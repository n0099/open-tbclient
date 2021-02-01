package com.baidu.tieba.card;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class i extends c<com.baidu.tieba.card.data.i> {
    private String fSu;
    private CustomMessageListener fSw;
    private CustomMessageListener fSx;
    private LikeModel fnw;
    private HListView iwg;
    private com.baidu.tieba.horizonalList.widget.b iwh;
    private CardExtendForumItemHolder iwi;
    private View iwj;
    private List<com.baidu.tieba.horizonalList.widget.c> iwk;
    private String iwl;
    private String iwm;
    private String iwn;
    private String iwo;
    private LayoutInflater mInflater;
    private View.OnClickListener onClickListener;
    private String stType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fSw = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.card.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    i.this.i(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.fSx = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.card.i.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    i.this.i(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.iwg = new HListView(getContext());
        this.iwg.setHeaderDividersEnabled(false);
        this.iwg.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.iwj = this.mInflater.inflate(R.layout.extend_forum_item, (ViewGroup) null);
        this.iwi = new CardExtendForumItemHolder(this.iwj);
        this.iuC.addView(this.iwg);
        this.iwg.setSelector(R.drawable.list_selector_transparent);
        this.iwg.setPadding(tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds4), 0);
        crX();
        if (this.iwh == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.iwh = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.extend_forum_item, this.iwi);
            this.iwh.setOnClickListener(this.onClickListener);
            this.iwg.setAdapter((ListAdapter) this.iwh);
        }
        this.iuu.setOnClickListener(this);
        this.fnw = new LikeModel(tbPageContext);
        this.fnw.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.card.i.1
            @Override // com.baidu.adp.base.e
            public void callback(Object obj) {
                if (!(obj instanceof com.baidu.tieba.tbadkCore.w) || i.this.fnw.getErrorCode() != 0) {
                    if (AntiHelper.bX(i.this.fnw.getErrorCode(), i.this.fnw.getErrorString())) {
                        AntiHelper.br(i.this.getContext(), i.this.fnw.getErrorString());
                    } else {
                        i.this.getTbPageContext().showToast(i.this.fnw.getErrorString());
                    }
                }
            }
        });
        this.iwg.setOnItemClickListener(null);
    }

    public void l(BdUniqueId bdUniqueId) {
        if (this.fSw != null && this.fSx != null) {
            this.fSw.setTag(bdUniqueId);
            this.fSx.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fSw);
            MessageManager.getInstance().registerListener(this.fSx);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.iwg != null && this.iwh != null) {
            this.iwh.onSkinTypeChanged(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.c
    public void a(com.baidu.tieba.card.data.i iVar) {
        super.a((i) iVar);
        if (iVar == null || com.baidu.tbadk.core.util.y.getCount(iVar.getDataList()) <= 0) {
            getView().setVisibility(8);
            return;
        }
        int count = com.baidu.tbadk.core.util.y.getCount(iVar.getDataList());
        if (count > 10) {
            ArrayList arrayList = new ArrayList(iVar.getDataList());
            iVar.getDataList().clear();
            iVar.getDataList().addAll(arrayList.subList(0, 10));
        }
        this.iwo = iVar.csT();
        this.stType = iVar.getStType();
        if (!t(iVar.getDataList(), this.iwk)) {
            boolean z = com.baidu.tbadk.core.util.y.getCount(iVar.getDataList()) != com.baidu.tbadk.core.util.y.getCount(this.iwk);
            this.iwk = iVar.getDataList();
            if (count <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.iwh != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.iwk.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.iwh = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.extend_forum_item, this.iwi);
                    this.iwh.setData(this.iwk);
                    this.iwh.setOnClickListener(this.onClickListener);
                    this.iwg.setAdapter((ListAdapter) this.iwh);
                    onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.iwh.setData(this.iwk);
                this.iwh.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.data.g IL(String str) {
        if (com.baidu.tbadk.core.util.y.getCount(this.iwk) > 0) {
            for (com.baidu.tieba.horizonalList.widget.c cVar : this.iwk) {
                if (cVar != null && (cVar instanceof com.baidu.tieba.card.data.g)) {
                    com.baidu.tieba.card.data.g gVar = (com.baidu.tieba.card.data.g) cVar;
                    if (String.valueOf(gVar.forumId).equals(str)) {
                        return gVar;
                    }
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(long j, boolean z) {
        com.baidu.tieba.card.data.g IL = IL(String.valueOf(j));
        if (IL != null) {
            IL.isLiked = z;
        }
        if (this.iwh != null) {
            this.iwh.setData(this.iwk);
            this.iwh.notifyDataSetChanged();
        }
    }

    private boolean t(List<com.baidu.tieba.horizonalList.widget.c> list, List<com.baidu.tieba.horizonalList.widget.c> list2) {
        boolean z;
        if (com.baidu.tbadk.core.util.y.getCount(list) <= 0 || com.baidu.tbadk.core.util.y.getCount(list2) <= 0 || com.baidu.tbadk.core.util.y.getCount(list) != com.baidu.tbadk.core.util.y.getCount(list2)) {
            return false;
        }
        int i = 0;
        boolean z2 = true;
        while (i < com.baidu.tbadk.core.util.y.getCount(list)) {
            com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.y.getItem(list, i);
            com.baidu.tieba.horizonalList.widget.c cVar2 = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.y.getItem(list2, i);
            if (cVar == null || !(cVar instanceof com.baidu.tieba.card.data.g) || cVar2 == null || !(cVar2 instanceof com.baidu.tieba.card.data.g)) {
                z = false;
            } else {
                com.baidu.tieba.card.data.g gVar = (com.baidu.tieba.card.data.g) cVar;
                com.baidu.tieba.card.data.g gVar2 = (com.baidu.tieba.card.data.g) cVar2;
                if (gVar.forumId != gVar2.forumId) {
                    z2 = false;
                }
                if (!gVar.forumAvatar.equals(gVar2.forumAvatar)) {
                    z2 = false;
                }
                if (!gVar.forumName.equals(gVar2.forumName)) {
                    z2 = false;
                }
                z = z2;
            }
            i++;
            z2 = z;
        }
        return z2;
    }

    private void crX() {
        this.onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.getId() == R.id.forum_add_love) {
                        if (bh.checkUpIsLogin(i.this.getView().getContext())) {
                            String str = (String) view.getTag(R.id.tag_forum_name);
                            String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                            if (au.isForumName(str)) {
                                i.this.fnw.gw(str, valueOf);
                                TiebaStatic.log(new ar(i.this.fSu).dR("fid", valueOf).dR(TiebaInitialize.Params.OBJ_PARAM3, m.csk()));
                            }
                        }
                    } else if (view.getTag(R.id.tag_forum_name) != null) {
                        String str2 = (String) view.getTag(R.id.tag_forum_name);
                        String valueOf2 = String.valueOf(view.getTag(R.id.tag_forum_id));
                        if (au.isForumName(str2)) {
                            if (view.getId() == R.id.m_forum_name_textview) {
                                TiebaStatic.log(new ar(i.this.iwn).dR("fid", valueOf2).dR(TiebaInitialize.Params.OBJ_PARAM3, m.csk()));
                            } else {
                                TiebaStatic.log(new ar(i.this.iwm).dR("fid", valueOf2).dR(TiebaInitialize.Params.OBJ_PARAM3, m.csk()));
                            }
                            if (!StringUtils.isNull(i.this.stType) && !StringUtils.isNull(i.this.iwo)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(i.this.getView().getContext()).createCfgForpersonalized(str2, i.this.stType, i.this.iwo)));
                            } else {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(i.this.getView().getContext()).createNormalCfg(str2, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                            }
                        }
                    }
                }
            }
        };
    }

    public void B(String str, String str2, String str3, String str4) {
        this.iwl = str;
        this.fSu = str2;
        this.iwm = str3;
        this.iwn = str4;
    }
}

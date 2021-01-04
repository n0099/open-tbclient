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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class i extends c<com.baidu.tieba.card.data.i> {
    private String fUO;
    private CustomMessageListener fUQ;
    private CustomMessageListener fUR;
    private LikeModel fpO;
    private HListView ivj;
    private com.baidu.tieba.horizonalList.widget.b ivk;
    private CardExtendForumItemHolder ivl;
    private View ivm;
    private List<com.baidu.tieba.horizonalList.widget.c> ivn;
    private String ivo;
    private String ivp;
    private String ivq;
    private String ivr;
    private LayoutInflater mInflater;
    private View.OnClickListener onClickListener;
    private String stType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fUQ = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.card.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    i.this.h(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.fUR = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.card.i.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    i.this.h(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.ivj = new HListView(getContext());
        this.ivj.setHeaderDividersEnabled(false);
        this.ivj.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.ivm = this.mInflater.inflate(R.layout.extend_forum_item, (ViewGroup) null);
        this.ivl = new CardExtendForumItemHolder(this.ivm);
        this.itF.addView(this.ivj);
        this.ivj.setSelector(R.drawable.list_selector_transparent);
        this.ivj.setPadding(tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds4), 0);
        cuE();
        if (this.ivk == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.ivk = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.extend_forum_item, this.ivl);
            this.ivk.setOnClickListener(this.onClickListener);
            this.ivj.setAdapter((ListAdapter) this.ivk);
        }
        this.itx.setOnClickListener(this);
        this.fpO = new LikeModel(tbPageContext);
        this.fpO.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.card.i.1
            @Override // com.baidu.adp.base.e
            public void callback(Object obj) {
                if (!(obj instanceof com.baidu.tieba.tbadkCore.w) || i.this.fpO.getErrorCode() != 0) {
                    if (AntiHelper.bP(i.this.fpO.getErrorCode(), i.this.fpO.getErrorString())) {
                        AntiHelper.bs(i.this.getContext(), i.this.fpO.getErrorString());
                    } else {
                        i.this.getTbPageContext().showToast(i.this.fpO.getErrorString());
                    }
                }
            }
        });
        this.ivj.setOnItemClickListener(null);
    }

    public void l(BdUniqueId bdUniqueId) {
        if (this.fUQ != null && this.fUR != null) {
            this.fUQ.setTag(bdUniqueId);
            this.fUR.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fUQ);
            MessageManager.getInstance().registerListener(this.fUR);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.ivj != null && this.ivk != null) {
            this.ivk.onSkinTypeChanged(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.c
    public void a(com.baidu.tieba.card.data.i iVar) {
        super.a((i) iVar);
        if (iVar == null || com.baidu.tbadk.core.util.x.getCount(iVar.getDataList()) <= 0) {
            getView().setVisibility(8);
            return;
        }
        int count = com.baidu.tbadk.core.util.x.getCount(iVar.getDataList());
        if (count > 10) {
            ArrayList arrayList = new ArrayList(iVar.getDataList());
            iVar.getDataList().clear();
            iVar.getDataList().addAll(arrayList.subList(0, 10));
        }
        this.ivr = iVar.cvy();
        this.stType = iVar.getStType();
        if (!u(iVar.getDataList(), this.ivn)) {
            boolean z = com.baidu.tbadk.core.util.x.getCount(iVar.getDataList()) != com.baidu.tbadk.core.util.x.getCount(this.ivn);
            this.ivn = iVar.getDataList();
            if (count <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.ivk != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.ivn.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.ivk = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.extend_forum_item, this.ivl);
                    this.ivk.setData(this.ivn);
                    this.ivk.setOnClickListener(this.onClickListener);
                    this.ivj.setAdapter((ListAdapter) this.ivk);
                    onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.ivk.setData(this.ivn);
                this.ivk.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.data.g Jn(String str) {
        if (com.baidu.tbadk.core.util.x.getCount(this.ivn) > 0) {
            for (com.baidu.tieba.horizonalList.widget.c cVar : this.ivn) {
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
    public void h(long j, boolean z) {
        com.baidu.tieba.card.data.g Jn = Jn(String.valueOf(j));
        if (Jn != null) {
            Jn.isLiked = z;
        }
        if (this.ivk != null) {
            this.ivk.setData(this.ivn);
            this.ivk.notifyDataSetChanged();
        }
    }

    private boolean u(List<com.baidu.tieba.horizonalList.widget.c> list, List<com.baidu.tieba.horizonalList.widget.c> list2) {
        boolean z;
        if (com.baidu.tbadk.core.util.x.getCount(list) <= 0 || com.baidu.tbadk.core.util.x.getCount(list2) <= 0 || com.baidu.tbadk.core.util.x.getCount(list) != com.baidu.tbadk.core.util.x.getCount(list2)) {
            return false;
        }
        int i = 0;
        boolean z2 = true;
        while (i < com.baidu.tbadk.core.util.x.getCount(list)) {
            com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.x.getItem(list, i);
            com.baidu.tieba.horizonalList.widget.c cVar2 = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.x.getItem(list2, i);
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

    private void cuE() {
        this.onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.getId() == R.id.forum_add_love) {
                        if (bg.checkUpIsLogin(i.this.getView().getContext())) {
                            String str = (String) view.getTag(R.id.tag_forum_name);
                            String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                            if (at.isForumName(str)) {
                                i.this.fpO.gr(str, valueOf);
                                TiebaStatic.log(new aq(i.this.fUO).dX("fid", valueOf).dX(TiebaInitialize.Params.OBJ_PARAM3, m.cuR()));
                            }
                        }
                    } else if (view.getTag(R.id.tag_forum_name) != null) {
                        String str2 = (String) view.getTag(R.id.tag_forum_name);
                        String valueOf2 = String.valueOf(view.getTag(R.id.tag_forum_id));
                        if (at.isForumName(str2)) {
                            if (view.getId() == R.id.m_forum_name_textview) {
                                TiebaStatic.log(new aq(i.this.ivq).dX("fid", valueOf2).dX(TiebaInitialize.Params.OBJ_PARAM3, m.cuR()));
                            } else {
                                TiebaStatic.log(new aq(i.this.ivp).dX("fid", valueOf2).dX(TiebaInitialize.Params.OBJ_PARAM3, m.cuR()));
                            }
                            if (!StringUtils.isNull(i.this.stType) && !StringUtils.isNull(i.this.ivr)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(i.this.getView().getContext()).createCfgForpersonalized(str2, i.this.stType, i.this.ivr)));
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
        this.ivo = str;
        this.fUO = str2;
        this.ivp = str3;
        this.ivq = str4;
    }
}

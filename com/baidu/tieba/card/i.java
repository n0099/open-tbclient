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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class i extends b<com.baidu.tieba.card.data.i> {
    private String dLb;
    private CustomMessageListener dLd;
    private CustomMessageListener dLe;
    private LikeModel dkh;
    private View.OnClickListener drw;
    private HListView fJh;
    private com.baidu.tieba.horizonalList.widget.b fJi;
    private c fJj;
    private View fJk;
    private List<com.baidu.tieba.horizonalList.widget.c> fJl;
    private String fJm;
    private String fJn;
    private String fJo;
    private String fJp;
    private LayoutInflater mInflater;
    private String stType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.dLd = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.card.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    i.this.d(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.dLe = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.card.i.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    i.this.d(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.fJh = new HListView(getContext());
        this.fJh.setHeaderDividersEnabled(false);
        this.fJh.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.fJk = this.mInflater.inflate(R.layout.extend_forum_item, (ViewGroup) null);
        this.fJj = new c(this.fJk);
        this.fHD.addView(this.fJh);
        this.fJh.setSelector(R.drawable.list_selector_transparent);
        this.fJh.setPadding(tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds4), 0);
        buJ();
        if (this.fJi == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.fJi = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.extend_forum_item, this.fJj);
            this.fJi.setOnClickListener(this.drw);
            this.fJh.setAdapter((ListAdapter) this.fJi);
        }
        this.fHv.setOnClickListener(this);
        this.dkh = new LikeModel(tbPageContext);
        this.dkh.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.i.1
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (!(obj instanceof com.baidu.tieba.tbadkCore.t) || i.this.dkh.getErrorCode() != 0) {
                    if (AntiHelper.bb(i.this.dkh.getErrorCode(), i.this.dkh.getErrorString())) {
                        AntiHelper.bn(i.this.getContext(), i.this.dkh.getErrorString());
                    } else {
                        i.this.getTbPageContext().showToast(i.this.dkh.getErrorString());
                    }
                }
            }
        });
        this.fJh.setOnItemClickListener(null);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (this.dLd != null && this.dLe != null) {
            this.dLd.setTag(bdUniqueId);
            this.dLe.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dLd);
            MessageManager.getInstance().registerListener(this.dLe);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.fJh != null && this.fJi != null) {
            this.fJi.onSkinTypeChanged(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.i iVar) {
        super.a((i) iVar);
        if (iVar == null || com.baidu.tbadk.core.util.v.getCount(iVar.getDataList()) <= 0) {
            getView().setVisibility(8);
            return;
        }
        int count = com.baidu.tbadk.core.util.v.getCount(iVar.getDataList());
        if (count > 10) {
            ArrayList arrayList = new ArrayList(iVar.getDataList());
            iVar.getDataList().clear();
            iVar.getDataList().addAll(arrayList.subList(0, 10));
        }
        this.fJp = iVar.bvz();
        this.stType = iVar.getStType();
        if (!j(iVar.getDataList(), this.fJl)) {
            boolean z = com.baidu.tbadk.core.util.v.getCount(iVar.getDataList()) != com.baidu.tbadk.core.util.v.getCount(this.fJl);
            this.fJl = iVar.getDataList();
            if (count <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.fJi != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.fJl.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.fJi = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.extend_forum_item, this.fJj);
                    this.fJi.setData(this.fJl);
                    this.fJi.setOnClickListener(this.drw);
                    this.fJh.setAdapter((ListAdapter) this.fJi);
                    onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.fJi.setData(this.fJl);
                this.fJi.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.data.g zS(String str) {
        if (com.baidu.tbadk.core.util.v.getCount(this.fJl) > 0) {
            for (com.baidu.tieba.horizonalList.widget.c cVar : this.fJl) {
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
    public void d(long j, boolean z) {
        com.baidu.tieba.card.data.g zS = zS(String.valueOf(j));
        if (zS != null) {
            zS.isLiked = z;
        }
        if (this.fJi != null) {
            this.fJi.setData(this.fJl);
            this.fJi.notifyDataSetChanged();
        }
    }

    private boolean j(List<com.baidu.tieba.horizonalList.widget.c> list, List<com.baidu.tieba.horizonalList.widget.c> list2) {
        boolean z;
        if (com.baidu.tbadk.core.util.v.getCount(list) <= 0 || com.baidu.tbadk.core.util.v.getCount(list2) <= 0 || com.baidu.tbadk.core.util.v.getCount(list) != com.baidu.tbadk.core.util.v.getCount(list2)) {
            return false;
        }
        int i = 0;
        boolean z2 = true;
        while (i < com.baidu.tbadk.core.util.v.getCount(list)) {
            com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.v.getItem(list, i);
            com.baidu.tieba.horizonalList.widget.c cVar2 = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.v.getItem(list2, i);
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

    private void buJ() {
        this.drw = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.getId() == R.id.forum_add_love) {
                        if (bc.checkUpIsLogin(i.this.getView().getContext())) {
                            String str = (String) view.getTag(R.id.tag_forum_name);
                            String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                            if (aq.isForumName(str)) {
                                i.this.dkh.eC(str, valueOf);
                                TiebaStatic.log(new an(i.this.dLb).cy("fid", valueOf).cy(TiebaInitialize.Params.OBJ_PARAM3, l.buY()));
                            }
                        }
                    } else if (view.getTag(R.id.tag_forum_name) != null) {
                        String str2 = (String) view.getTag(R.id.tag_forum_name);
                        String valueOf2 = String.valueOf(view.getTag(R.id.tag_forum_id));
                        if (aq.isForumName(str2)) {
                            if (view.getId() == R.id.m_forum_name_textview) {
                                TiebaStatic.log(new an(i.this.fJo).cy("fid", valueOf2).cy(TiebaInitialize.Params.OBJ_PARAM3, l.buY()));
                            } else {
                                TiebaStatic.log(new an(i.this.fJn).cy("fid", valueOf2).cy(TiebaInitialize.Params.OBJ_PARAM3, l.buY()));
                            }
                            if (!StringUtils.isNull(i.this.stType) && !StringUtils.isNull(i.this.fJp)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(i.this.getView().getContext()).createCfgForpersonalized(str2, i.this.stType, i.this.fJp)));
                            } else {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(i.this.getView().getContext()).createNormalCfg(str2, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                            }
                        }
                    }
                }
            }
        };
    }

    public void w(String str, String str2, String str3, String str4) {
        this.fJm = str;
        this.dLb = str2;
        this.fJn = str3;
        this.fJo = str4;
    }
}

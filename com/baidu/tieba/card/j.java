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
/* loaded from: classes20.dex */
public class j extends c<com.baidu.tieba.card.data.i> {
    private LikeModel eYI;
    private String fDw;
    private CustomMessageListener fDy;
    private CustomMessageListener fDz;
    private View.OnClickListener fhp;
    private HListView hXP;
    private com.baidu.tieba.horizonalList.widget.b hXQ;
    private d hXR;
    private View hXS;
    private List<com.baidu.tieba.horizonalList.widget.c> hXT;
    private String hXU;
    private String hXV;
    private String hXW;
    private String hXX;
    private LayoutInflater mInflater;
    private String stType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fDy = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.card.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    j.this.g(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.fDz = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.card.j.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    j.this.g(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.hXP = new HListView(getContext());
        this.hXP.setHeaderDividersEnabled(false);
        this.hXP.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.hXS = this.mInflater.inflate(R.layout.extend_forum_item, (ViewGroup) null);
        this.hXR = new d(this.hXS);
        this.hWl.addView(this.hXP);
        this.hXP.setSelector(R.drawable.list_selector_transparent);
        this.hXP.setPadding(tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds4), 0);
        cnx();
        if (this.hXQ == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.hXQ = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.extend_forum_item, this.hXR);
            this.hXQ.setOnClickListener(this.fhp);
            this.hXP.setAdapter((ListAdapter) this.hXQ);
        }
        this.hWd.setOnClickListener(this);
        this.eYI = new LikeModel(tbPageContext);
        this.eYI.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.j.1
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (!(obj instanceof com.baidu.tieba.tbadkCore.v) || j.this.eYI.getErrorCode() != 0) {
                    if (AntiHelper.bP(j.this.eYI.getErrorCode(), j.this.eYI.getErrorString())) {
                        AntiHelper.bj(j.this.getContext(), j.this.eYI.getErrorString());
                    } else {
                        j.this.getTbPageContext().showToast(j.this.eYI.getErrorString());
                    }
                }
            }
        });
        this.hXP.setOnItemClickListener(null);
    }

    public void l(BdUniqueId bdUniqueId) {
        if (this.fDy != null && this.fDz != null) {
            this.fDy.setTag(bdUniqueId);
            this.fDz.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fDy);
            MessageManager.getInstance().registerListener(this.fDz);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.hXP != null && this.hXQ != null) {
            this.hXQ.onSkinTypeChanged(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.c
    public void a(com.baidu.tieba.card.data.i iVar) {
        super.a((j) iVar);
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
        this.hXX = iVar.cor();
        this.stType = iVar.getStType();
        if (!t(iVar.getDataList(), this.hXT)) {
            boolean z = com.baidu.tbadk.core.util.y.getCount(iVar.getDataList()) != com.baidu.tbadk.core.util.y.getCount(this.hXT);
            this.hXT = iVar.getDataList();
            if (count <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.hXQ != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.hXT.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.hXQ = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.extend_forum_item, this.hXR);
                    this.hXQ.setData(this.hXT);
                    this.hXQ.setOnClickListener(this.fhp);
                    this.hXP.setAdapter((ListAdapter) this.hXQ);
                    onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.hXQ.setData(this.hXT);
                this.hXQ.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.data.g Iz(String str) {
        if (com.baidu.tbadk.core.util.y.getCount(this.hXT) > 0) {
            for (com.baidu.tieba.horizonalList.widget.c cVar : this.hXT) {
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
    public void g(long j, boolean z) {
        com.baidu.tieba.card.data.g Iz = Iz(String.valueOf(j));
        if (Iz != null) {
            Iz.isLiked = z;
        }
        if (this.hXQ != null) {
            this.hXQ.setData(this.hXT);
            this.hXQ.notifyDataSetChanged();
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

    private void cnx() {
        this.fhp = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.getId() == R.id.forum_add_love) {
                        if (bh.checkUpIsLogin(j.this.getView().getContext())) {
                            String str = (String) view.getTag(R.id.tag_forum_name);
                            String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                            if (au.isForumName(str)) {
                                j.this.eYI.gp(str, valueOf);
                                TiebaStatic.log(new ar(j.this.fDw).dR("fid", valueOf).dR(TiebaInitialize.Params.OBJ_PARAM3, n.cnK()));
                            }
                        }
                    } else if (view.getTag(R.id.tag_forum_name) != null) {
                        String str2 = (String) view.getTag(R.id.tag_forum_name);
                        String valueOf2 = String.valueOf(view.getTag(R.id.tag_forum_id));
                        if (au.isForumName(str2)) {
                            if (view.getId() == R.id.m_forum_name_textview) {
                                TiebaStatic.log(new ar(j.this.hXW).dR("fid", valueOf2).dR(TiebaInitialize.Params.OBJ_PARAM3, n.cnK()));
                            } else {
                                TiebaStatic.log(new ar(j.this.hXV).dR("fid", valueOf2).dR(TiebaInitialize.Params.OBJ_PARAM3, n.cnK()));
                            }
                            if (!StringUtils.isNull(j.this.stType) && !StringUtils.isNull(j.this.hXX)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(j.this.getView().getContext()).createCfgForpersonalized(str2, j.this.stType, j.this.hXX)));
                            } else {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(j.this.getView().getContext()).createNormalCfg(str2, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                            }
                        }
                    }
                }
            }
        };
    }

    public void C(String str, String str2, String str3, String str4) {
        this.hXU = str;
        this.fDw = str2;
        this.hXV = str3;
        this.hXW = str4;
    }
}

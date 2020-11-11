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
/* loaded from: classes21.dex */
public class j extends c<com.baidu.tieba.card.data.j> {
    private LikeModel eZA;
    private String fDT;
    private CustomMessageListener fDV;
    private CustomMessageListener fDW;
    private View.OnClickListener fii;
    private HListView hXp;
    private com.baidu.tieba.horizonalList.widget.b hXq;
    private d hXr;
    private View hXs;
    private List<com.baidu.tieba.horizonalList.widget.c> hXt;
    private String hXu;
    private String hXv;
    private String hXw;
    private String hXx;
    private LayoutInflater mInflater;
    private String stType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fDV = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.card.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    j.this.g(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.fDW = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.card.j.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    j.this.g(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.hXp = new HListView(getContext());
        this.hXp.setHeaderDividersEnabled(false);
        this.hXp.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.hXs = this.mInflater.inflate(R.layout.extend_forum_item, (ViewGroup) null);
        this.hXr = new d(this.hXs);
        this.hVL.addView(this.hXp);
        this.hXp.setSelector(R.drawable.list_selector_transparent);
        this.hXp.setPadding(tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds4), 0);
        cnV();
        if (this.hXq == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.hXq = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.extend_forum_item, this.hXr);
            this.hXq.setOnClickListener(this.fii);
            this.hXp.setAdapter((ListAdapter) this.hXq);
        }
        this.hVD.setOnClickListener(this);
        this.eZA = new LikeModel(tbPageContext);
        this.eZA.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.j.1
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (!(obj instanceof com.baidu.tieba.tbadkCore.v) || j.this.eZA.getErrorCode() != 0) {
                    if (AntiHelper.bR(j.this.eZA.getErrorCode(), j.this.eZA.getErrorString())) {
                        AntiHelper.bm(j.this.getContext(), j.this.eZA.getErrorString());
                    } else {
                        j.this.getTbPageContext().showToast(j.this.eZA.getErrorString());
                    }
                }
            }
        });
        this.hXp.setOnItemClickListener(null);
    }

    public void l(BdUniqueId bdUniqueId) {
        if (this.fDV != null && this.fDW != null) {
            this.fDV.setTag(bdUniqueId);
            this.fDW.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fDV);
            MessageManager.getInstance().registerListener(this.fDW);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.hXp != null && this.hXq != null) {
            this.hXq.onSkinTypeChanged(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.j jVar) {
        super.a((j) jVar);
        if (jVar == null || com.baidu.tbadk.core.util.y.getCount(jVar.getDataList()) <= 0) {
            getView().setVisibility(8);
            return;
        }
        int count = com.baidu.tbadk.core.util.y.getCount(jVar.getDataList());
        if (count > 10) {
            ArrayList arrayList = new ArrayList(jVar.getDataList());
            jVar.getDataList().clear();
            jVar.getDataList().addAll(arrayList.subList(0, 10));
        }
        this.hXx = jVar.coM();
        this.stType = jVar.getStType();
        if (!t(jVar.getDataList(), this.hXt)) {
            boolean z = com.baidu.tbadk.core.util.y.getCount(jVar.getDataList()) != com.baidu.tbadk.core.util.y.getCount(this.hXt);
            this.hXt = jVar.getDataList();
            if (count <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.hXq != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.hXt.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.hXq = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.extend_forum_item, this.hXr);
                    this.hXq.setData(this.hXt);
                    this.hXq.setOnClickListener(this.fii);
                    this.hXp.setAdapter((ListAdapter) this.hXq);
                    onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.hXq.setData(this.hXt);
                this.hXq.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.data.h IY(String str) {
        if (com.baidu.tbadk.core.util.y.getCount(this.hXt) > 0) {
            for (com.baidu.tieba.horizonalList.widget.c cVar : this.hXt) {
                if (cVar != null && (cVar instanceof com.baidu.tieba.card.data.h)) {
                    com.baidu.tieba.card.data.h hVar = (com.baidu.tieba.card.data.h) cVar;
                    if (String.valueOf(hVar.forumId).equals(str)) {
                        return hVar;
                    }
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(long j, boolean z) {
        com.baidu.tieba.card.data.h IY = IY(String.valueOf(j));
        if (IY != null) {
            IY.isLiked = z;
        }
        if (this.hXq != null) {
            this.hXq.setData(this.hXt);
            this.hXq.notifyDataSetChanged();
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
            if (cVar == null || !(cVar instanceof com.baidu.tieba.card.data.h) || cVar2 == null || !(cVar2 instanceof com.baidu.tieba.card.data.h)) {
                z = false;
            } else {
                com.baidu.tieba.card.data.h hVar = (com.baidu.tieba.card.data.h) cVar;
                com.baidu.tieba.card.data.h hVar2 = (com.baidu.tieba.card.data.h) cVar2;
                if (hVar.forumId != hVar2.forumId) {
                    z2 = false;
                }
                if (!hVar.forumAvatar.equals(hVar2.forumAvatar)) {
                    z2 = false;
                }
                if (!hVar.forumName.equals(hVar2.forumName)) {
                    z2 = false;
                }
                z = z2;
            }
            i++;
            z2 = z;
        }
        return z2;
    }

    private void cnV() {
        this.fii = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.getId() == R.id.forum_add_love) {
                        if (bg.checkUpIsLogin(j.this.getView().getContext())) {
                            String str = (String) view.getTag(R.id.tag_forum_name);
                            String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                            if (at.isForumName(str)) {
                                j.this.eZA.gp(str, valueOf);
                                TiebaStatic.log(new aq(j.this.fDT).dR("fid", valueOf).dR(TiebaInitialize.Params.OBJ_PARAM3, n.coi()));
                            }
                        }
                    } else if (view.getTag(R.id.tag_forum_name) != null) {
                        String str2 = (String) view.getTag(R.id.tag_forum_name);
                        String valueOf2 = String.valueOf(view.getTag(R.id.tag_forum_id));
                        if (at.isForumName(str2)) {
                            if (view.getId() == R.id.m_forum_name_textview) {
                                TiebaStatic.log(new aq(j.this.hXw).dR("fid", valueOf2).dR(TiebaInitialize.Params.OBJ_PARAM3, n.coi()));
                            } else {
                                TiebaStatic.log(new aq(j.this.hXv).dR("fid", valueOf2).dR(TiebaInitialize.Params.OBJ_PARAM3, n.coi()));
                            }
                            if (!StringUtils.isNull(j.this.stType) && !StringUtils.isNull(j.this.hXx)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(j.this.getView().getContext()).createCfgForpersonalized(str2, j.this.stType, j.this.hXx)));
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
        this.hXu = str;
        this.fDT = str2;
        this.hXv = str3;
        this.hXw = str4;
    }
}

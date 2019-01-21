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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.e;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class j extends b<com.baidu.tieba.card.data.g> {
    private LikeModel aLQ;
    private View.OnClickListener aTJ;
    private String bnS;
    private CustomMessageListener bnU;
    private CustomMessageListener bnV;
    private com.baidu.tieba.horizonalList.widget.b cXA;
    private d cXB;
    private View cXC;
    private List<com.baidu.tieba.horizonalList.widget.c> cXD;
    private String cXE;
    private String cXF;
    private String cXG;
    private String cXH;
    private HListView cXz;
    private LayoutInflater mInflater;
    private String stType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bnU = new CustomMessageListener(2001336) { // from class: com.baidu.tieba.card.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    j.this.c(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.bnV = new CustomMessageListener(2001335) { // from class: com.baidu.tieba.card.j.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    j.this.c(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.cXz = new HListView(getContext());
        this.cXz.setHeaderDividersEnabled(false);
        this.cXz.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.cXC = this.mInflater.inflate(e.h.extend_forum_item, (ViewGroup) null);
        this.cXB = new d(this.cXC);
        this.cVP.addView(this.cXz);
        this.cXz.setSelector(e.f.list_selector_transparent);
        this.cXz.setPadding(tbPageContext.getResources().getDimensionPixelSize(e.C0210e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(e.C0210e.ds4), 0);
        aqv();
        if (this.cXA == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.cXA = new com.baidu.tieba.horizonalList.widget.b(getContext(), e.h.extend_forum_item, this.cXB);
            this.cXA.setOnClickListener(this.aTJ);
            this.cXz.setAdapter((ListAdapter) this.cXA);
        }
        this.cVH.setOnClickListener(this);
        this.aLQ = new LikeModel(tbPageContext);
        this.aLQ.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.j.1
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (!(obj instanceof com.baidu.tieba.tbadkCore.r) || j.this.aLQ.getErrorCode() != 0) {
                    if (AntiHelper.al(j.this.aLQ.getErrorCode(), j.this.aLQ.getErrorString())) {
                        AntiHelper.aH(j.this.getContext(), j.this.aLQ.getErrorString());
                    } else {
                        j.this.getTbPageContext().showToast(j.this.aLQ.getErrorString());
                    }
                }
            }
        });
        this.cXz.setOnItemClickListener(null);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (this.bnU != null && this.bnV != null) {
            this.bnU.setTag(bdUniqueId);
            this.bnV.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bnU);
            MessageManager.getInstance().registerListener(this.bnV);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.cXz != null && this.cXA != null) {
            this.cXA.ej(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.g gVar) {
        super.a((j) gVar);
        if (gVar == null || com.baidu.tbadk.core.util.v.H(gVar.getDataList()) <= 0) {
            getView().setVisibility(8);
            return;
        }
        int H = com.baidu.tbadk.core.util.v.H(gVar.getDataList());
        if (H > 10) {
            ArrayList arrayList = new ArrayList(gVar.getDataList());
            gVar.getDataList().clear();
            gVar.getDataList().addAll(arrayList.subList(0, 10));
        }
        this.cXH = gVar.ari();
        this.stType = gVar.getStType();
        if (!h(gVar.getDataList(), this.cXD)) {
            boolean z = com.baidu.tbadk.core.util.v.H(gVar.getDataList()) != com.baidu.tbadk.core.util.v.H(this.cXD);
            this.cXD = gVar.getDataList();
            if (H <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.cXA != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.cXD.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.cXA = new com.baidu.tieba.horizonalList.widget.b(getContext(), e.h.extend_forum_item, this.cXB);
                    this.cXA.setData(this.cXD);
                    this.cXA.setOnClickListener(this.aTJ);
                    this.cXz.setAdapter((ListAdapter) this.cXA);
                    d(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.cXA.setData(this.cXD);
                this.cXA.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.data.e mV(String str) {
        if (com.baidu.tbadk.core.util.v.H(this.cXD) > 0) {
            for (com.baidu.tieba.horizonalList.widget.c cVar : this.cXD) {
                if (cVar != null && (cVar instanceof com.baidu.tieba.card.data.e)) {
                    com.baidu.tieba.card.data.e eVar = (com.baidu.tieba.card.data.e) cVar;
                    if (String.valueOf(eVar.forumId).equals(str)) {
                        return eVar;
                    }
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j, boolean z) {
        com.baidu.tieba.card.data.e mV = mV(String.valueOf(j));
        if (mV != null) {
            mV.isLiked = z;
        }
        if (this.cXA != null) {
            this.cXA.setData(this.cXD);
            this.cXA.notifyDataSetChanged();
        }
    }

    private boolean h(List<com.baidu.tieba.horizonalList.widget.c> list, List<com.baidu.tieba.horizonalList.widget.c> list2) {
        boolean z;
        if (com.baidu.tbadk.core.util.v.H(list) <= 0 || com.baidu.tbadk.core.util.v.H(list2) <= 0 || com.baidu.tbadk.core.util.v.H(list) != com.baidu.tbadk.core.util.v.H(list2)) {
            return false;
        }
        int i = 0;
        boolean z2 = true;
        while (i < com.baidu.tbadk.core.util.v.H(list)) {
            com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.v.d(list, i);
            com.baidu.tieba.horizonalList.widget.c cVar2 = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.v.d(list2, i);
            if (cVar == null || !(cVar instanceof com.baidu.tieba.card.data.e) || cVar2 == null || !(cVar2 instanceof com.baidu.tieba.card.data.e)) {
                z = false;
            } else {
                com.baidu.tieba.card.data.e eVar = (com.baidu.tieba.card.data.e) cVar;
                com.baidu.tieba.card.data.e eVar2 = (com.baidu.tieba.card.data.e) cVar2;
                if (eVar.forumId != eVar2.forumId) {
                    z2 = false;
                }
                if (!eVar.forumAvatar.equals(eVar2.forumAvatar)) {
                    z2 = false;
                }
                if (!eVar.forumName.equals(eVar2.forumName)) {
                    z2 = false;
                }
                z = z2;
            }
            i++;
            z2 = z;
        }
        return z2;
    }

    private void aqv() {
        this.aTJ = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.getId() == e.g.forum_add_love) {
                        if (ba.bJ(j.this.getView().getContext())) {
                            String str = (String) view.getTag(e.g.tag_forum_name);
                            String valueOf = String.valueOf(view.getTag(e.g.tag_forum_id));
                            if (ao.bv(str)) {
                                j.this.aLQ.cM(str, valueOf);
                                TiebaStatic.log(new am(j.this.bnS).aB(ImageViewerConfig.FORUM_ID, valueOf).aB("obj_param3", o.aqG()));
                            }
                        }
                    } else if (view.getTag(e.g.tag_forum_name) != null) {
                        String str2 = (String) view.getTag(e.g.tag_forum_name);
                        String valueOf2 = String.valueOf(view.getTag(e.g.tag_forum_id));
                        if (ao.bv(str2)) {
                            if (view.getId() == e.g.m_forum_name_textview) {
                                TiebaStatic.log(new am(j.this.cXG).aB(ImageViewerConfig.FORUM_ID, valueOf2).aB("obj_param3", o.aqG()));
                            } else {
                                TiebaStatic.log(new am(j.this.cXF).aB(ImageViewerConfig.FORUM_ID, valueOf2).aB("obj_param3", o.aqG()));
                            }
                            if (!StringUtils.isNull(j.this.stType) && !StringUtils.isNull(j.this.cXH)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(j.this.getView().getContext()).createCfgForpersonalized(str2, j.this.stType, j.this.cXH)));
                            } else {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(j.this.getView().getContext()).createNormalCfg(str2, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                            }
                        }
                    }
                }
            }
        };
    }

    public void k(String str, String str2, String str3, String str4) {
        this.cXE = str;
        this.bnS = str2;
        this.cXF = str3;
        this.cXG = str4;
    }
}

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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e extends b<com.baidu.tieba.card.data.g> {
    private View.OnClickListener bmd;
    private HListView cVP;
    private com.baidu.tieba.horizonalList.widget.c cVQ;
    private d cVR;
    private View cVS;
    private List<com.baidu.tieba.horizonalList.widget.d> cVT;
    private String cVU;
    private String cVV;
    private String cVW;
    private String cVX;
    private String cVY;
    private CustomMessageListener cVZ;
    private CustomMessageListener cWa;
    private LikeModel cdg;
    private LayoutInflater mInflater;
    private String stType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cVZ = new CustomMessageListener(2001336) { // from class: com.baidu.tieba.card.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    e.this.b(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.cWa = new CustomMessageListener(2001335) { // from class: com.baidu.tieba.card.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    e.this.b(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.cVP = new HListView(getContext());
        this.cVP.setHeaderDividersEnabled(false);
        this.cVP.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.cVS = this.mInflater.inflate(d.h.extend_forum_item, (ViewGroup) null);
        this.cVR = new d(this.cVS);
        this.cVD.addView(this.cVP);
        this.cVP.setSelector(d.f.list_selector_transparent);
        this.cVP.setPadding(tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0);
        akV();
        if (this.cVQ == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.cVQ = new com.baidu.tieba.horizonalList.widget.c(getContext(), d.h.extend_forum_item, this.cVR);
            this.cVQ.setOnClickListener(this.bmd);
            this.cVP.setAdapter((ListAdapter) this.cVQ);
        }
        this.cVv.setOnClickListener(this);
        this.cdg = new LikeModel(tbPageContext);
        this.cdg.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.e.1
            @Override // com.baidu.adp.base.d
            public void ak(Object obj) {
                if (!(obj instanceof com.baidu.tieba.tbadkCore.r) || e.this.cdg.getErrorCode() != 0) {
                    if (AntiHelper.vQ(e.this.cdg.getErrorCode())) {
                        AntiHelper.ar(e.this.getContext(), e.this.cdg.getErrorString());
                    } else {
                        e.this.akO().showToast(e.this.cdg.getErrorString());
                    }
                }
            }
        });
        this.cVP.setOnItemClickListener(null);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (this.cVZ != null && this.cWa != null) {
            this.cVZ.setTag(bdUniqueId);
            this.cWa.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cVZ);
            MessageManager.getInstance().registerListener(this.cWa);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.cVP != null && this.cVQ != null) {
            this.cVQ.gi(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.g gVar) {
        super.a((e) gVar);
        if (gVar == null || com.baidu.tbadk.core.util.v.D(gVar.getDataList()) <= 0) {
            getView().setVisibility(8);
            return;
        }
        int D = com.baidu.tbadk.core.util.v.D(gVar.getDataList());
        if (D > 10) {
            ArrayList arrayList = new ArrayList(gVar.getDataList());
            gVar.getDataList().clear();
            gVar.getDataList().addAll(arrayList.subList(0, 10));
        }
        this.cVY = gVar.alI();
        this.stType = gVar.getStType();
        if (!g(gVar.getDataList(), this.cVT)) {
            boolean z = com.baidu.tbadk.core.util.v.D(gVar.getDataList()) != com.baidu.tbadk.core.util.v.D(this.cVT);
            this.cVT = gVar.getDataList();
            if (D <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.cVQ != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.cVT.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.cVQ = new com.baidu.tieba.horizonalList.widget.c(getContext(), d.h.extend_forum_item, this.cVR);
                    this.cVQ.setData(this.cVT);
                    this.cVQ.setOnClickListener(this.bmd);
                    this.cVP.setAdapter((ListAdapter) this.cVQ);
                    d(akO(), TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.cVQ.setData(this.cVT);
                this.cVQ.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.data.e kq(String str) {
        if (com.baidu.tbadk.core.util.v.D(this.cVT) > 0) {
            for (com.baidu.tieba.horizonalList.widget.d dVar : this.cVT) {
                if (dVar != null && (dVar instanceof com.baidu.tieba.card.data.e)) {
                    com.baidu.tieba.card.data.e eVar = (com.baidu.tieba.card.data.e) dVar;
                    if (String.valueOf(eVar.forumId).equals(str)) {
                        return eVar;
                    }
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, boolean z) {
        com.baidu.tieba.card.data.e kq = kq(String.valueOf(j));
        if (kq != null) {
            kq.isLiked = z;
        }
        if (this.cVQ != null) {
            this.cVQ.setData(this.cVT);
            this.cVQ.notifyDataSetChanged();
        }
    }

    private boolean g(List<com.baidu.tieba.horizonalList.widget.d> list, List<com.baidu.tieba.horizonalList.widget.d> list2) {
        boolean z;
        if (com.baidu.tbadk.core.util.v.D(list) <= 0 || com.baidu.tbadk.core.util.v.D(list2) <= 0 || com.baidu.tbadk.core.util.v.D(list) != com.baidu.tbadk.core.util.v.D(list2)) {
            return false;
        }
        int i = 0;
        boolean z2 = true;
        while (i < com.baidu.tbadk.core.util.v.D(list)) {
            com.baidu.tieba.horizonalList.widget.d dVar = (com.baidu.tieba.horizonalList.widget.d) com.baidu.tbadk.core.util.v.f(list, i);
            com.baidu.tieba.horizonalList.widget.d dVar2 = (com.baidu.tieba.horizonalList.widget.d) com.baidu.tbadk.core.util.v.f(list2, i);
            if (dVar == null || !(dVar instanceof com.baidu.tieba.card.data.e) || dVar2 == null || !(dVar2 instanceof com.baidu.tieba.card.data.e)) {
                z = false;
            } else {
                com.baidu.tieba.card.data.e eVar = (com.baidu.tieba.card.data.e) dVar;
                com.baidu.tieba.card.data.e eVar2 = (com.baidu.tieba.card.data.e) dVar2;
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

    private void akV() {
        this.bmd = new View.OnClickListener() { // from class: com.baidu.tieba.card.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.getId() == d.g.forum_add_love) {
                        if (ay.ba(e.this.getView().getContext())) {
                            String str = (String) view.getTag(d.g.tag_forum_name);
                            String valueOf = String.valueOf(view.getTag(d.g.tag_forum_id));
                            if (am.aT(str)) {
                                e.this.cdg.cc(str, valueOf);
                                TiebaStatic.log(new ak(e.this.cVV).ab(ImageViewerConfig.FORUM_ID, valueOf).ab("obj_param3", j.alg()));
                            }
                        }
                    } else if (view.getTag(d.g.tag_forum_name) != null) {
                        String str2 = (String) view.getTag(d.g.tag_forum_name);
                        String valueOf2 = String.valueOf(view.getTag(d.g.tag_forum_id));
                        if (am.aT(str2)) {
                            if (view.getId() == d.g.m_forum_name_textview) {
                                TiebaStatic.log(new ak(e.this.cVX).ab(ImageViewerConfig.FORUM_ID, valueOf2).ab("obj_param3", j.alg()));
                            } else {
                                TiebaStatic.log(new ak(e.this.cVW).ab(ImageViewerConfig.FORUM_ID, valueOf2).ab("obj_param3", j.alg()));
                            }
                            if (!StringUtils.isNull(e.this.stType) && !StringUtils.isNull(e.this.cVY)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(e.this.getView().getContext()).createCfgForpersonalized(str2, e.this.stType, e.this.cVY)));
                            } else {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(e.this.getView().getContext()).createNormalCfg(str2, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                            }
                        }
                    }
                }
            }
        };
    }

    public void k(String str, String str2, String str3, String str4) {
        this.cVU = str;
        this.cVV = str2;
        this.cVW = str3;
        this.cVX = str4;
    }
}

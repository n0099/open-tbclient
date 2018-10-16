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
    private LikeModel aGV;
    private View.OnClickListener aOJ;
    private String biR;
    private CustomMessageListener biT;
    private CustomMessageListener biU;
    private HListView cMk;
    private com.baidu.tieba.horizonalList.widget.b cMl;
    private d cMm;
    private View cMn;
    private List<com.baidu.tieba.horizonalList.widget.c> cMo;
    private String cMp;
    private String cMq;
    private String cMr;
    private String cMs;
    private LayoutInflater mInflater;
    private String stType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.biT = new CustomMessageListener(2001336) { // from class: com.baidu.tieba.card.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    j.this.a(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.biU = new CustomMessageListener(2001335) { // from class: com.baidu.tieba.card.j.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    j.this.a(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.cMk = new HListView(getContext());
        this.cMk.setHeaderDividersEnabled(false);
        this.cMk.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.cMn = this.mInflater.inflate(e.h.extend_forum_item, (ViewGroup) null);
        this.cMm = new d(this.cMn);
        this.cKA.addView(this.cMk);
        this.cMk.setSelector(e.f.list_selector_transparent);
        this.cMk.setPadding(tbPageContext.getResources().getDimensionPixelSize(e.C0175e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(e.C0175e.ds4), 0);
        anU();
        if (this.cMl == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.cMl = new com.baidu.tieba.horizonalList.widget.b(getContext(), e.h.extend_forum_item, this.cMm);
            this.cMl.setOnClickListener(this.aOJ);
            this.cMk.setAdapter((ListAdapter) this.cMl);
        }
        this.cKs.setOnClickListener(this);
        this.aGV = new LikeModel(tbPageContext);
        this.aGV.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.j.1
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (!(obj instanceof com.baidu.tieba.tbadkCore.r) || j.this.aGV.getErrorCode() != 0) {
                    if (AntiHelper.am(j.this.aGV.getErrorCode(), j.this.aGV.getErrorString())) {
                        AntiHelper.aI(j.this.getContext(), j.this.aGV.getErrorString());
                    } else {
                        j.this.getTbPageContext().showToast(j.this.aGV.getErrorString());
                    }
                }
            }
        });
        this.cMk.setOnItemClickListener(null);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (this.biT != null && this.biU != null) {
            this.biT.setTag(bdUniqueId);
            this.biU.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.biT);
            MessageManager.getInstance().registerListener(this.biU);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.cMk != null && this.cMl != null) {
            this.cMl.dH(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.g gVar) {
        super.a((j) gVar);
        if (gVar == null || com.baidu.tbadk.core.util.v.I(gVar.getDataList()) <= 0) {
            getView().setVisibility(8);
            return;
        }
        int I = com.baidu.tbadk.core.util.v.I(gVar.getDataList());
        if (I > 10) {
            ArrayList arrayList = new ArrayList(gVar.getDataList());
            gVar.getDataList().clear();
            gVar.getDataList().addAll(arrayList.subList(0, 10));
        }
        this.cMs = gVar.aoH();
        this.stType = gVar.getStType();
        if (!h(gVar.getDataList(), this.cMo)) {
            boolean z = com.baidu.tbadk.core.util.v.I(gVar.getDataList()) != com.baidu.tbadk.core.util.v.I(this.cMo);
            this.cMo = gVar.getDataList();
            if (I <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.cMl != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.cMo.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.cMl = new com.baidu.tieba.horizonalList.widget.b(getContext(), e.h.extend_forum_item, this.cMm);
                    this.cMl.setData(this.cMo);
                    this.cMl.setOnClickListener(this.aOJ);
                    this.cMk.setAdapter((ListAdapter) this.cMl);
                    d(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.cMl.setData(this.cMo);
                this.cMl.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.data.e mc(String str) {
        if (com.baidu.tbadk.core.util.v.I(this.cMo) > 0) {
            for (com.baidu.tieba.horizonalList.widget.c cVar : this.cMo) {
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
    public void a(long j, boolean z) {
        com.baidu.tieba.card.data.e mc = mc(String.valueOf(j));
        if (mc != null) {
            mc.isLiked = z;
        }
        if (this.cMl != null) {
            this.cMl.setData(this.cMo);
            this.cMl.notifyDataSetChanged();
        }
    }

    private boolean h(List<com.baidu.tieba.horizonalList.widget.c> list, List<com.baidu.tieba.horizonalList.widget.c> list2) {
        boolean z;
        if (com.baidu.tbadk.core.util.v.I(list) <= 0 || com.baidu.tbadk.core.util.v.I(list2) <= 0 || com.baidu.tbadk.core.util.v.I(list) != com.baidu.tbadk.core.util.v.I(list2)) {
            return false;
        }
        int i = 0;
        boolean z2 = true;
        while (i < com.baidu.tbadk.core.util.v.I(list)) {
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

    private void anU() {
        this.aOJ = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.getId() == e.g.forum_add_love) {
                        if (ba.bI(j.this.getView().getContext())) {
                            String str = (String) view.getTag(e.g.tag_forum_name);
                            String valueOf = String.valueOf(view.getTag(e.g.tag_forum_id));
                            if (ao.bv(str)) {
                                j.this.aGV.cF(str, valueOf);
                                TiebaStatic.log(new am(j.this.biR).ax(ImageViewerConfig.FORUM_ID, valueOf).ax("obj_param3", o.aof()));
                            }
                        }
                    } else if (view.getTag(e.g.tag_forum_name) != null) {
                        String str2 = (String) view.getTag(e.g.tag_forum_name);
                        String valueOf2 = String.valueOf(view.getTag(e.g.tag_forum_id));
                        if (ao.bv(str2)) {
                            if (view.getId() == e.g.m_forum_name_textview) {
                                TiebaStatic.log(new am(j.this.cMr).ax(ImageViewerConfig.FORUM_ID, valueOf2).ax("obj_param3", o.aof()));
                            } else {
                                TiebaStatic.log(new am(j.this.cMq).ax(ImageViewerConfig.FORUM_ID, valueOf2).ax("obj_param3", o.aof()));
                            }
                            if (!StringUtils.isNull(j.this.stType) && !StringUtils.isNull(j.this.cMs)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(j.this.getView().getContext()).createCfgForpersonalized(str2, j.this.stType, j.this.cMs)));
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
        this.cMp = str;
        this.biR = str2;
        this.cMq = str3;
        this.cMr = str4;
    }
}

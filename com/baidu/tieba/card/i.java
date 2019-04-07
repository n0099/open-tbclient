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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class i extends b<com.baidu.tieba.card.data.g> {
    private LikeModel bUs;
    private View.OnClickListener ccC;
    private String cys;
    private CustomMessageListener cyu;
    private CustomMessageListener cyv;
    private HListView egT;
    private com.baidu.tieba.horizonalList.widget.b egU;
    private c egV;
    private View egW;
    private List<com.baidu.tieba.horizonalList.widget.c> egX;
    private String egY;
    private String egZ;
    private String eha;
    private String ehb;
    private LayoutInflater mInflater;
    private String stType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cyu = new CustomMessageListener(2001336) { // from class: com.baidu.tieba.card.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    i.this.d(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.cyv = new CustomMessageListener(2001335) { // from class: com.baidu.tieba.card.i.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    i.this.d(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.egT = new HListView(getContext());
        this.egT.setHeaderDividersEnabled(false);
        this.egT.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.egW = this.mInflater.inflate(d.h.extend_forum_item, (ViewGroup) null);
        this.egV = new c(this.egW);
        this.efo.addView(this.egT);
        this.egT.setSelector(d.f.list_selector_transparent);
        this.egT.setPadding(tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0);
        aQh();
        if (this.egU == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.egU = new com.baidu.tieba.horizonalList.widget.b(getContext(), d.h.extend_forum_item, this.egV);
            this.egU.setOnClickListener(this.ccC);
            this.egT.setAdapter((ListAdapter) this.egU);
        }
        this.efg.setOnClickListener(this);
        this.bUs = new LikeModel(tbPageContext);
        this.bUs.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.i.1
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (!(obj instanceof com.baidu.tieba.tbadkCore.r) || i.this.bUs.getErrorCode() != 0) {
                    if (AntiHelper.aD(i.this.bUs.getErrorCode(), i.this.bUs.getErrorString())) {
                        AntiHelper.aU(i.this.getContext(), i.this.bUs.getErrorString());
                    } else {
                        i.this.getTbPageContext().showToast(i.this.bUs.getErrorString());
                    }
                }
            }
        });
        this.egT.setOnItemClickListener(null);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.cyu != null && this.cyv != null) {
            this.cyu.setTag(bdUniqueId);
            this.cyv.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cyu);
            MessageManager.getInstance().registerListener(this.cyv);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.egT != null && this.egU != null) {
            this.egU.hM(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.g gVar) {
        super.a((i) gVar);
        if (gVar == null || com.baidu.tbadk.core.util.v.S(gVar.getDataList()) <= 0) {
            getView().setVisibility(8);
            return;
        }
        int S = com.baidu.tbadk.core.util.v.S(gVar.getDataList());
        if (S > 10) {
            ArrayList arrayList = new ArrayList(gVar.getDataList());
            gVar.getDataList().clear();
            gVar.getDataList().addAll(arrayList.subList(0, 10));
        }
        this.ehb = gVar.aQV();
        this.stType = gVar.getStType();
        if (!h(gVar.getDataList(), this.egX)) {
            boolean z = com.baidu.tbadk.core.util.v.S(gVar.getDataList()) != com.baidu.tbadk.core.util.v.S(this.egX);
            this.egX = gVar.getDataList();
            if (S <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.egU != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.egX.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.egU = new com.baidu.tieba.horizonalList.widget.b(getContext(), d.h.extend_forum_item, this.egV);
                    this.egU.setData(this.egX);
                    this.egU.setOnClickListener(this.ccC);
                    this.egT.setAdapter((ListAdapter) this.egU);
                    onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.egU.setData(this.egX);
                this.egU.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.data.e ty(String str) {
        if (com.baidu.tbadk.core.util.v.S(this.egX) > 0) {
            for (com.baidu.tieba.horizonalList.widget.c cVar : this.egX) {
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
    public void d(long j, boolean z) {
        com.baidu.tieba.card.data.e ty = ty(String.valueOf(j));
        if (ty != null) {
            ty.isLiked = z;
        }
        if (this.egU != null) {
            this.egU.setData(this.egX);
            this.egU.notifyDataSetChanged();
        }
    }

    private boolean h(List<com.baidu.tieba.horizonalList.widget.c> list, List<com.baidu.tieba.horizonalList.widget.c> list2) {
        boolean z;
        if (com.baidu.tbadk.core.util.v.S(list) <= 0 || com.baidu.tbadk.core.util.v.S(list2) <= 0 || com.baidu.tbadk.core.util.v.S(list) != com.baidu.tbadk.core.util.v.S(list2)) {
            return false;
        }
        int i = 0;
        boolean z2 = true;
        while (i < com.baidu.tbadk.core.util.v.S(list)) {
            com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.v.c(list, i);
            com.baidu.tieba.horizonalList.widget.c cVar2 = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.v.c(list2, i);
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

    private void aQh() {
        this.ccC = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.getId() == d.g.forum_add_love) {
                        if (bc.cZ(i.this.getView().getContext())) {
                            String str = (String) view.getTag(d.g.tag_forum_name);
                            String valueOf = String.valueOf(view.getTag(d.g.tag_forum_id));
                            if (ap.bv(str)) {
                                i.this.bUs.dW(str, valueOf);
                                TiebaStatic.log(new am(i.this.cys).bJ(ImageViewerConfig.FORUM_ID, valueOf).bJ("obj_param3", n.aQv()));
                            }
                        }
                    } else if (view.getTag(d.g.tag_forum_name) != null) {
                        String str2 = (String) view.getTag(d.g.tag_forum_name);
                        String valueOf2 = String.valueOf(view.getTag(d.g.tag_forum_id));
                        if (ap.bv(str2)) {
                            if (view.getId() == d.g.m_forum_name_textview) {
                                TiebaStatic.log(new am(i.this.eha).bJ(ImageViewerConfig.FORUM_ID, valueOf2).bJ("obj_param3", n.aQv()));
                            } else {
                                TiebaStatic.log(new am(i.this.egZ).bJ(ImageViewerConfig.FORUM_ID, valueOf2).bJ("obj_param3", n.aQv()));
                            }
                            if (!StringUtils.isNull(i.this.stType) && !StringUtils.isNull(i.this.ehb)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(i.this.getView().getContext()).createCfgForpersonalized(str2, i.this.stType, i.this.ehb)));
                            } else {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(i.this.getView().getContext()).createNormalCfg(str2, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                            }
                        }
                    }
                }
            }
        };
    }

    public void o(String str, String str2, String str3, String str4) {
        this.egY = str;
        this.cys = str2;
        this.egZ = str3;
        this.eha = str4;
    }
}

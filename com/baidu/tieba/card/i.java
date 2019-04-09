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
    private LikeModel bUt;
    private View.OnClickListener ccD;
    private String cyt;
    private CustomMessageListener cyv;
    private CustomMessageListener cyw;
    private HListView egU;
    private com.baidu.tieba.horizonalList.widget.b egV;
    private c egW;
    private View egX;
    private List<com.baidu.tieba.horizonalList.widget.c> egY;
    private String egZ;
    private String eha;
    private String ehb;
    private String ehc;
    private LayoutInflater mInflater;
    private String stType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cyv = new CustomMessageListener(2001336) { // from class: com.baidu.tieba.card.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    i.this.d(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.cyw = new CustomMessageListener(2001335) { // from class: com.baidu.tieba.card.i.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    i.this.d(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.egU = new HListView(getContext());
        this.egU.setHeaderDividersEnabled(false);
        this.egU.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.egX = this.mInflater.inflate(d.h.extend_forum_item, (ViewGroup) null);
        this.egW = new c(this.egX);
        this.efp.addView(this.egU);
        this.egU.setSelector(d.f.list_selector_transparent);
        this.egU.setPadding(tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0);
        aQh();
        if (this.egV == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.egV = new com.baidu.tieba.horizonalList.widget.b(getContext(), d.h.extend_forum_item, this.egW);
            this.egV.setOnClickListener(this.ccD);
            this.egU.setAdapter((ListAdapter) this.egV);
        }
        this.efh.setOnClickListener(this);
        this.bUt = new LikeModel(tbPageContext);
        this.bUt.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.i.1
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (!(obj instanceof com.baidu.tieba.tbadkCore.r) || i.this.bUt.getErrorCode() != 0) {
                    if (AntiHelper.aD(i.this.bUt.getErrorCode(), i.this.bUt.getErrorString())) {
                        AntiHelper.aU(i.this.getContext(), i.this.bUt.getErrorString());
                    } else {
                        i.this.getTbPageContext().showToast(i.this.bUt.getErrorString());
                    }
                }
            }
        });
        this.egU.setOnItemClickListener(null);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.cyv != null && this.cyw != null) {
            this.cyv.setTag(bdUniqueId);
            this.cyw.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cyv);
            MessageManager.getInstance().registerListener(this.cyw);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.egU != null && this.egV != null) {
            this.egV.hM(i);
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
        this.ehc = gVar.aQV();
        this.stType = gVar.getStType();
        if (!h(gVar.getDataList(), this.egY)) {
            boolean z = com.baidu.tbadk.core.util.v.S(gVar.getDataList()) != com.baidu.tbadk.core.util.v.S(this.egY);
            this.egY = gVar.getDataList();
            if (S <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.egV != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.egY.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.egV = new com.baidu.tieba.horizonalList.widget.b(getContext(), d.h.extend_forum_item, this.egW);
                    this.egV.setData(this.egY);
                    this.egV.setOnClickListener(this.ccD);
                    this.egU.setAdapter((ListAdapter) this.egV);
                    onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.egV.setData(this.egY);
                this.egV.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.data.e ty(String str) {
        if (com.baidu.tbadk.core.util.v.S(this.egY) > 0) {
            for (com.baidu.tieba.horizonalList.widget.c cVar : this.egY) {
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
        if (this.egV != null) {
            this.egV.setData(this.egY);
            this.egV.notifyDataSetChanged();
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
        this.ccD = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.getId() == d.g.forum_add_love) {
                        if (bc.cZ(i.this.getView().getContext())) {
                            String str = (String) view.getTag(d.g.tag_forum_name);
                            String valueOf = String.valueOf(view.getTag(d.g.tag_forum_id));
                            if (ap.bv(str)) {
                                i.this.bUt.dW(str, valueOf);
                                TiebaStatic.log(new am(i.this.cyt).bJ(ImageViewerConfig.FORUM_ID, valueOf).bJ("obj_param3", n.aQv()));
                            }
                        }
                    } else if (view.getTag(d.g.tag_forum_name) != null) {
                        String str2 = (String) view.getTag(d.g.tag_forum_name);
                        String valueOf2 = String.valueOf(view.getTag(d.g.tag_forum_id));
                        if (ap.bv(str2)) {
                            if (view.getId() == d.g.m_forum_name_textview) {
                                TiebaStatic.log(new am(i.this.ehb).bJ(ImageViewerConfig.FORUM_ID, valueOf2).bJ("obj_param3", n.aQv()));
                            } else {
                                TiebaStatic.log(new am(i.this.eha).bJ(ImageViewerConfig.FORUM_ID, valueOf2).bJ("obj_param3", n.aQv()));
                            }
                            if (!StringUtils.isNull(i.this.stType) && !StringUtils.isNull(i.this.ehc)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(i.this.getView().getContext()).createCfgForpersonalized(str2, i.this.stType, i.this.ehc)));
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
        this.egZ = str;
        this.cyt = str2;
        this.eha = str3;
        this.ehb = str4;
    }
}

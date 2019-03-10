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
import com.baidu.tieba.card.data.e;
import com.baidu.tieba.card.data.g;
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class i extends b<g> {
    private LikeModel bUp;
    private View.OnClickListener ccA;
    private String cyt;
    private CustomMessageListener cyv;
    private CustomMessageListener cyw;
    private HListView ehl;
    private com.baidu.tieba.horizonalList.widget.b ehm;
    private c ehn;
    private View eho;
    private List<com.baidu.tieba.horizonalList.widget.c> ehp;
    private String ehq;
    private String ehr;
    private String ehs;
    private String eht;
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
        this.ehl = new HListView(getContext());
        this.ehl.setHeaderDividersEnabled(false);
        this.ehl.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.eho = this.mInflater.inflate(d.h.extend_forum_item, (ViewGroup) null);
        this.ehn = new c(this.eho);
        this.efG.addView(this.ehl);
        this.ehl.setSelector(d.f.list_selector_transparent);
        this.ehl.setPadding(tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0);
        aQk();
        if (this.ehm == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.ehm = new com.baidu.tieba.horizonalList.widget.b(getContext(), d.h.extend_forum_item, this.ehn);
            this.ehm.setOnClickListener(this.ccA);
            this.ehl.setAdapter((ListAdapter) this.ehm);
        }
        this.efy.setOnClickListener(this);
        this.bUp = new LikeModel(tbPageContext);
        this.bUp.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.i.1
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (!(obj instanceof r) || i.this.bUp.getErrorCode() != 0) {
                    if (AntiHelper.aB(i.this.bUp.getErrorCode(), i.this.bUp.getErrorString())) {
                        AntiHelper.aV(i.this.getContext(), i.this.bUp.getErrorString());
                    } else {
                        i.this.getTbPageContext().showToast(i.this.bUp.getErrorString());
                    }
                }
            }
        });
        this.ehl.setOnItemClickListener(null);
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
        if (this.ehl != null && this.ehm != null) {
            this.ehm.hN(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(g gVar) {
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
        this.eht = gVar.aQY();
        this.stType = gVar.getStType();
        if (!h(gVar.getDataList(), this.ehp)) {
            boolean z = com.baidu.tbadk.core.util.v.S(gVar.getDataList()) != com.baidu.tbadk.core.util.v.S(this.ehp);
            this.ehp = gVar.getDataList();
            if (S <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.ehm != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.ehp.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.ehm = new com.baidu.tieba.horizonalList.widget.b(getContext(), d.h.extend_forum_item, this.ehn);
                    this.ehm.setData(this.ehp);
                    this.ehm.setOnClickListener(this.ccA);
                    this.ehl.setAdapter((ListAdapter) this.ehm);
                    onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.ehm.setData(this.ehp);
                this.ehm.notifyDataSetChanged();
            }
        }
    }

    private e tB(String str) {
        if (com.baidu.tbadk.core.util.v.S(this.ehp) > 0) {
            for (com.baidu.tieba.horizonalList.widget.c cVar : this.ehp) {
                if (cVar != null && (cVar instanceof e)) {
                    e eVar = (e) cVar;
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
        e tB = tB(String.valueOf(j));
        if (tB != null) {
            tB.isLiked = z;
        }
        if (this.ehm != null) {
            this.ehm.setData(this.ehp);
            this.ehm.notifyDataSetChanged();
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
            if (cVar == null || !(cVar instanceof e) || cVar2 == null || !(cVar2 instanceof e)) {
                z = false;
            } else {
                e eVar = (e) cVar;
                e eVar2 = (e) cVar2;
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

    private void aQk() {
        this.ccA = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.getId() == d.g.forum_add_love) {
                        if (bc.cZ(i.this.getView().getContext())) {
                            String str = (String) view.getTag(d.g.tag_forum_name);
                            String valueOf = String.valueOf(view.getTag(d.g.tag_forum_id));
                            if (ap.bv(str)) {
                                i.this.bUp.dW(str, valueOf);
                                TiebaStatic.log(new am(i.this.cyt).bJ(ImageViewerConfig.FORUM_ID, valueOf).bJ("obj_param3", n.aQy()));
                            }
                        }
                    } else if (view.getTag(d.g.tag_forum_name) != null) {
                        String str2 = (String) view.getTag(d.g.tag_forum_name);
                        String valueOf2 = String.valueOf(view.getTag(d.g.tag_forum_id));
                        if (ap.bv(str2)) {
                            if (view.getId() == d.g.m_forum_name_textview) {
                                TiebaStatic.log(new am(i.this.ehs).bJ(ImageViewerConfig.FORUM_ID, valueOf2).bJ("obj_param3", n.aQy()));
                            } else {
                                TiebaStatic.log(new am(i.this.ehr).bJ(ImageViewerConfig.FORUM_ID, valueOf2).bJ("obj_param3", n.aQy()));
                            }
                            if (!StringUtils.isNull(i.this.stType) && !StringUtils.isNull(i.this.eht)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(i.this.getView().getContext()).createCfgForpersonalized(str2, i.this.stType, i.this.eht)));
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
        this.ehq = str;
        this.cyt = str2;
        this.ehr = str3;
        this.ehs = str4;
    }
}

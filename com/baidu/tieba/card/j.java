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
    private LikeModel aHL;
    private View.OnClickListener aPz;
    private String bjC;
    private CustomMessageListener bjE;
    private CustomMessageListener bjF;
    private HListView cNq;
    private com.baidu.tieba.horizonalList.widget.b cNr;
    private d cNs;
    private View cNt;
    private List<com.baidu.tieba.horizonalList.widget.c> cNu;
    private String cNv;
    private String cNw;
    private String cNx;
    private String cNy;
    private LayoutInflater mInflater;
    private String stType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bjE = new CustomMessageListener(2001336) { // from class: com.baidu.tieba.card.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    j.this.c(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.bjF = new CustomMessageListener(2001335) { // from class: com.baidu.tieba.card.j.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    j.this.c(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.cNq = new HListView(getContext());
        this.cNq.setHeaderDividersEnabled(false);
        this.cNq.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.cNt = this.mInflater.inflate(e.h.extend_forum_item, (ViewGroup) null);
        this.cNs = new d(this.cNt);
        this.cLG.addView(this.cNq);
        this.cNq.setSelector(e.f.list_selector_transparent);
        this.cNq.setPadding(tbPageContext.getResources().getDimensionPixelSize(e.C0200e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(e.C0200e.ds4), 0);
        anw();
        if (this.cNr == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.cNr = new com.baidu.tieba.horizonalList.widget.b(getContext(), e.h.extend_forum_item, this.cNs);
            this.cNr.setOnClickListener(this.aPz);
            this.cNq.setAdapter((ListAdapter) this.cNr);
        }
        this.cLy.setOnClickListener(this);
        this.aHL = new LikeModel(tbPageContext);
        this.aHL.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.j.1
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (!(obj instanceof com.baidu.tieba.tbadkCore.r) || j.this.aHL.getErrorCode() != 0) {
                    if (AntiHelper.ai(j.this.aHL.getErrorCode(), j.this.aHL.getErrorString())) {
                        AntiHelper.aG(j.this.getContext(), j.this.aHL.getErrorString());
                    } else {
                        j.this.getTbPageContext().showToast(j.this.aHL.getErrorString());
                    }
                }
            }
        });
        this.cNq.setOnItemClickListener(null);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (this.bjE != null && this.bjF != null) {
            this.bjE.setTag(bdUniqueId);
            this.bjF.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bjE);
            MessageManager.getInstance().registerListener(this.bjF);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.cNq != null && this.cNr != null) {
            this.cNr.dV(i);
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
        this.cNy = gVar.aoj();
        this.stType = gVar.getStType();
        if (!h(gVar.getDataList(), this.cNu)) {
            boolean z = com.baidu.tbadk.core.util.v.H(gVar.getDataList()) != com.baidu.tbadk.core.util.v.H(this.cNu);
            this.cNu = gVar.getDataList();
            if (H <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.cNr != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.cNu.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.cNr = new com.baidu.tieba.horizonalList.widget.b(getContext(), e.h.extend_forum_item, this.cNs);
                    this.cNr.setData(this.cNu);
                    this.cNr.setOnClickListener(this.aPz);
                    this.cNq.setAdapter((ListAdapter) this.cNr);
                    d(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.cNr.setData(this.cNu);
                this.cNr.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.data.e md(String str) {
        if (com.baidu.tbadk.core.util.v.H(this.cNu) > 0) {
            for (com.baidu.tieba.horizonalList.widget.c cVar : this.cNu) {
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
        com.baidu.tieba.card.data.e md = md(String.valueOf(j));
        if (md != null) {
            md.isLiked = z;
        }
        if (this.cNr != null) {
            this.cNr.setData(this.cNu);
            this.cNr.notifyDataSetChanged();
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

    private void anw() {
        this.aPz = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.getId() == e.g.forum_add_love) {
                        if (ba.bG(j.this.getView().getContext())) {
                            String str = (String) view.getTag(e.g.tag_forum_name);
                            String valueOf = String.valueOf(view.getTag(e.g.tag_forum_id));
                            if (ao.bv(str)) {
                                j.this.aHL.cF(str, valueOf);
                                TiebaStatic.log(new am(j.this.bjC).ax(ImageViewerConfig.FORUM_ID, valueOf).ax("obj_param3", o.anH()));
                            }
                        }
                    } else if (view.getTag(e.g.tag_forum_name) != null) {
                        String str2 = (String) view.getTag(e.g.tag_forum_name);
                        String valueOf2 = String.valueOf(view.getTag(e.g.tag_forum_id));
                        if (ao.bv(str2)) {
                            if (view.getId() == e.g.m_forum_name_textview) {
                                TiebaStatic.log(new am(j.this.cNx).ax(ImageViewerConfig.FORUM_ID, valueOf2).ax("obj_param3", o.anH()));
                            } else {
                                TiebaStatic.log(new am(j.this.cNw).ax(ImageViewerConfig.FORUM_ID, valueOf2).ax("obj_param3", o.anH()));
                            }
                            if (!StringUtils.isNull(j.this.stType) && !StringUtils.isNull(j.this.cNy)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(j.this.getView().getContext()).createCfgForpersonalized(str2, j.this.stType, j.this.cNy)));
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
        this.cNv = str;
        this.bjC = str2;
        this.cNw = str3;
        this.cNx = str4;
    }
}

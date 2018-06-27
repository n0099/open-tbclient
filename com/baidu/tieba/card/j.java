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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class j extends b<com.baidu.tieba.card.data.g> {
    private View.OnClickListener aGU;
    private String baZ;
    private CustomMessageListener bbb;
    private CustomMessageListener bbc;
    private LikeModel bwM;
    private HListView cvA;
    private com.baidu.tieba.horizonalList.widget.b cvB;
    private d cvC;
    private View cvD;
    private List<com.baidu.tieba.horizonalList.widget.c> cvE;
    private String cvF;
    private String cvG;
    private String cvH;
    private String cvI;
    private LayoutInflater mInflater;
    private String stType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bbb = new CustomMessageListener(2001336) { // from class: com.baidu.tieba.card.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    j.this.b(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.bbc = new CustomMessageListener(2001335) { // from class: com.baidu.tieba.card.j.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    j.this.b(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.cvA = new HListView(getContext());
        this.cvA.setHeaderDividersEnabled(false);
        this.cvA.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.cvD = this.mInflater.inflate(d.i.extend_forum_item, (ViewGroup) null);
        this.cvC = new d(this.cvD);
        this.ctP.addView(this.cvA);
        this.cvA.setSelector(d.f.list_selector_transparent);
        this.cvA.setPadding(tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0);
        aig();
        if (this.cvB == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.cvB = new com.baidu.tieba.horizonalList.widget.b(getContext(), d.i.extend_forum_item, this.cvC);
            this.cvB.setOnClickListener(this.aGU);
            this.cvA.setAdapter((ListAdapter) this.cvB);
        }
        this.ctH.setOnClickListener(this);
        this.bwM = new LikeModel(tbPageContext);
        this.bwM.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.j.1
            @Override // com.baidu.adp.base.d
            public void i(Object obj) {
                if (!(obj instanceof com.baidu.tieba.tbadkCore.r) || j.this.bwM.getErrorCode() != 0) {
                    if (AntiHelper.tQ(j.this.bwM.getErrorCode())) {
                        AntiHelper.ao(j.this.getContext(), j.this.bwM.getErrorString());
                    } else {
                        j.this.ahZ().showToast(j.this.bwM.getErrorString());
                    }
                }
            }
        });
        this.cvA.setOnItemClickListener(null);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (this.bbb != null && this.bbc != null) {
            this.bbb.setTag(bdUniqueId);
            this.bbc.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bbb);
            MessageManager.getInstance().registerListener(this.bbc);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.cvA != null && this.cvB != null) {
            this.cvB.dl(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.g gVar) {
        super.a((j) gVar);
        if (gVar == null || com.baidu.tbadk.core.util.w.z(gVar.getDataList()) <= 0) {
            getView().setVisibility(8);
            return;
        }
        int z = com.baidu.tbadk.core.util.w.z(gVar.getDataList());
        if (z > 10) {
            ArrayList arrayList = new ArrayList(gVar.getDataList());
            gVar.getDataList().clear();
            gVar.getDataList().addAll(arrayList.subList(0, 10));
        }
        this.cvI = gVar.aiS();
        this.stType = gVar.getStType();
        if (!h(gVar.getDataList(), this.cvE)) {
            boolean z2 = com.baidu.tbadk.core.util.w.z(gVar.getDataList()) != com.baidu.tbadk.core.util.w.z(this.cvE);
            this.cvE = gVar.getDataList();
            if (z <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.cvB != null) {
                if (z2) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.cvE.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.cvB = new com.baidu.tieba.horizonalList.widget.b(getContext(), d.i.extend_forum_item, this.cvC);
                    this.cvB.setData(this.cvE);
                    this.cvB.setOnClickListener(this.aGU);
                    this.cvA.setAdapter((ListAdapter) this.cvB);
                    d(ahZ(), TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.cvB.setData(this.cvE);
                this.cvB.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.data.e kX(String str) {
        if (com.baidu.tbadk.core.util.w.z(this.cvE) > 0) {
            for (com.baidu.tieba.horizonalList.widget.c cVar : this.cvE) {
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
    public void b(long j, boolean z) {
        com.baidu.tieba.card.data.e kX = kX(String.valueOf(j));
        if (kX != null) {
            kX.isLiked = z;
        }
        if (this.cvB != null) {
            this.cvB.setData(this.cvE);
            this.cvB.notifyDataSetChanged();
        }
    }

    private boolean h(List<com.baidu.tieba.horizonalList.widget.c> list, List<com.baidu.tieba.horizonalList.widget.c> list2) {
        boolean z;
        if (com.baidu.tbadk.core.util.w.z(list) <= 0 || com.baidu.tbadk.core.util.w.z(list2) <= 0 || com.baidu.tbadk.core.util.w.z(list) != com.baidu.tbadk.core.util.w.z(list2)) {
            return false;
        }
        int i = 0;
        boolean z2 = true;
        while (i < com.baidu.tbadk.core.util.w.z(list)) {
            com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.w.d(list, i);
            com.baidu.tieba.horizonalList.widget.c cVar2 = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.w.d(list2, i);
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

    private void aig() {
        this.aGU = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.getId() == d.g.forum_add_love) {
                        if (bb.aU(j.this.getView().getContext())) {
                            String str = (String) view.getTag(d.g.tag_forum_name);
                            String valueOf = String.valueOf(view.getTag(d.g.tag_forum_id));
                            if (ap.be(str)) {
                                j.this.bwM.cn(str, valueOf);
                                TiebaStatic.log(new an(j.this.baZ).ah(ImageViewerConfig.FORUM_ID, valueOf).ah("obj_param3", o.aiq()));
                            }
                        }
                    } else if (view.getTag(d.g.tag_forum_name) != null) {
                        String str2 = (String) view.getTag(d.g.tag_forum_name);
                        String valueOf2 = String.valueOf(view.getTag(d.g.tag_forum_id));
                        if (ap.be(str2)) {
                            if (view.getId() == d.g.m_forum_name_textview) {
                                TiebaStatic.log(new an(j.this.cvH).ah(ImageViewerConfig.FORUM_ID, valueOf2).ah("obj_param3", o.aiq()));
                            } else {
                                TiebaStatic.log(new an(j.this.cvG).ah(ImageViewerConfig.FORUM_ID, valueOf2).ah("obj_param3", o.aiq()));
                            }
                            if (!StringUtils.isNull(j.this.stType) && !StringUtils.isNull(j.this.cvI)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(j.this.getView().getContext()).createCfgForpersonalized(str2, j.this.stType, j.this.cvI)));
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
        this.cvF = str;
        this.baZ = str2;
        this.cvG = str3;
        this.cvH = str4;
    }
}

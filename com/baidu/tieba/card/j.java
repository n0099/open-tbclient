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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class j extends b<com.baidu.tieba.card.data.g> {
    private String aSj;
    private CustomMessageListener aSl;
    private CustomMessageListener aSm;
    private View.OnClickListener axH;
    private LikeModel bnl;
    private HListView coP;
    private com.baidu.tieba.horizonalList.widget.b coQ;
    private d coR;
    private View coS;
    private List<com.baidu.tieba.horizonalList.widget.c> coT;
    private String coU;
    private String coV;
    private String coW;
    private String coX;
    private LayoutInflater mInflater;
    private String stType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aSl = new CustomMessageListener(2001336) { // from class: com.baidu.tieba.card.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    j.this.b(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.aSm = new CustomMessageListener(2001335) { // from class: com.baidu.tieba.card.j.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    j.this.b(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.coP = new HListView(getContext());
        this.coP.setHeaderDividersEnabled(false);
        this.coP.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.coS = this.mInflater.inflate(d.i.extend_forum_item, (ViewGroup) null);
        this.coR = new d(this.coS);
        this.cne.addView(this.coP);
        this.coP.setSelector(d.f.list_selector_transparent);
        this.coP.setPadding(tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0);
        aff();
        if (this.coQ == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.coQ = new com.baidu.tieba.horizonalList.widget.b(getContext(), d.i.extend_forum_item, this.coR);
            this.coQ.setOnClickListener(this.axH);
            this.coP.setAdapter((ListAdapter) this.coQ);
        }
        this.cmW.setOnClickListener(this);
        this.bnl = new LikeModel(tbPageContext);
        this.bnl.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.j.1
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                if (!(obj instanceof com.baidu.tieba.tbadkCore.r) || j.this.bnl.getErrorCode() != 0) {
                    if (AntiHelper.ts(j.this.bnl.getErrorCode())) {
                        AntiHelper.am(j.this.getContext(), j.this.bnl.getErrorString());
                    } else {
                        j.this.aeY().showToast(j.this.bnl.getErrorString());
                    }
                }
            }
        });
        this.coP.setOnItemClickListener(null);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (this.aSl != null && this.aSm != null) {
            this.aSl.setTag(bdUniqueId);
            this.aSm.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aSl);
            MessageManager.getInstance().registerListener(this.aSm);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.coP != null && this.coQ != null) {
            this.coQ.di(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.g gVar) {
        super.a((j) gVar);
        if (gVar == null || com.baidu.tbadk.core.util.v.v(gVar.getDataList()) <= 0) {
            getView().setVisibility(8);
            return;
        }
        int v = com.baidu.tbadk.core.util.v.v(gVar.getDataList());
        if (v > 10) {
            ArrayList arrayList = new ArrayList(gVar.getDataList());
            gVar.getDataList().clear();
            gVar.getDataList().addAll(arrayList.subList(0, 10));
        }
        this.coX = gVar.afQ();
        this.stType = gVar.getStType();
        if (!g(gVar.getDataList(), this.coT)) {
            boolean z = com.baidu.tbadk.core.util.v.v(gVar.getDataList()) != com.baidu.tbadk.core.util.v.v(this.coT);
            this.coT = gVar.getDataList();
            if (v <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.coQ != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.coT.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.coQ = new com.baidu.tieba.horizonalList.widget.b(getContext(), d.i.extend_forum_item, this.coR);
                    this.coQ.setData(this.coT);
                    this.coQ.setOnClickListener(this.axH);
                    this.coP.setAdapter((ListAdapter) this.coQ);
                    d(aeY(), TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.coQ.setData(this.coT);
                this.coQ.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.data.e kx(String str) {
        if (com.baidu.tbadk.core.util.v.v(this.coT) > 0) {
            for (com.baidu.tieba.horizonalList.widget.c cVar : this.coT) {
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
        com.baidu.tieba.card.data.e kx = kx(String.valueOf(j));
        if (kx != null) {
            kx.isLiked = z;
        }
        if (this.coQ != null) {
            this.coQ.setData(this.coT);
            this.coQ.notifyDataSetChanged();
        }
    }

    private boolean g(List<com.baidu.tieba.horizonalList.widget.c> list, List<com.baidu.tieba.horizonalList.widget.c> list2) {
        boolean z;
        if (com.baidu.tbadk.core.util.v.v(list) <= 0 || com.baidu.tbadk.core.util.v.v(list2) <= 0 || com.baidu.tbadk.core.util.v.v(list) != com.baidu.tbadk.core.util.v.v(list2)) {
            return false;
        }
        int i = 0;
        boolean z2 = true;
        while (i < com.baidu.tbadk.core.util.v.v(list)) {
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

    private void aff() {
        this.axH = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (view2 != null) {
                    if (view2.getId() == d.g.forum_add_love) {
                        if (az.aK(j.this.getView().getContext())) {
                            String str = (String) view2.getTag(d.g.tag_forum_name);
                            String valueOf = String.valueOf(view2.getTag(d.g.tag_forum_id));
                            if (an.aQ(str)) {
                                j.this.bnl.cb(str, valueOf);
                                TiebaStatic.log(new al(j.this.aSj).ac(ImageViewerConfig.FORUM_ID, valueOf).ac("obj_param3", o.afp()));
                            }
                        }
                    } else if (view2.getTag(d.g.tag_forum_name) != null) {
                        String str2 = (String) view2.getTag(d.g.tag_forum_name);
                        String valueOf2 = String.valueOf(view2.getTag(d.g.tag_forum_id));
                        if (an.aQ(str2)) {
                            if (view2.getId() == d.g.m_forum_name_textview) {
                                TiebaStatic.log(new al(j.this.coW).ac(ImageViewerConfig.FORUM_ID, valueOf2).ac("obj_param3", o.afp()));
                            } else {
                                TiebaStatic.log(new al(j.this.coV).ac(ImageViewerConfig.FORUM_ID, valueOf2).ac("obj_param3", o.afp()));
                            }
                            if (!StringUtils.isNull(j.this.stType) && !StringUtils.isNull(j.this.coX)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(j.this.getView().getContext()).createCfgForpersonalized(str2, j.this.stType, j.this.coX)));
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
        this.coU = str;
        this.aSj = str2;
        this.coV = str3;
        this.coW = str4;
    }
}

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
/* loaded from: classes2.dex */
public class j extends b<com.baidu.tieba.card.data.g> {
    private LikeModel aCp;
    private View.OnClickListener aKh;
    private CustomMessageListener beB;
    private CustomMessageListener beC;
    private String bez;
    private HListView cDP;
    private com.baidu.tieba.horizonalList.widget.b cDQ;
    private d cDR;
    private View cDS;
    private List<com.baidu.tieba.horizonalList.widget.c> cDT;
    private String cDU;
    private String cDV;
    private String cDW;
    private String cDX;
    private LayoutInflater mInflater;
    private String stType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.beB = new CustomMessageListener(2001336) { // from class: com.baidu.tieba.card.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    j.this.a(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.beC = new CustomMessageListener(2001335) { // from class: com.baidu.tieba.card.j.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    j.this.a(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.cDP = new HListView(getContext());
        this.cDP.setHeaderDividersEnabled(false);
        this.cDP.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.cDS = this.mInflater.inflate(e.h.extend_forum_item, (ViewGroup) null);
        this.cDR = new d(this.cDS);
        this.cCf.addView(this.cDP);
        this.cDP.setSelector(e.f.list_selector_transparent);
        this.cDP.setPadding(tbPageContext.getResources().getDimensionPixelSize(e.C0141e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(e.C0141e.ds4), 0);
        aks();
        if (this.cDQ == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.cDQ = new com.baidu.tieba.horizonalList.widget.b(getContext(), e.h.extend_forum_item, this.cDR);
            this.cDQ.setOnClickListener(this.aKh);
            this.cDP.setAdapter((ListAdapter) this.cDQ);
        }
        this.cBX.setOnClickListener(this);
        this.aCp = new LikeModel(tbPageContext);
        this.aCp.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.j.1
            @Override // com.baidu.adp.base.d
            public void j(Object obj) {
                if (!(obj instanceof com.baidu.tieba.tbadkCore.r) || j.this.aCp.getErrorCode() != 0) {
                    if (AntiHelper.am(j.this.aCp.getErrorCode(), j.this.aCp.getErrorString())) {
                        AntiHelper.aG(j.this.getContext(), j.this.aCp.getErrorString());
                    } else {
                        j.this.getTbPageContext().showToast(j.this.aCp.getErrorString());
                    }
                }
            }
        });
        this.cDP.setOnItemClickListener(null);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (this.beB != null && this.beC != null) {
            this.beB.setTag(bdUniqueId);
            this.beC.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.beB);
            MessageManager.getInstance().registerListener(this.beC);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.cDP != null && this.cDQ != null) {
            this.cDQ.dx(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.g gVar) {
        super.a((j) gVar);
        if (gVar == null || com.baidu.tbadk.core.util.v.y(gVar.getDataList()) <= 0) {
            getView().setVisibility(8);
            return;
        }
        int y = com.baidu.tbadk.core.util.v.y(gVar.getDataList());
        if (y > 10) {
            ArrayList arrayList = new ArrayList(gVar.getDataList());
            gVar.getDataList().clear();
            gVar.getDataList().addAll(arrayList.subList(0, 10));
        }
        this.cDX = gVar.alf();
        this.stType = gVar.getStType();
        if (!h(gVar.getDataList(), this.cDT)) {
            boolean z = com.baidu.tbadk.core.util.v.y(gVar.getDataList()) != com.baidu.tbadk.core.util.v.y(this.cDT);
            this.cDT = gVar.getDataList();
            if (y <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.cDQ != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.cDT.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.cDQ = new com.baidu.tieba.horizonalList.widget.b(getContext(), e.h.extend_forum_item, this.cDR);
                    this.cDQ.setData(this.cDT);
                    this.cDQ.setOnClickListener(this.aKh);
                    this.cDP.setAdapter((ListAdapter) this.cDQ);
                    d(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.cDQ.setData(this.cDT);
                this.cDQ.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.data.e lz(String str) {
        if (com.baidu.tbadk.core.util.v.y(this.cDT) > 0) {
            for (com.baidu.tieba.horizonalList.widget.c cVar : this.cDT) {
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
        com.baidu.tieba.card.data.e lz = lz(String.valueOf(j));
        if (lz != null) {
            lz.isLiked = z;
        }
        if (this.cDQ != null) {
            this.cDQ.setData(this.cDT);
            this.cDQ.notifyDataSetChanged();
        }
    }

    private boolean h(List<com.baidu.tieba.horizonalList.widget.c> list, List<com.baidu.tieba.horizonalList.widget.c> list2) {
        boolean z;
        if (com.baidu.tbadk.core.util.v.y(list) <= 0 || com.baidu.tbadk.core.util.v.y(list2) <= 0 || com.baidu.tbadk.core.util.v.y(list) != com.baidu.tbadk.core.util.v.y(list2)) {
            return false;
        }
        int i = 0;
        boolean z2 = true;
        while (i < com.baidu.tbadk.core.util.v.y(list)) {
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

    private void aks() {
        this.aKh = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.getId() == e.g.forum_add_love) {
                        if (ba.bA(j.this.getView().getContext())) {
                            String str = (String) view.getTag(e.g.tag_forum_name);
                            String valueOf = String.valueOf(view.getTag(e.g.tag_forum_id));
                            if (ao.bw(str)) {
                                j.this.aCp.cu(str, valueOf);
                                TiebaStatic.log(new am(j.this.bez).al(ImageViewerConfig.FORUM_ID, valueOf).al("obj_param3", o.akD()));
                            }
                        }
                    } else if (view.getTag(e.g.tag_forum_name) != null) {
                        String str2 = (String) view.getTag(e.g.tag_forum_name);
                        String valueOf2 = String.valueOf(view.getTag(e.g.tag_forum_id));
                        if (ao.bw(str2)) {
                            if (view.getId() == e.g.m_forum_name_textview) {
                                TiebaStatic.log(new am(j.this.cDW).al(ImageViewerConfig.FORUM_ID, valueOf2).al("obj_param3", o.akD()));
                            } else {
                                TiebaStatic.log(new am(j.this.cDV).al(ImageViewerConfig.FORUM_ID, valueOf2).al("obj_param3", o.akD()));
                            }
                            if (!StringUtils.isNull(j.this.stType) && !StringUtils.isNull(j.this.cDX)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(j.this.getView().getContext()).createCfgForpersonalized(str2, j.this.stType, j.this.cDX)));
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
        this.cDU = str;
        this.bez = str2;
        this.cDV = str3;
        this.cDW = str4;
    }
}

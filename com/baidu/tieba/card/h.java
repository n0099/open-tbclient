package com.baidu.tieba.card;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h extends b<com.baidu.tieba.card.data.g> {
    private View.OnClickListener atM;
    private HListView bAH;
    private com.baidu.tieba.horizonalList.widget.j bAI;
    private g bAJ;
    private View bAK;
    private LikeModel bAL;
    private List<com.baidu.tieba.horizonalList.widget.k> bAM;
    private String bAN;
    private String bAO;
    private String bAP;
    private String bAQ;
    private String bAR;
    private CustomMessageListener bAS;
    private CustomMessageListener bAT;
    private LayoutInflater mInflater;
    private String stType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bAS = new i(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
        this.bAT = new j(this, CmdConfigCustom.CMD_LIKE_FORUM);
        this.bAH = new HListView(getContext());
        this.bAH.setHeaderDividersEnabled(false);
        this.bAH.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.bAK = this.mInflater.inflate(w.j.extend_forum_item, (ViewGroup) null);
        this.bAJ = new g(this.bAK);
        this.bAs.addView(this.bAH);
        this.bAH.setSelector(w.g.list_selector_transparent);
        this.bAH.setPadding(tbPageContext.getResources().getDimensionPixelSize(w.f.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(w.f.ds4), 0);
        Vy();
        if (this.bAI == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.bAI = new com.baidu.tieba.horizonalList.widget.j(getContext(), w.j.extend_forum_item, this.bAJ);
            this.bAI.setOnClickListener(this.atM);
            this.bAH.setAdapter((ListAdapter) this.bAI);
        }
        this.bAk.setOnClickListener(this);
        this.bAL = new LikeModel(tbPageContext);
        this.bAL.setLoadDataCallBack(new k(this));
        this.bAH.setOnItemClickListener(null);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.bAS != null && this.bAT != null) {
            this.bAS.setTag(bdUniqueId);
            this.bAT.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bAS);
            MessageManager.getInstance().registerListener(this.bAT);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.bAH != null && this.bAI != null) {
            this.bAI.de(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.g gVar) {
        super.a((h) gVar);
        if (gVar == null || com.baidu.tbadk.core.util.z.s(gVar.getDataList()) <= 0) {
            getView().setVisibility(8);
            return;
        }
        int s = com.baidu.tbadk.core.util.z.s(gVar.getDataList());
        if (s > 10) {
            ArrayList arrayList = new ArrayList(gVar.getDataList());
            gVar.getDataList().clear();
            gVar.getDataList().addAll(arrayList.subList(0, 10));
        }
        this.bAR = gVar.VZ();
        this.stType = gVar.getStType();
        if (!f(gVar.getDataList(), this.bAM)) {
            boolean z = com.baidu.tbadk.core.util.z.s(gVar.getDataList()) != com.baidu.tbadk.core.util.z.s(this.bAM);
            this.bAM = gVar.getDataList();
            if (s <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.bAI != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.bAM.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.bAI = new com.baidu.tieba.horizonalList.widget.j(getContext(), w.j.extend_forum_item, this.bAJ);
                    this.bAI.setData(this.bAM);
                    this.bAI.setOnClickListener(this.atM);
                    this.bAH.setAdapter((ListAdapter) this.bAI);
                    d(Vr(), TbadkCoreApplication.m9getInst().getSkinType());
                    return;
                }
                this.bAI.setData(this.bAM);
                this.bAI.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.data.e iH(String str) {
        if (com.baidu.tbadk.core.util.z.s(this.bAM) > 0) {
            for (com.baidu.tieba.horizonalList.widget.k kVar : this.bAM) {
                if (kVar != null && (kVar instanceof com.baidu.tieba.card.data.e)) {
                    com.baidu.tieba.card.data.e eVar = (com.baidu.tieba.card.data.e) kVar;
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
        com.baidu.tieba.card.data.e iH = iH(String.valueOf(j));
        if (iH != null) {
            iH.isLiked = z;
        }
        if (this.bAI != null) {
            this.bAI.setData(this.bAM);
            this.bAI.notifyDataSetChanged();
        }
    }

    private boolean f(List<com.baidu.tieba.horizonalList.widget.k> list, List<com.baidu.tieba.horizonalList.widget.k> list2) {
        boolean z;
        if (com.baidu.tbadk.core.util.z.s(list) <= 0 || com.baidu.tbadk.core.util.z.s(list2) <= 0 || com.baidu.tbadk.core.util.z.s(list) != com.baidu.tbadk.core.util.z.s(list2)) {
            return false;
        }
        int i = 0;
        boolean z2 = true;
        while (i < com.baidu.tbadk.core.util.z.s(list)) {
            com.baidu.tieba.horizonalList.widget.k kVar = (com.baidu.tieba.horizonalList.widget.k) com.baidu.tbadk.core.util.z.c(list, i);
            com.baidu.tieba.horizonalList.widget.k kVar2 = (com.baidu.tieba.horizonalList.widget.k) com.baidu.tbadk.core.util.z.c(list2, i);
            if (kVar == null || !(kVar instanceof com.baidu.tieba.card.data.e) || kVar2 == null || !(kVar2 instanceof com.baidu.tieba.card.data.e)) {
                z = false;
            } else {
                com.baidu.tieba.card.data.e eVar = (com.baidu.tieba.card.data.e) kVar;
                com.baidu.tieba.card.data.e eVar2 = (com.baidu.tieba.card.data.e) kVar2;
                if (eVar.forumId != eVar2.forumId) {
                    z2 = false;
                }
                if (!eVar.forumAvatar.equals(eVar2.forumAvatar)) {
                    z2 = false;
                }
                z = !eVar.forumName.equals(eVar2.forumName) ? false : z2;
            }
            i++;
            z2 = z;
        }
        return z2;
    }

    private void Vy() {
        this.atM = new l(this);
    }

    public void k(String str, String str2, String str3, String str4) {
        this.bAN = str;
        this.bAO = str2;
        this.bAP = str3;
        this.bAQ = str4;
    }
}

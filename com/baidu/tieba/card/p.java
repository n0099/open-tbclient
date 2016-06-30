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
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class p extends b<com.baidu.tieba.card.a.j> {
    private com.baidu.tieba.tbadkCore.y Dq;
    private HListView aSC;
    private com.baidu.tieba.horizonalList.widget.k aSD;
    private i aSE;
    private View aSF;
    private List<com.baidu.tieba.horizonalList.widget.l> aSG;
    private String aSH;
    private String aSI;
    private String aSJ;
    private String aSK;
    private String aSL;
    private CustomMessageListener aSM;
    private CustomMessageListener aSN;
    private View.OnClickListener akb;
    private LayoutInflater mInflater;
    private String stType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aSM = new q(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
        this.aSN = new r(this, CmdConfigCustom.CMD_LIKE_FORUM);
        this.aSC = new HListView(getContext());
        this.aSC.setHeaderDividersEnabled(false);
        this.aSC.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.aSF = this.mInflater.inflate(u.h.extend_forum_item, (ViewGroup) null);
        this.aSE = new i(this.aSF);
        this.aRw.addView(this.aSC);
        this.aSC.setSelector(u.f.list_selector_transparent);
        this.aSC.setPadding(tbPageContext.getResources().getDimensionPixelSize(u.e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(u.e.ds4), 0);
        KT();
        if (this.aSD == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.aSD = new com.baidu.tieba.horizonalList.widget.k(getContext(), u.h.extend_forum_item, this.aSE);
            this.aSD.setOnClickListener(this.akb);
            this.aSC.setAdapter((ListAdapter) this.aSD);
        }
        this.aRo.setOnClickListener(this);
        this.Dq = new com.baidu.tieba.tbadkCore.y(tbPageContext);
        this.Dq.setLoadDataCallBack(new s(this));
        this.aSC.setOnItemClickListener(null);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.aSM != null && this.aSN != null) {
            this.aSM.setTag(bdUniqueId);
            this.aSN.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aSM);
            MessageManager.getInstance().registerListener(this.aSN);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.b
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.aSC != null && this.aSD != null) {
            this.aSD.cO(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.a.j jVar) {
        super.a((p) jVar);
        if (jVar == null || com.baidu.tbadk.core.util.y.s(jVar.Eb()) <= 0) {
            getView().setVisibility(8);
            return;
        }
        int s = com.baidu.tbadk.core.util.y.s(jVar.Eb());
        if (s > 10) {
            ArrayList arrayList = new ArrayList(jVar.Eb());
            jVar.Eb().clear();
            jVar.Eb().addAll(arrayList.subList(0, 10));
        }
        this.aSL = jVar.Lt();
        this.stType = jVar.getStType();
        if (!b(jVar.Eb(), this.aSG)) {
            boolean z = com.baidu.tbadk.core.util.y.s(jVar.Eb()) != com.baidu.tbadk.core.util.y.s(this.aSG);
            this.aSG = jVar.Eb();
            if (s <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.aSD != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.aSG.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.aSD = new com.baidu.tieba.horizonalList.widget.k(getContext(), u.h.extend_forum_item, this.aSE);
                    this.aSD.setData(this.aSG);
                    this.aSD.setOnClickListener(this.akb);
                    this.aSC.setAdapter((ListAdapter) this.aSD);
                    d(KN(), TbadkCoreApplication.m9getInst().getSkinType());
                    return;
                }
                this.aSD.setData(this.aSG);
                this.aSD.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.a.e ha(String str) {
        if (com.baidu.tbadk.core.util.y.s(this.aSG) > 0) {
            for (com.baidu.tieba.horizonalList.widget.l lVar : this.aSG) {
                if (lVar != null && (lVar instanceof com.baidu.tieba.card.a.e)) {
                    com.baidu.tieba.card.a.e eVar = (com.baidu.tieba.card.a.e) lVar;
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
        com.baidu.tieba.card.a.e ha = ha(String.valueOf(j));
        if (ha != null) {
            ha.isLiked = z;
        }
        if (this.aSD != null) {
            this.aSD.setData(this.aSG);
            this.aSD.notifyDataSetChanged();
        }
    }

    private boolean b(List<com.baidu.tieba.horizonalList.widget.l> list, List<com.baidu.tieba.horizonalList.widget.l> list2) {
        boolean z;
        if (com.baidu.tbadk.core.util.y.s(list) <= 0 || com.baidu.tbadk.core.util.y.s(list2) <= 0 || com.baidu.tbadk.core.util.y.s(list) != com.baidu.tbadk.core.util.y.s(list2)) {
            return false;
        }
        int i = 0;
        boolean z2 = true;
        while (i < com.baidu.tbadk.core.util.y.s(list)) {
            com.baidu.tieba.horizonalList.widget.l lVar = (com.baidu.tieba.horizonalList.widget.l) com.baidu.tbadk.core.util.y.c(list, i);
            com.baidu.tieba.horizonalList.widget.l lVar2 = (com.baidu.tieba.horizonalList.widget.l) com.baidu.tbadk.core.util.y.c(list2, i);
            if (lVar == null || !(lVar instanceof com.baidu.tieba.card.a.e) || lVar2 == null || !(lVar2 instanceof com.baidu.tieba.card.a.e)) {
                z = false;
            } else {
                com.baidu.tieba.card.a.e eVar = (com.baidu.tieba.card.a.e) lVar;
                com.baidu.tieba.card.a.e eVar2 = (com.baidu.tieba.card.a.e) lVar2;
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

    private void KT() {
        this.akb = new t(this);
    }

    public void i(String str, String str2, String str3, String str4) {
        this.aSH = str;
        this.aSI = str2;
        this.aSJ = str3;
        this.aSK = str4;
    }
}

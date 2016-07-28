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
    private com.baidu.tieba.tbadkCore.y DR;
    private i aTA;
    private View aTB;
    private List<com.baidu.tieba.horizonalList.widget.l> aTC;
    private String aTD;
    private String aTE;
    private String aTF;
    private String aTG;
    private String aTH;
    private CustomMessageListener aTI;
    private CustomMessageListener aTJ;
    private HListView aTy;
    private com.baidu.tieba.horizonalList.widget.k aTz;
    private View.OnClickListener akQ;
    private LayoutInflater mInflater;
    private String stType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aTI = new q(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
        this.aTJ = new r(this, CmdConfigCustom.CMD_LIKE_FORUM);
        this.aTy = new HListView(getContext());
        this.aTy.setHeaderDividersEnabled(false);
        this.aTy.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.aTB = this.mInflater.inflate(u.h.extend_forum_item, (ViewGroup) null);
        this.aTA = new i(this.aTB);
        this.aSq.addView(this.aTy);
        this.aTy.setSelector(u.f.list_selector_transparent);
        this.aTy.setPadding(tbPageContext.getResources().getDimensionPixelSize(u.e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(u.e.ds4), 0);
        KS();
        if (this.aTz == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.aTz = new com.baidu.tieba.horizonalList.widget.k(getContext(), u.h.extend_forum_item, this.aTA);
            this.aTz.setOnClickListener(this.akQ);
            this.aTy.setAdapter((ListAdapter) this.aTz);
        }
        this.aSi.setOnClickListener(this);
        this.DR = new com.baidu.tieba.tbadkCore.y(tbPageContext);
        this.DR.setLoadDataCallBack(new s(this));
        this.aTy.setOnItemClickListener(null);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.aTI != null && this.aTJ != null) {
            this.aTI.setTag(bdUniqueId);
            this.aTJ.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aTI);
            MessageManager.getInstance().registerListener(this.aTJ);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.b
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.aTy != null && this.aTz != null) {
            this.aTz.cO(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.a.j jVar) {
        super.a((p) jVar);
        if (jVar == null || com.baidu.tbadk.core.util.y.s(jVar.Ea()) <= 0) {
            getView().setVisibility(8);
            return;
        }
        int s = com.baidu.tbadk.core.util.y.s(jVar.Ea());
        if (s > 10) {
            ArrayList arrayList = new ArrayList(jVar.Ea());
            jVar.Ea().clear();
            jVar.Ea().addAll(arrayList.subList(0, 10));
        }
        this.aTH = jVar.Ls();
        this.stType = jVar.getStType();
        if (!b(jVar.Ea(), this.aTC)) {
            boolean z = com.baidu.tbadk.core.util.y.s(jVar.Ea()) != com.baidu.tbadk.core.util.y.s(this.aTC);
            this.aTC = jVar.Ea();
            if (s <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.aTz != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.aTC.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.aTz = new com.baidu.tieba.horizonalList.widget.k(getContext(), u.h.extend_forum_item, this.aTA);
                    this.aTz.setData(this.aTC);
                    this.aTz.setOnClickListener(this.akQ);
                    this.aTy.setAdapter((ListAdapter) this.aTz);
                    d(KM(), TbadkCoreApplication.m10getInst().getSkinType());
                    return;
                }
                this.aTz.setData(this.aTC);
                this.aTz.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.a.e ha(String str) {
        if (com.baidu.tbadk.core.util.y.s(this.aTC) > 0) {
            for (com.baidu.tieba.horizonalList.widget.l lVar : this.aTC) {
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
        if (this.aTz != null) {
            this.aTz.setData(this.aTC);
            this.aTz.notifyDataSetChanged();
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

    private void KS() {
        this.akQ = new t(this);
    }

    public void i(String str, String str2, String str3, String str4) {
        this.aTD = str;
        this.aTE = str2;
        this.aTF = str3;
        this.aTG = str4;
    }
}

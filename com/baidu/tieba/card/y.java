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
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class y extends b<com.baidu.tieba.card.a.n> {
    private com.baidu.tieba.tbadkCore.w MY;
    private String aGe;
    private CustomMessageListener aGg;
    private CustomMessageListener aGh;
    private HListView aSQ;
    private com.baidu.tieba.horizonalList.widget.k aSR;
    private f aSS;
    private View aST;
    private List<com.baidu.tieba.horizonalList.widget.l> aSU;
    private String aSV;
    private String aSW;
    private String aSX;
    private String aSY;
    private View.OnClickListener anH;
    private LayoutInflater mInflater;
    private String stType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aGg = new z(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
        this.aGh = new aa(this, CmdConfigCustom.CMD_LIKE_FORUM);
        this.aSQ = new HListView(getContext());
        this.aSQ.setHeaderDividersEnabled(false);
        this.aSQ.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.aST = this.mInflater.inflate(t.h.extend_forum_item, (ViewGroup) null);
        this.aSS = new f(this.aST);
        this.aRx.addView(this.aSQ);
        this.aSQ.setSelector(t.f.list_selector_transparent);
        this.aSQ.setPadding(tbPageContext.getResources().getDimensionPixelSize(t.e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(t.e.ds4), 0);
        Ll();
        if (this.aSR == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.aSR = new com.baidu.tieba.horizonalList.widget.k(getContext(), t.h.extend_forum_item, this.aSS);
            this.aSR.setOnClickListener(this.anH);
            this.aSQ.setAdapter((ListAdapter) this.aSR);
        }
        this.aRp.setOnClickListener(this);
        this.MY = new com.baidu.tieba.tbadkCore.w(tbPageContext);
        this.MY.setLoadDataCallBack(new ab(this));
        this.aSQ.setOnItemClickListener(null);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.aGg != null && this.aGh != null) {
            this.aGg.setTag(bdUniqueId);
            this.aGh.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aGg);
            MessageManager.getInstance().registerListener(this.aGh);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.b
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.aSQ != null && this.aSR != null) {
            this.aSR.de(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.a.n nVar) {
        super.a((y) nVar);
        if (nVar == null || com.baidu.tbadk.core.util.y.p(nVar.FZ()) <= 0) {
            getView().setVisibility(8);
            return;
        }
        int p = com.baidu.tbadk.core.util.y.p(nVar.FZ());
        if (p > 10) {
            ArrayList arrayList = new ArrayList(nVar.FZ());
            nVar.FZ().clear();
            nVar.FZ().addAll(arrayList.subList(0, 10));
        }
        this.aSY = nVar.LL();
        this.stType = nVar.getStType();
        if (!b(nVar.FZ(), this.aSU)) {
            boolean z = com.baidu.tbadk.core.util.y.p(nVar.FZ()) != com.baidu.tbadk.core.util.y.p(this.aSU);
            this.aSU = nVar.FZ();
            if (p <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.aSR != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.aSU.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.aSR = new com.baidu.tieba.horizonalList.widget.k(getContext(), t.h.extend_forum_item, this.aSS);
                    this.aSR.setData(this.aSU);
                    this.aSR.setOnClickListener(this.anH);
                    this.aSQ.setAdapter((ListAdapter) this.aSR);
                    d(Lb(), TbadkCoreApplication.m411getInst().getSkinType());
                    return;
                }
                this.aSR.setData(this.aSU);
                this.aSR.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.a.f gZ(String str) {
        if (com.baidu.tbadk.core.util.y.p(this.aSU) > 0) {
            for (com.baidu.tieba.horizonalList.widget.l lVar : this.aSU) {
                if (lVar != null && (lVar instanceof com.baidu.tieba.card.a.f)) {
                    com.baidu.tieba.card.a.f fVar = (com.baidu.tieba.card.a.f) lVar;
                    if (String.valueOf(fVar.forumId).equals(str)) {
                        return fVar;
                    }
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, boolean z) {
        com.baidu.tieba.card.a.f gZ = gZ(String.valueOf(j));
        if (gZ != null) {
            gZ.isLiked = z;
        }
        if (this.aSR != null) {
            this.aSR.setData(this.aSU);
            this.aSR.notifyDataSetChanged();
        }
    }

    private boolean b(List<com.baidu.tieba.horizonalList.widget.l> list, List<com.baidu.tieba.horizonalList.widget.l> list2) {
        boolean z;
        if (com.baidu.tbadk.core.util.y.p(list) <= 0 || com.baidu.tbadk.core.util.y.p(list2) <= 0 || com.baidu.tbadk.core.util.y.p(list) != com.baidu.tbadk.core.util.y.p(list2)) {
            return false;
        }
        int i = 0;
        boolean z2 = true;
        while (i < com.baidu.tbadk.core.util.y.p(list)) {
            com.baidu.tieba.horizonalList.widget.l lVar = (com.baidu.tieba.horizonalList.widget.l) com.baidu.tbadk.core.util.y.b(list, i);
            com.baidu.tieba.horizonalList.widget.l lVar2 = (com.baidu.tieba.horizonalList.widget.l) com.baidu.tbadk.core.util.y.b(list2, i);
            if (lVar == null || !(lVar instanceof com.baidu.tieba.card.a.f) || lVar2 == null || !(lVar2 instanceof com.baidu.tieba.card.a.f)) {
                z = false;
            } else {
                com.baidu.tieba.card.a.f fVar = (com.baidu.tieba.card.a.f) lVar;
                com.baidu.tieba.card.a.f fVar2 = (com.baidu.tieba.card.a.f) lVar2;
                if (fVar.forumId != fVar2.forumId) {
                    z2 = false;
                }
                if (!fVar.forumAvatar.equals(fVar2.forumAvatar)) {
                    z2 = false;
                }
                z = !fVar.forumName.equals(fVar2.forumName) ? false : z2;
            }
            i++;
            z2 = z;
        }
        return z2;
    }

    private void Ll() {
        this.anH = new ac(this);
    }

    public void i(String str, String str2, String str3, String str4) {
        this.aSV = str;
        this.aGe = str2;
        this.aSW = str3;
        this.aSX = str4;
    }
}

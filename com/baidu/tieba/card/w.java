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
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class w extends b<com.baidu.tieba.card.a.m> {
    private com.baidu.tieba.tbadkCore.w MS;
    private String aEJ;
    private CustomMessageListener aEL;
    private CustomMessageListener aEM;
    private com.baidu.tieba.horizonalList.widget.k aPV;
    private com.baidu.tieba.horizonalList.widget.l aPW;
    private f aPX;
    private View aPY;
    private List<com.baidu.tieba.horizonalList.widget.m> aPZ;
    private String aQa;
    private String aQb;
    private String aQc;
    private String aQd;
    private View.OnClickListener anq;
    private LayoutInflater mInflater;
    private String stType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aEL = new x(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
        this.aEM = new y(this, CmdConfigCustom.CMD_LIKE_FORUM);
        this.aPV = new com.baidu.tieba.horizonalList.widget.k(getContext());
        this.aPV.setHeaderDividersEnabled(false);
        this.aPV.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.aPY = this.mInflater.inflate(t.h.extend_forum_item, (ViewGroup) null);
        this.aPX = new f(this.aPY);
        this.aOI.addView(this.aPV);
        this.aPV.setSelector(t.f.list_selector_transparent);
        this.aPV.setPadding(tbPageContext.getResources().getDimensionPixelSize(t.e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(t.e.ds4), 0);
        JT();
        if (this.aPW == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.aPW = new com.baidu.tieba.horizonalList.widget.l(getContext(), t.h.extend_forum_item, this.aPX, arrayList);
            this.aPW.setOnClickListener(this.anq);
            this.aPV.setAdapter((ListAdapter) this.aPW);
        }
        this.aOA.setOnClickListener(this);
        this.MS = new com.baidu.tieba.tbadkCore.w(tbPageContext);
        this.MS.setLoadDataCallBack(new z(this));
        this.aPV.setOnItemClickListener(null);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.aEL != null && this.aEM != null) {
            this.aEL.setTag(bdUniqueId);
            this.aEM.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aEL);
            MessageManager.getInstance().registerListener(this.aEM);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.b
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.aPV != null && this.aPW != null) {
            this.aPW.db(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.a.m mVar) {
        super.a((w) mVar);
        if (mVar == null || com.baidu.tbadk.core.util.x.o(mVar.Fm()) <= 0) {
            getView().setVisibility(8);
            return;
        }
        int o = com.baidu.tbadk.core.util.x.o(mVar.Fm());
        if (o > 10) {
            ArrayList arrayList = new ArrayList(mVar.Fm());
            mVar.Fm().clear();
            mVar.Fm().addAll(arrayList.subList(0, 10));
        }
        this.aQd = mVar.Kr();
        this.stType = mVar.getStType();
        if (!b(mVar.Fm(), this.aPZ)) {
            boolean z = com.baidu.tbadk.core.util.x.o(mVar.Fm()) != com.baidu.tbadk.core.util.x.o(this.aPZ);
            this.aPZ = mVar.Fm();
            if (o <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.aPW != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.aPZ.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.aPW = new com.baidu.tieba.horizonalList.widget.l(getContext(), t.h.extend_forum_item, this.aPX, arrayList2);
                    this.aPW.setData(this.aPZ);
                    this.aPW.setOnClickListener(this.anq);
                    this.aPV.setAdapter((ListAdapter) this.aPW);
                    d(JK(), TbadkCoreApplication.m411getInst().getSkinType());
                    return;
                }
                this.aPW.setData(this.aPZ);
                this.aPW.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.a.f gN(String str) {
        if (com.baidu.tbadk.core.util.x.o(this.aPZ) > 0) {
            for (com.baidu.tieba.horizonalList.widget.m mVar : this.aPZ) {
                if (mVar != null && (mVar instanceof com.baidu.tieba.card.a.f)) {
                    com.baidu.tieba.card.a.f fVar = (com.baidu.tieba.card.a.f) mVar;
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
        com.baidu.tieba.card.a.f gN = gN(String.valueOf(j));
        if (gN != null) {
            gN.isLiked = z;
        }
        if (this.aPW != null) {
            this.aPW.setData(this.aPZ);
            this.aPW.notifyDataSetChanged();
        }
    }

    private boolean b(List<com.baidu.tieba.horizonalList.widget.m> list, List<com.baidu.tieba.horizonalList.widget.m> list2) {
        boolean z;
        if (com.baidu.tbadk.core.util.x.o(list) <= 0 || com.baidu.tbadk.core.util.x.o(list2) <= 0 || com.baidu.tbadk.core.util.x.o(list) != com.baidu.tbadk.core.util.x.o(list2)) {
            return false;
        }
        int i = 0;
        boolean z2 = true;
        while (i < com.baidu.tbadk.core.util.x.o(list)) {
            com.baidu.tieba.horizonalList.widget.m mVar = (com.baidu.tieba.horizonalList.widget.m) com.baidu.tbadk.core.util.x.b(list, i);
            com.baidu.tieba.horizonalList.widget.m mVar2 = (com.baidu.tieba.horizonalList.widget.m) com.baidu.tbadk.core.util.x.b(list2, i);
            if (mVar == null || !(mVar instanceof com.baidu.tieba.card.a.f) || mVar2 == null || !(mVar2 instanceof com.baidu.tieba.card.a.f)) {
                z = false;
            } else {
                com.baidu.tieba.card.a.f fVar = (com.baidu.tieba.card.a.f) mVar;
                com.baidu.tieba.card.a.f fVar2 = (com.baidu.tieba.card.a.f) mVar2;
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

    private void JT() {
        this.anq = new aa(this);
    }

    public void i(String str, String str2, String str3, String str4) {
        this.aQa = str;
        this.aEJ = str2;
        this.aQb = str3;
        this.aQc = str4;
    }
}

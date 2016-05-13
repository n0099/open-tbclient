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
public class p extends b<com.baidu.tieba.card.a.i> {
    private com.baidu.tieba.tbadkCore.x Dp;
    private HListView aPg;
    private com.baidu.tieba.horizonalList.widget.k aPh;
    private i aPi;
    private View aPj;
    private List<com.baidu.tieba.horizonalList.widget.l> aPk;
    private String aPl;
    private String aPm;
    private String aPn;
    private String aPo;
    private String aPp;
    private CustomMessageListener aPq;
    private CustomMessageListener aPr;
    private View.OnClickListener ajv;
    private LayoutInflater mInflater;
    private String stType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aPq = new q(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
        this.aPr = new r(this, CmdConfigCustom.CMD_LIKE_FORUM);
        this.aPg = new HListView(getContext());
        this.aPg.setHeaderDividersEnabled(false);
        this.aPg.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.aPj = this.mInflater.inflate(t.h.extend_forum_item, (ViewGroup) null);
        this.aPi = new i(this.aPj);
        this.aNZ.addView(this.aPg);
        this.aPg.setSelector(t.f.list_selector_transparent);
        this.aPg.setPadding(tbPageContext.getResources().getDimensionPixelSize(t.e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(t.e.ds4), 0);
        JU();
        if (this.aPh == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.aPh = new com.baidu.tieba.horizonalList.widget.k(getContext(), t.h.extend_forum_item, this.aPi);
            this.aPh.setOnClickListener(this.ajv);
            this.aPg.setAdapter((ListAdapter) this.aPh);
        }
        this.aNR.setOnClickListener(this);
        this.Dp = new com.baidu.tieba.tbadkCore.x(tbPageContext);
        this.Dp.setLoadDataCallBack(new s(this));
        this.aPg.setOnItemClickListener(null);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.aPq != null && this.aPr != null) {
            this.aPq.setTag(bdUniqueId);
            this.aPr.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aPq);
            MessageManager.getInstance().registerListener(this.aPr);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.b
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.aPg != null && this.aPh != null) {
            this.aPh.cM(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.a.i iVar) {
        super.a((p) iVar);
        if (iVar == null || com.baidu.tbadk.core.util.y.r(iVar.DS()) <= 0) {
            getView().setVisibility(8);
            return;
        }
        int r = com.baidu.tbadk.core.util.y.r(iVar.DS());
        if (r > 10) {
            ArrayList arrayList = new ArrayList(iVar.DS());
            iVar.DS().clear();
            iVar.DS().addAll(arrayList.subList(0, 10));
        }
        this.aPp = iVar.Kw();
        this.stType = iVar.getStType();
        if (!b(iVar.DS(), this.aPk)) {
            boolean z = com.baidu.tbadk.core.util.y.r(iVar.DS()) != com.baidu.tbadk.core.util.y.r(this.aPk);
            this.aPk = iVar.DS();
            if (r <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.aPh != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.aPk.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.aPh = new com.baidu.tieba.horizonalList.widget.k(getContext(), t.h.extend_forum_item, this.aPi);
                    this.aPh.setData(this.aPk);
                    this.aPh.setOnClickListener(this.ajv);
                    this.aPg.setAdapter((ListAdapter) this.aPh);
                    d(getTbPageContext(), TbadkCoreApplication.m11getInst().getSkinType());
                    return;
                }
                this.aPh.setData(this.aPk);
                this.aPh.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.a.e ha(String str) {
        if (com.baidu.tbadk.core.util.y.r(this.aPk) > 0) {
            for (com.baidu.tieba.horizonalList.widget.l lVar : this.aPk) {
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
        if (this.aPh != null) {
            this.aPh.setData(this.aPk);
            this.aPh.notifyDataSetChanged();
        }
    }

    private boolean b(List<com.baidu.tieba.horizonalList.widget.l> list, List<com.baidu.tieba.horizonalList.widget.l> list2) {
        boolean z;
        if (com.baidu.tbadk.core.util.y.r(list) <= 0 || com.baidu.tbadk.core.util.y.r(list2) <= 0 || com.baidu.tbadk.core.util.y.r(list) != com.baidu.tbadk.core.util.y.r(list2)) {
            return false;
        }
        int i = 0;
        boolean z2 = true;
        while (i < com.baidu.tbadk.core.util.y.r(list)) {
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

    private void JU() {
        this.ajv = new t(this);
    }

    public void i(String str, String str2, String str3, String str4) {
        this.aPl = str;
        this.aPm = str2;
        this.aPn = str3;
        this.aPo = str4;
    }
}

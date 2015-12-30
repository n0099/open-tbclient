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
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class p extends b<com.baidu.tieba.card.a.j> {
    private com.baidu.tieba.tbadkCore.x MB;
    private String aDT;
    private CustomMessageListener aDV;
    private CustomMessageListener aDW;
    private com.baidu.tieba.horizonalList.widget.k aNS;
    private com.baidu.tieba.horizonalList.widget.l aNT;
    private c aNU;
    private View aNV;
    private List<com.baidu.tieba.horizonalList.widget.n> aNW;
    private String aNX;
    private String aNY;
    private String aNZ;
    private String aOa;
    private View.OnClickListener amx;
    private LayoutInflater mInflater;
    private String stType;

    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aDV = new q(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
        this.aDW = new r(this, CmdConfigCustom.CMD_LIKE_FORUM);
        this.aNS = new com.baidu.tieba.horizonalList.widget.k(getContext());
        this.aNS.setHeaderDividersEnabled(false);
        this.aNS.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.aNV = this.mInflater.inflate(n.h.extend_forum_item, (ViewGroup) null);
        this.aNU = new c(this.aNV);
        this.aNu.addView(this.aNS);
        this.aNS.setSelector(n.f.list_selector_transparent);
        this.aNS.setPadding(tbPageContext.getResources().getDimensionPixelSize(n.e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(n.e.ds4), 0);
        this.aNm.setOnClickListener(this);
        this.MB = new com.baidu.tieba.tbadkCore.x(tbPageContext);
        this.MB.setLoadDataCallBack(new s(this));
        Il();
        this.aNS.setOnItemClickListener(null);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.aDV != null && this.aDW != null) {
            this.aDV.setTag(bdUniqueId);
            this.aDW.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aDV);
            MessageManager.getInstance().registerListener(this.aDW);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.aNS != null && this.aNT != null) {
            this.aNT.cK(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.a.j jVar) {
        int i = 0;
        super.a((p) jVar);
        if (jVar == null || com.baidu.tbadk.core.util.y.l(jVar.DS()) <= 0) {
            getView().setVisibility(8);
            return;
        }
        int l = com.baidu.tbadk.core.util.y.l(jVar.DS());
        if (l > 10) {
            ArrayList arrayList = new ArrayList(jVar.DS());
            jVar.DS().clear();
            jVar.DS().addAll(arrayList.subList(0, 10));
        }
        this.aOa = jVar.Iy();
        this.stType = jVar.getStType();
        am.Iq().a(new av(this.aNX).aa("obj_param3", x.Im()));
        if (!b(jVar.DS(), this.aNW)) {
            boolean z = com.baidu.tbadk.core.util.y.l(jVar.DS()) != com.baidu.tbadk.core.util.y.l(this.aNW);
            this.aNW = jVar.DS();
            if (l <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.aNT == null) {
                ArrayList arrayList2 = new ArrayList();
                while (i < this.aNW.size()) {
                    arrayList2.add(String.valueOf(i));
                    i++;
                }
                this.aNT = new com.baidu.tieba.horizonalList.widget.l(getContext(), n.h.extend_forum_item, this.aNU, arrayList2);
                this.aNT.setData(this.aNW);
                this.aNT.setOnClickListener(this.amx);
                this.aNS.setAdapter((ListAdapter) this.aNT);
                onChangeSkinType(Ie(), TbadkCoreApplication.m411getInst().getSkinType());
            } else if (z) {
                ArrayList arrayList3 = new ArrayList();
                while (i < this.aNW.size()) {
                    arrayList3.add(String.valueOf(i));
                    i++;
                }
                this.aNT = new com.baidu.tieba.horizonalList.widget.l(getContext(), n.h.extend_forum_item, this.aNU, arrayList3);
                this.aNT.setData(this.aNW);
                this.aNT.setOnClickListener(this.amx);
                this.aNS.setAdapter((ListAdapter) this.aNT);
                onChangeSkinType(Ie(), TbadkCoreApplication.m411getInst().getSkinType());
            } else {
                this.aNT.setData(this.aNW);
                this.aNT.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.a.e gG(String str) {
        if (com.baidu.tbadk.core.util.y.l(this.aNW) > 0) {
            for (com.baidu.tieba.horizonalList.widget.n nVar : this.aNW) {
                if (nVar != null && (nVar instanceof com.baidu.tieba.card.a.e)) {
                    com.baidu.tieba.card.a.e eVar = (com.baidu.tieba.card.a.e) nVar;
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
        com.baidu.tieba.card.a.e gG = gG(String.valueOf(j));
        if (gG != null) {
            gG.isLiked = z;
        }
        if (this.aNT != null) {
            this.aNT.setData(this.aNW);
            this.aNT.notifyDataSetChanged();
        }
    }

    private boolean b(List<com.baidu.tieba.horizonalList.widget.n> list, List<com.baidu.tieba.horizonalList.widget.n> list2) {
        boolean z;
        if (com.baidu.tbadk.core.util.y.l(list) <= 0 || com.baidu.tbadk.core.util.y.l(list2) <= 0 || com.baidu.tbadk.core.util.y.l(list) != com.baidu.tbadk.core.util.y.l(list2)) {
            return false;
        }
        int i = 0;
        boolean z2 = true;
        while (i < com.baidu.tbadk.core.util.y.l(list)) {
            com.baidu.tieba.horizonalList.widget.n nVar = (com.baidu.tieba.horizonalList.widget.n) com.baidu.tbadk.core.util.y.b(list, i);
            com.baidu.tieba.horizonalList.widget.n nVar2 = (com.baidu.tieba.horizonalList.widget.n) com.baidu.tbadk.core.util.y.b(list2, i);
            if (nVar == null || !(nVar instanceof com.baidu.tieba.card.a.e) || nVar2 == null || !(nVar2 instanceof com.baidu.tieba.card.a.e)) {
                z = false;
            } else {
                com.baidu.tieba.card.a.e eVar = (com.baidu.tieba.card.a.e) nVar;
                com.baidu.tieba.card.a.e eVar2 = (com.baidu.tieba.card.a.e) nVar2;
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

    private void Il() {
        this.amx = new t(this);
    }

    public void h(String str, String str2, String str3, String str4) {
        this.aNX = str;
        this.aDT = str2;
        this.aNY = str3;
        this.aNZ = str4;
    }
}

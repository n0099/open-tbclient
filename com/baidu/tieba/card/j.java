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
public class j extends b<com.baidu.tieba.card.data.j> {
    private com.baidu.tieba.tbadkCore.x Ge;
    private HListView aYG;
    private com.baidu.tieba.horizonalList.widget.k aYH;
    private c aYI;
    private View aYJ;
    private List<com.baidu.tieba.horizonalList.widget.l> aYK;
    private String aYL;
    private String aYM;
    private String aYN;
    private String aYO;
    private String aYP;
    private CustomMessageListener aYQ;
    private CustomMessageListener aYR;
    private View.OnClickListener anX;
    private LayoutInflater mInflater;
    private String stType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aYQ = new k(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
        this.aYR = new l(this, CmdConfigCustom.CMD_LIKE_FORUM);
        this.aYG = new HListView(getContext());
        this.aYG.setHeaderDividersEnabled(false);
        this.aYG.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.aYJ = this.mInflater.inflate(t.h.extend_forum_item, (ViewGroup) null);
        this.aYI = new c(this.aYJ);
        this.aXR.addView(this.aYG);
        this.aYG.setSelector(t.f.list_selector_transparent);
        this.aYG.setPadding(tbPageContext.getResources().getDimensionPixelSize(t.e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(t.e.ds4), 0);
        Nu();
        if (this.aYH == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.aYH = new com.baidu.tieba.horizonalList.widget.k(getContext(), t.h.extend_forum_item, this.aYI);
            this.aYH.setOnClickListener(this.anX);
            this.aYG.setAdapter((ListAdapter) this.aYH);
        }
        this.aXJ.setOnClickListener(this);
        this.Ge = new com.baidu.tieba.tbadkCore.x(tbPageContext);
        this.Ge.setLoadDataCallBack(new m(this));
        this.aYG.setOnItemClickListener(null);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.aYQ != null && this.aYR != null) {
            this.aYQ.setTag(bdUniqueId);
            this.aYR.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aYQ);
            MessageManager.getInstance().registerListener(this.aYR);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.aYG != null && this.aYH != null) {
            this.aYH.dc(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.j jVar) {
        super.onBindDataToView((j) jVar);
        if (jVar == null || com.baidu.tbadk.core.util.y.s(jVar.Fu()) <= 0) {
            getView().setVisibility(8);
            return;
        }
        int s = com.baidu.tbadk.core.util.y.s(jVar.Fu());
        if (s > 10) {
            ArrayList arrayList = new ArrayList(jVar.Fu());
            jVar.Fu().clear();
            jVar.Fu().addAll(arrayList.subList(0, 10));
        }
        this.aYP = jVar.NW();
        this.stType = jVar.getStType();
        if (!b(jVar.Fu(), this.aYK)) {
            boolean z = com.baidu.tbadk.core.util.y.s(jVar.Fu()) != com.baidu.tbadk.core.util.y.s(this.aYK);
            this.aYK = jVar.Fu();
            if (s <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.aYH != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.aYK.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.aYH = new com.baidu.tieba.horizonalList.widget.k(getContext(), t.h.extend_forum_item, this.aYI);
                    this.aYH.setData(this.aYK);
                    this.aYH.setOnClickListener(this.anX);
                    this.aYG.setAdapter((ListAdapter) this.aYH);
                    onChangeSkinType(getTbPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
                    return;
                }
                this.aYH.setData(this.aYK);
                this.aYH.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.data.e hF(String str) {
        if (com.baidu.tbadk.core.util.y.s(this.aYK) > 0) {
            for (com.baidu.tieba.horizonalList.widget.l lVar : this.aYK) {
                if (lVar != null && (lVar instanceof com.baidu.tieba.card.data.e)) {
                    com.baidu.tieba.card.data.e eVar = (com.baidu.tieba.card.data.e) lVar;
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
        com.baidu.tieba.card.data.e hF = hF(String.valueOf(j));
        if (hF != null) {
            hF.isLiked = z;
        }
        if (this.aYH != null) {
            this.aYH.setData(this.aYK);
            this.aYH.notifyDataSetChanged();
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
            if (lVar == null || !(lVar instanceof com.baidu.tieba.card.data.e) || lVar2 == null || !(lVar2 instanceof com.baidu.tieba.card.data.e)) {
                z = false;
            } else {
                com.baidu.tieba.card.data.e eVar = (com.baidu.tieba.card.data.e) lVar;
                com.baidu.tieba.card.data.e eVar2 = (com.baidu.tieba.card.data.e) lVar2;
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

    private void Nu() {
        this.anX = new n(this);
    }

    public void j(String str, String str2, String str3, String str4) {
        this.aYL = str;
        this.aYM = str2;
        this.aYN = str3;
        this.aYO = str4;
    }
}

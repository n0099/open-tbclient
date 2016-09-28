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
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h extends b<com.baidu.tieba.card.data.j> {
    private com.baidu.tieba.tbadkCore.x Ge;
    private HListView aZa;
    private com.baidu.tieba.horizonalList.widget.k aZb;
    private c aZc;
    private View aZd;
    private List<com.baidu.tieba.horizonalList.widget.l> aZe;
    private String aZf;
    private String aZg;
    private String aZh;
    private String aZi;
    private String aZj;
    private CustomMessageListener aZk;
    private CustomMessageListener aZl;
    private View.OnClickListener anF;
    private LayoutInflater mInflater;
    private String stType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aZk = new i(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
        this.aZl = new j(this, CmdConfigCustom.CMD_LIKE_FORUM);
        this.aZa = new HListView(getContext());
        this.aZa.setHeaderDividersEnabled(false);
        this.aZa.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.aZd = this.mInflater.inflate(r.h.extend_forum_item, (ViewGroup) null);
        this.aZc = new c(this.aZd);
        this.aYv.addView(this.aZa);
        this.aZa.setSelector(r.f.list_selector_transparent);
        this.aZa.setPadding(tbPageContext.getResources().getDimensionPixelSize(r.e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(r.e.ds4), 0);
        NV();
        if (this.aZb == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.aZb = new com.baidu.tieba.horizonalList.widget.k(getContext(), r.h.extend_forum_item, this.aZc);
            this.aZb.setOnClickListener(this.anF);
            this.aZa.setAdapter((ListAdapter) this.aZb);
        }
        this.aYn.setOnClickListener(this);
        this.Ge = new com.baidu.tieba.tbadkCore.x(tbPageContext);
        this.Ge.setLoadDataCallBack(new k(this));
        this.aZa.setOnItemClickListener(null);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.aZk != null && this.aZl != null) {
            this.aZk.setTag(bdUniqueId);
            this.aZl.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aZk);
            MessageManager.getInstance().registerListener(this.aZl);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.aZa != null && this.aZb != null) {
            this.aZb.dc(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.j jVar) {
        super.onBindDataToView((h) jVar);
        if (jVar == null || com.baidu.tbadk.core.util.y.s(jVar.Ft()) <= 0) {
            getView().setVisibility(8);
            return;
        }
        int s = com.baidu.tbadk.core.util.y.s(jVar.Ft());
        if (s > 10) {
            ArrayList arrayList = new ArrayList(jVar.Ft());
            jVar.Ft().clear();
            jVar.Ft().addAll(arrayList.subList(0, 10));
        }
        this.aZj = jVar.Oy();
        this.stType = jVar.getStType();
        if (!d(jVar.Ft(), this.aZe)) {
            boolean z = com.baidu.tbadk.core.util.y.s(jVar.Ft()) != com.baidu.tbadk.core.util.y.s(this.aZe);
            this.aZe = jVar.Ft();
            if (s <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.aZb != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.aZe.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.aZb = new com.baidu.tieba.horizonalList.widget.k(getContext(), r.h.extend_forum_item, this.aZc);
                    this.aZb.setData(this.aZe);
                    this.aZb.setOnClickListener(this.anF);
                    this.aZa.setAdapter((ListAdapter) this.aZb);
                    onChangeSkinType(getTbPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
                    return;
                }
                this.aZb.setData(this.aZe);
                this.aZb.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.data.e hM(String str) {
        if (com.baidu.tbadk.core.util.y.s(this.aZe) > 0) {
            for (com.baidu.tieba.horizonalList.widget.l lVar : this.aZe) {
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
        com.baidu.tieba.card.data.e hM = hM(String.valueOf(j));
        if (hM != null) {
            hM.isLiked = z;
        }
        if (this.aZb != null) {
            this.aZb.setData(this.aZe);
            this.aZb.notifyDataSetChanged();
        }
    }

    private boolean d(List<com.baidu.tieba.horizonalList.widget.l> list, List<com.baidu.tieba.horizonalList.widget.l> list2) {
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

    private void NV() {
        this.anF = new l(this);
    }

    public void j(String str, String str2, String str3, String str4) {
        this.aZf = str;
        this.aZg = str2;
        this.aZh = str3;
        this.aZi = str4;
    }
}

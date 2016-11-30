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
    private com.baidu.tieba.tbadkCore.x Gg;
    private View.OnClickListener aoz;
    private HListView bcj;
    private com.baidu.tieba.horizonalList.widget.k bck;
    private c bcl;
    private View bcm;
    private List<com.baidu.tieba.horizonalList.widget.l> bcn;
    private String bco;
    private String bcp;
    private String bcq;
    private String bcr;
    private String bcs;
    private CustomMessageListener bct;
    private CustomMessageListener bcu;
    private LayoutInflater mInflater;
    private String stType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bct = new i(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
        this.bcu = new j(this, CmdConfigCustom.CMD_LIKE_FORUM);
        this.bcj = new HListView(getContext());
        this.bcj.setHeaderDividersEnabled(false);
        this.bcj.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.bcm = this.mInflater.inflate(r.h.extend_forum_item, (ViewGroup) null);
        this.bcl = new c(this.bcm);
        this.bbE.addView(this.bcj);
        this.bcj.setSelector(r.f.list_selector_transparent);
        this.bcj.setPadding(tbPageContext.getResources().getDimensionPixelSize(r.e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(r.e.ds4), 0);
        OY();
        if (this.bck == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.bck = new com.baidu.tieba.horizonalList.widget.k(getContext(), r.h.extend_forum_item, this.bcl);
            this.bck.setOnClickListener(this.aoz);
            this.bcj.setAdapter((ListAdapter) this.bck);
        }
        this.bbw.setOnClickListener(this);
        this.Gg = new com.baidu.tieba.tbadkCore.x(tbPageContext);
        this.Gg.setLoadDataCallBack(new k(this));
        this.bcj.setOnItemClickListener(null);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.bct != null && this.bcu != null) {
            this.bct.setTag(bdUniqueId);
            this.bcu.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bct);
            MessageManager.getInstance().registerListener(this.bcu);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.bcj != null && this.bck != null) {
            this.bck.dd(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.j jVar) {
        super.onBindDataToView((h) jVar);
        if (jVar == null || com.baidu.tbadk.core.util.x.s(jVar.Fy()) <= 0) {
            getView().setVisibility(8);
            return;
        }
        int s = com.baidu.tbadk.core.util.x.s(jVar.Fy());
        if (s > 10) {
            ArrayList arrayList = new ArrayList(jVar.Fy());
            jVar.Fy().clear();
            jVar.Fy().addAll(arrayList.subList(0, 10));
        }
        this.bcs = jVar.PB();
        this.stType = jVar.getStType();
        if (!d(jVar.Fy(), this.bcn)) {
            boolean z = com.baidu.tbadk.core.util.x.s(jVar.Fy()) != com.baidu.tbadk.core.util.x.s(this.bcn);
            this.bcn = jVar.Fy();
            if (s <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.bck != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.bcn.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.bck = new com.baidu.tieba.horizonalList.widget.k(getContext(), r.h.extend_forum_item, this.bcl);
                    this.bck.setData(this.bcn);
                    this.bck.setOnClickListener(this.aoz);
                    this.bcj.setAdapter((ListAdapter) this.bck);
                    onChangeSkinType(getTbPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
                    return;
                }
                this.bck.setData(this.bcn);
                this.bck.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.data.e hQ(String str) {
        if (com.baidu.tbadk.core.util.x.s(this.bcn) > 0) {
            for (com.baidu.tieba.horizonalList.widget.l lVar : this.bcn) {
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
        com.baidu.tieba.card.data.e hQ = hQ(String.valueOf(j));
        if (hQ != null) {
            hQ.isLiked = z;
        }
        if (this.bck != null) {
            this.bck.setData(this.bcn);
            this.bck.notifyDataSetChanged();
        }
    }

    private boolean d(List<com.baidu.tieba.horizonalList.widget.l> list, List<com.baidu.tieba.horizonalList.widget.l> list2) {
        boolean z;
        if (com.baidu.tbadk.core.util.x.s(list) <= 0 || com.baidu.tbadk.core.util.x.s(list2) <= 0 || com.baidu.tbadk.core.util.x.s(list) != com.baidu.tbadk.core.util.x.s(list2)) {
            return false;
        }
        int i = 0;
        boolean z2 = true;
        while (i < com.baidu.tbadk.core.util.x.s(list)) {
            com.baidu.tieba.horizonalList.widget.l lVar = (com.baidu.tieba.horizonalList.widget.l) com.baidu.tbadk.core.util.x.c(list, i);
            com.baidu.tieba.horizonalList.widget.l lVar2 = (com.baidu.tieba.horizonalList.widget.l) com.baidu.tbadk.core.util.x.c(list2, i);
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

    private void OY() {
        this.aoz = new l(this);
    }

    public void j(String str, String str2, String str3, String str4) {
        this.bco = str;
        this.bcp = str2;
        this.bcq = str3;
        this.bcr = str4;
    }
}

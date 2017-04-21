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
public class h extends b<com.baidu.tieba.card.data.i> {
    private View.OnClickListener asV;
    private HListView bue;
    private com.baidu.tieba.horizonalList.widget.k buf;
    private c bug;
    private View buh;
    private LikeModel bui;
    private List<com.baidu.tieba.horizonalList.widget.l> buj;
    private String buk;
    private String bul;
    private String bum;
    private String bun;
    private String buo;
    private CustomMessageListener bup;
    private CustomMessageListener buq;
    private LayoutInflater mInflater;
    private String stType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bup = new i(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
        this.buq = new j(this, CmdConfigCustom.CMD_LIKE_FORUM);
        this.bue = new HListView(getContext());
        this.bue.setHeaderDividersEnabled(false);
        this.bue.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.buh = this.mInflater.inflate(w.j.extend_forum_item, (ViewGroup) null);
        this.bug = new c(this.buh);
        this.btA.addView(this.bue);
        this.bue.setSelector(w.g.list_selector_transparent);
        this.bue.setPadding(tbPageContext.getResources().getDimensionPixelSize(w.f.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(w.f.ds4), 0);
        TJ();
        if (this.buf == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.buf = new com.baidu.tieba.horizonalList.widget.k(getContext(), w.j.extend_forum_item, this.bug);
            this.buf.setOnClickListener(this.asV);
            this.bue.setAdapter((ListAdapter) this.buf);
        }
        this.bts.setOnClickListener(this);
        this.bui = new LikeModel(tbPageContext);
        this.bui.setLoadDataCallBack(new k(this));
        this.bue.setOnItemClickListener(null);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.bup != null && this.buq != null) {
            this.bup.setTag(bdUniqueId);
            this.buq.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bup);
            MessageManager.getInstance().registerListener(this.buq);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.bue != null && this.buf != null) {
            this.buf.df(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.i iVar) {
        super.onBindDataToView((h) iVar);
        if (iVar == null || com.baidu.tbadk.core.util.x.p(iVar.getDataList()) <= 0) {
            getView().setVisibility(8);
            return;
        }
        int p = com.baidu.tbadk.core.util.x.p(iVar.getDataList());
        if (p > 10) {
            ArrayList arrayList = new ArrayList(iVar.getDataList());
            iVar.getDataList().clear();
            iVar.getDataList().addAll(arrayList.subList(0, 10));
        }
        this.buo = iVar.Ul();
        this.stType = iVar.getStType();
        if (!c(iVar.getDataList(), this.buj)) {
            boolean z = com.baidu.tbadk.core.util.x.p(iVar.getDataList()) != com.baidu.tbadk.core.util.x.p(this.buj);
            this.buj = iVar.getDataList();
            if (p <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.buf != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.buj.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.buf = new com.baidu.tieba.horizonalList.widget.k(getContext(), w.j.extend_forum_item, this.bug);
                    this.buf.setData(this.buj);
                    this.buf.setOnClickListener(this.asV);
                    this.bue.setAdapter((ListAdapter) this.buf);
                    onChangeSkinType(getTbPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
                    return;
                }
                this.buf.setData(this.buj);
                this.buf.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.data.e hY(String str) {
        if (com.baidu.tbadk.core.util.x.p(this.buj) > 0) {
            for (com.baidu.tieba.horizonalList.widget.l lVar : this.buj) {
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
        com.baidu.tieba.card.data.e hY = hY(String.valueOf(j));
        if (hY != null) {
            hY.isLiked = z;
        }
        if (this.buf != null) {
            this.buf.setData(this.buj);
            this.buf.notifyDataSetChanged();
        }
    }

    private boolean c(List<com.baidu.tieba.horizonalList.widget.l> list, List<com.baidu.tieba.horizonalList.widget.l> list2) {
        boolean z;
        if (com.baidu.tbadk.core.util.x.p(list) <= 0 || com.baidu.tbadk.core.util.x.p(list2) <= 0 || com.baidu.tbadk.core.util.x.p(list) != com.baidu.tbadk.core.util.x.p(list2)) {
            return false;
        }
        int i = 0;
        boolean z2 = true;
        while (i < com.baidu.tbadk.core.util.x.p(list)) {
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

    private void TJ() {
        this.asV = new l(this);
    }

    public void k(String str, String str2, String str3, String str4) {
        this.buk = str;
        this.bul = str2;
        this.bum = str3;
        this.bun = str4;
    }
}

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
public class h extends b<com.baidu.tieba.card.data.i> {
    private com.baidu.tieba.tbadkCore.w Gg;
    private View.OnClickListener aob;
    private CustomMessageListener bbA;
    private HListView bbp;
    private com.baidu.tieba.horizonalList.widget.k bbq;
    private c bbr;
    private View bbs;
    private List<com.baidu.tieba.horizonalList.widget.l> bbt;
    private String bbu;
    private String bbv;
    private String bbw;
    private String bbx;
    private String bby;
    private CustomMessageListener bbz;
    private LayoutInflater mInflater;
    private String stType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bbz = new i(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
        this.bbA = new j(this, CmdConfigCustom.CMD_LIKE_FORUM);
        this.bbp = new HListView(getContext());
        this.bbp.setHeaderDividersEnabled(false);
        this.bbp.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.bbs = this.mInflater.inflate(r.h.extend_forum_item, (ViewGroup) null);
        this.bbr = new c(this.bbs);
        this.baK.addView(this.bbp);
        this.bbp.setSelector(r.f.list_selector_transparent);
        this.bbp.setPadding(tbPageContext.getResources().getDimensionPixelSize(r.e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(r.e.ds4), 0);
        Ot();
        if (this.bbq == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.bbq = new com.baidu.tieba.horizonalList.widget.k(getContext(), r.h.extend_forum_item, this.bbr);
            this.bbq.setOnClickListener(this.aob);
            this.bbp.setAdapter((ListAdapter) this.bbq);
        }
        this.baC.setOnClickListener(this);
        this.Gg = new com.baidu.tieba.tbadkCore.w(tbPageContext);
        this.Gg.setLoadDataCallBack(new k(this));
        this.bbp.setOnItemClickListener(null);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.bbz != null && this.bbA != null) {
            this.bbz.setTag(bdUniqueId);
            this.bbA.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bbz);
            MessageManager.getInstance().registerListener(this.bbA);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.bbp != null && this.bbq != null) {
            this.bbq.df(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.i iVar) {
        super.onBindDataToView((h) iVar);
        if (iVar == null || com.baidu.tbadk.core.util.x.s(iVar.getDataList()) <= 0) {
            getView().setVisibility(8);
            return;
        }
        int s = com.baidu.tbadk.core.util.x.s(iVar.getDataList());
        if (s > 10) {
            ArrayList arrayList = new ArrayList(iVar.getDataList());
            iVar.getDataList().clear();
            iVar.getDataList().addAll(arrayList.subList(0, 10));
        }
        this.bby = iVar.OX();
        this.stType = iVar.getStType();
        if (!d(iVar.getDataList(), this.bbt)) {
            boolean z = com.baidu.tbadk.core.util.x.s(iVar.getDataList()) != com.baidu.tbadk.core.util.x.s(this.bbt);
            this.bbt = iVar.getDataList();
            if (s <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.bbq != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.bbt.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.bbq = new com.baidu.tieba.horizonalList.widget.k(getContext(), r.h.extend_forum_item, this.bbr);
                    this.bbq.setData(this.bbt);
                    this.bbq.setOnClickListener(this.aob);
                    this.bbp.setAdapter((ListAdapter) this.bbq);
                    onChangeSkinType(getTbPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
                    return;
                }
                this.bbq.setData(this.bbt);
                this.bbq.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.data.e hK(String str) {
        if (com.baidu.tbadk.core.util.x.s(this.bbt) > 0) {
            for (com.baidu.tieba.horizonalList.widget.l lVar : this.bbt) {
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
        com.baidu.tieba.card.data.e hK = hK(String.valueOf(j));
        if (hK != null) {
            hK.isLiked = z;
        }
        if (this.bbq != null) {
            this.bbq.setData(this.bbt);
            this.bbq.notifyDataSetChanged();
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

    private void Ot() {
        this.aob = new l(this);
    }

    public void j(String str, String str2, String str3, String str4) {
        this.bbu = str;
        this.bbv = str2;
        this.bbw = str3;
        this.bbx = str4;
    }
}

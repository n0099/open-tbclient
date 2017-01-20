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
import com.baidu.tieba.tbadkCore.LikeModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h extends b<com.baidu.tieba.card.data.i> {
    private LikeModel Fq;
    private View.OnClickListener ani;
    private HListView blc;
    private com.baidu.tieba.horizonalList.widget.k bld;
    private c ble;
    private View blf;
    private List<com.baidu.tieba.horizonalList.widget.l> blg;
    private String blh;
    private String bli;
    private String blj;
    private String blk;
    private String bll;
    private CustomMessageListener blm;
    private CustomMessageListener bln;
    private LayoutInflater mInflater;
    private String stType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.blm = new i(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
        this.bln = new j(this, CmdConfigCustom.CMD_LIKE_FORUM);
        this.blc = new HListView(getContext());
        this.blc.setHeaderDividersEnabled(false);
        this.blc.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.blf = this.mInflater.inflate(r.j.extend_forum_item, (ViewGroup) null);
        this.ble = new c(this.blf);
        this.bky.addView(this.blc);
        this.blc.setSelector(r.g.list_selector_transparent);
        this.blc.setPadding(tbPageContext.getResources().getDimensionPixelSize(r.f.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(r.f.ds4), 0);
        Rm();
        if (this.bld == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.bld = new com.baidu.tieba.horizonalList.widget.k(getContext(), r.j.extend_forum_item, this.ble);
            this.bld.setOnClickListener(this.ani);
            this.blc.setAdapter((ListAdapter) this.bld);
        }
        this.bkq.setOnClickListener(this);
        this.Fq = new LikeModel(tbPageContext);
        this.Fq.setLoadDataCallBack(new k(this));
        this.blc.setOnItemClickListener(null);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.blm != null && this.bln != null) {
            this.blm.setTag(bdUniqueId);
            this.bln.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.blm);
            MessageManager.getInstance().registerListener(this.bln);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.blc != null && this.bld != null) {
            this.bld.dg(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.i iVar) {
        super.onBindDataToView((h) iVar);
        if (iVar == null || com.baidu.tbadk.core.util.w.r(iVar.getDataList()) <= 0) {
            getView().setVisibility(8);
            return;
        }
        int r = com.baidu.tbadk.core.util.w.r(iVar.getDataList());
        if (r > 10) {
            ArrayList arrayList = new ArrayList(iVar.getDataList());
            iVar.getDataList().clear();
            iVar.getDataList().addAll(arrayList.subList(0, 10));
        }
        this.bll = iVar.RN();
        this.stType = iVar.getStType();
        if (!b(iVar.getDataList(), this.blg)) {
            boolean z = com.baidu.tbadk.core.util.w.r(iVar.getDataList()) != com.baidu.tbadk.core.util.w.r(this.blg);
            this.blg = iVar.getDataList();
            if (r <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.bld != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.blg.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.bld = new com.baidu.tieba.horizonalList.widget.k(getContext(), r.j.extend_forum_item, this.ble);
                    this.bld.setData(this.blg);
                    this.bld.setOnClickListener(this.ani);
                    this.blc.setAdapter((ListAdapter) this.bld);
                    onChangeSkinType(getTbPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
                    return;
                }
                this.bld.setData(this.blg);
                this.bld.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.data.e id(String str) {
        if (com.baidu.tbadk.core.util.w.r(this.blg) > 0) {
            for (com.baidu.tieba.horizonalList.widget.l lVar : this.blg) {
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
        com.baidu.tieba.card.data.e id = id(String.valueOf(j));
        if (id != null) {
            id.isLiked = z;
        }
        if (this.bld != null) {
            this.bld.setData(this.blg);
            this.bld.notifyDataSetChanged();
        }
    }

    private boolean b(List<com.baidu.tieba.horizonalList.widget.l> list, List<com.baidu.tieba.horizonalList.widget.l> list2) {
        boolean z;
        if (com.baidu.tbadk.core.util.w.r(list) <= 0 || com.baidu.tbadk.core.util.w.r(list2) <= 0 || com.baidu.tbadk.core.util.w.r(list) != com.baidu.tbadk.core.util.w.r(list2)) {
            return false;
        }
        int i = 0;
        boolean z2 = true;
        while (i < com.baidu.tbadk.core.util.w.r(list)) {
            com.baidu.tieba.horizonalList.widget.l lVar = (com.baidu.tieba.horizonalList.widget.l) com.baidu.tbadk.core.util.w.c(list, i);
            com.baidu.tieba.horizonalList.widget.l lVar2 = (com.baidu.tieba.horizonalList.widget.l) com.baidu.tbadk.core.util.w.c(list2, i);
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

    private void Rm() {
        this.ani = new l(this);
    }

    public void k(String str, String str2, String str3, String str4) {
        this.blh = str;
        this.bli = str2;
        this.blj = str3;
        this.blk = str4;
    }
}

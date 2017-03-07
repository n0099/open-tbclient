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
    private View.OnClickListener asD;
    private HListView brU;
    private com.baidu.tieba.horizonalList.widget.k brV;
    private c brW;
    private View brX;
    private LikeModel brY;
    private List<com.baidu.tieba.horizonalList.widget.l> brZ;
    private String bsa;
    private String bsb;
    private String bsc;
    private String bsd;
    private String bse;
    private CustomMessageListener bsf;
    private CustomMessageListener bsg;
    private LayoutInflater mInflater;
    private String stType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bsf = new i(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
        this.bsg = new j(this, CmdConfigCustom.CMD_LIKE_FORUM);
        this.brU = new HListView(getContext());
        this.brU.setHeaderDividersEnabled(false);
        this.brU.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.brX = this.mInflater.inflate(w.j.extend_forum_item, (ViewGroup) null);
        this.brW = new c(this.brX);
        this.brq.addView(this.brU);
        this.brU.setSelector(w.g.list_selector_transparent);
        this.brU.setPadding(tbPageContext.getResources().getDimensionPixelSize(w.f.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(w.f.ds4), 0);
        Sj();
        if (this.brV == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.brV = new com.baidu.tieba.horizonalList.widget.k(getContext(), w.j.extend_forum_item, this.brW);
            this.brV.setOnClickListener(this.asD);
            this.brU.setAdapter((ListAdapter) this.brV);
        }
        this.bri.setOnClickListener(this);
        this.brY = new LikeModel(tbPageContext);
        this.brY.setLoadDataCallBack(new k(this));
        this.brU.setOnItemClickListener(null);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.bsf != null && this.bsg != null) {
            this.bsf.setTag(bdUniqueId);
            this.bsg.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bsf);
            MessageManager.getInstance().registerListener(this.bsg);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.brU != null && this.brV != null) {
            this.brV.dc(i);
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
        this.bse = iVar.SL();
        this.stType = iVar.getStType();
        if (!c(iVar.getDataList(), this.brZ)) {
            boolean z = com.baidu.tbadk.core.util.x.p(iVar.getDataList()) != com.baidu.tbadk.core.util.x.p(this.brZ);
            this.brZ = iVar.getDataList();
            if (p <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.brV != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.brZ.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.brV = new com.baidu.tieba.horizonalList.widget.k(getContext(), w.j.extend_forum_item, this.brW);
                    this.brV.setData(this.brZ);
                    this.brV.setOnClickListener(this.asD);
                    this.brU.setAdapter((ListAdapter) this.brV);
                    onChangeSkinType(getTbPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
                    return;
                }
                this.brV.setData(this.brZ);
                this.brV.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.data.e hT(String str) {
        if (com.baidu.tbadk.core.util.x.p(this.brZ) > 0) {
            for (com.baidu.tieba.horizonalList.widget.l lVar : this.brZ) {
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
        com.baidu.tieba.card.data.e hT = hT(String.valueOf(j));
        if (hT != null) {
            hT.isLiked = z;
        }
        if (this.brV != null) {
            this.brV.setData(this.brZ);
            this.brV.notifyDataSetChanged();
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

    private void Sj() {
        this.asD = new l(this);
    }

    public void k(String str, String str2, String str3, String str4) {
        this.bsa = str;
        this.bsb = str2;
        this.bsc = str3;
        this.bsd = str4;
    }
}

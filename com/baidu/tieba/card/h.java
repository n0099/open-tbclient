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
    private View.OnClickListener asT;
    private HListView brM;
    private com.baidu.tieba.horizonalList.widget.k brN;
    private c brO;
    private View brP;
    private LikeModel brQ;
    private List<com.baidu.tieba.horizonalList.widget.l> brR;
    private String brS;
    private String brT;
    private String brU;
    private String brV;
    private String brW;
    private CustomMessageListener brX;
    private CustomMessageListener brY;
    private LayoutInflater mInflater;
    private String stType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.brX = new i(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
        this.brY = new j(this, CmdConfigCustom.CMD_LIKE_FORUM);
        this.brM = new HListView(getContext());
        this.brM.setHeaderDividersEnabled(false);
        this.brM.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.brP = this.mInflater.inflate(w.j.extend_forum_item, (ViewGroup) null);
        this.brO = new c(this.brP);
        this.bri.addView(this.brM);
        this.brM.setSelector(w.g.list_selector_transparent);
        this.brM.setPadding(tbPageContext.getResources().getDimensionPixelSize(w.f.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(w.f.ds4), 0);
        SH();
        if (this.brN == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.brN = new com.baidu.tieba.horizonalList.widget.k(getContext(), w.j.extend_forum_item, this.brO);
            this.brN.setOnClickListener(this.asT);
            this.brM.setAdapter((ListAdapter) this.brN);
        }
        this.bra.setOnClickListener(this);
        this.brQ = new LikeModel(tbPageContext);
        this.brQ.setLoadDataCallBack(new k(this));
        this.brM.setOnItemClickListener(null);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.brX != null && this.brY != null) {
            this.brX.setTag(bdUniqueId);
            this.brY.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.brX);
            MessageManager.getInstance().registerListener(this.brY);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.brM != null && this.brN != null) {
            this.brN.df(i);
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
        this.brW = iVar.Tj();
        this.stType = iVar.getStType();
        if (!c(iVar.getDataList(), this.brR)) {
            boolean z = com.baidu.tbadk.core.util.x.p(iVar.getDataList()) != com.baidu.tbadk.core.util.x.p(this.brR);
            this.brR = iVar.getDataList();
            if (p <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.brN != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.brR.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.brN = new com.baidu.tieba.horizonalList.widget.k(getContext(), w.j.extend_forum_item, this.brO);
                    this.brN.setData(this.brR);
                    this.brN.setOnClickListener(this.asT);
                    this.brM.setAdapter((ListAdapter) this.brN);
                    onChangeSkinType(getTbPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
                    return;
                }
                this.brN.setData(this.brR);
                this.brN.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.data.e hX(String str) {
        if (com.baidu.tbadk.core.util.x.p(this.brR) > 0) {
            for (com.baidu.tieba.horizonalList.widget.l lVar : this.brR) {
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
        com.baidu.tieba.card.data.e hX = hX(String.valueOf(j));
        if (hX != null) {
            hX.isLiked = z;
        }
        if (this.brN != null) {
            this.brN.setData(this.brR);
            this.brN.notifyDataSetChanged();
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

    private void SH() {
        this.asT = new l(this);
    }

    public void k(String str, String str2, String str3, String str4) {
        this.brS = str;
        this.brT = str2;
        this.brU = str3;
        this.brV = str4;
    }
}

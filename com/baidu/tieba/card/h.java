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
public class h extends b<com.baidu.tieba.card.data.g> {
    private View.OnClickListener asJ;
    private CustomMessageListener bAa;
    private HListView bzO;
    private com.baidu.tieba.horizonalList.widget.j bzP;
    private g bzQ;
    private View bzR;
    private LikeModel bzS;
    private List<com.baidu.tieba.horizonalList.widget.k> bzT;
    private String bzU;
    private String bzV;
    private String bzW;
    private String bzX;
    private String bzY;
    private CustomMessageListener bzZ;
    private LayoutInflater mInflater;
    private String stType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bzZ = new i(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
        this.bAa = new j(this, CmdConfigCustom.CMD_LIKE_FORUM);
        this.bzO = new HListView(getContext());
        this.bzO.setHeaderDividersEnabled(false);
        this.bzO.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.bzR = this.mInflater.inflate(w.j.extend_forum_item, (ViewGroup) null);
        this.bzQ = new g(this.bzR);
        this.bzz.addView(this.bzO);
        this.bzO.setSelector(w.g.list_selector_transparent);
        this.bzO.setPadding(tbPageContext.getResources().getDimensionPixelSize(w.f.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(w.f.ds4), 0);
        Uj();
        if (this.bzP == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.bzP = new com.baidu.tieba.horizonalList.widget.j(getContext(), w.j.extend_forum_item, this.bzQ);
            this.bzP.setOnClickListener(this.asJ);
            this.bzO.setAdapter((ListAdapter) this.bzP);
        }
        this.bzr.setOnClickListener(this);
        this.bzS = new LikeModel(tbPageContext);
        this.bzS.setLoadDataCallBack(new k(this));
        this.bzO.setOnItemClickListener(null);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.bzZ != null && this.bAa != null) {
            this.bzZ.setTag(bdUniqueId);
            this.bAa.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bzZ);
            MessageManager.getInstance().registerListener(this.bAa);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.bzO != null && this.bzP != null) {
            this.bzP.dc(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.g gVar) {
        super.a((h) gVar);
        if (gVar == null || com.baidu.tbadk.core.util.x.q(gVar.getDataList()) <= 0) {
            getView().setVisibility(8);
            return;
        }
        int q = com.baidu.tbadk.core.util.x.q(gVar.getDataList());
        if (q > 10) {
            ArrayList arrayList = new ArrayList(gVar.getDataList());
            gVar.getDataList().clear();
            gVar.getDataList().addAll(arrayList.subList(0, 10));
        }
        this.bzY = gVar.UI();
        this.stType = gVar.getStType();
        if (!e(gVar.getDataList(), this.bzT)) {
            boolean z = com.baidu.tbadk.core.util.x.q(gVar.getDataList()) != com.baidu.tbadk.core.util.x.q(this.bzT);
            this.bzT = gVar.getDataList();
            if (q <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.bzP != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.bzT.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.bzP = new com.baidu.tieba.horizonalList.widget.j(getContext(), w.j.extend_forum_item, this.bzQ);
                    this.bzP.setData(this.bzT);
                    this.bzP.setOnClickListener(this.asJ);
                    this.bzO.setAdapter((ListAdapter) this.bzP);
                    d(Uc(), TbadkCoreApplication.m9getInst().getSkinType());
                    return;
                }
                this.bzP.setData(this.bzT);
                this.bzP.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.data.e ia(String str) {
        if (com.baidu.tbadk.core.util.x.q(this.bzT) > 0) {
            for (com.baidu.tieba.horizonalList.widget.k kVar : this.bzT) {
                if (kVar != null && (kVar instanceof com.baidu.tieba.card.data.e)) {
                    com.baidu.tieba.card.data.e eVar = (com.baidu.tieba.card.data.e) kVar;
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
        com.baidu.tieba.card.data.e ia = ia(String.valueOf(j));
        if (ia != null) {
            ia.isLiked = z;
        }
        if (this.bzP != null) {
            this.bzP.setData(this.bzT);
            this.bzP.notifyDataSetChanged();
        }
    }

    private boolean e(List<com.baidu.tieba.horizonalList.widget.k> list, List<com.baidu.tieba.horizonalList.widget.k> list2) {
        boolean z;
        if (com.baidu.tbadk.core.util.x.q(list) <= 0 || com.baidu.tbadk.core.util.x.q(list2) <= 0 || com.baidu.tbadk.core.util.x.q(list) != com.baidu.tbadk.core.util.x.q(list2)) {
            return false;
        }
        int i = 0;
        boolean z2 = true;
        while (i < com.baidu.tbadk.core.util.x.q(list)) {
            com.baidu.tieba.horizonalList.widget.k kVar = (com.baidu.tieba.horizonalList.widget.k) com.baidu.tbadk.core.util.x.c(list, i);
            com.baidu.tieba.horizonalList.widget.k kVar2 = (com.baidu.tieba.horizonalList.widget.k) com.baidu.tbadk.core.util.x.c(list2, i);
            if (kVar == null || !(kVar instanceof com.baidu.tieba.card.data.e) || kVar2 == null || !(kVar2 instanceof com.baidu.tieba.card.data.e)) {
                z = false;
            } else {
                com.baidu.tieba.card.data.e eVar = (com.baidu.tieba.card.data.e) kVar;
                com.baidu.tieba.card.data.e eVar2 = (com.baidu.tieba.card.data.e) kVar2;
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

    private void Uj() {
        this.asJ = new l(this);
    }

    public void l(String str, String str2, String str3, String str4) {
        this.bzU = str;
        this.bzV = str2;
        this.bzW = str3;
        this.bzX = str4;
    }
}

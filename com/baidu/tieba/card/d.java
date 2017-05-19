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
public class d extends b<com.baidu.tieba.card.data.g> {
    private View.OnClickListener asZ;
    private HListView bua;
    private com.baidu.tieba.horizonalList.widget.j bub;
    private c buc;
    private View bud;
    private LikeModel bue;
    private List<com.baidu.tieba.horizonalList.widget.k> buf;
    private String bug;
    private String buh;
    private String bui;
    private String buj;
    private String buk;
    private CustomMessageListener bul;
    private CustomMessageListener bum;
    private LayoutInflater mInflater;
    private String stType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bul = new e(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
        this.bum = new f(this, CmdConfigCustom.CMD_LIKE_FORUM);
        this.bua = new HListView(getContext());
        this.bua.setHeaderDividersEnabled(false);
        this.bua.setFooterDividersEnabled(false);
        this.mInflater = LayoutInflater.from(getContext());
        this.bud = this.mInflater.inflate(w.j.extend_forum_item, (ViewGroup) null);
        this.buc = new c(this.bud);
        this.btT.addView(this.bua);
        this.bua.setSelector(w.g.list_selector_transparent);
        this.bua.setPadding(tbPageContext.getResources().getDimensionPixelSize(w.f.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(w.f.ds4), 0);
        Tc();
        if (this.bub == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(String.valueOf(i));
            }
            this.bub = new com.baidu.tieba.horizonalList.widget.j(getContext(), w.j.extend_forum_item, this.buc);
            this.bub.setOnClickListener(this.asZ);
            this.bua.setAdapter((ListAdapter) this.bub);
        }
        this.btL.setOnClickListener(this);
        this.bue = new LikeModel(tbPageContext);
        this.bue.setLoadDataCallBack(new g(this));
        this.bua.setOnItemClickListener(null);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.bul != null && this.bum != null) {
            this.bul.setTag(bdUniqueId);
            this.bum.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bul);
            MessageManager.getInstance().registerListener(this.bum);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setFrom(String str) {
        super.setFrom(str);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.bua != null && this.bub != null) {
            this.bub.db(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.g gVar) {
        super.onBindDataToView((d) gVar);
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
        this.buk = gVar.TE();
        this.stType = gVar.getStType();
        if (!c(gVar.getDataList(), this.buf)) {
            boolean z = com.baidu.tbadk.core.util.x.q(gVar.getDataList()) != com.baidu.tbadk.core.util.x.q(this.buf);
            this.buf = gVar.getDataList();
            if (q <= 0) {
                getView().setVisibility(8);
                return;
            }
            getView().setVisibility(0);
            if (this.bub != null) {
                if (z) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < this.buf.size(); i++) {
                        arrayList2.add(String.valueOf(i));
                    }
                    this.bub = new com.baidu.tieba.horizonalList.widget.j(getContext(), w.j.extend_forum_item, this.buc);
                    this.bub.setData(this.buf);
                    this.bub.setOnClickListener(this.asZ);
                    this.bua.setAdapter((ListAdapter) this.bub);
                    onChangeSkinType(getTbPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
                    return;
                }
                this.bub.setData(this.buf);
                this.bub.notifyDataSetChanged();
            }
        }
    }

    private com.baidu.tieba.card.data.e hX(String str) {
        if (com.baidu.tbadk.core.util.x.q(this.buf) > 0) {
            for (com.baidu.tieba.horizonalList.widget.k kVar : this.buf) {
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
        com.baidu.tieba.card.data.e hX = hX(String.valueOf(j));
        if (hX != null) {
            hX.isLiked = z;
        }
        if (this.bub != null) {
            this.bub.setData(this.buf);
            this.bub.notifyDataSetChanged();
        }
    }

    private boolean c(List<com.baidu.tieba.horizonalList.widget.k> list, List<com.baidu.tieba.horizonalList.widget.k> list2) {
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

    private void Tc() {
        this.asZ = new h(this);
    }

    public void k(String str, String str2, String str3, String str4) {
        this.bug = str;
        this.buh = str2;
        this.bui = str3;
        this.buj = str4;
    }
}

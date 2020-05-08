package com.baidu.tieba.ala.alasquare.live.a;

import android.widget.BaseAdapter;
import com.baidu.adp.base.e;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.ala.square.IAlaSquareTabController;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.subtablist.c.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private final List<com.baidu.adp.widget.ListView.a> aMj = new ArrayList();
    private e dvg;
    private BdTypeListView eOj;
    private a eOk;
    private com.baidu.tieba.ala.alasquare.subtablist.a.a eOl;
    private com.baidu.tieba.ala.alasquare.subtablist.a.b eOm;

    public b(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.dvg = tbPageContext;
        this.eOj = bdTypeListView;
        BB();
    }

    private void BB() {
        this.eOm = new com.baidu.tieba.ala.alasquare.subtablist.a.b((TbPageContext) this.dvg);
        this.eOm.setFrom(1);
        this.eOl = new com.baidu.tieba.ala.alasquare.subtablist.a.a((TbPageContext) this.dvg);
        this.eOl.setFrom(1);
        this.eOk = new a((TbPageContext) this.dvg, com.baidu.tieba.ala.alasquare.live.b.b.eOq);
        this.aMj.add(this.eOm);
        this.aMj.add(this.eOl);
        this.aMj.add(this.eOk);
        this.eOj.addAdapters(this.aMj);
    }

    public void setDatas(List<m> list) {
        if (this.eOj != null) {
            this.eOj.setData(list);
        }
    }

    public void oW(int i) {
        this.eOm.oW(i);
        this.eOl.oW(i);
    }

    public void notifyDataSetChanged() {
        if (this.eOj != null && (this.eOj.getAdapter() instanceof BaseAdapter)) {
            this.eOj.getAdapter().notifyDataSetChanged();
        }
    }

    public void a(IAlaSquareTabController iAlaSquareTabController) {
        this.eOk.a(iAlaSquareTabController);
    }

    public void a(i iVar) {
        this.eOm.b(iVar);
        this.eOl.b(iVar);
    }
}

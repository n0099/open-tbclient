package com.baidu.tieba.ala.alasquare.live.a;

import android.widget.BaseAdapter;
import com.baidu.adp.base.e;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.ala.square.IAlaSquareTabController;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.subtablist.c.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    private final List<com.baidu.adp.widget.ListView.a> bky = new ArrayList();
    private e eIz;
    private BdTypeListView gih;
    private a gii;
    private com.baidu.tieba.ala.alasquare.subtablist.a.a gij;
    private com.baidu.tieba.ala.alasquare.subtablist.a.b gik;

    public b(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.eIz = tbPageContext;
        this.gih = bdTypeListView;
        LY();
    }

    private void LY() {
        this.gik = new com.baidu.tieba.ala.alasquare.subtablist.a.b((TbPageContext) this.eIz);
        this.gik.setFrom(1);
        this.gij = new com.baidu.tieba.ala.alasquare.subtablist.a.a((TbPageContext) this.eIz);
        this.gij.setFrom(1);
        this.gii = new a((TbPageContext) this.eIz, com.baidu.tieba.ala.alasquare.live.b.b.gio);
        this.bky.add(this.gik);
        this.bky.add(this.gij);
        this.bky.add(this.gii);
        this.gih.addAdapters(this.bky);
    }

    public void setDatas(List<q> list) {
        if (this.gih != null) {
            this.gih.setData(list);
        }
    }

    public void tS(int i) {
        this.gik.tS(i);
        this.gij.tS(i);
    }

    public void notifyDataSetChanged() {
        if (this.gih != null && (this.gih.getAdapter() instanceof BaseAdapter)) {
            this.gih.getAdapter().notifyDataSetChanged();
        }
    }

    public void a(IAlaSquareTabController iAlaSquareTabController) {
        this.gii.a(iAlaSquareTabController);
    }

    public void a(i iVar) {
        this.gik.b(iVar);
        this.gij.b(iVar);
    }
}

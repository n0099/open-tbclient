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
/* loaded from: classes6.dex */
public class b {
    private final List<com.baidu.adp.widget.ListView.a> bnf = new ArrayList();
    private e eNZ;
    private BdTypeListView gpX;
    private a gpY;
    private com.baidu.tieba.ala.alasquare.subtablist.a.a gpZ;
    private com.baidu.tieba.ala.alasquare.subtablist.a.b gqa;

    public b(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.eNZ = tbPageContext;
        this.gpX = bdTypeListView;
        Nt();
    }

    private void Nt() {
        this.gqa = new com.baidu.tieba.ala.alasquare.subtablist.a.b((TbPageContext) this.eNZ);
        this.gqa.setFrom(1);
        this.gpZ = new com.baidu.tieba.ala.alasquare.subtablist.a.a((TbPageContext) this.eNZ);
        this.gpZ.setFrom(1);
        this.gpY = new a((TbPageContext) this.eNZ, com.baidu.tieba.ala.alasquare.live.b.b.gqe);
        this.bnf.add(this.gqa);
        this.bnf.add(this.gpZ);
        this.bnf.add(this.gpY);
        this.gpX.addAdapters(this.bnf);
    }

    public void setDatas(List<q> list) {
        if (this.gpX != null) {
            this.gpX.setData(list);
        }
    }

    public void uU(int i) {
        this.gqa.uU(i);
        this.gpZ.uU(i);
    }

    public void notifyDataSetChanged() {
        if (this.gpX != null && (this.gpX.getAdapter() instanceof BaseAdapter)) {
            this.gpX.getAdapter().notifyDataSetChanged();
        }
    }

    public void a(IAlaSquareTabController iAlaSquareTabController) {
        this.gpY.a(iAlaSquareTabController);
    }

    public void a(i iVar) {
        this.gqa.b(iVar);
        this.gpZ.b(iVar);
    }
}

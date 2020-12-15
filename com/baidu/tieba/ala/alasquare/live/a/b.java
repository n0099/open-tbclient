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
    private BdTypeListView gpZ;
    private a gqa;
    private com.baidu.tieba.ala.alasquare.subtablist.a.a gqb;
    private com.baidu.tieba.ala.alasquare.subtablist.a.b gqc;

    public b(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.eNZ = tbPageContext;
        this.gpZ = bdTypeListView;
        Nt();
    }

    private void Nt() {
        this.gqc = new com.baidu.tieba.ala.alasquare.subtablist.a.b((TbPageContext) this.eNZ);
        this.gqc.setFrom(1);
        this.gqb = new com.baidu.tieba.ala.alasquare.subtablist.a.a((TbPageContext) this.eNZ);
        this.gqb.setFrom(1);
        this.gqa = new a((TbPageContext) this.eNZ, com.baidu.tieba.ala.alasquare.live.b.b.gqg);
        this.bnf.add(this.gqc);
        this.bnf.add(this.gqb);
        this.bnf.add(this.gqa);
        this.gpZ.addAdapters(this.bnf);
    }

    public void setDatas(List<q> list) {
        if (this.gpZ != null) {
            this.gpZ.setData(list);
        }
    }

    public void uU(int i) {
        this.gqc.uU(i);
        this.gqb.uU(i);
    }

    public void notifyDataSetChanged() {
        if (this.gpZ != null && (this.gpZ.getAdapter() instanceof BaseAdapter)) {
            this.gpZ.getAdapter().notifyDataSetChanged();
        }
    }

    public void a(IAlaSquareTabController iAlaSquareTabController) {
        this.gqa.a(iAlaSquareTabController);
    }

    public void a(i iVar) {
        this.gqc.b(iVar);
        this.gqb.b(iVar);
    }
}

package com.baidu.tieba.ala.alasquare.live.a;

import android.widget.BaseAdapter;
import com.baidu.adp.base.e;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.o;
import com.baidu.ala.square.IAlaSquareTabController;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.subtablist.c.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private final List<com.baidu.adp.widget.ListView.a> aSj = new ArrayList();
    private e dJb;
    private BdTypeListView faQ;
    private a faR;
    private com.baidu.tieba.ala.alasquare.subtablist.a.a faS;
    private com.baidu.tieba.ala.alasquare.subtablist.a.b faT;

    public b(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.dJb = tbPageContext;
        this.faQ = bdTypeListView;
        CY();
    }

    private void CY() {
        this.faT = new com.baidu.tieba.ala.alasquare.subtablist.a.b((TbPageContext) this.dJb);
        this.faT.setFrom(1);
        this.faS = new com.baidu.tieba.ala.alasquare.subtablist.a.a((TbPageContext) this.dJb);
        this.faS.setFrom(1);
        this.faR = new a((TbPageContext) this.dJb, com.baidu.tieba.ala.alasquare.live.b.b.faX);
        this.aSj.add(this.faT);
        this.aSj.add(this.faS);
        this.aSj.add(this.faR);
        this.faQ.addAdapters(this.aSj);
    }

    public void setDatas(List<o> list) {
        if (this.faQ != null) {
            this.faQ.setData(list);
        }
    }

    public void px(int i) {
        this.faT.px(i);
        this.faS.px(i);
    }

    public void notifyDataSetChanged() {
        if (this.faQ != null && (this.faQ.getAdapter() instanceof BaseAdapter)) {
            this.faQ.getAdapter().notifyDataSetChanged();
        }
    }

    public void a(IAlaSquareTabController iAlaSquareTabController) {
        this.faR.a(iAlaSquareTabController);
    }

    public void a(i iVar) {
        this.faT.b(iVar);
        this.faS.b(iVar);
    }
}

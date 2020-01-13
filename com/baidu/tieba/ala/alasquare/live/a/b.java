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
/* loaded from: classes2.dex */
public class b {
    private final List<com.baidu.adp.widget.ListView.a> apl = new ArrayList();
    private e cRA;
    private BdTypeListView efW;
    private a efX;
    private com.baidu.tieba.ala.alasquare.subtablist.a.a efY;
    private com.baidu.tieba.ala.alasquare.subtablist.a.b efZ;

    public b(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.cRA = tbPageContext;
        this.efW = bdTypeListView;
        vi();
    }

    private void vi() {
        this.efZ = new com.baidu.tieba.ala.alasquare.subtablist.a.b((TbPageContext) this.cRA);
        this.efZ.setFrom(1);
        this.efY = new com.baidu.tieba.ala.alasquare.subtablist.a.a((TbPageContext) this.cRA);
        this.efY.setFrom(1);
        this.efX = new a((TbPageContext) this.cRA, com.baidu.tieba.ala.alasquare.live.b.b.egd);
        this.apl.add(this.efZ);
        this.apl.add(this.efY);
        this.apl.add(this.efX);
        this.efW.addAdapters(this.apl);
    }

    public void setDatas(List<m> list) {
        if (this.efW != null) {
            this.efW.setData(list);
        }
    }

    public void ok(int i) {
        this.efZ.ok(i);
        this.efY.ok(i);
    }

    public void notifyDataSetChanged() {
        if (this.efW != null && (this.efW.getAdapter() instanceof BaseAdapter)) {
            this.efW.getAdapter().notifyDataSetChanged();
        }
    }

    public void a(IAlaSquareTabController iAlaSquareTabController) {
        this.efX.a(iAlaSquareTabController);
    }

    public void a(i iVar) {
        this.efZ.b(iVar);
        this.efY.b(iVar);
    }
}

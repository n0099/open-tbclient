package com.baidu.tieba.ala.person.hosttabpanel.a;

import com.baidu.live.adp.widget.listview.AbsDelegateAdapter;
import com.baidu.live.adp.widget.listview.BdTypeListView;
import com.baidu.live.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<AbsDelegateAdapter> apl = new ArrayList();
    private BdTypeListView apn;
    private b fnX;
    private c fnY;
    private e fnZ;
    private f foa;
    private d fob;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView) {
        this.mPageContext = tbPageContext;
        this.apn = bdTypeListView;
        vi();
    }

    private void vi() {
        this.fnX = new b(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.a.foe);
        this.fnY = new c(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.b.foh);
        this.fnZ = new e(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.d.foj);
        this.foa = new f(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.e.fok);
        this.fob = new d(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.c.foi);
        this.apl.add(this.fnX);
        this.apl.add(this.fnY);
        this.apl.add(this.fnZ);
        this.apl.add(this.foa);
        this.apl.add(this.fob);
        this.apn.addAdapters(this.apl);
    }

    public void onDestroy() {
        if (this.fnX != null) {
            this.fnX.onDestroy();
        }
        if (this.fnY != null) {
            this.fnY.onDestroy();
        }
    }
}

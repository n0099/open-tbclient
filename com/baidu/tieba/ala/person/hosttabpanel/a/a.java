package com.baidu.tieba.ala.person.hosttabpanel.a;

import com.baidu.live.adp.widget.listview.AbsDelegateAdapter;
import com.baidu.live.adp.widget.listview.BdTypeListView;
import com.baidu.live.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private List<AbsDelegateAdapter> aMd = new ArrayList();
    private BdTypeListView aMf;
    private b fVK;
    private c fVL;
    private e fVM;
    private f fVN;
    private d fVO;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView) {
        this.mPageContext = tbPageContext;
        this.aMf = bdTypeListView;
        BC();
    }

    private void BC() {
        this.fVK = new b(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.a.fVR);
        this.fVL = new c(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.b.fVU);
        this.fVM = new e(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.d.fVW);
        this.fVN = new f(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.e.fVX);
        this.fVO = new d(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.c.fVV);
        this.aMd.add(this.fVK);
        this.aMd.add(this.fVL);
        this.aMd.add(this.fVM);
        this.aMd.add(this.fVN);
        this.aMd.add(this.fVO);
        this.aMf.addAdapters(this.aMd);
    }

    public void onDestroy() {
        if (this.fVK != null) {
            this.fVK.onDestroy();
        }
        if (this.fVL != null) {
            this.fVL.onDestroy();
        }
    }
}

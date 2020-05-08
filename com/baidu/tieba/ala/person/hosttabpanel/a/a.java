package com.baidu.tieba.ala.person.hosttabpanel.a;

import com.baidu.live.adp.widget.listview.AbsDelegateAdapter;
import com.baidu.live.adp.widget.listview.BdTypeListView;
import com.baidu.live.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private List<AbsDelegateAdapter> aMj = new ArrayList();
    private BdTypeListView aMl;
    private b fVP;
    private c fVQ;
    private e fVR;
    private f fVS;
    private d fVT;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView) {
        this.mPageContext = tbPageContext;
        this.aMl = bdTypeListView;
        BB();
    }

    private void BB() {
        this.fVP = new b(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.a.fVW);
        this.fVQ = new c(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.b.fVZ);
        this.fVR = new e(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.d.fWb);
        this.fVS = new f(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.e.fWc);
        this.fVT = new d(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.c.fWa);
        this.aMj.add(this.fVP);
        this.aMj.add(this.fVQ);
        this.aMj.add(this.fVR);
        this.aMj.add(this.fVS);
        this.aMj.add(this.fVT);
        this.aMl.addAdapters(this.aMj);
    }

    public void onDestroy() {
        if (this.fVP != null) {
            this.fVP.onDestroy();
        }
        if (this.fVQ != null) {
            this.fVQ.onDestroy();
        }
    }
}

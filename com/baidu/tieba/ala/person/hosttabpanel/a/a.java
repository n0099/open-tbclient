package com.baidu.tieba.ala.person.hosttabpanel.a;

import com.baidu.live.adp.widget.listview.AbsDelegateAdapter;
import com.baidu.live.adp.widget.listview.BdTypeListView;
import com.baidu.live.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    private List<AbsDelegateAdapter> boM = new ArrayList();
    private BdTypeListView boO;
    private b hVM;
    private c hVN;
    private e hVO;
    private f hVP;
    private d hVQ;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView) {
        this.mPageContext = tbPageContext;
        this.boO = bdTypeListView;
        MT();
    }

    private void MT() {
        this.hVM = new b(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.a.hVT);
        this.hVN = new c(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.b.hVW);
        this.hVO = new e(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.d.hVY);
        this.hVP = new f(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.e.hVZ);
        this.hVQ = new d(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.c.hVX);
        this.boM.add(this.hVM);
        this.boM.add(this.hVN);
        this.boM.add(this.hVO);
        this.boM.add(this.hVP);
        this.boM.add(this.hVQ);
        this.boO.addAdapters(this.boM);
    }

    public void onDestroy() {
        if (this.hVM != null) {
            this.hVM.onDestroy();
        }
        if (this.hVN != null) {
            this.hVN.onDestroy();
        }
    }
}

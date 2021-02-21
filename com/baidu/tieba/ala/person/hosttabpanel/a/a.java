package com.baidu.tieba.ala.person.hosttabpanel.a;

import com.baidu.live.adp.widget.listview.AbsDelegateAdapter;
import com.baidu.live.adp.widget.listview.BdTypeListView;
import com.baidu.live.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    private List<AbsDelegateAdapter> bns = new ArrayList();
    private BdTypeListView bnu;
    private b hVO;
    private c hVP;
    private e hVQ;
    private f hVR;
    private d hVS;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView) {
        this.mPageContext = tbPageContext;
        this.bnu = bdTypeListView;
        Kw();
    }

    private void Kw() {
        this.hVO = new b(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.a.hVV);
        this.hVP = new c(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.b.hVY);
        this.hVQ = new e(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.d.hWa);
        this.hVR = new f(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.e.hWb);
        this.hVS = new d(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.c.hVZ);
        this.bns.add(this.hVO);
        this.bns.add(this.hVP);
        this.bns.add(this.hVQ);
        this.bns.add(this.hVR);
        this.bns.add(this.hVS);
        this.bnu.addAdapters(this.bns);
    }

    public void onDestroy() {
        if (this.hVO != null) {
            this.hVO.onDestroy();
        }
        if (this.hVP != null) {
            this.hVP.onDestroy();
        }
    }
}

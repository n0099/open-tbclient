package com.baidu.tieba.homepage.hotTopic.tab.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.w;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class h {
    private List<com.baidu.adp.widget.ListView.a> bbw;
    private v hyr;
    private g iLE;
    private l iLF;
    private b iLG;
    private d iLH;
    private c iLI;
    private e iLJ;
    private f iLK;
    private TbPageContext mPageContext;

    public h(TbPageContext tbPageContext, v vVar) {
        this.mPageContext = tbPageContext;
        this.hyr = vVar;
        Jv();
    }

    private void Jv() {
        this.bbw = new ArrayList();
        this.bbw.add(new j(this.mPageContext));
        this.bbw.add(new k(this.mPageContext));
        this.bbw.add(new i(this.mPageContext));
        this.bbw.add(new w(this.mPageContext));
        this.iLE = new g(this.mPageContext);
        this.iLE.a(this.hyr);
        this.bbw.add(this.iLE);
        this.iLF = new l(this.mPageContext);
        this.iLF.a(this.hyr);
        this.bbw.add(this.iLF);
        this.iLG = new b(this.mPageContext);
        this.iLG.a(this.hyr);
        this.bbw.add(this.iLG);
        this.iLH = new d(this.mPageContext);
        this.iLH.a(this.hyr);
        this.bbw.add(this.iLH);
        this.iLI = new c(this.mPageContext);
        this.iLI.a(this.hyr);
        this.bbw.add(this.iLI);
        this.iLJ = new e(this.mPageContext);
        this.iLJ.a(this.hyr);
        this.bbw.add(this.iLJ);
        this.iLK = new f(this.mPageContext);
        this.iLK.a(this.hyr);
        this.bbw.add(this.iLK);
        this.hyr.addAdapters(this.bbw);
    }

    public void notifyDataSetChanged() {
        if (this.hyr != null) {
            this.hyr.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<q> list) {
        this.hyr.setData(list);
    }

    public List<q> getData() {
        return this.hyr.getData();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bbw) {
            aVar.setPageId(bdUniqueId);
        }
    }

    public void setOnItemCoverListener(com.baidu.tbadk.h.f fVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bbw) {
            if (aVar instanceof a) {
                ((a) aVar).setOnItemCoverListener(fVar);
            }
        }
    }
}

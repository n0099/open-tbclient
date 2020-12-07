package com.baidu.tieba.ala.alasquare.subtablist.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.ala.alasquare.subtablist.c.e;
import com.baidu.tieba.ala.alasquare.subtablist.c.f;
import com.baidu.tieba.ala.alasquare.subtablist.c.i;
/* loaded from: classes6.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.subtablist.b.b, f> {
    private int from;
    private i gxs;
    private boolean gzs;
    private e gzu;
    private int isSmallFollow;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.b.gzw);
        this.gzs = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ab */
    public f c(ViewGroup viewGroup) {
        this.gzu = new e(this.mPageContext, this.gzs);
        d.e(this.gzu.getView(), true);
        return new f(this.gzu);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.b bVar, f fVar) {
        b(bVar);
        fVar.gzu.a(bVar);
        fVar.gzu.d(this.gxs);
        return fVar.getView();
    }

    public void b(i iVar) {
        this.gxs = iVar;
    }

    private void b(com.baidu.tieba.ala.alasquare.subtablist.b.b bVar) {
        if (bVar != null) {
            if (this.from == 1) {
                if (bVar.grU != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bSG().e(com.baidu.tieba.ala.alasquare.c.a.bSG().a(this.isSmallFollow, "c12117", bVar.grU.tabId, bVar.grU.entryName, bVar.grU.bmn()));
                }
                if (bVar.grV != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bSG().e(com.baidu.tieba.ala.alasquare.c.a.bSG().a(this.isSmallFollow, "c12117", bVar.grV.tabId, bVar.grV.entryName, bVar.grV.bmn()));
                }
            } else if (this.from == 2) {
                if (bVar.grU != null && bVar.grU.bmn() != null && bVar.grU.bmn().bpj() != null) {
                    by bmn = bVar.grU.bmn();
                    TiebaStatic.log(new ar("c12115").w("obj_id", bmn.bpj().live_id).dY(TiebaInitialize.Params.OBJ_PARAM3, bmn.bpj().appId).dY("locate_type", bVar.grU.entryName));
                }
                if (bVar.grV != null && bVar.grV.bmn() != null && bVar.grV.bmn().bpj() != null) {
                    by bmn2 = bVar.grV.bmn();
                    TiebaStatic.log(new ar("c12115").w("obj_id", bmn2.bpj().live_id).dY(TiebaInitialize.Params.OBJ_PARAM3, bmn2.bpj().appId).dY("locate_type", bVar.grV.entryName));
                }
            }
        }
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void uU(int i) {
        this.isSmallFollow = i;
    }

    public void mo(boolean z) {
        this.gzs = z;
    }
}

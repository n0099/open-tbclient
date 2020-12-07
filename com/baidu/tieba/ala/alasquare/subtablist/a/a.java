package com.baidu.tieba.ala.alasquare.subtablist.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.ala.alasquare.subtablist.c.i;
/* loaded from: classes6.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.subtablist.b.a, com.baidu.tieba.ala.alasquare.subtablist.c.b> {
    private int from;
    private i gxs;
    private boolean gzs;
    private com.baidu.tieba.ala.alasquare.subtablist.c.a gzt;
    private int isSmallFollow;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.a.gzv);
        this.gzs = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aa */
    public com.baidu.tieba.ala.alasquare.subtablist.c.b c(ViewGroup viewGroup) {
        this.gzt = new com.baidu.tieba.ala.alasquare.subtablist.c.a(this.mPageContext, this.gzs);
        d.e(this.gzt.getView(), true);
        return new com.baidu.tieba.ala.alasquare.subtablist.c.b(this.gzt);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.a aVar, com.baidu.tieba.ala.alasquare.subtablist.c.b bVar) {
        a(aVar);
        bVar.gzt.a(aVar);
        bVar.gzt.d(this.gxs);
        return bVar.getView();
    }

    private void a(com.baidu.tieba.ala.alasquare.subtablist.b.a aVar) {
        if (aVar != null) {
            if (this.from == 1) {
                if (aVar.grU != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bSG().e(com.baidu.tieba.ala.alasquare.c.a.bSG().a(this.isSmallFollow, "c12117", aVar.grU.tabId, aVar.grU.entryName, aVar.grU.bmn()));
                }
                if (aVar.grV != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bSG().e(com.baidu.tieba.ala.alasquare.c.a.bSG().a(this.isSmallFollow, "c12117", aVar.grV.tabId, aVar.grV.entryName, aVar.grV.bmn()));
                }
            } else if (this.from == 2) {
                if (aVar.grU != null && aVar.grU.bmn() != null && aVar.grU.bmn().bpj() != null) {
                    by bmn = aVar.grU.bmn();
                    TiebaStatic.log(new ar("c12115").w("obj_id", bmn.bpj().live_id).dY(TiebaInitialize.Params.OBJ_PARAM3, bmn.bpj().appId).dY("locate_type", aVar.grU.entryName));
                }
                if (aVar.grV != null && aVar.grV.bmn() != null && aVar.grV.bmn().bpj() != null) {
                    by bmn2 = aVar.grV.bmn();
                    TiebaStatic.log(new ar("c12115").w("obj_id", bmn2.bpj().live_id).dY(TiebaInitialize.Params.OBJ_PARAM3, bmn2.bpj().appId).dY("locate_type", aVar.grV.entryName));
                }
            }
        }
    }

    public void b(i iVar) {
        this.gxs = iVar;
    }

    public void uU(int i) {
        this.isSmallFollow = i;
    }

    public void mo(boolean z) {
        this.gzs = z;
    }

    public void setFrom(int i) {
        this.from = i;
    }
}

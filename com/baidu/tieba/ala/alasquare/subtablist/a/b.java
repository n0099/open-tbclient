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
    private i gxu;
    private boolean gzu;
    private e gzw;
    private int isSmallFollow;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.b.gzy);
        this.gzu = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ab */
    public f c(ViewGroup viewGroup) {
        this.gzw = new e(this.mPageContext, this.gzu);
        d.e(this.gzw.getView(), true);
        return new f(this.gzw);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.b bVar, f fVar) {
        b(bVar);
        fVar.gzw.a(bVar);
        fVar.gzw.d(this.gxu);
        return fVar.getView();
    }

    public void b(i iVar) {
        this.gxu = iVar;
    }

    private void b(com.baidu.tieba.ala.alasquare.subtablist.b.b bVar) {
        if (bVar != null) {
            if (this.from == 1) {
                if (bVar.grW != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bSH().e(com.baidu.tieba.ala.alasquare.c.a.bSH().a(this.isSmallFollow, "c12117", bVar.grW.tabId, bVar.grW.entryName, bVar.grW.bmn()));
                }
                if (bVar.grX != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bSH().e(com.baidu.tieba.ala.alasquare.c.a.bSH().a(this.isSmallFollow, "c12117", bVar.grX.tabId, bVar.grX.entryName, bVar.grX.bmn()));
                }
            } else if (this.from == 2) {
                if (bVar.grW != null && bVar.grW.bmn() != null && bVar.grW.bmn().bpj() != null) {
                    by bmn = bVar.grW.bmn();
                    TiebaStatic.log(new ar("c12115").w("obj_id", bmn.bpj().live_id).dY(TiebaInitialize.Params.OBJ_PARAM3, bmn.bpj().appId).dY("locate_type", bVar.grW.entryName));
                }
                if (bVar.grX != null && bVar.grX.bmn() != null && bVar.grX.bmn().bpj() != null) {
                    by bmn2 = bVar.grX.bmn();
                    TiebaStatic.log(new ar("c12115").w("obj_id", bmn2.bpj().live_id).dY(TiebaInitialize.Params.OBJ_PARAM3, bmn2.bpj().appId).dY("locate_type", bVar.grX.entryName));
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
        this.gzu = z;
    }
}

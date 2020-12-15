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
    private i gxu;
    private boolean gzu;
    private com.baidu.tieba.ala.alasquare.subtablist.c.a gzv;
    private int isSmallFollow;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.a.gzx);
        this.gzu = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aa */
    public com.baidu.tieba.ala.alasquare.subtablist.c.b c(ViewGroup viewGroup) {
        this.gzv = new com.baidu.tieba.ala.alasquare.subtablist.c.a(this.mPageContext, this.gzu);
        d.e(this.gzv.getView(), true);
        return new com.baidu.tieba.ala.alasquare.subtablist.c.b(this.gzv);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.a aVar, com.baidu.tieba.ala.alasquare.subtablist.c.b bVar) {
        a(aVar);
        bVar.gzv.a(aVar);
        bVar.gzv.d(this.gxu);
        return bVar.getView();
    }

    private void a(com.baidu.tieba.ala.alasquare.subtablist.b.a aVar) {
        if (aVar != null) {
            if (this.from == 1) {
                if (aVar.grW != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bSH().e(com.baidu.tieba.ala.alasquare.c.a.bSH().a(this.isSmallFollow, "c12117", aVar.grW.tabId, aVar.grW.entryName, aVar.grW.bmn()));
                }
                if (aVar.grX != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bSH().e(com.baidu.tieba.ala.alasquare.c.a.bSH().a(this.isSmallFollow, "c12117", aVar.grX.tabId, aVar.grX.entryName, aVar.grX.bmn()));
                }
            } else if (this.from == 2) {
                if (aVar.grW != null && aVar.grW.bmn() != null && aVar.grW.bmn().bpj() != null) {
                    by bmn = aVar.grW.bmn();
                    TiebaStatic.log(new ar("c12115").w("obj_id", bmn.bpj().live_id).dY(TiebaInitialize.Params.OBJ_PARAM3, bmn.bpj().appId).dY("locate_type", aVar.grW.entryName));
                }
                if (aVar.grX != null && aVar.grX.bmn() != null && aVar.grX.bmn().bpj() != null) {
                    by bmn2 = aVar.grX.bmn();
                    TiebaStatic.log(new ar("c12115").w("obj_id", bmn2.bpj().live_id).dY(TiebaInitialize.Params.OBJ_PARAM3, bmn2.bpj().appId).dY("locate_type", aVar.grX.entryName));
                }
            }
        }
    }

    public void b(i iVar) {
        this.gxu = iVar;
    }

    public void uU(int i) {
        this.isSmallFollow = i;
    }

    public void mo(boolean z) {
        this.gzu = z;
    }

    public void setFrom(int i) {
        this.from = i;
    }
}

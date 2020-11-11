package com.baidu.tieba.ala.alasquare.subtablist.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.ala.alasquare.subtablist.c.e;
import com.baidu.tieba.ala.alasquare.subtablist.c.f;
import com.baidu.tieba.ala.alasquare.subtablist.c.i;
/* loaded from: classes4.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.subtablist.b.b, f> {
    private int from;
    private i gpC;
    private boolean grC;
    private e grE;
    private int isSmallFollow;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.b.grG);
        this.grC = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: af */
    public f c(ViewGroup viewGroup) {
        this.grE = new e(this.mPageContext, this.grC);
        return new f(this.grE);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.b bVar, f fVar) {
        b(bVar);
        fVar.grE.a(bVar);
        fVar.grE.d(this.gpC);
        return fVar.getView();
    }

    public void b(i iVar) {
        this.gpC = iVar;
    }

    private void b(com.baidu.tieba.ala.alasquare.subtablist.b.b bVar) {
        if (bVar != null) {
            if (this.from == 1) {
                if (bVar.gke != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bPC().e(com.baidu.tieba.ala.alasquare.c.a.bPC().a(this.isSmallFollow, "c12117", bVar.gke.tabId, bVar.gke.entryName, bVar.gke.bjZ()));
                }
                if (bVar.gkf != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bPC().e(com.baidu.tieba.ala.alasquare.c.a.bPC().a(this.isSmallFollow, "c12117", bVar.gkf.tabId, bVar.gkf.entryName, bVar.gkf.bjZ()));
                }
            } else if (this.from == 2) {
                if (bVar.gke != null && bVar.gke.bjZ() != null && bVar.gke.bjZ().bmU() != null) {
                    bw bjZ = bVar.gke.bjZ();
                    TiebaStatic.log(new aq("c12115").w("obj_id", bjZ.bmU().live_id).dR(TiebaInitialize.Params.OBJ_PARAM3, bjZ.bmU().appId).dR("locate_type", bVar.gke.entryName));
                }
                if (bVar.gkf != null && bVar.gkf.bjZ() != null && bVar.gkf.bjZ().bmU() != null) {
                    bw bjZ2 = bVar.gkf.bjZ();
                    TiebaStatic.log(new aq("c12115").w("obj_id", bjZ2.bmU().live_id).dR(TiebaInitialize.Params.OBJ_PARAM3, bjZ2.bmU().appId).dR("locate_type", bVar.gkf.entryName));
                }
            }
        }
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void tS(int i) {
        this.isSmallFollow = i;
    }

    public void lS(boolean z) {
        this.grC = z;
    }
}

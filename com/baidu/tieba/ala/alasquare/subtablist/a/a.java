package com.baidu.tieba.ala.alasquare.subtablist.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.ala.alasquare.subtablist.c.i;
/* loaded from: classes4.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.subtablist.b.a, com.baidu.tieba.ala.alasquare.subtablist.c.b> {
    private int from;
    private i gpC;
    private boolean grC;
    private com.baidu.tieba.ala.alasquare.subtablist.c.a grD;
    private int isSmallFollow;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.a.grF);
        this.grC = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ae */
    public com.baidu.tieba.ala.alasquare.subtablist.c.b c(ViewGroup viewGroup) {
        this.grD = new com.baidu.tieba.ala.alasquare.subtablist.c.a(this.mPageContext, this.grC);
        return new com.baidu.tieba.ala.alasquare.subtablist.c.b(this.grD);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.a aVar, com.baidu.tieba.ala.alasquare.subtablist.c.b bVar) {
        a(aVar);
        bVar.grD.a(aVar);
        bVar.grD.d(this.gpC);
        return bVar.getView();
    }

    private void a(com.baidu.tieba.ala.alasquare.subtablist.b.a aVar) {
        if (aVar != null) {
            if (this.from == 1) {
                if (aVar.gke != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bPC().e(com.baidu.tieba.ala.alasquare.c.a.bPC().a(this.isSmallFollow, "c12117", aVar.gke.tabId, aVar.gke.entryName, aVar.gke.bjZ()));
                }
                if (aVar.gkf != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bPC().e(com.baidu.tieba.ala.alasquare.c.a.bPC().a(this.isSmallFollow, "c12117", aVar.gkf.tabId, aVar.gkf.entryName, aVar.gkf.bjZ()));
                }
            } else if (this.from == 2) {
                if (aVar.gke != null && aVar.gke.bjZ() != null && aVar.gke.bjZ().bmU() != null) {
                    bw bjZ = aVar.gke.bjZ();
                    TiebaStatic.log(new aq("c12115").w("obj_id", bjZ.bmU().live_id).dR(TiebaInitialize.Params.OBJ_PARAM3, bjZ.bmU().appId).dR("locate_type", aVar.gke.entryName));
                }
                if (aVar.gkf != null && aVar.gkf.bjZ() != null && aVar.gkf.bjZ().bmU() != null) {
                    bw bjZ2 = aVar.gkf.bjZ();
                    TiebaStatic.log(new aq("c12115").w("obj_id", bjZ2.bmU().live_id).dR(TiebaInitialize.Params.OBJ_PARAM3, bjZ2.bmU().appId).dR("locate_type", aVar.gkf.entryName));
                }
            }
        }
    }

    public void b(i iVar) {
        this.gpC = iVar;
    }

    public void tS(int i) {
        this.isSmallFollow = i;
    }

    public void lS(boolean z) {
        this.grC = z;
    }

    public void setFrom(int i) {
        this.from = i;
    }
}

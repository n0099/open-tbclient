package com.baidu.tieba.ala.alasquare.subtablist.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.ala.alasquare.subtablist.c.e;
import com.baidu.tieba.ala.alasquare.subtablist.c.f;
import com.baidu.tieba.ala.alasquare.subtablist.c.i;
/* loaded from: classes2.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.subtablist.b.b, f> {
    private i emV;
    private boolean eoZ;
    private e epb;
    private int from;
    private int isSmallFollow;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.b.epd);
        this.eoZ = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: O */
    public f b(ViewGroup viewGroup) {
        this.epb = new e(this.mPageContext, this.eoZ);
        return new f(this.epb);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.b bVar, f fVar) {
        b(bVar);
        fVar.epb.a(bVar);
        fVar.epb.d(this.emV);
        return fVar.getView();
    }

    public void b(i iVar) {
        this.emV = iVar;
    }

    private void b(com.baidu.tieba.ala.alasquare.subtablist.b.b bVar) {
        if (bVar != null) {
            if (this.from == 1) {
                if (bVar.ehP != null) {
                    com.baidu.tieba.ala.alasquare.c.a.baG().c(com.baidu.tieba.ala.alasquare.c.a.baG().a(this.isSmallFollow, "c12117", bVar.ehP.tabId, bVar.ehP.entryName, bVar.ehP.axQ()));
                }
                if (bVar.ehQ != null) {
                    com.baidu.tieba.ala.alasquare.c.a.baG().c(com.baidu.tieba.ala.alasquare.c.a.baG().a(this.isSmallFollow, "c12117", bVar.ehQ.tabId, bVar.ehQ.entryName, bVar.ehQ.axQ()));
                }
            } else if (this.from == 2) {
                if (bVar.ehP != null && bVar.ehP.axQ() != null && bVar.ehP.axQ().aAq() != null) {
                    bj axQ = bVar.ehP.axQ();
                    TiebaStatic.log(new an("c12115").s("obj_id", axQ.aAq().live_id).cp(TiebaInitialize.Params.OBJ_PARAM3, axQ.aAq().appId).cp("locate_type", bVar.ehP.entryName));
                }
                if (bVar.ehQ != null && bVar.ehQ.axQ() != null && bVar.ehQ.axQ().aAq() != null) {
                    bj axQ2 = bVar.ehQ.axQ();
                    TiebaStatic.log(new an("c12115").s("obj_id", axQ2.aAq().live_id).cp(TiebaInitialize.Params.OBJ_PARAM3, axQ2.aAq().appId).cp("locate_type", bVar.ehQ.entryName));
                }
            }
        }
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void ok(int i) {
        this.isSmallFollow = i;
    }

    public void hY(boolean z) {
        this.eoZ = z;
    }
}

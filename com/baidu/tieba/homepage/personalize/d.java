package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.homepage.personalize.n;
import com.baidu.tieba.w;
import java.util.List;
import tbclient.Personalized.TagInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements n.a {
    final /* synthetic */ a czr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.czr = aVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.n.a
    public void aw(int i, int i2) {
        com.baidu.tieba.homepage.framework.c cVar;
        boolean akg;
        TagInfo tagInfo;
        com.baidu.tieba.homepage.framework.c cVar2;
        TagInfo tagInfo2;
        com.baidu.tieba.homepage.framework.c cVar3;
        TagInfo tagInfo3;
        cVar = this.czr.czi;
        if (cVar == null) {
            this.czr.showNetRefreshView(this.czr, TbadkCoreApplication.m9getInst().getString(w.l.neterror), true);
            this.czr.KC();
            return;
        }
        akg = this.czr.akg();
        this.czr.KD();
        if (akg) {
            this.czr.h(true, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds520));
        }
        tagInfo = this.czr.czg;
        if (tagInfo != null) {
            tagInfo2 = this.czr.czg;
            if (tagInfo2.tag_code != null) {
                cVar3 = this.czr.czi;
                tagInfo3 = this.czr.czg;
                cVar3.u(tagInfo3.tag_code.intValue(), i, i2);
                return;
            }
        }
        cVar2 = this.czr.czi;
        cVar2.u(0, i, i2);
    }

    @Override // com.baidu.tieba.homepage.personalize.n.a
    public void v(int i, int i2, int i3) {
        com.baidu.tieba.homepage.framework.c cVar;
        TagInfo tagInfo;
        TagInfo tagInfo2;
        com.baidu.tieba.homepage.framework.c cVar2;
        TagInfo tagInfo3;
        cVar = this.czr.czi;
        if (cVar != null) {
            tagInfo = this.czr.czg;
            if (tagInfo != null) {
                tagInfo2 = this.czr.czg;
                if (tagInfo2.tag_code != null) {
                    cVar2 = this.czr.czi;
                    tagInfo3 = this.czr.czg;
                    cVar2.i(tagInfo3.tag_code.intValue(), i, i2, i3);
                }
            }
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.n.a
    public void onError(int i, String str) {
        BdTypeListView bdTypeListView;
        TbPageContext tbPageContext;
        this.czr.KC();
        if (i != 1) {
            bdTypeListView = this.czr.aPG;
            bdTypeListView.setVisibility(8);
            this.czr.showNetRefreshView(this.czr, str, true);
        } else if (com.baidu.adp.lib.util.i.hk()) {
            tbPageContext = this.czr.pageContext;
            tbPageContext.showToast(str);
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.n.a
    public void onSuccess() {
        BdTypeListView bdTypeListView;
        this.czr.KC();
        this.czr.KD();
        bdTypeListView = this.czr.aPG;
        bdTypeListView.setVisibility(0);
    }

    @Override // com.baidu.tieba.homepage.personalize.n.a
    public void bb(List<TagInfo> list) {
        com.baidu.tieba.homepage.framework.c cVar;
        com.baidu.tieba.homepage.framework.c cVar2;
        cVar = this.czr.czi;
        if (cVar != null) {
            cVar2 = this.czr.czi;
            cVar2.aU(list);
        }
    }
}

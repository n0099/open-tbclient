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
    final /* synthetic */ a cxa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.cxa = aVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.n.a
    public void aw(int i, int i2) {
        com.baidu.tieba.homepage.framework.c cVar;
        boolean ajf;
        TagInfo tagInfo;
        com.baidu.tieba.homepage.framework.c cVar2;
        TagInfo tagInfo2;
        com.baidu.tieba.homepage.framework.c cVar3;
        TagInfo tagInfo3;
        cVar = this.cxa.cwR;
        if (cVar == null) {
            this.cxa.showNetRefreshView(this.cxa, TbadkCoreApplication.m9getInst().getString(w.l.neterror), true);
            this.cxa.KC();
            return;
        }
        ajf = this.cxa.ajf();
        this.cxa.KD();
        if (ajf) {
            this.cxa.g(true, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds520));
        }
        tagInfo = this.cxa.cwP;
        if (tagInfo != null) {
            tagInfo2 = this.cxa.cwP;
            if (tagInfo2.tag_code != null) {
                cVar3 = this.cxa.cwR;
                tagInfo3 = this.cxa.cwP;
                cVar3.u(tagInfo3.tag_code.intValue(), i, i2);
                return;
            }
        }
        cVar2 = this.cxa.cwR;
        cVar2.u(0, i, i2);
    }

    @Override // com.baidu.tieba.homepage.personalize.n.a
    public void v(int i, int i2, int i3) {
        com.baidu.tieba.homepage.framework.c cVar;
        TagInfo tagInfo;
        TagInfo tagInfo2;
        com.baidu.tieba.homepage.framework.c cVar2;
        TagInfo tagInfo3;
        cVar = this.cxa.cwR;
        if (cVar != null) {
            tagInfo = this.cxa.cwP;
            if (tagInfo != null) {
                tagInfo2 = this.cxa.cwP;
                if (tagInfo2.tag_code != null) {
                    cVar2 = this.cxa.cwR;
                    tagInfo3 = this.cxa.cwP;
                    cVar2.i(tagInfo3.tag_code.intValue(), i, i2, i3);
                }
            }
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.n.a
    public void onError(int i, String str) {
        BdTypeListView bdTypeListView;
        TbPageContext tbPageContext;
        this.cxa.KC();
        if (i != 1) {
            bdTypeListView = this.cxa.aPE;
            bdTypeListView.setVisibility(8);
            this.cxa.showNetRefreshView(this.cxa, str, true);
        } else if (com.baidu.adp.lib.util.i.hj()) {
            tbPageContext = this.cxa.pageContext;
            tbPageContext.showToast(str);
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.n.a
    public void onSuccess() {
        BdTypeListView bdTypeListView;
        this.cxa.KC();
        this.cxa.KD();
        bdTypeListView = this.cxa.aPE;
        bdTypeListView.setVisibility(0);
    }

    @Override // com.baidu.tieba.homepage.personalize.n.a
    public void ba(List<TagInfo> list) {
        com.baidu.tieba.homepage.framework.c cVar;
        com.baidu.tieba.homepage.framework.c cVar2;
        cVar = this.cxa.cwR;
        if (cVar != null) {
            cVar2 = this.cxa.cwR;
            cVar2.aT(list);
        }
    }
}

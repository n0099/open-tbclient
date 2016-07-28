package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.homepage.personalize.b;
import com.baidu.tieba.u;
import java.util.List;
import tbclient.Personalized.TagInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements b.a {
    final /* synthetic */ z ctN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar) {
        this.ctN = zVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.b.a
    public void av(int i, int i2) {
        com.baidu.tieba.homepage.framework.c cVar;
        boolean ahL;
        TagInfo tagInfo;
        com.baidu.tieba.homepage.framework.c cVar2;
        TagInfo tagInfo2;
        com.baidu.tieba.homepage.framework.c cVar3;
        TagInfo tagInfo3;
        cVar = this.ctN.ctH;
        if (cVar == null) {
            this.ctN.showNetRefreshView(this.ctN, TbadkCoreApplication.m10getInst().getString(u.j.neterror), true);
            this.ctN.IM();
            return;
        }
        ahL = this.ctN.ahL();
        this.ctN.IL();
        if (ahL) {
            this.ctN.j(true, TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds520));
        }
        tagInfo = this.ctN.ctE;
        if (tagInfo != null) {
            tagInfo2 = this.ctN.ctE;
            if (tagInfo2.tag_code != null) {
                cVar3 = this.ctN.ctH;
                tagInfo3 = this.ctN.ctE;
                cVar3.r(tagInfo3.tag_code.intValue(), i, i2);
                return;
            }
        }
        cVar2 = this.ctN.ctH;
        cVar2.r(0, i, i2);
    }

    @Override // com.baidu.tieba.homepage.personalize.b.a
    public void s(int i, int i2, int i3) {
        com.baidu.tieba.homepage.framework.c cVar;
        TagInfo tagInfo;
        TagInfo tagInfo2;
        com.baidu.tieba.homepage.framework.c cVar2;
        TagInfo tagInfo3;
        cVar = this.ctN.ctH;
        if (cVar != null) {
            tagInfo = this.ctN.ctE;
            if (tagInfo != null) {
                tagInfo2 = this.ctN.ctE;
                if (tagInfo2.tag_code != null) {
                    cVar2 = this.ctN.ctH;
                    tagInfo3 = this.ctN.ctE;
                    cVar2.i(tagInfo3.tag_code.intValue(), i, i2, i3);
                }
            }
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.b.a
    public void onError(int i, String str) {
        BdTypeListView bdTypeListView;
        TbPageContext tbPageContext;
        this.ctN.IM();
        if (i != 1) {
            bdTypeListView = this.ctN.ctF;
            bdTypeListView.setVisibility(8);
            this.ctN.showNetRefreshView(this.ctN, str, true);
        } else if (com.baidu.adp.lib.util.i.fq()) {
            tbPageContext = this.ctN.pageContext;
            tbPageContext.showToast(str);
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.b.a
    public void onSuccess() {
        BdTypeListView bdTypeListView;
        this.ctN.IM();
        this.ctN.IL();
        bdTypeListView = this.ctN.ctF;
        bdTypeListView.setVisibility(0);
    }

    @Override // com.baidu.tieba.homepage.personalize.b.a
    public void bs(List<TagInfo> list) {
        com.baidu.tieba.homepage.framework.c cVar;
        com.baidu.tieba.homepage.framework.c cVar2;
        cVar = this.ctN.ctH;
        if (cVar != null) {
            cVar2 = this.ctN.ctH;
            cVar2.bm(list);
        }
    }
}

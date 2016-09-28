package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.homepage.personalize.m;
import com.baidu.tieba.r;
import java.util.List;
import tbclient.Personalized.TagInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements m.a {
    final /* synthetic */ a cFs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cFs = aVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.m.a
    public void az(int i, int i2) {
        com.baidu.tieba.homepage.framework.c cVar;
        boolean amx;
        TagInfo tagInfo;
        com.baidu.tieba.homepage.framework.c cVar2;
        TagInfo tagInfo2;
        com.baidu.tieba.homepage.framework.c cVar3;
        TagInfo tagInfo3;
        cVar = this.cFs.cFl;
        if (cVar == null) {
            this.cFs.showNetRefreshView(this.cFs, TbadkCoreApplication.m9getInst().getString(r.j.neterror), true);
            this.cFs.JE();
            return;
        }
        amx = this.cFs.amx();
        this.cFs.JJ();
        if (amx) {
            this.cFs.j(true, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds520));
        }
        tagInfo = this.cFs.cFi;
        if (tagInfo != null) {
            tagInfo2 = this.cFs.cFi;
            if (tagInfo2.tag_code != null) {
                cVar3 = this.cFs.cFl;
                tagInfo3 = this.cFs.cFi;
                cVar3.u(tagInfo3.tag_code.intValue(), i, i2);
                return;
            }
        }
        cVar2 = this.cFs.cFl;
        cVar2.u(0, i, i2);
    }

    @Override // com.baidu.tieba.homepage.personalize.m.a
    public void v(int i, int i2, int i3) {
        com.baidu.tieba.homepage.framework.c cVar;
        TagInfo tagInfo;
        TagInfo tagInfo2;
        com.baidu.tieba.homepage.framework.c cVar2;
        TagInfo tagInfo3;
        cVar = this.cFs.cFl;
        if (cVar != null) {
            tagInfo = this.cFs.cFi;
            if (tagInfo != null) {
                tagInfo2 = this.cFs.cFi;
                if (tagInfo2.tag_code != null) {
                    cVar2 = this.cFs.cFl;
                    tagInfo3 = this.cFs.cFi;
                    cVar2.k(tagInfo3.tag_code.intValue(), i, i2, i3);
                }
            }
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.m.a
    public void onError(int i, String str) {
        BdTypeListView bdTypeListView;
        TbPageContext tbPageContext;
        this.cFs.JE();
        if (i != 1) {
            bdTypeListView = this.cFs.cFj;
            bdTypeListView.setVisibility(8);
            this.cFs.showNetRefreshView(this.cFs, str, true);
        } else if (com.baidu.adp.lib.util.i.gm()) {
            tbPageContext = this.cFs.pageContext;
            tbPageContext.showToast(str);
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.m.a
    public void onSuccess() {
        BdTypeListView bdTypeListView;
        this.cFs.JE();
        this.cFs.JJ();
        bdTypeListView = this.cFs.cFj;
        bdTypeListView.setVisibility(0);
    }

    @Override // com.baidu.tieba.homepage.personalize.m.a
    public void bu(List<TagInfo> list) {
        com.baidu.tieba.homepage.framework.c cVar;
        com.baidu.tieba.homepage.framework.c cVar2;
        cVar = this.cFs.cFl;
        if (cVar != null) {
            cVar2 = this.cFs.cFl;
            cVar2.bo(list);
        }
    }
}

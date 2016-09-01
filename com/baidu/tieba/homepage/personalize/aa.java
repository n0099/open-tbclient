package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.homepage.personalize.b;
import com.baidu.tieba.t;
import java.util.List;
import tbclient.Personalized.TagInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements b.a {
    final /* synthetic */ z cFs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar) {
        this.cFs = zVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.b.a
    public void az(int i, int i2) {
        com.baidu.tieba.homepage.framework.c cVar;
        boolean amA;
        TagInfo tagInfo;
        com.baidu.tieba.homepage.framework.c cVar2;
        TagInfo tagInfo2;
        com.baidu.tieba.homepage.framework.c cVar3;
        TagInfo tagInfo3;
        cVar = this.cFs.cFm;
        if (cVar == null) {
            this.cFs.showNetRefreshView(this.cFs, TbadkCoreApplication.m9getInst().getString(t.j.neterror), true);
            this.cFs.Lb();
            return;
        }
        amA = this.cFs.amA();
        this.cFs.La();
        if (amA) {
            this.cFs.i(true, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds520));
        }
        tagInfo = this.cFs.cFj;
        if (tagInfo != null) {
            tagInfo2 = this.cFs.cFj;
            if (tagInfo2.tag_code != null) {
                cVar3 = this.cFs.cFm;
                tagInfo3 = this.cFs.cFj;
                cVar3.s(tagInfo3.tag_code.intValue(), i, i2);
                return;
            }
        }
        cVar2 = this.cFs.cFm;
        cVar2.s(0, i, i2);
    }

    @Override // com.baidu.tieba.homepage.personalize.b.a
    public void t(int i, int i2, int i3) {
        com.baidu.tieba.homepage.framework.c cVar;
        TagInfo tagInfo;
        TagInfo tagInfo2;
        com.baidu.tieba.homepage.framework.c cVar2;
        TagInfo tagInfo3;
        cVar = this.cFs.cFm;
        if (cVar != null) {
            tagInfo = this.cFs.cFj;
            if (tagInfo != null) {
                tagInfo2 = this.cFs.cFj;
                if (tagInfo2.tag_code != null) {
                    cVar2 = this.cFs.cFm;
                    tagInfo3 = this.cFs.cFj;
                    cVar2.j(tagInfo3.tag_code.intValue(), i, i2, i3);
                }
            }
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.b.a
    public void onError(int i, String str) {
        BdTypeListView bdTypeListView;
        TbPageContext tbPageContext;
        this.cFs.Lb();
        if (i != 1) {
            bdTypeListView = this.cFs.cFk;
            bdTypeListView.setVisibility(8);
            this.cFs.showNetRefreshView(this.cFs, str, true);
        } else if (com.baidu.adp.lib.util.i.gm()) {
            tbPageContext = this.cFs.pageContext;
            tbPageContext.showToast(str);
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.b.a
    public void onSuccess() {
        BdTypeListView bdTypeListView;
        this.cFs.Lb();
        this.cFs.La();
        bdTypeListView = this.cFs.cFk;
        bdTypeListView.setVisibility(0);
    }

    @Override // com.baidu.tieba.homepage.personalize.b.a
    public void bu(List<TagInfo> list) {
        com.baidu.tieba.homepage.framework.c cVar;
        com.baidu.tieba.homepage.framework.c cVar2;
        cVar = this.cFs.cFm;
        if (cVar != null) {
            cVar2 = this.cFs.cFm;
            cVar2.bo(list);
        }
    }
}

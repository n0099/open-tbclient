package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.homepage.personalize.n;
import com.baidu.tieba.r;
import java.util.List;
import tbclient.Personalized.TagInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements n.a {
    final /* synthetic */ a cKG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.cKG = aVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.n.a
    public void aA(int i, int i2) {
        com.baidu.tieba.homepage.framework.c cVar;
        boolean aos;
        TagInfo tagInfo;
        com.baidu.tieba.homepage.framework.c cVar2;
        TagInfo tagInfo2;
        com.baidu.tieba.homepage.framework.c cVar3;
        TagInfo tagInfo3;
        cVar = this.cKG.cKy;
        if (cVar == null) {
            this.cKG.showNetRefreshView(this.cKG, TbadkCoreApplication.m9getInst().getString(r.j.neterror), true);
            this.cKG.JO();
            return;
        }
        aos = this.cKG.aos();
        this.cKG.JP();
        if (aos) {
            this.cKG.j(true, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds520));
        }
        tagInfo = this.cKG.cKv;
        if (tagInfo != null) {
            tagInfo2 = this.cKG.cKv;
            if (tagInfo2.tag_code != null) {
                cVar3 = this.cKG.cKy;
                tagInfo3 = this.cKG.cKv;
                cVar3.t(tagInfo3.tag_code.intValue(), i, i2);
                return;
            }
        }
        cVar2 = this.cKG.cKy;
        cVar2.t(0, i, i2);
    }

    @Override // com.baidu.tieba.homepage.personalize.n.a
    public void u(int i, int i2, int i3) {
        com.baidu.tieba.homepage.framework.c cVar;
        TagInfo tagInfo;
        TagInfo tagInfo2;
        com.baidu.tieba.homepage.framework.c cVar2;
        TagInfo tagInfo3;
        cVar = this.cKG.cKy;
        if (cVar != null) {
            tagInfo = this.cKG.cKv;
            if (tagInfo != null) {
                tagInfo2 = this.cKG.cKv;
                if (tagInfo2.tag_code != null) {
                    cVar2 = this.cKG.cKy;
                    tagInfo3 = this.cKG.cKv;
                    cVar2.j(tagInfo3.tag_code.intValue(), i, i2, i3);
                }
            }
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.n.a
    public void onError(int i, String str) {
        BdTypeListView bdTypeListView;
        TbPageContext tbPageContext;
        this.cKG.JO();
        if (i != 1) {
            bdTypeListView = this.cKG.cKw;
            bdTypeListView.setVisibility(8);
            this.cKG.showNetRefreshView(this.cKG, str, true);
        } else if (com.baidu.adp.lib.util.i.gm()) {
            tbPageContext = this.cKG.pageContext;
            tbPageContext.showToast(str);
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.n.a
    public void onSuccess() {
        BdTypeListView bdTypeListView;
        this.cKG.JO();
        this.cKG.JP();
        bdTypeListView = this.cKG.cKw;
        bdTypeListView.setVisibility(0);
    }

    @Override // com.baidu.tieba.homepage.personalize.n.a
    public void bw(List<TagInfo> list) {
        com.baidu.tieba.homepage.framework.c cVar;
        com.baidu.tieba.homepage.framework.c cVar2;
        cVar = this.cKG.cKy;
        if (cVar != null) {
            cVar2 = this.cKG.cKy;
            cVar2.bq(list);
        }
    }
}

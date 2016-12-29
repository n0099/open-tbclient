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
    final /* synthetic */ a cqb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.cqb = aVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.n.a
    public void av(int i, int i2) {
        com.baidu.tieba.homepage.framework.c cVar;
        boolean aiS;
        TagInfo tagInfo;
        com.baidu.tieba.homepage.framework.c cVar2;
        TagInfo tagInfo2;
        com.baidu.tieba.homepage.framework.c cVar3;
        TagInfo tagInfo3;
        cVar = this.cqb.cpT;
        if (cVar == null) {
            this.cqb.showNetRefreshView(this.cqb, TbadkCoreApplication.m9getInst().getString(r.j.neterror), true);
            this.cqb.Jj();
            return;
        }
        aiS = this.cqb.aiS();
        this.cqb.Jk();
        if (aiS) {
            this.cqb.g(true, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds520));
        }
        tagInfo = this.cqb.cpQ;
        if (tagInfo != null) {
            tagInfo2 = this.cqb.cpQ;
            if (tagInfo2.tag_code != null) {
                cVar3 = this.cqb.cpT;
                tagInfo3 = this.cqb.cpQ;
                cVar3.t(tagInfo3.tag_code.intValue(), i, i2);
                return;
            }
        }
        cVar2 = this.cqb.cpT;
        cVar2.t(0, i, i2);
    }

    @Override // com.baidu.tieba.homepage.personalize.n.a
    public void u(int i, int i2, int i3) {
        com.baidu.tieba.homepage.framework.c cVar;
        TagInfo tagInfo;
        TagInfo tagInfo2;
        com.baidu.tieba.homepage.framework.c cVar2;
        TagInfo tagInfo3;
        cVar = this.cqb.cpT;
        if (cVar != null) {
            tagInfo = this.cqb.cpQ;
            if (tagInfo != null) {
                tagInfo2 = this.cqb.cpQ;
                if (tagInfo2.tag_code != null) {
                    cVar2 = this.cqb.cpT;
                    tagInfo3 = this.cqb.cpQ;
                    cVar2.j(tagInfo3.tag_code.intValue(), i, i2, i3);
                }
            }
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.n.a
    public void onError(int i, String str) {
        BdTypeListView bdTypeListView;
        TbPageContext tbPageContext;
        this.cqb.Jj();
        if (i != 1) {
            bdTypeListView = this.cqb.cpR;
            bdTypeListView.setVisibility(8);
            this.cqb.showNetRefreshView(this.cqb, str, true);
        } else if (com.baidu.adp.lib.util.i.gm()) {
            tbPageContext = this.cqb.pageContext;
            tbPageContext.showToast(str);
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.n.a
    public void onSuccess() {
        BdTypeListView bdTypeListView;
        this.cqb.Jj();
        this.cqb.Jk();
        bdTypeListView = this.cqb.cpR;
        bdTypeListView.setVisibility(0);
    }

    @Override // com.baidu.tieba.homepage.personalize.n.a
    public void bo(List<TagInfo> list) {
        com.baidu.tieba.homepage.framework.c cVar;
        com.baidu.tieba.homepage.framework.c cVar2;
        cVar = this.cqb.cpT;
        if (cVar != null) {
            cVar2 = this.cqb.cpT;
            cVar2.bi(list);
        }
    }
}

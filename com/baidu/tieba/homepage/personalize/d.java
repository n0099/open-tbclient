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
    final /* synthetic */ a cxb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.cxb = aVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.n.a
    public void av(int i, int i2) {
        com.baidu.tieba.homepage.framework.c cVar;
        boolean ajZ;
        TagInfo tagInfo;
        com.baidu.tieba.homepage.framework.c cVar2;
        TagInfo tagInfo2;
        com.baidu.tieba.homepage.framework.c cVar3;
        TagInfo tagInfo3;
        cVar = this.cxb.cwS;
        if (cVar == null) {
            this.cxb.showNetRefreshView(this.cxb, TbadkCoreApplication.m9getInst().getString(r.l.neterror), true);
            this.cxb.Jx();
            return;
        }
        ajZ = this.cxb.ajZ();
        this.cxb.Jy();
        if (ajZ) {
            this.cxb.g(true, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds520));
        }
        tagInfo = this.cxb.cwQ;
        if (tagInfo != null) {
            tagInfo2 = this.cxb.cwQ;
            if (tagInfo2.tag_code != null) {
                cVar3 = this.cxb.cwS;
                tagInfo3 = this.cxb.cwQ;
                cVar3.u(tagInfo3.tag_code.intValue(), i, i2);
                return;
            }
        }
        cVar2 = this.cxb.cwS;
        cVar2.u(0, i, i2);
    }

    @Override // com.baidu.tieba.homepage.personalize.n.a
    public void v(int i, int i2, int i3) {
        com.baidu.tieba.homepage.framework.c cVar;
        TagInfo tagInfo;
        TagInfo tagInfo2;
        com.baidu.tieba.homepage.framework.c cVar2;
        TagInfo tagInfo3;
        cVar = this.cxb.cwS;
        if (cVar != null) {
            tagInfo = this.cxb.cwQ;
            if (tagInfo != null) {
                tagInfo2 = this.cxb.cwQ;
                if (tagInfo2.tag_code != null) {
                    cVar2 = this.cxb.cwS;
                    tagInfo3 = this.cxb.cwQ;
                    cVar2.i(tagInfo3.tag_code.intValue(), i, i2, i3);
                }
            }
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.n.a
    public void onError(int i, String str) {
        BdTypeListView bdTypeListView;
        TbPageContext tbPageContext;
        this.cxb.Jx();
        if (i != 1) {
            bdTypeListView = this.cxb.aJF;
            bdTypeListView.setVisibility(8);
            this.cxb.showNetRefreshView(this.cxb, str, true);
        } else if (com.baidu.adp.lib.util.i.gk()) {
            tbPageContext = this.cxb.pageContext;
            tbPageContext.showToast(str);
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.n.a
    public void onSuccess() {
        BdTypeListView bdTypeListView;
        this.cxb.Jx();
        this.cxb.Jy();
        bdTypeListView = this.cxb.aJF;
        bdTypeListView.setVisibility(0);
    }

    @Override // com.baidu.tieba.homepage.personalize.n.a
    public void bu(List<TagInfo> list) {
        com.baidu.tieba.homepage.framework.c cVar;
        com.baidu.tieba.homepage.framework.c cVar2;
        cVar = this.cxb.cwS;
        if (cVar != null) {
            cVar2 = this.cxb.cwS;
            cVar2.bo(list);
        }
    }
}

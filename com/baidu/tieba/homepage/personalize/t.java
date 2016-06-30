package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.homepage.personalize.a;
import com.baidu.tieba.u;
import java.util.List;
import tbclient.Personalized.TagInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements a.InterfaceC0060a {
    final /* synthetic */ s crd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.crd = sVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.a.InterfaceC0060a
    public void as(int i, int i2) {
        com.baidu.tieba.homepage.framework.c cVar;
        boolean ahd;
        TagInfo tagInfo;
        com.baidu.tieba.homepage.framework.c cVar2;
        TagInfo tagInfo2;
        com.baidu.tieba.homepage.framework.c cVar3;
        TagInfo tagInfo3;
        cVar = this.crd.cqX;
        if (cVar == null) {
            this.crd.showNetRefreshView(this.crd, TbadkCoreApplication.m9getInst().getString(u.j.neterror), true);
            this.crd.IN();
            return;
        }
        ahd = this.crd.ahd();
        this.crd.IM();
        if (ahd) {
            this.crd.i(true, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds520));
        }
        tagInfo = this.crd.cqU;
        if (tagInfo != null) {
            tagInfo2 = this.crd.cqU;
            if (tagInfo2.tag_code != null) {
                cVar3 = this.crd.cqX;
                tagInfo3 = this.crd.cqU;
                cVar3.q(tagInfo3.tag_code.intValue(), i, i2);
                return;
            }
        }
        cVar2 = this.crd.cqX;
        cVar2.q(0, i, i2);
    }

    @Override // com.baidu.tieba.homepage.personalize.a.InterfaceC0060a
    public void r(int i, int i2, int i3) {
        com.baidu.tieba.homepage.framework.c cVar;
        TagInfo tagInfo;
        TagInfo tagInfo2;
        com.baidu.tieba.homepage.framework.c cVar2;
        TagInfo tagInfo3;
        cVar = this.crd.cqX;
        if (cVar != null) {
            tagInfo = this.crd.cqU;
            if (tagInfo != null) {
                tagInfo2 = this.crd.cqU;
                if (tagInfo2.tag_code != null) {
                    cVar2 = this.crd.cqX;
                    tagInfo3 = this.crd.cqU;
                    cVar2.h(tagInfo3.tag_code.intValue(), i, i2, i3);
                }
            }
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.a.InterfaceC0060a
    public void onError(int i, String str) {
        BdTypeListView bdTypeListView;
        TbPageContext tbPageContext;
        this.crd.IN();
        if (i != 1) {
            bdTypeListView = this.crd.cqV;
            bdTypeListView.setVisibility(8);
            this.crd.showNetRefreshView(this.crd, str, true);
        } else if (com.baidu.adp.lib.util.i.fr()) {
            tbPageContext = this.crd.pageContext;
            tbPageContext.showToast(str);
        }
    }

    @Override // com.baidu.tieba.homepage.personalize.a.InterfaceC0060a
    public void onSuccess() {
        BdTypeListView bdTypeListView;
        this.crd.IN();
        this.crd.IM();
        bdTypeListView = this.crd.cqV;
        bdTypeListView.setVisibility(0);
    }

    @Override // com.baidu.tieba.homepage.personalize.a.InterfaceC0060a
    public void bo(List<TagInfo> list) {
        com.baidu.tieba.homepage.framework.c cVar;
        com.baidu.tieba.homepage.framework.c cVar2;
        cVar = this.crd.cqX;
        if (cVar != null) {
            cVar2 = this.crd.cqX;
            cVar2.bi(list);
        }
    }
}

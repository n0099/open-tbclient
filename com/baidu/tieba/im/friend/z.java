package com.baidu.tieba.im.friend;

import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.bn;
import com.baidu.tbadk.core.util.bp;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class z implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ y a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.a = yVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        BdListView bdListView;
        InviteFriendCandidateList inviteFriendCandidateList;
        BdListView bdListView2;
        if (bVar != null) {
            bdListView = this.a.f;
            ImageView imageView = (ImageView) bdListView.findViewWithTag(str);
            while (imageView != null) {
                imageView.setTag(null);
                imageView.setImageBitmap(bVar.h());
                bdListView2 = this.a.f;
                imageView = (ImageView) bdListView2.findViewWithTag(str);
            }
            inviteFriendCandidateList = this.a.j;
            bn.a((ViewGroup) inviteFriendCandidateList, false, (bp) new aa(this, str, bVar));
        }
    }
}

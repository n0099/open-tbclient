package com.baidu.tieba.im.friend;

import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.bx;
import com.baidu.tbadk.core.util.bz;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ x a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.a = xVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        BdListView bdListView;
        InviteFriendCandidateList inviteFriendCandidateList;
        BdListView bdListView2;
        if (aVar != null) {
            bdListView = this.a.e;
            ImageView imageView = (ImageView) bdListView.findViewWithTag(str);
            while (imageView != null) {
                imageView.setTag(null);
                imageView.setImageBitmap(aVar.h());
                bdListView2 = this.a.e;
                imageView = (ImageView) bdListView2.findViewWithTag(str);
            }
            inviteFriendCandidateList = this.a.i;
            bx.a((ViewGroup) inviteFriendCandidateList, false, (bz) new z(this, str, aVar));
        }
    }
}

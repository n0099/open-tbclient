package com.baidu.tieba.im.friend;

import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.util.ch;
import com.baidu.tieba.util.cj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ u a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar) {
        this.a = uVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
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
            ch.a((ViewGroup) inviteFriendCandidateList, false, (cj) new w(this, str, bVar));
        }
    }
}

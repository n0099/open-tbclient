package com.baidu.tieba.im.friend;

import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.bp;
import com.baidu.tbadk.core.util.br;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ y a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.a = yVar;
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
            bp.a((ViewGroup) inviteFriendCandidateList, false, (br) new aa(this, str, aVar));
        }
    }
}

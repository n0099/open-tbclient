package com.baidu.tieba.im.chat;

import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bw implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ MsgActivityView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(MsgActivityView msgActivityView) {
        this.a = msgActivityView;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        HeadImageView headImageView;
        HeadImageView headImageView2;
        headImageView = this.a.p;
        String str2 = (String) headImageView.getTag();
        if (str != null && str.equals(str2) && bVar != null) {
            headImageView2 = this.a.p;
            bVar.a(headImageView2);
        }
    }
}

package com.baidu.tieba.im.chat;

import com.baidu.tieba.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ MsgActivityView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(MsgActivityView msgActivityView) {
        this.a = msgActivityView;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
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

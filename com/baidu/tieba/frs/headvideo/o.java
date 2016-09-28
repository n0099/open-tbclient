package com.baidu.tieba.frs.headvideo;

import android.view.View;
/* loaded from: classes.dex */
class o implements com.baidu.tbadk.widget.layout.i {
    final /* synthetic */ ForumHeadVideoView ccf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(ForumHeadVideoView forumHeadVideoView) {
        this.ccf = forumHeadVideoView;
    }

    @Override // com.baidu.tbadk.widget.layout.i
    public void a(View view, int i, int i2, int i3, int i4) {
        int aer = a.aer();
        if (i > 0 && i2 > 0 && aer == 0) {
            this.ccf.aeI();
        }
    }
}

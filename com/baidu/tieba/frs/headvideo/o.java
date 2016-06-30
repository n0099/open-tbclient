package com.baidu.tieba.frs.headvideo;

import android.view.View;
/* loaded from: classes.dex */
class o implements com.baidu.tbadk.widget.layout.i {
    final /* synthetic */ ForumHeadVideoView bPh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(ForumHeadVideoView forumHeadVideoView) {
        this.bPh = forumHeadVideoView;
    }

    @Override // com.baidu.tbadk.widget.layout.i
    public void a(View view, int i, int i2, int i3, int i4) {
        int YV = a.YV();
        if (i > 0 && i2 > 0 && YV == 0) {
            this.bPh.Zn();
        }
    }
}

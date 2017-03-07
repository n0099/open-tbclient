package com.baidu.tieba.frs.headvideo;

import android.view.View;
/* loaded from: classes.dex */
class l implements com.baidu.tbadk.widget.layout.i {
    final /* synthetic */ ForumHeadVideoView bYL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(ForumHeadVideoView forumHeadVideoView) {
        this.bYL = forumHeadVideoView;
    }

    @Override // com.baidu.tbadk.widget.layout.i
    public void a(View view, int i, int i2, int i3, int i4) {
        int acj = a.acj();
        if (i > 0 && i2 > 0 && acj == 0) {
            this.bYL.acz();
        }
    }
}

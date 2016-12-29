package com.baidu.tieba.frs.headvideo;

import android.view.View;
/* loaded from: classes.dex */
class m implements com.baidu.tbadk.widget.layout.i {
    final /* synthetic */ ForumHeadVideoView bLk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(ForumHeadVideoView forumHeadVideoView) {
        this.bLk = forumHeadVideoView;
    }

    @Override // com.baidu.tbadk.widget.layout.i
    public void a(View view, int i, int i2, int i3, int i4) {
        int aah = a.aah();
        if (i > 0 && i2 > 0 && aah == 0) {
            this.bLk.aaw();
        }
    }
}

package com.baidu.tieba.im.live.room;

import android.widget.Button;
import com.baidu.tieba.im.view.LocateScrollView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements com.baidu.tieba.im.view.l {
    final /* synthetic */ az a;
    private final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(az azVar, int i) {
        this.a = azVar;
        this.b = i;
    }

    @Override // com.baidu.tieba.im.view.l
    public void a(int i, int i2, int i3, int i4) {
        LocateScrollView locateScrollView;
        LocateScrollView locateScrollView2;
        Button button;
        if (i2 - i4 < 0) {
            locateScrollView2 = this.a.i;
            button = this.a.c;
            locateScrollView2.a(button, this.b);
            return;
        }
        locateScrollView = this.a.i;
        locateScrollView.a(null, 0);
    }
}

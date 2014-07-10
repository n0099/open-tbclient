package com.baidu.tieba.im.live.room;

import android.widget.Button;
import com.baidu.tieba.im.view.LocateScrollView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements com.baidu.tieba.im.view.k {
    final /* synthetic */ ba a;
    private final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(ba baVar, int i) {
        this.a = baVar;
        this.b = i;
    }

    @Override // com.baidu.tieba.im.view.k
    public void a(int i, int i2, int i3, int i4) {
        LocateScrollView locateScrollView;
        LocateScrollView locateScrollView2;
        Button button;
        if (i2 - i4 < 0) {
            locateScrollView2 = this.a.g;
            button = this.a.a;
            locateScrollView2.a(button, this.b);
            return;
        }
        locateScrollView = this.a.g;
        locateScrollView.a(null, 0);
    }
}

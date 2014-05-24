package com.baidu.tieba.frs;

import android.app.Activity;
import android.widget.ListView;
import com.baidu.tieba.editortool.PbEditor;
/* loaded from: classes.dex */
public class dd implements Runnable {
    private int a;
    private int b;
    private PbEditor c;
    private ListView d;
    private Activity e;
    private int f;

    public dd(Activity activity, int i, int i2, PbEditor pbEditor, ListView listView, int i3) {
        this.b = i2;
        this.a = i;
        this.c = pbEditor;
        this.d = listView;
        this.f = i3;
        this.e = activity;
    }

    @Override // java.lang.Runnable
    public void run() {
        int[] iArr = new int[2];
        this.c.getLocationInWindow(iArr);
        this.d.setSelectionFromTop(this.a + this.d.getHeaderViewsCount(), ((iArr[1] - this.b) - this.f) - com.baidu.adp.lib.util.k.a(this.e));
        this.d.invalidate();
    }
}

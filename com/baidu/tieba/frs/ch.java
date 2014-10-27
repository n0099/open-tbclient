package com.baidu.tieba.frs;

import android.app.Activity;
import android.widget.ListView;
import com.baidu.tieba.editortool.PbEditor;
/* loaded from: classes.dex */
public class ch implements Runnable {
    private Activity Yg;
    private PbEditor aDu;
    private ListView aDv;
    private int aDw;
    private int distance;
    private int position;

    public ch(Activity activity, int i, int i2, PbEditor pbEditor, ListView listView, int i3) {
        this.distance = i2;
        this.position = i;
        this.aDu = pbEditor;
        this.aDv = listView;
        this.aDw = i3;
        this.Yg = activity;
    }

    @Override // java.lang.Runnable
    public void run() {
        int[] iArr = new int[2];
        this.aDu.getLocationInWindow(iArr);
        this.aDv.setSelectionFromTop(this.position + this.aDv.getHeaderViewsCount(), ((iArr[1] - this.distance) - this.aDw) - com.baidu.adp.lib.util.m.f(this.Yg));
        this.aDv.invalidate();
    }
}

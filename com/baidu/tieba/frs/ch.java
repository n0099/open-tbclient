package com.baidu.tieba.frs;

import android.app.Activity;
import android.widget.ListView;
import com.baidu.tieba.editortool.PbEditor;
/* loaded from: classes.dex */
public class ch implements Runnable {
    private Activity Yk;
    private PbEditor aDE;
    private ListView aDF;
    private int aDG;
    private int distance;
    private int position;

    public ch(Activity activity, int i, int i2, PbEditor pbEditor, ListView listView, int i3) {
        this.distance = i2;
        this.position = i;
        this.aDE = pbEditor;
        this.aDF = listView;
        this.aDG = i3;
        this.Yk = activity;
    }

    @Override // java.lang.Runnable
    public void run() {
        int[] iArr = new int[2];
        this.aDE.getLocationInWindow(iArr);
        this.aDF.setSelectionFromTop(this.position + this.aDF.getHeaderViewsCount(), ((iArr[1] - this.distance) - this.aDG) - com.baidu.adp.lib.util.m.f(this.Yk));
        this.aDF.invalidate();
    }
}

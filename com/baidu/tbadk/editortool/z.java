package com.baidu.tbadk.editortool;

import android.app.Activity;
import android.widget.ListView;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
/* loaded from: classes.dex */
public class z implements Runnable {
    private PbEditor akv;
    private ListView akw;
    private Activity akx;
    private int aky;
    private int distance;
    private int position;

    public z(Activity activity, int i, int i2, PbEditor pbEditor, ListView listView, int i3) {
        this.distance = i2;
        this.position = i;
        this.akv = pbEditor;
        this.akw = listView;
        this.aky = i3;
        this.akx = activity;
    }

    @Override // java.lang.Runnable
    public void run() {
        int[] iArr = new int[2];
        this.akv.getLocationInWindow(iArr);
        this.akw.setSelectionFromTop(this.position + this.akw.getHeaderViewsCount(), ((iArr[1] - this.distance) - this.aky) - com.baidu.adp.lib.util.n.l(this.akx));
        this.akw.invalidate();
    }
}

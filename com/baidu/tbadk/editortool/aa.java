package com.baidu.tbadk.editortool;

import android.app.Activity;
import android.widget.ListView;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
/* loaded from: classes.dex */
public class aa implements Runnable {
    private PbEditor Yo;
    private ListView Yp;
    private Activity Yq;
    private int Yr;
    private int distance;
    private int position;

    public aa(Activity activity, int i, int i2, PbEditor pbEditor, ListView listView, int i3) {
        this.distance = i2;
        this.position = i;
        this.Yo = pbEditor;
        this.Yp = listView;
        this.Yr = i3;
        this.Yq = activity;
    }

    @Override // java.lang.Runnable
    public void run() {
        int[] iArr = new int[2];
        this.Yo.getLocationInWindow(iArr);
        this.Yp.setSelectionFromTop(this.position + this.Yp.getHeaderViewsCount(), ((iArr[1] - this.distance) - this.Yr) - com.baidu.adp.lib.util.l.l(this.Yq));
        this.Yp.invalidate();
    }
}

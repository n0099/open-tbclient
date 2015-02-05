package com.baidu.tbadk.editortool;

import android.app.Activity;
import android.widget.ListView;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
/* loaded from: classes.dex */
public class aa implements Runnable {
    private PbEditor YR;
    private ListView YS;
    private Activity YT;
    private int YU;
    private int distance;
    private int position;

    public aa(Activity activity, int i, int i2, PbEditor pbEditor, ListView listView, int i3) {
        this.distance = i2;
        this.position = i;
        this.YR = pbEditor;
        this.YS = listView;
        this.YU = i3;
        this.YT = activity;
    }

    @Override // java.lang.Runnable
    public void run() {
        int[] iArr = new int[2];
        this.YR.getLocationInWindow(iArr);
        this.YS.setSelectionFromTop(this.position + this.YS.getHeaderViewsCount(), ((iArr[1] - this.distance) - this.YU) - com.baidu.adp.lib.util.l.m(this.YT));
        this.YS.invalidate();
    }
}

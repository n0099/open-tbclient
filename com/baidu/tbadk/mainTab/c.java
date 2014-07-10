package com.baidu.tbadk.mainTab;

import android.view.View;
import android.widget.TextView;
/* loaded from: classes.dex */
public class c {
    public View a;
    public boolean b = true;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public FragmentTabIndicator h;

    public void a(int i) {
        if (i == 1) {
            if (this.e != 0) {
                this.a.setBackgroundResource(this.e);
            }
            if ((this.a instanceof TextView) && this.g != 0) {
                ((TextView) this.a).setTextColor(this.g);
                return;
            }
            return;
        }
        if (this.d != 0) {
            this.a.setBackgroundResource(this.d);
        }
        if ((this.a instanceof TextView) && this.f != 0) {
            ((TextView) this.a).setTextColor(this.f);
        }
    }
}

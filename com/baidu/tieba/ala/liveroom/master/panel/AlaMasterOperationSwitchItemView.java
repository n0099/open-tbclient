package com.baidu.tieba.ala.liveroom.master.panel;

import android.content.Context;
import com.baidu.live.q.a;
/* loaded from: classes2.dex */
public class AlaMasterOperationSwitchItemView extends AlaMasterOperationBaseItemView {
    private short faw;
    private int fax;
    private int fay;

    public AlaMasterOperationSwitchItemView(Context context, int i) {
        super(context, i);
        this.faw = (short) 1;
    }

    public void setTextResIdAndOnIconIdAndOffIconId(int i, int i2, int i3) {
        setTextResId(i);
        this.fax = i2;
        this.fay = i3;
        bmi();
    }

    public void f(short s) {
        this.faw = s;
        bmi();
        bmj();
    }

    private void bmi() {
        if (this.faw == 1) {
            setIconResId(this.fax);
            setEnabled(true);
        } else if (this.faw == 2) {
            setIconResId(this.fay);
            setEnabled(true);
        } else {
            setIconResId(this.fax);
            setEnabled(false);
        }
    }

    private void bmj() {
        if (this.mId == 3) {
            if (this.faw == 1) {
                setTextResId(a.i.ala_operation_panel_text_mirror_on);
            } else if (this.faw == 2) {
                setTextResId(a.i.ala_operation_panel_text_mirror_off);
            }
        }
    }
}

package com.baidu.tieba.ala.liveroom.master.panel;

import android.content.Context;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class AlaMasterOperationSwitchItemView extends AlaMasterOperationBaseItemView {
    private short fgt;
    private int fgu;
    private int fgv;

    public AlaMasterOperationSwitchItemView(Context context, int i) {
        super(context, i);
        this.fgt = (short) 1;
    }

    public void setTextResIdAndOnIconIdAndOffIconId(int i, int i2, int i3) {
        setTextResId(i);
        this.fgu = i2;
        this.fgv = i3;
        boQ();
    }

    public void h(short s) {
        this.fgt = s;
        boQ();
        boR();
    }

    private void boQ() {
        if (this.fgt == 1) {
            setIconResId(this.fgu);
            setEnabled(true);
        } else if (this.fgt == 2) {
            setIconResId(this.fgv);
            setEnabled(true);
        } else {
            setIconResId(this.fgu);
            setEnabled(false);
        }
    }

    private void boR() {
        if (this.mId == 3) {
            if (this.fgt == 1) {
                setTextResId(a.i.ala_operation_panel_text_mirror_on);
            } else if (this.fgt == 2) {
                setTextResId(a.i.ala_operation_panel_text_mirror_off);
            }
        }
    }
}

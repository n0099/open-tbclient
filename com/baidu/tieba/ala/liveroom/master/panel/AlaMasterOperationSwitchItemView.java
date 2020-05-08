package com.baidu.tieba.ala.liveroom.master.panel;

import android.content.Context;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class AlaMasterOperationSwitchItemView extends AlaMasterOperationBaseItemView {
    private short fLx;
    private int fLy;
    private int fLz;

    public AlaMasterOperationSwitchItemView(Context context, int i) {
        super(context, i);
        this.fLx = (short) 1;
    }

    public void setTextResIdAndOnIconIdAndOffIconId(int i, int i2, int i3) {
        setTextResId(i);
        this.fLy = i2;
        this.fLz = i3;
        byq();
    }

    public void h(short s) {
        this.fLx = s;
        byq();
        byr();
    }

    private void byq() {
        if (this.fLx == 1) {
            setIconResId(this.fLy);
            setEnabled(true);
        } else if (this.fLx == 2) {
            setIconResId(this.fLz);
            setEnabled(true);
        } else {
            setIconResId(this.fLy);
            setEnabled(false);
        }
    }

    private void byr() {
        if (this.mId == 3) {
            if (this.fLx == 1) {
                setTextResId(a.i.ala_operation_panel_text_mirror_on);
            } else if (this.fLx == 2) {
                setTextResId(a.i.ala_operation_panel_text_mirror_off);
            }
        }
    }
}

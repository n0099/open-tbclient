package com.baidu.tieba.ala.liveroom.master.panel;

import android.content.Context;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class AlaMasterOperationSwitchItemView extends AlaMasterOperationBaseItemView {
    private short fZv;
    private int fZw;
    private int fZx;

    public AlaMasterOperationSwitchItemView(Context context, int i) {
        super(context, i);
        this.fZv = (short) 1;
    }

    public void setTextResIdAndOnIconIdAndOffIconId(int i, int i2, int i3) {
        setTextResId(i);
        this.fZw = i2;
        this.fZx = i3;
        bEt();
    }

    public void h(short s) {
        this.fZv = s;
        bEt();
        bEu();
    }

    private void bEt() {
        if (this.fZv == 1) {
            setIconResId(this.fZw);
            setEnabled(true);
        } else if (this.fZv == 2) {
            setIconResId(this.fZx);
            setEnabled(true);
        } else {
            setIconResId(this.fZw);
            setEnabled(false);
        }
    }

    private void bEu() {
        if (this.mId == 3) {
            if (this.fZv == 1) {
                setTextResId(a.i.ala_operation_panel_text_mirror_on);
            } else if (this.fZv == 2) {
                setTextResId(a.i.ala_operation_panel_text_mirror_off);
            }
        }
    }
}

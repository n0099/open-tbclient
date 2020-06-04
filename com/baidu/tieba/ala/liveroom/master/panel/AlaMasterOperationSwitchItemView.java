package com.baidu.tieba.ala.liveroom.master.panel;

import android.content.Context;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class AlaMasterOperationSwitchItemView extends AlaMasterOperationBaseItemView {
    private short fZG;
    private int fZH;
    private int fZI;

    public AlaMasterOperationSwitchItemView(Context context, int i) {
        super(context, i);
        this.fZG = (short) 1;
    }

    public void setTextResIdAndOnIconIdAndOffIconId(int i, int i2, int i3) {
        setTextResId(i);
        this.fZH = i2;
        this.fZI = i3;
        bEv();
    }

    public void h(short s) {
        this.fZG = s;
        bEv();
        bEw();
    }

    private void bEv() {
        if (this.fZG == 1) {
            setIconResId(this.fZH);
            setEnabled(true);
        } else if (this.fZG == 2) {
            setIconResId(this.fZI);
            setEnabled(true);
        } else {
            setIconResId(this.fZH);
            setEnabled(false);
        }
    }

    private void bEw() {
        if (this.mId == 3) {
            if (this.fZG == 1) {
                setTextResId(a.i.ala_operation_panel_text_mirror_on);
            } else if (this.fZG == 2) {
                setTextResId(a.i.ala_operation_panel_text_mirror_off);
            }
        }
    }
}

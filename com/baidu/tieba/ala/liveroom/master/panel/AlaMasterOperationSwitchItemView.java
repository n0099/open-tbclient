package com.baidu.tieba.ala.liveroom.master.panel;

import android.content.Context;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class AlaMasterOperationSwitchItemView extends AlaMasterOperationBaseItemView {
    private short hoe;
    private int hof;
    private int hog;

    public AlaMasterOperationSwitchItemView(Context context, int i) {
        super(context, i);
        this.hoe = (short) 1;
    }

    public void setTextResIdAndOnIconIdAndOffIconId(int i, int i2, int i3) {
        setTextResId(i);
        this.hof = i2;
        this.hog = i3;
        cfw();
    }

    public void i(short s) {
        this.hoe = s;
        cfw();
        cfx();
    }

    private void cfw() {
        if (this.hoe == 1) {
            setIconResId(this.hof);
            setEnabled(true);
        } else if (this.hoe == 2) {
            setIconResId(this.hog);
            setEnabled(true);
        } else {
            setIconResId(this.hof);
            setEnabled(false);
        }
    }

    private void cfx() {
        if (this.mId == 3) {
            if (this.hoe == 1) {
                setTextResId(a.h.ala_operation_panel_text_mirror_on);
            } else if (this.hoe == 2) {
                setTextResId(a.h.ala_operation_panel_text_mirror_off);
            }
        }
    }
}

package com.baidu.tieba.ala.liveroom.master.panel;

import android.content.Context;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class AlaMasterOperationSwitchItemView extends AlaMasterOperationBaseItemView {
    private short hKV;
    private int hKW;
    private int hKX;

    public AlaMasterOperationSwitchItemView(Context context, int i) {
        super(context, i);
        this.hKV = (short) 1;
    }

    public void setTextResIdAndOnIconIdAndOffIconId(int i, int i2, int i3) {
        setTextResId(i);
        this.hKW = i2;
        this.hKX = i3;
        updateIcon();
    }

    public void i(short s) {
        this.hKV = s;
        updateIcon();
        XQ();
    }

    private void updateIcon() {
        if (this.hKV == 1) {
            setIconResId(this.hKW);
            setEnabled(true);
        } else if (this.hKV == 2) {
            setIconResId(this.hKX);
            setEnabled(true);
        } else {
            setIconResId(this.hKW);
            setEnabled(false);
        }
    }

    private void XQ() {
        if (this.mId == 3) {
            if (this.hKV == 1) {
                setTextResId(a.h.ala_operation_panel_text_mirror_on);
            } else if (this.hKV == 2) {
                setTextResId(a.h.ala_operation_panel_text_mirror_off);
            }
        }
    }
}

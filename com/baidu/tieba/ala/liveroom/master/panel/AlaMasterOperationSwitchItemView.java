package com.baidu.tieba.ala.liveroom.master.panel;

import android.content.Context;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class AlaMasterOperationSwitchItemView extends AlaMasterOperationBaseItemView {
    private short hEM;
    private int hEN;
    private int hEO;

    public AlaMasterOperationSwitchItemView(Context context, int i) {
        super(context, i);
        this.hEM = (short) 1;
    }

    public void setTextResIdAndOnIconIdAndOffIconId(int i, int i2, int i3) {
        setTextResId(i);
        this.hEN = i2;
        this.hEO = i3;
        updateIcon();
    }

    public void i(short s) {
        this.hEM = s;
        updateIcon();
        We();
    }

    private void updateIcon() {
        if (this.hEM == 1) {
            setIconResId(this.hEN);
            setEnabled(true);
        } else if (this.hEM == 2) {
            setIconResId(this.hEO);
            setEnabled(true);
        } else {
            setIconResId(this.hEN);
            setEnabled(false);
        }
    }

    private void We() {
        if (this.mId == 3) {
            if (this.hEM == 1) {
                setTextResId(a.h.ala_operation_panel_text_mirror_on);
            } else if (this.hEM == 2) {
                setTextResId(a.h.ala_operation_panel_text_mirror_off);
            }
        }
    }
}

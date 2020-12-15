package com.baidu.tieba.ala.liveroom.master.panel;

import android.content.Context;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class AlaMasterOperationSwitchItemView extends AlaMasterOperationBaseItemView {
    private short hxu;
    private int hxv;
    private int hxw;

    public AlaMasterOperationSwitchItemView(Context context, int i) {
        super(context, i);
        this.hxu = (short) 1;
    }

    public void setTextResIdAndOnIconIdAndOffIconId(int i, int i2, int i3) {
        setTextResId(i);
        this.hxv = i2;
        this.hxw = i3;
        ciM();
    }

    public void i(short s) {
        this.hxu = s;
        ciM();
        ciN();
    }

    private void ciM() {
        if (this.hxu == 1) {
            setIconResId(this.hxv);
            setEnabled(true);
        } else if (this.hxu == 2) {
            setIconResId(this.hxw);
            setEnabled(true);
        } else {
            setIconResId(this.hxv);
            setEnabled(false);
        }
    }

    private void ciN() {
        if (this.mId == 3) {
            if (this.hxu == 1) {
                setTextResId(a.h.ala_operation_panel_text_mirror_on);
            } else if (this.hxu == 2) {
                setTextResId(a.h.ala_operation_panel_text_mirror_off);
            }
        }
    }
}

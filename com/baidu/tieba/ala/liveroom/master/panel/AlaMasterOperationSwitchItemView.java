package com.baidu.tieba.ala.liveroom.master.panel;

import android.content.Context;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class AlaMasterOperationSwitchItemView extends AlaMasterOperationBaseItemView {
    private short hxs;
    private int hxt;
    private int hxu;

    public AlaMasterOperationSwitchItemView(Context context, int i) {
        super(context, i);
        this.hxs = (short) 1;
    }

    public void setTextResIdAndOnIconIdAndOffIconId(int i, int i2, int i3) {
        setTextResId(i);
        this.hxt = i2;
        this.hxu = i3;
        ciL();
    }

    public void i(short s) {
        this.hxs = s;
        ciL();
        ciM();
    }

    private void ciL() {
        if (this.hxs == 1) {
            setIconResId(this.hxt);
            setEnabled(true);
        } else if (this.hxs == 2) {
            setIconResId(this.hxu);
            setEnabled(true);
        } else {
            setIconResId(this.hxt);
            setEnabled(false);
        }
    }

    private void ciM() {
        if (this.mId == 3) {
            if (this.hxs == 1) {
                setTextResId(a.h.ala_operation_panel_text_mirror_on);
            } else if (this.hxs == 2) {
                setTextResId(a.h.ala_operation_panel_text_mirror_off);
            }
        }
    }
}

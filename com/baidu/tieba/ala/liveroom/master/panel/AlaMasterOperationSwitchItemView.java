package com.baidu.tieba.ala.liveroom.master.panel;

import android.content.Context;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class AlaMasterOperationSwitchItemView extends AlaMasterOperationBaseItemView {
    private short hIY;
    private int hIZ;
    private int hJa;

    public AlaMasterOperationSwitchItemView(Context context, int i) {
        super(context, i);
        this.hIY = (short) 1;
    }

    public void setTextResIdAndOnIconIdAndOffIconId(int i, int i2, int i3) {
        setTextResId(i);
        this.hIZ = i2;
        this.hJa = i3;
        updateIcon();
    }

    public void i(short s) {
        this.hIY = s;
        updateIcon();
        XN();
    }

    private void updateIcon() {
        if (this.hIY == 1) {
            setIconResId(this.hIZ);
            setEnabled(true);
        } else if (this.hIY == 2) {
            setIconResId(this.hJa);
            setEnabled(true);
        } else {
            setIconResId(this.hIZ);
            setEnabled(false);
        }
    }

    private void XN() {
        if (this.mId == 3) {
            if (this.hIY == 1) {
                setTextResId(a.h.ala_operation_panel_text_mirror_on);
            } else if (this.hIY == 2) {
                setTextResId(a.h.ala_operation_panel_text_mirror_off);
            }
        }
    }
}

package com.baidu.tieba.ala.liveroom.master.panel;

import android.content.Context;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class AlaMasterOperationSwitchItemView extends AlaMasterOperationBaseItemView {
    private short hJm;
    private int hJn;
    private int hJo;

    public AlaMasterOperationSwitchItemView(Context context, int i) {
        super(context, i);
        this.hJm = (short) 1;
    }

    public void setTextResIdAndOnIconIdAndOffIconId(int i, int i2, int i3) {
        setTextResId(i);
        this.hJn = i2;
        this.hJo = i3;
        updateIcon();
    }

    public void i(short s) {
        this.hJm = s;
        updateIcon();
        XN();
    }

    private void updateIcon() {
        if (this.hJm == 1) {
            setIconResId(this.hJn);
            setEnabled(true);
        } else if (this.hJm == 2) {
            setIconResId(this.hJo);
            setEnabled(true);
        } else {
            setIconResId(this.hJn);
            setEnabled(false);
        }
    }

    private void XN() {
        if (this.mId == 3) {
            if (this.hJm == 1) {
                setTextResId(a.h.ala_operation_panel_text_mirror_on);
            } else if (this.hJm == 2) {
                setTextResId(a.h.ala_operation_panel_text_mirror_off);
            }
        }
    }
}

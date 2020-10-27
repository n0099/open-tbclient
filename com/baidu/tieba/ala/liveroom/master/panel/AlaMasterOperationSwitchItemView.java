package com.baidu.tieba.ala.liveroom.master.panel;

import android.content.Context;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class AlaMasterOperationSwitchItemView extends AlaMasterOperationBaseItemView {
    private short hin;
    private int hio;
    private int hip;

    public AlaMasterOperationSwitchItemView(Context context, int i) {
        super(context, i);
        this.hin = (short) 1;
    }

    public void setTextResIdAndOnIconIdAndOffIconId(int i, int i2, int i3) {
        setTextResId(i);
        this.hio = i2;
        this.hip = i3;
        ccV();
    }

    public void i(short s) {
        this.hin = s;
        ccV();
        ccW();
    }

    private void ccV() {
        if (this.hin == 1) {
            setIconResId(this.hio);
            setEnabled(true);
        } else if (this.hin == 2) {
            setIconResId(this.hip);
            setEnabled(true);
        } else {
            setIconResId(this.hio);
            setEnabled(false);
        }
    }

    private void ccW() {
        if (this.mId == 3) {
            if (this.hin == 1) {
                setTextResId(a.i.ala_operation_panel_text_mirror_on);
            } else if (this.hin == 2) {
                setTextResId(a.i.ala_operation_panel_text_mirror_off);
            }
        }
    }
}

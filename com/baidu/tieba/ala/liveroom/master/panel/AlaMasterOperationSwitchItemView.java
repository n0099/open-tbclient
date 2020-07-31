package com.baidu.tieba.ala.liveroom.master.panel;

import android.content.Context;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class AlaMasterOperationSwitchItemView extends AlaMasterOperationBaseItemView {
    private short grC;
    private int grD;
    private int grE;

    public AlaMasterOperationSwitchItemView(Context context, int i) {
        super(context, i);
        this.grC = (short) 1;
    }

    public void setTextResIdAndOnIconIdAndOffIconId(int i, int i2, int i3) {
        setTextResId(i);
        this.grD = i2;
        this.grE = i3;
        bKI();
    }

    public void h(short s) {
        this.grC = s;
        bKI();
        bKJ();
    }

    private void bKI() {
        if (this.grC == 1) {
            setIconResId(this.grD);
            setEnabled(true);
        } else if (this.grC == 2) {
            setIconResId(this.grE);
            setEnabled(true);
        } else {
            setIconResId(this.grD);
            setEnabled(false);
        }
    }

    private void bKJ() {
        if (this.mId == 3) {
            if (this.grC == 1) {
                setTextResId(a.i.ala_operation_panel_text_mirror_on);
            } else if (this.grC == 2) {
                setTextResId(a.i.ala_operation_panel_text_mirror_off);
            }
        }
    }
}

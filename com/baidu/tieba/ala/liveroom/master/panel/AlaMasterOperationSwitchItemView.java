package com.baidu.tieba.ala.liveroom.master.panel;

import android.content.Context;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class AlaMasterOperationSwitchItemView extends AlaMasterOperationBaseItemView {
    private short hnL;
    private int hnM;
    private int hnN;

    public AlaMasterOperationSwitchItemView(Context context, int i) {
        super(context, i);
        this.hnL = (short) 1;
    }

    public void setTextResIdAndOnIconIdAndOffIconId(int i, int i2, int i3) {
        setTextResId(i);
        this.hnM = i2;
        this.hnN = i3;
        ceP();
    }

    public void i(short s) {
        this.hnL = s;
        ceP();
        ceQ();
    }

    private void ceP() {
        if (this.hnL == 1) {
            setIconResId(this.hnM);
            setEnabled(true);
        } else if (this.hnL == 2) {
            setIconResId(this.hnN);
            setEnabled(true);
        } else {
            setIconResId(this.hnM);
            setEnabled(false);
        }
    }

    private void ceQ() {
        if (this.mId == 3) {
            if (this.hnL == 1) {
                setTextResId(a.h.ala_operation_panel_text_mirror_on);
            } else if (this.hnL == 2) {
                setTextResId(a.h.ala_operation_panel_text_mirror_off);
            }
        }
    }
}

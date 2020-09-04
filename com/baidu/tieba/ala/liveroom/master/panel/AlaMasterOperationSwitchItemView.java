package com.baidu.tieba.ala.liveroom.master.panel;

import android.content.Context;
import com.baidu.live.sdk.a;
/* loaded from: classes7.dex */
public class AlaMasterOperationSwitchItemView extends AlaMasterOperationBaseItemView {
    private short gEA;
    private int gEB;
    private int gEC;

    public AlaMasterOperationSwitchItemView(Context context, int i) {
        super(context, i);
        this.gEA = (short) 1;
    }

    public void setTextResIdAndOnIconIdAndOffIconId(int i, int i2, int i3) {
        setTextResId(i);
        this.gEB = i2;
        this.gEC = i3;
        bUM();
    }

    public void h(short s) {
        this.gEA = s;
        bUM();
        bUN();
    }

    private void bUM() {
        if (this.gEA == 1) {
            setIconResId(this.gEB);
            setEnabled(true);
        } else if (this.gEA == 2) {
            setIconResId(this.gEC);
            setEnabled(true);
        } else {
            setIconResId(this.gEB);
            setEnabled(false);
        }
    }

    private void bUN() {
        if (this.mId == 3) {
            if (this.gEA == 1) {
                setTextResId(a.i.ala_operation_panel_text_mirror_on);
            } else if (this.gEA == 2) {
                setTextResId(a.i.ala_operation_panel_text_mirror_off);
            }
        }
    }
}

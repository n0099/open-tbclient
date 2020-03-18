package com.baidu.tieba.ala.liveroom.master.panel;

import android.content.Context;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class AlaMasterOperationSwitchItemView extends AlaMasterOperationBaseItemView {
    private short fhg;
    private int fhh;
    private int fhi;

    public AlaMasterOperationSwitchItemView(Context context, int i) {
        super(context, i);
        this.fhg = (short) 1;
    }

    public void setTextResIdAndOnIconIdAndOffIconId(int i, int i2, int i3) {
        setTextResId(i);
        this.fhh = i2;
        this.fhi = i3;
        boY();
    }

    public void h(short s) {
        this.fhg = s;
        boY();
        boZ();
    }

    private void boY() {
        if (this.fhg == 1) {
            setIconResId(this.fhh);
            setEnabled(true);
        } else if (this.fhg == 2) {
            setIconResId(this.fhi);
            setEnabled(true);
        } else {
            setIconResId(this.fhh);
            setEnabled(false);
        }
    }

    private void boZ() {
        if (this.mId == 3) {
            if (this.fhg == 1) {
                setTextResId(a.i.ala_operation_panel_text_mirror_on);
            } else if (this.fhg == 2) {
                setTextResId(a.i.ala_operation_panel_text_mirror_off);
            }
        }
    }
}

package com.baidu.tieba.ala.liveroom.master.panel;

import android.content.Context;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class AlaMasterOperationSwitchItemView extends AlaMasterOperationBaseItemView {
    private short fgu;
    private int fgv;
    private int fgw;

    public AlaMasterOperationSwitchItemView(Context context, int i) {
        super(context, i);
        this.fgu = (short) 1;
    }

    public void setTextResIdAndOnIconIdAndOffIconId(int i, int i2, int i3) {
        setTextResId(i);
        this.fgv = i2;
        this.fgw = i3;
        boS();
    }

    public void h(short s) {
        this.fgu = s;
        boS();
        boT();
    }

    private void boS() {
        if (this.fgu == 1) {
            setIconResId(this.fgv);
            setEnabled(true);
        } else if (this.fgu == 2) {
            setIconResId(this.fgw);
            setEnabled(true);
        } else {
            setIconResId(this.fgv);
            setEnabled(false);
        }
    }

    private void boT() {
        if (this.mId == 3) {
            if (this.fgu == 1) {
                setTextResId(a.i.ala_operation_panel_text_mirror_on);
            } else if (this.fgu == 2) {
                setTextResId(a.i.ala_operation_panel_text_mirror_off);
            }
        }
    }
}

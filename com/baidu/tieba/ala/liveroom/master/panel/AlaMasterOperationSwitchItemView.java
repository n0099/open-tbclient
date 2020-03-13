package com.baidu.tieba.ala.liveroom.master.panel;

import android.content.Context;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class AlaMasterOperationSwitchItemView extends AlaMasterOperationBaseItemView {
    private short fgH;
    private int fgI;
    private int fgJ;

    public AlaMasterOperationSwitchItemView(Context context, int i) {
        super(context, i);
        this.fgH = (short) 1;
    }

    public void setTextResIdAndOnIconIdAndOffIconId(int i, int i2, int i3) {
        setTextResId(i);
        this.fgI = i2;
        this.fgJ = i3;
        boT();
    }

    public void h(short s) {
        this.fgH = s;
        boT();
        boU();
    }

    private void boT() {
        if (this.fgH == 1) {
            setIconResId(this.fgI);
            setEnabled(true);
        } else if (this.fgH == 2) {
            setIconResId(this.fgJ);
            setEnabled(true);
        } else {
            setIconResId(this.fgI);
            setEnabled(false);
        }
    }

    private void boU() {
        if (this.mId == 3) {
            if (this.fgH == 1) {
                setTextResId(a.i.ala_operation_panel_text_mirror_on);
            } else if (this.fgH == 2) {
                setTextResId(a.i.ala_operation_panel_text_mirror_off);
            }
        }
    }
}

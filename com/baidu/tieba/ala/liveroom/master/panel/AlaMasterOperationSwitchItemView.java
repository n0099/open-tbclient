package com.baidu.tieba.ala.liveroom.master.panel;

import android.content.Context;
import com.baidu.live.k.a;
/* loaded from: classes6.dex */
public class AlaMasterOperationSwitchItemView extends AlaMasterOperationBaseItemView {
    private short ekY;
    private int ekZ;
    private int ela;

    public AlaMasterOperationSwitchItemView(Context context, int i) {
        super(context, i);
        this.ekY = (short) 1;
    }

    public void setTextResIdAndOnIconIdAndOffIconId(int i, int i2, int i3) {
        setTextResId(i);
        this.ekZ = i2;
        this.ela = i3;
        aUt();
    }

    public void f(short s) {
        this.ekY = s;
        aUt();
        aUu();
    }

    private void aUt() {
        if (this.ekY == 1) {
            setIconResId(this.ekZ);
            setEnabled(true);
        } else if (this.ekY == 2) {
            setIconResId(this.ela);
            setEnabled(true);
        } else {
            setIconResId(this.ekZ);
            setEnabled(false);
        }
    }

    private void aUu() {
        if (this.mId == 3) {
            if (this.ekY == 1) {
                setTextResId(a.i.ala_operation_panel_text_mirror_on);
            } else if (this.ekY == 2) {
                setTextResId(a.i.ala_operation_panel_text_mirror_off);
            }
        }
    }
}

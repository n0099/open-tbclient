package com.baidu.tieba.ala.liveroom.master.panel;

import android.content.Context;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class AlaMasterOperationSwitchItemView extends AlaMasterOperationBaseItemView {
    private short gWx;
    private int gWy;
    private int gWz;

    public AlaMasterOperationSwitchItemView(Context context, int i) {
        super(context, i);
        this.gWx = (short) 1;
    }

    public void setTextResIdAndOnIconIdAndOffIconId(int i, int i2, int i3) {
        setTextResId(i);
        this.gWy = i2;
        this.gWz = i3;
        bZR();
    }

    public void h(short s) {
        this.gWx = s;
        bZR();
        bZS();
    }

    private void bZR() {
        if (this.gWx == 1) {
            setIconResId(this.gWy);
            setEnabled(true);
        } else if (this.gWx == 2) {
            setIconResId(this.gWz);
            setEnabled(true);
        } else {
            setIconResId(this.gWy);
            setEnabled(false);
        }
    }

    private void bZS() {
        if (this.mId == 3) {
            if (this.gWx == 1) {
                setTextResId(a.i.ala_operation_panel_text_mirror_on);
            } else if (this.gWx == 2) {
                setTextResId(a.i.ala_operation_panel_text_mirror_off);
            }
        }
    }
}

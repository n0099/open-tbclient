package com.baidu.tieba.ala.liveroom.master.panel;

import android.content.Context;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class AlaMasterOperationSwitchItemView extends AlaMasterOperationBaseItemView {
    private short gHX;
    private int gHY;
    private int gHZ;

    public AlaMasterOperationSwitchItemView(Context context, int i) {
        super(context, i);
        this.gHX = (short) 1;
    }

    public void setTextResIdAndOnIconIdAndOffIconId(int i, int i2, int i3) {
        setTextResId(i);
        this.gHY = i2;
        this.gHZ = i3;
        bWw();
    }

    public void h(short s) {
        this.gHX = s;
        bWw();
        bWx();
    }

    private void bWw() {
        if (this.gHX == 1) {
            setIconResId(this.gHY);
            setEnabled(true);
        } else if (this.gHX == 2) {
            setIconResId(this.gHZ);
            setEnabled(true);
        } else {
            setIconResId(this.gHY);
            setEnabled(false);
        }
    }

    private void bWx() {
        if (this.mId == 3) {
            if (this.gHX == 1) {
                setTextResId(a.i.ala_operation_panel_text_mirror_on);
            } else if (this.gHX == 2) {
                setTextResId(a.i.ala_operation_panel_text_mirror_off);
            }
        }
    }
}

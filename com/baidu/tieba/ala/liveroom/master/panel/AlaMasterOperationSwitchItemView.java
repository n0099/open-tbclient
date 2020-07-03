package com.baidu.tieba.ala.liveroom.master.panel;

import android.content.Context;
import com.baidu.live.sdk.a;
/* loaded from: classes3.dex */
public class AlaMasterOperationSwitchItemView extends AlaMasterOperationBaseItemView {
    private short gmE;
    private int gmF;
    private int gmG;

    public AlaMasterOperationSwitchItemView(Context context, int i) {
        super(context, i);
        this.gmE = (short) 1;
    }

    public void setTextResIdAndOnIconIdAndOffIconId(int i, int i2, int i3) {
        setTextResId(i);
        this.gmF = i2;
        this.gmG = i3;
        bHB();
    }

    public void h(short s) {
        this.gmE = s;
        bHB();
        bHC();
    }

    private void bHB() {
        if (this.gmE == 1) {
            setIconResId(this.gmF);
            setEnabled(true);
        } else if (this.gmE == 2) {
            setIconResId(this.gmG);
            setEnabled(true);
        } else {
            setIconResId(this.gmF);
            setEnabled(false);
        }
    }

    private void bHC() {
        if (this.mId == 3) {
            if (this.gmE == 1) {
                setTextResId(a.i.ala_operation_panel_text_mirror_on);
            } else if (this.gmE == 2) {
                setTextResId(a.i.ala_operation_panel_text_mirror_off);
            }
        }
    }
}

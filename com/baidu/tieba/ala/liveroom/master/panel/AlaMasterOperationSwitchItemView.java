package com.baidu.tieba.ala.liveroom.master.panel;

import android.content.Context;
import com.baidu.live.sdk.a;
/* loaded from: classes7.dex */
public class AlaMasterOperationSwitchItemView extends AlaMasterOperationBaseItemView {
    private short gEw;
    private int gEx;
    private int gEy;

    public AlaMasterOperationSwitchItemView(Context context, int i) {
        super(context, i);
        this.gEw = (short) 1;
    }

    public void setTextResIdAndOnIconIdAndOffIconId(int i, int i2, int i3) {
        setTextResId(i);
        this.gEx = i2;
        this.gEy = i3;
        bUL();
    }

    public void h(short s) {
        this.gEw = s;
        bUL();
        bUM();
    }

    private void bUL() {
        if (this.gEw == 1) {
            setIconResId(this.gEx);
            setEnabled(true);
        } else if (this.gEw == 2) {
            setIconResId(this.gEy);
            setEnabled(true);
        } else {
            setIconResId(this.gEx);
            setEnabled(false);
        }
    }

    private void bUM() {
        if (this.mId == 3) {
            if (this.gEw == 1) {
                setTextResId(a.i.ala_operation_panel_text_mirror_on);
            } else if (this.gEw == 2) {
                setTextResId(a.i.ala_operation_panel_text_mirror_off);
            }
        }
    }
}

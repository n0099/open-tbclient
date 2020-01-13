package com.baidu.tieba.ala.liveroom.master.panel;

import android.content.Context;
import com.baidu.live.r.a;
/* loaded from: classes2.dex */
public class AlaMasterOperationSwitchItemView extends AlaMasterOperationBaseItemView {
    private short fdk;
    private int fdl;
    private int fdm;

    public AlaMasterOperationSwitchItemView(Context context, int i) {
        super(context, i);
        this.fdk = (short) 1;
    }

    public void setTextResIdAndOnIconIdAndOffIconId(int i, int i2, int i3) {
        setTextResId(i);
        this.fdl = i2;
        this.fdm = i3;
        bng();
    }

    public void f(short s) {
        this.fdk = s;
        bng();
        bnh();
    }

    private void bng() {
        if (this.fdk == 1) {
            setIconResId(this.fdl);
            setEnabled(true);
        } else if (this.fdk == 2) {
            setIconResId(this.fdm);
            setEnabled(true);
        } else {
            setIconResId(this.fdl);
            setEnabled(false);
        }
    }

    private void bnh() {
        if (this.mId == 3) {
            if (this.fdk == 1) {
                setTextResId(a.i.ala_operation_panel_text_mirror_on);
            } else if (this.fdk == 2) {
                setTextResId(a.i.ala_operation_panel_text_mirror_off);
            }
        }
    }
}

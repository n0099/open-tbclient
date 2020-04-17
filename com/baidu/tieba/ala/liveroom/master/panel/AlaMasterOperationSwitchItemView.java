package com.baidu.tieba.ala.liveroom.master.panel;

import android.content.Context;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class AlaMasterOperationSwitchItemView extends AlaMasterOperationBaseItemView {
    private short fLs;
    private int fLt;
    private int fLu;

    public AlaMasterOperationSwitchItemView(Context context, int i) {
        super(context, i);
        this.fLs = (short) 1;
    }

    public void setTextResIdAndOnIconIdAndOffIconId(int i, int i2, int i3) {
        setTextResId(i);
        this.fLt = i2;
        this.fLu = i3;
        bys();
    }

    public void h(short s) {
        this.fLs = s;
        bys();
        byt();
    }

    private void bys() {
        if (this.fLs == 1) {
            setIconResId(this.fLt);
            setEnabled(true);
        } else if (this.fLs == 2) {
            setIconResId(this.fLu);
            setEnabled(true);
        } else {
            setIconResId(this.fLt);
            setEnabled(false);
        }
    }

    private void byt() {
        if (this.mId == 3) {
            if (this.fLs == 1) {
                setTextResId(a.i.ala_operation_panel_text_mirror_on);
            } else if (this.fLs == 2) {
                setTextResId(a.i.ala_operation_panel_text_mirror_off);
            }
        }
    }
}

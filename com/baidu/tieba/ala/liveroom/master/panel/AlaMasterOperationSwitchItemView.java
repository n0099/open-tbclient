package com.baidu.tieba.ala.liveroom.master.panel;

import android.content.Context;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class AlaMasterOperationSwitchItemView extends AlaMasterOperationBaseItemView {
    private short hJs;
    private int hJt;
    private int hJu;

    public AlaMasterOperationSwitchItemView(Context context, int i) {
        super(context, i);
        this.hJs = (short) 1;
    }

    public void setTextResIdAndOnIconIdAndOffIconId(int i, int i2, int i3) {
        setTextResId(i);
        this.hJt = i2;
        this.hJu = i3;
        updateIcon();
    }

    public void i(short s) {
        this.hJs = s;
        updateIcon();
        ZX();
    }

    private void updateIcon() {
        if (this.hJs == 1) {
            setIconResId(this.hJt);
            setEnabled(true);
        } else if (this.hJs == 2) {
            setIconResId(this.hJu);
            setEnabled(true);
        } else {
            setIconResId(this.hJt);
            setEnabled(false);
        }
    }

    private void ZX() {
        if (this.mId == 3) {
            if (this.hJs == 1) {
                setTextResId(a.h.ala_operation_panel_text_mirror_on);
            } else if (this.hJs == 2) {
                setTextResId(a.h.ala_operation_panel_text_mirror_off);
            }
        }
    }
}

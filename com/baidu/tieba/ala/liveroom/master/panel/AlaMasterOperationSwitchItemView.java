package com.baidu.tieba.ala.liveroom.master.panel;

import android.content.Context;
import com.baidu.live.k.a;
/* loaded from: classes6.dex */
public class AlaMasterOperationSwitchItemView extends AlaMasterOperationBaseItemView {
    private short ekh;
    private int eki;
    private int ekj;

    public AlaMasterOperationSwitchItemView(Context context, int i) {
        super(context, i);
        this.ekh = (short) 1;
    }

    public void setTextResIdAndOnIconIdAndOffIconId(int i, int i2, int i3) {
        setTextResId(i);
        this.eki = i2;
        this.ekj = i3;
        aUr();
    }

    public void e(short s) {
        this.ekh = s;
        aUr();
        aUs();
    }

    private void aUr() {
        if (this.ekh == 1) {
            setIconResId(this.eki);
            setEnabled(true);
        } else if (this.ekh == 2) {
            setIconResId(this.ekj);
            setEnabled(true);
        } else {
            setIconResId(this.eki);
            setEnabled(false);
        }
    }

    private void aUs() {
        if (this.mId == 3) {
            if (this.ekh == 1) {
                setTextResId(a.i.ala_operation_panel_text_mirror_on);
            } else if (this.ekh == 2) {
                setTextResId(a.i.ala_operation_panel_text_mirror_off);
            }
        }
    }
}

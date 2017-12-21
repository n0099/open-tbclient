package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class PbNewLocationInfoView extends TextView {
    private int mState;

    public PbNewLocationInfoView(Context context) {
        this(context, null);
    }

    public PbNewLocationInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setMaxEms(8);
        setSingleLine(true);
        setEllipsize(TextUtils.TruncateAt.END);
        setTextSize(0, l.f(context, d.e.ds24));
        k(0, null);
    }

    public void k(int i, String str) {
        this.mState = i;
        if (i == 1) {
            if (str == null) {
                str = getResources().getString(d.j.location_loading);
            }
            setText(str);
        } else if (i == 2) {
            if (str == null) {
                str = getResources().getString(d.j.location_default);
            }
            setText(str);
        } else {
            if (str == null) {
                str = getResources().getString(d.j.location_default);
            }
            setText(str);
        }
    }

    public int getState() {
        return this.mState;
    }

    public void onChangeSkinType() {
        setTextColor(aj.getColor(d.C0095d.cp_cont_f));
    }
}

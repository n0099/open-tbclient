package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
/* loaded from: classes3.dex */
public class PbNewLocationInfoView extends TextView {

    /* renamed from: e  reason: collision with root package name */
    public int f13559e;

    public PbNewLocationInfoView(Context context) {
        this(context, null);
    }

    public int getState() {
        return this.f13559e;
    }

    public void setState(int i, String str) {
        this.f13559e = i;
        if (i == 1) {
            if (str == null) {
                str = getResources().getString(R.string.location_loading);
            }
            setText(str);
        } else if (i == 2) {
            if (str == null) {
                str = getResources().getString(R.string.location_default);
            }
            setText(str);
        } else {
            if (str == null) {
                str = getResources().getString(R.string.location_default);
            }
            setText(str);
        }
    }

    public PbNewLocationInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setMaxEms(8);
        setSingleLine(true);
        setEllipsize(TextUtils.TruncateAt.END);
        setTextSize(0, l.g(context, R.dimen.ds24));
        setState(0, null);
    }
}

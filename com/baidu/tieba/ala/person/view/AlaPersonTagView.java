package com.baidu.tieba.ala.person.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes7.dex */
public class AlaPersonTagView extends TextView {
    public AlaPersonTagView(Context context) {
        this(context, null);
    }

    public AlaPersonTagView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AlaPersonTagView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        dL(context);
    }

    private void dL(Context context) {
        setCompoundDrawablePadding(context.getResources().getDimensionPixelSize(a.e.sdk_ds4));
        setEllipsize(TextUtils.TruncateAt.END);
        setGravity(17);
        setSingleLine();
        setIncludeFontPadding(false);
        setPadding(context.getResources().getDimensionPixelSize(a.e.sdk_ds14), 0, context.getResources().getDimensionPixelSize(a.e.sdk_ds14), 0);
        setTextSize(12.0f);
    }

    public void setAddTagView() {
        setBackgroundResource(a.f.bg_ala_person_add_tag);
        setTextColor(getResources().getColor(a.d.sdk_common_color_10106));
        setCompoundDrawablesWithIntrinsicBounds(a.f.icon_add_tag, 0, 0, 0);
        setText(a.i.ala_person_add_tag);
    }

    public void setTagView(String str, int i) {
        setBackgroundResource(i);
        setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
        setText(str);
    }
}

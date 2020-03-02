package com.baidu.tieba.ala.liveroom.master.panel;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.u.a;
import com.baidu.live.utils.d;
/* loaded from: classes3.dex */
public class AlaMasterOperationBaseItemView extends LinearLayout {
    private TextView bpp;
    private ImageView mIconView;
    public int mId;

    public AlaMasterOperationBaseItemView(Context context, int i) {
        super(context);
        setOrientation(1);
        this.mId = i;
        setGravity(49);
        setPadding(0, context.getResources().getDimensionPixelSize(a.e.sdk_ds16), 0, 0);
        LayoutInflater.from(context).inflate(a.h.ala_gridview_item, this);
        this.bpp = (TextView) findViewById(a.g.contentTv);
        this.mIconView = (ImageView) findViewById(a.g.icon_img);
    }

    public int getItemId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setTextResId(int i) {
        if (i > 0) {
            this.bpp.setText(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setIconResId(int i) {
        if (i > 0) {
            Drawable drawable = getContext().getResources().getDrawable(i);
            if (drawable instanceof StateListDrawable) {
                this.mIconView.setImageDrawable(drawable);
            } else {
                this.mIconView.setImageDrawable(d.a(getResources(), i));
            }
        }
    }

    protected void setTextColorResId(int i) {
        this.bpp.setTextColor(getResources().getColor(i));
        this.bpp.setAlpha(0.7f);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.bpp.setEnabled(z);
        this.mIconView.setEnabled(z);
    }
}

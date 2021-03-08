package com.baidu.tieba.ala.liveroom.master.panel;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.utils.e;
/* loaded from: classes10.dex */
public class AlaMasterOperationBaseItemView extends LinearLayout {
    private TextView cVd;
    private ImageView mIconView;
    public int mId;

    public AlaMasterOperationBaseItemView(Context context, int i) {
        super(context);
        setOrientation(1);
        this.mId = i;
        setGravity(49);
        setPadding(0, context.getResources().getDimensionPixelSize(a.d.sdk_ds16), 0, 0);
        LayoutInflater.from(context).inflate(a.g.ala_gridview_item, this);
        this.cVd = (TextView) findViewById(a.f.contentTv);
        this.mIconView = (ImageView) findViewById(a.f.icon_img);
    }

    public int getItemId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setTextResId(int i) {
        if (i > 0) {
            this.cVd.setText(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setIconResId(int i) {
        if (i > 0) {
            Drawable drawable = getContext().getResources().getDrawable(i);
            if (drawable instanceof StateListDrawable) {
                this.mIconView.setImageDrawable(drawable);
            } else {
                this.mIconView.setImageDrawable(e.a(getResources(), i));
            }
        }
    }

    protected void setTextColorResId(int i) {
        this.cVd.setTextColor(getResources().getColor(i));
        this.cVd.setAlpha(0.7f);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.cVd.setEnabled(z);
        this.mIconView.setEnabled(z);
    }
}

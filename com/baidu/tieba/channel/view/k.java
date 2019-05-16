package com.baidu.tieba.channel.view;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class k extends PopupWindow {
    private View mContentView;

    public k(Activity activity, View view) {
        super(activity);
        this.mContentView = null;
        f(activity, view);
    }

    private void f(Activity activity, View view) {
        this.mContentView = view;
        setContentView(this.mContentView);
        setOutsideTouchable(true);
        setFocusable(true);
        setHeight(-1);
        setWidth(-1);
        setSoftInputMode(16);
        setBackgroundDrawable(new ColorDrawable(activity.getResources().getColor(R.color.common_color_10022)));
        setAnimationStyle(R.style.channel_more_pop_anim);
    }

    @Override // android.widget.PopupWindow
    public View getContentView() {
        return this.mContentView;
    }
}

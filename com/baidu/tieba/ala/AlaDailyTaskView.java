package com.baidu.tieba.ala;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.sdk.a;
import com.baidu.live.view.web.CommonWebLayout;
/* loaded from: classes10.dex */
public class AlaDailyTaskView extends RelativeLayout {
    private ViewGroup bLa;
    private CommonWebLayout bXc;

    public AlaDailyTaskView(ViewGroup viewGroup) {
        this(viewGroup.getContext(), null);
    }

    public AlaDailyTaskView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AlaDailyTaskView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    public CommonWebLayout getWebView() {
        return this.bXc;
    }

    private void initView() {
        this.bLa = (ViewGroup) LayoutInflater.from(getContext()).inflate(a.g.sdk_daily_task_layout, (ViewGroup) this, true);
        x(this.bLa);
    }

    private void x(ViewGroup viewGroup) {
        this.bXc = new CommonWebLayout(getContext());
        this.bXc.setScrollEnabled(false, false);
        this.bXc.setRequestDisallowInterceptTouchEvent(false);
        viewGroup.addView(this.bXc, -1, -1);
    }
}

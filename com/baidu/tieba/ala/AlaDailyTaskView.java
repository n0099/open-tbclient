package com.baidu.tieba.ala;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.sdk.a;
import com.baidu.live.view.web.CommonWebLayout;
/* loaded from: classes11.dex */
public class AlaDailyTaskView extends RelativeLayout {
    private ViewGroup bJA;
    private CommonWebLayout bVC;

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
        return this.bVC;
    }

    private void initView() {
        this.bJA = (ViewGroup) LayoutInflater.from(getContext()).inflate(a.g.sdk_daily_task_layout, (ViewGroup) this, true);
        x(this.bJA);
    }

    private void x(ViewGroup viewGroup) {
        this.bVC = new CommonWebLayout(getContext());
        this.bVC.setScrollEnabled(false, false);
        this.bVC.setRequestDisallowInterceptTouchEvent(false);
        viewGroup.addView(this.bVC, -1, -1);
    }
}

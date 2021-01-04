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
    private ViewGroup bKC;
    private CommonWebLayout byR;

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
        return this.byR;
    }

    private void initView() {
        this.bKC = (ViewGroup) LayoutInflater.from(getContext()).inflate(a.g.sdk_daily_task_layout, (ViewGroup) this, true);
        q(this.bKC);
    }

    private void q(ViewGroup viewGroup) {
        this.byR = new CommonWebLayout(getContext());
        this.byR.setScrollEnabled(false, false);
        this.byR.setRequestDisallowInterceptTouchEvent(false);
        viewGroup.addView(this.byR, -1, -1);
    }
}

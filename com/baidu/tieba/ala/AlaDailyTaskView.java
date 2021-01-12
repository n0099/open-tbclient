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
    private ViewGroup bFQ;
    private CommonWebLayout bue;

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
        return this.bue;
    }

    private void initView() {
        this.bFQ = (ViewGroup) LayoutInflater.from(getContext()).inflate(a.g.sdk_daily_task_layout, (ViewGroup) this, true);
        q(this.bFQ);
    }

    private void q(ViewGroup viewGroup) {
        this.bue = new CommonWebLayout(getContext());
        this.bue.setScrollEnabled(false, false);
        this.bue.setRequestDisallowInterceptTouchEvent(false);
        viewGroup.addView(this.bue, -1, -1);
    }
}

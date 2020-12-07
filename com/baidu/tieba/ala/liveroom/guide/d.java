package com.baidu.tieba.ala.liveroom.guide;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper;
/* loaded from: classes4.dex */
public class d {
    private RelativeLayout hsF;
    private AlaLivePriseGuideView hsG;
    private TbPageContext mTbPageContext;

    public d(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void ax(ViewGroup viewGroup) {
        boolean z = SharedPrefHelper.getInstance().getBoolean("live_root_key_guide_double_click_praise", false);
        if (viewGroup != null && this.mTbPageContext != null && !z && this.hsG == null) {
            this.hsG = new AlaLivePriseGuideView(this.mTbPageContext.getPageActivity());
            this.hsG.setOrientation(1);
            TextView textView = new TextView(this.mTbPageContext.getPageActivity());
            textView.setText("为主播点赞");
            textView.setTextColor(-1);
            textView.setTextSize(22.0f);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 1;
            layoutParams.topMargin = 20;
            this.hsG.addView(textView, layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(13, -1);
            this.hsF = new RelativeLayout(this.mTbPageContext.getPageActivity());
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
            this.hsF.setBackgroundResource(a.c.sdk_black_alpha50);
            this.hsF.addView(this.hsG, layoutParams2);
            this.hsF.setTag("AlaLivePraiseGuideController");
            viewGroup.addView(this.hsF, layoutParams3);
            this.hsF.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.guide.d.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    d.this.cfO();
                    return false;
                }
            });
            SharedPrefHelper.getInstance().putBoolean("live_root_key_guide_double_click_praise", true);
        }
    }

    public boolean cfO() {
        if (this.hsG == null || !this.hsG.cfO()) {
            return false;
        }
        if (this.hsF != null && this.hsF.getParent() != null) {
            ((ViewGroup) this.hsF.getParent()).removeView(this.hsF);
        }
        return true;
    }
}

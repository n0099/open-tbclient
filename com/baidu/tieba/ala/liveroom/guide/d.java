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
    private AlaLivePriseGuideView gDA;
    private RelativeLayout gDz;
    private TbPageContext mTbPageContext;

    public d(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void ax(ViewGroup viewGroup) {
        boolean z = SharedPrefHelper.getInstance().getBoolean("live_root_key_guide_double_click_praise", false);
        if (viewGroup != null && this.mTbPageContext != null && !z && this.gDA == null) {
            this.gDA = new AlaLivePriseGuideView(this.mTbPageContext.getPageActivity());
            this.gDA.setOrientation(1);
            TextView textView = new TextView(this.mTbPageContext.getPageActivity());
            textView.setText("为主播点赞");
            textView.setTextColor(-1);
            textView.setTextSize(22.0f);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 1;
            layoutParams.topMargin = 20;
            this.gDA.addView(textView, layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(13, -1);
            this.gDz = new RelativeLayout(this.mTbPageContext.getPageActivity());
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
            this.gDz.setBackgroundResource(a.d.sdk_black_alpha50);
            this.gDz.addView(this.gDA, layoutParams2);
            this.gDz.setTag("AlaLivePraiseGuideController");
            viewGroup.addView(this.gDz, layoutParams3);
            this.gDz.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.guide.d.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    d.this.bTJ();
                    return false;
                }
            });
            SharedPrefHelper.getInstance().putBoolean("live_root_key_guide_double_click_praise", true);
        }
    }

    public boolean bTJ() {
        if (this.gDA == null || !this.gDA.bTJ()) {
            return false;
        }
        if (this.gDz != null && this.gDz.getParent() != null) {
            ((ViewGroup) this.gDz.getParent()).removeView(this.gDz);
        }
        return true;
    }
}

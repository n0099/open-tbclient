package com.baidu.tieba.ala.liveroom.guide;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class d {
    private RelativeLayout fcD;
    private AlaLivePriseGuideView fcE;
    private TbPageContext mTbPageContext;

    public d(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void ai(ViewGroup viewGroup) {
        boolean z = SharedPrefHelper.getInstance().getBoolean("live_root_key_guide_double_click_praise", false);
        if (viewGroup != null && this.mTbPageContext != null && !z && this.fcE == null) {
            this.fcE = new AlaLivePriseGuideView(this.mTbPageContext.getPageActivity());
            this.fcE.setOrientation(1);
            TextView textView = new TextView(this.mTbPageContext.getPageActivity());
            textView.setText("为主播点赞");
            textView.setTextColor(-1);
            textView.setTextSize(22.0f);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 1;
            layoutParams.topMargin = 20;
            this.fcE.addView(textView, layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(13, -1);
            this.fcD = new RelativeLayout(this.mTbPageContext.getPageActivity());
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
            this.fcD.setBackgroundResource(a.d.sdk_black_alpha50);
            this.fcD.addView(this.fcE, layoutParams2);
            this.fcD.setTag("AlaLivePraiseGuideController");
            viewGroup.addView(this.fcD, layoutParams3);
            this.fcD.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.guide.d.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    d.this.bmz();
                    return false;
                }
            });
            SharedPrefHelper.getInstance().putBoolean("live_root_key_guide_double_click_praise", true);
        }
    }

    public boolean bmz() {
        if (this.fcE == null || !this.fcE.bmz()) {
            return false;
        }
        if (this.fcD != null && this.fcD.getParent() != null) {
            ((ViewGroup) this.fcD.getParent()).removeView(this.fcD);
        }
        return true;
    }
}

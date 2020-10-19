package com.baidu.tieba.ala.liveroom.activeview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.CountDownTimer;
import android.support.v4.graphics.ColorUtils;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.data.bf;
import com.baidu.live.data.l;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.x.d;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaActiveDynamicView extends RelativeLayout implements c {
    private TbImageView fPO;
    private a gCI;
    private l gCJ;
    private ViewGroup gCK;
    private View gCL;
    private TextView gCM;
    private TextView gCN;
    private TextView gCO;
    private TextView gCP;
    private ViewGroup gCQ;
    private View gCR;
    private TextView gCS;
    private TextView gCT;
    private TextView gCU;
    private ProgressBar gCV;
    private ForegroundColorSpan gCW;
    private ForegroundColorSpan gCX;
    private int gCY;
    private long mEndTime;
    private int mTextColor;
    private CountDownTimer mTimer;

    /* loaded from: classes4.dex */
    public interface a {
        void b(l lVar);
    }

    public AlaActiveDynamicView(Context context) {
        super(context);
        init();
    }

    public AlaActiveDynamicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.gCI = aVar;
    }

    public l getActivityInfo() {
        return this.gCJ;
    }

    public void setActivityInfo(l lVar) {
        this.gCJ = lVar;
    }

    public void setData(String str, bf bfVar) {
        a(bfVar);
        this.fPO.startLoad(str, 10, false);
        this.gCM.setText(bfVar.text);
        this.gCM.setTextColor(this.mTextColor);
        this.gCN.setText(bfVar.point);
        this.gCN.setTextColor(this.gCY);
        setLayoutBg(bfVar);
        setValues(bfVar);
        bRn();
    }

    public void setTimer(String str) {
        this.gCS.setText(str);
        if (this.gCK.getVisibility() != 8) {
            this.gCK.setVisibility(8);
        }
        if (this.gCQ.getVisibility() != 0) {
            this.gCQ.setVisibility(0);
        }
    }

    private void bMg() {
        this.mEndTime = 0L;
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        d.OZ().Pb();
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStart() {
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStop() {
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void release() {
        bMg();
        this.gCI = null;
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.h.ala_active_dynamic, (ViewGroup) this, true);
        this.fPO = (TbImageView) findViewById(a.g.iv_bg);
        this.gCK = (ViewGroup) findViewById(a.g.layout_data);
        this.gCL = findViewById(a.g.divider_data);
        this.gCM = (TextView) findViewById(a.g.tv_data_title);
        this.gCN = (TextView) findViewById(a.g.tv_data_point);
        this.gCO = (TextView) findViewById(a.g.tv_data_a);
        this.gCP = (TextView) findViewById(a.g.tv_data_b);
        this.gCQ = (ViewGroup) findViewById(a.g.layout_timer);
        this.gCR = findViewById(a.g.divider_timer);
        this.gCS = (TextView) findViewById(a.g.tv_timer_title);
        this.gCT = (TextView) findViewById(a.g.tv_timer_tip);
        this.gCU = (TextView) findViewById(a.g.tv_timer_num);
        this.gCV = (ProgressBar) findViewById(a.g.pb_timer);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveDynamicView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaActiveDynamicView.this.gCI != null) {
                    AlaActiveDynamicView.this.gCI.b(AlaActiveDynamicView.this.gCJ);
                }
            }
        });
    }

    private void a(bf bfVar) {
        boolean z;
        boolean z2 = true;
        if (TextUtils.isEmpty(bfVar.aND)) {
            z = false;
        } else {
            try {
                this.mTextColor = Color.parseColor(bfVar.aND);
                z = true;
            } catch (Exception e) {
                z = false;
            }
        }
        if (!z) {
            this.mTextColor = getResources().getColor(a.d.sdk_active_normal);
        }
        if (TextUtils.isEmpty(bfVar.aNE)) {
            z2 = false;
        } else {
            try {
                this.gCY = Color.parseColor(bfVar.aNE);
            } catch (Exception e2) {
                z2 = false;
            }
        }
        if (!z2) {
            this.gCY = getResources().getColor(a.d.sdk_active_highlight);
        }
        this.gCW = new ForegroundColorSpan(this.mTextColor);
        this.gCX = new ForegroundColorSpan(this.gCY);
    }

    private void setLayoutBg(bf bfVar) {
        int i;
        boolean z;
        int parseColor;
        int parseColor2;
        int i2 = 0;
        String str = bfVar.aNF;
        if (TextUtils.isEmpty(str)) {
            i = 0;
            z = false;
        } else {
            try {
                i2 = Color.parseColor(str);
                z = true;
                i = i2;
            } catch (Exception e) {
                i = 0;
                z = false;
            }
        }
        if (z) {
            int i3 = -1;
            String str2 = bfVar.aNG;
            if (!TextUtils.isEmpty(str2)) {
                try {
                    i3 = Integer.parseInt(str2);
                } catch (Exception e2) {
                }
                if (i3 >= 0 && i3 <= 100) {
                    i = ColorUtils.setAlphaComponent(i, ((100 - i3) * 255) / 100);
                }
            }
            int i4 = i2;
            parseColor = i;
            parseColor2 = i4;
        } else {
            parseColor = Color.parseColor("#9A000000");
            parseColor2 = Color.parseColor("#26D8D8D8");
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds8));
        gradientDrawable.setColor(parseColor);
        this.gCK.setBackgroundDrawable(gradientDrawable);
        this.gCQ.setBackgroundDrawable(gradientDrawable);
        this.gCL.setBackgroundColor(parseColor2);
        this.gCR.setBackgroundColor(parseColor2);
    }

    private void setValues(bf bfVar) {
        List<bf.a> list = bfVar.aNC;
        if (list != null) {
            bf.a aVar = list.get(0);
            if (aVar != null) {
                SpannableString spannableString = new SpannableString(aVar.text + "：" + aVar.value);
                spannableString.setSpan(this.gCW, 0, aVar.text.length() + 1, 18);
                spannableString.setSpan(this.gCX, aVar.text.length() + 1, spannableString.length(), 18);
                this.gCO.setText(spannableString);
            }
            bf.a aVar2 = list.get(1);
            if (aVar2 != null) {
                SpannableString spannableString2 = new SpannableString(aVar2.text + "：" + aVar2.value);
                spannableString2.setSpan(this.gCW, 0, aVar2.text.length() + 1, 18);
                spannableString2.setSpan(this.gCX, aVar2.text.length() + 1, spannableString2.length(), 18);
                this.gCP.setText(spannableString2);
            }
        }
    }

    private void bRn() {
        this.gCS.setTextColor(this.gCY);
        this.gCT.setTextColor(this.mTextColor);
        this.gCU.setTextColor(this.mTextColor);
    }
}

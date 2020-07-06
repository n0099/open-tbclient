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
import com.baidu.live.data.ax;
import com.baidu.live.data.i;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.v.d;
import java.util.List;
/* loaded from: classes3.dex */
public class AlaActiveDynamicView extends RelativeLayout implements c {
    private a fTN;
    private i fTO;
    private ViewGroup fTP;
    private View fTQ;
    private TextView fTR;
    private TextView fTS;
    private TextView fTT;
    private TextView fTU;
    private ViewGroup fTV;
    private View fTW;
    private TextView fTX;
    private TextView fTY;
    private TextView fTZ;
    private ProgressBar fUa;
    private ForegroundColorSpan fUb;
    private ForegroundColorSpan fUc;
    private int fUd;
    private TbImageView fjL;
    private long mEndTime;
    private int mTextColor;
    private CountDownTimer mTimer;

    /* loaded from: classes3.dex */
    public interface a {
        void b(i iVar);
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
        this.fTN = aVar;
    }

    public i getActivityInfo() {
        return this.fTO;
    }

    public void setActivityInfo(i iVar) {
        this.fTO = iVar;
    }

    public void setData(String str, ax axVar) {
        a(axVar);
        this.fjL.startLoad(str, 10, false);
        this.fTR.setText(axVar.text);
        this.fTR.setTextColor(this.mTextColor);
        this.fTS.setText(axVar.point);
        this.fTS.setTextColor(this.fUd);
        setLayoutBg(axVar);
        setValues(axVar);
        bAd();
    }

    public void setTimer(String str) {
        this.fTX.setText(str);
        if (this.fTP.getVisibility() != 8) {
            this.fTP.setVisibility(8);
        }
        if (this.fTV.getVisibility() != 0) {
            this.fTV.setVisibility(0);
        }
    }

    private void bvZ() {
        this.mEndTime = 0L;
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        d.Ht().Hv();
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStart() {
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStop() {
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void release() {
        bvZ();
        this.fTN = null;
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.h.ala_active_dynamic, (ViewGroup) this, true);
        this.fjL = (TbImageView) findViewById(a.g.iv_bg);
        this.fTP = (ViewGroup) findViewById(a.g.layout_data);
        this.fTQ = findViewById(a.g.divider_data);
        this.fTR = (TextView) findViewById(a.g.tv_data_title);
        this.fTS = (TextView) findViewById(a.g.tv_data_point);
        this.fTT = (TextView) findViewById(a.g.tv_data_a);
        this.fTU = (TextView) findViewById(a.g.tv_data_b);
        this.fTV = (ViewGroup) findViewById(a.g.layout_timer);
        this.fTW = findViewById(a.g.divider_timer);
        this.fTX = (TextView) findViewById(a.g.tv_timer_title);
        this.fTY = (TextView) findViewById(a.g.tv_timer_tip);
        this.fTZ = (TextView) findViewById(a.g.tv_timer_num);
        this.fUa = (ProgressBar) findViewById(a.g.pb_timer);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveDynamicView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaActiveDynamicView.this.fTN != null) {
                    AlaActiveDynamicView.this.fTN.b(AlaActiveDynamicView.this.fTO);
                }
            }
        });
    }

    private void a(ax axVar) {
        boolean z;
        boolean z2 = true;
        if (TextUtils.isEmpty(axVar.aCB)) {
            z = false;
        } else {
            try {
                this.mTextColor = Color.parseColor(axVar.aCB);
                z = true;
            } catch (Exception e) {
                z = false;
            }
        }
        if (!z) {
            this.mTextColor = getResources().getColor(a.d.sdk_active_normal);
        }
        if (TextUtils.isEmpty(axVar.aCC)) {
            z2 = false;
        } else {
            try {
                this.fUd = Color.parseColor(axVar.aCC);
            } catch (Exception e2) {
                z2 = false;
            }
        }
        if (!z2) {
            this.fUd = getResources().getColor(a.d.sdk_active_highlight);
        }
        this.fUb = new ForegroundColorSpan(this.mTextColor);
        this.fUc = new ForegroundColorSpan(this.fUd);
    }

    private void setLayoutBg(ax axVar) {
        int i;
        boolean z;
        int parseColor;
        int parseColor2;
        int i2 = 0;
        String str = axVar.aCD;
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
            String str2 = axVar.aCE;
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
        this.fTP.setBackgroundDrawable(gradientDrawable);
        this.fTV.setBackgroundDrawable(gradientDrawable);
        this.fTQ.setBackgroundColor(parseColor2);
        this.fTW.setBackgroundColor(parseColor2);
    }

    private void setValues(ax axVar) {
        List<ax.a> list = axVar.aCA;
        if (list != null) {
            ax.a aVar = list.get(0);
            if (aVar != null) {
                SpannableString spannableString = new SpannableString(aVar.text + "：" + aVar.value);
                spannableString.setSpan(this.fUb, 0, aVar.text.length() + 1, 18);
                spannableString.setSpan(this.fUc, aVar.text.length() + 1, spannableString.length(), 18);
                this.fTT.setText(spannableString);
            }
            ax.a aVar2 = list.get(1);
            if (aVar2 != null) {
                SpannableString spannableString2 = new SpannableString(aVar2.text + "：" + aVar2.value);
                spannableString2.setSpan(this.fUb, 0, aVar2.text.length() + 1, 18);
                spannableString2.setSpan(this.fUc, aVar2.text.length() + 1, spannableString2.length(), 18);
                this.fTU.setText(spannableString2);
            }
        }
    }

    private void bAd() {
        this.fTX.setTextColor(this.fUd);
        this.fTY.setTextColor(this.mTextColor);
        this.fTZ.setTextColor(this.mTextColor);
    }
}

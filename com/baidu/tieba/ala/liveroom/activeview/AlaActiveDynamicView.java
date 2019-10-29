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
import com.baidu.live.data.ad;
import com.baidu.live.k.a;
import com.baidu.live.l.d;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.utils.i;
import java.util.List;
/* loaded from: classes6.dex */
public class AlaActiveDynamicView extends RelativeLayout implements c {
    private long baF;
    private TextView dVA;
    private ViewGroup dVB;
    private View dVC;
    private TextView dVD;
    private TextView dVE;
    private TextView dVF;
    private ProgressBar dVG;
    private ForegroundColorSpan dVH;
    private ForegroundColorSpan dVI;
    private int dVJ;
    private a dVs;
    private com.baidu.live.data.c dVt;
    private TbImageView dVu;
    private ViewGroup dVv;
    private View dVw;
    private TextView dVx;
    private TextView dVy;
    private TextView dVz;
    private int mStyle;
    private int mTextColor;
    private CountDownTimer mTimer;

    /* loaded from: classes6.dex */
    public interface a {
        void b(com.baidu.live.data.c cVar);
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
        this.dVs = aVar;
    }

    public com.baidu.live.data.c getActivityInfo() {
        return this.dVt;
    }

    public void setActivityInfo(com.baidu.live.data.c cVar) {
        this.dVt = cVar;
    }

    public void nl(int i) {
        if (this.dVv != null && this.dVB != null && i != this.mStyle) {
            this.mStyle = i;
            switch (i) {
                case 1:
                    if (this.dVv.getVisibility() != 0) {
                        this.dVv.setVisibility(0);
                    }
                    if (this.dVB.getVisibility() != 8) {
                        this.dVB.setVisibility(8);
                    }
                    aNN();
                    return;
                case 2:
                    if (this.dVv.getVisibility() != 8) {
                        this.dVv.setVisibility(8);
                    }
                    if (this.dVB.getVisibility() != 0) {
                        this.dVB.setVisibility(0);
                        return;
                    }
                    return;
                default:
                    aNN();
                    return;
            }
        }
    }

    public void setData(String str, ad adVar) {
        a(adVar);
        this.dVu.startLoad(str, 10, false);
        this.dVx.setText(adVar.text);
        this.dVx.setTextColor(this.mTextColor);
        this.dVy.setText(adVar.TS);
        this.dVy.setTextColor(this.dVJ);
        setLayoutBg(adVar);
        setValues(adVar);
        aNO();
    }

    public void setTimer(String str) {
        this.dVD.setText(str);
        if (this.dVv.getVisibility() != 8) {
            this.dVv.setVisibility(8);
        }
        if (this.dVB.getVisibility() != 0) {
            this.dVB.setVisibility(0);
        }
    }

    public void p(final long j, long j2) {
        if (j2 != this.baF) {
            aNN();
            this.baF = j2;
            d.uI().D(j);
            this.mTimer = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveDynamicView.1
                @Override // android.os.CountDownTimer
                public void onTick(long j3) {
                    AlaActiveDynamicView.this.aj(i.H(j3), (int) ((1.0f - ((((float) j3) * 1.0f) / ((float) j))) * 100.0f));
                    d.uI().D(j3);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    AlaActiveDynamicView.this.nl(1);
                }
            };
            this.mTimer.start();
        }
    }

    private void aNN() {
        this.baF = 0L;
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        d.uI().uK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aj(String str, int i) {
        if (this.dVF != null && this.dVG != null) {
            this.dVF.setText(str);
            this.dVG.setProgress(i);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStart() {
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStop() {
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void release() {
        aNN();
        this.dVs = null;
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.h.ala_active_dynamic, (ViewGroup) this, true);
        this.dVu = (TbImageView) findViewById(a.g.iv_bg);
        this.dVv = (ViewGroup) findViewById(a.g.layout_data);
        this.dVw = findViewById(a.g.divider_data);
        this.dVx = (TextView) findViewById(a.g.tv_data_title);
        this.dVy = (TextView) findViewById(a.g.tv_data_point);
        this.dVz = (TextView) findViewById(a.g.tv_data_a);
        this.dVA = (TextView) findViewById(a.g.tv_data_b);
        this.dVB = (ViewGroup) findViewById(a.g.layout_timer);
        this.dVC = findViewById(a.g.divider_timer);
        this.dVD = (TextView) findViewById(a.g.tv_timer_title);
        this.dVE = (TextView) findViewById(a.g.tv_timer_tip);
        this.dVF = (TextView) findViewById(a.g.tv_timer_num);
        this.dVG = (ProgressBar) findViewById(a.g.pb_timer);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveDynamicView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaActiveDynamicView.this.dVs != null) {
                    AlaActiveDynamicView.this.dVs.b(AlaActiveDynamicView.this.dVt);
                }
            }
        });
    }

    private void a(ad adVar) {
        boolean z;
        boolean z2 = true;
        if (TextUtils.isEmpty(adVar.TU)) {
            z = false;
        } else {
            try {
                this.mTextColor = Color.parseColor(adVar.TU);
                z = true;
            } catch (Exception e) {
                z = false;
            }
        }
        if (!z) {
            this.mTextColor = getResources().getColor(a.d.sdk_active_normal);
        }
        if (TextUtils.isEmpty(adVar.TV)) {
            z2 = false;
        } else {
            try {
                this.dVJ = Color.parseColor(adVar.TV);
            } catch (Exception e2) {
                z2 = false;
            }
        }
        if (!z2) {
            this.dVJ = getResources().getColor(a.d.sdk_active_highlight);
        }
        this.dVH = new ForegroundColorSpan(this.mTextColor);
        this.dVI = new ForegroundColorSpan(this.dVJ);
    }

    private void setLayoutBg(ad adVar) {
        int i;
        boolean z;
        int parseColor;
        int parseColor2;
        int i2 = 0;
        String str = adVar.TW;
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
            String str2 = adVar.TX;
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
        this.dVv.setBackgroundDrawable(gradientDrawable);
        this.dVB.setBackgroundDrawable(gradientDrawable);
        this.dVw.setBackgroundColor(parseColor2);
        this.dVC.setBackgroundColor(parseColor2);
    }

    private void setValues(ad adVar) {
        List<ad.a> list = adVar.TT;
        if (list != null) {
            ad.a aVar = list.get(0);
            if (aVar != null) {
                SpannableString spannableString = new SpannableString(aVar.text + "：" + aVar.value);
                spannableString.setSpan(this.dVH, 0, aVar.text.length() + 1, 18);
                spannableString.setSpan(this.dVI, aVar.text.length() + 1, spannableString.length(), 18);
                this.dVz.setText(spannableString);
            }
            ad.a aVar2 = list.get(1);
            if (aVar2 != null) {
                SpannableString spannableString2 = new SpannableString(aVar2.text + "：" + aVar2.value);
                spannableString2.setSpan(this.dVH, 0, aVar2.text.length() + 1, 18);
                spannableString2.setSpan(this.dVI, aVar2.text.length() + 1, spannableString2.length(), 18);
                this.dVA.setText(spannableString2);
            }
        }
    }

    private void aNO() {
        this.dVD.setTextColor(this.dVJ);
        this.dVE.setTextColor(this.mTextColor);
        this.dVF.setTextColor(this.mTextColor);
    }
}

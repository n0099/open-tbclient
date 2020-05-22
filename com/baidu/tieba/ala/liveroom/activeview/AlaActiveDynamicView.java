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
import com.baidu.live.data.at;
import com.baidu.live.data.i;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
import com.baidu.live.utils.j;
import com.baidu.live.v.d;
import java.util.List;
/* loaded from: classes3.dex */
public class AlaActiveDynamicView extends RelativeLayout implements c {
    private TbImageView eYM;
    private TextView fIA;
    private TextView fIB;
    private ViewGroup fIC;
    private View fID;
    private TextView fIE;
    private TextView fIF;
    private TextView fIG;
    private ProgressBar fIH;
    private ForegroundColorSpan fII;
    private ForegroundColorSpan fIJ;
    private int fIK;
    private a fIu;
    private i fIv;
    private ViewGroup fIw;
    private View fIx;
    private TextView fIy;
    private TextView fIz;
    private long mEndTime;
    private int mStyle;
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
        this.fIu = aVar;
    }

    public i getActivityInfo() {
        return this.fIv;
    }

    public void setActivityInfo(i iVar) {
        this.fIv = iVar;
    }

    public void pV(int i) {
        if (this.fIw != null && this.fIC != null && i != this.mStyle) {
            this.mStyle = i;
            switch (i) {
                case 1:
                    if (this.fIw.getVisibility() != 0) {
                        this.fIw.setVisibility(0);
                    }
                    if (this.fIC.getVisibility() != 8) {
                        this.fIC.setVisibility(8);
                    }
                    btc();
                    return;
                case 2:
                    if (this.fIw.getVisibility() != 8) {
                        this.fIw.setVisibility(8);
                    }
                    if (this.fIC.getVisibility() != 0) {
                        this.fIC.setVisibility(0);
                        return;
                    }
                    return;
                default:
                    btc();
                    return;
            }
        }
    }

    public void setData(String str, at atVar) {
        a(atVar);
        this.eYM.startLoad(str, 10, false);
        this.fIy.setText(atVar.text);
        this.fIy.setTextColor(this.mTextColor);
        this.fIz.setText(atVar.point);
        this.fIz.setTextColor(this.fIK);
        setLayoutBg(atVar);
        setValues(atVar);
        bxg();
    }

    public void setTimer(String str) {
        this.fIE.setText(str);
        if (this.fIw.getVisibility() != 8) {
            this.fIw.setVisibility(8);
        }
        if (this.fIC.getVisibility() != 0) {
            this.fIC.setVisibility(0);
        }
    }

    public void w(final long j, long j2) {
        if (j2 != this.mEndTime) {
            btc();
            this.mEndTime = j2;
            d.Gl().ap(j);
            this.mTimer = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveDynamicView.1
                @Override // android.os.CountDownTimer
                public void onTick(long j3) {
                    AlaActiveDynamicView.this.aC(j.at(j3), (int) ((1.0f - ((((float) j3) * 1.0f) / ((float) j))) * 100.0f));
                    d.Gl().ap(j3);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    AlaActiveDynamicView.this.pV(1);
                }
            };
            this.mTimer.start();
        }
    }

    private void btc() {
        this.mEndTime = 0L;
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        d.Gl().Gn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aC(String str, int i) {
        if (this.fIG != null && this.fIH != null) {
            this.fIG.setText(str);
            this.fIH.setProgress(i);
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
        btc();
        this.fIu = null;
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.h.ala_active_dynamic, (ViewGroup) this, true);
        this.eYM = (TbImageView) findViewById(a.g.iv_bg);
        this.fIw = (ViewGroup) findViewById(a.g.layout_data);
        this.fIx = findViewById(a.g.divider_data);
        this.fIy = (TextView) findViewById(a.g.tv_data_title);
        this.fIz = (TextView) findViewById(a.g.tv_data_point);
        this.fIA = (TextView) findViewById(a.g.tv_data_a);
        this.fIB = (TextView) findViewById(a.g.tv_data_b);
        this.fIC = (ViewGroup) findViewById(a.g.layout_timer);
        this.fID = findViewById(a.g.divider_timer);
        this.fIE = (TextView) findViewById(a.g.tv_timer_title);
        this.fIF = (TextView) findViewById(a.g.tv_timer_tip);
        this.fIG = (TextView) findViewById(a.g.tv_timer_num);
        this.fIH = (ProgressBar) findViewById(a.g.pb_timer);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveDynamicView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaActiveDynamicView.this.fIu != null) {
                    AlaActiveDynamicView.this.fIu.b(AlaActiveDynamicView.this.fIv);
                }
            }
        });
    }

    private void a(at atVar) {
        boolean z;
        boolean z2 = true;
        if (TextUtils.isEmpty(atVar.aAq)) {
            z = false;
        } else {
            try {
                this.mTextColor = Color.parseColor(atVar.aAq);
                z = true;
            } catch (Exception e) {
                z = false;
            }
        }
        if (!z) {
            this.mTextColor = getResources().getColor(a.d.sdk_active_normal);
        }
        if (TextUtils.isEmpty(atVar.aAr)) {
            z2 = false;
        } else {
            try {
                this.fIK = Color.parseColor(atVar.aAr);
            } catch (Exception e2) {
                z2 = false;
            }
        }
        if (!z2) {
            this.fIK = getResources().getColor(a.d.sdk_active_highlight);
        }
        this.fII = new ForegroundColorSpan(this.mTextColor);
        this.fIJ = new ForegroundColorSpan(this.fIK);
    }

    private void setLayoutBg(at atVar) {
        int i;
        boolean z;
        int parseColor;
        int parseColor2;
        int i2 = 0;
        String str = atVar.aAs;
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
            String str2 = atVar.aAt;
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
        this.fIw.setBackgroundDrawable(gradientDrawable);
        this.fIC.setBackgroundDrawable(gradientDrawable);
        this.fIx.setBackgroundColor(parseColor2);
        this.fID.setBackgroundColor(parseColor2);
    }

    private void setValues(at atVar) {
        List<at.a> list = atVar.aAp;
        if (list != null) {
            at.a aVar = list.get(0);
            if (aVar != null) {
                SpannableString spannableString = new SpannableString(aVar.text + "：" + aVar.value);
                spannableString.setSpan(this.fII, 0, aVar.text.length() + 1, 18);
                spannableString.setSpan(this.fIJ, aVar.text.length() + 1, spannableString.length(), 18);
                this.fIA.setText(spannableString);
            }
            at.a aVar2 = list.get(1);
            if (aVar2 != null) {
                SpannableString spannableString2 = new SpannableString(aVar2.text + "：" + aVar2.value);
                spannableString2.setSpan(this.fII, 0, aVar2.text.length() + 1, 18);
                spannableString2.setSpan(this.fIJ, aVar2.text.length() + 1, spannableString2.length(), 18);
                this.fIB.setText(spannableString2);
            }
        }
    }

    private void bxg() {
        this.fIE.setTextColor(this.fIK);
        this.fIF.setTextColor(this.mTextColor);
        this.fIG.setTextColor(this.mTextColor);
    }
}

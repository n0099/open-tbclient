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
import com.baidu.live.data.ag;
import com.baidu.live.data.e;
import com.baidu.live.q.a;
import com.baidu.live.r.d;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.utils.j;
import java.util.List;
/* loaded from: classes2.dex */
public class AlaActiveDynamicView extends RelativeLayout implements c {
    private long bDa;
    private a eKb;
    private e eKc;
    private TbImageView eKd;
    private ViewGroup eKe;
    private View eKf;
    private TextView eKg;
    private TextView eKh;
    private TextView eKi;
    private TextView eKj;
    private ViewGroup eKk;
    private View eKl;
    private TextView eKm;
    private TextView eKn;
    private TextView eKo;
    private ProgressBar eKp;
    private ForegroundColorSpan eKq;
    private ForegroundColorSpan eKr;
    private int eKs;
    private int mStyle;
    private int mTextColor;
    private CountDownTimer mTimer;

    /* loaded from: classes2.dex */
    public interface a {
        void b(e eVar);
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
        this.eKb = aVar;
    }

    public e getActivityInfo() {
        return this.eKc;
    }

    public void setActivityInfo(e eVar) {
        this.eKc = eVar;
    }

    public void oF(int i) {
        if (this.eKe != null && this.eKk != null && i != this.mStyle) {
            this.mStyle = i;
            switch (i) {
                case 1:
                    if (this.eKe.getVisibility() != 0) {
                        this.eKe.setVisibility(0);
                    }
                    if (this.eKk.getVisibility() != 8) {
                        this.eKk.setVisibility(8);
                    }
                    bbi();
                    return;
                case 2:
                    if (this.eKe.getVisibility() != 8) {
                        this.eKe.setVisibility(8);
                    }
                    if (this.eKk.getVisibility() != 0) {
                        this.eKk.setVisibility(0);
                        return;
                    }
                    return;
                default:
                    bbi();
                    return;
            }
        }
    }

    public void setData(String str, ag agVar) {
        a(agVar);
        this.eKd.startLoad(str, 10, false);
        this.eKg.setText(agVar.text);
        this.eKg.setTextColor(this.mTextColor);
        this.eKh.setText(agVar.aao);
        this.eKh.setTextColor(this.eKs);
        setLayoutBg(agVar);
        setValues(agVar);
        bfh();
    }

    public void setTimer(String str) {
        this.eKm.setText(str);
        if (this.eKe.getVisibility() != 8) {
            this.eKe.setVisibility(8);
        }
        if (this.eKk.getVisibility() != 0) {
            this.eKk.setVisibility(0);
        }
    }

    public void u(final long j, long j2) {
        if (j2 != this.bDa) {
            bbi();
            this.bDa = j2;
            d.wH().E(j);
            this.mTimer = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveDynamicView.1
                @Override // android.os.CountDownTimer
                public void onTick(long j3) {
                    AlaActiveDynamicView.this.as(j.I(j3), (int) ((1.0f - ((((float) j3) * 1.0f) / ((float) j))) * 100.0f));
                    d.wH().E(j3);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    AlaActiveDynamicView.this.oF(1);
                }
            };
            this.mTimer.start();
        }
    }

    private void bbi() {
        this.bDa = 0L;
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        d.wH().wJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as(String str, int i) {
        if (this.eKo != null && this.eKp != null) {
            this.eKo.setText(str);
            this.eKp.setProgress(i);
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
        bbi();
        this.eKb = null;
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.h.ala_active_dynamic, (ViewGroup) this, true);
        this.eKd = (TbImageView) findViewById(a.g.iv_bg);
        this.eKe = (ViewGroup) findViewById(a.g.layout_data);
        this.eKf = findViewById(a.g.divider_data);
        this.eKg = (TextView) findViewById(a.g.tv_data_title);
        this.eKh = (TextView) findViewById(a.g.tv_data_point);
        this.eKi = (TextView) findViewById(a.g.tv_data_a);
        this.eKj = (TextView) findViewById(a.g.tv_data_b);
        this.eKk = (ViewGroup) findViewById(a.g.layout_timer);
        this.eKl = findViewById(a.g.divider_timer);
        this.eKm = (TextView) findViewById(a.g.tv_timer_title);
        this.eKn = (TextView) findViewById(a.g.tv_timer_tip);
        this.eKo = (TextView) findViewById(a.g.tv_timer_num);
        this.eKp = (ProgressBar) findViewById(a.g.pb_timer);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveDynamicView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaActiveDynamicView.this.eKb != null) {
                    AlaActiveDynamicView.this.eKb.b(AlaActiveDynamicView.this.eKc);
                }
            }
        });
    }

    private void a(ag agVar) {
        boolean z;
        boolean z2 = true;
        if (TextUtils.isEmpty(agVar.aaq)) {
            z = false;
        } else {
            try {
                this.mTextColor = Color.parseColor(agVar.aaq);
                z = true;
            } catch (Exception e) {
                z = false;
            }
        }
        if (!z) {
            this.mTextColor = getResources().getColor(a.d.sdk_active_normal);
        }
        if (TextUtils.isEmpty(agVar.aar)) {
            z2 = false;
        } else {
            try {
                this.eKs = Color.parseColor(agVar.aar);
            } catch (Exception e2) {
                z2 = false;
            }
        }
        if (!z2) {
            this.eKs = getResources().getColor(a.d.sdk_active_highlight);
        }
        this.eKq = new ForegroundColorSpan(this.mTextColor);
        this.eKr = new ForegroundColorSpan(this.eKs);
    }

    private void setLayoutBg(ag agVar) {
        int i;
        boolean z;
        int parseColor;
        int parseColor2;
        int i2 = 0;
        String str = agVar.aas;
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
            String str2 = agVar.aat;
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
        this.eKe.setBackgroundDrawable(gradientDrawable);
        this.eKk.setBackgroundDrawable(gradientDrawable);
        this.eKf.setBackgroundColor(parseColor2);
        this.eKl.setBackgroundColor(parseColor2);
    }

    private void setValues(ag agVar) {
        List<ag.a> list = agVar.aap;
        if (list != null) {
            ag.a aVar = list.get(0);
            if (aVar != null) {
                SpannableString spannableString = new SpannableString(aVar.text + "：" + aVar.value);
                spannableString.setSpan(this.eKq, 0, aVar.text.length() + 1, 18);
                spannableString.setSpan(this.eKr, aVar.text.length() + 1, spannableString.length(), 18);
                this.eKi.setText(spannableString);
            }
            ag.a aVar2 = list.get(1);
            if (aVar2 != null) {
                SpannableString spannableString2 = new SpannableString(aVar2.text + "：" + aVar2.value);
                spannableString2.setSpan(this.eKq, 0, aVar2.text.length() + 1, 18);
                spannableString2.setSpan(this.eKr, aVar2.text.length() + 1, spannableString2.length(), 18);
                this.eKj.setText(spannableString2);
            }
        }
    }

    private void bfh() {
        this.eKm.setTextColor(this.eKs);
        this.eKn.setTextColor(this.mTextColor);
        this.eKo.setTextColor(this.mTextColor);
    }
}

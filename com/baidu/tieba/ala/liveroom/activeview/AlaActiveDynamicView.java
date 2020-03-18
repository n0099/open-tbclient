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
import com.baidu.live.data.al;
import com.baidu.live.data.f;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
import com.baidu.live.utils.j;
import com.baidu.live.v.d;
import java.util.List;
/* loaded from: classes3.dex */
public class AlaActiveDynamicView extends RelativeLayout implements c {
    private a ePY;
    private f ePZ;
    private TbImageView eQa;
    private ViewGroup eQb;
    private View eQc;
    private TextView eQd;
    private TextView eQe;
    private TextView eQf;
    private TextView eQg;
    private ViewGroup eQh;
    private View eQi;
    private TextView eQj;
    private TextView eQk;
    private TextView eQl;
    private ProgressBar eQm;
    private ForegroundColorSpan eQn;
    private ForegroundColorSpan eQo;
    private int eQp;
    private long mEndTime;
    private int mStyle;
    private int mTextColor;
    private CountDownTimer mTimer;

    /* loaded from: classes3.dex */
    public interface a {
        void b(f fVar);
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
        this.ePY = aVar;
    }

    public f getActivityInfo() {
        return this.ePZ;
    }

    public void setActivityInfo(f fVar) {
        this.ePZ = fVar;
    }

    public void oZ(int i) {
        if (this.eQb != null && this.eQh != null && i != this.mStyle) {
            this.mStyle = i;
            switch (i) {
                case 1:
                    if (this.eQb.getVisibility() != 0) {
                        this.eQb.setVisibility(0);
                    }
                    if (this.eQh.getVisibility() != 8) {
                        this.eQh.setVisibility(8);
                    }
                    bea();
                    return;
                case 2:
                    if (this.eQb.getVisibility() != 8) {
                        this.eQb.setVisibility(8);
                    }
                    if (this.eQh.getVisibility() != 0) {
                        this.eQh.setVisibility(0);
                        return;
                    }
                    return;
                default:
                    bea();
                    return;
            }
        }
    }

    public void setData(String str, al alVar) {
        a(alVar);
        this.eQa.startLoad(str, 10, false);
        this.eQd.setText(alVar.text);
        this.eQd.setTextColor(this.mTextColor);
        this.eQe.setText(alVar.point);
        this.eQe.setTextColor(this.eQp);
        setLayoutBg(alVar);
        setValues(alVar);
        bhW();
    }

    public void setTimer(String str) {
        this.eQj.setText(str);
        if (this.eQb.getVisibility() != 8) {
            this.eQb.setVisibility(8);
        }
        if (this.eQh.getVisibility() != 0) {
            this.eQh.setVisibility(0);
        }
    }

    public void u(final long j, long j2) {
        if (j2 != this.mEndTime) {
            bea();
            this.mEndTime = j2;
            d.zz().I(j);
            this.mTimer = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveDynamicView.1
                @Override // android.os.CountDownTimer
                public void onTick(long j3) {
                    AlaActiveDynamicView.this.ar(j.M(j3), (int) ((1.0f - ((((float) j3) * 1.0f) / ((float) j))) * 100.0f));
                    d.zz().I(j3);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    AlaActiveDynamicView.this.oZ(1);
                }
            };
            this.mTimer.start();
        }
    }

    private void bea() {
        this.mEndTime = 0L;
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        d.zz().zB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ar(String str, int i) {
        if (this.eQl != null && this.eQm != null) {
            this.eQl.setText(str);
            this.eQm.setProgress(i);
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
        bea();
        this.ePY = null;
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.h.ala_active_dynamic, (ViewGroup) this, true);
        this.eQa = (TbImageView) findViewById(a.g.iv_bg);
        this.eQb = (ViewGroup) findViewById(a.g.layout_data);
        this.eQc = findViewById(a.g.divider_data);
        this.eQd = (TextView) findViewById(a.g.tv_data_title);
        this.eQe = (TextView) findViewById(a.g.tv_data_point);
        this.eQf = (TextView) findViewById(a.g.tv_data_a);
        this.eQg = (TextView) findViewById(a.g.tv_data_b);
        this.eQh = (ViewGroup) findViewById(a.g.layout_timer);
        this.eQi = findViewById(a.g.divider_timer);
        this.eQj = (TextView) findViewById(a.g.tv_timer_title);
        this.eQk = (TextView) findViewById(a.g.tv_timer_tip);
        this.eQl = (TextView) findViewById(a.g.tv_timer_num);
        this.eQm = (ProgressBar) findViewById(a.g.pb_timer);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveDynamicView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaActiveDynamicView.this.ePY != null) {
                    AlaActiveDynamicView.this.ePY.b(AlaActiveDynamicView.this.ePZ);
                }
            }
        });
    }

    private void a(al alVar) {
        boolean z;
        boolean z2 = true;
        if (TextUtils.isEmpty(alVar.acK)) {
            z = false;
        } else {
            try {
                this.mTextColor = Color.parseColor(alVar.acK);
                z = true;
            } catch (Exception e) {
                z = false;
            }
        }
        if (!z) {
            this.mTextColor = getResources().getColor(a.d.sdk_active_normal);
        }
        if (TextUtils.isEmpty(alVar.acL)) {
            z2 = false;
        } else {
            try {
                this.eQp = Color.parseColor(alVar.acL);
            } catch (Exception e2) {
                z2 = false;
            }
        }
        if (!z2) {
            this.eQp = getResources().getColor(a.d.sdk_active_highlight);
        }
        this.eQn = new ForegroundColorSpan(this.mTextColor);
        this.eQo = new ForegroundColorSpan(this.eQp);
    }

    private void setLayoutBg(al alVar) {
        int i;
        boolean z;
        int parseColor;
        int parseColor2;
        int i2 = 0;
        String str = alVar.acM;
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
            String str2 = alVar.acN;
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
        this.eQb.setBackgroundDrawable(gradientDrawable);
        this.eQh.setBackgroundDrawable(gradientDrawable);
        this.eQc.setBackgroundColor(parseColor2);
        this.eQi.setBackgroundColor(parseColor2);
    }

    private void setValues(al alVar) {
        List<al.a> list = alVar.acJ;
        if (list != null) {
            al.a aVar = list.get(0);
            if (aVar != null) {
                SpannableString spannableString = new SpannableString(aVar.text + "：" + aVar.value);
                spannableString.setSpan(this.eQn, 0, aVar.text.length() + 1, 18);
                spannableString.setSpan(this.eQo, aVar.text.length() + 1, spannableString.length(), 18);
                this.eQf.setText(spannableString);
            }
            al.a aVar2 = list.get(1);
            if (aVar2 != null) {
                SpannableString spannableString2 = new SpannableString(aVar2.text + "：" + aVar2.value);
                spannableString2.setSpan(this.eQn, 0, aVar2.text.length() + 1, 18);
                spannableString2.setSpan(this.eQo, aVar2.text.length() + 1, spannableString2.length(), 18);
                this.eQg.setText(spannableString2);
            }
        }
    }

    private void bhW() {
        this.eQj.setTextColor(this.eQp);
        this.eQk.setTextColor(this.mTextColor);
        this.eQl.setTextColor(this.mTextColor);
    }
}

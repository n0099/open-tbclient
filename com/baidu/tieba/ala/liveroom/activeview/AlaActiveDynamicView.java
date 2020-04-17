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
import com.baidu.live.data.ao;
import com.baidu.live.data.f;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
import com.baidu.live.utils.j;
import com.baidu.live.v.d;
import java.util.List;
/* loaded from: classes3.dex */
public class AlaActiveDynamicView extends RelativeLayout implements c {
    private TbImageView eMk;
    private TextView fuA;
    private ViewGroup fuB;
    private View fuC;
    private TextView fuD;
    private TextView fuE;
    private TextView fuF;
    private ProgressBar fuG;
    private ForegroundColorSpan fuH;
    private ForegroundColorSpan fuI;
    private int fuJ;
    private a fut;
    private f fuu;
    private ViewGroup fuv;
    private View fuw;
    private TextView fux;
    private TextView fuy;
    private TextView fuz;
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
        this.fut = aVar;
    }

    public f getActivityInfo() {
        return this.fuu;
    }

    public void setActivityInfo(f fVar) {
        this.fuu = fVar;
    }

    public void pu(int i) {
        if (this.fuv != null && this.fuB != null && i != this.mStyle) {
            this.mStyle = i;
            switch (i) {
                case 1:
                    if (this.fuv.getVisibility() != 0) {
                        this.fuv.setVisibility(0);
                    }
                    if (this.fuB.getVisibility() != 8) {
                        this.fuB.setVisibility(8);
                    }
                    bnm();
                    return;
                case 2:
                    if (this.fuv.getVisibility() != 8) {
                        this.fuv.setVisibility(8);
                    }
                    if (this.fuB.getVisibility() != 0) {
                        this.fuB.setVisibility(0);
                        return;
                    }
                    return;
                default:
                    bnm();
                    return;
            }
        }
    }

    public void setData(String str, ao aoVar) {
        a(aoVar);
        this.eMk.startLoad(str, 10, false);
        this.fux.setText(aoVar.text);
        this.fux.setTextColor(this.mTextColor);
        this.fuy.setText(aoVar.point);
        this.fuy.setTextColor(this.fuJ);
        setLayoutBg(aoVar);
        setValues(aoVar);
        brp();
    }

    public void setTimer(String str) {
        this.fuD.setText(str);
        if (this.fuv.getVisibility() != 8) {
            this.fuv.setVisibility(8);
        }
        if (this.fuB.getVisibility() != 0) {
            this.fuB.setVisibility(0);
        }
    }

    public void v(final long j, long j2) {
        if (j2 != this.mEndTime) {
            bnm();
            this.mEndTime = j2;
            d.Ev().ak(j);
            this.mTimer = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveDynamicView.1
                @Override // android.os.CountDownTimer
                public void onTick(long j3) {
                    AlaActiveDynamicView.this.aB(j.ao(j3), (int) ((1.0f - ((((float) j3) * 1.0f) / ((float) j))) * 100.0f));
                    d.Ev().ak(j3);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    AlaActiveDynamicView.this.pu(1);
                }
            };
            this.mTimer.start();
        }
    }

    private void bnm() {
        this.mEndTime = 0L;
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        d.Ev().Ex();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aB(String str, int i) {
        if (this.fuF != null && this.fuG != null) {
            this.fuF.setText(str);
            this.fuG.setProgress(i);
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
        bnm();
        this.fut = null;
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.h.ala_active_dynamic, (ViewGroup) this, true);
        this.eMk = (TbImageView) findViewById(a.g.iv_bg);
        this.fuv = (ViewGroup) findViewById(a.g.layout_data);
        this.fuw = findViewById(a.g.divider_data);
        this.fux = (TextView) findViewById(a.g.tv_data_title);
        this.fuy = (TextView) findViewById(a.g.tv_data_point);
        this.fuz = (TextView) findViewById(a.g.tv_data_a);
        this.fuA = (TextView) findViewById(a.g.tv_data_b);
        this.fuB = (ViewGroup) findViewById(a.g.layout_timer);
        this.fuC = findViewById(a.g.divider_timer);
        this.fuD = (TextView) findViewById(a.g.tv_timer_title);
        this.fuE = (TextView) findViewById(a.g.tv_timer_tip);
        this.fuF = (TextView) findViewById(a.g.tv_timer_num);
        this.fuG = (ProgressBar) findViewById(a.g.pb_timer);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveDynamicView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaActiveDynamicView.this.fut != null) {
                    AlaActiveDynamicView.this.fut.b(AlaActiveDynamicView.this.fuu);
                }
            }
        });
    }

    private void a(ao aoVar) {
        boolean z;
        boolean z2 = true;
        if (TextUtils.isEmpty(aoVar.avc)) {
            z = false;
        } else {
            try {
                this.mTextColor = Color.parseColor(aoVar.avc);
                z = true;
            } catch (Exception e) {
                z = false;
            }
        }
        if (!z) {
            this.mTextColor = getResources().getColor(a.d.sdk_active_normal);
        }
        if (TextUtils.isEmpty(aoVar.avd)) {
            z2 = false;
        } else {
            try {
                this.fuJ = Color.parseColor(aoVar.avd);
            } catch (Exception e2) {
                z2 = false;
            }
        }
        if (!z2) {
            this.fuJ = getResources().getColor(a.d.sdk_active_highlight);
        }
        this.fuH = new ForegroundColorSpan(this.mTextColor);
        this.fuI = new ForegroundColorSpan(this.fuJ);
    }

    private void setLayoutBg(ao aoVar) {
        int i;
        boolean z;
        int parseColor;
        int parseColor2;
        int i2 = 0;
        String str = aoVar.ave;
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
            String str2 = aoVar.avf;
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
        this.fuv.setBackgroundDrawable(gradientDrawable);
        this.fuB.setBackgroundDrawable(gradientDrawable);
        this.fuw.setBackgroundColor(parseColor2);
        this.fuC.setBackgroundColor(parseColor2);
    }

    private void setValues(ao aoVar) {
        List<ao.a> list = aoVar.avb;
        if (list != null) {
            ao.a aVar = list.get(0);
            if (aVar != null) {
                SpannableString spannableString = new SpannableString(aVar.text + "：" + aVar.value);
                spannableString.setSpan(this.fuH, 0, aVar.text.length() + 1, 18);
                spannableString.setSpan(this.fuI, aVar.text.length() + 1, spannableString.length(), 18);
                this.fuz.setText(spannableString);
            }
            ao.a aVar2 = list.get(1);
            if (aVar2 != null) {
                SpannableString spannableString2 = new SpannableString(aVar2.text + "：" + aVar2.value);
                spannableString2.setSpan(this.fuH, 0, aVar2.text.length() + 1, 18);
                spannableString2.setSpan(this.fuI, aVar2.text.length() + 1, spannableString2.length(), 18);
                this.fuA.setText(spannableString2);
            }
        }
    }

    private void brp() {
        this.fuD.setTextColor(this.fuJ);
        this.fuE.setTextColor(this.mTextColor);
        this.fuF.setTextColor(this.mTextColor);
    }
}

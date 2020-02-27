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
    private ProgressBar ePA;
    private ForegroundColorSpan ePB;
    private ForegroundColorSpan ePC;
    private int ePD;
    private a ePm;
    private f ePn;
    private TbImageView ePo;
    private ViewGroup ePp;
    private View ePq;
    private TextView ePr;
    private TextView ePs;
    private TextView ePt;
    private TextView ePu;
    private ViewGroup ePv;
    private View ePw;
    private TextView ePx;
    private TextView ePy;
    private TextView ePz;
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
        this.ePm = aVar;
    }

    public f getActivityInfo() {
        return this.ePn;
    }

    public void setActivityInfo(f fVar) {
        this.ePn = fVar;
    }

    public void oX(int i) {
        if (this.ePp != null && this.ePv != null && i != this.mStyle) {
            this.mStyle = i;
            switch (i) {
                case 1:
                    if (this.ePp.getVisibility() != 0) {
                        this.ePp.setVisibility(0);
                    }
                    if (this.ePv.getVisibility() != 8) {
                        this.ePv.setVisibility(8);
                    }
                    bdS();
                    return;
                case 2:
                    if (this.ePp.getVisibility() != 8) {
                        this.ePp.setVisibility(8);
                    }
                    if (this.ePv.getVisibility() != 0) {
                        this.ePv.setVisibility(0);
                        return;
                    }
                    return;
                default:
                    bdS();
                    return;
            }
        }
    }

    public void setData(String str, al alVar) {
        a(alVar);
        this.ePo.startLoad(str, 10, false);
        this.ePr.setText(alVar.text);
        this.ePr.setTextColor(this.mTextColor);
        this.ePs.setText(alVar.point);
        this.ePs.setTextColor(this.ePD);
        setLayoutBg(alVar);
        setValues(alVar);
        bhO();
    }

    public void setTimer(String str) {
        this.ePx.setText(str);
        if (this.ePp.getVisibility() != 8) {
            this.ePp.setVisibility(8);
        }
        if (this.ePv.getVisibility() != 0) {
            this.ePv.setVisibility(0);
        }
    }

    public void u(final long j, long j2) {
        if (j2 != this.mEndTime) {
            bdS();
            this.mEndTime = j2;
            d.zq().I(j);
            this.mTimer = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveDynamicView.1
                @Override // android.os.CountDownTimer
                public void onTick(long j3) {
                    AlaActiveDynamicView.this.ar(j.M(j3), (int) ((1.0f - ((((float) j3) * 1.0f) / ((float) j))) * 100.0f));
                    d.zq().I(j3);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    AlaActiveDynamicView.this.oX(1);
                }
            };
            this.mTimer.start();
        }
    }

    private void bdS() {
        this.mEndTime = 0L;
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        d.zq().zs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ar(String str, int i) {
        if (this.ePz != null && this.ePA != null) {
            this.ePz.setText(str);
            this.ePA.setProgress(i);
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
        bdS();
        this.ePm = null;
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.h.ala_active_dynamic, (ViewGroup) this, true);
        this.ePo = (TbImageView) findViewById(a.g.iv_bg);
        this.ePp = (ViewGroup) findViewById(a.g.layout_data);
        this.ePq = findViewById(a.g.divider_data);
        this.ePr = (TextView) findViewById(a.g.tv_data_title);
        this.ePs = (TextView) findViewById(a.g.tv_data_point);
        this.ePt = (TextView) findViewById(a.g.tv_data_a);
        this.ePu = (TextView) findViewById(a.g.tv_data_b);
        this.ePv = (ViewGroup) findViewById(a.g.layout_timer);
        this.ePw = findViewById(a.g.divider_timer);
        this.ePx = (TextView) findViewById(a.g.tv_timer_title);
        this.ePy = (TextView) findViewById(a.g.tv_timer_tip);
        this.ePz = (TextView) findViewById(a.g.tv_timer_num);
        this.ePA = (ProgressBar) findViewById(a.g.pb_timer);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveDynamicView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaActiveDynamicView.this.ePm != null) {
                    AlaActiveDynamicView.this.ePm.b(AlaActiveDynamicView.this.ePn);
                }
            }
        });
    }

    private void a(al alVar) {
        boolean z;
        boolean z2 = true;
        if (TextUtils.isEmpty(alVar.acA)) {
            z = false;
        } else {
            try {
                this.mTextColor = Color.parseColor(alVar.acA);
                z = true;
            } catch (Exception e) {
                z = false;
            }
        }
        if (!z) {
            this.mTextColor = getResources().getColor(a.d.sdk_active_normal);
        }
        if (TextUtils.isEmpty(alVar.acB)) {
            z2 = false;
        } else {
            try {
                this.ePD = Color.parseColor(alVar.acB);
            } catch (Exception e2) {
                z2 = false;
            }
        }
        if (!z2) {
            this.ePD = getResources().getColor(a.d.sdk_active_highlight);
        }
        this.ePB = new ForegroundColorSpan(this.mTextColor);
        this.ePC = new ForegroundColorSpan(this.ePD);
    }

    private void setLayoutBg(al alVar) {
        int i;
        boolean z;
        int parseColor;
        int parseColor2;
        int i2 = 0;
        String str = alVar.acC;
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
            String str2 = alVar.acD;
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
        this.ePp.setBackgroundDrawable(gradientDrawable);
        this.ePv.setBackgroundDrawable(gradientDrawable);
        this.ePq.setBackgroundColor(parseColor2);
        this.ePw.setBackgroundColor(parseColor2);
    }

    private void setValues(al alVar) {
        List<al.a> list = alVar.acz;
        if (list != null) {
            al.a aVar = list.get(0);
            if (aVar != null) {
                SpannableString spannableString = new SpannableString(aVar.text + "：" + aVar.value);
                spannableString.setSpan(this.ePB, 0, aVar.text.length() + 1, 18);
                spannableString.setSpan(this.ePC, aVar.text.length() + 1, spannableString.length(), 18);
                this.ePt.setText(spannableString);
            }
            al.a aVar2 = list.get(1);
            if (aVar2 != null) {
                SpannableString spannableString2 = new SpannableString(aVar2.text + "：" + aVar2.value);
                spannableString2.setSpan(this.ePB, 0, aVar2.text.length() + 1, 18);
                spannableString2.setSpan(this.ePC, aVar2.text.length() + 1, spannableString2.length(), 18);
                this.ePu.setText(spannableString2);
            }
        }
    }

    private void bhO() {
        this.ePx.setTextColor(this.ePD);
        this.ePy.setTextColor(this.mTextColor);
        this.ePz.setTextColor(this.mTextColor);
    }
}

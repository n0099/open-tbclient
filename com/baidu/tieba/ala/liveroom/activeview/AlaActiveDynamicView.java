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
    private a ePA;
    private f ePB;
    private TbImageView ePC;
    private ViewGroup ePD;
    private View ePE;
    private TextView ePF;
    private TextView ePG;
    private TextView ePH;
    private TextView ePI;
    private ViewGroup ePJ;
    private View ePK;
    private TextView ePL;
    private TextView ePM;
    private TextView ePN;
    private ProgressBar ePO;
    private ForegroundColorSpan ePP;
    private ForegroundColorSpan ePQ;
    private int ePR;
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
        this.ePA = aVar;
    }

    public f getActivityInfo() {
        return this.ePB;
    }

    public void setActivityInfo(f fVar) {
        this.ePB = fVar;
    }

    public void oX(int i) {
        if (this.ePD != null && this.ePJ != null && i != this.mStyle) {
            this.mStyle = i;
            switch (i) {
                case 1:
                    if (this.ePD.getVisibility() != 0) {
                        this.ePD.setVisibility(0);
                    }
                    if (this.ePJ.getVisibility() != 8) {
                        this.ePJ.setVisibility(8);
                    }
                    bdV();
                    return;
                case 2:
                    if (this.ePD.getVisibility() != 8) {
                        this.ePD.setVisibility(8);
                    }
                    if (this.ePJ.getVisibility() != 0) {
                        this.ePJ.setVisibility(0);
                        return;
                    }
                    return;
                default:
                    bdV();
                    return;
            }
        }
    }

    public void setData(String str, al alVar) {
        a(alVar);
        this.ePC.startLoad(str, 10, false);
        this.ePF.setText(alVar.text);
        this.ePF.setTextColor(this.mTextColor);
        this.ePG.setText(alVar.point);
        this.ePG.setTextColor(this.ePR);
        setLayoutBg(alVar);
        setValues(alVar);
        bhR();
    }

    public void setTimer(String str) {
        this.ePL.setText(str);
        if (this.ePD.getVisibility() != 8) {
            this.ePD.setVisibility(8);
        }
        if (this.ePJ.getVisibility() != 0) {
            this.ePJ.setVisibility(0);
        }
    }

    public void u(final long j, long j2) {
        if (j2 != this.mEndTime) {
            bdV();
            this.mEndTime = j2;
            d.zs().I(j);
            this.mTimer = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveDynamicView.1
                @Override // android.os.CountDownTimer
                public void onTick(long j3) {
                    AlaActiveDynamicView.this.ar(j.M(j3), (int) ((1.0f - ((((float) j3) * 1.0f) / ((float) j))) * 100.0f));
                    d.zs().I(j3);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    AlaActiveDynamicView.this.oX(1);
                }
            };
            this.mTimer.start();
        }
    }

    private void bdV() {
        this.mEndTime = 0L;
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        d.zs().zu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ar(String str, int i) {
        if (this.ePN != null && this.ePO != null) {
            this.ePN.setText(str);
            this.ePO.setProgress(i);
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
        bdV();
        this.ePA = null;
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.h.ala_active_dynamic, (ViewGroup) this, true);
        this.ePC = (TbImageView) findViewById(a.g.iv_bg);
        this.ePD = (ViewGroup) findViewById(a.g.layout_data);
        this.ePE = findViewById(a.g.divider_data);
        this.ePF = (TextView) findViewById(a.g.tv_data_title);
        this.ePG = (TextView) findViewById(a.g.tv_data_point);
        this.ePH = (TextView) findViewById(a.g.tv_data_a);
        this.ePI = (TextView) findViewById(a.g.tv_data_b);
        this.ePJ = (ViewGroup) findViewById(a.g.layout_timer);
        this.ePK = findViewById(a.g.divider_timer);
        this.ePL = (TextView) findViewById(a.g.tv_timer_title);
        this.ePM = (TextView) findViewById(a.g.tv_timer_tip);
        this.ePN = (TextView) findViewById(a.g.tv_timer_num);
        this.ePO = (ProgressBar) findViewById(a.g.pb_timer);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveDynamicView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaActiveDynamicView.this.ePA != null) {
                    AlaActiveDynamicView.this.ePA.b(AlaActiveDynamicView.this.ePB);
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
                this.ePR = Color.parseColor(alVar.acB);
            } catch (Exception e2) {
                z2 = false;
            }
        }
        if (!z2) {
            this.ePR = getResources().getColor(a.d.sdk_active_highlight);
        }
        this.ePP = new ForegroundColorSpan(this.mTextColor);
        this.ePQ = new ForegroundColorSpan(this.ePR);
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
        this.ePD.setBackgroundDrawable(gradientDrawable);
        this.ePJ.setBackgroundDrawable(gradientDrawable);
        this.ePE.setBackgroundColor(parseColor2);
        this.ePK.setBackgroundColor(parseColor2);
    }

    private void setValues(al alVar) {
        List<al.a> list = alVar.acz;
        if (list != null) {
            al.a aVar = list.get(0);
            if (aVar != null) {
                SpannableString spannableString = new SpannableString(aVar.text + "：" + aVar.value);
                spannableString.setSpan(this.ePP, 0, aVar.text.length() + 1, 18);
                spannableString.setSpan(this.ePQ, aVar.text.length() + 1, spannableString.length(), 18);
                this.ePH.setText(spannableString);
            }
            al.a aVar2 = list.get(1);
            if (aVar2 != null) {
                SpannableString spannableString2 = new SpannableString(aVar2.text + "：" + aVar2.value);
                spannableString2.setSpan(this.ePP, 0, aVar2.text.length() + 1, 18);
                spannableString2.setSpan(this.ePQ, aVar2.text.length() + 1, spannableString2.length(), 18);
                this.ePI.setText(spannableString2);
            }
        }
    }

    private void bhR() {
        this.ePL.setTextColor(this.ePR);
        this.ePM.setTextColor(this.mTextColor);
        this.ePN.setTextColor(this.mTextColor);
    }
}

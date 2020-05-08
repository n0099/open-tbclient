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
    private TbImageView eMp;
    private ViewGroup fuA;
    private View fuB;
    private TextView fuC;
    private TextView fuD;
    private TextView fuE;
    private TextView fuF;
    private ViewGroup fuG;
    private View fuH;
    private TextView fuI;
    private TextView fuJ;
    private TextView fuK;
    private ProgressBar fuL;
    private ForegroundColorSpan fuM;
    private ForegroundColorSpan fuN;
    private int fuO;
    private a fuy;
    private f fuz;
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
        this.fuy = aVar;
    }

    public f getActivityInfo() {
        return this.fuz;
    }

    public void setActivityInfo(f fVar) {
        this.fuz = fVar;
    }

    public void pu(int i) {
        if (this.fuA != null && this.fuG != null && i != this.mStyle) {
            this.mStyle = i;
            switch (i) {
                case 1:
                    if (this.fuA.getVisibility() != 0) {
                        this.fuA.setVisibility(0);
                    }
                    if (this.fuG.getVisibility() != 8) {
                        this.fuG.setVisibility(8);
                    }
                    bnk();
                    return;
                case 2:
                    if (this.fuA.getVisibility() != 8) {
                        this.fuA.setVisibility(8);
                    }
                    if (this.fuG.getVisibility() != 0) {
                        this.fuG.setVisibility(0);
                        return;
                    }
                    return;
                default:
                    bnk();
                    return;
            }
        }
    }

    public void setData(String str, ao aoVar) {
        a(aoVar);
        this.eMp.startLoad(str, 10, false);
        this.fuC.setText(aoVar.text);
        this.fuC.setTextColor(this.mTextColor);
        this.fuD.setText(aoVar.point);
        this.fuD.setTextColor(this.fuO);
        setLayoutBg(aoVar);
        setValues(aoVar);
        brn();
    }

    public void setTimer(String str) {
        this.fuI.setText(str);
        if (this.fuA.getVisibility() != 8) {
            this.fuA.setVisibility(8);
        }
        if (this.fuG.getVisibility() != 0) {
            this.fuG.setVisibility(0);
        }
    }

    public void v(final long j, long j2) {
        if (j2 != this.mEndTime) {
            bnk();
            this.mEndTime = j2;
            d.Eu().ak(j);
            this.mTimer = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveDynamicView.1
                @Override // android.os.CountDownTimer
                public void onTick(long j3) {
                    AlaActiveDynamicView.this.aB(j.ao(j3), (int) ((1.0f - ((((float) j3) * 1.0f) / ((float) j))) * 100.0f));
                    d.Eu().ak(j3);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    AlaActiveDynamicView.this.pu(1);
                }
            };
            this.mTimer.start();
        }
    }

    private void bnk() {
        this.mEndTime = 0L;
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        d.Eu().Ew();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aB(String str, int i) {
        if (this.fuK != null && this.fuL != null) {
            this.fuK.setText(str);
            this.fuL.setProgress(i);
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
        bnk();
        this.fuy = null;
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.h.ala_active_dynamic, (ViewGroup) this, true);
        this.eMp = (TbImageView) findViewById(a.g.iv_bg);
        this.fuA = (ViewGroup) findViewById(a.g.layout_data);
        this.fuB = findViewById(a.g.divider_data);
        this.fuC = (TextView) findViewById(a.g.tv_data_title);
        this.fuD = (TextView) findViewById(a.g.tv_data_point);
        this.fuE = (TextView) findViewById(a.g.tv_data_a);
        this.fuF = (TextView) findViewById(a.g.tv_data_b);
        this.fuG = (ViewGroup) findViewById(a.g.layout_timer);
        this.fuH = findViewById(a.g.divider_timer);
        this.fuI = (TextView) findViewById(a.g.tv_timer_title);
        this.fuJ = (TextView) findViewById(a.g.tv_timer_tip);
        this.fuK = (TextView) findViewById(a.g.tv_timer_num);
        this.fuL = (ProgressBar) findViewById(a.g.pb_timer);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveDynamicView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaActiveDynamicView.this.fuy != null) {
                    AlaActiveDynamicView.this.fuy.b(AlaActiveDynamicView.this.fuz);
                }
            }
        });
    }

    private void a(ao aoVar) {
        boolean z;
        boolean z2 = true;
        if (TextUtils.isEmpty(aoVar.avi)) {
            z = false;
        } else {
            try {
                this.mTextColor = Color.parseColor(aoVar.avi);
                z = true;
            } catch (Exception e) {
                z = false;
            }
        }
        if (!z) {
            this.mTextColor = getResources().getColor(a.d.sdk_active_normal);
        }
        if (TextUtils.isEmpty(aoVar.avj)) {
            z2 = false;
        } else {
            try {
                this.fuO = Color.parseColor(aoVar.avj);
            } catch (Exception e2) {
                z2 = false;
            }
        }
        if (!z2) {
            this.fuO = getResources().getColor(a.d.sdk_active_highlight);
        }
        this.fuM = new ForegroundColorSpan(this.mTextColor);
        this.fuN = new ForegroundColorSpan(this.fuO);
    }

    private void setLayoutBg(ao aoVar) {
        int i;
        boolean z;
        int parseColor;
        int parseColor2;
        int i2 = 0;
        String str = aoVar.avk;
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
            String str2 = aoVar.avl;
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
        this.fuA.setBackgroundDrawable(gradientDrawable);
        this.fuG.setBackgroundDrawable(gradientDrawable);
        this.fuB.setBackgroundColor(parseColor2);
        this.fuH.setBackgroundColor(parseColor2);
    }

    private void setValues(ao aoVar) {
        List<ao.a> list = aoVar.avh;
        if (list != null) {
            ao.a aVar = list.get(0);
            if (aVar != null) {
                SpannableString spannableString = new SpannableString(aVar.text + "：" + aVar.value);
                spannableString.setSpan(this.fuM, 0, aVar.text.length() + 1, 18);
                spannableString.setSpan(this.fuN, aVar.text.length() + 1, spannableString.length(), 18);
                this.fuE.setText(spannableString);
            }
            ao.a aVar2 = list.get(1);
            if (aVar2 != null) {
                SpannableString spannableString2 = new SpannableString(aVar2.text + "：" + aVar2.value);
                spannableString2.setSpan(this.fuM, 0, aVar2.text.length() + 1, 18);
                spannableString2.setSpan(this.fuN, aVar2.text.length() + 1, spannableString2.length(), 18);
                this.fuF.setText(spannableString2);
            }
        }
    }

    private void brn() {
        this.fuI.setTextColor(this.fuO);
        this.fuJ.setTextColor(this.mTextColor);
        this.fuK.setTextColor(this.mTextColor);
    }
}

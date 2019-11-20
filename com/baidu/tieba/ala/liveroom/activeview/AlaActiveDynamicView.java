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
    private long ban;
    private a dUB;
    private com.baidu.live.data.c dUC;
    private TbImageView dUD;
    private ViewGroup dUE;
    private View dUF;
    private TextView dUG;
    private TextView dUH;
    private TextView dUI;
    private TextView dUJ;
    private ViewGroup dUK;
    private View dUL;
    private TextView dUM;
    private TextView dUN;
    private TextView dUO;
    private ProgressBar dUP;
    private ForegroundColorSpan dUQ;
    private ForegroundColorSpan dUR;
    private int dUS;
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
        this.dUB = aVar;
    }

    public com.baidu.live.data.c getActivityInfo() {
        return this.dUC;
    }

    public void setActivityInfo(com.baidu.live.data.c cVar) {
        this.dUC = cVar;
    }

    public void nk(int i) {
        if (this.dUE != null && this.dUK != null && i != this.mStyle) {
            this.mStyle = i;
            switch (i) {
                case 1:
                    if (this.dUE.getVisibility() != 0) {
                        this.dUE.setVisibility(0);
                    }
                    if (this.dUK.getVisibility() != 8) {
                        this.dUK.setVisibility(8);
                    }
                    aNL();
                    return;
                case 2:
                    if (this.dUE.getVisibility() != 8) {
                        this.dUE.setVisibility(8);
                    }
                    if (this.dUK.getVisibility() != 0) {
                        this.dUK.setVisibility(0);
                        return;
                    }
                    return;
                default:
                    aNL();
                    return;
            }
        }
    }

    public void setData(String str, ad adVar) {
        a(adVar);
        this.dUD.startLoad(str, 10, false);
        this.dUG.setText(adVar.text);
        this.dUG.setTextColor(this.mTextColor);
        this.dUH.setText(adVar.Tx);
        this.dUH.setTextColor(this.dUS);
        setLayoutBg(adVar);
        setValues(adVar);
        aNM();
    }

    public void setTimer(String str) {
        this.dUM.setText(str);
        if (this.dUE.getVisibility() != 8) {
            this.dUE.setVisibility(8);
        }
        if (this.dUK.getVisibility() != 0) {
            this.dUK.setVisibility(0);
        }
    }

    public void p(final long j, long j2) {
        if (j2 != this.ban) {
            aNL();
            this.ban = j2;
            d.uJ().C(j);
            this.mTimer = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveDynamicView.1
                @Override // android.os.CountDownTimer
                public void onTick(long j3) {
                    AlaActiveDynamicView.this.aj(i.G(j3), (int) ((1.0f - ((((float) j3) * 1.0f) / ((float) j))) * 100.0f));
                    d.uJ().C(j3);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    AlaActiveDynamicView.this.nk(1);
                }
            };
            this.mTimer.start();
        }
    }

    private void aNL() {
        this.ban = 0L;
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        d.uJ().uL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aj(String str, int i) {
        if (this.dUO != null && this.dUP != null) {
            this.dUO.setText(str);
            this.dUP.setProgress(i);
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
        aNL();
        this.dUB = null;
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.h.ala_active_dynamic, (ViewGroup) this, true);
        this.dUD = (TbImageView) findViewById(a.g.iv_bg);
        this.dUE = (ViewGroup) findViewById(a.g.layout_data);
        this.dUF = findViewById(a.g.divider_data);
        this.dUG = (TextView) findViewById(a.g.tv_data_title);
        this.dUH = (TextView) findViewById(a.g.tv_data_point);
        this.dUI = (TextView) findViewById(a.g.tv_data_a);
        this.dUJ = (TextView) findViewById(a.g.tv_data_b);
        this.dUK = (ViewGroup) findViewById(a.g.layout_timer);
        this.dUL = findViewById(a.g.divider_timer);
        this.dUM = (TextView) findViewById(a.g.tv_timer_title);
        this.dUN = (TextView) findViewById(a.g.tv_timer_tip);
        this.dUO = (TextView) findViewById(a.g.tv_timer_num);
        this.dUP = (ProgressBar) findViewById(a.g.pb_timer);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveDynamicView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaActiveDynamicView.this.dUB != null) {
                    AlaActiveDynamicView.this.dUB.b(AlaActiveDynamicView.this.dUC);
                }
            }
        });
    }

    private void a(ad adVar) {
        boolean z;
        boolean z2 = true;
        if (TextUtils.isEmpty(adVar.Tz)) {
            z = false;
        } else {
            try {
                this.mTextColor = Color.parseColor(adVar.Tz);
                z = true;
            } catch (Exception e) {
                z = false;
            }
        }
        if (!z) {
            this.mTextColor = getResources().getColor(a.d.sdk_active_normal);
        }
        if (TextUtils.isEmpty(adVar.TA)) {
            z2 = false;
        } else {
            try {
                this.dUS = Color.parseColor(adVar.TA);
            } catch (Exception e2) {
                z2 = false;
            }
        }
        if (!z2) {
            this.dUS = getResources().getColor(a.d.sdk_active_highlight);
        }
        this.dUQ = new ForegroundColorSpan(this.mTextColor);
        this.dUR = new ForegroundColorSpan(this.dUS);
    }

    private void setLayoutBg(ad adVar) {
        int i;
        boolean z;
        int parseColor;
        int parseColor2;
        int i2 = 0;
        String str = adVar.TB;
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
            String str2 = adVar.TC;
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
        this.dUE.setBackgroundDrawable(gradientDrawable);
        this.dUK.setBackgroundDrawable(gradientDrawable);
        this.dUF.setBackgroundColor(parseColor2);
        this.dUL.setBackgroundColor(parseColor2);
    }

    private void setValues(ad adVar) {
        List<ad.a> list = adVar.Ty;
        if (list != null) {
            ad.a aVar = list.get(0);
            if (aVar != null) {
                SpannableString spannableString = new SpannableString(aVar.text + "：" + aVar.value);
                spannableString.setSpan(this.dUQ, 0, aVar.text.length() + 1, 18);
                spannableString.setSpan(this.dUR, aVar.text.length() + 1, spannableString.length(), 18);
                this.dUI.setText(spannableString);
            }
            ad.a aVar2 = list.get(1);
            if (aVar2 != null) {
                SpannableString spannableString2 = new SpannableString(aVar2.text + "：" + aVar2.value);
                spannableString2.setSpan(this.dUQ, 0, aVar2.text.length() + 1, 18);
                spannableString2.setSpan(this.dUR, aVar2.text.length() + 1, spannableString2.length(), 18);
                this.dUJ.setText(spannableString2);
            }
        }
    }

    private void aNM() {
        this.dUM.setTextColor(this.dUS);
        this.dUN.setTextColor(this.mTextColor);
        this.dUO.setTextColor(this.mTextColor);
    }
}

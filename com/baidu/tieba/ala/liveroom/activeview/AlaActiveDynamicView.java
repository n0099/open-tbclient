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
import com.baidu.live.data.ak;
import com.baidu.live.data.e;
import com.baidu.live.r.a;
import com.baidu.live.s.d;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.utils.j;
import java.util.List;
/* loaded from: classes2.dex */
public class AlaActiveDynamicView extends RelativeLayout implements c {
    private long bDL;
    private ProgressBar eLA;
    private ForegroundColorSpan eLB;
    private ForegroundColorSpan eLC;
    private int eLD;
    private a eLm;
    private e eLn;
    private TbImageView eLo;
    private ViewGroup eLp;
    private View eLq;
    private TextView eLr;
    private TextView eLs;
    private TextView eLt;
    private TextView eLu;
    private ViewGroup eLv;
    private View eLw;
    private TextView eLx;
    private TextView eLy;
    private TextView eLz;
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
        this.eLm = aVar;
    }

    public e getActivityInfo() {
        return this.eLn;
    }

    public void setActivityInfo(e eVar) {
        this.eLn = eVar;
    }

    public void oG(int i) {
        if (this.eLp != null && this.eLv != null && i != this.mStyle) {
            this.mStyle = i;
            switch (i) {
                case 1:
                    if (this.eLp.getVisibility() != 0) {
                        this.eLp.setVisibility(0);
                    }
                    if (this.eLv.getVisibility() != 8) {
                        this.eLv.setVisibility(8);
                    }
                    bbD();
                    return;
                case 2:
                    if (this.eLp.getVisibility() != 8) {
                        this.eLp.setVisibility(8);
                    }
                    if (this.eLv.getVisibility() != 0) {
                        this.eLv.setVisibility(0);
                        return;
                    }
                    return;
                default:
                    bbD();
                    return;
            }
        }
    }

    public void setData(String str, ak akVar) {
        a(akVar);
        this.eLo.startLoad(str, 10, false);
        this.eLr.setText(akVar.text);
        this.eLr.setTextColor(this.mTextColor);
        this.eLs.setText(akVar.point);
        this.eLs.setTextColor(this.eLD);
        setLayoutBg(akVar);
        setValues(akVar);
        bfF();
    }

    public void setTimer(String str) {
        this.eLx.setText(str);
        if (this.eLp.getVisibility() != 8) {
            this.eLp.setVisibility(8);
        }
        if (this.eLv.getVisibility() != 0) {
            this.eLv.setVisibility(0);
        }
    }

    public void u(final long j, long j2) {
        if (j2 != this.bDL) {
            bbD();
            this.bDL = j2;
            d.wY().E(j);
            this.mTimer = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveDynamicView.1
                @Override // android.os.CountDownTimer
                public void onTick(long j3) {
                    AlaActiveDynamicView.this.at(j.I(j3), (int) ((1.0f - ((((float) j3) * 1.0f) / ((float) j))) * 100.0f));
                    d.wY().E(j3);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    AlaActiveDynamicView.this.oG(1);
                }
            };
            this.mTimer.start();
        }
    }

    private void bbD() {
        this.bDL = 0L;
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        d.wY().xa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void at(String str, int i) {
        if (this.eLz != null && this.eLA != null) {
            this.eLz.setText(str);
            this.eLA.setProgress(i);
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
        bbD();
        this.eLm = null;
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.h.ala_active_dynamic, (ViewGroup) this, true);
        this.eLo = (TbImageView) findViewById(a.g.iv_bg);
        this.eLp = (ViewGroup) findViewById(a.g.layout_data);
        this.eLq = findViewById(a.g.divider_data);
        this.eLr = (TextView) findViewById(a.g.tv_data_title);
        this.eLs = (TextView) findViewById(a.g.tv_data_point);
        this.eLt = (TextView) findViewById(a.g.tv_data_a);
        this.eLu = (TextView) findViewById(a.g.tv_data_b);
        this.eLv = (ViewGroup) findViewById(a.g.layout_timer);
        this.eLw = findViewById(a.g.divider_timer);
        this.eLx = (TextView) findViewById(a.g.tv_timer_title);
        this.eLy = (TextView) findViewById(a.g.tv_timer_tip);
        this.eLz = (TextView) findViewById(a.g.tv_timer_num);
        this.eLA = (ProgressBar) findViewById(a.g.pb_timer);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveDynamicView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaActiveDynamicView.this.eLm != null) {
                    AlaActiveDynamicView.this.eLm.b(AlaActiveDynamicView.this.eLn);
                }
            }
        });
    }

    private void a(ak akVar) {
        boolean z;
        boolean z2 = true;
        if (TextUtils.isEmpty(akVar.aaC)) {
            z = false;
        } else {
            try {
                this.mTextColor = Color.parseColor(akVar.aaC);
                z = true;
            } catch (Exception e) {
                z = false;
            }
        }
        if (!z) {
            this.mTextColor = getResources().getColor(a.d.sdk_active_normal);
        }
        if (TextUtils.isEmpty(akVar.aaD)) {
            z2 = false;
        } else {
            try {
                this.eLD = Color.parseColor(akVar.aaD);
            } catch (Exception e2) {
                z2 = false;
            }
        }
        if (!z2) {
            this.eLD = getResources().getColor(a.d.sdk_active_highlight);
        }
        this.eLB = new ForegroundColorSpan(this.mTextColor);
        this.eLC = new ForegroundColorSpan(this.eLD);
    }

    private void setLayoutBg(ak akVar) {
        int i;
        boolean z;
        int parseColor;
        int parseColor2;
        int i2 = 0;
        String str = akVar.aaE;
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
            String str2 = akVar.aaF;
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
        this.eLp.setBackgroundDrawable(gradientDrawable);
        this.eLv.setBackgroundDrawable(gradientDrawable);
        this.eLq.setBackgroundColor(parseColor2);
        this.eLw.setBackgroundColor(parseColor2);
    }

    private void setValues(ak akVar) {
        List<ak.a> list = akVar.aaB;
        if (list != null) {
            ak.a aVar = list.get(0);
            if (aVar != null) {
                SpannableString spannableString = new SpannableString(aVar.text + "：" + aVar.value);
                spannableString.setSpan(this.eLB, 0, aVar.text.length() + 1, 18);
                spannableString.setSpan(this.eLC, aVar.text.length() + 1, spannableString.length(), 18);
                this.eLt.setText(spannableString);
            }
            ak.a aVar2 = list.get(1);
            if (aVar2 != null) {
                SpannableString spannableString2 = new SpannableString(aVar2.text + "：" + aVar2.value);
                spannableString2.setSpan(this.eLB, 0, aVar2.text.length() + 1, 18);
                spannableString2.setSpan(this.eLC, aVar2.text.length() + 1, spannableString2.length(), 18);
                this.eLu.setText(spannableString2);
            }
        }
    }

    private void bfF() {
        this.eLx.setTextColor(this.eLD);
        this.eLy.setTextColor(this.mTextColor);
        this.eLz.setTextColor(this.mTextColor);
    }
}

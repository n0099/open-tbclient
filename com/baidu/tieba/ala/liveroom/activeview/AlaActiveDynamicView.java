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
import com.baidu.live.data.ba;
import com.baidu.live.data.i;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.w.d;
import java.util.List;
/* loaded from: classes7.dex */
public class AlaActiveDynamicView extends RelativeLayout implements c {
    private TbImageView fAt;
    private a gli;
    private i glj;
    private ViewGroup glk;
    private View gll;
    private TextView glm;
    private TextView gln;
    private TextView glo;
    private TextView glp;
    private ViewGroup glq;
    private View glr;
    private TextView gls;
    private TextView glt;
    private TextView glu;
    private ProgressBar glv;
    private ForegroundColorSpan glw;
    private ForegroundColorSpan glx;
    private int gly;
    private long mEndTime;
    private int mTextColor;
    private CountDownTimer mTimer;

    /* loaded from: classes7.dex */
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
        this.gli = aVar;
    }

    public i getActivityInfo() {
        return this.glj;
    }

    public void setActivityInfo(i iVar) {
        this.glj = iVar;
    }

    public void setData(String str, ba baVar) {
        a(baVar);
        this.fAt.startLoad(str, 10, false);
        this.glm.setText(baVar.text);
        this.glm.setTextColor(this.mTextColor);
        this.gln.setText(baVar.point);
        this.gln.setTextColor(this.gly);
        setLayoutBg(baVar);
        setValues(baVar);
        bMM();
    }

    public void setTimer(String str) {
        this.gls.setText(str);
        if (this.glk.getVisibility() != 8) {
            this.glk.setVisibility(8);
        }
        if (this.glq.getVisibility() != 0) {
            this.glq.setVisibility(0);
        }
    }

    private void bIo() {
        this.mEndTime = 0L;
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        d.Nr().Nt();
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStart() {
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStop() {
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void release() {
        bIo();
        this.gli = null;
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.h.ala_active_dynamic, (ViewGroup) this, true);
        this.fAt = (TbImageView) findViewById(a.g.iv_bg);
        this.glk = (ViewGroup) findViewById(a.g.layout_data);
        this.gll = findViewById(a.g.divider_data);
        this.glm = (TextView) findViewById(a.g.tv_data_title);
        this.gln = (TextView) findViewById(a.g.tv_data_point);
        this.glo = (TextView) findViewById(a.g.tv_data_a);
        this.glp = (TextView) findViewById(a.g.tv_data_b);
        this.glq = (ViewGroup) findViewById(a.g.layout_timer);
        this.glr = findViewById(a.g.divider_timer);
        this.gls = (TextView) findViewById(a.g.tv_timer_title);
        this.glt = (TextView) findViewById(a.g.tv_timer_tip);
        this.glu = (TextView) findViewById(a.g.tv_timer_num);
        this.glv = (ProgressBar) findViewById(a.g.pb_timer);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveDynamicView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaActiveDynamicView.this.gli != null) {
                    AlaActiveDynamicView.this.gli.b(AlaActiveDynamicView.this.glj);
                }
            }
        });
    }

    private void a(ba baVar) {
        boolean z;
        boolean z2 = true;
        if (TextUtils.isEmpty(baVar.aJi)) {
            z = false;
        } else {
            try {
                this.mTextColor = Color.parseColor(baVar.aJi);
                z = true;
            } catch (Exception e) {
                z = false;
            }
        }
        if (!z) {
            this.mTextColor = getResources().getColor(a.d.sdk_active_normal);
        }
        if (TextUtils.isEmpty(baVar.aJj)) {
            z2 = false;
        } else {
            try {
                this.gly = Color.parseColor(baVar.aJj);
            } catch (Exception e2) {
                z2 = false;
            }
        }
        if (!z2) {
            this.gly = getResources().getColor(a.d.sdk_active_highlight);
        }
        this.glw = new ForegroundColorSpan(this.mTextColor);
        this.glx = new ForegroundColorSpan(this.gly);
    }

    private void setLayoutBg(ba baVar) {
        int i;
        boolean z;
        int parseColor;
        int parseColor2;
        int i2 = 0;
        String str = baVar.aJk;
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
            String str2 = baVar.aJl;
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
        this.glk.setBackgroundDrawable(gradientDrawable);
        this.glq.setBackgroundDrawable(gradientDrawable);
        this.gll.setBackgroundColor(parseColor2);
        this.glr.setBackgroundColor(parseColor2);
    }

    private void setValues(ba baVar) {
        List<ba.a> list = baVar.aJh;
        if (list != null) {
            ba.a aVar = list.get(0);
            if (aVar != null) {
                SpannableString spannableString = new SpannableString(aVar.text + "：" + aVar.value);
                spannableString.setSpan(this.glw, 0, aVar.text.length() + 1, 18);
                spannableString.setSpan(this.glx, aVar.text.length() + 1, spannableString.length(), 18);
                this.glo.setText(spannableString);
            }
            ba.a aVar2 = list.get(1);
            if (aVar2 != null) {
                SpannableString spannableString2 = new SpannableString(aVar2.text + "：" + aVar2.value);
                spannableString2.setSpan(this.glw, 0, aVar2.text.length() + 1, 18);
                spannableString2.setSpan(this.glx, aVar2.text.length() + 1, spannableString2.length(), 18);
                this.glp.setText(spannableString2);
            }
        }
    }

    private void bMM() {
        this.gls.setTextColor(this.gly);
        this.glt.setTextColor(this.mTextColor);
        this.glu.setTextColor(this.mTextColor);
    }
}

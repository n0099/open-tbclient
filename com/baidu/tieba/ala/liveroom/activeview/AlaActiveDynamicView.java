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
    private TbImageView fAp;
    private a gle;
    private i glf;
    private ViewGroup glg;
    private View glh;
    private TextView gli;
    private TextView glj;
    private TextView glk;
    private TextView gll;
    private ViewGroup glm;
    private View gln;
    private TextView glo;
    private TextView glp;
    private TextView glq;
    private ProgressBar glr;
    private ForegroundColorSpan gls;
    private ForegroundColorSpan glt;
    private int glu;
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
        this.gle = aVar;
    }

    public i getActivityInfo() {
        return this.glf;
    }

    public void setActivityInfo(i iVar) {
        this.glf = iVar;
    }

    public void setData(String str, ba baVar) {
        a(baVar);
        this.fAp.startLoad(str, 10, false);
        this.gli.setText(baVar.text);
        this.gli.setTextColor(this.mTextColor);
        this.glj.setText(baVar.point);
        this.glj.setTextColor(this.glu);
        setLayoutBg(baVar);
        setValues(baVar);
        bML();
    }

    public void setTimer(String str) {
        this.glo.setText(str);
        if (this.glg.getVisibility() != 8) {
            this.glg.setVisibility(8);
        }
        if (this.glm.getVisibility() != 0) {
            this.glm.setVisibility(0);
        }
    }

    private void bIn() {
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
        bIn();
        this.gle = null;
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.h.ala_active_dynamic, (ViewGroup) this, true);
        this.fAp = (TbImageView) findViewById(a.g.iv_bg);
        this.glg = (ViewGroup) findViewById(a.g.layout_data);
        this.glh = findViewById(a.g.divider_data);
        this.gli = (TextView) findViewById(a.g.tv_data_title);
        this.glj = (TextView) findViewById(a.g.tv_data_point);
        this.glk = (TextView) findViewById(a.g.tv_data_a);
        this.gll = (TextView) findViewById(a.g.tv_data_b);
        this.glm = (ViewGroup) findViewById(a.g.layout_timer);
        this.gln = findViewById(a.g.divider_timer);
        this.glo = (TextView) findViewById(a.g.tv_timer_title);
        this.glp = (TextView) findViewById(a.g.tv_timer_tip);
        this.glq = (TextView) findViewById(a.g.tv_timer_num);
        this.glr = (ProgressBar) findViewById(a.g.pb_timer);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveDynamicView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaActiveDynamicView.this.gle != null) {
                    AlaActiveDynamicView.this.gle.b(AlaActiveDynamicView.this.glf);
                }
            }
        });
    }

    private void a(ba baVar) {
        boolean z;
        boolean z2 = true;
        if (TextUtils.isEmpty(baVar.aJg)) {
            z = false;
        } else {
            try {
                this.mTextColor = Color.parseColor(baVar.aJg);
                z = true;
            } catch (Exception e) {
                z = false;
            }
        }
        if (!z) {
            this.mTextColor = getResources().getColor(a.d.sdk_active_normal);
        }
        if (TextUtils.isEmpty(baVar.aJh)) {
            z2 = false;
        } else {
            try {
                this.glu = Color.parseColor(baVar.aJh);
            } catch (Exception e2) {
                z2 = false;
            }
        }
        if (!z2) {
            this.glu = getResources().getColor(a.d.sdk_active_highlight);
        }
        this.gls = new ForegroundColorSpan(this.mTextColor);
        this.glt = new ForegroundColorSpan(this.glu);
    }

    private void setLayoutBg(ba baVar) {
        int i;
        boolean z;
        int parseColor;
        int parseColor2;
        int i2 = 0;
        String str = baVar.aJi;
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
            String str2 = baVar.aJj;
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
        this.glg.setBackgroundDrawable(gradientDrawable);
        this.glm.setBackgroundDrawable(gradientDrawable);
        this.glh.setBackgroundColor(parseColor2);
        this.gln.setBackgroundColor(parseColor2);
    }

    private void setValues(ba baVar) {
        List<ba.a> list = baVar.aJf;
        if (list != null) {
            ba.a aVar = list.get(0);
            if (aVar != null) {
                SpannableString spannableString = new SpannableString(aVar.text + "：" + aVar.value);
                spannableString.setSpan(this.gls, 0, aVar.text.length() + 1, 18);
                spannableString.setSpan(this.glt, aVar.text.length() + 1, spannableString.length(), 18);
                this.glk.setText(spannableString);
            }
            ba.a aVar2 = list.get(1);
            if (aVar2 != null) {
                SpannableString spannableString2 = new SpannableString(aVar2.text + "：" + aVar2.value);
                spannableString2.setSpan(this.gls, 0, aVar2.text.length() + 1, 18);
                spannableString2.setSpan(this.glt, aVar2.text.length() + 1, spannableString2.length(), 18);
                this.gll.setText(spannableString2);
            }
        }
    }

    private void bML() {
        this.glo.setTextColor(this.glu);
        this.glp.setTextColor(this.mTextColor);
        this.glq.setTextColor(this.mTextColor);
    }
}

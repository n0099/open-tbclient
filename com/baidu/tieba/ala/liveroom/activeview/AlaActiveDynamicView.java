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
import com.baidu.live.data.bf;
import com.baidu.live.data.l;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.x.d;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaActiveDynamicView extends RelativeLayout implements c {
    private TbImageView fDF;
    private TextView goA;
    private TextView goB;
    private ProgressBar goC;
    private ForegroundColorSpan goD;
    private ForegroundColorSpan goE;
    private int goF;
    private a gop;
    private l goq;
    private ViewGroup gor;
    private View gos;
    private TextView got;
    private TextView gou;
    private TextView gov;
    private TextView gow;
    private ViewGroup gox;
    private View goy;
    private TextView goz;
    private long mEndTime;
    private int mTextColor;
    private CountDownTimer mTimer;

    /* loaded from: classes4.dex */
    public interface a {
        void b(l lVar);
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
        this.gop = aVar;
    }

    public l getActivityInfo() {
        return this.goq;
    }

    public void setActivityInfo(l lVar) {
        this.goq = lVar;
    }

    public void setData(String str, bf bfVar) {
        a(bfVar);
        this.fDF.startLoad(str, 10, false);
        this.got.setText(bfVar.text);
        this.got.setTextColor(this.mTextColor);
        this.gou.setText(bfVar.point);
        this.gou.setTextColor(this.goF);
        setLayoutBg(bfVar);
        setValues(bfVar);
        bNW();
    }

    public void setTimer(String str) {
        this.goz.setText(str);
        if (this.gor.getVisibility() != 8) {
            this.gor.setVisibility(8);
        }
        if (this.gox.getVisibility() != 0) {
            this.gox.setVisibility(0);
        }
    }

    private void bJw() {
        this.mEndTime = 0L;
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        d.NU().NW();
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStart() {
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void onStop() {
    }

    @Override // com.baidu.tieba.ala.liveroom.activeview.c
    public void release() {
        bJw();
        this.gop = null;
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.h.ala_active_dynamic, (ViewGroup) this, true);
        this.fDF = (TbImageView) findViewById(a.g.iv_bg);
        this.gor = (ViewGroup) findViewById(a.g.layout_data);
        this.gos = findViewById(a.g.divider_data);
        this.got = (TextView) findViewById(a.g.tv_data_title);
        this.gou = (TextView) findViewById(a.g.tv_data_point);
        this.gov = (TextView) findViewById(a.g.tv_data_a);
        this.gow = (TextView) findViewById(a.g.tv_data_b);
        this.gox = (ViewGroup) findViewById(a.g.layout_timer);
        this.goy = findViewById(a.g.divider_timer);
        this.goz = (TextView) findViewById(a.g.tv_timer_title);
        this.goA = (TextView) findViewById(a.g.tv_timer_tip);
        this.goB = (TextView) findViewById(a.g.tv_timer_num);
        this.goC = (ProgressBar) findViewById(a.g.pb_timer);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaActiveDynamicView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaActiveDynamicView.this.gop != null) {
                    AlaActiveDynamicView.this.gop.b(AlaActiveDynamicView.this.goq);
                }
            }
        });
    }

    private void a(bf bfVar) {
        boolean z;
        boolean z2 = true;
        if (TextUtils.isEmpty(bfVar.aKy)) {
            z = false;
        } else {
            try {
                this.mTextColor = Color.parseColor(bfVar.aKy);
                z = true;
            } catch (Exception e) {
                z = false;
            }
        }
        if (!z) {
            this.mTextColor = getResources().getColor(a.d.sdk_active_normal);
        }
        if (TextUtils.isEmpty(bfVar.aKz)) {
            z2 = false;
        } else {
            try {
                this.goF = Color.parseColor(bfVar.aKz);
            } catch (Exception e2) {
                z2 = false;
            }
        }
        if (!z2) {
            this.goF = getResources().getColor(a.d.sdk_active_highlight);
        }
        this.goD = new ForegroundColorSpan(this.mTextColor);
        this.goE = new ForegroundColorSpan(this.goF);
    }

    private void setLayoutBg(bf bfVar) {
        int i;
        boolean z;
        int parseColor;
        int parseColor2;
        int i2 = 0;
        String str = bfVar.aKA;
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
            String str2 = bfVar.aKB;
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
        this.gor.setBackgroundDrawable(gradientDrawable);
        this.gox.setBackgroundDrawable(gradientDrawable);
        this.gos.setBackgroundColor(parseColor2);
        this.goy.setBackgroundColor(parseColor2);
    }

    private void setValues(bf bfVar) {
        List<bf.a> list = bfVar.aKx;
        if (list != null) {
            bf.a aVar = list.get(0);
            if (aVar != null) {
                SpannableString spannableString = new SpannableString(aVar.text + "：" + aVar.value);
                spannableString.setSpan(this.goD, 0, aVar.text.length() + 1, 18);
                spannableString.setSpan(this.goE, aVar.text.length() + 1, spannableString.length(), 18);
                this.gov.setText(spannableString);
            }
            bf.a aVar2 = list.get(1);
            if (aVar2 != null) {
                SpannableString spannableString2 = new SpannableString(aVar2.text + "：" + aVar2.value);
                spannableString2.setSpan(this.goD, 0, aVar2.text.length() + 1, 18);
                spannableString2.setSpan(this.goE, aVar2.text.length() + 1, spannableString2.length(), 18);
                this.gow.setText(spannableString2);
            }
        }
    }

    private void bNW() {
        this.goz.setTextColor(this.goF);
        this.goA.setTextColor(this.mTextColor);
        this.goB.setTextColor(this.mTextColor);
    }
}

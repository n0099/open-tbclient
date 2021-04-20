package com.baidu.tieba.homepage.hotTopic.tab.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TagTextHelper;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
import d.b.h0.m.f;
import d.b.i0.a1.e.a.e.e;
/* loaded from: classes4.dex */
public class HotTopicTabThreadItem extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f16867e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f16868f;

    /* renamed from: g  reason: collision with root package name */
    public View f16869g;

    /* renamed from: h  reason: collision with root package name */
    public View f16870h;
    public ImageView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public View n;
    public e o;
    public f<e> p;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (HotTopicTabThreadItem.this.o == null || HotTopicTabThreadItem.this.o.j == null) {
                return;
            }
            if (HotTopicTabThreadItem.this.p != null) {
                HotTopicTabThreadItem.this.p.a(view, HotTopicTabThreadItem.this.o, HotTopicTabThreadItem.this.o.f52593e, HotTopicTabThreadItem.this.o.f52593e);
            }
            ThreadCardUtils.jumpToPB((d.b.h0.r.q.a) HotTopicTabThreadItem.this.o.j, view.getContext(), 2, false, true);
        }
    }

    public HotTopicTabThreadItem(Context context) {
        super(context);
        this.f16867e = 3;
        e();
    }

    public void c(e eVar) {
        e eVar2;
        if (eVar != null) {
            this.o = eVar;
            if (TextUtils.isEmpty(eVar.f52596h)) {
                this.f16868f.setVisibility(8);
                this.f16869g.setVisibility(8);
                this.f16870h.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
                layoutParams.addRule(8, 0);
                layoutParams.addRule(3, R.id.titleView);
                this.m.setLayoutParams(layoutParams);
            } else {
                this.f16868f.W(eVar.f52596h, 10, false);
                this.f16868f.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
                layoutParams2.addRule(8, R.id.coverView);
                layoutParams2.addRule(3, 0);
                this.m.setLayoutParams(layoutParams2);
                if (eVar.i > 0) {
                    this.f16870h.setVisibility(0);
                    this.f16869g.setVisibility(0);
                    this.j.setText(StringUtils.translateSecondsToString(eVar.i));
                } else {
                    this.f16870h.setVisibility(8);
                    this.f16869g.setVisibility(8);
                }
            }
            this.l.setText(eVar.f52594f);
            int i = eVar.f52595g;
            if (i < 1000) {
                i = 1000;
            }
            String numberUniformFormatExtraWithRoundInt = StringHelper.numberUniformFormatExtraWithRoundInt(i);
            TextView textView = this.m;
            textView.setText(textView.getContext().getResources().getString(R.string.hot_topic_thread_item_tag, numberUniformFormatExtraWithRoundInt));
            this.k.setText(String.valueOf(eVar.f52593e));
            d();
            f<e> fVar = this.p;
            if (fVar == null || (eVar2 = this.o) == null) {
                return;
            }
            int i2 = eVar2.f52593e;
            fVar.c(this, eVar2, i2, i2);
        }
    }

    public final void d() {
        e eVar = this.o;
        if (eVar != null) {
            int indexTextColorRes = TagTextHelper.getIndexTextColorRes(eVar.f52593e);
            Drawable background = this.m.getBackground();
            DrawableCompat.setTint(background, SkinManager.getColor(indexTextColorRes));
            background.setAlpha(40);
            this.m.setBackgroundDrawable(background);
            SkinManager.setViewTextColor(this.m, indexTextColorRes);
            Drawable background2 = this.k.getBackground();
            DrawableCompat.setTint(background2, SkinManager.getColor(indexTextColorRes));
            this.k.setBackgroundDrawable(background2);
        }
    }

    public final void e() {
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_tab_thread_item, (ViewGroup) this, true);
        this.f16868f = (TbImageView) findViewById(R.id.coverView);
        this.f16869g = findViewById(R.id.coverGradientMask);
        this.f16870h = findViewById(R.id.videoTimeContainer);
        this.i = (ImageView) findViewById(R.id.videoPlayIcon);
        this.j = (TextView) findViewById(R.id.videoPlayTime);
        this.k = (TextView) findViewById(R.id.indexView);
        this.l = (TextView) findViewById(R.id.titleView);
        this.m = (TextView) findViewById(R.id.tagView);
        this.f16868f.setPlaceHolder(2);
        this.f16868f.setRadius(l.g(getContext(), R.dimen.tbds10));
        this.f16868f.setConrers(15);
        View findViewById = findViewById(R.id.rootLayout);
        this.n = findViewById;
        findViewById.setOnClickListener(new a());
    }

    public void f(int i) {
        if (this.f16867e != i) {
            TBSelector.setViewBackgroundColorWithPressedState(this.n, R.color.CAM_X0205, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0101);
            this.i.setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, null));
            d();
            this.f16867e = i;
        }
    }

    public void setOnItemCoverListener(f<e> fVar) {
        this.p = fVar;
    }

    public HotTopicTabThreadItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16867e = 3;
        e();
    }

    public HotTopicTabThreadItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f16867e = 3;
        e();
    }
}

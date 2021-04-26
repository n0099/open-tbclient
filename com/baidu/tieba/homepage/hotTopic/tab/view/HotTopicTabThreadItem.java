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
import d.a.c.e.p.l;
import d.a.i0.m.f;
import d.a.j0.a1.e.a.e.e;
/* loaded from: classes4.dex */
public class HotTopicTabThreadItem extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f17142e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f17143f;

    /* renamed from: g  reason: collision with root package name */
    public View f17144g;

    /* renamed from: h  reason: collision with root package name */
    public View f17145h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f17146i;
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
                HotTopicTabThreadItem.this.p.a(view, HotTopicTabThreadItem.this.o, HotTopicTabThreadItem.this.o.f50717e, HotTopicTabThreadItem.this.o.f50717e);
            }
            ThreadCardUtils.jumpToPB((d.a.i0.r.q.a) HotTopicTabThreadItem.this.o.j, view.getContext(), 2, false, true);
        }
    }

    public HotTopicTabThreadItem(Context context) {
        super(context);
        this.f17142e = 3;
        e();
    }

    public void c(e eVar) {
        e eVar2;
        if (eVar != null) {
            this.o = eVar;
            if (TextUtils.isEmpty(eVar.f50720h)) {
                this.f17143f.setVisibility(8);
                this.f17144g.setVisibility(8);
                this.f17145h.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
                layoutParams.addRule(8, 0);
                layoutParams.addRule(3, R.id.titleView);
                this.m.setLayoutParams(layoutParams);
            } else {
                this.f17143f.V(eVar.f50720h, 10, false);
                this.f17143f.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
                layoutParams2.addRule(8, R.id.coverView);
                layoutParams2.addRule(3, 0);
                this.m.setLayoutParams(layoutParams2);
                if (eVar.f50721i > 0) {
                    this.f17145h.setVisibility(0);
                    this.f17144g.setVisibility(0);
                    this.j.setText(StringUtils.translateSecondsToString(eVar.f50721i));
                } else {
                    this.f17145h.setVisibility(8);
                    this.f17144g.setVisibility(8);
                }
            }
            this.l.setText(eVar.f50718f);
            int i2 = eVar.f50719g;
            if (i2 < 1000) {
                i2 = 1000;
            }
            String numberUniformFormatExtraWithRoundInt = StringHelper.numberUniformFormatExtraWithRoundInt(i2);
            TextView textView = this.m;
            textView.setText(textView.getContext().getResources().getString(R.string.hot_topic_thread_item_tag, numberUniformFormatExtraWithRoundInt));
            this.k.setText(String.valueOf(eVar.f50717e));
            d();
            f<e> fVar = this.p;
            if (fVar == null || (eVar2 = this.o) == null) {
                return;
            }
            int i3 = eVar2.f50717e;
            fVar.c(this, eVar2, i3, i3);
        }
    }

    public final void d() {
        e eVar = this.o;
        if (eVar != null) {
            int indexTextColorRes = TagTextHelper.getIndexTextColorRes(eVar.f50717e);
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
        this.f17143f = (TbImageView) findViewById(R.id.coverView);
        this.f17144g = findViewById(R.id.coverGradientMask);
        this.f17145h = findViewById(R.id.videoTimeContainer);
        this.f17146i = (ImageView) findViewById(R.id.videoPlayIcon);
        this.j = (TextView) findViewById(R.id.videoPlayTime);
        this.k = (TextView) findViewById(R.id.indexView);
        this.l = (TextView) findViewById(R.id.titleView);
        this.m = (TextView) findViewById(R.id.tagView);
        this.f17143f.setPlaceHolder(2);
        this.f17143f.setRadius(l.g(getContext(), R.dimen.tbds10));
        this.f17143f.setConrers(15);
        View findViewById = findViewById(R.id.rootLayout);
        this.n = findViewById;
        findViewById.setOnClickListener(new a());
    }

    public void f(int i2) {
        if (this.f17142e != i2) {
            TBSelector.setViewBackgroundColorWithPressedState(this.n, R.color.CAM_X0205, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0101);
            this.f17146i.setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, null));
            d();
            this.f17142e = i2;
        }
    }

    public void setOnItemCoverListener(f<e> fVar) {
        this.p = fVar;
    }

    public HotTopicTabThreadItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17142e = 3;
        e();
    }

    public HotTopicTabThreadItem(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f17142e = 3;
        e();
    }
}

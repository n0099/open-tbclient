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
import d.a.m0.m.f;
import d.a.n0.b1.e.a.e.e;
/* loaded from: classes4.dex */
public class HotTopicTabThreadItem extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f16362e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f16363f;

    /* renamed from: g  reason: collision with root package name */
    public View f16364g;

    /* renamed from: h  reason: collision with root package name */
    public View f16365h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f16366i;
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
                HotTopicTabThreadItem.this.p.a(view, HotTopicTabThreadItem.this.o, HotTopicTabThreadItem.this.o.f51579e, HotTopicTabThreadItem.this.o.f51579e);
            }
            ThreadCardUtils.jumpToPB((d.a.m0.r.q.a) HotTopicTabThreadItem.this.o.j, view.getContext(), 2, false, true);
        }
    }

    public HotTopicTabThreadItem(Context context) {
        super(context);
        this.f16362e = 3;
        e();
    }

    public void c(e eVar) {
        e eVar2;
        if (eVar != null) {
            this.o = eVar;
            if (TextUtils.isEmpty(eVar.f51582h)) {
                this.f16363f.setVisibility(8);
                this.f16364g.setVisibility(8);
                this.f16365h.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
                layoutParams.addRule(8, 0);
                layoutParams.addRule(3, R.id.titleView);
                this.m.setLayoutParams(layoutParams);
            } else {
                this.f16363f.V(eVar.f51582h, 10, false);
                this.f16363f.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
                layoutParams2.addRule(8, R.id.coverView);
                layoutParams2.addRule(3, 0);
                this.m.setLayoutParams(layoutParams2);
                if (eVar.f51583i > 0) {
                    this.f16365h.setVisibility(0);
                    this.f16364g.setVisibility(0);
                    this.j.setText(StringUtils.translateSecondsToString(eVar.f51583i));
                } else {
                    this.f16365h.setVisibility(8);
                    this.f16364g.setVisibility(8);
                }
            }
            this.l.setText(eVar.f51580f);
            int i2 = eVar.f51581g;
            if (i2 < 1000) {
                i2 = 1000;
            }
            String numberUniformFormatExtraWithRoundInt = StringHelper.numberUniformFormatExtraWithRoundInt(i2);
            TextView textView = this.m;
            textView.setText(textView.getContext().getResources().getString(R.string.hot_topic_thread_item_tag, numberUniformFormatExtraWithRoundInt));
            this.k.setText(String.valueOf(eVar.f51579e));
            d();
            f<e> fVar = this.p;
            if (fVar == null || (eVar2 = this.o) == null) {
                return;
            }
            int i3 = eVar2.f51579e;
            fVar.c(this, eVar2, i3, i3);
        }
    }

    public final void d() {
        e eVar = this.o;
        if (eVar != null) {
            int indexTextColorRes = TagTextHelper.getIndexTextColorRes(eVar.f51579e);
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
        this.f16363f = (TbImageView) findViewById(R.id.coverView);
        this.f16364g = findViewById(R.id.coverGradientMask);
        this.f16365h = findViewById(R.id.videoTimeContainer);
        this.f16366i = (ImageView) findViewById(R.id.videoPlayIcon);
        this.j = (TextView) findViewById(R.id.videoPlayTime);
        this.k = (TextView) findViewById(R.id.indexView);
        this.l = (TextView) findViewById(R.id.titleView);
        this.m = (TextView) findViewById(R.id.tagView);
        this.f16363f.setPlaceHolder(2);
        this.f16363f.setRadius(l.g(getContext(), R.dimen.tbds10));
        this.f16363f.setConrers(15);
        View findViewById = findViewById(R.id.rootLayout);
        this.n = findViewById;
        findViewById.setOnClickListener(new a());
    }

    public void f(int i2) {
        if (this.f16362e != i2) {
            TBSelector.setViewBackgroundColorWithPressedState(this.n, R.color.CAM_X0205, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0101);
            this.f16366i.setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, null));
            d();
            this.f16362e = i2;
        }
    }

    public void setOnItemCoverListener(f<e> fVar) {
        this.p = fVar;
    }

    public HotTopicTabThreadItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16362e = 3;
        e();
    }

    public HotTopicTabThreadItem(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f16362e = 3;
        e();
    }
}

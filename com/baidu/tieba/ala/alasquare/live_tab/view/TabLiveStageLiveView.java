package com.baidu.tieba.ala.alasquare.live_tab.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.ala.utils.AlaUtilHelper;
import com.baidu.ala.view.AlaRoundRelativeLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
import d.b.h0.z0.i0;
import d.b.i0.t.d.c.c;
/* loaded from: classes4.dex */
public class TabLiveStageLiveView extends AlaRoundRelativeLayout {
    public static final float p;
    public static final float[] q;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f14475e;

    /* renamed from: f  reason: collision with root package name */
    public HeadImageView f14476f;

    /* renamed from: g  reason: collision with root package name */
    public View f14477g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f14478h;
    public TextView i;
    public TextView j;
    public View k;
    public TabLiveStageLiveZanLottieView l;
    public int m;
    public SdkLiveInfoData n;
    public int[] o;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.f(TabLiveStageLiveView.this.getContext(), TabLiveStageLiveView.this.n);
            if (TabLiveStageLiveView.this.m != 101) {
                if (TabLiveStageLiveView.this.m == 102) {
                    StatisticItem statisticItem = new StatisticItem("c13559");
                    statisticItem.param(TiebaStatic.Params.ENTRY_NAME, "推荐");
                    TiebaStatic.log(statisticItem);
                    return;
                }
                return;
            }
            StatisticItem statisticItem2 = new StatisticItem("c13556");
            statisticItem2.param(TiebaStatic.Params.ENTRY_NAME, "推荐");
            TiebaStatic.log(statisticItem2);
        }
    }

    static {
        float dimension = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
        p = dimension;
        q = new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimension, dimension, dimension, dimension};
    }

    public TabLiveStageLiveView(Context context) {
        super(context);
        this.m = 101;
        this.o = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    public void c() {
        SkinManager.setViewTextColor(this.f14478h, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0101);
        Drawable drawable = SkinManager.getDrawable(getContext().getResources(), R.drawable.tab_icon_living_seeding);
        drawable.setBounds(0, 0, getContext().getResources().getDimensionPixelOffset(R.dimen.tbds18), getContext().getResources().getDimensionPixelOffset(R.dimen.tbds18));
        this.j.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.j.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelOffset(R.dimen.tbds8));
    }

    public final void d() {
        try {
            this.l.setAnimation("zan_lottie_anim.json");
            this.l.setImageAssetsFolder("images/");
            this.l.loop(true);
            this.l.playAnimation();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.tab_stage_view, this);
        float f2 = p;
        setRoundLayoutRadius(new float[]{f2, f2, f2, f2, f2, f2, f2, f2});
        TabLiveStageLiveZanLottieView tabLiveStageLiveZanLottieView = (TabLiveStageLiveZanLottieView) findViewById(R.id.zan_lottie_view);
        this.l = tabLiveStageLiveZanLottieView;
        tabLiveStageLiveZanLottieView.setForbidAutoUpdateState(true);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.cover);
        this.f14475e = tbImageView;
        tbImageView.setBackgroundColor(0);
        this.f14475e.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.f14475e.setConrers(15);
        HeadImageView headImageView = (HeadImageView) findViewById(R.id.head_img);
        this.f14476f = headImageView;
        headImageView.setAutoChangeStyle(false);
        this.f14476f.setClickable(true);
        this.f14476f.setIsRound(true);
        this.f14476f.setBorderWidth(l.g(getContext(), R.dimen.tbds1));
        this.f14477g = findViewById(R.id.head_mask_view);
        this.f14478h = (TextView) findViewById(R.id.title);
        this.i = (TextView) findViewById(R.id.user_name);
        this.j = (TextView) findViewById(R.id.audience_count);
        this.k = findViewById(R.id.bottom_gradient_bg);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.o);
        gradientDrawable.setCornerRadii(q);
        this.k.setBackgroundDrawable(gradientDrawable);
        setOnClickListener(new a());
        d();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TabLiveStageLiveZanLottieView tabLiveStageLiveZanLottieView = this.l;
        if (tabLiveStageLiveZanLottieView == null || tabLiveStageLiveZanLottieView.isAnimating()) {
            return;
        }
        this.l.playAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        TabLiveStageLiveZanLottieView tabLiveStageLiveZanLottieView = this.l;
        if (tabLiveStageLiveZanLottieView != null && tabLiveStageLiveZanLottieView.isAnimating()) {
            this.l.pauseAnimation();
        }
        super.onDetachedFromWindow();
    }

    public void setData(SdkLiveInfoData sdkLiveInfoData, int i) {
        if (sdkLiveInfoData != null && sdkLiveInfoData.liveInfo != null) {
            this.n = sdkLiveInfoData;
            this.m = i;
            this.f14475e.setPlaceHolder(3);
            this.f14475e.W(sdkLiveInfoData.liveInfo.cover, 10, false);
            SdkLiveInfoData.LiveAuthor liveAuthor = sdkLiveInfoData.liveAuthor;
            if (liveAuthor != null) {
                String name_show = liveAuthor.getName_show();
                if (i0.d(name_show) > 16) {
                    name_show = i0.m(name_show, 16) + StringHelper.STRING_MORE;
                }
                this.i.setText(name_show);
                AlaUtilHelper.startLoadPortrait(this.f14476f, sdkLiveInfoData.liveAuthor.portrait, false);
                if (1 == TbadkCoreApplication.getInst().getSkinType()) {
                    this.f14477g.setVisibility(0);
                } else {
                    this.f14477g.setVisibility(8);
                }
            }
            this.f14478h.setText(sdkLiveInfoData.title);
            this.j.setText(getContext().getResources().getString(R.string.square_sub_live_audience_label, StringHelper.numberUniformFormatExtraWithRound(sdkLiveInfoData.liveInfo.audienceCount)));
            return;
        }
        setVisibility(4);
    }

    public TabLiveStageLiveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.m = 101;
        this.o = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    public TabLiveStageLiveView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.m = 101;
        this.o = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }
}

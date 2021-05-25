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
import com.baidu.swan.facade.requred.webview.LoadingActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.a.j;
import d.a.c.e.p.l;
import d.a.m0.z0.i0;
import d.a.n0.v.d.c.c;
/* loaded from: classes4.dex */
public class TabLiveStageLiveView extends AlaRoundRelativeLayout {
    public static final float p;
    public static final float[] q;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f13771e;

    /* renamed from: f  reason: collision with root package name */
    public HeadImageView f13772f;

    /* renamed from: g  reason: collision with root package name */
    public View f13773g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f13774h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f13775i;
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
            if (!c.d(TabLiveStageLiveView.this.n)) {
                c.h(TabLiveStageLiveView.this.getContext(), TabLiveStageLiveView.this.n);
            } else if (j.a(TabLiveStageLiveView.this.getContext()) instanceof TbPageContext) {
                c.j((TbPageContext) j.a(TabLiveStageLiveView.this.getContext()), TabLiveStageLiveView.this.n);
            }
            int i2 = TabLiveStageLiveView.this.m;
            String str = TiebaStatic.YYValues.YY_LIVE;
            if (i2 != 101) {
                if (TabLiveStageLiveView.this.m == 102) {
                    StatisticItem statisticItem = new StatisticItem("c13559");
                    if (TabLiveStageLiveView.this.n.liveInfo != null) {
                        int a2 = c.a(TabLiveStageLiveView.this.n.liveInfo);
                        if (TabLiveStageLiveView.this.n.liveInfo.yyExt != null) {
                            TiebaStaticHelper.addYYParam(statisticItem, c.k(TabLiveStageLiveView.this.n.liveInfo.yyExt));
                        } else {
                            str = "";
                        }
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, a2);
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, str);
                    }
                    statisticItem.param(TiebaStatic.Params.ENTRY_NAME, "推荐");
                    TiebaStatic.log(statisticItem);
                    return;
                }
                return;
            }
            StatisticItem statisticItem2 = new StatisticItem("c13556");
            if (TabLiveStageLiveView.this.n.liveInfo != null) {
                int a3 = c.a(TabLiveStageLiveView.this.n.liveInfo);
                if (TabLiveStageLiveView.this.n.liveInfo.yyExt != null) {
                    TiebaStaticHelper.addYYParam(statisticItem2, c.k(TabLiveStageLiveView.this.n.liveInfo.yyExt));
                } else {
                    str = "";
                }
                statisticItem2.param("obj_param1", a3);
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, str);
            }
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
        SkinManager.setViewTextColor(this.f13774h, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f13775i, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0101);
        Drawable drawable = SkinManager.getDrawable(getContext().getResources(), R.drawable.tab_icon_living_seeding);
        drawable.setBounds(0, 0, getContext().getResources().getDimensionPixelOffset(R.dimen.tbds18), getContext().getResources().getDimensionPixelOffset(R.dimen.tbds18));
        this.j.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.j.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelOffset(R.dimen.tbds8));
    }

    public final void d() {
        try {
            this.l.setAnimation("zan_lottie_anim.json");
            this.l.setImageAssetsFolder(LoadingActivity.LOTTIE_ASSETS_PATH);
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
        this.f13771e = tbImageView;
        tbImageView.setBackgroundColor(0);
        this.f13771e.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.f13771e.setConrers(15);
        HeadImageView headImageView = (HeadImageView) findViewById(R.id.head_img);
        this.f13772f = headImageView;
        headImageView.setAutoChangeStyle(false);
        this.f13772f.setClickable(true);
        this.f13772f.setIsRound(true);
        this.f13772f.setBorderWidth(l.g(getContext(), R.dimen.tbds1));
        this.f13773g = findViewById(R.id.head_mask_view);
        this.f13774h = (TextView) findViewById(R.id.title);
        this.f13775i = (TextView) findViewById(R.id.user_name);
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

    public void setData(SdkLiveInfoData sdkLiveInfoData, int i2) {
        if (sdkLiveInfoData != null && sdkLiveInfoData.liveInfo != null) {
            this.n = sdkLiveInfoData;
            this.m = i2;
            this.f13771e.setPlaceHolder(3);
            this.f13771e.V(sdkLiveInfoData.liveInfo.cover, 10, false);
            SdkLiveInfoData.LiveAuthor liveAuthor = sdkLiveInfoData.liveAuthor;
            if (liveAuthor != null) {
                String name_show = liveAuthor.getName_show();
                if (i0.d(name_show) > 16) {
                    name_show = i0.m(name_show, 16) + StringHelper.STRING_MORE;
                }
                this.f13775i.setText(name_show);
                AlaUtilHelper.startLoadPortrait(this.f13772f, sdkLiveInfoData.liveAuthor.portrait, false);
                if (1 == TbadkCoreApplication.getInst().getSkinType()) {
                    this.f13773g.setVisibility(0);
                } else {
                    this.f13773g.setVisibility(8);
                }
            }
            this.f13774h.setText(sdkLiveInfoData.title);
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

    public TabLiveStageLiveView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.m = 101;
        this.o = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }
}

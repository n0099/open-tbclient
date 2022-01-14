package com.baidu.tieba.hottopic.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.t0.q1.h;
import c.a.t0.q1.l.f;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.PagerSlidingTabStrip;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import org.apache.commons.lang3.text.FormattableUtils;
/* loaded from: classes12.dex */
public class HotTopicHeaderView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener A;
    public ClickableSpan B;
    public ClickableSpan C;

    /* renamed from: e  reason: collision with root package name */
    public int f44674e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f44675f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f44676g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f44677h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f44678i;

    /* renamed from: j  reason: collision with root package name */
    public View f44679j;
    public LinearLayout k;
    public LinearLayout l;
    public ImageView m;
    public TextView n;
    public TextView o;
    public PagerSlidingTabStrip p;
    public View q;
    public ImageView r;
    public View s;
    public boolean t;
    public c.a.s0.g1.j.e u;
    public int v;
    public String w;
    public int x;
    public int y;
    public f z;

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicHeaderView f44680e;

        public a(HotTopicHeaderView hotTopicHeaderView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicHeaderView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44680e = hotTopicHeaderView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f44680e.z == null || StringUtils.isNull(this.f44680e.z.s)) {
                return;
            }
            c.a.s0.m.a.m(this.f44680e.getContext(), this.f44680e.z.s);
        }
    }

    /* loaded from: classes12.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicHeaderView f44681e;

        public b(HotTopicHeaderView hotTopicHeaderView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicHeaderView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44681e = hotTopicHeaderView;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                HotTopicHeaderView hotTopicHeaderView = this.f44681e;
                hotTopicHeaderView.y = hotTopicHeaderView.f44676g.getMeasuredHeight();
                this.f44681e.f44676g.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f44682e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HotTopicHeaderView f44683f;

        public c(HotTopicHeaderView hotTopicHeaderView, f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicHeaderView, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44683f = hotTopicHeaderView;
            this.f44682e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(view.getContext()).createNormalConfig("hottopic", this.f44682e.o)));
                TiebaStatic.log(new StatisticItem("c10813").param("obj_name", this.f44682e.f21544f));
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicHeaderView f44684e;

        public d(HotTopicHeaderView hotTopicHeaderView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicHeaderView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44684e = hotTopicHeaderView;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) this.f44684e.w);
                if (this.f44684e.w.length() > 500) {
                    spannableStringBuilder.append((CharSequence) "...  ");
                }
                String str = this.f44684e.getResources().getString(h.hot_topic_coll) + GlideException.IndentedAppendable.INDENT;
                spannableStringBuilder.append((CharSequence) str);
                SpannableString spannableString = new SpannableString(spannableStringBuilder);
                spannableString.setSpan(this.f44684e.C, spannableString.length() - str.length(), spannableString.length(), 33);
                this.f44684e.f44678i.setText(spannableString);
                this.f44684e.f44678i.setHeight(this.f44684e.v * this.f44684e.f44678i.getLineHeight());
                int lineCount = this.f44684e.f44678i.getLineCount() * this.f44684e.f44678i.getLineHeight();
                if (lineCount > this.f44684e.v * this.f44684e.f44678i.getLineHeight()) {
                    this.f44684e.f44678i.scrollTo(0, lineCount - (this.f44684e.v * this.f44684e.f44678i.getLineHeight()));
                }
                this.f44684e.f44678i.requestLayout();
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                textPaint.setColor(this.f44684e.getResources().getColor(c.a.t0.q1.b.CAM_X0304));
            }
        }
    }

    /* loaded from: classes12.dex */
    public class e extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicHeaderView f44685e;

        public e(HotTopicHeaderView hotTopicHeaderView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicHeaderView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44685e = hotTopicHeaderView;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f44685e.f44678i.setText(this.f44685e.w);
                this.f44685e.i();
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                textPaint.setColor(this.f44685e.getResources().getColor(c.a.t0.q1.b.CAM_X0304));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicHeaderView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f44674e = 3;
        this.t = false;
        this.w = "";
        this.x = 0;
        this.y = 0;
        this.A = new a(this);
        this.B = new d(this);
        this.C = new e(this);
        j(context);
    }

    public void changePlaceHolderHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            ((LinearLayout.LayoutParams) this.s.getLayoutParams()).height = i2;
            this.s.postInvalidate();
        }
    }

    public int getNavigationBarSwitchHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            f fVar = this.z;
            boolean z = (fVar == null || StringUtils.isNull(fVar.f21547i)) ? false : true;
            int i2 = this.y;
            View view = this.s;
            if (view != null) {
                i2 += view.getMeasuredHeight();
            }
            return z ? this.y + this.x : i2;
        }
        return invokeV.intValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) this.w);
            String string = getResources().getString(h.hot_topic_detail);
            SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) spannableStringBuilder.subSequence(0, (this.f44678i.getLayout().getLineEnd(2) - string.length()) - 2);
            spannableStringBuilder2.append((CharSequence) "...  ");
            int length = spannableStringBuilder2.length();
            spannableStringBuilder2.append((CharSequence) string);
            SpannableString spannableString = new SpannableString(spannableStringBuilder2);
            spannableString.setSpan(this.B, length - 1, spannableString.length(), 33);
            this.f44678i.setText(spannableString);
            TextView textView = this.f44678i;
            textView.setHeight(textView.getLineHeight() * 3);
            this.f44678i.scrollTo(0, 0);
            this.f44678i.requestLayout();
        }
    }

    public boolean isDataSet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.t : invokeV.booleanValue;
    }

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            this.x = n.f(context, c.a.t0.q1.c.tbds418);
            setOrientation(1);
            LayoutInflater.from(context).inflate(c.a.t0.q1.f.hot_topic_topicinfo_item, (ViewGroup) this, true);
            this.s = findViewById(c.a.t0.q1.e.hot_topic_info_place_holder);
            TbImageView tbImageView = (TbImageView) findViewById(c.a.t0.q1.e.hot_topic_info_picture);
            this.f44675f = tbImageView;
            tbImageView.setOnClickListener(this.A);
            this.f44676g = (TextView) findViewById(c.a.t0.q1.e.hot_topic_info_title);
            this.f44677h = (TextView) findViewById(c.a.t0.q1.e.hot_topic_info_threadcount);
            this.f44678i = (TextView) findViewById(c.a.t0.q1.e.hot_topic_info_abstract);
            View findViewById = findViewById(c.a.t0.q1.e.divider_line);
            this.f44679j = findViewById;
            findViewById.setVisibility(8);
            this.k = (LinearLayout) findViewById(c.a.t0.q1.e.hot_topic_ranking_item);
            this.l = (LinearLayout) findViewById(c.a.t0.q1.e.hot_topic_ranking_content);
            this.n = (TextView) findViewById(c.a.t0.q1.e.hot_topic_ranklist_title);
            this.m = (ImageView) findViewById(c.a.t0.q1.e.ranklist_pic_r);
            this.o = (TextView) findViewById(c.a.t0.q1.e.hot_topic_look_ranklist);
            PagerSlidingTabStrip pagerSlidingTabStrip = (PagerSlidingTabStrip) findViewById(c.a.t0.q1.e.hot_topic_tab_strip);
            this.p = pagerSlidingTabStrip;
            pagerSlidingTabStrip.init(n.f(context, c.a.t0.q1.c.ds32), n.f(context, c.a.t0.q1.c.ds1), n.f(context, c.a.t0.q1.c.ds4), true);
            View findViewById2 = findViewById(c.a.t0.q1.e.tab_divider_line);
            this.q = findViewById2;
            findViewById2.setVisibility(8);
            this.r = (ImageView) findViewById(c.a.t0.q1.e.hot_topic_tab_strip_bottomline);
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.f44674e) {
            return;
        }
        this.f44674e = skinType;
        SkinManager.setBackgroundColor(this, c.a.t0.q1.b.CAM_X0201);
        SkinManager.setBackgroundColor(this.p, c.a.t0.q1.b.CAM_X0201);
        SkinManager.setViewTextColor(this.f44676g, c.a.t0.q1.b.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.f44677h, c.a.t0.q1.b.CAM_X0301, 1);
        SkinManager.setViewTextColor(this.f44678i, c.a.t0.q1.b.CAM_X0108, 1);
        SkinManager.setBackgroundColor(this.f44679j, c.a.t0.q1.b.CAM_X0205);
        SkinManager.setBackgroundColor(this.q, c.a.t0.q1.b.CAM_X0205);
        SkinManager.setViewTextColor(this.n, c.a.t0.q1.b.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.o, c.a.t0.q1.b.CAM_X0107, 1);
        SkinManager.setBackgroundResource(this.m, c.a.t0.q1.d.icon_arrow_more_gray);
        SkinManager.setBackgroundResource(this.l, c.a.t0.q1.d.hot_topic_ranklist_bg);
        SkinManager.setBackgroundColor(this.r, c.a.t0.q1.b.CAM_X0204);
        this.p.onChangeSkinType();
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048582, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            c.a.s0.g1.j.e eVar = this.u;
            if (eVar != null) {
                eVar.a(this, i2, i3, i4, i5);
            }
        }
    }

    public void setData(f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, fVar) == null) || fVar == null || StringUtils.isNull(fVar.f21544f)) {
            return;
        }
        this.z = fVar;
        this.t = true;
        this.f44675f.setDefaultBgResource(c.a.t0.q1.b.CAM_X0205);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f44675f.getLayoutParams();
        layoutParams.height = this.x;
        this.f44675f.setLayoutParams(layoutParams);
        if (!StringUtils.isNull(fVar.f21547i) && StringUtils.isNull(fVar.n)) {
            this.f44675f.startLoad(fVar.f21547i, 10, false);
            this.s.setVisibility(8);
        } else {
            this.f44675f.setVisibility(8);
            this.s.setVisibility(0);
        }
        this.f44676g.setSingleLine();
        String trim = fVar.f21544f.trim();
        fVar.f21544f = trim;
        if (!StringUtils.isNull(trim)) {
            this.f44676g.setText(c.a.t0.q1.n.a.a(fVar.f21544f, 10));
        } else {
            this.f44676g.setText("");
        }
        this.f44676g.getViewTreeObserver().addOnGlobalLayoutListener(new b(this));
        this.f44677h.setText(TbadkCoreApplication.getInst().getString(h.hot_topic_info_threadCount).replace(FormattableUtils.SIMPLEST_FORMAT, StringHelper.longNumFormatOver9999wan(fVar.f21546h)));
        if (StringUtils.isNull(fVar.f21545g)) {
            this.f44678i.setVisibility(8);
        } else {
            if (m.byteLength(fVar.f21545g) > 500) {
                this.w = StringHelper.cutChineseAndEnglishWithSuffix(fVar.f21545g, 500, "");
            } else {
                this.w = fVar.f21545g;
            }
            this.f44678i.setText(this.w);
            int lineCount = this.f44678i.getLineCount();
            this.v = lineCount;
            if (lineCount > 3) {
                this.f44678i.setMovementMethod(LinkMovementMethod.getInstance());
                i();
            }
            this.f44678i.setVisibility(0);
            this.f44678i.setHighlightColor(getResources().getColor(c.a.t0.q1.b.transparent));
        }
        long j2 = fVar.m;
        if (j2 > 0 && j2 <= 20) {
            this.k.setVisibility(0);
            TextView textView = this.n;
            textView.setText(fVar.f21544f.trim() + getResources().getString(h.hot_topic_cur_rank) + fVar.m);
            this.l.setOnClickListener(new c(this, fVar));
            this.f44679j.setVisibility(0);
        } else {
            this.f44679j.setVisibility(8);
            this.k.setVisibility(8);
        }
        this.p.notifyDataSetChanged();
        this.q.setVisibility(0);
    }

    public void setHeaderBottomLineShow(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) || (imageView = this.r) == null) {
            return;
        }
        imageView.setVisibility(z ? 0 : 8);
    }

    public void setOnSizeChangeListener(c.a.s0.g1.j.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, eVar) == null) {
            this.u = eVar;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        PagerSlidingTabStrip pagerSlidingTabStrip;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, viewPager) == null) || (pagerSlidingTabStrip = this.p) == null) {
            return;
        }
        pagerSlidingTabStrip.setViewPager(viewPager);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f44674e = 3;
        this.t = false;
        this.w = "";
        this.x = 0;
        this.y = 0;
        this.A = new a(this);
        this.B = new d(this);
        this.C = new e(this);
        j(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicHeaderView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f44674e = 3;
        this.t = false;
        this.w = "";
        this.x = 0;
        this.y = 0;
        this.A = new a(this);
        this.B = new d(this);
        this.C = new e(this);
        j(context);
    }
}

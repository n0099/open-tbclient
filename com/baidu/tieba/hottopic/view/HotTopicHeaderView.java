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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import d.a.d.e.p.k;
import d.a.d.e.p.l;
import d.a.q0.g1.c.f;
/* loaded from: classes4.dex */
public class HotTopicHeaderView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener A;
    public ClickableSpan B;
    public ClickableSpan C;

    /* renamed from: e  reason: collision with root package name */
    public int f17216e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f17217f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17218g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f17219h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f17220i;
    public View j;
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
    public d.a.p0.d1.j.e u;
    public int v;
    public String w;
    public int x;
    public int y;
    public f z;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicHeaderView f17221e;

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
            this.f17221e = hotTopicHeaderView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f17221e.z == null || StringUtils.isNull(this.f17221e.z.r)) {
                return;
            }
            d.a.p0.m.a.l(this.f17221e.getContext(), this.f17221e.z.r);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicHeaderView f17222e;

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
            this.f17222e = hotTopicHeaderView;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                HotTopicHeaderView hotTopicHeaderView = this.f17222e;
                hotTopicHeaderView.y = hotTopicHeaderView.f17218g.getMeasuredHeight();
                this.f17222e.f17218g.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f17223e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HotTopicHeaderView f17224f;

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
            this.f17224f = hotTopicHeaderView;
            this.f17223e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(view.getContext()).createNormalConfig("hottopic", this.f17223e.n)));
                TiebaStatic.log(new StatisticItem("c10813").param("obj_name", this.f17223e.f56961f));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicHeaderView f17225e;

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
            this.f17225e = hotTopicHeaderView;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) this.f17225e.w);
                if (this.f17225e.w.length() > 500) {
                    spannableStringBuilder.append((CharSequence) "...  ");
                }
                String str = this.f17225e.getResources().getString(R.string.hot_topic_coll) + GlideException.IndentedAppendable.INDENT;
                spannableStringBuilder.append((CharSequence) str);
                SpannableString spannableString = new SpannableString(spannableStringBuilder);
                spannableString.setSpan(this.f17225e.C, spannableString.length() - str.length(), spannableString.length(), 33);
                this.f17225e.f17220i.setText(spannableString);
                this.f17225e.f17220i.setHeight(this.f17225e.v * this.f17225e.f17220i.getLineHeight());
                int lineCount = this.f17225e.f17220i.getLineCount() * this.f17225e.f17220i.getLineHeight();
                if (lineCount > this.f17225e.v * this.f17225e.f17220i.getLineHeight()) {
                    this.f17225e.f17220i.scrollTo(0, lineCount - (this.f17225e.v * this.f17225e.f17220i.getLineHeight()));
                }
                this.f17225e.f17220i.requestLayout();
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                textPaint.setColor(this.f17225e.getResources().getColor(R.color.CAM_X0304));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicHeaderView f17226e;

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
            this.f17226e = hotTopicHeaderView;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f17226e.f17220i.setText(this.f17226e.w);
                this.f17226e.j();
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                textPaint.setColor(this.f17226e.getResources().getColor(R.color.CAM_X0304));
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
        this.f17216e = 3;
        this.t = false;
        this.w = "";
        this.x = 0;
        this.y = 0;
        this.A = new a(this);
        this.B = new d(this);
        this.C = new e(this);
        k(context);
    }

    public int getNavigationBarSwitchHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            f fVar = this.z;
            boolean z = (fVar == null || StringUtils.isNull(fVar.f56964i)) ? false : true;
            int i2 = this.y;
            View view = this.s;
            if (view != null) {
                i2 += view.getMeasuredHeight();
            }
            return z ? this.y + this.x : i2;
        }
        return invokeV.intValue;
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            ((LinearLayout.LayoutParams) this.s.getLayoutParams()).height = i2;
            this.s.postInvalidate();
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) this.w);
            String string = getResources().getString(R.string.hot_topic_detail);
            SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) spannableStringBuilder.subSequence(0, (this.f17220i.getLayout().getLineEnd(2) - string.length()) - 2);
            spannableStringBuilder2.append((CharSequence) "...  ");
            int length = spannableStringBuilder2.length();
            spannableStringBuilder2.append((CharSequence) string);
            SpannableString spannableString = new SpannableString(spannableStringBuilder2);
            spannableString.setSpan(this.B, length - 1, spannableString.length(), 33);
            this.f17220i.setText(spannableString);
            TextView textView = this.f17220i;
            textView.setHeight(textView.getLineHeight() * 3);
            this.f17220i.scrollTo(0, 0);
            this.f17220i.requestLayout();
        }
    }

    public final void k(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            this.x = l.g(context, R.dimen.tbds418);
            setOrientation(1);
            LayoutInflater.from(context).inflate(R.layout.hot_topic_topicinfo_item, (ViewGroup) this, true);
            this.s = findViewById(R.id.hot_topic_info_place_holder);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.hot_topic_info_picture);
            this.f17217f = tbImageView;
            tbImageView.setOnClickListener(this.A);
            this.f17218g = (TextView) findViewById(R.id.hot_topic_info_title);
            this.f17219h = (TextView) findViewById(R.id.hot_topic_info_threadcount);
            this.f17220i = (TextView) findViewById(R.id.hot_topic_info_abstract);
            View findViewById = findViewById(R.id.divider_line);
            this.j = findViewById;
            findViewById.setVisibility(8);
            this.k = (LinearLayout) findViewById(R.id.hot_topic_ranking_item);
            this.l = (LinearLayout) findViewById(R.id.hot_topic_ranking_content);
            this.n = (TextView) findViewById(R.id.hot_topic_ranklist_title);
            this.m = (ImageView) findViewById(R.id.ranklist_pic_r);
            this.o = (TextView) findViewById(R.id.hot_topic_look_ranklist);
            PagerSlidingTabStrip pagerSlidingTabStrip = (PagerSlidingTabStrip) findViewById(R.id.hot_topic_tab_strip);
            this.p = pagerSlidingTabStrip;
            pagerSlidingTabStrip.k(l.g(context, R.dimen.ds32), l.g(context, R.dimen.ds1), l.g(context, R.dimen.ds4), true);
            View findViewById2 = findViewById(R.id.tab_divider_line);
            this.q = findViewById2;
            findViewById2.setVisibility(8);
            this.r = (ImageView) findViewById(R.id.hot_topic_tab_strip_bottomline);
            m();
        }
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.t : invokeV.booleanValue;
    }

    public void m() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.f17216e) {
            return;
        }
        this.f17216e = skinType;
        SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.p, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.f17218g, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.f17219h, R.color.CAM_X0301, 1);
        SkinManager.setViewTextColor(this.f17220i, R.color.CAM_X0108, 1);
        SkinManager.setBackgroundColor(this.j, R.color.CAM_X0205);
        SkinManager.setBackgroundColor(this.q, R.color.CAM_X0205);
        SkinManager.setViewTextColor(this.n, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0107, 1);
        SkinManager.setBackgroundResource(this.m, R.drawable.icon_arrow_more_gray);
        SkinManager.setBackgroundResource(this.l, R.drawable.hot_topic_ranklist_bg);
        SkinManager.setBackgroundColor(this.r, R.color.CAM_X0204);
        this.p.m();
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048582, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            d.a.p0.d1.j.e eVar = this.u;
            if (eVar != null) {
                eVar.a(this, i2, i3, i4, i5);
            }
        }
    }

    public void setData(f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, fVar) == null) || fVar == null || StringUtils.isNull(fVar.f56961f)) {
            return;
        }
        this.z = fVar;
        this.t = true;
        this.f17217f.setDefaultBgResource(R.color.CAM_X0205);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f17217f.getLayoutParams();
        layoutParams.height = this.x;
        this.f17217f.setLayoutParams(layoutParams);
        if (!StringUtils.isNull(fVar.f56964i) && StringUtils.isNull(fVar.m)) {
            this.f17217f.M(fVar.f56964i, 10, false);
            this.s.setVisibility(8);
        } else {
            this.f17217f.setVisibility(8);
            this.s.setVisibility(0);
        }
        this.f17218g.setSingleLine();
        String trim = fVar.f56961f.trim();
        fVar.f56961f = trim;
        if (!StringUtils.isNull(trim)) {
            this.f17218g.setText(d.a.q0.g1.e.a.a(fVar.f56961f, 10));
        } else {
            this.f17218g.setText("");
        }
        this.f17218g.getViewTreeObserver().addOnGlobalLayoutListener(new b(this));
        this.f17219h.setText(TbadkCoreApplication.getInst().getString(R.string.hot_topic_info_threadCount).replace("%s", StringHelper.longNumFormatOver9999wan(fVar.f56963h)));
        if (StringUtils.isNull(fVar.f56962g)) {
            this.f17220i.setVisibility(8);
        } else {
            if (k.byteLength(fVar.f56962g) > 500) {
                this.w = StringHelper.cutChineseAndEnglishWithSuffix(fVar.f56962g, 500, "");
            } else {
                this.w = fVar.f56962g;
            }
            this.f17220i.setText(this.w);
            int lineCount = this.f17220i.getLineCount();
            this.v = lineCount;
            if (lineCount > 3) {
                this.f17220i.setMovementMethod(LinkMovementMethod.getInstance());
                j();
            }
            this.f17220i.setVisibility(0);
            this.f17220i.setHighlightColor(getResources().getColor(R.color.transparent));
        }
        long j = fVar.l;
        if (j > 0 && j <= 20) {
            this.k.setVisibility(0);
            TextView textView = this.n;
            textView.setText(fVar.f56961f.trim() + getResources().getString(R.string.hot_topic_cur_rank) + fVar.l);
            this.l.setOnClickListener(new c(this, fVar));
            this.j.setVisibility(0);
        } else {
            this.j.setVisibility(8);
            this.k.setVisibility(8);
        }
        this.p.l();
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

    public void setOnSizeChangeListener(d.a.p0.d1.j.e eVar) {
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
        this.f17216e = 3;
        this.t = false;
        this.w = "";
        this.x = 0;
        this.y = 0;
        this.A = new a(this);
        this.B = new d(this);
        this.C = new e(this);
        k(context);
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
        this.f17216e = 3;
        this.t = false;
        this.w = "";
        this.x = 0;
        this.y = 0;
        this.A = new a(this);
        this.B = new d(this);
        this.C = new e(this);
        k(context);
    }
}

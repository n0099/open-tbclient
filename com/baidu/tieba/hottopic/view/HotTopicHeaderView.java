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
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.p0.h1.c.f;
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
import org.apache.commons.lang3.text.FormattableUtils;
/* loaded from: classes7.dex */
public class HotTopicHeaderView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener A;
    public ClickableSpan B;
    public ClickableSpan C;

    /* renamed from: e  reason: collision with root package name */
    public int f52408e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f52409f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f52410g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f52411h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f52412i;

    /* renamed from: j  reason: collision with root package name */
    public View f52413j;
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
    public c.a.o0.d1.j.e u;
    public int v;
    public String w;
    public int x;
    public int y;
    public f z;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicHeaderView f52414e;

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
            this.f52414e = hotTopicHeaderView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f52414e.z == null || StringUtils.isNull(this.f52414e.z.r)) {
                return;
            }
            c.a.o0.m.a.l(this.f52414e.getContext(), this.f52414e.z.r);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicHeaderView f52415e;

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
            this.f52415e = hotTopicHeaderView;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                HotTopicHeaderView hotTopicHeaderView = this.f52415e;
                hotTopicHeaderView.y = hotTopicHeaderView.f52410g.getMeasuredHeight();
                this.f52415e.f52410g.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f52416e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HotTopicHeaderView f52417f;

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
            this.f52417f = hotTopicHeaderView;
            this.f52416e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(view.getContext()).createNormalConfig("hottopic", this.f52416e.n)));
                TiebaStatic.log(new StatisticItem("c10813").param("obj_name", this.f52416e.f18291f));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicHeaderView f52418e;

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
            this.f52418e = hotTopicHeaderView;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) this.f52418e.w);
                if (this.f52418e.w.length() > 500) {
                    spannableStringBuilder.append((CharSequence) "...  ");
                }
                String str = this.f52418e.getResources().getString(R.string.hot_topic_coll) + GlideException.IndentedAppendable.INDENT;
                spannableStringBuilder.append((CharSequence) str);
                SpannableString spannableString = new SpannableString(spannableStringBuilder);
                spannableString.setSpan(this.f52418e.C, spannableString.length() - str.length(), spannableString.length(), 33);
                this.f52418e.f52412i.setText(spannableString);
                this.f52418e.f52412i.setHeight(this.f52418e.v * this.f52418e.f52412i.getLineHeight());
                int lineCount = this.f52418e.f52412i.getLineCount() * this.f52418e.f52412i.getLineHeight();
                if (lineCount > this.f52418e.v * this.f52418e.f52412i.getLineHeight()) {
                    this.f52418e.f52412i.scrollTo(0, lineCount - (this.f52418e.v * this.f52418e.f52412i.getLineHeight()));
                }
                this.f52418e.f52412i.requestLayout();
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                textPaint.setColor(this.f52418e.getResources().getColor(R.color.CAM_X0304));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicHeaderView f52419e;

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
            this.f52419e = hotTopicHeaderView;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f52419e.f52412i.setText(this.f52419e.w);
                this.f52419e.i();
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                textPaint.setColor(this.f52419e.getResources().getColor(R.color.CAM_X0304));
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
        this.f52408e = 3;
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
            boolean z = (fVar == null || StringUtils.isNull(fVar.f18294i)) ? false : true;
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
            String string = getResources().getString(R.string.hot_topic_detail);
            SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) spannableStringBuilder.subSequence(0, (this.f52412i.getLayout().getLineEnd(2) - string.length()) - 2);
            spannableStringBuilder2.append((CharSequence) "...  ");
            int length = spannableStringBuilder2.length();
            spannableStringBuilder2.append((CharSequence) string);
            SpannableString spannableString = new SpannableString(spannableStringBuilder2);
            spannableString.setSpan(this.B, length - 1, spannableString.length(), 33);
            this.f52412i.setText(spannableString);
            TextView textView = this.f52412i;
            textView.setHeight(textView.getLineHeight() * 3);
            this.f52412i.scrollTo(0, 0);
            this.f52412i.requestLayout();
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
            this.x = l.g(context, R.dimen.tbds418);
            setOrientation(1);
            LayoutInflater.from(context).inflate(R.layout.hot_topic_topicinfo_item, (ViewGroup) this, true);
            this.s = findViewById(R.id.hot_topic_info_place_holder);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.hot_topic_info_picture);
            this.f52409f = tbImageView;
            tbImageView.setOnClickListener(this.A);
            this.f52410g = (TextView) findViewById(R.id.hot_topic_info_title);
            this.f52411h = (TextView) findViewById(R.id.hot_topic_info_threadcount);
            this.f52412i = (TextView) findViewById(R.id.hot_topic_info_abstract);
            View findViewById = findViewById(R.id.divider_line);
            this.f52413j = findViewById;
            findViewById.setVisibility(8);
            this.k = (LinearLayout) findViewById(R.id.hot_topic_ranking_item);
            this.l = (LinearLayout) findViewById(R.id.hot_topic_ranking_content);
            this.n = (TextView) findViewById(R.id.hot_topic_ranklist_title);
            this.m = (ImageView) findViewById(R.id.ranklist_pic_r);
            this.o = (TextView) findViewById(R.id.hot_topic_look_ranklist);
            PagerSlidingTabStrip pagerSlidingTabStrip = (PagerSlidingTabStrip) findViewById(R.id.hot_topic_tab_strip);
            this.p = pagerSlidingTabStrip;
            pagerSlidingTabStrip.init(l.g(context, R.dimen.ds32), l.g(context, R.dimen.ds1), l.g(context, R.dimen.ds4), true);
            View findViewById2 = findViewById(R.id.tab_divider_line);
            this.q = findViewById2;
            findViewById2.setVisibility(8);
            this.r = (ImageView) findViewById(R.id.hot_topic_tab_strip_bottomline);
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.f52408e) {
            return;
        }
        this.f52408e = skinType;
        SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.p, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.f52410g, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.f52411h, R.color.CAM_X0301, 1);
        SkinManager.setViewTextColor(this.f52412i, R.color.CAM_X0108, 1);
        SkinManager.setBackgroundColor(this.f52413j, R.color.CAM_X0205);
        SkinManager.setBackgroundColor(this.q, R.color.CAM_X0205);
        SkinManager.setViewTextColor(this.n, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0107, 1);
        SkinManager.setBackgroundResource(this.m, R.drawable.icon_arrow_more_gray);
        SkinManager.setBackgroundResource(this.l, R.drawable.hot_topic_ranklist_bg);
        SkinManager.setBackgroundColor(this.r, R.color.CAM_X0204);
        this.p.onChangeSkinType();
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048582, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            c.a.o0.d1.j.e eVar = this.u;
            if (eVar != null) {
                eVar.a(this, i2, i3, i4, i5);
            }
        }
    }

    public void setData(f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, fVar) == null) || fVar == null || StringUtils.isNull(fVar.f18291f)) {
            return;
        }
        this.z = fVar;
        this.t = true;
        this.f52409f.setDefaultBgResource(R.color.CAM_X0205);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f52409f.getLayoutParams();
        layoutParams.height = this.x;
        this.f52409f.setLayoutParams(layoutParams);
        if (!StringUtils.isNull(fVar.f18294i) && StringUtils.isNull(fVar.m)) {
            this.f52409f.startLoad(fVar.f18294i, 10, false);
            this.s.setVisibility(8);
        } else {
            this.f52409f.setVisibility(8);
            this.s.setVisibility(0);
        }
        this.f52410g.setSingleLine();
        String trim = fVar.f18291f.trim();
        fVar.f18291f = trim;
        if (!StringUtils.isNull(trim)) {
            this.f52410g.setText(c.a.p0.h1.e.a.a(fVar.f18291f, 10));
        } else {
            this.f52410g.setText("");
        }
        this.f52410g.getViewTreeObserver().addOnGlobalLayoutListener(new b(this));
        this.f52411h.setText(TbadkCoreApplication.getInst().getString(R.string.hot_topic_info_threadCount).replace(FormattableUtils.SIMPLEST_FORMAT, StringHelper.longNumFormatOver9999wan(fVar.f18293h)));
        if (StringUtils.isNull(fVar.f18292g)) {
            this.f52412i.setVisibility(8);
        } else {
            if (k.byteLength(fVar.f18292g) > 500) {
                this.w = StringHelper.cutChineseAndEnglishWithSuffix(fVar.f18292g, 500, "");
            } else {
                this.w = fVar.f18292g;
            }
            this.f52412i.setText(this.w);
            int lineCount = this.f52412i.getLineCount();
            this.v = lineCount;
            if (lineCount > 3) {
                this.f52412i.setMovementMethod(LinkMovementMethod.getInstance());
                i();
            }
            this.f52412i.setVisibility(0);
            this.f52412i.setHighlightColor(getResources().getColor(R.color.transparent));
        }
        long j2 = fVar.l;
        if (j2 > 0 && j2 <= 20) {
            this.k.setVisibility(0);
            TextView textView = this.n;
            textView.setText(fVar.f18291f.trim() + getResources().getString(R.string.hot_topic_cur_rank) + fVar.l);
            this.l.setOnClickListener(new c(this, fVar));
            this.f52413j.setVisibility(0);
        } else {
            this.f52413j.setVisibility(8);
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

    public void setOnSizeChangeListener(c.a.o0.d1.j.e eVar) {
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
        this.f52408e = 3;
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
        this.f52408e = 3;
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

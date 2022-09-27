package com.baidu.tieba.homepage.hotTopic.tab;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.a07;
import com.baidu.tieba.ej;
import com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabNewRankListLayout;
import com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout;
import com.baidu.tieba.hv4;
import com.baidu.tieba.hz6;
import com.baidu.tieba.qp4;
import com.baidu.tieba.x16;
import com.baidu.tieba.xz6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.tabs.TabLayout;
import tbclient.HotThreadList.DataRes;
import tbclient.HotThreadList.HotThreadListResIdl;
import tbclient.HotThreadList.InnerTabInfo;
/* loaded from: classes4.dex */
public class HotTopicHeaderView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public LinearLayout b;
    public HotTopicTabRankListLayout c;
    public TextView d;
    @Nullable
    public LinearLayout e;
    @Nullable
    public HotTopicTabNewRankListLayout f;
    public TextView g;
    public EMTextView h;
    public EMTextView i;
    @Nullable
    public a07 j;
    public x16 k;
    public qp4 l;
    public LinearLayout m;
    public TbPageContext<?> n;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicHeaderView a;

        public a(HotTopicHeaderView hotTopicHeaderView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicHeaderView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotTopicHeaderView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                new HotRanklistActivityConfig(view2.getContext()).createNormalConfig("hotforum", "all").start();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ InnerTabInfo a;
        public final /* synthetic */ HotTopicHeaderView b;

        public b(HotTopicHeaderView hotTopicHeaderView, InnerTabInfo innerTabInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicHeaderView, innerTabInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hotTopicHeaderView;
            this.a = innerTabInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.e(this.a);
                Object tag = view2.getTag(R.id.obfuscated_res_0x7f090df3);
                if (tag instanceof Integer) {
                    this.b.h(((Integer) tag).intValue());
                }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3;
        g();
    }

    public final View c(@NonNull InnerTabInfo innerTabInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, innerTabInfo)) == null) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            relativeLayout.setGravity(17);
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(0);
            linearLayout.setGravity(17);
            relativeLayout.addView(linearLayout, new ViewGroup.LayoutParams(-2, -2));
            TbClipImageView tbClipImageView = new TbClipImageView(getContext());
            tbClipImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            tbClipImageView.setDrawCorner(true);
            tbClipImageView.setRadius(ej.f(getContext(), R.dimen.tbds83));
            tbClipImageView.setConrers(15);
            tbClipImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            tbClipImageView.setPlaceHolder(1);
            if (!StringUtils.isNull(innerTabInfo.icon)) {
                tbClipImageView.L(innerTabInfo.icon, 10, false, false);
            }
            linearLayout.addView(tbClipImageView, new ViewGroup.LayoutParams(ej.f(getContext(), R.dimen.tbds83), ej.f(getContext(), R.dimen.tbds83)));
            TextView textView = new TextView(getContext());
            hv4 d = hv4.d(textView);
            d.v(R.color.CAM_X0105);
            d.z(R.dimen.T_X06);
            d.A(R.string.F_X01);
            textView.setId(R.id.obfuscated_res_0x7f0922d9);
            textView.setPadding(ej.f(getContext(), R.dimen.M_W_X002), 0, 0, 0);
            textView.setText(innerTabInfo.name);
            linearLayout.addView(textView);
            relativeLayout.setOnClickListener(new b(this, innerTabInfo));
            return relativeLayout;
        }
        return (View) invokeL.objValue;
    }

    public final String d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? TbadkCoreApplication.getInst().getString(i) : (String) invokeI.objValue;
    }

    public final void e(@NonNull InnerTabInfo innerTabInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, innerTabInfo) == null) || this.n == null || TextUtils.isEmpty(innerTabInfo.jump_scheme)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(this.n, new String[]{innerTabInfo.jump_scheme});
    }

    public final void f(@Nullable HotThreadListResIdl hotThreadListResIdl) {
        LinearLayout linearLayout;
        DataRes dataRes;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, hotThreadListResIdl) == null) || (linearLayout = this.e) == null) {
            return;
        }
        linearLayout.removeAllViews();
        if (hotThreadListResIdl == null || (dataRes = hotThreadListResIdl.data) == null || ListUtils.isEmpty(dataRes.inner_tabs)) {
            return;
        }
        int size = hotThreadListResIdl.data.inner_tabs.size();
        if (size > 3) {
            size = 3;
        }
        int i = 0;
        while (i < size) {
            View c = c(hotThreadListResIdl.data.inner_tabs.get(i));
            i++;
            c.setTag(R.id.obfuscated_res_0x7f090df3, Integer.valueOf(i));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, ej.f(getContext(), R.dimen.tbds125));
            layoutParams.weight = 1.0f;
            this.e.addView(c, layoutParams);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            setOrientation(1);
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.b = linearLayout;
            linearLayout.setOrientation(1);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X003);
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X007);
            int dimenPixelSize4 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
            int dimenPixelSize5 = UtilHelper.getDimenPixelSize(R.dimen.M_H_X005);
            int dimenPixelSize6 = UtilHelper.getDimenPixelSize(R.dimen.M_H_X004);
            if (UbsABTestHelper.isNewHomeHotTopicTab()) {
                LinearLayout linearLayout2 = new LinearLayout(getContext());
                this.e = linearLayout2;
                linearLayout2.setOrientation(0);
                this.e.setDividerDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.obfuscated_res_0x7f080fe3, getContext().getTheme()));
                this.e.setShowDividers(2);
                addView(this.e, new ViewGroup.LayoutParams(-1, -2));
            }
            TextView textView = new TextView(getContext());
            this.d = textView;
            textView.setId(R.id.obfuscated_res_0x7f09222e);
            hv4 d = hv4.d(this.d);
            d.v(R.color.CAM_X0105);
            d.z(R.dimen.T_X07);
            d.A(R.string.F_X02);
            if (!UbsABTestHelper.isNewHomeHotTopicTab()) {
                this.d.setText(d(R.string.obfuscated_res_0x7f0f08aa));
            } else {
                this.d.setText(d(R.string.obfuscated_res_0x7f0f0fd1));
            }
            this.d.setMaxLines(1);
            this.d.setEllipsize(TextUtils.TruncateAt.END);
            this.d.setPadding(dimenPixelSize4, dimenPixelSize5, dimenPixelSize4, dimenPixelSize6);
            this.b.addView(this.d, new LinearLayout.LayoutParams(-1, -2));
            if (!UbsABTestHelper.isNewHomeHotTopicTab()) {
                HotTopicTabRankListLayout hotTopicTabRankListLayout = new HotTopicTabRankListLayout(getContext());
                this.c = hotTopicTabRankListLayout;
                this.b.addView(hotTopicTabRankListLayout, new LinearLayout.LayoutParams(-1, -2));
            } else {
                HotTopicTabNewRankListLayout hotTopicTabNewRankListLayout = new HotTopicTabNewRankListLayout(getContext());
                this.f = hotTopicTabNewRankListLayout;
                this.b.addView(hotTopicTabNewRankListLayout, new LinearLayout.LayoutParams(-1, -2));
                RelativeLayout relativeLayout = new RelativeLayout(getContext());
                relativeLayout.setGravity(17);
                this.b.addView(relativeLayout, new LinearLayout.LayoutParams(-1, -2));
                TextView textView2 = new TextView(getContext());
                this.g = textView2;
                textView2.setText(R.string.obfuscated_res_0x7f0f08a6);
                this.g.setPadding(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003), 0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
                relativeLayout.addView(this.g);
                relativeLayout.setOnClickListener(new a(this));
            }
            hv4 d2 = hv4.d(this.b);
            d2.n(R.string.J_X06);
            d2.f(R.color.CAM_X0205);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
            this.b.setPadding(0, 0, 0, dimenPixelSize6);
            addView(this.b, layoutParams);
            if (!UbsABTestHelper.isNewHomeHotTopicTab()) {
                x16 x16Var = new x16(getContext());
                this.k = x16Var;
                x16Var.setFrom("from_hottop");
                this.k.f("2");
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams2.topMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds5);
                addView(this.k.b(), layoutParams2);
            }
            LinearLayout linearLayout3 = new LinearLayout(getContext());
            this.m = linearLayout3;
            linearLayout3.setOrientation(0);
            EMTextView eMTextView = new EMTextView(getContext());
            hv4 d3 = hv4.d(eMTextView);
            d3.z(R.dimen.T_X07);
            d3.v(R.color.CAM_X0105);
            d3.A(R.string.F_X02);
            if (UbsABTestHelper.isNewHomeHotTopicTab()) {
                eMTextView.setText(d(R.string.obfuscated_res_0x7f0f089d));
            } else {
                eMTextView.setText(d(R.string.obfuscated_res_0x7f0f0898));
            }
            eMTextView.setMaxLines(1);
            eMTextView.setEllipsize(TextUtils.TruncateAt.END);
            eMTextView.setPadding(dimenPixelSize3 - dimenPixelSize2, 0, dimenPixelSize, 0);
            this.m.addView(eMTextView);
            this.h = eMTextView;
            EMTextView eMTextView2 = new EMTextView(getContext());
            hv4 d4 = hv4.d(eMTextView2);
            d4.z(R.dimen.T_X09);
            d4.v(R.color.CAM_X0109);
            d4.A(R.string.F_X01);
            eMTextView2.setText(d(R.string.obfuscated_res_0x7f0f0897));
            eMTextView2.setMaxLines(1);
            eMTextView2.setEllipsize(TextUtils.TruncateAt.END);
            eMTextView2.setPadding(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X006) - dimenPixelSize5, 0, 0);
            if (!UbsABTestHelper.isNewHomeHotTopicTab()) {
                this.m.addView(eMTextView2);
            }
            this.i = eMTextView2;
            this.m.setPadding(0, dimenPixelSize5, 0, dimenPixelSize6);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams3.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
            addView(this.m, layoutParams3);
            if (UbsABTestHelper.isNewHomeHotTopicTab()) {
                return;
            }
            a07 a07Var = new a07(getContext());
            this.j = a07Var;
            addView(a07Var.a());
            LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.j.a().getLayoutParams();
            layoutParams4.weight = -1.0f;
            layoutParams4.height = UtilHelper.getDimenPixelSize(R.dimen.tbds106);
            this.j.a().requestLayout();
        }
    }

    public final void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_HOT_TOPIC_BANNER_CLICK);
            statisticItem.addParam("obj_locate", i);
            TiebaStatic.log(statisticItem);
        }
    }

    public void i(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i) == null) || this.a == i) {
            return;
        }
        this.a = i;
        SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0109);
        hv4 d = hv4.d(this.b);
        d.n(R.string.J_X06);
        d.f(R.color.CAM_X0205);
        if (UbsABTestHelper.isNewHomeHotTopicTab()) {
            this.d.setBackgroundResource(R.drawable.obfuscated_res_0x7f0805da);
        } else {
            this.d.setBackground(null);
        }
        HotTopicTabRankListLayout hotTopicTabRankListLayout = this.c;
        if (hotTopicTabRankListLayout != null) {
            hotTopicTabRankListLayout.d(i);
        }
        HotTopicTabNewRankListLayout hotTopicTabNewRankListLayout = this.f;
        if (hotTopicTabNewRankListLayout != null) {
            hotTopicTabNewRankListLayout.d(i);
        }
        a07 a07Var = this.j;
        if (a07Var != null) {
            a07Var.c(i);
        }
        x16 x16Var = this.k;
        if (x16Var != null) {
            x16Var.e(i);
        }
        TextView textView = this.g;
        if (textView != null) {
            hv4 d2 = hv4.d(textView);
            d2.A(R.string.F_X01);
            d2.z(R.dimen.T_X06);
            d2.v(R.color.CAM_X0304);
            Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.icon_common_arrow16_right_n, SkinManager.getColor(R.color.CAM_X0304), WebPManager.ResourceStateType.NORMAL);
            pureDrawable.setBounds(0, ej.f(getContext(), R.dimen.tbds3), ej.f(getContext(), R.dimen.tbds13), ej.f(getContext(), R.dimen.tbds26) + ej.f(getContext(), R.dimen.tbds3));
            this.g.setCompoundDrawables(null, null, pureDrawable, null);
            this.g.setCompoundDrawablePadding(ej.f(getContext(), R.dimen.tbds7));
        }
        if (this.e != null) {
            for (int i2 = 0; i2 < this.e.getChildCount(); i2++) {
                hv4 d3 = hv4.d((TextView) ((ViewGroup) this.e.getChildAt(i2)).findViewById(R.id.obfuscated_res_0x7f0922d9));
                d3.v(R.color.CAM_X0105);
                d3.z(R.dimen.T_X06);
                d3.A(R.string.F_X01);
            }
        }
    }

    public void setData(HotThreadListResIdl hotThreadListResIdl) {
        DataRes dataRes;
        DataRes dataRes2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, hotThreadListResIdl) == null) {
            f(hotThreadListResIdl);
            if (hotThreadListResIdl != null && (dataRes2 = hotThreadListResIdl.data) != null && !ListUtils.isEmpty(dataRes2.topic_list)) {
                this.d.setVisibility(0);
                HotTopicTabRankListLayout hotTopicTabRankListLayout = this.c;
                if (hotTopicTabRankListLayout != null) {
                    hotTopicTabRankListLayout.setVisibility(0);
                    this.c.setOnItemCoverListener(this.l);
                    this.c.b(new xz6(hotThreadListResIdl.data.topic_list));
                }
                HotTopicTabNewRankListLayout hotTopicTabNewRankListLayout = this.f;
                if (hotTopicTabNewRankListLayout != null) {
                    hotTopicTabNewRankListLayout.setVisibility(0);
                    this.f.setOnItemCoverListener(this.l);
                    this.f.b(new xz6(hotThreadListResIdl.data.topic_list));
                }
            } else {
                this.d.setVisibility(8);
                HotTopicTabRankListLayout hotTopicTabRankListLayout2 = this.c;
                if (hotTopicTabRankListLayout2 != null) {
                    hotTopicTabRankListLayout2.setVisibility(8);
                }
                HotTopicTabNewRankListLayout hotTopicTabNewRankListLayout2 = this.f;
                if (hotTopicTabNewRankListLayout2 != null) {
                    hotTopicTabNewRankListLayout2.setVisibility(8);
                }
            }
            x16 x16Var = this.k;
            if (x16Var != null) {
                x16Var.b().setVisibility(0);
            }
            this.h.setVisibility(0);
            this.i.setVisibility(0);
            if (this.j != null) {
                this.j.e(hz6.d((hotThreadListResIdl == null || (dataRes = hotThreadListResIdl.data) == null) ? null : dataRes.hot_thread_tab_info).a());
            }
            i(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void setOnItemCoverListener(qp4 qp4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, qp4Var) == null) {
            this.l = qp4Var;
        }
    }

    public void setOnTabSelectedListener(TabLayout.OnTabSelectedListener onTabSelectedListener) {
        a07 a07Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, onTabSelectedListener) == null) || (a07Var = this.j) == null) {
            return;
        }
        a07Var.d(onTabSelectedListener);
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, tbPageContext) == null) {
            this.n = tbPageContext;
            HotTopicTabRankListLayout hotTopicTabRankListLayout = this.c;
            if (hotTopicTabRankListLayout != null) {
                hotTopicTabRankListLayout.setPageContext(tbPageContext);
            }
            HotTopicTabNewRankListLayout hotTopicTabNewRankListLayout = this.f;
            if (hotTopicTabNewRankListLayout != null) {
                hotTopicTabNewRankListLayout.setTbPageContext(this.n);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicHeaderView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 3;
        g();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicHeaderView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = 3;
        g();
    }
}

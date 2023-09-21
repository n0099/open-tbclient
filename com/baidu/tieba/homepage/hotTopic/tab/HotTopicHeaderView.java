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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
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
import com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabNewRankListLayout;
import com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout;
import com.baidu.tieba.l48;
import com.baidu.tieba.t38;
import com.baidu.tieba.util.TopicListUtil;
import com.baidu.tieba.wz4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.HotThreadList.DataRes;
import tbclient.HotThreadList.HotThreadListResIdl;
import tbclient.HotThreadList.InnerTabInfo;
/* loaded from: classes6.dex */
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
    public wz4 j;
    public LinearLayout k;
    public TbPageContext<?> l;
    public String m;

    /* loaded from: classes6.dex */
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
                TopicListUtil.openWebTopicListPage();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ InnerTabInfo a;
        public final /* synthetic */ View b;
        public final /* synthetic */ HotTopicHeaderView c;

        public b(HotTopicHeaderView hotTopicHeaderView, InnerTabInfo innerTabInfo, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicHeaderView, innerTabInfo, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = hotTopicHeaderView;
            this.a = innerTabInfo;
            this.b = view2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.c.h(this.a);
            Object tag = view2.getTag(R.id.obfuscated_res_0x7f090fc1);
            if (!(tag instanceof Integer)) {
                return;
            }
            this.c.k(((Integer) tag).intValue());
            View view3 = this.b;
            if (view3 == null || view3.getTag(R.id.obfuscated_res_0x7f090fc1) != tag) {
                return;
            }
            this.c.m(this.a.name);
            SharedPrefHelper.getInstance().putLong(this.c.m, this.a.notify_version.intValue());
            this.b.setVisibility(8);
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
        j();
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
        j();
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
        j();
    }

    public final String g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            return TbadkCoreApplication.getInst().getString(i);
        }
        return (String) invokeI.objValue;
    }

    public final void h(@NonNull InnerTabInfo innerTabInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, innerTabInfo) == null) && this.l != null && !TextUtils.isEmpty(innerTabInfo.jump_scheme)) {
            UrlManager.getInstance().dealOneLink(this.l, new String[]{innerTabInfo.jump_scheme});
        }
    }

    public final void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_HOT_TOPIC_BANNER_CLICK);
            statisticItem.addParam("obj_locate", i);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.m = "key_god_tie_and_hot_bar_update_time" + TbadkCoreApplication.getCurrentAccount() + str;
        }
    }

    public void setOnItemCoverListener(wz4 wz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, wz4Var) == null) {
            this.j = wz4Var;
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, tbPageContext) == null) {
            this.l = tbPageContext;
            HotTopicTabRankListLayout hotTopicTabRankListLayout = this.c;
            if (hotTopicTabRankListLayout != null) {
                hotTopicTabRankListLayout.setPageContext(tbPageContext);
            }
            HotTopicTabNewRankListLayout hotTopicTabNewRankListLayout = this.f;
            if (hotTopicTabNewRankListLayout != null) {
                hotTopicTabNewRankListLayout.setTbPageContext(this.l);
            }
        }
    }

    public View e(ViewGroup viewGroup, View view2, int i, long j, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{viewGroup, view2, Integer.valueOf(i), Long.valueOf(j), str})) == null) {
            if ((!"镇吧神贴".equals(str) && !"精选热吧".equals(str)) || !t38.a(j, this.m)) {
                return null;
            }
            View view3 = new View(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(BdUtilHelper.getDimens(getContext(), R.dimen.tbds18), BdUtilHelper.getDimens(getContext(), R.dimen.tbds18));
            layoutParams.topMargin = BdUtilHelper.getDimens(getContext(), R.dimen.tbds40);
            layoutParams.addRule(1, view2.getId());
            view3.setLayoutParams(layoutParams);
            SkinManager.setBackgroundResource(view3, R.drawable.icon_news_red_dot);
            view3.setTag(R.id.obfuscated_res_0x7f090fc1, Integer.valueOf(i + 1));
            viewGroup.addView(view3, layoutParams);
            return view3;
        }
        return (View) invokeCommon.objValue;
    }

    public final View f(@NonNull InnerTabInfo innerTabInfo, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, innerTabInfo, i)) == null) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(0);
            linearLayout.setId(R.id.obfuscated_res_0x7f09266a);
            linearLayout.setGravity(17);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            relativeLayout.addView(linearLayout, layoutParams);
            TbClipImageView tbClipImageView = new TbClipImageView(getContext());
            tbClipImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            tbClipImageView.setDrawCorner(true);
            tbClipImageView.setRadius(BdUtilHelper.getDimens(getContext(), R.dimen.tbds83));
            tbClipImageView.setConrers(15);
            tbClipImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            tbClipImageView.setPlaceHolder(1);
            if (!StringUtils.isNull(innerTabInfo.icon)) {
                tbClipImageView.startLoad(innerTabInfo.icon, 10, false, false);
            }
            linearLayout.addView(tbClipImageView, new ViewGroup.LayoutParams(BdUtilHelper.getDimens(getContext(), R.dimen.tbds83), BdUtilHelper.getDimens(getContext(), R.dimen.tbds83)));
            TextView textView = new TextView(getContext());
            EMManager.from(textView).setTextColor(R.color.CAM_X0105).setTextSize(R.dimen.T_X06).setTextStyle(R.string.F_X01);
            textView.setId(R.id.obfuscated_res_0x7f09266b);
            textView.setPadding(BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X002), 0, 0, 0);
            textView.setText(innerTabInfo.name);
            linearLayout.addView(textView);
            m(innerTabInfo.name);
            relativeLayout.setOnClickListener(new b(this, innerTabInfo, e(relativeLayout, linearLayout, i, innerTabInfo.notify_version.intValue(), innerTabInfo.name)));
            return relativeLayout;
        }
        return (View) invokeLI.objValue;
    }

    public final void i(@Nullable HotThreadListResIdl hotThreadListResIdl) {
        LinearLayout linearLayout;
        DataRes dataRes;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, hotThreadListResIdl) == null) && (linearLayout = this.e) != null) {
            linearLayout.removeAllViews();
            if (hotThreadListResIdl != null && (dataRes = hotThreadListResIdl.data) != null && !ListUtils.isEmpty(dataRes.inner_tabs)) {
                int size = hotThreadListResIdl.data.inner_tabs.size();
                if (size > 3) {
                    size = 3;
                }
                int i = 0;
                while (i < size) {
                    View f = f(hotThreadListResIdl.data.inner_tabs.get(i), i);
                    i++;
                    f.setTag(R.id.obfuscated_res_0x7f090fc1, Integer.valueOf(i));
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, BdUtilHelper.getDimens(getContext(), R.dimen.tbds125));
                    layoutParams.weight = 1.0f;
                    this.e.addView(f, layoutParams);
                }
            }
        }
    }

    public void setData(HotThreadListResIdl hotThreadListResIdl) {
        DataRes dataRes;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, hotThreadListResIdl) == null) {
            i(hotThreadListResIdl);
            if (hotThreadListResIdl != null && (dataRes = hotThreadListResIdl.data) != null && !ListUtils.isEmpty(dataRes.topic_list)) {
                this.d.setVisibility(0);
                HotTopicTabRankListLayout hotTopicTabRankListLayout = this.c;
                if (hotTopicTabRankListLayout != null) {
                    hotTopicTabRankListLayout.setVisibility(0);
                    this.c.setOnItemCoverListener(this.j);
                    this.c.a(new l48(hotThreadListResIdl.data.topic_list));
                }
                HotTopicTabNewRankListLayout hotTopicTabNewRankListLayout = this.f;
                if (hotTopicTabNewRankListLayout != null) {
                    hotTopicTabNewRankListLayout.setVisibility(0);
                    this.f.setOnItemCoverListener(this.j);
                    this.f.a(new l48(hotThreadListResIdl.data.topic_list));
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
            this.h.setVisibility(0);
            this.i.setVisibility(0);
            l(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            setOrientation(1);
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.b = linearLayout;
            linearLayout.setOrientation(1);
            UtilHelper.getDimenPixelSize(R.dimen.M_W_X003);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X007);
            int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X002);
            int dimenPixelSize4 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
            int dimenPixelSize5 = UtilHelper.getDimenPixelSize(R.dimen.M_H_X005);
            int dimenPixelSize6 = UtilHelper.getDimenPixelSize(R.dimen.M_H_X004);
            LinearLayout linearLayout2 = new LinearLayout(getContext());
            this.e = linearLayout2;
            linearLayout2.setOrientation(0);
            this.e.setDividerDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.obfuscated_res_0x7f0812af, getContext().getTheme()));
            this.e.setShowDividers(2);
            addView(this.e, new ViewGroup.LayoutParams(-1, -2));
            TextView textView = new TextView(getContext());
            this.d = textView;
            textView.setId(R.id.title_id);
            EMManager.from(this.d).setTextColor(R.color.CAM_X0105).setTextSize(R.dimen.T_X07).setTextStyle(R.string.F_X02);
            this.d.setText(g(R.string.obfuscated_res_0x7f0f121d));
            this.d.setMaxLines(1);
            this.d.setEllipsize(TextUtils.TruncateAt.END);
            this.d.setPadding(dimenPixelSize4, dimenPixelSize5, dimenPixelSize4, dimenPixelSize6);
            this.b.addView(this.d, new LinearLayout.LayoutParams(-1, -2));
            HotTopicTabNewRankListLayout hotTopicTabNewRankListLayout = new HotTopicTabNewRankListLayout(getContext());
            this.f = hotTopicTabNewRankListLayout;
            this.b.addView(hotTopicTabNewRankListLayout, new LinearLayout.LayoutParams(-1, -2));
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            relativeLayout.setGravity(17);
            this.b.addView(relativeLayout, new LinearLayout.LayoutParams(-1, -2));
            TextView textView2 = new TextView(getContext());
            this.g = textView2;
            textView2.setText(R.string.obfuscated_res_0x7f0f0a26);
            this.g.setPadding(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003), 0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            relativeLayout.addView(this.g);
            relativeLayout.setOnClickListener(new a(this));
            EMManager.from(this.b).setCorner(R.string.J_X06).setBackGroundColor(R.color.CAM_X0205);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
            this.b.setPadding(0, 0, 0, dimenPixelSize6);
            addView(this.b, layoutParams);
            LinearLayout linearLayout3 = new LinearLayout(getContext());
            this.k = linearLayout3;
            linearLayout3.setOrientation(0);
            EMTextView eMTextView = new EMTextView(getContext());
            EMManager.from(eMTextView).setTextSize(R.dimen.T_X07).setTextColor(R.color.CAM_X0105).setTextStyle(R.string.F_X02);
            eMTextView.setText(g(R.string.obfuscated_res_0x7f0f0a1d));
            eMTextView.setMaxLines(1);
            eMTextView.setEllipsize(TextUtils.TruncateAt.END);
            eMTextView.setPadding(dimenPixelSize2 - dimenPixelSize, 0, dimenPixelSize3, 0);
            this.k.addView(eMTextView);
            EMTextView eMTextView2 = new EMTextView(getContext());
            EMManager.from(eMTextView2).setTextSize(R.dimen.T_X09).setTextColor(R.color.CAM_X0109).setTextStyle(R.string.F_X01);
            eMTextView2.setText(g(R.string.obfuscated_res_0x7f0f0a30));
            this.k.addView(eMTextView2);
            this.h = eMTextView;
            this.i = eMTextView2;
            this.k.setPadding(0, dimenPixelSize5, 0, dimenPixelSize6);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
            addView(this.k, layoutParams2);
        }
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048583, this, i) != null) || this.a == i) {
            return;
        }
        this.a = i;
        SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0109);
        EMManager.from(this.b).setCorner(R.string.J_X06).setBackGroundColor(R.color.CAM_X0205);
        this.d.setBackgroundResource(R.drawable.obfuscated_res_0x7f080769);
        HotTopicTabRankListLayout hotTopicTabRankListLayout = this.c;
        if (hotTopicTabRankListLayout != null) {
            hotTopicTabRankListLayout.c(i);
        }
        HotTopicTabNewRankListLayout hotTopicTabNewRankListLayout = this.f;
        if (hotTopicTabNewRankListLayout != null) {
            hotTopicTabNewRankListLayout.c(i);
        }
        TextView textView = this.g;
        if (textView != null) {
            EMManager.from(textView).setTextStyle(R.string.F_X01).setTextSize(R.dimen.T_X06).setTextColor(R.color.CAM_X0304);
            Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.icon_common_arrow16_right_n, SkinManager.getColor(R.color.CAM_X0304), WebPManager.ResourceStateType.NORMAL);
            pureDrawable.setBounds(0, BdUtilHelper.getDimens(getContext(), R.dimen.tbds3), BdUtilHelper.getDimens(getContext(), R.dimen.tbds13), BdUtilHelper.getDimens(getContext(), R.dimen.tbds26) + BdUtilHelper.getDimens(getContext(), R.dimen.tbds3));
            this.g.setCompoundDrawables(null, null, pureDrawable, null);
            this.g.setCompoundDrawablePadding(BdUtilHelper.getDimens(getContext(), R.dimen.tbds7));
        }
        if (this.e != null) {
            for (int i2 = 0; i2 < this.e.getChildCount(); i2++) {
                EMManager.from((TextView) ((ViewGroup) this.e.getChildAt(i2)).findViewById(R.id.obfuscated_res_0x7f09266b)).setTextColor(R.color.CAM_X0105).setTextSize(R.dimen.T_X06).setTextStyle(R.string.F_X01);
            }
        }
    }
}

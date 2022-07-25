package com.baidu.tieba.homepage.hotTopic.tab;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.tabs.TabLayout;
import com.repackage.cw6;
import com.repackage.km4;
import com.repackage.kv6;
import com.repackage.vr4;
import com.repackage.yx5;
import com.repackage.zv6;
import tbclient.HotThreadList.DataRes;
import tbclient.HotThreadList.HotThreadListResIdl;
/* loaded from: classes3.dex */
public class HotTopicHeaderView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public RelativeLayout b;
    public HotTopicTabRankListLayout c;
    public EMTextView d;
    public EMTextView e;
    public EMTextView f;
    public cw6 g;
    public yx5 h;
    public km4 i;
    public LinearLayout j;

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
        b();
    }

    public final String a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? TbadkCoreApplication.getInst().getString(i) : (String) invokeI.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setOrientation(1);
            this.b = new RelativeLayout(getContext());
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X003);
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X007);
            int dimenPixelSize4 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
            int dimenPixelSize5 = UtilHelper.getDimenPixelSize(R.dimen.M_H_X005);
            int dimenPixelSize6 = UtilHelper.getDimenPixelSize(R.dimen.M_H_X004);
            EMTextView eMTextView = new EMTextView(getContext());
            this.d = eMTextView;
            eMTextView.setId(R.id.obfuscated_res_0x7f0920d4);
            vr4 d = vr4.d(this.d);
            d.v(R.color.CAM_X0105);
            d.z(R.dimen.T_X07);
            d.A(R.string.F_X02);
            this.d.setText(a(R.string.obfuscated_res_0x7f0f0880));
            this.d.setMaxLines(1);
            this.d.setEllipsize(TextUtils.TruncateAt.END);
            this.d.setPadding(dimenPixelSize4, dimenPixelSize5, dimenPixelSize4, dimenPixelSize6);
            this.b.addView(this.d, new RelativeLayout.LayoutParams(-1, -2));
            this.c = new HotTopicTabRankListLayout(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(3, R.id.obfuscated_res_0x7f0920d4);
            this.b.addView(this.c, layoutParams);
            vr4 d2 = vr4.d(this.b);
            d2.n(R.string.J_X06);
            d2.f(R.color.CAM_X0205);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
            this.b.setPadding(0, 0, 0, dimenPixelSize6);
            addView(this.b, layoutParams2);
            yx5 yx5Var = new yx5(getContext());
            this.h = yx5Var;
            yx5Var.setFrom("from_hottop");
            this.h.f("2");
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams3.topMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds5);
            addView(this.h.b(), layoutParams3);
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.j = linearLayout;
            linearLayout.setOrientation(0);
            EMTextView eMTextView2 = new EMTextView(getContext());
            vr4 d3 = vr4.d(eMTextView2);
            d3.z(R.dimen.T_X07);
            d3.v(R.color.CAM_X0105);
            d3.A(R.string.F_X02);
            eMTextView2.setText(a(R.string.obfuscated_res_0x7f0f0870));
            eMTextView2.setMaxLines(1);
            eMTextView2.setEllipsize(TextUtils.TruncateAt.END);
            eMTextView2.setPadding(dimenPixelSize3 - dimenPixelSize2, 0, dimenPixelSize, 0);
            this.j.addView(eMTextView2);
            this.e = eMTextView2;
            EMTextView eMTextView3 = new EMTextView(getContext());
            vr4 d4 = vr4.d(eMTextView3);
            d4.z(R.dimen.T_X09);
            d4.v(R.color.CAM_X0109);
            d4.A(R.string.F_X01);
            eMTextView3.setText(a(R.string.obfuscated_res_0x7f0f086f));
            eMTextView3.setMaxLines(1);
            eMTextView3.setEllipsize(TextUtils.TruncateAt.END);
            eMTextView3.setPadding(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X006) - dimenPixelSize5, 0, 0);
            this.j.addView(eMTextView3);
            this.f = eMTextView3;
            this.j.setPadding(0, dimenPixelSize5, 0, dimenPixelSize6);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams4.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
            addView(this.j, layoutParams4);
            cw6 cw6Var = new cw6(getContext());
            this.g = cw6Var;
            addView(cw6Var.a());
            LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.g.a().getLayoutParams();
            layoutParams5.weight = -1.0f;
            layoutParams5.height = UtilHelper.getDimenPixelSize(R.dimen.tbds106);
            this.g.a().requestLayout();
        }
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || this.a == i) {
            return;
        }
        this.a = i;
        SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0109);
        vr4 d = vr4.d(this.b);
        d.n(R.string.J_X06);
        d.f(R.color.CAM_X0205);
        HotTopicTabRankListLayout hotTopicTabRankListLayout = this.c;
        if (hotTopicTabRankListLayout != null) {
            hotTopicTabRankListLayout.d(i);
        }
        cw6 cw6Var = this.g;
        if (cw6Var != null) {
            cw6Var.c(i);
        }
        yx5 yx5Var = this.h;
        if (yx5Var != null) {
            yx5Var.e(i);
        }
    }

    public void setData(HotThreadListResIdl hotThreadListResIdl) {
        DataRes dataRes;
        DataRes dataRes2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, hotThreadListResIdl) == null) {
            if (hotThreadListResIdl != null && (dataRes2 = hotThreadListResIdl.data) != null && !ListUtils.isEmpty(dataRes2.topic_list)) {
                this.d.setVisibility(0);
                this.c.setVisibility(0);
                this.c.setOnItemCoverListener(this.i);
                this.c.b(new zv6(hotThreadListResIdl.data.topic_list));
            } else {
                this.d.setVisibility(8);
                this.c.setVisibility(8);
            }
            yx5 yx5Var = this.h;
            if (yx5Var != null) {
                yx5Var.b().setVisibility(0);
            }
            this.e.setVisibility(0);
            this.f.setVisibility(0);
            this.g.e(kv6.d((hotThreadListResIdl == null || (dataRes = hotThreadListResIdl.data) == null) ? null : dataRes.hot_thread_tab_info).a());
            c(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void setOnItemCoverListener(km4 km4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, km4Var) == null) {
            this.i = km4Var;
        }
    }

    public void setOnTabSelectedListener(TabLayout.OnTabSelectedListener onTabSelectedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onTabSelectedListener) == null) {
            this.g.d(onTabSelectedListener);
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
        b();
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
        b();
    }
}

package com.baidu.tieba.homepage.hotTopic.tab;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import c.a.s0.n.f;
import c.a.s0.s.u.c;
import c.a.t0.g0.r;
import c.a.t0.o1.f.a.e.d;
import c.a.t0.o1.f.a.g.a;
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
import tbclient.HotThreadList.DataRes;
import tbclient.HotThreadList.HotThreadListResIdl;
/* loaded from: classes12.dex */
public class HotTopicHeaderView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f44227e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f44228f;

    /* renamed from: g  reason: collision with root package name */
    public HotTopicTabRankListLayout f44229g;

    /* renamed from: h  reason: collision with root package name */
    public EMTextView f44230h;

    /* renamed from: i  reason: collision with root package name */
    public EMTextView f44231i;

    /* renamed from: j  reason: collision with root package name */
    public EMTextView f44232j;
    public a k;
    public r l;
    public LinearLayout m;
    public f mOnItemCoverListener;

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
        this.f44227e = 3;
        b();
    }

    public final String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? TbadkCoreApplication.getInst().getString(i2) : (String) invokeI.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setOrientation(1);
            this.f44228f = new RelativeLayout(getContext());
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X003);
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X007);
            int dimenPixelSize4 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
            int dimenPixelSize5 = UtilHelper.getDimenPixelSize(R.dimen.M_H_X005);
            int dimenPixelSize6 = UtilHelper.getDimenPixelSize(R.dimen.M_H_X004);
            EMTextView eMTextView = new EMTextView(getContext());
            this.f44230h = eMTextView;
            eMTextView.setId(R.id.title_id);
            c d2 = c.d(this.f44230h);
            d2.v(R.color.CAM_X0105);
            d2.z(R.dimen.T_X07);
            d2.A(R.string.F_X02);
            this.f44230h.setText(a(R.string.hot_topic_tab_rank_list_title));
            this.f44230h.setMaxLines(1);
            this.f44230h.setEllipsize(TextUtils.TruncateAt.END);
            this.f44230h.setPadding(dimenPixelSize4, dimenPixelSize5, dimenPixelSize4, dimenPixelSize6);
            this.f44228f.addView(this.f44230h, new RelativeLayout.LayoutParams(-1, -2));
            this.f44229g = new HotTopicTabRankListLayout(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(3, R.id.title_id);
            this.f44228f.addView(this.f44229g, layoutParams);
            c d3 = c.d(this.f44228f);
            d3.n(R.string.J_X06);
            d3.f(R.color.CAM_X0205);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
            this.f44228f.setPadding(0, 0, 0, dimenPixelSize6);
            addView(this.f44228f, layoutParams2);
            r rVar = new r(getContext());
            this.l = rVar;
            rVar.setFrom("from_hottop");
            this.l.f("2");
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams3.topMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds5);
            addView(this.l.b(), layoutParams3);
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.m = linearLayout;
            linearLayout.setOrientation(0);
            EMTextView eMTextView2 = new EMTextView(getContext());
            c d4 = c.d(eMTextView2);
            d4.z(R.dimen.T_X07);
            d4.v(R.color.CAM_X0105);
            d4.A(R.string.F_X02);
            eMTextView2.setText(a(R.string.hot_topic_hot_tie_title));
            eMTextView2.setMaxLines(1);
            eMTextView2.setEllipsize(TextUtils.TruncateAt.END);
            eMTextView2.setPadding(dimenPixelSize3 - dimenPixelSize2, 0, dimenPixelSize, 0);
            this.m.addView(eMTextView2);
            this.f44231i = eMTextView2;
            EMTextView eMTextView3 = new EMTextView(getContext());
            c d5 = c.d(eMTextView3);
            d5.z(R.dimen.T_X09);
            d5.v(R.color.CAM_X0109);
            d5.A(R.string.F_X01);
            eMTextView3.setText(a(R.string.hot_topic_hot_tie_sub_title));
            eMTextView3.setMaxLines(1);
            eMTextView3.setEllipsize(TextUtils.TruncateAt.END);
            eMTextView3.setPadding(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X006) - dimenPixelSize5, 0, 0);
            this.m.addView(eMTextView3);
            this.f44232j = eMTextView3;
            this.m.setPadding(0, dimenPixelSize5, 0, dimenPixelSize6);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams4.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
            addView(this.m, layoutParams4);
            a aVar = new a(getContext());
            this.k = aVar;
            addView(aVar.a());
            LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.k.a().getLayoutParams();
            layoutParams5.weight = -1.0f;
            layoutParams5.height = UtilHelper.getDimenPixelSize(R.dimen.tbds106);
            this.k.a().requestLayout();
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.f44227e == i2) {
            return;
        }
        this.f44227e = i2;
        SkinManager.setViewTextColor(this.f44230h, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f44231i, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f44232j, R.color.CAM_X0109);
        c d2 = c.d(this.f44228f);
        d2.n(R.string.J_X06);
        d2.f(R.color.CAM_X0205);
        HotTopicTabRankListLayout hotTopicTabRankListLayout = this.f44229g;
        if (hotTopicTabRankListLayout != null) {
            hotTopicTabRankListLayout.onChangeSkinType(i2);
        }
        a aVar = this.k;
        if (aVar != null) {
            aVar.c(i2);
        }
        r rVar = this.l;
        if (rVar != null) {
            rVar.e(i2);
        }
    }

    public void setData(HotThreadListResIdl hotThreadListResIdl) {
        DataRes dataRes;
        DataRes dataRes2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, hotThreadListResIdl) == null) {
            if (hotThreadListResIdl != null && (dataRes2 = hotThreadListResIdl.data) != null && !ListUtils.isEmpty(dataRes2.topic_list)) {
                this.f44230h.setVisibility(0);
                this.f44229g.setVisibility(0);
                this.f44229g.setOnItemCoverListener(this.mOnItemCoverListener);
                this.f44229g.bindData(new d(hotThreadListResIdl.data.topic_list));
            } else {
                this.f44230h.setVisibility(8);
                this.f44229g.setVisibility(8);
            }
            r rVar = this.l;
            if (rVar != null) {
                rVar.b().setVisibility(0);
            }
            this.f44231i.setVisibility(0);
            this.f44232j.setVisibility(0);
            this.k.e(c.a.t0.o1.f.a.c.d((hotThreadListResIdl == null || (dataRes = hotThreadListResIdl.data) == null) ? null : dataRes.hot_thread_tab_info).a());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void setOnItemCoverListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            this.mOnItemCoverListener = fVar;
        }
    }

    public void setOnTabSelectedListener(TabLayout.OnTabSelectedListener onTabSelectedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onTabSelectedListener) == null) {
            this.k.d(onTabSelectedListener);
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
        this.f44227e = 3;
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicHeaderView(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.f44227e = 3;
        b();
    }
}

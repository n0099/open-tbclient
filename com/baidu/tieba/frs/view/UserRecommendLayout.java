package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.g;
import c.a.s0.s.i0.t.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Locale;
/* loaded from: classes12.dex */
public class UserRecommendLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f45556e;

    /* renamed from: f  reason: collision with root package name */
    public int f45557f;

    /* renamed from: g  reason: collision with root package name */
    public int f45558g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f45559h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f45560i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.d.f.k.b<UserRecommendItemView> f45561j;

    /* renamed from: k  reason: collision with root package name */
    public final ViewGroup.OnHierarchyChangeListener f45562k;

    /* loaded from: classes12.dex */
    public class a implements ViewGroup.OnHierarchyChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserRecommendLayout f45563e;

        public a(UserRecommendLayout userRecommendLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userRecommendLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45563e = userRecommendLayout;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, view2) == null) {
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, view2) == null) && (view2 instanceof UserRecommendItemView) && this.f45563e.f45561j != null) {
                UserRecommendItemView userRecommendItemView = (UserRecommendItemView) view2;
                if (userRecommendItemView.getTag() instanceof c) {
                    ((c) userRecommendItemView.getTag()).t(this.f45563e.f45556e.getUniqueId());
                }
                this.f45563e.f45561j.e(userRecommendItemView);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements CommonUserLikeButton.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserRecommendItemView a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UserRecommendLayout f45564b;

        public b(UserRecommendLayout userRecommendLayout, UserRecommendItemView userRecommendItemView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userRecommendLayout, userRecommendItemView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45564b = userRecommendLayout;
            this.a = userRecommendItemView;
        }

        @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.a.getFansNum().setText(String.format(Locale.CHINA, "%s粉丝", StringHelper.numFormatOverWanNa(i2)));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserRecommendLayout(Context context) {
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
        this.f45558g = 0;
        this.f45559h = null;
        this.f45560i = null;
        this.f45561j = null;
        this.f45562k = new a(this);
        c();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setOrientation(0);
        }
    }

    public final void d(UserRecommendItemView userRecommendItemView, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, userRecommendItemView, i2, i3) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) userRecommendItemView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(i3, -1);
            } else {
                layoutParams.width = i3;
            }
            if (i2 == 0) {
                layoutParams.leftMargin = 0;
            } else {
                layoutParams.leftMargin = this.f45558g;
            }
            userRecommendItemView.setLayoutParams(layoutParams);
        }
    }

    public final void e(UserRecommendItemView userRecommendItemView, MetaData metaData) {
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, userRecommendItemView, metaData) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            userRecommendItemView.getFansNum().setText(String.format(Locale.CHINA, "%s粉丝", StringHelper.numFormatOverWanNa(metaData.getFansNum())));
            userRecommendItemView.getUsername().setText(metaData.getName_show());
            userRecommendItemView.getLikeBtn().setFanNumCallBack(new b(this, userRecommendItemView));
            if (userRecommendItemView.getLikeBtn().getTag() instanceof c) {
                cVar = (c) userRecommendItemView.getLikeBtn().getTag();
            } else {
                cVar = new c(this.f45556e, userRecommendItemView.getLikeBtn());
            }
            cVar.m("7");
            userRecommendItemView.getLikeBtn().setTag(cVar);
            cVar.n(metaData);
            userRecommendItemView.getLikeBtn().setAfterOnClickListener(this.f45559h);
            userRecommendItemView.getHeaderView().setData(metaData);
            userRecommendItemView.getHeaderView().setAfterClickListener(this.f45560i);
            userRecommendItemView.setIsGod(metaData.isGod());
            userRecommendItemView.onChangeSkinType(skinType);
        }
    }

    public int getChildItemWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f45557f : invokeV.intValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onAttachedToWindow();
            setOnHierarchyChangeListener(this.f45562k);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDetachedFromWindow();
            setOnHierarchyChangeListener(null);
        }
    }

    public void setAfterHeaderLickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onClickListener) == null) {
            this.f45560i = onClickListener;
        }
    }

    public void setAfterLikeBtnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onClickListener) == null) {
            this.f45559h = onClickListener;
        }
    }

    public void setData(List<MetaData> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        int a2 = g.a(getContext()) - (getPaddingLeft() * 2);
        int i2 = this.f45558g;
        int i3 = (a2 - (i2 * 2)) / 3;
        this.f45557f = i2 + i3;
        int i4 = 0;
        int childCount = getChildCount();
        while (i4 < childCount && i4 < list.size()) {
            if (getChildAt(i4) instanceof UserRecommendItemView) {
                UserRecommendItemView userRecommendItemView = (UserRecommendItemView) getChildAt(i4);
                d(userRecommendItemView, i4, i3);
                e(userRecommendItemView, list.get(i4));
            }
            i4++;
        }
        while (i4 < childCount) {
            removeViewAt(i4);
            i4++;
        }
        while (i4 < list.size()) {
            UserRecommendItemView b2 = this.f45561j.b();
            if (b2.getParent() != null) {
                ((ViewGroup) b2.getParent()).removeView(b2);
            }
            d(b2, i4, i3);
            e(b2, list.get(i4));
            addView(b2);
            i4++;
        }
    }

    public void setItemSpace(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f45558g = i2;
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, tbPageContext) == null) {
            this.f45556e = tbPageContext;
        }
    }

    public void setViewPool(c.a.d.f.k.b<UserRecommendItemView> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            this.f45561j = bVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserRecommendLayout(Context context, AttributeSet attributeSet) {
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
        this.f45558g = 0;
        this.f45559h = null;
        this.f45560i = null;
        this.f45561j = null;
        this.f45562k = new a(this);
        c();
    }
}

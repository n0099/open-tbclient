package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.g;
import c.a.o0.r.l0.t.c;
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
/* loaded from: classes5.dex */
public class UserRecommendLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public int f33025b;

    /* renamed from: c  reason: collision with root package name */
    public int f33026c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f33027d;

    /* renamed from: e  reason: collision with root package name */
    public View.OnClickListener f33028e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.d.f.k.b<UserRecommendItemView> f33029f;

    /* renamed from: g  reason: collision with root package name */
    public final ViewGroup.OnHierarchyChangeListener f33030g;

    /* loaded from: classes5.dex */
    public class a implements ViewGroup.OnHierarchyChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserRecommendLayout a;

        public a(UserRecommendLayout userRecommendLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userRecommendLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = userRecommendLayout;
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
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, view2) == null) && (view2 instanceof UserRecommendItemView) && this.a.f33029f != null) {
                UserRecommendItemView userRecommendItemView = (UserRecommendItemView) view2;
                if (userRecommendItemView.getTag() instanceof c) {
                    ((c) userRecommendItemView.getTag()).t(this.a.a.getUniqueId());
                }
                this.a.f33029f.e(userRecommendItemView);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements CommonUserLikeButton.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserRecommendItemView a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UserRecommendLayout f33031b;

        public b(UserRecommendLayout userRecommendLayout, UserRecommendItemView userRecommendItemView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userRecommendLayout, userRecommendItemView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33031b = userRecommendLayout;
            this.a = userRecommendItemView;
        }

        @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.getFansNum().setText(String.format(Locale.CHINA, "%s粉丝", StringHelper.numFormatOverWanNa(i)));
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33026c = 0;
        this.f33027d = null;
        this.f33028e = null;
        this.f33029f = null;
        this.f33030g = new a(this);
        c();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setOrientation(0);
        }
    }

    public final void d(UserRecommendItemView userRecommendItemView, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, userRecommendItemView, i, i2) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) userRecommendItemView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(i2, -1);
            } else {
                layoutParams.width = i2;
            }
            if (i == 0) {
                layoutParams.leftMargin = 0;
            } else {
                layoutParams.leftMargin = this.f33026c;
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
                cVar = new c(this.a, userRecommendItemView.getLikeBtn());
            }
            cVar.m("7");
            userRecommendItemView.getLikeBtn().setTag(cVar);
            cVar.n(metaData);
            userRecommendItemView.getLikeBtn().setAfterOnClickListener(this.f33027d);
            userRecommendItemView.getHeaderView().setData(metaData);
            userRecommendItemView.getHeaderView().setAfterClickListener(this.f33028e);
            userRecommendItemView.setIsGod(metaData.isGod());
            userRecommendItemView.c(skinType);
        }
    }

    public int getChildItemWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f33025b : invokeV.intValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onAttachedToWindow();
            setOnHierarchyChangeListener(this.f33030g);
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
            this.f33028e = onClickListener;
        }
    }

    public void setAfterLikeBtnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onClickListener) == null) {
            this.f33027d = onClickListener;
        }
    }

    public void setData(List<MetaData> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        int a2 = g.a(getContext()) - (getPaddingLeft() * 2);
        int i = this.f33026c;
        int i2 = (a2 - (i * 2)) / 3;
        this.f33025b = i + i2;
        int i3 = 0;
        int childCount = getChildCount();
        while (i3 < childCount && i3 < list.size()) {
            if (getChildAt(i3) instanceof UserRecommendItemView) {
                UserRecommendItemView userRecommendItemView = (UserRecommendItemView) getChildAt(i3);
                d(userRecommendItemView, i3, i2);
                e(userRecommendItemView, list.get(i3));
            }
            i3++;
        }
        while (i3 < childCount) {
            removeViewAt(i3);
            i3++;
        }
        while (i3 < list.size()) {
            UserRecommendItemView b2 = this.f33029f.b();
            if (b2.getParent() != null) {
                ((ViewGroup) b2.getParent()).removeView(b2);
            }
            d(b2, i3, i2);
            e(b2, list.get(i3));
            addView(b2);
            i3++;
        }
    }

    public void setItemSpace(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.f33026c = i;
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, tbPageContext) == null) {
            this.a = tbPageContext;
        }
    }

    public void setViewPool(c.a.d.f.k.b<UserRecommendItemView> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            this.f33029f = bVar;
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
        this.f33026c = 0;
        this.f33027d = null;
        this.f33028e = null;
        this.f33029f = null;
        this.f33030g = new a(this);
        c();
    }
}

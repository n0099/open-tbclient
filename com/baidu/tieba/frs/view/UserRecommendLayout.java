package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tieba.ag;
import com.baidu.tieba.wh;
import com.baidu.tieba.za5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Locale;
/* loaded from: classes6.dex */
public class UserRecommendLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public int b;
    public int c;
    public View.OnClickListener d;
    public View.OnClickListener e;
    public ag<UserRecommendItemView> f;
    public final ViewGroup.OnHierarchyChangeListener g;

    /* loaded from: classes6.dex */
    public class a implements ViewGroup.OnHierarchyChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserRecommendLayout a;

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view2, View view3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, view3) == null) {
            }
        }

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
        public void onChildViewRemoved(View view2, View view3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, view3) == null) && (view3 instanceof UserRecommendItemView) && this.a.f != null) {
                UserRecommendItemView userRecommendItemView = (UserRecommendItemView) view3;
                if (userRecommendItemView.getTag() instanceof za5) {
                    ((za5) userRecommendItemView.getTag()).r(this.a.a.getUniqueId());
                }
                this.a.f.e(userRecommendItemView);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements CommonUserLikeButton.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserRecommendItemView a;
        public final /* synthetic */ UserRecommendLayout b;

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
            this.b = userRecommendLayout;
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
        this.c = 0;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = new a(this);
        c();
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
        this.c = 0;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = new a(this);
        c();
    }

    public void setAfterHeaderLickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onClickListener) == null) {
            this.e = onClickListener;
        }
    }

    public void setAfterLikeBtnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onClickListener) == null) {
            this.d = onClickListener;
        }
    }

    public void setItemSpace(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.c = i;
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, tbPageContext) == null) {
            this.a = tbPageContext;
        }
    }

    public void setViewPool(ag<UserRecommendItemView> agVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, agVar) == null) {
            this.f = agVar;
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setOrientation(0);
        }
    }

    public int getChildItemWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onAttachedToWindow();
            setOnHierarchyChangeListener(this.g);
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
                layoutParams.leftMargin = this.c;
            }
            userRecommendItemView.setLayoutParams(layoutParams);
        }
    }

    public final void e(UserRecommendItemView userRecommendItemView, MetaData metaData) {
        za5 za5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, userRecommendItemView, metaData) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            userRecommendItemView.getFansNum().setText(String.format(Locale.CHINA, "%s粉丝", StringHelper.numFormatOverWanNa(metaData.getFansNum())));
            userRecommendItemView.getUsername().setText(metaData.getName_show());
            userRecommendItemView.getLikeBtn().setFanNumCallBack(new b(this, userRecommendItemView));
            if (userRecommendItemView.getLikeBtn().getTag() instanceof za5) {
                za5Var = (za5) userRecommendItemView.getLikeBtn().getTag();
            } else {
                za5Var = new za5(this.a, userRecommendItemView.getLikeBtn());
            }
            za5Var.k("7");
            userRecommendItemView.getLikeBtn().setTag(za5Var);
            za5Var.l(metaData);
            userRecommendItemView.getLikeBtn().setAfterOnClickListener(this.d);
            userRecommendItemView.getHeaderView().setData(metaData);
            userRecommendItemView.getHeaderView().setAfterClickListener(this.e);
            userRecommendItemView.setIsGod(metaData.isGod());
            userRecommendItemView.c(skinType);
        }
    }

    public void setData(List<MetaData> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        int a2 = wh.a(getContext()) - (getPaddingLeft() * 2);
        int i = this.c;
        int i2 = (a2 - (i * 2)) / 3;
        this.b = i + i2;
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
            UserRecommendItemView b2 = this.f.b();
            if (b2.getParent() != null) {
                ((ViewGroup) b2.getParent()).removeView(b2);
            }
            d(b2, i3, i2);
            e(b2, list.get(i3));
            addView(b2);
            i3++;
        }
    }
}

package com.baidu.tieba.card;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.k.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGameSubNode;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class CardFrsGameRecommendGameLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b<CardFrsGameRecommendGameItemView> a;

    /* renamed from: b  reason: collision with root package name */
    public int f31641b;

    /* renamed from: c  reason: collision with root package name */
    public int f31642c;

    /* renamed from: d  reason: collision with root package name */
    public int f31643d;

    /* renamed from: e  reason: collision with root package name */
    public final ViewGroup.OnHierarchyChangeListener f31644e;

    /* loaded from: classes5.dex */
    public class a implements ViewGroup.OnHierarchyChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CardFrsGameRecommendGameLayout a;

        public a(CardFrsGameRecommendGameLayout cardFrsGameRecommendGameLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardFrsGameRecommendGameLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cardFrsGameRecommendGameLayout;
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
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, view2) == null) && (view2 instanceof CardFrsGameRecommendGameItemView) && this.a.a != null) {
                this.a.a.e((CardFrsGameRecommendGameItemView) view2);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardFrsGameRecommendGameLayout(Context context) {
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
        this.a = null;
        this.f31644e = new a(this);
        b();
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setOrientation(0);
            setGravity(17);
        }
    }

    public final void c(CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cardFrsGameRecommendGameItemView, i, i2) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cardFrsGameRecommendGameItemView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(i2, -1);
            } else {
                layoutParams.width = i2;
            }
            if (i == 0) {
                layoutParams.leftMargin = 0;
            } else {
                layoutParams.leftMargin = this.f31641b;
            }
            cardFrsGameRecommendGameItemView.setLayoutParams(layoutParams);
        }
    }

    public final void d(CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView, FeatureCardGameSubNode featureCardGameSubNode) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cardFrsGameRecommendGameItemView, featureCardGameSubNode) == null) || featureCardGameSubNode == null) {
            return;
        }
        cardFrsGameRecommendGameItemView.getGamePicView().J(featureCardGameSubNode.image, 10, false);
        cardFrsGameRecommendGameItemView.getGameNameView().setText(featureCardGameSubNode.name);
        cardFrsGameRecommendGameItemView.getGameDscView().setText(featureCardGameSubNode.title);
        cardFrsGameRecommendGameItemView.setTag(featureCardGameSubNode.url);
        cardFrsGameRecommendGameItemView.c(TbadkCoreApplication.getInst().getSkinType());
    }

    public int getChildItemWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f31643d : invokeV.intValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onAttachedToWindow();
            setOnHierarchyChangeListener(this.f31644e);
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

    public void setData(List<FeatureCardGameSubNode> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.f31643d = this.f31642c + this.f31641b;
        int i = 0;
        int childCount = getChildCount();
        while (i < childCount && i < list.size()) {
            if (getChildAt(i) instanceof CardFrsGameRecommendGameItemView) {
                CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView = (CardFrsGameRecommendGameItemView) getChildAt(i);
                c(cardFrsGameRecommendGameItemView, i, this.f31642c);
                d(cardFrsGameRecommendGameItemView, list.get(i));
            }
            i++;
        }
        while (i < childCount) {
            removeViewAt(i);
            i++;
        }
        while (i < list.size()) {
            CardFrsGameRecommendGameItemView b2 = this.a.b();
            if (b2.getParent() != null) {
                ((ViewGroup) b2.getParent()).removeView(b2);
            }
            c(b2, i, this.f31642c);
            d(b2, list.get(i));
            addView(b2);
            i++;
        }
    }

    public void setItemSpace(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.f31641b = i;
        }
    }

    public void setItemWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.f31642c = i;
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, tbPageContext) == null) {
        }
    }

    public void setViewPool(b<CardFrsGameRecommendGameItemView> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            this.a = bVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardFrsGameRecommendGameLayout(Context context, @Nullable AttributeSet attributeSet) {
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
        this.a = null;
        this.f31644e = new a(this);
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardFrsGameRecommendGameLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.a = null;
        this.f31644e = new a(this);
        b();
    }
}

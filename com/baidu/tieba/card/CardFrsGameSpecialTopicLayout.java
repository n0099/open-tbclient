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
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopicSubNode;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class CardFrsGameSpecialTopicLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b<CardFrsGameSpecialTopicItemView> a;

    /* renamed from: b  reason: collision with root package name */
    public int f31652b;

    /* renamed from: c  reason: collision with root package name */
    public int f31653c;

    /* renamed from: d  reason: collision with root package name */
    public int f31654d;

    /* renamed from: e  reason: collision with root package name */
    public final ViewGroup.OnHierarchyChangeListener f31655e;

    /* loaded from: classes5.dex */
    public class a implements ViewGroup.OnHierarchyChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CardFrsGameSpecialTopicLayout a;

        public a(CardFrsGameSpecialTopicLayout cardFrsGameSpecialTopicLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardFrsGameSpecialTopicLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cardFrsGameSpecialTopicLayout;
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
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, view2) == null) && (view2 instanceof CardFrsGameSpecialTopicItemView) && this.a.a != null) {
                this.a.a.e((CardFrsGameSpecialTopicItemView) view2);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardFrsGameSpecialTopicLayout(Context context) {
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
        this.f31655e = new a(this);
        b();
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setOrientation(0);
            setGravity(17);
        }
    }

    public final void c(CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cardFrsGameSpecialTopicItemView, i, i2) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cardFrsGameSpecialTopicItemView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(i2, -1);
            } else {
                layoutParams.width = i2;
            }
            if (i == 0) {
                layoutParams.leftMargin = 0;
            } else {
                layoutParams.leftMargin = this.f31652b;
            }
            cardFrsGameSpecialTopicItemView.setLayoutParams(layoutParams);
        }
    }

    public final void d(CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView, FeatureCardTopicSubNode featureCardTopicSubNode) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cardFrsGameSpecialTopicItemView, featureCardTopicSubNode) == null) || featureCardTopicSubNode == null) {
            return;
        }
        cardFrsGameSpecialTopicItemView.getSpecialTopicPicView().J(featureCardTopicSubNode.image, 10, false);
        cardFrsGameSpecialTopicItemView.getSpecialTopicNameView().setText(featureCardTopicSubNode.title);
        cardFrsGameSpecialTopicItemView.getSpecialTopicDscView().setText(getContext().getResources().getString(R.string.obfuscated_res_0x7f0f06db, String.valueOf(featureCardTopicSubNode.article_num)));
        cardFrsGameSpecialTopicItemView.getSpecialTopicUpdateTimeView().setText(getContext().getString(R.string.obfuscated_res_0x7f0f06dc, StringHelper.getTimeInterval(featureCardTopicSubNode.update_time)));
        cardFrsGameSpecialTopicItemView.setTag(featureCardTopicSubNode.url);
        cardFrsGameSpecialTopicItemView.c(TbadkCoreApplication.getInst().getSkinType());
    }

    public int getChildItemWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f31654d : invokeV.intValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onAttachedToWindow();
            setOnHierarchyChangeListener(this.f31655e);
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

    public void setData(List<FeatureCardTopicSubNode> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.f31654d = this.f31653c + this.f31652b;
        int i = 0;
        int childCount = getChildCount();
        while (i < childCount && i < list.size()) {
            if (getChildAt(i) instanceof CardFrsGameSpecialTopicItemView) {
                CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView = (CardFrsGameSpecialTopicItemView) getChildAt(i);
                c(cardFrsGameSpecialTopicItemView, i, this.f31653c);
                d(cardFrsGameSpecialTopicItemView, list.get(i));
            }
            i++;
        }
        while (i < childCount) {
            removeViewAt(i);
            i++;
        }
        while (i < list.size()) {
            CardFrsGameSpecialTopicItemView b2 = this.a.b();
            if (b2.getParent() != null) {
                ((ViewGroup) b2.getParent()).removeView(b2);
            }
            c(b2, i, this.f31653c);
            d(b2, list.get(i));
            addView(b2);
            i++;
        }
    }

    public void setItemSpace(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.f31652b = i;
        }
    }

    public void setItemWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.f31653c = i;
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, tbPageContext) == null) {
        }
    }

    public void setViewPool(b<CardFrsGameSpecialTopicItemView> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            this.a = bVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardFrsGameSpecialTopicLayout(Context context, @Nullable AttributeSet attributeSet) {
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
        this.f31655e = new a(this);
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardFrsGameSpecialTopicLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.f31655e = new a(this);
        b();
    }
}

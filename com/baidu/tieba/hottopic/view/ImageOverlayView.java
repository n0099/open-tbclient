package com.baidu.tieba.hottopic.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.m.b;
import c.a.r0.p1.l.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.List;
/* loaded from: classes10.dex */
public class ImageOverlayView extends ViewGroup {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f45700e;

    /* renamed from: f  reason: collision with root package name */
    public int f45701f;

    /* renamed from: g  reason: collision with root package name */
    public int f45702g;

    /* renamed from: h  reason: collision with root package name */
    public int f45703h;

    /* renamed from: i  reason: collision with root package name */
    public int f45704i;

    /* renamed from: j  reason: collision with root package name */
    public int f45705j;

    /* renamed from: k  reason: collision with root package name */
    public List<l> f45706k;

    /* loaded from: classes10.dex */
    public interface a {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageOverlayView(Context context) {
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
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (int i2 = 0; i2 < this.f45700e; i2++) {
                HeadImageView headImageView = new HeadImageView(getContext());
                headImageView.setLayoutParams(new ViewGroup.LayoutParams(this.f45701f, this.f45702g));
                headImageView.setIsRound(true);
                headImageView.setBorderSurroundContent(true);
                headImageView.setDrawBorder(true);
                headImageView.setBorderWidth(this.f45703h);
                headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                headImageView.setBorderColor(SkinManager.getColor(this.f45704i));
                headImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                addView(headImageView);
            }
        }
    }

    public int getExistUserIndex(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
            if (this.f45706k == null) {
                return -1;
            }
            for (int i2 = 0; i2 < this.f45706k.size(); i2++) {
                if (this.f45706k.get(i2).a == j2) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeJ.intValue;
    }

    public void init(int i2, int i3, int i4, int i5, int i6, int i7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)}) == null) {
            this.f45700e = i2;
            this.f45701f = i3;
            this.f45702g = i4;
            this.f45703h = i5;
            this.f45704i = i6;
            this.f45705j = i7;
            a();
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                if (childAt instanceof HeadImageView) {
                    ((HeadImageView) childAt).setBorderColor(SkinManager.getColor(this.f45704i));
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            for (int i6 = 0; i6 < this.f45700e && i6 < getChildCount() && (childAt = getChildAt(i6)) != null; i6++) {
                childAt.layout(paddingLeft, paddingTop, this.f45701f + paddingLeft, this.f45702g + paddingTop);
                paddingLeft += this.f45701f - this.f45705j;
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
            int paddingLeft = getPaddingLeft() + getPaddingRight();
            int i4 = this.f45700e;
            setMeasuredDimension(ViewGroup.resolveSize((paddingLeft + (this.f45701f * i4)) - ((i4 - 1) * this.f45705j), i2), ViewGroup.resolveSize(getPaddingTop() + getPaddingBottom() + this.f45702g, i3));
        }
    }

    public void setData(List<l> list) {
        HeadImageView headImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.f45706k = list;
        for (int i2 = 0; i2 < this.f45700e && (headImageView = (HeadImageView) getChildAt(i2)) != null; i2++) {
            if (i2 >= list.size()) {
                headImageView.setVisibility(8);
            } else {
                headImageView.setVisibility(0);
                l lVar = (l) ListUtils.getItem(list, (list.size() - i2) - 1);
                if (lVar == null) {
                    return;
                }
                headImageView.setUserId(String.valueOf(lVar.a));
                headImageView.startLoad(lVar.f21174b, 12, this.f45701f, this.f45702g, false);
            }
        }
    }

    public void setImageClickListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
        }
    }

    public void updateTopHeadForPostUser() {
        AccountData currentAccountInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f45706k == null || (currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo()) == null) {
            return;
        }
        l lVar = new l();
        lVar.f21174b = currentAccountInfo.getPortrait();
        currentAccountInfo.getAccount();
        long g2 = b.g(currentAccountInfo.getID(), 0L);
        lVar.a = g2;
        int existUserIndex = getExistUserIndex(g2);
        if (existUserIndex >= 0) {
            if (existUserIndex >= this.f45706k.size() - 1) {
                return;
            }
            List<l> list = this.f45706k;
            Collections.swap(list, existUserIndex, list.size() - 1);
        } else {
            ListUtils.add(this.f45706k, 0, lVar);
            if (this.f45706k.size() > this.f45700e) {
                List<l> list2 = this.f45706k;
                ListUtils.remove(list2, list2.size() - 1);
            }
        }
        setData(this.f45706k);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageOverlayView(Context context, AttributeSet attributeSet) {
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
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageOverlayView(Context context, AttributeSet attributeSet, int i2) {
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
    }
}

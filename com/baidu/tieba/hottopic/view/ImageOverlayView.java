package com.baidu.tieba.hottopic.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.m.b;
import c.a.r0.i1.c.l;
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
/* loaded from: classes7.dex */
public class ImageOverlayView extends ViewGroup {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f52861e;

    /* renamed from: f  reason: collision with root package name */
    public int f52862f;

    /* renamed from: g  reason: collision with root package name */
    public int f52863g;

    /* renamed from: h  reason: collision with root package name */
    public int f52864h;

    /* renamed from: i  reason: collision with root package name */
    public int f52865i;

    /* renamed from: j  reason: collision with root package name */
    public int f52866j;
    public List<l> k;

    /* loaded from: classes7.dex */
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
            for (int i2 = 0; i2 < this.f52861e; i2++) {
                HeadImageView headImageView = new HeadImageView(getContext());
                headImageView.setLayoutParams(new ViewGroup.LayoutParams(this.f52862f, this.f52863g));
                headImageView.setIsRound(true);
                headImageView.setBorderSurroundContent(true);
                headImageView.setDrawBorder(true);
                headImageView.setBorderWidth(this.f52864h);
                headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                headImageView.setBorderColor(SkinManager.getColor(this.f52865i));
                headImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                addView(headImageView);
            }
        }
    }

    public int getExistUserIndex(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
            if (this.k == null) {
                return -1;
            }
            for (int i2 = 0; i2 < this.k.size(); i2++) {
                if (this.k.get(i2).f19319a == j2) {
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
            this.f52861e = i2;
            this.f52862f = i3;
            this.f52863g = i4;
            this.f52864h = i5;
            this.f52865i = i6;
            this.f52866j = i7;
            a();
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                if (childAt instanceof HeadImageView) {
                    ((HeadImageView) childAt).setBorderColor(SkinManager.getColor(this.f52865i));
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
            for (int i6 = 0; i6 < this.f52861e && i6 < getChildCount() && (childAt = getChildAt(i6)) != null; i6++) {
                childAt.layout(paddingLeft, paddingTop, this.f52862f + paddingLeft, this.f52863g + paddingTop);
                paddingLeft += this.f52862f - this.f52866j;
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
            int paddingLeft = getPaddingLeft() + getPaddingRight();
            int i4 = this.f52861e;
            setMeasuredDimension(ViewGroup.resolveSize((paddingLeft + (this.f52862f * i4)) - ((i4 - 1) * this.f52866j), i2), ViewGroup.resolveSize(getPaddingTop() + getPaddingBottom() + this.f52863g, i3));
        }
    }

    public void setData(List<l> list) {
        HeadImageView headImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.k = list;
        for (int i2 = 0; i2 < this.f52861e && (headImageView = (HeadImageView) getChildAt(i2)) != null; i2++) {
            if (i2 >= list.size()) {
                headImageView.setVisibility(8);
            } else {
                headImageView.setVisibility(0);
                l lVar = (l) ListUtils.getItem(list, (list.size() - i2) - 1);
                if (lVar == null) {
                    return;
                }
                headImageView.setUserId(String.valueOf(lVar.f19319a));
                headImageView.startLoad(lVar.f19320b, 12, this.f52862f, this.f52863g, false);
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
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.k == null || (currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo()) == null) {
            return;
        }
        l lVar = new l();
        lVar.f19320b = currentAccountInfo.getPortrait();
        currentAccountInfo.getAccount();
        long g2 = b.g(currentAccountInfo.getID(), 0L);
        lVar.f19319a = g2;
        int existUserIndex = getExistUserIndex(g2);
        if (existUserIndex >= 0) {
            if (existUserIndex >= this.k.size() - 1) {
                return;
            }
            List<l> list = this.k;
            Collections.swap(list, existUserIndex, list.size() - 1);
        } else {
            ListUtils.add(this.k, 0, lVar);
            if (this.k.size() > this.f52861e) {
                List<l> list2 = this.k;
                ListUtils.remove(list2, list2.size() - 1);
            }
        }
        setData(this.k);
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

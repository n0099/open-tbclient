package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.k.b;
import c.a.q0.f1.j.c;
import c.a.q0.f1.j.d;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class ConstrainImageGroup extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f48796e;

    /* renamed from: f  reason: collision with root package name */
    public b<ConstrainImageLayout> f48797f;

    /* renamed from: g  reason: collision with root package name */
    public b<TbImageView> f48798g;

    /* renamed from: h  reason: collision with root package name */
    public c f48799h;

    /* renamed from: i  reason: collision with root package name */
    public int f48800i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f48801j;
    public double k;
    public d l;
    public View.OnClickListener m;
    public c.a.e.l.c.b n;
    public ViewGroup.OnHierarchyChangeListener o;
    public boolean p;

    /* loaded from: classes6.dex */
    public class a implements ViewGroup.OnHierarchyChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ConstrainImageGroup f48802e;

        public a(ConstrainImageGroup constrainImageGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {constrainImageGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48802e = constrainImageGroup;
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
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, view2) == null) && (view2 instanceof ConstrainImageLayout) && this.f48802e.f48797f != null) {
                ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view2;
                constrainImageLayout.reset();
                this.f48802e.f48797f.e(constrainImageLayout);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstrainImageGroup(Context context) {
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
        this.f48799h = new c.a.q0.f1.j.b();
        this.f48801j = false;
        this.o = new a(this);
        this.p = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.o);
    }

    private ConstrainImageLayout getConstrainImageLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            ConstrainImageLayout b2 = this.f48797f.b();
            b2.setImagePadding(this.f48800i);
            b2.setImageViewObjectPool(this.f48798g);
            b2.setImageMaxChildCount(-1);
            b2.setExtraCenterText(null);
            b2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            b2.setPageUniqueId(this.f48796e);
            b2.setPreloadSizeReadyCallback(this.n);
            return b2;
        }
        return (ConstrainImageLayout) invokeV.objValue;
    }

    public final void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            int b2 = this.f48799h.b(i2);
            int childCount = getChildCount() - b2;
            if (childCount > 0) {
                removeViews(b2, childCount);
            } else if (childCount < 0) {
                int abs = Math.abs(childCount);
                for (int i3 = 0; i3 < abs; i3++) {
                    addView(getConstrainImageLayout());
                }
            }
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt instanceof ConstrainImageLayout) {
                    ((ConstrainImageLayout) childAt).onChangeSkinType();
                }
            }
        }
    }

    public void setChildClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.m = onClickListener;
        }
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            super.setClickable(z);
            if (z) {
                return;
            }
            setImageClickListener(null);
            setChildClickListener(null);
        }
    }

    public void setConstrainLayoutPool(b<ConstrainImageLayout> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f48797f = bVar;
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f48801j = z;
        }
    }

    public void setImageClickListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            this.l = dVar;
            int childCount = getChildCount();
            if (childCount > 0) {
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = getChildAt(i2);
                    if (childAt instanceof ConstrainImageLayout) {
                        ((ConstrainImageLayout) childAt).setImageClickListener(this.l);
                    }
                }
            }
        }
    }

    public void setImageMargin(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            if (i2 >= 0) {
                this.f48800i = i2;
            } else {
                this.f48800i = 0;
            }
        }
    }

    public void setImageMediaList(List<MediaData> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) || ListUtils.isEmpty(list) || this.f48797f == null) {
            return;
        }
        b(ListUtils.getCount(list));
        int childCount = getChildCount();
        int i2 = 0;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt instanceof ConstrainImageLayout) {
                ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) childAt;
                constrainImageLayout.setImageClickListener(this.l);
                constrainImageLayout.setFromCDN(this.f48801j);
                double d2 = this.k;
                if (d2 > 0.0d) {
                    constrainImageLayout.setSingleImageRatio(d2);
                }
                View.OnClickListener onClickListener = this.m;
                if (onClickListener == null) {
                    constrainImageLayout.setClickable(false);
                } else {
                    constrainImageLayout.setOnClickListener(onClickListener);
                }
                constrainImageLayout.setSinglePicUseStyleV10(this.p);
                i2 = this.f48799h.a(constrainImageLayout, list, i3, i2);
            }
        }
    }

    public void setImageProcessor(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) || cVar == null) {
            return;
        }
        this.f48799h = cVar;
    }

    @Deprecated
    public void setImageUrls(List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        for (String str : list) {
            MediaData mediaData = new MediaData();
            mediaData.setPic(str);
            mediaData.setThumbnails_url(str);
            linkedList.add(mediaData);
        }
        setImageMediaList(linkedList);
    }

    public void setImageViewPool(b<TbImageView> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            this.f48798g = bVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bdUniqueId) == null) {
            this.f48796e = bdUniqueId;
        }
    }

    public void setPreloadSizeReadyCallback(c.a.e.l.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bVar) == null) {
            this.n = bVar;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt instanceof ConstrainImageLayout) {
                    ((ConstrainImageLayout) childAt).setPreloadSizeReadyCallback(bVar);
                }
            }
        }
    }

    public void setSingleImageRatio(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Double.valueOf(d2)}) == null) {
            this.k = d2;
        }
    }

    public void setSinglePicUseStyleV10(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.p = z;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstrainImageGroup(Context context, AttributeSet attributeSet) {
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
        this.f48799h = new c.a.q0.f1.j.b();
        this.f48801j = false;
        this.o = new a(this);
        this.p = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.o);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstrainImageGroup(Context context, AttributeSet attributeSet, int i2) {
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
        this.f48799h = new c.a.q0.f1.j.b();
        this.f48801j = false;
        this.o = new a(this);
        this.p = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.o);
    }
}

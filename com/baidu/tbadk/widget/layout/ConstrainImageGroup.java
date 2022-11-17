package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.gn;
import com.baidu.tieba.og;
import com.baidu.tieba.rl5;
import com.baidu.tieba.sl5;
import com.baidu.tieba.tl5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class ConstrainImageGroup extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public og<ConstrainImageLayout> b;
    public og<TbImageView> c;
    public sl5 d;
    public int e;
    public boolean f;
    public double g;
    public tl5 h;
    public View.OnClickListener i;
    public gn j;
    public ViewGroup.OnHierarchyChangeListener k;
    public boolean l;

    /* loaded from: classes3.dex */
    public class a implements ViewGroup.OnHierarchyChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConstrainImageGroup a;

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view2, View view3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, view3) == null) {
            }
        }

        public a(ConstrainImageGroup constrainImageGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {constrainImageGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = constrainImageGroup;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view2, View view3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, view3) == null) && (view3 instanceof ConstrainImageLayout) && this.a.b != null) {
                ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) view3;
                constrainImageLayout.i();
                this.a.b.e(constrainImageLayout);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new rl5();
        this.f = false;
        this.k = new a(this);
        this.l = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.k);
    }

    public void setImageMediaList(List<MediaData> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) != null) || ListUtils.isEmpty(list) || this.b == null) {
            return;
        }
        c(ListUtils.getCount(list));
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof ConstrainImageLayout) {
                ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) childAt;
                constrainImageLayout.setImageClickListener(this.h);
                constrainImageLayout.setFromCDN(this.f);
                double d = this.g;
                if (d > 0.0d) {
                    constrainImageLayout.setSingleImageRatio(d);
                }
                View.OnClickListener onClickListener = this.i;
                if (onClickListener == null) {
                    constrainImageLayout.setClickable(false);
                } else {
                    constrainImageLayout.setOnClickListener(onClickListener);
                }
                constrainImageLayout.setSinglePicUseStyleV10(this.l);
                i = this.d.a(constrainImageLayout, list, i2, i);
            }
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
        this.d = new rl5();
        this.f = false;
        this.k = new a(this);
        this.l = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.k);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstrainImageGroup(Context context, AttributeSet attributeSet, int i) {
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
        this.d = new rl5();
        this.f = false;
        this.k = new a(this);
        this.l = false;
        setOrientation(1);
        setOnHierarchyChangeListener(this.k);
    }

    public void setChildClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.i = onClickListener;
        }
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            super.setClickable(z);
            if (!z) {
                setImageClickListener(null);
                setChildClickListener(null);
            }
        }
    }

    public void setConstrainLayoutPool(og<ConstrainImageLayout> ogVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ogVar) == null) {
            this.b = ogVar;
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f = z;
        }
    }

    public void setImageClickListener(tl5 tl5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, tl5Var) == null) {
            this.h = tl5Var;
            int childCount = getChildCount();
            if (childCount > 0) {
                for (int i = 0; i < childCount; i++) {
                    View childAt = getChildAt(i);
                    if (childAt instanceof ConstrainImageLayout) {
                        ((ConstrainImageLayout) childAt).setImageClickListener(this.h);
                    }
                }
            }
        }
    }

    public void setImageMargin(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            if (i >= 0) {
                this.e = i;
            } else {
                this.e = 0;
            }
        }
    }

    public void setImageProcessor(sl5 sl5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, sl5Var) == null) && sl5Var != null) {
            this.d = sl5Var;
        }
    }

    public void setImageViewPool(og<TbImageView> ogVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, ogVar) == null) {
            this.c = ogVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bdUniqueId) == null) {
            this.a = bdUniqueId;
        }
    }

    public void setPreloadSizeReadyCallback(gn gnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, gnVar) == null) {
            this.j = gnVar;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof ConstrainImageLayout) {
                    ((ConstrainImageLayout) childAt).setPreloadSizeReadyCallback(gnVar);
                }
            }
        }
    }

    public void setSingleImageRatio(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Double.valueOf(d)}) == null) {
            this.g = d;
        }
    }

    public void setSinglePicUseStyleV10(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.l = z;
        }
    }

    private ConstrainImageLayout getConstrainImageLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            ConstrainImageLayout b = this.b.b();
            b.setImagePadding(this.e);
            b.setImageViewObjectPool(this.c);
            b.setImageMaxChildCount(-1);
            b.setExtraCenterText(null);
            b.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            b.setPageUniqueId(this.a);
            b.setPreloadSizeReadyCallback(this.j);
            return b;
        }
        return (ConstrainImageLayout) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof ConstrainImageLayout) {
                    ((ConstrainImageLayout) childAt).h();
                }
            }
        }
    }

    public final void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            int b = this.d.b(i);
            int childCount = getChildCount() - b;
            if (childCount > 0) {
                removeViews(b, childCount);
            } else if (childCount < 0) {
                int abs = Math.abs(childCount);
                for (int i2 = 0; i2 < abs; i2++) {
                    addView(getConstrainImageLayout());
                }
            }
        }
    }

    @Deprecated
    public void setImageUrls(List<String> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, list) != null) || ListUtils.isEmpty(list)) {
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
}

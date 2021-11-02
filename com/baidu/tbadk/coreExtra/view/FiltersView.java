package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class FiltersView extends HorizontalScrollView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f45727e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f45728f;

    /* renamed from: g  reason: collision with root package name */
    public Context f45729g;

    /* renamed from: h  reason: collision with root package name */
    public View f45730h;

    /* renamed from: i  reason: collision with root package name */
    public View f45731i;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FiltersView f45732e;

        public a(FiltersView filtersView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {filtersView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45732e = filtersView;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f45732e.f45730h == null) {
                return;
            }
            int childCount = ((LinearLayout) this.f45732e.getChildAt(0)).getChildCount();
            int i3 = 0;
            while (true) {
                if (i3 >= childCount) {
                    i2 = 0;
                    break;
                }
                View childAt = ((LinearLayout) this.f45732e.getChildAt(0)).getChildAt(i3);
                if (childAt == this.f45732e.f45730h) {
                    i2 = childAt.getRight();
                    break;
                }
                i3++;
            }
            this.f45732e.f45730h = null;
            int width = i2 - this.f45732e.getWidth();
            if (width > 0) {
                this.f45732e.scrollBy(width, 0);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FiltersView(TbPageContextSupport tbPageContextSupport, String str) {
        super(tbPageContextSupport.getPageContext().getContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContextSupport, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f45727e = 0;
        this.f45728f = new a(this);
        this.f45729g = null;
        this.f45730h = null;
        this.f45731i = null;
        this.f45729g = tbPageContextSupport.getPageContext().getContext();
        c();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f45729g.getResources().getDimension(R.dimen.ds4);
            this.f45727e = (int) this.f45729g.getResources().getDimension(R.dimen.ds30);
            LinearLayout linearLayout = new LinearLayout(this.f45729g);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
            linearLayout.setGravity(16);
            linearLayout.setOrientation(0);
            linearLayout.setPadding(this.f45727e, linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), linearLayout.getPaddingBottom());
            setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
            addView(linearLayout);
        }
    }

    public String getSelectedFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            View view = this.f45731i;
            return view != null ? (String) ((View) view.getTag()).getTag() : "normal";
        }
        return (String) invokeV.objValue;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            if (this.f45730h != null) {
                post(this.f45728f);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FiltersView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f45727e = 0;
        this.f45728f = new a(this);
        this.f45729g = null;
        this.f45730h = null;
        this.f45731i = null;
    }
}

package com.baidu.tbadk.widget.extend;

import android.app.Activity;
import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.m.g;
/* loaded from: classes4.dex */
public abstract class AdapterLayout extends ViewGroup {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d.a.r0.b1.f.a.b f13295e;

    /* renamed from: f  reason: collision with root package name */
    public DataSetObserver f13296f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f13297g;

    /* loaded from: classes4.dex */
    public class a extends g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f13298e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AdapterLayout f13299f;

        public a(AdapterLayout adapterLayout, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adapterLayout, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13299f = adapterLayout;
            this.f13298e = context;
        }

        @Override // d.a.r0.m.g, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            DataSetObserver dataSetObserver;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, activity) == null) && activity == this.f13298e) {
                AdapterLayout adapterLayout = this.f13299f;
                d.a.r0.b1.f.a.b bVar = adapterLayout.f13295e;
                if (bVar != null && (dataSetObserver = adapterLayout.f13296f) != null) {
                    bVar.e(dataSetObserver);
                    AdapterLayout adapterLayout2 = this.f13299f;
                    adapterLayout2.f13295e = null;
                    adapterLayout2.f13296f = null;
                }
                ((Activity) this.f13298e).getApplication().unregisterActivityLifecycleCallbacks(this);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends DataSetObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdapterLayout f13300a;

        public b(AdapterLayout adapterLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adapterLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13300a = adapterLayout;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f13300a.b();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdapterLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void a() {
        d.a.r0.b1.f.a.b bVar;
        DataSetObserver dataSetObserver;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.f13295e) == null || (dataSetObserver = this.f13296f) == null || this.f13297g) {
            return;
        }
        bVar.d(dataSetObserver);
        this.f13297g = true;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f13295e == null) {
            return;
        }
        removeAllViews();
        int a2 = this.f13295e.a();
        for (int i2 = 0; i2 < a2; i2++) {
            View b2 = this.f13295e.b(i2, this);
            b2.setFocusable(true);
            addView(b2);
        }
    }

    public final void c() {
        d.a.r0.b1.f.a.b bVar;
        DataSetObserver dataSetObserver;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bVar = this.f13295e) == null || (dataSetObserver = this.f13296f) == null || !this.f13297g) {
            return;
        }
        this.f13297g = false;
        bVar.e(dataSetObserver);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onAttachedToWindow();
            a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c();
            super.onDetachedFromWindow();
        }
    }

    public void setAdapter(d.a.r0.b1.f.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            c();
            if (bVar != null) {
                this.f13295e = bVar;
                this.f13296f = new b(this);
                a();
                b();
                return;
            }
            throw new NullPointerException("FlowBaseAdapter is null");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdapterLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdapterLayout(Context context, AttributeSet attributeSet, int i2) {
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
        this.f13297g = false;
        if (context instanceof Activity) {
            ((Activity) context).getApplication().registerActivityLifecycleCallbacks(new a(this, context));
        }
    }
}

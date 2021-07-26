package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.view.CommonTabWidgetView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.x.z.a;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class CommonTabHost extends ICommonTabHost implements CommonTabWidgetView.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public EditorTools f13127e;

    /* renamed from: f  reason: collision with root package name */
    public CommonTabContentView f13128f;

    /* renamed from: g  reason: collision with root package name */
    public CommonTabWidgetView f13129g;

    /* renamed from: h  reason: collision with root package name */
    public ProgressBar f13130h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<d.a.p0.x.z.a> f13131i;
    public int j;
    public int k;
    public Context l;
    public int m;
    public int n;
    public b o;
    public boolean p;

    /* loaded from: classes3.dex */
    public class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CommonTabHost f13132a;

        public a(CommonTabHost commonTabHost) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonTabHost};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13132a = commonTabHost;
        }

        @Override // com.baidu.tbadk.editortools.view.CommonTabHost.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f13132a.o();
            }
        }

        @Override // com.baidu.tbadk.editortools.view.CommonTabHost.b
        public void b(d.a.p0.x.z.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.f13132a.m();
                this.f13132a.f13129g.e();
                this.f13132a.f13129g.setDatas(this.f13132a.f13131i);
                int size = this.f13132a.f13131i.size();
                boolean z = false;
                for (int i2 = 0; i2 < size; i2++) {
                    a.b i3 = ((d.a.p0.x.z.a) this.f13132a.f13131i.get(i2)).i();
                    if (i3 != null) {
                        this.f13132a.l(i3);
                        z = true;
                    }
                }
                if (!z) {
                    this.f13132a.f13129g.setVisibility(8);
                }
                if (this.f13132a.j < 0) {
                    this.f13132a.setCurrentTab(0);
                    return;
                }
                CommonTabHost commonTabHost = this.f13132a;
                commonTabHost.setCurrentTab(commonTabHost.j);
            }
        }

        @Override // com.baidu.tbadk.editortools.view.CommonTabHost.b
        public void onLoadFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f13132a.m();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a();

        void b(d.a.p0.x.z.a aVar);

        void onLoadFail();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonTabHost(Context context) {
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
        this.f13131i = new ArrayList<>();
        this.j = -1;
        this.k = -1;
        this.m = 0;
        this.n = R.color.common_color_10255;
        this.o = new a(this);
        this.p = false;
        n(context);
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.b
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            setCurrentTab(i2);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setVisibility(0);
        }
    }

    @Override // d.a.p0.x.n
    public void d(d.a.p0.x.a aVar) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) || (editorTools = this.f13127e) == null) {
            return;
        }
        editorTools.A(aVar);
    }

    @Override // com.baidu.tbadk.editortools.view.ICommonTabHost, d.a.p0.x.n
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.m : invokeV.intValue;
    }

    @Override // d.a.p0.x.n
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            setVisibility(8);
        }
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public void k(d.a.p0.x.z.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            aVar.s(this.o);
            aVar.setEditorTools(this.f13127e);
            this.f13131i.add(aVar);
        }
    }

    public final void l(a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.f13129g.b(bVar);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f13130h.setVisibility(8);
        }
    }

    public final void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, context) == null) {
            this.l = context;
            removeAllViews();
            LayoutInflater.from(context).inflate(R.layout.common_tab_host, (ViewGroup) this, true);
            this.f13128f = (CommonTabContentView) findViewById(R.id.common_tab_content);
            this.f13129g = (CommonTabWidgetView) findViewById(R.id.common_tab_widget);
            this.f13130h = (ProgressBar) findViewById(R.id.common_progress);
            this.f13129g.setOnTabSelectedListener(this);
            this.f13129g.setEditorTools(this.f13127e);
            setOrientation(1);
            this.k = TbadkCoreApplication.getInst().getSkinType();
            setBackgroundColorId(R.color.CAM_X0201);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f13130h.setVisibility(0);
        }
    }

    public void onAction(d.a.p0.x.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) {
            Iterator<d.a.p0.x.z.a> it = this.f13131i.iterator();
            while (it.hasNext()) {
                it.next().onAction(aVar);
            }
        }
    }

    @Override // d.a.p0.x.n
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            SkinManager.setBackgroundColor(this, this.n, i2);
            this.f13129g.d(i2);
            this.f13128f.d(i2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onDetachedFromWindow();
            Iterator<d.a.p0.x.z.a> it = this.f13131i.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    public void setBackgroundColorId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            super.setBackgroundColor(getContext().getResources().getColor(i2));
            this.n = i2;
        }
    }

    public void setCurrentTab(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i2) == null) || i2 < 0 || i2 >= this.f13131i.size()) {
            return;
        }
        this.f13128f.e(this.f13131i.get(i2));
        this.f13129g.setCurrentTab(i2);
        this.j = i2;
    }

    @Override // com.baidu.tbadk.editortools.view.ICommonTabHost, d.a.p0.x.n
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, editorTools) == null) {
            this.f13127e = editorTools;
            ArrayList<d.a.p0.x.z.a> arrayList = this.f13131i;
            if (arrayList != null && arrayList.size() != 0) {
                Iterator<d.a.p0.x.z.a> it = this.f13131i.iterator();
                while (it.hasNext()) {
                    it.next().setEditorTools(this.f13127e);
                }
            }
            CommonTabWidgetView commonTabWidgetView = this.f13129g;
            if (commonTabWidgetView != null) {
                commonTabWidgetView.setEditorTools(this.f13127e);
            }
        }
    }

    public void setShowDelete(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.f13129g.setShowDelete(z);
        }
    }

    @Override // com.baidu.tbadk.editortools.view.ICommonTabHost, d.a.p0.x.n
    public void setToolId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.m = i2;
        }
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            super.setVisibility(i2);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType != this.k) {
                this.k = skinType;
                onChangeSkinType(skinType);
            }
            if (i2 == 8 || i2 == 4 || this.p) {
                return;
            }
            this.p = true;
            Iterator<d.a.p0.x.z.a> it = this.f13131i.iterator();
            while (it.hasNext()) {
                it.next().q(this.l);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonTabHost(Context context, AttributeSet attributeSet) {
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
        this.f13131i = new ArrayList<>();
        this.j = -1;
        this.k = -1;
        this.m = 0;
        this.n = R.color.common_color_10255;
        this.o = new a(this);
        this.p = false;
        n(context);
    }
}

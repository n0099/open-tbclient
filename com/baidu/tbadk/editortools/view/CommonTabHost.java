package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.x.a0.a;
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
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class CommonTabHost extends ICommonTabHost implements CommonTabWidgetView.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public EditorTools f48398e;

    /* renamed from: f  reason: collision with root package name */
    public CommonTabContentView f48399f;

    /* renamed from: g  reason: collision with root package name */
    public CommonTabWidgetView f48400g;

    /* renamed from: h  reason: collision with root package name */
    public ProgressBar f48401h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<c.a.q0.x.a0.a> f48402i;

    /* renamed from: j  reason: collision with root package name */
    public int f48403j;
    public int k;
    public Context l;
    public int m;
    public int n;
    public b o;
    public boolean p;

    /* loaded from: classes6.dex */
    public class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CommonTabHost f48404a;

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
            this.f48404a = commonTabHost;
        }

        @Override // com.baidu.tbadk.editortools.view.CommonTabHost.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f48404a.j();
            }
        }

        @Override // com.baidu.tbadk.editortools.view.CommonTabHost.b
        public void b(c.a.q0.x.a0.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.f48404a.h();
                this.f48404a.f48400g.reset();
                this.f48404a.f48400g.setDatas(this.f48404a.f48402i);
                int size = this.f48404a.f48402i.size();
                boolean z = false;
                for (int i2 = 0; i2 < size; i2++) {
                    a.b f2 = ((c.a.q0.x.a0.a) this.f48404a.f48402i.get(i2)).f();
                    if (f2 != null) {
                        this.f48404a.g(f2);
                        z = true;
                    }
                }
                if (!z) {
                    this.f48404a.f48400g.setVisibility(8);
                }
                if (this.f48404a.f48403j < 0) {
                    this.f48404a.setCurrentTab(0);
                    return;
                }
                CommonTabHost commonTabHost = this.f48404a;
                commonTabHost.setCurrentTab(commonTabHost.f48403j);
            }
        }

        @Override // com.baidu.tbadk.editortools.view.CommonTabHost.b
        public void onLoadFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f48404a.h();
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a();

        void b(c.a.q0.x.a0.a aVar);

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
        this.f48402i = new ArrayList<>();
        this.f48403j = -1;
        this.k = -1;
        this.m = 0;
        this.n = R.color.common_color_10255;
        this.o = new a(this);
        this.p = false;
        i(context);
    }

    public void addTab(c.a.q0.x.a0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            aVar.p(this.o);
            aVar.setEditorTools(this.f48398e);
            this.f48402i.add(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.view.ICommonTabHost, c.a.q0.x.n
    public void display() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setVisibility(0);
        }
    }

    public final void g(a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f48400g.addTabWidget(bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.view.ICommonTabHost, c.a.q0.x.n
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.m : invokeV.intValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f48401h.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.editortools.view.ICommonTabHost, c.a.q0.x.n
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            setVisibility(8);
        }
    }

    public final void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            this.l = context;
            removeAllViews();
            LayoutInflater.from(context).inflate(R.layout.common_tab_host, (ViewGroup) this, true);
            this.f48399f = (CommonTabContentView) findViewById(R.id.common_tab_content);
            this.f48400g = (CommonTabWidgetView) findViewById(R.id.common_tab_widget);
            this.f48401h = (ProgressBar) findViewById(R.id.common_progress);
            this.f48400g.setOnTabSelectedListener(this);
            this.f48400g.setEditorTools(this.f48398e);
            setOrientation(1);
            this.k = TbadkCoreApplication.getInst().getSkinType();
            setBackgroundColorId(R.color.CAM_X0201);
        }
    }

    @Override // com.baidu.tbadk.editortools.view.ICommonTabHost, c.a.q0.x.n
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f48401h.setVisibility(0);
        }
    }

    @Override // com.baidu.tbadk.editortools.view.ICommonTabHost, c.a.q0.x.b
    public void onAction(c.a.q0.x.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            Iterator<c.a.q0.x.a0.a> it = this.f48402i.iterator();
            while (it.hasNext()) {
                it.next().onAction(aVar);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.view.ICommonTabHost, c.a.q0.x.n
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            SkinManager.setBackgroundColor(this, this.n, i2);
            this.f48400g.onChangeSkinType(i2);
            this.f48399f.onChangeSkinType(i2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onDetachedFromWindow();
            Iterator<c.a.q0.x.a0.a> it = this.f48402i.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.b
    public void onTabSelected(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            setCurrentTab(i2);
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f48403j = -1;
            this.f48402i.clear();
            this.f48400g.reset();
        }
    }

    @Override // com.baidu.tbadk.editortools.view.ICommonTabHost, c.a.q0.x.n
    public void sendAction(c.a.q0.x.a aVar) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) || (editorTools = this.f48398e) == null) {
            return;
        }
        editorTools.sendAction(aVar);
    }

    public void setBackgroundColorId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            super.setBackgroundColor(getContext().getResources().getColor(i2));
            this.n = i2;
        }
    }

    public void setCurrentTab(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048592, this, i2) == null) || i2 < 0 || i2 >= this.f48402i.size()) {
            return;
        }
        this.f48399f.showContent(this.f48402i.get(i2));
        this.f48400g.setCurrentTab(i2);
        this.f48403j = i2;
    }

    @Override // com.baidu.tbadk.editortools.view.ICommonTabHost, c.a.q0.x.n
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, editorTools) == null) {
            this.f48398e = editorTools;
            ArrayList<c.a.q0.x.a0.a> arrayList = this.f48402i;
            if (arrayList != null && arrayList.size() != 0) {
                Iterator<c.a.q0.x.a0.a> it = this.f48402i.iterator();
                while (it.hasNext()) {
                    it.next().setEditorTools(this.f48398e);
                }
            }
            CommonTabWidgetView commonTabWidgetView = this.f48400g;
            if (commonTabWidgetView != null) {
                commonTabWidgetView.setEditorTools(this.f48398e);
            }
        }
    }

    public void setShowDelete(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.f48400g.setShowDelete(z);
        }
    }

    @Override // com.baidu.tbadk.editortools.view.ICommonTabHost, c.a.q0.x.n
    public void setToolId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.m = i2;
        }
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
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
            Iterator<c.a.q0.x.a0.a> it = this.f48402i.iterator();
            while (it.hasNext()) {
                it.next().n(this.l);
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
        this.f48402i = new ArrayList<>();
        this.f48403j = -1;
        this.k = -1;
        this.m = 0;
        this.n = R.color.common_color_10255;
        this.o = new a(this);
        this.p = false;
        i(context);
    }
}

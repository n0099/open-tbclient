package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.x.b0.a;
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
/* loaded from: classes11.dex */
public class CommonTabHost extends ICommonTabHost implements CommonTabWidgetView.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public EditorTools f42494e;

    /* renamed from: f  reason: collision with root package name */
    public CommonTabContentView f42495f;

    /* renamed from: g  reason: collision with root package name */
    public CommonTabWidgetView f42496g;

    /* renamed from: h  reason: collision with root package name */
    public ProgressBar f42497h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<c.a.s0.x.b0.a> f42498i;

    /* renamed from: j  reason: collision with root package name */
    public int f42499j;

    /* renamed from: k  reason: collision with root package name */
    public int f42500k;
    public Context l;
    public int m;
    public int n;
    public b o;
    public boolean p;

    /* loaded from: classes11.dex */
    public class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CommonTabHost a;

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
            this.a = commonTabHost;
        }

        @Override // com.baidu.tbadk.editortools.view.CommonTabHost.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.j();
            }
        }

        @Override // com.baidu.tbadk.editortools.view.CommonTabHost.b
        public void b(c.a.s0.x.b0.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.a.h();
                this.a.f42496g.reset();
                this.a.f42496g.setDatas(this.a.f42498i);
                int size = this.a.f42498i.size();
                boolean z = false;
                for (int i2 = 0; i2 < size; i2++) {
                    a.b f2 = ((c.a.s0.x.b0.a) this.a.f42498i.get(i2)).f();
                    if (f2 != null) {
                        this.a.g(f2);
                        z = true;
                    }
                }
                if (!z) {
                    this.a.f42496g.setVisibility(8);
                }
                if (this.a.f42499j < 0) {
                    this.a.setCurrentTab(0);
                    return;
                }
                CommonTabHost commonTabHost = this.a;
                commonTabHost.setCurrentTab(commonTabHost.f42499j);
            }
        }

        @Override // com.baidu.tbadk.editortools.view.CommonTabHost.b
        public void onLoadFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.h();
            }
        }
    }

    /* loaded from: classes11.dex */
    public interface b {
        void a();

        void b(c.a.s0.x.b0.a aVar);

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
        this.f42498i = new ArrayList<>();
        this.f42499j = -1;
        this.f42500k = -1;
        this.m = 0;
        this.n = R.color.common_color_10255;
        this.o = new a(this);
        this.p = false;
        i(context);
    }

    public void addTab(c.a.s0.x.b0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            aVar.p(this.o);
            aVar.setEditorTools(this.f42494e);
            this.f42498i.add(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.view.ICommonTabHost, c.a.s0.x.n
    public void display() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setVisibility(0);
        }
    }

    public final void g(a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f42496g.addTabWidget(bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.view.ICommonTabHost, c.a.s0.x.n
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.m : invokeV.intValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f42497h.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.editortools.view.ICommonTabHost, c.a.s0.x.n
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
            this.f42495f = (CommonTabContentView) findViewById(R.id.common_tab_content);
            this.f42496g = (CommonTabWidgetView) findViewById(R.id.common_tab_widget);
            this.f42497h = (ProgressBar) findViewById(R.id.common_progress);
            this.f42496g.setOnTabSelectedListener(this);
            this.f42496g.setEditorTools(this.f42494e);
            setOrientation(1);
            this.f42500k = TbadkCoreApplication.getInst().getSkinType();
            setBackgroundColorId(R.color.CAM_X0201);
        }
    }

    @Override // com.baidu.tbadk.editortools.view.ICommonTabHost, c.a.s0.x.n
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f42497h.setVisibility(0);
        }
    }

    @Override // com.baidu.tbadk.editortools.view.ICommonTabHost, c.a.s0.x.b
    public void onAction(c.a.s0.x.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            Iterator<c.a.s0.x.b0.a> it = this.f42498i.iterator();
            while (it.hasNext()) {
                it.next().onAction(aVar);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.view.ICommonTabHost, c.a.s0.x.n
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            SkinManager.setBackgroundColor(this, this.n, i2);
            this.f42496g.onChangeSkinType(i2);
            this.f42495f.onChangeSkinType(i2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onDetachedFromWindow();
            Iterator<c.a.s0.x.b0.a> it = this.f42498i.iterator();
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
            this.f42499j = -1;
            this.f42498i.clear();
            this.f42496g.reset();
        }
    }

    @Override // com.baidu.tbadk.editortools.view.ICommonTabHost, c.a.s0.x.n
    public void sendAction(c.a.s0.x.a aVar) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) || (editorTools = this.f42494e) == null) {
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
        if (!(interceptable == null || interceptable.invokeI(1048592, this, i2) == null) || i2 < 0 || i2 >= this.f42498i.size()) {
            return;
        }
        this.f42495f.showContent(this.f42498i.get(i2));
        this.f42496g.setCurrentTab(i2);
        this.f42499j = i2;
    }

    @Override // com.baidu.tbadk.editortools.view.ICommonTabHost, c.a.s0.x.n
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, editorTools) == null) {
            this.f42494e = editorTools;
            ArrayList<c.a.s0.x.b0.a> arrayList = this.f42498i;
            if (arrayList != null && arrayList.size() != 0) {
                Iterator<c.a.s0.x.b0.a> it = this.f42498i.iterator();
                while (it.hasNext()) {
                    it.next().setEditorTools(this.f42494e);
                }
            }
            CommonTabWidgetView commonTabWidgetView = this.f42496g;
            if (commonTabWidgetView != null) {
                commonTabWidgetView.setEditorTools(this.f42494e);
            }
        }
    }

    public void setShowDelete(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.f42496g.setShowDelete(z);
        }
    }

    @Override // com.baidu.tbadk.editortools.view.ICommonTabHost, c.a.s0.x.n
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
            if (skinType != this.f42500k) {
                this.f42500k = skinType;
                onChangeSkinType(skinType);
            }
            if (i2 == 8 || i2 == 4 || this.p) {
                return;
            }
            this.p = true;
            Iterator<c.a.s0.x.b0.a> it = this.f42498i.iterator();
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
        this.f42498i = new ArrayList<>();
        this.f42499j = -1;
        this.f42500k = -1;
        this.m = 0;
        this.n = R.color.common_color_10255;
        this.o = new a(this);
        this.p = false;
        i(context);
    }
}

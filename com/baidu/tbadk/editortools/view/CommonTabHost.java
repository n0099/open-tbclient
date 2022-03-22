package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.w.b0.a;
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
/* loaded from: classes5.dex */
public class CommonTabHost extends ICommonTabHost implements CommonTabWidgetView.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EditorTools a;

    /* renamed from: b  reason: collision with root package name */
    public CommonTabContentView f30555b;

    /* renamed from: c  reason: collision with root package name */
    public CommonTabWidgetView f30556c;

    /* renamed from: d  reason: collision with root package name */
    public ProgressBar f30557d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<c.a.o0.w.b0.a> f30558e;

    /* renamed from: f  reason: collision with root package name */
    public int f30559f;

    /* renamed from: g  reason: collision with root package name */
    public int f30560g;

    /* renamed from: h  reason: collision with root package name */
    public Context f30561h;
    public int i;
    public int j;
    public b k;
    public boolean l;

    /* loaded from: classes5.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                this.a.o();
            }
        }

        @Override // com.baidu.tbadk.editortools.view.CommonTabHost.b
        public void b(c.a.o0.w.b0.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.a.m();
                this.a.f30556c.e();
                this.a.f30556c.setDatas(this.a.f30558e);
                int size = this.a.f30558e.size();
                boolean z = false;
                for (int i = 0; i < size; i++) {
                    a.b i2 = ((c.a.o0.w.b0.a) this.a.f30558e.get(i)).i();
                    if (i2 != null) {
                        this.a.l(i2);
                        z = true;
                    }
                }
                if (!z) {
                    this.a.f30556c.setVisibility(8);
                }
                if (this.a.f30559f < 0) {
                    this.a.setCurrentTab(0);
                    return;
                }
                CommonTabHost commonTabHost = this.a;
                commonTabHost.setCurrentTab(commonTabHost.f30559f);
            }
        }

        @Override // com.baidu.tbadk.editortools.view.CommonTabHost.b
        public void onLoadFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.m();
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a();

        void b(c.a.o0.w.b0.a aVar);

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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30558e = new ArrayList<>();
        this.f30559f = -1;
        this.f30560g = -1;
        this.i = 0;
        this.j = R.color.common_color_10255;
        this.k = new a(this);
        this.l = false;
        n(context);
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.b
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            setCurrentTab(i);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setVisibility(0);
        }
    }

    @Override // c.a.o0.w.n
    public void d(c.a.o0.w.a aVar) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) || (editorTools = this.a) == null) {
            return;
        }
        editorTools.A(aVar);
    }

    @Override // com.baidu.tbadk.editortools.view.ICommonTabHost, c.a.o0.w.n
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.i : invokeV.intValue;
    }

    @Override // c.a.o0.w.n
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

    public void k(c.a.o0.w.b0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            aVar.s(this.k);
            aVar.setEditorTools(this.a);
            this.f30558e.add(aVar);
        }
    }

    public final void l(a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.f30556c.b(bVar);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f30557d.setVisibility(8);
        }
    }

    public final void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, context) == null) {
            this.f30561h = context;
            removeAllViews();
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d01f4, (ViewGroup) this, true);
            this.f30555b = (CommonTabContentView) findViewById(R.id.obfuscated_res_0x7f0906a4);
            this.f30556c = (CommonTabWidgetView) findViewById(R.id.obfuscated_res_0x7f0906a5);
            this.f30557d = (ProgressBar) findViewById(R.id.obfuscated_res_0x7f0906a3);
            this.f30556c.setOnTabSelectedListener(this);
            this.f30556c.setEditorTools(this.a);
            setOrientation(1);
            this.f30560g = TbadkCoreApplication.getInst().getSkinType();
            setBackgroundColorId(R.color.CAM_X0201);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f30557d.setVisibility(0);
        }
    }

    public void onAction(c.a.o0.w.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) {
            Iterator<c.a.o0.w.b0.a> it = this.f30558e.iterator();
            while (it.hasNext()) {
                it.next().onAction(aVar);
            }
        }
    }

    @Override // c.a.o0.w.n
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            SkinManager.setBackgroundColor(this, this.j, i);
            this.f30556c.d(i);
            this.f30555b.d(i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onDetachedFromWindow();
            Iterator<c.a.o0.w.b0.a> it = this.f30558e.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    public void setBackgroundColorId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            super.setBackgroundColor(getContext().getResources().getColor(i));
            this.j = i;
        }
    }

    public void setCurrentTab(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i) == null) || i < 0 || i >= this.f30558e.size()) {
            return;
        }
        this.f30555b.e(this.f30558e.get(i));
        this.f30556c.setCurrentTab(i);
        this.f30559f = i;
    }

    @Override // com.baidu.tbadk.editortools.view.ICommonTabHost, c.a.o0.w.n
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, editorTools) == null) {
            this.a = editorTools;
            ArrayList<c.a.o0.w.b0.a> arrayList = this.f30558e;
            if (arrayList != null && arrayList.size() != 0) {
                Iterator<c.a.o0.w.b0.a> it = this.f30558e.iterator();
                while (it.hasNext()) {
                    it.next().setEditorTools(this.a);
                }
            }
            CommonTabWidgetView commonTabWidgetView = this.f30556c;
            if (commonTabWidgetView != null) {
                commonTabWidgetView.setEditorTools(this.a);
            }
        }
    }

    public void setShowDelete(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.f30556c.setShowDelete(z);
        }
    }

    @Override // com.baidu.tbadk.editortools.view.ICommonTabHost, c.a.o0.w.n
    public void setToolId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.i = i;
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            super.setVisibility(i);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType != this.f30560g) {
                this.f30560g = skinType;
                onChangeSkinType(skinType);
            }
            if (i == 8 || i == 4 || this.l) {
                return;
            }
            this.l = true;
            Iterator<c.a.o0.w.b0.a> it = this.f30558e.iterator();
            while (it.hasNext()) {
                it.next().q(this.f30561h);
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
        this.f30558e = new ArrayList<>();
        this.f30559f = -1;
        this.f30560g = -1;
        this.i = 0;
        this.j = R.color.common_color_10255;
        this.k = new a(this);
        this.l = false;
        n(context);
    }
}

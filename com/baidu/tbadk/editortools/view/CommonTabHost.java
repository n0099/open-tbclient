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
import com.baidu.tieba.k65;
import com.baidu.tieba.w85;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class CommonTabHost extends ICommonTabHost implements CommonTabWidgetView.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EditorTools a;
    public CommonTabContentView b;
    public CommonTabWidgetView c;
    public ProgressBar d;
    public ArrayList<w85> e;
    public int f;
    public int g;
    public Context h;
    public int i;
    public int j;
    public b k;
    public boolean l;

    /* loaded from: classes3.dex */
    public interface b {
        void a();

        void b(w85 w85Var);

        void onLoadFail();
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    /* loaded from: classes3.dex */
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
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.l();
        }

        @Override // com.baidu.tbadk.editortools.view.CommonTabHost.b
        public void onLoadFail() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) {
                return;
            }
            this.a.j();
        }

        @Override // com.baidu.tbadk.editortools.view.CommonTabHost.b
        public void b(w85 w85Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, w85Var) == null) {
                this.a.j();
                this.a.c.e();
                this.a.c.setDatas(this.a.e);
                int size = this.a.e.size();
                boolean z = false;
                for (int i = 0; i < size; i++) {
                    w85.b f = ((w85) this.a.e.get(i)).f();
                    if (f != null) {
                        this.a.i(f);
                        z = true;
                    }
                }
                if (!z) {
                    this.a.c.setVisibility(8);
                }
                if (this.a.f < 0) {
                    this.a.setCurrentTab(0);
                    return;
                }
                CommonTabHost commonTabHost = this.a;
                commonTabHost.setCurrentTab(commonTabHost.f);
            }
        }
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
        this.e = new ArrayList<>();
        this.f = -1;
        this.g = -1;
        this.i = 0;
        this.j = R.color.common_color_10255;
        this.k = new a(this);
        this.l = false;
        k(context);
    }

    public final void k(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, context) == null) {
            this.h = context;
            removeAllViews();
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d01ea, (ViewGroup) this, true);
            this.b = (CommonTabContentView) findViewById(R.id.obfuscated_res_0x7f0906b7);
            this.c = (CommonTabWidgetView) findViewById(R.id.obfuscated_res_0x7f0906b8);
            this.d = (ProgressBar) findViewById(R.id.obfuscated_res_0x7f0906b5);
            this.c.setOnTabSelectedListener(this);
            this.c.setEditorTools(this.a);
            setOrientation(1);
            this.g = TbadkCoreApplication.getInst().getSkinType();
            setBackgroundColorId(R.color.CAM_X0201);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            super.setVisibility(i);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType != this.g) {
                this.g = skinType;
                onChangeSkinType(skinType);
            }
            if (i == 8 || i == 4 || this.l) {
                return;
            }
            this.l = true;
            Iterator<w85> it = this.e.iterator();
            while (it.hasNext()) {
                it.next().n(this.h);
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
        this.e = new ArrayList<>();
        this.f = -1;
        this.g = -1;
        this.i = 0;
        this.j = R.color.common_color_10255;
        this.k = new a(this);
        this.l = false;
        k(context);
    }

    public void B(k65 k65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, k65Var) == null) {
            Iterator<w85> it = this.e.iterator();
            while (it.hasNext()) {
                it.next().B(k65Var);
            }
        }
    }

    @Override // com.baidu.tieba.w65
    public void K(k65 k65Var) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k65Var) == null) && (editorTools = this.a) != null) {
            editorTools.A(k65Var);
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.b
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            setCurrentTab(i);
        }
    }

    public void h(w85 w85Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, w85Var) == null) {
            w85Var.p(this.k);
            w85Var.setEditorTools(this.a);
            this.e.add(w85Var);
        }
    }

    public final void i(w85.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.c.b(bVar);
        }
    }

    @Override // com.baidu.tieba.w65
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            SkinManager.setBackgroundColor(this, this.j, i);
            this.c.d(i);
            this.b.d(i);
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
        if ((interceptable == null || interceptable.invokeI(1048591, this, i) == null) && i >= 0 && i < this.e.size()) {
            this.b.e(this.e.get(i));
            this.c.setCurrentTab(i);
            this.f = i;
        }
    }

    public void setShowDelete(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.c.setShowDelete(z);
        }
    }

    @Override // com.baidu.tbadk.editortools.view.ICommonTabHost, com.baidu.tieba.w65
    public void setToolId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.i = i;
        }
    }

    public void display() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            setVisibility(0);
        }
    }

    @Override // com.baidu.tbadk.editortools.view.ICommonTabHost, com.baidu.tieba.w65
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.i;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.w65
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            setVisibility(8);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.d.setVisibility(8);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.d.setVisibility(0);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onDetachedFromWindow();
            Iterator<w85> it = this.e.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.view.ICommonTabHost, com.baidu.tieba.w65
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, editorTools) == null) {
            this.a = editorTools;
            ArrayList<w85> arrayList = this.e;
            if (arrayList != null && arrayList.size() != 0) {
                Iterator<w85> it = this.e.iterator();
                while (it.hasNext()) {
                    it.next().setEditorTools(this.a);
                }
            }
            CommonTabWidgetView commonTabWidgetView = this.c;
            if (commonTabWidgetView != null) {
                commonTabWidgetView.setEditorTools(this.a);
            }
        }
    }
}

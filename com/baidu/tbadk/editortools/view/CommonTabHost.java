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
import com.baidu.tieba.cf5;
import com.baidu.tieba.pc5;
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
    public ArrayList<cf5> e;
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

        void b(cf5 cf5Var);

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
        public void b(cf5 cf5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cf5Var) == null) {
                this.a.j();
                this.a.c.e();
                this.a.c.setDatas(this.a.e);
                int size = this.a.e.size();
                boolean z = false;
                for (int i = 0; i < size; i++) {
                    cf5.b f = ((cf5) this.a.e.get(i)).f();
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
            LayoutInflater.from(context).inflate(R.layout.common_tab_host, (ViewGroup) this, true);
            this.b = (CommonTabContentView) findViewById(R.id.common_tab_content);
            this.c = (CommonTabWidgetView) findViewById(R.id.common_tab_widget);
            this.d = (ProgressBar) findViewById(R.id.common_progress);
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
            Iterator<cf5> it = this.e.iterator();
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

    public void C(pc5 pc5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pc5Var) == null) {
            Iterator<cf5> it = this.e.iterator();
            while (it.hasNext()) {
                it.next().C(pc5Var);
            }
        }
    }

    @Override // com.baidu.tieba.bd5
    public void H(pc5 pc5Var) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pc5Var) == null) && (editorTools = this.a) != null) {
            editorTools.C(pc5Var);
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.b
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            setCurrentTab(i);
        }
    }

    public void h(cf5 cf5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cf5Var) == null) {
            cf5Var.p(this.k);
            cf5Var.setEditorTools(this.a);
            this.e.add(cf5Var);
        }
    }

    public final void i(cf5.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.c.b(bVar);
        }
    }

    @Override // com.baidu.tieba.bd5
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

    @Override // com.baidu.tbadk.editortools.view.ICommonTabHost, com.baidu.tieba.bd5
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

    @Override // com.baidu.tbadk.editortools.view.ICommonTabHost, com.baidu.tieba.bd5
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.i;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.bd5
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
            Iterator<cf5> it = this.e.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.view.ICommonTabHost, com.baidu.tieba.bd5
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, editorTools) == null) {
            this.a = editorTools;
            ArrayList<cf5> arrayList = this.e;
            if (arrayList != null && arrayList.size() != 0) {
                Iterator<cf5> it = this.e.iterator();
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

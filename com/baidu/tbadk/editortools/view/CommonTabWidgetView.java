package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.w.z.a;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class CommonTabWidgetView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public CommonTabHorizonScrollView f13067e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f13068f;

    /* renamed from: g  reason: collision with root package name */
    public EditorTools f13069g;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CommonTabWidgetView f13070e;

        public a(CommonTabWidgetView commonTabWidgetView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonTabWidgetView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13070e = commonTabWidgetView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f13070e.f13069g == null) {
                return;
            }
            this.f13070e.f13069g.A(new d.a.r0.w.a(3, 3, null));
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(int i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonTabWidgetView(Context context, AttributeSet attributeSet) {
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
        c(context);
    }

    public void b(a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f13067e.b(bVar);
        }
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            setVisibility(8);
            removeAllViews();
            LayoutInflater.from(context).inflate(R.layout.common_tab_widget, (ViewGroup) this, true);
            this.f13067e = (CommonTabHorizonScrollView) findViewById(R.id.privilege_tab_scroll_view);
            ImageView imageView = (ImageView) findViewById(R.id.privilege_tab_delete);
            this.f13068f = imageView;
            imageView.setOnClickListener(new a(this));
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            SkinManager.setBackgroundColor(this, R.color.common_color_10223, i2);
            this.f13067e.e(i2);
            SkinManager.setImageResource(this.f13068f, R.drawable.but_face_close, i2);
            SkinManager.setBackgroundColor(this.f13068f, R.color.common_color_10224, i2);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f13067e.f();
        }
    }

    public void setCurrentTab(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f13067e.setCurrentTab(i2);
        }
    }

    public void setDatas(ArrayList<d.a.r0.w.z.a> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            this.f13067e.setDatas(arrayList);
            if (arrayList != null && arrayList.size() > 1) {
                setVisibility(0);
            } else {
                setVisibility(8);
            }
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, editorTools) == null) {
            this.f13069g = editorTools;
        }
    }

    public void setOnTabSelectedListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.f13067e.setOnTabSelectedListener(bVar);
        }
    }

    public void setShowDelete(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            if (z) {
                this.f13068f.setVisibility(0);
            } else {
                this.f13068f.setVisibility(8);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonTabWidgetView(Context context) {
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
        c(context);
    }
}

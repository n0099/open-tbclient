package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.UserCollectManageActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class EmotionTabWidgetView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public EmotionTabHorizonScrollView f14583e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f14584f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f14585g;

    /* renamed from: h  reason: collision with root package name */
    public View f14586h;

    /* renamed from: i  reason: collision with root package name */
    public EditorTools f14587i;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EmotionTabWidgetView f14588e;

        public a(EmotionTabWidgetView emotionTabWidgetView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionTabWidgetView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14588e = emotionTabWidgetView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f14588e.f14587i == null) {
                return;
            }
            this.f14588e.f14587i.A(new d.a.r0.w.a(3, -1, null));
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EmotionTabWidgetView f14589e;

        public b(EmotionTabWidgetView emotionTabWidgetView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionTabWidgetView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14589e = emotionTabWidgetView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UserCollectManageActivityConfig(this.f14589e.getContext())));
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(int i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmotionTabWidgetView(Context context, AttributeSet attributeSet) {
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

    public void b(d.a.r0.w.p.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            this.f14583e.j(cVar);
        }
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            removeAllViews();
            LayoutInflater.from(context).inflate(R.layout.emotion_tab_widget, (ViewGroup) this, true);
            this.f14583e = (EmotionTabHorizonScrollView) findViewById(R.id.face_tab_scroll_view);
            this.f14584f = (ImageView) findViewById(R.id.face_tab_delete);
            this.f14585g = (ImageView) findViewById(R.id.face_tab_setting);
            this.f14586h = findViewById(R.id.vertical_div_line);
            this.f14584f.setOnClickListener(new a(this));
            this.f14585g.setOnClickListener(new b(this));
            this.f14585g.setVisibility(8);
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            SkinManager.setBackgroundColor(this, R.color.common_color_10255, i2);
            this.f14583e.n(i2);
            SkinManager.setImageResource(this.f14584f, R.drawable.emotion_delete, i2);
            SkinManager.setBackgroundColor(this.f14584f, R.color.common_color_10255, i2);
            SkinManager.setImageResource(this.f14585g, R.drawable.icon_sett_s, i2);
            SkinManager.setBackgroundColor(this.f14585g, R.color.common_color_10255, i2);
            SkinManager.setBackgroundColor(this.f14586h, R.color.common_color_10288, i2);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f14583e.o();
        }
    }

    public void setCurrentTab(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f14583e.setCurrentTab(i2);
        }
    }

    public void setDatas(ArrayList<d.a.r0.w.p.c> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            this.f14583e.setDatas(arrayList);
        }
    }

    public void setFrom(int i2) {
        EmotionTabHorizonScrollView emotionTabHorizonScrollView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || (emotionTabHorizonScrollView = this.f14583e) == null) {
            return;
        }
        emotionTabHorizonScrollView.setFrom(i2);
    }

    public void setOnDataSelected(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, editorTools) == null) {
            this.f14587i = editorTools;
            this.f14583e.setEditorTools(editorTools);
        }
    }

    public void setOnTabSelectedListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
            this.f14583e.setOnTabSelectedListener(cVar);
        }
    }

    public void setShowDelete(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            if (z) {
                this.f14584f.setVisibility(0);
            } else {
                this.f14584f.setVisibility(8);
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f14583e.setTabWidgetBigEmontionVisibility(z);
        }
    }

    public void setTabWidgetVisibility(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.f14583e.setTabWidgetVisibility(i2, z);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmotionTabWidgetView(Context context) {
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

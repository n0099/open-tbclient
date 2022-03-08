package com.baidu.tieba.flutter.base.view;

import android.content.Context;
import android.view.ViewStructure;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.idlefish.flutterboost.FlutterBoost;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import java.lang.reflect.Field;
/* loaded from: classes5.dex */
public class TbFlutterView extends FlutterView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbFlutterView(@NonNull Context context) {
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
    }

    private void setPadding() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            try {
                Field declaredField = FlutterView.class.getDeclaredField("viewportMetrics");
                declaredField.setAccessible(true);
                FlutterRenderer.ViewportMetrics viewportMetrics = (FlutterRenderer.ViewportMetrics) declaredField.get(this);
                if (viewportMetrics != null) {
                    viewportMetrics.viewPaddingTop = UtilHelper.getStatusBarHeight();
                    FlutterBoost.instance().engineProvider().getRenderer().setViewportMetrics(viewportMetrics);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // io.flutter.embedding.android.FlutterView, android.view.View
    public void onProvideAutofillVirtualStructure(ViewStructure viewStructure, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, viewStructure, i2) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbFlutterView(@NonNull Context context, @NonNull FlutterView.RenderMode renderMode, @NonNull FlutterView.TransparencyMode transparencyMode) {
        super(context, renderMode, transparencyMode);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, renderMode, transparencyMode};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (FlutterView.RenderMode) objArr2[1], (FlutterView.TransparencyMode) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        setPadding();
    }
}

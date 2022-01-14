package com.baidu.tieba.flutter.plugin.progressHUD;

import androidx.annotation.NonNull;
import c.a.d.a.h;
import c.a.d.f.p.n;
import c.a.t0.z0.a.i.f;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.flutter.plugin.progressHUD.ProgressHUDAuto;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
/* loaded from: classes12.dex */
public class ProgressHUDPlugin implements FlutterPlugin, ProgressHUDAuto.HostProgressHUD {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ProgressHUDPlugin() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private String getAndroidNameFromIos(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) ? str : (String) invokeL.objValue;
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, flutterPluginBinding) == null) {
            f.f(flutterPluginBinding.getBinaryMessenger(), this);
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, flutterPluginBinding) == null) {
            f.f(flutterPluginBinding.getBinaryMessenger(), null);
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.progressHUD.ProgressHUDAuto.HostProgressHUD
    public void showAttentionWithStatus(ProgressHUDAuto.StringParam stringParam) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, stringParam) == null) {
            n.N(TbadkCoreApplication.getInst().getCurrentActivity(), stringParam.getStatus());
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.progressHUD.ProgressHUDAuto.HostProgressHUD
    public void showAttentionWithStatusForTime(ProgressHUDAuto.AttentionTimeParam attentionTimeParam) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, attentionTimeParam) == null) {
            n.O(TbadkCoreApplication.getInst().getCurrentActivity(), attentionTimeParam.getStatus(), attentionTimeParam.getTime().intValue());
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.progressHUD.ProgressHUDAuto.HostProgressHUD
    public void showErrorWithStatus(ProgressHUDAuto.StringParam stringParam) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, stringParam) == null) {
            n.N(TbadkCoreApplication.getInst().getCurrentActivity(), stringParam.getStatus());
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.progressHUD.ProgressHUDAuto.HostProgressHUD
    public void showSuccessWithStatus(ProgressHUDAuto.StringParam stringParam) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, stringParam) == null) {
            n.N(TbadkCoreApplication.getInst().getCurrentActivity(), stringParam.getStatus());
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.progressHUD.ProgressHUDAuto.HostProgressHUD
    public void showWithImg(ProgressHUDAuto.ImageParam imageParam) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, imageParam) == null) {
            String image = imageParam.getImage();
            String text = imageParam.getText();
            Boolean isSvg = imageParam.getIsSvg();
            BdToast.i(TbadkCoreApplication.getInst().getCurrentActivity(), text, h.a().getResources().getIdentifier(getAndroidNameFromIos(image), "drawable", BdBaseApplication.getInst().getPackageName()), isSvg.booleanValue()).q();
        }
    }
}

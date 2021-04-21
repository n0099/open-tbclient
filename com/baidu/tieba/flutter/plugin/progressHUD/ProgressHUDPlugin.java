package com.baidu.tieba.flutter.plugin.progressHUD;

import androidx.annotation.NonNull;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.flutter.plugin.progressHUD.ProgressHUDAuto;
import d.b.c.a.h;
import d.b.c.e.p.l;
import d.b.j0.m0.a.h.f;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
/* loaded from: classes4.dex */
public class ProgressHUDPlugin implements FlutterPlugin, ProgressHUDAuto.HostProgressHUD {
    private String getAndroidNameFromIos(String str) {
        return str;
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        f.f(flutterPluginBinding.getBinaryMessenger(), this);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        f.f(flutterPluginBinding.getBinaryMessenger(), null);
    }

    @Override // com.baidu.tieba.flutter.plugin.progressHUD.ProgressHUDAuto.HostProgressHUD
    public void showAttentionWithStatus(ProgressHUDAuto.StringParam stringParam) {
        l.L(TbadkCoreApplication.getInst().getCurrentActivity(), stringParam.getStatus());
    }

    @Override // com.baidu.tieba.flutter.plugin.progressHUD.ProgressHUDAuto.HostProgressHUD
    public void showAttentionWithStatusForTime(ProgressHUDAuto.AttentionTimeParam attentionTimeParam) {
        l.M(TbadkCoreApplication.getInst().getCurrentActivity(), attentionTimeParam.getStatus(), attentionTimeParam.getTime().intValue());
    }

    @Override // com.baidu.tieba.flutter.plugin.progressHUD.ProgressHUDAuto.HostProgressHUD
    public void showErrorWithStatus(ProgressHUDAuto.StringParam stringParam) {
        l.L(TbadkCoreApplication.getInst().getCurrentActivity(), stringParam.getStatus());
    }

    @Override // com.baidu.tieba.flutter.plugin.progressHUD.ProgressHUDAuto.HostProgressHUD
    public void showSuccessWithStatus(ProgressHUDAuto.StringParam stringParam) {
        l.L(TbadkCoreApplication.getInst().getCurrentActivity(), stringParam.getStatus());
    }

    @Override // com.baidu.tieba.flutter.plugin.progressHUD.ProgressHUDAuto.HostProgressHUD
    public void showWithImg(ProgressHUDAuto.ImageParam imageParam) {
        String image = imageParam.getImage();
        String text = imageParam.getText();
        Boolean isSvg = imageParam.getIsSvg();
        BdToast.i(TbadkCoreApplication.getInst().getCurrentActivity(), text, h.a().b().getIdentifier(getAndroidNameFromIos(image), "drawable", BdBaseApplication.getInst().getPackageName()), isSvg.booleanValue()).q();
    }
}

package com.baidu.tieba.flutter.plugin.imagePicker;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.util.sp.PreferenceUtils;
import com.baidu.permissionhelper.app.ActivityCompat;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.flutter.plugin.imagePicker.ImagePickerAuto;
import com.baidu.tieba.flutter.plugin.imagePicker.PostAsyncTask;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import com.kwai.video.player.PlayerPostEvent;
import d.b.i0.z0.q;
import d.b.j0.m0.a.d.e;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class ImagePickerPlugin implements FlutterPlugin, ImagePickerAuto.HostImagePicker {
    public static final String ACTION = "com.tieba.action.ImagePickerPlugin";
    public static String barId = null;
    public static BroadcastReciver broadcastReciver = null;
    public static Activity currentActivity = null;
    public static boolean isEditHeadImage = false;
    public static boolean onlyNeedImageUrl = false;
    public static double scaleRate = 1.0d;
    public PostAsyncTask.PostCallback callback = new PostAsyncTask.PostCallback() { // from class: com.baidu.tieba.flutter.plugin.imagePicker.ImagePickerPlugin.2
        @Override // com.baidu.tieba.flutter.plugin.imagePicker.PostAsyncTask.PostCallback
        public void onFailure(PostAsyncTask.ResultData resultData) {
            if (resultData == null) {
                return;
            }
            ImagePickerPlugin.this.notifyFlutter(resultData.error_code, resultData.error_msg, resultData.url);
        }

        @Override // com.baidu.tieba.flutter.plugin.imagePicker.PostAsyncTask.PostCallback
        public void onSuccess(PostAsyncTask.ResultData resultData) {
            if (resultData == null) {
                return;
            }
            ImagePickerPlugin.this.notifyFlutter(resultData.error_code, "提交成功，我们会尽快完成审核", resultData.url);
        }
    };
    public CustomMessageListener mAlbumResultListener = new CustomMessageListener(2921464) { // from class: com.baidu.tieba.flutter.plugin.imagePicker.ImagePickerPlugin.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Intent intent;
            String stringExtra;
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2921464 || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Intent) || (stringExtra = (intent = (Intent) customResponsedMessage.getData()).getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) == null) {
                return;
            }
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
            writeImagesInfo.parseJson(stringExtra);
            writeImagesInfo.updateQuality();
            if (ListUtils.isEmpty(writeImagesInfo.getChosedFiles())) {
                return;
            }
            if (ImagePickerPlugin.isEditHeadImage) {
                EditHeadActivityConfig editHeadActivityConfig = new EditHeadActivityConfig((Context) ImagePickerPlugin.currentActivity, (int) PlayerPostEvent.MEDIA_REP_CHANGE_END, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, writeImagesInfo.getChosedFiles().get(0).getFilePath(), (float) ImagePickerPlugin.scaleRate, true);
                editHeadActivityConfig.setWaterMaskType(3);
                editHeadActivityConfig.setFromWhere(EditHeadActivityConfig.FROM_FLUTTER_IMAGEPICKER);
                editHeadActivityConfig.setNeedPaste(true);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, editHeadActivityConfig));
                return;
            }
            EditHeadActivityConfig editHeadActivityConfig2 = new EditHeadActivityConfig((Context) ImagePickerPlugin.currentActivity, (int) PlayerPostEvent.MEDIA_REP_CHANGE_END, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 4, writeImagesInfo.getChosedFiles().get(0).getFilePath(), (float) ImagePickerPlugin.scaleRate, true);
            editHeadActivityConfig2.setWaterMaskType(3);
            editHeadActivityConfig2.setFromWhere(EditHeadActivityConfig.FROM_FLUTTER_IMAGEPICKER);
            editHeadActivityConfig2.setNeedPaste(false);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, editHeadActivityConfig2));
        }
    };

    /* loaded from: classes4.dex */
    public class BroadcastReciver extends BroadcastReceiver {
        public BroadcastReciver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && "com.tieba.action.ImagePickerPlugin".equals(intent.getAction())) {
                if (intent.getBooleanExtra("isHeadImage", false)) {
                    if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001380));
                        return;
                    }
                    return;
                }
                PhotoUrlData photoUrlData = (PhotoUrlData) intent.getSerializableExtra("pic_info");
                if (photoUrlData == null || !TbadkCoreApplication.getInst().isMainProcess(true)) {
                    return;
                }
                String originPic = photoUrlData.getOriginPic();
                if (ImagePickerPlugin.onlyNeedImageUrl) {
                    ImagePickerPlugin.this.notifyFlutter(0, "", originPic);
                } else {
                    new PostAsyncTask(originPic, ImagePickerPlugin.barId, ImagePickerPlugin.this.callback).execute(new String[0]);
                }
            }
        }
    }

    private void downloadImage(String str) {
        if (currentActivity == null || str == null) {
            return;
        }
        q qVar = new q(currentActivity, str, new q.a() { // from class: com.baidu.tieba.flutter.plugin.imagePicker.ImagePickerPlugin.1
            @Override // d.b.i0.z0.q.a
            public void onError(int i, String str2) {
                ImagePickerPlugin.this.notifyFlutter(i, str2, "");
            }

            @Override // d.b.i0.z0.q.a
            public void onSuccess(String str2) {
                ImagePickerPlugin.this.notifyFlutter(0, "保存成功！", "");
            }
        });
        qVar.o(false);
        qVar.q(true);
        qVar.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyFlutter(int i, String str, String str2) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("imgUrl", str2);
        }
        hashMap.put("msg", str);
        hashMap.put("errorcode", String.valueOf(i));
        HashMap hashMap2 = new HashMap();
        if (onlyNeedImageUrl) {
            hashMap2.put("uniqueKey", "kUpDateBaHeadNSNotificationBarBroadcast");
        } else {
            hashMap2.put("uniqueKey", "kUpDateBaHeadNSNotification");
        }
        hashMap2.put("data", hashMap);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921540, hashMap2));
    }

    private void registerBroadcastReciver() {
        try {
            broadcastReciver = new BroadcastReciver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.tieba.action.ImagePickerPlugin");
            TbadkCoreApplication.getInst().registerReceiver(broadcastReciver, intentFilter);
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }

    private void unRegisterBroadcastReciver() {
        try {
            if (broadcastReciver != null) {
                TbadkCoreApplication.getInst().unregisterReceiver(broadcastReciver);
            }
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.imagePicker.ImagePickerAuto.HostImagePicker
    public void chosePhotoLibrary(ImagePickerAuto.HostParam hostParam) {
        getPhoto(hostParam);
    }

    @Override // com.baidu.tieba.flutter.plugin.imagePicker.ImagePickerAuto.HostImagePicker
    public void editUserPortrait() {
        currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.clearRequestPermissionList();
        permissionJudgePolicy.appendRequestPermission(currentActivity, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
        if (permissionJudgePolicy.startRequestPermission(currentActivity)) {
            return;
        }
        isEditHeadImage = true;
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) currentActivity, new WriteImagesInfo().toJsonString(), true);
        albumActivityConfig.getIntent().putExtra("from", AlbumActivityConfig.FROM_FLUTTER);
        albumActivityConfig.setRequestCode(PlayerPostEvent.MEDIA_REP_CHANGE_END);
        albumActivityConfig.setIntentAction(IntentAction.ActivityForResult);
        albumActivityConfig.setResourceType(2);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
    }

    public void getPhoto(ImagePickerAuto.HostParam hostParam) {
        currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.clearRequestPermissionList();
        permissionJudgePolicy.appendRequestPermission(currentActivity, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
        if (permissionJudgePolicy.startRequestPermission(TbadkCoreApplication.getInst().getCurrentActivity())) {
            if (PreferenceUtils.getBoolean("imagepicker_tost_show", false) && !ActivityCompat.shouldShowRequestPermissionRationale(TbadkCoreApplication.getInst().getCurrentActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION)) {
                BdToast.c(currentActivity, "请到设置-隐私-照片开启照片权限").q();
            }
            PreferenceUtils.setBoolean("imagepicker_tost_show", true);
            return;
        }
        onlyNeedImageUrl = false;
        barId = null;
        scaleRate = 1.0d;
        isEditHeadImage = false;
        if (hostParam.getOnlyNeedImageUrl() != null) {
            onlyNeedImageUrl = hostParam.getOnlyNeedImageUrl().booleanValue();
        }
        if (onlyNeedImageUrl) {
            scaleRate = 0.5625d;
        }
        if (hostParam.getBarId() != null) {
            barId = hostParam.getBarId();
        }
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) currentActivity, new WriteImagesInfo().toJsonString(), true);
        albumActivityConfig.setRequestCode(PlayerPostEvent.MEDIA_REP_CHANGE_END);
        albumActivityConfig.setIntentAction(IntentAction.ActivityForResult);
        albumActivityConfig.setCanEditImage(false);
        albumActivityConfig.getIntent().putExtra("from", AlbumActivityConfig.FROM_FLUTTER);
        albumActivityConfig.setResourceType(2);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        e.e(flutterPluginBinding.getBinaryMessenger(), this);
        MessageManager.getInstance().registerListener(this.mAlbumResultListener);
        registerBroadcastReciver();
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        unRegisterBroadcastReciver();
        MessageManager.getInstance().unRegisterListener(this.mAlbumResultListener);
        e.e(flutterPluginBinding.getBinaryMessenger(), null);
    }

    @Override // com.baidu.tieba.flutter.plugin.imagePicker.ImagePickerAuto.HostImagePicker
    public void savePhoto(ImagePickerAuto.HostParam hostParam) {
        currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.clearRequestPermissionList();
        permissionJudgePolicy.appendRequestPermission(currentActivity, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
        if (permissionJudgePolicy.startRequestPermission(TbadkCoreApplication.getInst().getCurrentActivity())) {
            if (PreferenceUtils.getBoolean("imagepicker_tost_show", false) && !ActivityCompat.shouldShowRequestPermissionRationale(TbadkCoreApplication.getInst().getCurrentActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION)) {
                BdToast.c(currentActivity, "请到设置-隐私-照片开启照片权限").q();
            }
            PreferenceUtils.setBoolean("imagepicker_tost_show", true);
            return;
        }
        onlyNeedImageUrl = false;
        isEditHeadImage = false;
        if (hostParam.getOnlyNeedImageUrl() != null) {
            onlyNeedImageUrl = hostParam.getOnlyNeedImageUrl().booleanValue();
        }
        downloadImage(hostParam.getAvatar());
    }

    @Override // com.baidu.tieba.flutter.plugin.imagePicker.ImagePickerAuto.HostImagePicker
    public void takePhoto(ImagePickerAuto.HostParam hostParam) {
        getPhoto(hostParam);
    }
}

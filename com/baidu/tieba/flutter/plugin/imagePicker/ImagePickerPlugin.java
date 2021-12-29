package com.baidu.tieba.flutter.plugin.imagePicker;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.s0.e1.v;
import c.a.t0.z0.a.d.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.sp.PreferenceUtils;
import com.baidu.bdtask.model.response.TaskResponseData;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import java.util.HashMap;
/* loaded from: classes12.dex */
public class ImagePickerPlugin implements FlutterPlugin, ImagePickerAuto.HostImagePicker {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACTION = "com.tieba.action.ImagePickerPlugin";
    public static String barId = null;
    public static BroadcastReciver broadcastReciver = null;
    public static Activity currentActivity = null;
    public static boolean isEditHeadImage = false;
    public static boolean onlyNeedImageUrl = false;
    public static double scaleRate = 1.0d;
    public transient /* synthetic */ FieldHolder $fh;
    public PostAsyncTask.PostCallback callback;
    public CustomMessageListener mAlbumResultListener;

    /* loaded from: classes12.dex */
    public class BroadcastReciver extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImagePickerPlugin this$0;

        public BroadcastReciver(ImagePickerPlugin imagePickerPlugin) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imagePickerPlugin};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = imagePickerPlugin;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && intent != null && "com.tieba.action.ImagePickerPlugin".equals(intent.getAction())) {
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
                    this.this$0.notifyFlutter(0, "", originPic);
                } else {
                    new PostAsyncTask(originPic, ImagePickerPlugin.barId, this.this$0.callback).execute(new String[0]);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1977894688, "Lcom/baidu/tieba/flutter/plugin/imagePicker/ImagePickerPlugin;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1977894688, "Lcom/baidu/tieba/flutter/plugin/imagePicker/ImagePickerPlugin;");
        }
    }

    public ImagePickerPlugin() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.callback = new PostAsyncTask.PostCallback(this) { // from class: com.baidu.tieba.flutter.plugin.imagePicker.ImagePickerPlugin.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ImagePickerPlugin this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.tieba.flutter.plugin.imagePicker.PostAsyncTask.PostCallback
            public void onFailure(PostAsyncTask.ResultData resultData) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, resultData) == null) || resultData == null) {
                    return;
                }
                this.this$0.notifyFlutter(resultData.error_code, resultData.error_msg, resultData.url);
            }

            @Override // com.baidu.tieba.flutter.plugin.imagePicker.PostAsyncTask.PostCallback
            public void onSuccess(PostAsyncTask.ResultData resultData) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, resultData) == null) || resultData == null) {
                    return;
                }
                this.this$0.notifyFlutter(resultData.error_code, "提交成功，我们会尽快完成审核", resultData.url);
            }
        };
        this.mAlbumResultListener = new CustomMessageListener(this, 2921464) { // from class: com.baidu.tieba.flutter.plugin.imagePicker.ImagePickerPlugin.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ImagePickerPlugin this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Intent intent;
                String stringExtra;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2921464 || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Intent) || (stringExtra = (intent = (Intent) customResponsedMessage.getData()).getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) == null) {
                    return;
                }
                WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
                writeImagesInfo.parseJson(stringExtra);
                writeImagesInfo.updateQuality();
                if (ListUtils.isEmpty(writeImagesInfo.getChosedFiles())) {
                    return;
                }
                if (ImagePickerPlugin.isEditHeadImage) {
                    EditHeadActivityConfig editHeadActivityConfig = new EditHeadActivityConfig((Context) ImagePickerPlugin.currentActivity, (int) TaskResponseData.ERROR_NO_TASK_OFFLINE_03, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, writeImagesInfo.getChosedFiles().get(0).getFilePath(), (float) ImagePickerPlugin.scaleRate, true);
                    editHeadActivityConfig.setWaterMaskType(3);
                    editHeadActivityConfig.setFromWhere(EditHeadActivityConfig.FROM_FLUTTER_IMAGEPICKER);
                    editHeadActivityConfig.setNeedPaste(true);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, editHeadActivityConfig));
                    return;
                }
                EditHeadActivityConfig editHeadActivityConfig2 = new EditHeadActivityConfig((Context) ImagePickerPlugin.currentActivity, (int) TaskResponseData.ERROR_NO_TASK_OFFLINE_03, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 4, writeImagesInfo.getChosedFiles().get(0).getFilePath(), (float) ImagePickerPlugin.scaleRate, true);
                editHeadActivityConfig2.setWaterMaskType(3);
                editHeadActivityConfig2.setFromWhere(EditHeadActivityConfig.FROM_FLUTTER_IMAGEPICKER);
                editHeadActivityConfig2.setNeedPaste(false);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, editHeadActivityConfig2));
            }
        };
    }

    private void downloadImage(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, this, str) == null) || currentActivity == null || str == null) {
            return;
        }
        v vVar = new v(currentActivity, str, new v.a(this) { // from class: com.baidu.tieba.flutter.plugin.imagePicker.ImagePickerPlugin.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ImagePickerPlugin this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // c.a.s0.e1.v.a
            public void onError(int i2, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str2) == null) {
                    this.this$0.notifyFlutter(i2, str2, "");
                }
            }

            @Override // c.a.s0.e1.v.a
            public void onSuccess(String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str2) == null) {
                    this.this$0.notifyFlutter(0, "保存成功！", "");
                }
            }
        });
        vVar.o(false);
        vVar.q(true);
        vVar.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyFlutter(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65546, this, i2, str, str2) == null) {
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put("imgUrl", str2);
            }
            hashMap.put("msg", str);
            hashMap.put("errorcode", String.valueOf(i2));
            HashMap hashMap2 = new HashMap();
            if (onlyNeedImageUrl) {
                hashMap2.put("uniqueKey", "kUpDateBaHeadNSNotificationBarBroadcast");
            } else {
                hashMap2.put("uniqueKey", "kUpDateBaHeadNSNotification");
            }
            hashMap2.put("data", hashMap);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921542, hashMap2));
        }
    }

    private void registerBroadcastReciver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            try {
                broadcastReciver = new BroadcastReciver(this);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.tieba.action.ImagePickerPlugin");
                TbadkCoreApplication.getInst().registerReceiver(broadcastReciver, intentFilter);
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    private void unRegisterBroadcastReciver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            try {
                if (broadcastReciver != null) {
                    TbadkCoreApplication.getInst().unregisterReceiver(broadcastReciver);
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.imagePicker.ImagePickerAuto.HostImagePicker
    public void chosePhotoLibrary(ImagePickerAuto.HostParam hostParam) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hostParam) == null) {
            getPhoto(hostParam);
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.imagePicker.ImagePickerAuto.HostImagePicker
    public void editUserPortrait() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            permissionJudgePolicy.clearRequestPermissionList();
            permissionJudgePolicy.appendRequestPermission(currentActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (permissionJudgePolicy.startRequestPermission(currentActivity)) {
                return;
            }
            isEditHeadImage = true;
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) currentActivity, new WriteImagesInfo().toJsonString(), true);
            albumActivityConfig.getIntent().putExtra("from", AlbumActivityConfig.FROM_FLUTTER);
            albumActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
            albumActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            albumActivityConfig.setResourceType(2);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
    }

    public void getPhoto(ImagePickerAuto.HostParam hostParam) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hostParam) == null) {
            currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            permissionJudgePolicy.clearRequestPermissionList();
            permissionJudgePolicy.appendRequestPermission(currentActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (permissionJudgePolicy.startRequestPermission(TbadkCoreApplication.getInst().getCurrentActivity())) {
                if (PreferenceUtils.getBoolean("imagepicker_tost_show", false) && !ActivityCompat.shouldShowRequestPermissionRationale(TbadkCoreApplication.getInst().getCurrentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE")) {
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
            albumActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
            albumActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            albumActivityConfig.setCanEditImage(false);
            albumActivityConfig.getIntent().putExtra("from", AlbumActivityConfig.FROM_FLUTTER);
            albumActivityConfig.setResourceType(2);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, flutterPluginBinding) == null) {
            e.e(flutterPluginBinding.getBinaryMessenger(), this);
            MessageManager.getInstance().registerListener(this.mAlbumResultListener);
            registerBroadcastReciver();
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, flutterPluginBinding) == null) {
            unRegisterBroadcastReciver();
            MessageManager.getInstance().unRegisterListener(this.mAlbumResultListener);
            e.e(flutterPluginBinding.getBinaryMessenger(), null);
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.imagePicker.ImagePickerAuto.HostImagePicker
    public void savePhoto(ImagePickerAuto.HostParam hostParam) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, hostParam) == null) {
            currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            permissionJudgePolicy.clearRequestPermissionList();
            permissionJudgePolicy.appendRequestPermission(currentActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (permissionJudgePolicy.startRequestPermission(TbadkCoreApplication.getInst().getCurrentActivity())) {
                if (PreferenceUtils.getBoolean("imagepicker_tost_show", false) && !ActivityCompat.shouldShowRequestPermissionRationale(TbadkCoreApplication.getInst().getCurrentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE")) {
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
    }

    @Override // com.baidu.tieba.flutter.plugin.imagePicker.ImagePickerAuto.HostImagePicker
    public void takePhoto(ImagePickerAuto.HostParam hostParam) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, hostParam) == null) {
            getPhoto(hostParam);
        }
    }
}

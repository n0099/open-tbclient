package com.baidu.tieba.flutter.plugin.commonPlatformView;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbadkApplication;
import d.b.i0.a3.a;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.platform.PlatformView;
import java.util.Map;
/* loaded from: classes4.dex */
public class CommonPlatformView implements PlatformView, MethodChannel.MethodCallHandler {
    public static final String TAG = "CommonPlatformView";
    public a mSquareDelegate;
    public View mainView;
    public final MethodChannel methodChannel;
    public int viewId;
    public String persistentViewId = "-1";
    public CustomMessageListener mSelectForumCategoryListener = new CustomMessageListener(2921539) { // from class: com.baidu.tieba.flutter.plugin.commonPlatformView.CommonPlatformView.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2921539 || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof String)) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (CommonPlatformView.this.mSquareDelegate == null || TextUtils.isEmpty(str)) {
                return;
            }
            CommonPlatformView.this.mSquareDelegate.l(str);
        }
    };

    @TargetApi(17)
    public CommonPlatformView(Context context, BinaryMessenger binaryMessenger, int i, Map<String, Object> map) {
        creatMainView(context, map);
        this.viewId = i;
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "common_platform_view_" + this.persistentViewId);
        this.methodChannel = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    private void creatMainView(Context context, Map<String, Object> map) {
        if (map == null || !(map instanceof Map)) {
            return;
        }
        Object obj = map.get("x");
        if (obj != null) {
            Double.valueOf(obj.toString()).doubleValue();
        }
        Object obj2 = map.get("y");
        if (obj2 != null) {
            Double.valueOf(obj2.toString()).doubleValue();
        }
        Object obj3 = map.get("width");
        if (obj3 != null) {
            Double.valueOf(obj3.toString()).doubleValue();
        }
        Object obj4 = map.get("height");
        if (obj4 != null) {
            Double.valueOf(obj4.toString()).doubleValue();
        }
        this.persistentViewId = String.valueOf(map.get("persistentViewId"));
        if ("BarSquare".equals(String.valueOf(map.get("nativeViewType")))) {
            a aVar = new a(TbadkApplication.getInst().getCurrentActivity(), ((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext());
            this.mSquareDelegate = aVar;
            aVar.e();
            this.mSquareDelegate.m();
            this.mainView = this.mSquareDelegate.f53061d.d();
        }
    }

    @Override // io.flutter.plugin.platform.PlatformView
    public void dispose() {
        Log.d(TAG, "dispose() called");
    }

    @Override // io.flutter.plugin.platform.PlatformView
    public View getView() {
        return this.mainView;
    }

    @Override // io.flutter.plugin.platform.PlatformView
    public void onFlutterViewAttached(@NonNull View view) {
        MessageManager.getInstance().registerListener(this.mSelectForumCategoryListener);
    }

    @Override // io.flutter.plugin.platform.PlatformView
    public void onFlutterViewDetached() {
        MessageManager.getInstance().unRegisterListener(this.mSelectForumCategoryListener);
    }

    @Override // io.flutter.plugin.platform.PlatformView
    public void onInputConnectionLocked() {
    }

    @Override // io.flutter.plugin.platform.PlatformView
    public void onInputConnectionUnlocked() {
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
        if (methodCall.method.equals("getPlatformVersion")) {
            result.success("Android " + Build.VERSION.RELEASE);
        } else if (methodCall.method.equals("removePlatformView")) {
            CommonPlatformViewFactory.removePlatformViewByPersistentViewId(this.viewId);
            result.success(Boolean.TRUE);
        } else if (methodCall.method.equals("selectForumCategory")) {
            String str = (String) methodCall.arguments;
            if (this.mSquareDelegate != null && !TextUtils.isEmpty(str)) {
                this.mSquareDelegate.l(str);
            }
            result.success(null);
        } else {
            result.notImplemented();
        }
    }
}

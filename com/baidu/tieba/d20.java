package com.baidu.tieba;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.java.Supplier;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.aperf.param.CommonUtils;
import com.baidu.searchbox.aperf.runtime.AperfRuntime;
import com.baidu.searchbox.logsystem.basic.LogSystemServiceUtil;
import com.baidu.searchbox.logsystem.basic.LokiService;
import com.baidu.searchbox.logsystem.basic.eventhandler.DefaultProcessEventSceneHandler;
import com.baidu.searchbox.logsystem.basic.util.SnapshotUtil;
import com.baidu.searchbox.logsystem.logsys.CrashUtil;
import com.baidu.searchbox.logsystem.logsys.LogDiskStoreConfig;
import com.baidu.searchbox.logsystem.logsys.LogExtra;
import com.baidu.searchbox.logsystem.logsys.LogFile;
import com.baidu.searchbox.logsystem.logsys.LogPipelineSingleton;
import com.baidu.searchbox.logsystem.logsys.LogType;
import com.baidu.searchbox.logsystem.logsys.SnapshotConstant;
import com.baidu.searchbox.logsystem.logsys.eventscene.EventObject;
import com.baidu.searchbox.logsystem.logsys.eventscene.handler.ForwardingProcessEventSceneHandler;
import com.baidu.searchbox.logsystem.logsys.eventscene.handler.ProcessEventSceneHandler;
import com.baidu.searchbox.logsystem.logsys.eventscene.snapshot.ProcessSnapshotType;
import com.baidu.searchbox.logsystem.util.LLog;
import com.baidu.searchbox.logsystem.util.Utility;
import com.baidu.searchbox.track.Track;
import com.baidu.searchbox.track.ui.TrackUI;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d20 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "loki-native-NativeCrashHandler";
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public Supplier<List<ProcessEventSceneHandler>> mForwardingHandlerSupplier;
    public long mProcessLaunchTime;
    public String mProcessName;

    public void onAttachExtra(@NonNull Context context, @NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, jSONObject) == null) {
        }
    }

    public void onCrashStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public void onDisasterRecovery(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
        }
    }

    public void onEvent(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
        }
    }

    public d20(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (context instanceof Application) {
            this.mContext = context;
        } else {
            this.mContext = context.getApplicationContext();
        }
        this.mProcessName = of1.b();
        this.mProcessLaunchTime = System.currentTimeMillis();
        if (Build.VERSION.SDK_INT <= 19) {
            initKITKAT();
        }
    }

    public d20(@NonNull Context context, @NonNull Supplier<List<ProcessEventSceneHandler>> supplier) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, supplier};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (context instanceof Application) {
            this.mContext = context;
        } else {
            this.mContext = context.getApplicationContext();
        }
        this.mProcessName = of1.b();
        this.mProcessLaunchTime = System.currentTimeMillis();
        this.mForwardingHandlerSupplier = supplier;
    }

    private LogExtra createLogExtra() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            LogExtra logExtra = new LogExtra();
            TrackUI lastTrackUI = Track.getInstance().getLastTrackUI();
            if (lastTrackUI != null) {
                if (!TextUtils.isEmpty(lastTrackUI.getFragmentPage())) {
                    logExtra.mPage = lastTrackUI.getFragmentPage();
                } else {
                    logExtra.mPage = lastTrackUI.getActivityPage();
                }
            }
            logExtra.mCrashTime = String.valueOf(System.currentTimeMillis());
            logExtra.mLaunchTime = String.valueOf(this.mProcessLaunchTime);
            if (DeviceUtil.OSInfo.hasNougat()) {
                logExtra.mProcessLifeTime = String.valueOf(SystemClock.elapsedRealtime() - Utility.getProcessStartElapsedRealTime());
            }
            logExtra.mForeground = String.valueOf(Track.getInstance().isForeground());
            logExtra.mTraceID = AperfRuntime.Runtime.getProcessUUID();
            logExtra.mHeapMem = CommonUtils.getHeapInfo();
            logExtra.mVSSRSS = CommonUtils.getVSSRSS();
            logExtra.mPSS = CommonUtils.getPSS();
            logExtra.mSysMem = CommonUtils.getSysMem();
            logExtra.mSysLowMem = !CommonUtils.isLowMemory() ? 1 : 0;
            return logExtra;
        }
        return (LogExtra) invokeV.objValue;
    }

    @NonNull
    private ForwardingProcessEventSceneHandler getForwardingProcessEventSceneHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            ForwardingProcessEventSceneHandler forwardingProcessEventSceneHandler = new ForwardingProcessEventSceneHandler();
            if (Build.VERSION.SDK_INT > 19) {
                forwardingProcessEventSceneHandler.addEventHandleCallback(new DefaultProcessEventSceneHandler());
            }
            Supplier<List<ProcessEventSceneHandler>> supplier = this.mForwardingHandlerSupplier;
            if (supplier != null && Build.VERSION.SDK_INT > 19) {
                forwardingProcessEventSceneHandler.addEventHandleCallback(supplier.get());
            }
            return forwardingProcessEventSceneHandler;
        }
        return (ForwardingProcessEventSceneHandler) invokeV.objValue;
    }

    private void initKITKAT() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            DefaultProcessEventSceneHandler.init();
            LogType.init();
            SnapshotUtil.init();
            LogFile.init();
            ProcessSnapshotType.init();
            Utility.init();
            LogPipelineSingleton.init();
            LokiService.init();
            LogExtra.init();
            LogDiskStoreConfig.init();
            CrashUtil.init();
            LogSystemServiceUtil.init();
        }
    }

    private void processNativeCrash(@NonNull String str, @NonNull LogExtra logExtra) {
        HashSet hashSet;
        Set<LogFile> obtainProcessSnapShots;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, this, str, logExtra) == null) {
            File obtainFileDirWithProcessName = LogPipelineSingleton.obtainFileDirWithProcessName(this.mProcessName);
            if (!obtainFileDirWithProcessName.exists()) {
                obtainFileDirWithProcessName.mkdirs();
            }
            JSONObject jSONObject = new JSONObject();
            onAttachExtra(this.mContext, jSONObject);
            logExtra.mJSONAttach = jSONObject.toString();
            ForwardingProcessEventSceneHandler forwardingProcessEventSceneHandler = getForwardingProcessEventSceneHandler();
            File file = null;
            if (forwardingProcessEventSceneHandler != null) {
                hashSet = new HashSet(5);
                EventObject eventObject = new EventObject(LogType.NATIVE_CRASH, str);
                Set<ProcessSnapshotType> requireGeneralSnapshots = forwardingProcessEventSceneHandler.requireGeneralSnapshots(this.mContext, eventObject);
                if (requireGeneralSnapshots != null && requireGeneralSnapshots.size() > 0 && (obtainProcessSnapShots = SnapshotUtil.obtainProcessSnapShots(this.mContext, requireGeneralSnapshots, obtainFileDirWithProcessName, this.mProcessName, logExtra)) != null && obtainProcessSnapShots.size() > 0) {
                    hashSet.addAll(obtainProcessSnapShots);
                }
                Set<LogFile> customizedSnapshots = forwardingProcessEventSceneHandler.getCustomizedSnapshots(this.mContext, obtainFileDirWithProcessName, eventObject);
                if (customizedSnapshots != null && customizedSnapshots.size() > 0) {
                    hashSet.addAll(customizedSnapshots);
                }
                LogFile obtainFragmentSnapShot = SnapshotUtil.obtainFragmentSnapShot(this.mContext, forwardingProcessEventSceneHandler, eventObject, obtainFileDirWithProcessName, SnapshotConstant.ProcessConstants.PROCESS_SHARED_FRAGMENT_FILE);
                if (obtainFragmentSnapShot != null && obtainFragmentSnapShot.mFile.exists()) {
                    hashSet.add(obtainFragmentSnapShot);
                }
                if (LLog.sDebug) {
                    if (hashSet.size() > 0) {
                        Log.d(TAG, "uploadLogFiles.size() = " + hashSet.size());
                        for (int i = 0; i < hashSet.size(); i++) {
                        }
                    } else {
                        Log.d(TAG, "uploadLogFiles is null or uploadLogFiles.size() = 0");
                    }
                }
            } else {
                hashSet = null;
            }
            onDisasterRecovery(this.mContext);
            if (hashSet != null) {
                file = SnapshotUtil.createPathNameKeeper(obtainFileDirWithProcessName, hashSet);
                if (LLog.sDebug && file != null) {
                    Log.d(TAG, "pathNameKeeper = " + file.getAbsolutePath());
                }
            }
            onReport(this.mContext, str, file, logExtra);
        }
    }

    public void onReport(@NonNull Context context, @NonNull String str, @Nullable File file, @Nullable LogExtra logExtra) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, context, str, file, logExtra) == null) {
            LogSystemServiceUtil.startLogHandlerService(context, LogType.NATIVE_CRASH, str, file, logExtra);
        }
    }

    public void uncaughtNativeCrash(@NonNull String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048581, this, str, i, i2) == null) {
            Log.d(TAG, str);
            try {
                processNativeCrash(str, createLogExtra());
            } catch (Throwable th) {
                if (LLog.sDebug) {
                    th.printStackTrace();
                }
            }
        }
    }
}

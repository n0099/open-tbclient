package com.baidu.tbadk.mutiprocess;

import android.app.Activity;
import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.lm5;
import com.baidu.tieba.mm5;
import com.baidu.tieba.nm5;
import com.baidu.tieba.om5;
import com.baidu.tieba.pm5;
import com.baidu.tieba.qm5;
import com.baidu.tieba.yu4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes5.dex */
public class MutiProcessManager {
    public static /* synthetic */ Interceptable $ic;
    public static MutiProcessManager sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean hasInited;
    public final yu4 mActivityLifecycleCallbacks;
    public final mm5 mEventDispatcher;
    public final Map<Class<? extends IEvent>, lm5> mForeverListeners;
    public nm5 mMutiProcessProcessor;
    public final Map<Class<? extends IEvent>, LinkedList<ResponsedEventListener>> mResponsedListeners;
    public final Handler mUIHandler;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1277807360, "Lcom/baidu/tbadk/mutiprocess/MutiProcessManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1277807360, "Lcom/baidu/tbadk/mutiprocess/MutiProcessManager;");
        }
    }

    /* loaded from: classes5.dex */
    public class a implements mm5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MutiProcessManager a;

        public a(MutiProcessManager mutiProcessManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mutiProcessManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mutiProcessManager;
        }

        @Override // com.baidu.tieba.mm5
        public void a(IEvent iEvent) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, iEvent) != null) {
                return;
            }
            this.a.dispatchResponsedEventToUI(iEvent);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IEvent a;
        public final /* synthetic */ MutiProcessManager b;

        public b(MutiProcessManager mutiProcessManager, IEvent iEvent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mutiProcessManager, iEvent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = mutiProcessManager;
            this.a = iEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.dispatchResponsedEvent(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends yu4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MutiProcessManager a;

        public c(MutiProcessManager mutiProcessManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mutiProcessManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mutiProcessManager;
        }

        @Override // com.baidu.tieba.yu4, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, activity) == null) && (activity instanceof TbPageContextSupport)) {
                this.a.unRegisterResponsedEventListener(((TbPageContextSupport) activity).getPageContext().getUniqueId());
            }
        }
    }

    public MutiProcessManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.hasInited = false;
        this.mUIHandler = new Handler(Looper.getMainLooper());
        this.mEventDispatcher = new a(this);
        this.mActivityLifecycleCallbacks = new c(this);
        this.mForeverListeners = new HashMap();
        this.mResponsedListeners = new HashMap();
    }

    public void registerForeverListener(@NonNull Class<? extends IEvent> cls, @NonNull lm5 lm5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, cls, lm5Var) == null) {
            if (this.mForeverListeners.containsKey(cls)) {
                BdLog.e(cls + " has existed, Please unRegister old listener first！");
                return;
            }
            this.mForeverListeners.put(cls, lm5Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchResponsedEvent(IEvent iEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, iEvent) != null) || iEvent == null) {
            return;
        }
        Class<?> cls = iEvent.getClass();
        try {
            lm5 lm5Var = this.mForeverListeners.get(cls);
            if (lm5Var != null) {
                lm5Var.onEvent(iEvent);
            }
        } catch (Exception e) {
            BdLog.detailException(cls.getName(), e);
        }
        try {
            LinkedList<ResponsedEventListener> linkedList = this.mResponsedListeners.get(cls);
            if (ListUtils.isEmpty(linkedList)) {
                return;
            }
            int myPid = Process.myPid();
            for (ResponsedEventListener responsedEventListener : linkedList) {
                if (responsedEventListener != null && (!responsedEventListener.isSelfListener() || (iEvent.getPid() == myPid && responsedEventListener.getTag() != null && responsedEventListener.getTag().getId() == iEvent.getTag()))) {
                    try {
                        responsedEventListener.onEvent(iEvent);
                    } catch (Exception e2) {
                        BdLog.detailException(cls.getName(), e2);
                    }
                }
            }
        } catch (Exception e3) {
            BdLog.detailException(cls.getName(), e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchResponsedEventToUI(IEvent iEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, iEvent) == null) {
            if (BdUtilHelper.isMainThread()) {
                dispatchResponsedEvent(iEvent);
            } else {
                this.mUIHandler.post(new b(this, iEvent));
            }
        }
    }

    public static void publishEvent(@NonNull IEvent iEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, iEvent) == null) {
            getInstance().postEvent(iEvent);
        }
    }

    private void publishProcessEvent(IEvent iEvent) {
        nm5 nm5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65545, this, iEvent) == null) && (nm5Var = this.mMutiProcessProcessor) != null) {
            nm5Var.b(iEvent);
        }
    }

    private void registerActivityLifecycleCallbacks(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, application) == null) {
            try {
                application.registerActivityLifecycleCallbacks(this.mActivityLifecycleCallbacks);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void init(@NonNull Application application) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, application) != null) || this.hasInited) {
            return;
        }
        pm5.g();
        registerActivityLifecycleCallbacks(application);
        om5 om5Var = new om5(application);
        this.mMutiProcessProcessor = om5Var;
        om5Var.c(this.mEventDispatcher);
        this.mMutiProcessProcessor.a();
        this.hasInited = true;
    }

    public void removeStickyEvent(@NonNull Class<? extends StickyEvent> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cls) == null) {
            qm5.s(cls.getSimpleName());
        }
    }

    public void unRegisterResponsedEventListener(@NonNull Class<? extends IEvent> cls) {
        LinkedList<ResponsedEventListener> linkedList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, cls) == null) && (linkedList = this.mResponsedListeners.get(cls)) != null) {
            linkedList.clear();
            this.mResponsedListeners.remove(cls);
        }
    }

    private void dispatchStickyEventIfNeed(@NonNull Class<? extends IEvent> cls, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65542, this, cls, bdUniqueId) == null) && StickyEvent.class.isAssignableFrom(cls)) {
            OrmObject h = qm5.h(cls.getSimpleName(), cls);
            if (h instanceof StickyEvent) {
                StickyEvent stickyEvent = (StickyEvent) h;
                stickyEvent.resetPid();
                stickyEvent.setTag(bdUniqueId);
                stickyEvent.setType(2);
                publishEvent(stickyEvent);
            }
        }
    }

    public void unRegisterResponsedEventListener(@NonNull Class<? extends IEvent> cls, @NonNull ResponsedEventListener responsedEventListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, cls, responsedEventListener) == null) {
            LinkedList<ResponsedEventListener> linkedList = this.mResponsedListeners.get(cls);
            if (ListUtils.isEmpty(linkedList)) {
                return;
            }
            Iterator<ResponsedEventListener> it = linkedList.iterator();
            while (it.hasNext()) {
                if (it.next() == responsedEventListener) {
                    it.remove();
                }
            }
        }
    }

    public static MutiProcessManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (sInstance == null) {
                synchronized (MutiProcessManager.class) {
                    if (sInstance == null) {
                        sInstance = new MutiProcessManager();
                    }
                }
            }
            return sInstance;
        }
        return (MutiProcessManager) invokeV.objValue;
    }

    public void postEvent(@NonNull IEvent iEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iEvent) == null) {
            if (!pm5.i()) {
                String c2 = pm5.c();
                pm5.m(c2 + " Process Not In WhiteList，Ignore Event!");
                return;
            }
            int myPid = Process.myPid();
            int pid = iEvent.getPid();
            if (iEvent.getType() == 2 && myPid == pid) {
                dispatchResponsedEventToUI(iEvent);
            } else {
                publishProcessEvent(iEvent);
            }
        }
    }

    public void unRegisterResponsedEventListener(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, bdUniqueId) != null) || bdUniqueId == null) {
            return;
        }
        for (Map.Entry<Class<? extends IEvent>, LinkedList<ResponsedEventListener>> entry : this.mResponsedListeners.entrySet()) {
            LinkedList<ResponsedEventListener> value = entry.getValue();
            if (!ListUtils.isEmpty(value)) {
                Iterator<ResponsedEventListener> it = value.iterator();
                while (it.hasNext()) {
                    ResponsedEventListener next = it.next();
                    if (next != null && next.getTag() != null && next.getTag() == bdUniqueId) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void postStickyEvent(@NonNull StickyEvent stickyEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, stickyEvent) == null) {
            if (!pm5.i()) {
                String c2 = pm5.c();
                pm5.m(c2 + " Process Not In WhiteList，Ignore StickyEvent!");
                return;
            }
            qm5.p(stickyEvent.getClass().getSimpleName(), stickyEvent);
        }
    }

    public void registerResponsedEventListener(@NonNull Class<? extends IEvent> cls, @NonNull ResponsedEventListener responsedEventListener, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, cls, responsedEventListener, bdUniqueId) == null) {
            LinkedList<ResponsedEventListener> linkedList = this.mResponsedListeners.get(cls);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.mResponsedListeners.put(cls, linkedList);
            }
            if (linkedList.contains(responsedEventListener)) {
                BdLog.e("listener has existed, Please unRegister old listener first！");
                return;
            }
            responsedEventListener.setTag(bdUniqueId);
            FrameHelper.f(linkedList, responsedEventListener);
            dispatchStickyEventIfNeed(cls, bdUniqueId);
        }
    }

    public void registerResponsedEventListener(@NonNull Class<? extends IEvent> cls, @NonNull ResponsedEventListener responsedEventListener, BdPageContext bdPageContext) {
        BdUniqueId bdUniqueId;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, cls, responsedEventListener, bdPageContext) == null) {
            if (bdPageContext != null) {
                bdUniqueId = bdPageContext.getUniqueId();
            } else {
                bdUniqueId = null;
            }
            registerResponsedEventListener(cls, responsedEventListener, bdUniqueId);
        }
    }

    public void unRegisterResponsedEventListener(@NonNull ResponsedEventListener responsedEventListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, responsedEventListener) == null) {
            for (Map.Entry<Class<? extends IEvent>, LinkedList<ResponsedEventListener>> entry : this.mResponsedListeners.entrySet()) {
                LinkedList<ResponsedEventListener> value = entry.getValue();
                if (!ListUtils.isEmpty(value)) {
                    Iterator<ResponsedEventListener> it = value.iterator();
                    while (it.hasNext()) {
                        if (it.next() == responsedEventListener) {
                            it.remove();
                        }
                    }
                }
            }
        }
    }
}

package com.baidu.tbadk.util;

import android.util.SparseArray;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ChatStatusManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int GROUP_CHAT = 2;
    public static final int OFFICIALBAR_CHAT = 1;
    public static final int OFFICIAL_MERGE = 4;
    public static final int PERSONAL_CHAT = 0;
    public static final int STRANGER_MERGE = 5;
    public static final int UPDATES = 6;
    public static final int VALIDATE = 7;
    public static ChatStatusManager instance;
    public transient /* synthetic */ FieldHolder $fh;
    public SparseArray<a> mStatus;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public String f30633b;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public ChatStatusManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mStatus = new SparseArray<>();
    }

    public static synchronized ChatStatusManager getInst() {
        InterceptResult invokeV;
        ChatStatusManager chatStatusManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (ChatStatusManager.class) {
                if (instance == null) {
                    instance = new ChatStatusManager();
                }
                chatStatusManager = instance;
            }
            return chatStatusManager;
        }
        return (ChatStatusManager) invokeV.objValue;
    }

    public String getCurId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            a aVar = this.mStatus.get(i);
            return aVar != null ? aVar.f30633b : "";
        }
        return (String) invokeI.objValue;
    }

    public boolean getIsOpen(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            a aVar = this.mStatus.get(i);
            if (aVar != null) {
                return aVar.a;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void remove(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.mStatus.delete(i);
        }
    }

    public void setCurId(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
            a aVar = this.mStatus.get(i);
            if (aVar != null) {
                aVar.f30633b = str;
                return;
            }
            a aVar2 = new a();
            aVar2.f30633b = str;
            this.mStatus.put(i, aVar2);
        }
    }

    public void setIsOpen(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            a aVar = this.mStatus.get(i);
            if (aVar != null) {
                aVar.a = z;
                return;
            }
            a aVar2 = new a();
            aVar2.a = z;
            this.mStatus.put(i, aVar2);
        }
    }
}

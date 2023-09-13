package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.base.BdUploadStatMsgData;
import com.baidu.adp.lib.stats.switchs.BdStatSwitchData;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class ah {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ah j;
    public static final Handler k;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public String c;
    public Context d;
    public c e;
    public BdStatSwitchData f;
    public bh g;
    public b h;
    public ii i;

    /* loaded from: classes5.dex */
    public interface b {
        void a();
    }

    /* loaded from: classes5.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 1) {
                Object obj = message.obj;
                if (obj instanceof BdUploadStatMsgData) {
                    nh.i().r(((BdUploadStatMsgData) obj).parentType);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ah this$0;

        public c(ah ahVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ahVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = ahVar;
        }

        public /* synthetic */ c(ah ahVar, a aVar) {
            this(ahVar);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Serializable serializableExtra;
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048576, this, context, intent) != null) || intent == null) {
                return;
            }
            String action = intent.getAction();
            if ("com.baidu.adp.stats.background".equals(action)) {
                BdStatisticsManager.getInstance().save();
                if (this.this$0.a) {
                    nh.i().f();
                }
            } else if ("com.baidu.adp.stats.switch".equals(action)) {
                if (!this.this$0.a) {
                    this.this$0.p();
                    nh.i().s();
                }
            } else if ("com.baidu.adp.stats.updatecmd".equals(action) && !this.this$0.a && (serializableExtra = intent.getSerializableExtra("switchsCmdBrdMsg")) != null && (serializableExtra instanceof BdUploadStatMsgData)) {
                BdUploadStatMsgData bdUploadStatMsgData = (BdUploadStatMsgData) serializableExtra;
                if (bdUploadStatMsgData.parentType == null && bdUploadStatMsgData.childType == null) {
                    return;
                }
                if (TextUtils.isEmpty(bdUploadStatMsgData.childType)) {
                    str = bdUploadStatMsgData.parentType;
                } else {
                    str = bdUploadStatMsgData.childType;
                }
                if (!TextUtils.isEmpty(str)) {
                    this.this$0.f.putTmpSwitchConfData(str, bdUploadStatMsgData);
                    this.this$0.l(bdUploadStatMsgData);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ah a;

        public d(ah ahVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ahVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ahVar;
        }

        public /* synthetic */ d(ah ahVar, a aVar) {
            this(ahVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public BdStatSwitchData doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                BdStatSwitchData bdStatSwitchData = new BdStatSwitchData();
                if (this.a.g.a()) {
                    bdStatSwitchData.parserJson(this.a.g.b);
                }
                this.a.b = false;
                if (this.a.a) {
                    ah ahVar = this.a;
                    if (ahVar.t(ahVar.g.b)) {
                        String w = this.a.w();
                        if (!TextUtils.isEmpty(w) && !w.equals(this.a.g.b)) {
                            this.a.b = true;
                            bdStatSwitchData.parserJson(w);
                            this.a.g.b(w);
                        }
                    }
                }
                return bdStatSwitchData;
            }
            return (BdStatSwitchData) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdStatSwitchData) == null) {
                super.onPostExecute(bdStatSwitchData);
                if (bdStatSwitchData != null) {
                    this.a.f = bdStatSwitchData;
                    if (this.a.a && this.a.b && !BdBaseApplication.getInst().checkInterrupt()) {
                        this.a.z();
                        nh.i().s();
                    }
                    b bVar = this.a.h;
                    if (bVar != null) {
                        bVar.a();
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448299622, "Lcom/baidu/tieba/ah;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448299622, "Lcom/baidu/tieba/ah;");
                return;
            }
        }
        k = new a(Looper.getMainLooper());
    }

    public static ah o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            if (j == null) {
                synchronized (ah.class) {
                    if (j == null) {
                        j = new ah();
                    }
                }
            }
            return j;
        }
        return (ah) invokeV.objValue;
    }

    public void p() {
        ii iiVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (iiVar = this.i) != null && iiVar.isAgreePrivacyPolicy()) {
            d dVar = new d(this, null);
            dVar.setPriority(4);
            dVar.execute(new Object[0]);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.a) {
            Intent intent = new Intent("com.baidu.adp.stats.switch");
            intent.setPackage(BdBaseApplication.getInst().getPackageName());
            this.d.sendBroadcast(intent);
        }
    }

    public ah() {
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
        this.b = false;
        this.c = null;
        this.f = new BdStatSwitchData();
        this.g = new bh();
        this.h = null;
    }

    public final String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (TextUtils.isEmpty(this.c)) {
                return null;
            }
            try {
                rf g = new yf().g(this.c, 3, 30000, -1);
                if (g != null) {
                    return new String(g.i, "utf-8");
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public void A(ii iiVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iiVar) == null) {
            this.i = iiVar;
        }
    }

    public ArrayList<String> n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            return this.f.getChiledTypes(str);
        }
        return (ArrayList) invokeL.objValue;
    }

    public boolean s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return this.f.isExactWriteFile(ug.g(str));
        }
        return invokeL.booleanValue;
    }

    public final boolean t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && System.currentTimeMillis() - this.g.a < 86400000) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void y(BdUploadStatMsgData bdUploadStatMsgData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, bdUploadStatMsgData) == null) && this.a) {
            Intent intent = new Intent("com.baidu.adp.stats.updatecmd");
            intent.setPackage(BdBaseApplication.getInst().getPackageName());
            this.d.sendBroadcast(intent);
        }
    }

    public boolean B(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                return this.f.smallFlowUpload(ug.g(str), str2);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public int m(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, str, i)) == null) {
            if (TextUtils.isEmpty(str)) {
                return i;
            }
            return this.f.geUploadCycle(str, i);
        }
        return invokeLI.intValue;
    }

    public int q(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, str, i)) == null) {
            if (TextUtils.isEmpty(str)) {
                return i;
            }
            return this.f.getMaxAlertCount(str, i);
        }
        return invokeLI.intValue;
    }

    public boolean u(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                return false;
            }
            return this.f.isUpload(ug.g(str), str2);
        }
        return invokeLL.booleanValue;
    }

    public boolean v(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                return false;
            }
            return this.f.isWrite(ug.g(str), str2);
        }
        return invokeLL.booleanValue;
    }

    public boolean x(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                return false;
            }
            return this.f.onlyWifiUpload(ug.g(str), str2);
        }
        return invokeLL.booleanValue;
    }

    public boolean k(String str, String str2, BdUploadStatMsgData bdUploadStatMsgData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, bdUploadStatMsgData)) == null) {
            if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || bdUploadStatMsgData == null) {
                return false;
            }
            if (!TextUtils.isEmpty(str2)) {
                str = str2;
            }
            if (this.f.getTmpSwitchConfData(str) == null) {
                this.f.putTmpSwitchConfData(str, bdUploadStatMsgData);
                y(bdUploadStatMsgData);
                l(bdUploadStatMsgData);
                return true;
            }
            long j2 = bdUploadStatMsgData.deadLineTime;
            if (0 == j2) {
                this.f.rmTmpSwitchConfData(str);
                return false;
            } else if (0 >= j2) {
                return false;
            } else {
                this.f.putTmpSwitchConfData(str, bdUploadStatMsgData);
                y(bdUploadStatMsgData);
                l(bdUploadStatMsgData);
                return true;
            }
        }
        return invokeLLL.booleanValue;
    }

    public final void l(BdUploadStatMsgData bdUploadStatMsgData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdUploadStatMsgData) == null) {
            long currentTimeMillis = bdUploadStatMsgData.deadLineTime - System.currentTimeMillis();
            if (currentTimeMillis < 0) {
                return;
            }
            long j2 = currentTimeMillis - 3000;
            if (j2 > 0) {
                currentTimeMillis = j2;
            }
            Message obtainMessage = k.obtainMessage();
            obtainMessage.what = 1;
            obtainMessage.obj = bdUploadStatMsgData;
            k.removeMessages(1);
            k.sendMessageDelayed(obtainMessage, currentTimeMillis);
        }
    }

    public void r(boolean z, String str, Context context, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), str, context, bVar}) == null) {
            this.a = z;
            this.c = str;
            this.d = context;
            try {
                if (this.e == null && context != null && !BdBaseApplication.getInst().checkInterrupt()) {
                    this.e = new c(this, null);
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("com.baidu.adp.stats.background");
                    intentFilter.addAction("com.baidu.adp.stats.switch");
                    intentFilter.addAction("com.baidu.adp.stats.updatecmd");
                    intentFilter.addAction("com.baidu.adp.stats.uploadallfile");
                    this.d.registerReceiver(this.e, intentFilter);
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
            this.h = bVar;
        }
    }
}

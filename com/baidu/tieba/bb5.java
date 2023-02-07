package com.baidu.tieba;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoAd;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.distribute.DistributeHttpResponse;
import com.baidu.tbadk.distribute.DistributeRequest;
import com.baidu.tbadk.distribute.DistributeSocketResponse;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tbclient.LogTogether.AdReq;
/* loaded from: classes3.dex */
public class bb5 {
    public static /* synthetic */ Interceptable $ic;
    public static String l;
    public static bb5 m;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public ArrayList<AdReq> b;
    public boolean c;
    public long d;
    public int e;
    public Handler f;
    public wb g;
    public CustomMessageListener h;
    public final CustomMessageListener i;
    public ArrayList<AdvertAppInfo> j;
    public ArrayList<AdvertAppInfo> k;

    public final void o(DownloadStaticsData downloadStaticsData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, downloadStaticsData) == null) {
        }
    }

    public final void p(String str, DownloadStaticsData downloadStaticsData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, downloadStaticsData) == null) {
        }
    }

    public final void q(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, str, i) == null) {
        }
    }

    /* loaded from: classes3.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bb5 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(bb5 bb5Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bb5Var, looper};
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
            this.a = bb5Var;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, message) != null) || message.what != 1) {
                return;
            }
            this.a.h(true);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends wb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bb5 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(bb5 bb5Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bb5Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bb5Var;
        }

        @Override // com.baidu.tieba.wb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) || responsedMessage == null || !responsedMessage.hasError()) {
                return;
            }
            Object extra = responsedMessage.getOrginalMessage().getExtra();
            if (!(extra instanceof DistributeRequest)) {
                return;
            }
            this.a.g(((DistributeRequest) extra).getAdReqList());
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bb5 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(bb5 bb5Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bb5Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bb5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || getCmd() != 2000994 || !(customResponsedMessage instanceof NetWorkChangedMessage) || customResponsedMessage.hasError()) {
                return;
            }
            if (BdNetTypeUtil.isWifiNet() || BdNetTypeUtil.isMobileNet()) {
                this.a.s(true);
            } else {
                this.a.s(false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bb5 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(bb5 bb5Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bb5Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bb5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<DownloadData> data;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && !data.isEmpty()) {
                for (int i = 0; i < data.size(); i++) {
                    DownloadData downloadData = data.get(i);
                    if (downloadData.getType() == 12) {
                        int status = downloadData.getStatus();
                        if (status != 0) {
                            if (status != 1) {
                                if (status != 2 && status != 4) {
                                    if (status == 5) {
                                        this.a.o(downloadData.getDownloadStaticsData());
                                    }
                                }
                            } else {
                                this.a.p(downloadData.getId(), downloadData.getDownloadStaticsData());
                            }
                        }
                        this.a.q(downloadData.getId(), downloadData.getStatus());
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947639220, "Lcom/baidu/tieba/bb5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947639220, "Lcom/baidu/tieba/bb5;");
                return;
            }
        }
        m = new bb5();
    }

    public static bb5 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return m;
        }
        return (bb5) invokeV.objValue;
    }

    public final SocketMessageTask l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            SocketMessageTask socketMessageTask = new SocketMessageTask(303101);
            socketMessageTask.g(true);
            socketMessageTask.setResponsedClass(DistributeSocketResponse.class);
            return socketMessageTask;
        }
        return (SocketMessageTask) invokeV.objValue;
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f.hasMessages(1);
        }
        return invokeV.booleanValue;
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f.removeMessages(1);
            this.f.sendEmptyMessageDelayed(1, this.d);
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f.removeMessages(1);
        }
    }

    public bb5() {
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
        this.f = new a(this, Looper.getMainLooper());
        this.g = new b(this, CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, 303101);
        this.h = new c(this, 2000994);
        this.i = new d(this, 2001118);
        new HashMap();
        new HashMap();
        new HashMap();
        this.b = new ArrayList<>();
        this.j = new ArrayList<>();
        this.k = new ArrayList<>();
        this.c = true;
        this.d = 60000L;
        this.e = 10;
        this.a = BdNetTypeUtil.isNetWorkAvailable();
    }

    public final synchronized void g(List<AdReq> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            synchronized (this) {
                if (this.b != null) {
                    this.b.addAll(list);
                }
            }
        }
    }

    public final void s(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048587, this, z) != null) || this.a == z) {
            return;
        }
        this.a = z;
        if (z) {
            h(true);
        } else {
            w();
        }
    }

    public void t(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            if (i > 3600) {
                this.d = 300000L;
            } else if (i <= 0) {
                this.d = 60000L;
            } else {
                this.d = i * 1000;
            }
        }
    }

    public void u(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            if (i > 20) {
                this.e = 10;
            } else if (i <= 0) {
                this.e = 5;
            } else {
                this.e = i;
            }
        }
    }

    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.c = z;
        }
    }

    public final void h(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && this.a && this.c) {
            List<AdReq> k = k(z);
            if (z || !n()) {
                r();
            }
            if (k != null && k.size() != 0) {
                if (!z) {
                    r();
                }
                MessageManager.getInstance().sendMessage(new DistributeRequest(k));
            }
        }
    }

    public final synchronized List<AdReq> k(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            synchronized (this) {
                if (!z) {
                    if (this.b.size() < this.e) {
                        return null;
                    }
                }
                if (this.b.size() <= 0) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.b);
                this.b.clear();
                return arrayList;
            }
        }
        return (List) invokeZ.objValue;
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            MessageManager messageManager = MessageManager.getInstance();
            if (z) {
                messageManager.registerTask(l());
            }
            messageManager.registerTask(i());
            messageManager.registerListener(this.g);
            messageManager.registerListener(this.h);
            messageManager.registerListener(this.i);
        }
    }

    public final HttpMessageTask i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            HttpMessageTask httpMessageTask = new HttpMessageTask(CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, TbConfig.SERVER_ADDRESS + TbConfig.LOG_TOGETHER + "?cmd=303101");
            httpMessageTask.setResponsedClass(DistributeHttpResponse.class);
            return httpMessageTask;
        }
        return (HttpMessageTask) invokeV.objValue;
    }

    public void x(Context context, String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{context, str, str2, Long.valueOf(j)}) == null) {
            if (TextUtils.equals(str, "frs")) {
                y(context, this.j, str, str2, j);
            } else if (TextUtils.equals(str, "pb")) {
                y(context, this.k, str, str2, j);
            }
        }
    }

    public final void y(Context context, ArrayList<AdvertAppInfo> arrayList, String str, String str2, long j) {
        ArrayList<AdvertAppInfo> arrayList2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{context, arrayList, str, str2, Long.valueOf(j)}) == null) && (arrayList2 = arrayList) != null && arrayList.size() > 0) {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            StringBuilder sb4 = new StringBuilder();
            StringBuilder sb5 = new StringBuilder();
            StringBuilder sb6 = new StringBuilder();
            StringBuilder sb7 = new StringBuilder();
            StringBuilder sb8 = new StringBuilder();
            StringBuilder sb9 = new StringBuilder();
            StringBuilder sb10 = new StringBuilder();
            StringBuilder sb11 = new StringBuilder();
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                AdvertAppInfo advertAppInfo = arrayList2.get(i);
                if (advertAppInfo != null) {
                    if (i == size - 1) {
                        sb2.append(advertAppInfo.f);
                        sb3.append(advertAppInfo.a);
                        sb5.append(advertAppInfo.g);
                        sb7.append(advertAppInfo.l);
                    } else {
                        sb2.append(advertAppInfo.f);
                        sb2.append("|");
                        sb3.append(advertAppInfo.a);
                        sb3.append("|");
                        sb5.append(advertAppInfo.g);
                        sb5.append("|");
                        sb7.append(advertAppInfo.l);
                        sb7.append("|");
                    }
                }
                i++;
                arrayList2 = arrayList;
            }
            StringBuilder sb12 = new StringBuilder(15);
            sb12.append(String.valueOf(ej.l(context)));
            sb12.append(",");
            sb12.append(String.valueOf(ej.j(context)));
            TiebaStatic.eventStat(context, "ad_distribute", null, 1, "da_task", "tbda", BdVideoAd.AD_VIDEO_DAPAGE, str, "da_locate", sb2, "da_type", "show", "da_obj_id", sb3, "fid", str2, "tid", Long.valueOf(j), "da_good_id", sb4, "da_ext_info", sb5, "da_price", sb6, "da_verify", sb, "cuid", TbadkCoreApplication.getInst().getCuid(), "uid", TbadkCoreApplication.getCurrentAccount(), "baiduid", TbadkCoreApplication.getCurrentBduss(), "da_obj_name", sb7, "da_first_name", sb8, "da_second_name", sb9, "da_cpid", sb10, "da_abtest", sb11, "da_stime", Long.valueOf(System.currentTimeMillis()), "phone_screen", sb12.toString(), "model", gj.g());
            arrayList.clear();
        }
    }
}

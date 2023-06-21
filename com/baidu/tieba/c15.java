package com.baidu.tieba;

import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.bigday.GetBigdayInfoHttpResMessage;
import com.baidu.tbadk.core.bigday.GetBigdayInfoReqMessage;
import com.baidu.tbadk.core.bigday.GetBigdayInfoSocketResMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.core.util.resourceLoaderProc.BigdayImageLoaderProc;
import com.baidu.tbadk.switchs.BigdaySwitch;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.GetBigday.BigdayInfo;
import tbclient.GetBigday.GetBigdayResIdl;
/* loaded from: classes5.dex */
public class c15 {
    public static /* synthetic */ Interceptable $ic;
    public static c15 h;
    public transient /* synthetic */ FieldHolder $fh;
    public b15 a;
    public b15 b;
    public SparseArray<Long> c;
    public ArrayList<b15> d;
    public BdUniqueId e;
    public boolean f;
    public jb g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947621922, "Lcom/baidu/tieba/c15;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947621922, "Lcom/baidu/tieba/c15;");
        }
    }

    /* loaded from: classes5.dex */
    public class a extends jb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c15 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c15 c15Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c15Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = c15Var;
        }

        @Override // com.baidu.tieba.jb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && responsedMessage != null && !responsedMessage.hasError()) {
                this.a.f = true;
                ArrayList<b15> arrayList = null;
                if (responsedMessage instanceof GetBigdayInfoSocketResMessage) {
                    arrayList = ((GetBigdayInfoSocketResMessage) responsedMessage).bigdayInfos;
                } else if (responsedMessage instanceof GetBigdayInfoHttpResMessage) {
                    arrayList = ((GetBigdayInfoHttpResMessage) responsedMessage).bigdayInfos;
                }
                this.a.m(arrayList);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<Void, Void, ArrayList<b15>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c15 a;

        public b(c15 c15Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c15Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c15Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ArrayList<b15> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) {
                super.onPostExecute(arrayList);
                if (arrayList == null) {
                    return;
                }
                this.a.l(arrayList);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ArrayList<b15> doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            byte[] bArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                ArrayList<b15> arrayList = new ArrayList<>();
                c55.d();
                we<byte[]> b = c55.b("tb.bigday_datas");
                if (b != null && (bArr = b.get("tb.bigday_datas")) != null) {
                    try {
                        GetBigdayResIdl getBigdayResIdl = (GetBigdayResIdl) new Wire(new Class[0]).parseFrom(bArr, GetBigdayResIdl.class);
                        if (getBigdayResIdl.data != null) {
                            for (BigdayInfo bigdayInfo : getBigdayResIdl.data.bigday_list) {
                                if (bigdayInfo != null) {
                                    b15 b15Var = new b15();
                                    b15Var.b(bigdayInfo);
                                    if (b15Var.a()) {
                                        arrayList.add(b15Var);
                                    }
                                }
                            }
                            return arrayList;
                        }
                        return arrayList;
                    } catch (Exception unused) {
                        return null;
                    }
                }
                return arrayList;
            }
            return (ArrayList) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class c extends DiskFileOperate implements bc {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ArrayList<String> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, String str2, DiskFileOperate.Action action, ArrayList<b15> arrayList) {
            super(str, str2, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, action, arrayList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (String) objArr2[1], (DiskFileOperate.Action) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new ArrayList<>();
            Iterator<b15> it = arrayList.iterator();
            while (it.hasNext()) {
                b15 next = it.next();
                if (next != null) {
                    String g = qg.h().g(next.a, 41);
                    if (!StringUtils.isNULL(g)) {
                        String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(g);
                        if (!StringUtils.isNULL(nameMd5FromUrl)) {
                            this.a.add(nameMd5FromUrl);
                        }
                    }
                }
            }
        }

        @Override // com.baidu.tieba.bc
        public boolean compare(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, file)) == null) {
                if (file != null && !StringUtils.isNULL(file.getName())) {
                    return !this.a.contains(file.getName());
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    public c15() {
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
        this.f = false;
        this.g = new a(this, CmdConfigHttp.CMD_GET_BIGDAY_INFO, 309609);
        jz9.h(309609, GetBigdayInfoSocketResMessage.class, false, false);
        jz9.c(309609, CmdConfigHttp.CMD_GET_BIGDAY_INFO, "c/s/getBigday", GetBigdayInfoHttpResMessage.class, false, false, true, false);
        MessageManager.getInstance().registerListener(this.g);
        this.c = new SparseArray<>();
    }

    public static c15 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (h == null) {
                h = new c15();
            }
            return h;
        }
        return (c15) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.g);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            new b(this).execute(new Void[0]);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f = false;
            GetBigdayInfoReqMessage getBigdayInfoReqMessage = new GetBigdayInfoReqMessage();
            getBigdayInfoReqMessage.setTag(this.e);
            MessageManager.getInstance().sendMessage(getBigdayInfoReqMessage);
        }
    }

    public final void d(ArrayList<b15> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, arrayList) == null) {
            ArrayList arrayList2 = new ArrayList();
            ListUtils.addAll(arrayList2, 0, arrayList);
            ListUtils.add(arrayList2, this.a);
            ListUtils.add(arrayList2, this.b);
            c cVar = new c(TbConfig.BIGDAY_IMAGE_CACHE_DIR_NAME, null, DiskFileOperate.Action.DELETE_FILES, arrayList2);
            cVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.setSdCard(false);
            cVar.setSavedCache(true);
            ec.f().a(cVar);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || ListUtils.isEmpty(this.d)) {
            return;
        }
        Iterator<b15> it = this.d.iterator();
        while (it.hasNext()) {
            b15 next = it.next();
            if (!BigdayImageLoaderProc.isImageFileExist(next.a)) {
                qg.h().m(next.a, 41, null, this.e);
            }
        }
    }

    public final b15 g(List<b15> list, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, list, i)) == null) {
            if (!ListUtils.isEmpty(list)) {
                for (b15 b15Var : list) {
                    if (b15Var.a() && b15Var.e == i) {
                        long currentTimeMillis = System.currentTimeMillis() / 1000;
                        long j = b15Var.f;
                        if (j > currentTimeMillis) {
                            this.c.put(i, Long.valueOf(j));
                            return null;
                        } else if (b15Var.g >= currentTimeMillis) {
                            return b15Var;
                        }
                    }
                }
                return null;
            }
            return null;
        }
        return (b15) invokeLI.objValue;
    }

    public b15 h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (i == 1) {
                if (this.a == null && this.c.get(i, 0L).longValue() != 0 && this.c.get(i, 0L).longValue() < currentTimeMillis) {
                    this.a = g(this.d, 1);
                }
                b15 b15Var = this.a;
                if (b15Var != null && (currentTimeMillis < b15Var.f || currentTimeMillis > b15Var.g)) {
                    this.a = g(this.d, 1);
                }
                b15 b15Var2 = this.a;
                if (b15Var2 != null && BigdayImageLoaderProc.isImageFileExist(b15Var2.a)) {
                    return this.a;
                }
            } else if (i == 3) {
                if (this.b == null && this.c.get(i, 0L).longValue() != 0 && this.c.get(i, 0L).longValue() < currentTimeMillis) {
                    this.a = g(this.d, 3);
                }
                b15 b15Var3 = this.b;
                if (b15Var3 != null && (currentTimeMillis < b15Var3.f || currentTimeMillis > b15Var3.g)) {
                    this.b = g(this.d, 3);
                }
                b15 b15Var4 = this.b;
                if (b15Var4 != null && BigdayImageLoaderProc.isImageFileExist(b15Var4.a)) {
                    return this.b;
                }
            }
            return null;
        }
        return (b15) invokeI.objValue;
    }

    public final void l(ArrayList<b15> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, arrayList) != null) || ListUtils.isEmpty(arrayList) || this.f) {
            return;
        }
        this.a = g(arrayList, 1);
        this.b = g(arrayList, 3);
        this.d = arrayList;
        f();
        b15 b15Var = this.a;
        if (b15Var != null && BigdayImageLoaderProc.isImageFileExist(b15Var.a) && SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > o95.p().r("key_bigday_next_showtime_home", 0L)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, this.a));
        }
    }

    public final void m(ArrayList<b15> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList) == null) {
            b15 g = g(arrayList, 1);
            b15 g2 = g(arrayList, 3);
            d(arrayList);
            this.d = arrayList;
            if (g != null && g.a()) {
                this.a = g;
            }
            if (g2 != null && g2.a()) {
                this.b = g2;
            }
            f();
            b15 b15Var = this.a;
            if (b15Var != null && BigdayImageLoaderProc.isImageFileExist(b15Var.a) && SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > o95.p().r("key_bigday_next_showtime_home", 0L)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, this.a));
            }
        }
    }

    public void n(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            this.e = bdUniqueId;
        }
    }
}

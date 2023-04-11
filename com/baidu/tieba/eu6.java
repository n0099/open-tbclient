package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.du6;
import com.baidu.tieba.faceshop.DiyEmotionData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class eu6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public du6 a;
    public Handler b;

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ List b;
        public final /* synthetic */ eu6 c;

        /* loaded from: classes4.dex */
        public class a implements du6.k {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // com.baidu.tieba.du6.k
            public void a(int i, int i2, int i3, @Nullable Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), obj}) == null) {
                    b bVar = this.a;
                    bVar.c.g(bVar.b);
                }
            }
        }

        public b(eu6 eu6Var, List list, List list2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eu6Var, list, list2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = eu6Var;
            this.a = list;
            this.b = list2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.a.h(this.a, false, new a(this));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements du6.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ Map b;
        public final /* synthetic */ eu6 c;

        public a(eu6 eu6Var, List list, Map map) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eu6Var, list, map};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = eu6Var;
            this.a = list;
            this.b = map;
        }

        @Override // com.baidu.tieba.du6.k
        public void a(int i, int i2, int i3, @Nullable Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), obj}) == null) {
                this.c.d(this.a, this.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements du6.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(eu6 eu6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eu6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.du6.k
        public void a(int i, int i2, int i3, @Nullable Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), obj}) == null) {
                if (i2 > 0) {
                    BdLog.e("NewFaceSyncUtil setCollectUpdateTime reSortLocalFace Called:" + System.currentTimeMillis());
                    ip8.v(System.currentTimeMillis());
                }
                ip8.o().x(false);
            }
        }
    }

    public eu6() {
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
        this.a = du6.q();
        this.b = new Handler(Looper.getMainLooper());
    }

    public final void g(List<DiyEmotionData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            fp8.a("【表情云同步】：5 - DIY表情：根据云端数据进行排序");
            this.a.r(list, false, new c(this));
        }
    }

    public final void d(List<DiyEmotionData> list, Map<String, DiyEmotionData> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, list, map) == null) {
            ArrayList<DiyEmotionData> arrayList = new ArrayList();
            for (DiyEmotionData diyEmotionData : list) {
                if (diyEmotionData != null && !map.containsKey(diyEmotionData.getPid()) && !TextUtils.isEmpty(diyEmotionData.getPicUrl())) {
                    arrayList.add(diyEmotionData);
                }
            }
            if (!arrayList.isEmpty()) {
                fp8.a("【表情云同步】：4 - DIY表情：下载本地没有的表情");
                ArrayList arrayList2 = new ArrayList();
                for (DiyEmotionData diyEmotionData2 : arrayList) {
                    uf5 uf5Var = new uf5();
                    uf5Var.f = diyEmotionData2.getPkgId();
                    uf5Var.a = diyEmotionData2.getPid();
                    uf5Var.d = diyEmotionData2.getPicUrl();
                    uf5Var.b = diyEmotionData2.getWidth();
                    uf5Var.c = diyEmotionData2.getHeight();
                    uf5Var.e = diyEmotionData2.getThumbnail();
                    arrayList2.add(uf5Var);
                }
                this.b.post(new b(this, arrayList2, list));
                return;
            }
            g(list);
        }
    }

    public final void e(List<DiyEmotionData> list, List<DiyEmotionData> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, list2) == null) {
            ArrayList arrayList = new ArrayList();
            Map<String, DiyEmotionData> h = h(list2);
            Map<String, DiyEmotionData> h2 = h(list);
            for (Map.Entry<String, DiyEmotionData> entry : h.entrySet()) {
                if (!h2.containsKey(entry.getKey())) {
                    arrayList.add(entry.getValue());
                }
            }
            if (!arrayList.isEmpty()) {
                fp8.a("【表情云同步】：4 - DIY表情：删除云端没有的表情");
                this.a.t(arrayList, false, new a(this, list, h));
                return;
            }
            d(list, h);
        }
    }

    public void f(List<DiyEmotionData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            du6.q().j(true);
            List<DiyEmotionData> r = pt6.o().r(TbadkCoreApplication.getCurrentAccountForEmotion());
            for (DiyEmotionData diyEmotionData : r) {
                String n = du6.n(diyEmotionData.getPid(), false);
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setFilePath(n);
                diyEmotionData.imageFileInfo = imageFileInfo;
            }
            BdLog.e("NewFaceSyncUtil MergeCollectFace Called CloudList:");
            Iterator<DiyEmotionData> it = list.iterator();
            while (it.hasNext()) {
                BdLog.e("NewFaceSyncUtil Cloud data:" + it.next().getPkgId());
            }
            BdLog.e("NewFaceSyncUtil MergeCollectFace Called localList:");
            Iterator<DiyEmotionData> it2 = r.iterator();
            while (it2.hasNext()) {
                BdLog.e("NewFaceSyncUtil Local data:" + it2.next().getPkgId());
            }
            e(list, r);
        }
    }

    public final Map<String, DiyEmotionData> h(List<DiyEmotionData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, list)) == null) {
            HashMap hashMap = new HashMap();
            if (list != null) {
                for (DiyEmotionData diyEmotionData : list) {
                    if (diyEmotionData != null && !TextUtils.isEmpty(diyEmotionData.getPid())) {
                        hashMap.put(diyEmotionData.getPid(), diyEmotionData);
                    }
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }
}

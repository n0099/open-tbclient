package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.a57;
import com.baidu.tieba.faceshop.CollectEmotionData;
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
/* loaded from: classes5.dex */
public class c57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a57 a;
    public Handler b;

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ List b;
        public final /* synthetic */ c57 c;

        /* loaded from: classes5.dex */
        public class a implements a57.l {
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

            @Override // com.baidu.tieba.a57.l
            public void onResult(int i, int i2, int i3) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIII(1048576, this, i, i2, i3) == null) {
                    b bVar = this.a;
                    bVar.c.g(bVar.b);
                }
            }
        }

        public b(c57 c57Var, List list, List list2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c57Var, list, list2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = c57Var;
            this.a = list;
            this.b = list2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.a.i(this.a, false, new a(this));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements a57.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ Map b;
        public final /* synthetic */ c57 c;

        public a(c57 c57Var, List list, Map map) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c57Var, list, map};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = c57Var;
            this.a = list;
            this.b = map;
        }

        @Override // com.baidu.tieba.a57.l
        public void onResult(int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(1048576, this, i, i2, i3) == null) {
                this.c.d(this.a, this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a57.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(c57 c57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c57Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.a57.l
        public void onResult(int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(1048576, this, i, i2, i3) == null) {
                if (i2 > 0) {
                    BdLog.e("NewFaceSyncUtil setCollectUpdateTime reSortLocalFace Called:" + System.currentTimeMillis());
                    fb9.u(System.currentTimeMillis());
                }
                fb9.o().x(false);
            }
        }
    }

    public c57() {
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
        this.a = a57.t();
        this.b = new Handler(Looper.getMainLooper());
    }

    public final void g(List<CollectEmotionData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            cb9.a("【表情云同步】：5 - 收藏表情：根据云端数据进行排序");
            this.a.u(list, false, new c(this));
        }
    }

    public final void d(List<CollectEmotionData> list, Map<String, CollectEmotionData> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, list, map) == null) {
            ArrayList<CollectEmotionData> arrayList = new ArrayList();
            for (CollectEmotionData collectEmotionData : list) {
                if (collectEmotionData != null && !map.containsKey(collectEmotionData.pid) && !TextUtils.isEmpty(collectEmotionData.picUrl)) {
                    arrayList.add(collectEmotionData);
                }
            }
            if (!arrayList.isEmpty()) {
                cb9.a("【表情云同步】：4 - 收藏表情：下载本地没有的表情");
                ArrayList arrayList2 = new ArrayList();
                for (CollectEmotionData collectEmotionData2 : arrayList) {
                    in5 in5Var = new in5();
                    in5Var.f = collectEmotionData2.pkgId;
                    in5Var.a = collectEmotionData2.pid;
                    in5Var.d = collectEmotionData2.picUrl;
                    in5Var.b = collectEmotionData2.width;
                    in5Var.c = collectEmotionData2.height;
                    in5Var.e = collectEmotionData2.thumbnail;
                    arrayList2.add(in5Var);
                }
                this.b.post(new b(this, arrayList2, list));
                return;
            }
            g(list);
        }
    }

    public final void e(List<CollectEmotionData> list, List<CollectEmotionData> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, list2) == null) {
            ArrayList arrayList = new ArrayList();
            Map<String, CollectEmotionData> h = h(list2);
            Map<String, CollectEmotionData> h2 = h(list);
            for (Map.Entry<String, CollectEmotionData> entry : h.entrySet()) {
                if (!h2.containsKey(entry.getKey())) {
                    arrayList.add(entry.getValue());
                }
            }
            if (!arrayList.isEmpty()) {
                cb9.a("【表情云同步】：4 - 收藏表情：删除云端没有的表情");
                this.a.x(arrayList, false, new a(this, list, h));
                return;
            }
            d(list, h);
        }
    }

    public void f(List<CollectEmotionData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            a57.t().l(true);
            List<CollectEmotionData> q = q47.o().q(TbadkCoreApplication.getCurrentAccountForEmotion());
            for (CollectEmotionData collectEmotionData : q) {
                String p = a57.p(collectEmotionData.pid, false);
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setFilePath(p);
                collectEmotionData.imageFileInfo = imageFileInfo;
            }
            BdLog.e("NewFaceSyncUtil MergeCollectFace Called CloudList:");
            Iterator<CollectEmotionData> it = list.iterator();
            while (it.hasNext()) {
                BdLog.e("NewFaceSyncUtil Cloud data:" + it.next().pkgId);
            }
            BdLog.e("NewFaceSyncUtil MergeCollectFace Called localList:");
            Iterator<CollectEmotionData> it2 = q.iterator();
            while (it2.hasNext()) {
                BdLog.e("NewFaceSyncUtil Local data:" + it2.next().pkgId);
            }
            e(list, q);
        }
    }

    public final Map<String, CollectEmotionData> h(List<CollectEmotionData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, list)) == null) {
            HashMap hashMap = new HashMap();
            if (list != null) {
                for (CollectEmotionData collectEmotionData : list) {
                    if (collectEmotionData != null && !TextUtils.isEmpty(collectEmotionData.pid)) {
                        hashMap.put(collectEmotionData.pid, collectEmotionData);
                    }
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }
}

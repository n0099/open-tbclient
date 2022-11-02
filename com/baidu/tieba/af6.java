package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.httpNet.WebClient;
import com.baidu.tbadk.img.GetEmotionInfosModel;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.UploadedImageInfo;
import com.baidu.tbadk.mutiprocess.event.CollectEmotionEvent;
import com.baidu.tieba.faceshop.CollectEmotionData;
import com.baidu.tieba.faceshop.UserCollectModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public class af6 {
    public static /* synthetic */ Interceptable $ic;
    public static af6 b;
    public transient /* synthetic */ FieldHolder $fh;
    public GetEmotionInfosModel a;

    /* loaded from: classes3.dex */
    public interface j {
        void onFail();

        void onSuccess();
    }

    /* loaded from: classes3.dex */
    public interface l {
        void onResult(int i, int i2, int i3);
    }

    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Void, Void, Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l a;
        public final /* synthetic */ List b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ af6 d;

        public a(af6 af6Var, l lVar, List list, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {af6Var, lVar, list, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = af6Var;
            this.a = lVar;
            this.b = list;
            this.c = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Integer doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                return Integer.valueOf(qe6.o().l(TbadkCoreApplication.getCurrentAccount()) - 1);
            }
            return (Integer) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, num) == null) {
                if (num.intValue() >= 300) {
                    l lVar = this.a;
                    if (lVar != null) {
                        lVar.onResult(4, 0, 0);
                        return;
                    } else {
                        xi.O(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f10d5);
                        return;
                    }
                }
                while (this.b.size() + num.intValue() > 300) {
                    List list = this.b;
                    list.remove(list.size() - 1);
                }
                this.d.j(this.b, this.c, this.a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements GetEmotionInfosModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l a;
        public final /* synthetic */ Map b;
        public final /* synthetic */ List c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ af6 e;

        public b(af6 af6Var, l lVar, Map map, List list, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {af6Var, lVar, map, list, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = af6Var;
            this.a = lVar;
            this.b = map;
            this.c = list;
            this.d = z;
        }

        @Override // com.baidu.tbadk.img.GetEmotionInfosModel.b
        public void onFail(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                l lVar = this.a;
                if (lVar == null) {
                    xi.O(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f10d4);
                } else {
                    lVar.onResult(4, 0, 0);
                }
            }
        }

        @Override // com.baidu.tbadk.img.GetEmotionInfosModel.b
        public void onSuccess(List<i95> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                if (list == null || list.isEmpty()) {
                    l lVar = this.a;
                    if (lVar == null) {
                        xi.O(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f10d4);
                    } else {
                        lVar.onResult(4, 0, 0);
                    }
                }
                for (i95 i95Var : list) {
                    if (!bf6.e().f(i95Var.a)) {
                        i95Var.f = (String) this.b.get(i95Var.g);
                        this.c.add(i95Var);
                    }
                }
                this.e.n(this.c, this.a, this.d);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ i95 b;
        public final /* synthetic */ AtomicInteger c;
        public final /* synthetic */ l d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ af6 f;

        public c(af6 af6Var, List list, i95 i95Var, AtomicInteger atomicInteger, l lVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {af6Var, list, i95Var, atomicInteger, lVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = af6Var;
            this.a = list;
            this.b = i95Var;
            this.c = atomicInteger;
            this.d = lVar;
            this.e = z;
        }

        @Override // com.baidu.tieba.af6.j
        public void onFail() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.c.decrementAndGet() == 0) {
                this.f.f(this.a, this.d, this.e);
            }
        }

        @Override // com.baidu.tieba.af6.j
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.add(this.f.y(this.b));
                if (this.c.decrementAndGet() == 0) {
                    this.f.f(this.a, this.d, this.e);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends BdAsyncTask<Void, Void, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ l b;
        public final /* synthetic */ boolean c;

        public d(af6 af6Var, List list, l lVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {af6Var, list, lVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = list;
            this.b = lVar;
            this.c = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                return Boolean.valueOf(qe6.o().b(this.a));
            }
            return (Boolean) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bool) == null) {
                if (bool != null && bool.booleanValue()) {
                    l lVar = this.b;
                    if (lVar == null) {
                        List list = this.a;
                        if (list != null && !list.isEmpty() && this.a.get(0) != null) {
                            mb5.i(new CollectEmotionEvent(((CollectEmotionData) this.a.get(0)).pid));
                        }
                        xi.O(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f10d6);
                    } else {
                        lVar.onResult(4, 1, 0);
                    }
                    bf6.e().g();
                    if (this.c) {
                        new UserCollectModel().z();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921028));
                    TiebaStatic.log("c12222");
                    return;
                }
                l lVar2 = this.b;
                if (lVar2 == null) {
                    xi.O(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f10d4);
                } else {
                    lVar2.onResult(4, 0, 0);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends BdAsyncTask<Void, Void, List<Integer>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ l b;
        public final /* synthetic */ boolean c;

        public e(af6 af6Var, List list, l lVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {af6Var, list, lVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = list;
            this.b = lVar;
            this.c = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<Integer> doInBackground(Void[] voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                List<CollectEmotionData> q = qe6.o().q(TbadkCoreApplication.getCurrentAccountForEmotion());
                HashMap hashMap = new HashMap();
                for (CollectEmotionData collectEmotionData : q) {
                    hashMap.put(collectEmotionData.getSharpText(), collectEmotionData);
                }
                int size = q.size() - 2;
                for (int i = 0; i < this.a.size(); i++) {
                    CollectEmotionData collectEmotionData2 = (CollectEmotionData) this.a.get(i);
                    collectEmotionData2.setOrderId(size);
                    String sharpText = collectEmotionData2.getSharpText();
                    if (hashMap.containsKey(sharpText)) {
                        q.remove(hashMap.get(sharpText));
                        hashMap.remove(sharpText);
                    }
                    qe6.o().v(collectEmotionData2);
                    size--;
                }
                for (int i2 = 0; i2 < q.size(); i2++) {
                    CollectEmotionData collectEmotionData3 = q.get(i2);
                    if (!f95.f.equals(collectEmotionData3.getSharpText())) {
                        collectEmotionData3.setOrderId(size);
                        qe6.o().v(collectEmotionData3);
                        size--;
                    }
                }
                if (this.a.size() > 0) {
                    bf6.e().g();
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(Integer.valueOf(this.a.size()));
                arrayList.add(0);
                return arrayList;
            }
            return (List) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<Integer> list) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) && this.b != null && list != null && list.size() == 2) {
                this.b.onResult(2, list.get(0).intValue(), list.get(1).intValue());
                if (list.get(0).intValue() > 0) {
                    if (this.c) {
                        new UserCollectModel().z();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921028));
                    StatisticItem statisticItem = new StatisticItem("c12227");
                    statisticItem.param("obj_param1", list.get(0).intValue());
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f extends BdAsyncTask<Void, Void, List<Integer>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ l b;
        public final /* synthetic */ boolean c;

        public f(af6 af6Var, List list, l lVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {af6Var, list, lVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = list;
            this.b = lVar;
            this.c = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<Integer> doInBackground(Void[] voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                int i = 0;
                for (CollectEmotionData collectEmotionData : this.a) {
                    if (collectEmotionData != null && !"setting_icon".equals(collectEmotionData.pid) && !f95.f.equals(collectEmotionData.getSharpText())) {
                        qe6.o().i(collectEmotionData);
                        ImageFileInfo imageFileInfo = collectEmotionData.imageFileInfo;
                        if (imageFileInfo != null && !TextUtils.isEmpty(imageFileInfo.getFilePath())) {
                            File file = new File(collectEmotionData.imageFileInfo.getFilePath());
                            if (file.exists()) {
                                file.delete();
                            }
                            String filePath = collectEmotionData.imageFileInfo.getFilePath();
                            File file2 = new File(filePath.replace("_s.jpg", "_b.jpg"));
                            if (file2.exists()) {
                                file2.delete();
                            }
                            File file3 = new File(filePath.replace("_s.jpg", "_b.gif"));
                            if (file3.exists()) {
                                file3.delete();
                            }
                        }
                        i++;
                    }
                }
                List<CollectEmotionData> q = qe6.o().q(TbadkCoreApplication.getCurrentAccount());
                for (int i2 = 0; i2 < q.size(); i2++) {
                    CollectEmotionData collectEmotionData2 = q.get(i2);
                    if (!f95.f.equals(collectEmotionData2.getSharpText())) {
                        collectEmotionData2.setOrderId((q.size() - i2) - 1);
                        qe6.o().v(collectEmotionData2);
                    }
                }
                if (i > 0) {
                    bf6.e().g();
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(Integer.valueOf(i));
                arrayList.add(Integer.valueOf(this.a.size() - i));
                return arrayList;
            }
            return (List) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<Integer> list) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) && this.b != null && list != null && list.size() == 2) {
                this.b.onResult(1, list.get(0).intValue(), list.get(1).intValue());
                if (list.get(0).intValue() > 0) {
                    if (this.c) {
                        new UserCollectModel().z();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921028));
                    StatisticItem statisticItem = new StatisticItem("c12226");
                    statisticItem.param("obj_param1", list.get(0).intValue());
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g extends BdAsyncTask<Void, Void, List<Integer>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ l b;
        public final /* synthetic */ af6 c;

        public g(af6 af6Var, List list, l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {af6Var, list, lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = af6Var;
            this.a = list;
            this.b = lVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<Integer> doInBackground(Void[] voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                int i = 0;
                for (CollectEmotionData collectEmotionData : this.a) {
                    String filePath = collectEmotionData.imageFileInfo.getFilePath();
                    File file = new File(filePath.replace("_s.jpg", "_b.jpg"));
                    byte[] bArr = null;
                    if (file.exists()) {
                        bArr = this.c.s(file);
                    }
                    if (bArr == null) {
                        bArr = this.c.s(new File(filePath.replace("_s.jpg", "_b.gif")));
                    }
                    if (bArr != null && FileHelper.saveImageFileByUser(collectEmotionData.picUrl, bArr, TbadkCoreApplication.getInst().getContext()) == 0) {
                        i++;
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(Integer.valueOf(i));
                arrayList.add(Integer.valueOf(this.a.size() - i));
                return arrayList;
            }
            return (List) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<Integer> list) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) && this.b != null && list != null && list.size() == 2) {
                this.b.onResult(3, list.get(0).intValue(), list.get(1).intValue());
                if (list.get(0).intValue() > 0) {
                    StatisticItem statisticItem = new StatisticItem("c12228");
                    statisticItem.param("obj_param1", list.get(0).intValue());
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h extends BdAsyncTask<Void, Void, List<CollectEmotionData>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ af6 a;

        public h(af6 af6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {af6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = af6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<CollectEmotionData> doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                return this.a.q();
            }
            return (List) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<CollectEmotionData> list) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || list == null) {
                return;
            }
            for (CollectEmotionData collectEmotionData : list) {
                if (collectEmotionData != null) {
                    i95 i95Var = new i95();
                    i95Var.a = collectEmotionData.pid;
                    i95Var.f = collectEmotionData.pkgId;
                    i95Var.d = collectEmotionData.picUrl;
                    i95Var.e = collectEmotionData.thumbnail;
                    i95Var.b = collectEmotionData.width;
                    i95Var.c = collectEmotionData.height;
                    ct7.a("【表情云同步】：4 - 开始：重新下载数据库中有数据但是没文件的表情，" + i95Var.d);
                    new k(this.a, null).execute(i95Var);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.af6.l
        public void onResult(int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(1048576, this, i, i2, i3) == null) {
            }
        }

        public i(af6 af6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {af6Var};
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

    /* loaded from: classes3.dex */
    public class k extends BdAsyncTask<i95, Void, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public i95 a;
        public j b;
        public final /* synthetic */ af6 c;

        public k(af6 af6Var, j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {af6Var, jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = af6Var;
            this.b = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(i95[] i95VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, i95VarArr)) == null) {
                if (i95VarArr != null && i95VarArr.length > 0) {
                    this.a = i95VarArr[0];
                    WebClient webClient = new WebClient();
                    byte[] downloadImageBytes = webClient.downloadImageBytes(this.a.d, false);
                    if (downloadImageBytes == null || !webClient.IsRequestSuccess()) {
                        return Boolean.FALSE;
                    }
                    String r = this.c.r(this.a, true);
                    if (TextUtils.isEmpty(r)) {
                        return Boolean.FALSE;
                    }
                    if (xi.D(downloadImageBytes)) {
                        r = r.replace("_b.jpg", "_b.gif");
                    }
                    File file = new File(r);
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    if (!this.c.v(file, downloadImageBytes)) {
                        return Boolean.FALSE;
                    }
                    byte[] downloadImageBytes2 = webClient.downloadImageBytes(this.a.e, false);
                    if (downloadImageBytes2 == null || !webClient.IsRequestSuccess()) {
                        return Boolean.FALSE;
                    }
                    String r2 = this.c.r(this.a, false);
                    if (TextUtils.isEmpty(r2)) {
                        return Boolean.FALSE;
                    }
                    if (!this.c.v(new File(r2), downloadImageBytes2)) {
                        return Boolean.FALSE;
                    }
                    return Boolean.TRUE;
                }
                return Boolean.FALSE;
            }
            return (Boolean) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bool) == null) {
                if (bool != null && bool.booleanValue()) {
                    j jVar = this.b;
                    if (jVar != null) {
                        jVar.onSuccess();
                        return;
                    }
                    return;
                }
                j jVar2 = this.b;
                if (jVar2 != null) {
                    jVar2.onFail();
                }
            }
        }
    }

    public af6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static af6 t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (b == null) {
                b = new af6();
            }
            return b;
        }
        return (af6) invokeV.objValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            new h(this).execute(new Void[0]);
        }
    }

    public void g(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            h(str, null, str2, null);
        }
    }

    public void w(List<CollectEmotionData> list, l lVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048591, this, list, lVar) == null) && list != null && list.size() > 0) {
            new g(this, list, lVar).execute(new Void[0]);
        }
    }

    public final void f(List<CollectEmotionData> list, l lVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048576, this, list, lVar, z) == null) {
            new d(this, list, lVar, z).execute(new Void[0]);
        }
    }

    public void i(List<i95> list, boolean z, l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{list, Boolean.valueOf(z), lVar}) == null) {
            new a(this, lVar, list, z).execute(new Void[0]);
        }
    }

    public static String p(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65542, null, str, z)) == null) {
            String str2 = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/.collect/" + f95.d() + "/" + str + "_s.jpg";
            if (!z) {
                return str2;
            }
            String replace = str2.replace("_s.jpg", "_b.jpg");
            if (new File(replace).exists()) {
                return replace;
            }
            String replace2 = str2.replace("_s.jpg", "_b.gif");
            if (new File(replace2).exists()) {
                return replace2;
            }
            return "";
        }
        return (String) invokeLZ.objValue;
    }

    public final String r(i95 i95Var, boolean z) {
        InterceptResult invokeLZ;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048587, this, i95Var, z)) == null) {
            if (i95Var != null && !TextUtils.isEmpty(i95Var.d) && !TextUtils.isEmpty(i95Var.a)) {
                if (z) {
                    str = "_b.jpg";
                } else {
                    str = "_s.jpg";
                }
                return TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/.collect/" + f95.d() + "/" + i95Var.a + str;
            }
            return "";
        }
        return (String) invokeLZ.objValue;
    }

    public void h(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, str3, str4) == null) {
            if (ft7.o().p()) {
                xi.O(BdBaseApplication.getInst().getApp(), R.string.obfuscated_res_0x7f0f05fe);
                return;
            }
            i95 i95Var = new i95();
            i95Var.d = str;
            i95Var.e = str2;
            i95Var.f = str3;
            i95Var.a = str4;
            ArrayList arrayList = new ArrayList();
            arrayList.add(i95Var);
            i(arrayList, true, null);
        }
    }

    public void j(List<i95> list, boolean z, l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{list, Boolean.valueOf(z), lVar}) == null) {
            if (list != null && !list.isEmpty()) {
                if (!TbadkCoreApplication.isLogin()) {
                    if (lVar == null) {
                        ViewHelper.skipToLoginActivity(TbadkCoreApplication.getInst());
                        return;
                    } else {
                        lVar.onResult(4, 0, 0);
                        return;
                    }
                }
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                HashMap hashMap = new HashMap();
                for (i95 i95Var : list) {
                    String str = i95Var.a;
                    if (str != null && !TextUtils.isEmpty(str)) {
                        if (!bf6.e().f(i95Var.a)) {
                            arrayList.add(i95Var);
                        }
                    } else {
                        arrayList2.add(i95Var.d);
                        String str2 = i95Var.f;
                        if (str2 != null) {
                            hashMap.put(i95Var.d, str2);
                        }
                    }
                }
                if (arrayList2.size() > 0) {
                    if (this.a == null) {
                        this.a = new GetEmotionInfosModel();
                    }
                    this.a.B(arrayList2, new b(this, lVar, hashMap, arrayList, z));
                    return;
                }
                n(arrayList, lVar, z);
            } else if (lVar == null) {
                xi.O(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f10d4);
            } else {
                lVar.onResult(4, 0, 0);
            }
        }
    }

    public void k(List<String> list, l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, list, lVar) == null) {
            if (ListUtils.isEmpty(list) && lVar != null) {
                lVar.onResult(4, 0, 0);
            }
            if (ft7.o().p() && lVar != null) {
                xi.O(BdBaseApplication.getInst().getApp(), R.string.obfuscated_res_0x7f0f05fe);
                lVar.onResult(4, 0, 0);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                i95 i95Var = new i95();
                i95Var.d = str;
                arrayList.add(i95Var);
            }
            i(arrayList, true, lVar);
        }
    }

    public final boolean v(File file, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, file, bArr)) == null) {
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    try {
                        if ((file.exists() && !file.delete()) || !file.createNewFile()) {
                            return false;
                        }
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                        try {
                            fileOutputStream2.write(bArr, 0, bArr.length);
                            fileOutputStream2.flush();
                            fileOutputStream2.close();
                            return true;
                        } catch (IOException e2) {
                            e = e2;
                            fileOutputStream = fileOutputStream2;
                            BdLog.e(e.getMessage());
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            return false;
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        BdLog.e(th2.getMessage());
                        return false;
                    }
                } catch (IOException e3) {
                    e = e3;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } else {
            return invokeLL.booleanValue;
        }
    }

    public boolean l(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
            List<CollectEmotionData> q = q();
            if (q != null && !q.isEmpty()) {
                ct7.a("【表情云同步】：4 - 收藏表情：检查数据库中表情文件是否存在");
                if (z) {
                    x(q, false, new i(this));
                }
                return false;
            }
            return true;
        }
        return invokeZ.booleanValue;
    }

    public void m(List<CollectEmotionData> list, boolean z, l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{list, Boolean.valueOf(z), lVar}) == null) {
            if (list != null && list.size() > 0) {
                new f(this, list, lVar, z).execute(new Void[0]);
            } else if (lVar != null) {
                lVar.onResult(1, 1, 0);
            }
        }
    }

    public void u(List<CollectEmotionData> list, boolean z, l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{list, Boolean.valueOf(z), lVar}) == null) {
            if (list != null && list.size() > 0) {
                new e(this, list, lVar, z).execute(new Void[0]);
            } else if (lVar != null) {
                lVar.onResult(2, 0, 0);
            }
        }
    }

    public final void n(List<i95> list, l lVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, list, lVar, z) == null) {
            if (list.size() == 0) {
                if (lVar == null) {
                    xi.O(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f10d6);
                    return;
                } else {
                    lVar.onResult(4, 1, 0);
                    return;
                }
            }
            AtomicInteger atomicInteger = new AtomicInteger(list.size());
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            for (i95 i95Var : list) {
                new k(this, new c(this, copyOnWriteArrayList, i95Var, atomicInteger, lVar, z)).execute(i95Var);
            }
        }
    }

    public List<CollectEmotionData> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ArrayList arrayList = new ArrayList();
            List<CollectEmotionData> q = qe6.o().q(TbadkCoreApplication.getCurrentAccountForEmotion());
            if (q != null) {
                for (CollectEmotionData collectEmotionData : q) {
                    if (collectEmotionData != null && !"setting_icon".equals(collectEmotionData.pid) && !new File(p(collectEmotionData.pid, false)).exists()) {
                        arrayList.add(collectEmotionData);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [boolean] */
    public byte[] s(File file) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, file)) == null) {
            InputStream inputStream = null;
            if (file != null) {
                ?? exists = file.exists();
                try {
                    if (exists != 0) {
                        try {
                            fileInputStream = new FileInputStream(file);
                            try {
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int read = fileInputStream.read(bArr, 0, 1024);
                                    if (read != -1) {
                                        byteArrayOutputStream.write(bArr, 0, read);
                                    } else {
                                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                                        yi.e(fileInputStream);
                                        return byteArray;
                                    }
                                }
                            } catch (IOException e2) {
                                e = e2;
                                BdLog.e(e.getMessage());
                                yi.e(fileInputStream);
                                return null;
                            }
                        } catch (IOException e3) {
                            e = e3;
                            fileInputStream = null;
                        } catch (Throwable th) {
                            th = th;
                            yi.e(inputStream);
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = exists;
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }

    public void x(List<CollectEmotionData> list, boolean z, l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{list, Boolean.valueOf(z), lVar}) == null) {
            if (list != null && list.size() > 0) {
                int i2 = 0;
                for (CollectEmotionData collectEmotionData : list) {
                    if (collectEmotionData != null && !"setting_icon".equals(collectEmotionData.pid) && !f95.f.equals(collectEmotionData.getSharpText())) {
                        qe6.o().i(collectEmotionData);
                        ImageFileInfo imageFileInfo = collectEmotionData.imageFileInfo;
                        if (imageFileInfo != null && !TextUtils.isEmpty(imageFileInfo.getFilePath())) {
                            File file = new File(collectEmotionData.imageFileInfo.getFilePath());
                            if (file.exists()) {
                                file.delete();
                            }
                            String filePath = collectEmotionData.imageFileInfo.getFilePath();
                            File file2 = new File(filePath.replace("_s.jpg", "_b.jpg"));
                            if (file2.exists()) {
                                file2.delete();
                            }
                            File file3 = new File(filePath.replace("_s.jpg", "_b.gif"));
                            if (file3.exists()) {
                                file3.delete();
                            }
                        }
                        i2++;
                    }
                }
                List<CollectEmotionData> q = qe6.o().q(TbadkCoreApplication.getCurrentAccount());
                for (int i3 = 0; i3 < q.size(); i3++) {
                    CollectEmotionData collectEmotionData2 = q.get(i3);
                    if (!f95.f.equals(collectEmotionData2.getSharpText())) {
                        collectEmotionData2.setOrderId((q.size() - i3) - 1);
                        qe6.o().v(collectEmotionData2);
                    }
                }
                if (i2 > 0) {
                    bf6.e().g();
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(Integer.valueOf(i2));
                arrayList.add(Integer.valueOf(list.size() - i2));
                if (lVar != null && arrayList.size() == 2) {
                    lVar.onResult(1, ((Integer) arrayList.get(0)).intValue(), ((Integer) arrayList.get(1)).intValue());
                    if (((Integer) arrayList.get(0)).intValue() > 0) {
                        if (z) {
                            new UserCollectModel().z();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921028));
                        StatisticItem statisticItem = new StatisticItem("c12226");
                        statisticItem.param("obj_param1", ((Integer) arrayList.get(0)).intValue());
                        TiebaStatic.log(statisticItem);
                    }
                }
            } else if (lVar != null) {
                lVar.onResult(1, 1, 0);
            }
        }
    }

    public final CollectEmotionData y(i95 i95Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, i95Var)) == null) {
            CollectEmotionData collectEmotionData = new CollectEmotionData();
            StringBuilder sb = new StringBuilder(f95.h);
            if (TextUtils.isEmpty(i95Var.f)) {
                sb.append(i95Var.a);
                sb.append(",");
            } else {
                sb.append(i95Var.f);
                sb.append("_");
                sb.append(i95Var.a);
                sb.append(",");
            }
            sb.append(i95Var.b);
            sb.append(",");
            sb.append(i95Var.c);
            sb.append(",");
            String lowerCase = ej.c(sb.toString().replace("collect_", "") + UploadedImageInfo.MD5_KEY).toLowerCase();
            collectEmotionData.pid = i95Var.a;
            collectEmotionData.uid = TbadkCoreApplication.getCurrentAccount();
            collectEmotionData.setSharpText(SmallTailInfo.EMOTION_PREFIX + sb.toString() + lowerCase + SmallTailInfo.EMOTION_SUFFIX);
            collectEmotionData.setOrderId(qe6.o().l(collectEmotionData.uid) + 1);
            collectEmotionData.width = i95Var.b;
            collectEmotionData.height = i95Var.c;
            collectEmotionData.picUrl = i95Var.d;
            collectEmotionData.thumbnail = i95Var.e;
            collectEmotionData.backup = "";
            return collectEmotionData;
        }
        return (CollectEmotionData) invokeL.objValue;
    }
}

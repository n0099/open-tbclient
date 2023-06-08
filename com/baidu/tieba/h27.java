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
/* loaded from: classes6.dex */
public class h27 {
    public static /* synthetic */ Interceptable $ic;
    public static h27 b;
    public transient /* synthetic */ FieldHolder $fh;
    public GetEmotionInfosModel a;

    /* loaded from: classes6.dex */
    public interface j {
        void onFail();

        void onSuccess();
    }

    /* loaded from: classes6.dex */
    public interface l {
        void onResult(int i, int i2, int i3);
    }

    /* loaded from: classes6.dex */
    public class a extends BdAsyncTask<Void, Void, Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l a;
        public final /* synthetic */ List b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ h27 d;

        public a(h27 h27Var, l lVar, List list, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h27Var, lVar, list, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = h27Var;
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
                return Integer.valueOf(x17.o().l(TbadkCoreApplication.getCurrentAccount()) - 1);
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
                        vi.P(TbadkCoreApplication.getInst(), R.string.save_emotion_limit);
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

    /* loaded from: classes6.dex */
    public class b implements GetEmotionInfosModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l a;
        public final /* synthetic */ Map b;
        public final /* synthetic */ List c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ h27 e;

        public b(h27 h27Var, l lVar, Map map, List list, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h27Var, lVar, map, list, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = h27Var;
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
                    vi.P(TbadkCoreApplication.getInst(), R.string.save_emotion_failed);
                } else {
                    lVar.onResult(4, 0, 0);
                }
            }
        }

        @Override // com.baidu.tbadk.img.GetEmotionInfosModel.b
        public void onSuccess(List<bm5> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                if (list == null || list.isEmpty()) {
                    l lVar = this.a;
                    if (lVar == null) {
                        vi.P(TbadkCoreApplication.getInst(), R.string.save_emotion_failed);
                    } else {
                        lVar.onResult(4, 0, 0);
                    }
                }
                for (bm5 bm5Var : list) {
                    if (!i27.e().f(bm5Var.a)) {
                        bm5Var.f = (String) this.b.get(bm5Var.g);
                        this.c.add(bm5Var);
                    }
                }
                this.e.n(this.c, this.a, this.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ bm5 b;
        public final /* synthetic */ AtomicInteger c;
        public final /* synthetic */ l d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ h27 f;

        public c(h27 h27Var, List list, bm5 bm5Var, AtomicInteger atomicInteger, l lVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h27Var, list, bm5Var, atomicInteger, lVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = h27Var;
            this.a = list;
            this.b = bm5Var;
            this.c = atomicInteger;
            this.d = lVar;
            this.e = z;
        }

        @Override // com.baidu.tieba.h27.j
        public void onFail() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.c.decrementAndGet() == 0) {
                this.f.f(this.a, this.d, this.e);
            }
        }

        @Override // com.baidu.tieba.h27.j
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

    /* loaded from: classes6.dex */
    public class d extends BdAsyncTask<Void, Void, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ l b;
        public final /* synthetic */ boolean c;

        public d(h27 h27Var, List list, l lVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h27Var, list, lVar, Boolean.valueOf(z)};
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
                return Boolean.valueOf(x17.o().b(this.a));
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
                            ip5.i(new CollectEmotionEvent(((CollectEmotionData) this.a.get(0)).pid));
                        }
                        vi.P(TbadkCoreApplication.getInst(), R.string.save_emotion_success);
                    } else {
                        lVar.onResult(4, 1, 0);
                    }
                    i27.e().g();
                    if (this.c) {
                        new UserCollectModel().U();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921028));
                    TiebaStatic.log("c12222");
                    return;
                }
                l lVar2 = this.b;
                if (lVar2 == null) {
                    vi.P(TbadkCoreApplication.getInst(), R.string.save_emotion_failed);
                } else {
                    lVar2.onResult(4, 0, 0);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends BdAsyncTask<Void, Void, List<Integer>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ l b;
        public final /* synthetic */ boolean c;

        public e(h27 h27Var, List list, l lVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h27Var, list, lVar, Boolean.valueOf(z)};
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
                List<CollectEmotionData> q = x17.o().q(TbadkCoreApplication.getCurrentAccountForEmotion());
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
                    x17.o().v(collectEmotionData2);
                    size--;
                }
                for (int i2 = 0; i2 < q.size(); i2++) {
                    CollectEmotionData collectEmotionData3 = q.get(i2);
                    if (!yl5.f.equals(collectEmotionData3.getSharpText())) {
                        collectEmotionData3.setOrderId(size);
                        x17.o().v(collectEmotionData3);
                        size--;
                    }
                }
                if (this.a.size() > 0) {
                    i27.e().g();
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
                        new UserCollectModel().U();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921028));
                    StatisticItem statisticItem = new StatisticItem("c12227");
                    statisticItem.param("obj_param1", list.get(0).intValue());
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f extends BdAsyncTask<Void, Void, List<Integer>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ l b;
        public final /* synthetic */ boolean c;

        public f(h27 h27Var, List list, l lVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h27Var, list, lVar, Boolean.valueOf(z)};
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
                    if (collectEmotionData != null && !"setting_icon".equals(collectEmotionData.pid) && !yl5.f.equals(collectEmotionData.getSharpText())) {
                        x17.o().i(collectEmotionData);
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
                List<CollectEmotionData> q = x17.o().q(TbadkCoreApplication.getCurrentAccount());
                for (int i2 = 0; i2 < q.size(); i2++) {
                    CollectEmotionData collectEmotionData2 = q.get(i2);
                    if (!yl5.f.equals(collectEmotionData2.getSharpText())) {
                        collectEmotionData2.setOrderId((q.size() - i2) - 1);
                        x17.o().v(collectEmotionData2);
                    }
                }
                if (i > 0) {
                    i27.e().g();
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
                        new UserCollectModel().U();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921028));
                    StatisticItem statisticItem = new StatisticItem("c12226");
                    statisticItem.param("obj_param1", list.get(0).intValue());
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends BdAsyncTask<Void, Void, List<Integer>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ l b;
        public final /* synthetic */ h27 c;

        public g(h27 h27Var, List list, l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h27Var, list, lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = h27Var;
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

    /* loaded from: classes6.dex */
    public class h extends BdAsyncTask<Void, Void, List<CollectEmotionData>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h27 a;

        public h(h27 h27Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h27Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h27Var;
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
                    bm5 bm5Var = new bm5();
                    bm5Var.a = collectEmotionData.pid;
                    bm5Var.f = collectEmotionData.pkgId;
                    bm5Var.d = collectEmotionData.picUrl;
                    bm5Var.e = collectEmotionData.thumbnail;
                    bm5Var.b = collectEmotionData.width;
                    bm5Var.c = collectEmotionData.height;
                    sz8.a("【表情云同步】：4 - 开始：重新下载数据库中有数据但是没文件的表情，" + bm5Var.d);
                    new k(this.a, null).execute(bm5Var);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.h27.l
        public void onResult(int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(1048576, this, i, i2, i3) == null) {
            }
        }

        public i(h27 h27Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h27Var};
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

    /* loaded from: classes6.dex */
    public class k extends BdAsyncTask<bm5, Void, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public bm5 a;
        public j b;
        public final /* synthetic */ h27 c;

        public k(h27 h27Var, j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h27Var, jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = h27Var;
            this.b = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(bm5[] bm5VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bm5VarArr)) == null) {
                if (bm5VarArr != null && bm5VarArr.length > 0) {
                    this.a = bm5VarArr[0];
                    WebClient webClient = new WebClient();
                    byte[] downloadImageBytes = webClient.downloadImageBytes(this.a.d, false);
                    if (downloadImageBytes == null || !webClient.IsRequestSuccess()) {
                        return Boolean.FALSE;
                    }
                    String r = this.c.r(this.a, true);
                    if (TextUtils.isEmpty(r)) {
                        return Boolean.FALSE;
                    }
                    if (vi.D(downloadImageBytes)) {
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

    public h27() {
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

    public static h27 t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (b == null) {
                b = new h27();
            }
            return b;
        }
        return (h27) invokeV.objValue;
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

    public void i(List<bm5> list, boolean z, l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{list, Boolean.valueOf(z), lVar}) == null) {
            new a(this, lVar, list, z).execute(new Void[0]);
        }
    }

    public static String p(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65542, null, str, z)) == null) {
            String str2 = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/.collect/" + yl5.d() + "/" + str + "_s.jpg";
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

    public final String r(bm5 bm5Var, boolean z) {
        InterceptResult invokeLZ;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048587, this, bm5Var, z)) == null) {
            if (bm5Var != null && !TextUtils.isEmpty(bm5Var.d) && !TextUtils.isEmpty(bm5Var.a)) {
                if (z) {
                    str = "_b.jpg";
                } else {
                    str = "_s.jpg";
                }
                return TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/.collect/" + yl5.d() + "/" + bm5Var.a + str;
            }
            return "";
        }
        return (String) invokeLZ.objValue;
    }

    public void h(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, str3, str4) == null) {
            if (vz8.o().p()) {
                vi.P(BdBaseApplication.getInst().getApp(), R.string.obfuscated_res_0x7f0f06e1);
                return;
            }
            bm5 bm5Var = new bm5();
            bm5Var.d = str;
            bm5Var.e = str2;
            bm5Var.f = str3;
            bm5Var.a = str4;
            ArrayList arrayList = new ArrayList();
            arrayList.add(bm5Var);
            i(arrayList, true, null);
        }
    }

    public void j(List<bm5> list, boolean z, l lVar) {
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
                for (bm5 bm5Var : list) {
                    String str = bm5Var.a;
                    if (str != null && !TextUtils.isEmpty(str)) {
                        if (!i27.e().f(bm5Var.a)) {
                            arrayList.add(bm5Var);
                        }
                    } else {
                        arrayList2.add(bm5Var.d);
                        String str2 = bm5Var.f;
                        if (str2 != null) {
                            hashMap.put(bm5Var.d, str2);
                        }
                    }
                }
                if (arrayList2.size() > 0) {
                    if (this.a == null) {
                        this.a = new GetEmotionInfosModel();
                    }
                    this.a.W(arrayList2, new b(this, lVar, hashMap, arrayList, z));
                    return;
                }
                n(arrayList, lVar, z);
            } else if (lVar == null) {
                vi.P(TbadkCoreApplication.getInst(), R.string.save_emotion_failed);
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
            if (vz8.o().p() && lVar != null) {
                vi.P(BdBaseApplication.getInst().getApp(), R.string.obfuscated_res_0x7f0f06e1);
                lVar.onResult(4, 0, 0);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                bm5 bm5Var = new bm5();
                bm5Var.d = str;
                arrayList.add(bm5Var);
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
                sz8.a("【表情云同步】：4 - 收藏表情：检查数据库中表情文件是否存在");
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

    public final void n(List<bm5> list, l lVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, list, lVar, z) == null) {
            if (list.size() == 0) {
                if (lVar == null) {
                    vi.P(TbadkCoreApplication.getInst(), R.string.save_emotion_success);
                    return;
                } else {
                    lVar.onResult(4, 1, 0);
                    return;
                }
            }
            AtomicInteger atomicInteger = new AtomicInteger(list.size());
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            for (bm5 bm5Var : list) {
                new k(this, new c(this, copyOnWriteArrayList, bm5Var, atomicInteger, lVar, z)).execute(bm5Var);
            }
        }
    }

    public List<CollectEmotionData> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ArrayList arrayList = new ArrayList();
            List<CollectEmotionData> q = x17.o().q(TbadkCoreApplication.getCurrentAccountForEmotion());
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
                                        wi.e(fileInputStream);
                                        return byteArray;
                                    }
                                }
                            } catch (IOException e2) {
                                e = e2;
                                BdLog.e(e.getMessage());
                                wi.e(fileInputStream);
                                return null;
                            }
                        } catch (IOException e3) {
                            e = e3;
                            fileInputStream = null;
                        } catch (Throwable th) {
                            th = th;
                            wi.e(inputStream);
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
                    if (collectEmotionData != null && !"setting_icon".equals(collectEmotionData.pid) && !yl5.f.equals(collectEmotionData.getSharpText())) {
                        x17.o().i(collectEmotionData);
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
                List<CollectEmotionData> q = x17.o().q(TbadkCoreApplication.getCurrentAccount());
                for (int i3 = 0; i3 < q.size(); i3++) {
                    CollectEmotionData collectEmotionData2 = q.get(i3);
                    if (!yl5.f.equals(collectEmotionData2.getSharpText())) {
                        collectEmotionData2.setOrderId((q.size() - i3) - 1);
                        x17.o().v(collectEmotionData2);
                    }
                }
                if (i2 > 0) {
                    i27.e().g();
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(Integer.valueOf(i2));
                arrayList.add(Integer.valueOf(list.size() - i2));
                if (lVar != null && arrayList.size() == 2) {
                    lVar.onResult(1, ((Integer) arrayList.get(0)).intValue(), ((Integer) arrayList.get(1)).intValue());
                    if (((Integer) arrayList.get(0)).intValue() > 0) {
                        if (z) {
                            new UserCollectModel().U();
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

    public final CollectEmotionData y(bm5 bm5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, bm5Var)) == null) {
            CollectEmotionData collectEmotionData = new CollectEmotionData();
            StringBuilder sb = new StringBuilder(yl5.h);
            if (TextUtils.isEmpty(bm5Var.f)) {
                sb.append(bm5Var.a);
                sb.append(",");
            } else {
                sb.append(bm5Var.f);
                sb.append("_");
                sb.append(bm5Var.a);
                sb.append(",");
            }
            sb.append(bm5Var.b);
            sb.append(",");
            sb.append(bm5Var.c);
            sb.append(",");
            String lowerCase = cj.c(sb.toString().replace("collect_", "") + UploadedImageInfo.MD5_KEY).toLowerCase();
            collectEmotionData.pid = bm5Var.a;
            collectEmotionData.uid = TbadkCoreApplication.getCurrentAccount();
            collectEmotionData.setSharpText(SmallTailInfo.EMOTION_PREFIX + sb.toString() + lowerCase + SmallTailInfo.EMOTION_SUFFIX);
            collectEmotionData.setOrderId(x17.o().l(collectEmotionData.uid) + 1);
            collectEmotionData.width = bm5Var.b;
            collectEmotionData.height = bm5Var.c;
            collectEmotionData.picUrl = bm5Var.d;
            collectEmotionData.thumbnail = bm5Var.e;
            collectEmotionData.backup = "";
            return collectEmotionData;
        }
        return (CollectEmotionData) invokeL.objValue;
    }
}

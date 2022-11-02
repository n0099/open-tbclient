package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.httpNet.WebClient;
import com.baidu.tbadk.img.GetEmotionInfosModel;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.UploadedImageInfo;
import com.baidu.tieba.faceshop.DiyEmotionData;
import com.baidu.tieba.faceshop.UserDiyModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes4.dex */
public class ef6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ef6 b;
    public transient /* synthetic */ FieldHolder $fh;
    public GetEmotionInfosModel a;

    /* loaded from: classes4.dex */
    public interface i {
        void onFail();

        void onSuccess();
    }

    /* loaded from: classes4.dex */
    public interface k {
        void a(int i, int i2, int i3, @Nullable Object obj);
    }

    /* loaded from: classes4.dex */
    public class a extends BdAsyncTask<Void, Void, Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k a;
        public final /* synthetic */ List b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ ef6 d;

        public a(ef6 ef6Var, k kVar, List list, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ef6Var, kVar, list, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = ef6Var;
            this.a = kVar;
            this.b = list;
            this.c = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Integer doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                return Integer.valueOf(qe6.o().m(TbadkCoreApplication.getCurrentAccount()) - 1);
            }
            return (Integer) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, num) == null) {
                if (num.intValue() >= 300) {
                    k kVar = this.a;
                    if (kVar != null) {
                        kVar.a(4, 0, 0, null);
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
                this.d.i(this.b, this.c, this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements GetEmotionInfosModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k a;
        public final /* synthetic */ Map b;
        public final /* synthetic */ List c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ ef6 e;

        public b(ef6 ef6Var, k kVar, Map map, List list, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ef6Var, kVar, map, list, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ef6Var;
            this.a = kVar;
            this.b = map;
            this.c = list;
            this.d = z;
        }

        @Override // com.baidu.tbadk.img.GetEmotionInfosModel.b
        public void onFail(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                k kVar = this.a;
                if (kVar == null) {
                    xi.O(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f10d4);
                } else {
                    kVar.a(4, 0, 0, null);
                }
            }
        }

        @Override // com.baidu.tbadk.img.GetEmotionInfosModel.b
        public void onSuccess(List<i95> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                if (list == null || list.isEmpty()) {
                    k kVar = this.a;
                    if (kVar == null) {
                        xi.O(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f10d4);
                    } else {
                        kVar.a(4, 0, 0, null);
                    }
                }
                for (i95 i95Var : list) {
                    if (!ne6.e().f(i95Var.a)) {
                        i95Var.f = (String) this.b.get(i95Var.g);
                        this.c.add(i95Var);
                    }
                }
                this.e.l(this.c, this.a, this.d);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ i95 b;
        public final /* synthetic */ AtomicInteger c;
        public final /* synthetic */ k d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ ef6 f;

        public c(ef6 ef6Var, List list, i95 i95Var, AtomicInteger atomicInteger, k kVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ef6Var, list, i95Var, atomicInteger, kVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = ef6Var;
            this.a = list;
            this.b = i95Var;
            this.c = atomicInteger;
            this.d = kVar;
            this.e = z;
        }

        @Override // com.baidu.tieba.ef6.i
        public void onFail() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.c.decrementAndGet() == 0) {
                this.f.f(this.a, this.d, this.e);
            }
        }

        @Override // com.baidu.tieba.ef6.i
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.add(this.f.u(this.b));
                if (this.c.decrementAndGet() == 0) {
                    this.f.f(this.a, this.d, this.e);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends BdAsyncTask<Void, Void, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ k c;

        public d(ef6 ef6Var, List list, boolean z, k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ef6Var, list, Boolean.valueOf(z), kVar};
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
            this.b = z;
            this.c = kVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                return Boolean.valueOf(qe6.o().d(this.a));
            }
            return (Boolean) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bool) == null) {
                if (bool != null && bool.booleanValue()) {
                    ne6.e().g();
                    if (this.b) {
                        new UserDiyModel().z();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921028));
                    k kVar = this.c;
                    if (kVar == null) {
                        xi.O(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f00bd);
                        return;
                    } else {
                        kVar.a(4, 1, 0, this.a);
                        return;
                    }
                }
                k kVar2 = this.c;
                if (kVar2 == null) {
                    xi.O(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f10d4);
                } else {
                    kVar2.a(4, 0, 0, null);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends BdAsyncTask<Void, Void, List<Integer>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ k b;
        public final /* synthetic */ boolean c;

        public e(ef6 ef6Var, List list, k kVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ef6Var, list, kVar, Boolean.valueOf(z)};
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
            this.b = kVar;
            this.c = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<Integer> doInBackground(Void[] voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                List<DiyEmotionData> r = qe6.o().r(TbadkCoreApplication.getCurrentAccountForEmotion());
                HashMap hashMap = new HashMap();
                for (DiyEmotionData diyEmotionData : r) {
                    hashMap.put(diyEmotionData.getSharpText(), diyEmotionData);
                }
                int size = r.size() - 2;
                for (int i = 0; i < this.a.size(); i++) {
                    DiyEmotionData diyEmotionData2 = (DiyEmotionData) this.a.get(i);
                    diyEmotionData2.setOrderId(size);
                    String sharpText = diyEmotionData2.getSharpText();
                    if (hashMap.containsKey(sharpText)) {
                        r.remove(hashMap.get(sharpText));
                        hashMap.remove(sharpText);
                    }
                    qe6.o().w(diyEmotionData2);
                    size--;
                }
                if (this.a.size() > 0) {
                    ne6.e().g();
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
                this.b.a(2, list.get(0).intValue(), list.get(1).intValue(), null);
                if (list.get(0).intValue() > 0) {
                    if (this.c) {
                        new UserDiyModel().z();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921028));
                    StatisticItem statisticItem = new StatisticItem("c12227");
                    statisticItem.param("obj_param1", list.get(0).intValue());
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends BdAsyncTask<Void, Void, List<Integer>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ k b;
        public final /* synthetic */ boolean c;

        public f(ef6 ef6Var, List list, k kVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ef6Var, list, kVar, Boolean.valueOf(z)};
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
            this.b = kVar;
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
                for (DiyEmotionData diyEmotionData : this.a) {
                    if (diyEmotionData != null && !"setting_icon".equals(diyEmotionData.getPid()) && !"#(meme,diysetting)".equals(diyEmotionData.getSharpText())) {
                        qe6.o().j(diyEmotionData);
                        ImageFileInfo imageFileInfo = diyEmotionData.imageFileInfo;
                        if (imageFileInfo != null && !TextUtils.isEmpty(imageFileInfo.getFilePath())) {
                            File file = new File(diyEmotionData.imageFileInfo.getFilePath());
                            if (file.exists()) {
                                file.delete();
                            }
                            String filePath = diyEmotionData.imageFileInfo.getFilePath();
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
                List<DiyEmotionData> r = qe6.o().r(TbadkCoreApplication.getCurrentAccount());
                for (int i2 = 0; i2 < r.size(); i2++) {
                    DiyEmotionData diyEmotionData2 = r.get(i2);
                    if (!"#(meme,diysetting)".equals(diyEmotionData2.getSharpText())) {
                        diyEmotionData2.setOrderId((r.size() - i2) - 1);
                        qe6.o().w(diyEmotionData2);
                    }
                }
                if (i > 0) {
                    ne6.e().g();
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
                this.b.a(1, list.get(0).intValue(), list.get(1).intValue(), null);
                if (list.get(0).intValue() > 0) {
                    if (this.c) {
                        new UserDiyModel().z();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921028));
                    StatisticItem statisticItem = new StatisticItem("c12226");
                    statisticItem.param("obj_param1", list.get(0).intValue());
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends BdAsyncTask<Void, Void, List<DiyEmotionData>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ef6 a;

        public g(ef6 ef6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ef6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ef6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<DiyEmotionData> doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                return this.a.o();
            }
            return (List) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<DiyEmotionData> list) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || list == null) {
                return;
            }
            for (DiyEmotionData diyEmotionData : list) {
                if (diyEmotionData != null) {
                    i95 i95Var = new i95();
                    i95Var.a = diyEmotionData.getPid();
                    i95Var.f = diyEmotionData.getPkgId();
                    i95Var.d = diyEmotionData.getPicUrl();
                    i95Var.e = diyEmotionData.getThumbnail();
                    i95Var.b = diyEmotionData.getWidth();
                    i95Var.c = diyEmotionData.getHeight();
                    ct7.a("【表情云同步】：4 - 开始：重新下载数据库中有数据但是没文件的表情，" + i95Var.d);
                    new j(this.a, null).execute(i95Var);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.ef6.k
        public void a(int i, int i2, int i3, @Nullable Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), obj}) == null) {
            }
        }

        public h(ef6 ef6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ef6Var};
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

    /* loaded from: classes4.dex */
    public class j extends BdAsyncTask<i95, Void, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public i95 a;
        public i b;
        public final /* synthetic */ ef6 c;

        public j(ef6 ef6Var, i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ef6Var, iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ef6Var;
            this.b = iVar;
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
                    String p = this.c.p(this.a, true);
                    if (TextUtils.isEmpty(p)) {
                        return Boolean.FALSE;
                    }
                    if (xi.D(downloadImageBytes)) {
                        p = p.replace("_b.jpg", "_b.gif");
                    }
                    File file = new File(p);
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    if (!this.c.s(file, downloadImageBytes)) {
                        return Boolean.FALSE;
                    }
                    byte[] downloadImageBytes2 = webClient.downloadImageBytes(this.a.e, false);
                    if (downloadImageBytes2 == null || !webClient.IsRequestSuccess()) {
                        return Boolean.FALSE;
                    }
                    String p2 = this.c.p(this.a, false);
                    if (TextUtils.isEmpty(p2)) {
                        return Boolean.FALSE;
                    }
                    if (!this.c.s(new File(p2), downloadImageBytes2)) {
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
                    i iVar = this.b;
                    if (iVar != null) {
                        iVar.onSuccess();
                        return;
                    }
                    return;
                }
                i iVar2 = this.b;
                if (iVar2 != null) {
                    iVar2.onFail();
                }
            }
        }
    }

    public ef6() {
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

    public static ef6 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (b == null) {
                synchronized (ef6.class) {
                    if (b == null) {
                        b = new ef6();
                    }
                }
            }
            return b;
        }
        return (ef6) invokeV.objValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            new g(this).execute(new Void[0]);
        }
    }

    public final void f(List<DiyEmotionData> list, k kVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048576, this, list, kVar, z) == null) {
            new d(this, list, z, kVar).execute(new Void[0]);
        }
    }

    public void h(List<i95> list, boolean z, k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{list, Boolean.valueOf(z), kVar}) == null) {
            new a(this, kVar, list, z).execute(new Void[0]);
        }
    }

    public static String n(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65542, null, str, z)) == null) {
            String str2 = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/.collect/" + f95.c() + "/" + str + "_s.jpg";
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

    public final String p(i95 i95Var, boolean z) {
        InterceptResult invokeLZ;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048585, this, i95Var, z)) == null) {
            if (i95Var != null && !TextUtils.isEmpty(i95Var.d) && !TextUtils.isEmpty(i95Var.a)) {
                if (z) {
                    str = "_b.jpg";
                } else {
                    str = "_s.jpg";
                }
                return TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/.collect/" + f95.c() + "/" + i95Var.a + str;
            }
            return "";
        }
        return (String) invokeLZ.objValue;
    }

    public final boolean s(File file, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, file, bArr)) == null) {
            FileOutputStream fileOutputStream = null;
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
                            try {
                                fileOutputStream.close();
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        }
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable th3) {
                                BdLog.e(th3.getMessage());
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (IOException e3) {
                e = e3;
            }
        } else {
            return invokeLL.booleanValue;
        }
    }

    public void g(String str, String str2, k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, kVar) == null) {
            if (ft7.o().p()) {
                xi.O(BdBaseApplication.getInst().getApp(), R.string.obfuscated_res_0x7f0f05fe);
                return;
            }
            i95 i95Var = new i95();
            i95Var.d = str;
            i95Var.f = str2;
            ArrayList arrayList = new ArrayList();
            arrayList.add(i95Var);
            h(arrayList, true, kVar);
        }
    }

    public void k(List<DiyEmotionData> list, boolean z, k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{list, Boolean.valueOf(z), kVar}) == null) {
            if (list != null && list.size() > 0) {
                new f(this, list, kVar, z).execute(new Void[0]);
            } else if (kVar != null) {
                kVar.a(1, 1, 0, null);
            }
        }
    }

    public void r(List<DiyEmotionData> list, boolean z, k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{list, Boolean.valueOf(z), kVar}) == null) {
            if (list != null && list.size() > 0) {
                new e(this, list, kVar, z).execute(new Void[0]);
            } else if (kVar != null) {
                kVar.a(2, 0, 0, null);
            }
        }
    }

    public void i(List<i95> list, boolean z, k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{list, Boolean.valueOf(z), kVar}) == null) {
            if (list != null && !list.isEmpty()) {
                if (!TbadkCoreApplication.isLogin()) {
                    if (kVar == null) {
                        ViewHelper.skipToLoginActivity(TbadkCoreApplication.getInst());
                        return;
                    } else {
                        kVar.a(4, 0, 0, null);
                        return;
                    }
                }
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                HashMap hashMap = new HashMap();
                for (i95 i95Var : list) {
                    String str = i95Var.a;
                    if (str != null && !TextUtils.isEmpty(str)) {
                        if (!ne6.e().f(i95Var.a)) {
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
                    this.a.B(arrayList2, new b(this, kVar, hashMap, arrayList, z));
                    return;
                }
                l(arrayList, kVar, z);
            } else if (kVar == null) {
                xi.O(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f10d4);
            } else {
                kVar.a(4, 0, 0, null);
            }
        }
    }

    public boolean j(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            List<DiyEmotionData> o = o();
            if (o != null && !o.isEmpty()) {
                ct7.a("【表情云同步】：4 - 收藏表情：检查数据库中表情文件是否存在");
                if (z) {
                    t(o, false, new h(this));
                }
                return false;
            }
            return true;
        }
        return invokeZ.booleanValue;
    }

    public final void l(List<i95> list, k kVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048582, this, list, kVar, z) == null) {
            if (list.size() == 0) {
                if (kVar == null) {
                    xi.O(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f00bd);
                    return;
                } else {
                    kVar.a(4, 1, 0, null);
                    return;
                }
            }
            AtomicInteger atomicInteger = new AtomicInteger(list.size());
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            for (i95 i95Var : list) {
                new j(this, new c(this, copyOnWriteArrayList, i95Var, atomicInteger, kVar, z)).execute(i95Var);
            }
        }
    }

    public List<DiyEmotionData> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ArrayList arrayList = new ArrayList();
            List<DiyEmotionData> r = qe6.o().r(TbadkCoreApplication.getCurrentAccountForEmotion());
            if (r != null) {
                for (DiyEmotionData diyEmotionData : r) {
                    if (diyEmotionData != null && !"setting_icon".equals(diyEmotionData.getPid()) && !new File(n(diyEmotionData.getPid(), false)).exists()) {
                        arrayList.add(diyEmotionData);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public void t(List<DiyEmotionData> list, boolean z, k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{list, Boolean.valueOf(z), kVar}) == null) {
            if (list != null && list.size() > 0) {
                int i2 = 0;
                for (DiyEmotionData diyEmotionData : list) {
                    if (diyEmotionData != null && !"setting_icon".equals(diyEmotionData.getPid()) && !"#(meme,diysetting)".equals(diyEmotionData.getSharpText())) {
                        qe6.o().j(diyEmotionData);
                        ImageFileInfo imageFileInfo = diyEmotionData.imageFileInfo;
                        if (imageFileInfo != null && !TextUtils.isEmpty(imageFileInfo.getFilePath())) {
                            File file = new File(diyEmotionData.imageFileInfo.getFilePath());
                            if (file.exists()) {
                                file.delete();
                            }
                            String filePath = diyEmotionData.imageFileInfo.getFilePath();
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
                List<DiyEmotionData> r = qe6.o().r(TbadkCoreApplication.getCurrentAccount());
                for (int i3 = 0; i3 < r.size(); i3++) {
                    DiyEmotionData diyEmotionData2 = r.get(i3);
                    if (!"#(meme,diysetting)".equals(diyEmotionData2.getSharpText())) {
                        diyEmotionData2.setOrderId((r.size() - i3) - 1);
                        qe6.o().w(diyEmotionData2);
                    }
                }
                if (i2 > 0) {
                    ne6.e().g();
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(Integer.valueOf(i2));
                arrayList.add(Integer.valueOf(list.size() - i2));
                if (kVar != null && arrayList.size() == 2) {
                    kVar.a(1, ((Integer) arrayList.get(0)).intValue(), ((Integer) arrayList.get(1)).intValue(), null);
                    if (((Integer) arrayList.get(0)).intValue() > 0) {
                        if (z) {
                            new UserDiyModel().z();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921028));
                        StatisticItem statisticItem = new StatisticItem("c12226");
                        statisticItem.param("obj_param1", ((Integer) arrayList.get(0)).intValue());
                        TiebaStatic.log(statisticItem);
                    }
                }
            } else if (kVar != null) {
                kVar.a(1, 1, 0, null);
            }
        }
    }

    public final DiyEmotionData u(i95 i95Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, i95Var)) == null) {
            DiyEmotionData diyEmotionData = new DiyEmotionData();
            StringBuilder sb = new StringBuilder("meme,diy_");
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
            String lowerCase = ej.c(sb.toString().replace("diy_", "") + UploadedImageInfo.MD5_KEY).toLowerCase();
            diyEmotionData.setPid(i95Var.a);
            diyEmotionData.setUid(TbadkCoreApplication.getCurrentAccount());
            diyEmotionData.setSharpText(SmallTailInfo.EMOTION_PREFIX + sb.toString() + lowerCase + SmallTailInfo.EMOTION_SUFFIX);
            diyEmotionData.setOrderId(qe6.o().m(diyEmotionData.getUid()) + 1);
            diyEmotionData.setWidth(i95Var.b);
            diyEmotionData.setHeight(i95Var.c);
            diyEmotionData.setPicUrl(i95Var.d);
            diyEmotionData.setThumbnail(i95Var.e);
            diyEmotionData.setBackup("");
            return diyEmotionData;
        }
        return (DiyEmotionData) invokeL.objValue;
    }
}

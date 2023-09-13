package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
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
/* loaded from: classes5.dex */
public class f57 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile f57 b;
    public transient /* synthetic */ FieldHolder $fh;
    public GetEmotionInfosModel a;

    /* loaded from: classes5.dex */
    public interface i {
        void onFail();

        void onSuccess();
    }

    /* loaded from: classes5.dex */
    public interface k {
        void a(int i, int i2, int i3, @Nullable Object obj);
    }

    /* loaded from: classes5.dex */
    public class a extends BdAsyncTask<Void, Void, Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k a;
        public final /* synthetic */ List b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ f57 d;

        public a(f57 f57Var, k kVar, List list, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f57Var, kVar, list, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = f57Var;
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
                return Integer.valueOf(r47.o().m(TbadkCoreApplication.getCurrentAccount()) - 1);
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
                        BdUtilHelper.showToast(TbadkCoreApplication.getInst(), (int) R.string.save_emotion_limit);
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

    /* loaded from: classes5.dex */
    public class b implements GetEmotionInfosModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k a;
        public final /* synthetic */ Map b;
        public final /* synthetic */ List c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ f57 e;

        public b(f57 f57Var, k kVar, Map map, List list, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f57Var, kVar, map, list, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = f57Var;
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
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst(), (int) R.string.save_emotion_failed);
                } else {
                    kVar.a(4, 0, 0, null);
                }
            }
        }

        @Override // com.baidu.tbadk.img.GetEmotionInfosModel.b
        public void onSuccess(List<bn5> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                if (list == null || list.isEmpty()) {
                    k kVar = this.a;
                    if (kVar == null) {
                        BdUtilHelper.showToast(TbadkCoreApplication.getInst(), (int) R.string.save_emotion_failed);
                    } else {
                        kVar.a(4, 0, 0, null);
                    }
                }
                for (bn5 bn5Var : list) {
                    if (!o47.e().f(bn5Var.a)) {
                        bn5Var.f = (String) this.b.get(bn5Var.g);
                        this.c.add(bn5Var);
                    }
                }
                this.e.l(this.c, this.a, this.d);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ bn5 b;
        public final /* synthetic */ AtomicInteger c;
        public final /* synthetic */ k d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ f57 f;

        public c(f57 f57Var, List list, bn5 bn5Var, AtomicInteger atomicInteger, k kVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f57Var, list, bn5Var, atomicInteger, kVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = f57Var;
            this.a = list;
            this.b = bn5Var;
            this.c = atomicInteger;
            this.d = kVar;
            this.e = z;
        }

        @Override // com.baidu.tieba.f57.i
        public void onFail() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.c.decrementAndGet() == 0) {
                this.f.f(this.a, this.d, this.e);
            }
        }

        @Override // com.baidu.tieba.f57.i
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

    /* loaded from: classes5.dex */
    public class d extends BdAsyncTask<Void, Void, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ k c;

        public d(f57 f57Var, List list, boolean z, k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f57Var, list, Boolean.valueOf(z), kVar};
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
                return Boolean.valueOf(r47.o().d(this.a));
            }
            return (Boolean) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bool) == null) {
                if (bool != null && bool.booleanValue()) {
                    o47.e().g();
                    if (this.b) {
                        new UserDiyModel().M();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921028));
                    k kVar = this.c;
                    if (kVar == null) {
                        BdUtilHelper.showToast(TbadkCoreApplication.getInst(), (int) R.string.add_diy_success);
                        return;
                    } else {
                        kVar.a(4, 1, 0, this.a);
                        return;
                    }
                }
                k kVar2 = this.c;
                if (kVar2 == null) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst(), (int) R.string.save_emotion_failed);
                } else {
                    kVar2.a(4, 0, 0, null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends BdAsyncTask<Void, Void, List<Integer>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ k b;
        public final /* synthetic */ boolean c;

        public e(f57 f57Var, List list, k kVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f57Var, list, kVar, Boolean.valueOf(z)};
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
                List<DiyEmotionData> r = r47.o().r(TbadkCoreApplication.getCurrentAccountForEmotion());
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
                    r47.o().w(diyEmotionData2);
                    size--;
                }
                if (this.a.size() > 0) {
                    o47.e().g();
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
                        new UserDiyModel().M();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921028));
                    StatisticItem statisticItem = new StatisticItem("c12227");
                    statisticItem.param("obj_param1", list.get(0).intValue());
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends BdAsyncTask<Void, Void, List<Integer>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ k b;
        public final /* synthetic */ boolean c;

        public f(f57 f57Var, List list, k kVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f57Var, list, kVar, Boolean.valueOf(z)};
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
                        r47.o().j(diyEmotionData);
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
                List<DiyEmotionData> r = r47.o().r(TbadkCoreApplication.getCurrentAccount());
                for (int i2 = 0; i2 < r.size(); i2++) {
                    DiyEmotionData diyEmotionData2 = r.get(i2);
                    if (!"#(meme,diysetting)".equals(diyEmotionData2.getSharpText())) {
                        diyEmotionData2.setOrderId((r.size() - i2) - 1);
                        r47.o().w(diyEmotionData2);
                    }
                }
                if (i > 0) {
                    o47.e().g();
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
                        new UserDiyModel().M();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921028));
                    StatisticItem statisticItem = new StatisticItem("c12226");
                    statisticItem.param("obj_param1", list.get(0).intValue());
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g extends BdAsyncTask<Void, Void, List<DiyEmotionData>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f57 a;

        public g(f57 f57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f57Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f57Var;
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
                    bn5 bn5Var = new bn5();
                    bn5Var.a = diyEmotionData.getPid();
                    bn5Var.f = diyEmotionData.getPkgId();
                    bn5Var.d = diyEmotionData.getPicUrl();
                    bn5Var.e = diyEmotionData.getThumbnail();
                    bn5Var.b = diyEmotionData.getWidth();
                    bn5Var.c = diyEmotionData.getHeight();
                    he9.a("【表情云同步】：4 - 开始：重新下载数据库中有数据但是没文件的表情，" + bn5Var.d);
                    new j(this.a, null).execute(bn5Var);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.f57.k
        public void a(int i, int i2, int i3, @Nullable Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), obj}) == null) {
            }
        }

        public h(f57 f57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f57Var};
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

    /* loaded from: classes5.dex */
    public class j extends BdAsyncTask<bn5, Void, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public bn5 a;
        public i b;
        public final /* synthetic */ f57 c;

        public j(f57 f57Var, i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f57Var, iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = f57Var;
            this.b = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(bn5[] bn5VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bn5VarArr)) == null) {
                if (bn5VarArr != null && bn5VarArr.length > 0) {
                    this.a = bn5VarArr[0];
                    WebClient webClient = new WebClient();
                    byte[] downloadImageBytes = webClient.downloadImageBytes(this.a.d, false);
                    if (downloadImageBytes == null || !webClient.IsRequestSuccess()) {
                        return Boolean.FALSE;
                    }
                    String p = this.c.p(this.a, true);
                    if (TextUtils.isEmpty(p)) {
                        return Boolean.FALSE;
                    }
                    if (BdUtilHelper.isGif(downloadImageBytes)) {
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

    public f57() {
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

    public static f57 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (b == null) {
                synchronized (f57.class) {
                    if (b == null) {
                        b = new f57();
                    }
                }
            }
            return b;
        }
        return (f57) invokeV.objValue;
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

    public void h(List<bn5> list, boolean z, k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{list, Boolean.valueOf(z), kVar}) == null) {
            new a(this, kVar, list, z).execute(new Void[0]);
        }
    }

    public static String n(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65542, null, str, z)) == null) {
            String str2 = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/.collect/" + ym5.c() + "/" + str + "_s.jpg";
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

    public final String p(bn5 bn5Var, boolean z) {
        InterceptResult invokeLZ;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048585, this, bn5Var, z)) == null) {
            if (bn5Var != null && !TextUtils.isEmpty(bn5Var.d) && !TextUtils.isEmpty(bn5Var.a)) {
                if (z) {
                    str = "_b.jpg";
                } else {
                    str = "_s.jpg";
                }
                return TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/.collect/" + ym5.c() + "/" + bn5Var.a + str;
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
            if (ke9.o().p()) {
                BdUtilHelper.showToast(BdBaseApplication.getInst().getApp(), (int) R.string.obfuscated_res_0x7f0f06fa);
                return;
            }
            bn5 bn5Var = new bn5();
            bn5Var.d = str;
            bn5Var.f = str2;
            ArrayList arrayList = new ArrayList();
            arrayList.add(bn5Var);
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

    public void i(List<bn5> list, boolean z, k kVar) {
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
                for (bn5 bn5Var : list) {
                    String str = bn5Var.a;
                    if (str != null && !TextUtils.isEmpty(str)) {
                        if (!o47.e().f(bn5Var.a)) {
                            arrayList.add(bn5Var);
                        }
                    } else {
                        arrayList2.add(bn5Var.d);
                        String str2 = bn5Var.f;
                        if (str2 != null) {
                            hashMap.put(bn5Var.d, str2);
                        }
                    }
                }
                if (arrayList2.size() > 0) {
                    if (this.a == null) {
                        this.a = new GetEmotionInfosModel();
                    }
                    this.a.O(arrayList2, new b(this, kVar, hashMap, arrayList, z));
                    return;
                }
                l(arrayList, kVar, z);
            } else if (kVar == null) {
                BdUtilHelper.showToast(TbadkCoreApplication.getInst(), (int) R.string.save_emotion_failed);
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
                he9.a("【表情云同步】：4 - 收藏表情：检查数据库中表情文件是否存在");
                if (z) {
                    t(o, false, new h(this));
                }
                return false;
            }
            return true;
        }
        return invokeZ.booleanValue;
    }

    public final void l(List<bn5> list, k kVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048582, this, list, kVar, z) == null) {
            if (list.size() == 0) {
                if (kVar == null) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst(), (int) R.string.add_diy_success);
                    return;
                } else {
                    kVar.a(4, 1, 0, null);
                    return;
                }
            }
            AtomicInteger atomicInteger = new AtomicInteger(list.size());
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            for (bn5 bn5Var : list) {
                new j(this, new c(this, copyOnWriteArrayList, bn5Var, atomicInteger, kVar, z)).execute(bn5Var);
            }
        }
    }

    public List<DiyEmotionData> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ArrayList arrayList = new ArrayList();
            List<DiyEmotionData> r = r47.o().r(TbadkCoreApplication.getCurrentAccountForEmotion());
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
                        r47.o().j(diyEmotionData);
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
                List<DiyEmotionData> r = r47.o().r(TbadkCoreApplication.getCurrentAccount());
                for (int i3 = 0; i3 < r.size(); i3++) {
                    DiyEmotionData diyEmotionData2 = r.get(i3);
                    if (!"#(meme,diysetting)".equals(diyEmotionData2.getSharpText())) {
                        diyEmotionData2.setOrderId((r.size() - i3) - 1);
                        r47.o().w(diyEmotionData2);
                    }
                }
                if (i2 > 0) {
                    o47.e().g();
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(Integer.valueOf(i2));
                arrayList.add(Integer.valueOf(list.size() - i2));
                if (kVar != null && arrayList.size() == 2) {
                    kVar.a(1, ((Integer) arrayList.get(0)).intValue(), ((Integer) arrayList.get(1)).intValue(), null);
                    if (((Integer) arrayList.get(0)).intValue() > 0) {
                        if (z) {
                            new UserDiyModel().M();
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

    public final DiyEmotionData u(bn5 bn5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, bn5Var)) == null) {
            DiyEmotionData diyEmotionData = new DiyEmotionData();
            StringBuilder sb = new StringBuilder("meme,diy_");
            if (TextUtils.isEmpty(bn5Var.f)) {
                sb.append(bn5Var.a);
                sb.append(",");
            } else {
                sb.append(bn5Var.f);
                sb.append("_");
                sb.append(bn5Var.a);
                sb.append(",");
            }
            sb.append(bn5Var.b);
            sb.append(",");
            sb.append(bn5Var.c);
            sb.append(",");
            String lowerCase = ki.c(sb.toString().replace("diy_", "") + UploadedImageInfo.MD5_KEY).toLowerCase();
            diyEmotionData.setPid(bn5Var.a);
            diyEmotionData.setUid(TbadkCoreApplication.getCurrentAccount());
            diyEmotionData.setSharpText(SmallTailInfo.EMOTION_PREFIX + sb.toString() + lowerCase + SmallTailInfo.EMOTION_SUFFIX);
            diyEmotionData.setOrderId(r47.o().m(diyEmotionData.getUid()) + 1);
            diyEmotionData.setWidth(bn5Var.b);
            diyEmotionData.setHeight(bn5Var.c);
            diyEmotionData.setPicUrl(bn5Var.d);
            diyEmotionData.setThumbnail(bn5Var.e);
            diyEmotionData.setBackup("");
            return diyEmotionData;
        }
        return (DiyEmotionData) invokeL.objValue;
    }
}

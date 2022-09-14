package com.baidu.tieba;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c97 {
    public static /* synthetic */ Interceptable $ic;
    public static c97 c;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    public final DialogInterface.OnCancelListener b;

    /* loaded from: classes3.dex */
    public class a implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c97 a;

        public a(c97 c97Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c97Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c97Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.a.c();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<Object, d, Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final a87 a;
        public final int b;
        public c c;
        public final /* synthetic */ c97 d;

        /* loaded from: classes3.dex */
        public class a implements c {
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

            @Override // com.baidu.tieba.c97.c
            public void a(int i, String str, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) {
                    if (this.a.isCancelled()) {
                        this.a.h(i, str, i2);
                        return;
                    }
                    d dVar = new d();
                    dVar.a = str;
                    dVar.b = i2;
                    dVar.c = i;
                    this.a.publishProgress(dVar);
                }
            }

            @Override // com.baidu.tieba.c97.c
            public void b(List<d> list) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                    this.a.i(list);
                }
            }
        }

        /* renamed from: com.baidu.tieba.c97$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0223b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ String b;
            public final /* synthetic */ int c;
            public final /* synthetic */ b d;

            public RunnableC0223b(b bVar, int i, String str, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, Integer.valueOf(i), str, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.d = bVar;
                this.a = i;
                this.b = str;
                this.c = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.d.a == null) {
                    return;
                }
                this.d.a.onProgressUpdate(this.a, this.b, this.c);
                this.d.a.onCanceled();
            }
        }

        /* loaded from: classes3.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ List a;
            public final /* synthetic */ b b;

            public c(b bVar, List list) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, list};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = bVar;
                this.a = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a == null || this.b.a == null) {
                    return;
                }
                for (d dVar : this.a) {
                    if (dVar != null) {
                        this.b.a.onProgressUpdate(dVar.c, dVar.a, dVar.b);
                    }
                }
                this.b.a.onCanceled();
                this.a.clear();
            }
        }

        public b(c97 c97Var, int i, a87 a87Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c97Var, Integer.valueOf(i), a87Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = c97Var;
            this.c = new a(this);
            this.b = i;
            this.a = a87Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public Integer doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, objArr)) == null) {
                if (isCancelled()) {
                    return -1;
                }
                if (objArr != null && objArr.length > 0 && objArr[0] != null) {
                    Object obj = objArr[0];
                    if (obj instanceof ArrayList) {
                        List<ImMessageCenterShowItemData> list = (List) obj;
                        int i = this.b;
                        if (i == 4) {
                            this.d.d(list, this.c);
                        } else if (i == 2) {
                            this.d.f(list, this.c);
                        }
                    } else if (obj instanceof ImMessageCenterShowItemData) {
                        this.d.s(((ImMessageCenterShowItemData) obj).getFriendId(), this.b, this.c);
                    }
                    return 0;
                }
                return -2;
            }
            return (Integer) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public void onProgressUpdate(d... dVarArr) {
            a87 a87Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVarArr) == null) {
                super.onProgressUpdate(dVarArr);
                if (dVarArr == null || dVarArr.length <= 0 || dVarArr[0] == null || (a87Var = this.a) == null) {
                    return;
                }
                d dVar = dVarArr[0];
                a87Var.onProgressUpdate(dVar.c, dVar.a, dVar.b);
            }
        }

        public final void h(int i, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) {
                gh.a().post(new RunnableC0223b(this, i, str, i2));
            }
        }

        public final void i(List<d> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
                gh.a().post(new c(this, list));
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                super.onCancelled();
                a87 a87Var = this.a;
                if (a87Var != null) {
                    a87Var.onCanceled();
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                super.onPreExecute();
                a87 a87Var = this.a;
                if (a87Var != null) {
                    a87Var.onPreExecute();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, num) == null) {
                super.onPostExecute((b) num);
                if (this.a != null) {
                    if (isCancelled()) {
                        this.a.onCanceled();
                    } else {
                        this.a.onPostExecute();
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(int i, String str, int i2);

        void b(List<d> list);
    }

    /* loaded from: classes3.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public int b;
        public int c;

        public d() {
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

    public c97() {
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
        this.b = new a(this);
    }

    public static c97 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (c97.class) {
                    if (c == null) {
                        c = new c97();
                    }
                }
            }
            return c;
        }
        return (c97) invokeV.objValue;
    }

    public void a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, a87 a87Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, imMessageCenterShowItemData, i, a87Var) == null) {
            b bVar = new b(this, i, a87Var);
            this.a = bVar;
            bVar.setParallel(TiebaIMConfig.getParallel());
            this.a.setPriority(3);
            this.a.execute(imMessageCenterShowItemData);
        }
    }

    public void b(List<ImMessageCenterShowItemData> list, int i, a87 a87Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, i, a87Var) == null) {
            b bVar = new b(this, i, a87Var);
            this.a = bVar;
            bVar.setParallel(TiebaIMConfig.getParallel());
            this.a.setPriority(3);
            this.a.execute(list);
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            b bVar = this.a;
            if (bVar != null && bVar.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
                this.a.cancel(true);
            }
            this.a = null;
            return true;
        }
        return invokeV.booleanValue;
    }

    public void d(List<ImMessageCenterShowItemData> list, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, list, cVar) == null) {
            try {
                try {
                    f97.d().f();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                int size = list.size();
                int i = 0;
                for (int i2 = size - 1; i2 >= 0; i2--) {
                    if (o()) {
                        break;
                    }
                    ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) ListUtils.getItem(list, i2);
                    if (imMessageCenterShowItemData != null && !TextUtils.isEmpty(imMessageCenterShowItemData.getFriendId())) {
                        String friendId = imMessageCenterShowItemData.getFriendId();
                        k(friendId, 4);
                        j97.w().e(friendId);
                        i++;
                        if (cVar != null) {
                            cVar.a((i * 100) / size, friendId, 4);
                        }
                    }
                }
            } finally {
                f97.d().b();
            }
        }
    }

    public void e(c cVar) {
        List<String> y;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            try {
                try {
                    f97.d().f();
                    j97.w();
                    y = j97.y();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (!ListUtils.isEmpty(y)) {
                    int size = y.size();
                    int i = 0;
                    for (String str : y) {
                        if (o()) {
                            break;
                        }
                        k(str, 4);
                        j97.w().e(str);
                        i++;
                        if (cVar != null) {
                            cVar.a((i * 100) / size, str, 4);
                        }
                    }
                    if (!o()) {
                        k(TbEnum.CustomGroupId.OFFICIAL_MERGE, -8);
                    }
                }
            } finally {
                f97.d().b();
            }
        }
    }

    public void f(List<ImMessageCenterShowItemData> list, c cVar) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, list, cVar) == null) {
            try {
                try {
                    f97.d().f();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (!ListUtils.isEmpty(list)) {
                    ArrayList arrayList = new ArrayList(list.size());
                    for (int size = list.size() - 1; size >= 0; size--) {
                        ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) ListUtils.getItem(list, size);
                        if (imMessageCenterShowItemData != null && !TextUtils.isEmpty(imMessageCenterShowItemData.getFriendId())) {
                            arrayList.add(imMessageCenterShowItemData.getFriendId());
                        }
                    }
                    int size2 = arrayList.size();
                    int i3 = size2 / 100;
                    if (size2 % 100 != 0) {
                        i3++;
                    }
                    int i4 = 0;
                    while (i4 < i3) {
                        if (!o()) {
                            if (i4 == i3 - 1) {
                                i = 100 * i4;
                                i2 = size2;
                            } else {
                                i = 100 * i4;
                                i2 = i + 100;
                            }
                            i4++;
                            l(ListUtils.subList(arrayList, i, i2), cVar, (i4 * 100) / i3);
                        }
                    }
                }
            } finally {
                f97.d().b();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0053, code lost:
        if (o() == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0056, code lost:
        k(com.baidu.tbadk.core.util.TbEnum.CustomGroupId.STRANGE_MERGE, -7);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g(c cVar) {
        List<String> e;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            try {
                try {
                    f97.d().f();
                    e = l97.e();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (!ListUtils.isEmpty(e)) {
                    int size = e.size();
                    int i3 = size / 100;
                    if (size % 100 != 0) {
                        i3++;
                    }
                    int i4 = 0;
                    while (true) {
                        if (i4 >= i3) {
                            break;
                        } else if (o()) {
                            break;
                        } else {
                            if (i4 == i3 - 1) {
                                i = 100 * i4;
                                i2 = size;
                            } else {
                                i = 100 * i4;
                                i2 = i + 100;
                            }
                            i4++;
                            l(ListUtils.subList(e, i, i2), cVar, (i4 * 100) / i3);
                        }
                    }
                }
            } finally {
                f97.d().b();
            }
        }
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            try {
                try {
                    f97.d().f();
                    ImMessageCenterPojo i = y97.o().i(str, 1);
                    i.setIs_hidden(1);
                    i.setUnread_count(0);
                    h97.f().l(i, 2);
                    a97.h().d(str);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            } finally {
                f97.d().b();
            }
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            try {
                try {
                    f97.d().f();
                    k(str, 4);
                    j97.w().e(str);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } finally {
                f97.d().b();
            }
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            try {
                try {
                    f97.d().f();
                    k(str, 2);
                    k97.w().e(str);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } finally {
                f97.d().b();
            }
        }
    }

    public void k(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048586, this, str, i) == null) {
            h97.f().c(str, i);
        }
    }

    public final void l(List<String> list, c cVar, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048587, this, list, cVar, i) == null) || list == null || cVar == null) {
            return;
        }
        l97.b(t(list));
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            k97.w().d(str);
            if (o()) {
                d dVar = new d();
                dVar.a = str;
                dVar.b = 2;
                dVar.c = i;
                arrayList.add(dVar);
            } else {
                cVar.a(i, str, 2);
            }
        }
        if (arrayList.isEmpty() || cVar == null) {
            return;
        }
        cVar.b(arrayList);
    }

    public void n(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048588, this, str, i) == null) {
            try {
                try {
                    f97.d().f();
                    ImMessageCenterPojo i2 = y97.o().i(str, i);
                    i2.setIs_hidden(1);
                    i2.setUnread_count(0);
                    h97.f().l(i2, 2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } finally {
                f97.d().b();
            }
        }
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            b bVar = this.a;
            if (bVar != null) {
                return bVar != null && bVar.isCancelled();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public du4 p(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, context)) == null) {
            du4 du4Var = new du4(context);
            du4Var.a(context.getString(R.string.obfuscated_res_0x7f0f04b7));
            du4Var.setCanceledOnTouchOutside(false);
            du4Var.setCancelable(true);
            du4Var.setOnCancelListener(this.b);
            return du4Var;
        }
        return (du4) invokeL.objValue;
    }

    public void q(String str, int i) {
        ImMessageCenterPojo i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048591, this, str, i) == null) || (i2 = y97.o().i(str, i)) == null) {
            return;
        }
        if (i == 2) {
            v15.h0().r(str);
        } else if (i == 4) {
            v15.h0().q(dh.e(str, 0));
        } else if (i == -4) {
            v15.h0().f(1);
        } else {
            v15.h0().d(str);
        }
        i2.setIs_hidden(1);
        i2.setUnread_count(0);
        if (i == 2 || i == 4 || i == -7 || i == -8) {
            y97.o().F(str, i);
        } else if (i == 1) {
            y97.o().A(str, i, false);
        } else {
            y97.o().A(str, i, false);
        }
    }

    public void r(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048592, this, str, i) == null) {
            y97.o().G(str, i);
        }
    }

    public void s(String str, int i, c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048593, this, str, i, cVar) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (1 == i) {
            h(str);
        } else if (-7 == i) {
            g(cVar);
        } else if (-8 == i) {
            e(cVar);
        } else if (2 == i) {
            j(str);
        } else if (4 == i) {
            i(str);
        } else if (-4 == i) {
            n(str, i);
        } else {
            n(str, i);
        }
    }

    public final String t(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, list)) == null) {
            StringBuilder sb = new StringBuilder();
            boolean z = true;
            for (String str : list) {
                if (z) {
                    z = false;
                } else {
                    sb.append(",");
                }
                sb.append(str);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }
}

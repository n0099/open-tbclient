package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.database.SwanAppDbControl;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.s63;
import com.baidu.tieba.yd2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import rx.schedulers.Schedulers;
/* loaded from: classes4.dex */
public class hb2 implements yd2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    @Nullable
    public static AtomicLong b;
    public static final String[] c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements uz9<Cursor> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s63.c a;

        public a(s63.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.uz9
        public void call(Cursor cursor) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cursor) == null) {
                if (cursor == null || !cursor.moveToFirst()) {
                    if (hb2.a) {
                        Log.d("SwanAppHistoryHelper", "historyList == null || historyList.size() == 0");
                    }
                    gs2.a(cursor);
                    this.a.a(null);
                    return;
                }
                this.a.a(hb2.k(cursor));
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements yz9<String, Cursor> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yz9
        public Cursor call(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                return hb2.m();
            }
            return (Cursor) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public bb2 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c() {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public qh2 a;

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
                    return;
                }
            }
            this.a = new qh2();
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* loaded from: classes4.dex */
    public static class e implements Comparator<d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
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

        public /* synthetic */ e(a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(d dVar, d dVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, dVar, dVar2)) == null) {
                return Long.compare(dVar2.a.e, dVar.a.e);
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class f extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public PMSAppInfo b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f() {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public /* synthetic */ f(a aVar) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947817873, "Lcom/baidu/tieba/hb2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947817873, "Lcom/baidu/tieba/hb2;");
                return;
            }
        }
        a = ok1.a;
        c = new String[]{"_id", SwanAppDbControl.SwanAppTable.app_id.name(), SwanAppDbControl.SwanAppTable.app_key.name(), SwanAppDbControl.SwanAppTable.version.name(), SwanAppDbControl.SwanAppTable.description.name(), SwanAppDbControl.SwanAppTable.error_code.name(), SwanAppDbControl.SwanAppTable.error_detail.name(), SwanAppDbControl.SwanAppTable.error_msg.name(), SwanAppDbControl.SwanAppTable.resume_date.name(), SwanAppDbControl.SwanAppTable.icon.name(), SwanAppDbControl.SwanAppTable.icon_url.name(), SwanAppDbControl.SwanAppTable.max_swan_version.name(), SwanAppDbControl.SwanAppTable.min_swan_version.name(), SwanAppDbControl.SwanAppTable.name.name(), SwanAppDbControl.SwanAppTable.service_category.name(), SwanAppDbControl.SwanAppTable.subject_info.name(), SwanAppDbControl.SwanAppTable.bear_info.name(), SwanAppDbControl.SwanAppTable.sign.name(), SwanAppDbControl.SwanAppTable.type.name(), SwanAppDbControl.SwanAppTable.is_have_zip.name(), SwanAppDbControl.SwanAppTable.app_open_url.name(), SwanAppDbControl.SwanAppTable.app_download_url.name(), SwanAppDbControl.SwanAppTable.target_swan_version.name(), SwanAppDbControl.SwanAppTable.app_zip_size.name(), SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), SwanAppDbControl.SwanAppTable.version_code.name(), SwanAppDbControl.SwanAppTable.app_category.name(), SwanAppDbControl.SwanAppTable.orientation.name(), SwanAppDbControl.SwanAppTable.max_age.name(), SwanAppDbControl.SwanAppTable.create_time.name(), SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), "app_from", "visit_time", SwanAppDbControl.SwanAppTable.pay_protected.name(), "customer_service", "global_notice", "global_private", "pa_number", Constants.PHONE_BRAND, SwanAppDbControl.SwanAppTable.quick_app_key.name()};
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            AppRuntime.getAppContext().getContentResolver().delete(gb2.a(), null, null);
        }
    }

    public static Cursor m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            return n(null, null);
        }
        return (Cursor) invokeV.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    @WorkerThread
    public static boolean c(@NonNull ContentResolver contentResolver, @Nullable qh2 qh2Var, yd2.b bVar) {
        InterceptResult invokeLLL;
        String uri;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, contentResolver, qh2Var, bVar)) == null) {
            if (qh2Var == null || TextUtils.isEmpty(qh2Var.a)) {
                return false;
            }
            if (a) {
                Log.d("SwanAppHistoryHelper", "addHistory: " + qh2Var.c + " / " + qh2Var.a);
            }
            if (TextUtils.equals(String.valueOf(1), qh2Var.g)) {
                String str = qh2Var.a;
                zd2 m = zd2.m(bVar);
                m.i(1);
                h(contentResolver, str, m.k());
            }
            Uri a2 = gb2.a();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", qh2Var.a);
            contentValues.put("visit_time", Long.valueOf(qh2Var.e));
            contentValues.put("app_from", qh2Var.i);
            contentValues.put("app_name", qh2Var.c);
            contentValues.put(GameGuideConfigInfo.KEY_APP_KEY, qh2Var.b);
            contentValues.put("version_code", qh2Var.j);
            contentValues.put("app_icon", qh2Var.d);
            contentValues.put("frame_type", Integer.valueOf(qh2Var.f));
            contentValues.put("app_type", qh2Var.g);
            contentValues.put("pay_protected", Integer.valueOf(qh2Var.h));
            contentValues.put("sync_state", (Integer) 0);
            try {
                Uri insert = AppRuntime.getAppContext().getContentResolver().insert(a2, contentValues);
                if (a) {
                    if (insert == null) {
                        uri = "NULL";
                    } else {
                        uri = insert.toString();
                    }
                    Log.d("SwanAppHistoryHelper", "Add history: newUri - " + uri);
                }
                if (e()) {
                    String str2 = qh2Var.a;
                    zd2 m2 = zd2.m(bVar);
                    m2.i(2);
                    t(contentResolver, str2, m2.k());
                }
                if (insert == null) {
                    return false;
                }
                return true;
            } catch (Exception e2) {
                r22.f(a2.toString(), qh2Var.a, e2.toString());
                if (!a) {
                    return false;
                }
                Log.e("SwanAppHistoryHelper", "encounter error while adding swan history" + e2.toString());
                throw new RuntimeException("encounter error while adding swan history, only throw in debug mode", e2);
            }
        }
        return invokeLLL.booleanValue;
    }

    public static void d(MatrixCursor matrixCursor, int i, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(InputDeviceCompat.SOURCE_TRACKBALL, null, matrixCursor, i, dVar) == null) {
            if (dVar instanceof c) {
                c cVar = (c) dVar;
                matrixCursor.newRow().add("_id", Integer.valueOf(i)).add(SwanAppDbControl.SwanAppTable.app_id.name(), cVar.b.a).add(SwanAppDbControl.SwanAppTable.app_key.name(), cVar.b.b).add(SwanAppDbControl.SwanAppTable.version.name(), cVar.b.q).add(SwanAppDbControl.SwanAppTable.description.name(), cVar.b.c).add(SwanAppDbControl.SwanAppTable.error_code.name(), Integer.valueOf(cVar.b.d)).add(SwanAppDbControl.SwanAppTable.error_detail.name(), cVar.b.e).add(SwanAppDbControl.SwanAppTable.error_msg.name(), cVar.b.f).add(SwanAppDbControl.SwanAppTable.resume_date.name(), cVar.b.g).add(SwanAppDbControl.SwanAppTable.icon.name(), cVar.b.h).add(SwanAppDbControl.SwanAppTable.icon_url.name(), cVar.b.i).add(SwanAppDbControl.SwanAppTable.max_swan_version.name(), cVar.b.j).add(SwanAppDbControl.SwanAppTable.min_swan_version.name(), cVar.b.k).add(SwanAppDbControl.SwanAppTable.name.name(), cVar.b.l).add(SwanAppDbControl.SwanAppTable.service_category.name(), cVar.b.m).add(SwanAppDbControl.SwanAppTable.subject_info.name(), cVar.b.n).add(SwanAppDbControl.SwanAppTable.bear_info.name(), cVar.b.o).add(SwanAppDbControl.SwanAppTable.sign.name(), cVar.b.p).add(SwanAppDbControl.SwanAppTable.type.name(), Integer.valueOf(cVar.b.r)).add(SwanAppDbControl.SwanAppTable.is_have_zip.name(), Integer.valueOf(cVar.b.s)).add(SwanAppDbControl.SwanAppTable.app_open_url.name(), cVar.b.t).add(SwanAppDbControl.SwanAppTable.app_download_url.name(), cVar.b.u).add(SwanAppDbControl.SwanAppTable.target_swan_version.name(), cVar.b.v).add(SwanAppDbControl.SwanAppTable.app_zip_size.name(), Long.valueOf(cVar.b.w)).add(SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), Integer.valueOf(cVar.b.x)).add(SwanAppDbControl.SwanAppTable.version_code.name(), cVar.b.A).add(SwanAppDbControl.SwanAppTable.app_category.name(), Integer.valueOf(cVar.b.y)).add(SwanAppDbControl.SwanAppTable.orientation.name(), Integer.valueOf(cVar.b.z)).add(SwanAppDbControl.SwanAppTable.max_age.name(), Long.valueOf(cVar.b.B)).add(SwanAppDbControl.SwanAppTable.create_time.name(), Long.valueOf(cVar.b.C)).add(SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), Integer.valueOf(cVar.b.D ? 1 : 0)).add("app_from", cVar.a.i).add("visit_time", Long.valueOf(cVar.a.e)).add(SwanAppDbControl.SwanAppTable.pay_protected.name(), Integer.valueOf(cVar.b.E)).add(SwanAppDbControl.SwanAppTable.quick_app_key.name(), cVar.b.F);
                return;
            }
            f fVar = (f) dVar;
            matrixCursor.newRow().add("_id", Integer.valueOf(i)).add(SwanAppDbControl.SwanAppTable.app_id.name(), fVar.a.a).add(SwanAppDbControl.SwanAppTable.app_key.name(), fVar.b.appKey).add(SwanAppDbControl.SwanAppTable.version.name(), Long.valueOf(fVar.b.versionCode)).add(SwanAppDbControl.SwanAppTable.description.name(), fVar.b.description).add(SwanAppDbControl.SwanAppTable.error_code.name(), Integer.valueOf(fVar.b.appStatus)).add(SwanAppDbControl.SwanAppTable.error_detail.name(), fVar.b.statusDetail).add(SwanAppDbControl.SwanAppTable.error_msg.name(), fVar.b.statusDesc).add(SwanAppDbControl.SwanAppTable.resume_date.name(), fVar.b.resumeDate).add(SwanAppDbControl.SwanAppTable.icon.name(), "").add(SwanAppDbControl.SwanAppTable.icon_url.name(), fVar.a.d).add(SwanAppDbControl.SwanAppTable.max_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.min_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.name.name(), fVar.a.c).add(SwanAppDbControl.SwanAppTable.service_category.name(), fVar.b.serviceCategory).add(SwanAppDbControl.SwanAppTable.subject_info.name(), fVar.b.subjectInfo).add(SwanAppDbControl.SwanAppTable.bear_info.name(), fVar.b.bearInfo).add(SwanAppDbControl.SwanAppTable.sign.name(), "").add(SwanAppDbControl.SwanAppTable.type.name(), Integer.valueOf(fVar.b.type)).add(SwanAppDbControl.SwanAppTable.is_have_zip.name(), 0).add(SwanAppDbControl.SwanAppTable.app_open_url.name(), "").add(SwanAppDbControl.SwanAppTable.app_download_url.name(), "").add(SwanAppDbControl.SwanAppTable.target_swan_version.name(), "").add(SwanAppDbControl.SwanAppTable.app_zip_size.name(), Long.valueOf(fVar.b.pkgSize)).add(SwanAppDbControl.SwanAppTable.pending_aps_errcode.name(), Integer.valueOf(fVar.b.pendingErrCode)).add(SwanAppDbControl.SwanAppTable.version_code.name(), fVar.b.versionName).add(SwanAppDbControl.SwanAppTable.app_category.name(), Integer.valueOf(fVar.b.appCategory)).add(SwanAppDbControl.SwanAppTable.orientation.name(), Integer.valueOf(fVar.b.getOrientation())).add(SwanAppDbControl.SwanAppTable.max_age.name(), Long.valueOf(fVar.b.maxAge)).add(SwanAppDbControl.SwanAppTable.create_time.name(), Long.valueOf(fVar.b.createTime)).add(SwanAppDbControl.SwanAppTable.force_fetch_meta_info.name(), 0).add("app_from", fVar.a.i).add("visit_time", Long.valueOf(fVar.a.e)).add(SwanAppDbControl.SwanAppTable.pay_protected.name(), Integer.valueOf(fVar.b.payProtected)).add("customer_service", Integer.valueOf(fVar.b.customerService)).add("global_notice", Integer.valueOf(fVar.b.globalNotice)).add("global_private", Integer.valueOf(fVar.b.globalPrivate)).add("pa_number", fVar.b.paNumber).add(Constants.PHONE_BRAND, fVar.b.brandsInfo).add(SwanAppDbControl.SwanAppTable.quick_app_key.name(), fVar.b.quickAppKey);
        }
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (b != null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - b.get() <= 86400000) {
                    return false;
                }
                b.set(currentTimeMillis);
                sc3.a().putLong("key_check_delete_swan_history", currentTimeMillis);
                return true;
            }
            synchronized (sc3.class) {
                if (b != null) {
                    return false;
                }
                b = new AtomicLong(sc3.a().getLong("key_check_delete_swan_history", 0L));
                return e();
            }
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean g(ContentResolver contentResolver, String str, String str2, String str3, String str4, boolean z, yd2.b bVar) {
        InterceptResult invokeCommon;
        char c2;
        int i;
        int delete;
        boolean z2;
        oc2 d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{contentResolver, str, str2, str3, str4, Boolean.valueOf(z), bVar})) == null) {
            switch (str4.hashCode()) {
                case 48:
                    if (str4.equals("0")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 49:
                    if (str4.equals("1")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 50:
                    if (str4.equals("2")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 51:
                    if (str4.equals("3")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 != 2) {
                        if (c2 == 3) {
                            i = 3;
                        }
                    } else {
                        i = 2;
                    }
                } else {
                    i = 1;
                }
                if (!TextUtils.isEmpty(str)) {
                    if (TextUtils.isEmpty(str2)) {
                        return false;
                    }
                    delete = contentResolver.delete(gb2.a(), "app_key=? AND app_type=? AND version_code=?", new String[]{str2, String.valueOf(i), str3});
                } else {
                    delete = contentResolver.delete(gb2.a(), "app_id=?", new String[]{str});
                }
                if (delete <= 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z && z2 && (d2 = qc2.c().d()) != null) {
                    zd2 m = zd2.m(bVar);
                    m.i(4);
                    d2.e(str, true, m.k());
                }
                if (a) {
                    Log.d("SwanAppHistoryHelper", "deleteHistory: " + str + " isSuccess: " + z2);
                }
                if (z2) {
                    rh2.j("DEL", str, System.currentTimeMillis(), str2, String.valueOf(i), str3, null);
                }
                return z2;
            }
            i = 0;
            if (!TextUtils.isEmpty(str)) {
            }
            if (delete <= 0) {
            }
            if (z) {
                zd2 m2 = zd2.m(bVar);
                m2.i(4);
                d2.e(str, true, m2.k());
            }
            if (a) {
            }
            if (z2) {
            }
            return z2;
        }
        return invokeCommon.booleanValue;
    }

    public static void h(@NonNull ContentResolver contentResolver, @Nullable String str, yd2.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, contentResolver, str, bVar) == null) {
            if (a) {
                Log.d("SwanAppHistoryHelper", "start deleteOtherDevHistory: ");
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String a2 = gw1.a(str);
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            List<String> s = s(contentResolver, str);
            if (s != null && s.size() != 0) {
                oc2 d2 = qc2.c().d();
                if (d2 != null) {
                    if (a) {
                        Log.d("SwanAppHistoryHelper", "deleteOtherDevHistory: delete other dev SwanApp");
                    }
                    d2.g(s, false, false, bVar);
                }
                if (a) {
                    Log.d("SwanAppHistoryHelper", "deleteOtherDevHistory: delete other dev history");
                }
                contentResolver.delete(gb2.a(), "app_id LIKE ? AND app_id != ?", new String[]{a2 + "_dev%", str});
            } else if (a) {
                Log.d("SwanAppHistoryHelper", "deleteOtherDevHistory finish because: other dev history is empty");
            }
        }
    }

    @NonNull
    public static Set<String> i(@NonNull ContentResolver contentResolver) {
        InterceptResult invokeL;
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, contentResolver)) == null) {
            HashSet hashSet = new HashSet();
            Cursor cursor = null;
            try {
                try {
                    cursor = contentResolver.query(gb2.a(), null, null, null, null);
                } catch (Exception e2) {
                    if (a) {
                        e2.printStackTrace();
                    }
                    if (a && cursor != null) {
                        sb = new StringBuilder();
                    }
                }
                if (cursor != null && cursor.moveToFirst()) {
                    do {
                        hashSet.add(cursor.getString(cursor.getColumnIndex("app_id")));
                    } while (cursor.moveToNext());
                    if (a) {
                        sb = new StringBuilder();
                        sb.append("getAllHistoryIdsSet: Cursor count: ");
                        sb.append(cursor.getCount());
                        Log.d("SwanAppHistoryHelper", sb.toString());
                    }
                    ik4.d(cursor);
                    return hashSet;
                }
                if (a && cursor != null) {
                    sb = new StringBuilder();
                    sb.append("getAllHistoryIdsSet: Cursor count: ");
                    sb.append(cursor.getCount());
                    Log.d("SwanAppHistoryHelper", sb.toString());
                }
                ik4.d(cursor);
                return hashSet;
            } catch (Throwable th) {
                if (a && cursor != null) {
                    Log.d("SwanAppHistoryHelper", "getAllHistoryIdsSet: Cursor count: " + cursor.getCount());
                }
                ik4.d(cursor);
                throw th;
            }
        }
        return (Set) invokeL.objValue;
    }

    public static Set<String> q(SQLiteDatabase sQLiteDatabase) {
        InterceptResult invokeL;
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, sQLiteDatabase)) == null) {
            HashSet hashSet = new HashSet();
            Cursor cursor = null;
            try {
                try {
                    cursor = sQLiteDatabase.query("ai_apps_history", null, null, null, null, null, null);
                } catch (Exception e2) {
                    if (a) {
                        e2.printStackTrace();
                    }
                    if (a && cursor != null) {
                        sb = new StringBuilder();
                    }
                }
                if (cursor != null && cursor.moveToFirst()) {
                    do {
                        hashSet.add(cursor.getString(cursor.getColumnIndex("app_id")));
                    } while (cursor.moveToNext());
                    if (a) {
                        sb = new StringBuilder();
                        sb.append("getAllHistoryIdsSet: Cursor count: ");
                        sb.append(cursor.getCount());
                        Log.d("SwanAppHistoryHelper", sb.toString());
                    }
                    gs2.a(cursor);
                    return hashSet;
                }
                if (a && cursor != null) {
                    sb = new StringBuilder();
                    sb.append("getAllHistoryIdsSet: Cursor count: ");
                    sb.append(cursor.getCount());
                    Log.d("SwanAppHistoryHelper", sb.toString());
                }
                gs2.a(cursor);
                return hashSet;
            } catch (Throwable th) {
                if (a && cursor != null) {
                    Log.d("SwanAppHistoryHelper", "getAllHistoryIdsSet: Cursor count: " + cursor.getCount());
                }
                gs2.a(cursor);
                throw th;
            }
        }
        return (Set) invokeL.objValue;
    }

    public static void j(s63.c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65546, null, cVar) != null) || cVar == null) {
            return;
        }
        gz9.f("").y(Schedulers.io()).h(new b()).k(qz9.b()).w(new a(cVar));
    }

    @NonNull
    public static JSONObject k(Cursor cursor) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, cursor)) == null) {
            JSONArray jSONArray = new JSONArray();
            do {
                JSONObject jSONObject = new JSONObject();
                try {
                    String string = cursor.getString(cursor.getColumnIndex("app_id"));
                    if (!TextUtils.isEmpty(string)) {
                        jSONObject.put("appid", string);
                    }
                    String string2 = cursor.getString(cursor.getColumnIndex(GameGuideConfigInfo.KEY_APP_KEY));
                    if (!TextUtils.isEmpty(string2)) {
                        jSONObject.put("appKey", string2);
                    }
                    jSONObject.put("version", cursor.getInt(cursor.getColumnIndex("version_code")));
                    int i = cursor.getInt(cursor.getColumnIndex("frame_type"));
                    jSONObject.put("frameType", i);
                    int i2 = cursor.getInt(cursor.getColumnIndex("app_type"));
                    String str2 = "1";
                    if (i2 != 0) {
                        if (i2 != 1) {
                            if (i2 != 2) {
                                if (i2 == 3) {
                                    str2 = "3";
                                }
                            } else {
                                str2 = "2";
                            }
                        } else {
                            str2 = "0";
                        }
                    }
                    jSONObject.put("type", str2);
                    if (TextUtils.isEmpty(string)) {
                        string = "";
                    }
                    if (i == 1) {
                        str = String.format(s63.d, string);
                    } else {
                        str = s63.c + string + "\"}";
                    }
                    jSONObject.put("scheme", str);
                    String string3 = cursor.getString(cursor.getColumnIndex("visit_time"));
                    if (!TextUtils.isEmpty(string3)) {
                        jSONObject.put("dataStamp", string3);
                        jSONObject.put("dateStamp", string3);
                    }
                    String string4 = cursor.getString(cursor.getColumnIndex("app_icon"));
                    if (!TextUtils.isEmpty(string4)) {
                        jSONObject.put("iconUrl", string4);
                    }
                    jSONObject.put("payProtected", cursor.getInt(cursor.getColumnIndex("pay_protected")));
                    String string5 = cursor.getString(cursor.getColumnIndex("app_name"));
                    if (!TextUtils.isEmpty(string5)) {
                        jSONObject.put("title", string5);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                jSONArray.put(jSONObject);
            } while (cursor.moveToNext());
            gs2.a(cursor);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("history", jSONArray);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            if (a) {
                Log.d("SwanAppHistoryHelper", "historyCursorToJson : " + jSONObject2.toString());
            }
            return jSONObject2;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void l(List<qh2> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65548, null, list) == null) && list != null && list.size() > 0) {
            SQLiteDatabase e2 = SwanAppDbControl.f(AppRuntime.getAppContext()).e();
            e2.beginTransaction();
            try {
                try {
                    for (qh2 qh2Var : list) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("app_id", qh2Var.a);
                        contentValues.put("visit_time", Long.valueOf(qh2Var.e));
                        contentValues.put("app_from", qh2Var.i);
                        contentValues.put("app_name", qh2Var.c);
                        contentValues.put(GameGuideConfigInfo.KEY_APP_KEY, qh2Var.b);
                        contentValues.put("version_code", qh2Var.j);
                        contentValues.put("app_icon", qh2Var.d);
                        contentValues.put("app_type", qh2Var.g);
                        contentValues.put("frame_type", Integer.valueOf(qh2Var.f));
                        contentValues.put("pay_protected", Integer.valueOf(qh2Var.h));
                        contentValues.put("sync_state", (Integer) 1);
                        e2.insertWithOnConflict("ai_apps_history", null, contentValues, 5);
                    }
                    e2.setTransactionSuccessful();
                } catch (Exception e3) {
                    if (a) {
                        e3.printStackTrace();
                    }
                }
                e2.endTransaction();
                AppRuntime.getAppContext().getContentResolver().notifyChange(gb2.a(), (ContentObserver) null, false);
            } catch (Throwable th) {
                e2.endTransaction();
                throw th;
            }
        }
    }

    public static Cursor n(String str, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, str, strArr)) == null) {
            return AppRuntime.getAppContext().getContentResolver().query(gb2.a(), null, str, strArr, "visit_time desc  LIMIT 200");
        }
        return (Cursor) invokeLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0206 A[LOOP:3: B:50:0x0200->B:52:0x0206, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02ae A[LOOP:5: B:67:0x02a8->B:69:0x02ae, LOOP_END] */
    @Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Cursor o(@NonNull String str, int i) {
        InterceptResult invokeLI;
        Cursor query;
        List<d> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65551, null, str, i)) == null) {
            HashMap hashMap = new HashMap();
            Cursor p = p(AppRuntime.getAppContext().getContentResolver(), str);
            if (p != null && p.moveToFirst()) {
                do {
                    bb2 bb2Var = new bb2();
                    SwanAppDbControl.f(AppRuntime.getAppContext()).s(p, bb2Var);
                    if (!TextUtils.isEmpty(bb2Var.a)) {
                        c cVar = new c(null);
                        cVar.b = bb2Var;
                        qh2 qh2Var = cVar.a;
                        qh2Var.a = bb2Var.a;
                        qh2Var.a = p.getString(p.getColumnIndex("app_from"));
                        cVar.a.e = p.getLong(p.getColumnIndex("visit_time"));
                        hashMap.put(cVar.a.a, cVar);
                        if (a) {
                            Log.v("history_migrate_pms", "Aps&History == " + bb2Var.a);
                        }
                    }
                } while (p.moveToNext());
                ik4.d(p);
                if (a) {
                }
                query = AppRuntime.getAppContext().getContentResolver().query(gb2.a(), null, null, null, null);
                HashMap hashMap2 = new HashMap();
                if (query == null) {
                }
                ik4.d(query);
                if (a) {
                }
                ArrayList<d> arrayList2 = new ArrayList();
                while (r2.hasNext()) {
                }
                if (a) {
                }
                while (r13.hasNext()) {
                }
                if (a) {
                }
                arrayList = new ArrayList(hashMap.values());
                Collections.sort(arrayList, new e(null));
                int i2 = 0;
                if (i > 0) {
                }
                MatrixCursor matrixCursor = new MatrixCursor(c, 50);
                while (r13.hasNext()) {
                }
                return matrixCursor;
            }
            ik4.d(p);
            if (a) {
                Log.d("history_migrate_pms", "^ Aps & History 查询到 " + hashMap.size() + " 个历史记录");
            }
            query = AppRuntime.getAppContext().getContentResolver().query(gb2.a(), null, null, null, null);
            HashMap hashMap22 = new HashMap();
            if (query == null && query.moveToFirst()) {
                do {
                    qh2 qh2Var2 = new qh2();
                    qh2Var2.a = query.getString(query.getColumnIndex("app_id"));
                    qh2Var2.i = query.getString(query.getColumnIndex("app_from"));
                    qh2Var2.e = query.getLong(query.getColumnIndex("visit_time"));
                    qh2Var2.c = query.getString(query.getColumnIndex("app_name"));
                    qh2Var2.b = query.getString(query.getColumnIndex(GameGuideConfigInfo.KEY_APP_KEY));
                    qh2Var2.j = query.getString(query.getColumnIndex("version_code"));
                    qh2Var2.d = query.getString(query.getColumnIndex("app_icon"));
                    qh2Var2.f = query.getInt(query.getColumnIndex("frame_type"));
                    hashMap22.put(qh2Var2.a, qh2Var2);
                    if (a) {
                        Log.v("history_migrate_pms", "History == " + qh2Var2.a);
                    }
                } while (query.moveToNext());
                ik4.d(query);
                if (a) {
                }
                ArrayList<d> arrayList22 = new ArrayList();
                while (r2.hasNext()) {
                }
                if (a) {
                }
                while (r13.hasNext()) {
                }
                if (a) {
                }
                arrayList = new ArrayList(hashMap.values());
                Collections.sort(arrayList, new e(null));
                int i22 = 0;
                if (i > 0) {
                    arrayList = arrayList.subList(0, i);
                    if (a) {
                    }
                }
                MatrixCursor matrixCursor2 = new MatrixCursor(c, 50);
                while (r13.hasNext()) {
                }
                return matrixCursor2;
            }
            ik4.d(query);
            if (a) {
                Log.d("history_migrate_pms", "^ History 库查询到 " + hashMap22.size() + " 个历史记录");
            }
            ArrayList<d> arrayList222 = new ArrayList();
            for (PMSAppInfo pMSAppInfo : new ArrayList(bc4.i().v().values())) {
                if (a) {
                    Log.v("history_migrate_pms", "Pms == " + pMSAppInfo.appId);
                }
                String str2 = pMSAppInfo.appName;
                if (str2 != null && str2.contains(str) && hashMap22.containsKey(pMSAppInfo.appId)) {
                    f fVar = new f(null);
                    fVar.a = (qh2) hashMap22.get(pMSAppInfo.appId);
                    fVar.b = pMSAppInfo;
                    arrayList222.add(fVar);
                }
            }
            if (a) {
                Log.d("history_migrate_pms", "^ Pms & History 查询到 " + arrayList222.size() + " 个历史记录");
            }
            for (d dVar : arrayList222) {
                hashMap.put(dVar.a.a, dVar);
            }
            if (a) {
                Log.d("history_migrate_pms", "合并后有 " + hashMap.size() + " 个历史记录");
                Iterator it = hashMap.values().iterator();
                while (it.hasNext()) {
                    Log.v("history_migrate_pms", "Migrate == " + ((d) it.next()).a.a);
                }
            }
            arrayList = new ArrayList(hashMap.values());
            Collections.sort(arrayList, new e(null));
            int i222 = 0;
            if (i > 0 && i < arrayList.size()) {
                arrayList = arrayList.subList(0, i);
                if (a) {
                    Log.d("history_migrate_pms", "Limit限制 " + i + " 条");
                }
            }
            MatrixCursor matrixCursor22 = new MatrixCursor(c, 50);
            for (d dVar2 : arrayList) {
                d(matrixCursor22, i222, dVar2);
                i222++;
            }
            return matrixCursor22;
        }
        return (Cursor) invokeLI.objValue;
    }

    @Nullable
    public static Cursor p(@NonNull ContentResolver contentResolver, @NonNull String str) {
        InterceptResult invokeLL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, contentResolver, str)) == null) {
            try {
                cursor = contentResolver.query(gb2.b(), null, SwanAppDbControl.SwanAppTable.name.name() + " LIKE ? ", new String[]{"%" + str + "%"}, "visit_time desc  LIMIT 200");
            } catch (Exception e2) {
                if (a) {
                    e2.printStackTrace();
                }
                cursor = null;
            }
            if (a && cursor != null) {
                Log.d("SwanAppHistoryHelper", "queryHistoryByKeyword: keyword[" + str + "]  Cursor count: " + cursor.getCount());
            }
            return cursor;
        }
        return (Cursor) invokeLL.objValue;
    }

    public static List<qh2> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            ContentResolver contentResolver = AppRuntime.getAppContext().getContentResolver();
            Cursor query = contentResolver.query(gb2.a(), null, "sync_state=?", new String[]{String.valueOf(0)}, "visit_time asc  LIMIT 200");
            if (query != null && query.moveToFirst()) {
                ArrayList arrayList = new ArrayList();
                do {
                    qh2 qh2Var = new qh2();
                    qh2Var.a = query.getString(query.getColumnIndex("app_id"));
                    qh2Var.e = query.getLong(query.getColumnIndex("visit_time"));
                    arrayList.add(qh2Var);
                } while (query.moveToNext());
                gs2.a(query);
                return arrayList;
            }
            gs2.a(query);
            return null;
        }
        return (List) invokeV.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:28:0x0089 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.Closeable] */
    @Nullable
    public static List<String> s(@NonNull ContentResolver contentResolver, @Nullable String str) {
        InterceptResult invokeLL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, contentResolver, str)) == null) {
            ?? r1 = 0;
            try {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                try {
                    String a2 = gw1.a(str);
                    if (TextUtils.isEmpty(a2)) {
                        ik4.d(null);
                        return null;
                    }
                    cursor = contentResolver.query(gb2.a(), null, "app_id LIKE ? AND app_id != ?", new String[]{a2 + "_dev%", str}, "visit_time desc  LIMIT 200");
                    if (cursor != null) {
                        try {
                            if (cursor.moveToFirst()) {
                                ArrayList arrayList = new ArrayList();
                                do {
                                    String string = cursor.getString(cursor.getColumnIndex("app_id"));
                                    if (!TextUtils.isEmpty(string)) {
                                        arrayList.add(string);
                                    }
                                } while (cursor.moveToNext());
                                ik4.d(cursor);
                                return arrayList;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            if (a) {
                                e.printStackTrace();
                            }
                            ik4.d(cursor);
                            return null;
                        }
                    }
                    ik4.d(cursor);
                    return null;
                } catch (Exception e3) {
                    e = e3;
                    cursor = null;
                } catch (Throwable th) {
                    th = th;
                    ik4.d(r1);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                r1 = contentResolver;
            }
        } else {
            return (List) invokeLL.objValue;
        }
    }

    @WorkerThread
    public static void t(@NonNull ContentResolver contentResolver, @Nullable String str, yd2.b bVar) {
        int i;
        Cursor query;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65556, null, contentResolver, str, bVar) == null) {
            Cursor cursor = null;
            if (str == null) {
                str = "";
            }
            try {
                try {
                    query = contentResolver.query(gb2.a(), null, "app_id != ?", new String[]{str, String.valueOf(200)}, "visit_time DESC limit ?,-1");
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                ArrayList arrayList = new ArrayList();
                if (query != null) {
                    while (query.moveToNext()) {
                        String string = query.getString(query.getColumnIndex("app_id"));
                        if (!TextUtils.isEmpty(string)) {
                            arrayList.add(string);
                        }
                    }
                }
                if (a) {
                    Log.i("SwanAppHistoryHelper", "tryDelUpperLimitSwanApp size=" + arrayList.size() + ", appId=" + str);
                }
                if (arrayList.isEmpty()) {
                    ik4.d(query);
                    return;
                }
                oc2 d2 = qc2.c().d();
                if (d2 != null) {
                    d2.f(arrayList, false, bVar);
                }
                StringBuilder sb = new StringBuilder();
                int size = arrayList.size();
                for (i = 0; i < size; i++) {
                    sb.append('\'');
                    sb.append((String) arrayList.get(i));
                    sb.append('\'');
                    if (i < size - 1) {
                        sb.append(",");
                    }
                }
                String str2 = "app_id in (" + sb.toString() + SmallTailInfo.EMOTION_SUFFIX;
                int delete = contentResolver.delete(gb2.a(), str2, null);
                if (a) {
                    Log.i("SwanAppHistoryHelper", "tryDelUpperLimitSwanApp delete result=" + delete + ", query=" + str2);
                }
                ik4.d(query);
            } catch (Exception e3) {
                e = e3;
                cursor = query;
                if (a) {
                    Log.e("SwanAppHistoryHelper", "tryDelUpperLimitSwanApp error", e);
                }
                ik4.d(cursor);
            } catch (Throwable th2) {
                th = th2;
                cursor = query;
                ik4.d(cursor);
                throw th;
            }
        }
    }

    public static void u(ContentResolver contentResolver, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65557, null, contentResolver, str, i) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("sync_state", Integer.valueOf(i));
            contentResolver.update(gb2.a(), contentValues, "app_id=?", new String[]{str});
        }
    }

    public static void v(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, null, sQLiteDatabase) == null) {
            sQLiteDatabase.beginTransaction();
            try {
                for (String str : q(sQLiteDatabase)) {
                    PMSAppInfo u = bc4.i().u(str);
                    if (u != null) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("app_name", u.appName);
                        contentValues.put("app_icon", u.iconUrl);
                        contentValues.put("frame_type", Integer.valueOf(u.appCategory));
                        contentValues.put("app_type", String.valueOf(u.type));
                        contentValues.put("sync_state", (Integer) 0);
                        if (sQLiteDatabase.updateWithOnConflict("ai_apps_history", contentValues, "app_id=?", new String[]{str}, 5) <= 0) {
                            if (a) {
                                Log.e("SwanAppHistoryHelper", "updatePMSDataToHistoryTable: 更新失败");
                            }
                            return;
                        }
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
            } finally {
                sQLiteDatabase.endTransaction();
            }
        }
    }
}

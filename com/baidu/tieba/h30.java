package com.baidu.tieba;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.request.taskmanager.DatabaseMng;
import com.baidu.tieba.c30;
import com.baidu.tieba.k50;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.OutputStream;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class h30 extends c30 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public k50.a f;
    public b g;

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        public a() {
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

        public static a d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
                JSONObject jSONObject = new JSONObject(new String(new s40().a(Base64.decode(str, 3))));
                a aVar = new a();
                aVar.c(jSONObject.getString("id"));
                aVar.b(jSONObject.getInt("d_form_ver"));
                return aVar;
            }
            return (a) invokeL.objValue;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (String) invokeV.objValue;
        }

        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            }
        }

        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.a = str;
            }
        }

        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.a == null) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject();
                s40 s40Var = new s40();
                jSONObject.put("id", this.a);
                jSONObject.put("d_form_ver", 1);
                return Base64.encodeToString(s40Var.b(jSONObject.toString().getBytes()), 3);
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public String b;
        public boolean c;
        public final /* synthetic */ h30 d;

        public b(h30 h30Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h30Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = h30Var;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (String) invokeV.objValue;
        }

        public void b(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) || this.a == j) {
                return;
            }
            this.a = j;
            this.c = true;
        }

        public void c(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || str.equals(this.b)) {
                return;
            }
            this.b = str;
            this.c = true;
        }

        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? e(this.d.f.g("pub.dat", true)) : invokeV.booleanValue;
        }

        public final boolean e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        this.a = jSONObject.getLong("pub_lst_ts");
                        this.b = jSONObject.getString("pub_id");
                        jSONObject.getInt("d_form_ver");
                        this.c = false;
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                if (this.c) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("pub_id", this.b);
                        jSONObject.put("pub_lst_ts", this.a);
                        jSONObject.put("d_form_ver", 1);
                        this.d.f.i("pub.dat", jSONObject.toString(), true);
                        this.c = false;
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c extends c30.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String d;
        public long e;
        public long f;
        public String g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(h30 h30Var, String str) {
            super(h30Var.f, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h30Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((k50.a) objArr2[0], (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.baidu.tieba.c30.c
        public void c(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.d = jSONObject.getString("pkg");
                this.e = jSONObject.getLong("last_fe_ts");
                this.g = jSONObject.getString("id");
                this.f = jSONObject.getLong("tar_pkg_lst_up_ts");
                jSONObject.getInt("d_form_ver");
            }
        }

        @Override // com.baidu.tieba.c30.c
        public void e(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                jSONObject.put("pkg", this.d);
                jSONObject.put("last_fe_ts", this.e);
                jSONObject.put("id", this.g);
                jSONObject.put("tar_pkg_lst_up_ts", this.f);
                jSONObject.put("d_form_ver", 1);
            }
        }

        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.d : (String) invokeV.objValue;
        }

        public boolean g(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
                if (this.e != j) {
                    this.e = j;
                    a(true);
                    return true;
                }
                return false;
            }
            return invokeJ.booleanValue;
        }

        public boolean h(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                if (str.equals(this.d)) {
                    return false;
                }
                this.d = str;
                a(true);
                return true;
            }
            return invokeL.booleanValue;
        }

        public String i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.g : (String) invokeV.objValue;
        }

        public boolean j(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j)) == null) {
                if (this.f != j) {
                    this.f = j;
                    a(true);
                    return true;
                }
                return false;
            }
            return invokeJ.booleanValue;
        }

        public boolean k(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                if (str.equals(this.g)) {
                    return false;
                }
                this.g = str;
                a(true);
                return true;
            }
            return invokeL.booleanValue;
        }

        public long l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f : invokeV.longValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h30() {
        super("esc-ms", 7500000L);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                super((String) objArr[0], ((Long) objArr[1]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = new b(this);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, IF, IF] complete} */
    @Override // com.baidu.tieba.c30
    public c30.h b(String str, c30.g gVar) {
        InterceptResult invokeLL;
        PackageInfo packageInfo;
        c cVar;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, gVar)) == null) {
            if (Build.VERSION.SDK_INT < 29) {
                i = -101;
            } else {
                Context context = this.a.a;
                Cursor cursor = null;
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str, 0);
                } catch (PackageManager.NameNotFoundException unused) {
                    packageInfo = null;
                }
                if (packageInfo == null) {
                    i = -1;
                } else {
                    if (gVar.a) {
                        cVar = new c(this, str);
                        cVar.d();
                        if (str.equals(cVar.f()) && packageInfo.lastUpdateTime == cVar.l()) {
                            String i2 = cVar.i();
                            if (!TextUtils.isEmpty(i2)) {
                                return c30.h.f(i2);
                            }
                        }
                    } else {
                        cVar = null;
                    }
                    if (context.checkPermission(com.kuaishou.weapon.p0.h.i, Process.myPid(), Process.myUid()) == 0) {
                        try {
                            try {
                                cursor = context.getContentResolver().query(MediaStore.setIncludePending(MediaStore.Images.Media.EXTERNAL_CONTENT_URI), new String[]{"_id", "description"}, "owner_package_name = ? AND relative_path = ?", new String[]{str, "Pictures/" + str + "/helios/"}, DatabaseMng.DEFAULT_SORT_ORDER);
                                if (cursor != null) {
                                    while (cursor.moveToNext()) {
                                        String string = cursor.getString(cursor.getColumnIndexOrThrow("description"));
                                        if (string != null) {
                                            try {
                                                String a2 = a.d(string).a();
                                                if (!TextUtils.isEmpty(a2)) {
                                                    if (gVar.a && cVar != null) {
                                                        cVar.k(a2);
                                                        cVar.g(System.currentTimeMillis());
                                                        cVar.j(packageInfo.lastUpdateTime);
                                                        cVar.h(str);
                                                    }
                                                    c30.h f = c30.h.f(a2);
                                                    f50.a(cursor);
                                                    if (gVar.a && cVar != null) {
                                                        cVar.b();
                                                    }
                                                    return f;
                                                }
                                                continue;
                                            } catch (Exception unused2) {
                                                continue;
                                            }
                                        }
                                    }
                                }
                                f50.a(cursor);
                                if (gVar.a && cVar != null) {
                                    cVar.b();
                                }
                                i = -2;
                            } catch (Exception e) {
                                c30.h d = c30.h.d(e);
                                f50.a(cursor);
                                if (gVar.a && cVar != null) {
                                    cVar.b();
                                }
                                return d;
                            }
                        } catch (Throwable th) {
                            f50.a(cursor);
                            if (gVar.a && cVar != null) {
                                cVar.b();
                            }
                            throw th;
                        }
                    } else {
                        i = -100;
                    }
                }
            }
            return c30.h.b(i);
        }
        return (c30.h) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.c30
    public void e(c30.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            this.f = this.b.f("esc-ms");
        }
    }

    @Override // com.baidu.tieba.c30
    public c30.f f(c30.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar)) == null) {
            if (Build.VERSION.SDK_INT < 29) {
                return c30.f.a();
            }
            this.g.d();
            try {
                return i(eVar);
            } finally {
                this.g.f();
            }
        }
        return (c30.f) invokeL.objValue;
    }

    public final Uri h(String str, ContentResolver contentResolver, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(1048579, this, str, contentResolver, str2)) != null) {
            return (Uri) invokeLLL.objValue;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", "helios-icon.JPG");
        contentValues.put("mime_type", "image/jpeg");
        contentValues.put("is_pending", (Integer) 1);
        int i = 0;
        contentValues.put("relative_path", String.format("Pictures/%s/helios", str));
        contentValues.put("description", str2);
        while (true) {
            try {
                Uri insert = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                if (insert == null) {
                    throw new IllegalStateException("file path maybe duplicated");
                    break;
                }
                return insert;
            } catch (IllegalStateException e) {
                i++;
                if (i > 5) {
                    throw new IllegalStateException("insert file retry count exceed", e);
                }
                contentValues.put("_display_name", "helios-icon-" + i + ".JPG");
            }
        }
    }

    public final c30.f i(c30.e eVar) {
        InterceptResult invokeL;
        ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, eVar)) == null) {
            Context context = this.a.a;
            String packageName = context.getPackageName();
            ContentResolver contentResolver = this.a.a.getContentResolver();
            String c2 = this.a.c.a("aid").c();
            String a2 = this.g.a();
            if (a2 == null || !TextUtils.equals(a2, c2)) {
                if (Build.VERSION.SDK_INT < 29) {
                    return c30.f.a();
                }
                ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream2 = null;
                try {
                    try {
                        a aVar = new a();
                        aVar.c(c2);
                        autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(contentResolver.openFileDescriptor(h(packageName, contentResolver, aVar.e()), "w", null));
                    } catch (Exception e) {
                        e = e;
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    j(autoCloseOutputStream, context);
                    this.g.c(c2);
                    this.g.b(System.currentTimeMillis());
                    c30.f d = c30.f.d();
                    f50.b(autoCloseOutputStream);
                    return d;
                } catch (Exception e2) {
                    e = e2;
                    autoCloseOutputStream2 = autoCloseOutputStream;
                    c30.f c3 = c30.f.c(e);
                    f50.b(autoCloseOutputStream2);
                    return c3;
                } catch (Throwable th2) {
                    th = th2;
                    autoCloseOutputStream2 = autoCloseOutputStream;
                    f50.b(autoCloseOutputStream2);
                    throw th;
                }
            }
            return c30.f.d();
        }
        return (c30.f) invokeL.objValue;
    }

    public final void j(OutputStream outputStream, Context context) {
        float min;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, outputStream, context) == null) {
            Drawable loadIcon = context.getApplicationInfo().loadIcon(context.getPackageManager());
            int intrinsicWidth = loadIcon.getIntrinsicWidth();
            int intrinsicHeight = loadIcon.getIntrinsicHeight();
            Matrix matrix = new Matrix();
            Bitmap createBitmap = Bitmap.createBitmap(96, 96, Bitmap.Config.ARGB_8888);
            if (intrinsicWidth > 96 || intrinsicHeight > 96) {
                float f = 96;
                min = Math.min(f / intrinsicWidth, f / intrinsicHeight);
            } else {
                min = 1.0f;
            }
            float f2 = 96;
            matrix.setScale(min, min);
            matrix.postTranslate(Math.round((f2 - (intrinsicWidth * min)) * 0.5f), Math.round((f2 - (intrinsicHeight * min)) * 0.5f));
            Canvas canvas = new Canvas(createBitmap);
            canvas.concat(matrix);
            loadIcon.setBounds(0, 0, loadIcon.getIntrinsicWidth(), loadIcon.getIntrinsicHeight());
            loadIcon.draw(canvas);
            createBitmap.compress(Bitmap.CompressFormat.JPEG, 90, outputStream);
            createBitmap.recycle();
        }
    }
}

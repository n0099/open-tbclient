package com.baidu.tieba;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tieba.o93;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e63 extends g63 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class a implements cj3<m93<o93.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ File d;
        public final /* synthetic */ UnitedSchemeEntity e;
        public final /* synthetic */ e63 f;

        /* renamed from: com.baidu.tieba.e63$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0255a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0255a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    a aVar = this.a;
                    aVar.f.p(aVar.c, aVar.d, aVar.e, aVar.a, aVar.b);
                }
            }
        }

        public a(e63 e63Var, CallbackHandler callbackHandler, String str, Context context, File file, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e63Var, callbackHandler, str, context, file, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = e63Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = context;
            this.d = file;
            this.e = unitedSchemeEntity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cj3
        /* renamed from: b */
        public void a(m93<o93.e> m93Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, m93Var) == null) {
                if (!h93.h(m93Var)) {
                    j12.i("SaveImage", "Permission denied");
                    h93.q(m93Var, this.a, this.b);
                    return;
                }
                dh3.k(new RunnableC0255a(this), "SaveImageAction");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements mz2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ File b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ String d;
        public final /* synthetic */ UnitedSchemeEntity e;
        public final /* synthetic */ e63 f;

        public b(e63 e63Var, Context context, File file, CallbackHandler callbackHandler, String str, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e63Var, context, file, callbackHandler, str, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = e63Var;
            this.a = context;
            this.b = file;
            this.c = callbackHandler;
            this.d = str;
            this.e = unitedSchemeEntity;
        }

        @Override // com.baidu.tieba.mz2
        public void a(String str) {
            int i;
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, str) != null) {
                return;
            }
            boolean q = qg3.a() ? this.f.q(this.a, this.b) : this.f.r(this.a, this.b);
            if (q) {
                i = 0;
            } else {
                i = 1001;
            }
            if (q) {
                str2 = "save success";
            } else {
                str2 = "can not save to album : " + this.b;
            }
            j12.i("SaveImage", str2);
            this.c.handleSchemeDispatchCallback(this.d, UnitedSchemeUtility.wrapCallbackParams(i, str2).toString());
        }

        @Override // com.baidu.tieba.mz2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                j12.i("SaveImage", str + "");
                UnitedSchemeUtility.safeCallback(this.c, this.e, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.d);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e63(g53 g53Var) {
        super(g53Var, "/swanAPI/saveImageToPhotosAlbum");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {g53Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final String m(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file)) == null) {
            String t = nk4.t(file.getPath());
            String valueOf = String.valueOf(System.currentTimeMillis());
            if (!TextUtils.isEmpty(t)) {
                return valueOf + "." + t;
            }
            return valueOf;
        }
        return (String) invokeL.objValue;
    }

    public static String o(Uri uri, Context context) {
        InterceptResult invokeLL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, uri, context)) == null) {
            Cursor cursor2 = null;
            r7 = null;
            r7 = null;
            String str = null;
            try {
                cursor = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
                if (cursor != null) {
                    try {
                        try {
                            int columnIndexOrThrow = cursor.getColumnIndexOrThrow("_data");
                            cursor.moveToFirst();
                            str = cursor.getString(columnIndexOrThrow);
                        } catch (SQLException e) {
                            e = e;
                            if (g63.b) {
                                e.printStackTrace();
                            }
                            nk4.d(cursor);
                            return str;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        nk4.d(cursor2);
                        throw th;
                    }
                }
            } catch (SQLException e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                nk4.d(cursor2);
                throw th;
            }
            nk4.d(cursor);
            return str;
        }
        return (String) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.g63
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, j43 j43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, j43Var)) == null) {
            if (j43Var == null) {
                j12.c("SaveImage", "illegal swanApp");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
                return false;
            }
            JSONObject a2 = g63.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                j12.c("SaveImage", "illegal params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal params");
                return false;
            }
            String optString = a2.optString("filePath");
            try {
                File n = n(j43Var, optString, URI.create(optString));
                if (n != null && n.exists() && n.isFile()) {
                    String optString2 = a2.optString("cb");
                    if (TextUtils.isEmpty(optString2)) {
                        j12.c("SaveImage", "empty cb");
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                        return false;
                    }
                    j43Var.e0().g(context, "mapp_images", new a(this, callbackHandler, optString2, context, n, unitedSchemeEntity));
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    return true;
                }
                j12.c("SaveImage", "can not find such file");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "can not find such file : " + n);
                return false;
            } catch (Exception e) {
                if (g63.b) {
                    e.printStackTrace();
                }
                j12.c("SaveImage", "Illegal file_path");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "Illegal file_path : " + optString);
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final File n(j43 j43Var, String str, URI uri) {
        InterceptResult invokeLLL;
        String e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, j43Var, str, uri)) == null) {
            mc3 G = wp2.U().G();
            if ("bdfile".equalsIgnoreCase(uri.getScheme())) {
                e = G.i(str);
            } else if (i03.B(j43Var.Y())) {
                e = G.m(str);
            } else {
                e = G.e(str);
            }
            if (!TextUtils.isEmpty(e)) {
                return new File(e);
            }
            return null;
        }
        return (File) invokeLLL.objValue;
    }

    public final void p(@NonNull Context context, File file, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, context, file, unitedSchemeEntity, callbackHandler, str) == null) {
            lz2.e("android.permission.WRITE_EXTERNAL_STORAGE", new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 3, context, new b(this, context, file, callbackHandler, str, unitedSchemeEntity));
        }
    }

    public final boolean q(Context context, File file) {
        String str;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, file)) == null) {
            try {
                str = MediaStore.Images.Media.insertImage(context.getContentResolver(), file.getPath(), file.getName(), "by aiapp");
            } catch (FileNotFoundException e) {
                if (g63.b) {
                    e.printStackTrace();
                }
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                String o = o(Uri.parse(str), context);
                if (!TextUtils.isEmpty(o)) {
                    hh3.r(context, o);
                }
            }
            if (g63.b) {
                Log.i("SaveImageAction", "saveToAlbum : file = " + file);
                Log.i("SaveImageAction", "saveToAlbum : image = " + str);
            }
            j12.i("SaveImage", "save success");
            return !TextUtils.isEmpty(str);
        }
        return invokeLL.booleanValue;
    }

    public final boolean r(Context context, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, context, file)) == null) {
            Bitmap decodeFile = BitmapFactory.decodeFile(file.getPath());
            if (decodeFile == null) {
                return false;
            }
            decodeFile.recycle();
            File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            nk4.l(externalStoragePublicDirectory);
            File file2 = new File(externalStoragePublicDirectory, m(file));
            if (nk4.f(file, file2) == 0) {
                return false;
            }
            hh3.r(context, file2.getAbsolutePath());
            return true;
        }
        return invokeLL.booleanValue;
    }
}

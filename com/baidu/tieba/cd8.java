package com.baidu.tieba;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.QRCodeScanActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tieba.ju8;
import com.baidu.tieba.qrcode.lib.core.QRCodeView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class cd8 implements QRCodeView.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final bd8 a;
    public final TbPageContext b;
    public e c;
    public ju8 d;
    public d e;
    public boolean f;

    /* loaded from: classes3.dex */
    public class a implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cd8 a;

        public a(cd8 cd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cd8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cd8Var;
        }

        @Override // com.baidu.tieba.cd8.d.a
        public void a(String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048576, this, str, str2) != null) || TextUtils.isEmpty(str)) {
                return;
            }
            ux4.k().y("key_gallery_last_image_path", str);
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.a.a.o0(str, str2);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements PermissionJudgePolicy.OnPermissionsGrantedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ cd8 b;

        public b(cd8 cd8Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cd8Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cd8Var;
            this.a = str;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921361, URLDecoder.decode(this.a, "UTF-8")));
                    this.b.b.getPageActivity().finish();
                } catch (UnsupportedEncodingException unused) {
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends BdAsyncTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cd8 a;

        public c(cd8 cd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cd8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cd8Var;
        }

        public /* synthetic */ c(cd8 cd8Var, a aVar) {
            this(cd8Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                String str = strArr[0];
                if (StringUtils.isNull(str)) {
                    return null;
                }
                String postNetData = new NetWork(str).postNetData();
                if (StringUtils.isNull(postNetData)) {
                    return null;
                }
                try {
                    return new JSONObject(postNetData).optString("data");
                } catch (JSONException unused) {
                    return null;
                }
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                super.onPostExecute((c) str);
                this.a.p(str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends BdAsyncTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public a b;

        /* loaded from: classes3.dex */
        public interface a {
            void a(String str, String str2);
        }

        public d(a aVar) {
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
            this.b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                if (strArr != null && strArr.length > 0) {
                    String str = strArr[0];
                    this.a = str;
                    return gd8.c(str);
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                super.onPostExecute((d) str);
                a aVar = this.b;
                if (aVar != null) {
                    aVar.a(this.a, str);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends BdAsyncTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cd8 a;

        public e(cd8 cd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cd8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cd8Var;
        }

        public /* synthetic */ e(cd8 cd8Var, a aVar) {
            this(cd8Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                if (strArr != null && strArr.length > 0) {
                    return gd8.c(strArr[0]);
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                super.onPostExecute((e) str);
                this.a.a.b1();
                this.a.b(str);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                super.onPreExecute();
                this.a.a.g0();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements ju8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference a;
        public final String b;
        public final WeakReference c;

        public f(bd8 bd8Var, String str, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bd8Var, str, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference(bd8Var);
            this.b = str;
            this.c = new WeakReference(tbPageContext);
        }

        @Override // com.baidu.tieba.ju8.a
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.get() != null) {
                ((bd8) this.a.get()).b1();
                ((bd8) this.a.get()).a1();
            }
        }

        @Override // com.baidu.tieba.ju8.a
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.get() != null) {
                ((bd8) this.a.get()).b1();
                ((bd8) this.a.get()).w0(this.b);
            }
        }

        @Override // com.baidu.tieba.ju8.a
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.a.get() != null) {
                    ((bd8) this.a.get()).b1();
                }
                if (this.c.get() != null) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) this.c.get(), new String[]{this.b});
                    ((TbPageContext) this.c.get()).getPageActivity().finish();
                }
            }
        }

        @Override // com.baidu.tieba.ju8.a
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && this.a.get() != null) {
                ((bd8) this.a.get()).b1();
                ((bd8) this.a.get()).g1();
            }
        }
    }

    public cd8(bd8 bd8Var, TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bd8Var, tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = bd8Var;
        this.b = tbPageContext;
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            UrlManager.getInstance().dealOneLink(this.b, new String[]{str});
            this.b.getPageActivity().finish();
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f = z;
        }
    }

    @Override // com.baidu.tieba.qrcode.lib.core.QRCodeView.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            fj.M(this.b.getPageActivity(), R.string.obfuscated_res_0x7f0f0506);
            this.b.getPageActivity().finish();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ju8 ju8Var = this.d;
            if (ju8Var != null && !ju8Var.isCancelled()) {
                this.d.cancel();
            }
            e eVar = this.c;
            if (eVar != null) {
                eVar.cancel();
                this.c = null;
            }
            d dVar = this.e;
            if (dVar != null) {
                dVar.cancel();
                this.e = null;
            }
        }
    }

    @Override // com.baidu.tieba.qrcode.lib.core.QRCodeView.c
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            if (StringUtils.isNull(str)) {
                this.a.b1();
                this.a.g1();
            } else if (this.f) {
                Intent intent = new Intent();
                intent.putExtra(QRCodeScanActivityConfig.RESULT_SCAN_CODE, str);
                this.b.getPageActivity().setResult(-1, intent);
                this.b.getPageActivity().finish();
            } else if (k(str)) {
                this.a.b1();
            } else if (!StringUtils.isNull(str) && str.contains("feedavatar.baidu.com")) {
                this.a.b1();
                i(str);
            } else if (l(str)) {
                this.a.b1();
                this.b.getPageActivity().finish();
            } else if (!StringHelper.isNetworkUrl(str)) {
                this.a.b1();
                this.a.g1();
            } else {
                m(str);
            }
        }
    }

    public final String f(ContentResolver contentResolver) {
        InterceptResult invokeL;
        Throwable th;
        Cursor cursor;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, contentResolver)) == null) {
            Cursor cursor2 = null;
            if (contentResolver == null) {
                return null;
            }
            try {
                cursor = contentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id", "_display_name", "_data", "_size", "bucket_display_name", "date_modified"}, null, null, null);
            } catch (Exception unused) {
                str = null;
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
            }
            if (cursor == null) {
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            }
            try {
                try {
                    cursor.moveToLast();
                    str = cursor.getString(cursor.getColumnIndex("_data"));
                    try {
                    } catch (Exception unused2) {
                        cursor2 = cursor;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        return str;
                    }
                } catch (Exception unused3) {
                    str = null;
                }
                if (TextUtils.isEmpty(str)) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } else if (!new File(str).exists()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } else {
                    cursor.close();
                    if (cursor != null) {
                        cursor.close();
                    }
                    return str;
                }
            } catch (Throwable th3) {
                th = th3;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }
        return (String) invokeL.objValue;
    }

    public final void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            CookieSyncManager.createInstance(this.b.getPageActivity());
            CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.setAcceptCookie(true);
            cookieManager.setCookie("feedavatar.baidu.com", "cuid=" + TbadkCoreApplication.getInst().getCuid() + ParamableElem.DIVIDE_PARAM);
            cookieManager.setCookie("feedavatar.baidu.com", "tiebaapp=1;");
            CookieSyncManager.getInstance().sync();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.b.getPageActivity(), null, str, false)));
        }
    }

    public void g() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (tbPageContext = this.b) != null && tbPageContext.getPageActivity() != null) {
            if (Build.VERSION.SDK_INT >= 23 && (this.b.getPageActivity().checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0 || this.b.getPageActivity().checkSelfPermission(com.kuaishou.weapon.p0.h.i) != 0)) {
                return;
            }
            String f2 = f(this.b.getPageActivity().getContentResolver());
            if (TextUtils.isEmpty(f2) || f2.endsWith(".gif") || f2.endsWith(".GIF") || f2.equals(ux4.k().q("key_gallery_last_image_path", null))) {
                return;
            }
            d dVar = this.e;
            if (dVar != null) {
                dVar.cancel();
            }
            d dVar2 = new d(new a(this));
            this.e = dVar2;
            dVar2.execute(f2);
        }
    }

    public final boolean k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (StringUtils.isNULL(str)) {
                return false;
            }
            if (str.startsWith("tiebaclient:")) {
                p(str);
                return true;
            } else if (!str.contains("smartapp.baidu.com/mappconsole/api/packagescheme") && !str.contains("mappconsole/api/packagescheme")) {
                return false;
            } else {
                new c(this, null).execute(str);
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public final boolean l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921339, null, str);
            if (runTask != null && runTask.getData() != null && (runTask.getData() instanceof Boolean) && ((Boolean) runTask.getData()).booleanValue()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, str) != null) || StringUtils.isNull(str)) {
            return;
        }
        this.a.g0();
        e eVar = this.c;
        if (eVar != null) {
            eVar.cancel();
        }
        e eVar2 = new e(this, null);
        this.c = eVar2;
        eVar2.execute(str);
    }

    public final void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            if (!fj.D()) {
                this.a.b1();
                fj.N(this.b.getPageActivity(), this.b.getResources().getString(R.string.obfuscated_res_0x7f0f0c69));
                return;
            }
            ju8 ju8Var = this.d;
            if (ju8Var != null && !ju8Var.isCancelled()) {
                this.d.cancel();
            }
            ju8 ju8Var2 = new ju8(str, new f(this.a, str, this.b));
            this.d = ju8Var2;
            ju8Var2.setPriority(3);
            this.d.execute(new String[0]);
        }
    }

    public final void p(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, str) == null) && !StringUtils.isNull(str) && str.startsWith("tiebaclient:")) {
            if (Build.VERSION.SDK_INT <= 21) {
                fj.M(this.b.getPageActivity(), R.string.obfuscated_res_0x7f0f00ec);
                return;
            }
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            permissionJudgePolicy.clearRequestPermissionList();
            permissionJudgePolicy.appendRequestPermission(this.b.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            permissionJudgePolicy.setOnPermissionsGrantedListener(new b(this, str));
            permissionJudgePolicy.startRequestPermission(this.b.getPageActivity());
        }
    }
}

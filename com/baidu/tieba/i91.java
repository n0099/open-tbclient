package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.content.FileProvider;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.nadcore.webarch.permission.NadPermissionActivity;
import com.baidu.tieba.e81;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class i91 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ValueCallback<Uri> a;
    public String b;
    public ValueCallback<Uri[]> c;
    public h91 d;
    public boolean e;
    public boolean f;
    public Activity g;
    public boolean h;

    /* loaded from: classes6.dex */
    public class a implements e81.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ i91 b;

        public a(i91 i91Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i91Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = i91Var;
            this.a = i;
        }

        @Override // com.baidu.tieba.e81.b
        @RequiresApi(api = 21)
        public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(1048576, this, i, strArr, iArr) == null) && i == this.a) {
                if (iArr.length == 0) {
                    z = false;
                } else {
                    z = true;
                }
                for (int i2 : iArr) {
                    if (i2 == -1) {
                        z = false;
                    }
                }
                if (z) {
                    this.b.h = false;
                    i91 i91Var = this.b;
                    i91Var.startActivityForResult(i91Var.k(), 11);
                } else if (this.b.c != null) {
                    this.b.c.onReceiveValue(null);
                }
                h81.b().d(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements e81.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i91 a;

        public b(i91 i91Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i91Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i91Var;
        }

        @Override // com.baidu.tieba.e81.b
        public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(1048576, this, i, strArr, iArr) == null) && i == 4099) {
                if (iArr.length == 0) {
                    z = false;
                } else {
                    z = true;
                }
                for (int i2 : iArr) {
                    if (i2 == -1) {
                        z = false;
                    }
                }
                if (z) {
                    this.a.h = true;
                    i91 i91Var = this.a;
                    i91Var.startActivityForResult(i91Var.j(), 11);
                }
                h81.b().d(4099);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements e81.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i91 a;

        public c(i91 i91Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i91Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i91Var;
        }

        @Override // com.baidu.tieba.e81.b
        public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(1048576, this, i, strArr, iArr) == null) && i == 4099) {
                if (iArr.length == 0) {
                    z = false;
                } else {
                    z = true;
                }
                for (int i2 : iArr) {
                    if (i2 == -1) {
                        z = false;
                    }
                }
                if (z) {
                    this.a.h = true;
                    this.a.g.startActivityForResult(this.a.h(), 11);
                }
                h81.b().d(4099);
            }
        }
    }

    public i91(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = false;
        this.g = activity;
    }

    public boolean startActivityForResult(Intent intent, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048588, this, intent, i)) == null) {
            try {
                try {
                    this.g.startActivityForResult(intent, i);
                    return true;
                } catch (ActivityNotFoundException unused) {
                    g();
                    return false;
                }
            } catch (ActivityNotFoundException unused2) {
                this.f = true;
                this.g.startActivityForResult(m(), i);
                return true;
            }
        }
        return invokeLI.booleanValue;
    }

    private void requestPermissions(int i, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65543, this, i, strArr) == null) {
            Intent intent = new Intent(this.g.getApplicationContext(), NadPermissionActivity.class);
            intent.putExtra("request_code", i);
            intent.putExtra("permissions", strArr);
            h81.b().a(i, new a(this, i));
            try {
                w61.c(this.g, intent);
            } catch (Exception unused) {
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ValueCallback<Uri> valueCallback = this.a;
            if (valueCallback != null) {
                valueCallback.onReceiveValue(null);
            }
            ValueCallback<Uri[]> valueCallback2 = this.c;
            if (valueCallback2 != null) {
                valueCallback2.onReceiveValue(null);
            }
        }
    }

    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.g;
        }
        return (Activity) invokeV.objValue;
    }

    public final Intent n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return new Intent("android.provider.MediaStore.RECORD_SOUND");
        }
        return (Intent) invokeV.objValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    public final Intent h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (l91.a(this.g)) {
                return new Intent("android.media.action.VIDEO_CAPTURE");
            }
            Intent intent = new Intent(this.g.getApplicationContext(), NadPermissionActivity.class);
            intent.putExtra("request_code", 4099);
            intent.putExtra("permissions", new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE});
            h81.b().a(4099, new c(this));
            return intent;
        }
        return (Intent) invokeV.objValue;
    }

    public final Intent m() {
        InterceptResult invokeV;
        h91 h91Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("*/*");
            Intent l = l(i(), h(), n());
            l.putExtra("android.intent.extra.INTENT", intent);
            if (Build.VERSION.SDK_INT >= 21 && (h91Var = this.d) != null) {
                l.putExtra("android.intent.extra.INTENT", h91Var.a());
            }
            return l;
        }
        return (Intent) invokeV.objValue;
    }

    public Intent i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (l91.a(this.g) && l91.b(this.g)) {
                return j();
            }
            Intent intent = new Intent(this.g.getApplicationContext(), NadPermissionActivity.class);
            intent.putExtra("request_code", 4099);
            String[] strArr = {PermissionRequest.RESOURCE_VIDEO_CAPTURE, "android.permission.WRITE_EXTERNAL_STORAGE"};
            if (Build.VERSION.SDK_INT >= 29 && !Environment.isExternalStorageLegacy()) {
                strArr = new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE};
            }
            intent.putExtra("permissions", strArr);
            h81.b().a(4099, new b(this));
            return intent;
        }
        return (Intent) invokeV.objValue;
    }

    @SuppressLint({"NewApi", "ObsoleteSdkInt"})
    public final Intent j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            File externalFilesDir = rk0.b().getExternalFilesDir(Environment.DIRECTORY_DCIM);
            File file = new File(externalFilesDir.getAbsolutePath() + File.separator + "nad-browser-photos");
            file.mkdirs();
            this.b = file.getAbsolutePath() + File.separator + System.currentTimeMillis() + ".jpg";
            if (Build.VERSION.SDK_INT >= 24) {
                intent.putExtra("output", FileProvider.getUriForFile(rk0.b(), rk0.c().a().v(), new File(this.b)));
            } else {
                intent.putExtra("output", Uri.fromFile(new File(this.b)));
            }
            if (Build.VERSION.SDK_INT >= 19) {
                intent.setFlags(3);
            }
            return intent;
        }
        return (Intent) invokeV.objValue;
    }

    @RequiresApi(api = 21)
    @SuppressLint({"ObsoleteSdkInt"})
    public final Intent k() {
        InterceptResult invokeV;
        String[] strArr;
        String str;
        boolean z;
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            h91 h91Var = this.d;
            if (h91Var != null) {
                strArr = h91Var.b();
            } else {
                strArr = null;
            }
            String str2 = "*/*";
            if (strArr == null || strArr.length <= 0) {
                str = "*/*";
            } else {
                str = strArr[0];
            }
            if (str != null && !str.trim().isEmpty()) {
                str2 = str;
            }
            ArrayList arrayList = new ArrayList();
            h91 h91Var2 = this.d;
            if (h91Var2 != null && h91Var2.getMode() == 1) {
                z = true;
            } else {
                z = false;
            }
            if (str2.equals(BdUploadHandler.IMAGE_MIME_TYPE)) {
                arrayList.add(j());
            } else if (str2.equals(BdUploadHandler.VIDEO_MIME_TYPE)) {
                arrayList.add(new Intent("android.media.action.VIDEO_CAPTURE"));
            } else if (str2.equals(BdUploadHandler.AUDIO_MIME_TYPE)) {
                arrayList.add(n());
            }
            if (arrayList.isEmpty()) {
                arrayList.add(j());
                arrayList.add(h());
                arrayList.add(n());
            }
            if (str2.equals(BdUploadHandler.IMAGE_MIME_TYPE)) {
                intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, BdUploadHandler.IMAGE_MIME_TYPE);
                if (Build.VERSION.SDK_INT >= 18 && z) {
                    intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
                }
            } else {
                Intent intent2 = new Intent("android.intent.action.GET_CONTENT");
                if (Build.VERSION.SDK_INT >= 18 && z) {
                    intent2.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
                }
                intent2.setType(str2);
                intent = intent2;
            }
            Intent intent3 = new Intent("android.intent.action.CHOOSER");
            if (!arrayList.isEmpty()) {
                intent3.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new Intent[0]));
            }
            intent3.putExtra("android.intent.extra.INTENT", intent);
            return intent3;
        }
        return (Intent) invokeV.objValue;
    }

    public final Intent l(Intent... intentArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, intentArr)) == null) {
            Intent intent = new Intent("android.intent.action.CHOOSER");
            intent.putExtra("android.intent.extra.INITIAL_INTENTS", intentArr);
            intent.putExtra("android.intent.extra.TITLE", rk0.b().getResources().getString(R.string.nad_choose_upload));
            return intent;
        }
        return (Intent) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v2, resolved type: android.webkit.ValueCallback<android.net.Uri[]> */
    /* JADX WARN: Multi-variable type inference failed */
    public void p(int i, Intent intent) {
        Uri uri;
        Uri fromFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i, intent) == null) {
            if (this.h) {
                this.h = false;
                return;
            }
            if (i == -1 && intent == null && this.b == null) {
                i = 0;
            }
            if (i == 0 && this.f) {
                this.f = false;
                return;
            }
            if (intent != null && i == -1) {
                try {
                    uri = intent.getData();
                } catch (Throwable th) {
                    th.printStackTrace();
                    return;
                }
            } else {
                uri = null;
            }
            if (uri == null && intent == null && i == -1) {
                File file = new File(this.b);
                if (file.exists()) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        fromFile = FileProvider.getUriForFile(rk0.b(), rk0.c().a().v(), file);
                    } else {
                        fromFile = Uri.fromFile(file);
                    }
                    uri = fromFile;
                    rk0.b().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", uri));
                }
            }
            if (this.c != null) {
                ArrayList arrayList = new ArrayList();
                if (uri != null) {
                    arrayList.add(uri);
                } else if (intent != null && intent.getClipData() != null) {
                    ClipData clipData = intent.getClipData();
                    for (int i2 = 0; i2 < clipData.getItemCount(); i2++) {
                        arrayList.add(clipData.getItemAt(i2).getUri());
                    }
                }
                this.c.onReceiveValue(arrayList.toArray(new Uri[0]));
            }
            if (this.a != null) {
                this.a.onReceiveValue(uri);
            }
            this.e = true;
            this.f = false;
        }
    }

    @RequiresApi(api = 21)
    public boolean q(@NonNull ValueCallback<Uri[]> valueCallback, @NonNull h91 h91Var) {
        InterceptResult invokeLL;
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, valueCallback, h91Var)) == null) {
            this.c = valueCallback;
            this.d = h91Var;
            String[] b2 = h91Var.b();
            if (b2 != null && b2.length > 0) {
                str = b2[0];
            } else {
                str = "*/*";
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals(BdUploadHandler.IMAGE_MIME_TYPE)) {
                if (!l91.a(this.g)) {
                    arrayList.add(PermissionRequest.RESOURCE_VIDEO_CAPTURE);
                }
                if (Build.VERSION.SDK_INT >= 29 && !Environment.isExternalStorageLegacy()) {
                    z = false;
                } else {
                    z = true;
                }
                if (!l91.b(this.g) && z) {
                    arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
                }
            } else if (str.equals(BdUploadHandler.VIDEO_MIME_TYPE) && !l91.a(this.g)) {
                arrayList.add(PermissionRequest.RESOURCE_VIDEO_CAPTURE);
            }
            if (arrayList.isEmpty()) {
                if (!l91.a(this.g)) {
                    arrayList.add(PermissionRequest.RESOURCE_VIDEO_CAPTURE);
                }
                if (!l91.b(this.g)) {
                    arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
                }
            }
            if (arrayList.size() > 0) {
                requestPermissions(4099, (String[]) arrayList.toArray(new String[0]));
                return true;
            }
            try {
                return startActivityForResult(k(), 11);
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }
}

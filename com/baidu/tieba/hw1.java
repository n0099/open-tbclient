package com.baidu.tieba;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcher;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.net.URLConnection;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class hw1 extends wv1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.wv1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "File" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wv1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "FileApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes4.dex */
    public class a implements ActivityResultConsumer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ hw1 b;

        public a(hw1 hw1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hw1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hw1Var;
            this.a = str;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer
        public boolean consume(ActivityResultDispatcher activityResultDispatcher, int i, Intent intent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, activityResultDispatcher, i, intent)) == null) {
                this.b.d(this.a, new tz1(0));
                return true;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hw1(@NonNull uv1 uv1Var) {
        super(uv1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uv1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((uv1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final String x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            int lastIndexOf = str.lastIndexOf("/");
            if (lastIndexOf > 0) {
                String contentTypeFor = URLConnection.getFileNameMap().getContentTypeFor(str.substring(lastIndexOf + 1));
                if (!TextUtils.isEmpty(contentTypeFor)) {
                    return contentTypeFor;
                }
                return "*/*";
            }
            return "*/*";
        }
        return (String) invokeL.objValue;
    }

    public tz1 y(String str) {
        InterceptResult invokeL;
        Uri fromFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            q("#shareFile", false);
            if (n()) {
                t42.c("FileApi", "FileApi does not supported when app is invisible.");
                return new tz1(1001, "FileApi does not supported when app is invisible.");
            }
            Pair<tz1, JSONObject> s = s(str);
            tz1 tz1Var = (tz1) s.first;
            if (!tz1Var.isSuccess()) {
                return tz1Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String optString = jSONObject.optString("filePath");
            String M = bf3.M(optString, t73.g0());
            if (!TextUtils.isEmpty(optString) && bf3.s(optString) == PathType.BD_FILE && !TextUtils.isEmpty(M)) {
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    t42.c("FileApi", "cb is required");
                    return new tz1(202, "cb is required");
                }
                File file = new File(M);
                if (file.exists() && !file.isDirectory()) {
                    SwanAppActivity activity = gt2.U().getActivity();
                    if (activity == null) {
                        t42.c("FileApi", "activity null");
                        return new tz1(1001, "activity null");
                    }
                    ActivityResultDispatcher resultDispatcher = activity.getResultDispatcher();
                    Intent intent = new Intent();
                    if (ak3.i()) {
                        fromFile = ql3.a(activity, file);
                        intent.setFlags(3);
                    } else {
                        fromFile = Uri.fromFile(file);
                    }
                    intent.setAction("android.intent.action.SEND");
                    intent.putExtra("android.intent.extra.STREAM", fromFile);
                    intent.setType(x(M));
                    resultDispatcher.addConsumer(new a(this, optString2));
                    resultDispatcher.startActivityForResult(Intent.createChooser(intent, "分享到..."));
                    return tz1.f();
                }
                t42.c("FileApi", "file not exists");
                return new tz1(1001, "file not exists");
            }
            t42.c("FileApi", "a valid filePath is required");
            return new tz1(202, "a valid filePath is required");
        }
        return (tz1) invokeL.objValue;
    }
}

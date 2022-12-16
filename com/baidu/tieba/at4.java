package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
import tbclient.MultiForumPerm;
/* loaded from: classes3.dex */
public class at4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public int b;
    public boolean c;

    public at4() {
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

    public void a(JSONObject jSONObject) {
        boolean z;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        boolean z2 = false;
        if (jSONObject.optInt("is_bawu") == 1) {
            z = true;
        } else {
            z = false;
        }
        this.a = z;
        if ("manager".equals(jSONObject.optString("bawu_type"))) {
            i = 1;
        } else if (PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(jSONObject.optString("bawu_type"))) {
            i = 2;
        } else {
            i = 0;
        }
        this.b = i;
        if (jSONObject.optInt("is_deleted") == 1) {
            z2 = true;
        }
        this.c = z2;
    }

    public void b(MultiForumPerm multiForumPerm) {
        boolean z;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, multiForumPerm) != null) || multiForumPerm == null) {
            return;
        }
        boolean z2 = false;
        if (multiForumPerm.is_bawu.intValue() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.a = z;
        if ("manager".equals(multiForumPerm.bawu_type)) {
            i = 1;
        } else if (PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(multiForumPerm.bawu_type)) {
            i = 2;
        } else {
            i = 0;
        }
        this.b = i;
        if (multiForumPerm.is_deleted.intValue() == 1) {
            z2 = true;
        }
        this.c = z2;
    }
}

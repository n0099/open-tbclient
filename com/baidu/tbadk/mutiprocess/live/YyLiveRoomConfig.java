package com.baidu.tbadk.mutiprocess.live;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class YyLiveRoomConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_ROOM_ID = "room_id";
    public static final String KEY_SID = "sid";
    public static final String KEY_SOURCE = "source";
    public static final String KEY_SSID = "ssid";
    public static final String KEY_STREAMINFO = "streamInfo";
    public static final String KEY_TEMPLATE_ID = "template_Id";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YyLiveRoomConfig(@NonNull Context context, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @NonNull String str5, @NonNull String str6) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, str3, str4, str5, str6};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intent intent = getIntent();
        intent.putExtra("sid", str);
        intent.putExtra(KEY_SSID, str2);
        intent.putExtra(KEY_TEMPLATE_ID, str3);
        intent.putExtra("room_id", str4);
        intent.putExtra(KEY_STREAMINFO, str5);
        intent.putExtra("source", str6);
    }
}

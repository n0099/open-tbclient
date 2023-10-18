package com.baidu.tbadk.pay;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class YYPayData {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CHANNEL_MEDIA = 0;
    public static final int CHANNEL_YY_LIVE = 1;
    public static final int DIALOG_PAY_SCENE = 1;
    public static final int DIALOG_QUICK_PAY = 2;
    public static final int DIALOG_TARGET_PAY = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public int channel;
    public boolean closeOnSuccess;
    public Context context;
    public Long mAmount;
    public String mTitle;
    public int payScene;
    public IyyPayResultCallback yyPayResultCallback;

    public YYPayData(Context context, int i, String str, Long l, IyyPayResultCallback iyyPayResultCallback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), str, l, iyyPayResultCallback};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.closeOnSuccess = false;
        this.context = context;
        this.channel = i;
        this.mTitle = str;
        this.mAmount = l;
        this.yyPayResultCallback = iyyPayResultCallback;
    }
}

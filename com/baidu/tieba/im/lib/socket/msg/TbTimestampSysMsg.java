package com.baidu.tieba.im.lib.socket.msg;

import androidx.annotation.NonNull;
import com.baidu.tieba.ad;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class TbTimestampSysMsg extends TbSysMsg {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Calendar CALENDAR;
    public static final int MSG_TYPE = -7013;
    public transient /* synthetic */ FieldHolder $fh;
    public String timeShow;
    public long timestamp;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-129596414, "Lcom/baidu/tieba/im/lib/socket/msg/TbTimestampSysMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-129596414, "Lcom/baidu/tieba/im/lib/socket/msg/TbTimestampSysMsg;");
                return;
            }
        }
        CALENDAR = Calendar.getInstance(Locale.CHINA);
    }

    public TbTimestampSysMsg() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        setType(-7013);
    }

    public String getTimeShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.timeShow == null) {
                this.timeShow = getTimeShow(this.timestamp);
            }
            return this.timeShow;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public static TbTimestampSysMsg create(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65538, null, j)) == null) {
            TbTimestampSysMsg tbTimestampSysMsg = new TbTimestampSysMsg();
            tbTimestampSysMsg.setMsgId(j);
            tbTimestampSysMsg.setMsgKey(String.valueOf(j));
            tbTimestampSysMsg.timestamp = TimeUnit.MICROSECONDS.toMillis(j);
            return tbTimestampSysMsg;
        }
        return (TbTimestampSysMsg) invokeJ.objValue;
    }

    @NonNull
    private String getTimeShow(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65539, this, j)) == null) {
            Calendar calendar = Calendar.getInstance(Locale.CHINA);
            calendar.setTimeInMillis(j);
            if (CALENDAR.get(1) == calendar.get(1) && CALENDAR.get(6) == calendar.get(6)) {
                return ad.getDateStringHm(calendar.getTime());
            }
            return ad.getDateStringMdHm(calendar.getTime());
        }
        return (String) invokeJ.objValue;
    }
}

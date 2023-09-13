package com.baidu.tieba.im.db.pojo;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import protobuf.Media;
/* loaded from: classes6.dex */
public class MediaPojo extends OrmObject {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String bigPic;
    public String bsize;
    public int duringTime;
    public String dynamicPic;
    public int eType;
    public int height;
    public double hthMidLoc;
    public int isBlockedPic;
    public int isLongPic;
    public String originPic;
    public int originSize;
    public long postId;
    public int showOriginalBtn;
    public String smallPic;
    public String srcPic;
    public String text;
    public int type;
    public String vhsrc;
    public String vpic;
    public String vsrc;
    public String waterPic;
    public int width;
    public double wthMidLoc;

    public MediaPojo() {
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

    public String M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.srcPic;
        }
        return (String) invokeV.objValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.type;
        }
        return invokeV.intValue;
    }

    public void N(Media media) {
        int intValue;
        int intValue2;
        int intValue3;
        int intValue4;
        int intValue5;
        long longValue;
        int intValue6;
        int intValue7;
        double doubleValue;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, media) != null) || media == null) {
            return;
        }
        this.type = media.type.intValue();
        this.smallPic = media.smallPic;
        this.bigPic = media.bigPic;
        this.waterPic = media.waterPic;
        this.vpic = media.vpic;
        this.vsrc = media.vsrc;
        this.vhsrc = media.vhsrc;
        this.srcPic = media.srcPic;
        this.text = media.text;
        Integer num = media.width;
        int i = 0;
        if (num == null) {
            intValue = 0;
        } else {
            intValue = num.intValue();
        }
        this.width = intValue;
        Integer num2 = media.height;
        if (num2 == null) {
            intValue2 = 0;
        } else {
            intValue2 = num2.intValue();
        }
        this.height = intValue2;
        this.bsize = media.bsize;
        Integer num3 = media.duringTime;
        if (num3 == null) {
            intValue3 = 0;
        } else {
            intValue3 = num3.intValue();
        }
        this.duringTime = intValue3;
        Integer num4 = media.eType;
        if (num4 == null) {
            intValue4 = 0;
        } else {
            intValue4 = num4.intValue();
        }
        this.eType = intValue4;
        this.originPic = media.originPic;
        Integer num5 = media.originSize;
        if (num5 == null) {
            intValue5 = 0;
        } else {
            intValue5 = num5.intValue();
        }
        this.originSize = intValue5;
        Long l = media.postId;
        if (l == null) {
            longValue = 0;
        } else {
            longValue = l.longValue();
        }
        this.postId = longValue;
        this.dynamicPic = media.dynamicPic;
        Integer num6 = media.isLongPic;
        if (num6 == null) {
            intValue6 = 0;
        } else {
            intValue6 = num6.intValue();
        }
        this.isLongPic = intValue6;
        Integer num7 = media.showOriginalBtn;
        if (num7 == null) {
            intValue7 = 0;
        } else {
            intValue7 = num7.intValue();
        }
        this.showOriginalBtn = intValue7;
        Integer num8 = media.isBlockedPic;
        if (num8 != null) {
            i = num8.intValue();
        }
        this.isBlockedPic = i;
        Double d = media.wthMidLoc;
        double d2 = 0.0d;
        if (d == null) {
            doubleValue = 0.0d;
        } else {
            doubleValue = d.doubleValue();
        }
        this.wthMidLoc = doubleValue;
        Double d3 = media.hthMidLoc;
        if (d3 != null) {
            d2 = d3.doubleValue();
        }
        this.hthMidLoc = d2;
    }
}

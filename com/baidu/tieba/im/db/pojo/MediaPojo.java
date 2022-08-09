package com.baidu.tieba.im.db.pojo;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import protobuf.Media;
/* loaded from: classes3.dex */
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

    public void A(Media media) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, media) == null) || media == null) {
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
        this.width = media.width.intValue();
        this.height = media.height.intValue();
        this.bsize = media.bsize;
        this.duringTime = media.duringTime.intValue();
        this.eType = media.eType.intValue();
        this.originPic = media.originPic;
        this.originSize = media.originSize.intValue();
        this.postId = media.postId.longValue();
        this.dynamicPic = media.dynamicPic;
        this.isLongPic = media.isLongPic.intValue();
        this.showOriginalBtn = media.showOriginalBtn.intValue();
        this.isBlockedPic = media.isBlockedPic.intValue();
        this.wthMidLoc = media.wthMidLoc.doubleValue();
        this.hthMidLoc = media.hthMidLoc.doubleValue();
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.type : invokeV.intValue;
    }

    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.srcPic : (String) invokeV.objValue;
    }
}

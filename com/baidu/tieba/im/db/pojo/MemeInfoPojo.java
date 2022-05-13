package com.baidu.tieba.im.db.pojo;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import protobuf.MemeInfo;
/* loaded from: classes3.dex */
public class MemeInfoPojo extends OrmObject {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String detailLink;
    public Integer height;
    public Integer pckId;
    public Long picId;
    public String picUrl;
    public String thumbnail;
    public Integer width;

    public MemeInfoPojo() {
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

    public static MemeInfoPojo y(MemeInfo memeInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, memeInfo)) == null) {
            if (memeInfo == null) {
                return null;
            }
            MemeInfoPojo memeInfoPojo = new MemeInfoPojo();
            memeInfoPojo.picId = memeInfo.picId;
            memeInfoPojo.pckId = memeInfo.pckId;
            memeInfoPojo.picUrl = memeInfo.picUrl;
            memeInfoPojo.thumbnail = memeInfo.thumbnail;
            memeInfoPojo.width = memeInfo.width;
            memeInfoPojo.height = memeInfo.height;
            memeInfoPojo.detailLink = memeInfo.detailLink;
            return memeInfoPojo;
        }
        return (MemeInfoPojo) invokeL.objValue;
    }

    public static MemeInfoPojo z(tbclient.MemeInfo memeInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, memeInfo)) == null) {
            if (memeInfo == null) {
                return null;
            }
            MemeInfoPojo memeInfoPojo = new MemeInfoPojo();
            memeInfoPojo.picId = memeInfo.pic_id;
            memeInfoPojo.pckId = memeInfo.pck_id;
            memeInfoPojo.picUrl = memeInfo.pic_url;
            memeInfoPojo.thumbnail = memeInfo.thumbnail;
            memeInfoPojo.width = memeInfo.width;
            memeInfoPojo.height = memeInfo.height;
            memeInfoPojo.detailLink = memeInfo.detail_link;
            return memeInfoPojo;
        }
        return (MemeInfoPojo) invokeL.objValue;
    }
}

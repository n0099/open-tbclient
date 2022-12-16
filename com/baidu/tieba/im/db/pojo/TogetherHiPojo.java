package com.baidu.tieba.im.db.pojo;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import protobuf.TogetherHi;
/* loaded from: classes4.dex */
public class TogetherHiPojo extends OrmObject {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Long albumId;
    public String albumName;
    public Integer endTime;
    public String location;
    public Integer numJoin;
    public Integer numSignup;
    public List<String> picUrls;
    public List<String> potraits;
    public Integer startTime;

    public TogetherHiPojo() {
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

    public static TogetherHiPojo G(TogetherHi togetherHi) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, togetherHi)) == null) {
            if (togetherHi == null) {
                return null;
            }
            TogetherHiPojo togetherHiPojo = new TogetherHiPojo();
            togetherHiPojo.albumName = togetherHi.albumName;
            togetherHiPojo.albumId = togetherHi.albumId;
            togetherHiPojo.startTime = togetherHi.startTime;
            togetherHiPojo.endTime = togetherHi.endTime;
            togetherHiPojo.location = togetherHi.location;
            togetherHiPojo.numSignup = togetherHi.numSignup;
            togetherHiPojo.potraits = togetherHi.potraits;
            togetherHiPojo.numJoin = togetherHi.numJoin;
            togetherHiPojo.picUrls = togetherHi.picUrls;
            return togetherHiPojo;
        }
        return (TogetherHiPojo) invokeL.objValue;
    }

    public static TogetherHiPojo H(tbclient.TogetherHi togetherHi) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, togetherHi)) == null) {
            if (togetherHi == null) {
                return null;
            }
            TogetherHiPojo togetherHiPojo = new TogetherHiPojo();
            togetherHiPojo.albumName = togetherHi.album_name;
            togetherHiPojo.albumId = togetherHi.album_id;
            togetherHiPojo.startTime = togetherHi.start_time;
            togetherHiPojo.endTime = togetherHi.end_time;
            togetherHiPojo.location = togetherHi.location;
            togetherHiPojo.numSignup = togetherHi.num_signup;
            togetherHiPojo.potraits = togetherHi.potraits;
            togetherHiPojo.numJoin = togetherHi.num_join;
            togetherHiPojo.picUrls = togetherHi.pic_urls;
            return togetherHiPojo;
        }
        return (TogetherHiPojo) invokeL.objValue;
    }
}

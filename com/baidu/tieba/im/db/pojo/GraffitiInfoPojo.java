package com.baidu.tieba.im.db.pojo;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import protobuf.GraffitiInfo;
/* loaded from: classes3.dex */
public class GraffitiInfoPojo extends OrmObject {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Long gid;
    public String url;

    public GraffitiInfoPojo() {
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

    public static GraffitiInfoPojo A(GraffitiInfo graffitiInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, graffitiInfo)) == null) {
            if (graffitiInfo == null) {
                return null;
            }
            GraffitiInfoPojo graffitiInfoPojo = new GraffitiInfoPojo();
            graffitiInfoPojo.url = graffitiInfo.url;
            graffitiInfoPojo.gid = graffitiInfo.gid;
            return graffitiInfoPojo;
        }
        return (GraffitiInfoPojo) invokeL.objValue;
    }

    public static GraffitiInfoPojo B(tbclient.GraffitiInfo graffitiInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, graffitiInfo)) == null) {
            if (graffitiInfo == null) {
                return null;
            }
            GraffitiInfoPojo graffitiInfoPojo = new GraffitiInfoPojo();
            graffitiInfoPojo.url = graffitiInfo.url;
            graffitiInfoPojo.gid = graffitiInfo.gid;
            return graffitiInfoPojo;
        }
        return (GraffitiInfoPojo) invokeL.objValue;
    }
}

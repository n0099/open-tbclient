package com.baidu.tieba.im.db.pojo;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import protobuf.ApkDetail;
/* loaded from: classes4.dex */
public class ApkDetailPojo extends OrmObject {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String authorityUrl;
    public String developer;
    public Integer needInnerBuy;
    public Integer needNetwork;
    public Integer pkgSource;
    public String privacyUrl;
    public String publisher;
    public String size;
    public String updateTime;
    public String version;
    public Integer versionCode;

    public ApkDetailPojo() {
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

    public static ApkDetailPojo R(ApkDetail apkDetail) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, apkDetail)) == null) {
            if (apkDetail == null) {
                return null;
            }
            ApkDetailPojo apkDetailPojo = new ApkDetailPojo();
            apkDetailPojo.developer = apkDetail.developer;
            apkDetailPojo.publisher = apkDetail.publisher;
            apkDetailPojo.version = apkDetail.version;
            apkDetailPojo.versionCode = apkDetail.versionCode;
            apkDetailPojo.updateTime = apkDetail.updateTime;
            apkDetailPojo.size = apkDetail.size;
            apkDetailPojo.needNetwork = apkDetail.needNetwork;
            apkDetailPojo.needInnerBuy = apkDetail.needInnerBuy;
            apkDetailPojo.authorityUrl = apkDetail.authorityUrl;
            apkDetailPojo.privacyUrl = apkDetail.privacyUrl;
            apkDetailPojo.pkgSource = apkDetail.pkgSource;
            return apkDetailPojo;
        }
        return (ApkDetailPojo) invokeL.objValue;
    }

    public static ApkDetailPojo S(tbclient.ApkDetail apkDetail) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, apkDetail)) == null) {
            if (apkDetail == null) {
                return null;
            }
            ApkDetailPojo apkDetailPojo = new ApkDetailPojo();
            apkDetailPojo.developer = apkDetail.developer;
            apkDetailPojo.publisher = apkDetail.publisher;
            apkDetailPojo.version = apkDetail.version;
            apkDetailPojo.versionCode = apkDetail.version_code;
            apkDetailPojo.updateTime = apkDetail.update_time;
            apkDetailPojo.size = apkDetail.size;
            apkDetailPojo.needNetwork = apkDetail.need_network;
            apkDetailPojo.needInnerBuy = apkDetail.need_inner_buy;
            apkDetailPojo.authorityUrl = apkDetail.authority_url;
            apkDetailPojo.privacyUrl = apkDetail.privacy_url;
            apkDetailPojo.pkgSource = apkDetail.pkg_source;
            return apkDetailPojo;
        }
        return (ApkDetailPojo) invokeL.objValue;
    }
}

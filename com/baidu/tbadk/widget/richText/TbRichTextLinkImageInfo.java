package com.baidu.tbadk.widget.richText;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.core.Domains;
import tbclient.PbContent;
/* loaded from: classes6.dex */
public class TbRichTextLinkImageInfo extends OrmObject {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f48740e;

    /* renamed from: f  reason: collision with root package name */
    public int f48741f;

    /* renamed from: g  reason: collision with root package name */
    public String f48742g;

    /* renamed from: h  reason: collision with root package name */
    public String f48743h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f48744i;

    public TbRichTextLinkImageInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f48740e = 1;
        this.f48741f = 1;
        this.f48742g = null;
        this.f48743h = null;
        this.f48744i = true;
    }

    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f48741f : invokeV.intValue;
    }

    public String getLink() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f48743h : (String) invokeV.objValue;
    }

    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f48740e : invokeV.intValue;
    }

    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f48742g : (String) invokeV.objValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f48744i : invokeV.booleanValue;
    }

    public TbRichTextLinkImageInfo(PbContent pbContent) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbContent};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f48740e = 1;
        this.f48741f = 1;
        this.f48742g = null;
        this.f48743h = null;
        this.f48744i = true;
        this.f48742g = pbContent.cdn_src;
        this.f48743h = pbContent.link;
        String str = pbContent.bsize;
        if (str != null) {
            try {
                String[] split = str.split(",");
                this.f48740e = Integer.valueOf(split[0]).intValue();
                this.f48741f = Integer.valueOf(split[1]).intValue();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f48740e <= 0) {
            this.f48740e = 1;
        }
        if (this.f48741f <= 0) {
            this.f48741f = 1;
        }
        String str2 = this.f48742g;
        if (str2 != null) {
            str2.indexOf(Domains.BAIDU);
        }
    }
}

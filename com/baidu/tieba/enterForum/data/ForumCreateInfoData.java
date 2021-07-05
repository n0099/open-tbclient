package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ForumCreateInfo;
/* loaded from: classes5.dex */
public class ForumCreateInfoData extends OrmObject {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f14608e;

    /* renamed from: f  reason: collision with root package name */
    public int f14609f;

    /* renamed from: g  reason: collision with root package name */
    public int f14610g;

    /* renamed from: h  reason: collision with root package name */
    public String f14611h;

    public ForumCreateInfoData() {
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
        this.f14608e = 0;
        this.f14609f = 0;
        this.f14610g = 0;
        this.f14611h = null;
    }

    public void A(ForumCreateInfo forumCreateInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, forumCreateInfo) == null) || forumCreateInfo == null) {
            return;
        }
        this.f14608e = forumCreateInfo.is_show_create.intValue();
        this.f14609f = forumCreateInfo.is_can_create.intValue();
        this.f14610g = forumCreateInfo.can_create_errno.intValue();
        this.f14611h = forumCreateInfo.can_create_errdata;
    }

    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f14611h : (String) invokeV.objValue;
    }

    public int x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f14610g : invokeV.intValue;
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f14609f != 0 : invokeV.booleanValue;
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f14608e != 0 : invokeV.booleanValue;
    }
}

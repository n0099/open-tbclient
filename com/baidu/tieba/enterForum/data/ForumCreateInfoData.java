package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ForumCreateInfo;
/* loaded from: classes7.dex */
public class ForumCreateInfoData extends OrmObject {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f49980e;

    /* renamed from: f  reason: collision with root package name */
    public int f49981f;

    /* renamed from: g  reason: collision with root package name */
    public int f49982g;

    /* renamed from: h  reason: collision with root package name */
    public String f49983h;

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
        this.f49980e = 0;
        this.f49981f = 0;
        this.f49982g = 0;
        this.f49983h = null;
    }

    public void A(ForumCreateInfo forumCreateInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, forumCreateInfo) == null) || forumCreateInfo == null) {
            return;
        }
        this.f49980e = forumCreateInfo.is_show_create.intValue();
        this.f49981f = forumCreateInfo.is_can_create.intValue();
        this.f49982g = forumCreateInfo.can_create_errno.intValue();
        this.f49983h = forumCreateInfo.can_create_errdata;
    }

    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f49983h : (String) invokeV.objValue;
    }

    public int x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f49982g : invokeV.intValue;
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f49981f != 0 : invokeV.booleanValue;
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f49980e != 0 : invokeV.booleanValue;
    }
}

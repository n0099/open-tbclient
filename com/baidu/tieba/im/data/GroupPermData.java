package com.baidu.tieba.im.data;

import androidx.core.view.InputDeviceCompat;
import c.a.d.m.e.n;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes10.dex */
public class GroupPermData implements n, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MANAGER = 1;
    public static final int NORMAL = 1;
    public static final int OFFICIAL = 1;
    public static final int PERSONAL = 1;
    public static final BdUniqueId TYPE_FRS_CREATE_GROUP;
    public static final long serialVersionUID = 5660832418912851013L;
    public transient /* synthetic */ FieldHolder $fh;
    public int canCreateNormal;
    public int canCreateNormalNum;
    public int canCreateOfficial;
    public int canCreateOfficialNum;
    public int canCreatePersonal;
    public int canCreatePersonalNum;
    public String createNormalTip;
    public String createOfficialTip;
    public String createPersonalTip;
    public String forumId;
    public int isManager;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1779566602, "Lcom/baidu/tieba/im/data/GroupPermData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1779566602, "Lcom/baidu/tieba/im/data/GroupPermData;");
                return;
            }
        }
        TYPE_FRS_CREATE_GROUP = BdUniqueId.gen();
    }

    public GroupPermData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public int getCanCreateNormal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.canCreateNormal : invokeV.intValue;
    }

    public int getCanCreateNormalNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.canCreateNormalNum : invokeV.intValue;
    }

    public int getCanCreateOfficial() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.canCreateOfficial : invokeV.intValue;
    }

    public int getCanCreateOfficialNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.canCreateOfficialNum : invokeV.intValue;
    }

    public int getCanCreatePersonalNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.canCreatePersonalNum : invokeV.intValue;
    }

    public String getCreateNormalTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.createNormalTip : (String) invokeV.objValue;
    }

    public String getCreateOfficialTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.createOfficialTip : (String) invokeV.objValue;
    }

    public String getCreatePersonalTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.createPersonalTip : (String) invokeV.objValue;
    }

    public String getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.forumId : (String) invokeV.objValue;
    }

    public int getIsManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.isManager : invokeV.intValue;
    }

    @Override // c.a.d.m.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? TYPE_FRS_CREATE_GROUP : (BdUniqueId) invokeV.objValue;
    }

    public boolean isCreateNormal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.canCreateNormal == 1 : invokeV.booleanValue;
    }

    public boolean isCreateOfficial() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.canCreateOfficial == 1 : invokeV.booleanValue;
    }

    public boolean isCreatePersonal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.canCreatePersonal == 1 : invokeV.booleanValue;
    }

    public boolean isManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.isManager == 1 : invokeV.booleanValue;
    }

    public void setCanCreateNormal(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.canCreateNormal = i2;
        }
    }

    public void setCanCreateNormalNum(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.canCreateNormalNum = i2;
        }
    }

    public void setCanCreateOfficial(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.canCreateOfficial = i2;
        }
    }

    public void setCanCreateOfficialNum(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.canCreateOfficialNum = i2;
        }
    }

    public void setCanCreatePersonal(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.canCreatePersonal = i2;
        }
    }

    public void setCanCreatePersonalNum(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.canCreatePersonalNum = i2;
        }
    }

    public void setCreateNormalTip(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.createNormalTip = str;
        }
    }

    public void setCreateOfficialTip(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.createOfficialTip = str;
        }
    }

    public void setCreatePersonalTip(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.createPersonalTip = str;
        }
    }

    public void setForumId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.forumId = str;
        }
    }

    public void setIsManager(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            this.isManager = i2;
        }
    }
}

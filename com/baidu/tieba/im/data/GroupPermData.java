package com.baidu.tieba.im.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.wn;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes4.dex */
public class GroupPermData implements wn, Serializable {
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public int getCanCreateNormal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.canCreateNormal;
        }
        return invokeV.intValue;
    }

    public int getCanCreateNormalNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.canCreateNormalNum;
        }
        return invokeV.intValue;
    }

    public int getCanCreateOfficial() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.canCreateOfficial;
        }
        return invokeV.intValue;
    }

    public int getCanCreateOfficialNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.canCreateOfficialNum;
        }
        return invokeV.intValue;
    }

    public int getCanCreatePersonalNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.canCreatePersonalNum;
        }
        return invokeV.intValue;
    }

    public String getCreateNormalTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.createNormalTip;
        }
        return (String) invokeV.objValue;
    }

    public String getCreateOfficialTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.createOfficialTip;
        }
        return (String) invokeV.objValue;
    }

    public String getCreatePersonalTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.createPersonalTip;
        }
        return (String) invokeV.objValue;
    }

    public String getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.forumId;
        }
        return (String) invokeV.objValue;
    }

    public int getIsManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.isManager;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.wn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return TYPE_FRS_CREATE_GROUP;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public boolean isCreateNormal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.canCreateNormal == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isCreateOfficial() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.canCreateOfficial == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isCreatePersonal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.canCreatePersonal == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.isManager == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void setCanCreateNormal(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.canCreateNormal = i;
        }
    }

    public void setCanCreateNormalNum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.canCreateNormalNum = i;
        }
    }

    public void setCanCreateOfficial(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.canCreateOfficial = i;
        }
    }

    public void setCanCreateOfficialNum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.canCreateOfficialNum = i;
        }
    }

    public void setCanCreatePersonal(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.canCreatePersonal = i;
        }
    }

    public void setCanCreatePersonalNum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.canCreatePersonalNum = i;
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

    public void setIsManager(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            this.isManager = i;
        }
    }
}

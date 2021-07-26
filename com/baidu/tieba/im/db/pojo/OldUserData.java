package com.baidu.tieba.im.db.pojo;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.AbstractImageProvider;
import com.baidu.tbadk.data.IconData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.k;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class OldUserData extends AbstractImageProvider implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -4483304441506804594L;
    public transient /* synthetic */ FieldHolder $fh;
    public long id;
    public long inTime;
    public long lastReplyTime;
    public String lat;
    public String lng;
    public long loginTime;
    public ArrayList<IconData> mTShowIconInfo;
    public String name;
    public Permission permission;
    public String portrait;
    public String position;
    public int sex;
    public long userId;
    public String userName;

    /* loaded from: classes4.dex */
    public static class Permission extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int TRUE = 1;
        public static final long serialVersionUID = -661968182172681650L;
        public transient /* synthetic */ FieldHolder $fh;
        public int isGroupManager;
        public int isGroupOwner;

        public Permission() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public boolean getIsGroupManager() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.isGroupManager == 1 : invokeV.booleanValue;
        }

        public boolean getIsGroupOwner() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.isGroupOwner == 1 : invokeV.booleanValue;
        }

        public boolean isController() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? getIsGroupManager() || getIsGroupOwner() : invokeV.booleanValue;
        }

        public void setIsGroupManager(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
                this.isGroupManager = i2;
            }
        }

        public void setIsGroupOwner(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
                this.isGroupOwner = i2;
            }
        }
    }

    public OldUserData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public long getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.id : invokeV.longValue;
    }

    public long getInTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.inTime : invokeV.longValue;
    }

    public long getLastReplyTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.lastReplyTime : invokeV.longValue;
    }

    public String getLat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.lat : (String) invokeV.objValue;
    }

    public String getLng() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.lng : (String) invokeV.objValue;
    }

    public long getLoginTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.loginTime : invokeV.longValue;
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.name : (String) invokeV.objValue;
    }

    public Permission getPermission() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.permission : (Permission) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.util.AbstractImageProvider, com.baidu.tbadk.core.util.ImageProvider
    public ArrayList<String> getPhotoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(this.portrait);
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public String getPortrait() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.portrait : (String) invokeV.objValue;
    }

    public String getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.position : (String) invokeV.objValue;
    }

    public int getSex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.sex : invokeV.intValue;
    }

    public ArrayList<IconData> getTShowInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mTShowIconInfo : (ArrayList) invokeV.objValue;
    }

    public long getUserId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.userId : invokeV.longValue;
    }

    public String getUserName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.userName : (String) invokeV.objValue;
    }

    public void setId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048591, this, j) == null) {
            this.id = j;
        }
    }

    public void setInTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048592, this, j) == null) {
            this.inTime = j;
        }
    }

    public void setLastReplyTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048593, this, j) == null) {
            this.lastReplyTime = j;
        }
    }

    public void setLat(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.lat = str;
        }
    }

    public void setLng(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.lng = str;
        }
    }

    public void setLoginTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048596, this, j) == null) {
            this.loginTime = j;
        }
    }

    public void setName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.name = str;
        }
    }

    public void setPermission(Permission permission) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, permission) == null) {
            this.permission = permission;
        }
    }

    public void setPortrait(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.portrait = str;
        }
    }

    public void setPosition(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.position = str;
        }
    }

    public void setSex(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            this.sex = i2;
        }
    }

    public void setTShowInfo(ArrayList<IconData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, arrayList) == null) {
            this.mTShowIconInfo = arrayList;
        }
    }

    public void setToUserData(UserData userData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, userData) == null) || userData == null) {
            return;
        }
        userData.setUserIdLong(Math.max(this.id, this.userId));
        userData.setUserName((k.isEmpty(this.userName) || StringUtil.NULL_STRING.equalsIgnoreCase(this.userName)) ? this.name : this.userName);
        userData.setPortrait(this.portrait);
        userData.setSex(this.sex);
        userData.setPosition(this.position);
        userData.setLat(this.lat);
        userData.setLng(this.lng);
        userData.setInTime(this.inTime);
        userData.setLoginTime(this.loginTime);
        userData.setLastReplyTime(this.lastReplyTime);
        userData.setTShowInfo(this.mTShowIconInfo);
    }

    public void setUserId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048604, this, j) == null) {
            this.userId = j;
        }
    }

    public void setUserName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            this.userName = str;
        }
    }
}

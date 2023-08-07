package com.baidu.tieba.im.data;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class GameMatchUser {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String avatar;
    public boolean isFree;
    public int pos;
    public String showName;
    public String userId;

    public GameMatchUser() {
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

    private boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            if (!TextUtils.isEmpty(this.userId) && !TextUtils.isEmpty(this.showName) && !TextUtils.isEmpty(this.avatar)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String getAvatar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.avatar;
        }
        return (String) invokeV.objValue;
    }

    public int getPos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.pos;
        }
        return invokeV.intValue;
    }

    public String getShowName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.showName;
        }
        return (String) invokeV.objValue;
    }

    public String getUserId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.userId;
        }
        return (String) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            String str = this.userId;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean isFree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.isFree;
        }
        return invokeV.booleanValue;
    }

    public static GameMatchUser parserFlutterData(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, obj)) == null) {
            if (obj instanceof Map) {
                Map map = (Map) obj;
                GameMatchUser gameMatchUser = new GameMatchUser();
                try {
                    gameMatchUser.userId = (String) map.get("user_id");
                    gameMatchUser.showName = (String) map.get("username");
                    gameMatchUser.avatar = (String) map.get("avatar");
                    gameMatchUser.isFree = ((Boolean) map.get("is_free")).booleanValue();
                    gameMatchUser.pos = ((Integer) map.get("pos")).intValue();
                } catch (Exception unused) {
                    Log.d("GameMatchUser", "Flutter Data Parser Error!");
                }
                if (gameMatchUser.isValid()) {
                    return gameMatchUser;
                }
                return null;
            }
            return null;
        }
        return (GameMatchUser) invokeL.objValue;
    }

    @NonNull
    public static List<GameMatchUser> parserFlutterList(HashMap hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, hashMap)) == null) {
            ArrayList arrayList = new ArrayList();
            Object obj = hashMap.get("imUserList");
            if (obj instanceof List) {
                int i = 0;
                while (true) {
                    List list = (List) obj;
                    if (i >= list.size()) {
                        break;
                    }
                    GameMatchUser parserFlutterData = parserFlutterData(list.get(i));
                    if (parserFlutterData != null) {
                        arrayList.add(parserFlutterData);
                    }
                    i++;
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || GameMatchUser.class != obj.getClass()) {
                return false;
            }
            String str = this.userId;
            String str2 = ((GameMatchUser) obj).userId;
            if (str != null) {
                return str.equals(str2);
            }
            if (str2 == null) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return "GameMatchUser{userId='" + this.userId + "', showName='" + this.showName + "', avatar='" + this.avatar + "', isFree='" + this.isFree + "', pos='" + this.pos + "'}";
        }
        return (String) invokeV.objValue;
    }
}

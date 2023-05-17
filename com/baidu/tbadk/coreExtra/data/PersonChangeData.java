package com.baidu.tbadk.coreExtra.data;

import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.data.SelectForumData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class PersonChangeData extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG_PERSON_INFO = "person_change_data";
    public static final long serialVersionUID = 4345761658406426272L;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean canModifyAvatar;
    public String cantModifyAvatarDesc;
    public String isBusinessAccount;
    public int isMem;
    public boolean isNickNameInVerifying;
    public long mAlaId;
    public int mBirthdayShowStatus;
    public long mBirthdayTime;
    public String mForumAge;
    public transient ArrayList<SelectForumData> mInterestedForums;
    public String mIntro;
    public String mName;
    public String mNameShow;
    public int mNickNameLeftDays;
    public boolean mPhotoChanged;
    public String mPortrait;
    public int mSex;
    public String mTiebaId;
    public int mUserAge;
    public String nickNameInVerifying;
    public String tempNickName;
    public String userId;

    @Keep
    /* loaded from: classes4.dex */
    public class Forum {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String fid;
        public String fname;
        public final /* synthetic */ PersonChangeData this$0;

        public Forum(PersonChangeData personChangeData, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeData, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = personChangeData;
            this.fid = str;
            this.fname = str2;
        }
    }

    public PersonChangeData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mForumAge = "0.1";
        this.isNickNameInVerifying = false;
        this.mIntro = null;
        this.mSex = 0;
        this.mName = null;
        this.mPortrait = null;
        this.mPhotoChanged = false;
        this.mNameShow = null;
        this.mNickNameLeftDays = -1;
        this.isMem = 0;
        this.canModifyAvatar = true;
    }

    public void addInterestForums(SelectForumData selectForumData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, selectForumData) != null) || selectForumData == null) {
            return;
        }
        if (this.mInterestedForums == null) {
            this.mInterestedForums = new ArrayList<>();
        }
        this.mInterestedForums.add(selectForumData);
    }

    public void setAlaId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048598, this, j) == null) {
            this.mAlaId = j;
        }
    }

    public void setBirthdayShowStatus(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            this.mBirthdayShowStatus = i;
        }
    }

    public void setBirthdayTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048600, this, j) == null) {
            this.mBirthdayTime = j;
        }
    }

    public void setCanModifyAvatar(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.canModifyAvatar = z;
        }
    }

    public void setCantModifyAvatarDesc(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.cantModifyAvatarDesc = str;
        }
    }

    public void setForumAge(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.mForumAge = str;
        }
    }

    public void setInterestForums(ArrayList<SelectForumData> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048604, this, arrayList) != null) || ListUtils.isEmpty(arrayList)) {
            return;
        }
        ArrayList<SelectForumData> arrayList2 = this.mInterestedForums;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
        for (int i = 0; i < arrayList.size(); i++) {
            addInterestForums(arrayList.get(i));
        }
    }

    public void setIntro(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            this.mIntro = str;
        }
    }

    public void setIsBusinessAccount(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            this.isBusinessAccount = str;
        }
    }

    public void setMem(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            this.isMem = i;
        }
    }

    public void setName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
            this.mName = str;
        }
    }

    public void setNameShow(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
            this.mNameShow = str;
        }
    }

    public void setNickNameLeftDays(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i) == null) {
            this.mNickNameLeftDays = i;
        }
    }

    public void setPhotoChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            this.mPhotoChanged = z;
        }
    }

    public void setPortrait(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            this.mPortrait = str;
        }
    }

    public void setSex(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i) == null) {
            this.mSex = i;
        }
    }

    public void setTempNickName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, str) == null) {
            this.tempNickName = str;
        }
    }

    public void setTiebaId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, str) == null) {
            this.mTiebaId = str;
        }
    }

    public void setUserAge(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i) == null) {
            this.mUserAge = i;
        }
    }

    public void setUserId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, str) == null) {
            this.userId = str;
        }
    }

    public boolean canModifyAvatar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.canModifyAvatar;
        }
        return invokeV.booleanValue;
    }

    public long getAlaId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mAlaId;
        }
        return invokeV.longValue;
    }

    public int getBirthdayShowStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mBirthdayShowStatus;
        }
        return invokeV.intValue;
    }

    public long getBirthdayTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mBirthdayTime;
        }
        return invokeV.longValue;
    }

    public String getCantModifyAvatarDesc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.cantModifyAvatarDesc;
        }
        return (String) invokeV.objValue;
    }

    public String getForumAge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mForumAge;
        }
        return (String) invokeV.objValue;
    }

    public ArrayList<SelectForumData> getInterestedForums() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mInterestedForums;
        }
        return (ArrayList) invokeV.objValue;
    }

    public String getIntro() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mIntro;
        }
        return (String) invokeV.objValue;
    }

    public String getIsBusinessAccount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.isBusinessAccount;
        }
        return (String) invokeV.objValue;
    }

    public int getMen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.isMem;
        }
        return invokeV.intValue;
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mName;
        }
        return (String) invokeV.objValue;
    }

    public String getNameShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.mNameShow;
        }
        return (String) invokeV.objValue;
    }

    public int getNickNameLeftDays() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.mNickNameLeftDays;
        }
        return invokeV.intValue;
    }

    public boolean getPhotoChanged() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.mPhotoChanged;
        }
        return invokeV.booleanValue;
    }

    public String getPortrait() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.mPortrait;
        }
        return (String) invokeV.objValue;
    }

    public int getSex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.mSex;
        }
        return invokeV.intValue;
    }

    public String getTempNickName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.tempNickName;
        }
        return (String) invokeV.objValue;
    }

    public int getUserAge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.mUserAge;
        }
        return invokeV.intValue;
    }

    public String getUserId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.userId;
        }
        return (String) invokeV.objValue;
    }

    public String getmTiebaId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.mTiebaId;
        }
        return (String) invokeV.objValue;
    }

    public String getInterestedForumsJsonString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ArrayList arrayList = new ArrayList();
            if (!ListUtils.isEmpty(this.mInterestedForums)) {
                for (int i = 0; i < this.mInterestedForums.size(); i++) {
                    SelectForumData selectForumData = this.mInterestedForums.get(i);
                    if (selectForumData != null) {
                        arrayList.add(new Forum(this, selectForumData.forumId, selectForumData.forumName));
                    }
                }
            }
            return new Gson().toJson(arrayList);
        }
        return (String) invokeV.objValue;
    }
}

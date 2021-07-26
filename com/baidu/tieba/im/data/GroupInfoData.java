package com.baidu.tieba.im.data;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.AbstractImageProvider;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.PreLoadImageProvider;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.k.e.n;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class GroupInfoData extends AbstractImageProvider implements n, Serializable, PreLoadImageProvider {
    public static /* synthetic */ Interceptable $ic = null;
    public static final BdUniqueId TYPE_FRS_GROUP;
    public static final int TYPE_USER_MEIZHI_TRUE = 1;
    public static final long serialVersionUID = 5616188082014345808L;
    public transient /* synthetic */ FieldHolder $fh;
    public long authorId;
    public int authorIsMeizhi;
    public String authorName;
    public int forumId;
    public String forumName;
    public String forumShowName;
    public int from;
    public int grade;
    public long groupId;
    public String intro;
    public int isGroupManager;
    public boolean isMemGroup;
    public int maxMemberNum;
    public int memberNum;
    public String name;
    public String portrait;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1950581492, "Lcom/baidu/tieba/im/data/GroupInfoData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1950581492, "Lcom/baidu/tieba/im/data/GroupInfoData;");
                return;
            }
        }
        TYPE_FRS_GROUP = BdUniqueId.gen();
    }

    public GroupInfoData() {
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

    public boolean autorIsMeizhi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.authorIsMeizhi == 1 : invokeV.booleanValue;
    }

    public long getAuthorId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.authorId : invokeV.longValue;
    }

    public int getAuthorIsMeizhi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.authorIsMeizhi : invokeV.intValue;
    }

    public String getAuthorName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.authorName : (String) invokeV.objValue;
    }

    public long getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.forumId : invokeV.longValue;
    }

    public String getForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.forumName : (String) invokeV.objValue;
    }

    public String getForumShowName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.forumShowName : (String) invokeV.objValue;
    }

    public int getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.from : invokeV.intValue;
    }

    public int getGrade() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.grade : invokeV.intValue;
    }

    public long getGroupId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.groupId : invokeV.longValue;
    }

    @Override // com.baidu.tbadk.core.util.AbstractImageProvider, com.baidu.tbadk.core.util.ImageProvider
    public ArrayList<String> getImageUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(this.portrait);
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.util.PreLoadImageProvider
    public ArrayList<PreLoadImageInfo> getImages() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
            PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
            preLoadImageInfo.imgUrl = this.portrait;
            preLoadImageInfo.procType = 10;
            arrayList.add(preLoadImageInfo);
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public String getIntro() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? TextUtils.isEmpty(this.intro) ? "" : this.intro : (String) invokeV.objValue;
    }

    public int getIsGroupManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.isGroupManager : invokeV.intValue;
    }

    public int getMaxMemberNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.maxMemberNum : invokeV.intValue;
    }

    public int getMemberNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.memberNum : invokeV.intValue;
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.name : (String) invokeV.objValue;
    }

    public String getPortrait() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.portrait : (String) invokeV.objValue;
    }

    @Override // d.a.d.k.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? TYPE_FRS_GROUP : (BdUniqueId) invokeV.objValue;
    }

    public boolean isMemGroup() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.isMemGroup : invokeV.booleanValue;
    }

    public void setAuthorId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048596, this, j) == null) {
            this.authorId = j;
        }
    }

    public void setAuthorIsMeizhi(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.authorIsMeizhi = i2;
        }
    }

    public void setAuthorName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.authorName = str;
        }
    }

    public void setForumId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.forumId = i2;
        }
    }

    public void setForumName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.forumName = str;
        }
    }

    public void setForumShowName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.forumShowName = str;
        }
    }

    public void setFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            this.from = i2;
        }
    }

    public void setGrade(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            this.grade = i2;
        }
    }

    public void setGroupId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048604, this, j) == null) {
            this.groupId = j;
        }
    }

    public void setIntro(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            this.intro = str;
        }
    }

    public void setIsGroupManager(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            this.isGroupManager = i2;
        }
    }

    public void setMaxMemberNum(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            this.maxMemberNum = i2;
        }
    }

    public void setMemGroup(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.isMemGroup = z;
        }
    }

    public void setMemberNum(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i2) == null) {
            this.memberNum = i2;
        }
    }

    public void setName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
            this.name = str;
        }
    }

    public void setPortrait(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            this.portrait = str;
        }
    }
}

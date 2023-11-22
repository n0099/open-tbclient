package com.baidu.tieba.im.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.AbstractImageProvider;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.PreLoadImageProvider;
import com.baidu.tieba.im.db.pojo.GroupChatRoomPojo;
import com.baidu.tieba.oi;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class GroupInfoData extends AbstractImageProvider implements oi, Parcelable, Serializable, PreLoadImageProvider {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator<GroupInfoData> CREATOR;
    public static final String SHARE_KEY_ACTIVE_ID = "scene_id";
    public static final String SHARE_KEY_ALBUM_ID = "album_id";
    public static final String SHARE_KEY_FID = "fid";
    public static final String SHARE_KEY_FROM_GROUP_ID = "share_chatroom_id";
    public static final String SHARE_KEY_GROUP_ID = "chatroom_id";
    public static final String SHARE_KEY_SCHEMA = "schema";
    public static final String SHARE_KEY_THREAD_ID = "thread_id";
    public static final String SHARE_KEY_TOPIC_ID = "topic_id";
    public static final String SHARE_KEY_TOPIC_NAME = "topic_name";
    public static final String SHARE_KEY_TYPE = "r_type";
    public static final BdUniqueId TYPE_FRS_GROUP;
    public static final long serialVersionUID = 5616188082014345808L;
    public transient /* synthetic */ FieldHolder $fh;
    public long authorId;
    public int authorIsMeizhi;
    public String authorName;
    public long forumId;
    public String forumName;
    public String forumShowName;
    public int from;
    public int grade;
    public long groupId;
    public String intro;
    public int isGroupManager;
    public boolean isMemGroup;
    public long lastUpdateTime;
    public String link;
    public String mDesc;
    public int maxMemberNum;
    public int memberNum;
    public String name;
    public String portrait;

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes6.dex */
    public class a implements Parcelable.Creator<GroupInfoData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public GroupInfoData createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) {
                if (parcel == null) {
                    return null;
                }
                GroupInfoData groupInfoData = new GroupInfoData();
                groupInfoData.groupId = parcel.readLong();
                groupInfoData.forumId = parcel.readLong();
                groupInfoData.name = parcel.readString();
                groupInfoData.portrait = parcel.readString();
                groupInfoData.forumName = parcel.readString();
                groupInfoData.forumShowName = parcel.readString();
                groupInfoData.memberNum = parcel.readInt();
                groupInfoData.link = parcel.readString();
                groupInfoData.lastUpdateTime = parcel.readLong();
                groupInfoData.isGroupManager = parcel.readInt();
                groupInfoData.authorIsMeizhi = parcel.readInt();
                groupInfoData.intro = parcel.readString();
                groupInfoData.maxMemberNum = parcel.readInt();
                groupInfoData.authorId = parcel.readLong();
                groupInfoData.authorName = parcel.readString();
                groupInfoData.grade = parcel.readInt();
                boolean z = true;
                if (parcel.readInt() != 1) {
                    z = false;
                }
                groupInfoData.isMemGroup = z;
                groupInfoData.from = parcel.readInt();
                return groupInfoData;
            }
            return (GroupInfoData) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public GroupInfoData[] newArray(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                return new GroupInfoData[i];
            }
            return (GroupInfoData[]) invokeI.objValue;
        }
    }

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
        CREATOR = new a();
    }

    public GroupInfoData() {
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

    public long getAuthorId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.authorId;
        }
        return invokeV.longValue;
    }

    public int getAuthorIsMeizhi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.authorIsMeizhi;
        }
        return invokeV.intValue;
    }

    public String getAuthorName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.authorName;
        }
        return (String) invokeV.objValue;
    }

    public String getDesc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mDesc;
        }
        return (String) invokeV.objValue;
    }

    public long getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.forumId;
        }
        return invokeV.longValue;
    }

    public String getForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.forumName;
        }
        return (String) invokeV.objValue;
    }

    public String getForumShowName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.forumShowName;
        }
        return (String) invokeV.objValue;
    }

    public int getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.from;
        }
        return invokeV.intValue;
    }

    public int getGrade() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.grade;
        }
        return invokeV.intValue;
    }

    public long getGroupId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.groupId;
        }
        return invokeV.longValue;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (TextUtils.isEmpty(this.intro)) {
                return "";
            }
            return this.intro;
        }
        return (String) invokeV.objValue;
    }

    public int getIsGroupManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.isGroupManager;
        }
        return invokeV.intValue;
    }

    public int getMaxMemberNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.maxMemberNum;
        }
        return invokeV.intValue;
    }

    public int getMemberNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.memberNum;
        }
        return invokeV.intValue;
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.name;
        }
        return (String) invokeV.objValue;
    }

    public String getPortrait() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.portrait;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.oi
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return TYPE_FRS_GROUP;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public boolean isMemGroup() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.isMemGroup;
        }
        return invokeV.booleanValue;
    }

    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.groupId > 0 && !TextUtils.isEmpty(this.name)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Nullable
    public static GroupInfoData fromGroupChatRoomPojo(@NonNull GroupChatRoomPojo groupChatRoomPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, groupChatRoomPojo)) == null) {
            if (groupChatRoomPojo.getRoomId() <= 0) {
                return null;
            }
            GroupInfoData groupInfoData = new GroupInfoData();
            groupInfoData.setGroupId(groupChatRoomPojo.getRoomId());
            groupInfoData.setName(groupChatRoomPojo.getName());
            groupInfoData.setPortrait(groupChatRoomPojo.getAvatar());
            groupInfoData.forumId = JavaTypesHelper.toLong(groupChatRoomPojo.getForumId(), -1L);
            groupInfoData.forumName = groupChatRoomPojo.getForumName();
            groupInfoData.lastUpdateTime = groupChatRoomPojo.getTimestamp();
            return groupInfoData;
        }
        return (GroupInfoData) invokeL.objValue;
    }

    @Nullable
    public static GroupInfoData fromJsonH5(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, jSONObject)) == null) {
            long optLong = jSONObject.optLong("roomId");
            if (optLong <= 0) {
                return null;
            }
            GroupInfoData groupInfoData = new GroupInfoData();
            groupInfoData.setGroupId(optLong);
            groupInfoData.setName(jSONObject.optString("title"));
            groupInfoData.setPortrait(jSONObject.optString("img"));
            groupInfoData.setDesc(jSONObject.optString("desc"));
            groupInfoData.link = jSONObject.optString("url");
            groupInfoData.forumId = jSONObject.optLong("fid");
            groupInfoData.forumName = jSONObject.optString(ForumBroadcastHelper.KEY_PARMARS_FORUM_NAME);
            groupInfoData.setMemberNum(jSONObject.optInt("roomMemberCount"));
            return groupInfoData;
        }
        return (GroupInfoData) invokeL.objValue;
    }

    public static boolean isValidGroup(GroupInfoData groupInfoData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, groupInfoData)) == null) {
            if (groupInfoData != null && groupInfoData.isValid()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setAuthorId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048597, this, j) == null) {
            this.authorId = j;
        }
    }

    public void setAuthorIsMeizhi(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            this.authorIsMeizhi = i;
        }
    }

    public void setAuthorName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.authorName = str;
        }
    }

    public void setDesc(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.mDesc = str;
        }
    }

    public void setForumId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            this.forumId = i;
        }
    }

    public void setForumName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.forumName = str;
        }
    }

    public void setForumShowName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.forumShowName = str;
        }
    }

    public void setFrom(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
            this.from = i;
        }
    }

    public void setGrade(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i) == null) {
            this.grade = i;
        }
    }

    public void setGroupId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048606, this, j) == null) {
            this.groupId = j;
        }
    }

    public void setIntro(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            this.intro = str;
        }
    }

    public void setIsGroupManager(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            this.isGroupManager = i;
        }
    }

    public void setMaxMemberNum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i) == null) {
            this.maxMemberNum = i;
        }
    }

    public void setMemGroup(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            this.isMemGroup = z;
        }
    }

    public void setMemberNum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i) == null) {
            this.memberNum = i;
        }
    }

    public void setName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            this.name = str;
        }
    }

    public void setPortrait(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
            this.portrait = str;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return "GroupInfoData{groupId=" + this.groupId + ", forumId=" + this.forumId + ", name='" + this.name + "', portrait='" + this.portrait + "', forumName='" + this.forumName + "', forumShowName='" + this.forumShowName + "', memberNum=" + this.memberNum + ", lastUpdateTime=" + this.lastUpdateTime + '}';
        }
        return (String) invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048615, this, parcel, i) == null) {
            parcel.writeLong(this.groupId);
            parcel.writeLong(this.forumId);
            parcel.writeString(this.name);
            parcel.writeString(this.portrait);
            parcel.writeString(this.forumName);
            parcel.writeString(this.forumShowName);
            parcel.writeInt(this.memberNum);
            parcel.writeString(this.link);
            parcel.writeLong(this.lastUpdateTime);
            parcel.writeInt(this.isGroupManager);
            parcel.writeInt(this.authorIsMeizhi);
            parcel.writeString(this.intro);
            parcel.writeInt(this.maxMemberNum);
            parcel.writeLong(this.authorId);
            parcel.writeString(this.authorName);
            parcel.writeInt(this.grade);
            parcel.writeInt(this.isMemGroup ? 1 : 0);
            parcel.writeInt(this.from);
        }
    }
}

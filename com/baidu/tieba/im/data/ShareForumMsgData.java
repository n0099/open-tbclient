package com.baidu.tieba.im.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tieba.pg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
import protobuf.ForumInfo;
/* loaded from: classes4.dex */
public final class ShareForumMsgData extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -768533409599248763L;
    public transient /* synthetic */ FieldHolder $fh;
    public String avatar;
    public long forum_id;
    public String forum_name;
    public int hasRead;
    public int member_count;
    public String slogan;
    public int thread_count;

    public ShareForumMsgData() {
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
        this.hasRead = 0;
    }

    public static ShareForumMsgData ofForumData(@NonNull ForumData forumData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, forumData)) == null) {
            if (forumData == null) {
                return null;
            }
            ShareForumMsgData shareForumMsgData = new ShareForumMsgData();
            shareForumMsgData.forum_id = pg.g(forumData.getId(), 0L);
            shareForumMsgData.forum_name = forumData.getName();
            shareForumMsgData.avatar = forumData.getImage_url();
            shareForumMsgData.thread_count = forumData.getThread_num();
            shareForumMsgData.member_count = forumData.getMember_num();
            shareForumMsgData.slogan = forumData.getSlogan();
            return shareForumMsgData;
        }
        return (ShareForumMsgData) invokeL.objValue;
    }

    @Nullable
    public static ShareForumMsgData ofImForumInfo(ForumInfo forumInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, forumInfo)) == null) {
            if (forumInfo == null) {
                return null;
            }
            ShareForumMsgData shareForumMsgData = new ShareForumMsgData();
            shareForumMsgData.forum_id = forumInfo.forumId.longValue();
            shareForumMsgData.forum_name = forumInfo.forumName;
            shareForumMsgData.avatar = forumInfo.avatar;
            shareForumMsgData.thread_count = pg.e(forumInfo.threadNum, 0);
            shareForumMsgData.member_count = forumInfo.memberCount.intValue();
            shareForumMsgData.slogan = forumInfo.slogan;
            return shareForumMsgData;
        }
        return (ShareForumMsgData) invokeL.objValue;
    }

    public String getAvatar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.avatar : (String) invokeV.objValue;
    }

    public long getForum_id() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.forum_id : invokeV.longValue;
    }

    public String getForum_name() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.forum_name : (String) invokeV.objValue;
    }

    public int getMember_count() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.member_count : invokeV.intValue;
    }

    public String getSlogan() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.slogan : (String) invokeV.objValue;
    }

    public int getThread_count() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.thread_count : invokeV.intValue;
    }

    public boolean hasRead() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.hasRead == 1 : invokeV.booleanValue;
    }

    public void setAvatar(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.avatar = str;
        }
    }

    public void setForum_id(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
            this.forum_id = j;
        }
    }

    public void setForum_name(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.forum_name = str;
        }
    }

    public void setHasRead(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.hasRead = z ? 1 : 0;
        }
    }

    public void setMember_count(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.member_count = i;
        }
    }

    public void setSlogan(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.slogan = str;
        }
    }

    public void setThread_count(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.thread_count = i;
        }
    }

    public String toEncodeContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("fid", getForum_id());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }
}

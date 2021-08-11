package com.baidu.tieba.im.message.chat;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.e.c.e.c.a;
import c.a.e.e.m.b;
import c.a.e.k.e.n;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.gif.GifInfo;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class ChatMessage extends TbSocketMessage implements a, n {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId TYPE_MSG_GROUP_ACTIVITY;
    public static final BdUniqueId TYPE_MSG_LEFT;
    public static final BdUniqueId TYPE_MSG_MID;
    public static final BdUniqueId TYPE_MSG_MULTI_PIC_TEXT;
    public static final BdUniqueId TYPE_MSG_PHOTOLIVE;
    public static final BdUniqueId TYPE_MSG_REPLY_CARD;
    public static final BdUniqueId TYPE_MSG_RIGHT;
    public static final BdUniqueId TYPE_MSG_TOPIC;
    public transient /* synthetic */ FieldHolder $fh;
    public long bornTime;
    public transient MsgCacheData cacheData;
    public String content;
    public int customGroupType;
    public int followStatus;
    public GifInfo gifInfo;
    public String groupId;
    public boolean hasRead;
    public boolean hasRepeat;
    public int height;
    public int isFriend;
    public boolean isGifLoadSuccess;
    public boolean isUploading;
    public String link;
    public MsgLocalData localData;
    public long logTime;
    public boolean mIsPushForOperateAccount;
    public LinkedList<IconData> mTShowIconInfo;
    public long mToUserId;
    public long msgId;
    public int msgType;
    public Object objContent;
    public int progressValue;
    public int readCountPv;
    public long recordId;
    public long serviceId;
    public long sid;
    public String st_type;
    public String stat;
    public long statisticsServiceId;
    public long statisticsTaskId;
    public long taskId;
    public long time;
    public UserData toUserInfo;
    public long userId;
    public UserData userInfo;
    public int width;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(51080606, "Lcom/baidu/tieba/im/message/chat/ChatMessage;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(51080606, "Lcom/baidu/tieba/im/message/chat/ChatMessage;");
                return;
            }
        }
        TYPE_MSG_LEFT = BdUniqueId.gen();
        TYPE_MSG_RIGHT = BdUniqueId.gen();
        TYPE_MSG_MID = BdUniqueId.gen();
        TYPE_MSG_TOPIC = BdUniqueId.gen();
        TYPE_MSG_GROUP_ACTIVITY = BdUniqueId.gen();
        TYPE_MSG_MULTI_PIC_TEXT = BdUniqueId.gen();
        TYPE_MSG_REPLY_CARD = BdUniqueId.gen();
        TYPE_MSG_PHOTOLIVE = BdUniqueId.gen();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatMessage(int i2) {
        super(i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.progressValue = 0;
        this.statisticsTaskId = -1L;
        this.statisticsServiceId = -1L;
        this.mIsPushForOperateAccount = false;
        this.isGifLoadSuccess = true;
        this.isUploading = false;
    }

    public long getBornTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.bornTime : invokeV.longValue;
    }

    public MsgCacheData getCacheData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.cacheData : (MsgCacheData) invokeV.objValue;
    }

    public String getContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.content : (String) invokeV.objValue;
    }

    public int getCustomGroupType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.customGroupType : invokeV.intValue;
    }

    public int getFollowStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.followStatus : invokeV.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0073 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public GifInfo getGifInfo() {
        InterceptResult invokeV;
        JSONObject jSONObject;
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048581, this)) != null) {
            return (GifInfo) invokeV.objValue;
        }
        GifInfo gifInfo = this.gifInfo;
        if (gifInfo != null) {
            return gifInfo;
        }
        String str = this.content;
        try {
            try {
                jSONArray = new JSONArray(str);
            } catch (JSONException unused) {
            }
        } catch (JSONException unused2) {
            jSONObject = new JSONObject(str);
        }
        if (jSONArray.length() > 0) {
            jSONObject = jSONArray.getJSONObject(0);
            if (jSONObject == null) {
                String optString = jSONObject.optString("face_name");
                String optString2 = jSONObject.optString("url_s");
                String optString3 = jSONObject.optString("url_d");
                String optString4 = jSONObject.optString("pid");
                String optString5 = jSONObject.optString("packet_name");
                String optString6 = jSONObject.optString("icon");
                int optInt = jSONObject.optInt("size_width");
                int optInt2 = jSONObject.optInt("size_height");
                GifInfo gifInfo2 = new GifInfo();
                gifInfo2.mLoadFailed = false;
                gifInfo2.mSharpText = optString;
                gifInfo2.mStaticUrl = optString2;
                gifInfo2.mDynamicUrl = optString3;
                gifInfo2.mGid = optString4;
                gifInfo2.mGifWidth = optInt;
                gifInfo2.mGifHeight = optInt2;
                gifInfo2.mPackageName = optString5;
                gifInfo2.mIcon = optString6;
                this.gifInfo = gifInfo2;
                return gifInfo2;
            }
            return null;
        }
        jSONObject = null;
        if (jSONObject == null) {
        }
    }

    public String getGroupId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.groupId : (String) invokeV.objValue;
    }

    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.height : invokeV.intValue;
    }

    public int getIsFriend() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.isFriend : invokeV.intValue;
    }

    public boolean getIsUploading() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.isUploading : invokeV.booleanValue;
    }

    public String getLink() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.link : (String) invokeV.objValue;
    }

    public MsgLocalData getLocalData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.localData : (MsgLocalData) invokeV.objValue;
    }

    public long getLogTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.logTime : invokeV.longValue;
    }

    public long getMsgId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.msgId : invokeV.longValue;
    }

    public int getMsgType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.msgType : invokeV.intValue;
    }

    public Object getObjContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.objContent : invokeV.objValue;
    }

    public int getProgressValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.progressValue : invokeV.intValue;
    }

    public int getReadCountPv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.readCountPv : invokeV.intValue;
    }

    public long getRecordId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.recordId : invokeV.longValue;
    }

    public long getServiceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.serviceId : invokeV.longValue;
    }

    public long getSid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.sid : invokeV.longValue;
    }

    public String getSt_type() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.st_type : (String) invokeV.objValue;
    }

    public String getStat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.stat : (String) invokeV.objValue;
    }

    public long getStatTaskId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            long j2 = this.statisticsTaskId;
            if (j2 != -1) {
                return j2;
            }
            if (!TextUtils.isEmpty(this.content)) {
                try {
                    JSONArray jSONArray = new JSONArray(this.content);
                    if (jSONArray.length() > 0) {
                        this.statisticsTaskId = b.f(jSONArray.optJSONObject(0).optString("task_id"), 0L);
                    }
                } catch (Exception unused) {
                }
            }
            if (this.statisticsTaskId <= 0) {
                long j3 = this.taskId;
                this.statisticsTaskId = j3 >= 0 ? j3 : 0L;
            }
            return this.statisticsTaskId;
        }
        return invokeV.longValue;
    }

    public long getStatisticsServiceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            long j2 = this.statisticsServiceId;
            if (j2 != -1) {
                return j2;
            }
            if (!TextUtils.isEmpty(this.content)) {
                try {
                    JSONArray jSONArray = new JSONArray(this.content);
                    if (jSONArray.length() > 0) {
                        this.statisticsServiceId = b.f(jSONArray.optJSONObject(0).optString("service_id"), 0L);
                    }
                } catch (Exception unused) {
                }
            }
            if (this.statisticsServiceId <= 0) {
                long j3 = this.serviceId;
                this.statisticsServiceId = j3 >= 0 ? j3 : 0L;
            }
            return this.statisticsServiceId;
        }
        return invokeV.longValue;
    }

    public LinkedList<IconData> getTShowInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.mTShowIconInfo : (LinkedList) invokeV.objValue;
    }

    public long getTaskId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.taskId : invokeV.longValue;
    }

    public long getTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.time : invokeV.longValue;
    }

    public long getToUserId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.mToUserId : invokeV.longValue;
    }

    public UserData getToUserInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.toUserInfo : (UserData) invokeV.objValue;
    }

    @Override // c.a.e.k.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            int i2 = this.msgType;
            if (i2 == 11) {
                return TYPE_MSG_MID;
            }
            if (i2 == 12) {
                return TYPE_MSG_TOPIC;
            }
            if (i2 == 6) {
                return TYPE_MSG_GROUP_ACTIVITY;
            }
            if (i2 == 7) {
                return TYPE_MSG_MULTI_PIC_TEXT;
            }
            if (i2 == 23) {
                return TYPE_MSG_REPLY_CARD;
            }
            if (i2 == 25) {
                return TYPE_MSG_PHOTOLIVE;
            }
            if (getUserInfo() != null && getUserInfo().getUserId() != null) {
                if (getUserInfo().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    return TYPE_MSG_RIGHT;
                }
                return TYPE_MSG_LEFT;
            }
            return TYPE_MSG_LEFT;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public long getUserId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.userId : invokeV.longValue;
    }

    public UserData getUserInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.userInfo : (UserData) invokeV.objValue;
    }

    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.width : invokeV.intValue;
    }

    public boolean isGifLoadSuccess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.isGifLoadSuccess : invokeV.booleanValue;
    }

    public boolean isHasRead() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.hasRead : invokeV.booleanValue;
    }

    public boolean isPushForOperateAccount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.mIsPushForOperateAccount : invokeV.booleanValue;
    }

    @Override // c.a.e.c.e.c.a
    public boolean onFindMessage(SocketMessage socketMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, socketMessage)) == null) {
            if (socketMessage != null && (socketMessage instanceof ChatMessage)) {
                ChatMessage chatMessage = (ChatMessage) socketMessage;
                return chatMessage.getGroupId() != null && chatMessage.getRecordId() == this.recordId && chatMessage.getGroupId().equals(this.groupId) && chatMessage.getToUserId() == this.mToUserId;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setBornTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048614, this, j2) == null) {
            this.bornTime = j2;
        }
    }

    public void setCacheData(MsgCacheData msgCacheData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, msgCacheData) == null) {
            this.cacheData = msgCacheData;
        }
    }

    public void setContent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, str) == null) {
            this.content = str;
        }
    }

    public void setCustomGroupType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i2) == null) {
            this.customGroupType = i2;
        }
    }

    public void setFollowStatus(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i2) == null) {
            this.followStatus = i2;
        }
    }

    public void setGifLoadSuccess(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.isGifLoadSuccess = z;
        }
    }

    public void setGroupId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, str) == null) {
            this.groupId = str;
        }
    }

    public void setHasRead(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z) == null) {
            this.hasRead = z;
        }
    }

    public void setHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048622, this, i2) == null) {
            this.height = i2;
        }
    }

    public void setIsFriend(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i2) == null) {
            this.isFriend = i2;
        }
    }

    public void setIsPushForOperateAccount(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
            this.mIsPushForOperateAccount = z;
        }
    }

    public void setIsUploading(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
            this.isUploading = z;
        }
    }

    public void setLink(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, str) == null) {
            this.link = str;
        }
    }

    public void setLocalData(MsgLocalData msgLocalData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, msgLocalData) == null) {
            this.localData = msgLocalData;
        }
    }

    public void setLogTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048628, this, j2) == null) {
            this.logTime = j2;
        }
    }

    public void setMsgId(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048629, this, j2) == null) {
            this.msgId = j2;
        }
    }

    public void setMsgType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048630, this, i2) == null) {
            this.msgType = i2;
        }
    }

    public void setObjContent(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, obj) == null) {
            this.objContent = obj;
        }
    }

    public void setProgressValue(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048632, this, i2) == null) {
            this.progressValue = i2;
        }
    }

    public void setReadCountPv(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048633, this, i2) == null) {
            this.readCountPv = i2;
        }
    }

    public void setRecordId(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048634, this, j2) == null) {
            this.recordId = j2;
        }
    }

    public void setServiceId(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048635, this, j2) == null) {
            this.serviceId = j2;
        }
    }

    public void setSid(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048636, this, j2) == null) {
            this.sid = j2;
        }
    }

    public void setSt_type(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, str) == null) {
            this.st_type = str;
        }
    }

    public void setStat(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, str) == null) {
            this.stat = str;
        }
    }

    public void setTShowInfo(LinkedList<IconData> linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, linkedList) == null) {
            this.mTShowIconInfo = linkedList;
        }
    }

    public void setTaskId(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048640, this, j2) == null) {
            this.taskId = j2;
        }
    }

    public void setTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048641, this, j2) == null) {
            this.time = j2;
        }
    }

    public void setToUserId(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048642, this, j2) == null) {
            this.mToUserId = j2;
        }
    }

    public void setToUserInfo(UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, userData) == null) {
            this.toUserInfo = userData;
        }
    }

    public void setUserId(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048644, this, j2) == null) {
            this.userId = j2;
        }
    }

    public void setUserInfo(UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, userData) == null) {
            this.userInfo = userData;
        }
    }

    public void setWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048646, this, i2) == null) {
            this.width = i2;
        }
    }
}

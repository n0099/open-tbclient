package com.baidu.tieba.im.message.chat;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.gif.GifInfo;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import com.baidu.tieba.cb7;
import com.baidu.tieba.ic7;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.na;
import com.baidu.tieba.xg;
import com.baidu.tieba.xn;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class ChatMessage extends TbSocketMessage implements na, xn {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId TYPE_MSG_GROUP_ACTIVITY;
    public static final BdUniqueId TYPE_MSG_ICE_BREAK;
    public static final BdUniqueId TYPE_MSG_LEFT;
    public static final BdUniqueId TYPE_MSG_LEFT_FORUM;
    public static final BdUniqueId TYPE_MSG_LEFT_IMAGE_THREAD;
    public static final BdUniqueId TYPE_MSG_MID;
    public static final BdUniqueId TYPE_MSG_MULTI_PIC_TEXT;
    public static final BdUniqueId TYPE_MSG_PHOTOLIVE;
    public static final BdUniqueId TYPE_MSG_REPLY_CARD;
    public static final BdUniqueId TYPE_MSG_RIGHT;
    public static final BdUniqueId TYPE_MSG_RIGHT_FORUM;
    public static final BdUniqueId TYPE_MSG_RIGHT_IMAGE_THREAD;
    public static final BdUniqueId TYPE_MSG_STRANGER_TIP;
    public static final BdUniqueId TYPE_MSG_TOPIC;
    public transient /* synthetic */ FieldHolder $fh;
    public transient MsgCacheData cacheData;
    public String content;
    public int customGroupType;
    public String encodeContent;
    public int followStatus;
    public GifInfo gifInfo;
    public String groupId;
    public boolean hasRead;
    public int height;
    public List<ic7> iceBreakEmotions;
    public int isFriend;
    public boolean isUploading;
    public WeakReference<cb7> itemViewWeakReference;
    public String link;
    public MsgLocalData localData;
    public long logTime;
    public int mError;
    public String mErrorString;
    public boolean mIsPushForOperateAccount;
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

    public void setBornTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048616, this, j) == null) {
        }
    }

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
        TYPE_MSG_ICE_BREAK = BdUniqueId.gen();
        TYPE_MSG_STRANGER_TIP = BdUniqueId.gen();
        TYPE_MSG_LEFT_FORUM = BdUniqueId.gen();
        TYPE_MSG_RIGHT_FORUM = BdUniqueId.gen();
        TYPE_MSG_LEFT_IMAGE_THREAD = BdUniqueId.gen();
        TYPE_MSG_RIGHT_IMAGE_THREAD = BdUniqueId.gen();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0071 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public GifInfo getGifInfo() {
        InterceptResult invokeV;
        JSONObject jSONObject;
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
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
                if (jSONObject != null) {
                    return null;
                }
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
            jSONObject = null;
            if (jSONObject != null) {
            }
        } else {
            return (GifInfo) invokeV.objValue;
        }
    }

    @Override // com.baidu.tieba.xn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            int i = this.msgType;
            if (i == 11) {
                return TYPE_MSG_MID;
            }
            if (i == 12) {
                return TYPE_MSG_TOPIC;
            }
            if (i == 6) {
                return TYPE_MSG_GROUP_ACTIVITY;
            }
            if (i != 7 && i != 35) {
                if (i == 23) {
                    return TYPE_MSG_REPLY_CARD;
                }
                if (i == 25) {
                    return TYPE_MSG_PHOTOLIVE;
                }
                if (i == 8001) {
                    return TYPE_MSG_STRANGER_TIP;
                }
                if (this.iceBreakEmotions != null) {
                    return TYPE_MSG_ICE_BREAK;
                }
                if (getUserInfo() != null && getUserInfo().getUserId() != null) {
                    if (getUserInfo().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        return TYPE_MSG_RIGHT;
                    }
                    return TYPE_MSG_LEFT;
                }
                return TYPE_MSG_LEFT;
            }
            return TYPE_MSG_MULTI_PIC_TEXT;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatMessage(int i) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.progressValue = 0;
        this.mError = 0;
        this.mErrorString = null;
        this.statisticsTaskId = -1L;
        this.statisticsServiceId = -1L;
        this.mIsPushForOperateAccount = false;
        this.isUploading = false;
    }

    public MsgCacheData getCacheData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.cacheData;
        }
        return (MsgCacheData) invokeV.objValue;
    }

    public String getContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.content;
        }
        return (String) invokeV.objValue;
    }

    public int getCustomGroupType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.customGroupType;
        }
        return invokeV.intValue;
    }

    public String getEncodeContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.encodeContent;
        }
        return (String) invokeV.objValue;
    }

    public int getError() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mError;
        }
        return invokeV.intValue;
    }

    public String getErrorString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mErrorString;
        }
        return (String) invokeV.objValue;
    }

    public int getFollowStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.followStatus;
        }
        return invokeV.intValue;
    }

    public String getGroupId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.groupId;
        }
        return (String) invokeV.objValue;
    }

    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.height;
        }
        return invokeV.intValue;
    }

    public List<ic7> getIceBreakEmotions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.iceBreakEmotions;
        }
        return (List) invokeV.objValue;
    }

    public int getIsFriend() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.isFriend;
        }
        return invokeV.intValue;
    }

    public boolean getIsUploading() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.isUploading;
        }
        return invokeV.booleanValue;
    }

    @Nullable
    public cb7 getItemView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            WeakReference<cb7> weakReference = this.itemViewWeakReference;
            if (weakReference == null) {
                return null;
            }
            return weakReference.get();
        }
        return (cb7) invokeV.objValue;
    }

    public String getLink() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.link;
        }
        return (String) invokeV.objValue;
    }

    public MsgLocalData getLocalData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.localData;
        }
        return (MsgLocalData) invokeV.objValue;
    }

    public long getLogTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.logTime;
        }
        return invokeV.longValue;
    }

    public long getMsgId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.msgId;
        }
        return invokeV.longValue;
    }

    public int getMsgType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.msgType;
        }
        return invokeV.intValue;
    }

    public Object getObjContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.objContent;
        }
        return invokeV.objValue;
    }

    public int getProgressValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.progressValue;
        }
        return invokeV.intValue;
    }

    public int getReadCountPv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.readCountPv;
        }
        return invokeV.intValue;
    }

    public long getRecordId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.recordId;
        }
        return invokeV.longValue;
    }

    public long getServiceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.serviceId;
        }
        return invokeV.longValue;
    }

    public long getSid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.sid;
        }
        return invokeV.longValue;
    }

    public String getSt_type() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.st_type;
        }
        return (String) invokeV.objValue;
    }

    public String getStat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.stat;
        }
        return (String) invokeV.objValue;
    }

    public long getTaskId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.taskId;
        }
        return invokeV.longValue;
    }

    public long getTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.time;
        }
        return invokeV.longValue;
    }

    public long getToUserId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.mToUserId;
        }
        return invokeV.longValue;
    }

    public UserData getToUserInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.toUserInfo;
        }
        return (UserData) invokeV.objValue;
    }

    public long getUserId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.userId;
        }
        return invokeV.longValue;
    }

    public UserData getUserInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.userInfo;
        }
        return (UserData) invokeV.objValue;
    }

    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.width;
        }
        return invokeV.intValue;
    }

    public boolean isHasRead() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.hasRead;
        }
        return invokeV.booleanValue;
    }

    public boolean isPushForOperateAccount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.mIsPushForOperateAccount;
        }
        return invokeV.booleanValue;
    }

    public long getStatTaskId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            long j = this.statisticsTaskId;
            if (j != -1) {
                return j;
            }
            long j2 = 0;
            if (!TextUtils.isEmpty(this.content)) {
                try {
                    JSONArray jSONArray = new JSONArray(this.content);
                    if (jSONArray.length() > 0) {
                        this.statisticsTaskId = xg.g(jSONArray.optJSONObject(0).optString("task_id"), 0L);
                    }
                } catch (Exception unused) {
                }
            }
            if (this.statisticsTaskId <= 0) {
                long j3 = this.taskId;
                if (j3 >= 0) {
                    j2 = j3;
                }
                this.statisticsTaskId = j2;
            }
            return this.statisticsTaskId;
        }
        return invokeV.longValue;
    }

    public long getStatisticsServiceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            long j = this.statisticsServiceId;
            if (j != -1) {
                return j;
            }
            long j2 = 0;
            if (!TextUtils.isEmpty(this.content)) {
                try {
                    JSONArray jSONArray = new JSONArray(this.content);
                    if (jSONArray.length() > 0) {
                        this.statisticsServiceId = xg.g(jSONArray.optJSONObject(0).optString("service_id"), 0L);
                    }
                } catch (Exception unused) {
                }
            }
            if (this.statisticsServiceId <= 0) {
                long j3 = this.serviceId;
                if (j3 >= 0) {
                    j2 = j3;
                }
                this.statisticsServiceId = j2;
            }
            return this.statisticsServiceId;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.na
    public boolean onFindMessage(SocketMessage socketMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, socketMessage)) == null) {
            if (socketMessage == null || !(socketMessage instanceof ChatMessage)) {
                return false;
            }
            ChatMessage chatMessage = (ChatMessage) socketMessage;
            if (chatMessage.getGroupId() == null || chatMessage.getRecordId() != this.recordId || !chatMessage.getGroupId().equals(this.groupId) || chatMessage.getToUserId() != this.mToUserId) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setItemView(@Nullable cb7 cb7Var) {
        WeakReference<cb7> weakReference;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, cb7Var) == null) {
            if (cb7Var == null && (weakReference = this.itemViewWeakReference) != null) {
                weakReference.clear();
                this.itemViewWeakReference = null;
                return;
            }
            WeakReference<cb7> weakReference2 = this.itemViewWeakReference;
            if (weakReference2 != null) {
                if (weakReference2.get() == cb7Var) {
                    return;
                }
                this.itemViewWeakReference.clear();
                this.itemViewWeakReference = null;
            }
            this.itemViewWeakReference = new WeakReference<>(cb7Var);
        }
    }

    public void setCacheData(MsgCacheData msgCacheData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, msgCacheData) == null) {
            this.cacheData = msgCacheData;
        }
    }

    public void setContent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, str) == null) {
            this.content = str;
        }
    }

    public void setCustomGroupType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i) == null) {
            this.customGroupType = i;
        }
    }

    public void setEncodeContent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, str) == null) {
            this.encodeContent = str;
        }
    }

    public void setError(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i) == null) {
            this.mError = i;
        }
    }

    public void setErrorString(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            this.mErrorString = str;
        }
    }

    public void setFollowStatus(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i) == null) {
            this.followStatus = i;
        }
    }

    public void setGroupId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, str) == null) {
            this.groupId = str;
        }
    }

    public void setHasRead(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
            this.hasRead = z;
        }
    }

    public void setHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048626, this, i) == null) {
            this.height = i;
        }
    }

    public void setIceBreakEmotions(List<ic7> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, list) == null) {
            this.iceBreakEmotions = list;
        }
    }

    public void setIsFriend(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048628, this, i) == null) {
            this.isFriend = i;
        }
    }

    public void setIsPushForOperateAccount(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z) == null) {
            this.mIsPushForOperateAccount = z;
        }
    }

    public void setIsUploading(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048630, this, z) == null) {
            this.isUploading = z;
        }
    }

    public void setLink(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, str) == null) {
            this.link = str;
        }
    }

    public void setLocalData(MsgLocalData msgLocalData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, msgLocalData) == null) {
            this.localData = msgLocalData;
        }
    }

    public void setLogTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048634, this, j) == null) {
            this.logTime = j;
        }
    }

    public void setMsgId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048635, this, j) == null) {
            this.msgId = j;
        }
    }

    public void setMsgType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048636, this, i) == null) {
            this.msgType = i;
        }
    }

    public void setObjContent(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, obj) == null) {
            this.objContent = obj;
        }
    }

    public void setProgressValue(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048638, this, i) == null) {
            this.progressValue = i;
        }
    }

    public void setReadCountPv(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048639, this, i) == null) {
            this.readCountPv = i;
        }
    }

    public void setRecordId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048640, this, j) == null) {
            this.recordId = j;
        }
    }

    public void setServiceId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048641, this, j) == null) {
            this.serviceId = j;
        }
    }

    public void setSid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048642, this, j) == null) {
            this.sid = j;
        }
    }

    public void setSt_type(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, str) == null) {
            this.st_type = str;
        }
    }

    public void setStat(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, str) == null) {
            this.stat = str;
        }
    }

    public void setTaskId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048645, this, j) == null) {
            this.taskId = j;
        }
    }

    public void setTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048646, this, j) == null) {
            this.time = j;
        }
    }

    public void setToUserId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048647, this, j) == null) {
            this.mToUserId = j;
        }
    }

    public void setToUserInfo(UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, userData) == null) {
            this.toUserInfo = userData;
        }
    }

    public void setUserId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048649, this, j) == null) {
            this.userId = j;
        }
    }

    public void setUserInfo(UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, userData) == null) {
            this.userInfo = userData;
        }
    }

    public void setWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048651, this, i) == null) {
            this.width = i;
        }
    }
}

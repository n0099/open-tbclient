package com.baidu.tieba.im.data;

import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import protobuf.ImShareChatroomInfo;
@Keep
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0001'B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003JE\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u0011HÖ\u0001J\u0006\u0010%\u001a\u00020\u0005J\t\u0010&\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u0006("}, d2 = {"Lcom/baidu/tieba/im/data/ShareChatroomMsgData;", "Lcom/baidu/adp/lib/OrmObject/toolsystem/orm/object/OrmObject;", "id", "", "name", "", "icon", "fid", "forumName", "chatCount", "(JLjava/lang/String;Ljava/lang/String;JLjava/lang/String;J)V", "getChatCount", "()J", "getFid", "getForumName", "()Ljava/lang/String;", "hasRead", "", "getHasRead", "()I", "setHasRead", "(I)V", "getIcon", "getId", "getName", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", ImageViewerConfig.FROM_OTHER, "", TTDownloadField.TT_HASHCODE, "toEncodeContent", "toString", "Companion", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ShareChatroomMsgData extends OrmObject {
    public static /* synthetic */ Interceptable $ic = null;
    public static final a Companion;
    public static final String KEY_CHATROOM_ID = "chatroom_id";
    public static final String KEY_TYPE = "type";
    public static final int TYPE_CHATROOM = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public final long chatCount;
    public final long fid;
    public final String forumName;
    public int hasRead;
    public final String icon;
    public final long id;
    public final String name;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1265658342, "Lcom/baidu/tieba/im/data/ShareChatroomMsgData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1265658342, "Lcom/baidu/tieba/im/data/ShareChatroomMsgData;");
                return;
            }
        }
        Companion = new a(null);
    }

    public final long component1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.id : invokeV.longValue;
    }

    public final String component2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.name : (String) invokeV.objValue;
    }

    public final String component3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.icon : (String) invokeV.objValue;
    }

    public final long component4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.fid : invokeV.longValue;
    }

    public final String component5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.forumName : (String) invokeV.objValue;
    }

    public final long component6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.chatCount : invokeV.longValue;
    }

    public final ShareChatroomMsgData copy(long j, String name, String icon, long j2, String forumName, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j), name, icon, Long.valueOf(j2), forumName, Long.valueOf(j3)})) == null) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(icon, "icon");
            Intrinsics.checkNotNullParameter(forumName, "forumName");
            return new ShareChatroomMsgData(j, name, icon, j2, forumName, j3);
        }
        return (ShareChatroomMsgData) invokeCommon.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ShareChatroomMsgData) {
                ShareChatroomMsgData shareChatroomMsgData = (ShareChatroomMsgData) obj;
                return this.id == shareChatroomMsgData.id && Intrinsics.areEqual(this.name, shareChatroomMsgData.name) && Intrinsics.areEqual(this.icon, shareChatroomMsgData.icon) && this.fid == shareChatroomMsgData.fid && Intrinsics.areEqual(this.forumName, shareChatroomMsgData.forumName) && this.chatCount == shareChatroomMsgData.chatCount;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (((((((((com.baidu.tieba.a.a(this.id) * 31) + this.name.hashCode()) * 31) + this.icon.hashCode()) * 31) + com.baidu.tieba.a.a(this.fid)) * 31) + this.forumName.hashCode()) * 31) + com.baidu.tieba.a.a(this.chatCount) : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return "ShareChatroomMsgData(id=" + this.id + ", name=" + this.name + ", icon=" + this.icon + ", fid=" + this.fid + ", forumName=" + this.forumName + ", chatCount=" + this.chatCount + ')';
        }
        return (String) invokeV.objValue;
    }

    /* loaded from: classes4.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

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

        public final ShareChatroomMsgData a(GroupInfoData info) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, info)) == null) {
                Intrinsics.checkNotNullParameter(info, "info");
                long groupId = info.getGroupId();
                String name = info.getName();
                Intrinsics.checkNotNullExpressionValue(name, "info.name");
                String portrait = info.getPortrait();
                Intrinsics.checkNotNullExpressionValue(portrait, "info.portrait");
                long forumId = info.getForumId();
                String forumName = info.getForumName();
                Intrinsics.checkNotNullExpressionValue(forumName, "info.forumName");
                return new ShareChatroomMsgData(groupId, name, portrait, forumId, forumName, info.getMemberNum());
            }
            return (ShareChatroomMsgData) invokeL.objValue;
        }

        public final ShareChatroomMsgData b(ImShareChatroomInfo info) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, info)) == null) {
                Intrinsics.checkNotNullParameter(info, "info");
                Long l = info.id;
                Intrinsics.checkNotNullExpressionValue(l, "info.id");
                long longValue = l.longValue();
                String str = info.name;
                Intrinsics.checkNotNullExpressionValue(str, "info.name");
                String str2 = info.icon;
                Intrinsics.checkNotNullExpressionValue(str2, "info.icon");
                Long l2 = info.forumId;
                Intrinsics.checkNotNullExpressionValue(l2, "info.forumId");
                long longValue2 = l2.longValue();
                String str3 = info.forumName;
                Intrinsics.checkNotNullExpressionValue(str3, "info.forumName");
                Long l3 = info.chatCount;
                Intrinsics.checkNotNullExpressionValue(l3, "info.chatCount");
                return new ShareChatroomMsgData(longValue, str, str2, longValue2, str3, l3.longValue());
            }
            return (ShareChatroomMsgData) invokeL.objValue;
        }
    }

    public ShareChatroomMsgData(long j, String name, String icon, long j2, String forumName, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), name, icon, Long.valueOf(j2), forumName, Long.valueOf(j3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(forumName, "forumName");
        this.id = j;
        this.name = name;
        this.icon = icon;
        this.fid = j2;
        this.forumName = forumName;
        this.chatCount = j3;
    }

    public final long getChatCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.chatCount;
        }
        return invokeV.longValue;
    }

    public final long getFid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.fid;
        }
        return invokeV.longValue;
    }

    public final String getForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.forumName;
        }
        return (String) invokeV.objValue;
    }

    public final int getHasRead() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.hasRead;
        }
        return invokeV.intValue;
    }

    public final String getIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.icon;
        }
        return (String) invokeV.objValue;
    }

    public final long getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.id;
        }
        return invokeV.longValue;
    }

    public final String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.name;
        }
        return (String) invokeV.objValue;
    }

    public final String toEncodeContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", 1);
            jSONObject.put("chatroom_id", this.id);
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   … id)\n        }.toString()");
            return jSONObject2;
        }
        return (String) invokeV.objValue;
    }

    public final void setHasRead(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.hasRead = i;
        }
    }
}

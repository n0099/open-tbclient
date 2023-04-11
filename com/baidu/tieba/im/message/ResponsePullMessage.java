package com.baidu.tieba.im.message;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.a28;
import com.baidu.tieba.c28;
import com.baidu.tieba.d28;
import com.baidu.tieba.e28;
import com.baidu.tieba.e45;
import com.baidu.tieba.fz7;
import com.baidu.tieba.gb;
import com.baidu.tieba.gg;
import com.baidu.tieba.gm5;
import com.baidu.tieba.h08;
import com.baidu.tieba.hi;
import com.baidu.tieba.hz7;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.NotifyChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.im.message.chat.SystemMessage;
import com.baidu.tieba.im.message.chat.YYMessage;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.j08;
import com.baidu.tieba.jy7;
import com.baidu.tieba.jz7;
import com.baidu.tieba.ky7;
import com.baidu.tieba.kz7;
import com.baidu.tieba.ly7;
import com.baidu.tieba.my7;
import com.baidu.tieba.ny7;
import com.baidu.tieba.oy7;
import com.baidu.tieba.p08;
import com.baidu.tieba.p45;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import org.json.JSONArray;
import protobuf.GetGroupMsg.DataRes;
import protobuf.GetGroupMsg.GetGroupMsgResIdl;
import protobuf.GetGroupMsg.GroupMsg;
import protobuf.GroupInfo;
import protobuf.MsgInfo;
import protobuf.TshowInfo;
import protobuf.UserInfo;
/* loaded from: classes4.dex */
public class ResponsePullMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_DELETE_TEMP_ITEM_LIST = "KEY_DELETE_TEMP_ITEM_LIST";
    @NonNull
    public static final List<DeleteTempItem> sDeleteTempItemList;
    public transient /* synthetic */ FieldHolder $fh;
    public List<GroupMsgData> groupMsg;

    public boolean isPulledMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes4.dex */
    public static class DeleteTempItem implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int customGroupType;
        public final String gid;

        public DeleteTempItem(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.gid = str;
            this.customGroupType = i;
        }

        public static DeleteTempItem create(String str, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, str, i)) == null) {
                return new DeleteTempItem(str, i);
            }
            return (DeleteTempItem) invokeLI.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || DeleteTempItem.class != obj.getClass()) {
                    return false;
                }
                DeleteTempItem deleteTempItem = (DeleteTempItem) obj;
                if (this.customGroupType == deleteTempItem.customGroupType && Objects.equals(this.gid, deleteTempItem.gid)) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return Objects.hash(this.gid, Integer.valueOf(this.customGroupType));
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes4.dex */
    public class a implements jy7.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImMessageCenterPojo a;
        public final /* synthetic */ ResponsePullMessage b;

        public a(ResponsePullMessage responsePullMessage, ImMessageCenterPojo imMessageCenterPojo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {responsePullMessage, imMessageCenterPojo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = responsePullMessage;
            this.a = imMessageCenterPojo;
        }

        @Override // com.baidu.tieba.jy7.b
        public void a(String str, List<CommonMsgPojo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, list) == null) {
                kz7.w().n(gg.g(str, 0L), list, true);
            }
        }

        @Override // com.baidu.tieba.jy7.b
        public void b(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
            ImMessageCenterPojo imMessageCenterPojo2;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{imMessageCenterPojo, Integer.valueOf(i), Boolean.valueOf(z)}) != null) || imMessageCenterPojo == null) {
                return;
            }
            e45.a("im", -1L, 0, "im_check: pull group id: " + p08.j + " pulled msg id: " + imMessageCenterPojo.getPulled_msgId(), -1, "", new Object[0]);
            int i2 = 2;
            if (!this.b.checkDeleteTempList(DeleteTempItem.create(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType()))) {
                hz7.f().l(imMessageCenterPojo, 2);
            }
            if (imMessageCenterPojo.getIsFriend() == 0 && (imMessageCenterPojo2 = this.a) != null) {
                imMessageCenterPojo2.setGid(TbEnum.CustomGroupId.STRANGE_MERGE);
                this.a.setCustomGroupType(-7);
                if (i == 0) {
                    this.a.setUnread_count(0);
                } else if (i == 1) {
                    this.a.setUnread_count(1);
                } else {
                    i2 = 1;
                }
                if (z) {
                    this.a.setIs_hidden(0);
                }
                hz7.f().l(this.a, i2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements jy7.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImMessageCenterPojo a;

        public b(ResponsePullMessage responsePullMessage, ImMessageCenterPojo imMessageCenterPojo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {responsePullMessage, imMessageCenterPojo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imMessageCenterPojo;
        }

        @Override // com.baidu.tieba.jy7.b
        public void a(String str, List<CommonMsgPojo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, list) == null) {
                jz7.w().n(gg.g(str, 0L), list, true);
            }
        }

        @Override // com.baidu.tieba.jy7.b
        public void b(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{imMessageCenterPojo, Integer.valueOf(i), Boolean.valueOf(z)}) != null) || imMessageCenterPojo == null) {
                return;
            }
            int i2 = 2;
            hz7.f().l(imMessageCenterPojo, 2);
            int userType = imMessageCenterPojo.getUserType();
            if (this.a != null) {
                if (userType == 1 || userType == 3) {
                    this.a.setGid(TbEnum.CustomGroupId.OFFICIAL_MERGE);
                    this.a.setCustomGroupType(-8);
                    if (i == 0) {
                        this.a.setUnread_count(0);
                    } else if (i == 1) {
                        this.a.setUnread_count(1);
                    } else {
                        i2 = 1;
                    }
                    if (z) {
                        this.a.setIs_hidden(0);
                    }
                    hz7.f().l(this.a, i2);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements jy7.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.jy7.b
        public void a(String str, List<CommonMsgPojo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, list) == null) {
            }
        }

        public c(ResponsePullMessage responsePullMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {responsePullMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.jy7.b
        public void b(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{imMessageCenterPojo, Integer.valueOf(i), Boolean.valueOf(z)}) != null) || imMessageCenterPojo == null) {
                return;
            }
            imMessageCenterPojo.setIs_hidden(1);
            hz7.f().k(imMessageCenterPojo);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements jy7.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.jy7.b
        public void a(String str, List<CommonMsgPojo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, list) == null) {
            }
        }

        public d(ResponsePullMessage responsePullMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {responsePullMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.jy7.b
        public void b(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{imMessageCenterPojo, Integer.valueOf(i), Boolean.valueOf(z)}) != null) || imMessageCenterPojo == null) {
                return;
            }
            imMessageCenterPojo.setIs_hidden(1);
            hz7.f().k(imMessageCenterPojo);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1259187199, "Lcom/baidu/tieba/im/message/ResponsePullMessage;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1259187199, "Lcom/baidu/tieba/im/message/ResponsePullMessage;");
                return;
            }
        }
        sDeleteTempItemList = new ArrayList();
        try {
            p45 m = p45.m();
            String s = m.s(KEY_DELETE_TEMP_ITEM_LIST, null);
            if (!TextUtils.isEmpty(s)) {
                sDeleteTempItemList.addAll(DataExt.toEntityList(s, DeleteTempItem.class));
                int n = m.n("KEY_DELETE_TEMP_ITEM_LISTcount", 0);
                if (n > 5) {
                    m.H(KEY_DELETE_TEMP_ITEM_LIST);
                    m.H("KEY_DELETE_TEMP_ITEM_LISTcount");
                } else {
                    m.z("KEY_DELETE_TEMP_ITEM_LISTcount", n + 1);
                }
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponsePullMessage() {
        super(202003);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public List<GroupMsgData> getGroupMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.groupMsg;
        }
        return (List) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponsePullMessage(int i) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    private boolean hasStranger(GroupMsgData groupMsgData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, groupMsgData)) == null) {
            if (groupMsgData != null && groupMsgData.getListMessage() != null && groupMsgData.getListMessage().size() != 0) {
                Iterator<ChatMessage> it = groupMsgData.getListMessage().iterator();
                while (it.hasNext()) {
                    if (it.next().getIsFriend() == 0) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void addDeleteTempItem(@NonNull DeleteTempItem deleteTempItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, deleteTempItem) == null) {
            sDeleteTempItemList.add(deleteTempItem);
            try {
                p45.m().B(KEY_DELETE_TEMP_ITEM_LIST, DataExt.toJson(sDeleteTempItemList));
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkDeleteTempList(@NonNull DeleteTempItem deleteTempItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, deleteTempItem)) == null) {
            return sDeleteTempItemList.contains(deleteTempItem);
        }
        return invokeL.booleanValue;
    }

    private void parseMsgConfig(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65546, this, str) != null) || hi.isEmpty(str)) {
        }
    }

    public void setGroupMsg(List<GroupMsgData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.groupMsg = list;
        }
    }

    public static long getTaskId(MsgInfo msgInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, msgInfo)) == null) {
            if (msgInfo == null) {
                return 0L;
            }
            if (!TextUtils.isEmpty(msgInfo.content)) {
                try {
                    JSONArray jSONArray = new JSONArray(msgInfo.content);
                    if (jSONArray.length() > 0) {
                        long g = gg.g(jSONArray.optJSONObject(0).optString("task_id"), 0L);
                        if (g > 0) {
                            return g;
                        }
                    }
                } catch (Exception unused) {
                }
            }
            return msgInfo.taskId.longValue();
        }
        return invokeL.longValue;
    }

    private GroupMsgData obtainGroupData(GroupInfo groupInfo) {
        InterceptResult invokeL;
        GroupMsgData groupMsgData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, groupInfo)) == null) {
            int intValue = groupInfo.groupType.intValue();
            if (intValue != 1) {
                if (intValue != 6) {
                    if (intValue != 8) {
                        if (intValue != 30) {
                            switch (intValue) {
                                case 10:
                                    groupMsgData = new GroupMsgData(2012126);
                                    groupMsgData.getGroupInfo().setCustomType(6);
                                    break;
                                case 11:
                                    groupMsgData = new GroupMsgData(2012126);
                                    groupMsgData.getGroupInfo().setCustomType(7);
                                    break;
                                case 12:
                                    groupMsgData = new GroupMsgData(2012126);
                                    groupMsgData.getGroupInfo().setCustomType(8);
                                    break;
                                default:
                                    groupMsgData = null;
                                    break;
                            }
                        } else {
                            BdLog.i("pullMessage groupType = 30");
                            groupMsgData = new GroupMsgData(2012129);
                            groupMsgData.getGroupInfo().setCustomType(-9);
                        }
                    } else {
                        groupMsgData = new GroupMsgData(2012124);
                        groupMsgData.getGroupInfo().setCustomType(5);
                    }
                } else {
                    BdLog.i("pullMessage groupType = 6");
                    groupMsgData = new GroupMsgData(2012128);
                    groupMsgData.getGroupInfo().setCustomType(-1);
                }
            } else {
                groupMsgData = new GroupMsgData(2012120);
                groupMsgData.getGroupInfo().setCustomType(-2);
            }
            if (groupMsgData != null) {
                groupMsgData.getGroupInfo().setGroupId(groupInfo.groupId.longValue());
                groupMsgData.getGroupInfo().setGroupType(groupInfo.groupType.intValue());
                BdLog.i("pullMessage groupid" + groupInfo.groupId);
            }
            return groupMsgData;
        }
        return (GroupMsgData) invokeL.objValue;
    }

    private ChatMessage obtainMessage(GroupInfo groupInfo, MsgInfo msgInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, this, groupInfo, msgInfo)) == null) {
            int intValue = groupInfo.groupType.intValue();
            if (intValue != 1) {
                if (intValue != 6) {
                    if (intValue != 8) {
                        if (intValue != 30) {
                            switch (intValue) {
                                case 10:
                                case 11:
                                case 12:
                                    return new YYMessage();
                                default:
                                    return null;
                            }
                        }
                        return new OfficialChatMessage();
                    }
                    return new NotifyChatMessage();
                }
                return new PersonalChatMessage();
            }
            return new SystemMessage();
        }
        return (ChatMessage) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0380  */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void beforeDispatchInBackGround(int i, byte[] bArr) {
        int i2;
        int i3;
        int i4;
        gb gbVar;
        gm5 gm5Var;
        int i5;
        long currentTimeMillis;
        gb gbVar2;
        String str;
        Iterator<GroupMsgData> it;
        ChatMessage chatMessage;
        LinkedList<ChatMessage> listMessage;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) {
            String str2 = TbEnum.CustomGroupId.OFFICIAL_MERGE;
            List<GroupMsgData> groupMsg = getGroupMsg();
            if (groupMsg != null && groupMsg.size() != 0) {
                Iterator<GroupMsgData> it2 = groupMsg.iterator();
                while (true) {
                    i2 = 4;
                    i3 = 0;
                    if (!it2.hasNext()) {
                        break;
                    }
                    GroupMsgData next = it2.next();
                    if (next.getGroupInfo() != null && next.getGroupInfo().getCustomType() == 4 && (listMessage = next.getListMessage()) != null && listMessage.size() != 0 && listMessage.get(0).getSid() > 0) {
                        h08.i().m(next, isPulledMessage());
                    }
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                try {
                    fz7.d().f();
                    Iterator<GroupMsgData> it3 = groupMsg.iterator();
                    ImMessageCenterPojo imMessageCenterPojo = null;
                    ImMessageCenterPojo imMessageCenterPojo2 = null;
                    i5 = 0;
                    while (it3.hasNext()) {
                        try {
                            GroupMsgData next2 = it3.next();
                            if (next2 != null && next2.getListMessage() != null) {
                                i5 += next2.getListMessage().size();
                                String valueOf = String.valueOf(next2.getGroupInfo().getGroupId());
                                int customType = next2.getGroupInfo().getCustomType();
                                int userType = next2.getGroupInfo().getUserType();
                                ImMessageCenterPojo g = hz7.f().g(valueOf, customType);
                                if (g != null) {
                                    g.setUserType(userType);
                                }
                                if (customType == i2 && imMessageCenterPojo == null && (imMessageCenterPojo = hz7.f().g(str2, -8)) == null) {
                                    imMessageCenterPojo = new ImMessageCenterPojo();
                                    imMessageCenterPojo.setGid(str2);
                                    imMessageCenterPojo.setCustomGroupType(-8);
                                    imMessageCenterPojo.setIs_hidden(1);
                                }
                                if (customType == 2 && imMessageCenterPojo2 == null && hasStranger(next2)) {
                                    ImMessageCenterPojo g2 = hz7.f().g(TbEnum.CustomGroupId.STRANGE_MERGE, -7);
                                    if (g2 == null) {
                                        g2 = new ImMessageCenterPojo();
                                        g2.setGid(TbEnum.CustomGroupId.STRANGE_MERGE);
                                        g2.setCustomGroupType(-7);
                                        g2.setIs_hidden(1);
                                    }
                                    imMessageCenterPojo2 = g2;
                                }
                                if (next2.getCmd() == 2012120) {
                                    ny7.d(next2);
                                } else if (next2.getCmd() == 2012121) {
                                    my7.b(next2, g, new a(this, imMessageCenterPojo2));
                                    my7.c(next2);
                                } else if (next2.getCmd() == 2012123) {
                                    ly7.a(next2, g, new b(this, imMessageCenterPojo));
                                } else if (next2.getCmd() == 2012128) {
                                    if (next2.getListMessage() != null && next2.getListMessage().size() != 0) {
                                        ChatMessage chatMessage2 = next2.getListMessage().get(i3);
                                        ImMessageCenterPojo imMessageCenterPojo3 = new ImMessageCenterPojo();
                                        imMessageCenterPojo3.setGid(String.valueOf(p08.j));
                                        imMessageCenterPojo3.setCustomGroupType(-1);
                                        imMessageCenterPojo3.setIs_hidden(1);
                                        imMessageCenterPojo3.setPulled_msgId(chatMessage2.getMsgId());
                                        hz7.f().k(imMessageCenterPojo3);
                                        BdLog.i("pullMessage insertMessagecent personal_Group gid = " + p08.j + " msgid = " + chatMessage2.getMsgId());
                                    }
                                } else {
                                    if (next2.getCmd() == 2012129) {
                                        if (next2.getListMessage() != null) {
                                            if (next2.getListMessage().size() != 0) {
                                                ChatMessage chatMessage3 = next2.getListMessage().get(i3);
                                                ImMessageCenterPojo imMessageCenterPojo4 = new ImMessageCenterPojo();
                                                imMessageCenterPojo4.setGid(String.valueOf(next2.getGroupInfo().getGroupId()));
                                                imMessageCenterPojo4.setCustomGroupType(-9);
                                                imMessageCenterPojo4.setIs_hidden(1);
                                                str = str2;
                                                it = it3;
                                                imMessageCenterPojo4.setPulled_msgId(chatMessage3.getMsgId());
                                                if (chatMessage3.getSid() <= 0) {
                                                    if (isPulledMessage()) {
                                                        imMessageCenterPojo4.setPushIds("");
                                                        j08.e().k();
                                                    } else if (chatMessage3.getUserInfo() != null) {
                                                        if (chatMessage3.getUserInfo().getUserType() == 4) {
                                                            Long f = j08.e().f();
                                                            if (f != null) {
                                                                chatMessage = chatMessage3;
                                                                if (f.longValue() != 0) {
                                                                    imMessageCenterPojo4.setPulled_msgId(0L);
                                                                    imMessageCenterPojo4.setPushIds(j08.e().h());
                                                                }
                                                            } else {
                                                                chatMessage = chatMessage3;
                                                            }
                                                            imMessageCenterPojo4.setPushIds("");
                                                        } else {
                                                            chatMessage = chatMessage3;
                                                        }
                                                        hz7.f().m(imMessageCenterPojo4, 1, 2);
                                                    }
                                                    chatMessage = chatMessage3;
                                                    hz7.f().m(imMessageCenterPojo4, 1, 2);
                                                } else {
                                                    chatMessage = chatMessage3;
                                                }
                                                BdLog.i("pullMessage insertMessagecent offical_Group gid = " + next2.getGroupInfo().getGroupId() + " msgid = " + chatMessage.getMsgId());
                                            }
                                        } else {
                                            str = str2;
                                            it = it3;
                                        }
                                    } else {
                                        str = str2;
                                        it = it3;
                                        if (next2.getCmd() == 2012124) {
                                            ky7.a(next2, g, new c(this));
                                        } else if (next2.getCmd() == 2012126) {
                                            if (next2.getGroupInfo().getGroupId() == 10) {
                                                oy7.d(next2, g, new d(this));
                                            } else {
                                                long[] a2 = oy7.b().a(next2);
                                                if (a2 != null) {
                                                    oy7.b().f(String.valueOf(a2[0]), d28.c(a2[1]));
                                                    str2 = str;
                                                    it3 = it;
                                                    i2 = 4;
                                                    i3 = 0;
                                                }
                                            }
                                        }
                                    }
                                    str2 = str;
                                    it3 = it;
                                    i2 = 4;
                                    i3 = 0;
                                }
                            }
                            str = str2;
                            it = it3;
                            str2 = str;
                            it3 = it;
                            i2 = 4;
                            i3 = 0;
                        } catch (Exception e) {
                            e = e;
                            i4 = i5;
                            try {
                                BdLog.e(e.getMessage());
                                fz7.d().b();
                                long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
                                gm5Var = new gm5();
                                getCmd();
                                gb gbVar3 = this.performanceData;
                                if (gbVar3 != null) {
                                    gm5Var.b = gbVar3.f;
                                    gm5Var.c = getDownSize();
                                    gm5Var.d = currentTimeMillis3;
                                    gm5Var.e = i4;
                                    gm5Var.f = this.performanceData.c;
                                    gm5Var.a(1002);
                                    gm5Var.f();
                                }
                                return;
                            } catch (Throwable th) {
                                th = th;
                                fz7.d().b();
                                long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis2;
                                gm5 gm5Var2 = new gm5();
                                getCmd();
                                gbVar = this.performanceData;
                                if (gbVar != null) {
                                    gm5Var2.b = gbVar.f;
                                    gm5Var2.c = getDownSize();
                                    gm5Var2.d = currentTimeMillis4;
                                    gm5Var2.e = i4;
                                    gm5Var2.f = this.performanceData.c;
                                    gm5Var2.a(1002);
                                    gm5Var2.f();
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            i4 = i5;
                            fz7.d().b();
                            long currentTimeMillis42 = System.currentTimeMillis() - currentTimeMillis2;
                            gm5 gm5Var22 = new gm5();
                            getCmd();
                            gbVar = this.performanceData;
                            if (gbVar != null) {
                            }
                            throw th;
                        }
                    }
                    fz7.d().b();
                    currentTimeMillis = System.currentTimeMillis() - currentTimeMillis2;
                    gm5Var = new gm5();
                    getCmd();
                    gbVar2 = this.performanceData;
                } catch (Exception e2) {
                    e = e2;
                    i4 = 0;
                } catch (Throwable th3) {
                    th = th3;
                    i4 = 0;
                }
                if (gbVar2 != null) {
                    gm5Var.b = gbVar2.f;
                    gm5Var.c = getDownSize();
                    gm5Var.d = currentTimeMillis;
                    gm5Var.e = i5;
                    gm5Var.f = this.performanceData.c;
                    gm5Var.a(1002);
                    gm5Var.f();
                }
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(27:42|43|44|45|46|47|48|(1:238)(1:52)|53|(4:205|206|(5:208|209|(9:213|214|215|216|217|218|219|210|211)|227|228)(1:234)|229)(1:55)|56|(1:58)|59|(2:61|(3:63|(1:65)(1:67)|66))(3:178|(2:180|(4:182|183|118|119))(2:184|(2:186|(4:188|183|118|119))(3:189|190|(15:192|(1:194)(1:199)|195|(4:197|198|118|119)|69|70|(1:72)|73|(3:77|78|(10:80|81|82|83|(1:86)|87|(7:89|(1:91)(1:133)|92|(3:120|121|(4:123|(1:125)(1:126)|95|(3:97|(1:99)(2:114|(1:116))|(2:104|(1:106)(3:107|(3:109|(1:111)|112)|113))(1:103))))|94|95|(0))(2:134|(2:136|(4:138|(1:140)(1:165)|141|(9:143|(2:145|146)(4:160|161|162|(1:164))|147|148|149|150|(1:152)|153|154)))(2:166|167))|117|118|119))|174|87|(0)(0)|117|118|119)(13:200|(4:204|198|118|119)|69|70|(0)|73|(4:75|77|78|(0))|174|87|(0)(0)|117|118|119)))|38)|68|69|70|(0)|73|(0)|174|87|(0)(0)|117|118|119|38) */
    /* JADX WARN: Code restructure failed: missing block: B:209:0x0561, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x0562, code lost:
        r9 = r4;
     */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0329 A[Catch: Exception -> 0x0561, TryCatch #12 {Exception -> 0x0561, blocks: (B:117:0x02e8, B:119:0x0329, B:120:0x0338, B:122:0x0342, B:139:0x0375, B:141:0x037b, B:143:0x038d, B:144:0x0394, B:137:0x0370, B:108:0x02c3, B:110:0x02c9, B:112:0x02d0, B:114:0x02dc, B:116:0x02e2), top: B:258:0x02e8 }] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0342 A[Catch: Exception -> 0x0561, TRY_LEAVE, TryCatch #12 {Exception -> 0x0561, blocks: (B:117:0x02e8, B:119:0x0329, B:120:0x0338, B:122:0x0342, B:139:0x0375, B:141:0x037b, B:143:0x038d, B:144:0x0394, B:137:0x0370, B:108:0x02c3, B:110:0x02c9, B:112:0x02d0, B:114:0x02dc, B:116:0x02e2), top: B:258:0x02e8 }] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0357 A[Catch: Exception -> 0x036e, TRY_LEAVE, TryCatch #1 {Exception -> 0x036e, blocks: (B:124:0x0348, B:126:0x0357), top: B:236:0x0348 }] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x037b A[Catch: Exception -> 0x0561, TryCatch #12 {Exception -> 0x0561, blocks: (B:117:0x02e8, B:119:0x0329, B:120:0x0338, B:122:0x0342, B:139:0x0375, B:141:0x037b, B:143:0x038d, B:144:0x0394, B:137:0x0370, B:108:0x02c3, B:110:0x02c9, B:112:0x02d0, B:114:0x02dc, B:116:0x02e2), top: B:258:0x02e8 }] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x03c5 A[Catch: Exception -> 0x055d, TryCatch #8 {Exception -> 0x055d, blocks: (B:147:0x03a0, B:149:0x03a4, B:151:0x03ae, B:156:0x03c5, B:158:0x03cb, B:163:0x03ea, B:165:0x03f8, B:166:0x03ff, B:168:0x0407, B:169:0x040e, B:171:0x0418, B:173:0x046c, B:174:0x0479, B:175:0x0491, B:159:0x03cf, B:161:0x03e2, B:152:0x03b7, B:176:0x04a3, B:178:0x04a9, B:181:0x04bf, B:183:0x04d1, B:187:0x04e2, B:189:0x04e8, B:184:0x04d8), top: B:250:0x03a0 }] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x04a3 A[Catch: Exception -> 0x055d, TryCatch #8 {Exception -> 0x055d, blocks: (B:147:0x03a0, B:149:0x03a4, B:151:0x03ae, B:156:0x03c5, B:158:0x03cb, B:163:0x03ea, B:165:0x03f8, B:166:0x03ff, B:168:0x0407, B:169:0x040e, B:171:0x0418, B:173:0x046c, B:174:0x0479, B:175:0x0491, B:159:0x03cf, B:161:0x03e2, B:152:0x03b7, B:176:0x04a3, B:178:0x04a9, B:181:0x04bf, B:183:0x04d1, B:187:0x04e2, B:189:0x04e8, B:184:0x04d8), top: B:250:0x03a0 }] */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        int size;
        GroupInfo groupInfo;
        boolean z;
        int size2;
        GetGroupMsgResIdl getGroupMsgResIdl;
        int i2;
        GroupInfo groupInfo2;
        List<MsgInfo> list;
        int i3;
        HashMap hashMap;
        MsgInfo msgInfo;
        ChatMessage obtainMessage;
        int i4;
        boolean z2;
        HashMap hashMap2;
        long longValue;
        long longValue2;
        int intValue;
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, bArr)) == null) {
            GetGroupMsgResIdl getGroupMsgResIdl2 = (GetGroupMsgResIdl) new Wire(new Class[0]).parseFrom(bArr, GetGroupMsgResIdl.class);
            setError(getGroupMsgResIdl2.error.errorno.intValue());
            setErrorString(getGroupMsgResIdl2.error.usermsg);
            if (getError() != 0) {
                return getGroupMsgResIdl2;
            }
            DataRes dataRes = getGroupMsgResIdl2.data;
            if (dataRes == null) {
                return getGroupMsgResIdl2;
            }
            parseMsgConfig(dataRes.config);
            setGroupMsg(new LinkedList());
            HashMap hashMap3 = new HashMap();
            HashMap hashMap4 = new HashMap();
            List<GroupMsg> list2 = getGroupMsgResIdl2.data.groupMsg;
            if (list2 == null) {
                size = 0;
            } else {
                size = list2.size();
            }
            int i5 = 0;
            while (i5 < size) {
                GroupMsg groupMsg = getGroupMsgResIdl2.data.groupMsg.get(i5);
                if (groupMsg != null && (groupInfo = groupMsg.groupInfo) != null) {
                    GroupMsgData obtainGroupData = obtainGroupData(groupInfo);
                    if (obtainGroupData == null) {
                        BdLog.e("obtainGroupData == null !!!!");
                    } else {
                        getGroupMsg().add(obtainGroupData);
                        LinkedList<ChatMessage> linkedList = new LinkedList<>();
                        obtainGroupData.setListMessageData(linkedList);
                        if (groupMsg.hasMore.intValue() != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        obtainGroupData.setHasMore(z);
                        List<MsgInfo> list3 = groupMsg.msgList;
                        if (list3 != null && (size2 = list3.size()) > 0) {
                            int i6 = 0;
                            while (i6 < size2) {
                                try {
                                    msgInfo = list3.get(i6);
                                } catch (Exception e) {
                                    e = e;
                                    getGroupMsgResIdl = getGroupMsgResIdl2;
                                }
                                if (msgInfo != null && (obtainMessage = obtainMessage(groupInfo, msgInfo)) != null) {
                                    getGroupMsgResIdl = getGroupMsgResIdl2;
                                    try {
                                        long a2 = d28.a(msgInfo.msgId.longValue());
                                        obtainMessage.setMsgId(a2);
                                        obtainMessage.setGroupId(String.valueOf(msgInfo.groupId));
                                        obtainMessage.setMsgType(msgInfo.msgType.intValue());
                                        i4 = i6;
                                        try {
                                            long longValue3 = msgInfo.userId.longValue();
                                            obtainMessage.setUserId(longValue3);
                                            if (TbadkCoreApplication.isLogin() && String.valueOf(longValue3).equals(TbadkCoreApplication.getCurrentAccount())) {
                                                obtainMessage.setRecordId(msgInfo.recordId.longValue());
                                            } else {
                                                obtainMessage.setRecordId(a2);
                                            }
                                            UserData userData = new UserData();
                                            obtainMessage.setUserInfo(userData);
                                            UserInfo userInfo = msgInfo.userInfo;
                                            if (userInfo != null) {
                                                try {
                                                    List<TshowInfo> list4 = userInfo.tshowIcon;
                                                    if (list4 != null) {
                                                        ArrayList<IconData> arrayList = new ArrayList<>();
                                                        i2 = size;
                                                        int i7 = 0;
                                                        while (i7 < list4.size()) {
                                                            try {
                                                                TshowInfo tshowInfo = list4.get(i7);
                                                                List<TshowInfo> list5 = list4;
                                                                groupInfo2 = groupInfo;
                                                                try {
                                                                    list = list3;
                                                                } catch (Exception e2) {
                                                                    e = e2;
                                                                    list = list3;
                                                                    hashMap = hashMap3;
                                                                    i3 = i4;
                                                                    e.printStackTrace();
                                                                    i6 = i3 + 1;
                                                                    getGroupMsgResIdl2 = getGroupMsgResIdl;
                                                                    hashMap3 = hashMap;
                                                                    size = i2;
                                                                    groupInfo = groupInfo2;
                                                                    list3 = list;
                                                                }
                                                                try {
                                                                    arrayList.add(new IconData(tshowInfo.icon, tshowInfo.name, tshowInfo.url));
                                                                    i7++;
                                                                    list4 = list5;
                                                                    groupInfo = groupInfo2;
                                                                    list3 = list;
                                                                } catch (Exception e3) {
                                                                    e = e3;
                                                                    hashMap = hashMap3;
                                                                    i3 = i4;
                                                                    e.printStackTrace();
                                                                    i6 = i3 + 1;
                                                                    getGroupMsgResIdl2 = getGroupMsgResIdl;
                                                                    hashMap3 = hashMap;
                                                                    size = i2;
                                                                    groupInfo = groupInfo2;
                                                                    list3 = list;
                                                                }
                                                            } catch (Exception e4) {
                                                                e = e4;
                                                                groupInfo2 = groupInfo;
                                                                list = list3;
                                                                hashMap = hashMap3;
                                                                i3 = i4;
                                                                e.printStackTrace();
                                                                i6 = i3 + 1;
                                                                getGroupMsgResIdl2 = getGroupMsgResIdl;
                                                                hashMap3 = hashMap;
                                                                size = i2;
                                                                groupInfo = groupInfo2;
                                                                list3 = list;
                                                            }
                                                        }
                                                        groupInfo2 = groupInfo;
                                                        list = list3;
                                                        userData.setTShowInfo(arrayList);
                                                    } else {
                                                        i2 = size;
                                                        groupInfo2 = groupInfo;
                                                        list = list3;
                                                    }
                                                    obtainMessage.getUserInfo().setUserId(String.valueOf(userInfo.userId));
                                                    obtainMessage.getUserInfo().setUserName(userInfo.userName);
                                                    obtainMessage.getUserInfo().setName_show(userInfo.userNameShow);
                                                    obtainMessage.getUserInfo().setPortrait(userInfo.portrait);
                                                    obtainMessage.getUserInfo().setImBjhAvatar(userInfo.bjhAvatar);
                                                    obtainMessage.getUserInfo().setSex(userInfo.sex.intValue());
                                                    obtainMessage.getUserInfo().setUserType(userInfo.userType.intValue());
                                                } catch (Exception e5) {
                                                    e = e5;
                                                    i2 = size;
                                                }
                                            } else {
                                                i2 = size;
                                                groupInfo2 = groupInfo;
                                                list = list3;
                                            }
                                            obtainMessage.setToUserInfo(new UserData());
                                            UserInfo userInfo2 = msgInfo.toUserInfo;
                                            if (userInfo2 != null) {
                                                obtainMessage.getToUserInfo().setUserId(String.valueOf(userInfo2.userId));
                                                obtainMessage.getToUserInfo().setUserName(userInfo2.userName);
                                                obtainMessage.getToUserInfo().setName_show(userInfo2.userNameShow);
                                                obtainMessage.getToUserInfo().setPortrait(userInfo2.portrait);
                                                obtainMessage.getToUserInfo().setImBjhAvatar(userInfo2.bjhAvatar);
                                                obtainMessage.getToUserInfo().setSex(userInfo2.sex.intValue());
                                                obtainMessage.getToUserInfo().setUserType(userInfo2.userType.intValue());
                                            }
                                            obtainMessage.setToUserId(msgInfo.toUid.longValue());
                                            obtainMessage.setContent(msgInfo.content);
                                            BdLog.i("pullMessage content" + msgInfo.content);
                                        } catch (Exception e6) {
                                            e = e6;
                                            i2 = size;
                                            groupInfo2 = groupInfo;
                                            list = list3;
                                            i3 = i4;
                                            hashMap = hashMap3;
                                            e.printStackTrace();
                                            i6 = i3 + 1;
                                            getGroupMsgResIdl2 = getGroupMsgResIdl;
                                            hashMap3 = hashMap;
                                            size = i2;
                                            groupInfo = groupInfo2;
                                            list3 = list;
                                        }
                                    } catch (Exception e7) {
                                        e = e7;
                                        i2 = size;
                                        groupInfo2 = groupInfo;
                                        list = list3;
                                        i3 = i6;
                                        hashMap = hashMap3;
                                        e.printStackTrace();
                                        i6 = i3 + 1;
                                        getGroupMsgResIdl2 = getGroupMsgResIdl;
                                        hashMap3 = hashMap;
                                        size = i2;
                                        groupInfo = groupInfo2;
                                        list3 = list;
                                    }
                                    if (msgInfo.msgType.intValue() == 3) {
                                        VoiceMsgData q = e28.q(obtainMessage);
                                        if (q != null) {
                                            if (e28.w(obtainMessage)) {
                                                q.setHas_read(1);
                                            } else {
                                                q.setHas_read(0);
                                            }
                                            String jsonStrWithObject = OrmObject.jsonStrWithObject(q);
                                            obtainMessage.setContent(PreferencesUtil.LEFT_MOUNT + jsonStrWithObject + PreferencesUtil.RIGHT_MOUNT);
                                        }
                                    } else {
                                        if (msgInfo.msgType.intValue() == 32) {
                                            if (!e28.u(obtainMessage, msgInfo)) {
                                                a28.a("分享『贴』32 ：数据解析失败，消息抛弃");
                                                hashMap = hashMap3;
                                                i3 = i4;
                                            }
                                        } else if (msgInfo.msgType.intValue() == 33) {
                                            if (!e28.t(obtainMessage, msgInfo)) {
                                                a28.a("分享『吧』33 ：数据解析失败，消息抛弃");
                                                hashMap = hashMap3;
                                                i3 = i4;
                                            }
                                        } else if (msgInfo.msgType.intValue() == 34) {
                                            i3 = i4;
                                            if (i3 == size2 - 1) {
                                                z2 = true;
                                            } else {
                                                z2 = false;
                                            }
                                            if (!e28.r(obtainMessage, msgInfo, z2)) {
                                                a28.a("陪玩消息卡片 ：数据解析失败，消息抛弃");
                                                hashMap = hashMap3;
                                            }
                                            obtainMessage.setTime(msgInfo.createTime.intValue());
                                            obtainMessage.setIsFriend(msgInfo.relation.intValue());
                                            obtainMessage.setFollowStatus(msgInfo.isFriend.intValue());
                                            obtainMessage.setLink(msgInfo.link);
                                            obtainMessage.setStat(msgInfo.stat);
                                            obtainMessage.setTaskId(msgInfo.taskId.longValue());
                                            obtainMessage.setServiceId(msgInfo.serviceId.longValue());
                                            if (msgInfo.isRenderStlog.intValue() == 1) {
                                                c28.d(msgInfo.msgId.longValue(), msgInfo.msgType.intValue());
                                            }
                                            if (obtainMessage.getMsgType() == 9 && obtainMessage.getContent() != null) {
                                                try {
                                                    jSONArray = new JSONArray(obtainMessage.getContent());
                                                } catch (Exception e8) {
                                                    e = e8;
                                                }
                                                if (jSONArray.length() >= 2) {
                                                    String optString = jSONArray.optString(0);
                                                    try {
                                                        int optInt = jSONArray.optInt(1);
                                                        if (1 != optInt && 4 != optInt) {
                                                            obtainMessage.setMsgType(1);
                                                            obtainMessage.setContent(optString);
                                                        }
                                                    } catch (Exception e9) {
                                                        e = e9;
                                                        BdLog.e(e);
                                                        if (obtainMessage instanceof OfficialChatMessage) {
                                                        }
                                                        hashMap = hashMap2;
                                                        i6 = i3 + 1;
                                                        getGroupMsgResIdl2 = getGroupMsgResIdl;
                                                        hashMap3 = hashMap;
                                                        size = i2;
                                                        groupInfo = groupInfo2;
                                                        list3 = list;
                                                    }
                                                    if (obtainMessage instanceof OfficialChatMessage) {
                                                        long g = gg.g(TbadkCoreApplication.getCurrentAccount(), 0L);
                                                        if (g != msgInfo.userId.longValue()) {
                                                            longValue2 = msgInfo.userId.longValue();
                                                        } else {
                                                            longValue2 = msgInfo.toUid.longValue();
                                                        }
                                                        hashMap2 = hashMap3;
                                                        long j = longValue2;
                                                        if (msgInfo != null) {
                                                            try {
                                                                if (msgInfo.userInfo != null) {
                                                                    if (g != msgInfo.userId.longValue()) {
                                                                        intValue = msgInfo.userInfo.userType.intValue();
                                                                    } else {
                                                                        intValue = msgInfo.toUserInfo.userType.intValue();
                                                                    }
                                                                    if (j != 0) {
                                                                        if (linkedList.size() == 0) {
                                                                            linkedList.add(obtainMessage);
                                                                        } else if (linkedList.get(0).getMsgId() < obtainMessage.getMsgId()) {
                                                                            linkedList.remove(0);
                                                                            linkedList.add(obtainMessage);
                                                                        }
                                                                        if (intValue == 4 && j08.e().c(obtainMessage.getMsgId())) {
                                                                            BdLog.i("msg is contained in PushIdsCacheManager");
                                                                        } else if (obtainMessage.getMsgType() == 99) {
                                                                            BdLog.i("msg is MSG_UNSHOW_OPERATER_ACCOUNT");
                                                                        } else {
                                                                            if (hashMap4.get(String.valueOf(j)) == null) {
                                                                                GroupMsgData groupMsgData = new GroupMsgData(2012123);
                                                                                groupMsgData.getGroupInfo().setUserType(intValue);
                                                                                groupMsgData.getGroupInfo().setCustomType(4);
                                                                                groupMsgData.getGroupInfo().setGroupId(j);
                                                                                getGroupMsg().add(groupMsgData);
                                                                                groupMsgData.setListMessageData(new LinkedList<>());
                                                                                hashMap4.put(String.valueOf(j), groupMsgData);
                                                                                StatisticItem statisticItem = new StatisticItem("official_message_receive");
                                                                                statisticItem.param("msg_id", msgInfo.msgId.longValue());
                                                                                statisticItem.param("official_id", msgInfo.userId.longValue());
                                                                                if (msgInfo.userInfo != null) {
                                                                                    statisticItem.param("official_type", msgInfo.userInfo.userType.intValue());
                                                                                }
                                                                                statisticItem.param("operate_time", System.currentTimeMillis() / 1000);
                                                                                statisticItem.param("task_id", getTaskId(msgInfo));
                                                                                TiebaStatic.log(statisticItem);
                                                                            }
                                                                            ((GroupMsgData) hashMap4.get(String.valueOf(j))).getListMessage().add(obtainMessage);
                                                                        }
                                                                    }
                                                                }
                                                            } catch (Exception e10) {
                                                                e = e10;
                                                                hashMap = hashMap2;
                                                                e.printStackTrace();
                                                                i6 = i3 + 1;
                                                                getGroupMsgResIdl2 = getGroupMsgResIdl;
                                                                hashMap3 = hashMap;
                                                                size = i2;
                                                                groupInfo = groupInfo2;
                                                                list3 = list;
                                                            }
                                                        }
                                                        intValue = 1;
                                                        if (j != 0) {
                                                        }
                                                    } else {
                                                        hashMap2 = hashMap3;
                                                        if (obtainMessage instanceof PersonalChatMessage) {
                                                            if (!checkDeleteTempList(DeleteTempItem.create(String.valueOf(obtainMessage.getToUserId()), 2))) {
                                                                if (gg.g(TbadkCoreApplication.getCurrentAccount(), 0L) != msgInfo.userId.longValue()) {
                                                                    longValue = msgInfo.userId.longValue();
                                                                } else {
                                                                    longValue = msgInfo.toUid.longValue();
                                                                }
                                                                if (longValue != 0) {
                                                                    if (linkedList.size() == 0) {
                                                                        linkedList.add(obtainMessage);
                                                                    } else {
                                                                        try {
                                                                            if (linkedList.get(0).getMsgId() < obtainMessage.getMsgId()) {
                                                                                linkedList.remove(0);
                                                                                linkedList.add(obtainMessage);
                                                                            }
                                                                        } catch (Exception e11) {
                                                                            e = e11;
                                                                            hashMap = hashMap2;
                                                                            e.printStackTrace();
                                                                            i6 = i3 + 1;
                                                                            getGroupMsgResIdl2 = getGroupMsgResIdl;
                                                                            hashMap3 = hashMap;
                                                                            size = i2;
                                                                            groupInfo = groupInfo2;
                                                                            list3 = list;
                                                                        }
                                                                    }
                                                                    hashMap = hashMap2;
                                                                    try {
                                                                        if (hashMap.get(String.valueOf(longValue)) == null) {
                                                                            GroupMsgData groupMsgData2 = new GroupMsgData(2012121);
                                                                            groupMsgData2.getGroupInfo().setCustomType(2);
                                                                            groupMsgData2.getGroupInfo().setGroupId(longValue);
                                                                            getGroupMsg().add(groupMsgData2);
                                                                            groupMsgData2.setListMessageData(new LinkedList<>());
                                                                            hashMap.put(String.valueOf(longValue), groupMsgData2);
                                                                        }
                                                                        ((GroupMsgData) hashMap.get(String.valueOf(longValue))).getListMessage().add(obtainMessage);
                                                                    } catch (Exception e12) {
                                                                        e = e12;
                                                                        e.printStackTrace();
                                                                        i6 = i3 + 1;
                                                                        getGroupMsgResIdl2 = getGroupMsgResIdl;
                                                                        hashMap3 = hashMap;
                                                                        size = i2;
                                                                        groupInfo = groupInfo2;
                                                                        list3 = list;
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            hashMap = hashMap2;
                                                            linkedList.add(obtainMessage);
                                                        }
                                                    }
                                                    hashMap = hashMap2;
                                                }
                                            }
                                            if (obtainMessage instanceof OfficialChatMessage) {
                                            }
                                            hashMap = hashMap2;
                                        } else {
                                            i3 = i4;
                                            if (msgInfo.msgType.intValue() == 37 && !e28.s(obtainMessage, msgInfo)) {
                                                a28.a("分享『群聊』卡片 ：数据解析失败，消息抛弃");
                                                hashMap = hashMap3;
                                            }
                                            obtainMessage.setTime(msgInfo.createTime.intValue());
                                            obtainMessage.setIsFriend(msgInfo.relation.intValue());
                                            obtainMessage.setFollowStatus(msgInfo.isFriend.intValue());
                                            obtainMessage.setLink(msgInfo.link);
                                            obtainMessage.setStat(msgInfo.stat);
                                            obtainMessage.setTaskId(msgInfo.taskId.longValue());
                                            obtainMessage.setServiceId(msgInfo.serviceId.longValue());
                                            if (msgInfo.isRenderStlog.intValue() == 1) {
                                            }
                                            if (obtainMessage.getMsgType() == 9) {
                                                jSONArray = new JSONArray(obtainMessage.getContent());
                                                if (jSONArray.length() >= 2) {
                                                }
                                            }
                                            if (obtainMessage instanceof OfficialChatMessage) {
                                            }
                                            hashMap = hashMap2;
                                        }
                                        i6 = i3 + 1;
                                        getGroupMsgResIdl2 = getGroupMsgResIdl;
                                        hashMap3 = hashMap;
                                        size = i2;
                                        groupInfo = groupInfo2;
                                        list3 = list;
                                    }
                                    i3 = i4;
                                    obtainMessage.setTime(msgInfo.createTime.intValue());
                                    obtainMessage.setIsFriend(msgInfo.relation.intValue());
                                    obtainMessage.setFollowStatus(msgInfo.isFriend.intValue());
                                    obtainMessage.setLink(msgInfo.link);
                                    obtainMessage.setStat(msgInfo.stat);
                                    obtainMessage.setTaskId(msgInfo.taskId.longValue());
                                    obtainMessage.setServiceId(msgInfo.serviceId.longValue());
                                    if (msgInfo.isRenderStlog.intValue() == 1) {
                                    }
                                    if (obtainMessage.getMsgType() == 9) {
                                    }
                                    if (obtainMessage instanceof OfficialChatMessage) {
                                    }
                                    hashMap = hashMap2;
                                    i6 = i3 + 1;
                                    getGroupMsgResIdl2 = getGroupMsgResIdl;
                                    hashMap3 = hashMap;
                                    size = i2;
                                    groupInfo = groupInfo2;
                                    list3 = list;
                                }
                                getGroupMsgResIdl = getGroupMsgResIdl2;
                                i2 = size;
                                groupInfo2 = groupInfo;
                                list = list3;
                                i3 = i6;
                                hashMap = hashMap3;
                                i6 = i3 + 1;
                                getGroupMsgResIdl2 = getGroupMsgResIdl;
                                hashMap3 = hashMap;
                                size = i2;
                                groupInfo = groupInfo2;
                                list3 = list;
                            }
                        }
                    }
                }
                i5++;
                getGroupMsgResIdl2 = getGroupMsgResIdl2;
                hashMap3 = hashMap3;
                size = size;
            }
            GetGroupMsgResIdl getGroupMsgResIdl3 = getGroupMsgResIdl2;
            if (getGroupMsgResIdl3.data.userMsg == null) {
                return getGroupMsgResIdl3;
            }
            MessageUtils.generatePushData(getGroupMsg(), 30, getGroupMsgResIdl3.data.userMsg.msgs, null);
            return getGroupMsgResIdl3;
        }
        return invokeIL.objValue;
    }
}

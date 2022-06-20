package com.baidu.tieba.im.message;

import android.text.TextUtils;
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
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.GroupChatMessage;
import com.baidu.tieba.im.message.chat.NotifyChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.im.message.chat.SystemMessage;
import com.baidu.tieba.im.message.chat.YYMessage;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.d87;
import com.repackage.e57;
import com.repackage.f87;
import com.repackage.gb;
import com.repackage.h87;
import com.repackage.i87;
import com.repackage.j57;
import com.repackage.l57;
import com.repackage.l67;
import com.repackage.l85;
import com.repackage.n47;
import com.repackage.n57;
import com.repackage.n67;
import com.repackage.ng;
import com.repackage.o47;
import com.repackage.o57;
import com.repackage.oi;
import com.repackage.p47;
import com.repackage.q47;
import com.repackage.r47;
import com.repackage.s47;
import com.repackage.t47;
import com.repackage.t67;
import com.repackage.ws4;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import protobuf.GetGroupMsg.DataRes;
import protobuf.GetGroupMsg.GetGroupMsgResIdl;
import protobuf.GetGroupMsg.GroupMsg;
import protobuf.GroupInfo;
import protobuf.MsgInfo;
import protobuf.TshowInfo;
import protobuf.UserInfo;
/* loaded from: classes3.dex */
public class ResponsePullMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<GroupMsgData> groupMsg;

    /* loaded from: classes3.dex */
    public class a implements n47.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(ResponsePullMessage responsePullMessage) {
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

        @Override // com.repackage.n47.b
        public void a(String str, List<CommonMsgPojo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, list) == null) {
                e57.h().l(str, list, true);
            }
        }

        @Override // com.repackage.n47.b
        public void b(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{imMessageCenterPojo, Integer.valueOf(i), Boolean.valueOf(z)}) == null) || imMessageCenterPojo == null) {
                return;
            }
            l57.f().l(imMessageCenterPojo, 2);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements n47.b {
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

        @Override // com.repackage.n47.b
        public void a(String str, List<CommonMsgPojo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, list) == null) {
                o57.v().n(ng.g(str, 0L), list, true);
            }
        }

        @Override // com.repackage.n47.b
        public void b(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
            ImMessageCenterPojo imMessageCenterPojo2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{imMessageCenterPojo, Integer.valueOf(i), Boolean.valueOf(z)}) == null) || imMessageCenterPojo == null) {
                return;
            }
            ws4.a("im", -1L, 0, "im_check: pull group id: " + t67.j + " pulled msg id: " + imMessageCenterPojo.getPulled_msgId(), -1, "", new Object[0]);
            int i2 = 2;
            l57.f().l(imMessageCenterPojo, 2);
            if (imMessageCenterPojo.getIsFriend() != 0 || (imMessageCenterPojo2 = this.a) == null) {
                return;
            }
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
            l57.f().l(this.a, i2);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements n47.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImMessageCenterPojo a;

        public c(ResponsePullMessage responsePullMessage, ImMessageCenterPojo imMessageCenterPojo) {
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

        @Override // com.repackage.n47.b
        public void a(String str, List<CommonMsgPojo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, list) == null) {
                n57.v().n(ng.g(str, 0L), list, true);
            }
        }

        @Override // com.repackage.n47.b
        public void b(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{imMessageCenterPojo, Integer.valueOf(i), Boolean.valueOf(z)}) == null) || imMessageCenterPojo == null) {
                return;
            }
            int i2 = 2;
            l57.f().l(imMessageCenterPojo, 2);
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
                    l57.f().l(this.a, i2);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements n47.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        @Override // com.repackage.n47.b
        public void a(String str, List<CommonMsgPojo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, list) == null) {
            }
        }

        @Override // com.repackage.n47.b
        public void b(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{imMessageCenterPojo, Integer.valueOf(i), Boolean.valueOf(z)}) == null) || imMessageCenterPojo == null) {
                return;
            }
            imMessageCenterPojo.setIs_hidden(1);
            l57.f().k(imMessageCenterPojo);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements n47.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(ResponsePullMessage responsePullMessage) {
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

        @Override // com.repackage.n47.b
        public void a(String str, List<CommonMsgPojo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, list) == null) {
            }
        }

        @Override // com.repackage.n47.b
        public void b(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{imMessageCenterPojo, Integer.valueOf(i), Boolean.valueOf(z)}) == null) || imMessageCenterPojo == null) {
                return;
            }
            imMessageCenterPojo.setIs_hidden(1);
            l57.f().k(imMessageCenterPojo);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponsePullMessage() {
        super(202003);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static long getTaskId(MsgInfo msgInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, msgInfo)) == null) {
            if (msgInfo == null) {
                return 0L;
            }
            if (!TextUtils.isEmpty(msgInfo.content)) {
                try {
                    JSONArray jSONArray = new JSONArray(msgInfo.content);
                    if (jSONArray.length() > 0) {
                        long g = ng.g(jSONArray.optJSONObject(0).optString("task_id"), 0L);
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

    private boolean hasStranger(GroupMsgData groupMsgData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, groupMsgData)) == null) {
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

    private GroupMsgData obtainGroupData(GroupInfo groupInfo) {
        InterceptResult invokeL;
        GroupMsgData groupMsgData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, groupInfo)) == null) {
            int intValue = groupInfo.groupType.intValue();
            if (intValue == 8) {
                groupMsgData = new GroupMsgData(2012124);
                groupMsgData.getGroupInfo().setCustomType(5);
            } else if (intValue != 30) {
                switch (intValue) {
                    case 1:
                        groupMsgData = new GroupMsgData(2012120);
                        groupMsgData.getGroupInfo().setCustomType(-2);
                        break;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        groupMsgData = new GroupMsgData(2012125);
                        groupMsgData.getGroupInfo().setCustomType(1);
                        break;
                    case 6:
                        BdLog.i("pullMessage groupType = 6");
                        groupMsgData = new GroupMsgData(2012128);
                        groupMsgData.getGroupInfo().setCustomType(-1);
                        break;
                    default:
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
                }
            } else {
                BdLog.i("pullMessage groupType = 30");
                groupMsgData = new GroupMsgData(2012129);
                groupMsgData.getGroupInfo().setCustomType(-9);
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, this, groupInfo, msgInfo)) == null) {
            int intValue = groupInfo.groupType.intValue();
            if (intValue != 8) {
                if (intValue != 30) {
                    switch (intValue) {
                        case 1:
                            return new SystemMessage();
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            return new GroupChatMessage();
                        case 6:
                            return new PersonalChatMessage();
                        default:
                            switch (intValue) {
                                case 10:
                                case 11:
                                case 12:
                                    return new YYMessage();
                                default:
                                    return null;
                            }
                    }
                }
                return new OfficialChatMessage();
            }
            return new NotifyChatMessage();
        }
        return (ChatMessage) invokeLL.objValue;
    }

    private void parseMsgConfig(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65542, this, str) != null) || oi.isEmpty(str)) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x032a A[Catch: Exception -> 0x04ec, TryCatch #2 {Exception -> 0x04ec, blocks: (B:63:0x0140, B:66:0x0156, B:68:0x0162, B:70:0x01b2, B:72:0x01be, B:73:0x0209, B:75:0x0236, B:77:0x023c, B:79:0x0242, B:81:0x024b, B:80:0x0247, B:92:0x0297, B:94:0x02d8, B:95:0x02e7, B:97:0x02f1, B:114:0x0324, B:116:0x032a, B:118:0x033c, B:122:0x034d, B:124:0x0351, B:126:0x035b, B:131:0x0372, B:133:0x0378, B:138:0x0397, B:140:0x03a5, B:141:0x03ac, B:143:0x03b4, B:144:0x03bb, B:146:0x03c5, B:148:0x0419, B:149:0x0426, B:150:0x043f, B:134:0x037c, B:136:0x038f, B:127:0x0364, B:119:0x0343, B:151:0x0452, B:153:0x0456, B:155:0x0468, B:159:0x0479, B:161:0x047f, B:156:0x046f, B:112:0x031f, B:82:0x0269, B:84:0x0273, B:86:0x0279, B:87:0x0280, B:89:0x028a, B:91:0x0290), top: B:202:0x0140 }] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0452 A[Catch: Exception -> 0x04ec, TryCatch #2 {Exception -> 0x04ec, blocks: (B:63:0x0140, B:66:0x0156, B:68:0x0162, B:70:0x01b2, B:72:0x01be, B:73:0x0209, B:75:0x0236, B:77:0x023c, B:79:0x0242, B:81:0x024b, B:80:0x0247, B:92:0x0297, B:94:0x02d8, B:95:0x02e7, B:97:0x02f1, B:114:0x0324, B:116:0x032a, B:118:0x033c, B:122:0x034d, B:124:0x0351, B:126:0x035b, B:131:0x0372, B:133:0x0378, B:138:0x0397, B:140:0x03a5, B:141:0x03ac, B:143:0x03b4, B:144:0x03bb, B:146:0x03c5, B:148:0x0419, B:149:0x0426, B:150:0x043f, B:134:0x037c, B:136:0x038f, B:127:0x0364, B:119:0x0343, B:151:0x0452, B:153:0x0456, B:155:0x0468, B:159:0x0479, B:161:0x047f, B:156:0x046f, B:112:0x031f, B:82:0x0269, B:84:0x0273, B:86:0x0279, B:87:0x0280, B:89:0x028a, B:91:0x0290), top: B:202:0x0140 }] */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        DataRes dataRes;
        GroupInfo groupInfo;
        int size;
        GetGroupMsgResIdl getGroupMsgResIdl;
        int i2;
        GroupInfo groupInfo2;
        int i3;
        MsgInfo msgInfo;
        ChatMessage obtainMessage;
        long longValue;
        long longValue2;
        int i4;
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, bArr)) == null) {
            ResponsePullMessage responsePullMessage = this;
            GetGroupMsgResIdl getGroupMsgResIdl2 = (GetGroupMsgResIdl) new Wire(new Class[0]).parseFrom(bArr, GetGroupMsgResIdl.class);
            responsePullMessage.setError(getGroupMsgResIdl2.error.errorno.intValue());
            responsePullMessage.setErrorString(getGroupMsgResIdl2.error.usermsg);
            if (getError() == 0 && (dataRes = getGroupMsgResIdl2.data) != null) {
                responsePullMessage.parseMsgConfig(dataRes.config);
                responsePullMessage.setGroupMsg(new LinkedList());
                HashMap hashMap = new HashMap();
                HashMap hashMap2 = new HashMap();
                List<GroupMsg> list = getGroupMsgResIdl2.data.groupMsg;
                int size2 = list == null ? 0 : list.size();
                int i5 = 0;
                while (i5 < size2) {
                    GroupMsg groupMsg = getGroupMsgResIdl2.data.groupMsg.get(i5);
                    if (groupMsg != null && (groupInfo = groupMsg.groupInfo) != null) {
                        GroupMsgData obtainGroupData = responsePullMessage.obtainGroupData(groupInfo);
                        if (obtainGroupData == null) {
                            BdLog.e("obtainGroupData == null !!!!");
                        } else {
                            getGroupMsg().add(obtainGroupData);
                            LinkedList<ChatMessage> linkedList = new LinkedList<>();
                            obtainGroupData.setListMessageData(linkedList);
                            obtainGroupData.setHasMore(groupMsg.hasMore.intValue() != 0);
                            List<MsgInfo> list2 = groupMsg.msgList;
                            if (list2 != null && (size = list2.size()) > 0) {
                                int i6 = 0;
                                while (i6 < size) {
                                    try {
                                        msgInfo = list2.get(i6);
                                    } catch (Exception e2) {
                                        e = e2;
                                        getGroupMsgResIdl = getGroupMsgResIdl2;
                                    }
                                    if (msgInfo != null && (obtainMessage = responsePullMessage.obtainMessage(groupInfo, msgInfo)) != null) {
                                        getGroupMsgResIdl = getGroupMsgResIdl2;
                                        try {
                                            long a2 = h87.a(msgInfo.msgId.longValue());
                                            obtainMessage.setMsgId(a2);
                                            obtainMessage.setGroupId(String.valueOf(msgInfo.groupId));
                                            obtainMessage.setMsgType(msgInfo.msgType.intValue());
                                            i3 = i6;
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
                                                    List<TshowInfo> list3 = userInfo.tshowIcon;
                                                    if (list3 != null) {
                                                        ArrayList<IconData> arrayList = new ArrayList<>();
                                                        int i7 = 0;
                                                        while (i7 < list3.size()) {
                                                            TshowInfo tshowInfo = list3.get(i7);
                                                            List<TshowInfo> list4 = list3;
                                                            i2 = size2;
                                                            try {
                                                                groupInfo2 = groupInfo;
                                                                try {
                                                                    arrayList.add(new IconData(tshowInfo.icon, tshowInfo.name, tshowInfo.url));
                                                                    i7++;
                                                                    list3 = list4;
                                                                    size2 = i2;
                                                                    groupInfo = groupInfo2;
                                                                } catch (Exception e3) {
                                                                    e = e3;
                                                                    e.printStackTrace();
                                                                    i6 = i3 + 1;
                                                                    responsePullMessage = this;
                                                                    getGroupMsgResIdl2 = getGroupMsgResIdl;
                                                                    size2 = i2;
                                                                    groupInfo = groupInfo2;
                                                                }
                                                            } catch (Exception e4) {
                                                                e = e4;
                                                                groupInfo2 = groupInfo;
                                                                e.printStackTrace();
                                                                i6 = i3 + 1;
                                                                responsePullMessage = this;
                                                                getGroupMsgResIdl2 = getGroupMsgResIdl;
                                                                size2 = i2;
                                                                groupInfo = groupInfo2;
                                                            }
                                                        }
                                                        i2 = size2;
                                                        groupInfo2 = groupInfo;
                                                        userData.setTShowInfo(arrayList);
                                                    } else {
                                                        i2 = size2;
                                                        groupInfo2 = groupInfo;
                                                    }
                                                    obtainMessage.getUserInfo().setUserId(String.valueOf(userInfo.userId));
                                                    obtainMessage.getUserInfo().setUserName(userInfo.userName);
                                                    obtainMessage.getUserInfo().setName_show(userInfo.userNameShow);
                                                    obtainMessage.getUserInfo().setPortrait(userInfo.portrait);
                                                    obtainMessage.getUserInfo().setImBjhAvatar(userInfo.bjhAvatar);
                                                    obtainMessage.getUserInfo().setSex(userInfo.sex.intValue());
                                                    obtainMessage.getUserInfo().setUserType(userInfo.userType.intValue());
                                                } else {
                                                    i2 = size2;
                                                    groupInfo2 = groupInfo;
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
                                            } catch (Exception e5) {
                                                e = e5;
                                                i2 = size2;
                                            }
                                        } catch (Exception e6) {
                                            e = e6;
                                            i2 = size2;
                                            groupInfo2 = groupInfo;
                                            i3 = i6;
                                            e.printStackTrace();
                                            i6 = i3 + 1;
                                            responsePullMessage = this;
                                            getGroupMsgResIdl2 = getGroupMsgResIdl;
                                            size2 = i2;
                                            groupInfo = groupInfo2;
                                        }
                                        if (msgInfo.msgType.intValue() == 3) {
                                            VoiceMsgData p = i87.p(obtainMessage);
                                            if (p != null) {
                                                if (i87.t(obtainMessage)) {
                                                    p.setHas_read(1);
                                                } else {
                                                    p.setHas_read(0);
                                                }
                                                String jsonStrWithObject = OrmObject.jsonStrWithObject(p);
                                                obtainMessage.setContent(PreferencesUtil.LEFT_MOUNT + jsonStrWithObject + PreferencesUtil.RIGHT_MOUNT);
                                            }
                                        } else if (msgInfo.msgType.intValue() == 32) {
                                            if (!i87.r(obtainMessage, msgInfo)) {
                                                d87.a("分享『贴』32 ：数据解析失败，消息抛弃");
                                                i6 = i3 + 1;
                                                responsePullMessage = this;
                                                getGroupMsgResIdl2 = getGroupMsgResIdl;
                                                size2 = i2;
                                                groupInfo = groupInfo2;
                                            }
                                        } else if (msgInfo.msgType.intValue() == 33 && !i87.q(obtainMessage, msgInfo)) {
                                            d87.a("分享『吧』33 ：数据解析失败，消息抛弃");
                                            i6 = i3 + 1;
                                            responsePullMessage = this;
                                            getGroupMsgResIdl2 = getGroupMsgResIdl;
                                            size2 = i2;
                                            groupInfo = groupInfo2;
                                        }
                                        obtainMessage.setTime(msgInfo.createTime.intValue());
                                        obtainMessage.setIsFriend(msgInfo.relation.intValue());
                                        obtainMessage.setFollowStatus(msgInfo.isFriend.intValue());
                                        obtainMessage.setLink(msgInfo.link);
                                        obtainMessage.setStat(msgInfo.stat);
                                        obtainMessage.setTaskId(msgInfo.taskId.longValue());
                                        obtainMessage.setServiceId(msgInfo.serviceId.longValue());
                                        if (msgInfo.isRenderStlog.intValue() == 1) {
                                            f87.b(msgInfo.msgId.longValue(), msgInfo.msgType.intValue());
                                        }
                                        if (obtainMessage.getMsgType() == 9 && obtainMessage.getContent() != null) {
                                            try {
                                                jSONArray = new JSONArray(obtainMessage.getContent());
                                            } catch (Exception e7) {
                                                e = e7;
                                            }
                                            if (jSONArray.length() >= 2) {
                                                String optString = jSONArray.optString(0);
                                                try {
                                                    int optInt = jSONArray.optInt(1);
                                                    if (1 != optInt && 4 != optInt) {
                                                        obtainMessage.setMsgType(1);
                                                        obtainMessage.setContent(optString);
                                                    }
                                                } catch (Exception e8) {
                                                    e = e8;
                                                    BdLog.e(e);
                                                    if (obtainMessage instanceof OfficialChatMessage) {
                                                    }
                                                    i6 = i3 + 1;
                                                    responsePullMessage = this;
                                                    getGroupMsgResIdl2 = getGroupMsgResIdl;
                                                    size2 = i2;
                                                    groupInfo = groupInfo2;
                                                }
                                                if (obtainMessage instanceof OfficialChatMessage) {
                                                    long g = ng.g(TbadkCoreApplication.getCurrentAccount(), 0L);
                                                    if (g != msgInfo.userId.longValue()) {
                                                        longValue2 = msgInfo.userId.longValue();
                                                    } else {
                                                        longValue2 = msgInfo.toUid.longValue();
                                                    }
                                                    long j = longValue2;
                                                    if (msgInfo == null || msgInfo.userInfo == null) {
                                                        i4 = 1;
                                                    } else if (g != msgInfo.userId.longValue()) {
                                                        i4 = msgInfo.userInfo.userType.intValue();
                                                    } else {
                                                        i4 = msgInfo.toUserInfo.userType.intValue();
                                                    }
                                                    if (j != 0) {
                                                        if (linkedList.size() == 0) {
                                                            linkedList.add(obtainMessage);
                                                        } else if (linkedList.get(0).getMsgId() < obtainMessage.getMsgId()) {
                                                            linkedList.remove(0);
                                                            linkedList.add(obtainMessage);
                                                        }
                                                        if (i4 == 4 && n67.e().c(obtainMessage.getMsgId())) {
                                                            BdLog.i("msg is contained in PushIdsCacheManager");
                                                        } else if (obtainMessage.getMsgType() == 99) {
                                                            BdLog.i("msg is MSG_UNSHOW_OPERATER_ACCOUNT");
                                                        } else {
                                                            if (hashMap2.get(String.valueOf(j)) == null) {
                                                                GroupMsgData groupMsgData = new GroupMsgData(2012123);
                                                                groupMsgData.getGroupInfo().setUserType(i4);
                                                                groupMsgData.getGroupInfo().setCustomType(4);
                                                                groupMsgData.getGroupInfo().setGroupId(j);
                                                                getGroupMsg().add(groupMsgData);
                                                                groupMsgData.setListMessageData(new LinkedList<>());
                                                                hashMap2.put(String.valueOf(j), groupMsgData);
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
                                                            ((GroupMsgData) hashMap2.get(String.valueOf(j))).getListMessage().add(obtainMessage);
                                                        }
                                                    }
                                                } else {
                                                    if (obtainMessage instanceof PersonalChatMessage) {
                                                        if (ng.g(TbadkCoreApplication.getCurrentAccount(), 0L) != msgInfo.userId.longValue()) {
                                                            longValue = msgInfo.userId.longValue();
                                                        } else {
                                                            longValue = msgInfo.toUid.longValue();
                                                        }
                                                        if (longValue != 0) {
                                                            if (linkedList.size() == 0) {
                                                                linkedList.add(obtainMessage);
                                                            } else if (linkedList.get(0).getMsgId() < obtainMessage.getMsgId()) {
                                                                linkedList.remove(0);
                                                                linkedList.add(obtainMessage);
                                                            }
                                                            if (hashMap.get(String.valueOf(longValue)) == null) {
                                                                try {
                                                                    GroupMsgData groupMsgData2 = new GroupMsgData(2012121);
                                                                    groupMsgData2.getGroupInfo().setCustomType(2);
                                                                    groupMsgData2.getGroupInfo().setGroupId(longValue);
                                                                    getGroupMsg().add(groupMsgData2);
                                                                    groupMsgData2.setListMessageData(new LinkedList<>());
                                                                    hashMap.put(String.valueOf(longValue), groupMsgData2);
                                                                } catch (Exception e9) {
                                                                    e = e9;
                                                                    e.printStackTrace();
                                                                    i6 = i3 + 1;
                                                                    responsePullMessage = this;
                                                                    getGroupMsgResIdl2 = getGroupMsgResIdl;
                                                                    size2 = i2;
                                                                    groupInfo = groupInfo2;
                                                                }
                                                            }
                                                            ((GroupMsgData) hashMap.get(String.valueOf(longValue))).getListMessage().add(obtainMessage);
                                                        }
                                                    } else {
                                                        linkedList.add(obtainMessage);
                                                    }
                                                    i6 = i3 + 1;
                                                    responsePullMessage = this;
                                                    getGroupMsgResIdl2 = getGroupMsgResIdl;
                                                    size2 = i2;
                                                    groupInfo = groupInfo2;
                                                }
                                                i6 = i3 + 1;
                                                responsePullMessage = this;
                                                getGroupMsgResIdl2 = getGroupMsgResIdl;
                                                size2 = i2;
                                                groupInfo = groupInfo2;
                                            }
                                        }
                                        if (obtainMessage instanceof OfficialChatMessage) {
                                        }
                                        i6 = i3 + 1;
                                        responsePullMessage = this;
                                        getGroupMsgResIdl2 = getGroupMsgResIdl;
                                        size2 = i2;
                                        groupInfo = groupInfo2;
                                    }
                                    getGroupMsgResIdl = getGroupMsgResIdl2;
                                    i2 = size2;
                                    groupInfo2 = groupInfo;
                                    i3 = i6;
                                    i6 = i3 + 1;
                                    responsePullMessage = this;
                                    getGroupMsgResIdl2 = getGroupMsgResIdl;
                                    size2 = i2;
                                    groupInfo = groupInfo2;
                                }
                            }
                        }
                    }
                    i5++;
                    responsePullMessage = this;
                    getGroupMsgResIdl2 = getGroupMsgResIdl2;
                    size2 = size2;
                }
                GetGroupMsgResIdl getGroupMsgResIdl3 = getGroupMsgResIdl2;
                if (getGroupMsgResIdl3.data.userMsg == null) {
                    return getGroupMsgResIdl3;
                }
                MessageUtils.generatePushData(getGroupMsg(), 30, getGroupMsgResIdl3.data.userMsg.msgs, null);
                return getGroupMsgResIdl3;
            }
            return getGroupMsgResIdl2;
        }
        return invokeIL.objValue;
    }

    public List<GroupMsgData> getGroupMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.groupMsg : (List) invokeV.objValue;
    }

    public boolean isPulledMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void setGroupMsg(List<GroupMsgData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.groupMsg = list;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponsePullMessage(int i) {
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
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0390  */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void beforeDispatchInBackGround(int i, byte[] bArr) {
        int i2;
        int i3;
        int i4;
        gb gbVar;
        l85 l85Var;
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
            if (groupMsg == null || groupMsg.size() == 0) {
                return;
            }
            Iterator<GroupMsgData> it2 = groupMsg.iterator();
            while (true) {
                i2 = 4;
                i3 = 0;
                if (!it2.hasNext()) {
                    break;
                }
                GroupMsgData next = it2.next();
                if (next.getGroupInfo() != null && next.getGroupInfo().getCustomType() == 4 && (listMessage = next.getListMessage()) != null && listMessage.size() != 0 && listMessage.get(0).getSid() > 0) {
                    l67.i().m(next, isPulledMessage());
                }
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            try {
                j57.d().f();
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
                            ImMessageCenterPojo g = l57.f().g(valueOf, customType);
                            if (g != null) {
                                g.setUserType(userType);
                            }
                            if (customType == i2 && imMessageCenterPojo == null && (imMessageCenterPojo = l57.f().g(str2, -8)) == null) {
                                imMessageCenterPojo = new ImMessageCenterPojo();
                                imMessageCenterPojo.setGid(str2);
                                imMessageCenterPojo.setCustomGroupType(-8);
                                imMessageCenterPojo.setIs_hidden(1);
                            }
                            if (customType == 2 && imMessageCenterPojo2 == null && hasStranger(next2)) {
                                ImMessageCenterPojo g2 = l57.f().g(TbEnum.CustomGroupId.STRANGE_MERGE, -7);
                                if (g2 == null) {
                                    g2 = new ImMessageCenterPojo();
                                    g2.setGid(TbEnum.CustomGroupId.STRANGE_MERGE);
                                    g2.setCustomGroupType(-7);
                                    g2.setIs_hidden(1);
                                }
                                imMessageCenterPojo2 = g2;
                            }
                            if (next2.getCmd() == 2012125) {
                                o47.a(next2, g, new a(this));
                            } else if (next2.getCmd() == 2012120) {
                                s47.g(next2);
                            } else if (next2.getCmd() == 2012121) {
                                r47.b(next2, g, new b(this, imMessageCenterPojo2));
                            } else if (next2.getCmd() == 2012123) {
                                q47.a(next2, g, new c(this, imMessageCenterPojo));
                            } else if (next2.getCmd() == 2012128) {
                                if (next2.getListMessage() != null && next2.getListMessage().size() != 0) {
                                    ChatMessage chatMessage2 = next2.getListMessage().get(i3);
                                    ImMessageCenterPojo imMessageCenterPojo3 = new ImMessageCenterPojo();
                                    imMessageCenterPojo3.setGid(String.valueOf(t67.j));
                                    imMessageCenterPojo3.setCustomGroupType(-1);
                                    imMessageCenterPojo3.setIs_hidden(1);
                                    imMessageCenterPojo3.setPulled_msgId(chatMessage2.getMsgId());
                                    l57.f().k(imMessageCenterPojo3);
                                    BdLog.i("pullMessage insertMessagecent personal_Group gid = " + t67.j + " msgid = " + chatMessage2.getMsgId());
                                }
                            } else {
                                if (next2.getCmd() == 2012129) {
                                    if (next2.getListMessage() == null) {
                                        str = str2;
                                        it = it3;
                                    } else if (next2.getListMessage().size() != 0) {
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
                                                n67.e().k();
                                            } else if (chatMessage3.getUserInfo() != null) {
                                                if (chatMessage3.getUserInfo().getUserType() == 4) {
                                                    Long f = n67.e().f();
                                                    if (f != null) {
                                                        chatMessage = chatMessage3;
                                                        if (f.longValue() != 0) {
                                                            imMessageCenterPojo4.setPulled_msgId(0L);
                                                            imMessageCenterPojo4.setPushIds(n67.e().h());
                                                        }
                                                    } else {
                                                        chatMessage = chatMessage3;
                                                    }
                                                    imMessageCenterPojo4.setPushIds("");
                                                } else {
                                                    chatMessage = chatMessage3;
                                                }
                                                l57.f().m(imMessageCenterPojo4, 1, 2);
                                            }
                                            chatMessage = chatMessage3;
                                            l57.f().m(imMessageCenterPojo4, 1, 2);
                                        } else {
                                            chatMessage = chatMessage3;
                                        }
                                        BdLog.i("pullMessage insertMessagecent offical_Group gid = " + next2.getGroupInfo().getGroupId() + " msgid = " + chatMessage.getMsgId());
                                    }
                                } else {
                                    str = str2;
                                    it = it3;
                                    if (next2.getCmd() == 2012124) {
                                        p47.a(next2, g, new d(this));
                                    } else if (next2.getCmd() == 2012126) {
                                        if (next2.getGroupInfo().getGroupId() == 10) {
                                            t47.d(next2, g, new e(this));
                                        } else {
                                            long[] a2 = t47.b().a(next2);
                                            if (a2 != null) {
                                                t47.b().f(String.valueOf(a2[0]), h87.c(a2[1]));
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
                    } catch (Exception e2) {
                        e = e2;
                        i4 = i5;
                        try {
                            BdLog.e(e.getMessage());
                            j57.d().b();
                            long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
                            l85Var = new l85();
                            getCmd();
                            gb gbVar3 = this.performanceData;
                            if (gbVar3 != null) {
                                l85Var.b = gbVar3.f;
                                l85Var.c = getDownSize();
                                l85Var.d = currentTimeMillis3;
                                l85Var.e = i4;
                                l85Var.f = this.performanceData.c;
                                l85Var.a(1002);
                                l85Var.f();
                            }
                            return;
                        } catch (Throwable th) {
                            th = th;
                            j57.d().b();
                            long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis2;
                            l85 l85Var2 = new l85();
                            getCmd();
                            gbVar = this.performanceData;
                            if (gbVar != null) {
                                l85Var2.b = gbVar.f;
                                l85Var2.c = getDownSize();
                                l85Var2.d = currentTimeMillis4;
                                l85Var2.e = i4;
                                l85Var2.f = this.performanceData.c;
                                l85Var2.a(1002);
                                l85Var2.f();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        i4 = i5;
                        j57.d().b();
                        long currentTimeMillis42 = System.currentTimeMillis() - currentTimeMillis2;
                        l85 l85Var22 = new l85();
                        getCmd();
                        gbVar = this.performanceData;
                        if (gbVar != null) {
                        }
                        throw th;
                    }
                }
                j57.d().b();
                currentTimeMillis = System.currentTimeMillis() - currentTimeMillis2;
                l85Var = new l85();
                getCmd();
                gbVar2 = this.performanceData;
            } catch (Exception e3) {
                e = e3;
                i4 = 0;
            } catch (Throwable th3) {
                th = th3;
                i4 = 0;
            }
            if (gbVar2 != null) {
                l85Var.b = gbVar2.f;
                l85Var.c = getDownSize();
                l85Var.d = currentTimeMillis;
                l85Var.e = i5;
                l85Var.f = this.performanceData.c;
                l85Var.a(1002);
                l85Var.f();
            }
        }
    }
}

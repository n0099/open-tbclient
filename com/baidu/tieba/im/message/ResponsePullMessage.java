package com.baidu.tieba.im.message;

import android.text.TextUtils;
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
import com.repackage.a97;
import com.repackage.db;
import com.repackage.f67;
import com.repackage.k67;
import com.repackage.kt4;
import com.repackage.m67;
import com.repackage.m77;
import com.repackage.mg;
import com.repackage.n85;
import com.repackage.ni;
import com.repackage.o67;
import com.repackage.o77;
import com.repackage.p67;
import com.repackage.s57;
import com.repackage.t57;
import com.repackage.u57;
import com.repackage.v57;
import com.repackage.v77;
import com.repackage.w57;
import com.repackage.x57;
import com.repackage.y57;
import com.repackage.z87;
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
    public class a implements s57.b {
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

        @Override // com.repackage.s57.b
        public void a(String str, List<CommonMsgPojo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, list) == null) {
                f67.h().l(str, list, true);
            }
        }

        @Override // com.repackage.s57.b
        public void b(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{imMessageCenterPojo, Integer.valueOf(i), Boolean.valueOf(z)}) == null) || imMessageCenterPojo == null) {
                return;
            }
            m67.f().l(imMessageCenterPojo, 2);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements s57.b {
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

        @Override // com.repackage.s57.b
        public void a(String str, List<CommonMsgPojo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, list) == null) {
                p67.t().m(mg.g(str, 0L), list, true);
            }
        }

        @Override // com.repackage.s57.b
        public void b(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
            ImMessageCenterPojo imMessageCenterPojo2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{imMessageCenterPojo, Integer.valueOf(i), Boolean.valueOf(z)}) == null) || imMessageCenterPojo == null) {
                return;
            }
            kt4.a("im", -1L, 0, "im_check: pull group id: " + v77.i + " pulled msg id: " + imMessageCenterPojo.getPulled_msgId(), -1, "", new Object[0]);
            int i2 = 2;
            m67.f().l(imMessageCenterPojo, 2);
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
            m67.f().l(this.a, i2);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements s57.b {
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

        @Override // com.repackage.s57.b
        public void a(String str, List<CommonMsgPojo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, list) == null) {
                o67.t().m(mg.g(str, 0L), list, true);
            }
        }

        @Override // com.repackage.s57.b
        public void b(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{imMessageCenterPojo, Integer.valueOf(i), Boolean.valueOf(z)}) == null) || imMessageCenterPojo == null) {
                return;
            }
            int i2 = 2;
            m67.f().l(imMessageCenterPojo, 2);
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
                    m67.f().l(this.a, i2);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements s57.b {
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

        @Override // com.repackage.s57.b
        public void a(String str, List<CommonMsgPojo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, list) == null) {
            }
        }

        @Override // com.repackage.s57.b
        public void b(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{imMessageCenterPojo, Integer.valueOf(i), Boolean.valueOf(z)}) == null) || imMessageCenterPojo == null) {
                return;
            }
            imMessageCenterPojo.setIs_hidden(1);
            m67.f().k(imMessageCenterPojo);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements s57.b {
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

        @Override // com.repackage.s57.b
        public void a(String str, List<CommonMsgPojo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, list) == null) {
            }
        }

        @Override // com.repackage.s57.b
        public void b(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{imMessageCenterPojo, Integer.valueOf(i), Boolean.valueOf(z)}) == null) || imMessageCenterPojo == null) {
                return;
            }
            imMessageCenterPojo.setIs_hidden(1);
            m67.f().k(imMessageCenterPojo);
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
                        long g = mg.g(jSONArray.optJSONObject(0).optString("task_id"), 0L);
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
        if ((interceptable != null && interceptable.invokeL(65542, this, str) != null) || ni.isEmpty(str)) {
        }
    }

    public List<GroupMsgData> getGroupMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.groupMsg : (List) invokeV.objValue;
    }

    public boolean isPulledMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void setGroupMsg(List<GroupMsgData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
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
        db dbVar;
        n85 n85Var;
        int i5;
        long currentTimeMillis;
        db dbVar2;
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
                    m77.i().m(next, isPulledMessage());
                }
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            try {
                k67.d().f();
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
                            ImMessageCenterPojo g = m67.f().g(valueOf, customType);
                            if (g != null) {
                                g.setUserType(userType);
                            }
                            if (customType == i2 && imMessageCenterPojo == null && (imMessageCenterPojo = m67.f().g(str2, -8)) == null) {
                                imMessageCenterPojo = new ImMessageCenterPojo();
                                imMessageCenterPojo.setGid(str2);
                                imMessageCenterPojo.setCustomGroupType(-8);
                                imMessageCenterPojo.setIs_hidden(1);
                            }
                            if (customType == 2 && imMessageCenterPojo2 == null && hasStranger(next2)) {
                                ImMessageCenterPojo g2 = m67.f().g(TbEnum.CustomGroupId.STRANGE_MERGE, -7);
                                if (g2 == null) {
                                    g2 = new ImMessageCenterPojo();
                                    g2.setGid(TbEnum.CustomGroupId.STRANGE_MERGE);
                                    g2.setCustomGroupType(-7);
                                    g2.setIs_hidden(1);
                                }
                                imMessageCenterPojo2 = g2;
                            }
                            if (next2.getCmd() == 2012125) {
                                t57.a(next2, g, new a(this));
                            } else if (next2.getCmd() == 2012120) {
                                x57.g(next2);
                            } else if (next2.getCmd() == 2012121) {
                                w57.b(next2, g, new b(this, imMessageCenterPojo2));
                            } else if (next2.getCmd() == 2012123) {
                                v57.a(next2, g, new c(this, imMessageCenterPojo));
                            } else if (next2.getCmd() == 2012128) {
                                if (next2.getListMessage() != null && next2.getListMessage().size() != 0) {
                                    ChatMessage chatMessage2 = next2.getListMessage().get(i3);
                                    ImMessageCenterPojo imMessageCenterPojo3 = new ImMessageCenterPojo();
                                    imMessageCenterPojo3.setGid(String.valueOf(v77.i));
                                    imMessageCenterPojo3.setCustomGroupType(-1);
                                    imMessageCenterPojo3.setIs_hidden(1);
                                    imMessageCenterPojo3.setPulled_msgId(chatMessage2.getMsgId());
                                    m67.f().k(imMessageCenterPojo3);
                                    BdLog.i("pullMessage insertMessagecent personal_Group gid = " + v77.i + " msgid = " + chatMessage2.getMsgId());
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
                                                o77.e().k();
                                            } else if (chatMessage3.getUserInfo() != null) {
                                                if (chatMessage3.getUserInfo().getUserType() == 4) {
                                                    Long f = o77.e().f();
                                                    if (f != null) {
                                                        chatMessage = chatMessage3;
                                                        if (f.longValue() != 0) {
                                                            imMessageCenterPojo4.setPulled_msgId(0L);
                                                            imMessageCenterPojo4.setPushIds(o77.e().h());
                                                        }
                                                    } else {
                                                        chatMessage = chatMessage3;
                                                    }
                                                    imMessageCenterPojo4.setPushIds("");
                                                } else {
                                                    chatMessage = chatMessage3;
                                                }
                                                m67.f().m(imMessageCenterPojo4, 1, 2);
                                            }
                                            chatMessage = chatMessage3;
                                            m67.f().m(imMessageCenterPojo4, 1, 2);
                                        } else {
                                            chatMessage = chatMessage3;
                                        }
                                        BdLog.i("pullMessage insertMessagecent offical_Group gid = " + next2.getGroupInfo().getGroupId() + " msgid = " + chatMessage.getMsgId());
                                    }
                                } else {
                                    str = str2;
                                    it = it3;
                                    if (next2.getCmd() == 2012124) {
                                        u57.a(next2, g, new d(this));
                                    } else if (next2.getCmd() == 2012126) {
                                        if (next2.getGroupInfo().getGroupId() == 10) {
                                            y57.d(next2, g, new e(this));
                                        } else {
                                            long[] a2 = y57.b().a(next2);
                                            if (a2 != null) {
                                                y57.b().f(String.valueOf(a2[0]), z87.c(a2[1]));
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
                            k67.d().b();
                            long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
                            n85Var = new n85();
                            getCmd();
                            db dbVar3 = this.performanceData;
                            if (dbVar3 != null) {
                                n85Var.b = dbVar3.f;
                                n85Var.c = getDownSize();
                                n85Var.d = currentTimeMillis3;
                                n85Var.e = i4;
                                n85Var.f = this.performanceData.c;
                                n85Var.a(1002);
                                n85Var.f();
                            }
                            return;
                        } catch (Throwable th) {
                            th = th;
                            k67.d().b();
                            long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis2;
                            n85 n85Var2 = new n85();
                            getCmd();
                            dbVar = this.performanceData;
                            if (dbVar != null) {
                                n85Var2.b = dbVar.f;
                                n85Var2.c = getDownSize();
                                n85Var2.d = currentTimeMillis4;
                                n85Var2.e = i4;
                                n85Var2.f = this.performanceData.c;
                                n85Var2.a(1002);
                                n85Var2.f();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        i4 = i5;
                        k67.d().b();
                        long currentTimeMillis42 = System.currentTimeMillis() - currentTimeMillis2;
                        n85 n85Var22 = new n85();
                        getCmd();
                        dbVar = this.performanceData;
                        if (dbVar != null) {
                        }
                        throw th;
                    }
                }
                k67.d().b();
                currentTimeMillis = System.currentTimeMillis() - currentTimeMillis2;
                n85Var = new n85();
                getCmd();
                dbVar2 = this.performanceData;
            } catch (Exception e3) {
                e = e3;
                i4 = 0;
            } catch (Throwable th3) {
                th = th3;
                i4 = 0;
            }
            if (dbVar2 != null) {
                n85Var.b = dbVar2.f;
                n85Var.c = getDownSize();
                n85Var.d = currentTimeMillis;
                n85Var.e = i5;
                n85Var.f = this.performanceData.c;
                n85Var.a(1002);
                n85Var.f();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0304 A[Catch: Exception -> 0x04f9, TryCatch #1 {Exception -> 0x04f9, blocks: (B:68:0x0161, B:71:0x0177, B:73:0x0183, B:75:0x01d3, B:77:0x01df, B:78:0x022a, B:80:0x0257, B:82:0x025d, B:84:0x0263, B:86:0x026c, B:85:0x0268, B:87:0x0289, B:89:0x02cb, B:106:0x02fe, B:108:0x0304, B:110:0x0316, B:114:0x0327, B:116:0x032b, B:118:0x0335, B:123:0x034c, B:125:0x0352, B:130:0x0371, B:132:0x037f, B:133:0x0386, B:135:0x038e, B:136:0x0395, B:138:0x039f, B:141:0x03af, B:143:0x03b9, B:145:0x040d, B:146:0x041a, B:147:0x0433, B:126:0x0356, B:128:0x0369, B:119:0x033e, B:111:0x031d, B:148:0x0446, B:150:0x044a, B:152:0x045c, B:156:0x046d, B:158:0x0473, B:153:0x0463, B:104:0x02f9), top: B:201:0x0161 }] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0446 A[Catch: Exception -> 0x04f9, TryCatch #1 {Exception -> 0x04f9, blocks: (B:68:0x0161, B:71:0x0177, B:73:0x0183, B:75:0x01d3, B:77:0x01df, B:78:0x022a, B:80:0x0257, B:82:0x025d, B:84:0x0263, B:86:0x026c, B:85:0x0268, B:87:0x0289, B:89:0x02cb, B:106:0x02fe, B:108:0x0304, B:110:0x0316, B:114:0x0327, B:116:0x032b, B:118:0x0335, B:123:0x034c, B:125:0x0352, B:130:0x0371, B:132:0x037f, B:133:0x0386, B:135:0x038e, B:136:0x0395, B:138:0x039f, B:141:0x03af, B:143:0x03b9, B:145:0x040d, B:146:0x041a, B:147:0x0433, B:126:0x0356, B:128:0x0369, B:119:0x033e, B:111:0x031d, B:148:0x0446, B:150:0x044a, B:152:0x045c, B:156:0x046d, B:158:0x0473, B:153:0x0463, B:104:0x02f9), top: B:201:0x0161 }] */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
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
        VoiceMsgData n;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, bArr) == null) {
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
                        } else if (TbadkCoreApplication.getInst().getCustomizedFilter() == null || TbadkCoreApplication.getInst().getCustomizedFilter().b(obtainGroupData.getGroupInfo().getCustomType())) {
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
                                            long a2 = z87.a(msgInfo.msgId.longValue());
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
                                                if (msgInfo.msgType.intValue() == 3 && (n = a97.n(obtainMessage)) != null) {
                                                    if (a97.p(obtainMessage)) {
                                                        n.setHas_read(1);
                                                    } else {
                                                        n.setHas_read(0);
                                                    }
                                                    String jsonStrWithObject = OrmObject.jsonStrWithObject(n);
                                                    obtainMessage.setContent(PreferencesUtil.LEFT_MOUNT + jsonStrWithObject + PreferencesUtil.RIGHT_MOUNT);
                                                }
                                                obtainMessage.setTime(msgInfo.createTime.intValue());
                                                obtainMessage.setIsFriend(msgInfo.isFriend.intValue());
                                                obtainMessage.setFollowStatus(msgInfo.isFriend.intValue());
                                                obtainMessage.setLink(msgInfo.link);
                                                obtainMessage.setStat(msgInfo.stat);
                                                obtainMessage.setTaskId(msgInfo.taskId.longValue());
                                                obtainMessage.setServiceId(msgInfo.serviceId.longValue());
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
                                                    long g = mg.g(TbadkCoreApplication.getCurrentAccount(), 0L);
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
                                                        if (i4 == 4 && o77.e().c(obtainMessage.getMsgId())) {
                                                            BdLog.i("msg is contained in PushIdsCacheManager");
                                                        } else if (obtainMessage.getMsgType() == 99) {
                                                            BdLog.i("msg is MSG_UNSHOW_OPERATER_ACCOUNT");
                                                        } else if (TbadkCoreApplication.getInst().getCustomizedFilter() == null || TbadkCoreApplication.getInst().getCustomizedFilter().b(4)) {
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
                                                        if (mg.g(TbadkCoreApplication.getCurrentAccount(), 0L) != msgInfo.userId.longValue()) {
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
                                                            if (TbadkCoreApplication.getInst().getCustomizedFilter() != null) {
                                                                try {
                                                                    if (!TbadkCoreApplication.getInst().getCustomizedFilter().b(2)) {
                                                                    }
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
                                                            if (hashMap.get(String.valueOf(longValue)) == null) {
                                                                GroupMsgData groupMsgData2 = new GroupMsgData(2012121);
                                                                groupMsgData2.getGroupInfo().setCustomType(2);
                                                                groupMsgData2.getGroupInfo().setGroupId(longValue);
                                                                getGroupMsg().add(groupMsgData2);
                                                                groupMsgData2.setListMessageData(new LinkedList<>());
                                                                hashMap.put(String.valueOf(longValue), groupMsgData2);
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
                    return;
                }
                MessageUtils.generatePushData(getGroupMsg(), 30, getGroupMsgResIdl3.data.userMsg.msgs, null);
            }
        }
    }
}

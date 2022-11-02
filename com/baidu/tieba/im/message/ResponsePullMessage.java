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
import com.baidu.tieba.gb7;
import com.baidu.tieba.ge7;
import com.baidu.tieba.ie7;
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
import com.baidu.tieba.ke7;
import com.baidu.tieba.lb7;
import com.baidu.tieba.le7;
import com.baidu.tieba.nb7;
import com.baidu.tieba.pa7;
import com.baidu.tieba.pb7;
import com.baidu.tieba.pc7;
import com.baidu.tieba.pe5;
import com.baidu.tieba.qa7;
import com.baidu.tieba.qb7;
import com.baidu.tieba.ra7;
import com.baidu.tieba.rc7;
import com.baidu.tieba.sa7;
import com.baidu.tieba.ta7;
import com.baidu.tieba.ua7;
import com.baidu.tieba.va7;
import com.baidu.tieba.wb;
import com.baidu.tieba.wg;
import com.baidu.tieba.wi;
import com.baidu.tieba.xc7;
import com.baidu.tieba.zx4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes4.dex */
public class ResponsePullMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
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
    public class a implements pa7.b {
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

        @Override // com.baidu.tieba.pa7.b
        public void a(String str, List<CommonMsgPojo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, list) == null) {
                gb7.h().l(str, list, true);
            }
        }

        @Override // com.baidu.tieba.pa7.b
        public void b(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{imMessageCenterPojo, Integer.valueOf(i), Boolean.valueOf(z)}) != null) || imMessageCenterPojo == null) {
                return;
            }
            nb7.f().l(imMessageCenterPojo, 2);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements pa7.b {
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

        @Override // com.baidu.tieba.pa7.b
        public void a(String str, List<CommonMsgPojo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, list) == null) {
                qb7.w().n(wg.g(str, 0L), list, true);
            }
        }

        @Override // com.baidu.tieba.pa7.b
        public void b(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
            ImMessageCenterPojo imMessageCenterPojo2;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{imMessageCenterPojo, Integer.valueOf(i), Boolean.valueOf(z)}) != null) || imMessageCenterPojo == null) {
                return;
            }
            zx4.a("im", -1L, 0, "im_check: pull group id: " + xc7.j + " pulled msg id: " + imMessageCenterPojo.getPulled_msgId(), -1, "", new Object[0]);
            int i2 = 2;
            nb7.f().l(imMessageCenterPojo, 2);
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
                nb7.f().l(this.a, i2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements pa7.b {
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

        @Override // com.baidu.tieba.pa7.b
        public void a(String str, List<CommonMsgPojo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, list) == null) {
                pb7.w().n(wg.g(str, 0L), list, true);
            }
        }

        @Override // com.baidu.tieba.pa7.b
        public void b(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{imMessageCenterPojo, Integer.valueOf(i), Boolean.valueOf(z)}) != null) || imMessageCenterPojo == null) {
                return;
            }
            int i2 = 2;
            nb7.f().l(imMessageCenterPojo, 2);
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
                    nb7.f().l(this.a, i2);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements pa7.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.pa7.b
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

        @Override // com.baidu.tieba.pa7.b
        public void b(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{imMessageCenterPojo, Integer.valueOf(i), Boolean.valueOf(z)}) != null) || imMessageCenterPojo == null) {
                return;
            }
            imMessageCenterPojo.setIs_hidden(1);
            nb7.f().k(imMessageCenterPojo);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements pa7.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.pa7.b
        public void a(String str, List<CommonMsgPojo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, list) == null) {
            }
        }

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

        @Override // com.baidu.tieba.pa7.b
        public void b(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{imMessageCenterPojo, Integer.valueOf(i), Boolean.valueOf(z)}) != null) || imMessageCenterPojo == null) {
                return;
            }
            imMessageCenterPojo.setIs_hidden(1);
            nb7.f().k(imMessageCenterPojo);
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
                        long g = wg.g(jSONArray.optJSONObject(0).optString("task_id"), 0L);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, groupInfo)) == null) {
            int intValue = groupInfo.groupType.intValue();
            if (intValue != 8) {
                if (intValue != 30) {
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
            } else {
                groupMsgData = new GroupMsgData(2012124);
                groupMsgData.getGroupInfo().setCustomType(5);
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
        if ((interceptable != null && interceptable.invokeL(65542, this, str) != null) || wi.isEmpty(str)) {
        }
    }

    public void setGroupMsg(List<GroupMsgData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.groupMsg = list;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0393  */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void beforeDispatchInBackGround(int i, byte[] bArr) {
        int i2;
        int i3;
        int i4;
        wb wbVar;
        pe5 pe5Var;
        int i5;
        long currentTimeMillis;
        wb wbVar2;
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
                        pc7.i().m(next, isPulledMessage());
                    }
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                try {
                    lb7.d().f();
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
                                ImMessageCenterPojo g = nb7.f().g(valueOf, customType);
                                if (g != null) {
                                    g.setUserType(userType);
                                }
                                if (customType == i2 && imMessageCenterPojo == null && (imMessageCenterPojo = nb7.f().g(str2, -8)) == null) {
                                    imMessageCenterPojo = new ImMessageCenterPojo();
                                    imMessageCenterPojo.setGid(str2);
                                    imMessageCenterPojo.setCustomGroupType(-8);
                                    imMessageCenterPojo.setIs_hidden(1);
                                }
                                if (customType == 2 && imMessageCenterPojo2 == null && hasStranger(next2)) {
                                    ImMessageCenterPojo g2 = nb7.f().g(TbEnum.CustomGroupId.STRANGE_MERGE, -7);
                                    if (g2 == null) {
                                        g2 = new ImMessageCenterPojo();
                                        g2.setGid(TbEnum.CustomGroupId.STRANGE_MERGE);
                                        g2.setCustomGroupType(-7);
                                        g2.setIs_hidden(1);
                                    }
                                    imMessageCenterPojo2 = g2;
                                }
                                if (next2.getCmd() == 2012125) {
                                    qa7.a(next2, g, new a(this));
                                } else if (next2.getCmd() == 2012120) {
                                    ua7.g(next2);
                                } else if (next2.getCmd() == 2012121) {
                                    ta7.b(next2, g, new b(this, imMessageCenterPojo2));
                                    ta7.c(next2);
                                } else if (next2.getCmd() == 2012123) {
                                    sa7.a(next2, g, new c(this, imMessageCenterPojo));
                                } else if (next2.getCmd() == 2012128) {
                                    if (next2.getListMessage() != null && next2.getListMessage().size() != 0) {
                                        ChatMessage chatMessage2 = next2.getListMessage().get(i3);
                                        ImMessageCenterPojo imMessageCenterPojo3 = new ImMessageCenterPojo();
                                        imMessageCenterPojo3.setGid(String.valueOf(xc7.j));
                                        imMessageCenterPojo3.setCustomGroupType(-1);
                                        imMessageCenterPojo3.setIs_hidden(1);
                                        imMessageCenterPojo3.setPulled_msgId(chatMessage2.getMsgId());
                                        nb7.f().k(imMessageCenterPojo3);
                                        BdLog.i("pullMessage insertMessagecent personal_Group gid = " + xc7.j + " msgid = " + chatMessage2.getMsgId());
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
                                                        rc7.e().k();
                                                    } else if (chatMessage3.getUserInfo() != null) {
                                                        if (chatMessage3.getUserInfo().getUserType() == 4) {
                                                            Long f = rc7.e().f();
                                                            if (f != null) {
                                                                chatMessage = chatMessage3;
                                                                if (f.longValue() != 0) {
                                                                    imMessageCenterPojo4.setPulled_msgId(0L);
                                                                    imMessageCenterPojo4.setPushIds(rc7.e().h());
                                                                }
                                                            } else {
                                                                chatMessage = chatMessage3;
                                                            }
                                                            imMessageCenterPojo4.setPushIds("");
                                                        } else {
                                                            chatMessage = chatMessage3;
                                                        }
                                                        nb7.f().m(imMessageCenterPojo4, 1, 2);
                                                    }
                                                    chatMessage = chatMessage3;
                                                    nb7.f().m(imMessageCenterPojo4, 1, 2);
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
                                            ra7.a(next2, g, new d(this));
                                        } else if (next2.getCmd() == 2012126) {
                                            if (next2.getGroupInfo().getGroupId() == 10) {
                                                va7.d(next2, g, new e(this));
                                            } else {
                                                long[] a2 = va7.b().a(next2);
                                                if (a2 != null) {
                                                    va7.b().f(String.valueOf(a2[0]), ke7.c(a2[1]));
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
                                lb7.d().b();
                                long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
                                pe5Var = new pe5();
                                getCmd();
                                wb wbVar3 = this.performanceData;
                                if (wbVar3 != null) {
                                    pe5Var.b = wbVar3.f;
                                    pe5Var.c = getDownSize();
                                    pe5Var.d = currentTimeMillis3;
                                    pe5Var.e = i4;
                                    pe5Var.f = this.performanceData.c;
                                    pe5Var.a(1002);
                                    pe5Var.f();
                                }
                                return;
                            } catch (Throwable th) {
                                th = th;
                                lb7.d().b();
                                long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis2;
                                pe5 pe5Var2 = new pe5();
                                getCmd();
                                wbVar = this.performanceData;
                                if (wbVar != null) {
                                    pe5Var2.b = wbVar.f;
                                    pe5Var2.c = getDownSize();
                                    pe5Var2.d = currentTimeMillis4;
                                    pe5Var2.e = i4;
                                    pe5Var2.f = this.performanceData.c;
                                    pe5Var2.a(1002);
                                    pe5Var2.f();
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            i4 = i5;
                            lb7.d().b();
                            long currentTimeMillis42 = System.currentTimeMillis() - currentTimeMillis2;
                            pe5 pe5Var22 = new pe5();
                            getCmd();
                            wbVar = this.performanceData;
                            if (wbVar != null) {
                            }
                            throw th;
                        }
                    }
                    lb7.d().b();
                    currentTimeMillis = System.currentTimeMillis() - currentTimeMillis2;
                    pe5Var = new pe5();
                    getCmd();
                    wbVar2 = this.performanceData;
                } catch (Exception e3) {
                    e = e3;
                    i4 = 0;
                } catch (Throwable th3) {
                    th = th3;
                    i4 = 0;
                }
                if (wbVar2 != null) {
                    pe5Var.b = wbVar2.f;
                    pe5Var.c = getDownSize();
                    pe5Var.d = currentTimeMillis;
                    pe5Var.e = i5;
                    pe5Var.f = this.performanceData.c;
                    pe5Var.a(1002);
                    pe5Var.f();
                }
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(26:42|43|44|45|46|47|48|(1:212)(1:52)|53|(3:55|(4:57|(8:60|61|62|63|64|65|66|58)|77|78)(1:210)|79)(1:211)|80|(1:82)|83|(2:85|(3:87|(1:89)(1:91)|90))(3:189|(2:191|(4:193|194|121|122))(2:195|(2:197|(4:199|194|121|122))(3:200|201|(14:203|(1:205)(1:209)|206|(3:208|121|122)|93|94|(1:96)|97|(3:101|102|(9:104|105|106|107|(1:110)|111|(7:113|(1:115)(1:152)|116|(3:143|144|(4:146|(1:148)(1:149)|119|(3:123|(1:125)(2:140|(1:142))|(2:130|(1:132)(3:133|(3:135|(1:137)|138)|139))(1:129))))|118|119|(0))(2:153|(4:155|(1:157)(1:176)|158|(6:160|(2:162|163)(3:172|173|(1:175))|164|(2:168|169)|166|167))(2:177|178))|121|122))|185|111|(0)(0)|121|122)))|38)|92|93|94|(0)|97|(4:99|101|102|(0))|185|111|(0)(0)|121|122|38) */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x0511, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x0512, code lost:
        r8 = r2;
     */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02f9 A[Catch: Exception -> 0x0511, TryCatch #9 {Exception -> 0x0511, blocks: (B:104:0x02b8, B:106:0x02f9, B:107:0x0308, B:109:0x0312, B:126:0x0345, B:128:0x034b, B:130:0x035d, B:131:0x0364, B:124:0x0340, B:101:0x02ab, B:103:0x02b1), top: B:232:0x02b8 }] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0327 A[Catch: Exception -> 0x033e, TRY_LEAVE, TryCatch #2 {Exception -> 0x033e, blocks: (B:111:0x0318, B:113:0x0327), top: B:218:0x0318 }] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x034b A[Catch: Exception -> 0x0511, TryCatch #9 {Exception -> 0x0511, blocks: (B:104:0x02b8, B:106:0x02f9, B:107:0x0308, B:109:0x0312, B:126:0x0345, B:128:0x034b, B:130:0x035d, B:131:0x0364, B:124:0x0340, B:101:0x02ab, B:103:0x02b1), top: B:232:0x02b8 }] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0394 A[Catch: Exception -> 0x050f, TryCatch #1 {Exception -> 0x050f, blocks: (B:134:0x036f, B:136:0x0373, B:138:0x037d, B:143:0x0394, B:145:0x039a, B:150:0x03b9, B:152:0x03c7, B:153:0x03ce, B:155:0x03d6, B:156:0x03dd, B:158:0x03e7, B:160:0x043b, B:161:0x0448, B:162:0x0461, B:146:0x039e, B:148:0x03b1, B:139:0x0386, B:163:0x0474, B:165:0x0479, B:167:0x048b, B:171:0x049c, B:173:0x04a2, B:168:0x0492), top: B:216:0x036f }] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0474 A[Catch: Exception -> 0x050f, TryCatch #1 {Exception -> 0x050f, blocks: (B:134:0x036f, B:136:0x0373, B:138:0x037d, B:143:0x0394, B:145:0x039a, B:150:0x03b9, B:152:0x03c7, B:153:0x03ce, B:155:0x03d6, B:156:0x03dd, B:158:0x03e7, B:160:0x043b, B:161:0x0448, B:162:0x0461, B:146:0x039e, B:148:0x03b1, B:139:0x0386, B:163:0x0474, B:165:0x0479, B:167:0x048b, B:171:0x049c, B:173:0x04a2, B:168:0x0492), top: B:216:0x036f }] */
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
        int i3;
        MsgInfo msgInfo;
        ChatMessage obtainMessage;
        int i4;
        int i5;
        boolean z2;
        long longValue;
        long longValue2;
        int intValue;
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, bArr)) == null) {
            ResponsePullMessage responsePullMessage = this;
            GetGroupMsgResIdl getGroupMsgResIdl2 = (GetGroupMsgResIdl) new Wire(new Class[0]).parseFrom(bArr, GetGroupMsgResIdl.class);
            responsePullMessage.setError(getGroupMsgResIdl2.error.errorno.intValue());
            responsePullMessage.setErrorString(getGroupMsgResIdl2.error.usermsg);
            if (getError() != 0) {
                return getGroupMsgResIdl2;
            }
            DataRes dataRes = getGroupMsgResIdl2.data;
            if (dataRes == null) {
                return getGroupMsgResIdl2;
            }
            responsePullMessage.parseMsgConfig(dataRes.config);
            responsePullMessage.setGroupMsg(new LinkedList());
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            List<GroupMsg> list = getGroupMsgResIdl2.data.groupMsg;
            if (list == null) {
                size = 0;
            } else {
                size = list.size();
            }
            int i6 = 0;
            while (i6 < size) {
                GroupMsg groupMsg = getGroupMsgResIdl2.data.groupMsg.get(i6);
                if (groupMsg != null && (groupInfo = groupMsg.groupInfo) != null) {
                    GroupMsgData obtainGroupData = responsePullMessage.obtainGroupData(groupInfo);
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
                        List<MsgInfo> list2 = groupMsg.msgList;
                        if (list2 != null && (size2 = list2.size()) > 0) {
                            int i7 = 0;
                            while (i7 < size2) {
                                try {
                                    msgInfo = list2.get(i7);
                                } catch (Exception e2) {
                                    e = e2;
                                    getGroupMsgResIdl = getGroupMsgResIdl2;
                                    i2 = size;
                                    groupInfo2 = groupInfo;
                                    i3 = i7;
                                }
                                if (msgInfo != null && (obtainMessage = responsePullMessage.obtainMessage(groupInfo, msgInfo)) != null) {
                                    getGroupMsgResIdl = getGroupMsgResIdl2;
                                    try {
                                        long a2 = ke7.a(msgInfo.msgId.longValue());
                                        obtainMessage.setMsgId(a2);
                                        obtainMessage.setGroupId(String.valueOf(msgInfo.groupId));
                                        obtainMessage.setMsgType(msgInfo.msgType.intValue());
                                        i4 = i7;
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
                                                    int i8 = 0;
                                                    while (i8 < list3.size()) {
                                                        TshowInfo tshowInfo = list3.get(i8);
                                                        List<TshowInfo> list4 = list3;
                                                        i2 = size;
                                                        try {
                                                            groupInfo2 = groupInfo;
                                                        } catch (Exception e3) {
                                                            e = e3;
                                                            groupInfo2 = groupInfo;
                                                            i3 = i4;
                                                            e.printStackTrace();
                                                            i7 = i3 + 1;
                                                            responsePullMessage = this;
                                                            getGroupMsgResIdl2 = getGroupMsgResIdl;
                                                            size = i2;
                                                            groupInfo = groupInfo2;
                                                        }
                                                        try {
                                                            arrayList.add(new IconData(tshowInfo.icon, tshowInfo.name, tshowInfo.url));
                                                            i8++;
                                                            list3 = list4;
                                                            size = i2;
                                                            groupInfo = groupInfo2;
                                                        } catch (Exception e4) {
                                                            e = e4;
                                                            i3 = i4;
                                                            e.printStackTrace();
                                                            i7 = i3 + 1;
                                                            responsePullMessage = this;
                                                            getGroupMsgResIdl2 = getGroupMsgResIdl;
                                                            size = i2;
                                                            groupInfo = groupInfo2;
                                                        }
                                                    }
                                                    i2 = size;
                                                    groupInfo2 = groupInfo;
                                                    userData.setTShowInfo(arrayList);
                                                } else {
                                                    i2 = size;
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
                                                i2 = size;
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
                                            i2 = size;
                                        }
                                    } catch (Exception e6) {
                                        e = e6;
                                        i2 = size;
                                        groupInfo2 = groupInfo;
                                        i3 = i7;
                                    }
                                    if (msgInfo.msgType.intValue() == 3) {
                                        VoiceMsgData q = le7.q(obtainMessage);
                                        if (q != null) {
                                            if (le7.v(obtainMessage)) {
                                                q.setHas_read(1);
                                            } else {
                                                q.setHas_read(0);
                                            }
                                            String jsonStrWithObject = OrmObject.jsonStrWithObject(q);
                                            obtainMessage.setContent(PreferencesUtil.LEFT_MOUNT + jsonStrWithObject + PreferencesUtil.RIGHT_MOUNT);
                                        }
                                    } else {
                                        if (msgInfo.msgType.intValue() == 32) {
                                            if (!le7.t(obtainMessage, msgInfo)) {
                                                ge7.a("分享『贴』32 ：数据解析失败，消息抛弃");
                                                i3 = i4;
                                            }
                                        } else if (msgInfo.msgType.intValue() == 33) {
                                            if (!le7.s(obtainMessage, msgInfo)) {
                                                ge7.a("分享『吧』33 ：数据解析失败，消息抛弃");
                                                i3 = i4;
                                            }
                                        } else if (msgInfo.msgType.intValue() == 34) {
                                            i5 = i4;
                                            if (i5 == size2 - 1) {
                                                z2 = true;
                                            } else {
                                                z2 = false;
                                            }
                                            if (!le7.r(obtainMessage, msgInfo, z2)) {
                                                ge7.a("陪玩消息卡片 ：数据解析失败，消息抛弃");
                                                i3 = i5;
                                            }
                                            obtainMessage.setTime(msgInfo.createTime.intValue());
                                            obtainMessage.setIsFriend(msgInfo.relation.intValue());
                                            obtainMessage.setFollowStatus(msgInfo.isFriend.intValue());
                                            obtainMessage.setLink(msgInfo.link);
                                            obtainMessage.setStat(msgInfo.stat);
                                            obtainMessage.setTaskId(msgInfo.taskId.longValue());
                                            obtainMessage.setServiceId(msgInfo.serviceId.longValue());
                                            if (msgInfo.isRenderStlog.intValue() == 1) {
                                                ie7.d(msgInfo.msgId.longValue(), msgInfo.msgType.intValue());
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
                                                        if (!(obtainMessage instanceof OfficialChatMessage)) {
                                                        }
                                                        i7 = i3 + 1;
                                                        responsePullMessage = this;
                                                        getGroupMsgResIdl2 = getGroupMsgResIdl;
                                                        size = i2;
                                                        groupInfo = groupInfo2;
                                                    }
                                                    if (!(obtainMessage instanceof OfficialChatMessage)) {
                                                        long g = wg.g(TbadkCoreApplication.getCurrentAccount(), 0L);
                                                        if (g != msgInfo.userId.longValue()) {
                                                            longValue2 = msgInfo.userId.longValue();
                                                        } else {
                                                            longValue2 = msgInfo.toUid.longValue();
                                                        }
                                                        i3 = i5;
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
                                                                        if (intValue == 4 && rc7.e().c(obtainMessage.getMsgId())) {
                                                                            BdLog.i("msg is contained in PushIdsCacheManager");
                                                                        } else if (obtainMessage.getMsgType() == 99) {
                                                                            BdLog.i("msg is MSG_UNSHOW_OPERATER_ACCOUNT");
                                                                        } else {
                                                                            if (hashMap2.get(String.valueOf(j)) == null) {
                                                                                GroupMsgData groupMsgData = new GroupMsgData(2012123);
                                                                                groupMsgData.getGroupInfo().setUserType(intValue);
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
                                                                }
                                                            } catch (Exception e9) {
                                                                e = e9;
                                                                e.printStackTrace();
                                                                i7 = i3 + 1;
                                                                responsePullMessage = this;
                                                                getGroupMsgResIdl2 = getGroupMsgResIdl;
                                                                size = i2;
                                                                groupInfo = groupInfo2;
                                                            }
                                                        }
                                                        intValue = 1;
                                                        if (j != 0) {
                                                        }
                                                    } else {
                                                        i3 = i5;
                                                        if (obtainMessage instanceof PersonalChatMessage) {
                                                            if (wg.g(TbadkCoreApplication.getCurrentAccount(), 0L) != msgInfo.userId.longValue()) {
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
                                                                    } catch (Exception e10) {
                                                                        e = e10;
                                                                        e.printStackTrace();
                                                                        i7 = i3 + 1;
                                                                        responsePullMessage = this;
                                                                        getGroupMsgResIdl2 = getGroupMsgResIdl;
                                                                        size = i2;
                                                                        groupInfo = groupInfo2;
                                                                    }
                                                                }
                                                                ((GroupMsgData) hashMap.get(String.valueOf(longValue))).getListMessage().add(obtainMessage);
                                                            }
                                                        } else {
                                                            linkedList.add(obtainMessage);
                                                        }
                                                    }
                                                }
                                            }
                                            if (!(obtainMessage instanceof OfficialChatMessage)) {
                                            }
                                        }
                                        i7 = i3 + 1;
                                        responsePullMessage = this;
                                        getGroupMsgResIdl2 = getGroupMsgResIdl;
                                        size = i2;
                                        groupInfo = groupInfo2;
                                    }
                                    i5 = i4;
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
                                    if (!(obtainMessage instanceof OfficialChatMessage)) {
                                    }
                                    i7 = i3 + 1;
                                    responsePullMessage = this;
                                    getGroupMsgResIdl2 = getGroupMsgResIdl;
                                    size = i2;
                                    groupInfo = groupInfo2;
                                }
                                getGroupMsgResIdl = getGroupMsgResIdl2;
                                i2 = size;
                                groupInfo2 = groupInfo;
                                i3 = i7;
                                i7 = i3 + 1;
                                responsePullMessage = this;
                                getGroupMsgResIdl2 = getGroupMsgResIdl;
                                size = i2;
                                groupInfo = groupInfo2;
                            }
                        }
                    }
                }
                i6++;
                responsePullMessage = this;
                getGroupMsgResIdl2 = getGroupMsgResIdl2;
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

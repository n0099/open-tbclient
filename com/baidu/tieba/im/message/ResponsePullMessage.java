package com.baidu.tieba.im.message;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.k;
import b.a.q0.q0.f;
import b.a.r0.l1.f.l.a;
import b.a.r0.l1.f.l.g;
import b.a.r0.l1.h.h;
import b.a.r0.l1.h.j;
import b.a.r0.l1.h.l;
import b.a.r0.l1.h.m;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes9.dex */
public class ResponsePullMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<GroupMsgData> groupMsg;

    /* loaded from: classes9.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(ResponsePullMessage responsePullMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {responsePullMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // b.a.r0.l1.f.l.a.b
        public void a(String str, List<CommonMsgPojo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, list) == null) {
                b.a.r0.l1.h.c.h().l(str, list, true);
            }
        }

        @Override // b.a.r0.l1.f.l.a.b
        public void b(ImMessageCenterPojo imMessageCenterPojo, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{imMessageCenterPojo, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || imMessageCenterPojo == null) {
                return;
            }
            j.f().k(imMessageCenterPojo, 2);
        }
    }

    /* loaded from: classes9.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImMessageCenterPojo f50505a;

        public b(ResponsePullMessage responsePullMessage, ImMessageCenterPojo imMessageCenterPojo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {responsePullMessage, imMessageCenterPojo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50505a = imMessageCenterPojo;
        }

        @Override // b.a.r0.l1.f.l.a.b
        public void a(String str, List<CommonMsgPojo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, list) == null) {
                m.t().m(b.a.e.e.m.b.g(str, 0L), list, true);
            }
        }

        @Override // b.a.r0.l1.f.l.a.b
        public void b(ImMessageCenterPojo imMessageCenterPojo, int i2, boolean z) {
            ImMessageCenterPojo imMessageCenterPojo2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{imMessageCenterPojo, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || imMessageCenterPojo == null) {
                return;
            }
            int i3 = 2;
            j.f().k(imMessageCenterPojo, 2);
            if (imMessageCenterPojo.getIsFriend() != 0 || (imMessageCenterPojo2 = this.f50505a) == null) {
                return;
            }
            imMessageCenterPojo2.setGid(TbEnum.CustomGroupId.STRANGE_MERGE);
            this.f50505a.setCustomGroupType(-7);
            if (i2 == 0) {
                this.f50505a.setUnread_count(0);
            } else if (i2 == 1) {
                this.f50505a.setUnread_count(1);
            } else {
                i3 = 1;
            }
            if (z) {
                this.f50505a.setIs_hidden(0);
            }
            j.f().k(this.f50505a, i3);
        }
    }

    /* loaded from: classes9.dex */
    public class c implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImMessageCenterPojo f50506a;

        public c(ResponsePullMessage responsePullMessage, ImMessageCenterPojo imMessageCenterPojo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {responsePullMessage, imMessageCenterPojo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50506a = imMessageCenterPojo;
        }

        @Override // b.a.r0.l1.f.l.a.b
        public void a(String str, List<CommonMsgPojo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, list) == null) {
                l.t().m(b.a.e.e.m.b.g(str, 0L), list, true);
            }
        }

        @Override // b.a.r0.l1.f.l.a.b
        public void b(ImMessageCenterPojo imMessageCenterPojo, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{imMessageCenterPojo, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || imMessageCenterPojo == null) {
                return;
            }
            int i3 = 2;
            j.f().k(imMessageCenterPojo, 2);
            int userType = imMessageCenterPojo.getUserType();
            if (this.f50506a != null) {
                if (userType == 1 || userType == 3) {
                    this.f50506a.setGid(TbEnum.CustomGroupId.OFFICIAL_MERGE);
                    this.f50506a.setCustomGroupType(-8);
                    if (i2 == 0) {
                        this.f50506a.setUnread_count(0);
                    } else if (i2 == 1) {
                        this.f50506a.setUnread_count(1);
                    } else {
                        i3 = 1;
                    }
                    if (z) {
                        this.f50506a.setIs_hidden(0);
                    }
                    j.f().k(this.f50506a, i3);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(ResponsePullMessage responsePullMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {responsePullMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // b.a.r0.l1.f.l.a.b
        public void a(String str, List<CommonMsgPojo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, list) == null) {
            }
        }

        @Override // b.a.r0.l1.f.l.a.b
        public void b(ImMessageCenterPojo imMessageCenterPojo, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{imMessageCenterPojo, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || imMessageCenterPojo == null) {
                return;
            }
            imMessageCenterPojo.setIs_hidden(1);
            j.f().j(imMessageCenterPojo);
        }
    }

    /* loaded from: classes9.dex */
    public class e implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(ResponsePullMessage responsePullMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {responsePullMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // b.a.r0.l1.f.l.a.b
        public void a(String str, List<CommonMsgPojo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, list) == null) {
            }
        }

        @Override // b.a.r0.l1.f.l.a.b
        public void b(ImMessageCenterPojo imMessageCenterPojo, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{imMessageCenterPojo, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || imMessageCenterPojo == null) {
                return;
            }
            imMessageCenterPojo.setIs_hidden(1);
            j.f().j(imMessageCenterPojo);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponsePullMessage() {
        super(202003);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
                        long g2 = b.a.e.e.m.b.g(jSONArray.optJSONObject(0).optString("task_id"), 0L);
                        if (g2 > 0) {
                            return g2;
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, groupInfo, msgInfo)) == null) {
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
        if ((interceptable != null && interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, str) != null) || k.isEmpty(str)) {
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
    public ResponsePullMessage(int i2) {
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
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0390  */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void beforeDispatchInBackGround(int i2, byte[] bArr) {
        int i3;
        int i4;
        int i5;
        b.a.e.c.i.a aVar;
        f fVar;
        int i6;
        long currentTimeMillis;
        b.a.e.c.i.a aVar2;
        String str;
        Iterator<GroupMsgData> it;
        ChatMessage chatMessage;
        LinkedList<ChatMessage> listMessage;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) {
            String str2 = TbEnum.CustomGroupId.OFFICIAL_MERGE;
            List<GroupMsgData> groupMsg = getGroupMsg();
            if (groupMsg == null || groupMsg.size() == 0) {
                return;
            }
            Iterator<GroupMsgData> it2 = groupMsg.iterator();
            while (true) {
                i3 = 4;
                i4 = 0;
                if (!it2.hasNext()) {
                    break;
                }
                GroupMsgData next = it2.next();
                if (next.getGroupInfo() != null && next.getGroupInfo().getCustomType() == 4 && (listMessage = next.getListMessage()) != null && listMessage.size() != 0 && listMessage.get(0).getSid() > 0) {
                    b.a.r0.l1.o.a.i().m(next, isPulledMessage());
                }
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            try {
                h.d().f();
                Iterator<GroupMsgData> it3 = groupMsg.iterator();
                ImMessageCenterPojo imMessageCenterPojo = null;
                ImMessageCenterPojo imMessageCenterPojo2 = null;
                i6 = 0;
                while (it3.hasNext()) {
                    try {
                        GroupMsgData next2 = it3.next();
                        if (next2 != null && next2.getListMessage() != null) {
                            i6 += next2.getListMessage().size();
                            String valueOf = String.valueOf(next2.getGroupInfo().getGroupId());
                            int customType = next2.getGroupInfo().getCustomType();
                            int userType = next2.getGroupInfo().getUserType();
                            ImMessageCenterPojo g2 = j.f().g(valueOf, customType);
                            if (g2 != null) {
                                g2.setUserType(userType);
                            }
                            if (customType == i3 && imMessageCenterPojo == null && (imMessageCenterPojo = j.f().g(str2, -8)) == null) {
                                imMessageCenterPojo = new ImMessageCenterPojo();
                                imMessageCenterPojo.setGid(str2);
                                imMessageCenterPojo.setCustomGroupType(-8);
                                imMessageCenterPojo.setIs_hidden(1);
                            }
                            if (customType == 2 && imMessageCenterPojo2 == null && hasStranger(next2)) {
                                ImMessageCenterPojo g3 = j.f().g(TbEnum.CustomGroupId.STRANGE_MERGE, -7);
                                if (g3 == null) {
                                    g3 = new ImMessageCenterPojo();
                                    g3.setGid(TbEnum.CustomGroupId.STRANGE_MERGE);
                                    g3.setCustomGroupType(-7);
                                    g3.setIs_hidden(1);
                                }
                                imMessageCenterPojo2 = g3;
                            }
                            if (next2.getCmd() == 2012125) {
                                b.a.r0.l1.f.l.b.a(next2, g2, new a(this));
                            } else if (next2.getCmd() == 2012120) {
                                b.a.r0.l1.f.l.f.g(next2);
                            } else if (next2.getCmd() == 2012121) {
                                b.a.r0.l1.f.l.e.b(next2, g2, new b(this, imMessageCenterPojo2));
                            } else if (next2.getCmd() == 2012123) {
                                b.a.r0.l1.f.l.d.a(next2, g2, new c(this, imMessageCenterPojo));
                            } else if (next2.getCmd() == 2012128) {
                                if (next2.getListMessage() != null && next2.getListMessage().size() != 0) {
                                    ChatMessage chatMessage2 = next2.getListMessage().get(i4);
                                    ImMessageCenterPojo imMessageCenterPojo3 = new ImMessageCenterPojo();
                                    imMessageCenterPojo3.setGid(String.valueOf(b.a.r0.l1.s.a.f20346i));
                                    imMessageCenterPojo3.setCustomGroupType(-1);
                                    imMessageCenterPojo3.setIs_hidden(1);
                                    imMessageCenterPojo3.setPulled_msgId(chatMessage2.getMsgId());
                                    j.f().j(imMessageCenterPojo3);
                                    BdLog.i("pullMessage insertMessagecent personal_Group gid = " + b.a.r0.l1.s.a.f20346i + " msgid = " + chatMessage2.getMsgId());
                                }
                            } else {
                                if (next2.getCmd() == 2012129) {
                                    if (next2.getListMessage() == null) {
                                        str = str2;
                                        it = it3;
                                    } else if (next2.getListMessage().size() != 0) {
                                        ChatMessage chatMessage3 = next2.getListMessage().get(i4);
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
                                                b.a.r0.l1.o.c.e().k();
                                            } else if (chatMessage3.getUserInfo() != null) {
                                                if (chatMessage3.getUserInfo().getUserType() == 4) {
                                                    Long f2 = b.a.r0.l1.o.c.e().f();
                                                    if (f2 != null) {
                                                        chatMessage = chatMessage3;
                                                        if (f2.longValue() != 0) {
                                                            imMessageCenterPojo4.setPulled_msgId(0L);
                                                            imMessageCenterPojo4.setPushIds(b.a.r0.l1.o.c.e().h());
                                                        }
                                                    } else {
                                                        chatMessage = chatMessage3;
                                                    }
                                                    imMessageCenterPojo4.setPushIds("");
                                                } else {
                                                    chatMessage = chatMessage3;
                                                }
                                                j.f().l(imMessageCenterPojo4, 1, 2);
                                            }
                                            chatMessage = chatMessage3;
                                            j.f().l(imMessageCenterPojo4, 1, 2);
                                        } else {
                                            chatMessage = chatMessage3;
                                        }
                                        BdLog.i("pullMessage insertMessagecent offical_Group gid = " + next2.getGroupInfo().getGroupId() + " msgid = " + chatMessage.getMsgId());
                                    }
                                } else {
                                    str = str2;
                                    it = it3;
                                    if (next2.getCmd() == 2012124) {
                                        b.a.r0.l1.f.l.c.a(next2, g2, new d(this));
                                    } else if (next2.getCmd() == 2012126) {
                                        if (next2.getGroupInfo().getGroupId() == 10) {
                                            g.d(next2, g2, new e(this));
                                        } else {
                                            long[] a2 = g.b().a(next2);
                                            if (a2 != null) {
                                                g.b().f(String.valueOf(a2[0]), b.a.r0.l1.w.b.c(a2[1]));
                                                str2 = str;
                                                it3 = it;
                                                i3 = 4;
                                                i4 = 0;
                                            }
                                        }
                                    }
                                }
                                str2 = str;
                                it3 = it;
                                i3 = 4;
                                i4 = 0;
                            }
                        }
                        str = str2;
                        it = it3;
                        str2 = str;
                        it3 = it;
                        i3 = 4;
                        i4 = 0;
                    } catch (Exception e2) {
                        e = e2;
                        i5 = i6;
                        try {
                            BdLog.e(e.getMessage());
                            h.d().b();
                            long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
                            fVar = new f();
                            getCmd();
                            b.a.e.c.i.a aVar3 = this.performanceData;
                            if (aVar3 != null) {
                                fVar.f12826b = aVar3.f1566f;
                                fVar.f12827c = getDownSize();
                                fVar.f12828d = currentTimeMillis3;
                                fVar.f12829e = i5;
                                fVar.f12830f = this.performanceData.f1563c;
                                fVar.a(1002);
                                fVar.f();
                            }
                            return;
                        } catch (Throwable th) {
                            th = th;
                            h.d().b();
                            long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis2;
                            f fVar2 = new f();
                            getCmd();
                            aVar = this.performanceData;
                            if (aVar != null) {
                                fVar2.f12826b = aVar.f1566f;
                                fVar2.f12827c = getDownSize();
                                fVar2.f12828d = currentTimeMillis4;
                                fVar2.f12829e = i5;
                                fVar2.f12830f = this.performanceData.f1563c;
                                fVar2.a(1002);
                                fVar2.f();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        i5 = i6;
                        h.d().b();
                        long currentTimeMillis42 = System.currentTimeMillis() - currentTimeMillis2;
                        f fVar22 = new f();
                        getCmd();
                        aVar = this.performanceData;
                        if (aVar != null) {
                        }
                        throw th;
                    }
                }
                h.d().b();
                currentTimeMillis = System.currentTimeMillis() - currentTimeMillis2;
                fVar = new f();
                getCmd();
                aVar2 = this.performanceData;
            } catch (Exception e3) {
                e = e3;
                i5 = 0;
            } catch (Throwable th3) {
                th = th3;
                i5 = 0;
            }
            if (aVar2 != null) {
                fVar.f12826b = aVar2.f1566f;
                fVar.f12827c = getDownSize();
                fVar.f12828d = currentTimeMillis;
                fVar.f12829e = i6;
                fVar.f12830f = this.performanceData.f1563c;
                fVar.a(1002);
                fVar.f();
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
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        DataRes dataRes;
        GroupInfo groupInfo;
        int size;
        GetGroupMsgResIdl getGroupMsgResIdl;
        int i3;
        GroupInfo groupInfo2;
        int i4;
        MsgInfo msgInfo;
        ChatMessage obtainMessage;
        long longValue;
        long longValue2;
        int i5;
        JSONArray jSONArray;
        VoiceMsgData n;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, bArr) == null) {
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
                int i6 = 0;
                while (i6 < size2) {
                    GroupMsg groupMsg = getGroupMsgResIdl2.data.groupMsg.get(i6);
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
                                int i7 = 0;
                                while (i7 < size) {
                                    try {
                                        msgInfo = list2.get(i7);
                                    } catch (Exception e2) {
                                        e = e2;
                                        getGroupMsgResIdl = getGroupMsgResIdl2;
                                    }
                                    if (msgInfo != null && (obtainMessage = responsePullMessage.obtainMessage(groupInfo, msgInfo)) != null) {
                                        getGroupMsgResIdl = getGroupMsgResIdl2;
                                        try {
                                            long a2 = b.a.r0.l1.w.b.a(msgInfo.msgId.longValue());
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
                                                            i3 = size2;
                                                            try {
                                                                groupInfo2 = groupInfo;
                                                                try {
                                                                    arrayList.add(new IconData(tshowInfo.icon, tshowInfo.name, tshowInfo.url));
                                                                    i8++;
                                                                    list3 = list4;
                                                                    size2 = i3;
                                                                    groupInfo = groupInfo2;
                                                                } catch (Exception e3) {
                                                                    e = e3;
                                                                    e.printStackTrace();
                                                                    i7 = i4 + 1;
                                                                    responsePullMessage = this;
                                                                    getGroupMsgResIdl2 = getGroupMsgResIdl;
                                                                    size2 = i3;
                                                                    groupInfo = groupInfo2;
                                                                }
                                                            } catch (Exception e4) {
                                                                e = e4;
                                                                groupInfo2 = groupInfo;
                                                                e.printStackTrace();
                                                                i7 = i4 + 1;
                                                                responsePullMessage = this;
                                                                getGroupMsgResIdl2 = getGroupMsgResIdl;
                                                                size2 = i3;
                                                                groupInfo = groupInfo2;
                                                            }
                                                        }
                                                        i3 = size2;
                                                        groupInfo2 = groupInfo;
                                                        userData.setTShowInfo(arrayList);
                                                    } else {
                                                        i3 = size2;
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
                                                    i3 = size2;
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
                                                if (msgInfo.msgType.intValue() == 3 && (n = b.a.r0.l1.w.c.n(obtainMessage)) != null) {
                                                    if (b.a.r0.l1.w.c.p(obtainMessage)) {
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
                                                i3 = size2;
                                            }
                                        } catch (Exception e6) {
                                            e = e6;
                                            i3 = size2;
                                            groupInfo2 = groupInfo;
                                            i4 = i7;
                                            e.printStackTrace();
                                            i7 = i4 + 1;
                                            responsePullMessage = this;
                                            getGroupMsgResIdl2 = getGroupMsgResIdl;
                                            size2 = i3;
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
                                                    i7 = i4 + 1;
                                                    responsePullMessage = this;
                                                    getGroupMsgResIdl2 = getGroupMsgResIdl;
                                                    size2 = i3;
                                                    groupInfo = groupInfo2;
                                                }
                                                if (obtainMessage instanceof OfficialChatMessage) {
                                                    long g2 = b.a.e.e.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L);
                                                    if (g2 != msgInfo.userId.longValue()) {
                                                        longValue2 = msgInfo.userId.longValue();
                                                    } else {
                                                        longValue2 = msgInfo.toUid.longValue();
                                                    }
                                                    long j = longValue2;
                                                    if (msgInfo == null || msgInfo.userInfo == null) {
                                                        i5 = 1;
                                                    } else if (g2 != msgInfo.userId.longValue()) {
                                                        i5 = msgInfo.userInfo.userType.intValue();
                                                    } else {
                                                        i5 = msgInfo.toUserInfo.userType.intValue();
                                                    }
                                                    if (j != 0) {
                                                        if (linkedList.size() == 0) {
                                                            linkedList.add(obtainMessage);
                                                        } else if (linkedList.get(0).getMsgId() < obtainMessage.getMsgId()) {
                                                            linkedList.remove(0);
                                                            linkedList.add(obtainMessage);
                                                        }
                                                        if (i5 == 4 && b.a.r0.l1.o.c.e().c(obtainMessage.getMsgId())) {
                                                            BdLog.i("msg is contained in PushIdsCacheManager");
                                                        } else if (obtainMessage.getMsgType() == 99) {
                                                            BdLog.i("msg is MSG_UNSHOW_OPERATER_ACCOUNT");
                                                        } else if (TbadkCoreApplication.getInst().getCustomizedFilter() == null || TbadkCoreApplication.getInst().getCustomizedFilter().b(4)) {
                                                            if (hashMap2.get(String.valueOf(j)) == null) {
                                                                GroupMsgData groupMsgData = new GroupMsgData(2012123);
                                                                groupMsgData.getGroupInfo().setUserType(i5);
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
                                                        if (b.a.e.e.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L) != msgInfo.userId.longValue()) {
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
                                                                    i7 = i4 + 1;
                                                                    responsePullMessage = this;
                                                                    getGroupMsgResIdl2 = getGroupMsgResIdl;
                                                                    size2 = i3;
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
                                                    i7 = i4 + 1;
                                                    responsePullMessage = this;
                                                    getGroupMsgResIdl2 = getGroupMsgResIdl;
                                                    size2 = i3;
                                                    groupInfo = groupInfo2;
                                                }
                                                i7 = i4 + 1;
                                                responsePullMessage = this;
                                                getGroupMsgResIdl2 = getGroupMsgResIdl;
                                                size2 = i3;
                                                groupInfo = groupInfo2;
                                            }
                                        }
                                        if (obtainMessage instanceof OfficialChatMessage) {
                                        }
                                        i7 = i4 + 1;
                                        responsePullMessage = this;
                                        getGroupMsgResIdl2 = getGroupMsgResIdl;
                                        size2 = i3;
                                        groupInfo = groupInfo2;
                                    }
                                    getGroupMsgResIdl = getGroupMsgResIdl2;
                                    i3 = size2;
                                    groupInfo2 = groupInfo;
                                    i4 = i7;
                                    i7 = i4 + 1;
                                    responsePullMessage = this;
                                    getGroupMsgResIdl2 = getGroupMsgResIdl;
                                    size2 = i3;
                                    groupInfo = groupInfo2;
                                }
                            }
                        }
                    }
                    i6++;
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

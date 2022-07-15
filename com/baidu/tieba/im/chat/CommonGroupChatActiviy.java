package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionImageActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.GroupMsgImageActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.PushMessage;
import com.baidu.tieba.im.message.ResponseDismissGroupMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.CommonGroupMsglistModel;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.tieba.im.model.PvCacheModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a97;
import com.repackage.bb;
import com.repackage.y87;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class CommonGroupChatActiviy<T> extends MsglistActivity<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public bb v;
    public CustomMessageListener w;

    /* loaded from: classes3.dex */
    public class a extends bb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CommonGroupChatActiviy a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(CommonGroupChatActiviy commonGroupChatActiviy, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonGroupChatActiviy, Integer.valueOf(i)};
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
            this.a = commonGroupChatActiviy;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            GroupData group;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) || socketResponsedMessage == null) {
                return;
            }
            switch (socketResponsedMessage.getCmd()) {
                case 103101:
                case 103110:
                case 103112:
                    this.a.b.refresh();
                    return;
                case 103104:
                    if (socketResponsedMessage instanceof ResponseDismissGroupMessage) {
                        ResponseDismissGroupMessage responseDismissGroupMessage = (ResponseDismissGroupMessage) socketResponsedMessage;
                        if (responseDismissGroupMessage.getError() != 0) {
                            return;
                        }
                        MsglistModel msglistModel = this.a.c;
                        if ((msglistModel instanceof CommonGroupMsglistModel) && (group = ((CommonGroupMsglistModel) msglistModel).getGroup()) != null && group.getGroupId() == responseDismissGroupMessage.getGroupId()) {
                            this.a.finish();
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CommonGroupChatActiviy a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(CommonGroupChatActiviy commonGroupChatActiviy, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonGroupChatActiviy, Integer.valueOf(i)};
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
            this.a = commonGroupChatActiviy;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            GroupNewsPojo p;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            switch (customResponsedMessage.getCmd()) {
                case 2001109:
                    this.a.b.refresh();
                    return;
                case 2001126:
                case 2001128:
                case 2001130:
                case 2001132:
                case 2001133:
                case 2001134:
                case 2001137:
                    if (!(customResponsedMessage instanceof PushMessage) || (p = ((PushMessage) customResponsedMessage).getP()) == null) {
                        return;
                    }
                    String cmd = p.getCmd();
                    if (TextUtils.isEmpty(cmd)) {
                        return;
                    }
                    this.a.b.refresh();
                    if (cmd.equals("kick_out")) {
                        this.a.s1(p);
                        return;
                    } else if (cmd.equals("group_name_change")) {
                        this.a.t1(p);
                        return;
                    } else if (cmd.equals("dismiss_group")) {
                        this.a.r1(p);
                        return;
                    } else {
                        return;
                    }
                default:
                    return;
            }
        }
    }

    public CommonGroupChatActiviy() {
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
        this.v = new a(this, 0);
        this.w = new b(this, 0);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void e1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.e1();
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void g1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.g1();
            registerListener(103110, this.v);
            registerListener(103101, this.v);
            registerListener(103112, this.v);
            registerListener(103104, this.v);
            registerListener(2001109, this.w);
            registerListener(2001126, this.w);
            registerListener(2001128, this.w);
            registerListener(2001134, this.w);
            registerListener(2001132, this.w);
            registerListener(2001130, this.w);
            registerListener(2001133, this.w);
            registerListener(2001137, this.w);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0032, code lost:
        r0 = r0.getContent();
     */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.repackage.hf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void h(View view2, int i, int i2, long j) {
        ChatMessage msg;
        MsglistModel msglistModel;
        ChatMessage msg2;
        String content;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            super.h(view2, i, i2, j);
            if (i == 2) {
                ChatMessage msg3 = this.c.getMsg(i2);
                if (msg3 == null || msg3.getUserInfo() == null) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getContext(), msg3.getUserInfo().getUserId(), msg3.getUserInfo().getUserName(), null, AddFriendActivityConfig.TYPE_IM_GROUP)));
            } else if (i != 4) {
                if (i == 7 && F0() && (msglistModel = this.c) != null && (msg2 = msglistModel.getMsg(i2)) != null && a97.u(msg2) && content != null) {
                    JSONObject jSONObject = null;
                    try {
                        try {
                            JSONArray jSONArray = new JSONArray(content);
                            if (jSONArray.length() > 0) {
                                jSONObject = jSONArray.getJSONObject(0);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    } catch (Exception unused) {
                        jSONObject = new JSONObject(content);
                    }
                    if (jSONObject != null) {
                        sendMessage(new CustomMessage(2902011, new EmotionImageActivityConfig(getPageContext().getContext(), jSONObject.optString("pid"), jSONObject.optString("packet_name"), jSONObject.optString("icon"), jSONObject.optString("url_s"), jSONObject.optString("url_d"), jSONObject.optString("face_name"), 3, jSONObject.optInt("size_width"), jSONObject.optInt("size_height"))));
                    }
                }
            } else if (F0() && (msg = this.c.getMsg(i2)) != null && a97.w(msg)) {
                String h = a97.h(msg.getContent(), true);
                String h2 = a97.h(msg.getContent(), false);
                if (h == null) {
                    return;
                }
                MsglistModel msglistModel2 = this.c;
                if (!(msglistModel2 instanceof CommonGroupMsglistModel) || ((CommonGroupMsglistModel) msglistModel2).getGroup() == null) {
                    return;
                }
                sendMessage(new CustomMessage(2002001, new GroupMsgImageActivityConfig(getPageContext().getContext(), h, ((CommonGroupMsglistModel) this.c).getGroup().getGroupId(), false, String.valueOf(msg.getMsgId()), h2)));
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void i1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.i1();
            MessageManager.getInstance().unRegisterListener(this.v);
            MessageManager.getInstance().unRegisterListener(this.w);
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.repackage.Cif
    public void m(View view2, int i, int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            super.m(view2, i, i2, j);
        }
    }

    public boolean m1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            GroupData group = ((CommonGroupMsglistModel) this.c).getGroup();
            return (group == null || group.getGroupId() == 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void n1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Intent intent = getIntent();
            boolean booleanExtra = intent.getBooleanExtra(IntentConfig.IS_ACCEPT_NOTIFY, true);
            MsglistModel msglistModel = this.c;
            if (msglistModel == null) {
                return;
            }
            msglistModel.setIsAcceptNotify(booleanExtra);
            p1(intent);
        }
    }

    public void o1(Bundle bundle) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            this.c.setIsAcceptNotify(bundle.getBoolean(IntentConfig.IS_ACCEPT_NOTIFY, true));
            q1(bundle);
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putBoolean(IntentConfig.IS_ACCEPT_NOTIFY, this.c.getIsAcceptNotify());
            if (((CommonGroupMsglistModel) this.c).getGroup() != null) {
                bundle.putString("group", OrmObject.jsonStrWithObject(((CommonGroupMsglistModel) this.c).getGroup()));
            }
        }
    }

    public void p1(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, intent) == null) {
            GroupData groupData = (GroupData) intent.getSerializableExtra("group");
            String stringExtra = intent.getStringExtra(GroupChatActivityConfig.GROUP_OBJ_TP);
            String valueOf = String.valueOf(groupData.getGroupId());
            if (!PvCacheModel.getInstance().isSameDay(valueOf)) {
                new y87(TbConfig.ST_TYPE_IM, stringExtra, valueOf).start();
                TiebaStatic.eventStat(TbadkApplication.getInst().getApp(), TbConfig.ST_TYPE_IM, "", 1, "obj_tp", stringExtra, "group_id", valueOf);
                PvCacheModel.getInstance().addCacheData(valueOf, Long.valueOf(System.currentTimeMillis()));
            }
            ((CommonGroupMsglistModel) this.c).setGroup(groupData);
        }
    }

    public void q1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            String string = bundle.getString("group");
            if (StringUtils.isNull(string)) {
                return;
            }
            ((CommonGroupMsglistModel) this.c).setGroup((GroupData) OrmObject.objectWithJsonStr(string, GroupData.class));
        }
    }

    public final void r1(GroupNewsPojo groupNewsPojo) {
        MsglistModel msglistModel;
        GroupData group;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, groupNewsPojo) == null) || groupNewsPojo == null || (msglistModel = this.c) == null || !(msglistModel instanceof CommonGroupMsglistModel) || (group = ((CommonGroupMsglistModel) msglistModel).getGroup()) == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
            String string = jSONObject.getJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM).getString(TbEnum.SystemMessage.KEY_GROUP_ID);
            if (jSONObject.getString(TbEnum.SystemMessage.KEY_EVENT_ID).equals(TbEnum.SystemMessage.EVENT_ID_DISMISS_GROUP) && string.equals(String.valueOf(group.getGroupId()))) {
                showToast(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f07f5), false);
                finish();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public final void s1(GroupNewsPojo groupNewsPojo) {
        MsglistModel msglistModel;
        GroupData group;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, groupNewsPojo) == null) || groupNewsPojo == null || (msglistModel = this.c) == null || !(msglistModel instanceof CommonGroupMsglistModel) || (group = ((CommonGroupMsglistModel) msglistModel).getGroup()) == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
            String string = jSONObject.getJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM).getString(TbEnum.SystemMessage.KEY_GROUP_ID);
            if (jSONObject.getString(TbEnum.SystemMessage.KEY_EVENT_ID).equals(TbEnum.SystemMessage.EVENT_ID_KICKED_OUT) && string.equals(String.valueOf(group.getGroupId()))) {
                showToast(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f07f6), false);
                finish();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public final void t1(GroupNewsPojo groupNewsPojo) {
        MsglistModel msglistModel;
        GroupData group;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, groupNewsPojo) == null) || groupNewsPojo == null || (msglistModel = this.c) == null || !(msglistModel instanceof CommonGroupMsglistModel) || (group = ((CommonGroupMsglistModel) msglistModel).getGroup()) == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
            JSONObject jSONObject2 = jSONObject.getJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
            String string = jSONObject2.getString(TbEnum.SystemMessage.KEY_GROUP_ID);
            if (jSONObject.getString(TbEnum.SystemMessage.KEY_EVENT_ID).equals("101") && string.equals(String.valueOf(group.getGroupId()))) {
                String string2 = jSONObject2.getString(TbEnum.SystemMessage.KEY_GROUP_NAME);
                if (TextUtils.isEmpty(string2)) {
                    return;
                }
                this.b.refreshHeaderFooter(string2, true);
                group.setName(string2);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

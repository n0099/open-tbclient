package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.e.c.g.c;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class CommonGroupChatActiviy<T> extends MsglistActivity<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener mCustomListener;
    public c mListener;

    /* loaded from: classes7.dex */
    public class a extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CommonGroupChatActiviy f52716a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(CommonGroupChatActiviy commonGroupChatActiviy, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonGroupChatActiviy, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52716a = commonGroupChatActiviy;
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
                    this.f52716a.mListView.refresh();
                    return;
                case 103104:
                    if (socketResponsedMessage instanceof ResponseDismissGroupMessage) {
                        ResponseDismissGroupMessage responseDismissGroupMessage = (ResponseDismissGroupMessage) socketResponsedMessage;
                        if (responseDismissGroupMessage.getError() != 0) {
                            return;
                        }
                        MsglistModel msglistModel = this.f52716a.mListModel;
                        if ((msglistModel instanceof CommonGroupMsglistModel) && (group = ((CommonGroupMsglistModel) msglistModel).getGroup()) != null && group.getGroupId() == responseDismissGroupMessage.getGroupId()) {
                            this.f52716a.finish();
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

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CommonGroupChatActiviy f52717a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(CommonGroupChatActiviy commonGroupChatActiviy, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonGroupChatActiviy, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52717a = commonGroupChatActiviy;
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
                    this.f52717a.mListView.refresh();
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
                    this.f52717a.mListView.refresh();
                    if (cmd.equals("apply_join_success")) {
                        return;
                    }
                    if (cmd.equals("kick_out")) {
                        this.f52717a.processKick(p);
                        return;
                    } else if (cmd.equals("group_name_change")) {
                        this.f52717a.processTitleChange(p);
                        return;
                    } else if (cmd.equals("dismiss_group")) {
                        this.f52717a.processDismissGroup(p);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mListener = new a(this, 0);
        this.mCustomListener = new b(this, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processDismissGroup(GroupNewsPojo groupNewsPojo) {
        MsglistModel msglistModel;
        GroupData group;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, groupNewsPojo) == null) || groupNewsPojo == null || (msglistModel = this.mListModel) == null || !(msglistModel instanceof CommonGroupMsglistModel) || (group = ((CommonGroupMsglistModel) msglistModel).getGroup()) == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
            String string = jSONObject.getJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM).getString(TbEnum.SystemMessage.KEY_GROUP_ID);
            if (jSONObject.getString(TbEnum.SystemMessage.KEY_EVENT_ID).equals(TbEnum.SystemMessage.EVENT_ID_DISMISS_GROUP) && string.equals(String.valueOf(group.getGroupId()))) {
                showToast(TbadkApplication.getInst().getString(R.string.group_is_dismiss), false);
                finish();
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processKick(GroupNewsPojo groupNewsPojo) {
        MsglistModel msglistModel;
        GroupData group;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, groupNewsPojo) == null) || groupNewsPojo == null || (msglistModel = this.mListModel) == null || !(msglistModel instanceof CommonGroupMsglistModel) || (group = ((CommonGroupMsglistModel) msglistModel).getGroup()) == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
            String string = jSONObject.getJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM).getString(TbEnum.SystemMessage.KEY_GROUP_ID);
            if (jSONObject.getString(TbEnum.SystemMessage.KEY_EVENT_ID).equals(TbEnum.SystemMessage.EVENT_ID_KICKED_OUT) && string.equals(String.valueOf(group.getGroupId()))) {
                showToast(TbadkApplication.getInst().getString(R.string.group_is_kicked), false);
                finish();
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processTitleChange(GroupNewsPojo groupNewsPojo) {
        MsglistModel msglistModel;
        GroupData group;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, groupNewsPojo) == null) || groupNewsPojo == null || (msglistModel = this.mListModel) == null || !(msglistModel instanceof CommonGroupMsglistModel) || (group = ((CommonGroupMsglistModel) msglistModel).getGroup()) == null) {
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
                this.mListView.refreshHeaderFooter(string2, true);
                group.setName(string2);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public boolean checkParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            GroupData group = ((CommonGroupMsglistModel) this.mListModel).getGroup();
            return (group == null || group.getGroupId() == 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public abstract boolean initData(Bundle bundle);

    public void initParam() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Intent intent = getIntent();
            boolean booleanExtra = intent.getBooleanExtra(IntentConfig.IS_ACCEPT_NOTIFY, true);
            MsglistModel msglistModel = this.mListModel;
            if (msglistModel == null) {
                return;
            }
            msglistModel.setIsAcceptNotify(booleanExtra);
            onInitParam(intent);
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public abstract void initView();

    public void onInitParam(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            String string = bundle.getString("group");
            if (StringUtils.isNull(string)) {
                return;
            }
            ((CommonGroupMsglistModel) this.mListModel).setGroup((GroupData) OrmObject.objectWithJsonStr(string, GroupData.class));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0032, code lost:
        r0 = r0.getContent();
     */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, c.a.e.e.h.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onItemViewClick(View view, int i2, int i3, long j2) {
        ChatMessage msg;
        MsglistModel msglistModel;
        ChatMessage msg2;
        String content;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)}) == null) {
            super.onItemViewClick(view, i2, i3, j2);
            if (i2 == 2) {
                ChatMessage msg3 = this.mListModel.getMsg(i3);
                if (msg3 == null || msg3.getUserInfo() == null) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getContext(), msg3.getUserInfo().getUserId(), msg3.getUserInfo().getUserName(), null, AddFriendActivityConfig.TYPE_IM_GROUP)));
            } else if (i2 != 4) {
                if (i2 == 7 && isExStorageOk() && (msglistModel = this.mListModel) != null && (msg2 = msglistModel.getMsg(i3)) != null && c.a.q0.j1.w.c.q(msg2) && content != null) {
                    JSONObject jSONObject = null;
                    try {
                        try {
                            JSONArray jSONArray = new JSONArray(content);
                            if (jSONArray.length() > 0) {
                                jSONObject = jSONArray.getJSONObject(0);
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    } catch (Exception unused) {
                        jSONObject = new JSONObject(content);
                    }
                    if (jSONObject != null) {
                        sendMessage(new CustomMessage(2902011, new EmotionImageActivityConfig(getPageContext().getContext(), jSONObject.optString("pid"), jSONObject.optString("packet_name"), jSONObject.optString("icon"), jSONObject.optString("url_s"), jSONObject.optString("url_d"), jSONObject.optString("face_name"), 3, jSONObject.optInt("size_width"), jSONObject.optInt("size_height"))));
                    }
                }
            } else if (isExStorageOk() && (msg = this.mListModel.getMsg(i3)) != null && c.a.q0.j1.w.c.s(msg)) {
                String f2 = c.a.q0.j1.w.c.f(msg.getContent(), true);
                String f3 = c.a.q0.j1.w.c.f(msg.getContent(), false);
                if (f2 == null) {
                    return;
                }
                MsglistModel msglistModel2 = this.mListModel;
                if (!(msglistModel2 instanceof CommonGroupMsglistModel) || ((CommonGroupMsglistModel) msglistModel2).getGroup() == null) {
                    return;
                }
                sendMessage(new CustomMessage(2002001, new GroupMsgImageActivityConfig(getPageContext().getContext(), f2, ((CommonGroupMsglistModel) this.mListModel).getGroup().getGroupId(), false, String.valueOf(msg.getMsgId()), f3)));
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, c.a.e.e.h.b
    public void onItemViewLongClick(View view, int i2, int i3, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)}) == null) {
            super.onItemViewLongClick(view, i2, i3, j2);
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putBoolean(IntentConfig.IS_ACCEPT_NOTIFY, this.mListModel.getIsAcceptNotify());
            if (((CommonGroupMsglistModel) this.mListModel).getGroup() != null) {
                bundle.putString("group", OrmObject.jsonStrWithObject(((CommonGroupMsglistModel) this.mListModel).getGroup()));
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void refreshHeadIcon() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.refreshHeadIcon();
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void regReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.regReceiver();
            registerListener(103110, this.mListener);
            registerListener(103101, this.mListener);
            registerListener(103112, this.mListener);
            registerListener(103104, this.mListener);
            registerListener(2001109, this.mCustomListener);
            registerListener(2001126, this.mCustomListener);
            registerListener(2001128, this.mCustomListener);
            registerListener(2001134, this.mCustomListener);
            registerListener(2001132, this.mCustomListener);
            registerListener(2001130, this.mCustomListener);
            registerListener(2001133, this.mCustomListener);
            registerListener(2001137, this.mCustomListener);
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void unregReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.unregReceiver();
            MessageManager.getInstance().unRegisterListener(this.mListener);
            MessageManager.getInstance().unRegisterListener(this.mCustomListener);
        }
    }

    public void onInitParam(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, intent) == null) {
            GroupData groupData = (GroupData) intent.getSerializableExtra("group");
            String stringExtra = intent.getStringExtra(GroupChatActivityConfig.GROUP_OBJ_TP);
            String valueOf = String.valueOf(groupData.getGroupId());
            if (!PvCacheModel.getInstance().isSameDay(valueOf)) {
                new c.a.q0.j1.w.a(TbConfig.ST_TYPE_IM, stringExtra, valueOf).start();
                TiebaStatic.eventStat(TbadkApplication.getInst().getApp(), TbConfig.ST_TYPE_IM, "", 1, "obj_tp", stringExtra, "group_id", valueOf);
                PvCacheModel.getInstance().addCacheData(valueOf, Long.valueOf(System.currentTimeMillis()));
            }
            ((CommonGroupMsglistModel) this.mListModel).setGroup(groupData);
        }
    }

    public void initParam(Bundle bundle) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            this.mListModel.setIsAcceptNotify(bundle.getBoolean(IntentConfig.IS_ACCEPT_NOTIFY, true));
            onInitParam(bundle);
        }
    }
}

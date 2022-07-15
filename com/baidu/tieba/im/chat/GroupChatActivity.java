package com.baidu.tieba.im.chat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.im.chat.AbsMsglistView;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.CommonGroupMsglistModel;
import com.baidu.tieba.im.model.GroupMsglistModel;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.d47;
import com.repackage.de5;
import com.repackage.he5;
import com.repackage.jd5;
import com.repackage.ny4;
import com.repackage.oi;
import com.repackage.q77;
/* loaded from: classes3.dex */
public class GroupChatActivity extends CommonGroupChatActiviy<GroupChatActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public class a extends de5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupData a;
        public final /* synthetic */ GroupChatActivity b;

        public a(GroupChatActivity groupChatActivity, GroupData groupData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatActivity, groupData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = groupChatActivity;
            this.a = groupData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.repackage.de5
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(q77.k().c(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.a.getGroupId()))) : (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements jd5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupData a;
        public final /* synthetic */ GroupChatActivity b;

        public b(GroupChatActivity groupChatActivity, GroupData groupData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatActivity, groupData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = groupChatActivity;
            this.a = groupData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jd5
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            GroupData groupData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, bool) == null) || bool == null) {
                return;
            }
            if (bool.booleanValue()) {
                this.b.b.closeNotNotify();
            } else {
                this.b.b.showNotNotfiy();
            }
            if (this.b.c == null || (groupData = this.a) == null) {
                return;
            }
            String name = groupData.getName();
            if (TextUtils.isEmpty(name)) {
                return;
            }
            this.b.b.refreshHeaderFooter(name, true);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements AbsMsglistView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatActivity a;

        public c(GroupChatActivity groupChatActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupChatActivity;
        }

        @Override // com.baidu.tieba.im.chat.AbsMsglistView.i
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.baidu.tieba.im.chat.AbsMsglistView.i
        public void b(VoiceData.VoiceModel voiceModel) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voiceModel) == null) || voiceModel == null) {
                return;
            }
            this.a.c.sendMsgVoice(voiceModel.voiceId, voiceModel.duration);
        }
    }

    public GroupChatActivity() {
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

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public boolean X0(d47 d47Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, d47Var)) == null) {
            this.c.loadFirst(d47Var);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.repackage.vg5
    public void Y(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public boolean a1(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle)) == null) {
            try {
                GroupMsglistModel groupMsglistModel = new GroupMsglistModel(this);
                this.c = groupMsglistModel;
                groupMsglistModel.setLoadDataCallBack(this.r);
                if (bundle != null) {
                    o1(bundle);
                } else {
                    n1();
                }
                return m1();
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void d1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            v1();
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy, com.baidu.tieba.im.chat.MsglistActivity
    public void e1() {
        GroupData group;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.e1();
            MsglistModel msglistModel = this.c;
            if ((msglistModel instanceof CommonGroupMsglistModel) && (group = ((CommonGroupMsglistModel) msglistModel).getGroup()) != null) {
                if (group != null) {
                    String name = group.getName();
                    if (!TextUtils.isEmpty(name)) {
                        this.b.refreshHeaderFooter(name, true);
                    }
                }
                he5.c(new a(this, group), new b(this, group));
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.b = new GroupChatView(this, this.c.getIsAcceptNotify());
            this.b.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
            MsglistModel msglistModel = this.c;
            if (msglistModel instanceof GroupMsglistModel) {
                long j = 0;
                if (((GroupMsglistModel) msglistModel).getGroup() != null) {
                    j = ((GroupMsglistModel) this.c).getGroup().getGroupId();
                    this.b.refreshHeaderFooter(((GroupMsglistModel) this.c).getGroup().getName(), true);
                }
                this.b.bindDataAndRefresh(this.c.getData(), j);
                this.b.setRecordCallback(new c(this));
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy, com.baidu.tieba.im.chat.TalkableActivity, com.repackage.Cif
    public void m(View view2, int i, int i2, long j) {
        ChatMessage msg;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            super.m(view2, i, i2, j);
            if (i != 2 || (msg = this.c.getMsg(i2)) == null || msg.getUserInfo() == null || msg.getUserInfo().getName_show() == null) {
                return;
            }
            this.b.addAt2SendMsg(msg.getUserInfo().getName_show());
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view2) == null) {
            super.onClick(view2);
            if (view2 == this.b.getBtnGroupInfo()) {
                sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(getPageContext().getContext(), ((GroupMsglistModel) this.c).getGroup().getGroupId(), 3)));
                String stringExtra = getIntent().getStringExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID);
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) || !TbadkCoreApplication.getCurrentAccount().equals(stringExtra)) {
                    return;
                }
                AbsMsglistView absMsglistView = this.b;
                if (absMsglistView instanceof GroupChatView) {
                    ((GroupChatView) absMsglistView).a();
                }
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onDestroy();
            ChatStatusManager.getInst().setCurId(2, "");
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, intent) == null) {
            MsglistModel msglistModel = this.c;
            if (msglistModel != null) {
                msglistModel.onDestroy();
                this.c = null;
            }
            super.onNewIntent(intent);
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onPause();
            ChatStatusManager.getInst().setIsOpen(2, false);
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onResume();
            ChatStatusManager.getInst().setIsOpen(2, true);
            String curId = ChatStatusManager.getInst().getCurId(2);
            ny4.f0().d(curId);
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(curId, 1)));
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy
    public void p1(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, intent) == null) {
            super.p1(intent);
            u1();
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy
    public void q1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            super.q1(bundle);
            u1();
        }
    }

    public final void u1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            MsglistModel msglistModel = this.c;
            if (msglistModel != null && (msglistModel instanceof GroupMsglistModel)) {
                GroupData group = ((GroupMsglistModel) msglistModel).getGroup();
                if (group != null) {
                    ChatStatusManager.getInst().setCurId(2, String.valueOf(group.getGroupId()));
                    return;
                } else {
                    ChatStatusManager.getInst().setCurId(2, "");
                    return;
                }
            }
            ChatStatusManager.getInst().setCurId(2, "");
        }
    }

    public final void v1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || getIntent() == null) {
            return;
        }
        String stringExtra = getIntent().getStringExtra(GroupChatActivityConfig.AUTO_SEND_EXTRA_MSG);
        if (!oi.isEmpty(stringExtra)) {
            getIntent().removeExtra(GroupChatActivityConfig.AUTO_SEND_EXTRA_MSG);
            this.c.sendExtraMessage(stringExtra);
        }
        String stringExtra2 = getIntent().getStringExtra(GroupChatActivityConfig.AUTO_SEND_TEXT_MSG);
        if (oi.isEmpty(stringExtra2) || stringExtra2.trim().length() <= 0) {
            return;
        }
        getIntent().removeExtra(GroupChatActivityConfig.AUTO_SEND_TEXT_MSG);
        this.c.sendTextMessage(stringExtra2);
    }
}

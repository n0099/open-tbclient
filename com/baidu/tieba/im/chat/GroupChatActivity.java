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
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
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
import d.a.c.e.p.k;
import d.a.r0.z0.f0;
import d.a.r0.z0.i0;
import d.a.r0.z0.n;
/* loaded from: classes5.dex */
public class GroupChatActivity extends CommonGroupChatActiviy<GroupChatActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a extends f0<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GroupData f17252a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GroupChatActivity f17253b;

        public a(GroupChatActivity groupChatActivity, GroupData groupData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatActivity, groupData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17253b = groupChatActivity;
            this.f17252a = groupData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.a.r0.z0.f0
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(d.a.s0.i1.t.b.k().c(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.f17252a.getGroupId()))) : (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements n<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GroupData f17254a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GroupChatActivity f17255b;

        public b(GroupChatActivity groupChatActivity, GroupData groupData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatActivity, groupData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17255b = groupChatActivity;
            this.f17254a = groupData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.r0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            GroupData groupData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, bool) == null) || bool == null) {
                return;
            }
            if (bool.booleanValue()) {
                this.f17255b.mListView.closeNotNotify();
            } else {
                this.f17255b.mListView.showNotNotfiy();
            }
            if (this.f17255b.mListModel == null || (groupData = this.f17254a) == null) {
                return;
            }
            String name = groupData.getName();
            if (TextUtils.isEmpty(name)) {
                return;
            }
            this.f17255b.mListView.refreshHeaderFooter(name, true);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements AbsMsglistView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GroupChatActivity f17256a;

        public c(GroupChatActivity groupChatActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17256a = groupChatActivity;
        }

        @Override // com.baidu.tieba.im.chat.AbsMsglistView.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.baidu.tieba.im.chat.AbsMsglistView.f
        public void b(VoiceData$VoiceModel voiceData$VoiceModel) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voiceData$VoiceModel) == null) || voiceData$VoiceModel == null) {
                return;
            }
            this.f17256a.mListModel.sendMsgVoice(voiceData$VoiceModel.voiceId, voiceData$VoiceModel.duration);
        }
    }

    public GroupChatActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void initCurId() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            MsglistModel msglistModel = this.mListModel;
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

    private void sendAutoMessage() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || getIntent() == null) {
            return;
        }
        String stringExtra = getIntent().getStringExtra(GroupChatActivityConfig.AUTO_SEND_EXTRA_MSG);
        if (!k.isEmpty(stringExtra)) {
            getIntent().removeExtra(GroupChatActivityConfig.AUTO_SEND_EXTRA_MSG);
            this.mListModel.sendExtraMessage(stringExtra);
        }
        String stringExtra2 = getIntent().getStringExtra(GroupChatActivityConfig.AUTO_SEND_TEXT_MSG);
        if (k.isEmpty(stringExtra2) || stringExtra2.trim().length() <= 0) {
            return;
        }
        getIntent().removeExtra(GroupChatActivityConfig.AUTO_SEND_TEXT_MSG);
        this.mListModel.sendTextMessage(stringExtra2);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public boolean first(d.a.s0.i1.f.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            this.mListModel.loadFirst(cVar);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy, com.baidu.tieba.im.chat.MsglistActivity
    public boolean initData(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle)) == null) {
            try {
                GroupMsglistModel groupMsglistModel = new GroupMsglistModel(this);
                this.mListModel = groupMsglistModel;
                groupMsglistModel.setLoadDataCallBack(this.mMsgCallback);
                if (bundle != null) {
                    initParam(bundle);
                } else {
                    initParam();
                }
                return checkParam();
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy, com.baidu.tieba.im.chat.MsglistActivity
    public void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.mListView = new GroupChatView(this, this.mListModel.getIsAcceptNotify());
            this.mListView.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
            MsglistModel msglistModel = this.mListModel;
            if (msglistModel instanceof GroupMsglistModel) {
                long j = 0;
                if (((GroupMsglistModel) msglistModel).getGroup() != null) {
                    j = ((GroupMsglistModel) this.mListModel).getGroup().getGroupId();
                    this.mListView.refreshHeaderFooter(((GroupMsglistModel) this.mListModel).getGroup().getName(), true);
                }
                this.mListView.bindDataAndRefresh(this.mListModel.getData(), j);
                this.mListView.setRecordCallback(new c(this));
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            super.onClick(view);
            if (view == this.mListView.getBtnGroupInfo()) {
                sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(getPageContext().getContext(), ((GroupMsglistModel) this.mListModel).getGroup().getGroupId(), 3)));
                String stringExtra = getIntent().getStringExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID);
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) || !TbadkCoreApplication.getCurrentAccount().equals(stringExtra)) {
                    return;
                }
                AbsMsglistView absMsglistView = this.mListView;
                if (absMsglistView instanceof GroupChatView) {
                    ((GroupChatView) absMsglistView).d();
                }
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            ChatStatusManager.getInst().setCurId(2, "");
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy
    public void onInitParam(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onInitParam(bundle);
            initCurId();
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy, com.baidu.tieba.im.chat.TalkableActivity, d.a.c.e.h.b
    public void onItemViewLongClick(View view, int i2, int i3, long j) {
        ChatMessage msg;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j)}) == null) {
            super.onItemViewLongClick(view, i2, i3, j);
            if (i2 != 2 || (msg = this.mListModel.getMsg(i3)) == null || msg.getUserInfo() == null || msg.getUserInfo().getName_show() == null) {
                return;
            }
            this.mListView.addAt2SendMsg(msg.getUserInfo().getName_show());
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, d.a.r0.b1.m.h
    public void onLinkButtonClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, intent) == null) {
            MsglistModel msglistModel = this.mListModel;
            if (msglistModel != null) {
                msglistModel.onDestroy();
                this.mListModel = null;
            }
            super.onNewIntent(intent);
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void onPageInited() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            sendAutoMessage();
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onPause();
            ChatStatusManager.getInst().setIsOpen(2, false);
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onResume();
            ChatStatusManager.getInst().setIsOpen(2, true);
            String curId = ChatStatusManager.getInst().getCurId(2);
            d.a.r0.s.d.b.g0().d(curId);
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(curId, 1)));
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy, com.baidu.tieba.im.chat.MsglistActivity
    public void refreshHeadIcon() {
        GroupData group;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.refreshHeadIcon();
            MsglistModel msglistModel = this.mListModel;
            if ((msglistModel instanceof CommonGroupMsglistModel) && (group = ((CommonGroupMsglistModel) msglistModel).getGroup()) != null) {
                if (group != null) {
                    String name = group.getName();
                    if (!TextUtils.isEmpty(name)) {
                        this.mListView.refreshHeaderFooter(name, true);
                    }
                }
                i0.c(new a(this, group), new b(this, group));
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonGroupChatActiviy
    public void onInitParam(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, intent) == null) {
            super.onInitParam(intent);
            initCurId();
        }
    }
}

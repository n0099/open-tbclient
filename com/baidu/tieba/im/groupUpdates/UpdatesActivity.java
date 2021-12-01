package com.baidu.tieba.im.groupUpdates;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AbsListView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.j;
import c.a.q0.d1.q;
import c.a.q0.s.s.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.GroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.core.atomData.GroupLevelActivityConfig;
import com.baidu.tbadk.core.dialog.PopupDialog;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.UpdatesItemData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.RequestDelSystemMessage;
import com.baidu.tieba.im.message.ResponseDelSystemMessage;
import com.baidu.tieba.im.model.UpdatesModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes10.dex */
public class UpdatesActivity extends BaseActivity<UpdatesActivity> implements AbsListView.OnScrollListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public q<Boolean> delDataCallBack;
    public PopupDialog deleteItemDialog;
    public q<LinkedList<GroupNewsPojo>> getDataCallBack;
    public boolean isEditMode;
    public Runnable loadImageRunnable;
    public CustomMessageListener mCustomListener;
    public c.a.d.c.g.c mListener;
    public UpdatesModel model;
    public UpdatesItemData pendingToDel;
    public c.a.r0.r1.j.c updatesView;

    /* loaded from: classes10.dex */
    public class a implements q<LinkedList<GroupNewsPojo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UpdatesActivity a;

        public a(UpdatesActivity updatesActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {updatesActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = updatesActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.d1.q
        /* renamed from: a */
        public void onReturnDataInUI(LinkedList<GroupNewsPojo> linkedList) {
            ImMessageCenterPojo imMessageCenterPojo;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, linkedList) == null) {
                List<UpdatesItemData> convertToUpdatesItemData = UpdatesModel.convertToUpdatesItemData(linkedList);
                this.a.updatesView.m(convertToUpdatesItemData);
                this.a.model.calculateSelects(convertToUpdatesItemData);
                this.a.updatesView.o(false);
                this.a.updatesView.n(this.a.model.getDeleteSize());
                this.a.loadImage();
                if (convertToUpdatesItemData == null || convertToUpdatesItemData.size() <= 0) {
                    imMessageCenterPojo = null;
                } else {
                    imMessageCenterPojo = new ImMessageCenterPojo();
                    imMessageCenterPojo.setLast_content(convertToUpdatesItemData.get(0).getContent());
                    imMessageCenterPojo.setLast_content_time(convertToUpdatesItemData.get(0).getTime());
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001210, imMessageCenterPojo));
                if (convertToUpdatesItemData == null || convertToUpdatesItemData.size() != 0) {
                    return;
                }
                this.a.finish();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements q<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UpdatesActivity f46031b;

        public b(UpdatesActivity updatesActivity, q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {updatesActivity, qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46031b = updatesActivity;
            this.a = qVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.d1.q
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                this.f46031b.model.clearSelect();
                this.f46031b.updatesView.c();
                this.f46031b.setEditMode(false);
                UpdatesModel.requestUpdatesDataFromDB(this.a);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class c implements q<LinkedList<GroupNewsPojo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UpdatesActivity a;

        public c(UpdatesActivity updatesActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {updatesActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = updatesActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.d1.q
        /* renamed from: a */
        public void onReturnDataInUI(LinkedList<GroupNewsPojo> linkedList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, linkedList) == null) {
                List<UpdatesItemData> convertToUpdatesItemData = UpdatesModel.convertToUpdatesItemData(linkedList);
                this.a.updatesView.m(convertToUpdatesItemData);
                this.a.model.calculateSelects(convertToUpdatesItemData);
                this.a.updatesView.o(false);
                this.a.updatesView.n(this.a.model.getDeleteSize());
                this.a.loadImage();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class d implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UpdatesActivity f46032e;

        public d(UpdatesActivity updatesActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {updatesActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46032e = updatesActivity;
        }

        @Override // c.a.q0.s.s.i.e
        public void onItemClick(i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                if (this.f46032e.deleteItemDialog != null && this.f46032e.deleteItemDialog.isShowing()) {
                    this.f46032e.deleteItemDialog.dismiss();
                }
                if (i2 != 0) {
                    return;
                }
                this.f46032e.updatesView.o(true);
                UpdatesActivity updatesActivity = this.f46032e;
                updatesActivity.processDel(updatesActivity.pendingToDel);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class e extends c.a.d.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UpdatesActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(UpdatesActivity updatesActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {updatesActivity, Integer.valueOf(i2)};
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
            this.a = updatesActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) {
                this.a.updatesView.o(false);
                if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponsedMessage) && 202004 == socketResponsedMessage.getCmd()) {
                    ResponseDelSystemMessage responseDelSystemMessage = (ResponseDelSystemMessage) socketResponsedMessage;
                    RequestDelSystemMessage requestDelSystemMessage = (RequestDelSystemMessage) responseDelSystemMessage.getOrginalMessage();
                    if (responseDelSystemMessage.getError() != 0) {
                        return;
                    }
                    if (this.a.pendingToDel != null) {
                        UpdatesModel.deleteUpdatesData(this.a.pendingToDel, this.a.delDataCallBack);
                        this.a.pendingToDel = null;
                    }
                    if (this.a.model == null || this.a.model.getDeleteSize() <= 0) {
                        return;
                    }
                    this.a.model.deleteDatas(this.a.delDataCallBack);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UpdatesActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(UpdatesActivity updatesActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {updatesActivity, Integer.valueOf(i2)};
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
            this.a = updatesActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.updatesView.o(false);
                if (customResponsedMessage != null && (customResponsedMessage instanceof ResponsedMessage)) {
                    int cmd = customResponsedMessage.getCmd();
                    if (2001132 == cmd || 2001133 == cmd || 2001130 == cmd || 2001129 == cmd || 2001137 == cmd) {
                        UpdatesModel.requestUpdatesDataFromDB(this.a.getDataCallBack);
                    }
                }
            }
        }
    }

    public UpdatesActivity() {
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
        this.isEditMode = false;
        this.mListener = new e(this, 0);
        this.mCustomListener = new f(this, 0);
    }

    private void initDataCallBack() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.delDataCallBack = new b(this, new a(this));
            this.getDataCallBack = new c(this);
        }
    }

    private void initDeleteDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            String string = getPageContext().getString(R.string.delete_user_chat);
            d dVar = new d(this);
            PopupDialog popupDialog = new PopupDialog(getPageContext());
            this.deleteItemDialog = popupDialog;
            popupDialog.setDefaultContentView(null, new String[]{string}, dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadImage() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65548, this) == null) || this.updatesView.j() == null) {
            return;
        }
        this.updatesView.j().removeCallbacks(this.loadImageRunnable);
        this.updatesView.j().post(this.loadImageRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processDel(UpdatesItemData updatesItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, updatesItemData) == null) {
            if (!j.z()) {
                showToast(R.string.neterror);
            } else if (updatesItemData == null || TextUtils.isEmpty(c.a.r0.r1.p.b.b().c()) || !TextUtils.isDigitsOnly(c.a.r0.r1.p.b.b().c()) || TextUtils.isEmpty(updatesItemData.getNotice_id()) || !TextUtils.isDigitsOnly(updatesItemData.getNotice_id())) {
            } else {
                try {
                    this.updatesView.o(true);
                    RequestDelSystemMessage requestDelSystemMessage = new RequestDelSystemMessage();
                    requestDelSystemMessage.setGroupId(c.a.d.f.m.b.g(c.a.r0.r1.p.b.b().c(), 0L));
                    long parseLong = Long.parseLong(updatesItemData.getNotice_id());
                    requestDelSystemMessage.setMsgIds("" + (parseLong / 100));
                    MessageManager.getInstance().sendMessage(requestDelSystemMessage);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void startActivity(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65551, null, context) == null) || context == null) {
            return;
        }
        Intent intent = new Intent(context, UpdatesActivity.class);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    public boolean isEditMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.isEditMode : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            super.onChangeSkinType(i2);
            c.a.r0.r1.j.c cVar = this.updatesView;
            if (cVar != null) {
                cVar.onChangeSkinType(i2);
            }
        }
    }

    public void onCheckedChanged(View view, boolean z, UpdatesItemData updatesItemData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{view, Boolean.valueOf(z), updatesItemData}) == null) || updatesItemData == null) {
            return;
        }
        if (z) {
            this.model.addSelect(updatesItemData);
            updatesItemData.setSelected(true);
            if (this.model.getDeleteSize() > 100) {
                this.model.cancelSelect(updatesItemData);
                updatesItemData.setSelected(false);
                showToast(R.string.updates_activity_del_limit);
            }
        } else {
            this.model.cancelSelect(updatesItemData);
            updatesItemData.setSelected(false);
        }
        this.updatesView.n(this.model.getDeleteSize());
        this.updatesView.l();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c.a.r0.r1.j.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view) == null) || view == null || (cVar = this.updatesView) == null) {
            return;
        }
        if (view.equals(cVar.e())) {
            finish();
        } else if (view.equals(this.updatesView.h())) {
            this.model.clearSelect();
            this.model.calculateSelects(this.updatesView.i().b());
            this.updatesView.n(this.model.getDeleteSize());
            setEditMode(true);
            this.updatesView.d();
        } else if (view.equals(this.updatesView.f())) {
            setEditMode(false);
            this.updatesView.c();
            this.model.clearSelect();
            UpdatesModel.requestUpdatesDataFromDB(this.getDataCallBack);
        } else if (view.equals(this.updatesView.g())) {
            this.updatesView.o(true);
            String deleteDatasIds = this.model.deleteDatasIds();
            if (!TextUtils.isEmpty(deleteDatasIds)) {
                processDel(deleteDatasIds);
            } else {
                this.updatesView.o(false);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            this.model = new UpdatesModel();
            this.updatesView = new c.a.r0.r1.j.c(this);
            initDataCallBack();
            registerListener(2001132, this.mCustomListener);
            registerListener(2001133, this.mCustomListener);
            registerListener(2001130, this.mCustomListener);
            registerListener(2001129, this.mCustomListener);
            registerListener(2001137, this.mCustomListener);
            this.updatesView.o(true);
            UpdatesModel.requestUpdatesDataFromDB(this.getDataCallBack);
            registerListener(202004, this.mListener);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            c.a.r0.r1.j.c cVar = this.updatesView;
            if (cVar != null) {
                cVar.destroy();
            }
            UpdatesModel updatesModel = this.model;
            if (updatesModel != null) {
                updatesModel.destory();
            }
            this.pendingToDel = null;
        }
    }

    public void onItemViewClick(View view, int i2, int i3, long j2, UpdatesItemData updatesItemData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), updatesItemData}) == null) || updatesItemData == null || 101 != i2 || isEditMode()) {
            return;
        }
        String groupId = updatesItemData.getGroupId();
        String updatesType = updatesItemData.getUpdatesType();
        if (TextUtils.isEmpty(updatesType)) {
            return;
        }
        try {
            if (updatesType.equals("group_level_up")) {
                sendMessage(new CustomMessage(2002001, new GroupLevelActivityConfig(getPageContext().getPageActivity(), c.a.d.f.m.b.g(groupId, 0L), updatesItemData.isShown())));
            } else if (updatesType.equals("dismiss_group")) {
            } else {
                if (updatesType.equals("group_event_info")) {
                    TiebaStatic.log("update_activity_group_event_click");
                    UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{updatesItemData.getEventLink()});
                } else if (updatesType.equals("group_activitys_change")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupActivityActivityConfig(getPageContext().getPageActivity(), c.a.d.f.m.b.e(updatesItemData.getGroupActivityId(), 0), c.a.d.f.m.b.g(updatesItemData.getGroupId(), 0L), 1)));
                } else {
                    sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(getPageContext().getPageActivity(), Long.parseLong(groupId), 0)));
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onItemViewLongClick(View view, int i2, int i3, long j2, UpdatesItemData updatesItemData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), updatesItemData}) == null) || view == null || updatesItemData == null || 200 != i2 || isEditMode()) {
            return;
        }
        if (this.deleteItemDialog == null) {
            this.pendingToDel = updatesItemData;
            initDeleteDialog();
        }
        this.deleteItemDialog.showDialog();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, keyEvent)) == null) {
            if (4 == i2 && keyEvent.getAction() == 0 && this.isEditMode) {
                setEditMode(false);
                this.model.clearSelect();
                this.updatesView.n(this.model.getDeleteSize());
                this.updatesView.c();
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onPause();
            ChatStatusManager.getInst().setIsOpen(6, false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRestart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onRestart();
            ChatStatusManager.getInst().setIsOpen(6, true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onResume();
            ChatStatusManager.getInst().setIsOpen(6, true);
            c.a.q0.t.d.b.g0().f(2);
            c.a.q0.t.d.b.g0().g();
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(TbEnum.CustomGroupId.GROUP_UPDATE, -3)));
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048588, this, absListView, i2, i3, i4) == null) {
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048589, this, absListView, i2) == null) && i2 == 0) {
            loadImage();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onStart();
            ChatStatusManager.getInst().setIsOpen(6, true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onStop();
            ChatStatusManager.getInst().setIsOpen(6, false);
        }
    }

    public void setEditMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.isEditMode = z;
        }
    }

    private void processDel(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, str) == null) {
            if (!j.z()) {
                showToast(R.string.neterror);
            } else if (TextUtils.isEmpty(str)) {
            } else {
                String c2 = c.a.r0.r1.p.b.b().c();
                if (TextUtils.isEmpty(c2) || !TextUtils.isDigitsOnly(c2)) {
                    return;
                }
                this.updatesView.o(true);
                RequestDelSystemMessage requestDelSystemMessage = new RequestDelSystemMessage();
                requestDelSystemMessage.setGroupId(c.a.d.f.m.b.g(c2, 0L));
                requestDelSystemMessage.setMsgIds(str);
                MessageManager.getInstance().sendMessage(requestDelSystemMessage);
            }
        }
    }
}

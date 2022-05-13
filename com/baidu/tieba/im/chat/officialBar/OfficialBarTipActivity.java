package com.baidu.tieba.im.chat.officialBar;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SingleForumBroadcastFeedActivityConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.R;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.RequestSendPVTJMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.im.model.AddMsgRecordModel;
import com.baidu.tieba.im.model.OfficialBarTipModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.gz4;
import com.repackage.nr4;
import com.repackage.qr4;
import com.repackage.r47;
import com.repackage.s47;
import com.repackage.s77;
import com.repackage.u57;
import com.repackage.wr4;
import com.repackage.y47;
import com.repackage.ya;
import com.repackage.yr4;
import java.util.List;
/* loaded from: classes3.dex */
public class OfficialBarTipActivity extends BaseActivity<OfficialBarTipActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final s47 IProcessImpl;
    public r47 mCompleteProcess;
    public final CustomMessageListener mMemoryListener;
    public OfficialBarTipModel mModel;
    public qr4 mProgressDialog;
    public final ya mSubscribeListener;
    public ImMessageCenterShowItemData mUnsubscribeItem;
    public y47 mView;

    /* loaded from: classes3.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OfficialBarTipActivity a;

        public a(OfficialBarTipActivity officialBarTipActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {officialBarTipActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = officialBarTipActivity;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            ImMessageCenterShowItemData item;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) || (item = this.a.mView.k().getItem(i)) == null || view2 == null) {
                return;
            }
            if (this.a.mView.k().c()) {
                ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091cc4);
                if (item.isSelected()) {
                    item.setSelected(false);
                    SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
                    SkinManager.setBackgroundResource(imageView, R.drawable.btn_bgb_choice_n);
                    if (this.a.hasSelectedData()) {
                        return;
                    }
                    this.a.mView.t(false);
                    return;
                }
                item.setSelected(true);
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0205);
                SkinManager.setBackgroundResource(imageView, R.drawable.btn_bgb_choice_s);
                this.a.mView.s(true);
                return;
            }
            try {
                long parseLong = Long.parseLong(item.getFriendId());
                RequestSendPVTJMessage.sendOfficialBarPVTJ(RequestSendPVTJMessage.TYPE_V_MREAD, parseLong + "");
                TiebaStatic.log("c12936");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SingleForumBroadcastFeedActivityConfig(this.a.getActivity(), item.getFriendId(), item.getFriendName())));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements AdapterView.OnItemLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OfficialBarTipActivity a;

        /* loaded from: classes3.dex */
        public class a implements yr4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ wr4 a;
            public final /* synthetic */ ImMessageCenterShowItemData b;
            public final /* synthetic */ b c;

            /* renamed from: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class C0197a implements nr4.e {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public C0197a(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = aVar;
                }

                @Override // com.repackage.nr4.e
                public void onClick(nr4 nr4Var) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                        nr4Var.dismiss();
                        this.a.c.a.mModel.subscribeBar(false, this.a.b.getFriendId());
                        a aVar = this.a;
                        aVar.c.a.mUnsubscribeItem = aVar.b;
                    }
                }
            }

            /* renamed from: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity$b$a$b  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class C0198b implements nr4.e {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                public C0198b(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.repackage.nr4.e
                public void onClick(nr4 nr4Var) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                        nr4Var.dismiss();
                    }
                }
            }

            public a(b bVar, wr4 wr4Var, ImMessageCenterShowItemData imMessageCenterShowItemData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, wr4Var, imMessageCenterShowItemData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = bVar;
                this.a = wr4Var;
                this.b = imMessageCenterShowItemData;
            }

            @Override // com.repackage.yr4.e
            public void onItemClick(yr4 yr4Var, int i, View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIL(1048576, this, yr4Var, i, view2) == null) {
                    wr4 wr4Var = this.a;
                    if (wr4Var != null && wr4Var.isShowing()) {
                        this.a.dismiss();
                    }
                    if (i == 0) {
                        this.c.a.mModel.asyncDeleteItem(this.b, this.c.a.IProcessImpl);
                        return;
                    }
                    nr4 a = gz4.a(this.c.a.getPageContext(), -1, R.string.obfuscated_res_0x7f0f0a79, R.string.obfuscated_res_0x7f0f0428, R.string.obfuscated_res_0x7f0f0374, new C0197a(this), new C0198b(this));
                    a.setMessageShowCenter(true);
                    a.show();
                }
            }
        }

        public b(OfficialBarTipActivity officialBarTipActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {officialBarTipActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = officialBarTipActivity;
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view2, int i, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)})) == null) {
                ImMessageCenterShowItemData item = this.a.mView.k().getItem(i);
                if (item != null) {
                    if (this.a.mView.k().c()) {
                        ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091cc4);
                        if (item.isSelected()) {
                            item.setSelected(false);
                            SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
                            SkinManager.setBackgroundResource(imageView, R.drawable.btn_bgb_choice_n);
                            if (!this.a.hasSelectedData()) {
                                this.a.mView.s(false);
                            }
                        } else {
                            item.setSelected(true);
                            SkinManager.setBackgroundColor(view2, R.color.CAM_X0205);
                            SkinManager.setBackgroundResource(imageView, R.drawable.btn_bgb_choice_s);
                            this.a.mView.s(true);
                        }
                        return true;
                    }
                    String[] strArr = {TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04b6), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f037d)};
                    wr4 wr4Var = new wr4(this.a.getPageContext());
                    wr4Var.j(null, strArr, new a(this, wr4Var, item));
                    wr4Var.m();
                }
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OfficialBarTipActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(OfficialBarTipActivity officialBarTipActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {officialBarTipActivity, Integer.valueOf(i)};
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
            this.a = officialBarTipActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (customResponsedMessage.getCmd() == 2016002) {
                this.a.processMemoryInitComplete(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016004) {
                this.a.processMemoryChanged(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016007) {
                this.a.processResponsedMemoryList(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016001) {
                this.a.mModel.setData(null, this.a.mCompleteProcess);
            } else if (customResponsedMessage.getCmd() != 2016011 || this.a.mView == null || this.a.mView.k() == null) {
            } else {
                this.a.mView.k().notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends ya {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OfficialBarTipActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(OfficialBarTipActivity officialBarTipActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {officialBarTipActivity, Integer.valueOf(i)};
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
            this.a = officialBarTipActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            String errorString;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage)) {
                ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage;
                Message<?> orginalMessage = responseUpdateMaskInfoMessage.getOrginalMessage();
                if (orginalMessage instanceof RequestUpdateMaskInfoMessage) {
                    RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                    if (requestUpdateMaskInfoMessage.getMaskType() == 12 && requestUpdateMaskInfoMessage.getIsMask() == 1) {
                        if (responseUpdateMaskInfoMessage.getError() == 0) {
                            this.a.onUnSubscribe(requestUpdateMaskInfoMessage.getList());
                            return;
                        }
                        if (StringUtils.isNull(responseUpdateMaskInfoMessage.getErrorString())) {
                            errorString = this.a.getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c2d);
                        } else {
                            errorString = responseUpdateMaskInfoMessage.getErrorString();
                        }
                        this.a.getPageContext().showToast(errorString);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements r47 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OfficialBarTipActivity a;

        public e(OfficialBarTipActivity officialBarTipActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {officialBarTipActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = officialBarTipActivity;
        }

        @Override // com.repackage.r47
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.onCompleteProcess();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ OfficialBarTipActivity b;

        public f(OfficialBarTipActivity officialBarTipActivity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {officialBarTipActivity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = officialBarTipActivity;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                if (TextUtils.isEmpty(this.a)) {
                    return null;
                }
                s77.j().f(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.a), false);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class g implements s47 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OfficialBarTipActivity a;

        public g(OfficialBarTipActivity officialBarTipActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {officialBarTipActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = officialBarTipActivity;
        }

        @Override // com.repackage.s47
        public void onCanceled() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.dismissDialog();
                this.a.onCompleteProcess();
            }
        }

        @Override // com.repackage.s47
        public void onPostExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.dismissDialog();
                this.a.showToast(R.string.obfuscated_res_0x7f0f04ab, false);
                this.a.onCompleteProcess();
            }
        }

        @Override // com.repackage.s47
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.showProgressDialog();
            }
        }

        @Override // com.repackage.s47
        public void onProgressUpdate(int i, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) {
                if (this.a.mProgressDialog != null) {
                    this.a.mProgressDialog.b(i);
                }
                this.a.notifyDataSetChanged();
            }
        }
    }

    public OfficialBarTipActivity() {
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
        this.mMemoryListener = new c(this, 0);
        this.mSubscribeListener = new d(this, 104102);
        this.mCompleteProcess = new e(this);
        this.IProcessImpl = new g(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            qr4 qr4Var = this.mProgressDialog;
            if (qr4Var != null && qr4Var.isShowing()) {
                this.mProgressDialog.dismiss();
                this.mProgressDialog = null;
            }
            closeLoadingDialog();
            dismissAllDialog();
        }
    }

    private void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            this.mModel = new OfficialBarTipModel(getPageContext());
        }
    }

    private void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            y47 y47Var = new y47(this);
            this.mView = y47Var;
            y47Var.l().setOnItemClickListener(new a(this));
            this.mView.l().setOnItemLongClickListener(new b(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyDataSetChanged() {
        y47 y47Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65554, this) == null) || (y47Var = this.mView) == null || y47Var.k() == null) {
            return;
        }
        this.mView.k().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCompleteProcess() {
        y47 y47Var;
        OfficialBarTipModel officialBarTipModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65555, this) == null) || (y47Var = this.mView) == null || y47Var.k() == null || (officialBarTipModel = this.mModel) == null) {
            return;
        }
        if (officialBarTipModel != null && officialBarTipModel.isEmpty()) {
            finish();
        }
        new AddMsgRecordModel().req();
        this.mView.q(this.mModel.getData());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onUnSubscribe(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, this, str) == null) {
            this.mModel.asyncDeleteItem(this.mUnsubscribeItem, this.IProcessImpl);
            new f(this, str).execute(new Void[0]);
            MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processMemoryChanged(CustomResponsedMessage<?> customResponsedMessage) {
        OfficialBarTipModel officialBarTipModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65557, this, customResponsedMessage) == null) && (customResponsedMessage instanceof MemoryChangedMessage)) {
            MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
            ImMessageCenterPojo data = memoryChangedMessage.getData();
            if (memoryChangedMessage.getType() == 1) {
                OfficialBarTipModel officialBarTipModel2 = this.mModel;
                if (officialBarTipModel2 != null) {
                    officialBarTipModel2.insertOrUpdate(data, this.mCompleteProcess);
                }
            } else if (memoryChangedMessage.getType() != 2 || (officialBarTipModel = this.mModel) == null) {
            } else {
                officialBarTipModel.remove(data, this.mCompleteProcess);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processMemoryInitComplete(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65558, this, customResponsedMessage) == null) && (customResponsedMessage instanceof MemoryInitCompleteMessage) && ((MemoryInitCompleteMessage) customResponsedMessage).getData().booleanValue()) {
            sendMessage(new RequestMemoryListMessage(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processResponsedMemoryList(CustomResponsedMessage<?> customResponsedMessage) {
        OfficialBarTipModel officialBarTipModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65559, this, customResponsedMessage) == null) && (customResponsedMessage instanceof ResponsedMemoryListMessage)) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() != 2 || (officialBarTipModel = this.mModel) == null) {
                return;
            }
            officialBarTipModel.setData(data, this.mCompleteProcess);
        }
    }

    private void registerListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            registerListener(2016004, this.mMemoryListener);
            registerListener(2016007, this.mMemoryListener);
            registerListener(2016001, this.mMemoryListener);
            registerListener(2016011, this.mMemoryListener);
            registerListener(2016002, this.mMemoryListener);
            registerListener(this.mSubscribeListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showProgressDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, this) == null) {
            dismissDialog();
            if (this.mProgressDialog == null) {
                this.mProgressDialog = u57.m().p(getPageContext().getPageActivity());
            }
            this.mProgressDialog.show();
            this.mProgressDialog.b(0);
        }
    }

    public void deleteSelectedDatas() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mModel.deleteSelectedDatas(this.IProcessImpl);
        }
    }

    public boolean hasNoRead() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<ImMessageCenterShowItemData> data = this.mModel.getData();
            for (int i = 0; i != data.size(); i++) {
                if (data.get(i).getUnReadCount() != 0) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean hasSelectedData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<ImMessageCenterShowItemData> data = this.mModel.getData();
            for (int i = 0; i != data.size(); i++) {
                if (data.get(i).isSelected()) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.mView.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            initData();
            initUI();
            registerListener();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            dismissDialog();
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRestart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onRestart();
            ChatStatusManager.getInst().setIsOpen(4, true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onResume();
            this.mView.k().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onStart();
            ChatStatusManager.getInst().setIsOpen(4, true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onStop();
            ChatStatusManager.getInst().setIsOpen(4, false);
        }
    }

    public void setAllRead() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            List<ImMessageCenterShowItemData> data = this.mModel.getData();
            for (int i = 0; i != data.size(); i++) {
                MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.get(i).getFriendId(), 4)));
                data.get(i).setUnReadCount(0);
            }
            this.mView.q(this.mModel.getData());
        }
    }

    public void updateEditStatus(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.mModel.updateEditStatus(z);
            this.mView.q(this.mModel.getData());
        }
    }
}

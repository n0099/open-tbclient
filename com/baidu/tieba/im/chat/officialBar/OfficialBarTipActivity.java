package com.baidu.tieba.im.chat.officialBar;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.SocketMessageListener;
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
import com.baidu.tbadk.coreExtra.util.DialogUtil;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.R;
import com.baidu.tieba.at8;
import com.baidu.tieba.bt8;
import com.baidu.tieba.du8;
import com.baidu.tieba.f05;
import com.baidu.tieba.gt8;
import com.baidu.tieba.h05;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.RequestSendPVTJMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.im.model.AddMsgRecordModel;
import com.baidu.tieba.im.model.OfficialBarTipModel;
import com.baidu.tieba.im.settingcache.OfficialSettingCache;
import com.baidu.tieba.n05;
import com.baidu.tieba.p05;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class OfficialBarTipActivity extends BaseActivity<OfficialBarTipActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public OfficialBarTipModel a;
    public gt8 b;
    public ImMessageCenterShowItemData c;
    public h05 d;
    public final CustomMessageListener e;
    public final SocketMessageListener f;
    public at8 g;
    public final bt8 h;

    /* loaded from: classes6.dex */
    public class b implements AdapterView.OnItemLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OfficialBarTipActivity a;

        /* loaded from: classes6.dex */
        public class a implements p05.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ n05 a;
            public final /* synthetic */ ImMessageCenterShowItemData b;
            public final /* synthetic */ b c;

            /* renamed from: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class C0334a implements f05.e {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public C0334a(a aVar) {
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

                @Override // com.baidu.tieba.f05.e
                public void onClick(f05 f05Var) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                        f05Var.dismiss();
                        this.a.c.a.a.subscribeBar(false, this.a.b.getFriendId());
                        a aVar = this.a;
                        aVar.c.a.c = aVar.b;
                    }
                }
            }

            /* renamed from: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity$b$a$b  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class C0335b implements f05.e {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                public C0335b(a aVar) {
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

                @Override // com.baidu.tieba.f05.e
                public void onClick(f05 f05Var) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                        f05Var.dismiss();
                    }
                }
            }

            public a(b bVar, n05 n05Var, ImMessageCenterShowItemData imMessageCenterShowItemData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, n05Var, imMessageCenterShowItemData};
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
                this.a = n05Var;
                this.b = imMessageCenterShowItemData;
            }

            @Override // com.baidu.tieba.p05.f
            public void E0(p05 p05Var, int i, View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIL(1048576, this, p05Var, i, view2) == null) {
                    n05 n05Var = this.a;
                    if (n05Var != null && n05Var.isShowing()) {
                        this.a.dismiss();
                    }
                    if (i == 0) {
                        this.c.a.a.asyncDeleteItem(this.b, this.c.a.h);
                        return;
                    }
                    f05 createAlertDialog = DialogUtil.createAlertDialog(this.c.a.getPageContext(), -1, (int) R.string.make_sure_cancel_subscribe, (int) R.string.obfuscated_res_0x7f0f04d2, (int) R.string.obfuscated_res_0x7f0f03db, new C0334a(this), new C0335b(this));
                    createAlertDialog.setMessageShowCenter(true);
                    createAlertDialog.show();
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
                ImMessageCenterShowItemData item = this.a.b.C().getItem(i);
                if (item != null) {
                    if (this.a.b.C().c()) {
                        ImageView imageView = (ImageView) view2.findViewById(R.id.select_status);
                        if (item.isSelected()) {
                            item.setSelected(false);
                            SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
                            SkinManager.setBackgroundResource(imageView, R.drawable.btn_bgb_choice_n);
                            if (!this.a.g1()) {
                                this.a.b.J(false);
                            }
                        } else {
                            item.setSelected(true);
                            SkinManager.setBackgroundColor(view2, R.color.CAM_X0205);
                            SkinManager.setBackgroundResource(imageView, R.drawable.btn_bgb_choice_s);
                            this.a.b.J(true);
                        }
                        return true;
                    }
                    String[] strArr = {TbadkCoreApplication.getInst().getString(R.string.delete_user_chat), TbadkCoreApplication.getInst().getString(R.string.cancel_subscribe)};
                    n05 n05Var = new n05(this.a.getPageContext());
                    n05Var.i(null, strArr, new a(this, n05Var, item));
                    n05Var.l();
                }
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
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
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) && (item = this.a.b.C().getItem(i)) != null && view2 != null) {
                if (this.a.b.C().c()) {
                    ImageView imageView = (ImageView) view2.findViewById(R.id.select_status);
                    if (item.isSelected()) {
                        item.setSelected(false);
                        SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
                        SkinManager.setBackgroundResource(imageView, R.drawable.btn_bgb_choice_n);
                        if (!this.a.g1()) {
                            this.a.b.K(false);
                            return;
                        }
                        return;
                    }
                    item.setSelected(true);
                    SkinManager.setBackgroundColor(view2, R.color.CAM_X0205);
                    SkinManager.setBackgroundResource(imageView, R.drawable.btn_bgb_choice_s);
                    this.a.b.J(true);
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
    }

    /* loaded from: classes6.dex */
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            if (customResponsedMessage.getCmd() != 2016002) {
                if (customResponsedMessage.getCmd() != 2016004) {
                    if (customResponsedMessage.getCmd() != 2016007) {
                        if (customResponsedMessage.getCmd() == 2016001) {
                            this.a.a.setData(null, this.a.g);
                            return;
                        } else if (customResponsedMessage.getCmd() == 2016011 && this.a.b != null && this.a.b.C() != null) {
                            this.a.b.C().notifyDataSetChanged();
                            return;
                        } else {
                            return;
                        }
                    }
                    this.a.q1(customResponsedMessage);
                    return;
                }
                this.a.k1(customResponsedMessage);
                return;
            }
            this.a.l1(customResponsedMessage);
            this.a.n1();
        }
    }

    /* loaded from: classes6.dex */
    public class d extends SocketMessageListener {
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
        /* renamed from: g */
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            String errorString;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, socketResponsedMessage) != null) || !(socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage)) {
                return;
            }
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage;
            Message<?> orginalMessage = responseUpdateMaskInfoMessage.getOrginalMessage();
            if (!(orginalMessage instanceof RequestUpdateMaskInfoMessage)) {
                return;
            }
            RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
            if (requestUpdateMaskInfoMessage.getMaskType() != 12 || requestUpdateMaskInfoMessage.getIsMask() != 1) {
                return;
            }
            if (responseUpdateMaskInfoMessage.getError() != 0) {
                if (StringUtils.isNull(responseUpdateMaskInfoMessage.getErrorString())) {
                    errorString = this.a.getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0e70);
                } else {
                    errorString = responseUpdateMaskInfoMessage.getErrorString();
                }
                this.a.getPageContext().showToast(errorString);
                return;
            }
            this.a.j1(requestUpdateMaskInfoMessage.getList());
        }
    }

    /* loaded from: classes6.dex */
    public class e implements at8 {
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

        @Override // com.baidu.tieba.at8
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.i1();
            }
        }
    }

    /* loaded from: classes6.dex */
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
                OfficialSettingCache.getInstance().saveAcceptNotify(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.a), false);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class g implements bt8 {
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

        @Override // com.baidu.tieba.bt8
        public void onCanceled() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c1();
                this.a.i1();
            }
        }

        @Override // com.baidu.tieba.bt8
        public void onPostExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.c1();
                this.a.showToast(R.string.delete_success, false);
                this.a.i1();
            }
        }

        @Override // com.baidu.tieba.bt8
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.t1();
            }
        }

        @Override // com.baidu.tieba.bt8
        public void onProgressUpdate(int i, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) {
                if (this.a.d != null) {
                    this.a.d.b(i);
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
        this.e = new c(this, 0);
        this.f = new d(this, 104102);
        this.g = new e(this);
        this.h = new g(this);
    }

    public final void i1() {
        gt8 gt8Var;
        OfficialBarTipModel officialBarTipModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (gt8Var = this.b) != null && gt8Var.C() != null && (officialBarTipModel = this.a) != null) {
            if (officialBarTipModel != null && officialBarTipModel.isEmpty()) {
                finish();
            }
            new AddMsgRecordModel().req();
            this.b.H(this.a.getData());
        }
    }

    public final void r1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            registerListener(2016004, this.e);
            registerListener(2016007, this.e);
            registerListener(2016001, this.e);
            registerListener(2016011, this.e);
            registerListener(2016002, this.e);
            registerListener(this.f);
        }
    }

    public final void t1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            c1();
            if (this.d == null) {
                this.d = du8.l().o(getPageContext().getPageActivity());
            }
            this.d.show();
            this.d.b(0);
        }
    }

    public final void j1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.a.asyncDeleteItem(this.c, this.h);
            new f(this, str).execute(new Void[0]);
            MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
        }
    }

    public final void l1(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, customResponsedMessage) == null) && (customResponsedMessage instanceof MemoryInitCompleteMessage) && ((MemoryInitCompleteMessage) customResponsedMessage).getData().booleanValue()) {
            sendMessage(new RequestMemoryListMessage(2));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.b.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            super.onCreate(bundle);
            initData();
            h1();
            r1();
        }
    }

    public final void q1(CustomResponsedMessage<?> customResponsedMessage) {
        OfficialBarTipModel officialBarTipModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048595, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof ResponsedMemoryListMessage)) {
            return;
        }
        ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
        List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
        if (responsedMemoryListMessage.getType() == 2 && (officialBarTipModel = this.a) != null) {
            officialBarTipModel.setData(data, this.g);
        }
    }

    public void u1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.a.updateEditStatus(z);
            this.b.H(this.a.getData());
        }
    }

    public void b1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.deleteSelectedDatas(this.h);
        }
    }

    public final void c1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            h05 h05Var = this.d;
            if (h05Var != null && h05Var.isShowing()) {
                this.d.dismiss();
                this.d = null;
            }
            closeLoadingDialog();
            dismissAllDialog();
        }
    }

    public boolean f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<ImMessageCenterShowItemData> data = this.a.getData();
            for (int i = 0; i != data.size(); i++) {
                if (data.get(i).getUnReadCount() != 0) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            List<ImMessageCenterShowItemData> data = this.a.getData();
            for (int i = 0; i != data.size(); i++) {
                if (data.get(i).isSelected()) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void h1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            gt8 gt8Var = new gt8(this);
            this.b = gt8Var;
            gt8Var.D().setOnItemClickListener(new a(this));
            this.b.D().setOnItemLongClickListener(new b(this));
        }
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a = new OfficialBarTipModel(getPageContext());
        }
    }

    public final void n1() {
        OfficialBarTipModel officialBarTipModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (officialBarTipModel = this.a) != null) {
            officialBarTipModel.clearData();
        }
    }

    public final void notifyDataSetChanged() {
        gt8 gt8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (gt8Var = this.b) != null && gt8Var.C() != null) {
            this.b.C().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            c1();
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRestart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onRestart();
            ChatStatusManager.getInst().setIsOpen(4, true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onResume();
            this.b.C().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onStart();
            ChatStatusManager.getInst().setIsOpen(4, true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onStop();
            ChatStatusManager.getInst().setIsOpen(4, false);
        }
    }

    public final void k1(CustomResponsedMessage<?> customResponsedMessage) {
        OfficialBarTipModel officialBarTipModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof MemoryChangedMessage)) {
            return;
        }
        MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
        ImMessageCenterPojo data = memoryChangedMessage.getData();
        if (memoryChangedMessage.getType() == 1) {
            OfficialBarTipModel officialBarTipModel2 = this.a;
            if (officialBarTipModel2 != null) {
                officialBarTipModel2.insertOrUpdate(data, this.g);
            }
        } else if (memoryChangedMessage.getType() == 2 && (officialBarTipModel = this.a) != null) {
            officialBarTipModel.remove(data, this.g);
        }
    }

    public void s1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            List<ImMessageCenterShowItemData> data = this.a.getData();
            for (int i = 0; i != data.size(); i++) {
                MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.get(i).getFriendId(), 4)));
                data.get(i).setUnReadCount(0);
            }
            this.b.H(this.a.getData());
        }
    }
}

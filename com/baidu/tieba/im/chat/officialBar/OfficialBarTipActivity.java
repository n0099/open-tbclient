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
import com.baidu.tieba.ay7;
import com.baidu.tieba.bb;
import com.baidu.tieba.c05;
import com.baidu.tieba.cz7;
import com.baidu.tieba.f05;
import com.baidu.tieba.fy7;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.RequestSendPVTJMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.im.model.AddMsgRecordModel;
import com.baidu.tieba.im.model.OfficialBarTipModel;
import com.baidu.tieba.ka5;
import com.baidu.tieba.l05;
import com.baidu.tieba.n05;
import com.baidu.tieba.x08;
import com.baidu.tieba.zx7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class OfficialBarTipActivity extends BaseActivity<OfficialBarTipActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public OfficialBarTipModel a;
    public fy7 b;
    public ImMessageCenterShowItemData c;
    public f05 d;
    public final CustomMessageListener e;
    public final bb f;
    public zx7 g;
    public final ay7 h;

    /* loaded from: classes4.dex */
    public class b implements AdapterView.OnItemLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OfficialBarTipActivity a;

        /* loaded from: classes4.dex */
        public class a implements n05.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ l05 a;
            public final /* synthetic */ ImMessageCenterShowItemData b;
            public final /* synthetic */ b c;

            /* renamed from: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class C0300a implements c05.e {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public C0300a(a aVar) {
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

                @Override // com.baidu.tieba.c05.e
                public void onClick(c05 c05Var) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, c05Var) == null) {
                        c05Var.dismiss();
                        this.a.c.a.a.subscribeBar(false, this.a.b.getFriendId());
                        a aVar = this.a;
                        aVar.c.a.c = aVar.b;
                    }
                }
            }

            /* renamed from: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity$b$a$b  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class C0301b implements c05.e {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                public C0301b(a aVar) {
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

                @Override // com.baidu.tieba.c05.e
                public void onClick(c05 c05Var) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, c05Var) == null) {
                        c05Var.dismiss();
                    }
                }
            }

            public a(b bVar, l05 l05Var, ImMessageCenterShowItemData imMessageCenterShowItemData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, l05Var, imMessageCenterShowItemData};
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
                this.a = l05Var;
                this.b = imMessageCenterShowItemData;
            }

            @Override // com.baidu.tieba.n05.f
            public void M0(n05 n05Var, int i, View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIL(1048576, this, n05Var, i, view2) == null) {
                    l05 l05Var = this.a;
                    if (l05Var != null && l05Var.isShowing()) {
                        this.a.dismiss();
                    }
                    if (i == 0) {
                        this.c.a.a.asyncDeleteItem(this.b, this.c.a.h);
                        return;
                    }
                    c05 a = ka5.a(this.c.a.getPageContext(), -1, R.string.make_sure_cancel_subscribe, R.string.obfuscated_res_0x7f0f045d, R.string.obfuscated_res_0x7f0f038d, new C0300a(this), new C0301b(this));
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
                ImMessageCenterShowItemData item = this.a.b.B().getItem(i);
                if (item != null) {
                    if (this.a.b.B().c()) {
                        ImageView imageView = (ImageView) view2.findViewById(R.id.select_status);
                        if (item.isSelected()) {
                            item.setSelected(false);
                            SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
                            SkinManager.setBackgroundResource(imageView, R.drawable.btn_bgb_choice_n);
                            if (!this.a.R1()) {
                                this.a.b.I(false);
                            }
                        } else {
                            item.setSelected(true);
                            SkinManager.setBackgroundColor(view2, R.color.CAM_X0205);
                            SkinManager.setBackgroundResource(imageView, R.drawable.btn_bgb_choice_s);
                            this.a.b.I(true);
                        }
                        return true;
                    }
                    String[] strArr = {TbadkCoreApplication.getInst().getString(R.string.delete_user_chat), TbadkCoreApplication.getInst().getString(R.string.cancel_subscribe)};
                    l05 l05Var = new l05(this.a.getPageContext());
                    l05Var.i(null, strArr, new a(this, l05Var, item));
                    l05Var.k();
                }
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) && (item = this.a.b.B().getItem(i)) != null && view2 != null) {
                if (this.a.b.B().c()) {
                    ImageView imageView = (ImageView) view2.findViewById(R.id.select_status);
                    if (item.isSelected()) {
                        item.setSelected(false);
                        SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
                        SkinManager.setBackgroundResource(imageView, R.drawable.btn_bgb_choice_n);
                        if (!this.a.R1()) {
                            this.a.b.J(false);
                            return;
                        }
                        return;
                    }
                    item.setSelected(true);
                    SkinManager.setBackgroundColor(view2, R.color.CAM_X0205);
                    SkinManager.setBackgroundResource(imageView, R.drawable.btn_bgb_choice_s);
                    this.a.b.I(true);
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

    /* loaded from: classes4.dex */
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
                        } else if (customResponsedMessage.getCmd() == 2016011 && this.a.b != null && this.a.b.B() != null) {
                            this.a.b.B().notifyDataSetChanged();
                            return;
                        } else {
                            return;
                        }
                    }
                    this.a.Z1(customResponsedMessage);
                    return;
                }
                this.a.W1(customResponsedMessage);
                return;
            }
            this.a.X1(customResponsedMessage);
            this.a.Y1();
        }
    }

    /* loaded from: classes4.dex */
    public class d extends bb {
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
        /* renamed from: a */
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
                    errorString = this.a.getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0d1b);
                } else {
                    errorString = responseUpdateMaskInfoMessage.getErrorString();
                }
                this.a.getPageContext().showToast(errorString);
                return;
            }
            this.a.V1(requestUpdateMaskInfoMessage.getList());
        }
    }

    /* loaded from: classes4.dex */
    public class e implements zx7 {
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

        @Override // com.baidu.tieba.zx7
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.U1();
            }
        }
    }

    /* loaded from: classes4.dex */
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
                x08.j().f(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.a), false);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class g implements ay7 {
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

        @Override // com.baidu.tieba.ay7
        public void onCanceled() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.P1();
                this.a.U1();
            }
        }

        @Override // com.baidu.tieba.ay7
        public void onPostExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.P1();
                this.a.showToast(R.string.delete_success, false);
                this.a.U1();
            }
        }

        @Override // com.baidu.tieba.ay7
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.c2();
            }
        }

        @Override // com.baidu.tieba.ay7
        public void onProgressUpdate(int i, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) {
                if (this.a.d != null) {
                    this.a.d.b(i);
                }
                this.a.T1();
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

    public final void U1() {
        fy7 fy7Var;
        OfficialBarTipModel officialBarTipModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (fy7Var = this.b) != null && fy7Var.B() != null && (officialBarTipModel = this.a) != null) {
            if (officialBarTipModel != null && officialBarTipModel.isEmpty()) {
                finish();
            }
            new AddMsgRecordModel().req();
            this.b.G(this.a.getData());
        }
    }

    public final void a2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            registerListener(2016004, this.e);
            registerListener(2016007, this.e);
            registerListener(2016001, this.e);
            registerListener(2016011, this.e);
            registerListener(2016002, this.e);
            registerListener(this.f);
        }
    }

    public final void c2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            P1();
            if (this.d == null) {
                this.d = cz7.l().o(getPageContext().getPageActivity());
            }
            this.d.show();
            this.d.b(0);
        }
    }

    public final void V1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.a.asyncDeleteItem(this.c, this.h);
            new f(this, str).execute(new Void[0]);
            MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
        }
    }

    public final void X1(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, customResponsedMessage) == null) && (customResponsedMessage instanceof MemoryInitCompleteMessage) && ((MemoryInitCompleteMessage) customResponsedMessage).getData().booleanValue()) {
            sendMessage(new RequestMemoryListMessage(2));
        }
    }

    public final void Z1(CustomResponsedMessage<?> customResponsedMessage) {
        OfficialBarTipModel officialBarTipModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof ResponsedMemoryListMessage)) {
            return;
        }
        ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
        List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
        if (responsedMemoryListMessage.getType() == 2 && (officialBarTipModel = this.a) != null) {
            officialBarTipModel.setData(data, this.g);
        }
    }

    public void d2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.a.updateEditStatus(z);
            this.b.G(this.a.getData());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.b.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bundle) == null) {
            super.onCreate(bundle);
            initData();
            S1();
            a2();
        }
    }

    public void O1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.deleteSelectedDatas(this.h);
        }
    }

    public final void P1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            f05 f05Var = this.d;
            if (f05Var != null && f05Var.isShowing()) {
                this.d.dismiss();
                this.d = null;
            }
            closeLoadingDialog();
            dismissAllDialog();
        }
    }

    public boolean Q1() {
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

    public boolean R1() {
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

    public final void S1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            fy7 fy7Var = new fy7(this);
            this.b = fy7Var;
            fy7Var.C().setOnItemClickListener(new a(this));
            this.b.C().setOnItemLongClickListener(new b(this));
        }
    }

    public final void T1() {
        fy7 fy7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (fy7Var = this.b) != null && fy7Var.B() != null) {
            this.b.B().notifyDataSetChanged();
        }
    }

    public final void Y1() {
        OfficialBarTipModel officialBarTipModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (officialBarTipModel = this.a) != null) {
            officialBarTipModel.clearData();
        }
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.a = new OfficialBarTipModel(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            P1();
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRestart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onRestart();
            ChatStatusManager.getInst().setIsOpen(4, true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onResume();
            this.b.B().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onStart();
            ChatStatusManager.getInst().setIsOpen(4, true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onStop();
            ChatStatusManager.getInst().setIsOpen(4, false);
        }
    }

    public final void W1(CustomResponsedMessage<?> customResponsedMessage) {
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

    public void b2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            List<ImMessageCenterShowItemData> data = this.a.getData();
            for (int i = 0; i != data.size(); i++) {
                MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.get(i).getFriendId(), 4)));
                data.get(i).setUnReadCount(0);
            }
            this.b.G(this.a.getData());
        }
    }
}

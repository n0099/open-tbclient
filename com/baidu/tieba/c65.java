package com.baidu.tieba;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.coreExtra.model.AttentionModel;
import com.baidu.tieba.rz4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class c65 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a65 a;
    public WeakReference<b65> b;
    public TbPageContext c;
    public AttentionModel d;
    public BdUniqueId e;
    public String f;
    public String g;
    public boolean h;
    public boolean i;
    public pz4 j;
    public boolean k;
    public cu4 l;
    public f m;
    public CustomMessageListener n;
    public CustomMessageListener o;

    /* loaded from: classes5.dex */
    public interface f {
        void a(boolean z);
    }

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c65 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c65 c65Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c65Var, Integer.valueOf(i)};
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
            this.a = c65Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(this.a.a.getUserId()) && this.a.a.getUserId().equals(str)) {
                    this.a.k = true;
                }
                hb.a(this.a.j, TbadkCoreApplication.getInst().getCurrentActivity());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c65 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(c65 c65Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c65Var, Integer.valueOf(i)};
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
            this.a = c65Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof UpdateAttentionMessage)) {
                return;
            }
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            UpdateAttentionMessage.UpdateAttentionData data = updateAttentionMessage.getData();
            a65 a65Var = this.a.a;
            if (a65Var != null && !StringUtils.isNull(a65Var.getUserId()) && data != null && this.a.a.getUserId().equals(data.toUid)) {
                if (updateAttentionMessage.getOrginalMessage() != null && this.a.e != null && updateAttentionMessage.getOrginalMessage().getTag().equals(this.a.e)) {
                    z = true;
                } else {
                    z = false;
                }
                BlockPopInfoData blockPopInfoData = data.blockData;
                if (blockPopInfoData != null) {
                    String str2 = blockPopInfoData.appeal_msg;
                    if (blockPopInfoData.appeal_status == 1) {
                        if (TextUtils.isEmpty(str2)) {
                            str2 = TbadkCoreApplication.getInst().getString(R.string.anti_account_exception_appealing);
                        }
                    } else if (TextUtils.isEmpty(str2)) {
                        str2 = TbadkCoreApplication.getInst().getString(R.string.anti_no_chance_com_tip);
                    }
                    this.a.c.showToast(str2);
                } else if (!data.isSucc) {
                    this.a.k = false;
                    if (updateAttentionMessage.getData() != null) {
                        str = updateAttentionMessage.getData().errorString;
                    } else {
                        str = "";
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = TbadkCoreApplication.getInst().getString(R.string.operation_failed);
                    }
                    BdToast.makeText(TbadkCoreApplication.getInst().getContext(), str).setIcon(BdToast.ToastIcon.FAILURE).setDuration(3000).show();
                    b65 b65Var = (b65) this.a.b.get();
                    if (b65Var == null) {
                        return;
                    }
                    if (z) {
                        b65Var.b(this.a.a.getIsLike(), this.a.a.getLikeStatus(), z);
                    } else {
                        b65Var.d(this.a.a.getIsLike(), this.a.a.getLikeStatus());
                    }
                } else {
                    int fansNum = this.a.a.getFansNum();
                    boolean isLike = this.a.a.getIsLike();
                    if (data.isAttention && !isLike) {
                        fansNum++;
                    } else if (!data.isAttention && isLike) {
                        fansNum--;
                        if (!this.a.h) {
                            this.a.c.showToast(R.string.un_attention_success);
                        }
                    }
                    this.a.a.setLikeStatus(data.status);
                    this.a.a.setIsLike(data.isAttention);
                    this.a.a.setIsFromNetWork(false);
                    this.a.a.setFansNum(fansNum);
                    this.a.k = false;
                    b65 b65Var2 = (b65) this.a.b.get();
                    if (b65Var2 != null) {
                        b65Var2.c(fansNum);
                        if (z) {
                            if (this.a.m != null) {
                                this.a.m.a(data.isAttention);
                            }
                            b65Var2.b(data.isAttention, data.status, true);
                            return;
                        }
                        b65Var2.d(data.isAttention, data.status);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements rz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c65 a;

        public c(c65 c65Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c65Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c65Var;
        }

        @Override // com.baidu.tieba.rz4.e
        public void onClick() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b65 b65Var = (b65) this.a.b.get();
                if (b65Var instanceof View) {
                    this.a.k = true;
                    MessageManager messageManager = MessageManager.getInstance();
                    a65 a65Var = this.a.a;
                    if (a65Var != null) {
                        str = a65Var.getUserId();
                    } else {
                        str = "0";
                    }
                    messageManager.dispatchResponsedMessage(new CustomResponsedMessage(2921560, str));
                    this.a.onClick((View) b65Var);
                }
                hb.a(this.a.j, TbadkCoreApplication.getInst().getCurrentActivity());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements rz4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c65 a;

        public d(c65 c65Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c65Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c65Var;
        }

        @Override // com.baidu.tieba.rz4.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.j == null) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921560, "0"));
        }
    }

    /* loaded from: classes5.dex */
    public class e implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(c65 c65Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c65Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921560, "0"));
            }
        }
    }

    public c65(TbPageContext tbPageContext, b65 b65Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, b65Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new WeakReference<>(null);
        this.f = "0";
        this.n = new a(this, 2921560);
        this.o = new b(this, 2001115);
        this.c = tbPageContext;
        this.d = new AttentionModel(tbPageContext);
        this.e = this.c.getUniqueId();
        tbPageContext.registerListener(this.o);
        tbPageContext.registerListener(this.n);
        p(b65Var);
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.h = z;
            this.d.h(z);
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f = str;
        }
    }

    public void l(a65 a65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, a65Var) == null) {
            this.a = a65Var;
            b65 b65Var = this.b.get();
            if (b65Var != null && this.a != null) {
                b65Var.d(a65Var.getIsLike(), a65Var.getLikeStatus());
                b65Var.c(a65Var.getFansNum());
            }
        }
    }

    public void m(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            this.m = fVar;
        }
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.g = str;
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.i = z;
        }
    }

    public void p(b65 b65Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, b65Var) == null) && b65Var != null) {
            this.b = new WeakReference<>(b65Var);
            b65Var.e(this);
        }
    }

    public void r(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, bdUniqueId) != null) || bdUniqueId == null) {
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.o);
        MessageManager.getInstance().unRegisterListener(this.n);
    }

    public a65 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (a65) invokeV.objValue;
    }

    public void j(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId) != null) || bdUniqueId == null) {
            return;
        }
        this.e = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(this.o);
        MessageManager.getInstance().unRegisterListener(this.n);
        this.o.setTag(this.e);
        this.n.setTag(this.e);
        MessageManager.getInstance().registerListener(this.o);
        MessageManager.getInstance().registerListener(this.n);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        a65 a65Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) {
            cu4 cu4Var = this.l;
            if (cu4Var != null && cu4Var.a(view2)) {
                return;
            }
            if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                this.c.showToast(R.string.obfuscated_res_0x7f0f0e4f);
                return;
            }
            b65 b65Var = this.b.get();
            if (b65Var != null) {
                b65Var.a(view2);
            }
            if (!ViewHelper.checkUpIsLogin(this.c.getPageActivity()) || (a65Var = this.a) == null) {
                return;
            }
            boolean z = !a65Var.getIsLike();
            if (!z && this.i && !this.k) {
                q();
            } else if (this.e == null) {
                this.d.m(z, this.a.getPortrait(), this.a.getUserId(), this.a.isGod(), this.f, this.c.getUniqueId(), null, "0", this.g);
            } else {
                this.d.m(z, this.a.getPortrait(), this.a.getUserId(), this.a.isGod(), this.f, this.e, null, "0", this.g);
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.j == null) {
                rz4 rz4Var = new rz4(TbadkCoreApplication.getInst().getCurrentActivity());
                rz4Var.u(TbadkCoreApplication.getInst().getString(R.string.confirm_unlike));
                ArrayList arrayList = new ArrayList();
                nz4 nz4Var = new nz4(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04c8), rz4Var);
                nz4Var.m(new c(this));
                arrayList.add(nz4Var);
                rz4Var.p(new d(this));
                rz4Var.m(arrayList);
                pz4 pz4Var = new pz4(UtilHelper.getTbPageContext(TbadkCoreApplication.getInst().getCurrentActivity()), rz4Var);
                this.j = pz4Var;
                pz4Var.k(0.7f);
            }
            this.j.setOnCancelListener(new e(this));
            hb.i(this.j, TbadkCoreApplication.getInst().getCurrentActivity());
        }
    }
}

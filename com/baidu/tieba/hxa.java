package com.baidu.tieba;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.vcode.VcodeTool;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.accountAccess.AccountAccessActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class hxa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ixa a;
    public final NewWriteModel b;
    public boolean c;
    public final NewWriteModel.d d;

    /* loaded from: classes6.dex */
    public class a implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hxa a;

        public a(hxa hxaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hxaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hxaVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, qd5 qd5Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, qd5Var, writeData, antiData}) == null) && this.a.a != null && this.a.b != null && this.a.b.d0() != null) {
                this.a.a.o(false);
                if (writeData == null) {
                    writeData = this.a.b.d0();
                }
                WriteData writeData2 = writeData;
                if (!z) {
                    if (writeData2 != null && qd5Var != null && !TextUtils.isEmpty(qd5Var.d())) {
                        writeData2.setVcodeMD5(qd5Var.b());
                        writeData2.setVcodeUrl(qd5Var.c());
                        writeData2.setVcodeExtra(qd5Var.a());
                        this.a.a.getContext().setVisible(false);
                        if (VcodeTool.needVcode(qd5Var.d())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.a.a.getContext().getActivity(), 12006, writeData2, false, qd5Var.d())));
                            return;
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.a.a.getContext().getActivity(), writeData2, 12006)));
                            return;
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                        Intent intent = new Intent();
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                        intent.putExtras(bundle);
                        BaseActivity context = this.a.a.getContext();
                        this.a.a.getContext();
                        context.setResult(0, intent);
                        this.a.a.getContext().finish();
                        return;
                    } else {
                        if (postWriteCallBackData != null) {
                            eia.b(this.a.a.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                            BaseActivity context2 = this.a.a.getContext();
                            this.a.a.getContext();
                            context2.setResult(0, null);
                        }
                        this.a.a.getContext().finish();
                        return;
                    }
                }
                this.a.c = true;
                if (postWriteCallBackData == null) {
                    eia.b(this.a.a.getContext().getActivity(), this.a.a.getContext().getResources().getString(R.string.send_success), null, null);
                } else {
                    eia.b(this.a.a.getContext().getActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                }
                Intent intent2 = new Intent();
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent2.putExtras(bundle2);
                BaseActivity context3 = this.a.a.getContext();
                this.a.a.getContext();
                context3.setResult(-1, intent2);
                this.a.a.getContext().finish();
            }
        }
    }

    public hxa(ixa ixaVar, NewWriteModel newWriteModel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ixaVar, newWriteModel};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a aVar = new a(this);
        this.d = aVar;
        this.a = ixaVar;
        this.b = newWriteModel;
        newWriteModel.l0(aVar);
    }

    public void h(String str) {
        ixa ixaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && (ixaVar = this.a) != null) {
            ixaVar.p(true);
            this.a.q(false);
            this.a.i().loadUrl(str);
        }
    }

    public void d() {
        ixa ixaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (ixaVar = this.a) != null) {
            ixaVar.r(500);
        }
    }

    public void e() {
        ixa ixaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (ixaVar = this.a) != null) {
            ixaVar.o(false);
        }
    }

    public boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (this.a == null || str == null) {
                return false;
            }
            if (str.equals(AccountAccessActivity.g)) {
                this.a.getContext().finish();
                return true;
            } else if (str.equals(AccountAccessActivity.h)) {
                this.a.n(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
                if (this.a.g() != this.a.h()) {
                    ixa ixaVar = this.a;
                    ixaVar.m(ixaVar.g());
                    this.a.s();
                }
                this.a.i().setVisibility(0);
                return true;
            } else if (str.equals(AccountAccessActivity.i)) {
                g();
                return true;
            } else if (str.equals(AccountAccessActivity.j) || str.equals(AccountAccessActivity.k)) {
                this.a.getContext().finish();
                UrlManager.getInstance().dealOneLink(this.a.getContext().getPageContext(), new String[]{UrlSchemaHelper.SCHEMA_TYPE_FEED_BACK});
                return true;
            } else {
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.a != null && this.b != null) {
            if (!BdUtilHelper.isNetOk()) {
                this.a.getContext().showToast(R.string.obfuscated_res_0x7f0f0e29);
                this.a.getContext().finish();
                return;
            }
            this.a.o(true);
            this.b.o0();
        }
    }
}

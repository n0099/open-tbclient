package com.baidu.tieba;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class goa implements foa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public doa a;
    public coa b;
    public TbPageContext<?> c;

    @Override // com.baidu.tieba.foa
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    @Override // com.baidu.tieba.foa
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareItem a;
        public final /* synthetic */ goa b;

        public a(goa goaVar, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {goaVar, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = goaVar;
            this.a = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                oi.a(this.a.x);
                yi.R(this.b.c.getPageActivity(), view2.getResources().getString(R.string.copy_pb_url_success));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ goa a;

        public b(goa goaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {goaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = goaVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, dialogInterface) != null) {
                return;
            }
            this.a.h();
        }
    }

    public goa(TbPageContext<?> tbPageContext, coa coaVar, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, coaVar, intent};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = tbPageContext;
        this.b = coaVar;
        eoa eoaVar = new eoa();
        this.a = eoaVar;
        eoaVar.b(intent);
        this.a.e(tbPageContext.getUniqueId());
    }

    @Override // com.baidu.tieba.foa
    public void a() {
        coa coaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (coaVar = this.b) != null) {
            coaVar.showErrorView();
        }
    }

    @Override // com.baidu.tieba.foa
    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.c == null) {
            return;
        }
        if (!ShareSwitch.isOn() && !ViewHelper.checkUpIsLogin(this.c.getPageActivity())) {
            return;
        }
        i();
    }

    @Override // com.baidu.tieba.foa
    public void c() {
        doa doaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (doaVar = this.a) != null) {
            da5.p().A(da5.t(doaVar.c()), false);
        }
    }

    @Override // com.baidu.tieba.foa
    public void d() {
        doa doaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (doaVar = this.a) != null && this.b != null) {
            this.b.D0(doaVar.getVideoUrl());
        }
    }

    @Override // com.baidu.tieba.foa
    public void e() {
        coa coaVar;
        doa doaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (coaVar = this.b) != null && (doaVar = this.a) != null) {
            coaVar.p0(doaVar.a(), this.a.g());
        }
    }

    public final void h() {
        doa doaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (doaVar = this.a) != null && this.b != null) {
            this.b.B0(doaVar.getVideoUrl());
        }
    }

    @Override // com.baidu.tieba.foa
    public void onClose() {
        coa coaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (coaVar = this.b) != null) {
            coaVar.finishActivity();
        }
    }

    @Override // com.baidu.tieba.foa
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            h();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.a != null && this.c != null) {
            ShareItem shareItem = new ShareItem();
            shareItem.v = this.a.d();
            shareItem.w = this.a.i();
            shareItem.x = this.a.f();
            shareItem.y = this.a.f();
            if (!xi.isEmpty(this.a.h())) {
                shareItem.z = Uri.parse(this.a.h());
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.c.getPageActivity(), shareItem, true, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new a(this, shareItem));
            shareDialogConfig.setOnDismissListener(new b(this));
            this.c.sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }
}

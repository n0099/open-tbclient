package com.baidu.tieba;

import android.app.Activity;
import android.content.DialogInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdDimDialog;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.leveiconlivepolling.PollingModel;
import com.baidu.tbadk.data.IconPopData;
import com.baidu.tieba.b55;
import com.baidu.tieba.stamp.SignPopStampDialogUtil;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class bha extends b55 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity c;
    public final iea d;
    public IconPopData e;
    public BdDimDialog f;

    /* loaded from: classes5.dex */
    public class a implements SignPopStampDialogUtil.clickCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bha a;

        public a(bha bhaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bhaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bhaVar;
        }

        @Override // com.baidu.tieba.stamp.SignPopStampDialogUtil.clickCallBack
        public void closeBtn() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c();
            }
        }

        @Override // com.baidu.tieba.stamp.SignPopStampDialogUtil.clickCallBack
        public void jumpToIconCenterBtn() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.c();
            }
        }

        @Override // com.baidu.tieba.stamp.SignPopStampDialogUtil.clickCallBack
        public void shareBtn() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.c();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bha a;

        public b(bha bhaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bhaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bhaVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                YunDialogManager.unMarkShowingDialogName("userIcon");
                this.a.c();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bha(MainTabActivity mainTabActivity, iea ieaVar) {
        super(mainTabActivity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, ieaVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Activity) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = mainTabActivity;
        this.d = ieaVar;
    }

    @Override // com.baidu.tieba.b55
    public void b() {
        BdDimDialog bdDimDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (bdDimDialog = this.f) != null) {
            bdDimDialog.dismiss();
        }
    }

    @Override // com.baidu.tieba.b55
    public void d(b55.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            if (YunDialogManager.isShowingDialog() && aVar != null) {
                aVar.callback(false);
                return;
            }
            iea ieaVar = this.d;
            if ((ieaVar == null || ieaVar.z() == null || (this.d.z().getCurrentTabType() != 2 && this.d.z().getCurrentTabType() != 1 && this.d.z().getCurrentTabType() != 3)) && aVar != null) {
                aVar.callback(false);
                return;
            }
            IconPopData iconPopData = TbSingleton.getInstance().getIconPopData();
            this.e = iconPopData;
            if (iconPopData != null && PollingModel.checkIconPopHadShow() && this.e.getPic160() != null && this.e.getTitle() != null && this.c.K1() && this.c.B && this.e.getUid().longValue() == TbadkCoreApplication.getCurrentAccountId() && aVar != null) {
                aVar.callback(true);
            } else if (aVar != null) {
                aVar.callback(false);
            }
        }
    }

    @Override // com.baidu.tieba.b55
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.e == null) {
                this.e = TbSingleton.getInstance().getIconPopData();
            }
            if (!PollingModel.checkIconPopHadShow()) {
                c();
                return;
            }
            SignPopStampDialogUtil signPopStampDialogUtil = new SignPopStampDialogUtil();
            signPopStampDialogUtil.setClickCallBack(new a(this));
            signPopStampDialogUtil.setOnDismissListener(new b(this));
            this.f = signPopStampDialogUtil.preShowPollingStampDialog(this.e);
            YunDialogManager.markShowingDialogName("userIcon");
        }
    }
}

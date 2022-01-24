package com.baidu.tieba.barselect.view;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import c.a.d.f.p.n;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class ToastDialog extends AlertDialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f42294e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f42295f;

    /* renamed from: g  reason: collision with root package name */
    public String f42296g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ToastDialog(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void onSkinChange(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            int f2 = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds5);
            View view = this.f42294e;
            int i3 = R.color.cp_cont_b_alpha80;
            SkinManager.setBackgroundShapeDrawable(view, f2, i3, i3, i2);
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f42296g = str;
        }
    }

    @Override // android.app.Dialog
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.show();
            Window window = getWindow();
            if (window != null) {
                window.setDimAmount(0.0f);
                window.setContentView(R.layout.id_card_dialog);
                this.f42294e = window.findViewById(R.id.toast_container);
                this.f42295f = (TextView) window.findViewById(R.id.toast_tv);
                if (!StringUtils.isNull(this.f42296g)) {
                    this.f42295f.setText(this.f42296g);
                }
                onSkinChange(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }
}

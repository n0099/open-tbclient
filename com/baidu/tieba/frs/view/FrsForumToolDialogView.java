package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class FrsForumToolDialogView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public TextView b;
    public TbImageView c;
    public TextView d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsForumToolDialogView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0362, this);
            this.c = (TbImageView) findViewById(R.id.obfuscated_res_0x7f09122c);
            this.b = (TextView) findViewById(R.id.tv_content);
            this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f0904bf);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f0904e3);
            this.a.setText(R.string.obfuscated_res_0x7f0f03d0);
            this.d.setText(R.string.know_more);
            this.c.setPlaceHolder(3);
            this.c.setDrawCorner(true);
            this.c.setAutoChangeStyle(true);
            this.c.setConrers(3);
            this.c.setRadiusById(R.string.J_X06);
            EMManager.from(this.b).setTextColor(R.color.CAM_X0107).setTextLinePadding(R.dimen.M_T_X001).setTextSize(R.dimen.T_X06);
            EMManager.from(this.a).setTextColor(R.color.CAM_X0105).setCorner(R.string.J_X07).setBorderWidth(R.dimen.L_X02).setTextSize(R.dimen.T_X08).setBorderColor(R.color.CAM_X0902).setBackGroundColor(R.color.CAM_X0201);
            EMManager.from(this.d).setTextColor(R.color.CAM_X0302).setCorner(R.string.J_X07).setTextSize(R.dimen.T_X08).setBorderWidth(R.dimen.L_X02).setAlpha(R.string.A_X07).setBorderColor(R.color.CAM_X0302).setBackGroundColor(R.color.CAM_X0201);
            EMManager.from(this).setCorner(R.string.J_X06).setCardType(0).setBackGroundColor(R.color.CAM_X0201);
        }
    }

    public void setCancleButtonListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) && onClickListener != null) {
            this.a.setOnClickListener(onClickListener);
        }
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) && onClickListener != null) {
            this.d.setOnClickListener(onClickListener);
        }
    }

    public void setContent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.b.setText(str);
        }
    }

    public void setStartLoadUrl(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) {
            if (i != 1 && i != 2) {
                this.c.startLoad(str, 10, false);
            } else {
                this.c.startLoad(str, 24, false);
            }
        }
    }
}

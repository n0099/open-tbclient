package com.baidu.tieba.im.forum.broadcast.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ForumBroadcastMajorQuestionDialogView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout a;
    public TextView b;
    public TextView c;
    public TextView d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumBroadcastMajorQuestionDialogView(Context context) {
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
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d02f5, this);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090bbc);
            this.a = linearLayout;
            this.b = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090bbe);
            this.c = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090bbd);
            this.d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f09126a);
            this.b.setText(R.string.subscribe_bar_title);
            this.c.setText(R.string.obfuscated_res_0x7f0f0787);
            this.d.setText(R.string.obfuscated_res_0x7f0f0b59);
            SkinManager.setBackgroundResource(this.a, R.drawable.bg_frs_private_dialog);
            SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0302);
        }
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) && onClickListener != null) {
            this.d.setOnClickListener(onClickListener);
        }
    }
}

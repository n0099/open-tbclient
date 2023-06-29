package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.R;
import com.baidu.tieba.wi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class FrsShareCardView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout a;
    public Context b;
    public EditText c;
    public HeadImageView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public ShareFromFrsMsgData h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsShareCardView(Context context) {
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
        this.b = context;
        c(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsShareCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = context;
        c(context);
    }

    public final String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            return wi.cutString(str, 18) + this.b.getString(R.string.obfuscated_res_0x7f0f076a);
        }
        return (String) invokeL.objValue;
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, shareFromFrsMsgData) == null) {
            this.h = shareFromFrsMsgData;
            d();
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            this.d.setPageId(bdUniqueId);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.setFocusable(true);
            this.a.setFocusableInTouchMode(true);
            this.a.requestFocus();
        }
    }

    public EditText getChatMsgView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.c;
        }
        return (EditText) invokeV.objValue;
    }

    public String getLeaveMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            EditText editText = this.c;
            if (editText == null) {
                return null;
            }
            return wi.charSequence2String(editText.getText(), null);
        }
        return (String) invokeV.objValue;
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.frs_share_card_view, this);
            setOrientation(1);
            this.a = (LinearLayout) findViewById(R.id.share_content);
            this.e = (TextView) findViewById(R.id.frs_card_name);
            this.c = (EditText) findViewById(R.id.chat_msg);
            this.d = (HeadImageView) findViewById(R.id.frs_card_img);
            this.g = (TextView) findViewById(R.id.frs_card_member_num);
            this.f = (TextView) findViewById(R.id.frs_card_post_num);
            SkinManager.setViewTextColor(this.e, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(this.c, R.color.CAM_X0105, 2);
            this.c.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            this.c.setPadding(context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d5), 0, 0, 0);
            b();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.e.setText(a(this.h.getName()));
            BdLog.e("mData.getImageUrl()的图片URL" + this.h.getImageUrl());
            this.d.N(this.h.getImageUrl(), 15, false);
            this.g.setText(StringHelper.numFormatOver10000((long) this.h.getMemberNum()));
            this.f.setText(StringHelper.numFormatOver10000((long) this.h.getPostNum()));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return new LinearLayout.LayoutParams(-1, -2);
        }
        return (LinearLayout.LayoutParams) invokeV.objValue;
    }
}

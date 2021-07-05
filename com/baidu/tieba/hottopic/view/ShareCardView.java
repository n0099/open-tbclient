package com.baidu.tieba.hottopic.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.data.ShareFromTopicMsgData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
/* loaded from: classes5.dex */
public class ShareCardView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f17170e;

    /* renamed from: f  reason: collision with root package name */
    public EditText f17171f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f17172g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f17173h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f17174i;
    public ShareFromTopicMsgData j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        b(context);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f17170e.setFocusable(true);
            this.f17170e.setFocusableInTouchMode(true);
            this.f17170e.requestFocus();
        }
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.thread_to_group_share_view, this);
            setOrientation(1);
            this.f17170e = (LinearLayout) findViewById(R.id.share_content);
            this.f17174i = (TextView) findViewById(R.id.share_title_view);
            this.f17171f = (EditText) findViewById(R.id.chat_msg);
            this.f17172g = (TbImageView) findViewById(R.id.chat_group_img);
            this.f17173h = (TextView) findViewById(R.id.chat_group_desc);
            SkinManager.setViewTextColor(this.f17174i, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(this.f17171f, R.color.CAM_X0105, 2);
            SkinManager.setViewTextColor(this.f17173h, R.color.CAM_X0106, 1);
            this.f17171f.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            this.f17171f.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
            a();
        }
    }

    public void c(String str, boolean z) {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, str, z) == null) || (tbImageView = this.f17172g) == null) {
            return;
        }
        tbImageView.M(str, z ? 17 : 18, false);
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f17174i.setText(this.j.getTitle());
            BdLog.e("mData.getImageUrl()的图片URL" + this.j.getImageUrl());
            this.f17172g.setTag(this.j.getImageUrl());
            BdLog.e("mData.getContent()的Content" + this.j.getContent());
            this.f17173h.setText(this.j.getContent());
        }
    }

    public EditText getChatMsgView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f17171f : (EditText) invokeV.objValue;
    }

    public String getLeaveMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            EditText editText = this.f17171f;
            if (editText != null) {
                return k.charSequence2String(editText.getText(), null);
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public void setData(ShareFromTopicMsgData shareFromTopicMsgData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, shareFromTopicMsgData) == null) {
            this.j = shareFromTopicMsgData;
            d();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? new LinearLayout.LayoutParams(-1, -2) : (LinearLayout.LayoutParams) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareCardView(Context context) {
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
        b(context);
    }
}

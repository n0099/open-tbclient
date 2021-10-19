package com.baidu.tieba.hottopic.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.k;
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
/* loaded from: classes7.dex */
public class ShareCardView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f52811e;

    /* renamed from: f  reason: collision with root package name */
    public EditText f52812f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f52813g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f52814h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f52815i;

    /* renamed from: j  reason: collision with root package name */
    public ShareFromTopicMsgData f52816j;

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
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.thread_to_group_share_view, this);
            setOrientation(1);
            this.f52811e = (LinearLayout) findViewById(R.id.share_content);
            this.f52815i = (TextView) findViewById(R.id.share_title_view);
            this.f52812f = (EditText) findViewById(R.id.chat_msg);
            this.f52813g = (TbImageView) findViewById(R.id.chat_group_img);
            this.f52814h = (TextView) findViewById(R.id.chat_group_desc);
            SkinManager.setViewTextColor(this.f52815i, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(this.f52812f, R.color.CAM_X0105, 2);
            SkinManager.setViewTextColor(this.f52814h, R.color.CAM_X0106, 1);
            this.f52812f.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            this.f52812f.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
            hideEditTextCursor();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f52815i.setText(this.f52816j.getTitle());
            BdLog.e("mData.getImageUrl()的图片URL" + this.f52816j.getImageUrl());
            this.f52813g.setTag(this.f52816j.getImageUrl());
            BdLog.e("mData.getContent()的Content" + this.f52816j.getContent());
            this.f52814h.setText(this.f52816j.getContent());
        }
    }

    public EditText getChatMsgView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f52812f : (EditText) invokeV.objValue;
    }

    public String getLeaveMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            EditText editText = this.f52812f;
            if (editText != null) {
                return k.charSequence2String(editText.getText(), null);
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public void hideEditTextCursor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f52811e.setFocusable(true);
            this.f52811e.setFocusableInTouchMode(true);
            this.f52811e.requestFocus();
        }
    }

    public void loadImageIcon(String str, boolean z) {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048583, this, str, z) == null) || (tbImageView = this.f52813g) == null) {
            return;
        }
        tbImageView.startLoad(str, z ? 17 : 18, false);
    }

    public void setData(ShareFromTopicMsgData shareFromTopicMsgData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, shareFromTopicMsgData) == null) {
            this.f52816j = shareFromTopicMsgData;
            b();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new LinearLayout.LayoutParams(-1, -2) : (LinearLayout.LayoutParams) invokeV.objValue;
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
        a(context);
    }
}

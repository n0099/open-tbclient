package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.k;
import b.a.r0.x0.b1;
import b.a.r0.x0.c1;
import b.a.r0.x0.e1;
import b.a.r0.x0.f1;
import b.a.r0.x0.h1;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class FrsShareCardView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f49142e;

    /* renamed from: f  reason: collision with root package name */
    public Context f49143f;

    /* renamed from: g  reason: collision with root package name */
    public EditText f49144g;

    /* renamed from: h  reason: collision with root package name */
    public HeadImageView f49145h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f49146i;
    public TextView j;
    public TextView k;
    public ShareFromFrsMsgData l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsShareCardView(Context context, AttributeSet attributeSet) {
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
        this.f49143f = context;
        b(context);
    }

    public final String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            return k.cutString(str, 18) + this.f49143f.getString(h1.forum);
        }
        return (String) invokeL.objValue;
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            LayoutInflater.from(context).inflate(f1.frs_share_card_view, this);
            setOrientation(1);
            this.f49142e = (LinearLayout) findViewById(e1.share_content);
            this.f49146i = (TextView) findViewById(e1.frs_card_name);
            this.f49144g = (EditText) findViewById(e1.chat_msg);
            this.f49145h = (HeadImageView) findViewById(e1.frs_card_img);
            this.k = (TextView) findViewById(e1.frs_card_member_num);
            this.j = (TextView) findViewById(e1.frs_card_post_num);
            SkinManager.setViewTextColor(this.f49146i, b1.CAM_X0105, 1);
            SkinManager.setViewTextColor(this.f49144g, b1.CAM_X0105, 2);
            this.f49144g.setHintTextColor(SkinManager.getColor(b1.CAM_X0110));
            this.f49144g.setPadding(context.getResources().getDimensionPixelSize(c1.ds20), 0, 0, 0);
            hideEditTextCursor();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f49146i.setText(a(this.l.getName()));
            BdLog.e("mData.getImageUrl()的图片URL" + this.l.getImageUrl());
            this.f49145h.startLoad(this.l.getImageUrl(), 15, false);
            this.k.setText(StringHelper.numFormatOver10000((long) this.l.getMemberNum()));
            this.j.setText(StringHelper.numFormatOver10000((long) this.l.getPostNum()));
        }
    }

    public EditText getChatMsgView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f49144g : (EditText) invokeV.objValue;
    }

    public String getLeaveMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            EditText editText = this.f49144g;
            if (editText != null) {
                return k.charSequence2String(editText.getText(), null);
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public void hideEditTextCursor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f49142e.setFocusable(true);
            this.f49142e.setFocusableInTouchMode(true);
            this.f49142e.requestFocus();
        }
    }

    public void loadImageIcon(String str, boolean z) {
        HeadImageView headImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, z) == null) || (headImageView = this.f49145h) == null) {
            return;
        }
        headImageView.startLoad(str, 15, false);
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, shareFromFrsMsgData) == null) {
            this.l = shareFromFrsMsgData;
            c();
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bdUniqueId) == null) {
            this.f49145h.setPageId(bdUniqueId);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new LinearLayout.LayoutParams(-1, -2) : (LinearLayout.LayoutParams) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsShareCardView(Context context) {
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
        this.f49143f = context;
        b(context);
    }
}

package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.e.f.p.k;
import b.a.r0.x0.c1;
import b.a.r0.x0.d1;
import b.a.r0.x0.f1;
import b.a.r0.x0.g1;
import b.a.r0.x0.i1;
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
    public LinearLayout f50006e;

    /* renamed from: f  reason: collision with root package name */
    public Context f50007f;

    /* renamed from: g  reason: collision with root package name */
    public EditText f50008g;

    /* renamed from: h  reason: collision with root package name */
    public HeadImageView f50009h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f50010i;
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
        this.f50007f = context;
        b(context);
    }

    public final String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            return k.cutString(str, 18) + this.f50007f.getString(i1.forum);
        }
        return (String) invokeL.objValue;
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            LayoutInflater.from(context).inflate(g1.frs_share_card_view, this);
            setOrientation(1);
            this.f50006e = (LinearLayout) findViewById(f1.share_content);
            this.f50010i = (TextView) findViewById(f1.frs_card_name);
            this.f50008g = (EditText) findViewById(f1.chat_msg);
            this.f50009h = (HeadImageView) findViewById(f1.frs_card_img);
            this.k = (TextView) findViewById(f1.frs_card_member_num);
            this.j = (TextView) findViewById(f1.frs_card_post_num);
            SkinManager.setViewTextColor(this.f50010i, c1.CAM_X0105, 1);
            SkinManager.setViewTextColor(this.f50008g, c1.CAM_X0105, 2);
            this.f50008g.setHintTextColor(SkinManager.getColor(c1.CAM_X0110));
            this.f50008g.setPadding(context.getResources().getDimensionPixelSize(d1.ds20), 0, 0, 0);
            hideEditTextCursor();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f50010i.setText(a(this.l.getName()));
            BdLog.e("mData.getImageUrl()的图片URL" + this.l.getImageUrl());
            this.f50009h.startLoad(this.l.getImageUrl(), 15, false);
            this.k.setText(StringHelper.numFormatOver10000((long) this.l.getMemberNum()));
            this.j.setText(StringHelper.numFormatOver10000((long) this.l.getPostNum()));
        }
    }

    public EditText getChatMsgView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f50008g : (EditText) invokeV.objValue;
    }

    public String getLeaveMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            EditText editText = this.f50008g;
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
            this.f50006e.setFocusable(true);
            this.f50006e.setFocusableInTouchMode(true);
            this.f50006e.requestFocus();
        }
    }

    public void loadImageIcon(String str, boolean z) {
        HeadImageView headImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, z) == null) || (headImageView = this.f50009h) == null) {
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
            this.f50009h.setPageId(bdUniqueId);
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
        this.f50007f = context;
        b(context);
    }
}

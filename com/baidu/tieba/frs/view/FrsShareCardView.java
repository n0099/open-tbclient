package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.t0.e1.c1;
import c.a.t0.e1.d1;
import c.a.t0.e1.f1;
import c.a.t0.e1.g1;
import c.a.t0.e1.i1;
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
/* loaded from: classes12.dex */
public class FrsShareCardView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f43867e;

    /* renamed from: f  reason: collision with root package name */
    public Context f43868f;

    /* renamed from: g  reason: collision with root package name */
    public EditText f43869g;

    /* renamed from: h  reason: collision with root package name */
    public HeadImageView f43870h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f43871i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f43872j;
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
        this.f43868f = context;
        b(context);
    }

    public final String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            return m.cutString(str, 18) + this.f43868f.getString(i1.forum);
        }
        return (String) invokeL.objValue;
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            LayoutInflater.from(context).inflate(g1.frs_share_card_view, this);
            setOrientation(1);
            this.f43867e = (LinearLayout) findViewById(f1.share_content);
            this.f43871i = (TextView) findViewById(f1.frs_card_name);
            this.f43869g = (EditText) findViewById(f1.chat_msg);
            this.f43870h = (HeadImageView) findViewById(f1.frs_card_img);
            this.k = (TextView) findViewById(f1.frs_card_member_num);
            this.f43872j = (TextView) findViewById(f1.frs_card_post_num);
            SkinManager.setViewTextColor(this.f43871i, c1.CAM_X0105, 1);
            SkinManager.setViewTextColor(this.f43869g, c1.CAM_X0105, 2);
            this.f43869g.setHintTextColor(SkinManager.getColor(c1.CAM_X0110));
            this.f43869g.setPadding(context.getResources().getDimensionPixelSize(d1.ds20), 0, 0, 0);
            hideEditTextCursor();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f43871i.setText(a(this.l.getName()));
            BdLog.e("mData.getImageUrl()的图片URL" + this.l.getImageUrl());
            this.f43870h.startLoad(this.l.getImageUrl(), 15, false);
            this.k.setText(StringHelper.numFormatOver10000((long) this.l.getMemberNum()));
            this.f43872j.setText(StringHelper.numFormatOver10000((long) this.l.getPostNum()));
        }
    }

    public EditText getChatMsgView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f43869g : (EditText) invokeV.objValue;
    }

    public String getLeaveMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            EditText editText = this.f43869g;
            if (editText != null) {
                return m.charSequence2String(editText.getText(), null);
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public void hideEditTextCursor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f43867e.setFocusable(true);
            this.f43867e.setFocusableInTouchMode(true);
            this.f43867e.requestFocus();
        }
    }

    public void loadImageIcon(String str, boolean z) {
        HeadImageView headImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, z) == null) || (headImageView = this.f43870h) == null) {
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
            this.f43870h.setPageId(bdUniqueId);
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
        this.f43868f = context;
        b(context);
    }
}

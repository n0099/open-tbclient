package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.q0.j1.l.c.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class OfficialFeedItemBottom extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f52857e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f52858f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f52859g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OfficialFeedItemBottom(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setOrientation(1);
            LayoutInflater.from(this.f52857e).inflate(R.layout.official_feed_item_bottom, (ViewGroup) this, true);
            this.f52858f = (TextView) findViewById(R.id.message_no_image_title);
            this.f52859g = (TextView) findViewById(R.id.message_info);
            onSkinTypeChange();
        }
    }

    public void adjustForSingleForum(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f52859g.getLayoutParams();
            layoutParams.topMargin = i2;
            this.f52859g.setLayoutParams(layoutParams);
        }
    }

    public void onSkinTypeChange() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setViewTextColor(this.f52859g, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f52858f, R.color.CAM_X0105);
        }
    }

    public void setData(a.C0970a c0970a, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048579, this, c0970a, z) == null) {
            int i2 = TextUtils.isEmpty(c0970a.f20909b) ? 8 : 0;
            this.f52858f.setText(c0970a.f20908a);
            this.f52859g.setText(c0970a.f20909b);
            this.f52859g.setVisibility(i2);
            if (z) {
                this.f52858f.setVisibility(8);
            } else {
                this.f52858f.setVisibility(0);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfficialFeedItemBottom(Context context, AttributeSet attributeSet) {
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
        this.f52857e = context;
        a();
    }
}

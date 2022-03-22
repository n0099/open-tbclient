package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.view.ChatImageWithTailView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class HistoryItemView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public TbRichTextView f33679b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f33680c;

    /* renamed from: d  reason: collision with root package name */
    public ChatImageWithTailView f33681d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f33682e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HistoryItemView(Context context) {
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
        this.a = context;
        b();
    }

    public void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.f33682e.setBackgroundDrawable(null);
            this.f33682e.removeAllViews();
            this.f33682e.addView(view);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setOrientation(1);
            LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0643, (ViewGroup) this, true);
            setClickable(false);
            setFocusable(false);
            this.f33682e = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090d58);
            this.f33680c = (TextView) findViewById(R.id.obfuscated_res_0x7f090d5d);
            this.f33679b = (TbRichTextView) findViewById(R.id.obfuscated_res_0x7f090d5f);
            this.f33681d = (ChatImageWithTailView) findViewById(R.id.obfuscated_res_0x7f090d5c);
            SkinManager.setBackgroundResource(this.f33682e, R.drawable.selector_history_multi_single_bg);
            SkinManager.setViewTextColor(this.f33680c, R.color.common_color_10067, 1);
            this.f33679b.setTextColor(SkinManager.getColor(R.color.CAM_X0108));
            this.f33681d.setIsSupportNight(true);
        }
    }

    public ChatImageWithTailView getImageView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f33681d : (ChatImageWithTailView) invokeV.objValue;
    }

    public TbRichTextView getRichTextView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f33679b : (TbRichTextView) invokeV.objValue;
    }

    public void setTime(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f33680c.setText(str);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HistoryItemView(Context context, AttributeSet attributeSet) {
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
        this.a = context;
        b();
    }
}

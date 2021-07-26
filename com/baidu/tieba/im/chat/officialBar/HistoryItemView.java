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
/* loaded from: classes4.dex */
public class HistoryItemView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f17382e;

    /* renamed from: f  reason: collision with root package name */
    public TbRichTextView f17383f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17384g;

    /* renamed from: h  reason: collision with root package name */
    public ChatImageWithTailView f17385h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f17386i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HistoryItemView(Context context) {
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
        this.f17382e = context;
        b();
    }

    public void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.f17386i.setBackgroundDrawable(null);
            this.f17386i.removeAllViews();
            this.f17386i.addView(view);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setOrientation(1);
            LayoutInflater.from(this.f17382e).inflate(R.layout.official_history_item, (ViewGroup) this, true);
            setClickable(false);
            setFocusable(false);
            this.f17386i = (LinearLayout) findViewById(R.id.history_container);
            this.f17384g = (TextView) findViewById(R.id.history_send_time);
            this.f17383f = (TbRichTextView) findViewById(R.id.history_txt);
            this.f17385h = (ChatImageWithTailView) findViewById(R.id.history_pic);
            SkinManager.setBackgroundResource(this.f17386i, R.drawable.selector_history_multi_single_bg);
            SkinManager.setViewTextColor(this.f17384g, R.color.common_color_10067, 1);
            this.f17383f.setTextColor(SkinManager.getColor(R.color.CAM_X0108));
            this.f17385h.setIsSupportNight(true);
        }
    }

    public ChatImageWithTailView getImageView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f17385h : (ChatImageWithTailView) invokeV.objValue;
    }

    public TbRichTextView getRichTextView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f17383f : (TbRichTextView) invokeV.objValue;
    }

    public void setTime(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f17384g.setText(str);
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
        this.f17382e = context;
        b();
    }
}

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
/* loaded from: classes12.dex */
public class HistoryItemView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f46541e;

    /* renamed from: f  reason: collision with root package name */
    public TbRichTextView f46542f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f46543g;

    /* renamed from: h  reason: collision with root package name */
    public ChatImageWithTailView f46544h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f46545i;

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
        this.f46541e = context;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setOrientation(1);
            LayoutInflater.from(this.f46541e).inflate(R.layout.official_history_item, (ViewGroup) this, true);
            setClickable(false);
            setFocusable(false);
            this.f46545i = (LinearLayout) findViewById(R.id.history_container);
            this.f46543g = (TextView) findViewById(R.id.history_send_time);
            this.f46542f = (TbRichTextView) findViewById(R.id.history_txt);
            this.f46544h = (ChatImageWithTailView) findViewById(R.id.history_pic);
            SkinManager.setBackgroundResource(this.f46545i, R.drawable.selector_history_multi_single_bg);
            SkinManager.setViewTextColor(this.f46543g, R.color.common_color_10067, 1);
            this.f46542f.setTextColor(SkinManager.getColor(R.color.CAM_X0108));
            this.f46544h.setIsSupportNight(true);
        }
    }

    public void addMultiView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            this.f46545i.setBackgroundDrawable(null);
            this.f46545i.removeAllViews();
            this.f46545i.addView(view);
        }
    }

    public ChatImageWithTailView getImageView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f46544h : (ChatImageWithTailView) invokeV.objValue;
    }

    public TbRichTextView getRichTextView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f46542f : (TbRichTextView) invokeV.objValue;
    }

    public void setTime(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f46543g.setText(str);
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
        this.f46541e = context;
        a();
    }
}

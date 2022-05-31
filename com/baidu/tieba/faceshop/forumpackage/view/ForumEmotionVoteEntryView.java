package com.baidu.tieba.faceshop.forumpackage.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class ForumEmotionVoteEntryView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public LinearLayout c;
    public TextView d;
    public View e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumEmotionVoteEntryView(Context context) {
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
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d02ab, this);
            this.c = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090a7f);
            this.a = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070225);
            this.b = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070224);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f090a20);
            this.e = findViewById(R.id.obfuscated_res_0x7f090a80);
        }
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.c, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0105);
            SkinManager.setBackgroundColor(this.e, R.color.common_color_10312);
        }
    }

    public void setAvatarList(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.c.removeAllViews();
            if (list == null || list.isEmpty()) {
                return;
            }
            for (String str : list) {
                if (!StringUtils.isNull(str)) {
                    TbImageView tbImageView = new TbImageView(getContext());
                    tbImageView.setDrawerType(1);
                    tbImageView.setIsRound(true);
                    tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    int i = this.a;
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
                    layoutParams.leftMargin = this.b;
                    layoutParams.gravity = 17;
                    tbImageView.K(str, 10, false);
                    this.c.addView(tbImageView, layoutParams);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumEmotionVoteEntryView(Context context, AttributeSet attributeSet) {
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
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumEmotionVoteEntryView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        a(context);
    }
}

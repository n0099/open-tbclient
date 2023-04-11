package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.h85;
import com.baidu.tieba.q25;
import com.baidu.tieba.qo7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class NewHotTipLabelView extends EMTextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a b;

    /* loaded from: classes4.dex */
    public interface a {
        void onShow();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewHotTipLabelView(Context context) {
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
        a();
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            if (i == 4) {
                setBackground(SkinManager.getDrawable(R.drawable.icon_mask_hot_point_bubble_n));
            } else {
                setBackground(SkinManager.getDrawable(R.drawable.icon_mask_hot_point_bubble));
            }
            q25 d = q25.d(this);
            d.w(R.color.CAM_X0310);
            d.B(R.dimen.T_X10);
            d.C(R.string.F_X01);
        }
    }

    public void setData(h85 h85Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, h85Var) != null) || h85Var == null) {
            return;
        }
        String cutChineseAndEnglishWithSuffix = StringHelper.cutChineseAndEnglishWithSuffix(h85Var.a(), 6, "");
        if (StringUtils.isNull(cutChineseAndEnglishWithSuffix)) {
            cutChineseAndEnglishWithSuffix = getContext().getString(R.string.obfuscated_res_0x7f0f0d21);
        }
        setText(cutChineseAndEnglishWithSuffix);
        setVisibility(0);
        this.b.onShow();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewHotTipLabelView(Context context, @Nullable AttributeSet attributeSet) {
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
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewHotTipLabelView(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setLayoutParams(new RelativeLayout.LayoutParams(UtilHelper.getDimenPixelSize(R.dimen.tbds120), UtilHelper.getDimenPixelSize(R.dimen.tbds65)));
            setSingleLine();
            setGravity(17);
            setEllipsize(TextUtils.TruncateAt.END);
            setPadding(0, 0, 0, UtilHelper.getDimenPixelSize(R.dimen.tbds14));
            b(TbadkApplication.getInst().getSkinType());
            setVisibility(8);
        }
    }

    public void c() {
        h85 hotNotifyConfig;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (hotNotifyConfig = TbSingleton.getInstance().getHotNotifyConfig()) != null) {
            qo7.c("key_new_hot_topic_update_time", hotNotifyConfig.b());
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDetachedFromWindow();
        }
    }

    public void setHotTipCallBack(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.b = aVar;
        }
    }

    public void setView(ViewGroup viewGroup, float f, float f2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048582, this, new Object[]{viewGroup, Float.valueOf(f), Float.valueOf(f2)}) != null) || viewGroup == null) {
            return;
        }
        viewGroup.removeView(this);
        setTranslationX(f);
        setTranslationY(f2);
        viewGroup.addView(this);
    }
}

package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.mz6;
import com.baidu.tieba.n15;
import com.baidu.tieba.nv4;
import com.baidu.tieba.ux4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class NewHotTipLabelView extends EMTextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener b;
    public CustomMessageListener c;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewHotTipLabelView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(NewHotTipLabelView newHotTipLabelView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newHotTipLabelView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newHotTipLabelView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304) {
                this.a.b(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewHotTipLabelView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(NewHotTipLabelView newHotTipLabelView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newHotTipLabelView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newHotTipLabelView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                String o = ux4.o("key_new_hot_topic_update_time");
                n15 hotNotifyConfig = TbSingleton.getInstance().getHotNotifyConfig();
                if (hotNotifyConfig != null && mz6.b(4320000L) && mz6.a(hotNotifyConfig.b(), o)) {
                    this.a.setData(hotNotifyConfig);
                }
            }
        }
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
        this.b = new a(this, 2001304);
        this.c = new b(this, 2001371);
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewHotTipLabelView(Context context, AttributeSet attributeSet) {
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
        this.b = new a(this, 2001304);
        this.c = new b(this, 2001371);
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewHotTipLabelView(Context context, AttributeSet attributeSet, int i) {
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
        this.b = new a(this, 2001304);
        this.c = new b(this, 2001371);
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
            MessageManager.getInstance().registerListener(this.b);
            MessageManager.getInstance().registerListener(this.c);
        }
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            if (i != 1 && i != 4) {
                setBackground(SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f0807fd));
            } else {
                setBackground(SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f0807fe));
            }
            nv4 d = nv4.d(this);
            d.v(R.color.CAM_X0310);
            d.z(R.dimen.T_X10);
            d.A(R.string.F_X01);
        }
    }

    public void setData(n15 n15Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, n15Var) != null) || n15Var == null) {
            return;
        }
        String cutChineseAndEnglishWithSuffix = StringHelper.cutChineseAndEnglishWithSuffix(n15Var.a(), 6, "");
        if (StringUtils.isNull(cutChineseAndEnglishWithSuffix)) {
            cutChineseAndEnglishWithSuffix = getContext().getString(R.string.obfuscated_res_0x7f0f0c6e);
        }
        setText(cutChineseAndEnglishWithSuffix);
        setVisibility(0);
    }

    public void c() {
        n15 hotNotifyConfig;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (hotNotifyConfig = TbSingleton.getInstance().getHotNotifyConfig()) != null) {
            mz6.c("key_new_hot_topic_update_time", hotNotifyConfig.b());
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.c);
            MessageManager.getInstance().unRegisterListener(this.b);
        }
    }

    public void setView(ViewGroup viewGroup, float f, float f2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048581, this, new Object[]{viewGroup, Float.valueOf(f), Float.valueOf(f2)}) != null) || viewGroup == null) {
            return;
        }
        viewGroup.removeView(this);
        setTranslationX(f);
        setTranslationY(f2);
        viewGroup.addView(this);
    }
}

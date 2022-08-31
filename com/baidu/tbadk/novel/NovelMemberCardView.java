package com.baidu.tbadk.novel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.NovelWebViewActivityConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ns4;
import com.baidu.tieba.p95;
import com.baidu.tieba.q15;
import com.baidu.tieba.q95;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class NovelMemberCardView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public View b;
    public TbImageView c;
    public TextView d;
    public ImageView e;
    public ImageView f;
    public View g;
    public TextView h;
    public q15 i;
    public boolean j;
    public String k;
    public int l;
    public String m;
    public String n;
    public final CustomMessageListener o;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NovelMemberCardView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(NovelMemberCardView novelMemberCardView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {novelMemberCardView, Integer.valueOf(i)};
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
            this.a = novelMemberCardView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921697) {
                int error = customResponsedMessage.getError();
                if (customResponsedMessage.getData() instanceof Boolean) {
                    this.a.j = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (error == 0 && this.a.j) {
                        this.a.i.l(true);
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NovelMemberCardView(Context context) {
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
        this.a = 3;
        this.o = new a(this, 2921697);
        e(context);
    }

    private void getReadDataRecord() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65542, this) == null) || this.i == null) {
            return;
        }
        String c = p95.c(String.valueOf(this.i.f()), TbadkCoreApplication.getCurrentAccount());
        ReadRecordsData readRecordsData = (ReadRecordsData) OrmObject.objectWithJsonStr(c, ReadRecordsData.class);
        if (!StringUtils.isNull(c) && readRecordsData != null && readRecordsData.A()) {
            this.k = readRecordsData.z();
        } else {
            this.k = String.valueOf(this.i.b());
        }
    }

    public final void d(View view2) {
        q15 q15Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (q15Var = this.i) == null) {
            return;
        }
        int i = q15Var.h() ? 2 : 1;
        if (view2.getId() == R.id.obfuscated_res_0x7f0916dc) {
            q95.a(CommonStatisticKey.KEY_PB_NOVEL_INFO_CARD_VIEW_CLICK, 4, String.valueOf(this.i.f()), this.m, this.n);
        } else {
            q95.a(CommonStatisticKey.KEY_PB_NOVEL_INFO_READ_MORE_BUTTON_CLICK, i, String.valueOf(this.i.f()), this.m, this.n);
        }
    }

    public final void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            setOrientation(1);
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0661, (ViewGroup) this, true);
            this.b = findViewById(R.id.obfuscated_res_0x7f0916d9);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.obfuscated_res_0x7f0916dc);
            this.c = tbImageView;
            tbImageView.setDrawCorner(true);
            this.c.setConrers(15);
            this.c.setRadiusById(R.string.J_X06);
            this.e = (ImageView) findViewById(R.id.obfuscated_res_0x7f091b1d);
            this.f = (ImageView) findViewById(R.id.obfuscated_res_0x7f090e14);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f0916de);
            this.g = findViewById(R.id.obfuscated_res_0x7f0916db);
            this.h = (TextView) findViewById(R.id.obfuscated_res_0x7f0916da);
            this.c.setOnClickListener(this);
            setOnClickListener(this);
            g();
            MessageManager.getInstance().registerListener(this.o);
        }
    }

    public void f(q15 q15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, q15Var) == null) {
            if (q15Var.h()) {
                this.b.setVisibility(8);
                this.g.setVisibility(0);
                this.h.setText(R.string.obfuscated_res_0x7f0f0cc3);
                g();
                return;
            }
            this.g.setVisibility(8);
        }
    }

    public void g() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.a) {
            return;
        }
        this.a = skinType;
        this.c.setSkinType(skinType);
        ns4 d = ns4.d(this.d);
        d.A(R.string.F_X01);
        d.z(R.dimen.T_X05);
        d.v(R.color.CAM_X0319);
        ns4 d2 = ns4.d(this.h);
        d2.A(R.string.F_X01);
        d2.z(R.dimen.T_X05);
        d2.v(R.color.CAM_X0304);
        WebPManager.setPureDrawable(this.f, R.drawable.obfuscated_res_0x7f080951, R.color.CAM_X0304, WebPManager.ResourceStateType.NORMAL);
        WebPManager.setPureDrawable(this.e, R.drawable.obfuscated_res_0x7f08089a, R.color.CAM_X0319, WebPManager.ResourceStateType.NORMAL);
    }

    public View getNovelCoverPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            TbImageView tbImageView = this.c;
            if (tbImageView == null || tbImageView.getVisibility() != 0) {
                return null;
            }
            return this.c;
        }
        return (View) invokeV.objValue;
    }

    public View getNovelPaidButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            View view2 = this.g;
            if (view2 == null || view2.getVisibility() != 0) {
                return null;
            }
            return this.g;
        }
        return (View) invokeV.objValue;
    }

    public View getNovelReadMoreButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ImageView imageView = this.e;
            if (imageView == null || imageView.getVisibility() != 0) {
                return null;
            }
            return this.e;
        }
        return (View) invokeV.objValue;
    }

    public final void h() {
        q15 q15Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (q15Var = this.i) == null || StringUtils.isNull(q15Var.c()) || StringUtils.isNull(this.i.a())) {
            return;
        }
        if (this.i.h()) {
            k(l(p95.f(this.i.c(), "data", "cid", this.k)), true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921658, Boolean.TRUE));
            return;
        }
        k(l(this.i.a()), false);
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.o);
        }
    }

    public void j() {
        q15 q15Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (q15Var = this.i) == null) {
            return;
        }
        f(q15Var);
    }

    public final void k(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, str, z) == null) {
            NovelWebViewActivityConfig novelWebViewActivityConfig = new NovelWebViewActivityConfig(getContext(), "", str, true);
            novelWebViewActivityConfig.setIsShowTopToast(z);
            novelWebViewActivityConfig.setBookId(String.valueOf(this.i.f()));
            novelWebViewActivityConfig.setExtraData(this.m, this.n);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, novelWebViewActivityConfig));
        }
    }

    public final String l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) ? p95.g(p95.a(str, "sectionIndex", this.l)) : (String) invokeL.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view2) == null) {
            h();
            d(view2);
        }
    }

    public void setData(q15 q15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, q15Var) == null) {
            if (q15Var != null && !q15Var.i()) {
                setVisibility(0);
                this.i = q15Var;
                if (!StringUtils.isNull(q15Var.d())) {
                    this.c.K(this.i.d(), 10, false);
                } else {
                    this.c.setVisibility(8);
                }
                if (StringUtils.isNull(this.i.e())) {
                    this.d.setText(R.string.obfuscated_res_0x7f0f0cc1);
                } else {
                    this.d.setText(this.i.e());
                }
                this.l = this.i.g();
                f(this.i);
                getReadDataRecord();
                return;
            }
            setVisibility(8);
        }
    }

    public void setStatisticData(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, str2) == null) {
            this.m = str;
            this.n = str2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NovelMemberCardView(Context context, AttributeSet attributeSet) {
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
        this.a = 3;
        this.o = new a(this, 2921697);
        e(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NovelMemberCardView(Context context, AttributeSet attributeSet, int i) {
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
        this.a = 3;
        this.o = new a(this, 2921697);
        e(context);
    }
}

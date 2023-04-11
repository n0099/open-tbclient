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
import com.baidu.tieba.bl5;
import com.baidu.tieba.cl5;
import com.baidu.tieba.q25;
import com.baidu.tieba.vb5;
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
    public vb5 i;
    public boolean j;
    public String k;
    public int l;
    public String m;
    public String n;
    public int o;
    public final CustomMessageListener p;

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
                if (!(customResponsedMessage.getData() instanceof Boolean)) {
                    return;
                }
                this.a.j = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (error == 0 && this.a.j) {
                    this.a.i.l(true);
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
        this.p = new a(this, 2921697);
        e(context);
    }

    public void f(vb5 vb5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, vb5Var) == null) {
            if (vb5Var.h()) {
                this.b.setVisibility(8);
                this.g.setVisibility(0);
                this.h.setText(R.string.novel_member_payed);
                g();
                return;
            }
            this.g.setVisibility(8);
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
        this.p = new a(this, 2921697);
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
        this.p = new a(this, 2921697);
        e(context);
    }

    public final String l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            return bl5.g(bl5.a(str, "sectionIndex", this.l));
        }
        return (String) invokeL.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view2) == null) {
            h();
            d(view2);
        }
    }

    private void getReadDataRecord() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65542, this) != null) || this.i == null) {
            return;
        }
        String c = bl5.c(String.valueOf(this.i.f()), TbadkCoreApplication.getCurrentAccount());
        ReadRecordsData readRecordsData = (ReadRecordsData) OrmObject.objectWithJsonStr(c, ReadRecordsData.class);
        if (!StringUtils.isNull(c) && readRecordsData != null && readRecordsData.R()) {
            this.k = readRecordsData.Q();
        } else {
            this.k = String.valueOf(this.i.b());
        }
    }

    public void g() {
        int skinType;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.a) {
            return;
        }
        this.a = skinType;
        this.c.setSkinType(skinType);
        q25 d = q25.d(this.d);
        d.C(R.string.F_X01);
        d.B(R.dimen.T_X05);
        d.w(R.color.CAM_X0319);
        q25 d2 = q25.d(this.h);
        d2.C(R.string.F_X01);
        d2.B(R.dimen.T_X05);
        d2.w(R.color.CAM_X0304);
        WebPManager.setPureDrawable(this.f, R.drawable.icon_pure_list_arrow_right, R.color.CAM_X0304, WebPManager.ResourceStateType.NORMAL);
        WebPManager.setPureDrawable(this.e, R.drawable.icon_novel_lock, R.color.CAM_X0319, WebPManager.ResourceStateType.NORMAL);
    }

    public final void d(View view2) {
        vb5 vb5Var;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (vb5Var = this.i) != null) {
            if (vb5Var.h()) {
                i = 2;
            } else {
                i = 1;
            }
            if (view2.getId() == R.id.novel_member_rights_page) {
                cl5.b(CommonStatisticKey.KEY_PB_NOVEL_INFO_CARD_VIEW_CLICK, 4, String.valueOf(this.i.f()), this.m, this.n, this.o);
            } else {
                cl5.a(CommonStatisticKey.KEY_PB_NOVEL_INFO_READ_MORE_BUTTON_CLICK, i, String.valueOf(this.i.f()), this.m, this.n);
            }
        }
    }

    public final void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            setOrientation(1);
            LayoutInflater.from(context).inflate(R.layout.novel_member_card_layout, (ViewGroup) this, true);
            this.b = findViewById(R.id.novel_member_no_pay_view);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.novel_member_rights_page);
            this.c = tbImageView;
            tbImageView.setDrawCorner(true);
            this.c.setConrers(15);
            this.c.setRadiusById(R.string.J_X06);
            this.e = (ImageView) findViewById(R.id.read_more_lock_icon);
            this.f = (ImageView) findViewById(R.id.icon_pure_arrow_right);
            this.d = (TextView) findViewById(R.id.novel_read_more_text);
            this.g = findViewById(R.id.novel_member_pay_view);
            this.h = (TextView) findViewById(R.id.novel_member_pay_tip);
            this.c.setOnClickListener(this);
            setOnClickListener(this);
            g();
            MessageManager.getInstance().registerListener(this.p);
        }
    }

    public void setData(vb5 vb5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, vb5Var) == null) {
            if (vb5Var != null && !vb5Var.i()) {
                setVisibility(0);
                this.i = vb5Var;
                if (!StringUtils.isNull(vb5Var.d())) {
                    this.c.N(this.i.d(), 10, false);
                } else {
                    this.c.setVisibility(8);
                }
                if (StringUtils.isNull(this.i.e())) {
                    this.d.setText(R.string.novel_default_tip);
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

    public View getNovelCoverPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            TbImageView tbImageView = this.c;
            if (tbImageView != null && tbImageView.getVisibility() == 0) {
                return this.c;
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public View getNovelPaidButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            View view2 = this.g;
            if (view2 != null && view2.getVisibility() == 0) {
                return this.g;
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public View getNovelReadMoreButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ImageView imageView = this.e;
            if (imageView != null && imageView.getVisibility() == 0) {
                return this.e;
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.p);
        }
    }

    public void j() {
        vb5 vb5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (vb5Var = this.i) != null) {
            f(vb5Var);
        }
    }

    public final void h() {
        vb5 vb5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (vb5Var = this.i) != null && !StringUtils.isNull(vb5Var.c()) && !StringUtils.isNull(this.i.a())) {
            if (this.i.h()) {
                k(l(bl5.f(this.i.c(), "data", "cid", this.k)), true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921658, Boolean.TRUE));
                return;
            }
            k(l(this.i.a()), false);
        }
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

    public void setStatisticData(String str, String str2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048590, this, str, str2, i) == null) {
            this.m = str;
            this.n = str2;
            this.o = i;
        }
    }
}

package com.baidu.tieba.barselect.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.segment.VotedAreaLayout;
import com.baidu.tieba.hi6;
import com.baidu.tieba.vg;
import com.baidu.tieba.wh6;
import com.baidu.tieba.xh6;
import com.baidu.tieba.yh6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class FloatMyRecordCard extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public int b;
    public yh6 c;
    public wh6 d;
    public TextView e;
    public BazhuHeadView f;
    public TextView g;
    public ImageView h;
    public TextView i;
    public VotedAreaLayout j;
    public View.OnClickListener k;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FloatMyRecordCard a;

        public a(FloatMyRecordCard floatMyRecordCard) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {floatMyRecordCard};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = floatMyRecordCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.d != null && this.a.d.l() != 0) {
                long g = vg.g(TbadkCoreApplication.getCurrentAccount(), 0L);
                long l = this.a.d.l();
                if (this.a.getContext() instanceof Activity) {
                    PersonPolymericActivityConfig personPolymericActivityConfig = new PersonPolymericActivityConfig(this.a.getContext());
                    if (l == g) {
                        z = true;
                    } else {
                        z = false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, personPolymericActivityConfig.createNormalConfig(l, z, false)));
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FloatMyRecordCard(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FloatMyRecordCard(Context context, AttributeSet attributeSet) {
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
        this.k = new a(this);
        c();
    }

    public void setGrade(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            SkinManager.setImageResource(this.h, BitmapHelper.getGradeResourceIdInEnterForum(i));
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f092746);
            BazhuHeadView bazhuHeadView = (BazhuHeadView) findViewById(R.id.user_avatar);
            this.f = bazhuHeadView;
            if (bazhuHeadView.getHeadView() != null) {
                this.f.getHeadView().setIsRound(true);
            }
            this.g = (TextView) findViewById(R.id.user_name);
            this.h = (ImageView) findViewById(R.id.obfuscated_res_0x7f090e4c);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f092960);
            this.j = (VotedAreaLayout) findViewById(R.id.obfuscated_res_0x7f09180c);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = getContext();
            setOrientation(0);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d02cb, (ViewGroup) this, true);
            b();
        }
    }

    public void d(int i) {
        wh6 wh6Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) != null) || (wh6Var = this.d) == null) {
            return;
        }
        if (wh6Var.i() > 3) {
            SkinManager.setViewTextColor(this.e, R.color.CAM_X0105, 1, i);
        }
        SkinManager.setViewTextColor(this.g, R.color.CAM_X0105, 1, i);
        setGrade(this.d.d());
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0109, 1, i);
        this.j.c(i);
        SkinManager.setBackgroundColor(this, R.color.CAM_X0201, i);
        setGrade(this.d.d());
    }

    public void setData(yh6 yh6Var) {
        wh6 wh6Var;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, yh6Var) == null) {
            this.c = yh6Var;
            if (yh6Var != null && yh6Var.a() != null) {
                xh6 a2 = this.c.a();
                if (a2 != null) {
                    this.b = a2.h();
                }
                this.d = this.c.f();
            }
            if (this.c != null && (wh6Var = this.d) != null && this.b == hi6.c) {
                int i = wh6Var.i();
                if (i < 10) {
                    this.e.setText("0" + i);
                } else {
                    this.e.setText("" + i);
                }
                if (i == 2) {
                    this.e.setTextColor(getResources().getColor(R.color.common_color_10263));
                } else if (i == 3) {
                    this.e.setTextColor(getResources().getColor(R.color.common_color_10266));
                }
                this.f.m(this.d.g());
                this.f.setOnClickListener(this.k);
                this.g.setText(StringHelper.cutChineseAndEnglishWithSuffix(this.d.e(), 14, "..."));
                setGrade(this.d.d());
                if (this.d.c() < 1000) {
                    String str2 = "0000" + this.d.c();
                    str = str2.substring(str2.length() - 4, str2.length());
                } else {
                    str = "" + this.d.c();
                }
                this.i.setText("NO." + str);
                this.j.setMyRecordData(this.d);
                return;
            }
            setVisibility(8);
        }
    }
}

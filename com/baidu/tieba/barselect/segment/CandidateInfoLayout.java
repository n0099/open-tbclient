package com.baidu.tieba.barselect.segment;

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
import com.baidu.tieba.barselect.view.BazhuHeadView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dw5;
import com.repackage.mg;
import com.repackage.oi;
import com.repackage.uv5;
import com.repackage.wv5;
/* loaded from: classes3.dex */
public class CandidateInfoLayout extends CardBasicLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context d;
    public BazhuHeadView e;
    public LinearLayout f;
    public TextView g;
    public TextView h;
    public ImageView i;
    public TextView j;
    public View.OnClickListener k;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CandidateInfoLayout a;

        public a(CandidateInfoLayout candidateInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {candidateInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = candidateInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            uv5 uv5Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (uv5Var = this.a.c) == null || uv5Var.l() == 0) {
                return;
            }
            long g = mg.g(TbadkCoreApplication.getCurrentAccount(), 0L);
            long l = this.a.c.l();
            if (!(this.a.getContext() instanceof Activity) || this.a.c.f() == 2) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.a.getContext()).createNormalConfig(l, l == g, false)));
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CandidateInfoLayout(Context context) {
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

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            BazhuHeadView bazhuHeadView = (BazhuHeadView) findViewById(R.id.obfuscated_res_0x7f09227a);
            this.e = bazhuHeadView;
            if (bazhuHeadView.getHeadView() != null) {
                this.e.getHeadView().setIsRound(true);
            }
            this.f = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09229d);
            this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f09229c);
            this.h = (TextView) findViewById(R.id.obfuscated_res_0x7f0923f7);
            this.j = (TextView) findViewById(R.id.obfuscated_res_0x7f090163);
            this.i = (ImageView) findViewById(R.id.obfuscated_res_0x7f090ce7);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.d = getContext();
            setClipChildren(false);
            setClipToPadding(false);
            setOrientation(0);
            setGravity(80);
            setMinimumHeight(oi.f(getContext(), R.dimen.tbds90));
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0176, (ViewGroup) this, true);
            a();
        }
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            SkinManager.setViewTextColor(this.g, R.color.CAM_X0105, 1, i);
            SkinManager.setViewTextColor(this.h, R.color.CAM_X0109, 1, i);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0109, 1, i);
            uv5 uv5Var = this.c;
            if (uv5Var != null) {
                setGrade(uv5Var.d());
            }
        }
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, wv5 wv5Var) {
        int i2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, wv5Var) == null) {
            super.setData(i, wv5Var);
            if (this.b != null && this.c != null && (i2 = this.a) >= 0) {
                if (i2 == dw5.c) {
                    int f = oi.f(this.d, R.dimen.tbds191);
                    int f2 = oi.f(this.d, R.dimen.tbds157);
                    int f3 = oi.f(this.d, R.dimen.tbds6);
                    int f4 = oi.f(this.d, R.dimen.tbds24);
                    int f5 = oi.f(this.d, R.dimen.tbds30);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(f2, f);
                    layoutParams.setMargins(layoutParams.leftMargin - f3, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
                    this.e.setLayoutParams(layoutParams);
                    this.e.o(true);
                    this.e.setBawuLogoView(R.drawable.obfuscated_res_0x7f080efd);
                    this.e.setPendantView(R.drawable.obfuscated_res_0x7f0806de);
                    this.g.setTextSize(0, oi.f(this.d, R.dimen.tbfontsize46));
                    setGravity(16);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.setMargins(f5, f4, layoutParams2.rightMargin, f3);
                    this.e.setLayoutParams(layoutParams);
                    this.f.setLayoutParams(layoutParams2);
                } else {
                    this.e.o(false);
                }
                this.e.l(this.c.g());
                this.e.setOnClickListener(this.k);
                this.g.setText(StringHelper.cutChineseAndEnglishWithSuffix(this.c.e(), 14, StringHelper.STRING_MORE));
                setGrade(this.c.d());
                if (this.c.f() == 2) {
                    this.h.setVisibility(8);
                } else {
                    this.h.setVisibility(0);
                    if (this.c.c() < 1000) {
                        String str2 = "0000" + this.c.c();
                        str = str2.substring(str2.length() - 4, str2.length());
                    } else {
                        str = "" + this.c.c();
                    }
                    this.h.setText("NO." + str);
                }
                this.j.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f00e1), StringHelper.numFormatOverWanWithNegative(this.c.a()), StringHelper.numFormatOverWanWithNegative(this.c.j()), StringHelper.numFormatOverWanWithNegative(this.c.h())));
                return;
            }
            setVisibility(8);
        }
    }

    public void setGrade(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            SkinManager.setImageResource(this.i, BitmapHelper.getGradeResourceIdInEnterForum(i));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CandidateInfoLayout(Context context, AttributeSet attributeSet) {
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
        b();
    }
}

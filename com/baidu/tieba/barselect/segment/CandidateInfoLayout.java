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
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.view.BazhuHeadView;
import com.baidu.tieba.hi6;
import com.baidu.tieba.ji6;
import com.baidu.tieba.qi6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
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
            hi6 hi6Var;
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (hi6Var = this.a.c) != null && hi6Var.l() != 0) {
                long j = JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                long l = this.a.c.l();
                if ((this.a.getContext() instanceof Activity) && this.a.c.f() != 2) {
                    PersonPolymericActivityConfig personPolymericActivityConfig = new PersonPolymericActivityConfig(this.a.getContext());
                    if (l == j) {
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

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            BazhuHeadView bazhuHeadView = (BazhuHeadView) findViewById(R.id.user_avatar);
            this.e = bazhuHeadView;
            if (bazhuHeadView.getHeadView() != null) {
                this.e.getHeadView().setIsRound(true);
            }
            this.f = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f092897);
            this.g = (TextView) findViewById(R.id.user_name);
            this.h = (TextView) findViewById(R.id.obfuscated_res_0x7f092a1d);
            this.j = (TextView) findViewById(R.id.obfuscated_res_0x7f09016b);
            this.i = (ImageView) findViewById(R.id.obfuscated_res_0x7f090e78);
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
            setMinimumHeight(BdUtilHelper.getDimens(getContext(), R.dimen.tbds90));
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d019e, (ViewGroup) this, true);
            a();
        }
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            SkinManager.setViewTextColor(this.g, R.color.CAM_X0105, 1, i);
            SkinManager.setViewTextColor(this.h, R.color.CAM_X0109, 1, i);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0109, 1, i);
            hi6 hi6Var = this.c;
            if (hi6Var != null) {
                setGrade(hi6Var.d());
            }
        }
    }

    public void setGrade(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            SkinManager.setImageResource(this.i, BitmapHelper.getGradeResourceIdInEnterForum(i));
        }
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, ji6 ji6Var) {
        int i2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, ji6Var) == null) {
            super.setData(i, ji6Var);
            if (this.b != null && this.c != null && (i2 = this.a) >= 0) {
                if (i2 == qi6.c) {
                    int dimens = BdUtilHelper.getDimens(this.d, R.dimen.tbds191);
                    int dimens2 = BdUtilHelper.getDimens(this.d, R.dimen.tbds157);
                    int dimens3 = BdUtilHelper.getDimens(this.d, R.dimen.tbds6);
                    int dimens4 = BdUtilHelper.getDimens(this.d, R.dimen.tbds24);
                    int dimens5 = BdUtilHelper.getDimens(this.d, R.dimen.tbds30);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens2, dimens);
                    layoutParams.setMargins(layoutParams.leftMargin - dimens3, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
                    this.e.setLayoutParams(layoutParams);
                    this.e.p(true);
                    this.e.setBawuLogoView(R.drawable.obfuscated_res_0x7f0811ee);
                    this.e.setPendantView(R.drawable.obfuscated_res_0x7f080895);
                    this.g.setTextSize(0, BdUtilHelper.getDimens(this.d, R.dimen.tbfontsize46));
                    setGravity(16);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.setMargins(dimens5, dimens4, layoutParams2.rightMargin, dimens3);
                    this.e.setLayoutParams(layoutParams);
                    this.f.setLayoutParams(layoutParams2);
                } else {
                    this.e.p(false);
                }
                this.e.m(this.c.g());
                this.e.setOnClickListener(this.k);
                this.g.setText(StringHelper.cutChineseAndEnglishWithSuffix(this.c.e(), 14, "..."));
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
                this.j.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0116), StringHelper.numFormatOverWanWithNegative(this.c.a()), StringHelper.numFormatOverWanWithNegative(this.c.j()), StringHelper.numFormatOverWanWithNegative(this.c.h())));
                return;
            }
            setVisibility(8);
        }
    }
}

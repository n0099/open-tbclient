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
import c.a.d.f.m.b;
import c.a.d.f.p.n;
import c.a.p0.e0.b.d;
import c.a.p0.e0.b.f;
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
/* loaded from: classes5.dex */
public class CandidateInfoLayout extends CardBasicLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public Context f31567d;

    /* renamed from: e  reason: collision with root package name */
    public BazhuHeadView f31568e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f31569f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f31570g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f31571h;
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
        public void onClick(View view) {
            d dVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (dVar = this.a.f31573c) == null || dVar.l() == 0) {
                return;
            }
            long g2 = b.g(TbadkCoreApplication.getCurrentAccount(), 0L);
            long l = this.a.f31573c.l();
            if (!(this.a.getContext() instanceof Activity) || this.a.f31573c.f() == 2) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.a.getContext()).createNormalConfig(l, l == g2, false)));
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
            BazhuHeadView bazhuHeadView = (BazhuHeadView) findViewById(R.id.obfuscated_res_0x7f092296);
            this.f31568e = bazhuHeadView;
            if (bazhuHeadView.getHeadView() != null) {
                this.f31568e.getHeadView().setIsRound(true);
            }
            this.f31569f = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0922bc);
            this.f31570g = (TextView) findViewById(R.id.obfuscated_res_0x7f0922bb);
            this.f31571h = (TextView) findViewById(R.id.obfuscated_res_0x7f09241c);
            this.j = (TextView) findViewById(R.id.obfuscated_res_0x7f09015a);
            this.i = (ImageView) findViewById(R.id.obfuscated_res_0x7f090ce0);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f31567d = getContext();
            setClipChildren(false);
            setClipToPadding(false);
            setOrientation(0);
            setGravity(80);
            setMinimumHeight(n.f(getContext(), R.dimen.tbds90));
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0172, (ViewGroup) this, true);
            a();
        }
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            SkinManager.setViewTextColor(this.f31570g, R.color.CAM_X0105, 1, i);
            SkinManager.setViewTextColor(this.f31571h, R.color.CAM_X0109, 1, i);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0109, 1, i);
            d dVar = this.f31573c;
            if (dVar != null) {
                setGrade(dVar.d());
            }
        }
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        int i2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, fVar) == null) {
            super.setData(i, fVar);
            if (this.f31572b != null && this.f31573c != null && (i2 = this.a) >= 0) {
                if (i2 == c.a.p0.e0.e.a.f13758c) {
                    int f2 = n.f(this.f31567d, R.dimen.tbds191);
                    int f3 = n.f(this.f31567d, R.dimen.tbds157);
                    int f4 = n.f(this.f31567d, R.dimen.tbds6);
                    int f5 = n.f(this.f31567d, R.dimen.tbds24);
                    int f6 = n.f(this.f31567d, R.dimen.tbds30);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(f3, f2);
                    layoutParams.setMargins(layoutParams.leftMargin - f4, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
                    this.f31568e.setLayoutParams(layoutParams);
                    this.f31568e.o(true);
                    this.f31568e.setBawuLogoView(R.drawable.obfuscated_res_0x7f080ef3);
                    this.f31568e.setPendantView(R.drawable.obfuscated_res_0x7f0806df);
                    this.f31570g.setTextSize(0, n.f(this.f31567d, R.dimen.tbfontsize46));
                    setGravity(16);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.setMargins(f6, f5, layoutParams2.rightMargin, f4);
                    this.f31568e.setLayoutParams(layoutParams);
                    this.f31569f.setLayoutParams(layoutParams2);
                } else {
                    this.f31568e.o(false);
                }
                this.f31568e.l(this.f31573c.g());
                this.f31568e.setOnClickListener(this.k);
                this.f31570g.setText(StringHelper.cutChineseAndEnglishWithSuffix(this.f31573c.e(), 14, StringHelper.STRING_MORE));
                setGrade(this.f31573c.d());
                if (this.f31573c.f() == 2) {
                    this.f31571h.setVisibility(8);
                } else {
                    this.f31571h.setVisibility(0);
                    if (this.f31573c.c() < 1000) {
                        String str2 = "0000" + this.f31573c.c();
                        str = str2.substring(str2.length() - 4, str2.length());
                    } else {
                        str = "" + this.f31573c.c();
                    }
                    this.f31571h.setText("NO." + str);
                }
                this.j.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f00e0), StringHelper.numFormatOverWanWithNegative(this.f31573c.a()), StringHelper.numFormatOverWanWithNegative(this.f31573c.j()), StringHelper.numFormatOverWanWithNegative(this.f31573c.h())));
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

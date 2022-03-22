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
import c.a.d.f.m.b;
import c.a.p0.e0.b.d;
import c.a.p0.e0.b.e;
import c.a.p0.e0.b.f;
import c.a.p0.e0.e.c;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class FloatMyRecordCard extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public int f31587b;

    /* renamed from: c  reason: collision with root package name */
    public f f31588c;

    /* renamed from: d  reason: collision with root package name */
    public d f31589d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f31590e;

    /* renamed from: f  reason: collision with root package name */
    public BazhuHeadView f31591f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f31592g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f31593h;
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.f31589d == null || this.a.f31589d.l() == 0) {
                return;
            }
            long g2 = b.g(TbadkCoreApplication.getCurrentAccount(), 0L);
            long l = this.a.f31589d.l();
            if (this.a.getContext() instanceof Activity) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.a.getContext()).createNormalConfig(l, l == g2, false)));
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

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f31590e = (TextView) findViewById(R.id.obfuscated_res_0x7f09222e);
            BazhuHeadView bazhuHeadView = (BazhuHeadView) findViewById(R.id.obfuscated_res_0x7f092296);
            this.f31591f = bazhuHeadView;
            if (bazhuHeadView.getHeadView() != null) {
                this.f31591f.getHeadView().setIsRound(true);
            }
            this.f31592g = (TextView) findViewById(R.id.obfuscated_res_0x7f0922bb);
            this.f31593h = (ImageView) findViewById(R.id.obfuscated_res_0x7f090ce0);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f09241c);
            this.j = (VotedAreaLayout) findViewById(R.id.obfuscated_res_0x7f09149b);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = getContext();
            setOrientation(0);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0295, (ViewGroup) this, true);
            b();
        }
    }

    public void d(int i) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || (dVar = this.f31589d) == null) {
            return;
        }
        if (dVar.i() > 3) {
            SkinManager.setViewTextColor(this.f31590e, R.color.CAM_X0105, 1, i);
        }
        SkinManager.setViewTextColor(this.f31592g, R.color.CAM_X0105, 1, i);
        setGrade(this.f31589d.d());
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0109, 1, i);
        this.j.c(i);
        SkinManager.setBackgroundColor(this, R.color.CAM_X0201, i);
        setGrade(this.f31589d.d());
    }

    public void setData(f fVar) {
        d dVar;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            this.f31588c = fVar;
            if (fVar != null && fVar.a() != null) {
                e a2 = this.f31588c.a();
                if (a2 != null) {
                    this.f31587b = a2.g();
                }
                this.f31589d = this.f31588c.f();
            }
            if (this.f31588c != null && (dVar = this.f31589d) != null && this.f31587b == c.f13761c) {
                int i = dVar.i();
                if (i < 10) {
                    this.f31590e.setText("0" + i);
                } else {
                    this.f31590e.setText("" + i);
                }
                if (i == 2) {
                    this.f31590e.setTextColor(getResources().getColor(R.color.common_color_10263));
                } else if (i == 3) {
                    this.f31590e.setTextColor(getResources().getColor(R.color.common_color_10266));
                }
                this.f31591f.l(this.f31589d.g());
                this.f31591f.setOnClickListener(this.k);
                this.f31592g.setText(StringHelper.cutChineseAndEnglishWithSuffix(this.f31589d.e(), 14, StringHelper.STRING_MORE));
                setGrade(this.f31589d.d());
                if (this.f31589d.c() < 1000) {
                    String str2 = "0000" + this.f31589d.c();
                    str = str2.substring(str2.length() - 4, str2.length());
                } else {
                    str = "" + this.f31589d.c();
                }
                this.i.setText("NO." + str);
                this.j.setMyRecordData(this.f31589d);
                return;
            }
            setVisibility(8);
        }
    }

    public void setGrade(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            SkinManager.setImageResource(this.f31593h, BitmapHelper.getGradeResourceIdInEnterForum(i));
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
}

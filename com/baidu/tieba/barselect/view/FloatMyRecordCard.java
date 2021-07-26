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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.m.b;
import d.a.q0.x.b.d;
import d.a.q0.x.b.e;
import d.a.q0.x.b.f;
import d.a.q0.x.e.c;
/* loaded from: classes4.dex */
public class FloatMyRecordCard extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f14502e;

    /* renamed from: f  reason: collision with root package name */
    public int f14503f;

    /* renamed from: g  reason: collision with root package name */
    public f f14504g;

    /* renamed from: h  reason: collision with root package name */
    public d f14505h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f14506i;
    public BazhuHeadView j;
    public TextView k;
    public ImageView l;
    public TextView m;
    public VotedAreaLayout n;
    public View.OnClickListener o;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FloatMyRecordCard f14507e;

        public a(FloatMyRecordCard floatMyRecordCard) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {floatMyRecordCard};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14507e = floatMyRecordCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f14507e.f14505h == null || this.f14507e.f14505h.l() == 0) {
                return;
            }
            long f2 = b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
            long l = this.f14507e.f14505h.l();
            if (this.f14507e.getContext() instanceof Activity) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f14507e.getContext()).createNormalConfig(l, l == f2, false)));
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            this.f14506i = (TextView) findViewById(R.id.tv_voted_rank);
            BazhuHeadView bazhuHeadView = (BazhuHeadView) findViewById(R.id.user_avatar);
            this.j = bazhuHeadView;
            if (bazhuHeadView.getHeadView() != null) {
                this.j.getHeadView().setIsRound(true);
            }
            this.k = (TextView) findViewById(R.id.user_name);
            this.l = (ImageView) findViewById(R.id.grade);
            this.m = (TextView) findViewById(R.id.vote_id);
            this.n = (VotedAreaLayout) findViewById(R.id.my_vote_num_layout);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f14502e = getContext();
            setOrientation(0);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            LayoutInflater.from(getContext()).inflate(R.layout.float_my_record_card, (ViewGroup) this, true);
            b();
        }
    }

    public void d(int i2) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || (dVar = this.f14505h) == null) {
            return;
        }
        if (dVar.i() > 3) {
            SkinManager.setViewTextColor(this.f14506i, R.color.CAM_X0105, 1, i2);
        }
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0105, 1, i2);
        setGrade(this.f14505h.d());
        SkinManager.setViewTextColor(this.m, R.color.CAM_X0109, 1, i2);
        this.n.c(i2);
        SkinManager.setBackgroundColor(this, R.color.CAM_X0201, i2);
        setGrade(this.f14505h.d());
    }

    public void setData(f fVar) {
        d dVar;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            this.f14504g = fVar;
            if (fVar != null && fVar.a() != null) {
                e a2 = this.f14504g.a();
                if (a2 != null) {
                    this.f14503f = a2.g();
                }
                this.f14505h = this.f14504g.f();
            }
            if (this.f14504g != null && (dVar = this.f14505h) != null && this.f14503f == c.f66852c) {
                int i2 = dVar.i();
                if (i2 < 10) {
                    this.f14506i.setText("0" + i2);
                } else {
                    this.f14506i.setText("" + i2);
                }
                if (i2 == 2) {
                    this.f14506i.setTextColor(getResources().getColor(R.color.common_color_10263));
                } else if (i2 == 3) {
                    this.f14506i.setTextColor(getResources().getColor(R.color.common_color_10266));
                }
                this.j.k(this.f14505h.g());
                this.j.setOnClickListener(this.o);
                this.k.setText(StringHelper.cutChineseAndEnglishWithSuffix(this.f14505h.e(), 14, StringHelper.STRING_MORE));
                setGrade(this.f14505h.d());
                if (this.f14505h.c() < 1000) {
                    String str2 = "0000" + this.f14505h.c();
                    str = str2.substring(str2.length() - 4, str2.length());
                } else {
                    str = "" + this.f14505h.c();
                }
                this.m.setText("NO." + str);
                this.n.setMyRecordData(this.f14505h);
                return;
            }
            setVisibility(8);
        }
    }

    public void setGrade(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            SkinManager.setImageResource(this.l, BitmapHelper.getGradeResourceIdInEnterForum(i2));
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.o = new a(this);
        c();
    }
}

package com.baidu.tieba.barselect.view;

import android.content.Context;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.e.e.p.l;
import b.a.r0.c4.d;
import b.a.r0.y.b.e;
import b.a.r0.y.b.f;
import b.a.r0.y.e.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.view.NewVoteCountDownView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class VoteStatusCard extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f47379e;

    /* renamed from: f  reason: collision with root package name */
    public int f47380f;

    /* renamed from: g  reason: collision with root package name */
    public f f47381g;

    /* renamed from: h  reason: collision with root package name */
    public e f47382h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f47383i;
    public VoteStatusView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public NewVoteCountDownView q;
    public View r;
    public Path s;
    public b t;
    public NewVoteCountDownView.b u;

    /* loaded from: classes9.dex */
    public class a implements NewVoteCountDownView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VoteStatusCard f47384a;

        public a(VoteStatusCard voteStatusCard) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {voteStatusCard};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47384a = voteStatusCard;
        }

        @Override // com.baidu.tieba.view.NewVoteCountDownView.b
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f47384a.t == null) {
                return;
            }
            this.f47384a.t.onRefresh();
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
        void onRefresh();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VoteStatusCard(Context context) {
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
            this.f47383i = (TextView) findViewById(R.id.bar_maneger_apply_title);
            this.j = (VoteStatusView) findViewById(R.id.vote_status_view);
            this.k = (TextView) findViewById(R.id.apply_title);
            this.l = (TextView) findViewById(R.id.apply_start_time);
            this.m = (TextView) findViewById(R.id.vote_title);
            this.n = (TextView) findViewById(R.id.vote_start_time);
            this.o = (TextView) findViewById(R.id.publicity_title);
            this.p = (TextView) findViewById(R.id.publicity_start_time);
            this.r = findViewById(R.id.vote_count_down_container);
            this.q = (NewVoteCountDownView) findViewById(R.id.vote_count_down_view);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Path path = new Path();
            this.s = path;
            path.moveTo(0.0f, 15.0f);
            this.s.lineTo(440.0f, 15.0f);
            this.s.lineTo(454.0f, 0.0f);
            this.s.lineTo(468.0f, 15.0f);
            this.s.lineTo(902.0f, 15.0f);
            this.s.lineTo(902.0f, 224.0f);
            this.s.lineTo(0.0f, 224.0f);
            this.s.lineTo(0.0f, 15.0f);
            this.s.close();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f47379e = getContext();
            setOrientation(1);
            setMinimumHeight(l.g(getContext(), R.dimen.tbds90));
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            setBackgroundResource(R.drawable.bar_select_bg_shadow_and_radius);
            int g2 = l.g(this.f47379e, R.dimen.tbds56);
            int g3 = l.g(this.f47379e, R.dimen.tbds52);
            setPadding(g2, g3, g2, g3);
            LayoutInflater.from(getContext()).inflate(R.layout.vote_status_card, (ViewGroup) this, true);
            b();
            c();
        }
    }

    public void onDestroy() {
        NewVoteCountDownView newVoteCountDownView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (newVoteCountDownView = this.q) == null) {
            return;
        }
        newVoteCountDownView.onDestroy();
    }

    public void onSkinChange(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            int color = SkinManager.getColor(i2, R.color.CAM_X0105);
            int color2 = SkinManager.getColor(i2, R.color.CAM_X0109);
            TextView textView = this.k;
            if (textView != null) {
                textView.setTextColor(color);
            }
            TextView textView2 = this.m;
            if (textView2 != null) {
                textView2.setTextColor(this.f47380f > c.f27224a ? color : color2);
            }
            TextView textView3 = this.o;
            if (textView3 != null) {
                if (this.f47380f <= c.f27225b) {
                    color = color2;
                }
                textView3.setTextColor(color);
            }
            VoteStatusView voteStatusView = this.j;
            if (voteStatusView != null) {
                voteStatusView.onSkinChange(i2);
            }
            SkinManager.setViewTextColor(this.f47383i, R.color.CAM_X0105, 1, i2);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0109, 1, i2);
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0109, 1, i2);
            SkinManager.setViewTextColor(this.p, R.color.CAM_X0109, 1, i2);
            SkinManager.setBackgroundResource(this, R.drawable.bar_select_bg_shadow_and_radius, i2);
            NewVoteCountDownView newVoteCountDownView = this.q;
            if (newVoteCountDownView != null) {
                newVoteCountDownView.onSkinChange(i2);
            }
            int color3 = SkinManager.getColor(R.color.CAM_X0206);
            d dVar = new d(this.s, 902.0f, 224.0f);
            dVar.a(color3);
            this.r.setBackground(dVar);
        }
    }

    public void setData(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            this.f47381g = fVar;
            if (fVar != null && fVar.a() != null) {
                e a2 = this.f47381g.a();
                this.f47382h = a2;
                int g2 = a2.g();
                this.f47380f = g2;
                this.j.setStatus(g2);
                long f2 = this.f47382h.f() * 1000;
                this.l.setText(StringHelper.getDateStringMd(this.f47382h.c() * 1000));
                this.n.setText(StringHelper.getDateStringMdHm(this.f47382h.h() * 1000));
                this.p.setText(StringHelper.getDateStringMdHm(this.f47382h.d() * 1000));
                if (this.f47380f == c.f27225b) {
                    this.r.setVisibility(0);
                    NewVoteCountDownView.b bVar = this.u;
                    if (bVar != null) {
                        this.q.setOnCountDownFinished(bVar);
                    }
                    this.q.setData(f2);
                    return;
                }
                this.r.setVisibility(8);
                return;
            }
            setVisibility(8);
        }
    }

    public void setOnRefreshListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.t = bVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoteStatusCard(Context context, AttributeSet attributeSet) {
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
        this.f47380f = c.f27225b;
        this.u = new a(this);
        d();
    }
}

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
import d.a.d.e.m.b;
import d.a.d.e.p.l;
import d.a.q0.x.b.d;
import d.a.q0.x.b.f;
/* loaded from: classes4.dex */
public class CandidateInfoLayout extends CardBasicLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public Context f14487h;

    /* renamed from: i  reason: collision with root package name */
    public BazhuHeadView f14488i;
    public LinearLayout j;
    public TextView k;
    public TextView l;
    public ImageView m;
    public TextView n;
    public View.OnClickListener o;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CandidateInfoLayout f14489e;

        public a(CandidateInfoLayout candidateInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {candidateInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14489e = candidateInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d dVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (dVar = this.f14489e.f14492g) == null || dVar.l() == 0) {
                return;
            }
            long f2 = b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
            long l = this.f14489e.f14492g.l();
            if (!(this.f14489e.getContext() instanceof Activity) || this.f14489e.f14492g.f() == 2) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f14489e.getContext()).createNormalConfig(l, l == f2, false)));
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

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            BazhuHeadView bazhuHeadView = (BazhuHeadView) findViewById(R.id.user_avatar);
            this.f14488i = bazhuHeadView;
            if (bazhuHeadView.getHeadView() != null) {
                this.f14488i.getHeadView().setIsRound(true);
            }
            this.j = (LinearLayout) findViewById(R.id.user_name_and_active_status);
            this.k = (TextView) findViewById(R.id.user_name);
            this.l = (TextView) findViewById(R.id.vote_id);
            this.n = (TextView) findViewById(R.id.agree_post_reply_num);
            this.m = (ImageView) findViewById(R.id.grade);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f14487h = getContext();
            setClipChildren(false);
            setClipToPadding(false);
            setOrientation(0);
            setGravity(80);
            setMinimumHeight(l.g(getContext(), R.dimen.tbds90));
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            LayoutInflater.from(getContext()).inflate(R.layout.candidate_info_layout, (ViewGroup) this, true);
            a();
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0105, 1, i2);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0109, 1, i2);
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0109, 1, i2);
            d dVar = this.f14492g;
            if (dVar != null) {
                setGrade(dVar.d());
            }
        }
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i2, f fVar) {
        int i3;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, fVar) == null) {
            super.setData(i2, fVar);
            if (this.f14491f != null && this.f14492g != null && (i3 = this.f14490e) >= 0) {
                if (i3 == d.a.q0.x.e.a.f66848c) {
                    int g2 = l.g(this.f14487h, R.dimen.tbds191);
                    int g3 = l.g(this.f14487h, R.dimen.tbds157);
                    int g4 = l.g(this.f14487h, R.dimen.tbds6);
                    int g5 = l.g(this.f14487h, R.dimen.tbds24);
                    int g6 = l.g(this.f14487h, R.dimen.tbds30);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g3, g2);
                    layoutParams.setMargins(layoutParams.leftMargin - g4, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
                    this.f14488i.setLayoutParams(layoutParams);
                    this.f14488i.n(true);
                    this.f14488i.setBawuLogoView(R.drawable.pic_election_bazhu);
                    this.f14488i.setPendantView(R.drawable.icon_crown);
                    this.k.setTextSize(0, l.g(this.f14487h, R.dimen.tbfontsize46));
                    setGravity(16);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.setMargins(g6, g5, layoutParams2.rightMargin, g4);
                    this.f14488i.setLayoutParams(layoutParams);
                    this.j.setLayoutParams(layoutParams2);
                } else {
                    this.f14488i.n(false);
                }
                this.f14488i.k(this.f14492g.g());
                this.f14488i.setOnClickListener(this.o);
                this.k.setText(StringHelper.cutChineseAndEnglishWithSuffix(this.f14492g.e(), 14, StringHelper.STRING_MORE));
                setGrade(this.f14492g.d());
                if (this.f14492g.f() == 2) {
                    this.l.setVisibility(8);
                } else {
                    this.l.setVisibility(0);
                    if (this.f14492g.c() < 1000) {
                        String str2 = "0000" + this.f14492g.c();
                        str = str2.substring(str2.length() - 4, str2.length());
                    } else {
                        str = "" + this.f14492g.c();
                    }
                    this.l.setText("NO." + str);
                }
                this.n.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.agree_post_reply), StringHelper.numFormatOverWanWithNegative(this.f14492g.a()), StringHelper.numFormatOverWanWithNegative(this.f14492g.j()), StringHelper.numFormatOverWanWithNegative(this.f14492g.h())));
                return;
            }
            setVisibility(8);
        }
    }

    public void setGrade(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            SkinManager.setImageResource(this.m, BitmapHelper.getGradeResourceIdInEnterForum(i2));
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
        b();
    }
}

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
import b.a.e.e.m.b;
import b.a.e.e.p.l;
import b.a.r0.y.b.d;
import b.a.r0.y.b.f;
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
/* loaded from: classes9.dex */
public class CandidateInfoLayout extends CardBasicLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f47337e;

    /* renamed from: f  reason: collision with root package name */
    public BazhuHeadView f47338f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f47339g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f47340h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f47341i;
    public ImageView j;
    public TextView k;
    public View.OnClickListener l;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CandidateInfoLayout f47342e;

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
            this.f47342e = candidateInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d dVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (dVar = this.f47342e.mElectionData) == null || dVar.l() == 0) {
                return;
            }
            long g2 = b.g(TbadkCoreApplication.getCurrentAccount(), 0L);
            long l = this.f47342e.mElectionData.l();
            if (!(this.f47342e.getContext() instanceof Activity) || this.f47342e.mElectionData.f() == 2) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f47342e.getContext()).createNormalConfig(l, l == g2, false)));
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
            this.f47338f = bazhuHeadView;
            if (bazhuHeadView.getHeadView() != null) {
                this.f47338f.getHeadView().setIsRound(true);
            }
            this.f47339g = (LinearLayout) findViewById(R.id.user_name_and_active_status);
            this.f47340h = (TextView) findViewById(R.id.user_name);
            this.f47341i = (TextView) findViewById(R.id.vote_id);
            this.k = (TextView) findViewById(R.id.agree_post_reply_num);
            this.j = (ImageView) findViewById(R.id.grade);
        }
    }

    public void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f47337e = getContext();
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

    public void onSkinChange(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            SkinManager.setViewTextColor(this.f47340h, R.color.CAM_X0105, 1, i2);
            SkinManager.setViewTextColor(this.f47341i, R.color.CAM_X0109, 1, i2);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0109, 1, i2);
            d dVar = this.mElectionData;
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
            if (this.mData != null && this.mElectionData != null && (i3 = this.status) >= 0) {
                if (i3 == b.a.r0.y.e.a.f27222c) {
                    int g2 = l.g(this.f47337e, R.dimen.tbds191);
                    int g3 = l.g(this.f47337e, R.dimen.tbds157);
                    int g4 = l.g(this.f47337e, R.dimen.tbds6);
                    int g5 = l.g(this.f47337e, R.dimen.tbds24);
                    int g6 = l.g(this.f47337e, R.dimen.tbds30);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g3, g2);
                    layoutParams.setMargins(layoutParams.leftMargin - g4, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
                    this.f47338f.setLayoutParams(layoutParams);
                    this.f47338f.resizeView(true);
                    this.f47338f.setBawuLogoView(R.drawable.pic_election_bazhu);
                    this.f47338f.setPendantView(R.drawable.icon_crown);
                    this.f47340h.setTextSize(0, l.g(this.f47337e, R.dimen.tbfontsize46));
                    setGravity(16);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.setMargins(g6, g5, layoutParams2.rightMargin, g4);
                    this.f47338f.setLayoutParams(layoutParams);
                    this.f47339g.setLayoutParams(layoutParams2);
                } else {
                    this.f47338f.resizeView(false);
                }
                this.f47338f.startLoadOnlyHeadUrl(this.mElectionData.g());
                this.f47338f.setOnClickListener(this.l);
                this.f47340h.setText(StringHelper.cutChineseAndEnglishWithSuffix(this.mElectionData.e(), 14, "..."));
                setGrade(this.mElectionData.d());
                if (this.mElectionData.f() == 2) {
                    this.f47341i.setVisibility(8);
                } else {
                    this.f47341i.setVisibility(0);
                    if (this.mElectionData.c() < 1000) {
                        String str2 = "0000" + this.mElectionData.c();
                        str = str2.substring(str2.length() - 4, str2.length());
                    } else {
                        str = "" + this.mElectionData.c();
                    }
                    this.f47341i.setText("NO." + str);
                }
                this.k.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.agree_post_reply), StringHelper.numFormatOverWanWithNegative(this.mElectionData.a()), StringHelper.numFormatOverWanWithNegative(this.mElectionData.j()), StringHelper.numFormatOverWanWithNegative(this.mElectionData.h())));
                return;
            }
            setVisibility(8);
        }
    }

    public void setGrade(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            SkinManager.setImageResource(this.j, BitmapHelper.getGradeResourceIdInEnterForum(i2));
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
        this.l = new a(this);
        initUI();
    }
}

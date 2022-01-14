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
import c.a.t0.c0.b.d;
import c.a.t0.c0.b.f;
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
/* loaded from: classes12.dex */
public class CandidateInfoLayout extends CardBasicLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f42236e;

    /* renamed from: f  reason: collision with root package name */
    public BazhuHeadView f42237f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f42238g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f42239h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f42240i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f42241j;
    public TextView k;
    public View.OnClickListener l;

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CandidateInfoLayout f42242e;

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
            this.f42242e = candidateInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d dVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (dVar = this.f42242e.mElectionData) == null || dVar.l() == 0) {
                return;
            }
            long g2 = b.g(TbadkCoreApplication.getCurrentAccount(), 0L);
            long l = this.f42242e.mElectionData.l();
            if (!(this.f42242e.getContext() instanceof Activity) || this.f42242e.mElectionData.f() == 2) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f42242e.getContext()).createNormalConfig(l, l == g2, false)));
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
            this.f42237f = bazhuHeadView;
            if (bazhuHeadView.getHeadView() != null) {
                this.f42237f.getHeadView().setIsRound(true);
            }
            this.f42238g = (LinearLayout) findViewById(R.id.user_name_and_active_status);
            this.f42239h = (TextView) findViewById(R.id.user_name);
            this.f42240i = (TextView) findViewById(R.id.vote_id);
            this.k = (TextView) findViewById(R.id.agree_post_reply_num);
            this.f42241j = (ImageView) findViewById(R.id.grade);
        }
    }

    public void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f42236e = getContext();
            setClipChildren(false);
            setClipToPadding(false);
            setOrientation(0);
            setGravity(80);
            setMinimumHeight(n.f(getContext(), R.dimen.tbds90));
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            LayoutInflater.from(getContext()).inflate(R.layout.candidate_info_layout, (ViewGroup) this, true);
            a();
        }
    }

    public void onSkinChange(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            SkinManager.setViewTextColor(this.f42239h, R.color.CAM_X0105, 1, i2);
            SkinManager.setViewTextColor(this.f42240i, R.color.CAM_X0109, 1, i2);
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
                if (i3 == c.a.t0.c0.e.a.f15308c) {
                    int f2 = n.f(this.f42236e, R.dimen.tbds191);
                    int f3 = n.f(this.f42236e, R.dimen.tbds157);
                    int f4 = n.f(this.f42236e, R.dimen.tbds6);
                    int f5 = n.f(this.f42236e, R.dimen.tbds24);
                    int f6 = n.f(this.f42236e, R.dimen.tbds30);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(f3, f2);
                    layoutParams.setMargins(layoutParams.leftMargin - f4, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
                    this.f42237f.setLayoutParams(layoutParams);
                    this.f42237f.resizeView(true);
                    this.f42237f.setBawuLogoView(R.drawable.pic_election_bazhu);
                    this.f42237f.setPendantView(R.drawable.icon_crown);
                    this.f42239h.setTextSize(0, n.f(this.f42236e, R.dimen.tbfontsize46));
                    setGravity(16);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.setMargins(f6, f5, layoutParams2.rightMargin, f4);
                    this.f42237f.setLayoutParams(layoutParams);
                    this.f42238g.setLayoutParams(layoutParams2);
                } else {
                    this.f42237f.resizeView(false);
                }
                this.f42237f.startLoadOnlyHeadUrl(this.mElectionData.g());
                this.f42237f.setOnClickListener(this.l);
                this.f42239h.setText(StringHelper.cutChineseAndEnglishWithSuffix(this.mElectionData.e(), 14, "..."));
                setGrade(this.mElectionData.d());
                if (this.mElectionData.f() == 2) {
                    this.f42240i.setVisibility(8);
                } else {
                    this.f42240i.setVisibility(0);
                    if (this.mElectionData.c() < 1000) {
                        String str2 = "0000" + this.mElectionData.c();
                        str = str2.substring(str2.length() - 4, str2.length());
                    } else {
                        str = "" + this.mElectionData.c();
                    }
                    this.f42240i.setText("NO." + str);
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
            SkinManager.setImageResource(this.f42241j, BitmapHelper.getGradeResourceIdInEnterForum(i2));
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

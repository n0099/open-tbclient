package com.baidu.tieba.barselect.segment;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.t0.c0.b.f;
import com.baidu.adp.framework.MessageManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.data.CommitVoteReqMsg;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.view.TrapezoidButton;
import com.baidu.tieba.view.RoundAndShadowLinearLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class VoteAreaLayout extends CardBasicLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f42271e;

    /* renamed from: f  reason: collision with root package name */
    public RoundAndShadowLinearLayout f42272f;

    /* renamed from: g  reason: collision with root package name */
    public View f42273g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f42274h;

    /* renamed from: i  reason: collision with root package name */
    public TrapezoidButton f42275i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f42276j;

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f42277e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VoteAreaLayout f42278f;

        public a(VoteAreaLayout voteAreaLayout, f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {voteAreaLayout, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42278f = voteAreaLayout;
            this.f42277e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f fVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (this.f42278f.f42271e instanceof Activity) && ViewHelper.checkUpIsLogin(this.f42278f.f42271e)) {
                new StatisticItem(TbadkCoreStatisticKey.KEY_VOTE_BUTTON).eventStat();
                if (this.f42278f.mElectionData == null || (fVar = this.f42277e) == null || fVar.a() == null) {
                    return;
                }
                if (this.f42277e.a().a()) {
                    if (this.f42277e.c() == 0 || this.f42277e.g() == null) {
                        return;
                    }
                    CommitVoteReqMsg commitVoteReqMsg = new CommitVoteReqMsg(this.f42278f.mElectionData.l(), this.f42277e.c(), this.f42278f.mElectionData.k(), 1);
                    commitVoteReqMsg.setTag(this.f42277e.g());
                    MessageManager.getInstance().sendMessage(commitVoteReqMsg);
                    return;
                }
                n.M(TbadkCoreApplication.getInst(), R.string.has_not_other_ticket);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VoteAreaLayout(Context context) {
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
            RoundAndShadowLinearLayout roundAndShadowLinearLayout = (RoundAndShadowLinearLayout) findViewById(R.id.vote_area_container);
            this.f42272f = roundAndShadowLinearLayout;
            roundAndShadowLinearLayout.setRadius(n.f(this.f42271e, R.dimen.tbds8));
            this.f42274h = (TextView) findViewById(R.id.vote_num);
            this.f42275i = (TrapezoidButton) findViewById(R.id.vote_button);
            this.f42276j = (TextView) findViewById(R.id.vote_button_tv);
            this.f42273g = findViewById(R.id.button_container);
        }
    }

    public void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f42271e = getContext();
            setClipChildren(false);
            setClipToPadding(false);
            setOrientation(0);
            setGravity(16);
            setMinimumHeight(n.f(getContext(), R.dimen.tbds90));
            setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            LayoutInflater.from(getContext()).inflate(R.layout.vote_area_layout, (ViewGroup) this, true);
            b();
        }
    }

    public void onSkinChange(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            SkinManager.setViewTextColor(this.f42274h, R.color.CAM_X0303, 1, i2);
            SkinManager.setBackgroundColorWithAlpha(this.f42273g, R.color.CAM_X0303, 0.2f, i2);
            SkinManager.setViewTextColor(this.f42276j, R.color.CAM_X0101, 1, i2);
            SkinManager.setBackgroundResource(this.f42276j, R.drawable.bar_select_bg_gradient, i2);
        }
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i2, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, fVar) == null) {
            super.setData(i2, fVar);
            if (this.mData != null && this.mElectionData != null && this.status >= 0) {
                TextView textView = this.f42274h;
                textView.setText(StringHelper.numFormatOverWan(this.mElectionData.m()) + "票");
                this.f42276j.setOnClickListener(new a(this, fVar));
                if (this.mElectionData.n()) {
                    this.f42276j.setEnabled(false);
                    return;
                } else {
                    this.f42276j.setEnabled(true);
                    return;
                }
            }
            setVisibility(8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoteAreaLayout(Context context, AttributeSet attributeSet) {
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
        initUI();
    }
}

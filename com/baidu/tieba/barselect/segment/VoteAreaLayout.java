package com.baidu.tieba.barselect.segment;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
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
import d.a.c.e.p.l;
import d.a.s0.x.b.f;
/* loaded from: classes5.dex */
public class VoteAreaLayout extends CardBasicLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public Context f14409h;

    /* renamed from: i  reason: collision with root package name */
    public RoundAndShadowLinearLayout f14410i;
    public View j;
    public TextView k;
    public TrapezoidButton l;
    public TextView m;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f14411e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VoteAreaLayout f14412f;

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
            this.f14412f = voteAreaLayout;
            this.f14411e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f fVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (this.f14412f.f14409h instanceof Activity) && ViewHelper.checkUpIsLogin(this.f14412f.f14409h)) {
                new StatisticItem(TbadkCoreStatisticKey.KEY_VOTE_BUTTON).eventStat();
                if (this.f14412f.f14405g == null || (fVar = this.f14411e) == null || fVar.a() == null) {
                    return;
                }
                if (this.f14411e.a().a()) {
                    if (this.f14411e.c() == 0 || this.f14411e.g() == null) {
                        return;
                    }
                    CommitVoteReqMsg commitVoteReqMsg = new CommitVoteReqMsg(this.f14412f.f14405g.l(), this.f14411e.c(), this.f14412f.f14405g.k(), 1);
                    commitVoteReqMsg.setTag(this.f14411e.g());
                    MessageManager.getInstance().sendMessage(commitVoteReqMsg);
                    return;
                }
                l.L(TbadkCoreApplication.getInst(), R.string.has_not_other_ticket);
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
            this.f14410i = roundAndShadowLinearLayout;
            roundAndShadowLinearLayout.setRadius(l.g(this.f14409h, R.dimen.tbds8));
            this.k = (TextView) findViewById(R.id.vote_num);
            this.l = (TrapezoidButton) findViewById(R.id.vote_button);
            this.m = (TextView) findViewById(R.id.vote_button_tv);
            this.j = findViewById(R.id.button_container);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f14409h = getContext();
            setClipChildren(false);
            setClipToPadding(false);
            setOrientation(0);
            setGravity(16);
            setMinimumHeight(l.g(getContext(), R.dimen.tbds90));
            setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            LayoutInflater.from(getContext()).inflate(R.layout.vote_area_layout, (ViewGroup) this, true);
            b();
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0303, 1, i2);
            SkinManager.setBackgroundColorWithAlpha(this.j, R.color.CAM_X0303, 0.2f, i2);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0101, 1, i2);
            SkinManager.setBackgroundResource(this.m, R.drawable.bar_select_bg_gradient, i2);
        }
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i2, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, fVar) == null) {
            super.setData(i2, fVar);
            if (this.f14404f != null && this.f14405g != null && this.f14403e >= 0) {
                TextView textView = this.k;
                textView.setText(StringHelper.numFormatOverWan(this.f14405g.m()) + "票");
                this.m.setOnClickListener(new a(this, fVar));
                if (this.f14405g.n()) {
                    this.m.setEnabled(false);
                    return;
                } else {
                    this.m.setEnabled(true);
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
        c();
    }
}

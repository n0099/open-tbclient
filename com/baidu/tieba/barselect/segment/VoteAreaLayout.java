package com.baidu.tieba.barselect.segment;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.p0.e0.b.f;
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
/* loaded from: classes5.dex */
public class VoteAreaLayout extends CardBasicLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public Context f31579d;

    /* renamed from: e  reason: collision with root package name */
    public RoundAndShadowLinearLayout f31580e;

    /* renamed from: f  reason: collision with root package name */
    public View f31581f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f31582g;

    /* renamed from: h  reason: collision with root package name */
    public TrapezoidButton f31583h;
    public TextView i;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ VoteAreaLayout f31584b;

        public a(VoteAreaLayout voteAreaLayout, f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {voteAreaLayout, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31584b = voteAreaLayout;
            this.a = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f fVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (this.f31584b.f31579d instanceof Activity) && ViewHelper.checkUpIsLogin(this.f31584b.f31579d)) {
                new StatisticItem(TbadkCoreStatisticKey.KEY_VOTE_BUTTON).eventStat();
                if (this.f31584b.f31573c == null || (fVar = this.a) == null || fVar.a() == null) {
                    return;
                }
                if (this.a.a().a()) {
                    if (this.a.c() == 0 || this.a.g() == null) {
                        return;
                    }
                    CommitVoteReqMsg commitVoteReqMsg = new CommitVoteReqMsg(this.f31584b.f31573c.l(), this.a.c(), this.f31584b.f31573c.k(), 1);
                    commitVoteReqMsg.setTag(this.a.g());
                    MessageManager.getInstance().sendMessage(commitVoteReqMsg);
                    return;
                }
                n.M(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f0808);
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
            RoundAndShadowLinearLayout roundAndShadowLinearLayout = (RoundAndShadowLinearLayout) findViewById(R.id.obfuscated_res_0x7f092414);
            this.f31580e = roundAndShadowLinearLayout;
            roundAndShadowLinearLayout.setRadius(n.f(this.f31579d, R.dimen.tbds8));
            this.f31582g = (TextView) findViewById(R.id.obfuscated_res_0x7f092428);
            this.f31583h = (TrapezoidButton) findViewById(R.id.obfuscated_res_0x7f092416);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f092417);
            this.f31581f = findViewById(R.id.obfuscated_res_0x7f09045e);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f31579d = getContext();
            setClipChildren(false);
            setClipToPadding(false);
            setOrientation(0);
            setGravity(16);
            setMinimumHeight(n.f(getContext(), R.dimen.tbds90));
            setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d08b4, (ViewGroup) this, true);
            b();
        }
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            SkinManager.setViewTextColor(this.f31582g, R.color.CAM_X0303, 1, i);
            SkinManager.setBackgroundColorWithAlpha(this.f31581f, R.color.CAM_X0303, 0.2f, i);
            SkinManager.setViewTextColor(this.i, R.color.CAM_X0101, 1, i);
            SkinManager.setBackgroundResource(this.i, R.drawable.bar_select_bg_gradient, i);
        }
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, fVar) == null) {
            super.setData(i, fVar);
            if (this.f31572b != null && this.f31573c != null && this.a >= 0) {
                TextView textView = this.f31582g;
                textView.setText(StringHelper.numFormatOverWan(this.f31573c.m()) + "票");
                this.i.setOnClickListener(new a(this, fVar));
                if (this.f31573c.n()) {
                    this.i.setEnabled(false);
                    return;
                } else {
                    this.i.setEnabled(true);
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
        c();
    }
}

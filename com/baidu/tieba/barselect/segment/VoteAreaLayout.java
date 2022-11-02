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
import com.baidu.tieba.e26;
import com.baidu.tieba.view.RoundAndShadowLinearLayout;
import com.baidu.tieba.xi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class VoteAreaLayout extends CardBasicLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context d;
    public RoundAndShadowLinearLayout e;
    public View f;
    public TextView g;
    public TrapezoidButton h;
    public TextView i;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e26 a;
        public final /* synthetic */ VoteAreaLayout b;

        public a(VoteAreaLayout voteAreaLayout, e26 e26Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {voteAreaLayout, e26Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = voteAreaLayout;
            this.a = e26Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            e26 e26Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !(this.b.d instanceof Activity) || !ViewHelper.checkUpIsLogin(this.b.d)) {
                return;
            }
            new StatisticItem(TbadkCoreStatisticKey.KEY_VOTE_BUTTON).eventStat();
            if (this.b.c != null && (e26Var = this.a) != null && e26Var.a() != null) {
                if (this.a.a().b()) {
                    if (this.a.c() != 0 && this.a.g() != null) {
                        CommitVoteReqMsg commitVoteReqMsg = new CommitVoteReqMsg(this.b.c.l(), this.a.c(), this.b.c.k(), 1);
                        commitVoteReqMsg.setTag(this.a.g());
                        MessageManager.getInstance().sendMessage(commitVoteReqMsg);
                        return;
                    }
                    return;
                }
                xi.O(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f0854);
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

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            SkinManager.setViewTextColor(this.g, R.color.CAM_X0303, 1, i);
            SkinManager.setBackgroundColor(this.f, R.color.CAM_X0905, i);
            SkinManager.setViewTextColor(this.i, R.color.CAM_X0101, 1, i);
            SkinManager.setBackgroundResource(this.i, R.drawable.bar_select_bg_gradient, i);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            RoundAndShadowLinearLayout roundAndShadowLinearLayout = (RoundAndShadowLinearLayout) findViewById(R.id.obfuscated_res_0x7f092661);
            this.e = roundAndShadowLinearLayout;
            roundAndShadowLinearLayout.setRadius(xi.g(this.d, R.dimen.tbds8));
            this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f092675);
            this.h = (TrapezoidButton) findViewById(R.id.obfuscated_res_0x7f092663);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f092664);
            this.f = findViewById(R.id.obfuscated_res_0x7f090498);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.d = getContext();
            setClipChildren(false);
            setClipToPadding(false);
            setOrientation(0);
            setGravity(16);
            setMinimumHeight(xi.g(getContext(), R.dimen.tbds90));
            setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d091d, (ViewGroup) this, true);
            b();
        }
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, e26 e26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, e26Var) == null) {
            super.setData(i, e26Var);
            if (this.b != null && this.c != null && this.a >= 0) {
                TextView textView = this.g;
                textView.setText(StringHelper.numFormatOverWan(this.c.m()) + "票");
                this.i.setOnClickListener(new a(this, e26Var));
                if (this.c.n()) {
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
}

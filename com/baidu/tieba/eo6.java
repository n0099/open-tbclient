package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class eo6 extends do6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext r0;
    public TextView s0;
    public EntelechyUserLikeButton t0;
    public s05 u0;
    public int v0;
    public ThreadData w0;
    public CommonUserLikeButton.a x0;
    public View.OnClickListener y0;

    /* loaded from: classes4.dex */
    public class a implements CommonUserLikeButton.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eo6 a;

        public a(eo6 eo6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eo6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eo6Var;
        }

        @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeI(1048576, this, i) != null) {
                return;
            }
            this.a.h0(i);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eo6 a;

        public b(eo6 eo6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eo6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eo6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.w0 != null && this.a.w0.getAuthor() != null && !StringUtils.isNull(this.a.w0.getAuthor().getName_show()) && !StringUtils.isNull(this.a.w0.getAuthor().getUserId()) && this.a.w0.getForum_name() != null) {
                PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(this.a.r0.getPageActivity(), this.a.w0.getAuthor().getUserId(), this.a.w0.getAuthor().getName_show(), this.a.w0.getForum_name(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                if (this.a.w0.getThreadVideoInfo() != null) {
                    z = true;
                } else {
                    z = false;
                }
                personInfoActivityConfig.setIsVideoThread(z);
                personInfoActivityConfig.setVideoPersonFrom("frs");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public eo6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.v0 = 3;
        this.x0 = new a(this);
        this.y0 = new b(this);
        this.r0 = tbPageContext;
        TextView textView = new TextView(tbPageContext.getPageActivity());
        this.s0 = textView;
        textView.setIncludeFontPadding(false);
        this.s0.setTextSize(0, yi.g(tbPageContext.getPageActivity(), R.dimen.obfuscated_res_0x7f0701e8));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = yi.g(tbPageContext.getPageActivity(), R.dimen.obfuscated_res_0x7f0702e6);
        this.s0.setLayoutParams(layoutParams);
        this.s0.setOnClickListener(this.y0);
        this.q.addView(this.s0, 1);
        EntelechyUserLikeButton entelechyUserLikeButton = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.t0 = entelechyUserLikeButton;
        entelechyUserLikeButton.setFanNumCallBack(this.x0);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, yi.g(this.r0.getPageActivity(), R.dimen.obfuscated_res_0x7f0702dd));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, R.id.obfuscated_res_0x7f090d77);
        layoutParams2.rightMargin = yi.g(this.r0.getPageActivity(), R.dimen.obfuscated_res_0x7f070207);
        layoutParams2.topMargin = yi.g(this.r0.getPageActivity(), R.dimen.obfuscated_res_0x7f0701e8);
        this.t0.setLayoutParams(layoutParams2);
        ((ViewGroup) k()).addView(this.t0);
        s05 s05Var = new s05(tbPageContext, this.t0);
        this.u0 = s05Var;
        s05Var.m("1");
        this.u0.l(bdUniqueId);
    }

    @Override // com.baidu.tieba.do6, com.baidu.tieba.m36
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i) == null) {
            super.m(tbPageContext, i);
            if (this.v0 != i) {
                SkinManager.setViewTextColor(this.s0, (int) R.color.CAM_X0109);
                this.t0.g(i);
            }
            this.v0 = i;
        }
    }

    @Override // com.baidu.tieba.do6
    public void U(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdUniqueId) == null) {
            super.U(bdUniqueId);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.do6, com.baidu.tieba.m36
    /* renamed from: S */
    public void l(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) {
            super.l(threadData);
            if (threadData == null) {
                return;
            }
            this.w0 = threadData;
            if (threadData.getAuthor() != null) {
                this.u0.n(threadData.getAuthor());
                h0(threadData.getAuthor().getFansNum());
                if (!this.w0.isGodThread()) {
                    this.t0.setVisibility(8);
                } else if (this.w0.getAuthor().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.w0.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.t0.setVisibility(8);
                    return;
                } else if (this.w0.getAuthor().getGodUserData() != null && this.w0.getAuthor().getGodUserData().getIsLike()) {
                    if (this.w0.getAuthor().getGodUserData().getIsFromNetWork()) {
                        this.t0.setVisibility(8);
                    } else {
                        this.t0.setVisibility(0);
                        this.t0.d(true, 1);
                    }
                } else {
                    this.t0.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.r.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.t0.getLayoutParams();
            if (threadData.getSkinInfoData() != null) {
                layoutParams.topMargin = yi.g(this.r0.getPageActivity(), R.dimen.obfuscated_res_0x7f070224) + i;
            } else {
                layoutParams.topMargin = yi.g(this.r0.getPageActivity(), R.dimen.obfuscated_res_0x7f0701e8);
            }
        }
    }

    public final void h0(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) != null) || this.s0 == null) {
            return;
        }
        String string = this.r0.getResources().getString(R.string.obfuscated_res_0x7f0f061f);
        ThreadData threadData = this.w0;
        if (threadData != null && !StringUtils.isNull(threadData.getForum_name()) && this.w0.getForum_name().equals(this.a0)) {
            if (this.w0.isGodThread()) {
                String format = String.format(string, StringHelper.numberUniformFormat(i));
                this.s0.setVisibility(0);
                this.s0.setText(format);
                return;
            }
            this.s0.setVisibility(8);
            return;
        }
        this.s0.setText(this.r0.getResources().getString(R.string.obfuscated_res_0x7f0f04a6));
    }
}

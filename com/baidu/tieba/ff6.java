package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class ff6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NEGFeedBackView a;
    public TbPageContext b;
    public ViewGroup c;
    public BdUniqueId d;
    public NEGFeedBackView.b e;

    /* loaded from: classes5.dex */
    public class a implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void b(k35 k35Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k35Var, compoundButton, z) == null) {
            }
        }

        public a(ff6 ff6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ff6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void a(ArrayList<Integer> arrayList, String str, k35 k35Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(1048576, this, arrayList, str, k35Var) == null) && arrayList != null && k35Var != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append(arrayList.get(i) + ",");
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                if ("ala_frs_demo_hell_live_feed_back_type".equals(k35Var.getType())) {
                    TiebaStatic.log(new StatisticItem("c12803").param("tid", k35Var.f()));
                } else if ("ala_frs_stage_live_feed_back_type".equals(k35Var.getType())) {
                    TiebaStatic.log(new StatisticItem("c12807").param("tid", k35Var.f()));
                }
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void c(k35 k35Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, k35Var) != null) || k35Var == null) {
                return;
            }
            if ("ala_frs_demo_hell_live_feed_back_type".equals(k35Var.getType())) {
                TiebaStatic.log(new StatisticItem("c12802").param("tid", k35Var.f()));
            } else if ("ala_frs_stage_live_feed_back_type".equals(k35Var.getType())) {
                TiebaStatic.log(new StatisticItem("c12806").param("tid", k35Var.f()));
            }
        }
    }

    public ff6(TbPageContext tbPageContext, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new a(this);
        this.b = tbPageContext;
        this.c = viewGroup;
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (View) invokeV.objValue;
    }

    public void c() {
        NEGFeedBackView nEGFeedBackView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (nEGFeedBackView = this.a) != null) {
            nEGFeedBackView.u();
        }
    }

    public void b(ThreadData threadData, String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData, str) == null) && threadData != null && threadData.getThreadAlaInfo() != null && this.b != null && this.c != null) {
            int i = 0;
            if (threadData.getAuthor() != null && threadData.getAuthor().getUserId() != null && threadData.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                z = true;
            } else {
                z = false;
            }
            if (TbadkCoreApplication.isLogin() && threadData.getThreadAlaInfo().dislikeInfo != null && !z && threadData.getThreadAlaInfo().dislikeInfo.size() > 0) {
                if (this.a == null) {
                    NEGFeedBackView nEGFeedBackView = new NEGFeedBackView(this.b);
                    this.a = nEGFeedBackView;
                    nEGFeedBackView.setUniqueId(this.d);
                    this.a.setId(R.id.negative_feedback_view);
                    this.a.setDefaultReasonArray(new String[]{this.b.getString(R.string.bad_quality), "", ""});
                    this.a.setEventCallback(this.e);
                    this.a.r(this.c, xi.g(this.b.getPageActivity(), R.dimen.tbds120), xi.g(this.b.getPageActivity(), R.dimen.tbds20));
                    this.a.u();
                }
                if (this.a.getVisibility() != 0) {
                    this.a.setVisibility(0);
                }
                k35 k35Var = new k35();
                k35Var.o(threadData.getTid());
                k35Var.k(threadData.getFid());
                k35Var.n(threadData.getNid());
                k35Var.r(str);
                k35Var.j(threadData.getThreadAlaInfo().dislikeInfo);
                this.a.setData(k35Var);
            } else {
                NEGFeedBackView nEGFeedBackView2 = this.a;
                if (nEGFeedBackView2 != null && nEGFeedBackView2.getVisibility() != 8) {
                    this.a.setVisibility(8);
                }
                i = xi.g(this.b.getPageActivity(), R.dimen.obfuscated_res_0x7f070207);
            }
            if (this.c.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.c.getLayoutParams();
                layoutParams.rightMargin = i;
                this.c.setLayoutParams(layoutParams);
            }
            if (this.c.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.c.setLayoutParams(layoutParams2);
            }
            NEGFeedBackView nEGFeedBackView3 = this.a;
            if (nEGFeedBackView3 != null) {
                nEGFeedBackView3.s();
            }
        }
    }

    public void d(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) {
            this.d = bdUniqueId;
        }
    }
}

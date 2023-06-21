package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThirdStatisticHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class a18 extends jn<m18, CardViewHolder<c>> {
    public static /* synthetic */ Interceptable $ic;
    public static final int b;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* loaded from: classes4.dex */
    public class a implements go {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;
        public final /* synthetic */ a18 b;

        /* renamed from: com.baidu.tieba.a18$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0232a implements ThirdStatisticHelper.ThirdStatisticCallback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0232a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tbadk.core.util.ThirdStatisticHelper.ThirdStatisticCallback
            public void onFailed(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    new StatisticItem("c12885").addParam("obj_param1", 1).eventStat();
                }
            }

            @Override // com.baidu.tbadk.core.util.ThirdStatisticHelper.ThirdStatisticCallback
            public void onSuccess(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                    new StatisticItem("c12885").addParam("obj_param1", 0).eventStat();
                }
            }
        }

        public a(a18 a18Var, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a18Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a18Var;
            this.a = cVar;
        }

        @Override // com.baidu.tieba.go
        public void b(View view2, wn wnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            c cVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, wnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && view2 != null && (cVar = this.a) != null && !vi.isEmpty(cVar.l)) {
                if (ListUtils.isEmpty(this.a.m)) {
                    new StatisticItem("c12885").addParam("obj_param1", 2).eventStat();
                } else {
                    for (String str : this.a.m) {
                        ThirdStatisticHelper.sendReq(str, new C0232a(this));
                    }
                }
                UrlManager.getInstance().dealOneLink(this.b.a, new String[]{this.a.l});
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ThirdStatisticHelper.ThirdStatisticCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(a18 a18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.core.util.ThirdStatisticHelper.ThirdStatisticCallback
        public void onFailed(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                new StatisticItem("c12884").addParam("obj_param1", 1).eventStat();
            }
        }

        @Override // com.baidu.tbadk.core.util.ThirdStatisticHelper.ThirdStatisticCallback
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                new StatisticItem("c12884").addParam("obj_param1", 0).eventStat();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends nn6<m18> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView i;
        public ImageView j;
        public View k;
        public String l;
        public List<String> m;

        @Override // com.baidu.tieba.nn6
        public int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d01d4 : invokeV.intValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(TbPageContext tbPageContext, ViewGroup viewGroup) {
            super(tbPageContext, viewGroup);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((TbPageContext) objArr2[0], (ViewGroup) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            TbImageView tbImageView = (TbImageView) h().findViewById(R.id.obfuscated_res_0x7f091d70);
            this.i = tbImageView;
            tbImageView.setAutoChangeStyle(true);
            this.i.setRadiusById(R.string.J_X06);
            this.i.setConrers(15);
            this.i.setScaleType(ImageView.ScaleType.FIT_XY);
            this.i.setPlaceHolder(2);
            this.k = h().findViewById(R.id.obfuscated_res_0x7f090726);
            this.j = (ImageView) h().findViewById(R.id.obfuscated_res_0x7f090717);
            this.k.setOnClickListener(this);
            h().setOnClickListener(this);
            WebPManager.setPureDrawable(this.j, R.drawable.icon_pure_card_close22, R.color.CAM_X0101, null);
            j(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, view2) == null) && view2 == this.k) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016569));
            }
        }

        @Override // com.baidu.tieba.nn6
        public void j(TbPageContext tbPageContext, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
                SkinManager.setBackgroundColor(h(), R.color.transparent);
                WebPManager.setPureDrawable(this.j, R.drawable.icon_pure_card_close22, R.color.CAM_X0101, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nn6
        /* renamed from: t */
        public void i(m18 m18Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, m18Var) == null) {
                if (m18Var != null) {
                    u(m18Var.c, m18Var.b);
                    this.i.setPlaceHolder(2);
                    this.i.N(m18Var.d, 10, false);
                    this.l = m18Var.e;
                    this.m = m18Var.g;
                }
                j(g(), TbadkCoreApplication.getInst().getSkinType());
            }
        }

        public final void u(int i, int i2) {
            int i3;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeII(1048581, this, i, i2) != null) || this.i == null) {
                return;
            }
            Context context = TbadkCoreApplication.getInst().getContext();
            ViewGroup.LayoutParams layoutParams = this.i.getLayoutParams();
            if (context != null && layoutParams != null) {
                int i4 = a18.b;
                if (i > 0 && i2 > 0) {
                    i3 = (int) (((i4 * 1.0f) * i2) / i);
                } else {
                    i3 = (int) (((i4 * 1.0f) * 182.0f) / 988.0f);
                }
                layoutParams.width = -1;
                layoutParams.height = i3;
                this.i.setLayoutParams(layoutParams);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947562433, "Lcom/baidu/tieba/a18;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947562433, "Lcom/baidu/tieba/a18;");
                return;
            }
        }
        b = wi.l(TbadkCoreApplication.getInst()) - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) * 2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a18(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jn
    /* renamed from: u */
    public CardViewHolder<c> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            c cVar = new c(this.a, viewGroup);
            cVar.h().setPadding(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003), 0, 0);
            setOnAdapterItemClickListener(new a(this, cVar));
            return new CardViewHolder<>(cVar);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jn
    /* renamed from: x */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, m18 m18Var, CardViewHolder<c> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, m18Var, cardViewHolder})) == null) {
            if (m18Var != null && cardViewHolder != null && cardViewHolder.a() != null) {
                if (ListUtils.isEmpty(m18Var.f)) {
                    new StatisticItem("c12884").addParam("obj_param1", 2).eventStat();
                } else {
                    for (String str : m18Var.f) {
                        ThirdStatisticHelper.sendReq(str, new b(this));
                    }
                }
                cardViewHolder.a().i(m18Var);
                return cardViewHolder.a().h();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}

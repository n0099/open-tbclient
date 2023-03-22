package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class i56 extends me6<n26> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int i;
    public TbPageContext<?> j;
    public c k;
    public m56 l;
    public ThreadData m;
    public int n;
    public String o;
    public boolean p;
    public View.OnClickListener q;
    public View.OnClickListener r;

    @Override // com.baidu.tieba.me6
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? R.layout.obfuscated_res_0x7f0d0111 : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i56 a;

        public a(i56 i56Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i56Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i56Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    hi.N(this.a.j.getPageActivity(), this.a.j.getPageActivity().getString(R.string.no_network_guide));
                } else if (this.a.m != null && this.a.m.getThreadAlaInfo() != null && this.a.l != null) {
                    this.a.l.a(this.a.n, this.a.o, this.a.m);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i56 a;

        public b(i56 i56Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i56Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i56Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.m != null && this.a.m.getAuthor() != null && !StringUtils.isNull(this.a.m.getAuthor().getUserId())) {
                long g = gg.g(this.a.m.getAuthor().getUserId(), 0L);
                if (g == gg.g(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                    z = true;
                } else {
                    z = false;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.a.j.getPageActivity()).createNormalConfig(g, z, this.a.m.getAuthor().isBigV())));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public TbImageView b;
        public TextView c;
        public TextView d;
        public RelativeLayout e;
        public ClickableHeaderImageView f;
        public TextView g;
        public TextView h;
        public TextView i;

        public c(i56 i56Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i56Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view2;
            this.b = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f09101d);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092540);
            this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09253f);
            this.e = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091df8);
            this.f = (ClickableHeaderImageView) view2.findViewById(R.id.obfuscated_res_0x7f09101e);
            this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09254d);
            this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092549);
            this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092546);
            view2.setOnClickListener(i56Var.q);
            this.b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.b.setDrawerType(0);
            this.f.setIsRound(true);
            this.f.setDrawBorder(true);
            this.f.setBorderColor(i56Var.j.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.f.setBorderWidth(i56Var.j.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070198));
            this.f.setIsGod(false);
            this.f.setIsBigV(false);
            this.f.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.e.getLayoutParams();
            int l = (hi.l(view2.getContext()) - view2.getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070224)) / 2;
            layoutParams.width = l;
            layoutParams.height = (l * 9) / 16;
            this.e.setLayoutParams(layoutParams);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i56(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = 3;
        this.p = false;
        this.q = new a(this);
        this.r = new b(this);
        this.j = tbPageContext;
        this.k = new c(this, h());
        this.p = z;
    }

    public void A(m56 m56Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, m56Var) == null) {
            this.l = m56Var;
        }
    }

    @Override // com.baidu.tieba.me6
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) && this.i != i) {
            SkinManager.setBackgroundResource(this.k.e, R.drawable.addresslist_item_bg);
            SkinManager.setViewTextColor(this.k.d, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.k.g, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.k.h, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.k.i, (int) R.color.CAM_X0109);
            this.i = i;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.me6
    /* renamed from: z */
    public void l(n26 n26Var) {
        ThreadData threadData;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, n26Var) == null) {
            if (n26Var != null && (threadData = n26Var.d) != null && threadData.getThreadAlaInfo() != null) {
                h().setVisibility(0);
                this.m = n26Var.d;
                this.n = n26Var.a;
                if (!TextUtils.isEmpty(n26Var.c)) {
                    str = n26Var.c;
                } else {
                    str = n26Var.b;
                }
                this.o = str;
                this.k.b.M(this.m.getThreadAlaInfo().cover, 10, false);
                this.k.d.setText(this.j.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f12d1, StringHelper.numberUniformFormatExtra(this.m.getThreadAlaInfo().audience_count)));
                this.k.f.setData(this.m, false);
                this.k.h.setText(this.m.getTitle());
                if (this.m.getAuthor() != null) {
                    String name_show = this.m.getAuthor().getName_show();
                    if (dq5.f(name_show) > 10) {
                        name_show = dq5.n(name_show, 10) + StringHelper.STRING_MORE;
                    }
                    this.k.g.setText(name_show);
                }
                String str2 = this.m.getThreadAlaInfo().label_name;
                if (this.p && !StringUtils.isNull(str2)) {
                    this.k.c.setText(str2);
                    this.k.c.setVisibility(0);
                } else {
                    this.k.c.setVisibility(8);
                }
                if (n26Var.e) {
                    this.k.i.setText(this.j.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f12d0, StringHelper.numberUniformFormatExtra((long) (this.m.getThreadAlaInfo().distance / 1000.0d))));
                    this.k.i.setVisibility(0);
                } else {
                    this.k.i.setVisibility(8);
                }
                this.k.g.setOnClickListener(this.r);
                m(this.j, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            h().setVisibility(4);
        }
    }
}

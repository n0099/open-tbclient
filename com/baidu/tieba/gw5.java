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
public class gw5 extends i16<mt5> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int i;
    public TbPageContext<?> j;
    public c k;
    public kw5 l;
    public ThreadData m;
    public int n;
    public String o;
    public boolean p;
    public View.OnClickListener q;
    public View.OnClickListener r;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gw5 a;

        public a(gw5 gw5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gw5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    if (this.a.m == null || this.a.m.getThreadAlaInfo() == null || this.a.l == null) {
                        return;
                    }
                    this.a.l.a(this.a.n, this.a.o, this.a.m);
                    return;
                }
                ej.K(this.a.j.getPageActivity(), this.a.j.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0c92));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gw5 a;

        public b(gw5 gw5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gw5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.m == null || this.a.m.getAuthor() == null || StringUtils.isNull(this.a.m.getAuthor().getUserId())) {
                return;
            }
            long g = dh.g(this.a.m.getAuthor().getUserId(), 0L);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.a.j.getPageActivity()).createNormalConfig(g, g == dh.g(TbadkCoreApplication.getCurrentAccount(), 0L), this.a.m.getAuthor().isBigV())));
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

        public c(gw5 gw5Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw5Var, view2};
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
            this.b = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090ebf);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092353);
            this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092352);
            this.e = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091c4d);
            this.f = (ClickableHeaderImageView) view2.findViewById(R.id.obfuscated_res_0x7f090ec0);
            this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09235f);
            this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09235c);
            this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092359);
            view2.setOnClickListener(gw5Var.q);
            this.b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.b.setDrawerType(0);
            this.f.setIsRound(true);
            this.f.setDrawBorder(true);
            this.f.setBorderColor(gw5Var.j.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.f.setBorderWidth(gw5Var.j.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070198));
            this.f.setIsGod(false);
            this.f.setIsBigV(false);
            this.f.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.e.getLayoutParams();
            int k = (ej.k(view2.getContext()) - view2.getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070224)) / 2;
            layoutParams.width = k;
            layoutParams.height = (k * 9) / 16;
            this.e.setLayoutParams(layoutParams);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gw5(TbPageContext<?> tbPageContext, boolean z) {
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

    @Override // com.baidu.tieba.i16
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d010d : invokeV.intValue;
    }

    @Override // com.baidu.tieba.i16
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) || this.i == i) {
            return;
        }
        SkinManager.setBackgroundResource(this.k.e, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.k.d, (int) R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.k.g, (int) R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.k.h, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.k.i, (int) R.color.CAM_X0109);
        this.i = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.i16
    /* renamed from: x */
    public void i(mt5 mt5Var) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, mt5Var) == null) {
            if (mt5Var != null && (threadData = mt5Var.d) != null && threadData.getThreadAlaInfo() != null) {
                h().setVisibility(0);
                this.m = mt5Var.d;
                this.n = mt5Var.a;
                this.o = !TextUtils.isEmpty(mt5Var.c) ? mt5Var.c : mt5Var.b;
                this.k.b.K(this.m.getThreadAlaInfo().cover, 10, false);
                this.k.d.setText(this.j.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f11fc, StringHelper.numberUniformFormatExtra(this.m.getThreadAlaInfo().audience_count)));
                this.k.f.setData(this.m, false);
                this.k.h.setText(this.m.getTitle());
                if (this.m.getAuthor() != null) {
                    String name_show = this.m.getAuthor().getName_show();
                    if (ji5.d(name_show) > 10) {
                        name_show = ji5.n(name_show, 10) + StringHelper.STRING_MORE;
                    }
                    this.k.g.setText(name_show);
                }
                String str = this.m.getThreadAlaInfo().label_name;
                if (this.p && !StringUtils.isNull(str)) {
                    this.k.c.setText(str);
                    this.k.c.setVisibility(0);
                } else {
                    this.k.c.setVisibility(8);
                }
                if (mt5Var.e) {
                    this.k.i.setText(this.j.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f11fb, StringHelper.numberUniformFormatExtra((long) (this.m.getThreadAlaInfo().distance / 1000.0d))));
                    this.k.i.setVisibility(0);
                } else {
                    this.k.i.setVisibility(8);
                }
                this.k.g.setOnClickListener(this.r);
                j(this.j, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            h().setVisibility(4);
        }
    }

    public void y(kw5 kw5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, kw5Var) == null) {
            this.l = kw5Var;
        }
    }
}

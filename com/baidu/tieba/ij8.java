package com.baidu.tieba;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ij8 extends a86<fi8> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public ClickableHeaderImageView m;
    public ClickableHeaderImageView n;
    public ClickableHeaderImageView o;
    public TextView p;
    public View q;
    public int r;
    public TbPageContext<?> s;
    public View.OnClickListener t;
    public boolean u;

    @Override // com.baidu.tieba.a86
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d0739 : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ij8 a;

        public a(ij8 ij8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ij8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ij8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || view2 == null) {
                return;
            }
            if (!this.a.u) {
                TiebaStatic.log(new StatisticItem("c11595"));
            }
            if (view2.getTag() instanceof UserData) {
                UserData userData = (UserData) view2.getTag();
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.s.getPageActivity(), userData.getUserId(), userData.getUserName(), null, AddFriendActivityConfig.TYPE_FOCUS)));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ij8(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
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
        this.r = 3;
        this.s = tbPageContext;
        View h = h();
        t();
        this.q = h.findViewById(R.id.bottom_divider);
        this.j = (TextView) h.findViewById(R.id.month_num);
        this.i = (TextView) h.findViewById(R.id.day_num);
        this.k = (TextView) h.findViewById(R.id.obfuscated_res_0x7f090ee3);
        this.l = (TextView) h.findViewById(R.id.obfuscated_res_0x7f0902ea);
        ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) h.findViewById(R.id.obfuscated_res_0x7f090dc9);
        this.m = clickableHeaderImageView;
        clickableHeaderImageView.setRadius(zi.g(this.s.getPageActivity(), R.dimen.obfuscated_res_0x7f07019a));
        this.m.setAutoChangeStyle(true);
        this.m.setOnClickListener(this.t);
        ClickableHeaderImageView clickableHeaderImageView2 = (ClickableHeaderImageView) h.findViewById(R.id.obfuscated_res_0x7f090dca);
        this.n = clickableHeaderImageView2;
        clickableHeaderImageView2.setRadius(zi.g(this.s.getPageActivity(), R.dimen.obfuscated_res_0x7f07019a));
        this.n.setAutoChangeStyle(true);
        this.n.setOnClickListener(this.t);
        ClickableHeaderImageView clickableHeaderImageView3 = (ClickableHeaderImageView) h.findViewById(R.id.obfuscated_res_0x7f090dcb);
        this.o = clickableHeaderImageView3;
        clickableHeaderImageView3.setRadius(zi.g(this.s.getPageActivity(), R.dimen.obfuscated_res_0x7f07019a));
        this.o.setAutoChangeStyle(true);
        this.o.setOnClickListener(this.t);
        this.p = (TextView) h.findViewById(R.id.obfuscated_res_0x7f090971);
    }

    @Override // com.baidu.tieba.a86
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            if (this.r != i) {
                SkinManager.setBackgroundResource(h(), R.drawable.home_thread_card_item_bg);
                SkinManager.setBackgroundColor(this.q, R.color.CAM_X0204);
                SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0106);
                SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0106);
                SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0106);
                SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0106);
                SkinManager.setViewTextColor(this.p, (int) R.color.CAM_X0108);
            }
            this.r = i;
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.t = new a(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.a86
    /* renamed from: u */
    public void i(fi8 fi8Var) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fi8Var) == null) {
            if (fi8Var == null) {
                if (h() != null) {
                    h().setVisibility(8);
                    return;
                }
                return;
            }
            if (h() != null) {
                h().setVisibility(0);
            }
            this.u = fi8Var.a;
            this.i.setText(fi8Var.d);
            this.j.setText(fi8Var.c);
            TextView textView = this.i;
            int i2 = 4;
            if (fi8Var.b) {
                i = 0;
            } else {
                i = 4;
            }
            textView.setVisibility(i);
            TextView textView2 = this.j;
            if (fi8Var.b) {
                i2 = 0;
            }
            textView2.setVisibility(i2);
            if (fi8Var.a) {
                this.k.setText(this.s.getString(R.string.obfuscated_res_0x7f0f0b30));
            } else {
                this.k.setText(StringHelper.getUserDescByGender(fi8Var.e));
            }
            int count = ListUtils.getCount(fi8Var.f);
            if (count > 3) {
                this.p.setVisibility(0);
                this.p.setText(String.format(this.s.getString(R.string.obfuscated_res_0x7f0f02c2), Integer.valueOf(count)));
            } else {
                this.p.setVisibility(8);
            }
            if (count >= 3) {
                this.o.setVisibility(0);
                this.o.setTag(fi8Var.f.get(2));
                if (fi8Var.f.get(2).getGodUserData() != null && fi8Var.f.get(2).getGodUserData().getType() == 2) {
                    this.o.setIsGod(true);
                } else {
                    this.o.setIsGod(false);
                }
                this.o.K(fi8Var.f.get(2).getPortrait(), 12, false);
            } else {
                this.o.setVisibility(8);
            }
            if (count >= 2) {
                this.n.setVisibility(0);
                this.n.setTag(fi8Var.f.get(1));
                if (fi8Var.f.get(1).getGodUserData() != null && fi8Var.f.get(1).getGodUserData().getType() == 2) {
                    this.n.setIsGod(true);
                } else {
                    this.n.setIsGod(false);
                }
                this.n.K(fi8Var.f.get(1).getPortrait(), 12, false);
            } else {
                this.n.setVisibility(8);
            }
            if (count >= 1) {
                this.m.setVisibility(0);
                this.m.setTag(fi8Var.f.get(0));
                if (fi8Var.f.get(0).getGodUserData() != null && fi8Var.f.get(0).getGodUserData().getType() == 2) {
                    this.m.setIsGod(true);
                } else {
                    this.m.setIsGod(false);
                }
                this.m.K(fi8Var.f.get(0).getPortrait(), 12, false);
            } else {
                this.m.setVisibility(8);
            }
            j(this.s, TbadkCoreApplication.getInst().getSkinType());
        }
    }
}

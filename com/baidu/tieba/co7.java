package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.VideoRecommentPlayActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewCommonUtil;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.imMessageCenter.mention.base.MessageCardBottomView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.NewFloorInfo;
/* loaded from: classes4.dex */
public class co7 extends a86<xn7> {
    public static /* synthetic */ Interceptable $ic;
    public static el5<String> C;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public OriginalThreadCardView.b B;
    public HeadImageView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public OriginalThreadCardView o;
    public LinearLayout p;
    public TextView q;
    public MessageCardBottomView r;
    public View s;
    public TbPageContext t;
    public int u;
    public xn7 v;
    public String w;
    public View x;
    public List<NewFloorInfo> y;
    public int z;

    @Override // com.baidu.tieba.a86
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d01b7 : invokeV.intValue;
    }

    /* loaded from: classes4.dex */
    public class a implements OriginalThreadCardView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ co7 a;

        public a(co7 co7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {co7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = co7Var;
        }

        @Override // com.baidu.tieba.card.OriginalThreadCardView.b
        public void a(OriginalThreadInfo originalThreadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, originalThreadInfo) == null) {
                go7.a(this.a.v, 13);
                if (this.a.e() != null) {
                    z86<xn7> e = this.a.e();
                    co7 co7Var = this.a;
                    e.a(co7Var.o, co7Var.v);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947681566, "Lcom/baidu/tieba/co7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947681566, "Lcom/baidu/tieba/co7;");
                return;
            }
        }
        C = new el5<>();
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return VideoRecommentPlayActivityConfig.FROM_AT_PAGE.equals(this.w);
        }
        return invokeV.booleanValue;
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE.equals(this.w);
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public co7(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewGroup};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (ViewGroup) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.u = 3;
        this.A = null;
        this.B = new a(this);
        this.t = tbPageContext;
        t();
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.w = str;
        }
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048586, this, z) == null) && this.n != null && u()) {
            if (z) {
                this.n.setMaxLines(5);
            } else {
                this.n.setMaxLines(2);
            }
        }
    }

    @Override // com.baidu.tieba.a86
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) && this.u != i) {
            this.u = i;
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0105);
            OriginalThreadCardView originalThreadCardView = this.o;
            if (originalThreadCardView != null) {
                if (this.z == 3) {
                    originalThreadCardView.t(R.color.CAM_X0201, R.color.CAM_X0107, R.color.CAM_X0107);
                } else {
                    originalThreadCardView.t(R.color.CAM_X0204, R.color.CAM_X0107, R.color.CAM_X0107);
                }
            }
            MessageCardBottomView messageCardBottomView = this.r;
            if (messageCardBottomView != null) {
                messageCardBottomView.h();
            }
            SkinManager.setBackgroundResource(this.s, R.drawable.icon_news_red_dot);
            cx4 d = cx4.d(this.k);
            d.n(R.string.J_X04);
            d.v(R.color.CAM_X0108);
            d.A(R.string.F_X01);
            d.f(R.color.CAM_X0204);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        xn7 xn7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view2) == null) && (xn7Var = this.v) != null && this.t != null) {
            this.y = xn7Var.m();
            if (view2 != this.i && view2 != this.j) {
                if (view2 == this.q) {
                    go7.a(this.v, 12);
                } else if (view2 == this.r.getReplyContainer()) {
                    go7.a(this.v, 15);
                }
            } else if (this.v.v() == null) {
                return;
            } else {
                go7.a(this.v, 14);
                String userId = this.v.v().getUserId();
                String userName = this.v.v().getUserName();
                if (userId != null && userId.length() > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.t.getContext(), userId, userName)));
                }
            }
            if (e() != null) {
                e().a(view2, this.v);
            }
        }
    }

    public final void s(@NonNull View view2, @NonNull xn7 xn7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, view2, xn7Var) == null) {
            if (StringHelper.equals(C.a(), xn7Var.q())) {
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0313);
            } else {
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0205);
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            View h = h();
            this.x = h;
            this.i = (HeadImageView) h.findViewById(R.id.obfuscated_res_0x7f091a7e);
            this.j = (TextView) this.x.findViewById(R.id.user_name);
            this.k = (TextView) this.x.findViewById(R.id.obfuscated_res_0x7f0909d3);
            this.l = (TextView) this.x.findViewById(R.id.obfuscated_res_0x7f091b04);
            this.m = (TextView) this.x.findViewById(R.id.obfuscated_res_0x7f0922ca);
            this.n = (TextView) this.x.findViewById(R.id.obfuscated_res_0x7f090570);
            this.o = (OriginalThreadCardView) this.x.findViewById(R.id.original_thread_view);
            this.r = (MessageCardBottomView) this.x.findViewById(R.id.obfuscated_res_0x7f09056c);
            this.s = this.x.findViewById(R.id.new_message);
            this.p = (LinearLayout) this.x.findViewById(R.id.obfuscated_res_0x7f09173b);
            this.q = (TextView) this.x.findViewById(R.id.obfuscated_res_0x7f090571);
            ViewCommonUtil.setViewPadding(this.o, zi.g(getContext(), R.dimen.M_W_X004), zi.g(getContext(), R.dimen.M_H_X003), zi.g(getContext(), R.dimen.M_W_X004), zi.g(getContext(), R.dimen.M_H_X003));
            this.o.setUsePlaceHolder(false);
            this.i.setOnClickListener(this);
            this.j.setOnClickListener(this);
            this.r.getReplyContainer().setOnClickListener(this);
            this.q.setOnClickListener(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.a86
    /* renamed from: w */
    public void i(xn7 xn7Var) {
        boolean z;
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, xn7Var) == null) && xn7Var != null && xn7Var.v() != null) {
            this.v = xn7Var;
            MetaData v = xn7Var.v();
            this.i.setVisibility(0);
            boolean z2 = true;
            this.i.setPlaceHolder(1);
            this.i.setIsRound(true);
            UtilHelper.showHeadImageViewBigV(this.i, v, 0);
            this.i.setTag(null);
            this.i.setPageId(this.t.getUniqueId());
            this.i.K(this.v.v().getAvater(), 12, false);
            this.j.setText(StringHelper.cutChineseAndEnglishWithSuffix(UtilHelper.getUserName(v), 14, StringHelper.STRING_MORE));
            if (this.v.v().getIsMyFans() == 1) {
                this.k.setVisibility(0);
            } else {
                this.k.setVisibility(8);
            }
            if (this.v.getCardType() != 2 && this.v.getCardType() != 3) {
                if (this.v.getCardType() == 1) {
                    this.l.setVisibility(0);
                    if (u()) {
                        this.l.setText(getContext().getString(R.string.obfuscated_res_0x7f0f02b9));
                    } else if (v()) {
                        if (this.v.D()) {
                            this.l.setText(getContext().getString(R.string.obfuscated_res_0x7f0f1074));
                        } else {
                            this.l.setText(getContext().getString(R.string.obfuscated_res_0x7f0f1076));
                        }
                    }
                } else {
                    this.l.setVisibility(8);
                }
            } else {
                this.l.setVisibility(0);
                if (u()) {
                    this.l.setText(getContext().getString(R.string.obfuscated_res_0x7f0f02b8));
                } else if (v()) {
                    if (this.v.D()) {
                        this.l.setText(getContext().getString(R.string.obfuscated_res_0x7f0f1075));
                    } else {
                        this.l.setText(getContext().getString(R.string.obfuscated_res_0x7f0f1077));
                    }
                }
            }
            this.m.setText(StringHelper.getFormatTime(this.v.getTime()));
            if (this.v.m() != null) {
                List<NewFloorInfo> m = this.v.m();
                this.y = m;
                if (m.size() <= 2 && this.n != null) {
                    if (this.v.m().size() > 1 && this.y.get(1) != null) {
                        this.n.setVisibility(0);
                        this.n.setOnTouchListener(new r99(mo5.G(this.y.get(1).content)));
                        this.n.setText(mo5.G(this.y.get(1).content));
                        this.z = 2;
                    } else if (this.v.m().size() == 1) {
                        this.z = 1;
                        this.n.setVisibility(8);
                    } else if (this.v.m().size() == 0) {
                        this.z = 1;
                        this.n.setVisibility(8);
                        this.q.setVisibility(8);
                        cx4 d = cx4.d(this.p);
                        d.n(R.string.J_X05);
                        d.f(R.color.CAM_X0201);
                        cx4 d2 = cx4.d(this.o);
                        d2.n(R.string.J_X05);
                        d2.f(R.color.CAM_X0204);
                        ViewCommonUtil.setViewMargin(this.p, 0, zi.g(getContext(), R.dimen.M_H_X004), 0, zi.g(getContext(), R.dimen.M_H_X005));
                        this.p.setPadding(0, 0, 0, 0);
                        ViewCommonUtil.setViewMargin(this.o, 0, 0, 0, 0);
                    }
                    this.q.setVisibility(8);
                    cx4 d3 = cx4.d(this.p);
                    d3.n(R.string.J_X05);
                    d3.f(R.color.CAM_X0201);
                    cx4 d4 = cx4.d(this.o);
                    d4.n(R.string.J_X05);
                    d4.f(R.color.CAM_X0204);
                    ViewCommonUtil.setViewMargin(this.p, 0, zi.g(getContext(), R.dimen.M_H_X004), 0, zi.g(getContext(), R.dimen.M_H_X003));
                    this.p.setPadding(0, 0, 0, 0);
                    ViewCommonUtil.setViewMargin(this.o, 0, 0, 0, 0);
                } else {
                    if (this.y.get(2) != null && (textView = this.n) != null) {
                        textView.setVisibility(0);
                        this.n.setOnTouchListener(new r99(mo5.G(this.y.get(2).content)));
                        this.n.setText(mo5.G(this.y.get(2).content));
                    }
                    this.z = 3;
                    this.q.setVisibility(0);
                    ViewCommonUtil.setViewMargin(this.q, zi.g(getContext(), R.dimen.M_W_X005), zi.g(getContext(), R.dimen.M_H_X004), zi.g(getContext(), R.dimen.M_W_X005), 0);
                    ViewCommonUtil.setViewMargin(this.p, 0, zi.g(getContext(), R.dimen.M_H_X004), 0, zi.g(getContext(), R.dimen.M_H_X003));
                    ViewCommonUtil.setViewMargin(this.o, zi.g(getContext(), R.dimen.M_W_X005), zi.g(getContext(), R.dimen.M_H_X004), zi.g(getContext(), R.dimen.M_W_X005), zi.g(getContext(), R.dimen.M_H_X004));
                    this.p.setPadding(0, 0, 0, 0);
                    cx4 d5 = cx4.d(this.p);
                    d5.n(R.string.J_X05);
                    d5.f(R.color.CAM_X0204);
                    cx4 d6 = cx4.d(this.o);
                    d6.n(R.string.J_X05);
                    d6.f(R.color.CAM_X0201);
                    if (this.y.get(1) != null) {
                        this.q.setOnTouchListener(new r99(mo5.G(this.y.get(1).content)));
                        this.q.setText(mo5.G(this.y.get(1).content));
                        this.v.L(TbRichTextView.c0(this.y.get(1).content, false));
                        if (this.y.get(1).is_floor.intValue() == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        this.q.setTag(R.id.item_data, Boolean.valueOf(z));
                    }
                }
                if (this.v.m().size() != 0 && this.y.get(0) != null) {
                    this.v.K(TbRichTextView.c0(this.y.get(0).content, false));
                    this.A = this.v.i().toString();
                }
            }
            if (this.v.m() != null && this.v.m().size() != 0) {
                this.o.setCardFrom(this.w);
                this.o.j(this.v.o(), this.A);
                this.o.setSubClickListener(this.B);
                this.r.setData(this.v.c(), (this.v.getType() == xn7.A || this.v.getType() == xn7.B || this.v.getType() == xn7.C) ? false : false);
            } else {
                this.o.j(null, "");
                this.r.setData("", (this.v.getType() == xn7.A || this.v.getType() == xn7.B || this.v.getType() == xn7.C) ? false : false);
            }
            if (v()) {
                this.r.setAgreeData(this.v, this.z);
            } else {
                this.r.getAgreeContainer().setVisibility(8);
            }
            if (this.v.C()) {
                this.s.setVisibility(0);
            } else {
                this.s.setVisibility(8);
            }
            s(h(), this.v);
            j(this.t, TbadkCoreApplication.getInst().getSkinType());
        }
    }
}

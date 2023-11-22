package com.baidu.tieba;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.immessagecenter.mention.base.MessageCardBottomView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class d39 extends zk6<a39> {
    public static /* synthetic */ Interceptable $ic;
    public static gu5<String> B;
    public transient /* synthetic */ FieldHolder $fh;
    public OriginalThreadCardView.b A;
    public HeadImageView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public View m;
    public TextView n;
    public TextView o;
    public View p;
    public TextView q;
    public OriginalThreadCardView r;
    public MessageCardBottomView s;
    public View t;
    public TbPageContext u;
    public int v;
    public a39 w;
    public String x;
    public int y;
    public int z;

    @Override // com.baidu.tieba.zk6
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? R.layout.obfuscated_res_0x7f0d01d4 : invokeV.intValue;
    }

    /* loaded from: classes5.dex */
    public class a implements OriginalThreadCardView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d39 a;

        public a(d39 d39Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d39Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d39Var;
        }

        @Override // com.baidu.tieba.card.OriginalThreadCardView.b
        public void a(OriginalThreadInfo originalThreadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, originalThreadInfo) == null) {
                if (this.a.w != null && this.a.w.t() != null) {
                    StatisticItem param = new StatisticItem(this.a.w.t()).param("obj_locate", 2);
                    if (this.a.w.getType() != a39.I && this.a.w.getType() != a39.D) {
                        param.param("obj_type", 2);
                    } else {
                        param.param("obj_type", 1);
                    }
                    TiebaStatic.log(param);
                }
                if (this.a.f() != null) {
                    yl6<a39> f = this.a.f();
                    d39 d39Var = this.a;
                    f.a(d39Var.r, d39Var.w);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947653759, "Lcom/baidu/tieba/d39;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947653759, "Lcom/baidu/tieba/d39;");
                return;
            }
        }
        B = new gu5<>();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d39(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
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
        this.v = 3;
        this.A = new a(this);
        this.u = tbPageContext;
        this.y = BdUtilHelper.getDimens(tbPageContext.getContext(), R.dimen.tbds42);
        this.z = BdUtilHelper.getDimens(this.u.getContext(), R.dimen.tbds48);
        y();
    }

    @Override // com.baidu.tieba.zk6
    public void l(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) && this.v != i) {
            this.v = i;
            i().setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0205));
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0109);
            SkinManager.setBackgroundResource(this.k, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
            SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0109);
            SkinManager.setBackgroundColor(this.m, R.color.CAM_X0110);
            SkinManager.setViewTextColor(this.o, (int) R.color.CAM_X0105);
            SkinManager.setBackgroundColor(this.p, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0107);
            OriginalThreadCardView originalThreadCardView = this.r;
            if (originalThreadCardView != null) {
                originalThreadCardView.s();
            }
            MessageCardBottomView messageCardBottomView = this.s;
            if (messageCardBottomView != null) {
                messageCardBottomView.h();
            }
            SkinManager.setBackgroundResource(this.t, R.drawable.icon_news_red_dot);
        }
    }

    public void A(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.x = str;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            if (this.w == null && this.u == null) {
                return;
            }
            if (view2 == this.i || view2 == this.j) {
                if (this.w.s() == null) {
                    return;
                }
                String userId = this.w.s().getUserId();
                String userName = this.w.s().getUserName();
                if (userId != null && userId.length() > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.u.getContext(), userId, userName)));
                }
            }
            if (f() != null) {
                f().a(view2, this.w);
            }
        }
    }

    public final CharSequence r(TextView textView, SpannableString spannableString) {
        InterceptResult invokeLL;
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, textView, spannableString)) == null) {
            if (textView != null && spannableString != null && (tbPageContext = this.u) != null) {
                return TextUtils.ellipsize(spannableString, textView.getPaint(), ((BdUtilHelper.getEquipmentWidth(tbPageContext.getPageActivity()) - (this.u.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070201) * 2)) - textView.getCompoundPaddingLeft()) * 2.0f, TextUtils.TruncateAt.END);
            }
            return null;
        }
        return (CharSequence) invokeLL.objValue;
    }

    public final void x(@NonNull View view2, @NonNull a39 a39Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, view2, a39Var) == null) {
            if (StringHelper.equals(B.a(), a39Var.o())) {
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0313);
            } else {
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0205);
            }
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            View i = i();
            this.i = (HeadImageView) i.findViewById(R.id.obfuscated_res_0x7f091ce0);
            this.j = (TextView) i.findViewById(R.id.user_name);
            this.k = (TextView) i.findViewById(R.id.obfuscated_res_0x7f090b22);
            this.l = (TextView) i.findViewById(R.id.obfuscated_res_0x7f091d76);
            this.m = i.findViewById(R.id.obfuscated_res_0x7f09092d);
            this.n = (TextView) i.findViewById(R.id.obfuscated_res_0x7f0925c7);
            this.o = (TextView) i.findViewById(R.id.obfuscated_res_0x7f09063f);
            this.p = i.findViewById(R.id.obfuscated_res_0x7f09063c);
            this.q = (TextView) i.findViewById(R.id.obfuscated_res_0x7f09063e);
            this.r = (OriginalThreadCardView) i.findViewById(R.id.original_thread_view);
            this.s = (MessageCardBottomView) i.findViewById(R.id.obfuscated_res_0x7f09063b);
            this.t = i.findViewById(R.id.new_message);
            this.r.setUsePlaceHolder(false);
            this.i.setOnClickListener(this);
            this.j.setOnClickListener(this);
            this.s.getReplyContainer().setOnClickListener(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.zk6
    /* renamed from: z */
    public void k(a39 a39Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, a39Var) == null) && a39Var != null && a39Var.s() != null) {
            this.w = a39Var;
            MetaData s = a39Var.s();
            this.i.setVisibility(0);
            boolean z = true;
            this.i.setPlaceHolder(1);
            this.i.setIsRound(true);
            UtilHelper.showHeadImageViewBigV(this.i, s, 0);
            this.i.setTag(null);
            this.i.setPageId(this.u.getUniqueId());
            this.i.startLoad(a39Var.s().getAvater(), 12, false);
            this.j.setText(StringHelper.cutChineseAndEnglishWithSuffix(UtilHelper.getUserName(s), 14, "..."));
            if (a39Var.s().getIsMyFans() == 1) {
                this.k.setVisibility(0);
            } else {
                this.k.setVisibility(8);
            }
            if (!qd.isEmpty(a39Var.n())) {
                this.m.setVisibility(0);
                this.l.setVisibility(0);
                this.l.setText(a39Var.n());
            } else {
                this.m.setVisibility(8);
                this.l.setVisibility(8);
            }
            this.n.setText(StringHelper.getFormatTime(a39Var.getTime()));
            TextView textView = this.o;
            TbFaceManager i = TbFaceManager.i();
            Context applicationContext = this.u.getPageActivity().getApplicationContext();
            String title = a39Var.getTitle();
            int i2 = this.z;
            textView.setText(r(textView, i.s(applicationContext, title, i2, i2)));
            if (qd.isEmpty(a39Var.getSubTitle())) {
                this.p.setVisibility(8);
                this.q.setVisibility(8);
            } else {
                TextView textView2 = this.q;
                TbFaceManager i3 = TbFaceManager.i();
                Context applicationContext2 = this.u.getPageActivity().getApplicationContext();
                String subTitle = a39Var.getSubTitle();
                int i4 = this.y;
                textView2.setText(r(textView2, i3.s(applicationContext2, subTitle, i4, i4)));
                this.q.setVisibility(0);
                this.p.setVisibility(0);
            }
            this.r.setCardFrom(this.x);
            this.r.i(a39Var.l());
            this.r.setSubClickListener(this.A);
            this.s.setData(a39Var.d(), (a39Var.getType() == a39.D || a39Var.getType() == a39.E || a39Var.getType() == a39.F) ? false : false);
            if (a39Var.y()) {
                this.t.setVisibility(0);
            } else {
                this.t.setVisibility(8);
            }
            x(i(), a39Var);
            l(this.u, TbadkCoreApplication.getInst().getSkinType());
        }
    }
}

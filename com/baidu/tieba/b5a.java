package com.baidu.tieba;

import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BarVoteActivityConfig;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.data.CommitVoteResMsg;
import com.baidu.tbadk.widget.SelectRuleView;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.view.VoteCountDownView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class b5a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public View b;
    public zv9 c;
    public kw9 d;
    public int e;
    public TextView f;
    public View g;
    public TextView h;
    public TBSpecificationBtn i;
    public TextView j;
    public View k;
    public TextView l;
    public VoteCountDownView m;
    public View n;
    public TextView o;
    public SelectRuleView p;
    public TextView q;
    public VoteCountDownView.b r;
    public View.OnClickListener s;
    public HttpMessageListener t;

    /* loaded from: classes5.dex */
    public class a implements VoteCountDownView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b5a a;

        public a(b5a b5aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b5aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b5aVar;
        }

        @Override // com.baidu.tieba.view.VoteCountDownView.b
        public void onFinished() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.b == null) {
                return;
            }
            if (this.a.c != null && this.a.c.h != null) {
                this.a.c.h.k(3);
                b5a b5aVar = this.a;
                b5aVar.j(b5aVar.c);
                return;
            }
            this.a.b.setVisibility(8);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b5a a;

        public b(b5a b5aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b5aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b5aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2.getId() == R.id.obfuscated_res_0x7f091bea) {
                    if (this.a.c == null || this.a.a == null || !ViewHelper.checkUpIsLogin(this.a.a.getPageActivity())) {
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(this.a.a.getPageActivity()).createNormalConfig(JavaTypesHelper.toLong(this.a.c.o(), 0L), 3)));
                } else if (view2.getId() == R.id.obfuscated_res_0x7f091c57 && ViewHelper.checkUpIsLogin(this.a.a.getPageActivity()) && this.a.c != null && this.a.d != null && this.a.c.R() != null) {
                    if (this.a.d.a()) {
                        b6a.L("c13444", this.a.c.o());
                        du9 du9Var = new du9();
                        du9Var.i(JavaTypesHelper.toLong(this.a.c.T(), 0L));
                        du9Var.g(JavaTypesHelper.toLong(this.a.c.o(), 0L));
                        b5a b5aVar = this.a;
                        mwa f = b5aVar.f(b5aVar.c);
                        if (f != null && f.u() != null) {
                            str = f.u().getUserId();
                        } else {
                            str = "";
                        }
                        du9Var.f(JavaTypesHelper.toLong(str, 0L));
                        du9Var.h(2);
                        du9Var.j(this.a.a.getUniqueId());
                        CustomMessage customMessage = new CustomMessage(2921411);
                        customMessage.setData(du9Var);
                        MessageManager.getInstance().sendMessage(customMessage);
                        return;
                    }
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst(), (int) R.string.has_not_other_ticket);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b5a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(b5a b5aVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b5aVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b5aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String errorString;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null) {
                int error = httpResponsedMessage.getError();
                if ((httpResponsedMessage instanceof CommitVoteResMsg) && this.a.c != null && this.a.c.h != null && this.a.a != null && httpResponsedMessage.getOrginalMessage().getTag() == this.a.a.getUniqueId()) {
                    if (error == 0) {
                        BdUtilHelper.showToast(TbadkCoreApplication.getInst(), (int) R.string.bar_manager_vote_success);
                        this.a.c.h.l(this.a.c.h.h() + 1);
                        this.a.c.h.j(false);
                        b5a b5aVar = this.a;
                        b5aVar.j(b5aVar.c);
                    } else if (error == 3250023) {
                        uxa.b(error, "", null);
                    } else if (error == 3250021) {
                        uxa.a(error, ((CommitVoteResMsg) httpResponsedMessage).getTokenData(), null);
                    } else if (error != 3250002 && error != 3250004) {
                        BdUtilHelper.showToast(TbadkCoreApplication.getInst(), httpResponsedMessage.getErrorString());
                    } else {
                        BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                        if (rd.isEmpty(httpResponsedMessage.getErrorString())) {
                            errorString = this.a.a.getResources().getString(R.string.block_user_tip);
                        } else {
                            errorString = httpResponsedMessage.getErrorString();
                        }
                        blockPopInfoData.block_info = errorString;
                        blockPopInfoData.ahead_info = this.a.a.getResources().getString(R.string.block_user_feed);
                        blockPopInfoData.ok_info = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0b86);
                        blockPopInfoData.ahead_url = AntiHelper.a;
                        AntiHelper.s(this.a.a.getPageActivity(), blockPopInfoData);
                    }
                }
            }
        }
    }

    public b5a(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = new a(this);
        this.s = new b(this);
        this.t = new c(this, CmdConfigHttp.CMD_BAR_VOTE);
        this.a = tbPageContext;
    }

    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            SkinManager.setViewTextColor(this.h, R.color.CAM_X0304, 1, i);
            SkinManager.setViewTextColor(this.f, R.color.CAM_X0109, 1, i);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0109, 1, i);
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0105, 1, i);
            SkinManager.setViewTextColor(this.q, R.color.CAM_X0304, 1, i);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0105, 1, i);
            TBSpecificationBtn tBSpecificationBtn = this.i;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.k();
            }
            SkinManager.setBackgroundColor(this.n, R.color.CAM_X0206, i);
            VoteCountDownView voteCountDownView = this.m;
            if (voteCountDownView != null) {
                voteCountDownView.e(i);
            }
            SelectRuleView selectRuleView = this.p;
            if (selectRuleView != null) {
                selectRuleView.d(i);
            }
        }
    }

    public View a(zv9 zv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, zv9Var)) == null) {
            TbPageContext tbPageContext = this.a;
            if (tbPageContext == null) {
                return null;
            }
            View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d014f, (ViewGroup) null);
            this.b = inflate;
            this.f = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091b86);
            this.g = this.b.findViewById(R.id.obfuscated_res_0x7f091c58);
            this.l = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091b96);
            this.i = (TBSpecificationBtn) this.b.findViewById(R.id.obfuscated_res_0x7f091c57);
            d65 d65Var = new d65();
            d65Var.e(GradientDrawable.Orientation.TL_BR);
            this.i.setText(TbadkCoreApplication.getInst().getString(R.string.pb_vote_text));
            this.i.setTextSize(R.dimen.tbfontsize44);
            this.i.setConfig(d65Var);
            this.h = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091c5a);
            this.j = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091b87);
            this.k = this.b.findViewById(R.id.obfuscated_res_0x7f091b95);
            this.m = (VoteCountDownView) this.b.findViewById(R.id.obfuscated_res_0x7f091c59);
            this.n = this.b.findViewById(R.id.obfuscated_res_0x7f091c5b);
            this.o = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091c5d);
            this.p = (SelectRuleView) this.b.findViewById(R.id.obfuscated_res_0x7f091c5c);
            this.q = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091bea);
            if (this.t != null) {
                if (this.a.getPageActivity() instanceof BaseActivity) {
                    this.t.setTag(((BaseActivity) this.a.getPageActivity()).getUniqueId());
                } else if (this.a.getPageActivity() instanceof BaseFragmentActivity) {
                    this.t.setTag(((BaseFragmentActivity) this.a.getPageActivity()).getUniqueId());
                }
                MessageManager.getInstance().registerListener(this.t);
            }
            j(zv9Var);
            return this.b;
        }
        return (View) invokeL.objValue;
    }

    public void j(zv9 zv9Var) {
        kw9 kw9Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, zv9Var) != null) || this.b == null) {
            return;
        }
        if (zv9Var != null && (kw9Var = zv9Var.h) != null) {
            this.c = zv9Var;
            this.d = kw9Var;
            if (kw9Var.d() != 0) {
                int d = this.d.d();
                this.e = d;
                if (d == 2) {
                    this.g.setVisibility(8);
                    this.k.setVisibility(0);
                    this.m.setOnCountDownFinished(this.r);
                    this.m.setData(this.d.c() * 1000);
                    this.q.setVisibility(8);
                } else if (d == 3) {
                    this.g.setVisibility(0);
                    this.i.setOnClickListener(this.s);
                    this.k.setVisibility(8);
                    this.q.setVisibility(0);
                    this.q.setOnClickListener(this.s);
                    TextView textView = this.h;
                    textView.setText(this.d.h() + "票");
                } else if (d != 4 && d != 5) {
                    if (d == 6) {
                        this.g.setVisibility(0);
                        this.i.setEnabled(false);
                        this.k.setVisibility(8);
                        TextView textView2 = this.h;
                        textView2.setText(this.d.h() + "票");
                        this.q.setVisibility(8);
                    } else {
                        this.b.setVisibility(8);
                        return;
                    }
                } else {
                    this.g.setVisibility(0);
                    this.i.setEnabled(false);
                    this.k.setVisibility(8);
                    this.q.setVisibility(0);
                    this.q.setOnClickListener(this.s);
                    TextView textView3 = this.h;
                    textView3.setText(this.d.h() + "票");
                }
                if (!ListUtils.isEmpty(this.d.g()) || !ListUtils.isEmpty(this.d.f())) {
                    this.p.setColumn(2);
                    this.p.setData(this.d.g(), this.d.f());
                }
                i(TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            return;
        }
        this.b.setVisibility(8);
    }

    public mwa f(zv9 zv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zv9Var)) == null) {
            mwa mwaVar = null;
            if (zv9Var == null) {
                return null;
            }
            if (zv9Var.b0() != null) {
                return zv9Var.b0();
            }
            if (!ListUtils.isEmpty(zv9Var.I())) {
                Iterator<mwa> it = zv9Var.I().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    mwa next = it.next();
                    if (next != null && next.L() == 1) {
                        mwaVar = next;
                        break;
                    }
                }
            }
            if (mwaVar == null) {
                mwaVar = zv9Var.l();
            }
            if (mwaVar == null) {
                mwaVar = g(zv9Var);
            }
            if (mwaVar != null && mwaVar.u() != null && mwaVar.u().getUserTbVipInfoData() != null && mwaVar.u().getUserTbVipInfoData().getvipIntro() != null) {
                mwaVar.u().getGodUserData().setIntro(mwaVar.u().getUserTbVipInfoData().getvipIntro());
            }
            return mwaVar;
        }
        return (mwa) invokeL.objValue;
    }

    public final mwa g(zv9 zv9Var) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, zv9Var)) == null) {
            if (zv9Var != null && zv9Var.R() != null && zv9Var.R().getAuthor() != null) {
                mwa mwaVar = new mwa();
                MetaData author = zv9Var.R().getAuthor();
                String userId = author.getUserId();
                HashMap<String, MetaData> userMap = zv9Var.R().getUserMap();
                if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                    author = metaData;
                }
                mwaVar.Z0(1);
                mwaVar.f1(zv9Var.R().getFirstPostId());
                mwaVar.x1(zv9Var.R().getTitle());
                mwaVar.w1(zv9Var.R().getCreateTime());
                mwaVar.T0(author);
                return mwaVar;
            }
            return null;
        }
        return (mwa) invokeL.objValue;
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }
}

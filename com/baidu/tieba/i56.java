package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.BlueCheckRadioButton;
import com.baidu.tieba.lv4;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.wv4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import tbclient.BawuThrones;
/* loaded from: classes4.dex */
public class i56 extends uv4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final wv4.e A;
    public TbPageContext k;
    public Context l;
    public final wv4 m;
    public AlertDialog n;
    public AlertDialog o;
    public lv4 p;
    public Dialog q;
    public final List<sv4> r;
    public String s;
    public String t;
    public List<BlueCheckRadioButton> u;
    public ThreadData v;
    public ForumManageModel w;
    public boolean x;
    public final CompoundButton.OnCheckedChangeListener y;
    public final q9 z;

    /* loaded from: classes4.dex */
    public class h extends q9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i56 a;

        /* loaded from: classes4.dex */
        public class a implements lv4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(h hVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.lv4.e
            public void onClick(lv4 lv4Var) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) && lv4Var != null) {
                    lv4Var.dismiss();
                }
            }
        }

        public h(i56 i56Var) {
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

        @Override // com.baidu.tieba.q9
        public void c(Object obj) {
            String Z;
            String Z2;
            String Z3;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && obj != null && this.a.w != null) {
                ViewGroup viewGroup = (ViewGroup) this.a.Y();
                switch (this.a.w.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.d != 0) {
                            if (bVar.h) {
                                BdTopToast bdTopToast = new BdTopToast(this.a.getContext());
                                bdTopToast.h(false);
                                bdTopToast.g(this.a.Z(R.string.shield_fail, new Object[0]));
                                bdTopToast.i(viewGroup);
                                return;
                            }
                            BdTopToast bdTopToast2 = new BdTopToast(this.a.getContext());
                            bdTopToast2.h(false);
                            bdTopToast2.g(this.a.Z(R.string.delete_fail, new Object[0]));
                            bdTopToast2.i(viewGroup);
                            return;
                        } else if (bVar.a) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.a.v.getId()));
                            if (bVar.h) {
                                BdTopToast bdTopToast3 = new BdTopToast(this.a.getContext());
                                bdTopToast3.h(true);
                                bdTopToast3.g(this.a.Z(R.string.shield_success, new Object[0]));
                                bdTopToast3.i(viewGroup);
                                return;
                            }
                            BdTopToast bdTopToast4 = new BdTopToast(this.a.getContext());
                            bdTopToast4.h(true);
                            bdTopToast4.g(this.a.Z(R.string.delete_success, new Object[0]));
                            bdTopToast4.i(viewGroup);
                            return;
                        } else {
                            if (!TextUtils.isEmpty(bVar.b)) {
                                Z = bVar.b;
                            } else {
                                Z = this.a.Z(R.string.delete_fail, new Object[0]);
                            }
                            if (bVar.c == 1211066) {
                                if (this.a.p == null) {
                                    i56 i56Var = this.a;
                                    i56Var.p = new lv4(i56Var.k.getPageActivity());
                                    this.a.p.setMessage(Z);
                                    this.a.p.setPositiveButton(R.string.dialog_known, new a(this));
                                    this.a.p.setCancelable(true);
                                    this.a.p.create(this.a.k);
                                }
                                this.a.p.show();
                                return;
                            }
                            BdTopToast bdTopToast5 = new BdTopToast(this.a.getContext());
                            bdTopToast5.h(false);
                            bdTopToast5.g(Z);
                            bdTopToast5.i(viewGroup);
                            return;
                        }
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        if (dVar == null) {
                            yi.Q(this.a.l, this.a.Z(R.string.mute_fail, new Object[0]));
                            return;
                        } else if (dVar.a) {
                            if (!TextUtils.isEmpty(dVar.b)) {
                                Z3 = dVar.b;
                            } else {
                                Z3 = this.a.Z(R.string.mute_success, new Object[0]);
                            }
                            yi.Q(this.a.l, Z3);
                            return;
                        } else {
                            if (!TextUtils.isEmpty(dVar.b)) {
                                Z2 = dVar.b;
                            } else {
                                Z2 = this.a.Z(R.string.mute_fail, new Object[0]);
                            }
                            yi.Q(this.a.l, Z2);
                            return;
                        }
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        i56 i56Var2 = this.a;
                        i56Var2.X(i56Var2.w.getLoadDataMode(), (ForumManageModel.g) obj);
                        return;
                    case 6:
                        ForumManageModel.g gVar = (ForumManageModel.g) obj;
                        if (gVar == null || !gVar.a) {
                            yi.Q(this.a.l, this.a.Z(R.string.operation_failed, new Object[0]));
                            return;
                        } else {
                            this.a.h0(gVar.c);
                            return;
                        }
                    default:
                        return;
                }
            }
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
                if (this.a.n != null) {
                    this.a.n.dismiss();
                }
                if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    yi.P(this.a.l, R.string.obfuscated_res_0x7f0f0cb8);
                } else {
                    this.a.i0(null, false);
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
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.n != null) {
                this.a.n.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i56 a;

        public c(i56 i56Var) {
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
                if (this.a.o != null) {
                    this.a.o.dismiss();
                }
                if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    yi.P(this.a.l, R.string.obfuscated_res_0x7f0f0cb8);
                    return;
                }
                this.a.i0(null, true);
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_SELF_DIALOG_CONFIRM_CLICK);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("tid", this.a.v.getId());
                statisticItem.param("fid", this.a.v.getFid());
                statisticItem.param("fname", this.a.v.getForum_name());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i56 a;

        public d(i56 i56Var) {
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
                if (this.a.o != null) {
                    this.a.o.dismiss();
                }
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_SELF_DIALOG_CANCEL_CLICK);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("tid", this.a.v.getId());
                statisticItem.param("fid", this.a.v.getFid());
                statisticItem.param("fname", this.a.v.getForum_name());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i56 a;

        public e(i56 i56Var) {
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
                ch.b(this.a.q, this.a.k);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i56 a;

        public f(i56 i56Var) {
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
                ch.b(this.a.q, this.a.k);
                i56 i56Var = this.a;
                i56Var.k0(i56Var.t, false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i56 a;

        public g(i56 i56Var) {
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

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) && z && (compoundButton.getTag() instanceof String)) {
                this.a.t = (String) compoundButton.getTag();
                if (this.a.u != null) {
                    for (BlueCheckRadioButton blueCheckRadioButton : this.a.u) {
                        String str = (String) blueCheckRadioButton.getTag();
                        if (str != null && this.a.t != null && !str.equals(this.a.t)) {
                            blueCheckRadioButton.setChecked(false);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements wv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i56 a;

        public i(i56 i56Var) {
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

        @Override // com.baidu.tieba.wv4.e
        public void n0(wv4 wv4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, wv4Var, i, view2) == null) {
                this.a.dismiss();
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    yi.P(this.a.l, R.string.network_not_available);
                    return;
                }
                if (i == 1) {
                    if (this.a.v != null && this.a.v.getAuthor() != null) {
                        if (UtilHelper.isCurrentAccount(this.a.v.getAuthor().getUserId())) {
                            this.a.g0();
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921515, new pq5(1, this.a.w, this.a.v)));
                        }
                    }
                } else if (i == 9) {
                    if (this.a.v != null && this.a.v.getAuthor() != null) {
                        if (UtilHelper.isCurrentAccount(this.a.v.getAuthor().getUserId())) {
                            this.a.f0();
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921515, new pq5(3, this.a.w, this.a.v)));
                            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_SHOW);
                            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                            statisticItem.param("tid", this.a.v.getId());
                            if (this.a.v.getForumData() != null) {
                                statisticItem.param("fid", this.a.v.getForumData().b());
                                statisticItem.param("fname", this.a.v.getForumData().d());
                            }
                            statisticItem.param("obj_source", 1);
                            TiebaStatic.log(statisticItem);
                        }
                        StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_BAWU_FRS_MUSK_CLICK);
                        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                        statisticItem2.param("tid", this.a.v.getId());
                        statisticItem2.param("fid", this.a.v.getFid());
                        statisticItem2.param("fname", this.a.v.getForum_name());
                        TiebaStatic.log(statisticItem2);
                    }
                } else if (i == 2) {
                    this.a.j0();
                } else if (i == 3) {
                    this.a.l0();
                } else if (i == 4) {
                    i56 i56Var = this.a;
                    i56Var.k0(i56Var.s, true);
                } else if (i == 5) {
                    this.a.P();
                } else if (i == 10) {
                    this.a.O();
                    StatisticItem statisticItem3 = new StatisticItem(CommonStatisticKey.KEY_BAWU_MULTI_MUSK_CLICK);
                    statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem3.param("tid", this.a.v.getId());
                    statisticItem3.param("fid", this.a.v.getFid());
                    statisticItem3.param("fname", this.a.v.getForum_name());
                    TiebaStatic.log(statisticItem3);
                } else if (i == 6) {
                    this.a.d0();
                } else if (i == 7) {
                    this.a.N();
                } else if (i == 8) {
                    this.a.M();
                }
                this.a.b0(i);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i56(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((r9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.s = "0";
        this.t = "0";
        this.x = false;
        this.y = new g(this);
        this.z = new h(this);
        this.A = new i(this);
        this.k = tbPageContext;
        this.l = tbPageContext.getPageActivity();
        this.r = new ArrayList();
        wv4 wv4Var = new wv4(this.l);
        this.m = wv4Var;
        wv4Var.q(Z(R.string.thread_manager, new Object[0]));
        this.m.n(this.A);
        ForumManageModel forumManageModel = new ForumManageModel(this.k);
        this.w = forumManageModel;
        forumManageModel.setLoadDataCallBack(this.z);
        this.x = z;
        h(this.m);
    }

    public void e0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, threadData) == null) {
            this.v = threadData;
            R();
        }
    }

    public final String Z(int i2, Object... objArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048589, this, i2, objArr)) == null) {
            Context context = this.l;
            if (context == null) {
                return null;
            }
            return context.getString(i2, objArr);
        }
        return (String) invokeIL.objValue;
    }

    public final String a0(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048590, this, str, i2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return Z(i2, new Object[0]);
            }
            return str;
        }
        return (String) invokeLI.objValue;
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921475, this.v));
        }
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            sj6.h().p(true, false);
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            tj6.f().o(false);
            tj6.f().p(true, false);
        }
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            T();
        }
    }

    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            V();
            U();
            W();
            dismiss();
        }
    }

    public void U() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (alertDialog = this.o) != null && alertDialog.isShowing()) {
            this.o.dismiss();
        }
    }

    public void V() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (alertDialog = this.n) != null && alertDialog.isShowing()) {
            this.n.dismiss();
        }
    }

    public void W() {
        Dialog dialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (dialog = this.q) != null && dialog.isShowing()) {
            this.q.dismiss();
        }
    }

    public final View Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            Context context = this.l;
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            wv4 wv4Var = this.m;
            if (wv4Var != null) {
                wv4Var.i();
            }
            lv4 lv4Var = this.p;
            if (lv4Var != null) {
                ig5.a(this.k, lv4Var.getRealView());
            }
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            tj6.f().o(true);
            tj6.f().p(true, false);
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_MULTI_MUSK_VIEW_SHOW);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("tid", this.v.getId());
            statisticItem.param("fid", this.v.getFid());
            statisticItem.param("fname", this.v.getForum_name());
            TiebaStatic.log(statisticItem);
        }
    }

    public final BlueCheckRadioButton Q(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
            BlueCheckRadioButton blueCheckRadioButton = new BlueCheckRadioButton(this.l);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, yi.g(this.l, R.dimen.obfuscated_res_0x7f07019a));
            blueCheckRadioButton.setOnCheckedChangeListener(this.y);
            blueCheckRadioButton.setTag(str);
            blueCheckRadioButton.setText(str2);
            blueCheckRadioButton.setLayoutParams(layoutParams);
            return blueCheckRadioButton;
        }
        return (BlueCheckRadioButton) invokeLL.objValue;
    }

    public final void k0(String str, boolean z) {
        ThreadData threadData;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048600, this, str, z) == null) && (threadData = this.v) != null && this.w != null) {
            if (threadData.getIs_good() == 1) {
                i2 = 3;
            } else if (z) {
                i2 = 6;
            } else {
                i2 = 2;
            }
            String id = this.v.getId();
            this.w.d0(String.valueOf(this.v.getFid()), this.v.getForum_name(), id, i2, str);
        }
    }

    public final void R() {
        List<sv4> list;
        boolean z;
        int i2;
        boolean z2;
        int i3;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.v != null && (list = this.r) != null && this.m != null) {
            list.clear();
            if (bk6.d(bk6.a()) && !bk6.f()) {
                if (!this.v.isBjh() && ((this.v.getAuthor() == null || !this.v.getAuthor().isForumBusinessAccount() || this.v.isSelf() || pl6.isOn()) && !bk6.g() && !this.v.isWorksInfo() && !this.v.isScoreThread() && (!this.v.isTiePlusCantDeleteUnion() || this.v.isSelf()))) {
                    this.r.add(new sv4(1, Z(R.string.delete_page, new Object[0]), this.m));
                }
                if (this.v.isWorksInfo() || this.v.isScoreThread() || (bk6.g() && !this.v.isBjh() && (this.v.getAuthor() == null || !this.v.getAuthor().isForumBusinessAccount() || this.v.isSelf() || pl6.isOn()))) {
                    this.r.add(new sv4(9, Z(R.string.forum_shield, new Object[0]), this.m));
                }
                if (this.v.getAuthor() != null) {
                    str = this.v.getAuthor().getUserId();
                } else {
                    str = "";
                }
                if (!UtilHelper.isCurrentAccount(str) && ((this.v.getAuthor() == null || !this.v.getAuthor().isForumBusinessAccount()) && !this.v.isTiePlusCantDeleteUnion())) {
                    this.r.add(new sv4(2, Z(R.string.thread_forbid, new Object[0]), this.m));
                }
            }
            if (bk6.e() || bk6.f()) {
                if (this.v.getIs_top() == 1) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    i2 = R.string.cancel_top;
                } else {
                    i2 = R.string.obfuscated_res_0x7f0f14d1;
                }
                this.r.add(new sv4(3, Z(i2, new Object[0]), this.m));
            }
            if (bk6.e() || bk6.h()) {
                if (this.v.getIs_good() == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    i3 = R.string.cancel_good;
                } else {
                    i3 = R.string.commit_good;
                }
                this.r.add(new sv4(4, Z(i3, new Object[0]), this.m));
            }
            if (bk6.e()) {
                this.r.add(new sv4(6, Z(R.string.frs_recommend_thread, new Object[0]), this.m));
            }
            if (bk6.e() || bk6.f()) {
                this.r.add(new sv4(8, Z(R.string.frs_forum_bawu_send_broadcast, new Object[0]), this.m));
            }
            if (bk6.e() && this.x) {
                this.r.add(new sv4(7, Z(R.string.frs_move_area_thread, new Object[0]), this.m));
            }
            if (!bk6.f() && tj6.f().j() && this.x && ((this.v.getAuthor() == null || !this.v.getAuthor().isForumBusinessAccount() || this.v.isSelf() || pl6.isOn()) && !bk6.g())) {
                this.r.add(new sv4(5, Z(R.string.multi_delete, new Object[0]), this.m));
            }
            if (bk6.g() && !bk6.f() && tj6.f().j() && this.x && (this.v.getAuthor() == null || !this.v.getAuthor().isForumBusinessAccount() || this.v.isSelf() || pl6.isOn())) {
                this.r.add(new sv4(10, Z(R.string.multi_shield, new Object[0]), this.m));
            }
            if (bk6.g() && this.v.isSelf() && !this.v.isBjh()) {
                this.r.add(new sv4(1, Z(R.string.obfuscated_res_0x7f0f04c1, new Object[0]), this.m));
            }
            this.m.j(this.r);
        }
    }

    public final void X(int i2, ForumManageModel.g gVar) {
        String Z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048587, this, i2, gVar) == null) {
            ThreadData threadData = this.v;
            if (threadData != null && gVar != null && gVar.a) {
                String str = "";
                boolean z = true;
                if (i2 == 2) {
                    threadData.setIs_good(1);
                    ws4 ws4Var = new ws4();
                    ws4Var.a = 2;
                    ws4Var.b = this.v.getTid();
                    if (bk6.e()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921469, ws4Var));
                    } else {
                        str = a0(gVar.b, R.string.set_good_success);
                        z = false;
                    }
                } else {
                    if (i2 == 3) {
                        threadData.setIs_good(0);
                        str = a0(gVar.b, R.string.operation_success);
                    } else if (i2 == 4) {
                        threadData.setIs_top(1);
                        ws4 ws4Var2 = new ws4();
                        ws4Var2.a = 1;
                        ws4Var2.b = this.v.getTid();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921469, ws4Var2));
                    } else if (i2 == 5) {
                        threadData.setIs_top(0);
                        str = a0(gVar.b, R.string.operation_success);
                    }
                    z = false;
                }
                ForumManageModel.e eVar = new ForumManageModel.e();
                eVar.a = this.v.getId();
                eVar.c = this.v.getForum_name();
                eVar.b = String.valueOf(this.v.getFid());
                eVar.d = i2;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921316, eVar));
                if (TextUtils.isEmpty(str)) {
                    str = Z(R.string.operation_success, new Object[0]);
                }
                if (!z) {
                    yi.Q(this.l, str);
                    return;
                }
                return;
            }
            if (gVar != null && !TextUtils.isEmpty(gVar.b)) {
                Z = gVar.b;
            } else {
                Z = Z(R.string.operation_failed, new Object[0]);
            }
            yi.Q(this.l, Z);
        }
    }

    public final void b0(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048591, this, i2) != null) || this.v == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_MANAGE_ITEM_CLICK).param("obj_type", i2).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.v.getFid()).param("tid", this.v.getId()));
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.k != null && this.v != null) {
            BawuThrones b2 = uj6.c().b();
            if (b2 == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921465));
            } else if (b2.total_recommend_num.intValue() == b2.used_recommend_num.intValue()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921465));
            } else if (ry4.l().i("key_frs_recommend_tip", true)) {
                uj6.c().f(this.k, String.valueOf(this.v.getFid()), this.v.getId());
            } else {
                uj6.c().d(String.valueOf(this.v.getFid()), this.v.getId());
            }
        }
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            V();
            if (this.k == null) {
                return;
            }
            TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f04c1, TBAlertConfig.OperateBtnStyle.MAIN);
            TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f037c, TBAlertConfig.OperateBtnStyle.SECONDARY);
            TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.k.getPageActivity());
            tBAlertBuilder.v(R.string.del_my_thread_confirm);
            tBAlertBuilder.m(R.string.del_my_thread_confirm_subtitle);
            tBAlertBuilder.o(true);
            tBAlertBuilder.t(aVar2, aVar);
            tBAlertBuilder.j(false);
            this.n = tBAlertBuilder.y();
            aVar.a(new a(this));
            aVar2.a(new b(this));
        }
    }

    public final void j0() {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && this.l != null && (threadData = this.v) != null && threadData.getAuthor() != null) {
            String userId = this.v.getAuthor().getUserId();
            String userName = this.v.getAuthor().getUserName();
            String name_show = this.v.getAuthor().getName_show();
            String id = this.v.getId();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.l, String.valueOf(this.v.getFid()), this.v.getForum_name(), id, userId, userName, name_show, null, this.v.getAuthor().getPortrait())));
        }
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            U();
            if (this.k == null) {
                return;
            }
            TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f1206, TBAlertConfig.OperateBtnStyle.MAIN);
            TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f037c, TBAlertConfig.OperateBtnStyle.SECONDARY);
            TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.k.getPageActivity());
            tBAlertBuilder.v(R.string.musk_my_thread_confirm);
            tBAlertBuilder.m(R.string.musk_my_thread_confirm_subtitle);
            tBAlertBuilder.o(true);
            tBAlertBuilder.t(aVar2, aVar);
            tBAlertBuilder.j(false);
            this.o = tBAlertBuilder.y();
            aVar.a(new c(this));
            aVar2.a(new d(this));
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_SELF_DIALOG_SHOW);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("tid", this.v.getId());
            statisticItem.param("fid", this.v.getFid());
            statisticItem.param("fname", this.v.getForum_name());
            TiebaStatic.log(statisticItem);
        }
    }

    public final void h0(ArrayList<it4> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, arrayList) == null) {
            if (this.q == null) {
                View inflate = LayoutInflater.from(this.l).inflate(R.layout.commit_good, (ViewGroup) null);
                Dialog dialog = new Dialog(this.l, R.style.obfuscated_res_0x7f1003a9);
                this.q = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.q.setCancelable(true);
                this.q.setContentView(inflate);
                WindowManager.LayoutParams attributes = this.q.getWindow().getAttributes();
                attributes.width = yi.g(this.l, R.dimen.obfuscated_res_0x7f0702db);
                this.q.getWindow().setAttributes(attributes);
                inflate.findViewById(R.id.dialog_button_cancel).setOnClickListener(new e(this));
                inflate.findViewById(R.id.dialog_button_ok).setOnClickListener(new f(this));
            }
            ig5.a(this.k, this.q.findViewById(R.id.commit_good_layout));
            LinearLayout linearLayout = (LinearLayout) this.q.findViewById(R.id.good_class_group);
            linearLayout.removeAllViews();
            this.u = new ArrayList();
            BlueCheckRadioButton Q = Q(this.s, Z(R.string.thread_good_class, new Object[0]));
            Q.setChecked(true);
            linearLayout.addView(Q);
            this.u.add(Q);
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    it4 it4Var = arrayList.get(i2);
                    if (it4Var != null && !TextUtils.isEmpty(it4Var.b()) && it4Var.a() > 0) {
                        BlueCheckRadioButton Q2 = Q(String.valueOf(it4Var.a()), it4Var.b());
                        this.u.add(Q2);
                        View view2 = new View(this.l);
                        view2.setLayoutParams(new LinearLayout.LayoutParams(-1, yi.g(this.l, R.dimen.obfuscated_res_0x7f070198)));
                        linearLayout.addView(view2);
                        linearLayout.addView(Q2);
                        SkinManager.setBackgroundColor(view2, R.color.CAM_X0204);
                    }
                }
                ScrollView scrollView = (ScrollView) this.q.findViewById(R.id.good_scroll);
                ViewGroup.LayoutParams layoutParams = scrollView.getLayoutParams();
                int size2 = arrayList.size();
                if (size2 != 0 && size2 != 1) {
                    if (size2 != 2) {
                        layoutParams.height = yi.d(this.l, 220.0f);
                    } else {
                        layoutParams.height = yi.d(this.l, 186.0f);
                    }
                } else {
                    layoutParams.height = yi.d(this.l, 120.0f);
                }
                scrollView.setLayoutParams(layoutParams);
                scrollView.removeAllViews();
                scrollView.addView(linearLayout);
            }
            ch.j(this.q, this.k);
        }
    }

    public final void i0(JSONArray jSONArray, boolean z) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048598, this, jSONArray, z) == null) && this.w != null && (threadData = this.v) != null && threadData.getAuthor() != null) {
            String userId = this.v.getAuthor().getUserId();
            String id = this.v.getId();
            String forum_name = this.v.getForum_name();
            String valueOf = String.valueOf(this.v.getFid());
            boolean isCurrentAccount = UtilHelper.isCurrentAccount(userId);
            if (jSONArray != null) {
                this.w.b0(StringHelper.JsonArrayToString(jSONArray));
            }
            this.w.c0(valueOf, forum_name, id, null, 0, 1, isCurrentAccount, this.v.getBaijiahaoData(), z);
        }
    }

    public final void l0() {
        ThreadData threadData;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && (threadData = this.v) != null && this.w != null) {
            if (threadData.getIs_top() == 1) {
                i2 = 5;
            } else {
                i2 = 4;
            }
            String id = this.v.getId();
            this.w.d0(String.valueOf(this.v.getFid()), this.v.getForum_name(), id, i2, null);
        }
    }
}

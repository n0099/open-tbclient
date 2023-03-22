package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.lb9;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.zz4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public List<TBSpecificationBtn> b;
    public LikeModel c;
    public lb9 d;
    public boolean e;
    public AntiHelper.k f;
    public CustomMessageListener g;
    public z8 h;
    public lb9.a i;

    /* loaded from: classes3.dex */
    public class a implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(b97 b97Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b97Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zz4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b97 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(b97 b97Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b97Var, Integer.valueOf(i)};
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
            this.a = b97Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof bb9)) {
                this.a.f(customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends z8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b97 a;

        public c(b97 b97Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b97Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b97Var;
        }

        @Override // com.baidu.tieba.z8
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, obj) != null) {
                return;
            }
            this.a.f(obj);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements lb9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b97 a;

        @Override // com.baidu.tieba.lb9.a
        public void a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
            }
        }

        public d(b97 b97Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b97Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b97Var;
        }

        @Override // com.baidu.tieba.lb9.a
        public void b(String str, long j) {
            FrsViewData W0;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) && this.a.a != null && (W0 = this.a.a.W0()) != null && W0.getForum() != null) {
                String name = W0.getForum().getName();
                String id = W0.getForum().getId();
                if (j == gg.g(id, 0L) && TextUtils.equals(name, str)) {
                    d97 s0 = this.a.a.s0();
                    if (s0 != null) {
                        s0.i0(str);
                    }
                    W0.getForum().setLike(0);
                    if (s0 != null) {
                        s0.c0(0);
                    }
                    this.a.a.n5(Boolean.TRUE);
                    this.a.l(false, id);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003004, id));
                    bb9 bb9Var = new bb9();
                    bb9Var.y(0);
                    bb9Var.v(id);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, bb9Var));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements zz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b97 a;

        public e(b97 b97Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b97Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b97Var;
        }

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                zz4Var.dismiss();
                if (this.a.a != null && this.a.d != null) {
                    FrsViewData W0 = this.a.a.W0();
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (currentAccount != null && currentAccount.length() > 0) {
                        if (W0 != null && W0.getForum() != null) {
                            this.a.d.c(W0.getForum().getName(), gg.g(W0.getForum().getId(), 0L));
                            return;
                        }
                        return;
                    }
                    TbadkCoreApplication.getInst().login(this.a.a.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.a.a.getActivity(), true, 11036)));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements zz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(b97 b97Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b97Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                zz4Var.dismiss();
            }
        }
    }

    public b97(FrsFragment frsFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new ArrayList();
        this.c = null;
        this.d = null;
        this.f = new a(this);
        this.g = new b(this, 2921600);
        this.h = new c(this);
        this.i = new d(this);
        this.a = frsFragment;
        if (frsFragment != null) {
            frsFragment.registerListener(this.g);
        }
    }

    public final void l(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048583, this, z, str) == null) {
            ar7.j().g(TbadkCoreApplication.getCurrentAccount(), str, z, null);
            MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
        }
    }

    public void o(String str, String str2) {
        LikeModel likeModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048586, this, str, str2) == null) && (likeModel = this.c) != null) {
            likeModel.k0(str, str2, "FRS");
        }
    }

    public void g(@NonNull List<TBSpecificationBtn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.b = list;
            n();
        }
    }

    public void m(boolean z) {
        LikeModel likeModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) && (likeModel = this.c) != null) {
            likeModel.i0(z ? 1 : 0);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13605");
            FrsFragment frsFragment = this.a;
            if (frsFragment != null) {
                ek5.b(frsFragment.getContext(), statisticItem);
                i67.b(statisticItem, this.a.w(), this.a.v());
            }
            i67.a(statisticItem);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void f(Object obj) {
        FrsFragment frsFragment;
        FrsViewData W0;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) && (frsFragment = this.a) != null && (W0 = frsFragment.W0()) != null && W0.getForum() != null && obj != null) {
            if (AntiHelper.m(this.c.getErrorCode(), this.c.getErrorString())) {
                if (AntiHelper.t(this.a.getActivity(), this.c.g0(), this.f) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
                    return;
                }
                return;
            }
            String name = W0.getForum().getName();
            String id = W0.getForum().getId();
            bb9 bb9Var = null;
            if (obj instanceof bb9) {
                bb9Var = (bb9) obj;
            }
            boolean z2 = false;
            if (bb9Var != null && this.c.getErrorCode() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (bb9Var.d() == 3250013) {
                BdToast b2 = BdToast.b(TbadkCoreApplication.getInst().getContext(), bb9Var.e());
                b2.g(BdToast.ToastIcon.FAILURE);
                b2.d(3000);
                b2.k();
            } else {
                z2 = z;
            }
            if (bb9Var != null && z2) {
                d97 s0 = this.a.s0();
                if (s0 != null) {
                    s0.i0(name);
                }
                bb9Var.y(1);
                W0.updateLikeData(bb9Var);
                W0.setLikeFeedForumDataList(bb9Var.f());
                if (s0 != null) {
                    s0.q0(W0, this.e);
                    if (!ListUtils.isEmpty(bb9Var.k())) {
                        s0.z0(bb9Var.k());
                    }
                }
                this.e = true;
                FrsFragment frsFragment2 = this.a;
                if (frsFragment2 != null && (frsFragment2.getActivity() instanceof FrsActivity)) {
                    ((FrsActivity) this.a.getActivity()).u1().d(id);
                }
                l(true, id);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, bb9Var));
                e();
            } else if (this.c.getErrorCode() == 22) {
                FrsFragment frsFragment3 = this.a;
                frsFragment3.showToast(frsFragment3.getString(R.string.had_liked_forum));
            } else {
                this.a.showToast(this.c.getErrorString());
            }
            this.a.j4(Boolean.valueOf(z2));
        }
    }

    public void p(boolean z) {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z) == null) && (frsFragment = this.a) != null && this.c != null) {
            FrsViewData W0 = frsFragment.W0();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (W0 != null && W0.getForum() != null) {
                    if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.a.y3())) {
                        TiebaStatic.log(new StatisticItem("c10356").param("fid", W0.getForum().getId()));
                    } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.a.y3())) {
                        TiebaStatic.log(new StatisticItem("c10590").param("obj_type", 2).param("fid", W0.getForum().getId()));
                    } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.a.y3())) {
                        TiebaStatic.log(new StatisticItem("c10587").param("obj_type", 2).param("fid", W0.getForum().getId()));
                    } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.a.y3())) {
                        TiebaStatic.log(new StatisticItem("c10578").param("obj_type", 2).param("fid", W0.getForum().getId()));
                    }
                    this.c.setFrom("recom_flist_like_frs");
                    if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.a.y3())) {
                        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                    } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.a.y3())) {
                        TiebaStatic.log(new StatisticItem("c10359").param("fid", W0.getForum().getId()));
                    }
                    this.c.k0(W0.getForum().getName(), W0.getForum().getId(), "FRS");
                    this.e = z;
                    return;
                }
                return;
            }
            TbadkCoreApplication.getInst().login(this.a.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.a.getActivity(), true, 11002)));
        }
    }

    public final void h() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (frsFragment = this.a) != null) {
            LikeModel likeModel = new LikeModel(frsFragment.getPageContext());
            this.c = likeModel;
            likeModel.setLoadDataCallBack(this.h);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            lb9 lb9Var = new lb9();
            this.d = lb9Var;
            lb9Var.a("from_frs");
            this.d.b(this.i);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            h();
            i();
        }
    }

    public void k() {
        LikeModel likeModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (likeModel = this.c) != null) {
            likeModel.f0();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            for (TBSpecificationBtn tBSpecificationBtn : this.b) {
                if (tBSpecificationBtn != null) {
                    tBSpecificationBtn.k();
                }
            }
        }
    }

    public void q() {
        FrsFragment frsFragment;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || (frsFragment = this.a) == null) {
            return;
        }
        zz4 zz4Var = new zz4(frsFragment.getActivity());
        FrsViewData W0 = this.a.W0();
        if (W0 != null && W0.getForum() != null && W0.getForum().getName() != null) {
            str = W0.getForum().getName();
        } else {
            str = "";
        }
        if (!StringUtils.isNull(str)) {
            zz4Var.setMessage(String.format(this.a.getString(R.string.attention_cancel_dialog_content), str));
        } else {
            zz4Var.setMessage(this.a.getString(R.string.obfuscated_res_0x7f0f02c0));
        }
        zz4Var.setPositiveButton(this.a.getString(R.string.editor_dialog_yes), new e(this));
        zz4Var.setNegativeButton(this.a.getString(R.string.editor_dialog_no), new f(this));
        zz4Var.create(this.a.n()).show();
    }
}

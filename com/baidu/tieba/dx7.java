package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.BdToastHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.dha;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.im.settingcache.OfficialSettingCache;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.LikeReturnData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.y45;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class dx7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public List<TBSpecificationBtn> b;
    public LikeModel c;
    public dha d;
    public boolean e;
    public AntiHelper.k f;
    public CustomMessageListener g;
    public i9 h;
    public dha.a i;

    /* loaded from: classes5.dex */
    public class a implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(dx7 dx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx7Var};
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
        public void onNavigationButtonClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, y45Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dx7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(dx7 dx7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx7Var, Integer.valueOf(i)};
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
            this.a = dx7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof LikeReturnData)) {
                this.a.f(customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends i9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dx7 a;

        public c(dx7 dx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dx7Var;
        }

        @Override // com.baidu.tieba.i9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, obj) != null) {
                return;
            }
            this.a.f(obj);
        }
    }

    /* loaded from: classes5.dex */
    public class d implements dha.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dx7 a;

        @Override // com.baidu.tieba.dha.a
        public void a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
            }
        }

        public d(dx7 dx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dx7Var;
        }

        @Override // com.baidu.tieba.dha.a
        public void b(String str, long j) {
            FrsViewData m1;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) && this.a.a != null && (m1 = this.a.a.m1()) != null && m1.getForum() != null) {
                String name = m1.getForum().getName();
                String id = m1.getForum().getId();
                if (j == JavaTypesHelper.toLong(id, 0L) && TextUtils.equals(name, str)) {
                    fx7 G0 = this.a.a.G0();
                    if (G0 != null) {
                        G0.v0(str);
                    }
                    m1.getForum().setLike(0);
                    if (G0 != null) {
                        G0.p0(0);
                    }
                    this.a.a.O5(Boolean.TRUE);
                    this.a.l(false, id);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003004, id));
                    LikeReturnData likeReturnData = new LikeReturnData();
                    likeReturnData.setLike(0);
                    likeReturnData.setFid(id);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, likeReturnData));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements y45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dx7 a;

        public e(dx7 dx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dx7Var;
        }

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                y45Var.dismiss();
                if (this.a.a != null && this.a.d != null) {
                    FrsViewData m1 = this.a.a.m1();
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (currentAccount != null && currentAccount.length() > 0) {
                        if (m1 != null && m1.getForum() != null) {
                            this.a.d.c(m1.getForum().getName(), JavaTypesHelper.toLong(m1.getForum().getId(), 0L));
                            return;
                        }
                        return;
                    }
                    TbadkCoreApplication.getInst().login(this.a.a.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.a.a.getActivity(), true, 11036)));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements y45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(dx7 dx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                y45Var.dismiss();
            }
        }
    }

    public dx7(FrsFragment frsFragment) {
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
            OfficialSettingCache.getInstance().saveAcceptNotifyAsync(TbadkCoreApplication.getCurrentAccount(), str, z, null);
            MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
        }
    }

    public void o(String str, String str2) {
        LikeModel likeModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048586, this, str, str2) == null) && (likeModel = this.c) != null) {
            likeModel.f0(str, str2, "FRS");
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
            likeModel.d0(z ? 1 : 0);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13605");
            FrsFragment frsFragment = this.a;
            if (frsFragment != null) {
                rs5.b(frsFragment.getContext(), statisticItem);
                bt7.b(statisticItem, this.a.w(), this.a.v());
            }
            bt7.a(statisticItem);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void f(Object obj) {
        FrsFragment frsFragment;
        FrsViewData m1;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) && (frsFragment = this.a) != null && (m1 = frsFragment.m1()) != null && m1.getForum() != null && obj != null) {
            if (AntiHelper.m(this.c.getErrorCode(), this.c.getErrorString())) {
                if (AntiHelper.t(this.a.getActivity(), this.c.b0(), this.f) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
                    return;
                }
                return;
            }
            String name = m1.getForum().getName();
            String id = m1.getForum().getId();
            LikeReturnData likeReturnData = null;
            if (obj instanceof LikeReturnData) {
                likeReturnData = (LikeReturnData) obj;
            }
            boolean z2 = false;
            if (likeReturnData != null && this.c.getErrorCode() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (likeReturnData.getErrorCode() == 3250013) {
                BdToast.makeText(TbadkCoreApplication.getInst().getContext(), likeReturnData.getErrorMsg()).setIcon(BdToast.ToastIcon.FAILURE).setDuration(3000).show();
            } else {
                z2 = z;
            }
            if (likeReturnData != null && z2) {
                fx7 G0 = this.a.G0();
                if (G0 != null) {
                    G0.v0(name);
                }
                likeReturnData.setLike(1);
                m1.updateLikeData(likeReturnData);
                m1.setLikeFeedForumDataList(likeReturnData.getFeedForumDataList());
                if (G0 != null) {
                    G0.D0(m1, this.e);
                    if (!ListUtils.isEmpty(likeReturnData.getRecommendForums())) {
                        G0.M0(likeReturnData.getRecommendForums());
                    }
                }
                this.e = true;
                FrsFragment frsFragment2 = this.a;
                if (frsFragment2 != null && (frsFragment2.getActivity() instanceof FrsActivity) && !BdToastHelper.canShowToast(likeReturnData.getToastData())) {
                    ((FrsActivity) this.a.getActivity()).w1().d(id);
                }
                l(true, id);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, likeReturnData));
                e();
            } else if (this.c.getErrorCode() == 22) {
                FrsFragment frsFragment3 = this.a;
                frsFragment3.showToast(frsFragment3.getString(R.string.had_liked_forum));
            } else {
                this.a.showToast(this.c.getErrorString());
            }
            this.a.H4(Boolean.valueOf(z2));
        }
    }

    public void p(boolean z) {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z) == null) && (frsFragment = this.a) != null && this.c != null) {
            FrsViewData m1 = frsFragment.m1();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (m1 != null && m1.getForum() != null) {
                    if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.a.getFrom())) {
                        TiebaStatic.log(new StatisticItem("c10356").param("fid", m1.getForum().getId()));
                    } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.a.getFrom())) {
                        TiebaStatic.log(new StatisticItem("c10590").param("obj_type", 2).param("fid", m1.getForum().getId()));
                    } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.a.getFrom())) {
                        TiebaStatic.log(new StatisticItem("c10587").param("obj_type", 2).param("fid", m1.getForum().getId()));
                    } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.a.getFrom())) {
                        TiebaStatic.log(new StatisticItem("c10578").param("obj_type", 2).param("fid", m1.getForum().getId()));
                    }
                    this.c.setFrom("recom_flist_like_frs");
                    if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.a.getFrom())) {
                        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                    } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.a.getFrom())) {
                        TiebaStatic.log(new StatisticItem("c10359").param("fid", m1.getForum().getId()));
                    }
                    this.c.f0(m1.getForum().getName(), m1.getForum().getId(), "FRS");
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
            dha dhaVar = new dha();
            this.d = dhaVar;
            dhaVar.a("from_frs");
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
            likeModel.a0();
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
        y45 y45Var = new y45(frsFragment.getActivity());
        FrsViewData m1 = this.a.m1();
        if (m1 != null && m1.getForum() != null && m1.getForum().getName() != null) {
            str = m1.getForum().getName();
        } else {
            str = "";
        }
        if (!StringUtils.isNull(str)) {
            y45Var.setMessage(String.format(this.a.getString(R.string.attention_cancel_dialog_content), str));
        } else {
            y45Var.setMessage(this.a.getString(R.string.obfuscated_res_0x7f0f02f0));
        }
        y45Var.setPositiveButton(this.a.getString(R.string.editor_dialog_yes), new e(this));
        y45Var.setNegativeButton(this.a.getString(R.string.editor_dialog_no), new f(this));
        y45Var.create(this.a.u()).show();
    }
}

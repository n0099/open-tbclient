package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.resourceLoader.BdResourceCallback;
import com.baidu.adp.lib.resourceLoader.BdResourceLoader;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.data.LoginDialogData;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tieba.f05;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.FrsPage.ActivityConfig;
import tbclient.ItemInfo;
/* loaded from: classes6.dex */
public class h78 implements lx7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public NoPressedRelativeLayout b;
    public p78 c;
    public t4b d;
    public qdb e;
    public OvalActionButton f;
    public rdb g;
    public final View.OnClickListener h;
    public final BdResourceCallback<BdImage> i;

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h78 a;

        public a(h78 h78Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h78Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h78Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.a.getPageContext().getPageActivity(), LoginDialogData.FRS_PUBLISH_RESULT_PAGE)) || this.a.d.c() || this.a.j() || WriteActivityConfig.isAsyncWriting()) {
                return;
            }
            if (this.a.c != null) {
                this.a.c.i();
            }
            if (!UbsABTestHelper.isNewWrite()) {
                this.a.A();
            } else {
                h78 h78Var = this.a;
                h78Var.u(h78Var.a.D4());
            }
            int i = 2;
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_HOME_WRITE_TEST_ICON_CLICK).param("obj_type", 2);
            if (!UbsABTestHelper.isNewWrite()) {
                i = 1;
            }
            TiebaStatic.log(param.param("obj_source", i));
            this.a.i();
        }
    }

    /* loaded from: classes6.dex */
    public class b extends BdResourceCallback<BdImage> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h78 a;

        public b(h78 h78Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h78Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h78Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.resourceLoader.BdResourceCallback
        public void onLoaded(BdImage bdImage, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, bdImage, str, i) == null) {
                super.onLoaded((b) bdImage, str, i);
                if (bdImage == null || !bdImage.isValidNow()) {
                    this.a.v();
                    return;
                }
                this.a.f.setImageDrawable(null);
                bdImage.drawImageTo(this.a.f);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements f05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(h78 h78Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h78Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.f05.e
        public void onClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, f05Var) != null) || f05Var == null) {
                return;
            }
            f05Var.dismiss();
        }
    }

    /* loaded from: classes6.dex */
    public class d implements f05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BlockPopInfoData a;
        public final /* synthetic */ h78 b;

        public d(h78 h78Var, BlockPopInfoData blockPopInfoData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h78Var, blockPopInfoData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h78Var;
            this.a = blockPopInfoData;
        }

        @Override // com.baidu.tieba.f05.e
        public void onClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                UrlManager.getInstance().dealOneLink(this.b.a.getPageContext(), new String[]{this.a.ahead_url});
                if (f05Var == null) {
                    return;
                }
                f05Var.dismiss();
            }
        }
    }

    public h78(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, noPressedRelativeLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = new a(this);
        this.i = new b(this);
        if (frsFragment != null && noPressedRelativeLayout != null) {
            this.a = frsFragment;
            this.b = noPressedRelativeLayout;
            this.d = new t4b(frsFragment.getPageContext());
            this.e = new qdb(this.a.getPageContext().getPageActivity(), "frs", 2, "2");
            s(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            BdResourceLoader.getInstance().loadResource(str, 10, this.i, this.a.getUniqueId());
        }
    }

    public void s(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            rdb rdbVar = this.g;
            if (rdbVar != null) {
                rdbVar.d(i);
            }
            qdb qdbVar = this.e;
            if (qdbVar != null) {
                qdbVar.i(i);
            }
            t4b t4bVar = this.d;
            if (t4bVar != null) {
                t4bVar.f();
            }
        }
    }

    public void w(OvalActionButton ovalActionButton) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048593, this, ovalActionButton) != null) || ovalActionButton == null) {
            return;
        }
        this.f = ovalActionButton;
        ovalActionButton.setOnClickListener(this.h);
        if (!k()) {
            v();
        }
    }

    public final void A() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (frsFragment = this.a) != null) {
            ForumWriteData D4 = frsFragment.D4();
            ItemInfo itemInfo = null;
            if (this.a.Q1() != null) {
                itemInfo = this.a.Q1().itemInfo;
            }
            if (this.e == null) {
                this.e = new qdb(this.a.getPageContext().getPageActivity(), "frs", 2, "2");
            }
            this.e.j(D4);
            this.e.l(l());
            this.e.k(itemInfo);
            this.e.m();
        }
    }

    public void B() {
        OvalActionButton ovalActionButton;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (ovalActionButton = this.f) != null) {
            ovalActionButton.performClick();
        }
    }

    @Override // com.baidu.tieba.lx7
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.d.c() || j()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final String l() {
        InterceptResult invokeV;
        FrsViewData Q1;
        ActivityConfig activityConfig;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            FrsFragment frsFragment = this.a;
            if (frsFragment == null || (Q1 = frsFragment.Q1()) == null || (activityConfig = Q1.activityConfig) == null) {
                return "";
            }
            return activityConfig.addthread_text;
        }
        return (String) invokeV.objValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            rdb rdbVar = this.g;
            if (rdbVar == null) {
                return false;
            }
            return rdbVar.b();
        }
        return invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            rdb rdbVar = this.g;
            if (rdbVar == null) {
                return false;
            }
            return rdbVar.b();
        }
        return invokeV.booleanValue;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            rdb rdbVar = this.g;
            if (rdbVar != null) {
                rdbVar.e();
            }
            p78 p78Var = this.c;
            if (p78Var != null) {
                p78Var.i();
            }
        }
    }

    public void q() {
        p78 p78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (p78Var = this.c) != null) {
            p78Var.i();
        }
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            rdb rdbVar = this.g;
            if (rdbVar != null && rdbVar.b()) {
                this.g.a(true);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f.setImageResource(0);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13604");
            FrsFragment frsFragment = this.a;
            if (frsFragment != null) {
                cp5.b(frsFragment.getContext(), statisticItem);
                a38.b(statisticItem, this.a.w(), this.a.v());
            }
            a38.a(statisticItem);
            TiebaStatic.log(statisticItem);
        }
    }

    public boolean j() {
        InterceptResult invokeV;
        FrsViewData Q1;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            FrsFragment frsFragment = this.a;
            if (frsFragment == null || (Q1 = frsFragment.Q1()) == null) {
                return false;
            }
            if (!ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                return true;
            }
            AntiData anti = Q1.getAnti();
            if (anti == null || !x(anti.getBlock_stat(), anti.mFrsForbidenDialogInfo)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        FrsViewData Q1;
        ActivityConfig activityConfig;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            FrsFragment frsFragment = this.a;
            if (frsFragment == null || (Q1 = frsFragment.Q1()) == null || (activityConfig = Q1.activityConfig) == null || activityConfig.type.intValue() != 2 || TextUtils.isEmpty(activityConfig.addthread_icon)) {
                return false;
            }
            o(activityConfig.addthread_icon);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void u(ForumWriteData forumWriteData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, forumWriteData) == null) && forumWriteData != null && !TextUtils.isEmpty(forumWriteData.forumId)) {
            WriteActivityConfig.newInstance(this.a.getActivity()).setType(9).setForumWriteData(forumWriteData).setFrom("frs").setTitle(l()).setCallFrom("2").setStatisticFrom(2).setIsWriteTest(true).setFromArticle(vdb.n).send();
        }
    }

    public final boolean x(int i, BlockPopInfoData blockPopInfoData) {
        InterceptResult invokeIL;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048594, this, i, blockPopInfoData)) == null) {
            if (blockPopInfoData == null || blockPopInfoData.can_post.intValue() == 1 || !TbadkCoreApplication.isLogin()) {
                return false;
            }
            if (StringUtils.isNull(blockPopInfoData.block_info)) {
                str = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f081b);
            } else {
                str = blockPopInfoData.block_info;
            }
            if (i != 1 && i != 2) {
                return false;
            }
            f05 f05Var = new f05(this.a.getPageContext().getPageActivity());
            f05Var.setMessage(StringHelper.getFixedText(str, 50, true));
            if (StringUtils.isNull(blockPopInfoData.ok_info)) {
                str2 = this.a.getResources().getString(R.string.group_create_private_isee);
            } else {
                str2 = blockPopInfoData.ok_info;
            }
            f05Var.setNegativeButton(StringHelper.getFixedText(str2, 4, true), new c(this));
            if (!StringUtils.isNull(blockPopInfoData.ahead_info) && !StringUtils.isNull(blockPopInfoData.ahead_url)) {
                f05Var.setPositiveButton(StringHelper.getFixedText(blockPopInfoData.ahead_info, 4, true), new d(this, blockPopInfoData));
            }
            f05Var.create(this.a.getPageContext()).show();
            return true;
        }
        return invokeIL.booleanValue;
    }

    public void y(View view2, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048595, this, view2, frsViewData) == null) && this.a != null && frsViewData != null && frsViewData.getForum() != null && frsViewData.postTopic != null) {
            if (this.c == null) {
                this.c = new p78(this.a.getActivity(), this);
            }
            this.c.i();
            this.c.j(view2, frsViewData);
        }
    }

    public void z(boolean z) {
        int i;
        FrsViewData Q1;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048596, this, z) == null) && this.f != null) {
            k();
            OvalActionButton ovalActionButton = this.f;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            ovalActionButton.setVisibility(i);
            if (z && TbadkCoreApplication.isLogin() && (Q1 = this.a.Q1()) != null && Q1.postTopic != null && Q1.getForum() != null && !StringUtils.isNull(Q1.getForum().getId()) && !StringUtils.isNull(Q1.postTopic.recom_title) && !StringUtils.isNull(Q1.postTopic.recom_topic) && ks7.d().c(Q1.getForum().getId(), Q1.postTopic.uniq_topicid.longValue())) {
                y(this.f, Q1);
            }
        }
    }
}

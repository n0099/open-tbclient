package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class fla {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final kka b;
    public final yka c;

    public fla(MainTabActivity mainTabActivity, kka kkaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, kkaVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = mainTabActivity;
        this.b = kkaVar;
        this.c = mainTabActivity.e;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            kka kkaVar = this.b;
            if (kkaVar != null && kkaVar.y() != null && this.b.y().getAnimationView() != null && this.b.y().getAnimationView().getVisibility() != 0) {
                this.b.y().setLottieView(false);
            }
            if (TbadkCoreApplication.getInst().getActivityPrizeData().isSwitchTurn()) {
                if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getInst().getActivityPrizeData().isUserSatisfy()) {
                    String h5Url = TbadkCoreApplication.getInst().getActivityPrizeData().getH5Url();
                    if (!StringUtils.isNull(h5Url)) {
                        SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
                        if (sharedPrefHelper.getBoolean("activity_prize_get_tip" + TbadkCoreApplication.getCurrentAccount(), true)) {
                            UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.a.getPageContext(), new String[]{h5Url}, true);
                            SharedPrefHelper sharedPrefHelper2 = SharedPrefHelper.getInstance();
                            sharedPrefHelper2.putBoolean("activity_prize_get_tip" + TbadkCoreApplication.getCurrentAccount(), false);
                        }
                    }
                }
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    String myTabText = TbadkCoreApplication.getInst().getActivityPrizeData().getMyTabText();
                    if (!StringUtils.isNull(myTabText)) {
                        kka kkaVar2 = this.b;
                        if (kkaVar2 != null) {
                            kkaVar2.Q(myTabText);
                        }
                    } else {
                        kka kkaVar3 = this.b;
                        if (kkaVar3 != null) {
                            kkaVar3.Q(null);
                        }
                    }
                } else {
                    kka kkaVar4 = this.b;
                    if (kkaVar4 != null) {
                        kkaVar4.Q(null);
                    }
                }
            } else {
                kka kkaVar5 = this.b;
                if (kkaVar5 != null) {
                    kkaVar5.Q(null);
                }
            }
            if (TbSingleton.getInstance().canShowPermDialog()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921360, this.b));
            }
            w05.b().l("1", "");
            yka ykaVar = this.c;
            if (ykaVar != null && ykaVar.i() != null) {
                this.c.i().a();
            }
        }
    }
}

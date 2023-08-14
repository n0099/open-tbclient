package com.baidu.tieba;

import android.content.Context;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.data.UserData;
import com.baidu.tieba.redtip.PersonRedTipManager;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ega extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ega(MainTabActivity mainTabActivity, iea ieaVar) {
        super(2001247);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, ieaVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = mainTabActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
            return;
        }
        UserData e = lk5.d().e();
        if (TbadkCoreApplication.isLogin() && e != null && e.getUserId() != null && !e.getUserId().equals(this.a.s) && e.getIsGodInvited()) {
            this.a.s = e.getUserId();
            BrowserHelper.startWebActivity((Context) this.a.getPageContext().getPageActivity(), "", TbWebViewActivityConfig.GOD_INVITE_JUMP_URL + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE, true);
        }
        if (!SharedPrefHelper.getInstance().getBoolean("key_new_god_invited_my_tab_red_tip_showed", false) && TbadkCoreApplication.isLogin() && e != null && e.getUserId() != null && !e.getUserId().equals(this.a.s) && e.getNewGodData() != null && e.getNewGodData().isNewGodInvited()) {
            PersonRedTipManager.getInstance().updateRedTipState(11, true, true);
            TiebaStatic.log(new StatisticItem("c13688").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_locate", 0));
            SharedPrefHelper.getInstance().putBoolean("key_new_god_invited_my_tab_red_tip_showed", true);
        }
    }
}

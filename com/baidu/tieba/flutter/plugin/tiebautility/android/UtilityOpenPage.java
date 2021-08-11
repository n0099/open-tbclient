package com.baidu.tieba.flutter.plugin.tiebautility.android;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.m.b;
import c.a.e.e.p.k;
import c.a.o0.e.f;
import c.a.o0.u.j;
import c.a.p0.u.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaPersonCenterActivityConfig;
import com.baidu.tbadk.core.atomData.SignAllForumActivityConfig;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tbadk.core.atomData.YoungsterPasswordActivityConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityOpenPageAuto;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class UtilityOpenPage implements TiebaUtilityOpenPageAuto.HostUtilityOpenPage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public UtilityOpenPage() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void doGoToActivityCenter() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            String missionEntranceUrl = TbSingleton.getInstance().getMissionEntranceUrl();
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity instanceof TbPageContextSupport) {
                UrlManager.getInstance().dealOneLink(((TbPageContextSupport) currentActivity).getPageContext(), new String[]{missionEntranceUrl});
            }
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityOpenPageAuto.HostUtilityOpenPage
    public void accessFollowService(TiebaUtilityOpenPageAuto.PageStringValue pageStringValue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pageStringValue) == null) {
            String result = pageStringValue.getResult();
            Uri parse = Uri.parse("?" + result);
            String queryParameter = parse.getQueryParameter("kUid");
            String queryParameter2 = parse.getQueryParameter("followType");
            if (TextUtils.isEmpty(queryParameter) || TextUtils.isEmpty(queryParameter2)) {
                return;
            }
            UpdateAttentionMessage.a aVar = new UpdateAttentionMessage.a();
            aVar.f47847a = true;
            aVar.f47850d = "1".equals(queryParameter2);
            aVar.f47849c = queryParameter;
            MessageManager.getInstance().dispatchResponsedMessage(new UpdateAttentionMessage(aVar));
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityOpenPageAuto.HostUtilityOpenPage
    public void accessLiveCenterService(TiebaUtilityOpenPageAuto.PageStringValue pageStringValue) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pageStringValue) == null) || TextUtils.isEmpty(pageStringValue.getResult())) {
            return;
        }
        Uri parse = Uri.parse(pageStringValue.getResult());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921545, new f(this, new AlaPersonCenterActivityConfig(TbadkCoreApplication.getInst(), parse.getQueryParameter("kUid"), parse.getQueryParameter(TbEnum.SystemMessage.KEY_USER_NAME), parse.getQueryParameter("portrait"), b.d(parse.getQueryParameter("sex"), 0), true)) { // from class: com.baidu.tieba.flutter.plugin.tiebautility.android.UtilityOpenPage.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ UtilityOpenPage this$0;
            public final /* synthetic */ AlaPersonCenterActivityConfig val$alaPersonCenterConfig;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, r7};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$alaPersonCenterConfig = r7;
            }

            @Override // c.a.o0.e.f
            public void onFail() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    onSwitchGet(false);
                }
            }

            @Override // c.a.o0.e.f
            public void onSwitchGet(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                    if (z) {
                        if (TbadkApplication.getInst().getCurrentActivity() instanceof TbPageContextSupport) {
                            UrlManager.getInstance().dealOneLink(((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext(), new String[]{UrlSchemaHelper.GO_TO_YY_PERSONAL_CENTER_PAGE});
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, this.val$alaPersonCenterConfig));
                }
            }
        }));
        TiebaStatic.log(CommonStatisticKey.KEY_PERSON_LIVE_TAB_CLICK);
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityOpenPageAuto.HostUtilityOpenPage
    public void accessWalletService(TiebaUtilityOpenPageAuto.PageStringValue pageStringValue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pageStringValue) == null) {
            String result = pageStringValue.getResult();
            if (StringUtils.isNull(result)) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2001447, result));
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityOpenPageAuto.HostUtilityOpenPage
    public void goToActivityCenter() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            doGoToActivityCenter();
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityOpenPageAuto.HostUtilityOpenPage
    public void goToGameCenter() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            doGoToActivityCenter();
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityOpenPageAuto.HostUtilityOpenPage
    public void goToMainTabRefresh(TiebaUtilityOpenPageAuto.ToWhereParam toWhereParam) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, toWhereParam) == null) || toWhereParam.getResult() == null) {
            return;
        }
        c.a.o0.s.a0.b.g(TbadkCoreApplication.getInst(), toWhereParam.getResult().intValue(), false);
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityOpenPageAuto.HostUtilityOpenPage
    public void goToSearch(TiebaUtilityOpenPageAuto.SearchParam searchParam) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, searchParam) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity instanceof TbPageContextSupport) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new SquareSearchActivityConfig(currentActivity, "", false, searchParam.getSearch(), searchParam.getSearchValue())));
            }
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityOpenPageAuto.HostUtilityOpenPage
    public void goToSendThread(TiebaUtilityOpenPageAuto.SendThreadParam sendThreadParam) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, sendThreadParam) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921452, new j(1)));
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.UBS_TEST_PUBLISH_BUTTON_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityOpenPageAuto.HostUtilityOpenPage
    public void goToSignIn(TiebaUtilityOpenPageAuto.SignInParam signInParam) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, signInParam) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity instanceof TbPageContextSupport) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(currentActivity)));
            }
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityOpenPageAuto.HostUtilityOpenPage
    public void goToTeenagerMode() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity instanceof TbPageContextSupport) {
                YoungsterPasswordActivityConfig youngsterPasswordActivityConfig = new YoungsterPasswordActivityConfig(currentActivity);
                youngsterPasswordActivityConfig.setYoungsterPasswordPageType(3);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, youngsterPasswordActivityConfig));
            }
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityOpenPageAuto.HostUtilityOpenPage
    public void openAppStore(TiebaUtilityOpenPageAuto.PageStringValue pageStringValue, TiebaUtilityOpenPageAuto.Result<TiebaUtilityOpenPageAuto.OpenPageBoolResult> result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, pageStringValue, result) == null) {
            TiebaUtilityOpenPageAuto.OpenPageBoolResult openPageBoolResult = new TiebaUtilityOpenPageAuto.OpenPageBoolResult();
            openPageBoolResult.setResult(Boolean.FALSE);
            result.success(openPageBoolResult);
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityOpenPageAuto.HostUtilityOpenPage
    public void openBBASMAppForItem(TiebaUtilityOpenPageAuto.SMAppMapParam sMAppMapParam) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, sMAppMapParam) == null) {
            HashMap result = sMAppMapParam.getResult();
            if (a.b((String) result.get("id"), (String) result.get("link"), "1191000600000000", Integer.valueOf(((Boolean) result.get("is_game")).booleanValue() ? 1 : 0)) || k.isEmpty((String) result.get("h5_url"))) {
                return;
            }
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity instanceof TbPageContextSupport) {
                UrlManager.getInstance().dealOneLink(((TbPageContextSupport) currentActivity).getPageContext(), new String[]{(String) result.get("h5_url")});
            }
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityOpenPageAuto.HostUtilityOpenPage
    public void openBBASMAppForUrl(TiebaUtilityOpenPageAuto.PageStringValue pageStringValue) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, pageStringValue) == null) || TextUtils.isEmpty(pageStringValue.getResult())) {
            return;
        }
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (currentActivity instanceof TbPageContextSupport) {
            UrlManager.getInstance().dealOneLink(((TbPageContextSupport) currentActivity).getPageContext(), new String[]{pageStringValue.getResult()});
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityOpenPageAuto.HostUtilityOpenPage
    public void postSignProcess(TiebaUtilityOpenPageAuto.SignProcessParam signProcessParam) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, signProcessParam) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity instanceof TbPageContextSupport) {
                c.a.o0.t.d.f.c().a(((TbPageContextSupport) currentActivity).getPageContext(), (ViewGroup) currentActivity.getWindow().getDecorView());
            }
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityOpenPageAuto.HostUtilityOpenPage
    public void redirectTo(TiebaUtilityOpenPageAuto.PageStringValue pageStringValue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, pageStringValue) == null) {
            String result = pageStringValue.getResult();
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (TextUtils.isEmpty(result) || !(currentActivity instanceof TbPageContextSupport)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(((TbPageContextSupport) currentActivity).getPageContext(), new String[]{result});
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityOpenPageAuto.HostUtilityOpenPage
    public void shareFrs(TiebaUtilityOpenPageAuto.PageStringValue pageStringValue) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, pageStringValue) == null) || TextUtils.isEmpty(pageStringValue.getResult())) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921463, pageStringValue.getResult()));
    }
}

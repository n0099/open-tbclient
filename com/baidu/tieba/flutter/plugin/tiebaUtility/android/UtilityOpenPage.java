package com.baidu.tieba.flutter.plugin.tiebaUtility.android;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaPersonCenterActivityConfig;
import com.baidu.tbadk.core.atomData.SignAllForumActivityConfig;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityOpenPageAuto;
import d.a.c.e.m.b;
import d.a.i0.d.f;
import d.a.i0.t.k;
import d.a.j0.s.a;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class UtilityOpenPage implements TiebaUtilityOpenPageAuto.HostUtilityOpenPage {
    private void doGoToActivityCenter() {
        String missionEntranceUrl = TbSingleton.getInstance().getMissionEntranceUrl();
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (currentActivity instanceof TbPageContextSupport) {
            UrlManager.getInstance().dealOneLink(((TbPageContextSupport) currentActivity).getPageContext(), new String[]{missionEntranceUrl});
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityOpenPageAuto.HostUtilityOpenPage
    public void accessLiveCenterService(TiebaUtilityOpenPageAuto.PageStringValue pageStringValue) {
        if (TextUtils.isEmpty(pageStringValue.getResult())) {
            return;
        }
        Uri parse = Uri.parse(pageStringValue.getResult());
        final AlaPersonCenterActivityConfig alaPersonCenterActivityConfig = new AlaPersonCenterActivityConfig(TbadkCoreApplication.getInst(), parse.getQueryParameter("kUid"), parse.getQueryParameter(TbEnum.SystemMessage.KEY_USER_NAME), parse.getQueryParameter("portrait"), b.d(parse.getQueryParameter("sex"), 0), true);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921545, new f() { // from class: com.baidu.tieba.flutter.plugin.tiebaUtility.android.UtilityOpenPage.1
            @Override // d.a.i0.d.f
            public void onFail() {
                onSwitchGet(false);
            }

            @Override // d.a.i0.d.f
            public void onSwitchGet(boolean z) {
                TbPageContextSupport tbPageContextSupport;
                if (z) {
                    if (!(TbadkApplication.getInst().getCurrentActivity() instanceof TbPageContextSupport) || (tbPageContextSupport = (TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()) == null) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink(tbPageContextSupport.getPageContext(), new String[]{UrlSchemaHelper.GO_TO_YY_PERSONAL_CENTER_PAGE});
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, alaPersonCenterActivityConfig));
            }
        }));
        TiebaStatic.log(CommonStatisticKey.KEY_PERSON_LIVE_TAB_CLICK);
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityOpenPageAuto.HostUtilityOpenPage
    public void accessWalletService(TiebaUtilityOpenPageAuto.PageStringValue pageStringValue) {
        String result = pageStringValue.getResult();
        if (StringUtils.isNull(result)) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2001447, result));
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityOpenPageAuto.HostUtilityOpenPage
    public void goToActivityCenter() {
        doGoToActivityCenter();
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityOpenPageAuto.HostUtilityOpenPage
    public void goToGameCenter() {
        doGoToActivityCenter();
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityOpenPageAuto.HostUtilityOpenPage
    public void goToMainTabRefresh(TiebaUtilityOpenPageAuto.ToWhereParam toWhereParam) {
        if (toWhereParam.getResult() == null) {
            return;
        }
        d.a.i0.r.a0.b.g(TbadkCoreApplication.getInst(), toWhereParam.getResult().intValue(), false);
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityOpenPageAuto.HostUtilityOpenPage
    public void goToSearch(TiebaUtilityOpenPageAuto.SearchParam searchParam) {
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (currentActivity instanceof TbPageContextSupport) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new SquareSearchActivityConfig(currentActivity, "", false, searchParam.getSearch(), searchParam.getSearchValue())));
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityOpenPageAuto.HostUtilityOpenPage
    public void goToSendThread(TiebaUtilityOpenPageAuto.SendThreadParam sendThreadParam) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921452, new k(1)));
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.UBS_TEST_PUBLISH_BUTTON_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityOpenPageAuto.HostUtilityOpenPage
    public void goToSignIn(TiebaUtilityOpenPageAuto.SignInParam signInParam) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(TbadkCoreApplication.getInst().getCurrentActivity())));
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityOpenPageAuto.HostUtilityOpenPage
    public void openAppStore(TiebaUtilityOpenPageAuto.PageStringValue pageStringValue, TiebaUtilityOpenPageAuto.Result<TiebaUtilityOpenPageAuto.OpenPageBoolResult> result) {
        TiebaUtilityOpenPageAuto.OpenPageBoolResult openPageBoolResult = new TiebaUtilityOpenPageAuto.OpenPageBoolResult();
        openPageBoolResult.setResult(Boolean.FALSE);
        result.success(openPageBoolResult);
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityOpenPageAuto.HostUtilityOpenPage
    public void openBBASMAppForItem(TiebaUtilityOpenPageAuto.SMAppMapParam sMAppMapParam) {
        HashMap result = sMAppMapParam.getResult();
        if (a.b((String) result.get("id"), (String) result.get("link"), "1191000600000000", Integer.valueOf(((Boolean) result.get("is_game")).booleanValue() ? 1 : 0)) || d.a.c.e.p.k.isEmpty((String) result.get("h5_url"))) {
            return;
        }
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (currentActivity instanceof TbPageContextSupport) {
            UrlManager.getInstance().dealOneLink(((TbPageContextSupport) currentActivity).getPageContext(), new String[]{(String) result.get("h5_url")});
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityOpenPageAuto.HostUtilityOpenPage
    public void openBBASMAppForUrl(TiebaUtilityOpenPageAuto.PageStringValue pageStringValue) {
        if (TextUtils.isEmpty(pageStringValue.getResult())) {
            return;
        }
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (currentActivity instanceof TbPageContextSupport) {
            UrlManager.getInstance().dealOneLink(((TbPageContextSupport) currentActivity).getPageContext(), new String[]{pageStringValue.getResult()});
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityOpenPageAuto.HostUtilityOpenPage
    public void postSignProcess(TiebaUtilityOpenPageAuto.SignProcessParam signProcessParam) {
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (currentActivity instanceof TbPageContextSupport) {
            d.a.i0.s.d.f.c().a(((TbPageContextSupport) currentActivity).getPageContext(), (ViewGroup) currentActivity.getWindow().getDecorView());
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityOpenPageAuto.HostUtilityOpenPage
    public void redirectTo(TiebaUtilityOpenPageAuto.PageStringValue pageStringValue) {
        String result = pageStringValue.getResult();
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (TextUtils.isEmpty(result) || !(currentActivity instanceof TbPageContextSupport)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(((TbPageContextSupport) currentActivity).getPageContext(), new String[]{result});
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityOpenPageAuto.HostUtilityOpenPage
    public void shareFrs(TiebaUtilityOpenPageAuto.PageStringValue pageStringValue) {
        if (TextUtils.isEmpty(pageStringValue.getResult())) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921463, pageStringValue.getResult()));
    }
}

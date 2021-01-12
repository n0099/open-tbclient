package com.baidu.tieba.im.forum.detail;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BarVoteActivityConfig;
import com.baidu.tbadk.core.atomData.CommonEmotionManagerActivityConfig;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ForumMemberActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.messageCenter.d;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.OfficialBarHistoryActivityConfig;
import com.baidu.tieba.im.forum.detail.BarEmotionResponseMessage;
import com.baidu.tieba.im.forum.detail.ForumDetailModel;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.SettingChangeMessage;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetForumDetail.BzApplySwitch;
import tbclient.GetForumDetail.ManagerApplyInfo;
import tbclient.GetForumDetail.ManagerElectionTab;
import tbclient.PriManagerApplyInfo;
import tbclient.RecommendForumInfo;
import tbclient.SimpleThreadInfo;
/* loaded from: classes7.dex */
public class ForumDetailActivity extends BaseActivity<ForumDetailActivity> implements BdSwitchView.a, ForumDetailModel.a {
    private ManagerApplyInfo applyInfo;
    private BzApplySwitch bzApplySwitch;
    private String fromType;
    private List<SimpleThreadInfo> jXR;
    private com.baidu.tieba.im.forum.detail.a kya;
    private ForumDetailModel kyb;
    private RecommendForumInfo kyc;
    private BarEmotionResponseMessage.ForumEmotionData kyf;
    private PriManagerApplyInfo kyg;
    private String mForumId;
    private ManagerElectionTab managerElectionTab;
    private boolean kyd = false;
    private boolean kye = false;
    public boolean kyh = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.forum_detail_activity);
        this.kya = new com.baidu.tieba.im.forum.detail.a(this);
        this.kya.cUt().a(new a());
        this.kya.h(new b());
        this.kyb = new ForumDetailModel(this);
        this.mForumId = getIntent().getStringExtra("forum_id");
        cFH();
        cUl();
    }

    private void cFH() {
        if (l.isNetOk()) {
            this.kya.showLoading();
            this.kyb.sendMessage(this.mForumId);
            this.kyb.Mg(this.mForumId);
            return;
        }
        this.kya.hideLoading();
        this.kya.CH(R.string.refresh_view_title_text);
        showToast(R.string.neterror);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        cFH();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.kya.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.kya.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.a
    public void Mf(String str) {
        this.kya.hideLoading();
        if (TextUtils.isEmpty(str)) {
            showToast(R.string.neterror);
        } else {
            showToast(str);
        }
        if (l.isNetOk()) {
            this.kya.CH(R.string.no_data_common_txt);
        } else {
            this.kya.CH(R.string.refresh_view_title_text);
        }
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.a
    public void a(ForumDetailSocketResponse forumDetailSocketResponse) {
        this.kyc = forumDetailSocketResponse.getForumInfo();
        this.jXR = forumDetailSocketResponse.getThreadInfoList();
        this.kyd = forumDetailSocketResponse.isBawuShow() == 1;
        this.kye = forumDetailSocketResponse.isComplaintShow();
        this.applyInfo = forumDetailSocketResponse.getApplyInfo();
        this.kyg = forumDetailSocketResponse.getPrivateApplyInfo();
        this.managerElectionTab = forumDetailSocketResponse.getManagerElectionTab();
        this.bzApplySwitch = forumDetailSocketResponse.getBzApplySwitch();
        cUk();
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.a
    public void a(ForumDetailHttpResponse forumDetailHttpResponse) {
        this.kyc = forumDetailHttpResponse.getForumInfo();
        this.jXR = forumDetailHttpResponse.getThreadInfoList();
        this.kyd = forumDetailHttpResponse.isBawuShow() == 1;
        this.kye = forumDetailHttpResponse.isComplaintShow();
        this.applyInfo = forumDetailHttpResponse.getApplyInfo();
        this.kyg = forumDetailHttpResponse.getPrivateApplyInfo();
        this.managerElectionTab = forumDetailHttpResponse.getManagerElectionTab();
        this.bzApplySwitch = forumDetailHttpResponse.getBzApplySwitch();
        cUk();
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.a
    public void a(BarEmotionResponseMessage barEmotionResponseMessage) {
        if (barEmotionResponseMessage != null) {
            this.kya.a(barEmotionResponseMessage.data);
            this.kyf = barEmotionResponseMessage.data;
        }
    }

    private void cUk() {
        this.kya.hideLoading();
        this.kya.hideNoDataView();
        if (this.kyc != null || (this.jXR != null && this.jXR.size() > 0)) {
            this.kyh = true;
            this.jXR = eB(this.jXR);
            this.kya.a(this.kyc, this.kyd, this.kye, this.applyInfo, this.kyg, this.managerElectionTab, this.bzApplySwitch);
            this.kya.bV(this.jXR);
            return;
        }
        this.kyh = false;
        this.kya.CH(R.string.no_data_common_txt);
    }

    private List<SimpleThreadInfo> eB(List<SimpleThreadInfo> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (SimpleThreadInfo simpleThreadInfo : list) {
            if (simpleThreadInfo != null) {
                if (i >= 5) {
                    break;
                }
                i++;
                arrayList.add(simpleThreadInfo);
            }
        }
        return arrayList;
    }

    public void clearHistory() {
        if (!TextUtils.isEmpty(this.mForumId)) {
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(this.mForumId), 4, null, 1)));
            sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_DEL_OFFICIAL_DB, String.valueOf(this.mForumId)));
        }
    }

    private void cUl() {
        this.fromType = getIntent().getStringExtra("from_type");
        if (!StringUtils.isNull(this.fromType)) {
            String str = "";
            if (this.fromType.equals(ForumDetailActivityConfig.FromType.FRS.toString())) {
                str = "frs_2_sub";
            } else if (this.fromType.equals(ForumDetailActivityConfig.FromType.BAR_DIR.toString()) || this.fromType.equals(ForumDetailActivityConfig.FromType.BAR_RANK.toString())) {
                str = "sq_2_sub";
            } else if (this.fromType.equals(ForumDetailActivityConfig.FromType.FRS_SIDE.toString())) {
                str = "side_2_sub";
            } else if (this.fromType.equals(ForumDetailActivityConfig.FromType.BAR.toString())) {
                str = "aio_side_2_sub";
            }
            if (!StringUtils.isNull(str)) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), str, "click", 1, new Object[0]);
            }
        }
    }

    public String bnj() {
        return this.fromType;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.bar_info_member_lay) {
            if (this.kyc != null && this.kyc.forum_id != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumMemberActivityConfig(getActivity(), String.valueOf(this.kyc.forum_id), this.kyc.forum_name)));
            }
        } else if (id == R.id.bar_info_clean_lay) {
            this.kya.cUs();
        } else if (id == R.id.bar_info_history_lay) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new OfficialBarHistoryActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toInt(this.mForumId, 0))));
        } else if (id == R.id.bar_info_emotion_layout) {
            if (!TbadkApplication.isLogin()) {
                TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_USE)));
            } else if (this.kyf != null && this.kyf.forum_pkg_status == 1 && !TextUtils.isEmpty(this.kyf.url) && this.kyc != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonEmotionManagerActivityConfig(getPageContext().getPageActivity(), this.kyf.url + "?forum_id=" + this.kyc.forum_id)));
            }
        } else if (id == R.id.bar_info_manager_lay) {
            if (this.kyc != null) {
                if (this.kyc.is_private_forum.intValue() == 0) {
                    be.bsB().b(getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/bawuindex?fn=" + this.kyc.forum_name + "&fid=" + this.kyc.forum_id});
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_BAR_DETAIL_CLICK));
                    return;
                }
                be.bsB().b(getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/pribawuindex?fid=" + this.kyc.forum_id + "&fn=" + this.kyc.forum_name + "&nomenu=1"});
            }
        } else if (id == R.id.bar_info_complaint_lay) {
            if (this.kyc != null) {
                be.bsB().b(getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/pritousu/complainforum?fid=" + this.kyc.forum_id + "&nomenu=1"});
            }
        } else if (id == R.id.bar_manager_apply_lay) {
            new aq("c13443").bsu();
            if (this.kyc != null && this.managerElectionTab != null) {
                int intValue = this.managerElectionTab.new_manager_status.intValue();
                if (intValue == 2) {
                    if (!TextUtils.isEmpty(this.managerElectionTab.new_strategy_link)) {
                        be.bsB().b(getPageContext(), new String[]{this.managerElectionTab.new_strategy_link});
                    }
                } else if (intValue == 3 || intValue == 4) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(this).createNormalConfig(this.kyc.forum_id.longValue(), 2)));
                } else if (intValue == 5) {
                    if (TextUtils.isEmpty(this.managerElectionTab.toast_text)) {
                        l.showToast(TbadkCoreApplication.getInst(), R.string.bar_election_finished);
                    } else {
                        l.showToast(TbadkCoreApplication.getInst(), this.managerElectionTab.toast_text);
                    }
                } else if (intValue == 1 && !TextUtils.isEmpty(this.managerElectionTab.toast_text)) {
                    l.showToast(TbadkCoreApplication.getInst(), this.managerElectionTab.toast_text);
                }
            }
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.OFF) {
            this.kyb.subscribeBar(false, this.mForumId);
        } else if (!d.bxM().bxO() || !d.bxM().bxU()) {
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.nu(R.string.error_open_personal_single_alloff);
            aVar.b(getResources().getString(R.string.signallforum_signnow), new a.b() { // from class: com.baidu.tieba.im.forum.detail.ForumDetailActivity.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                }
            });
            aVar.b(getPageContext());
            aVar.bqe();
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.im.forum.detail.ForumDetailActivity.2
                @Override // java.lang.Runnable
                public void run() {
                    ForumDetailActivity.this.kya.setSwitch(false);
                }
            }, 500L);
        } else {
            this.kyb.subscribeBar(true, this.mForumId);
        }
    }

    /* loaded from: classes7.dex */
    class a implements NoNetworkView.a {
        a() {
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (!ForumDetailActivity.this.kyh) {
                if (z) {
                    ForumDetailActivity.this.kya.hideNoDataView();
                    ForumDetailActivity.this.kya.showLoading();
                    ForumDetailActivity.this.kyb.sendMessage(ForumDetailActivity.this.mForumId);
                    return;
                }
                ForumDetailActivity.this.kya.hideLoading();
                ForumDetailActivity.this.kya.CH(R.string.refresh_view_title_text);
            }
        }
    }

    /* loaded from: classes7.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.isNetOk()) {
                ForumDetailActivity.this.kya.hideNoDataView();
                ForumDetailActivity.this.kya.showLoading();
                ForumDetailActivity.this.kyb.sendMessage(ForumDetailActivity.this.mForumId);
            }
        }
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.a
    public void sA(boolean z) {
        if (z) {
            showToast(R.string.success);
            sC(true);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "like_add ", "like_add", 1, new Object[0]);
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.im.forum.detail.ForumDetailActivity.3
            @Override // java.lang.Runnable
            public void run() {
                ForumDetailActivity.this.kya.setSwitch(false);
            }
        }, 500L);
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.a
    public void sB(boolean z) {
        if (z) {
            showToast(R.string.success);
            sC(false);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "like_cancel ", "like_canel", 1, new Object[0]);
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.im.forum.detail.ForumDetailActivity.4
            @Override // java.lang.Runnable
            public void run() {
                ForumDetailActivity.this.kya.setSwitch(true);
            }
        }, 500L);
    }

    public void sC(final boolean z) {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.im.forum.detail.ForumDetailActivity.5
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                if (!TextUtils.isEmpty(ForumDetailActivity.this.mForumId)) {
                    com.baidu.tieba.im.settingcache.d.cVV().D(TbadkApplication.getCurrentAccount(), String.valueOf(ForumDetailActivity.this.mForumId), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void setSwitch(boolean z) {
        this.kya.setSwitch(z);
    }

    public void sD(boolean z) {
        this.kya.a(this.kyc, z);
    }

    public void sE(boolean z) {
        this.kya.b(this.kyc, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 11003 && this.kyf != null && this.kyf.forum_pkg_status == 1 && !TextUtils.isEmpty(this.kyf.url) && this.kyc != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonEmotionManagerActivityConfig(getPageContext().getPageActivity(), this.kyf.url + "?forum_id=" + this.kyc.forum_id)));
        }
    }
}

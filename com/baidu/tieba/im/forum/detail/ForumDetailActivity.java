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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
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
/* loaded from: classes26.dex */
public class ForumDetailActivity extends BaseActivity<ForumDetailActivity> implements BdSwitchView.a, ForumDetailModel.a {
    private ManagerApplyInfo applyInfo;
    private BzApplySwitch bzApplySwitch;
    private String fromType;
    private List<SimpleThreadInfo> jPi;
    private com.baidu.tieba.im.forum.detail.a krQ;
    private ForumDetailModel krR;
    private RecommendForumInfo krS;
    private BarEmotionResponseMessage.ForumEmotionData krV;
    private PriManagerApplyInfo krW;
    private String mForumId;
    private ManagerElectionTab managerElectionTab;
    private boolean krT = false;
    private boolean krU = false;
    public boolean krX = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.forum_detail_activity);
        this.krQ = new com.baidu.tieba.im.forum.detail.a(this);
        this.krQ.cWO().a(new a());
        this.krQ.g(new b());
        this.krR = new ForumDetailModel(this);
        this.mForumId = getIntent().getStringExtra("forum_id");
        cGz();
        cWG();
    }

    private void cGz() {
        if (l.isNetOk()) {
            this.krQ.showLoading();
            this.krR.sendMessage(this.mForumId);
            this.krR.Nv(this.mForumId);
            return;
        }
        this.krQ.hideLoading();
        this.krQ.Ed(R.string.refresh_view_title_text);
        showToast(R.string.neterror);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        cGz();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.krQ.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.krQ.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.a
    public void Nu(String str) {
        this.krQ.hideLoading();
        if (TextUtils.isEmpty(str)) {
            showToast(R.string.neterror);
        } else {
            showToast(str);
        }
        if (l.isNetOk()) {
            this.krQ.Ed(R.string.no_data_common_txt);
        } else {
            this.krQ.Ed(R.string.refresh_view_title_text);
        }
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.a
    public void a(ForumDetailSocketResponse forumDetailSocketResponse) {
        this.krS = forumDetailSocketResponse.getForumInfo();
        this.jPi = forumDetailSocketResponse.getThreadInfoList();
        this.krT = forumDetailSocketResponse.isBawuShow() == 1;
        this.krU = forumDetailSocketResponse.isComplaintShow();
        this.applyInfo = forumDetailSocketResponse.getApplyInfo();
        this.krW = forumDetailSocketResponse.getPrivateApplyInfo();
        this.managerElectionTab = forumDetailSocketResponse.getManagerElectionTab();
        this.bzApplySwitch = forumDetailSocketResponse.getBzApplySwitch();
        cWF();
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.a
    public void a(ForumDetailHttpResponse forumDetailHttpResponse) {
        this.krS = forumDetailHttpResponse.getForumInfo();
        this.jPi = forumDetailHttpResponse.getThreadInfoList();
        this.krT = forumDetailHttpResponse.isBawuShow() == 1;
        this.krU = forumDetailHttpResponse.isComplaintShow();
        this.applyInfo = forumDetailHttpResponse.getApplyInfo();
        this.krW = forumDetailHttpResponse.getPrivateApplyInfo();
        this.managerElectionTab = forumDetailHttpResponse.getManagerElectionTab();
        this.bzApplySwitch = forumDetailHttpResponse.getBzApplySwitch();
        cWF();
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.a
    public void a(BarEmotionResponseMessage barEmotionResponseMessage) {
        if (barEmotionResponseMessage != null) {
            this.krQ.a(barEmotionResponseMessage.data);
            this.krV = barEmotionResponseMessage.data;
        }
    }

    private void cWF() {
        this.krQ.hideLoading();
        this.krQ.hideNoDataView();
        if (this.krS != null || (this.jPi != null && this.jPi.size() > 0)) {
            this.krX = true;
            this.jPi = eu(this.jPi);
            this.krQ.a(this.krS, this.krT, this.krU, this.applyInfo, this.krW, this.managerElectionTab, this.bzApplySwitch);
            this.krQ.bO(this.jPi);
            return;
        }
        this.krX = false;
        this.krQ.Ed(R.string.no_data_common_txt);
    }

    private List<SimpleThreadInfo> eu(List<SimpleThreadInfo> list) {
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

    private void cWG() {
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

    public String boB() {
        return this.fromType;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.bar_info_member_lay) {
            if (this.krS != null && this.krS.forum_id != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumMemberActivityConfig(getActivity(), String.valueOf(this.krS.forum_id), this.krS.forum_name)));
            }
        } else if (id == R.id.bar_info_clean_lay) {
            this.krQ.cWN();
        } else if (id == R.id.bar_info_history_lay) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new OfficialBarHistoryActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toInt(this.mForumId, 0))));
        } else if (id == R.id.bar_info_emotion_layout) {
            if (!TbadkApplication.isLogin()) {
                TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_USE)));
            } else if (this.krV != null && this.krV.forum_pkg_status == 1 && !TextUtils.isEmpty(this.krV.url) && this.krS != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonEmotionManagerActivityConfig(getPageContext().getPageActivity(), this.krV.url + "?forum_id=" + this.krS.forum_id)));
            }
        } else if (id == R.id.bar_info_manager_lay) {
            if (this.krS != null) {
                if (this.krS.is_private_forum.intValue() == 0) {
                    bf.bua().b(getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/bawuindex?fn=" + this.krS.forum_name + "&fid=" + this.krS.forum_id});
                    TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_BAR_DETAIL_CLICK));
                    return;
                }
                bf.bua().b(getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/pribawuindex?fid=" + this.krS.forum_id + "&fn=" + this.krS.forum_name + "&nomenu=1"});
            }
        } else if (id == R.id.bar_info_complaint_lay) {
            if (this.krS != null) {
                bf.bua().b(getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/pritousu/complainforum?fid=" + this.krS.forum_id + "&nomenu=1"});
            }
        } else if (id == R.id.bar_manager_apply_lay) {
            new ar("c13443").btT();
            if (this.krS != null && this.managerElectionTab != null) {
                int intValue = this.managerElectionTab.new_manager_status.intValue();
                if (intValue == 2) {
                    if (!TextUtils.isEmpty(this.managerElectionTab.new_strategy_link)) {
                        bf.bua().b(getPageContext(), new String[]{this.managerElectionTab.new_strategy_link});
                    }
                } else if (intValue == 3 || intValue == 4) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(this).createNormalConfig(this.krS.forum_id.longValue(), 2)));
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
            this.krR.subscribeBar(false, this.mForumId);
        } else if (!d.bzl().bzn() || !d.bzl().bzt()) {
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.oQ(R.string.error_open_personal_single_alloff);
            aVar.b(getResources().getString(R.string.signallforum_signnow), new a.b() { // from class: com.baidu.tieba.im.forum.detail.ForumDetailActivity.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                }
            });
            aVar.b(getPageContext());
            aVar.brv();
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.im.forum.detail.ForumDetailActivity.2
                @Override // java.lang.Runnable
                public void run() {
                    ForumDetailActivity.this.krQ.setSwitch(false);
                }
            }, 500L);
        } else {
            this.krR.subscribeBar(true, this.mForumId);
        }
    }

    /* loaded from: classes26.dex */
    class a implements NoNetworkView.a {
        a() {
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (!ForumDetailActivity.this.krX) {
                if (z) {
                    ForumDetailActivity.this.krQ.hideNoDataView();
                    ForumDetailActivity.this.krQ.showLoading();
                    ForumDetailActivity.this.krR.sendMessage(ForumDetailActivity.this.mForumId);
                    return;
                }
                ForumDetailActivity.this.krQ.hideLoading();
                ForumDetailActivity.this.krQ.Ed(R.string.refresh_view_title_text);
            }
        }
    }

    /* loaded from: classes26.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.isNetOk()) {
                ForumDetailActivity.this.krQ.hideNoDataView();
                ForumDetailActivity.this.krQ.showLoading();
                ForumDetailActivity.this.krR.sendMessage(ForumDetailActivity.this.mForumId);
            }
        }
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.a
    public void sp(boolean z) {
        if (z) {
            showToast(R.string.success);
            sr(true);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "like_add ", "like_add", 1, new Object[0]);
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.im.forum.detail.ForumDetailActivity.3
            @Override // java.lang.Runnable
            public void run() {
                ForumDetailActivity.this.krQ.setSwitch(false);
            }
        }, 500L);
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.a
    public void sq(boolean z) {
        if (z) {
            showToast(R.string.success);
            sr(false);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "like_cancel ", "like_canel", 1, new Object[0]);
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.im.forum.detail.ForumDetailActivity.4
            @Override // java.lang.Runnable
            public void run() {
                ForumDetailActivity.this.krQ.setSwitch(true);
            }
        }, 500L);
    }

    public void sr(final boolean z) {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.im.forum.detail.ForumDetailActivity.5
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                if (!TextUtils.isEmpty(ForumDetailActivity.this.mForumId)) {
                    com.baidu.tieba.im.settingcache.d.cZZ().B(TbadkApplication.getCurrentAccount(), String.valueOf(ForumDetailActivity.this.mForumId), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void setSwitch(boolean z) {
        this.krQ.setSwitch(z);
    }

    public void ss(boolean z) {
        this.krQ.a(this.krS, z);
    }

    public void st(boolean z) {
        this.krQ.b(this.krS, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 11003 && this.krV != null && this.krV.forum_pkg_status == 1 && !TextUtils.isEmpty(this.krV.url) && this.krS != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonEmotionManagerActivityConfig(getPageContext().getPageActivity(), this.krV.url + "?forum_id=" + this.krS.forum_id)));
        }
    }
}

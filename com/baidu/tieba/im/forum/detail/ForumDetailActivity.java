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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
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
/* loaded from: classes11.dex */
public class ForumDetailActivity extends BaseActivity<ForumDetailActivity> implements BdSwitchView.a, ForumDetailModel.a {
    private ManagerApplyInfo applyInfo;
    private BzApplySwitch bzApplySwitch;
    private String fromType;
    private List<SimpleThreadInfo> gZg;
    private com.baidu.tieba.im.forum.detail.a hwl;
    private ForumDetailModel hwm;
    private RecommendForumInfo hwn;
    private BarEmotionResponseMessage.ForumEmotionData hwq;
    private PriManagerApplyInfo hwr;
    private String mForumId;
    private ManagerElectionTab managerElectionTab;
    private boolean hwo = false;
    private boolean hwp = false;
    public boolean hws = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.forum_detail_activity);
        this.hwl = new com.baidu.tieba.im.forum.detail.a(this);
        this.hwl.bTq().a(new a());
        this.hwl.f(new b());
        this.hwm = new ForumDetailModel(this);
        this.mForumId = getIntent().getStringExtra("forum_id");
        bTg();
        bTi();
    }

    private void bTg() {
        if (l.isNetOk()) {
            this.hwl.showLoading();
            this.hwm.sendMessage(this.mForumId);
            this.hwm.CL(this.mForumId);
            return;
        }
        this.hwl.hideLoading();
        this.hwl.wi(R.string.refresh_view_title_text);
        showToast(R.string.neterror);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        bTg();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.hwl.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.hwl.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.a
    public void CK(String str) {
        this.hwl.hideLoading();
        if (TextUtils.isEmpty(str)) {
            showToast(R.string.neterror);
        } else {
            showToast(str);
        }
        if (l.isNetOk()) {
            this.hwl.wi(R.string.no_data_common_txt);
        } else {
            this.hwl.wi(R.string.refresh_view_title_text);
        }
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.a
    public void a(ForumDetailSocketResponse forumDetailSocketResponse) {
        this.hwn = forumDetailSocketResponse.getForumInfo();
        this.gZg = forumDetailSocketResponse.getThreadInfoList();
        this.hwo = forumDetailSocketResponse.isBawuShow() == 1;
        this.hwp = forumDetailSocketResponse.isComplaintShow();
        this.applyInfo = forumDetailSocketResponse.getApplyInfo();
        this.hwr = forumDetailSocketResponse.getPrivateApplyInfo();
        this.managerElectionTab = forumDetailSocketResponse.getManagerElectionTab();
        this.bzApplySwitch = forumDetailSocketResponse.getBzApplySwitch();
        bTh();
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.a
    public void a(ForumDetailHttpResponse forumDetailHttpResponse) {
        this.hwn = forumDetailHttpResponse.getForumInfo();
        this.gZg = forumDetailHttpResponse.getThreadInfoList();
        this.hwo = forumDetailHttpResponse.isBawuShow() == 1;
        this.hwp = forumDetailHttpResponse.isComplaintShow();
        this.applyInfo = forumDetailHttpResponse.getApplyInfo();
        this.hwr = forumDetailHttpResponse.getPrivateApplyInfo();
        this.managerElectionTab = forumDetailHttpResponse.getManagerElectionTab();
        this.bzApplySwitch = forumDetailHttpResponse.getBzApplySwitch();
        bTh();
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.a
    public void a(BarEmotionResponseMessage barEmotionResponseMessage) {
        if (barEmotionResponseMessage != null) {
            this.hwl.a(barEmotionResponseMessage.data);
            this.hwq = barEmotionResponseMessage.data;
        }
    }

    private void bTh() {
        this.hwl.hideLoading();
        this.hwl.hideNoDataView();
        if (this.hwn != null || (this.gZg != null && this.gZg.size() > 0)) {
            this.hws = true;
            this.gZg = cZ(this.gZg);
            this.hwl.a(this.hwn, this.hwo, this.hwp, this.applyInfo, this.hwr, this.managerElectionTab, this.bzApplySwitch);
            this.hwl.aT(this.gZg);
            return;
        }
        this.hws = false;
        this.hwl.wi(R.string.no_data_common_txt);
    }

    private List<SimpleThreadInfo> cZ(List<SimpleThreadInfo> list) {
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

    private void bTi() {
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

    public String azJ() {
        return this.fromType;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.bar_info_member_lay) {
            if (this.hwn != null && this.hwn.forum_id != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumMemberActivityConfig(getActivity(), String.valueOf(this.hwn.forum_id), this.hwn.forum_name)));
            }
        } else if (id == R.id.bar_info_clean_lay) {
            this.hwl.bTp();
        } else if (id == R.id.bar_info_history_lay) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new OfficialBarHistoryActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toInt(this.mForumId, 0))));
        } else if (id == R.id.bar_info_emotion_layout) {
            if (!TbadkApplication.isLogin()) {
                TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11003)));
            } else if (this.hwq != null && this.hwq.forum_pkg_status == 1 && !TextUtils.isEmpty(this.hwq.url) && this.hwn != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonEmotionManagerActivityConfig(getPageContext().getPageActivity(), this.hwq.url + "?forum_id=" + this.hwn.forum_id)));
            }
        } else if (id == R.id.bar_info_manager_lay) {
            if (this.hwn != null) {
                if (this.hwn.is_private_forum.intValue() == 0) {
                    ba.aEt().b(getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/bawuindex?fn=" + this.hwn.forum_name + "&fid=" + this.hwn.forum_id});
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_BAR_DETAIL_CLICK));
                    return;
                }
                ba.aEt().b(getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/pribawuindex?fid=" + this.hwn.forum_id + "&fn=" + this.hwn.forum_name + "&nomenu=1"});
            }
        } else if (id == R.id.bar_info_complaint_lay) {
            if (this.hwn != null) {
                ba.aEt().b(getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/pritousu/complainforum?fid=" + this.hwn.forum_id + "&nomenu=1"});
            }
        } else if (id == R.id.bar_manager_apply_lay) {
            new an("c13443").aEm();
            if (this.hwn != null && this.managerElectionTab != null) {
                int intValue = this.managerElectionTab.new_manager_status.intValue();
                if (intValue == 2) {
                    if (!TextUtils.isEmpty(this.managerElectionTab.new_strategy_link)) {
                        ba.aEt().b(getPageContext(), new String[]{this.managerElectionTab.new_strategy_link});
                    }
                } else if (intValue == 3 || intValue == 4) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(this).createNormalConfig(this.hwn.forum_id.longValue(), 2)));
                } else if (intValue == 5) {
                    if (TextUtils.isEmpty(this.managerElectionTab.toast_text)) {
                        l.showToast(TbadkCoreApplication.getInst(), (int) R.string.bar_election_finished);
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
            this.hwm.subscribeBar(false, this.mForumId);
        } else if (!d.aIQ().aIS() || !d.aIQ().aIY()) {
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.jF(R.string.error_open_personal_single_alloff);
            aVar.b(getResources().getString(R.string.signallforum_signnow), new a.b() { // from class: com.baidu.tieba.im.forum.detail.ForumDetailActivity.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                }
            });
            aVar.b(getPageContext());
            aVar.aCp();
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.im.forum.detail.ForumDetailActivity.2
                @Override // java.lang.Runnable
                public void run() {
                    ForumDetailActivity.this.hwl.setSwitch(false);
                }
            }, 500L);
        } else {
            this.hwm.subscribeBar(true, this.mForumId);
        }
    }

    /* loaded from: classes11.dex */
    class a implements NoNetworkView.a {
        a() {
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (!ForumDetailActivity.this.hws) {
                if (z) {
                    ForumDetailActivity.this.hwl.hideNoDataView();
                    ForumDetailActivity.this.hwl.showLoading();
                    ForumDetailActivity.this.hwm.sendMessage(ForumDetailActivity.this.mForumId);
                    return;
                }
                ForumDetailActivity.this.hwl.hideLoading();
                ForumDetailActivity.this.hwl.wi(R.string.refresh_view_title_text);
            }
        }
    }

    /* loaded from: classes11.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.isNetOk()) {
                ForumDetailActivity.this.hwl.hideNoDataView();
                ForumDetailActivity.this.hwl.showLoading();
                ForumDetailActivity.this.hwm.sendMessage(ForumDetailActivity.this.mForumId);
            }
        }
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.a
    public void no(boolean z) {
        if (z) {
            showToast(R.string.success);
            nq(true);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "like_add ", "like_add", 1, new Object[0]);
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.im.forum.detail.ForumDetailActivity.3
            @Override // java.lang.Runnable
            public void run() {
                ForumDetailActivity.this.hwl.setSwitch(false);
            }
        }, 500L);
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.a
    public void np(boolean z) {
        if (z) {
            showToast(R.string.success);
            nq(false);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "like_cancel ", "like_canel", 1, new Object[0]);
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.im.forum.detail.ForumDetailActivity.4
            @Override // java.lang.Runnable
            public void run() {
                ForumDetailActivity.this.hwl.setSwitch(true);
            }
        }, 500L);
    }

    public void nq(final boolean z) {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.im.forum.detail.ForumDetailActivity.5
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                if (!TextUtils.isEmpty(ForumDetailActivity.this.mForumId)) {
                    com.baidu.tieba.im.settingcache.d.bWy().x(TbadkApplication.getCurrentAccount(), String.valueOf(ForumDetailActivity.this.mForumId), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void setSwitch(boolean z) {
        this.hwl.setSwitch(z);
    }

    public void nr(boolean z) {
        this.hwl.a(this.hwn, z);
    }

    public void ns(boolean z) {
        this.hwl.b(this.hwn, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 11003 && this.hwq != null && this.hwq.forum_pkg_status == 1 && !TextUtils.isEmpty(this.hwq.url) && this.hwn != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonEmotionManagerActivityConfig(getPageContext().getPageActivity(), this.hwq.url + "?forum_id=" + this.hwn.forum_id)));
        }
    }
}

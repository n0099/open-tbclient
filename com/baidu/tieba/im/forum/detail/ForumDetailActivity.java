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
/* loaded from: classes26.dex */
public class ForumDetailActivity extends BaseActivity<ForumDetailActivity> implements BdSwitchView.a, ForumDetailModel.a {
    private ManagerApplyInfo applyInfo;
    private BzApplySwitch bzApplySwitch;
    private String fromType;
    private List<SimpleThreadInfo> jAI;
    private com.baidu.tieba.im.forum.detail.a kdF;
    private ForumDetailModel kdG;
    private RecommendForumInfo kdH;
    private BarEmotionResponseMessage.ForumEmotionData kdK;
    private PriManagerApplyInfo kdL;
    private String mForumId;
    private ManagerElectionTab managerElectionTab;
    private boolean kdI = false;
    private boolean kdJ = false;
    public boolean kdM = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.forum_detail_activity);
        this.kdF = new com.baidu.tieba.im.forum.detail.a(this);
        this.kdF.cRV().a(new a());
        this.kdF.g(new b());
        this.kdG = new ForumDetailModel(this);
        this.mForumId = getIntent().getStringExtra("forum_id");
        cRL();
        cRN();
    }

    private void cRL() {
        if (l.isNetOk()) {
            this.kdF.showLoading();
            this.kdG.sendMessage(this.mForumId);
            this.kdG.MM(this.mForumId);
            return;
        }
        this.kdF.hideLoading();
        this.kdF.CQ(R.string.refresh_view_title_text);
        showToast(R.string.neterror);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        cRL();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.kdF.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.kdF.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.a
    public void ML(String str) {
        this.kdF.hideLoading();
        if (TextUtils.isEmpty(str)) {
            showToast(R.string.neterror);
        } else {
            showToast(str);
        }
        if (l.isNetOk()) {
            this.kdF.CQ(R.string.no_data_common_txt);
        } else {
            this.kdF.CQ(R.string.refresh_view_title_text);
        }
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.a
    public void a(ForumDetailSocketResponse forumDetailSocketResponse) {
        this.kdH = forumDetailSocketResponse.getForumInfo();
        this.jAI = forumDetailSocketResponse.getThreadInfoList();
        this.kdI = forumDetailSocketResponse.isBawuShow() == 1;
        this.kdJ = forumDetailSocketResponse.isComplaintShow();
        this.applyInfo = forumDetailSocketResponse.getApplyInfo();
        this.kdL = forumDetailSocketResponse.getPrivateApplyInfo();
        this.managerElectionTab = forumDetailSocketResponse.getManagerElectionTab();
        this.bzApplySwitch = forumDetailSocketResponse.getBzApplySwitch();
        cRM();
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.a
    public void a(ForumDetailHttpResponse forumDetailHttpResponse) {
        this.kdH = forumDetailHttpResponse.getForumInfo();
        this.jAI = forumDetailHttpResponse.getThreadInfoList();
        this.kdI = forumDetailHttpResponse.isBawuShow() == 1;
        this.kdJ = forumDetailHttpResponse.isComplaintShow();
        this.applyInfo = forumDetailHttpResponse.getApplyInfo();
        this.kdL = forumDetailHttpResponse.getPrivateApplyInfo();
        this.managerElectionTab = forumDetailHttpResponse.getManagerElectionTab();
        this.bzApplySwitch = forumDetailHttpResponse.getBzApplySwitch();
        cRM();
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.a
    public void a(BarEmotionResponseMessage barEmotionResponseMessage) {
        if (barEmotionResponseMessage != null) {
            this.kdF.a(barEmotionResponseMessage.data);
            this.kdK = barEmotionResponseMessage.data;
        }
    }

    private void cRM() {
        this.kdF.hideLoading();
        this.kdF.hideNoDataView();
        if (this.kdH != null || (this.jAI != null && this.jAI.size() > 0)) {
            this.kdM = true;
            this.jAI = ej(this.jAI);
            this.kdF.a(this.kdH, this.kdI, this.kdJ, this.applyInfo, this.kdL, this.managerElectionTab, this.bzApplySwitch);
            this.kdF.bK(this.jAI);
            return;
        }
        this.kdM = false;
        this.kdF.CQ(R.string.no_data_common_txt);
    }

    private List<SimpleThreadInfo> ej(List<SimpleThreadInfo> list) {
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

    private void cRN() {
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

    public String bmm() {
        return this.fromType;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.bar_info_member_lay) {
            if (this.kdH != null && this.kdH.forum_id != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumMemberActivityConfig(getActivity(), String.valueOf(this.kdH.forum_id), this.kdH.forum_name)));
            }
        } else if (id == R.id.bar_info_clean_lay) {
            this.kdF.cRU();
        } else if (id == R.id.bar_info_history_lay) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new OfficialBarHistoryActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toInt(this.mForumId, 0))));
        } else if (id == R.id.bar_info_emotion_layout) {
            if (!TbadkApplication.isLogin()) {
                TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_USE)));
            } else if (this.kdK != null && this.kdK.forum_pkg_status == 1 && !TextUtils.isEmpty(this.kdK.url) && this.kdH != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonEmotionManagerActivityConfig(getPageContext().getPageActivity(), this.kdK.url + "?forum_id=" + this.kdH.forum_id)));
            }
        } else if (id == R.id.bar_info_manager_lay) {
            if (this.kdH != null) {
                if (this.kdH.is_private_forum.intValue() == 0) {
                    be.brr().b(getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/bawuindex?fn=" + this.kdH.forum_name + "&fid=" + this.kdH.forum_id});
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_BAR_DETAIL_CLICK));
                    return;
                }
                be.brr().b(getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/pribawuindex?fid=" + this.kdH.forum_id + "&fn=" + this.kdH.forum_name + "&nomenu=1"});
            }
        } else if (id == R.id.bar_info_complaint_lay) {
            if (this.kdH != null) {
                be.brr().b(getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/pritousu/complainforum?fid=" + this.kdH.forum_id + "&nomenu=1"});
            }
        } else if (id == R.id.bar_manager_apply_lay) {
            new aq("c13443").brk();
            if (this.kdH != null && this.managerElectionTab != null) {
                int intValue = this.managerElectionTab.new_manager_status.intValue();
                if (intValue == 2) {
                    if (!TextUtils.isEmpty(this.managerElectionTab.new_strategy_link)) {
                        be.brr().b(getPageContext(), new String[]{this.managerElectionTab.new_strategy_link});
                    }
                } else if (intValue == 3 || intValue == 4) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(this).createNormalConfig(this.kdH.forum_id.longValue(), 2)));
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
            this.kdG.subscribeBar(false, this.mForumId);
        } else if (!d.bwv().bwx() || !d.bwv().bwD()) {
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.ow(R.string.error_open_personal_single_alloff);
            aVar.b(getResources().getString(R.string.signallforum_signnow), new a.b() { // from class: com.baidu.tieba.im.forum.detail.ForumDetailActivity.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                }
            });
            aVar.b(getPageContext());
            aVar.bpc();
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.im.forum.detail.ForumDetailActivity.2
                @Override // java.lang.Runnable
                public void run() {
                    ForumDetailActivity.this.kdF.setSwitch(false);
                }
            }, 500L);
        } else {
            this.kdG.subscribeBar(true, this.mForumId);
        }
    }

    /* loaded from: classes26.dex */
    class a implements NoNetworkView.a {
        a() {
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (!ForumDetailActivity.this.kdM) {
                if (z) {
                    ForumDetailActivity.this.kdF.hideNoDataView();
                    ForumDetailActivity.this.kdF.showLoading();
                    ForumDetailActivity.this.kdG.sendMessage(ForumDetailActivity.this.mForumId);
                    return;
                }
                ForumDetailActivity.this.kdF.hideLoading();
                ForumDetailActivity.this.kdF.CQ(R.string.refresh_view_title_text);
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
                ForumDetailActivity.this.kdF.hideNoDataView();
                ForumDetailActivity.this.kdF.showLoading();
                ForumDetailActivity.this.kdG.sendMessage(ForumDetailActivity.this.mForumId);
            }
        }
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.a
    public void rK(boolean z) {
        if (z) {
            showToast(R.string.success);
            rM(true);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "like_add ", "like_add", 1, new Object[0]);
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.im.forum.detail.ForumDetailActivity.3
            @Override // java.lang.Runnable
            public void run() {
                ForumDetailActivity.this.kdF.setSwitch(false);
            }
        }, 500L);
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.a
    public void rL(boolean z) {
        if (z) {
            showToast(R.string.success);
            rM(false);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "like_cancel ", "like_canel", 1, new Object[0]);
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.im.forum.detail.ForumDetailActivity.4
            @Override // java.lang.Runnable
            public void run() {
                ForumDetailActivity.this.kdF.setSwitch(true);
            }
        }, 500L);
    }

    public void rM(final boolean z) {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.im.forum.detail.ForumDetailActivity.5
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                if (!TextUtils.isEmpty(ForumDetailActivity.this.mForumId)) {
                    com.baidu.tieba.im.settingcache.d.cVg().A(TbadkApplication.getCurrentAccount(), String.valueOf(ForumDetailActivity.this.mForumId), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void setSwitch(boolean z) {
        this.kdF.setSwitch(z);
    }

    public void rN(boolean z) {
        this.kdF.a(this.kdH, z);
    }

    public void rO(boolean z) {
        this.kdF.b(this.kdH, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 11003 && this.kdK != null && this.kdK.forum_pkg_status == 1 && !TextUtils.isEmpty(this.kdK.url) && this.kdH != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonEmotionManagerActivityConfig(getPageContext().getPageActivity(), this.kdK.url + "?forum_id=" + this.kdH.forum_id)));
        }
    }
}

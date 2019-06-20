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
import com.baidu.tbadk.core.util.am;
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
/* loaded from: classes3.dex */
public class ForumDetailActivity extends BaseActivity<ForumDetailActivity> implements BdSwitchView.a, ForumDetailModel.a {
    private ManagerApplyInfo applyInfo;
    private BzApplySwitch bzApplySwitch;
    private String fromType;
    private com.baidu.tieba.im.forum.detail.a gyD;
    private ForumDetailModel gyE;
    private RecommendForumInfo gyF;
    private List<SimpleThreadInfo> gyG;
    private BarEmotionResponseMessage.ForumEmotionData gyJ;
    private PriManagerApplyInfo gyK;
    private String mForumId;
    private ManagerElectionTab managerElectionTab;
    private boolean gyH = false;
    private boolean gyI = false;
    public boolean gyL = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.forum_detail_activity);
        this.gyD = new com.baidu.tieba.im.forum.detail.a(this);
        this.gyD.bAD().a(new a());
        this.gyD.d(new b());
        this.gyE = new ForumDetailModel(this);
        this.mForumId = getIntent().getStringExtra("forum_id");
        bAs();
        bAu();
    }

    private void bAs() {
        if (l.ki()) {
            this.gyD.showLoading();
            this.gyE.sendMessage(this.mForumId);
            this.gyE.yp(this.mForumId);
            return;
        }
        this.gyD.boN();
        this.gyD.oH(R.string.game_index_no_network_text);
        showToast(R.string.neterror);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        bAs();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.gyD.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gyD.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.a
    public void yo(String str) {
        this.gyD.boN();
        if (TextUtils.isEmpty(str)) {
            showToast(R.string.neterror);
        } else {
            showToast(str);
        }
        if (l.ki()) {
            this.gyD.oH(R.string.no_data_text);
        } else {
            this.gyD.oH(R.string.game_index_no_network_text);
        }
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.a
    public void a(ForumDetailSocketResponse forumDetailSocketResponse) {
        this.gyF = forumDetailSocketResponse.getForumInfo();
        this.gyG = forumDetailSocketResponse.getThreadInfoList();
        this.gyH = forumDetailSocketResponse.isBawuShow() == 1;
        this.gyI = forumDetailSocketResponse.isComplaintShow();
        this.applyInfo = forumDetailSocketResponse.getApplyInfo();
        this.gyK = forumDetailSocketResponse.getPrivateApplyInfo();
        this.managerElectionTab = forumDetailSocketResponse.getManagerElectionTab();
        this.bzApplySwitch = forumDetailSocketResponse.getBzApplySwitch();
        bAt();
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.a
    public void a(ForumDetailHttpResponse forumDetailHttpResponse) {
        this.gyF = forumDetailHttpResponse.getForumInfo();
        this.gyG = forumDetailHttpResponse.getThreadInfoList();
        this.gyH = forumDetailHttpResponse.isBawuShow() == 1;
        this.gyI = forumDetailHttpResponse.isComplaintShow();
        this.applyInfo = forumDetailHttpResponse.getApplyInfo();
        this.gyK = forumDetailHttpResponse.getPrivateApplyInfo();
        this.managerElectionTab = forumDetailHttpResponse.getManagerElectionTab();
        this.bzApplySwitch = forumDetailHttpResponse.getBzApplySwitch();
        bAt();
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.a
    public void a(BarEmotionResponseMessage barEmotionResponseMessage) {
        if (barEmotionResponseMessage != null) {
            this.gyD.a(barEmotionResponseMessage.data);
            this.gyJ = barEmotionResponseMessage.data;
        }
    }

    private void bAt() {
        this.gyD.boN();
        this.gyD.hideNoDataView();
        if (this.gyF != null || (this.gyG != null && this.gyG.size() > 0)) {
            this.gyL = true;
            this.gyG = cW(this.gyG);
            this.gyD.a(this.gyF, this.gyH, this.gyI, this.applyInfo, this.gyK, this.managerElectionTab, this.bzApplySwitch);
            this.gyD.av(this.gyG);
            return;
        }
        this.gyL = false;
        this.gyD.oH(R.string.no_data_text);
    }

    private List<SimpleThreadInfo> cW(List<SimpleThreadInfo> list) {
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
            sendMessage(new CustomMessage(2001151, String.valueOf(this.mForumId)));
        }
    }

    private void bAu() {
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

    public String adi() {
        return this.fromType;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.bar_info_member_lay) {
            if (this.gyF != null && this.gyF.forum_id != null) {
                sendMessage(new CustomMessage(2002001, new ForumMemberActivityConfig(getActivity(), String.valueOf(this.gyF.forum_id), this.gyF.forum_name)));
            }
        } else if (id == R.id.bar_info_clean_lay) {
            this.gyD.bAC();
        } else if (id == R.id.bar_info_history_lay) {
            sendMessage(new CustomMessage(2002001, new OfficialBarHistoryActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.f(this.mForumId, 0))));
        } else if (id == R.id.bar_info_emotion_layout) {
            if (!TbadkApplication.isLogin()) {
                TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11003)));
            } else if (this.gyJ != null && this.gyJ.forum_pkg_status == 1 && !TextUtils.isEmpty(this.gyJ.url) && this.gyF != null) {
                sendMessage(new CustomMessage(2002001, new CommonEmotionManagerActivityConfig(getPageContext().getPageActivity(), this.gyJ.url + "?forum_id=" + this.gyF.forum_id)));
            }
        } else if (id == R.id.bar_info_manager_lay) {
            if (this.gyF != null) {
                if (this.gyF.is_private_forum.intValue() == 0) {
                    ba.aiz().c(getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/bawuindex?fn=" + this.gyF.forum_name + "&fid=" + this.gyF.forum_id});
                    TiebaStatic.log(new am("c12714"));
                    return;
                }
                ba.aiz().c(getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/pribawuindex?fid=" + this.gyF.forum_id + "&fn=" + this.gyF.forum_name + "&nomenu=1"});
            }
        } else if (id == R.id.bar_info_complaint_lay) {
            if (this.gyF != null) {
                ba.aiz().c(getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/pritousu/complainforum?fid=" + this.gyF.forum_id + "&nomenu=1"});
            }
        } else if (id == R.id.bar_manager_apply_lay) {
            new am("c13443").aif();
            if (this.gyF != null && this.managerElectionTab != null) {
                int intValue = this.managerElectionTab.new_manager_status.intValue();
                if (intValue == 2) {
                    if (!TextUtils.isEmpty(this.managerElectionTab.new_strategy_link)) {
                        ba.aiz().c(getPageContext(), new String[]{this.managerElectionTab.new_strategy_link});
                    }
                } else if (intValue == 3 || intValue == 4) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(this).createNormalConfig(this.gyF.forum_id.longValue(), 2)));
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
            this.gyE.subscribeBar(false, this.mForumId);
        } else if (!d.anf().anh() || !d.anf().ann()) {
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.ho(R.string.error_open_personal_single_alloff);
            aVar.b(getResources().getString(R.string.signallforum_signnow), new a.b() { // from class: com.baidu.tieba.im.forum.detail.ForumDetailActivity.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                }
            });
            aVar.b(getPageContext());
            aVar.afG();
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.im.forum.detail.ForumDetailActivity.2
                @Override // java.lang.Runnable
                public void run() {
                    ForumDetailActivity.this.gyD.setSwitch(false);
                }
            }, 500L);
        } else {
            this.gyE.subscribeBar(true, this.mForumId);
        }
    }

    /* loaded from: classes3.dex */
    class a implements NoNetworkView.a {
        a() {
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void el(boolean z) {
            if (!ForumDetailActivity.this.gyL) {
                if (z) {
                    ForumDetailActivity.this.gyD.hideNoDataView();
                    ForumDetailActivity.this.gyD.showLoading();
                    ForumDetailActivity.this.gyE.sendMessage(ForumDetailActivity.this.mForumId);
                    return;
                }
                ForumDetailActivity.this.gyD.boN();
                ForumDetailActivity.this.gyD.oH(R.string.game_index_no_network_text);
            }
        }
    }

    /* loaded from: classes3.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.ki()) {
                ForumDetailActivity.this.gyD.hideNoDataView();
                ForumDetailActivity.this.gyD.showLoading();
                ForumDetailActivity.this.gyE.sendMessage(ForumDetailActivity.this.mForumId);
            }
        }
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.a
    public void lJ(boolean z) {
        if (z) {
            showToast(R.string.success);
            lL(true);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "like_add ", "like_add", 1, new Object[0]);
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.im.forum.detail.ForumDetailActivity.3
            @Override // java.lang.Runnable
            public void run() {
                ForumDetailActivity.this.gyD.setSwitch(false);
            }
        }, 500L);
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.a
    public void lK(boolean z) {
        if (z) {
            showToast(R.string.success);
            lL(false);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "like_cancel ", "like_canel", 1, new Object[0]);
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.im.forum.detail.ForumDetailActivity.4
            @Override // java.lang.Runnable
            public void run() {
                ForumDetailActivity.this.gyD.setSwitch(true);
            }
        }, 500L);
    }

    public void lL(final boolean z) {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.im.forum.detail.ForumDetailActivity.5
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                if (!TextUtils.isEmpty(ForumDetailActivity.this.mForumId)) {
                    com.baidu.tieba.im.settingcache.d.bDL().w(TbadkApplication.getCurrentAccount(), String.valueOf(ForumDetailActivity.this.mForumId), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void setSwitch(boolean z) {
        this.gyD.setSwitch(z);
    }

    public void lM(boolean z) {
        this.gyD.a(this.gyF, z);
    }

    public void lN(boolean z) {
        this.gyD.b(this.gyF, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 11003 && this.gyJ != null && this.gyJ.forum_pkg_status == 1 && !TextUtils.isEmpty(this.gyJ.url) && this.gyF != null) {
            sendMessage(new CustomMessage(2002001, new CommonEmotionManagerActivityConfig(getPageContext().getPageActivity(), this.gyJ.url + "?forum_id=" + this.gyF.forum_id)));
        }
    }
}

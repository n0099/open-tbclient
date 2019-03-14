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
import com.baidu.tbadk.core.atomData.CommonEmotionManagerActivityConfig;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ForumMemberActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.OfficialBarHistoryActivityConfig;
import com.baidu.tieba.im.forum.detail.BarEmotionResponseMessage;
import com.baidu.tieba.im.forum.detail.ForumDetailModel;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.SettingChangeMessage;
import java.util.ArrayList;
import java.util.List;
import tbclient.ManagerApplyInfo;
import tbclient.PriManagerApplyInfo;
import tbclient.RecommendForumInfo;
import tbclient.SimpleThreadInfo;
/* loaded from: classes3.dex */
public class ForumDetailActivity extends BaseActivity<ForumDetailActivity> implements BdSwitchView.a, ForumDetailModel.a {
    private ManagerApplyInfo applyInfo;
    private String fromType;
    private com.baidu.tieba.im.forum.detail.a ghA;
    private ForumDetailModel ghB;
    private RecommendForumInfo ghC;
    private List<SimpleThreadInfo> ghD;
    private BarEmotionResponseMessage.ForumEmotionData ghG;
    private PriManagerApplyInfo ghH;
    private String mForumId;
    private boolean ghE = false;
    private boolean ghF = false;
    public boolean ghI = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.forum_detail_activity);
        this.ghA = new com.baidu.tieba.im.forum.detail.a(this);
        this.ghA.bsQ().a(new a());
        this.ghA.d(new b());
        this.ghB = new ForumDetailModel(this);
        this.mForumId = getIntent().getStringExtra("forum_id");
        bsF();
        bsH();
    }

    private void bsF() {
        if (l.lo()) {
            this.ghA.showLoading();
            this.ghB.sendMessage(this.mForumId);
            this.ghB.wZ(this.mForumId);
            return;
        }
        this.ghA.bhr();
        this.ghA.nS(d.j.game_index_no_network_text);
        showToast(d.j.neterror);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        bsF();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.ghA.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ghA.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.a
    public void wY(String str) {
        this.ghA.bhr();
        if (TextUtils.isEmpty(str)) {
            showToast(d.j.neterror);
        } else {
            showToast(str);
        }
        if (l.lo()) {
            this.ghA.nS(d.j.no_data_text);
        } else {
            this.ghA.nS(d.j.game_index_no_network_text);
        }
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.a
    public void a(ForumDetailSocketResponse forumDetailSocketResponse) {
        this.ghC = forumDetailSocketResponse.getForumInfo();
        this.ghD = forumDetailSocketResponse.getThreadInfoList();
        this.ghE = forumDetailSocketResponse.isBawuShow() == 1;
        this.ghF = forumDetailSocketResponse.isComplaintShow();
        this.applyInfo = forumDetailSocketResponse.getApplyInfo();
        this.ghH = forumDetailSocketResponse.getPrivateApplyInfo();
        bsG();
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.a
    public void a(ForumDetailHttpResponse forumDetailHttpResponse) {
        this.ghC = forumDetailHttpResponse.getForumInfo();
        this.ghD = forumDetailHttpResponse.getThreadInfoList();
        this.ghE = forumDetailHttpResponse.isBawuShow() == 1;
        this.ghF = forumDetailHttpResponse.isComplaintShow();
        this.applyInfo = forumDetailHttpResponse.getApplyInfo();
        this.ghH = forumDetailHttpResponse.getPrivateApplyInfo();
        bsG();
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.a
    public void a(BarEmotionResponseMessage barEmotionResponseMessage) {
        if (barEmotionResponseMessage != null) {
            this.ghA.a(barEmotionResponseMessage.data);
            this.ghG = barEmotionResponseMessage.data;
        }
    }

    private void bsG() {
        this.ghA.bhr();
        this.ghA.hideNoDataView();
        if (this.ghC != null || (this.ghD != null && this.ghD.size() > 0)) {
            this.ghI = true;
            this.ghD = cR(this.ghD);
            this.ghA.a(this.ghC, this.ghE, this.ghF, this.applyInfo, this.ghH);
            this.ghA.ao(this.ghD);
            return;
        }
        this.ghI = false;
        this.ghA.nS(d.j.no_data_text);
    }

    private List<SimpleThreadInfo> cR(List<SimpleThreadInfo> list) {
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

    private void bsH() {
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

    public String YE() {
        return this.fromType;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == d.g.bar_info_member_lay) {
            if (this.ghC != null && this.ghC.forum_id != null) {
                sendMessage(new CustomMessage(2002001, new ForumMemberActivityConfig(getActivity(), String.valueOf(this.ghC.forum_id), this.ghC.forum_name)));
            }
        } else if (id == d.g.bar_info_clean_lay) {
            this.ghA.bsP();
        } else if (id == d.g.bar_info_history_lay) {
            sendMessage(new CustomMessage(2002001, new OfficialBarHistoryActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.l(this.mForumId, 0))));
        } else if (id == d.g.bar_info_emotion_layout) {
            if (!TbadkApplication.isLogin()) {
                TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11003)));
            } else if (this.ghG != null && this.ghG.forum_pkg_status == 1 && !TextUtils.isEmpty(this.ghG.url) && this.ghC != null) {
                sendMessage(new CustomMessage(2002001, new CommonEmotionManagerActivityConfig(getPageContext().getPageActivity(), this.ghG.url + "?forum_id=" + this.ghC.forum_id)));
            }
        } else if (id == d.g.bar_info_manager_lay) {
            if (this.ghC != null) {
                if (this.ghC.is_private_forum.intValue() == 0) {
                    ba.adD().c(getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/bawuindex?fn=" + this.ghC.forum_name + "&fid=" + this.ghC.forum_id});
                    TiebaStatic.log(new am("c12714"));
                    return;
                }
                ba.adD().c(getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/pribawuindex?fid=" + this.ghC.forum_id + "&fn=" + this.ghC.forum_name + "&nomenu=1"});
            }
        } else if (id == d.g.bar_info_complaint_lay && this.ghC != null) {
            ba.adD().c(getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/pritousu/complainforum?fid=" + this.ghC.forum_id + "&nomenu=1"});
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.OFF) {
            this.ghB.subscribeBar(false, this.mForumId);
        } else if (!com.baidu.tbadk.coreExtra.messageCenter.d.aih().aij() || !com.baidu.tbadk.coreExtra.messageCenter.d.aih().aip()) {
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.gD(d.j.error_open_personal_single_alloff);
            aVar.b(getResources().getString(d.j.signallforum_signnow), new a.b() { // from class: com.baidu.tieba.im.forum.detail.ForumDetailActivity.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                }
            });
            aVar.b(getPageContext());
            aVar.aaZ();
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.im.forum.detail.ForumDetailActivity.2
                @Override // java.lang.Runnable
                public void run() {
                    ForumDetailActivity.this.ghA.setSwitch(false);
                }
            }, 500L);
        } else {
            this.ghB.subscribeBar(true, this.mForumId);
        }
    }

    /* loaded from: classes3.dex */
    class a implements NoNetworkView.a {
        a() {
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void dP(boolean z) {
            if (!ForumDetailActivity.this.ghI) {
                if (z) {
                    ForumDetailActivity.this.ghA.hideNoDataView();
                    ForumDetailActivity.this.ghA.showLoading();
                    ForumDetailActivity.this.ghB.sendMessage(ForumDetailActivity.this.mForumId);
                    return;
                }
                ForumDetailActivity.this.ghA.bhr();
                ForumDetailActivity.this.ghA.nS(d.j.game_index_no_network_text);
            }
        }
    }

    /* loaded from: classes3.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.lo()) {
                ForumDetailActivity.this.ghA.hideNoDataView();
                ForumDetailActivity.this.ghA.showLoading();
                ForumDetailActivity.this.ghB.sendMessage(ForumDetailActivity.this.mForumId);
            }
        }
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.a
    public void kT(boolean z) {
        if (z) {
            showToast(d.j.success);
            kV(true);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "like_add ", "like_add", 1, new Object[0]);
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.im.forum.detail.ForumDetailActivity.3
            @Override // java.lang.Runnable
            public void run() {
                ForumDetailActivity.this.ghA.setSwitch(false);
            }
        }, 500L);
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.a
    public void kU(boolean z) {
        if (z) {
            showToast(d.j.success);
            kV(false);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "like_cancel ", "like_canel", 1, new Object[0]);
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.im.forum.detail.ForumDetailActivity.4
            @Override // java.lang.Runnable
            public void run() {
                ForumDetailActivity.this.ghA.setSwitch(true);
            }
        }, 500L);
    }

    public void kV(final boolean z) {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.im.forum.detail.ForumDetailActivity.5
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                if (!TextUtils.isEmpty(ForumDetailActivity.this.mForumId)) {
                    com.baidu.tieba.im.settingcache.d.bwc().t(TbadkApplication.getCurrentAccount(), String.valueOf(ForumDetailActivity.this.mForumId), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void setSwitch(boolean z) {
        this.ghA.setSwitch(z);
    }

    public void kW(boolean z) {
        this.ghA.a(this.ghC, z);
    }

    public void kX(boolean z) {
        this.ghA.b(this.ghC, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 11003 && this.ghG != null && this.ghG.forum_pkg_status == 1 && !TextUtils.isEmpty(this.ghG.url) && this.ghC != null) {
            sendMessage(new CustomMessage(2002001, new CommonEmotionManagerActivityConfig(getPageContext().getPageActivity(), this.ghG.url + "?forum_id=" + this.ghC.forum_id)));
        }
    }
}

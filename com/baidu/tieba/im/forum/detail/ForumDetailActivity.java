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
    private com.baidu.tieba.im.forum.detail.a gho;
    private ForumDetailModel ghp;
    private RecommendForumInfo ghq;
    private List<SimpleThreadInfo> ghr;
    private BarEmotionResponseMessage.ForumEmotionData ghu;
    private PriManagerApplyInfo ghv;
    private String mForumId;
    private boolean ghs = false;
    private boolean ght = false;
    public boolean ghw = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.forum_detail_activity);
        this.gho = new com.baidu.tieba.im.forum.detail.a(this);
        this.gho.bsN().a(new a());
        this.gho.d(new b());
        this.ghp = new ForumDetailModel(this);
        this.mForumId = getIntent().getStringExtra("forum_id");
        bsC();
        bsE();
    }

    private void bsC() {
        if (l.lo()) {
            this.gho.showLoading();
            this.ghp.sendMessage(this.mForumId);
            this.ghp.wY(this.mForumId);
            return;
        }
        this.gho.bhp();
        this.gho.nQ(d.j.game_index_no_network_text);
        showToast(d.j.neterror);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        bsC();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.gho.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gho.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.a
    public void wX(String str) {
        this.gho.bhp();
        if (TextUtils.isEmpty(str)) {
            showToast(d.j.neterror);
        } else {
            showToast(str);
        }
        if (l.lo()) {
            this.gho.nQ(d.j.no_data_text);
        } else {
            this.gho.nQ(d.j.game_index_no_network_text);
        }
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.a
    public void a(ForumDetailSocketResponse forumDetailSocketResponse) {
        this.ghq = forumDetailSocketResponse.getForumInfo();
        this.ghr = forumDetailSocketResponse.getThreadInfoList();
        this.ghs = forumDetailSocketResponse.isBawuShow() == 1;
        this.ght = forumDetailSocketResponse.isComplaintShow();
        this.applyInfo = forumDetailSocketResponse.getApplyInfo();
        this.ghv = forumDetailSocketResponse.getPrivateApplyInfo();
        bsD();
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.a
    public void a(ForumDetailHttpResponse forumDetailHttpResponse) {
        this.ghq = forumDetailHttpResponse.getForumInfo();
        this.ghr = forumDetailHttpResponse.getThreadInfoList();
        this.ghs = forumDetailHttpResponse.isBawuShow() == 1;
        this.ght = forumDetailHttpResponse.isComplaintShow();
        this.applyInfo = forumDetailHttpResponse.getApplyInfo();
        this.ghv = forumDetailHttpResponse.getPrivateApplyInfo();
        bsD();
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.a
    public void a(BarEmotionResponseMessage barEmotionResponseMessage) {
        if (barEmotionResponseMessage != null) {
            this.gho.a(barEmotionResponseMessage.data);
            this.ghu = barEmotionResponseMessage.data;
        }
    }

    private void bsD() {
        this.gho.bhp();
        this.gho.hideNoDataView();
        if (this.ghq != null || (this.ghr != null && this.ghr.size() > 0)) {
            this.ghw = true;
            this.ghr = cO(this.ghr);
            this.gho.a(this.ghq, this.ghs, this.ght, this.applyInfo, this.ghv);
            this.gho.ao(this.ghr);
            return;
        }
        this.ghw = false;
        this.gho.nQ(d.j.no_data_text);
    }

    private List<SimpleThreadInfo> cO(List<SimpleThreadInfo> list) {
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

    private void bsE() {
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

    public String YB() {
        return this.fromType;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == d.g.bar_info_member_lay) {
            if (this.ghq != null && this.ghq.forum_id != null) {
                sendMessage(new CustomMessage(2002001, new ForumMemberActivityConfig(getActivity(), String.valueOf(this.ghq.forum_id), this.ghq.forum_name)));
            }
        } else if (id == d.g.bar_info_clean_lay) {
            this.gho.bsM();
        } else if (id == d.g.bar_info_history_lay) {
            sendMessage(new CustomMessage(2002001, new OfficialBarHistoryActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.l(this.mForumId, 0))));
        } else if (id == d.g.bar_info_emotion_layout) {
            if (!TbadkApplication.isLogin()) {
                TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11003)));
            } else if (this.ghu != null && this.ghu.forum_pkg_status == 1 && !TextUtils.isEmpty(this.ghu.url) && this.ghq != null) {
                sendMessage(new CustomMessage(2002001, new CommonEmotionManagerActivityConfig(getPageContext().getPageActivity(), this.ghu.url + "?forum_id=" + this.ghq.forum_id)));
            }
        } else if (id == d.g.bar_info_manager_lay) {
            if (this.ghq != null) {
                if (this.ghq.is_private_forum.intValue() == 0) {
                    ba.adA().c(getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/bawuindex?fn=" + this.ghq.forum_name + "&fid=" + this.ghq.forum_id});
                    TiebaStatic.log(new am("c12714"));
                    return;
                }
                ba.adA().c(getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/pribawuindex?fid=" + this.ghq.forum_id + "&fn=" + this.ghq.forum_name + "&nomenu=1"});
            }
        } else if (id == d.g.bar_info_complaint_lay && this.ghq != null) {
            ba.adA().c(getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/pritousu/complainforum?fid=" + this.ghq.forum_id + "&nomenu=1"});
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.OFF) {
            this.ghp.subscribeBar(false, this.mForumId);
        } else if (!com.baidu.tbadk.coreExtra.messageCenter.d.aie().aig() || !com.baidu.tbadk.coreExtra.messageCenter.d.aie().aim()) {
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.gC(d.j.error_open_personal_single_alloff);
            aVar.b(getResources().getString(d.j.signallforum_signnow), new a.b() { // from class: com.baidu.tieba.im.forum.detail.ForumDetailActivity.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                }
            });
            aVar.b(getPageContext());
            aVar.aaW();
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.im.forum.detail.ForumDetailActivity.2
                @Override // java.lang.Runnable
                public void run() {
                    ForumDetailActivity.this.gho.setSwitch(false);
                }
            }, 500L);
        } else {
            this.ghp.subscribeBar(true, this.mForumId);
        }
    }

    /* loaded from: classes3.dex */
    class a implements NoNetworkView.a {
        a() {
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void dP(boolean z) {
            if (!ForumDetailActivity.this.ghw) {
                if (z) {
                    ForumDetailActivity.this.gho.hideNoDataView();
                    ForumDetailActivity.this.gho.showLoading();
                    ForumDetailActivity.this.ghp.sendMessage(ForumDetailActivity.this.mForumId);
                    return;
                }
                ForumDetailActivity.this.gho.bhp();
                ForumDetailActivity.this.gho.nQ(d.j.game_index_no_network_text);
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
                ForumDetailActivity.this.gho.hideNoDataView();
                ForumDetailActivity.this.gho.showLoading();
                ForumDetailActivity.this.ghp.sendMessage(ForumDetailActivity.this.mForumId);
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
                ForumDetailActivity.this.gho.setSwitch(false);
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
                ForumDetailActivity.this.gho.setSwitch(true);
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
                    com.baidu.tieba.im.settingcache.d.bvZ().t(TbadkApplication.getCurrentAccount(), String.valueOf(ForumDetailActivity.this.mForumId), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void setSwitch(boolean z) {
        this.gho.setSwitch(z);
    }

    public void kW(boolean z) {
        this.gho.a(this.ghq, z);
    }

    public void kX(boolean z) {
        this.gho.b(this.ghq, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 11003 && this.ghu != null && this.ghu.forum_pkg_status == 1 && !TextUtils.isEmpty(this.ghu.url) && this.ghq != null) {
            sendMessage(new CustomMessage(2002001, new CommonEmotionManagerActivityConfig(getPageContext().getPageActivity(), this.ghu.url + "?forum_id=" + this.ghq.forum_id)));
        }
    }
}

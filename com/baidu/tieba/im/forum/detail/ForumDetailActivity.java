package com.baidu.tieba.im.forum.detail;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BarVoteActivityConfig;
import com.baidu.tbadk.core.atomData.CommonEmotionManagerActivityConfig;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ForumMemberActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.OfficialBarHistoryActivityConfig;
import com.baidu.tieba.im.forum.detail.BarEmotionResponseMessage;
import com.baidu.tieba.im.forum.detail.ForumDetailModel;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.SettingChangeMessage;
import d.a.c.e.p.l;
import d.a.m0.r.s.a;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetForumDetail.BzApplySwitch;
import tbclient.GetForumDetail.ManagerApplyInfo;
import tbclient.GetForumDetail.ManagerElectionTab;
import tbclient.PriManagerApplyInfo;
import tbclient.RecommendForumInfo;
import tbclient.SimpleThreadInfo;
/* loaded from: classes4.dex */
public class ForumDetailActivity extends BaseActivity<ForumDetailActivity> implements ForumDetailModel.f, BdSwitchView.b {
    public static final int THREAD_ITEM_MAX_NUM = 5;
    public ManagerApplyInfo applyInfo;
    public BzApplySwitch bzApplySwitch;
    public String fromType;
    public BarEmotionResponseMessage.ForumEmotionData mForumEmotionData;
    public String mForumId;
    public RecommendForumInfo mForumInfo;
    public ForumDetailModel mModel;
    public PriManagerApplyInfo mPrivateApplyInfo;
    public List<SimpleThreadInfo> mThreadInfoList;
    public d.a.n0.f1.i.b.a mView;
    public ManagerElectionTab managerElectionTab;
    public boolean isBawuShow = false;
    public boolean mIsComplaintShow = false;
    public boolean mIsHasData = false;

    /* loaded from: classes4.dex */
    public class a implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.r.s.a f17248e;

        public a(d.a.m0.r.s.a aVar) {
            this.f17248e = aVar;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            this.f17248e.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ForumDetailActivity.this.mView.q(false);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ForumDetailActivity.this.mView.q(false);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ForumDetailActivity.this.mView.q(true);
        }
    }

    /* loaded from: classes4.dex */
    public class e extends BdAsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f17253a;

        public e(boolean z) {
            this.f17253a = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (TextUtils.isEmpty(ForumDetailActivity.this.mForumId)) {
                return null;
            }
            d.a.n0.f1.t.d.j().f(TbadkCoreApplication.getCurrentAccount(), String.valueOf(ForumDetailActivity.this.mForumId), this.f17253a);
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public class f implements NoNetworkView.b {
        public f() {
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void b(boolean z) {
            ForumDetailActivity forumDetailActivity = ForumDetailActivity.this;
            if (forumDetailActivity.mIsHasData) {
                return;
            }
            if (z) {
                forumDetailActivity.mView.k();
                ForumDetailActivity.this.mView.t();
                ForumDetailActivity.this.mModel.F(ForumDetailActivity.this.mForumId);
                return;
            }
            forumDetailActivity.mView.i();
            ForumDetailActivity.this.mView.u(R.string.refresh_view_title_text);
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.D()) {
                ForumDetailActivity.this.mView.k();
                ForumDetailActivity.this.mView.t();
                ForumDetailActivity.this.mModel.F(ForumDetailActivity.this.mForumId);
            }
        }
    }

    private List<SimpleThreadInfo> filterThreadList(List<SimpleThreadInfo> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (SimpleThreadInfo simpleThreadInfo : list) {
            if (simpleThreadInfo != null) {
                if (i2 >= 5) {
                    break;
                }
                i2++;
                arrayList.add(simpleThreadInfo);
            }
        }
        return arrayList;
    }

    private void onResult() {
        List<SimpleThreadInfo> list;
        this.mView.i();
        this.mView.k();
        if (this.mForumInfo == null && ((list = this.mThreadInfoList) == null || list.size() <= 0)) {
            this.mIsHasData = false;
            this.mView.u(R.string.no_data_common_txt);
            return;
        }
        this.mIsHasData = true;
        this.mThreadInfoList = filterThreadList(this.mThreadInfoList);
        this.mView.n(this.mForumInfo, this.isBawuShow, this.mIsComplaintShow, this.applyInfo, this.mPrivateApplyInfo, this.managerElectionTab, this.bzApplySwitch);
        this.mView.r(this.mThreadInfoList);
    }

    private void requestNet() {
        if (l.D()) {
            this.mView.t();
            this.mModel.F(this.mForumId);
            this.mModel.E(this.mForumId);
            return;
        }
        this.mView.i();
        this.mView.u(R.string.refresh_view_title_text);
        showToast(R.string.neterror);
    }

    private void statistics() {
        String str;
        String stringExtra = getIntent().getStringExtra("from_type");
        this.fromType = stringExtra;
        if (StringUtils.isNull(stringExtra)) {
            return;
        }
        if (this.fromType.equals(ForumDetailActivityConfig.FromType.FRS.toString())) {
            str = "frs_2_sub";
        } else if (this.fromType.equals(ForumDetailActivityConfig.FromType.BAR_DIR.toString()) || this.fromType.equals(ForumDetailActivityConfig.FromType.BAR_RANK.toString())) {
            str = "sq_2_sub";
        } else if (this.fromType.equals(ForumDetailActivityConfig.FromType.FRS_SIDE.toString())) {
            str = "side_2_sub";
        } else {
            str = this.fromType.equals(ForumDetailActivityConfig.FromType.BAR.toString()) ? "aio_side_2_sub" : "";
        }
        if (StringUtils.isNull(str)) {
            return;
        }
        TiebaStatic.eventStat(getPageContext().getPageActivity(), str, PrefetchEvent.STATE_CLICK, 1, new Object[0]);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
    public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.OFF) {
            this.mModel.subscribeBar(false, this.mForumId);
        } else if (d.a.m0.s.d.d.d().s() && d.a.m0.s.d.d.d().p()) {
            this.mModel.subscribeBar(true, this.mForumId);
        } else {
            d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(getActivity());
            aVar.setMessageId(R.string.error_open_personal_single_alloff);
            aVar.setNegativeButton(getResources().getString(R.string.signallforum_signnow), new a(aVar));
            aVar.create(getPageContext());
            aVar.show();
            this.mHandler.postDelayed(new b(), 500L);
        }
    }

    public void clearHistory() {
        if (TextUtils.isEmpty(this.mForumId)) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(this.mForumId), 4, null, 1)));
        sendMessage(new CustomMessage(2001151, String.valueOf(this.mForumId)));
    }

    public String getFromType() {
        return this.fromType;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        BarEmotionResponseMessage.ForumEmotionData forumEmotionData;
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1 || i2 != 11003 || (forumEmotionData = this.mForumEmotionData) == null || forumEmotionData.forum_pkg_status != 1 || TextUtils.isEmpty(forumEmotionData.url) || this.mForumInfo == null) {
            return;
        }
        Activity pageActivity = getPageContext().getPageActivity();
        sendMessage(new CustomMessage(2002001, new CommonEmotionManagerActivityConfig(pageActivity, this.mForumEmotionData.url + "?forum_id=" + this.mForumInfo.forum_id)));
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        this.mView.onChangeSkinType(i2);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        ManagerElectionTab managerElectionTab;
        int id = view.getId();
        if (id == R.id.bar_info_member_lay) {
            RecommendForumInfo recommendForumInfo = this.mForumInfo;
            if (recommendForumInfo == null || recommendForumInfo.forum_id == null) {
                return;
            }
            sendMessage(new CustomMessage(2002001, new ForumMemberActivityConfig(getActivity(), String.valueOf(this.mForumInfo.forum_id), this.mForumInfo.forum_name)));
        } else if (id == R.id.bar_info_clean_lay) {
            this.mView.s();
        } else if (id == R.id.bar_info_history_lay) {
            sendMessage(new CustomMessage(2002001, new OfficialBarHistoryActivityConfig(getPageContext().getPageActivity(), d.a.c.e.m.b.d(this.mForumId, 0))));
        } else if (id == R.id.bar_info_emotion_layout) {
            if (!TbadkCoreApplication.isLogin()) {
                TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11003)));
                return;
            }
            BarEmotionResponseMessage.ForumEmotionData forumEmotionData = this.mForumEmotionData;
            if (forumEmotionData == null || forumEmotionData.forum_pkg_status != 1 || TextUtils.isEmpty(forumEmotionData.url) || this.mForumInfo == null) {
                return;
            }
            Activity pageActivity = getPageContext().getPageActivity();
            sendMessage(new CustomMessage(2002001, new CommonEmotionManagerActivityConfig(pageActivity, this.mForumEmotionData.url + "?forum_id=" + this.mForumInfo.forum_id)));
        } else if (id == R.id.bar_info_manager_lay) {
            RecommendForumInfo recommendForumInfo2 = this.mForumInfo;
            if (recommendForumInfo2 != null) {
                if (recommendForumInfo2.is_private_forum.intValue() == 0) {
                    UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/bawuindex?fn=" + this.mForumInfo.forum_name + "&fid=" + this.mForumInfo.forum_id});
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_BAR_DETAIL_CLICK));
                    return;
                }
                UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/pribawuindex?fid=" + this.mForumInfo.forum_id + "&fn=" + this.mForumInfo.forum_name + "&nomenu=1"});
            }
        } else if (id == R.id.bar_info_complaint_lay) {
            if (this.mForumInfo != null) {
                UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/pritousu/complainforum?fid=" + this.mForumInfo.forum_id + "&nomenu=1"});
            }
        } else if (id == R.id.bar_manager_apply_lay) {
            new StatisticItem(TbadkCoreStatisticKey.KEY_BAR_ENTRANCE_DETAIL).eventStat();
            if (this.mForumInfo == null || (managerElectionTab = this.managerElectionTab) == null) {
                return;
            }
            int intValue = managerElectionTab.new_manager_status.intValue();
            if (intValue == 2) {
                if (TextUtils.isEmpty(this.managerElectionTab.new_strategy_link)) {
                    return;
                }
                UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{this.managerElectionTab.new_strategy_link});
            } else if (intValue == 3 || intValue == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(this).createNormalConfig(this.mForumInfo.forum_id.longValue(), 2)));
            } else if (intValue == 5) {
                if (TextUtils.isEmpty(this.managerElectionTab.toast_text)) {
                    l.L(TbadkCoreApplication.getInst(), R.string.bar_election_finished);
                } else {
                    l.M(TbadkCoreApplication.getInst(), this.managerElectionTab.toast_text);
                }
            } else if (intValue != 1 || TextUtils.isEmpty(this.managerElectionTab.toast_text)) {
            } else {
                l.M(TbadkCoreApplication.getInst(), this.managerElectionTab.toast_text);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.forum_detail_activity);
        d.a.n0.f1.i.b.a aVar = new d.a.n0.f1.i.b.a(this);
        this.mView = aVar;
        aVar.h().a(new f());
        this.mView.p(new g());
        this.mModel = new ForumDetailModel(this);
        this.mForumId = getIntent().getStringExtra("forum_id");
        requestNet();
        statistics();
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.f
    public void onHttpEmotionResponseMessage(BarEmotionResponseMessage barEmotionResponseMessage) {
        if (barEmotionResponseMessage != null) {
            this.mView.m(barEmotionResponseMessage.data);
            this.mForumEmotionData = barEmotionResponseMessage.data;
        }
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.f
    public void onHttpResponsedMessage(ForumDetailHttpResponse forumDetailHttpResponse) {
        this.mForumInfo = forumDetailHttpResponse.getForumInfo();
        this.mThreadInfoList = forumDetailHttpResponse.getThreadInfoList();
        this.isBawuShow = forumDetailHttpResponse.isBawuShow() == 1;
        this.mIsComplaintShow = forumDetailHttpResponse.isComplaintShow();
        this.applyInfo = forumDetailHttpResponse.getApplyInfo();
        this.mPrivateApplyInfo = forumDetailHttpResponse.getPrivateApplyInfo();
        this.managerElectionTab = forumDetailHttpResponse.getManagerElectionTab();
        this.bzApplySwitch = forumDetailHttpResponse.getBzApplySwitch();
        onResult();
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.f
    public void onNetError(String str) {
        this.mView.i();
        if (TextUtils.isEmpty(str)) {
            showToast(R.string.neterror);
        } else {
            showToast(str);
        }
        if (l.D()) {
            this.mView.u(R.string.no_data_common_txt);
        } else {
            this.mView.u(R.string.refresh_view_title_text);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mView.l();
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.f
    public void onSocketResponsedMessage(ForumDetailSocketResponse forumDetailSocketResponse) {
        this.mForumInfo = forumDetailSocketResponse.getForumInfo();
        this.mThreadInfoList = forumDetailSocketResponse.getThreadInfoList();
        this.isBawuShow = forumDetailSocketResponse.isBawuShow() == 1;
        this.mIsComplaintShow = forumDetailSocketResponse.isComplaintShow();
        this.applyInfo = forumDetailSocketResponse.getApplyInfo();
        this.mPrivateApplyInfo = forumDetailSocketResponse.getPrivateApplyInfo();
        this.managerElectionTab = forumDetailSocketResponse.getManagerElectionTab();
        this.bzApplySwitch = forumDetailSocketResponse.getBzApplySwitch();
        onResult();
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.f
    public void onSubscrib(boolean z) {
        if (z) {
            showToast(R.string.success);
            saveAcceptNotify(true);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "like_add ", "like_add", 1, new Object[0]);
            return;
        }
        this.mHandler.postDelayed(new c(), 500L);
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.f
    public void onUnSubscrib(boolean z) {
        if (z) {
            showToast(R.string.success);
            saveAcceptNotify(false);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "like_cancel ", "like_canel", 1, new Object[0]);
            return;
        }
        this.mHandler.postDelayed(new d(), 500L);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        requestNet();
    }

    public void saveAcceptNotify(boolean z) {
        new e(z).execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void setMsgManageVisibility(boolean z) {
        this.mView.o(this.mForumInfo, z);
    }

    public void setSwitch(boolean z) {
        this.mView.q(z);
    }

    public void updateLikeAndMsgStatus(boolean z) {
        this.mView.v(this.mForumInfo, z);
    }
}

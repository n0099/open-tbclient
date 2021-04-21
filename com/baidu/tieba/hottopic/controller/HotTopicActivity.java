package com.baidu.tieba.hottopic.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbDomainConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.VideoEasterEggActivityConfig;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.hottopic.controller.HotRelateThreadModel;
import com.baidu.tieba.hottopic.controller.HotTopicModel;
import com.baidu.tieba.hottopic.data.ShareFromTopicMsgData;
import com.baidu.tieba.hottopic.holder.HotThreadItemHolder;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import d.b.c.e.p.j;
import d.b.c.e.p.k;
import d.b.c.e.p.l;
import d.b.i0.r.q.w0;
import d.b.i0.r.q.z0;
import d.b.j0.c1.c.f;
import d.b.j0.c1.c.i;
import d.b.j0.x.m;
import d.b.j0.x.t;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.GetMyPost.User_Info;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes4.dex */
public class HotTopicActivity extends BaseActivity<HotTopicActivity> implements HotTopicModel.b, HotRelateThreadModel.c, FrsCommonImageLayout.e, UserIconBox.c, BdListView.p, HotRelateThreadModel.b, d.b.j0.c1.b.a {
    public BlessModel blessModel;
    public long fid;
    public String firstDir;
    public d.b.c.e.k.b<TbImageView> hotThreadCommonImagePool;
    public d.b.j0.c1.b.b hotTopicShareModel;
    public LikeModel likeModel;
    public d.b.j0.c1.b.a mBusinessStatistic;
    public List<HotTopicBussinessData> mDataList;
    public List<d.b.j0.c1.c.e> mHotTopicDataList;
    public long mTid;
    public d.b.c.e.k.b<TbImageView> mUserIconPool;
    public String secondDir;
    public d.b.j0.c1.f.c mainView = null;
    public HotTopicModel hotTopicModel = null;
    public HotRelateThreadModel hotRelateThreadModel = null;
    public String topicId = null;
    public String topicName = null;
    public String mFrom = "";
    public long lastResumeTime = 0;
    public int mIsGlobalBlock = 0;
    public boolean mIsLoadComplete = true;
    public AntiHelper.k mAntiInjectListener = new a();
    public final d.b.c.c.g.a mGetMyPostNetListener = new b(CmdConfigHttp.CMD_GET_MY_POST, 303111);
    public d.b.c.a.e mLikeModelCallback = new c();

    /* loaded from: classes4.dex */
    public class a implements AntiHelper.k {
        public a() {
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(d.b.i0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(d.b.i0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
        }
    }

    /* loaded from: classes4.dex */
    public class b extends d.b.c.c.g.a {
        public b(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            String errorString2;
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                if (StringUtils.isNull(getMyPostHttpResponseMessage.getErrorString())) {
                    errorString2 = HotTopicActivity.this.getResources().getString(R.string.neterror);
                } else {
                    errorString2 = getMyPostHttpResponseMessage.getErrorString();
                }
                HotTopicActivity.this.handleGetMyPostResponse(getMyPostHttpResponseMessage.getError(), errorString2, getMyPostHttpResponseMessage.getResponseData());
            } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                if (StringUtils.isNull(getMyPostSocketResponseMessage.getErrorString())) {
                    errorString = HotTopicActivity.this.getResources().getString(R.string.neterror);
                } else {
                    errorString = getMyPostSocketResponseMessage.getErrorString();
                }
                HotTopicActivity.this.handleGetMyPostResponse(getMyPostSocketResponseMessage.getError(), errorString, getMyPostSocketResponseMessage.getResponseData());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends d.b.c.a.e {
        public c() {
        }

        @Override // d.b.c.a.e
        public void c(Object obj) {
            if (!AntiHelper.m(HotTopicActivity.this.likeModel.getErrorCode(), HotTopicActivity.this.likeModel.getErrorString())) {
                if (StringUtils.isNull(HotTopicActivity.this.likeModel.getErrorString())) {
                    return;
                }
                l.L(TbadkCoreApplication.getInst(), HotTopicActivity.this.likeModel.getErrorString());
            } else if (AntiHelper.w(HotTopicActivity.this.getActivity(), HotTopicActivity.this.likeModel.getErrorString(), HotTopicActivity.this.likeModel.getErrorCode(), HotTopicActivity.this.mAntiInjectListener) != null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnTouchListener {
        public d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (!ViewHelper.checkUpIsLogin(HotTopicActivity.this.getActivity())) {
            }
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class e implements NoNetworkView.b {
        public e() {
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void b(boolean z) {
            HotTopicActivity.this.mainView.E(!z);
            if (!z || HotTopicActivity.this.hotTopicModel == null || ListUtils.getItem(HotTopicActivity.this.mHotTopicDataList, HotTopicActivity.this.mainView.q()) == null) {
                return;
            }
            d.b.j0.c1.c.e eVar = (d.b.j0.c1.c.e) HotTopicActivity.this.mHotTopicDataList.get(HotTopicActivity.this.mainView.q());
            if (eVar == null || ListUtils.isEmpty(eVar.i())) {
                HotTopicActivity.this.mainView.x();
                HotTopicActivity.this.mainView.N();
                HotTopicActivity.this.loadHotTopicData();
            }
        }
    }

    private boolean checkVideoEasterEgg(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || k.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (d.b.i0.r.d0.b.j().g(d.b.i0.r.d0.b.n(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this).createNormalConfig("from_hottopic", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    private void firstTimeLoadHotTopicData() {
        showLoadingView(this.mainView.u(), false);
        if (!j.A()) {
            hideLoadingView(this.mainView.u());
            showNetRefreshView(this.mainView.u(), getResources().getString(R.string.neterror), true);
            setNetRefreshViewTopMargin(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds530));
            this.mainView.I(8);
            return;
        }
        this.mainView.I(0);
        loadHotTopicData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleGetMyPostResponse(int i, String str, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0) {
            showToast(str);
            return;
        }
        d.b.j0.c1.f.c cVar = this.mainView;
        if (cVar == null || ListUtils.getItem(this.mHotTopicDataList, cVar.q()) == null || this.mainView.r() == null) {
            return;
        }
        d.b.j0.c1.c.e eVar = (d.b.j0.c1.c.e) ListUtils.getItem(this.mHotTopicDataList, this.mainView.q());
        w0 w0Var = new w0();
        ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
        User.Builder builder2 = new User.Builder(builder.author);
        parseUserData(builder2, getMyPostResIdl.data.user_info);
        builder.author = builder2.build(true);
        w0Var.R2(builder.build(true));
        eVar.b(w0Var);
        this.mainView.r().A(eVar);
    }

    private void initListeners() {
        this.mainView.K(new d());
        this.mainView.J(new e());
        this.mGetMyPostNetListener.getSocketMessageListener().setSelfListener(true);
        this.mGetMyPostNetListener.getHttpMessageListener().setSelfListener(true);
        registerListener(this.mGetMyPostNetListener);
    }

    private void initParamsFromIntent(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.topicId = intent.getStringExtra("topic_id");
            this.topicName = intent.getStringExtra(IntentConfig.TOPIC_NAME);
            this.fid = intent.getLongExtra(IntentConfig.TOPIC_FID, 0L);
            this.firstDir = intent.getStringExtra(IntentConfig.TOPIC_FIRST_DIR);
            this.secondDir = intent.getStringExtra(IntentConfig.TOPIC_SECOND_DIR);
            this.mFrom = intent.getStringExtra("from");
            this.mTid = intent.getLongExtra(IntentConfig.TOPIC_TID, 0L);
        } else if (bundle != null) {
            this.topicId = bundle.getString("topic_id");
            this.topicName = bundle.getString(IntentConfig.TOPIC_NAME);
            this.fid = bundle.getLong(IntentConfig.TOPIC_FID, 0L);
            this.firstDir = bundle.getString(IntentConfig.TOPIC_FIRST_DIR);
            this.secondDir = bundle.getString(IntentConfig.TOPIC_SECOND_DIR);
            this.mFrom = bundle.getString("from");
            this.mFrom = bundle.getString("from");
            this.mTid = bundle.getLong(IntentConfig.TOPIC_TID, 0L);
        }
    }

    private void parseUserData(User.Builder builder, User_Info user_Info) {
        if (user_Info == null) {
            return;
        }
        builder.id = user_Info.id;
        builder.gender = user_Info.gender;
        builder.type = user_Info.type;
        builder.name = user_Info.name;
        builder.name_show = user_Info.name_show;
        builder.portrait = TbadkCoreApplication.getCurrentPortrait();
        builder.god_data = user_Info.god_data;
        builder.fans_num = user_Info.fans_num;
        builder.fans_nickname = user_Info.fans_nickname;
        builder.is_bawu = user_Info.is_bawu;
        builder.bawu_type = user_Info.bawu_type;
    }

    private void parserWriteData(d.b.j0.c1.c.e eVar) {
        List<HotTopicBussinessData> list = this.mDataList;
        if (list == null) {
            this.mDataList = new ArrayList();
        } else {
            list.clear();
        }
        this.mDataList.add(new HotTopicBussinessData(0L, "", eVar.h().f53934f, this.mIsGlobalBlock));
    }

    private void updateLoadingMoreForNetError() {
        int tabPosBySortType = getTabPosBySortType(getSortType());
        d.b.j0.c1.c.e eVar = (d.b.j0.c1.c.e) ListUtils.getItem(this.mHotTopicDataList, tabPosBySortType);
        if (eVar != null && eVar.j() != null) {
            if (eVar.j().b() != 0) {
                this.mainView.w(tabPosBySortType);
                return;
            }
            this.mainView.w(tabPosBySortType);
            this.mainView.O(tabPosBySortType);
            return;
        }
        this.mainView.w(tabPosBySortType);
    }

    private void updateReqPageInfo(int i, z0 z0Var) {
        if (z0Var == null) {
            return;
        }
        int tabPosBySortType = getTabPosBySortType(i);
        d.b.j0.c1.c.e eVar = (d.b.j0.c1.c.e) ListUtils.getItem(this.mHotTopicDataList, tabPosBySortType);
        if (eVar != null) {
            eVar.q(z0Var);
        }
        if (z0Var.b() != 0) {
            this.mainView.M(tabPosBySortType);
            return;
        }
        this.mainView.w(tabPosBySortType);
        this.mainView.O(tabPosBySortType);
    }

    public void businessStatisticForTopic(d.b.j0.x.e0.b bVar) {
        if (bVar == null || bVar.n() == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13021");
        statisticItem.param("tid", bVar.n().w1()).param("fid", bVar.n().c0()).param("obj_source", bVar.n().R0).param("obj_locate", getFrom()).param("obj_name", getTopicName()).param(TiebaStatic.Params.OBJ_PARAM3, m.e()).param("ab_tag", bVar.z());
        t.b().a(statisticItem);
    }

    public void businessStatisticForTopicClick(d.b.j0.x.e0.b bVar) {
        if (bVar == null || bVar.n() == null) {
            return;
        }
        d.b.j0.c1.e.b.a(bVar.n(), getTopicName(), getFrom(), bVar.k);
    }

    @Override // com.baidu.tieba.hottopic.controller.HotRelateThreadModel.b
    public void complete() {
        this.mIsLoadComplete = true;
    }

    @Override // com.baidu.tbadk.BaseActivity, d.b.i0.k0.a
    public String getCurrentPageKey() {
        return "a010";
    }

    public String getFrom() {
        return this.mFrom;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.e
    public d.b.c.e.k.b<TbImageView> getFrsCommonImageLayoutPool() {
        if (this.hotThreadCommonImagePool == null) {
            this.hotThreadCommonImagePool = FrsCommonImageLayout.m(getPageContext().getPageActivity(), 12);
        }
        return this.hotThreadCommonImagePool;
    }

    public String getHotTopicId() {
        return this.topicId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public ListView getListView() {
        return null;
    }

    public ShareFromTopicMsgData getShareFromTopicMsgData() {
        f h2;
        if (ListUtils.isEmpty(this.mHotTopicDataList) || (h2 = this.mHotTopicDataList.get(0).h()) == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        ShareFromTopicMsgData shareFromTopicMsgData = new ShareFromTopicMsgData();
        shareFromTopicMsgData.setContent(h2.j);
        shareFromTopicMsgData.setImageUrl(h2.k);
        shareFromTopicMsgData.setTitle(h2.f53934f);
        shareFromTopicMsgData.setHotTopicID(h2.f53933e);
        shareFromTopicMsgData.setHotTopicName(h2.f53934f);
        sb.append(TbDomainConfig.DOMAIN_HTTPS_TIEBA);
        sb.append("mo/q/hotMessage?topic_id=");
        sb.append(h2.f53933e);
        sb.append("&topic_name=");
        sb.append(h2.f53934f);
        shareFromTopicMsgData.setLinkUrl(sb.toString());
        return shareFromTopicMsgData;
    }

    public int getSortType() {
        return this.mainView.q() == 0 ? 1 : 0;
    }

    public int getTabPosBySortType(int i) {
        return i == 1 ? 0 : 1;
    }

    public String getTopicName() {
        return this.topicName;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public d.b.c.e.k.b<TbImageView> getUserIconPool() {
        if (this.mUserIconPool == null) {
            this.mUserIconPool = UserIconBox.c(getPageContext().getPageActivity(), 8);
        }
        return this.mUserIconPool;
    }

    public int getUserIconViewId() {
        return HotThreadItemHolder.b();
    }

    @Override // com.baidu.tieba.hottopic.controller.HotRelateThreadModel.c
    public void hotRelateThreadCallback(boolean z, d.b.j0.c1.c.d dVar, int i) {
        if (z && dVar != null && !ListUtils.isEmpty(this.mHotTopicDataList) && ListUtils.getCount(dVar.E3) != 0) {
            d.b.j0.c1.c.e eVar = (d.b.j0.c1.c.e) ListUtils.getItem(this.mHotTopicDataList, getTabPosBySortType(i));
            if (eVar == null) {
                this.mainView.w(getTabPosBySortType(i));
                return;
            }
            eVar.a(dVar);
            this.mainView.A(this.mHotTopicDataList);
            updateReqPageInfo(i, dVar.F3);
            return;
        }
        this.mainView.w(getTabPosBySortType(i));
    }

    @Override // com.baidu.tieba.hottopic.controller.HotTopicModel.b
    public void hotTopicDataCallback(boolean z, d.b.j0.c1.c.e eVar) {
        hideLoadingView(this.mainView.u());
        if (this.mainView == null) {
            return;
        }
        if (this.mHotTopicDataList == null) {
            this.mHotTopicDataList = new ArrayList();
        }
        if (this.mHotTopicDataList.size() != 2) {
            this.mHotTopicDataList.clear();
        }
        if (this.mHotTopicDataList.size() == 0) {
            d.b.j0.c1.c.e eVar2 = new d.b.j0.c1.c.e();
            d.b.j0.c1.c.e eVar3 = new d.b.j0.c1.c.e();
            eVar2.s = 1;
            eVar3.s = 0;
            this.mHotTopicDataList.add(eVar2);
            this.mHotTopicDataList.add(eVar3);
        }
        if (eVar.s == 1) {
            this.mHotTopicDataList.set(0, eVar);
        } else {
            this.mHotTopicDataList.set(1, eVar);
        }
        this.mIsGlobalBlock = eVar.f();
        if (eVar.c() != null && eVar.d() != null) {
            this.mainView.y(8, true, 0L, 0);
        } else if (eVar.c() != null) {
            this.mainView.y(0, true, eVar.c().f53913e, eVar.c().f53914f);
        } else if (eVar.d() != null) {
            this.mainView.y(0, false, eVar.d().f53913e, eVar.d().f53914f);
        }
        this.mainView.A(this.mHotTopicDataList);
        this.mainView.L(eVar);
        this.mainView.C();
        updateReqPageInfo(eVar.s, eVar.j());
    }

    public void loadHotTopicData() {
        HotTopicModel hotTopicModel;
        if (j.z() && (hotTopicModel = this.hotTopicModel) != null) {
            hotTopicModel.v(this.topicId, this.topicName, getSortType(), this.fid, this.firstDir, this.secondDir, this.mFrom, this.mTid);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 13003) {
                if (intent == null) {
                    return;
                }
                PostWriteCallBackData postWriteCallBackData = null;
                try {
                    postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                } catch (Exception unused) {
                }
                if (postWriteCallBackData != null) {
                    long f2 = d.b.c.e.m.b.f(postWriteCallBackData.getPostId(), 0L);
                    long f3 = d.b.c.e.m.b.f(postWriteCallBackData.getThreadId(), 0L);
                    d.b.j0.c1.f.c cVar = this.mainView;
                    long f4 = (cVar == null || ListUtils.getItem(this.mDataList, cVar.q()) == null) ? 0L : d.b.c.e.m.b.f(String.valueOf(((HotTopicBussinessData) ListUtils.getItem(this.mDataList, this.mainView.q())).mForumId), 0L);
                    if (f2 != 0 && f3 != 0) {
                        int k = l.k(TbadkCoreApplication.getInst());
                        int i3 = l.i(TbadkCoreApplication.getInst());
                        float f5 = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                        int i4 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
                        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                        requestGetMyPostNetMessage.setParams(f3, f2, f4, k, i3, f5, i4);
                        sendMessage(requestGetMyPostNetMessage);
                    }
                }
                checkVideoEasterEgg(postWriteCallBackData);
            } else if (i == 18003) {
                String stringExtra = intent.getStringExtra("tid");
                if (stringExtra != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001390, stringExtra));
                }
            } else if (i != 23003) {
                if (i != 23007 || intent == null || ListUtils.isEmpty(this.mHotTopicDataList)) {
                    return;
                }
                this.hotTopicShareModel.d(getShareFromTopicMsgData(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra("name_show"), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT), this.mHotTopicDataList.get(0));
            } else if (intent == null || ListUtils.isEmpty(this.mHotTopicDataList)) {
            } else {
                this.hotTopicShareModel.c(getShareFromTopicMsgData(), intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L), this.mHotTopicDataList.get(0));
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mainView.B(i);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initParamsFromIntent(bundle);
        this.mainView = new d.b.j0.c1.f.c(getPageContext(), this.topicId);
        HotTopicModel hotTopicModel = new HotTopicModel(this);
        this.hotTopicModel = hotTopicModel;
        hotTopicModel.y(this);
        LikeModel likeModel = new LikeModel(getPageContext());
        this.likeModel = likeModel;
        likeModel.setLoadDataCallBack(this.mLikeModelCallback);
        HotRelateThreadModel hotRelateThreadModel = new HotRelateThreadModel(this);
        this.hotRelateThreadModel = hotRelateThreadModel;
        hotRelateThreadModel.A(this);
        this.hotRelateThreadModel.z(this);
        this.hotTopicShareModel = new d.b.j0.c1.b.b(this);
        this.blessModel = new BlessModel(this);
        initListeners();
        firstTimeLoadHotTopicData();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        t.b().c();
        d.b.j0.c1.f.c cVar = this.mainView;
        if (cVar != null) {
            cVar.p();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        d.b.j0.c1.f.c cVar;
        if (j.z() && (cVar = this.mainView) != null) {
            cVar.x();
            this.mainView.I(0);
            loadHotTopicData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
        TiebaStatic.log(new StatisticItem("c10817").param(TiebaStatic.Params.OBJ_DURATION, String.valueOf(System.currentTimeMillis() - this.lastResumeTime)));
        setRequestedOrientation(1);
        d.b.j0.c1.f.c cVar = this.mainView;
        if (cVar != null) {
            cVar.D();
        }
        super.onPause();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.lastResumeTime = System.currentTimeMillis();
        super.onResume();
        d.b.j0.c1.f.c cVar = this.mainView;
        if (cVar != null) {
            cVar.F();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (StringUtils.isNull(this.topicName) && StringUtils.isNull(this.topicId)) {
            return;
        }
        bundle.putString("topic_id", this.topicId);
        bundle.putString(IntentConfig.TOPIC_NAME, this.topicName);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        if (this.mainView != null && !ListUtils.isEmpty(this.mHotTopicDataList) && j.z()) {
            d.b.j0.c1.c.e eVar = (d.b.j0.c1.c.e) ListUtils.getItem(this.mHotTopicDataList, this.mainView.q());
            if (eVar != null && eVar.j() != null) {
                if (eVar.r && this.mIsLoadComplete) {
                    this.hotRelateThreadModel.w(eVar, getSortType());
                    this.mIsLoadComplete = false;
                    return;
                }
                return;
            }
            updateLoadingMoreForNetError();
            return;
        }
        updateLoadingMoreForNetError();
    }

    public void sendBlessData() {
        if (this.blessModel == null || ListUtils.isEmpty(this.mHotTopicDataList) || !j.z()) {
            return;
        }
        d.b.j0.c1.c.a c2 = this.mHotTopicDataList.get(0).c();
        d.b.j0.c1.c.a d2 = this.mHotTopicDataList.get(0).d();
        if (c2 != null) {
            this.blessModel.s(c2.f53915g, Long.parseLong(this.topicId), 1, 0, 1, c2.f53916h);
        } else if (d2 != null) {
            this.blessModel.s(d2.f53915g, Long.parseLong(this.topicId), 1, 0, 1, d2.f53916h);
        }
    }

    public void sendPkData() {
        i g2;
        if (this.blessModel == null || ListUtils.isEmpty(this.mHotTopicDataList) || !j.z() || (g2 = this.mHotTopicDataList.get(0).g()) == null) {
            return;
        }
        this.blessModel.s(g2.l, Long.parseLong(this.topicId), g2.k, 0, 0, g2.m);
    }

    public void shareTopic() {
        f h2;
        if (ListUtils.isEmpty(this.mHotTopicDataList) || (h2 = this.mHotTopicDataList.get(0).h()) == null) {
            return;
        }
        this.hotTopicShareModel.e(h2.f53933e, h2.f53934f, null, h2.k, h2.j, true);
    }
}

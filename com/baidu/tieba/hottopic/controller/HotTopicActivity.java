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
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.VideoEasterEggActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
import com.baidu.tieba.card.s;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.hottopic.controller.HotRelateThreadModel;
import com.baidu.tieba.hottopic.controller.HotTopicModel;
import com.baidu.tieba.hottopic.data.ShareFromTopicMsgData;
import com.baidu.tieba.hottopic.data.e;
import com.baidu.tieba.hottopic.data.f;
import com.baidu.tieba.hottopic.data.i;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.GetMyPost.User_Info;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes15.dex */
public class HotTopicActivity extends BaseActivity<HotTopicActivity> implements BdListView.e, UserIconBox.b, HotRelateThreadModel.a, HotRelateThreadModel.b, HotTopicModel.a, a, FrsCommonImageLayout.c {
    private long dNY;
    private com.baidu.adp.lib.d.b<TbImageView> evp;
    private long fid;
    private String firstDir;
    private b iXX;
    private BlessModel iYo;
    private LikeModel iYp;
    private com.baidu.adp.lib.d.b<TbImageView> iYq;
    private List<HotTopicBussinessData> mDataList;
    private List<e> mHotTopicDataList;
    private String secondDir;
    private com.baidu.tieba.hottopic.view.c iYl = null;
    private HotTopicModel iYm = null;
    private HotRelateThreadModel iYn = null;
    private String eoj = null;
    private String eab = null;
    private String mFrom = "";
    private long lastResumeTime = 0;
    private int mIsGlobalBlock = 0;
    private boolean iYr = true;
    private AntiHelper.a hUk = new AntiHelper.a() { // from class: com.baidu.tieba.hottopic.controller.HotTopicActivity.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ai("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ai("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }
    };
    private final com.baidu.adp.framework.listener.a hpZ = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.hottopic.controller.HotTopicActivity.2
        @Override // com.baidu.adp.framework.listener.a
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
                HotTopicActivity.this.a(getMyPostHttpResponseMessage.getError(), errorString2, getMyPostHttpResponseMessage.getResponseData());
            } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                if (StringUtils.isNull(getMyPostSocketResponseMessage.getErrorString())) {
                    errorString = HotTopicActivity.this.getResources().getString(R.string.neterror);
                } else {
                    errorString = getMyPostSocketResponseMessage.getErrorString();
                }
                HotTopicActivity.this.a(getMyPostSocketResponseMessage.getError(), errorString, getMyPostSocketResponseMessage.getResponseData());
            }
        }
    };
    private com.baidu.adp.base.d hvu = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.hottopic.controller.HotTopicActivity.3
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (!AntiHelper.bz(HotTopicActivity.this.iYp.getErrorCode(), HotTopicActivity.this.iYp.getErrorString())) {
                if (!StringUtils.isNull(HotTopicActivity.this.iYp.getErrorString())) {
                    l.showToast(TbadkCoreApplication.getInst(), HotTopicActivity.this.iYp.getErrorString());
                }
            } else if (AntiHelper.a(HotTopicActivity.this.getActivity(), HotTopicActivity.this.iYp.getErrorString(), HotTopicActivity.this.iYp.getErrorCode(), HotTopicActivity.this.hUk) != null) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ai("obj_locate", ax.a.LOCATE_LIKE_PERSON));
            }
        }
    };

    private void a(User.Builder builder, User_Info user_Info) {
        if (user_Info != null) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0) {
            showToast(str);
        } else if (this.iYl != null && y.getItem(this.mHotTopicDataList, this.iYl.getCurrentTab()) != null && this.iYl.cAu() != null) {
            e eVar = (e) y.getItem(this.mHotTopicDataList, this.iYl.getCurrentTab());
            as asVar = new as();
            ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
            User.Builder builder2 = new User.Builder(builder.author);
            a(builder2, getMyPostResIdl.data.user_info);
            builder.author = builder2.build(true);
            asVar.a(builder.build(true));
            eVar.aD(asVar);
            this.iYl.cAu().d(eVar);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        as(bundle);
        this.iYl = new com.baidu.tieba.hottopic.view.c(getPageContext(), this.eoj);
        this.iYm = new HotTopicModel(this);
        this.iYm.a(this);
        this.iYp = new LikeModel(getPageContext());
        this.iYp.setLoadDataCallBack(this.hvu);
        this.iYn = new HotRelateThreadModel(this);
        this.iYn.a((HotRelateThreadModel.a) this);
        this.iYn.a((HotRelateThreadModel.b) this);
        this.iXX = new b(this);
        this.iYo = new BlessModel(this);
        bMg();
        czD();
    }

    private void czD() {
        showLoadingView(this.iYl.cAo(), false);
        if (!j.isNetworkAvailableForImmediately()) {
            hideLoadingView(this.iYl.cAo());
            showNetRefreshView(this.iYl.cAo(), getResources().getString(R.string.neterror), true);
            setNetRefreshViewTopMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds530));
            this.iYl.Aw(8);
            return;
        }
        this.iYl.Aw(0);
        czF();
    }

    private void as(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.eoj = intent.getStringExtra("topic_id");
            this.eab = intent.getStringExtra("topic_name");
            this.fid = intent.getLongExtra("topic_fid", 0L);
            this.firstDir = intent.getStringExtra("topic_first_dir");
            this.secondDir = intent.getStringExtra("topic_second_dir");
            this.mFrom = intent.getStringExtra("from");
            this.dNY = intent.getLongExtra(IntentConfig.TOPIC_TID, 0L);
        } else if (bundle != null) {
            this.eoj = bundle.getString("topic_id");
            this.eab = bundle.getString("topic_name");
            this.fid = bundle.getLong("topic_fid", 0L);
            this.firstDir = bundle.getString("topic_first_dir");
            this.secondDir = bundle.getString("topic_second_dir");
            this.mFrom = bundle.getString("from");
            this.mFrom = bundle.getString("from");
            this.dNY = bundle.getLong(IntentConfig.TOPIC_TID, 0L);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onResume() {
        this.lastResumeTime = System.currentTimeMillis();
        super.onResume();
        if (this.iYl != null) {
            this.iYl.resume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(e eVar) {
        if (this.mDataList == null) {
            this.mDataList = new ArrayList();
        } else {
            this.mDataList.clear();
        }
        this.mDataList.add(new HotTopicBussinessData(0L, "", eVar.czY().eab, this.mIsGlobalBlock));
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_WRITE_NEW /* 13003 */:
                    if (intent != null) {
                        try {
                            postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                        } catch (Exception e) {
                            postWriteCallBackData = null;
                        }
                        if (postWriteCallBackData != null) {
                            long j = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
                            long j2 = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
                            long j3 = 0;
                            if (this.iYl != null && y.getItem(this.mDataList, this.iYl.getCurrentTab()) != null) {
                                j3 = com.baidu.adp.lib.f.b.toLong(String.valueOf(((HotTopicBussinessData) y.getItem(this.mDataList, this.iYl.getCurrentTab())).mForumId), 0L);
                            }
                            if (j != 0 && j2 != 0) {
                                int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                                int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                                float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                                int i3 = 1;
                                if (au.bjr().bjs()) {
                                    i3 = 2;
                                }
                                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                                requestGetMyPostNetMessage.setParams(j2, j, j3, equipmentWidth, equipmentHeight, f, i3);
                                sendMessage(requestGetMyPostNetMessage);
                            }
                        }
                        d(postWriteCallBackData);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_FRS_TO_PB /* 18003 */:
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR, stringExtra));
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SELECT_IM_CHAT_GROUP_CODE /* 23003 */:
                    if (intent != null && !y.isEmpty(this.mHotTopicDataList)) {
                        this.iXX.a(czE(), intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L), this.mHotTopicDataList.get(0));
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHARE_FRIEND_FORUM /* 23007 */:
                    if (intent != null && !y.isEmpty(this.mHotTopicDataList)) {
                        this.iXX.a(czE(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra("name_show"), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT), this.mHotTopicDataList.get(0));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onPause() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        TiebaStatic.log(new aq("c10817").dD("obj_duration", String.valueOf(System.currentTimeMillis() - this.lastResumeTime)));
        setRequestedOrientation(1);
        if (this.iYl != null) {
            this.iYl.pause();
        }
        super.onPause();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        s.cbX().bDV();
        if (this.iYl != null) {
            this.iYl.destroy();
        }
        super.onDestroy();
    }

    public ShareFromTopicMsgData czE() {
        f czY;
        if (!y.isEmpty(this.mHotTopicDataList) && (czY = this.mHotTopicDataList.get(0).czY()) != null) {
            StringBuilder sb = new StringBuilder();
            ShareFromTopicMsgData shareFromTopicMsgData = new ShareFromTopicMsgData();
            shareFromTopicMsgData.setContent(czY.shareTitle);
            shareFromTopicMsgData.setImageUrl(czY.iTh);
            shareFromTopicMsgData.setTitle(czY.eab);
            shareFromTopicMsgData.setHotTopicID(czY.eoj);
            shareFromTopicMsgData.setHotTopicName(czY.eab);
            sb.append("http://tieba.baidu.com/").append("mo/q/hotMessage?topic_id=").append(czY.eoj).append("&topic_name=").append(czY.eab);
            shareFromTopicMsgData.setLinkUrl(sb.toString());
            return shareFromTopicMsgData;
        }
        return null;
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iYl.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.hottopic.controller.HotTopicModel.a
    public void a(boolean z, e eVar) {
        hideLoadingView(this.iYl.cAo());
        if (this.iYl != null) {
            if (this.mHotTopicDataList == null) {
                this.mHotTopicDataList = new ArrayList();
            }
            if (this.mHotTopicDataList.size() != 2) {
                this.mHotTopicDataList.clear();
            }
            if (this.mHotTopicDataList.size() == 0) {
                e eVar2 = new e();
                e eVar3 = new e();
                eVar2.sortType = 1;
                eVar3.sortType = 0;
                this.mHotTopicDataList.add(eVar2);
                this.mHotTopicDataList.add(eVar3);
            }
            if (eVar.sortType == 1) {
                this.mHotTopicDataList.set(0, eVar);
            } else {
                this.mHotTopicDataList.set(1, eVar);
            }
            this.mIsGlobalBlock = eVar.cAi();
            if (eVar.cAa() != null && eVar.cAb() != null) {
                this.iYl.a(8, true, 0L, 0);
            } else if (eVar.cAa() != null) {
                this.iYl.a(0, true, eVar.cAa().totalNum, eVar.cAa().iYK);
            } else if (eVar.cAb() != null) {
                this.iYl.a(0, false, eVar.cAb().totalNum, eVar.cAb().iYK);
            }
            this.iYl.du(this.mHotTopicDataList);
            this.iYl.c(eVar);
            this.iYl.cAq();
            a(eVar.sortType, eVar.getPageData());
        }
    }

    public void czF() {
        if (j.isNetWorkAvailable() && this.iYm != null) {
            this.iYm.a(this.eoj, this.eab, getSortType(), this.fid, this.firstDir, this.secondDir, this.mFrom, this.dNY);
        }
    }

    public void czG() {
        if (this.iYo != null && !y.isEmpty(this.mHotTopicDataList) && j.isNetWorkAvailable()) {
            com.baidu.tieba.hottopic.data.a cAa = this.mHotTopicDataList.get(0).cAa();
            com.baidu.tieba.hottopic.data.a cAb = this.mHotTopicDataList.get(0).cAb();
            if (cAa != null) {
                this.iYo.a(cAa.pkId, Long.parseLong(this.eoj), 1, 0, 1, cAa.userPkId);
            } else if (cAb != null) {
                this.iYo.a(cAb.pkId, Long.parseLong(this.eoj), 1, 0, 1, cAb.userPkId);
            }
        }
    }

    public void czH() {
        i czZ;
        if (this.iYo != null && !y.isEmpty(this.mHotTopicDataList) && j.isNetWorkAvailable() && (czZ = this.mHotTopicDataList.get(0).czZ()) != null) {
            this.iYo.a(czZ.pkId, Long.parseLong(this.eoj), czZ.iYK, 0, 0, czZ.userPkId);
        }
    }

    private void bMg() {
        this.iYl.b(new View.OnTouchListener() { // from class: com.baidu.tieba.hottopic.controller.HotTopicActivity.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                e eVar;
                if (!bg.checkUpIsLogin(HotTopicActivity.this.getActivity()) || motionEvent.getAction() != 1 || (eVar = (e) y.getItem(HotTopicActivity.this.mHotTopicDataList, HotTopicActivity.this.iYl.getCurrentTab())) == null) {
                    return true;
                }
                if (!j.isNetWorkAvailable()) {
                    l.showToast(HotTopicActivity.this.getPageContext().getContext(), R.string.no_network_guide);
                }
                HotTopicActivity.this.b(eVar);
                WriteActivityConfig writeActivityConfig = new WriteActivityConfig(HotTopicActivity.this.getPageContext().getPageActivity(), 9, String.valueOf(0), "", null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0);
                writeActivityConfig.getIntent().putExtra("hot_topic_forum_list", (Serializable) HotTopicActivity.this.mDataList);
                writeActivityConfig.getIntent().putExtra(WriteActivityConfig.HOT_TOPIC_ID, HotTopicActivity.this.eoj);
                writeActivityConfig.setCallFrom("1");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                aq aqVar = new aq(CommonStatisticKey.KEY_ENTRANCE_CLICKED);
                aqVar.ai("obj_locate", 6).ai("obj_type", 1);
                TiebaStatic.log(aqVar);
                return true;
            }
        });
        this.iYl.g(new NoNetworkView.a() { // from class: com.baidu.tieba.hottopic.controller.HotTopicActivity.5
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                HotTopicActivity.this.iYl.pY(!z);
                if (z && HotTopicActivity.this.iYm != null && y.getItem(HotTopicActivity.this.mHotTopicDataList, HotTopicActivity.this.iYl.getCurrentTab()) != null) {
                    e eVar = (e) HotTopicActivity.this.mHotTopicDataList.get(HotTopicActivity.this.iYl.getCurrentTab());
                    if (eVar == null || y.isEmpty(eVar.cAf())) {
                        HotTopicActivity.this.iYl.bFW();
                        HotTopicActivity.this.iYl.showLoadingView();
                        HotTopicActivity.this.czF();
                    }
                }
            }
        });
        this.hpZ.getSocketMessageListener().setSelfListener(true);
        this.hpZ.getHttpMessageListener().setSelfListener(true);
        registerListener(this.hpZ);
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> clf() {
        if (this.iYq == null) {
            this.iYq = FrsCommonImageLayout.D(getPageContext().getPageActivity(), 12);
        }
        return this.iYq;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> bld() {
        if (this.evp == null) {
            this.evp = UserIconBox.u(getPageContext().getPageActivity(), 8);
        }
        return this.evp;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public ListView blc() {
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.iYl == null || y.isEmpty(this.mHotTopicDataList) || !j.isNetWorkAvailable()) {
            czI();
            return;
        }
        e eVar = (e) y.getItem(this.mHotTopicDataList, this.iYl.getCurrentTab());
        if (eVar == null || eVar.getPageData() == null) {
            czI();
        } else if (eVar.iZl && this.iYr) {
            this.iYn.b(eVar, getSortType());
            this.iYr = false;
        }
    }

    public int getSortType() {
        return this.iYl.getCurrentTab() == 0 ? 1 : 0;
    }

    public int Aq(int i) {
        return i == 1 ? 0 : 1;
    }

    @Override // com.baidu.tieba.hottopic.controller.HotRelateThreadModel.a
    public void complete() {
        this.iYr = true;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (!StringUtils.isNull(this.eab) || !StringUtils.isNull(this.eoj)) {
            bundle.putString("topic_id", this.eoj);
            bundle.putString("topic_name", this.eab);
        }
    }

    @Override // com.baidu.tieba.hottopic.controller.HotRelateThreadModel.b
    public void a(boolean z, com.baidu.tieba.hottopic.data.d dVar, int i) {
        if (!z || dVar == null || y.isEmpty(this.mHotTopicDataList) || y.getCount(dVar.fku) == 0) {
            this.iYl.Ao(Aq(i));
            return;
        }
        e eVar = (e) y.getItem(this.mHotTopicDataList, Aq(i));
        if (eVar == null) {
            this.iYl.Ao(Aq(i));
            return;
        }
        eVar.a(dVar);
        this.iYl.du(this.mHotTopicDataList);
        a(i, dVar.pageData);
    }

    private void a(int i, av avVar) {
        if (avVar != null) {
            int Aq = Aq(i);
            e eVar = (e) y.getItem(this.mHotTopicDataList, Aq);
            if (eVar != null) {
                eVar.a(avVar);
            }
            if (avVar.bdu() != 0) {
                this.iYl.Am(Aq);
                return;
            }
            this.iYl.Ao(Aq);
            this.iYl.An(Aq);
        }
    }

    private void czI() {
        int Aq = Aq(getSortType());
        e eVar = (e) y.getItem(this.mHotTopicDataList, Aq);
        if (eVar == null || eVar.getPageData() == null) {
            this.iYl.Ao(Aq);
            return;
        }
        if (eVar.getPageData().bdu() != 0) {
            this.iYl.Ao(Aq);
            return;
        }
        this.iYl.Ao(Aq);
        this.iYl.An(Aq);
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable() && this.iYl != null) {
            this.iYl.bFW();
            this.iYl.Aw(0);
            czF();
        }
    }

    public String czJ() {
        return this.eoj;
    }

    public String getTopicName() {
        return this.eab;
    }

    public void czA() {
        f czY;
        if (!y.isEmpty(this.mHotTopicDataList) && (czY = this.mHotTopicDataList.get(0).czY()) != null) {
            this.iXX.b(czY.eoj, czY.eab, null, czY.iTh, czY.shareTitle, true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.HOT_TOPIC;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public void s(com.baidu.tieba.card.data.c cVar) {
        if (cVar != null && cVar.bce() != null) {
            aq aqVar = new aq("c13021");
            aqVar.dD("tid", cVar.bce().getTid()).u("fid", cVar.bce().getFid()).dD("obj_source", cVar.bce().mRecomSource).dD("obj_locate", getFrom()).dD("obj_name", getTopicName()).dD(TiebaInitialize.Params.OBJ_PARAM3, m.cbO()).dD("ab_tag", cVar.cck());
            s.cbX().e(aqVar);
        }
    }

    public void t(com.baidu.tieba.card.data.c cVar) {
        if (cVar != null && cVar.bce() != null) {
            com.baidu.tieba.hottopic.b.b.a(cVar.bce(), getTopicName(), getFrom(), cVar.objType);
        }
    }

    private boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || at.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this).createNormalConfig("from_hottopic", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }
}

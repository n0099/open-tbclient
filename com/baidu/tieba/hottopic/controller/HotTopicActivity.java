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
/* loaded from: classes21.dex */
public class HotTopicActivity extends BaseActivity<HotTopicActivity> implements BdListView.e, UserIconBox.b, HotRelateThreadModel.a, HotRelateThreadModel.b, HotTopicModel.a, a, FrsCommonImageLayout.c {
    private com.baidu.adp.lib.d.b<TbImageView> eJH;
    private long ecg;
    private long fid;
    private String firstDir;
    private LikeModel jeT;
    private b jvI;
    private BlessModel jvZ;
    private com.baidu.adp.lib.d.b<TbImageView> jwa;
    private List<HotTopicBussinessData> mDataList;
    private List<e> mHotTopicDataList;
    private String secondDir;
    private com.baidu.tieba.hottopic.view.c jvW = null;
    private HotTopicModel jvX = null;
    private HotRelateThreadModel jvY = null;
    private String eCP = null;
    private String eou = null;
    private String mFrom = "";
    private long lastResumeTime = 0;
    private int mIsGlobalBlock = 0;
    private boolean jwb = true;
    private AntiHelper.a iqr = new AntiHelper.a() { // from class: com.baidu.tieba.hottopic.controller.HotTopicActivity.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).aj("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).aj("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }
    };
    private final com.baidu.adp.framework.listener.a hMd = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.hottopic.controller.HotTopicActivity.2
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
    private com.baidu.adp.base.d hRA = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.hottopic.controller.HotTopicActivity.3
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (!AntiHelper.bM(HotTopicActivity.this.jeT.getErrorCode(), HotTopicActivity.this.jeT.getErrorString())) {
                if (!StringUtils.isNull(HotTopicActivity.this.jeT.getErrorString())) {
                    l.showToast(TbadkCoreApplication.getInst(), HotTopicActivity.this.jeT.getErrorString());
                }
            } else if (AntiHelper.a(HotTopicActivity.this.getActivity(), HotTopicActivity.this.jeT.getErrorString(), HotTopicActivity.this.jeT.getErrorCode(), HotTopicActivity.this.iqr) != null) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).aj("obj_locate", ax.a.LOCATE_LIKE_PERSON));
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
        } else if (this.jvW != null && y.getItem(this.mHotTopicDataList, this.jvW.getCurrentTab()) != null && this.jvW.cHL() != null) {
            e eVar = (e) y.getItem(this.mHotTopicDataList, this.jvW.getCurrentTab());
            as asVar = new as();
            ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
            User.Builder builder2 = new User.Builder(builder.author);
            a(builder2, getMyPostResIdl.data.user_info);
            builder.author = builder2.build(true);
            asVar.a(builder.build(true));
            eVar.aE(asVar);
            this.jvW.cHL().d(eVar);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        as(bundle);
        this.jvW = new com.baidu.tieba.hottopic.view.c(getPageContext(), this.eCP);
        this.jvX = new HotTopicModel(this);
        this.jvX.a(this);
        this.jeT = new LikeModel(getPageContext());
        this.jeT.setLoadDataCallBack(this.hRA);
        this.jvY = new HotRelateThreadModel(this);
        this.jvY.a((HotRelateThreadModel.a) this);
        this.jvY.a((HotRelateThreadModel.b) this);
        this.jvI = new b(this);
        this.jvZ = new BlessModel(this);
        bQI();
        cGU();
    }

    private void cGU() {
        showLoadingView(this.jvW.cHF(), false);
        if (!j.isNetworkAvailableForImmediately()) {
            hideLoadingView(this.jvW.cHF());
            showNetRefreshView(this.jvW.cHF(), getResources().getString(R.string.neterror), true);
            setNetRefreshViewTopMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds530));
            this.jvW.BD(8);
            return;
        }
        this.jvW.BD(0);
        cGW();
    }

    private void as(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.eCP = intent.getStringExtra("topic_id");
            this.eou = intent.getStringExtra("topic_name");
            this.fid = intent.getLongExtra("topic_fid", 0L);
            this.firstDir = intent.getStringExtra("topic_first_dir");
            this.secondDir = intent.getStringExtra("topic_second_dir");
            this.mFrom = intent.getStringExtra("from");
            this.ecg = intent.getLongExtra(IntentConfig.TOPIC_TID, 0L);
        } else if (bundle != null) {
            this.eCP = bundle.getString("topic_id");
            this.eou = bundle.getString("topic_name");
            this.fid = bundle.getLong("topic_fid", 0L);
            this.firstDir = bundle.getString("topic_first_dir");
            this.secondDir = bundle.getString("topic_second_dir");
            this.mFrom = bundle.getString("from");
            this.mFrom = bundle.getString("from");
            this.ecg = bundle.getLong(IntentConfig.TOPIC_TID, 0L);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onResume() {
        this.lastResumeTime = System.currentTimeMillis();
        super.onResume();
        if (this.jvW != null) {
            this.jvW.resume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(e eVar) {
        if (this.mDataList == null) {
            this.mDataList = new ArrayList();
        } else {
            this.mDataList.clear();
        }
        this.mDataList.add(new HotTopicBussinessData(0L, "", eVar.cHp().eou, this.mIsGlobalBlock));
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
                            if (this.jvW != null && y.getItem(this.mDataList, this.jvW.getCurrentTab()) != null) {
                                j3 = com.baidu.adp.lib.f.b.toLong(String.valueOf(((HotTopicBussinessData) y.getItem(this.mDataList, this.jvW.getCurrentTab())).mForumId), 0L);
                            }
                            if (j != 0 && j2 != 0) {
                                int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                                int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                                float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                                int i3 = 1;
                                if (au.bmV().bmW()) {
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
                        this.jvI.a(cGV(), intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L), this.mHotTopicDataList.get(0));
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHARE_FRIEND_FORUM /* 23007 */:
                    if (intent != null && !y.isEmpty(this.mHotTopicDataList)) {
                        this.jvI.a(cGV(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra("name_show"), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT), this.mHotTopicDataList.get(0));
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
        TiebaStatic.log(new aq("c10817").dK("obj_duration", String.valueOf(System.currentTimeMillis() - this.lastResumeTime)));
        setRequestedOrientation(1);
        if (this.jvW != null) {
            this.jvW.pause();
        }
        super.onPause();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        s.ciJ().bHY();
        if (this.jvW != null) {
            this.jvW.destroy();
        }
        super.onDestroy();
    }

    public ShareFromTopicMsgData cGV() {
        f cHp;
        if (!y.isEmpty(this.mHotTopicDataList) && (cHp = this.mHotTopicDataList.get(0).cHp()) != null) {
            StringBuilder sb = new StringBuilder();
            ShareFromTopicMsgData shareFromTopicMsgData = new ShareFromTopicMsgData();
            shareFromTopicMsgData.setContent(cHp.shareTitle);
            shareFromTopicMsgData.setImageUrl(cHp.jqS);
            shareFromTopicMsgData.setTitle(cHp.eou);
            shareFromTopicMsgData.setHotTopicID(cHp.eCP);
            shareFromTopicMsgData.setHotTopicName(cHp.eou);
            sb.append("http://tieba.baidu.com/").append("mo/q/hotMessage?topic_id=").append(cHp.eCP).append("&topic_name=").append(cHp.eou);
            shareFromTopicMsgData.setLinkUrl(sb.toString());
            return shareFromTopicMsgData;
        }
        return null;
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jvW.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.hottopic.controller.HotTopicModel.a
    public void a(boolean z, e eVar) {
        hideLoadingView(this.jvW.cHF());
        if (this.jvW != null) {
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
            this.mIsGlobalBlock = eVar.cHz();
            if (eVar.cHr() != null && eVar.cHs() != null) {
                this.jvW.a(8, true, 0L, 0);
            } else if (eVar.cHr() != null) {
                this.jvW.a(0, true, eVar.cHr().totalNum, eVar.cHr().jwu);
            } else if (eVar.cHs() != null) {
                this.jvW.a(0, false, eVar.cHs().totalNum, eVar.cHs().jwu);
            }
            this.jvW.dF(this.mHotTopicDataList);
            this.jvW.c(eVar);
            this.jvW.cHH();
            a(eVar.sortType, eVar.getPageData());
        }
    }

    public void cGW() {
        if (j.isNetWorkAvailable() && this.jvX != null) {
            this.jvX.a(this.eCP, this.eou, getSortType(), this.fid, this.firstDir, this.secondDir, this.mFrom, this.ecg);
        }
    }

    public void cGX() {
        if (this.jvZ != null && !y.isEmpty(this.mHotTopicDataList) && j.isNetWorkAvailable()) {
            com.baidu.tieba.hottopic.data.a cHr = this.mHotTopicDataList.get(0).cHr();
            com.baidu.tieba.hottopic.data.a cHs = this.mHotTopicDataList.get(0).cHs();
            if (cHr != null) {
                this.jvZ.a(cHr.pkId, Long.parseLong(this.eCP), 1, 0, 1, cHr.userPkId);
            } else if (cHs != null) {
                this.jvZ.a(cHs.pkId, Long.parseLong(this.eCP), 1, 0, 1, cHs.userPkId);
            }
        }
    }

    public void cGY() {
        i cHq;
        if (this.jvZ != null && !y.isEmpty(this.mHotTopicDataList) && j.isNetWorkAvailable() && (cHq = this.mHotTopicDataList.get(0).cHq()) != null) {
            this.jvZ.a(cHq.pkId, Long.parseLong(this.eCP), cHq.jwu, 0, 0, cHq.userPkId);
        }
    }

    private void bQI() {
        this.jvW.b(new View.OnTouchListener() { // from class: com.baidu.tieba.hottopic.controller.HotTopicActivity.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                e eVar;
                if (!bg.checkUpIsLogin(HotTopicActivity.this.getActivity()) || motionEvent.getAction() != 1 || (eVar = (e) y.getItem(HotTopicActivity.this.mHotTopicDataList, HotTopicActivity.this.jvW.getCurrentTab())) == null) {
                    return true;
                }
                if (!j.isNetWorkAvailable()) {
                    l.showToast(HotTopicActivity.this.getPageContext().getContext(), R.string.no_network_guide);
                }
                HotTopicActivity.this.b(eVar);
                WriteActivityConfig writeActivityConfig = new WriteActivityConfig(HotTopicActivity.this.getPageContext().getPageActivity(), 9, String.valueOf(0), "", null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0);
                writeActivityConfig.getIntent().putExtra("hot_topic_forum_list", (Serializable) HotTopicActivity.this.mDataList);
                writeActivityConfig.getIntent().putExtra(WriteActivityConfig.HOT_TOPIC_ID, HotTopicActivity.this.eCP);
                writeActivityConfig.setCallFrom("1");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                aq aqVar = new aq(CommonStatisticKey.KEY_ENTRANCE_CLICKED);
                aqVar.aj("obj_locate", 6).aj("obj_type", 1);
                TiebaStatic.log(aqVar);
                return true;
            }
        });
        this.jvW.g(new NoNetworkView.a() { // from class: com.baidu.tieba.hottopic.controller.HotTopicActivity.5
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                HotTopicActivity.this.jvW.qO(!z);
                if (z && HotTopicActivity.this.jvX != null && y.getItem(HotTopicActivity.this.mHotTopicDataList, HotTopicActivity.this.jvW.getCurrentTab()) != null) {
                    e eVar = (e) HotTopicActivity.this.mHotTopicDataList.get(HotTopicActivity.this.jvW.getCurrentTab());
                    if (eVar == null || y.isEmpty(eVar.cHw())) {
                        HotTopicActivity.this.jvW.SK();
                        HotTopicActivity.this.jvW.showLoadingView();
                        HotTopicActivity.this.cGW();
                    }
                }
            }
        });
        this.hMd.getSocketMessageListener().setSelfListener(true);
        this.hMd.getHttpMessageListener().setSelfListener(true);
        registerListener(this.hMd);
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> crR() {
        if (this.jwa == null) {
            this.jwa = FrsCommonImageLayout.G(getPageContext().getPageActivity(), 12);
        }
        return this.jwa;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> boI() {
        if (this.eJH == null) {
            this.eJH = UserIconBox.u(getPageContext().getPageActivity(), 8);
        }
        return this.eJH;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public ListView boH() {
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.jvW == null || y.isEmpty(this.mHotTopicDataList) || !j.isNetWorkAvailable()) {
            cGZ();
            return;
        }
        e eVar = (e) y.getItem(this.mHotTopicDataList, this.jvW.getCurrentTab());
        if (eVar == null || eVar.getPageData() == null) {
            cGZ();
        } else if (eVar.jwV && this.jwb) {
            this.jvY.b(eVar, getSortType());
            this.jwb = false;
        }
    }

    public int getSortType() {
        return this.jvW.getCurrentTab() == 0 ? 1 : 0;
    }

    public int Bx(int i) {
        return i == 1 ? 0 : 1;
    }

    @Override // com.baidu.tieba.hottopic.controller.HotRelateThreadModel.a
    public void complete() {
        this.jwb = true;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (!StringUtils.isNull(this.eou) || !StringUtils.isNull(this.eCP)) {
            bundle.putString("topic_id", this.eCP);
            bundle.putString("topic_name", this.eou);
        }
    }

    @Override // com.baidu.tieba.hottopic.controller.HotRelateThreadModel.b
    public void a(boolean z, com.baidu.tieba.hottopic.data.d dVar, int i) {
        if (!z || dVar == null || y.isEmpty(this.mHotTopicDataList) || y.getCount(dVar.fzF) == 0) {
            this.jvW.Bv(Bx(i));
            return;
        }
        e eVar = (e) y.getItem(this.mHotTopicDataList, Bx(i));
        if (eVar == null) {
            this.jvW.Bv(Bx(i));
            return;
        }
        eVar.a(dVar);
        this.jvW.dF(this.mHotTopicDataList);
        a(i, dVar.pageData);
    }

    private void a(int i, av avVar) {
        if (avVar != null) {
            int Bx = Bx(i);
            e eVar = (e) y.getItem(this.mHotTopicDataList, Bx);
            if (eVar != null) {
                eVar.a(avVar);
            }
            if (avVar.bgX() != 0) {
                this.jvW.Bt(Bx);
                return;
            }
            this.jvW.Bv(Bx);
            this.jvW.Bu(Bx);
        }
    }

    private void cGZ() {
        int Bx = Bx(getSortType());
        e eVar = (e) y.getItem(this.mHotTopicDataList, Bx);
        if (eVar == null || eVar.getPageData() == null) {
            this.jvW.Bv(Bx);
            return;
        }
        if (eVar.getPageData().bgX() != 0) {
            this.jvW.Bv(Bx);
            return;
        }
        this.jvW.Bv(Bx);
        this.jvW.Bu(Bx);
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable() && this.jvW != null) {
            this.jvW.SK();
            this.jvW.BD(0);
            cGW();
        }
    }

    public String cHa() {
        return this.eCP;
    }

    public String getTopicName() {
        return this.eou;
    }

    public void cGR() {
        f cHp;
        if (!y.isEmpty(this.mHotTopicDataList) && (cHp = this.mHotTopicDataList.get(0).cHp()) != null) {
            this.jvI.c(cHp.eCP, cHp.eou, null, cHp.jqS, cHp.shareTitle, true);
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
        if (cVar != null && cVar.bfG() != null) {
            aq aqVar = new aq("c13021");
            aqVar.dK("tid", cVar.bfG().getTid()).u("fid", cVar.bfG().getFid()).dK("obj_source", cVar.bfG().mRecomSource).dK("obj_locate", getFrom()).dK("obj_name", getTopicName()).dK(TiebaInitialize.Params.OBJ_PARAM3, m.ciA()).dK("ab_tag", cVar.ciW());
            s.ciJ().e(aqVar);
        }
    }

    public void t(com.baidu.tieba.card.data.c cVar) {
        if (cVar != null && cVar.bfG() != null) {
            com.baidu.tieba.hottopic.b.b.a(cVar.bfG(), getTopicName(), getFrom(), cVar.objType);
        }
    }

    private boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || at.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.blO().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this).createNormalConfig("from_hottopic", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }
}

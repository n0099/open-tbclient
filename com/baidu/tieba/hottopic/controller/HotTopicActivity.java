package com.baidu.tieba.hottopic.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
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
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.VideoEasterEggActivityConfig;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.data.au;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.x;
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
import java.util.ArrayList;
import java.util.List;
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.GetMyPost.User_Info;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes7.dex */
public class HotTopicActivity extends BaseActivity<HotTopicActivity> implements BdListView.e, UserIconBox.a, HotRelateThreadModel.a, HotRelateThreadModel.b, HotTopicModel.a, a, FrsCommonImageLayout.c {
    private long eAs;
    private long fid;
    private String firstDir;
    private com.baidu.adp.lib.d.b<TbImageView> fjw;
    private LikeModel jUs;
    private b klb;
    private BlessModel kls;
    private com.baidu.adp.lib.d.b<TbImageView> klt;
    private List<HotTopicBussinessData> mDataList;
    private List<e> mHotTopicDataList;
    private String secondDir;
    private com.baidu.tieba.hottopic.view.c klp = null;
    private HotTopicModel klq = null;
    private HotRelateThreadModel klr = null;
    private String fci = null;
    private String eNh = null;
    private String mFrom = "";
    private long lastResumeTime = 0;
    private int mIsGlobalBlock = 0;
    private boolean klu = true;
    private AntiHelper.a jbW = new AntiHelper.a() { // from class: com.baidu.tieba.hottopic.controller.HotTopicActivity.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).an("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).an("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }
    };
    private final com.baidu.adp.framework.listener.a ixZ = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.hottopic.controller.HotTopicActivity.2
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
    private com.baidu.adp.base.e iDn = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.hottopic.controller.HotTopicActivity.3
        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            if (!AntiHelper.bQ(HotTopicActivity.this.jUs.getErrorCode(), HotTopicActivity.this.jUs.getErrorString())) {
                if (!StringUtils.isNull(HotTopicActivity.this.jUs.getErrorString())) {
                    l.showToast(TbadkCoreApplication.getInst(), HotTopicActivity.this.jUs.getErrorString());
                }
            } else if (AntiHelper.a(HotTopicActivity.this.getActivity(), HotTopicActivity.this.jUs.getErrorString(), HotTopicActivity.this.jUs.getErrorCode(), HotTopicActivity.this.jbW) != null) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).an("obj_locate", ax.a.LOCATE_LIKE_PERSON));
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
        } else if (this.klp != null && x.getItem(this.mHotTopicDataList, this.klp.getCurrentTab()) != null && this.klp.cRD() != null) {
            e eVar = (e) x.getItem(this.mHotTopicDataList, this.klp.getCurrentTab());
            au auVar = new au();
            ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
            User.Builder builder2 = new User.Builder(builder.author);
            a(builder2, getMyPostResIdl.data.user_info);
            builder.author = builder2.build(true);
            auVar.a(builder.build(true));
            eVar.aH(auVar);
            this.klp.cRD().c(eVar);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        an(bundle);
        this.klp = new com.baidu.tieba.hottopic.view.c(getPageContext(), this.fci);
        this.klq = new HotTopicModel(this);
        this.klq.a(this);
        this.jUs = new LikeModel(getPageContext());
        this.jUs.setLoadDataCallBack(this.iDn);
        this.klr = new HotRelateThreadModel(this);
        this.klr.a((HotRelateThreadModel.a) this);
        this.klr.a((HotRelateThreadModel.b) this);
        this.klb = new b(this);
        this.kls = new BlessModel(this);
        bYg();
        cQN();
    }

    private void cQN() {
        showLoadingView(this.klp.cRx(), false);
        if (!j.isNetworkAvailableForImmediately()) {
            hideLoadingView(this.klp.cRx());
            showNetRefreshView(this.klp.cRx(), getResources().getString(R.string.neterror), true);
            setNetRefreshViewTopMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds530));
            this.klp.Ce(8);
            return;
        }
        this.klp.Ce(0);
        cQP();
    }

    private void an(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.fci = intent.getStringExtra("topic_id");
            this.eNh = intent.getStringExtra("topic_name");
            this.fid = intent.getLongExtra("topic_fid", 0L);
            this.firstDir = intent.getStringExtra("topic_first_dir");
            this.secondDir = intent.getStringExtra("topic_second_dir");
            this.mFrom = intent.getStringExtra("from");
            this.eAs = intent.getLongExtra(IntentConfig.TOPIC_TID, 0L);
        } else if (bundle != null) {
            this.fci = bundle.getString("topic_id");
            this.eNh = bundle.getString("topic_name");
            this.fid = bundle.getLong("topic_fid", 0L);
            this.firstDir = bundle.getString("topic_first_dir");
            this.secondDir = bundle.getString("topic_second_dir");
            this.mFrom = bundle.getString("from");
            this.mFrom = bundle.getString("from");
            this.eAs = bundle.getLong(IntentConfig.TOPIC_TID, 0L);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onResume() {
        this.lastResumeTime = System.currentTimeMillis();
        super.onResume();
        if (this.klp != null) {
            this.klp.resume();
        }
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
                            if (this.klp != null && x.getItem(this.mDataList, this.klp.getCurrentTab()) != null) {
                                j3 = com.baidu.adp.lib.f.b.toLong(String.valueOf(((HotTopicBussinessData) x.getItem(this.mDataList, this.klp.getCurrentTab())).mForumId), 0L);
                            }
                            if (j != 0 && j2 != 0) {
                                int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                                int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                                float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                                int i3 = 1;
                                if (com.baidu.tbadk.core.util.au.bsy().bsz()) {
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
                    if (intent != null && !x.isEmpty(this.mHotTopicDataList)) {
                        this.klb.a(cQO(), intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L), this.mHotTopicDataList.get(0));
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHARE_FRIEND_FORUM /* 23007 */:
                    if (intent != null && !x.isEmpty(this.mHotTopicDataList)) {
                        this.klb.a(cQO(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra("name_show"), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT), this.mHotTopicDataList.get(0));
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
        TiebaStatic.log(new aq("c10817").dW("obj_duration", String.valueOf(System.currentTimeMillis() - this.lastResumeTime)));
        setRequestedOrientation(1);
        if (this.klp != null) {
            this.klp.pause();
        }
        super.onPause();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        s.crj().bOb();
        if (this.klp != null) {
            this.klp.destroy();
        }
        super.onDestroy();
    }

    public ShareFromTopicMsgData cQO() {
        f cRi;
        if (!x.isEmpty(this.mHotTopicDataList) && (cRi = this.mHotTopicDataList.get(0).cRi()) != null) {
            StringBuilder sb = new StringBuilder();
            ShareFromTopicMsgData shareFromTopicMsgData = new ShareFromTopicMsgData();
            shareFromTopicMsgData.setContent(cRi.shareTitle);
            shareFromTopicMsgData.setImageUrl(cRi.kgl);
            shareFromTopicMsgData.setTitle(cRi.eNh);
            shareFromTopicMsgData.setHotTopicID(cRi.fci);
            shareFromTopicMsgData.setHotTopicName(cRi.eNh);
            sb.append("http://tieba.baidu.com/").append("mo/q/hotMessage?topic_id=").append(cRi.fci).append("&topic_name=").append(cRi.eNh);
            shareFromTopicMsgData.setLinkUrl(sb.toString());
            return shareFromTopicMsgData;
        }
        return null;
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.klp.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.hottopic.controller.HotTopicModel.a
    public void a(boolean z, e eVar) {
        hideLoadingView(this.klp.cRx());
        if (this.klp != null) {
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
            this.mIsGlobalBlock = eVar.cRs();
            if (eVar.cRk() != null && eVar.cRl() != null) {
                this.klp.a(8, true, 0L, 0);
            } else if (eVar.cRk() != null) {
                this.klp.a(0, true, eVar.cRk().totalNum, eVar.cRk().klN);
            } else if (eVar.cRl() != null) {
                this.klp.a(0, false, eVar.cRl().totalNum, eVar.cRl().klN);
            }
            this.klp.eo(this.mHotTopicDataList);
            this.klp.b(eVar);
            this.klp.cRz();
            a(eVar.sortType, eVar.getPageData());
        }
    }

    public void cQP() {
        if (j.isNetWorkAvailable() && this.klq != null) {
            this.klq.a(this.fci, this.eNh, getSortType(), this.fid, this.firstDir, this.secondDir, this.mFrom, this.eAs);
        }
    }

    public void cQQ() {
        if (this.kls != null && !x.isEmpty(this.mHotTopicDataList) && j.isNetWorkAvailable()) {
            com.baidu.tieba.hottopic.data.a cRk = this.mHotTopicDataList.get(0).cRk();
            com.baidu.tieba.hottopic.data.a cRl = this.mHotTopicDataList.get(0).cRl();
            if (cRk != null) {
                this.kls.a(cRk.pkId, Long.parseLong(this.fci), 1, 0, 1, cRk.userPkId);
            } else if (cRl != null) {
                this.kls.a(cRl.pkId, Long.parseLong(this.fci), 1, 0, 1, cRl.userPkId);
            }
        }
    }

    public void cQR() {
        i cRj;
        if (this.kls != null && !x.isEmpty(this.mHotTopicDataList) && j.isNetWorkAvailable() && (cRj = this.mHotTopicDataList.get(0).cRj()) != null) {
            this.kls.a(cRj.pkId, Long.parseLong(this.fci), cRj.klN, 0, 0, cRj.userPkId);
        }
    }

    private void bYg() {
        this.klp.b(new View.OnTouchListener() { // from class: com.baidu.tieba.hottopic.controller.HotTopicActivity.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (!bg.checkUpIsLogin(HotTopicActivity.this.getActivity())) {
                }
                return true;
            }
        });
        this.klp.g(new NoNetworkView.a() { // from class: com.baidu.tieba.hottopic.controller.HotTopicActivity.5
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                HotTopicActivity.this.klp.sn(!z);
                if (z && HotTopicActivity.this.klq != null && x.getItem(HotTopicActivity.this.mHotTopicDataList, HotTopicActivity.this.klp.getCurrentTab()) != null) {
                    e eVar = (e) HotTopicActivity.this.mHotTopicDataList.get(HotTopicActivity.this.klp.getCurrentTab());
                    if (eVar == null || x.isEmpty(eVar.cRp())) {
                        HotTopicActivity.this.klp.Vq();
                        HotTopicActivity.this.klp.showLoadingView();
                        HotTopicActivity.this.cQP();
                    }
                }
            }
        });
        this.ixZ.getSocketMessageListener().setSelfListener(true);
        this.ixZ.getHttpMessageListener().setSelfListener(true);
        registerListener(this.ixZ);
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> cAu() {
        if (this.klt == null) {
            this.klt = FrsCommonImageLayout.Q(getPageContext().getPageActivity(), 12);
        }
        return this.klt;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.a
    public com.baidu.adp.lib.d.b<TbImageView> bus() {
        if (this.fjw == null) {
            this.fjw = UserIconBox.E(getPageContext().getPageActivity(), 8);
        }
        return this.fjw;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.klp == null || x.isEmpty(this.mHotTopicDataList) || !j.isNetWorkAvailable()) {
            cQS();
            return;
        }
        e eVar = (e) x.getItem(this.mHotTopicDataList, this.klp.getCurrentTab());
        if (eVar == null || eVar.getPageData() == null) {
            cQS();
        } else if (eVar.kmo && this.klu) {
            this.klr.b(eVar, getSortType());
            this.klu = false;
        }
    }

    public int getSortType() {
        return this.klp.getCurrentTab() == 0 ? 1 : 0;
    }

    public int BY(int i) {
        return i == 1 ? 0 : 1;
    }

    @Override // com.baidu.tieba.hottopic.controller.HotRelateThreadModel.a
    public void complete() {
        this.klu = true;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (!StringUtils.isNull(this.eNh) || !StringUtils.isNull(this.fci)) {
            bundle.putString("topic_id", this.fci);
            bundle.putString("topic_name", this.eNh);
        }
    }

    @Override // com.baidu.tieba.hottopic.controller.HotRelateThreadModel.b
    public void a(boolean z, com.baidu.tieba.hottopic.data.d dVar, int i) {
        if (!z || dVar == null || x.isEmpty(this.mHotTopicDataList) || x.getCount(dVar.gaa) == 0) {
            this.klp.BW(BY(i));
            return;
        }
        e eVar = (e) x.getItem(this.mHotTopicDataList, BY(i));
        if (eVar == null) {
            this.klp.BW(BY(i));
            return;
        }
        eVar.a(dVar);
        this.klp.eo(this.mHotTopicDataList);
        a(i, dVar.pageData);
    }

    private void a(int i, com.baidu.tbadk.core.data.ax axVar) {
        if (axVar != null) {
            int BY = BY(i);
            e eVar = (e) x.getItem(this.mHotTopicDataList, BY);
            if (eVar != null) {
                eVar.a(axVar);
            }
            if (axVar.bmm() != 0) {
                this.klp.BU(BY);
                return;
            }
            this.klp.BW(BY);
            this.klp.BV(BY);
        }
    }

    private void cQS() {
        int BY = BY(getSortType());
        e eVar = (e) x.getItem(this.mHotTopicDataList, BY);
        if (eVar == null || eVar.getPageData() == null) {
            this.klp.BW(BY);
            return;
        }
        if (eVar.getPageData().bmm() != 0) {
            this.klp.BW(BY);
            return;
        }
        this.klp.BW(BY);
        this.klp.BV(BY);
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable() && this.klp != null) {
            this.klp.Vq();
            this.klp.Ce(0);
            cQP();
        }
    }

    public String cQT() {
        return this.fci;
    }

    public String getTopicName() {
        return this.eNh;
    }

    public void cQK() {
        f cRi;
        if (!x.isEmpty(this.mHotTopicDataList) && (cRi = this.mHotTopicDataList.get(0).cRi()) != null) {
            this.klb.a(cRi.fci, cRi.eNh, (String) null, cRi.kgl, cRi.shareTitle, true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.HOT_TOPIC;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public void s(com.baidu.tieba.card.data.b bVar) {
        if (bVar != null && bVar.bkV() != null) {
            aq aqVar = new aq("c13021");
            aqVar.dW("tid", bVar.bkV().getTid()).w("fid", bVar.bkV().getFid()).dW("obj_source", bVar.bkV().mRecomSource).dW("obj_locate", getFrom()).dW("obj_name", getTopicName()).dW(TiebaInitialize.Params.OBJ_PARAM3, m.cra()).dW("ab_tag", bVar.crw());
            s.crj().e(aqVar);
        }
    }

    public void t(com.baidu.tieba.card.data.b bVar) {
        if (bVar != null && bVar.bkV() != null) {
            com.baidu.tieba.hottopic.a.b.a(bVar.bkV(), getTopicName(), getFrom(), bVar.objType);
        }
    }

    private boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || at.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.brx().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this).createNormalConfig("from_hottopic", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }
}

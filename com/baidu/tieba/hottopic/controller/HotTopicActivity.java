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
import com.baidu.tbadk.core.data.aw;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
import com.baidu.tieba.card.t;
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
/* loaded from: classes8.dex */
public class HotTopicActivity extends BaseActivity<HotTopicActivity> implements BdListView.e, UserIconBox.a, HotRelateThreadModel.a, HotRelateThreadModel.b, HotTopicModel.a, a, FrsCommonImageLayout.c {
    private long eCy;
    private long fid;
    private String firstDir;
    private com.baidu.adp.lib.d.b<TbImageView> flN;
    private LikeModel kbT;
    private com.baidu.adp.lib.d.b<TbImageView> ktA;
    private b kti;
    private BlessModel ktz;
    private List<HotTopicBussinessData> mDataList;
    private List<e> mHotTopicDataList;
    private String secondDir;
    private com.baidu.tieba.hottopic.view.c ktw = null;
    private HotTopicModel ktx = null;
    private HotRelateThreadModel kty = null;
    private String fey = null;
    private String ePt = null;
    private String mFrom = "";
    private long lastResumeTime = 0;
    private int mIsGlobalBlock = 0;
    private boolean ktB = true;
    private AntiHelper.a jhC = new AntiHelper.a() { // from class: com.baidu.tieba.hottopic.controller.HotTopicActivity.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ap("obj_locate", ay.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ap("obj_locate", ay.a.LOCATE_LIKE_PERSON));
        }
    };
    private final com.baidu.adp.framework.listener.a iDJ = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.hottopic.controller.HotTopicActivity.2
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
    private com.baidu.adp.base.e iIX = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.hottopic.controller.HotTopicActivity.3
        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            if (!AntiHelper.bX(HotTopicActivity.this.kbT.getErrorCode(), HotTopicActivity.this.kbT.getErrorString())) {
                if (!StringUtils.isNull(HotTopicActivity.this.kbT.getErrorString())) {
                    l.showToast(TbadkCoreApplication.getInst(), HotTopicActivity.this.kbT.getErrorString());
                }
            } else if (AntiHelper.a(HotTopicActivity.this.getActivity(), HotTopicActivity.this.kbT.getErrorString(), HotTopicActivity.this.kbT.getErrorCode(), HotTopicActivity.this.jhC) != null) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ap("obj_locate", ay.a.LOCATE_LIKE_PERSON));
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
        } else if (this.ktw != null && y.getItem(this.mHotTopicDataList, this.ktw.getCurrentTab()) != null && this.ktw.cTC() != null) {
            e eVar = (e) y.getItem(this.mHotTopicDataList, this.ktw.getCurrentTab());
            aw awVar = new aw();
            ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
            User.Builder builder2 = new User.Builder(builder.author);
            a(builder2, getMyPostResIdl.data.user_info);
            builder.author = builder2.build(true);
            awVar.a(builder.build(true));
            eVar.aI(awVar);
            this.ktw.cTC().c(eVar);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        an(bundle);
        this.ktw = new com.baidu.tieba.hottopic.view.c(getPageContext(), this.fey);
        this.ktx = new HotTopicModel(this);
        this.ktx.a(this);
        this.kbT = new LikeModel(getPageContext());
        this.kbT.setLoadDataCallBack(this.iIX);
        this.kty = new HotRelateThreadModel(this);
        this.kty.a((HotRelateThreadModel.a) this);
        this.kty.a((HotRelateThreadModel.b) this);
        this.kti = new b(this);
        this.ktz = new BlessModel(this);
        bZe();
        cSM();
    }

    private void cSM() {
        showLoadingView(this.ktw.cTw(), false);
        if (!j.isNetworkAvailableForImmediately()) {
            hideLoadingView(this.ktw.cTw());
            showNetRefreshView(this.ktw.cTw(), getResources().getString(R.string.neterror), true);
            setNetRefreshViewTopMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds530));
            this.ktw.Cv(8);
            return;
        }
        this.ktw.Cv(0);
        cSO();
    }

    private void an(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.fey = intent.getStringExtra("topic_id");
            this.ePt = intent.getStringExtra("topic_name");
            this.fid = intent.getLongExtra("topic_fid", 0L);
            this.firstDir = intent.getStringExtra("topic_first_dir");
            this.secondDir = intent.getStringExtra("topic_second_dir");
            this.mFrom = intent.getStringExtra("from");
            this.eCy = intent.getLongExtra(IntentConfig.TOPIC_TID, 0L);
        } else if (bundle != null) {
            this.fey = bundle.getString("topic_id");
            this.ePt = bundle.getString("topic_name");
            this.fid = bundle.getLong("topic_fid", 0L);
            this.firstDir = bundle.getString("topic_first_dir");
            this.secondDir = bundle.getString("topic_second_dir");
            this.mFrom = bundle.getString("from");
            this.mFrom = bundle.getString("from");
            this.eCy = bundle.getLong(IntentConfig.TOPIC_TID, 0L);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onResume() {
        this.lastResumeTime = System.currentTimeMillis();
        super.onResume();
        if (this.ktw != null) {
            this.ktw.resume();
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
                            if (this.ktw != null && y.getItem(this.mDataList, this.ktw.getCurrentTab()) != null) {
                                j3 = com.baidu.adp.lib.f.b.toLong(String.valueOf(((HotTopicBussinessData) y.getItem(this.mDataList, this.ktw.getCurrentTab())).mForumId), 0L);
                            }
                            if (j != 0 && j2 != 0) {
                                int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                                int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                                float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                                int i3 = 1;
                                if (av.bsS().bsT()) {
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
                        this.kti.a(cSN(), intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L), this.mHotTopicDataList.get(0));
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHARE_FRIEND_FORUM /* 23007 */:
                    if (intent != null && !y.isEmpty(this.mHotTopicDataList)) {
                        this.kti.a(cSN(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra("name_show"), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT), this.mHotTopicDataList.get(0));
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
        TiebaStatic.log(new ar("c10817").dR("obj_duration", String.valueOf(System.currentTimeMillis() - this.lastResumeTime)));
        setRequestedOrientation(1);
        if (this.ktw != null) {
            this.ktw.pause();
        }
        super.onPause();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        t.csu().bOF();
        if (this.ktw != null) {
            this.ktw.destroy();
        }
        super.onDestroy();
    }

    public ShareFromTopicMsgData cSN() {
        f cTh;
        if (!y.isEmpty(this.mHotTopicDataList) && (cTh = this.mHotTopicDataList.get(0).cTh()) != null) {
            StringBuilder sb = new StringBuilder();
            ShareFromTopicMsgData shareFromTopicMsgData = new ShareFromTopicMsgData();
            shareFromTopicMsgData.setContent(cTh.shareTitle);
            shareFromTopicMsgData.setImageUrl(cTh.kot);
            shareFromTopicMsgData.setTitle(cTh.ePt);
            shareFromTopicMsgData.setHotTopicID(cTh.fey);
            shareFromTopicMsgData.setHotTopicName(cTh.ePt);
            sb.append("http://tieba.baidu.com/").append("mo/q/hotMessage?topic_id=").append(cTh.fey).append("&topic_name=").append(cTh.ePt);
            shareFromTopicMsgData.setLinkUrl(sb.toString());
            return shareFromTopicMsgData;
        }
        return null;
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ktw.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.hottopic.controller.HotTopicModel.a
    public void a(boolean z, e eVar) {
        hideLoadingView(this.ktw.cTw());
        if (this.ktw != null) {
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
            this.mIsGlobalBlock = eVar.cTr();
            if (eVar.cTj() != null && eVar.cTk() != null) {
                this.ktw.a(8, true, 0L, 0);
            } else if (eVar.cTj() != null) {
                this.ktw.a(0, true, eVar.cTj().totalNum, eVar.cTj().ktU);
            } else if (eVar.cTk() != null) {
                this.ktw.a(0, false, eVar.cTk().totalNum, eVar.cTk().ktU);
            }
            this.ktw.em(this.mHotTopicDataList);
            this.ktw.b(eVar);
            this.ktw.cTy();
            a(eVar.sortType, eVar.getPageData());
        }
    }

    public void cSO() {
        if (j.isNetWorkAvailable() && this.ktx != null) {
            this.ktx.a(this.fey, this.ePt, getSortType(), this.fid, this.firstDir, this.secondDir, this.mFrom, this.eCy);
        }
    }

    public void cSP() {
        if (this.ktz != null && !y.isEmpty(this.mHotTopicDataList) && j.isNetWorkAvailable()) {
            com.baidu.tieba.hottopic.data.a cTj = this.mHotTopicDataList.get(0).cTj();
            com.baidu.tieba.hottopic.data.a cTk = this.mHotTopicDataList.get(0).cTk();
            if (cTj != null) {
                this.ktz.a(cTj.pkId, Long.parseLong(this.fey), 1, 0, 1, cTj.userPkId);
            } else if (cTk != null) {
                this.ktz.a(cTk.pkId, Long.parseLong(this.fey), 1, 0, 1, cTk.userPkId);
            }
        }
    }

    public void cSQ() {
        i cTi;
        if (this.ktz != null && !y.isEmpty(this.mHotTopicDataList) && j.isNetWorkAvailable() && (cTi = this.mHotTopicDataList.get(0).cTi()) != null) {
            this.ktz.a(cTi.pkId, Long.parseLong(this.fey), cTi.ktU, 0, 0, cTi.userPkId);
        }
    }

    private void bZe() {
        this.ktw.b(new View.OnTouchListener() { // from class: com.baidu.tieba.hottopic.controller.HotTopicActivity.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (!bh.checkUpIsLogin(HotTopicActivity.this.getActivity())) {
                }
                return true;
            }
        });
        this.ktw.g(new NoNetworkView.a() { // from class: com.baidu.tieba.hottopic.controller.HotTopicActivity.5
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                HotTopicActivity.this.ktw.sA(!z);
                if (z && HotTopicActivity.this.ktx != null && y.getItem(HotTopicActivity.this.mHotTopicDataList, HotTopicActivity.this.ktw.getCurrentTab()) != null) {
                    e eVar = (e) HotTopicActivity.this.mHotTopicDataList.get(HotTopicActivity.this.ktw.getCurrentTab());
                    if (eVar == null || y.isEmpty(eVar.cTo())) {
                        HotTopicActivity.this.ktw.WZ();
                        HotTopicActivity.this.ktw.showLoadingView();
                        HotTopicActivity.this.cSO();
                    }
                }
            }
        });
        this.iDJ.getSocketMessageListener().setSelfListener(true);
        this.iDJ.getHttpMessageListener().setSelfListener(true);
        registerListener(this.iDJ);
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> cBF() {
        if (this.ktA == null) {
            this.ktA = FrsCommonImageLayout.Q(getPageContext().getPageActivity(), 12);
        }
        return this.ktA;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.a
    public com.baidu.adp.lib.d.b<TbImageView> buM() {
        if (this.flN == null) {
            this.flN = UserIconBox.E(getPageContext().getPageActivity(), 8);
        }
        return this.flN;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.ktw == null || y.isEmpty(this.mHotTopicDataList) || !j.isNetWorkAvailable()) {
            cSR();
            return;
        }
        e eVar = (e) y.getItem(this.mHotTopicDataList, this.ktw.getCurrentTab());
        if (eVar == null || eVar.getPageData() == null) {
            cSR();
        } else if (eVar.kuv && this.ktB) {
            this.kty.b(eVar, getSortType());
            this.ktB = false;
        }
    }

    public int getSortType() {
        return this.ktw.getCurrentTab() == 0 ? 1 : 0;
    }

    public int Cp(int i) {
        return i == 1 ? 0 : 1;
    }

    @Override // com.baidu.tieba.hottopic.controller.HotRelateThreadModel.a
    public void complete() {
        this.ktB = true;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (!StringUtils.isNull(this.ePt) || !StringUtils.isNull(this.fey)) {
            bundle.putString("topic_id", this.fey);
            bundle.putString("topic_name", this.ePt);
        }
    }

    @Override // com.baidu.tieba.hottopic.controller.HotRelateThreadModel.b
    public void a(boolean z, com.baidu.tieba.hottopic.data.d dVar, int i) {
        if (!z || dVar == null || y.isEmpty(this.mHotTopicDataList) || y.getCount(dVar.gcs) == 0) {
            this.ktw.Cn(Cp(i));
            return;
        }
        e eVar = (e) y.getItem(this.mHotTopicDataList, Cp(i));
        if (eVar == null) {
            this.ktw.Cn(Cp(i));
            return;
        }
        eVar.a(dVar);
        this.ktw.em(this.mHotTopicDataList);
        a(i, dVar.pageData);
    }

    private void a(int i, az azVar) {
        if (azVar != null) {
            int Cp = Cp(i);
            e eVar = (e) y.getItem(this.mHotTopicDataList, Cp);
            if (eVar != null) {
                eVar.a(azVar);
            }
            if (azVar.bmF() != 0) {
                this.ktw.Cl(Cp);
                return;
            }
            this.ktw.Cn(Cp);
            this.ktw.Cm(Cp);
        }
    }

    private void cSR() {
        int Cp = Cp(getSortType());
        e eVar = (e) y.getItem(this.mHotTopicDataList, Cp);
        if (eVar == null || eVar.getPageData() == null) {
            this.ktw.Cn(Cp);
            return;
        }
        if (eVar.getPageData().bmF() != 0) {
            this.ktw.Cn(Cp);
            return;
        }
        this.ktw.Cn(Cp);
        this.ktw.Cm(Cp);
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable() && this.ktw != null) {
            this.ktw.WZ();
            this.ktw.Cv(0);
            cSO();
        }
    }

    public String cSS() {
        return this.fey;
    }

    public String getTopicName() {
        return this.ePt;
    }

    public void cSJ() {
        f cTh;
        if (!y.isEmpty(this.mHotTopicDataList) && (cTh = this.mHotTopicDataList.get(0).cTh()) != null) {
            this.kti.a(cTh.fey, cTh.ePt, (String) null, cTh.kot, cTh.shareTitle, true);
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
        if (bVar != null && bVar.bln() != null) {
            ar arVar = new ar("c13021");
            arVar.dR("tid", bVar.bln().getTid()).v("fid", bVar.bln().getFid()).dR("obj_source", bVar.bln().mRecomSource).dR("obj_locate", getFrom()).dR("obj_name", getTopicName()).dR(TiebaInitialize.Params.OBJ_PARAM3, m.csk()).dR("ab_tag", bVar.csI());
            t.csu().e(arVar);
        }
    }

    public void t(com.baidu.tieba.card.data.b bVar) {
        if (bVar != null && bVar.bln() != null) {
            com.baidu.tieba.hottopic.a.b.a(bVar.bln(), getTopicName(), getFrom(), bVar.objType);
        }
    }

    private boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || au.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this).createNormalConfig("from_hottopic", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }
}

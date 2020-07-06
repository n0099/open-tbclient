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
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.w;
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
/* loaded from: classes8.dex */
public class HotTopicActivity extends BaseActivity<HotTopicActivity> implements BdListView.e, UserIconBox.b, HotRelateThreadModel.a, HotRelateThreadModel.b, HotTopicModel.a, a, FrsCommonImageLayout.c {
    private long dyU;
    private com.baidu.adp.lib.d.b<TbImageView> efk;
    private long fid;
    private String firstDir;
    private b iCT;
    private BlessModel iDk;
    private LikeModel iDl;
    private com.baidu.adp.lib.d.b<TbImageView> iDm;
    private List<HotTopicBussinessData> mDataList;
    private List<e> mHotTopicDataList;
    private String secondDir;
    private com.baidu.tieba.hottopic.view.c iDh = null;
    private HotTopicModel iDi = null;
    private HotRelateThreadModel iDj = null;
    private String dYw = null;
    private String dKw = null;
    private String mFrom = "";
    private long lastResumeTime = 0;
    private int mIsGlobalBlock = 0;
    private boolean iDn = true;
    private AntiHelper.a hAZ = new AntiHelper.a() { // from class: com.baidu.tieba.hottopic.controller.HotTopicActivity.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ao(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ag("obj_locate", av.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ao(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ag("obj_locate", av.a.LOCATE_LIKE_PERSON));
        }
    };
    private final com.baidu.adp.framework.listener.a gXA = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.hottopic.controller.HotTopicActivity.2
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
    private com.baidu.adp.base.d hcL = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.hottopic.controller.HotTopicActivity.3
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (!AntiHelper.bA(HotTopicActivity.this.iDl.getErrorCode(), HotTopicActivity.this.iDl.getErrorString())) {
                if (!StringUtils.isNull(HotTopicActivity.this.iDl.getErrorString())) {
                    l.showToast(TbadkCoreApplication.getInst(), HotTopicActivity.this.iDl.getErrorString());
                }
            } else if (AntiHelper.a(HotTopicActivity.this.getActivity(), HotTopicActivity.this.iDl.getErrorString(), HotTopicActivity.this.iDl.getErrorCode(), HotTopicActivity.this.hAZ) != null) {
                TiebaStatic.log(new ao(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ag("obj_locate", av.a.LOCATE_LIKE_PERSON));
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
        } else if (this.iDh != null && w.getItem(this.mHotTopicDataList, this.iDh.getCurrentTab()) != null && this.iDh.cmc() != null) {
            e eVar = (e) w.getItem(this.mHotTopicDataList, this.iDh.getCurrentTab());
            aq aqVar = new aq();
            ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
            User.Builder builder2 = new User.Builder(builder.author);
            a(builder2, getMyPostResIdl.data.user_info);
            builder.author = builder2.build(true);
            aqVar.a(builder.build(true));
            eVar.aF(aqVar);
            this.iDh.cmc().d(eVar);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        as(bundle);
        this.iDh = new com.baidu.tieba.hottopic.view.c(getPageContext(), this.dYw);
        this.iDi = new HotTopicModel(this);
        this.iDi.a(this);
        this.iDl = new LikeModel(getPageContext());
        this.iDl.setLoadDataCallBack(this.hcL);
        this.iDj = new HotRelateThreadModel(this);
        this.iDj.a((HotRelateThreadModel.a) this);
        this.iDj.a((HotRelateThreadModel.b) this);
        this.iCT = new b(this);
        this.iDk = new BlessModel(this);
        bzy();
        clk();
    }

    private void clk() {
        showLoadingView(this.iDh.clV(), false);
        if (!j.isNetworkAvailableForImmediately()) {
            hideLoadingView(this.iDh.clV());
            showNetRefreshView(this.iDh.clV(), getResources().getString(R.string.neterror), true);
            setNetRefreshViewTopMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds530));
            this.iDh.xK(8);
            return;
        }
        this.iDh.xK(0);
        clm();
    }

    private void as(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.dYw = intent.getStringExtra("topic_id");
            this.dKw = intent.getStringExtra("topic_name");
            this.fid = intent.getLongExtra("topic_fid", 0L);
            this.firstDir = intent.getStringExtra("topic_first_dir");
            this.secondDir = intent.getStringExtra("topic_second_dir");
            this.mFrom = intent.getStringExtra("from");
            this.dyU = intent.getLongExtra(IntentConfig.TOPIC_TID, 0L);
        } else if (bundle != null) {
            this.dYw = bundle.getString("topic_id");
            this.dKw = bundle.getString("topic_name");
            this.fid = bundle.getLong("topic_fid", 0L);
            this.firstDir = bundle.getString("topic_first_dir");
            this.secondDir = bundle.getString("topic_second_dir");
            this.mFrom = bundle.getString("from");
            this.mFrom = bundle.getString("from");
            this.dyU = bundle.getLong(IntentConfig.TOPIC_TID, 0L);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onResume() {
        this.lastResumeTime = System.currentTimeMillis();
        super.onResume();
        if (this.iDh != null) {
            this.iDh.resume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(e eVar) {
        if (this.mDataList == null) {
            this.mDataList = new ArrayList();
        } else {
            this.mDataList.clear();
        }
        this.mDataList.add(new HotTopicBussinessData(0L, "", eVar.clF().dKw, this.mIsGlobalBlock));
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
                            if (this.iDh != null && w.getItem(this.mDataList, this.iDh.getCurrentTab()) != null) {
                                j3 = com.baidu.adp.lib.f.b.toLong(String.valueOf(((HotTopicBussinessData) w.getItem(this.mDataList, this.iDh.getCurrentTab())).mForumId), 0L);
                            }
                            if (j != 0 && j2 != 0) {
                                int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                                int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                                float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                                int i3 = 1;
                                if (as.aWR().aWS()) {
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
                    if (intent != null && !w.isEmpty(this.mHotTopicDataList)) {
                        this.iCT.a(cll(), intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L), this.mHotTopicDataList.get(0));
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHARE_FRIEND_FORUM /* 23007 */:
                    if (intent != null && !w.isEmpty(this.mHotTopicDataList)) {
                        this.iCT.a(cll(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra("name_show"), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT), this.mHotTopicDataList.get(0));
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
        TiebaStatic.log(new ao("c10817").dk("obj_duration", String.valueOf(System.currentTimeMillis() - this.lastResumeTime)));
        setRequestedOrientation(1);
        if (this.iDh != null) {
            this.iDh.pause();
        }
        super.onPause();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        s.bOB().brU();
        if (this.iDh != null) {
            this.iDh.destroy();
        }
        super.onDestroy();
    }

    public ShareFromTopicMsgData cll() {
        f clF;
        if (!w.isEmpty(this.mHotTopicDataList) && (clF = this.mHotTopicDataList.get(0).clF()) != null) {
            StringBuilder sb = new StringBuilder();
            ShareFromTopicMsgData shareFromTopicMsgData = new ShareFromTopicMsgData();
            shareFromTopicMsgData.setContent(clF.shareTitle);
            shareFromTopicMsgData.setImageUrl(clF.iyd);
            shareFromTopicMsgData.setTitle(clF.dKw);
            shareFromTopicMsgData.setHotTopicID(clF.dYw);
            shareFromTopicMsgData.setHotTopicName(clF.dKw);
            sb.append("http://tieba.baidu.com/").append("mo/q/hotMessage?topic_id=").append(clF.dYw).append("&topic_name=").append(clF.dKw);
            shareFromTopicMsgData.setLinkUrl(sb.toString());
            return shareFromTopicMsgData;
        }
        return null;
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iDh.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.hottopic.controller.HotTopicModel.a
    public void a(boolean z, e eVar) {
        hideLoadingView(this.iDh.clV());
        if (this.iDh != null) {
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
            this.mIsGlobalBlock = eVar.clP();
            if (eVar.clH() != null && eVar.clI() != null) {
                this.iDh.a(8, true, 0L, 0);
            } else if (eVar.clH() != null) {
                this.iDh.a(0, true, eVar.clH().totalNum, eVar.clH().iDG);
            } else if (eVar.clI() != null) {
                this.iDh.a(0, false, eVar.clI().totalNum, eVar.clI().iDG);
            }
            this.iDh.di(this.mHotTopicDataList);
            this.iDh.c(eVar);
            this.iDh.clX();
            a(eVar.sortType, eVar.getPageData());
        }
    }

    public void clm() {
        if (j.isNetWorkAvailable() && this.iDi != null) {
            this.iDi.a(this.dYw, this.dKw, getSortType(), this.fid, this.firstDir, this.secondDir, this.mFrom, this.dyU);
        }
    }

    public void cln() {
        if (this.iDk != null && !w.isEmpty(this.mHotTopicDataList) && j.isNetWorkAvailable()) {
            com.baidu.tieba.hottopic.data.a clH = this.mHotTopicDataList.get(0).clH();
            com.baidu.tieba.hottopic.data.a clI = this.mHotTopicDataList.get(0).clI();
            if (clH != null) {
                this.iDk.a(clH.pkId, Long.parseLong(this.dYw), 1, 0, 1, clH.userPkId);
            } else if (clI != null) {
                this.iDk.a(clI.pkId, Long.parseLong(this.dYw), 1, 0, 1, clI.userPkId);
            }
        }
    }

    public void clo() {
        i clG;
        if (this.iDk != null && !w.isEmpty(this.mHotTopicDataList) && j.isNetWorkAvailable() && (clG = this.mHotTopicDataList.get(0).clG()) != null) {
            this.iDk.a(clG.pkId, Long.parseLong(this.dYw), clG.iDG, 0, 0, clG.userPkId);
        }
    }

    private void bzy() {
        this.iDh.b(new View.OnTouchListener() { // from class: com.baidu.tieba.hottopic.controller.HotTopicActivity.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                e eVar;
                if (!be.checkUpIsLogin(HotTopicActivity.this.getActivity()) || motionEvent.getAction() != 1 || (eVar = (e) w.getItem(HotTopicActivity.this.mHotTopicDataList, HotTopicActivity.this.iDh.getCurrentTab())) == null) {
                    return true;
                }
                if (!j.isNetWorkAvailable()) {
                    l.showToast(HotTopicActivity.this.getPageContext().getContext(), (int) R.string.no_network_guide);
                }
                HotTopicActivity.this.b(eVar);
                WriteActivityConfig writeActivityConfig = new WriteActivityConfig(HotTopicActivity.this.getPageContext().getPageActivity(), 9, String.valueOf(0), "", null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0);
                writeActivityConfig.getIntent().putExtra("hot_topic_forum_list", (Serializable) HotTopicActivity.this.mDataList);
                writeActivityConfig.getIntent().putExtra(WriteActivityConfig.HOT_TOPIC_ID, HotTopicActivity.this.dYw);
                writeActivityConfig.setCallFrom("1");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                ao aoVar = new ao(CommonStatisticKey.KEY_ENTRANCE_CLICKED);
                aoVar.ag("obj_locate", 6).ag("obj_type", 1);
                TiebaStatic.log(aoVar);
                return true;
            }
        });
        this.iDh.g(new NoNetworkView.a() { // from class: com.baidu.tieba.hottopic.controller.HotTopicActivity.5
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                HotTopicActivity.this.iDh.oN(!z);
                if (z && HotTopicActivity.this.iDi != null && w.getItem(HotTopicActivity.this.mHotTopicDataList, HotTopicActivity.this.iDh.getCurrentTab()) != null) {
                    e eVar = (e) HotTopicActivity.this.mHotTopicDataList.get(HotTopicActivity.this.iDh.getCurrentTab());
                    if (eVar == null || w.isEmpty(eVar.clM())) {
                        HotTopicActivity.this.iDh.btO();
                        HotTopicActivity.this.iDh.showLoadingView();
                        HotTopicActivity.this.clm();
                    }
                }
            }
        });
        this.gXA.getSocketMessageListener().setSelfListener(true);
        this.gXA.getHttpMessageListener().setSelfListener(true);
        registerListener(this.gXA);
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> bXo() {
        if (this.iDm == null) {
            this.iDm = FrsCommonImageLayout.B(getPageContext().getPageActivity(), 12);
        }
        return this.iDm;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> aYI() {
        if (this.efk == null) {
            this.efk = UserIconBox.t(getPageContext().getPageActivity(), 8);
        }
        return this.efk;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public ListView aYH() {
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.iDh == null || w.isEmpty(this.mHotTopicDataList) || !j.isNetWorkAvailable()) {
            clp();
            return;
        }
        e eVar = (e) w.getItem(this.mHotTopicDataList, this.iDh.getCurrentTab());
        if (eVar == null || eVar.getPageData() == null) {
            clp();
        } else if (eVar.iEh && this.iDn) {
            this.iDj.b(eVar, getSortType());
            this.iDn = false;
        }
    }

    public int getSortType() {
        return this.iDh.getCurrentTab() == 0 ? 1 : 0;
    }

    public int xE(int i) {
        return i == 1 ? 0 : 1;
    }

    @Override // com.baidu.tieba.hottopic.controller.HotRelateThreadModel.a
    public void complete() {
        this.iDn = true;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (!StringUtils.isNull(this.dKw) || !StringUtils.isNull(this.dYw)) {
            bundle.putString("topic_id", this.dYw);
            bundle.putString("topic_name", this.dKw);
        }
    }

    @Override // com.baidu.tieba.hottopic.controller.HotRelateThreadModel.b
    public void a(boolean z, com.baidu.tieba.hottopic.data.d dVar, int i) {
        if (!z || dVar == null || w.isEmpty(this.mHotTopicDataList) || w.getCount(dVar.eSH) == 0) {
            this.iDh.xC(xE(i));
            return;
        }
        e eVar = (e) w.getItem(this.mHotTopicDataList, xE(i));
        if (eVar == null) {
            this.iDh.xC(xE(i));
            return;
        }
        eVar.a(dVar);
        this.iDh.di(this.mHotTopicDataList);
        a(i, dVar.pageData);
    }

    private void a(int i, at atVar) {
        if (atVar != null) {
            int xE = xE(i);
            e eVar = (e) w.getItem(this.mHotTopicDataList, xE);
            if (eVar != null) {
                eVar.a(atVar);
            }
            if (atVar.aRf() != 0) {
                this.iDh.xA(xE);
                return;
            }
            this.iDh.xC(xE);
            this.iDh.xB(xE);
        }
    }

    private void clp() {
        int xE = xE(getSortType());
        e eVar = (e) w.getItem(this.mHotTopicDataList, xE);
        if (eVar == null || eVar.getPageData() == null) {
            this.iDh.xC(xE);
            return;
        }
        if (eVar.getPageData().aRf() != 0) {
            this.iDh.xC(xE);
            return;
        }
        this.iDh.xC(xE);
        this.iDh.xB(xE);
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable() && this.iDh != null) {
            this.iDh.btO();
            this.iDh.xK(0);
            clm();
        }
    }

    public String clq() {
        return this.dYw;
    }

    public String getTopicName() {
        return this.dKw;
    }

    public void clh() {
        f clF;
        if (!w.isEmpty(this.mHotTopicDataList) && (clF = this.mHotTopicDataList.get(0).clF()) != null) {
            this.iCT.b(clF.dYw, clF.dKw, null, clF.iyd, clF.shareTitle, true);
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
        if (cVar != null && cVar.aPS() != null) {
            ao aoVar = new ao("c13021");
            aoVar.dk("tid", cVar.aPS().getTid()).s("fid", cVar.aPS().getFid()).dk("obj_source", cVar.aPS().mRecomSource).dk("obj_locate", getFrom()).dk("obj_name", getTopicName()).dk(TiebaInitialize.Params.OBJ_PARAM3, m.bOs()).dk("ab_tag", cVar.bON());
            s.bOB().e(aoVar);
        }
    }

    public void t(com.baidu.tieba.card.data.c cVar) {
        if (cVar != null && cVar.aPS() != null) {
            com.baidu.tieba.hottopic.b.b.a(cVar.aPS(), getTopicName(), getFrom(), cVar.objType);
        }
    }

    private boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || ar.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this).createNormalConfig("from_hottopic", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }
}

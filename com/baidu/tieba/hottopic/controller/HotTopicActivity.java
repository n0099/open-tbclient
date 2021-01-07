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
/* loaded from: classes8.dex */
public class HotTopicActivity extends BaseActivity<HotTopicActivity> implements BdListView.e, UserIconBox.a, HotRelateThreadModel.a, HotRelateThreadModel.b, HotTopicModel.a, a, FrsCommonImageLayout.c {
    private long eFe;
    private long fid;
    private String firstDir;
    private com.baidu.adp.lib.d.b<TbImageView> fof;
    private LikeModel jYX;
    private b kpG;
    private BlessModel kpX;
    private com.baidu.adp.lib.d.b<TbImageView> kpY;
    private List<HotTopicBussinessData> mDataList;
    private List<e> mHotTopicDataList;
    private String secondDir;
    private com.baidu.tieba.hottopic.view.c kpU = null;
    private HotTopicModel kpV = null;
    private HotRelateThreadModel kpW = null;
    private String fgR = null;
    private String eRS = null;
    private String mFrom = "";
    private long lastResumeTime = 0;
    private int mIsGlobalBlock = 0;
    private boolean kpZ = true;
    private AntiHelper.a jgD = new AntiHelper.a() { // from class: com.baidu.tieba.hottopic.controller.HotTopicActivity.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).an("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).an("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }
    };
    private final com.baidu.adp.framework.listener.a iCG = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.hottopic.controller.HotTopicActivity.2
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
    private com.baidu.adp.base.e iHU = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.hottopic.controller.HotTopicActivity.3
        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            if (!AntiHelper.bP(HotTopicActivity.this.jYX.getErrorCode(), HotTopicActivity.this.jYX.getErrorString())) {
                if (!StringUtils.isNull(HotTopicActivity.this.jYX.getErrorString())) {
                    l.showToast(TbadkCoreApplication.getInst(), HotTopicActivity.this.jYX.getErrorString());
                }
            } else if (AntiHelper.a(HotTopicActivity.this.getActivity(), HotTopicActivity.this.jYX.getErrorString(), HotTopicActivity.this.jYX.getErrorCode(), HotTopicActivity.this.jgD) != null) {
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
        } else if (this.kpU != null && x.getItem(this.mHotTopicDataList, this.kpU.getCurrentTab()) != null && this.kpU.cVv() != null) {
            e eVar = (e) x.getItem(this.mHotTopicDataList, this.kpU.getCurrentTab());
            au auVar = new au();
            ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
            User.Builder builder2 = new User.Builder(builder.author);
            a(builder2, getMyPostResIdl.data.user_info);
            builder.author = builder2.build(true);
            auVar.a(builder.build(true));
            eVar.aH(auVar);
            this.kpU.cVv().c(eVar);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        an(bundle);
        this.kpU = new com.baidu.tieba.hottopic.view.c(getPageContext(), this.fgR);
        this.kpV = new HotTopicModel(this);
        this.kpV.a(this);
        this.jYX = new LikeModel(getPageContext());
        this.jYX.setLoadDataCallBack(this.iHU);
        this.kpW = new HotRelateThreadModel(this);
        this.kpW.a((HotRelateThreadModel.a) this);
        this.kpW.a((HotRelateThreadModel.b) this);
        this.kpG = new b(this);
        this.kpX = new BlessModel(this);
        cbY();
        cUF();
    }

    private void cUF() {
        showLoadingView(this.kpU.cVp(), false);
        if (!j.isNetworkAvailableForImmediately()) {
            hideLoadingView(this.kpU.cVp());
            showNetRefreshView(this.kpU.cVp(), getResources().getString(R.string.neterror), true);
            setNetRefreshViewTopMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds530));
            this.kpU.DK(8);
            return;
        }
        this.kpU.DK(0);
        cUH();
    }

    private void an(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.fgR = intent.getStringExtra("topic_id");
            this.eRS = intent.getStringExtra("topic_name");
            this.fid = intent.getLongExtra("topic_fid", 0L);
            this.firstDir = intent.getStringExtra("topic_first_dir");
            this.secondDir = intent.getStringExtra("topic_second_dir");
            this.mFrom = intent.getStringExtra("from");
            this.eFe = intent.getLongExtra(IntentConfig.TOPIC_TID, 0L);
        } else if (bundle != null) {
            this.fgR = bundle.getString("topic_id");
            this.eRS = bundle.getString("topic_name");
            this.fid = bundle.getLong("topic_fid", 0L);
            this.firstDir = bundle.getString("topic_first_dir");
            this.secondDir = bundle.getString("topic_second_dir");
            this.mFrom = bundle.getString("from");
            this.mFrom = bundle.getString("from");
            this.eFe = bundle.getLong(IntentConfig.TOPIC_TID, 0L);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onResume() {
        this.lastResumeTime = System.currentTimeMillis();
        super.onResume();
        if (this.kpU != null) {
            this.kpU.resume();
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
                            if (this.kpU != null && x.getItem(this.mDataList, this.kpU.getCurrentTab()) != null) {
                                j3 = com.baidu.adp.lib.f.b.toLong(String.valueOf(((HotTopicBussinessData) x.getItem(this.mDataList, this.kpU.getCurrentTab())).mForumId), 0L);
                            }
                            if (j != 0 && j2 != 0) {
                                int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                                int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                                float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                                int i3 = 1;
                                if (com.baidu.tbadk.core.util.au.bws().bwt()) {
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
                        this.kpG.a(cUG(), intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L), this.mHotTopicDataList.get(0));
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHARE_FRIEND_FORUM /* 23007 */:
                    if (intent != null && !x.isEmpty(this.mHotTopicDataList)) {
                        this.kpG.a(cUG(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra("name_show"), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT), this.mHotTopicDataList.get(0));
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
        TiebaStatic.log(new aq("c10817").dX("obj_duration", String.valueOf(System.currentTimeMillis() - this.lastResumeTime)));
        setRequestedOrientation(1);
        if (this.kpU != null) {
            this.kpU.pause();
        }
        super.onPause();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        s.cvb().bRT();
        if (this.kpU != null) {
            this.kpU.destroy();
        }
        super.onDestroy();
    }

    public ShareFromTopicMsgData cUG() {
        f cVa;
        if (!x.isEmpty(this.mHotTopicDataList) && (cVa = this.mHotTopicDataList.get(0).cVa()) != null) {
            StringBuilder sb = new StringBuilder();
            ShareFromTopicMsgData shareFromTopicMsgData = new ShareFromTopicMsgData();
            shareFromTopicMsgData.setContent(cVa.shareTitle);
            shareFromTopicMsgData.setImageUrl(cVa.kkR);
            shareFromTopicMsgData.setTitle(cVa.eRS);
            shareFromTopicMsgData.setHotTopicID(cVa.fgR);
            shareFromTopicMsgData.setHotTopicName(cVa.eRS);
            sb.append("http://tieba.baidu.com/").append("mo/q/hotMessage?topic_id=").append(cVa.fgR).append("&topic_name=").append(cVa.eRS);
            shareFromTopicMsgData.setLinkUrl(sb.toString());
            return shareFromTopicMsgData;
        }
        return null;
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.kpU.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.hottopic.controller.HotTopicModel.a
    public void a(boolean z, e eVar) {
        hideLoadingView(this.kpU.cVp());
        if (this.kpU != null) {
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
            this.mIsGlobalBlock = eVar.cVk();
            if (eVar.cVc() != null && eVar.cVd() != null) {
                this.kpU.a(8, true, 0L, 0);
            } else if (eVar.cVc() != null) {
                this.kpU.a(0, true, eVar.cVc().totalNum, eVar.cVc().kqs);
            } else if (eVar.cVd() != null) {
                this.kpU.a(0, false, eVar.cVd().totalNum, eVar.cVd().kqs);
            }
            this.kpU.eo(this.mHotTopicDataList);
            this.kpU.b(eVar);
            this.kpU.cVr();
            a(eVar.sortType, eVar.getPageData());
        }
    }

    public void cUH() {
        if (j.isNetWorkAvailable() && this.kpV != null) {
            this.kpV.a(this.fgR, this.eRS, getSortType(), this.fid, this.firstDir, this.secondDir, this.mFrom, this.eFe);
        }
    }

    public void cUI() {
        if (this.kpX != null && !x.isEmpty(this.mHotTopicDataList) && j.isNetWorkAvailable()) {
            com.baidu.tieba.hottopic.data.a cVc = this.mHotTopicDataList.get(0).cVc();
            com.baidu.tieba.hottopic.data.a cVd = this.mHotTopicDataList.get(0).cVd();
            if (cVc != null) {
                this.kpX.a(cVc.pkId, Long.parseLong(this.fgR), 1, 0, 1, cVc.userPkId);
            } else if (cVd != null) {
                this.kpX.a(cVd.pkId, Long.parseLong(this.fgR), 1, 0, 1, cVd.userPkId);
            }
        }
    }

    public void cUJ() {
        i cVb;
        if (this.kpX != null && !x.isEmpty(this.mHotTopicDataList) && j.isNetWorkAvailable() && (cVb = this.mHotTopicDataList.get(0).cVb()) != null) {
            this.kpX.a(cVb.pkId, Long.parseLong(this.fgR), cVb.kqs, 0, 0, cVb.userPkId);
        }
    }

    private void cbY() {
        this.kpU.b(new View.OnTouchListener() { // from class: com.baidu.tieba.hottopic.controller.HotTopicActivity.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (!bg.checkUpIsLogin(HotTopicActivity.this.getActivity())) {
                }
                return true;
            }
        });
        this.kpU.g(new NoNetworkView.a() { // from class: com.baidu.tieba.hottopic.controller.HotTopicActivity.5
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                HotTopicActivity.this.kpU.sr(!z);
                if (z && HotTopicActivity.this.kpV != null && x.getItem(HotTopicActivity.this.mHotTopicDataList, HotTopicActivity.this.kpU.getCurrentTab()) != null) {
                    e eVar = (e) HotTopicActivity.this.mHotTopicDataList.get(HotTopicActivity.this.kpU.getCurrentTab());
                    if (eVar == null || x.isEmpty(eVar.cVh())) {
                        HotTopicActivity.this.kpU.Zj();
                        HotTopicActivity.this.kpU.showLoadingView();
                        HotTopicActivity.this.cUH();
                    }
                }
            }
        });
        this.iCG.getSocketMessageListener().setSelfListener(true);
        this.iCG.getHttpMessageListener().setSelfListener(true);
        registerListener(this.iCG);
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> cEm() {
        if (this.kpY == null) {
            this.kpY = FrsCommonImageLayout.Q(getPageContext().getPageActivity(), 12);
        }
        return this.kpY;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.a
    public com.baidu.adp.lib.d.b<TbImageView> bym() {
        if (this.fof == null) {
            this.fof = UserIconBox.E(getPageContext().getPageActivity(), 8);
        }
        return this.fof;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.kpU == null || x.isEmpty(this.mHotTopicDataList) || !j.isNetWorkAvailable()) {
            cUK();
            return;
        }
        e eVar = (e) x.getItem(this.mHotTopicDataList, this.kpU.getCurrentTab());
        if (eVar == null || eVar.getPageData() == null) {
            cUK();
        } else if (eVar.kqT && this.kpZ) {
            this.kpW.b(eVar, getSortType());
            this.kpZ = false;
        }
    }

    public int getSortType() {
        return this.kpU.getCurrentTab() == 0 ? 1 : 0;
    }

    public int DE(int i) {
        return i == 1 ? 0 : 1;
    }

    @Override // com.baidu.tieba.hottopic.controller.HotRelateThreadModel.a
    public void complete() {
        this.kpZ = true;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (!StringUtils.isNull(this.eRS) || !StringUtils.isNull(this.fgR)) {
            bundle.putString("topic_id", this.fgR);
            bundle.putString("topic_name", this.eRS);
        }
    }

    @Override // com.baidu.tieba.hottopic.controller.HotRelateThreadModel.b
    public void a(boolean z, com.baidu.tieba.hottopic.data.d dVar, int i) {
        if (!z || dVar == null || x.isEmpty(this.mHotTopicDataList) || x.getCount(dVar.geK) == 0) {
            this.kpU.DC(DE(i));
            return;
        }
        e eVar = (e) x.getItem(this.mHotTopicDataList, DE(i));
        if (eVar == null) {
            this.kpU.DC(DE(i));
            return;
        }
        eVar.a(dVar);
        this.kpU.eo(this.mHotTopicDataList);
        a(i, dVar.pageData);
    }

    private void a(int i, com.baidu.tbadk.core.data.ax axVar) {
        if (axVar != null) {
            int DE = DE(i);
            e eVar = (e) x.getItem(this.mHotTopicDataList, DE);
            if (eVar != null) {
                eVar.a(axVar);
            }
            if (axVar.bqg() != 0) {
                this.kpU.DA(DE);
                return;
            }
            this.kpU.DC(DE);
            this.kpU.DB(DE);
        }
    }

    private void cUK() {
        int DE = DE(getSortType());
        e eVar = (e) x.getItem(this.mHotTopicDataList, DE);
        if (eVar == null || eVar.getPageData() == null) {
            this.kpU.DC(DE);
            return;
        }
        if (eVar.getPageData().bqg() != 0) {
            this.kpU.DC(DE);
            return;
        }
        this.kpU.DC(DE);
        this.kpU.DB(DE);
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable() && this.kpU != null) {
            this.kpU.Zj();
            this.kpU.DK(0);
            cUH();
        }
    }

    public String cUL() {
        return this.fgR;
    }

    public String getTopicName() {
        return this.eRS;
    }

    public void cUC() {
        f cVa;
        if (!x.isEmpty(this.mHotTopicDataList) && (cVa = this.mHotTopicDataList.get(0).cVa()) != null) {
            this.kpG.a(cVa.fgR, cVa.eRS, (String) null, cVa.kkR, cVa.shareTitle, true);
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
        if (bVar != null && bVar.boP() != null) {
            aq aqVar = new aq("c13021");
            aqVar.dX("tid", bVar.boP().getTid()).w("fid", bVar.boP().getFid()).dX("obj_source", bVar.boP().mRecomSource).dX("obj_locate", getFrom()).dX("obj_name", getTopicName()).dX(TiebaInitialize.Params.OBJ_PARAM3, m.cuS()).dX("ab_tag", bVar.cvo());
            s.cvb().e(aqVar);
        }
    }

    public void t(com.baidu.tieba.card.data.b bVar) {
        if (bVar != null && bVar.boP() != null) {
            com.baidu.tieba.hottopic.a.b.a(bVar.boP(), getTopicName(), getFrom(), bVar.objType);
        }
    }

    private boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || at.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.bvr().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this).createNormalConfig("from_hottopic", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }
}

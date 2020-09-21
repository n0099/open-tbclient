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
/* loaded from: classes20.dex */
public class HotTopicActivity extends BaseActivity<HotTopicActivity> implements BdListView.e, UserIconBox.b, HotRelateThreadModel.a, HotRelateThreadModel.b, HotTopicModel.a, a, FrsCommonImageLayout.c {
    private long dQf;
    private com.baidu.adp.lib.d.b<TbImageView> exy;
    private long fid;
    private String firstDir;
    private LikeModel iPZ;
    private b jgJ;
    private BlessModel jha;
    private com.baidu.adp.lib.d.b<TbImageView> jhb;
    private List<HotTopicBussinessData> mDataList;
    private List<e> mHotTopicDataList;
    private String secondDir;
    private com.baidu.tieba.hottopic.view.c jgX = null;
    private HotTopicModel jgY = null;
    private HotRelateThreadModel jgZ = null;
    private String eqD = null;
    private String ecp = null;
    private String mFrom = "";
    private long lastResumeTime = 0;
    private int mIsGlobalBlock = 0;
    private boolean jhc = true;
    private AntiHelper.a ibq = new AntiHelper.a() { // from class: com.baidu.tieba.hottopic.controller.HotTopicActivity.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ai("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ai("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }
    };
    private final com.baidu.adp.framework.listener.a hxi = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.hottopic.controller.HotTopicActivity.2
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
    private com.baidu.adp.base.d hCF = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.hottopic.controller.HotTopicActivity.3
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (!AntiHelper.bC(HotTopicActivity.this.iPZ.getErrorCode(), HotTopicActivity.this.iPZ.getErrorString())) {
                if (!StringUtils.isNull(HotTopicActivity.this.iPZ.getErrorString())) {
                    l.showToast(TbadkCoreApplication.getInst(), HotTopicActivity.this.iPZ.getErrorString());
                }
            } else if (AntiHelper.a(HotTopicActivity.this.getActivity(), HotTopicActivity.this.iPZ.getErrorString(), HotTopicActivity.this.iPZ.getErrorCode(), HotTopicActivity.this.ibq) != null) {
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
        } else if (this.jgX != null && y.getItem(this.mHotTopicDataList, this.jgX.getCurrentTab()) != null && this.jgX.cEc() != null) {
            e eVar = (e) y.getItem(this.mHotTopicDataList, this.jgX.getCurrentTab());
            as asVar = new as();
            ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
            User.Builder builder2 = new User.Builder(builder.author);
            a(builder2, getMyPostResIdl.data.user_info);
            builder.author = builder2.build(true);
            asVar.a(builder.build(true));
            eVar.aE(asVar);
            this.jgX.cEc().d(eVar);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        as(bundle);
        this.jgX = new com.baidu.tieba.hottopic.view.c(getPageContext(), this.eqD);
        this.jgY = new HotTopicModel(this);
        this.jgY.a(this);
        this.iPZ = new LikeModel(getPageContext());
        this.iPZ.setLoadDataCallBack(this.hCF);
        this.jgZ = new HotRelateThreadModel(this);
        this.jgZ.a((HotRelateThreadModel.a) this);
        this.jgZ.a((HotRelateThreadModel.b) this);
        this.jgJ = new b(this);
        this.jha = new BlessModel(this);
        bNr();
        cDl();
    }

    private void cDl() {
        showLoadingView(this.jgX.cDW(), false);
        if (!j.isNetworkAvailableForImmediately()) {
            hideLoadingView(this.jgX.cDW());
            showNetRefreshView(this.jgX.cDW(), getResources().getString(R.string.neterror), true);
            setNetRefreshViewTopMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds530));
            this.jgX.AX(8);
            return;
        }
        this.jgX.AX(0);
        cDn();
    }

    private void as(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.eqD = intent.getStringExtra("topic_id");
            this.ecp = intent.getStringExtra("topic_name");
            this.fid = intent.getLongExtra("topic_fid", 0L);
            this.firstDir = intent.getStringExtra("topic_first_dir");
            this.secondDir = intent.getStringExtra("topic_second_dir");
            this.mFrom = intent.getStringExtra("from");
            this.dQf = intent.getLongExtra(IntentConfig.TOPIC_TID, 0L);
        } else if (bundle != null) {
            this.eqD = bundle.getString("topic_id");
            this.ecp = bundle.getString("topic_name");
            this.fid = bundle.getLong("topic_fid", 0L);
            this.firstDir = bundle.getString("topic_first_dir");
            this.secondDir = bundle.getString("topic_second_dir");
            this.mFrom = bundle.getString("from");
            this.mFrom = bundle.getString("from");
            this.dQf = bundle.getLong(IntentConfig.TOPIC_TID, 0L);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onResume() {
        this.lastResumeTime = System.currentTimeMillis();
        super.onResume();
        if (this.jgX != null) {
            this.jgX.resume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(e eVar) {
        if (this.mDataList == null) {
            this.mDataList = new ArrayList();
        } else {
            this.mDataList.clear();
        }
        this.mDataList.add(new HotTopicBussinessData(0L, "", eVar.cDG().ecp, this.mIsGlobalBlock));
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
                            if (this.jgX != null && y.getItem(this.mDataList, this.jgX.getCurrentTab()) != null) {
                                j3 = com.baidu.adp.lib.f.b.toLong(String.valueOf(((HotTopicBussinessData) y.getItem(this.mDataList, this.jgX.getCurrentTab())).mForumId), 0L);
                            }
                            if (j != 0 && j2 != 0) {
                                int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                                int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                                float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                                int i3 = 1;
                                if (au.bkm().bkn()) {
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
                        this.jgJ.a(cDm(), intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L), this.mHotTopicDataList.get(0));
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHARE_FRIEND_FORUM /* 23007 */:
                    if (intent != null && !y.isEmpty(this.mHotTopicDataList)) {
                        this.jgJ.a(cDm(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra("name_show"), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT), this.mHotTopicDataList.get(0));
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
        TiebaStatic.log(new aq("c10817").dF("obj_duration", String.valueOf(System.currentTimeMillis() - this.lastResumeTime)));
        setRequestedOrientation(1);
        if (this.jgX != null) {
            this.jgX.pause();
        }
        super.onPause();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        s.cfn().bFm();
        if (this.jgX != null) {
            this.jgX.destroy();
        }
        super.onDestroy();
    }

    public ShareFromTopicMsgData cDm() {
        f cDG;
        if (!y.isEmpty(this.mHotTopicDataList) && (cDG = this.mHotTopicDataList.get(0).cDG()) != null) {
            StringBuilder sb = new StringBuilder();
            ShareFromTopicMsgData shareFromTopicMsgData = new ShareFromTopicMsgData();
            shareFromTopicMsgData.setContent(cDG.shareTitle);
            shareFromTopicMsgData.setImageUrl(cDG.jbT);
            shareFromTopicMsgData.setTitle(cDG.ecp);
            shareFromTopicMsgData.setHotTopicID(cDG.eqD);
            shareFromTopicMsgData.setHotTopicName(cDG.ecp);
            sb.append("http://tieba.baidu.com/").append("mo/q/hotMessage?topic_id=").append(cDG.eqD).append("&topic_name=").append(cDG.ecp);
            shareFromTopicMsgData.setLinkUrl(sb.toString());
            return shareFromTopicMsgData;
        }
        return null;
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jgX.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.hottopic.controller.HotTopicModel.a
    public void a(boolean z, e eVar) {
        hideLoadingView(this.jgX.cDW());
        if (this.jgX != null) {
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
            this.mIsGlobalBlock = eVar.cDQ();
            if (eVar.cDI() != null && eVar.cDJ() != null) {
                this.jgX.a(8, true, 0L, 0);
            } else if (eVar.cDI() != null) {
                this.jgX.a(0, true, eVar.cDI().totalNum, eVar.cDI().jhv);
            } else if (eVar.cDJ() != null) {
                this.jgX.a(0, false, eVar.cDJ().totalNum, eVar.cDJ().jhv);
            }
            this.jgX.dC(this.mHotTopicDataList);
            this.jgX.c(eVar);
            this.jgX.cDY();
            a(eVar.sortType, eVar.getPageData());
        }
    }

    public void cDn() {
        if (j.isNetWorkAvailable() && this.jgY != null) {
            this.jgY.a(this.eqD, this.ecp, getSortType(), this.fid, this.firstDir, this.secondDir, this.mFrom, this.dQf);
        }
    }

    public void cDo() {
        if (this.jha != null && !y.isEmpty(this.mHotTopicDataList) && j.isNetWorkAvailable()) {
            com.baidu.tieba.hottopic.data.a cDI = this.mHotTopicDataList.get(0).cDI();
            com.baidu.tieba.hottopic.data.a cDJ = this.mHotTopicDataList.get(0).cDJ();
            if (cDI != null) {
                this.jha.a(cDI.pkId, Long.parseLong(this.eqD), 1, 0, 1, cDI.userPkId);
            } else if (cDJ != null) {
                this.jha.a(cDJ.pkId, Long.parseLong(this.eqD), 1, 0, 1, cDJ.userPkId);
            }
        }
    }

    public void cDp() {
        i cDH;
        if (this.jha != null && !y.isEmpty(this.mHotTopicDataList) && j.isNetWorkAvailable() && (cDH = this.mHotTopicDataList.get(0).cDH()) != null) {
            this.jha.a(cDH.pkId, Long.parseLong(this.eqD), cDH.jhv, 0, 0, cDH.userPkId);
        }
    }

    private void bNr() {
        this.jgX.b(new View.OnTouchListener() { // from class: com.baidu.tieba.hottopic.controller.HotTopicActivity.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                e eVar;
                if (!bg.checkUpIsLogin(HotTopicActivity.this.getActivity()) || motionEvent.getAction() != 1 || (eVar = (e) y.getItem(HotTopicActivity.this.mHotTopicDataList, HotTopicActivity.this.jgX.getCurrentTab())) == null) {
                    return true;
                }
                if (!j.isNetWorkAvailable()) {
                    l.showToast(HotTopicActivity.this.getPageContext().getContext(), R.string.no_network_guide);
                }
                HotTopicActivity.this.b(eVar);
                WriteActivityConfig writeActivityConfig = new WriteActivityConfig(HotTopicActivity.this.getPageContext().getPageActivity(), 9, String.valueOf(0), "", null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0);
                writeActivityConfig.getIntent().putExtra("hot_topic_forum_list", (Serializable) HotTopicActivity.this.mDataList);
                writeActivityConfig.getIntent().putExtra(WriteActivityConfig.HOT_TOPIC_ID, HotTopicActivity.this.eqD);
                writeActivityConfig.setCallFrom("1");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                aq aqVar = new aq(CommonStatisticKey.KEY_ENTRANCE_CLICKED);
                aqVar.ai("obj_locate", 6).ai("obj_type", 1);
                TiebaStatic.log(aqVar);
                return true;
            }
        });
        this.jgX.g(new NoNetworkView.a() { // from class: com.baidu.tieba.hottopic.controller.HotTopicActivity.5
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                HotTopicActivity.this.jgX.qi(!z);
                if (z && HotTopicActivity.this.jgY != null && y.getItem(HotTopicActivity.this.mHotTopicDataList, HotTopicActivity.this.jgX.getCurrentTab()) != null) {
                    e eVar = (e) HotTopicActivity.this.mHotTopicDataList.get(HotTopicActivity.this.jgX.getCurrentTab());
                    if (eVar == null || y.isEmpty(eVar.cDN())) {
                        HotTopicActivity.this.jgX.bHn();
                        HotTopicActivity.this.jgX.showLoadingView();
                        HotTopicActivity.this.cDn();
                    }
                }
            }
        });
        this.hxi.getSocketMessageListener().setSelfListener(true);
        this.hxi.getHttpMessageListener().setSelfListener(true);
        registerListener(this.hxi);
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> cot() {
        if (this.jhb == null) {
            this.jhb = FrsCommonImageLayout.G(getPageContext().getPageActivity(), 12);
        }
        return this.jhb;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> blY() {
        if (this.exy == null) {
            this.exy = UserIconBox.u(getPageContext().getPageActivity(), 8);
        }
        return this.exy;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public ListView blX() {
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.jgX == null || y.isEmpty(this.mHotTopicDataList) || !j.isNetWorkAvailable()) {
            cDq();
            return;
        }
        e eVar = (e) y.getItem(this.mHotTopicDataList, this.jgX.getCurrentTab());
        if (eVar == null || eVar.getPageData() == null) {
            cDq();
        } else if (eVar.jhW && this.jhc) {
            this.jgZ.b(eVar, getSortType());
            this.jhc = false;
        }
    }

    public int getSortType() {
        return this.jgX.getCurrentTab() == 0 ? 1 : 0;
    }

    public int AR(int i) {
        return i == 1 ? 0 : 1;
    }

    @Override // com.baidu.tieba.hottopic.controller.HotRelateThreadModel.a
    public void complete() {
        this.jhc = true;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (!StringUtils.isNull(this.ecp) || !StringUtils.isNull(this.eqD)) {
            bundle.putString("topic_id", this.eqD);
            bundle.putString("topic_name", this.ecp);
        }
    }

    @Override // com.baidu.tieba.hottopic.controller.HotRelateThreadModel.b
    public void a(boolean z, com.baidu.tieba.hottopic.data.d dVar, int i) {
        if (!z || dVar == null || y.isEmpty(this.mHotTopicDataList) || y.getCount(dVar.fnr) == 0) {
            this.jgX.AP(AR(i));
            return;
        }
        e eVar = (e) y.getItem(this.mHotTopicDataList, AR(i));
        if (eVar == null) {
            this.jgX.AP(AR(i));
            return;
        }
        eVar.a(dVar);
        this.jgX.dC(this.mHotTopicDataList);
        a(i, dVar.pageData);
    }

    private void a(int i, av avVar) {
        if (avVar != null) {
            int AR = AR(i);
            e eVar = (e) y.getItem(this.mHotTopicDataList, AR);
            if (eVar != null) {
                eVar.a(avVar);
            }
            if (avVar.beo() != 0) {
                this.jgX.AN(AR);
                return;
            }
            this.jgX.AP(AR);
            this.jgX.AO(AR);
        }
    }

    private void cDq() {
        int AR = AR(getSortType());
        e eVar = (e) y.getItem(this.mHotTopicDataList, AR);
        if (eVar == null || eVar.getPageData() == null) {
            this.jgX.AP(AR);
            return;
        }
        if (eVar.getPageData().beo() != 0) {
            this.jgX.AP(AR);
            return;
        }
        this.jgX.AP(AR);
        this.jgX.AO(AR);
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable() && this.jgX != null) {
            this.jgX.bHn();
            this.jgX.AX(0);
            cDn();
        }
    }

    public String cDr() {
        return this.eqD;
    }

    public String getTopicName() {
        return this.ecp;
    }

    public void cDi() {
        f cDG;
        if (!y.isEmpty(this.mHotTopicDataList) && (cDG = this.mHotTopicDataList.get(0).cDG()) != null) {
            this.jgJ.b(cDG.eqD, cDG.ecp, null, cDG.jbT, cDG.shareTitle, true);
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
        if (cVar != null && cVar.bcY() != null) {
            aq aqVar = new aq("c13021");
            aqVar.dF("tid", cVar.bcY().getTid()).u("fid", cVar.bcY().getFid()).dF("obj_source", cVar.bcY().mRecomSource).dF("obj_locate", getFrom()).dF("obj_name", getTopicName()).dF(TiebaInitialize.Params.OBJ_PARAM3, m.cfe()).dF("ab_tag", cVar.cfA());
            s.cfn().e(aqVar);
        }
    }

    public void t(com.baidu.tieba.card.data.c cVar) {
        if (cVar != null && cVar.bcY() != null) {
            com.baidu.tieba.hottopic.b.b.a(cVar.bcY(), getTopicName(), getFrom(), cVar.objType);
        }
    }

    private boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || at.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this).createNormalConfig("from_hottopic", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }
}

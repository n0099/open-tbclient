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
import com.baidu.tbadk.core.data.au;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.n;
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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.GetMyPost.User_Info;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes21.dex */
public class HotTopicActivity extends BaseActivity<HotTopicActivity> implements BdListView.e, UserIconBox.b, HotRelateThreadModel.a, HotRelateThreadModel.b, HotTopicModel.a, a, FrsCommonImageLayout.c {
    private long evO;
    private com.baidu.adp.lib.d.b<TbImageView> few;
    private long fid;
    private String firstDir;
    private LikeModel jLH;
    private BlessModel kcJ;
    private com.baidu.adp.lib.d.b<TbImageView> kcK;
    private b kcs;
    private List<HotTopicBussinessData> mDataList;
    private List<e> mHotTopicDataList;
    private String secondDir;
    private com.baidu.tieba.hottopic.view.c kcG = null;
    private HotTopicModel kcH = null;
    private HotRelateThreadModel kcI = null;
    private String eXq = null;
    private String eIa = null;
    private String mFrom = "";
    private long lastResumeTime = 0;
    private int mIsGlobalBlock = 0;
    private boolean kcL = true;
    private AntiHelper.a iUq = new AntiHelper.a() { // from class: com.baidu.tieba.hottopic.controller.HotTopicActivity.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).al("obj_locate", ay.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).al("obj_locate", ay.a.LOCATE_LIKE_PERSON));
        }
    };
    private final com.baidu.adp.framework.listener.a iqk = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.hottopic.controller.HotTopicActivity.2
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
    private com.baidu.adp.base.d ivF = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.hottopic.controller.HotTopicActivity.3
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (!AntiHelper.bP(HotTopicActivity.this.jLH.getErrorCode(), HotTopicActivity.this.jLH.getErrorString())) {
                if (!StringUtils.isNull(HotTopicActivity.this.jLH.getErrorString())) {
                    l.showToast(TbadkCoreApplication.getInst(), HotTopicActivity.this.jLH.getErrorString());
                }
            } else if (AntiHelper.a(HotTopicActivity.this.getActivity(), HotTopicActivity.this.jLH.getErrorString(), HotTopicActivity.this.jLH.getErrorCode(), HotTopicActivity.this.iUq) != null) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).al("obj_locate", ay.a.LOCATE_LIKE_PERSON));
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
        } else if (this.kcG != null && y.getItem(this.mHotTopicDataList, this.kcG.getCurrentTab()) != null && this.kcG.cSn() != null) {
            e eVar = (e) y.getItem(this.mHotTopicDataList, this.kcG.getCurrentTab());
            au auVar = new au();
            ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
            User.Builder builder2 = new User.Builder(builder.author);
            a(builder2, getMyPostResIdl.data.user_info);
            builder.author = builder2.build(true);
            auVar.a(builder.build(true));
            eVar.aG(auVar);
            this.kcG.cSn().d(eVar);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        an(bundle);
        this.kcG = new com.baidu.tieba.hottopic.view.c(getPageContext(), this.eXq);
        this.kcH = new HotTopicModel(this);
        this.kcH.a(this);
        this.jLH = new LikeModel(getPageContext());
        this.jLH.setLoadDataCallBack(this.ivF);
        this.kcI = new HotRelateThreadModel(this);
        this.kcI.a((HotRelateThreadModel.a) this);
        this.kcI.a((HotRelateThreadModel.b) this);
        this.kcs = new b(this);
        this.kcJ = new BlessModel(this);
        bZp();
        cRx();
    }

    private void cRx() {
        showLoadingView(this.kcG.cSh(), false);
        if (!j.isNetworkAvailableForImmediately()) {
            hideLoadingView(this.kcG.cSh());
            showNetRefreshView(this.kcG.cSh(), getResources().getString(R.string.neterror), true);
            setNetRefreshViewTopMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds530));
            this.kcG.Dw(8);
            return;
        }
        this.kcG.Dw(0);
        cRz();
    }

    private void an(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.eXq = intent.getStringExtra("topic_id");
            this.eIa = intent.getStringExtra("topic_name");
            this.fid = intent.getLongExtra("topic_fid", 0L);
            this.firstDir = intent.getStringExtra("topic_first_dir");
            this.secondDir = intent.getStringExtra("topic_second_dir");
            this.mFrom = intent.getStringExtra("from");
            this.evO = intent.getLongExtra(IntentConfig.TOPIC_TID, 0L);
        } else if (bundle != null) {
            this.eXq = bundle.getString("topic_id");
            this.eIa = bundle.getString("topic_name");
            this.fid = bundle.getLong("topic_fid", 0L);
            this.firstDir = bundle.getString("topic_first_dir");
            this.secondDir = bundle.getString("topic_second_dir");
            this.mFrom = bundle.getString("from");
            this.mFrom = bundle.getString("from");
            this.evO = bundle.getLong(IntentConfig.TOPIC_TID, 0L);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onResume() {
        this.lastResumeTime = System.currentTimeMillis();
        super.onResume();
        if (this.kcG != null) {
            this.kcG.resume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(e eVar) {
        if (this.mDataList == null) {
            this.mDataList = new ArrayList();
        } else {
            this.mDataList.clear();
        }
        this.mDataList.add(new HotTopicBussinessData(0L, "", eVar.cRS().eIa, this.mIsGlobalBlock));
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
                            if (this.kcG != null && y.getItem(this.mDataList, this.kcG.getCurrentTab()) != null) {
                                j3 = com.baidu.adp.lib.f.b.toLong(String.valueOf(((HotTopicBussinessData) y.getItem(this.mDataList, this.kcG.getCurrentTab())).mForumId), 0L);
                            }
                            if (j != 0 && j2 != 0) {
                                int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                                int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                                float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                                int i3 = 1;
                                if (av.btX().btY()) {
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
                        this.kcs.a(cRy(), intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L), this.mHotTopicDataList.get(0));
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHARE_FRIEND_FORUM /* 23007 */:
                    if (intent != null && !y.isEmpty(this.mHotTopicDataList)) {
                        this.kcs.a(cRy(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra("name_show"), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT), this.mHotTopicDataList.get(0));
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
        TiebaStatic.log(new ar("c10817").dY("obj_duration", String.valueOf(System.currentTimeMillis() - this.lastResumeTime)));
        setRequestedOrientation(1);
        if (this.kcG != null) {
            this.kcG.pause();
        }
        super.onPause();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        t.csg().bPr();
        if (this.kcG != null) {
            this.kcG.destroy();
        }
        super.onDestroy();
    }

    public ShareFromTopicMsgData cRy() {
        f cRS;
        if (!y.isEmpty(this.mHotTopicDataList) && (cRS = this.mHotTopicDataList.get(0).cRS()) != null) {
            StringBuilder sb = new StringBuilder();
            ShareFromTopicMsgData shareFromTopicMsgData = new ShareFromTopicMsgData();
            shareFromTopicMsgData.setContent(cRS.shareTitle);
            shareFromTopicMsgData.setImageUrl(cRS.jXD);
            shareFromTopicMsgData.setTitle(cRS.eIa);
            shareFromTopicMsgData.setHotTopicID(cRS.eXq);
            shareFromTopicMsgData.setHotTopicName(cRS.eIa);
            sb.append("http://tieba.baidu.com/").append("mo/q/hotMessage?topic_id=").append(cRS.eXq).append("&topic_name=").append(cRS.eIa);
            shareFromTopicMsgData.setLinkUrl(sb.toString());
            return shareFromTopicMsgData;
        }
        return null;
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.kcG.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.hottopic.controller.HotTopicModel.a
    public void a(boolean z, e eVar) {
        hideLoadingView(this.kcG.cSh());
        if (this.kcG != null) {
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
            this.mIsGlobalBlock = eVar.cSc();
            if (eVar.cRU() != null && eVar.cRV() != null) {
                this.kcG.a(8, true, 0L, 0);
            } else if (eVar.cRU() != null) {
                this.kcG.a(0, true, eVar.cRU().totalNum, eVar.cRU().kde);
            } else if (eVar.cRV() != null) {
                this.kcG.a(0, false, eVar.cRV().totalNum, eVar.cRV().kde);
            }
            this.kcG.eh(this.mHotTopicDataList);
            this.kcG.c(eVar);
            this.kcG.cSj();
            a(eVar.sortType, eVar.getPageData());
        }
    }

    public void cRz() {
        if (j.isNetWorkAvailable() && this.kcH != null) {
            this.kcH.a(this.eXq, this.eIa, getSortType(), this.fid, this.firstDir, this.secondDir, this.mFrom, this.evO);
        }
    }

    public void cRA() {
        if (this.kcJ != null && !y.isEmpty(this.mHotTopicDataList) && j.isNetWorkAvailable()) {
            com.baidu.tieba.hottopic.data.a cRU = this.mHotTopicDataList.get(0).cRU();
            com.baidu.tieba.hottopic.data.a cRV = this.mHotTopicDataList.get(0).cRV();
            if (cRU != null) {
                this.kcJ.a(cRU.pkId, Long.parseLong(this.eXq), 1, 0, 1, cRU.userPkId);
            } else if (cRV != null) {
                this.kcJ.a(cRV.pkId, Long.parseLong(this.eXq), 1, 0, 1, cRV.userPkId);
            }
        }
    }

    public void cRB() {
        i cRT;
        if (this.kcJ != null && !y.isEmpty(this.mHotTopicDataList) && j.isNetWorkAvailable() && (cRT = this.mHotTopicDataList.get(0).cRT()) != null) {
            this.kcJ.a(cRT.pkId, Long.parseLong(this.eXq), cRT.kde, 0, 0, cRT.userPkId);
        }
    }

    private void bZp() {
        this.kcG.b(new View.OnTouchListener() { // from class: com.baidu.tieba.hottopic.controller.HotTopicActivity.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                e eVar;
                if (!bh.checkUpIsLogin(HotTopicActivity.this.getActivity()) || motionEvent.getAction() != 1 || (eVar = (e) y.getItem(HotTopicActivity.this.mHotTopicDataList, HotTopicActivity.this.kcG.getCurrentTab())) == null) {
                    return true;
                }
                if (!j.isNetWorkAvailable()) {
                    l.showToast(HotTopicActivity.this.getPageContext().getContext(), R.string.no_network_guide);
                }
                HotTopicActivity.this.b(eVar);
                WriteActivityConfig writeActivityConfig = new WriteActivityConfig(HotTopicActivity.this.getPageContext().getPageActivity(), 9, String.valueOf(0), "", null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0);
                writeActivityConfig.getIntent().putExtra("hot_topic_forum_list", (Serializable) HotTopicActivity.this.mDataList);
                writeActivityConfig.getIntent().putExtra(WriteActivityConfig.HOT_TOPIC_ID, HotTopicActivity.this.eXq);
                writeActivityConfig.setCallFrom("1");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                ar arVar = new ar(CommonStatisticKey.KEY_ENTRANCE_CLICKED);
                arVar.al("obj_locate", 6).al("obj_type", 1);
                TiebaStatic.log(arVar);
                return true;
            }
        });
        this.kcG.g(new NoNetworkView.a() { // from class: com.baidu.tieba.hottopic.controller.HotTopicActivity.5
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                HotTopicActivity.this.kcG.rU(!z);
                if (z && HotTopicActivity.this.kcH != null && y.getItem(HotTopicActivity.this.mHotTopicDataList, HotTopicActivity.this.kcG.getCurrentTab()) != null) {
                    e eVar = (e) HotTopicActivity.this.mHotTopicDataList.get(HotTopicActivity.this.kcG.getCurrentTab());
                    if (eVar == null || y.isEmpty(eVar.cRZ())) {
                        HotTopicActivity.this.kcG.Yb();
                        HotTopicActivity.this.kcG.showLoadingView();
                        HotTopicActivity.this.cRz();
                    }
                }
            }
        });
        this.iqk.getSocketMessageListener().setSelfListener(true);
        this.iqk.getHttpMessageListener().setSelfListener(true);
        registerListener(this.iqk);
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> cBr() {
        if (this.kcK == null) {
            this.kcK = FrsCommonImageLayout.P(getPageContext().getPageActivity(), 12);
        }
        return this.kcK;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> bvR() {
        if (this.few == null) {
            this.few = UserIconBox.D(getPageContext().getPageActivity(), 8);
        }
        return this.few;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public ListView bvQ() {
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.kcG == null || y.isEmpty(this.mHotTopicDataList) || !j.isNetWorkAvailable()) {
            cRC();
            return;
        }
        e eVar = (e) y.getItem(this.mHotTopicDataList, this.kcG.getCurrentTab());
        if (eVar == null || eVar.getPageData() == null) {
            cRC();
        } else if (eVar.kdF && this.kcL) {
            this.kcI.b(eVar, getSortType());
            this.kcL = false;
        }
    }

    public int getSortType() {
        return this.kcG.getCurrentTab() == 0 ? 1 : 0;
    }

    public int Dq(int i) {
        return i == 1 ? 0 : 1;
    }

    @Override // com.baidu.tieba.hottopic.controller.HotRelateThreadModel.a
    public void complete() {
        this.kcL = true;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (!StringUtils.isNull(this.eIa) || !StringUtils.isNull(this.eXq)) {
            bundle.putString("topic_id", this.eXq);
            bundle.putString("topic_name", this.eIa);
        }
    }

    @Override // com.baidu.tieba.hottopic.controller.HotRelateThreadModel.b
    public void a(boolean z, com.baidu.tieba.hottopic.data.d dVar, int i) {
        if (!z || dVar == null || y.isEmpty(this.mHotTopicDataList) || y.getCount(dVar.fVe) == 0) {
            this.kcG.Do(Dq(i));
            return;
        }
        e eVar = (e) y.getItem(this.mHotTopicDataList, Dq(i));
        if (eVar == null) {
            this.kcG.Do(Dq(i));
            return;
        }
        eVar.a(dVar);
        this.kcG.eh(this.mHotTopicDataList);
        a(i, dVar.pageData);
    }

    private void a(int i, ax axVar) {
        if (axVar != null) {
            int Dq = Dq(i);
            e eVar = (e) y.getItem(this.mHotTopicDataList, Dq);
            if (eVar != null) {
                eVar.a(axVar);
            }
            if (axVar.bnF() != 0) {
                this.kcG.Dm(Dq);
                return;
            }
            this.kcG.Do(Dq);
            this.kcG.Dn(Dq);
        }
    }

    private void cRC() {
        int Dq = Dq(getSortType());
        e eVar = (e) y.getItem(this.mHotTopicDataList, Dq);
        if (eVar == null || eVar.getPageData() == null) {
            this.kcG.Do(Dq);
            return;
        }
        if (eVar.getPageData().bnF() != 0) {
            this.kcG.Do(Dq);
            return;
        }
        this.kcG.Do(Dq);
        this.kcG.Dn(Dq);
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable() && this.kcG != null) {
            this.kcG.Yb();
            this.kcG.Dw(0);
            cRz();
        }
    }

    public String cRD() {
        return this.eXq;
    }

    public String getTopicName() {
        return this.eIa;
    }

    public void cRu() {
        f cRS;
        if (!y.isEmpty(this.mHotTopicDataList) && (cRS = this.mHotTopicDataList.get(0).cRS()) != null) {
            this.kcs.a(cRS.eXq, cRS.eIa, (String) null, cRS.jXD, cRS.shareTitle, true);
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
        if (bVar != null && bVar.bmn() != null) {
            ar arVar = new ar("c13021");
            arVar.dY("tid", bVar.bmn().getTid()).w("fid", bVar.bmn().getFid()).dY("obj_source", bVar.bmn().mRecomSource).dY("obj_locate", getFrom()).dY("obj_name", getTopicName()).dY(TiebaInitialize.Params.OBJ_PARAM3, n.crX()).dY("ab_tag", bVar.cst());
            t.csg().e(arVar);
        }
    }

    public void t(com.baidu.tieba.card.data.b bVar) {
        if (bVar != null && bVar.bmn() != null) {
            com.baidu.tieba.hottopic.b.b.a(bVar.bmn(), getTopicName(), getFrom(), bVar.objType);
        }
    }

    private boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || com.baidu.tbadk.core.util.au.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this).createNormalConfig("from_hottopic", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }
}

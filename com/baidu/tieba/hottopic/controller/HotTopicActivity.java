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
/* loaded from: classes7.dex */
public class HotTopicActivity extends BaseActivity<HotTopicActivity> implements BdListView.e, UserIconBox.a, HotRelateThreadModel.a, HotRelateThreadModel.b, HotTopicModel.a, a, FrsCommonImageLayout.c {
    private long eDZ;
    private long fid;
    private String firstDir;
    private com.baidu.adp.lib.d.b<TbImageView> fnn;
    private LikeModel kej;
    private BlessModel kvP;
    private com.baidu.adp.lib.d.b<TbImageView> kvQ;
    private b kvy;
    private List<HotTopicBussinessData> mDataList;
    private List<e> mHotTopicDataList;
    private String secondDir;
    private com.baidu.tieba.hottopic.view.c kvM = null;
    private HotTopicModel kvN = null;
    private HotRelateThreadModel kvO = null;
    private String ffX = null;
    private String eQU = null;
    private String mFrom = "";
    private long lastResumeTime = 0;
    private int mIsGlobalBlock = 0;
    private boolean kvR = true;
    private AntiHelper.a jjA = new AntiHelper.a() { // from class: com.baidu.tieba.hottopic.controller.HotTopicActivity.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).aq("obj_locate", ay.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).aq("obj_locate", ay.a.LOCATE_LIKE_PERSON));
        }
    };
    private final com.baidu.adp.framework.listener.a iFG = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.hottopic.controller.HotTopicActivity.2
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
    private com.baidu.adp.base.e iKU = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.hottopic.controller.HotTopicActivity.3
        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            if (!AntiHelper.bX(HotTopicActivity.this.kej.getErrorCode(), HotTopicActivity.this.kej.getErrorString())) {
                if (!StringUtils.isNull(HotTopicActivity.this.kej.getErrorString())) {
                    l.showToast(TbadkCoreApplication.getInst(), HotTopicActivity.this.kej.getErrorString());
                }
            } else if (AntiHelper.a(HotTopicActivity.this.getActivity(), HotTopicActivity.this.kej.getErrorString(), HotTopicActivity.this.kej.getErrorCode(), HotTopicActivity.this.jjA) != null) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).aq("obj_locate", ay.a.LOCATE_LIKE_PERSON));
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
        } else if (this.kvM != null && y.getItem(this.mHotTopicDataList, this.kvM.getCurrentTab()) != null && this.kvM.cTQ() != null) {
            e eVar = (e) y.getItem(this.mHotTopicDataList, this.kvM.getCurrentTab());
            aw awVar = new aw();
            ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
            User.Builder builder2 = new User.Builder(builder.author);
            a(builder2, getMyPostResIdl.data.user_info);
            builder.author = builder2.build(true);
            awVar.a(builder.build(true));
            eVar.aI(awVar);
            this.kvM.cTQ().c(eVar);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        an(bundle);
        this.kvM = new com.baidu.tieba.hottopic.view.c(getPageContext(), this.ffX);
        this.kvN = new HotTopicModel(this);
        this.kvN.a(this);
        this.kej = new LikeModel(getPageContext());
        this.kej.setLoadDataCallBack(this.iKU);
        this.kvO = new HotRelateThreadModel(this);
        this.kvO.a((HotRelateThreadModel.a) this);
        this.kvO.a((HotRelateThreadModel.b) this);
        this.kvy = new b(this);
        this.kvP = new BlessModel(this);
        bZr();
        cTa();
    }

    private void cTa() {
        showLoadingView(this.kvM.cTK(), false);
        if (!j.isNetworkAvailableForImmediately()) {
            hideLoadingView(this.kvM.cTK());
            showNetRefreshView(this.kvM.cTK(), getResources().getString(R.string.neterror), true);
            setNetRefreshViewTopMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds530));
            this.kvM.Cy(8);
            return;
        }
        this.kvM.Cy(0);
        cTc();
    }

    private void an(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.ffX = intent.getStringExtra("topic_id");
            this.eQU = intent.getStringExtra("topic_name");
            this.fid = intent.getLongExtra("topic_fid", 0L);
            this.firstDir = intent.getStringExtra("topic_first_dir");
            this.secondDir = intent.getStringExtra("topic_second_dir");
            this.mFrom = intent.getStringExtra("from");
            this.eDZ = intent.getLongExtra(IntentConfig.TOPIC_TID, 0L);
        } else if (bundle != null) {
            this.ffX = bundle.getString("topic_id");
            this.eQU = bundle.getString("topic_name");
            this.fid = bundle.getLong("topic_fid", 0L);
            this.firstDir = bundle.getString("topic_first_dir");
            this.secondDir = bundle.getString("topic_second_dir");
            this.mFrom = bundle.getString("from");
            this.mFrom = bundle.getString("from");
            this.eDZ = bundle.getLong(IntentConfig.TOPIC_TID, 0L);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onResume() {
        this.lastResumeTime = System.currentTimeMillis();
        super.onResume();
        if (this.kvM != null) {
            this.kvM.resume();
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
                            if (this.kvM != null && y.getItem(this.mDataList, this.kvM.getCurrentTab()) != null) {
                                j3 = com.baidu.adp.lib.f.b.toLong(String.valueOf(((HotTopicBussinessData) y.getItem(this.mDataList, this.kvM.getCurrentTab())).mForumId), 0L);
                            }
                            if (j != 0 && j2 != 0) {
                                int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                                int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                                float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                                int i3 = 1;
                                if (av.bsV().bsW()) {
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
                        this.kvy.a(cTb(), intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L), this.mHotTopicDataList.get(0));
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHARE_FRIEND_FORUM /* 23007 */:
                    if (intent != null && !y.isEmpty(this.mHotTopicDataList)) {
                        this.kvy.a(cTb(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra("name_show"), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT), this.mHotTopicDataList.get(0));
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
        if (this.kvM != null) {
            this.kvM.pause();
        }
        super.onPause();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        t.csH().bOS();
        if (this.kvM != null) {
            this.kvM.destroy();
        }
        super.onDestroy();
    }

    public ShareFromTopicMsgData cTb() {
        f cTv;
        if (!y.isEmpty(this.mHotTopicDataList) && (cTv = this.mHotTopicDataList.get(0).cTv()) != null) {
            StringBuilder sb = new StringBuilder();
            ShareFromTopicMsgData shareFromTopicMsgData = new ShareFromTopicMsgData();
            shareFromTopicMsgData.setContent(cTv.shareTitle);
            shareFromTopicMsgData.setImageUrl(cTv.kqJ);
            shareFromTopicMsgData.setTitle(cTv.eQU);
            shareFromTopicMsgData.setHotTopicID(cTv.ffX);
            shareFromTopicMsgData.setHotTopicName(cTv.eQU);
            sb.append("http://tieba.baidu.com/").append("mo/q/hotMessage?topic_id=").append(cTv.ffX).append("&topic_name=").append(cTv.eQU);
            shareFromTopicMsgData.setLinkUrl(sb.toString());
            return shareFromTopicMsgData;
        }
        return null;
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.kvM.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.hottopic.controller.HotTopicModel.a
    public void a(boolean z, e eVar) {
        hideLoadingView(this.kvM.cTK());
        if (this.kvM != null) {
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
            this.mIsGlobalBlock = eVar.cTF();
            if (eVar.cTx() != null && eVar.cTy() != null) {
                this.kvM.a(8, true, 0L, 0);
            } else if (eVar.cTx() != null) {
                this.kvM.a(0, true, eVar.cTx().totalNum, eVar.cTx().kwk);
            } else if (eVar.cTy() != null) {
                this.kvM.a(0, false, eVar.cTy().totalNum, eVar.cTy().kwk);
            }
            this.kvM.em(this.mHotTopicDataList);
            this.kvM.b(eVar);
            this.kvM.cTM();
            a(eVar.sortType, eVar.getPageData());
        }
    }

    public void cTc() {
        if (j.isNetWorkAvailable() && this.kvN != null) {
            this.kvN.a(this.ffX, this.eQU, getSortType(), this.fid, this.firstDir, this.secondDir, this.mFrom, this.eDZ);
        }
    }

    public void cTd() {
        if (this.kvP != null && !y.isEmpty(this.mHotTopicDataList) && j.isNetWorkAvailable()) {
            com.baidu.tieba.hottopic.data.a cTx = this.mHotTopicDataList.get(0).cTx();
            com.baidu.tieba.hottopic.data.a cTy = this.mHotTopicDataList.get(0).cTy();
            if (cTx != null) {
                this.kvP.a(cTx.pkId, Long.parseLong(this.ffX), 1, 0, 1, cTx.userPkId);
            } else if (cTy != null) {
                this.kvP.a(cTy.pkId, Long.parseLong(this.ffX), 1, 0, 1, cTy.userPkId);
            }
        }
    }

    public void cTe() {
        i cTw;
        if (this.kvP != null && !y.isEmpty(this.mHotTopicDataList) && j.isNetWorkAvailable() && (cTw = this.mHotTopicDataList.get(0).cTw()) != null) {
            this.kvP.a(cTw.pkId, Long.parseLong(this.ffX), cTw.kwk, 0, 0, cTw.userPkId);
        }
    }

    private void bZr() {
        this.kvM.b(new View.OnTouchListener() { // from class: com.baidu.tieba.hottopic.controller.HotTopicActivity.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (!bh.checkUpIsLogin(HotTopicActivity.this.getActivity())) {
                }
                return true;
            }
        });
        this.kvM.g(new NoNetworkView.a() { // from class: com.baidu.tieba.hottopic.controller.HotTopicActivity.5
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                HotTopicActivity.this.kvM.sA(!z);
                if (z && HotTopicActivity.this.kvN != null && y.getItem(HotTopicActivity.this.mHotTopicDataList, HotTopicActivity.this.kvM.getCurrentTab()) != null) {
                    e eVar = (e) HotTopicActivity.this.mHotTopicDataList.get(HotTopicActivity.this.kvM.getCurrentTab());
                    if (eVar == null || y.isEmpty(eVar.cTC())) {
                        HotTopicActivity.this.kvM.Xc();
                        HotTopicActivity.this.kvM.showLoadingView();
                        HotTopicActivity.this.cTc();
                    }
                }
            }
        });
        this.iFG.getSocketMessageListener().setSelfListener(true);
        this.iFG.getHttpMessageListener().setSelfListener(true);
        registerListener(this.iFG);
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> cBS() {
        if (this.kvQ == null) {
            this.kvQ = FrsCommonImageLayout.Q(getPageContext().getPageActivity(), 12);
        }
        return this.kvQ;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.a
    public com.baidu.adp.lib.d.b<TbImageView> buP() {
        if (this.fnn == null) {
            this.fnn = UserIconBox.E(getPageContext().getPageActivity(), 8);
        }
        return this.fnn;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.kvM == null || y.isEmpty(this.mHotTopicDataList) || !j.isNetWorkAvailable()) {
            cTf();
            return;
        }
        e eVar = (e) y.getItem(this.mHotTopicDataList, this.kvM.getCurrentTab());
        if (eVar == null || eVar.getPageData() == null) {
            cTf();
        } else if (eVar.kwL && this.kvR) {
            this.kvO.b(eVar, getSortType());
            this.kvR = false;
        }
    }

    public int getSortType() {
        return this.kvM.getCurrentTab() == 0 ? 1 : 0;
    }

    public int Cs(int i) {
        return i == 1 ? 0 : 1;
    }

    @Override // com.baidu.tieba.hottopic.controller.HotRelateThreadModel.a
    public void complete() {
        this.kvR = true;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (!StringUtils.isNull(this.eQU) || !StringUtils.isNull(this.ffX)) {
            bundle.putString("topic_id", this.ffX);
            bundle.putString("topic_name", this.eQU);
        }
    }

    @Override // com.baidu.tieba.hottopic.controller.HotRelateThreadModel.b
    public void a(boolean z, com.baidu.tieba.hottopic.data.d dVar, int i) {
        if (!z || dVar == null || y.isEmpty(this.mHotTopicDataList) || y.getCount(dVar.gdY) == 0) {
            this.kvM.Cq(Cs(i));
            return;
        }
        e eVar = (e) y.getItem(this.mHotTopicDataList, Cs(i));
        if (eVar == null) {
            this.kvM.Cq(Cs(i));
            return;
        }
        eVar.a(dVar);
        this.kvM.em(this.mHotTopicDataList);
        a(i, dVar.pageData);
    }

    private void a(int i, az azVar) {
        if (azVar != null) {
            int Cs = Cs(i);
            e eVar = (e) y.getItem(this.mHotTopicDataList, Cs);
            if (eVar != null) {
                eVar.a(azVar);
            }
            if (azVar.bmH() != 0) {
                this.kvM.Co(Cs);
                return;
            }
            this.kvM.Cq(Cs);
            this.kvM.Cp(Cs);
        }
    }

    private void cTf() {
        int Cs = Cs(getSortType());
        e eVar = (e) y.getItem(this.mHotTopicDataList, Cs);
        if (eVar == null || eVar.getPageData() == null) {
            this.kvM.Cq(Cs);
            return;
        }
        if (eVar.getPageData().bmH() != 0) {
            this.kvM.Cq(Cs);
            return;
        }
        this.kvM.Cq(Cs);
        this.kvM.Cp(Cs);
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable() && this.kvM != null) {
            this.kvM.Xc();
            this.kvM.Cy(0);
            cTc();
        }
    }

    public String cTg() {
        return this.ffX;
    }

    public String getTopicName() {
        return this.eQU;
    }

    public void cSX() {
        f cTv;
        if (!y.isEmpty(this.mHotTopicDataList) && (cTv = this.mHotTopicDataList.get(0).cTv()) != null) {
            this.kvy.a(cTv.ffX, cTv.eQU, (String) null, cTv.kqJ, cTv.shareTitle, true);
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
        if (bVar != null && bVar.blp() != null) {
            ar arVar = new ar("c13021");
            arVar.dR("tid", bVar.blp().getTid()).v("fid", bVar.blp().getFid()).dR("obj_source", bVar.blp().mRecomSource).dR("obj_locate", getFrom()).dR("obj_name", getTopicName()).dR(TiebaInitialize.Params.OBJ_PARAM3, m.csx()).dR("ab_tag", bVar.csV());
            t.csH().e(arVar);
        }
    }

    public void t(com.baidu.tieba.card.data.b bVar) {
        if (bVar != null && bVar.blp() != null) {
            com.baidu.tieba.hottopic.a.b.a(bVar.blp(), getTopicName(), getFrom(), bVar.objType);
        }
    }

    private boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || au.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.brR().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this).createNormalConfig("from_hottopic", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }
}

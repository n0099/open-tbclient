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
    private com.baidu.adp.lib.d.b<TbImageView> eXS;
    private long eqw;
    private long fid;
    private String firstDir;
    private b jOf;
    private BlessModel jOw;
    private com.baidu.adp.lib.d.b<TbImageView> jOx;
    private LikeModel jxo;
    private List<HotTopicBussinessData> mDataList;
    private List<e> mHotTopicDataList;
    private String secondDir;
    private com.baidu.tieba.hottopic.view.c jOt = null;
    private HotTopicModel jOu = null;
    private HotRelateThreadModel jOv = null;
    private String eRa = null;
    private String eCJ = null;
    private String mFrom = "";
    private long lastResumeTime = 0;
    private int mIsGlobalBlock = 0;
    private boolean jOy = true;
    private AntiHelper.a iIK = new AntiHelper.a() { // from class: com.baidu.tieba.hottopic.controller.HotTopicActivity.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).al("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).al("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }
    };
    private final com.baidu.adp.framework.listener.a ieB = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.hottopic.controller.HotTopicActivity.2
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
    private com.baidu.adp.base.d ijY = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.hottopic.controller.HotTopicActivity.3
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (!AntiHelper.bR(HotTopicActivity.this.jxo.getErrorCode(), HotTopicActivity.this.jxo.getErrorString())) {
                if (!StringUtils.isNull(HotTopicActivity.this.jxo.getErrorString())) {
                    l.showToast(TbadkCoreApplication.getInst(), HotTopicActivity.this.jxo.getErrorString());
                }
            } else if (AntiHelper.a(HotTopicActivity.this.getActivity(), HotTopicActivity.this.jxo.getErrorString(), HotTopicActivity.this.jxo.getErrorCode(), HotTopicActivity.this.iIK) != null) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).al("obj_locate", ax.a.LOCATE_LIKE_PERSON));
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
        } else if (this.jOt != null && y.getItem(this.mHotTopicDataList, this.jOt.getCurrentTab()) != null && this.jOt.cNt() != null) {
            e eVar = (e) y.getItem(this.mHotTopicDataList, this.jOt.getCurrentTab());
            as asVar = new as();
            ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
            User.Builder builder2 = new User.Builder(builder.author);
            a(builder2, getMyPostResIdl.data.user_info);
            builder.author = builder2.build(true);
            asVar.a(builder.build(true));
            eVar.aE(asVar);
            this.jOt.cNt().d(eVar);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        as(bundle);
        this.jOt = new com.baidu.tieba.hottopic.view.c(getPageContext(), this.eRa);
        this.jOu = new HotTopicModel(this);
        this.jOu.a(this);
        this.jxo = new LikeModel(getPageContext());
        this.jxo.setLoadDataCallBack(this.ijY);
        this.jOv = new HotRelateThreadModel(this);
        this.jOv.a((HotRelateThreadModel.a) this);
        this.jOv.a((HotRelateThreadModel.b) this);
        this.jOf = new b(this);
        this.jOw = new BlessModel(this);
        bWm();
        cMC();
    }

    private void cMC() {
        showLoadingView(this.jOt.cNn(), false);
        if (!j.isNetworkAvailableForImmediately()) {
            hideLoadingView(this.jOt.cNn());
            showNetRefreshView(this.jOt.cNn(), getResources().getString(R.string.neterror), true);
            setNetRefreshViewTopMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds530));
            this.jOt.Cj(8);
            return;
        }
        this.jOt.Cj(0);
        cME();
    }

    private void as(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.eRa = intent.getStringExtra("topic_id");
            this.eCJ = intent.getStringExtra("topic_name");
            this.fid = intent.getLongExtra("topic_fid", 0L);
            this.firstDir = intent.getStringExtra("topic_first_dir");
            this.secondDir = intent.getStringExtra("topic_second_dir");
            this.mFrom = intent.getStringExtra("from");
            this.eqw = intent.getLongExtra(IntentConfig.TOPIC_TID, 0L);
        } else if (bundle != null) {
            this.eRa = bundle.getString("topic_id");
            this.eCJ = bundle.getString("topic_name");
            this.fid = bundle.getLong("topic_fid", 0L);
            this.firstDir = bundle.getString("topic_first_dir");
            this.secondDir = bundle.getString("topic_second_dir");
            this.mFrom = bundle.getString("from");
            this.mFrom = bundle.getString("from");
            this.eqw = bundle.getLong(IntentConfig.TOPIC_TID, 0L);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onResume() {
        this.lastResumeTime = System.currentTimeMillis();
        super.onResume();
        if (this.jOt != null) {
            this.jOt.resume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(e eVar) {
        if (this.mDataList == null) {
            this.mDataList = new ArrayList();
        } else {
            this.mDataList.clear();
        }
        this.mDataList.add(new HotTopicBussinessData(0L, "", eVar.cMX().eCJ, this.mIsGlobalBlock));
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
                            if (this.jOt != null && y.getItem(this.mDataList, this.jOt.getCurrentTab()) != null) {
                                j3 = com.baidu.adp.lib.f.b.toLong(String.valueOf(((HotTopicBussinessData) y.getItem(this.mDataList, this.jOt.getCurrentTab())).mForumId), 0L);
                            }
                            if (j != 0 && j2 != 0) {
                                int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                                int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                                float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                                int i3 = 1;
                                if (au.bro().brp()) {
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
                        this.jOf.a(cMD(), intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L), this.mHotTopicDataList.get(0));
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHARE_FRIEND_FORUM /* 23007 */:
                    if (intent != null && !y.isEmpty(this.mHotTopicDataList)) {
                        this.jOf.a(cMD(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra("name_show"), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT), this.mHotTopicDataList.get(0));
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
        TiebaStatic.log(new aq("c10817").dR("obj_duration", String.valueOf(System.currentTimeMillis() - this.lastResumeTime)));
        setRequestedOrientation(1);
        if (this.jOt != null) {
            this.jOt.pause();
        }
        super.onPause();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        t.cor().bMp();
        if (this.jOt != null) {
            this.jOt.destroy();
        }
        super.onDestroy();
    }

    public ShareFromTopicMsgData cMD() {
        f cMX;
        if (!y.isEmpty(this.mHotTopicDataList) && (cMX = this.mHotTopicDataList.get(0).cMX()) != null) {
            StringBuilder sb = new StringBuilder();
            ShareFromTopicMsgData shareFromTopicMsgData = new ShareFromTopicMsgData();
            shareFromTopicMsgData.setContent(cMX.shareTitle);
            shareFromTopicMsgData.setImageUrl(cMX.jJp);
            shareFromTopicMsgData.setTitle(cMX.eCJ);
            shareFromTopicMsgData.setHotTopicID(cMX.eRa);
            shareFromTopicMsgData.setHotTopicName(cMX.eCJ);
            sb.append("http://tieba.baidu.com/").append("mo/q/hotMessage?topic_id=").append(cMX.eRa).append("&topic_name=").append(cMX.eCJ);
            shareFromTopicMsgData.setLinkUrl(sb.toString());
            return shareFromTopicMsgData;
        }
        return null;
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jOt.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.hottopic.controller.HotTopicModel.a
    public void a(boolean z, e eVar) {
        hideLoadingView(this.jOt.cNn());
        if (this.jOt != null) {
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
            this.mIsGlobalBlock = eVar.cNh();
            if (eVar.cMZ() != null && eVar.cNa() != null) {
                this.jOt.a(8, true, 0L, 0);
            } else if (eVar.cMZ() != null) {
                this.jOt.a(0, true, eVar.cMZ().totalNum, eVar.cMZ().jOR);
            } else if (eVar.cNa() != null) {
                this.jOt.a(0, false, eVar.cNa().totalNum, eVar.cNa().jOR);
            }
            this.jOt.dW(this.mHotTopicDataList);
            this.jOt.c(eVar);
            this.jOt.cNp();
            a(eVar.sortType, eVar.getPageData());
        }
    }

    public void cME() {
        if (j.isNetWorkAvailable() && this.jOu != null) {
            this.jOu.a(this.eRa, this.eCJ, getSortType(), this.fid, this.firstDir, this.secondDir, this.mFrom, this.eqw);
        }
    }

    public void cMF() {
        if (this.jOw != null && !y.isEmpty(this.mHotTopicDataList) && j.isNetWorkAvailable()) {
            com.baidu.tieba.hottopic.data.a cMZ = this.mHotTopicDataList.get(0).cMZ();
            com.baidu.tieba.hottopic.data.a cNa = this.mHotTopicDataList.get(0).cNa();
            if (cMZ != null) {
                this.jOw.a(cMZ.pkId, Long.parseLong(this.eRa), 1, 0, 1, cMZ.userPkId);
            } else if (cNa != null) {
                this.jOw.a(cNa.pkId, Long.parseLong(this.eRa), 1, 0, 1, cNa.userPkId);
            }
        }
    }

    public void cMG() {
        i cMY;
        if (this.jOw != null && !y.isEmpty(this.mHotTopicDataList) && j.isNetWorkAvailable() && (cMY = this.mHotTopicDataList.get(0).cMY()) != null) {
            this.jOw.a(cMY.pkId, Long.parseLong(this.eRa), cMY.jOR, 0, 0, cMY.userPkId);
        }
    }

    private void bWm() {
        this.jOt.b(new View.OnTouchListener() { // from class: com.baidu.tieba.hottopic.controller.HotTopicActivity.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                e eVar;
                if (!bg.checkUpIsLogin(HotTopicActivity.this.getActivity()) || motionEvent.getAction() != 1 || (eVar = (e) y.getItem(HotTopicActivity.this.mHotTopicDataList, HotTopicActivity.this.jOt.getCurrentTab())) == null) {
                    return true;
                }
                if (!j.isNetWorkAvailable()) {
                    l.showToast(HotTopicActivity.this.getPageContext().getContext(), R.string.no_network_guide);
                }
                HotTopicActivity.this.b(eVar);
                WriteActivityConfig writeActivityConfig = new WriteActivityConfig(HotTopicActivity.this.getPageContext().getPageActivity(), 9, String.valueOf(0), "", null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0);
                writeActivityConfig.getIntent().putExtra("hot_topic_forum_list", (Serializable) HotTopicActivity.this.mDataList);
                writeActivityConfig.getIntent().putExtra(WriteActivityConfig.HOT_TOPIC_ID, HotTopicActivity.this.eRa);
                writeActivityConfig.setCallFrom("1");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                aq aqVar = new aq(CommonStatisticKey.KEY_ENTRANCE_CLICKED);
                aqVar.al("obj_locate", 6).al("obj_type", 1);
                TiebaStatic.log(aqVar);
                return true;
            }
        });
        this.jOt.g(new NoNetworkView.a() { // from class: com.baidu.tieba.hottopic.controller.HotTopicActivity.5
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                HotTopicActivity.this.jOt.rp(!z);
                if (z && HotTopicActivity.this.jOu != null && y.getItem(HotTopicActivity.this.mHotTopicDataList, HotTopicActivity.this.jOt.getCurrentTab()) != null) {
                    e eVar = (e) HotTopicActivity.this.mHotTopicDataList.get(HotTopicActivity.this.jOt.getCurrentTab());
                    if (eVar == null || y.isEmpty(eVar.cNe())) {
                        HotTopicActivity.this.jOt.Wk();
                        HotTopicActivity.this.jOt.showLoadingView();
                        HotTopicActivity.this.cME();
                    }
                }
            }
        });
        this.ieB.getSocketMessageListener().setSelfListener(true);
        this.ieB.getHttpMessageListener().setSelfListener(true);
        registerListener(this.ieB);
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> cxz() {
        if (this.jOx == null) {
            this.jOx = FrsCommonImageLayout.G(getPageContext().getPageActivity(), 12);
        }
        return this.jOx;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> btb() {
        if (this.eXS == null) {
            this.eXS = UserIconBox.u(getPageContext().getPageActivity(), 8);
        }
        return this.eXS;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public ListView bta() {
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.jOt == null || y.isEmpty(this.mHotTopicDataList) || !j.isNetWorkAvailable()) {
            cMH();
            return;
        }
        e eVar = (e) y.getItem(this.mHotTopicDataList, this.jOt.getCurrentTab());
        if (eVar == null || eVar.getPageData() == null) {
            cMH();
        } else if (eVar.jPs && this.jOy) {
            this.jOv.b(eVar, getSortType());
            this.jOy = false;
        }
    }

    public int getSortType() {
        return this.jOt.getCurrentTab() == 0 ? 1 : 0;
    }

    public int Cd(int i) {
        return i == 1 ? 0 : 1;
    }

    @Override // com.baidu.tieba.hottopic.controller.HotRelateThreadModel.a
    public void complete() {
        this.jOy = true;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (!StringUtils.isNull(this.eCJ) || !StringUtils.isNull(this.eRa)) {
            bundle.putString("topic_id", this.eRa);
            bundle.putString("topic_name", this.eCJ);
        }
    }

    @Override // com.baidu.tieba.hottopic.controller.HotRelateThreadModel.b
    public void a(boolean z, com.baidu.tieba.hottopic.data.d dVar, int i) {
        if (!z || dVar == null || y.isEmpty(this.mHotTopicDataList) || y.getCount(dVar.fNQ) == 0) {
            this.jOt.Cb(Cd(i));
            return;
        }
        e eVar = (e) y.getItem(this.mHotTopicDataList, Cd(i));
        if (eVar == null) {
            this.jOt.Cb(Cd(i));
            return;
        }
        eVar.a(dVar);
        this.jOt.dW(this.mHotTopicDataList);
        a(i, dVar.pageData);
    }

    private void a(int i, av avVar) {
        if (avVar != null) {
            int Cd = Cd(i);
            e eVar = (e) y.getItem(this.mHotTopicDataList, Cd);
            if (eVar != null) {
                eVar.a(avVar);
            }
            if (avVar.blq() != 0) {
                this.jOt.BZ(Cd);
                return;
            }
            this.jOt.Cb(Cd);
            this.jOt.Ca(Cd);
        }
    }

    private void cMH() {
        int Cd = Cd(getSortType());
        e eVar = (e) y.getItem(this.mHotTopicDataList, Cd);
        if (eVar == null || eVar.getPageData() == null) {
            this.jOt.Cb(Cd);
            return;
        }
        if (eVar.getPageData().blq() != 0) {
            this.jOt.Cb(Cd);
            return;
        }
        this.jOt.Cb(Cd);
        this.jOt.Ca(Cd);
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable() && this.jOt != null) {
            this.jOt.Wk();
            this.jOt.Cj(0);
            cME();
        }
    }

    public String cMI() {
        return this.eRa;
    }

    public String getTopicName() {
        return this.eCJ;
    }

    public void cMz() {
        f cMX;
        if (!y.isEmpty(this.mHotTopicDataList) && (cMX = this.mHotTopicDataList.get(0).cMX()) != null) {
            this.jOf.b(cMX.eRa, cMX.eCJ, null, cMX.jJp, cMX.shareTitle, true);
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
        if (cVar != null && cVar.bjZ() != null) {
            aq aqVar = new aq("c13021");
            aqVar.dR("tid", cVar.bjZ().getTid()).w("fid", cVar.bjZ().getFid()).dR("obj_source", cVar.bjZ().mRecomSource).dR("obj_locate", getFrom()).dR("obj_name", getTopicName()).dR(TiebaInitialize.Params.OBJ_PARAM3, n.coi()).dR("ab_tag", cVar.coE());
            t.cor().e(aqVar);
        }
    }

    public void t(com.baidu.tieba.card.data.c cVar) {
        if (cVar != null && cVar.bjZ() != null) {
            com.baidu.tieba.hottopic.b.b.a(cVar.bjZ(), getTopicName(), getFrom(), cVar.objType);
        }
    }

    private boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || at.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this).createNormalConfig("from_hottopic", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }
}

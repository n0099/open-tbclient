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
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.au;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.bf;
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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.GetMyPost.User_Info;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes15.dex */
public class HotTopicActivity extends BaseActivity<HotTopicActivity> implements BdListView.e, UserIconBox.b, HotRelateThreadModel.a, HotRelateThreadModel.b, HotTopicModel.a, a, FrsCommonImageLayout.c {
    private long dEQ;
    private com.baidu.adp.lib.d.b<TbImageView> elu;
    private long fid;
    private String firstDir;
    private b iIX;
    private BlessModel iJo;
    private LikeModel iJp;
    private com.baidu.adp.lib.d.b<TbImageView> iJq;
    private List<HotTopicBussinessData> mDataList;
    private List<e> mHotTopicDataList;
    private String secondDir;
    private com.baidu.tieba.hottopic.view.c iJl = null;
    private HotTopicModel iJm = null;
    private HotRelateThreadModel iJn = null;
    private String eeI = null;
    private String dQI = null;
    private String mFrom = "";
    private long lastResumeTime = 0;
    private int mIsGlobalBlock = 0;
    private boolean iJr = true;
    private AntiHelper.a hGU = new AntiHelper.a() { // from class: com.baidu.tieba.hottopic.controller.HotTopicActivity.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ah("obj_locate", aw.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ah("obj_locate", aw.a.LOCATE_LIKE_PERSON));
        }
    };
    private final com.baidu.adp.framework.listener.a hdf = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.hottopic.controller.HotTopicActivity.2
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
    private com.baidu.adp.base.d hiv = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.hottopic.controller.HotTopicActivity.3
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (!AntiHelper.bB(HotTopicActivity.this.iJp.getErrorCode(), HotTopicActivity.this.iJp.getErrorString())) {
                if (!StringUtils.isNull(HotTopicActivity.this.iJp.getErrorString())) {
                    l.showToast(TbadkCoreApplication.getInst(), HotTopicActivity.this.iJp.getErrorString());
                }
            } else if (AntiHelper.a(HotTopicActivity.this.getActivity(), HotTopicActivity.this.iJp.getErrorString(), HotTopicActivity.this.iJp.getErrorCode(), HotTopicActivity.this.hGU) != null) {
                TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ah("obj_locate", aw.a.LOCATE_LIKE_PERSON));
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
        } else if (this.iJl != null && x.getItem(this.mHotTopicDataList, this.iJl.getCurrentTab()) != null && this.iJl.cpC() != null) {
            e eVar = (e) x.getItem(this.mHotTopicDataList, this.iJl.getCurrentTab());
            ar arVar = new ar();
            ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
            User.Builder builder2 = new User.Builder(builder.author);
            a(builder2, getMyPostResIdl.data.user_info);
            builder.author = builder2.build(true);
            arVar.a(builder.build(true));
            eVar.aC(arVar);
            this.iJl.cpC().d(eVar);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        at(bundle);
        this.iJl = new com.baidu.tieba.hottopic.view.c(getPageContext(), this.eeI);
        this.iJm = new HotTopicModel(this);
        this.iJm.a(this);
        this.iJp = new LikeModel(getPageContext());
        this.iJp.setLoadDataCallBack(this.hiv);
        this.iJn = new HotRelateThreadModel(this);
        this.iJn.a((HotRelateThreadModel.a) this);
        this.iJn.a((HotRelateThreadModel.b) this);
        this.iIX = new b(this);
        this.iJo = new BlessModel(this);
        bCM();
        coK();
    }

    private void coK() {
        showLoadingView(this.iJl.cpv(), false);
        if (!j.isNetworkAvailableForImmediately()) {
            hideLoadingView(this.iJl.cpv());
            showNetRefreshView(this.iJl.cpv(), getResources().getString(R.string.neterror), true);
            setNetRefreshViewTopMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds530));
            this.iJl.yc(8);
            return;
        }
        this.iJl.yc(0);
        coM();
    }

    private void at(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.eeI = intent.getStringExtra("topic_id");
            this.dQI = intent.getStringExtra("topic_name");
            this.fid = intent.getLongExtra("topic_fid", 0L);
            this.firstDir = intent.getStringExtra("topic_first_dir");
            this.secondDir = intent.getStringExtra("topic_second_dir");
            this.mFrom = intent.getStringExtra("from");
            this.dEQ = intent.getLongExtra(IntentConfig.TOPIC_TID, 0L);
        } else if (bundle != null) {
            this.eeI = bundle.getString("topic_id");
            this.dQI = bundle.getString("topic_name");
            this.fid = bundle.getLong("topic_fid", 0L);
            this.firstDir = bundle.getString("topic_first_dir");
            this.secondDir = bundle.getString("topic_second_dir");
            this.mFrom = bundle.getString("from");
            this.mFrom = bundle.getString("from");
            this.dEQ = bundle.getLong(IntentConfig.TOPIC_TID, 0L);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onResume() {
        this.lastResumeTime = System.currentTimeMillis();
        super.onResume();
        if (this.iJl != null) {
            this.iJl.resume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(e eVar) {
        if (this.mDataList == null) {
            this.mDataList = new ArrayList();
        } else {
            this.mDataList.clear();
        }
        this.mDataList.add(new HotTopicBussinessData(0L, "", eVar.cpf().dQI, this.mIsGlobalBlock));
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
                            if (this.iJl != null && x.getItem(this.mDataList, this.iJl.getCurrentTab()) != null) {
                                j3 = com.baidu.adp.lib.f.b.toLong(String.valueOf(((HotTopicBussinessData) x.getItem(this.mDataList, this.iJl.getCurrentTab())).mForumId), 0L);
                            }
                            if (j != 0 && j2 != 0) {
                                int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                                int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                                float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                                int i3 = 1;
                                if (at.baS().baT()) {
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
                        this.iIX.a(coL(), intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L), this.mHotTopicDataList.get(0));
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHARE_FRIEND_FORUM /* 23007 */:
                    if (intent != null && !x.isEmpty(this.mHotTopicDataList)) {
                        this.iIX.a(coL(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra("name_show"), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT), this.mHotTopicDataList.get(0));
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
        TiebaStatic.log(new ap("c10817").dn("obj_duration", String.valueOf(System.currentTimeMillis() - this.lastResumeTime)));
        setRequestedOrientation(1);
        if (this.iJl != null) {
            this.iJl.pause();
        }
        super.onPause();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        s.bRL().bva();
        if (this.iJl != null) {
            this.iJl.destroy();
        }
        super.onDestroy();
    }

    public ShareFromTopicMsgData coL() {
        f cpf;
        if (!x.isEmpty(this.mHotTopicDataList) && (cpf = this.mHotTopicDataList.get(0).cpf()) != null) {
            StringBuilder sb = new StringBuilder();
            ShareFromTopicMsgData shareFromTopicMsgData = new ShareFromTopicMsgData();
            shareFromTopicMsgData.setContent(cpf.shareTitle);
            shareFromTopicMsgData.setImageUrl(cpf.iEh);
            shareFromTopicMsgData.setTitle(cpf.dQI);
            shareFromTopicMsgData.setHotTopicID(cpf.eeI);
            shareFromTopicMsgData.setHotTopicName(cpf.dQI);
            sb.append("http://tieba.baidu.com/").append("mo/q/hotMessage?topic_id=").append(cpf.eeI).append("&topic_name=").append(cpf.dQI);
            shareFromTopicMsgData.setLinkUrl(sb.toString());
            return shareFromTopicMsgData;
        }
        return null;
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iJl.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.hottopic.controller.HotTopicModel.a
    public void a(boolean z, e eVar) {
        hideLoadingView(this.iJl.cpv());
        if (this.iJl != null) {
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
            this.mIsGlobalBlock = eVar.cpp();
            if (eVar.cph() != null && eVar.cpi() != null) {
                this.iJl.a(8, true, 0L, 0);
            } else if (eVar.cph() != null) {
                this.iJl.a(0, true, eVar.cph().totalNum, eVar.cph().iJK);
            } else if (eVar.cpi() != null) {
                this.iJl.a(0, false, eVar.cpi().totalNum, eVar.cpi().iJK);
            }
            this.iJl.dn(this.mHotTopicDataList);
            this.iJl.c(eVar);
            this.iJl.cpx();
            a(eVar.sortType, eVar.getPageData());
        }
    }

    public void coM() {
        if (j.isNetWorkAvailable() && this.iJm != null) {
            this.iJm.a(this.eeI, this.dQI, getSortType(), this.fid, this.firstDir, this.secondDir, this.mFrom, this.dEQ);
        }
    }

    public void coN() {
        if (this.iJo != null && !x.isEmpty(this.mHotTopicDataList) && j.isNetWorkAvailable()) {
            com.baidu.tieba.hottopic.data.a cph = this.mHotTopicDataList.get(0).cph();
            com.baidu.tieba.hottopic.data.a cpi = this.mHotTopicDataList.get(0).cpi();
            if (cph != null) {
                this.iJo.a(cph.pkId, Long.parseLong(this.eeI), 1, 0, 1, cph.userPkId);
            } else if (cpi != null) {
                this.iJo.a(cpi.pkId, Long.parseLong(this.eeI), 1, 0, 1, cpi.userPkId);
            }
        }
    }

    public void coO() {
        i cpg;
        if (this.iJo != null && !x.isEmpty(this.mHotTopicDataList) && j.isNetWorkAvailable() && (cpg = this.mHotTopicDataList.get(0).cpg()) != null) {
            this.iJo.a(cpg.pkId, Long.parseLong(this.eeI), cpg.iJK, 0, 0, cpg.userPkId);
        }
    }

    private void bCM() {
        this.iJl.b(new View.OnTouchListener() { // from class: com.baidu.tieba.hottopic.controller.HotTopicActivity.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                e eVar;
                if (!bf.checkUpIsLogin(HotTopicActivity.this.getActivity()) || motionEvent.getAction() != 1 || (eVar = (e) x.getItem(HotTopicActivity.this.mHotTopicDataList, HotTopicActivity.this.iJl.getCurrentTab())) == null) {
                    return true;
                }
                if (!j.isNetWorkAvailable()) {
                    l.showToast(HotTopicActivity.this.getPageContext().getContext(), R.string.no_network_guide);
                }
                HotTopicActivity.this.b(eVar);
                WriteActivityConfig writeActivityConfig = new WriteActivityConfig(HotTopicActivity.this.getPageContext().getPageActivity(), 9, String.valueOf(0), "", null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0);
                writeActivityConfig.getIntent().putExtra("hot_topic_forum_list", (Serializable) HotTopicActivity.this.mDataList);
                writeActivityConfig.getIntent().putExtra(WriteActivityConfig.HOT_TOPIC_ID, HotTopicActivity.this.eeI);
                writeActivityConfig.setCallFrom("1");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                ap apVar = new ap(CommonStatisticKey.KEY_ENTRANCE_CLICKED);
                apVar.ah("obj_locate", 6).ah("obj_type", 1);
                TiebaStatic.log(apVar);
                return true;
            }
        });
        this.iJl.g(new NoNetworkView.a() { // from class: com.baidu.tieba.hottopic.controller.HotTopicActivity.5
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                HotTopicActivity.this.iJl.ps(!z);
                if (z && HotTopicActivity.this.iJm != null && x.getItem(HotTopicActivity.this.mHotTopicDataList, HotTopicActivity.this.iJl.getCurrentTab()) != null) {
                    e eVar = (e) HotTopicActivity.this.mHotTopicDataList.get(HotTopicActivity.this.iJl.getCurrentTab());
                    if (eVar == null || x.isEmpty(eVar.cpm())) {
                        HotTopicActivity.this.iJl.bwX();
                        HotTopicActivity.this.iJl.showLoadingView();
                        HotTopicActivity.this.coM();
                    }
                }
            }
        });
        this.hdf.getSocketMessageListener().setSelfListener(true);
        this.hdf.getHttpMessageListener().setSelfListener(true);
        registerListener(this.hdf);
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> caJ() {
        if (this.iJq == null) {
            this.iJq = FrsCommonImageLayout.B(getPageContext().getPageActivity(), 12);
        }
        return this.iJq;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> bcF() {
        if (this.elu == null) {
            this.elu = UserIconBox.t(getPageContext().getPageActivity(), 8);
        }
        return this.elu;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public ListView bcE() {
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.iJl == null || x.isEmpty(this.mHotTopicDataList) || !j.isNetWorkAvailable()) {
            coP();
            return;
        }
        e eVar = (e) x.getItem(this.mHotTopicDataList, this.iJl.getCurrentTab());
        if (eVar == null || eVar.getPageData() == null) {
            coP();
        } else if (eVar.iKl && this.iJr) {
            this.iJn.b(eVar, getSortType());
            this.iJr = false;
        }
    }

    public int getSortType() {
        return this.iJl.getCurrentTab() == 0 ? 1 : 0;
    }

    public int xW(int i) {
        return i == 1 ? 0 : 1;
    }

    @Override // com.baidu.tieba.hottopic.controller.HotRelateThreadModel.a
    public void complete() {
        this.iJr = true;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (!StringUtils.isNull(this.dQI) || !StringUtils.isNull(this.eeI)) {
            bundle.putString("topic_id", this.eeI);
            bundle.putString("topic_name", this.dQI);
        }
    }

    @Override // com.baidu.tieba.hottopic.controller.HotRelateThreadModel.b
    public void a(boolean z, com.baidu.tieba.hottopic.data.d dVar, int i) {
        if (!z || dVar == null || x.isEmpty(this.mHotTopicDataList) || x.getCount(dVar.eZc) == 0) {
            this.iJl.xU(xW(i));
            return;
        }
        e eVar = (e) x.getItem(this.mHotTopicDataList, xW(i));
        if (eVar == null) {
            this.iJl.xU(xW(i));
            return;
        }
        eVar.a(dVar);
        this.iJl.dn(this.mHotTopicDataList);
        a(i, dVar.pageData);
    }

    private void a(int i, au auVar) {
        if (auVar != null) {
            int xW = xW(i);
            e eVar = (e) x.getItem(this.mHotTopicDataList, xW);
            if (eVar != null) {
                eVar.a(auVar);
            }
            if (auVar.aVb() != 0) {
                this.iJl.xS(xW);
                return;
            }
            this.iJl.xU(xW);
            this.iJl.xT(xW);
        }
    }

    private void coP() {
        int xW = xW(getSortType());
        e eVar = (e) x.getItem(this.mHotTopicDataList, xW);
        if (eVar == null || eVar.getPageData() == null) {
            this.iJl.xU(xW);
            return;
        }
        if (eVar.getPageData().aVb() != 0) {
            this.iJl.xU(xW);
            return;
        }
        this.iJl.xU(xW);
        this.iJl.xT(xW);
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable() && this.iJl != null) {
            this.iJl.bwX();
            this.iJl.yc(0);
            coM();
        }
    }

    public String coQ() {
        return this.eeI;
    }

    public String getTopicName() {
        return this.dQI;
    }

    public void coH() {
        f cpf;
        if (!x.isEmpty(this.mHotTopicDataList) && (cpf = this.mHotTopicDataList.get(0).cpf()) != null) {
            this.iIX.b(cpf.eeI, cpf.dQI, null, cpf.iEh, cpf.shareTitle, true);
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
        if (cVar != null && cVar.aTN() != null) {
            ap apVar = new ap("c13021");
            apVar.dn("tid", cVar.aTN().getTid()).t("fid", cVar.aTN().getFid()).dn("obj_source", cVar.aTN().mRecomSource).dn("obj_locate", getFrom()).dn("obj_name", getTopicName()).dn(TiebaInitialize.Params.OBJ_PARAM3, m.bRC()).dn("ab_tag", cVar.bRY());
            s.bRL().e(apVar);
        }
    }

    public void t(com.baidu.tieba.card.data.c cVar) {
        if (cVar != null && cVar.aTN() != null) {
            com.baidu.tieba.hottopic.b.b.a(cVar.aTN(), getTopicName(), getFrom(), cVar.objType);
        }
    }

    private boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || as.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this).createNormalConfig("from_hottopic", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }
}

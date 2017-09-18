package com.baidu.tieba.homepage.framework;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.h;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.tbadk.mvc.model.CacheModel;
import com.baidu.tbadk.util.c;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.homepage.concern.c;
import com.baidu.tieba.homepage.framework.c;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.myCollection.baseHistory.PbHistoryCacheModel;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class RecommendFrsControlFragment extends BaseFragment {
    private com.baidu.tbadk.i.a cqp;
    private ScrollFragmentTabHost daC;
    private c daD;
    private com.baidu.tieba.homepage.personalize.a.a daE;
    private boolean daG;
    private boolean daH;
    private boolean daK;
    private Boolean daF = null;
    private NoNetworkView.a bPi = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aM(boolean z) {
            if (z && RecommendFrsControlFragment.this.isPrimary()) {
                RecommendFrsControlFragment.this.daC.aqF();
            }
        }
    };
    private CustomMessageTask daI = new CustomMessageTask(CmdConfigCustom.CMD_GET_MAINTAB_FORUM_INFO, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.8
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<ForumWriteData> run(CustomMessage<Object> customMessage) {
            ah currentFragment = RecommendFrsControlFragment.this.daC.getCurrentFragment();
            if (currentFragment == null || !RecommendFrsControlFragment.this.isPrimary()) {
                return null;
            }
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_MAINTAB_FORUM_INFO, currentFragment.ahv());
        }
    });
    private CustomMessageListener daJ = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    int intValue = ((Integer) data).intValue();
                    if (intValue == 0 && RecommendFrsControlFragment.this.daC != null) {
                        boolean isPrimary = RecommendFrsControlFragment.this.isPrimary();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        if (RecommendFrsControlFragment.this.daC.getCurrentTabType() == 0) {
                            boolean aqG = RecommendFrsControlFragment.this.daC.aqG();
                            if (!isPrimary) {
                                TiebaStatic.log(new ak("c12350").r("obj_type", aqG ? 1 : 0));
                            }
                            if (aqG && !isPrimary) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                                RecommendFrsControlFragment.this.daC.aqF();
                            }
                        }
                        if (isPrimary) {
                            RecommendFrsControlFragment.this.daG = true;
                            RecommendFrsControlFragment.this.daC.aqF();
                        }
                    }
                    if (intValue == 0) {
                        if (RecommendFrsControlFragment.this.isPrimary()) {
                            RecommendFrsControlFragment.this.daG = true;
                            RecommendFrsControlFragment.this.daC.aqF();
                        } else if (!RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.daC.getCurrentIndex() == 1) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ENTER_LEAVE_DISCOVER_PAGE, true));
                        }
                    } else if (RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.daC.getCurrentIndex() == 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ENTER_LEAVE_DISCOVER_PAGE, false));
                    }
                }
            }
        }
    };
    private CustomMessageListener daL = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean data;
            if ((customResponsedMessage instanceof BackgroundSwitchMessage) && (data = ((BackgroundSwitchMessage) customResponsedMessage).getData()) != null) {
                if (data.booleanValue()) {
                    RecommendFrsControlFragment.this.daK = false;
                } else if (TbadkCoreApplication.isLogin() && !RecommendFrsControlFragment.this.daK) {
                    RecommendFrsControlFragment.this.daD.aqw();
                }
            }
        }
    };
    private CustomMessageListener daM = new CustomMessageListener(CmdConfigCustom.MAINTAB_CHANGE_SUB_TAB) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            Integer num;
            String str;
            boolean z;
            boolean z2 = false;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null) {
                Integer num2 = -1;
                if (data instanceof Integer) {
                    num = (Integer) data;
                } else if (data instanceof String) {
                    String str2 = (String) data;
                    List<com.baidu.tieba.homepage.b.a.a> tagList = RecommendFrsControlFragment.this.daC.getTagList();
                    int u = v.u(tagList);
                    int i = 0;
                    while (true) {
                        if (i < u) {
                            if (!str2.equals(tagList.get(i).deN)) {
                                i++;
                            } else {
                                num = Integer.valueOf(i);
                                z = true;
                                break;
                            }
                        } else {
                            num = num2;
                            z = false;
                            break;
                        }
                    }
                    z2 = z;
                } else {
                    if (data instanceof Boolean) {
                        ArrayList arrayList = new ArrayList();
                        com.baidu.tieba.homepage.b.a.a aVar = new com.baidu.tieba.homepage.b.a.a();
                        aVar.deN = "推荐";
                        aVar.deO = -1L;
                        aVar.isSelected = false;
                        arrayList.add(aVar);
                        com.baidu.tieba.homepage.b.a.a aVar2 = new com.baidu.tieba.homepage.b.a.a();
                        aVar2.deN = "发现";
                        aVar2.deO = -2L;
                        aVar2.isSelected = false;
                        arrayList.add(aVar2);
                        c.a[] GZ = com.baidu.tbadk.util.c.GZ();
                        com.baidu.tieba.homepage.b.a.a aVar3 = (com.baidu.tieba.homepage.b.a.a) v.c(RecommendFrsControlFragment.this.daC.getTagList(), com.baidu.tieba.homepage.framework.a.a.aqM().dbN);
                        if (aVar3 == null) {
                            str = null;
                        } else {
                            str = aVar3.deN;
                        }
                        int length = GZ.length;
                        for (int i2 = 0; i2 < length; i2++) {
                            String str3 = GZ[i2].forumName;
                            int i3 = GZ[i2].level;
                            com.baidu.tieba.homepage.b.a.a aVar4 = new com.baidu.tieba.homepage.b.a.a();
                            aVar4.deN = str3;
                            aVar4.isSelected = false;
                            aVar4.level = i3;
                            arrayList.add(aVar4);
                            if (str3.equals(str)) {
                                num2 = Integer.valueOf(i2 + 1);
                            }
                        }
                        if (!((Boolean) data).booleanValue() && num2.intValue() == -1) {
                            num2 = Integer.valueOf(com.baidu.tieba.homepage.framework.a.a.aqM().dbN - 1);
                        }
                        RecommendFrsControlFragment.this.bx(arrayList);
                    }
                    num = num2;
                }
                RecommendFrsControlFragment.this.daC.r(num.intValue(), z2);
            }
        }
    };
    private CustomMessageListener daN = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM_NAME) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                ArrayList<com.baidu.tieba.homepage.b.a.a> arrayList = new ArrayList();
                if (!v.v(RecommendFrsControlFragment.this.daC.getTagList())) {
                    arrayList.addAll(RecommendFrsControlFragment.this.daC.getTagList());
                }
                com.baidu.tieba.homepage.b.a.a aVar2 = new com.baidu.tieba.homepage.b.a.a();
                aVar2.deN = aVar.forumName;
                aVar2.isSelected = false;
                aVar2.level = aVar.level;
                arrayList.add(aVar2);
                ArrayList arrayList2 = new ArrayList();
                for (com.baidu.tieba.homepage.b.a.a aVar3 : arrayList) {
                    if (aVar3 != null && !StringUtils.isNull(aVar3.deN) && aVar3.deO != -1 && aVar3.deO != -2) {
                        arrayList2.add(new c.a(aVar3.deN, aVar3.level));
                    }
                }
                com.baidu.tbadk.util.c.H(arrayList2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_CHANGE_SUB_TAB, true));
            }
        }
    };
    private CustomMessageListener daO = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            int i;
            boolean z;
            String str = null;
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null) {
                String str2 = data instanceof String ? (String) data : null;
                if (!StringUtils.isNull(str2)) {
                    ArrayList<com.baidu.tieba.homepage.b.a.a> arrayList = new ArrayList();
                    if (!v.v(RecommendFrsControlFragment.this.daC.getTagList())) {
                        arrayList.addAll(RecommendFrsControlFragment.this.daC.getTagList());
                        int i2 = com.baidu.tieba.homepage.framework.a.a.aqM().dbN;
                        int size = arrayList.size();
                        int i3 = 0;
                        while (true) {
                            if (i3 >= size) {
                                i = i2;
                                z = false;
                                break;
                            }
                            com.baidu.tieba.homepage.b.a.a aVar = (com.baidu.tieba.homepage.b.a.a) arrayList.get(i3);
                            String str3 = aVar != null ? aVar.deN : str;
                            if (!str2.equals(str3)) {
                                i3++;
                                str = str3;
                            } else {
                                z = true;
                                i = i3;
                                break;
                            }
                        }
                        if (z) {
                            arrayList.remove(i);
                        }
                        ArrayList arrayList2 = new ArrayList();
                        for (com.baidu.tieba.homepage.b.a.a aVar2 : arrayList) {
                            if (aVar2 != null && !StringUtils.isNull(aVar2.deN) && aVar2.deO != -1 && aVar2.deO != -2) {
                                arrayList2.add(new c.a(aVar2.deN, aVar2.level));
                            }
                        }
                        com.baidu.tbadk.util.c.H(arrayList2);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_CHANGE_SUB_TAB, false));
                    }
                }
            }
        }
    };
    private final CustomMessageListener cqL = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData)) {
                SignData signData = (SignData) customResponsedMessage.getData();
                if (!StringUtils.isNull(signData.forumName)) {
                    RecommendFrsControlFragment.this.daC.O(signData.forumName, TbadkCoreApplication.getInst().getSignLevelUpValue(signData.forumName));
                }
            }
        }
    };
    private final CustomMessageListener daP = new CustomMessageListener(CmdConfigCustom.CMD_FRS_UPDATE_USER_LEVEL) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof be)) {
                be beVar = (be) customResponsedMessage.getData();
                RecommendFrsControlFragment.this.daC.O(beVar.getForumName(), beVar.qW());
            }
        }
    };
    private b daQ = new b() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.2
        @Override // com.baidu.tieba.homepage.framework.b
        public void aH(int i, int i2) {
            RecommendFrsControlFragment.this.daD.b(1, i, 1, i2, RecommendFrsControlFragment.this.daG ? 0 : TbadkCoreApplication.isLogin() ? 1 : 0);
            RecommendFrsControlFragment.this.daG = false;
            if (i.gW()) {
                TiebaStatic.log(new ak("c11032").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void u(int i, int i2, int i3) {
            RecommendFrsControlFragment.this.daD.b(2, i2, i, i3, 0);
            if (i.gW()) {
                TiebaStatic.log(new ak("c11032").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void k(List<com.baidu.tieba.homepage.b.a.a> list, boolean z) {
            if (!TbadkCoreApplication.isLogin() || z) {
                RecommendFrsControlFragment.this.bx(list);
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void aqy() {
        }
    };
    private c.a daR = new c.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.3
        @Override // com.baidu.tieba.homepage.concern.c.a
        public void onPullToRefresh() {
            RecommendFrsControlFragment.this.daD.lM("");
        }

        @Override // com.baidu.tieba.homepage.concern.c.a
        public void lL(String str) {
            RecommendFrsControlFragment.this.daD.lM(str);
        }

        @Override // com.baidu.tieba.homepage.concern.c.a
        public void x(boolean z, boolean z2) {
            if (z) {
                if (RecommendFrsControlFragment.this.daH) {
                    RecommendFrsControlFragment.this.daC.setShowConcernRedTip(true);
                    if (!RecommendFrsControlFragment.this.isPrimary()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 1));
                    }
                } else {
                    RecommendFrsControlFragment.this.daC.setShowConcernRedTip(false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                }
            } else if (z2) {
                RecommendFrsControlFragment.this.daD.aqw();
            }
            RecommendFrsControlFragment.this.daH = false;
        }
    };
    private CustomMessageListener daS = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().BW && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    RecommendFrsControlFragment.this.a(updateAttentionMessage);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class ControlModelMessage extends CustomMessage<c> {
        public ControlModelMessage(c cVar) {
            super(CmdConfigCustom.CMD_RECOMMEND_FRS_INIT_CONTROL_MODEL);
            setData(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UpdateAttentionMessage updateAttentionMessage) {
        Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.isAttention() && updateAttentionMessage.isGod() && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(getUniqueId())) {
            if (this.cqp == null) {
                this.cqp = new com.baidu.tbadk.i.a(getPageContext());
            }
            this.cqp.aq(updateAttentionMessage.getData().toUid, null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.j.recommend_frs_control, (ViewGroup) null);
        inflate.setDrawingCacheEnabled(false);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "c10702", "click");
            if (this.daC != null && this.daC.aqI()) {
                this.daC.aqi();
                this.daH = true;
                if (TbadkCoreApplication.isLogin() && this.daD != null) {
                    this.daK = true;
                }
            }
        } else {
            VoiceManager cb = com.baidu.tieba.tbadkCore.voice.b.cb(getActivity());
            if (cb != null) {
                cb.stopPlay();
            }
        }
        if (this.daC != null) {
            this.daC.setPrimary(isPrimary());
            this.daC.aqK();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        this.daC.notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        bj();
        this.daC = (ScrollFragmentTabHost) getView().findViewById(d.h.recommend_frs_tab_host);
        this.daC.a(getPageContext(), this.bPi);
        this.daC.a(getChildFragmentManager(), this.daQ, this.daR);
        this.daC.setPageUniqueId(getUniqueId());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        a.aqx().setCreateTime(System.currentTimeMillis() - a.aqx().kS(1));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a.aqx().c(System.currentTimeMillis(), 1);
        registerListener(this.daJ);
        registerListener(this.daM);
        registerListener(this.daN);
        registerListener(this.daO);
        registerListener(this.daS);
        registerListener(this.cqL);
        registerListener(this.daP);
        registerListener(this.daL);
        this.daI.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.daI);
        aqz();
        this.daE = new com.baidu.tieba.homepage.personalize.a.a();
    }

    private void aqz() {
        PbHistoryCacheModel pbHistoryCacheModel = new PbHistoryCacheModel(getPageContext());
        pbHistoryCacheModel.setUniqueId(getUniqueId());
        pbHistoryCacheModel.a(new CacheModel.a<com.baidu.tieba.myCollection.baseHistory.a>() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.5
            @Override // com.baidu.tbadk.mvc.model.CacheModel.a
            public void a(ReadCacheRespMsg<List<com.baidu.tieba.myCollection.baseHistory.a>> readCacheRespMsg, ReadCacheMessage<com.baidu.tieba.myCollection.baseHistory.a> readCacheMessage) {
                if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && (readCacheRespMsg.getData() instanceof List)) {
                    com.baidu.tieba.tbadkCore.util.c godFeedReadHistory = TbadkCoreApplication.getInst().getGodFeedReadHistory();
                    for (com.baidu.tieba.myCollection.baseHistory.a aVar : readCacheRespMsg.getData()) {
                        if (aVar != null && !StringUtils.isNull(aVar.getThreadId()) && godFeedReadHistory != null) {
                            godFeedReadHistory.a(aVar.getThreadId(), aVar);
                        }
                    }
                }
            }

            @Override // com.baidu.tbadk.mvc.model.CacheModel.a
            public void a(WriteCacheRespMsg<List<com.baidu.tieba.myCollection.baseHistory.a>> writeCacheRespMsg, WriteCacheMessage<com.baidu.tieba.myCollection.baseHistory.a> writeCacheMessage) {
            }
        });
        pbHistoryCacheModel.Fh();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.homepage.framework.a.a.aqM().onDestory();
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_MAINTAB_FORUM_INFO);
        if (this.cqp != null) {
            this.cqp.destory();
        }
        if (this.daE != null) {
            this.daE.onDestroy();
        }
        this.daC.onDestroy();
    }

    private void bj() {
        com.baidu.tieba.homepage.framework.a.a.aqM().o(getUniqueId());
        this.daD = new c(getPageContext(), getUniqueId());
        this.daD.a(new c.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.6
            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3) {
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(String str, String str2, int i, boolean z, int i2) {
                if (RecommendFrsControlFragment.this.daC.aqJ()) {
                    RecommendFrsControlFragment.this.daC.h(str2, i, i2);
                }
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(DataRes dataRes, boolean z, boolean z2) {
                RecommendFrsControlFragment.this.daC.c(dataRes, z, z2);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void c(tbclient.Userlike.DataRes dataRes, boolean z) {
                RecommendFrsControlFragment.this.daC.d(dataRes, z);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void fQ(boolean z) {
                if (RecommendFrsControlFragment.this.daC != null) {
                    RecommendFrsControlFragment.this.daC.setShowConcernRedTip(z);
                    if (!RecommendFrsControlFragment.this.isPrimary() || !z) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, Integer.valueOf(z ? 1 : 0)));
                    }
                }
            }
        });
        MessageManager.getInstance().sendMessage(new ControlModelMessage(this.daD));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bx(List<com.baidu.tieba.homepage.b.a.a> list) {
        if (v.u(list) > 1) {
            ArrayList arrayList = new ArrayList();
            if (!TbadkCoreApplication.isLogin() || !TbadkCoreApplication.getInst().appResponseToIntentClass(FrsActivityConfig.class)) {
                arrayList.add(list.get(0));
                arrayList.add(list.get(1));
            } else {
                arrayList.addAll(list);
            }
            if (this.daC != null && !this.daC.bA(arrayList)) {
                this.daC.bz(arrayList);
                this.daC.r(0, false);
                this.daC.aqL();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new ReadCacheRespMsg(CmdConfigCustom.CMD_UPDATE_LIKE_FORUMS_IN_HOME_RECOMMEND, list));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.daC != null) {
            this.daC.onChangeSkinType(i);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 18003:
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR, stringExtra));
                        if (intent.getIntExtra("type", -1) == 4 && isPrimary()) {
                            this.daC.aqF();
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.daC != null) {
            this.daC.setPrimary(isPrimary());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.daF == null) {
            this.daF = Boolean.valueOf(h.oS().oY());
        } else {
            r0 = this.daF.booleanValue() != h.oS().oY();
            this.daF = Boolean.valueOf(h.oS().oY());
        }
        if (r0) {
            this.daC.aqh();
        }
        if (this.daC != null) {
            this.daC.setPrimary(isPrimary());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new com.baidu.tbadk.pageStayDuration.b() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.7
            @Override // com.baidu.tbadk.pageStayDuration.b
            public boolean FM() {
                return false;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int FN() {
                return com.baidu.tbadk.pageStayDuration.e.FS().FU();
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public boolean a(com.baidu.tbadk.pageStayDuration.d dVar) {
                return false;
            }
        };
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.daC != null) {
            return this.daC.getCurrentPageKey();
        }
        return null;
    }
}

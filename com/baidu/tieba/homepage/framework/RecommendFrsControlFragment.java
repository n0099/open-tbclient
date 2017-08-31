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
    private ScrollFragmentTabHost cZG;
    private c cZH;
    private com.baidu.tieba.homepage.personalize.a.a cZI;
    private boolean cZK;
    private boolean cZL;
    private boolean cZO;
    private com.baidu.tbadk.i.a cpx;
    private Boolean cZJ = null;
    private NoNetworkView.a bOr = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aM(boolean z) {
            if (z && RecommendFrsControlFragment.this.isPrimary()) {
                RecommendFrsControlFragment.this.cZG.aqu();
            }
        }
    };
    private CustomMessageTask cZM = new CustomMessageTask(CmdConfigCustom.CMD_GET_MAINTAB_FORUM_INFO, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.8
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<ForumWriteData> run(CustomMessage<Object> customMessage) {
            ah currentFragment = RecommendFrsControlFragment.this.cZG.getCurrentFragment();
            if (currentFragment == null || !RecommendFrsControlFragment.this.isPrimary()) {
                return null;
            }
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_MAINTAB_FORUM_INFO, currentFragment.ahk());
        }
    });
    private CustomMessageListener cZN = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    int intValue = ((Integer) data).intValue();
                    if (intValue == 0 && RecommendFrsControlFragment.this.cZG != null) {
                        boolean isPrimary = RecommendFrsControlFragment.this.isPrimary();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        if (RecommendFrsControlFragment.this.cZG.getCurrentTabType() == 0) {
                            boolean aqv = RecommendFrsControlFragment.this.cZG.aqv();
                            if (!isPrimary) {
                                TiebaStatic.log(new ak("c12350").r("obj_type", aqv ? 1 : 0));
                            }
                            if (aqv && !isPrimary) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                                RecommendFrsControlFragment.this.cZG.aqu();
                            }
                        }
                        if (isPrimary) {
                            RecommendFrsControlFragment.this.cZK = true;
                            RecommendFrsControlFragment.this.cZG.aqu();
                        }
                    }
                    if (intValue == 0) {
                        if (RecommendFrsControlFragment.this.isPrimary()) {
                            RecommendFrsControlFragment.this.cZK = true;
                            RecommendFrsControlFragment.this.cZG.aqu();
                        } else if (!RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.cZG.getCurrentIndex() == 1) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ENTER_LEAVE_DISCOVER_PAGE, true));
                        }
                    } else if (RecommendFrsControlFragment.this.isPrimary() && RecommendFrsControlFragment.this.cZG.getCurrentIndex() == 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ENTER_LEAVE_DISCOVER_PAGE, false));
                    }
                }
            }
        }
    };
    private CustomMessageListener cZP = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean data;
            if ((customResponsedMessage instanceof BackgroundSwitchMessage) && (data = ((BackgroundSwitchMessage) customResponsedMessage).getData()) != null) {
                if (data.booleanValue()) {
                    RecommendFrsControlFragment.this.cZO = false;
                } else if (TbadkCoreApplication.isLogin() && !RecommendFrsControlFragment.this.cZO) {
                    RecommendFrsControlFragment.this.cZH.aql();
                }
            }
        }
    };
    private CustomMessageListener cZQ = new CustomMessageListener(CmdConfigCustom.MAINTAB_CHANGE_SUB_TAB) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.11
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
                    List<com.baidu.tieba.homepage.b.a.a> tagList = RecommendFrsControlFragment.this.cZG.getTagList();
                    int u = v.u(tagList);
                    int i = 0;
                    while (true) {
                        if (i < u) {
                            if (!str2.equals(tagList.get(i).ddR)) {
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
                        aVar.ddR = "推荐";
                        aVar.ddS = -1L;
                        aVar.isSelected = false;
                        arrayList.add(aVar);
                        com.baidu.tieba.homepage.b.a.a aVar2 = new com.baidu.tieba.homepage.b.a.a();
                        aVar2.ddR = "发现";
                        aVar2.ddS = -2L;
                        aVar2.isSelected = false;
                        arrayList.add(aVar2);
                        c.a[] GZ = com.baidu.tbadk.util.c.GZ();
                        com.baidu.tieba.homepage.b.a.a aVar3 = (com.baidu.tieba.homepage.b.a.a) v.c(RecommendFrsControlFragment.this.cZG.getTagList(), com.baidu.tieba.homepage.framework.a.a.aqB().daT);
                        if (aVar3 == null) {
                            str = null;
                        } else {
                            str = aVar3.ddR;
                        }
                        int length = GZ.length;
                        for (int i2 = 0; i2 < length; i2++) {
                            String str3 = GZ[i2].forumName;
                            int i3 = GZ[i2].level;
                            com.baidu.tieba.homepage.b.a.a aVar4 = new com.baidu.tieba.homepage.b.a.a();
                            aVar4.ddR = str3;
                            aVar4.isSelected = false;
                            aVar4.level = i3;
                            arrayList.add(aVar4);
                            if (str3.equals(str)) {
                                num2 = Integer.valueOf(i2 + 1);
                            }
                        }
                        if (!((Boolean) data).booleanValue() && num2.intValue() == -1) {
                            num2 = Integer.valueOf(com.baidu.tieba.homepage.framework.a.a.aqB().daT - 1);
                        }
                        RecommendFrsControlFragment.this.bw(arrayList);
                    }
                    num = num2;
                }
                RecommendFrsControlFragment.this.cZG.r(num.intValue(), z2);
            }
        }
    };
    private CustomMessageListener cZR = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM_NAME) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                ArrayList<com.baidu.tieba.homepage.b.a.a> arrayList = new ArrayList();
                if (!v.v(RecommendFrsControlFragment.this.cZG.getTagList())) {
                    arrayList.addAll(RecommendFrsControlFragment.this.cZG.getTagList());
                }
                com.baidu.tieba.homepage.b.a.a aVar2 = new com.baidu.tieba.homepage.b.a.a();
                aVar2.ddR = aVar.forumName;
                aVar2.isSelected = false;
                aVar2.level = aVar.level;
                arrayList.add(aVar2);
                ArrayList arrayList2 = new ArrayList();
                for (com.baidu.tieba.homepage.b.a.a aVar3 : arrayList) {
                    if (aVar3 != null && !StringUtils.isNull(aVar3.ddR) && aVar3.ddS != -1 && aVar3.ddS != -2) {
                        arrayList2.add(new c.a(aVar3.ddR, aVar3.level));
                    }
                }
                com.baidu.tbadk.util.c.H(arrayList2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_CHANGE_SUB_TAB, true));
            }
        }
    };
    private CustomMessageListener cZS = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.13
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
                    if (!v.v(RecommendFrsControlFragment.this.cZG.getTagList())) {
                        arrayList.addAll(RecommendFrsControlFragment.this.cZG.getTagList());
                        int i2 = com.baidu.tieba.homepage.framework.a.a.aqB().daT;
                        int size = arrayList.size();
                        int i3 = 0;
                        while (true) {
                            if (i3 >= size) {
                                i = i2;
                                z = false;
                                break;
                            }
                            com.baidu.tieba.homepage.b.a.a aVar = (com.baidu.tieba.homepage.b.a.a) arrayList.get(i3);
                            String str3 = aVar != null ? aVar.ddR : str;
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
                            if (aVar2 != null && !StringUtils.isNull(aVar2.ddR) && aVar2.ddS != -1 && aVar2.ddS != -2) {
                                arrayList2.add(new c.a(aVar2.ddR, aVar2.level));
                            }
                        }
                        com.baidu.tbadk.util.c.H(arrayList2);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_CHANGE_SUB_TAB, false));
                    }
                }
            }
        }
    };
    private final CustomMessageListener cpT = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData)) {
                SignData signData = (SignData) customResponsedMessage.getData();
                if (!StringUtils.isNull(signData.forumName)) {
                    RecommendFrsControlFragment.this.cZG.O(signData.forumName, TbadkCoreApplication.getInst().getSignLevelUpValue(signData.forumName));
                }
            }
        }
    };
    private final CustomMessageListener cZT = new CustomMessageListener(CmdConfigCustom.CMD_FRS_UPDATE_USER_LEVEL) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof be)) {
                be beVar = (be) customResponsedMessage.getData();
                RecommendFrsControlFragment.this.cZG.O(beVar.getForumName(), beVar.qW());
            }
        }
    };
    private b cZU = new b() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.2
        @Override // com.baidu.tieba.homepage.framework.b
        public void aD(int i, int i2) {
            RecommendFrsControlFragment.this.cZH.b(1, i, 1, i2, RecommendFrsControlFragment.this.cZK ? 0 : TbadkCoreApplication.isLogin() ? 1 : 0);
            RecommendFrsControlFragment.this.cZK = false;
            if (i.gW()) {
                TiebaStatic.log(new ak("c11032").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void u(int i, int i2, int i3) {
            RecommendFrsControlFragment.this.cZH.b(2, i2, i, i3, 0);
            if (i.gW()) {
                TiebaStatic.log(new ak("c11032").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void k(List<com.baidu.tieba.homepage.b.a.a> list, boolean z) {
            if (!TbadkCoreApplication.isLogin() || z) {
                RecommendFrsControlFragment.this.bw(list);
            }
        }

        @Override // com.baidu.tieba.homepage.framework.b
        public void aqn() {
        }
    };
    private c.a cZV = new c.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.3
        @Override // com.baidu.tieba.homepage.concern.c.a
        public void onPullToRefresh() {
            RecommendFrsControlFragment.this.cZH.lK("");
        }

        @Override // com.baidu.tieba.homepage.concern.c.a
        public void lJ(String str) {
            RecommendFrsControlFragment.this.cZH.lK(str);
        }

        @Override // com.baidu.tieba.homepage.concern.c.a
        public void x(boolean z, boolean z2) {
            if (z) {
                if (RecommendFrsControlFragment.this.cZL) {
                    RecommendFrsControlFragment.this.cZG.setShowConcernRedTip(true);
                    if (!RecommendFrsControlFragment.this.isPrimary()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 1));
                    }
                } else {
                    RecommendFrsControlFragment.this.cZG.setShowConcernRedTip(false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                }
            } else if (z2) {
                RecommendFrsControlFragment.this.cZH.aql();
            }
            RecommendFrsControlFragment.this.cZL = false;
        }
    };
    private CustomMessageListener cZW = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.4
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
            if (this.cpx == null) {
                this.cpx = new com.baidu.tbadk.i.a(getPageContext());
            }
            this.cpx.aq(updateAttentionMessage.getData().toUid, null);
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
            if (this.cZG != null && this.cZG.aqx()) {
                this.cZG.apX();
                this.cZL = true;
                if (TbadkCoreApplication.isLogin() && this.cZH != null) {
                    this.cZO = true;
                }
            }
        } else {
            VoiceManager ca = com.baidu.tieba.tbadkCore.voice.b.ca(getActivity());
            if (ca != null) {
                ca.stopPlay();
            }
        }
        if (this.cZG != null) {
            this.cZG.setPrimary(isPrimary());
            this.cZG.aqz();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        this.cZG.notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        bj();
        this.cZG = (ScrollFragmentTabHost) getView().findViewById(d.h.recommend_frs_tab_host);
        this.cZG.a(getPageContext(), this.bOr);
        this.cZG.a(getChildFragmentManager(), this.cZU, this.cZV);
        this.cZG.setPageUniqueId(getUniqueId());
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        a.aqm().setCreateTime(System.currentTimeMillis() - a.aqm().kQ(1));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a.aqm().c(System.currentTimeMillis(), 1);
        registerListener(this.cZN);
        registerListener(this.cZQ);
        registerListener(this.cZR);
        registerListener(this.cZS);
        registerListener(this.cZW);
        registerListener(this.cpT);
        registerListener(this.cZT);
        registerListener(this.cZP);
        this.cZM.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.cZM);
        aqo();
        this.cZI = new com.baidu.tieba.homepage.personalize.a.a();
    }

    private void aqo() {
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
        com.baidu.tieba.homepage.framework.a.a.aqB().onDestory();
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_MAINTAB_FORUM_INFO);
        if (this.cpx != null) {
            this.cpx.destory();
        }
        if (this.cZI != null) {
            this.cZI.onDestroy();
        }
        this.cZG.onDestroy();
    }

    private void bj() {
        com.baidu.tieba.homepage.framework.a.a.aqB().o(getUniqueId());
        this.cZH = new c(getPageContext(), getUniqueId());
        this.cZH.a(new c.a() { // from class: com.baidu.tieba.homepage.framework.RecommendFrsControlFragment.6
            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3) {
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(String str, String str2, int i, boolean z, int i2) {
                if (RecommendFrsControlFragment.this.cZG.aqy()) {
                    RecommendFrsControlFragment.this.cZG.h(str2, i, i2);
                }
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void a(DataRes dataRes, boolean z, boolean z2) {
                RecommendFrsControlFragment.this.cZG.c(dataRes, z, z2);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void c(tbclient.Userlike.DataRes dataRes, boolean z) {
                RecommendFrsControlFragment.this.cZG.d(dataRes, z);
            }

            @Override // com.baidu.tieba.homepage.framework.c.a
            public void fP(boolean z) {
                if (RecommendFrsControlFragment.this.cZG != null) {
                    RecommendFrsControlFragment.this.cZG.setShowConcernRedTip(z);
                    if (!RecommendFrsControlFragment.this.isPrimary() || !z) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, Integer.valueOf(z ? 1 : 0)));
                    }
                }
            }
        });
        MessageManager.getInstance().sendMessage(new ControlModelMessage(this.cZH));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bw(List<com.baidu.tieba.homepage.b.a.a> list) {
        if (v.u(list) > 1) {
            ArrayList arrayList = new ArrayList();
            if (!TbadkCoreApplication.isLogin() || !TbadkCoreApplication.getInst().appResponseToIntentClass(FrsActivityConfig.class)) {
                arrayList.add(list.get(0));
                arrayList.add(list.get(1));
            } else {
                arrayList.addAll(list);
            }
            if (this.cZG != null && !this.cZG.bz(arrayList)) {
                this.cZG.by(arrayList);
                this.cZG.r(0, false);
                this.cZG.aqA();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new ReadCacheRespMsg(CmdConfigCustom.CMD_UPDATE_LIKE_FORUMS_IN_HOME_RECOMMEND, list));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cZG != null) {
            this.cZG.onChangeSkinType(i);
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
                            this.cZG.aqu();
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
        if (this.cZG != null) {
            this.cZG.setPrimary(isPrimary());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.cZJ == null) {
            this.cZJ = Boolean.valueOf(h.oS().oY());
        } else {
            r0 = this.cZJ.booleanValue() != h.oS().oY();
            this.cZJ = Boolean.valueOf(h.oS().oY());
        }
        if (r0) {
            this.cZG.apW();
        }
        if (this.cZG != null) {
            this.cZG.setPrimary(isPrimary());
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
        if (this.cZG != null) {
            return this.cZG.getCurrentPageKey();
        }
        return null;
    }
}

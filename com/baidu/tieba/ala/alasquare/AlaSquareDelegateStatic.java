package com.baidu.tieba.ala.alasquare;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaConfig;
import com.baidu.ala.atomdata.AlaLiveTabMyConcernActivityConfig;
import com.baidu.ala.atomdata.AlaNewSquareSubListActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.mainTab.c;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.alasquare.live.AlaAllLiveSimpleActivity;
import com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment;
import com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment;
import com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabYanzhiSubFragment;
import com.baidu.tieba.ala.alasquare.live_tab.message.AlaTabLiveResponsedMessage;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.AlaLiveTabMyConcernActivity;
import com.baidu.tieba.ala.alasquare.special_forum.a;
import com.baidu.tieba.ala.alasquare.special_forum.message.AlaSpecialConcernResponse;
import com.baidu.tieba.ala.alasquare.special_forum.message.AlaSpecialRecommendResponse;
import com.baidu.tieba.ala.alasquare.subtablist.message.AlaNewSquareSubListResponseMessage;
import com.baidu.tieba.ala.alasquare.subtablist.message.SdkLiveInfoListResponsedMessage;
import com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListActivity;
import com.baidu.tieba.frs.ac;
import com.baidu.tieba.frs.e;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tbclient.FrsTabInfo;
/* loaded from: classes3.dex */
public class AlaSquareDelegateStatic {
    static {
        bbS();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921353));
        CustomMessageTask customMessageTask = new CustomMessageTask(2921399, new CustomMessageTask.CustomRunnable<BaseFragment>() { // from class: com.baidu.tieba.ala.alasquare.AlaSquareDelegateStatic.1
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<BaseFragment> run(CustomMessage<BaseFragment> customMessage) {
                return new CustomResponsedMessage<>(2921399, new AlaLiveTabFragment());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        bbU();
        TbadkCoreApplication.getInst().RegisterIntent(AlaLiveTabMyConcernActivityConfig.class, AlaLiveTabMyConcernActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(AlaNewSquareSubListActivityConfig.class, AlaNewSquareSubListActivity.class);
        bbV();
        bbW();
        bca();
        bbX();
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB) { // from class: com.baidu.tieba.ala.alasquare.AlaSquareDelegateStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof ac) {
                        ac acVar = (ac) data;
                        acVar.b(new a(acVar.getForumId(), acVar.getForumName()));
                    }
                }
            }
        });
        bbY();
        bbZ();
        CustomMessageTask customMessageTask2 = new CustomMessageTask(CmdConfigCustom.CMD_ALA_GET_LIVE_FORUM_URL, new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.alasquare.AlaSquareDelegateStatic.3
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<String> run(CustomMessage customMessage) {
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_ALA_GET_LIVE_FORUM_URL, b.aFB().getString("show_live_forum_url", "http://tieba.baidu.com/f?kw=百度直播"));
            }
        });
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        CustomMessageTask customMessageTask3 = new CustomMessageTask(CmdConfigCustom.CMD_ALA_START_SYNC, new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.alasquare.AlaSquareDelegateStatic.4
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<String> run(CustomMessage customMessage) {
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_ALA_START_SYNC, b.aFB().getString("show_live_forum_name", "百度直播"));
            }
        });
        customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask3);
    }

    private static void bbS() {
        ba.aGE().a(new ba.a() { // from class: com.baidu.tieba.ala.alasquare.AlaSquareDelegateStatic.5
            @Override // com.baidu.tbadk.core.util.ba.a
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                if (strArr == null || strArr.length == 0 || strArr[0] == null || tbPageContext == null) {
                    return 3;
                }
                String lowerCase = strArr[0].toLowerCase();
                if (lowerCase.contains(UrlSchemaHelper.JUMP_TO_VIDEO_SQUARE)) {
                    com.baidu.tbadk.core.e.b.b(tbPageContext.getPageActivity(), 15, true);
                    return 1;
                }
                Matcher matcher = Pattern.compile("http[s]?://tieba.baidu.com/video/square\\?tid=(\\d+)").matcher(lowerCase);
                if (matcher.find()) {
                    if (AlaSquareDelegateStatic.bbT()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(2).buildVideoThreadId(matcher.group(1))));
                        return 1;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(15).buildVideoThreadId(matcher.group(1))));
                    return 1;
                }
                return 3;
            }
        });
    }

    public static boolean bbT() {
        return true;
    }

    private static void bbU() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO, TbConfig.SERVER_ADDRESS + AlaConfig.ALA_GET_TAB_LIVE_INFO);
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaTabLiveResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void bbV() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_NEW_SQUARE_SUB_LIST, TbConfig.SERVER_ADDRESS + AlaConfig.ALA_GET_NEW_SQUARE_SUB_LIVE_LIST);
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(AlaNewSquareSubListResponseMessage.class);
        MessageManager.getInstance().unRegisterTask(AlaCmdConfigHttp.CMD_ALA_NEW_SQUARE_SUB_LIST);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void bbW() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_GAME_LIVE_LIST, TbConfig.SERVER_ADDRESS + AlaConfig.ALA_GAME_LIVE_LIST);
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(SdkLiveInfoListResponsedMessage.class);
        MessageManager.getInstance().unRegisterTask(AlaCmdConfigHttp.CMD_ALA_GAME_LIVE_LIST);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void bbX() {
        CustomMessageTask customMessageTask = new CustomMessageTask(AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new CustomMessageTask.CustomRunnable<IntentConfig>() { // from class: com.baidu.tieba.ala.alasquare.AlaSquareDelegateStatic.6
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<IntentConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    customMessage.getData().startActivity(AlaAllLiveSimpleActivity.class);
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void bbY() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_SPECIAL_CONCERN_TAB, TbConfig.SERVER_ADDRESS + AlaConfig.ALA_SPECIAL_LIVE_CONCERN_TAB);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaSpecialConcernResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void bbZ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_SPECIAL_RECOMMEND_TAB, TbConfig.SERVER_ADDRESS + AlaConfig.ALA_SPECIAL_LIVE_RECOMMEND_TAB);
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(AlaSpecialRecommendResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void bca() {
        CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_TAB) { // from class: com.baidu.tieba.ala.alasquare.AlaSquareDelegateStatic.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                e eVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e) && (eVar = (e) customResponsedMessage.getData()) != null && !v.isEmpty(eVar.bDs())) {
                    for (FrsTabInfo frsTabInfo : eVar.bDs()) {
                        if (frsTabInfo.tab_id.intValue() == 1120) {
                            AlaSquareDelegateStatic.b(eVar);
                        } else if (frsTabInfo.tab_id.intValue() == 1121) {
                            AlaSquareDelegateStatic.a(eVar);
                        }
                    }
                }
            }
        };
        customMessageListener.setPriority(1);
        MessageManager.getInstance().registerListener(customMessageListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(final e eVar) {
        if (eVar != null) {
            eVar.b(new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.ala.alasquare.AlaSquareDelegateStatic.8
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public c createFragmentTabStructure() {
                    LiveTabGameSubFragment hT = LiveTabGameSubFragment.hT(true);
                    hT.cP(e.this.getForumId(), e.this.getForumName());
                    c cVar = new c();
                    cVar.frag = hT;
                    cVar.type = 1121;
                    cVar.showIconType = c.SHOWTEXT;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator getTabIndicator(Context context) {
                    return null;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final e eVar) {
        if (eVar != null) {
            eVar.b(new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.ala.alasquare.AlaSquareDelegateStatic.9
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public c createFragmentTabStructure() {
                    LiveTabYanzhiSubFragment hV = LiveTabYanzhiSubFragment.hV(true);
                    hV.cP(e.this.getForumId(), e.this.getForumName());
                    c cVar = new c();
                    cVar.frag = hV;
                    cVar.type = 1120;
                    cVar.showIconType = c.SHOWTEXT;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator getTabIndicator(Context context) {
                    return null;
                }
            });
        }
    }
}

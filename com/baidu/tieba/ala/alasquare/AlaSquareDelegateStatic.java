package com.baidu.tieba.ala.alasquare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaConfig;
import com.baidu.ala.atomdata.AlaNewSquareSubListActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveTabMyConcernActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.mainTab.c;
import com.baidu.tbadk.mainTab.d;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
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
import com.baidu.tieba.frs.am;
import com.baidu.tieba.frs.g;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class AlaSquareDelegateStatic {
    public static String Tag = "tag";

    static {
        bJt();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921353));
        bJC();
        bJD();
        bJv();
        TbadkCoreApplication.getInst().RegisterIntent(AlaLiveTabMyConcernActivityConfig.class, AlaLiveTabMyConcernActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(AlaNewSquareSubListActivityConfig.class, AlaNewSquareSubListActivity.class);
        bJw();
        bJx();
        bJB();
        bJy();
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB) { // from class: com.baidu.tieba.ala.alasquare.AlaSquareDelegateStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof am) {
                        am amVar = (am) data;
                        amVar.b(new a(amVar.getForumId(), amVar.getForumName()));
                    }
                }
            }
        });
        bJz();
        bJA();
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_ALA_GET_LIVE_FORUM_URL, new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.alasquare.AlaSquareDelegateStatic.3
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<String> run(CustomMessage customMessage) {
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_ALA_GET_LIVE_FORUM_URL, b.blO().getString("show_live_forum_url", "http://tieba.baidu.com/f?kw=百度直播"));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(CmdConfigCustom.CMD_ALA_START_SYNC, new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.alasquare.AlaSquareDelegateStatic.4
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<String> run(CustomMessage customMessage) {
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_ALA_START_SYNC, b.blO().getString("show_live_forum_name", "百度直播"));
            }
        });
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
    }

    private static void bJt() {
        be.bmY().a(new be.a() { // from class: com.baidu.tieba.ala.alasquare.AlaSquareDelegateStatic.5
            @Override // com.baidu.tbadk.core.util.be.a
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                if (strArr == null || strArr.length == 0 || strArr[0] == null || tbPageContext == null) {
                    return 3;
                }
                String lowerCase = strArr[0].toLowerCase();
                if (lowerCase.contains(UrlSchemaHelper.JUMP_TO_VIDEO_SQUARE)) {
                    com.baidu.tbadk.core.e.b.c(tbPageContext.getPageActivity(), 15, true);
                    return 1;
                }
                Matcher matcher = Pattern.compile("http[s]?://tieba.baidu.com/video/square\\?tid=(\\d+)").matcher(lowerCase);
                if (matcher.find()) {
                    if (AlaSquareDelegateStatic.bJu()) {
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

    public static boolean bJu() {
        return true;
    }

    private static void bJv() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO, TbConfig.SERVER_ADDRESS + AlaConfig.ALA_GET_TAB_LIVE_INFO);
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaTabLiveResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void bJw() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_NEW_SQUARE_SUB_LIST, TbConfig.SERVER_ADDRESS + AlaConfig.ALA_GET_NEW_SQUARE_SUB_LIVE_LIST);
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(AlaNewSquareSubListResponseMessage.class);
        MessageManager.getInstance().unRegisterTask(AlaCmdConfigHttp.CMD_ALA_NEW_SQUARE_SUB_LIST);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void bJx() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_GAME_LIVE_LIST, TbConfig.SERVER_ADDRESS + AlaConfig.ALA_GAME_LIVE_LIST);
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(SdkLiveInfoListResponsedMessage.class);
        MessageManager.getInstance().unRegisterTask(AlaCmdConfigHttp.CMD_ALA_GAME_LIVE_LIST);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void bJy() {
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

    private static void bJz() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_SPECIAL_CONCERN_TAB, TbConfig.SERVER_ADDRESS + AlaConfig.ALA_SPECIAL_LIVE_CONCERN_TAB);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaSpecialConcernResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void bJA() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_SPECIAL_RECOMMEND_TAB, TbConfig.SERVER_ADDRESS + AlaConfig.ALA_SPECIAL_LIVE_RECOMMEND_TAB);
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(AlaSpecialRecommendResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void bJB() {
        CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_TAB) { // from class: com.baidu.tieba.ala.alasquare.AlaSquareDelegateStatic.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                g gVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof g) && (gVar = (g) customResponsedMessage.getData()) != null && !y.isEmpty(gVar.buQ())) {
                    for (FrsTabInfo frsTabInfo : gVar.buQ()) {
                        if (frsTabInfo.tab_id.intValue() == 1120) {
                            AlaSquareDelegateStatic.b(gVar);
                        } else if (frsTabInfo.tab_id.intValue() == 1121) {
                            AlaSquareDelegateStatic.a(gVar);
                        }
                    }
                }
            }
        };
        customMessageListener.setPriority(1);
        MessageManager.getInstance().registerListener(customMessageListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(final g gVar) {
        if (gVar != null) {
            gVar.b(new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.ala.alasquare.AlaSquareDelegateStatic.8
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public c createFragmentTabStructure() {
                    LiveTabGameSubFragment ld = LiveTabGameSubFragment.ld(true);
                    ld.eb(g.this.getForumId(), g.this.getForumName());
                    c cVar = new c();
                    cVar.frag = ld;
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
    public static void b(final g gVar) {
        if (gVar != null) {
            gVar.b(new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.ala.alasquare.AlaSquareDelegateStatic.9
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public c createFragmentTabStructure() {
                    LiveTabYanzhiSubFragment lf = LiveTabYanzhiSubFragment.lf(true);
                    lf.eb(g.this.getForumId(), g.this.getForumName());
                    c cVar = new c();
                    cVar.frag = lf;
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

    private static void bJC() {
        new CustomMessageListener(CmdConfigCustom.MAINTAB_ADD_FRAGMENT) { // from class: com.baidu.tieba.ala.alasquare.AlaSquareDelegateStatic.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null) {
                    ((d) customResponsedMessage.getData()).a(new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.ala.alasquare.AlaSquareDelegateStatic.10.1
                        @Override // com.baidu.tbadk.mainTab.b
                        public boolean isAvailable() {
                            return true;
                        }

                        @Override // com.baidu.tbadk.mainTab.b
                        public c createFragmentTabStructure() {
                            c cVar = new c();
                            cVar.frag = new MainBottomLiveTabFragment();
                            cVar.type = 20;
                            cVar.textResId = R.string.ala_live;
                            cVar.animationResId = R.raw.lottie_tab_live;
                            cVar.showIconType = c.SHOWBOTH;
                            return cVar;
                        }

                        @Override // com.baidu.tbadk.mainTab.b
                        public TbFragmentTabIndicator getTabIndicator(Context context) {
                            this.mIndicator = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(R.layout.maintab_bottom_indicator, (ViewGroup) null);
                            return this.mIndicator;
                        }
                    });
                }
            }
        }.setPriority(6);
    }

    private static void bJD() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921399, new CustomMessageTask.CustomRunnable<BaseFragment>() { // from class: com.baidu.tieba.ala.alasquare.AlaSquareDelegateStatic.2
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<BaseFragment> run(CustomMessage<BaseFragment> customMessage) {
                return new CustomResponsedMessage<>(2921399, new AlaLiveTabFragment());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}

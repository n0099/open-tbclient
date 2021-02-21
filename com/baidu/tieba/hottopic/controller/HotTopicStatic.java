package com.baidu.tieba.hottopic.controller;

import android.content.Context;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.RelateTopicForumActivityConfig;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.util.al;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.g;
import com.baidu.tieba.homepage.BlessHttpResponseMessage;
import com.baidu.tieba.homepage.BlessSocketResponseMessage;
import com.baidu.tieba.hottopic.frs.FrsHottopicFragment;
import com.baidu.tieba.hottopic.message.ResponseHttpGetTopicRelateThreadMessage;
import com.baidu.tieba.hottopic.message.ResponseHttpHotRanklistMessage;
import com.baidu.tieba.hottopic.message.ResponseHttpHotTopicMessage;
import com.baidu.tieba.hottopic.message.ResponseSocketGetTopicRelateThreadMessage;
import com.baidu.tieba.hottopic.message.ResponseSocketHotRanklistMessage;
import com.baidu.tieba.hottopic.message.ResponseSocketHotTopicMessage;
import com.baidu.tieba.newdetail.HotTopicDetailActivity;
import com.baidu.tieba.newlist.HotTopicListActivity;
import java.util.Map;
/* loaded from: classes8.dex */
public class HotTopicStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(HotTopicActivityConfig.class, HotTopicDetailActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(RelateTopicForumActivityConfig.class, RelateTopicForumActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(HotRanklistActivityConfig.class, HotTopicListActivity.class);
        cTa();
        cTb();
        cTc();
        cwb();
        cTd();
        cTe();
        cTf();
        bRa();
    }

    private static void cTa() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_HOT_TOPIC, ResponseSocketHotTopicMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_HOT_TOPIC, 1003041, TbConfig.URL_GET_HOT_TOPIC_DATA, ResponseHttpHotTopicMessage.class, false, false, true, false);
    }

    private static void cTb() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_TOPIC_RELATE_THREAD, ResponseSocketGetTopicRelateThreadMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_TOPIC_RELATE_THREAD, 1003042, TbConfig.URL_GET_TOPIC_RELATE_THREAD, ResponseHttpGetTopicRelateThreadMessage.class, false, false, true, false);
    }

    private static void cTc() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_TOPIC_BLESS, BlessSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_TOPIC_BLESS, 1003065, TbConfig.URL_TOPIC_USER_PK, BlessHttpResponseMessage.class, false, false, true, false);
    }

    private static void cwb() {
        bf.bsV().a(new bf.a() { // from class: com.baidu.tieba.hottopic.controller.HotTopicStatic.1
            @Override // com.baidu.tbadk.core.util.bf.a
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                String lowerCase;
                if (strArr == null || strArr.length == 0 || strArr[0] == null || tbPageContext == null || (lowerCase = strArr[0].toLowerCase()) == null || com.baidu.tbadk.plugins.b.a(tbPageContext, false, true)) {
                    return 3;
                }
                if (lowerCase.startsWith(UrlSchemaHelper.JUMP_TO_HOT_TOPIC) || lowerCase.startsWith(UrlSchemaHelper.JUMP_TO_HOT_TOPIC_NEW) || lowerCase.startsWith(UrlSchemaHelper.HTTPS_JUMP_TO_HOT_TOPIC) || lowerCase.startsWith(UrlSchemaHelper.HTTPS_JUMP_TO_HOT_TOPIC_NEW)) {
                    String matchStringFromURL = al.getMatchStringFromURL(lowerCase, "topic_id=");
                    String matchStringFromURL2 = al.getMatchStringFromURL(lowerCase, "topic_name=");
                    if (StringUtils.isNull(matchStringFromURL) || StringUtils.isNull(matchStringFromURL2, true)) {
                        return 3;
                    }
                    String str = "";
                    if (strArr != null && strArr.length > 1 && !StringUtils.isNull(strArr[1])) {
                        str = strArr[1];
                    }
                    tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(tbPageContext.getPageActivity()).createNormalConfig(matchStringFromURL, matchStringFromURL2, str)));
                    return 1;
                }
                return 3;
            }
        });
    }

    private static void cTd() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.hottopic.controller.HotTopicStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                    ((AbsDelegateAdapterList) customResponsedMessage.getData()).add(new com.baidu.tieba.hottopic.frs.c(null, cb.eQU));
                }
            }
        });
    }

    private static void cTe() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_HOT_TOPIC_RANKLIST, ResponseSocketHotRanklistMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_HOT_TOPIC_RANKLIST, 1003078, TbConfig.URL_GET_HOT_RANKLIST_DATA, ResponseHttpHotRanklistMessage.class, false, false, true, false);
    }

    private static void cTf() {
        bf.bsV().a(UrlSchemaHelper.SCHEMA_TYPE_HOT_TOPIC_LIST, new bf.b() { // from class: com.baidu.tieba.hottopic.controller.HotTopicStatic.3
            @Override // com.baidu.tbadk.core.util.bf.b
            public void a(TbPageContext<?> tbPageContext, Map<String, String> map) {
                if (tbPageContext != null && map != null) {
                    new HotRanklistActivityConfig(tbPageContext.getPageActivity()).createNormalConfig(map.get("call_from"), map.get("list_type")).start();
                }
            }
        });
    }

    private static void bRa() {
        CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_TAB) { // from class: com.baidu.tieba.hottopic.controller.HotTopicStatic.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof g)) {
                    final g gVar = (g) customResponsedMessage.getData();
                    gVar.b(new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.hottopic.controller.HotTopicStatic.4.1
                        @Override // com.baidu.tbadk.mainTab.b
                        public boolean isAvailable() {
                            return true;
                        }

                        @Override // com.baidu.tbadk.mainTab.b
                        public com.baidu.tbadk.mainTab.c createFragmentTabStructure() {
                            FrsHottopicFragment frsHottopicFragment = new FrsHottopicFragment();
                            Bundle bundle = new Bundle();
                            bundle.putString("fid", gVar.getForumId());
                            bundle.putString("from", gVar.getFrom());
                            frsHottopicFragment.setArguments(bundle);
                            com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                            cVar.frag = frsHottopicFragment;
                            cVar.type = 401;
                            cVar.showIconType = com.baidu.tbadk.mainTab.c.SHOWTEXT;
                            return cVar;
                        }

                        @Override // com.baidu.tbadk.mainTab.b
                        public TbFragmentTabIndicator getTabIndicator(Context context) {
                            return null;
                        }
                    });
                }
            }
        };
        customMessageListener.setPriority(1);
        MessageManager.getInstance().registerListener(customMessageListener);
    }
}

package com.baidu.tieba.frs;

import android.os.Build;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsGameCommentActivityConfig;
import com.baidu.tbadk.core.atomData.FrsGameSubPbActivityConfig;
import com.baidu.tbadk.core.atomData.FrsMoreFeedForumsConfig;
import com.baidu.tbadk.core.atomData.FrsProfessionIntroActivityConfig;
import com.baidu.tbadk.core.atomData.GameShareActivityConfig;
import com.baidu.tbadk.core.atomData.VideoAggregationActivityConfig;
import com.baidu.tbadk.core.atomData.VideoEasterEggActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import com.baidu.tieba.frs.aggregation.VideoAggregationActivity;
import com.baidu.tieba.frs.frsfeedforums.FrsMoreFeedForumsActivity;
import com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity;
import com.baidu.tieba.frs.gameshare.GameShareCardActivity;
import com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity;
import com.baidu.tieba.frs.professional.FrsProfessionIntroActivity;
import com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageActivity;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity;
import com.tencent.connect.share.QzonePublish;
import java.net.URLDecoder;
import java.util.Map;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class FRSExtraStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(VideoEasterEggActivityConfig.class, VideoEasterEggActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(GameShareActivityConfig.class, GameShareCardActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(VideoAggregationActivityConfig.class, VideoAggregationActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(VideoMiddlePageActivityConfig.class, VideoMiddlePageActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(FrsGameCommentActivityConfig.class, FrsGameCommentActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(FrsGameSubPbActivityConfig.class, FrsGameSubPbActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(FrsProfessionIntroActivityConfig.class, FrsProfessionIntroActivity.class);
        bh.cbc.set(true);
        c.ftA.set(new ao());
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.FRSExtraStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                    AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
                    absDelegateAdapterList.add(new r(null, ay.bZS, null));
                    absDelegateAdapterList.add(new com.baidu.tieba.frs.a.a.a(null, com.baidu.tieba.card.data.n.ePT, true));
                    absDelegateAdapterList.add(new com.baidu.tieba.frs.a.a.b(null, com.baidu.tieba.tbadkCore.x.jgE, null));
                    absDelegateAdapterList.add(new com.baidu.tieba.frs.gamepaltform.a(null, com.baidu.tieba.h.b.fXE, null));
                }
            }
        });
        MessageManager.getInstance().registerTask(new CustomMessageTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.frs.FRSExtraStatic.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                return null;
            }
        }));
        ba.amO().a(new ba.a() { // from class: com.baidu.tieba.frs.FRSExtraStatic.3
            @Override // com.baidu.tbadk.core.util.ba.a
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                Map<String, String> paramPair;
                if (tbPageContext == null || strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                if (!str.contains("tieba.baidu.com/videoMiddlePage") || (paramPair = ba.getParamPair(ba.getParamStr(str))) == null) {
                    return 3;
                }
                String str2 = paramPair.get(TbEnum.SystemMessage.KEY_USER_NAME);
                String decode = !com.baidu.tbadk.core.util.aq.isEmpty(str2) ? URLDecoder.decode(str2) : str2;
                String str3 = paramPair.get("portrait");
                String decode2 = !com.baidu.tbadk.core.util.aq.isEmpty(str3) ? URLDecoder.decode(str3) : str3;
                String str4 = paramPair.get("videoUrl");
                String decode3 = !com.baidu.tbadk.core.util.aq.isEmpty(str4) ? URLDecoder.decode(str4) : str4;
                String str5 = paramPair.get("thumbnailUrl");
                String decode4 = !com.baidu.tbadk.core.util.aq.isEmpty(str5) ? URLDecoder.decode(str5) : str5;
                String str6 = paramPair.get("title");
                String decode5 = !com.baidu.tbadk.core.util.aq.isEmpty(str6) ? URLDecoder.decode(str6) : str6;
                VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
                videoSerializeVideoThreadInfo.author = new VideoSerializeVideoThreadInfo.VideoAggregationAuthorData();
                videoSerializeVideoThreadInfo.author.userId = paramPair.get(TbEnum.SystemMessage.KEY_USER_ID);
                videoSerializeVideoThreadInfo.author.userName = decode;
                videoSerializeVideoThreadInfo.author.portrait = decode2;
                videoSerializeVideoThreadInfo.author.hasFocus = "1".equals(paramPair.get("hasFocus"));
                videoSerializeVideoThreadInfo.author.isGod = "1".equals(paramPair.get("isGod"));
                videoSerializeVideoThreadInfo.video = new VideoSerializeVideoThreadInfo.VideoAggregationVideoData();
                videoSerializeVideoThreadInfo.video.videoMd5 = paramPair.get("videoMd5");
                videoSerializeVideoThreadInfo.video.videoUrl = decode3;
                videoSerializeVideoThreadInfo.video.videoWidth = paramPair.get("videoWidth");
                videoSerializeVideoThreadInfo.video.videoHeight = paramPair.get("videoHeight");
                videoSerializeVideoThreadInfo.video.thumbnailUrl = decode4;
                videoSerializeVideoThreadInfo.forumId = paramPair.get(TbTitleActivityConfig.FORUM_ID);
                videoSerializeVideoThreadInfo.threadId = paramPair.get("threadId");
                videoSerializeVideoThreadInfo.hasAgree = "1".equals(paramPair.get("hasAgree"));
                videoSerializeVideoThreadInfo.title = decode5;
                videoSerializeVideoThreadInfo.video.videoDuration = com.baidu.adp.lib.g.b.toInt(paramPair.get(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), 0);
                videoSerializeVideoThreadInfo.postNum = com.baidu.adp.lib.g.b.toInt(paramPair.get("postNum"), 0);
                videoSerializeVideoThreadInfo.agreeNum = com.baidu.adp.lib.g.b.toInt(paramPair.get("agreeNum"), 0);
                videoSerializeVideoThreadInfo.disAgreeNum = com.baidu.adp.lib.g.b.toInt(paramPair.get("disagreeNum"), 0);
                videoSerializeVideoThreadInfo.agreeType = com.baidu.adp.lib.g.b.toInt(paramPair.get("agreeType"), 0);
                videoSerializeVideoThreadInfo.shareNum = com.baidu.adp.lib.g.b.toInt(paramPair.get("shareNum"), 0);
                videoSerializeVideoThreadInfo.mVideoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoMiddlePageActivityConfig(tbPageContext.getContext(), paramPair.get("from"), videoSerializeVideoThreadInfo.threadId, "", "", videoSerializeVideoThreadInfo)));
                return 1;
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.FRSExtraStatic.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001616) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof ab) {
                        ab abVar = (ab) data;
                        abVar.b(new com.baidu.tieba.frs.gamerecommend.a(abVar.getForumId(), abVar.getForumName()));
                        for (FrsTabInfo frsTabInfo : abVar.blH()) {
                            if (frsTabInfo.tab_id.intValue() > 100) {
                                com.baidu.tieba.frs.gametabs.c cVar = new com.baidu.tieba.frs.gametabs.c(frsTabInfo.tab_id.intValue(), frsTabInfo.tab_url);
                                abVar.b(cVar);
                                if (abVar.getContext() == null) {
                                    continue;
                                } else {
                                    com.baidu.tbadk.mainTab.c avx = cVar.avx();
                                    if (avx != null) {
                                        avx.frag.setArguments(new Bundle());
                                    } else {
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });
        TbadkCoreApplication.getInst().RegisterIntent(FrsMoreFeedForumsConfig.class, FrsMoreFeedForumsActivity.class);
        bje();
        bjf();
        if (Build.VERSION.SDK_INT < 24) {
            com.baidu.tieba.nativecrash.a.bNV();
        }
    }

    private static void bje() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.FRSExtraStatic.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                    ((AbsDelegateAdapterList) customResponsedMessage.getData()).add(new com.baidu.tieba.frs.frsfeedforums.c(null, com.baidu.tieba.tbadkCore.k.jfL, true));
                }
            }
        });
    }

    private static void bjf() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_FRS_MORE_FEED_FORUMS_CONTROLLER, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.frs.FRSExtraStatic.6
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_FRS_MORE_FEED_FORUMS_CONTROLLER, new com.baidu.tieba.frs.frsfeedforums.a());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}

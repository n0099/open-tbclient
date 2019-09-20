package com.baidu.tieba.frs;

import android.os.Build;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
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
import com.baidu.tbadk.core.frameworkData.IntentConfig;
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
        bh.bKl.set(true);
        c.fve.set(new ao());
        MessageManager.getInstance().registerListener(new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.FRSExtraStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                    AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
                    absDelegateAdapterList.add(new r(null, ay.bJc, null));
                    absDelegateAdapterList.add(new com.baidu.tieba.frs.a.a.a(null, com.baidu.tieba.card.data.n.eIf, true));
                    absDelegateAdapterList.add(new com.baidu.tieba.frs.a.a.b(null, com.baidu.tieba.tbadkCore.x.jhG, null));
                    absDelegateAdapterList.add(new com.baidu.tieba.frs.gamepaltform.a(null, com.baidu.tieba.h.b.fZa, null));
                }
            }
        });
        MessageManager.getInstance().registerTask(new CustomMessageTask(2003016, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.frs.FRSExtraStatic.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                return null;
            }
        }));
        ba.ajK().a(new ba.a() { // from class: com.baidu.tieba.frs.FRSExtraStatic.3
            @Override // com.baidu.tbadk.core.util.ba.a
            public int a(TbPageContext<?> tbPageContext, String[] strArr) {
                Map<String, String> oq;
                if (tbPageContext == null || strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                if (!str.contains("tieba.baidu.com/videoMiddlePage") || (oq = ba.oq(ba.or(str))) == null) {
                    return 3;
                }
                String str2 = oq.get("userName");
                String decode = !com.baidu.tbadk.core.util.aq.isEmpty(str2) ? URLDecoder.decode(str2) : str2;
                String str3 = oq.get(IntentConfig.PORTRAIT);
                String decode2 = !com.baidu.tbadk.core.util.aq.isEmpty(str3) ? URLDecoder.decode(str3) : str3;
                String str4 = oq.get("videoUrl");
                String decode3 = !com.baidu.tbadk.core.util.aq.isEmpty(str4) ? URLDecoder.decode(str4) : str4;
                String str5 = oq.get("thumbnailUrl");
                String decode4 = !com.baidu.tbadk.core.util.aq.isEmpty(str5) ? URLDecoder.decode(str5) : str5;
                String str6 = oq.get("title");
                String decode5 = !com.baidu.tbadk.core.util.aq.isEmpty(str6) ? URLDecoder.decode(str6) : str6;
                VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
                videoSerializeVideoThreadInfo.author = new VideoSerializeVideoThreadInfo.VideoAggregationAuthorData();
                videoSerializeVideoThreadInfo.author.userId = oq.get("userId");
                videoSerializeVideoThreadInfo.author.userName = decode;
                videoSerializeVideoThreadInfo.author.portrait = decode2;
                videoSerializeVideoThreadInfo.author.hasFocus = "1".equals(oq.get("hasFocus"));
                videoSerializeVideoThreadInfo.author.isGod = "1".equals(oq.get("isGod"));
                videoSerializeVideoThreadInfo.video = new VideoSerializeVideoThreadInfo.VideoAggregationVideoData();
                videoSerializeVideoThreadInfo.video.videoMd5 = oq.get("videoMd5");
                videoSerializeVideoThreadInfo.video.videoUrl = decode3;
                videoSerializeVideoThreadInfo.video.videoWidth = oq.get("videoWidth");
                videoSerializeVideoThreadInfo.video.videoHeight = oq.get("videoHeight");
                videoSerializeVideoThreadInfo.video.thumbnailUrl = decode4;
                videoSerializeVideoThreadInfo.forumId = oq.get(TbTitleActivityConfig.FORUM_ID);
                videoSerializeVideoThreadInfo.threadId = oq.get("threadId");
                videoSerializeVideoThreadInfo.hasAgree = "1".equals(oq.get("hasAgree"));
                videoSerializeVideoThreadInfo.title = decode5;
                videoSerializeVideoThreadInfo.video.videoDuration = com.baidu.adp.lib.g.b.f(oq.get(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), 0);
                videoSerializeVideoThreadInfo.postNum = com.baidu.adp.lib.g.b.f(oq.get("postNum"), 0);
                videoSerializeVideoThreadInfo.agreeNum = com.baidu.adp.lib.g.b.f(oq.get("agreeNum"), 0);
                videoSerializeVideoThreadInfo.disAgreeNum = com.baidu.adp.lib.g.b.f(oq.get("disagreeNum"), 0);
                videoSerializeVideoThreadInfo.agreeType = com.baidu.adp.lib.g.b.f(oq.get("agreeType"), 0);
                videoSerializeVideoThreadInfo.shareNum = com.baidu.adp.lib.g.b.f(oq.get("shareNum"), 0);
                videoSerializeVideoThreadInfo.mVideoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(tbPageContext.getContext(), oq.get("from"), videoSerializeVideoThreadInfo.threadId, "", "", videoSerializeVideoThreadInfo)));
                return 1;
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001616) { // from class: com.baidu.tieba.frs.FRSExtraStatic.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001616) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof ab) {
                        ab abVar = (ab) data;
                        abVar.b(new com.baidu.tieba.frs.gamerecommend.a(abVar.getForumId(), abVar.getForumName()));
                        for (FrsTabInfo frsTabInfo : abVar.boF()) {
                            if (frsTabInfo.tab_id.intValue() > 100) {
                                com.baidu.tieba.frs.gametabs.c cVar = new com.baidu.tieba.frs.gametabs.c(frsTabInfo.tab_id.intValue(), frsTabInfo.tab_url);
                                abVar.b(cVar);
                                if (abVar.getContext() == null) {
                                    continue;
                                } else {
                                    com.baidu.tbadk.mainTab.c aug = cVar.aug();
                                    if (aug != null) {
                                        aug.cyG.setArguments(new Bundle());
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
        bma();
        bmb();
        if (Build.VERSION.SDK_INT < 24) {
            com.baidu.tieba.nativecrash.a.bQZ();
        }
    }

    private static void bma() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.FRSExtraStatic.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                    ((AbsDelegateAdapterList) customResponsedMessage.getData()).add(new com.baidu.tieba.frs.frsfeedforums.c(null, com.baidu.tieba.tbadkCore.k.jgM, true));
                }
            }
        });
    }

    private static void bmb() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016468, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.frs.FRSExtraStatic.6
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                return new CustomResponsedMessage<>(2016468, new com.baidu.tieba.frs.frsfeedforums.a());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}

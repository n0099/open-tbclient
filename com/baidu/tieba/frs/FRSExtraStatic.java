package com.baidu.tieba.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsGameCommentActivityConfig;
import com.baidu.tbadk.core.atomData.FrsGameSubPbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoAggregationActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import com.baidu.tieba.frs.aggregation.VideoAggregationActivity;
import com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity;
import com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity;
import com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageActivity;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.tencent.connect.share.QzonePublish;
import java.net.URLDecoder;
import java.util.Map;
/* loaded from: classes3.dex */
public class FRSExtraStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(VideoAggregationActivityConfig.class, VideoAggregationActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(VideoMiddlePageActivityConfig.class, VideoMiddlePageActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(FrsGameCommentActivityConfig.class, FrsGameCommentActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(FrsGameSubPbActivityConfig.class, FrsGameSubPbActivity.class);
        bb.apd.set(true);
        c.dzu.set(new aq());
        MessageManager.getInstance().registerListener(new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.FRSExtraStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                    AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
                    absDelegateAdapterList.add(new r(null, com.baidu.tbadk.core.data.at.aot, null));
                    absDelegateAdapterList.add(new com.baidu.tieba.frs.a.a.a(null, com.baidu.tieba.card.data.n.cQD, true));
                    absDelegateAdapterList.add(new com.baidu.tieba.frs.a.a.b(null, com.baidu.tieba.tbadkCore.v.hcb, null));
                }
            }
        });
        MessageManager.getInstance().registerTask(new CustomMessageTask(2003016, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.frs.FRSExtraStatic.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                return null;
            }
        }));
        ay.CU().a(new ay.a() { // from class: com.baidu.tieba.frs.FRSExtraStatic.3
            @Override // com.baidu.tbadk.core.util.ay.a
            public int a(TbPageContext<?> tbPageContext, String[] strArr) {
                Map<String, String> fv;
                if (tbPageContext == null || strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                if (!str.contains("tieba.baidu.com/videoMiddlePage") || (fv = ay.fv(ay.fw(str))) == null) {
                    return 3;
                }
                String str2 = fv.get("userName");
                String decode = !com.baidu.tbadk.core.util.ao.isEmpty(str2) ? URLDecoder.decode(str2) : str2;
                String str3 = fv.get(IntentConfig.PORTRAIT);
                String decode2 = !com.baidu.tbadk.core.util.ao.isEmpty(str3) ? URLDecoder.decode(str3) : str3;
                String str4 = fv.get("videoUrl");
                String decode3 = !com.baidu.tbadk.core.util.ao.isEmpty(str4) ? URLDecoder.decode(str4) : str4;
                String str5 = fv.get("thumbnailUrl");
                String decode4 = !com.baidu.tbadk.core.util.ao.isEmpty(str5) ? URLDecoder.decode(str5) : str5;
                String str6 = fv.get("title");
                String decode5 = !com.baidu.tbadk.core.util.ao.isEmpty(str6) ? URLDecoder.decode(str6) : str6;
                VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
                videoSerializeVideoThreadInfo.author = new VideoSerializeVideoThreadInfo.VideoAggregationAuthorData();
                videoSerializeVideoThreadInfo.author.userId = fv.get("userId");
                videoSerializeVideoThreadInfo.author.userName = decode;
                videoSerializeVideoThreadInfo.author.portrait = decode2;
                videoSerializeVideoThreadInfo.author.hasFocus = "1".equals(fv.get("hasFocus"));
                videoSerializeVideoThreadInfo.author.isGod = "1".equals(fv.get("isGod"));
                videoSerializeVideoThreadInfo.video = new VideoSerializeVideoThreadInfo.VideoAggregationVideoData();
                videoSerializeVideoThreadInfo.video.videoMd5 = fv.get("videoMd5");
                videoSerializeVideoThreadInfo.video.videoUrl = decode3;
                videoSerializeVideoThreadInfo.video.videoWidth = fv.get("videoWidth");
                videoSerializeVideoThreadInfo.video.videoHeight = fv.get("videoHeight");
                videoSerializeVideoThreadInfo.video.thumbnailUrl = decode4;
                videoSerializeVideoThreadInfo.forumId = fv.get(TbTitleActivityConfig.FORUM_ID);
                videoSerializeVideoThreadInfo.threadId = fv.get("threadId");
                videoSerializeVideoThreadInfo.hasAgree = "1".equals(fv.get("hasAgree"));
                videoSerializeVideoThreadInfo.title = decode5;
                videoSerializeVideoThreadInfo.video.videoDuration = com.baidu.adp.lib.g.b.l(fv.get(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), 0);
                videoSerializeVideoThreadInfo.postNum = com.baidu.adp.lib.g.b.l(fv.get("postNum"), 0);
                videoSerializeVideoThreadInfo.agreeNum = com.baidu.adp.lib.g.b.l(fv.get("agreeNum"), 0);
                videoSerializeVideoThreadInfo.disAgreeNum = com.baidu.adp.lib.g.b.l(fv.get("disagreeNum"), 0);
                videoSerializeVideoThreadInfo.agreeType = com.baidu.adp.lib.g.b.l(fv.get("agreeType"), 0);
                videoSerializeVideoThreadInfo.shareNum = com.baidu.adp.lib.g.b.l(fv.get("shareNum"), 0);
                videoSerializeVideoThreadInfo.mVideoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(tbPageContext.getContext(), fv.get("from"), videoSerializeVideoThreadInfo.threadId, "", "", videoSerializeVideoThreadInfo)));
                return 1;
            }
        });
    }
}

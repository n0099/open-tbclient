package com.baidu.tieba.frs;

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
import com.baidu.tbadk.core.atomData.VideoMiddlePageLightActivityConfig;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import com.baidu.tieba.frs.aggregation.VideoAggregationActivity;
import com.baidu.tieba.frs.frsfeedforums.FrsMoreFeedForumsActivity;
import com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity;
import com.baidu.tieba.frs.gameshare.GameShareCardActivity;
import com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity;
import com.baidu.tieba.frs.professional.FrsProfessionIntroActivity;
import com.baidu.tieba.frs.videomiddlepage.VideoMiddlePageActivity;
import com.baidu.tieba.frs.videomiddlepagelight.VideoMiddlePageLightActivity;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.videoEasterEgg.VideoEasterEggActivity;
import com.tencent.connect.share.QzonePublish;
import d.b.b.e.p.k;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.q1;
import d.b.i0.c3.e0;
import d.b.i0.c3.l;
import d.b.i0.p0.b1;
import d.b.i0.p0.j0;
import d.b.i0.x.e0.n;
import java.net.URLDecoder;
import java.util.Map;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class FRSExtraStatic {

    /* loaded from: classes4.dex */
    public static class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
                absDelegateAdapterList.add(new FrsSchoolRecommendAdapter(null, q1.G3, null));
                absDelegateAdapterList.add(new d.b.i0.p0.p1.a.a(null, n.k, true));
                absDelegateAdapterList.add(new d.b.i0.p0.p1.a.b(null, e0.H3, null));
                absDelegateAdapterList.add(new d.b.i0.p0.t1.a(null, d.b.i0.s0.b.i, null));
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements CustomMessageTask.CustomRunnable<Object> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements UrlManager.UrlDealListener {
        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            Map<String, String> paramPair;
            if (tbPageContext != null && strArr != null && strArr.length != 0) {
                String str = strArr[0];
                if (!str.contains(UrlSchemaHelper.SCHEMA_TYPE_VIDEO_MIDDLE_PAGE) || (paramPair = UrlManager.getParamPair(UrlManager.getParamStr(str))) == null) {
                    return 3;
                }
                String str2 = paramPair.get(TbEnum.SystemMessage.KEY_USER_NAME);
                if (!k.isEmpty(str2)) {
                    str2 = URLDecoder.decode(str2);
                }
                String str3 = paramPair.get("portrait");
                if (!k.isEmpty(str3)) {
                    str3 = URLDecoder.decode(str3);
                }
                String str4 = paramPair.get("videoUrl");
                if (!k.isEmpty(str4)) {
                    str4 = URLDecoder.decode(str4);
                }
                String str5 = paramPair.get("thumbnailUrl");
                if (!k.isEmpty(str5)) {
                    str5 = URLDecoder.decode(str5);
                }
                String str6 = paramPair.get("title");
                if (!k.isEmpty(str6)) {
                    str6 = URLDecoder.decode(str6);
                }
                VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
                VideoSerializeVideoThreadInfo.VideoAggregationAuthorData videoAggregationAuthorData = new VideoSerializeVideoThreadInfo.VideoAggregationAuthorData();
                videoSerializeVideoThreadInfo.author = videoAggregationAuthorData;
                videoAggregationAuthorData.userId = paramPair.get("userId");
                VideoSerializeVideoThreadInfo.VideoAggregationAuthorData videoAggregationAuthorData2 = videoSerializeVideoThreadInfo.author;
                videoAggregationAuthorData2.userName = str2;
                videoAggregationAuthorData2.portrait = str3;
                videoAggregationAuthorData2.hasFocus = "1".equals(paramPair.get("hasFocus"));
                videoSerializeVideoThreadInfo.author.isGod = "1".equals(paramPair.get("isGod"));
                VideoSerializeVideoThreadInfo.VideoAggregationVideoData videoAggregationVideoData = new VideoSerializeVideoThreadInfo.VideoAggregationVideoData();
                videoSerializeVideoThreadInfo.video = videoAggregationVideoData;
                videoAggregationVideoData.videoMd5 = paramPair.get("videoMd5");
                VideoSerializeVideoThreadInfo.VideoAggregationVideoData videoAggregationVideoData2 = videoSerializeVideoThreadInfo.video;
                videoAggregationVideoData2.videoUrl = str4;
                videoAggregationVideoData2.videoWidth = paramPair.get("videoWidth");
                videoSerializeVideoThreadInfo.video.videoHeight = paramPair.get("videoHeight");
                videoSerializeVideoThreadInfo.video.thumbnailUrl = str5;
                videoSerializeVideoThreadInfo.forumId = paramPair.get(TbTitleActivityConfig.FORUM_ID);
                videoSerializeVideoThreadInfo.threadId = paramPair.get("threadId");
                videoSerializeVideoThreadInfo.hasAgree = "1".equals(paramPair.get("hasAgree"));
                videoSerializeVideoThreadInfo.title = str6;
                videoSerializeVideoThreadInfo.video.videoDuration = d.b.b.e.m.b.d(paramPair.get(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), 0);
                videoSerializeVideoThreadInfo.postNum = d.b.b.e.m.b.d(paramPair.get("postNum"), 0);
                videoSerializeVideoThreadInfo.agreeNum = d.b.b.e.m.b.d(paramPair.get("agreeNum"), 0);
                videoSerializeVideoThreadInfo.disAgreeNum = d.b.b.e.m.b.d(paramPair.get("disagreeNum"), 0);
                videoSerializeVideoThreadInfo.agreeType = d.b.b.e.m.b.d(paramPair.get("agreeType"), 0);
                videoSerializeVideoThreadInfo.shareNum = d.b.b.e.m.b.d(paramPair.get("shareNum"), 0);
                videoSerializeVideoThreadInfo.mVideoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoMiddlePageActivityConfig(tbPageContext.getContext(), paramPair.get("from"), videoSerializeVideoThreadInfo.threadId, "", "", videoSerializeVideoThreadInfo)));
                return 1;
            }
            return 3;
        }
    }

    /* loaded from: classes4.dex */
    public static class d extends CustomMessageListener {
        public d(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2001616) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof j0) {
                j0 j0Var = (j0) data;
                j0Var.a(new d.b.i0.p0.u1.a(j0Var.d(), j0Var.e()));
                for (FrsTabInfo frsTabInfo : j0Var.g()) {
                    if (frsTabInfo.tab_id.intValue() > 100) {
                        d.b.i0.p0.y1.c cVar = new d.b.i0.p0.y1.c(frsTabInfo.tab_id.intValue(), frsTabInfo.tab_url);
                        j0Var.a(cVar);
                        if (j0Var.b() == null) {
                            continue;
                        } else {
                            d.b.h0.e0.c fragmentTabStructure = cVar.getFragmentTabStructure();
                            if (fragmentTabStructure == null) {
                                return;
                            }
                            fragmentTabStructure.f50155a.setArguments(new Bundle());
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class e extends CustomMessageListener {
        public e(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                ((AbsDelegateAdapterList) customResponsedMessage.getData()).add(new d.b.i0.p0.r1.c(null, l.f53486g, true));
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class f implements CustomMessageTask.CustomRunnable<Object> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            return new CustomResponsedMessage<>(2016468, new d.b.i0.p0.r1.a());
        }
    }

    static {
        TbadkCoreApplication.getInst().RegisterIntent(VideoEasterEggActivityConfig.class, VideoEasterEggActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(GameShareActivityConfig.class, GameShareCardActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(VideoAggregationActivityConfig.class, VideoAggregationActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(VideoMiddlePageActivityConfig.class, VideoMiddlePageActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(VideoMiddlePageLightActivityConfig.class, VideoMiddlePageLightActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(FrsGameCommentActivityConfig.class, FrsGameCommentActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(FrsGameSubPbActivityConfig.class, FrsGameSubPbActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(FrsProfessionIntroActivityConfig.class, FrsProfessionIntroActivity.class);
        a2.t3.set(true);
        d.b.i0.p0.e.f57398a.set(new b1());
        MessageManager.getInstance().registerListener(new a(2003008));
        MessageManager.getInstance().registerTask(new CustomMessageTask(2003016, new b()));
        UrlManager.getInstance().addListener(new c());
        MessageManager.getInstance().registerListener(new d(2001616));
        TbadkCoreApplication.getInst().RegisterIntent(FrsMoreFeedForumsConfig.class, FrsMoreFeedForumsActivity.class);
        a();
        b();
    }

    public static void a() {
        MessageManager.getInstance().registerListener(new e(2003008));
    }

    public static void b() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016468, new f());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}

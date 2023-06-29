package com.baidu.tbadk.switchs;

import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.tieba.fh;
import com.baidu.tieba.hf;
import com.baidu.tieba.ji;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class SyncSwitch {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public SyncSwitch() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void initSyncSwitch() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            SwitchManager.getInstance().registerSwitch(TbBrowseModeSwitch.class);
            SwitchManager.getInstance().registerSwitch(GiftSwitch.class);
            SwitchManager.getInstance().registerSwitch(AccountsDataFromPassSwitch.class);
            SwitchManager.getInstance().registerSwitch(AdSdkSwitch.class);
            SwitchManager.getInstance().registerSwitch(AppLegoSwitch.class);
            SwitchManager.getInstance().registerSwitch(BaiduWebviewSwitch.class);
            SwitchManager.getInstance().registerSwitch(BaiduYunPushSdkSwitch.class);
            SwitchManager.getInstance().registerSwitch(ChunkUploadSwitch.class);
            SwitchManager.getInstance().registerSwitch(ConveneThreadOpenSwitch.class);
            SwitchManager.getInstance().registerSwitch(CreateBarTipSwitch.class);
            SwitchManager.getInstance().registerSwitch(FrsHeadVideoAutoPlaySwitch.class);
            SwitchManager.getInstance().registerSwitch(HybridBridgeSwitch.class);
            SwitchManager.getInstance().registerSwitch(ImmersiveStickySwitch.class);
            SwitchManager.getInstance().registerSwitch(LoginPassV6Switch.class);
            SwitchManager.getInstance().registerSwitch(LowVersionLoginPassV6Switch.class);
            SwitchManager.getInstance().registerSwitch(ScreenLockSyncSwitch.class);
            SwitchManager.getInstance().registerSwitch(StokenEnableSwitch.class);
            SwitchManager.getInstance().registerSwitch(UpdateDialogStyleSyncSwitch.class);
            SwitchManager.getInstance().registerSwitch(WalletSwitch.class);
            SwitchManager.getInstance().registerSwitch(WebpSwitch.class);
            SwitchManager.getInstance().registerSwitch(WebpForceSwitch.class);
            SwitchManager.getInstance().registerSwitch(XiaomiPushSdkSwitch.class);
            SwitchManager.getInstance().registerSwitch(VoiceSwitch.class);
            SwitchManager.getInstance().registerSwitch(ImgLogSwitch.class);
            SwitchManager.getInstance().registerSwitch(PerformanceSwitch.class);
            SwitchManager.getInstance().registerSwitch(TBCdnPortraitSwitch.class);
            SwitchManager.getInstance().registerSwitch(AudioRecorderSwitch.class);
            SwitchManager.getInstance().registerSwitch(NickNameActivitySwitch.class);
            SwitchManager.getInstance().registerSwitch(QuickWebViewSwitch.class);
            SwitchManager.getInstance().registerSwitch(PublishVideoThreadSwitch.class);
            SwitchManager.getInstance().registerSwitch(UrlNeedCuidSwitch.class);
            SwitchManager.getInstance().registerSwitch(DuiSwitch.class);
            SwitchManager.getInstance().registerSwitch(PbReplySwitch.class);
            SwitchManager.getInstance().registerSwitch(ShareSwitch.class);
            SwitchManager.getInstance().registerSwitch(StrangeCleanSwitch.class);
            SwitchManager.getInstance().registerSwitch(VideoMiddlePageSwitch.class);
            SwitchManager.getInstance().registerSwitch(RichTextGifViewSwitch.class);
            SwitchManager.getInstance().registerSwitch(VideoSquareMiddlePageSwitch.class);
            SwitchManager.getInstance().registerSwitch(NetDeleteSwitch.class);
            SwitchManager.getInstance().registerSwitch(NetTypeFixedSwitch.class);
            SwitchManager.getInstance().registerSwitch(MessageChooseFriendSwitch.class);
            SwitchManager.getInstance().registerSwitch(CheckShowNameDialogSwitch.class);
            SwitchManager.getInstance().registerSwitch(IsFullScreenSwitch.class);
            SwitchManager.getInstance().registerSwitch(BigdaySwitch.class);
            SwitchManager.getInstance().registerSwitch(VideoPreLoadSwitch.class);
            SwitchManager.getInstance().registerSwitch(IdentifyImageSwitch.class);
            SwitchManager.getInstance().registerSwitch(EncSigNewSwitch.class);
            SwitchManager.getInstance().registerSwitch(LoginDefaultTypeSmsSwitch.class);
            SwitchManager.getInstance().registerSwitch(FaceFeedbackEnableSwitch.class);
            SwitchManager.getInstance().registerSwitch(BenchmarkSwitch.class);
            SwitchManager.getInstance().registerSwitch(RedirectInterceptionSwitch.class);
            SwitchManager.getInstance().registerSwitch(YunPushOppoproxyEnableSwitch.class);
            SwitchManager.getInstance().registerSwitch(BarDetailForDirSwitch.class);
            SwitchManager.getInstance().registerSwitch(PbNormalLikeButtonSwitch.class);
            SwitchManager.getInstance().registerSwitch(TencentMMSwitch.class);
            SwitchManager.getInstance().registerSwitch(PageStayDurationSwitch.class);
            SwitchManager.getInstance().registerSwitch(UseHttpdnsSdkSwitch.class);
            SwitchManager.getInstance().registerSwitch(ji.class);
            SwitchManager.getInstance().registerSwitch(RepostToDynamicDefaultSwitch.class);
            SwitchManager.getInstance().registerSwitch(PbPreloadSwitch.class);
            SwitchManager.getInstance().registerSwitch(FlutterSignAllEnableSwitch.class);
            SwitchManager.getInstance().registerSwitch(FlutterPersonAttentionEnableSwitch.class);
            SwitchManager.getInstance().registerSwitch(FlutterForumDetailEnableSwitch.class);
            SwitchManager.getInstance().registerSwitch(FlutterConcernForumEnableSwitch.class);
            SwitchManager.getInstance().registerSwitch(FlutterAttachSwitch.class);
            SwitchManager.getInstance().registerSwitch(FlutterPersonCenterEnableSwitch.class);
            SwitchManager.getInstance().registerSwitch(FunAdSdkSwitch.class);
            SwitchManager.getInstance().registerSwitch(FlutterLifeCycleBugEnableSwitch.class);
            SwitchManager.getInstance().registerSwitch(UseHttpAutoRetrySwitch.class);
            SwitchManager.getInstance().registerSwitch(OpenJsSdkSwitch.class);
            SwitchManager.getInstance().registerSwitch(LimitLowQualityPicUploadSwitch.class);
            SwitchManager.getInstance().registerSwitch(WorkIntroSwitch.class);
            SwitchManager.getInstance().registerSwitch(CreateCenterTipSwitch.class);
            SwitchManager.getInstance().registerSwitch(FollowListSwitch.class);
            SwitchManager.getInstance().registerSwitch(IColorSDKSwitch.class);
            SwitchManager.getInstance().registerSwitch(VideoMiddleAdSwitch.class);
            SwitchManager.getInstance().registerSwitch(GdtPrivacySwitch.class);
            SwitchManager.getInstance().registerSwitch(KsPrivacySwitch.class);
            SwitchManager.getInstance().registerSwitch(fh.class);
            SwitchManager.getInstance().registerSwitch(CsjPrivacySwitch.class);
            SwitchManager.getInstance().registerSwitch(FunAdServerRecordSwitch.class);
            SwitchManager.getInstance().registerSwitch(FunAdSplashClickRegionSwitch.class);
            SwitchManager.getInstance().registerSwitch(WeChatShareSmallAppToH5Switch.class);
            SwitchManager.getInstance().registerSwitch(QqShareH5Switch.class);
            SwitchManager.getInstance().registerSwitch(WorkAddTopicSwitch.class);
            SwitchManager.getInstance().registerSwitch(UploadPicParallelSwitch.class);
            SwitchManager.getInstance().registerSwitch(AndroidActivityLogSwitch.class);
            SwitchManager.getInstance().registerSwitch(NovelPaySwitch.class);
            SwitchManager.getInstance().registerSwitch(ComplianceParmasSwitch.class);
            SwitchManager.getInstance().registerSwitch(OpenStartSafeModeSwitch.class);
            SwitchManager.getInstance().registerSwitch(ResetSplashAdConfigSwitch.class);
            SwitchManager.getInstance().registerSwitch(SocketAddCommonParamSwitch.class);
            SwitchManager.getInstance().registerSwitch(DelayInitNightPluginSwitch.class);
            SwitchManager.getInstance().registerSwitch(ImgUaSwitch.class);
            SwitchManager.getInstance().registerSwitch(BdNetTypeSwitch.class);
            SwitchManager.getInstance().registerSwitch(HttpsTestSwitch.class);
            SwitchManager.getInstance().registerSwitch(Ipv6TestSwitch.class);
            SwitchManager.getInstance().registerSwitch(AsyncGetClipboardSwitch.class);
            SwitchManager.getInstance().registerSwitch(MemeDiyEnableSwitch.class);
            SwitchManager.getInstance().registerSwitch(BearTimeoutTryShowSwitch.class);
            SwitchManager.getInstance().registerSwitch(MainTabFragmentIdleSwitch.class);
            SwitchManager.getInstance().registerSwitch(ImageChangeCacheKeySwitch.class);
            SwitchManager.getInstance().registerSwitch(NewWebHotTopicPageSwitch.class);
            SwitchManager.getInstance().registerSwitch(ImageAddRequestLayoutSwitch.class);
            SwitchManager.getInstance().registerSwitch(CheckIsQuestionThreadSwitch.class);
            SwitchManager.getInstance().registerSwitch(FunSdkInitSwitch.class);
            SwitchManager.getInstance().registerSwitch(GifLibrarySwitch.class);
            SwitchManager.getInstance().registerSwitch(WorldCupEnableSwitch.class);
            SwitchManager.getInstance().registerSwitch(DelayLoadUrlSwitch.class);
            SwitchManager.getInstance().registerSwitch(PraiseSwitch.class);
            SwitchManager.getInstance().registerSwitch(WebViewTrackerEnableSwitch.class);
            SwitchManager.getInstance().registerSwitch(DynamicLottieSwitch.class);
            SwitchManager.getInstance().registerSwitch(ImageCacheOptimizeSwitch.class);
            SwitchManager.getInstance().registerSwitch(BigImageCacheOptimizeSwitch.class);
            SwitchManager.getInstance().registerSwitch(UploadLogButtonSwitch.class);
            SwitchManager.getInstance().registerSwitch(EnableYaLogSwitch.class);
            SwitchManager.getInstance().registerSwitch(ImagePrePageLimitSwitch.class);
            SwitchManager.getInstance().registerSwitch(WebViewOptSwitch.class);
            SwitchManager.getInstance().registerSwitch(FunnySpriteSwitch.class);
            SwitchManager.getInstance().registerSwitch(FunnySpriteDeviceScoreSwitch.class);
            SwitchManager.getInstance().registerSwitch(OfflinePkgAutoCleanSwitch.class);
            SwitchManager.getInstance().registerSwitch(SpriteTypeWriterSwitch.class);
            SwitchManager.getInstance().registerSwitch(HeadlinesPrefetchSwitch.class);
            SwitchManager.getInstance().registerSwitch(HeadlinesPreRenderSwitch.class);
            SwitchManager.getInstance().registerSwitch(FunnySpriteColdStartRequestSwitch.class);
            SwitchManager.getInstance().registerSwitch(SpriteInterceptHomeTipSwitch.class);
            SwitchManager.getInstance().registerSwitch(PicReqSwitch.class);
            SwitchManager.getInstance().registerSwitch(DuTokenNewSwitch.class);
            SwitchManager.getInstance().registerSwitch(PageCountSwitch.class);
            hf.a().b();
        }
    }
}

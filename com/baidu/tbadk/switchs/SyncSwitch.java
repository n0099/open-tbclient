package com.baidu.tbadk.switchs;

import c.a.d.f.n.c;
import c.a.d.f.o.a;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class SyncSwitch {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public SyncSwitch() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void initSyncSwitch() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            SwitchManager.getInstance().registerSwitch(GiftSwitch.class);
            SwitchManager.getInstance().registerSwitch(AccountsDataFromPassSwitch.class);
            SwitchManager.getInstance().registerSwitch(AdSdkSwitch.class);
            SwitchManager.getInstance().registerSwitch(AdUploadSwitch.class);
            SwitchManager.getInstance().registerSwitch(AppLegoSwitch.class);
            SwitchManager.getInstance().registerSwitch(ApplistReportSwitch.class);
            SwitchManager.getInstance().registerSwitch(AppUploadSwitch.class);
            SwitchManager.getInstance().registerSwitch(BaiduWebviewSwitch.class);
            SwitchManager.getInstance().registerSwitch(BaiduYunPushSdkSwitch.class);
            SwitchManager.getInstance().registerSwitch(ChunkUploadSwitch.class);
            SwitchManager.getInstance().registerSwitch(ConveneThreadOpenSwitch.class);
            SwitchManager.getInstance().registerSwitch(CrabSdkSwitch.class);
            SwitchManager.getInstance().registerSwitch(CreateBarTipSwitch.class);
            SwitchManager.getInstance().registerSwitch(DriftingBottleSwitch.class);
            SwitchManager.getInstance().registerSwitch(FrsHeadVideoAutoPlaySwitch.class);
            SwitchManager.getInstance().registerSwitch(GameEnterSwitch.class);
            SwitchManager.getInstance().registerSwitch(HttpsConnSwitch.class);
            SwitchManager.getInstance().registerSwitch(HybridBridgeSwitch.class);
            SwitchManager.getInstance().registerSwitch(ImmersiveStickySwitch.class);
            SwitchManager.getInstance().registerSwitch(LbsWebViewSwitch.class);
            SwitchManager.getInstance().registerSwitch(LoginPassV6Switch.class);
            SwitchManager.getInstance().registerSwitch(LowVersionLoginPassV6Switch.class);
            SwitchManager.getInstance().registerSwitch(MotuSwitch.class);
            SwitchManager.getInstance().registerSwitch(PraiseSwitch.class);
            SwitchManager.getInstance().registerSwitch(RemindForumBroadcastSwitch.class);
            SwitchManager.getInstance().registerSwitch(ScreenLockSyncSwitch.class);
            SwitchManager.getInstance().registerSwitch(StokenEnableSwitch.class);
            SwitchManager.getInstance().registerSwitch(UpdateDialogStyleSyncSwitch.class);
            SwitchManager.getInstance().registerSwitch(VideoCacheSwitch.class);
            SwitchManager.getInstance().registerSwitch(VideoListWeakLockSwitch.class);
            SwitchManager.getInstance().registerSwitch(VideoUploadSwitch.class);
            SwitchManager.getInstance().registerSwitch(WalletSwitch.class);
            SwitchManager.getInstance().registerSwitch(WebpSwitch.class);
            SwitchManager.getInstance().registerSwitch(XiaomiPushSdkSwitch.class);
            SwitchManager.getInstance().registerSwitch(VoiceSwitch.class);
            SwitchManager.getInstance().registerSwitch(ImgLogSwitch.class);
            SwitchManager.getInstance().registerSwitch(PerformanceSwitch.class);
            SwitchManager.getInstance().registerSwitch(TBCdnPortraitSwitch.class);
            SwitchManager.getInstance().registerSwitch(AudioRecorderSwitch.class);
            SwitchManager.getInstance().registerSwitch(PostUrlSwitch.class);
            SwitchManager.getInstance().registerSwitch(VideoHttpDnsSwitch.class);
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
            SwitchManager.getInstance().registerSwitch(KeepAliveSwitch.class);
            SwitchManager.getInstance().registerSwitch(VideoPreLoadSwitch.class);
            SwitchManager.getInstance().registerSwitch(IdentifyImageSwitch.class);
            SwitchManager.getInstance().registerSwitch(EncSigNewSwitch.class);
            SwitchManager.getInstance().registerSwitch(LoginDefaultTypeSmsSwitch.class);
            SwitchManager.getInstance().registerSwitch(FaceFeedbackEnableSwitch.class);
            SwitchManager.getInstance().registerSwitch(BenchmarkSwitch.class);
            SwitchManager.getInstance().registerSwitch(RedirectInterceptionSwitch.class);
            SwitchManager.getInstance().registerSwitch(SwanAppPreLoadEnableSwitch.class);
            SwitchManager.getInstance().registerSwitch(YunPushOppoproxyEnableSwitch.class);
            SwitchManager.getInstance().registerSwitch(BarDetailForDirSwitch.class);
            SwitchManager.getInstance().registerSwitch(CustomPlayerSwitch.class);
            SwitchManager.getInstance().registerSwitch(DnsProxySwitch.class);
            SwitchManager.getInstance().registerSwitch(PbNormalLikeButtonSwitch.class);
            SwitchManager.getInstance().registerSwitch(TencentMMSwitch.class);
            SwitchManager.getInstance().registerSwitch(VCacheSwitch.class);
            SwitchManager.getInstance().registerSwitch(PageStayDurationSwitch.class);
            SwitchManager.getInstance().registerSwitch(PluginClassChangeSwitch.class);
            SwitchManager.getInstance().registerSwitch(UseNewMethodCheckLogoSwitch.class);
            SwitchManager.getInstance().registerSwitch(UseHttpdnsSdkSwitch.class);
            SwitchManager.getInstance().registerSwitch(a.class);
            SwitchManager.getInstance().registerSwitch(RepostToDynamicDefaultSwitch.class);
            SwitchManager.getInstance().registerSwitch(PbPreloadSwitch.class);
            SwitchManager.getInstance().registerSwitch(FlutterSignAllEnableSwitch.class);
            SwitchManager.getInstance().registerSwitch(FlutterPersonAttentionEnableSwitch.class);
            SwitchManager.getInstance().registerSwitch(FlutterForumDetailEnableSwitch.class);
            SwitchManager.getInstance().registerSwitch(FlutterMyTabEnableSwitch.class);
            SwitchManager.getInstance().registerSwitch(NativeCrashHandler.class);
            SwitchManager.getInstance().registerSwitch(FlutterConcernForumEnableSwitch.class);
            SwitchManager.getInstance().registerSwitch(FlutterAttachSwitch.class);
            SwitchManager.getInstance().registerSwitch(XiaomiWebViewInitSwitch.class);
            SwitchManager.getInstance().registerSwitch(FlutterPersonCenterEnableSwitch.class);
            SwitchManager.getInstance().registerSwitch(FlutterCrashRepairEnableSwitch.class);
            SwitchManager.getInstance().registerSwitch(FunAdSdkSwitch.class);
            SwitchManager.getInstance().registerSwitch(FlutterCrabReportEnableSwitch.class);
            SwitchManager.getInstance().registerSwitch(FlutterLifeCycleBugEnableSwitch.class);
            SwitchManager.getInstance().registerSwitch(UseHttpAutoRetrySwitch.class);
            SwitchManager.getInstance().registerSwitch(OpenJsSdkSwitch.class);
            SwitchManager.getInstance().registerSwitch(LimitLowQualityPicUploadSwitch.class);
            SwitchManager.getInstance().registerSwitch(PicReqSwitch.class);
            SwitchManager.getInstance().registerSwitch(WorkIntroSwitch.class);
            SwitchManager.getInstance().registerSwitch(CreateCenterTipSwitch.class);
            SwitchManager.getInstance().registerSwitch(FollowListSwitch.class);
            SwitchManager.getInstance().registerSwitch(SplashDealyTimeoutSwitch.class);
            SwitchManager.getInstance().registerSwitch(IColorSDKSwitch.class);
            SwitchManager.getInstance().registerSwitch(VideoMiddleAdSwitch.class);
            SwitchManager.getInstance().registerSwitch(GdtPrivacySwitch.class);
            SwitchManager.getInstance().registerSwitch(KsPrivacySwitch.class);
            SwitchManager.getInstance().registerSwitch(c.class);
            SwitchManager.getInstance().registerSwitch(CsjPrivacySwitch.class);
            SwitchManager.getInstance().registerSwitch(FunAdServerRecordSwitch.class);
            SwitchManager.getInstance().registerSwitch(FunAdSplashClickRegionSwitch.class);
            SwitchManager.getInstance().registerSwitch(WeChatShareSmallAppToH5Switch.class);
            SwitchManager.getInstance().registerSwitch(QqShareH5Switch.class);
            SwitchManager.getInstance().registerSwitch(WorkAddTopicSwitch.class);
            SwitchManager.getInstance().registerSwitch(UploadPicParallelSwitch.class);
            SwitchManager.getInstance().registerSwitch(AdSaleSpreadSwitch.class);
            SwitchManager.getInstance().registerSwitch(AndroidActivityLogSwitch.class);
        }
    }
}

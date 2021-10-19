package com.baidu.tieba.flutter.plugin.tiebautility.android;

import android.text.TextUtils;
import android.view.KeyEvent;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.a0.b;
import c.a.q0.s.q.l1;
import c.a.q0.s.q.n2;
import c.a.r0.a3.a;
import c.a.r0.k3.i0.e;
import c.a.r0.k3.r0.g;
import c.a.r0.k3.r0.k;
import c.a.r0.k3.x;
import com.alibaba.fastjson.parser.JSONLexer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.VideoNotifyPersonalPageData;
import com.baidu.tbadk.core.data.WorkPostNotifyFlutterData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.httpNet.NetWorkParam;
import com.baidu.tbadk.coreExtra.message.ShareSDKResultMessage;
import com.baidu.tbadk.data.UserPendantData;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityNotificationAuto;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.maxicode.decoder.DecodedBitStreamParser;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.CharUtils;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class NativeListeners {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int NEW_CATEGORY_FORUM = 2;
    public static final int TAB_ENTER_FORUM = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public final String AccountInfoUpdated;
    public final String AnimateToBarEntryForumSquare;
    public final String AppDidBecomeActive;
    public final String AppDidEnterBackground;
    public final String AutoRefreshBarEntry;
    public final String AutoRefreshCategory;
    public final String BarBroadcastCopyLink;
    public final String BookMarkUpdate;
    public final String ChangePendantImage;
    public final String ChangePortraitImage;
    public final String ChangeUserProfile;
    public final String ChangeUserProfileBackground;
    public final String FansCountUpdate;
    public final String KTBShareNumberPlus;
    public final String LikeForumsSign;
    public final String MultiRemoveBlockFans;
    public final String PersonDataChangedNotification;
    public final String ServiceCenterCheck;
    public final String ServiceCenterUpdate;
    public final String SyncComplete;
    public final String ThreadAgreeChanged;
    public final String ThreadWriteReplyListener;
    public final String VolumeUpOnKeyDownNotification;
    public final String WritePostSuccess;
    public final CustomMessageListener bookMarksGiftAndFansListener;
    public CustomMessageListener checkFeedBackListener;
    public CustomMessageListener feedBackRedTipListener;
    public final String kSendVideoWorkStatus;
    public final String kSendWorkBackToFlutter;
    public final String kTBCBroadcastEdditPageResume;
    public final String kTBCBroadcastPublishSuccess;
    public final String kTBCCancleLikeFrsNotification;
    public final String kTBCDeleteFrsSection;
    public final String kTBCFlutterUpgradeVideoAccountStatusNotification;
    public final String kTBCLikeForumsInfoDeletedNotification;
    public final String kTBCLikeForumsInfoUpdateNotification;
    public final String kTBCPersonalCenterRefreshDataNotification;
    public final String kTBCShareSdkResultNotification;
    public final String kUIApplicationEnterPersonalCenterByClickNotification;
    public final String kUIApplicationSwitchTabNotification;
    public final String kUpdateVideoWorkProgressNotification;
    public CustomMessageListener mAccountChangedListener;
    public CustomMessageListener mAnimateToBarEntryForumSquare;
    public CustomMessageListener mBackgroundListener;
    public CustomMessageListener mBgRefreshListener;
    public HttpMessageListener mChangePortraitListener;
    public final CustomMessageListener mCopyBarBroadcastLinkListener;
    public TiebaUtilityNotificationAuto.FlutterUtilityNotification mFlutterNotification;
    public int mLastMainTabIndex;
    public CustomMessageListener mMainTabClickListener;
    public CustomMessageListener mPersonDataChangedListener;
    public HttpMessageListener mRemoveForbiddenListener;
    public HttpMessageListener mResetUserPicsListener;
    public CustomMessageListener mSendPrePageKeyToFlutterWhenTabChangedListener;
    public CustomMessageListener mSendPrePageKeyToPersonCenterFlutterPage;
    public CustomMessageListener mSendWorkBackToPersonCenter;
    public final CustomMessageListener mSignChangedListener;
    public CustomMessageListener mThreadAgreeChangedListener;
    public CustomMessageListener mThreadWriteReplyListener;
    public CustomMessageListener mUpdatePendantListener;
    public CustomMessageListener mUpdateShareNumListener;
    public CustomMessageListener mVideoNotifyPersonalPage;
    public CustomMessageListener mVideoUpgradeListener;
    public CustomMessageListener mVolumeUpOnKeyDownListener;
    public CustomMessageListener mWorkPostProgress;
    public CustomMessageListener mWorkPostStatus;
    public CustomMessageListener mWritePostSuccessListener;
    public CustomMessageListener memberCenterRedTipListener;
    public final String reportFlutterDebugData;
    public CustomMessageListener syncFinishListener;

    public NativeListeners() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mLastMainTabIndex = -1;
        this.MultiRemoveBlockFans = "MultiRemoveBlockFans";
        this.AppDidEnterBackground = "AppDidEnterBackground";
        this.AppDidBecomeActive = "AppDidBecomeActive";
        this.reportFlutterDebugData = "reportFlutterDebugData";
        this.BookMarkUpdate = "BookMarkUpdate";
        this.FansCountUpdate = "FansCountUpdate";
        this.ServiceCenterUpdate = "ServiceCenterUpdate";
        this.SyncComplete = "SyncComplete";
        this.ServiceCenterCheck = "ServiceCenterCheck";
        this.LikeForumsSign = "LikeForumsSign";
        this.BarBroadcastCopyLink = "BarBroadcastCopyLink";
        this.ThreadAgreeChanged = "ThreadAgreeChanged";
        this.ChangePortraitImage = "ChangePortraitImage";
        this.ChangePendantImage = "ChangePendantImage";
        this.ChangeUserProfile = "ChangeUserProfile";
        this.ChangeUserProfileBackground = "ChangeUserProfileBackground";
        this.kTBCLikeForumsInfoUpdateNotification = "kTBCLikeForumsInfoUpdateNotification";
        this.kTBCLikeForumsInfoDeletedNotification = "kTBCLikeForumsInfoDeletedNotification";
        this.kTBCShareSdkResultNotification = "kTBCShareSdkResultNotification";
        this.kTBCCancleLikeFrsNotification = "kTBCCancleLikeFrsNotification";
        this.PersonDataChangedNotification = "PersonDataChangedNotification";
        this.KTBShareNumberPlus = "KTBShareNumberPlus";
        this.ThreadWriteReplyListener = "ThreadWriteReplyListener";
        this.kTBCDeleteFrsSection = "kTBCDeleteFrsSection";
        this.kTBCBroadcastPublishSuccess = "kTBCBroadcastPublishSuccess";
        this.kTBCBroadcastEdditPageResume = "kTBCBroadcastEdditPageResume";
        this.AutoRefreshBarEntry = "AutoRefreshBarEntry";
        this.WritePostSuccess = "WritePostSuccess";
        this.AutoRefreshCategory = "AutoRefreshCategory";
        this.AccountInfoUpdated = "AccountInfoUpdated";
        this.kUIApplicationEnterPersonalCenterByClickNotification = "kUIApplicationEnterPersonalCenterByClickNotification";
        this.kUIApplicationSwitchTabNotification = "kUIApplicationSwitchTabNotification";
        this.AnimateToBarEntryForumSquare = "AnimateToBarEntryForumSquare";
        this.VolumeUpOnKeyDownNotification = "VolumeUpOnKeyDownNotification";
        this.kUpdateVideoWorkProgressNotification = "UpdateThreadProgress";
        this.kSendWorkBackToFlutter = "SendWorkBackToFlutter";
        this.kSendVideoWorkStatus = "SendVideoWorkStatus";
        this.kTBCPersonalCenterRefreshDataNotification = "kTBCPersonalCenterRefreshDataNotification";
        this.kTBCFlutterUpgradeVideoAccountStatusNotification = "kTBCFlutterUpgradeVideoAccountStatusNotification";
        this.mVolumeUpOnKeyDownListener = new CustomMessageListener(this, 2921381) { // from class: com.baidu.tieba.flutter.plugin.tiebautility.android.NativeListeners.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NativeListeners this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("keyValue", 24);
                        this.this$0.notifyFlutter("VolumeUpOnKeyDownNotification", null, hashMap);
                    }
                }
            }
        };
        this.bookMarksGiftAndFansListener = new CustomMessageListener(this, 2001120) { // from class: com.baidu.tieba.flutter.plugin.tiebautility.android.NativeListeners.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NativeListeners this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                    return;
                }
                if (a.v().B()) {
                    this.this$0.notifyFlutter("FansCountUpdate", null, null);
                } else if (a.v().A()) {
                    this.this$0.notifyFlutter("BookMarkUpdate", null, null);
                }
            }
        };
        this.mSignChangedListener = new CustomMessageListener(this, 2001222) { // from class: com.baidu.tieba.flutter.plugin.tiebautility.android.NativeListeners.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NativeListeners this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                SignData signData;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof SignData) || (signData = (SignData) customResponsedMessage.getData()) == null) {
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put(TbTitleActivityConfig.FORUM_ID, signData.forumId);
                hashMap.put("signFlag", String.valueOf(signData.is_signed));
                this.this$0.notifyFlutter("LikeForumsSign", hashMap, null);
            }
        };
        this.mCopyBarBroadcastLinkListener = new CustomMessageListener(this, 2921472) { // from class: com.baidu.tieba.flutter.plugin.tiebautility.android.NativeListeners.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NativeListeners this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                String str;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) || (str = (String) customResponsedMessage.getData()) == null) {
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put(ForumBroadcastHelper.KEY_PARMARS_BCAST_THREADLINK, str);
                this.this$0.notifyFlutter("BarBroadcastCopyLink", null, hashMap);
            }
        };
        this.mRemoveForbiddenListener = new HttpMessageListener(this, CmdConfigHttp.CMD_REMOVE_ALL_FORBIDDEN_FANS) { // from class: com.baidu.tieba.flutter.plugin.tiebautility.android.NativeListeners.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NativeListeners this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, httpResponsedMessage) == null) || httpResponsedMessage == null) {
                    return;
                }
                this.this$0.notifyFlutter("MultiRemoveBlockFans", null, null);
            }
        };
        this.mAccountChangedListener = new CustomMessageListener(this, 2001247) { // from class: com.baidu.tieba.flutter.plugin.tiebautility.android.NativeListeners.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NativeListeners this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001247) {
                    this.this$0.notifyFlutter("AccountInfoUpdated", null, null);
                }
            }
        };
        this.mBackgroundListener = new CustomMessageListener(this, 2001011) { // from class: com.baidu.tieba.flutter.plugin.tiebautility.android.NativeListeners.9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NativeListeners this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof BackgroundSwitchMessage)) {
                    boolean booleanValue = ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                    if (booleanValue) {
                        try {
                            if (booleanValue == UtilHelper.isAppForeground()) {
                                return;
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2);
                        }
                    }
                    if (booleanValue) {
                        this.this$0.notifyFlutter("AppDidEnterBackground", null, null);
                    } else {
                        this.this$0.notifyFlutter("AppDidBecomeActive", null, null);
                    }
                }
            }
        };
        this.feedBackRedTipListener = new CustomMessageListener(this, 2016561) { // from class: com.baidu.tieba.flutter.plugin.tiebautility.android.NativeListeners.10
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NativeListeners this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    this.this$0.notifyFlutter("ServiceCenterUpdate", null, null);
                }
            }
        };
        this.memberCenterRedTipListener = new CustomMessageListener(this, 2016459) { // from class: com.baidu.tieba.flutter.plugin.tiebautility.android.NativeListeners.11
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NativeListeners this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    this.this$0.notifyFlutter("ServiceCenterUpdate", null, null);
                }
            }
        };
        this.checkFeedBackListener = new CustomMessageListener(this, 2016560) { // from class: com.baidu.tieba.flutter.plugin.tiebautility.android.NativeListeners.12
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NativeListeners this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2016560) {
                    this.this$0.notifyFlutter("ServiceCenterCheck", null, null);
                }
            }
        };
        this.syncFinishListener = new CustomMessageListener(this, 2001371) { // from class: com.baidu.tieba.flutter.plugin.tiebautility.android.NativeListeners.13
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NativeListeners this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) {
                    this.this$0.notifyFlutter("SyncComplete", null, null);
                }
            }
        };
        this.mThreadAgreeChangedListener = new CustomMessageListener(this, 2016528) { // from class: com.baidu.tieba.flutter.plugin.tiebautility.android.NativeListeners.14
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NativeListeners this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AgreeData agreeData;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof e) || (agreeData = ((e) customResponsedMessage.getData()).f21031b) == null) {
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("nid", agreeData.nid);
                hashMap.put("tid", agreeData.threadId);
                hashMap.put("agreeType", String.valueOf(agreeData.agreeType));
                hashMap.put("hasAgree", agreeData.hasAgree ? "1" : "0");
                hashMap.put("diffAgreeNum", String.valueOf(agreeData.diffAgreeNum));
                hashMap.put("agreeNum", String.valueOf(agreeData.agreeNum));
                hashMap.put("disAgreeNum", String.valueOf(agreeData.disAgreeNum));
                this.this$0.notifyFlutter("ThreadAgreeChanged", null, hashMap);
            }
        };
        this.mChangePortraitListener = new HttpMessageListener(this, CmdConfigHttp.CMD_CHANGE_PORTRAIT) { // from class: com.baidu.tieba.flutter.plugin.tiebautility.android.NativeListeners.15
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NativeListeners this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, httpResponsedMessage) == null) || httpResponsedMessage == null) {
                    return;
                }
                this.this$0.notifyFlutter("ChangePortraitImage", null, null);
            }
        };
        this.mResetUserPicsListener = new HttpMessageListener(this, CmdConfigHttp.CMD_SET_USER_PICS) { // from class: com.baidu.tieba.flutter.plugin.tiebautility.android.NativeListeners.16
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NativeListeners this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, httpResponsedMessage) == null) || httpResponsedMessage == null) {
                    return;
                }
                this.this$0.notifyFlutter("ChangePendantImage", null, null);
            }
        };
        this.mUpdatePendantListener = new CustomMessageListener(this, 2016485) { // from class: com.baidu.tieba.flutter.plugin.tiebautility.android.NativeListeners.17
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NativeListeners this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserPendantData)) {
                    this.this$0.notifyFlutter("ChangeUserProfile", null, null);
                }
            }
        };
        this.mBgRefreshListener = new CustomMessageListener(this, 2921004) { // from class: com.baidu.tieba.flutter.plugin.tiebautility.android.NativeListeners.18
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NativeListeners this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) {
                    this.this$0.notifyFlutter("ChangeUserProfileBackground", null, null);
                }
            }
        };
        this.mPersonDataChangedListener = new CustomMessageListener(this, 2001380) { // from class: com.baidu.tieba.flutter.plugin.tiebautility.android.NativeListeners.19
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NativeListeners this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) {
                    this.this$0.notifyFlutter("PersonDataChangedNotification", null, null);
                }
            }
        };
        this.mWritePostSuccessListener = new CustomMessageListener(this, 2001375) { // from class: com.baidu.tieba.flutter.plugin.tiebautility.android.NativeListeners.20
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NativeListeners this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) {
                    this.this$0.notifyFlutter("WritePostSuccess", null, null);
                }
            }
        };
        this.mUpdateShareNumListener = new CustomMessageListener(this, 2921417) { // from class: com.baidu.tieba.flutter.plugin.tiebautility.android.NativeListeners.21
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NativeListeners this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof String)) {
                    return;
                }
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("tid", str);
                this.this$0.notifyFlutter("KTBShareNumberPlus", null, hashMap);
            }
        };
        this.mThreadWriteReplyListener = new CustomMessageListener(this, 2921344) { // from class: com.baidu.tieba.flutter.plugin.tiebautility.android.NativeListeners.22
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NativeListeners this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) {
                    HashMap hashMap = new HashMap();
                    if (customResponsedMessage.getData() instanceof NetWorkParam) {
                        NetWorkParam netWorkParam = (NetWorkParam) customResponsedMessage.getData();
                        if (!ListUtils.isEmpty(netWorkParam.mPostData)) {
                            for (int i4 = 0; i4 < netWorkParam.mPostData.size(); i4++) {
                                if (netWorkParam.mPostData.get(i4) != null) {
                                    hashMap.put(netWorkParam.mPostData.get(i4).getName(), netWorkParam.mPostData.get(i4).getValue());
                                }
                            }
                        }
                    }
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("tid", hashMap.get("tid"));
                    hashMap2.put("nid", hashMap.get("ori_ugc_nid"));
                    this.this$0.notifyFlutter("ThreadWriteReplyListener", null, hashMap2);
                }
            }
        };
        this.mMainTabClickListener = new CustomMessageListener(this, 2001384) { // from class: com.baidu.tieba.flutter.plugin.tiebautility.android.NativeListeners.23
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NativeListeners this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                    Integer num = (Integer) customResponsedMessage.getData();
                    if (num.intValue() == 1 && this.this$0.mLastMainTabIndex == 1) {
                        this.this$0.notifyFlutter("AutoRefreshBarEntry", null, null);
                    } else if (num.intValue() == 2 && this.this$0.mLastMainTabIndex == 2) {
                        this.this$0.notifyFlutter("AutoRefreshCategory", null, null);
                    }
                    this.this$0.mLastMainTabIndex = num.intValue();
                }
            }
        };
        this.mSendPrePageKeyToFlutterWhenTabChangedListener = new CustomMessageListener(this, 2921520) { // from class: com.baidu.tieba.flutter.plugin.tiebautility.android.NativeListeners.24
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NativeListeners this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String) || StringUtil.isEmpty((String) customResponsedMessage.getData())) {
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put(TiebaStatic.Params.OBJ_PRE_PAGE, (String) customResponsedMessage.getData());
                this.this$0.notifyFlutter("kUIApplicationSwitchTabNotification", null, hashMap);
            }
        };
        this.mAnimateToBarEntryForumSquare = new CustomMessageListener(this, 2921528) { // from class: com.baidu.tieba.flutter.plugin.tiebautility.android.NativeListeners.25
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NativeListeners this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                    return;
                }
                b.f13758c = b.f13759d;
                this.this$0.notifyFlutter("AnimateToBarEntryForumSquare", null, null);
            }
        };
        this.mSendPrePageKeyToPersonCenterFlutterPage = new CustomMessageListener(this, 2921521) { // from class: com.baidu.tieba.flutter.plugin.tiebautility.android.NativeListeners.26
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NativeListeners this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String) || StringUtil.isEmpty((String) customResponsedMessage.getData())) {
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put(TiebaStatic.Params.OBJ_PRE_PAGE, (String) customResponsedMessage.getData());
                this.this$0.notifyFlutter("kUIApplicationEnterPersonalCenterByClickNotification", null, hashMap);
            }
        };
        this.mWorkPostProgress = new CustomMessageListener(this, 2921526) { // from class: com.baidu.tieba.flutter.plugin.tiebautility.android.NativeListeners.27
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NativeListeners this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                l1 l1Var;
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof l1) && (l1Var = (l1) customResponsedMessage.getData()) != null && l1Var.e() && g.j().h() == null) {
                    this.this$0.notifyFlutter("UpdateThreadProgress", null, null);
                }
            }
        };
        this.mWorkPostStatus = new CustomMessageListener(this, 2921592) { // from class: com.baidu.tieba.flutter.plugin.tiebautility.android.NativeListeners.28
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NativeListeners this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                WorkPostNotifyFlutterData workPostNotifyFlutterData;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof WorkPostNotifyFlutterData) || (workPostNotifyFlutterData = (WorkPostNotifyFlutterData) customResponsedMessage.getData()) == null) {
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("status", workPostNotifyFlutterData.f47448a);
                hashMap.put("videoId", workPostNotifyFlutterData.f47449b);
                hashMap.put("errorMessage", workPostNotifyFlutterData.f47450c);
                hashMap.put("fid", workPostNotifyFlutterData.b());
                hashMap.put("fname", workPostNotifyFlutterData.c());
                hashMap.put("videoItem", workPostNotifyFlutterData.d());
                hashMap.put("pageId", workPostNotifyFlutterData.a());
                this.this$0.notifyFlutter("SendVideoWorkStatus", null, hashMap);
            }
        };
        this.mSendWorkBackToPersonCenter = new CustomMessageListener(this, 2921625) { // from class: com.baidu.tieba.flutter.plugin.tiebautility.android.NativeListeners.29
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NativeListeners this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof n2)) {
                    return;
                }
                n2 n2Var = (n2) customResponsedMessage.getData();
                HashMap hashMap = new HashMap();
                if (n2Var.f14294a) {
                    hashMap.put(PersonInfoActivityConfig.IS_SHOW_PROGRESS, "1");
                } else {
                    hashMap.put(PersonInfoActivityConfig.IS_SHOW_PROGRESS, "0");
                }
                hashMap.put("pageId", n2Var.f14295b);
                this.this$0.notifyFlutter("SendWorkBackToFlutter", null, hashMap);
            }
        };
        this.mVideoNotifyPersonalPage = new CustomMessageListener(this, 2921623) { // from class: com.baidu.tieba.flutter.plugin.tiebautility.android.NativeListeners.30
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NativeListeners this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                VideoNotifyPersonalPageData videoNotifyPersonalPageData;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof VideoNotifyPersonalPageData) || (videoNotifyPersonalPageData = (VideoNotifyPersonalPageData) customResponsedMessage.getData()) == null) {
                    return;
                }
                this.this$0.notifyFlutter("kTBCPersonalCenterRefreshDataNotification", null, new HashMap(DataExt.h(videoNotifyPersonalPageData)));
            }
        };
        this.mVideoUpgradeListener = new CustomMessageListener(this, 2921624) { // from class: com.baidu.tieba.flutter.plugin.tiebautility.android.NativeListeners.31
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NativeListeners this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    this.this$0.notifyFlutter("kTBCFlutterUpgradeVideoAccountStatusNotification", null, null);
                }
            }
        };
    }

    private void dealBeforeAttachNotification(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, this, str) == null) && "AnimateToBarEntryForumSquare".equals(str) && b.f13758c == b.f13760e) {
            c.a.e.e.m.e.a().postDelayed(new Runnable(this) { // from class: com.baidu.tieba.flutter.plugin.tiebautility.android.NativeListeners.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ NativeListeners this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921528));
                    }
                }
            }, 300L);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private MessageListener<?> getListererFromKey(String str) {
        InterceptResult invokeL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str)) == null) {
            switch (str.hashCode()) {
                case -2135388668:
                    if (str.equals("WritePostSuccess")) {
                        c2 = 18;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -2111678678:
                    if (str.equals("AutoRefreshCategory")) {
                        c2 = 20;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -2039579207:
                    if (str.equals("kTBCFlutterUpgradeVideoAccountStatusNotification")) {
                        c2 = DecodedBitStreamParser.GS;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1967337156:
                    if (str.equals("ChangeUserProfileBackground")) {
                        c2 = CharUtils.CR;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1702113870:
                    if (str.equals("ThreadAgreeChanged")) {
                        c2 = '\t';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -994250872:
                    if (str.equals("AppDidEnterBackground")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -815635840:
                    if (str.equals("PersonDataChangedNotification")) {
                        c2 = 14;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -739728061:
                    if (str.equals("AnimateToBarEntryForumSquare")) {
                        c2 = 23;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -712625697:
                    if (str.equals("BookMarkUpdate")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -634080138:
                    if (str.equals("SendVideoWorkStatus")) {
                        c2 = JSONLexer.EOI;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -336540695:
                    if (str.equals("ThreadWriteReplyListener")) {
                        c2 = 16;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -241869128:
                    if (str.equals("FansCountUpdate")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -213083375:
                    if (str.equals("kTBCPersonalCenterRefreshDataNotification")) {
                        c2 = DecodedBitStreamParser.FS;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 79574153:
                    if (str.equals("KTBShareNumberPlus")) {
                        c2 = 15;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 215365908:
                    if (str.equals("SyncComplete")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 220510267:
                    if (str.equals("kUIApplicationSwitchTabNotification")) {
                        c2 = 21;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 353880651:
                    if (str.equals("AutoRefreshBarEntry")) {
                        c2 = 17;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 401543534:
                    if (str.equals("ChangeUserProfile")) {
                        c2 = '\f';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 438746368:
                    if (str.equals("kUIApplicationEnterPersonalCenterByClickNotification")) {
                        c2 = 22;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 463822814:
                    if (str.equals("ServiceCenterCheck")) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 483157862:
                    if (str.equals("LikeForumsSign")) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 541940592:
                    if (str.equals("MultiRemoveBlockFans")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 757688464:
                    if (str.equals("ChangePortraitImage")) {
                        c2 = '\n';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 790383375:
                    if (str.equals("ChangePendantImage")) {
                        c2 = 11;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1111371169:
                    if (str.equals("SendWorkBackToFlutter")) {
                        c2 = 27;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1449078688:
                    if (str.equals("UpdateThreadProgress")) {
                        c2 = 25;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1499680061:
                    if (str.equals("BarBroadcastCopyLink")) {
                        c2 = '\b';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1599848416:
                    if (str.equals("AccountInfoUpdated")) {
                        c2 = 19;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1714732632:
                    if (str.equals("VolumeUpOnKeyDownNotification")) {
                        c2 = 24;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2016286899:
                    if (str.equals("ServiceCenterUpdate")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    this.mRemoveForbiddenListener.setPriority(Integer.MAX_VALUE);
                    return this.mRemoveForbiddenListener;
                case 1:
                    this.mBackgroundListener.setPriority(Integer.MAX_VALUE);
                    return this.mBackgroundListener;
                case 2:
                case 3:
                    this.bookMarksGiftAndFansListener.setPriority(Integer.MAX_VALUE);
                    return this.bookMarksGiftAndFansListener;
                case 4:
                    this.feedBackRedTipListener.setPriority(Integer.MAX_VALUE);
                    return this.feedBackRedTipListener;
                case 5:
                    this.syncFinishListener.setPriority(Integer.MAX_VALUE);
                    return this.syncFinishListener;
                case 6:
                    this.checkFeedBackListener.setPriority(Integer.MAX_VALUE);
                    return this.checkFeedBackListener;
                case 7:
                    this.mSignChangedListener.setPriority(Integer.MAX_VALUE);
                    return this.mSignChangedListener;
                case '\b':
                    this.mCopyBarBroadcastLinkListener.setPriority(Integer.MAX_VALUE);
                    return this.mCopyBarBroadcastLinkListener;
                case '\t':
                    return this.mThreadAgreeChangedListener;
                case '\n':
                    return this.mChangePortraitListener;
                case 11:
                    return this.mResetUserPicsListener;
                case '\f':
                    return this.mUpdatePendantListener;
                case '\r':
                    return this.mBgRefreshListener;
                case 14:
                    return this.mPersonDataChangedListener;
                case 15:
                    return this.mUpdateShareNumListener;
                case 16:
                    return this.mThreadWriteReplyListener;
                case 17:
                    if (this.mLastMainTabIndex == -1) {
                        this.mLastMainTabIndex = 1;
                    }
                    return this.mMainTabClickListener;
                case 18:
                    return this.mWritePostSuccessListener;
                case 19:
                    return this.mAccountChangedListener;
                case 20:
                    if (this.mLastMainTabIndex == -1) {
                        this.mLastMainTabIndex = 2;
                    }
                    return this.mMainTabClickListener;
                case 21:
                    return this.mSendPrePageKeyToFlutterWhenTabChangedListener;
                case 22:
                    return this.mSendPrePageKeyToPersonCenterFlutterPage;
                case 23:
                    return this.mAnimateToBarEntryForumSquare;
                case 24:
                    return this.mVolumeUpOnKeyDownListener;
                case 25:
                    return this.mWorkPostProgress;
                case 26:
                    return this.mWorkPostStatus;
                case 27:
                    return this.mSendWorkBackToPersonCenter;
                case 28:
                    return this.mVideoNotifyPersonalPage;
                case 29:
                    return this.mVideoUpgradeListener;
                default:
                    return null;
            }
        }
        return (MessageListener) invokeL.objValue;
    }

    private Message getMessageFromName(String str, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, str, obj)) == null) {
            if (((str.hashCode() == 406924293 && str.equals("kTBCCancleLikeFrsNotification")) ? (char) 0 : (char) 65535) != 0) {
                return null;
            }
            Object argument = argument(obj, "payload");
            if (argument instanceof String) {
                return new CustomMessage(2003004, (String) argument);
            }
            return null;
        }
        return (Message) invokeLL.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private ResponsedMessage getResponsedMessageFromName(String str, Object obj) {
        InterceptResult invokeLL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, this, str, obj)) == null) {
            switch (str.hashCode()) {
                case -1789920843:
                    if (str.equals("kTBCBroadcastEdditPageResume")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1017654699:
                    if (str.equals("kTBCLikeForumsInfoUpdateNotification")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 332172237:
                    if (str.equals("kTBCShareSdkResultNotification")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 558131307:
                    if (str.equals("kTBCBroadcastPublishSuccess")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1749524275:
                    if (str.equals("kTBCDeleteFrsSection")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1973571011:
                    if (str.equals("kTBCLikeForumsInfoDeletedNotification")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 == 0) {
                String str2 = (String) argument(obj, "payload");
                x xVar = new x();
                xVar.s(str2);
                xVar.v(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, xVar));
                k kVar = new k();
                kVar.f21309a = c.a.e.e.m.b.g(str2, 0L);
                kVar.f21310b = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001437, kVar));
                return null;
            } else if (c2 == 1) {
                String str3 = (String) argument(obj, "payload");
                x xVar2 = new x();
                xVar2.s(str3);
                xVar2.v(0);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, xVar2));
                MessageManager.getInstance().sendMessage(new CustomMessage(2003004, str3));
                return null;
            } else if (c2 == 2) {
                Object argument = argument(obj, "payload");
                if (argument instanceof Boolean) {
                    return new ShareSDKResultMessage(Boolean.valueOf(((Boolean) argument).booleanValue()));
                }
                return null;
            } else if (c2 == 3) {
                Object argument2 = argument(obj, "payload");
                if (argument2 instanceof Integer) {
                    return new CustomResponsedMessage(2921470, Integer.valueOf(((Integer) argument2).intValue()));
                }
                return null;
            } else if (c2 == 4) {
                Object argument3 = argument(obj, "payload");
                if (argument3 instanceof Map) {
                    return new CustomResponsedMessage(2921477, (Map) argument3);
                }
                return null;
            } else if (c2 != 5) {
                return null;
            } else {
                Object argument4 = argument(obj, "payload");
                if (argument4 instanceof Integer) {
                    return new CustomResponsedMessage(2921478, Integer.valueOf(((Integer) argument4).intValue()));
                }
                return null;
            }
        }
        return (ResponsedMessage) invokeLL.objValue;
    }

    public void addFlutterNotification(TiebaUtilityNotificationAuto.FlutterUtilityNotification flutterUtilityNotification) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, flutterUtilityNotification) == null) {
            this.mFlutterNotification = flutterUtilityNotification;
        }
    }

    public void addNotificationObserver(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            MessageListener<?> listererFromKey = getListererFromKey(str);
            if (listererFromKey != null) {
                MessageManager.getInstance().registerListener(listererFromKey);
            }
            dealBeforeAttachNotification(str);
        }
    }

    public <T> T argument(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, obj, str)) == null) {
            if (obj == null) {
                return null;
            }
            try {
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            if (obj instanceof Map) {
                return (T) ((Map) obj).get(str);
            }
            if (obj instanceof JSONObject) {
                return (T) ((JSONObject) obj).opt(str);
            }
            return null;
        }
        return (T) invokeLL.objValue;
    }

    public void notifyFlutter(String str, HashMap hashMap, HashMap hashMap2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, hashMap, hashMap2) == null) {
            TiebaUtilityNotificationAuto.OnNotifyData onNotifyData = new TiebaUtilityNotificationAuto.OnNotifyData();
            onNotifyData.setUniqueKey(str);
            onNotifyData.setObject(hashMap);
            onNotifyData.setData(hashMap2);
            TiebaUtilityNotificationAuto.FlutterUtilityNotification flutterUtilityNotification = this.mFlutterNotification;
            if (flutterUtilityNotification != null) {
                flutterUtilityNotification.onNotification(onNotifyData, new TiebaUtilityNotificationAuto.FlutterUtilityNotification.Reply<TiebaUtilityNotificationAuto.NotifyResult>(this) { // from class: com.baidu.tieba.flutter.plugin.tiebautility.android.NativeListeners.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ NativeListeners this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityNotificationAuto.FlutterUtilityNotification.Reply
                    public void reply(TiebaUtilityNotificationAuto.NotifyResult notifyResult) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, notifyResult) == null) {
                            BdLog.i("notifyFlutter result:" + notifyResult.getResult());
                        }
                    }
                });
            }
        }
    }

    public boolean postNotification(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, hashMap)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Message<?> messageFromName = getMessageFromName(str, hashMap);
            if (messageFromName != null) {
                MessageManager.getInstance().sendMessage(messageFromName);
                return true;
            }
            ResponsedMessage<?> responsedMessageFromName = getResponsedMessageFromName(str, hashMap);
            if (responsedMessageFromName != null) {
                MessageManager.getInstance().dispatchResponsedMessage(responsedMessageFromName);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void removeNotificationObserver(String str) {
        MessageListener<?> listererFromKey;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || (listererFromKey = getListererFromKey(str)) == null) {
            return;
        }
        MessageManager.getInstance().unRegisterListener(listererFromKey);
    }
}

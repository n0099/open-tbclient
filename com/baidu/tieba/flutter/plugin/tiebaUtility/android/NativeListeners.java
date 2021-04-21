package com.baidu.tieba.flutter.plugin.tiebaUtility.android;

import android.text.TextUtils;
import android.view.KeyEvent;
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
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.httpNet.NetWorkParam;
import com.baidu.tbadk.coreExtra.message.ShareSDKResultMessage;
import com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityNotificationAuto;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import d.b.i0.r.a0.b;
import d.b.i0.t.n;
import d.b.j0.d3.h0.e;
import d.b.j0.d3.w;
import d.b.j0.t2.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class NativeListeners {
    public static final int NEW_CATEGORY_FORUM = 2;
    public static final int TAB_ENTER_FORUM = 1;
    public TiebaUtilityNotificationAuto.FlutterUtilityNotification mFlutterNotification;
    public int mLastMainTabIndex = -1;
    public final String MultiRemoveBlockFans = "MultiRemoveBlockFans";
    public final String AppDidEnterBackground = "AppDidEnterBackground";
    public final String AppDidBecomeActive = "AppDidBecomeActive";
    public final String reportFlutterDebugData = "reportFlutterDebugData";
    public final String BookMarkUpdate = "BookMarkUpdate";
    public final String FansCountUpdate = "FansCountUpdate";
    public final String ServiceCenterUpdate = "ServiceCenterUpdate";
    public final String SyncComplete = "SyncComplete";
    public final String ServiceCenterCheck = "ServiceCenterCheck";
    public final String LikeForumsSign = "LikeForumsSign";
    public final String BarBroadcastCopyLink = "BarBroadcastCopyLink";
    public final String ThreadAgreeChanged = "ThreadAgreeChanged";
    public final String ChangePortraitImage = "ChangePortraitImage";
    public final String ChangePendantImage = "ChangePendantImage";
    public final String ChangeUserProfile = "ChangeUserProfile";
    public final String ChangeUserProfileBackground = "ChangeUserProfileBackground";
    public final String kTBCLikeForumsInfoUpdateNotification = "kTBCLikeForumsInfoUpdateNotification";
    public final String kTBCLikeForumsInfoDeletedNotification = "kTBCLikeForumsInfoDeletedNotification";
    public final String kTBCShareSdkResultNotification = "kTBCShareSdkResultNotification";
    public final String kTBCCancleLikeFrsNotification = "kTBCCancleLikeFrsNotification";
    public final String PersonDataChangedNotification = "PersonDataChangedNotification";
    public final String KTBShareNumberPlus = "KTBShareNumberPlus";
    public final String ThreadWriteReplyListener = "ThreadWriteReplyListener";
    public final String kTBCDeleteFrsSection = "kTBCDeleteFrsSection";
    public final String kTBCBroadcastPublishSuccess = "kTBCBroadcastPublishSuccess";
    public final String kTBCBroadcastEdditPageResume = "kTBCBroadcastEdditPageResume";
    public final String AutoRefreshBarEntry = "AutoRefreshBarEntry";
    public final String WritePostSuccess = "WritePostSuccess";
    public final String AutoRefreshCategory = "AutoRefreshCategory";
    public final String AccountInfoUpdated = "AccountInfoUpdated";
    public final String kUIApplicationEnterPersonalCenterByClickNotification = "kUIApplicationEnterPersonalCenterByClickNotification";
    public final String kUIApplicationSwitchTabNotification = "kUIApplicationSwitchTabNotification";
    public final String AnimateToBarEntryForumSquare = "AnimateToBarEntryForumSquare";
    public final String VolumeUpOnKeyDownNotification = "VolumeUpOnKeyDownNotification";
    public CustomMessageListener mVolumeUpOnKeyDownListener = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.flutter.plugin.tiebaUtility.android.NativeListeners.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof KeyEvent)) {
                return;
            }
            KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
            if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                HashMap hashMap = new HashMap();
                hashMap.put("keyValue", 24);
                NativeListeners.this.notifyFlutter("VolumeUpOnKeyDownNotification", null, hashMap);
            }
        }
    };
    public final CustomMessageListener bookMarksGiftAndFansListener = new CustomMessageListener(2001120) { // from class: com.baidu.tieba.flutter.plugin.tiebaUtility.android.NativeListeners.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            if (a.v().B()) {
                NativeListeners.this.notifyFlutter("FansCountUpdate", null, null);
            } else if (a.v().A()) {
                NativeListeners.this.notifyFlutter("BookMarkUpdate", null, null);
            }
        }
    };
    public final CustomMessageListener mSignChangedListener = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.flutter.plugin.tiebaUtility.android.NativeListeners.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            SignData signData;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof SignData) || (signData = (SignData) customResponsedMessage.getData()) == null) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(TbTitleActivityConfig.FORUM_ID, signData.forumId);
            hashMap.put("signFlag", String.valueOf(signData.is_signed));
            NativeListeners.this.notifyFlutter("LikeForumsSign", hashMap, null);
        }
    };
    public final CustomMessageListener mCopyBarBroadcastLinkListener = new CustomMessageListener(2921472) { // from class: com.baidu.tieba.flutter.plugin.tiebaUtility.android.NativeListeners.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String str = (String) customResponsedMessage.getData();
            if (str == null) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(ForumBroadcastHelper.KEY_PARMARS_BCAST_THREADLINK, str);
            NativeListeners.this.notifyFlutter("BarBroadcastCopyLink", null, hashMap);
        }
    };
    public HttpMessageListener mRemoveForbiddenListener = new HttpMessageListener(CmdConfigHttp.CMD_REMOVE_ALL_FORBIDDEN_FANS) { // from class: com.baidu.tieba.flutter.plugin.tiebaUtility.android.NativeListeners.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null) {
                return;
            }
            NativeListeners.this.notifyFlutter("MultiRemoveBlockFans", null, null);
        }
    };
    public CustomMessageListener mAccountChangedListener = new CustomMessageListener(2001247) { // from class: com.baidu.tieba.flutter.plugin.tiebaUtility.android.NativeListeners.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2001247) {
                return;
            }
            NativeListeners.this.notifyFlutter("AccountInfoUpdated", null, null);
        }
    };
    public CustomMessageListener mBackgroundListener = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.flutter.plugin.tiebaUtility.android.NativeListeners.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
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
                    NativeListeners.this.notifyFlutter("AppDidEnterBackground", null, null);
                } else {
                    NativeListeners.this.notifyFlutter("AppDidBecomeActive", null, null);
                }
            }
        }
    };
    public CustomMessageListener feedBackRedTipListener = new CustomMessageListener(2016561) { // from class: com.baidu.tieba.flutter.plugin.tiebaUtility.android.NativeListeners.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            NativeListeners.this.notifyFlutter("ServiceCenterUpdate", null, null);
        }
    };
    public CustomMessageListener memberCenterRedTipListener = new CustomMessageListener(2016459) { // from class: com.baidu.tieba.flutter.plugin.tiebaUtility.android.NativeListeners.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            NativeListeners.this.notifyFlutter("ServiceCenterUpdate", null, null);
        }
    };
    public CustomMessageListener checkFeedBackListener = new CustomMessageListener(2016560) { // from class: com.baidu.tieba.flutter.plugin.tiebaUtility.android.NativeListeners.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016560) {
                NativeListeners.this.notifyFlutter("ServiceCenterCheck", null, null);
            }
        }
    };
    public CustomMessageListener syncFinishListener = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.flutter.plugin.tiebaUtility.android.NativeListeners.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NativeListeners.this.notifyFlutter("SyncComplete", null, null);
        }
    };
    public CustomMessageListener mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.flutter.plugin.tiebaUtility.android.NativeListeners.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof e) || (agreeData = ((e) customResponsedMessage.getData()).f55240b) == null) {
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
            NativeListeners.this.notifyFlutter("ThreadAgreeChanged", null, hashMap);
        }
    };
    public HttpMessageListener mChangePortraitListener = new HttpMessageListener(CmdConfigHttp.CMD_CHANGE_PORTRAIT) { // from class: com.baidu.tieba.flutter.plugin.tiebaUtility.android.NativeListeners.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null) {
                return;
            }
            NativeListeners.this.notifyFlutter("ChangePortraitImage", null, null);
        }
    };
    public HttpMessageListener mResetUserPicsListener = new HttpMessageListener(CmdConfigHttp.CMD_SET_USER_PICS) { // from class: com.baidu.tieba.flutter.plugin.tiebaUtility.android.NativeListeners.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null) {
                return;
            }
            NativeListeners.this.notifyFlutter("ChangePendantImage", null, null);
        }
    };
    public CustomMessageListener mUpdatePendantListener = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.flutter.plugin.tiebaUtility.android.NativeListeners.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof n)) {
                return;
            }
            NativeListeners.this.notifyFlutter("ChangeUserProfile", null, null);
        }
    };
    public CustomMessageListener mBgRefreshListener = new CustomMessageListener(2921004) { // from class: com.baidu.tieba.flutter.plugin.tiebaUtility.android.NativeListeners.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NativeListeners.this.notifyFlutter("ChangeUserProfileBackground", null, null);
        }
    };
    public CustomMessageListener mPersonDataChangedListener = new CustomMessageListener(2001380) { // from class: com.baidu.tieba.flutter.plugin.tiebaUtility.android.NativeListeners.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NativeListeners.this.notifyFlutter("PersonDataChangedNotification", null, null);
        }
    };
    public CustomMessageListener mWritePostSuccessListener = new CustomMessageListener(2001375) { // from class: com.baidu.tieba.flutter.plugin.tiebaUtility.android.NativeListeners.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NativeListeners.this.notifyFlutter("WritePostSuccess", null, null);
        }
    };
    public CustomMessageListener mUpdateShareNumListener = new CustomMessageListener(2921417) { // from class: com.baidu.tieba.flutter.plugin.tiebaUtility.android.NativeListeners.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof String)) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("tid", str);
            NativeListeners.this.notifyFlutter("KTBShareNumberPlus", null, hashMap);
        }
    };
    public CustomMessageListener mThreadWriteReplyListener = new CustomMessageListener(2921344) { // from class: com.baidu.tieba.flutter.plugin.tiebaUtility.android.NativeListeners.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            HashMap hashMap = new HashMap();
            if (customResponsedMessage.getData() instanceof NetWorkParam) {
                NetWorkParam netWorkParam = (NetWorkParam) customResponsedMessage.getData();
                if (!ListUtils.isEmpty(netWorkParam.mPostData)) {
                    for (int i = 0; i < netWorkParam.mPostData.size(); i++) {
                        if (netWorkParam.mPostData.get(i) != null) {
                            hashMap.put(netWorkParam.mPostData.get(i).getName(), netWorkParam.mPostData.get(i).getValue());
                        }
                    }
                }
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("tid", hashMap.get("tid"));
            hashMap2.put("nid", hashMap.get("ori_ugc_nid"));
            NativeListeners.this.notifyFlutter("ThreadWriteReplyListener", null, hashMap2);
        }
    };
    public CustomMessageListener mMainTabClickListener = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.flutter.plugin.tiebaUtility.android.NativeListeners.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            Integer num = (Integer) customResponsedMessage.getData();
            if (num.intValue() == 1 && NativeListeners.this.mLastMainTabIndex == 1) {
                NativeListeners.this.notifyFlutter("AutoRefreshBarEntry", null, null);
            } else if (num.intValue() == 2 && NativeListeners.this.mLastMainTabIndex == 2) {
                NativeListeners.this.notifyFlutter("AutoRefreshCategory", null, null);
            }
            NativeListeners.this.mLastMainTabIndex = num.intValue();
        }
    };
    public CustomMessageListener mSendPrePageKeyToFlutterWhenTabChangedListener = new CustomMessageListener(2921520) { // from class: com.baidu.tieba.flutter.plugin.tiebaUtility.android.NativeListeners.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String) || StringUtil.isEmpty((String) customResponsedMessage.getData())) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(TiebaStatic.Params.OBJ_PRE_PAGE, (String) customResponsedMessage.getData());
            NativeListeners.this.notifyFlutter("kUIApplicationSwitchTabNotification", null, hashMap);
        }
    };
    public CustomMessageListener mAnimateToBarEntryForumSquare = new CustomMessageListener(2921528) { // from class: com.baidu.tieba.flutter.plugin.tiebaUtility.android.NativeListeners.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            b.f51159c = b.f51160d;
            NativeListeners.this.notifyFlutter("AnimateToBarEntryForumSquare", null, null);
        }
    };
    public CustomMessageListener mSendPrePageKeyToPersonCenterFlutterPage = new CustomMessageListener(2921521) { // from class: com.baidu.tieba.flutter.plugin.tiebaUtility.android.NativeListeners.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String) || StringUtil.isEmpty((String) customResponsedMessage.getData())) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(TiebaStatic.Params.OBJ_PRE_PAGE, (String) customResponsedMessage.getData());
            NativeListeners.this.notifyFlutter("kUIApplicationEnterPersonalCenterByClickNotification", null, hashMap);
        }
    };

    private void dealBeforeAttachNotification(String str) {
        if ("AnimateToBarEntryForumSquare".equals(str) && b.f51159c == b.f51161e) {
            d.b.c.e.m.e.a().postDelayed(new Runnable() { // from class: com.baidu.tieba.flutter.plugin.tiebaUtility.android.NativeListeners.2
                @Override // java.lang.Runnable
                public void run() {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921528));
                }
            }, 300L);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private MessageListener<?> getListererFromKey(String str) {
        char c2;
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
            case -1967337156:
                if (str.equals("ChangeUserProfileBackground")) {
                    c2 = '\r';
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
            default:
                return null;
        }
    }

    private Message getMessageFromName(String str, Object obj) {
        if (((str.hashCode() == 406924293 && str.equals("kTBCCancleLikeFrsNotification")) ? (char) 0 : (char) 65535) != 0) {
            return null;
        }
        Object argument = argument(obj, "payload");
        if (argument instanceof String) {
            return new CustomMessage(2003004, (String) argument);
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private ResponsedMessage getResponsedMessageFromName(String str, Object obj) {
        char c2;
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
            w wVar = new w();
            wVar.s(str2);
            wVar.v(1);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, wVar));
            d.b.j0.d3.q0.e eVar = new d.b.j0.d3.q0.e();
            eVar.f55459a = d.b.c.e.m.b.f(str2, 0L);
            eVar.f55460b = true;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001437, eVar));
            return null;
        } else if (c2 == 1) {
            String str3 = (String) argument(obj, "payload");
            w wVar2 = new w();
            wVar2.s(str3);
            wVar2.v(0);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, wVar2));
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

    public void addFlutterNotification(TiebaUtilityNotificationAuto.FlutterUtilityNotification flutterUtilityNotification) {
        this.mFlutterNotification = flutterUtilityNotification;
    }

    public void addNotificationObserver(String str) {
        MessageListener<?> listererFromKey = getListererFromKey(str);
        if (listererFromKey != null) {
            MessageManager.getInstance().registerListener(listererFromKey);
        }
        dealBeforeAttachNotification(str);
    }

    public <T> T argument(Object obj, String str) {
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

    public void notifyFlutter(String str, HashMap hashMap, HashMap hashMap2) {
        TiebaUtilityNotificationAuto.OnNotifyData onNotifyData = new TiebaUtilityNotificationAuto.OnNotifyData();
        onNotifyData.setUniqueKey(str);
        onNotifyData.setObject(hashMap);
        onNotifyData.setData(hashMap2);
        TiebaUtilityNotificationAuto.FlutterUtilityNotification flutterUtilityNotification = this.mFlutterNotification;
        if (flutterUtilityNotification != null) {
            flutterUtilityNotification.onNotification(onNotifyData, new TiebaUtilityNotificationAuto.FlutterUtilityNotification.Reply<TiebaUtilityNotificationAuto.NotifyResult>() { // from class: com.baidu.tieba.flutter.plugin.tiebaUtility.android.NativeListeners.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityNotificationAuto.FlutterUtilityNotification.Reply
                public void reply(TiebaUtilityNotificationAuto.NotifyResult notifyResult) {
                    BdLog.i("notifyFlutter result:" + notifyResult.getResult());
                }
            });
        }
    }

    public boolean postNotification(String str, HashMap hashMap) {
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

    public void removeNotificationObserver(String str) {
        MessageListener<?> listererFromKey = getListererFromKey(str);
        if (listererFromKey != null) {
            MessageManager.getInstance().unRegisterListener(listererFromKey);
        }
    }
}

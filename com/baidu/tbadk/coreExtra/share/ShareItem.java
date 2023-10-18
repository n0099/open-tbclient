package com.baidu.tbadk.coreExtra.share;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tieba.ad;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.data.ShareIMCommonCardData;
import com.baidu.tieba.pea;
import com.baidu.tieba.vx0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ShareItem {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT = 0;
    public static final int FROM_DEFAULT = 0;
    public static final int FROM_MY_THREAD = 2;
    public static final int FROM_PB = 1;
    public static final int FRS_SMALL_APP_SHARE = 2;
    public static final int FRS_SMALL_APP_SHARE_RELOAD = 4;
    public static final String IMAGE_DATA_FILE;
    public static final String KEY_DISK_PIC_OP_FORMATDATA = "formatData";
    public static final String KEY_DISK_PIC_OP_NAME = "name";
    public static final String KEY_DISK_PIC_OP_PAHT = "path";
    public static final String KEY_DISK_PIC_OP_SAVEDCACHE = "isSavedCache";
    public static final String KEY_DISK_PIC_OP_SDCARD = "isSdcard";
    public static final String KEY_DISK_PIC_OP_SUBDIR = "isSubDir";
    public static final int OBJ_LOACTION_CONCERN = 2;
    public static final int OBJ_LOCATION_CHANNEL = 25;
    public static final int OBJ_LOCATION_CRAD_MIDDLE_VIDEO_LANDSCAPE = 12;
    public static final int OBJ_LOCATION_CRAD_MIDDLE_VIDEO_VERTICAL = 19;
    public static final int OBJ_LOCATION_ENTER_FORUM_SQUARE = 20;
    public static final int OBJ_LOCATION_FRS = 4;
    public static final int OBJ_LOCATION_FRS_FORUM = 11;
    public static final int OBJ_LOCATION_FRS_HOT_TAB = 13;
    public static final int OBJ_LOCATION_FRS_VIDEO_TAB = 30;
    public static final int OBJ_LOCATION_GAME_ITEM_DETAIL = 24;
    public static final int OBJ_LOCATION_GAME_VIDEO = 10;
    public static final int OBJ_LOCATION_HOME_DAILY = 9;
    public static final int OBJ_LOCATION_HOT_TOPIC = 27;
    public static final int OBJ_LOCATION_NEW_VIDEO_TAB = 17;
    public static final int OBJ_LOCATION_PB = 5;
    public static final int OBJ_LOCATION_PB_BOTTOM_REC = 26;
    public static final int OBJ_LOCATION_PB_COMMENT = 21;
    public static final int OBJ_LOCATION_PB_EXTRA = 6;
    public static final int OBJ_LOCATION_PB_MORE = 1;
    public static final int OBJ_LOCATION_PB_VIDEO_SHARE = 18;
    public static final int OBJ_LOCATION_PERSON_CENTER = 8;
    public static final int OBJ_LOCATION_RECOMMEND = 3;
    public static final int OBJ_LOCATION_STAMP_DIALOG_SHARE_BTN = 31;
    public static final int OBJ_LOCATION_WRITE_SHARE = 7;
    public static final int OBJ_PARAM_BA_SHARE = 2;
    public static final int OBJ_PARAM_FRS_VIDEO_TAB = 7;
    public static final int OBJ_PARAM_HOT_TOPIC_SHARE = 4;
    public static final int OBJ_PARAM_SCREENSHOT_SHARE = 1;
    public static final int OBJ_PARAM_TIE_SHARE = 3;
    public static final int OBJ_SOURCE_AFTER_PUBLISHER = 15;
    public static final int OBJ_SOURCE_ATTENTION_FEED = 4;
    public static final int OBJ_SOURCE_CHANNEL = 20;
    public static final int OBJ_SOURCE_CRAD_MIDDLE_VIDEO_LANDSCAPE = 11;
    public static final int OBJ_SOURCE_CRAD_MIDDLE_VIDEO_VERTICAL = 12;
    public static final int OBJ_SOURCE_FRS_FEED = 5;
    public static final int OBJ_SOURCE_FRS_HOT = 33;
    public static final int OBJ_SOURCE_FRS_SHARE_BAR = 10;
    public static final int OBJ_SOURCE_GAME_ITEM_DETAIL = 19;
    public static final int OBJ_SOURCE_H5_SHARE = 17;
    public static final int OBJ_SOURCE_HOME_VIDEO_TAB = 16;
    public static final int OBJ_SOURCE_HOT_TOPIC = 30;
    public static final int OBJ_SOURCE_IMAGE_VIEWER = 14;
    public static final int OBJ_SOURCE_LONG_CLICK_MENU = 23;
    public static final int OBJ_SOURCE_PB_BOTTOM_REC = 24;
    public static final int OBJ_SOURCE_PB_BOTTOM_SHARE = 2;
    public static final int OBJ_SOURCE_PB_FIRST_FLOOR = 1;
    public static final int OBJ_SOURCE_PB_SHARE = 6;
    public static final int OBJ_SOURCE_PERSON_CENTER = 8;
    public static final int OBJ_SOURCE_RECOMMEND_FEED = 3;
    public static final int OBJ_SOURCE_STAMP_DIALOG_SHARE = 31;
    public static final int OBJ_SOURCE_STATISTIC_FRS_LIKE_SHARE = 32;
    public static final int OBJ_SOURCE_VIDEO_CHANNEL_PAGE = 25;
    public static final int OBJ_SOURCE_VIDEO_CHANNEL_PAGE_CONCERN = 29;
    public static final int OBJ_SOURCE_WEBVIEW_ACTIVITY_RIGHT_TOP = 13;
    public static final int OBJ_SOURCE_WRITE_SHARE = 7;
    public static final int OBJ_TYPE_BJH_ARTICAL = 5;
    public static final int OBJ_TYPE_BJH_VIDEO = 6;
    public static final int OBJ_TYPE_GAME_ITEM_DETAIL = 10;
    public static final int OBJ_TYPE_GOD = 4;
    public static final int OBJ_TYPE_GROUP_INFO = 11;
    public static final int OBJ_TYPE_LIVE = 3;
    public static final int OBJ_TYPE_NORMAL = 1;
    public static final int OBJ_TYPE_TRANSMIT = 9;
    public static final int OBJ_TYPE_UGC_PIC = 7;
    public static final int OBJ_TYPE_UGC_VIDEO = 8;
    public static final int OBJ_TYPE_VIDEO = 2;
    public static final String OUTSIDE_SHARE_CIRCLE = "circle";
    public static final String OUTSIDE_SHARE_QQ = "qq";
    public static final String OUTSIDE_SHARE_QQZONE = "qqzone";
    public static final String OUTSIDE_SHARE_WECHAT = "wechat";
    public static final String OUTSIDE_SHARE_WEIBO = "weibo";
    public static final int PB_SMALL_APP_SHARE = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public String aiAppId;
    public String aiAppSource;
    public int aiAppType;
    public boolean canShareBySmartApp;
    public String cmdContent;
    public String cmdKey;
    public JSONArray cmdPannel;
    public JSONObject commandInfo;
    public String content;
    public Bundle diskPicOperate;
    public String experienceTip;
    public String extData;
    public String extLiveInfo;
    public String fName;
    public String festivalTaskTid;
    public String festivalTaskType;
    public String fid;
    public String floorAuthorUid;
    public String forbidShareToast;
    public String forbidShareTplText;
    public ForumData forumData;
    public ForwardInfo forwardInfo;
    public String ftid;
    public GroupInfoData groupData;
    public WeakReference<Bitmap> imageData;
    public Uri imageUri;
    public String imageUrl;
    public boolean isAiApps;
    public boolean isDirectFromWeb;
    public boolean isFromAcrossForum;
    public boolean isFromChosenPb;
    public boolean isFromCommentShare;
    public boolean isFromDuXiaoMan;
    public boolean isFromEmotionPackage;
    public boolean isFromFeed;
    public boolean isFromFeedVideoFinish;
    public boolean isFromGameDetial;
    public boolean isFromImageViewer;
    public boolean isFromPhotoLive;
    public boolean isFromShareFrs;
    public boolean isFromSharePb;
    public boolean isFromTopicDetail;
    public boolean isFromWebActivity;
    public boolean isFromYuanSheng;
    public boolean isShowAddExperienceTip;
    public boolean isShowMoreForumIcon;
    public boolean isShowShare;
    public boolean isShowShareOuerItem;
    public boolean isStampShare;
    public boolean isVideoAdShare;
    public String linkUrl;
    public String localFile;
    public Location location;
    public List<Integer> mCommandChannelArray;
    public boolean mFilterPerson;
    public boolean mFilterRooms;
    public ShareIMCommonCardData mShareCommonInfoData;
    public String mYyAnchorBdUid;
    public String mediaType;
    public String nid;
    public int objLocate;
    public int objParam1;
    public int objParam2;
    public int objParam3;
    public int objSource;
    public int obj_type;
    public OriginalThreadInfo.ShareInfo originalThreadInfo;
    public HashMap<String, Boolean> outsideShareDisableMap;
    public String pid;
    @Nullable
    public String portrait;
    public String prefferContent;
    public long readCount;
    public String shareAbstract;
    public String shareH5CardOptimizeContent;
    public Uri shareH5CardOptimizeImageUri;
    public String shareH5CardOptimizeTitle;
    public int shareMediaType;
    public String sharePanelTitle;
    public int shareReportFrom;
    public String shareToken;
    public int shareType;
    public boolean showLink;
    public boolean showTail;
    public String smartAppShareImageUrl;
    public String spareLinkUrl;
    public Bundle stats;
    public String taskCompleteId;
    public transient ThreadData threadData;
    public String tid;
    public String title;
    public String topic;
    public String topicId;
    public int typeShareToSmallApp;
    public String uid;
    @Nullable
    public String userName;
    @Nullable
    public String userShowName;
    public long voiceRoomId;
    public String voiceRoomShareType;
    public String wbcontent;
    public String wbtitle;
    public int weixinDisable;

    /* loaded from: classes5.dex */
    public static class ForwardInfo extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String avatar;
        public BaijiahaoData baijiahaoData;
        public boolean isDynamic;
        public boolean isShareType;
        public BaijiahaoData originalBaijiahaoData;
        public String originalTid;
        public String showPicUrl;
        public String showText;
        public int showType;
        public String transmitOriginThreadComment;
        public String transmitThreadAuthorNameShow;
        public String url;
        public String video_duration;

        public ForwardInfo() {
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

        public static ForwardInfo generateForwardInfo(OriginalThreadInfo.ShareInfo shareInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, shareInfo)) == null) {
                if (shareInfo == null) {
                    return null;
                }
                ForwardInfo forwardInfo = new ForwardInfo();
                forwardInfo.isShareType = false;
                forwardInfo.showText = shareInfo.showText;
                forwardInfo.showPicUrl = shareInfo.showPicUrl;
                forwardInfo.showType = shareInfo.showType;
                forwardInfo.originalTid = shareInfo.threadId;
                BaijiahaoData baijiahaoData = shareInfo.oriUgcInfo;
                if (baijiahaoData != null && !TextUtils.isEmpty(baijiahaoData.oriUgcNid)) {
                    forwardInfo.isDynamic = true;
                    forwardInfo.baijiahaoData = shareInfo.oriUgcInfo;
                }
                return forwardInfo;
            }
            return (ForwardInfo) invokeL.objValue;
        }

        public static ForwardInfo generateForwardInfo(ThreadData threadData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, threadData)) == null) {
                return generateForwardInfo(threadData, 0);
            }
            return (ForwardInfo) invokeL.objValue;
        }

        public static ForwardInfo generateForwardInfo(ThreadData threadData, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, threadData, i)) == null) {
                return generateForwardInfo(threadData, i, null);
            }
            return (ForwardInfo) invokeLI.objValue;
        }

        public static ForwardInfo generateForwardInfo(ThreadData threadData, int i, pea peaVar) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(InputDeviceCompat.SOURCE_TRACKBALL, null, threadData, i, peaVar)) == null) {
                String str = null;
                if (threadData == null) {
                    return null;
                }
                ForwardInfo forwardInfo = new ForwardInfo();
                forwardInfo.isShareType = false;
                if (threadData.isShareThread && threadData.originalThreadData != null) {
                    forwardInfo.isShareType = true;
                }
                if (forwardInfo.isShareType) {
                    BaijiahaoData baijiahaoData = threadData.originalThreadData.p;
                    if (baijiahaoData != null && !TextUtils.isEmpty(baijiahaoData.oriUgcNid)) {
                        forwardInfo.isDynamic = true;
                    }
                    forwardInfo.showText = threadData.originalThreadData.e();
                    OriginalThreadInfo originalThreadInfo = threadData.originalThreadData;
                    forwardInfo.showPicUrl = originalThreadInfo.c;
                    forwardInfo.showType = originalThreadInfo.a;
                    forwardInfo.originalBaijiahaoData = originalThreadInfo.p;
                    forwardInfo.originalTid = originalThreadInfo.f;
                    if (i == 1) {
                        if (peaVar != null && peaVar.f0() != null) {
                            str = peaVar.f0().toString();
                        } else if (threadData.getAbstract() != null) {
                            str = threadData.getAbstractText().toString();
                        }
                    } else if (threadData.parseFirstFloorContent() != null) {
                        str = threadData.parseFirstFloorContent().toString();
                    }
                    if (!TextUtils.isEmpty(str)) {
                        forwardInfo.transmitOriginThreadComment = str;
                    }
                    if (threadData.getAuthor() != null && !TextUtils.isEmpty(threadData.getAuthor().getName_show())) {
                        forwardInfo.transmitThreadAuthorNameShow = threadData.getAuthor().getName_show();
                    }
                    if (i == 1 && peaVar != null && ad.isEmpty(forwardInfo.transmitThreadAuthorNameShow) && peaVar.t() != null) {
                        forwardInfo.transmitThreadAuthorNameShow = peaVar.t().getName_show();
                    }
                    if (i == 2 && ad.isEmpty(forwardInfo.transmitThreadAuthorNameShow)) {
                        forwardInfo.transmitThreadAuthorNameShow = TbadkCoreApplication.getCurrentAccountNameShow();
                    }
                } else {
                    if (threadData.getBaijiahaoData() != null && !TextUtils.isEmpty(threadData.getBaijiahaoData().oriUgcNid)) {
                        forwardInfo.isDynamic = true;
                    }
                    OriginalThreadInfo n = OriginalThreadInfo.n(threadData);
                    if (n != null) {
                        forwardInfo.showText = n.e();
                        forwardInfo.showPicUrl = n.c;
                        forwardInfo.showType = n.a;
                    }
                    forwardInfo.originalTid = threadData.getTid();
                }
                if (i == 1) {
                    OriginalThreadInfo originalThreadInfo2 = threadData.originalThreadData;
                    if (originalThreadInfo2 != null && originalThreadInfo2.p != null) {
                        BaijiahaoData baijiahaoData2 = new BaijiahaoData();
                        forwardInfo.baijiahaoData = baijiahaoData2;
                        BaijiahaoData baijiahaoData3 = threadData.originalThreadData.p;
                        baijiahaoData2.oriUgcNid = baijiahaoData3.oriUgcNid;
                        baijiahaoData2.oriUgcTid = baijiahaoData3.oriUgcTid;
                        baijiahaoData2.oriUgcType = baijiahaoData3.oriUgcType;
                        baijiahaoData2.oriUgcVid = baijiahaoData3.oriUgcVid;
                        baijiahaoData2.forwardUrl = baijiahaoData3.forwardUrl;
                    } else if (threadData.getBaijiahaoData() != null) {
                        BaijiahaoData baijiahaoData4 = new BaijiahaoData();
                        forwardInfo.baijiahaoData = baijiahaoData4;
                        baijiahaoData4.oriUgcNid = threadData.getBaijiahaoData().oriUgcNid;
                        forwardInfo.baijiahaoData.oriUgcTid = threadData.getBaijiahaoData().oriUgcTid;
                        forwardInfo.baijiahaoData.oriUgcType = threadData.getBaijiahaoData().oriUgcType;
                        forwardInfo.baijiahaoData.oriUgcVid = threadData.getBaijiahaoData().oriUgcVid;
                        forwardInfo.baijiahaoData.forwardUrl = threadData.getBaijiahaoData().forwardUrl;
                    }
                } else if (threadData.getBaijiahaoData() != null) {
                    BaijiahaoData baijiahaoData5 = new BaijiahaoData();
                    forwardInfo.baijiahaoData = baijiahaoData5;
                    baijiahaoData5.oriUgcNid = threadData.getBaijiahaoData().oriUgcNid;
                    forwardInfo.baijiahaoData.oriUgcTid = threadData.getBaijiahaoData().oriUgcTid;
                    forwardInfo.baijiahaoData.oriUgcType = threadData.getBaijiahaoData().oriUgcType;
                    forwardInfo.baijiahaoData.oriUgcVid = threadData.getBaijiahaoData().oriUgcVid;
                    forwardInfo.baijiahaoData.forwardUrl = threadData.getBaijiahaoData().forwardUrl;
                }
                if (threadData.getBaijiahaoData() != null) {
                    if (threadData.getBaijiahaoData().oriUgcType == 2) {
                        if (threadData.getThreadVideoInfo() != null) {
                            forwardInfo.video_duration = String.valueOf(threadData.getThreadVideoInfo().video_duration);
                        }
                    } else if ((threadData.getBaijiahaoData().oriUgcType == 3 || threadData.getBaijiahaoData().oriUgcType == 4) && threadData.getAuthor() != null && !TextUtils.isEmpty(threadData.getAuthor().getPortrait())) {
                        if (threadData.getAuthor().getPortrait().startsWith("http")) {
                            forwardInfo.avatar = threadData.getAuthor().getPortrait();
                        } else {
                            forwardInfo.avatar = TbConfig.getBigPhotoAdress() + threadData.getAuthor().getPortrait() + ".jpg";
                        }
                    }
                }
                return forwardInfo;
            }
            return (ForwardInfo) invokeLIL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1452161178, "Lcom/baidu/tbadk/coreExtra/share/ShareItem;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1452161178, "Lcom/baidu/tbadk/coreExtra/share/ShareItem;");
                return;
            }
        }
        IMAGE_DATA_FILE = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/share/SHARED_IMAGE";
    }

    public ShareItem() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.isFromChosenPb = false;
        this.isFromShareFrs = false;
        this.isFromSharePb = false;
        this.isFromPhotoLive = false;
        this.isFromAcrossForum = false;
        this.isFromFeed = false;
        this.isFromWebActivity = false;
        this.isFromFeedVideoFinish = false;
        this.isFromTopicDetail = false;
        this.isFromImageViewer = false;
        this.isFromCommentShare = false;
        this.isFromGameDetial = false;
        this.isFromDuXiaoMan = false;
        this.isFromYuanSheng = false;
        this.isFromEmotionPackage = false;
        this.isDirectFromWeb = false;
        this.isShowAddExperienceTip = false;
        this.isShowMoreForumIcon = false;
        this.experienceTip = "";
        this.typeShareToSmallApp = 0;
        this.objSource = 0;
        this.objParam1 = 3;
        this.objParam2 = 0;
        this.objParam3 = 0;
        this.objLocate = 0;
        this.readCount = -1L;
        this.voiceRoomId = 0L;
        this.shareType = 0;
        this.isShowShare = false;
        this.isShowShareOuerItem = true;
        this.isVideoAdShare = false;
        this.showTail = true;
        this.showLink = true;
        this.weixinDisable = 0;
        this.canShareBySmartApp = true;
        this.isAiApps = false;
        this.mFilterRooms = false;
        this.mFilterPerson = false;
        this.title = null;
        this.content = null;
        this.linkUrl = null;
        this.spareLinkUrl = null;
        this.imageUri = null;
        this.location = null;
        this.imageData = null;
        this.ftid = null;
        this.extData = null;
        this.localFile = null;
        this.mYyAnchorBdUid = null;
        this.typeShareToSmallApp = 0;
        this.groupData = null;
        this.mShareCommonInfoData = null;
        this.mFilterRooms = false;
    }

    public static ShareItem buildShareItem(@NonNull JSONObject jSONObject, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, jSONObject, z)) == null) {
            ShareItem shareItem = new ShareItem();
            String optString = jSONObject.optString("title");
            String optString2 = jSONObject.optString("desc");
            String optString3 = jSONObject.optString("img");
            String optString4 = jSONObject.optString("url");
            String optString5 = jSONObject.optString("topic");
            String optString6 = jSONObject.optString("wbtitle");
            String optString7 = jSONObject.optString("wbcontent");
            shareItem.title = optString;
            shareItem.linkUrl = optString4;
            shareItem.content = optString2;
            if (!TextUtils.isEmpty(optString3)) {
                shareItem.imageUri = Uri.parse(optString3);
            }
            shareItem.topic = optString5;
            shareItem.wbtitle = optString6;
            shareItem.wbcontent = optString7;
            shareItem.shareType = jSONObject.optInt("shareimg");
            shareItem.weixinDisable = jSONObject.optInt("weixin_disable");
            String optString8 = jSONObject.optString("extdata");
            if (!StringUtils.isNull(optString8)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(optString8);
                    String optString9 = jSONObject2.optString("activityid");
                    String optString10 = jSONObject2.optString("missionid");
                    if (!StringUtils.isNull(optString9) && !StringUtils.isNull(optString10)) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put(optString9, optString10);
                        shareItem.taskCompleteId = jSONObject3.toString();
                    }
                } catch (JSONException unused) {
                }
            }
            shareItem.groupData = GroupInfoData.fromJsonH5(jSONObject);
            shareItem.mShareCommonInfoData = ShareIMCommonCardData.fromJsonH5(jSONObject);
            return shareItem;
        }
        return (ShareItem) invokeLZ.objValue;
    }

    private boolean isNoShowForumByIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            if ((isShareGroup() || isShareAlbum() || isShareTopic() || isShareActive()) && !this.isShowMoreForumIcon) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public List<Integer> getCommandChannelArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mCommandChannelArray;
        }
        return (List) invokeV.objValue;
    }

    @NonNull
    public String getForbidShareToast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String str = this.forbidShareToast;
            if (str == null) {
                return "";
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public String getForbidShareTplText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            String str = this.forbidShareTplText;
            if (str == null) {
                return "";
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public Bitmap getImageData() {
        InterceptResult invokeV;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            WeakReference<Bitmap> weakReference = this.imageData;
            if (weakReference != null && (bitmap = weakReference.get()) != null && !bitmap.isRecycled()) {
                return bitmap;
            }
            return null;
        }
        return (Bitmap) invokeV.objValue;
    }

    public boolean getIsShowShare() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.isShowShare;
        }
        return invokeV.booleanValue;
    }

    @NonNull
    public HashMap<String, Boolean> getOutsideShareDisableMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.outsideShareDisableMap == null) {
                this.outsideShareDisableMap = new HashMap<>();
            }
            return this.outsideShareDisableMap;
        }
        return (HashMap) invokeV.objValue;
    }

    @Nullable
    public String getSharePanelTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.sharePanelTitle;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public String getShareToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            String str = this.shareToken;
            if (str == null) {
                return "";
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public Bundle getStats() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.stats;
        }
        return (Bundle) invokeV.objValue;
    }

    public boolean isFilterPerson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mFilterPerson;
        }
        return invokeV.booleanValue;
    }

    public boolean isFilterRooms() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mFilterRooms;
        }
        return invokeV.booleanValue;
    }

    public boolean isShareActive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return ShareIMCommonCardData.isValidActive(this.mShareCommonInfoData);
        }
        return invokeV.booleanValue;
    }

    public boolean isShareAlbum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return ShareIMCommonCardData.isValidAlbum(this.mShareCommonInfoData);
        }
        return invokeV.booleanValue;
    }

    public boolean isShareGroup() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            GroupInfoData groupInfoData = this.groupData;
            if (groupInfoData != null && groupInfoData.getGroupId() > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isShareTopic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return ShareIMCommonCardData.isValidTopic(this.mShareCommonInfoData);
        }
        return invokeV.booleanValue;
    }

    public boolean isShowForumShareItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            int i = this.obj_type;
            if (i != 7 && i != 8 && i != 5 && i != 6 && i != 11 && !isNoShowForumByIcon()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isShowMoreForumIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.isShowMoreForumIcon;
        }
        return invokeV.booleanValue;
    }

    public Boolean checkOutsideForbidShare(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(this.shareToken)) {
                return Boolean.FALSE;
            }
            if (vx0.c(this.outsideShareDisableMap)) {
                return Boolean.FALSE;
            }
            if (!this.outsideShareDisableMap.containsKey(str)) {
                return Boolean.FALSE;
            }
            return this.outsideShareDisableMap.get(str);
        }
        return (Boolean) invokeL.objValue;
    }

    public byte[] getCompressedImageData() {
        InterceptResult invokeV;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            WeakReference<Bitmap> weakReference = this.imageData;
            byte[] bArr = null;
            if (weakReference != null && (bitmap = weakReference.get()) != null && !bitmap.isRecycled()) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                if (bitmap.compress(Bitmap.CompressFormat.PNG, 85, byteArrayOutputStream)) {
                    bArr = byteArrayOutputStream.toByteArray();
                }
                try {
                    byteArrayOutputStream.close();
                } catch (IOException unused) {
                }
            }
            return bArr;
        }
        return (byte[]) invokeV.objValue;
    }

    public void saveImageDataIfNecessary() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && this.imageData != null) {
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    if (FileHelper.checkSD()) {
                        File file = new File(IMAGE_DATA_FILE);
                        if (file.exists()) {
                            file.delete();
                        }
                        File parentFile = file.getParentFile();
                        if (parentFile != null && !parentFile.exists()) {
                            parentFile.mkdirs();
                        }
                        byte[] compressedImageData = getCompressedImageData();
                        if (compressedImageData != null) {
                            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                            try {
                                fileOutputStream2.write(compressedImageData);
                                fileOutputStream2.close();
                                this.imageUri = Uri.fromFile(file);
                                this.imageData = null;
                                try {
                                    fileOutputStream2.close();
                                } catch (IOException e) {
                                    BdLog.e(e.toString());
                                }
                            } catch (Exception e2) {
                                e = e2;
                                fileOutputStream = fileOutputStream2;
                                BdLog.e(e.toString());
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e3) {
                                        BdLog.e(e3.toString());
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                fileOutputStream = fileOutputStream2;
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e4) {
                                        BdLog.e(e4.toString());
                                    }
                                }
                                throw th;
                            }
                        }
                    }
                } catch (Exception e5) {
                    e = e5;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public void setCommandChannelArray(List<Integer> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, list) == null) {
            this.mCommandChannelArray = list;
        }
    }

    public void setFilterPerson(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.mFilterPerson = z;
        }
    }

    public void setFilterRooms(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.mFilterRooms = z;
        }
    }

    public void setForbidShareToast(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.forbidShareToast = str;
        }
    }

    public void setForbidShareTplText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.forbidShareTplText = str;
        }
    }

    public void setImageData(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, bitmap) == null) {
            this.imageData = new WeakReference<>(bitmap);
        }
    }

    public void setOutsideShareDisableMap(HashMap<String, Boolean> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, hashMap) == null) {
            this.outsideShareDisableMap = hashMap;
        }
    }

    public void setShareCommonInfoData(ShareIMCommonCardData shareIMCommonCardData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, shareIMCommonCardData) == null) {
            this.mShareCommonInfoData = shareIMCommonCardData;
        }
    }

    public void setSharePanelTitle(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            this.sharePanelTitle = str;
        }
    }

    public void setShareToken(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            this.shareToken = str;
        }
    }

    public void setShowMoreForumIcon(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            this.isShowMoreForumIcon = z;
        }
    }

    public void setShowShare(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            this.isShowShare = z;
        }
    }

    public void setStats(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, bundle) == null) {
            this.stats = bundle;
        }
    }
}

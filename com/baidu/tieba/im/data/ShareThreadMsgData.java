package com.baidu.tieba.im.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tieba.bh7;
import com.baidu.tieba.fv4;
import com.baidu.tieba.im.db.pojo.ApkDetailPojo;
import com.baidu.tieba.im.db.pojo.GraffitiInfoPojo;
import com.baidu.tieba.im.db.pojo.MediaPojo;
import com.baidu.tieba.im.db.pojo.MemeInfoPojo;
import com.baidu.tieba.im.db.pojo.PbContentPojo;
import com.baidu.tieba.im.db.pojo.PluginUserPojo;
import com.baidu.tieba.im.db.pojo.TiebaPlusInfoPojo;
import com.baidu.tieba.im.db.pojo.TogetherHiPojo;
import com.baidu.tieba.yg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import protobuf.ImShareThreadInfo;
import protobuf.Media;
import protobuf.OriginThreadInfo;
import protobuf.SimpleForum;
import protobuf.User;
import protobuf.Voice;
import tbclient.ApkDetail;
import tbclient.GraffitiInfo;
import tbclient.Item;
import tbclient.MemeInfo;
import tbclient.NativeApp;
import tbclient.PbContent;
import tbclient.PluginUser;
import tbclient.TiebaPlusInfo;
import tbclient.TogetherHi;
import tbclient.VideoInfo;
/* loaded from: classes4.dex */
public final class ShareThreadMsgData extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 6249773504681205473L;
    public transient /* synthetic */ FieldHolder $fh;
    public String author_name_show;
    public String author_portrait;
    public int during_time;
    public String forum_avatar;
    public long forum_id;
    public String forum_name;
    public int hasRead;
    public long id;
    public boolean is_share_thread;
    public List<MediaPojo> media_list;
    public ShareThreadMsgData origin_thread_info;
    public int play_count;
    public List<PbContentPojo> rich_abstract;
    public List<PbContentPojo> rich_title;
    public int thread_type;
    public int thumbnail_height;
    public String thumbnail_url;
    public int thumbnail_width;
    public String title;
    public int video_duration;

    public static long getSerialVersionUID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? serialVersionUID : invokeV.longValue;
    }

    public ShareThreadMsgData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.hasRead = 0;
    }

    public String getAuthor_name_show() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.author_name_show;
        }
        return (String) invokeV.objValue;
    }

    public String getAuthor_portrait() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.author_portrait;
        }
        return (String) invokeV.objValue;
    }

    public int getDuring_time() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.during_time;
        }
        return invokeV.intValue;
    }

    public String getForum_avatar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.forum_avatar;
        }
        return (String) invokeV.objValue;
    }

    public long getForum_id() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.forum_id;
        }
        return invokeV.longValue;
    }

    public String getForum_name() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.forum_name;
        }
        return (String) invokeV.objValue;
    }

    public long getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.id;
        }
        return invokeV.longValue;
    }

    public List<MediaPojo> getMedia_list() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.media_list;
        }
        return (List) invokeV.objValue;
    }

    public ShareThreadMsgData getOrigin_thread_info() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.origin_thread_info;
        }
        return (ShareThreadMsgData) invokeV.objValue;
    }

    public int getPlay_count() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.play_count;
        }
        return invokeV.intValue;
    }

    public List<PbContentPojo> getRich_abstract() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.rich_abstract;
        }
        return (List) invokeV.objValue;
    }

    public List<PbContentPojo> getRich_title() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.rich_title;
        }
        return (List) invokeV.objValue;
    }

    public int getThread_type() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.thread_type;
        }
        return invokeV.intValue;
    }

    public int getThumbnail_height() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.thumbnail_height;
        }
        return invokeV.intValue;
    }

    public String getThumbnail_url() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.thumbnail_url;
        }
        return (String) invokeV.objValue;
    }

    public int getThumbnail_width() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.thumbnail_width;
        }
        return invokeV.intValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.title;
        }
        return (String) invokeV.objValue;
    }

    public int getVideo_duration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.video_duration;
        }
        return invokeV.intValue;
    }

    public boolean hasRead() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.hasRead == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isIs_share_thread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.is_share_thread;
        }
        return invokeV.booleanValue;
    }

    public String toEncodeContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("tid", getId());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public static ShareThreadMsgData ofImShareThreadInfo(ImShareThreadInfo imShareThreadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, imShareThreadInfo)) == null) {
            if (imShareThreadInfo == null) {
                return null;
            }
            ShareThreadMsgData shareThreadMsgData = new ShareThreadMsgData();
            shareThreadMsgData.thread_type = imShareThreadInfo.threadType.intValue();
            shareThreadMsgData.id = imShareThreadInfo.id.longValue();
            shareThreadMsgData.title = imShareThreadInfo.title;
            shareThreadMsgData.rich_title = parseContentPojo(imShareThreadInfo.richTitle);
            shareThreadMsgData.rich_abstract = parseContentPojo(imShareThreadInfo.richAbstract);
            Integer num = imShareThreadInfo.isShareThread;
            boolean z = true;
            shareThreadMsgData.is_share_thread = (num == null || num.intValue() != 1) ? false : false;
            parseOriginalThread(shareThreadMsgData, imShareThreadInfo.originThreadInfo);
            parseUserInfo(shareThreadMsgData, imShareThreadInfo.author);
            parseForumInfo(shareThreadMsgData, imShareThreadInfo.forumInfo);
            parseVedioInfo(shareThreadMsgData, imShareThreadInfo.videoInfo);
            List<Voice> list = imShareThreadInfo.voiceInfo;
            if (list != null && list.size() > 0) {
                parseVoiceInfo(shareThreadMsgData, imShareThreadInfo.voiceInfo.get(0));
            }
            parseMediaList(shareThreadMsgData, imShareThreadInfo.media);
            return shareThreadMsgData;
        }
        return (ShareThreadMsgData) invokeL.objValue;
    }

    public static ShareThreadMsgData ofThreadData(@NonNull ThreadData threadData) {
        InterceptResult invokeL;
        VoiceData.VoiceModel voiceModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, threadData)) == null) {
            if (threadData == null) {
                return null;
            }
            ShareThreadMsgData shareThreadMsgData = new ShareThreadMsgData();
            shareThreadMsgData.thread_type = threadData.threadType;
            shareThreadMsgData.id = yg.g(threadData.getTid(), 0L);
            if (threadData.isImShareFromPb()) {
                shareThreadMsgData.rich_abstract = parseContentTb(threadData.getPbFirstShareData().i0);
            } else {
                shareThreadMsgData.rich_abstract = parseContentTb(threadData.getRichAbstractList());
            }
            shareThreadMsgData.rich_title = parseContentTb(threadData.getRichTitle());
            shareThreadMsgData.title = threadData.getTitle();
            shareThreadMsgData.is_share_thread = threadData.isShareThread;
            if (threadData.originalThreadData != null) {
                ShareThreadMsgData shareThreadMsgData2 = new ShareThreadMsgData();
                OriginalThreadInfo originalThreadInfo = threadData.originalThreadData;
                shareThreadMsgData2.thread_type = originalThreadInfo.k;
                shareThreadMsgData2.id = yg.g(originalThreadInfo.f, 0L);
                List<PbContentPojo> parseContentTb = parseContentTb(threadData.originalThreadData.s);
                shareThreadMsgData2.rich_abstract = parseContentTb;
                if (ListUtils.isEmpty(parseContentTb)) {
                    shareThreadMsgData2.rich_title = parseContentTb(threadData.originalThreadData.f());
                }
                VideoInfo videoInfo = threadData.originalThreadData.r;
                if (videoInfo != null) {
                    shareThreadMsgData2.video_duration = videoInfo.video_duration.intValue();
                    shareThreadMsgData2.play_count = threadData.originalThreadData.r.play_count.intValue();
                    VideoInfo videoInfo2 = threadData.originalThreadData.r;
                    shareThreadMsgData2.thumbnail_url = videoInfo2.thumbnail_url;
                    shareThreadMsgData2.thumbnail_width = videoInfo2.thumbnail_width.intValue();
                    shareThreadMsgData2.thumbnail_height = threadData.originalThreadData.r.thumbnail_height.intValue();
                }
                if (!ListUtils.isEmpty(threadData.originalThreadData.q) && (voiceModel = (VoiceData.VoiceModel) ListUtils.getItem(threadData.originalThreadData.q, 0)) != null) {
                    shareThreadMsgData2.during_time = voiceModel.getDuration();
                }
                if (!ListUtils.isEmpty(threadData.originalThreadData.h)) {
                    parseMediaDataList(shareThreadMsgData2, threadData.originalThreadData.h);
                }
                shareThreadMsgData.origin_thread_info = shareThreadMsgData2;
            }
            if (threadData.getAuthor() != null) {
                shareThreadMsgData.author_portrait = threadData.getAuthor().getPortrait();
                shareThreadMsgData.author_name_show = threadData.getAuthor().getName_show();
            }
            if (threadData.getForumData() != null) {
                fv4 forumData = threadData.getForumData();
                shareThreadMsgData.forum_id = yg.g(forumData.a, 0L);
                shareThreadMsgData.forum_avatar = forumData.c;
                shareThreadMsgData.forum_name = forumData.b;
            }
            if (threadData.getThreadVideoInfo() != null) {
                VideoInfo threadVideoInfo = threadData.getThreadVideoInfo();
                shareThreadMsgData.video_duration = threadVideoInfo.video_duration.intValue();
                shareThreadMsgData.play_count = threadVideoInfo.play_count.intValue();
                shareThreadMsgData.thumbnail_url = threadVideoInfo.thumbnail_url;
                shareThreadMsgData.thumbnail_width = threadVideoInfo.thumbnail_width.intValue();
                shareThreadMsgData.thumbnail_height = threadVideoInfo.thumbnail_height.intValue();
            }
            if (threadData.getVoice() != null) {
                ArrayList<VoiceData.VoiceModel> voice = threadData.getVoice();
                if (!ListUtils.isEmpty(voice)) {
                    shareThreadMsgData.during_time = ((VoiceData.VoiceModel) ListUtils.getItem(voice, 0)).getDuration();
                }
            }
            if (!ListUtils.isEmpty(threadData.getMedias())) {
                parseMediaDataList(shareThreadMsgData, threadData.getMedias());
            } else if (threadData.isImShareFromPb() && threadData.getPbFirstShareData() != null && threadData.getPbFirstShareData().Z() != null) {
                shareThreadMsgData.media_list = new ArrayList();
                Iterator<TbRichTextImageInfo> it = threadData.getPbFirstShareData().Z().K().iterator();
                while (it.hasNext()) {
                    TbRichTextImageInfo next = it.next();
                    MediaPojo mediaPojo = new MediaPojo();
                    mediaPojo.srcPic = next.J();
                    mediaPojo.width = next.getWidth();
                    mediaPojo.height = next.getHeight();
                    shareThreadMsgData.media_list.add(mediaPojo);
                }
            }
            return shareThreadMsgData;
        }
        return (ShareThreadMsgData) invokeL.objValue;
    }

    public static List<PbContent> parseContent(List<PbContentPojo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (!ListUtils.isEmpty(list)) {
                for (PbContentPojo pbContentPojo : list) {
                    PbContent.Builder builder = new PbContent.Builder();
                    builder.type = pbContentPojo.type;
                    builder.text = pbContentPojo.text;
                    builder.link = pbContentPojo.link;
                    builder.src = pbContentPojo.src;
                    builder.bsize = pbContentPojo.bsize;
                    builder.big_src = pbContentPojo.bigSrc;
                    builder.big_size = pbContentPojo.bigSize;
                    builder.cdn_src = pbContentPojo.cdnSrc;
                    builder.big_cdn_src = pbContentPojo.bigCdnSrc;
                    builder.imgtype = pbContentPojo.imgtype;
                    builder.c = pbContentPojo.c;
                    builder.voice_md5 = pbContentPojo.voiceMd5;
                    builder.during_time = pbContentPojo.duringTime;
                    builder.is_sub = pbContentPojo.isSub;
                    builder.uid = pbContentPojo.uid;
                    builder.dynamic = pbContentPojo.dynamic;
                    builder._static = pbContentPojo._static;
                    builder.width = pbContentPojo.width;
                    builder.height = pbContentPojo.height;
                    builder.packet_name = pbContentPojo.packetName;
                    builder.phonetype = pbContentPojo.phonetype;
                    builder.is_native_app = pbContentPojo.isNativeApp;
                    if (pbContentPojo.nativeApp != null) {
                        NativeApp.Builder builder2 = new NativeApp.Builder();
                        protobuf.NativeApp nativeApp = pbContentPojo.nativeApp;
                        builder2.jump_and = nativeApp.jumpAnd;
                        builder2.jump_ios = nativeApp.jumpIos;
                        builder2.download_and = nativeApp.downloadAnd;
                        builder2.download_ios = nativeApp.downloadIos;
                        builder.native_app = builder2.build(true);
                    }
                    builder.e_type = pbContentPojo.eType;
                    builder.origin_src = pbContentPojo.originSrc;
                    builder.btn_type = pbContentPojo.btnType;
                    builder.origin_size = pbContentPojo.originSize;
                    builder.count = pbContentPojo.count;
                    if (pbContentPojo.graffitiInfo != null) {
                        GraffitiInfo.Builder builder3 = new GraffitiInfo.Builder();
                        GraffitiInfoPojo graffitiInfoPojo = pbContentPojo.graffitiInfo;
                        builder3.url = graffitiInfoPojo.url;
                        builder3.gid = graffitiInfoPojo.gid;
                        builder.graffiti_info = builder3.build(true);
                    }
                    if (pbContentPojo.highTogether != null) {
                        TogetherHi.Builder builder4 = new TogetherHi.Builder();
                        TogetherHiPojo togetherHiPojo = pbContentPojo.highTogether;
                        builder4.album_name = togetherHiPojo.albumName;
                        builder4.album_id = togetherHiPojo.albumId;
                        builder4.start_time = togetherHiPojo.startTime;
                        builder4.end_time = togetherHiPojo.endTime;
                        builder4.location = togetherHiPojo.location;
                        builder4.num_signup = togetherHiPojo.numSignup;
                        builder4.potraits = new ArrayList(pbContentPojo.highTogether.potraits);
                        builder4.num_join = pbContentPojo.highTogether.numJoin;
                        builder4.pic_urls = new ArrayList(pbContentPojo.highTogether.picUrls);
                        builder.high_together = builder4.build(true);
                    }
                    builder.media_subtitle = pbContentPojo.mediaSubtitle;
                    builder.url_type = pbContentPojo.urlType;
                    if (pbContentPojo.memeInfo != null) {
                        MemeInfo.Builder builder5 = new MemeInfo.Builder();
                        MemeInfoPojo memeInfoPojo = pbContentPojo.memeInfo;
                        builder5.pck_id = memeInfoPojo.pckId;
                        builder5.pic_id = memeInfoPojo.picId;
                        builder5.pic_url = memeInfoPojo.picUrl;
                        builder5.thumbnail = memeInfoPojo.thumbnail;
                        builder5.width = memeInfoPojo.width;
                        builder5.height = memeInfoPojo.height;
                        builder5.detail_link = memeInfoPojo.detailLink;
                        builder.meme_info = builder5.build(true);
                    }
                    builder.is_long_pic = pbContentPojo.isLongPic;
                    builder.show_original_btn = pbContentPojo.showOriginalBtn;
                    builder.cdn_src_active = pbContentPojo.cdnSrcActive;
                    builder.topic_special_icon = pbContentPojo.topicSpecialIcon;
                    builder.item_id = pbContentPojo.itemId;
                    builder.item_forum_name = pbContentPojo.itemForumName;
                    if (pbContentPojo.tiebaplusInfo != null) {
                        TiebaPlusInfo.Builder builder6 = new TiebaPlusInfo.Builder();
                        TiebaPlusInfoPojo tiebaPlusInfoPojo = pbContentPojo.tiebaplusInfo;
                        builder6.title = tiebaPlusInfoPojo.title;
                        builder6.desc = tiebaPlusInfoPojo.desc;
                        builder6.jump_url = tiebaPlusInfoPojo.jumpUrl;
                        builder6.download_url = tiebaPlusInfoPojo.downloadUrl;
                        builder6.app_id = tiebaPlusInfoPojo.appId;
                        builder6.app_icon = tiebaPlusInfoPojo.appIcon;
                        builder6.app_package = tiebaPlusInfoPojo.appPackage;
                        builder6.app_version = tiebaPlusInfoPojo.appVersion;
                        builder6.app_privacy = tiebaPlusInfoPojo.appPrivacy;
                        builder6.app_power = tiebaPlusInfoPojo.appPower;
                        builder6.app_company = tiebaPlusInfoPojo.appCompany;
                        builder6.target_type = tiebaPlusInfoPojo.targetType;
                        builder6.h5_jump_type = tiebaPlusInfoPojo.h5JumpType;
                        builder6.h5_jump_number = tiebaPlusInfoPojo.h5JumpNumber;
                        builder6.h5_jump_param = tiebaPlusInfoPojo.h5JumpParam;
                        builder6.jump_type = tiebaPlusInfoPojo.jumpType;
                        builder6.item_id = tiebaPlusInfoPojo.itemId;
                        builder6.is_appoint = tiebaPlusInfoPojo.isAppoint;
                        if (tiebaPlusInfoPojo.pluginUser != null) {
                            PluginUser.Builder builder7 = new PluginUser.Builder();
                            PluginUserPojo pluginUserPojo = pbContentPojo.tiebaplusInfo.pluginUser;
                            builder7.user_id = pluginUserPojo.userId;
                            builder7.user_name_show = pluginUserPojo.userNameShow;
                            builder7.user_type = pluginUserPojo.userType;
                            builder7.user_photo = pluginUserPojo.userPhoto;
                            builder7.is_download_card_whiteuser = pluginUserPojo.isDownloadCardWhiteuser;
                            builder6.plugin_user = builder7.build(true);
                        }
                        TiebaPlusInfoPojo tiebaPlusInfoPojo2 = pbContentPojo.tiebaplusInfo;
                        builder6.forum_name = tiebaPlusInfoPojo2.forumName;
                        builder6.jump_setting = tiebaPlusInfoPojo2.jumpSetting;
                        builder6.wx_thumbnail = tiebaPlusInfoPojo2.wxThumbnail;
                        builder6.button_desc = tiebaPlusInfoPojo2.buttonDesc;
                        builder.tiebaplus_info = builder6.build(true);
                    }
                    if (pbContentPojo.item != null) {
                        Item.Builder builder8 = new Item.Builder();
                        bh7 bh7Var = pbContentPojo.item;
                        builder8.item_id = bh7Var.a;
                        builder8.item_name = bh7Var.b;
                        builder8.icon_size = bh7Var.c;
                        builder8.icon_url = bh7Var.d;
                        if (bh7Var.e != null) {
                            builder8.tags = new ArrayList(pbContentPojo.item.e);
                        }
                        bh7 bh7Var2 = pbContentPojo.item;
                        builder8.score = bh7Var2.f;
                        builder8.star = bh7Var2.g;
                        builder8.button_name = bh7Var2.h;
                        builder8.button_link = bh7Var2.i;
                        builder8.item_appid = bh7Var2.j;
                        builder8.category_id = bh7Var2.k;
                        builder8.button_link_type = bh7Var2.l;
                        builder8.apk_name = bh7Var2.m;
                        builder8.forum_name = bh7Var2.n;
                        if (bh7Var2.o != null) {
                            ApkDetail.Builder builder9 = new ApkDetail.Builder();
                            ApkDetailPojo apkDetailPojo = pbContentPojo.item.o;
                            builder9.developer = apkDetailPojo.developer;
                            builder9.publisher = apkDetailPojo.publisher;
                            builder9.version = apkDetailPojo.version;
                            builder9.version_code = apkDetailPojo.versionCode;
                            builder9.update_time = apkDetailPojo.updateTime;
                            builder9.size = apkDetailPojo.size;
                            builder9.need_network = apkDetailPojo.needNetwork;
                            builder9.need_inner_buy = apkDetailPojo.needInnerBuy;
                            builder9.authority_url = apkDetailPojo.authorityUrl;
                            builder9.privacy_url = apkDetailPojo.privacyUrl;
                            builder9.pkg_source = apkDetailPojo.pkgSource;
                            builder8.apk_detail = builder9.build(true);
                        }
                        builder.item = builder8.build(true);
                    }
                    builder.pic_id = pbContentPojo.picId;
                    arrayList.add(builder.build(true));
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<PbContentPojo> parseContentPojo(List<protobuf.PbContent> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            if (list != null && list.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (protobuf.PbContent pbContent : list) {
                    PbContentPojo pbContentPojo = new PbContentPojo();
                    pbContentPojo.G(pbContent);
                    arrayList.add(pbContentPojo);
                }
                return arrayList;
            }
            return new ArrayList();
        }
        return (List) invokeL.objValue;
    }

    public static List<PbContentPojo> parseContentTb(List<PbContent> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, list)) == null) {
            if (list != null && list.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (PbContent pbContent : list) {
                    PbContentPojo pbContentPojo = new PbContentPojo();
                    pbContentPojo.H(pbContent);
                    arrayList.add(pbContentPojo);
                }
                return arrayList;
            }
            return new ArrayList();
        }
        return (List) invokeL.objValue;
    }

    public static void parseForumInfo(ShareThreadMsgData shareThreadMsgData, SimpleForum simpleForum) {
        long longValue;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65543, null, shareThreadMsgData, simpleForum) != null) || simpleForum == null) {
            return;
        }
        Long l = simpleForum.id;
        if (l == null) {
            longValue = 0;
        } else {
            longValue = l.longValue();
        }
        shareThreadMsgData.forum_id = longValue;
        shareThreadMsgData.forum_avatar = simpleForum.avatar;
        shareThreadMsgData.forum_name = simpleForum.name;
    }

    public static void parseUserInfo(ShareThreadMsgData shareThreadMsgData, User user) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65547, null, shareThreadMsgData, user) != null) || user == null) {
            return;
        }
        shareThreadMsgData.author_portrait = user.portrait;
        shareThreadMsgData.author_name_show = user.nameShow;
    }

    public static void parseVoiceInfo(ShareThreadMsgData shareThreadMsgData, Voice voice) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65549, null, shareThreadMsgData, voice) != null) || voice == null) {
            return;
        }
        shareThreadMsgData.during_time = voice.duringTime.intValue();
    }

    public static void parseMediaDataList(ShareThreadMsgData shareThreadMsgData, List<MediaData> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65544, null, shareThreadMsgData, list) == null) && !ListUtils.isEmpty(list)) {
            shareThreadMsgData.media_list = new ArrayList();
            for (MediaData mediaData : list) {
                MediaPojo mediaPojo = new MediaPojo();
                mediaPojo.srcPic = mediaData.getSrc_pic();
                mediaPojo.width = mediaData.picWidth;
                mediaPojo.height = mediaData.picHeight;
                shareThreadMsgData.media_list.add(mediaPojo);
            }
        }
    }

    public static void parseMediaList(ShareThreadMsgData shareThreadMsgData, List<Media> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65545, null, shareThreadMsgData, list) == null) && list != null && list.size() != 0) {
            shareThreadMsgData.media_list = new ArrayList();
            for (Media media : list) {
                MediaPojo mediaPojo = new MediaPojo();
                mediaPojo.H(media);
                if (StringUtils.isNull(mediaPojo.srcPic)) {
                    if (!StringUtils.isNull(mediaPojo.originPic)) {
                        mediaPojo.srcPic = mediaPojo.originPic;
                    } else if (!StringUtils.isNull(mediaPojo.bigPic)) {
                        mediaPojo.srcPic = mediaPojo.bigPic;
                    } else if (!StringUtils.isNull(mediaPojo.smallPic)) {
                        mediaPojo.srcPic = mediaPojo.smallPic;
                    }
                }
                shareThreadMsgData.media_list.add(mediaPojo);
            }
        }
    }

    public static void parseOriginalThread(ShareThreadMsgData shareThreadMsgData, OriginThreadInfo originThreadInfo) {
        Voice voice;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65546, null, shareThreadMsgData, originThreadInfo) != null) || originThreadInfo == null) {
            return;
        }
        ShareThreadMsgData shareThreadMsgData2 = new ShareThreadMsgData();
        shareThreadMsgData2.thread_type = originThreadInfo.threadType.intValue();
        shareThreadMsgData2.id = yg.g(originThreadInfo.tid, 0L);
        shareThreadMsgData2.title = originThreadInfo.title;
        shareThreadMsgData2.rich_abstract = parseContentPojo(originThreadInfo.content);
        protobuf.VideoInfo videoInfo = originThreadInfo.videoInfo;
        if (videoInfo != null) {
            shareThreadMsgData2.video_duration = videoInfo.videoDuration.intValue();
            shareThreadMsgData2.play_count = originThreadInfo.videoInfo.playCount.intValue();
            protobuf.VideoInfo videoInfo2 = originThreadInfo.videoInfo;
            shareThreadMsgData2.thumbnail_url = videoInfo2.thumbnailUrl;
            shareThreadMsgData2.thumbnail_width = videoInfo2.thumbnailWidth.intValue();
            shareThreadMsgData2.thumbnail_height = originThreadInfo.videoInfo.thumbnailHeight.intValue();
        }
        if (!ListUtils.isEmpty(originThreadInfo.voiceInfo) && (voice = (Voice) ListUtils.getItem(originThreadInfo.voiceInfo, 0)) != null) {
            shareThreadMsgData2.during_time = voice.duringTime.intValue();
        }
        if (!ListUtils.isEmpty(originThreadInfo.media)) {
            parseMediaList(shareThreadMsgData2, originThreadInfo.media);
        }
        shareThreadMsgData.origin_thread_info = shareThreadMsgData2;
    }

    public static void parseVedioInfo(ShareThreadMsgData shareThreadMsgData, protobuf.VideoInfo videoInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65548, null, shareThreadMsgData, videoInfo) != null) || videoInfo == null) {
            return;
        }
        shareThreadMsgData.video_duration = videoInfo.videoDuration.intValue();
        shareThreadMsgData.play_count = videoInfo.playCount.intValue();
        shareThreadMsgData.thumbnail_url = videoInfo.thumbnailUrl;
        shareThreadMsgData.thumbnail_width = videoInfo.thumbnailWidth.intValue();
        shareThreadMsgData.thumbnail_height = videoInfo.thumbnailHeight.intValue();
    }

    public void setAuthor_name_show(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.author_name_show = str;
        }
    }

    public void setAuthor_portrait(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.author_portrait = str;
        }
    }

    public void setDuring_time(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            this.during_time = i;
        }
    }

    public void setForum_avatar(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.forum_avatar = str;
        }
    }

    public void setForum_id(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048600, this, j) == null) {
            this.forum_id = j;
        }
    }

    public void setForum_name(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.forum_name = str;
        }
    }

    public void setHasRead(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.hasRead = z ? 1 : 0;
        }
    }

    public void setId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048603, this, j) == null) {
            this.id = j;
        }
    }

    public void setIs_share_thread(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.is_share_thread = z;
        }
    }

    public void setMedia_list(List<MediaPojo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, list) == null) {
            this.media_list = list;
        }
    }

    public void setOrigin_thread_info(ShareThreadMsgData shareThreadMsgData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, shareThreadMsgData) == null) {
            this.origin_thread_info = shareThreadMsgData;
        }
    }

    public void setPlay_count(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            this.play_count = i;
        }
    }

    public void setRich_abstract(List<PbContentPojo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, list) == null) {
            this.rich_abstract = list;
        }
    }

    public void setRich_title(List<PbContentPojo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, list) == null) {
            this.rich_title = list;
        }
    }

    public void setThread_type(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i) == null) {
            this.thread_type = i;
        }
    }

    public void setThumbnail_height(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i) == null) {
            this.thumbnail_height = i;
        }
    }

    public void setThumbnail_url(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            this.thumbnail_url = str;
        }
    }

    public void setThumbnail_width(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i) == null) {
            this.thumbnail_width = i;
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, str) == null) {
            this.title = str;
        }
    }

    public void setVideo_duration(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i) == null) {
            this.video_duration = i;
        }
    }
}

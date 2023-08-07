package com.baidu.tieba.im.db.pojo;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ac8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import protobuf.NativeApp;
import protobuf.PbContent;
/* loaded from: classes6.dex */
public class PbContentPojo extends OrmObject {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String _static;
    public String bigCdnSrc;
    public String bigSize;
    public String bigSrc;
    public String bsize;
    public Integer btnType;
    public String c;
    public String cdnSrc;
    public String cdnSrcActive;
    public Integer count;
    public Integer duringTime;
    public String dynamic;
    public Integer eType;
    public GraffitiInfoPojo graffitiInfo;
    public Integer height;
    public TogetherHiPojo highTogether;
    public String imgtype;
    public Integer isLongPic;
    public Integer isNativeApp;
    public Integer isSub;
    public ac8 item;
    public String itemForumName;
    public Long itemId;
    public String link;
    public String mediaSubtitle;
    public MemeInfoPojo memeInfo;
    public NativeApp nativeApp;
    public Integer originSize;
    public String originSrc;
    public String packetName;
    public String phonetype;
    public Long picId;
    public Integer showOriginalBtn;
    public String src;
    public String text;
    public TiebaPlusInfoPojo tiebaplusInfo;
    public String topicSpecialIcon;
    public Integer type;
    public Long uid;
    public Integer urlType;
    public String voiceMd5;
    public Integer width;

    public PbContentPojo() {
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

    public Integer getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.type;
        }
        return (Integer) invokeV.objValue;
    }

    public void N(PbContent pbContent) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, pbContent) != null) || pbContent == null) {
            return;
        }
        this.type = pbContent.type;
        this.text = pbContent.text;
        this.link = pbContent.link;
        this.src = pbContent.src;
        this.bsize = pbContent.bsize;
        this.bigSrc = pbContent.bigSrc;
        this.bigSize = pbContent.bigSize;
        this.cdnSrc = pbContent.cdnSrc;
        this.bigCdnSrc = pbContent.bigCdnSrc;
        this.imgtype = pbContent.imgtype;
        this.c = pbContent.c;
        this.voiceMd5 = pbContent.voiceMd5;
        this.duringTime = pbContent.duringTime;
        this.isSub = pbContent.isSub;
        this.uid = pbContent.uid;
        this.dynamic = pbContent.dynamic;
        this._static = pbContent._static;
        this.width = pbContent.width;
        this.height = pbContent.height;
        this.packetName = pbContent.packetName;
        this.phonetype = pbContent.phonetype;
        this.isNativeApp = pbContent.isNativeApp;
        this.eType = pbContent.eType;
        this.originSrc = pbContent.originSrc;
        this.btnType = pbContent.btnType;
        this.originSize = pbContent.originSize;
        this.count = pbContent.count;
        this.graffitiInfo = GraffitiInfoPojo.N(pbContent.graffitiInfo);
        this.highTogether = TogetherHiPojo.N(pbContent.highTogether);
        this.mediaSubtitle = pbContent.mediaSubtitle;
        this.urlType = pbContent.urlType;
        this.memeInfo = MemeInfoPojo.N(pbContent.memeInfo);
        this.isLongPic = pbContent.isLongPic;
        this.showOriginalBtn = pbContent.showOriginalBtn;
        this.cdnSrcActive = pbContent.cdnSrcActive;
        this.topicSpecialIcon = pbContent.topicSpecialIcon;
        this.itemId = pbContent.itemId;
        this.itemForumName = pbContent.itemForumName;
        this.tiebaplusInfo = TiebaPlusInfoPojo.N(pbContent.tiebaplusInfo);
        this.item = ac8.a(pbContent.item);
        this.picId = pbContent.picId;
    }

    public void O(tbclient.PbContent pbContent) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pbContent) != null) || pbContent == null) {
            return;
        }
        this.type = pbContent.type;
        this.text = pbContent.text;
        this.link = pbContent.link;
        this.src = pbContent.src;
        this.bsize = pbContent.bsize;
        this.bigSrc = pbContent.big_src;
        this.bigSize = pbContent.big_size;
        this.cdnSrc = pbContent.cdn_src;
        this.bigCdnSrc = pbContent.big_cdn_src;
        this.imgtype = pbContent.imgtype;
        this.c = pbContent.c;
        this.voiceMd5 = pbContent.voice_md5;
        this.duringTime = pbContent.during_time;
        this.isSub = pbContent.is_sub;
        this.uid = pbContent.uid;
        this.dynamic = pbContent.dynamic;
        this._static = pbContent._static;
        this.width = pbContent.width;
        this.height = pbContent.height;
        this.packetName = pbContent.packet_name;
        this.phonetype = pbContent.phonetype;
        this.isNativeApp = pbContent.is_native_app;
        this.eType = pbContent.e_type;
        this.originSrc = pbContent.origin_src;
        this.btnType = pbContent.btn_type;
        this.originSize = pbContent.origin_size;
        this.count = pbContent.count;
        this.graffitiInfo = GraffitiInfoPojo.O(pbContent.graffiti_info);
        this.highTogether = TogetherHiPojo.O(pbContent.high_together);
        this.mediaSubtitle = pbContent.media_subtitle;
        this.urlType = pbContent.url_type;
        this.memeInfo = MemeInfoPojo.O(pbContent.meme_info);
        this.isLongPic = pbContent.is_long_pic;
        this.showOriginalBtn = pbContent.show_original_btn;
        this.cdnSrcActive = pbContent.cdn_src_active;
        this.topicSpecialIcon = pbContent.topic_special_icon;
        this.itemId = pbContent.item_id;
        this.itemForumName = pbContent.item_forum_name;
        this.tiebaplusInfo = TiebaPlusInfoPojo.O(pbContent.tiebaplus_info);
        this.item = ac8.b(pbContent.item);
        this.picId = pbContent.pic_id;
    }
}

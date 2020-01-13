package com.baidu.tbadk.data;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes.dex */
public class h {
    public static String bduss;
    public static String drk;
    public static boolean drl = false;
    public static boolean drm = false;
    public Activity activity;
    public int drf;
    public b drg;
    public String drh;
    public c dri;
    public a drj;
    public Object drn;
    public String placeTitle;
    public String placeholder;

    /* loaded from: classes.dex */
    public static final class a {
        public String dro;
        public String drp;
        public String drq;
    }

    /* loaded from: classes.dex */
    public interface b {
        void onSuccess();
    }

    /* loaded from: classes.dex */
    public static final class c {
        public String avatar;
        public String channel;
        public String drr;
        public String id;
        public String nid;
        public String ref_type;
        public String thumbpic;
        public String tid;
        public String title;
        public String url;
        public String video_duration;
    }

    public static h aLr() {
        h hVar = new h();
        hVar.drf = 7;
        return hVar;
    }

    public static h aLs() {
        h hVar = new h();
        hVar.drf = 6;
        return hVar;
    }

    public static h ad(Object obj) {
        h hVar = new h();
        hVar.drf = 5;
        hVar.drn = obj;
        return hVar;
    }

    public static h aLt() {
        h hVar = new h();
        hVar.drf = 2;
        return hVar;
    }

    public static h aLu() {
        h hVar = new h();
        hVar.drf = 1;
        return hVar;
    }

    public static h aLv() {
        h hVar = new h();
        hVar.drf = 3;
        return hVar;
    }

    public static h a(ShareItem.ForwardInfo forwardInfo) {
        if (forwardInfo == null) {
            return null;
        }
        h hVar = new h();
        hVar.drf = 4;
        if (forwardInfo.isShareType) {
            return a(hVar, forwardInfo);
        }
        return b(hVar, forwardInfo);
    }

    private static h a(h hVar, ShareItem.ForwardInfo forwardInfo) {
        if (hVar == null) {
            return null;
        }
        if (!TextUtils.isEmpty(forwardInfo.transmitOriginThreadComment)) {
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(forwardInfo.transmitThreadAuthorNameShow)) {
                sb.append("@");
                sb.append(forwardInfo.transmitThreadAuthorNameShow);
                sb.append(" : ");
                sb.append(forwardInfo.transmitOriginThreadComment);
            } else {
                sb.append(forwardInfo.transmitOriginThreadComment);
            }
            hVar.drh = sb.toString();
        } else {
            hVar.drh = "";
        }
        hVar.dri = new c();
        if (!TextUtils.isEmpty(forwardInfo.showText)) {
            hVar.dri.title = forwardInfo.showText;
        } else {
            hVar.dri.title = TbadkCoreApplication.getInst().getString(R.string.publisher_share_default_title);
        }
        if (!TextUtils.isEmpty(forwardInfo.showPicUrl)) {
            hVar.dri.thumbpic = uA(forwardInfo.showPicUrl);
        } else {
            hVar.dri.thumbpic = "https://b.bdstatic.com/searchbox/mappconsole/image/20180614/1528975601-43867.png";
        }
        if (forwardInfo.isDynamic) {
            if (forwardInfo.originalBaijiahaoData != null && !TextUtils.isEmpty(forwardInfo.originalBaijiahaoData.oriUgcNid)) {
                if (forwardInfo.originalBaijiahaoData.oriUgcType == 1) {
                    hVar.dri.drr = "";
                    hVar.dri.channel = "bjh_details_share_collect_comment";
                    hVar.dri.id = "";
                    hVar.dri.nid = "news_" + forwardInfo.originalBaijiahaoData.oriUgcNid;
                    hVar.dri.ref_type = "imagetext";
                    hVar.dri.url = forwardInfo.originalBaijiahaoData.forwardUrl;
                } else if (forwardInfo.originalBaijiahaoData.oriUgcType == 2) {
                    hVar.dri.drr = "";
                    hVar.dri.channel = "sv_shortdetails_share_collect_comment";
                    hVar.dri.id = "";
                    hVar.dri.nid = "sv_" + forwardInfo.originalBaijiahaoData.oriUgcNid;
                    hVar.dri.ref_type = "video";
                    hVar.dri.url = forwardInfo.originalBaijiahaoData.forwardUrl;
                    hVar.dri.video_duration = forwardInfo.video_duration;
                } else if (forwardInfo.originalBaijiahaoData.oriUgcType == 3) {
                    hVar.dri.drr = "ugcsimple";
                    hVar.dri.channel = "ugc_user_share_collect_comment";
                    hVar.dri.id = forwardInfo.originalBaijiahaoData.oriUgcNid;
                    hVar.dri.nid = "dt_" + forwardInfo.originalBaijiahaoData.oriUgcNid;
                    hVar.dri.ref_type = "imagetext";
                    hVar.dri.avatar = forwardInfo.avatar;
                } else if (forwardInfo.originalBaijiahaoData.oriUgcType == 4) {
                    hVar.dri.drr = "ugcsimple";
                    hVar.dri.channel = "sv_user_share_collect_comment";
                    hVar.dri.id = forwardInfo.originalBaijiahaoData.oriUgcVid;
                    hVar.dri.nid = "dt_" + forwardInfo.originalBaijiahaoData.oriUgcNid;
                    hVar.dri.ref_type = "video";
                    hVar.dri.avatar = forwardInfo.avatar;
                }
            }
        } else {
            hVar.dri.tid = forwardInfo.originalTid;
            hVar.dri.drr = "swan";
            hVar.dri.url = "https://mbd.baidu.com/ma/landingpage?t=smartapp_share&appid=flFqXclepWs7RdugAszy9eERL7G5dS0I&url=/pages/pb/pb?tid=" + forwardInfo.originalTid;
            hVar.dri.channel = "swan_details_tieba_post_share_collect_comment";
            if (forwardInfo.showType == 3) {
                hVar.dri.ref_type = "video";
            } else {
                hVar.dri.ref_type = "imagetext";
            }
        }
        hVar.drj = new a();
        hVar.drj.dro = "forward";
        if (forwardInfo.baijiahaoData != null && !TextUtils.isEmpty(forwardInfo.baijiahaoData.oriUgcNid)) {
            hVar.drj.drp = forwardInfo.baijiahaoData.oriUgcNid;
        }
        hVar.drj.drq = "0";
        return hVar;
    }

    private static h b(h hVar, ShareItem.ForwardInfo forwardInfo) {
        if (hVar == null) {
            return null;
        }
        hVar.drh = "";
        hVar.dri = new c();
        if (!TextUtils.isEmpty(forwardInfo.showText)) {
            hVar.dri.title = forwardInfo.showText;
        } else {
            hVar.dri.title = TbadkCoreApplication.getInst().getString(R.string.publisher_share_default_title);
        }
        if (!TextUtils.isEmpty(forwardInfo.showPicUrl)) {
            hVar.dri.thumbpic = uA(forwardInfo.showPicUrl);
        } else {
            hVar.dri.thumbpic = "https://b.bdstatic.com/searchbox/mappconsole/image/20180614/1528975601-43867.png";
        }
        if (forwardInfo.isDynamic) {
            if (forwardInfo.baijiahaoData != null && !TextUtils.isEmpty(forwardInfo.baijiahaoData.oriUgcNid)) {
                if (forwardInfo.baijiahaoData.oriUgcType == 1) {
                    hVar.dri.drr = "";
                    hVar.dri.channel = "bjh_details_share_collect_comment";
                    hVar.dri.id = "";
                    hVar.dri.nid = "news_" + forwardInfo.baijiahaoData.oriUgcNid;
                    hVar.dri.ref_type = "imagetext";
                    hVar.dri.url = forwardInfo.baijiahaoData.forwardUrl;
                } else if (forwardInfo.baijiahaoData.oriUgcType == 2) {
                    hVar.dri.drr = "";
                    hVar.dri.channel = "sv_shortdetails_share_collect_comment";
                    hVar.dri.id = "";
                    hVar.dri.nid = "sv_" + forwardInfo.baijiahaoData.oriUgcNid;
                    hVar.dri.ref_type = "video";
                    hVar.dri.url = forwardInfo.baijiahaoData.forwardUrl;
                    hVar.dri.video_duration = forwardInfo.video_duration;
                } else if (forwardInfo.baijiahaoData.oriUgcType == 3) {
                    hVar.dri.drr = "ugcsimple";
                    hVar.dri.channel = "ugc_user_share_collect_comment";
                    hVar.dri.id = forwardInfo.baijiahaoData.oriUgcNid;
                    hVar.dri.nid = "dt_" + forwardInfo.baijiahaoData.oriUgcNid;
                    hVar.dri.ref_type = "imagetext";
                    hVar.dri.avatar = forwardInfo.avatar;
                } else if (forwardInfo.baijiahaoData.oriUgcType == 4) {
                    hVar.dri.drr = "ugcsimple";
                    hVar.dri.channel = "sv_user_share_collect_comment";
                    hVar.dri.id = forwardInfo.baijiahaoData.oriUgcVid;
                    hVar.dri.nid = "dt_" + forwardInfo.baijiahaoData.oriUgcNid;
                    hVar.dri.ref_type = "video";
                    hVar.dri.avatar = forwardInfo.avatar;
                }
            }
        } else {
            hVar.dri.tid = forwardInfo.originalTid;
            hVar.dri.drr = "swan";
            hVar.dri.url = "https://mbd.baidu.com/ma/landingpage?t=smartapp_share&appid=flFqXclepWs7RdugAszy9eERL7G5dS0I&url=/pages/pb/pb?tid=" + forwardInfo.originalTid;
            hVar.dri.channel = "swan_details_tieba_post_share_collect_comment";
            if (forwardInfo.showType == 3) {
                hVar.dri.ref_type = "video";
            } else {
                hVar.dri.ref_type = "imagetext";
            }
        }
        hVar.drj = new a();
        hVar.drj.dro = "forward";
        hVar.drj.drq = "0";
        return hVar;
    }

    public static String uA(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
            int indexOf = str.indexOf(ETAG.EQUAL);
            int length = str.length();
            if (indexOf != -1 && indexOf + 1 != length) {
                String urlDecode = com.baidu.adp.lib.util.k.getUrlDecode(str.substring(indexOf + 1));
                return !TextUtils.isEmpty(urlDecode) ? urlDecode : str;
            }
            return str;
        }
        return str;
    }
}

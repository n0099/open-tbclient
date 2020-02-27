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
    public static String dvs;
    public static boolean dvt = false;
    public static boolean dvu = false;
    public Activity activity;
    public int dvn;
    public b dvo;
    public String dvp;
    public c dvq;
    public a dvr;
    public Object dvv;
    public String placeTitle;
    public String placeholder;

    /* loaded from: classes.dex */
    public static final class a {
        public String dvw;
        public String dvx;
        public String dvy;
    }

    /* loaded from: classes.dex */
    public interface b {
        void onSuccess();
    }

    /* loaded from: classes.dex */
    public static final class c {
        public String avatar;
        public String channel;
        public String dvz;
        public String id;
        public String nid;
        public String ref_type;
        public String thumbpic;
        public String tid;
        public String title;
        public String url;
        public String video_duration;
    }

    public static h aNN() {
        h hVar = new h();
        hVar.dvn = 7;
        return hVar;
    }

    public static h aNO() {
        h hVar = new h();
        hVar.dvn = 6;
        return hVar;
    }

    public static h af(Object obj) {
        h hVar = new h();
        hVar.dvn = 5;
        hVar.dvv = obj;
        return hVar;
    }

    public static h aNP() {
        h hVar = new h();
        hVar.dvn = 2;
        return hVar;
    }

    public static h aNQ() {
        h hVar = new h();
        hVar.dvn = 1;
        return hVar;
    }

    public static h aNR() {
        h hVar = new h();
        hVar.dvn = 3;
        return hVar;
    }

    public static h a(ShareItem.ForwardInfo forwardInfo) {
        if (forwardInfo == null) {
            return null;
        }
        h hVar = new h();
        hVar.dvn = 4;
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
            hVar.dvp = sb.toString();
        } else {
            hVar.dvp = "";
        }
        hVar.dvq = new c();
        if (!TextUtils.isEmpty(forwardInfo.showText)) {
            hVar.dvq.title = forwardInfo.showText;
        } else {
            hVar.dvq.title = TbadkCoreApplication.getInst().getString(R.string.publisher_share_default_title);
        }
        if (!TextUtils.isEmpty(forwardInfo.showPicUrl)) {
            hVar.dvq.thumbpic = uR(forwardInfo.showPicUrl);
        } else {
            hVar.dvq.thumbpic = "https://b.bdstatic.com/searchbox/mappconsole/image/20180614/1528975601-43867.png";
        }
        if (forwardInfo.isDynamic) {
            if (forwardInfo.originalBaijiahaoData != null && !TextUtils.isEmpty(forwardInfo.originalBaijiahaoData.oriUgcNid)) {
                if (forwardInfo.originalBaijiahaoData.oriUgcType == 1) {
                    hVar.dvq.dvz = "";
                    hVar.dvq.channel = "bjh_details_share_collect_comment";
                    hVar.dvq.id = "";
                    hVar.dvq.nid = "news_" + forwardInfo.originalBaijiahaoData.oriUgcNid;
                    hVar.dvq.ref_type = "imagetext";
                    hVar.dvq.url = forwardInfo.originalBaijiahaoData.forwardUrl;
                } else if (forwardInfo.originalBaijiahaoData.oriUgcType == 2) {
                    hVar.dvq.dvz = "";
                    hVar.dvq.channel = "sv_shortdetails_share_collect_comment";
                    hVar.dvq.id = "";
                    hVar.dvq.nid = "sv_" + forwardInfo.originalBaijiahaoData.oriUgcNid;
                    hVar.dvq.ref_type = "video";
                    hVar.dvq.url = forwardInfo.originalBaijiahaoData.forwardUrl;
                    hVar.dvq.video_duration = forwardInfo.video_duration;
                } else if (forwardInfo.originalBaijiahaoData.oriUgcType == 3) {
                    hVar.dvq.dvz = "ugcsimple";
                    hVar.dvq.channel = "ugc_user_share_collect_comment";
                    hVar.dvq.id = forwardInfo.originalBaijiahaoData.oriUgcNid;
                    hVar.dvq.nid = "dt_" + forwardInfo.originalBaijiahaoData.oriUgcNid;
                    hVar.dvq.ref_type = "imagetext";
                    hVar.dvq.avatar = forwardInfo.avatar;
                } else if (forwardInfo.originalBaijiahaoData.oriUgcType == 4) {
                    hVar.dvq.dvz = "ugcsimple";
                    hVar.dvq.channel = "sv_user_share_collect_comment";
                    hVar.dvq.id = forwardInfo.originalBaijiahaoData.oriUgcVid;
                    hVar.dvq.nid = "dt_" + forwardInfo.originalBaijiahaoData.oriUgcNid;
                    hVar.dvq.ref_type = "video";
                    hVar.dvq.avatar = forwardInfo.avatar;
                }
            }
        } else {
            hVar.dvq.tid = forwardInfo.originalTid;
            hVar.dvq.dvz = "swan";
            hVar.dvq.url = "https://mbd.baidu.com/ma/landingpage?t=smartapp_share&appid=flFqXclepWs7RdugAszy9eERL7G5dS0I&url=/pages/pb/pb?tid=" + forwardInfo.originalTid;
            hVar.dvq.channel = "swan_details_tieba_post_share_collect_comment";
            if (forwardInfo.showType == 3) {
                hVar.dvq.ref_type = "video";
            } else {
                hVar.dvq.ref_type = "imagetext";
            }
        }
        hVar.dvr = new a();
        hVar.dvr.dvw = "forward";
        if (forwardInfo.baijiahaoData != null && !TextUtils.isEmpty(forwardInfo.baijiahaoData.oriUgcNid)) {
            hVar.dvr.dvx = forwardInfo.baijiahaoData.oriUgcNid;
        }
        hVar.dvr.dvy = "0";
        return hVar;
    }

    private static h b(h hVar, ShareItem.ForwardInfo forwardInfo) {
        if (hVar == null) {
            return null;
        }
        hVar.dvp = "";
        hVar.dvq = new c();
        if (!TextUtils.isEmpty(forwardInfo.showText)) {
            hVar.dvq.title = forwardInfo.showText;
        } else {
            hVar.dvq.title = TbadkCoreApplication.getInst().getString(R.string.publisher_share_default_title);
        }
        if (!TextUtils.isEmpty(forwardInfo.showPicUrl)) {
            hVar.dvq.thumbpic = uR(forwardInfo.showPicUrl);
        } else {
            hVar.dvq.thumbpic = "https://b.bdstatic.com/searchbox/mappconsole/image/20180614/1528975601-43867.png";
        }
        if (forwardInfo.isDynamic) {
            if (forwardInfo.baijiahaoData != null && !TextUtils.isEmpty(forwardInfo.baijiahaoData.oriUgcNid)) {
                if (forwardInfo.baijiahaoData.oriUgcType == 1) {
                    hVar.dvq.dvz = "";
                    hVar.dvq.channel = "bjh_details_share_collect_comment";
                    hVar.dvq.id = "";
                    hVar.dvq.nid = "news_" + forwardInfo.baijiahaoData.oriUgcNid;
                    hVar.dvq.ref_type = "imagetext";
                    hVar.dvq.url = forwardInfo.baijiahaoData.forwardUrl;
                } else if (forwardInfo.baijiahaoData.oriUgcType == 2) {
                    hVar.dvq.dvz = "";
                    hVar.dvq.channel = "sv_shortdetails_share_collect_comment";
                    hVar.dvq.id = "";
                    hVar.dvq.nid = "sv_" + forwardInfo.baijiahaoData.oriUgcNid;
                    hVar.dvq.ref_type = "video";
                    hVar.dvq.url = forwardInfo.baijiahaoData.forwardUrl;
                    hVar.dvq.video_duration = forwardInfo.video_duration;
                } else if (forwardInfo.baijiahaoData.oriUgcType == 3) {
                    hVar.dvq.dvz = "ugcsimple";
                    hVar.dvq.channel = "ugc_user_share_collect_comment";
                    hVar.dvq.id = forwardInfo.baijiahaoData.oriUgcNid;
                    hVar.dvq.nid = "dt_" + forwardInfo.baijiahaoData.oriUgcNid;
                    hVar.dvq.ref_type = "imagetext";
                    hVar.dvq.avatar = forwardInfo.avatar;
                } else if (forwardInfo.baijiahaoData.oriUgcType == 4) {
                    hVar.dvq.dvz = "ugcsimple";
                    hVar.dvq.channel = "sv_user_share_collect_comment";
                    hVar.dvq.id = forwardInfo.baijiahaoData.oriUgcVid;
                    hVar.dvq.nid = "dt_" + forwardInfo.baijiahaoData.oriUgcNid;
                    hVar.dvq.ref_type = "video";
                    hVar.dvq.avatar = forwardInfo.avatar;
                }
            }
        } else {
            hVar.dvq.tid = forwardInfo.originalTid;
            hVar.dvq.dvz = "swan";
            hVar.dvq.url = "https://mbd.baidu.com/ma/landingpage?t=smartapp_share&appid=flFqXclepWs7RdugAszy9eERL7G5dS0I&url=/pages/pb/pb?tid=" + forwardInfo.originalTid;
            hVar.dvq.channel = "swan_details_tieba_post_share_collect_comment";
            if (forwardInfo.showType == 3) {
                hVar.dvq.ref_type = "video";
            } else {
                hVar.dvq.ref_type = "imagetext";
            }
        }
        hVar.dvr = new a();
        hVar.dvr.dvw = "forward";
        hVar.dvr.dvy = "0";
        return hVar;
    }

    public static String uR(String str) {
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

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
    public static String dqZ;
    public static boolean dra = false;
    public static boolean drb = false;
    public Activity activity;
    public int dqU;
    public b dqV;
    public String dqW;
    public c dqX;
    public a dqY;
    public Object drc;
    public String placeTitle;
    public String placeholder;

    /* loaded from: classes.dex */
    public static final class a {
        public String drd;
        public String dre;
        public String drf;
    }

    /* loaded from: classes.dex */
    public interface b {
        void onSuccess();
    }

    /* loaded from: classes.dex */
    public static final class c {
        public String avatar;
        public String channel;
        public String drg;
        public String id;
        public String nid;
        public String ref_type;
        public String thumbpic;
        public String tid;
        public String title;
        public String url;
        public String video_duration;
    }

    public static h aKY() {
        h hVar = new h();
        hVar.dqU = 7;
        return hVar;
    }

    public static h aKZ() {
        h hVar = new h();
        hVar.dqU = 6;
        return hVar;
    }

    public static h ad(Object obj) {
        h hVar = new h();
        hVar.dqU = 5;
        hVar.drc = obj;
        return hVar;
    }

    public static h aLa() {
        h hVar = new h();
        hVar.dqU = 2;
        return hVar;
    }

    public static h aLb() {
        h hVar = new h();
        hVar.dqU = 1;
        return hVar;
    }

    public static h aLc() {
        h hVar = new h();
        hVar.dqU = 3;
        return hVar;
    }

    public static h a(ShareItem.ForwardInfo forwardInfo) {
        if (forwardInfo == null) {
            return null;
        }
        h hVar = new h();
        hVar.dqU = 4;
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
            hVar.dqW = sb.toString();
        } else {
            hVar.dqW = "";
        }
        hVar.dqX = new c();
        if (!TextUtils.isEmpty(forwardInfo.showText)) {
            hVar.dqX.title = forwardInfo.showText;
        } else {
            hVar.dqX.title = TbadkCoreApplication.getInst().getString(R.string.publisher_share_default_title);
        }
        if (!TextUtils.isEmpty(forwardInfo.showPicUrl)) {
            hVar.dqX.thumbpic = uv(forwardInfo.showPicUrl);
        } else {
            hVar.dqX.thumbpic = "https://b.bdstatic.com/searchbox/mappconsole/image/20180614/1528975601-43867.png";
        }
        if (forwardInfo.isDynamic) {
            if (forwardInfo.originalBaijiahaoData != null && !TextUtils.isEmpty(forwardInfo.originalBaijiahaoData.oriUgcNid)) {
                if (forwardInfo.originalBaijiahaoData.oriUgcType == 1) {
                    hVar.dqX.drg = "";
                    hVar.dqX.channel = "bjh_details_share_collect_comment";
                    hVar.dqX.id = "";
                    hVar.dqX.nid = "news_" + forwardInfo.originalBaijiahaoData.oriUgcNid;
                    hVar.dqX.ref_type = "imagetext";
                    hVar.dqX.url = forwardInfo.originalBaijiahaoData.forwardUrl;
                } else if (forwardInfo.originalBaijiahaoData.oriUgcType == 2) {
                    hVar.dqX.drg = "";
                    hVar.dqX.channel = "sv_shortdetails_share_collect_comment";
                    hVar.dqX.id = "";
                    hVar.dqX.nid = "sv_" + forwardInfo.originalBaijiahaoData.oriUgcNid;
                    hVar.dqX.ref_type = "video";
                    hVar.dqX.url = forwardInfo.originalBaijiahaoData.forwardUrl;
                    hVar.dqX.video_duration = forwardInfo.video_duration;
                } else if (forwardInfo.originalBaijiahaoData.oriUgcType == 3) {
                    hVar.dqX.drg = "ugcsimple";
                    hVar.dqX.channel = "ugc_user_share_collect_comment";
                    hVar.dqX.id = forwardInfo.originalBaijiahaoData.oriUgcNid;
                    hVar.dqX.nid = "dt_" + forwardInfo.originalBaijiahaoData.oriUgcNid;
                    hVar.dqX.ref_type = "imagetext";
                    hVar.dqX.avatar = forwardInfo.avatar;
                } else if (forwardInfo.originalBaijiahaoData.oriUgcType == 4) {
                    hVar.dqX.drg = "ugcsimple";
                    hVar.dqX.channel = "sv_user_share_collect_comment";
                    hVar.dqX.id = forwardInfo.originalBaijiahaoData.oriUgcVid;
                    hVar.dqX.nid = "dt_" + forwardInfo.originalBaijiahaoData.oriUgcNid;
                    hVar.dqX.ref_type = "video";
                    hVar.dqX.avatar = forwardInfo.avatar;
                }
            }
        } else {
            hVar.dqX.tid = forwardInfo.originalTid;
            hVar.dqX.drg = "swan";
            hVar.dqX.url = "https://mbd.baidu.com/ma/landingpage?t=smartapp_share&appid=flFqXclepWs7RdugAszy9eERL7G5dS0I&url=/pages/pb/pb?tid=" + forwardInfo.originalTid;
            hVar.dqX.channel = "swan_details_tieba_post_share_collect_comment";
            if (forwardInfo.showType == 3) {
                hVar.dqX.ref_type = "video";
            } else {
                hVar.dqX.ref_type = "imagetext";
            }
        }
        hVar.dqY = new a();
        hVar.dqY.drd = "forward";
        if (forwardInfo.baijiahaoData != null && !TextUtils.isEmpty(forwardInfo.baijiahaoData.oriUgcNid)) {
            hVar.dqY.dre = forwardInfo.baijiahaoData.oriUgcNid;
        }
        hVar.dqY.drf = "0";
        return hVar;
    }

    private static h b(h hVar, ShareItem.ForwardInfo forwardInfo) {
        if (hVar == null) {
            return null;
        }
        hVar.dqW = "";
        hVar.dqX = new c();
        if (!TextUtils.isEmpty(forwardInfo.showText)) {
            hVar.dqX.title = forwardInfo.showText;
        } else {
            hVar.dqX.title = TbadkCoreApplication.getInst().getString(R.string.publisher_share_default_title);
        }
        if (!TextUtils.isEmpty(forwardInfo.showPicUrl)) {
            hVar.dqX.thumbpic = uv(forwardInfo.showPicUrl);
        } else {
            hVar.dqX.thumbpic = "https://b.bdstatic.com/searchbox/mappconsole/image/20180614/1528975601-43867.png";
        }
        if (forwardInfo.isDynamic) {
            if (forwardInfo.baijiahaoData != null && !TextUtils.isEmpty(forwardInfo.baijiahaoData.oriUgcNid)) {
                if (forwardInfo.baijiahaoData.oriUgcType == 1) {
                    hVar.dqX.drg = "";
                    hVar.dqX.channel = "bjh_details_share_collect_comment";
                    hVar.dqX.id = "";
                    hVar.dqX.nid = "news_" + forwardInfo.baijiahaoData.oriUgcNid;
                    hVar.dqX.ref_type = "imagetext";
                    hVar.dqX.url = forwardInfo.baijiahaoData.forwardUrl;
                } else if (forwardInfo.baijiahaoData.oriUgcType == 2) {
                    hVar.dqX.drg = "";
                    hVar.dqX.channel = "sv_shortdetails_share_collect_comment";
                    hVar.dqX.id = "";
                    hVar.dqX.nid = "sv_" + forwardInfo.baijiahaoData.oriUgcNid;
                    hVar.dqX.ref_type = "video";
                    hVar.dqX.url = forwardInfo.baijiahaoData.forwardUrl;
                    hVar.dqX.video_duration = forwardInfo.video_duration;
                } else if (forwardInfo.baijiahaoData.oriUgcType == 3) {
                    hVar.dqX.drg = "ugcsimple";
                    hVar.dqX.channel = "ugc_user_share_collect_comment";
                    hVar.dqX.id = forwardInfo.baijiahaoData.oriUgcNid;
                    hVar.dqX.nid = "dt_" + forwardInfo.baijiahaoData.oriUgcNid;
                    hVar.dqX.ref_type = "imagetext";
                    hVar.dqX.avatar = forwardInfo.avatar;
                } else if (forwardInfo.baijiahaoData.oriUgcType == 4) {
                    hVar.dqX.drg = "ugcsimple";
                    hVar.dqX.channel = "sv_user_share_collect_comment";
                    hVar.dqX.id = forwardInfo.baijiahaoData.oriUgcVid;
                    hVar.dqX.nid = "dt_" + forwardInfo.baijiahaoData.oriUgcNid;
                    hVar.dqX.ref_type = "video";
                    hVar.dqX.avatar = forwardInfo.avatar;
                }
            }
        } else {
            hVar.dqX.tid = forwardInfo.originalTid;
            hVar.dqX.drg = "swan";
            hVar.dqX.url = "https://mbd.baidu.com/ma/landingpage?t=smartapp_share&appid=flFqXclepWs7RdugAszy9eERL7G5dS0I&url=/pages/pb/pb?tid=" + forwardInfo.originalTid;
            hVar.dqX.channel = "swan_details_tieba_post_share_collect_comment";
            if (forwardInfo.showType == 3) {
                hVar.dqX.ref_type = "video";
            } else {
                hVar.dqX.ref_type = "imagetext";
            }
        }
        hVar.dqY = new a();
        hVar.dqY.drd = "forward";
        hVar.dqY.drf = "0";
        return hVar;
    }

    public static String uv(String str) {
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

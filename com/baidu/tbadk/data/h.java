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
    public static String dvG;
    public static boolean dvH = false;
    public static boolean dvI = false;
    public Activity activity;
    public int dvB;
    public b dvC;
    public String dvD;
    public c dvE;
    public a dvF;
    public Object dvJ;
    public String placeTitle;
    public String placeholder;

    /* loaded from: classes.dex */
    public static final class a {
        public String dvK;
        public String dvL;
        public String dvM;
    }

    /* loaded from: classes.dex */
    public interface b {
        void onSuccess();
    }

    /* loaded from: classes.dex */
    public static final class c {
        public String avatar;
        public String channel;
        public String dvN;
        public String id;
        public String nid;
        public String ref_type;
        public String thumbpic;
        public String tid;
        public String title;
        public String url;
        public String video_duration;
    }

    public static h aNQ() {
        h hVar = new h();
        hVar.dvB = 7;
        return hVar;
    }

    public static h aNR() {
        h hVar = new h();
        hVar.dvB = 6;
        return hVar;
    }

    public static h af(Object obj) {
        h hVar = new h();
        hVar.dvB = 5;
        hVar.dvJ = obj;
        return hVar;
    }

    public static h aNS() {
        h hVar = new h();
        hVar.dvB = 2;
        return hVar;
    }

    public static h aNT() {
        h hVar = new h();
        hVar.dvB = 1;
        return hVar;
    }

    public static h aNU() {
        h hVar = new h();
        hVar.dvB = 3;
        return hVar;
    }

    public static h a(ShareItem.ForwardInfo forwardInfo) {
        if (forwardInfo == null) {
            return null;
        }
        h hVar = new h();
        hVar.dvB = 4;
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
            hVar.dvD = sb.toString();
        } else {
            hVar.dvD = "";
        }
        hVar.dvE = new c();
        if (!TextUtils.isEmpty(forwardInfo.showText)) {
            hVar.dvE.title = forwardInfo.showText;
        } else {
            hVar.dvE.title = TbadkCoreApplication.getInst().getString(R.string.publisher_share_default_title);
        }
        if (!TextUtils.isEmpty(forwardInfo.showPicUrl)) {
            hVar.dvE.thumbpic = uS(forwardInfo.showPicUrl);
        } else {
            hVar.dvE.thumbpic = "https://b.bdstatic.com/searchbox/mappconsole/image/20180614/1528975601-43867.png";
        }
        if (forwardInfo.isDynamic) {
            if (forwardInfo.originalBaijiahaoData != null && !TextUtils.isEmpty(forwardInfo.originalBaijiahaoData.oriUgcNid)) {
                if (forwardInfo.originalBaijiahaoData.oriUgcType == 1) {
                    hVar.dvE.dvN = "";
                    hVar.dvE.channel = "bjh_details_share_collect_comment";
                    hVar.dvE.id = "";
                    hVar.dvE.nid = "news_" + forwardInfo.originalBaijiahaoData.oriUgcNid;
                    hVar.dvE.ref_type = "imagetext";
                    hVar.dvE.url = forwardInfo.originalBaijiahaoData.forwardUrl;
                } else if (forwardInfo.originalBaijiahaoData.oriUgcType == 2) {
                    hVar.dvE.dvN = "";
                    hVar.dvE.channel = "sv_shortdetails_share_collect_comment";
                    hVar.dvE.id = "";
                    hVar.dvE.nid = "sv_" + forwardInfo.originalBaijiahaoData.oriUgcNid;
                    hVar.dvE.ref_type = "video";
                    hVar.dvE.url = forwardInfo.originalBaijiahaoData.forwardUrl;
                    hVar.dvE.video_duration = forwardInfo.video_duration;
                } else if (forwardInfo.originalBaijiahaoData.oriUgcType == 3) {
                    hVar.dvE.dvN = "ugcsimple";
                    hVar.dvE.channel = "ugc_user_share_collect_comment";
                    hVar.dvE.id = forwardInfo.originalBaijiahaoData.oriUgcNid;
                    hVar.dvE.nid = "dt_" + forwardInfo.originalBaijiahaoData.oriUgcNid;
                    hVar.dvE.ref_type = "imagetext";
                    hVar.dvE.avatar = forwardInfo.avatar;
                } else if (forwardInfo.originalBaijiahaoData.oriUgcType == 4) {
                    hVar.dvE.dvN = "ugcsimple";
                    hVar.dvE.channel = "sv_user_share_collect_comment";
                    hVar.dvE.id = forwardInfo.originalBaijiahaoData.oriUgcVid;
                    hVar.dvE.nid = "dt_" + forwardInfo.originalBaijiahaoData.oriUgcNid;
                    hVar.dvE.ref_type = "video";
                    hVar.dvE.avatar = forwardInfo.avatar;
                }
            }
        } else {
            hVar.dvE.tid = forwardInfo.originalTid;
            hVar.dvE.dvN = "swan";
            hVar.dvE.url = "https://mbd.baidu.com/ma/landingpage?t=smartapp_share&appid=flFqXclepWs7RdugAszy9eERL7G5dS0I&url=/pages/pb/pb?tid=" + forwardInfo.originalTid;
            hVar.dvE.channel = "swan_details_tieba_post_share_collect_comment";
            if (forwardInfo.showType == 3) {
                hVar.dvE.ref_type = "video";
            } else {
                hVar.dvE.ref_type = "imagetext";
            }
        }
        hVar.dvF = new a();
        hVar.dvF.dvK = "forward";
        if (forwardInfo.baijiahaoData != null && !TextUtils.isEmpty(forwardInfo.baijiahaoData.oriUgcNid)) {
            hVar.dvF.dvL = forwardInfo.baijiahaoData.oriUgcNid;
        }
        hVar.dvF.dvM = "0";
        return hVar;
    }

    private static h b(h hVar, ShareItem.ForwardInfo forwardInfo) {
        if (hVar == null) {
            return null;
        }
        hVar.dvD = "";
        hVar.dvE = new c();
        if (!TextUtils.isEmpty(forwardInfo.showText)) {
            hVar.dvE.title = forwardInfo.showText;
        } else {
            hVar.dvE.title = TbadkCoreApplication.getInst().getString(R.string.publisher_share_default_title);
        }
        if (!TextUtils.isEmpty(forwardInfo.showPicUrl)) {
            hVar.dvE.thumbpic = uS(forwardInfo.showPicUrl);
        } else {
            hVar.dvE.thumbpic = "https://b.bdstatic.com/searchbox/mappconsole/image/20180614/1528975601-43867.png";
        }
        if (forwardInfo.isDynamic) {
            if (forwardInfo.baijiahaoData != null && !TextUtils.isEmpty(forwardInfo.baijiahaoData.oriUgcNid)) {
                if (forwardInfo.baijiahaoData.oriUgcType == 1) {
                    hVar.dvE.dvN = "";
                    hVar.dvE.channel = "bjh_details_share_collect_comment";
                    hVar.dvE.id = "";
                    hVar.dvE.nid = "news_" + forwardInfo.baijiahaoData.oriUgcNid;
                    hVar.dvE.ref_type = "imagetext";
                    hVar.dvE.url = forwardInfo.baijiahaoData.forwardUrl;
                } else if (forwardInfo.baijiahaoData.oriUgcType == 2) {
                    hVar.dvE.dvN = "";
                    hVar.dvE.channel = "sv_shortdetails_share_collect_comment";
                    hVar.dvE.id = "";
                    hVar.dvE.nid = "sv_" + forwardInfo.baijiahaoData.oriUgcNid;
                    hVar.dvE.ref_type = "video";
                    hVar.dvE.url = forwardInfo.baijiahaoData.forwardUrl;
                    hVar.dvE.video_duration = forwardInfo.video_duration;
                } else if (forwardInfo.baijiahaoData.oriUgcType == 3) {
                    hVar.dvE.dvN = "ugcsimple";
                    hVar.dvE.channel = "ugc_user_share_collect_comment";
                    hVar.dvE.id = forwardInfo.baijiahaoData.oriUgcNid;
                    hVar.dvE.nid = "dt_" + forwardInfo.baijiahaoData.oriUgcNid;
                    hVar.dvE.ref_type = "imagetext";
                    hVar.dvE.avatar = forwardInfo.avatar;
                } else if (forwardInfo.baijiahaoData.oriUgcType == 4) {
                    hVar.dvE.dvN = "ugcsimple";
                    hVar.dvE.channel = "sv_user_share_collect_comment";
                    hVar.dvE.id = forwardInfo.baijiahaoData.oriUgcVid;
                    hVar.dvE.nid = "dt_" + forwardInfo.baijiahaoData.oriUgcNid;
                    hVar.dvE.ref_type = "video";
                    hVar.dvE.avatar = forwardInfo.avatar;
                }
            }
        } else {
            hVar.dvE.tid = forwardInfo.originalTid;
            hVar.dvE.dvN = "swan";
            hVar.dvE.url = "https://mbd.baidu.com/ma/landingpage?t=smartapp_share&appid=flFqXclepWs7RdugAszy9eERL7G5dS0I&url=/pages/pb/pb?tid=" + forwardInfo.originalTid;
            hVar.dvE.channel = "swan_details_tieba_post_share_collect_comment";
            if (forwardInfo.showType == 3) {
                hVar.dvE.ref_type = "video";
            } else {
                hVar.dvE.ref_type = "imagetext";
            }
        }
        hVar.dvF = new a();
        hVar.dvF.dvK = "forward";
        hVar.dvF.dvM = "0";
        return hVar;
    }

    public static String uS(String str) {
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

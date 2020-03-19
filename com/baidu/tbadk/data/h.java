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
    public static String dvT;
    public static boolean dvU = false;
    public static boolean dvV = false;
    public Activity activity;
    public int dvO;
    public b dvP;
    public String dvQ;
    public c dvR;
    public a dvS;
    public Object dvW;
    public String placeTitle;
    public String placeholder;

    /* loaded from: classes.dex */
    public static final class a {
        public String dvX;
        public String dvY;
        public String dvZ;
    }

    /* loaded from: classes.dex */
    public interface b {
        void onSuccess();
    }

    /* loaded from: classes.dex */
    public static final class c {
        public String avatar;
        public String channel;
        public String dwa;
        public String id;
        public String nid;
        public String ref_type;
        public String thumbpic;
        public String tid;
        public String title;
        public String url;
        public String video_duration;
    }

    public static h aNU() {
        h hVar = new h();
        hVar.dvO = 7;
        return hVar;
    }

    public static h aNV() {
        h hVar = new h();
        hVar.dvO = 6;
        return hVar;
    }

    public static h af(Object obj) {
        h hVar = new h();
        hVar.dvO = 5;
        hVar.dvW = obj;
        return hVar;
    }

    public static h aNW() {
        h hVar = new h();
        hVar.dvO = 2;
        return hVar;
    }

    public static h aNX() {
        h hVar = new h();
        hVar.dvO = 1;
        return hVar;
    }

    public static h aNY() {
        h hVar = new h();
        hVar.dvO = 3;
        return hVar;
    }

    public static h a(ShareItem.ForwardInfo forwardInfo) {
        if (forwardInfo == null) {
            return null;
        }
        h hVar = new h();
        hVar.dvO = 4;
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
            hVar.dvQ = sb.toString();
        } else {
            hVar.dvQ = "";
        }
        hVar.dvR = new c();
        if (!TextUtils.isEmpty(forwardInfo.showText)) {
            hVar.dvR.title = forwardInfo.showText;
        } else {
            hVar.dvR.title = TbadkCoreApplication.getInst().getString(R.string.publisher_share_default_title);
        }
        if (!TextUtils.isEmpty(forwardInfo.showPicUrl)) {
            hVar.dvR.thumbpic = uS(forwardInfo.showPicUrl);
        } else {
            hVar.dvR.thumbpic = "https://b.bdstatic.com/searchbox/mappconsole/image/20180614/1528975601-43867.png";
        }
        if (forwardInfo.isDynamic) {
            if (forwardInfo.originalBaijiahaoData != null && !TextUtils.isEmpty(forwardInfo.originalBaijiahaoData.oriUgcNid)) {
                if (forwardInfo.originalBaijiahaoData.oriUgcType == 1) {
                    hVar.dvR.dwa = "";
                    hVar.dvR.channel = "bjh_details_share_collect_comment";
                    hVar.dvR.id = "";
                    hVar.dvR.nid = "news_" + forwardInfo.originalBaijiahaoData.oriUgcNid;
                    hVar.dvR.ref_type = "imagetext";
                    hVar.dvR.url = forwardInfo.originalBaijiahaoData.forwardUrl;
                } else if (forwardInfo.originalBaijiahaoData.oriUgcType == 2) {
                    hVar.dvR.dwa = "";
                    hVar.dvR.channel = "sv_shortdetails_share_collect_comment";
                    hVar.dvR.id = "";
                    hVar.dvR.nid = "sv_" + forwardInfo.originalBaijiahaoData.oriUgcNid;
                    hVar.dvR.ref_type = "video";
                    hVar.dvR.url = forwardInfo.originalBaijiahaoData.forwardUrl;
                    hVar.dvR.video_duration = forwardInfo.video_duration;
                } else if (forwardInfo.originalBaijiahaoData.oriUgcType == 3) {
                    hVar.dvR.dwa = "ugcsimple";
                    hVar.dvR.channel = "ugc_user_share_collect_comment";
                    hVar.dvR.id = forwardInfo.originalBaijiahaoData.oriUgcNid;
                    hVar.dvR.nid = "dt_" + forwardInfo.originalBaijiahaoData.oriUgcNid;
                    hVar.dvR.ref_type = "imagetext";
                    hVar.dvR.avatar = forwardInfo.avatar;
                } else if (forwardInfo.originalBaijiahaoData.oriUgcType == 4) {
                    hVar.dvR.dwa = "ugcsimple";
                    hVar.dvR.channel = "sv_user_share_collect_comment";
                    hVar.dvR.id = forwardInfo.originalBaijiahaoData.oriUgcVid;
                    hVar.dvR.nid = "dt_" + forwardInfo.originalBaijiahaoData.oriUgcNid;
                    hVar.dvR.ref_type = "video";
                    hVar.dvR.avatar = forwardInfo.avatar;
                }
            }
        } else {
            hVar.dvR.tid = forwardInfo.originalTid;
            hVar.dvR.dwa = "swan";
            hVar.dvR.url = "https://mbd.baidu.com/ma/landingpage?t=smartapp_share&appid=flFqXclepWs7RdugAszy9eERL7G5dS0I&url=/pages/pb/pb?tid=" + forwardInfo.originalTid;
            hVar.dvR.channel = "swan_details_tieba_post_share_collect_comment";
            if (forwardInfo.showType == 3) {
                hVar.dvR.ref_type = "video";
            } else {
                hVar.dvR.ref_type = "imagetext";
            }
        }
        hVar.dvS = new a();
        hVar.dvS.dvX = "forward";
        if (forwardInfo.baijiahaoData != null && !TextUtils.isEmpty(forwardInfo.baijiahaoData.oriUgcNid)) {
            hVar.dvS.dvY = forwardInfo.baijiahaoData.oriUgcNid;
        }
        hVar.dvS.dvZ = "0";
        return hVar;
    }

    private static h b(h hVar, ShareItem.ForwardInfo forwardInfo) {
        if (hVar == null) {
            return null;
        }
        hVar.dvQ = "";
        hVar.dvR = new c();
        if (!TextUtils.isEmpty(forwardInfo.showText)) {
            hVar.dvR.title = forwardInfo.showText;
        } else {
            hVar.dvR.title = TbadkCoreApplication.getInst().getString(R.string.publisher_share_default_title);
        }
        if (!TextUtils.isEmpty(forwardInfo.showPicUrl)) {
            hVar.dvR.thumbpic = uS(forwardInfo.showPicUrl);
        } else {
            hVar.dvR.thumbpic = "https://b.bdstatic.com/searchbox/mappconsole/image/20180614/1528975601-43867.png";
        }
        if (forwardInfo.isDynamic) {
            if (forwardInfo.baijiahaoData != null && !TextUtils.isEmpty(forwardInfo.baijiahaoData.oriUgcNid)) {
                if (forwardInfo.baijiahaoData.oriUgcType == 1) {
                    hVar.dvR.dwa = "";
                    hVar.dvR.channel = "bjh_details_share_collect_comment";
                    hVar.dvR.id = "";
                    hVar.dvR.nid = "news_" + forwardInfo.baijiahaoData.oriUgcNid;
                    hVar.dvR.ref_type = "imagetext";
                    hVar.dvR.url = forwardInfo.baijiahaoData.forwardUrl;
                } else if (forwardInfo.baijiahaoData.oriUgcType == 2) {
                    hVar.dvR.dwa = "";
                    hVar.dvR.channel = "sv_shortdetails_share_collect_comment";
                    hVar.dvR.id = "";
                    hVar.dvR.nid = "sv_" + forwardInfo.baijiahaoData.oriUgcNid;
                    hVar.dvR.ref_type = "video";
                    hVar.dvR.url = forwardInfo.baijiahaoData.forwardUrl;
                    hVar.dvR.video_duration = forwardInfo.video_duration;
                } else if (forwardInfo.baijiahaoData.oriUgcType == 3) {
                    hVar.dvR.dwa = "ugcsimple";
                    hVar.dvR.channel = "ugc_user_share_collect_comment";
                    hVar.dvR.id = forwardInfo.baijiahaoData.oriUgcNid;
                    hVar.dvR.nid = "dt_" + forwardInfo.baijiahaoData.oriUgcNid;
                    hVar.dvR.ref_type = "imagetext";
                    hVar.dvR.avatar = forwardInfo.avatar;
                } else if (forwardInfo.baijiahaoData.oriUgcType == 4) {
                    hVar.dvR.dwa = "ugcsimple";
                    hVar.dvR.channel = "sv_user_share_collect_comment";
                    hVar.dvR.id = forwardInfo.baijiahaoData.oriUgcVid;
                    hVar.dvR.nid = "dt_" + forwardInfo.baijiahaoData.oriUgcNid;
                    hVar.dvR.ref_type = "video";
                    hVar.dvR.avatar = forwardInfo.avatar;
                }
            }
        } else {
            hVar.dvR.tid = forwardInfo.originalTid;
            hVar.dvR.dwa = "swan";
            hVar.dvR.url = "https://mbd.baidu.com/ma/landingpage?t=smartapp_share&appid=flFqXclepWs7RdugAszy9eERL7G5dS0I&url=/pages/pb/pb?tid=" + forwardInfo.originalTid;
            hVar.dvR.channel = "swan_details_tieba_post_share_collect_comment";
            if (forwardInfo.showType == 3) {
                hVar.dvR.ref_type = "video";
            } else {
                hVar.dvR.ref_type = "imagetext";
            }
        }
        hVar.dvS = new a();
        hVar.dvS.dvX = "forward";
        hVar.dvS.dvZ = "0";
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

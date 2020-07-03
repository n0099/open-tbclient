package com.baidu.tbadk.coreExtra.share;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.s;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.coreExtra.share.a;
import com.baidu.tbadk.switchs.UrlNeedCuidSwitch;
import com.baidu.tieba.R;
import com.baidu.webkit.internal.ETAG;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
/* loaded from: classes.dex */
public class f {
    private b eob;
    private c eoc;
    private a eog;
    private final Context mContext;
    private String eod = TbadkCoreApplication.getInst().getContext().getString(R.string.share_tail);
    private String eoe = TbadkCoreApplication.getInst().getContext().getString(R.string.weibo_share_tail) + this.eod;
    private a.InterfaceC0491a eoh = new a.InterfaceC0491a() { // from class: com.baidu.tbadk.coreExtra.share.f.1
        @Override // com.baidu.tbadk.coreExtra.share.a.InterfaceC0491a
        public void e(ShareItem shareItem) {
            f.this.eoc.a(f.this.a(shareItem, LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND), 3, false);
        }
    };

    public f(Context context, b bVar) {
        d dVar;
        this.eob = null;
        this.eoc = null;
        this.mContext = context;
        this.eob = bVar;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_CREATE_SHARE_DIALOG, d.class);
        if (runTask.getData() != null && (dVar = (d) runTask.getData()) != null) {
            this.eoc = dVar.a(this.mContext, this.eob);
        }
    }

    public static boolean dN(Context context) {
        return bdk();
    }

    public static boolean bdk() {
        return TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_CREATE_SHARE_DIALOG);
    }

    public static String dq(String str, String str2) {
        return ad(str, "copy", str2);
    }

    public void f(ShareItem shareItem) {
        if (this.eoc != null && shareItem != null) {
            if (StringUtils.isNull(shareItem.tid)) {
                shareItem.content = b(shareItem.content, 80, 20, shareItem.enS ? this.eod : "");
            }
            if (shareItem.canShareBySmartApp && !ar.isEmpty(shareItem.enV)) {
                shareItem.imageUri = Uri.parse(shareItem.enV);
                this.eoc.a(a(shareItem, LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND), 3, false);
            } else if (shareItem.canShareBySmartApp && ar.isEmpty(shareItem.enV) && !ar.isEmpty(shareItem.tid) && !"0".equals(shareItem.tid)) {
                if (this.eog == null) {
                    this.eog = new a();
                    this.eog.a(this.eoh);
                }
                this.eog.c(shareItem);
            } else {
                if (shareItem.typeShareToSmallApp == 4) {
                    if (this.eog == null) {
                        this.eog = new a();
                    }
                    this.eog.c(shareItem);
                }
                this.eoc.a(a(shareItem, LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND), 3, false);
            }
        }
    }

    public void g(ShareItem shareItem) {
        if (this.eoc != null && shareItem != null) {
            shareItem.content = b(shareItem.content, 80, 20, shareItem.enS ? this.eod : "");
            this.eoc.a(a(shareItem, LogConfig.LIVE_SHARE_WEIXIN_TIMELINE), 2, false);
        }
    }

    public void h(ShareItem shareItem) {
        if (this.eoc != null && shareItem != null) {
            shareItem.content = b(shareItem.content, 80, 32, shareItem.enS ? this.eod : "");
            this.eoc.a(a(shareItem, LogConfig.LIVE_SHARE_QQ_FRIEND), 8, true);
        }
    }

    public void i(ShareItem shareItem) {
        if (this.eoc != null) {
            shareItem.content = b(shareItem.content, 80, 32, shareItem.enS ? this.eod : "");
            this.eoc.a(a(shareItem, Constants.SOURCE_QZONE), 4, true);
        }
    }

    public void j(ShareItem shareItem) {
        if (this.eoc != null) {
            shareItem.content = b(shareItem.content, 140, 20, shareItem.enS ? this.eod : "");
            this.eoc.a(a(shareItem, "tencent_weibo"), 5, true);
        }
    }

    public void k(ShareItem shareItem) {
        if (this.eoc != null) {
            shareItem.content = b(shareItem.content, 140, 20, shareItem.enS ? this.eoe : "");
            this.eoc.a(a(shareItem, "sina_weibo"), 6, true);
        }
    }

    public void l(ShareItem shareItem) {
        if (this.eoc != null) {
            shareItem.content = b(shareItem.content, 140, 20, shareItem.enS ? this.eod : "");
            this.eoc.a(a(shareItem, "renren"), 7, true);
        }
    }

    private String b(String str, int i, int i2, String str2) {
        if (str != null) {
            int min = Math.min((i - str2.length()) - i2, str.length());
            if (min < str.length()) {
                return str.substring(0, min - 1) + (StringHelper.STRING_MORE + str2);
            }
            return str + str2;
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ShareItem a(ShareItem shareItem, String str) {
        if (shareItem == null) {
            return null;
        }
        if ((shareItem.imageUri == null || shareItem.imageUri.equals("")) && shareItem.bdf() == null) {
            String str2 = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            if (str.startsWith(LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND)) {
                str2 = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            shareItem.imageUri = Uri.parse(str2);
        }
        if (shareItem.imageUri != null && !shareItem.imageUri.equals("")) {
            String uri = shareItem.imageUri.toString();
            if (!xP(uri) && !xQ(uri)) {
                shareItem.imageUri = Uri.parse("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
            } else {
                shareItem.imageUri = Uri.parse(uri);
                dr(uri, "sfc=" + str);
            }
        }
        if (shareItem.enT) {
            shareItem.linkUrl = ad(shareItem.linkUrl, str, shareItem.tid);
            return shareItem;
        }
        return shareItem;
    }

    protected boolean xP(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("file://")) {
            try {
                File file = new File(new URI(str));
                return file.isFile() && file.exists();
            } catch (URISyntaxException e) {
                return false;
            }
        }
        return false;
    }

    private static String ad(String str, String str2, String str3) {
        String md5;
        if (ar.isEmpty(str)) {
            str = "http://tieba.baidu.com/";
        }
        String dr = dr(dr(dr(dr(str, "sfc=" + str2), "client_type=2"), "client_version=" + TbConfig.getVersion()), "st=" + (System.currentTimeMillis() / 1000));
        if (str3 != null) {
            if (SwitchManager.getInstance().findType(UrlNeedCuidSwitch.URL_NEED_CUID_SWITCH) == 1) {
                md5 = s.toMd5(str3 + TbadkCoreApplication.getInst().getCuid() + (System.currentTimeMillis() / 1000) + "6&!N_j9#");
            } else {
                md5 = s.toMd5(str3 + (System.currentTimeMillis() / 1000) + "6&!N_j9#");
            }
            return dr(dr, "unique=" + md5);
        }
        return dr;
    }

    private static String dr(String str, String str2) {
        String str3 = ETAG.ITEM_SEPARATOR;
        if (!str.contains("?")) {
            str = str + "?";
            str3 = "";
        }
        return str + str3 + str2;
    }

    private boolean xQ(String str) {
        String[] split = "jpg,jpeg,png,gif,bmp".split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
        if (bc.aWU().UrlValidated(str)) {
            if (split == null || split.length <= 0) {
                return true;
            }
            for (String str2 : split) {
                if (str2 != null && !str2.equals("") && (str.contains(str2) || str.contains(str2.toUpperCase()))) {
                    return true;
                }
            }
        }
        return false;
    }
}

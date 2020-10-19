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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.coreExtra.share.b;
import com.baidu.tbadk.switchs.UrlNeedCuidSwitch;
import com.baidu.tieba.R;
import com.baidu.webkit.internal.ETAG;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
/* loaded from: classes.dex */
public class g {
    private c eTi;
    private d eTj;
    private b eTm;
    private final Context mContext;
    private String eTk = TbadkCoreApplication.getInst().getContext().getString(R.string.share_tail);
    private String eTl = TbadkCoreApplication.getInst().getContext().getString(R.string.weibo_share_tail) + this.eTk;
    private b.a eTn = new b.a() { // from class: com.baidu.tbadk.coreExtra.share.g.1
        @Override // com.baidu.tbadk.coreExtra.share.b.a
        public void e(ShareItem shareItem) {
            g.this.eTj.a(g.this.a(shareItem, LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND), 3, false);
        }
    };

    public g(Context context, c cVar) {
        e eVar;
        this.eTi = null;
        this.eTj = null;
        this.mContext = context;
        this.eTi = cVar;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_CREATE_SHARE_DIALOG, e.class);
        if (runTask.getData() != null && (eVar = (e) runTask.getData()) != null) {
            this.eTj = eVar.a(this.mContext, this.eTi);
        }
    }

    public static boolean eh(Context context) {
        return bti();
    }

    public static boolean bti() {
        return TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_CREATE_SHARE_DIALOG);
    }

    public static String dO(String str, String str2) {
        return af(str, "copy", str2);
    }

    public void f(ShareItem shareItem) {
        if (this.eTj != null && shareItem != null) {
            if (StringUtils.isNull(shareItem.tid)) {
                shareItem.content = b(shareItem.content, 80, 20, shareItem.eSV ? this.eTk : "");
            }
            if (shareItem.canShareBySmartApp && !at.isEmpty(shareItem.eSY)) {
                shareItem.imageUri = Uri.parse(shareItem.eSY);
                this.eTj.a(a(shareItem, LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND), 3, false);
            } else if (shareItem.canShareBySmartApp && at.isEmpty(shareItem.eSY) && !at.isEmpty(shareItem.tid) && !"0".equals(shareItem.tid)) {
                if (this.eTm == null) {
                    this.eTm = new b();
                    this.eTm.a(this.eTn);
                }
                this.eTm.c(shareItem);
            } else {
                if (shareItem.typeShareToSmallApp == 4) {
                    if (this.eTm == null) {
                        this.eTm = new b();
                    }
                    this.eTm.c(shareItem);
                }
                this.eTj.a(a(shareItem, LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND), 3, false);
            }
        }
    }

    public void g(ShareItem shareItem) {
        if (this.eTj != null && shareItem != null) {
            shareItem.content = b(shareItem.content, 80, 20, shareItem.eSV ? this.eTk : "");
            this.eTj.a(a(shareItem, LogConfig.LIVE_SHARE_WEIXIN_TIMELINE), 2, false);
        }
    }

    public void h(ShareItem shareItem) {
        if (this.eTj != null && shareItem != null) {
            shareItem.content = b(shareItem.content, 80, 32, shareItem.eSV ? this.eTk : "");
            this.eTj.a(a(shareItem, LogConfig.LIVE_SHARE_QQ_FRIEND), 8, true);
        }
    }

    public void i(ShareItem shareItem) {
        if (this.eTj != null) {
            shareItem.content = b(shareItem.content, 80, 32, shareItem.eSV ? this.eTk : "");
            this.eTj.a(a(shareItem, Constants.SOURCE_QZONE), 4, true);
        }
    }

    public void j(ShareItem shareItem) {
        if (this.eTj != null) {
            shareItem.content = b(shareItem.content, 140, 20, shareItem.eSV ? this.eTk : "");
            this.eTj.a(a(shareItem, "tencent_weibo"), 5, true);
        }
    }

    public void k(ShareItem shareItem) {
        if (this.eTj != null) {
            shareItem.content = b(shareItem.content, 140, 20, shareItem.eSV ? this.eTl : "");
            this.eTj.a(a(shareItem, "sina_weibo"), 6, true);
        }
    }

    public void l(ShareItem shareItem) {
        if (this.eTj != null) {
            shareItem.content = b(shareItem.content, 140, 20, shareItem.eSV ? this.eTk : "");
            this.eTj.a(a(shareItem, "renren"), 7, true);
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
        if ((shareItem.imageUri == null || shareItem.imageUri.equals("")) && shareItem.btc() == null) {
            String str2 = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            if (str.startsWith(LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND)) {
                str2 = "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg";
            }
            shareItem.imageUri = Uri.parse(str2);
        }
        if (shareItem.imageUri != null && !shareItem.imageUri.equals("")) {
            String uri = shareItem.imageUri.toString();
            if (!Cu(uri) && !Cv(uri)) {
                shareItem.imageUri = Uri.parse("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
            } else {
                shareItem.imageUri = Uri.parse(uri);
                dP(uri, "sfc=" + str);
            }
        }
        if (shareItem.eSW) {
            shareItem.linkUrl = af(shareItem.linkUrl, str, shareItem.tid);
            return shareItem;
        }
        return shareItem;
    }

    protected boolean Cu(String str) {
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

    private static String af(String str, String str2, String str3) {
        String md5;
        if (at.isEmpty(str)) {
            str = "http://tieba.baidu.com/";
        }
        String dP = dP(dP(dP(dP(str, "sfc=" + str2), "client_type=2"), "client_version=" + TbConfig.getVersion()), "st=" + (System.currentTimeMillis() / 1000));
        if (str3 != null) {
            if (SwitchManager.getInstance().findType(UrlNeedCuidSwitch.URL_NEED_CUID_SWITCH) == 1) {
                md5 = s.toMd5(str3 + TbadkCoreApplication.getInst().getCuid() + (System.currentTimeMillis() / 1000) + "6&!N_j9#");
            } else {
                md5 = s.toMd5(str3 + (System.currentTimeMillis() / 1000) + "6&!N_j9#");
            }
            return dP(dP, "unique=" + md5);
        }
        return dP;
    }

    private static String dP(String str, String str2) {
        String str3 = ETAG.ITEM_SEPARATOR;
        if (!str.contains("?")) {
            str = str + "?";
            str3 = "";
        }
        return str + str3 + str2;
    }

    private boolean Cv(String str) {
        String[] split = "jpg,jpeg,png,gif,bmp".split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
        if (be.bmY().UrlValidated(str)) {
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

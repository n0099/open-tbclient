package com.baidu.tbadk.util;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.webkit.internal.ETAG;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
/* loaded from: classes.dex */
public class ab {
    public static String aL(String str, String str2) {
        int indexOf = str.indexOf(str2);
        if (indexOf != -1) {
            int length = str2.length() + indexOf;
            int i = length;
            while (i < str.length() && str.charAt(i) != '&') {
                i++;
            }
            try {
                return URLDecoder.decode(str.substring(length, i));
            } catch (Exception e) {
                BdLog.e(e.toString());
                return "";
            }
        }
        return "";
    }

    public static String aM(String str, String str2) {
        String[] split;
        String str3 = "";
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2) && (split = str.split("[?]")) != null && split.length >= 2) {
            for (int i = 1; i < split.length; i++) {
                String[] split2 = split[i].split(ETAG.ITEM_SEPARATOR);
                if (split2 != null && split2.length > 0) {
                    int length = split2.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 < length) {
                            String[] split3 = split2[i2].split(ETAG.EQUAL);
                            if (split3.length == 2) {
                                String str4 = split3[0];
                                String str5 = split3[1];
                                if (str2.equals(str4)) {
                                    try {
                                        str3 = URLDecoder.decode(str5);
                                        break;
                                    } catch (Exception e) {
                                        str3 = str5;
                                    }
                                }
                            }
                            i2++;
                        }
                    }
                }
            }
        }
        return str3;
    }

    public static Bundle ix(String str) {
        URL url;
        String query;
        String[] split;
        if (StringUtils.isNull(str)) {
            return null;
        }
        Bundle bundle = new Bundle();
        try {
            url = new URL(str);
            query = url.getQuery();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        if (StringUtils.isNull(query) || StringUtils.isNull(url.getPath()) || (split = query.split(ETAG.ITEM_SEPARATOR)) == null) {
            return null;
        }
        bundle.putString("path", url.getPath());
        for (String str2 : split) {
            String[] split2 = str2.split(ETAG.EQUAL);
            if (split2 != null && split2.length == 2 && !StringUtils.isNull(split2[0])) {
                bundle.putString(split2[0], split2[1]);
            }
        }
        return bundle;
    }

    /* loaded from: classes.dex */
    public static class a {
        public String BDUSS;
        public String bfu;

        public a(String str, String str2) {
            this.BDUSS = "";
            this.bfu = "";
            this.BDUSS = str;
            this.bfu = str2;
        }

        public int hashCode() {
            return (((this.BDUSS == null ? 0 : this.BDUSS.hashCode()) + 31) * 31) + (this.bfu != null ? this.bfu.hashCode() : 0);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                a aVar = (a) obj;
                if (this.BDUSS == null) {
                    if (aVar.BDUSS != null) {
                        return false;
                    }
                } else if (!this.BDUSS.equals(aVar.BDUSS)) {
                    return false;
                }
                return this.bfu == null ? aVar.bfu == null : this.bfu.equals(aVar.bfu);
            }
            return false;
        }
    }

    public static void a(final BaseWebView baseWebView, BdUniqueId bdUniqueId) {
        if (baseWebView != null) {
            CustomMessageListener customMessageListener = new CustomMessageListener(2921024) { // from class: com.baidu.tbadk.util.ab.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921024 && baseWebView != null) {
                        baseWebView.reload();
                    }
                }
            };
            if (bdUniqueId != null) {
                customMessageListener.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(customMessageListener);
            }
        }
    }

    public static String iy(String str) {
        if (!ao.isEmpty(str) && !str.contains("page_type")) {
            StringBuilder sb = new StringBuilder(str);
            if (str.contains("?")) {
                sb.append(ETAG.ITEM_SEPARATOR);
            } else {
                sb.append("?");
            }
            sb.append("page_type");
            sb.append(ETAG.EQUAL);
            sb.append(TbWebViewActivityConfig.PAGE_TYPE_BLACK_TRANSLUCENT);
            return sb.toString();
        }
        return str;
    }
}

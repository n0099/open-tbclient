package com.baidu.tieba.ad.webview;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.baidu.android.imsdk.internal.DefaultConfig;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.mobads.interfaces.utils.IXAdCommonUtils;
import com.baidu.mobstat.Config;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import java.io.File;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public final class a {
    private static HashMap<String, Integer> bsG = new HashMap<>();
    private static HashMap<String, Integer> bsH = new HashMap<>();
    private static HashMap<String, String> bsI = new HashMap<>();
    private static HashMap<String, String> bsJ = new HashMap<>();
    private static final Pattern bsK;

    static {
        e("application/andrew-inset", "ez", 5);
        e("application/dsptype", "tsp", 5);
        e("application/futuresplash", "spl", 5);
        e("application/hta", "hta", 5);
        e("application/mac-binhex40", "hqx", 5);
        e("application/mac-compactpro", "cpt", 5);
        e("application/mathematica", "nb", 5);
        e("application/msaccess", "mdb", 5);
        e("application/oda", "oda", 5);
        e("application/ogg", "ogg", 1);
        e("application/pdf", "pdf", 4);
        e("application/pgp-keys", TiebaInitialize.Params.KEY, 5);
        e("application/pgp-signature", "pgp", 5);
        e("application/pics-rules", "prf", 5);
        e("application/rar", "rar", 8);
        e("application/rdf+xml", "rdf", 5);
        e("application/rss+xml", "rss", 5);
        e("application/zip", "zip", 8);
        e("application/vnd.android.package-archive", "apk", 3);
        e("application/vnd.cinderella", "cdy", 5);
        e("application/vnd.ms-pki.stl", "stl", 5);
        e("application/vnd.oasis.opendocument.database", "odb", 5);
        e("application/vnd.oasis.opendocument.formula", "odf", 5);
        e("application/vnd.oasis.opendocument.graphics", "odg", 5);
        e("application/vnd.oasis.opendocument.graphics-template", "otg", 5);
        e("application/vnd.oasis.opendocument.image", "odi", 5);
        e("application/vnd.oasis.opendocument.spreadsheet", "ods", 5);
        e("application/vnd.oasis.opendocument.spreadsheet-template", "ots", 5);
        e("application/vnd.oasis.opendocument.text", "odt", 5);
        e("application/vnd.oasis.opendocument.text-master", "odm", 5);
        e("application/vnd.oasis.opendocument.text-template", "ott", 5);
        e("application/vnd.oasis.opendocument.text-web", "oth", 5);
        e("application/vnd.google-earth.kml+xml", "kml", 5);
        e("application/vnd.google-earth.kmz", "kmz", 5);
        e("application/msword", "doc", 4);
        e("application/msword", "dot", 4);
        e("application/vnd.openxmlformats-officedocument.wordprocessingml.document", "docx", 4);
        e("application/vnd.openxmlformats-officedocument.wordprocessingml.template", "dotx", 4);
        e("application/vnd.ms-excel", "xls", 4);
        e("application/vnd.ms-excel", "xlt", 4);
        e("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "xlsx", 4);
        e("application/vnd.openxmlformats-officedocument.spreadsheetml.template", "xltx", 4);
        e("application/vnd.ms-powerpoint", "ppt", 4);
        e("application/vnd.ms-powerpoint", "pot", 4);
        e("application/vnd.ms-powerpoint", "pps", 4);
        e("application/vnd.openxmlformats-officedocument.presentationml.presentation", "pptx", 4);
        e("application/vnd.openxmlformats-officedocument.presentationml.template", "potx", 4);
        e("application/vnd.openxmlformats-officedocument.presentationml.slideshow", "ppsx", 4);
        e("application/vnd.rim.cod", "cod", 5);
        e("application/vnd.smaf", "mmf", 5);
        e("application/vnd.stardivision.calc", "sdc", 5);
        e("application/vnd.stardivision.draw", "sda", 5);
        e("application/vnd.stardivision.impress", "sdd", 5);
        e("application/vnd.stardivision.impress", "sdp", 5);
        e("application/vnd.stardivision.math", "smf", 5);
        e("application/vnd.stardivision.writer", "sdw", 5);
        e("application/vnd.stardivision.writer", "vor", 5);
        e("application/vnd.stardivision.writer-global", "sgl", 5);
        e("application/vnd.sun.xml.calc", "sxc", 5);
        e("application/vnd.sun.xml.calc.template", "stc", 5);
        e("application/vnd.sun.xml.draw", "sxd", 5);
        e("application/vnd.sun.xml.draw.template", "std", 5);
        e("application/vnd.sun.xml.impress", "sxi", 5);
        e("application/vnd.sun.xml.impress.template", "sti", 5);
        e("application/vnd.sun.xml.math", "sxm", 5);
        e("application/vnd.sun.xml.writer", "sxw", 5);
        e("application/vnd.sun.xml.writer.global", "sxg", 5);
        e("application/vnd.sun.xml.writer.template", "stw", 5);
        e("application/vnd.visio", "vsd", 5);
        e("application/x-abiword", "abw", 5);
        e("application/x-apple-diskimage", "dmg", 5);
        e("application/x-bcpio", "bcpio", 5);
        e("application/x-bittorrent", "torrent", 5);
        e("application/x-cdf", "cdf", 5);
        e("application/x-cdlink", "vcd", 5);
        e("application/x-chess-pgn", "pgn", 5);
        e("application/x-cpio", "cpio", 5);
        e("application/x-debian-package", "deb", 5);
        e("application/x-debian-package", "udeb", 5);
        e("application/x-director", "dcr", 5);
        e("application/x-director", "dir", 5);
        e("application/x-director", "dxr", 5);
        e("application/x-dms", "dms", 5);
        e("application/x-doom", "wad", 5);
        e("application/x-dvi", "dvi", 5);
        e("application/x-flac", "flac", 1);
        e("application/x-font", "pfa", 5);
        e("application/x-font", "pfb", 5);
        e("application/x-font", "gsf", 5);
        e("application/x-font", "pcf", 5);
        e("application/x-font", "pcf.Z", 5);
        e("application/x-freemind", "mm", 5);
        e("application/x-futuresplash", "spl", 5);
        e("application/x-gnumeric", "gnumeric", 5);
        e("application/x-go-sgf", "sgf", 5);
        e("application/x-graphing-calculator", "gcf", 5);
        e("application/x-gtar", "gtar", 5);
        e("application/x-gtar", "tgz", 5);
        e("application/x-gtar", "taz", 5);
        e("application/x-hdf", "hdf", 5);
        e("application/x-ica", "ica", 5);
        e("application/x-internet-signup", "ins", 5);
        e("application/x-internet-signup", "isp", 5);
        e("application/x-iphone", "iii", 5);
        e("application/x-iso9660-image", "iso", 5);
        e("application/x-jmol", "jmz", 5);
        e("application/x-kchart", "chrt", 5);
        e("application/x-killustrator", "kil", 5);
        e("application/x-koan", "skp", 5);
        e("application/x-koan", "skd", 5);
        e("application/x-koan", "skt", 5);
        e("application/x-koan", "skm", 5);
        e("application/x-kpresenter", "kpr", 5);
        e("application/x-kpresenter", "kpt", 5);
        e("application/x-kspread", "ksp", 5);
        e("application/x-kword", "kwd", 5);
        e("application/x-kword", "kwt", 5);
        e("application/x-latex", "latex", 5);
        e("application/x-lha", "lha", 5);
        e("application/x-lzh", "lzh", 5);
        e("application/x-lzx", "lzx", 5);
        e("application/x-maker", "frm", 5);
        e("application/x-maker", "maker", 5);
        e("application/x-maker", "frame", 5);
        e("application/x-maker", "fb", 5);
        e("application/x-maker", "book", 5);
        e("application/x-maker", "fbdoc", 5);
        e("application/x-mif", "mif", 5);
        e("application/x-ms-wmd", "wmd", 5);
        e("application/x-ms-wmz", "wmz", 5);
        e("application/x-msi", "msi", 5);
        e("application/x-ns-proxy-autoconfig", "pac", 5);
        e("application/x-nwc", "nwc", 5);
        e("application/x-object", Config.OS, 5);
        e("application/x-oz-application", "oza", 5);
        e("application/x-pkcs12", "p12", 5);
        e("application/x-pkcs12", "pfx", 5);
        e("application/x-pkcs7-certreqresp", "p7r", 5);
        e("application/x-pkcs7-crl", "crl", 5);
        e("application/x-quicktimeplayer", "qtl", 5);
        e("application/x-shar", "shar", 5);
        e("application/x-shockwave-flash", "swf", 5);
        e("application/x-stuffit", "sit", 5);
        e("application/x-sv4cpio", "sv4cpio", 5);
        e("application/x-sv4crc", "sv4crc", 5);
        e("application/x-tar", "tar", 8);
        e("application/x-texinfo", "texinfo", 5);
        e("application/x-texinfo", "texi", 5);
        e("application/x-troff", "t", 5);
        e("application/x-troff", "roff", 5);
        e("application/x-troff-man", "man", 5);
        e("application/x-ustar", "ustar", 5);
        e("application/x-wais-source", "src", 5);
        e("application/x-wingz", "wz", 5);
        e("application/x-webarchive", "webarchive", 5);
        e("application/x-webarchive-xml", "webarchivexml", 5);
        e("application/x-x509-ca-cert", "crt", 5);
        e("application/x-x509-user-cert", "crt", 5);
        e("application/x-xcf", "xcf", 5);
        e("application/x-xfig", "fig", 5);
        e("application/xhtml+xml", "xhtml", 5);
        e("application/font-sfnt", "ttf", 5);
        e("audio/3gpp", "3gpp", 1);
        e("audio/amr", "amr", 1);
        e("audio/basic", "snd", 1);
        e("audio/midi", "mid", 1);
        e("audio/midi", "midi", 1);
        e("audio/midi", "kar", 1);
        e("audio/midi", "xmf", 1);
        e("audio/mobile-xmf", "mxmf", 1);
        e("audio/mpeg", "mp3", 1);
        e("audio/mpeg", "mpga", 1);
        e("audio/mpeg", "mpega", 1);
        e("audio/mpeg", "mp2", 1);
        e("audio/mpeg", "m4a", 1);
        e("audio/mpegurl", "m3u", 1);
        e("audio/prs.sid", "sid", 1);
        e("audio/x-aiff", "aif", 1);
        e("audio/x-aiff", "aiff", 1);
        e("audio/x-aiff", "aifc", 1);
        e("audio/x-gsm", "gsm", 1);
        e("audio/x-mpegurl", "m3u", 1);
        e("audio/x-ms-wma", "wma", 1);
        e("audio/x-ms-wax", "wax", 1);
        e("audio/x-pn-realaudio", "ra", 1);
        e("audio/x-pn-realaudio", "rm", 1);
        e("audio/x-pn-realaudio", "ram", 1);
        e("audio/x-realaudio", "ra", 1);
        e("audio/x-scpls", "pls", 1);
        e("audio/x-sd2", "sd2", 1);
        e("audio/x-wav", "wav", 1);
        e("image/bmp", "bmp", 2);
        e("image/gif", "gif", 2);
        e("image/ico", "cur", 5);
        e("image/ico", "ico", 2);
        e("image/ief", "ief", 5);
        e("image/jpeg", "jpeg", 2);
        e("image/jpeg", "jpg", 2);
        e("image/jpeg", "jpe", 2);
        e("image/pcx", "pcx", 5);
        e("image/png", "png", 2);
        e("image/svg+xml", "svg", 5);
        e("image/svg+xml", "svgz", 5);
        e("image/tiff", "tiff", 5);
        e("image/tiff", "tif", 5);
        e("image/vnd.djvu", "djvu", 5);
        e("image/vnd.djvu", "djv", 5);
        e("image/vnd.wap.wbmp", "wbmp", 2);
        e("image/x-cmu-raster", "ras", 5);
        e("image/x-coreldraw", "cdr", 5);
        e("image/x-coreldrawpattern", "pat", 5);
        e("image/x-coreldrawtemplate", "cdt", 5);
        e("image/x-corelphotopaint", "cpt", 5);
        e("image/x-icon", "ico", 2);
        e("image/x-jg", "art", 5);
        e("image/x-jng", "jng", 5);
        e("image/x-ms-bmp", "bmp", 2);
        e("image/x-photoshop", "psd", 5);
        e("image/x-portable-anymap", "pnm", 5);
        e("image/x-portable-bitmap", "pbm", 5);
        e("image/x-portable-graymap", "pgm", 5);
        e("image/x-portable-pixmap", "ppm", 5);
        e("image/x-rgb", "rgb", 5);
        e("image/x-xbitmap", "xbm", 5);
        e("image/x-xpixmap", "xpm", 5);
        e("image/x-xwindowdump", "xwd", 5);
        e("model/iges", "igs", 5);
        e("model/iges", "iges", 5);
        e("model/mesh", "msh", 5);
        e("model/mesh", "mesh", 5);
        e("model/mesh", "silo", 5);
        e("text/calendar", "ics", 5);
        e("text/calendar", "icz", 5);
        e("text/comma-separated-values", "csv", 5);
        e("text/css", "css", 5);
        e("text/html", "htm", 11);
        e("text/html", "html", 11);
        e("text/h323", "323", 5);
        e("text/iuls", "uls", 5);
        e("text/mathml", "mml", 5);
        e("text/plain-story", "txt", 6);
        e("text/plain", "dat", 5);
        e("text/plain", "txt", 4);
        e("text/plain", "asc", 4);
        e("text/plain", "text", 4);
        e("text/plain", "diff", 4);
        e("text/plain", "po", 4);
        e("text/richtext", "rtx", 4);
        e("text/rtf", "rtf", 4);
        e("text/texmacs", TimeDisplaySetting.TIME_DISPLAY_SETTING, 5);
        e("text/text", "phps", 5);
        e("text/tab-separated-values", "tsv", 5);
        e("text/xml", "xml", 4);
        e("text/x-bibtex", "bib", 5);
        e("text/x-boo", "boo", 5);
        e("text/x-c++hdr", "h++", 5);
        e("text/x-c++hdr", "hpp", 5);
        e("text/x-c++hdr", "hxx", 5);
        e("text/x-c++hdr", "hh", 5);
        e("text/x-c++src", "c++", 5);
        e("text/x-c++src", "cpp", 5);
        e("text/x-c++src", "cxx", 5);
        e("text/x-chdr", "h", 5);
        e("text/x-component", "htc", 5);
        e("text/x-csh", "csh", 5);
        e("text/x-csrc", "c", 5);
        e("text/x-dsrc", "d", 5);
        e("text/x-haskell", "hs", 5);
        e("text/x-java", "java", 5);
        e("text/x-literate-haskell", "lhs", 5);
        e("text/x-moc", "moc", 5);
        e("text/x-pascal", "p", 5);
        e("text/x-pascal", "pas", 5);
        e("text/x-pcs-gcd", "gcd", 5);
        e("text/x-setext", "etx", 5);
        e("text/x-tcl", "tcl", 5);
        e("text/x-tex", "tex", 5);
        e("text/x-tex", "ltx", 5);
        e("text/x-tex", "sty", 5);
        e("text/x-tex", "cls", 5);
        e("text/x-vcalendar", "vcs", 5);
        e("text/x-vcard", "vcf", 5);
        e("video/mkv", "mkv", 0);
        e("video/3gpp", "3gpp", 0);
        e("video/3gpp", "3gp", 0);
        e("video/3gpp", "3g2", 0);
        e("video/dl", IXAdCommonUtils.PKGS_PREF_DOWNLOAD_STATUS, 0);
        e("video/dv", "dif", 0);
        e("video/dv", "dv", 0);
        e("video/fli", "fli", 0);
        e("video/m4v", "m4v", 0);
        e("video/mpeg", "mpeg", 0);
        e("video/mpeg", "mpg", 0);
        e("video/mpeg", "mpe", 0);
        e("video/mp4", "mp4", 0);
        e("video/mpeg", "vob", 0);
        e("video/quicktime", "qt", 0);
        e("video/quicktime", "mov", 0);
        e("video/vnd.mpegurl", "mxu", 0);
        e("video/x-la-asf", "lsf", 0);
        e("video/x-la-asf", "lsx", 0);
        e("video/x-mng", "mng", 0);
        e("video/x-ms-asf", "asf", 0);
        e("video/x-ms-asf", "asx", 0);
        e("video/x-ms-wm", "wm", 0);
        e("video/x-ms-wmv", "wmv", 0);
        e("video/x-ms-wmx", "wmx", 0);
        e("video/x-ms-wvx", "wvx", 0);
        e("video/x-msvideo", "avi", 0);
        e("video/x-sgi-movie", "movie", 0);
        e("video/x-webex", "wrf", 0);
        e("x-conference/x-cooltalk", "ice", 5);
        e("x-epoc/x-sisx-app", "sisx", 5);
        e("video/vnd.rn-realvideo", "rmvb", 0);
        e("video/x-flv", "flv", 0);
        e("audio/aac", "aac", 1);
        e("application/vnd.rn-realmedia", "rm", 0);
        e("message/rfc822", "mht", 11);
        bsK = Pattern.compile("attachment;\\s*filename\\s*=\\s*(\"?)([^\"]*)\\1\\s*$", 2);
    }

    private static void e(String str, String str2, int i) {
        bsG.put(str2, Integer.valueOf(i));
        bsH.put(str, Integer.valueOf(i));
        bsI.put(str2, str);
        if (!bsJ.containsKey(str)) {
            bsJ.put(str, str2);
        }
    }

    public static int ch(String str, String str2) {
        return u(!TextUtils.isEmpty(str) ? str.toLowerCase() : "", str2, true);
    }

    public static int u(String str, String str2, boolean z) {
        Integer num = bsH.get(str2);
        if (num == null) {
            num = bsG.get(str);
            if (num == null) {
                num = 5;
            } else if (z && num.intValue() == 8) {
                num = 5;
            }
        } else if (z && num.intValue() == 8) {
            num = 5;
        }
        return num.intValue();
    }

    public static String ry(String str) {
        int lastIndexOf;
        if (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf(DefaultConfig.TOKEN_SEPARATOR)) == -1 || lastIndexOf == str.length()) {
            return "";
        }
        return str.substring(lastIndexOf + 1);
    }

    public static String rz(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return bsI.get(str);
    }

    public static String rA(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return bsJ.get(str);
    }

    public static String N(String str, String str2, String str3) {
        String str4;
        String str5;
        int lastIndexOf;
        int lastIndexOf2;
        String str6 = null;
        if (0 != 0 || str2 == null) {
            str4 = null;
        } else {
            str4 = rC(str2);
            if (str4 != null && (lastIndexOf2 = str4.lastIndexOf(File.separator) + 1) > 0) {
                str4 = str4.substring(lastIndexOf2);
            }
        }
        if (TextUtils.isEmpty(str4)) {
            str4 = rB(str);
        }
        if (TextUtils.isEmpty(str4)) {
            str4 = "downloadfile";
        }
        int lastIndexOf3 = str4.lastIndexOf(DefaultConfig.TOKEN_SEPARATOR);
        if (lastIndexOf3 < 0) {
            if (str3 != null) {
                str5 = MimeTypeMap.getSingleton().getExtensionFromMimeType(str3);
                if (TextUtils.isEmpty(str5)) {
                    if (str3.toLowerCase().startsWith("image/")) {
                        str5 = ".jpg";
                    }
                } else {
                    str5 = DefaultConfig.TOKEN_SEPARATOR + str5;
                }
            } else {
                str5 = null;
            }
            if (str5 != null) {
                str6 = str5;
            } else if (str3 != null && str3.toLowerCase().startsWith("text/")) {
                if (str3.equalsIgnoreCase("text/html")) {
                    str6 = ".html";
                } else {
                    str6 = ".txt";
                }
            } else {
                String rB = rB(str);
                if (!TextUtils.isEmpty(rB) && (lastIndexOf = rB.lastIndexOf(DefaultConfig.TOKEN_SEPARATOR)) != -1) {
                    str6 = rB.substring(lastIndexOf + 1);
                }
                if (!TextUtils.isEmpty(str6)) {
                    str6 = DefaultConfig.TOKEN_SEPARATOR + str6;
                } else {
                    str6 = ".bin";
                }
            }
        } else {
            if (str3 != null) {
                String substring = str4.substring(str4.lastIndexOf(DefaultConfig.TOKEN_SEPARATOR) + 1);
                String rA = rA(str3);
                String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(str3);
                String lowerCase = !TextUtils.isEmpty(substring) ? substring.toLowerCase() : "";
                String lowerCase2 = !TextUtils.isEmpty(rA) ? rA.toLowerCase() : "";
                String lowerCase3 = !TextUtils.isEmpty(extensionFromMimeType) ? extensionFromMimeType.toLowerCase() : "";
                String rz = rz(lowerCase);
                String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase);
                String lowerCase4 = !TextUtils.isEmpty(rz) ? rz.toLowerCase() : "";
                String lowerCase5 = !TextUtils.isEmpty(mimeTypeFromExtension) ? mimeTypeFromExtension.toLowerCase() : "";
                if (TextUtils.equals(lowerCase4, lowerCase5)) {
                    if (!TextUtils.isEmpty(lowerCase2) && TextUtils.equals(lowerCase2, lowerCase3)) {
                        str6 = DefaultConfig.TOKEN_SEPARATOR + lowerCase2;
                    }
                } else if (TextUtils.isEmpty(lowerCase4)) {
                    if (!TextUtils.isEmpty(lowerCase3)) {
                        str6 = DefaultConfig.TOKEN_SEPARATOR + lowerCase3;
                    }
                } else if (TextUtils.isEmpty(lowerCase5)) {
                    if (!TextUtils.isEmpty(lowerCase4)) {
                        str6 = DefaultConfig.TOKEN_SEPARATOR + lowerCase;
                    } else if (!TextUtils.isEmpty(lowerCase2)) {
                        str6 = DefaultConfig.TOKEN_SEPARATOR + lowerCase2;
                    }
                }
            }
            if (str6 == null) {
                str6 = str4.substring(lastIndexOf3);
            }
            str4 = str4.substring(0, lastIndexOf3);
        }
        if (str4 != null && str4.length() > 50) {
            str4 = str4.substring(0, 50);
        }
        return str4 + str6;
    }

    public static String rB(String str) {
        int lastIndexOf;
        String decode = Uri.decode(str);
        if (decode != null) {
            int indexOf = decode.indexOf(63);
            if (indexOf > 0) {
                decode = decode.substring(0, indexOf);
            }
            if (!decode.endsWith("/") && (lastIndexOf = decode.lastIndexOf(47) + 1) > 0) {
                return decode.substring(lastIndexOf);
            }
        }
        return null;
    }

    static String rC(String str) {
        try {
            Matcher matcher = bsK.matcher(str);
            if (matcher.find()) {
                return matcher.group(2);
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        return null;
    }
}

package com.baidu.tieba.ad.webview;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.baidu.android.util.io.DocumentOpenUtil;
import com.baidu.android.util.media.MimeType;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.down.utils.Utils;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.mobads.interfaces.utils.IXAdCommonUtils;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.searchbox.ugc.transcoder.TranscoderPlugin;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import java.io.File;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes8.dex */
public final class a {
    private static HashMap<String, Integer> cxD = new HashMap<>();
    private static HashMap<String, Integer> cxE = new HashMap<>();
    private static HashMap<String, String> cxF = new HashMap<>();
    private static HashMap<String, String> cxG = new HashMap<>();
    private static final Pattern cxH;

    static {
        g("application/andrew-inset", "ez", 5);
        g("application/dsptype", "tsp", 5);
        g("application/futuresplash", "spl", 5);
        g("application/hta", "hta", 5);
        g("application/mac-binhex40", "hqx", 5);
        g("application/mac-compactpro", "cpt", 5);
        g("application/mathematica", "nb", 5);
        g("application/msaccess", "mdb", 5);
        g("application/oda", "oda", 5);
        g("application/ogg", "ogg", 1);
        g(DocumentOpenUtil.PDF_TYPE, DocumentOpenUtil.PDF, 4);
        g("application/pgp-keys", "key", 5);
        g("application/pgp-signature", "pgp", 5);
        g("application/pics-rules", "prf", 5);
        g("application/rar", "rar", 8);
        g("application/rdf+xml", "rdf", 5);
        g("application/rss+xml", "rss", 5);
        g("application/zip", "zip", 8);
        g("application/vnd.android.package-archive", "apk", 3);
        g("application/vnd.cinderella", "cdy", 5);
        g("application/vnd.ms-pki.stl", "stl", 5);
        g("application/vnd.oasis.opendocument.database", "odb", 5);
        g("application/vnd.oasis.opendocument.formula", "odf", 5);
        g("application/vnd.oasis.opendocument.graphics", "odg", 5);
        g("application/vnd.oasis.opendocument.graphics-template", "otg", 5);
        g("application/vnd.oasis.opendocument.image", "odi", 5);
        g("application/vnd.oasis.opendocument.spreadsheet", "ods", 5);
        g("application/vnd.oasis.opendocument.spreadsheet-template", "ots", 5);
        g("application/vnd.oasis.opendocument.text", "odt", 5);
        g("application/vnd.oasis.opendocument.text-master", "odm", 5);
        g("application/vnd.oasis.opendocument.text-template", "ott", 5);
        g("application/vnd.oasis.opendocument.text-web", "oth", 5);
        g("application/vnd.google-earth.kml+xml", "kml", 5);
        g("application/vnd.google-earth.kmz", "kmz", 5);
        g(DocumentOpenUtil.WORD_TYPE, DocumentOpenUtil.DOC, 4);
        g(DocumentOpenUtil.WORD_TYPE, "dot", 4);
        g(DocumentOpenUtil.DOCUMENT_TYPE, DocumentOpenUtil.DOCX, 4);
        g("application/vnd.openxmlformats-officedocument.wordprocessingml.template", "dotx", 4);
        g(DocumentOpenUtil.EXCEL_TYPE, DocumentOpenUtil.XLS, 4);
        g(DocumentOpenUtil.EXCEL_TYPE, "xlt", 4);
        g(DocumentOpenUtil.SHEET_TYPE, DocumentOpenUtil.XLSX, 4);
        g("application/vnd.openxmlformats-officedocument.spreadsheetml.template", "xltx", 4);
        g(DocumentOpenUtil.PPT_TYPE, DocumentOpenUtil.PPT, 4);
        g(DocumentOpenUtil.PPT_TYPE, "pot", 4);
        g(DocumentOpenUtil.PPT_TYPE, "pps", 4);
        g(DocumentOpenUtil.PRESENT_TYPE, DocumentOpenUtil.PPTX, 4);
        g("application/vnd.openxmlformats-officedocument.presentationml.template", "potx", 4);
        g("application/vnd.openxmlformats-officedocument.presentationml.slideshow", "ppsx", 4);
        g("application/vnd.rim.cod", "cod", 5);
        g("application/vnd.smaf", "mmf", 5);
        g("application/vnd.stardivision.calc", "sdc", 5);
        g("application/vnd.stardivision.draw", "sda", 5);
        g("application/vnd.stardivision.impress", "sdd", 5);
        g("application/vnd.stardivision.impress", "sdp", 5);
        g("application/vnd.stardivision.math", "smf", 5);
        g("application/vnd.stardivision.writer", "sdw", 5);
        g("application/vnd.stardivision.writer", "vor", 5);
        g("application/vnd.stardivision.writer-global", "sgl", 5);
        g("application/vnd.sun.xml.calc", "sxc", 5);
        g("application/vnd.sun.xml.calc.template", "stc", 5);
        g("application/vnd.sun.xml.draw", "sxd", 5);
        g("application/vnd.sun.xml.draw.template", "std", 5);
        g("application/vnd.sun.xml.impress", "sxi", 5);
        g("application/vnd.sun.xml.impress.template", "sti", 5);
        g("application/vnd.sun.xml.math", "sxm", 5);
        g("application/vnd.sun.xml.writer", "sxw", 5);
        g("application/vnd.sun.xml.writer.global", "sxg", 5);
        g("application/vnd.sun.xml.writer.template", "stw", 5);
        g("application/vnd.visio", "vsd", 5);
        g("application/x-abiword", "abw", 5);
        g("application/x-apple-diskimage", "dmg", 5);
        g("application/x-bcpio", "bcpio", 5);
        g("application/x-bittorrent", "torrent", 5);
        g("application/x-cdf", "cdf", 5);
        g("application/x-cdlink", "vcd", 5);
        g("application/x-chess-pgn", "pgn", 5);
        g("application/x-cpio", "cpio", 5);
        g("application/x-debian-package", "deb", 5);
        g("application/x-debian-package", "udeb", 5);
        g("application/x-director", "dcr", 5);
        g("application/x-director", "dir", 5);
        g("application/x-director", "dxr", 5);
        g("application/x-dms", "dms", 5);
        g("application/x-doom", "wad", 5);
        g("application/x-dvi", "dvi", 5);
        g("application/x-flac", "flac", 1);
        g("application/x-font", "pfa", 5);
        g("application/x-font", "pfb", 5);
        g("application/x-font", "gsf", 5);
        g("application/x-font", "pcf", 5);
        g("application/x-font", "pcf.Z", 5);
        g("application/x-freemind", "mm", 5);
        g("application/x-futuresplash", "spl", 5);
        g("application/x-gnumeric", "gnumeric", 5);
        g("application/x-go-sgf", "sgf", 5);
        g("application/x-graphing-calculator", "gcf", 5);
        g("application/x-gtar", "gtar", 5);
        g("application/x-gtar", "tgz", 5);
        g("application/x-gtar", "taz", 5);
        g("application/x-hdf", "hdf", 5);
        g("application/x-ica", "ica", 5);
        g("application/x-internet-signup", "ins", 5);
        g("application/x-internet-signup", "isp", 5);
        g("application/x-iphone", "iii", 5);
        g("application/x-iso9660-image", "iso", 5);
        g("application/x-jmol", "jmz", 5);
        g("application/x-kchart", "chrt", 5);
        g("application/x-killustrator", "kil", 5);
        g("application/x-koan", "skp", 5);
        g("application/x-koan", "skd", 5);
        g("application/x-koan", "skt", 5);
        g("application/x-koan", "skm", 5);
        g("application/x-kpresenter", "kpr", 5);
        g("application/x-kpresenter", "kpt", 5);
        g("application/x-kspread", "ksp", 5);
        g("application/x-kword", "kwd", 5);
        g("application/x-kword", "kwt", 5);
        g("application/x-latex", "latex", 5);
        g("application/x-lha", "lha", 5);
        g("application/x-lzh", "lzh", 5);
        g("application/x-lzx", "lzx", 5);
        g("application/x-maker", "frm", 5);
        g("application/x-maker", "maker", 5);
        g("application/x-maker", "frame", 5);
        g("application/x-maker", "fb", 5);
        g("application/x-maker", "book", 5);
        g("application/x-maker", "fbdoc", 5);
        g("application/x-mif", "mif", 5);
        g("application/x-ms-wmd", "wmd", 5);
        g("application/x-ms-wmz", "wmz", 5);
        g("application/x-msi", "msi", 5);
        g("application/x-ns-proxy-autoconfig", "pac", 5);
        g("application/x-nwc", "nwc", 5);
        g("application/x-object", Config.OS, 5);
        g("application/x-oz-application", "oza", 5);
        g("application/x-pkcs12", "p12", 5);
        g("application/x-pkcs12", "pfx", 5);
        g("application/x-pkcs7-certreqresp", "p7r", 5);
        g("application/x-pkcs7-crl", "crl", 5);
        g("application/x-quicktimeplayer", "qtl", 5);
        g("application/x-shar", "shar", 5);
        g("application/x-shockwave-flash", "swf", 5);
        g("application/x-stuffit", "sit", 5);
        g("application/x-sv4cpio", "sv4cpio", 5);
        g("application/x-sv4crc", "sv4crc", 5);
        g("application/x-tar", "tar", 8);
        g("application/x-texinfo", "texinfo", 5);
        g("application/x-texinfo", "texi", 5);
        g("application/x-troff", "t", 5);
        g("application/x-troff", "roff", 5);
        g("application/x-troff-man", "man", 5);
        g("application/x-ustar", "ustar", 5);
        g("application/x-wais-source", UserAccountActionItem.KEY_SRC, 5);
        g("application/x-wingz", "wz", 5);
        g("application/x-webarchive", "webarchive", 5);
        g("application/x-webarchive-xml", "webarchivexml", 5);
        g("application/x-x509-ca-cert", "crt", 5);
        g("application/x-x509-user-cert", "crt", 5);
        g("application/x-xcf", "xcf", 5);
        g("application/x-xfig", "fig", 5);
        g("application/xhtml+xml", "xhtml", 5);
        g("application/font-sfnt", "ttf", 5);
        g("audio/3gpp", "3gpp", 1);
        g(MimeType.Audio.AMR, "amr", 1);
        g("audio/basic", "snd", 1);
        g("audio/midi", "mid", 1);
        g("audio/midi", "midi", 1);
        g("audio/midi", "kar", 1);
        g("audio/midi", "xmf", 1);
        g("audio/mobile-xmf", "mxmf", 1);
        g("audio/mpeg", "mp3", 1);
        g("audio/mpeg", "mpga", 1);
        g("audio/mpeg", "mpega", 1);
        g("audio/mpeg", "mp2", 1);
        g("audio/mpeg", "m4a", 1);
        g("audio/mpegurl", "m3u", 1);
        g("audio/prs.sid", UbcStatConstant.KEY_CONTENT_EXT_SID, 1);
        g("audio/x-aiff", "aif", 1);
        g("audio/x-aiff", "aiff", 1);
        g("audio/x-aiff", "aifc", 1);
        g("audio/x-gsm", "gsm", 1);
        g("audio/x-mpegurl", "m3u", 1);
        g("audio/x-ms-wma", "wma", 1);
        g("audio/x-ms-wax", "wax", 1);
        g("audio/x-pn-realaudio", "ra", 1);
        g("audio/x-pn-realaudio", "rm", 1);
        g("audio/x-pn-realaudio", "ram", 1);
        g("audio/x-realaudio", "ra", 1);
        g("audio/x-scpls", "pls", 1);
        g("audio/x-sd2", "sd2", 1);
        g(MimeType.Audio.WAV, "wav", 1);
        g("image/bmp", "bmp", 2);
        g("image/gif", "gif", 2);
        g("image/ico", "cur", 5);
        g("image/ico", "ico", 2);
        g("image/ief", "ief", 5);
        g(MimeType.Image.JPEG, "jpeg", 2);
        g(MimeType.Image.JPEG, "jpg", 2);
        g(MimeType.Image.JPEG, "jpe", 2);
        g("image/pcx", "pcx", 5);
        g(MimeType.Image.PNG, "png", 2);
        g("image/svg+xml", "svg", 5);
        g("image/svg+xml", "svgz", 5);
        g("image/tiff", "tiff", 5);
        g("image/tiff", "tif", 5);
        g("image/vnd.djvu", "djvu", 5);
        g("image/vnd.djvu", "djv", 5);
        g("image/vnd.wap.wbmp", "wbmp", 2);
        g("image/x-cmu-raster", "ras", 5);
        g("image/x-coreldraw", "cdr", 5);
        g("image/x-coreldrawpattern", "pat", 5);
        g("image/x-coreldrawtemplate", "cdt", 5);
        g("image/x-corelphotopaint", "cpt", 5);
        g("image/x-icon", "ico", 2);
        g("image/x-jg", "art", 5);
        g("image/x-jng", "jng", 5);
        g("image/x-ms-bmp", "bmp", 2);
        g("image/x-photoshop", "psd", 5);
        g("image/x-portable-anymap", "pnm", 5);
        g("image/x-portable-bitmap", "pbm", 5);
        g("image/x-portable-graymap", "pgm", 5);
        g("image/x-portable-pixmap", "ppm", 5);
        g("image/x-rgb", "rgb", 5);
        g("image/x-xbitmap", "xbm", 5);
        g("image/x-xpixmap", "xpm", 5);
        g("image/x-xwindowdump", "xwd", 5);
        g("model/iges", "igs", 5);
        g("model/iges", "iges", 5);
        g("model/mesh", "msh", 5);
        g("model/mesh", "mesh", 5);
        g("model/mesh", "silo", 5);
        g("text/calendar", "ics", 5);
        g("text/calendar", "icz", 5);
        g("text/comma-separated-values", "csv", 5);
        g("text/css", "css", 5);
        g("text/html", "htm", 11);
        g("text/html", "html", 11);
        g("text/h323", "323", 5);
        g("text/iuls", "uls", 5);
        g("text/mathml", "mml", 5);
        g("text/plain-story", DocumentOpenUtil.TXT, 6);
        g("text/plain", "dat", 5);
        g("text/plain", DocumentOpenUtil.TXT, 4);
        g("text/plain", "asc", 4);
        g("text/plain", "text", 4);
        g("text/plain", "diff", 4);
        g("text/plain", "po", 4);
        g("text/richtext", "rtx", 4);
        g("text/rtf", "rtf", 4);
        g("text/texmacs", TimeDisplaySetting.TIME_DISPLAY_SETTING, 5);
        g("text/text", "phps", 5);
        g("text/tab-separated-values", "tsv", 5);
        g("text/xml", "xml", 4);
        g("text/x-bibtex", "bib", 5);
        g("text/x-boo", "boo", 5);
        g("text/x-c++hdr", "h++", 5);
        g("text/x-c++hdr", "hpp", 5);
        g("text/x-c++hdr", "hxx", 5);
        g("text/x-c++hdr", "hh", 5);
        g("text/x-c++src", "c++", 5);
        g("text/x-c++src", "cpp", 5);
        g("text/x-c++src", "cxx", 5);
        g("text/x-chdr", "h", 5);
        g("text/x-component", "htc", 5);
        g("text/x-csh", "csh", 5);
        g("text/x-csrc", "c", 5);
        g("text/x-dsrc", "d", 5);
        g("text/x-haskell", "hs", 5);
        g("text/x-java", "java", 5);
        g("text/x-literate-haskell", "lhs", 5);
        g("text/x-moc", "moc", 5);
        g("text/x-pascal", "p", 5);
        g("text/x-pascal", "pas", 5);
        g("text/x-pcs-gcd", "gcd", 5);
        g("text/x-setext", "etx", 5);
        g("text/x-tcl", "tcl", 5);
        g("text/x-tex", "tex", 5);
        g("text/x-tex", "ltx", 5);
        g("text/x-tex", "sty", 5);
        g("text/x-tex", "cls", 5);
        g("text/x-vcalendar", "vcs", 5);
        g("text/x-vcard", "vcf", 5);
        g("video/mkv", "mkv", 0);
        g(MimeType.Video.GP3, "3gpp", 0);
        g(MimeType.Video.GP3, "3gp", 0);
        g(MimeType.Video.GP3, "3g2", 0);
        g("video/dl", IXAdCommonUtils.PKGS_PREF_DOWNLOAD_STATUS, 0);
        g("video/dv", "dif", 0);
        g("video/dv", "dv", 0);
        g("video/fli", "fli", 0);
        g("video/m4v", "m4v", 0);
        g(MimeType.Video.MPEG, "mpeg", 0);
        g(MimeType.Video.MPEG, "mpg", 0);
        g(MimeType.Video.MPEG, "mpe", 0);
        g(MimeType.Video.MP4, "mp4", 0);
        g(MimeType.Video.MPEG, "vob", 0);
        g("video/quicktime", "qt", 0);
        g("video/quicktime", "mov", 0);
        g("video/vnd.mpegurl", "mxu", 0);
        g("video/x-la-asf", "lsf", 0);
        g("video/x-la-asf", "lsx", 0);
        g("video/x-mng", "mng", 0);
        g("video/x-ms-asf", "asf", 0);
        g("video/x-ms-asf", "asx", 0);
        g("video/x-ms-wm", "wm", 0);
        g("video/x-ms-wmv", "wmv", 0);
        g("video/x-ms-wmx", "wmx", 0);
        g("video/x-ms-wvx", "wvx", 0);
        g("video/x-msvideo", "avi", 0);
        g("video/x-sgi-movie", "movie", 0);
        g("video/x-webex", "wrf", 0);
        g("x-conference/x-cooltalk", "ice", 5);
        g("x-epoc/x-sisx-app", "sisx", 5);
        g("video/vnd.rn-realvideo", "rmvb", 0);
        g("video/x-flv", "flv", 0);
        g("audio/aac", TranscoderPlugin.AUDIO_CODEC, 1);
        g("application/vnd.rn-realmedia", "rm", 0);
        g("message/rfc822", "mht", 11);
        cxH = Pattern.compile("attachment;\\s*filename\\s*=\\s*(\"?)([^\"]*)\\1\\s*$", 2);
    }

    private static void g(String str, String str2, int i) {
        cxD.put(str2, Integer.valueOf(i));
        cxE.put(str, Integer.valueOf(i));
        cxF.put(str2, str);
        if (!cxG.containsKey(str)) {
            cxG.put(str, str2);
        }
    }

    public static int cX(String str, String str2) {
        return v(!TextUtils.isEmpty(str) ? str.toLowerCase() : "", str2, true);
    }

    public static int v(String str, String str2, boolean z) {
        Integer num = cxE.get(str2);
        if (num == null) {
            num = cxD.get(str);
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

    public static String nU(String str) {
        int lastIndexOf;
        if (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf(".")) == -1 || lastIndexOf == str.length()) {
            return "";
        }
        return str.substring(lastIndexOf + 1);
    }

    public static String nV(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return cxF.get(str);
    }

    public static String yt(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return cxG.get(str);
    }

    public static String Z(String str, String str2, String str3) {
        String str4;
        String str5;
        int lastIndexOf;
        int lastIndexOf2;
        String str6 = null;
        if (0 != 0 || str2 == null) {
            str4 = null;
        } else {
            str4 = yu(str2);
            if (str4 != null && (lastIndexOf2 = str4.lastIndexOf(File.separator) + 1) > 0) {
                str4 = str4.substring(lastIndexOf2);
            }
        }
        if (TextUtils.isEmpty(str4)) {
            str4 = getFileNameFromUrl(str);
        }
        if (TextUtils.isEmpty(str4)) {
            str4 = Utils.DEFAULT_DL_FILENAME;
        }
        int lastIndexOf3 = str4.lastIndexOf(".");
        if (lastIndexOf3 < 0) {
            if (str3 != null) {
                str5 = MimeTypeMap.getSingleton().getExtensionFromMimeType(str3);
                if (TextUtils.isEmpty(str5)) {
                    if (str3.toLowerCase().startsWith("image/")) {
                        str5 = ".jpg";
                    }
                } else {
                    str5 = "." + str5;
                }
            } else {
                str5 = null;
            }
            if (str5 != null) {
                str6 = str5;
            } else if (str3 != null && str3.toLowerCase().startsWith("text/")) {
                if (str3.equalsIgnoreCase("text/html")) {
                    str6 = DownloadDataConstants.DEFAULT_DL_HTML_EXTENSION;
                } else {
                    str6 = DownloadDataConstants.DEFAULT_DL_TEXT_EXTENSION;
                }
            } else {
                String fileNameFromUrl = getFileNameFromUrl(str);
                if (!TextUtils.isEmpty(fileNameFromUrl) && (lastIndexOf = fileNameFromUrl.lastIndexOf(".")) != -1) {
                    str6 = fileNameFromUrl.substring(lastIndexOf + 1);
                }
                if (!TextUtils.isEmpty(str6)) {
                    str6 = "." + str6;
                } else {
                    str6 = DownloadDataConstants.DEFAULT_DL_BINARY_EXTENSION;
                }
            }
        } else {
            if (str3 != null) {
                String substring = str4.substring(str4.lastIndexOf(".") + 1);
                String yt = yt(str3);
                String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(str3);
                String lowerCase = !TextUtils.isEmpty(substring) ? substring.toLowerCase() : "";
                String lowerCase2 = !TextUtils.isEmpty(yt) ? yt.toLowerCase() : "";
                String lowerCase3 = !TextUtils.isEmpty(extensionFromMimeType) ? extensionFromMimeType.toLowerCase() : "";
                String nV = nV(lowerCase);
                String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase);
                String lowerCase4 = !TextUtils.isEmpty(nV) ? nV.toLowerCase() : "";
                String lowerCase5 = !TextUtils.isEmpty(mimeTypeFromExtension) ? mimeTypeFromExtension.toLowerCase() : "";
                if (TextUtils.equals(lowerCase4, lowerCase5)) {
                    if (!TextUtils.isEmpty(lowerCase2) && TextUtils.equals(lowerCase2, lowerCase3)) {
                        str6 = "." + lowerCase2;
                    }
                } else if (TextUtils.isEmpty(lowerCase4)) {
                    if (!TextUtils.isEmpty(lowerCase3)) {
                        str6 = "." + lowerCase3;
                    }
                } else if (TextUtils.isEmpty(lowerCase5)) {
                    if (!TextUtils.isEmpty(lowerCase4)) {
                        str6 = "." + lowerCase;
                    } else if (!TextUtils.isEmpty(lowerCase2)) {
                        str6 = "." + lowerCase2;
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

    public static String getFileNameFromUrl(String str) {
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

    static String yu(String str) {
        try {
            Matcher matcher = cxH.matcher(str);
            if (matcher.find()) {
                return matcher.group(2);
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        return null;
    }
}

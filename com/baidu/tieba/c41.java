package com.baidu.tieba;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.io.DocumentOpenUtil;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.down.utils.Utils;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.sapi2.SapiWebView;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.live.interfaces.defaultimpl.utils.MultiRatePlayUrlHelper;
import com.baidu.searchbox.logsystem.basic.upload.BaseContentUploader;
import com.baidu.searchbox.logsystem.exceptionhandler.impl.ExceptionHandlerImpl;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.fun.ad.sdk.FunAdSdk;
import com.google.android.exoplayer2.util.ColorParser;
import com.google.android.exoplayer2.util.MimeTypes;
import com.sina.weibo.sdk.utils.FileUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public final class c41 {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, Integer> a;
    public static HashMap<String, Integer> b;
    public static HashMap<String, String> c;
    public static HashMap<String, String> d;
    public static HashMap<String, Integer> e;
    public static final Pattern f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947624681, "Lcom/baidu/tieba/c41;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947624681, "Lcom/baidu/tieba/c41;");
                return;
            }
        }
        a = new HashMap<>();
        b = new HashMap<>();
        c = new HashMap<>();
        d = new HashMap<>();
        e = new HashMap<>();
        a("application/andrew-inset", "ez", 5);
        a("application/dsptype", "tsp", 5);
        a("application/futuresplash", "spl", 5);
        a("application/hta", "hta", 5);
        a("application/mac-binhex40", "hqx", 5);
        a("application/mac-compactpro", "cpt", 5);
        a("application/mathematica", BaseContentUploader.NB, 5);
        a("application/msaccess", "mdb", 5);
        a("application/oda", "oda", 5);
        a("application/ogg", "ogg", 1);
        a(DocumentOpenUtil.PDF_TYPE, DocumentOpenUtil.PDF, 4);
        a("application/pgp-keys", "key", 5);
        a("application/pgp-signature", "pgp", 5);
        a("application/pics-rules", "prf", 5);
        a("application/rar", "rar", 8);
        a("application/x-rar-compressed", "rar", 8);
        a("application/rdf+xml", "rdf", 5);
        a("application/rss+xml", "rss", 5);
        a("application/zip", StatConstants.VALUE_TYPE_ZIP, 8);
        a("application/x-zip-compressed", StatConstants.VALUE_TYPE_ZIP, 8);
        a("application/vnd.android.package-archive", "apk", 3);
        a("application/vnd.cinderella", "cdy", 5);
        a("application/vnd.ms-pki.stl", "stl", 5);
        a("application/vnd.oasis.opendocument.database", "odb", 5);
        a("application/vnd.oasis.opendocument.formula", "odf", 5);
        a("application/vnd.oasis.opendocument.graphics", "odg", 5);
        a("application/vnd.oasis.opendocument.graphics-template", "otg", 5);
        a("application/vnd.oasis.opendocument.image", "odi", 5);
        a("application/vnd.oasis.opendocument.spreadsheet", "ods", 5);
        a("application/vnd.oasis.opendocument.spreadsheet-template", "ots", 5);
        a("application/vnd.oasis.opendocument.text", "odt", 5);
        a("application/vnd.oasis.opendocument.text-master", "odm", 5);
        a("application/vnd.oasis.opendocument.text-template", "ott", 5);
        a("application/vnd.oasis.opendocument.text-web", "oth", 5);
        a("application/vnd.google-earth.kml+xml", "kml", 5);
        a("application/vnd.google-earth.kmz", "kmz", 5);
        a(DocumentOpenUtil.WORD_TYPE, DocumentOpenUtil.DOC, 4);
        a(DocumentOpenUtil.WORD_TYPE, "dot", 4);
        a(DocumentOpenUtil.DOCUMENT_TYPE, DocumentOpenUtil.DOCX, 4);
        a("application/vnd.openxmlformats-officedocument.wordprocessingml.template", "dotx", 4);
        a(DocumentOpenUtil.EXCEL_TYPE, DocumentOpenUtil.XLS, 4);
        a(DocumentOpenUtil.EXCEL_TYPE, "xlt", 4);
        a(DocumentOpenUtil.SHEET_TYPE, DocumentOpenUtil.XLSX, 4);
        a("application/vnd.openxmlformats-officedocument.spreadsheetml.template", "xltx", 4);
        a(DocumentOpenUtil.PPT_TYPE, DocumentOpenUtil.PPT, 4);
        a(DocumentOpenUtil.PPT_TYPE, "pot", 4);
        a(DocumentOpenUtil.PPT_TYPE, "pps", 4);
        a(DocumentOpenUtil.PRESENT_TYPE, DocumentOpenUtil.PPTX, 4);
        a("application/vnd.openxmlformats-officedocument.presentationml.template", "potx", 4);
        a("application/vnd.openxmlformats-officedocument.presentationml.slideshow", "ppsx", 4);
        a("application/vnd.rim.cod", "cod", 5);
        a("application/vnd.smaf", "mmf", 5);
        a("application/vnd.stardivision.calc", "sdc", 5);
        a("application/vnd.stardivision.draw", "sda", 5);
        a("application/vnd.stardivision.impress", "sdd", 5);
        a("application/vnd.stardivision.impress", "sdp", 5);
        a("application/vnd.stardivision.math", "smf", 5);
        a("application/vnd.stardivision.writer", "sdw", 5);
        a("application/vnd.stardivision.writer", "vor", 5);
        a("application/vnd.stardivision.writer-global", "sgl", 5);
        a("application/vnd.sun.xml.calc", "sxc", 5);
        a("application/vnd.sun.xml.calc.template", "stc", 5);
        a("application/vnd.sun.xml.draw", "sxd", 5);
        a("application/vnd.sun.xml.draw.template", "std", 5);
        a("application/vnd.sun.xml.impress", "sxi", 5);
        a("application/vnd.sun.xml.impress.template", "sti", 5);
        a("application/vnd.sun.xml.math", "sxm", 5);
        a("application/vnd.sun.xml.writer", "sxw", 5);
        a("application/vnd.sun.xml.writer.global", "sxg", 5);
        a("application/vnd.sun.xml.writer.template", "stw", 5);
        a("application/vnd.visio", "vsd", 5);
        a("application/x-abiword", "abw", 5);
        a("application/x-apple-diskimage", "dmg", 5);
        a("application/x-bcpio", "bcpio", 5);
        a("application/x-bittorrent", "torrent", 5);
        a("application/x-cdf", "cdf", 5);
        a("application/x-cdlink", "vcd", 5);
        a("application/x-chess-pgn", "pgn", 5);
        a("application/x-cpio", "cpio", 5);
        a("application/x-debian-package", "deb", 5);
        a("application/x-debian-package", "udeb", 5);
        a("application/x-director", "dcr", 5);
        a("application/x-director", MapBundleKey.MapObjKey.OBJ_DIR, 5);
        a("application/x-director", "dxr", 5);
        a("application/x-dms", "dms", 5);
        a("application/x-doom", "wad", 5);
        a("application/x-dvi", "dvi", 5);
        a("application/x-flac", "flac", 1);
        a("application/x-font", "pfa", 5);
        a("application/x-font", "pfb", 5);
        a("application/x-font", "gsf", 5);
        a("application/x-font", "pcf", 5);
        a("application/x-font", "pcf.Z", 5);
        a("application/x-freemind", FunAdSdk.PLATFORM_MM, 5);
        a("application/x-futuresplash", "spl", 5);
        a("application/x-gnumeric", "gnumeric", 5);
        a("application/x-go-sgf", "sgf", 5);
        a("application/x-graphing-calculator", "gcf", 5);
        a("application/x-gtar", "gtar", 5);
        a("application/x-gtar", "tgz", 5);
        a("application/x-gtar", "taz", 5);
        a("application/x-hdf", "hdf", 5);
        a("application/x-ica", "ica", 5);
        a("application/x-internet-signup", "ins", 5);
        a("application/x-internet-signup", "isp", 5);
        a("application/x-iphone", "iii", 5);
        a("application/x-iso9660-image", "iso", 5);
        a("application/x-jmol", "jmz", 5);
        a("application/x-kchart", "chrt", 5);
        a("application/x-killustrator", "kil", 5);
        a("application/x-koan", "skp", 5);
        a("application/x-koan", "skd", 5);
        a("application/x-koan", "skt", 5);
        a("application/x-koan", "skm", 5);
        a("application/x-kpresenter", "kpr", 5);
        a("application/x-kpresenter", "kpt", 5);
        a("application/x-kspread", "ksp", 5);
        a("application/x-kword", "kwd", 5);
        a("application/x-kword", "kwt", 5);
        a("application/x-latex", "latex", 5);
        a("application/x-lha", "lha", 5);
        a("application/x-lzh", "lzh", 5);
        a("application/x-lzx", "lzx", 5);
        a("application/x-maker", "frm", 5);
        a("application/x-maker", "maker", 5);
        a("application/x-maker", "frame", 5);
        a("application/x-maker", "fb", 5);
        a("application/x-maker", "book", 5);
        a("application/x-maker", "fbdoc", 5);
        a("application/x-mif", "mif", 5);
        a("application/x-ms-wmd", "wmd", 5);
        a("application/x-ms-wmz", "wmz", 5);
        a("application/x-msi", "msi", 5);
        a("application/x-ns-proxy-autoconfig", "pac", 5);
        a("application/x-nwc", "nwc", 5);
        a("application/x-object", "o", 5);
        a("application/x-oz-application", "oza", 5);
        a("application/x-pkcs12", "p12", 5);
        a("application/x-pkcs12", "pfx", 5);
        a("application/x-pkcs7-certreqresp", "p7r", 5);
        a("application/x-pkcs7-crl", "crl", 5);
        a("application/x-quicktimeplayer", "qtl", 5);
        a("application/x-shar", "shar", 5);
        a("application/x-shockwave-flash", "swf", 5);
        a("application/x-stuffit", "sit", 5);
        a("application/x-sv4cpio", "sv4cpio", 5);
        a("application/x-sv4crc", "sv4crc", 5);
        a("application/x-tar", "tar", 8);
        a("application/x-texinfo", "texinfo", 5);
        a("application/x-texinfo", "texi", 5);
        a("application/x-troff", "t", 5);
        a("application/x-troff", "roff", 5);
        a("application/x-troff-man", "man", 5);
        a("application/x-ustar", "ustar", 5);
        a("application/x-wais-source", "src", 5);
        a("application/x-wingz", "wz", 5);
        a("application/x-webarchive", "webarchive", 5);
        a("application/x-webarchive-xml", "webarchivexml", 5);
        a("application/x-x509-ca-cert", "crt", 5);
        a("application/x-x509-user-cert", "crt", 5);
        a("application/x-xcf", "xcf", 5);
        a("application/x-xfig", "fig", 5);
        a("application/xhtml+xml", "xhtml", 5);
        a("application/font-sfnt", "ttf", 5);
        a(MimeTypes.AUDIO_AMR_NB, "3gpp", 1);
        a("audio/amr", "amr", 1);
        a("audio/basic", "snd", 1);
        a("audio/midi", "mid", 1);
        a("audio/midi", "midi", 1);
        a("audio/midi", "kar", 1);
        a("audio/midi", "xmf", 1);
        a("audio/mobile-xmf", "mxmf", 1);
        a(MimeTypes.AUDIO_MPEG, "mp3", 1);
        a(MimeTypes.AUDIO_MPEG, "mpga", 1);
        a(MimeTypes.AUDIO_MPEG, "mpega", 1);
        a(MimeTypes.AUDIO_MPEG, "mp2", 1);
        a(MimeTypes.AUDIO_MPEG, "m4a", 1);
        a("audio/mpegurl", "m3u", 1);
        a("audio/prs.sid", "sid", 1);
        a("audio/x-aiff", "aif", 1);
        a("audio/x-aiff", "aiff", 1);
        a("audio/x-aiff", "aifc", 1);
        a("audio/x-gsm", "gsm", 1);
        a("audio/x-mpegurl", "m3u", 1);
        a("audio/x-ms-wma", "wma", 1);
        a("audio/x-ms-wax", "wax", 1);
        a("audio/x-pn-realaudio", MultiRatePlayUrlHelper.ABBR_RATE_NAME, 1);
        a("audio/x-pn-realaudio", com.kuaishou.weapon.p0.u.B, 1);
        a("audio/x-pn-realaudio", "ram", 1);
        a("audio/x-realaudio", MultiRatePlayUrlHelper.ABBR_RATE_NAME, 1);
        a("audio/x-scpls", "pls", 1);
        a("audio/x-sd2", "sd2", 1);
        a("audio/x-wav", "wav", 1);
        a("image/bmp", "bmp", 2);
        a("image/gif", NativeConstants.TYPE_GIF, 2);
        a("image/ico", "cur", 5);
        a("image/ico", "ico", 2);
        a("image/ief", "ief", 5);
        a("image/jpeg", "jpeg", 2);
        a("image/jpeg", "jpg", 2);
        a("image/jpeg", "jpe", 2);
        a("image/pcx", "pcx", 5);
        a("image/png", "png", 2);
        a("image/svg+xml", "svg", 5);
        a("image/svg+xml", "svgz", 5);
        a("image/tiff", "tiff", 5);
        a("image/tiff", "tif", 5);
        a("image/vnd.djvu", "djvu", 5);
        a("image/vnd.djvu", "djv", 5);
        a(Downsampler.WBMP_MIME_TYPE, "wbmp", 2);
        a("image/webp", "webp", 2);
        a("image/x-cmu-raster", "ras", 5);
        a("image/x-coreldraw", "cdr", 5);
        a("image/x-coreldrawpattern", "pat", 5);
        a("image/x-coreldrawtemplate", "cdt", 5);
        a("image/x-corelphotopaint", "cpt", 5);
        a("image/x-icon", "ico", 2);
        a("image/x-jg", "art", 5);
        a("image/x-jng", "jng", 5);
        a("image/x-ms-bmp", "bmp", 2);
        a("image/x-photoshop", "psd", 5);
        a("image/x-portable-anymap", "pnm", 5);
        a("image/x-portable-bitmap", "pbm", 5);
        a("image/x-portable-graymap", "pgm", 5);
        a("image/x-portable-pixmap", "ppm", 5);
        a("image/x-rgb", ColorParser.RGB, 5);
        a("image/x-xbitmap", "xbm", 5);
        a("image/x-xpixmap", "xpm", 5);
        a("image/x-xwindowdump", "xwd", 5);
        a("model/iges", "igs", 5);
        a("model/iges", "iges", 5);
        a("model/mesh", "msh", 5);
        a("model/mesh", "mesh", 5);
        a("model/mesh", "silo", 5);
        a("text/calendar", "ics", 5);
        a("text/calendar", "icz", 5);
        a("text/comma-separated-values", "csv", 5);
        a("text/css", "css", 5);
        a(SapiWebView.DATA_MIME_TYPE, "htm", 11);
        a(SapiWebView.DATA_MIME_TYPE, "html", 11);
        a("text/h323", "323", 5);
        a("text/iuls", "uls", 5);
        a("text/mathml", "mml", 5);
        a("text/plain-story", "txt", 6);
        a("text/plain", "dat", 5);
        a("text/plain", "txt", 4);
        a("text/plain", "asc", 5);
        a("text/plain", "text", 4);
        a("text/plain", "diff", 5);
        a("text/plain", "po", 5);
        a("text/richtext", "rtx", 5);
        a("text/rtf", "rtf", 5);
        a("text/texmacs", "ts", 5);
        a("text/text", "phps", 5);
        a("text/tab-separated-values", "tsv", 5);
        a("text/xml", "xml", 5);
        a("text/x-bibtex", "bib", 5);
        a("text/x-boo", "boo", 5);
        a("text/x-c++hdr", "h++", 5);
        a("text/x-c++hdr", "hpp", 5);
        a("text/x-c++hdr", "hxx", 5);
        a("text/x-c++hdr", "hh", 5);
        a("text/x-c++src", "c++", 5);
        a("text/x-c++src", "cpp", 5);
        a("text/x-c++src", "cxx", 5);
        a("text/x-chdr", "h", 5);
        a("text/x-component", "htc", 5);
        a("text/x-csh", "csh", 5);
        a("text/x-csrc", "c", 5);
        a("text/x-dsrc", "d", 5);
        a("text/x-haskell", "hs", 5);
        a("text/x-java", ExceptionHandlerImpl.EXCEPTION_TYPE_JAVA, 5);
        a("text/x-literate-haskell", "lhs", 5);
        a("text/x-moc", "moc", 5);
        a("text/x-pascal", "p", 5);
        a("text/x-pascal", "pas", 5);
        a("text/x-pcs-gcd", "gcd", 5);
        a("text/x-setext", "etx", 5);
        a("text/x-tcl", "tcl", 5);
        a("text/x-tex", "tex", 5);
        a("text/x-tex", "ltx", 5);
        a("text/x-tex", "sty", 5);
        a("text/x-tex", "cls", 5);
        a("text/x-vcalendar", "vcs", 5);
        a("text/x-vcard", "vcf", 5);
        a("video/mkv", "mkv", 0);
        a(MimeTypes.VIDEO_H263, "3gpp", 0);
        a(MimeTypes.VIDEO_H263, "3gp", 0);
        a(MimeTypes.VIDEO_H263, "3g2", 0);
        a("video/dl", "dl", 0);
        a("video/dv", "dif", 0);
        a("video/dv", "dv", 0);
        a("video/fli", "fli", 0);
        a("video/m4v", "m4v", 0);
        a("video/mpeg", "mpeg", 0);
        a("video/mpeg", "mpg", 0);
        a("video/mpeg", "mpe", 0);
        a(MimeTypes.VIDEO_MP4, "mp4", 0);
        a("video/mpeg", "vob", 0);
        a("video/quicktime", "qt", 0);
        a("video/quicktime", "mov", 0);
        a("video/vnd.mpegurl", "mxu", 0);
        a("video/x-la-asf", "lsf", 0);
        a("video/x-la-asf", "lsx", 0);
        a("video/x-mng", "mng", 0);
        a("video/x-ms-asf", "asf", 0);
        a("video/x-ms-asf", "asx", 0);
        a("video/x-ms-wm", "wm", 0);
        a("video/x-ms-wmv", "wmv", 0);
        a("video/x-ms-wmx", "wmx", 0);
        a("video/x-ms-wvx", "wvx", 0);
        a("video/x-msvideo", "avi", 0);
        a("video/x-sgi-movie", "movie", 0);
        a("video/x-webex", "wrf", 0);
        a("x-conference/x-cooltalk", "ice", 5);
        a("x-epoc/x-sisx-app", "sisx", 5);
        a("video/vnd.rn-realvideo", "rmvb", 0);
        a("video/x-flv", "flv", 0);
        a("audio/aac", "aac", 1);
        a("application/vnd.rn-realmedia", com.kuaishou.weapon.p0.u.B, 0);
        a("message/rfc822", "mht", 11);
        a("application/x.mpegurl", "m3u8", 0);
        a("application/vnd.apple.mpegurl", "m3u8", 0);
        a("application/x.mpegurl", "m3u", 0);
        a("application/vnd.apple.mpegurl", "m3u", 0);
        f = Pattern.compile("attachment;\\s*filename\\s*=\\s*(\"?)([^\"]*)\\1\\s*$", 2);
    }

    public static void a(String str, String str2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65537, null, str, str2, i) == null) {
            a.put(str2, Integer.valueOf(i));
            b.put(str, Integer.valueOf(i));
            HashMap<String, Integer> hashMap = e;
            hashMap.put(str + "@" + str2, Integer.valueOf(i));
            c.put(str2, str);
            if (!d.containsKey(str)) {
                d.put(str, str2);
            }
        }
    }

    public static int b(String str, String str2) {
        InterceptResult invokeLL;
        String str3;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (!TextUtils.isEmpty(str)) {
                str3 = str.toLowerCase(Locale.getDefault());
            } else {
                str3 = "";
            }
            if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2)) {
                HashMap<String, Integer> hashMap = e;
                num = hashMap.get(str2 + "@" + str3);
                if (num == null) {
                    num = a.get(str3);
                }
                if (num == null) {
                    num = b.get(str2);
                }
            } else if (TextUtils.isEmpty(str2)) {
                num = a.get(str3);
            } else {
                num = b.get(str2);
            }
            if (num == null) {
                num = 5;
            }
            return num.intValue();
        }
        return invokeLL.intValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        int lastIndexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (str == null || (lastIndexOf = str.lastIndexOf(".")) == -1 || lastIndexOf == str.length()) {
                return "";
            }
            return str.substring(lastIndexOf + 1);
        }
        return (String) invokeL.objValue;
    }

    public static String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return d.get(str);
        }
        return (String) invokeL.objValue;
    }

    public static String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return c.get(str);
        }
        return (String) invokeL.objValue;
    }

    public static String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            try {
                Matcher matcher = f.matcher(str);
                if (matcher.find()) {
                    return matcher.group(2);
                }
                return null;
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String e(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        int lastIndexOf;
        int lastIndexOf2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, str, str2, str3)) == null) {
            String str11 = null;
            if (str2 != null) {
                str4 = g(str2);
                if (str4 != null && (lastIndexOf2 = str4.lastIndexOf(File.separator) + 1) > 0) {
                    str4 = str4.substring(lastIndexOf2);
                }
            } else {
                str4 = null;
            }
            if (TextUtils.isEmpty(str4)) {
                str4 = d41.d(str);
            }
            if (TextUtils.isEmpty(str4)) {
                str4 = Utils.DEFAULT_DL_FILENAME;
            }
            int lastIndexOf3 = str4.lastIndexOf(".");
            if (lastIndexOf3 < 0) {
                if (str3 != null) {
                    str10 = MimeTypeMap.getSingleton().getExtensionFromMimeType(str3);
                    if (TextUtils.isEmpty(str10)) {
                        if (str3.toLowerCase(Locale.getDefault()).startsWith(FileUtils.IMAGE_FILE_START)) {
                            str10 = ".jpg";
                        }
                    } else {
                        str10 = "." + str10;
                    }
                } else {
                    str10 = null;
                }
                if (str10 == null) {
                    if (str3 != null && str3.toLowerCase(Locale.getDefault()).startsWith("text/")) {
                        if (str3.equalsIgnoreCase(SapiWebView.DATA_MIME_TYPE)) {
                            str10 = DownloadDataConstants.DEFAULT_DL_HTML_EXTENSION;
                        } else {
                            str10 = DownloadDataConstants.DEFAULT_DL_TEXT_EXTENSION;
                        }
                    } else {
                        String d2 = d41.d(str);
                        if (!TextUtils.isEmpty(d2) && (lastIndexOf = d2.lastIndexOf(".")) != -1) {
                            str11 = d2.substring(lastIndexOf + 1);
                        }
                        if (!TextUtils.isEmpty(str11)) {
                            str5 = "." + str11;
                        } else {
                            str5 = DownloadDataConstants.DEFAULT_DL_BINARY_EXTENSION;
                        }
                    }
                }
                if (str4 != null && str4.length() > 50) {
                    str4 = str4.substring(0, 50);
                }
                return str4 + str10;
            }
            if (str3 != null) {
                String substring = str4.substring(str4.lastIndexOf(".") + 1);
                String d3 = d(str3);
                String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(str3);
                String str12 = "";
                if (TextUtils.isEmpty(substring)) {
                    str6 = "";
                } else {
                    str6 = substring.toLowerCase(Locale.getDefault());
                }
                if (TextUtils.isEmpty(d3)) {
                    str7 = "";
                } else {
                    str7 = d3.toLowerCase(Locale.getDefault());
                }
                if (TextUtils.isEmpty(extensionFromMimeType)) {
                    str8 = "";
                } else {
                    str8 = extensionFromMimeType.toLowerCase(Locale.getDefault());
                }
                String f2 = f(str6);
                String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str6);
                if (TextUtils.isEmpty(f2)) {
                    str9 = "";
                } else {
                    str9 = f2.toLowerCase(Locale.getDefault());
                }
                if (!TextUtils.isEmpty(mimeTypeFromExtension)) {
                    str12 = mimeTypeFromExtension.toLowerCase(Locale.getDefault());
                }
                if (TextUtils.equals(str9, str12)) {
                    if (!TextUtils.isEmpty(str7) && TextUtils.equals(str7, str8)) {
                        str11 = "." + str7;
                    }
                } else if (TextUtils.isEmpty(str9)) {
                    if (!TextUtils.isEmpty(str8)) {
                        str11 = "." + str8;
                    }
                } else if (TextUtils.isEmpty(str12)) {
                    if (!TextUtils.isEmpty(str9)) {
                        str11 = "." + str6;
                    } else if (!TextUtils.isEmpty(str7)) {
                        str11 = "." + str7;
                    }
                }
            }
            if (str11 == null) {
                str5 = str4.substring(lastIndexOf3);
            } else {
                str5 = str11;
            }
            str4 = str4.substring(0, lastIndexOf3);
            str10 = str5;
            if (str4 != null) {
                str4 = str4.substring(0, 50);
            }
            return str4 + str10;
        }
        return (String) invokeLLL.objValue;
    }
}

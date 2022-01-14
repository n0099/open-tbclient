package com.baidu.tieba.flutter.plugin.tiebaShare;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.s0.s.q.e2;
import c.a.t0.k0.h;
import c.a.t0.z0.a.j.c;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalForumInfo;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.flutter.plugin.tiebaShare.TiebaShareAuto;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class TiebaSharePlugin implements FlutterPlugin, TiebaShareAuto.HostTiebaShare {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public TiebaSharePlugin() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private String getShareImageUrl(e2 e2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, e2Var)) == null) {
            String str = null;
            if (e2Var == null) {
                return null;
            }
            if (e2Var.o1() != null && !TextUtils.isEmpty(e2Var.o1().cover)) {
                return e2Var.o1().cover;
            }
            if (e2Var.F0() == null) {
                return null;
            }
            ArrayList<MediaData> F0 = e2Var.F0();
            int size = F0.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                }
                MediaData mediaData = F0.get(i2);
                if (mediaData != null && (mediaData.getType() == 3 || mediaData.getType() == 5)) {
                    if (!StringUtils.isNull(mediaData.getThumbnails_url())) {
                        str = mediaData.getThumbnails_url();
                        break;
                    } else if (!StringUtils.isNull(mediaData.getPicUrl())) {
                        str = mediaData.getPicUrl();
                        break;
                    }
                }
                i2++;
            }
            return (str != null || e2Var.t1() == null || TextUtils.isEmpty(e2Var.t1().thumbnail_url)) ? str : e2Var.t1().thumbnail_url;
        }
        return (String) invokeL.objValue;
    }

    private int getShareObjParam2(e2 e2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, e2Var)) == null) {
            if (e2Var == null) {
                return 0;
            }
            if (e2Var.I2()) {
                return 11;
            }
            if (e2Var.P1()) {
                return 10;
            }
            if (e2Var.S1()) {
                return 9;
            }
            if (e2Var.R1()) {
                return 8;
            }
            if (e2Var.Q1()) {
                return 7;
            }
            if (e2Var.A1) {
                return 6;
            }
            int i2 = e2Var.d0;
            if (i2 == 0) {
                return 1;
            }
            if (i2 == 40) {
                return 2;
            }
            if (i2 == 49 || i2 == 69) {
                return 3;
            }
            return i2 == 54 ? 4 : 5;
        }
        return invokeL.intValue;
    }

    private int getStateThreadType(e2 e2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, e2Var)) == null) {
            if (e2Var != null) {
                if (e2Var.t2()) {
                    return 4;
                }
                if (e2Var.k0() == 1) {
                    return 3;
                }
                if (e2Var.P1()) {
                    return 5;
                }
                if (e2Var.S1()) {
                    return 6;
                }
                if (e2Var.Q1()) {
                    return 7;
                }
                if (e2Var.R1()) {
                    return 8;
                }
                if (!e2Var.A1 || e2Var.z1 == null) {
                    return e2Var.u2() ? 2 : 1;
                }
                return 9;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    private void showShareDetailsDialog(String str, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) || str == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        statisticItem.param("obj_locate", 24);
        TiebaStatic.log(statisticItem);
        ShareItem shareItem = new ShareItem();
        shareItem.t = str;
        shareItem.q = str2;
        shareItem.r = str3;
        shareItem.l = true;
        shareItem.E = 19;
        TbadkCoreApplication.getInst().setShareItem(shareItem);
        Bundle bundle = new Bundle();
        bundle.putInt("obj_param1", shareItem.F);
        bundle.putInt("obj_type", shareItem.M);
        bundle.putString("fid", shareItem.J);
        bundle.putString("tid", shareItem.K);
        bundle.putInt("obj_source", shareItem.o);
        bundle.putInt("source", 10);
        shareItem.k(bundle);
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(TbadkCoreApplication.getInst().getCurrentActivity(), shareItem, true);
        if (z) {
            h.c().l(shareDialogConfig);
            return;
        }
        shareDialogConfig.isCopyLink = true;
        MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void showShareDialog(e2 e2Var) {
        String v1;
        String str;
        boolean z;
        Uri parse;
        String o;
        String format;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, this, e2Var) == null) || e2Var == null) {
            return;
        }
        String valueOf = String.valueOf(e2Var.U());
        String a0 = e2Var.a0();
        OriginalForumInfo originalForumInfo = e2Var.J1;
        if (originalForumInfo != null) {
            valueOf = originalForumInfo.id;
            a0 = originalForumInfo.ori_fname;
        }
        String str2 = a0;
        String str3 = valueOf;
        String title = e2Var.getTitle();
        if (TextUtils.isEmpty(title)) {
            title = e2Var.o();
        }
        String str4 = title;
        if (e2Var.G2()) {
            v1 = e2Var.L().oriUgcTid;
            str = "?share=9105&fr=dshare&dtype=" + e2Var.L().oriUgcType + "&dvid=" + e2Var.L().oriUgcVid + "&nid=" + e2Var.L().oriUgcNid;
        } else {
            v1 = e2Var.v1();
            str = "?share=9105&fr=sharewise";
        }
        String str5 = str;
        String str6 = v1;
        String str7 = "http://tieba.baidu.com/p/" + str6 + str5;
        boolean z2 = false;
        if (e2Var.o1() != null && e2Var.o1().user_info != null) {
            try {
                str7 = "https://tieba.baidu.com/ala/share?uname=" + URLEncoder.encode(e2Var.o1().user_info.user_name, "utf-8");
                z = false;
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            String shareImageUrl = getShareImageUrl(e2Var);
            parse = shareImageUrl != null ? null : Uri.parse(shareImageUrl);
            o = e2Var.o();
            String string = TbadkApplication.getInst().getResources().getString(R.string.share_content_tpl);
            String string2 = TbadkApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
            if (!e2Var.G2() && e2Var.J() != null) {
                format = (TextUtils.isEmpty(e2Var.getTitle()) || TextUtils.isEmpty(o)) ? MessageFormat.format(string2, e2Var.J().getName_show(), TbadkApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix)) : o;
            } else {
                format = MessageFormat.format(string, str4, o);
            }
            String cutString = m.cutString(str4, 100);
            String cutString2 = m.cutString(format, 100);
            ShareItem shareItem = new ShareItem();
            shareItem.r = cutString;
            shareItem.s = cutString2;
            int stateThreadType = getStateThreadType(e2Var);
            if (!e2Var.G2()) {
                shareItem.R = -1L;
                shareItem.D = cutString2;
            } else {
                if (stateThreadType == 2 && e2Var.t1() != null) {
                    shareItem.R = e2Var.t1().play_count.intValue();
                } else if (stateThreadType == 1) {
                    shareItem.R = e2Var.E1();
                }
                shareItem.D = o;
            }
            if (e2Var.G1() != null) {
                shareItem.U = e2Var.G1().room_id.longValue();
            }
            shareItem.t = str7;
            shareItem.q = str6;
            shareItem.J = str3;
            shareItem.p = str2;
            shareItem.K = str6;
            shareItem.f40766f = true;
            shareItem.o = 6;
            shareItem.E = 8;
            shareItem.M = stateThreadType;
            shareItem.F = 3;
            shareItem.G = getShareObjParam2(e2Var);
            if (parse != null) {
                shareItem.v = parse;
            }
            if (e2Var.G2()) {
                z = false;
            }
            shareItem.m0 = z;
            if (z) {
                shareItem.k0 = e2Var.b1();
            }
            shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(e2Var);
            shareItem.W = ShareItem.ForwardInfo.generateForwardInfo(e2Var);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.F);
            bundle.putInt("obj_type", shareItem.M);
            bundle.putString("fid", shareItem.J);
            bundle.putString("tid", shareItem.K);
            bundle.putInt("obj_source", shareItem.o);
            shareItem.k(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(TbadkCoreApplication.getInst().getCurrentActivity(), shareItem, true);
            shareDialogConfig.setIsAlaLive((e2Var.r1() != 49 || e2Var.r1() == 60 || e2Var.r1() == 69) ? true : true);
            shareDialogConfig.setFrom(ShareDialogConfig.From.PersonPolymeric);
            h.c().l(shareDialogConfig);
        }
        z = true;
        String shareImageUrl2 = getShareImageUrl(e2Var);
        if (shareImageUrl2 != null) {
        }
        o = e2Var.o();
        String string3 = TbadkApplication.getInst().getResources().getString(R.string.share_content_tpl);
        String string22 = TbadkApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
        if (!e2Var.G2()) {
        }
        format = MessageFormat.format(string3, str4, o);
        String cutString3 = m.cutString(str4, 100);
        String cutString22 = m.cutString(format, 100);
        ShareItem shareItem2 = new ShareItem();
        shareItem2.r = cutString3;
        shareItem2.s = cutString22;
        int stateThreadType2 = getStateThreadType(e2Var);
        if (!e2Var.G2()) {
        }
        if (e2Var.G1() != null) {
        }
        shareItem2.t = str7;
        shareItem2.q = str6;
        shareItem2.J = str3;
        shareItem2.p = str2;
        shareItem2.K = str6;
        shareItem2.f40766f = true;
        shareItem2.o = 6;
        shareItem2.E = 8;
        shareItem2.M = stateThreadType2;
        shareItem2.F = 3;
        shareItem2.G = getShareObjParam2(e2Var);
        if (parse != null) {
        }
        if (e2Var.G2()) {
        }
        shareItem2.m0 = z;
        if (z) {
        }
        shareItem2.T = OriginalThreadInfo.ShareInfo.generateShareInfo(e2Var);
        shareItem2.W = ShareItem.ForwardInfo.generateForwardInfo(e2Var);
        TbadkCoreApplication.getInst().setShareItem(shareItem2);
        Bundle bundle2 = new Bundle();
        bundle2.putInt("obj_param1", shareItem2.F);
        bundle2.putInt("obj_type", shareItem2.M);
        bundle2.putString("fid", shareItem2.J);
        bundle2.putString("tid", shareItem2.K);
        bundle2.putInt("obj_source", shareItem2.o);
        shareItem2.k(bundle2);
        ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig(TbadkCoreApplication.getInst().getCurrentActivity(), shareItem2, true);
        shareDialogConfig2.setIsAlaLive((e2Var.r1() != 49 || e2Var.r1() == 60 || e2Var.r1() == 69) ? true : true);
        shareDialogConfig2.setFrom(ShareDialogConfig.From.PersonPolymeric);
        h.c().l(shareDialogConfig2);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, flutterPluginBinding) == null) {
            c.c(flutterPluginBinding.getBinaryMessenger(), this);
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, flutterPluginBinding) == null) {
            c.c(flutterPluginBinding.getBinaryMessenger(), null);
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaShare.TiebaShareAuto.HostTiebaShare
    public void shareGameItemDetails(TiebaShareAuto.GameDetailsParam gameDetailsParam) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gameDetailsParam) == null) {
            try {
                showShareDetailsDialog(gameDetailsParam.getUrl(), gameDetailsParam.getItemId(), gameDetailsParam.getItemName(), false);
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaShare.TiebaShareAuto.HostTiebaShare
    public void shareThread(TiebaShareAuto.ShareThreadParam shareThreadParam) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, shareThreadParam) == null) {
            try {
                JSONObject optJSONObject = new JSONObject(shareThreadParam.getThreadInfo()).optJSONObject("item");
                e2 e2Var = new e2();
                e2Var.b3(optJSONObject);
                showShareDialog(e2Var);
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }
}

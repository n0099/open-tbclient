package com.baidu.tieba.flutter.plugin.tiebaShare;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.e.f.p.k;
import b.a.q0.s.q.d2;
import b.a.r0.f0.h;
import b.a.r0.t0.a.j.c;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes9.dex */
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

    private String getShareImageUrl(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, d2Var)) == null) {
            String str = null;
            if (d2Var == null) {
                return null;
            }
            if (d2Var.m1() != null && !TextUtils.isEmpty(d2Var.m1().cover)) {
                return d2Var.m1().cover;
            }
            if (d2Var.E0() == null) {
                return null;
            }
            ArrayList<MediaData> E0 = d2Var.E0();
            int size = E0.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                }
                MediaData mediaData = E0.get(i2);
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
            return (str != null || d2Var.r1() == null || TextUtils.isEmpty(d2Var.r1().thumbnail_url)) ? str : d2Var.r1().thumbnail_url;
        }
        return (String) invokeL.objValue;
    }

    private int getShareObjParam2(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, d2Var)) == null) {
            if (d2Var == null) {
                return 0;
            }
            if (d2Var.H2()) {
                return 11;
            }
            if (d2Var.O1()) {
                return 10;
            }
            if (d2Var.R1()) {
                return 9;
            }
            if (d2Var.Q1()) {
                return 8;
            }
            if (d2Var.P1()) {
                return 7;
            }
            if (d2Var.z1) {
                return 6;
            }
            int i2 = d2Var.i0;
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

    private int getStateThreadType(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, d2Var)) == null) {
            if (d2Var != null) {
                if (d2Var.s2()) {
                    return 4;
                }
                if (d2Var.j0() == 1) {
                    return 3;
                }
                if (d2Var.O1()) {
                    return 5;
                }
                if (d2Var.R1()) {
                    return 6;
                }
                if (d2Var.P1()) {
                    return 7;
                }
                if (d2Var.Q1()) {
                    return 8;
                }
                if (!d2Var.z1 || d2Var.y1 == null) {
                    return d2Var.t2() ? 2 : 1;
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

    /* JADX WARN: Removed duplicated region for block: B:28:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void showShareDialog(d2 d2Var) {
        String t1;
        String str;
        boolean z;
        Uri parse;
        String o;
        String format;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, d2Var) == null) || d2Var == null) {
            return;
        }
        String valueOf = String.valueOf(d2Var.T());
        String Z = d2Var.Z();
        OriginalForumInfo originalForumInfo = d2Var.J1;
        if (originalForumInfo != null) {
            valueOf = originalForumInfo.id;
            Z = originalForumInfo.ori_fname;
        }
        String str2 = Z;
        String str3 = valueOf;
        String title = d2Var.getTitle();
        if (TextUtils.isEmpty(title)) {
            title = d2Var.o();
        }
        String str4 = title;
        if (d2Var.F2()) {
            t1 = d2Var.L().oriUgcTid;
            str = "?share=9105&fr=dshare&dtype=" + d2Var.L().oriUgcType + "&dvid=" + d2Var.L().oriUgcVid + "&nid=" + d2Var.L().oriUgcNid;
        } else {
            t1 = d2Var.t1();
            str = "?share=9105&fr=sharewise";
        }
        String str5 = str;
        String str6 = t1;
        String str7 = "http://tieba.baidu.com/p/" + str6 + str5;
        boolean z2 = false;
        if (d2Var.m1() != null && d2Var.m1().user_info != null) {
            try {
                str7 = "https://tieba.baidu.com/ala/share?uname=" + URLEncoder.encode(d2Var.m1().user_info.user_name, "utf-8");
                z = false;
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            String shareImageUrl = getShareImageUrl(d2Var);
            parse = shareImageUrl != null ? null : Uri.parse(shareImageUrl);
            o = d2Var.o();
            String string = TbadkApplication.getInst().getResources().getString(R.string.share_content_tpl);
            String string2 = TbadkApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
            if (!d2Var.F2() && d2Var.J() != null) {
                format = (TextUtils.isEmpty(d2Var.getTitle()) || TextUtils.isEmpty(o)) ? MessageFormat.format(string2, d2Var.J().getName_show(), TbadkApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix)) : o;
            } else {
                format = MessageFormat.format(string, str4, o);
            }
            String cutString = k.cutString(str4, 100);
            String cutString2 = k.cutString(format, 100);
            ShareItem shareItem = new ShareItem();
            shareItem.r = cutString;
            shareItem.s = cutString2;
            int stateThreadType = getStateThreadType(d2Var);
            if (!d2Var.F2()) {
                shareItem.R = -1L;
                shareItem.D = cutString2;
            } else {
                if (stateThreadType == 2 && d2Var.r1() != null) {
                    shareItem.R = d2Var.r1().play_count.intValue();
                } else if (stateThreadType == 1) {
                    shareItem.R = d2Var.D1();
                }
                shareItem.D = o;
            }
            shareItem.t = str7;
            shareItem.q = str6;
            shareItem.J = str3;
            shareItem.p = str2;
            shareItem.K = str6;
            shareItem.f46543f = true;
            shareItem.o = 6;
            shareItem.E = 8;
            shareItem.M = stateThreadType;
            shareItem.F = 3;
            shareItem.G = getShareObjParam2(d2Var);
            if (parse != null) {
                shareItem.v = parse;
            }
            if (d2Var.F2()) {
                z = false;
            }
            shareItem.j0 = z;
            if (z) {
                shareItem.i0 = d2Var.a1();
            }
            shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(d2Var);
            shareItem.U = ShareItem.ForwardInfo.generateForwardInfo(d2Var);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.F);
            bundle.putInt("obj_type", shareItem.M);
            bundle.putString("fid", shareItem.J);
            bundle.putString("tid", shareItem.K);
            bundle.putInt("obj_source", shareItem.o);
            shareItem.k(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(TbadkCoreApplication.getInst().getCurrentActivity(), shareItem, true);
            shareDialogConfig.setIsAlaLive((d2Var.p1() != 49 || d2Var.p1() == 60 || d2Var.p1() == 69) ? true : true);
            shareDialogConfig.setFrom(ShareDialogConfig.From.PersonPolymeric);
            h.c().l(shareDialogConfig);
        }
        z = true;
        String shareImageUrl2 = getShareImageUrl(d2Var);
        if (shareImageUrl2 != null) {
        }
        o = d2Var.o();
        String string3 = TbadkApplication.getInst().getResources().getString(R.string.share_content_tpl);
        String string22 = TbadkApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
        if (!d2Var.F2()) {
        }
        format = MessageFormat.format(string3, str4, o);
        String cutString3 = k.cutString(str4, 100);
        String cutString22 = k.cutString(format, 100);
        ShareItem shareItem2 = new ShareItem();
        shareItem2.r = cutString3;
        shareItem2.s = cutString22;
        int stateThreadType2 = getStateThreadType(d2Var);
        if (!d2Var.F2()) {
        }
        shareItem2.t = str7;
        shareItem2.q = str6;
        shareItem2.J = str3;
        shareItem2.p = str2;
        shareItem2.K = str6;
        shareItem2.f46543f = true;
        shareItem2.o = 6;
        shareItem2.E = 8;
        shareItem2.M = stateThreadType2;
        shareItem2.F = 3;
        shareItem2.G = getShareObjParam2(d2Var);
        if (parse != null) {
        }
        if (d2Var.F2()) {
        }
        shareItem2.j0 = z;
        if (z) {
        }
        shareItem2.T = OriginalThreadInfo.ShareInfo.generateShareInfo(d2Var);
        shareItem2.U = ShareItem.ForwardInfo.generateForwardInfo(d2Var);
        TbadkCoreApplication.getInst().setShareItem(shareItem2);
        Bundle bundle2 = new Bundle();
        bundle2.putInt("obj_param1", shareItem2.F);
        bundle2.putInt("obj_type", shareItem2.M);
        bundle2.putString("fid", shareItem2.J);
        bundle2.putString("tid", shareItem2.K);
        bundle2.putInt("obj_source", shareItem2.o);
        shareItem2.k(bundle2);
        ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig(TbadkCoreApplication.getInst().getCurrentActivity(), shareItem2, true);
        shareDialogConfig2.setIsAlaLive((d2Var.p1() != 49 || d2Var.p1() == 60 || d2Var.p1() == 69) ? true : true);
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
                d2 d2Var = new d2();
                d2Var.Z2(optJSONObject);
                showShareDialog(d2Var);
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }
}

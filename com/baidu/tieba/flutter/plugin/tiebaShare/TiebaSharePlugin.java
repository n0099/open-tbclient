package com.baidu.tieba.flutter.plugin.tiebaShare;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.k;
import c.a.p0.s.q.c2;
import c.a.q0.e0.f;
import c.a.q0.r0.a.i.c;
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
/* loaded from: classes7.dex */
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

    private String getShareImageUrl(c2 c2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, c2Var)) == null) {
            String str = null;
            if (c2Var == null) {
                return null;
            }
            if (c2Var.j1() != null && !TextUtils.isEmpty(c2Var.j1().cover)) {
                return c2Var.j1().cover;
            }
            if (c2Var.C0() == null) {
                return null;
            }
            ArrayList<MediaData> C0 = c2Var.C0();
            int size = C0.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                }
                MediaData mediaData = C0.get(i2);
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
            return (str != null || c2Var.o1() == null || TextUtils.isEmpty(c2Var.o1().thumbnail_url)) ? str : c2Var.o1().thumbnail_url;
        }
        return (String) invokeL.objValue;
    }

    private int getShareObjParam2(c2 c2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, c2Var)) == null) {
            if (c2Var == null) {
                return 0;
            }
            if (c2Var.B2()) {
                return 11;
            }
            if (c2Var.J1()) {
                return 10;
            }
            if (c2Var.M1()) {
                return 9;
            }
            if (c2Var.L1()) {
                return 8;
            }
            if (c2Var.K1()) {
                return 7;
            }
            if (c2Var.w1) {
                return 6;
            }
            int i2 = c2Var.a0;
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

    private int getStateThreadType(c2 c2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, c2Var)) == null) {
            if (c2Var != null) {
                if (c2Var.m2()) {
                    return 4;
                }
                if (c2Var.j0() == 1) {
                    return 3;
                }
                if (c2Var.J1()) {
                    return 5;
                }
                if (c2Var.M1()) {
                    return 6;
                }
                if (c2Var.K1()) {
                    return 7;
                }
                if (c2Var.L1()) {
                    return 8;
                }
                if (!c2Var.w1 || c2Var.v1 == null) {
                    return c2Var.n2() ? 2 : 1;
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
            f.b().k(shareDialogConfig);
            return;
        }
        shareDialogConfig.isCopyLink = true;
        MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void showShareDialog(c2 c2Var) {
        String q1;
        String str;
        boolean z;
        Uri parse;
        String o;
        String format;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, c2Var) == null) || c2Var == null) {
            return;
        }
        String valueOf = String.valueOf(c2Var.T());
        String Z = c2Var.Z();
        OriginalForumInfo originalForumInfo = c2Var.G1;
        if (originalForumInfo != null) {
            valueOf = originalForumInfo.id;
            Z = originalForumInfo.ori_fname;
        }
        String str2 = Z;
        String str3 = valueOf;
        String title = c2Var.getTitle();
        if (TextUtils.isEmpty(title)) {
            title = c2Var.o();
        }
        String str4 = title;
        if (c2Var.z2()) {
            q1 = c2Var.L().oriUgcTid;
            str = "?share=9105&fr=dshare&dtype=" + c2Var.L().oriUgcType + "&dvid=" + c2Var.L().oriUgcVid + "&nid=" + c2Var.L().oriUgcNid;
        } else {
            q1 = c2Var.q1();
            str = "?share=9105&fr=sharewise";
        }
        String str5 = str;
        String str6 = q1;
        String str7 = "http://tieba.baidu.com/p/" + str6 + str5;
        boolean z2 = false;
        if (c2Var.j1() != null && c2Var.j1().user_info != null) {
            try {
                str7 = "https://tieba.baidu.com/ala/share?uname=" + URLEncoder.encode(c2Var.j1().user_info.user_name, "utf-8");
                z = false;
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            String shareImageUrl = getShareImageUrl(c2Var);
            parse = shareImageUrl != null ? null : Uri.parse(shareImageUrl);
            o = c2Var.o();
            String string = TbadkApplication.getInst().getResources().getString(R.string.share_content_tpl);
            String string2 = TbadkApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
            if (!c2Var.z2() && c2Var.J() != null) {
                format = (TextUtils.isEmpty(c2Var.getTitle()) || TextUtils.isEmpty(o)) ? MessageFormat.format(string2, c2Var.J().getName_show(), TbadkApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix)) : o;
            } else {
                format = MessageFormat.format(string, str4, o);
            }
            String cutString = k.cutString(str4, 100);
            String cutString2 = k.cutString(format, 100);
            ShareItem shareItem = new ShareItem();
            shareItem.r = cutString;
            shareItem.s = cutString2;
            int stateThreadType = getStateThreadType(c2Var);
            if (!c2Var.z2()) {
                shareItem.R = -1L;
                shareItem.D = cutString2;
            } else {
                if (stateThreadType == 2 && c2Var.o1() != null) {
                    shareItem.R = c2Var.o1().play_count.intValue();
                } else if (stateThreadType == 1) {
                    shareItem.R = c2Var.A1();
                }
                shareItem.D = o;
            }
            shareItem.t = str7;
            shareItem.q = str6;
            shareItem.J = str3;
            shareItem.p = str2;
            shareItem.K = str6;
            shareItem.f47982f = true;
            shareItem.o = 6;
            shareItem.E = 8;
            shareItem.M = stateThreadType;
            shareItem.F = 3;
            shareItem.G = getShareObjParam2(c2Var);
            if (parse != null) {
                shareItem.v = parse;
            }
            if (c2Var.z2()) {
                z = false;
            }
            shareItem.g0 = z;
            if (z) {
                shareItem.f0 = c2Var.X0();
            }
            shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(c2Var);
            shareItem.U = ShareItem.ForwardInfo.generateForwardInfo(c2Var);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.F);
            bundle.putInt("obj_type", shareItem.M);
            bundle.putString("fid", shareItem.J);
            bundle.putString("tid", shareItem.K);
            bundle.putInt("obj_source", shareItem.o);
            shareItem.k(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(TbadkCoreApplication.getInst().getCurrentActivity(), shareItem, true);
            shareDialogConfig.setIsAlaLive((c2Var.m1() != 49 || c2Var.m1() == 60 || c2Var.m1() == 69) ? true : true);
            shareDialogConfig.setFrom(ShareDialogConfig.From.PersonPolymeric);
            f.b().k(shareDialogConfig);
        }
        z = true;
        String shareImageUrl2 = getShareImageUrl(c2Var);
        if (shareImageUrl2 != null) {
        }
        o = c2Var.o();
        String string3 = TbadkApplication.getInst().getResources().getString(R.string.share_content_tpl);
        String string22 = TbadkApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
        if (!c2Var.z2()) {
        }
        format = MessageFormat.format(string3, str4, o);
        String cutString3 = k.cutString(str4, 100);
        String cutString22 = k.cutString(format, 100);
        ShareItem shareItem2 = new ShareItem();
        shareItem2.r = cutString3;
        shareItem2.s = cutString22;
        int stateThreadType2 = getStateThreadType(c2Var);
        if (!c2Var.z2()) {
        }
        shareItem2.t = str7;
        shareItem2.q = str6;
        shareItem2.J = str3;
        shareItem2.p = str2;
        shareItem2.K = str6;
        shareItem2.f47982f = true;
        shareItem2.o = 6;
        shareItem2.E = 8;
        shareItem2.M = stateThreadType2;
        shareItem2.F = 3;
        shareItem2.G = getShareObjParam2(c2Var);
        if (parse != null) {
        }
        if (c2Var.z2()) {
        }
        shareItem2.g0 = z;
        if (z) {
        }
        shareItem2.T = OriginalThreadInfo.ShareInfo.generateShareInfo(c2Var);
        shareItem2.U = ShareItem.ForwardInfo.generateForwardInfo(c2Var);
        TbadkCoreApplication.getInst().setShareItem(shareItem2);
        Bundle bundle2 = new Bundle();
        bundle2.putInt("obj_param1", shareItem2.F);
        bundle2.putInt("obj_type", shareItem2.M);
        bundle2.putString("fid", shareItem2.J);
        bundle2.putString("tid", shareItem2.K);
        bundle2.putInt("obj_source", shareItem2.o);
        shareItem2.k(bundle2);
        ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig(TbadkCoreApplication.getInst().getCurrentActivity(), shareItem2, true);
        shareDialogConfig2.setIsAlaLive((c2Var.m1() != 49 || c2Var.m1() == 60 || c2Var.m1() == 69) ? true : true);
        shareDialogConfig2.setFrom(ShareDialogConfig.From.PersonPolymeric);
        f.b().k(shareDialogConfig2);
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
                c2 c2Var = new c2();
                c2Var.R2(optJSONObject);
                showShareDialog(c2Var);
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }
}

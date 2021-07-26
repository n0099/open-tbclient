package com.baidu.tieba.flutter.plugin.tiebaShare;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
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
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.flutter.plugin.tiebaShare.TiebaShareAuto;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.k;
import d.a.p0.s.q.b2;
import d.a.q0.e0.f;
import d.a.q0.q0.a.i.c;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes4.dex */
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

    private String getShareImageUrl(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, b2Var)) == null) {
            String str = null;
            if (b2Var == null) {
                return null;
            }
            if (b2Var.h1() != null && !TextUtils.isEmpty(b2Var.h1().cover)) {
                return b2Var.h1().cover;
            }
            if (b2Var.A0() == null) {
                return null;
            }
            ArrayList<MediaData> A0 = b2Var.A0();
            int size = A0.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                }
                MediaData mediaData = A0.get(i2);
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
            return (str != null || b2Var.m1() == null || TextUtils.isEmpty(b2Var.m1().thumbnail_url)) ? str : b2Var.m1().thumbnail_url;
        }
        return (String) invokeL.objValue;
    }

    private int getShareObjParam2(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, b2Var)) == null) {
            if (b2Var == null) {
                return 0;
            }
            if (b2Var.F1()) {
                return 10;
            }
            if (b2Var.I1()) {
                return 9;
            }
            if (b2Var.H1()) {
                return 8;
            }
            if (b2Var.G1()) {
                return 7;
            }
            if (b2Var.v1) {
                return 6;
            }
            int i2 = b2Var.Z;
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

    private int getStateThreadType(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, b2Var)) == null) {
            if (b2Var != null) {
                if (b2Var.f2()) {
                    return 4;
                }
                if (b2Var.h0() == 1) {
                    return 3;
                }
                if (b2Var.F1()) {
                    return 5;
                }
                if (b2Var.I1()) {
                    return 6;
                }
                if (b2Var.G1()) {
                    return 7;
                }
                if (b2Var.H1()) {
                    return 8;
                }
                if (!b2Var.v1 || b2Var.u1 == null) {
                    return b2Var.g2() ? 2 : 1;
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
        ShareItem shareItem = new ShareItem();
        shareItem.t = str;
        shareItem.q = str2;
        shareItem.r = str3;
        shareItem.l = true;
        TbadkCoreApplication.getInst().setShareItem(shareItem);
        Bundle bundle = new Bundle();
        bundle.putInt("obj_param1", shareItem.F);
        bundle.putInt("obj_type", shareItem.M);
        bundle.putString("fid", shareItem.J);
        bundle.putString("tid", shareItem.K);
        bundle.putInt("obj_source", shareItem.o);
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
    private void showShareDialog(b2 b2Var) {
        String o1;
        String str;
        boolean z;
        Uri parse;
        String h2;
        String format;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, b2Var) == null) || b2Var == null) {
            return;
        }
        String valueOf = String.valueOf(b2Var.R());
        String X = b2Var.X();
        OriginalForumInfo originalForumInfo = b2Var.F1;
        if (originalForumInfo != null) {
            valueOf = originalForumInfo.id;
            X = originalForumInfo.ori_fname;
        }
        String str2 = X;
        String str3 = valueOf;
        String title = b2Var.getTitle();
        if (TextUtils.isEmpty(title)) {
            title = b2Var.h();
        }
        String str4 = title;
        if (b2Var.r2()) {
            o1 = b2Var.J().oriUgcTid;
            str = "?share=9105&fr=dshare&dtype=" + b2Var.J().oriUgcType + "&dvid=" + b2Var.J().oriUgcVid + "&nid=" + b2Var.J().oriUgcNid;
        } else {
            o1 = b2Var.o1();
            str = "?share=9105&fr=sharewise";
        }
        String str5 = str;
        String str6 = o1;
        String str7 = "http://tieba.baidu.com/p/" + str6 + str5;
        boolean z2 = false;
        if (b2Var.h1() != null && b2Var.h1().user_info != null) {
            try {
                str7 = "https://tieba.baidu.com/ala/share?uname=" + URLEncoder.encode(b2Var.h1().user_info.user_name, "utf-8");
                z = false;
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            String shareImageUrl = getShareImageUrl(b2Var);
            parse = shareImageUrl != null ? null : Uri.parse(shareImageUrl);
            h2 = b2Var.h();
            String string = TbadkApplication.getInst().getResources().getString(R.string.share_content_tpl);
            String string2 = TbadkApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
            if (!b2Var.r2() && b2Var.H() != null) {
                format = (TextUtils.isEmpty(b2Var.getTitle()) || TextUtils.isEmpty(h2)) ? MessageFormat.format(string2, b2Var.H().getName_show(), TbadkApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix)) : h2;
            } else {
                format = MessageFormat.format(string, str4, h2);
            }
            String cutString = k.cutString(str4, 100);
            String cutString2 = k.cutString(format, 100);
            ShareItem shareItem = new ShareItem();
            shareItem.r = cutString;
            shareItem.s = cutString2;
            int stateThreadType = getStateThreadType(b2Var);
            if (!b2Var.r2()) {
                shareItem.R = -1L;
                shareItem.D = cutString2;
            } else {
                if (stateThreadType == 2 && b2Var.m1() != null) {
                    shareItem.R = b2Var.m1().play_count.intValue();
                } else if (stateThreadType == 1) {
                    shareItem.R = b2Var.x1();
                }
                shareItem.D = h2;
            }
            shareItem.t = str7;
            shareItem.q = str6;
            shareItem.J = str3;
            shareItem.p = str2;
            shareItem.K = str6;
            shareItem.f12892f = true;
            shareItem.o = 6;
            shareItem.E = 8;
            shareItem.M = stateThreadType;
            shareItem.F = 3;
            shareItem.G = getShareObjParam2(b2Var);
            if (parse != null) {
                shareItem.v = parse;
            }
            if (b2Var.r2()) {
                z = false;
            }
            shareItem.g0 = z;
            if (z) {
                shareItem.f0 = b2Var.V0();
            }
            shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(b2Var);
            shareItem.U = ShareItem.ForwardInfo.generateForwardInfo(b2Var);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.F);
            bundle.putInt("obj_type", shareItem.M);
            bundle.putString("fid", shareItem.J);
            bundle.putString("tid", shareItem.K);
            bundle.putInt("obj_source", shareItem.o);
            shareItem.k(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(TbadkCoreApplication.getInst().getCurrentActivity(), shareItem, true);
            shareDialogConfig.setIsAlaLive((b2Var.k1() != 49 || b2Var.k1() == 60 || b2Var.k1() == 69) ? true : true);
            shareDialogConfig.setFrom(ShareDialogConfig.From.PersonPolymeric);
            f.b().k(shareDialogConfig);
        }
        z = true;
        String shareImageUrl2 = getShareImageUrl(b2Var);
        if (shareImageUrl2 != null) {
        }
        h2 = b2Var.h();
        String string3 = TbadkApplication.getInst().getResources().getString(R.string.share_content_tpl);
        String string22 = TbadkApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
        if (!b2Var.r2()) {
        }
        format = MessageFormat.format(string3, str4, h2);
        String cutString3 = k.cutString(str4, 100);
        String cutString22 = k.cutString(format, 100);
        ShareItem shareItem2 = new ShareItem();
        shareItem2.r = cutString3;
        shareItem2.s = cutString22;
        int stateThreadType2 = getStateThreadType(b2Var);
        if (!b2Var.r2()) {
        }
        shareItem2.t = str7;
        shareItem2.q = str6;
        shareItem2.J = str3;
        shareItem2.p = str2;
        shareItem2.K = str6;
        shareItem2.f12892f = true;
        shareItem2.o = 6;
        shareItem2.E = 8;
        shareItem2.M = stateThreadType2;
        shareItem2.F = 3;
        shareItem2.G = getShareObjParam2(b2Var);
        if (parse != null) {
        }
        if (b2Var.r2()) {
        }
        shareItem2.g0 = z;
        if (z) {
        }
        shareItem2.T = OriginalThreadInfo.ShareInfo.generateShareInfo(b2Var);
        shareItem2.U = ShareItem.ForwardInfo.generateForwardInfo(b2Var);
        TbadkCoreApplication.getInst().setShareItem(shareItem2);
        Bundle bundle2 = new Bundle();
        bundle2.putInt("obj_param1", shareItem2.F);
        bundle2.putInt("obj_type", shareItem2.M);
        bundle2.putString("fid", shareItem2.J);
        bundle2.putString("tid", shareItem2.K);
        bundle2.putInt("obj_source", shareItem2.o);
        shareItem2.k(bundle2);
        ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig(TbadkCoreApplication.getInst().getCurrentActivity(), shareItem2, true);
        shareDialogConfig2.setIsAlaLive((b2Var.k1() != 49 || b2Var.k1() == 60 || b2Var.k1() == 69) ? true : true);
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
                b2 b2Var = new b2();
                b2Var.J2(optJSONObject);
                showShareDialog(b2Var);
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }
}

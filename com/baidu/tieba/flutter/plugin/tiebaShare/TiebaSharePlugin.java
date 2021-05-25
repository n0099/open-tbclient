package com.baidu.tieba.flutter.plugin.tiebaShare;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalForumInfo;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.flutter.plugin.tiebaShare.TiebaShareAuto;
import d.a.c.e.p.k;
import d.a.m0.r.q.a2;
import d.a.n0.d0.f;
import d.a.n0.n0.a.i.c;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class TiebaSharePlugin implements FlutterPlugin, TiebaShareAuto.HostTiebaShare {
    private String getShareImageUrl(a2 a2Var) {
        String str = null;
        if (a2Var == null) {
            return null;
        }
        if (a2Var.r1() != null && !TextUtils.isEmpty(a2Var.r1().cover)) {
            return a2Var.r1().cover;
        }
        if (a2Var.L0() == null) {
            return null;
        }
        ArrayList<MediaData> L0 = a2Var.L0();
        int size = L0.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            MediaData mediaData = L0.get(i2);
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
        return (str != null || a2Var.w1() == null || TextUtils.isEmpty(a2Var.w1().thumbnail_url)) ? str : a2Var.w1().thumbnail_url;
    }

    private int getShareObjParam2(a2 a2Var) {
        if (a2Var == null) {
            return 0;
        }
        if (a2Var.Q1()) {
            return 10;
        }
        if (a2Var.T1()) {
            return 9;
        }
        if (a2Var.S1()) {
            return 8;
        }
        if (a2Var.R1()) {
            return 7;
        }
        if (a2Var.t1) {
            return 6;
        }
        int i2 = a2Var.Z;
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

    private int getStateThreadType(a2 a2Var) {
        if (a2Var != null) {
            if (a2Var.q2()) {
                return 4;
            }
            if (a2Var.s0() == 1) {
                return 3;
            }
            if (a2Var.Q1()) {
                return 5;
            }
            if (a2Var.T1()) {
                return 6;
            }
            if (a2Var.R1()) {
                return 7;
            }
            if (a2Var.S1()) {
                return 8;
            }
            if (!a2Var.t1 || a2Var.s1 == null) {
                return a2Var.r2() ? 2 : 1;
            }
            return 9;
        }
        return 0;
    }

    private void showShareDetailsDialog(String str, String str2, String str3, boolean z) {
        if (str == null) {
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

    /* JADX WARN: Removed duplicated region for block: B:26:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void showShareDialog(a2 a2Var) {
        String y1;
        String str;
        boolean z;
        Uri parse;
        String C;
        String format;
        if (a2Var == null) {
            return;
        }
        String valueOf = String.valueOf(a2Var.c0());
        String i0 = a2Var.i0();
        OriginalForumInfo originalForumInfo = a2Var.D1;
        if (originalForumInfo != null) {
            valueOf = originalForumInfo.id;
            i0 = originalForumInfo.ori_fname;
        }
        String str2 = i0;
        String str3 = valueOf;
        String z1 = a2Var.z1();
        if (TextUtils.isEmpty(z1)) {
            z1 = a2Var.C();
        }
        String str4 = z1;
        if (a2Var.B2()) {
            y1 = a2Var.V().oriUgcTid;
            str = "?share=9105&fr=dshare&dtype=" + a2Var.V().oriUgcType + "&dvid=" + a2Var.V().oriUgcVid + "&nid=" + a2Var.V().oriUgcNid;
        } else {
            y1 = a2Var.y1();
            str = "?share=9105&fr=share";
        }
        String str5 = str;
        String str6 = y1;
        String str7 = "http://tieba.baidu.com/p/" + str6 + str5;
        boolean z2 = false;
        if (a2Var.r1() != null && a2Var.r1().user_info != null) {
            try {
                str7 = "https://tieba.baidu.com/ala/share?uname=" + URLEncoder.encode(a2Var.r1().user_info.user_name, "utf-8");
                z = false;
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            String shareImageUrl = getShareImageUrl(a2Var);
            parse = shareImageUrl != null ? null : Uri.parse(shareImageUrl);
            C = a2Var.C();
            String string = TbadkApplication.getInst().getResources().getString(R.string.share_content_tpl);
            String string2 = TbadkApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
            if (!a2Var.B2() && a2Var.T() != null) {
                format = (TextUtils.isEmpty(a2Var.z1()) || TextUtils.isEmpty(C)) ? MessageFormat.format(string2, a2Var.T().getName_show(), TbadkApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix)) : C;
            } else {
                format = MessageFormat.format(string, str4, C);
            }
            String cutString = k.cutString(str4, 100);
            String cutString2 = k.cutString(format, 100);
            ShareItem shareItem = new ShareItem();
            shareItem.r = cutString;
            shareItem.s = cutString2;
            int stateThreadType = getStateThreadType(a2Var);
            if (!a2Var.B2()) {
                shareItem.R = -1L;
                shareItem.D = cutString2;
            } else {
                if (stateThreadType == 2 && a2Var.w1() != null) {
                    shareItem.R = a2Var.w1().play_count.intValue();
                } else if (stateThreadType == 1) {
                    shareItem.R = a2Var.I1();
                }
                shareItem.D = C;
            }
            shareItem.t = str7;
            shareItem.q = str6;
            shareItem.J = str3;
            shareItem.p = str2;
            shareItem.K = str6;
            shareItem.f12600f = true;
            shareItem.o = 6;
            shareItem.E = 8;
            shareItem.M = stateThreadType;
            shareItem.F = 3;
            shareItem.G = getShareObjParam2(a2Var);
            if (parse != null) {
                shareItem.v = parse;
            }
            if (a2Var.B2()) {
                z = false;
            }
            shareItem.f0 = z;
            if (z) {
                shareItem.e0 = a2Var.f1();
            }
            shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(a2Var);
            shareItem.U = ShareItem.ForwardInfo.generateForwardInfo(a2Var);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.F);
            bundle.putInt("obj_type", shareItem.M);
            bundle.putString("fid", shareItem.J);
            bundle.putString("tid", shareItem.K);
            bundle.putInt("obj_source", shareItem.o);
            shareItem.k(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(TbadkCoreApplication.getInst().getCurrentActivity(), shareItem, true);
            shareDialogConfig.setIsAlaLive((a2Var.u1() != 49 || a2Var.u1() == 60 || a2Var.u1() == 69) ? true : true);
            shareDialogConfig.setFrom(ShareDialogConfig.From.PersonPolymeric);
            f.b().k(shareDialogConfig);
        }
        z = true;
        String shareImageUrl2 = getShareImageUrl(a2Var);
        if (shareImageUrl2 != null) {
        }
        C = a2Var.C();
        String string3 = TbadkApplication.getInst().getResources().getString(R.string.share_content_tpl);
        String string22 = TbadkApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
        if (!a2Var.B2()) {
        }
        format = MessageFormat.format(string3, str4, C);
        String cutString3 = k.cutString(str4, 100);
        String cutString22 = k.cutString(format, 100);
        ShareItem shareItem2 = new ShareItem();
        shareItem2.r = cutString3;
        shareItem2.s = cutString22;
        int stateThreadType2 = getStateThreadType(a2Var);
        if (!a2Var.B2()) {
        }
        shareItem2.t = str7;
        shareItem2.q = str6;
        shareItem2.J = str3;
        shareItem2.p = str2;
        shareItem2.K = str6;
        shareItem2.f12600f = true;
        shareItem2.o = 6;
        shareItem2.E = 8;
        shareItem2.M = stateThreadType2;
        shareItem2.F = 3;
        shareItem2.G = getShareObjParam2(a2Var);
        if (parse != null) {
        }
        if (a2Var.B2()) {
        }
        shareItem2.f0 = z;
        if (z) {
        }
        shareItem2.T = OriginalThreadInfo.ShareInfo.generateShareInfo(a2Var);
        shareItem2.U = ShareItem.ForwardInfo.generateForwardInfo(a2Var);
        TbadkCoreApplication.getInst().setShareItem(shareItem2);
        Bundle bundle2 = new Bundle();
        bundle2.putInt("obj_param1", shareItem2.F);
        bundle2.putInt("obj_type", shareItem2.M);
        bundle2.putString("fid", shareItem2.J);
        bundle2.putString("tid", shareItem2.K);
        bundle2.putInt("obj_source", shareItem2.o);
        shareItem2.k(bundle2);
        ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig(TbadkCoreApplication.getInst().getCurrentActivity(), shareItem2, true);
        shareDialogConfig2.setIsAlaLive((a2Var.u1() != 49 || a2Var.u1() == 60 || a2Var.u1() == 69) ? true : true);
        shareDialogConfig2.setFrom(ShareDialogConfig.From.PersonPolymeric);
        f.b().k(shareDialogConfig2);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        c.c(flutterPluginBinding.getBinaryMessenger(), this);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        c.c(flutterPluginBinding.getBinaryMessenger(), null);
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaShare.TiebaShareAuto.HostTiebaShare
    public void shareGameItemDetails(TiebaShareAuto.GameDetailsParam gameDetailsParam) {
        try {
            showShareDetailsDialog(gameDetailsParam.getUrl(), gameDetailsParam.getItemId(), gameDetailsParam.getItemName(), false);
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaShare.TiebaShareAuto.HostTiebaShare
    public void shareThread(TiebaShareAuto.ShareThreadParam shareThreadParam) {
        try {
            JSONObject optJSONObject = new JSONObject(shareThreadParam.getThreadInfo()).optJSONObject("item");
            a2 a2Var = new a2();
            a2Var.T2(optJSONObject);
            showShareDialog(a2Var);
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }
}

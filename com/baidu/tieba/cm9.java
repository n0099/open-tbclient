package com.baidu.tieba;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.controller.TransmitShareController;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.MessageFormat;
/* loaded from: classes5.dex */
public class cm9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbModel a;
        public final /* synthetic */ AbsPbActivity b;
        public final /* synthetic */ View c;

        public a(PbModel pbModel, AbsPbActivity absPbActivity, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbModel, absPbActivity, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbModel;
            this.b = absPbActivity;
            this.c = view2;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            PbModel pbModel;
            View view2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) && (pbModel = this.a) != null && pbModel.r1() != null && this.a.r1().x0() && !TbSingleton.getInstance().isNotchScreen(this.b) && !TbSingleton.getInstance().isCutoutScreen(this.b) && (view2 = this.c) != null) {
                view2.setSystemUiVisibility(4);
            }
        }
    }

    public static int a(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, threadData)) == null) {
            if (threadData == null) {
                return 0;
            }
            if (threadData.isVideoWorksInfo()) {
                return 11;
            }
            if (threadData.isBJHArticleThreadType()) {
                return 10;
            }
            if (threadData.isBJHVideoThreadType()) {
                return 9;
            }
            if (threadData.isBJHVideoDynamicThreadType()) {
                return 8;
            }
            if (threadData.isBJHNormalThreadType()) {
                return 7;
            }
            if (threadData.isShareThread) {
                return 6;
            }
            int i = threadData.threadType;
            if (i == 0) {
                return 1;
            }
            if (i == 40) {
                return 2;
            }
            if (i == 49) {
                return 3;
            }
            if (i == 54) {
                return 4;
            }
            return 5;
        }
        return invokeL.intValue;
    }

    public static int b(sd9 sd9Var) {
        InterceptResult invokeL;
        ThreadData O;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, sd9Var)) == null) {
            if (sd9Var != null && (O = sd9Var.O()) != null) {
                if (O.isRealGod()) {
                    return 4;
                }
                if (O.getIsLive() == 1) {
                    return 3;
                }
                if (O.isBJHArticleThreadType()) {
                    return 5;
                }
                if (O.isBJHVideoThreadType()) {
                    return 6;
                }
                if (O.isBJHNormalThreadType()) {
                    return 7;
                }
                if (O.isBJHVideoDynamicThreadType()) {
                    return 8;
                }
                if (!O.isRealVideoThread()) {
                    return 1;
                }
                return 2;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0251  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(AbsPbActivity absPbActivity, int i, int i2) {
        boolean z;
        ThreadData O;
        String K1;
        String str;
        String str2;
        Uri parse;
        String str3;
        ShareItem shareItem;
        char c;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(65538, null, absPbActivity, i, i2) == null) && absPbActivity != null && absPbActivity.J1() != null) {
            PbModel J1 = absPbActivity.J1();
            View rootView = absPbActivity.getRootView();
            if (!J1.d()) {
                return;
            }
            TiebaStatic.eventStat(absPbActivity, CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            sd9 r1 = J1.r1();
            String title = r1.O().getTitle();
            boolean U0 = J1.U0();
            if (r1.k() != null) {
                if (r1.k().isLike() == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2 && AddExperiencedModel.S(r1.l())) {
                    z = true;
                    O = J1.r1().O();
                    if (!O.isUgcThreadType()) {
                        K1 = O.getBaijiahaoData().oriUgcTid;
                        str = "?share=9105&fr=dshare&see_lz=" + (U0 ? 1 : 0) + "&dtype=" + O.getBaijiahaoData().oriUgcType + "&dvid=" + O.getBaijiahaoData().oriUgcVid + "&nid=" + O.getBaijiahaoData().oriUgcNid;
                    } else {
                        K1 = J1.K1();
                        str = "?share=9105&fr=sharewise&see_lz=" + (U0 ? 1 : 0);
                    }
                    String str4 = TbConfig.HTTPS_PB_PREFIX + K1 + (str + "&share_from=post");
                    String[] L = r1.L();
                    str2 = L[0];
                    if (!StringUtils.isNull(str2) && str2.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                        str2 = str2.substring(37);
                    }
                    if (str2 != null) {
                        parse = null;
                    } else {
                        parse = Uri.parse(str2);
                    }
                    str3 = L[1];
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (i == 1) {
                        ql9.w("c10399", r1.l(), r1.Q(), currentAccount);
                    }
                    String string = TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
                    if (!r1.j0() && O.getAuthor() != null) {
                        if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str3) || O.isBJHVideoDynamicThreadType() || O.isBJHVideoThreadType()) {
                            if (TextUtils.isEmpty(title)) {
                                c = 1;
                                title = L[1];
                            } else {
                                c = 1;
                            }
                            Object[] objArr = new Object[2];
                            objArr[0] = O.getAuthor().getName_show();
                            objArr[c] = TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix);
                            str3 = MessageFormat.format(string, objArr);
                        }
                    } else if (bi.isEmpty(str3)) {
                        str3 = title;
                    }
                    String cutString = bi.cutString(title, 100);
                    String cutString2 = bi.cutString(str3, 100);
                    shareItem = new ShareItem();
                    shareItem.title = cutString;
                    shareItem.content = cutString2;
                    if (!r1.j0()) {
                        shareItem.shareAbstract = cutString2;
                        shareItem.readCount = -1L;
                    } else if (r1.O() != null && r1.O().getThreadVideoInfo() != null && !r1.O().isUgcThreadType()) {
                        shareItem.readCount = r1.O().getThreadVideoInfo().play_count.intValue();
                    }
                    shareItem.linkUrl = str4;
                    shareItem.isFromSharePb = true;
                    shareItem.isShowAddExperienceTip = z;
                    shareItem.extData = J1.K1();
                    shareItem.objParam1 = 3;
                    shareItem.objSource = i2;
                    shareItem.fid = J1.getForumId();
                    shareItem.tid = J1.K1();
                    shareItem.obj_type = b(r1);
                    shareItem.uid = TbadkCoreApplication.getCurrentAccount();
                    if (parse != null) {
                        shareItem.imageUri = parse;
                    }
                    if (i2 == 2) {
                        shareItem.objParam1 = J1.V0();
                    }
                    if (r1.j0()) {
                        shareItem.canShareBySmartApp = false;
                    }
                    shareItem.originalThreadInfo = OriginalThreadInfo.ShareInfo.generateShareInfo(O);
                    if (r1 == null && r1.F() != null && r1.F().size() > 0) {
                        shareItem.forwardInfo = ShareItem.ForwardInfo.generateForwardInfo(O, 1, r1.F().get(0));
                    } else {
                        shareItem.forwardInfo = ShareItem.ForwardInfo.generateForwardInfo(O, 1, null);
                    }
                    TbadkCoreApplication.getInst().setShareItem(shareItem);
                    if (O != null) {
                        shareItem.smartAppShareImageUrl = O.getShareImageUrl();
                    }
                    shareItem.objParam2 = a(O);
                    Bundle bundle = new Bundle();
                    bundle.putInt("obj_param1", shareItem.objParam1);
                    bundle.putInt("obj_type", shareItem.obj_type);
                    bundle.putString("fid", shareItem.fid);
                    bundle.putString("tid", shareItem.tid);
                    bundle.putString("uid", shareItem.uid);
                    shareItem.setStats(bundle);
                    ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) absPbActivity, shareItem, true, true);
                    shareDialogConfig.setOnDismissListener(new a(J1, absPbActivity, rootView));
                    shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
                    TransmitShareController.getInstance().showShareDialog(shareDialogConfig);
                }
            }
            z = false;
            O = J1.r1().O();
            if (!O.isUgcThreadType()) {
            }
            String str42 = TbConfig.HTTPS_PB_PREFIX + K1 + (str + "&share_from=post");
            String[] L2 = r1.L();
            str2 = L2[0];
            if (!StringUtils.isNull(str2)) {
                str2 = str2.substring(37);
            }
            if (str2 != null) {
            }
            str3 = L2[1];
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            if (i == 1) {
            }
            String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
            if (!r1.j0()) {
            }
            if (bi.isEmpty(str3)) {
            }
            String cutString3 = bi.cutString(title, 100);
            String cutString22 = bi.cutString(str3, 100);
            shareItem = new ShareItem();
            shareItem.title = cutString3;
            shareItem.content = cutString22;
            if (!r1.j0()) {
            }
            shareItem.linkUrl = str42;
            shareItem.isFromSharePb = true;
            shareItem.isShowAddExperienceTip = z;
            shareItem.extData = J1.K1();
            shareItem.objParam1 = 3;
            shareItem.objSource = i2;
            shareItem.fid = J1.getForumId();
            shareItem.tid = J1.K1();
            shareItem.obj_type = b(r1);
            shareItem.uid = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
            }
            if (i2 == 2) {
            }
            if (r1.j0()) {
            }
            shareItem.originalThreadInfo = OriginalThreadInfo.ShareInfo.generateShareInfo(O);
            if (r1 == null) {
            }
            shareItem.forwardInfo = ShareItem.ForwardInfo.generateForwardInfo(O, 1, null);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            if (O != null) {
            }
            shareItem.objParam2 = a(O);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("obj_param1", shareItem.objParam1);
            bundle2.putInt("obj_type", shareItem.obj_type);
            bundle2.putString("fid", shareItem.fid);
            bundle2.putString("tid", shareItem.tid);
            bundle2.putString("uid", shareItem.uid);
            shareItem.setStats(bundle2);
            ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig((Context) absPbActivity, shareItem, true, true);
            shareDialogConfig2.setOnDismissListener(new a(J1, absPbActivity, rootView));
            shareDialogConfig2.setFrom(ShareDialogConfig.From.PB);
            TransmitShareController.getInstance().showShareDialog(shareDialogConfig2);
        }
    }
}

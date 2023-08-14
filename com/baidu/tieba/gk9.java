package com.baidu.tieba;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.OriginalForumInfo;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.controller.TransmitShareController;
import com.baidu.tieba.m45;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.view.Thread2GroupShareView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.text.MessageFormat;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public class gk9 {
    public static /* synthetic */ Interceptable $ic;
    public static final Set<String> a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbModel a;
        public final /* synthetic */ PbFragment b;
        public final /* synthetic */ Thread2GroupShareView c;
        public final /* synthetic */ long d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ ShareFromPBMsgData h;

        public a(PbModel pbModel, PbFragment pbFragment, Thread2GroupShareView thread2GroupShareView, long j, String str, String str2, String str3, ShareFromPBMsgData shareFromPBMsgData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbModel, pbFragment, thread2GroupShareView, Long.valueOf(j), str, str2, str3, shareFromPBMsgData};
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
            this.b = pbFragment;
            this.c = thread2GroupShareView;
            this.d = j;
            this.e = str;
            this.f = str2;
            this.g = str3;
            this.h = shareFromPBMsgData;
        }

        @Override // com.baidu.tieba.m45.e
        public void onClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                PbModel pbModel = this.a;
                if (pbModel != null && pbModel.s1() != null) {
                    StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 1).param("obj_param1", 3).param("fid", this.a.getForumId()).param("tid", this.a.M1()).param("obj_locate", 1);
                    if (gk9.f(this.a.s1()) != 0) {
                        param.param("obj_type", gk9.f(this.a.s1()));
                    }
                    TiebaStatic.log(param);
                }
                PbFragment pbFragment = this.b;
                if (pbFragment != null && pbFragment.getBaseFragmentActivity() != null) {
                    this.b.HidenSoftKeyPad((InputMethodManager) this.b.getBaseFragmentActivity().getSystemService("input_method"), this.c.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.b.getBaseFragmentActivity(), this.d, this.e, this.f, this.g, 0, this.c.getLeaveMsg(), this.h.toChatMessageContent())));
                }
                m45Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;
        public final /* synthetic */ Thread2GroupShareView b;

        public b(PbFragment pbFragment, Thread2GroupShareView thread2GroupShareView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, thread2GroupShareView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
            this.b = thread2GroupShareView;
        }

        @Override // com.baidu.tieba.m45.e
        public void onClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                this.a.HidenSoftKeyPad((InputMethodManager) this.a.getBaseFragmentActivity().getSystemService("input_method"), this.b.getChatMsgView());
                m45Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<PbFragment> a;
        public final PbModel b;

        public c(PbFragment pbFragment, PbModel pbModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, pbModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(pbFragment);
            this.b = pbModel;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            PbFragment pbFragment;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, dialogInterface) != null) || (pbFragment = this.a.get()) == null) {
                return;
            }
            ci9 M5 = pbFragment.M5();
            PbModel pbModel = this.b;
            if (pbModel != null && pbModel.s1() != null && this.b.s1().x0() && !TbSingleton.getInstance().isNotchScreen(pbFragment.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(pbFragment.getBaseFragmentActivity()) && M5 != null && M5.E1() != null) {
                M5.E1().setSystemUiVisibility(4);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947796948, "Lcom/baidu/tieba/gk9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947796948, "Lcom/baidu/tieba/gk9;");
                return;
            }
        }
        a = new HashSet();
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            a.add(str);
        }
    }

    public static boolean h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            return a.contains(str);
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x02a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ShareItem c(int i, int i2, PbModel pbModel) {
        InterceptResult invokeIIL;
        boolean z;
        ThreadData O;
        String M1;
        String str;
        String str2;
        Uri parse;
        String str3;
        String str4;
        String cutString;
        ShareItem shareItem;
        ThreadData threadData;
        OriginalForumInfo originalForumInfo;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65539, null, i, i2, pbModel)) == null) {
            td9 s1 = pbModel.s1();
            String title = s1.O().getTitle();
            boolean V0 = pbModel.V0();
            if (s1.k() != null) {
                if (s1.k().isLike() == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2 && AddExperiencedModel.S(s1.l())) {
                    z = true;
                    O = pbModel.s1().O();
                    O.setImShareFromPb(true);
                    if (pbModel != null && pbModel.s1() != null) {
                        O.setPbFirstShareData(pbModel.s1().h());
                    }
                    if (!O.isUgcThreadType()) {
                        M1 = O.getBaijiahaoData().oriUgcTid;
                        str = "?share=9105&fr=dshare&see_lz=" + (V0 ? 1 : 0) + "&dtype=" + O.getBaijiahaoData().oriUgcType + "&dvid=" + O.getBaijiahaoData().oriUgcVid + "&nid=" + O.getBaijiahaoData().oriUgcNid;
                    } else {
                        M1 = pbModel.M1();
                        str = "?share=9105&fr=sharewise&see_lz=" + (V0 ? 1 : 0);
                    }
                    String str5 = TbConfig.HTTPS_PB_PREFIX + M1 + (str + "&share_from=post");
                    String[] L = s1.L();
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
                        rl9.y("c10399", s1.l(), s1.Q(), currentAccount);
                    }
                    String string = TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
                    if (!s1.j0() && O.getAuthor() != null) {
                        if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str3)) {
                            if (TextUtils.isEmpty(title) || O.isBJHVideoDynamicThreadType() || O.isBJHVideoThreadType()) {
                                title = L[1];
                            }
                            str4 = MessageFormat.format(string, O.getAuthor().getName_show(), TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix));
                            String cutString2 = bi.cutString(title, 100);
                            cutString = bi.cutString(str4, 100);
                            if (cutString != null) {
                            }
                            String cutString3 = bi.cutString(cutString, 100);
                            shareItem = new ShareItem();
                            shareItem.title = cutString2;
                            shareItem.content = cutString3;
                            if (s1.j0()) {
                            }
                            shareItem.linkUrl = str5;
                            shareItem.isFromSharePb = true;
                            shareItem.isShowAddExperienceTip = z;
                            shareItem.extData = pbModel.M1();
                            if (i2 == 2) {
                            }
                            shareItem.objSource = i2;
                            shareItem.objParam2 = e(O);
                            shareItem.fid = pbModel.getForumId();
                            shareItem.fName = pbModel.R0();
                            shareItem.tid = pbModel.M1();
                            shareItem.obj_type = f(s1);
                            shareItem.uid = TbadkCoreApplication.getCurrentAccount();
                            if (parse != null) {
                            }
                            if (s1.j0()) {
                            }
                            shareItem.originalThreadInfo = OriginalThreadInfo.ShareInfo.generateShareInfo(O);
                            if (s1 == null) {
                            }
                            shareItem.forwardInfo = ShareItem.ForwardInfo.generateForwardInfo(O, 1, null);
                            threadData = shareItem.originalThreadInfo.threadData;
                            if (threadData != null) {
                            }
                            if (O != null) {
                            }
                            Bundle bundle = new Bundle();
                            bundle.putInt("obj_param1", shareItem.objParam1);
                            bundle.putInt("obj_type", shareItem.obj_type);
                            bundle.putString("fid", shareItem.fid);
                            bundle.putString("tid", shareItem.tid);
                            bundle.putString("uid", shareItem.uid);
                            shareItem.setStats(bundle);
                            int j = ff5.j(O);
                            String forum_name = O.getForum_name();
                            originalForumInfo = O.mOriginalForumInfo;
                            if (originalForumInfo != null) {
                            }
                            shareItem.shareH5CardOptimizeTitle = ff5.i(O, j);
                            shareItem.shareH5CardOptimizeContent = ff5.h(O, j, forum_name, shareItem.readCount, "", cutString3);
                            return shareItem;
                        }
                        str4 = str3;
                        String cutString22 = bi.cutString(title, 100);
                        cutString = bi.cutString(str4, 100);
                        if (cutString != null) {
                        }
                        String cutString32 = bi.cutString(cutString, 100);
                        shareItem = new ShareItem();
                        shareItem.title = cutString22;
                        shareItem.content = cutString32;
                        if (s1.j0()) {
                        }
                        shareItem.linkUrl = str5;
                        shareItem.isFromSharePb = true;
                        shareItem.isShowAddExperienceTip = z;
                        shareItem.extData = pbModel.M1();
                        if (i2 == 2) {
                        }
                        shareItem.objSource = i2;
                        shareItem.objParam2 = e(O);
                        shareItem.fid = pbModel.getForumId();
                        shareItem.fName = pbModel.R0();
                        shareItem.tid = pbModel.M1();
                        shareItem.obj_type = f(s1);
                        shareItem.uid = TbadkCoreApplication.getCurrentAccount();
                        if (parse != null) {
                        }
                        if (s1.j0()) {
                        }
                        shareItem.originalThreadInfo = OriginalThreadInfo.ShareInfo.generateShareInfo(O);
                        if (s1 == null) {
                        }
                        shareItem.forwardInfo = ShareItem.ForwardInfo.generateForwardInfo(O, 1, null);
                        threadData = shareItem.originalThreadInfo.threadData;
                        if (threadData != null) {
                        }
                        if (O != null) {
                        }
                        Bundle bundle2 = new Bundle();
                        bundle2.putInt("obj_param1", shareItem.objParam1);
                        bundle2.putInt("obj_type", shareItem.obj_type);
                        bundle2.putString("fid", shareItem.fid);
                        bundle2.putString("tid", shareItem.tid);
                        bundle2.putString("uid", shareItem.uid);
                        shareItem.setStats(bundle2);
                        int j2 = ff5.j(O);
                        String forum_name2 = O.getForum_name();
                        originalForumInfo = O.mOriginalForumInfo;
                        if (originalForumInfo != null) {
                        }
                        shareItem.shareH5CardOptimizeTitle = ff5.i(O, j2);
                        shareItem.shareH5CardOptimizeContent = ff5.h(O, j2, forum_name2, shareItem.readCount, "", cutString32);
                        return shareItem;
                    }
                    if (bi.isEmpty(str3)) {
                        str4 = title;
                        String cutString222 = bi.cutString(title, 100);
                        cutString = bi.cutString(str4, 100);
                        if (cutString != null) {
                            cutString = cutString.replaceAll("[\n\u0000]+", " ").replaceAll("[\n]+", " ");
                        }
                        String cutString322 = bi.cutString(cutString, 100);
                        shareItem = new ShareItem();
                        shareItem.title = cutString222;
                        shareItem.content = cutString322;
                        if (s1.j0()) {
                            shareItem.shareAbstract = cutString322;
                            shareItem.readCount = -1L;
                        } else {
                            shareItem.readCount = s1.P();
                        }
                        shareItem.linkUrl = str5;
                        shareItem.isFromSharePb = true;
                        shareItem.isShowAddExperienceTip = z;
                        shareItem.extData = pbModel.M1();
                        if (i2 == 2) {
                            shareItem.objParam1 = pbModel.W0();
                        }
                        shareItem.objSource = i2;
                        shareItem.objParam2 = e(O);
                        shareItem.fid = pbModel.getForumId();
                        shareItem.fName = pbModel.R0();
                        shareItem.tid = pbModel.M1();
                        shareItem.obj_type = f(s1);
                        shareItem.uid = TbadkCoreApplication.getCurrentAccount();
                        if (parse != null) {
                            shareItem.imageUri = parse;
                        }
                        if (s1.j0()) {
                            shareItem.canShareBySmartApp = false;
                        }
                        shareItem.originalThreadInfo = OriginalThreadInfo.ShareInfo.generateShareInfo(O);
                        if (s1 == null && s1.F() != null && s1.F().size() > 0) {
                            shareItem.forwardInfo = ShareItem.ForwardInfo.generateForwardInfo(O, 1, s1.F().get(0));
                        } else {
                            shareItem.forwardInfo = ShareItem.ForwardInfo.generateForwardInfo(O, 1, null);
                        }
                        threadData = shareItem.originalThreadInfo.threadData;
                        if (threadData != null && threadData.getForumData() == null && s1 != null && s1.k() != null) {
                            s35 s35Var = new s35();
                            s35Var.m(s1.k().getName());
                            s35Var.a = s1.k().getId();
                            s35Var.c = s1.k().getImage_url();
                            shareItem.originalThreadInfo.threadData.setForumData(s35Var);
                        }
                        if (O != null) {
                            shareItem.smartAppShareImageUrl = O.getShareImageUrl();
                        }
                        Bundle bundle22 = new Bundle();
                        bundle22.putInt("obj_param1", shareItem.objParam1);
                        bundle22.putInt("obj_type", shareItem.obj_type);
                        bundle22.putString("fid", shareItem.fid);
                        bundle22.putString("tid", shareItem.tid);
                        bundle22.putString("uid", shareItem.uid);
                        shareItem.setStats(bundle22);
                        int j22 = ff5.j(O);
                        String forum_name22 = O.getForum_name();
                        originalForumInfo = O.mOriginalForumInfo;
                        if (originalForumInfo != null) {
                            forum_name22 = originalForumInfo.ori_fname;
                        }
                        shareItem.shareH5CardOptimizeTitle = ff5.i(O, j22);
                        shareItem.shareH5CardOptimizeContent = ff5.h(O, j22, forum_name22, shareItem.readCount, "", cutString322);
                        return shareItem;
                    }
                    str4 = str3;
                    String cutString2222 = bi.cutString(title, 100);
                    cutString = bi.cutString(str4, 100);
                    if (cutString != null) {
                    }
                    String cutString3222 = bi.cutString(cutString, 100);
                    shareItem = new ShareItem();
                    shareItem.title = cutString2222;
                    shareItem.content = cutString3222;
                    if (s1.j0()) {
                    }
                    shareItem.linkUrl = str5;
                    shareItem.isFromSharePb = true;
                    shareItem.isShowAddExperienceTip = z;
                    shareItem.extData = pbModel.M1();
                    if (i2 == 2) {
                    }
                    shareItem.objSource = i2;
                    shareItem.objParam2 = e(O);
                    shareItem.fid = pbModel.getForumId();
                    shareItem.fName = pbModel.R0();
                    shareItem.tid = pbModel.M1();
                    shareItem.obj_type = f(s1);
                    shareItem.uid = TbadkCoreApplication.getCurrentAccount();
                    if (parse != null) {
                    }
                    if (s1.j0()) {
                    }
                    shareItem.originalThreadInfo = OriginalThreadInfo.ShareInfo.generateShareInfo(O);
                    if (s1 == null) {
                    }
                    shareItem.forwardInfo = ShareItem.ForwardInfo.generateForwardInfo(O, 1, null);
                    threadData = shareItem.originalThreadInfo.threadData;
                    if (threadData != null) {
                        s35 s35Var2 = new s35();
                        s35Var2.m(s1.k().getName());
                        s35Var2.a = s1.k().getId();
                        s35Var2.c = s1.k().getImage_url();
                        shareItem.originalThreadInfo.threadData.setForumData(s35Var2);
                    }
                    if (O != null) {
                    }
                    Bundle bundle222 = new Bundle();
                    bundle222.putInt("obj_param1", shareItem.objParam1);
                    bundle222.putInt("obj_type", shareItem.obj_type);
                    bundle222.putString("fid", shareItem.fid);
                    bundle222.putString("tid", shareItem.tid);
                    bundle222.putString("uid", shareItem.uid);
                    shareItem.setStats(bundle222);
                    int j222 = ff5.j(O);
                    String forum_name222 = O.getForum_name();
                    originalForumInfo = O.mOriginalForumInfo;
                    if (originalForumInfo != null) {
                    }
                    shareItem.shareH5CardOptimizeTitle = ff5.i(O, j222);
                    shareItem.shareH5CardOptimizeContent = ff5.h(O, j222, forum_name222, shareItem.readCount, "", cutString3222);
                    return shareItem;
                }
            }
            z = false;
            O = pbModel.s1().O();
            O.setImShareFromPb(true);
            if (pbModel != null) {
                O.setPbFirstShareData(pbModel.s1().h());
            }
            if (!O.isUgcThreadType()) {
            }
            String str52 = TbConfig.HTTPS_PB_PREFIX + M1 + (str + "&share_from=post");
            String[] L2 = s1.L();
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
            if (!s1.j0()) {
            }
            if (bi.isEmpty(str3)) {
            }
            str4 = str3;
            String cutString22222 = bi.cutString(title, 100);
            cutString = bi.cutString(str4, 100);
            if (cutString != null) {
            }
            String cutString32222 = bi.cutString(cutString, 100);
            shareItem = new ShareItem();
            shareItem.title = cutString22222;
            shareItem.content = cutString32222;
            if (s1.j0()) {
            }
            shareItem.linkUrl = str52;
            shareItem.isFromSharePb = true;
            shareItem.isShowAddExperienceTip = z;
            shareItem.extData = pbModel.M1();
            if (i2 == 2) {
            }
            shareItem.objSource = i2;
            shareItem.objParam2 = e(O);
            shareItem.fid = pbModel.getForumId();
            shareItem.fName = pbModel.R0();
            shareItem.tid = pbModel.M1();
            shareItem.obj_type = f(s1);
            shareItem.uid = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
            }
            if (s1.j0()) {
            }
            shareItem.originalThreadInfo = OriginalThreadInfo.ShareInfo.generateShareInfo(O);
            if (s1 == null) {
            }
            shareItem.forwardInfo = ShareItem.ForwardInfo.generateForwardInfo(O, 1, null);
            threadData = shareItem.originalThreadInfo.threadData;
            if (threadData != null) {
            }
            if (O != null) {
            }
            Bundle bundle2222 = new Bundle();
            bundle2222.putInt("obj_param1", shareItem.objParam1);
            bundle2222.putInt("obj_type", shareItem.obj_type);
            bundle2222.putString("fid", shareItem.fid);
            bundle2222.putString("tid", shareItem.tid);
            bundle2222.putString("uid", shareItem.uid);
            shareItem.setStats(bundle2222);
            int j2222 = ff5.j(O);
            String forum_name2222 = O.getForum_name();
            originalForumInfo = O.mOriginalForumInfo;
            if (originalForumInfo != null) {
            }
            shareItem.shareH5CardOptimizeTitle = ff5.i(O, j2222);
            shareItem.shareH5CardOptimizeContent = ff5.h(O, j2222, forum_name2222, shareItem.readCount, "", cutString32222);
            return shareItem;
        }
        return (ShareItem) invokeIIL.objValue;
    }

    public static ShareFromPBMsgData d(PbFragment pbFragment) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, pbFragment)) == null) {
            if (pbFragment != null && pbFragment.R() != null && pbFragment.M5() != null) {
                PbModel R = pbFragment.R();
                ci9 M5 = pbFragment.M5();
                ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
                String[] L = R.s1().L();
                rba a1 = M5.a1();
                String str2 = "";
                if (a1 == null) {
                    str = "";
                } else {
                    str = a1.S();
                    String m = a1.m();
                    if (!bi.isEmpty(m)) {
                        L[1] = m;
                    }
                }
                String firstPostId = R.s1().O().getFirstPostId();
                if (firstPostId == null || !firstPostId.equals(str)) {
                    str2 = str;
                }
                shareFromPBMsgData.setContent(L[1]);
                shareFromPBMsgData.setImageUrl(L[0]);
                shareFromPBMsgData.setForumName(R.s1().k().getName());
                shareFromPBMsgData.setPostId(str2);
                shareFromPBMsgData.setThreadId(R.s1().O().getId());
                shareFromPBMsgData.setTitle(R.s1().O().getTitle());
                return shareFromPBMsgData;
            }
            return null;
        }
        return (ShareFromPBMsgData) invokeL.objValue;
    }

    public static int e(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, threadData)) == null) {
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

    public static int f(td9 td9Var) {
        InterceptResult invokeL;
        ThreadData O;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, td9Var)) == null) {
            if (td9Var != null && (O = td9Var.O()) != null) {
                if (O.isRealGod()) {
                    return 4;
                }
                if (O.getIsLive() == 1) {
                    return 3;
                }
                if (O.isRealVideoThread()) {
                    return 2;
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
                if (!O.isBJHVideoDynamicThreadType()) {
                    return 1;
                }
                return 8;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static void g(PbFragment pbFragment, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, pbFragment, intent) == null) {
            i(pbFragment, intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra("name_show"), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
        }
    }

    public static void i(PbFragment pbFragment, long j, String str, String str2, String str3) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65545, null, new Object[]{pbFragment, Long.valueOf(j), str, str2, str3}) != null) || pbFragment == null) {
            return;
        }
        PbModel R = pbFragment.R();
        ShareFromPBMsgData d = d(pbFragment);
        if (R != null && R.s1() != null && R.s1().O() != null) {
            m45 m45Var = new m45(pbFragment.getBaseFragmentActivity());
            Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
            thread2GroupShareView.setData(d);
            m45Var.setContentViewSize(1);
            m45Var.setContentView(thread2GroupShareView);
            m45Var.setPositiveButton(R.string.obfuscated_res_0x7f0f137a, new a(R, pbFragment, thread2GroupShareView, j, str, str2, str3, d));
            m45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03ce, new b(pbFragment, thread2GroupShareView));
            m45Var.setCanceledOnTouchOutside(true);
            m45Var.create(pbFragment.getPageContext()).show();
            if (!bi.isEmpty(d.getImageUrl())) {
                String imageUrl = d.getImageUrl();
                if (R.s1().r() == 1) {
                    z = true;
                } else {
                    z = false;
                }
                thread2GroupShareView.c(imageUrl, z);
            }
        }
    }

    public static void j(PbFragment pbFragment, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(65546, null, pbFragment, i, i2) == null) && pbFragment != null && pbFragment.R() != null && pbFragment.M5() != null) {
            PbModel R = pbFragment.R();
            if (!R.d()) {
                return;
            }
            TiebaStatic.eventStat(pbFragment.getContext(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            ShareItem c2 = c(i, i2, R);
            TbadkCoreApplication.getInst().setShareItem(c2);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(pbFragment.getContext(), c2, true, true);
            shareDialogConfig.setOnDismissListener(new c(pbFragment, R));
            Bundle bundle = new Bundle();
            bundle.putInt("source", 3);
            bundle.putInt("obj_param1", 3);
            shareDialogConfig.shareItem.setStats(bundle);
            shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
            shareDialogConfig.setTopicId(R.getTopicId());
            if (R.s1().O().threadType == 72) {
                shareDialogConfig.setIsHideShareCopyLink(true);
            }
            if (R.s1() != null) {
                shareDialogConfig.setShowNovelMask(R.s1().p0());
            }
            TransmitShareController.getInstance().showShareDialog(shareDialogConfig);
        }
    }
}

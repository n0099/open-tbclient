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
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.view.Thread2GroupShareView;
import com.baidu.tieba.y45;
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
/* loaded from: classes5.dex */
public class cq9 {
    public static /* synthetic */ Interceptable $ic;
    public static final Set<String> a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements y45.e {
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

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                PbModel pbModel = this.a;
                if (pbModel != null && pbModel.r1() != null) {
                    StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 1).param("obj_param1", 3).param("fid", this.a.getForumId()).param("tid", this.a.L1()).param("obj_locate", 1);
                    if (cq9.e(this.a.r1()) != 0) {
                        param.param("obj_type", cq9.e(this.a.r1()));
                    }
                    TiebaStatic.log(param);
                }
                PbFragment pbFragment = this.b;
                if (pbFragment != null && pbFragment.getBaseFragmentActivity() != null) {
                    this.b.HidenSoftKeyPad((InputMethodManager) this.b.getBaseFragmentActivity().getSystemService("input_method"), this.c.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.b.getBaseFragmentActivity(), this.d, this.e, this.f, this.g, 0, this.c.getLeaveMsg(), this.h.toChatMessageContent())));
                }
                y45Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements y45.e {
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

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                this.a.HidenSoftKeyPad((InputMethodManager) this.a.getBaseFragmentActivity().getSystemService("input_method"), this.b.getChatMsgView());
                y45Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
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
            xn9 H6 = pbFragment.H6();
            PbModel pbModel = this.b;
            if (pbModel != null && pbModel.r1() != null && this.b.r1().x0() && !TbSingleton.getInstance().isNotchScreen(pbFragment.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(pbFragment.getBaseFragmentActivity()) && H6 != null && H6.E1() != null) {
                H6.E1().setSystemUiVisibility(4);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947683550, "Lcom/baidu/tieba/cq9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947683550, "Lcom/baidu/tieba/cq9;");
                return;
            }
        }
        a = new HashSet();
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            a.add(str);
        }
    }

    public static boolean g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
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
    public static ShareItem b(int i, int i2, PbModel pbModel) {
        InterceptResult invokeIIL;
        boolean z;
        ThreadData O;
        String L1;
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
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65538, null, i, i2, pbModel)) == null) {
            aj9 r1 = pbModel.r1();
            String title = r1.O().getTitle();
            boolean U0 = pbModel.U0();
            if (r1.k() != null) {
                if (r1.k().isLike() == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2 && AddExperiencedModel.R(r1.l())) {
                    z = true;
                    O = pbModel.r1().O();
                    O.setImShareFromPb(true);
                    if (pbModel != null && pbModel.r1() != null) {
                        O.setPbFirstShareData(pbModel.r1().h());
                    }
                    if (!O.isUgcThreadType()) {
                        L1 = O.getBaijiahaoData().oriUgcTid;
                        str = "?share=9105&fr=dshare&see_lz=" + (U0 ? 1 : 0) + "&dtype=" + O.getBaijiahaoData().oriUgcType + "&dvid=" + O.getBaijiahaoData().oriUgcVid + "&nid=" + O.getBaijiahaoData().oriUgcNid;
                    } else {
                        L1 = pbModel.L1();
                        str = "?share=9105&fr=sharewise&see_lz=" + (U0 ? 1 : 0);
                    }
                    String str5 = TbConfig.HTTPS_PB_PREFIX + L1 + (str + "&share_from=post");
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
                        nr9.E("c10399", r1.l(), r1.Q(), currentAccount);
                    }
                    String string = TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
                    if (!r1.j0() && O.getAuthor() != null) {
                        if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str3)) {
                            if (TextUtils.isEmpty(title) || O.isBJHVideoDynamicThreadType() || O.isBJHVideoThreadType()) {
                                title = L[1];
                            }
                            str4 = MessageFormat.format(string, O.getAuthor().getName_show(), TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix));
                            String cutString2 = ei.cutString(title, 100);
                            cutString = ei.cutString(str4, 100);
                            if (cutString != null) {
                            }
                            String cutString3 = ei.cutString(cutString, 100);
                            shareItem = new ShareItem();
                            shareItem.title = cutString2;
                            shareItem.content = cutString3;
                            if (r1.j0()) {
                            }
                            shareItem.linkUrl = str5;
                            shareItem.isFromSharePb = true;
                            shareItem.isShowAddExperienceTip = z;
                            shareItem.extData = pbModel.L1();
                            if (i2 == 2) {
                            }
                            shareItem.objSource = i2;
                            shareItem.objParam2 = d(O);
                            shareItem.fid = pbModel.getForumId();
                            shareItem.fName = pbModel.Q0();
                            shareItem.tid = pbModel.L1();
                            shareItem.obj_type = e(r1);
                            shareItem.uid = TbadkCoreApplication.getCurrentAccount();
                            if (parse != null) {
                            }
                            if (r1.j0()) {
                            }
                            shareItem.originalThreadInfo = OriginalThreadInfo.ShareInfo.generateShareInfo(O);
                            if (r1 == null) {
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
                            int j = wf5.j(O);
                            String forum_name = O.getForum_name();
                            originalForumInfo = O.mOriginalForumInfo;
                            if (originalForumInfo != null) {
                            }
                            shareItem.shareH5CardOptimizeTitle = wf5.i(O, j);
                            shareItem.shareH5CardOptimizeContent = wf5.h(O, j, forum_name, shareItem.readCount, "", cutString3);
                            return shareItem;
                        }
                        str4 = str3;
                        String cutString22 = ei.cutString(title, 100);
                        cutString = ei.cutString(str4, 100);
                        if (cutString != null) {
                        }
                        String cutString32 = ei.cutString(cutString, 100);
                        shareItem = new ShareItem();
                        shareItem.title = cutString22;
                        shareItem.content = cutString32;
                        if (r1.j0()) {
                        }
                        shareItem.linkUrl = str5;
                        shareItem.isFromSharePb = true;
                        shareItem.isShowAddExperienceTip = z;
                        shareItem.extData = pbModel.L1();
                        if (i2 == 2) {
                        }
                        shareItem.objSource = i2;
                        shareItem.objParam2 = d(O);
                        shareItem.fid = pbModel.getForumId();
                        shareItem.fName = pbModel.Q0();
                        shareItem.tid = pbModel.L1();
                        shareItem.obj_type = e(r1);
                        shareItem.uid = TbadkCoreApplication.getCurrentAccount();
                        if (parse != null) {
                        }
                        if (r1.j0()) {
                        }
                        shareItem.originalThreadInfo = OriginalThreadInfo.ShareInfo.generateShareInfo(O);
                        if (r1 == null) {
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
                        int j2 = wf5.j(O);
                        String forum_name2 = O.getForum_name();
                        originalForumInfo = O.mOriginalForumInfo;
                        if (originalForumInfo != null) {
                        }
                        shareItem.shareH5CardOptimizeTitle = wf5.i(O, j2);
                        shareItem.shareH5CardOptimizeContent = wf5.h(O, j2, forum_name2, shareItem.readCount, "", cutString32);
                        return shareItem;
                    }
                    if (ei.isEmpty(str3)) {
                        str4 = title;
                        String cutString222 = ei.cutString(title, 100);
                        cutString = ei.cutString(str4, 100);
                        if (cutString != null) {
                            cutString = cutString.replaceAll("[\n\u0000]+", " ").replaceAll("[\n]+", " ");
                        }
                        String cutString322 = ei.cutString(cutString, 100);
                        shareItem = new ShareItem();
                        shareItem.title = cutString222;
                        shareItem.content = cutString322;
                        if (r1.j0()) {
                            shareItem.shareAbstract = cutString322;
                            shareItem.readCount = -1L;
                        } else {
                            shareItem.readCount = r1.P();
                        }
                        shareItem.linkUrl = str5;
                        shareItem.isFromSharePb = true;
                        shareItem.isShowAddExperienceTip = z;
                        shareItem.extData = pbModel.L1();
                        if (i2 == 2) {
                            shareItem.objParam1 = pbModel.V0();
                        }
                        shareItem.objSource = i2;
                        shareItem.objParam2 = d(O);
                        shareItem.fid = pbModel.getForumId();
                        shareItem.fName = pbModel.Q0();
                        shareItem.tid = pbModel.L1();
                        shareItem.obj_type = e(r1);
                        shareItem.uid = TbadkCoreApplication.getCurrentAccount();
                        if (parse != null) {
                            shareItem.imageUri = parse;
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
                        threadData = shareItem.originalThreadInfo.threadData;
                        if (threadData != null && threadData.getForumData() == null && r1 != null && r1.k() != null) {
                            d45 d45Var = new d45();
                            d45Var.n(r1.k().getName());
                            d45Var.a = r1.k().getId();
                            d45Var.c = r1.k().getImage_url();
                            shareItem.originalThreadInfo.threadData.setForumData(d45Var);
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
                        int j22 = wf5.j(O);
                        String forum_name22 = O.getForum_name();
                        originalForumInfo = O.mOriginalForumInfo;
                        if (originalForumInfo != null) {
                            forum_name22 = originalForumInfo.ori_fname;
                        }
                        shareItem.shareH5CardOptimizeTitle = wf5.i(O, j22);
                        shareItem.shareH5CardOptimizeContent = wf5.h(O, j22, forum_name22, shareItem.readCount, "", cutString322);
                        return shareItem;
                    }
                    str4 = str3;
                    String cutString2222 = ei.cutString(title, 100);
                    cutString = ei.cutString(str4, 100);
                    if (cutString != null) {
                    }
                    String cutString3222 = ei.cutString(cutString, 100);
                    shareItem = new ShareItem();
                    shareItem.title = cutString2222;
                    shareItem.content = cutString3222;
                    if (r1.j0()) {
                    }
                    shareItem.linkUrl = str5;
                    shareItem.isFromSharePb = true;
                    shareItem.isShowAddExperienceTip = z;
                    shareItem.extData = pbModel.L1();
                    if (i2 == 2) {
                    }
                    shareItem.objSource = i2;
                    shareItem.objParam2 = d(O);
                    shareItem.fid = pbModel.getForumId();
                    shareItem.fName = pbModel.Q0();
                    shareItem.tid = pbModel.L1();
                    shareItem.obj_type = e(r1);
                    shareItem.uid = TbadkCoreApplication.getCurrentAccount();
                    if (parse != null) {
                    }
                    if (r1.j0()) {
                    }
                    shareItem.originalThreadInfo = OriginalThreadInfo.ShareInfo.generateShareInfo(O);
                    if (r1 == null) {
                    }
                    shareItem.forwardInfo = ShareItem.ForwardInfo.generateForwardInfo(O, 1, null);
                    threadData = shareItem.originalThreadInfo.threadData;
                    if (threadData != null) {
                        d45 d45Var2 = new d45();
                        d45Var2.n(r1.k().getName());
                        d45Var2.a = r1.k().getId();
                        d45Var2.c = r1.k().getImage_url();
                        shareItem.originalThreadInfo.threadData.setForumData(d45Var2);
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
                    int j222 = wf5.j(O);
                    String forum_name222 = O.getForum_name();
                    originalForumInfo = O.mOriginalForumInfo;
                    if (originalForumInfo != null) {
                    }
                    shareItem.shareH5CardOptimizeTitle = wf5.i(O, j222);
                    shareItem.shareH5CardOptimizeContent = wf5.h(O, j222, forum_name222, shareItem.readCount, "", cutString3222);
                    return shareItem;
                }
            }
            z = false;
            O = pbModel.r1().O();
            O.setImShareFromPb(true);
            if (pbModel != null) {
                O.setPbFirstShareData(pbModel.r1().h());
            }
            if (!O.isUgcThreadType()) {
            }
            String str52 = TbConfig.HTTPS_PB_PREFIX + L1 + (str + "&share_from=post");
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
            if (ei.isEmpty(str3)) {
            }
            str4 = str3;
            String cutString22222 = ei.cutString(title, 100);
            cutString = ei.cutString(str4, 100);
            if (cutString != null) {
            }
            String cutString32222 = ei.cutString(cutString, 100);
            shareItem = new ShareItem();
            shareItem.title = cutString22222;
            shareItem.content = cutString32222;
            if (r1.j0()) {
            }
            shareItem.linkUrl = str52;
            shareItem.isFromSharePb = true;
            shareItem.isShowAddExperienceTip = z;
            shareItem.extData = pbModel.L1();
            if (i2 == 2) {
            }
            shareItem.objSource = i2;
            shareItem.objParam2 = d(O);
            shareItem.fid = pbModel.getForumId();
            shareItem.fName = pbModel.Q0();
            shareItem.tid = pbModel.L1();
            shareItem.obj_type = e(r1);
            shareItem.uid = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
            }
            if (r1.j0()) {
            }
            shareItem.originalThreadInfo = OriginalThreadInfo.ShareInfo.generateShareInfo(O);
            if (r1 == null) {
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
            int j2222 = wf5.j(O);
            String forum_name2222 = O.getForum_name();
            originalForumInfo = O.mOriginalForumInfo;
            if (originalForumInfo != null) {
            }
            shareItem.shareH5CardOptimizeTitle = wf5.i(O, j2222);
            shareItem.shareH5CardOptimizeContent = wf5.h(O, j2222, forum_name2222, shareItem.readCount, "", cutString32222);
            return shareItem;
        }
        return (ShareItem) invokeIIL.objValue;
    }

    public static ShareFromPBMsgData c(PbFragment pbFragment) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, pbFragment)) == null) {
            if (pbFragment != null && pbFragment.X() != null && pbFragment.H6() != null) {
                PbModel X = pbFragment.X();
                xn9 H6 = pbFragment.H6();
                ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
                String[] L = X.r1().L();
                tha a1 = H6.a1();
                String str2 = "";
                if (a1 == null) {
                    str = "";
                } else {
                    str = a1.U();
                    String m = a1.m();
                    if (!ei.isEmpty(m)) {
                        L[1] = m;
                    }
                }
                String firstPostId = X.r1().O().getFirstPostId();
                if (firstPostId == null || !firstPostId.equals(str)) {
                    str2 = str;
                }
                shareFromPBMsgData.setContent(L[1]);
                shareFromPBMsgData.setImageUrl(L[0]);
                shareFromPBMsgData.setForumName(X.r1().k().getName());
                shareFromPBMsgData.setPostId(str2);
                shareFromPBMsgData.setThreadId(X.r1().O().getId());
                shareFromPBMsgData.setTitle(X.r1().O().getTitle());
                return shareFromPBMsgData;
            }
            return null;
        }
        return (ShareFromPBMsgData) invokeL.objValue;
    }

    public static int d(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, threadData)) == null) {
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

    public static int e(aj9 aj9Var) {
        InterceptResult invokeL;
        ThreadData O;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, aj9Var)) == null) {
            if (aj9Var != null && (O = aj9Var.O()) != null) {
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

    public static void f(PbFragment pbFragment, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, pbFragment, intent) == null) {
            h(pbFragment, intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra("name_show"), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
        }
    }

    public static void h(PbFragment pbFragment, long j, String str, String str2, String str3) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65544, null, new Object[]{pbFragment, Long.valueOf(j), str, str2, str3}) != null) || pbFragment == null) {
            return;
        }
        PbModel X = pbFragment.X();
        ShareFromPBMsgData c2 = c(pbFragment);
        if (X != null && X.r1() != null && X.r1().O() != null) {
            y45 y45Var = new y45(pbFragment.getBaseFragmentActivity());
            Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
            thread2GroupShareView.setData(c2);
            y45Var.setContentViewSize(1);
            y45Var.setContentView(thread2GroupShareView);
            y45Var.setPositiveButton(R.string.obfuscated_res_0x7f0f13a0, new a(X, pbFragment, thread2GroupShareView, j, str, str2, str3, c2));
            y45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03d0, new b(pbFragment, thread2GroupShareView));
            y45Var.setCanceledOnTouchOutside(true);
            y45Var.create(pbFragment.getPageContext()).show();
            if (!ei.isEmpty(c2.getImageUrl())) {
                String imageUrl = c2.getImageUrl();
                if (X.r1().r() == 1) {
                    z = true;
                } else {
                    z = false;
                }
                thread2GroupShareView.c(imageUrl, z);
            }
        }
    }

    public static void i(PbFragment pbFragment, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(65545, null, pbFragment, i, i2) == null) && pbFragment != null && pbFragment.X() != null && pbFragment.H6() != null) {
            PbModel X = pbFragment.X();
            if (!X.c()) {
                return;
            }
            TiebaStatic.eventStat(pbFragment.getContext(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            ShareItem b2 = b(i, i2, X);
            TbadkCoreApplication.getInst().setShareItem(b2);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(pbFragment.getContext(), b2, true, true);
            shareDialogConfig.setOnDismissListener(new c(pbFragment, X));
            Bundle bundle = new Bundle();
            bundle.putInt("source", 3);
            bundle.putInt("obj_param1", 3);
            shareDialogConfig.shareItem.setStats(bundle);
            shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
            shareDialogConfig.setTopicId(X.getTopicId());
            if (X.r1().O().threadType == 72) {
                shareDialogConfig.setIsHideShareCopyLink(true);
            }
            if (X.r1() != null) {
                shareDialogConfig.setShowNovelMask(X.r1().p0());
            }
            TransmitShareController.getInstance().showShareDialog(shareDialogConfig);
        }
    }
}

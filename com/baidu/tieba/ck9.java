package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbMemeImageView;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.List;
import tbclient.ForumToolPerm;
/* loaded from: classes5.dex */
public class ck9 {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] a;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean A(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) ? i == 1 || i == 2 || i == 3 || i == 4 : invokeI.booleanValue;
    }

    public static boolean B(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) ? i == 2 || i == 1 : invokeI.booleanValue;
    }

    public static int q(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65565, null, i)) == null) {
            if (i != 1) {
                if (i != 2) {
                    return i != 3 ? 1 : 7;
                }
                return 6;
            }
            return 5;
        }
        return invokeI.intValue;
    }

    /* loaded from: classes5.dex */
    public class a extends gs5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ PbModel b;

        public a(int i, PbModel pbModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), pbModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.b = pbModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gs5
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (ShareSwitch.isOn()) {
                    i = 1;
                } else {
                    i = 6;
                }
                return mm9.b(this.a, i, this.b);
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements lr5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ int b;

        public b(Context context, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lr5
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                Bundle bundle = new Bundle();
                bundle.putInt("source", 2);
                shareItem.setStats(bundle);
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.a, this.b, shareItem, false));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ PbFragment b;
        public final /* synthetic */ String c;

        public c(int i, PbFragment pbFragment, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), pbFragment, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.b = pbFragment;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                il9.j(this.a, this.b.getListView(), this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;
        public final /* synthetic */ int b;

        public d(PbFragment pbFragment, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            ck9.G(this.a, this.b);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947677784, "Lcom/baidu/tieba/ck9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947677784, "Lcom/baidu/tieba/ck9;");
                return;
            }
        }
        BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds150);
        BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
        BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8);
        a = new int[]{R.string.obfuscated_res_0x7f0f125a};
    }

    public static boolean C(ye9 ye9Var, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, null, ye9Var, z)) == null) {
            if (ye9Var == null || ye9Var.O() == null || ye9Var.O().getAuthor() == null || TextUtils.equals(ye9Var.O().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                return false;
            }
            return !z;
        }
        return invokeLZ.booleanValue;
    }

    public static boolean d(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65552, null, tbPageContext, i)) == null) {
            if (tbPageContext != null && tbPageContext.getPageActivity() != null) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    return true;
                }
                TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i)));
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public static Intent n(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65562, null, context, str)) == null) {
            if (!TextUtils.isEmpty(str) && context != null) {
                Intent intent = new Intent(context, DealIntentService.class);
                intent.putExtra("class", 1);
                intent.putExtra("id", str);
                intent.putExtra("from", "nas");
                intent.putExtra("key_start_from", 5);
                return intent;
            }
            return null;
        }
        return (Intent) invokeLL.objValue;
    }

    public static boolean D(PbFragment pbFragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, pbFragment)) == null) {
            if (pbFragment == null || pbFragment.q6() != 4) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean k(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.V() == null) {
                return false;
            }
            return tbRichTextData.V().W();
        }
        return invokeL.booleanValue;
    }

    public static boolean l(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.V() == null) {
                return false;
            }
            return tbRichTextData.V().X();
        }
        return invokeL.booleanValue;
    }

    public static String o(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.V() == null) {
                return null;
            }
            return tbRichTextData.V().R();
        }
        return (String) invokeL.objValue;
    }

    public static long p(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.V() == null) {
                return 0L;
            }
            return tbRichTextData.V().getOriginalSize();
        }
        return invokeL.longValue;
    }

    public static boolean y(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, null, view2)) == null) {
            if (!(view2 instanceof TbImageView) && !(view2 instanceof TbMemeImageView) && !(view2 instanceof GifView)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void E(ye9 ye9Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65541, null, ye9Var, str, str2) == null) && ye9Var != null && ye9Var.O() != null && ye9Var.O().isQuestionThread()) {
            ThreadData O = ye9Var.O();
            int i = 3;
            if ("3".equals(str2)) {
                i = 1;
            } else if ("question_answer_invite".equals(str)) {
                i = 2;
            }
            TiebaStatic.log(new StatisticItem("c14923").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("tid", O.getId()).param("fid", O.getFid()).param("obj_source", i));
        }
    }

    public static boolean K(ye9 ye9Var, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{ye9Var, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (z || ye9Var == null) {
                return false;
            }
            if (ye9Var.k() != null && ye9Var.k().isBlockBawuDelete) {
                return false;
            }
            if ((ye9Var.O() != null && ye9Var.O().getAuthor() != null && ye9Var.O().getAuthor().isForumBusinessAccount() && !me7.isOn()) || z2) {
                return false;
            }
            if ((ye9Var.O() != null && ye9Var.O().isBlocked()) || ye9Var.W() == 0 || ye9Var.W() == 3) {
                return false;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static void F(PbFragment pbFragment, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(65542, null, pbFragment, i) != null) || pbFragment == null) {
            return;
        }
        if (D(pbFragment)) {
            pbFragment.x0 = true;
            SafeHandler.getInst().post(new d(pbFragment, i));
            return;
        }
        G(pbFragment, i);
    }

    public static void G(PbFragment pbFragment, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65543, null, pbFragment, i) == null) {
            if (i > 0) {
                il9.i(pbFragment.getListView(), i);
            } else {
                il9.g(pbFragment.getListView());
            }
        }
    }

    public static void I(PbFragment pbFragment, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65545, null, pbFragment, i) == null) && pbFragment != null) {
            pbFragment.c8(i);
        }
    }

    public static oea j(ye9 ye9Var, String str) {
        InterceptResult invokeLL;
        oea z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, ye9Var, str)) == null) {
            if (TextUtils.isEmpty(str) || ye9Var == null || (z = ye9Var.z()) == null || !str.equals(z.E1())) {
                return null;
            }
            return z;
        }
        return (oea) invokeLL.objValue;
    }

    public static String t(int i, Object... objArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65568, null, i, objArr)) == null) {
            return TbadkCoreApplication.getInst().getString(i, objArr);
        }
        return (String) invokeIL.objValue;
    }

    public static void H(PbFragment pbFragment, int i, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(65544, null, pbFragment, i, str) != null) || pbFragment == null) {
            return;
        }
        if (D(pbFragment)) {
            SafeHandler.getInst().post(new c(i, pbFragment, str));
        } else {
            il9.j(i, pbFragment.getListView(), str);
        }
    }

    public static boolean J(ye9 ye9Var, boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        qw4 qw4Var;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{ye9Var, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            if (ye9Var == null) {
                return false;
            }
            ThreadData O = ye9Var.O();
            if (O != null) {
                if (O.isBJHArticleThreadType() || O.isBJHVideoThreadType()) {
                    return false;
                }
                if (O.isBJHNormalThreadType() || O.isBJHVideoDynamicThreadType()) {
                    return z;
                }
            }
            if (z) {
                return true;
            }
            if ((O != null && O.getAuthor() != null && O.getAuthor().isForumBusinessAccount() && !me7.isOn()) || z3 || O.isWorksInfo() || O.isScoreThread() || z2) {
                return false;
            }
            if (ye9Var.k() != null && ye9Var.k().isBlockBawuDelete) {
                return false;
            }
            if (ye9Var.O() != null && ye9Var.O().isBlocked()) {
                return false;
            }
            if (ye9Var.W() != 0) {
                if (ye9Var.W() == 3) {
                    return false;
                }
                return true;
            }
            List<ly4> o = ye9Var.o();
            if (ListUtils.getCount(o) <= 0) {
                return false;
            }
            for (ly4 ly4Var : o) {
                if (ly4Var != null && (qw4Var = ly4Var.h) != null && qw4Var.a && !qw4Var.c && ((i = qw4Var.b) == 1 || i == 2)) {
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean L(boolean z, boolean z2, boolean z3, int i, boolean z4, boolean z5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Integer.valueOf(i), Boolean.valueOf(z4), Boolean.valueOf(z5)})) == null) {
            if (z) {
                return false;
            }
            if (z4 || z5) {
                return true;
            }
            if (!z2 || (!z3 && !A(i))) {
                return false;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static void b(Context context, ye9 ye9Var, String str, boolean z, String str2, String str3, String str4, String str5, String str6, String str7) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{context, ye9Var, str, Boolean.valueOf(z), str2, str3, str4, str5, str6, str7}) == null) && ye9Var != null && ye9Var.O() != null) {
            ThreadData O = ye9Var.O();
            O.mRecomAbTag = str2;
            O.mRecomWeight = str3;
            O.mRecomSource = str4;
            O.mRecomExtra = str5;
            if (O.getFid() == 0) {
                O.setFid(JavaTypesHelper.toLong(str, 0L));
            }
            StatisticItem i = ym5.i(context, O, TbadkCoreStatisticKey.KEY_PB_REPLY_CLICK);
            TbPageTag l = ym5.l(context);
            if (l != null && "a008".equals(l.locatePage)) {
                i.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a005");
                i.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a008");
            }
            if (l != null && "a002".equals(l.locatePage)) {
                i.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a005");
                i.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a002");
            }
            if (i != null) {
                i.param(TiebaStatic.Params.REPLY_TYPE, 1);
                tm5 currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(context);
                if (currentVisiblePageExtra != null) {
                    i.param(TiebaStatic.Params.OBJ_CUR_PAGE, currentVisiblePageExtra.a());
                }
                if (TbPageExtraHelper.getPrePageKey() != null) {
                    i.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
                }
                TiebaStatic.log(i);
            }
            if (!z) {
                E(ye9Var, str6, str7);
            }
        }
    }

    public static void c(@NonNull ImageView imageView, boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{imageView, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            if (z) {
                imageView.setImageResource(R.drawable.pic_frs_headlines_n);
                imageView.setVisibility(0);
            } else if (z2 && z3) {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f08123a);
                imageView.setVisibility(0);
            } else if (z2) {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f081238);
                imageView.setVisibility(0);
            } else if (z3) {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f081239);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            if (imageView.getVisibility() == 0 && imageView.getLayoutParams() != null) {
                imageView.getLayoutParams().height = r() - s();
            }
        }
    }

    public static void e(List<yh> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65553, null, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        Iterator<yh> it = list.iterator();
        while (it.hasNext()) {
            yh next = it.next();
            if (next instanceof ThreadData) {
                if (((ThreadData) next).funAdData != null) {
                    it.remove();
                }
            } else if (!(next instanceof oea) && !(next instanceof f16)) {
                if ((next instanceof pea) && ((pea) next).y0 != null) {
                    it.remove();
                }
            } else {
                it.remove();
            }
        }
    }

    public static int u(ye9 ye9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, ye9Var)) == null) {
            if (ye9Var == null || ye9Var.O() == null) {
                return 0;
            }
            if (ye9Var.O().isMutiForumThread()) {
                if (ListUtils.isEmpty(ye9Var.o()) && (ye9Var.g() == null || StringUtils.isNull(ye9Var.g().d()))) {
                    return 0;
                }
                return 2;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public static int v(ye9 ye9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, ye9Var)) == null) {
            if (ye9Var != null && ye9Var.O() != null) {
                if (ye9Var.O().getThreadType() == 0) {
                    return 1;
                }
                if (ye9Var.O().getThreadType() == 54) {
                    return 2;
                }
                if (ye9Var.O().getThreadType() == 40) {
                    return 3;
                }
                return 4;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static void f(List<yh> list, oea oeaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65554, null, list, oeaVar) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        Iterator<yh> it = list.iterator();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (it.hasNext()) {
            i++;
            yh next = it.next();
            nea neaVar = null;
            if ((i2 + 1 == i || i3 + 1 == i) && (next instanceof f16)) {
                it.remove();
            }
            if (next instanceof ThreadData) {
                neaVar = ((ThreadData) next).funAdData;
            } else if (next instanceof pea) {
                neaVar = ((pea) next).y0;
            }
            if (neaVar != null && neaVar.i()) {
                i2 = i;
            }
            if (oeaVar != null && next == oeaVar) {
                it.remove();
                i3 = i;
            }
        }
    }

    public static void g(String str, ye9 ye9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65555, null, str, ye9Var) == null) && ye9Var != null && ye9Var.O() != null && ye9Var.O().isUgcThreadType()) {
            ThreadData O = ye9Var.O();
            int i = 0;
            if (O.isBJHArticleThreadType()) {
                i = 1;
            } else if (O.isBJHVideoThreadType()) {
                i = 2;
            } else if (O.isBJHNormalThreadType()) {
                i = 3;
            } else if (O.isBJHVideoDynamicThreadType()) {
                i = 4;
            }
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("obj_source", 4);
            statisticItem.param("obj_type", i);
            TiebaStatic.log(statisticItem);
        }
    }

    public static boolean z(ye9 ye9Var, int i) {
        InterceptResult invokeLI;
        List<ForumToolPerm> forumToolAuth;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65574, null, ye9Var, i)) == null) {
            if (i == 1) {
                return true;
            }
            if (ye9Var.V() != null && (forumToolAuth = ye9Var.V().getForumToolAuth()) != null) {
                for (int i2 = 0; i2 < forumToolAuth.size(); i2++) {
                    ForumToolPerm forumToolPerm = forumToolAuth.get(i2);
                    if (forumToolPerm != null && forumToolPerm.perm.longValue() == 1) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public static int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            return a[0];
        }
        return invokeV.intValue;
    }

    public static int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) {
            return UtilHelper.getDimenPixelSize(R.dimen.tbds195);
        }
        return invokeV.intValue;
    }

    public static int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) {
            return UtilHelper.getDimenPixelSize(R.dimen.tbds88);
        }
        return invokeV.intValue;
    }

    public static SpannableString i(ThreadData threadData) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, threadData)) == null) {
            if (threadData == null) {
                return null;
            }
            if (threadData.getBJHContentTag() == 1) {
                str = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1938);
            } else if (threadData.getBJHContentTag() == 2) {
                str = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1408);
            } else {
                str = "";
            }
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            SpannableString spannableString = new SpannableString(new StringBuilder(str).toString());
            spannableString.setSpan(new p55(R.color.CAM_X0204, UtilHelper.getDimenPixelSize(R.dimen.tbds5), UtilHelper.getDimenPixelSize(R.dimen.tbds26), R.color.CAM_X0105, UtilHelper.getDimenPixelSize(R.dimen.tbds8), UtilHelper.getDimenPixelSize(R.dimen.tbds9), UtilHelper.getDimenPixelSize(R.dimen.tbds13)), 0, spannableString.length(), 17);
            return spannableString;
        }
        return (SpannableString) invokeL.objValue;
    }

    public static int m(PbFragment pbFragment) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, pbFragment)) == null) {
            if (pbFragment != null && pbFragment.getActivity() != null) {
                i = BdUtilHelper.getDimens(pbFragment.getActivity(), R.dimen.obfuscated_res_0x7f070420);
            } else {
                i = 0;
            }
            if (i == 0) {
                i = UtilHelper.getDimenPixelSize(R.dimen.obfuscated_res_0x7f070420);
            }
            return UtilHelper.getLightStatusBarHeight() + i;
        }
        return invokeL.intValue;
    }

    public static boolean x(ye9 ye9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, null, ye9Var)) == null) {
            if (ye9Var != null && ye9Var.O() != null) {
                SpannableStringBuilder span_str = ye9Var.O().getSpan_str();
                if (span_str != null) {
                    return TbadkApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0ff7).equals(span_str.toString());
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void w(Context context, int i, int i2, PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65571, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), pbModel}) == null) {
            ks5.b(new a(i2, pbModel), new b(context, i));
            StatisticItem statisticItem = new StatisticItem("c13833");
            statisticItem.param("obj_locate", 1);
            if (i == 3) {
                statisticItem.param("obj_type", 1);
            } else if (i == 8) {
                statisticItem.param("obj_type", 2);
            }
            TiebaStatic.log(statisticItem);
        }
    }
}

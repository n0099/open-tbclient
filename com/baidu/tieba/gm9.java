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
/* loaded from: classes6.dex */
public class gm9 {
    public static /* synthetic */ Interceptable $ic;
    public static final int a;
    public static final int b;
    public static final int c;
    public static final int[] d;
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

    public static int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
            return 28;
        }
        return invokeV.intValue;
    }

    public static int p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65563, null, i)) == null) {
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

    /* loaded from: classes6.dex */
    public static class a extends bx5<ShareItem> {
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
        @Override // com.baidu.tieba.bx5
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
                return lo9.c(this.a, i, this.b);
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements gw5<ShareItem> {
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
        @Override // com.baidu.tieba.gw5
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

    /* loaded from: classes6.dex */
    public static class c implements Runnable {
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
                in9.i(this.a, this.b.getListView(), this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public d(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
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
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                in9.g(this.a.getListView());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947798870, "Lcom/baidu/tieba/gm9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947798870, "Lcom/baidu/tieba/gm9;");
                return;
            }
        }
        a = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds150);
        b = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
        c = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8);
        d = new int[]{R.string.obfuscated_res_0x7f0f1230};
    }

    public static boolean C(yh9 yh9Var, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, null, yh9Var, z)) == null) {
            if (yh9Var == null || yh9Var.O() == null || yh9Var.O().getAuthor() == null || TextUtils.equals(yh9Var.O().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                return false;
            }
            return !z;
        }
        return invokeLZ.booleanValue;
    }

    public static boolean c(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65550, null, tbPageContext, i)) == null) {
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

    public static Intent m(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, context, str)) == null) {
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
            if (pbFragment == null || pbFragment.I5() != 4) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void F(PbFragment pbFragment) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65542, null, pbFragment) != null) || pbFragment == null) {
            return;
        }
        if (D(pbFragment)) {
            pbFragment.w0 = true;
            SafeHandler.getInst().post(new d(pbFragment));
            return;
        }
        in9.g(pbFragment.getListView());
    }

    public static boolean j(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.V() == null) {
                return false;
            }
            return tbRichTextData.V().U();
        }
        return invokeL.booleanValue;
    }

    public static boolean k(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.V() == null) {
                return false;
            }
            return tbRichTextData.V().V();
        }
        return invokeL.booleanValue;
    }

    public static String n(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.V() == null) {
                return null;
            }
            return tbRichTextData.V().Q();
        }
        return (String) invokeL.objValue;
    }

    public static long o(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, tbRichTextData)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, null, view2)) == null) {
            if (!(view2 instanceof TbImageView) && !(view2 instanceof TbMemeImageView) && !(view2 instanceof GifView)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void E(yh9 yh9Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65541, null, yh9Var, str, str2) == null) && yh9Var != null && yh9Var.O() != null && yh9Var.O().isQuestionThread()) {
            ThreadData O = yh9Var.O();
            int i = 3;
            if ("3".equals(str2)) {
                i = 1;
            } else if ("question_answer_invite".equals(str)) {
                i = 2;
            }
            TiebaStatic.log(new StatisticItem("c14923").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("tid", O.getId()).param("fid", O.getFid()).param("obj_source", i));
        }
    }

    public static boolean J(yh9 yh9Var, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{yh9Var, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (z || yh9Var == null) {
                return false;
            }
            if (yh9Var.k() != null && yh9Var.k().isBlockBawuDelete) {
                return false;
            }
            if ((yh9Var.O() != null && yh9Var.O().getAuthor() != null && yh9Var.O().getAuthor().isForumBusinessAccount() && !mi7.isOn()) || z2) {
                return false;
            }
            if ((yh9Var.O() != null && yh9Var.O().isBlocked()) || yh9Var.W() == 0 || yh9Var.W() == 3) {
                return false;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static void G(PbFragment pbFragment, int i, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(65543, null, pbFragment, i, str) != null) || pbFragment == null) {
            return;
        }
        if (D(pbFragment)) {
            SafeHandler.getInst().post(new c(i, pbFragment, str));
        } else {
            in9.i(i, pbFragment.getListView(), str);
        }
    }

    public static void H(PbFragment pbFragment, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65544, null, pbFragment, i) == null) && pbFragment != null) {
            pbFragment.Y6(i);
        }
    }

    public static yfa i(yh9 yh9Var, String str) {
        InterceptResult invokeLL;
        yfa z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, yh9Var, str)) == null) {
            if (TextUtils.isEmpty(str) || yh9Var == null || (z = yh9Var.z()) == null || !str.equals(z.A1())) {
                return null;
            }
            return z;
        }
        return (yfa) invokeLL.objValue;
    }

    public static String t(int i, Object... objArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65567, null, i, objArr)) == null) {
            return TbadkCoreApplication.getInst().getString(i, objArr);
        }
        return (String) invokeIL.objValue;
    }

    public static boolean I(yh9 yh9Var, boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        d25 d25Var;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{yh9Var, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            if (yh9Var == null) {
                return false;
            }
            ThreadData O = yh9Var.O();
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
            if ((O != null && O.getAuthor() != null && O.getAuthor().isForumBusinessAccount() && !mi7.isOn()) || z3 || O.isWorksInfo() || O.isScoreThread() || z2) {
                return false;
            }
            if (yh9Var.k() != null && yh9Var.k().isBlockBawuDelete) {
                return false;
            }
            if (yh9Var.O() != null && yh9Var.O().isBlocked()) {
                return false;
            }
            if (yh9Var.W() != 0) {
                if (yh9Var.W() == 3) {
                    return false;
                }
                return true;
            }
            List<y35> o = yh9Var.o();
            if (ListUtils.getCount(o) <= 0) {
                return false;
            }
            for (y35 y35Var : o) {
                if (y35Var != null && (d25Var = y35Var.h) != null && d25Var.a && !d25Var.c && ((i = d25Var.b) == 1 || i == 2)) {
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean K(boolean z, boolean z2, boolean z3, int i, boolean z4, boolean z5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Integer.valueOf(i), Boolean.valueOf(z4), Boolean.valueOf(z5)})) == null) {
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

    public static int q(int i, int i2, int i3, int i4, int i5, boolean z) {
        InterceptResult invokeCommon;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65564, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z)})) == null) {
            if (z) {
                i6 = a;
            } else {
                i6 = 0;
            }
            return ((((i - i2) - i3) - i4) - i5) - i6;
        }
        return invokeCommon.intValue;
    }

    public static void a(Context context, yh9 yh9Var, String str, boolean z, String str2, String str3, String str4, String str5, String str6, String str7) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{context, yh9Var, str, Boolean.valueOf(z), str2, str3, str4, str5, str6, str7}) == null) && yh9Var != null && yh9Var.O() != null) {
            ThreadData O = yh9Var.O();
            O.mRecomAbTag = str2;
            O.mRecomWeight = str3;
            O.mRecomSource = str4;
            O.mRecomExtra = str5;
            if (O.getFid() == 0) {
                O.setFid(JavaTypesHelper.toLong(str, 0L));
            }
            StatisticItem i = xr5.i(context, O, TbadkCoreStatisticKey.KEY_PB_REPLY_CLICK);
            TbPageTag l = xr5.l(context);
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
                sr5 currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(context);
                if (currentVisiblePageExtra != null) {
                    i.param(TiebaStatic.Params.OBJ_CUR_PAGE, currentVisiblePageExtra.a());
                }
                if (TbPageExtraHelper.getPrePageKey() != null) {
                    i.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
                }
                TiebaStatic.log(i);
            }
            if (!z) {
                E(yh9Var, str6, str7);
            }
        }
    }

    public static void b(@NonNull ImageView imageView, boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{imageView, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            if (z) {
                imageView.setImageResource(R.drawable.pic_frs_headlines_n);
                imageView.setVisibility(0);
            } else if (z2 && z3) {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f08121f);
                imageView.setVisibility(0);
            } else if (z2) {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f08121d);
                imageView.setVisibility(0);
            } else if (z3) {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f08121e);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            if (imageView.getVisibility() == 0 && imageView.getLayoutParams() != null) {
                imageView.getLayoutParams().height = r() - s();
            }
        }
    }

    public static void d(List<bn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65551, null, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        Iterator<bn> it = list.iterator();
        while (it.hasNext()) {
            bn next = it.next();
            if (next instanceof ThreadData) {
                if (((ThreadData) next).funAdData != null) {
                    it.remove();
                }
            } else if (!(next instanceof yfa) && !(next instanceof z56)) {
                if ((next instanceof zfa) && ((zfa) next).x0 != null) {
                    it.remove();
                }
            } else {
                it.remove();
            }
        }
    }

    public static int u(yh9 yh9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, yh9Var)) == null) {
            if (yh9Var == null || yh9Var.O() == null) {
                return 0;
            }
            if (yh9Var.O().isMutiForumThread()) {
                if (ListUtils.isEmpty(yh9Var.o()) && (yh9Var.g() == null || StringUtils.isNull(yh9Var.g().d()))) {
                    return 0;
                }
                return 2;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public static int v(yh9 yh9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, yh9Var)) == null) {
            if (yh9Var != null && yh9Var.O() != null) {
                if (yh9Var.O().getThreadType() == 0) {
                    return 1;
                }
                if (yh9Var.O().getThreadType() == 54) {
                    return 2;
                }
                if (yh9Var.O().getThreadType() == 40) {
                    return 3;
                }
                return 4;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static void e(List<bn> list, yfa yfaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65552, null, list, yfaVar) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        Iterator<bn> it = list.iterator();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (it.hasNext()) {
            i++;
            bn next = it.next();
            xfa xfaVar = null;
            if ((i2 + 1 == i || i3 + 1 == i) && (next instanceof z56)) {
                it.remove();
            }
            if (next instanceof ThreadData) {
                xfaVar = ((ThreadData) next).funAdData;
            } else if (next instanceof zfa) {
                xfaVar = ((zfa) next).x0;
            }
            if (xfaVar != null && xfaVar.i()) {
                i2 = i;
            }
            if (yfaVar != null && next == yfaVar) {
                it.remove();
                i3 = i;
            }
        }
    }

    public static void f(String str, yh9 yh9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65553, null, str, yh9Var) == null) && yh9Var != null && yh9Var.O() != null && yh9Var.O().isUgcThreadType()) {
            ThreadData O = yh9Var.O();
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

    public static boolean z(yh9 yh9Var, int i) {
        InterceptResult invokeLI;
        List<ForumToolPerm> forumToolAuth;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65573, null, yh9Var, i)) == null) {
            if (i == 1) {
                return true;
            }
            if (yh9Var.V() != null && (forumToolAuth = yh9Var.V().getForumToolAuth()) != null) {
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

    public static int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            return d[0];
        }
        return invokeV.intValue;
    }

    public static int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) {
            return UtilHelper.getDimenPixelSize(R.dimen.tbds195);
        }
        return invokeV.intValue;
    }

    public static int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) {
            return UtilHelper.getDimenPixelSize(R.dimen.tbds88);
        }
        return invokeV.intValue;
    }

    public static SpannableString h(ThreadData threadData) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, threadData)) == null) {
            if (threadData == null) {
                return null;
            }
            if (threadData.getBJHContentTag() == 1) {
                str = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f193a);
            } else if (threadData.getBJHContentTag() == 2) {
                str = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f13dd);
            } else {
                str = "";
            }
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            SpannableString spannableString = new SpannableString(new StringBuilder(str).toString());
            spannableString.setSpan(new ta5(R.color.CAM_X0204, UtilHelper.getDimenPixelSize(R.dimen.tbds5), UtilHelper.getDimenPixelSize(R.dimen.tbds26), R.color.CAM_X0105, UtilHelper.getDimenPixelSize(R.dimen.tbds8), UtilHelper.getDimenPixelSize(R.dimen.tbds9), UtilHelper.getDimenPixelSize(R.dimen.tbds13)), 0, spannableString.length(), 17);
            return spannableString;
        }
        return (SpannableString) invokeL.objValue;
    }

    public static void w(Context context, int i, int i2, PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65570, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), pbModel}) == null) {
            fx5.b(new a(i2, pbModel), new b(context, i));
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

    public static boolean x(yh9 yh9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, yh9Var)) == null) {
            if (yh9Var != null && yh9Var.O() != null) {
                SpannableStringBuilder span_str = yh9Var.O().getSpan_str();
                if (span_str != null) {
                    return TbadkApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0fd1).equals(span_str.toString());
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}

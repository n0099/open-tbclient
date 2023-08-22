package com.baidu.tieba;

import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
import tbclient.ThreadInfo;
/* loaded from: classes5.dex */
public class do9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a extends h16 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ro6 m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i, String str, ro6 ro6Var) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), str, ro6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.m = ro6Var;
        }

        @Override // com.baidu.tieba.h16, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                StatisticItem statisticItem = null;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(view2.getContext(), g(), null)));
                ro6 ro6Var = this.m;
                if (ro6Var instanceof zo6) {
                    statisticItem = ((zo6) ro6Var).N();
                } else if (ro6Var instanceof ap6) {
                    statisticItem = ((ap6) ro6Var).K(null);
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public static void a(List<ThreadInfo> list, List<bn> list2, String str, int i) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65536, null, list, list2, str, i) == null) {
            int i2 = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                ThreadInfo threadInfo = list.get(i3);
                if (threadInfo != null) {
                    ThreadData threadData2 = new ThreadData();
                    threadData2.floorNum = i3 + 1;
                    threadData2.parserProtobuf(threadInfo);
                    if (threadData2.getForumData() != null && !TextUtils.isEmpty(str)) {
                        threadData2.getForumData().l = str;
                    }
                    if ((zo6.R(threadData2) || ap6.L(threadData2)) && threadData2.getType() != ThreadData.TYPE_SHARE_THREAD) {
                        zo6 d = d(threadData2, i);
                        if (d != null && (threadData = d.a) != null && threadData.getForumData() != null && !StringUtils.isNull(threadData.getForumData().b)) {
                            d.g = threadData2.getTid();
                            d.position = i2;
                            f(d);
                            list2.add(d);
                        }
                        int[] imageWidthAndHeight = threadData2.getImageWidthAndHeight();
                        ro6 c = c(threadData2, i);
                        if (c != null) {
                            c.g = threadData2.getTid();
                            c.position = i2;
                            if (c instanceof zo6) {
                                if (threadData2.picCount() == 1) {
                                    h(c);
                                    c.j = imageWidthAndHeight[0];
                                    c.k = imageWidthAndHeight[1];
                                } else if (threadData2.picCount() >= 2) {
                                    g(c);
                                } else {
                                    i(c);
                                }
                            } else if (c instanceof ap6) {
                                j(c);
                            }
                        }
                        if (c != null && c.isValid()) {
                            c.a.insertItemToTitleOrAbstractText();
                            if (!threadData2.isUgcThreadType() && threadData2.getAuthor() != null) {
                                String format = String.format(TbadkCoreApplication.getInst().getString(R.string.at_username), threadData2.getAuthor().getName_show());
                                SpannableString spannableString = new SpannableString(format);
                                spannableString.setSpan(new a(16, threadData2.getAuthor().getUserId(), c), 0, format.length() - 1, 33);
                                c.a.insertUsernameIntoTitleOrAbstract(spannableString);
                            }
                            list2.add(c);
                        }
                        zo6 d2 = d(threadData2, i);
                        if (d2 != null) {
                            d2.g = threadData2.getTid();
                            d2.position = i2;
                            e(d2);
                        }
                        if (d2 != null && d2.isValid()) {
                            list2.add(d2);
                        }
                    }
                    i2++;
                }
            }
        }
    }

    public static List<bn> b(List<ThreadInfo> list, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65537, null, list, str, i)) == null) {
            LinkedList linkedList = new LinkedList();
            a(list, linkedList, str, i);
            return linkedList;
        }
        return (List) invokeLLI.objValue;
    }

    public static ro6 c(ThreadData threadData, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, threadData, i)) == null) {
            if (threadData == null) {
                return null;
            }
            if (zo6.R(threadData)) {
                zo6 zo6Var = new zo6();
                threadData.isLinkThread();
                threadData.isSmartAppThreadType();
                if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                    threadData.isGodThread();
                }
                zo6Var.a = threadData;
                zo6Var.C = i;
                return zo6Var;
            } else if (!ap6.L(threadData)) {
                return null;
            } else {
                ap6 ap6Var = new ap6(threadData);
                ap6Var.C = i;
                return ap6Var;
            }
        }
        return (ro6) invokeLI.objValue;
    }

    public static zo6 d(ThreadData threadData, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, threadData, i)) == null) {
            zo6 zo6Var = new zo6();
            zo6Var.a = threadData;
            threadData.isLinkThread();
            if (!threadData.isLinkThread()) {
                threadData.isGodThread();
            }
            zo6Var.C = i;
            return zo6Var;
        }
        return (zo6) invokeLI.objValue;
    }

    public static void e(ro6 ro6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, ro6Var) == null) {
            if (ro6Var instanceof zo6) {
                ((zo6) ro6Var).A = true;
            } else if (ro6Var instanceof ap6) {
                ((ap6) ro6Var).A = true;
            } else if (ro6Var instanceof yo6) {
                ((yo6) ro6Var).A = true;
            }
            ro6Var.setSupportType(BaseCardInfo.SupportType.BOTTOM);
        }
    }

    public static void f(ro6 ro6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, ro6Var) == null) {
            ro6Var.n = true;
            ro6Var.setSupportType(BaseCardInfo.SupportType.TOP);
        }
    }

    public static void g(ro6 ro6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, ro6Var) == null) {
            ((zo6) ro6Var).q = true;
            ro6Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void h(ro6 ro6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, ro6Var) == null) {
            ((zo6) ro6Var).p = true;
            ro6Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void i(ro6 ro6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, ro6Var) == null) {
            ((zo6) ro6Var).r = true;
            ro6Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void j(ro6 ro6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, ro6Var) == null) {
            ((ap6) ro6Var).s = true;
            ro6Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }
}

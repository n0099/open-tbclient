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
public class el9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a extends f36 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cq6 l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i, String str, cq6 cq6Var) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), str, cq6Var};
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
            this.l = cq6Var;
        }

        @Override // com.baidu.tieba.f36, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                StatisticItem statisticItem = null;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(view2.getContext(), f(), null)));
                cq6 cq6Var = this.l;
                if (cq6Var instanceof kq6) {
                    statisticItem = ((kq6) cq6Var).R();
                } else if (cq6Var instanceof lq6) {
                    statisticItem = ((lq6) cq6Var).M(null);
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public static void a(List<ThreadInfo> list, List<yn> list2, String str, int i) {
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
                    if ((kq6.X(threadData2) || lq6.N(threadData2)) && threadData2.getType() != ThreadData.TYPE_SHARE_THREAD) {
                        kq6 d = d(threadData2, i);
                        if (d != null && (threadData = d.a) != null && threadData.getForumData() != null && !StringUtils.isNull(threadData.getForumData().b)) {
                            d.g = threadData2.getTid();
                            d.position = i2;
                            f(d);
                            list2.add(d);
                        }
                        int[] imageWidthAndHeight = threadData2.getImageWidthAndHeight();
                        cq6 c = c(threadData2, i);
                        if (c != null) {
                            c.g = threadData2.getTid();
                            c.position = i2;
                            if (c instanceof kq6) {
                                if (threadData2.picCount() == 1) {
                                    h(c);
                                    c.j = imageWidthAndHeight[0];
                                    c.k = imageWidthAndHeight[1];
                                } else if (threadData2.picCount() >= 2) {
                                    g(c);
                                } else {
                                    i(c);
                                }
                            } else if (c instanceof lq6) {
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
                        kq6 d2 = d(threadData2, i);
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

    public static List<yn> b(List<ThreadInfo> list, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65537, null, list, str, i)) == null) {
            LinkedList linkedList = new LinkedList();
            a(list, linkedList, str, i);
            return linkedList;
        }
        return (List) invokeLLI.objValue;
    }

    public static cq6 c(ThreadData threadData, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, threadData, i)) == null) {
            if (threadData == null) {
                return null;
            }
            if (kq6.X(threadData)) {
                kq6 kq6Var = new kq6();
                threadData.isLinkThread();
                threadData.isSmartAppThreadType();
                if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                    threadData.isGodThread();
                }
                kq6Var.a = threadData;
                kq6Var.C = i;
                return kq6Var;
            } else if (!lq6.N(threadData)) {
                return null;
            } else {
                lq6 lq6Var = new lq6(threadData);
                lq6Var.C = i;
                return lq6Var;
            }
        }
        return (cq6) invokeLI.objValue;
    }

    public static kq6 d(ThreadData threadData, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, threadData, i)) == null) {
            kq6 kq6Var = new kq6();
            kq6Var.a = threadData;
            threadData.isLinkThread();
            if (!threadData.isLinkThread()) {
                threadData.isGodThread();
            }
            kq6Var.C = i;
            return kq6Var;
        }
        return (kq6) invokeLI.objValue;
    }

    public static void e(cq6 cq6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, cq6Var) == null) {
            if (cq6Var instanceof kq6) {
                ((kq6) cq6Var).A = true;
            } else if (cq6Var instanceof lq6) {
                ((lq6) cq6Var).A = true;
            } else if (cq6Var instanceof jq6) {
                ((jq6) cq6Var).A = true;
            }
            cq6Var.setSupportType(BaseCardInfo.SupportType.BOTTOM);
        }
    }

    public static void f(cq6 cq6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, cq6Var) == null) {
            cq6Var.n = true;
            cq6Var.setSupportType(BaseCardInfo.SupportType.TOP);
        }
    }

    public static void g(cq6 cq6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, cq6Var) == null) {
            ((kq6) cq6Var).q = true;
            cq6Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void h(cq6 cq6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, cq6Var) == null) {
            ((kq6) cq6Var).p = true;
            cq6Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void i(cq6 cq6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, cq6Var) == null) {
            ((kq6) cq6Var).r = true;
            cq6Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void j(cq6 cq6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, cq6Var) == null) {
            ((lq6) cq6Var).s = true;
            cq6Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }
}

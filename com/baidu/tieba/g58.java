package com.baidu.tieba;

import android.text.SpannableString;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes4.dex */
public class g58 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public x18 b;
    public va6 c;
    public View.OnTouchListener d;

    /* loaded from: classes4.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g58 a;

        public a(g58 g58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g58Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (this.a.c != null) {
                    this.a.c.c(motionEvent);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends tn5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o56 i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(g58 g58Var, int i, String str, o56 o56Var) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g58Var, Integer.valueOf(i), str, o56Var};
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
            this.i = o56Var;
        }

        @Override // com.baidu.tieba.tn5, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                StatisticItem statisticItem = null;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(view2.getContext(), d(), null)));
                o56 o56Var = this.i;
                if (o56Var instanceof w56) {
                    statisticItem = ((w56) o56Var).S();
                } else if (o56Var instanceof x56) {
                    statisticItem = ((x56) o56Var).Q(null);
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public g58(BdTypeRecyclerView bdTypeRecyclerView, x18 x18Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdTypeRecyclerView, x18Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a aVar = new a(this);
        this.d = aVar;
        this.a = bdTypeRecyclerView;
        this.b = x18Var;
        bdTypeRecyclerView.setOnTouchListener(aVar);
        this.c = new va6();
    }

    public final w56 d(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData)) == null) {
            w56 w56Var = new w56();
            w56Var.a = threadData;
            threadData.isLinkThread();
            if (!threadData.isLinkThread()) {
                threadData.isGodThread();
            }
            return w56Var;
        }
        return (w56) invokeL.objValue;
    }

    public final void f(o56 o56Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, o56Var) == null) {
            o56Var.n = true;
            o56Var.setSupportType(BaseCardInfo.SupportType.TOP);
        }
    }

    public final void g(o56 o56Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, o56Var) == null) {
            ((w56) o56Var).q = true;
            o56Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public final void h(o56 o56Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, o56Var) == null) {
            ((w56) o56Var).p = true;
            o56Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public final void i(o56 o56Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, o56Var) == null) {
            ((w56) o56Var).r = true;
            o56Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public final void j(o56 o56Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, o56Var) == null) {
            ((x56) o56Var).s = true;
            o56Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public final void b(List<ThreadInfo> list, List<xn> list2, String str) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, list, list2, str) == null) {
            int i = 0;
            for (int i2 = 0; i2 < list.size(); i2++) {
                ThreadInfo threadInfo = list.get(i2);
                if (threadInfo != null) {
                    ThreadData threadData2 = new ThreadData();
                    threadData2.floorNum = i2 + 1;
                    threadData2.parserProtobuf(threadInfo);
                    if (threadData2.getForumData() != null) {
                        threadData2.getForumData().i = str;
                    }
                    if ((w56.W(threadData2) || x56.R(threadData2)) && threadData2.getType() != ThreadData.TYPE_SHARE_THREAD) {
                        w56 d = d(threadData2);
                        if (d != null && (threadData = d.a) != null && threadData.getForumData() != null && !StringUtils.isNull(threadData.getForumData().b)) {
                            d.g = threadData2.getTid();
                            d.position = i;
                            f(d);
                            list2.add(d);
                        }
                        int[] imageWidthAndHeight = threadData2.getImageWidthAndHeight();
                        o56 c = c(threadData2);
                        if (c != null) {
                            c.g = threadData2.getTid();
                            c.position = i;
                            if (c instanceof w56) {
                                if (threadData2.picCount() == 1) {
                                    h(c);
                                    c.j = imageWidthAndHeight[0];
                                    c.k = imageWidthAndHeight[1];
                                } else if (threadData2.picCount() >= 2) {
                                    g(c);
                                } else {
                                    i(c);
                                }
                            } else if (c instanceof x56) {
                                j(c);
                            }
                        }
                        if (c != null && c.isValid()) {
                            c.a.insertItemToTitleOrAbstractText();
                            if (!threadData2.isUgcThreadType() && threadData2.getAuthor() != null) {
                                String format = String.format(TbadkCoreApplication.getInst().getString(R.string.at_username), threadData2.getAuthor().getName_show());
                                SpannableString spannableString = new SpannableString(format);
                                spannableString.setSpan(new b(this, 16, threadData2.getAuthor().getUserId(), c), 0, format.length() - 1, 33);
                                c.a.insertUsernameIntoTitleOrAbstract(spannableString);
                            }
                            list2.add(c);
                        }
                        w56 d2 = d(threadData2);
                        if (d2 != null) {
                            d2.g = threadData2.getTid();
                            d2.position = i;
                            e(d2);
                        }
                        if (d2 != null && d2.isValid()) {
                            list2.add(d2);
                        }
                    }
                    i++;
                }
            }
        }
    }

    public final o56 c(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData)) == null) {
            if (threadData == null) {
                return null;
            }
            if (w56.W(threadData)) {
                w56 w56Var = new w56();
                threadData.isLinkThread();
                threadData.isSmartAppThreadType();
                if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                    threadData.isGodThread();
                }
                w56Var.a = threadData;
                return w56Var;
            } else if (!x56.R(threadData)) {
                return null;
            } else {
                return new x56(threadData);
            }
        }
        return (o56) invokeL.objValue;
    }

    public final void e(o56 o56Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, o56Var) == null) {
            if (o56Var instanceof w56) {
                ((w56) o56Var).A = true;
            } else if (o56Var instanceof x56) {
                ((x56) o56Var).A = true;
            } else if (o56Var instanceof v56) {
                ((v56) o56Var).A = true;
            }
            o56Var.setSupportType(BaseCardInfo.SupportType.BOTTOM);
        }
    }

    public void k(h08 h08Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, h08Var) != null) || h08Var == null) {
            return;
        }
        if (h08Var.l() != null) {
            str = h08Var.l().getFirst_class();
        } else {
            str = "";
        }
        List<ThreadInfo> K = h08Var.K();
        LinkedList linkedList = new LinkedList();
        b(K, linkedList, str);
        this.b.h(linkedList);
    }
}

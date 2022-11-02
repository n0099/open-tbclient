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
/* loaded from: classes3.dex */
public class c28 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public ty7 b;
    public n96 c;
    public View.OnTouchListener d;

    /* loaded from: classes3.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c28 a;

        public a(c28 c28Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c28Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c28Var;
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

    /* loaded from: classes3.dex */
    public class b extends nm5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g46 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(c28 c28Var, int i, String str, g46 g46Var) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c28Var, Integer.valueOf(i), str, g46Var};
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
            this.h = g46Var;
        }

        @Override // com.baidu.tieba.nm5, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                StatisticItem statisticItem = null;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(view2.getContext(), d(), null)));
                g46 g46Var = this.h;
                if (g46Var instanceof o46) {
                    statisticItem = ((o46) g46Var).S();
                } else if (g46Var instanceof p46) {
                    statisticItem = ((p46) g46Var).Q(null);
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public c28(BdTypeRecyclerView bdTypeRecyclerView, ty7 ty7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdTypeRecyclerView, ty7Var};
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
        this.b = ty7Var;
        bdTypeRecyclerView.setOnTouchListener(aVar);
        this.c = new n96();
    }

    public final o46 d(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData)) == null) {
            o46 o46Var = new o46();
            o46Var.a = threadData;
            threadData.isLinkThread();
            if (!threadData.isLinkThread()) {
                threadData.isGodThread();
            }
            return o46Var;
        }
        return (o46) invokeL.objValue;
    }

    public final void f(g46 g46Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, g46Var) == null) {
            g46Var.n = true;
            g46Var.setSupportType(BaseCardInfo.SupportType.TOP);
        }
    }

    public final void g(g46 g46Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, g46Var) == null) {
            ((o46) g46Var).q = true;
            g46Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public final void h(g46 g46Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, g46Var) == null) {
            ((o46) g46Var).p = true;
            g46Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public final void i(g46 g46Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, g46Var) == null) {
            ((o46) g46Var).r = true;
            g46Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public final void j(g46 g46Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, g46Var) == null) {
            ((p46) g46Var).s = true;
            g46Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public final void b(List<ThreadInfo> list, List<wn> list2, String str) {
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
                    if ((o46.W(threadData2) || p46.R(threadData2)) && threadData2.getType() != ThreadData.TYPE_SHARE_THREAD) {
                        o46 d = d(threadData2);
                        if (d != null && (threadData = d.a) != null && threadData.getForumData() != null && !StringUtils.isNull(threadData.getForumData().b)) {
                            d.g = threadData2.getTid();
                            d.position = i;
                            f(d);
                            list2.add(d);
                        }
                        int[] imageWidthAndHeight = threadData2.getImageWidthAndHeight();
                        g46 c = c(threadData2);
                        if (c != null) {
                            c.g = threadData2.getTid();
                            c.position = i;
                            if (c instanceof o46) {
                                if (threadData2.picCount() == 1) {
                                    h(c);
                                    c.j = imageWidthAndHeight[0];
                                    c.k = imageWidthAndHeight[1];
                                } else if (threadData2.picCount() >= 2) {
                                    g(c);
                                } else {
                                    i(c);
                                }
                            } else if (c instanceof p46) {
                                j(c);
                            }
                        }
                        if (c != null && c.isValid()) {
                            c.a.insertItemToTitleOrAbstractText();
                            if (!threadData2.isUgcThreadType() && threadData2.getAuthor() != null) {
                                String format = String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02ad), threadData2.getAuthor().getName_show());
                                SpannableString spannableString = new SpannableString(format);
                                spannableString.setSpan(new b(this, 16, threadData2.getAuthor().getUserId(), c), 0, format.length() - 1, 33);
                                c.a.insertUsernameIntoTitleOrAbstract(spannableString);
                            }
                            list2.add(c);
                        }
                        o46 d2 = d(threadData2);
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

    public final g46 c(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData)) == null) {
            if (threadData == null) {
                return null;
            }
            if (o46.W(threadData)) {
                o46 o46Var = new o46();
                threadData.isLinkThread();
                threadData.isSmartAppThreadType();
                if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                    threadData.isGodThread();
                }
                o46Var.a = threadData;
                return o46Var;
            } else if (!p46.R(threadData)) {
                return null;
            } else {
                return new p46(threadData);
            }
        }
        return (g46) invokeL.objValue;
    }

    public final void e(g46 g46Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, g46Var) == null) {
            if (g46Var instanceof o46) {
                ((o46) g46Var).A = true;
            } else if (g46Var instanceof p46) {
                ((p46) g46Var).A = true;
            } else if (g46Var instanceof n46) {
                ((n46) g46Var).A = true;
            }
            g46Var.setSupportType(BaseCardInfo.SupportType.BOTTOM);
        }
    }

    public void k(dx7 dx7Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, dx7Var) != null) || dx7Var == null) {
            return;
        }
        if (dx7Var.l() != null) {
            str = dx7Var.l().getFirst_class();
        } else {
            str = "";
        }
        List<ThreadInfo> K = dx7Var.K();
        LinkedList linkedList = new LinkedList();
        b(K, linkedList, str);
        this.b.h(linkedList);
    }
}

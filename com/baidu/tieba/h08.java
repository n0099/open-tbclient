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
public class h08 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public zw7 b;
    public w76 c;
    public View.OnTouchListener d;

    /* loaded from: classes4.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h08 a;

        public a(h08 h08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h08Var;
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
    public class b extends il5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p26 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(h08 h08Var, int i, String str, p26 p26Var) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h08Var, Integer.valueOf(i), str, p26Var};
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
            this.h = p26Var;
        }

        @Override // com.baidu.tieba.il5, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                StatisticItem statisticItem = null;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(view2.getContext(), d(), null)));
                p26 p26Var = this.h;
                if (p26Var instanceof x26) {
                    statisticItem = ((x26) p26Var).S();
                } else if (p26Var instanceof y26) {
                    statisticItem = ((y26) p26Var).Q(null);
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public h08(BdTypeRecyclerView bdTypeRecyclerView, zw7 zw7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdTypeRecyclerView, zw7Var};
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
        this.b = zw7Var;
        bdTypeRecyclerView.setOnTouchListener(aVar);
        this.c = new w76();
    }

    public final void b(List<ThreadInfo> list, List<Cdo> list2, String str) {
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
                        threadData2.getForumData().j = str;
                    }
                    if ((x26.W(threadData2) || y26.R(threadData2)) && threadData2.getType() != ThreadData.TYPE_SHARE_THREAD) {
                        x26 d = d(threadData2);
                        if (d != null && (threadData = d.a) != null && threadData.getForumData() != null && !StringUtils.isNull(threadData.getForumData().b)) {
                            d.g = threadData2.getTid();
                            d.position = i;
                            f(d);
                            list2.add(d);
                        }
                        int[] imageWidthAndHeight = threadData2.getImageWidthAndHeight();
                        p26 c = c(threadData2);
                        if (c != null) {
                            c.g = threadData2.getTid();
                            c.position = i;
                            if (c instanceof x26) {
                                if (threadData2.picCount() == 1) {
                                    h(c);
                                    c.j = imageWidthAndHeight[0];
                                    c.k = imageWidthAndHeight[1];
                                } else if (threadData2.picCount() >= 2) {
                                    g(c);
                                } else {
                                    i(c);
                                }
                            } else if (c instanceof y26) {
                                j(c);
                            }
                        }
                        if (c != null && c.isValid()) {
                            c.a.insertItemToTitleOrAbstractText();
                            if (!threadData2.isUgcThreadType() && threadData2.getAuthor() != null) {
                                String format = String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02ac), threadData2.getAuthor().getName_show());
                                SpannableString spannableString = new SpannableString(format);
                                spannableString.setSpan(new b(this, 16, threadData2.getAuthor().getUserId(), c), 0, format.length() - 1, 33);
                                c.a.insertUsernameIntoTitleOrAbstract(spannableString);
                            }
                            list2.add(c);
                        }
                        x26 d2 = d(threadData2);
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

    public final p26 c(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData)) == null) {
            if (threadData == null) {
                return null;
            }
            if (x26.W(threadData)) {
                x26 x26Var = new x26();
                threadData.isLinkThread();
                threadData.isSmartAppThreadType();
                if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                    threadData.isGodThread();
                }
                x26Var.a = threadData;
                return x26Var;
            } else if (y26.R(threadData)) {
                return new y26(threadData);
            } else {
                return null;
            }
        }
        return (p26) invokeL.objValue;
    }

    public final x26 d(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData)) == null) {
            x26 x26Var = new x26();
            x26Var.a = threadData;
            threadData.isLinkThread();
            if (!threadData.isLinkThread()) {
                threadData.isGodThread();
            }
            return x26Var;
        }
        return (x26) invokeL.objValue;
    }

    public final void e(p26 p26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, p26Var) == null) {
            if (p26Var instanceof x26) {
                ((x26) p26Var).A = true;
            } else if (p26Var instanceof y26) {
                ((y26) p26Var).A = true;
            } else if (p26Var instanceof w26) {
                ((w26) p26Var).A = true;
            }
            p26Var.setSupportType(BaseCardInfo.SupportType.BOTTOM);
        }
    }

    public final void f(p26 p26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, p26Var) == null) {
            p26Var.n = true;
            p26Var.setSupportType(BaseCardInfo.SupportType.TOP);
        }
    }

    public final void g(p26 p26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, p26Var) == null) {
            ((x26) p26Var).q = true;
            p26Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public final void h(p26 p26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, p26Var) == null) {
            ((x26) p26Var).p = true;
            p26Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public final void i(p26 p26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, p26Var) == null) {
            ((x26) p26Var).r = true;
            p26Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public final void j(p26 p26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, p26Var) == null) {
            ((y26) p26Var).s = true;
            p26Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public void k(jv7 jv7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, jv7Var) == null) || jv7Var == null) {
            return;
        }
        String first_class = jv7Var.l() != null ? jv7Var.l().getFirst_class() : "";
        List<ThreadInfo> I = jv7Var.I();
        LinkedList linkedList = new LinkedList();
        b(I, linkedList, first_class);
        this.b.h(linkedList);
    }
}

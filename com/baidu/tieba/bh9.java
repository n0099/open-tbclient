package com.baidu.tieba;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.foldcomment.FoldCommentActivity;
import com.baidu.tieba.pb.pb.sub.adapter.SubPbReplyAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class bh9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FoldCommentActivity a;
    public BdTypeListView b;
    public ok9 c;
    public qk9 d;
    public View.OnClickListener e;
    public View.OnClickListener f;
    public TbRichTextView.z g;
    public gg9 h;
    public View.OnLongClickListener i;
    public SubPbReplyAdapter j;
    public ch9 k;
    public List<ln> l;
    public ze9 m;
    public ArrayList<yn> n;

    public bh9(FoldCommentActivity foldCommentActivity, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {foldCommentActivity, bdTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = new ArrayList();
        this.n = new ArrayList<>();
        this.a = foldCommentActivity;
        this.b = bdTypeListView;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SubPbReplyAdapter subPbReplyAdapter = new SubPbReplyAdapter(this.a, om9.b);
            this.j = subPbReplyAdapter;
            subPbReplyAdapter.u(false);
            this.l.add(this.j);
            FoldCommentActivity foldCommentActivity = this.a;
            ch9 ch9Var = new ch9(foldCommentActivity, yca.X0, foldCommentActivity.getPageContext());
            this.k = ch9Var;
            ch9Var.e0(this.c);
            this.k.f0(this.d);
            this.k.h0(this.a);
            this.k.k(this.e);
            this.k.e(this.f);
            this.k.n(this.g);
            this.k.g0(this.h);
            this.k.d(this.i);
            this.l.add(this.k);
            this.b.addAdapters(this.l);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.b.getAdapter2() != null) {
            this.b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.f = onClickListener;
        }
    }

    public void d(boolean z) {
        ch9 ch9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && (ch9Var = this.k) != null) {
            ch9Var.setFromCDN(z);
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.e = onClickListener;
        }
    }

    public void f(boolean z) {
        ch9 ch9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && (ch9Var = this.k) != null) {
            ch9Var.d0(z);
        }
    }

    public void g(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, zVar) == null) {
            this.g = zVar;
        }
    }

    public void h(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onLongClickListener) == null) {
            this.i = onLongClickListener;
        }
    }

    public void j(ok9 ok9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, ok9Var) == null) {
            this.c = ok9Var;
        }
    }

    public void k(qk9 qk9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, qk9Var) == null) {
            this.d = qk9Var;
        }
    }

    public void l(gg9 gg9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, gg9Var) == null) {
            this.h = gg9Var;
        }
    }

    public void i(ze9 ze9Var) {
        ch9 ch9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ze9Var) == null) {
            this.m = ze9Var;
            ch9 ch9Var2 = this.k;
            if (ch9Var2 != null) {
                ch9Var2.r(ze9Var);
            }
            this.n.clear();
            ze9 ze9Var2 = this.m;
            if (ze9Var2 != null && ze9Var2.F() != null && this.m.F().size() > 0) {
                om9 om9Var = new om9();
                om9Var.b(ze9Var.F().size());
                this.n.add(om9Var);
                Iterator<yca> it = this.m.F().iterator();
                while (it.hasNext()) {
                    yca next = it.next();
                    if (next.getType() != yca.W0) {
                        this.n.add(next);
                    }
                }
            }
            if (ze9Var != null && ze9Var.N() != null && ze9Var.N().getAuthor() != null && (ch9Var = this.k) != null) {
                ch9Var.o(ze9Var.N().getAuthor().getUserId());
            }
            if (this.m != null) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_HAS_FOLD_ICON_SHOW);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.m.l());
                statisticItem.param("fname", this.m.m());
                statisticItem.param("tid", this.m.P());
                TiebaStatic.log(statisticItem);
            }
            this.b.setData(this.n);
            this.b.getAdapter2().notifyDataSetChanged();
        }
    }
}

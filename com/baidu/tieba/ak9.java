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
public class ak9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FoldCommentActivity a;
    public BdTypeListView b;
    public nn9 c;
    public pn9 d;
    public View.OnClickListener e;
    public View.OnClickListener f;
    public TbRichTextView.z g;
    public fj9 h;
    public View.OnLongClickListener i;
    public SubPbReplyAdapter j;
    public bk9 k;
    public List<om> l;
    public yh9 m;
    public ArrayList<bn> n;

    public ak9(FoldCommentActivity foldCommentActivity, BdTypeListView bdTypeListView) {
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
            SubPbReplyAdapter subPbReplyAdapter = new SubPbReplyAdapter(this.a, np9.b);
            this.j = subPbReplyAdapter;
            subPbReplyAdapter.u(false);
            this.l.add(this.j);
            FoldCommentActivity foldCommentActivity = this.a;
            bk9 bk9Var = new bk9(foldCommentActivity, zfa.W0, foldCommentActivity.getPageContext());
            this.k = bk9Var;
            bk9Var.e0(this.c);
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
        bk9 bk9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && (bk9Var = this.k) != null) {
            bk9Var.setFromCDN(z);
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.e = onClickListener;
        }
    }

    public void f(boolean z) {
        bk9 bk9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && (bk9Var = this.k) != null) {
            bk9Var.d0(z);
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

    public void j(nn9 nn9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, nn9Var) == null) {
            this.c = nn9Var;
        }
    }

    public void k(pn9 pn9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, pn9Var) == null) {
            this.d = pn9Var;
        }
    }

    public void l(fj9 fj9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, fj9Var) == null) {
            this.h = fj9Var;
        }
    }

    public void i(yh9 yh9Var) {
        bk9 bk9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, yh9Var) == null) {
            this.m = yh9Var;
            bk9 bk9Var2 = this.k;
            if (bk9Var2 != null) {
                bk9Var2.r(yh9Var);
            }
            this.n.clear();
            yh9 yh9Var2 = this.m;
            if (yh9Var2 != null && yh9Var2.F() != null && this.m.F().size() > 0) {
                np9 np9Var = new np9();
                np9Var.b(yh9Var.F().size());
                this.n.add(np9Var);
                Iterator<zfa> it = this.m.F().iterator();
                while (it.hasNext()) {
                    zfa next = it.next();
                    if (next.getType() != zfa.V0) {
                        this.n.add(next);
                    }
                }
            }
            if (yh9Var != null && yh9Var.O() != null && yh9Var.O().getAuthor() != null && (bk9Var = this.k) != null) {
                bk9Var.o(yh9Var.O().getAuthor().getUserId());
            }
            if (this.m != null) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_HAS_FOLD_ICON_SHOW);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.m.l());
                statisticItem.param("fname", this.m.m());
                statisticItem.param("tid", this.m.Q());
                TiebaStatic.log(statisticItem);
            }
            this.b.setData(this.n);
            this.b.getAdapter2().notifyDataSetChanged();
        }
    }
}

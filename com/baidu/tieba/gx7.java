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
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class gx7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FoldCommentActivity a;
    public BdTypeListView b;
    public q08 c;
    public s08 d;
    public View.OnClickListener e;
    public View.OnClickListener f;
    public TbRichTextView.y g;
    public lw7 h;
    public View.OnLongClickListener i;
    public SubPbReplyAdapter j;
    public hx7 k;
    public List<qn> l;
    public jv7 m;
    public ArrayList<Cdo> n;

    public gx7(FoldCommentActivity foldCommentActivity, BdTypeListView bdTypeListView) {
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
            SubPbReplyAdapter subPbReplyAdapter = new SubPbReplyAdapter(this.a, a28.b);
            this.j = subPbReplyAdapter;
            subPbReplyAdapter.u(false);
            this.l.add(this.j);
            FoldCommentActivity foldCommentActivity = this.a;
            hx7 hx7Var = new hx7(foldCommentActivity, PostData.L0, foldCommentActivity.getPageContext());
            this.k = hx7Var;
            hx7Var.d0(this.c);
            this.k.e0(this.d);
            this.k.g0(this.a);
            this.k.k(this.e);
            this.k.e(this.f);
            this.k.n(this.g);
            this.k.f0(this.h);
            this.k.d(this.i);
            this.l.add(this.k);
            this.b.a(this.l);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.b.getAdapter2() == null) {
            return;
        }
        this.b.getAdapter2().notifyDataSetChanged();
    }

    public void c(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.f = onClickListener;
        }
    }

    public void d(boolean z) {
        hx7 hx7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (hx7Var = this.k) == null) {
            return;
        }
        hx7Var.setFromCDN(z);
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.e = onClickListener;
        }
    }

    public void f(boolean z) {
        hx7 hx7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (hx7Var = this.k) == null) {
            return;
        }
        hx7Var.c0(z);
    }

    public void g(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, yVar) == null) {
            this.g = yVar;
        }
    }

    public void h(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onLongClickListener) == null) {
            this.i = onLongClickListener;
        }
    }

    public void i(jv7 jv7Var) {
        hx7 hx7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jv7Var) == null) {
            this.m = jv7Var;
            hx7 hx7Var2 = this.k;
            if (hx7Var2 != null) {
                hx7Var2.r(jv7Var);
            }
            this.n.clear();
            jv7 jv7Var2 = this.m;
            if (jv7Var2 != null && jv7Var2.F() != null && this.m.F().size() > 0) {
                a28 a28Var = new a28();
                a28Var.b(jv7Var.F().size());
                this.n.add(a28Var);
                Iterator<PostData> it = this.m.F().iterator();
                while (it.hasNext()) {
                    PostData next = it.next();
                    if (next.getType() != PostData.K0) {
                        this.n.add(next);
                    }
                }
            }
            if (jv7Var.O() != null && jv7Var.O().getAuthor() != null && (hx7Var = this.k) != null) {
                hx7Var.o(jv7Var.O().getAuthor().getUserId());
            }
            if (this.m != null) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_HAS_FOLD_ICON_SHOW);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.m.m());
                statisticItem.param("fname", this.m.n());
                statisticItem.param("tid", this.m.Q());
                TiebaStatic.log(statisticItem);
            }
            this.b.setData(this.n);
            this.b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void j(q08 q08Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, q08Var) == null) {
            this.c = q08Var;
        }
    }

    public void k(s08 s08Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, s08Var) == null) {
            this.d = s08Var;
        }
    }

    public void l(lw7 lw7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, lw7Var) == null) {
            this.h = lw7Var;
        }
    }
}

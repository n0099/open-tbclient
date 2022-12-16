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
public class e28 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FoldCommentActivity a;
    public BdTypeListView b;
    public p58 c;
    public r58 d;
    public View.OnClickListener e;
    public View.OnClickListener f;
    public TbRichTextView.y g;
    public j18 h;
    public View.OnLongClickListener i;
    public SubPbReplyAdapter j;
    public f28 k;
    public List<kn> l;
    public h08 m;
    public ArrayList<xn> n;

    public e28(FoldCommentActivity foldCommentActivity, BdTypeListView bdTypeListView) {
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
            SubPbReplyAdapter subPbReplyAdapter = new SubPbReplyAdapter(this.a, z68.b);
            this.j = subPbReplyAdapter;
            subPbReplyAdapter.u(false);
            this.l.add(this.j);
            FoldCommentActivity foldCommentActivity = this.a;
            f28 f28Var = new f28(foldCommentActivity, PostData.N0, foldCommentActivity.getPageContext());
            this.k = f28Var;
            f28Var.d0(this.c);
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
        f28 f28Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && (f28Var = this.k) != null) {
            f28Var.setFromCDN(z);
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.e = onClickListener;
        }
    }

    public void f(boolean z) {
        f28 f28Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && (f28Var = this.k) != null) {
            f28Var.c0(z);
        }
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

    public void j(p58 p58Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, p58Var) == null) {
            this.c = p58Var;
        }
    }

    public void k(r58 r58Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, r58Var) == null) {
            this.d = r58Var;
        }
    }

    public void l(j18 j18Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, j18Var) == null) {
            this.h = j18Var;
        }
    }

    public void i(h08 h08Var) {
        f28 f28Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, h08Var) == null) {
            this.m = h08Var;
            f28 f28Var2 = this.k;
            if (f28Var2 != null) {
                f28Var2.r(h08Var);
            }
            this.n.clear();
            h08 h08Var2 = this.m;
            if (h08Var2 != null && h08Var2.H() != null && this.m.H().size() > 0) {
                z68 z68Var = new z68();
                z68Var.b(h08Var.H().size());
                this.n.add(z68Var);
                Iterator<PostData> it = this.m.H().iterator();
                while (it.hasNext()) {
                    PostData next = it.next();
                    if (next.getType() != PostData.M0) {
                        this.n.add(next);
                    }
                }
            }
            if (h08Var.Q() != null && h08Var.Q().getAuthor() != null && (f28Var = this.k) != null) {
                f28Var.o(h08Var.Q().getAuthor().getUserId());
            }
            if (this.m != null) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_HAS_FOLD_ICON_SHOW);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.m.m());
                statisticItem.param("fname", this.m.n());
                statisticItem.param("tid", this.m.S());
                TiebaStatic.log(statisticItem);
            }
            this.b.setData(this.n);
            this.b.getAdapter2().notifyDataSetChanged();
        }
    }
}

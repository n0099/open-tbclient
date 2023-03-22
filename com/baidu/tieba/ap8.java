package com.baidu.tieba;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ap8 extends zo8<bc9, PbCommenFloorItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ThreadData c;
    public TbRichTextView.u d;
    public boolean e;
    public String f;
    public View.OnClickListener g;
    public TbRichTextView.a0 h;
    public mj8 i;
    public View.OnLongClickListener j;
    public vn8 k;
    public int l;
    public boolean m;
    public boolean n;
    public xf<ConstrainImageLayout> o;
    public xf<TbImageView> p;

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ ap8 b;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ bc9 a;
            public final /* synthetic */ e b;

            public a(e eVar, bc9 bc9Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, bc9Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = eVar;
                this.a = bc9Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    e eVar = this.b;
                    ap8 ap8Var = eVar.b;
                    ap8Var.k.b.a(null, ap8Var.c, this.a, eVar.a.q.getLayoutStrategy());
                }
            }
        }

        public e(ap8 ap8Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ap8Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ap8Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            bc9 bc9Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !(view2.getTag() instanceof SparseArray)) {
                return;
            }
            SparseArray sparseArray = (SparseArray) view2.getTag();
            if ((sparseArray.get(R.id.tag_load_sub_data) instanceof bc9) && (bc9Var = (bc9) sparseArray.get(R.id.tag_load_sub_data)) != null && this.a.c != null && this.b.k != null) {
                jg.a().postDelayed(new a(this, bc9Var), 100L);
                String id = this.b.c.getId();
                if (StringUtils.isNull(id) || "0".equals(id)) {
                    id = this.b.c.getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", id).param("fid", this.b.c.getFid()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", bc9Var.O()).param("obj_source", 1).param("obj_type", 4));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a implements yf<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ap8 a;

        public ConstrainImageLayout e(ConstrainImageLayout constrainImageLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, constrainImageLayout)) == null) ? constrainImageLayout : (ConstrainImageLayout) invokeL.objValue;
        }

        public ConstrainImageLayout h(ConstrainImageLayout constrainImageLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, constrainImageLayout)) == null) ? constrainImageLayout : (ConstrainImageLayout) invokeL.objValue;
        }

        public a(ap8 ap8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ap8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ap8Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.yf
        public /* bridge */ /* synthetic */ ConstrainImageLayout a(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            e(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.yf
        public /* bridge */ /* synthetic */ ConstrainImageLayout c(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            h(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yf
        /* renamed from: f */
        public void b(ConstrainImageLayout constrainImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, constrainImageLayout) == null) {
                constrainImageLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yf
        /* renamed from: g */
        public ConstrainImageLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return new ConstrainImageLayout(this.a.a.getPageContext().getPageActivity());
            }
            return (ConstrainImageLayout) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements yf<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ap8 a;

        public TbImageView e(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbImageView)) == null) ? tbImageView : (TbImageView) invokeL.objValue;
        }

        public b(ap8 ap8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ap8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ap8Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.yf
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.yf
        public /* bridge */ /* synthetic */ TbImageView c(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            h(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yf
        /* renamed from: f */
        public void b(TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, tbImageView) == null) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }
        }

        public TbImageView h(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, tbImageView)) == null) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
            return (TbImageView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yf
        /* renamed from: g */
        public TbImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                TbImageView tbImageView = new TbImageView(this.a.a.getPageContext().getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(SkinManager.getColor(R.color.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070198));
                return tbImageView;
            }
            return (TbImageView) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ ap8 b;

        public c(ap8 ap8Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ap8Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ap8Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            SparseArray sparseArray;
            bc9 bc9Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2 != null && (view2.getTag(R.id.tag_subpb_ban_display_keyboard) instanceof Boolean) && view2.getTag(R.id.tag_subpb_ban_display_keyboard) == Boolean.TRUE && this.a.getView() != null) {
                    this.a.getView().setTag(R.id.tag_subpb_ban_display_keyboard, Boolean.TRUE);
                }
                this.b.g.onClick(this.a.getView());
                if (view2 != null) {
                    view2.setTag(R.id.tag_subpb_ban_display_keyboard, null);
                }
                if (this.a.getView() != null) {
                    this.a.getView().setTag(R.id.tag_subpb_ban_display_keyboard, null);
                }
                if (this.a.getView() != null && (sparseArray = (SparseArray) this.a.getView().getTag(R.id.tag_from)) != null && (sparseArray.get(R.id.tag_clip_board) instanceof bc9) && (bc9Var = (bc9) sparseArray.get(R.id.tag_clip_board)) != null && bc9Var.r() != null && bc9Var.o() != null) {
                    yo8.a(bc9Var.o().threadId, TbadkCoreApplication.getCurrentAccount(), bc9Var.O());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ap8 a;

        public d(ap8 ap8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ap8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ap8Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (this.a.i != null) {
                    this.a.i.a(view2);
                    return this.a.i.onSingleTapConfirmed(motionEvent);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ ap8 b;

        public f(ap8 ap8Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ap8Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ap8Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.b.c != null && (pbCommenFloorItemViewHolder = this.a) != null && (agreeView = pbCommenFloorItemViewHolder.o) != null && agreeView.getData() != null) {
                if (view2 == this.a.o.getImgAgree()) {
                    i = 1;
                } else {
                    i = 2;
                }
                String id = this.b.c.getId();
                if (StringUtils.isNull(id) || "0".equals(id)) {
                    id = this.b.c.getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", id).param("fid", this.b.c.getFid()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.o.getData().postId).param("obj_source", 1).param("obj_type", i));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ap8(NewSubPbActivity newSubPbActivity, BdUniqueId bdUniqueId) {
        super(newSubPbActivity, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {newSubPbActivity, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((xj8) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = null;
        this.d = null;
        this.e = pv4.c().g();
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.n = false;
        this.o = new xf<>(new a(this), 6, 0);
        this.p = new xf<>(new b(this), 12, 0);
        if (newSubPbActivity != null && newSubPbActivity.M3() != null) {
            this.l = newSubPbActivity.M3().P0();
        }
    }

    public void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.n = z;
        }
    }

    public void H(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.m = z;
        }
    }

    public void I(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.f = str;
        }
    }

    public void J(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, threadData) == null) {
            this.c = threadData;
        }
    }

    public void d(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onLongClickListener) == null) {
            this.j = onLongClickListener;
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onClickListener) == null) {
            this.g = onClickListener;
        }
    }

    public void n(TbRichTextView.a0 a0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, a0Var) == null) {
            this.h = a0Var;
        }
    }

    public final void u(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.q.setTextViewOnTouchListener(this.i);
            pbCommenFloorItemViewHolder.q.setTextViewCheckSelection(false);
            pbCommenFloorItemViewHolder.s.setOnTouchListener(new d(this));
        }
    }

    public final void A(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, bc9 bc9Var, View view2, int i) {
        boolean z;
        String diplayIntro;
        boolean z2;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048576, this, pbCommenFloorItemViewHolder, bc9Var, view2, i) == null) && pbCommenFloorItemViewHolder != null && bc9Var != null) {
            pbCommenFloorItemViewHolder.f0 = i;
            xj8 xj8Var = this.a;
            ThreadData threadData = this.c;
            if (i == 0) {
                z = true;
            } else {
                z = false;
            }
            yj8.k(pbCommenFloorItemViewHolder, bc9Var, view2, i, xj8Var, threadData, z);
            yj8.f(pbCommenFloorItemViewHolder, bc9Var, this.c, i, bc9Var.h0);
            TextView textView = pbCommenFloorItemViewHolder.F0;
            if (StringUtils.isNull(bc9Var.r().getDiplayIntro())) {
                diplayIntro = "";
            } else {
                diplayIntro = bc9Var.r().getDiplayIntro();
            }
            textView.setText(diplayIntro);
            pbCommenFloorItemViewHolder.A.setVisibility(8);
            pbCommenFloorItemViewHolder.u.setVisibility(0);
            pbCommenFloorItemViewHolder.y.setVisibility(0);
            pbCommenFloorItemViewHolder.z.setVisibility(0);
            pbCommenFloorItemViewHolder.o.setVisibility(0);
            pbCommenFloorItemViewHolder.O.setVisibility(8);
            ImageView imageView = pbCommenFloorItemViewHolder.z;
            if (imageView != null) {
                if (bc9Var.h0) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                imageView.setVisibility(i2);
            }
            pbCommenFloorItemViewHolder.q.setTid(this.c.getTid());
            pbCommenFloorItemViewHolder.q.setPid(bc9Var.O());
            pbCommenFloorItemViewHolder.q.setPosition(TbRichTextView.Position.SUB_PB);
            xj8 xj8Var2 = this.a;
            boolean z3 = this.e;
            boolean z4 = this.b;
            if (i != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            yj8.g(xj8Var2, pbCommenFloorItemViewHolder, bc9Var, view2, z3, z4, z2, this.d);
            yj8.h(this.a, pbCommenFloorItemViewHolder, bc9Var, view2, this.c, bc9Var.h0);
            yj8.e(this.a, pbCommenFloorItemViewHolder, bc9Var, this.c);
            yj8.j(pbCommenFloorItemViewHolder, bc9Var);
            yj8.d(pbCommenFloorItemViewHolder, bc9Var, view2, this.e, null);
            z(pbCommenFloorItemViewHolder, bc9Var);
            yj8.i(pbCommenFloorItemViewHolder, view2, bc9Var, this.m, false);
            if (bc9Var.h0) {
                pbCommenFloorItemViewHolder.y.setVisibility(8);
                pbCommenFloorItemViewHolder.z.setVisibility(8);
                pbCommenFloorItemViewHolder.t0.setVisibility(0);
                WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.t0, R.drawable.icon_pure_pb_more18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                pbCommenFloorItemViewHolder.t0.setPadding(0, 0, 0, 0);
            } else {
                pbCommenFloorItemViewHolder.y.setVisibility(0);
                pbCommenFloorItemViewHolder.t0.setVisibility(8);
            }
            yj8.q(this.a.getPageContext(), pbCommenFloorItemViewHolder, bc9Var);
        }
    }

    public final void B(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, bc9 bc9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pbCommenFloorItemViewHolder, bc9Var) == null) && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.c != null) {
            if (StringHelper.equals(this.f, bc9Var.O())) {
                SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.c, R.color.CAM_X0313);
            } else {
                SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.c, R.color.CAM_X0205);
            }
        }
    }

    public final void C(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, bc9 bc9Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, pbCommenFloorItemViewHolder, bc9Var, i) == null) && pbCommenFloorItemViewHolder != null && bc9Var != null) {
            if (i == 0) {
                pbCommenFloorItemViewHolder.h(bc9Var.S, bc9Var.O(), this.n);
                return;
            }
            boolean z = true;
            if (bc9Var.s0 != 1) {
                z = false;
            }
            pbCommenFloorItemViewHolder.h(z, bc9Var.O(), this.n);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tm
    /* renamed from: D */
    public PbCommenFloorItemViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d0878, viewGroup, false);
            ((ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f0919fe)).addView(LayoutInflater.from(inflate.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0877, (ViewGroup) null));
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = new PbCommenFloorItemViewHolder(this.a.getPageContext(), inflate, this.l);
            pbCommenFloorItemViewHolder.g(true);
            pbCommenFloorItemViewHolder.t.setConstrainLayoutPool(this.o);
            pbCommenFloorItemViewHolder.t.setImageViewPool(this.p);
            x(pbCommenFloorItemViewHolder);
            yj8.o(pbCommenFloorItemViewHolder);
            return pbCommenFloorItemViewHolder;
        }
        return (PbCommenFloorItemViewHolder) invokeL.objValue;
    }

    public View E(int i, View view2, ViewGroup viewGroup, bc9 bc9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, bc9Var, pbCommenFloorItemViewHolder})) == null) {
            y(pbCommenFloorItemViewHolder, bc9Var, i);
            F(pbCommenFloorItemViewHolder);
            u(pbCommenFloorItemViewHolder);
            bc9 bc9Var2 = (bc9) getItem(i);
            if (bc9Var2 != null) {
                bc9Var2.o1();
                A(pbCommenFloorItemViewHolder, bc9Var2, view2, i);
                B(pbCommenFloorItemViewHolder, bc9Var);
                C(pbCommenFloorItemViewHolder, bc9Var, i);
            }
            yj8.o(pbCommenFloorItemViewHolder);
            View view3 = pbCommenFloorItemViewHolder.P;
            int i3 = 0;
            if (i == 0) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            view3.setVisibility(i2);
            pbCommenFloorItemViewHolder.F0.setVisibility((i != 0 || StringUtils.isNull(bc9Var2.r().getDiplayIntro())) ? 8 : 8);
            if (bc9Var2 != null && bc9Var2.r() != null && bc9Var2.o() != null) {
                yo8.b("2", String.valueOf(bc9Var2.o().threadId), TbadkCoreApplication.getCurrentAccount(), bc9Var2.O(), bc9Var2.K(), bc9Var2.L());
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void F(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.c.setOnLongClickListener(this.j);
            xj8 xj8Var = this.a;
            if (xj8Var != null && xj8Var.getPageContext().getOrignalPage() != null) {
                tn8 H0 = this.a.H0();
                if (H0 != null) {
                    pbCommenFloorItemViewHolder.g.setOnClickListener(H0.b);
                    pbCommenFloorItemViewHolder.p.setOnClickListener(H0.b);
                    pbCommenFloorItemViewHolder.L.setOnClickListener(H0.b);
                    pbCommenFloorItemViewHolder.L.getHeadView().setOnClickListener(H0.b);
                    pbCommenFloorItemViewHolder.q.setOnEmotionClickListener(H0.f);
                }
                pbCommenFloorItemViewHolder.q.setOnLongClickListener(this.j);
                pbCommenFloorItemViewHolder.q.setOnImageClickListener(this.h);
                pbCommenFloorItemViewHolder.q.setOnClickListener(this.g);
                pbCommenFloorItemViewHolder.getView().setOnClickListener(this.g);
                pbCommenFloorItemViewHolder.Q.setOnClickListener(this.g);
                pbCommenFloorItemViewHolder.R.setOnClickListener(this.g);
                pbCommenFloorItemViewHolder.T.setOnClickListener(this.g);
                pbCommenFloorItemViewHolder.s0.setOnClickListener(this.g);
                pbCommenFloorItemViewHolder.o0.setOnClickListener(this.g);
                if (this.k == null) {
                    this.k = new vn8(this.a.getPageContext());
                }
                pbCommenFloorItemViewHolder.y.setOnClickListener(this.g);
                pbCommenFloorItemViewHolder.z.setOnClickListener(new e(this, pbCommenFloorItemViewHolder));
                pbCommenFloorItemViewHolder.o.B = new f(this, pbCommenFloorItemViewHolder);
                pbCommenFloorItemViewHolder.t0.setOnClickListener(this.g);
            }
        }
    }

    @Override // com.baidu.tieba.zo8, com.baidu.tieba.tm
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        E(i, view2, viewGroup, (bc9) obj, (PbCommenFloorItemViewHolder) viewHolder);
        return view2;
    }

    public final void x(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, pbCommenFloorItemViewHolder) == null) {
            if (pbCommenFloorItemViewHolder.P.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                layoutParams = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.P.getLayoutParams();
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            }
            layoutParams.height = yj8.l(R.dimen.tbds2);
            layoutParams.leftMargin = yj8.l(R.dimen.tbds148);
            pbCommenFloorItemViewHolder.P.setLayoutParams(layoutParams);
            LinearLayout linearLayout = (LinearLayout) pbCommenFloorItemViewHolder.getView().findViewById(R.id.obfuscated_res_0x7f09110f);
            if (linearLayout.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                layoutParams2 = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
            } else {
                layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            }
            layoutParams2.leftMargin = yj8.l(R.dimen.tbds21);
            layoutParams2.rightMargin = yj8.l(R.dimen.tbds1);
            linearLayout.setLayoutParams(layoutParams2);
            pbCommenFloorItemViewHolder.q.setCommonTextViewOnClickListener(new c(this, pbCommenFloorItemViewHolder));
        }
    }

    public final void y(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, bc9 bc9Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048593, this, pbCommenFloorItemViewHolder, bc9Var, i) == null) {
            ImageView imageView = pbCommenFloorItemViewHolder.y;
            if (imageView != null) {
                SparseArray sparseArray = (SparseArray) imageView.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    pbCommenFloorItemViewHolder.y.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, bc9Var);
            }
            ImageView imageView2 = pbCommenFloorItemViewHolder.z;
            if (imageView2 != null) {
                SparseArray sparseArray2 = (SparseArray) imageView2.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    pbCommenFloorItemViewHolder.z.setTag(sparseArray2);
                }
                sparseArray2.put(R.id.tag_load_sub_data, bc9Var);
                sparseArray2.put(R.id.tag_is_subpb, Boolean.valueOf(!bc9Var.h0));
            }
        }
    }

    public final void z(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, bc9 bc9Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048594, this, pbCommenFloorItemViewHolder, bc9Var) == null) && pbCommenFloorItemViewHolder != null && bc9Var != null) {
            ImageView imageView = pbCommenFloorItemViewHolder.d0;
            if (bc9Var.b0) {
                i = 0;
            } else {
                i = 8;
            }
            imageView.setVisibility(i);
        }
    }
}

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
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class d48 extends c48<PostData, PbCommenFloorItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ThreadData c;
    public TbRichTextView.s d;
    public boolean e;
    public String f;
    public View.OnClickListener g;
    public TbRichTextView.y h;
    public qy7 i;
    public View.OnLongClickListener j;
    public y28 k;
    public int l;
    public boolean m;
    public boolean n;
    public og<ConstrainImageLayout> o;
    public og<TbImageView> p;

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ d48 b;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PostData a;
            public final /* synthetic */ e b;

            public a(e eVar, PostData postData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, postData};
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
                this.a = postData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    e eVar = this.b;
                    d48 d48Var = eVar.b;
                    d48Var.k.b.a(null, d48Var.c, this.a, eVar.a.q.getLayoutStrategy());
                }
            }
        }

        public e(d48 d48Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d48Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = d48Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PostData postData;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !(view2.getTag() instanceof SparseArray)) {
                return;
            }
            SparseArray sparseArray = (SparseArray) view2.getTag();
            if ((sparseArray.get(R.id.obfuscated_res_0x7f0920b1) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f0920b1)) != null && this.a.c != null && this.b.k != null) {
                ah.a().postDelayed(new a(this, postData), 100L);
                String id = this.b.c.getId();
                if (StringUtils.isNull(id) || "0".equals(id)) {
                    id = this.b.c.getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", id).param("fid", this.b.c.getFid()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData.M()).param("obj_source", 1).param("obj_type", 4));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a implements pg<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d48 a;

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

        public a(d48 d48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d48Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.pg
        public /* bridge */ /* synthetic */ ConstrainImageLayout a(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            e(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.pg
        public /* bridge */ /* synthetic */ ConstrainImageLayout c(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            h(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pg
        /* renamed from: f */
        public void b(ConstrainImageLayout constrainImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, constrainImageLayout) == null) {
                constrainImageLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pg
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
    public class b implements pg<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d48 a;

        public TbImageView e(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbImageView)) == null) ? tbImageView : (TbImageView) invokeL.objValue;
        }

        public b(d48 d48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d48Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.pg
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.pg
        public /* bridge */ /* synthetic */ TbImageView c(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            h(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pg
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
        @Override // com.baidu.tieba.pg
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
        public final /* synthetic */ d48 b;

        public c(d48 d48Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d48Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = d48Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            SparseArray sparseArray;
            PostData postData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2 != null && (view2.getTag(R.id.obfuscated_res_0x7f0920e1) instanceof Boolean) && view2.getTag(R.id.obfuscated_res_0x7f0920e1) == Boolean.TRUE && this.a.getView() != null) {
                    this.a.getView().setTag(R.id.obfuscated_res_0x7f0920e1, Boolean.TRUE);
                }
                this.b.g.onClick(this.a.getView());
                if (view2 != null) {
                    view2.setTag(R.id.obfuscated_res_0x7f0920e1, null);
                }
                if (this.a.getView() != null) {
                    this.a.getView().setTag(R.id.obfuscated_res_0x7f0920e1, null);
                }
                if (this.a.getView() != null && (sparseArray = (SparseArray) this.a.getView().getTag(R.id.obfuscated_res_0x7f0920a7)) != null && (sparseArray.get(R.id.obfuscated_res_0x7f092094) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f092094)) != null && postData.s() != null && postData.q() != null) {
                    b48.a(postData.q().threadId, TbadkCoreApplication.getCurrentAccount(), postData.M());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d48 a;

        public d(d48 d48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d48Var;
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
        public final /* synthetic */ d48 b;

        public f(d48 d48Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d48Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = d48Var;
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
    public d48(NewSubPbActivity newSubPbActivity, BdUniqueId bdUniqueId) {
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
                super((bz7) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = null;
        this.d = null;
        this.e = br4.c().g();
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.n = false;
        this.o = new og<>(new a(this), 6, 0);
        this.p = new og<>(new b(this), 12, 0);
        if (newSubPbActivity != null && newSubPbActivity.E3() != null) {
            this.l = newSubPbActivity.E3().x0();
        }
    }

    public void E(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.n = z;
        }
    }

    public void F(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.m = z;
        }
    }

    public void G(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f = str;
        }
    }

    public void H(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, threadData) == null) {
            this.c = threadData;
        }
    }

    public void d(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onLongClickListener) == null) {
            this.j = onLongClickListener;
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, onClickListener) == null) {
            this.g = onClickListener;
        }
    }

    public void n(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, yVar) == null) {
            this.h = yVar;
        }
    }

    public final void u(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.q.setTextViewOnTouchListener(this.i);
            pbCommenFloorItemViewHolder.q.setTextViewCheckSelection(false);
            pbCommenFloorItemViewHolder.s.setOnTouchListener(new d(this));
        }
    }

    public final void A(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048576, this, pbCommenFloorItemViewHolder, postData, i) == null) && pbCommenFloorItemViewHolder != null && postData != null) {
            if (i == 0) {
                pbCommenFloorItemViewHolder.h(postData.S, postData.M(), this.n);
                return;
            }
            boolean z = true;
            if (postData.r0 != 1) {
                z = false;
            }
            pbCommenFloorItemViewHolder.h(z, postData.M(), this.n);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: B */
    public PbCommenFloorItemViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d0820, viewGroup, false);
            ((ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f0918ab)).addView(LayoutInflater.from(inflate.getContext()).inflate(R.layout.obfuscated_res_0x7f0d081f, (ViewGroup) null));
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = new PbCommenFloorItemViewHolder(this.a.getPageContext(), inflate, this.l);
            pbCommenFloorItemViewHolder.g(true);
            pbCommenFloorItemViewHolder.t.setConstrainLayoutPool(this.o);
            pbCommenFloorItemViewHolder.t.setImageViewPool(this.p);
            v(pbCommenFloorItemViewHolder);
            cz7.o(pbCommenFloorItemViewHolder);
            return pbCommenFloorItemViewHolder;
        }
        return (PbCommenFloorItemViewHolder) invokeL.objValue;
    }

    public View C(int i, View view2, ViewGroup viewGroup, PostData postData, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, postData, pbCommenFloorItemViewHolder})) == null) {
            w(pbCommenFloorItemViewHolder, postData, i);
            D(pbCommenFloorItemViewHolder);
            u(pbCommenFloorItemViewHolder);
            PostData postData2 = (PostData) getItem(i);
            if (postData2 != null) {
                postData2.l1();
                y(pbCommenFloorItemViewHolder, postData2, view2, i);
                z(pbCommenFloorItemViewHolder, postData);
                A(pbCommenFloorItemViewHolder, postData, i);
            }
            cz7.o(pbCommenFloorItemViewHolder);
            View view3 = pbCommenFloorItemViewHolder.P;
            int i3 = 0;
            if (i == 0) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            view3.setVisibility(i2);
            pbCommenFloorItemViewHolder.F0.setVisibility((i != 0 || StringUtils.isNull(postData2.s().getDiplayIntro())) ? 8 : 8);
            if (postData2 != null && postData2.s() != null && postData2.q() != null) {
                b48.b("2", String.valueOf(postData2.q().threadId), TbadkCoreApplication.getCurrentAccount(), postData2.M(), postData2.I(), postData2.J());
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void D(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.c.setOnLongClickListener(this.j);
            bz7 bz7Var = this.a;
            if (bz7Var != null && bz7Var.getPageContext().getOrignalPage() != null) {
                w28 y0 = this.a.y0();
                if (y0 != null) {
                    pbCommenFloorItemViewHolder.g.setOnClickListener(y0.b);
                    pbCommenFloorItemViewHolder.p.setOnClickListener(y0.b);
                    pbCommenFloorItemViewHolder.L.setOnClickListener(y0.b);
                    pbCommenFloorItemViewHolder.L.getHeadView().setOnClickListener(y0.b);
                    pbCommenFloorItemViewHolder.q.setOnEmotionClickListener(y0.f);
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
                    this.k = new y28(this.a.getPageContext());
                }
                pbCommenFloorItemViewHolder.y.setOnClickListener(this.g);
                pbCommenFloorItemViewHolder.z.setOnClickListener(new e(this, pbCommenFloorItemViewHolder));
                pbCommenFloorItemViewHolder.o.A = new f(this, pbCommenFloorItemViewHolder);
                pbCommenFloorItemViewHolder.t0.setOnClickListener(this.g);
            }
        }
    }

    @Override // com.baidu.tieba.c48, com.baidu.tieba.kn
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        C(i, view2, viewGroup, (PostData) obj, (PbCommenFloorItemViewHolder) viewHolder);
        return view2;
    }

    public final void v(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, pbCommenFloorItemViewHolder) == null) {
            if (pbCommenFloorItemViewHolder.P.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                layoutParams = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.P.getLayoutParams();
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            }
            layoutParams.height = cz7.l(R.dimen.tbds2);
            layoutParams.leftMargin = cz7.l(R.dimen.tbds148);
            pbCommenFloorItemViewHolder.P.setLayoutParams(layoutParams);
            LinearLayout linearLayout = (LinearLayout) pbCommenFloorItemViewHolder.getView().findViewById(R.id.obfuscated_res_0x7f090fda);
            if (linearLayout.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                layoutParams2 = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
            } else {
                layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            }
            layoutParams2.leftMargin = cz7.l(R.dimen.tbds21);
            layoutParams2.rightMargin = cz7.l(R.dimen.tbds1);
            linearLayout.setLayoutParams(layoutParams2);
            pbCommenFloorItemViewHolder.q.setCommonTextViewOnClickListener(new c(this, pbCommenFloorItemViewHolder));
        }
    }

    public final void w(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048591, this, pbCommenFloorItemViewHolder, postData, i) == null) {
            ImageView imageView = pbCommenFloorItemViewHolder.y;
            if (imageView != null) {
                SparseArray sparseArray = (SparseArray) imageView.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    pbCommenFloorItemViewHolder.y.setTag(sparseArray);
                }
                sparseArray.put(R.id.obfuscated_res_0x7f0920b1, postData);
            }
            ImageView imageView2 = pbCommenFloorItemViewHolder.z;
            if (imageView2 != null) {
                SparseArray sparseArray2 = (SparseArray) imageView2.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    pbCommenFloorItemViewHolder.z.setTag(sparseArray2);
                }
                sparseArray2.put(R.id.obfuscated_res_0x7f0920b1, postData);
                sparseArray2.put(R.id.obfuscated_res_0x7f0920ad, Boolean.valueOf(!postData.h0));
            }
        }
    }

    public final void x(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048592, this, pbCommenFloorItemViewHolder, postData) == null) && pbCommenFloorItemViewHolder != null && postData != null) {
            ImageView imageView = pbCommenFloorItemViewHolder.d0;
            if (postData.b0) {
                i = 0;
            } else {
                i = 8;
            }
            imageView.setVisibility(i);
        }
    }

    public final void y(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view2, int i) {
        boolean z;
        String diplayIntro;
        boolean z2;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048593, this, pbCommenFloorItemViewHolder, postData, view2, i) == null) && pbCommenFloorItemViewHolder != null && postData != null) {
            pbCommenFloorItemViewHolder.f0 = i;
            bz7 bz7Var = this.a;
            ThreadData threadData = this.c;
            if (i == 0) {
                z = true;
            } else {
                z = false;
            }
            cz7.k(pbCommenFloorItemViewHolder, postData, view2, i, bz7Var, threadData, z);
            cz7.f(pbCommenFloorItemViewHolder, postData, this.c, i, postData.h0);
            TextView textView = pbCommenFloorItemViewHolder.F0;
            if (StringUtils.isNull(postData.s().getDiplayIntro())) {
                diplayIntro = "";
            } else {
                diplayIntro = postData.s().getDiplayIntro();
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
                if (postData.h0) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                imageView.setVisibility(i2);
            }
            bz7 bz7Var2 = this.a;
            boolean z3 = this.e;
            boolean z4 = this.b;
            if (i != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            cz7.g(bz7Var2, pbCommenFloorItemViewHolder, postData, view2, z3, z4, z2, this.d);
            cz7.h(this.a, pbCommenFloorItemViewHolder, postData, view2, this.c, postData.h0);
            cz7.e(this.a, pbCommenFloorItemViewHolder, postData, this.c);
            cz7.j(pbCommenFloorItemViewHolder, postData);
            cz7.d(pbCommenFloorItemViewHolder, postData, view2, this.e, null);
            x(pbCommenFloorItemViewHolder, postData);
            cz7.i(pbCommenFloorItemViewHolder, view2, postData, this.m, false);
            if (postData.h0) {
                pbCommenFloorItemViewHolder.y.setVisibility(8);
                pbCommenFloorItemViewHolder.z.setVisibility(8);
                pbCommenFloorItemViewHolder.t0.setVisibility(0);
                WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.t0, R.drawable.obfuscated_res_0x7f0809a2, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                pbCommenFloorItemViewHolder.t0.setPadding(0, 0, 0, 0);
            } else {
                pbCommenFloorItemViewHolder.y.setVisibility(0);
                pbCommenFloorItemViewHolder.t0.setVisibility(8);
            }
            cz7.q(this.a.getPageContext(), pbCommenFloorItemViewHolder, postData);
        }
    }

    public final void z(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048594, this, pbCommenFloorItemViewHolder, postData) == null) && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.c != null) {
            if (StringHelper.equals(this.f, postData.M())) {
                SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.c, R.color.CAM_X0313);
            } else {
                SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.c, R.color.CAM_X0205);
            }
        }
    }
}

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
import com.baidu.adp.lib.safe.SafeHandler;
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
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class br9 extends ar9<tha, PbCommenFloorItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ThreadData c;
    public TbRichTextView.t d;
    public boolean e;
    public String f;
    public View.OnClickListener g;
    public TbRichTextView.z h;
    public vk9 i;
    public View.OnLongClickListener j;
    public gp9 k;
    public int l;
    public boolean m;
    public boolean n;
    public bg<ConstrainImageLayout> o;
    public bg<TbImageView> p;

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ br9 b;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ tha a;
            public final /* synthetic */ g b;

            public a(g gVar, tha thaVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar, thaVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = gVar;
                this.a = thaVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    g gVar = this.b;
                    br9 br9Var = gVar.b;
                    br9Var.k.b.a(null, br9Var.c, this.a, gVar.a.q.getLayoutStrategy());
                }
            }
        }

        public g(br9 br9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {br9Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = br9Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            tha thaVar;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !(view2.getTag() instanceof SparseArray)) {
                return;
            }
            SparseArray sparseArray = (SparseArray) view2.getTag();
            if ((sparseArray.get(R.id.tag_load_sub_data) instanceof tha) && (thaVar = (tha) sparseArray.get(R.id.tag_load_sub_data)) != null && this.a.c != null && this.b.k != null) {
                SafeHandler.getInst().postDelayed(new a(this, thaVar), 100L);
                String id = this.b.c.getId();
                if (StringUtils.isNull(id) || "0".equals(id)) {
                    id = this.b.c.getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", id).param("fid", this.b.c.getFid()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", thaVar.U()).param("obj_source", 1).param("obj_type", 4));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements cg<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ br9 a;

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

        public a(br9 br9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {br9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = br9Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.cg
        public /* bridge */ /* synthetic */ ConstrainImageLayout a(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            e(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.cg
        public /* bridge */ /* synthetic */ ConstrainImageLayout c(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            h(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cg
        /* renamed from: f */
        public void b(ConstrainImageLayout constrainImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, constrainImageLayout) == null) {
                constrainImageLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cg
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

    /* loaded from: classes5.dex */
    public class b implements cg<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ br9 a;

        public TbImageView e(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbImageView)) == null) ? tbImageView : (TbImageView) invokeL.objValue;
        }

        public b(br9 br9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {br9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = br9Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.cg
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.cg
        public /* bridge */ /* synthetic */ TbImageView c(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            h(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cg
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
        @Override // com.baidu.tieba.cg
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

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ br9 b;

        public c(br9 br9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {br9Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = br9Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            SparseArray sparseArray;
            tha thaVar;
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
                if (this.a.getView() != null && (sparseArray = (SparseArray) this.a.getView().getTag(R.id.tag_from)) != null && (sparseArray.get(R.id.tag_clip_board) instanceof tha) && (thaVar = (tha) sparseArray.get(R.id.tag_clip_board)) != null && thaVar.t() != null && thaVar.p() != null) {
                    zq9.a(thaVar.p().threadId, TbadkCoreApplication.getCurrentAccount(), thaVar.U());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ String b;

        public d(br9 br9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {br9Var, pbCommenFloorItemViewHolder, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbCommenFloorItemViewHolder;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int measuredWidth = this.a.f.getMeasuredWidth();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.a.F);
                arrayList.add(this.a.i);
                arrayList.add(this.a.x0);
                arrayList.add(this.a.D);
                String str = this.b;
                PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = this.a;
                jy5.c(measuredWidth, str, pbCommenFloorItemViewHolder.g, pbCommenFloorItemViewHolder.D, arrayList, pbCommenFloorItemViewHolder.G);
                PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder2 = this.a;
                ly5.a(pbCommenFloorItemViewHolder2.g, pbCommenFloorItemViewHolder2.F, pbCommenFloorItemViewHolder2.j, pbCommenFloorItemViewHolder2.D, pbCommenFloorItemViewHolder2.G, 1);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ br9 a;

        public e(br9 br9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {br9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = br9Var;
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

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ br9 a;

        public f(br9 br9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {br9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = br9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ky5.d(String.valueOf(this.a.c.getFid()), this.a.c.getAuthor().getPortrait(), "4", this.a.mContext.getApplicationContext());
                ly5.c("c15281", String.valueOf(this.a.c.getFid()), "4");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ br9 b;

        public h(br9 br9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {br9Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = br9Var;
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
    public br9(NewSubPbActivity newSubPbActivity, BdUniqueId bdUniqueId) {
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
                super((gl9) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = null;
        this.d = null;
        this.e = m05.c().g();
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.n = false;
        this.o = new bg<>(new a(this), 6, 0);
        this.p = new bg<>(new b(this), 12, 0);
        if (newSubPbActivity != null && newSubPbActivity.F3() != null) {
            this.l = newSubPbActivity.F3().I0();
        }
    }

    public void H(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.n = z;
        }
    }

    public void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.m = z;
        }
    }

    public void J(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f = str;
        }
    }

    public void K(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, threadData) == null) {
            this.c = threadData;
        }
    }

    public void d(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onLongClickListener) == null) {
            this.j = onLongClickListener;
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onClickListener) == null) {
            this.g = onClickListener;
        }
    }

    public void n(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, zVar) == null) {
            this.h = zVar;
        }
    }

    public final void x(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.q.setTextViewOnTouchListener(this.i);
            pbCommenFloorItemViewHolder.q.setTextViewCheckSelection(false);
            pbCommenFloorItemViewHolder.s.setOnTouchListener(new e(this));
        }
    }

    public final void A(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, pbCommenFloorItemViewHolder, thaVar) == null) && pbCommenFloorItemViewHolder != null && thaVar != null) {
            ImageView imageView = pbCommenFloorItemViewHolder.W;
            if (thaVar.d0) {
                i = 0;
            } else {
                i = 8;
            }
            imageView.setVisibility(i);
        }
    }

    public final void B(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar, View view2, int i) {
        boolean z;
        String diplayIntro;
        boolean z2;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pbCommenFloorItemViewHolder, thaVar, view2, i) == null) && pbCommenFloorItemViewHolder != null && thaVar != null) {
            pbCommenFloorItemViewHolder.Y = i;
            gl9 gl9Var = this.a;
            ThreadData threadData = this.c;
            if (i == 0) {
                z = true;
            } else {
                z = false;
            }
            hl9.q(pbCommenFloorItemViewHolder, thaVar, view2, i, gl9Var, threadData, z);
            hl9.l(pbCommenFloorItemViewHolder, thaVar, this.c, i, thaVar.j0);
            TextView textView = pbCommenFloorItemViewHolder.z0;
            String str = "";
            if (StringUtils.isNull(thaVar.t().getDiplayIntro())) {
                diplayIntro = "";
            } else {
                diplayIntro = thaVar.t().getDiplayIntro();
            }
            textView.setText(diplayIntro);
            pbCommenFloorItemViewHolder.A.setVisibility(8);
            pbCommenFloorItemViewHolder.u.setVisibility(0);
            pbCommenFloorItemViewHolder.y.setVisibility(0);
            pbCommenFloorItemViewHolder.z.setVisibility(0);
            pbCommenFloorItemViewHolder.o.setVisibility(0);
            pbCommenFloorItemViewHolder.H.setVisibility(8);
            ImageView imageView = pbCommenFloorItemViewHolder.z;
            if (imageView != null) {
                if (thaVar.j0) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                imageView.setVisibility(i2);
            }
            pbCommenFloorItemViewHolder.q.setTid(this.c.getTid());
            pbCommenFloorItemViewHolder.q.setPid(thaVar.U());
            pbCommenFloorItemViewHolder.q.setPosition(TbRichTextView.Position.SUB_PB);
            gl9 gl9Var2 = this.a;
            boolean z3 = this.e;
            boolean z4 = this.b;
            if (i != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            hl9.m(gl9Var2, pbCommenFloorItemViewHolder, thaVar, view2, z3, z4, z2, this.d);
            hl9.n(this.a, pbCommenFloorItemViewHolder, thaVar, view2, this.c, thaVar.j0);
            hl9.k(this.a, pbCommenFloorItemViewHolder, thaVar, this.c);
            hl9.p(pbCommenFloorItemViewHolder, thaVar);
            hl9.j(pbCommenFloorItemViewHolder, thaVar, view2, this.e, null);
            A(pbCommenFloorItemViewHolder, thaVar);
            hl9.o(pbCommenFloorItemViewHolder, view2, thaVar, this.m, false);
            if (thaVar.j0) {
                pbCommenFloorItemViewHolder.y.setVisibility(8);
                pbCommenFloorItemViewHolder.z.setVisibility(8);
                pbCommenFloorItemViewHolder.n0.setVisibility(0);
                WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.n0, R.drawable.icon_pure_pb_more18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                pbCommenFloorItemViewHolder.n0.setPadding(0, 0, 0, 0);
            } else {
                pbCommenFloorItemViewHolder.y.setVisibility(0);
                pbCommenFloorItemViewHolder.n0.setVisibility(8);
            }
            if (thaVar.t() != null) {
                str = thaVar.t().getName_show();
            }
            pbCommenFloorItemViewHolder.g.setText(str);
            pbCommenFloorItemViewHolder.f.post(new d(this, pbCommenFloorItemViewHolder, str));
        }
    }

    public final void C(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, pbCommenFloorItemViewHolder, thaVar) == null) && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.c != null) {
            if (StringHelper.equals(this.f, thaVar.U())) {
                SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.c, R.color.CAM_X0313);
            } else {
                SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.c, R.color.CAM_X0205);
            }
        }
    }

    public final void D(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048579, this, pbCommenFloorItemViewHolder, thaVar, i) == null) && pbCommenFloorItemViewHolder != null && thaVar != null) {
            if (i == 0) {
                pbCommenFloorItemViewHolder.h(thaVar.f1164T, thaVar.U(), this.n);
                return;
            }
            boolean z = true;
            if (thaVar.u0 != 1) {
                z = false;
            }
            pbCommenFloorItemViewHolder.h(z, thaVar.U(), this.n);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: E */
    public PbCommenFloorItemViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d091e, viewGroup, false);
            ((ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f091b51)).addView(LayoutInflater.from(inflate.getContext()).inflate(R.layout.obfuscated_res_0x7f0d091d, (ViewGroup) null));
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = new PbCommenFloorItemViewHolder(this.a.getPageContext(), inflate, this.l);
            pbCommenFloorItemViewHolder.g(true);
            pbCommenFloorItemViewHolder.t.setConstrainLayoutPool(this.o);
            pbCommenFloorItemViewHolder.t.setImageViewPool(this.p);
            y(pbCommenFloorItemViewHolder);
            hl9.v(pbCommenFloorItemViewHolder);
            return pbCommenFloorItemViewHolder;
        }
        return (PbCommenFloorItemViewHolder) invokeL.objValue;
    }

    public View F(int i, View view2, ViewGroup viewGroup, tha thaVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, thaVar, pbCommenFloorItemViewHolder})) == null) {
            z(pbCommenFloorItemViewHolder, thaVar, i);
            G(pbCommenFloorItemViewHolder);
            x(pbCommenFloorItemViewHolder);
            tha thaVar2 = (tha) getItem(i);
            if (thaVar2 != null) {
                thaVar2.C1();
                B(pbCommenFloorItemViewHolder, thaVar2, view2, i);
                C(pbCommenFloorItemViewHolder, thaVar);
                D(pbCommenFloorItemViewHolder, thaVar, i);
            }
            hl9.v(pbCommenFloorItemViewHolder);
            View view3 = pbCommenFloorItemViewHolder.I;
            int i3 = 0;
            if (i == 0) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            view3.setVisibility(i2);
            pbCommenFloorItemViewHolder.z0.setVisibility((i != 0 || StringUtils.isNull(thaVar2.t().getDiplayIntro())) ? 8 : 8);
            if (thaVar2 != null && thaVar2.t() != null && thaVar2.p() != null) {
                zq9.b("2", String.valueOf(thaVar2.p().threadId), TbadkCoreApplication.getCurrentAccount(), thaVar2.U(), thaVar2.Q(), thaVar2.R());
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void G(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.c.setOnLongClickListener(this.j);
            gl9 gl9Var = this.a;
            if (gl9Var != null && gl9Var.getPageContext().getOrignalPage() != 0) {
                ep9 S0 = this.a.S0();
                if (S0 != null) {
                    pbCommenFloorItemViewHolder.g.setOnClickListener(S0.b);
                    pbCommenFloorItemViewHolder.p.setOnClickListener(S0.b);
                    pbCommenFloorItemViewHolder.E.setOnClickListener(S0.b);
                    pbCommenFloorItemViewHolder.E.getHeadView().setOnClickListener(S0.b);
                    pbCommenFloorItemViewHolder.q.setOnEmotionClickListener(S0.f);
                }
                pbCommenFloorItemViewHolder.q.setOnLongClickListener(this.j);
                pbCommenFloorItemViewHolder.q.setOnImageClickListener(this.h);
                pbCommenFloorItemViewHolder.q.setOnClickListener(this.g);
                pbCommenFloorItemViewHolder.getView().setOnClickListener(this.g);
                pbCommenFloorItemViewHolder.J.setOnClickListener(this.g);
                pbCommenFloorItemViewHolder.K.setOnClickListener(this.g);
                pbCommenFloorItemViewHolder.M.setOnClickListener(this.g);
                pbCommenFloorItemViewHolder.l0.setOnClickListener(this.g);
                pbCommenFloorItemViewHolder.h0.setOnClickListener(this.g);
                if (this.k == null) {
                    this.k = new gp9(this.a.getPageContext());
                }
                pbCommenFloorItemViewHolder.D.setOnClickListener(new f(this));
                pbCommenFloorItemViewHolder.y.setOnClickListener(this.g);
                pbCommenFloorItemViewHolder.z.setOnClickListener(new g(this, pbCommenFloorItemViewHolder));
                pbCommenFloorItemViewHolder.o.D = new h(this, pbCommenFloorItemViewHolder);
                pbCommenFloorItemViewHolder.n0.setOnClickListener(this.g);
            }
        }
    }

    @Override // com.baidu.tieba.ar9, com.baidu.tieba.pm
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        F(i, view2, viewGroup, (tha) obj, (PbCommenFloorItemViewHolder) viewHolder);
        return view2;
    }

    public final void y(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, pbCommenFloorItemViewHolder) == null) {
            if (pbCommenFloorItemViewHolder.I.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                layoutParams = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.I.getLayoutParams();
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            }
            layoutParams.height = hl9.r(R.dimen.tbds2);
            layoutParams.leftMargin = hl9.r(R.dimen.tbds148);
            pbCommenFloorItemViewHolder.I.setLayoutParams(layoutParams);
            LinearLayout linearLayout = (LinearLayout) pbCommenFloorItemViewHolder.getView().findViewById(R.id.obfuscated_res_0x7f0911bd);
            if (linearLayout.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                layoutParams2 = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
            } else {
                layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            }
            layoutParams2.leftMargin = hl9.r(R.dimen.tbds21);
            layoutParams2.rightMargin = hl9.r(R.dimen.tbds1);
            linearLayout.setLayoutParams(layoutParams2);
            pbCommenFloorItemViewHolder.q.setCommonTextViewOnClickListener(new c(this, pbCommenFloorItemViewHolder));
        }
    }

    public final void z(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048594, this, pbCommenFloorItemViewHolder, thaVar, i) == null) {
            ImageView imageView = pbCommenFloorItemViewHolder.y;
            if (imageView != null) {
                SparseArray sparseArray = (SparseArray) imageView.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    pbCommenFloorItemViewHolder.y.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, thaVar);
            }
            ImageView imageView2 = pbCommenFloorItemViewHolder.z;
            if (imageView2 != null) {
                SparseArray sparseArray2 = (SparseArray) imageView2.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    pbCommenFloorItemViewHolder.z.setTag(sparseArray2);
                }
                sparseArray2.put(R.id.tag_load_sub_data, thaVar);
                sparseArray2.put(R.id.tag_is_subpb, Boolean.valueOf(!thaVar.j0));
            }
        }
    }
}

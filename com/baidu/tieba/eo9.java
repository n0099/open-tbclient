package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.vk9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class eo9 extends lm9<tha, PbCommenFloorItemViewHolder> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public vk9 A;
    public int g;
    public TbRichTextView.t h;
    public boolean i;
    public float j;
    public String k;
    public aj9 l;
    public View.OnClickListener m;
    public View.OnClickListener n;
    public TbRichTextView.z o;
    public vk9 p;
    public View.OnLongClickListener q;
    public wq9 r;
    public int s;
    public boolean t;
    public boolean u;
    public int v;
    public boolean w;
    public boolean x;
    public bg<ConstrainImageLayout> y;
    public bg<TbImageView> z;

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, view2) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ gp9 b;
        public final /* synthetic */ eo9 c;

        /* renamed from: com.baidu.tieba.eo9$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0270a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ tha a;
            public final /* synthetic */ a b;

            public RunnableC0270a(a aVar, tha thaVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, thaVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = thaVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    a aVar = this.b;
                    aVar.b.b.a(aVar.c.l, null, this.a, aVar.a.q.getLayoutStrategy());
                }
            }
        }

        public a(eo9 eo9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, gp9 gp9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eo9Var, pbCommenFloorItemViewHolder, gp9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = eo9Var;
            this.a = pbCommenFloorItemViewHolder;
            this.b = gp9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            tha thaVar;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !(view2.getTag() instanceof SparseArray)) {
                return;
            }
            SparseArray sparseArray = (SparseArray) view2.getTag();
            if ((sparseArray.get(R.id.tag_load_sub_data) instanceof tha) && (thaVar = (tha) sparseArray.get(R.id.tag_load_sub_data)) != null && this.a.c != null && this.b != null) {
                SafeHandler.getInst().postDelayed(new RunnableC0270a(this, thaVar), 100L);
                String Q = this.c.l.Q();
                if ((StringUtils.isNull(Q) || "0".equals(this.c.l.Q())) && this.c.l.O() != null) {
                    Q = this.c.l.O().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", Q).param("fid", this.c.l.l()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", thaVar.U()).param("obj_source", this.c.f0(view2)).param("obj_type", 4));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ eo9 b;

        public b(eo9 eo9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eo9Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = eo9Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.b.l != null && (pbCommenFloorItemViewHolder = this.a) != null && (agreeView = pbCommenFloorItemViewHolder.o) != null && agreeView.getData() != null) {
                if (view2 == this.a.o.getImgAgree()) {
                    i = 1;
                } else {
                    i = 2;
                }
                String Q = this.b.l.Q();
                if ((StringUtils.isNull(Q) || "0".equals(this.b.l.Q())) && this.b.l.O() != null) {
                    Q = this.b.l.O().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", Q).param("fid", this.b.l.l()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.o.getData().postId).param("obj_source", this.b.f0(this.a.o)).param("obj_type", i));
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                statisticItem.param("fid", this.b.l.l());
                statisticItem.param("tid", this.b.l.Q());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("post_id", this.b.l.i().U());
                statisticItem.param("obj_source", 1);
                statisticItem.param("obj_type", 1);
                statisticItem.param("obj_locate", this.b.e0());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ eo9 b;

        public c(eo9 eo9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eo9Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = eo9Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.b.l != null && (pbCommenFloorItemViewHolder = this.a) != null && (agreeView = pbCommenFloorItemViewHolder.c0) != null && agreeView.getData() != null) {
                if (view2 == this.a.c0.getImgAgree()) {
                    i = 1;
                } else {
                    i = 2;
                }
                String Q = this.b.l.Q();
                if ((StringUtils.isNull(Q) || "0".equals(this.b.l.Q())) && this.b.l.O() != null) {
                    Q = this.b.l.O().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", Q).param("fid", this.b.l.l()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.c0.getData().postId).param("obj_source", this.b.f0(this.a.c0)).param("obj_type", i));
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                statisticItem.param("fid", this.b.l.l());
                statisticItem.param("tid", this.b.l.Q());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("post_id", this.b.l.i().U());
                statisticItem.param("obj_source", 1);
                statisticItem.param("obj_type", 1);
                statisticItem.param("obj_locate", this.b.e0());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eo9 a;

        public d(eo9 eo9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eo9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eo9Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (this.a.p != null) {
                    this.a.p.a(view2);
                    return this.a.p.onSingleTapConfirmed(motionEvent);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class e implements cg<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eo9 a;

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

        public e(eo9 eo9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eo9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eo9Var;
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
                return new ConstrainImageLayout(this.a.mContext);
            }
            return (ConstrainImageLayout) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class f implements cg<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eo9 a;

        public TbImageView e(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbImageView)) == null) ? tbImageView : (TbImageView) invokeL.objValue;
        }

        public f(eo9 eo9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eo9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eo9Var;
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
                TbImageView tbImageView = new TbImageView(this.a.mContext);
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(SkinManager.getColor(R.color.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070198));
                return tbImageView;
            }
            return (TbImageView) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class g implements vk9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eo9 a;

        @Override // com.baidu.tieba.vk9.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        public g(eo9 eo9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eo9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eo9Var;
        }

        @Override // com.baidu.tieba.vk9.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (this.a.p != null) {
                    if ((view2 instanceof TbListTextView) && this.a.n != null) {
                        this.a.n.onClick(view2);
                        return true;
                    }
                    this.a.p.a(view2);
                    this.a.p.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.vk9.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            PbFragment pbFragment;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                if (view2 == null || (((pbFragment = this.a.b) != null && pbFragment.H6() != null && !this.a.b.H6().e2()) || view2.getId() == R.id.obfuscated_res_0x7f090b78)) {
                    return true;
                }
                if (view2 instanceof FrameLayout) {
                    this.a.O(view2);
                } else {
                    ViewParent parent = view2.getParent();
                    int i = 0;
                    while (true) {
                        if (parent == null || i >= 10) {
                            break;
                        } else if (parent instanceof FrameLayout) {
                            this.a.O((RelativeLayout) parent);
                            break;
                        } else {
                            parent = parent.getParent();
                            i++;
                        }
                    }
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ eo9 b;

        public h(eo9 eo9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eo9Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = eo9Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SkinManager.setBackgroundColor(this.a.c, R.color.CAM_X0205);
                rr9 rr9Var = this.b.a;
                if (rr9Var != null && rr9Var.X() != null) {
                    this.b.a.X().x0();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ tha b;
        public final /* synthetic */ eo9 c;

        public i(eo9 eo9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eo9Var, pbCommenFloorItemViewHolder, thaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = eo9Var;
            this.a = pbCommenFloorItemViewHolder;
            this.b = thaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.R.getVisibility() == 8) {
                    z = true;
                } else {
                    z = false;
                }
                this.c.M(this.a, !z, this.b.O());
                this.b.e1(!z);
                this.c.i0(this.a, this.b);
                PbFragment pbFragment = this.c.b;
                if (pbFragment != null && pbFragment.H6() != null && this.c.b.H6().D1() != null && this.c.b.H6().m1() != null && !z && this.a.getView().getTop() < this.c.b.H6().D1().getMeasuredHeight()) {
                    this.c.b.H6().m1().setSelectionFromTop(ListUtils.getPosition(this.c.b.H6().m1().getData(), this.b) + this.c.b.H6().m1().getHeaderViewsCount(), this.c.b.H6().D1().getMeasuredHeight());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ eo9 b;

        public j(eo9 eo9Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eo9Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = eo9Var;
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.b.mContext == null) {
                return;
            }
            CommonStatisticUtils.staticNameplateOfUserLevel(2, 7, this.a);
            BrowserHelper.startWebActivity(this.b.mContext, (String) null, TbConfig.USER_GROWTH_TASK_CENTER_MAIN_URL, true);
        }
    }

    /* loaded from: classes5.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ String b;

        public k(eo9 eo9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eo9Var, pbCommenFloorItemViewHolder, str};
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
                arrayList.add(this.a.j);
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
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tha a;
        public final /* synthetic */ eo9 b;

        public l(eo9 eo9Var, tha thaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eo9Var, thaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = eo9Var;
            this.a = thaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.b.mContext != null && this.b.l != null && this.a.t() != null && StringUtils.isNotNull(this.a.t().getPortrait())) {
                ky5.d(this.b.l.l(), this.a.t().getPortrait(), "3", this.b.mContext);
                ly5.c("c15281", this.b.l.l(), "3");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;

        public m(eo9 eo9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eo9Var, pbCommenFloorItemViewHolder};
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
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.y.performClick();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public eo9(rr9 rr9Var, BdUniqueId bdUniqueId) {
        super(rr9Var, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rr9Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((rr9) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = 0;
        this.h = null;
        this.i = true;
        this.j = 1.0f;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.u = true;
        this.w = true;
        this.x = false;
        this.y = new bg<>(new e(this), 6, 0);
        this.z = new bg<>(new f(this), 12, 0);
        this.A = new vk9(new g(this));
        if (rr9Var != null && rr9Var.X() != null) {
            this.v = rr9Var.X().q1();
        }
        this.g = s(R.dimen.tbds14);
    }

    public final void R(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, pbCommenFloorItemViewHolder, thaVar) == null) && pbCommenFloorItemViewHolder != null && thaVar != null) {
            ImageView imageView = pbCommenFloorItemViewHolder.W;
            if (thaVar.d0) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            imageView.setVisibility(i2);
        }
    }

    public final void b0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048594, this, pbCommenFloorItemViewHolder, thaVar) == null) && pbCommenFloorItemViewHolder != null && thaVar != null) {
            pbCommenFloorItemViewHolder.h(thaVar.f1164T, thaVar.U(), this.x);
        }
    }

    public final void i0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, pbCommenFloorItemViewHolder, thaVar) == null) {
            TbRichText f0 = thaVar.f0();
            f0.isChanged = true;
            pbCommenFloorItemViewHolder.q.setText(f0, true, this.h);
        }
    }

    public final void I(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.q.setTextViewOnTouchListener(this.p);
            pbCommenFloorItemViewHolder.q.setTextViewCheckSelection(false);
            pbCommenFloorItemViewHolder.s.setOnTouchListener(new d(this));
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.i = z;
        }
    }

    public void d(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, onLongClickListener) == null) {
            this.q = onLongClickListener;
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, onClickListener) == null) {
            this.n = onClickListener;
        }
    }

    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, onClickListener) == null) {
            this.m = onClickListener;
        }
    }

    public void k0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            this.s = i2;
        }
    }

    public void m0(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048609, this, f2) == null) {
            this.j = f2;
        }
    }

    public void n(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, zVar) == null) {
            this.o = zVar;
        }
    }

    public void n0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            this.t = z;
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            this.k = str;
        }
    }

    public void o0(vk9 vk9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, vk9Var) == null) {
            this.p = vk9Var;
        }
    }

    public void p0(TbRichTextView.t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, tVar) == null) {
            this.h = tVar;
        }
    }

    public void r(aj9 aj9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, aj9Var) == null) {
            this.l = aj9Var;
        }
    }

    public final void J(tha thaVar) {
        aj9 aj9Var;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, thaVar) == null) && (aj9Var = this.l) != null) {
            if (aj9Var.x0()) {
                AbsVideoPbFragment absVideoPbFragment = this.c;
                if (absVideoPbFragment != null) {
                    BdUniqueId uniqueId = absVideoPbFragment.getUniqueId();
                    aj9 aj9Var2 = this.l;
                    int i4 = thaVar.f0;
                    if (thaVar.e0) {
                        i3 = 2;
                    } else {
                        i3 = 8;
                    }
                    nr9.e(uniqueId, aj9Var2, thaVar, i4, i3, "common_exp_source_pb_comment");
                    return;
                }
                return;
            }
            PbFragment pbFragment = this.b;
            if (pbFragment != null) {
                BdUniqueId uniqueId2 = pbFragment.getUniqueId();
                aj9 aj9Var3 = this.l;
                int i5 = thaVar.f0;
                if (thaVar.e0) {
                    i2 = 2;
                } else {
                    i2 = 8;
                }
                nr9.e(uniqueId2, aj9Var3, thaVar, i5, i2, "common_exp_source_pb_comment");
            }
        }
    }

    public final void K(tha thaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, thaVar) == null) && thaVar.E == 0 && thaVar.M) {
            StatisticItem statisticItem = new StatisticItem("c12203");
            statisticItem.param("post_id", thaVar.U());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("cuid", TbadkCoreApplication.getInst().getCuid());
            statisticItem.param("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            statisticItem.param("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
            statisticItem.param(TiebaStatic.Params.CUID_GID, TbadkCoreApplication.getInst().getCuidGid());
            statisticItem.param(TiebaStatic.Params.EXPOSURE_TIME, System.currentTimeMillis());
            rr9 rr9Var = this.a;
            if (rr9Var != null) {
                int q1 = rr9Var.X().q1();
                if (1 != q1 && 2 != q1) {
                    if (3 == q1) {
                        statisticItem.param("obj_source", "2");
                    } else {
                        statisticItem.param("obj_source", "0");
                    }
                } else {
                    statisticItem.param("obj_source", "1");
                }
            }
            TiebaStatic.log(statisticItem);
            if (thaVar.t() != null && thaVar.t().getAlaInfo() != null && thaVar.t().getAlaInfo().live_status == 1) {
                j0(thaVar);
            }
        }
    }

    public final void L(TbRichTextView tbRichTextView, View view2, boolean z, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{tbRichTextView, view2, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) && tbRichTextView != null && view2 != null) {
            int equipmentWidth = ((((BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst(), UtilHelper.isFoldScreen()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight()) - i2;
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                equipmentWidth = (equipmentWidth - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            if (z) {
                i3 = s(R.dimen.tbds115);
            } else {
                i3 = 0;
            }
            tbRichTextView.getLayoutStrategy().J = (equipmentWidth - i3) - s(R.dimen.tbds122);
            if (UtilHelper.isOppoFoldLargeScreen(TbadkCoreApplication.getInst().getContext())) {
                equipmentWidth /= 2;
            }
            tbRichTextView.getLayoutStrategy().r((int) ((equipmentWidth - i3) * this.j));
            tbRichTextView.getLayoutStrategy().q((int) (equipmentWidth * 1.618f * this.j));
        }
    }

    public final void M(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{pbCommenFloorItemViewHolder, Boolean.valueOf(z), str}) == null) {
            if (z) {
                pbCommenFloorItemViewHolder.R.setVisibility(8);
                if (StringUtils.isNull(str)) {
                    pbCommenFloorItemViewHolder.f1141T.setText(R.string.obfuscated_res_0x7f0f06ef);
                    return;
                } else {
                    pbCommenFloorItemViewHolder.f1141T.setText(str);
                    return;
                }
            }
            pbCommenFloorItemViewHolder.R.setVisibility(0);
            pbCommenFloorItemViewHolder.f1141T.setText(R.string.obfuscated_res_0x7f0f0477);
        }
    }

    public final void N(boolean z, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), pbCommenFloorItemViewHolder, thaVar}) == null) && pbCommenFloorItemViewHolder != null && (view2 = pbCommenFloorItemViewHolder.I) != null && pbCommenFloorItemViewHolder.S != null && (view2.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (pbCommenFloorItemViewHolder.S.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = !ListUtils.isEmpty(thaVar.j0());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.I.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.S.getLayoutParams();
            if (z) {
                pbCommenFloorItemViewHolder.q.getLayoutStrategy().n(0);
                if (z2) {
                    pbCommenFloorItemViewHolder.q.getLayoutStrategy().m(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                    }
                } else {
                    pbCommenFloorItemViewHolder.q.getLayoutStrategy().m(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = 0;
                    }
                }
                pbCommenFloorItemViewHolder.S.setLayoutParams(layoutParams2);
                if (layoutParams != null) {
                    layoutParams.topMargin = BdUtilHelper.getDimens(this.mContext, R.dimen.tbds20);
                    pbCommenFloorItemViewHolder.I.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            pbCommenFloorItemViewHolder.q.getLayoutStrategy().m(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
            pbCommenFloorItemViewHolder.q.getLayoutStrategy().n(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
            if (layoutParams != null) {
                layoutParams.topMargin = BdUtilHelper.getDimens(this.mContext, R.dimen.tbds14);
                pbCommenFloorItemViewHolder.I.setLayoutParams(layoutParams);
            }
        }
    }

    public final void X(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048590, this, pbCommenFloorItemViewHolder, thaVar, view2) == null) && pbCommenFloorItemViewHolder != null && thaVar != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.r.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = BdUtilHelper.getDimens(this.mContext, R.dimen.M_W_X007);
            layoutParams.leftMargin = BdUtilHelper.getDimens(this.mContext, R.dimen.tbds148);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            pbCommenFloorItemViewHolder.q.setPadding(0, 0, 0, 0);
            if (!this.i) {
                pbCommenFloorItemViewHolder.q.getLayoutStrategy().h(R.drawable.icon_click);
            } else {
                pbCommenFloorItemViewHolder.q.p0(null);
                pbCommenFloorItemViewHolder.q.setBackgroundDrawable(null);
                pbCommenFloorItemViewHolder.q.getLayoutStrategy().h(R.drawable.transparent_bg);
            }
            pbCommenFloorItemViewHolder.q.getLayoutStrategy().z(R.drawable.pic_video);
            L(pbCommenFloorItemViewHolder.q, view2, !StringUtils.isNull(thaVar.v()), layoutParams.leftMargin + layoutParams.rightMargin);
            pbCommenFloorItemViewHolder.r.setLayoutParams(layoutParams);
            pbCommenFloorItemViewHolder.q.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            pbCommenFloorItemViewHolder.q.setIsFromCDN(this.e);
            pbCommenFloorItemViewHolder.q.setText(thaVar.f0(), true, this.h);
            SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.q.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, thaVar);
            sparseArray.put(R.id.tag_is_subpb, Boolean.FALSE);
            pbCommenFloorItemViewHolder.q.setTag(sparseArray);
            pbCommenFloorItemViewHolder.s.setTag(sparseArray);
            pbCommenFloorItemViewHolder.c.setTag(R.id.tag_from, sparseArray);
            pbCommenFloorItemViewHolder.n0.setTag(sparseArray);
            pbCommenFloorItemViewHolder.d0.setTag(sparseArray);
        }
    }

    public final void O(View view2) {
        PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, view2) == null) && view2 != null && (view2.getTag() instanceof PbCommenFloorItemViewHolder) && (agreeView = (pbCommenFloorItemViewHolder = (PbCommenFloorItemViewHolder) view2.getTag()).c0) != null && agreeView.getData() != null) {
            pbCommenFloorItemViewHolder.c0.setAgreeSource(2);
            pbCommenFloorItemViewHolder.c0.N();
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
            statisticItem.param("fid", this.l.l());
            statisticItem.param("tid", this.l.Q());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("post_id", this.l.i().U());
            statisticItem.param("obj_source", 1);
            statisticItem.param("obj_type", 1);
            statisticItem.param("obj_locate", e0());
            TiebaStatic.log(statisticItem);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: g0 */
    public PbCommenFloorItemViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d07c7, viewGroup, false);
            ((ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f091b51)).addView(LayoutInflater.from(inflate.getContext()).inflate(R.layout.obfuscated_res_0x7f0d07bf, (ViewGroup) null));
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = new PbCommenFloorItemViewHolder(this.a.e0().getPageContext(), inflate, this.v);
            pbCommenFloorItemViewHolder.t.setConstrainLayoutPool(this.y);
            pbCommenFloorItemViewHolder.t.setImageViewPool(this.z);
            SubPbLayout subPbLayout = pbCommenFloorItemViewHolder.v;
            if (subPbLayout != null) {
                subPbLayout.setShowChildComment(this.w);
                pbCommenFloorItemViewHolder.v.setIsVideoThread(true);
            }
            q0(pbCommenFloorItemViewHolder);
            TbRichTextView tbRichTextView = pbCommenFloorItemViewHolder.q;
            if (tbRichTextView != null) {
                tbRichTextView.setDuiEnabled(this.u);
            }
            return pbCommenFloorItemViewHolder;
        }
        return (PbCommenFloorItemViewHolder) invokeL.objValue;
    }

    public final void j0(tha thaVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, thaVar) == null) {
            String userId = thaVar.t().getUserId();
            aj9 aj9Var = this.l;
            String str2 = "";
            if (aj9Var == null) {
                str = "";
            } else {
                str = aj9Var.l();
            }
            aj9 aj9Var2 = this.l;
            if (aj9Var2 != null) {
                str2 = aj9Var2.m();
            }
            int L = thaVar.L();
            String U = thaVar.U();
            StatisticItem statisticItem = new StatisticItem("c13714");
            statisticItem.param("fid", str);
            statisticItem.param("fname", str2);
            statisticItem.param("obj_param1", userId);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("tid", U);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, L);
            if (thaVar.t().getAlaInfo() != null) {
                AlaInfoData alaInfo = thaVar.t().getAlaInfo();
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, YYLiveUtil.calculateLiveType(alaInfo));
                if (alaInfo.mYyExtData != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, TiebaStatic.YYValues.YY_LIVE);
                    TiebaStaticHelper.addYYParam(statisticItem, alaInfo.mYyExtData);
                }
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void P(tha thaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, thaVar) == null) && thaVar != null) {
            int i2 = 8;
            if (thaVar.e0) {
                i2 = 2;
            }
            StatisticItem k2 = nr9.k(this.l, thaVar, thaVar.f0, i2, 6);
            thaVar.g0 = k2;
            if (!ListUtils.isEmpty(thaVar.j0())) {
                Iterator<tha> it = thaVar.j0().iterator();
                while (it.hasNext()) {
                    it.next().g0 = k2;
                }
            }
        }
    }

    public final String f0(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, view2)) == null) {
            SparseArray sparseArray = (SparseArray) view2.getTag();
            Object obj = "1";
            if (sparseArray == null) {
                return "1";
            }
            Object obj2 = sparseArray.get(R.id.pb_track_more_obj_source);
            if (obj2 != null) {
                obj = obj2;
            }
            sparseArray.remove(R.id.pb_track_more_obj_source);
            view2.setTag(sparseArray);
            return obj.toString();
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x010c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Q(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar) {
        boolean z;
        boolean z2;
        int i2;
        int i3;
        aj9 aj9Var;
        aj9 aj9Var2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pbCommenFloorItemViewHolder, thaVar) == null) && pbCommenFloorItemViewHolder != null && thaVar != null) {
            String str = null;
            boolean z3 = true;
            if (thaVar.L() > 0 && (aj9Var2 = this.l) != null && !aj9Var2.j0()) {
                String format = String.format(this.mContext.getString(R.string.obfuscated_res_0x7f0f0b33), Integer.valueOf(thaVar.L()));
                pbCommenFloorItemViewHolder.C.setVisibility(0);
                pbCommenFloorItemViewHolder.C.setText(format);
                z = true;
            } else {
                pbCommenFloorItemViewHolder.C.setVisibility(8);
                z = false;
            }
            if (thaVar.t() != null) {
                str = thaVar.t().getIpAddress();
                if (!TextUtils.isEmpty(str)) {
                    z2 = true;
                    oh5 a0 = thaVar.a0();
                    z3 = (a0 != null || StringUtils.isNull(a0.b()) || (aj9Var = this.l) == null || aj9Var.j0()) ? false : false;
                    if (!z) {
                        pbCommenFloorItemViewHolder.l.setVisibility(0);
                        i2 = this.g;
                    } else {
                        pbCommenFloorItemViewHolder.l.setVisibility(8);
                        i2 = 0;
                    }
                    if (z3 && !z2) {
                        pbCommenFloorItemViewHolder.m.setVisibility(8);
                        i3 = 0;
                    } else {
                        pbCommenFloorItemViewHolder.m.setVisibility(0);
                        i3 = this.g;
                    }
                    pbCommenFloorItemViewHolder.k.setPadding(i2, 0, i3, 0);
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(thaVar.q0()), "yyyy"))) {
                        pbCommenFloorItemViewHolder.k.setText(StringHelper.getFormatTimeShort(thaVar.q0()));
                    } else {
                        pbCommenFloorItemViewHolder.k.setText(StringHelper.getFormatTime(thaVar.q0()));
                    }
                    if (!z2) {
                        pbCommenFloorItemViewHolder.n.setVisibility(0);
                        pbCommenFloorItemViewHolder.n.setPadding(this.g, 0, 0, 0);
                        TextView textView = pbCommenFloorItemViewHolder.n;
                        textView.setText(TbadkCoreApplication.getInst().getString(R.string.user_ip_address) + str);
                    } else if (z3) {
                        pbCommenFloorItemViewHolder.n.setVisibility(0);
                        pbCommenFloorItemViewHolder.n.setPadding(this.g, 0, 0, 0);
                        if (thaVar.d0) {
                            pbCommenFloorItemViewHolder.n.setText(StringHelper.cutStringWithSuffix(a0.b(), 7, "..."));
                        } else {
                            pbCommenFloorItemViewHolder.n.setText(a0.b());
                        }
                    } else {
                        pbCommenFloorItemViewHolder.n.setVisibility(8);
                    }
                    TextView textView2 = pbCommenFloorItemViewHolder.f0;
                    textView2.setText(((Object) pbCommenFloorItemViewHolder.k.getText()) + "  • ");
                }
            }
            z2 = false;
            oh5 a02 = thaVar.a0();
            if (a02 != null) {
            }
            if (!z) {
            }
            if (z3) {
            }
            pbCommenFloorItemViewHolder.m.setVisibility(0);
            i3 = this.g;
            pbCommenFloorItemViewHolder.k.setPadding(i2, 0, i3, 0);
            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(thaVar.q0()), "yyyy"))) {
            }
            if (!z2) {
            }
            TextView textView22 = pbCommenFloorItemViewHolder.f0;
            textView22.setText(((Object) pbCommenFloorItemViewHolder.k.getText()) + "  • ");
        }
    }

    public final void S(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar, View view2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048586, this, pbCommenFloorItemViewHolder, thaVar, view2, i2) == null) && pbCommenFloorItemViewHolder != null && thaVar != null) {
            pbCommenFloorItemViewHolder.A.setVisibility(8);
            pbCommenFloorItemViewHolder.u.setVisibility(0);
            pbCommenFloorItemViewHolder.e0.setVisibility(8);
            pbCommenFloorItemViewHolder.y.setVisibility(8);
            pbCommenFloorItemViewHolder.z.setVisibility(8);
            pbCommenFloorItemViewHolder.o.setVisibility(8);
            pbCommenFloorItemViewHolder.n0.setVisibility(8);
            c0(pbCommenFloorItemViewHolder, thaVar, view2, i2);
            d0(pbCommenFloorItemViewHolder, thaVar);
            oo9.b(pbCommenFloorItemViewHolder, thaVar, this.l);
            T(pbCommenFloorItemViewHolder, thaVar);
            X(pbCommenFloorItemViewHolder, thaVar, view2);
            W(pbCommenFloorItemViewHolder, thaVar, view2, i2);
            Q(pbCommenFloorItemViewHolder, thaVar);
            Z(pbCommenFloorItemViewHolder, thaVar);
            U(pbCommenFloorItemViewHolder, thaVar);
            a0(pbCommenFloorItemViewHolder, thaVar);
            hl9.j(pbCommenFloorItemViewHolder, thaVar, view2, this.i, this.A);
            R(pbCommenFloorItemViewHolder, thaVar);
            Y(pbCommenFloorItemViewHolder, thaVar);
            b0(pbCommenFloorItemViewHolder, thaVar);
            hl9.o(pbCommenFloorItemViewHolder, view2, thaVar, this.t, true);
        }
    }

    public final void T(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048587, this, pbCommenFloorItemViewHolder, thaVar) == null) && pbCommenFloorItemViewHolder != null && thaVar != null && thaVar.p() != null) {
            thaVar.p().threadId = this.a.X().L1();
            thaVar.p().objType = 1;
            thaVar.p().isInPost = true;
            ThreadData threadData = null;
            aj9 aj9Var = this.l;
            if (aj9Var != null && aj9Var.O() != null) {
                threadData = this.l.O();
            }
            if (threadData != null && threadData.isUgcThreadType()) {
                pbCommenFloorItemViewHolder.o.setAgreeAlone(true);
            }
            pbCommenFloorItemViewHolder.o.setThreadData(threadData);
            pbCommenFloorItemViewHolder.o.setData(thaVar.p());
            pbCommenFloorItemViewHolder.c0.setThreadData(threadData);
            pbCommenFloorItemViewHolder.c0.setData(thaVar.p());
        }
    }

    public final void Y(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048591, this, pbCommenFloorItemViewHolder, thaVar) == null) && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.c != null) {
            rr9 rr9Var = this.a;
            if (rr9Var != null && rr9Var.X() != null && StringHelper.equals(this.a.X().S0(), thaVar.U())) {
                SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.c, R.color.CAM_X0313);
                return;
            }
            rr9 rr9Var2 = this.a;
            if (rr9Var2 != null && rr9Var2.X() != null && StringHelper.equals(this.a.X().R0(), thaVar.U())) {
                SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.c, R.color.CAM_X0313);
                SafeHandler.getInst().postDelayed(new h(this, pbCommenFloorItemViewHolder), 3000L);
                return;
            }
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.c, R.color.CAM_X0205);
        }
    }

    public final void Z(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar) {
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, pbCommenFloorItemViewHolder, thaVar) == null) {
            if (thaVar != null && thaVar.t() != null && thaVar.m0() != null) {
                TbRichText f0 = thaVar.f0();
                if (f0 != null && StringUtils.isNull(f0.toString()) && StringUtils.isNull(thaVar.v())) {
                    z = true;
                } else {
                    z = false;
                }
                if (thaVar.t().getSmallTailThemeData() != null) {
                    str = thaVar.t().getSmallTailThemeData().getPropsId();
                } else {
                    str = "";
                }
                pbCommenFloorItemViewHolder.J.setTag(R.id.tag_pb_small_tail_theme_id, str);
                pbCommenFloorItemViewHolder.K.setTag(R.id.tag_pb_small_tail_theme_id, str);
                cs9.c(thaVar.m0(), pbCommenFloorItemViewHolder.J, pbCommenFloorItemViewHolder.K, pbCommenFloorItemViewHolder.L, false, false, z, thaVar.t().getSmallTailThemeData());
                return;
            }
            pbCommenFloorItemViewHolder.J.setVisibility(8);
            pbCommenFloorItemViewHolder.K.setVisibility(8);
        }
    }

    public final void U(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048588, this, pbCommenFloorItemViewHolder, thaVar) == null) && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.P != null && pbCommenFloorItemViewHolder.M != null) {
            if (thaVar != null && (alaLiveInfoCoreData = thaVar.U) != null && !StringUtils.isNull(alaLiveInfoCoreData.liveTitle)) {
                pbCommenFloorItemViewHolder.P.setText(thaVar.U.liveTitle);
                pbCommenFloorItemViewHolder.M.setTag(thaVar.U);
                pbCommenFloorItemViewHolder.M.setVisibility(0);
                StatisticItem statisticItem = new StatisticItem("c12639");
                if (TbadkCoreApplication.getCurrentAccount() != null) {
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                }
                TiebaStatic.log(statisticItem);
                return;
            }
            pbCommenFloorItemViewHolder.M.setVisibility(8);
        }
    }

    public final void a0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, pbCommenFloorItemViewHolder, thaVar) == null) {
            if (thaVar.P() != 2 && thaVar.P() != 4) {
                pbCommenFloorItemViewHolder.S.setVisibility(8);
                pbCommenFloorItemViewHolder.R.setVisibility(0);
                N(false, pbCommenFloorItemViewHolder, thaVar);
            } else {
                pbCommenFloorItemViewHolder.S.setOnClickListener(new i(this, pbCommenFloorItemViewHolder, thaVar));
                pbCommenFloorItemViewHolder.S.setVisibility(0);
                M(pbCommenFloorItemViewHolder, thaVar.E0(), thaVar.O());
                N(true, pbCommenFloorItemViewHolder, thaVar);
            }
            i0(pbCommenFloorItemViewHolder, thaVar);
        }
    }

    public final void d0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048598, this, pbCommenFloorItemViewHolder, thaVar) == null) && pbCommenFloorItemViewHolder != null && thaVar != null && TbSingleton.getInstance().isUserGrowthOpen() && thaVar.t().getUserGrowthData() != null) {
            int a2 = thaVar.t().getUserGrowthData().a();
            if (a2 >= 0 && a2 <= 10) {
                pbCommenFloorItemViewHolder.j.setImageResource(ex.b(a2));
                pbCommenFloorItemViewHolder.j.setVisibility(0);
                pbCommenFloorItemViewHolder.j.setOnClickListener(new j(this, a2));
                CommonStatisticUtils.staticNameplateOfUserLevel(1, 7, a2);
                return;
            }
            pbCommenFloorItemViewHolder.j.setVisibility(8);
        }
    }

    public final void W(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar, View view2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048589, this, pbCommenFloorItemViewHolder, thaVar, view2, i2) == null) && pbCommenFloorItemViewHolder != null && thaVar != null) {
            if (thaVar.l0() > 0) {
                pbCommenFloorItemViewHolder.x.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.x.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    pbCommenFloorItemViewHolder.x.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, thaVar);
                if (thaVar.P() == 2) {
                    pbCommenFloorItemViewHolder.x.setVisibility(8);
                } else {
                    pbCommenFloorItemViewHolder.x.setVisibility(0);
                }
                pbCommenFloorItemViewHolder.w.setVisibility(8);
            }
            ImageView imageView = pbCommenFloorItemViewHolder.y;
            if (imageView != null) {
                SparseArray sparseArray2 = (SparseArray) imageView.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    pbCommenFloorItemViewHolder.y.setTag(sparseArray2);
                }
                sparseArray2.put(R.id.tag_load_sub_data, thaVar);
            }
            ImageView imageView2 = pbCommenFloorItemViewHolder.z;
            if (imageView2 != null) {
                SparseArray sparseArray3 = (SparseArray) imageView2.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    pbCommenFloorItemViewHolder.z.setTag(sparseArray3);
                }
                sparseArray3.put(R.id.tag_load_sub_data, thaVar);
            }
            pbCommenFloorItemViewHolder.w.setVisibility(8);
            boolean z = true;
            if (!thaVar.A0() && !thaVar.z0(true)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.v.getLayoutParams();
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                layoutParams.bottomMargin = 0;
                pbCommenFloorItemViewHolder.v.setLayoutParams(layoutParams);
                pbCommenFloorItemViewHolder.v.setVisibility(8);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.v.getLayoutParams();
                layoutParams2.topMargin = BdUtilHelper.getDimens(this.mContext, R.dimen.tbds10);
                layoutParams2.leftMargin = BdUtilHelper.getDimens(this.mContext, R.dimen.tbds148);
                layoutParams2.rightMargin = BdUtilHelper.getDimens(this.mContext, R.dimen.M_W_X007);
                layoutParams2.bottomMargin = BdUtilHelper.getDimens(this.mContext, R.dimen.tbds20);
                pbCommenFloorItemViewHolder.v.setLayoutParams(layoutParams2);
                if (this.r == null) {
                    wq9 wq9Var = new wq9(this.mContext);
                    this.r = wq9Var;
                    wq9Var.f(this.e);
                    this.r.h(this.m);
                    this.r.e(this.n);
                    String str = null;
                    aj9 aj9Var = this.l;
                    if (aj9Var != null && aj9Var.O() != null && this.l.O().getAuthor() != null) {
                        str = this.l.O().getAuthor().getUserId();
                    }
                    z = (str == null || !str.equals(TbadkCoreApplication.getCurrentAccount())) ? false : false;
                    aj9 aj9Var2 = this.l;
                    if (aj9Var2 != null) {
                        this.r.j(aj9Var2.W(), z);
                        this.r.i(this.l.O());
                    }
                }
                this.r.g(thaVar.U());
                pbCommenFloorItemViewHolder.v.setSubPbAdapter(this.r);
                pbCommenFloorItemViewHolder.v.setVisibility(0);
                pbCommenFloorItemViewHolder.v.setData(thaVar, view2);
                pbCommenFloorItemViewHolder.v.setChildOnClickListener(this.n);
                pbCommenFloorItemViewHolder.v.setChildOnLongClickListener(this.q);
                pbCommenFloorItemViewHolder.v.setChildOnTouchListener(this.A);
            }
            if (thaVar.P) {
                pbCommenFloorItemViewHolder.I.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.I.setVisibility(4);
            }
            pbCommenFloorItemViewHolder.x.setVisibility(8);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.u.getLayoutParams();
            layoutParams3.topMargin = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X001);
            layoutParams3.bottomMargin = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X002);
            if (pbCommenFloorItemViewHolder.w.getVisibility() == 8) {
                pbCommenFloorItemViewHolder.u.setVisibility(8);
            } else {
                pbCommenFloorItemViewHolder.u.setVisibility(0);
            }
            pbCommenFloorItemViewHolder.g0.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1247));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:188:0x0597  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x05a2  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x05ab  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x05ee  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x05f8  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x065e  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0668  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x06a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar, View view2, int i2) {
        String str;
        int i3;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        int i4;
        int i5;
        String str2;
        String str3;
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048596, this, pbCommenFloorItemViewHolder, thaVar, view2, i2) == null) && pbCommenFloorItemViewHolder != null && thaVar != null) {
            int i6 = 0;
            if (thaVar.R) {
                SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.e, R.color.CAM_X0204);
                pbCommenFloorItemViewHolder.e.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.e.setVisibility(8);
            }
            ThreadData threadData = null;
            pbCommenFloorItemViewHolder.p.setTag(null);
            pbCommenFloorItemViewHolder.p.setUserId(null);
            pbCommenFloorItemViewHolder.g.setText((CharSequence) null);
            pbCommenFloorItemViewHolder.E.getHeadView().setUserId(null);
            pbCommenFloorItemViewHolder.q.setIsHost(false);
            String str6 = "";
            if (thaVar.t() != null) {
                String str7 = this.k;
                if (str7 != null && !"0".equals(str7) && this.k.equals(thaVar.t().getUserId())) {
                    pbCommenFloorItemViewHolder.q.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = thaVar.t().getIconInfo();
                ArrayList<IconData> tShowInfoNew = thaVar.t().getTShowInfoNew();
                UserIconBox userIconBox = pbCommenFloorItemViewHolder.G;
                if (userIconBox != null) {
                    userIconBox.setTag(R.id.tag_user_id, thaVar.t().getUserId());
                    rr9 rr9Var = this.a;
                    if (rr9Var != null && rr9Var.e0() != null) {
                        pbCommenFloorItemViewHolder.G.setOnClickListener(this.a.e0().c.c);
                    }
                    int dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                    int dimens2 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                    UserIconBox userIconBox2 = pbCommenFloorItemViewHolder.G;
                    i4 = R.id.tag_user_id;
                    userIconBox2.g(iconInfo, 2, dimens, dimens, dimens2);
                } else {
                    i4 = R.id.tag_user_id;
                }
                if (pbCommenFloorItemViewHolder.F != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        pbCommenFloorItemViewHolder.F.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    rr9 rr9Var2 = this.a;
                    if (rr9Var2 != null && rr9Var2.e0() != null) {
                        pbCommenFloorItemViewHolder.F.setOnClickListener(this.a.e0().c.e);
                    }
                    int dimens3 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                    pbCommenFloorItemViewHolder.F.h(tShowInfoNew, 3, dimens3, dimens3, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
                }
                if (ListUtils.isEmpty(tShowInfoNew) && !thaVar.t().isBigV()) {
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0107, 1);
                } else {
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0301, 1);
                }
                String avater = thaVar.t().getAvater();
                if (thaVar.e0) {
                    i5 = 2;
                } else {
                    i5 = 8;
                }
                pbCommenFloorItemViewHolder.g.setTag(i4, thaVar.t().getUserId());
                pbCommenFloorItemViewHolder.g.setTag(R.id.tag_user_name, thaVar.t().getUserName());
                pbCommenFloorItemViewHolder.g.setTag(R.id.tag_virtual_user_url, thaVar.t().getVirtualUserUrl());
                pbCommenFloorItemViewHolder.g.setTag(R.id.tag_statistic_item, nr9.k(this.l, thaVar, thaVar.f0, i5, 2));
                String name_show = thaVar.t().getName_show();
                String userName = thaVar.t().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    pbCommenFloorItemViewHolder.g.setText(eh9.b(this.mContext, pbCommenFloorItemViewHolder.g.getText().toString()));
                    pbCommenFloorItemViewHolder.g.setGravity(16);
                    pbCommenFloorItemViewHolder.g.setTag(R.id.tag_nick_name_activity, eh9.a());
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0312, 1);
                }
                if (thaVar.t().getPendantData() != null && !StringUtils.isNull(thaVar.t().getPendantData().getImgUrl())) {
                    pbCommenFloorItemViewHolder.E.setBigVDimenSize(R.dimen.tbds36);
                    pbCommenFloorItemViewHolder.E.i(thaVar.t());
                    pbCommenFloorItemViewHolder.p.setVisibility(8);
                    pbCommenFloorItemViewHolder.E.setVisibility(0);
                    pbCommenFloorItemViewHolder.E.getHeadView().startLoad(avater, 28, false);
                    pbCommenFloorItemViewHolder.E.getHeadView().setUserId(thaVar.t().getUserId());
                    pbCommenFloorItemViewHolder.E.getHeadView().setUserName(thaVar.t().getUserName());
                    aj9 aj9Var = this.l;
                    if (aj9Var == null) {
                        str4 = "";
                    } else {
                        str4 = aj9Var.l();
                    }
                    pbCommenFloorItemViewHolder.E.getHeadView().setFid(str4);
                    aj9 aj9Var2 = this.l;
                    if (aj9Var2 == null) {
                        str5 = "";
                    } else {
                        str5 = aj9Var2.m();
                    }
                    pbCommenFloorItemViewHolder.E.getHeadView().setFName(str5);
                    pbCommenFloorItemViewHolder.E.getHeadView().setFloor(thaVar.L());
                    pbCommenFloorItemViewHolder.E.getHeadView().setTid(thaVar.U());
                    pbCommenFloorItemViewHolder.E.getHeadView().setTag(R.id.tag_statistic_item, nr9.k(this.l, thaVar, thaVar.f0, i5, 2));
                    pbCommenFloorItemViewHolder.E.n(thaVar.t().getPendantData().getImgUrl());
                } else {
                    pbCommenFloorItemViewHolder.p.setGodIconWidth(R.dimen.tbds36);
                    UtilHelper.showHeadImageViewBigV(pbCommenFloorItemViewHolder.p, thaVar.t(), 4);
                    pbCommenFloorItemViewHolder.p.setUserId(thaVar.t().getUserId());
                    aj9 aj9Var3 = this.l;
                    if (aj9Var3 == null) {
                        str2 = "";
                    } else {
                        str2 = aj9Var3.l();
                    }
                    pbCommenFloorItemViewHolder.p.setFid(str2);
                    aj9 aj9Var4 = this.l;
                    if (aj9Var4 == null) {
                        str3 = "";
                    } else {
                        str3 = aj9Var4.m();
                    }
                    pbCommenFloorItemViewHolder.p.setFName(str3);
                    pbCommenFloorItemViewHolder.p.setFloor(thaVar.L());
                    pbCommenFloorItemViewHolder.p.setTid(thaVar.U());
                    pbCommenFloorItemViewHolder.p.setUserName(thaVar.t().getUserName(), thaVar.t0());
                    pbCommenFloorItemViewHolder.p.setTag(R.id.tag_virtual_user_url, thaVar.t().getVirtualUserUrl());
                    pbCommenFloorItemViewHolder.p.setTag(R.id.tag_statistic_item, nr9.k(this.l, thaVar, thaVar.f0, i5, 2));
                    pbCommenFloorItemViewHolder.p.setImageDrawable(null);
                    pbCommenFloorItemViewHolder.p.startLoad(avater, 28, false);
                    pbCommenFloorItemViewHolder.p.setVisibility(0);
                    pbCommenFloorItemViewHolder.E.setVisibility(8);
                }
                if (thaVar.t() != null && thaVar.t().getAlaInfo() != null && thaVar.t().getAlaUserData() != null && thaVar.t().getAlaUserData().live_status == 1) {
                    pbCommenFloorItemViewHolder.d(true);
                    pbCommenFloorItemViewHolder.p.setLiveStatus(1);
                    pbCommenFloorItemViewHolder.p.setAlaInfo(thaVar.t().getAlaInfo());
                    pbCommenFloorItemViewHolder.E.getHeadView().setLiveStatus(1);
                    pbCommenFloorItemViewHolder.E.getHeadView().setAlaInfo(thaVar.t().getAlaInfo());
                    threadData = null;
                } else {
                    pbCommenFloorItemViewHolder.d(false);
                    pbCommenFloorItemViewHolder.p.setLiveStatus(0);
                    threadData = null;
                    pbCommenFloorItemViewHolder.p.setAlaInfo(null);
                    pbCommenFloorItemViewHolder.E.getHeadView().setLiveStatus(0);
                    pbCommenFloorItemViewHolder.E.getHeadView().setAlaInfo(null);
                }
                oo9.e(pbCommenFloorItemViewHolder.i, thaVar, this.l, this.k);
            }
            rr9 rr9Var3 = this.a;
            if (rr9Var3 == null || rr9Var3.e0() == null || !this.a.e0().I0() || thaVar.t() == null) {
                str = "";
                i3 = 0;
            } else {
                i3 = thaVar.t().getLevel_id();
                str = thaVar.t().getLevelName();
            }
            aj9 aj9Var5 = this.l;
            if (aj9Var5 != null && aj9Var5.j0()) {
                i3 = 0;
            }
            if (i3 > 0) {
                pbCommenFloorItemViewHolder.D.setVisibility(0);
                pbCommenFloorItemViewHolder.D.setLevel(i3, str);
            } else {
                pbCommenFloorItemViewHolder.D.setVisibility(8);
            }
            if (thaVar.t() != null && thaVar.t().getName_show() != null) {
                str6 = thaVar.t().getName_show();
            }
            pbCommenFloorItemViewHolder.g.setText(str6);
            pbCommenFloorItemViewHolder.f.post(new k(this, pbCommenFloorItemViewHolder, str6));
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, thaVar);
            sparseArray.put(R.id.tag_load_sub_data, thaVar);
            sparseArray.put(R.id.tag_load_sub_view, view2);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(thaVar.L()));
            sparseArray.put(R.id.tag_forbid_user_post_id, thaVar.U());
            sparseArray.put(R.id.pb_dialog_item_zan_1, pbCommenFloorItemViewHolder.o);
            sparseArray.put(R.id.pb_dialog_item_zan_2, pbCommenFloorItemViewHolder.c0);
            sparseArray.put(R.id.pb_dialog_item_reply, pbCommenFloorItemViewHolder.y);
            sparseArray.put(R.id.pb_dialog_item_share, pbCommenFloorItemViewHolder.z);
            aj9 aj9Var6 = this.l;
            if (aj9Var6 != null && aj9Var6.O() != null) {
                threadData = this.l.O();
            }
            if (threadData != null && threadData.isUgcThreadType()) {
                sparseArray.put(R.id.pb_dialog_item_isugc, Boolean.TRUE);
            } else {
                sparseArray.put(R.id.pb_dialog_item_isugc, Boolean.FALSE);
            }
            if (thaVar.t() != null && !StringUtils.isNull(thaVar.t().getVirtualUserUrl())) {
                z = true;
            } else {
                z = false;
            }
            aj9 aj9Var7 = this.l;
            if (aj9Var7 != null && aj9Var7.W() != 0 && !oo9.c(this.l)) {
                if (this.l.W() != 1002 && this.l.W() != 3) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (this.l.W() != 3 && !this.l.j0()) {
                    z3 = true;
                    z4 = true;
                } else {
                    z3 = false;
                    z4 = false;
                }
                if (thaVar != null && thaVar.t() != null) {
                    String userId = thaVar.t().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z2 = false;
                    }
                    if (userId == null || "0".equals(userId) || userId.length() == 0) {
                        z2 = false;
                    }
                }
            } else {
                z2 = false;
                z3 = false;
                z4 = false;
            }
            aj9 aj9Var8 = this.l;
            if (aj9Var8 != null && aj9Var8.O() != null && this.l.O().getAuthor() != null && thaVar.t() != null) {
                String userId2 = this.l.O().getAuthor().getUserId();
                String userId3 = thaVar.t().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    if (UtilHelper.isCurrentAccount(userId3)) {
                        z5 = false;
                        z3 = true;
                        z6 = true;
                    } else {
                        z5 = true;
                        z3 = true;
                        z6 = false;
                    }
                    z7 = true;
                    if (thaVar != null && thaVar.t() != null && UtilHelper.isCurrentAccount(thaVar.t().getUserId())) {
                        z3 = true;
                        z6 = true;
                    }
                    if (z) {
                        z2 = false;
                        z5 = false;
                        z3 = false;
                    }
                    if (thaVar.L() != 1) {
                        i6 = 1;
                    }
                    if (!z2) {
                        sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.l.W()));
                        if (thaVar.t() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, thaVar.t().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, thaVar.t().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, thaVar.t().getPortrait());
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                    }
                    if (!z5) {
                        sparseArray.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (thaVar.t() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, thaVar.t().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, thaVar.t().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, thaVar.t().getName_show());
                        }
                        if (this.l.O() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.l.O().getId());
                        }
                        sparseArray.put(R.id.tag_user_mute_post_id, thaVar.U());
                    } else {
                        sparseArray.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                    }
                    if (!z3) {
                        sparseArray.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_has_sub_post, Boolean.valueOf(thaVar.A0()));
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.l.W()));
                        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i6));
                        sparseArray.put(R.id.tag_del_post_id, thaVar.U());
                    } else {
                        sparseArray.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                    }
                    sparseArray.put(R.id.tag_mul_del_post_type, Boolean.valueOf(z4));
                    sparseArray.put(R.id.tag_is_self_post, Boolean.valueOf(z7));
                    pbCommenFloorItemViewHolder.q.setTag(sparseArray);
                    pbCommenFloorItemViewHolder.s.setTag(sparseArray);
                    pbCommenFloorItemViewHolder.D.setOnClickListener(new l(this, thaVar));
                }
            }
            z5 = false;
            z6 = false;
            z7 = false;
            if (thaVar != null) {
                z3 = true;
                z6 = true;
            }
            if (z) {
            }
            if (thaVar.L() != 1) {
            }
            if (!z2) {
            }
            if (!z5) {
            }
            if (!z3) {
            }
            sparseArray.put(R.id.tag_mul_del_post_type, Boolean.valueOf(z4));
            sparseArray.put(R.id.tag_is_self_post, Boolean.valueOf(z7));
            pbCommenFloorItemViewHolder.q.setTag(sparseArray);
            pbCommenFloorItemViewHolder.s.setTag(sparseArray);
            pbCommenFloorItemViewHolder.D.setOnClickListener(new l(this, thaVar));
        }
    }

    public int e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.s;
        }
        return invokeV.intValue;
    }

    public View h0(int i2, View view2, ViewGroup viewGroup, tha thaVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048603, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, thaVar, pbCommenFloorItemViewHolder})) == null) {
            super.onFillViewHolder(i2, view2, viewGroup, (ViewGroup) thaVar, (tha) pbCommenFloorItemViewHolder);
            q0(pbCommenFloorItemViewHolder);
            l0(pbCommenFloorItemViewHolder);
            I(pbCommenFloorItemViewHolder);
            tha thaVar2 = (tha) getItem(i2);
            if (thaVar2 != null) {
                thaVar2.f0 = i2 + 1;
                K(thaVar2);
                J(thaVar2);
                thaVar2.C1();
                P(thaVar2);
                S(pbCommenFloorItemViewHolder, thaVar2, view2, i2);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void l0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.c.setOnTouchListener(this.A);
            pbCommenFloorItemViewHolder.c.setOnLongClickListener(this.q);
            if (this.a.e0() != null && this.a.e0().getPageContext() != null && this.a.e0().getPageContext().getOrignalPage() != null) {
                ep9 ep9Var = this.a.e0().c;
                pbCommenFloorItemViewHolder.g.setOnClickListener(ep9Var.b);
                pbCommenFloorItemViewHolder.p.setOnClickListener(ep9Var.b);
                pbCommenFloorItemViewHolder.E.setOnClickListener(ep9Var.b);
                pbCommenFloorItemViewHolder.E.getHeadView().setOnClickListener(ep9Var.b);
                pbCommenFloorItemViewHolder.q.setOnLongClickListener(this.q);
                pbCommenFloorItemViewHolder.q.setOnTouchListener(this.A);
                pbCommenFloorItemViewHolder.q.setCommonTextViewOnClickListener(this.n);
                pbCommenFloorItemViewHolder.q.setOnImageClickListener(this.o);
                pbCommenFloorItemViewHolder.q.setOnImageTouchListener(this.A);
                pbCommenFloorItemViewHolder.q.setOnEmotionClickListener(ep9Var.f);
                pbCommenFloorItemViewHolder.q.setOnVoiceAfterClickListener(this.n);
                pbCommenFloorItemViewHolder.J.setOnClickListener(this.n);
                pbCommenFloorItemViewHolder.K.setOnClickListener(this.n);
                pbCommenFloorItemViewHolder.M.setOnClickListener(this.n);
                pbCommenFloorItemViewHolder.w.setOnClickListener(this.n);
                pbCommenFloorItemViewHolder.x.setOnClickListener(this.n);
                pbCommenFloorItemViewHolder.h0.setOnClickListener(this.n);
                pbCommenFloorItemViewHolder.l0.setOnClickListener(this.n);
                pbCommenFloorItemViewHolder.d0.setOnClickListener(this.n);
                pbCommenFloorItemViewHolder.n0.setOnClickListener(this.n);
                pbCommenFloorItemViewHolder.e0.setOnClickListener(new m(this, pbCommenFloorItemViewHolder));
                gp9 gp9Var = this.a.e0().d;
                pbCommenFloorItemViewHolder.y.setOnClickListener(this.n);
                pbCommenFloorItemViewHolder.z.setOnClickListener(new a(this, pbCommenFloorItemViewHolder, gp9Var));
                pbCommenFloorItemViewHolder.o.D = new b(this, pbCommenFloorItemViewHolder);
                pbCommenFloorItemViewHolder.c0.D = new c(this, pbCommenFloorItemViewHolder);
            }
        }
    }

    @Override // com.baidu.tieba.lm9, com.baidu.tieba.pm
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i2, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        h0(i2, view2, viewGroup, (tha) obj, (PbCommenFloorItemViewHolder) viewHolder);
        return view2;
    }

    public final void q0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048618, this, pbCommenFloorItemViewHolder) != null) || pbCommenFloorItemViewHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (pbCommenFloorItemViewHolder.a != skinType) {
            oo9.d(pbCommenFloorItemViewHolder.i, this.l, this.k);
            boolean z = true;
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.k, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.l, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.m, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.C, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.n, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.x, (int) R.color.CAM_X0108);
            pbCommenFloorItemViewHolder.q.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            if (pbCommenFloorItemViewHolder.s.getVisibility() == 0) {
                pbCommenFloorItemViewHolder.s.g(skinType);
            }
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f0, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g0, R.color.CAM_X0107, 1);
            SkinManager.setBackgroundShapeDrawable(pbCommenFloorItemViewHolder.v, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21), R.color.CAM_X0206, R.color.CAM_X0206);
            SkinManager.getColor(R.color.CAM_X0107);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.w, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.w, (int) R.color.CAM_X0304);
            pbCommenFloorItemViewHolder.w.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right, SkinManager.getColor(R.color.CAM_X0304), null), (Drawable) null);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.y, R.drawable.obfuscated_res_0x7f080bba, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.z, R.drawable.obfuscated_res_0x7f080bbb, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbCommenFloorItemViewHolder.v.d();
            pbCommenFloorItemViewHolder.t.b();
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.P, R.color.CAM_X0304, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.N, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.M, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.O, R.color.CAM_X0109);
            SkinManager.setImageResource(pbCommenFloorItemViewHolder.Q, R.drawable.icon_arrow_more_gray);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f1141T, (int) R.color.CAM_X0107);
            if (pbCommenFloorItemViewHolder.R.getVisibility() != 8) {
                z = false;
            }
            if (z) {
                pbCommenFloorItemViewHolder.f1141T.setText(R.string.obfuscated_res_0x7f0f0477);
            } else {
                aj9 aj9Var = this.l;
                if (aj9Var != null && StringUtils.isNull(aj9Var.j())) {
                    pbCommenFloorItemViewHolder.f1141T.setText(this.l.j());
                } else {
                    pbCommenFloorItemViewHolder.f1141T.setText(R.string.obfuscated_res_0x7f0f06ef);
                }
            }
            pbCommenFloorItemViewHolder.o.P(TbadkCoreApplication.getInst().getSkinType());
            pbCommenFloorItemViewHolder.c(skinType);
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.I, R.color.CAM_X0203);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.d0, R.drawable.icon_pure_pb_more18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.n0, R.drawable.icon_pure_pb_more18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbCommenFloorItemViewHolder.b();
        }
        pbCommenFloorItemViewHolder.a = skinType;
    }
}

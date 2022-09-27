package com.baidu.tieba;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.CommonStatisticUtils;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.MetaData;
import com.baidu.tbadk.data.VirtualImageCustomFigure;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.lw7;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbTopCommenFloorItemViewHolder;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.t16;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class hz7 extends ay7<PostData, PbTopCommenFloorItemViewHolder> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbRichTextView.s g;
    public boolean h;
    public float i;
    public String j;
    public jv7 k;
    public View.OnClickListener l;
    public TbRichTextView.y m;
    public lw7 n;
    public View.OnLongClickListener o;
    public boolean p;
    public int q;
    public boolean r;
    public int s;
    public String t;
    public ug<ConstrainImageLayout> u;
    public ug<TbImageView> v;
    public lw7 w;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbTopCommenFloorItemViewHolder a;
        public final /* synthetic */ hz7 b;

        public a(hz7 hz7Var, PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hz7Var, pbTopCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hz7Var;
            this.a = pbTopCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder;
            AgreeView agreeView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || view2 == null || this.b.k == null || (pbTopCommenFloorItemViewHolder = this.a) == null || (agreeView = pbTopCommenFloorItemViewHolder.c0) == null || agreeView.getData() == null) {
                return;
            }
            int i = view2 == this.a.c0.getImgAgree() ? 1 : 2;
            String Q = this.b.k.Q();
            if ((StringUtils.isNull(Q) || "0".equals(this.b.k.Q())) && this.b.k.O() != null) {
                Q = this.b.k.O().getNid();
            }
            j28.o(this.a.c0.getData().hasAgree ? 3 : 4);
            TiebaStatic.log(new StatisticItem("c13700").param("tid", Q).param("fid", this.b.k.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.c0.getData().postId).param("obj_source", this.b.j0(this.a.c0)).param("obj_type", i));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ PbTopCommenFloorItemViewHolder b;
        public final /* synthetic */ hz7 c;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            /* renamed from: com.baidu.tieba.hz7$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class View$OnClickListenerC0278a implements View.OnClickListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public View$OnClickListenerC0278a(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = aVar;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                        j28.p("c14886");
                        b bVar = this.a.a;
                        hz7 hz7Var = bVar.c;
                        hz7Var.l0(((PostData) hz7Var.getItem(bVar.a)).s());
                    }
                }
            }

            /* renamed from: com.baidu.tieba.hz7$b$a$b  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class RunnableC0279b implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public RunnableC0279b(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = aVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        b bVar = this.a.a;
                        ((PostData) bVar.c.getItem(bVar.a)).y0();
                        b bVar2 = this.a.a;
                        if (((PostData) bVar2.c.getItem(bVar2.a)).V() <= 0) {
                            b bVar3 = this.a.a;
                            ((PostData) bVar3.c.getItem(bVar3.a)).O0(Boolean.FALSE);
                            this.a.a.b.q0.setVisibility(8);
                            this.a.a.b.c0.setVisibility(0);
                            this.a.a.b.d0.setVisibility(0);
                        }
                    }
                }
            }

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.b.c0.getAgreeFlag()) {
                    b bVar = this.a;
                    ((PostData) bVar.c.getItem(bVar.a)).x0();
                    b bVar2 = this.a;
                    ((PostData) bVar2.c.getItem(bVar2.a)).O0(Boolean.TRUE);
                    this.a.b.c0.setVisibility(8);
                    this.a.b.d0.setVisibility(8);
                    this.a.b.q0.setVisibility(0);
                    this.a.b.q0.setOnClickListener(new View$OnClickListenerC0278a(this));
                    this.a.b.q0.postDelayed(new RunnableC0279b(this), 5000L);
                }
            }
        }

        public b(hz7 hz7Var, int i, PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hz7Var, Integer.valueOf(i), pbTopCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = hz7Var;
            this.a = i;
            this.b = pbTopCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && UtilHelper.isCurrentAccount(this.c.k.O().getAuthor().getUserId()) && this.c.k.O().isQuestionThread() && !UtilHelper.isCurrentAccount(((PostData) this.c.getItem(this.a)).s().getUserId())) {
                if (this.b.c0.getAgreeFlag()) {
                    ((PostData) this.c.getItem(this.a)).P0(1);
                    this.b.p0.setVisibility(0);
                    ((PostData) this.c.getItem(this.a)).I0(true);
                    this.b.i.setVisibility(8);
                    this.b.c0.postDelayed(new a(this), 900L);
                    return;
                }
                ((PostData) this.c.getItem(this.a)).P0(0);
                this.b.q0.setVisibility(8);
                this.b.p0.setVisibility(8);
                this.b.c0.setVisibility(0);
                ((PostData) this.c.getItem(this.a)).I0(false);
                if (((PostData) this.c.getItem(this.a)).X().booleanValue()) {
                    this.b.i.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hz7 a;

        public c(hz7 hz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hz7Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (this.a.n != null) {
                    this.a.n.a(view2);
                    return this.a.n.onSingleTapConfirmed(motionEvent);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements vg<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hz7 a;

        public d(hz7 hz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hz7Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.vg
        public /* bridge */ /* synthetic */ ConstrainImageLayout a(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            e(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.vg
        public /* bridge */ /* synthetic */ ConstrainImageLayout c(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            h(constrainImageLayout2);
            return constrainImageLayout2;
        }

        public ConstrainImageLayout e(ConstrainImageLayout constrainImageLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, constrainImageLayout)) == null) ? constrainImageLayout : (ConstrainImageLayout) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vg
        /* renamed from: f */
        public void b(ConstrainImageLayout constrainImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, constrainImageLayout) == null) {
                constrainImageLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vg
        /* renamed from: g */
        public ConstrainImageLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new ConstrainImageLayout(this.a.mContext) : (ConstrainImageLayout) invokeV.objValue;
        }

        public ConstrainImageLayout h(ConstrainImageLayout constrainImageLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, constrainImageLayout)) == null) ? constrainImageLayout : (ConstrainImageLayout) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class e implements vg<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hz7 a;

        public e(hz7 hz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hz7Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.vg
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.vg
        public /* bridge */ /* synthetic */ TbImageView c(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            h(tbImageView2);
            return tbImageView2;
        }

        public TbImageView e(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbImageView)) == null) ? tbImageView : (TbImageView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vg
        /* renamed from: f */
        public void b(TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, tbImageView) == null) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vg
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
    }

    /* loaded from: classes4.dex */
    public class f implements lw7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hz7 a;

        public f(hz7 hz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hz7Var;
        }

        @Override // com.baidu.tieba.lw7.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.lw7.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (this.a.n != null) {
                    if (!(view2 instanceof TbListTextView) || this.a.l == null) {
                        this.a.n.a(view2);
                        this.a.n.onSingleTapConfirmed(motionEvent);
                    } else {
                        this.a.l.onClick(view2);
                        PbFragment pbFragment = this.a.b;
                        if (pbFragment != null) {
                            pbFragment.a7(true);
                        }
                    }
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.lw7.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            PbFragment pbFragment;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                if (view2 == null || !((pbFragment = this.a.b) == null || pbFragment.P5() == null || this.a.b.P5().K1())) {
                    return true;
                }
                if (view2 instanceof RelativeLayout) {
                    this.a.R(view2);
                } else {
                    ViewParent parent = view2.getParent();
                    int i = 0;
                    while (true) {
                        if (parent == null || i >= 10) {
                            break;
                        } else if (parent instanceof RelativeLayout) {
                            this.a.R((RelativeLayout) parent);
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

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbTopCommenFloorItemViewHolder a;
        public final /* synthetic */ PostData b;
        public final /* synthetic */ hz7 c;

        public g(hz7 hz7Var, PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hz7Var, pbTopCommenFloorItemViewHolder, postData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = hz7Var;
            this.a = pbTopCommenFloorItemViewHolder;
            this.b = postData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                boolean z = this.a.U.getVisibility() == 8;
                this.c.O(this.a, !z, this.b.F());
                this.b.L0(!z);
                this.c.o0(this.a, this.b);
                PbFragment pbFragment = this.c.b;
                if (pbFragment == null || pbFragment.P5() == null || this.c.b.P5().o1() == null || this.c.b.P5().U0() == null || z || this.a.getView().getTop() >= this.c.b.P5().o1().getMeasuredHeight()) {
                    return;
                }
                this.c.b.P5().U0().setSelectionFromTop(ListUtils.getPosition(this.c.b.P5().U0().getData(), this.b) + this.c.b.P5().U0().getHeaderViewsCount(), this.c.b.P5().o1().getMeasuredHeight());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ hz7 b;

        public h(hz7 hz7Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hz7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hz7Var;
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.b.mContext == null) {
                return;
            }
            CommonStatisticUtils.staticNameplateOfUserLevel(2, 4, this.a);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.b.mContext, null, TbConfig.USER_GROWTH_TASK_CENTER_MAIN_URL, true)));
        }
    }

    /* loaded from: classes4.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbTopCommenFloorItemViewHolder a;

        public i(hz7 hz7Var, PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hz7Var, pbTopCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbTopCommenFloorItemViewHolder;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.q0.setVisibility(8);
                this.a.c0.setVisibility(0);
                this.a.d0.setVisibility(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbTopCommenFloorItemViewHolder a;
        public final /* synthetic */ String[] b;
        public final /* synthetic */ PostData c;
        public final /* synthetic */ int d;
        public final /* synthetic */ hz7 e;

        public j(hz7 hz7Var, PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, String[] strArr, PostData postData, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hz7Var, pbTopCommenFloorItemViewHolder, strArr, postData, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = hz7Var;
            this.a = pbTopCommenFloorItemViewHolder;
            this.b = strArr;
            this.c = postData;
            this.d = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int measuredWidth = this.a.f.getMeasuredWidth();
                boolean h0 = this.e.h0();
                int width = !StringUtils.isNull(this.b[0]) ? this.a.h.getWidth() : 0;
                int g = lz7.g(measuredWidth, this.a.J.getVisibility() == 8 ? 0 : this.a.J.getWidth() + lz7.c + lz7.b, width, this.a.j.getVisibility() == 8 ? 0 : this.a.j.getWidth() + lz7.b, this.a.H.getVisibility() == 8 ? 0 : this.a.H.getWidth() + lz7.b, h0);
                if (g < 0 && !StringUtils.isNull(this.b[0])) {
                    this.a.g.setWidth(width + g);
                    z = true;
                } else {
                    this.a.g.setWidth(width);
                    z = false;
                }
                if (this.a.h.getText() == null) {
                    if (z) {
                        this.a.g.setText(this.b[0]);
                        hz7 hz7Var = this.e;
                        PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder = this.a;
                        hz7Var.t0(pbTopCommenFloorItemViewHolder.g, pbTopCommenFloorItemViewHolder.j);
                    } else {
                        this.a.g.setText(this.b[0]);
                        this.e.u0(this.a.j, false);
                    }
                } else if (z) {
                    PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder2 = this.a;
                    pbTopCommenFloorItemViewHolder2.g.setText(pbTopCommenFloorItemViewHolder2.h.getText());
                    hz7 hz7Var2 = this.e;
                    PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder3 = this.a;
                    hz7Var2.t0(pbTopCommenFloorItemViewHolder3.g, pbTopCommenFloorItemViewHolder3.j);
                } else {
                    PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder4 = this.a;
                    pbTopCommenFloorItemViewHolder4.g.setText(pbTopCommenFloorItemViewHolder4.h.getText());
                    this.e.u0(this.a.j, false);
                }
                this.e.M(this.c, this.a, g, this.d);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ TextView b;
        public final /* synthetic */ TbImageView c;
        public final /* synthetic */ hz7 d;

        public k(hz7 hz7Var, TextView textView, TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hz7Var, textView, tbImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = hz7Var;
            this.b = textView;
            this.c = tbImageView;
            this.a = true;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a) {
                Layout layout = this.b.getLayout();
                if (this.b == null || layout == null) {
                    return;
                }
                int lineCount = layout.getLineCount() - 1;
                if (layout.getEllipsisCount(lineCount) == 0) {
                    return;
                }
                String charSequence = this.b.getText().toString();
                String substring = charSequence.substring(0, layout.getEllipsisStart(lineCount));
                this.b.setText(charSequence.substring(0, layout.getEllipsisStart(lineCount)).concat(StringHelper.STRING_MORE));
                this.a = false;
                TbImageView tbImageView = this.c;
                if (tbImageView == null || tbImageView.getVisibility() != 0) {
                    return;
                }
                if (substring.length() % 2 == 0) {
                    this.d.u0(this.c, false);
                } else {
                    this.d.u0(this.c, true);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbTopCommenFloorItemViewHolder a;
        public final /* synthetic */ s08 b;
        public final /* synthetic */ hz7 c;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PostData a;
            public final /* synthetic */ l b;

            public a(l lVar, PostData postData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar, postData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = lVar;
                this.a = postData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    l lVar = this.b;
                    lVar.b.b.a(lVar.c.k, null, this.a, lVar.a.q.getLayoutStrategy());
                }
            }
        }

        public l(hz7 hz7Var, PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, s08 s08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hz7Var, pbTopCommenFloorItemViewHolder, s08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = hz7Var;
            this.a = pbTopCommenFloorItemViewHolder;
            this.b = s08Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PostData postData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (view2.getTag() instanceof SparseArray)) {
                SparseArray sparseArray = (SparseArray) view2.getTag();
                if (!(sparseArray.get(R.id.obfuscated_res_0x7f092059) instanceof PostData) || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f092059)) == null || this.a.b == null || this.b == null) {
                    return;
                }
                gh.a().postDelayed(new a(this, postData), 100L);
                String Q = this.c.k.Q();
                if ((StringUtils.isNull(Q) || "0".equals(this.c.k.Q())) && this.c.k.O() != null) {
                    Q = this.c.k.O().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", Q).param("fid", this.c.k.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData.L()).param("obj_source", this.c.j0(view2)).param("obj_type", 4));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hz7(t28 t28Var, BdUniqueId bdUniqueId) {
        super(t28Var, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t28Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((t28) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = null;
        this.h = true;
        this.i = 1.0f;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = true;
        this.r = false;
        this.s = 0;
        this.t = null;
        this.u = new ug<>(new d(this), 6, 0);
        this.v = new ug<>(new e(this), 12, 0);
        this.w = new lw7(new f(this));
        if (t28Var != null && t28Var.K() != null) {
            this.q = t28Var.K().R1();
        }
        s(R.dimen.tbds14);
    }

    public final void I(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pbTopCommenFloorItemViewHolder) == null) {
            pbTopCommenFloorItemViewHolder.q.setTextViewOnTouchListener(this.n);
            pbTopCommenFloorItemViewHolder.q.setTextViewCheckSelection(false);
            pbTopCommenFloorItemViewHolder.s.setOnTouchListener(new c(this));
        }
    }

    public final void K(PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, postData) == null) {
            if (postData != null) {
                StatisticItem statisticItem = new StatisticItem("c14623");
                statisticItem.param("post_id", postData.L());
                statisticItem.param("pid", postData.L());
                statisticItem.param("tid", postData.e0());
                statisticItem.param("fid", postData.H());
                statisticItem.param("fname", postData.I());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
            }
            jv7 jv7Var = this.k;
            if (jv7Var != null) {
                if (jv7Var.u0()) {
                    AbsVideoPbFragment absVideoPbFragment = this.c;
                    if (absVideoPbFragment != null) {
                        j28.e(absVideoPbFragment.getUniqueId(), this.k, postData, postData.c0, postData.b0 ? 2 : 8, "common_exp_source_pb_comment");
                        return;
                    }
                    return;
                }
                PbFragment pbFragment = this.b;
                if (pbFragment != null) {
                    j28.e(pbFragment.getUniqueId(), this.k, postData, postData.c0, postData.b0 ? 2 : 8, "common_exp_source_pb_comment");
                }
            }
        }
    }

    public final void L(PostData postData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, postData) == null) && postData.D == 0 && postData.L) {
            StatisticItem statisticItem = new StatisticItem("c12203");
            statisticItem.param("post_id", postData.L());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("cuid", TbadkCoreApplication.getInst().getCuid());
            statisticItem.param("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            statisticItem.param("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
            statisticItem.param(TiebaStatic.Params.CUID_GID, TbadkCoreApplication.getInst().getCuidGid());
            statisticItem.param(TiebaStatic.Params.EXPOSURE_TIME, System.currentTimeMillis());
            t28 t28Var = this.a;
            if (t28Var != null) {
                int R1 = t28Var.K().R1();
                if (1 == R1 || 2 == R1) {
                    statisticItem.param("obj_source", "1");
                } else if (3 == R1) {
                    statisticItem.param("obj_source", "2");
                } else {
                    statisticItem.param("obj_source", "0");
                }
            }
            TiebaStatic.log(statisticItem);
            if (postData.s() == null || postData.s().getAlaInfo() == null || postData.s().getAlaInfo().live_status != 1) {
                return;
            }
            p0(postData);
        }
    }

    public final void M(PostData postData, PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048579, this, postData, pbTopCommenFloorItemViewHolder, i2, i3) == null) {
            if (i2 > postData.m0() + postData.M()) {
                if (pbTopCommenFloorItemViewHolder.K != null && postData.s() != null) {
                    pbTopCommenFloorItemViewHolder.K.setTag(R.id.obfuscated_res_0x7f092091, postData.s().getUserId());
                    t28 t28Var = this.a;
                    if (t28Var != null && t28Var.P() != null) {
                        pbTopCommenFloorItemViewHolder.K.setOnClickListener(this.a.P().d.c);
                    }
                    ArrayList<IconData> iconInfo = postData.s().getIconInfo();
                    int f2 = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                    pbTopCommenFloorItemViewHolder.K.g(iconInfo, i3, f2, f2, ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                }
                if (postData.X().booleanValue() && !postData.K()) {
                    pbTopCommenFloorItemViewHolder.i.setVisibility(0);
                } else {
                    pbTopCommenFloorItemViewHolder.i.setVisibility(8);
                }
            } else if (i2 > postData.M()) {
                if (postData.X().booleanValue() && !postData.K()) {
                    pbTopCommenFloorItemViewHolder.i.setVisibility(0);
                } else {
                    pbTopCommenFloorItemViewHolder.i.setVisibility(8);
                }
                pbTopCommenFloorItemViewHolder.K.setVisibility(8);
            } else {
                pbTopCommenFloorItemViewHolder.K.setVisibility(8);
                pbTopCommenFloorItemViewHolder.i.setVisibility(8);
            }
        }
    }

    public final void N(TbRichTextView tbRichTextView, View view2, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{tbRichTextView, view2, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || tbRichTextView == null || view2 == null) {
            return;
        }
        int k2 = ((((ej.k(TbadkCoreApplication.getInst()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight()) - i2;
        if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
            k2 = (k2 - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
        }
        int s = z ? s(R.dimen.tbds115) : 0;
        tbRichTextView.getLayoutStrategy().q((int) ((k2 - s) * this.i));
        tbRichTextView.getLayoutStrategy().H = (k2 - s) - s(R.dimen.tbds122);
        tbRichTextView.getLayoutStrategy().p((int) (k2 * 1.618f * this.i));
    }

    public final void O(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{pbTopCommenFloorItemViewHolder, Boolean.valueOf(z), str}) == null) {
            if (z) {
                pbTopCommenFloorItemViewHolder.U.setVisibility(8);
                if (StringUtils.isNull(str)) {
                    pbTopCommenFloorItemViewHolder.W.setText(R.string.obfuscated_res_0x7f0f05e6);
                    return;
                } else {
                    pbTopCommenFloorItemViewHolder.W.setText(str);
                    return;
                }
            }
            pbTopCommenFloorItemViewHolder.U.setVisibility(0);
            pbTopCommenFloorItemViewHolder.W.setText(R.string.obfuscated_res_0x7f0f03fb);
        }
    }

    public final void P(boolean z, PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, PostData postData) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), pbTopCommenFloorItemViewHolder, postData}) == null) || pbTopCommenFloorItemViewHolder == null || (linearLayout = pbTopCommenFloorItemViewHolder.V) == null || !(linearLayout.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            return;
        }
        boolean z2 = !ListUtils.isEmpty(postData.Z());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) pbTopCommenFloorItemViewHolder.V.getLayoutParams();
        if (z) {
            pbTopCommenFloorItemViewHolder.q.getLayoutStrategy().m(0);
            if (z2) {
                pbTopCommenFloorItemViewHolder.q.getLayoutStrategy().l(ej.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                if (layoutParams != null) {
                    layoutParams.topMargin = ej.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                }
            } else {
                pbTopCommenFloorItemViewHolder.q.getLayoutStrategy().l(ej.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                if (layoutParams != null) {
                    layoutParams.topMargin = 0;
                }
            }
            pbTopCommenFloorItemViewHolder.V.setLayoutParams(layoutParams);
        } else {
            pbTopCommenFloorItemViewHolder.q.getLayoutStrategy().l(ej.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X002));
            pbTopCommenFloorItemViewHolder.q.getLayoutStrategy().m(ej.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X001));
        }
        if (pbTopCommenFloorItemViewHolder.k0.getVisibility() != 0 && pbTopCommenFloorItemViewHolder.r0.getVisibility() != 0) {
            pbTopCommenFloorItemViewHolder.q.getLayoutStrategy().j(ej.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X001));
        } else {
            pbTopCommenFloorItemViewHolder.q.getLayoutStrategy().j(ej.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X002));
        }
    }

    public final boolean Q(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, postData)) == null) {
            if (this.k.O() == null || this.k.O().getAuthor() == null || this.k.O().getAuthor().getUserId() == null || postData == null || postData.s() == null || postData.s().getUserId() == null) {
                return false;
            }
            return this.k.O().getAuthor().getUserId().equals(postData.s().getUserId());
        }
        return invokeL.booleanValue;
    }

    public final void R(View view2) {
        PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder;
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) || view2 == null || !(view2.getTag() instanceof PbTopCommenFloorItemViewHolder) || (agreeView = (pbTopCommenFloorItemViewHolder = (PbTopCommenFloorItemViewHolder) view2.getTag()).c0) == null || agreeView.getData() == null) {
            return;
        }
        pbTopCommenFloorItemViewHolder.c0.setAgreeSource(2);
        pbTopCommenFloorItemViewHolder.c0.J();
    }

    public final void S(PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, postData) == null) {
            if (postData != null) {
                StatisticItem i2 = j28.i(this.k, postData, postData.c0, postData.b0 ? 2 : 8, 6);
                postData.d0 = i2;
                if (!ListUtils.isEmpty(postData.Z())) {
                    Iterator<PostData> it = postData.Z().iterator();
                    while (it.hasNext()) {
                        it.next().d0 = i2;
                    }
                }
            }
            j28.p("c14887");
        }
    }

    public final void T(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, pbTopCommenFloorItemViewHolder, postData) == null) {
            if (!TextUtils.isEmpty(postData.t()) && this.h && !h0()) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbTopCommenFloorItemViewHolder.r.getLayoutParams();
                layoutParams.topMargin = s(R.dimen.obfuscated_res_0x7f0701d5);
                layoutParams.bottomMargin = s(R.dimen.obfuscated_res_0x7f0701d5);
                pbTopCommenFloorItemViewHolder.r.setLayoutParams(layoutParams);
                if (!TextUtils.isEmpty(postData.y())) {
                    pbTopCommenFloorItemViewHolder.s.setVisibility(0);
                    pbTopCommenFloorItemViewHolder.s.k(yn4.a(postData.y()));
                } else {
                    pbTopCommenFloorItemViewHolder.s.setVisibility(8);
                }
                pbTopCommenFloorItemViewHolder.q.k0(postData.t());
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbTopCommenFloorItemViewHolder.r.getLayoutParams();
                layoutParams2.bottomMargin = 0;
                layoutParams2.topMargin = 0;
                pbTopCommenFloorItemViewHolder.r.setLayoutParams(layoutParams2);
                pbTopCommenFloorItemViewHolder.q.setPadding(0, 0, 0, 0);
                pbTopCommenFloorItemViewHolder.q.k0(null);
                pbTopCommenFloorItemViewHolder.s.setVisibility(8);
            }
            pbTopCommenFloorItemViewHolder.q.setTextViewOnTouchListener(this.w);
            pbTopCommenFloorItemViewHolder.q.setTextViewCheckSelection(false);
        }
    }

    public final void U(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, PostData postData) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, pbTopCommenFloorItemViewHolder, postData) == null) || pbTopCommenFloorItemViewHolder == null || postData == null || (imageView = pbTopCommenFloorItemViewHolder.L) == null || this.k == null) {
            return;
        }
        imageView.setVisibility(8);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void V(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, PostData postData) {
        boolean z;
        jv7 jv7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, pbTopCommenFloorItemViewHolder, postData) == null) || pbTopCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        String str = null;
        boolean z2 = true;
        if (postData.s() != null) {
            str = postData.s().getIpAddress();
            if (!TextUtils.isEmpty(str)) {
                z = true;
                j45 S = postData.S();
                z2 = (S != null || StringUtils.isNull(S.b()) || (jv7Var = this.k) == null || jv7Var.i0()) ? false : false;
                pbTopCommenFloorItemViewHolder.l.setVisibility(8);
                if (z2 && !z) {
                    pbTopCommenFloorItemViewHolder.m.setVisibility(8);
                } else {
                    pbTopCommenFloorItemViewHolder.m.setVisibility(0);
                }
                if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.f0()), "yyyy"))) {
                    pbTopCommenFloorItemViewHolder.k.setText(StringHelper.getFormatTimeShort(postData.f0()));
                } else {
                    pbTopCommenFloorItemViewHolder.k.setText(StringHelper.getFormatTime(postData.f0()));
                }
                if (!z) {
                    pbTopCommenFloorItemViewHolder.n.setVisibility(0);
                    TextView textView = pbTopCommenFloorItemViewHolder.n;
                    textView.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f150a) + str);
                } else if (z2) {
                    pbTopCommenFloorItemViewHolder.n.setVisibility(0);
                    if (postData.a0) {
                        pbTopCommenFloorItemViewHolder.n.setText(StringHelper.cutStringWithSuffix(S.b(), 7, StringHelper.STRING_MORE));
                    } else {
                        pbTopCommenFloorItemViewHolder.n.setText(S.b());
                    }
                } else {
                    pbTopCommenFloorItemViewHolder.n.setVisibility(8);
                }
                TextView textView2 = pbTopCommenFloorItemViewHolder.f0;
                textView2.setText(((Object) pbTopCommenFloorItemViewHolder.k.getText()) + "  • ");
            }
        }
        z = false;
        j45 S2 = postData.S();
        if (S2 != null) {
        }
        pbTopCommenFloorItemViewHolder.l.setVisibility(8);
        if (z2) {
        }
        pbTopCommenFloorItemViewHolder.m.setVisibility(0);
        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.f0()), "yyyy"))) {
        }
        if (!z) {
        }
        TextView textView22 = pbTopCommenFloorItemViewHolder.f0;
        textView22.setText(((Object) pbTopCommenFloorItemViewHolder.k.getText()) + "  • ");
    }

    public final void W(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, pbTopCommenFloorItemViewHolder, postData) == null) || pbTopCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        pbTopCommenFloorItemViewHolder.Z.setVisibility(postData.a0 ? 0 : 8);
    }

    public final void X(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, PostData postData, View view2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048590, this, pbTopCommenFloorItemViewHolder, postData, view2, i2) == null) || pbTopCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        pbTopCommenFloorItemViewHolder.u.setVisibility(8);
        pbTopCommenFloorItemViewHolder.b0.setVisibility(0);
        pbTopCommenFloorItemViewHolder.e0.setVisibility(8);
        g0(pbTopCommenFloorItemViewHolder, postData, view2, i2);
        U(pbTopCommenFloorItemViewHolder, postData);
        Y(pbTopCommenFloorItemViewHolder, postData);
        b0(pbTopCommenFloorItemViewHolder, postData, view2);
        V(pbTopCommenFloorItemViewHolder, postData);
        d0(pbTopCommenFloorItemViewHolder, postData);
        Z(pbTopCommenFloorItemViewHolder, postData);
        w0(pbTopCommenFloorItemViewHolder, postData);
        e0(pbTopCommenFloorItemViewHolder, postData);
        T(pbTopCommenFloorItemViewHolder, postData);
        W(pbTopCommenFloorItemViewHolder, postData);
        c0(pbTopCommenFloorItemViewHolder, postData);
        f0(pbTopCommenFloorItemViewHolder, postData);
        a0(pbTopCommenFloorItemViewHolder, postData);
    }

    public final void Y(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048591, this, pbTopCommenFloorItemViewHolder, postData) == null) || pbTopCommenFloorItemViewHolder == null || postData == null || postData.q() == null) {
            return;
        }
        postData.q().threadId = this.a.K().m2();
        postData.q().objType = 1;
        postData.q().isInPost = true;
        ThreadData threadData = null;
        jv7 jv7Var = this.k;
        if (jv7Var != null && jv7Var.O() != null) {
            threadData = this.k.O();
        }
        pbTopCommenFloorItemViewHolder.c0.setThreadData(threadData);
        pbTopCommenFloorItemViewHolder.c0.setData(postData.q());
    }

    public final void Z(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, PostData postData) {
        AlaLiveInfoCoreData alaLiveInfoCoreData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048592, this, pbTopCommenFloorItemViewHolder, postData) == null) || pbTopCommenFloorItemViewHolder == null || pbTopCommenFloorItemViewHolder.S == null || pbTopCommenFloorItemViewHolder.P == null) {
            return;
        }
        if (postData != null && (alaLiveInfoCoreData = postData.S) != null && !StringUtils.isNull(alaLiveInfoCoreData.liveTitle)) {
            pbTopCommenFloorItemViewHolder.S.setText(postData.S.liveTitle);
            pbTopCommenFloorItemViewHolder.P.setTag(postData.S);
            pbTopCommenFloorItemViewHolder.P.setVisibility(0);
            StatisticItem statisticItem = new StatisticItem("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(statisticItem);
            return;
        }
        pbTopCommenFloorItemViewHolder.P.setVisibility(8);
    }

    public final void a0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, pbTopCommenFloorItemViewHolder, postData) == null) {
            if (postData.b0() != 0) {
                pbTopCommenFloorItemViewHolder.o.setVisibility(0);
                TextView textView = pbTopCommenFloorItemViewHolder.o;
                textView.setText("查看全部" + postData.b0() + "条数据");
                return;
            }
            pbTopCommenFloorItemViewHolder.o.setVisibility(8);
        }
    }

    public final void b0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, PostData postData, View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048594, this, pbTopCommenFloorItemViewHolder, postData, view2) == null) || pbTopCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbTopCommenFloorItemViewHolder.r.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        layoutParams.rightMargin = ej.f(this.mContext, R.dimen.M_W_X007);
        layoutParams.leftMargin = ej.f(this.mContext, R.dimen.M_W_X007);
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = 0;
        pbTopCommenFloorItemViewHolder.q.setPadding(0, 0, 0, 0);
        if (!this.h) {
            pbTopCommenFloorItemViewHolder.q.getLayoutStrategy().g(R.drawable.icon_click);
        } else {
            pbTopCommenFloorItemViewHolder.q.k0(null);
            pbTopCommenFloorItemViewHolder.q.setBackgroundDrawable(null);
            pbTopCommenFloorItemViewHolder.q.getLayoutStrategy().g(R.drawable.obfuscated_res_0x7f081240);
        }
        pbTopCommenFloorItemViewHolder.q.getLayoutStrategy().x(R.drawable.pic_video);
        N(pbTopCommenFloorItemViewHolder.q, view2, !StringUtils.isNull(postData.t()), layoutParams.leftMargin + layoutParams.rightMargin);
        pbTopCommenFloorItemViewHolder.r.setLayoutParams(layoutParams);
        pbTopCommenFloorItemViewHolder.q.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        pbTopCommenFloorItemViewHolder.q.setIsFromCDN(this.e);
        pbTopCommenFloorItemViewHolder.q.setText(postData.W(), true, this.g);
        SparseArray sparseArray = (SparseArray) pbTopCommenFloorItemViewHolder.q.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        sparseArray.put(R.id.obfuscated_res_0x7f09203c, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f092055, Boolean.FALSE);
        sparseArray.put(R.id.obfuscated_res_0x7f092056, Boolean.TRUE);
        pbTopCommenFloorItemViewHolder.q.setTag(sparseArray);
        pbTopCommenFloorItemViewHolder.b.setTag(R.id.obfuscated_res_0x7f09204f, sparseArray);
        pbTopCommenFloorItemViewHolder.d0.setTag(sparseArray);
        pbTopCommenFloorItemViewHolder.s.setTag(sparseArray);
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.h = z;
        }
    }

    public final void c0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048596, this, pbTopCommenFloorItemViewHolder, postData) == null) || pbTopCommenFloorItemViewHolder == null || pbTopCommenFloorItemViewHolder.b == null) {
            return;
        }
        t28 t28Var = this.a;
        if (t28Var != null && t28Var.K() != null && StringHelper.equals(this.a.K().t1(), postData.L())) {
            SkinManager.setBackgroundColor(pbTopCommenFloorItemViewHolder.b, R.color.CAM_X0313);
        } else {
            SkinManager.setBackgroundColor(pbTopCommenFloorItemViewHolder.b, R.color.CAM_X0205);
        }
    }

    public void d(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, onLongClickListener) == null) {
            this.o = onLongClickListener;
        }
    }

    public final void d0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, pbTopCommenFloorItemViewHolder, postData) == null) {
            if (postData != null && postData.c0() != null && !h0()) {
                TbRichText W = postData.W();
                q38.c(postData.c0(), pbTopCommenFloorItemViewHolder.M, pbTopCommenFloorItemViewHolder.N, pbTopCommenFloorItemViewHolder.O, false, true, W != null && StringUtils.isNull(W.toString()) && StringUtils.isNull(postData.t()));
                return;
            }
            pbTopCommenFloorItemViewHolder.M.setVisibility(8);
            pbTopCommenFloorItemViewHolder.N.setVisibility(8);
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, onClickListener) == null) {
            this.l = onClickListener;
        }
    }

    public final void e0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, pbTopCommenFloorItemViewHolder, postData) == null) {
            if (postData.G() != 2 && postData.G() != 4) {
                pbTopCommenFloorItemViewHolder.V.setVisibility(8);
                pbTopCommenFloorItemViewHolder.U.setVisibility(0);
                P(false, pbTopCommenFloorItemViewHolder, postData);
            } else {
                pbTopCommenFloorItemViewHolder.V.setOnClickListener(new g(this, pbTopCommenFloorItemViewHolder, postData));
                pbTopCommenFloorItemViewHolder.V.setVisibility(0);
                O(pbTopCommenFloorItemViewHolder, postData.r0(), postData.F());
                P(true, pbTopCommenFloorItemViewHolder, postData);
            }
            o0(pbTopCommenFloorItemViewHolder, postData);
        }
    }

    public final void f0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048601, this, pbTopCommenFloorItemViewHolder, postData) == null) || pbTopCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        pbTopCommenFloorItemViewHolder.e(postData.R, postData.L(), this.r);
    }

    /* JADX WARN: Removed duplicated region for block: B:283:0x081b  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x081f  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x0828  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x0831  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x0874  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x087b  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x08e4  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x08ee  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x0930  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void g0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, PostData postData, View view2, int i2) {
        int i3;
        int i4;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048602, this, pbTopCommenFloorItemViewHolder, postData, view2, i2) == null) || pbTopCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        if (postData.s() != null) {
            postData.s().isBaijiahaoUser();
        }
        SkinManager.setBackgroundColor(pbTopCommenFloorItemViewHolder.e, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(pbTopCommenFloorItemViewHolder.d, R.color.CAM_X0204);
        pbTopCommenFloorItemViewHolder.d.setVisibility(0);
        pbTopCommenFloorItemViewHolder.p.setTag(null);
        pbTopCommenFloorItemViewHolder.p.setUserId(null);
        pbTopCommenFloorItemViewHolder.I.getHeadView().setUserId(null);
        pbTopCommenFloorItemViewHolder.q.setIsHost(false);
        if (postData.s() != null) {
            String str = this.j;
            if (str != null && !str.equals("0") && this.j.equals(postData.s().getUserId())) {
                pbTopCommenFloorItemViewHolder.q.setIsHost(true);
            }
            ArrayList<IconData> iconInfo = postData.s().getIconInfo();
            ArrayList<IconData> tShowInfoNew = postData.s().getTShowInfoNew();
            int f2 = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds40);
            int f3 = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            if (iconInfo.size() < 2) {
                i3 = iconInfo.size();
                if (i3 > 1) {
                    postData.e1((f2 * i3) + (f3 * i3));
                } else if (i3 == 1) {
                    postData.e1(f2 + f3);
                } else {
                    postData.e1(0);
                }
            } else {
                postData.e1((f2 * 2) + (f3 * 2));
                i3 = 2;
            }
            if (pbTopCommenFloorItemViewHolder.J != null) {
                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                    pbTopCommenFloorItemViewHolder.J.setTag(tShowInfoNew.get(0).getUrl());
                }
                t28 t28Var = this.a;
                if (t28Var != null && t28Var.P() != null) {
                    pbTopCommenFloorItemViewHolder.J.setOnClickListener(this.a.P().d.e);
                }
                int f4 = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                pbTopCommenFloorItemViewHolder.J.h(tShowInfoNew, 3, f4, f4, ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
            }
            if (ListUtils.isEmpty(tShowInfoNew) && !postData.s().isBigV()) {
                if (UbsABTestHelper.isPBPlanA()) {
                    if (DeviceInfoUtil.isMate30()) {
                        lz7.m(pbTopCommenFloorItemViewHolder.g);
                    } else {
                        hv4.d(pbTopCommenFloorItemViewHolder.g).A(R.string.F_X02);
                    }
                    SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.g, R.color.CAM_X0108, 1);
                } else {
                    SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.g, R.color.CAM_X0107, 1);
                }
            } else {
                SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.g, R.color.CAM_X0301, 1);
            }
            String avater = postData.s().getAvater();
            int i5 = postData.b0 ? 2 : 8;
            pbTopCommenFloorItemViewHolder.o.setTag(R.id.obfuscated_res_0x7f09206c, postData);
            pbTopCommenFloorItemViewHolder.o.setTag(R.id.obfuscated_res_0x7f092056, Boolean.TRUE);
            pbTopCommenFloorItemViewHolder.g.setTag(R.id.obfuscated_res_0x7f092091, postData.s().getUserId());
            pbTopCommenFloorItemViewHolder.g.setTag(R.id.obfuscated_res_0x7f092056, Boolean.TRUE);
            pbTopCommenFloorItemViewHolder.g.setTag(R.id.obfuscated_res_0x7f092099, postData.s().getUserName());
            pbTopCommenFloorItemViewHolder.g.setTag(R.id.obfuscated_res_0x7f09209b, postData.s().getVirtualUserUrl());
            pbTopCommenFloorItemViewHolder.g.setTag(R.id.obfuscated_res_0x7f092087, j28.i(this.k, postData, postData.c0, i5, 2));
            String name_show = postData.s().getName_show();
            String userName = postData.s().getUserName();
            if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                pbTopCommenFloorItemViewHolder.h.setText(ju7.b(this.mContext, pbTopCommenFloorItemViewHolder.g.getText().toString()));
                pbTopCommenFloorItemViewHolder.g.setGravity(16);
                pbTopCommenFloorItemViewHolder.g.setTag(R.id.obfuscated_res_0x7f092066, ju7.a());
                SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.g, R.color.CAM_X0312, 1);
            }
            if (postData.s().getPendantData() != null && !StringUtils.isNull(postData.s().getPendantData().getImgUrl())) {
                pbTopCommenFloorItemViewHolder.I.setBigVDimenSize(R.dimen.tbds36);
                pbTopCommenFloorItemViewHolder.I.j(postData.s(), 4);
                pbTopCommenFloorItemViewHolder.p.setVisibility(8);
                pbTopCommenFloorItemViewHolder.I.setVisibility(0);
                pbTopCommenFloorItemViewHolder.I.getHeadView().K(avater, 28, false);
                pbTopCommenFloorItemViewHolder.I.getHeadView().setUserId(postData.s().getUserId());
                pbTopCommenFloorItemViewHolder.I.getHeadView().setUserName(postData.s().getUserName());
                jv7 jv7Var = this.k;
                pbTopCommenFloorItemViewHolder.I.getHeadView().setFid(jv7Var != null ? jv7Var.m() : "");
                jv7 jv7Var2 = this.k;
                pbTopCommenFloorItemViewHolder.I.getHeadView().setFName(jv7Var2 != null ? jv7Var2.n() : "");
                pbTopCommenFloorItemViewHolder.I.getHeadView().setFloor(postData.C());
                pbTopCommenFloorItemViewHolder.I.getHeadView().setTid(postData.L());
                pbTopCommenFloorItemViewHolder.I.getHeadView().setTag(R.id.obfuscated_res_0x7f092087, j28.i(this.k, postData, postData.c0, i5, 2));
                pbTopCommenFloorItemViewHolder.I.setTag(R.id.obfuscated_res_0x7f092056, Boolean.TRUE);
                pbTopCommenFloorItemViewHolder.I.m(postData.s().getPendantData().getImgUrl());
            } else {
                pbTopCommenFloorItemViewHolder.p.setGodIconWidth(R.dimen.tbds36);
                UtilHelper.showHeadImageViewBigV(pbTopCommenFloorItemViewHolder.p, postData.s(), 4);
                pbTopCommenFloorItemViewHolder.p.setUserId(postData.s().getUserId());
                jv7 jv7Var3 = this.k;
                pbTopCommenFloorItemViewHolder.p.setFid(jv7Var3 != null ? jv7Var3.m() : "");
                jv7 jv7Var4 = this.k;
                pbTopCommenFloorItemViewHolder.p.setFName(jv7Var4 != null ? jv7Var4.n() : "");
                pbTopCommenFloorItemViewHolder.p.setFloor(postData.C());
                pbTopCommenFloorItemViewHolder.p.setTid(postData.L());
                pbTopCommenFloorItemViewHolder.p.setUserName(postData.s().getUserName(), postData.h0());
                pbTopCommenFloorItemViewHolder.p.setTag(R.id.obfuscated_res_0x7f09209b, postData.s().getVirtualUserUrl());
                pbTopCommenFloorItemViewHolder.p.setTag(R.id.obfuscated_res_0x7f092056, Boolean.TRUE);
                pbTopCommenFloorItemViewHolder.p.setTag(R.id.obfuscated_res_0x7f092087, j28.i(this.k, postData, postData.c0, i5, 2));
                pbTopCommenFloorItemViewHolder.p.setImageDrawable(null);
                pbTopCommenFloorItemViewHolder.p.K(avater, 28, false);
                pbTopCommenFloorItemViewHolder.p.setVisibility(0);
                pbTopCommenFloorItemViewHolder.I.setVisibility(8);
            }
            if (postData.s() != null && postData.s().getAlaInfo() != null && postData.s().getAlaUserData() != null && postData.s().getAlaUserData().live_status == 1) {
                pbTopCommenFloorItemViewHolder.d(true);
                pbTopCommenFloorItemViewHolder.p.setLiveStatus(1);
                pbTopCommenFloorItemViewHolder.p.setAlaInfo(postData.s().getAlaInfo());
                pbTopCommenFloorItemViewHolder.I.getHeadView().setLiveStatus(1);
                pbTopCommenFloorItemViewHolder.I.getHeadView().setAlaInfo(postData.s().getAlaInfo());
            } else {
                pbTopCommenFloorItemViewHolder.d(false);
                pbTopCommenFloorItemViewHolder.p.setLiveStatus(0);
                pbTopCommenFloorItemViewHolder.p.setAlaInfo(null);
                pbTopCommenFloorItemViewHolder.I.getHeadView().setLiveStatus(0);
                pbTopCommenFloorItemViewHolder.I.getHeadView().setAlaInfo(null);
            }
            y0(pbTopCommenFloorItemViewHolder.i, postData);
            if (TbSingleton.getInstance().isUserGrowthOpen() && postData.s().getUserGrowthData() != null) {
                int a2 = postData.s().getUserGrowthData().a();
                if (a2 >= 0 && a2 <= 10) {
                    pbTopCommenFloorItemViewHolder.j.setImageResource(kx.b(a2));
                    pbTopCommenFloorItemViewHolder.j.setVisibility(0);
                    pbTopCommenFloorItemViewHolder.j.setOnClickListener(new h(this, a2));
                    CommonStatisticUtils.staticNameplateOfUserLevel(1, 4, a2);
                } else {
                    pbTopCommenFloorItemViewHolder.j.setVisibility(8);
                }
            }
        } else {
            i3 = 2;
        }
        t28 t28Var2 = this.a;
        int level_id = (t28Var2 == null || t28Var2.P() == null || !this.a.P().u0() || postData.s() == null) ? 0 : postData.s().getLevel_id();
        jv7 jv7Var5 = this.k;
        if (jv7Var5 != null && jv7Var5.i0()) {
            level_id = 0;
        }
        if (level_id > 0) {
            pbTopCommenFloorItemViewHolder.H.setVisibility(0);
            SkinManager.setImageResource(pbTopCommenFloorItemViewHolder.H, BitmapHelper.getGradeResourceIdInEnterForum(level_id));
        } else {
            pbTopCommenFloorItemViewHolder.H.setVisibility(8);
        }
        int i6 = 15;
        if (i3 == 1) {
            i6 = 13;
        } else if (i3 > 1) {
            i6 = 11;
        }
        if (pbTopCommenFloorItemViewHolder.i.getVisibility() == 0) {
            i6 -= 2;
        }
        if (pbTopCommenFloorItemViewHolder.J.getChildCount() > 0) {
            i6 -= 2;
        }
        if (postData.x() > 1000) {
            i6 -= 2;
        }
        if (postData.x() > 10) {
            i6 -= 2;
        }
        if (i6 < 10) {
            if (i3 == 1) {
                i6 += 2;
            } else if (i3 > 1) {
                i6 += 4;
            }
            if (i6 < 10 && pbTopCommenFloorItemViewHolder.i.getVisibility() == 0) {
                i6 += 2;
                pbTopCommenFloorItemViewHolder.i.setVisibility(8);
            }
            if (i6 < 10 && pbTopCommenFloorItemViewHolder.H.getVisibility() == 0) {
                pbTopCommenFloorItemViewHolder.H.setVisibility(8);
            }
        }
        int e2 = lz7.e();
        String name_show2 = (postData.s() == null || postData.s().getName_show() == null) ? "" : postData.s().getName_show();
        int d2 = ji5.d(name_show2);
        if (postData.s() != null && !StringUtils.isNull(postData.s().getSealPrefix())) {
            int i7 = e2 - 2;
            if (d2 > i7) {
                name_show2 = ji5.n(name_show2, i7) + StringHelper.STRING_MORE;
            }
        } else if (d2 > e2) {
            name_show2 = ji5.n(name_show2, e2) + StringHelper.STRING_MORE;
        }
        if (postData.s() != null && !StringUtils.isNull(postData.s().getSealPrefix())) {
            pbTopCommenFloorItemViewHolder.h.setText(i0(postData.s().getSealPrefix(), name_show2));
        } else {
            pbTopCommenFloorItemViewHolder.h.setText(name_show2);
        }
        if (((PostData) getItem(i2)).O() == 1 && this.k.O() != null && this.k.O().isQuestionThread() && !Q(postData)) {
            ((PostData) getItem(i2)).I0(true);
            pbTopCommenFloorItemViewHolder.p0.setVisibility(0);
            if (((PostData) getItem(i2)).N().booleanValue()) {
                pbTopCommenFloorItemViewHolder.q0.setVisibility(0);
                pbTopCommenFloorItemViewHolder.c0.setVisibility(8);
                pbTopCommenFloorItemViewHolder.d0.setVisibility(8);
                pbTopCommenFloorItemViewHolder.q0.postDelayed(new i(this, pbTopCommenFloorItemViewHolder), 3000L);
            } else {
                pbTopCommenFloorItemViewHolder.q0.setVisibility(8);
                pbTopCommenFloorItemViewHolder.c0.setVisibility(0);
                pbTopCommenFloorItemViewHolder.d0.setVisibility(0);
            }
        } else {
            ((PostData) getItem(i2)).I0(false);
            pbTopCommenFloorItemViewHolder.p0.setVisibility(8);
            pbTopCommenFloorItemViewHolder.q0.setVisibility(8);
            pbTopCommenFloorItemViewHolder.c0.setVisibility(0);
            pbTopCommenFloorItemViewHolder.d0.setVisibility(0);
        }
        ImageView imageView = pbTopCommenFloorItemViewHolder.A;
        if (imageView != null) {
            SparseArray sparseArray = (SparseArray) imageView.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                pbTopCommenFloorItemViewHolder.A.setTag(sparseArray);
            }
            sparseArray.put(R.id.obfuscated_res_0x7f092059, postData);
        }
        ImageView imageView2 = pbTopCommenFloorItemViewHolder.B;
        if (imageView2 != null) {
            SparseArray sparseArray2 = (SparseArray) imageView2.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                pbTopCommenFloorItemViewHolder.B.setTag(sparseArray2);
            }
            sparseArray2.put(R.id.obfuscated_res_0x7f092059, postData);
        }
        SkinManager.setBackgroundResource(pbTopCommenFloorItemViewHolder.p0, R.color.CAM_X0204);
        SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.t0, R.color.CAM_X0105, 1);
        pbTopCommenFloorItemViewHolder.f.post(new j(this, pbTopCommenFloorItemViewHolder, new String[]{name_show2}, postData, 2));
        if (!StringUtils.isNull(postData.s().getDiplayIntro())) {
            i4 = 0;
            pbTopCommenFloorItemViewHolder.r0.setVisibility(0);
            pbTopCommenFloorItemViewHolder.r0.setText(postData.s().getDiplayIntro() + "");
        } else {
            i4 = 0;
            pbTopCommenFloorItemViewHolder.r0.setVisibility(8);
        }
        SparseArray sparseArray3 = new SparseArray();
        sparseArray3.put(R.id.obfuscated_res_0x7f09203c, postData);
        sparseArray3.put(R.id.obfuscated_res_0x7f092059, postData);
        sparseArray3.put(R.id.obfuscated_res_0x7f09205b, view2);
        sparseArray3.put(R.id.obfuscated_res_0x7f09206a, Integer.valueOf(i2));
        sparseArray3.put(R.id.obfuscated_res_0x7f092069, Integer.valueOf(postData.C()));
        sparseArray3.put(R.id.obfuscated_res_0x7f09204c, postData.L());
        sparseArray3.put(R.id.obfuscated_res_0x7f0917f0, pbTopCommenFloorItemViewHolder.c0);
        sparseArray3.put(R.id.obfuscated_res_0x7f0917ed, pbTopCommenFloorItemViewHolder.A);
        sparseArray3.put(R.id.obfuscated_res_0x7f0917ee, pbTopCommenFloorItemViewHolder.B);
        jv7 jv7Var6 = this.k;
        ThreadData O = (jv7Var6 == null || jv7Var6.O() == null) ? null : this.k.O();
        if (O != null && O.isUgcThreadType()) {
            sparseArray3.put(R.id.obfuscated_res_0x7f0917ec, Boolean.TRUE);
        } else {
            sparseArray3.put(R.id.obfuscated_res_0x7f0917ec, Boolean.FALSE);
        }
        boolean z7 = (postData.s() == null || StringUtils.isNull(postData.s().getVirtualUserUrl())) ? false : true;
        jv7 jv7Var7 = this.k;
        if (jv7Var7 == null || jv7Var7.W() == 0 || k0()) {
            z = false;
            z2 = false;
        } else {
            z = (this.k.W() == 1002 || this.k.W() == 3) ? false : true;
            z2 = (this.k.W() == 3 || this.k.i0()) ? false : true;
            if (postData != null && postData.s() != null) {
                String userId = postData.s().getUserId();
                if (UtilHelper.isCurrentAccount(userId)) {
                    z = false;
                }
                if (userId == null || userId.equals("0") || userId.length() == 0) {
                    z = false;
                }
            }
        }
        jv7 jv7Var8 = this.k;
        if (jv7Var8 != null && jv7Var8.O() != null && this.k.O().getAuthor() != null && postData.s() != null) {
            String userId2 = this.k.O().getAuthor().getUserId();
            String userId3 = postData.s().getUserId();
            if (UtilHelper.isCurrentAccount(userId2)) {
                if (UtilHelper.isCurrentAccount(userId3)) {
                    z2 = true;
                    z3 = false;
                    z4 = true;
                } else {
                    z2 = true;
                    z3 = true;
                    z4 = false;
                }
                z5 = true;
                if (postData != null && postData.s() != null && UtilHelper.isCurrentAccount(postData.s().getUserId())) {
                    z2 = true;
                    z4 = true;
                }
                if (z7) {
                    z6 = z;
                } else {
                    z2 = false;
                    z3 = false;
                    z6 = false;
                }
                if (postData.C() != 1) {
                    i4 = 1;
                }
                if (!z6) {
                    sparseArray3.put(R.id.obfuscated_res_0x7f092084, Boolean.TRUE);
                    sparseArray3.put(R.id.obfuscated_res_0x7f09205c, Integer.valueOf(this.k.W()));
                    if (postData.s() != null) {
                        sparseArray3.put(R.id.obfuscated_res_0x7f092049, postData.s().getUserName());
                        sparseArray3.put(R.id.obfuscated_res_0x7f09204a, postData.s().getName_show());
                        sparseArray3.put(R.id.obfuscated_res_0x7f09204b, postData.s().getPortrait());
                    }
                } else {
                    sparseArray3.put(R.id.obfuscated_res_0x7f092084, Boolean.FALSE);
                }
                if (!z3) {
                    sparseArray3.put(R.id.obfuscated_res_0x7f092098, Boolean.TRUE);
                    sparseArray3.put(R.id.obfuscated_res_0x7f092053, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.s() != null) {
                        sparseArray3.put(R.id.obfuscated_res_0x7f092094, postData.s().getUserId());
                        sparseArray3.put(R.id.obfuscated_res_0x7f092095, postData.s().getUserName());
                        sparseArray3.put(R.id.obfuscated_res_0x7f092093, postData.s().getName_show());
                    }
                    if (this.k.O() != null) {
                        sparseArray3.put(R.id.obfuscated_res_0x7f092097, this.k.O().getId());
                    }
                    sparseArray3.put(R.id.obfuscated_res_0x7f092096, postData.L());
                } else {
                    sparseArray3.put(R.id.obfuscated_res_0x7f092098, Boolean.FALSE);
                }
                if (!z2) {
                    sparseArray3.put(R.id.obfuscated_res_0x7f092082, Boolean.TRUE);
                    sparseArray3.put(R.id.obfuscated_res_0x7f092050, Boolean.valueOf(postData.o0()));
                    sparseArray3.put(R.id.obfuscated_res_0x7f09205c, Integer.valueOf(this.k.W()));
                    sparseArray3.put(R.id.obfuscated_res_0x7f09203f, Boolean.valueOf(z4));
                    sparseArray3.put(R.id.obfuscated_res_0x7f092040, Integer.valueOf(i4));
                    sparseArray3.put(R.id.obfuscated_res_0x7f09203e, postData.L());
                } else {
                    sparseArray3.put(R.id.obfuscated_res_0x7f092082, Boolean.FALSE);
                }
                sparseArray3.put(R.id.obfuscated_res_0x7f092054, Boolean.valueOf(z5));
                pbTopCommenFloorItemViewHolder.q.setTag(sparseArray3);
                pbTopCommenFloorItemViewHolder.s.setTag(sparseArray3);
            }
        }
        z3 = false;
        z4 = false;
        z5 = false;
        if (postData != null) {
            z2 = true;
            z4 = true;
        }
        if (z7) {
        }
        if (postData.C() != 1) {
        }
        if (!z6) {
        }
        if (!z3) {
        }
        if (!z2) {
        }
        sparseArray3.put(R.id.obfuscated_res_0x7f092054, Boolean.valueOf(z5));
        pbTopCommenFloorItemViewHolder.q.setTag(sparseArray3);
        pbTopCommenFloorItemViewHolder.s.setTag(sparseArray3);
    }

    public final boolean h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            jv7 jv7Var = this.k;
            if (jv7Var == null || jv7Var.O() == null) {
                return true;
            }
            return this.k.O().isQuestionThread();
        }
        return invokeV.booleanValue;
    }

    public final SpannableStringBuilder i0(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, str, str2)) == null) {
            ArrayList arrayList = new ArrayList();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (str2 == null || str == null) {
                return spannableStringBuilder;
            }
            arrayList.add(new t16.a(str, R.drawable.pic_smalldot_title));
            return t16.h(this.a.P(), str2, arrayList, true);
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public final String j0(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, view2)) == null) {
            SparseArray sparseArray = (SparseArray) view2.getTag();
            if (sparseArray == null) {
                return "1";
            }
            Object obj = sparseArray.get(R.id.obfuscated_res_0x7f09188c);
            String str = obj != null ? obj : "1";
            sparseArray.remove(R.id.obfuscated_res_0x7f09188c);
            view2.setTag(sparseArray);
            return str.toString();
        }
        return (String) invokeL.objValue;
    }

    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, onClickListener) == null) {
        }
    }

    public final boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            jv7 jv7Var = this.k;
            if (jv7Var == null || jv7Var.O() == null) {
                return false;
            }
            return this.k.O().isBlocked();
        }
        return invokeV.booleanValue;
    }

    public void l0(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, metaData) == null) {
            PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(this.mContext, metaData.getUserIdLong(), metaData.getUserName(), metaData.getName_show(), metaData.getPortrait(), metaData.getGender(), metaData.getIsMyFriend());
            personalChatActivityConfig.setFrom(3);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, personalChatActivityConfig));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: m0 */
    public PbTopCommenFloorItemViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d06e4, viewGroup, false);
            ((ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f09186e)).addView(LayoutInflater.from(inflate.getContext()).inflate(R.layout.obfuscated_res_0x7f0d06db, (ViewGroup) null));
            PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder = new PbTopCommenFloorItemViewHolder(this.a.P().getPageContext(), inflate, this.q);
            pbTopCommenFloorItemViewHolder.t.setConstrainLayoutPool(this.u);
            pbTopCommenFloorItemViewHolder.t.setImageViewPool(this.v);
            v0(pbTopCommenFloorItemViewHolder);
            TbRichTextView tbRichTextView = pbTopCommenFloorItemViewHolder.q;
            if (tbRichTextView != null) {
                tbRichTextView.setDuiEnabled(this.p);
            }
            return pbTopCommenFloorItemViewHolder;
        }
        return (PbTopCommenFloorItemViewHolder) invokeL.objValue;
    }

    public void n(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, yVar) == null) {
            this.m = yVar;
        }
    }

    public View n0(int i2, View view2, ViewGroup viewGroup, PostData postData, PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048611, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, postData, pbTopCommenFloorItemViewHolder})) == null) {
            super.onFillViewHolder(i2, view2, viewGroup, postData, pbTopCommenFloorItemViewHolder);
            v0(pbTopCommenFloorItemViewHolder);
            q0(pbTopCommenFloorItemViewHolder, i2);
            I(pbTopCommenFloorItemViewHolder);
            PostData postData2 = (PostData) getItem(i2);
            if (postData2 != null) {
                postData2.c0 = i2 + 1;
                L(postData2);
                K(postData2);
                postData2.i1();
                S(postData2);
                X(pbTopCommenFloorItemViewHolder, postData2, view2, i2);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            this.j = str;
        }
    }

    public final void o0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048613, this, pbTopCommenFloorItemViewHolder, postData) == null) {
            TbRichText W = postData.W();
            W.isChanged = true;
            pbTopCommenFloorItemViewHolder.q.setText(W, true, this.g);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, view2) == null) {
        }
    }

    @Override // com.baidu.tieba.ay7, com.baidu.tieba.qn
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i2, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        n0(i2, view2, viewGroup, (PostData) obj, (PbTopCommenFloorItemViewHolder) viewHolder);
        return view2;
    }

    public final void p0(PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, postData) == null) {
            String userId = postData.s().getUserId();
            jv7 jv7Var = this.k;
            String m = jv7Var != null ? jv7Var.m() : "";
            jv7 jv7Var2 = this.k;
            String n = jv7Var2 != null ? jv7Var2.n() : "";
            int C = postData.C();
            String L = postData.L();
            StatisticItem statisticItem = new StatisticItem("c13714");
            statisticItem.param("fid", m);
            statisticItem.param("fname", n);
            statisticItem.param("obj_param1", userId);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("tid", L);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, C);
            if (postData.s().getAlaInfo() != null) {
                AlaInfoData alaInfo = postData.s().getAlaInfo();
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, YYLiveUtil.calculateLiveType(alaInfo));
                if (alaInfo.mYyExtData != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, TiebaStatic.YYValues.YY_LIVE);
                    TiebaStaticHelper.addYYParam(statisticItem, alaInfo.mYyExtData);
                }
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void q0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048618, this, pbTopCommenFloorItemViewHolder, i2) == null) {
            pbTopCommenFloorItemViewHolder.b.setOnTouchListener(this.w);
            pbTopCommenFloorItemViewHolder.b.setOnLongClickListener(this.o);
            if (this.a.P() == null || this.a.P().getPageContext() == null || this.a.P().getPageContext().getOrignalPage() == null) {
                return;
            }
            q08 q08Var = this.a.P().d;
            pbTopCommenFloorItemViewHolder.g.setOnClickListener(q08Var.b);
            pbTopCommenFloorItemViewHolder.p.setOnClickListener(q08Var.b);
            pbTopCommenFloorItemViewHolder.l0.setOnClickListener(q08Var.d);
            pbTopCommenFloorItemViewHolder.k0.setOnClickListener(q08Var.d);
            pbTopCommenFloorItemViewHolder.I.setOnClickListener(q08Var.b);
            pbTopCommenFloorItemViewHolder.I.getHeadView().setOnClickListener(q08Var.b);
            pbTopCommenFloorItemViewHolder.q.setOnLongClickListener(this.o);
            pbTopCommenFloorItemViewHolder.q.setOnTouchListener(this.w);
            pbTopCommenFloorItemViewHolder.q.setCommonTextViewOnClickListener(this.l);
            pbTopCommenFloorItemViewHolder.q.setOnImageClickListener(this.m);
            pbTopCommenFloorItemViewHolder.q.setOnImageTouchListener(this.w);
            pbTopCommenFloorItemViewHolder.q.setOnEmotionClickListener(q08Var.f);
            pbTopCommenFloorItemViewHolder.q.setOnVoiceAfterClickListener(this.l);
            pbTopCommenFloorItemViewHolder.M.setOnClickListener(this.l);
            pbTopCommenFloorItemViewHolder.N.setOnClickListener(this.l);
            pbTopCommenFloorItemViewHolder.P.setOnClickListener(this.l);
            pbTopCommenFloorItemViewHolder.o.setOnClickListener(this.l);
            pbTopCommenFloorItemViewHolder.d0.setOnClickListener(this.l);
            s08 s08Var = this.a.P().e;
            pbTopCommenFloorItemViewHolder.A.setOnClickListener(this.l);
            pbTopCommenFloorItemViewHolder.B.setOnClickListener(new l(this, pbTopCommenFloorItemViewHolder, s08Var));
            pbTopCommenFloorItemViewHolder.c0.x = new a(this, pbTopCommenFloorItemViewHolder);
            pbTopCommenFloorItemViewHolder.c0.setAfterClickListener(new b(this, i2, pbTopCommenFloorItemViewHolder));
        }
    }

    public void r(jv7 jv7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, jv7Var) == null) {
            this.k = jv7Var;
        }
    }

    public void r0(lw7 lw7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, lw7Var) == null) {
            this.n = lw7Var;
        }
    }

    public void s0(TbRichTextView.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, sVar) == null) {
            this.g = sVar;
        }
    }

    public final void t0(TextView textView, TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048622, this, textView, tbImageView) == null) {
            textView.getViewTreeObserver().addOnGlobalLayoutListener(new k(this, textView, tbImageView));
        }
    }

    public final void u0(TbImageView tbImageView, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048623, this, tbImageView, z) == null) || tbImageView == null) {
            return;
        }
        if (z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbImageView.getLayoutParams();
            layoutParams.setMargins(ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds_16), ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds7), 0, 0);
            tbImageView.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) tbImageView.getLayoutParams();
        layoutParams2.setMargins(ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds10), ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds7), 0, 0);
        tbImageView.setLayoutParams(layoutParams2);
    }

    public final void v0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048624, this, pbTopCommenFloorItemViewHolder) == null) || pbTopCommenFloorItemViewHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (pbTopCommenFloorItemViewHolder.a != skinType) {
            x0(pbTopCommenFloorItemViewHolder.i);
            if (UbsABTestHelper.isPBPlanA()) {
                if (DeviceInfoUtil.isMate30()) {
                    lz7.m(pbTopCommenFloorItemViewHolder.g);
                } else {
                    hv4.d(pbTopCommenFloorItemViewHolder.g).A(R.string.F_X02);
                }
                SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.g, R.color.CAM_X0108, 1);
            } else {
                SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.g, R.color.CAM_X0109, 1);
            }
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.k, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.l, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.m, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.G, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.n, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.s0, R.color.CAM_X0105, 1);
            pbTopCommenFloorItemViewHolder.q.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            if (pbTopCommenFloorItemViewHolder.s.getVisibility() == 0) {
                pbTopCommenFloorItemViewHolder.s.g(skinType);
            }
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.f0, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.g0, R.color.CAM_X0107, 1);
            SkinManager.getColor(R.color.CAM_X0107);
            SkinManager.getColor(R.color.CAM_X0304);
            pbTopCommenFloorItemViewHolder.t.b();
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.S, R.color.CAM_X0304, 1);
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.Q, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundResource(pbTopCommenFloorItemViewHolder.P, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(pbTopCommenFloorItemViewHolder.R, R.color.CAM_X0109);
            SkinManager.setImageResource(pbTopCommenFloorItemViewHolder.T, R.drawable.icon_arrow_more_gray);
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.W, (int) R.color.CAM_X0107);
            if (pbTopCommenFloorItemViewHolder.U.getVisibility() == 8) {
                pbTopCommenFloorItemViewHolder.W.setText(R.string.obfuscated_res_0x7f0f03fb);
            } else {
                jv7 jv7Var = this.k;
                if (jv7Var != null && StringUtils.isNull(jv7Var.k())) {
                    pbTopCommenFloorItemViewHolder.W.setText(this.k.k());
                } else {
                    pbTopCommenFloorItemViewHolder.W.setText(R.string.obfuscated_res_0x7f0f05e6);
                }
            }
            pbTopCommenFloorItemViewHolder.c(skinType);
            WebPManager.setPureDrawable(pbTopCommenFloorItemViewHolder.d0, R.drawable.obfuscated_res_0x7f080984, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbTopCommenFloorItemViewHolder.b();
        }
        pbTopCommenFloorItemViewHolder.a = skinType;
    }

    public void w0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048625, this, pbTopCommenFloorItemViewHolder, postData) == null) {
            String str = "#7F66FE";
            if (postData.j0() != null) {
                VirtualImageCustomFigure j0 = postData.j0();
                pbTopCommenFloorItemViewHolder.l0.setHeadImageViewResource(j0.getFigureUrl());
                pbTopCommenFloorItemViewHolder.l0.setTid(postData.L());
                pbTopCommenFloorItemViewHolder.l0.setLocate(pz7.c);
                if (VirtualImageCustomFigure.BACK_GROUND_TYPE_TONE.equals(j0.getBackGroundType())) {
                    str = j0.getBackgroundValue();
                    pbTopCommenFloorItemViewHolder.l0.setHeadImageBackgroundColorResource(j0.getBackgroundValue());
                } else if (VirtualImageCustomFigure.BACK_GROUND_TYPE_URL.equals(j0.getBackGroundType())) {
                    pbTopCommenFloorItemViewHolder.l0.setHeadImageBackgroundResource(j0.getBackgroundValue());
                }
                pbTopCommenFloorItemViewHolder.l0.d(postData.s());
                pbTopCommenFloorItemViewHolder.j0.setVisibility(8);
                pbTopCommenFloorItemViewHolder.m0.setVisibility(0);
                pbTopCommenFloorItemViewHolder.l0.setTag(R.id.obfuscated_res_0x7f092091, postData.s().getUserId());
                pbTopCommenFloorItemViewHolder.l0.setTag(R.id.obfuscated_res_0x7f092099, postData.s().getUserName());
            } else {
                pbTopCommenFloorItemViewHolder.m0.setVisibility(8);
                pbTopCommenFloorItemViewHolder.l0.setTag(R.id.obfuscated_res_0x7f092091, null);
                pbTopCommenFloorItemViewHolder.l0.setTag(R.id.obfuscated_res_0x7f092099, null);
                pbTopCommenFloorItemViewHolder.j0.setVisibility(0);
            }
            if (postData.k0() != null && !TextUtils.isEmpty(postData.k0().b())) {
                pbTopCommenFloorItemViewHolder.k0.setData(postData.k0().b(), null, str);
                pbTopCommenFloorItemViewHolder.k0.setVisibility(0);
                if (pbTopCommenFloorItemViewHolder.n0.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) pbTopCommenFloorItemViewHolder.n0.getLayoutParams();
                    marginLayoutParams.setMargins(-UtilHelper.getDimenPixelSize(R.dimen.tbds20), marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                    pbTopCommenFloorItemViewHolder.n0.setLayoutParams(marginLayoutParams);
                }
                pbTopCommenFloorItemViewHolder.k0.setTag(R.id.obfuscated_res_0x7f092091, postData.s().getUserId());
                pbTopCommenFloorItemViewHolder.k0.setTag(R.id.obfuscated_res_0x7f092099, postData.s().getUserName());
                this.s = pz7.d;
                this.t = pbTopCommenFloorItemViewHolder.k0.getData();
                pbTopCommenFloorItemViewHolder.l0.setWithBubble(this.s);
                pbTopCommenFloorItemViewHolder.l0.setBubbleName(this.t);
            } else {
                if (pbTopCommenFloorItemViewHolder.n0.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) pbTopCommenFloorItemViewHolder.n0.getLayoutParams();
                    marginLayoutParams2.setMargins(0, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                    pbTopCommenFloorItemViewHolder.n0.setLayoutParams(marginLayoutParams2);
                }
                pbTopCommenFloorItemViewHolder.k0.setVisibility(8);
                pbTopCommenFloorItemViewHolder.k0.setTag(R.id.obfuscated_res_0x7f092099, null);
                pbTopCommenFloorItemViewHolder.k0.setTag(R.id.obfuscated_res_0x7f092091, null);
                int i2 = pz7.e;
                this.s = i2;
                pbTopCommenFloorItemViewHolder.l0.setWithBubble(i2);
            }
            if (pbTopCommenFloorItemViewHolder.l0.getVisibility() == 0) {
                pbTopCommenFloorItemViewHolder.l0.setBigWidthAndHeight(UtilHelper.getDimenPixelSize(R.dimen.tbds94), UtilHelper.getDimenPixelSize(R.dimen.tbds120));
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            if (pbTopCommenFloorItemViewHolder.m0.getVisibility() == 0) {
                layoutParams.setMargins(0, ej.f(this.mContext, R.dimen.M_H_X005), 0, ej.f(this.mContext, R.dimen.tbds5));
            } else {
                layoutParams.setMargins(0, ej.f(this.mContext, R.dimen.M_H_X005), 0, ej.f(this.mContext, R.dimen.tbds_10));
            }
            pbTopCommenFloorItemViewHolder.o0.setLayoutParams(layoutParams);
            if (postData.j0() != null) {
                pz7.a(2, postData.L(), pz7.c, this.s, this.t);
            }
        }
    }

    public final void x0(TextView textView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048626, this, textView) == null) || textView == null) {
            return;
        }
        Object tag = textView.getTag();
        if (tag instanceof PostData) {
            y0(textView, (PostData) tag);
        }
    }

    public final void y0(TextView textView, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048627, this, textView, postData) == null) {
            if (textView == null && postData == null) {
                return;
            }
            textView.setTag(postData);
            jv7 jv7Var = this.k;
            if (jv7Var != null && jv7Var.i0()) {
                postData.W0(Boolean.FALSE);
                postData.K0(0);
                textView.setTag(null);
            } else if (postData.s() != null) {
                com.baidu.tbadk.core.data.MetaData s = postData.s();
                String str = this.j;
                if (str != null && !str.equals("0") && this.j.equals(s.getUserId())) {
                    postData.W0(Boolean.TRUE);
                    postData.K0(ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds82));
                    textView.setAlpha(1.0f);
                    textView.setText(R.string.obfuscated_res_0x7f0f087d);
                    textView.setBackgroundColor(0);
                    hv4 d2 = hv4.d(textView);
                    d2.n(R.string.J_X04);
                    d2.l(R.dimen.L_X01);
                    d2.v(R.color.CAM_X0302);
                    d2.k(R.color.CAM_X0302);
                } else if (s.getIs_bawu() == 1 && postData.p0()) {
                    hv4 d3 = hv4.d(textView);
                    d3.v(R.color.CAM_X0101);
                    d3.n(R.string.J_X04);
                    d3.f(R.color.CAM_X0302);
                    postData.W0(Boolean.TRUE);
                    postData.K0(ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds108));
                    textView.setText(R.string.obfuscated_res_0x7f0f0346);
                } else if (s.getIs_bawu() == 1 && "manager".equals(s.getBawu_type())) {
                    hv4 d4 = hv4.d(textView);
                    d4.v(R.color.CAM_X0101);
                    d4.n(R.string.J_X04);
                    d4.f(R.color.CAM_X0302);
                    postData.W0(Boolean.TRUE);
                    postData.K0(ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds82));
                    textView.setText(R.string.obfuscated_res_0x7f0f02ff);
                } else if (s.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(s.getBawu_type())) {
                    hv4 d5 = hv4.d(textView);
                    d5.v(R.color.CAM_X0101);
                    d5.n(R.string.J_X04);
                    d5.f(R.color.CAM_X0302);
                    postData.W0(Boolean.TRUE);
                    postData.K0(ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds108));
                    textView.setText(R.string.obfuscated_res_0x7f0f0300);
                } else if (s.getIs_bawu() == 1 && "pri_content_assist".equals(s.getBawu_type())) {
                    hv4 d6 = hv4.d(textView);
                    d6.v(R.color.CAM_X0101);
                    d6.n(R.string.J_X04);
                    d6.f(R.color.CAM_X0302);
                    postData.W0(Boolean.TRUE);
                    postData.K0(ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds134));
                    textView.setText(R.string.obfuscated_res_0x7f0f02fc);
                } else if (s.getIs_bawu() == 1 && "pri_manage_assist".equals(s.getBawu_type())) {
                    hv4 d7 = hv4.d(textView);
                    d7.v(R.color.CAM_X0101);
                    d7.n(R.string.J_X04);
                    d7.f(R.color.CAM_X0302);
                    postData.W0(Boolean.TRUE);
                    postData.K0(ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds134));
                    textView.setText(R.string.obfuscated_res_0x7f0f02fd);
                } else {
                    postData.W0(Boolean.FALSE);
                    postData.K0(0);
                }
            } else {
                postData.W0(Boolean.FALSE);
                postData.K0(0);
            }
        }
    }
}

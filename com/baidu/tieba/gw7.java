package com.baidu.tieba;

import android.graphics.drawable.Drawable;
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
import android.widget.FrameLayout;
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
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.BitmapHelper;
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
import com.baidu.tbadk.data.VirtualImageCustomFigure;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.ou7;
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.uz5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class gw7 extends iw7<PostData, PbCommenFloorItemViewHolder> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ou7 A;
    public TbRichTextView.s g;
    public boolean h;
    public float i;
    public String j;
    public mt7 k;
    public View.OnClickListener l;
    public View.OnClickListener m;
    public TbRichTextView.y n;
    public ou7 o;
    public View.OnLongClickListener p;
    public yz7 q;
    public boolean r;
    public boolean s;
    public int t;
    public boolean u;
    public boolean v;
    public int w;
    public String x;
    public gg<ConstrainImageLayout> y;
    public gg<TbImageView> z;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ az7 b;
        public final /* synthetic */ gw7 c;

        /* renamed from: com.baidu.tieba.gw7$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0268a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PostData a;
            public final /* synthetic */ a b;

            public RunnableC0268a(a aVar, PostData postData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, postData};
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
                this.a = postData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    a aVar = this.b;
                    aVar.b.b.a(aVar.c.k, null, this.a, aVar.a.p.getLayoutStrategy());
                }
            }
        }

        public a(gw7 gw7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, az7 az7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw7Var, pbCommenFloorItemViewHolder, az7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = gw7Var;
            this.a = pbCommenFloorItemViewHolder;
            this.b = az7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PostData postData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (view2.getTag() instanceof SparseArray)) {
                SparseArray sparseArray = (SparseArray) view2.getTag();
                if (!(sparseArray.get(R.id.obfuscated_res_0x7f092007) instanceof PostData) || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f092007)) == null || this.a.b == null || this.b == null) {
                    return;
                }
                sg.a().postDelayed(new RunnableC0268a(this, postData), 100L);
                String Q = this.c.k.Q();
                if ((StringUtils.isNull(Q) || "0".equals(this.c.k.Q())) && this.c.k.O() != null) {
                    Q = this.c.k.O().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", Q).param("fid", this.c.k.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData.K()).param("obj_source", this.c.k0(view2)).param("obj_type", 4));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ gw7 b;

        public b(gw7 gw7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw7Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gw7Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || view2 == null || this.b.k == null || (pbCommenFloorItemViewHolder = this.a) == null || (agreeView = pbCommenFloorItemViewHolder.n) == null || agreeView.getData() == null) {
                return;
            }
            int i = view2 == this.a.n.getImgAgree() ? 1 : 2;
            String Q = this.b.k.Q();
            if ((StringUtils.isNull(Q) || "0".equals(this.b.k.Q())) && this.b.k.O() != null) {
                Q = this.b.k.O().getNid();
            }
            TiebaStatic.log(new StatisticItem("c13700").param("tid", Q).param("fid", this.b.k.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.n.getData().postId).param("obj_source", this.b.k0(this.a.n)).param("obj_type", i));
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ gw7 b;

        public c(gw7 gw7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw7Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gw7Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || view2 == null || this.b.k == null || (pbCommenFloorItemViewHolder = this.a) == null || (agreeView = pbCommenFloorItemViewHolder.d0) == null || agreeView.getData() == null) {
                return;
            }
            int i = view2 == this.a.d0.getImgAgree() ? 1 : 2;
            String Q = this.b.k.Q();
            if ((StringUtils.isNull(Q) || "0".equals(this.b.k.Q())) && this.b.k.O() != null) {
                Q = this.b.k.O().getNid();
            }
            TiebaStatic.log(new StatisticItem("c13700").param("tid", Q).param("fid", this.b.k.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.d0.getData().postId).param("obj_source", this.b.k0(this.a.d0)).param("obj_type", i));
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ PbCommenFloorItemViewHolder b;
        public final /* synthetic */ gw7 c;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            /* renamed from: com.baidu.tieba.gw7$d$a$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class View$OnClickListenerC0269a implements View.OnClickListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public View$OnClickListenerC0269a(a aVar) {
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
                        p08.p("c14886");
                        d dVar = this.a.a;
                        gw7 gw7Var = dVar.c;
                        gw7Var.m0(((PostData) gw7Var.getItem(dVar.a)).s());
                    }
                }
            }

            /* loaded from: classes4.dex */
            public class b implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public b(a aVar) {
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
                        d dVar = this.a.a;
                        ((PostData) dVar.c.getItem(dVar.a)).x0();
                        d dVar2 = this.a.a;
                        if (((PostData) dVar2.c.getItem(dVar2.a)).U() <= 0) {
                            d dVar3 = this.a.a;
                            ((PostData) dVar3.c.getItem(dVar3.a)).N0(Boolean.FALSE);
                            this.a.a.b.y0.setVisibility(8);
                            this.a.a.b.d0.setVisibility(0);
                            this.a.a.b.e0.setVisibility(0);
                        }
                    }
                }
            }

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.b.d0.getAgreeFlag()) {
                    d dVar = this.a;
                    ((PostData) dVar.c.getItem(dVar.a)).w0();
                    d dVar2 = this.a;
                    ((PostData) dVar2.c.getItem(dVar2.a)).N0(Boolean.TRUE);
                    this.a.b.d0.setVisibility(8);
                    this.a.b.e0.setVisibility(8);
                    this.a.b.y0.setVisibility(0);
                    this.a.b.y0.setOnClickListener(new View$OnClickListenerC0269a(this));
                    this.a.b.y0.postDelayed(new b(this), 5000L);
                }
            }
        }

        public d(gw7 gw7Var, int i, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw7Var, Integer.valueOf(i), pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = gw7Var;
            this.a = i;
            this.b = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && UtilHelper.isCurrentAccount(this.c.k.O().getAuthor().getUserId()) && this.c.k.O().isQuestionThread() && !UtilHelper.isCurrentAccount(((PostData) this.c.getItem(this.a)).s().getUserId())) {
                if (this.b.d0.getAgreeFlag()) {
                    ((PostData) this.c.getItem(this.a)).O0(1);
                    this.b.x0.setVisibility(0);
                    ((PostData) this.c.getItem(this.a)).H0(true);
                    this.b.h.setVisibility(8);
                    this.b.d0.postDelayed(new a(this), 900L);
                    return;
                }
                ((PostData) this.c.getItem(this.a)).O0(0);
                this.b.y0.setVisibility(8);
                this.b.x0.setVisibility(8);
                this.b.d0.setVisibility(0);
                this.b.e0.setVisibility(0);
                ((PostData) this.c.getItem(this.a)).H0(false);
                if (((PostData) this.c.getItem(this.a)).W().booleanValue()) {
                    this.b.h.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements hg<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gw7 a;

        public e(gw7 gw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gw7Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.hg
        public /* bridge */ /* synthetic */ ConstrainImageLayout a(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            e(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.hg
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
        @Override // com.baidu.tieba.hg
        /* renamed from: f */
        public void b(ConstrainImageLayout constrainImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, constrainImageLayout) == null) {
                constrainImageLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hg
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
    public class f implements hg<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gw7 a;

        public f(gw7 gw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gw7Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.hg
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.hg
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
        @Override // com.baidu.tieba.hg
        /* renamed from: f */
        public void b(TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, tbImageView) == null) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hg
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
    public class g implements ou7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gw7 a;

        public g(gw7 gw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gw7Var;
        }

        @Override // com.baidu.tieba.ou7.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.ou7.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (this.a.o != null) {
                    if (!(view2 instanceof TbListTextView) || this.a.m == null) {
                        this.a.o.a(view2);
                        this.a.o.onSingleTapConfirmed(motionEvent);
                        return true;
                    }
                    this.a.m.onClick(view2);
                    PbFragment pbFragment = this.a.b;
                    if (pbFragment != null) {
                        pbFragment.e7(false);
                        return true;
                    }
                    return true;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.ou7.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            PbFragment pbFragment;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                if (view2 == null || (!((pbFragment = this.a.b) == null || pbFragment.S5() == null || this.a.b.S5().H1()) || view2.getId() == R.id.obfuscated_res_0x7f0909f2)) {
                    return true;
                }
                if (view2 instanceof FrameLayout) {
                    this.a.S(view2);
                } else {
                    ViewParent parent = view2.getParent();
                    int i = 0;
                    while (true) {
                        if (parent == null || i >= 10) {
                            break;
                        } else if (parent instanceof FrameLayout) {
                            this.a.S((FrameLayout) parent);
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
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ PostData b;
        public final /* synthetic */ gw7 c;

        public h(gw7 gw7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw7Var, pbCommenFloorItemViewHolder, postData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = gw7Var;
            this.a = pbCommenFloorItemViewHolder;
            this.b = postData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                boolean z = this.a.T.getVisibility() == 8;
                this.c.P(this.a, !z, this.b.E());
                this.b.K0(!z);
                this.c.p0(this.a, this.b);
                PbFragment pbFragment = this.c.b;
                if (pbFragment == null || pbFragment.S5() == null || this.c.b.S5().l1() == null || this.c.b.S5().R0() == null || z || this.a.getView().getTop() >= this.c.b.S5().l1().getMeasuredHeight()) {
                    return;
                }
                this.c.b.S5().R0().setSelectionFromTop(ListUtils.getPosition(this.c.b.S5().R0().getData(), this.b) + this.c.b.S5().R0().getHeaderViewsCount(), this.c.b.S5().l1().getMeasuredHeight());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gw7 a;

        public i(gw7 gw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gw7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.mContext == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.a.mContext, null, TbConfig.USER_GROWTH_TASK_CENTER_MAIN_URL, true)));
        }
    }

    /* loaded from: classes4.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;

        public j(gw7 gw7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw7Var, pbCommenFloorItemViewHolder};
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.y0.setVisibility(8);
                this.a.d0.setVisibility(0);
                this.a.e0.setVisibility(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ PostData b;
        public final /* synthetic */ String[] c;
        public final /* synthetic */ int d;
        public final /* synthetic */ gw7 e;

        public k(gw7 gw7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, String[] strArr, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw7Var, pbCommenFloorItemViewHolder, postData, strArr, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = gw7Var;
            this.a = pbCommenFloorItemViewHolder;
            this.b = postData;
            this.c = strArr;
            this.d = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int measuredWidth = this.a.e.getMeasuredWidth();
                this.e.i0();
                boolean z = true;
                boolean z2 = !this.e.R(this.b);
                int width = !StringUtils.isNull(this.c[0]) ? this.a.g.getWidth() : 0;
                int g = sx7.g(measuredWidth, this.a.J.getVisibility() == 8 ? 0 : this.a.J.getWidth() + sx7.c + sx7.b, width, this.a.i.getVisibility() == 8 ? 0 : this.a.i.getWidth() + sx7.b, this.a.H.getVisibility() == 8 ? 0 : this.a.H.getWidth() + sx7.b, z2);
                if (g < 0 && !StringUtils.isNull(this.c[0])) {
                    this.a.f.setWidth(width + g);
                } else {
                    this.a.f.setWidth(width);
                    z = false;
                }
                if (this.a.g.getText() == null) {
                    if (z) {
                        this.a.f.setText(this.c[0]);
                        gw7 gw7Var = this.e;
                        PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = this.a;
                        gw7Var.x0(pbCommenFloorItemViewHolder.f, pbCommenFloorItemViewHolder.i);
                    } else {
                        this.a.f.setText(this.c[0]);
                        this.e.y0(this.a.i, false);
                    }
                } else if (z) {
                    PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder2 = this.a;
                    pbCommenFloorItemViewHolder2.f.setText(pbCommenFloorItemViewHolder2.g.getText());
                    gw7 gw7Var2 = this.e;
                    PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder3 = this.a;
                    gw7Var2.x0(pbCommenFloorItemViewHolder3.f, pbCommenFloorItemViewHolder3.i);
                } else {
                    PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder4 = this.a;
                    pbCommenFloorItemViewHolder4.f.setText(pbCommenFloorItemViewHolder4.g.getText());
                    this.e.y0(this.a.i, false);
                }
                this.e.N(this.b, this.a, g, this.d);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ TextView b;
        public final /* synthetic */ TbImageView c;
        public final /* synthetic */ gw7 d;

        public l(gw7 gw7Var, TextView textView, TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw7Var, textView, tbImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = gw7Var;
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
                    this.d.y0(this.c, false);
                } else {
                    this.d.y0(this.c, true);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;

        public m(gw7 gw7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw7Var, pbCommenFloorItemViewHolder};
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
                this.a.v.performClick();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gw7(a18 a18Var, BdUniqueId bdUniqueId) {
        super(a18Var, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {a18Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((a18) objArr2[0], (BdUniqueId) objArr2[1]);
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
        this.p = null;
        this.q = null;
        this.s = true;
        this.u = true;
        this.v = false;
        this.w = 0;
        this.x = null;
        this.y = new gg<>(new e(this), 6, 0);
        this.z = new gg<>(new f(this), 12, 0);
        this.A = new ou7(new g(this));
        if (a18Var != null && a18Var.K() != null) {
            this.t = a18Var.K().R1();
        }
        s(R.dimen.tbds14);
    }

    public void A0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, pbCommenFloorItemViewHolder, postData) == null) {
            String str = "#7F66FE";
            if (postData.i0() != null) {
                VirtualImageCustomFigure i0 = postData.i0();
                pbCommenFloorItemViewHolder.t0.setHeadImageViewResource(i0.getFigureUrl());
                pbCommenFloorItemViewHolder.t0.setTid(postData.K());
                pbCommenFloorItemViewHolder.t0.setLocate(wx7.c);
                if (VirtualImageCustomFigure.BACK_GROUND_TYPE_TONE.equals(i0.getBackGroundType())) {
                    str = i0.getBackgroundValue();
                    pbCommenFloorItemViewHolder.t0.setHeadImageBackgroundColorResource(i0.getBackgroundValue());
                } else if (VirtualImageCustomFigure.BACK_GROUND_TYPE_URL.equals(i0.getBackGroundType())) {
                    pbCommenFloorItemViewHolder.t0.setHeadImageBackgroundResource(i0.getBackgroundValue());
                }
                pbCommenFloorItemViewHolder.t0.d(postData.s());
                pbCommenFloorItemViewHolder.r0.setVisibility(8);
                pbCommenFloorItemViewHolder.u0.setVisibility(0);
                pbCommenFloorItemViewHolder.t0.setTag(R.id.obfuscated_res_0x7f09203f, postData.s().getUserId());
                pbCommenFloorItemViewHolder.t0.setTag(R.id.obfuscated_res_0x7f092047, postData.s().getUserName());
            } else {
                pbCommenFloorItemViewHolder.u0.setVisibility(8);
                pbCommenFloorItemViewHolder.t0.setTag(R.id.obfuscated_res_0x7f09203f, null);
                pbCommenFloorItemViewHolder.t0.setTag(R.id.obfuscated_res_0x7f092047, null);
                pbCommenFloorItemViewHolder.r0.setVisibility(0);
            }
            if (postData.j0() != null && !TextUtils.isEmpty(postData.j0().b())) {
                pbCommenFloorItemViewHolder.s0.setData(postData.j0().b(), null, str);
                pbCommenFloorItemViewHolder.s0.setVisibility(0);
                if (pbCommenFloorItemViewHolder.v0.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) pbCommenFloorItemViewHolder.v0.getLayoutParams();
                    marginLayoutParams.setMargins(-UtilHelper.getDimenPixelSize(R.dimen.tbds20), marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                    pbCommenFloorItemViewHolder.v0.setLayoutParams(marginLayoutParams);
                }
                pbCommenFloorItemViewHolder.s0.setTag(R.id.obfuscated_res_0x7f09203f, postData.s().getUserId());
                pbCommenFloorItemViewHolder.s0.setTag(R.id.obfuscated_res_0x7f092047, postData.s().getUserName());
                this.w = wx7.d;
                this.x = pbCommenFloorItemViewHolder.s0.getData();
                pbCommenFloorItemViewHolder.t0.setWithBubble(this.w);
                pbCommenFloorItemViewHolder.t0.setBubbleName(this.x);
            } else {
                if (pbCommenFloorItemViewHolder.v0.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) pbCommenFloorItemViewHolder.v0.getLayoutParams();
                    marginLayoutParams2.setMargins(0, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                    pbCommenFloorItemViewHolder.v0.setLayoutParams(marginLayoutParams2);
                }
                pbCommenFloorItemViewHolder.s0.setVisibility(8);
                pbCommenFloorItemViewHolder.s0.setTag(R.id.obfuscated_res_0x7f092047, null);
                pbCommenFloorItemViewHolder.s0.setTag(R.id.obfuscated_res_0x7f09203f, null);
                int i2 = wx7.e;
                this.w = i2;
                pbCommenFloorItemViewHolder.t0.setWithBubble(i2);
            }
            if (pbCommenFloorItemViewHolder.t0.getVisibility() == 0) {
                pbCommenFloorItemViewHolder.t0.setBigWidthAndHeight(UtilHelper.getDimenPixelSize(R.dimen.tbds94), UtilHelper.getDimenPixelSize(R.dimen.tbds120));
            }
            if (postData.i0() != null) {
                wx7.a(2, postData.K(), wx7.c, this.w, this.x);
            }
        }
    }

    public final void B0(TextView textView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textView) == null) || textView == null) {
            return;
        }
        Object tag = textView.getTag();
        if (tag instanceof PostData) {
            C0(textView, (PostData) tag);
        }
    }

    public final void C0(TextView textView, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, textView, postData) == null) {
            if (textView == null && postData == null) {
                return;
            }
            textView.setTag(postData);
            mt7 mt7Var = this.k;
            if (mt7Var != null && mt7Var.i0()) {
                postData.V0(Boolean.FALSE);
                postData.J0(0);
                textView.setTag(null);
            } else if (postData.s() != null) {
                MetaData s = postData.s();
                String str = this.j;
                if (str != null && !str.equals("0") && this.j.equals(s.getUserId())) {
                    postData.V0(Boolean.TRUE);
                    postData.J0(ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds82));
                    textView.setAlpha(1.0f);
                    textView.setText(R.string.obfuscated_res_0x7f0f086a);
                    textView.setBackgroundColor(0);
                    os4 d2 = os4.d(textView);
                    d2.n(R.string.J_X04);
                    d2.l(R.dimen.L_X01);
                    d2.v(R.color.CAM_X0302);
                    d2.k(R.color.CAM_X0302);
                } else if (s.getIs_bawu() == 1 && postData.o0()) {
                    os4 d3 = os4.d(textView);
                    d3.v(R.color.CAM_X0101);
                    d3.n(R.string.J_X04);
                    d3.f(R.color.CAM_X0302);
                    postData.V0(Boolean.TRUE);
                    postData.J0(ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds108));
                    textView.setText(R.string.obfuscated_res_0x7f0f0342);
                } else if (s.getIs_bawu() == 1 && "manager".equals(s.getBawu_type())) {
                    os4 d4 = os4.d(textView);
                    d4.v(R.color.CAM_X0101);
                    d4.n(R.string.J_X04);
                    d4.f(R.color.CAM_X0302);
                    postData.V0(Boolean.TRUE);
                    postData.J0(ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds82));
                    textView.setText(R.string.obfuscated_res_0x7f0f02fb);
                } else if (s.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(s.getBawu_type())) {
                    os4 d5 = os4.d(textView);
                    d5.v(R.color.CAM_X0101);
                    d5.n(R.string.J_X04);
                    d5.f(R.color.CAM_X0302);
                    postData.V0(Boolean.TRUE);
                    postData.J0(ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds108));
                    textView.setText(R.string.obfuscated_res_0x7f0f02fc);
                } else if (s.getIs_bawu() == 1 && "pri_content_assist".equals(s.getBawu_type())) {
                    os4 d6 = os4.d(textView);
                    d6.v(R.color.CAM_X0101);
                    d6.n(R.string.J_X04);
                    d6.f(R.color.CAM_X0302);
                    postData.V0(Boolean.TRUE);
                    postData.J0(ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds134));
                    textView.setText(R.string.obfuscated_res_0x7f0f02f8);
                } else if (s.getIs_bawu() == 1 && "pri_manage_assist".equals(s.getBawu_type())) {
                    os4 d7 = os4.d(textView);
                    d7.v(R.color.CAM_X0101);
                    d7.n(R.string.J_X04);
                    d7.f(R.color.CAM_X0302);
                    postData.V0(Boolean.TRUE);
                    postData.J0(ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds134));
                    textView.setText(R.string.obfuscated_res_0x7f0f02f9);
                } else {
                    postData.V0(Boolean.FALSE);
                    postData.J0(0);
                }
            } else {
                postData.V0(Boolean.FALSE);
                postData.J0(0);
            }
        }
    }

    public final void K(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.p.setTextViewOnTouchListener(this.o);
            pbCommenFloorItemViewHolder.p.setTextViewCheckSelection(false);
        }
    }

    public final void L(PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, postData) == null) {
            if (postData != null) {
                StatisticItem statisticItem = new StatisticItem("c14623");
                statisticItem.param("post_id", postData.K());
                statisticItem.param("pid", postData.K());
                statisticItem.param("tid", postData.d0());
                statisticItem.param("fid", postData.G());
                statisticItem.param("fname", postData.H());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
            }
            mt7 mt7Var = this.k;
            if (mt7Var != null) {
                if (mt7Var.u0()) {
                    AbsVideoPbFragment absVideoPbFragment = this.c;
                    if (absVideoPbFragment != null) {
                        p08.e(absVideoPbFragment.getUniqueId(), this.k, postData, postData.b0, postData.a0 ? 2 : 8, "common_exp_source_pb_comment");
                        return;
                    }
                    return;
                }
                PbFragment pbFragment = this.b;
                if (pbFragment != null) {
                    p08.e(pbFragment.getUniqueId(), this.k, postData, postData.b0, postData.a0 ? 2 : 8, "common_exp_source_pb_comment");
                }
            }
        }
    }

    public final void M(PostData postData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, postData) == null) && postData.C == 0 && postData.K) {
            StatisticItem statisticItem = new StatisticItem("c12203");
            statisticItem.param("post_id", postData.K());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("cuid", TbadkCoreApplication.getInst().getCuid());
            statisticItem.param("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            statisticItem.param("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
            statisticItem.param(TiebaStatic.Params.CUID_GID, TbadkCoreApplication.getInst().getCuidGid());
            statisticItem.param(TiebaStatic.Params.EXPOSURE_TIME, System.currentTimeMillis());
            a18 a18Var = this.a;
            if (a18Var != null) {
                int R1 = a18Var.K().R1();
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
            q0(postData);
        }
    }

    public final void N(PostData postData, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048582, this, postData, pbCommenFloorItemViewHolder, i2, i3) == null) {
            if (i2 > postData.l0() + postData.L()) {
                if (pbCommenFloorItemViewHolder.K != null && postData.s() != null) {
                    pbCommenFloorItemViewHolder.K.setTag(R.id.obfuscated_res_0x7f09203f, postData.s().getUserId());
                    a18 a18Var = this.a;
                    if (a18Var != null && a18Var.P() != null) {
                        pbCommenFloorItemViewHolder.K.setOnClickListener(this.a.P().d.c);
                    }
                    ArrayList<IconData> iconInfo = postData.s().getIconInfo();
                    int f2 = ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                    pbCommenFloorItemViewHolder.K.g(iconInfo, i3, f2, f2, ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                }
                if (postData.W().booleanValue() && !postData.J()) {
                    pbCommenFloorItemViewHolder.h.setVisibility(0);
                } else {
                    pbCommenFloorItemViewHolder.h.setVisibility(8);
                }
            } else if (i2 > postData.L()) {
                if (postData.W().booleanValue() && !postData.J()) {
                    pbCommenFloorItemViewHolder.h.setVisibility(0);
                } else {
                    pbCommenFloorItemViewHolder.h.setVisibility(8);
                }
                pbCommenFloorItemViewHolder.K.setVisibility(8);
            } else {
                pbCommenFloorItemViewHolder.K.setVisibility(8);
                pbCommenFloorItemViewHolder.h.setVisibility(8);
            }
        }
    }

    public final void O(TbRichTextView tbRichTextView, View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048583, this, tbRichTextView, view2, z) == null) || tbRichTextView == null || view2 == null) {
            return;
        }
        int k2 = (((ri.k(TbadkCoreApplication.getInst()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
        if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
            k2 = (k2 - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
        }
        int s = z ? s(R.dimen.tbds115) : 0;
        tbRichTextView.getLayoutStrategy().q((int) ((k2 - s) * this.i));
        tbRichTextView.getLayoutStrategy().H = (k2 - s) - s(R.dimen.tbds122);
        tbRichTextView.getLayoutStrategy().p((int) (k2 * 1.618f * this.i));
    }

    public final void P(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{pbCommenFloorItemViewHolder, Boolean.valueOf(z), str}) == null) {
            if (z) {
                pbCommenFloorItemViewHolder.T.setVisibility(8);
                if (StringUtils.isNull(str)) {
                    pbCommenFloorItemViewHolder.V.setText(R.string.obfuscated_res_0x7f0f05d9);
                    return;
                } else {
                    pbCommenFloorItemViewHolder.V.setText(str);
                    return;
                }
            }
            pbCommenFloorItemViewHolder.T.setVisibility(0);
            pbCommenFloorItemViewHolder.V.setText(R.string.obfuscated_res_0x7f0f03f7);
        }
    }

    public final void Q(boolean z, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), pbCommenFloorItemViewHolder, postData}) == null) || pbCommenFloorItemViewHolder == null || (view2 = pbCommenFloorItemViewHolder.M) == null || pbCommenFloorItemViewHolder.U == null || !(view2.getLayoutParams() instanceof RelativeLayout.LayoutParams) || !(pbCommenFloorItemViewHolder.U.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            return;
        }
        boolean z2 = !ListUtils.isEmpty(postData.Y());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.M.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.U.getLayoutParams();
        if (z) {
            pbCommenFloorItemViewHolder.p.getLayoutStrategy().m(0);
            if (z2) {
                pbCommenFloorItemViewHolder.p.getLayoutStrategy().l(ri.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = ri.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                }
            } else {
                pbCommenFloorItemViewHolder.p.getLayoutStrategy().l(ri.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = 0;
                }
            }
            pbCommenFloorItemViewHolder.U.setLayoutParams(layoutParams2);
            if (layoutParams != null) {
                layoutParams.topMargin = ri.f(this.mContext, R.dimen.tbds20);
                pbCommenFloorItemViewHolder.M.setLayoutParams(layoutParams);
            }
        } else {
            pbCommenFloorItemViewHolder.p.getLayoutStrategy().l(ri.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X003));
            pbCommenFloorItemViewHolder.p.getLayoutStrategy().m(ri.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X002));
            if (layoutParams != null) {
                layoutParams.topMargin = ri.f(this.mContext, R.dimen.tbds14);
                pbCommenFloorItemViewHolder.M.setLayoutParams(layoutParams);
            }
        }
        if (pbCommenFloorItemViewHolder.s0.getVisibility() != 0 && pbCommenFloorItemViewHolder.z0.getVisibility() != 0) {
            pbCommenFloorItemViewHolder.p.getLayoutStrategy().j(ri.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X001));
        } else {
            pbCommenFloorItemViewHolder.p.getLayoutStrategy().j(ri.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X002));
        }
    }

    public final boolean R(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, postData)) == null) {
            if (this.k.O() == null || this.k.O().getAuthor() == null || this.k.O().getAuthor().getUserId() == null || postData == null || postData.s() == null || postData.s().getUserId() == null) {
                return false;
            }
            return this.k.O().getAuthor().getUserId().equals(postData.s().getUserId());
        }
        return invokeL.booleanValue;
    }

    public final void S(View view2) {
        PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, view2) == null) || view2 == null || !(view2.getTag() instanceof PbCommenFloorItemViewHolder) || (agreeView = (pbCommenFloorItemViewHolder = (PbCommenFloorItemViewHolder) view2.getTag()).d0) == null || agreeView.getData() == null) {
            return;
        }
        pbCommenFloorItemViewHolder.d0.setAgreeSource(2);
        pbCommenFloorItemViewHolder.d0.J();
    }

    public final void T(PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, postData) == null) || postData == null) {
            return;
        }
        StatisticItem i2 = p08.i(this.k, postData, postData.b0, postData.a0 ? 2 : 8, 6);
        postData.c0 = i2;
        if (ListUtils.isEmpty(postData.Y())) {
            return;
        }
        Iterator<PostData> it = postData.Y().iterator();
        while (it.hasNext()) {
            it.next().c0 = i2;
        }
    }

    public final void U(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, pbCommenFloorItemViewHolder, postData) == null) {
            if (!TextUtils.isEmpty(postData.t()) && this.h) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.p.getLayoutParams();
                layoutParams.topMargin = s(R.dimen.obfuscated_res_0x7f0701d5);
                layoutParams.bottomMargin = s(R.dimen.obfuscated_res_0x7f0701d5);
                pbCommenFloorItemViewHolder.p.setLayoutParams(layoutParams);
                pbCommenFloorItemViewHolder.p.k0(postData.t());
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.p.getLayoutParams();
                layoutParams2.bottomMargin = 0;
                layoutParams2.topMargin = 0;
                pbCommenFloorItemViewHolder.p.setLayoutParams(layoutParams2);
                pbCommenFloorItemViewHolder.p.setPadding(0, 0, 0, 0);
                pbCommenFloorItemViewHolder.p.k0(null);
            }
            pbCommenFloorItemViewHolder.p.setTextViewOnTouchListener(this.A);
            pbCommenFloorItemViewHolder.p.setTextViewCheckSelection(false);
        }
    }

    public final void V(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || postData == null || (imageView = pbCommenFloorItemViewHolder.L) == null || this.k == null) {
            return;
        }
        imageView.setVisibility(8);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void W(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        boolean z;
        boolean z2;
        mt7 mt7Var;
        mt7 mt7Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048591, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        String str = null;
        boolean z3 = true;
        if (postData.B() > 0 && (mt7Var2 = this.k) != null && !mt7Var2.i0()) {
            String format = String.format(this.mContext.getString(R.string.obfuscated_res_0x7f0f0981), Integer.valueOf(postData.B()));
            pbCommenFloorItemViewHolder.G.setVisibility(0);
            pbCommenFloorItemViewHolder.G.setText(format);
            z = true;
        } else {
            pbCommenFloorItemViewHolder.G.setVisibility(8);
            z = false;
        }
        if (postData.s() != null) {
            str = postData.s().getIpAddress();
            if (!TextUtils.isEmpty(str)) {
                z2 = true;
                p15 R = postData.R();
                z3 = (R != null || StringUtils.isNull(R.b()) || (mt7Var = this.k) == null || mt7Var.i0()) ? false : false;
                if (!z) {
                    pbCommenFloorItemViewHolder.k.setVisibility(0);
                } else {
                    pbCommenFloorItemViewHolder.k.setVisibility(8);
                }
                if (z3 && !z2) {
                    pbCommenFloorItemViewHolder.l.setVisibility(8);
                } else {
                    pbCommenFloorItemViewHolder.l.setVisibility(0);
                }
                if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.e0()), "yyyy"))) {
                    pbCommenFloorItemViewHolder.j.setText(StringHelper.getFormatTimeShort(postData.e0()));
                } else {
                    pbCommenFloorItemViewHolder.j.setText(StringHelper.getFormatTime(postData.e0()));
                }
                if (!z2) {
                    pbCommenFloorItemViewHolder.m.setVisibility(0);
                    TextView textView = pbCommenFloorItemViewHolder.m;
                    textView.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f14ea) + str);
                } else if (z3) {
                    pbCommenFloorItemViewHolder.m.setVisibility(0);
                    if (postData.Z) {
                        pbCommenFloorItemViewHolder.m.setText(StringHelper.cutStringWithSuffix(R.b(), 7, StringHelper.STRING_MORE));
                    } else {
                        pbCommenFloorItemViewHolder.m.setText(R.b());
                    }
                } else {
                    pbCommenFloorItemViewHolder.m.setVisibility(8);
                }
                TextView textView2 = pbCommenFloorItemViewHolder.g0;
                textView2.setText(((Object) pbCommenFloorItemViewHolder.j.getText()) + "  • ");
            }
        }
        z2 = false;
        p15 R2 = postData.R();
        if (R2 != null) {
        }
        if (!z) {
        }
        if (z3) {
        }
        pbCommenFloorItemViewHolder.l.setVisibility(0);
        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.e0()), "yyyy"))) {
        }
        if (!z2) {
        }
        TextView textView22 = pbCommenFloorItemViewHolder.g0;
        textView22.setText(((Object) pbCommenFloorItemViewHolder.j.getText()) + "  • ");
    }

    public final void X(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048592, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        pbCommenFloorItemViewHolder.Y.setVisibility(postData.Z ? 0 : 8);
    }

    public final void Y(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048593, this, pbCommenFloorItemViewHolder, postData, view2, i2) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        pbCommenFloorItemViewHolder.x.setVisibility(8);
        pbCommenFloorItemViewHolder.r.setVisibility(0);
        pbCommenFloorItemViewHolder.f0.setVisibility(8);
        pbCommenFloorItemViewHolder.v.setVisibility(8);
        pbCommenFloorItemViewHolder.w.setVisibility(8);
        pbCommenFloorItemViewHolder.n.setVisibility(8);
        pbCommenFloorItemViewHolder.n0.setVisibility(8);
        h0(pbCommenFloorItemViewHolder, postData, view2, i2);
        V(pbCommenFloorItemViewHolder, postData);
        Z(pbCommenFloorItemViewHolder, postData);
        c0(pbCommenFloorItemViewHolder, postData, view2);
        b0(pbCommenFloorItemViewHolder, postData, view2, i2);
        W(pbCommenFloorItemViewHolder, postData);
        e0(pbCommenFloorItemViewHolder, postData);
        a0(pbCommenFloorItemViewHolder, postData);
        A0(pbCommenFloorItemViewHolder, postData);
        f0(pbCommenFloorItemViewHolder, postData);
        U(pbCommenFloorItemViewHolder, postData);
        X(pbCommenFloorItemViewHolder, postData);
        d0(pbCommenFloorItemViewHolder, postData);
        g0(pbCommenFloorItemViewHolder, postData);
        av7.h(pbCommenFloorItemViewHolder, view2, postData, this.r, true);
    }

    public final void Z(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048594, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || postData == null || postData.q() == null) {
            return;
        }
        postData.q().threadId = this.a.K().m2();
        postData.q().objType = 1;
        postData.q().isInPost = true;
        ThreadData threadData = null;
        mt7 mt7Var = this.k;
        if (mt7Var != null && mt7Var.O() != null) {
            threadData = this.k.O();
        }
        if (threadData != null && threadData.isUgcThreadType()) {
            pbCommenFloorItemViewHolder.n.setAgreeAlone(true);
        }
        pbCommenFloorItemViewHolder.n.setThreadData(threadData);
        pbCommenFloorItemViewHolder.n.setData(postData.q());
        pbCommenFloorItemViewHolder.d0.setThreadData(threadData);
        pbCommenFloorItemViewHolder.d0.setData(postData.q());
    }

    public final void a0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        AlaLiveInfoCoreData alaLiveInfoCoreData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048595, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || pbCommenFloorItemViewHolder.R == null || pbCommenFloorItemViewHolder.O == null) {
            return;
        }
        if (postData != null && (alaLiveInfoCoreData = postData.R) != null && !StringUtils.isNull(alaLiveInfoCoreData.liveTitle)) {
            pbCommenFloorItemViewHolder.R.setText(postData.R.liveTitle);
            pbCommenFloorItemViewHolder.O.setTag(postData.R);
            pbCommenFloorItemViewHolder.O.setVisibility(0);
            StatisticItem statisticItem = new StatisticItem("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(statisticItem);
            return;
        }
        pbCommenFloorItemViewHolder.O.setVisibility(8);
    }

    public final void b0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048596, this, pbCommenFloorItemViewHolder, postData, view2, i2) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        if (postData.a0() > 0) {
            pbCommenFloorItemViewHolder.u.setVisibility(8);
        } else {
            SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.u.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                pbCommenFloorItemViewHolder.u.setTag(sparseArray);
            }
            sparseArray.put(R.id.obfuscated_res_0x7f092007, postData);
            if (postData.F() == 2) {
                pbCommenFloorItemViewHolder.u.setVisibility(8);
            } else {
                pbCommenFloorItemViewHolder.u.setVisibility(0);
            }
            pbCommenFloorItemViewHolder.t.setVisibility(8);
        }
        ImageView imageView = pbCommenFloorItemViewHolder.v;
        if (imageView != null) {
            SparseArray sparseArray2 = (SparseArray) imageView.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                pbCommenFloorItemViewHolder.v.setTag(sparseArray2);
            }
            sparseArray2.put(R.id.obfuscated_res_0x7f092007, postData);
        }
        ImageView imageView2 = pbCommenFloorItemViewHolder.w;
        if (imageView2 != null) {
            SparseArray sparseArray3 = (SparseArray) imageView2.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                pbCommenFloorItemViewHolder.w.setTag(sparseArray3);
            }
            sparseArray3.put(R.id.obfuscated_res_0x7f092007, postData);
        }
        pbCommenFloorItemViewHolder.t.setVisibility(8);
        if (!postData.n0() && !postData.m0(false)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.s.getLayoutParams();
            layoutParams.topMargin = 0;
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            layoutParams.bottomMargin = 0;
            pbCommenFloorItemViewHolder.s.setLayoutParams(layoutParams);
            pbCommenFloorItemViewHolder.s.setVisibility(8);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.s.getLayoutParams();
            layoutParams2.topMargin = ri.f(this.mContext, R.dimen.tbds0);
            layoutParams2.leftMargin = ri.f(this.mContext, R.dimen.tbds148);
            layoutParams2.rightMargin = ri.f(this.mContext, R.dimen.M_W_X007);
            layoutParams2.bottomMargin = ri.f(this.mContext, R.dimen.tbds20);
            pbCommenFloorItemViewHolder.s.setLayoutParams(layoutParams2);
            if (this.q == null) {
                yz7 yz7Var = new yz7(this.mContext);
                this.q = yz7Var;
                yz7Var.f(this.e);
                this.q.h(this.l);
                this.q.e(this.m);
                String str = null;
                mt7 mt7Var = this.k;
                if (mt7Var != null && mt7Var.O() != null && this.k.O().getAuthor() != null) {
                    str = this.k.O().getAuthor().getUserId();
                }
                boolean z = true;
                z = (str == null || !str.equals(TbadkCoreApplication.getCurrentAccount())) ? false : false;
                mt7 mt7Var2 = this.k;
                if (mt7Var2 != null) {
                    this.q.j(mt7Var2.W(), z);
                    this.q.i(this.k.O());
                }
            }
            this.q.g(postData.K());
            pbCommenFloorItemViewHolder.s.setSubPbAdapter(this.q);
            pbCommenFloorItemViewHolder.s.setVisibility(0);
            pbCommenFloorItemViewHolder.s.setData(postData, view2);
            pbCommenFloorItemViewHolder.s.setChildOnClickListener(this.m);
            pbCommenFloorItemViewHolder.s.setChildOnLongClickListener(this.p);
            pbCommenFloorItemViewHolder.s.setChildOnTouchListener(this.A);
        }
        if (postData.N) {
            pbCommenFloorItemViewHolder.M.setVisibility(0);
        } else {
            pbCommenFloorItemViewHolder.M.setVisibility(4);
        }
        pbCommenFloorItemViewHolder.u.setVisibility(8);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.r.getLayoutParams();
        layoutParams3.topMargin = ri.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X001);
        layoutParams3.bottomMargin = ri.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X002);
        if (pbCommenFloorItemViewHolder.t.getVisibility() == 8) {
            pbCommenFloorItemViewHolder.r.setVisibility(8);
        } else {
            pbCommenFloorItemViewHolder.r.setVisibility(0);
        }
        pbCommenFloorItemViewHolder.h0.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fe1));
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.h = z;
        }
    }

    public final void c0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048598, this, pbCommenFloorItemViewHolder, postData, view2) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.p.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        layoutParams.rightMargin = ri.f(this.mContext, R.dimen.M_W_X007);
        layoutParams.leftMargin = ri.f(this.mContext, R.dimen.tbds148);
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = 0;
        pbCommenFloorItemViewHolder.p.setPadding(0, 0, 0, 0);
        if (!this.h) {
            pbCommenFloorItemViewHolder.p.getLayoutStrategy().g(R.drawable.icon_click);
        } else {
            pbCommenFloorItemViewHolder.p.k0(null);
            pbCommenFloorItemViewHolder.p.setBackgroundDrawable(null);
            pbCommenFloorItemViewHolder.p.getLayoutStrategy().g(R.drawable.obfuscated_res_0x7f081211);
        }
        pbCommenFloorItemViewHolder.p.getLayoutStrategy().x(R.drawable.pic_video);
        O(pbCommenFloorItemViewHolder.p, view2, !StringUtils.isNull(postData.t()));
        pbCommenFloorItemViewHolder.p.setLayoutParams(layoutParams);
        pbCommenFloorItemViewHolder.p.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        pbCommenFloorItemViewHolder.p.setIsFromCDN(this.e);
        pbCommenFloorItemViewHolder.p.setText(postData.V(), true, this.g);
        SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.p.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        sparseArray.put(R.id.obfuscated_res_0x7f091fea, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f092003, Boolean.FALSE);
        sparseArray.put(R.id.obfuscated_res_0x7f092004, Boolean.FALSE);
        pbCommenFloorItemViewHolder.p.setTag(sparseArray);
        pbCommenFloorItemViewHolder.b.setTag(R.id.obfuscated_res_0x7f091ffd, sparseArray);
        pbCommenFloorItemViewHolder.n0.setTag(sparseArray);
        pbCommenFloorItemViewHolder.e0.setTag(sparseArray);
    }

    public void d(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, onLongClickListener) == null) {
            this.p = onLongClickListener;
        }
    }

    public final void d0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048600, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || pbCommenFloorItemViewHolder.b == null) {
            return;
        }
        a18 a18Var = this.a;
        if (a18Var != null && a18Var.K() != null && StringHelper.equals(this.a.K().t1(), postData.K())) {
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.b, R.color.CAM_X0313);
        } else {
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.b, R.color.CAM_X0205);
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, onClickListener) == null) {
            this.m = onClickListener;
        }
    }

    public final void e0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, pbCommenFloorItemViewHolder, postData) == null) {
            if (postData != null && postData.b0() != null) {
                TbRichText V = postData.V();
                c28.c(postData.b0(), pbCommenFloorItemViewHolder.N, false, false, V != null && StringUtils.isNull(V.toString()) && StringUtils.isNull(postData.t()));
                return;
            }
            pbCommenFloorItemViewHolder.N.setVisibility(8);
        }
    }

    public final void f0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048603, this, pbCommenFloorItemViewHolder, postData) == null) {
            if (postData.F() != 2 && postData.F() != 4) {
                pbCommenFloorItemViewHolder.U.setVisibility(8);
                pbCommenFloorItemViewHolder.T.setVisibility(0);
                Q(false, pbCommenFloorItemViewHolder, postData);
            } else {
                pbCommenFloorItemViewHolder.U.setOnClickListener(new h(this, pbCommenFloorItemViewHolder, postData));
                pbCommenFloorItemViewHolder.U.setVisibility(0);
                P(pbCommenFloorItemViewHolder, postData.q0(), postData.E());
                Q(true, pbCommenFloorItemViewHolder, postData);
            }
            p0(pbCommenFloorItemViewHolder, postData);
        }
    }

    public final void g0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048604, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        pbCommenFloorItemViewHolder.f(postData.Q, postData.K(), this.v);
    }

    /* JADX WARN: Removed duplicated region for block: B:275:0x07e4  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x07ef  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x07f8  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x083b  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x0845  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x08ab  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x08b5  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x08f4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view2, int i2) {
        int i3;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048605, this, pbCommenFloorItemViewHolder, postData, view2, i2) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        if (postData.s() != null) {
            postData.s().isBaijiahaoUser();
        }
        if (postData.P) {
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.d, R.color.CAM_X0204);
            pbCommenFloorItemViewHolder.d.setVisibility(0);
        } else {
            pbCommenFloorItemViewHolder.d.setVisibility(8);
        }
        pbCommenFloorItemViewHolder.o.setTag(null);
        pbCommenFloorItemViewHolder.o.setUserId(null);
        pbCommenFloorItemViewHolder.I.getHeadView().setUserId(null);
        pbCommenFloorItemViewHolder.p.setIsHost(false);
        if (postData.s() != null) {
            String str = this.j;
            if (str != null && !str.equals("0") && this.j.equals(postData.s().getUserId())) {
                pbCommenFloorItemViewHolder.p.setIsHost(true);
            }
            ArrayList<IconData> iconInfo = postData.s().getIconInfo();
            ArrayList<IconData> tShowInfoNew = postData.s().getTShowInfoNew();
            int f2 = ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds40);
            int f3 = ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            if (iconInfo.size() < 2) {
                i3 = iconInfo.size();
                if (i3 > 1) {
                    postData.d1((f2 * i3) + (f3 * i3));
                } else if (i3 == 1) {
                    postData.d1(f2 + f3);
                } else {
                    postData.d1(0);
                }
            } else {
                postData.d1((f2 * 2) + (f3 * 2));
                i3 = 2;
            }
            if (pbCommenFloorItemViewHolder.J != null) {
                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                    pbCommenFloorItemViewHolder.J.setTag(tShowInfoNew.get(0).getUrl());
                }
                a18 a18Var = this.a;
                if (a18Var != null && a18Var.P() != null) {
                    pbCommenFloorItemViewHolder.J.setOnClickListener(this.a.P().d.e);
                }
                int f4 = ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                pbCommenFloorItemViewHolder.J.h(tShowInfoNew, 3, f4, f4, ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
            }
            if (ListUtils.isEmpty(tShowInfoNew) && !postData.s().isBigV()) {
                if (UbsABTestHelper.isPBPlanA()) {
                    if (DeviceInfoUtil.isMate30()) {
                        sx7.m(pbCommenFloorItemViewHolder.f);
                    } else {
                        os4.d(pbCommenFloorItemViewHolder.f).A(R.string.F_X02);
                    }
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f, R.color.CAM_X0108, 1);
                } else {
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f, R.color.CAM_X0107, 1);
                }
            } else {
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f, R.color.CAM_X0301, 1);
            }
            String avater = postData.s().getAvater();
            int i4 = postData.a0 ? 2 : 8;
            pbCommenFloorItemViewHolder.f.setTag(R.id.obfuscated_res_0x7f09203f, postData.s().getUserId());
            pbCommenFloorItemViewHolder.f.setTag(R.id.obfuscated_res_0x7f092047, postData.s().getUserName());
            pbCommenFloorItemViewHolder.f.setTag(R.id.obfuscated_res_0x7f092049, postData.s().getVirtualUserUrl());
            pbCommenFloorItemViewHolder.f.setTag(R.id.obfuscated_res_0x7f092035, p08.i(this.k, postData, postData.b0, i4, 2));
            String name_show = postData.s().getName_show();
            String userName = postData.s().getUserName();
            if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                pbCommenFloorItemViewHolder.g.setText(ns7.b(this.mContext, pbCommenFloorItemViewHolder.f.getText().toString()));
                pbCommenFloorItemViewHolder.f.setGravity(16);
                pbCommenFloorItemViewHolder.f.setTag(R.id.obfuscated_res_0x7f092014, ns7.a());
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f, R.color.CAM_X0312, 1);
            }
            if (postData.s().getPendantData() != null && !StringUtils.isNull(postData.s().getPendantData().getImgUrl())) {
                pbCommenFloorItemViewHolder.I.setBigVDimenSize(R.dimen.tbds36);
                pbCommenFloorItemViewHolder.I.j(postData.s(), 4);
                pbCommenFloorItemViewHolder.o.setVisibility(8);
                pbCommenFloorItemViewHolder.I.setVisibility(0);
                pbCommenFloorItemViewHolder.I.getHeadView().K(avater, 28, false);
                pbCommenFloorItemViewHolder.I.getHeadView().setUserId(postData.s().getUserId());
                pbCommenFloorItemViewHolder.I.getHeadView().setUserName(postData.s().getUserName());
                mt7 mt7Var = this.k;
                pbCommenFloorItemViewHolder.I.getHeadView().setFid(mt7Var != null ? mt7Var.m() : "");
                mt7 mt7Var2 = this.k;
                pbCommenFloorItemViewHolder.I.getHeadView().setFName(mt7Var2 != null ? mt7Var2.n() : "");
                pbCommenFloorItemViewHolder.I.getHeadView().setFloor(postData.B());
                pbCommenFloorItemViewHolder.I.getHeadView().setTid(postData.K());
                pbCommenFloorItemViewHolder.I.getHeadView().setTag(R.id.obfuscated_res_0x7f092035, p08.i(this.k, postData, postData.b0, i4, 2));
                pbCommenFloorItemViewHolder.I.m(postData.s().getPendantData().getImgUrl());
            } else {
                pbCommenFloorItemViewHolder.o.setGodIconWidth(R.dimen.tbds36);
                UtilHelper.showHeadImageViewBigV(pbCommenFloorItemViewHolder.o, postData.s(), 4);
                pbCommenFloorItemViewHolder.o.setUserId(postData.s().getUserId());
                mt7 mt7Var3 = this.k;
                pbCommenFloorItemViewHolder.o.setFid(mt7Var3 != null ? mt7Var3.m() : "");
                mt7 mt7Var4 = this.k;
                pbCommenFloorItemViewHolder.o.setFName(mt7Var4 != null ? mt7Var4.n() : "");
                pbCommenFloorItemViewHolder.o.setFloor(postData.B());
                pbCommenFloorItemViewHolder.o.setTid(postData.K());
                pbCommenFloorItemViewHolder.o.setUserName(postData.s().getUserName(), postData.g0());
                pbCommenFloorItemViewHolder.o.setTag(R.id.obfuscated_res_0x7f092049, postData.s().getVirtualUserUrl());
                pbCommenFloorItemViewHolder.o.setTag(R.id.obfuscated_res_0x7f092035, p08.i(this.k, postData, postData.b0, i4, 2));
                pbCommenFloorItemViewHolder.o.setImageDrawable(null);
                pbCommenFloorItemViewHolder.o.K(avater, 28, false);
                pbCommenFloorItemViewHolder.o.setVisibility(0);
                pbCommenFloorItemViewHolder.I.setVisibility(8);
            }
            if (postData.s() != null && postData.s().getAlaInfo() != null && postData.s().getAlaUserData() != null && postData.s().getAlaUserData().live_status == 1) {
                pbCommenFloorItemViewHolder.d(true);
                pbCommenFloorItemViewHolder.o.setLiveStatus(1);
                pbCommenFloorItemViewHolder.o.setAlaInfo(postData.s().getAlaInfo());
                pbCommenFloorItemViewHolder.I.getHeadView().setLiveStatus(1);
                pbCommenFloorItemViewHolder.I.getHeadView().setAlaInfo(postData.s().getAlaInfo());
            } else {
                pbCommenFloorItemViewHolder.d(false);
                pbCommenFloorItemViewHolder.o.setLiveStatus(0);
                pbCommenFloorItemViewHolder.o.setAlaInfo(null);
                pbCommenFloorItemViewHolder.I.getHeadView().setLiveStatus(0);
                pbCommenFloorItemViewHolder.I.getHeadView().setAlaInfo(null);
            }
            C0(pbCommenFloorItemViewHolder.h, postData);
            if (TbSingleton.getInstance().isUserGrowthOpen() && postData.s().getUserGrowthData() != null) {
                int a2 = postData.s().getUserGrowthData().a();
                if (a2 >= 0 && a2 <= 10) {
                    pbCommenFloorItemViewHolder.i.K(String.valueOf(ww.b(a2)), 24, false);
                    pbCommenFloorItemViewHolder.i.setVisibility(0);
                    pbCommenFloorItemViewHolder.i.setOnClickListener(new i(this));
                } else {
                    pbCommenFloorItemViewHolder.i.setVisibility(8);
                }
            }
        } else {
            i3 = 2;
        }
        a18 a18Var2 = this.a;
        int level_id = (a18Var2 == null || a18Var2.P() == null || !this.a.P().u0() || postData.s() == null) ? 0 : postData.s().getLevel_id();
        mt7 mt7Var5 = this.k;
        if (mt7Var5 != null && mt7Var5.i0()) {
            level_id = 0;
        }
        if (level_id > 0) {
            pbCommenFloorItemViewHolder.H.setVisibility(0);
            SkinManager.setImageResource(pbCommenFloorItemViewHolder.H, BitmapHelper.getGradeResourceIdInEnterForum(level_id));
        } else {
            pbCommenFloorItemViewHolder.H.setVisibility(8);
        }
        int i5 = 15;
        if (i3 == 1) {
            i5 = 13;
        } else if (i3 > 1) {
            i5 = 11;
        }
        if (pbCommenFloorItemViewHolder.h.getVisibility() == 0) {
            i5 -= 2;
        }
        if (pbCommenFloorItemViewHolder.J.getChildCount() > 0) {
            i5 -= 2;
        }
        if (postData.x() > 1000) {
            i5 -= 2;
        }
        if (postData.x() > 10) {
            i5 -= 2;
        }
        if (i5 < 10) {
            if (i3 == 1) {
                i5 += 2;
            } else if (i3 > 1) {
                i5 += 4;
            }
            if (i5 < 10 && pbCommenFloorItemViewHolder.h.getVisibility() == 0) {
                i5 += 2;
                pbCommenFloorItemViewHolder.h.setVisibility(8);
            }
            if (i5 < 10 && pbCommenFloorItemViewHolder.H.getVisibility() == 0) {
                pbCommenFloorItemViewHolder.H.setVisibility(8);
            }
        }
        int e2 = sx7.e();
        String[] strArr = new String[1];
        strArr[0] = (postData.s() == null || postData.s().getName_show() == null) ? "" : postData.s().getName_show();
        int d2 = pf5.d(strArr[0]);
        if (postData.s() != null && !StringUtils.isNull(postData.s().getSealPrefix())) {
            int i6 = e2 - 2;
            if (d2 > i6) {
                strArr[0] = pf5.n(strArr[0], i6);
                strArr[0] = strArr[0] + StringHelper.STRING_MORE;
            }
        } else if (d2 > e2) {
            strArr[0] = pf5.n(strArr[0], e2);
            strArr[0] = strArr[0] + StringHelper.STRING_MORE;
        }
        if (postData.s() != null && !StringUtils.isNull(postData.s().getSealPrefix())) {
            pbCommenFloorItemViewHolder.g.setText(j0(postData.s().getSealPrefix(), strArr[0]));
        } else {
            pbCommenFloorItemViewHolder.g.setText(strArr[0]);
        }
        if (((PostData) getItem(i2)).N() == 1 && this.k.O() != null && this.k.O().isQuestionThread() && !R(postData)) {
            ((PostData) getItem(i2)).H0(true);
            pbCommenFloorItemViewHolder.x0.setVisibility(0);
            if (((PostData) getItem(i2)).M().booleanValue()) {
                pbCommenFloorItemViewHolder.y0.setVisibility(0);
                pbCommenFloorItemViewHolder.d0.setVisibility(8);
                pbCommenFloorItemViewHolder.e0.setVisibility(8);
                pbCommenFloorItemViewHolder.y0.postDelayed(new j(this, pbCommenFloorItemViewHolder), 3000L);
            } else {
                pbCommenFloorItemViewHolder.y0.setVisibility(8);
                pbCommenFloorItemViewHolder.d0.setVisibility(0);
                pbCommenFloorItemViewHolder.e0.setVisibility(0);
            }
        } else {
            ((PostData) getItem(i2)).H0(false);
            pbCommenFloorItemViewHolder.x0.setVisibility(8);
            pbCommenFloorItemViewHolder.y0.setVisibility(8);
            pbCommenFloorItemViewHolder.d0.setVisibility(0);
            pbCommenFloorItemViewHolder.e0.setVisibility(0);
        }
        SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.x0, R.color.CAM_X0204);
        SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.w0, R.color.CAM_X0105, 1);
        pbCommenFloorItemViewHolder.e.post(new k(this, pbCommenFloorItemViewHolder, postData, new String[]{strArr[0]}, 2));
        if (!StringUtils.isNull(postData.s().getDiplayIntro())) {
            pbCommenFloorItemViewHolder.z0.setVisibility(0);
            pbCommenFloorItemViewHolder.z0.setText(postData.s().getDiplayIntro() + "");
        } else {
            pbCommenFloorItemViewHolder.z0.setVisibility(8);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.obfuscated_res_0x7f091fea, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f092007, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f092009, view2);
        sparseArray.put(R.id.obfuscated_res_0x7f092018, Integer.valueOf(i2));
        sparseArray.put(R.id.obfuscated_res_0x7f092017, Integer.valueOf(postData.B()));
        sparseArray.put(R.id.obfuscated_res_0x7f091ffa, postData.K());
        sparseArray.put(R.id.obfuscated_res_0x7f0917ba, pbCommenFloorItemViewHolder.n);
        sparseArray.put(R.id.obfuscated_res_0x7f0917bb, pbCommenFloorItemViewHolder.d0);
        sparseArray.put(R.id.obfuscated_res_0x7f0917b8, pbCommenFloorItemViewHolder.v);
        sparseArray.put(R.id.obfuscated_res_0x7f0917b9, pbCommenFloorItemViewHolder.w);
        mt7 mt7Var6 = this.k;
        ThreadData O = (mt7Var6 == null || mt7Var6.O() == null) ? null : this.k.O();
        if (O != null && O.isUgcThreadType()) {
            sparseArray.put(R.id.obfuscated_res_0x7f0917b7, Boolean.TRUE);
        } else {
            sparseArray.put(R.id.obfuscated_res_0x7f0917b7, Boolean.FALSE);
        }
        boolean z8 = (postData.s() == null || StringUtils.isNull(postData.s().getVirtualUserUrl())) ? false : true;
        mt7 mt7Var7 = this.k;
        if (mt7Var7 == null || mt7Var7.W() == 0 || l0()) {
            z = false;
            z2 = false;
            z3 = false;
        } else {
            z = (this.k.W() == 1002 || this.k.W() == 3) ? false : true;
            if (this.k.W() == 3 || this.k.i0()) {
                z2 = false;
                z3 = false;
            } else {
                z2 = true;
                z3 = true;
            }
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
        mt7 mt7Var8 = this.k;
        if (mt7Var8 != null && mt7Var8.O() != null && this.k.O().getAuthor() != null && postData.s() != null) {
            String userId2 = this.k.O().getAuthor().getUserId();
            String userId3 = postData.s().getUserId();
            if (UtilHelper.isCurrentAccount(userId2)) {
                if (UtilHelper.isCurrentAccount(userId3)) {
                    z5 = false;
                    z4 = true;
                    z6 = true;
                } else {
                    z5 = true;
                    z4 = true;
                    z6 = false;
                }
                z7 = true;
                if (postData != null && postData.s() != null && UtilHelper.isCurrentAccount(postData.s().getUserId())) {
                    z4 = true;
                    z6 = true;
                }
                if (z8) {
                    z = false;
                    z5 = false;
                    z4 = false;
                }
                int i7 = postData.B() != 1 ? 1 : 0;
                if (!z) {
                    sparseArray.put(R.id.obfuscated_res_0x7f092032, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f09200a, Integer.valueOf(this.k.W()));
                    if (postData.s() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f091ff7, postData.s().getUserName());
                        sparseArray.put(R.id.obfuscated_res_0x7f091ff8, postData.s().getName_show());
                        sparseArray.put(R.id.obfuscated_res_0x7f091ff9, postData.s().getPortrait());
                    }
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f092032, Boolean.FALSE);
                }
                if (!z5) {
                    sparseArray.put(R.id.obfuscated_res_0x7f092046, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f092001, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.s() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f092042, postData.s().getUserId());
                        sparseArray.put(R.id.obfuscated_res_0x7f092043, postData.s().getUserName());
                        sparseArray.put(R.id.obfuscated_res_0x7f092041, postData.s().getName_show());
                    }
                    if (this.k.O() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f092045, this.k.O().getId());
                    }
                    sparseArray.put(R.id.obfuscated_res_0x7f092044, postData.K());
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f092046, Boolean.FALSE);
                }
                if (!z4) {
                    sparseArray.put(R.id.obfuscated_res_0x7f092030, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f091ffe, Boolean.valueOf(postData.n0()));
                    sparseArray.put(R.id.obfuscated_res_0x7f09200a, Integer.valueOf(this.k.W()));
                    sparseArray.put(R.id.obfuscated_res_0x7f091fed, Boolean.valueOf(z6));
                    sparseArray.put(R.id.obfuscated_res_0x7f091fee, Integer.valueOf(i7));
                    sparseArray.put(R.id.obfuscated_res_0x7f091fec, postData.K());
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f092030, Boolean.FALSE);
                }
                sparseArray.put(R.id.obfuscated_res_0x7f09200b, Boolean.valueOf(z3));
                sparseArray.put(R.id.obfuscated_res_0x7f092002, Boolean.valueOf(z7));
                pbCommenFloorItemViewHolder.p.setTag(sparseArray);
            }
        }
        z4 = z2;
        z5 = false;
        z6 = false;
        z7 = false;
        if (postData != null) {
            z4 = true;
            z6 = true;
        }
        if (z8) {
        }
        if (postData.B() != 1) {
        }
        if (!z) {
        }
        if (!z5) {
        }
        if (!z4) {
        }
        sparseArray.put(R.id.obfuscated_res_0x7f09200b, Boolean.valueOf(z3));
        sparseArray.put(R.id.obfuscated_res_0x7f092002, Boolean.valueOf(z7));
        pbCommenFloorItemViewHolder.p.setTag(sparseArray);
    }

    public final boolean i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            mt7 mt7Var = this.k;
            if (mt7Var == null || mt7Var.O() == null) {
                return false;
            }
            return this.k.O().isQuestionThread();
        }
        return invokeV.booleanValue;
    }

    public final SpannableStringBuilder j0(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048607, this, str, str2)) == null) {
            ArrayList arrayList = new ArrayList();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (str2 == null || str == null) {
                return spannableStringBuilder;
            }
            arrayList.add(new uz5.a(str, R.drawable.pic_smalldot_title));
            return uz5.h(this.a.P(), str2, arrayList, true);
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, onClickListener) == null) {
            this.l = onClickListener;
        }
    }

    public final String k0(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, view2)) == null) {
            SparseArray sparseArray = (SparseArray) view2.getTag();
            if (sparseArray == null) {
                return "1";
            }
            Object obj = sparseArray.get(R.id.obfuscated_res_0x7f091854);
            String str = obj != null ? obj : "1";
            sparseArray.remove(R.id.obfuscated_res_0x7f091854);
            view2.setTag(sparseArray);
            return str.toString();
        }
        return (String) invokeL.objValue;
    }

    public final boolean l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            mt7 mt7Var = this.k;
            if (mt7Var == null || mt7Var.O() == null) {
                return false;
            }
            return this.k.O().isBlocked();
        }
        return invokeV.booleanValue;
    }

    public void m0(com.baidu.tbadk.data.MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, metaData) == null) {
            PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(this.mContext, metaData.getUserIdLong(), metaData.getUserName(), metaData.getName_show(), metaData.getPortrait(), metaData.getGender(), metaData.getIsMyFriend());
            personalChatActivityConfig.setFrom(3);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, personalChatActivityConfig));
        }
    }

    public void n(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, yVar) == null) {
            this.n = yVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.cn
    /* renamed from: n0 */
    public PbCommenFloorItemViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d06cc, viewGroup, false);
            ((ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f091836)).addView(LayoutInflater.from(inflate.getContext()).inflate(R.layout.obfuscated_res_0x7f0d06c4, (ViewGroup) null));
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = new PbCommenFloorItemViewHolder(this.a.P().getPageContext(), inflate, this.t);
            pbCommenFloorItemViewHolder.q.setConstrainLayoutPool(this.y);
            pbCommenFloorItemViewHolder.q.setImageViewPool(this.z);
            SubPbLayout subPbLayout = pbCommenFloorItemViewHolder.s;
            if (subPbLayout != null) {
                subPbLayout.setShowChildComment(this.u);
                pbCommenFloorItemViewHolder.s.setIsVideoThread(false);
            }
            z0(pbCommenFloorItemViewHolder);
            TbRichTextView tbRichTextView = pbCommenFloorItemViewHolder.p;
            if (tbRichTextView != null) {
                tbRichTextView.setDuiEnabled(this.s);
            }
            return pbCommenFloorItemViewHolder;
        }
        return (PbCommenFloorItemViewHolder) invokeL.objValue;
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, str) == null) {
            this.j = str;
        }
    }

    public View o0(int i2, View view2, ViewGroup viewGroup, PostData postData, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048615, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, postData, pbCommenFloorItemViewHolder})) == null) {
            super.onFillViewHolder(i2, view2, viewGroup, postData, pbCommenFloorItemViewHolder);
            z0(pbCommenFloorItemViewHolder);
            s0(pbCommenFloorItemViewHolder, i2);
            K(pbCommenFloorItemViewHolder);
            PostData postData2 = (PostData) getItem(i2);
            if (postData2 != null) {
                postData2.b0 = i2 + 1;
                M(postData2);
                L(postData2);
                postData2.h1();
                T(postData2);
                Y(pbCommenFloorItemViewHolder, postData2, view2, i2);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, view2) == null) {
        }
    }

    @Override // com.baidu.tieba.iw7, com.baidu.tieba.cn
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i2, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        o0(i2, view2, viewGroup, (PostData) obj, (PbCommenFloorItemViewHolder) viewHolder);
        return view2;
    }

    public final void p0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048619, this, pbCommenFloorItemViewHolder, postData) == null) {
            TbRichText V = postData.V();
            V.isChanged = true;
            pbCommenFloorItemViewHolder.p.setText(V, true, this.g);
        }
    }

    public final void q0(PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, postData) == null) {
            String userId = postData.s().getUserId();
            mt7 mt7Var = this.k;
            String m2 = mt7Var != null ? mt7Var.m() : "";
            mt7 mt7Var2 = this.k;
            String n = mt7Var2 != null ? mt7Var2.n() : "";
            int B = postData.B();
            String K = postData.K();
            StatisticItem statisticItem = new StatisticItem("c13714");
            statisticItem.param("fid", m2);
            statisticItem.param("fname", n);
            statisticItem.param("obj_param1", userId);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("tid", K);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, B);
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

    public void r(mt7 mt7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, mt7Var) == null) {
            this.k = mt7Var;
        }
    }

    public void r0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
            this.s = z;
        }
    }

    public final void s0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048623, this, pbCommenFloorItemViewHolder, i2) == null) {
            pbCommenFloorItemViewHolder.b.setOnTouchListener(this.A);
            pbCommenFloorItemViewHolder.b.setOnLongClickListener(this.p);
            if (this.a.P() == null || this.a.P().getPageContext() == null || this.a.P().getPageContext().getOrignalPage() == null) {
                return;
            }
            yy7 yy7Var = this.a.P().d;
            pbCommenFloorItemViewHolder.f.setOnClickListener(yy7Var.b);
            pbCommenFloorItemViewHolder.o.setOnClickListener(yy7Var.b);
            pbCommenFloorItemViewHolder.t0.setOnClickListener(yy7Var.d);
            pbCommenFloorItemViewHolder.s0.setOnClickListener(yy7Var.d);
            pbCommenFloorItemViewHolder.I.setOnClickListener(yy7Var.b);
            pbCommenFloorItemViewHolder.I.getHeadView().setOnClickListener(yy7Var.b);
            pbCommenFloorItemViewHolder.p.setOnLongClickListener(this.p);
            pbCommenFloorItemViewHolder.p.setOnTouchListener(this.A);
            pbCommenFloorItemViewHolder.p.setCommonTextViewOnClickListener(this.m);
            pbCommenFloorItemViewHolder.p.setOnImageClickListener(this.n);
            pbCommenFloorItemViewHolder.p.setOnImageTouchListener(this.A);
            pbCommenFloorItemViewHolder.p.setOnEmotionClickListener(yy7Var.f);
            pbCommenFloorItemViewHolder.p.setOnVoiceAfterClickListener(this.m);
            pbCommenFloorItemViewHolder.N.setOnClickListener(this.m);
            pbCommenFloorItemViewHolder.O.setOnClickListener(this.m);
            pbCommenFloorItemViewHolder.t.setOnClickListener(this.m);
            pbCommenFloorItemViewHolder.u.setOnClickListener(this.m);
            pbCommenFloorItemViewHolder.i0.setOnClickListener(this.m);
            pbCommenFloorItemViewHolder.m0.setOnClickListener(this.m);
            pbCommenFloorItemViewHolder.m0.setOnTouchListener(this.A);
            pbCommenFloorItemViewHolder.e0.setOnClickListener(this.m);
            pbCommenFloorItemViewHolder.n0.setOnClickListener(this.m);
            pbCommenFloorItemViewHolder.f0.setOnClickListener(new m(this, pbCommenFloorItemViewHolder));
            az7 az7Var = this.a.P().e;
            pbCommenFloorItemViewHolder.v.setOnClickListener(this.m);
            pbCommenFloorItemViewHolder.w.setOnClickListener(new a(this, pbCommenFloorItemViewHolder, az7Var));
            pbCommenFloorItemViewHolder.n.x = new b(this, pbCommenFloorItemViewHolder);
            pbCommenFloorItemViewHolder.d0.x = new c(this, pbCommenFloorItemViewHolder);
            pbCommenFloorItemViewHolder.d0.setAfterClickListener(new d(this, i2, pbCommenFloorItemViewHolder));
        }
    }

    public void t0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
            this.v = z;
        }
    }

    public void u0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
            this.r = z;
        }
    }

    public void v0(ou7 ou7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, ou7Var) == null) {
            this.o = ou7Var;
        }
    }

    public void w0(TbRichTextView.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, sVar) == null) {
            this.g = sVar;
        }
    }

    public final void x0(TextView textView, TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048628, this, textView, tbImageView) == null) {
            textView.getViewTreeObserver().addOnGlobalLayoutListener(new l(this, textView, tbImageView));
        }
    }

    public final void y0(TbImageView tbImageView, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048629, this, tbImageView, z) == null) || tbImageView == null) {
            return;
        }
        if (z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbImageView.getLayoutParams();
            layoutParams.setMargins(ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds_16), ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds7), 0, 0);
            tbImageView.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) tbImageView.getLayoutParams();
        layoutParams2.setMargins(ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds10), ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds7), 0, 0);
        tbImageView.setLayoutParams(layoutParams2);
    }

    public final void z0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048630, this, pbCommenFloorItemViewHolder) == null) || pbCommenFloorItemViewHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (pbCommenFloorItemViewHolder.a != skinType) {
            B0(pbCommenFloorItemViewHolder.h);
            if (UbsABTestHelper.isPBPlanA()) {
                if (DeviceInfoUtil.isMate30()) {
                    sx7.m(pbCommenFloorItemViewHolder.f);
                } else {
                    os4.d(pbCommenFloorItemViewHolder.f).A(R.string.F_X02);
                }
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f, R.color.CAM_X0108, 1);
            } else {
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f, R.color.CAM_X0109, 1);
            }
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.j, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.k, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.l, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.G, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.m, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.u, (int) R.color.CAM_X0108);
            pbCommenFloorItemViewHolder.p.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g0, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.h0, R.color.CAM_X0107, 1);
            SkinManager.setBackgroundShapeDrawable(pbCommenFloorItemViewHolder.s, ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds21), R.color.CAM_X0206, R.color.CAM_X0206);
            SkinManager.getColor(R.color.CAM_X0107);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.t, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.t, (int) R.color.CAM_X0304);
            pbCommenFloorItemViewHolder.t.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right, SkinManager.getColor(R.color.CAM_X0304), null), (Drawable) null);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.v, R.drawable.obfuscated_res_0x7f08098c, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.w, R.drawable.obfuscated_res_0x7f08098d, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbCommenFloorItemViewHolder.s.d();
            pbCommenFloorItemViewHolder.q.b();
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.R, R.color.CAM_X0304, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.P, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.O, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.Q, R.color.CAM_X0109);
            SkinManager.setImageResource(pbCommenFloorItemViewHolder.S, R.drawable.icon_arrow_more_gray);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.V, (int) R.color.CAM_X0107);
            if (pbCommenFloorItemViewHolder.T.getVisibility() == 8) {
                pbCommenFloorItemViewHolder.V.setText(R.string.obfuscated_res_0x7f0f03f7);
            } else {
                mt7 mt7Var = this.k;
                if (mt7Var != null && StringUtils.isNull(mt7Var.k())) {
                    pbCommenFloorItemViewHolder.V.setText(this.k.k());
                } else {
                    pbCommenFloorItemViewHolder.V.setText(R.string.obfuscated_res_0x7f0f05d9);
                }
            }
            pbCommenFloorItemViewHolder.n.L(TbadkCoreApplication.getInst().getSkinType());
            pbCommenFloorItemViewHolder.c(skinType);
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.M, R.color.CAM_X0203);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.e0, R.drawable.obfuscated_res_0x7f080967, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.n0, R.drawable.obfuscated_res_0x7f080967, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbCommenFloorItemViewHolder.b();
        }
        pbCommenFloorItemViewHolder.a = skinType;
    }
}

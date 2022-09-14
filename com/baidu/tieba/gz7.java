package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
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
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.CommonStatisticUtils;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
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
import com.baidu.tieba.g16;
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.xv7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class gz7 extends mx7<PostData, PbCommenFloorItemViewHolder> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public xv7 A;
    public int g;
    public TbRichTextView.s h;
    public boolean i;
    public float j;
    public String k;
    public vu7 l;
    public View.OnClickListener m;
    public View.OnClickListener n;
    public TbRichTextView.y o;
    public xv7 p;
    public View.OnLongClickListener q;
    public e18 r;
    public int s;
    public boolean t;
    public boolean u;
    public int v;
    public boolean w;
    public boolean x;
    public ug<ConstrainImageLayout> y;
    public ug<TbImageView> z;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ gz7 b;

        public a(gz7 gz7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gz7Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gz7Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || view2 == null || this.b.l == null || (pbCommenFloorItemViewHolder = this.a) == null || (agreeView = pbCommenFloorItemViewHolder.f0) == null || agreeView.getData() == null) {
                return;
            }
            int i = view2 == this.a.f0.getImgAgree() ? 1 : 2;
            String Q = this.b.l.Q();
            if ((StringUtils.isNull(Q) || "0".equals(this.b.l.Q())) && this.b.l.O() != null) {
                Q = this.b.l.O().getNid();
            }
            TiebaStatic.log(new StatisticItem("c13700").param("tid", Q).param("fid", this.b.l.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.f0.getData().postId).param("obj_source", this.b.e0(this.a.f0)).param("obj_type", i));
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
            statisticItem.param("fid", this.b.l.m());
            statisticItem.param("tid", this.b.l.Q());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("post_id", this.b.l.j().L());
            statisticItem.param("obj_source", 1);
            statisticItem.param("obj_type", 1);
            statisticItem.param("obj_locate", this.b.c0());
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gz7 a;

        public b(gz7 gz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gz7Var;
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

    /* loaded from: classes4.dex */
    public class c implements vg<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gz7 a;

        public c(gz7 gz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gz7Var;
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
    public class d implements vg<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gz7 a;

        public d(gz7 gz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gz7Var;
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
    public class e implements xv7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gz7 a;

        public e(gz7 gz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gz7Var;
        }

        @Override // com.baidu.tieba.xv7.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.xv7.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (this.a.p != null) {
                    if (!(view2 instanceof TbListTextView) || this.a.n == null) {
                        this.a.p.a(view2);
                        this.a.p.onSingleTapConfirmed(motionEvent);
                        return true;
                    }
                    this.a.n.onClick(view2);
                    return true;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.xv7.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            PbFragment pbFragment;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                if (view2 == null || (!((pbFragment = this.a.b) == null || pbFragment.P5() == null || this.a.b.P5().K1()) || view2.getId() == R.id.obfuscated_res_0x7f090a0c)) {
                    return true;
                }
                if (view2 instanceof FrameLayout) {
                    this.a.L(view2);
                } else {
                    ViewParent parent = view2.getParent();
                    int i = 0;
                    while (true) {
                        if (parent == null || i >= 10) {
                            break;
                        } else if (parent instanceof FrameLayout) {
                            this.a.L((RelativeLayout) parent);
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
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ gz7 b;

        public f(gz7 gz7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gz7Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gz7Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SkinManager.setBackgroundColor(this.a.b, R.color.CAM_X0205);
                f28 f28Var = this.b.a;
                if (f28Var == null || f28Var.K() == null) {
                    return;
                }
                this.b.a.K().Y0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ PostData b;
        public final /* synthetic */ gz7 c;

        public g(gz7 gz7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gz7Var, pbCommenFloorItemViewHolder, postData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = gz7Var;
            this.a = pbCommenFloorItemViewHolder;
            this.b = postData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                boolean z = this.a.V.getVisibility() == 8;
                this.c.I(this.a, !z, this.b.F());
                this.b.L0(!z);
                this.c.i0(this.a, this.b);
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
        public final /* synthetic */ gz7 b;

        public h(gz7 gz7Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gz7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gz7Var;
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.b.mContext == null) {
                return;
            }
            CommonStatisticUtils.staticNameplateOfUserLevel(2, 7, this.a);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.b.mContext, null, TbConfig.USER_GROWTH_TASK_CENTER_MAIN_URL, true)));
        }
    }

    /* loaded from: classes4.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;

        public i(gz7 gz7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gz7Var, pbCommenFloorItemViewHolder};
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
                this.a.x.performClick();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ e08 b;
        public final /* synthetic */ gz7 c;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PostData a;
            public final /* synthetic */ j b;

            public a(j jVar, PostData postData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar, postData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = jVar;
                this.a = postData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    j jVar = this.b;
                    jVar.b.b.a(jVar.c.l, null, this.a, jVar.a.p.getLayoutStrategy());
                }
            }
        }

        public j(gz7 gz7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, e08 e08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gz7Var, pbCommenFloorItemViewHolder, e08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = gz7Var;
            this.a = pbCommenFloorItemViewHolder;
            this.b = e08Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PostData postData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (view2.getTag() instanceof SparseArray)) {
                SparseArray sparseArray = (SparseArray) view2.getTag();
                if (!(sparseArray.get(R.id.obfuscated_res_0x7f092057) instanceof PostData) || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f092057)) == null || this.a.b == null || this.b == null) {
                    return;
                }
                gh.a().postDelayed(new a(this, postData), 100L);
                String Q = this.c.l.Q();
                if ((StringUtils.isNull(Q) || "0".equals(this.c.l.Q())) && this.c.l.O() != null) {
                    Q = this.c.l.O().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", Q).param("fid", this.c.l.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData.L()).param("obj_source", this.c.e0(view2)).param("obj_type", 4));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ gz7 b;

        public k(gz7 gz7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gz7Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gz7Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || view2 == null || this.b.l == null || (pbCommenFloorItemViewHolder = this.a) == null || (agreeView = pbCommenFloorItemViewHolder.n) == null || agreeView.getData() == null) {
                return;
            }
            int i = view2 == this.a.n.getImgAgree() ? 1 : 2;
            String Q = this.b.l.Q();
            if ((StringUtils.isNull(Q) || "0".equals(this.b.l.Q())) && this.b.l.O() != null) {
                Q = this.b.l.O().getNid();
            }
            TiebaStatic.log(new StatisticItem("c13700").param("tid", Q).param("fid", this.b.l.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.n.getData().postId).param("obj_source", this.b.e0(this.a.n)).param("obj_type", i));
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
            statisticItem.param("fid", this.b.l.m());
            statisticItem.param("tid", this.b.l.Q());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("post_id", this.b.l.j().L());
            statisticItem.param("obj_source", 1);
            statisticItem.param("obj_type", 1);
            statisticItem.param("obj_locate", this.b.c0());
            TiebaStatic.log(statisticItem);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gz7(f28 f28Var, BdUniqueId bdUniqueId) {
        super(f28Var, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {f28Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((f28) objArr2[0], (BdUniqueId) objArr2[1]);
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
        this.y = new ug<>(new c(this), 6, 0);
        this.z = new ug<>(new d(this), 12, 0);
        this.A = new xv7(new e(this));
        if (f28Var != null && f28Var.K() != null) {
            this.v = f28Var.K().R1();
        }
        this.g = s(R.dimen.tbds14);
    }

    public final void E(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.p.setTextViewOnTouchListener(this.p);
            pbCommenFloorItemViewHolder.p.setTextViewCheckSelection(false);
            pbCommenFloorItemViewHolder.r.setOnTouchListener(new b(this));
        }
    }

    public final void F(PostData postData) {
        vu7 vu7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, postData) == null) || (vu7Var = this.l) == null) {
            return;
        }
        if (vu7Var.u0()) {
            AbsVideoPbFragment absVideoPbFragment = this.c;
            if (absVideoPbFragment != null) {
                v18.e(absVideoPbFragment.getUniqueId(), this.l, postData, postData.b0, postData.a0 ? 2 : 8, "common_exp_source_pb_comment");
                return;
            }
            return;
        }
        PbFragment pbFragment = this.b;
        if (pbFragment != null) {
            v18.e(pbFragment.getUniqueId(), this.l, postData, postData.b0, postData.a0 ? 2 : 8, "common_exp_source_pb_comment");
        }
    }

    public final void G(PostData postData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, postData) == null) && postData.C == 0 && postData.K) {
            StatisticItem statisticItem = new StatisticItem("c12203");
            statisticItem.param("post_id", postData.L());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("cuid", TbadkCoreApplication.getInst().getCuid());
            statisticItem.param("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            statisticItem.param("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
            statisticItem.param(TiebaStatic.Params.CUID_GID, TbadkCoreApplication.getInst().getCuidGid());
            statisticItem.param(TiebaStatic.Params.EXPOSURE_TIME, System.currentTimeMillis());
            f28 f28Var = this.a;
            if (f28Var != null) {
                int R1 = f28Var.K().R1();
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
            j0(postData);
        }
    }

    public final void H(TbRichTextView tbRichTextView, View view2, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{tbRichTextView, view2, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || tbRichTextView == null || view2 == null) {
            return;
        }
        int k2 = ((((ej.k(TbadkCoreApplication.getInst()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight()) - i2;
        if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
            k2 = (k2 - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
        }
        int s = z ? s(R.dimen.tbds115) : 0;
        tbRichTextView.getLayoutStrategy().q((int) ((k2 - s) * this.j));
        tbRichTextView.getLayoutStrategy().H = (k2 - s) - s(R.dimen.tbds122);
        tbRichTextView.getLayoutStrategy().p((int) (k2 * 1.618f * this.j));
    }

    public final void I(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{pbCommenFloorItemViewHolder, Boolean.valueOf(z), str}) == null) {
            if (z) {
                pbCommenFloorItemViewHolder.V.setVisibility(8);
                if (StringUtils.isNull(str)) {
                    pbCommenFloorItemViewHolder.X.setText(R.string.obfuscated_res_0x7f0f05e6);
                    return;
                } else {
                    pbCommenFloorItemViewHolder.X.setText(str);
                    return;
                }
            }
            pbCommenFloorItemViewHolder.V.setVisibility(0);
            pbCommenFloorItemViewHolder.X.setText(R.string.obfuscated_res_0x7f0f03fb);
        }
    }

    public final void K(boolean z, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), pbCommenFloorItemViewHolder, postData}) == null) || pbCommenFloorItemViewHolder == null || (view2 = pbCommenFloorItemViewHolder.O) == null || pbCommenFloorItemViewHolder.W == null || !(view2.getLayoutParams() instanceof RelativeLayout.LayoutParams) || !(pbCommenFloorItemViewHolder.W.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            return;
        }
        boolean z2 = !ListUtils.isEmpty(postData.Z());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.O.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.W.getLayoutParams();
        if (z) {
            pbCommenFloorItemViewHolder.p.getLayoutStrategy().m(0);
            if (z2) {
                pbCommenFloorItemViewHolder.p.getLayoutStrategy().l(ej.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = ej.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                }
            } else {
                pbCommenFloorItemViewHolder.p.getLayoutStrategy().l(ej.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = 0;
                }
            }
            pbCommenFloorItemViewHolder.W.setLayoutParams(layoutParams2);
            if (layoutParams != null) {
                layoutParams.topMargin = ej.f(this.mContext, R.dimen.tbds20);
                pbCommenFloorItemViewHolder.O.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        pbCommenFloorItemViewHolder.p.getLayoutStrategy().l(ej.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
        pbCommenFloorItemViewHolder.p.getLayoutStrategy().m(ej.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
        if (layoutParams != null) {
            layoutParams.topMargin = ej.f(this.mContext, R.dimen.tbds14);
            pbCommenFloorItemViewHolder.O.setLayoutParams(layoutParams);
        }
    }

    public final void L(View view2) {
        PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, view2) == null) || view2 == null || !(view2.getTag() instanceof PbCommenFloorItemViewHolder) || (agreeView = (pbCommenFloorItemViewHolder = (PbCommenFloorItemViewHolder) view2.getTag()).f0) == null || agreeView.getData() == null) {
            return;
        }
        pbCommenFloorItemViewHolder.f0.setAgreeSource(2);
        pbCommenFloorItemViewHolder.f0.J();
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
        statisticItem.param("fid", this.l.m());
        statisticItem.param("tid", this.l.Q());
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param("post_id", this.l.j().L());
        statisticItem.param("obj_source", 1);
        statisticItem.param("obj_type", 1);
        statisticItem.param("obj_locate", c0());
        TiebaStatic.log(statisticItem);
    }

    public final void M(PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, postData) == null) || postData == null) {
            return;
        }
        StatisticItem i2 = v18.i(this.l, postData, postData.b0, postData.a0 ? 2 : 8, 6);
        postData.c0 = i2;
        if (ListUtils.isEmpty(postData.Z())) {
            return;
        }
        Iterator<PostData> it = postData.Z().iterator();
        while (it.hasNext()) {
            it.next().c0 = i2;
        }
    }

    public final void N(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pbCommenFloorItemViewHolder, postData) == null) {
            if (!TextUtils.isEmpty(postData.t()) && this.i) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.q.getLayoutParams();
                layoutParams.topMargin = s(R.dimen.obfuscated_res_0x7f0701d5);
                layoutParams.bottomMargin = s(R.dimen.obfuscated_res_0x7f0701d5);
                pbCommenFloorItemViewHolder.q.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.p.getLayoutParams();
                if (!TextUtils.isEmpty(postData.y())) {
                    pbCommenFloorItemViewHolder.r.setVisibility(0);
                    pbCommenFloorItemViewHolder.r.k(ln4.a(postData.y()));
                    layoutParams2.topMargin = ej.f(this.mContext, R.dimen.tbds48) * (-1);
                } else {
                    pbCommenFloorItemViewHolder.r.setVisibility(8);
                    layoutParams2.topMargin = 0;
                }
                pbCommenFloorItemViewHolder.p.setLayoutParams(layoutParams2);
                pbCommenFloorItemViewHolder.p.k0(postData.t());
            } else {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.q.getLayoutParams();
                layoutParams3.bottomMargin = 0;
                layoutParams3.topMargin = 0;
                pbCommenFloorItemViewHolder.q.setLayoutParams(layoutParams3);
                pbCommenFloorItemViewHolder.p.setPadding(0, 0, 0, 0);
                pbCommenFloorItemViewHolder.p.k0(null);
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.p.getLayoutParams();
                layoutParams4.topMargin = 0;
                pbCommenFloorItemViewHolder.p.setLayoutParams(layoutParams4);
                pbCommenFloorItemViewHolder.r.setVisibility(8);
            }
            pbCommenFloorItemViewHolder.p.setTextViewOnTouchListener(this.A);
            pbCommenFloorItemViewHolder.p.setTextViewCheckSelection(false);
        }
    }

    public final void O(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || postData == null || (imageView = pbCommenFloorItemViewHolder.N) == null || this.l == null) {
            return;
        }
        imageView.setVisibility(8);
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
    public final void P(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        boolean z;
        boolean z2;
        int i2;
        int i3;
        vu7 vu7Var;
        vu7 vu7Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048586, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        String str = null;
        boolean z3 = true;
        if (postData.C() > 0 && (vu7Var2 = this.l) != null && !vu7Var2.i0()) {
            String format = String.format(this.mContext.getString(R.string.obfuscated_res_0x7f0f0994), Integer.valueOf(postData.C()));
            pbCommenFloorItemViewHolder.I.setVisibility(0);
            pbCommenFloorItemViewHolder.I.setText(format);
            z = true;
        } else {
            pbCommenFloorItemViewHolder.I.setVisibility(8);
            z = false;
        }
        if (postData.s() != null) {
            str = postData.s().getIpAddress();
            if (!TextUtils.isEmpty(str)) {
                z2 = true;
                w35 S = postData.S();
                z3 = (S != null || StringUtils.isNull(S.b()) || (vu7Var = this.l) == null || vu7Var.i0()) ? false : false;
                if (!z) {
                    pbCommenFloorItemViewHolder.k.setVisibility(0);
                    i2 = this.g;
                } else {
                    pbCommenFloorItemViewHolder.k.setVisibility(8);
                    i2 = 0;
                }
                if (z3 && !z2) {
                    pbCommenFloorItemViewHolder.l.setVisibility(8);
                    i3 = 0;
                } else {
                    pbCommenFloorItemViewHolder.l.setVisibility(0);
                    i3 = this.g;
                }
                pbCommenFloorItemViewHolder.j.setPadding(i2, 0, i3, 0);
                if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.f0()), "yyyy"))) {
                    pbCommenFloorItemViewHolder.j.setText(StringHelper.getFormatTimeShort(postData.f0()));
                } else {
                    pbCommenFloorItemViewHolder.j.setText(StringHelper.getFormatTime(postData.f0()));
                }
                if (!z2) {
                    pbCommenFloorItemViewHolder.m.setVisibility(0);
                    pbCommenFloorItemViewHolder.m.setPadding(this.g, 0, 0, 0);
                    TextView textView = pbCommenFloorItemViewHolder.m;
                    textView.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f150a) + str);
                } else if (z3) {
                    pbCommenFloorItemViewHolder.m.setVisibility(0);
                    pbCommenFloorItemViewHolder.m.setPadding(this.g, 0, 0, 0);
                    if (postData.Z) {
                        pbCommenFloorItemViewHolder.m.setText(StringHelper.cutStringWithSuffix(S.b(), 7, StringHelper.STRING_MORE));
                    } else {
                        pbCommenFloorItemViewHolder.m.setText(S.b());
                    }
                } else {
                    pbCommenFloorItemViewHolder.m.setVisibility(8);
                }
                TextView textView2 = pbCommenFloorItemViewHolder.i0;
                textView2.setText(((Object) pbCommenFloorItemViewHolder.j.getText()) + "  • ");
            }
        }
        z2 = false;
        w35 S2 = postData.S();
        if (S2 != null) {
        }
        if (!z) {
        }
        if (z3) {
        }
        pbCommenFloorItemViewHolder.l.setVisibility(0);
        i3 = this.g;
        pbCommenFloorItemViewHolder.j.setPadding(i2, 0, i3, 0);
        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.f0()), "yyyy"))) {
        }
        if (!z2) {
        }
        TextView textView22 = pbCommenFloorItemViewHolder.i0;
        textView22.setText(((Object) pbCommenFloorItemViewHolder.j.getText()) + "  • ");
    }

    public final void Q(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        pbCommenFloorItemViewHolder.a0.setVisibility(postData.Z ? 0 : 8);
    }

    public final void R(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048588, this, pbCommenFloorItemViewHolder, postData, view2, i2) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        pbCommenFloorItemViewHolder.z.setVisibility(8);
        pbCommenFloorItemViewHolder.t.setVisibility(0);
        pbCommenFloorItemViewHolder.h0.setVisibility(8);
        pbCommenFloorItemViewHolder.x.setVisibility(8);
        pbCommenFloorItemViewHolder.y.setVisibility(8);
        pbCommenFloorItemViewHolder.n.setVisibility(8);
        pbCommenFloorItemViewHolder.p0.setVisibility(8);
        a0(pbCommenFloorItemViewHolder, postData, view2, i2);
        b0(pbCommenFloorItemViewHolder, postData);
        O(pbCommenFloorItemViewHolder, postData);
        S(pbCommenFloorItemViewHolder, postData);
        V(pbCommenFloorItemViewHolder, postData, view2);
        U(pbCommenFloorItemViewHolder, postData, view2, i2);
        P(pbCommenFloorItemViewHolder, postData);
        X(pbCommenFloorItemViewHolder, postData);
        T(pbCommenFloorItemViewHolder, postData);
        Y(pbCommenFloorItemViewHolder, postData);
        N(pbCommenFloorItemViewHolder, postData);
        Q(pbCommenFloorItemViewHolder, postData);
        W(pbCommenFloorItemViewHolder, postData);
        Z(pbCommenFloorItemViewHolder, postData);
        jw7.h(pbCommenFloorItemViewHolder, view2, postData, this.t, true);
    }

    public final void S(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || postData == null || postData.q() == null) {
            return;
        }
        postData.q().threadId = this.a.K().m2();
        postData.q().objType = 1;
        postData.q().isInPost = true;
        ThreadData threadData = null;
        vu7 vu7Var = this.l;
        if (vu7Var != null && vu7Var.O() != null) {
            threadData = this.l.O();
        }
        if (threadData != null && threadData.isUgcThreadType()) {
            pbCommenFloorItemViewHolder.n.setAgreeAlone(true);
        }
        pbCommenFloorItemViewHolder.n.setThreadData(threadData);
        pbCommenFloorItemViewHolder.n.setData(postData.q());
        pbCommenFloorItemViewHolder.f0.setThreadData(threadData);
        pbCommenFloorItemViewHolder.f0.setData(postData.q());
    }

    public final void T(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        AlaLiveInfoCoreData alaLiveInfoCoreData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || pbCommenFloorItemViewHolder.T == null || pbCommenFloorItemViewHolder.Q == null) {
            return;
        }
        if (postData != null && (alaLiveInfoCoreData = postData.R) != null && !StringUtils.isNull(alaLiveInfoCoreData.liveTitle)) {
            pbCommenFloorItemViewHolder.T.setText(postData.R.liveTitle);
            pbCommenFloorItemViewHolder.Q.setTag(postData.R);
            pbCommenFloorItemViewHolder.Q.setVisibility(0);
            StatisticItem statisticItem = new StatisticItem("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(statisticItem);
            return;
        }
        pbCommenFloorItemViewHolder.Q.setVisibility(8);
    }

    public final void U(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048591, this, pbCommenFloorItemViewHolder, postData, view2, i2) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        if (postData.b0() > 0) {
            pbCommenFloorItemViewHolder.w.setVisibility(8);
        } else {
            SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.w.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                pbCommenFloorItemViewHolder.w.setTag(sparseArray);
            }
            sparseArray.put(R.id.obfuscated_res_0x7f092057, postData);
            if (postData.G() == 2) {
                pbCommenFloorItemViewHolder.w.setVisibility(8);
            } else {
                pbCommenFloorItemViewHolder.w.setVisibility(0);
            }
            pbCommenFloorItemViewHolder.v.setVisibility(8);
        }
        ImageView imageView = pbCommenFloorItemViewHolder.x;
        if (imageView != null) {
            SparseArray sparseArray2 = (SparseArray) imageView.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                pbCommenFloorItemViewHolder.x.setTag(sparseArray2);
            }
            sparseArray2.put(R.id.obfuscated_res_0x7f092057, postData);
        }
        ImageView imageView2 = pbCommenFloorItemViewHolder.y;
        if (imageView2 != null) {
            SparseArray sparseArray3 = (SparseArray) imageView2.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                pbCommenFloorItemViewHolder.y.setTag(sparseArray3);
            }
            sparseArray3.put(R.id.obfuscated_res_0x7f092057, postData);
        }
        pbCommenFloorItemViewHolder.v.setVisibility(8);
        boolean z = true;
        if (!postData.o0() && !postData.n0(true)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.u.getLayoutParams();
            layoutParams.topMargin = 0;
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            layoutParams.bottomMargin = 0;
            pbCommenFloorItemViewHolder.u.setLayoutParams(layoutParams);
            pbCommenFloorItemViewHolder.u.setVisibility(8);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.u.getLayoutParams();
            layoutParams2.topMargin = ej.f(this.mContext, R.dimen.tbds10);
            layoutParams2.leftMargin = ej.f(this.mContext, R.dimen.tbds148);
            layoutParams2.rightMargin = ej.f(this.mContext, R.dimen.M_W_X007);
            layoutParams2.bottomMargin = ej.f(this.mContext, R.dimen.tbds20);
            pbCommenFloorItemViewHolder.u.setLayoutParams(layoutParams2);
            if (this.r == null) {
                e18 e18Var = new e18(this.mContext);
                this.r = e18Var;
                e18Var.f(this.e);
                this.r.h(this.m);
                this.r.e(this.n);
                String str = null;
                vu7 vu7Var = this.l;
                if (vu7Var != null && vu7Var.O() != null && this.l.O().getAuthor() != null) {
                    str = this.l.O().getAuthor().getUserId();
                }
                z = (str == null || !str.equals(TbadkCoreApplication.getCurrentAccount())) ? false : false;
                vu7 vu7Var2 = this.l;
                if (vu7Var2 != null) {
                    this.r.j(vu7Var2.W(), z);
                    this.r.i(this.l.O());
                }
            }
            this.r.g(postData.L());
            pbCommenFloorItemViewHolder.u.setSubPbAdapter(this.r);
            pbCommenFloorItemViewHolder.u.setVisibility(0);
            pbCommenFloorItemViewHolder.u.setData(postData, view2);
            pbCommenFloorItemViewHolder.u.setChildOnClickListener(this.n);
            pbCommenFloorItemViewHolder.u.setChildOnLongClickListener(this.q);
            pbCommenFloorItemViewHolder.u.setChildOnTouchListener(this.A);
        }
        if (postData.N) {
            pbCommenFloorItemViewHolder.O.setVisibility(0);
        } else {
            pbCommenFloorItemViewHolder.O.setVisibility(4);
        }
        pbCommenFloorItemViewHolder.w.setVisibility(8);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.t.getLayoutParams();
        layoutParams3.topMargin = ej.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X001);
        layoutParams3.bottomMargin = ej.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X002);
        if (pbCommenFloorItemViewHolder.v.getVisibility() == 8) {
            pbCommenFloorItemViewHolder.t.setVisibility(8);
        } else {
            pbCommenFloorItemViewHolder.t.setVisibility(0);
        }
        pbCommenFloorItemViewHolder.j0.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ffd));
    }

    public final void V(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048592, this, pbCommenFloorItemViewHolder, postData, view2) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.q.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        layoutParams.rightMargin = ej.f(this.mContext, R.dimen.M_W_X007);
        layoutParams.leftMargin = ej.f(this.mContext, R.dimen.tbds148);
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = 0;
        pbCommenFloorItemViewHolder.p.setPadding(0, 0, 0, 0);
        if (!this.i) {
            pbCommenFloorItemViewHolder.p.getLayoutStrategy().g(R.drawable.icon_click);
        } else {
            pbCommenFloorItemViewHolder.p.k0(null);
            pbCommenFloorItemViewHolder.p.setBackgroundDrawable(null);
            pbCommenFloorItemViewHolder.p.getLayoutStrategy().g(R.drawable.obfuscated_res_0x7f08123c);
        }
        pbCommenFloorItemViewHolder.p.getLayoutStrategy().x(R.drawable.pic_video);
        H(pbCommenFloorItemViewHolder.p, view2, !StringUtils.isNull(postData.t()), layoutParams.leftMargin + layoutParams.rightMargin);
        pbCommenFloorItemViewHolder.q.setLayoutParams(layoutParams);
        pbCommenFloorItemViewHolder.p.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        pbCommenFloorItemViewHolder.p.setIsFromCDN(this.e);
        pbCommenFloorItemViewHolder.p.setText(postData.W(), true, this.h);
        SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.p.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        sparseArray.put(R.id.obfuscated_res_0x7f09203a, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f092053, Boolean.FALSE);
        pbCommenFloorItemViewHolder.p.setTag(sparseArray);
        pbCommenFloorItemViewHolder.r.setTag(sparseArray);
        pbCommenFloorItemViewHolder.b.setTag(R.id.obfuscated_res_0x7f09204d, sparseArray);
        pbCommenFloorItemViewHolder.p0.setTag(sparseArray);
        pbCommenFloorItemViewHolder.g0.setTag(sparseArray);
    }

    public final void W(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048593, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || pbCommenFloorItemViewHolder.b == null) {
            return;
        }
        f28 f28Var = this.a;
        if (f28Var != null && f28Var.K() != null && StringHelper.equals(this.a.K().t1(), postData.L())) {
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.b, R.color.CAM_X0313);
            return;
        }
        f28 f28Var2 = this.a;
        if (f28Var2 != null && f28Var2.K() != null && StringHelper.equals(this.a.K().s1(), postData.L())) {
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.b, R.color.CAM_X0313);
            gh.a().postDelayed(new f(this, pbCommenFloorItemViewHolder), 3000L);
            return;
        }
        SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.b, R.color.CAM_X0205);
    }

    public final void X(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, pbCommenFloorItemViewHolder, postData) == null) {
            if (postData != null && postData.c0() != null) {
                TbRichText W = postData.W();
                c38.c(postData.c0(), pbCommenFloorItemViewHolder.P, false, false, W != null && StringUtils.isNull(W.toString()) && StringUtils.isNull(postData.t()));
                return;
            }
            pbCommenFloorItemViewHolder.P.setVisibility(8);
        }
    }

    public final void Y(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, pbCommenFloorItemViewHolder, postData) == null) {
            if (postData.G() != 2 && postData.G() != 4) {
                pbCommenFloorItemViewHolder.W.setVisibility(8);
                pbCommenFloorItemViewHolder.V.setVisibility(0);
                K(false, pbCommenFloorItemViewHolder, postData);
            } else {
                pbCommenFloorItemViewHolder.W.setOnClickListener(new g(this, pbCommenFloorItemViewHolder, postData));
                pbCommenFloorItemViewHolder.W.setVisibility(0);
                I(pbCommenFloorItemViewHolder, postData.r0(), postData.F());
                K(true, pbCommenFloorItemViewHolder, postData);
            }
            i0(pbCommenFloorItemViewHolder, postData);
        }
    }

    public final void Z(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048596, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        pbCommenFloorItemViewHolder.f(postData.Q, postData.L(), this.x);
    }

    /* JADX WARN: Removed duplicated region for block: B:245:0x06a2  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x06ad  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x06b6  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x06f9  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0703  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0769  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0773  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x07b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view2, int i2) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048597, this, pbCommenFloorItemViewHolder, postData, view2, i2) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
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
        ThreadData threadData = null;
        pbCommenFloorItemViewHolder.o.setTag(null);
        pbCommenFloorItemViewHolder.o.setUserId(null);
        pbCommenFloorItemViewHolder.f.setText((CharSequence) null);
        pbCommenFloorItemViewHolder.K.getHeadView().setUserId(null);
        pbCommenFloorItemViewHolder.p.setIsHost(false);
        if (postData.s() != null) {
            String str = this.k;
            if (str != null && !"0".equals(str) && this.k.equals(postData.s().getUserId())) {
                pbCommenFloorItemViewHolder.p.setIsHost(true);
            }
            ArrayList<IconData> iconInfo = postData.s().getIconInfo();
            ArrayList<IconData> tShowInfoNew = postData.s().getTShowInfoNew();
            UserIconBox userIconBox = pbCommenFloorItemViewHolder.M;
            if (userIconBox != null) {
                userIconBox.setTag(R.id.obfuscated_res_0x7f09208f, postData.s().getUserId());
                f28 f28Var = this.a;
                if (f28Var != null && f28Var.P() != null) {
                    pbCommenFloorItemViewHolder.M.setOnClickListener(this.a.P().d.c);
                }
                int f2 = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                int f3 = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                UserIconBox userIconBox2 = pbCommenFloorItemViewHolder.M;
                i3 = R.id.obfuscated_res_0x7f09208f;
                userIconBox2.g(iconInfo, 2, f2, f2, f3);
            } else {
                i3 = R.id.obfuscated_res_0x7f09208f;
            }
            if (pbCommenFloorItemViewHolder.L != null) {
                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                    pbCommenFloorItemViewHolder.L.setTag(tShowInfoNew.get(0).getUrl());
                }
                f28 f28Var2 = this.a;
                if (f28Var2 != null && f28Var2.P() != null) {
                    pbCommenFloorItemViewHolder.L.setOnClickListener(this.a.P().d.e);
                }
                int f4 = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                pbCommenFloorItemViewHolder.L.h(tShowInfoNew, 3, f4, f4, ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
            }
            if (ListUtils.isEmpty(tShowInfoNew) && !postData.s().isBigV()) {
                if (UbsABTestHelper.isPBPlanA()) {
                    if (DeviceInfoUtil.isMate30()) {
                        xy7.m(pbCommenFloorItemViewHolder.f);
                    } else {
                        uu4.d(pbCommenFloorItemViewHolder.f).A(R.string.F_X02);
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
            pbCommenFloorItemViewHolder.f.setTag(i3, postData.s().getUserId());
            pbCommenFloorItemViewHolder.f.setTag(R.id.obfuscated_res_0x7f092097, postData.s().getUserName());
            pbCommenFloorItemViewHolder.f.setTag(R.id.obfuscated_res_0x7f092099, postData.s().getVirtualUserUrl());
            pbCommenFloorItemViewHolder.f.setTag(R.id.obfuscated_res_0x7f092085, v18.i(this.l, postData, postData.b0, i4, 2));
            String name_show = postData.s().getName_show();
            String userName = postData.s().getUserName();
            if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                pbCommenFloorItemViewHolder.f.setText(vt7.b(this.mContext, pbCommenFloorItemViewHolder.f.getText().toString()));
                pbCommenFloorItemViewHolder.f.setGravity(16);
                pbCommenFloorItemViewHolder.f.setTag(R.id.obfuscated_res_0x7f092064, vt7.a());
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f, R.color.CAM_X0312, 1);
            }
            if (postData.s().getPendantData() != null && !StringUtils.isNull(postData.s().getPendantData().getImgUrl())) {
                pbCommenFloorItemViewHolder.K.setBigVDimenSize(R.dimen.tbds36);
                pbCommenFloorItemViewHolder.K.j(postData.s(), 4);
                pbCommenFloorItemViewHolder.o.setVisibility(8);
                pbCommenFloorItemViewHolder.K.setVisibility(0);
                pbCommenFloorItemViewHolder.K.getHeadView().K(avater, 28, false);
                pbCommenFloorItemViewHolder.K.getHeadView().setUserId(postData.s().getUserId());
                pbCommenFloorItemViewHolder.K.getHeadView().setUserName(postData.s().getUserName());
                vu7 vu7Var = this.l;
                pbCommenFloorItemViewHolder.K.getHeadView().setFid(vu7Var != null ? vu7Var.m() : "");
                vu7 vu7Var2 = this.l;
                pbCommenFloorItemViewHolder.K.getHeadView().setFName(vu7Var2 != null ? vu7Var2.n() : "");
                pbCommenFloorItemViewHolder.K.getHeadView().setFloor(postData.C());
                pbCommenFloorItemViewHolder.K.getHeadView().setTid(postData.L());
                pbCommenFloorItemViewHolder.K.getHeadView().setTag(R.id.obfuscated_res_0x7f092085, v18.i(this.l, postData, postData.b0, i4, 2));
                pbCommenFloorItemViewHolder.K.m(postData.s().getPendantData().getImgUrl());
            } else {
                pbCommenFloorItemViewHolder.o.setGodIconWidth(R.dimen.tbds36);
                UtilHelper.showHeadImageViewBigV(pbCommenFloorItemViewHolder.o, postData.s(), 4);
                pbCommenFloorItemViewHolder.o.setUserId(postData.s().getUserId());
                vu7 vu7Var3 = this.l;
                pbCommenFloorItemViewHolder.o.setFid(vu7Var3 != null ? vu7Var3.m() : "");
                vu7 vu7Var4 = this.l;
                pbCommenFloorItemViewHolder.o.setFName(vu7Var4 != null ? vu7Var4.n() : "");
                pbCommenFloorItemViewHolder.o.setFloor(postData.C());
                pbCommenFloorItemViewHolder.o.setTid(postData.L());
                pbCommenFloorItemViewHolder.o.setUserName(postData.s().getUserName(), postData.h0());
                pbCommenFloorItemViewHolder.o.setTag(R.id.obfuscated_res_0x7f092099, postData.s().getVirtualUserUrl());
                pbCommenFloorItemViewHolder.o.setTag(R.id.obfuscated_res_0x7f092085, v18.i(this.l, postData, postData.b0, i4, 2));
                pbCommenFloorItemViewHolder.o.setImageDrawable(null);
                pbCommenFloorItemViewHolder.o.K(avater, 28, false);
                pbCommenFloorItemViewHolder.o.setVisibility(0);
                pbCommenFloorItemViewHolder.K.setVisibility(8);
            }
            if (postData.s() != null && postData.s().getAlaInfo() != null && postData.s().getAlaUserData() != null && postData.s().getAlaUserData().live_status == 1) {
                pbCommenFloorItemViewHolder.d(true);
                pbCommenFloorItemViewHolder.o.setLiveStatus(1);
                pbCommenFloorItemViewHolder.o.setAlaInfo(postData.s().getAlaInfo());
                pbCommenFloorItemViewHolder.K.getHeadView().setLiveStatus(1);
                pbCommenFloorItemViewHolder.K.getHeadView().setAlaInfo(postData.s().getAlaInfo());
                threadData = null;
            } else {
                pbCommenFloorItemViewHolder.d(false);
                pbCommenFloorItemViewHolder.o.setLiveStatus(0);
                threadData = null;
                pbCommenFloorItemViewHolder.o.setAlaInfo(null);
                pbCommenFloorItemViewHolder.K.getHeadView().setLiveStatus(0);
                pbCommenFloorItemViewHolder.K.getHeadView().setAlaInfo(null);
            }
            s0(pbCommenFloorItemViewHolder.h, postData);
        }
        f28 f28Var3 = this.a;
        int level_id = (f28Var3 == null || f28Var3.P() == null || !this.a.P().u0() || postData.s() == null) ? 0 : postData.s().getLevel_id();
        vu7 vu7Var5 = this.l;
        if (vu7Var5 != null && vu7Var5.i0()) {
            level_id = 0;
        }
        if (level_id > 0) {
            pbCommenFloorItemViewHolder.J.setVisibility(0);
            SkinManager.setImageResource(pbCommenFloorItemViewHolder.J, BitmapHelper.getGradeResourceIdInEnterForum(level_id));
        } else {
            pbCommenFloorItemViewHolder.J.setVisibility(8);
        }
        int i5 = 15;
        if (pbCommenFloorItemViewHolder.M.getChildCount() == 1) {
            i5 = 13;
        } else if (pbCommenFloorItemViewHolder.M.getChildCount() > 1) {
            i5 = 11;
        }
        if (pbCommenFloorItemViewHolder.h.getVisibility() == 0) {
            i5 -= 2;
        }
        if (pbCommenFloorItemViewHolder.L.getChildCount() > 0) {
            i5 -= 2;
        }
        if (postData.x() > 1000) {
            i5 -= 2;
        }
        if (postData.x() > 10) {
            i5 -= 2;
        }
        if (i5 < 10) {
            pbCommenFloorItemViewHolder.M.setVisibility(8);
            if (pbCommenFloorItemViewHolder.M.getChildCount() == 1) {
                i5 += 2;
            } else if (pbCommenFloorItemViewHolder.M.getChildCount() > 1) {
                i5 += 4;
            }
            if (i5 < 10 && pbCommenFloorItemViewHolder.h.getVisibility() == 0) {
                i5 += 2;
                pbCommenFloorItemViewHolder.h.setVisibility(8);
            }
            if (i5 < 10 && pbCommenFloorItemViewHolder.J.getVisibility() == 0) {
                i5 += 2;
                pbCommenFloorItemViewHolder.J.setVisibility(8);
            }
        }
        String name_show2 = postData.s() != null ? postData.s().getName_show() : "";
        int d2 = wh5.d(name_show2);
        if (postData.s() != null && !StringUtils.isNull(postData.s().getSealPrefix())) {
            int i6 = i5 - 2;
            if (d2 > i6) {
                name_show2 = wh5.n(name_show2, i6) + StringHelper.STRING_MORE;
            }
        } else if (d2 > i5) {
            name_show2 = wh5.n(name_show2, i5) + StringHelper.STRING_MORE;
        }
        if (postData.s() != null && !StringUtils.isNull(postData.s().getSealPrefix())) {
            pbCommenFloorItemViewHolder.f.setText(d0(postData.s().getSealPrefix(), name_show2));
        } else {
            pbCommenFloorItemViewHolder.f.setText(name_show2);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.obfuscated_res_0x7f09203a, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f092057, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f092059, view2);
        sparseArray.put(R.id.obfuscated_res_0x7f092068, Integer.valueOf(i2));
        sparseArray.put(R.id.obfuscated_res_0x7f092067, Integer.valueOf(postData.C()));
        sparseArray.put(R.id.obfuscated_res_0x7f09204a, postData.L());
        sparseArray.put(R.id.obfuscated_res_0x7f0917ef, pbCommenFloorItemViewHolder.n);
        sparseArray.put(R.id.obfuscated_res_0x7f0917f0, pbCommenFloorItemViewHolder.f0);
        sparseArray.put(R.id.obfuscated_res_0x7f0917ed, pbCommenFloorItemViewHolder.x);
        sparseArray.put(R.id.obfuscated_res_0x7f0917ee, pbCommenFloorItemViewHolder.y);
        vu7 vu7Var6 = this.l;
        if (vu7Var6 != null && vu7Var6.O() != null) {
            threadData = this.l.O();
        }
        if (threadData != null && threadData.isUgcThreadType()) {
            sparseArray.put(R.id.obfuscated_res_0x7f0917ec, Boolean.TRUE);
        } else {
            sparseArray.put(R.id.obfuscated_res_0x7f0917ec, Boolean.FALSE);
        }
        boolean z8 = (postData.s() == null || StringUtils.isNull(postData.s().getVirtualUserUrl())) ? false : true;
        vu7 vu7Var7 = this.l;
        if (vu7Var7 == null || vu7Var7.W() == 0 || f0()) {
            z = false;
            z2 = false;
            z3 = false;
        } else {
            z = (this.l.W() == 1002 || this.l.W() == 3) ? false : true;
            if (this.l.W() == 3 || this.l.i0()) {
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
                if (userId == null || "0".equals(userId) || userId.length() == 0) {
                    z = false;
                }
            }
        }
        vu7 vu7Var8 = this.l;
        if (vu7Var8 != null && vu7Var8.O() != null && this.l.O().getAuthor() != null && postData.s() != null) {
            String userId2 = this.l.O().getAuthor().getUserId();
            String userId3 = postData.s().getUserId();
            if (UtilHelper.isCurrentAccount(userId2)) {
                if (UtilHelper.isCurrentAccount(userId3)) {
                    z5 = false;
                    z6 = true;
                } else {
                    z5 = true;
                    z6 = false;
                }
                z4 = true;
                z7 = true;
                if (postData != null && postData.s() != null && UtilHelper.isCurrentAccount(postData.s().getUserId())) {
                    z6 = true;
                    z4 = true;
                }
                if (z8) {
                    z = false;
                    z5 = false;
                    z4 = false;
                }
                int i7 = postData.C() != 1 ? 1 : 0;
                if (!z) {
                    sparseArray.put(R.id.obfuscated_res_0x7f092082, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f09205a, Integer.valueOf(this.l.W()));
                    if (postData.s() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f092047, postData.s().getUserName());
                        sparseArray.put(R.id.obfuscated_res_0x7f092048, postData.s().getName_show());
                        sparseArray.put(R.id.obfuscated_res_0x7f092049, postData.s().getPortrait());
                    }
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f092082, Boolean.FALSE);
                }
                if (!z5) {
                    sparseArray.put(R.id.obfuscated_res_0x7f092096, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f092051, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.s() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f092092, postData.s().getUserId());
                        sparseArray.put(R.id.obfuscated_res_0x7f092093, postData.s().getUserName());
                        sparseArray.put(R.id.obfuscated_res_0x7f092091, postData.s().getName_show());
                    }
                    if (this.l.O() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f092095, this.l.O().getId());
                    }
                    sparseArray.put(R.id.obfuscated_res_0x7f092094, postData.L());
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f092096, Boolean.FALSE);
                }
                if (!z4) {
                    sparseArray.put(R.id.obfuscated_res_0x7f092080, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f09204e, Boolean.valueOf(postData.o0()));
                    sparseArray.put(R.id.obfuscated_res_0x7f09205a, Integer.valueOf(this.l.W()));
                    sparseArray.put(R.id.obfuscated_res_0x7f09203d, Boolean.valueOf(z6));
                    sparseArray.put(R.id.obfuscated_res_0x7f09203e, Integer.valueOf(i7));
                    sparseArray.put(R.id.obfuscated_res_0x7f09203c, postData.L());
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f092080, Boolean.FALSE);
                }
                sparseArray.put(R.id.obfuscated_res_0x7f09205b, Boolean.valueOf(z2));
                sparseArray.put(R.id.obfuscated_res_0x7f092052, Boolean.valueOf(z7));
                pbCommenFloorItemViewHolder.p.setTag(sparseArray);
                pbCommenFloorItemViewHolder.r.setTag(sparseArray);
            }
        }
        z4 = z3;
        z5 = false;
        z6 = false;
        z7 = false;
        if (postData != null) {
            z6 = true;
            z4 = true;
        }
        if (z8) {
        }
        if (postData.C() != 1) {
        }
        if (!z) {
        }
        if (!z5) {
        }
        if (!z4) {
        }
        sparseArray.put(R.id.obfuscated_res_0x7f09205b, Boolean.valueOf(z2));
        sparseArray.put(R.id.obfuscated_res_0x7f092052, Boolean.valueOf(z7));
        pbCommenFloorItemViewHolder.p.setTag(sparseArray);
        pbCommenFloorItemViewHolder.r.setTag(sparseArray);
    }

    public final void b0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048598, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || postData == null || !TbSingleton.getInstance().isUserGrowthOpen() || postData.s().getUserGrowthData() == null) {
            return;
        }
        int a2 = postData.s().getUserGrowthData().a();
        if (a2 >= 0 && a2 <= 10) {
            pbCommenFloorItemViewHolder.i.K(String.valueOf(kx.b(a2)), 24, false);
            pbCommenFloorItemViewHolder.i.setVisibility(0);
            pbCommenFloorItemViewHolder.i.setOnClickListener(new h(this, a2));
            CommonStatisticUtils.staticNameplateOfUserLevel(1, 7, a2);
            return;
        }
        pbCommenFloorItemViewHolder.i.setVisibility(8);
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.i = z;
        }
    }

    public int c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.s : invokeV.intValue;
    }

    public void d(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, onLongClickListener) == null) {
            this.q = onLongClickListener;
        }
    }

    public final SpannableStringBuilder d0(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048602, this, str, str2)) == null) {
            ArrayList arrayList = new ArrayList();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (str2 == null || str == null) {
                return spannableStringBuilder;
            }
            arrayList.add(new g16.a(str, R.drawable.pic_smalldot_title));
            return g16.h(this.a.P(), str2, arrayList, true);
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, onClickListener) == null) {
            this.n = onClickListener;
        }
    }

    public final String e0(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, view2)) == null) {
            SparseArray sparseArray = (SparseArray) view2.getTag();
            if (sparseArray == null) {
                return "1";
            }
            Object obj = sparseArray.get(R.id.obfuscated_res_0x7f09188a);
            String str = obj != null ? obj : "1";
            sparseArray.remove(R.id.obfuscated_res_0x7f09188a);
            view2.setTag(sparseArray);
            return str.toString();
        }
        return (String) invokeL.objValue;
    }

    public final boolean f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            vu7 vu7Var = this.l;
            if (vu7Var == null || vu7Var.O() == null) {
                return false;
            }
            return this.l.O().isBlocked();
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: g0 */
    public PbCommenFloorItemViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d06e3, viewGroup, false);
            ((ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f09186c)).addView(LayoutInflater.from(inflate.getContext()).inflate(R.layout.obfuscated_res_0x7f0d06db, (ViewGroup) null));
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = new PbCommenFloorItemViewHolder(this.a.P().getPageContext(), inflate, this.v);
            pbCommenFloorItemViewHolder.s.setConstrainLayoutPool(this.y);
            pbCommenFloorItemViewHolder.s.setImageViewPool(this.z);
            SubPbLayout subPbLayout = pbCommenFloorItemViewHolder.u;
            if (subPbLayout != null) {
                subPbLayout.setShowChildComment(this.w);
                pbCommenFloorItemViewHolder.u.setIsVideoThread(true);
            }
            q0(pbCommenFloorItemViewHolder);
            TbRichTextView tbRichTextView = pbCommenFloorItemViewHolder.p;
            if (tbRichTextView != null) {
                tbRichTextView.setDuiEnabled(this.u);
            }
            return pbCommenFloorItemViewHolder;
        }
        return (PbCommenFloorItemViewHolder) invokeL.objValue;
    }

    public View h0(int i2, View view2, ViewGroup viewGroup, PostData postData, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048607, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, postData, pbCommenFloorItemViewHolder})) == null) {
            super.onFillViewHolder(i2, view2, viewGroup, postData, pbCommenFloorItemViewHolder);
            q0(pbCommenFloorItemViewHolder);
            l0(pbCommenFloorItemViewHolder);
            E(pbCommenFloorItemViewHolder);
            PostData postData2 = (PostData) getItem(i2);
            if (postData2 != null) {
                postData2.b0 = i2 + 1;
                G(postData2);
                F(postData2);
                postData2.i1();
                M(postData2);
                R(pbCommenFloorItemViewHolder, postData2, view2, i2);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void i0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048608, this, pbCommenFloorItemViewHolder, postData) == null) {
            TbRichText W = postData.W();
            W.isChanged = true;
            pbCommenFloorItemViewHolder.p.setText(W, true, this.h);
        }
    }

    public final void j0(PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, postData) == null) {
            String userId = postData.s().getUserId();
            vu7 vu7Var = this.l;
            String m = vu7Var != null ? vu7Var.m() : "";
            vu7 vu7Var2 = this.l;
            String n = vu7Var2 != null ? vu7Var2.n() : "";
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

    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, onClickListener) == null) {
            this.m = onClickListener;
        }
    }

    public void k0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i2) == null) {
            this.s = i2;
        }
    }

    public final void l0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.b.setOnTouchListener(this.A);
            pbCommenFloorItemViewHolder.b.setOnLongClickListener(this.q);
            if (this.a.P() == null || this.a.P().getPageContext() == null || this.a.P().getPageContext().getOrignalPage() == null) {
                return;
            }
            c08 c08Var = this.a.P().d;
            pbCommenFloorItemViewHolder.f.setOnClickListener(c08Var.b);
            pbCommenFloorItemViewHolder.o.setOnClickListener(c08Var.b);
            pbCommenFloorItemViewHolder.K.setOnClickListener(c08Var.b);
            pbCommenFloorItemViewHolder.K.getHeadView().setOnClickListener(c08Var.b);
            pbCommenFloorItemViewHolder.p.setOnLongClickListener(this.q);
            pbCommenFloorItemViewHolder.p.setOnTouchListener(this.A);
            pbCommenFloorItemViewHolder.p.setCommonTextViewOnClickListener(this.n);
            pbCommenFloorItemViewHolder.p.setOnImageClickListener(this.o);
            pbCommenFloorItemViewHolder.p.setOnImageTouchListener(this.A);
            pbCommenFloorItemViewHolder.p.setOnEmotionClickListener(c08Var.f);
            pbCommenFloorItemViewHolder.p.setOnVoiceAfterClickListener(this.n);
            pbCommenFloorItemViewHolder.P.setOnClickListener(this.n);
            pbCommenFloorItemViewHolder.Q.setOnClickListener(this.n);
            pbCommenFloorItemViewHolder.v.setOnClickListener(this.n);
            pbCommenFloorItemViewHolder.w.setOnClickListener(this.n);
            pbCommenFloorItemViewHolder.k0.setOnClickListener(this.n);
            pbCommenFloorItemViewHolder.o0.setOnClickListener(this.n);
            pbCommenFloorItemViewHolder.g0.setOnClickListener(this.n);
            pbCommenFloorItemViewHolder.p0.setOnClickListener(this.n);
            pbCommenFloorItemViewHolder.h0.setOnClickListener(new i(this, pbCommenFloorItemViewHolder));
            e08 e08Var = this.a.P().e;
            pbCommenFloorItemViewHolder.x.setOnClickListener(this.n);
            pbCommenFloorItemViewHolder.y.setOnClickListener(new j(this, pbCommenFloorItemViewHolder, e08Var));
            pbCommenFloorItemViewHolder.n.x = new k(this, pbCommenFloorItemViewHolder);
            pbCommenFloorItemViewHolder.f0.x = new a(this, pbCommenFloorItemViewHolder);
        }
    }

    public void m0(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048613, this, f2) == null) {
            this.j = f2;
        }
    }

    public void n(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, yVar) == null) {
            this.o = yVar;
        }
    }

    public void n0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            this.t = z;
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, str) == null) {
            this.k = str;
        }
    }

    public void o0(xv7 xv7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, xv7Var) == null) {
            this.p = xv7Var;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, view2) == null) {
        }
    }

    @Override // com.baidu.tieba.mx7, com.baidu.tieba.qn
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i2, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        h0(i2, view2, viewGroup, (PostData) obj, (PbCommenFloorItemViewHolder) viewHolder);
        return view2;
    }

    public void p0(TbRichTextView.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, sVar) == null) {
            this.h = sVar;
        }
    }

    public final void q0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048622, this, pbCommenFloorItemViewHolder) == null) || pbCommenFloorItemViewHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (pbCommenFloorItemViewHolder.a != skinType) {
            r0(pbCommenFloorItemViewHolder.h);
            if (UbsABTestHelper.isPBPlanA()) {
                if (DeviceInfoUtil.isMate30()) {
                    xy7.m(pbCommenFloorItemViewHolder.f);
                } else {
                    uu4.d(pbCommenFloorItemViewHolder.f).A(R.string.F_X02);
                }
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f, R.color.CAM_X0108, 1);
            } else {
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f, R.color.CAM_X0109, 1);
            }
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.j, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.k, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.l, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.I, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.m, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.w, (int) R.color.CAM_X0108);
            pbCommenFloorItemViewHolder.p.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            if (pbCommenFloorItemViewHolder.r.getVisibility() == 0) {
                pbCommenFloorItemViewHolder.r.g(skinType);
            }
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.i0, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.j0, R.color.CAM_X0107, 1);
            SkinManager.setBackgroundShapeDrawable(pbCommenFloorItemViewHolder.u, ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds21), R.color.CAM_X0206, R.color.CAM_X0206);
            SkinManager.getColor(R.color.CAM_X0107);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.v, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.v, (int) R.color.CAM_X0304);
            pbCommenFloorItemViewHolder.v.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right, SkinManager.getColor(R.color.CAM_X0304), null), (Drawable) null);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.x, R.drawable.obfuscated_res_0x7f0809a7, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.y, R.drawable.obfuscated_res_0x7f0809a8, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbCommenFloorItemViewHolder.u.d();
            pbCommenFloorItemViewHolder.s.b();
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.T, R.color.CAM_X0304, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.R, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.Q, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.S, R.color.CAM_X0109);
            SkinManager.setImageResource(pbCommenFloorItemViewHolder.U, R.drawable.icon_arrow_more_gray);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.X, (int) R.color.CAM_X0107);
            if (pbCommenFloorItemViewHolder.V.getVisibility() == 8) {
                pbCommenFloorItemViewHolder.X.setText(R.string.obfuscated_res_0x7f0f03fb);
            } else {
                vu7 vu7Var = this.l;
                if (vu7Var != null && StringUtils.isNull(vu7Var.k())) {
                    pbCommenFloorItemViewHolder.X.setText(this.l.k());
                } else {
                    pbCommenFloorItemViewHolder.X.setText(R.string.obfuscated_res_0x7f0f05e6);
                }
            }
            pbCommenFloorItemViewHolder.n.L(TbadkCoreApplication.getInst().getSkinType());
            pbCommenFloorItemViewHolder.c(skinType);
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.O, R.color.CAM_X0203);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.g0, R.drawable.obfuscated_res_0x7f080982, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.p0, R.drawable.obfuscated_res_0x7f080982, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbCommenFloorItemViewHolder.b();
        }
        pbCommenFloorItemViewHolder.a = skinType;
    }

    public void r(vu7 vu7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, vu7Var) == null) {
            this.l = vu7Var;
        }
    }

    public final void r0(TextView textView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048624, this, textView) == null) || textView == null) {
            return;
        }
        Object tag = textView.getTag();
        if (tag instanceof PostData) {
            s0(textView, (PostData) tag);
        }
    }

    public final void s0(TextView textView, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048625, this, textView, postData) == null) {
            if (textView == null && postData == null) {
                return;
            }
            textView.setTag(postData);
            vu7 vu7Var = this.l;
            if (vu7Var != null && vu7Var.i0()) {
                textView.setVisibility(8);
                textView.setTag(null);
            } else if (postData.s() != null) {
                MetaData s = postData.s();
                String str = this.k;
                if (str != null && !"0".equals(str) && this.k.equals(s.getUserId())) {
                    textView.setVisibility(0);
                    textView.setAlpha(1.0f);
                    textView.setText(R.string.obfuscated_res_0x7f0f087d);
                    textView.setBackgroundColor(0);
                    uu4 d2 = uu4.d(textView);
                    d2.n(R.string.J_X04);
                    d2.l(R.dimen.L_X01);
                    d2.v(R.color.CAM_X0302);
                    d2.k(R.color.CAM_X0302);
                } else if (s.getIs_bawu() == 1 && postData.p0()) {
                    uu4 d3 = uu4.d(textView);
                    d3.v(R.color.CAM_X0101);
                    d3.n(R.string.J_X04);
                    d3.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f0346);
                } else if (s.getIs_bawu() == 1 && "manager".equals(s.getBawu_type())) {
                    uu4 d4 = uu4.d(textView);
                    d4.v(R.color.CAM_X0101);
                    d4.n(R.string.J_X04);
                    d4.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f02ff);
                } else if (s.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(s.getBawu_type())) {
                    uu4 d5 = uu4.d(textView);
                    d5.v(R.color.CAM_X0101);
                    d5.n(R.string.J_X04);
                    d5.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f0300);
                } else if (s.getIs_bawu() == 1 && "pri_content_assist".equals(s.getBawu_type())) {
                    uu4 d6 = uu4.d(textView);
                    d6.v(R.color.CAM_X0101);
                    d6.n(R.string.J_X04);
                    d6.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f02fc);
                } else if (s.getIs_bawu() == 1 && "pri_manage_assist".equals(s.getBawu_type())) {
                    uu4 d7 = uu4.d(textView);
                    d7.v(R.color.CAM_X0101);
                    d7.n(R.string.J_X04);
                    d7.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f02fd);
                } else {
                    textView.setVisibility(8);
                }
            } else {
                textView.setVisibility(8);
            }
        }
    }
}

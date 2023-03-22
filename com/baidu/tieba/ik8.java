package com.baidu.tieba;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.mj8;
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.tieba.pb.pb.main.PbFloorComplaint;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.vn8;
import com.baidu.tieba.xe6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class ik8 extends tm<bc9, PbCommenFloorItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public TbPageContext b;
    public View.OnClickListener c;
    public View.OnClickListener d;
    public TbRichTextView.a0 e;
    public mj8 f;
    public View.OnLongClickListener g;
    public String h;
    public ki8 i;
    public boolean j;
    public SparseIntArray k;
    public vo8 l;
    public tn8 m;
    public vn8 n;
    public TbRichTextView.u o;
    public boolean p;
    public xf<ConstrainImageLayout> q;
    public xf<TbImageView> r;
    public mj8 s;

    /* loaded from: classes4.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ ik8 b;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ bc9 a;
            public final /* synthetic */ i b;

            public a(i iVar, bc9 bc9Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar, bc9Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = iVar;
                this.a = bc9Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    vn8.b bVar = this.b.b.n.b;
                    i iVar = this.b;
                    bVar.a(iVar.b.i, null, this.a, iVar.a.q.getLayoutStrategy());
                }
            }
        }

        public i(ik8 ik8Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ik8Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ik8Var;
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
            if ((sparseArray.get(R.id.tag_load_sub_data) instanceof bc9) && (bc9Var = (bc9) sparseArray.get(R.id.tag_load_sub_data)) != null && this.a.c != null && this.b.n != null) {
                jg.a().postDelayed(new a(this, bc9Var), 100L);
                String S = this.b.i.S();
                if ((StringUtils.isNull(S) || "0".equals(this.b.i.S())) && this.b.i.Q() != null) {
                    S = this.b.i.Q().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", S).param("fid", this.b.i.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", bc9Var.O()).param("obj_source", this.b.Z(view2)).param("obj_type", 4));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ bc9 b;
        public final /* synthetic */ ik8 c;

        public a(ik8 ik8Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, bc9 bc9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ik8Var, pbCommenFloorItemViewHolder, bc9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ik8Var;
            this.a = pbCommenFloorItemViewHolder;
            this.b = bc9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.Y.getVisibility() == 8) {
                    z = true;
                } else {
                    z = false;
                }
                this.c.F(this.a, !z, this.b.I());
                this.b.R0(!z);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ String b;

        public b(ik8 ik8Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ik8Var, pbCommenFloorItemViewHolder, str};
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
                String str = this.b;
                PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = this.a;
                mm8.b(measuredWidth, str, pbCommenFloorItemViewHolder.g, pbCommenFloorItemViewHolder.i, pbCommenFloorItemViewHolder.K, pbCommenFloorItemViewHolder.N, pbCommenFloorItemViewHolder.M);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ bc9 b;
        public final /* synthetic */ ik8 c;

        public c(ik8 ik8Var, String str, bc9 bc9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ik8Var, str, bc9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ik8Var;
            this.a = str;
            this.b = bc9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a != null) {
                    TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.c.b.getPageActivity(), "", this.a, true);
                    tbWebViewActivityConfig.setFixTitle(true);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
                }
                if (this.c.i != null) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_FLOOR_COMPLAINT_CLICK);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("fid", this.c.i.m());
                    statisticItem.param("fname", this.c.i.n());
                    statisticItem.param("tid", this.c.i.S());
                    statisticItem.param("pid", this.b.O());
                    statisticItem.param("obj_type", this.b.G());
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements yf<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ik8 a;

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

        public d(ik8 ik8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ik8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ik8Var;
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
                return new ConstrainImageLayout(this.a.mContext);
            }
            return (ConstrainImageLayout) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class e implements yf<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ik8 a;

        public TbImageView e(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbImageView)) == null) ? tbImageView : (TbImageView) invokeL.objValue;
        }

        public e(ik8 ik8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ik8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ik8Var;
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
                TbImageView tbImageView = new TbImageView(this.a.mContext);
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(SkinManager.getColor(R.color.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070198));
                return tbImageView;
            }
            return (TbImageView) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class f implements mj8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ik8 a;

        @Override // com.baidu.tieba.mj8.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        public f(ik8 ik8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ik8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ik8Var;
        }

        @Override // com.baidu.tieba.mj8.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (this.a.f != null) {
                    if ((view2 instanceof TbListTextView) && this.a.d != null) {
                        this.a.d.onClick(view2);
                        return true;
                    }
                    this.a.f.a(view2);
                    this.a.f.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.mj8.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                if (view2 == null || view2.getId() == R.id.obfuscated_res_0x7f090b04) {
                    return true;
                }
                if (view2 instanceof RelativeLayout) {
                    this.a.H(view2);
                } else {
                    ViewParent parent = view2.getParent();
                    int i = 0;
                    while (true) {
                        if (parent == null || i >= 10) {
                            break;
                        } else if (parent instanceof RelativeLayout) {
                            this.a.H((RelativeLayout) parent);
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
        public final /* synthetic */ PbCommenFloorItemViewHolder a;

        public g(ik8 ik8Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ik8Var, pbCommenFloorItemViewHolder};
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

    /* loaded from: classes4.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ ik8 b;

        public h(ik8 ik8Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ik8Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ik8Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.b.i != null && (pbCommenFloorItemViewHolder = this.a) != null && (agreeView = pbCommenFloorItemViewHolder.j0) != null && agreeView.getData() != null) {
                this.a.j0.getImgAgree();
                String S = this.b.i.S();
                if ((StringUtils.isNull(S) || "0".equals(this.b.i.S())) && this.b.i.Q() != null) {
                    S = this.b.i.Q().getNid();
                }
                TiebaStatic.log(new StatisticItem("c14442").param("tid", S).param("fname", this.b.i.n()).param("fid", this.b.i.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.j0.getData().postId));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ ik8 b;

        public j(ik8 ik8Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ik8Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ik8Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.b.i != null && (pbCommenFloorItemViewHolder = this.a) != null && (agreeView = pbCommenFloorItemViewHolder.o) != null && agreeView.getData() != null) {
                if (view2 == this.a.o.getImgAgree()) {
                    i = 1;
                } else {
                    i = 2;
                }
                String S = this.b.i.S();
                if ((StringUtils.isNull(S) || "0".equals(this.b.i.S())) && this.b.i.Q() != null) {
                    S = this.b.i.Q().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", S).param("fid", this.b.i.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.o.getData().postId).param("obj_source", this.b.Z(this.a.o)).param("obj_type", i));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ ik8 b;

        public k(ik8 ik8Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ik8Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ik8Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.b.i != null && (pbCommenFloorItemViewHolder = this.a) != null && (agreeView = pbCommenFloorItemViewHolder.j0) != null && agreeView.getData() != null) {
                if (view2 == this.a.j0.getImgAgree()) {
                    i = 1;
                } else {
                    i = 2;
                }
                String S = this.b.i.S();
                if ((StringUtils.isNull(S) || "0".equals(this.b.i.S())) && this.b.i.Q() != null) {
                    S = this.b.i.Q().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", S).param("fid", this.b.i.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.j0.getData().postId).param("obj_source", this.b.Z(this.a.j0)).param("obj_type", i));
                TiebaStatic.log(new StatisticItem("c14440").param("tid", S).param("fname", this.b.i.n()).param("fid", this.b.i.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.j0.getData().postId));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ik8 a;

        public l(ik8 ik8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ik8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ik8Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (this.a.f != null) {
                    this.a.f.a(view2);
                    return this.a.f.onSingleTapConfirmed(motionEvent);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ik8(Context context, BdUniqueId bdUniqueId, TbPageContext tbPageContext) {
        super(context, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId, tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = false;
        this.k = new SparseIntArray();
        this.l = null;
        this.q = new xf<>(new d(this), 6, 0);
        this.r = new xf<>(new e(this), 12, 0);
        this.s = new mj8(new f(this));
        this.b = tbPageContext;
        this.a = X(R.dimen.tbds14);
    }

    public final void J(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, bc9 bc9Var) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, pbCommenFloorItemViewHolder, bc9Var) == null) && pbCommenFloorItemViewHolder != null && bc9Var != null && (imageView = pbCommenFloorItemViewHolder.O) != null && this.i != null) {
            imageView.setVisibility(8);
        }
    }

    public final void M(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, bc9 bc9Var) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pbCommenFloorItemViewHolder, bc9Var) == null) && pbCommenFloorItemViewHolder != null && bc9Var != null) {
            ImageView imageView = pbCommenFloorItemViewHolder.d0;
            if (bc9Var.b0) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            imageView.setVisibility(i2);
        }
    }

    public final void S(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, bc9 bc9Var) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, pbCommenFloorItemViewHolder, bc9Var) == null) && pbCommenFloorItemViewHolder != null && (view2 = pbCommenFloorItemViewHolder.c) != null) {
            SkinManager.setBackgroundColor(view2, R.color.CAM_X0205);
        }
    }

    public final void V(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, bc9 bc9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048593, this, pbCommenFloorItemViewHolder, bc9Var) == null) && pbCommenFloorItemViewHolder != null && bc9Var != null) {
            pbCommenFloorItemViewHolder.h(bc9Var.S, bc9Var.O(), false);
        }
    }

    public final void D(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.q.setTextViewOnTouchListener(this.f);
            pbCommenFloorItemViewHolder.q.setTextViewCheckSelection(false);
            pbCommenFloorItemViewHolder.s.setOnTouchListener(new l(this));
        }
    }

    public int X(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
            int i3 = this.k.get(i2, -1);
            if (i3 != -1) {
                return i3;
            }
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i2);
            this.k.put(i2, dimensionPixelSize);
            return dimensionPixelSize;
        }
        return invokeI.intValue;
    }

    public void d(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, onLongClickListener) == null) {
            this.g = onLongClickListener;
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, onClickListener) == null) {
            this.d = onClickListener;
        }
    }

    public void e0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.p = z;
        }
    }

    public void f0(tn8 tn8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, tn8Var) == null) {
            this.m = tn8Var;
        }
    }

    public void g0(vn8 vn8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, vn8Var) == null) {
            this.n = vn8Var;
        }
    }

    public void h0(mj8 mj8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, mj8Var) == null) {
            this.f = mj8Var;
        }
    }

    public void i0(TbRichTextView.u uVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, uVar) == null) {
            this.o = uVar;
        }
    }

    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, onClickListener) == null) {
            this.c = onClickListener;
        }
    }

    public final void k0(TextView textView) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048611, this, textView) != null) || textView == null) {
            return;
        }
        Object tag = textView.getTag();
        if (!(tag instanceof bc9)) {
            return;
        }
        l0(textView, (bc9) tag);
    }

    public void n(TbRichTextView.a0 a0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, a0Var) == null) {
            this.e = a0Var;
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, str) == null) {
            this.h = str;
        }
    }

    public void r(ki8 ki8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, ki8Var) == null) {
            this.i = ki8Var;
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            this.j = z;
        }
    }

    public final void E(TbRichTextView tbRichTextView, View view2, boolean z, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{tbRichTextView, view2, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) && tbRichTextView != null && view2 != null) {
            int m = ((((hi.m(TbadkCoreApplication.getInst(), UtilHelper.isFoldScreen()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight()) - i2;
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                m = (m - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            if (z) {
                i3 = X(R.dimen.tbds115);
            } else {
                i3 = 0;
            }
            tbRichTextView.getLayoutStrategy().J = (m - i3) - X(R.dimen.tbds122);
            if (UtilHelper.isOppoFoldLargeScreen(TbadkCoreApplication.getInst().getContext())) {
                m /= 2;
            }
            tbRichTextView.getLayoutStrategy().r((int) ((m - i3) * 1.0f));
            tbRichTextView.getLayoutStrategy().q((int) (m * 1.618f * 1.0f));
        }
    }

    public final void F(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{pbCommenFloorItemViewHolder, Boolean.valueOf(z), str}) == null) {
            if (z) {
                pbCommenFloorItemViewHolder.Y.setVisibility(8);
                if (StringUtils.isNull(str)) {
                    pbCommenFloorItemViewHolder.a0.setText(R.string.obfuscated_res_0x7f0f0634);
                    return;
                } else {
                    pbCommenFloorItemViewHolder.a0.setText(str);
                    return;
                }
            }
            pbCommenFloorItemViewHolder.Y.setVisibility(0);
            pbCommenFloorItemViewHolder.a0.setText(R.string.obfuscated_res_0x7f0f0425);
        }
    }

    public final void G(boolean z, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, bc9 bc9Var) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), pbCommenFloorItemViewHolder, bc9Var}) == null) && pbCommenFloorItemViewHolder != null && (view2 = pbCommenFloorItemViewHolder.P) != null && pbCommenFloorItemViewHolder.Z != null && (view2.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (pbCommenFloorItemViewHolder.Z.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = !ListUtils.isEmpty(bc9Var.d0());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.P.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.Z.getLayoutParams();
            if (z) {
                pbCommenFloorItemViewHolder.q.getLayoutStrategy().n(0);
                if (z2) {
                    pbCommenFloorItemViewHolder.q.getLayoutStrategy().m(hi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = hi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                    }
                } else {
                    pbCommenFloorItemViewHolder.q.getLayoutStrategy().m(hi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = 0;
                    }
                }
                pbCommenFloorItemViewHolder.Z.setLayoutParams(layoutParams2);
                if (layoutParams != null) {
                    layoutParams.topMargin = hi.g(this.mContext, R.dimen.tbds20);
                    pbCommenFloorItemViewHolder.P.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            pbCommenFloorItemViewHolder.q.getLayoutStrategy().m(hi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
            pbCommenFloorItemViewHolder.q.getLayoutStrategy().n(hi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
            if (layoutParams != null) {
                layoutParams.topMargin = hi.g(this.mContext, R.dimen.tbds14);
                pbCommenFloorItemViewHolder.P.setLayoutParams(layoutParams);
            }
        }
    }

    public final void R(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, bc9 bc9Var, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048589, this, pbCommenFloorItemViewHolder, bc9Var, view2) == null) && pbCommenFloorItemViewHolder != null && bc9Var != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.r.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = hi.g(this.mContext, R.dimen.M_W_X007);
            layoutParams.leftMargin = hi.g(this.mContext, R.dimen.tbds148);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            pbCommenFloorItemViewHolder.q.setPadding(0, 0, 0, 0);
            pbCommenFloorItemViewHolder.q.p0(null);
            pbCommenFloorItemViewHolder.q.setBackgroundDrawable(null);
            pbCommenFloorItemViewHolder.q.getLayoutStrategy().h(R.drawable.transparent_bg);
            pbCommenFloorItemViewHolder.q.getLayoutStrategy().z(R.drawable.pic_video);
            E(pbCommenFloorItemViewHolder.q, view2, !StringUtils.isNull(bc9Var.t()), layoutParams.leftMargin + layoutParams.rightMargin);
            pbCommenFloorItemViewHolder.r.setLayoutParams(layoutParams);
            pbCommenFloorItemViewHolder.q.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            pbCommenFloorItemViewHolder.q.setIsFromCDN(this.j);
            pbCommenFloorItemViewHolder.q.setText(bc9Var.Z(), true, this.o);
            SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.q.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, bc9Var);
            sparseArray.put(R.id.tag_is_subpb, Boolean.FALSE);
            pbCommenFloorItemViewHolder.q.setTag(sparseArray);
            pbCommenFloorItemViewHolder.s.setTag(sparseArray);
            pbCommenFloorItemViewHolder.c.setTag(R.id.tag_from, sparseArray);
            pbCommenFloorItemViewHolder.t0.setTag(sparseArray);
            pbCommenFloorItemViewHolder.k0.setTag(sparseArray);
        }
    }

    public final void H(View view2) {
        PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, view2) == null) && view2 != null && (view2.getTag() instanceof PbCommenFloorItemViewHolder) && (agreeView = (pbCommenFloorItemViewHolder = (PbCommenFloorItemViewHolder) view2.getTag()).j0) != null && agreeView.getData() != null) {
            pbCommenFloorItemViewHolder.j0.setAgreeSource(2);
            pbCommenFloorItemViewHolder.j0.N();
        }
    }

    public final void I(bc9 bc9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, bc9Var) == null) && bc9Var != null) {
            int i2 = 8;
            if (bc9Var.c0) {
                i2 = 2;
            }
            StatisticItem i3 = mp8.i(this.i, bc9Var, bc9Var.d0, i2, 6);
            bc9Var.e0 = i3;
            if (!ListUtils.isEmpty(bc9Var.d0())) {
                Iterator<bc9> it = bc9Var.d0().iterator();
                while (it.hasNext()) {
                    it.next().e0 = i3;
                }
            }
        }
    }

    public final String Z(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, view2)) == null) {
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
    /* JADX WARN: Removed duplicated region for block: B:45:0x0119  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void L(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, bc9 bc9Var) {
        boolean z;
        boolean z2;
        int i2;
        int i3;
        ki8 ki8Var;
        ki8 ki8Var2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, pbCommenFloorItemViewHolder, bc9Var) == null) && pbCommenFloorItemViewHolder != null && bc9Var != null) {
            String str = null;
            boolean z3 = true;
            if (bc9Var.E() > 0 && (ki8Var2 = this.i) != null && !ki8Var2.l0()) {
                String format = String.format(this.mContext.getString(R.string.obfuscated_res_0x7f0f0a43), Integer.valueOf(bc9Var.E()));
                pbCommenFloorItemViewHolder.J.setVisibility(0);
                pbCommenFloorItemViewHolder.J.setText(format);
                z = true;
            } else {
                pbCommenFloorItemViewHolder.J.setVisibility(8);
                z = false;
            }
            if (bc9Var.r() != null) {
                str = bc9Var.r().getIpAddress();
                if (!TextUtils.isEmpty(str)) {
                    z2 = true;
                    oa5 V = bc9Var.V();
                    z3 = (V != null || StringUtils.isNull(V.b()) || (ki8Var = this.i) == null || ki8Var.l0()) ? false : false;
                    if (!z) {
                        pbCommenFloorItemViewHolder.l.setVisibility(0);
                        i2 = this.a;
                    } else {
                        pbCommenFloorItemViewHolder.l.setVisibility(8);
                        i2 = 0;
                    }
                    if (z3 && !z2) {
                        pbCommenFloorItemViewHolder.m.setVisibility(8);
                        i3 = 0;
                    } else {
                        pbCommenFloorItemViewHolder.m.setVisibility(0);
                        i3 = this.a;
                    }
                    pbCommenFloorItemViewHolder.k.setPadding(i2, 0, i3, 0);
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(bc9Var.k0()), "yyyy"))) {
                        pbCommenFloorItemViewHolder.k.setText(StringHelper.getFormatTimeShort(bc9Var.k0()));
                    } else {
                        pbCommenFloorItemViewHolder.k.setText(StringHelper.getFormatTime(bc9Var.k0()));
                    }
                    if (!z2) {
                        pbCommenFloorItemViewHolder.n.setVisibility(0);
                        pbCommenFloorItemViewHolder.n.setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds14), 0, 0, 0);
                        pbCommenFloorItemViewHolder.n.setText(TbadkCoreApplication.getInst().getString(R.string.user_ip_address) + str);
                    } else if (z3) {
                        pbCommenFloorItemViewHolder.n.setVisibility(0);
                        pbCommenFloorItemViewHolder.n.setPadding(this.a, 0, 0, 0);
                        if (bc9Var.b0) {
                            pbCommenFloorItemViewHolder.n.setText(StringHelper.cutStringWithSuffix(V.b(), 7, StringHelper.STRING_MORE));
                        } else {
                            pbCommenFloorItemViewHolder.n.setText(V.b());
                        }
                    } else {
                        pbCommenFloorItemViewHolder.n.setVisibility(8);
                    }
                    TextView textView = pbCommenFloorItemViewHolder.m0;
                    textView.setText(((Object) pbCommenFloorItemViewHolder.k.getText()) + "  • ");
                }
            }
            z2 = false;
            oa5 V2 = bc9Var.V();
            if (V2 != null) {
            }
            if (!z) {
            }
            if (z3) {
            }
            pbCommenFloorItemViewHolder.m.setVisibility(0);
            i3 = this.a;
            pbCommenFloorItemViewHolder.k.setPadding(i2, 0, i3, 0);
            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(bc9Var.k0()), "yyyy"))) {
            }
            if (!z2) {
            }
            TextView textView2 = pbCommenFloorItemViewHolder.m0;
            textView2.setText(((Object) pbCommenFloorItemViewHolder.k.getText()) + "  • ");
        }
    }

    public final void l0(TextView textView, bc9 bc9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048612, this, textView, bc9Var) == null) {
            if (textView == null && bc9Var == null) {
                return;
            }
            textView.setTag(bc9Var);
            if (bc9Var.r() != null) {
                MetaData r = bc9Var.r();
                String str = this.h;
                if (str != null && !str.equals("0") && this.h.equals(r.getUserId())) {
                    textView.setVisibility(0);
                    textView.setAlpha(1.0f);
                    textView.setText(R.string.host_name);
                    textView.setBackgroundColor(0);
                    n15 d2 = n15.d(textView);
                    d2.o(R.string.J_X04);
                    d2.m(R.dimen.L_X01);
                    d2.w(R.color.CAM_X0302);
                    d2.l(R.color.CAM_X0302);
                    return;
                } else if (r.getIs_bawu() == 1 && bc9Var.u0()) {
                    n15 d3 = n15.d(textView);
                    d3.w(R.color.CAM_X0101);
                    d3.o(R.string.J_X04);
                    d3.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.brand_official);
                    return;
                } else if (r.getIs_bawu() == 1 && "manager".equals(r.getBawu_type())) {
                    n15 d4 = n15.d(textView);
                    d4.w(R.color.CAM_X0101);
                    d4.o(R.string.J_X04);
                    d4.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_bazhu_tip);
                    return;
                } else if (r.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(r.getBawu_type())) {
                    n15 d5 = n15.d(textView);
                    d5.w(R.color.CAM_X0101);
                    d5.o(R.string.J_X04);
                    d5.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_xbazhu_tip);
                    return;
                } else if (r.getIs_bawu() == 1 && "pri_content_assist".equals(r.getBawu_type())) {
                    n15 d6 = n15.d(textView);
                    d6.w(R.color.CAM_X0101);
                    d6.o(R.string.J_X04);
                    d6.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_content_assist_tip);
                    return;
                } else if (r.getIs_bawu() == 1 && "pri_manage_assist".equals(r.getBawu_type())) {
                    n15 d7 = n15.d(textView);
                    d7.w(R.color.CAM_X0101);
                    d7.o(R.string.J_X04);
                    d7.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_manage_assist_tip);
                    return;
                } else {
                    textView.setVisibility(8);
                    return;
                }
            }
            textView.setVisibility(8);
        }
    }

    public final void N(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, bc9 bc9Var, View view2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048585, this, pbCommenFloorItemViewHolder, bc9Var, view2, i2) == null) && pbCommenFloorItemViewHolder != null && bc9Var != null) {
            pbCommenFloorItemViewHolder.A.setVisibility(8);
            pbCommenFloorItemViewHolder.u.setVisibility(0);
            pbCommenFloorItemViewHolder.l0.setVisibility(8);
            pbCommenFloorItemViewHolder.y.setVisibility(8);
            pbCommenFloorItemViewHolder.z.setVisibility(8);
            pbCommenFloorItemViewHolder.o.setVisibility(8);
            pbCommenFloorItemViewHolder.t0.setVisibility(8);
            W(pbCommenFloorItemViewHolder, bc9Var, view2, i2);
            J(pbCommenFloorItemViewHolder, bc9Var);
            O(pbCommenFloorItemViewHolder, bc9Var);
            R(pbCommenFloorItemViewHolder, bc9Var, view2);
            Q(pbCommenFloorItemViewHolder, bc9Var, view2, i2);
            L(pbCommenFloorItemViewHolder, bc9Var);
            T(pbCommenFloorItemViewHolder, bc9Var);
            P(pbCommenFloorItemViewHolder, bc9Var);
            U(pbCommenFloorItemViewHolder, bc9Var);
            yj8.c(pbCommenFloorItemViewHolder, bc9Var, view2, this.s);
            M(pbCommenFloorItemViewHolder, bc9Var);
            S(pbCommenFloorItemViewHolder, bc9Var);
            V(pbCommenFloorItemViewHolder, bc9Var);
            yj8.i(pbCommenFloorItemViewHolder, view2, bc9Var, this.p, true);
        }
    }

    public final void O(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, bc9 bc9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048586, this, pbCommenFloorItemViewHolder, bc9Var) == null) && pbCommenFloorItemViewHolder != null && bc9Var != null && bc9Var.o() != null) {
            bc9Var.o().objType = 1;
            bc9Var.o().isInPost = true;
            ThreadData threadData = null;
            ki8 ki8Var = this.i;
            if (ki8Var != null && ki8Var.Q() != null) {
                threadData = this.i.Q();
                bc9Var.o().threadId = threadData.getTid();
                bc9Var.o().forumId = String.valueOf(threadData.getFid());
            }
            if (threadData != null && threadData.isUgcThreadType()) {
                pbCommenFloorItemViewHolder.o.setAgreeAlone(true);
            }
            pbCommenFloorItemViewHolder.o.setThreadData(threadData);
            pbCommenFloorItemViewHolder.o.setData(bc9Var.o());
            pbCommenFloorItemViewHolder.j0.setThreadData(threadData);
            pbCommenFloorItemViewHolder.j0.setData(bc9Var.o());
        }
    }

    public final void T(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, bc9 bc9Var) {
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, pbCommenFloorItemViewHolder, bc9Var) == null) {
            if (bc9Var != null && bc9Var.r() != null && bc9Var.g0() != null) {
                TbRichText Z = bc9Var.Z();
                if (Z != null && StringUtils.isNull(Z.toString()) && StringUtils.isNull(bc9Var.t())) {
                    z = true;
                } else {
                    z = false;
                }
                if (bc9Var.r().getSmallTailThemeData() != null) {
                    str = bc9Var.r().getSmallTailThemeData().getPropsId();
                } else {
                    str = "";
                }
                pbCommenFloorItemViewHolder.Q.setTag(R.id.tag_pb_small_tail_theme_id, str);
                pbCommenFloorItemViewHolder.R.setTag(R.id.tag_pb_small_tail_theme_id, str);
                tq8.c(bc9Var.g0(), pbCommenFloorItemViewHolder.Q, pbCommenFloorItemViewHolder.R, pbCommenFloorItemViewHolder.S, false, false, z, bc9Var.r().getSmallTailThemeData());
                return;
            }
            pbCommenFloorItemViewHolder.Q.setVisibility(8);
            pbCommenFloorItemViewHolder.R.setVisibility(8);
        }
    }

    public final void P(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, bc9 bc9Var) {
        AlaLiveInfoCoreData alaLiveInfoCoreData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048587, this, pbCommenFloorItemViewHolder, bc9Var) == null) && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.W != null && pbCommenFloorItemViewHolder.T != null) {
            if (bc9Var != null && (alaLiveInfoCoreData = bc9Var.T) != null && !StringUtils.isNull(alaLiveInfoCoreData.liveTitle)) {
                pbCommenFloorItemViewHolder.W.setText(bc9Var.T.liveTitle);
                pbCommenFloorItemViewHolder.T.setTag(bc9Var.T);
                pbCommenFloorItemViewHolder.T.setVisibility(0);
                StatisticItem statisticItem = new StatisticItem("c12639");
                if (TbadkCoreApplication.getCurrentAccount() != null) {
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                }
                TiebaStatic.log(statisticItem);
                return;
            }
            pbCommenFloorItemViewHolder.T.setVisibility(8);
        }
    }

    public final void U(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, bc9 bc9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, pbCommenFloorItemViewHolder, bc9Var) == null) {
            if (bc9Var.J() != 2 && bc9Var.J() != 4) {
                pbCommenFloorItemViewHolder.Z.setVisibility(8);
                pbCommenFloorItemViewHolder.Y.setVisibility(0);
                G(false, pbCommenFloorItemViewHolder, bc9Var);
                return;
            }
            pbCommenFloorItemViewHolder.Z.setOnClickListener(new a(this, pbCommenFloorItemViewHolder, bc9Var));
            pbCommenFloorItemViewHolder.Z.setVisibility(0);
            F(pbCommenFloorItemViewHolder, bc9Var.w0(), bc9Var.I());
            G(true, pbCommenFloorItemViewHolder, bc9Var);
        }
    }

    public final void Q(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, bc9 bc9Var, View view2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048588, this, pbCommenFloorItemViewHolder, bc9Var, view2, i2) == null) && pbCommenFloorItemViewHolder != null && bc9Var != null) {
            if (bc9Var.f0() > 0) {
                pbCommenFloorItemViewHolder.x.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.x.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    pbCommenFloorItemViewHolder.x.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, bc9Var);
                if (bc9Var.J() == 2) {
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
                sparseArray2.put(R.id.tag_load_sub_data, bc9Var);
            }
            if (this.i != null) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_FLOOR_COMPLAINT);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.i.m());
                statisticItem.param("fname", this.i.n());
                statisticItem.param("tid", this.i.S());
                statisticItem.param("pid", bc9Var.O());
                TiebaStatic.log(statisticItem);
            }
            if (pbCommenFloorItemViewHolder.b0 != null) {
                PbFloorComplaint pbFloorComplaint = (PbFloorComplaint) view2.findViewById(R.id.obfuscated_res_0x7f09199a);
                pbCommenFloorItemViewHolder.b0 = pbFloorComplaint;
                pbCommenFloorItemViewHolder.c0 = Boolean.TRUE;
                pbFloorComplaint.setRemindText(bc9Var.G());
                pbCommenFloorItemViewHolder.b0.setRemindIcon(bc9Var.G());
                if (bc9Var.G() == 0) {
                    pbCommenFloorItemViewHolder.b0.setVisibility(8);
                } else {
                    pbCommenFloorItemViewHolder.b0.setVisibility(0);
                    if (this.i != null) {
                        StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_FLOOR_COMPLAINT_SHOW);
                        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem2.param("fid", this.i.m());
                        statisticItem2.param("fname", this.i.n());
                        statisticItem2.param("tid", this.i.S());
                        statisticItem2.param("pid", bc9Var.O());
                        statisticItem2.param("obj_type", bc9Var.G());
                        TiebaStatic.log(statisticItem2);
                    }
                }
                pbCommenFloorItemViewHolder.b0.setAmendIconListener(new c(this, bc9Var.F(), bc9Var));
            }
            ImageView imageView2 = pbCommenFloorItemViewHolder.z;
            if (imageView2 != null) {
                SparseArray sparseArray3 = (SparseArray) imageView2.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    pbCommenFloorItemViewHolder.z.setTag(sparseArray3);
                }
                sparseArray3.put(R.id.tag_load_sub_data, bc9Var);
            }
            pbCommenFloorItemViewHolder.w.setVisibility(8);
            if (!bc9Var.t0() && !bc9Var.s0(false)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.v.getLayoutParams();
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                layoutParams.bottomMargin = 0;
                pbCommenFloorItemViewHolder.v.setLayoutParams(layoutParams);
                pbCommenFloorItemViewHolder.v.setVisibility(8);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.v.getLayoutParams();
                layoutParams2.topMargin = hi.g(this.mContext, R.dimen.tbds10);
                layoutParams2.leftMargin = hi.g(this.mContext, R.dimen.tbds148);
                layoutParams2.rightMargin = hi.g(this.mContext, R.dimen.M_W_X007);
                layoutParams2.bottomMargin = hi.g(this.mContext, R.dimen.tbds20);
                pbCommenFloorItemViewHolder.v.setLayoutParams(layoutParams2);
                if (this.l == null) {
                    vo8 vo8Var = new vo8(this.mContext);
                    this.l = vo8Var;
                    vo8Var.f(this.j);
                    this.l.h(this.c);
                    this.l.e(this.d);
                    String str = null;
                    ki8 ki8Var = this.i;
                    if (ki8Var != null && ki8Var.Q() != null && this.i.Q().getAuthor() != null) {
                        str = this.i.Q().getAuthor().getUserId();
                    }
                    boolean z = true;
                    z = (str == null || !str.equals(TbadkCoreApplication.getCurrentAccount())) ? false : false;
                    ki8 ki8Var2 = this.i;
                    if (ki8Var2 != null) {
                        this.l.j(ki8Var2.Y(), z);
                        this.l.i(this.i.Q());
                    }
                }
                this.l.g(bc9Var.O());
                pbCommenFloorItemViewHolder.v.setSubPbAdapter(this.l);
                pbCommenFloorItemViewHolder.v.setVisibility(0);
                pbCommenFloorItemViewHolder.v.setData(bc9Var, view2);
                pbCommenFloorItemViewHolder.v.setChildOnClickListener(this.d);
                pbCommenFloorItemViewHolder.v.setChildOnLongClickListener(this.g);
                pbCommenFloorItemViewHolder.v.setChildOnTouchListener(this.s);
            }
            if (bc9Var.P) {
                pbCommenFloorItemViewHolder.P.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.P.setVisibility(4);
            }
            pbCommenFloorItemViewHolder.x.setVisibility(8);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.u.getLayoutParams();
            layoutParams3.topMargin = hi.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X001);
            layoutParams3.bottomMargin = hi.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X002);
            if (pbCommenFloorItemViewHolder.w.getVisibility() == 8) {
                pbCommenFloorItemViewHolder.u.setVisibility(8);
            } else {
                pbCommenFloorItemViewHolder.u.setVisibility(0);
            }
            pbCommenFloorItemViewHolder.n0.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f10c3));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:231:0x066c  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0677  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0680  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x06c3  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x06cd  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0733  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x073d  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x077c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void W(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, bc9 bc9Var, View view2, int i2) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        int i3;
        int i4;
        String str;
        String str2;
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048594, this, pbCommenFloorItemViewHolder, bc9Var, view2, i2) == null) && pbCommenFloorItemViewHolder != null && bc9Var != null) {
            if (bc9Var.r() != null) {
                bc9Var.r().isBaijiahaoUser();
            }
            int i5 = 0;
            if (bc9Var.R) {
                SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.e, R.color.CAM_X0204);
                pbCommenFloorItemViewHolder.e.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.e.setVisibility(8);
            }
            ThreadData threadData = null;
            pbCommenFloorItemViewHolder.p.setTag(null);
            pbCommenFloorItemViewHolder.p.setUserId(null);
            pbCommenFloorItemViewHolder.g.setText((CharSequence) null);
            pbCommenFloorItemViewHolder.L.getHeadView().setUserId(null);
            pbCommenFloorItemViewHolder.q.setIsHost(false);
            String str5 = "";
            if (bc9Var.r() != null) {
                String str6 = this.h;
                if (str6 != null && !str6.equals("0") && this.h.equals(bc9Var.r().getUserId())) {
                    pbCommenFloorItemViewHolder.q.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = bc9Var.r().getIconInfo();
                ArrayList<IconData> tShowInfoNew = bc9Var.r().getTShowInfoNew();
                UserIconBox userIconBox = pbCommenFloorItemViewHolder.N;
                if (userIconBox != null) {
                    userIconBox.setTag(R.id.tag_user_id, bc9Var.r().getUserId());
                    tn8 tn8Var = this.m;
                    if (tn8Var != null) {
                        pbCommenFloorItemViewHolder.N.setOnClickListener(tn8Var.c);
                    }
                    int g2 = hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                    int g3 = hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                    UserIconBox userIconBox2 = pbCommenFloorItemViewHolder.N;
                    i3 = R.id.tag_user_id;
                    userIconBox2.h(iconInfo, 2, g2, g2, g3);
                } else {
                    i3 = R.id.tag_user_id;
                }
                if (pbCommenFloorItemViewHolder.M != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        pbCommenFloorItemViewHolder.M.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    tn8 tn8Var2 = this.m;
                    if (tn8Var2 != null) {
                        pbCommenFloorItemViewHolder.M.setOnClickListener(tn8Var2.e);
                    }
                    int g4 = hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                    pbCommenFloorItemViewHolder.M.i(tShowInfoNew, 3, g4, g4, hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
                }
                if (ListUtils.isEmpty(tShowInfoNew) && !bc9Var.r().isBigV()) {
                    if (UbsABTestHelper.isPBPlanA()) {
                        if (DeviceInfoUtil.isMate30()) {
                            mm8.F(pbCommenFloorItemViewHolder.g);
                        } else {
                            n15.d(pbCommenFloorItemViewHolder.g).B(R.string.F_X02);
                        }
                        SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0108, 1);
                    } else {
                        SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0107, 1);
                    }
                } else {
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0301, 1);
                }
                String avater = bc9Var.r().getAvater();
                if (bc9Var.c0) {
                    i4 = 2;
                } else {
                    i4 = 8;
                }
                pbCommenFloorItemViewHolder.g.setTag(i3, bc9Var.r().getUserId());
                pbCommenFloorItemViewHolder.g.setTag(R.id.tag_user_name, bc9Var.r().getUserName());
                pbCommenFloorItemViewHolder.g.setTag(R.id.tag_virtual_user_url, bc9Var.r().getVirtualUserUrl());
                pbCommenFloorItemViewHolder.g.setTag(R.id.tag_statistic_item, mp8.i(this.i, bc9Var, bc9Var.d0, i4, 2));
                String name_show = bc9Var.r().getName_show();
                String userName = bc9Var.r().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    pbCommenFloorItemViewHolder.g.setText(kh8.b(this.mContext, pbCommenFloorItemViewHolder.g.getText().toString()));
                    pbCommenFloorItemViewHolder.g.setGravity(16);
                    pbCommenFloorItemViewHolder.g.setTag(R.id.tag_nick_name_activity, kh8.a());
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0312, 1);
                }
                if (bc9Var.r().getPendantData() != null && !StringUtils.isNull(bc9Var.r().getPendantData().getImgUrl())) {
                    pbCommenFloorItemViewHolder.L.setBigVDimenSize(R.dimen.tbds36);
                    pbCommenFloorItemViewHolder.L.i(bc9Var.r());
                    pbCommenFloorItemViewHolder.p.setVisibility(8);
                    pbCommenFloorItemViewHolder.L.setVisibility(0);
                    pbCommenFloorItemViewHolder.L.getHeadView().M(avater, 28, false);
                    pbCommenFloorItemViewHolder.L.getHeadView().setUserId(bc9Var.r().getUserId());
                    pbCommenFloorItemViewHolder.L.getHeadView().setUserName(bc9Var.r().getUserName());
                    ki8 ki8Var = this.i;
                    if (ki8Var == null) {
                        str3 = "";
                    } else {
                        str3 = ki8Var.m();
                    }
                    pbCommenFloorItemViewHolder.L.getHeadView().setFid(str3);
                    ki8 ki8Var2 = this.i;
                    if (ki8Var2 == null) {
                        str4 = "";
                    } else {
                        str4 = ki8Var2.n();
                    }
                    pbCommenFloorItemViewHolder.L.getHeadView().setFName(str4);
                    pbCommenFloorItemViewHolder.L.getHeadView().setFloor(bc9Var.E());
                    pbCommenFloorItemViewHolder.L.getHeadView().setTid(bc9Var.O());
                    pbCommenFloorItemViewHolder.L.getHeadView().setTag(R.id.tag_statistic_item, mp8.i(this.i, bc9Var, bc9Var.d0, i4, 2));
                    pbCommenFloorItemViewHolder.L.i(bc9Var.r());
                } else {
                    pbCommenFloorItemViewHolder.p.setGodIconWidth(R.dimen.tbds36);
                    UtilHelper.showHeadImageViewBigV(pbCommenFloorItemViewHolder.p, bc9Var.r(), 4);
                    pbCommenFloorItemViewHolder.p.setUserId(bc9Var.r().getUserId());
                    ki8 ki8Var3 = this.i;
                    if (ki8Var3 == null) {
                        str = "";
                    } else {
                        str = ki8Var3.m();
                    }
                    pbCommenFloorItemViewHolder.p.setFid(str);
                    ki8 ki8Var4 = this.i;
                    if (ki8Var4 == null) {
                        str2 = "";
                    } else {
                        str2 = ki8Var4.n();
                    }
                    pbCommenFloorItemViewHolder.p.setFName(str2);
                    pbCommenFloorItemViewHolder.p.setFloor(bc9Var.E());
                    pbCommenFloorItemViewHolder.p.setTid(bc9Var.O());
                    pbCommenFloorItemViewHolder.p.setUserName(bc9Var.r().getUserName(), bc9Var.m0());
                    pbCommenFloorItemViewHolder.p.setTag(R.id.tag_virtual_user_url, bc9Var.r().getVirtualUserUrl());
                    pbCommenFloorItemViewHolder.p.setTag(R.id.tag_statistic_item, mp8.i(this.i, bc9Var, bc9Var.d0, i4, 2));
                    pbCommenFloorItemViewHolder.p.setImageDrawable(null);
                    pbCommenFloorItemViewHolder.p.M(avater, 28, false);
                    pbCommenFloorItemViewHolder.p.setVisibility(0);
                    pbCommenFloorItemViewHolder.L.setVisibility(8);
                }
                if (bc9Var.r() != null && bc9Var.r().getAlaInfo() != null && bc9Var.r().getAlaUserData() != null && bc9Var.r().getAlaUserData().live_status == 1) {
                    pbCommenFloorItemViewHolder.d(true);
                    pbCommenFloorItemViewHolder.p.setLiveStatus(1);
                    pbCommenFloorItemViewHolder.p.setAlaInfo(bc9Var.r().getAlaInfo());
                    pbCommenFloorItemViewHolder.L.getHeadView().setLiveStatus(1);
                    pbCommenFloorItemViewHolder.L.getHeadView().setAlaInfo(bc9Var.r().getAlaInfo());
                    threadData = null;
                } else {
                    pbCommenFloorItemViewHolder.d(false);
                    pbCommenFloorItemViewHolder.p.setLiveStatus(0);
                    threadData = null;
                    pbCommenFloorItemViewHolder.p.setAlaInfo(null);
                    pbCommenFloorItemViewHolder.L.getHeadView().setLiveStatus(0);
                    pbCommenFloorItemViewHolder.L.getHeadView().setAlaInfo(null);
                }
                l0(pbCommenFloorItemViewHolder.i, bc9Var);
            }
            int level_id = bc9Var.r().getLevel_id();
            ki8 ki8Var5 = this.i;
            if (ki8Var5 != null && ki8Var5.l0()) {
                level_id = 0;
            }
            if (level_id > 0) {
                pbCommenFloorItemViewHolder.K.setVisibility(0);
                SkinManager.setImageResource(pbCommenFloorItemViewHolder.K, BitmapHelper.getGradeResourceIdInEnterForum(level_id));
            } else {
                pbCommenFloorItemViewHolder.K.setVisibility(8);
            }
            int i6 = 15;
            if (pbCommenFloorItemViewHolder.N.getChildCount() == 1) {
                i6 = 13;
            } else if (pbCommenFloorItemViewHolder.N.getChildCount() > 1) {
                i6 = 11;
            }
            if (pbCommenFloorItemViewHolder.i.getVisibility() == 0) {
                i6 -= 2;
            }
            if (pbCommenFloorItemViewHolder.M.getChildCount() > 0) {
                i6 -= 2;
            }
            if (bc9Var.w() > 1000) {
                i6 -= 2;
            }
            if (bc9Var.w() > 10) {
                i6 -= 2;
            }
            if (i6 < 10) {
                pbCommenFloorItemViewHolder.N.setVisibility(8);
                if (pbCommenFloorItemViewHolder.N.getChildCount() == 1) {
                    i6 += 2;
                } else if (pbCommenFloorItemViewHolder.N.getChildCount() > 1) {
                    i6 += 4;
                }
                if (i6 < 10 && pbCommenFloorItemViewHolder.i.getVisibility() == 0) {
                    i6 += 2;
                    pbCommenFloorItemViewHolder.i.setVisibility(8);
                }
                if (i6 < 10 && pbCommenFloorItemViewHolder.K.getVisibility() == 0) {
                    pbCommenFloorItemViewHolder.K.setVisibility(8);
                }
            }
            int m = mm8.m();
            if (bc9Var.r() != null) {
                str5 = bc9Var.r().getName_show();
            }
            int f2 = dq5.f(str5);
            if (bc9Var.r() != null && !StringUtils.isNull(bc9Var.r().getSealPrefix())) {
                int i7 = m - 2;
                if (f2 > i7) {
                    str5 = dq5.n(str5, i7) + StringHelper.STRING_MORE;
                }
            } else if (f2 > m) {
                str5 = dq5.n(str5, m) + StringHelper.STRING_MORE;
            }
            if (bc9Var.r() != null && !StringUtils.isNull(bc9Var.r().getSealPrefix())) {
                pbCommenFloorItemViewHolder.g.setText(Y(bc9Var.r().getSealPrefix(), str5));
            } else {
                pbCommenFloorItemViewHolder.g.setText(str5);
                pbCommenFloorItemViewHolder.f.post(new b(this, pbCommenFloorItemViewHolder, str5));
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, bc9Var);
            sparseArray.put(R.id.tag_load_sub_data, bc9Var);
            sparseArray.put(R.id.tag_load_sub_view, view2);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(bc9Var.E()));
            sparseArray.put(R.id.tag_forbid_user_post_id, bc9Var.O());
            sparseArray.put(R.id.pb_dialog_item_zan_1, pbCommenFloorItemViewHolder.o);
            sparseArray.put(R.id.pb_dialog_item_zan_2, pbCommenFloorItemViewHolder.j0);
            sparseArray.put(R.id.pb_dialog_item_reply, pbCommenFloorItemViewHolder.y);
            sparseArray.put(R.id.pb_dialog_item_share, pbCommenFloorItemViewHolder.z);
            ki8 ki8Var6 = this.i;
            if (ki8Var6 != null && ki8Var6.Q() != null) {
                threadData = this.i.Q();
            }
            if (threadData != null && threadData.isUgcThreadType()) {
                sparseArray.put(R.id.pb_dialog_item_isugc, Boolean.TRUE);
            } else {
                sparseArray.put(R.id.pb_dialog_item_isugc, Boolean.FALSE);
            }
            if (bc9Var.r() != null && !StringUtils.isNull(bc9Var.r().getVirtualUserUrl())) {
                z = true;
            } else {
                z = false;
            }
            ki8 ki8Var7 = this.i;
            if (ki8Var7 != null && ki8Var7.Y() != 0 && !a0()) {
                if (this.i.Y() != 1002 && this.i.Y() != 3) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (this.i.Y() != 3 && !this.i.l0()) {
                    z3 = true;
                    z4 = true;
                } else {
                    z3 = false;
                    z4 = false;
                }
                if (bc9Var != null && bc9Var.r() != null) {
                    String userId = bc9Var.r().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z2 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z2 = false;
                    }
                }
            } else {
                z2 = false;
                z3 = false;
                z4 = false;
            }
            ki8 ki8Var8 = this.i;
            if (ki8Var8 != null && ki8Var8.Q() != null && this.i.Q().getAuthor() != null && bc9Var.r() != null) {
                String userId2 = this.i.Q().getAuthor().getUserId();
                String userId3 = bc9Var.r().getUserId();
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
                    if (bc9Var != null && bc9Var.r() != null && UtilHelper.isCurrentAccount(bc9Var.r().getUserId())) {
                        z3 = true;
                        z6 = true;
                    }
                    if (z) {
                        z2 = false;
                        z5 = false;
                        z3 = false;
                    }
                    if (bc9Var.E() != 1) {
                        i5 = 1;
                    }
                    if (!z2) {
                        sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.i.Y()));
                        if (bc9Var.r() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, bc9Var.r().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, bc9Var.r().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, bc9Var.r().getPortrait());
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                    }
                    if (!z5) {
                        sparseArray.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (bc9Var.r() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, bc9Var.r().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, bc9Var.r().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, bc9Var.r().getName_show());
                        }
                        if (this.i.Q() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.i.Q().getId());
                        }
                        sparseArray.put(R.id.tag_user_mute_post_id, bc9Var.O());
                    } else {
                        sparseArray.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                    }
                    if (!z3) {
                        sparseArray.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_has_sub_post, Boolean.valueOf(bc9Var.t0()));
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.i.Y()));
                        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i5));
                        sparseArray.put(R.id.tag_del_post_id, bc9Var.O());
                    } else {
                        sparseArray.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                    }
                    sparseArray.put(R.id.tag_mul_del_post_type, Boolean.valueOf(z4));
                    sparseArray.put(R.id.tag_is_self_post, Boolean.valueOf(z7));
                    pbCommenFloorItemViewHolder.q.setTag(sparseArray);
                    pbCommenFloorItemViewHolder.s.setTag(sparseArray);
                }
            }
            z5 = false;
            z6 = false;
            z7 = false;
            if (bc9Var != null) {
                z3 = true;
                z6 = true;
            }
            if (z) {
            }
            if (bc9Var.E() != 1) {
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
        }
    }

    public final SpannableStringBuilder Y(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, str, str2)) == null) {
            ArrayList arrayList = new ArrayList();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (str2 == null) {
                return spannableStringBuilder;
            }
            if (str != null) {
                arrayList.add(new xe6.a(str, R.drawable.pic_smalldot_title));
                return xe6.h(this.mContext, str2, arrayList, true);
            }
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public final boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            ki8 ki8Var = this.i;
            if (ki8Var != null && ki8Var.Q() != null) {
                return this.i.Q().isBlocked();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tm
    /* renamed from: b0 */
    public PbCommenFloorItemViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d073d, viewGroup, false);
            ((ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f0919fe)).addView(LayoutInflater.from(inflate.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0735, (ViewGroup) null));
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = new PbCommenFloorItemViewHolder(this.b, inflate, 0);
            pbCommenFloorItemViewHolder.t.setConstrainLayoutPool(this.q);
            pbCommenFloorItemViewHolder.t.setImageViewPool(this.r);
            SubPbLayout subPbLayout = pbCommenFloorItemViewHolder.v;
            if (subPbLayout != null) {
                subPbLayout.setShowChildComment(true);
                pbCommenFloorItemViewHolder.v.setIsVideoThread(false);
            }
            j0(pbCommenFloorItemViewHolder);
            return pbCommenFloorItemViewHolder;
        }
        return (PbCommenFloorItemViewHolder) invokeL.objValue;
    }

    public View c0(int i2, View view2, ViewGroup viewGroup, bc9 bc9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, bc9Var, pbCommenFloorItemViewHolder})) == null) {
            j0(pbCommenFloorItemViewHolder);
            d0(pbCommenFloorItemViewHolder);
            D(pbCommenFloorItemViewHolder);
            bc9 bc9Var2 = (bc9) getItem(i2);
            if (bc9Var2 != null) {
                bc9Var2.d0 = i2 + 1;
                bc9Var2.o1();
                I(bc9Var2);
                N(pbCommenFloorItemViewHolder, bc9Var2, view2, i2);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void d0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.c.setOnTouchListener(this.s);
            pbCommenFloorItemViewHolder.c.setOnLongClickListener(this.g);
            pbCommenFloorItemViewHolder.g.setOnClickListener(this.m.b);
            pbCommenFloorItemViewHolder.p.setOnClickListener(this.m.b);
            pbCommenFloorItemViewHolder.L.setOnClickListener(this.m.b);
            pbCommenFloorItemViewHolder.L.getHeadView().setOnClickListener(this.m.b);
            pbCommenFloorItemViewHolder.q.setOnLongClickListener(this.g);
            pbCommenFloorItemViewHolder.q.setOnTouchListener(this.s);
            pbCommenFloorItemViewHolder.q.setCommonTextViewOnClickListener(this.d);
            pbCommenFloorItemViewHolder.q.setOnImageClickListener(this.e);
            pbCommenFloorItemViewHolder.q.setOnImageTouchListener(this.s);
            pbCommenFloorItemViewHolder.q.setOnEmotionClickListener(this.m.f);
            pbCommenFloorItemViewHolder.q.setOnVoiceAfterClickListener(this.d);
            pbCommenFloorItemViewHolder.Q.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.R.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.T.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.w.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.x.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.s0.setOnTouchListener(this.s);
            pbCommenFloorItemViewHolder.s0.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.o0.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.k0.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.t0.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.l0.setOnClickListener(new g(this, pbCommenFloorItemViewHolder));
            pbCommenFloorItemViewHolder.c.setOnClickListener(new h(this, pbCommenFloorItemViewHolder));
            pbCommenFloorItemViewHolder.y.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.z.setOnClickListener(new i(this, pbCommenFloorItemViewHolder));
            pbCommenFloorItemViewHolder.o.B = new j(this, pbCommenFloorItemViewHolder);
            pbCommenFloorItemViewHolder.j0.B = new k(this, pbCommenFloorItemViewHolder);
        }
    }

    public final void j0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048609, this, pbCommenFloorItemViewHolder) != null) || pbCommenFloorItemViewHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (pbCommenFloorItemViewHolder.a != skinType) {
            k0(pbCommenFloorItemViewHolder.i);
            boolean z = true;
            if (UbsABTestHelper.isPBPlanA()) {
                if (DeviceInfoUtil.isMate30()) {
                    mm8.F(pbCommenFloorItemViewHolder.g);
                } else {
                    n15.d(pbCommenFloorItemViewHolder.g).B(R.string.F_X02);
                }
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0108, 1);
            } else {
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0109, 1);
            }
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.k, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.l, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.m, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.J, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.n, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.x, (int) R.color.CAM_X0108);
            pbCommenFloorItemViewHolder.q.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            if (pbCommenFloorItemViewHolder.s.getVisibility() == 0) {
                pbCommenFloorItemViewHolder.s.g(skinType);
            }
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.m0, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.n0, R.color.CAM_X0107, 1);
            SkinManager.setBackgroundShapeDrawable(pbCommenFloorItemViewHolder.v, hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds21), R.color.CAM_X0206, R.color.CAM_X0206);
            SkinManager.getColor(R.color.CAM_X0107);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.w, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.w, (int) R.color.CAM_X0304);
            pbCommenFloorItemViewHolder.w.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right, SkinManager.getColor(R.color.CAM_X0304), null), (Drawable) null);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.y, R.drawable.obfuscated_res_0x7f080a17, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.z, R.drawable.obfuscated_res_0x7f080a18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbCommenFloorItemViewHolder.v.d();
            pbCommenFloorItemViewHolder.t.b();
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.W, R.color.CAM_X0304, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.U, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.T, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.V, R.color.CAM_X0109);
            SkinManager.setImageResource(pbCommenFloorItemViewHolder.X, R.drawable.icon_arrow_more_gray);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.a0, (int) R.color.CAM_X0107);
            if (pbCommenFloorItemViewHolder.Y.getVisibility() != 8) {
                z = false;
            }
            if (z) {
                pbCommenFloorItemViewHolder.a0.setText(R.string.obfuscated_res_0x7f0f0425);
            } else {
                ki8 ki8Var = this.i;
                if (ki8Var != null && StringUtils.isNull(ki8Var.k())) {
                    pbCommenFloorItemViewHolder.a0.setText(this.i.k());
                } else {
                    pbCommenFloorItemViewHolder.a0.setText(R.string.obfuscated_res_0x7f0f0634);
                }
            }
            pbCommenFloorItemViewHolder.o.P(TbadkCoreApplication.getInst().getSkinType());
            pbCommenFloorItemViewHolder.c(skinType);
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.P, R.color.CAM_X0203);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.k0, R.drawable.icon_pure_pb_more18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.t0, R.drawable.icon_pure_pb_more18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbCommenFloorItemViewHolder.b();
        }
        pbCommenFloorItemViewHolder.a = skinType;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.baidu.tieba.tm
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i2, View view2, ViewGroup viewGroup, bc9 bc9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        c0(i2, view2, viewGroup, bc9Var, pbCommenFloorItemViewHolder);
        return view2;
    }
}

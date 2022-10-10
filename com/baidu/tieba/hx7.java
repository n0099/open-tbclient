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
import com.baidu.tieba.lw7;
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.tieba.pb.pb.main.PbFloorComplaint;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.s08;
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
public class hx7 extends qn<PostData, PbCommenFloorItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public TbPageContext b;
    public View.OnClickListener c;
    public View.OnClickListener d;
    public TbRichTextView.y e;
    public lw7 f;
    public View.OnLongClickListener g;
    public String h;
    public jv7 i;
    public boolean j;
    public SparseIntArray k;
    public s18 l;
    public q08 m;
    public s08 n;
    public TbRichTextView.s o;
    public boolean p;
    public ug<ConstrainImageLayout> q;
    public ug<TbImageView> r;
    public lw7 s;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ PostData b;
        public final /* synthetic */ hx7 c;

        public a(hx7 hx7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hx7Var, pbCommenFloorItemViewHolder, postData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = hx7Var;
            this.a = pbCommenFloorItemViewHolder;
            this.b = postData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                boolean z = this.a.X.getVisibility() == 8;
                this.c.D(this.a, !z, this.b.F());
                this.b.L0(!z);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ String b;

        public b(hx7 hx7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hx7Var, pbCommenFloorItemViewHolder, str};
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
                int measuredWidth = this.a.e.getMeasuredWidth();
                String str = this.b;
                PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = this.a;
                lz7.a(measuredWidth, str, pbCommenFloorItemViewHolder.f, pbCommenFloorItemViewHolder.h, pbCommenFloorItemViewHolder.J, pbCommenFloorItemViewHolder.M, pbCommenFloorItemViewHolder.L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ PostData b;
        public final /* synthetic */ hx7 c;

        public c(hx7 hx7Var, String str, PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hx7Var, str, postData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = hx7Var;
            this.a = str;
            this.b = postData;
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
                    statisticItem.param("tid", this.c.i.Q());
                    statisticItem.param("pid", this.b.L());
                    statisticItem.param("obj_type", this.b.E());
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements vg<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hx7 a;

        public d(hx7 hx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hx7Var;
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
        public final /* synthetic */ hx7 a;

        public e(hx7 hx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hx7Var;
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
        public final /* synthetic */ hx7 a;

        public f(hx7 hx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hx7Var;
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
                if (this.a.f != null) {
                    if (!(view2 instanceof TbListTextView) || this.a.d == null) {
                        this.a.f.a(view2);
                        this.a.f.onSingleTapConfirmed(motionEvent);
                        return true;
                    }
                    this.a.d.onClick(view2);
                    return true;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.lw7.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                if (view2 == null || view2.getId() == R.id.obfuscated_res_0x7f090a0c) {
                    return true;
                }
                if (view2 instanceof RelativeLayout) {
                    this.a.F(view2);
                } else {
                    ViewParent parent = view2.getParent();
                    int i = 0;
                    while (true) {
                        if (parent == null || i >= 10) {
                            break;
                        } else if (parent instanceof RelativeLayout) {
                            this.a.F((RelativeLayout) parent);
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

        public g(hx7 hx7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hx7Var, pbCommenFloorItemViewHolder};
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
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ hx7 b;

        public h(hx7 hx7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hx7Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hx7Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || view2 == null || this.b.i == null || (pbCommenFloorItemViewHolder = this.a) == null || (agreeView = pbCommenFloorItemViewHolder.h0) == null || agreeView.getData() == null) {
                return;
            }
            this.a.h0.getImgAgree();
            String Q = this.b.i.Q();
            if ((StringUtils.isNull(Q) || "0".equals(this.b.i.Q())) && this.b.i.O() != null) {
                Q = this.b.i.O().getNid();
            }
            TiebaStatic.log(new StatisticItem("c14442").param("tid", Q).param("fname", this.b.i.n()).param("fid", this.b.i.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.h0.getData().postId));
        }
    }

    /* loaded from: classes4.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ hx7 b;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PostData a;
            public final /* synthetic */ i b;

            public a(i iVar, PostData postData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar, postData};
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
                this.a = postData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    s08.b bVar = this.b.b.n.b;
                    i iVar = this.b;
                    bVar.a(iVar.b.i, null, this.a, iVar.a.p.getLayoutStrategy());
                }
            }
        }

        public i(hx7 hx7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hx7Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hx7Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PostData postData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (view2.getTag() instanceof SparseArray)) {
                SparseArray sparseArray = (SparseArray) view2.getTag();
                if (!(sparseArray.get(R.id.obfuscated_res_0x7f09205a) instanceof PostData) || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f09205a)) == null || this.a.b == null || this.b.n == null) {
                    return;
                }
                gh.a().postDelayed(new a(this, postData), 100L);
                String Q = this.b.i.Q();
                if ((StringUtils.isNull(Q) || "0".equals(this.b.i.Q())) && this.b.i.O() != null) {
                    Q = this.b.i.O().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", Q).param("fid", this.b.i.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData.L()).param("obj_source", this.b.X(view2)).param("obj_type", 4));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ hx7 b;

        public j(hx7 hx7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hx7Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hx7Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || view2 == null || this.b.i == null || (pbCommenFloorItemViewHolder = this.a) == null || (agreeView = pbCommenFloorItemViewHolder.n) == null || agreeView.getData() == null) {
                return;
            }
            int i = view2 == this.a.n.getImgAgree() ? 1 : 2;
            String Q = this.b.i.Q();
            if ((StringUtils.isNull(Q) || "0".equals(this.b.i.Q())) && this.b.i.O() != null) {
                Q = this.b.i.O().getNid();
            }
            TiebaStatic.log(new StatisticItem("c13700").param("tid", Q).param("fid", this.b.i.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.n.getData().postId).param("obj_source", this.b.X(this.a.n)).param("obj_type", i));
        }
    }

    /* loaded from: classes4.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ hx7 b;

        public k(hx7 hx7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hx7Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hx7Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || view2 == null || this.b.i == null || (pbCommenFloorItemViewHolder = this.a) == null || (agreeView = pbCommenFloorItemViewHolder.h0) == null || agreeView.getData() == null) {
                return;
            }
            int i = view2 == this.a.h0.getImgAgree() ? 1 : 2;
            String Q = this.b.i.Q();
            if ((StringUtils.isNull(Q) || "0".equals(this.b.i.Q())) && this.b.i.O() != null) {
                Q = this.b.i.O().getNid();
            }
            TiebaStatic.log(new StatisticItem("c13700").param("tid", Q).param("fid", this.b.i.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.h0.getData().postId).param("obj_source", this.b.X(this.a.h0)).param("obj_type", i));
            TiebaStatic.log(new StatisticItem("c14440").param("tid", Q).param("fname", this.b.i.n()).param("fid", this.b.i.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.h0.getData().postId));
        }
    }

    /* loaded from: classes4.dex */
    public class l implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hx7 a;

        public l(hx7 hx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hx7Var;
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
    public hx7(Context context, BdUniqueId bdUniqueId, TbPageContext tbPageContext) {
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
        this.q = new ug<>(new d(this), 6, 0);
        this.r = new ug<>(new e(this), 12, 0);
        this.s = new lw7(new f(this));
        this.b = tbPageContext;
        this.a = V(R.dimen.tbds14);
    }

    public final void B(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.p.setTextViewOnTouchListener(this.f);
            pbCommenFloorItemViewHolder.p.setTextViewCheckSelection(false);
            pbCommenFloorItemViewHolder.r.setOnTouchListener(new l(this));
        }
    }

    public final void C(TbRichTextView tbRichTextView, View view2, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{tbRichTextView, view2, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || tbRichTextView == null || view2 == null) {
            return;
        }
        int k2 = ((((ej.k(TbadkCoreApplication.getInst()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight()) - i2;
        if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
            k2 = (k2 - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
        }
        int V = z ? V(R.dimen.tbds115) : 0;
        tbRichTextView.getLayoutStrategy().q((int) ((k2 - V) * 1.0f));
        tbRichTextView.getLayoutStrategy().H = (k2 - V) - V(R.dimen.tbds122);
        tbRichTextView.getLayoutStrategy().p((int) (k2 * 1.618f * 1.0f));
    }

    public final void D(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{pbCommenFloorItemViewHolder, Boolean.valueOf(z), str}) == null) {
            if (z) {
                pbCommenFloorItemViewHolder.X.setVisibility(8);
                if (StringUtils.isNull(str)) {
                    pbCommenFloorItemViewHolder.Z.setText(R.string.obfuscated_res_0x7f0f05e6);
                    return;
                } else {
                    pbCommenFloorItemViewHolder.Z.setText(str);
                    return;
                }
            }
            pbCommenFloorItemViewHolder.X.setVisibility(0);
            pbCommenFloorItemViewHolder.Z.setText(R.string.obfuscated_res_0x7f0f03fb);
        }
    }

    public final void E(boolean z, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), pbCommenFloorItemViewHolder, postData}) == null) || pbCommenFloorItemViewHolder == null || (view2 = pbCommenFloorItemViewHolder.O) == null || pbCommenFloorItemViewHolder.Y == null || !(view2.getLayoutParams() instanceof RelativeLayout.LayoutParams) || !(pbCommenFloorItemViewHolder.Y.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            return;
        }
        boolean z2 = !ListUtils.isEmpty(postData.Z());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.O.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.Y.getLayoutParams();
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
            pbCommenFloorItemViewHolder.Y.setLayoutParams(layoutParams2);
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

    public final void F(View view2) {
        PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, view2) == null) || view2 == null || !(view2.getTag() instanceof PbCommenFloorItemViewHolder) || (agreeView = (pbCommenFloorItemViewHolder = (PbCommenFloorItemViewHolder) view2.getTag()).h0) == null || agreeView.getData() == null) {
            return;
        }
        pbCommenFloorItemViewHolder.h0.setAgreeSource(2);
        pbCommenFloorItemViewHolder.h0.J();
    }

    public final void G(PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, postData) == null) || postData == null) {
            return;
        }
        StatisticItem i2 = j28.i(this.i, postData, postData.c0, postData.b0 ? 2 : 8, 6);
        postData.d0 = i2;
        if (ListUtils.isEmpty(postData.Z())) {
            return;
        }
        Iterator<PostData> it = postData.Z().iterator();
        while (it.hasNext()) {
            it.next().d0 = i2;
        }
    }

    public final void H(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || postData == null || (imageView = pbCommenFloorItemViewHolder.N) == null || this.i == null) {
            return;
        }
        imageView.setVisibility(8);
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
    public final void I(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        boolean z;
        boolean z2;
        int i2;
        int i3;
        jv7 jv7Var;
        jv7 jv7Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        String str = null;
        boolean z3 = true;
        if (postData.C() > 0 && (jv7Var2 = this.i) != null && !jv7Var2.i0()) {
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
                j45 S = postData.S();
                z3 = (S != null || StringUtils.isNull(S.b()) || (jv7Var = this.i) == null || jv7Var.i0()) ? false : false;
                if (!z) {
                    pbCommenFloorItemViewHolder.k.setVisibility(0);
                    i2 = this.a;
                } else {
                    pbCommenFloorItemViewHolder.k.setVisibility(8);
                    i2 = 0;
                }
                if (z3 && !z2) {
                    pbCommenFloorItemViewHolder.l.setVisibility(8);
                    i3 = 0;
                } else {
                    pbCommenFloorItemViewHolder.l.setVisibility(0);
                    i3 = this.a;
                }
                pbCommenFloorItemViewHolder.j.setPadding(i2, 0, i3, 0);
                if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.f0()), "yyyy"))) {
                    pbCommenFloorItemViewHolder.j.setText(StringHelper.getFormatTimeShort(postData.f0()));
                } else {
                    pbCommenFloorItemViewHolder.j.setText(StringHelper.getFormatTime(postData.f0()));
                }
                if (!z2) {
                    pbCommenFloorItemViewHolder.m.setVisibility(0);
                    pbCommenFloorItemViewHolder.m.setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds14), 0, 0, 0);
                    pbCommenFloorItemViewHolder.m.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f150b) + str);
                } else if (z3) {
                    pbCommenFloorItemViewHolder.m.setVisibility(0);
                    pbCommenFloorItemViewHolder.m.setPadding(this.a, 0, 0, 0);
                    if (postData.a0) {
                        pbCommenFloorItemViewHolder.m.setText(StringHelper.cutStringWithSuffix(S.b(), 7, StringHelper.STRING_MORE));
                    } else {
                        pbCommenFloorItemViewHolder.m.setText(S.b());
                    }
                } else {
                    pbCommenFloorItemViewHolder.m.setVisibility(8);
                }
                TextView textView = pbCommenFloorItemViewHolder.k0;
                textView.setText(((Object) pbCommenFloorItemViewHolder.j.getText()) + "  • ");
            }
        }
        z2 = false;
        j45 S2 = postData.S();
        if (S2 != null) {
        }
        if (!z) {
        }
        if (z3) {
        }
        pbCommenFloorItemViewHolder.l.setVisibility(0);
        i3 = this.a;
        pbCommenFloorItemViewHolder.j.setPadding(i2, 0, i3, 0);
        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.f0()), "yyyy"))) {
        }
        if (!z2) {
        }
        TextView textView2 = pbCommenFloorItemViewHolder.k0;
        textView2.setText(((Object) pbCommenFloorItemViewHolder.j.getText()) + "  • ");
    }

    public final void K(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        pbCommenFloorItemViewHolder.c0.setVisibility(postData.a0 ? 0 : 8);
    }

    public final void L(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048585, this, pbCommenFloorItemViewHolder, postData, view2, i2) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        pbCommenFloorItemViewHolder.z.setVisibility(8);
        pbCommenFloorItemViewHolder.t.setVisibility(0);
        pbCommenFloorItemViewHolder.j0.setVisibility(8);
        pbCommenFloorItemViewHolder.x.setVisibility(8);
        pbCommenFloorItemViewHolder.y.setVisibility(8);
        pbCommenFloorItemViewHolder.n.setVisibility(8);
        pbCommenFloorItemViewHolder.r0.setVisibility(8);
        U(pbCommenFloorItemViewHolder, postData, view2, i2);
        H(pbCommenFloorItemViewHolder, postData);
        M(pbCommenFloorItemViewHolder, postData);
        P(pbCommenFloorItemViewHolder, postData, view2);
        O(pbCommenFloorItemViewHolder, postData, view2, i2);
        I(pbCommenFloorItemViewHolder, postData);
        R(pbCommenFloorItemViewHolder, postData);
        N(pbCommenFloorItemViewHolder, postData);
        S(pbCommenFloorItemViewHolder, postData);
        xw7.c(pbCommenFloorItemViewHolder, postData, view2, this.s);
        K(pbCommenFloorItemViewHolder, postData);
        Q(pbCommenFloorItemViewHolder, postData);
        T(pbCommenFloorItemViewHolder, postData);
        xw7.j(pbCommenFloorItemViewHolder, view2, postData, this.p, true);
    }

    public final void M(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048586, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || postData == null || postData.q() == null) {
            return;
        }
        postData.q().objType = 1;
        postData.q().isInPost = true;
        ThreadData threadData = null;
        jv7 jv7Var = this.i;
        if (jv7Var != null && jv7Var.O() != null) {
            threadData = this.i.O();
            postData.q().threadId = threadData.getTid();
            postData.q().forumId = String.valueOf(threadData.getFid());
        }
        if (threadData != null && threadData.isUgcThreadType()) {
            pbCommenFloorItemViewHolder.n.setAgreeAlone(true);
        }
        pbCommenFloorItemViewHolder.n.setThreadData(threadData);
        pbCommenFloorItemViewHolder.n.setData(postData.q());
        pbCommenFloorItemViewHolder.h0.setThreadData(threadData);
        pbCommenFloorItemViewHolder.h0.setData(postData.q());
    }

    public final void N(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        AlaLiveInfoCoreData alaLiveInfoCoreData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || pbCommenFloorItemViewHolder.V == null || pbCommenFloorItemViewHolder.S == null) {
            return;
        }
        if (postData != null && (alaLiveInfoCoreData = postData.S) != null && !StringUtils.isNull(alaLiveInfoCoreData.liveTitle)) {
            pbCommenFloorItemViewHolder.V.setText(postData.S.liveTitle);
            pbCommenFloorItemViewHolder.S.setTag(postData.S);
            pbCommenFloorItemViewHolder.S.setVisibility(0);
            StatisticItem statisticItem = new StatisticItem("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(statisticItem);
            return;
        }
        pbCommenFloorItemViewHolder.S.setVisibility(8);
    }

    public final void O(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048588, this, pbCommenFloorItemViewHolder, postData, view2, i2) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
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
            sparseArray.put(R.id.obfuscated_res_0x7f09205a, postData);
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
            sparseArray2.put(R.id.obfuscated_res_0x7f09205a, postData);
        }
        if (this.i != null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_FLOOR_COMPLAINT);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("fid", this.i.m());
            statisticItem.param("fname", this.i.n());
            statisticItem.param("tid", this.i.Q());
            statisticItem.param("pid", postData.L());
            TiebaStatic.log(statisticItem);
        }
        if (pbCommenFloorItemViewHolder.a0 != null) {
            PbFloorComplaint pbFloorComplaint = (PbFloorComplaint) view2.findViewById(R.id.obfuscated_res_0x7f09180a);
            pbCommenFloorItemViewHolder.a0 = pbFloorComplaint;
            pbCommenFloorItemViewHolder.b0 = Boolean.TRUE;
            pbFloorComplaint.setRemindText(postData.E());
            pbCommenFloorItemViewHolder.a0.setRemindIcon(postData.E());
            if (postData.E() == 0) {
                pbCommenFloorItemViewHolder.a0.setVisibility(8);
            } else {
                pbCommenFloorItemViewHolder.a0.setVisibility(0);
                if (this.i != null) {
                    StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_FLOOR_COMPLAINT_SHOW);
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem2.param("fid", this.i.m());
                    statisticItem2.param("fname", this.i.n());
                    statisticItem2.param("tid", this.i.Q());
                    statisticItem2.param("pid", postData.L());
                    statisticItem2.param("obj_type", postData.E());
                    TiebaStatic.log(statisticItem2);
                }
            }
            pbCommenFloorItemViewHolder.a0.setAmendIconListener(new c(this, postData.D(), postData));
        }
        ImageView imageView2 = pbCommenFloorItemViewHolder.y;
        if (imageView2 != null) {
            SparseArray sparseArray3 = (SparseArray) imageView2.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                pbCommenFloorItemViewHolder.y.setTag(sparseArray3);
            }
            sparseArray3.put(R.id.obfuscated_res_0x7f09205a, postData);
        }
        pbCommenFloorItemViewHolder.v.setVisibility(8);
        if (!postData.o0() && !postData.n0(false)) {
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
            if (this.l == null) {
                s18 s18Var = new s18(this.mContext);
                this.l = s18Var;
                s18Var.f(this.j);
                this.l.h(this.c);
                this.l.e(this.d);
                String str = null;
                jv7 jv7Var = this.i;
                if (jv7Var != null && jv7Var.O() != null && this.i.O().getAuthor() != null) {
                    str = this.i.O().getAuthor().getUserId();
                }
                boolean z = true;
                z = (str == null || !str.equals(TbadkCoreApplication.getCurrentAccount())) ? false : false;
                jv7 jv7Var2 = this.i;
                if (jv7Var2 != null) {
                    this.l.j(jv7Var2.W(), z);
                    this.l.i(this.i.O());
                }
            }
            this.l.g(postData.L());
            pbCommenFloorItemViewHolder.u.setSubPbAdapter(this.l);
            pbCommenFloorItemViewHolder.u.setVisibility(0);
            pbCommenFloorItemViewHolder.u.setData(postData, view2);
            pbCommenFloorItemViewHolder.u.setChildOnClickListener(this.d);
            pbCommenFloorItemViewHolder.u.setChildOnLongClickListener(this.g);
            pbCommenFloorItemViewHolder.u.setChildOnTouchListener(this.s);
        }
        if (postData.O) {
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
        pbCommenFloorItemViewHolder.l0.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ffe));
    }

    public final void P(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048589, this, pbCommenFloorItemViewHolder, postData, view2) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
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
        pbCommenFloorItemViewHolder.p.k0(null);
        pbCommenFloorItemViewHolder.p.setBackgroundDrawable(null);
        pbCommenFloorItemViewHolder.p.getLayoutStrategy().g(R.drawable.obfuscated_res_0x7f081241);
        pbCommenFloorItemViewHolder.p.getLayoutStrategy().x(R.drawable.pic_video);
        C(pbCommenFloorItemViewHolder.p, view2, !StringUtils.isNull(postData.t()), layoutParams.leftMargin + layoutParams.rightMargin);
        pbCommenFloorItemViewHolder.q.setLayoutParams(layoutParams);
        pbCommenFloorItemViewHolder.p.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        pbCommenFloorItemViewHolder.p.setIsFromCDN(this.j);
        pbCommenFloorItemViewHolder.p.setText(postData.W(), true, this.o);
        SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.p.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        sparseArray.put(R.id.obfuscated_res_0x7f09203d, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f092056, Boolean.FALSE);
        pbCommenFloorItemViewHolder.p.setTag(sparseArray);
        pbCommenFloorItemViewHolder.r.setTag(sparseArray);
        pbCommenFloorItemViewHolder.b.setTag(R.id.obfuscated_res_0x7f092050, sparseArray);
        pbCommenFloorItemViewHolder.r0.setTag(sparseArray);
        pbCommenFloorItemViewHolder.i0.setTag(sparseArray);
    }

    public final void Q(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || (view2 = pbCommenFloorItemViewHolder.b) == null) {
            return;
        }
        SkinManager.setBackgroundColor(view2, R.color.CAM_X0205);
    }

    public final void R(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, pbCommenFloorItemViewHolder, postData) == null) {
            if (postData != null && postData.c0() != null) {
                TbRichText W = postData.W();
                q38.c(postData.c0(), pbCommenFloorItemViewHolder.P, pbCommenFloorItemViewHolder.Q, pbCommenFloorItemViewHolder.R, false, false, W != null && StringUtils.isNull(W.toString()) && StringUtils.isNull(postData.t()));
                return;
            }
            pbCommenFloorItemViewHolder.P.setVisibility(8);
            pbCommenFloorItemViewHolder.Q.setVisibility(8);
        }
    }

    public final void S(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, pbCommenFloorItemViewHolder, postData) == null) {
            if (postData.G() != 2 && postData.G() != 4) {
                pbCommenFloorItemViewHolder.Y.setVisibility(8);
                pbCommenFloorItemViewHolder.X.setVisibility(0);
                E(false, pbCommenFloorItemViewHolder, postData);
                return;
            }
            pbCommenFloorItemViewHolder.Y.setOnClickListener(new a(this, pbCommenFloorItemViewHolder, postData));
            pbCommenFloorItemViewHolder.Y.setVisibility(0);
            D(pbCommenFloorItemViewHolder, postData.r0(), postData.F());
            E(true, pbCommenFloorItemViewHolder, postData);
        }
    }

    public final void T(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048593, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        pbCommenFloorItemViewHolder.f(postData.R, postData.L(), false);
    }

    /* JADX WARN: Removed duplicated region for block: B:231:0x0674  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x067f  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0688  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x06cb  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x06d5  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x073b  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0745  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0784  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void U(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view2, int i2) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048594, this, pbCommenFloorItemViewHolder, postData, view2, i2) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        if (postData.s() != null) {
            postData.s().isBaijiahaoUser();
        }
        if (postData.Q) {
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
            String str = this.h;
            if (str != null && !str.equals("0") && this.h.equals(postData.s().getUserId())) {
                pbCommenFloorItemViewHolder.p.setIsHost(true);
            }
            ArrayList<IconData> iconInfo = postData.s().getIconInfo();
            ArrayList<IconData> tShowInfoNew = postData.s().getTShowInfoNew();
            UserIconBox userIconBox = pbCommenFloorItemViewHolder.M;
            if (userIconBox != null) {
                userIconBox.setTag(R.id.obfuscated_res_0x7f092092, postData.s().getUserId());
                q08 q08Var = this.m;
                if (q08Var != null) {
                    pbCommenFloorItemViewHolder.M.setOnClickListener(q08Var.c);
                }
                int f2 = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                int f3 = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                UserIconBox userIconBox2 = pbCommenFloorItemViewHolder.M;
                i3 = R.id.obfuscated_res_0x7f092092;
                userIconBox2.g(iconInfo, 2, f2, f2, f3);
            } else {
                i3 = R.id.obfuscated_res_0x7f092092;
            }
            if (pbCommenFloorItemViewHolder.L != null) {
                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                    pbCommenFloorItemViewHolder.L.setTag(tShowInfoNew.get(0).getUrl());
                }
                q08 q08Var2 = this.m;
                if (q08Var2 != null) {
                    pbCommenFloorItemViewHolder.L.setOnClickListener(q08Var2.e);
                }
                int f4 = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                pbCommenFloorItemViewHolder.L.h(tShowInfoNew, 3, f4, f4, ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
            }
            if (ListUtils.isEmpty(tShowInfoNew) && !postData.s().isBigV()) {
                if (UbsABTestHelper.isPBPlanA()) {
                    if (DeviceInfoUtil.isMate30()) {
                        lz7.m(pbCommenFloorItemViewHolder.f);
                    } else {
                        hv4.d(pbCommenFloorItemViewHolder.f).A(R.string.F_X02);
                    }
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f, R.color.CAM_X0108, 1);
                } else {
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f, R.color.CAM_X0107, 1);
                }
            } else {
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f, R.color.CAM_X0301, 1);
            }
            String avater = postData.s().getAvater();
            int i4 = postData.b0 ? 2 : 8;
            pbCommenFloorItemViewHolder.f.setTag(i3, postData.s().getUserId());
            pbCommenFloorItemViewHolder.f.setTag(R.id.obfuscated_res_0x7f09209a, postData.s().getUserName());
            pbCommenFloorItemViewHolder.f.setTag(R.id.obfuscated_res_0x7f09209c, postData.s().getVirtualUserUrl());
            pbCommenFloorItemViewHolder.f.setTag(R.id.obfuscated_res_0x7f092088, j28.i(this.i, postData, postData.c0, i4, 2));
            String name_show = postData.s().getName_show();
            String userName = postData.s().getUserName();
            if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                pbCommenFloorItemViewHolder.f.setText(ju7.b(this.mContext, pbCommenFloorItemViewHolder.f.getText().toString()));
                pbCommenFloorItemViewHolder.f.setGravity(16);
                pbCommenFloorItemViewHolder.f.setTag(R.id.obfuscated_res_0x7f092067, ju7.a());
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
                jv7 jv7Var = this.i;
                pbCommenFloorItemViewHolder.K.getHeadView().setFid(jv7Var != null ? jv7Var.m() : "");
                jv7 jv7Var2 = this.i;
                pbCommenFloorItemViewHolder.K.getHeadView().setFName(jv7Var2 != null ? jv7Var2.n() : "");
                pbCommenFloorItemViewHolder.K.getHeadView().setFloor(postData.C());
                pbCommenFloorItemViewHolder.K.getHeadView().setTid(postData.L());
                pbCommenFloorItemViewHolder.K.getHeadView().setTag(R.id.obfuscated_res_0x7f092088, j28.i(this.i, postData, postData.c0, i4, 2));
                pbCommenFloorItemViewHolder.K.m(postData.s().getPendantData().getImgUrl());
            } else {
                pbCommenFloorItemViewHolder.o.setGodIconWidth(R.dimen.tbds36);
                UtilHelper.showHeadImageViewBigV(pbCommenFloorItemViewHolder.o, postData.s(), 4);
                pbCommenFloorItemViewHolder.o.setUserId(postData.s().getUserId());
                jv7 jv7Var3 = this.i;
                pbCommenFloorItemViewHolder.o.setFid(jv7Var3 != null ? jv7Var3.m() : "");
                jv7 jv7Var4 = this.i;
                pbCommenFloorItemViewHolder.o.setFName(jv7Var4 != null ? jv7Var4.n() : "");
                pbCommenFloorItemViewHolder.o.setFloor(postData.C());
                pbCommenFloorItemViewHolder.o.setTid(postData.L());
                pbCommenFloorItemViewHolder.o.setUserName(postData.s().getUserName(), postData.h0());
                pbCommenFloorItemViewHolder.o.setTag(R.id.obfuscated_res_0x7f09209c, postData.s().getVirtualUserUrl());
                pbCommenFloorItemViewHolder.o.setTag(R.id.obfuscated_res_0x7f092088, j28.i(this.i, postData, postData.c0, i4, 2));
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
            j0(pbCommenFloorItemViewHolder.h, postData);
        }
        int level_id = postData.s().getLevel_id();
        jv7 jv7Var5 = this.i;
        if (jv7Var5 != null && jv7Var5.i0()) {
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
                pbCommenFloorItemViewHolder.J.setVisibility(8);
            }
        }
        int e2 = lz7.e();
        String name_show2 = postData.s() != null ? postData.s().getName_show() : "";
        int d2 = ji5.d(name_show2);
        if (postData.s() != null && !StringUtils.isNull(postData.s().getSealPrefix())) {
            int i6 = e2 - 2;
            if (d2 > i6) {
                name_show2 = ji5.n(name_show2, i6) + StringHelper.STRING_MORE;
            }
        } else if (d2 > e2) {
            name_show2 = ji5.n(name_show2, e2) + StringHelper.STRING_MORE;
        }
        if (postData.s() != null && !StringUtils.isNull(postData.s().getSealPrefix())) {
            pbCommenFloorItemViewHolder.f.setText(W(postData.s().getSealPrefix(), name_show2));
        } else {
            pbCommenFloorItemViewHolder.f.setText(name_show2);
            pbCommenFloorItemViewHolder.e.post(new b(this, pbCommenFloorItemViewHolder, name_show2));
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.obfuscated_res_0x7f09203d, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f09205a, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f09205c, view2);
        sparseArray.put(R.id.obfuscated_res_0x7f09206b, Integer.valueOf(i2));
        sparseArray.put(R.id.obfuscated_res_0x7f09206a, Integer.valueOf(postData.C()));
        sparseArray.put(R.id.obfuscated_res_0x7f09204d, postData.L());
        sparseArray.put(R.id.obfuscated_res_0x7f0917ef, pbCommenFloorItemViewHolder.n);
        sparseArray.put(R.id.obfuscated_res_0x7f0917f0, pbCommenFloorItemViewHolder.h0);
        sparseArray.put(R.id.obfuscated_res_0x7f0917ed, pbCommenFloorItemViewHolder.x);
        sparseArray.put(R.id.obfuscated_res_0x7f0917ee, pbCommenFloorItemViewHolder.y);
        jv7 jv7Var6 = this.i;
        if (jv7Var6 != null && jv7Var6.O() != null) {
            threadData = this.i.O();
        }
        if (threadData != null && threadData.isUgcThreadType()) {
            sparseArray.put(R.id.obfuscated_res_0x7f0917ec, Boolean.TRUE);
        } else {
            sparseArray.put(R.id.obfuscated_res_0x7f0917ec, Boolean.FALSE);
        }
        boolean z7 = (postData.s() == null || StringUtils.isNull(postData.s().getVirtualUserUrl())) ? false : true;
        jv7 jv7Var7 = this.i;
        if (jv7Var7 == null || jv7Var7.W() == 0 || Y()) {
            z = false;
            z2 = false;
            z3 = false;
        } else {
            z = (this.i.W() == 1002 || this.i.W() == 3) ? false : true;
            if (this.i.W() == 3 || this.i.i0()) {
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
        jv7 jv7Var8 = this.i;
        if (jv7Var8 != null && jv7Var8.O() != null && this.i.O().getAuthor() != null && postData.s() != null) {
            String userId2 = this.i.O().getAuthor().getUserId();
            String userId3 = postData.s().getUserId();
            if (UtilHelper.isCurrentAccount(userId2)) {
                if (UtilHelper.isCurrentAccount(userId3)) {
                    z4 = false;
                    z2 = true;
                    z5 = true;
                } else {
                    z4 = true;
                    z2 = true;
                    z5 = false;
                }
                z6 = true;
                if (postData != null && postData.s() != null && UtilHelper.isCurrentAccount(postData.s().getUserId())) {
                    z2 = true;
                    z5 = true;
                }
                if (z7) {
                    z = false;
                    z4 = false;
                    z2 = false;
                }
                int i7 = postData.C() != 1 ? 1 : 0;
                if (!z) {
                    sparseArray.put(R.id.obfuscated_res_0x7f092085, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f09205d, Integer.valueOf(this.i.W()));
                    if (postData.s() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f09204a, postData.s().getUserName());
                        sparseArray.put(R.id.obfuscated_res_0x7f09204b, postData.s().getName_show());
                        sparseArray.put(R.id.obfuscated_res_0x7f09204c, postData.s().getPortrait());
                    }
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f092085, Boolean.FALSE);
                }
                if (!z4) {
                    sparseArray.put(R.id.obfuscated_res_0x7f092099, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f092054, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.s() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f092095, postData.s().getUserId());
                        sparseArray.put(R.id.obfuscated_res_0x7f092096, postData.s().getUserName());
                        sparseArray.put(R.id.obfuscated_res_0x7f092094, postData.s().getName_show());
                    }
                    if (this.i.O() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f092098, this.i.O().getId());
                    }
                    sparseArray.put(R.id.obfuscated_res_0x7f092097, postData.L());
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f092099, Boolean.FALSE);
                }
                if (!z2) {
                    sparseArray.put(R.id.obfuscated_res_0x7f092083, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f092051, Boolean.valueOf(postData.o0()));
                    sparseArray.put(R.id.obfuscated_res_0x7f09205d, Integer.valueOf(this.i.W()));
                    sparseArray.put(R.id.obfuscated_res_0x7f092040, Boolean.valueOf(z5));
                    sparseArray.put(R.id.obfuscated_res_0x7f092041, Integer.valueOf(i7));
                    sparseArray.put(R.id.obfuscated_res_0x7f09203f, postData.L());
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f092083, Boolean.FALSE);
                }
                sparseArray.put(R.id.obfuscated_res_0x7f09205e, Boolean.valueOf(z3));
                sparseArray.put(R.id.obfuscated_res_0x7f092055, Boolean.valueOf(z6));
                pbCommenFloorItemViewHolder.p.setTag(sparseArray);
                pbCommenFloorItemViewHolder.r.setTag(sparseArray);
            }
        }
        z4 = false;
        z5 = false;
        z6 = false;
        if (postData != null) {
            z2 = true;
            z5 = true;
        }
        if (z7) {
        }
        if (postData.C() != 1) {
        }
        if (!z) {
        }
        if (!z4) {
        }
        if (!z2) {
        }
        sparseArray.put(R.id.obfuscated_res_0x7f09205e, Boolean.valueOf(z3));
        sparseArray.put(R.id.obfuscated_res_0x7f092055, Boolean.valueOf(z6));
        pbCommenFloorItemViewHolder.p.setTag(sparseArray);
        pbCommenFloorItemViewHolder.r.setTag(sparseArray);
    }

    public int V(int i2) {
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

    public final SpannableStringBuilder W(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, str, str2)) == null) {
            ArrayList arrayList = new ArrayList();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (str2 == null || str == null) {
                return spannableStringBuilder;
            }
            arrayList.add(new t16.a(str, R.drawable.pic_smalldot_title));
            return t16.h(this.mContext, str2, arrayList, true);
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public final String X(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, view2)) == null) {
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

    public final boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            jv7 jv7Var = this.i;
            if (jv7Var == null || jv7Var.O() == null) {
                return false;
            }
            return this.i.O().isBlocked();
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: Z */
    public PbCommenFloorItemViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d06e3, viewGroup, false);
            ((ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f09186e)).addView(LayoutInflater.from(inflate.getContext()).inflate(R.layout.obfuscated_res_0x7f0d06db, (ViewGroup) null));
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = new PbCommenFloorItemViewHolder(this.b, inflate, 0);
            pbCommenFloorItemViewHolder.s.setConstrainLayoutPool(this.q);
            pbCommenFloorItemViewHolder.s.setImageViewPool(this.r);
            SubPbLayout subPbLayout = pbCommenFloorItemViewHolder.u;
            if (subPbLayout != null) {
                subPbLayout.setShowChildComment(true);
                pbCommenFloorItemViewHolder.u.setIsVideoThread(false);
            }
            h0(pbCommenFloorItemViewHolder);
            return pbCommenFloorItemViewHolder;
        }
        return (PbCommenFloorItemViewHolder) invokeL.objValue;
    }

    public View a0(int i2, View view2, ViewGroup viewGroup, PostData postData, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, postData, pbCommenFloorItemViewHolder})) == null) {
            h0(pbCommenFloorItemViewHolder);
            b0(pbCommenFloorItemViewHolder);
            B(pbCommenFloorItemViewHolder);
            PostData postData2 = (PostData) getItem(i2);
            if (postData2 != null) {
                postData2.c0 = i2 + 1;
                postData2.i1();
                G(postData2);
                L(pbCommenFloorItemViewHolder, postData2, view2, i2);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void b0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.b.setOnTouchListener(this.s);
            pbCommenFloorItemViewHolder.b.setOnLongClickListener(this.g);
            pbCommenFloorItemViewHolder.f.setOnClickListener(this.m.b);
            pbCommenFloorItemViewHolder.o.setOnClickListener(this.m.b);
            pbCommenFloorItemViewHolder.K.setOnClickListener(this.m.b);
            pbCommenFloorItemViewHolder.K.getHeadView().setOnClickListener(this.m.b);
            pbCommenFloorItemViewHolder.p.setOnLongClickListener(this.g);
            pbCommenFloorItemViewHolder.p.setOnTouchListener(this.s);
            pbCommenFloorItemViewHolder.p.setCommonTextViewOnClickListener(this.d);
            pbCommenFloorItemViewHolder.p.setOnImageClickListener(this.e);
            pbCommenFloorItemViewHolder.p.setOnImageTouchListener(this.s);
            pbCommenFloorItemViewHolder.p.setOnEmotionClickListener(this.m.f);
            pbCommenFloorItemViewHolder.p.setOnVoiceAfterClickListener(this.d);
            pbCommenFloorItemViewHolder.P.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.Q.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.S.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.v.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.w.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.q0.setOnTouchListener(this.s);
            pbCommenFloorItemViewHolder.q0.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.m0.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.i0.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.r0.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.j0.setOnClickListener(new g(this, pbCommenFloorItemViewHolder));
            pbCommenFloorItemViewHolder.b.setOnClickListener(new h(this, pbCommenFloorItemViewHolder));
            pbCommenFloorItemViewHolder.x.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.y.setOnClickListener(new i(this, pbCommenFloorItemViewHolder));
            pbCommenFloorItemViewHolder.n.x = new j(this, pbCommenFloorItemViewHolder);
            pbCommenFloorItemViewHolder.h0.x = new k(this, pbCommenFloorItemViewHolder);
        }
    }

    public void c0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.p = z;
        }
    }

    public void d(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, onLongClickListener) == null) {
            this.g = onLongClickListener;
        }
    }

    public void d0(q08 q08Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, q08Var) == null) {
            this.m = q08Var;
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, onClickListener) == null) {
            this.d = onClickListener;
        }
    }

    public void e0(s08 s08Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, s08Var) == null) {
            this.n = s08Var;
        }
    }

    public void f0(lw7 lw7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, lw7Var) == null) {
            this.f = lw7Var;
        }
    }

    public void g0(TbRichTextView.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, sVar) == null) {
            this.o = sVar;
        }
    }

    public final void h0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048609, this, pbCommenFloorItemViewHolder) == null) || pbCommenFloorItemViewHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (pbCommenFloorItemViewHolder.a != skinType) {
            i0(pbCommenFloorItemViewHolder.h);
            if (UbsABTestHelper.isPBPlanA()) {
                if (DeviceInfoUtil.isMate30()) {
                    lz7.m(pbCommenFloorItemViewHolder.f);
                } else {
                    hv4.d(pbCommenFloorItemViewHolder.f).A(R.string.F_X02);
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
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.k0, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.l0, R.color.CAM_X0107, 1);
            SkinManager.setBackgroundShapeDrawable(pbCommenFloorItemViewHolder.u, ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds21), R.color.CAM_X0206, R.color.CAM_X0206);
            SkinManager.getColor(R.color.CAM_X0107);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.v, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.v, (int) R.color.CAM_X0304);
            pbCommenFloorItemViewHolder.v.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right, SkinManager.getColor(R.color.CAM_X0304), null), (Drawable) null);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.x, R.drawable.obfuscated_res_0x7f0809aa, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.y, R.drawable.obfuscated_res_0x7f0809ab, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbCommenFloorItemViewHolder.u.d();
            pbCommenFloorItemViewHolder.s.b();
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.V, R.color.CAM_X0304, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.T, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.S, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.U, R.color.CAM_X0109);
            SkinManager.setImageResource(pbCommenFloorItemViewHolder.W, R.drawable.icon_arrow_more_gray);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.Z, (int) R.color.CAM_X0107);
            if (pbCommenFloorItemViewHolder.X.getVisibility() == 8) {
                pbCommenFloorItemViewHolder.Z.setText(R.string.obfuscated_res_0x7f0f03fb);
            } else {
                jv7 jv7Var = this.i;
                if (jv7Var != null && StringUtils.isNull(jv7Var.k())) {
                    pbCommenFloorItemViewHolder.Z.setText(this.i.k());
                } else {
                    pbCommenFloorItemViewHolder.Z.setText(R.string.obfuscated_res_0x7f0f05e6);
                }
            }
            pbCommenFloorItemViewHolder.n.L(TbadkCoreApplication.getInst().getSkinType());
            pbCommenFloorItemViewHolder.c(skinType);
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.O, R.color.CAM_X0203);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.i0, R.drawable.obfuscated_res_0x7f080985, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.r0, R.drawable.obfuscated_res_0x7f080985, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbCommenFloorItemViewHolder.b();
        }
        pbCommenFloorItemViewHolder.a = skinType;
    }

    public final void i0(TextView textView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048610, this, textView) == null) || textView == null) {
            return;
        }
        Object tag = textView.getTag();
        if (tag instanceof PostData) {
            j0(textView, (PostData) tag);
        }
    }

    public final void j0(TextView textView, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048611, this, textView, postData) == null) {
            if (textView == null && postData == null) {
                return;
            }
            textView.setTag(postData);
            if (postData.s() != null) {
                MetaData s = postData.s();
                String str = this.h;
                if (str != null && !str.equals("0") && this.h.equals(s.getUserId())) {
                    textView.setVisibility(0);
                    textView.setAlpha(1.0f);
                    textView.setText(R.string.obfuscated_res_0x7f0f087d);
                    textView.setBackgroundColor(0);
                    hv4 d2 = hv4.d(textView);
                    d2.n(R.string.J_X04);
                    d2.l(R.dimen.L_X01);
                    d2.v(R.color.CAM_X0302);
                    d2.k(R.color.CAM_X0302);
                    return;
                } else if (s.getIs_bawu() == 1 && postData.p0()) {
                    hv4 d3 = hv4.d(textView);
                    d3.v(R.color.CAM_X0101);
                    d3.n(R.string.J_X04);
                    d3.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f0346);
                    return;
                } else if (s.getIs_bawu() == 1 && "manager".equals(s.getBawu_type())) {
                    hv4 d4 = hv4.d(textView);
                    d4.v(R.color.CAM_X0101);
                    d4.n(R.string.J_X04);
                    d4.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f02ff);
                    return;
                } else if (s.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(s.getBawu_type())) {
                    hv4 d5 = hv4.d(textView);
                    d5.v(R.color.CAM_X0101);
                    d5.n(R.string.J_X04);
                    d5.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f0300);
                    return;
                } else if (s.getIs_bawu() == 1 && "pri_content_assist".equals(s.getBawu_type())) {
                    hv4 d6 = hv4.d(textView);
                    d6.v(R.color.CAM_X0101);
                    d6.n(R.string.J_X04);
                    d6.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f02fc);
                    return;
                } else if (s.getIs_bawu() == 1 && "pri_manage_assist".equals(s.getBawu_type())) {
                    hv4 d7 = hv4.d(textView);
                    d7.v(R.color.CAM_X0101);
                    d7.n(R.string.J_X04);
                    d7.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f02fd);
                    return;
                } else {
                    textView.setVisibility(8);
                    return;
                }
            }
            textView.setVisibility(8);
        }
    }

    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, onClickListener) == null) {
            this.c = onClickListener;
        }
    }

    public void n(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, yVar) == null) {
            this.e = yVar;
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, str) == null) {
            this.h = str;
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.baidu.tieba.qn
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i2, View view2, ViewGroup viewGroup, PostData postData, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        a0(i2, view2, viewGroup, postData, pbCommenFloorItemViewHolder);
        return view2;
    }

    public void r(jv7 jv7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, jv7Var) == null) {
            this.i = jv7Var;
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            this.j = z;
        }
    }
}

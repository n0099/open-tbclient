package com.baidu.tieba;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
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
import com.baidu.tieba.gg9;
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.tieba.pb.pb.main.PbFloorComplaint;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.qk9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class ch9 extends ln<yca, PbCommenFloorItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public TbPageContext b;
    public View.OnClickListener c;
    public View.OnClickListener d;
    public TbRichTextView.z e;
    public gg9 f;
    public View.OnLongClickListener g;
    public String h;
    public ze9 i;
    public boolean j;
    public SparseIntArray k;
    public gm9 l;
    public ok9 m;
    public qk9 n;
    public TbRichTextView.t o;
    public boolean p;
    public ng<ConstrainImageLayout> q;
    public ng<TbImageView> r;
    public gg9 s;

    /* loaded from: classes5.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ ch9 b;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ yca a;
            public final /* synthetic */ i b;

            public a(i iVar, yca ycaVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar, ycaVar};
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
                this.a = ycaVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    qk9.b bVar = this.b.b.n.b;
                    i iVar = this.b;
                    bVar.a(iVar.b.i, null, this.a, iVar.a.r.getLayoutStrategy());
                }
            }
        }

        public i(ch9 ch9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ch9Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ch9Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            yca ycaVar;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !(view2.getTag() instanceof SparseArray)) {
                return;
            }
            SparseArray sparseArray = (SparseArray) view2.getTag();
            if ((sparseArray.get(R.id.tag_load_sub_data) instanceof yca) && (ycaVar = (yca) sparseArray.get(R.id.tag_load_sub_data)) != null && this.a.c != null && this.b.n != null) {
                zg.a().postDelayed(new a(this, ycaVar), 100L);
                String P = this.b.i.P();
                if ((StringUtils.isNull(P) || "0".equals(this.b.i.P())) && this.b.i.N() != null) {
                    P = this.b.i.N().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", P).param("fid", this.b.i.l()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", ycaVar.S()).param("obj_source", this.b.Y(view2)).param("obj_type", 4));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ yca b;
        public final /* synthetic */ ch9 c;

        public a(ch9 ch9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, yca ycaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ch9Var, pbCommenFloorItemViewHolder, ycaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ch9Var;
            this.a = pbCommenFloorItemViewHolder;
            this.b = ycaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.S.getVisibility() == 8) {
                    z = true;
                } else {
                    z = false;
                }
                this.c.F(this.a, !z, this.b.L());
                this.b.a1(!z);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ String b;

        public b(ch9 ch9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ch9Var, pbCommenFloorItemViewHolder, str};
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
                arrayList.add(this.a.G);
                arrayList.add(this.a.i);
                arrayList.add(this.a.j);
                arrayList.add(this.a.y0);
                arrayList.add(this.a.E);
                String str = this.b;
                PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = this.a;
                iz5.c(measuredWidth, str, pbCommenFloorItemViewHolder.g, pbCommenFloorItemViewHolder.E, arrayList, pbCommenFloorItemViewHolder.H);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ yca b;
        public final /* synthetic */ ch9 c;

        public c(ch9 ch9Var, String str, yca ycaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ch9Var, str, ycaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ch9Var;
            this.a = str;
            this.b = ycaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a != null) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean(WebViewActivityConfig.TAG_FIX_TITLE, true);
                    nx4.y(this.c.b.getPageActivity(), "", this.a, false, true, true, bundle);
                }
                if (this.c.i != null) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_FLOOR_COMPLAINT_CLICK);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("fid", this.c.i.l());
                    statisticItem.param("fname", this.c.i.m());
                    statisticItem.param("tid", this.c.i.P());
                    statisticItem.param("pid", this.b.S());
                    statisticItem.param("obj_type", this.b.K());
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements og<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ch9 a;

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

        public d(ch9 ch9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ch9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ch9Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.og
        public /* bridge */ /* synthetic */ ConstrainImageLayout a(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            e(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.og
        public /* bridge */ /* synthetic */ ConstrainImageLayout c(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            h(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.og
        /* renamed from: f */
        public void b(ConstrainImageLayout constrainImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, constrainImageLayout) == null) {
                constrainImageLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.og
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
    public class e implements og<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ch9 a;

        public TbImageView e(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbImageView)) == null) ? tbImageView : (TbImageView) invokeL.objValue;
        }

        public e(ch9 ch9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ch9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ch9Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.og
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.og
        public /* bridge */ /* synthetic */ TbImageView c(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            h(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.og
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
        @Override // com.baidu.tieba.og
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
    public class f implements gg9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ch9 a;

        @Override // com.baidu.tieba.gg9.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        public f(ch9 ch9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ch9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ch9Var;
        }

        @Override // com.baidu.tieba.gg9.a
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

        @Override // com.baidu.tieba.gg9.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                if (view2 == null || view2.getId() == R.id.obfuscated_res_0x7f090b60) {
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

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;

        public g(ch9 ch9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ch9Var, pbCommenFloorItemViewHolder};
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
                this.a.z.performClick();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ ch9 b;

        public h(ch9 ch9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ch9Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ch9Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.b.i != null && (pbCommenFloorItemViewHolder = this.a) != null && (agreeView = pbCommenFloorItemViewHolder.d0) != null && agreeView.getData() != null) {
                String P = this.b.i.P();
                if ((StringUtils.isNull(P) || "0".equals(this.b.i.P())) && this.b.i.N() != null) {
                    P = this.b.i.N().getNid();
                }
                TiebaStatic.log(new StatisticItem("c14442").param("tid", P).param("fname", this.b.i.m()).param("fid", this.b.i.l()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.d0.getData().postId));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ ch9 b;

        public j(ch9 ch9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ch9Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ch9Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.b.i != null && (pbCommenFloorItemViewHolder = this.a) != null && (agreeView = pbCommenFloorItemViewHolder.p) != null && agreeView.getData() != null) {
                if (view2 == this.a.p.getImgAgree()) {
                    i = 1;
                } else {
                    i = 2;
                }
                String P = this.b.i.P();
                if ((StringUtils.isNull(P) || "0".equals(this.b.i.P())) && this.b.i.N() != null) {
                    P = this.b.i.N().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", P).param("fid", this.b.i.l()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.p.getData().postId).param("obj_source", this.b.Y(this.a.p)).param("obj_type", i));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ ch9 b;

        public k(ch9 ch9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ch9Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ch9Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.b.i != null && (pbCommenFloorItemViewHolder = this.a) != null && (agreeView = pbCommenFloorItemViewHolder.d0) != null && agreeView.getData() != null) {
                if (view2 == this.a.d0.getImgAgree()) {
                    i = 1;
                } else {
                    i = 2;
                }
                String P = this.b.i.P();
                if ((StringUtils.isNull(P) || "0".equals(this.b.i.P())) && this.b.i.N() != null) {
                    P = this.b.i.N().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", P).param("fid", this.b.i.l()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.d0.getData().postId).param("obj_source", this.b.Y(this.a.d0)).param("obj_type", i));
                TiebaStatic.log(new StatisticItem("c14440").param("tid", P).param("fname", this.b.i.m()).param("fid", this.b.i.l()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.d0.getData().postId));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ch9 a;

        public l(ch9 ch9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ch9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ch9Var;
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
    public ch9(Context context, BdUniqueId bdUniqueId, TbPageContext tbPageContext) {
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
        this.q = new ng<>(new d(this), 6, 0);
        this.r = new ng<>(new e(this), 12, 0);
        this.s = new gg9(new f(this));
        this.b = tbPageContext;
        this.a = X(R.dimen.tbds14);
    }

    public final void J(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, yca ycaVar) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, pbCommenFloorItemViewHolder, ycaVar) == null) && pbCommenFloorItemViewHolder != null && ycaVar != null && (imageView = pbCommenFloorItemViewHolder.I) != null && this.i != null) {
            imageView.setVisibility(8);
        }
    }

    public final void M(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, yca ycaVar) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pbCommenFloorItemViewHolder, ycaVar) == null) && pbCommenFloorItemViewHolder != null && ycaVar != null) {
            ImageView imageView = pbCommenFloorItemViewHolder.X;
            if (ycaVar.c0) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            imageView.setVisibility(i2);
        }
    }

    public final void S(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, yca ycaVar) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, pbCommenFloorItemViewHolder, ycaVar) == null) && pbCommenFloorItemViewHolder != null && (view2 = pbCommenFloorItemViewHolder.c) != null) {
            SkinManager.setBackgroundColor(view2, R.color.CAM_X0205);
        }
    }

    public final void V(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, yca ycaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048593, this, pbCommenFloorItemViewHolder, ycaVar) == null) && pbCommenFloorItemViewHolder != null && ycaVar != null) {
            pbCommenFloorItemViewHolder.i(ycaVar.f1185T, ycaVar.S(), false);
        }
    }

    public final void D(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.r.setTextViewOnTouchListener(this.f);
            pbCommenFloorItemViewHolder.r.setTextViewCheckSelection(false);
            pbCommenFloorItemViewHolder.t.setOnTouchListener(new l(this));
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

    public void d0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.p = z;
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, onClickListener) == null) {
            this.d = onClickListener;
        }
    }

    public void e0(ok9 ok9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, ok9Var) == null) {
            this.m = ok9Var;
        }
    }

    public void f0(qk9 qk9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, qk9Var) == null) {
            this.n = qk9Var;
        }
    }

    public void g0(gg9 gg9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, gg9Var) == null) {
            this.f = gg9Var;
        }
    }

    public void h0(TbRichTextView.t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, tVar) == null) {
            this.o = tVar;
        }
    }

    public final void j0(TextView textView) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048609, this, textView) != null) || textView == null) {
            return;
        }
        Object tag = textView.getTag();
        if (!(tag instanceof yca)) {
            return;
        }
        k0(textView, (yca) tag);
    }

    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, onClickListener) == null) {
            this.c = onClickListener;
        }
    }

    public void n(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, zVar) == null) {
            this.e = zVar;
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
            this.h = str;
        }
    }

    public void r(ze9 ze9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, ze9Var) == null) {
            this.i = ze9Var;
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
            this.j = z;
        }
    }

    public final void E(TbRichTextView tbRichTextView, View view2, boolean z, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{tbRichTextView, view2, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) && tbRichTextView != null && view2 != null) {
            int m = ((((yi.m(TbadkCoreApplication.getInst(), UtilHelper.isFoldScreen()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight()) - i2;
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
                pbCommenFloorItemViewHolder.S.setVisibility(8);
                if (StringUtils.isNull(str)) {
                    pbCommenFloorItemViewHolder.U.setText(R.string.obfuscated_res_0x7f0f06e3);
                    return;
                } else {
                    pbCommenFloorItemViewHolder.U.setText(str);
                    return;
                }
            }
            pbCommenFloorItemViewHolder.S.setVisibility(0);
            pbCommenFloorItemViewHolder.U.setText(R.string.obfuscated_res_0x7f0f0474);
        }
    }

    public final void G(boolean z, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, yca ycaVar) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), pbCommenFloorItemViewHolder, ycaVar}) == null) && pbCommenFloorItemViewHolder != null && (view2 = pbCommenFloorItemViewHolder.J) != null && pbCommenFloorItemViewHolder.f1149T != null && (view2.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (pbCommenFloorItemViewHolder.f1149T.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = !ListUtils.isEmpty(ycaVar.i0());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.J.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.f1149T.getLayoutParams();
            if (z) {
                pbCommenFloorItemViewHolder.r.getLayoutStrategy().n(0);
                if (z2) {
                    pbCommenFloorItemViewHolder.r.getLayoutStrategy().m(yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                    }
                } else {
                    pbCommenFloorItemViewHolder.r.getLayoutStrategy().m(yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = 0;
                    }
                }
                pbCommenFloorItemViewHolder.f1149T.setLayoutParams(layoutParams2);
                if (layoutParams != null) {
                    layoutParams.topMargin = yi.g(this.mContext, R.dimen.tbds20);
                    pbCommenFloorItemViewHolder.J.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            pbCommenFloorItemViewHolder.r.getLayoutStrategy().m(yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
            pbCommenFloorItemViewHolder.r.getLayoutStrategy().n(yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
            if (layoutParams != null) {
                layoutParams.topMargin = yi.g(this.mContext, R.dimen.tbds14);
                pbCommenFloorItemViewHolder.J.setLayoutParams(layoutParams);
            }
        }
    }

    public final void R(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, yca ycaVar, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048589, this, pbCommenFloorItemViewHolder, ycaVar, view2) == null) && pbCommenFloorItemViewHolder != null && ycaVar != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.s.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = yi.g(this.mContext, R.dimen.M_W_X007);
            layoutParams.leftMargin = yi.g(this.mContext, R.dimen.tbds148);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            pbCommenFloorItemViewHolder.r.setPadding(0, 0, 0, 0);
            pbCommenFloorItemViewHolder.r.p0(null);
            pbCommenFloorItemViewHolder.r.setBackgroundDrawable(null);
            pbCommenFloorItemViewHolder.r.getLayoutStrategy().h(R.drawable.transparent_bg);
            pbCommenFloorItemViewHolder.r.getLayoutStrategy().z(R.drawable.pic_video);
            E(pbCommenFloorItemViewHolder.r, view2, !StringUtils.isNull(ycaVar.t()), layoutParams.leftMargin + layoutParams.rightMargin);
            pbCommenFloorItemViewHolder.s.setLayoutParams(layoutParams);
            pbCommenFloorItemViewHolder.r.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            pbCommenFloorItemViewHolder.r.setIsFromCDN(this.j);
            pbCommenFloorItemViewHolder.r.setText(ycaVar.e0(), true, this.o);
            SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.r.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, ycaVar);
            sparseArray.put(R.id.tag_is_subpb, Boolean.FALSE);
            pbCommenFloorItemViewHolder.r.setTag(sparseArray);
            pbCommenFloorItemViewHolder.t.setTag(sparseArray);
            pbCommenFloorItemViewHolder.c.setTag(R.id.tag_from, sparseArray);
            pbCommenFloorItemViewHolder.o0.setTag(sparseArray);
            pbCommenFloorItemViewHolder.e0.setTag(sparseArray);
        }
    }

    public final void H(View view2) {
        PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, view2) == null) && view2 != null && (view2.getTag() instanceof PbCommenFloorItemViewHolder) && (agreeView = (pbCommenFloorItemViewHolder = (PbCommenFloorItemViewHolder) view2.getTag()).d0) != null && agreeView.getData() != null) {
            pbCommenFloorItemViewHolder.d0.setAgreeSource(2);
            pbCommenFloorItemViewHolder.d0.O();
        }
    }

    public final void I(yca ycaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, ycaVar) == null) && ycaVar != null) {
            int i2 = 8;
            if (ycaVar.d0) {
                i2 = 2;
            }
            StatisticItem i3 = xm9.i(this.i, ycaVar, ycaVar.e0, i2, 6);
            ycaVar.f0 = i3;
            if (!ListUtils.isEmpty(ycaVar.i0())) {
                Iterator<yca> it = ycaVar.i0().iterator();
                while (it.hasNext()) {
                    it.next().f0 = i3;
                }
            }
        }
    }

    public final String Y(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, view2)) == null) {
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
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0119  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void L(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, yca ycaVar) {
        boolean z;
        boolean z2;
        int i2;
        int i3;
        ze9 ze9Var;
        ze9 ze9Var2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, pbCommenFloorItemViewHolder, ycaVar) == null) && pbCommenFloorItemViewHolder != null && ycaVar != null) {
            String str = null;
            boolean z3 = true;
            if (ycaVar.I() > 0 && (ze9Var2 = this.i) != null && !ze9Var2.i0()) {
                String format = String.format(this.mContext.getString(R.string.obfuscated_res_0x7f0f0b19), Integer.valueOf(ycaVar.I()));
                pbCommenFloorItemViewHolder.D.setVisibility(0);
                pbCommenFloorItemViewHolder.D.setText(format);
                z = true;
            } else {
                pbCommenFloorItemViewHolder.D.setVisibility(8);
                z = false;
            }
            if (ycaVar.q() != null) {
                str = ycaVar.q().getIpAddress();
                if (!TextUtils.isEmpty(str)) {
                    z2 = true;
                    ci5 Z = ycaVar.Z();
                    z3 = (Z != null || StringUtils.isNull(Z.b()) || (ze9Var = this.i) == null || ze9Var.i0()) ? false : false;
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
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(ycaVar.p0()), "yyyy"))) {
                        pbCommenFloorItemViewHolder.k.setText(StringHelper.getFormatTimeShort(ycaVar.p0()));
                    } else {
                        pbCommenFloorItemViewHolder.k.setText(StringHelper.getFormatTime(ycaVar.p0()));
                    }
                    if (!z2) {
                        pbCommenFloorItemViewHolder.o.setVisibility(0);
                        pbCommenFloorItemViewHolder.o.setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds14), 0, 0, 0);
                        pbCommenFloorItemViewHolder.o.setText(TbadkCoreApplication.getInst().getString(R.string.user_ip_address) + str);
                    } else if (z3) {
                        pbCommenFloorItemViewHolder.o.setVisibility(0);
                        pbCommenFloorItemViewHolder.o.setPadding(this.a, 0, 0, 0);
                        if (ycaVar.c0) {
                            pbCommenFloorItemViewHolder.o.setText(StringHelper.cutStringWithSuffix(Z.b(), 7, "..."));
                        } else {
                            pbCommenFloorItemViewHolder.o.setText(Z.b());
                        }
                    } else {
                        pbCommenFloorItemViewHolder.o.setVisibility(8);
                    }
                    pbCommenFloorItemViewHolder.n.setPadding(UtilHelper.getDimenPixelSize(R.dimen.tbds14), 0, 0, 0);
                    TextView textView = pbCommenFloorItemViewHolder.g0;
                    textView.setText(((Object) pbCommenFloorItemViewHolder.k.getText()) + "  • ");
                }
            }
            z2 = false;
            ci5 Z2 = ycaVar.Z();
            if (Z2 != null) {
            }
            if (!z) {
            }
            if (z3) {
            }
            pbCommenFloorItemViewHolder.m.setVisibility(0);
            i3 = this.a;
            pbCommenFloorItemViewHolder.k.setPadding(i2, 0, i3, 0);
            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(ycaVar.p0()), "yyyy"))) {
            }
            if (!z2) {
            }
            pbCommenFloorItemViewHolder.n.setPadding(UtilHelper.getDimenPixelSize(R.dimen.tbds14), 0, 0, 0);
            TextView textView2 = pbCommenFloorItemViewHolder.g0;
            textView2.setText(((Object) pbCommenFloorItemViewHolder.k.getText()) + "  • ");
        }
    }

    public final void k0(TextView textView, yca ycaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048611, this, textView, ycaVar) == null) {
            if (textView == null && ycaVar == null) {
                return;
            }
            textView.setTag(ycaVar);
            if (ycaVar.q() != null) {
                MetaData q = ycaVar.q();
                String str = this.h;
                if (str != null && !str.equals("0") && this.h.equals(q.getUserId())) {
                    textView.setVisibility(0);
                    textView.setAlpha(1.0f);
                    textView.setText(R.string.host_name);
                    textView.setBackgroundColor(0);
                    d85 d2 = d85.d(textView);
                    d2.o(R.string.J_X04);
                    d2.m(R.dimen.L_X01);
                    d2.x(R.color.CAM_X0302);
                    d2.l(R.color.CAM_X0302);
                    return;
                } else if (q.getIs_bawu() == 1 && ycaVar.B0()) {
                    d85 d3 = d85.d(textView);
                    d3.x(R.color.CAM_X0101);
                    d3.o(R.string.J_X04);
                    d3.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.brand_official);
                    return;
                } else if (q.getIs_bawu() == 1 && "manager".equals(q.getBawu_type())) {
                    d85 d4 = d85.d(textView);
                    d4.x(R.color.CAM_X0101);
                    d4.o(R.string.J_X04);
                    d4.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_bazhu_tip);
                    return;
                } else if (q.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(q.getBawu_type())) {
                    d85 d5 = d85.d(textView);
                    d5.x(R.color.CAM_X0101);
                    d5.o(R.string.J_X04);
                    d5.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_xbazhu_tip);
                    return;
                } else if (q.getIs_bawu() == 1 && "pri_content_assist".equals(q.getBawu_type())) {
                    d85 d6 = d85.d(textView);
                    d6.x(R.color.CAM_X0101);
                    d6.o(R.string.J_X04);
                    d6.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_content_assist_tip);
                    return;
                } else if (q.getIs_bawu() == 1 && "pri_manage_assist".equals(q.getBawu_type())) {
                    d85 d7 = d85.d(textView);
                    d7.x(R.color.CAM_X0101);
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

    public final void N(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, yca ycaVar, View view2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048585, this, pbCommenFloorItemViewHolder, ycaVar, view2, i2) == null) && pbCommenFloorItemViewHolder != null && ycaVar != null) {
            pbCommenFloorItemViewHolder.B.setVisibility(8);
            pbCommenFloorItemViewHolder.v.setVisibility(0);
            pbCommenFloorItemViewHolder.f0.setVisibility(8);
            pbCommenFloorItemViewHolder.z.setVisibility(8);
            pbCommenFloorItemViewHolder.A.setVisibility(8);
            pbCommenFloorItemViewHolder.p.setVisibility(8);
            pbCommenFloorItemViewHolder.o0.setVisibility(8);
            W(pbCommenFloorItemViewHolder, ycaVar, view2, i2);
            J(pbCommenFloorItemViewHolder, ycaVar);
            O(pbCommenFloorItemViewHolder, ycaVar);
            R(pbCommenFloorItemViewHolder, ycaVar, view2);
            Q(pbCommenFloorItemViewHolder, ycaVar, view2, i2);
            L(pbCommenFloorItemViewHolder, ycaVar);
            T(pbCommenFloorItemViewHolder, ycaVar);
            P(pbCommenFloorItemViewHolder, ycaVar);
            U(pbCommenFloorItemViewHolder, ycaVar);
            sg9.e(pbCommenFloorItemViewHolder, ycaVar, view2, this.s);
            M(pbCommenFloorItemViewHolder, ycaVar);
            S(pbCommenFloorItemViewHolder, ycaVar);
            V(pbCommenFloorItemViewHolder, ycaVar);
            sg9.k(pbCommenFloorItemViewHolder, view2, ycaVar, this.p, true);
        }
    }

    public final void O(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, yca ycaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048586, this, pbCommenFloorItemViewHolder, ycaVar) == null) && pbCommenFloorItemViewHolder != null && ycaVar != null && ycaVar.o() != null) {
            ycaVar.o().objType = 1;
            ycaVar.o().isInPost = true;
            ThreadData threadData = null;
            ze9 ze9Var = this.i;
            if (ze9Var != null && ze9Var.N() != null) {
                threadData = this.i.N();
                ycaVar.o().threadId = threadData.getTid();
                ycaVar.o().forumId = String.valueOf(threadData.getFid());
            }
            if (threadData != null && threadData.isUgcThreadType()) {
                pbCommenFloorItemViewHolder.p.setAgreeAlone(true);
            }
            pbCommenFloorItemViewHolder.p.setThreadData(threadData);
            pbCommenFloorItemViewHolder.p.setData(ycaVar.o());
            pbCommenFloorItemViewHolder.d0.setThreadData(threadData);
            pbCommenFloorItemViewHolder.d0.setData(ycaVar.o());
        }
    }

    public final void T(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, yca ycaVar) {
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, pbCommenFloorItemViewHolder, ycaVar) == null) {
            if (ycaVar != null && ycaVar.q() != null && ycaVar.l0() != null) {
                TbRichText e0 = ycaVar.e0();
                if (e0 != null && StringUtils.isNull(e0.toString()) && StringUtils.isNull(ycaVar.t())) {
                    z = true;
                } else {
                    z = false;
                }
                if (ycaVar.q().getSmallTailThemeData() != null) {
                    str = ycaVar.q().getSmallTailThemeData().getPropsId();
                } else {
                    str = "";
                }
                pbCommenFloorItemViewHolder.K.setTag(R.id.tag_pb_small_tail_theme_id, str);
                pbCommenFloorItemViewHolder.L.setTag(R.id.tag_pb_small_tail_theme_id, str);
                mn9.c(ycaVar.l0(), pbCommenFloorItemViewHolder.K, pbCommenFloorItemViewHolder.L, pbCommenFloorItemViewHolder.M, false, false, z, ycaVar.q().getSmallTailThemeData());
                return;
            }
            pbCommenFloorItemViewHolder.K.setVisibility(8);
            pbCommenFloorItemViewHolder.L.setVisibility(8);
        }
    }

    public final void P(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, yca ycaVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048587, this, pbCommenFloorItemViewHolder, ycaVar) == null) && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.Q != null && pbCommenFloorItemViewHolder.N != null) {
            if (ycaVar != null && (alaLiveInfoCoreData = ycaVar.U) != null && !StringUtils.isNull(alaLiveInfoCoreData.liveTitle)) {
                pbCommenFloorItemViewHolder.Q.setText(ycaVar.U.liveTitle);
                pbCommenFloorItemViewHolder.N.setTag(ycaVar.U);
                pbCommenFloorItemViewHolder.N.setVisibility(0);
                StatisticItem statisticItem = new StatisticItem("c12639");
                if (TbadkCoreApplication.getCurrentAccount() != null) {
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                }
                TiebaStatic.log(statisticItem);
                return;
            }
            pbCommenFloorItemViewHolder.N.setVisibility(8);
        }
    }

    public final void U(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, yca ycaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, pbCommenFloorItemViewHolder, ycaVar) == null) {
            if (ycaVar.M() != 2 && ycaVar.M() != 4) {
                pbCommenFloorItemViewHolder.f1149T.setVisibility(8);
                pbCommenFloorItemViewHolder.S.setVisibility(0);
                G(false, pbCommenFloorItemViewHolder, ycaVar);
                return;
            }
            pbCommenFloorItemViewHolder.f1149T.setOnClickListener(new a(this, pbCommenFloorItemViewHolder, ycaVar));
            pbCommenFloorItemViewHolder.f1149T.setVisibility(0);
            F(pbCommenFloorItemViewHolder, ycaVar.D0(), ycaVar.L());
            G(true, pbCommenFloorItemViewHolder, ycaVar);
        }
    }

    public final void Q(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, yca ycaVar, View view2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048588, this, pbCommenFloorItemViewHolder, ycaVar, view2, i2) == null) && pbCommenFloorItemViewHolder != null && ycaVar != null) {
            if (ycaVar.k0() > 0) {
                pbCommenFloorItemViewHolder.y.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.y.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    pbCommenFloorItemViewHolder.y.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, ycaVar);
                if (ycaVar.M() == 2) {
                    pbCommenFloorItemViewHolder.y.setVisibility(8);
                } else {
                    pbCommenFloorItemViewHolder.y.setVisibility(0);
                }
                pbCommenFloorItemViewHolder.x.setVisibility(8);
            }
            ImageView imageView = pbCommenFloorItemViewHolder.z;
            if (imageView != null) {
                SparseArray sparseArray2 = (SparseArray) imageView.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    pbCommenFloorItemViewHolder.z.setTag(sparseArray2);
                }
                sparseArray2.put(R.id.tag_load_sub_data, ycaVar);
            }
            if (this.i != null) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_FLOOR_COMPLAINT);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.i.l());
                statisticItem.param("fname", this.i.m());
                statisticItem.param("tid", this.i.P());
                statisticItem.param("pid", ycaVar.S());
                TiebaStatic.log(statisticItem);
            }
            if (pbCommenFloorItemViewHolder.V != null) {
                PbFloorComplaint pbFloorComplaint = (PbFloorComplaint) view2.findViewById(R.id.obfuscated_res_0x7f091a8d);
                pbCommenFloorItemViewHolder.V = pbFloorComplaint;
                pbCommenFloorItemViewHolder.W = Boolean.TRUE;
                pbFloorComplaint.setRemindText(ycaVar.K());
                pbCommenFloorItemViewHolder.V.setRemindIcon(ycaVar.K());
                if (ycaVar.K() == 0) {
                    pbCommenFloorItemViewHolder.V.setVisibility(8);
                } else {
                    pbCommenFloorItemViewHolder.V.setVisibility(0);
                    if (this.i != null) {
                        StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_FLOOR_COMPLAINT_SHOW);
                        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem2.param("fid", this.i.l());
                        statisticItem2.param("fname", this.i.m());
                        statisticItem2.param("tid", this.i.P());
                        statisticItem2.param("pid", ycaVar.S());
                        statisticItem2.param("obj_type", ycaVar.K());
                        TiebaStatic.log(statisticItem2);
                    }
                }
                pbCommenFloorItemViewHolder.V.setAmendIconListener(new c(this, ycaVar.J(), ycaVar));
            }
            ImageView imageView2 = pbCommenFloorItemViewHolder.A;
            if (imageView2 != null) {
                SparseArray sparseArray3 = (SparseArray) imageView2.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    pbCommenFloorItemViewHolder.A.setTag(sparseArray3);
                }
                sparseArray3.put(R.id.tag_load_sub_data, ycaVar);
            }
            pbCommenFloorItemViewHolder.x.setVisibility(8);
            if (!ycaVar.z0() && !ycaVar.y0(false)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.w.getLayoutParams();
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                layoutParams.bottomMargin = 0;
                pbCommenFloorItemViewHolder.w.setLayoutParams(layoutParams);
                pbCommenFloorItemViewHolder.w.setVisibility(8);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.w.getLayoutParams();
                layoutParams2.topMargin = yi.g(this.mContext, R.dimen.tbds10);
                layoutParams2.leftMargin = yi.g(this.mContext, R.dimen.tbds148);
                layoutParams2.rightMargin = yi.g(this.mContext, R.dimen.M_W_X007);
                layoutParams2.bottomMargin = yi.g(this.mContext, R.dimen.tbds20);
                pbCommenFloorItemViewHolder.w.setLayoutParams(layoutParams2);
                if (this.l == null) {
                    gm9 gm9Var = new gm9(this.mContext);
                    this.l = gm9Var;
                    gm9Var.f(this.j);
                    this.l.h(this.c);
                    this.l.e(this.d);
                    String str = null;
                    ze9 ze9Var = this.i;
                    if (ze9Var != null && ze9Var.N() != null && this.i.N().getAuthor() != null) {
                        str = this.i.N().getAuthor().getUserId();
                    }
                    boolean z = true;
                    z = (str == null || !str.equals(TbadkCoreApplication.getCurrentAccount())) ? false : false;
                    ze9 ze9Var2 = this.i;
                    if (ze9Var2 != null) {
                        this.l.j(ze9Var2.V(), z);
                        this.l.i(this.i.N());
                    }
                }
                this.l.g(ycaVar.S());
                pbCommenFloorItemViewHolder.w.setSubPbAdapter(this.l);
                pbCommenFloorItemViewHolder.w.setVisibility(0);
                pbCommenFloorItemViewHolder.w.setData(ycaVar, view2);
                pbCommenFloorItemViewHolder.w.setChildOnClickListener(this.d);
                pbCommenFloorItemViewHolder.w.setChildOnLongClickListener(this.g);
                pbCommenFloorItemViewHolder.w.setChildOnTouchListener(this.s);
            }
            if (ycaVar.P) {
                pbCommenFloorItemViewHolder.J.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.J.setVisibility(4);
            }
            pbCommenFloorItemViewHolder.y.setVisibility(8);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.v.getLayoutParams();
            layoutParams3.topMargin = yi.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X001);
            layoutParams3.bottomMargin = yi.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X002);
            if (pbCommenFloorItemViewHolder.x.getVisibility() == 8) {
                pbCommenFloorItemViewHolder.v.setVisibility(8);
            } else {
                pbCommenFloorItemViewHolder.v.setVisibility(0);
            }
            pbCommenFloorItemViewHolder.h0.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1220));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:176:0x054d  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0558  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0561  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x05a4  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x05ae  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0614  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x061e  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x065d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void W(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, yca ycaVar, View view2, int i2) {
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
        if ((interceptable == null || interceptable.invokeLLLI(1048594, this, pbCommenFloorItemViewHolder, ycaVar, view2, i2) == null) && pbCommenFloorItemViewHolder != null && ycaVar != null) {
            int i6 = 0;
            if (ycaVar.R) {
                SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.e, R.color.CAM_X0204);
                pbCommenFloorItemViewHolder.e.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.e.setVisibility(8);
            }
            ThreadData threadData = null;
            pbCommenFloorItemViewHolder.q.setTag(null);
            pbCommenFloorItemViewHolder.q.setUserId(null);
            pbCommenFloorItemViewHolder.g.setText((CharSequence) null);
            pbCommenFloorItemViewHolder.F.getHeadView().setUserId(null);
            pbCommenFloorItemViewHolder.r.setIsHost(false);
            String str6 = "";
            if (ycaVar.q() != null) {
                String str7 = this.h;
                if (str7 != null && !str7.equals("0") && this.h.equals(ycaVar.q().getUserId())) {
                    pbCommenFloorItemViewHolder.r.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = ycaVar.q().getIconInfo();
                ArrayList<IconData> tShowInfoNew = ycaVar.q().getTShowInfoNew();
                UserIconBox userIconBox = pbCommenFloorItemViewHolder.H;
                if (userIconBox != null) {
                    userIconBox.setTag(R.id.tag_user_id, ycaVar.q().getUserId());
                    ok9 ok9Var = this.m;
                    if (ok9Var != null) {
                        pbCommenFloorItemViewHolder.H.setOnClickListener(ok9Var.c);
                    }
                    int g2 = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                    int g3 = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                    UserIconBox userIconBox2 = pbCommenFloorItemViewHolder.H;
                    i4 = R.id.tag_user_id;
                    userIconBox2.g(iconInfo, 2, g2, g2, g3);
                } else {
                    i4 = R.id.tag_user_id;
                }
                if (pbCommenFloorItemViewHolder.G != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        pbCommenFloorItemViewHolder.G.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    ok9 ok9Var2 = this.m;
                    if (ok9Var2 != null) {
                        pbCommenFloorItemViewHolder.G.setOnClickListener(ok9Var2.e);
                    }
                    int g4 = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                    pbCommenFloorItemViewHolder.G.h(tShowInfoNew, 3, g4, g4, yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
                }
                if (ListUtils.isEmpty(tShowInfoNew) && !ycaVar.q().isBigV()) {
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0107, 1);
                } else {
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0301, 1);
                }
                String avater = ycaVar.q().getAvater();
                if (ycaVar.d0) {
                    i5 = 2;
                } else {
                    i5 = 8;
                }
                pbCommenFloorItemViewHolder.g.setTag(i4, ycaVar.q().getUserId());
                pbCommenFloorItemViewHolder.g.setTag(R.id.tag_user_name, ycaVar.q().getUserName());
                pbCommenFloorItemViewHolder.g.setTag(R.id.tag_virtual_user_url, ycaVar.q().getVirtualUserUrl());
                pbCommenFloorItemViewHolder.g.setTag(R.id.tag_statistic_item, xm9.i(this.i, ycaVar, ycaVar.e0, i5, 2));
                String name_show = ycaVar.q().getName_show();
                String userName = ycaVar.q().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    pbCommenFloorItemViewHolder.g.setText(ae9.b(this.mContext, pbCommenFloorItemViewHolder.g.getText().toString()));
                    pbCommenFloorItemViewHolder.g.setGravity(16);
                    pbCommenFloorItemViewHolder.g.setTag(R.id.tag_nick_name_activity, ae9.a());
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0312, 1);
                }
                if (ycaVar.q().getPendantData() != null && !StringUtils.isNull(ycaVar.q().getPendantData().getImgUrl())) {
                    pbCommenFloorItemViewHolder.F.setBigVDimenSize(R.dimen.tbds36);
                    pbCommenFloorItemViewHolder.F.i(ycaVar.q());
                    pbCommenFloorItemViewHolder.q.setVisibility(8);
                    pbCommenFloorItemViewHolder.F.setVisibility(0);
                    pbCommenFloorItemViewHolder.F.getHeadView().N(avater, 28, false);
                    pbCommenFloorItemViewHolder.F.getHeadView().setUserId(ycaVar.q().getUserId());
                    pbCommenFloorItemViewHolder.F.getHeadView().setUserName(ycaVar.q().getUserName());
                    ze9 ze9Var = this.i;
                    if (ze9Var == null) {
                        str4 = "";
                    } else {
                        str4 = ze9Var.l();
                    }
                    pbCommenFloorItemViewHolder.F.getHeadView().setFid(str4);
                    ze9 ze9Var2 = this.i;
                    if (ze9Var2 == null) {
                        str5 = "";
                    } else {
                        str5 = ze9Var2.m();
                    }
                    pbCommenFloorItemViewHolder.F.getHeadView().setFName(str5);
                    pbCommenFloorItemViewHolder.F.getHeadView().setFloor(ycaVar.I());
                    pbCommenFloorItemViewHolder.F.getHeadView().setTid(ycaVar.S());
                    pbCommenFloorItemViewHolder.F.getHeadView().setTag(R.id.tag_statistic_item, xm9.i(this.i, ycaVar, ycaVar.e0, i5, 2));
                    pbCommenFloorItemViewHolder.F.i(ycaVar.q());
                } else {
                    pbCommenFloorItemViewHolder.q.setGodIconWidth(R.dimen.tbds36);
                    UtilHelper.showHeadImageViewBigV(pbCommenFloorItemViewHolder.q, ycaVar.q(), 4);
                    pbCommenFloorItemViewHolder.q.setUserId(ycaVar.q().getUserId());
                    ze9 ze9Var3 = this.i;
                    if (ze9Var3 == null) {
                        str2 = "";
                    } else {
                        str2 = ze9Var3.l();
                    }
                    pbCommenFloorItemViewHolder.q.setFid(str2);
                    ze9 ze9Var4 = this.i;
                    if (ze9Var4 == null) {
                        str3 = "";
                    } else {
                        str3 = ze9Var4.m();
                    }
                    pbCommenFloorItemViewHolder.q.setFName(str3);
                    pbCommenFloorItemViewHolder.q.setFloor(ycaVar.I());
                    pbCommenFloorItemViewHolder.q.setTid(ycaVar.S());
                    pbCommenFloorItemViewHolder.q.setUserName(ycaVar.q().getUserName(), ycaVar.s0());
                    pbCommenFloorItemViewHolder.q.setTag(R.id.tag_virtual_user_url, ycaVar.q().getVirtualUserUrl());
                    pbCommenFloorItemViewHolder.q.setTag(R.id.tag_statistic_item, xm9.i(this.i, ycaVar, ycaVar.e0, i5, 2));
                    pbCommenFloorItemViewHolder.q.setImageDrawable(null);
                    pbCommenFloorItemViewHolder.q.N(avater, 28, false);
                    pbCommenFloorItemViewHolder.q.setVisibility(0);
                    pbCommenFloorItemViewHolder.F.setVisibility(8);
                }
                if (ycaVar.q() != null && ycaVar.q().getAlaInfo() != null && ycaVar.q().getAlaUserData() != null && ycaVar.q().getAlaUserData().live_status == 1) {
                    pbCommenFloorItemViewHolder.e(true);
                    pbCommenFloorItemViewHolder.q.setLiveStatus(1);
                    pbCommenFloorItemViewHolder.q.setAlaInfo(ycaVar.q().getAlaInfo());
                    pbCommenFloorItemViewHolder.F.getHeadView().setLiveStatus(1);
                    pbCommenFloorItemViewHolder.F.getHeadView().setAlaInfo(ycaVar.q().getAlaInfo());
                    threadData = null;
                } else {
                    pbCommenFloorItemViewHolder.e(false);
                    pbCommenFloorItemViewHolder.q.setLiveStatus(0);
                    threadData = null;
                    pbCommenFloorItemViewHolder.q.setAlaInfo(null);
                    pbCommenFloorItemViewHolder.F.getHeadView().setLiveStatus(0);
                    pbCommenFloorItemViewHolder.F.getHeadView().setAlaInfo(null);
                }
                k0(pbCommenFloorItemViewHolder.i, ycaVar);
            }
            if (ycaVar.q() == null) {
                str = "";
                i3 = 0;
            } else {
                i3 = ycaVar.q().getLevel_id();
                str = ycaVar.q().getLevelName();
            }
            ze9 ze9Var5 = this.i;
            if (ze9Var5 != null && ze9Var5.i0()) {
                i3 = 0;
            }
            if (i3 > 0) {
                pbCommenFloorItemViewHolder.E.setVisibility(0);
                pbCommenFloorItemViewHolder.E.setLevel(i3, str);
            } else {
                pbCommenFloorItemViewHolder.E.setVisibility(8);
            }
            if (ycaVar.q() != null) {
                str6 = ycaVar.q().getName_show();
            }
            pbCommenFloorItemViewHolder.g.setText(str6);
            pbCommenFloorItemViewHolder.f.post(new b(this, pbCommenFloorItemViewHolder, str6));
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, ycaVar);
            sparseArray.put(R.id.tag_load_sub_data, ycaVar);
            sparseArray.put(R.id.tag_load_sub_view, view2);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(ycaVar.I()));
            sparseArray.put(R.id.tag_forbid_user_post_id, ycaVar.S());
            sparseArray.put(R.id.pb_dialog_item_zan_1, pbCommenFloorItemViewHolder.p);
            sparseArray.put(R.id.pb_dialog_item_zan_2, pbCommenFloorItemViewHolder.d0);
            sparseArray.put(R.id.pb_dialog_item_reply, pbCommenFloorItemViewHolder.z);
            sparseArray.put(R.id.pb_dialog_item_share, pbCommenFloorItemViewHolder.A);
            ze9 ze9Var6 = this.i;
            if (ze9Var6 != null && ze9Var6.N() != null) {
                threadData = this.i.N();
            }
            if (threadData != null && threadData.isUgcThreadType()) {
                sparseArray.put(R.id.pb_dialog_item_isugc, Boolean.TRUE);
            } else {
                sparseArray.put(R.id.pb_dialog_item_isugc, Boolean.FALSE);
            }
            if (ycaVar.q() != null && !StringUtils.isNull(ycaVar.q().getVirtualUserUrl())) {
                z = true;
            } else {
                z = false;
            }
            ze9 ze9Var7 = this.i;
            if (ze9Var7 != null && ze9Var7.V() != 0 && !Z()) {
                if (this.i.V() != 1002 && this.i.V() != 3) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (this.i.V() != 3 && !this.i.i0()) {
                    z3 = true;
                    z4 = true;
                } else {
                    z3 = false;
                    z4 = false;
                }
                if (ycaVar != null && ycaVar.q() != null) {
                    String userId = ycaVar.q().getUserId();
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
            ze9 ze9Var8 = this.i;
            if (ze9Var8 != null && ze9Var8.N() != null && this.i.N().getAuthor() != null && ycaVar.q() != null) {
                String userId2 = this.i.N().getAuthor().getUserId();
                String userId3 = ycaVar.q().getUserId();
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
                    if (ycaVar != null && ycaVar.q() != null && UtilHelper.isCurrentAccount(ycaVar.q().getUserId())) {
                        z4 = true;
                        z6 = true;
                    }
                    if (z) {
                        z2 = false;
                        z5 = false;
                        z4 = false;
                    }
                    if (ycaVar.I() != 1) {
                        i6 = 1;
                    }
                    if (!z2) {
                        sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.i.V()));
                        if (ycaVar.q() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, ycaVar.q().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, ycaVar.q().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, ycaVar.q().getPortrait());
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                    }
                    if (!z5) {
                        sparseArray.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (ycaVar.q() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, ycaVar.q().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, ycaVar.q().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, ycaVar.q().getName_show());
                        }
                        if (this.i.N() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.i.N().getId());
                        }
                        sparseArray.put(R.id.tag_user_mute_post_id, ycaVar.S());
                    } else {
                        sparseArray.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                    }
                    if (!z4) {
                        sparseArray.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_has_sub_post, Boolean.valueOf(ycaVar.z0()));
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.i.V()));
                        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i6));
                        sparseArray.put(R.id.tag_del_post_id, ycaVar.S());
                    } else {
                        sparseArray.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                    }
                    sparseArray.put(R.id.tag_mul_del_post_type, Boolean.valueOf(z3));
                    sparseArray.put(R.id.tag_is_self_post, Boolean.valueOf(z7));
                    pbCommenFloorItemViewHolder.r.setTag(sparseArray);
                    pbCommenFloorItemViewHolder.t.setTag(sparseArray);
                }
            }
            z5 = false;
            z6 = false;
            z7 = false;
            if (ycaVar != null) {
                z4 = true;
                z6 = true;
            }
            if (z) {
            }
            if (ycaVar.I() != 1) {
            }
            if (!z2) {
            }
            if (!z5) {
            }
            if (!z4) {
            }
            sparseArray.put(R.id.tag_mul_del_post_type, Boolean.valueOf(z3));
            sparseArray.put(R.id.tag_is_self_post, Boolean.valueOf(z7));
            pbCommenFloorItemViewHolder.r.setTag(sparseArray);
            pbCommenFloorItemViewHolder.t.setTag(sparseArray);
        }
    }

    public final boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            ze9 ze9Var = this.i;
            if (ze9Var != null && ze9Var.N() != null) {
                return this.i.N().isBlocked();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: a0 */
    public PbCommenFloorItemViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d07a6, viewGroup, false);
            ((ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f091af9)).addView(LayoutInflater.from(inflate.getContext()).inflate(R.layout.obfuscated_res_0x7f0d079f, (ViewGroup) null));
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = new PbCommenFloorItemViewHolder(this.b, inflate, 0);
            pbCommenFloorItemViewHolder.u.setConstrainLayoutPool(this.q);
            pbCommenFloorItemViewHolder.u.setImageViewPool(this.r);
            SubPbLayout subPbLayout = pbCommenFloorItemViewHolder.w;
            if (subPbLayout != null) {
                subPbLayout.setShowChildComment(true);
                pbCommenFloorItemViewHolder.w.setIsVideoThread(false);
            }
            i0(pbCommenFloorItemViewHolder);
            return pbCommenFloorItemViewHolder;
        }
        return (PbCommenFloorItemViewHolder) invokeL.objValue;
    }

    public View b0(int i2, View view2, ViewGroup viewGroup, yca ycaVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, ycaVar, pbCommenFloorItemViewHolder})) == null) {
            i0(pbCommenFloorItemViewHolder);
            c0(pbCommenFloorItemViewHolder);
            D(pbCommenFloorItemViewHolder);
            yca ycaVar2 = (yca) getItem(i2);
            if (ycaVar2 != null) {
                ycaVar2.e0 = i2 + 1;
                ycaVar2.y1();
                I(ycaVar2);
                N(pbCommenFloorItemViewHolder, ycaVar2, view2, i2);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void c0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.c.setOnTouchListener(this.s);
            pbCommenFloorItemViewHolder.c.setOnLongClickListener(this.g);
            pbCommenFloorItemViewHolder.g.setOnClickListener(this.m.b);
            pbCommenFloorItemViewHolder.q.setOnClickListener(this.m.b);
            pbCommenFloorItemViewHolder.F.setOnClickListener(this.m.b);
            pbCommenFloorItemViewHolder.F.getHeadView().setOnClickListener(this.m.b);
            pbCommenFloorItemViewHolder.r.setOnLongClickListener(this.g);
            pbCommenFloorItemViewHolder.r.setOnTouchListener(this.s);
            pbCommenFloorItemViewHolder.r.setCommonTextViewOnClickListener(this.d);
            pbCommenFloorItemViewHolder.r.setOnImageClickListener(this.e);
            pbCommenFloorItemViewHolder.r.setOnImageTouchListener(this.s);
            pbCommenFloorItemViewHolder.r.setOnEmotionClickListener(this.m.f);
            pbCommenFloorItemViewHolder.r.setOnVoiceAfterClickListener(this.d);
            pbCommenFloorItemViewHolder.K.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.L.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.N.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.x.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.y.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.m0.setOnTouchListener(this.s);
            pbCommenFloorItemViewHolder.m0.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.i0.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.e0.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.o0.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.f0.setOnClickListener(new g(this, pbCommenFloorItemViewHolder));
            pbCommenFloorItemViewHolder.c.setOnClickListener(new h(this, pbCommenFloorItemViewHolder));
            pbCommenFloorItemViewHolder.z.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.A.setOnClickListener(new i(this, pbCommenFloorItemViewHolder));
            pbCommenFloorItemViewHolder.p.D = new j(this, pbCommenFloorItemViewHolder);
            pbCommenFloorItemViewHolder.d0.D = new k(this, pbCommenFloorItemViewHolder);
        }
    }

    public final void i0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048608, this, pbCommenFloorItemViewHolder) != null) || pbCommenFloorItemViewHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (pbCommenFloorItemViewHolder.a != skinType) {
            j0(pbCommenFloorItemViewHolder.i);
            boolean z = true;
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.k, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.l, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.m, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.D, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.o, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.n, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.y, (int) R.color.CAM_X0108);
            pbCommenFloorItemViewHolder.r.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            if (pbCommenFloorItemViewHolder.t.getVisibility() == 0) {
                pbCommenFloorItemViewHolder.t.g(skinType);
            }
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g0, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.h0, R.color.CAM_X0107, 1);
            SkinManager.setBackgroundShapeDrawable(pbCommenFloorItemViewHolder.w, yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds21), R.color.CAM_X0206, R.color.CAM_X0206);
            SkinManager.getColor(R.color.CAM_X0107);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.x, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.x, (int) R.color.CAM_X0304);
            pbCommenFloorItemViewHolder.x.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right, SkinManager.getColor(R.color.CAM_X0304), null), (Drawable) null);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.z, R.drawable.obfuscated_res_0x7f080b99, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.A, R.drawable.obfuscated_res_0x7f080b9a, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbCommenFloorItemViewHolder.w.d();
            pbCommenFloorItemViewHolder.u.b();
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.Q, R.color.CAM_X0304, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.O, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.N, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.P, R.color.CAM_X0109);
            SkinManager.setImageResource(pbCommenFloorItemViewHolder.R, R.drawable.icon_arrow_more_gray);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.U, (int) R.color.CAM_X0107);
            if (pbCommenFloorItemViewHolder.S.getVisibility() != 8) {
                z = false;
            }
            if (z) {
                pbCommenFloorItemViewHolder.U.setText(R.string.obfuscated_res_0x7f0f0474);
            } else {
                ze9 ze9Var = this.i;
                if (ze9Var != null && StringUtils.isNull(ze9Var.j())) {
                    pbCommenFloorItemViewHolder.U.setText(this.i.j());
                } else {
                    pbCommenFloorItemViewHolder.U.setText(R.string.obfuscated_res_0x7f0f06e3);
                }
            }
            pbCommenFloorItemViewHolder.p.Q(TbadkCoreApplication.getInst().getSkinType());
            pbCommenFloorItemViewHolder.d(skinType);
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.J, R.color.CAM_X0203);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.e0, R.drawable.icon_pure_pb_more18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.o0, R.drawable.icon_pure_pb_more18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbCommenFloorItemViewHolder.c();
        }
        pbCommenFloorItemViewHolder.a = skinType;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.baidu.tieba.ln
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i2, View view2, ViewGroup viewGroup, yca ycaVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        b0(i2, view2, viewGroup, ycaVar, pbCommenFloorItemViewHolder);
        return view2;
    }
}

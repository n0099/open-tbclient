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
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
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
import com.baidu.tieba.fj9;
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.tieba.pb.pb.main.PbFloorComplaint;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
import com.baidu.tieba.pn9;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class bk9 extends om<zfa, PbCommenFloorItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public TbPageContext b;
    public View.OnClickListener c;
    public View.OnClickListener d;
    public TbRichTextView.z e;
    public fj9 f;
    public View.OnLongClickListener g;
    public String h;
    public yh9 i;
    public boolean j;
    public SparseIntArray k;
    public fp9 l;
    public nn9 m;
    public pn9 n;
    public TbRichTextView.t o;
    public boolean p;
    public ag<ConstrainImageLayout> q;
    public ag<TbImageView> r;
    public fj9 s;

    /* loaded from: classes5.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ bk9 b;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ zfa a;
            public final /* synthetic */ i b;

            public a(i iVar, zfa zfaVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar, zfaVar};
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
                this.a = zfaVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    pn9.b bVar = this.b.b.n.b;
                    i iVar = this.b;
                    bVar.a(iVar.b.i, null, this.a, iVar.a.q.getLayoutStrategy());
                }
            }
        }

        public i(bk9 bk9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bk9Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bk9Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            zfa zfaVar;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !(view2.getTag() instanceof SparseArray)) {
                return;
            }
            SparseArray sparseArray = (SparseArray) view2.getTag();
            if ((sparseArray.get(R.id.tag_load_sub_data) instanceof zfa) && (zfaVar = (zfa) sparseArray.get(R.id.tag_load_sub_data)) != null && this.a.c != null && this.b.n != null) {
                SafeHandler.getInst().postDelayed(new a(this, zfaVar), 100L);
                String Q = this.b.i.Q();
                if ((StringUtils.isNull(Q) || "0".equals(this.b.i.Q())) && this.b.i.O() != null) {
                    Q = this.b.i.O().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", Q).param("fid", this.b.i.l()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", zfaVar.S()).param("obj_source", this.b.Y(view2)).param("obj_type", 4));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ zfa b;
        public final /* synthetic */ bk9 c;

        public a(bk9 bk9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, zfa zfaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bk9Var, pbCommenFloorItemViewHolder, zfaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = bk9Var;
            this.a = pbCommenFloorItemViewHolder;
            this.b = zfaVar;
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
                this.c.F(this.a, !z, this.b.M());
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

        public b(bk9 bk9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bk9Var, pbCommenFloorItemViewHolder, str};
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
                nx5.c(measuredWidth, str, pbCommenFloorItemViewHolder.g, pbCommenFloorItemViewHolder.D, arrayList, pbCommenFloorItemViewHolder.G);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ zfa b;
        public final /* synthetic */ bk9 c;

        public c(bk9 bk9Var, String str, zfa zfaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bk9Var, str, zfaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = bk9Var;
            this.a = str;
            this.b = zfaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a != null) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean(WebViewActivityConfig.TAG_FIX_TITLE, true);
                    BrowserHelper.startWebActivity(this.c.b.getPageActivity(), "", this.a, false, true, true, bundle);
                }
                if (this.c.i != null) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_FLOOR_COMPLAINT_CLICK);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("fid", this.c.i.l());
                    statisticItem.param("fname", this.c.i.m());
                    statisticItem.param("tid", this.c.i.Q());
                    statisticItem.param("pid", this.b.S());
                    statisticItem.param("obj_type", this.b.L());
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements bg<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bk9 a;

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

        public d(bk9 bk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bk9Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bg
        public /* bridge */ /* synthetic */ ConstrainImageLayout a(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            e(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bg
        public /* bridge */ /* synthetic */ ConstrainImageLayout c(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            h(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
        /* renamed from: f */
        public void b(ConstrainImageLayout constrainImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, constrainImageLayout) == null) {
                constrainImageLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
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
    public class e implements bg<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bk9 a;

        public TbImageView e(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbImageView)) == null) ? tbImageView : (TbImageView) invokeL.objValue;
        }

        public e(bk9 bk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bk9Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bg
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bg
        public /* bridge */ /* synthetic */ TbImageView c(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            h(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
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
        @Override // com.baidu.tieba.bg
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
    public class f implements fj9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bk9 a;

        @Override // com.baidu.tieba.fj9.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        public f(bk9 bk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bk9Var;
        }

        @Override // com.baidu.tieba.fj9.a
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

        @Override // com.baidu.tieba.fj9.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                if (view2 == null || view2.getId() == R.id.obfuscated_res_0x7f090b7d) {
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

        public g(bk9 bk9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bk9Var, pbCommenFloorItemViewHolder};
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

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ bk9 b;

        public h(bk9 bk9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bk9Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bk9Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.b.i != null && (pbCommenFloorItemViewHolder = this.a) != null && (agreeView = pbCommenFloorItemViewHolder.c0) != null && agreeView.getData() != null) {
                String Q = this.b.i.Q();
                if ((StringUtils.isNull(Q) || "0".equals(this.b.i.Q())) && this.b.i.O() != null) {
                    Q = this.b.i.O().getNid();
                }
                TiebaStatic.log(new StatisticItem("c14442").param("tid", Q).param("fname", this.b.i.m()).param("fid", this.b.i.l()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.c0.getData().postId));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ bk9 b;

        public j(bk9 bk9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bk9Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bk9Var;
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
                String Q = this.b.i.Q();
                if ((StringUtils.isNull(Q) || "0".equals(this.b.i.Q())) && this.b.i.O() != null) {
                    Q = this.b.i.O().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", Q).param("fid", this.b.i.l()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.o.getData().postId).param("obj_source", this.b.Y(this.a.o)).param("obj_type", i));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ bk9 b;

        public k(bk9 bk9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bk9Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bk9Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.b.i != null && (pbCommenFloorItemViewHolder = this.a) != null && (agreeView = pbCommenFloorItemViewHolder.c0) != null && agreeView.getData() != null) {
                if (view2 == this.a.c0.getImgAgree()) {
                    i = 1;
                } else {
                    i = 2;
                }
                String Q = this.b.i.Q();
                if ((StringUtils.isNull(Q) || "0".equals(this.b.i.Q())) && this.b.i.O() != null) {
                    Q = this.b.i.O().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", Q).param("fid", this.b.i.l()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.c0.getData().postId).param("obj_source", this.b.Y(this.a.c0)).param("obj_type", i));
                TiebaStatic.log(new StatisticItem("c14440").param("tid", Q).param("fname", this.b.i.m()).param("fid", this.b.i.l()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.c0.getData().postId));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bk9 a;

        public l(bk9 bk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bk9Var;
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
    public bk9(Context context, BdUniqueId bdUniqueId, TbPageContext tbPageContext) {
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
        this.q = new ag<>(new d(this), 6, 0);
        this.r = new ag<>(new e(this), 12, 0);
        this.s = new fj9(new f(this));
        this.b = tbPageContext;
        this.a = X(R.dimen.tbds14);
    }

    public final void J(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, zfa zfaVar) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, pbCommenFloorItemViewHolder, zfaVar) == null) && pbCommenFloorItemViewHolder != null && zfaVar != null && (imageView = pbCommenFloorItemViewHolder.H) != null && this.i != null) {
            imageView.setVisibility(8);
        }
    }

    public final void L(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, zfa zfaVar) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pbCommenFloorItemViewHolder, zfaVar) == null) && pbCommenFloorItemViewHolder != null && zfaVar != null) {
            ImageView imageView = pbCommenFloorItemViewHolder.W;
            if (zfaVar.c0) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            imageView.setVisibility(i2);
        }
    }

    public final void R(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, zfa zfaVar) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, pbCommenFloorItemViewHolder, zfaVar) == null) && pbCommenFloorItemViewHolder != null && (view2 = pbCommenFloorItemViewHolder.c) != null) {
            SkinManager.setBackgroundColor(view2, R.color.CAM_X0205);
        }
    }

    public final void U(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, zfa zfaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048593, this, pbCommenFloorItemViewHolder, zfaVar) == null) && pbCommenFloorItemViewHolder != null && zfaVar != null) {
            pbCommenFloorItemViewHolder.i(zfaVar.f1192T, zfaVar.S(), false);
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

    public void e0(nn9 nn9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, nn9Var) == null) {
            this.m = nn9Var;
        }
    }

    public void f0(pn9 pn9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, pn9Var) == null) {
            this.n = pn9Var;
        }
    }

    public void g0(fj9 fj9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, fj9Var) == null) {
            this.f = fj9Var;
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
        if (!(tag instanceof zfa)) {
            return;
        }
        k0(textView, (zfa) tag);
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

    public void r(yh9 yh9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, yh9Var) == null) {
            this.i = yh9Var;
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
            int equipmentWidth = ((((BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst(), UtilHelper.isFoldScreen()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight()) - i2;
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                equipmentWidth = (equipmentWidth - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            if (z) {
                i3 = X(R.dimen.tbds115);
            } else {
                i3 = 0;
            }
            tbRichTextView.getLayoutStrategy().J = (equipmentWidth - i3) - X(R.dimen.tbds122);
            if (UtilHelper.isOppoFoldLargeScreen(TbadkCoreApplication.getInst().getContext())) {
                equipmentWidth /= 2;
            }
            tbRichTextView.getLayoutStrategy().r((int) ((equipmentWidth - i3) * 1.0f));
            tbRichTextView.getLayoutStrategy().q((int) (equipmentWidth * 1.618f * 1.0f));
        }
    }

    public final void F(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{pbCommenFloorItemViewHolder, Boolean.valueOf(z), str}) == null) {
            if (z) {
                pbCommenFloorItemViewHolder.R.setVisibility(8);
                if (StringUtils.isNull(str)) {
                    pbCommenFloorItemViewHolder.f1151T.setText(R.string.obfuscated_res_0x7f0f06ec);
                    return;
                } else {
                    pbCommenFloorItemViewHolder.f1151T.setText(str);
                    return;
                }
            }
            pbCommenFloorItemViewHolder.R.setVisibility(0);
            pbCommenFloorItemViewHolder.f1151T.setText(R.string.obfuscated_res_0x7f0f0475);
        }
    }

    public final void G(boolean z, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, zfa zfaVar) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), pbCommenFloorItemViewHolder, zfaVar}) == null) && pbCommenFloorItemViewHolder != null && (view2 = pbCommenFloorItemViewHolder.I) != null && pbCommenFloorItemViewHolder.S != null && (view2.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (pbCommenFloorItemViewHolder.S.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = !ListUtils.isEmpty(zfaVar.i0());
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

    public final void Q(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, zfa zfaVar, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048589, this, pbCommenFloorItemViewHolder, zfaVar, view2) == null) && pbCommenFloorItemViewHolder != null && zfaVar != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.r.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = BdUtilHelper.getDimens(this.mContext, R.dimen.M_W_X007);
            layoutParams.leftMargin = BdUtilHelper.getDimens(this.mContext, R.dimen.tbds148);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            pbCommenFloorItemViewHolder.q.setPadding(0, 0, 0, 0);
            pbCommenFloorItemViewHolder.q.p0(null);
            pbCommenFloorItemViewHolder.q.setBackgroundDrawable(null);
            pbCommenFloorItemViewHolder.q.getLayoutStrategy().h(R.drawable.transparent_bg);
            pbCommenFloorItemViewHolder.q.getLayoutStrategy().z(R.drawable.pic_video);
            E(pbCommenFloorItemViewHolder.q, view2, !StringUtils.isNull(zfaVar.u()), layoutParams.leftMargin + layoutParams.rightMargin);
            pbCommenFloorItemViewHolder.r.setLayoutParams(layoutParams);
            pbCommenFloorItemViewHolder.q.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            pbCommenFloorItemViewHolder.q.setIsFromCDN(this.j);
            pbCommenFloorItemViewHolder.q.setText(zfaVar.e0(), true, this.o);
            SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.q.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, zfaVar);
            sparseArray.put(R.id.tag_is_subpb, Boolean.FALSE);
            pbCommenFloorItemViewHolder.q.setTag(sparseArray);
            pbCommenFloorItemViewHolder.s.setTag(sparseArray);
            pbCommenFloorItemViewHolder.c.setTag(R.id.tag_from, sparseArray);
            pbCommenFloorItemViewHolder.n0.setTag(sparseArray);
            pbCommenFloorItemViewHolder.d0.setTag(sparseArray);
        }
    }

    public final void H(View view2) {
        PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, view2) == null) && view2 != null && (view2.getTag() instanceof PbCommenFloorItemViewHolder) && (agreeView = (pbCommenFloorItemViewHolder = (PbCommenFloorItemViewHolder) view2.getTag()).c0) != null && agreeView.getData() != null) {
            pbCommenFloorItemViewHolder.c0.setAgreeSource(2);
            pbCommenFloorItemViewHolder.c0.O();
        }
    }

    public final void I(zfa zfaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, zfaVar) == null) && zfaVar != null) {
            int i2 = 8;
            if (zfaVar.d0) {
                i2 = 2;
            }
            StatisticItem k2 = wp9.k(this.i, zfaVar, zfaVar.e0, i2, 6);
            zfaVar.f0 = k2;
            if (!ListUtils.isEmpty(zfaVar.i0())) {
                Iterator<zfa> it = zfaVar.i0().iterator();
                while (it.hasNext()) {
                    it.next().f0 = k2;
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
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0119  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void K(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, zfa zfaVar) {
        boolean z;
        boolean z2;
        int i2;
        int i3;
        yh9 yh9Var;
        yh9 yh9Var2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, pbCommenFloorItemViewHolder, zfaVar) == null) && pbCommenFloorItemViewHolder != null && zfaVar != null) {
            String str = null;
            boolean z3 = true;
            if (zfaVar.I() > 0 && (yh9Var2 = this.i) != null && !yh9Var2.j0()) {
                String format = String.format(this.mContext.getString(R.string.obfuscated_res_0x7f0f0b22), Integer.valueOf(zfaVar.I()));
                pbCommenFloorItemViewHolder.C.setVisibility(0);
                pbCommenFloorItemViewHolder.C.setText(format);
                z = true;
            } else {
                pbCommenFloorItemViewHolder.C.setVisibility(8);
                z = false;
            }
            if (zfaVar.r() != null) {
                str = zfaVar.r().getIpAddress();
                if (!TextUtils.isEmpty(str)) {
                    z2 = true;
                    vg5 Z = zfaVar.Z();
                    z3 = (Z != null || StringUtils.isNull(Z.b()) || (yh9Var = this.i) == null || yh9Var.j0()) ? false : false;
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
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(zfaVar.p0()), "yyyy"))) {
                        pbCommenFloorItemViewHolder.k.setText(StringHelper.getFormatTimeShort(zfaVar.p0()));
                    } else {
                        pbCommenFloorItemViewHolder.k.setText(StringHelper.getFormatTime(zfaVar.p0()));
                    }
                    if (!z2) {
                        pbCommenFloorItemViewHolder.n.setVisibility(0);
                        pbCommenFloorItemViewHolder.n.setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds14), 0, 0, 0);
                        pbCommenFloorItemViewHolder.n.setText(TbadkCoreApplication.getInst().getString(R.string.user_ip_address) + str);
                    } else if (z3) {
                        pbCommenFloorItemViewHolder.n.setVisibility(0);
                        pbCommenFloorItemViewHolder.n.setPadding(this.a, 0, 0, 0);
                        if (zfaVar.c0) {
                            pbCommenFloorItemViewHolder.n.setText(StringHelper.cutStringWithSuffix(Z.b(), 7, "..."));
                        } else {
                            pbCommenFloorItemViewHolder.n.setText(Z.b());
                        }
                    } else {
                        pbCommenFloorItemViewHolder.n.setVisibility(8);
                    }
                    TextView textView = pbCommenFloorItemViewHolder.f0;
                    textView.setText(((Object) pbCommenFloorItemViewHolder.k.getText()) + "  • ");
                }
            }
            z2 = false;
            vg5 Z2 = zfaVar.Z();
            if (Z2 != null) {
            }
            if (!z) {
            }
            if (z3) {
            }
            pbCommenFloorItemViewHolder.m.setVisibility(0);
            i3 = this.a;
            pbCommenFloorItemViewHolder.k.setPadding(i2, 0, i3, 0);
            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(zfaVar.p0()), "yyyy"))) {
            }
            if (!z2) {
            }
            TextView textView2 = pbCommenFloorItemViewHolder.f0;
            textView2.setText(((Object) pbCommenFloorItemViewHolder.k.getText()) + "  • ");
        }
    }

    public final void k0(TextView textView, zfa zfaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048611, this, textView, zfaVar) == null) {
            if (textView == null && zfaVar == null) {
                return;
            }
            textView.setTag(zfaVar);
            if (zfaVar.r() != null) {
                MetaData r = zfaVar.r();
                String str = this.h;
                if (str != null && !str.equals("0") && this.h.equals(r.getUserId())) {
                    textView.setVisibility(0);
                    textView.setAlpha(1.0f);
                    textView.setText(R.string.host_name);
                    textView.setBackgroundColor(0);
                    EMManager.from(textView).setCorner(R.string.J_X04).setBorderWidth(R.dimen.L_X01).setTextColor(R.color.CAM_X0302).setBorderColor(R.color.CAM_X0302);
                    return;
                } else if (r.getIs_bawu() == 1 && zfaVar.B0()) {
                    EMManager.from(textView).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.brand_official);
                    return;
                } else if (r.getIs_bawu() == 1 && "manager".equals(r.getBawu_type())) {
                    EMManager.from(textView).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_bazhu_tip);
                    return;
                } else if (r.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(r.getBawu_type())) {
                    EMManager.from(textView).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_xbazhu_tip);
                    return;
                } else if (r.getIs_bawu() == 1 && "pri_content_assist".equals(r.getBawu_type())) {
                    EMManager.from(textView).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_content_assist_tip);
                    return;
                } else if (r.getIs_bawu() == 1 && "pri_manage_assist".equals(r.getBawu_type())) {
                    EMManager.from(textView).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
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

    public final void M(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, zfa zfaVar, View view2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048585, this, pbCommenFloorItemViewHolder, zfaVar, view2, i2) == null) && pbCommenFloorItemViewHolder != null && zfaVar != null) {
            pbCommenFloorItemViewHolder.A.setVisibility(8);
            pbCommenFloorItemViewHolder.u.setVisibility(0);
            pbCommenFloorItemViewHolder.e0.setVisibility(8);
            pbCommenFloorItemViewHolder.y.setVisibility(8);
            pbCommenFloorItemViewHolder.z.setVisibility(8);
            pbCommenFloorItemViewHolder.o.setVisibility(8);
            pbCommenFloorItemViewHolder.n0.setVisibility(8);
            W(pbCommenFloorItemViewHolder, zfaVar, view2, i2);
            J(pbCommenFloorItemViewHolder, zfaVar);
            N(pbCommenFloorItemViewHolder, zfaVar);
            Q(pbCommenFloorItemViewHolder, zfaVar, view2);
            P(pbCommenFloorItemViewHolder, zfaVar, view2, i2);
            K(pbCommenFloorItemViewHolder, zfaVar);
            S(pbCommenFloorItemViewHolder, zfaVar);
            O(pbCommenFloorItemViewHolder, zfaVar);
            T(pbCommenFloorItemViewHolder, zfaVar);
            rj9.i(pbCommenFloorItemViewHolder, zfaVar, view2, this.s);
            L(pbCommenFloorItemViewHolder, zfaVar);
            R(pbCommenFloorItemViewHolder, zfaVar);
            U(pbCommenFloorItemViewHolder, zfaVar);
            rj9.o(pbCommenFloorItemViewHolder, view2, zfaVar, this.p, true);
        }
    }

    public final void N(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, zfa zfaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048586, this, pbCommenFloorItemViewHolder, zfaVar) == null) && pbCommenFloorItemViewHolder != null && zfaVar != null && zfaVar.o() != null) {
            zfaVar.o().objType = 1;
            zfaVar.o().isInPost = true;
            ThreadData threadData = null;
            yh9 yh9Var = this.i;
            if (yh9Var != null && yh9Var.O() != null) {
                threadData = this.i.O();
                zfaVar.o().threadId = threadData.getTid();
                zfaVar.o().forumId = String.valueOf(threadData.getFid());
            }
            if (threadData != null && threadData.isUgcThreadType()) {
                pbCommenFloorItemViewHolder.o.setAgreeAlone(true);
            }
            pbCommenFloorItemViewHolder.o.setThreadData(threadData);
            pbCommenFloorItemViewHolder.o.setData(zfaVar.o());
            pbCommenFloorItemViewHolder.c0.setThreadData(threadData);
            pbCommenFloorItemViewHolder.c0.setData(zfaVar.o());
        }
    }

    public final void S(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, zfa zfaVar) {
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, pbCommenFloorItemViewHolder, zfaVar) == null) {
            if (zfaVar != null && zfaVar.r() != null && zfaVar.l0() != null) {
                TbRichText e0 = zfaVar.e0();
                if (e0 != null && StringUtils.isNull(e0.toString()) && StringUtils.isNull(zfaVar.u())) {
                    z = true;
                } else {
                    z = false;
                }
                if (zfaVar.r().getSmallTailThemeData() != null) {
                    str = zfaVar.r().getSmallTailThemeData().getPropsId();
                } else {
                    str = "";
                }
                pbCommenFloorItemViewHolder.J.setTag(R.id.tag_pb_small_tail_theme_id, str);
                pbCommenFloorItemViewHolder.K.setTag(R.id.tag_pb_small_tail_theme_id, str);
                lq9.c(zfaVar.l0(), pbCommenFloorItemViewHolder.J, pbCommenFloorItemViewHolder.K, pbCommenFloorItemViewHolder.L, false, false, z, zfaVar.r().getSmallTailThemeData());
                return;
            }
            pbCommenFloorItemViewHolder.J.setVisibility(8);
            pbCommenFloorItemViewHolder.K.setVisibility(8);
        }
    }

    public final void O(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, zfa zfaVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048587, this, pbCommenFloorItemViewHolder, zfaVar) == null) && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.P != null && pbCommenFloorItemViewHolder.M != null) {
            if (zfaVar != null && (alaLiveInfoCoreData = zfaVar.U) != null && !StringUtils.isNull(alaLiveInfoCoreData.liveTitle)) {
                pbCommenFloorItemViewHolder.P.setText(zfaVar.U.liveTitle);
                pbCommenFloorItemViewHolder.M.setTag(zfaVar.U);
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

    public final void T(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, zfa zfaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, pbCommenFloorItemViewHolder, zfaVar) == null) {
            if (zfaVar.N() != 2 && zfaVar.N() != 4) {
                pbCommenFloorItemViewHolder.S.setVisibility(8);
                pbCommenFloorItemViewHolder.R.setVisibility(0);
                G(false, pbCommenFloorItemViewHolder, zfaVar);
                return;
            }
            pbCommenFloorItemViewHolder.S.setOnClickListener(new a(this, pbCommenFloorItemViewHolder, zfaVar));
            pbCommenFloorItemViewHolder.S.setVisibility(0);
            F(pbCommenFloorItemViewHolder, zfaVar.D0(), zfaVar.M());
            G(true, pbCommenFloorItemViewHolder, zfaVar);
        }
    }

    public final void P(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, zfa zfaVar, View view2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048588, this, pbCommenFloorItemViewHolder, zfaVar, view2, i2) == null) && pbCommenFloorItemViewHolder != null && zfaVar != null) {
            if (zfaVar.k0() > 0) {
                pbCommenFloorItemViewHolder.x.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.x.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    pbCommenFloorItemViewHolder.x.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, zfaVar);
                if (zfaVar.N() == 2) {
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
                sparseArray2.put(R.id.tag_load_sub_data, zfaVar);
            }
            if (this.i != null) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_FLOOR_COMPLAINT);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.i.l());
                statisticItem.param("fname", this.i.m());
                statisticItem.param("tid", this.i.Q());
                statisticItem.param("pid", zfaVar.S());
                TiebaStatic.log(statisticItem);
            }
            if (pbCommenFloorItemViewHolder.U != null) {
                PbFloorComplaint pbFloorComplaint = (PbFloorComplaint) view2.findViewById(R.id.obfuscated_res_0x7f091acb);
                pbCommenFloorItemViewHolder.U = pbFloorComplaint;
                pbCommenFloorItemViewHolder.V = Boolean.TRUE;
                pbFloorComplaint.setRemindText(zfaVar.L());
                pbCommenFloorItemViewHolder.U.setRemindIcon(zfaVar.L());
                if (zfaVar.L() == 0) {
                    pbCommenFloorItemViewHolder.U.setVisibility(8);
                } else {
                    pbCommenFloorItemViewHolder.U.setVisibility(0);
                    if (this.i != null) {
                        StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_FLOOR_COMPLAINT_SHOW);
                        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem2.param("fid", this.i.l());
                        statisticItem2.param("fname", this.i.m());
                        statisticItem2.param("tid", this.i.Q());
                        statisticItem2.param("pid", zfaVar.S());
                        statisticItem2.param("obj_type", zfaVar.L());
                        TiebaStatic.log(statisticItem2);
                    }
                }
                pbCommenFloorItemViewHolder.U.setAmendIconListener(new c(this, zfaVar.K(), zfaVar));
            }
            ImageView imageView2 = pbCommenFloorItemViewHolder.z;
            if (imageView2 != null) {
                SparseArray sparseArray3 = (SparseArray) imageView2.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    pbCommenFloorItemViewHolder.z.setTag(sparseArray3);
                }
                sparseArray3.put(R.id.tag_load_sub_data, zfaVar);
            }
            pbCommenFloorItemViewHolder.w.setVisibility(8);
            if (!zfaVar.z0() && !zfaVar.y0(false)) {
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
                if (this.l == null) {
                    fp9 fp9Var = new fp9(this.mContext);
                    this.l = fp9Var;
                    fp9Var.f(this.j);
                    this.l.h(this.c);
                    this.l.e(this.d);
                    String str = null;
                    yh9 yh9Var = this.i;
                    if (yh9Var != null && yh9Var.O() != null && this.i.O().getAuthor() != null) {
                        str = this.i.O().getAuthor().getUserId();
                    }
                    boolean z = true;
                    z = (str == null || !str.equals(TbadkCoreApplication.getCurrentAccount())) ? false : false;
                    yh9 yh9Var2 = this.i;
                    if (yh9Var2 != null) {
                        this.l.j(yh9Var2.W(), z);
                        this.l.i(this.i.O());
                    }
                }
                this.l.g(zfaVar.S());
                pbCommenFloorItemViewHolder.v.setSubPbAdapter(this.l);
                pbCommenFloorItemViewHolder.v.setVisibility(0);
                pbCommenFloorItemViewHolder.v.setData(zfaVar, view2);
                pbCommenFloorItemViewHolder.v.setChildOnClickListener(this.d);
                pbCommenFloorItemViewHolder.v.setChildOnLongClickListener(this.g);
                pbCommenFloorItemViewHolder.v.setChildOnTouchListener(this.s);
            }
            if (zfaVar.P) {
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
            pbCommenFloorItemViewHolder.g0.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f122e));
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
    public final void W(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, zfa zfaVar, View view2, int i2) {
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
        if ((interceptable == null || interceptable.invokeLLLI(1048594, this, pbCommenFloorItemViewHolder, zfaVar, view2, i2) == null) && pbCommenFloorItemViewHolder != null && zfaVar != null) {
            int i6 = 0;
            if (zfaVar.R) {
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
            if (zfaVar.r() != null) {
                String str7 = this.h;
                if (str7 != null && !str7.equals("0") && this.h.equals(zfaVar.r().getUserId())) {
                    pbCommenFloorItemViewHolder.q.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = zfaVar.r().getIconInfo();
                ArrayList<IconData> tShowInfoNew = zfaVar.r().getTShowInfoNew();
                UserIconBox userIconBox = pbCommenFloorItemViewHolder.G;
                if (userIconBox != null) {
                    userIconBox.setTag(R.id.tag_user_id, zfaVar.r().getUserId());
                    nn9 nn9Var = this.m;
                    if (nn9Var != null) {
                        pbCommenFloorItemViewHolder.G.setOnClickListener(nn9Var.c);
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
                    nn9 nn9Var2 = this.m;
                    if (nn9Var2 != null) {
                        pbCommenFloorItemViewHolder.F.setOnClickListener(nn9Var2.e);
                    }
                    int dimens3 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                    pbCommenFloorItemViewHolder.F.h(tShowInfoNew, 3, dimens3, dimens3, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
                }
                if (ListUtils.isEmpty(tShowInfoNew) && !zfaVar.r().isBigV()) {
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0107, 1);
                } else {
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0301, 1);
                }
                String avater = zfaVar.r().getAvater();
                if (zfaVar.d0) {
                    i5 = 2;
                } else {
                    i5 = 8;
                }
                pbCommenFloorItemViewHolder.g.setTag(i4, zfaVar.r().getUserId());
                pbCommenFloorItemViewHolder.g.setTag(R.id.tag_user_name, zfaVar.r().getUserName());
                pbCommenFloorItemViewHolder.g.setTag(R.id.tag_virtual_user_url, zfaVar.r().getVirtualUserUrl());
                pbCommenFloorItemViewHolder.g.setTag(R.id.tag_statistic_item, wp9.k(this.i, zfaVar, zfaVar.e0, i5, 2));
                String name_show = zfaVar.r().getName_show();
                String userName = zfaVar.r().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    pbCommenFloorItemViewHolder.g.setText(cg9.b(this.mContext, pbCommenFloorItemViewHolder.g.getText().toString()));
                    pbCommenFloorItemViewHolder.g.setGravity(16);
                    pbCommenFloorItemViewHolder.g.setTag(R.id.tag_nick_name_activity, cg9.a());
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0312, 1);
                }
                if (zfaVar.r().getPendantData() != null && !StringUtils.isNull(zfaVar.r().getPendantData().getImgUrl())) {
                    pbCommenFloorItemViewHolder.E.setBigVDimenSize(R.dimen.tbds36);
                    pbCommenFloorItemViewHolder.E.i(zfaVar.r());
                    pbCommenFloorItemViewHolder.p.setVisibility(8);
                    pbCommenFloorItemViewHolder.E.setVisibility(0);
                    pbCommenFloorItemViewHolder.E.getHeadView().startLoad(avater, 28, false);
                    pbCommenFloorItemViewHolder.E.getHeadView().setUserId(zfaVar.r().getUserId());
                    pbCommenFloorItemViewHolder.E.getHeadView().setUserName(zfaVar.r().getUserName());
                    yh9 yh9Var = this.i;
                    if (yh9Var == null) {
                        str4 = "";
                    } else {
                        str4 = yh9Var.l();
                    }
                    pbCommenFloorItemViewHolder.E.getHeadView().setFid(str4);
                    yh9 yh9Var2 = this.i;
                    if (yh9Var2 == null) {
                        str5 = "";
                    } else {
                        str5 = yh9Var2.m();
                    }
                    pbCommenFloorItemViewHolder.E.getHeadView().setFName(str5);
                    pbCommenFloorItemViewHolder.E.getHeadView().setFloor(zfaVar.I());
                    pbCommenFloorItemViewHolder.E.getHeadView().setTid(zfaVar.S());
                    pbCommenFloorItemViewHolder.E.getHeadView().setTag(R.id.tag_statistic_item, wp9.k(this.i, zfaVar, zfaVar.e0, i5, 2));
                    pbCommenFloorItemViewHolder.E.i(zfaVar.r());
                } else {
                    pbCommenFloorItemViewHolder.p.setGodIconWidth(R.dimen.tbds36);
                    UtilHelper.showHeadImageViewBigV(pbCommenFloorItemViewHolder.p, zfaVar.r(), 4);
                    pbCommenFloorItemViewHolder.p.setUserId(zfaVar.r().getUserId());
                    yh9 yh9Var3 = this.i;
                    if (yh9Var3 == null) {
                        str2 = "";
                    } else {
                        str2 = yh9Var3.l();
                    }
                    pbCommenFloorItemViewHolder.p.setFid(str2);
                    yh9 yh9Var4 = this.i;
                    if (yh9Var4 == null) {
                        str3 = "";
                    } else {
                        str3 = yh9Var4.m();
                    }
                    pbCommenFloorItemViewHolder.p.setFName(str3);
                    pbCommenFloorItemViewHolder.p.setFloor(zfaVar.I());
                    pbCommenFloorItemViewHolder.p.setTid(zfaVar.S());
                    pbCommenFloorItemViewHolder.p.setUserName(zfaVar.r().getUserName(), zfaVar.s0());
                    pbCommenFloorItemViewHolder.p.setTag(R.id.tag_virtual_user_url, zfaVar.r().getVirtualUserUrl());
                    pbCommenFloorItemViewHolder.p.setTag(R.id.tag_statistic_item, wp9.k(this.i, zfaVar, zfaVar.e0, i5, 2));
                    pbCommenFloorItemViewHolder.p.setImageDrawable(null);
                    pbCommenFloorItemViewHolder.p.startLoad(avater, 28, false);
                    pbCommenFloorItemViewHolder.p.setVisibility(0);
                    pbCommenFloorItemViewHolder.E.setVisibility(8);
                }
                if (zfaVar.r() != null && zfaVar.r().getAlaInfo() != null && zfaVar.r().getAlaUserData() != null && zfaVar.r().getAlaUserData().live_status == 1) {
                    pbCommenFloorItemViewHolder.e(true);
                    pbCommenFloorItemViewHolder.p.setLiveStatus(1);
                    pbCommenFloorItemViewHolder.p.setAlaInfo(zfaVar.r().getAlaInfo());
                    pbCommenFloorItemViewHolder.E.getHeadView().setLiveStatus(1);
                    pbCommenFloorItemViewHolder.E.getHeadView().setAlaInfo(zfaVar.r().getAlaInfo());
                    threadData = null;
                } else {
                    pbCommenFloorItemViewHolder.e(false);
                    pbCommenFloorItemViewHolder.p.setLiveStatus(0);
                    threadData = null;
                    pbCommenFloorItemViewHolder.p.setAlaInfo(null);
                    pbCommenFloorItemViewHolder.E.getHeadView().setLiveStatus(0);
                    pbCommenFloorItemViewHolder.E.getHeadView().setAlaInfo(null);
                }
                k0(pbCommenFloorItemViewHolder.i, zfaVar);
            }
            if (zfaVar.r() == null) {
                str = "";
                i3 = 0;
            } else {
                i3 = zfaVar.r().getLevel_id();
                str = zfaVar.r().getLevelName();
            }
            yh9 yh9Var5 = this.i;
            if (yh9Var5 != null && yh9Var5.j0()) {
                i3 = 0;
            }
            if (i3 > 0) {
                pbCommenFloorItemViewHolder.D.setVisibility(0);
                pbCommenFloorItemViewHolder.D.setLevel(i3, str);
            } else {
                pbCommenFloorItemViewHolder.D.setVisibility(8);
            }
            if (zfaVar.r() != null) {
                str6 = zfaVar.r().getName_show();
            }
            pbCommenFloorItemViewHolder.g.setText(str6);
            pbCommenFloorItemViewHolder.f.post(new b(this, pbCommenFloorItemViewHolder, str6));
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, zfaVar);
            sparseArray.put(R.id.tag_load_sub_data, zfaVar);
            sparseArray.put(R.id.tag_load_sub_view, view2);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(zfaVar.I()));
            sparseArray.put(R.id.tag_forbid_user_post_id, zfaVar.S());
            sparseArray.put(R.id.pb_dialog_item_zan_1, pbCommenFloorItemViewHolder.o);
            sparseArray.put(R.id.pb_dialog_item_zan_2, pbCommenFloorItemViewHolder.c0);
            sparseArray.put(R.id.pb_dialog_item_reply, pbCommenFloorItemViewHolder.y);
            sparseArray.put(R.id.pb_dialog_item_share, pbCommenFloorItemViewHolder.z);
            yh9 yh9Var6 = this.i;
            if (yh9Var6 != null && yh9Var6.O() != null) {
                threadData = this.i.O();
            }
            if (threadData != null && threadData.isUgcThreadType()) {
                sparseArray.put(R.id.pb_dialog_item_isugc, Boolean.TRUE);
            } else {
                sparseArray.put(R.id.pb_dialog_item_isugc, Boolean.FALSE);
            }
            if (zfaVar.r() != null && !StringUtils.isNull(zfaVar.r().getVirtualUserUrl())) {
                z = true;
            } else {
                z = false;
            }
            yh9 yh9Var7 = this.i;
            if (yh9Var7 != null && yh9Var7.W() != 0 && !Z()) {
                if (this.i.W() != 1002 && this.i.W() != 3) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (this.i.W() != 3 && !this.i.j0()) {
                    z3 = true;
                    z4 = true;
                } else {
                    z3 = false;
                    z4 = false;
                }
                if (zfaVar != null && zfaVar.r() != null) {
                    String userId = zfaVar.r().getUserId();
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
            yh9 yh9Var8 = this.i;
            if (yh9Var8 != null && yh9Var8.O() != null && this.i.O().getAuthor() != null && zfaVar.r() != null) {
                String userId2 = this.i.O().getAuthor().getUserId();
                String userId3 = zfaVar.r().getUserId();
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
                    if (zfaVar != null && zfaVar.r() != null && UtilHelper.isCurrentAccount(zfaVar.r().getUserId())) {
                        z4 = true;
                        z6 = true;
                    }
                    if (z) {
                        z2 = false;
                        z5 = false;
                        z4 = false;
                    }
                    if (zfaVar.I() != 1) {
                        i6 = 1;
                    }
                    if (!z2) {
                        sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.i.W()));
                        if (zfaVar.r() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, zfaVar.r().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, zfaVar.r().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, zfaVar.r().getPortrait());
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                    }
                    if (!z5) {
                        sparseArray.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (zfaVar.r() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, zfaVar.r().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, zfaVar.r().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, zfaVar.r().getName_show());
                        }
                        if (this.i.O() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.i.O().getId());
                        }
                        sparseArray.put(R.id.tag_user_mute_post_id, zfaVar.S());
                    } else {
                        sparseArray.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                    }
                    if (!z4) {
                        sparseArray.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_has_sub_post, Boolean.valueOf(zfaVar.z0()));
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.i.W()));
                        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i6));
                        sparseArray.put(R.id.tag_del_post_id, zfaVar.S());
                    } else {
                        sparseArray.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                    }
                    sparseArray.put(R.id.tag_mul_del_post_type, Boolean.valueOf(z3));
                    sparseArray.put(R.id.tag_is_self_post, Boolean.valueOf(z7));
                    pbCommenFloorItemViewHolder.q.setTag(sparseArray);
                    pbCommenFloorItemViewHolder.s.setTag(sparseArray);
                }
            }
            z5 = false;
            z6 = false;
            z7 = false;
            if (zfaVar != null) {
                z4 = true;
                z6 = true;
            }
            if (z) {
            }
            if (zfaVar.I() != 1) {
            }
            if (!z2) {
            }
            if (!z5) {
            }
            if (!z4) {
            }
            sparseArray.put(R.id.tag_mul_del_post_type, Boolean.valueOf(z3));
            sparseArray.put(R.id.tag_is_self_post, Boolean.valueOf(z7));
            pbCommenFloorItemViewHolder.q.setTag(sparseArray);
            pbCommenFloorItemViewHolder.s.setTag(sparseArray);
        }
    }

    public final boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            yh9 yh9Var = this.i;
            if (yh9Var != null && yh9Var.O() != null) {
                return this.i.O().isBlocked();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.om
    /* renamed from: a0 */
    public PbCommenFloorItemViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d07b4, viewGroup, false);
            ((ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f091b38)).addView(LayoutInflater.from(inflate.getContext()).inflate(R.layout.obfuscated_res_0x7f0d07ac, (ViewGroup) null));
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = new PbCommenFloorItemViewHolder(this.b, inflate, 0);
            pbCommenFloorItemViewHolder.t.setConstrainLayoutPool(this.q);
            pbCommenFloorItemViewHolder.t.setImageViewPool(this.r);
            SubPbLayout subPbLayout = pbCommenFloorItemViewHolder.v;
            if (subPbLayout != null) {
                subPbLayout.setShowChildComment(true);
                pbCommenFloorItemViewHolder.v.setIsVideoThread(false);
            }
            i0(pbCommenFloorItemViewHolder);
            return pbCommenFloorItemViewHolder;
        }
        return (PbCommenFloorItemViewHolder) invokeL.objValue;
    }

    public View b0(int i2, View view2, ViewGroup viewGroup, zfa zfaVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, zfaVar, pbCommenFloorItemViewHolder})) == null) {
            i0(pbCommenFloorItemViewHolder);
            c0(pbCommenFloorItemViewHolder);
            D(pbCommenFloorItemViewHolder);
            zfa zfaVar2 = (zfa) getItem(i2);
            if (zfaVar2 != null) {
                zfaVar2.e0 = i2 + 1;
                zfaVar2.y1();
                I(zfaVar2);
                M(pbCommenFloorItemViewHolder, zfaVar2, view2, i2);
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
            pbCommenFloorItemViewHolder.p.setOnClickListener(this.m.b);
            pbCommenFloorItemViewHolder.E.setOnClickListener(this.m.b);
            pbCommenFloorItemViewHolder.E.getHeadView().setOnClickListener(this.m.b);
            pbCommenFloorItemViewHolder.q.setOnLongClickListener(this.g);
            pbCommenFloorItemViewHolder.q.setOnTouchListener(this.s);
            pbCommenFloorItemViewHolder.q.setCommonTextViewOnClickListener(this.d);
            pbCommenFloorItemViewHolder.q.setOnImageClickListener(this.e);
            pbCommenFloorItemViewHolder.q.setOnImageTouchListener(this.s);
            pbCommenFloorItemViewHolder.q.setOnEmotionClickListener(this.m.f);
            pbCommenFloorItemViewHolder.q.setOnVoiceAfterClickListener(this.d);
            pbCommenFloorItemViewHolder.J.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.K.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.M.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.w.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.x.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.l0.setOnTouchListener(this.s);
            pbCommenFloorItemViewHolder.l0.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.h0.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.d0.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.n0.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.e0.setOnClickListener(new g(this, pbCommenFloorItemViewHolder));
            pbCommenFloorItemViewHolder.c.setOnClickListener(new h(this, pbCommenFloorItemViewHolder));
            pbCommenFloorItemViewHolder.y.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.z.setOnClickListener(new i(this, pbCommenFloorItemViewHolder));
            pbCommenFloorItemViewHolder.o.D = new j(this, pbCommenFloorItemViewHolder);
            pbCommenFloorItemViewHolder.c0.D = new k(this, pbCommenFloorItemViewHolder);
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
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.y, R.drawable.obfuscated_res_0x7f080bab, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.z, R.drawable.obfuscated_res_0x7f080bac, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbCommenFloorItemViewHolder.v.d();
            pbCommenFloorItemViewHolder.t.b();
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.P, R.color.CAM_X0304, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.N, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.M, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.O, R.color.CAM_X0109);
            SkinManager.setImageResource(pbCommenFloorItemViewHolder.Q, R.drawable.icon_arrow_more_gray);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f1151T, (int) R.color.CAM_X0107);
            if (pbCommenFloorItemViewHolder.R.getVisibility() != 8) {
                z = false;
            }
            if (z) {
                pbCommenFloorItemViewHolder.f1151T.setText(R.string.obfuscated_res_0x7f0f0475);
            } else {
                yh9 yh9Var = this.i;
                if (yh9Var != null && StringUtils.isNull(yh9Var.j())) {
                    pbCommenFloorItemViewHolder.f1151T.setText(this.i.j());
                } else {
                    pbCommenFloorItemViewHolder.f1151T.setText(R.string.obfuscated_res_0x7f0f06ec);
                }
            }
            pbCommenFloorItemViewHolder.o.Q(TbadkCoreApplication.getInst().getSkinType());
            pbCommenFloorItemViewHolder.d(skinType);
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.I, R.color.CAM_X0203);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.d0, R.drawable.icon_pure_pb_more18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.n0, R.drawable.icon_pure_pb_more18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbCommenFloorItemViewHolder.c();
        }
        pbCommenFloorItemViewHolder.a = skinType;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.baidu.tieba.om
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i2, View view2, ViewGroup viewGroup, zfa zfaVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        b0(i2, view2, viewGroup, zfaVar, pbCommenFloorItemViewHolder);
        return view2;
    }
}

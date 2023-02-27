package com.baidu.tieba;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b88 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public static final float m;
    public static final float n;
    public static final float o;
    public static final int p;
    public static final int q;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public final ArrayList<MarkData> b;
    public boolean c;
    public View.OnClickListener d;
    public View.OnClickListener e;
    public View.OnClickListener f;
    public boolean g;
    public boolean h;
    public boolean i;
    public Runnable j;
    public final View.OnClickListener k;
    public View.OnClickListener l;

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 3;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b88 a;

        public a(b88 b88Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b88Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b88Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements OriginalThreadCardView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(b88 b88Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b88Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.card.OriginalThreadCardView.b
        public void a(OriginalThreadInfo originalThreadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, originalThreadInfo) == null) {
                TiebaStatic.log(new StatisticItem("c12529").param("obj_locate", 5));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b88 a;

        public c(b88 b88Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b88Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b88Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MarkData item = this.a.getItem(((Integer) view2.getTag()).intValue());
                StatisticItem statisticItem = new StatisticItem("c12529");
                if (view2 instanceof CommonUserLikeButton) {
                    statisticItem.param("obj_locate", 4);
                } else if (view2 instanceof ClickableHeaderImageView) {
                    statisticItem.param("obj_locate", 1);
                }
                statisticItem.param("tid", item.getId());
                statisticItem.param("obj_id", item.getUesrId());
                TiebaStatic.log(statisticItem);
                z78.b("c14064", item);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b88 a;

        public d(b88 b88Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b88Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b88Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                z78.b("c14065", this.a.getItem(((Integer) view2.getTag()).intValue()));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ImageButton a;
        public ClickableHeaderImageView b;
        public TextView c;
        public CommonUserLikeButton d;
        public TextView e;
        public TextView f;
        public ImageView g;
        public LinearLayout h;
        public LinearLayout i;
        public LinearLayout j;
        public View k;
        public c75 l;
        public final /* synthetic */ b88 m;

        public e(b88 b88Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b88Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.m = b88Var;
        }

        public void b(ClickableHeaderImageView clickableHeaderImageView) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, clickableHeaderImageView) != null) || clickableHeaderImageView == null) {
                return;
            }
            clickableHeaderImageView.setDefaultResource(17170445);
            clickableHeaderImageView.setPlaceHolder(1);
            clickableHeaderImageView.setIsRound(true);
            clickableHeaderImageView.setAfterClickListener(this.m.k);
        }

        public /* synthetic */ e(b88 b88Var, a aVar) {
            this(b88Var);
        }

        public void a(MarkData markData) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, markData) != null) || markData == null) {
                return;
            }
            String title = markData.getTitle();
            if (!TextUtils.isEmpty(title)) {
                if (markData.is_deleted()) {
                    this.e.setText(title);
                    this.e.setTextSize(0, b88.m);
                    SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0110);
                } else {
                    this.e.setText(title);
                    this.e.setTextSize(0, b88.n);
                    SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0105);
                }
            } else {
                this.e.setText("");
            }
            c(markData);
            this.b.setData(markData.metaData);
            this.b.setShowV(markData.metaData.isBigV());
            this.l.n(markData.metaData);
            this.d.g(TbadkCoreApplication.getInst().getSkinType());
            this.d.setTextSize(0, b88.o);
            if ((markData.metaData.getIsLike() || StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), markData.getUesrId())) && !markData.isLikeInPage()) {
                this.d.setVisibility(8);
            } else {
                this.d.setVisibility(0);
            }
            if ((!StringUtils.isNull(markData.getmState()) && markData.getNewCounts() > 0) || markData.is_deleted()) {
                this.j.setVisibility(0);
                if (markData.isRedTipShow() && !markData.is_deleted()) {
                    this.g.setVisibility(0);
                } else {
                    this.g.setVisibility(8);
                }
                if (markData.is_deleted()) {
                    this.f.setText(this.m.a.getString(R.string.mark_thread_deleted));
                } else {
                    this.f.setText(markData.getmState());
                }
                SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0109);
            } else {
                this.j.setVisibility(8);
            }
            SkinManager.setBackgroundColor(this.k, R.color.CAM_X0204);
        }

        public final void c(MarkData markData) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, markData) != null) || markData == null) {
                return;
            }
            this.c.setText(markData.getAuthorName());
            if (markData.metaData.isBigV()) {
                SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0301);
            } else {
                SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0106);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public ProgressBar b;

        public f(b88 b88Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b88Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ f(b88 b88Var, a aVar) {
            this(b88Var);
        }
    }

    /* loaded from: classes3.dex */
    public class g extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public OriginalThreadCardView n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(b88 b88Var, View view2) {
            super(b88Var, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b88Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((b88) objArr2[0], (a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09200c);
            this.a = (ImageButton) view2.findViewById(R.id.obfuscated_res_0x7f09200d);
            this.b = (ClickableHeaderImageView) view2.findViewById(R.id.obfuscated_res_0x7f092012);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092013);
            this.d = (CommonUserLikeButton) view2.findViewById(R.id.obfuscated_res_0x7f092011);
            this.l = new c75(b88Var.a, this.d);
            this.i = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09200e);
            this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092032);
            this.n = (OriginalThreadCardView) view2.findViewById(R.id.obfuscated_res_0x7f09201b);
            this.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092010);
            this.g = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f092017);
            this.j = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09200f);
            this.k = view2.findViewById(R.id.obfuscated_res_0x7f092030);
            b(this.b);
        }

        @Override // com.baidu.tieba.b88.e
        public void a(MarkData markData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, markData) == null) {
                super.a(markData);
                this.n.i(markData.getOriginalThreadInfo());
                this.n.s();
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.n.getLayoutParams();
                if ((!StringUtils.isNull(markData.getmState()) && markData.getNewCounts() > 0) || markData.is_deleted()) {
                    layoutParams.bottomMargin = 0;
                } else {
                    layoutParams.bottomMargin = (int) b88.m;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView n;
        public LinearLayout o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(b88 b88Var, View view2) {
            super(b88Var, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b88Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((b88) objArr2[0], (a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090ec0);
            this.b = (ClickableHeaderImageView) view2.findViewById(R.id.obfuscated_res_0x7f0915fa);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0915fb);
            this.i = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090ec3);
            this.o = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090ec2);
            this.d = (CommonUserLikeButton) view2.findViewById(R.id.obfuscated_res_0x7f091600);
            this.l = new c75(b88Var.a, this.d);
            this.n = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0915fe);
            this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0915ff);
            this.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0915fd);
            this.a = (ImageButton) view2.findViewById(R.id.obfuscated_res_0x7f090ec1);
            this.g = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0917d5);
            this.j = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0915fc);
            this.k = view2.findViewById(R.id.obfuscated_res_0x7f0922bf);
            b(this.b);
            this.n.setPlaceHolder(1);
        }

        @Override // com.baidu.tieba.b88.e
        public void a(MarkData markData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, markData) == null) {
                super.a(markData);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.i.getLayoutParams();
                if (hx4.c().g() && !StringUtils.isNull(markData.getPic_url())) {
                    String pic_url = markData.getPic_url();
                    if (!StringUtils.isNull(pic_url)) {
                        this.n.setVisibility(0);
                        this.n.K(pic_url, 10, false);
                    }
                    layoutParams.bottomMargin = b88.p;
                } else {
                    this.n.setVisibility(8);
                    layoutParams.bottomMargin = b88.q;
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.o.getLayoutParams();
                if ((!StringUtils.isNull(markData.getmState()) && markData.getNewCounts() > 0) || markData.is_deleted()) {
                    layoutParams2.bottomMargin = 0;
                } else {
                    layoutParams2.bottomMargin = (int) b88.m;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947598951, "Lcom/baidu/tieba/b88;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947598951, "Lcom/baidu/tieba/b88;");
                return;
            }
        }
        m = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070207);
        n = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070215);
        o = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701f0);
        p = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701f9);
        q = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d5);
    }

    public b88(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new ArrayList<>();
        this.c = false;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = false;
        this.h = true;
        this.i = true;
        this.k = new c(this);
        this.l = new d(this);
        this.a = tbPageContext;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            if (ListUtils.getCount(this.b) <= i) {
                return -1L;
            }
            return i;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            MarkData item = getItem(i);
            if (item == null) {
                return 1;
            }
            if (item.isShareThread()) {
                return 2;
            }
            return 0;
        }
        return invokeI.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: h */
    public MarkData getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            return (MarkData) ListUtils.getItem(this.b, i);
        }
        return (MarkData) invokeI.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            if (!ListUtils.isEmpty(this.b)) {
                if (this.h || getItemViewType(i) != 1) {
                    return super.isEnabled(i);
                }
                return false;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void j(ArrayList<MarkData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, arrayList) == null) {
            this.b.clear();
            if (arrayList != null) {
                this.b.addAll(arrayList);
            }
            notifyDataSetChanged();
        }
    }

    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onClickListener) == null) {
            this.d = onClickListener;
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.c = z;
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.i = z;
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.h = z;
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.g = z;
        }
    }

    public void q(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, onClickListener) == null) {
            this.f = onClickListener;
        }
    }

    public void r(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onClickListener) == null) {
            this.e = onClickListener;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (ListUtils.isEmpty(this.b)) {
                return 0;
            }
            if (this.i) {
                return ListUtils.getCount(this.b) + 1;
            }
            return ListUtils.getCount(this.b);
        }
        return invokeV.intValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.j != null) {
            gh.a().removeCallbacks(this.j);
        }
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (!ej.E()) {
                if (this.j == null) {
                    this.j = new a(this);
                }
                gh.a().post(this.j);
                return;
            }
            super.notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        e hVar;
        f fVar;
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i, view2, viewGroup)) == null) {
            int itemViewType = getItemViewType(i);
            boolean z = true;
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    if (itemViewType == 2) {
                        if (view2 != null && (view2.getTag() instanceof g)) {
                            gVar = (g) view2.getTag();
                        } else {
                            view2 = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d01d5, (ViewGroup) null);
                            gVar = new g(this, view2);
                            view2.setTag(gVar);
                        }
                        MarkData item = getItem(i);
                        if (item == null) {
                            gVar.a.setVisibility(8);
                            return view2;
                        }
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gVar.h.getLayoutParams();
                        if (this.c) {
                            gVar.a.setVisibility(0);
                            layoutParams.leftMargin = 0;
                        } else {
                            gVar.a.setVisibility(8);
                            layoutParams.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07020f);
                        }
                        gVar.a(item);
                        o(i, gVar);
                        gVar.n.setSubClickListener(new b(this));
                    }
                } else {
                    if (view2 != null && (view2.getTag() instanceof f)) {
                        fVar = (f) view2.getTag();
                    } else {
                        view2 = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d06e1, (ViewGroup) null);
                        fVar = new f(this, null);
                        fVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0918db);
                        fVar.b = (ProgressBar) view2.findViewById(R.id.obfuscated_res_0x7f091c06);
                        view2.setTag(fVar);
                    }
                    fVar.a.setVisibility(0);
                    if (this.g) {
                        fVar.b.setVisibility(0);
                        fVar.a.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0af9));
                        SkinManager.setViewTextColor(fVar.a, R.color.common_color_10039, 1);
                    } else if (!this.h) {
                        fVar.b.setVisibility(8);
                        fVar.a.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0d45));
                        SkinManager.setViewTextColor(fVar.a, R.color.common_color_10005, 1);
                    } else {
                        fVar.b.setVisibility(8);
                        fVar.a.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0af9));
                        SkinManager.setViewTextColor(fVar.a, R.color.common_color_10039, 1);
                    }
                }
            } else {
                if (view2 != null && (view2.getTag() instanceof h)) {
                    hVar = (h) view2.getTag();
                } else {
                    view2 = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d03b7, (ViewGroup) null);
                    hVar = new h(this, view2);
                    view2.setTag(hVar);
                }
                MarkData item2 = getItem(i);
                if (item2 == null) {
                    hVar.a.setVisibility(8);
                    return view2;
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) hVar.h.getLayoutParams();
                if (this.c) {
                    hVar.a.setVisibility(0);
                    layoutParams2.leftMargin = 0;
                } else {
                    hVar.a.setVisibility(8);
                    layoutParams2.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07020f);
                }
                hVar.a(item2);
                o(i, hVar);
            }
            xw4 layoutMode = this.a.getLayoutMode();
            if (TbadkCoreApplication.getInst().getSkinType() != 4) {
                z = false;
            }
            layoutMode.l(z);
            this.a.getLayoutMode().k(view2);
            z78.b("c14062", getItem(i));
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    public final void o(int i, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048591, this, i, eVar) == null) {
            Integer valueOf = Integer.valueOf(i);
            eVar.i.setOnClickListener(this.e);
            eVar.i.setTag(valueOf);
            eVar.b.setAfterClickListener(this.k);
            eVar.b.setTag(valueOf);
            eVar.d.setAfterOnClickListener(this.k);
            eVar.d.setAfterOnClickListener(this.l);
            eVar.d.setTag(valueOf);
            eVar.j.setOnClickListener(this.f);
            eVar.j.setTag(valueOf);
            eVar.a.setOnClickListener(this.d);
            eVar.a.setFocusable(false);
            eVar.a.setTag(valueOf);
        }
    }
}

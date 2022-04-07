package com.baidu.tieba.emotion.editortool;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.UserCollectManageActivityConfig;
import com.baidu.tbadk.core.util.EmotionUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.gif.GifInfo;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.compatible.menukey.MenuKeyUtils;
import com.repackage.a15;
import com.repackage.a46;
import com.repackage.ax4;
import com.repackage.bx4;
import com.repackage.dg;
import com.repackage.eg;
import com.repackage.fo;
import com.repackage.hg;
import com.repackage.i05;
import com.repackage.i35;
import com.repackage.ig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class EmotionTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context A;
    public dg<GridView> B;
    public CustomMessageListener C;
    public ViewPager a;
    public EmotionViewPagerAdapter b;
    public GridView c;
    public IndicatorView d;
    public LinearLayout e;
    public WindowManager f;
    public WindowManager.LayoutParams g;
    public GifView h;
    public final Rect i;
    public ViewGroup j;
    public int k;
    public int l;
    public int m;
    public boolean n;
    public int o;
    public a46 p;
    public List<a15> q;
    public List<a46> r;
    public int s;
    public int t;
    public int u;
    public d v;
    public int w;
    public final Point x;
    public EditorTools y;
    public int z;

    /* loaded from: classes3.dex */
    public class EmotionViewPagerAdapter extends PagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionTabContentView a;

        /* loaded from: classes3.dex */
        public class a implements AdapterView.OnItemLongClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ EmotionViewPagerAdapter a;

            public a(EmotionViewPagerAdapter emotionViewPagerAdapter) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {emotionViewPagerAdapter};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = emotionViewPagerAdapter;
            }

            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view2, int i, long j) {
                InterceptResult invokeCommon;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)})) == null) {
                    c cVar = (c) adapterView.getAdapter();
                    if (cVar == null || cVar.a() == null) {
                        return false;
                    }
                    a46 a = cVar.a();
                    if (a.c() == EmotionGroupType.BIG_EMOTION || a.c() == EmotionGroupType.USER_COLLECT) {
                        this.a.a.A(i, (GridView) adapterView);
                        return true;
                    }
                    return false;
                }
                return invokeCommon.booleanValue;
            }
        }

        /* loaded from: classes3.dex */
        public class b implements AdapterView.OnItemClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ EmotionViewPagerAdapter a;

            public b(EmotionViewPagerAdapter emotionViewPagerAdapter) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {emotionViewPagerAdapter};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = emotionViewPagerAdapter;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                    adapterView.setSelection(-1);
                    if (this.a.a.y != null) {
                        ax4 ax4Var = new ax4();
                        c cVar = (c) adapterView.getAdapter();
                        if (cVar == null || cVar.a() == null) {
                            return;
                        }
                        a46 a = cVar.a();
                        int b = cVar.b();
                        a15 j2 = a.j();
                        String b2 = a.j().b(b + i);
                        if (j2.h() == EmotionGroupType.USER_COLLECT && i35.d.equals(b2)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UserCollectManageActivityConfig(this.a.a.A)));
                            return;
                        }
                        ax4Var.j(b2);
                        ax4Var.m(j2.h());
                        ax4Var.l(j2.g());
                        ax4Var.k(j2.f());
                        ax4Var.o(j2.l());
                        ax4Var.i(j2.i());
                        bx4 bx4Var = new bx4();
                        bx4Var.a = this.a.a.y.getFid();
                        bx4Var.b = this.a.a.y.getTid();
                        bx4Var.d = a.g() + 1;
                        bx4Var.h = a.e() + 1;
                        bx4Var.f = (a.e() * 21) + i + 1;
                        bx4Var.g = 0;
                        bx4Var.e = 0;
                        if (this.a.a.y.a.getBarLauncherType() != 3) {
                            if (this.a.a.y.a.getBarLauncherType() == 2) {
                                bx4Var.e = 2;
                            }
                        } else {
                            bx4Var.e = 1;
                        }
                        bx4Var.c = TbadkCoreApplication.getCurrentAccount();
                        ax4Var.h(bx4Var);
                        this.a.a.y.A(new i05(24, -1, ax4Var));
                        this.a.a.s(bx4Var, "c14122");
                    }
                }
            }
        }

        public EmotionViewPagerAdapter(EmotionTabContentView emotionTabContentView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionTabContentView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionTabContentView;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, viewGroup, i, obj) == null) {
                GridView gridView = (GridView) obj;
                viewGroup.removeView(gridView);
                this.a.B.e(gridView);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.a.r == null) {
                    return 0;
                }
                return this.a.r.size();
            }
            return invokeV.intValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i)) == null) {
                GridView gridView = (GridView) this.a.B.b();
                if (gridView == null) {
                    gridView = new GridView(this.a.A);
                }
                gridView.setScrollbarFadingEnabled(false);
                if (this.a.r != null && i < this.a.r.size()) {
                    a46 a46Var = (a46) this.a.r.get(i);
                    gridView.setNumColumns(a46Var.a());
                    gridView.setVerticalSpacing(0);
                    gridView.setHorizontalSpacing(0);
                    gridView.setSelector(R.color.common_color_10022);
                    gridView.setPadding(this.a.A.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701f9), 0, this.a.A.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701f9), 0);
                    gridView.setOnItemLongClickListener(new a(this));
                    gridView.setOnItemClickListener(new b(this));
                    gridView.setAdapter((ListAdapter) new c(this.a, a46Var));
                }
                viewGroup.addView(gridView);
                return gridView;
            }
            return invokeLI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view2, Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view2, obj)) == null) ? view2 == obj : invokeLL.booleanValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048580, this, viewGroup, i, obj) == null) {
                if (this.a.r != null) {
                    int size = this.a.r.size();
                    if (i == 0 && i < size && i != this.a.u) {
                        a46 a46Var = (a46) this.a.r.get(i);
                        if (a46Var != null) {
                            this.a.u = i;
                            this.a.d.setVisibility(a46Var.f() > 1 ? 0 : 4);
                            this.a.d.setCount(a46Var.f());
                            this.a.d.setPosition(a46Var.e());
                            this.a.d.setContentDescription(String.format(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0553), Integer.valueOf(a46Var.e() + 1)) + String.format(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0552), Integer.valueOf(a46Var.f())));
                        }
                        if (a46Var != null && a46Var.g() != this.a.t) {
                            this.a.t = a46Var.g();
                            if (this.a.v != null) {
                                this.a.v.c(a46Var.g());
                            }
                        }
                    }
                }
                super.setPrimaryItem(viewGroup, i, obj);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a implements eg<GridView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionTabContentView a;

        public a(EmotionTabContentView emotionTabContentView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionTabContentView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionTabContentView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.eg
        public /* bridge */ /* synthetic */ GridView a(GridView gridView) {
            GridView gridView2 = gridView;
            e(gridView2);
            return gridView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.eg
        public /* bridge */ /* synthetic */ GridView c(GridView gridView) {
            GridView gridView2 = gridView;
            h(gridView2);
            return gridView2;
        }

        public GridView e(GridView gridView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, gridView)) == null) ? gridView : (GridView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.eg
        /* renamed from: f */
        public void b(GridView gridView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, gridView) == null) {
                gridView.setAdapter((ListAdapter) null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.eg
        /* renamed from: g */
        public GridView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new GridView(this.a.getContext()) : (GridView) invokeV.objValue;
        }

        public GridView h(GridView gridView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, gridView)) == null) {
                gridView.setAdapter((ListAdapter) null);
                return gridView;
            }
            return (GridView) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionTabContentView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(EmotionTabContentView emotionTabContentView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionTabContentView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionTabContentView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2921028) {
                this.a.t(new ArrayList(this.a.q));
                if (this.a.b == null) {
                    return;
                }
                this.a.b.notifyDataSetChanged();
                if ((this.a.t < 0 || this.a.t >= this.a.q.size() || ((a15) this.a.q.get(this.a.t)).h() == EmotionGroupType.USER_COLLECT) && this.a.b != null) {
                    if (this.a.u >= 0 && this.a.u < this.a.r.size()) {
                        EmotionTabContentView emotionTabContentView = this.a;
                        emotionTabContentView.p = (a46) emotionTabContentView.r.get(this.a.u);
                        int f = this.a.p.f();
                        this.a.d.setCount(f);
                        this.a.d.setVisibility(f > 1 ? 0 : 4);
                    }
                    if (this.a.a != null) {
                        for (int i = 0; i < this.a.a.getChildCount(); i++) {
                            try {
                                View childAt = this.a.a.getChildAt(i);
                                if (childAt != null && (childAt instanceof GridView)) {
                                    GridView gridView = (GridView) childAt;
                                    if (gridView.getAdapter() != null && (gridView.getAdapter() instanceof c)) {
                                        c cVar = (c) gridView.getAdapter();
                                        int d = cVar.a().d();
                                        if (d >= 0 && d < this.a.r.size()) {
                                            cVar.c((a46) this.a.r.get(d));
                                            cVar.notifyDataSetChanged();
                                        }
                                    }
                                }
                            } catch (Throwable unused) {
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public a46 a;
        public final /* synthetic */ EmotionTabContentView b;

        /* loaded from: classes3.dex */
        public class a extends hg<fo> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.hg
            public void onLoaded(fo foVar, String str, int i) {
                View findViewWithTag;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeLLI(1048576, this, foVar, str, i) == null) || foVar == null || (findViewWithTag = this.a.b.findViewWithTag(str)) == null || !(findViewWithTag instanceof TbImageView) || str == null) {
                    return;
                }
                TbImageView tbImageView = (TbImageView) findViewWithTag;
                foVar.h(tbImageView);
                tbImageView.setTag(null);
            }
        }

        public c(EmotionTabContentView emotionTabContentView, a46 a46Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionTabContentView, a46Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = emotionTabContentView;
            this.a = a46Var;
        }

        public a46 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (a46) invokeV.objValue;
        }

        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                a46 a46Var = this.a;
                if (a46Var == null) {
                    return 0;
                }
                return a46Var.i();
            }
            return invokeV.intValue;
        }

        public void c(a46 a46Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, a46Var) == null) {
                this.a = a46Var;
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                a46 a46Var = this.a;
                if (a46Var == null) {
                    return 0;
                }
                return a46Var.b();
            }
            return invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) ? Integer.valueOf(i) : invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) ? i : invokeI.longValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view2, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            LinearLayout linearLayout;
            int i2;
            int color;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i, view2, viewGroup)) == null) {
                if (view2 == null) {
                    LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.obfuscated_res_0x7f0d0270, (ViewGroup) null);
                    int measuredWidth = viewGroup.getMeasuredWidth();
                    int measuredHeight = viewGroup.getMeasuredHeight();
                    int a2 = this.a.a() != 0 ? measuredWidth / this.a.a() : 0;
                    int h = this.a.h() != 0 ? measuredHeight / this.a.h() : 0;
                    linearLayout2.setPadding(this.b.m * 2, this.b.m * 2, this.b.m * 2, this.b.m * 2);
                    linearLayout = linearLayout2;
                    linearLayout = linearLayout2;
                    if (a2 != 0 && h != 0) {
                        if (viewGroup != null && viewGroup.getChildAt(0) != null) {
                            viewGroup.getChildAt(0).setLayoutParams(new AbsListView.LayoutParams(a2, h));
                        }
                        linearLayout2.setLayoutParams(new AbsListView.LayoutParams(a2, h));
                        linearLayout = linearLayout2;
                    }
                } else {
                    linearLayout = view2;
                }
                LinearLayout linearLayout3 = (LinearLayout) linearLayout;
                a46 a46Var = this.a;
                if (a46Var == null) {
                    return linearLayout3;
                }
                int i3 = a46Var.i() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(R.id.obfuscated_res_0x7f0908b7);
                tbImageView.setAutoChangeStyle(false);
                SkinManager.setBackgroundResource(tbImageView, R.drawable.btn_choose_face_selector, this.b.z);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String b = this.a.j().b(i3);
                tbImageView.setTag(b);
                if (TextUtils.isEmpty(b)) {
                    i2 = 3;
                } else {
                    i2 = 3;
                    Object k = ig.h().k(b, 20, new a(this), 0, 0, null, null, b, Boolean.FALSE, null);
                    fo foVar = (k == null || !(k instanceof fo)) ? null : (fo) k;
                    if (foVar != null) {
                        foVar.h(tbImageView);
                        tbImageView.setTag(null);
                    }
                }
                TextView textView = (TextView) linearLayout3.findViewById(R.id.obfuscated_res_0x7f0908b8);
                if (this.a.c() == EmotionGroupType.BIG_EMOTION) {
                    String b2 = this.a.j().b(i3);
                    if (!TextUtils.isEmpty(b2) && !b2.startsWith(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX)) {
                        if (this.b.z == 0) {
                            color = this.b.getContext().getResources().getColor(R.color.CAM_X0108);
                        } else {
                            color = SkinManager.getColor(R.color.CAM_X0108);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(b2.substring(b2.lastIndexOf("_") + 1, b2.length() - 1));
                    } else {
                        textView.setVisibility(8);
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (b != null && b.length() > i2) {
                    linearLayout3.setContentDescription(b.substring(2, b.length() - 1));
                }
                return linearLayout3;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void c(int i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.i = new Rect();
        this.o = -1;
        this.s = 0;
        this.t = -1;
        this.u = -1;
        this.x = new Point();
        this.C = new b(this, 2921028);
        u(context);
    }

    public void A(int i, GridView gridView) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048576, this, i, gridView) == null) || this.o == i || gridView == null || (cVar = (c) gridView.getAdapter()) == null || cVar.a() == null) {
            return;
        }
        a46 a2 = cVar.a();
        String b2 = a2.j().b(cVar.b() + i);
        if (a2.c() == EmotionGroupType.USER_COLLECT && i35.d.equals(b2)) {
            return;
        }
        this.h.setTag(b2);
        GifInfo gifInfo = new GifInfo();
        gifInfo.mSharpText = b2;
        if (b2.startsWith(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX)) {
            this.h.setShowStaticDrawable(false);
        } else {
            this.h.setShowStaticDrawable(true);
        }
        this.h.g0(gifInfo);
        LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
        linearLayout.getDrawingRect(this.i);
        this.j.offsetDescendantRectToMyCoords(linearLayout, this.i);
        WindowManager.LayoutParams layoutParams = this.g;
        layoutParams.x = this.i.left - ((layoutParams.width - linearLayout.getWidth()) / 2);
        WindowManager.LayoutParams layoutParams2 = this.g;
        layoutParams2.y = (this.i.top - layoutParams2.height) + this.m;
        this.h.setVisibility(0);
        if (!this.n) {
            this.f.addView(this.h, this.g);
            this.n = true;
        } else {
            this.f.updateViewLayout(this.h, this.g);
        }
        gridView.setSelection(i);
        int i2 = this.o;
        if (i2 != -1) {
            ((LinearLayout) gridView.getChildAt(i2 - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
        }
        linearLayout.getChildAt(0).setSelected(true);
        this.o = i;
        this.c = gridView;
    }

    public void B(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || this.a == null) {
            return;
        }
        int size = this.r.size();
        if (i < 0 || i >= size) {
            return;
        }
        int i3 = 0;
        while (true) {
            if (i3 < size) {
                a46 a46Var = this.r.get(i3);
                if (a46Var != null && a46Var.g() == i) {
                    i2 = a46Var.d();
                    break;
                }
                i3++;
            } else {
                i2 = 0;
                break;
            }
        }
        this.a.setCurrentItem(i2, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.C);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDetachedFromWindow();
            if (this.n) {
                this.f.removeView(this.h);
                this.n = false;
            }
            MessageManager.getInstance().unRegisterListener(this.C);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:
        if (r0 != 3) goto L11;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
            int action = motionEvent.getAction() & 255;
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        this.x.set(x, y);
                        if (this.n && this.h.getVisibility() != 8 && this.c != null) {
                            return true;
                        }
                    }
                }
                x();
            } else {
                this.x.set(x, y);
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        List<a46> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) || (list = this.r) == null) {
            return;
        }
        int size = list.size();
        if (i < 0 || i >= size) {
            return;
        }
        a46 a46Var = this.r.get(i);
        this.p = a46Var;
        IndicatorView indicatorView = this.d;
        if (indicatorView == null || a46Var == null) {
            return;
        }
        if (this.u != i) {
            this.u = i;
            indicatorView.setVisibility(a46Var.f() > 1 ? 0 : 4);
            this.d.setCount(this.p.f());
            a46 a46Var2 = this.p;
            if (a46Var2 != null && a46Var2.g() != this.t) {
                this.t = this.p.g();
                d dVar = this.v;
                if (dVar != null) {
                    dVar.c(this.p.g());
                }
            }
        }
        float e = this.p.e() + f;
        this.d.setPosition(e);
        StringBuilder sb = new StringBuilder();
        int i3 = ((int) e) + 1;
        sb.append(String.format(getResources().getString(R.string.obfuscated_res_0x7f0f0553), Integer.valueOf(i3)));
        sb.append(String.format(getResources().getString(R.string.obfuscated_res_0x7f0f0552), Integer.valueOf(this.p.f())));
        this.e.setContentDescription(sb.toString());
        bx4 bx4Var = new bx4();
        bx4Var.a = this.y.getFid();
        bx4Var.b = this.y.getTid();
        bx4Var.d = this.p.g() + 1;
        bx4Var.f = this.p.b();
        bx4Var.h = i3;
        bx4Var.e = 0;
        if (this.y.a.getBarLauncherType() == 3) {
            bx4Var.e = 1;
        } else if (this.y.a.getBarLauncherType() == 2) {
            bx4Var.e = 2;
        }
        bx4Var.c = TbadkCoreApplication.getCurrentAccount();
        s(bx4Var, "c14124");
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0020, code lost:
        if (r0 != 4) goto L12;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, motionEvent)) == null) {
            int action = motionEvent.getAction() & 255;
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        getFocusedRect(this.i);
                        if (!this.i.contains(x, y)) {
                            x();
                            return true;
                        }
                        this.i.set(x, y, x + 1, y + 1);
                        GridView gridView = this.c;
                        if (gridView != null) {
                            offsetRectIntoDescendantCoords(gridView, this.i);
                            GridView gridView2 = this.c;
                            Rect rect = this.i;
                            int pointToPosition = gridView2.pointToPosition(rect.left, rect.top);
                            if (pointToPosition != -1) {
                                A(pointToPosition, this.c);
                            }
                        }
                    } else if (action != 3) {
                    }
                }
                x();
            } else {
                this.x.set(x, y);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void s(bx4 bx4Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, bx4Var, str) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("fid", bx4Var.a).param("tid", bx4Var.b).param("uid", bx4Var.c).param("obj_type", bx4Var.d).param("obj_source", bx4Var.e).param("obj_locate", bx4Var.f).param("obj_param1", bx4Var.g).param(TiebaStatic.Params.OBJ_PARAM2, bx4Var.h);
            TiebaStatic.log(statisticItem);
        }
    }

    public void setOnDataSelected(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, editorTools) == null) {
            this.y = editorTools;
        }
    }

    public void setOnEmotionSwitchedListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, dVar) == null) {
            this.v = dVar;
        }
    }

    public final void t(List<a15> list) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, list) == null) {
            this.q.clear();
            this.r.clear();
            if (list == null || list.isEmpty()) {
                return;
            }
            this.q.addAll(list);
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                a15 a15Var = list.get(i2);
                if (a15Var != null) {
                    int c2 = a15Var.c();
                    int a2 = a15Var.a();
                    int k = a15Var.k();
                    int i3 = a2 * k;
                    int i4 = c2 / i3;
                    if (c2 % i3 != 0) {
                        i4++;
                    }
                    int i5 = 0;
                    while (i5 < i4) {
                        a46 a46Var = new a46();
                        int i6 = i4 - 1;
                        int i7 = i5 < i6 ? i3 : c2 - (i6 * i3);
                        a46Var.u(a15Var);
                        a46Var.r(i2);
                        a46Var.m(a15Var.h());
                        a46Var.s(k);
                        a46Var.k(a2);
                        a46Var.q(i4);
                        a46Var.p(i5);
                        a46Var.l(i7);
                        a46Var.t(i5 * a2 * k);
                        a46Var.n((i + i7) - 1);
                        this.r.add(a46Var);
                        i5++;
                    }
                }
            }
            this.s = this.r.size();
            for (int i8 = 0; i8 < this.s; i8++) {
                List<a46> list2 = this.r;
                if (list2 != null && list2.get(i8) != null) {
                    this.r.get(i8).o(i8);
                }
            }
        }
    }

    public final void u(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, context) == null) {
            this.A = context;
            this.q = new ArrayList();
            this.r = new ArrayList();
            this.B = new dg<>(new a(this), 3, 0);
            setOrientation(1);
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d026f, (ViewGroup) this, true);
            ViewPager viewPager = (ViewPager) findViewById(R.id.obfuscated_res_0x7f090966);
            this.a = viewPager;
            viewPager.setFadingEdgeLength(0);
            this.a.setOnPageChangeListener(this);
            GifView gifView = new GifView(context);
            this.h = gifView;
            SkinManager.setBackgroundResource(gifView, R.drawable.bg_expression_bubble, this.z);
            this.h.setVisibility(8);
            this.f = (WindowManager) context.getSystemService("window");
            this.g = new WindowManager.LayoutParams();
            this.k = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070286);
            this.l = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07028c);
            this.m = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070234);
            WindowManager.LayoutParams layoutParams = this.g;
            layoutParams.width = this.k;
            layoutParams.height = this.l;
            layoutParams.gravity = 51;
            layoutParams.format = -3;
            layoutParams.type = 1000;
            layoutParams.flags |= 56;
            this.j = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
            this.d = (IndicatorView) findViewById(R.id.obfuscated_res_0x7f090888);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090963);
            this.e = linearLayout;
            linearLayout.setClickable(true);
            if (MenuKeyUtils.hasSmartBar()) {
                WindowManager.LayoutParams layoutParams2 = this.g;
                layoutParams2.type = 1000;
                layoutParams2.flags = 25165832;
            }
        }
    }

    public final void v(int i) {
        List<a46> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i) == null) || (list = this.r) == null) {
            return;
        }
        int size = list.size();
        if (i < 0 || i >= size) {
            return;
        }
        for (int i2 = 0; i2 < size; i2++) {
            a46 a46Var = this.r.get(i2);
            if (a46Var != null && a46Var.g() == i) {
                this.w = a46Var.d();
                return;
            }
        }
    }

    public void w(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.z = i;
            SkinManager.setBackgroundResource(this.h, R.drawable.bg_expression_bubble, i);
            SkinManager.setBackgroundColor(this, R.color.CAM_X0206, i);
            this.d.setSelector(SkinManager.getDrawable(i, (int) R.drawable.dot_pb_expression_s));
            this.d.setDrawable(SkinManager.getDrawable(i, (int) R.drawable.dot_pb_expression_n));
            if (this.a != null) {
                for (int i2 = 0; i2 < this.a.getChildCount(); i2++) {
                    View childAt = this.a.getChildAt(i2);
                    if (childAt != null && (childAt instanceof GridView)) {
                        GridView gridView = (GridView) childAt;
                        if (gridView.getAdapter() != null && (gridView.getAdapter() instanceof c)) {
                            ((c) gridView.getAdapter()).notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    }

    public final void x() {
        GridView gridView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || !this.n || this.h.getVisibility() == 8 || (gridView = this.c) == null) {
            return;
        }
        gridView.setSelection(-1);
        this.h.setVisibility(8);
        this.f.removeView(this.h);
        this.n = false;
        int i = this.o;
        if (i != -1) {
            GridView gridView2 = this.c;
            ((LinearLayout) gridView2.getChildAt(i - gridView2.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
        }
        this.o = -1;
        this.c = null;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            x();
        }
    }

    public void z(List<a15> list, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048594, this, list, i) == null) || list == null) {
            return;
        }
        int size = list.size();
        if (i < 0 || i >= size) {
            return;
        }
        t(list);
        v(i);
        EmotionViewPagerAdapter emotionViewPagerAdapter = new EmotionViewPagerAdapter(this);
        this.b = emotionViewPagerAdapter;
        this.a.setAdapter(emotionViewPagerAdapter);
        this.a.setCurrentItem(this.w, true);
        d dVar = this.v;
        if (dVar != null) {
            dVar.c(i);
            this.t = i;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmotionTabContentView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = new Rect();
        this.o = -1;
        this.s = 0;
        this.t = -1;
        this.u = -1;
        this.x = new Point();
        this.C = new b(this, 2921028);
        u(context);
    }
}

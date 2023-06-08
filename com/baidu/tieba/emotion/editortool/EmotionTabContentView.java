package com.baidu.tieba.emotion.editortool;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
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
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.log.DefaultLog;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.UserCollectManageActivityConfig;
import com.baidu.tbadk.core.util.EmotionUtil;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.gif.GifInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.cd5;
import com.baidu.tieba.dd5;
import com.baidu.tieba.eo5;
import com.baidu.tieba.gn;
import com.baidu.tieba.kg;
import com.baidu.tieba.lg;
import com.baidu.tieba.ni5;
import com.baidu.tieba.nx6;
import com.baidu.tieba.og;
import com.baidu.tieba.pg;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.tieba.uh5;
import com.baidu.tieba.wg;
import com.baidu.tieba.yl5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class EmotionTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EditorTools A;
    public int B;
    public Context C;
    public int D;
    public Map<String, String> E;
    public kg<GridView> F;
    public boolean G;
    public boolean H;
    public List<String> I;
    public og J;
    @Nullable
    public ni5 K;
    public boolean L;
    public CustomMessageListener M;
    public final CustomMessageListener N;
    public final CustomMessageListener O;
    public ViewPager a;
    public EmotionViewPagerAdapter b;
    public GridView c;
    public IndicatorView d;
    public LinearLayout e;
    public PopupWindow f;
    public WindowManager.LayoutParams g;
    public EmotionFloatView h;
    public final Rect i;
    public ViewGroup j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public boolean p;
    public int q;
    public nx6 r;
    public List<ni5> s;
    public List<nx6> t;
    public int u;
    public int v;
    public int w;
    public j x;
    public int y;
    public final Point z;

    /* loaded from: classes5.dex */
    public interface j {
        void b(int i);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class EmotionViewPagerAdapter extends PagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionTabContentView a;

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view2, Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view2, obj)) == null) ? view2 == obj : invokeLL.booleanValue;
        }

        /* loaded from: classes5.dex */
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
                    i iVar = (i) adapterView.getAdapter();
                    if (iVar == null || iVar.a() == null) {
                        return false;
                    }
                    nx6 a = iVar.a();
                    if (a.c() != EmotionGroupType.BIG_EMOTION && a.c() != EmotionGroupType.USER_COLLECT && a.c() != EmotionGroupType.LOCAL && a.c() != EmotionGroupType.USER_DIY) {
                        return false;
                    }
                    this.a.a.P(i, (GridView) adapterView);
                    return true;
                }
                return invokeCommon.booleanValue;
            }
        }

        /* loaded from: classes5.dex */
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
                String str;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                    adapterView.setSelection(-1);
                    if (this.a.a.A != null) {
                        cd5 cd5Var = new cd5();
                        i iVar = (i) adapterView.getAdapter();
                        if (iVar != null && iVar.a() != null) {
                            nx6 a = iVar.a();
                            int b = iVar.b();
                            ni5 j2 = a.j();
                            String b2 = a.j().b(b + i);
                            gn o = a.j().o(b2);
                            if (j2.h() == EmotionGroupType.USER_COLLECT && yl5.f.equals(b2)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UserCollectManageActivityConfig(this.a.a.C)));
                            } else if (j2.h() != EmotionGroupType.USER_DIY || !"#(meme,diysetting)".equals(b2)) {
                                cd5Var.n(b2);
                                cd5Var.q(j2.h());
                                cd5Var.p(j2.g());
                                cd5Var.o(j2.f());
                                cd5Var.s(j2.l());
                                cd5Var.l(j2.i());
                                cd5Var.m(o);
                                dd5 dd5Var = new dd5();
                                dd5Var.a = this.a.a.A.getFid();
                                dd5Var.b = this.a.a.A.getTid();
                                dd5Var.d = a.g() + 1;
                                dd5Var.h = a.e() + 1;
                                dd5Var.f = (a.e() * 21) + i + 1;
                                dd5Var.g = 0;
                                dd5Var.e = 0;
                                if (this.a.a.A.a.getBarLauncherType() == 3) {
                                    dd5Var.e = 1;
                                } else if (this.a.a.A.a.getBarLauncherType() == 2) {
                                    dd5Var.e = 2;
                                } else if (this.a.a.A.a.getBarLauncherType() == 7) {
                                    dd5Var.e = 3;
                                }
                                dd5Var.c = TbadkCoreApplication.getCurrentAccount();
                                cd5Var.k(dd5Var);
                                this.a.a.A.C(new uh5(24, -1, cd5Var));
                                dd5Var.c(j2, b2);
                                this.a.a.F(dd5Var, "c14122");
                            } else {
                                this.a.a.K = j2;
                                TiebaStatic.log(new StatisticItem("c14689").param("uid", TbadkCoreApplication.getCurrentAccount()));
                                HashMap hashMap = new HashMap();
                                hashMap.put("itemID", "");
                                if (this.a.a.L) {
                                    str = "1";
                                } else {
                                    str = "0";
                                }
                                hashMap.put("canSend", str);
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this.a.a.getContext(), "EmoticonDiyPage", hashMap)));
                            }
                        }
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
                this.a.F.e(gridView);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.a.t == null) {
                    return 0;
                }
                return this.a.t.size();
            }
            return invokeV.intValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i)) == null) {
                GridView gridView = (GridView) this.a.F.b();
                if (gridView == null) {
                    gridView = new GridView(this.a.C);
                }
                gridView.setScrollbarFadingEnabled(false);
                if (this.a.t != null && i < this.a.t.size()) {
                    nx6 nx6Var = (nx6) this.a.t.get(i);
                    gridView.setNumColumns(nx6Var.a());
                    gridView.setVerticalSpacing(0);
                    gridView.setHorizontalSpacing(0);
                    gridView.setSelector(R.color.common_color_10022);
                    gridView.setPadding(this.a.C.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701f9), 0, this.a.C.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701f9), 0);
                    gridView.setOnItemLongClickListener(new a(this));
                    gridView.setOnItemClickListener(new b(this));
                    gridView.setAdapter((ListAdapter) new i(this.a, nx6Var));
                }
                viewGroup.addView(gridView);
                return gridView;
            }
            return invokeLI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048580, this, viewGroup, i, obj) == null) {
                if (this.a.t != null) {
                    int size = this.a.t.size();
                    if (i == 0 && i < size && i != this.a.w) {
                        nx6 nx6Var = (nx6) this.a.t.get(i);
                        if (nx6Var != null) {
                            this.a.w = i;
                            IndicatorView indicatorView = this.a.d;
                            if (nx6Var.f() > 1) {
                                i2 = 0;
                            } else {
                                i2 = 4;
                            }
                            indicatorView.setVisibility(i2);
                            this.a.d.setCount(nx6Var.f());
                            this.a.d.setPosition(nx6Var.e());
                            this.a.d.setContentDescription(String.format(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0645), Integer.valueOf(nx6Var.e() + 1)) + String.format(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0644), Integer.valueOf(nx6Var.f())));
                        }
                        if (nx6Var != null && nx6Var.g() != this.a.v) {
                            this.a.v = nx6Var.g();
                            if (this.a.x != null) {
                                this.a.x.b(nx6Var.g());
                            }
                        }
                    }
                }
                super.setPrimaryItem(viewGroup, i, obj);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a extends og<gn> {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.og
        public void onLoaded(gn gnVar, String str, int i) {
            View findViewWithTag;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, gnVar, str, i) == null) {
                this.a.I.remove(str);
                if (gnVar != null && (findViewWithTag = this.a.findViewWithTag(str)) != null && (findViewWithTag instanceof TbImageView) && str != null) {
                    TbImageView tbImageView = (TbImageView) findViewWithTag;
                    gnVar.h(tbImageView);
                    tbImageView.setTag(null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements lg<GridView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionTabContentView a;

        public GridView e(GridView gridView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, gridView)) == null) ? gridView : (GridView) invokeL.objValue;
        }

        public b(EmotionTabContentView emotionTabContentView) {
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
        @Override // com.baidu.tieba.lg
        public /* bridge */ /* synthetic */ GridView a(GridView gridView) {
            GridView gridView2 = gridView;
            e(gridView2);
            return gridView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.lg
        public /* bridge */ /* synthetic */ GridView c(GridView gridView) {
            GridView gridView2 = gridView;
            h(gridView2);
            return gridView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lg
        /* renamed from: f */
        public void b(GridView gridView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, gridView) == null) {
                gridView.setAdapter((ListAdapter) null);
            }
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lg
        /* renamed from: g */
        public GridView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return new GridView(this.a.getContext());
            }
            return (GridView) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionTabContentView a;

        public c(EmotionTabContentView emotionTabContentView) {
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

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.L();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionTabContentView a;

        public d(EmotionTabContentView emotionTabContentView) {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921704, this.a.E));
                this.a.f.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionTabContentView a;

        public e(EmotionTabContentView emotionTabContentView) {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.H = !TbadkCoreApplication.getInst().isKeyboardHeightCanUsed();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionTabContentView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(EmotionTabContentView emotionTabContentView, int i) {
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
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage.getCmd() != 2921028) {
                return;
            }
            this.a.J(new ArrayList(this.a.s));
            if (this.a.b != null) {
                this.a.b.notifyDataSetChanged();
                if (this.a.v >= 0 && this.a.v < this.a.s.size()) {
                    ni5 ni5Var = (ni5) this.a.s.get(this.a.v);
                    if (ni5Var.h() != EmotionGroupType.USER_COLLECT && ni5Var.h() != EmotionGroupType.USER_DIY) {
                        return;
                    }
                }
                if (this.a.b != null) {
                    if (this.a.w >= 0 && this.a.w < this.a.t.size()) {
                        EmotionTabContentView emotionTabContentView = this.a;
                        emotionTabContentView.r = (nx6) emotionTabContentView.t.get(this.a.w);
                        int f = this.a.r.f();
                        this.a.d.setCount(f);
                        IndicatorView indicatorView = this.a.d;
                        if (f > 1) {
                            i = 0;
                        } else {
                            i = 4;
                        }
                        indicatorView.setVisibility(i);
                    }
                    if (this.a.a != null) {
                        for (int i2 = 0; i2 < this.a.a.getChildCount(); i2++) {
                            try {
                                View childAt = this.a.a.getChildAt(i2);
                                if (childAt instanceof GridView) {
                                    GridView gridView = (GridView) childAt;
                                    if (gridView.getAdapter() != null && (gridView.getAdapter() instanceof i)) {
                                        i iVar = (i) gridView.getAdapter();
                                        int d = iVar.a().d();
                                        if (d >= 0 && d < this.a.t.size()) {
                                            iVar.c((nx6) this.a.t.get(d));
                                            iVar.notifyDataSetChanged();
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

    /* loaded from: classes5.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionTabContentView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(EmotionTabContentView emotionTabContentView, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && this.a.A != null && this.a.K != null) {
                    String str = (String) data;
                    ni5 ni5Var = this.a.K;
                    gn o = ni5Var.o(str);
                    cd5 cd5Var = new cd5();
                    cd5Var.n(str);
                    cd5Var.q(ni5Var.h());
                    cd5Var.p(ni5Var.g());
                    cd5Var.o(ni5Var.f());
                    cd5Var.s(ni5Var.l());
                    cd5Var.l(ni5Var.i());
                    cd5Var.m(o);
                    cd5Var.j(true);
                    dd5 dd5Var = new dd5();
                    dd5Var.a = this.a.A.getFid();
                    dd5Var.b = this.a.A.getTid();
                    dd5Var.d = -1;
                    dd5Var.h = -1;
                    dd5Var.f = -1;
                    dd5Var.g = 0;
                    dd5Var.e = 0;
                    if (this.a.A.a.getBarLauncherType() == 3) {
                        dd5Var.e = 1;
                    } else if (this.a.A.a.getBarLauncherType() == 2) {
                        dd5Var.e = 2;
                    } else if (this.a.A.a.getBarLauncherType() == 7) {
                        dd5Var.e = 3;
                    }
                    dd5Var.c = TbadkCoreApplication.getCurrentAccount();
                    cd5Var.k(dd5Var);
                    this.a.A.C(new uh5(24, -1, cd5Var));
                    dd5Var.c(ni5Var, str);
                    this.a.F(dd5Var, "c14122");
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionTabContentView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(EmotionTabContentView emotionTabContentView, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    this.a.L = ((Boolean) data).booleanValue();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public nx6 a;
        public final /* synthetic */ EmotionTabContentView b;

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) ? i : invokeI.longValue;
        }

        public i(EmotionTabContentView emotionTabContentView, nx6 nx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionTabContentView, nx6Var};
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
            this.a = nx6Var;
        }

        public nx6 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a;
            }
            return (nx6) invokeV.objValue;
        }

        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                nx6 nx6Var = this.a;
                if (nx6Var == null) {
                    return 0;
                }
                return nx6Var.i();
            }
            return invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                nx6 nx6Var = this.a;
                if (nx6Var == null) {
                    return 0;
                }
                return nx6Var.b();
            }
            return invokeV.intValue;
        }

        public void c(nx6 nx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nx6Var) == null) {
                this.a = nx6Var;
            }
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
                return Integer.valueOf(i);
            }
            return invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view2, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            int i2;
            int i3;
            LinearLayout linearLayout;
            int i4;
            int color;
            gn gnVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i, view2, viewGroup)) == null) {
                if (view2 != null && !this.b.G && !this.b.H) {
                    linearLayout = view2;
                } else {
                    LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.obfuscated_res_0x7f0d02a2, (ViewGroup) null);
                    int measuredWidth = viewGroup.getMeasuredWidth();
                    int measuredHeight = viewGroup.getMeasuredHeight();
                    if (!this.b.H && !TbadkCoreApplication.getInst().isKeyboardHeightCanUsed()) {
                        this.b.H = true;
                    }
                    if (this.a.a() != 0) {
                        i2 = measuredWidth / this.a.a();
                    } else {
                        i2 = 0;
                    }
                    if (this.a.h() != 0) {
                        i3 = measuredHeight / this.a.h();
                    } else {
                        i3 = 0;
                    }
                    linearLayout2.setPadding(this.b.o * 2, this.b.o * 2, this.b.o * 2, this.b.o * 2);
                    linearLayout = linearLayout2;
                    linearLayout = linearLayout2;
                    if (i2 != 0 && i3 != 0) {
                        if (viewGroup != null && viewGroup.getChildAt(0) != null) {
                            viewGroup.getChildAt(0).setLayoutParams(new AbsListView.LayoutParams(i2, i3));
                        }
                        linearLayout2.setLayoutParams(new AbsListView.LayoutParams(i2, i3));
                        linearLayout = linearLayout2;
                    }
                }
                LinearLayout linearLayout3 = linearLayout;
                nx6 nx6Var = this.a;
                if (nx6Var == null) {
                    return linearLayout3;
                }
                int i5 = nx6Var.i() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(R.id.obfuscated_res_0x7f0909c8);
                tbImageView.setAutoChangeStyle(false);
                SkinManager.setBackgroundResource(tbImageView, R.drawable.btn_choose_face_selector, this.b.B);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String b = this.a.j().b(i5);
                tbImageView.setTag(b);
                if (!TextUtils.isEmpty(b)) {
                    this.b.I.add(b);
                    i4 = 3;
                    Object k = pg.h().k(b, 20, this.b.J, 0, 0, null, null, b, Boolean.FALSE, null);
                    if (k != null && (k instanceof gn)) {
                        gnVar = (gn) k;
                    } else {
                        gnVar = null;
                    }
                    if (gnVar != null) {
                        gnVar.h(tbImageView);
                        tbImageView.setTag(null);
                    }
                } else {
                    i4 = 3;
                }
                TextView textView = (TextView) linearLayout3.findViewById(R.id.obfuscated_res_0x7f0909c9);
                if (this.a.c() == EmotionGroupType.BIG_EMOTION) {
                    String b2 = this.a.j().b(i5);
                    if (!TextUtils.isEmpty(b2) && !b2.startsWith(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX)) {
                        if (this.b.B == 0) {
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
                if (b != null && b.length() > i4) {
                    linearLayout3.setContentDescription(b.substring(2, b.length() - 1));
                }
                return linearLayout3;
            }
            return (View) invokeILL.objValue;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = new Rect();
        this.q = -1;
        this.u = 0;
        this.v = -1;
        this.w = -1;
        this.z = new Point();
        this.G = false;
        this.H = false;
        this.I = new ArrayList();
        this.J = new a(this);
        this.K = null;
        this.L = false;
        this.M = new f(this, 2921028);
        this.N = new g(this, 2921705);
        this.O = new h(this, 2921706);
        G(context);
    }

    public void K(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.B = i2;
            EmotionFloatView emotionFloatView = this.h;
            if (emotionFloatView != null && emotionFloatView.getVisibility() == 0) {
                this.h.setBackGroundFloat(getFloatViewBackGround());
            }
            SkinManager.setBackgroundColor(this, R.color.CAM_X0206, i2);
            this.d.setSelector(SkinManager.getDrawable(i2, (int) R.drawable.dot_pb_expression_s));
            this.d.setDrawable(SkinManager.getDrawable(i2, (int) R.drawable.dot_pb_expression_n));
            if (this.a != null) {
                for (int i3 = 0; i3 < this.a.getChildCount(); i3++) {
                    View childAt = this.a.getChildAt(i3);
                    if (childAt instanceof GridView) {
                        GridView gridView = (GridView) childAt;
                        if (gridView.getAdapter() != null && (gridView.getAdapter() instanceof i)) {
                            ((i) gridView.getAdapter()).notifyDataSetChanged();
                        }
                    }
                }
            }
        }
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.i = new Rect();
        this.q = -1;
        this.u = 0;
        this.v = -1;
        this.w = -1;
        this.z = new Point();
        this.G = false;
        this.H = false;
        this.I = new ArrayList();
        this.J = new a(this);
        this.K = null;
        this.L = false;
        this.M = new f(this, 2921028);
        this.N = new g(this, 2921705);
        this.O = new h(this, 2921706);
        G(context);
    }

    public final void F(dd5 dd5Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, dd5Var, str) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("fid", dd5Var.a).param("tid", dd5Var.b).param("uid", dd5Var.c).param("obj_type", dd5Var.d).param("obj_source", dd5Var.e).param("obj_locate", dd5Var.f).param("obj_param1", dd5Var.g).param(TiebaStatic.Params.OBJ_PARAM2, dd5Var.h).param("nid", dd5Var.a());
            if (!TextUtils.isEmpty(dd5Var.b())) {
                statisticItem.param("obj_id", dd5Var.b());
            }
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, configuration) == null) {
            this.G = true;
        }
    }

    public void setOnDataSelected(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, editorTools) == null) {
            this.A = editorTools;
        }
    }

    public void setOnEmotionSwitchedListener(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, jVar) == null) {
            this.x = jVar;
        }
    }

    private int getFloatViewBackGround() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            int i2 = this.D;
            if (i2 != 0 && this.h != null) {
                if (i2 >= 3) {
                    if (i2 == 3) {
                        return 2;
                    }
                    if (i2 % 4 == 0) {
                        return 3;
                    }
                    if (i2 % 4 == 3) {
                        return 2;
                    }
                }
                return 1;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            L();
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            for (int i2 = 0; i2 < this.I.size(); i2++) {
                pg.h().d(this.I.get(i2), 20, this.J);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.M);
            MessageManager.getInstance().registerListener(this.N);
            MessageManager.getInstance().registerListener(this.O);
        }
    }

    public final void G(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.C = context;
            this.s = new ArrayList();
            this.t = new ArrayList();
            this.F = new kg<>(new b(this), 3, 0);
            setOrientation(1);
            LayoutInflater.from(context).inflate(R.layout.emotion_tab_content, (ViewGroup) this, true);
            ViewPager viewPager = (ViewPager) findViewById(R.id.face_tab_viewpager);
            this.a = viewPager;
            viewPager.setFadingEdgeLength(0);
            this.a.setOnPageChangeListener(this);
            EmotionFloatView emotionFloatView = new EmotionFloatView(context);
            this.h = emotionFloatView;
            emotionFloatView.setBackGroundFloat(1);
            this.k = context.getResources().getDimensionPixelSize(R.dimen.tbds348);
            this.l = context.getResources().getDimensionPixelSize(R.dimen.tbds444);
            this.m = context.getResources().getDimensionPixelSize(R.dimen.tbds96);
            PopupWindow popupWindow = new PopupWindow((View) this.h, this.k, this.l, true);
            this.f = popupWindow;
            GreyUtil.grey(popupWindow);
            this.g = new WindowManager.LayoutParams();
            this.n = context.getResources().getDimensionPixelSize(R.dimen.tbds100);
            this.o = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070353);
            WindowManager.LayoutParams layoutParams = this.g;
            layoutParams.width = this.k;
            layoutParams.height = this.l + this.n;
            layoutParams.gravity = 51;
            layoutParams.format = -3;
            layoutParams.type = 1000;
            layoutParams.flags |= 56;
            this.j = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
            this.d = (IndicatorView) findViewById(R.id.emotion_face_tab_indicator);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.face_tab_indicator_layout);
            this.e = linearLayout;
            linearLayout.setClickable(true);
            if (MenuKeyUtils.hasSmartBar()) {
                WindowManager.LayoutParams layoutParams2 = this.g;
                layoutParams2.type = 1000;
                layoutParams2.flags = 25165832;
            }
        }
    }

    public final void H(int i2, int i3) {
        PopupWindow popupWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) && (popupWindow = this.f) != null) {
            popupWindow.setBackgroundDrawable(new ColorDrawable(0));
            this.f.showAtLocation(this.j, 0, i2, i3);
            this.f.setTouchable(true);
            this.f.setOnDismissListener(new c(this));
            this.h.setDeleteBottomListener(new d(this));
        }
    }

    public void O(List<ni5> list, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048585, this, list, i2) != null) || list == null) {
            return;
        }
        int size = list.size();
        if (i2 >= 0 && i2 < size) {
            J(list);
            I(i2);
            EmotionViewPagerAdapter emotionViewPagerAdapter = new EmotionViewPagerAdapter(this);
            this.b = emotionViewPagerAdapter;
            this.a.setAdapter(emotionViewPagerAdapter);
            this.a.setCurrentItem(this.y, true);
            j jVar = this.x;
            if (jVar != null) {
                jVar.b(i2);
                this.v = i2;
            }
            this.G = false;
        }
    }

    public final void I(int i2) {
        List<nx6> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048579, this, i2) != null) || (list = this.t) == null) {
            return;
        }
        int size = list.size();
        if (i2 >= 0 && i2 < size) {
            for (int i3 = 0; i3 < size; i3++) {
                nx6 nx6Var = this.t.get(i3);
                if (nx6Var != null && nx6Var.g() == i2) {
                    this.y = nx6Var.d();
                    return;
                }
            }
        }
    }

    public void R(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048588, this, i2) == null) && this.a != null) {
            int size = this.t.size();
            if (i2 >= 0 && i2 < size) {
                int i4 = 0;
                while (true) {
                    if (i4 < size) {
                        nx6 nx6Var = this.t.get(i4);
                        if (nx6Var != null && nx6Var.g() == i2) {
                            i3 = nx6Var.d();
                            break;
                        }
                        i4++;
                    } else {
                        i3 = 0;
                        break;
                    }
                }
                this.a.setCurrentItem(i3, false);
            }
        }
    }

    public final void J(List<ni5> list) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.s.clear();
            this.t.clear();
            if (list != null && !list.isEmpty()) {
                this.s.addAll(list);
                int size = list.size();
                for (int i4 = 0; i4 < size; i4++) {
                    ni5 ni5Var = list.get(i4);
                    if (ni5Var != null) {
                        int c2 = ni5Var.c();
                        int a2 = ni5Var.a();
                        int k = ni5Var.k();
                        int i5 = a2 * k;
                        int i6 = c2 / i5;
                        if (c2 % i5 != 0) {
                            i6++;
                        }
                        for (int i7 = 0; i7 < i6; i7++) {
                            nx6 nx6Var = new nx6();
                            int i8 = i6 - 1;
                            if (i7 < i8) {
                                i2 = i5;
                            } else {
                                i2 = c2 - (i8 * i5);
                            }
                            nx6Var.u(ni5Var);
                            nx6Var.r(i4);
                            nx6Var.m(ni5Var.h());
                            nx6Var.s(k);
                            nx6Var.k(a2);
                            nx6Var.q(i6);
                            nx6Var.p(i7);
                            nx6Var.l(i2);
                            nx6Var.t(i7 * a2 * k);
                            nx6Var.n((i3 + i2) - 1);
                            this.t.add(nx6Var);
                        }
                    }
                }
                this.u = this.t.size();
                for (int i9 = 0; i9 < this.u; i9++) {
                    List<nx6> list2 = this.t;
                    if (list2 != null && list2.get(i9) != null) {
                        this.t.get(i9).o(i9);
                    }
                }
            }
        }
    }

    public final void L() {
        GridView gridView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.p && this.h.getVisibility() != 8 && (gridView = this.c) != null && this.f != null) {
            gridView.setSelection(-1);
            this.h.setVisibility(8);
            this.f.dismiss();
            this.p = false;
            int i2 = this.q;
            if (i2 != -1) {
                GridView gridView2 = this.c;
                ((LinearLayout) gridView2.getChildAt(i2 - gridView2.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.q = -1;
            this.c = null;
        }
    }

    public void M() {
        ViewPager viewPager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.H && (viewPager = this.a) != null) {
            int childCount = viewPager.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.a.getChildAt(i2);
                if (childAt instanceof GridView) {
                    GridView gridView = (GridView) childAt;
                    if (gridView.getAdapter() instanceof i) {
                        ((i) gridView.getAdapter()).notifyDataSetChanged();
                    }
                }
            }
            wg.a().postDelayed(new e(this), 300L);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        PopupWindow popupWindow;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onDetachedFromWindow();
            if (this.p && (popupWindow = this.f) != null) {
                popupWindow.dismiss();
                this.p = false;
            }
            MessageManager.getInstance().unRegisterListener(this.M);
            MessageManager.getInstance().unRegisterListener(this.N);
            MessageManager.getInstance().unRegisterListener(this.O);
            if (this.I.size() != 0) {
                Q();
            }
        }
    }

    public void P(int i2, GridView gridView) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048586, this, i2, gridView) == null) && this.q != i2 && gridView != null) {
            this.E = new HashMap();
            this.D = i2;
            i iVar = (i) gridView.getAdapter();
            if (iVar != null && iVar.a() != null) {
                nx6 a2 = iVar.a();
                String b2 = a2.j().b(iVar.b() + i2);
                if (b2 == null) {
                    DefaultLog.getInstance().b("EmotionTabContentView", "EmotionTabContentView showFloatView getEmotionSharpText key is null, pos=" + i2);
                } else if (a2.c() == EmotionGroupType.USER_COLLECT && yl5.f.equals(b2)) {
                } else {
                    if (a2.c() == EmotionGroupType.USER_DIY && "#(meme,diysetting)".equals(b2)) {
                        return;
                    }
                    this.h.setEmotionViewTag(b2);
                    GifInfo gifInfo = new GifInfo();
                    gifInfo.mSharpText = b2;
                    if (!b2.startsWith(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX) && a2.c() != EmotionGroupType.LOCAL) {
                        this.h.setShowStaticDrawable(true);
                    } else {
                        this.h.setShowStaticDrawable(false);
                    }
                    if (a2.c() == EmotionGroupType.USER_DIY) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.h.b(z);
                    this.h.c(gifInfo);
                    this.E.clear();
                    String b3 = eo5.b.b(b2);
                    this.E.put("pid", b3);
                    this.E.put("filePath", TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/.collect/" + yl5.c() + "/" + b3 + "_s.jpg");
                    this.E.put("sharpText", b2);
                    this.E.put("uid", TbadkCoreApplication.getCurrentAccount());
                    LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i2 - gridView.getFirstVisiblePosition());
                    linearLayout.getDrawingRect(this.i);
                    this.j.offsetDescendantRectToMyCoords(linearLayout, this.i);
                    if (a2.c() == EmotionGroupType.USER_DIY && getFloatViewBackGround() == 2) {
                        this.g.x = (this.i.left - (this.k - linearLayout.getWidth())) - this.o;
                    } else if (a2.c() == EmotionGroupType.USER_DIY && getFloatViewBackGround() == 3) {
                        this.g.x = this.i.left + this.o;
                    } else {
                        WindowManager.LayoutParams layoutParams = this.g;
                        layoutParams.x = this.i.left - ((layoutParams.width - linearLayout.getWidth()) / 2);
                    }
                    WindowManager.LayoutParams layoutParams2 = this.g;
                    int i3 = this.i.top;
                    int i4 = this.l;
                    int i5 = (i3 - i4) + this.o;
                    layoutParams2.y = i5;
                    int i6 = i5 + this.n;
                    if (z) {
                        this.f.setHeight(i4);
                        i6 -= this.n;
                    } else {
                        this.f.setHeight(i4 - this.m);
                    }
                    this.h.setVisibility(0);
                    if (a2.c() == EmotionGroupType.USER_DIY) {
                        this.h.setDeleteBottomVisible(0);
                        this.h.setBackGroundFloat(getFloatViewBackGround());
                    } else {
                        this.h.setDeleteBottomVisible(8);
                        this.h.setBackGroundFloat(1);
                    }
                    if (!this.p) {
                        H(this.g.x, i6);
                        this.p = true;
                    } else {
                        PopupWindow popupWindow = this.f;
                        if (popupWindow != null) {
                            ViewGroup viewGroup = this.j;
                            WindowManager.LayoutParams layoutParams3 = this.g;
                            popupWindow.update(viewGroup, layoutParams3.x, layoutParams3.y + this.l, -1, -1);
                        } else {
                            H(this.g.x, i6);
                        }
                    }
                    gridView.setSelection(i2);
                    int i7 = this.q;
                    if (i7 != -1) {
                        ((LinearLayout) gridView.getChildAt(i7 - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                    }
                    linearLayout.getChildAt(0).setSelected(true);
                    this.q = i2;
                    this.c = gridView;
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, motionEvent)) == null) {
            int action = motionEvent.getAction() & 255;
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action != 0) {
                if (action == 2) {
                    this.z.set(x, y);
                    if (this.p && this.h.getVisibility() != 8 && this.c != null) {
                        return true;
                    }
                }
            } else {
                this.z.set(x, y);
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, motionEvent)) == null) {
            int action = motionEvent.getAction() & 255;
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action != 0) {
                if (action == 2) {
                    getFocusedRect(this.i);
                    if (!this.i.contains(x, y)) {
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
                            P(pointToPosition, this.c);
                        }
                    }
                }
            } else {
                this.z.set(x, y);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
        int i4;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) && this.t != null) {
            int i5 = (f2 > 0.5f ? 1 : (f2 == 0.5f ? 0 : -1));
            if (i5 > 0) {
                i2++;
            }
            int size = this.t.size();
            if (i2 >= 0 && i2 < size) {
                nx6 nx6Var = this.t.get(i2);
                this.r = nx6Var;
                IndicatorView indicatorView = this.d;
                if (indicatorView != null && nx6Var != null) {
                    if (this.w != i2) {
                        this.w = i2;
                        if (nx6Var.f() > 1) {
                            i4 = 0;
                        } else {
                            i4 = 4;
                        }
                        indicatorView.setVisibility(i4);
                        this.d.setCount(this.r.f());
                        nx6 nx6Var2 = this.r;
                        if (nx6Var2 != null && nx6Var2.g() != this.v) {
                            this.v = this.r.g();
                            j jVar = this.x;
                            if (jVar != null) {
                                jVar.b(this.r.g());
                            }
                        }
                    }
                    float e2 = this.r.e() + f2;
                    if (i5 > 0) {
                        e2 -= 1.0f;
                    }
                    this.d.setPosition(e2);
                    StringBuilder sb = new StringBuilder();
                    int i6 = ((int) e2) + 1;
                    sb.append(String.format(getResources().getString(R.string.obfuscated_res_0x7f0f0645), Integer.valueOf(i6)));
                    sb.append(String.format(getResources().getString(R.string.obfuscated_res_0x7f0f0644), Integer.valueOf(this.r.f())));
                    this.e.setContentDescription(sb.toString());
                    dd5 dd5Var = new dd5();
                    dd5Var.a = this.A.getFid();
                    dd5Var.b = this.A.getTid();
                    dd5Var.d = this.r.g() + 1;
                    dd5Var.f = this.r.b();
                    dd5Var.h = i6;
                    dd5Var.e = 0;
                    if (this.A.a.getBarLauncherType() == 3) {
                        dd5Var.e = 1;
                    } else if (this.A.a.getBarLauncherType() == 2) {
                        dd5Var.e = 2;
                    } else if (this.A.a.getBarLauncherType() == 7) {
                        dd5Var.e = 3;
                    }
                    dd5Var.c = TbadkCoreApplication.getCurrentAccount();
                    dd5Var.c(this.r.j(), null);
                    F(dd5Var, "c14124");
                }
            }
        }
    }
}

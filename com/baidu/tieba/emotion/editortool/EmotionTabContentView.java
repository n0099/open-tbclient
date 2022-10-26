package com.baidu.tieba.emotion.editortool;

import android.app.Activity;
import android.content.Context;
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
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ah;
import com.baidu.tieba.d65;
import com.baidu.tieba.j15;
import com.baidu.tieba.k15;
import com.baidu.tieba.l55;
import com.baidu.tieba.m85;
import com.baidu.tieba.pn;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.tieba.v86;
import com.baidu.tieba.vg;
import com.baidu.tieba.wg;
import com.baidu.tieba.z95;
import com.baidu.tieba.zg;
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
/* loaded from: classes3.dex */
public class EmotionTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EditorTools A;
    public int B;
    public Context C;
    public int D;
    public Map E;
    public vg F;
    public d65 G;
    public boolean H;
    public CustomMessageListener I;
    public final CustomMessageListener J;
    public final CustomMessageListener K;
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
    public v86 r;
    public List s;
    public List t;
    public int u;
    public int v;
    public int w;
    public h x;
    public int y;
    public final Point z;

    /* loaded from: classes3.dex */
    public interface h {
        void b(int i);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
        }
    }

    /* loaded from: classes3.dex */
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
            public boolean onItemLongClick(AdapterView adapterView, View view2, int i, long j) {
                InterceptResult invokeCommon;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)})) == null) {
                    g gVar = (g) adapterView.getAdapter();
                    if (gVar == null || gVar.a() == null) {
                        return false;
                    }
                    v86 a = gVar.a();
                    if (a.c() != EmotionGroupType.BIG_EMOTION && a.c() != EmotionGroupType.USER_COLLECT && a.c() != EmotionGroupType.LOCAL && a.c() != EmotionGroupType.USER_DIY) {
                        return false;
                    }
                    this.a.a.J(i, (GridView) adapterView);
                    return true;
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
            public void onItemClick(AdapterView adapterView, View view2, int i, long j) {
                String str;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                    adapterView.setSelection(-1);
                    if (this.a.a.A != null) {
                        j15 j15Var = new j15();
                        g gVar = (g) adapterView.getAdapter();
                        if (gVar != null && gVar.a() != null) {
                            v86 a = gVar.a();
                            int b = gVar.b();
                            d65 j2 = a.j();
                            String b2 = a.j().b(b + i);
                            pn o = a.j().o(b2);
                            if (j2.h() == EmotionGroupType.USER_COLLECT && m85.f.equals(b2)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UserCollectManageActivityConfig(this.a.a.C)));
                            } else if (j2.h() != EmotionGroupType.USER_DIY || !"#(meme,diysetting)".equals(b2)) {
                                j15Var.n(b2);
                                j15Var.q(j2.h());
                                j15Var.p(j2.g());
                                j15Var.o(j2.f());
                                j15Var.s(j2.l());
                                j15Var.l(j2.i());
                                j15Var.m(o);
                                k15 k15Var = new k15();
                                k15Var.a = this.a.a.A.getFid();
                                k15Var.b = this.a.a.A.getTid();
                                k15Var.d = a.g() + 1;
                                k15Var.h = a.e() + 1;
                                k15Var.f = (a.e() * 21) + i + 1;
                                k15Var.g = 0;
                                k15Var.e = 0;
                                if (this.a.a.A.a.getBarLauncherType() == 3) {
                                    k15Var.e = 1;
                                } else if (this.a.a.A.a.getBarLauncherType() == 2) {
                                    k15Var.e = 2;
                                } else if (this.a.a.A.a.getBarLauncherType() == 7) {
                                    k15Var.e = 3;
                                }
                                k15Var.c = TbadkCoreApplication.getCurrentAccount();
                                j15Var.k(k15Var);
                                this.a.a.A.A(new l55(24, -1, j15Var));
                                k15Var.c(j2, b2);
                                this.a.a.A(k15Var, "c14122");
                            } else {
                                this.a.a.G = j2;
                                TiebaStatic.log(new StatisticItem("c14689").param("uid", TbadkCoreApplication.getCurrentAccount()));
                                HashMap hashMap = new HashMap();
                                hashMap.put("itemID", "");
                                if (this.a.a.H) {
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
                    v86 v86Var = (v86) this.a.t.get(i);
                    gridView.setNumColumns(v86Var.a());
                    gridView.setVerticalSpacing(0);
                    gridView.setHorizontalSpacing(0);
                    gridView.setSelector(R.color.common_color_10022);
                    gridView.setPadding(this.a.C.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701f9), 0, this.a.C.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701f9), 0);
                    gridView.setOnItemLongClickListener(new a(this));
                    gridView.setOnItemClickListener(new b(this));
                    gridView.setAdapter((ListAdapter) new g(this.a, v86Var));
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
                        v86 v86Var = (v86) this.a.t.get(i);
                        if (v86Var != null) {
                            this.a.w = i;
                            IndicatorView indicatorView = this.a.d;
                            if (v86Var.f() > 1) {
                                i2 = 0;
                            } else {
                                i2 = 4;
                            }
                            indicatorView.setVisibility(i2);
                            this.a.d.setCount(v86Var.f());
                            this.a.d.setPosition(v86Var.e());
                            this.a.d.setContentDescription(String.format(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f057d), Integer.valueOf(v86Var.e() + 1)) + String.format(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f057c), Integer.valueOf(v86Var.f())));
                        }
                        if (v86Var != null && v86Var.g() != this.a.v) {
                            this.a.v = v86Var.g();
                            if (this.a.x != null) {
                                this.a.x.b(v86Var.g());
                            }
                        }
                    }
                }
                super.setPrimaryItem(viewGroup, i, obj);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public v86 a;
        public final /* synthetic */ EmotionTabContentView b;

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) ? i : invokeI.longValue;
        }

        /* loaded from: classes3.dex */
        public class a extends zg {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.zg
            public void onLoaded(pn pnVar, String str, int i) {
                View findViewWithTag;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLLI(1048576, this, pnVar, str, i) == null) && pnVar != null && (findViewWithTag = this.a.b.findViewWithTag(str)) != null && (findViewWithTag instanceof TbImageView) && str != null) {
                    TbImageView tbImageView = (TbImageView) findViewWithTag;
                    pnVar.h(tbImageView);
                    tbImageView.setTag(null);
                }
            }
        }

        public g(EmotionTabContentView emotionTabContentView, v86 v86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionTabContentView, v86Var};
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
            this.a = v86Var;
        }

        public v86 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a;
            }
            return (v86) invokeV.objValue;
        }

        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                v86 v86Var = this.a;
                if (v86Var == null) {
                    return 0;
                }
                return v86Var.i();
            }
            return invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                v86 v86Var = this.a;
                if (v86Var == null) {
                    return 0;
                }
                return v86Var.b();
            }
            return invokeV.intValue;
        }

        public void c(v86 v86Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, v86Var) == null) {
                this.a = v86Var;
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
            LinearLayout linearLayout;
            int i2;
            int color;
            pn pnVar;
            int i3;
            int i4;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i, view2, viewGroup)) == null) {
                if (view2 == null) {
                    LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.obfuscated_res_0x7f0d0266, (ViewGroup) null);
                    int measuredWidth = viewGroup.getMeasuredWidth();
                    int measuredHeight = viewGroup.getMeasuredHeight();
                    if (this.a.a() != 0) {
                        i3 = measuredWidth / this.a.a();
                    } else {
                        i3 = 0;
                    }
                    if (this.a.h() != 0) {
                        i4 = measuredHeight / this.a.h();
                    } else {
                        i4 = 0;
                    }
                    linearLayout2.setPadding(this.b.o * 2, this.b.o * 2, this.b.o * 2, this.b.o * 2);
                    linearLayout = linearLayout2;
                    linearLayout = linearLayout2;
                    if (i3 != 0 && i4 != 0) {
                        if (viewGroup != null && viewGroup.getChildAt(0) != null) {
                            viewGroup.getChildAt(0).setLayoutParams(new AbsListView.LayoutParams(i3, i4));
                        }
                        linearLayout2.setLayoutParams(new AbsListView.LayoutParams(i3, i4));
                        linearLayout = linearLayout2;
                    }
                } else {
                    linearLayout = view2;
                }
                LinearLayout linearLayout3 = (LinearLayout) linearLayout;
                v86 v86Var = this.a;
                if (v86Var == null) {
                    return linearLayout3;
                }
                int i5 = v86Var.i() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(R.id.obfuscated_res_0x7f0908de);
                tbImageView.setAutoChangeStyle(false);
                SkinManager.setBackgroundResource(tbImageView, R.drawable.btn_choose_face_selector, this.b.B);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String b = this.a.j().b(i5);
                tbImageView.setTag(b);
                if (!TextUtils.isEmpty(b)) {
                    i2 = 3;
                    Object k = ah.h().k(b, 20, new a(this), 0, 0, null, null, b, Boolean.FALSE, null);
                    if (k != null && (k instanceof pn)) {
                        pnVar = (pn) k;
                    } else {
                        pnVar = null;
                    }
                    if (pnVar != null) {
                        pnVar.h(tbImageView);
                        tbImageView.setTag(null);
                    }
                } else {
                    i2 = 3;
                }
                TextView textView = (TextView) linearLayout3.findViewById(R.id.obfuscated_res_0x7f0908df);
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
                if (b != null && b.length() > i2) {
                    linearLayout3.setContentDescription(b.substring(2, b.length() - 1));
                }
                return linearLayout3;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class a implements wg {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionTabContentView a;

        public GridView e(GridView gridView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, gridView)) == null) ? gridView : (GridView) invokeL.objValue;
        }

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

        @Override // com.baidu.tieba.wg
        public /* bridge */ /* synthetic */ Object a(Object obj) {
            GridView gridView = (GridView) obj;
            e(gridView);
            return gridView;
        }

        @Override // com.baidu.tieba.wg
        public /* bridge */ /* synthetic */ Object c(Object obj) {
            GridView gridView = (GridView) obj;
            h(gridView);
            return gridView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wg
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
        @Override // com.baidu.tieba.wg
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

    /* loaded from: classes3.dex */
    public class b implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionTabContentView a;

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

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.G();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921704, this.a.E));
                this.a.f.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionTabContentView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(EmotionTabContentView emotionTabContentView, int i) {
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
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage.getCmd() != 2921028) {
                return;
            }
            this.a.E(new ArrayList(this.a.s));
            if (this.a.b != null) {
                this.a.b.notifyDataSetChanged();
                if (this.a.v >= 0 && this.a.v < this.a.s.size()) {
                    d65 d65Var = (d65) this.a.s.get(this.a.v);
                    if (d65Var.h() != EmotionGroupType.USER_COLLECT && d65Var.h() != EmotionGroupType.USER_DIY) {
                        return;
                    }
                }
                if (this.a.b != null) {
                    if (this.a.w >= 0 && this.a.w < this.a.t.size()) {
                        EmotionTabContentView emotionTabContentView = this.a;
                        emotionTabContentView.r = (v86) emotionTabContentView.t.get(this.a.w);
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
                                    if (gridView.getAdapter() != null && (gridView.getAdapter() instanceof g)) {
                                        g gVar = (g) gridView.getAdapter();
                                        int d = gVar.a().d();
                                        if (d >= 0 && d < this.a.t.size()) {
                                            gVar.c((v86) this.a.t.get(d));
                                            gVar.notifyDataSetChanged();
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
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionTabContentView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(EmotionTabContentView emotionTabContentView, int i) {
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
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && this.a.A != null && this.a.G != null) {
                    String str = (String) data;
                    d65 d65Var = this.a.G;
                    pn o = d65Var.o(str);
                    j15 j15Var = new j15();
                    j15Var.n(str);
                    j15Var.q(d65Var.h());
                    j15Var.p(d65Var.g());
                    j15Var.o(d65Var.f());
                    j15Var.s(d65Var.l());
                    j15Var.l(d65Var.i());
                    j15Var.m(o);
                    j15Var.j(true);
                    k15 k15Var = new k15();
                    k15Var.a = this.a.A.getFid();
                    k15Var.b = this.a.A.getTid();
                    k15Var.d = -1;
                    k15Var.h = -1;
                    k15Var.f = -1;
                    k15Var.g = 0;
                    k15Var.e = 0;
                    if (this.a.A.a.getBarLauncherType() == 3) {
                        k15Var.e = 1;
                    } else if (this.a.A.a.getBarLauncherType() == 2) {
                        k15Var.e = 2;
                    } else if (this.a.A.a.getBarLauncherType() == 7) {
                        k15Var.e = 3;
                    }
                    k15Var.c = TbadkCoreApplication.getCurrentAccount();
                    j15Var.k(k15Var);
                    this.a.A.A(new l55(24, -1, j15Var));
                    k15Var.c(d65Var, str);
                    this.a.A(k15Var, "c14122");
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    this.a.H = ((Boolean) data).booleanValue();
                }
            }
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
        this.q = -1;
        this.u = 0;
        this.v = -1;
        this.w = -1;
        this.z = new Point();
        this.G = null;
        this.H = false;
        this.I = new d(this, 2921028);
        this.J = new e(this, 2921705);
        this.K = new f(this, 2921706);
        B(context);
    }

    public void F(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.B = i;
            EmotionFloatView emotionFloatView = this.h;
            if (emotionFloatView != null && emotionFloatView.getVisibility() == 0) {
                this.h.setBackGroundFloat(getFloatViewBackGround());
            }
            SkinManager.setBackgroundColor(this, R.color.CAM_X0206, i);
            this.d.setSelector(SkinManager.getDrawable(i, (int) R.drawable.dot_pb_expression_s));
            this.d.setDrawable(SkinManager.getDrawable(i, (int) R.drawable.dot_pb_expression_n));
            if (this.a != null) {
                for (int i2 = 0; i2 < this.a.getChildCount(); i2++) {
                    View childAt = this.a.getChildAt(i2);
                    if (childAt instanceof GridView) {
                        GridView gridView = (GridView) childAt;
                        if (gridView.getAdapter() != null && (gridView.getAdapter() instanceof g)) {
                            ((g) gridView.getAdapter()).notifyDataSetChanged();
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
        this.q = -1;
        this.u = 0;
        this.v = -1;
        this.w = -1;
        this.z = new Point();
        this.G = null;
        this.H = false;
        this.I = new d(this, 2921028);
        this.J = new e(this, 2921705);
        this.K = new f(this, 2921706);
        B(context);
    }

    public final void A(k15 k15Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, k15Var, str) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("fid", k15Var.a).param("tid", k15Var.b).param("uid", k15Var.c).param("obj_type", k15Var.d).param("obj_source", k15Var.e).param("obj_locate", k15Var.f).param("obj_param1", k15Var.g).param(TiebaStatic.Params.OBJ_PARAM2, k15Var.h).param("nid", k15Var.a());
            if (!TextUtils.isEmpty(k15Var.b())) {
                statisticItem.param("obj_id", k15Var.b());
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public void setOnDataSelected(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, editorTools) == null) {
            this.A = editorTools;
        }
    }

    public void setOnEmotionSwitchedListener(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, hVar) == null) {
            this.x = hVar;
        }
    }

    private int getFloatViewBackGround() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            int i = this.D;
            if (i != 0 && this.h != null) {
                if (i >= 3) {
                    if (i == 3) {
                        return 2;
                    }
                    if (i % 4 == 0) {
                        return 3;
                    }
                    if (i % 4 == 3) {
                        return 2;
                    }
                }
                return 1;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            G();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.I);
            MessageManager.getInstance().registerListener(this.J);
            MessageManager.getInstance().registerListener(this.K);
        }
    }

    public final void B(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.C = context;
            this.s = new ArrayList();
            this.t = new ArrayList();
            this.F = new vg(new a(this), 3, 0);
            setOrientation(1);
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0265, (ViewGroup) this, true);
            ViewPager viewPager = (ViewPager) findViewById(R.id.obfuscated_res_0x7f090990);
            this.a = viewPager;
            viewPager.setFadingEdgeLength(0);
            this.a.setOnPageChangeListener(this);
            EmotionFloatView emotionFloatView = new EmotionFloatView(context);
            this.h = emotionFloatView;
            emotionFloatView.setBackGroundFloat(1);
            this.k = context.getResources().getDimensionPixelSize(R.dimen.tbds348);
            this.l = context.getResources().getDimensionPixelSize(R.dimen.tbds444);
            this.m = context.getResources().getDimensionPixelSize(R.dimen.tbds96);
            this.f = new PopupWindow((View) this.h, this.k, this.l, true);
            this.g = new WindowManager.LayoutParams();
            this.n = context.getResources().getDimensionPixelSize(R.dimen.tbds100);
            this.o = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070230);
            WindowManager.LayoutParams layoutParams = this.g;
            layoutParams.width = this.k;
            layoutParams.height = this.l + this.n;
            layoutParams.gravity = 51;
            layoutParams.format = -3;
            layoutParams.type = 1000;
            layoutParams.flags |= 56;
            this.j = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
            this.d = (IndicatorView) findViewById(R.id.obfuscated_res_0x7f0908ae);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09098e);
            this.e = linearLayout;
            linearLayout.setClickable(true);
            if (MenuKeyUtils.hasSmartBar()) {
                WindowManager.LayoutParams layoutParams2 = this.g;
                layoutParams2.type = 1000;
                layoutParams2.flags = 25165832;
            }
        }
    }

    public final void C(int i, int i2) {
        PopupWindow popupWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) && (popupWindow = this.f) != null) {
            popupWindow.setBackgroundDrawable(new ColorDrawable(0));
            this.f.showAtLocation(this.j, 0, i, i2);
            this.f.setTouchable(true);
            this.f.setOnDismissListener(new b(this));
            this.h.setDeleteBottomListener(new c(this));
        }
    }

    public void I(List list, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, list, i) != null) || list == null) {
            return;
        }
        int size = list.size();
        if (i >= 0 && i < size) {
            E(list);
            D(i);
            EmotionViewPagerAdapter emotionViewPagerAdapter = new EmotionViewPagerAdapter(this);
            this.b = emotionViewPagerAdapter;
            this.a.setAdapter(emotionViewPagerAdapter);
            this.a.setCurrentItem(this.y, true);
            h hVar = this.x;
            if (hVar != null) {
                hVar.b(i);
                this.v = i;
            }
        }
    }

    public final void D(int i) {
        List list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048579, this, i) != null) || (list = this.t) == null) {
            return;
        }
        int size = list.size();
        if (i >= 0 && i < size) {
            for (int i2 = 0; i2 < size; i2++) {
                v86 v86Var = (v86) this.t.get(i2);
                if (v86Var != null && v86Var.g() == i) {
                    this.y = v86Var.d();
                    return;
                }
            }
        }
    }

    public void K(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048586, this, i) == null) && this.a != null) {
            int size = this.t.size();
            if (i >= 0 && i < size) {
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        v86 v86Var = (v86) this.t.get(i3);
                        if (v86Var != null && v86Var.g() == i) {
                            i2 = v86Var.d();
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
        }
    }

    public final void E(List list) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.s.clear();
            this.t.clear();
            if (list != null && !list.isEmpty()) {
                this.s.addAll(list);
                int size = list.size();
                for (int i3 = 0; i3 < size; i3++) {
                    d65 d65Var = (d65) list.get(i3);
                    if (d65Var != null) {
                        int c2 = d65Var.c();
                        int a2 = d65Var.a();
                        int k = d65Var.k();
                        int i4 = a2 * k;
                        int i5 = c2 / i4;
                        if (c2 % i4 != 0) {
                            i5++;
                        }
                        for (int i6 = 0; i6 < i5; i6++) {
                            v86 v86Var = new v86();
                            int i7 = i5 - 1;
                            if (i6 < i7) {
                                i = i4;
                            } else {
                                i = c2 - (i7 * i4);
                            }
                            v86Var.u(d65Var);
                            v86Var.r(i3);
                            v86Var.m(d65Var.h());
                            v86Var.s(k);
                            v86Var.k(a2);
                            v86Var.q(i5);
                            v86Var.p(i6);
                            v86Var.l(i);
                            v86Var.t(i6 * a2 * k);
                            v86Var.n((i2 + i) - 1);
                            this.t.add(v86Var);
                        }
                    }
                }
                this.u = this.t.size();
                for (int i8 = 0; i8 < this.u; i8++) {
                    List list2 = this.t;
                    if (list2 != null && list2.get(i8) != null) {
                        ((v86) this.t.get(i8)).o(i8);
                    }
                }
            }
        }
    }

    public final void G() {
        GridView gridView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.p && this.h.getVisibility() != 8 && (gridView = this.c) != null && this.f != null) {
            gridView.setSelection(-1);
            this.h.setVisibility(8);
            this.f.dismiss();
            this.p = false;
            int i = this.q;
            if (i != -1) {
                GridView gridView2 = this.c;
                ((LinearLayout) gridView2.getChildAt(i - gridView2.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
            }
            this.q = -1;
            this.c = null;
        }
    }

    public void J(int i, GridView gridView) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048585, this, i, gridView) == null) && this.q != i && gridView != null) {
            this.E = new HashMap();
            this.D = i;
            g gVar = (g) gridView.getAdapter();
            if (gVar != null && gVar.a() != null) {
                v86 a2 = gVar.a();
                String b2 = a2.j().b(gVar.b() + i);
                if (a2.c() == EmotionGroupType.USER_COLLECT && m85.f.equals(b2)) {
                    return;
                }
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
                String b3 = z95.b.b(b2);
                this.E.put("pid", b3);
                this.E.put("filePath", TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/.collect/" + m85.c() + "/" + b3 + "_s.jpg");
                this.E.put("sharpText", b2);
                this.E.put("uid", TbadkCoreApplication.getCurrentAccount());
                LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
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
                int i2 = this.i.top;
                int i3 = this.l;
                int i4 = (i2 - i3) + this.o;
                layoutParams2.y = i4;
                int i5 = i4 + this.n;
                if (z) {
                    this.f.setHeight(i3);
                    i5 -= this.n;
                } else {
                    this.f.setHeight(i3 - this.m);
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
                    C(this.g.x, i5);
                    this.p = true;
                } else {
                    PopupWindow popupWindow = this.f;
                    if (popupWindow != null) {
                        ViewGroup viewGroup = this.j;
                        WindowManager.LayoutParams layoutParams3 = this.g;
                        popupWindow.update(viewGroup, layoutParams3.x, layoutParams3.y + this.l, -1, -1);
                    } else {
                        C(this.g.x, i5);
                    }
                }
                gridView.setSelection(i);
                int i6 = this.q;
                if (i6 != -1) {
                    ((LinearLayout) gridView.getChildAt(i6 - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
                }
                linearLayout.getChildAt(0).setSelected(true);
                this.q = i;
                this.c = gridView;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        PopupWindow popupWindow;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onDetachedFromWindow();
            if (this.p && (popupWindow = this.f) != null) {
                popupWindow.dismiss();
                this.p = false;
            }
            MessageManager.getInstance().unRegisterListener(this.I);
            MessageManager.getInstance().unRegisterListener(this.J);
            MessageManager.getInstance().unRegisterListener(this.K);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, motionEvent)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, motionEvent)) == null) {
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
                            J(pointToPosition, this.c);
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
    public void onPageScrolled(int i, float f2, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2), Integer.valueOf(i2)}) == null) && this.t != null) {
            int i4 = (f2 > 0.5f ? 1 : (f2 == 0.5f ? 0 : -1));
            if (i4 > 0) {
                i++;
            }
            int size = this.t.size();
            if (i >= 0 && i < size) {
                v86 v86Var = (v86) this.t.get(i);
                this.r = v86Var;
                IndicatorView indicatorView = this.d;
                if (indicatorView != null && v86Var != null) {
                    if (this.w != i) {
                        this.w = i;
                        if (v86Var.f() > 1) {
                            i3 = 0;
                        } else {
                            i3 = 4;
                        }
                        indicatorView.setVisibility(i3);
                        this.d.setCount(this.r.f());
                        v86 v86Var2 = this.r;
                        if (v86Var2 != null && v86Var2.g() != this.v) {
                            this.v = this.r.g();
                            h hVar = this.x;
                            if (hVar != null) {
                                hVar.b(this.r.g());
                            }
                        }
                    }
                    float e2 = this.r.e() + f2;
                    if (i4 > 0) {
                        e2 -= 1.0f;
                    }
                    this.d.setPosition(e2);
                    StringBuilder sb = new StringBuilder();
                    int i5 = ((int) e2) + 1;
                    sb.append(String.format(getResources().getString(R.string.obfuscated_res_0x7f0f057d), Integer.valueOf(i5)));
                    sb.append(String.format(getResources().getString(R.string.obfuscated_res_0x7f0f057c), Integer.valueOf(this.r.f())));
                    this.e.setContentDescription(sb.toString());
                    k15 k15Var = new k15();
                    k15Var.a = this.A.getFid();
                    k15Var.b = this.A.getTid();
                    k15Var.d = this.r.g() + 1;
                    k15Var.f = this.r.b();
                    k15Var.h = i5;
                    k15Var.e = 0;
                    if (this.A.a.getBarLauncherType() == 3) {
                        k15Var.e = 1;
                    } else if (this.A.a.getBarLauncherType() == 2) {
                        k15Var.e = 2;
                    } else if (this.A.a.getBarLauncherType() == 7) {
                        k15Var.e = 3;
                    }
                    k15Var.c = TbadkCoreApplication.getCurrentAccount();
                    k15Var.c(this.r.j(), null);
                    A(k15Var, "c14124");
                }
            }
        }
    }
}

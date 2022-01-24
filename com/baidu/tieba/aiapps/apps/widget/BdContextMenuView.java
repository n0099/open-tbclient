package com.baidu.tieba.aiapps.apps.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import c.a.r0.a.c2.b.e.a;
import c.a.r0.a.c2.b.e.b;
import c.a.r0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes12.dex */
public class BdContextMenuView extends FrameLayout implements a.g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f41850i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f41851e;

    /* renamed from: f  reason: collision with root package name */
    public b f41852f;

    /* renamed from: g  reason: collision with root package name */
    public Context f41853g;

    /* renamed from: h  reason: collision with root package name */
    public ListView f41854h;
    public boolean mLayoutInCenter;

    /* loaded from: classes12.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BdContextMenuView f41855e;

        public a(BdContextMenuView bdContextMenuView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdContextMenuView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41855e = bdContextMenuView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                this.f41855e.f41852f.a(i2);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public List<c.a.r0.a.c2.b.e.b> f41856e;

        /* renamed from: f  reason: collision with root package name */
        public Context f41857f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ BdContextMenuView f41858g;

        /* loaded from: classes12.dex */
        public class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public ImageView a;

            /* renamed from: b  reason: collision with root package name */
            public TextView f41859b;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }
        }

        public b(BdContextMenuView bdContextMenuView, Context context, List<c.a.r0.a.c2.b.e.b> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdContextMenuView, context, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41858g = bdContextMenuView;
            this.f41856e = list;
            this.f41857f = context;
        }

        public void a(int i2) {
            c.a.r0.a.c2.b.e.b bVar;
            b.a d2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (d2 = (bVar = this.f41856e.get(i2)).d()) == null) {
                return;
            }
            d2.a(bVar);
        }

        public final void b(View view, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, i2) == null) {
                if (getCount() == 1) {
                    view.setBackground(this.f41857f.getResources().getDrawable(R.drawable.aiapps_context_menu_round_corner_selector));
                } else if (i2 == 0) {
                    view.setBackground(this.f41857f.getResources().getDrawable(R.drawable.aiapps_context_menu_top_corner_selector));
                } else if (i2 == getCount() - 1) {
                    view.setBackground(this.f41857f.getResources().getDrawable(R.drawable.aiapps_context_menu_bottom_corner_selector));
                } else {
                    view.setBackground(this.f41857f.getResources().getDrawable(R.drawable.aiapps_context_menu_no_corner_selector));
                }
            }
        }

        public void c(List<c.a.r0.a.c2.b.e.b> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
                this.f41856e = list;
                notifyDataSetChanged();
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f41856e.size() : invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? this.f41856e.get(i2) : invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? i2 : invokeI.longValue;
        }

        @Override // android.widget.Adapter
        @SuppressLint({"InflateParams"})
        public View getView(int i2, View view, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            a aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
                if (view == null) {
                    view = LayoutInflater.from(this.f41857f).inflate(R.layout.aiapps_menu_item_view, (ViewGroup) null);
                    aVar = new a(this);
                    aVar.a = (ImageView) view.findViewById(R.id.item_icon);
                    TextView textView = (TextView) view.findViewById(R.id.item_title);
                    aVar.f41859b = textView;
                    textView.setTextColor(this.f41857f.getResources().getColor(R.color.aiapps_context_menu_item_title_color));
                    b(view, i2);
                    view.setTag(aVar);
                } else {
                    aVar = (a) view.getTag();
                }
                c.a.r0.a.c2.b.e.b bVar = this.f41856e.get(i2);
                aVar.f41859b.setText(bVar.e());
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.f41859b.getLayoutParams();
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) aVar.a.getLayoutParams();
                if (bVar.b() != null) {
                    aVar.a.setVisibility(0);
                    aVar.a.setImageDrawable(bVar.b());
                    layoutParams.setMarginStart(this.f41857f.getResources().getDimensionPixelSize(R.dimen.aiapps_context_menu_item_title_left_margin));
                    aVar.f41859b.setLayoutParams(layoutParams);
                } else {
                    aVar.a.setVisibility(8);
                    layoutParams.setMarginStart(this.f41857f.getResources().getDimensionPixelSize(R.dimen.aiapps_context_menu_item_icon_left_margin));
                    aVar.f41859b.setLayoutParams(layoutParams);
                }
                if (this.f41858g.mLayoutInCenter) {
                    ((LinearLayout) view).setGravity(17);
                    layoutParams.width = -2;
                    if (bVar.b() != null) {
                        layoutParams2.setMarginStart(0);
                        aVar.a.setLayoutParams(layoutParams2);
                    } else {
                        layoutParams.setMarginStart(0);
                        aVar.f41859b.setLayoutParams(layoutParams);
                    }
                }
                return view;
            }
            return (View) invokeILL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(801894655, "Lcom/baidu/tieba/aiapps/apps/widget/BdContextMenuView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(801894655, "Lcom/baidu/tieba/aiapps/apps/widget/BdContextMenuView;");
                return;
            }
        }
        f41850i = k.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @SuppressLint({"NewApi"})
    public BdContextMenuView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f41851e = false;
        this.f41853g = context;
        b();
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            setBackground(this.f41853g.getResources().getDrawable(R.drawable.aiapps_context_menu_bg));
            ListView listView = new ListView(this.f41853g);
            this.f41854h = listView;
            listView.setCacheColorHint(0);
            this.f41854h.setDivider(getResources().getDrawable(R.color.aiapps_context_menu_divider_color));
            this.f41854h.setDividerHeight(1);
            this.f41854h.setSelector(new ColorDrawable(0));
            addView(this.f41854h, new FrameLayout.LayoutParams(-1, -1));
            this.f41854h.setOnItemClickListener(new a(this));
        }
    }

    public void layoutMenu(List<c.a.r0.a.c2.b.e.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            boolean z = f41850i;
            if (this.f41851e) {
                return;
            }
            b bVar = this.f41852f;
            if (bVar == null) {
                b bVar2 = new b(this, this.f41853g, list);
                this.f41852f = bVar2;
                this.f41854h.setAdapter((ListAdapter) bVar2);
            } else {
                bVar.c(list);
            }
            this.f41851e = true;
        }
    }

    public void onMenuItemUpdated(c.a.r0.a.c2.b.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
        }
    }

    public void onMenuSetChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f41851e = false;
        }
    }

    public void setLayoutInCenter(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.mLayoutInCenter = z;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdContextMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f41851e = false;
        this.f41853g = context;
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdContextMenuView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f41851e = false;
        this.f41853g = context;
        b();
    }
}

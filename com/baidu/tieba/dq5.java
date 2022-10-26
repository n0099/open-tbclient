package com.baidu.tieba;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class dq5 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public List b;
    public int c;
    public int d;
    public int e;
    public int f;
    public Drawable g;
    public Drawable h;
    public int i;
    public boolean j;

    /* loaded from: classes3.dex */
    public /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public boolean b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) ? j > 0 && j < Long.MAX_VALUE : invokeJ.booleanValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) ? i : invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return 6;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes3.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public HeadImageView a;
        public TextView b;
        public View c;
        public TextView d;
        public TextView e;

        public b(dq5 dq5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dq5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(dq5 dq5Var, a aVar) {
            this(dq5Var);
        }
    }

    /* loaded from: classes3.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public View b;

        public c(dq5 dq5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dq5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ c(dq5 dq5Var, a aVar) {
            this(dq5Var);
        }
    }

    /* loaded from: classes3.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ImageView a;
        public TextView b;
        public View c;

        public d(dq5 dq5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dq5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ d(dq5 dq5Var, a aVar) {
            this(dq5Var);
        }
    }

    public dq5(Context context, zp4 zp4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, zp4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = true;
        this.a = context;
        this.d = R.color.CAM_X0105;
        this.e = R.color.CAM_X0108;
        this.f = R.color.CAM_X0109;
        this.i = fj.f(context, R.dimen.obfuscated_res_0x7f0701e8);
        this.j = TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
    }

    public final void c(TextView textView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, textView, i) == null) {
            if (i <= 0) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            SkinManager.setViewTextColor(textView, R.color.common_color_10225, 1);
            int i2 = R.drawable.icon_news_head_prompt_two;
            if (i < 10) {
                textView.setText(String.valueOf(i));
                i2 = R.drawable.icon_news_head_prompt_one;
            } else if (i < 100) {
                textView.setText(String.valueOf(i));
            } else {
                textView.setText("99+");
            }
            SkinManager.setBackgroundResource(textView, i2);
        }
    }

    public boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: d */
    public b35 getItem(int i) {
        InterceptResult invokeI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            if (this.j) {
                i2 = 3;
            } else {
                i2 = 2;
            }
            if (i >= i2 && i < getCount()) {
                return (b35) this.b.get(i - i2);
            }
            return null;
        }
        return (b35) invokeI.objValue;
    }

    public void e(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.b = list;
            notifyDataSetChanged();
        }
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.c = i;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.j) {
                i = 3;
            } else {
                i = 2;
            }
            List list = this.b;
            if (list == null) {
                return i;
            }
            return list.size() + i;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            b35 item = getItem(i);
            if (i == 0) {
                return 0;
            }
            if (i == 1) {
                return 5;
            }
            if (i == 2 && this.j) {
                return 1;
            }
            if (item == null) {
                return 4;
            }
            if (!TextUtils.isEmpty(item.a()) && TextUtils.isEmpty(item.e()) && TextUtils.isEmpty(item.g())) {
                return 2;
            }
            return 3;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        boolean z;
        c cVar;
        d dVar;
        d dVar2;
        d dVar3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048586, this, i, view2, viewGroup)) == null) {
            if (getItemViewType(i) == 4) {
                return null;
            }
            if (getItemViewType(i) == 0) {
                if (view2 != 0 && view2.getTag() != null && (view2.getTag() instanceof d)) {
                    dVar3 = (d) view2.getTag();
                } else {
                    view2 = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d007f, (ViewGroup) null);
                    dVar3 = new d(this, null);
                    dVar3.a = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09013c);
                    dVar3.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09013e);
                    dVar3.c = view2.findViewById(R.id.obfuscated_res_0x7f09013b);
                    view2.setTag(dVar3);
                }
                SkinManager.setImageResource(dVar3.a, R.drawable.icon_new_friend);
                SkinManager.setViewTextColor(dVar3.b, this.d, 1);
                SkinManager.setBackgroundResource(dVar3.c, R.color.CAM_X0204);
                SkinManager.setBackgroundResource(view2, R.drawable.addresslist_item_bg);
                c((TextView) view2.findViewById(R.id.obfuscated_res_0x7f09013d), this.c);
                return view2;
            } else if (getItemViewType(i) == 5) {
                if (view2 != 0 && view2.getTag() != null && (view2.getTag() instanceof d)) {
                    dVar2 = (d) view2.getTag();
                } else {
                    view2 = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d007f, (ViewGroup) null);
                    dVar2 = new d(this, null);
                    dVar2.a = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09013c);
                    dVar2.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09013e);
                    dVar2.c = view2.findViewById(R.id.obfuscated_res_0x7f09013b);
                    view2.setTag(dVar2);
                }
                SkinManager.setImageResource(dVar2.a, R.drawable.icon_add_friend);
                SkinManager.setViewTextColor(dVar2.b, this.d, 1);
                dVar2.b.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0649));
                SkinManager.setBackgroundResource(dVar2.c, R.color.CAM_X0204);
                SkinManager.setBackgroundResource(view2, R.drawable.addresslist_item_bg);
                ((TextView) view2.findViewById(R.id.obfuscated_res_0x7f09013d)).setVisibility(8);
                return view2;
            } else if (getItemViewType(i) == 1) {
                if (view2 != 0 && view2.getTag() != null && (view2.getTag() instanceof d)) {
                    dVar = (d) view2.getTag();
                } else {
                    view2 = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d007e, (ViewGroup) null);
                    dVar = new d(this, null);
                    dVar.a = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090139);
                    dVar.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09013a);
                    view2.setTag(dVar);
                }
                SkinManager.setImageResource(dVar.a, R.drawable.icon_me_group);
                SkinManager.setViewTextColor(dVar.b, this.d, 1);
                SkinManager.setBackgroundResource(view2, R.drawable.addresslist_item_bg);
                return view2;
            } else {
                b35 item = getItem(i);
                if (getItemViewType(i) == 2) {
                    if (view2 != null && view2.getTag() != null && (view2.getTag() instanceof c)) {
                        cVar = (c) view2.getTag();
                    } else {
                        view2 = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d007d, (ViewGroup) null);
                        cVar = new c(this, null);
                        cVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090138);
                        cVar.b = view2.findViewById(R.id.obfuscated_res_0x7f090137);
                        view2.setTag(cVar);
                    }
                    if (item.a() != null) {
                        cVar.a.setText(item.a());
                    }
                    SkinManager.setViewTextColor(cVar.a, this.e, 1);
                    SkinManager.setBackgroundResource(cVar.b, R.color.CAM_X0204);
                    return view2;
                } else if (getItemViewType(i) != 3) {
                    return null;
                } else {
                    if (view2 != null && view2.getTag() != null && (view2.getTag() instanceof b)) {
                        bVar = (b) view2.getTag();
                    } else {
                        bVar = new b(this, null);
                        view2 = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d007b, (ViewGroup) null);
                        bVar.a = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f090134);
                        bVar.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090135);
                        bVar.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0907b4);
                        bVar.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0907b5);
                        bVar.c = view2.findViewById(R.id.obfuscated_res_0x7f090133);
                        view2.setTag(bVar);
                    }
                    if (item.e() != null) {
                        bVar.b.setText(item.e());
                        bVar.a.L(item.g(), 12, false);
                    }
                    item.k(null);
                    if (item.b() != null) {
                        if (item.b().b() == 1) {
                            bVar.d.setVisibility(0);
                            SkinManager.setViewTextColor(bVar.d, this.f, 1);
                            bVar.d.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f044d));
                            bVar.d.setCompoundDrawables(null, null, null, null);
                            bVar.e.setVisibility(8);
                        } else if (item.b().b() == 0) {
                            if (a(item.b().a()) && b(item.b().c())) {
                                bVar.d.setVisibility(0);
                                bVar.e.setVisibility(0);
                                bVar.d.setText(item.b().a());
                                bVar.e.setText(StringHelper.getTimeInterval(item.b().c()));
                                SkinManager.setViewTextColor(bVar.d, this.f, 1);
                                Drawable drawable = SkinManager.getDrawable(R.drawable.icon_friend_pin);
                                this.g = drawable;
                                int i2 = this.i;
                                drawable.setBounds(0, 0, i2, i2);
                                bVar.d.setCompoundDrawables(this.g, null, null, null);
                                Drawable drawable2 = SkinManager.getDrawable(R.drawable.icon_friend_time);
                                this.h = drawable2;
                                int i3 = this.i;
                                drawable2.setBounds(0, 0, i3, i3);
                                bVar.e.setCompoundDrawables(this.h, null, null, null);
                                SkinManager.setViewTextColor(bVar.e, this.f, 1);
                            } else {
                                bVar.d.setVisibility(8);
                                bVar.e.setVisibility(8);
                            }
                        } else {
                            bVar.d.setVisibility(8);
                            bVar.e.setVisibility(8);
                        }
                    } else {
                        bVar.d.setVisibility(8);
                        bVar.e.setVisibility(8);
                    }
                    SkinManager.setViewTextColor(bVar.b, this.d, 1);
                    String a2 = item.a();
                    b35 item2 = getItem(i + 1);
                    if (!TextUtils.isEmpty(a2) && item2 != null && !a2.equals(item2.a())) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        bVar.c.setVisibility(4);
                    } else {
                        bVar.c.setVisibility(0);
                        SkinManager.setBackgroundResource(bVar.c, R.color.CAM_X0204);
                    }
                    SkinManager.setBackgroundResource(view2, R.drawable.addresslist_item_bg);
                    SkinManager.setViewTextColor(bVar.b, this.d, 1);
                    SkinManager.setBackgroundResource(bVar.c, R.color.CAM_X0204);
                    SkinManager.setBackgroundResource(view2, R.drawable.addresslist_item_bg);
                    return view2;
                }
            }
        }
        return (View) invokeILL.objValue;
    }
}

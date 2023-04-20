package com.baidu.tieba;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.signall.SignAllForumActivity;
import com.baidu.tieba.signall.SignSingleModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.badge.BadgeDrawable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes3.dex */
public class ah9 extends BaseAdapter implements AbsListView.OnScrollListener, SignSingleModel.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<xg9> a;
    public wg9 b;
    public SignAllForumActivity c;
    public HashMap<String, SignSingleModel> d;
    public boolean e;
    public boolean f;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) ? i : invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048591, this, absListView, i, i2, i3) == null) {
        }
    }

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xg9 a;
        public final /* synthetic */ c b;
        public final /* synthetic */ ah9 c;

        public a(ah9 ah9Var, xg9 xg9Var, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ah9Var, xg9Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ah9Var;
            this.a = xg9Var;
            this.b = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.k()) {
                return;
            }
            this.b.i.setVisibility(4);
            this.b.j.setVisibility(0);
            this.b.k.setText(R.string.obfuscated_res_0x7f0f127a);
            this.a.t(true);
            SignSingleModel signSingleModel = new SignSingleModel(this.c.c);
            signSingleModel.Z(this.c);
            String str = this.a.c() + "";
            synchronized (this.c) {
                this.c.d.put(str, signSingleModel);
            }
            signSingleModel.a0(this.a.d(), str);
            TiebaStatic.log("signall_resign_click");
        }
    }

    /* loaded from: classes3.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public TextView b;

        public b(ah9 ah9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ah9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public BarImageView a;
        public LinearLayout b;
        public TextView c;
        public ImageView d;
        public TextView e;
        public FrameLayout f;
        public TextView g;
        public RelativeLayout h;
        public ImageView i;
        public ProgressBar j;
        public TextView k;
        public TextView l;
        public TextView m;

        public c(ah9 ah9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ah9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public ah9(SignAllForumActivity signAllForumActivity, TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {signAllForumActivity, textView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList<>();
        this.d = new HashMap<>();
        this.f = true;
        this.c = signAllForumActivity;
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.b
    public void a(SignData signData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, signData) == null) {
            String str = signData.forumId;
            synchronized (this) {
                this.d.remove(str);
            }
            i(str, true, signData, null);
        }
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            if (this.a.size() > i) {
                return this.a.get(i);
            }
            return null;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            if (getItem(i) instanceof vg9) {
                return 1;
            }
            return 0;
        }
        return invokeI.intValue;
    }

    public void h(wg9 wg9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, wg9Var) != null) || wg9Var == null) {
            return;
        }
        this.b = wg9Var;
        ArrayList<xg9> k = wg9Var.k();
        this.a = k;
        if (k.size() == 0) {
            this.f = false;
        } else {
            this.f = true;
        }
        notifyDataSetChanged();
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.e = true;
            synchronized (this) {
                try {
                    for (Map.Entry<String, SignSingleModel> entry : this.d.entrySet()) {
                        entry.getValue().Y();
                    }
                    this.d.clear();
                }
            }
        }
    }

    public final View e() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            View inflate = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0826, (ViewGroup) null);
            NoDataView a2 = NoDataViewFactory.a(this.c.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f09208a), NoDataViewFactory.d.b(NoDataViewFactory.ImgType.FINDBAR, this.c.getResources().getDimensionPixelSize(R.dimen.tbds90)), NoDataViewFactory.e.d(null, this.c.getResources().getString(R.string.obfuscated_res_0x7f0f0d33)), null);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            iv4 layoutMode = this.c.getLayoutMode();
            if (skinType == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.l(z);
            this.c.getLayoutMode().k(inflate);
            a2.f(this.c.getPageContext(), skinType);
            a2.setVisibility(0);
            a2.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    public final View f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            if (i == 0) {
                View inflate = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0829, (ViewGroup) null);
                c cVar = new c(this);
                BarImageView barImageView = (BarImageView) inflate.findViewById(R.id.obfuscated_res_0x7f09209d);
                cVar.a = barImageView;
                barImageView.setIsRound(false);
                cVar.a.setGifIconSupport(false);
                cVar.c = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0920a4);
                cVar.d = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0920a2);
                cVar.e = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0920a0);
                cVar.f = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0920a5);
                cVar.g = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09209e);
                cVar.h = (RelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0920a6);
                cVar.i = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0920a7);
                cVar.j = (ProgressBar) inflate.findViewById(R.id.obfuscated_res_0x7f0920a9);
                cVar.k = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0920aa);
                cVar.l = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09209f);
                cVar.b = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0920a3);
                cVar.m = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0920a1);
                inflate.setTag(cVar);
                return inflate;
            }
            View inflate2 = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0828, (ViewGroup) null);
            b bVar = new b(this);
            bVar.a = (TextView) inflate2.findViewById(R.id.obfuscated_res_0x7f09209b);
            bVar.b = (TextView) inflate2.findViewById(R.id.obfuscated_res_0x7f09209a);
            inflate2.setTag(bVar);
            return inflate2;
        }
        return (View) invokeI.objValue;
    }

    public final void g(View view2, View view3, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048580, this, view2, view3, i) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            iv4 layoutMode = this.c.getLayoutMode();
            if (skinType == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.l(z);
            this.c.getLayoutMode().k(view2);
            c cVar = (c) view2.getTag();
            xg9 xg9Var = (xg9) getItem(i);
            if (xg9Var == null) {
                return;
            }
            String d = xg9Var.d();
            if (d != null && d.length() > 8) {
                char[] charArray = d.toCharArray();
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    if (i2 >= charArray.length) {
                        break;
                    }
                    if (StringUtils.isChinese(charArray[i2])) {
                        i3 += 2;
                    } else {
                        i3++;
                    }
                    if (i3 > 16) {
                        d = d.substring(0, i2) + StringHelper.STRING_MORE;
                        break;
                    }
                    i2++;
                }
            }
            cVar.c.setText(d);
            SkinManager.setImageResource(cVar.d, BitmapHelper.getSmallGradeResourceIdNew(xg9Var.i()));
            cVar.e.setText(xg9Var.h() + "/" + xg9Var.g());
            cVar.m.clearAnimation();
            if (xg9Var.l()) {
                cVar.b.setVisibility(0);
                cVar.l.setVisibility(8);
                cVar.g.setVisibility(0);
                cVar.h.setVisibility(8);
                cVar.g.setText(String.format(this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f1273), Integer.valueOf(xg9Var.b())));
                if (xg9Var.m()) {
                    cVar.e.setText(this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f127d));
                    cVar.m.setVisibility(8);
                } else {
                    cVar.e.setText(xg9Var.h() + "/" + xg9Var.g());
                    cVar.m.setVisibility(0);
                }
                int e = xg9Var.e();
                if (e > 0) {
                    cVar.m.setVisibility(0);
                    cVar.m.setText(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX + e);
                } else {
                    cVar.m.setVisibility(8);
                }
            } else if (xg9Var.j()) {
                cVar.b.setVisibility(0);
                cVar.l.setVisibility(8);
                cVar.m.setVisibility(8);
                cVar.g.setVisibility(8);
                cVar.h.setVisibility(0);
                if (xg9Var.k()) {
                    cVar.i.setVisibility(4);
                    cVar.j.setVisibility(0);
                    cVar.k.setText(R.string.obfuscated_res_0x7f0f127a);
                } else {
                    cVar.i.setVisibility(0);
                    cVar.j.setVisibility(4);
                    cVar.k.setText(R.string.obfuscated_res_0x7f0f1279);
                }
                cVar.h.setOnClickListener(new a(this, xg9Var, cVar));
            } else {
                cVar.g.setVisibility(8);
                cVar.h.setVisibility(8);
                cVar.m.setVisibility(8);
                cVar.b.setVisibility(0);
                cVar.l.setVisibility(8);
            }
            String a2 = xg9Var.a();
            cVar.a.setTag(a2);
            cVar.a.setPlaceHolder(1);
            cVar.a.N(a2, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (!this.f) {
                return 1;
            }
            return this.a.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048585, this, i, view2, viewGroup)) == null) {
            if (!this.f) {
                return e();
            }
            int itemViewType = getItemViewType(i);
            if (view2 == null) {
                view2 = f(itemViewType);
            }
            boolean z = true;
            if (itemViewType == 1) {
                if (view2.getTag() != null && (view2.getTag() instanceof b)) {
                    bVar = (b) view2.getTag();
                } else {
                    view2 = f(itemViewType);
                    bVar = (b) view2.getTag();
                }
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                iv4 layoutMode = this.c.getLayoutMode();
                if (skinType != 4) {
                    z = false;
                }
                layoutMode.l(z);
                this.c.getLayoutMode().k(view2.findViewById(R.id.obfuscated_res_0x7f09208c));
                bVar.a.setText(((vg9) getItem(i)).x());
                j(bVar.b, i);
            } else {
                if (view2.getTag() == null || !(view2.getTag() instanceof c)) {
                    view2 = f(itemViewType);
                }
                g(view2, viewGroup, i);
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    public final void i(String str, boolean z, SignData signData, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{str, Boolean.valueOf(z), signData, str2}) == null) {
            int size = this.a.size();
            for (int i = 0; i < size; i++) {
                xg9 xg9Var = this.a.get(i);
                if ((xg9Var.c() + "").equals(str)) {
                    xg9Var.u(z);
                    xg9Var.s(!z);
                    xg9Var.t(false);
                    if (z) {
                        xg9Var.o(signData.count_sign_num);
                        xg9Var.q(signData.sign_bonus_point);
                        xg9Var.r(1);
                        TbadkApplication.getInst().addSignedForum(xg9Var.d(), signData.sign_bonus_point, -1);
                        ArrayList<xg9> x = this.b.x();
                        if (x.contains(xg9Var)) {
                            x.remove(xg9Var);
                            this.b.r().add(xg9Var);
                        }
                    } else {
                        xg9Var.p(str2);
                    }
                    if (!this.e) {
                        notifyDataSetChanged();
                        return;
                    }
                    return;
                }
            }
        }
    }

    public final void j(TextView textView, int i) {
        int l;
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, textView, i) == null) {
            wg9 wg9Var = this.b;
            if (wg9Var == null) {
                l = 7;
            } else {
                l = wg9Var.l();
            }
            ArrayList<xg9> arrayList = this.a;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<xg9> it = this.a.iterator();
                i2 = 0;
                i3 = 0;
                i4 = 0;
                i5 = 0;
                while (it.hasNext()) {
                    xg9 next = it.next();
                    if (!TextUtils.isEmpty(next.d())) {
                        if (next.i() >= l) {
                            if (next.l()) {
                                i2++;
                            } else {
                                i3++;
                            }
                        } else if (next.l()) {
                            i4++;
                        } else {
                            i5++;
                        }
                    }
                }
            } else {
                i2 = 0;
                i3 = 0;
                i4 = 0;
                i5 = 0;
            }
            if (i == 0 && i2 + i3 > 0) {
                format = String.format(this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f1278), Integer.valueOf(i2), Integer.valueOf(i3));
            } else {
                format = String.format(this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f1278), Integer.valueOf(i4), Integer.valueOf(i5));
            }
            textView.setText(format);
        }
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.b
    public void onError(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, str2) == null) {
            if (!TextUtils.isEmpty(str2)) {
                ii.Q(this.c.getPageContext().getPageActivity(), str2);
            }
            synchronized (this) {
                this.d.remove(str);
            }
            i(str, false, null, str2);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048592, this, absListView, i) == null) && i == 0) {
            notifyDataSetChanged();
        }
    }
}

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
public class ch8 extends BaseAdapter implements AbsListView.OnScrollListener, SignSingleModel.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<zg8> a;
    public yg8 b;
    public SignAllForumActivity c;
    public HashMap<String, SignSingleModel> d;
    public boolean e;
    public boolean f;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zg8 a;
        public final /* synthetic */ c b;
        public final /* synthetic */ ch8 c;

        public a(ch8 ch8Var, zg8 zg8Var, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ch8Var, zg8Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ch8Var;
            this.a = zg8Var;
            this.b = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.k()) {
                return;
            }
            this.b.i.setVisibility(4);
            this.b.j.setVisibility(0);
            this.b.k.setText(R.string.obfuscated_res_0x7f0f119a);
            this.a.t(true);
            SignSingleModel signSingleModel = new SignSingleModel(this.c.c);
            signSingleModel.I(this.c);
            String str = this.a.c() + "";
            synchronized (this.c) {
                this.c.d.put(str, signSingleModel);
            }
            signSingleModel.J(this.a.d(), str);
            TiebaStatic.log("signall_resign_click");
        }
    }

    /* loaded from: classes3.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public TextView b;

        public b(ch8 ch8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ch8Var};
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

        public c(ch8 ch8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ch8Var};
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

    public ch8(SignAllForumActivity signAllForumActivity, TextView textView) {
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

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.e = true;
            synchronized (this) {
                try {
                    for (Map.Entry<String, SignSingleModel> entry : this.d.entrySet()) {
                        entry.getValue().H();
                    }
                    this.d.clear();
                }
            }
        }
    }

    public final View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            View inflate = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d07ac, (ViewGroup) null);
            NoDataView a2 = NoDataViewFactory.a(this.c.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091e7e), NoDataViewFactory.d.b(NoDataViewFactory.ImgType.FINDBAR, this.c.getResources().getDimensionPixelSize(R.dimen.tbds90)), NoDataViewFactory.e.d(null, this.c.getResources().getString(R.string.obfuscated_res_0x7f0f0c54)), null);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.c.getLayoutMode().l(skinType == 1);
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
                View inflate = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d07af, (ViewGroup) null);
                c cVar = new c(this);
                BarImageView barImageView = (BarImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091e91);
                cVar.a = barImageView;
                barImageView.setIsRound(false);
                cVar.a.setGifIconSupport(false);
                cVar.c = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091e98);
                cVar.d = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091e96);
                cVar.e = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091e94);
                cVar.f = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091e99);
                cVar.g = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091e92);
                cVar.h = (RelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091e9a);
                cVar.i = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091e9b);
                cVar.j = (ProgressBar) inflate.findViewById(R.id.obfuscated_res_0x7f091e9d);
                cVar.k = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091e9e);
                cVar.l = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091e93);
                cVar.b = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091e97);
                cVar.m = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091e95);
                inflate.setTag(cVar);
                return inflate;
            }
            View inflate2 = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d07ae, (ViewGroup) null);
            b bVar = new b(this);
            bVar.a = (TextView) inflate2.findViewById(R.id.obfuscated_res_0x7f091e8f);
            bVar.b = (TextView) inflate2.findViewById(R.id.obfuscated_res_0x7f091e8e);
            inflate2.setTag(bVar);
            return inflate2;
        }
        return (View) invokeI.objValue;
    }

    public final void g(View view2, View view3, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048580, this, view2, view3, i) == null) {
            this.c.getLayoutMode().l(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.c.getLayoutMode().k(view2);
            c cVar = (c) view2.getTag();
            zg8 zg8Var = (zg8) getItem(i);
            if (zg8Var == null) {
                return;
            }
            String d = zg8Var.d();
            if (d != null && d.length() > 8) {
                char[] charArray = d.toCharArray();
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    if (i2 >= charArray.length) {
                        break;
                    }
                    i3 = StringUtils.isChinese(charArray[i2]) ? i3 + 2 : i3 + 1;
                    if (i3 > 16) {
                        d = d.substring(0, i2) + StringHelper.STRING_MORE;
                        break;
                    }
                    i2++;
                }
            }
            cVar.c.setText(d);
            SkinManager.setImageResource(cVar.d, BitmapHelper.getSmallGradeResourceIdNew(zg8Var.i()));
            cVar.e.setText(zg8Var.h() + "/" + zg8Var.g());
            cVar.m.clearAnimation();
            if (zg8Var.l()) {
                cVar.b.setVisibility(0);
                cVar.l.setVisibility(8);
                cVar.g.setVisibility(0);
                cVar.h.setVisibility(8);
                cVar.g.setText(String.format(this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f1193), Integer.valueOf(zg8Var.b())));
                if (zg8Var.m()) {
                    cVar.e.setText(this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f119d));
                    cVar.m.setVisibility(8);
                } else {
                    cVar.e.setText(zg8Var.h() + "/" + zg8Var.g());
                    cVar.m.setVisibility(0);
                }
                int e = zg8Var.e();
                if (e > 0) {
                    cVar.m.setVisibility(0);
                    cVar.m.setText(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX + e);
                } else {
                    cVar.m.setVisibility(8);
                }
            } else if (zg8Var.j()) {
                cVar.b.setVisibility(0);
                cVar.l.setVisibility(8);
                cVar.m.setVisibility(8);
                cVar.g.setVisibility(8);
                cVar.h.setVisibility(0);
                if (zg8Var.k()) {
                    cVar.i.setVisibility(4);
                    cVar.j.setVisibility(0);
                    cVar.k.setText(R.string.obfuscated_res_0x7f0f119a);
                } else {
                    cVar.i.setVisibility(0);
                    cVar.j.setVisibility(4);
                    cVar.k.setText(R.string.obfuscated_res_0x7f0f1199);
                }
                cVar.h.setOnClickListener(new a(this, zg8Var, cVar));
            } else {
                cVar.g.setVisibility(8);
                cVar.h.setVisibility(8);
                cVar.m.setVisibility(8);
                cVar.b.setVisibility(0);
                cVar.l.setVisibility(8);
            }
            String a2 = zg8Var.a();
            cVar.a.setTag(a2);
            cVar.a.setPlaceHolder(1);
            cVar.a.K(a2, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f) {
                return this.a.size();
            }
            return 1;
        }
        return invokeV.intValue;
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

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) ? i : invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) ? getItem(i) instanceof xg8 ? 1 : 0 : invokeI.intValue;
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
            if (itemViewType == 1) {
                if (view2.getTag() != null && (view2.getTag() instanceof b)) {
                    bVar = (b) view2.getTag();
                } else {
                    view2 = f(itemViewType);
                    bVar = (b) view2.getTag();
                }
                this.c.getLayoutMode().l(TbadkCoreApplication.getInst().getSkinType() == 1);
                this.c.getLayoutMode().k(view2.findViewById(R.id.obfuscated_res_0x7f091e80));
                bVar.a.setText(((xg8) getItem(i)).x());
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

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    public void h(yg8 yg8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, yg8Var) == null) || yg8Var == null) {
            return;
        }
        this.b = yg8Var;
        ArrayList<zg8> k = yg8Var.k();
        this.a = k;
        if (k.size() == 0) {
            this.f = false;
        } else {
            this.f = true;
        }
        notifyDataSetChanged();
    }

    public final void i(String str, boolean z, SignData signData, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{str, Boolean.valueOf(z), signData, str2}) == null) {
            int size = this.a.size();
            for (int i = 0; i < size; i++) {
                zg8 zg8Var = this.a.get(i);
                if ((zg8Var.c() + "").equals(str)) {
                    zg8Var.u(z);
                    zg8Var.s(!z);
                    zg8Var.t(false);
                    if (z) {
                        zg8Var.o(signData.count_sign_num);
                        zg8Var.q(signData.sign_bonus_point);
                        zg8Var.r(1);
                        TbadkApplication.getInst().addSignedForum(zg8Var.d(), signData.sign_bonus_point, -1);
                        ArrayList<zg8> x = this.b.x();
                        if (x.contains(zg8Var)) {
                            x.remove(zg8Var);
                            this.b.r().add(zg8Var);
                        }
                    } else {
                        zg8Var.p(str2);
                    }
                    if (this.e) {
                        return;
                    }
                    notifyDataSetChanged();
                    return;
                }
            }
        }
    }

    public final void j(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, textView, i) == null) {
            yg8 yg8Var = this.b;
            int l = yg8Var == null ? 7 : yg8Var.l();
            ArrayList<zg8> arrayList = this.a;
            if (arrayList == null || arrayList.size() <= 0) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
                i5 = 0;
            } else {
                Iterator<zg8> it = this.a.iterator();
                i2 = 0;
                i3 = 0;
                i4 = 0;
                i5 = 0;
                while (it.hasNext()) {
                    zg8 next = it.next();
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
            }
            if (i == 0 && i2 + i3 > 0) {
                format = String.format(this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f1198), Integer.valueOf(i2), Integer.valueOf(i3));
            } else {
                format = String.format(this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f1198), Integer.valueOf(i4), Integer.valueOf(i5));
            }
            textView.setText(format);
        }
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.b
    public void onError(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, str2) == null) {
            if (!TextUtils.isEmpty(str2)) {
                ri.N(this.c.getPageContext().getPageActivity(), str2);
            }
            synchronized (this) {
                this.d.remove(str);
            }
            i(str, false, null, str2);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048591, this, absListView, i, i2, i3) == null) {
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

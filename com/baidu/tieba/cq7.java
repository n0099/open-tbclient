package com.baidu.tieba;

import android.text.Layout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.myAttentionAndFans.NewMyFansUserLikeButton;
import com.baidu.tieba.wz4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class cq7 extends bq7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext d;
    public boolean e;
    public int f;
    public View.OnClickListener g;
    public View.OnClickListener h;

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return 3;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;
        public final /* synthetic */ cq7 b;

        public a(cq7 cq7Var, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cq7Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cq7Var;
            this.a = cVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Layout layout;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (layout = this.a.c.getLayout()) != null) {
                if (layout.getEllipsisCount(layout.getLineCount() - 1) > 0) {
                    this.a.c.setCompoundDrawablePadding(0);
                } else {
                    this.a.c.setCompoundDrawablePadding(fj.f(this.b.d.getPageActivity(), R.dimen.tbds10));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements wz4.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cq7 a;

        public b(cq7 cq7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cq7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cq7Var;
        }

        @Override // com.baidu.tieba.wz4.f
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && !z) {
                fj.M(this.a.d.getPageActivity(), R.string.obfuscated_res_0x7f0f14dc);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ViewGroup a;
        public ClickableHeaderImageView b;
        public EMTextView c;
        public View d;
        public EMTextView e;
        public LinearLayout f;
        public LinearLayout g;
        public NewMyFansUserLikeButton h;
        public wz4 i;
        public ImageView j;
        public ProgressBar k;
        public TextView l;
        public TextView m;

        public c(cq7 cq7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cq7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ c(cq7 cq7Var, a aVar) {
            this(cq7Var);
        }
    }

    public cq7(TbPageContext tbPageContext, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z), Integer.valueOf(i), onClickListener, onClickListener2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = null;
        this.e = true;
        this.f = 0;
        this.g = null;
        this.h = null;
        this.d = tbPageContext;
        this.e = z;
        this.f = i;
        this.g = onClickListener2;
        this.h = onClickListener;
        this.a = new ArrayList();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            ArrayList arrayList = this.a;
            if (arrayList != null && i < arrayList.size()) {
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
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            ArrayList arrayList = this.a;
            if (arrayList != null && i < arrayList.size()) {
                return i;
            }
            return -1L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            if (this.b) {
                return 0;
            }
            ArrayList arrayList = this.a;
            if (arrayList != null && i < arrayList.size()) {
                if (((UserData) this.a.get(i)).mAttentionType != 0) {
                    return 0;
                }
                return 2;
            }
            return 1;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            if (this.b) {
                return false;
            }
            return super.isEnabled(i);
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.tieba.bq7
    public void a(it4 it4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, it4Var) == null) && it4Var != null && it4Var.b() != null) {
            Iterator it = it4Var.b().iterator();
            while (true) {
                boolean z = false;
                if (!it.hasNext()) {
                    break;
                }
                UserData userData = (UserData) it.next();
                if (userData != null) {
                    if (userData.getHave_attention() > 0) {
                        z = true;
                    }
                    userData.setIsLike(z);
                }
            }
            ArrayList arrayList = new ArrayList();
            if (this.a == null) {
                this.a = new ArrayList();
            }
            arrayList.addAll(it4Var.b());
            if (!ListUtils.isEmpty(this.a)) {
                ArrayList arrayList2 = this.a;
                if (arrayList2.get(arrayList2.size() - 1) != null) {
                    ArrayList arrayList3 = this.a;
                    if (((UserData) arrayList3.get(arrayList3.size() - 1)).isNewFan && !((UserData) arrayList.get(0)).isNewFan) {
                        ArrayList arrayList4 = this.a;
                        ((UserData) arrayList4.get(arrayList4.size() - 1)).isLastNewFan = true;
                        if (ListUtils.isEmpty(this.a) && arrayList.size() > 0 && ((UserData) arrayList.get(0)).isNewFan) {
                            UserData userData2 = new UserData();
                            userData2.mAttentionType = 0;
                            arrayList.add(0, userData2);
                        }
                        this.a.addAll(arrayList);
                    }
                }
            }
            int i = 0;
            while (i < arrayList.size() - 1) {
                UserData userData3 = (UserData) arrayList.get(i);
                i++;
                UserData userData4 = (UserData) arrayList.get(i);
                if (userData3 != null && userData4 != null && userData3.isNewFan && !userData4.isNewFan) {
                    userData3.isLastNewFan = true;
                }
            }
            if (ListUtils.isEmpty(this.a)) {
                UserData userData22 = new UserData();
                userData22.mAttentionType = 0;
                arrayList.add(0, userData22);
            }
            this.a.addAll(arrayList);
        }
    }

    @Override // com.baidu.tieba.bq7
    public boolean d(long j) {
        InterceptResult invokeJ;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            if (j != 0 && (arrayList = this.a) != null && arrayList.size() != 0) {
                Iterator it = this.a.iterator();
                while (it.hasNext()) {
                    UserData userData = (UserData) it.next();
                    if (userData != null && userData.getUserIdLong() == j) {
                        this.a.remove(userData);
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.b) {
                return 1;
            }
            int i = 0;
            ArrayList arrayList = this.a;
            if (arrayList != null) {
                i = arrayList.size();
            }
            if (c()) {
                return i + 1;
            }
            return i;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        c cVar;
        View inflate;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i, view2, viewGroup)) == null) {
            if (this.a == null) {
                return view2;
            }
            int itemViewType = getItemViewType(i);
            boolean z = true;
            if (view2 != null && (view2.getTag() instanceof c)) {
                cVar = (c) view2.getTag();
                inflate = view2;
            } else {
                cVar = new c(this, null);
                if (itemViewType == 0) {
                    inflate = LayoutInflater.from(this.d.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d071b, (ViewGroup) null);
                    ViewGroup viewGroup2 = (ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f090fd8);
                    cVar.a = viewGroup2;
                    viewGroup2.setOnClickListener(this.h);
                    ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0919ba);
                    cVar.b = clickableHeaderImageView;
                    clickableHeaderImageView.setRadius(fj.f(this.d.getPageActivity(), R.dimen.obfuscated_res_0x7f070308));
                    cVar.b.setAutoChangeStyle(true);
                    cVar.b.setClickable(false);
                    ((ViewGroup.MarginLayoutParams) cVar.b.getLayoutParams()).setMargins(fj.f(this.d.getPageActivity(), R.dimen.obfuscated_res_0x7f07020f), 0, 0, 0);
                    cVar.f = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f090f19);
                    cVar.g = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f09209d);
                    EMTextView eMTextView = (EMTextView) inflate.findViewById(R.id.obfuscated_res_0x7f091612);
                    cVar.c = eMTextView;
                    eMTextView.getViewTreeObserver().addOnGlobalLayoutListener(new a(this, cVar));
                    View a2 = co4.b().a(this.d.getPageActivity(), 5);
                    cVar.d = a2;
                    if (a2 != null) {
                        a2.setVisibility(8);
                        cVar.g.addView(cVar.d, 1);
                    }
                    cVar.l = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0902cc);
                    cVar.e = (EMTextView) inflate.findViewById(R.id.obfuscated_res_0x7f090f68);
                    NewMyFansUserLikeButton newMyFansUserLikeButton = (NewMyFansUserLikeButton) inflate.findViewById(R.id.obfuscated_res_0x7f0902d8);
                    cVar.h = newMyFansUserLikeButton;
                    newMyFansUserLikeButton.setContext(this.d);
                    ((LinearLayout.LayoutParams) cVar.h.getLayoutParams()).setMargins(0, 0, fj.f(this.d.getPageActivity(), R.dimen.obfuscated_res_0x7f07020f), 0);
                    wz4 wz4Var = new wz4(this.d, cVar.h);
                    cVar.i = wz4Var;
                    wz4Var.n((uz4) ListUtils.getItem(this.a, i));
                    cVar.i.o(new b(this));
                    cVar.k = null;
                    cVar.m = null;
                    cVar.j = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0907f7);
                } else if (itemViewType == 2) {
                    inflate = LayoutInflater.from(this.d.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d05cf, (ViewGroup) null);
                    cVar.m = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0915bc);
                } else {
                    inflate = LayoutInflater.from(this.d.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0646, (ViewGroup) null);
                    cVar.c = (EMTextView) inflate.findViewById(R.id.obfuscated_res_0x7f091839);
                    inflate.setOnClickListener(this.g);
                    cVar.k = (ProgressBar) inflate.findViewById(R.id.obfuscated_res_0x7f091ab9);
                    cVar.m = null;
                }
                inflate.setTag(cVar);
            }
            NewMyFansUserLikeButton newMyFansUserLikeButton2 = cVar.h;
            if (newMyFansUserLikeButton2 != null) {
                newMyFansUserLikeButton2.setTag(Integer.valueOf(i));
            }
            if (itemViewType == 0) {
                if (this.b) {
                    cVar.f.setVisibility(8);
                    cVar.l.setVisibility(0);
                    if (this.e) {
                        cVar.l.setText(R.string.obfuscated_res_0x7f0f0cca);
                    } else {
                        int i2 = this.f;
                        if (i2 == 2) {
                            cVar.l.setText(R.string.obfuscated_res_0x7f0f0867);
                        } else if (i2 == 1) {
                            cVar.l.setText(R.string.obfuscated_res_0x7f0f086a);
                        } else {
                            cVar.l.setText(R.string.obfuscated_res_0x7f0f0c8c);
                        }
                    }
                } else {
                    cVar.a.setTag(Integer.valueOf(i));
                    UserData userData = (UserData) ListUtils.getItem(this.a, i);
                    if (userData == null) {
                        return inflate;
                    }
                    cVar.l.setVisibility(8);
                    UtilHelper.showHeadImageViewBigV(cVar.b, userData, 0);
                    cVar.c.setText(UtilHelper.getUserName(userData));
                    cVar.b.setPlaceHolder(1);
                    cVar.b.L(userData.getAvater(), 12, false);
                    if (cVar.d != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            cVar.d.setVisibility(8);
                        } else {
                            cVar.d.setVisibility(0);
                            bo4 bo4Var = new bo4();
                            bo4Var.a = userData.getAlaUserData();
                            bo4Var.b = 5;
                            cVar.d.setTag(bo4Var);
                        }
                    }
                    if (ej.isEmpty(userData.getIntro())) {
                        cVar.e.setVisibility(8);
                    } else {
                        cVar.e.setVisibility(0);
                        cVar.e.setText(userData.getIntro());
                    }
                    String userId = userData.getUserId();
                    if (userData.getHave_attention() <= 0) {
                        z = false;
                    }
                    userData.setIsLike(z);
                    cVar.i.n(userData);
                    if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        cVar.h.setVisibility(8);
                    } else {
                        cVar.h.setStatsParams(2, userId);
                        cVar.i.m("9");
                        cVar.h.setVisibility(0);
                    }
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cVar.j.getLayoutParams();
                if (ListUtils.getItem(this.a, i) != null && ((UserData) ListUtils.getItem(this.a, i)).isLastNewFan) {
                    layoutParams.height = fj.f(this.d.getPageActivity(), R.dimen.obfuscated_res_0x7f07023b);
                    layoutParams.setMargins(0, 0, 0, 0);
                    cVar.j.setVisibility(0);
                } else {
                    cVar.j.setVisibility(8);
                    layoutParams.height = fj.f(this.d.getPageActivity(), R.dimen.obfuscated_res_0x7f070198);
                    layoutParams.setMargins(fj.f(this.d.getPageActivity(), R.dimen.obfuscated_res_0x7f07020f), 0, fj.f(this.d.getPageActivity(), R.dimen.obfuscated_res_0x7f07020f), 0);
                }
                cVar.j.setLayoutParams(layoutParams);
                cVar.k = null;
            } else if (itemViewType == 2) {
                cVar.m.setText(R.string.obfuscated_res_0x7f0f0c6c);
                cVar.m.setVisibility(0);
            } else {
                cVar.c.setText(this.d.getString(R.string.obfuscated_res_0x7f0f0a63));
                cVar.k.setVisibility(0);
            }
            h(inflate, cVar);
            return inflate;
        }
        return (View) invokeILL.objValue;
    }

    public final void h(View view2, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2, cVar) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            zp4 layoutMode = this.d.getLayoutMode();
            boolean z = true;
            if (skinType != 1) {
                z = false;
            }
            layoutMode.l(z);
            this.d.getLayoutMode().k(view2);
            if (cVar != null) {
                TextView textView = cVar.m;
                if (textView != null) {
                    SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0109);
                    SkinManager.setBackgroundColor(cVar.m, R.color.CAM_X0205);
                }
                ImageView imageView = cVar.j;
                if (imageView != null) {
                    SkinManager.setImageResource(imageView, R.color.CAM_X0204);
                }
                NewMyFansUserLikeButton newMyFansUserLikeButton = cVar.h;
                if (newMyFansUserLikeButton != null) {
                    newMyFansUserLikeButton.r(skinType);
                }
            }
        }
    }
}

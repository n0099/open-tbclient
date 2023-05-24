package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.text.Layout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.myAttentionAndFans.NewMyFansUserLikeButton;
import com.baidu.tieba.myAttentionAndFans.PersonListActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class cs8 extends as8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PersonListActivity d;
    public boolean e;
    public boolean f;
    public boolean g;
    public int h;
    public String i;
    public HashSet<Integer> j;
    public HashSet<Long> k;
    public View.OnClickListener l;
    public View.OnClickListener m;
    public View.OnClickListener n;
    public View.OnClickListener o;
    public NewMyFansUserLikeButton.b p;

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return 3;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes5.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;
        public final /* synthetic */ cs8 b;

        public a(cs8 cs8Var, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cs8Var, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cs8Var;
            this.a = dVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Layout layout;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (layout = this.a.d.getLayout()) != null) {
                if (layout.getEllipsisCount(layout.getLineCount() - 1) > 0) {
                    this.a.d.setCompoundDrawablePadding(0);
                } else {
                    this.a.d.setCompoundDrawablePadding(ri.g(this.b.d, R.dimen.tbds10));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements NewMyFansUserLikeButton.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cs8 a;

        public b(cs8 cs8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cs8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cs8Var;
        }

        @Override // com.baidu.tieba.myAttentionAndFans.NewMyFansUserLikeButton.b
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.d != null) {
                this.a.d.g2();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public c(cs8 cs8Var, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cs8Var, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b.playAnimation();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ViewGroup a;
        public TBLottieAnimationView b;
        public ClickableHeaderImageView c;
        public EMTextView d;
        public View e;
        public EMTextView f;
        public TextView g;
        public LinearLayout h;
        public LinearLayout i;
        public NewMyFansUserLikeButton j;
        public q85 k;
        public ProgressBar l;
        public TextView m;
        public TextView n;
        public LinearLayout o;
        public EMTextView p;

        public d(cs8 cs8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cs8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ d(cs8 cs8Var, a aVar) {
            this(cs8Var);
        }
    }

    public cs8(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnClickListener onClickListener4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {personListActivity, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), onClickListener, onClickListener2, onClickListener3, onClickListener4};
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
        this.e = false;
        this.f = false;
        this.g = true;
        this.h = 0;
        this.j = new HashSet<>();
        this.k = new HashSet<>();
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = new b(this);
        this.d = personListActivity;
        this.f = z;
        this.g = z2;
        this.h = i;
        this.l = onClickListener2;
        this.m = onClickListener3;
        this.n = onClickListener;
        this.o = onClickListener4;
        this.a = new ArrayList<>();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            ArrayList<UserData> arrayList = this.a;
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
            ArrayList<UserData> arrayList = this.a;
            if (arrayList != null && i < arrayList.size()) {
                return i;
            }
            return -1L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            if (this.e) {
                return false;
            }
            return super.isEnabled(i);
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.tieba.as8
    public void a(s05 s05Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, s05Var) != null) || s05Var == null) {
            return;
        }
        this.i = s05Var.i;
        ArrayList arrayList = new ArrayList();
        if (this.a.isEmpty() && !ListUtils.isEmpty(s05Var.a())) {
            Iterator<UserData> it = s05Var.a().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId())) {
                    this.k.add(Long.valueOf(pg.g(next.getUserId(), 0L)));
                }
            }
            arrayList.addAll(s05Var.a());
            UserData userData = new UserData();
            userData.mAttentionType = 0;
            arrayList.add(userData);
        }
        arrayList.addAll(i(s05Var.b()));
        this.a.addAll(arrayList);
        if (!this.a.isEmpty() && this.a.get(0).mAttentionType != 3) {
            UserData userData2 = new UserData();
            userData2.mAttentionType = 3;
            this.a.add(0, userData2);
        }
    }

    @Override // com.baidu.tieba.as8
    public boolean d(long j) {
        InterceptResult invokeJ;
        ArrayList<UserData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            boolean z = false;
            if (j != 0 && (arrayList = this.a) != null && arrayList.size() != 0) {
                Iterator<UserData> it = this.a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    UserData next = it.next();
                    if (next != null && next.getUserIdLong() == j) {
                        z = true;
                        if (next.getLikeStatus() == 2) {
                            next.setLikeStatus(1);
                        }
                    }
                }
            }
            return z;
        }
        return invokeJ.booleanValue;
    }

    public final ArrayList<UserData> i(ArrayList<UserData> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, arrayList)) == null) {
            if (!ListUtils.isEmpty(arrayList) && !this.k.isEmpty()) {
                ArrayList<UserData> arrayList2 = new ArrayList<>();
                Iterator<UserData> it = arrayList.iterator();
                while (it.hasNext()) {
                    UserData next = it.next();
                    if (next != null && !StringUtils.isNull(next.getUserId()) && !this.k.contains(Long.valueOf(pg.g(next.getUserId(), 0L)))) {
                        arrayList2.add(next);
                    }
                }
                return arrayList2;
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.e) {
                return 1;
            }
            int i = 0;
            ArrayList<UserData> arrayList = this.a;
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

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            if (this.e) {
                return 0;
            }
            ArrayList<UserData> arrayList = this.a;
            if (arrayList != null && i < arrayList.size()) {
                if (this.a.get(i).mAttentionType == 0) {
                    return 2;
                }
                if (this.a.get(i).mAttentionType != 3) {
                    return 0;
                }
                return 3;
            }
            return 1;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        d dVar;
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i, view2, viewGroup)) == null) {
            if (this.a == null) {
                return view2;
            }
            if (view2 != null && (view2.getTag() instanceof d)) {
                dVar = (d) view2.getTag();
                j((UserData) ListUtils.getItem(this.a, i), dVar, i);
            } else {
                dVar = new d(this, null);
                if (getItemViewType(i) == 0) {
                    view2 = LayoutInflater.from(this.d.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d07a3, (ViewGroup) null);
                    ViewGroup viewGroup2 = (ViewGroup) view2.findViewById(R.id.item_view);
                    dVar.a = viewGroup2;
                    viewGroup2.setOnClickListener(this.n);
                    ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) view2.findViewById(R.id.obfuscated_res_0x7f091ba6);
                    dVar.c = clickableHeaderImageView;
                    clickableHeaderImageView.setRadius(ri.g(this.d.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070411));
                    dVar.c.setAutoChangeStyle(true);
                    dVar.c.setGodIconWidth(R.dimen.tbds36);
                    dVar.c.setOnClickListener(this.o);
                    dVar.c.setTag(Integer.valueOf(i));
                    TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) view2.findViewById(R.id.user_living_lottie);
                    dVar.b = tBLottieAnimationView;
                    SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
                    j((UserData) ListUtils.getItem(this.a, i), dVar, i);
                    dVar.h = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0910d6);
                    dVar.i = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0922f9);
                    EMTextView eMTextView = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f0917fa);
                    dVar.d = eMTextView;
                    eMTextView.getViewTreeObserver().addOnGlobalLayoutListener(new a(this, dVar));
                    View a2 = wt4.b().a(this.d.getPageContext().getPageActivity(), 5);
                    dVar.e = a2;
                    if (a2 != null) {
                        a2.setVisibility(8);
                        dVar.i.addView(dVar.e, 1);
                    }
                    dVar.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0902db);
                    dVar.f = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f09112c);
                    TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09069a);
                    dVar.g = textView;
                    textView.setOnClickListener(this.l);
                    NewMyFansUserLikeButton newMyFansUserLikeButton = (NewMyFansUserLikeButton) view2.findViewById(R.id.obfuscated_res_0x7f0902e9);
                    dVar.j = newMyFansUserLikeButton;
                    newMyFansUserLikeButton.setContext(this.d.getPageContext());
                    dVar.j.setCallback(this.p);
                    dVar.k = new q85(this.d.getPageContext(), dVar.j);
                    dVar.l = null;
                    dVar.n = null;
                    dVar.o = null;
                } else if (getItemViewType(i) == 2) {
                    view2 = LayoutInflater.from(this.d.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d07a5, (ViewGroup) null);
                    dVar.n = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091b5c);
                    dVar.o = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09188e);
                } else if (getItemViewType(i) == 3) {
                    view2 = LayoutInflater.from(this.d.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d012d, (ViewGroup) null);
                    dVar.p = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f0902eb);
                } else {
                    view2 = LayoutInflater.from(this.d.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    dVar.d = (EMTextView) view2.findViewById(R.id.pb_more_text);
                    view2.setOnClickListener(this.m);
                    dVar.l = (ProgressBar) view2.findViewById(R.id.obfuscated_res_0x7f091c9b);
                    dVar.n = null;
                    dVar.o = null;
                }
                view2.setTag(dVar);
            }
            NewMyFansUserLikeButton newMyFansUserLikeButton2 = dVar.j;
            if (newMyFansUserLikeButton2 != null) {
                newMyFansUserLikeButton2.setTag(Integer.valueOf(i));
            }
            ClickableHeaderImageView clickableHeaderImageView2 = dVar.c;
            if (clickableHeaderImageView2 != null) {
                clickableHeaderImageView2.setTag(Integer.valueOf(i));
            }
            if (getItemViewType(i) == 0) {
                if (this.e) {
                    dVar.h.setVisibility(8);
                    dVar.g.setVisibility(8);
                    dVar.m.setVisibility(0);
                    if (this.f) {
                        if (this.g) {
                            dVar.m.setText(R.string.obfuscated_res_0x7f0f0e1a);
                        } else {
                            int i2 = this.h;
                            if (i2 == 2) {
                                dVar.m.setText(R.string.obfuscated_res_0x7f0f096d);
                            } else if (i2 == 1) {
                                dVar.m.setText(R.string.obfuscated_res_0x7f0f0975);
                            } else {
                                dVar.m.setText(R.string.obfuscated_res_0x7f0f0dd1);
                            }
                        }
                    } else if (this.g) {
                        dVar.m.setText(R.string.obfuscated_res_0x7f0f0e1d);
                    } else {
                        int i3 = this.h;
                        if (i3 == 2) {
                            dVar.m.setText(R.string.obfuscated_res_0x7f0f096f);
                        } else if (i3 == 1) {
                            dVar.m.setText(R.string.obfuscated_res_0x7f0f0976);
                        } else {
                            dVar.m.setText(R.string.obfuscated_res_0x7f0f0de0);
                        }
                    }
                } else {
                    UserData userData = (UserData) ListUtils.getItem(this.a, i);
                    if (userData == null) {
                        return null;
                    }
                    dVar.a.setTag(Integer.valueOf(i));
                    dVar.g.setVisibility(0);
                    dVar.m.setVisibility(8);
                    UtilHelper.showHeadImageViewBigV(dVar.c, userData, 0);
                    dVar.d.setText(UtilHelper.getUserName(userData));
                    dVar.c.setPlaceHolder(1);
                    dVar.c.N(userData.getAvater(), 12, false);
                    if (dVar.e != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            dVar.e.setVisibility(8);
                        } else {
                            dVar.e.setVisibility(0);
                            vt4 vt4Var = new vt4();
                            vt4Var.a = userData.getAlaUserData();
                            vt4Var.b = 5;
                            dVar.e.setTag(vt4Var);
                        }
                    }
                    if (qi.isEmpty(userData.getIntro())) {
                        dVar.f.setVisibility(8);
                    } else {
                        dVar.f.setVisibility(0);
                        EMTextView eMTextView2 = dVar.f;
                        if (TextUtils.isEmpty(userData.getFollowFrom()) && this.g) {
                            str = userData.getIntro();
                        } else {
                            str = userData.getFollowFrom() + " " + userData.getIntro();
                        }
                        eMTextView2.setText(str);
                    }
                    dVar.g.setTag(Integer.valueOf(i));
                    String userId = userData.getUserId();
                    dVar.j.setStatsParams(1, userId);
                    if (userData.getHave_attention() > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    userData.setIsLike(z);
                    dVar.k.n(userData);
                    if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                        dVar.j.setVisibility(8);
                        dVar.g.setVisibility(8);
                    } else {
                        dVar.g.setVisibility(8);
                        dVar.j.setVisibility(0);
                    }
                }
                dVar.l = null;
            } else if (getItemViewType(i) == 3) {
                if (!this.g || TextUtils.isEmpty(this.i)) {
                    dVar.p.setVisibility(8);
                }
                dVar.p.setText(this.i);
            } else if (getItemViewType(i) == 2) {
                dVar.n.setText(this.i);
            } else if (getItemViewType(i) != 2 || getItemViewType(i) != 3) {
                dVar.d.setText(this.d.getPageContext().getString(R.string.obfuscated_res_0x7f0f0b95));
                dVar.l.setVisibility(0);
            }
            h(view2, dVar);
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    public final void h(View view2, d dVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2, dVar) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            hx4 layoutMode = this.d.getLayoutMode();
            if (skinType == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.l(z);
            this.d.getLayoutMode().k(view2);
            if (dVar != null) {
                TextView textView = dVar.g;
                if (textView != null) {
                    SkinManager.setViewTextColor(textView, R.color.btn_forum_focus_color, 1);
                    SkinManager.setBackgroundResource(dVar.g, R.drawable.btn_focus_border_bg);
                    dVar.g.setEnabled(true);
                }
                LinearLayout linearLayout = dVar.o;
                if (linearLayout != null && dVar.n != null) {
                    SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0205);
                    SkinManager.setViewTextColor(dVar.n, (int) R.color.CAM_X0110);
                }
                EMTextView eMTextView = dVar.p;
                if (eMTextView != null) {
                    SkinManager.setViewTextColor(eMTextView, (int) R.color.CAM_X0105);
                }
                NewMyFansUserLikeButton newMyFansUserLikeButton = dVar.j;
                if (newMyFansUserLikeButton != null) {
                    newMyFansUserLikeButton.onChangeSkinType(skinType);
                }
                TBLottieAnimationView tBLottieAnimationView = dVar.b;
                if (tBLottieAnimationView != null) {
                    SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
                }
            }
        }
    }

    public final void j(UserData userData, d dVar, int i) {
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048587, this, userData, dVar, i) == null) && userData != null && dVar != null) {
            if (userData.getAlaUserData() != null && userData.getAlaUserData().live_status == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                dVar.b.setSpeed(0.8f);
                dVar.b.setVisibility(0);
                dVar.b.loop(true);
                dVar.b.post(new c(this, dVar));
                if (!this.j.contains(Integer.valueOf(i))) {
                    if (!this.g) {
                        str = "c14284";
                    } else {
                        str = "c14285";
                    }
                    ds8.a(str, userData);
                    this.j.add(Integer.valueOf(i));
                    return;
                }
                return;
            }
            TBLottieAnimationView tBLottieAnimationView = dVar.b;
            if (tBLottieAnimationView != null) {
                tBLottieAnimationView.setVisibility(4);
                dVar.b.cancelAnimation();
            }
        }
    }
}

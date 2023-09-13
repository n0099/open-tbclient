package com.baidu.tieba.faceshop;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ue9;
import com.baidu.tieba.ve9;
import com.baidu.tieba.wv4;
import com.baidu.tieba.xm5;
import com.baidu.tieba.xv4;
import com.baidu.tieba.yv4;
import com.baidu.tieba.z47;
import com.baidu.tieba.zv4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class UserAlbumActivity extends BaseFragmentActivity implements AbsListView.OnScrollListener, ue9, PopupWindow.OnDismissListener, z47.d {
    public static /* synthetic */ Interceptable $ic = null;
    public static int p = 10;
    public transient /* synthetic */ FieldHolder $fh;
    public GridView a;
    public NoDataView b;
    public NavigationBar c;
    public TextView d;
    public TextView e;
    public View f;
    public z47 g;
    public ve9 h;
    public xv4 i;
    public List<ImageFileInfo> j;
    public List<ImageFileInfo> k;
    public LinkedHashMap<String, ImageFileInfo> l;
    public String m;
    public int n;
    public wv4 o;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(4692054, "Lcom/baidu/tieba/faceshop/UserAlbumActivity;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(4692054, "Lcom/baidu/tieba/faceshop/UserAlbumActivity;");
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048588, this, absListView, i, i2, i3) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserAlbumActivity a;

        /* renamed from: com.baidu.tieba.faceshop.UserAlbumActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0282a implements yv4 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            @Override // com.baidu.tieba.yv4
            public void onPreLoad() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }

            public C0282a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // com.baidu.tieba.yv4
            public void a(List<wv4> list) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, list) == null) && !ListUtils.isEmpty(list)) {
                    if (this.a.a.o != null) {
                        list.add(0, this.a.a.o);
                    }
                    if (!this.a.a.g.isShowing()) {
                        this.a.a.g.i(list, this.a.a.m);
                        this.a.a.g.l(this.a.a.c);
                    }
                }
            }
        }

        public a(UserAlbumActivity userAlbumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userAlbumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = userAlbumActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                Drawable drawable = SkinManager.getDrawable(R.drawable.icon_emotion_albumarrow_up);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.a.d.setCompoundDrawables(null, null, drawable, null);
                this.a.i.g(new C0282a(this));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserAlbumActivity a;

        public b(UserAlbumActivity userAlbumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userAlbumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = userAlbumActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.finish();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserAlbumActivity a;

        public c(UserAlbumActivity userAlbumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userAlbumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = userAlbumActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                UserAlbumActivity userAlbumActivity = this.a;
                userAlbumActivity.l = userAlbumActivity.h.f();
                ArrayList arrayList = new ArrayList();
                for (Map.Entry entry : this.a.l.entrySet()) {
                    arrayList.add(entry.getValue());
                }
                Intent intent = new Intent();
                intent.putExtra("selected_album_list", arrayList);
                this.a.setResult(-1, intent);
                this.a.finish();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements zv4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserAlbumActivity a;

        @Override // com.baidu.tieba.zv4
        public void onPreLoad() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public d(UserAlbumActivity userAlbumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userAlbumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = userAlbumActivity;
        }

        @Override // com.baidu.tieba.zv4
        public void a(List<wv4> list, List<ImageFileInfo> list2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, list, list2, str) == null) {
                if (!ListUtils.isEmpty(list2)) {
                    this.a.a.setVisibility(0);
                    this.a.b.setVisibility(8);
                    this.a.k.clear();
                    this.a.k.addAll(list2);
                    this.a.j.addAll(list2);
                    this.a.o = new wv4();
                    this.a.o.h(wv4.f);
                    wv4 wv4Var = this.a.o;
                    wv4Var.i(list2.size() + "");
                    this.a.o.l(this.a.getPageContext().getString(R.string.album_all));
                    this.a.o.k(list2.get(0));
                    this.a.h.notifyDataSetChanged();
                    return;
                }
                this.a.a.setVisibility(8);
                this.a.b.setVisibility(0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements xm5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserAlbumActivity a;

        public e(UserAlbumActivity userAlbumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userAlbumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = userAlbumActivity;
        }

        @Override // com.baidu.tieba.xm5
        public void a(BdImage bdImage, String str, boolean z) {
            TbImageView tbImageView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLZ(1048576, this, bdImage, str, z) == null) && (tbImageView = (TbImageView) this.a.a.findViewWithTag(str)) != null && bdImage != null) {
                tbImageView.invalidate();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements zv4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserAlbumActivity a;

        @Override // com.baidu.tieba.zv4
        public void onPreLoad() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public f(UserAlbumActivity userAlbumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userAlbumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = userAlbumActivity;
        }

        @Override // com.baidu.tieba.zv4
        public void a(List<wv4> list, List<ImageFileInfo> list2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, list, list2, str) == null) {
                this.a.j.clear();
                if (!ListUtils.isEmpty(list2)) {
                    this.a.j.addAll(list2);
                }
                this.a.h.notifyDataSetChanged();
            }
        }
    }

    public UserAlbumActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.l = new LinkedHashMap<>();
        this.m = wv4.f;
    }

    public final void L1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            String string = getPageContext().getString(R.string.obfuscated_res_0x7f0f00e7);
            if (this.n > 0) {
                TextView textView = this.e;
                textView.setText("(" + this.n + ") " + string);
                return;
            }
            this.e.setText(string);
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            ve9 ve9Var = this.h;
            if (ve9Var != null) {
                this.l = ve9Var.f();
            }
            Drawable drawable = SkinManager.getDrawable(R.drawable.icon_emotion_albumarrow_down);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.d.setCompoundDrawables(null, null, drawable, null);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            BDLayoutMode layoutMode = getLayoutMode();
            if (i == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.setNightMode(z);
            this.c.onChangeSkinType(getPageContext(), i);
        }
    }

    @Override // com.baidu.tieba.z47.d
    public void b(int i, wv4 wv4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048581, this, i, wv4Var) == null) && wv4Var != null) {
            this.m = wv4Var.b();
            this.c.setCenterTextTitle(wv4Var.g());
            this.i.i(wv4Var.b(), new f(this));
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, absListView, i) == null) {
            if (i == 2) {
                this.h.l(true);
            } else if (this.h.i()) {
                this.h.l(false);
                K1();
            }
        }
    }

    @Override // com.baidu.tieba.ue9
    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.n++;
            L1();
        }
    }

    public final void J1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.i.i(wv4.f, new d(this));
        }
    }

    @Override // com.baidu.tieba.ue9
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            int i = this.n;
            if (i > 0) {
                this.n = i - 1;
            }
            L1();
        }
    }

    @Override // com.baidu.tieba.ue9
    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.n < p) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void I1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.i = new xv4(getActivity());
            ve9 ve9Var = new ve9(this, this.j);
            this.h = ve9Var;
            ve9Var.k(getPageContext().getString(R.string.obfuscated_res_0x7f0f03cf));
            this.h.j(this);
            this.a.setAdapter((ListAdapter) this.h);
            this.a.setOnScrollListener(this);
            z47 z47Var = new z47(getPageContext().getPageActivity());
            this.g = z47Var;
            z47Var.setOnDismissListener(this);
            this.g.j(this);
        }
    }

    public final void K1() {
        ve9 ve9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (ve9Var = this.h) != null && ve9Var.g() != null) {
            int childCount = this.a.getChildCount();
            int firstVisiblePosition = this.a.getFirstVisiblePosition();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.a.getChildAt(i);
                if (childAt != null) {
                    TbImageView tbImageView = (TbImageView) childAt.findViewById(R.id.obfuscated_res_0x7f09108c);
                    ImageFileInfo item = this.h.getItem(firstVisiblePosition + i);
                    if (item != null && tbImageView != null) {
                        tbImageView.setTag(item.toCachedKey(false));
                        this.h.g().e(item, new e(this), false, false);
                    }
                }
            }
        }
    }

    public final void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            NoDataView a2 = NoDataViewFactory.a(getPageContext().getPageActivity(), this.f, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, BdUtilHelper.getDimens(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0703c0)), NoDataViewFactory.e.c(getPageContext().getPageActivity().getText(R.string.obfuscated_res_0x7f0f0707).toString()), null);
            this.b = a2;
            a2.f(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.b.setVisibility(8);
            this.a = (GridView) this.f.findViewById(R.id.obfuscated_res_0x7f090e8a);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
            this.c = navigationBar;
            navigationBar.setCenterTextTitle(getPageContext().getString(R.string.album_all));
            TextView textView = this.c.mCenterText;
            this.d = textView;
            textView.setOnClickListener(new a(this));
            this.d.setCompoundDrawablePadding(BdUtilHelper.getDimens(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070420));
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0302);
            Drawable drawable = SkinManager.getDrawable(R.drawable.icon_emotion_albumarrow_down);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.d.setCompoundDrawables(null, null, drawable, null);
            this.c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new b(this)).setPadding(BdUtilHelper.getDimens(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701e8), 0, 0, 0);
            if (this.c.getBackImageView() != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.c.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            TextView addTextButton = this.c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.obfuscated_res_0x7f0f00e7), new c(this));
            this.e = addTextButton;
            addTextButton.setPadding(0, 0, BdUtilHelper.getDimens(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f07020f), 0);
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0302);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            super.onCreate(bundle);
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d09de, (ViewGroup) null);
            this.f = inflate;
            setContentView(inflate);
            SkinManager.setBackgroundResource(this.f, R.color.CAM_X0201);
            initView();
            I1();
            J1();
        }
    }
}

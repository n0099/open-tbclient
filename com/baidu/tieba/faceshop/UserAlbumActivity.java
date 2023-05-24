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
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.tieba.au4;
import com.baidu.tieba.bu4;
import com.baidu.tieba.cn;
import com.baidu.tieba.cu4;
import com.baidu.tieba.cx6;
import com.baidu.tieba.du4;
import com.baidu.tieba.fu8;
import com.baidu.tieba.gu8;
import com.baidu.tieba.hx4;
import com.baidu.tieba.ri;
import com.baidu.tieba.th5;
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
public class UserAlbumActivity extends BaseFragmentActivity implements AbsListView.OnScrollListener, fu8, PopupWindow.OnDismissListener, cx6.d {
    public static /* synthetic */ Interceptable $ic = null;
    public static int p = 10;
    public transient /* synthetic */ FieldHolder $fh;
    public GridView a;
    public NoDataView b;
    public NavigationBar c;
    public TextView d;
    public TextView e;
    public View f;
    public cx6 g;
    public gu8 h;
    public bu4 i;
    public List<ImageFileInfo> j;
    public List<ImageFileInfo> k;
    public LinkedHashMap<String, ImageFileInfo> l;
    public String m;
    public int n;
    public au4 o;

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
        if (interceptable == null || interceptable.invokeLIII(1048587, this, absListView, i, i2, i3) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserAlbumActivity a;

        /* renamed from: com.baidu.tieba.faceshop.UserAlbumActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0286a implements cu4 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            @Override // com.baidu.tieba.cu4
            public void onPreLoad() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }

            public C0286a(a aVar) {
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

            @Override // com.baidu.tieba.cu4
            public void a(List<au4> list) {
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
                this.a.i.g(new C0286a(this));
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
    public class d implements du4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserAlbumActivity a;

        @Override // com.baidu.tieba.du4
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

        @Override // com.baidu.tieba.du4
        public void a(List<au4> list, List<ImageFileInfo> list2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, list, list2, str) == null) {
                if (!ListUtils.isEmpty(list2)) {
                    this.a.a.setVisibility(0);
                    this.a.b.setVisibility(8);
                    this.a.k.clear();
                    this.a.k.addAll(list2);
                    this.a.j.addAll(list2);
                    this.a.o = new au4();
                    this.a.o.h(au4.f);
                    au4 au4Var = this.a.o;
                    au4Var.i(list2.size() + "");
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
    public class e implements th5 {
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

        @Override // com.baidu.tieba.th5
        public void a(cn cnVar, String str, boolean z) {
            TbImageView tbImageView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLZ(1048576, this, cnVar, str, z) == null) && (tbImageView = (TbImageView) this.a.a.findViewWithTag(str)) != null && cnVar != null) {
                tbImageView.invalidate();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements du4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserAlbumActivity a;

        @Override // com.baidu.tieba.du4
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

        @Override // com.baidu.tieba.du4
        public void a(List<au4> list, List<ImageFileInfo> list2, String str) {
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
        this.m = au4.f;
    }

    public final void M1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            String string = getPageContext().getString(R.string.obfuscated_res_0x7f0f00e5);
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
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            gu8 gu8Var = this.h;
            if (gu8Var != null) {
                this.l = gu8Var.f();
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
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            hx4 layoutMode = getLayoutMode();
            if (i == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.l(z);
            this.c.onChangeSkinType(getPageContext(), i);
        }
    }

    @Override // com.baidu.tieba.cx6.d
    public void a(int i, au4 au4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048581, this, i, au4Var) == null) && au4Var != null) {
            this.m = au4Var.b();
            this.c.setCenterTextTitle(au4Var.g());
            this.i.i(au4Var.b(), new f(this));
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048588, this, absListView, i) == null) {
            if (i == 2) {
                this.h.l(true);
            } else if (this.h.i()) {
                this.h.l(false);
                L1();
            }
        }
    }

    @Override // com.baidu.tieba.fu8
    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.n++;
            M1();
        }
    }

    public final void K1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.i.i(au4.f, new d(this));
        }
    }

    @Override // com.baidu.tieba.fu8
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            int i = this.n;
            if (i > 0) {
                this.n = i - 1;
            }
            M1();
        }
    }

    @Override // com.baidu.tieba.fu8
    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.n < p) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void J1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.i = new bu4(getActivity());
            gu8 gu8Var = new gu8(this, this.j);
            this.h = gu8Var;
            gu8Var.k(getPageContext().getString(R.string.obfuscated_res_0x7f0f03c2));
            this.h.j(this);
            this.a.setAdapter((ListAdapter) this.h);
            this.a.setOnScrollListener(this);
            cx6 cx6Var = new cx6(getPageContext().getPageActivity());
            this.g = cx6Var;
            cx6Var.setOnDismissListener(this);
            this.g.j(this);
        }
    }

    public final void L1() {
        gu8 gu8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (gu8Var = this.h) != null && gu8Var.g() != null) {
            int childCount = this.a.getChildCount();
            int firstVisiblePosition = this.a.getFirstVisiblePosition();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.a.getChildAt(i);
                if (childAt != null) {
                    TbImageView tbImageView = (TbImageView) childAt.findViewById(R.id.obfuscated_res_0x7f091034);
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
            NoDataView a2 = NoDataViewFactory.a(getPageContext().getPageActivity(), this.f, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, ri.g(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0703ab)), NoDataViewFactory.e.c(getPageContext().getPageActivity().getText(R.string.obfuscated_res_0x7f0f06b9).toString()), null);
            this.b = a2;
            a2.f(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.b.setVisibility(8);
            this.a = (GridView) this.f.findViewById(R.id.obfuscated_res_0x7f090e44);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
            this.c = navigationBar;
            navigationBar.setCenterTextTitle(getPageContext().getString(R.string.album_all));
            TextView textView = this.c.mCenterText;
            this.d = textView;
            textView.setOnClickListener(new a(this));
            this.d.setCompoundDrawablePadding(ri.g(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f07040b));
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0302);
            Drawable drawable = SkinManager.getDrawable(R.drawable.icon_emotion_albumarrow_down);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.d.setCompoundDrawables(null, null, drawable, null);
            this.c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new b(this)).setPadding(ri.g(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701e8), 0, 0, 0);
            if (this.c.getBackImageView() != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.c.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            TextView addTextButton = this.c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.obfuscated_res_0x7f0f00e5), new c(this));
            this.e = addTextButton;
            addTextButton.setPadding(0, 0, ri.g(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f07020f), 0);
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0302);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onCreate(bundle);
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0973, (ViewGroup) null);
            this.f = inflate;
            setContentView(inflate);
            SkinManager.setBackgroundResource(this.f, R.color.CAM_X0201);
            initView();
            J1();
            K1();
        }
    }
}

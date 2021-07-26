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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.q0.c2.g.g;
import d.a.q0.p0.s;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class UserAlbumActivity extends BaseFragmentActivity implements AbsListView.OnScrollListener, d.a.q0.c2.g.f, PopupWindow.OnDismissListener, s.d {
    public static /* synthetic */ Interceptable $ic = null;
    public static int MAX_SELECT_NUM = 10;
    public transient /* synthetic */ FieldHolder $fh;
    public g mAdapter;
    public TextView mAddAlbumTv;
    public d.a.p0.f.a mAddData;
    public String mAlbumId;
    public List<ImageFileInfo> mAllImageList;
    public LinkedHashMap<String, ImageFileInfo> mChooseList;
    public int mChoosedNum;
    public GridView mGridView;
    public List<ImageFileInfo> mImageList;
    public d.a.p0.f.b mLoadModel;
    public NavigationBar mNavigationBar;
    public NoDataView mNoDataView;
    public TextView mSelectAlbumTv;
    public s mUserCollectAlbumListPopupWindow;
    public View rootView;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserAlbumActivity f15060e;

        /* renamed from: com.baidu.tieba.faceshop.UserAlbumActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0195a implements d.a.p0.f.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f15061a;

            public C0195a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f15061a = aVar;
            }

            @Override // d.a.p0.f.c
            public void a(List<d.a.p0.f.a> list) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || ListUtils.isEmpty(list)) {
                    return;
                }
                if (this.f15061a.f15060e.mAddData != null) {
                    list.add(0, this.f15061a.f15060e.mAddData);
                }
                if (this.f15061a.f15060e.mUserCollectAlbumListPopupWindow.isShowing()) {
                    return;
                }
                this.f15061a.f15060e.mUserCollectAlbumListPopupWindow.i(list, this.f15061a.f15060e.mAlbumId);
                this.f15061a.f15060e.mUserCollectAlbumListPopupWindow.l(this.f15061a.f15060e.mNavigationBar);
            }

            @Override // d.a.p0.f.c
            public void onPreLoad() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15060e = userAlbumActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                Drawable drawable = SkinManager.getDrawable(R.drawable.icon_emotion_albumarrow_up);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.f15060e.mSelectAlbumTv.setCompoundDrawables(null, null, drawable, null);
                this.f15060e.mLoadModel.g(new C0195a(this));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserAlbumActivity f15062e;

        public b(UserAlbumActivity userAlbumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userAlbumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15062e = userAlbumActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f15062e.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserAlbumActivity f15063e;

        public c(UserAlbumActivity userAlbumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userAlbumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15063e = userAlbumActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                UserAlbumActivity userAlbumActivity = this.f15063e;
                userAlbumActivity.mChooseList = userAlbumActivity.mAdapter.f();
                ArrayList arrayList = new ArrayList();
                for (Map.Entry entry : this.f15063e.mChooseList.entrySet()) {
                    arrayList.add(entry.getValue());
                }
                Intent intent = new Intent();
                intent.putExtra("selected_album_list", arrayList);
                this.f15063e.setResult(-1, intent);
                this.f15063e.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements d.a.p0.f.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UserAlbumActivity f15064a;

        public d(UserAlbumActivity userAlbumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userAlbumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15064a = userAlbumActivity;
        }

        @Override // d.a.p0.f.d
        public void a(List<d.a.p0.f.a> list, List<ImageFileInfo> list2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, list, list2, str) == null) {
                if (!ListUtils.isEmpty(list2)) {
                    this.f15064a.mGridView.setVisibility(0);
                    this.f15064a.mNoDataView.setVisibility(8);
                    this.f15064a.mAllImageList.clear();
                    this.f15064a.mAllImageList.addAll(list2);
                    this.f15064a.mImageList.addAll(list2);
                    this.f15064a.mAddData = new d.a.p0.f.a();
                    this.f15064a.mAddData.h(d.a.p0.f.a.f52546f);
                    d.a.p0.f.a aVar = this.f15064a.mAddData;
                    aVar.i(list2.size() + "");
                    this.f15064a.mAddData.l(this.f15064a.getPageContext().getString(R.string.album_all));
                    this.f15064a.mAddData.k(list2.get(0));
                    this.f15064a.mAdapter.notifyDataSetChanged();
                    return;
                }
                this.f15064a.mGridView.setVisibility(8);
                this.f15064a.mNoDataView.setVisibility(0);
            }
        }

        @Override // d.a.p0.f.d
        public void onPreLoad() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements d.a.p0.b0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserAlbumActivity f15065e;

        public e(UserAlbumActivity userAlbumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userAlbumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15065e = userAlbumActivity;
        }

        @Override // d.a.p0.b0.b
        public void a(d.a.d.k.d.a aVar, String str, boolean z) {
            TbImageView tbImageView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, aVar, str, z) == null) || (tbImageView = (TbImageView) this.f15065e.mGridView.findViewWithTag(str)) == null || aVar == null) {
                return;
            }
            tbImageView.invalidate();
        }
    }

    /* loaded from: classes4.dex */
    public class f implements d.a.p0.f.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UserAlbumActivity f15066a;

        public f(UserAlbumActivity userAlbumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userAlbumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15066a = userAlbumActivity;
        }

        @Override // d.a.p0.f.d
        public void a(List<d.a.p0.f.a> list, List<ImageFileInfo> list2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, list, list2, str) == null) {
                this.f15066a.mImageList.clear();
                if (!ListUtils.isEmpty(list2)) {
                    this.f15066a.mImageList.addAll(list2);
                }
                this.f15066a.mAdapter.notifyDataSetChanged();
            }
        }

        @Override // d.a.p0.f.d
        public void onPreLoad() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

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

    public UserAlbumActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mImageList = new ArrayList();
        this.mAllImageList = new ArrayList();
        this.mChooseList = new LinkedHashMap<>();
        this.mAlbumId = d.a.p0.f.a.f52546f;
    }

    private void initSetting() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            this.mLoadModel = new d.a.p0.f.b(getActivity());
            g gVar = new g(this, this.mImageList);
            this.mAdapter = gVar;
            gVar.k(getPageContext().getString(R.string.can_select_only_ten));
            this.mAdapter.j(this);
            this.mGridView.setAdapter((ListAdapter) this.mAdapter);
            this.mGridView.setOnScrollListener(this);
            s sVar = new s(getPageContext().getPageActivity());
            this.mUserCollectAlbumListPopupWindow = sVar;
            sVar.setOnDismissListener(this);
            this.mUserCollectAlbumListPopupWindow.j(this);
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            NoDataView a2 = NoDataViewFactory.a(getPageContext().getPageActivity(), this.rootView, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(getPageContext().getPageActivity(), R.dimen.ds320)), NoDataViewFactory.e.c(getPageContext().getPageActivity().getText(R.string.face_group_no_picture).toString()), null);
            this.mNoDataView = a2;
            a2.f(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setVisibility(8);
            this.mGridView = (GridView) this.rootView.findViewById(R.id.grid_view);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
            this.mNavigationBar = navigationBar;
            navigationBar.setCenterTextTitle(getPageContext().getString(R.string.album_all));
            TextView textView = this.mNavigationBar.mCenterText;
            this.mSelectAlbumTv = textView;
            textView.setOnClickListener(new a(this));
            this.mSelectAlbumTv.setCompoundDrawablePadding(l.g(getPageContext().getPageActivity(), R.dimen.ds8));
            SkinManager.setViewTextColor(this.mSelectAlbumTv, R.color.CAM_X0302);
            Drawable drawable = SkinManager.getDrawable(R.drawable.icon_emotion_albumarrow_down);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.mSelectAlbumTv.setCompoundDrawables(null, null, drawable, null);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new b(this)).setPadding(l.g(getPageContext().getPageActivity(), R.dimen.ds24), 0, 0, 0);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            TextView addTextButton = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.add), new c(this));
            this.mAddAlbumTv = addTextButton;
            addTextButton.setPadding(0, 0, l.g(getPageContext().getPageActivity(), R.dimen.ds34), 0);
            SkinManager.setViewTextColor(this.mAddAlbumTv, R.color.CAM_X0302);
        }
    }

    private void loadAlbumData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            this.mLoadModel.i(d.a.p0.f.a.f52546f, new d(this));
        }
    }

    private void refreshImages() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65555, this) == null) || (gVar = this.mAdapter) == null || gVar.g() == null) {
            return;
        }
        int childCount = this.mGridView.getChildCount();
        int firstVisiblePosition = this.mGridView.getFirstVisiblePosition();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.mGridView.getChildAt(i2);
            if (childAt != null) {
                TbImageView tbImageView = (TbImageView) childAt.findViewById(R.id.image);
                ImageFileInfo item = this.mAdapter.getItem(firstVisiblePosition + i2);
                if (item != null && tbImageView != null) {
                    tbImageView.setTag(item.toCachedKey(false));
                    this.mAdapter.g().e(item, new e(this), false, false);
                }
            }
        }
    }

    private void updateChoosedNum() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            String string = getPageContext().getString(R.string.add);
            if (this.mChoosedNum > 0) {
                TextView textView = this.mAddAlbumTv;
                textView.setText("(" + this.mChoosedNum + ") " + string);
                return;
            }
            this.mAddAlbumTv.setText(string);
        }
    }

    @Override // d.a.q0.c2.g.f
    public boolean canChooseMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mChoosedNum < MAX_SELECT_NUM : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            getLayoutMode().k(i2 == 1);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
        }
    }

    @Override // d.a.q0.c2.g.f
    public void onChoose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.mChoosedNum++;
            updateChoosedNum();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.user_pick_album, (ViewGroup) null);
            this.rootView = inflate;
            setContentView(inflate);
            SkinManager.setBackgroundResource(this.rootView, R.color.CAM_X0201);
            initView();
            initSetting();
            loadAlbumData();
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            g gVar = this.mAdapter;
            if (gVar != null) {
                this.mChooseList = gVar.f();
            }
            Drawable drawable = SkinManager.getDrawable(R.drawable.icon_emotion_albumarrow_down);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.mSelectAlbumTv.setCompoundDrawables(null, null, drawable, null);
        }
    }

    @Override // d.a.q0.p0.s.d
    public void onItemClick(int i2, d.a.p0.f.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048581, this, i2, aVar) == null) || aVar == null) {
            return;
        }
        this.mAlbumId = aVar.b();
        this.mNavigationBar.setCenterTextTitle(aVar.g());
        this.mLoadModel.i(aVar.b(), new f(this));
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048582, this, absListView, i2, i3, i4) == null) {
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, absListView, i2) == null) {
            if (i2 == 2) {
                this.mAdapter.l(true);
            } else if (this.mAdapter.i()) {
                this.mAdapter.l(false);
                refreshImages();
            }
        }
    }

    @Override // d.a.q0.c2.g.f
    public void onUnChoose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            int i2 = this.mChoosedNum;
            if (i2 > 0) {
                this.mChoosedNum = i2 - 1;
            }
            updateChoosedNum();
        }
    }
}

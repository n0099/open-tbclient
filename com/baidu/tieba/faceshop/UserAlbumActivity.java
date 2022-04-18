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
import com.repackage.bl4;
import com.repackage.cl4;
import com.repackage.dl4;
import com.repackage.el4;
import com.repackage.fo;
import com.repackage.g35;
import com.repackage.lo7;
import com.repackage.mo7;
import com.repackage.oi;
import com.repackage.q96;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class UserAlbumActivity extends BaseFragmentActivity implements AbsListView.OnScrollListener, lo7, PopupWindow.OnDismissListener, q96.d {
    public static /* synthetic */ Interceptable $ic = null;
    public static int MAX_SELECT_NUM = 10;
    public transient /* synthetic */ FieldHolder $fh;
    public mo7 mAdapter;
    public TextView mAddAlbumTv;
    public bl4 mAddData;
    public String mAlbumId;
    public List<ImageFileInfo> mAllImageList;
    public LinkedHashMap<String, ImageFileInfo> mChooseList;
    public int mChoosedNum;
    public GridView mGridView;
    public List<ImageFileInfo> mImageList;
    public cl4 mLoadModel;
    public NavigationBar mNavigationBar;
    public NoDataView mNoDataView;
    public TextView mSelectAlbumTv;
    public q96 mUserCollectAlbumListPopupWindow;
    public View rootView;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserAlbumActivity a;

        /* renamed from: com.baidu.tieba.faceshop.UserAlbumActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0184a implements dl4 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0184a(a aVar) {
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

            @Override // com.repackage.dl4
            public void a(List<bl4> list) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || ListUtils.isEmpty(list)) {
                    return;
                }
                if (this.a.a.mAddData != null) {
                    list.add(0, this.a.a.mAddData);
                }
                if (this.a.a.mUserCollectAlbumListPopupWindow.isShowing()) {
                    return;
                }
                this.a.a.mUserCollectAlbumListPopupWindow.i(list, this.a.a.mAlbumId);
                this.a.a.mUserCollectAlbumListPopupWindow.l(this.a.a.mNavigationBar);
            }

            @Override // com.repackage.dl4
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
                this.a.mSelectAlbumTv.setCompoundDrawables(null, null, drawable, null);
                this.a.mLoadModel.g(new C0184a(this));
            }
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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
                userAlbumActivity.mChooseList = userAlbumActivity.mAdapter.f();
                ArrayList arrayList = new ArrayList();
                for (Map.Entry entry : this.a.mChooseList.entrySet()) {
                    arrayList.add(entry.getValue());
                }
                Intent intent = new Intent();
                intent.putExtra(UserCollectManageActivity.KEY_SELECT_ALBUM_LIST, arrayList);
                this.a.setResult(-1, intent);
                this.a.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements el4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserAlbumActivity a;

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

        @Override // com.repackage.el4
        public void a(List<bl4> list, List<ImageFileInfo> list2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, list, list2, str) == null) {
                if (!ListUtils.isEmpty(list2)) {
                    this.a.mGridView.setVisibility(0);
                    this.a.mNoDataView.setVisibility(8);
                    this.a.mAllImageList.clear();
                    this.a.mAllImageList.addAll(list2);
                    this.a.mImageList.addAll(list2);
                    this.a.mAddData = new bl4();
                    this.a.mAddData.h(bl4.f);
                    bl4 bl4Var = this.a.mAddData;
                    bl4Var.i(list2.size() + "");
                    this.a.mAddData.l(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0248));
                    this.a.mAddData.k(list2.get(0));
                    this.a.mAdapter.notifyDataSetChanged();
                    return;
                }
                this.a.mGridView.setVisibility(8);
                this.a.mNoDataView.setVisibility(0);
            }
        }

        @Override // com.repackage.el4
        public void onPreLoad() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements g35 {
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

        @Override // com.repackage.g35
        public void a(fo foVar, String str, boolean z) {
            TbImageView tbImageView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, foVar, str, z) == null) || (tbImageView = (TbImageView) this.a.mGridView.findViewWithTag(str)) == null || foVar == null) {
                return;
            }
            tbImageView.invalidate();
        }
    }

    /* loaded from: classes3.dex */
    public class f implements el4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserAlbumActivity a;

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

        @Override // com.repackage.el4
        public void a(List<bl4> list, List<ImageFileInfo> list2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, list, list2, str) == null) {
                this.a.mImageList.clear();
                if (!ListUtils.isEmpty(list2)) {
                    this.a.mImageList.addAll(list2);
                }
                this.a.mAdapter.notifyDataSetChanged();
            }
        }

        @Override // com.repackage.el4
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mImageList = new ArrayList();
        this.mAllImageList = new ArrayList();
        this.mChooseList = new LinkedHashMap<>();
        this.mAlbumId = bl4.f;
    }

    private void initSetting() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            this.mLoadModel = new cl4(getActivity());
            mo7 mo7Var = new mo7(this, this.mImageList);
            this.mAdapter = mo7Var;
            mo7Var.k(getPageContext().getString(R.string.obfuscated_res_0x7f0f036d));
            this.mAdapter.j(this);
            this.mGridView.setAdapter((ListAdapter) this.mAdapter);
            this.mGridView.setOnScrollListener(this);
            q96 q96Var = new q96(getPageContext().getPageActivity());
            this.mUserCollectAlbumListPopupWindow = q96Var;
            q96Var.setOnDismissListener(this);
            this.mUserCollectAlbumListPopupWindow.j(this);
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            NoDataView a2 = NoDataViewFactory.a(getPageContext().getPageActivity(), this.rootView, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, oi.f(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0702a1)), NoDataViewFactory.e.c(getPageContext().getPageActivity().getText(R.string.obfuscated_res_0x7f0f05dc).toString()), null);
            this.mNoDataView = a2;
            a2.f(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setVisibility(8);
            this.mGridView = (GridView) this.rootView.findViewById(R.id.obfuscated_res_0x7f090cf7);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f091515);
            this.mNavigationBar = navigationBar;
            navigationBar.setCenterTextTitle(getPageContext().getString(R.string.obfuscated_res_0x7f0f0248));
            TextView textView = this.mNavigationBar.mCenterText;
            this.mSelectAlbumTv = textView;
            textView.setOnClickListener(new a(this));
            this.mSelectAlbumTv.setCompoundDrawablePadding(oi.f(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070305));
            SkinManager.setViewTextColor(this.mSelectAlbumTv, (int) R.color.CAM_X0302);
            Drawable drawable = SkinManager.getDrawable(R.drawable.icon_emotion_albumarrow_down);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.mSelectAlbumTv.setCompoundDrawables(null, null, drawable, null);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new b(this)).setPadding(oi.f(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701e8), 0, 0, 0);
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mNavigationBar.getBackImageView(), R.drawable.obfuscated_res_0x7f0809bb, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            TextView addTextButton = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.obfuscated_res_0x7f0f00b6), new c(this));
            this.mAddAlbumTv = addTextButton;
            addTextButton.setPadding(0, 0, oi.f(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f07020f), 0);
            SkinManager.setViewTextColor(this.mAddAlbumTv, (int) R.color.CAM_X0302);
        }
    }

    private void loadAlbumData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            this.mLoadModel.i(bl4.f, new d(this));
        }
    }

    private void refreshImages() {
        mo7 mo7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65555, this) == null) || (mo7Var = this.mAdapter) == null || mo7Var.g() == null) {
            return;
        }
        int childCount = this.mGridView.getChildCount();
        int firstVisiblePosition = this.mGridView.getFirstVisiblePosition();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mGridView.getChildAt(i);
            if (childAt != null) {
                TbImageView tbImageView = (TbImageView) childAt.findViewById(R.id.obfuscated_res_0x7f090e68);
                ImageFileInfo item = this.mAdapter.getItem(firstVisiblePosition + i);
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
            String string = getPageContext().getString(R.string.obfuscated_res_0x7f0f00b6);
            if (this.mChoosedNum > 0) {
                TextView textView = this.mAddAlbumTv;
                textView.setText("(" + this.mChoosedNum + ") " + string);
                return;
            }
            this.mAddAlbumTv.setText(string);
        }
    }

    @Override // com.repackage.lo7
    public boolean canChooseMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mChoosedNum < MAX_SELECT_NUM : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            getLayoutMode().k(i == 1);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
    }

    @Override // com.repackage.lo7
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
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0860, (ViewGroup) null);
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
            mo7 mo7Var = this.mAdapter;
            if (mo7Var != null) {
                this.mChooseList = mo7Var.f();
            }
            Drawable drawable = SkinManager.getDrawable(R.drawable.icon_emotion_albumarrow_down);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.mSelectAlbumTv.setCompoundDrawables(null, null, drawable, null);
        }
    }

    @Override // com.repackage.q96.d
    public void onItemClick(int i, bl4 bl4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048581, this, i, bl4Var) == null) || bl4Var == null) {
            return;
        }
        this.mAlbumId = bl4Var.b();
        this.mNavigationBar.setCenterTextTitle(bl4Var.g());
        this.mLoadModel.i(bl4Var.b(), new f(this));
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048582, this, absListView, i, i2, i3) == null) {
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, absListView, i) == null) {
            if (i == 2) {
                this.mAdapter.l(true);
            } else if (this.mAdapter.i()) {
                this.mAdapter.l(false);
                refreshImages();
            }
        }
    }

    @Override // com.repackage.lo7
    public void onUnChoose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            int i = this.mChoosedNum;
            if (i > 0) {
                this.mChoosedNum = i - 1;
            }
            updateChoosedNum();
        }
    }
}

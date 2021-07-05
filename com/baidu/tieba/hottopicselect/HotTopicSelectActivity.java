package com.baidu.tieba.hottopicselect;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.suspended.SuspendedActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.StatusBarUtil;
import com.baidu.tieba.hottopicselect.HotTopicSelectModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class HotTopicSelectActivity extends SuspendedActivity implements d.a.r0.t0.a, HotTopicSelectModel.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView mCancelBtn;
    public ImageView mClearView;
    public HotTopicSelectModel mHotModel;
    public EditText mInputEdt;
    public View mListCustomView;
    public ExpandableListView mLvNoSearch;
    public ViewGroup mMainLayout;
    public NoDataView mNoDataView;
    public d.a.s0.h1.e mNoSearchAdapter;
    public final ExpandableListView.OnChildClickListener mOnChildClickListener;
    public final View.OnClickListener mOnClickListener;
    public final ExpandableListView.OnGroupClickListener mOnGroupClickListener;
    public final AdapterView.OnItemClickListener mOnItemClickListener;
    public Intent mResultIntent;
    public final List<d.a.s0.h1.d> mSearchList;
    public d.a.s0.h1.b mSuggestAdatper;
    public BdListView mSuggestView;
    public TextView mTopicText;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicSelectActivity f17216e;

        public a(HotTopicSelectActivity hotTopicSelectActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicSelectActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17216e = hotTopicSelectActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f17216e.mClearView) {
                    this.f17216e.clearAllTextStatus();
                } else if (view == this.f17216e.mCancelBtn) {
                    this.f17216e.createIntent("");
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicSelectActivity f17217e;

        public b(HotTopicSelectActivity hotTopicSelectActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicSelectActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17217e = hotTopicSelectActivity;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            d.a.s0.h1.d dVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || (dVar = (d.a.s0.h1.d) ListUtils.getItem(this.f17217e.mSuggestAdatper.d(), i2)) == null) {
                return;
            }
            String b2 = dVar.b();
            this.f17217e.createIntent(b2);
            this.f17217e.addClickStats(b2, 3);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ExpandableListView.OnGroupClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HotTopicSelectActivity f17218a;

        public c(HotTopicSelectActivity hotTopicSelectActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicSelectActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17218a = hotTopicSelectActivity;
        }

        @Override // android.widget.ExpandableListView.OnGroupClickListener
        public boolean onGroupClick(ExpandableListView expandableListView, View view, int i2, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{expandableListView, view, Integer.valueOf(i2), Long.valueOf(j)})) == null) {
                if (this.f17218a.mLvNoSearch != null) {
                    this.f17218a.mLvNoSearch.expandGroup(i2);
                    return true;
                }
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements ExpandableListView.OnChildClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicSelectActivity f17219e;

        public d(HotTopicSelectActivity hotTopicSelectActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicSelectActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17219e = hotTopicSelectActivity;
        }

        @Override // android.widget.ExpandableListView.OnChildClickListener
        public boolean onChildClick(ExpandableListView expandableListView, View view, int i2, int i3, long j) {
            InterceptResult invokeCommon;
            d.a.s0.h1.d child;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{expandableListView, view, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j)})) == null) {
                if (this.f17219e.mNoSearchAdapter == null || (child = this.f17219e.mNoSearchAdapter.getChild(i2, i3)) == null) {
                    return false;
                }
                String b2 = child.b();
                this.f17219e.createIntent(b2);
                d.a.s0.h1.c group = this.f17219e.mNoSearchAdapter.getGroup(i2);
                if (group != null) {
                    this.f17219e.addClickStats(b2, group.c() == 0 ? 1 : 2);
                    return false;
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicSelectActivity f17220e;

        public e(HotTopicSelectActivity hotTopicSelectActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicSelectActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17220e = hotTopicSelectActivity;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) || z) {
                return;
            }
            l.x(this.f17220e.getPageContext().getPageActivity(), view);
        }
    }

    /* loaded from: classes5.dex */
    public class f implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HotTopicSelectActivity f17221a;

        public f(HotTopicSelectActivity hotTopicSelectActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicSelectActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17221a = hotTopicSelectActivity;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i2, keyEvent)) == null) {
                if (i2 == 6) {
                    l.K(this.f17221a.getPageContext().getPageActivity(), textView);
                    if (TextUtils.isEmpty(this.f17221a.getSearchKey())) {
                        return true;
                    }
                    HotTopicSelectActivity hotTopicSelectActivity = this.f17221a;
                    hotTopicSelectActivity.createIntent(hotTopicSelectActivity.getSearchKey());
                    return true;
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class g implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicSelectActivity f17222e;

        public g(HotTopicSelectActivity hotTopicSelectActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicSelectActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17222e = hotTopicSelectActivity;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                String obj = editable.toString();
                if (obj == null || obj.trim().length() <= 0) {
                    this.f17222e.afterDealText();
                } else {
                    this.f17222e.mNoDataView.setVisibility(8);
                    this.f17222e.mListCustomView.setVisibility(8);
                    this.f17222e.showLoadingView();
                    this.f17222e.mHotModel.K(obj);
                }
                this.f17222e.setDelButtonVisible(!StringUtils.isNull(editable.toString()));
                this.f17222e.setTopicTextViewColor();
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
            }
        }
    }

    public HotTopicSelectActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mSearchList = new ArrayList();
        this.mOnClickListener = new a(this);
        this.mOnItemClickListener = new b(this);
        this.mOnGroupClickListener = new c(this);
        this.mOnChildClickListener = new d(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addClickStats(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65552, this, str, i2) == null) {
            StatisticItem statisticItem = new StatisticItem("c11665");
            statisticItem.param("obj_name", str);
            statisticItem.param("obj_locate", i2);
            TiebaStatic.log(statisticItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afterDealText() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            this.mLvNoSearch.setVisibility(0);
            this.mSuggestView.setVisibility(8);
            this.mSuggestAdatper.b();
            d.a.s0.h1.e eVar = this.mNoSearchAdapter;
            if (eVar != null && !ListUtils.isEmpty(eVar.f())) {
                this.mListCustomView.setVisibility(0);
                return;
            }
            showLoadingView();
            this.mHotModel.B();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAllTextStatus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            this.mHotModel.L("");
            this.mInputEdt.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createIntent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, this, str) == null) {
            EditText editText = this.mInputEdt;
            if (editText != null && editText.hasFocus()) {
                l.x(getPageContext().getPageActivity(), this.mInputEdt);
            }
            if (TextUtils.isEmpty(str)) {
                setResult(0, new Intent());
            } else {
                this.mResultIntent = new Intent();
                this.mResultIntent.putExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING, str + HotSelectActivityConfig.HOT_TOPIC_SING);
            }
            finish();
        }
    }

    private d.a.s0.h1.d createSearchData(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, this, str)) == null) {
            d.a.s0.h1.d dVar = new d.a.s0.h1.d();
            dVar.d(str);
            return dVar;
        }
        return (d.a.s0.h1.d) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSearchKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) {
            HotTopicSelectModel hotTopicSelectModel = this.mHotModel;
            String C = hotTopicSelectModel != null ? hotTopicSelectModel.C() : "";
            return C != null ? C : "";
        }
        return (String) invokeV.objValue;
    }

    private void initInputEdit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            EditText editText = (EditText) findViewById(R.id.search_root);
            this.mInputEdt = editText;
            editText.setCompoundDrawablePadding(l.g(getPageContext().getPageActivity(), R.dimen.ds8));
            this.mInputEdt.setOnFocusChangeListener(new e(this));
            this.mInputEdt.setOnEditorActionListener(new f(this));
            this.mInputEdt.addTextChangedListener(new g(this));
            this.mInputEdt.requestFocus();
        }
    }

    private void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            this.mMainLayout = (ViewGroup) findViewById(R.id.frame_main_view);
            this.mCancelBtn = (TextView) findViewById(R.id.btn_confirm);
            this.mTopicText = (TextView) findViewById(R.id.topic_text);
            this.mClearView = (ImageView) findViewById(R.id.clear_right_img);
            this.mListCustomView = findViewById(R.id.home_search_list);
            this.mSuggestView = (BdListView) findViewById(R.id.home_lv_search_suggest);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds420)), null, null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.mMainLayout.addView(this.mNoDataView, layoutParams);
            this.mNoDataView.setVisibility(8);
            d.a.s0.h1.b bVar = new d.a.s0.h1.b(getPageContext());
            this.mSuggestAdatper = bVar;
            this.mSuggestView.setAdapter((ListAdapter) bVar);
            this.mLvNoSearch = (ExpandableListView) findViewById(R.id.home_no_search_listview);
            d.a.s0.h1.e eVar = new d.a.s0.h1.e(getPageContext());
            this.mNoSearchAdapter = eVar;
            this.mLvNoSearch.setAdapter(eVar);
            this.mSuggestView.setOnItemClickListener(this.mOnItemClickListener);
            this.mLvNoSearch.setOnGroupClickListener(this.mOnGroupClickListener);
            this.mLvNoSearch.setOnChildClickListener(this.mOnChildClickListener);
            this.mCancelBtn.setOnClickListener(this.mOnClickListener);
            this.mClearView.setOnClickListener(this.mOnClickListener);
            setDelButtonVisible(false);
            initInputEdit();
        }
    }

    private void parseAndDealData(d.a.s0.h1.c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65560, this, cVar, z) == null) || cVar == null || ListUtils.isEmpty(cVar.b())) {
            return;
        }
        if (TextUtils.isEmpty(cVar.a())) {
            cVar.e(getString(z ? R.string.group_topic_default : R.string.group_topic_hot));
        }
        this.mNoSearchAdapter.g(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTopicTextViewColor() {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65561, this) == null) || (editText = this.mInputEdt) == null || this.mTopicText == null) {
            return;
        }
        if (TextUtils.isEmpty(editText.getText())) {
            SkinManager.setViewTextColor(this.mTopicText, R.color.CAM_X0109, 1);
        } else {
            SkinManager.setViewTextColor(this.mTopicText, R.color.CAM_X0105, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, this) == null) {
            this.mListCustomView.setVisibility(8);
            showLoadingView(this.mMainLayout, true, getResources().getDimensionPixelSize(R.dimen.ds320));
        }
    }

    @Override // d.a.r0.t0.a
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mResultIntent : (Intent) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public d.a.r0.t0.a getSuspendedContentView(LinearLayout linearLayout, NavigationBar navigationBar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, linearLayout, navigationBar)) == null) {
            LayoutInflater.from(this).inflate(R.layout.hot_navigation_view_layout, (ViewGroup) navigationBar.getContentLayout(), true);
            this.mCancel.setVisibility(8);
            LayoutInflater.from(this).inflate(R.layout.hot_select_main, (ViewGroup) linearLayout, true);
            return this;
        }
        return (d.a.r0.t0.a) invokeLL.objValue;
    }

    @Override // d.a.r0.t0.a
    public boolean isOnViewCancel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.r0.t0.a
    public boolean isOnViewTop() {
        InterceptResult invokeV;
        ListView listView;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.mSuggestView.getVisibility() == 0) {
                listView = this.mSuggestView;
            } else {
                listView = this.mLvNoSearch;
            }
            return listView != null && listView.getFirstVisiblePosition() == 0 && (childAt = listView.getChildAt(0)) != null && childAt.getTop() == 0;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            createIntent("");
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mSkinType = i2;
            NoDataView noDataView = this.mNoDataView;
            if (noDataView != null) {
                noDataView.f(getPageContext(), i2);
            }
            d.a.s0.h1.b bVar = this.mSuggestAdatper;
            if (bVar != null) {
                bVar.notifyDataSetChanged();
            }
            d.a.s0.h1.e eVar = this.mNoSearchAdapter;
            if (eVar != null) {
                eVar.notifyDataSetChanged();
            }
            EditText editText = this.mInputEdt;
            if (editText != null) {
                editText.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
            }
            SkinManager.setViewTextColor(this.mCancelBtn, R.color.CAM_X0302, 1);
            SkinManager.setViewTextColor(this.mInputEdt, R.color.CAM_X0105, 2);
            SkinManager.setImageResource(this.mClearView, R.drawable.del_search_btn);
            setTopicTextViewColor();
            if (this.mSkinType == 2) {
                StatusBarUtil.from(getPageContext().getPageActivity()).setTransparentStatusbar(true).setLightStatusBar(true).process();
            }
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            HotTopicSelectModel hotTopicSelectModel = new HotTopicSelectModel(getPageContext(), this);
            this.mHotModel = hotTopicSelectModel;
            hotTopicSelectModel.F(getIntent());
            this.mHotModel.I();
            initUI();
            getWindow().setSoftInputMode(1);
            showLoadingView();
            this.mHotModel.J();
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.mHotModel.onDestroy();
            this.mNoDataView.e();
            hideLoadingView(this.mMainLayout);
            super.onDestroy();
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.c
    public void onHotSelectDataNoSearchFailed(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            hideLoadingView(this.mMainLayout);
            this.mListCustomView.setVisibility(8);
            if (!j.z()) {
                this.mNoDataView.setTextOption(NoDataViewFactory.e.a(R.string.neterror));
                this.mNoDataView.setVisibility(0);
            } else if (TextUtils.isEmpty(str)) {
            } else {
                this.mNoDataView.setTextOption(NoDataViewFactory.e.a(R.string.refresh_view_title_text));
                this.mNoDataView.setVisibility(0);
                showToast(str);
            }
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.c
    public void onHotSelectDataNoSearchSuccess(d.a.s0.h1.c cVar, d.a.s0.h1.c cVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, cVar, cVar2) == null) {
            this.mListCustomView.setVisibility(0);
            this.mLvNoSearch.setVisibility(0);
            this.mSuggestView.setVisibility(8);
            hideLoadingView(this.mMainLayout);
            this.mNoSearchAdapter.c();
            parseAndDealData(cVar, true);
            parseAndDealData(cVar2, false);
            this.mNoSearchAdapter.notifyDataSetChanged();
            int count = this.mLvNoSearch.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                this.mLvNoSearch.expandGroup(i2);
            }
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.c
    public void onHotSelectDataSearchFailed(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.mListCustomView.setVisibility(0);
            this.mLvNoSearch.setVisibility(8);
            this.mSuggestView.setVisibility(0);
            hideLoadingView(this.mMainLayout);
            String searchKey = getSearchKey();
            d.a.s0.h1.d createSearchData = createSearchData(searchKey);
            this.mSearchList.clear();
            this.mSearchList.add(createSearchData);
            this.mSuggestAdatper.e(searchKey, this.mSearchList);
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.c
    public void onHotSelectDataSearchSuccess(d.a.s0.h1.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) {
            this.mListCustomView.setVisibility(0);
            this.mLvNoSearch.setVisibility(8);
            this.mSuggestView.setVisibility(0);
            hideLoadingView(this.mMainLayout);
            this.mSearchList.clear();
            String searchKey = getSearchKey();
            this.mSearchList.add(createSearchData(searchKey));
            if (cVar != null && cVar.b() != null) {
                this.mSearchList.addAll(cVar.b());
                this.mSuggestAdatper.e(searchKey, this.mSearchList);
                return;
            }
            this.mSuggestAdatper.e(searchKey, this.mSearchList);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onStop();
            setSkinType(3);
            NoDataView noDataView = this.mNoDataView;
            if (noDataView != null) {
                noDataView.e();
            }
        }
    }

    @Override // d.a.r0.t0.a
    public void onViewChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public void requestData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    public void setDelButtonVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.mClearView.setVisibility(z ? 0 : 8);
        }
    }
}

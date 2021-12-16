package com.baidu.tieba.addresslist;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import c.a.d.f.p.m;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.addresslist.model.QuickSearchModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class QuickSearchActivity extends BaseActivity<QuickSearchActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView mCancelButton;
    public TextView mEmptyResultView;
    public EditText mInputEditText;
    public g mListAdapter;
    public NavigationBar mNavigationBar;
    public View mParentView;
    public QuickSearchModel mSearchModel;
    public ListView mSearchResultList;

    /* loaded from: classes11.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ QuickSearchActivity f43138e;

        public a(QuickSearchActivity quickSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {quickSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43138e = quickSearchActivity;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 0) {
                    m.w(this.f43138e.getPageContext().getPageActivity(), this.f43138e.mInputEditText);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes11.dex */
    public class b implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ QuickSearchActivity f43139e;

        public b(QuickSearchActivity quickSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {quickSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43139e = quickSearchActivity;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 0) {
                    m.w(this.f43139e.getPageContext().getPageActivity(), this.f43139e.mInputEditText);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes11.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ QuickSearchActivity f43140e;

        public c(QuickSearchActivity quickSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {quickSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43140e = quickSearchActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f43140e.mInputEditText.hasFocus()) {
                    m.w(this.f43140e.getPageContext().getPageActivity(), this.f43140e.mInputEditText);
                }
                this.f43140e.closeActivity();
            }
        }
    }

    /* loaded from: classes11.dex */
    public class d implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ QuickSearchActivity f43141e;

        public d(QuickSearchActivity quickSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {quickSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43141e = quickSearchActivity;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) || z) {
                return;
            }
            m.w(this.f43141e.getPageContext().getPageActivity(), view);
        }
    }

    /* loaded from: classes11.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ QuickSearchActivity f43142e;

        public e(QuickSearchActivity quickSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {quickSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43142e = quickSearchActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f43142e.mInputEditText.setText("");
                this.f43142e.mEmptyResultView.setVisibility(8);
                this.f43142e.mSearchResultList.setVisibility(8);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class f implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ QuickSearchActivity f43143e;

        public f(QuickSearchActivity quickSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {quickSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43143e = quickSearchActivity;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                if (editable.toString().trim().length() == 0) {
                    this.f43143e.mCancelButton.setVisibility(8);
                } else {
                    this.f43143e.mCancelButton.setVisibility(0);
                }
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
                if (charSequence.toString().trim().length() != 0) {
                    this.f43143e.refreshResultList(charSequence.toString());
                    return;
                }
                this.f43143e.mEmptyResultView.setVisibility(8);
                this.f43143e.mSearchResultList.setVisibility(8);
            }
        }

        public /* synthetic */ f(QuickSearchActivity quickSearchActivity, a aVar) {
            this(quickSearchActivity);
        }
    }

    /* loaded from: classes11.dex */
    public class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public HeadImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f43146b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ QuickSearchActivity f43147c;

        public h(QuickSearchActivity quickSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {quickSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43147c = quickSearchActivity;
        }

        public /* synthetic */ h(QuickSearchActivity quickSearchActivity, a aVar) {
            this(quickSearchActivity);
        }
    }

    public QuickSearchActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void initNavigatorBar() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.mNavigationBar = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new c(this));
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.quick_search_navigation, (View.OnClickListener) null);
            EditText editText = (EditText) addCustomView.findViewById(R.id.quick_search_input);
            this.mInputEditText = editText;
            editText.addTextChangedListener(new f(this, null));
            this.mInputEditText.setOnFocusChangeListener(new d(this));
            this.mInputEditText.requestFocus();
            this.mCancelButton = (TextView) addCustomView.findViewById(R.id.quick_search_delete_button);
            m.b(getPageContext().getPageActivity(), this.mCancelButton, 10, 10, 10, 10);
            this.mCancelButton.setOnClickListener(new e(this));
        }
    }

    private void initViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.mParentView = findViewById(R.id.quick_search_parent);
            adjustResizeForSoftInput();
            initNavigatorBar();
            this.mSearchResultList = (ListView) findViewById(R.id.quick_search_result);
            TextView textView = new TextView(getActivity());
            textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
            this.mSearchResultList.addHeaderView(textView);
            this.mSearchResultList.setOnTouchListener(new a(this));
            g gVar = new g(this, null);
            this.mListAdapter = gVar;
            this.mSearchResultList.setAdapter((ListAdapter) gVar);
            this.mSearchResultList.setOnItemClickListener(this);
            this.mEmptyResultView = (TextView) findViewById(R.id.quick_search_empty_result);
            this.mParentView.setOnTouchListener(new b(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshResultList(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, str) == null) {
            List<c.a.r0.t.f.a> w = this.mSearchModel.w(str);
            if (w.size() > 0) {
                showSearchResultList(true);
                this.mListAdapter.b(w);
                this.mListAdapter.notifyDataSetChanged();
                this.mSearchResultList.setSelection(0);
                return;
            }
            showSearchResultList(false);
        }
    }

    private void showSearchResultList(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65546, this, z) == null) {
            this.mSearchResultList.setVisibility(z ? 0 : 8);
            this.mEmptyResultView.setVisibility(z ? 8 : 0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            super.onChangeSkinType(i2);
            SkinManager.setBackgroundResource(this.mParentView, R.color.CAM_X0201);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
            this.mListAdapter.notifyDataSetChanged();
            SkinManager.setViewTextColor(this.mEmptyResultView, R.color.CAM_X0109, 1);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.quick_search_activity);
            QuickSearchModel quickSearchModel = new QuickSearchModel(this);
            this.mSearchModel = quickSearchModel;
            quickSearchModel.setUniqueId(getUniqueId());
            initViews();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
            m.w(getPageContext().getPageActivity(), this.mInputEditText);
            this.mSearchModel = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            int headerViewsCount = this.mSearchResultList.getHeaderViewsCount();
            if (headerViewsCount > 0) {
                i2 -= headerViewsCount;
            }
            c.a.r0.t.f.a item = this.mListAdapter.getItem(i2);
            if (item == null || item.e() <= 0) {
                return;
            }
            if (item.i() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), item.e(), item.f(), item.h(), 0, 4)));
            } else {
                sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), String.valueOf(item.e()), item.f())));
            }
        }
    }

    /* loaded from: classes11.dex */
    public class g extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public List<c.a.r0.t.f.a> f43144e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ QuickSearchActivity f43145f;

        public g(QuickSearchActivity quickSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {quickSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43145f = quickSearchActivity;
            this.f43144e = new ArrayList();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public c.a.r0.t.f.a getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                if (this.f43144e == null || i2 < 0 || i2 >= getCount()) {
                    return null;
                }
                return this.f43144e.get(i2);
            }
            return (c.a.r0.t.f.a) invokeI.objValue;
        }

        public void b(List<c.a.r0.t.f.a> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                this.f43144e = list;
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                List<c.a.r0.t.f.a> list = this.f43144e;
                if (list != null) {
                    return list.size();
                }
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? i2 : invokeI.longValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            h hVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i2, view, viewGroup)) == null) {
                c.a.r0.s.c layoutMode = this.f43145f.getLayoutMode();
                TbadkCoreApplication.getInst().getSkinType();
                c.a.r0.t.f.a item = getItem(i2);
                if (item == null) {
                    return null;
                }
                if (view == null) {
                    view = LayoutInflater.from(this.f43145f.getPageContext().getPageActivity()).inflate(R.layout.quick_search_item, (ViewGroup) null);
                    hVar = new h(this.f43145f, null);
                    hVar.a = (HeadImageView) view.findViewById(R.id.quick_search_item_icon);
                    hVar.f43146b = (TextView) view.findViewById(R.id.quick_search_item_text);
                    view.setTag(hVar);
                } else {
                    hVar = (h) view.getTag();
                }
                layoutMode.j(view);
                SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                if (item.f() != null) {
                    hVar.f43146b.setText(item.f());
                }
                hVar.a.startLoad(item.h(), 12, false);
                return view;
            }
            return (View) invokeILL.objValue;
        }

        public /* synthetic */ g(QuickSearchActivity quickSearchActivity, a aVar) {
            this(quickSearchActivity);
        }
    }
}

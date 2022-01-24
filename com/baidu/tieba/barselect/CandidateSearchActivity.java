package com.baidu.tieba.barselect;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.data.CommitVoteResMsg;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.model.CandidateSearchHttpResMsg;
import com.baidu.tieba.barselect.model.CandidateSearchSocketResMsg;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes12.dex */
public class CandidateSearchActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<c.a.t0.c0.b.a> dataList;
    public CandidateSearchAdapter mAdapter;
    public TextView mButtonCancelSearch;
    public ImageView mButtonDel;
    public c.a.d.c.g.a mDataResListener;
    public String mForumId;
    public c.a.t0.c0.d.a mModel;
    public NavigationBar mNavigationBar;
    public View mNavigationCustomView;
    public View mNoDataView;
    public View.OnClickListener mOnClickListener;
    public TextView.OnEditorActionListener mOnEditorActionListener;
    public BdRecyclerView mRecyclerView;
    public ImageView mSearchIcon;
    public EditText mSearchbox;
    public Runnable mShowKeyboardRunnable;
    public TextWatcher mTextWatcher;
    public HttpMessageListener mVoteListener;

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CandidateSearchActivity f42183e;

        public a(CandidateSearchActivity candidateSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {candidateSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42183e = candidateSearchActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() != this.f42183e.mButtonCancelSearch.getId()) {
                    if (view.getId() == this.f42183e.mButtonDel.getId()) {
                        this.f42183e.mSearchbox.setText("");
                        this.f42183e.mRecyclerView.setVisibility(0);
                        this.f42183e.mNoDataView.setVisibility(8);
                        this.f42183e.mAdapter.setData(new ArrayList());
                        return;
                    }
                    return;
                }
                this.f42183e.finish();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CandidateSearchActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(CandidateSearchActivity candidateSearchActivity, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {candidateSearchActivity, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = candidateSearchActivity;
        }

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            c.a.t0.c0.b.a aVar = null;
            if (responsedMessage instanceof CandidateSearchHttpResMsg) {
                aVar = ((CandidateSearchHttpResMsg) responsedMessage).candidateData;
            } else if (responsedMessage instanceof CandidateSearchSocketResMsg) {
                aVar = ((CandidateSearchSocketResMsg) responsedMessage).candidateData;
            }
            if (responsedMessage.getError() != 0 || aVar == null) {
                this.a.mRecyclerView.setVisibility(8);
                this.a.mNoDataView.setVisibility(0);
                return;
            }
            this.a.mRecyclerView.setVisibility(0);
            this.a.mNoDataView.setVisibility(8);
            if (this.a.mSearchbox.getText() != null) {
                aVar.f15426j = this.a.mSearchbox.getText().toString();
            }
            if (this.a.dataList != null) {
                this.a.dataList.clear();
            } else {
                this.a.dataList = new ArrayList();
            }
            this.a.dataList.add(aVar);
            this.a.mAdapter.setData(this.a.dataList);
        }
    }

    /* loaded from: classes12.dex */
    public class c implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CandidateSearchActivity a;

        public c(CandidateSearchActivity candidateSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {candidateSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = candidateSearchActivity;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i2, keyEvent)) == null) {
                if (i2 == 3) {
                    if (this.a.mSearchbox.getText() != null && !TextUtils.isEmpty(this.a.mSearchbox.getText().toString()) && !TextUtils.isEmpty(this.a.mForumId)) {
                        this.a.mModel.a(c.a.d.f.m.b.e(this.a.mSearchbox.getText().toString(), 0), c.a.d.f.m.b.g(this.a.mForumId, 0L));
                    }
                    return true;
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes12.dex */
    public class d extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CandidateSearchActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(CandidateSearchActivity candidateSearchActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {candidateSearchActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = candidateSearchActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) || httpResponsedMessage == null) {
                return;
            }
            int error = httpResponsedMessage.getError();
            if (error == 0) {
                n.M(TbadkCoreApplication.getInst(), R.string.bar_manager_vote_success);
                if (this.a.dataList != null) {
                    for (c.a.t0.c0.b.a aVar : this.a.dataList) {
                        aVar.k = true;
                    }
                }
            } else if (error == 3250023) {
                c.a.t0.x3.p0.f.b(error, "", null);
            } else if (error == 3250021) {
                if (httpResponsedMessage instanceof CommitVoteResMsg) {
                    c.a.t0.x3.p0.f.a(error, ((CommitVoteResMsg) httpResponsedMessage).getTokenData(), null);
                }
            } else if (error != 3250002 && error != 3250004) {
                n.N(TbadkCoreApplication.getInst(), httpResponsedMessage.getErrorString());
            } else {
                BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                blockPopInfoData.block_info = m.isEmpty(httpResponsedMessage.getErrorString()) ? TbadkCoreApplication.getInst().getString(R.string.block_user_tip) : httpResponsedMessage.getErrorString();
                blockPopInfoData.ahead_info = TbadkCoreApplication.getInst().getString(R.string.block_user_feed);
                blockPopInfoData.ok_info = TbadkCoreApplication.getInst().getString(R.string.know);
                blockPopInfoData.ahead_url = "http://tieba.baidu.com/mo/q/userappeal";
                AntiHelper.s(this.a, blockPopInfoData);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class e implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CandidateSearchActivity f42184e;

        public e(CandidateSearchActivity candidateSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {candidateSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42184e = candidateSearchActivity;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.f42184e.setDelButtonVisible(!StringUtils.isNull(editable.toString()));
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

    /* loaded from: classes12.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CandidateSearchActivity f42185e;

        public f(CandidateSearchActivity candidateSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {candidateSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42185e = candidateSearchActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f42185e.mSearchbox == null) {
                return;
            }
            this.f42185e.mSearchbox.requestFocus();
            CandidateSearchActivity candidateSearchActivity = this.f42185e;
            n.L(candidateSearchActivity, candidateSearchActivity.mSearchbox);
        }
    }

    public CandidateSearchActivity() {
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
        this.mOnClickListener = new a(this);
        this.mDataResListener = new b(this, CmdConfigHttp.CMD_CANDIDATE_SEARCH, 309641);
        this.mOnEditorActionListener = new c(this);
        this.mVoteListener = new d(this, CmdConfigHttp.CMD_BAR_VOTE);
        this.mTextWatcher = new e(this);
        this.mShowKeyboardRunnable = new f(this);
    }

    private void initNavigationBar() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
            this.mNavigationBar = navigationBar;
            navigationBar.showBottomLine();
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.candidate_search_navigation_view, (View.OnClickListener) null);
            this.mNavigationCustomView = addCustomView;
            this.mSearchIcon = (ImageView) addCustomView.findViewById(R.id.search_bar_icon);
            this.mSearchbox = (EditText) this.mNavigationCustomView.findViewById(R.id.home_et_search);
            ImageView imageView = (ImageView) this.mNavigationCustomView.findViewById(R.id.home_bt_search_del);
            this.mButtonDel = imageView;
            imageView.setOnClickListener(this.mOnClickListener);
            this.mButtonCancelSearch = (TextView) this.mNavigationCustomView.findViewById(R.id.home_bt_search_cancel_s);
            setDelButtonVisible(false);
            this.mButtonCancelSearch.setText(getString(R.string.cancel));
            this.mButtonCancelSearch.setOnClickListener(this.mOnClickListener);
            this.mSearchbox.setOnEditorActionListener(this.mOnEditorActionListener);
            this.mSearchbox.addTextChangedListener(this.mTextWatcher);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
            SkinManager.setViewTextColor(this.mNoDataView, R.color.CAM_X0109);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mSearchIcon, R.drawable.icon_pure_topbar_search44_svg, R.color.CAM_X0109, null);
            this.mSearchbox.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            SkinManager.setNavbarTitleColor(this.mSearchbox, R.color.CAM_X0105, R.color.s_navbar_title_color);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mButtonDel, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SkinManager.setViewTextColor(this.mButtonCancelSearch, R.color.CAM_X0302, 1);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.activity_candidate_search);
            if (getIntent() != null) {
                this.mForumId = getIntent().getStringExtra("forum_id");
            }
            initNavigationBar();
            BdRecyclerView bdRecyclerView = (BdRecyclerView) findViewById(R.id.recycler_view);
            this.mRecyclerView = bdRecyclerView;
            bdRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            this.mNoDataView = findViewById(R.id.text_no_data);
            CandidateSearchAdapter candidateSearchAdapter = new CandidateSearchAdapter();
            this.mAdapter = candidateSearchAdapter;
            this.mRecyclerView.setAdapter(candidateSearchAdapter);
            registerListener(this.mDataResListener);
            registerListener(this.mVoteListener);
            this.mModel = new c.a.t0.c0.d.a(getPageContext());
            c.a.d.f.m.e.a().postDelayed(this.mShowKeyboardRunnable, 100L);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
            c.a.d.f.m.e.a().removeCallbacks(this.mShowKeyboardRunnable);
        }
    }

    public void setDelButtonVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.mButtonDel.setVisibility(z ? 0 : 8);
        }
    }
}

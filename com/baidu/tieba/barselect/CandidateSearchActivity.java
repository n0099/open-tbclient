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
import com.repackage.fi8;
import com.repackage.jg;
import com.repackage.ki;
import com.repackage.li;
import com.repackage.mg;
import com.repackage.nu5;
import com.repackage.wa;
import com.repackage.yu5;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class CandidateSearchActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<nu5> dataList;
    public CandidateSearchAdapter mAdapter;
    public TextView mButtonCancelSearch;
    public ImageView mButtonDel;
    public wa mDataResListener;
    public String mForumId;
    public yu5 mModel;
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

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CandidateSearchActivity a;

        public a(CandidateSearchActivity candidateSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {candidateSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = candidateSearchActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2.getId() != this.a.mButtonCancelSearch.getId()) {
                    if (view2.getId() == this.a.mButtonDel.getId()) {
                        this.a.mSearchbox.setText("");
                        this.a.mRecyclerView.setVisibility(0);
                        this.a.mNoDataView.setVisibility(8);
                        this.a.mAdapter.setData(new ArrayList());
                        return;
                    }
                    return;
                }
                this.a.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends wa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CandidateSearchActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(CandidateSearchActivity candidateSearchActivity, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {candidateSearchActivity, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = candidateSearchActivity;
        }

        @Override // com.repackage.wa
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            nu5 nu5Var = null;
            if (responsedMessage instanceof CandidateSearchHttpResMsg) {
                nu5Var = ((CandidateSearchHttpResMsg) responsedMessage).candidateData;
            } else if (responsedMessage instanceof CandidateSearchSocketResMsg) {
                nu5Var = ((CandidateSearchSocketResMsg) responsedMessage).candidateData;
            }
            if (responsedMessage.getError() != 0 || nu5Var == null) {
                this.a.mRecyclerView.setVisibility(8);
                this.a.mNoDataView.setVisibility(0);
                return;
            }
            this.a.mRecyclerView.setVisibility(0);
            this.a.mNoDataView.setVisibility(8);
            if (this.a.mSearchbox.getText() != null) {
                nu5Var.j = this.a.mSearchbox.getText().toString();
            }
            if (this.a.dataList != null) {
                this.a.dataList.clear();
            } else {
                this.a.dataList = new ArrayList();
            }
            this.a.dataList.add(nu5Var);
            this.a.mAdapter.setData(this.a.dataList);
        }
    }

    /* loaded from: classes3.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = candidateSearchActivity;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i, keyEvent)) == null) {
                if (i == 3) {
                    if (this.a.mSearchbox.getText() != null && !TextUtils.isEmpty(this.a.mSearchbox.getText().toString()) && !TextUtils.isEmpty(this.a.mForumId)) {
                        this.a.mModel.a(jg.e(this.a.mSearchbox.getText().toString(), 0), jg.g(this.a.mForumId, 0L));
                    }
                    return true;
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CandidateSearchActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(CandidateSearchActivity candidateSearchActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {candidateSearchActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                li.N(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f02e3);
                if (this.a.dataList != null) {
                    for (nu5 nu5Var : this.a.dataList) {
                        nu5Var.k = true;
                    }
                }
            } else if (error == 3250023) {
                fi8.b(error, "", null);
            } else if (error == 3250021) {
                if (httpResponsedMessage instanceof CommitVoteResMsg) {
                    fi8.a(error, ((CommitVoteResMsg) httpResponsedMessage).getTokenData(), null);
                }
            } else if (error != 3250002 && error != 3250004) {
                li.O(TbadkCoreApplication.getInst(), httpResponsedMessage.getErrorString());
            } else {
                BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                blockPopInfoData.block_info = ki.isEmpty(httpResponsedMessage.getErrorString()) ? TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f031c) : httpResponsedMessage.getErrorString();
                blockPopInfoData.ahead_info = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f031a);
                blockPopInfoData.ok_info = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f098e);
                blockPopInfoData.ahead_url = "http://tieba.baidu.com/mo/q/userappeal";
                AntiHelper.s(this.a, blockPopInfoData);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CandidateSearchActivity a;

        public e(CandidateSearchActivity candidateSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {candidateSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = candidateSearchActivity;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.a.setDelButtonVisible(!StringUtils.isNull(editable.toString()));
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CandidateSearchActivity a;

        public f(CandidateSearchActivity candidateSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {candidateSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = candidateSearchActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.mSearchbox == null) {
                return;
            }
            this.a.mSearchbox.requestFocus();
            CandidateSearchActivity candidateSearchActivity = this.a;
            li.M(candidateSearchActivity, candidateSearchActivity.mSearchbox);
        }
    }

    public CandidateSearchActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f0914f2);
            this.mNavigationBar = navigationBar;
            navigationBar.showBottomLine();
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.obfuscated_res_0x7f0d0170, (View.OnClickListener) null);
            this.mNavigationCustomView = addCustomView;
            this.mSearchIcon = (ImageView) addCustomView.findViewById(R.id.obfuscated_res_0x7f091c07);
            this.mSearchbox = (EditText) this.mNavigationCustomView.findViewById(R.id.obfuscated_res_0x7f090d32);
            ImageView imageView = (ImageView) this.mNavigationCustomView.findViewById(R.id.obfuscated_res_0x7f090d22);
            this.mButtonDel = imageView;
            imageView.setOnClickListener(this.mOnClickListener);
            this.mButtonCancelSearch = (TextView) this.mNavigationCustomView.findViewById(R.id.obfuscated_res_0x7f090d21);
            setDelButtonVisible(false);
            this.mButtonCancelSearch.setText(getString(R.string.obfuscated_res_0x7f0f0376));
            this.mButtonCancelSearch.setOnClickListener(this.mOnClickListener);
            this.mSearchbox.setOnEditorActionListener(this.mOnEditorActionListener);
            this.mSearchbox.addTextChangedListener(this.mTextWatcher);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            super.onChangeSkinType(i);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            SkinManager.setViewTextColor(this.mNoDataView, (int) R.color.CAM_X0109);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mSearchIcon, R.drawable.icon_pure_topbar_search44_svg, R.color.CAM_X0109, null);
            this.mSearchbox.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            SkinManager.setNavbarTitleColor(this.mSearchbox, R.color.CAM_X0105, R.color.s_navbar_title_color);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mButtonDel, R.drawable.obfuscated_res_0x7f0809aa, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SkinManager.setViewTextColor(this.mButtonCancelSearch, R.color.CAM_X0302, 1);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d002e);
            if (getIntent() != null) {
                this.mForumId = getIntent().getStringExtra("forum_id");
            }
            initNavigationBar();
            BdRecyclerView bdRecyclerView = (BdRecyclerView) findViewById(R.id.obfuscated_res_0x7f091a1b);
            this.mRecyclerView = bdRecyclerView;
            bdRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            this.mNoDataView = findViewById(R.id.obfuscated_res_0x7f091f2d);
            CandidateSearchAdapter candidateSearchAdapter = new CandidateSearchAdapter();
            this.mAdapter = candidateSearchAdapter;
            this.mRecyclerView.setAdapter(candidateSearchAdapter);
            registerListener(this.mDataResListener);
            registerListener(this.mVoteListener);
            this.mModel = new yu5(getPageContext());
            mg.a().postDelayed(this.mShowKeyboardRunnable, 100L);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
            mg.a().removeCallbacks(this.mShowKeyboardRunnable);
        }
    }

    public void setDelButtonVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.mButtonDel.setVisibility(z ? 0 : 8);
        }
    }
}

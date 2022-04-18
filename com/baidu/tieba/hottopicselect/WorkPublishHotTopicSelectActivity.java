package com.baidu.tieba.hottopicselect;

import android.content.Intent;
import android.graphics.drawable.Drawable;
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
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.WorkPublishHotTopicSelectActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.AutoChangeLineView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.suspended.SuspendedActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.StatusBarUtil;
import com.baidu.tieba.hottopicselect.HotTopicSelectModel;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.h95;
import com.repackage.mi;
import com.repackage.oi;
import com.repackage.p47;
import com.repackage.q47;
import com.repackage.r47;
import com.repackage.s47;
import com.repackage.vr4;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class WorkPublishHotTopicSelectActivity extends SuspendedActivity implements h95, HotTopicSelectModel.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView mClearView;
    public TextView mDoneText;
    public RelativeLayout mEditContainer;
    public HotTopicSelectModel mHotModel;
    public EditText mInputEdt;
    public AutoChangeLineView.b<String> mLabelTextprovider;
    public View mListCustomView;
    public ExpandableListView mLvNoSearch;
    public ViewGroup mMainLayout;
    public int mMaxSelected;
    public NoDataView mNoDataView;
    public s47 mNoSearchAdapter;
    public final ExpandableListView.OnChildClickListener mOnChildClickListener;
    public final View.OnClickListener mOnClickListener;
    public final ExpandableListView.OnGroupClickListener mOnGroupClickListener;
    public final AdapterView.OnItemClickListener mOnItemClickListener;
    public Intent mResultIntent;
    public final List<r47> mSearchList;
    public List<String> mSelectedList;
    public p47 mSuggestAdatper;
    public BdListView mSuggestView;
    public TextView mTopicText;
    public AutoChangeLineView mTopicView;
    public TextView mTopicViewNums;

    /* loaded from: classes3.dex */
    public class a implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WorkPublishHotTopicSelectActivity a;

        public a(WorkPublishHotTopicSelectActivity workPublishHotTopicSelectActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishHotTopicSelectActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = workPublishHotTopicSelectActivity;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                String obj = editable.toString();
                if (this.a.mSelectedList.size() >= this.a.mMaxSelected) {
                    editable.clear();
                    return;
                }
                if (obj == null || obj.trim().length() <= 0) {
                    this.a.afterDealText();
                } else {
                    this.a.mNoDataView.setVisibility(8);
                    this.a.mListCustomView.setVisibility(8);
                    this.a.showLoadingView();
                    this.a.mHotModel.M(obj);
                }
                this.a.setDelButtonVisible(!StringUtils.isNull(editable.toString()));
                this.a.setTopicTextViewColor();
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
    public class b implements AutoChangeLineView.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WorkPublishHotTopicSelectActivity a;

        public b(WorkPublishHotTopicSelectActivity workPublishHotTopicSelectActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishHotTopicSelectActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = workPublishHotTopicSelectActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.core.view.AutoChangeLineView.b
        /* renamed from: b */
        public CharSequence a(TextView textView, int i, String str) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textView, i, str)) == null) {
                Drawable pureDrawable = SvgManager.getInstance().getPureDrawable(R.drawable.obfuscated_res_0x7f080611, R.color.CAM_X0302, null);
                Drawable pureDrawable2 = SvgManager.getInstance().getPureDrawable(R.drawable.obfuscated_res_0x7f080606, R.color.CAM_X0302, null);
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds31);
                int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds21);
                pureDrawable.setBounds(0, 0, dimenPixelSize, dimenPixelSize);
                pureDrawable2.setBounds(0, 0, dimenPixelSize2, dimenPixelSize2);
                textView.setCompoundDrawablePadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
                textView.setCompoundDrawables(pureDrawable, null, pureDrawable2, null);
                String cutChineseAndEnglishWithEmoji = StringHelper.cutChineseAndEnglishWithEmoji(str, 16, StringHelper.STRING_MORE);
                vr4 d = vr4.d(textView);
                d.n(R.string.J_X01);
                d.l(R.dimen.L_X01);
                d.k(R.color.CAM_X0302);
                d.f(R.color.CAM_X0905);
                return cutChineseAndEnglishWithEmoji;
            }
            return (CharSequence) invokeLIL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements AutoChangeLineView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WorkPublishHotTopicSelectActivity a;

        public c(WorkPublishHotTopicSelectActivity workPublishHotTopicSelectActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishHotTopicSelectActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = workPublishHotTopicSelectActivity;
        }

        @Override // com.baidu.tbadk.core.view.AutoChangeLineView.c
        public void a(TextView textView, Object obj, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(1048576, this, textView, obj, i) == null) && (obj instanceof String)) {
                this.a.mSelectedList.remove(obj);
                this.a.mTopicViewNums.setText(String.format("(%d/%d)", Integer.valueOf(this.a.mSelectedList.size()), Integer.valueOf(this.a.mMaxSelected)));
                this.a.mTopicView.setLabels(this.a.mSelectedList, this.a.mLabelTextprovider);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WorkPublishHotTopicSelectActivity a;

        public d(WorkPublishHotTopicSelectActivity workPublishHotTopicSelectActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishHotTopicSelectActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = workPublishHotTopicSelectActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2 == this.a.mClearView) {
                    this.a.clearAllTextStatus();
                } else if (view2 == this.a.mDoneText) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921602, this.a.mSelectedList));
                    this.a.close();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WorkPublishHotTopicSelectActivity a;

        public e(WorkPublishHotTopicSelectActivity workPublishHotTopicSelectActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishHotTopicSelectActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = workPublishHotTopicSelectActivity;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            r47 r47Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) || (r47Var = (r47) ListUtils.getItem(this.a.mSuggestAdatper.d(), i)) == null) {
                return;
            }
            String b = r47Var.b();
            this.a.addTopicToView(b);
            this.a.addClickStats(b, 3);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements ExpandableListView.OnGroupClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WorkPublishHotTopicSelectActivity a;

        public f(WorkPublishHotTopicSelectActivity workPublishHotTopicSelectActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishHotTopicSelectActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = workPublishHotTopicSelectActivity;
        }

        @Override // android.widget.ExpandableListView.OnGroupClickListener
        public boolean onGroupClick(ExpandableListView expandableListView, View view2, int i, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{expandableListView, view2, Integer.valueOf(i), Long.valueOf(j)})) == null) {
                if (this.a.mLvNoSearch != null) {
                    this.a.mLvNoSearch.expandGroup(i);
                    return true;
                }
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class g implements ExpandableListView.OnChildClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WorkPublishHotTopicSelectActivity a;

        public g(WorkPublishHotTopicSelectActivity workPublishHotTopicSelectActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishHotTopicSelectActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = workPublishHotTopicSelectActivity;
        }

        @Override // android.widget.ExpandableListView.OnChildClickListener
        public boolean onChildClick(ExpandableListView expandableListView, View view2, int i, int i2, long j) {
            InterceptResult invokeCommon;
            r47 child;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{expandableListView, view2, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)})) == null) {
                if (this.a.mNoSearchAdapter == null || (child = this.a.mNoSearchAdapter.getChild(i, i2)) == null) {
                    return false;
                }
                String b = child.b();
                this.a.addTopicToView(b);
                q47 group = this.a.mNoSearchAdapter.getGroup(i);
                if (group != null) {
                    this.a.addClickStats(b, group.getType() == 0 ? 1 : 2);
                    return false;
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class h implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WorkPublishHotTopicSelectActivity a;

        public h(WorkPublishHotTopicSelectActivity workPublishHotTopicSelectActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishHotTopicSelectActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = workPublishHotTopicSelectActivity;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) || z) {
                return;
            }
            oi.w(this.a.getPageContext().getPageActivity(), view2);
        }
    }

    /* loaded from: classes3.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WorkPublishHotTopicSelectActivity a;

        public i(WorkPublishHotTopicSelectActivity workPublishHotTopicSelectActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishHotTopicSelectActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = workPublishHotTopicSelectActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.mSelectedList.size() < this.a.mMaxSelected) {
                return;
            }
            BdTopToast bdTopToast = new BdTopToast(this.a.getPageContext().getPageActivity());
            bdTopToast.i(false);
            bdTopToast.h(this.a.getString(R.string.obfuscated_res_0x7f0f140d));
            bdTopToast.j((ViewGroup) this.a.getPageContext().getPageActivity().findViewById(R.id.obfuscated_res_0x7f091dd2));
        }
    }

    /* loaded from: classes3.dex */
    public class j implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WorkPublishHotTopicSelectActivity a;

        public j(WorkPublishHotTopicSelectActivity workPublishHotTopicSelectActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishHotTopicSelectActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = workPublishHotTopicSelectActivity;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i, keyEvent)) == null) {
                if (i == 6) {
                    oi.L(this.a.getPageContext().getPageActivity(), textView);
                    if (TextUtils.isEmpty(this.a.getSearchKey())) {
                        return true;
                    }
                    WorkPublishHotTopicSelectActivity workPublishHotTopicSelectActivity = this.a;
                    workPublishHotTopicSelectActivity.addTopicToView(workPublishHotTopicSelectActivity.getSearchKey());
                    return true;
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    public WorkPublishHotTopicSelectActivity() {
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
        this.mSelectedList = new ArrayList();
        this.mMaxSelected = 3;
        this.mLabelTextprovider = new b(this);
        this.mOnClickListener = new d(this);
        this.mOnItemClickListener = new e(this);
        this.mOnGroupClickListener = new f(this);
        this.mOnChildClickListener = new g(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addClickStats(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65558, this, str, i2) == null) {
            StatisticItem statisticItem = new StatisticItem("c11665");
            statisticItem.param("obj_name", str);
            statisticItem.param("obj_locate", i2);
            TiebaStatic.log(statisticItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTopicToView(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, this, str) == null) {
            EditText editText = this.mInputEdt;
            if (editText != null && editText.hasFocus()) {
                oi.w(getPageContext().getPageActivity(), this.mInputEdt);
            }
            clearAllTextStatus();
            if (this.mSelectedList.contains(str)) {
                BdTopToast bdTopToast = new BdTopToast(this);
                bdTopToast.i(false);
                bdTopToast.h(getString(R.string.obfuscated_res_0x7f0f037a));
                bdTopToast.j((ViewGroup) findViewById(R.id.obfuscated_res_0x7f091dd2));
            } else if (this.mSelectedList.size() >= this.mMaxSelected) {
                BdTopToast bdTopToast2 = new BdTopToast(this);
                bdTopToast2.i(false);
                bdTopToast2.h(getString(R.string.obfuscated_res_0x7f0f140d));
                bdTopToast2.j((ViewGroup) findViewById(R.id.obfuscated_res_0x7f091dd2));
            } else {
                this.mSelectedList.add(str);
                this.mTopicViewNums.setText(String.format("(%d/%d)", Integer.valueOf(this.mSelectedList.size()), Integer.valueOf(this.mMaxSelected)));
                this.mTopicView.setLabels(this.mSelectedList, this.mLabelTextprovider);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afterDealText() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            this.mLvNoSearch.setVisibility(0);
            this.mSuggestView.setVisibility(8);
            this.mSuggestAdatper.b();
            s47 s47Var = this.mNoSearchAdapter;
            if (s47Var != null && !ListUtils.isEmpty(s47Var.f())) {
                this.mListCustomView.setVisibility(0);
                return;
            }
            showLoadingView();
            this.mHotModel.D();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAllTextStatus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, this) == null) {
            this.mHotModel.N("");
            this.mInputEdt.setText("");
        }
    }

    private r47 createSearchData(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, this, str)) == null) {
            r47 r47Var = new r47();
            r47Var.d(str);
            return r47Var;
        }
        return (r47) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSearchKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, this)) == null) {
            HotTopicSelectModel hotTopicSelectModel = this.mHotModel;
            String E = hotTopicSelectModel != null ? hotTopicSelectModel.E() : "";
            return E != null ? E : "";
        }
        return (String) invokeV.objValue;
    }

    private void initInputEdit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65564, this) == null) {
            EditText editText = (EditText) findViewById(R.id.obfuscated_res_0x7f091c35);
            this.mInputEdt = editText;
            editText.setCompoundDrawablePadding(oi.f(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070305));
            this.mInputEdt.setOnFocusChangeListener(new h(this));
            this.mInputEdt.setOnClickListener(new i(this));
            this.mInputEdt.setOnEditorActionListener(new j(this));
            this.mInputEdt.addTextChangedListener(new a(this));
            this.mInputEdt.requestFocus();
        }
    }

    private void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65565, this) == null) {
            this.mMainLayout = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f090ab0);
            this.mEditContainer = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0923a9);
            this.mTopicView = (AutoChangeLineView) findViewById(R.id.obfuscated_res_0x7f0920fa);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f092387);
            this.mTopicViewNums = textView;
            textView.setText(String.format("(%d/%d)", Integer.valueOf(this.mSelectedList.size()), Integer.valueOf(this.mMaxSelected)));
            this.mTopicText = (TextView) findViewById(R.id.obfuscated_res_0x7f09210e);
            this.mClearView = (ImageView) findViewById(R.id.obfuscated_res_0x7f09065c);
            this.mListCustomView = findViewById(R.id.obfuscated_res_0x7f090d8f);
            this.mSuggestView = (BdListView) findViewById(R.id.obfuscated_res_0x7f090d87);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f0702c2)), null, null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.mMainLayout.addView(this.mNoDataView, layoutParams);
            this.mNoDataView.setVisibility(8);
            p47 p47Var = new p47(getPageContext());
            this.mSuggestAdatper = p47Var;
            this.mSuggestView.setAdapter((ListAdapter) p47Var);
            this.mLvNoSearch = (ExpandableListView) findViewById(R.id.obfuscated_res_0x7f090d89);
            s47 s47Var = new s47(getPageContext());
            this.mNoSearchAdapter = s47Var;
            this.mLvNoSearch.setAdapter(s47Var);
            this.mSuggestView.setOnItemClickListener(this.mOnItemClickListener);
            this.mLvNoSearch.setOnGroupClickListener(this.mOnGroupClickListener);
            this.mLvNoSearch.setOnChildClickListener(this.mOnChildClickListener);
            this.mClearView.setOnClickListener(this.mOnClickListener);
            this.mDoneText.setOnClickListener(this.mOnClickListener);
            this.mTopicView.setOnLabelClickListener(new c(this));
            setDelButtonVisible(false);
            initInputEdit();
        }
    }

    private void parseAndDealData(q47 q47Var, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65566, this, q47Var, z) == null) || q47Var == null || ListUtils.isEmpty(q47Var.b())) {
            return;
        }
        if (TextUtils.isEmpty(q47Var.a())) {
            q47Var.e(getString(z ? R.string.obfuscated_res_0x7f0f07e4 : R.string.obfuscated_res_0x7f0f07e5));
        }
        this.mNoSearchAdapter.g(q47Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTopicTextViewColor() {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65567, this) == null) || (editText = this.mInputEdt) == null || this.mTopicText == null) {
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
        if (interceptable == null || interceptable.invokeV(65568, this) == null) {
            this.mListCustomView.setVisibility(8);
            showLoadingView(this.mMainLayout, false, getResources().getDimensionPixelSize(R.dimen.tbds320));
        }
    }

    @Override // com.repackage.h95
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mResultIntent : (Intent) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public h95 getSuspendedContentView(LinearLayout linearLayout, NavigationBar navigationBar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, linearLayout, navigationBar)) == null) {
            navigationBar.setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f1578));
            this.mDoneText = navigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(R.string.obfuscated_res_0x7f0f04e7));
            LayoutInflater.from(this).inflate(R.layout.obfuscated_res_0x7f0d03a9, (ViewGroup) linearLayout, true);
            return this;
        }
        return (h95) invokeLL.objValue;
    }

    @Override // com.repackage.h95
    public boolean isOnViewCancel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.h95
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
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mSkinType = i2;
            vr4.d(this.mDoneText).x(R.color.CAM_X0302);
            vr4.d(this.mTopicViewNums).v(R.color.CAM_X0107);
            vr4.d(findViewById(R.id.obfuscated_res_0x7f092386)).v(R.color.CAM_X0105);
            vr4.d(findViewById(R.id.obfuscated_res_0x7f0923aa)).v(R.color.CAM_X0105);
            vr4 d2 = vr4.d(this.mEditContainer);
            d2.n(R.string.J_X07);
            d2.f(R.color.CAM_X0209);
            this.mTopicView.setLabelTextColor(SkinManager.getColor(R.color.CAM_X0302));
            this.mTopicView.setLabels(this.mSelectedList, this.mLabelTextprovider);
            NoDataView noDataView = this.mNoDataView;
            if (noDataView != null) {
                noDataView.f(getPageContext(), i2);
            }
            p47 p47Var = this.mSuggestAdatper;
            if (p47Var != null) {
                p47Var.notifyDataSetChanged();
            }
            s47 s47Var = this.mNoSearchAdapter;
            if (s47Var != null) {
                s47Var.notifyDataSetChanged();
            }
            EditText editText = this.mInputEdt;
            if (editText != null) {
                editText.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
            }
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
            this.mMaxSelected = TbSingleton.getInstance().getWorksAddTopicMaxNum();
            HotTopicSelectModel hotTopicSelectModel = new HotTopicSelectModel(getPageContext(), this);
            this.mHotModel = hotTopicSelectModel;
            hotTopicSelectModel.H(getIntent());
            this.mHotModel.K();
            if (getIntent() != null) {
                ArrayList<String> stringArrayListExtra = getIntent().getStringArrayListExtra(WorkPublishHotTopicSelectActivityConfig.WORK_PUBLISH_TOPIC_LIST);
                this.mSelectedList = stringArrayListExtra;
                if (stringArrayListExtra == null) {
                    this.mSelectedList = new ArrayList();
                }
                int size = this.mSelectedList.size();
                int i2 = this.mMaxSelected;
                if (size > i2) {
                    this.mSelectedList = this.mSelectedList.subList(0, i2);
                }
            }
            initUI();
            this.mTopicView.setLabels(this.mSelectedList, this.mLabelTextprovider);
            getWindow().setSoftInputMode(1);
            showLoadingView();
            this.mHotModel.L();
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
            if (!mi.z()) {
                this.mNoDataView.setTextOption(NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0c17));
                this.mNoDataView.setVisibility(0);
            } else if (TextUtils.isEmpty(str)) {
            } else {
                this.mNoDataView.setTextOption(NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0f69));
                this.mNoDataView.setVisibility(0);
                showToast(str);
            }
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.c
    public void onHotSelectDataNoSearchSuccess(q47 q47Var, q47 q47Var2, q47 q47Var3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, q47Var, q47Var2, q47Var3) == null) {
            this.mListCustomView.setVisibility(0);
            this.mLvNoSearch.setVisibility(0);
            this.mSuggestView.setVisibility(8);
            hideLoadingView(this.mMainLayout);
            this.mNoSearchAdapter.c();
            parseAndDealData(q47Var, true);
            parseAndDealData(q47Var2, false);
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
            r47 createSearchData = createSearchData(searchKey);
            this.mSearchList.clear();
            this.mSearchList.add(createSearchData);
            this.mSuggestAdatper.e(searchKey, this.mSearchList);
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.c
    public void onHotSelectDataSearchSuccess(q47 q47Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, q47Var) == null) {
            this.mListCustomView.setVisibility(0);
            this.mLvNoSearch.setVisibility(8);
            this.mSuggestView.setVisibility(0);
            hideLoadingView(this.mMainLayout);
            this.mSearchList.clear();
            String searchKey = getSearchKey();
            this.mSearchList.add(createSearchData(searchKey));
            if (q47Var != null && q47Var.b() != null) {
                this.mSearchList.addAll(q47Var.b());
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

    @Override // com.repackage.h95
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

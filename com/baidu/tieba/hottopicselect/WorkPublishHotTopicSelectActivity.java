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
import c.a.e.e.p.l;
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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class WorkPublishHotTopicSelectActivity extends SuspendedActivity implements c.a.q0.x0.a, HotTopicSelectModel.c {
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
    public c.a.r0.k1.e mNoSearchAdapter;
    public final ExpandableListView.OnChildClickListener mOnChildClickListener;
    public final View.OnClickListener mOnClickListener;
    public final ExpandableListView.OnGroupClickListener mOnGroupClickListener;
    public final AdapterView.OnItemClickListener mOnItemClickListener;
    public Intent mResultIntent;
    public final List<c.a.r0.k1.d> mSearchList;
    public List<String> mSelectedList;
    public c.a.r0.k1.b mSuggestAdatper;
    public BdListView mSuggestView;
    public TextView mTopicText;
    public AutoChangeLineView mTopicView;
    public TextView mTopicViewNums;

    /* loaded from: classes7.dex */
    public class a implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishHotTopicSelectActivity f52877e;

        public a(WorkPublishHotTopicSelectActivity workPublishHotTopicSelectActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishHotTopicSelectActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52877e = workPublishHotTopicSelectActivity;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                String obj = editable.toString();
                if (this.f52877e.mSelectedList.size() >= this.f52877e.mMaxSelected) {
                    editable.clear();
                    return;
                }
                if (obj == null || obj.trim().length() <= 0) {
                    this.f52877e.afterDealText();
                } else {
                    this.f52877e.mNoDataView.setVisibility(8);
                    this.f52877e.mListCustomView.setVisibility(8);
                    this.f52877e.showLoadingView();
                    this.f52877e.mHotModel.K(obj);
                }
                this.f52877e.setDelButtonVisible(!StringUtils.isNull(editable.toString()));
                this.f52877e.setTopicTextViewColor();
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

    /* loaded from: classes7.dex */
    public class b implements AutoChangeLineView.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WorkPublishHotTopicSelectActivity f52878a;

        public b(WorkPublishHotTopicSelectActivity workPublishHotTopicSelectActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishHotTopicSelectActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52878a = workPublishHotTopicSelectActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.core.view.AutoChangeLineView.b
        /* renamed from: b */
        public CharSequence a(TextView textView, int i2, String str) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textView, i2, str)) == null) {
                Drawable pureDrawable = SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_post_topic12, R.color.CAM_X0302, null);
                Drawable pureDrawable2 = SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_interested_close12, R.color.CAM_X0302, null);
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds31);
                int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds21);
                pureDrawable.setBounds(0, 0, dimenPixelSize, dimenPixelSize);
                pureDrawable2.setBounds(0, 0, dimenPixelSize2, dimenPixelSize2);
                textView.setCompoundDrawablePadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
                textView.setCompoundDrawables(pureDrawable, null, pureDrawable2, null);
                String cutChineseAndEnglishWithEmoji = StringHelper.cutChineseAndEnglishWithEmoji(str, 16, "...");
                c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(textView);
                d2.n(R.string.J_X01);
                d2.l(R.dimen.L_X01);
                d2.k(R.color.CAM_X0302);
                d2.f(R.color.CAM_X0905);
                return cutChineseAndEnglishWithEmoji;
            }
            return (CharSequence) invokeLIL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements AutoChangeLineView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishHotTopicSelectActivity f52879e;

        public c(WorkPublishHotTopicSelectActivity workPublishHotTopicSelectActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishHotTopicSelectActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52879e = workPublishHotTopicSelectActivity;
        }

        @Override // com.baidu.tbadk.core.view.AutoChangeLineView.c
        public void onLabelClick(TextView textView, Object obj, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(1048576, this, textView, obj, i2) == null) && (obj instanceof String)) {
                this.f52879e.mSelectedList.remove(obj);
                this.f52879e.mTopicViewNums.setText(String.format("(%d/%d)", Integer.valueOf(this.f52879e.mSelectedList.size()), Integer.valueOf(this.f52879e.mMaxSelected)));
                this.f52879e.mTopicView.setLabels(this.f52879e.mSelectedList, this.f52879e.mLabelTextprovider);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishHotTopicSelectActivity f52880e;

        public d(WorkPublishHotTopicSelectActivity workPublishHotTopicSelectActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishHotTopicSelectActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52880e = workPublishHotTopicSelectActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f52880e.mClearView) {
                    this.f52880e.clearAllTextStatus();
                } else if (view == this.f52880e.mDoneText) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921602, this.f52880e.mSelectedList));
                    this.f52880e.close();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishHotTopicSelectActivity f52881e;

        public e(WorkPublishHotTopicSelectActivity workPublishHotTopicSelectActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishHotTopicSelectActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52881e = workPublishHotTopicSelectActivity;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            c.a.r0.k1.d dVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || (dVar = (c.a.r0.k1.d) ListUtils.getItem(this.f52881e.mSuggestAdatper.d(), i2)) == null) {
                return;
            }
            String b2 = dVar.b();
            this.f52881e.addTopicToView(b2);
            this.f52881e.addClickStats(b2, 3);
        }
    }

    /* loaded from: classes7.dex */
    public class f implements ExpandableListView.OnGroupClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WorkPublishHotTopicSelectActivity f52882a;

        public f(WorkPublishHotTopicSelectActivity workPublishHotTopicSelectActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishHotTopicSelectActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52882a = workPublishHotTopicSelectActivity;
        }

        @Override // android.widget.ExpandableListView.OnGroupClickListener
        public boolean onGroupClick(ExpandableListView expandableListView, View view, int i2, long j2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{expandableListView, view, Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
                if (this.f52882a.mLvNoSearch != null) {
                    this.f52882a.mLvNoSearch.expandGroup(i2);
                    return true;
                }
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class g implements ExpandableListView.OnChildClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishHotTopicSelectActivity f52883e;

        public g(WorkPublishHotTopicSelectActivity workPublishHotTopicSelectActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishHotTopicSelectActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52883e = workPublishHotTopicSelectActivity;
        }

        @Override // android.widget.ExpandableListView.OnChildClickListener
        public boolean onChildClick(ExpandableListView expandableListView, View view, int i2, int i3, long j2) {
            InterceptResult invokeCommon;
            c.a.r0.k1.d child;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{expandableListView, view, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)})) == null) {
                if (this.f52883e.mNoSearchAdapter == null || (child = this.f52883e.mNoSearchAdapter.getChild(i2, i3)) == null) {
                    return false;
                }
                String b2 = child.b();
                this.f52883e.addTopicToView(b2);
                c.a.r0.k1.c group = this.f52883e.mNoSearchAdapter.getGroup(i2);
                if (group != null) {
                    this.f52883e.addClickStats(b2, group.d() == 0 ? 1 : 2);
                    return false;
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class h implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishHotTopicSelectActivity f52884e;

        public h(WorkPublishHotTopicSelectActivity workPublishHotTopicSelectActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishHotTopicSelectActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52884e = workPublishHotTopicSelectActivity;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) || z) {
                return;
            }
            l.x(this.f52884e.getPageContext().getPageActivity(), view);
        }
    }

    /* loaded from: classes7.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishHotTopicSelectActivity f52885e;

        public i(WorkPublishHotTopicSelectActivity workPublishHotTopicSelectActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishHotTopicSelectActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52885e = workPublishHotTopicSelectActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f52885e.mSelectedList.size() < this.f52885e.mMaxSelected) {
                return;
            }
            new BdTopToast(this.f52885e.getPageContext().getPageActivity()).setIcon(false).setContent(this.f52885e.getString(R.string.topic_num_already_max)).show((ViewGroup) this.f52885e.getPageContext().getPageActivity().findViewById(R.id.suspend_root_view));
        }
    }

    /* loaded from: classes7.dex */
    public class j implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WorkPublishHotTopicSelectActivity f52886a;

        public j(WorkPublishHotTopicSelectActivity workPublishHotTopicSelectActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishHotTopicSelectActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52886a = workPublishHotTopicSelectActivity;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i2, keyEvent)) == null) {
                if (i2 == 6) {
                    l.K(this.f52886a.getPageContext().getPageActivity(), textView);
                    if (TextUtils.isEmpty(this.f52886a.getSearchKey())) {
                        return true;
                    }
                    WorkPublishHotTopicSelectActivity workPublishHotTopicSelectActivity = this.f52886a;
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
                l.x(getPageContext().getPageActivity(), this.mInputEdt);
            }
            clearAllTextStatus();
            if (this.mSelectedList.contains(str)) {
                new BdTopToast(this).setIcon(false).setContent(getString(R.string.cant_repeat_select_topic)).show((ViewGroup) findViewById(R.id.suspend_root_view));
            } else if (this.mSelectedList.size() >= this.mMaxSelected) {
                new BdTopToast(this).setIcon(false).setContent(getString(R.string.topic_num_already_max)).show((ViewGroup) findViewById(R.id.suspend_root_view));
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
            c.a.r0.k1.e eVar = this.mNoSearchAdapter;
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
        if (interceptable == null || interceptable.invokeV(65561, this) == null) {
            this.mHotModel.L("");
            this.mInputEdt.setText("");
        }
    }

    private c.a.r0.k1.d createSearchData(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, this, str)) == null) {
            c.a.r0.k1.d dVar = new c.a.r0.k1.d();
            dVar.d(str);
            return dVar;
        }
        return (c.a.r0.k1.d) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSearchKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, this)) == null) {
            HotTopicSelectModel hotTopicSelectModel = this.mHotModel;
            String C = hotTopicSelectModel != null ? hotTopicSelectModel.C() : "";
            return C != null ? C : "";
        }
        return (String) invokeV.objValue;
    }

    private void initInputEdit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65564, this) == null) {
            EditText editText = (EditText) findViewById(R.id.search_root);
            this.mInputEdt = editText;
            editText.setCompoundDrawablePadding(l.g(getPageContext().getPageActivity(), R.dimen.ds8));
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
            this.mMainLayout = (ViewGroup) findViewById(R.id.frame_main_view);
            this.mEditContainer = (RelativeLayout) findViewById(R.id.view_make_topic_self_edit_container);
            this.mTopicView = (AutoChangeLineView) findViewById(R.id.topic_select_view);
            TextView textView = (TextView) findViewById(R.id.view_add_topic_title_nums);
            this.mTopicViewNums = textView;
            textView.setText(String.format("(%d/%d)", Integer.valueOf(this.mSelectedList.size()), Integer.valueOf(this.mMaxSelected)));
            this.mTopicText = (TextView) findViewById(R.id.topic_text);
            this.mClearView = (ImageView) findViewById(R.id.clear_right_img);
            this.mListCustomView = findViewById(R.id.home_search_list);
            this.mSuggestView = (BdListView) findViewById(R.id.home_lv_search_suggest);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds420)), null, null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.mMainLayout.addView(this.mNoDataView, layoutParams);
            this.mNoDataView.setVisibility(8);
            c.a.r0.k1.b bVar = new c.a.r0.k1.b(getPageContext());
            this.mSuggestAdatper = bVar;
            this.mSuggestView.setAdapter((ListAdapter) bVar);
            this.mLvNoSearch = (ExpandableListView) findViewById(R.id.home_no_search_listview);
            c.a.r0.k1.e eVar = new c.a.r0.k1.e(getPageContext());
            this.mNoSearchAdapter = eVar;
            this.mLvNoSearch.setAdapter(eVar);
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

    private void parseAndDealData(c.a.r0.k1.c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65566, this, cVar, z) == null) || cVar == null || ListUtils.isEmpty(cVar.b())) {
            return;
        }
        if (TextUtils.isEmpty(cVar.a())) {
            cVar.f(getString(z ? R.string.group_topic_default : R.string.group_topic_hot));
        }
        this.mNoSearchAdapter.g(cVar);
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

    @Override // c.a.q0.x0.a
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mResultIntent : (Intent) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public c.a.q0.x0.a getSuspendedContentView(LinearLayout linearLayout, NavigationBar navigationBar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, linearLayout, navigationBar)) == null) {
            navigationBar.setCenterTextTitle(getString(R.string.work_publish_topic_title));
            this.mDoneText = navigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(R.string.done));
            LayoutInflater.from(this).inflate(R.layout.hot_select_work_publish, (ViewGroup) linearLayout, true);
            return this;
        }
        return (c.a.q0.x0.a) invokeLL.objValue;
    }

    @Override // c.a.q0.x0.a
    public boolean isOnViewCancel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.q0.x0.a
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
            c.a.q0.s.u.c.d(this.mDoneText).x(R.color.CAM_X0302);
            c.a.q0.s.u.c.d(this.mTopicViewNums).v(R.color.CAM_X0107);
            c.a.q0.s.u.c.d(findViewById(R.id.view_add_topic_title)).v(R.color.CAM_X0105);
            c.a.q0.s.u.c.d(findViewById(R.id.view_make_topic_self_title)).v(R.color.CAM_X0105);
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(this.mEditContainer);
            d2.n(R.string.J_X07);
            d2.f(R.color.CAM_X0209);
            this.mTopicView.setLabelTextColor(SkinManager.getColor(R.color.CAM_X0302));
            this.mTopicView.setLabels(this.mSelectedList, this.mLabelTextprovider);
            NoDataView noDataView = this.mNoDataView;
            if (noDataView != null) {
                noDataView.onChangeSkinType(getPageContext(), i2);
            }
            c.a.r0.k1.b bVar = this.mSuggestAdatper;
            if (bVar != null) {
                bVar.notifyDataSetChanged();
            }
            c.a.r0.k1.e eVar = this.mNoSearchAdapter;
            if (eVar != null) {
                eVar.notifyDataSetChanged();
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
            hotTopicSelectModel.F(getIntent());
            this.mHotModel.I();
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
            this.mHotModel.J();
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.mHotModel.onDestroy();
            this.mNoDataView.onActivityStop();
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
            if (!c.a.e.e.p.j.z()) {
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
    public void onHotSelectDataNoSearchSuccess(c.a.r0.k1.c cVar, c.a.r0.k1.c cVar2, c.a.r0.k1.c cVar3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, cVar, cVar2, cVar3) == null) {
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
            c.a.r0.k1.d createSearchData = createSearchData(searchKey);
            this.mSearchList.clear();
            this.mSearchList.add(createSearchData);
            this.mSuggestAdatper.e(searchKey, this.mSearchList);
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.c
    public void onHotSelectDataSearchSuccess(c.a.r0.k1.c cVar) {
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
                noDataView.onActivityStop();
            }
        }
    }

    @Override // c.a.q0.x0.a
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

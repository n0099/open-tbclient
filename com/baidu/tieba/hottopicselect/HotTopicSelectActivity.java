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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.suspended.SuspendedActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.StatusBarUtil;
import com.baidu.tieba.hottopicselect.HotTopicSelectModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class HotTopicSelectActivity extends SuspendedActivity implements com.baidu.tbadk.suspended.a, HotTopicSelectModel.a {
    private Intent gcE;
    private TextView juV;
    private HotTopicSelectModel kqQ;
    private View kqS;
    private BdListView kqT;
    private ExpandableListView kqU;
    private e kqV;
    private b kqW;
    private ViewGroup kqX;
    private EditText kqY;
    private ImageView kqZ;
    private TextView kra;
    private NoDataView mNoDataView;
    private final List<d> kqR = new ArrayList();
    final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == HotTopicSelectActivity.this.kqZ) {
                HotTopicSelectActivity.this.cRU();
            } else if (view == HotTopicSelectActivity.this.juV) {
                HotTopicSelectActivity.this.Lw("");
            }
        }
    };
    final AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            d dVar = (d) x.getItem(HotTopicSelectActivity.this.kqW.getList(), i);
            if (dVar != null) {
                String topicName = dVar.getTopicName();
                HotTopicSelectActivity.this.Lw(topicName);
                HotTopicSelectActivity.this.bf(topicName, 3);
            }
        }
    };
    final ExpandableListView.OnGroupClickListener krb = new ExpandableListView.OnGroupClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.3
        @Override // android.widget.ExpandableListView.OnGroupClickListener
        public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
            if (HotTopicSelectActivity.this.kqU != null) {
                HotTopicSelectActivity.this.kqU.expandGroup(i);
                return true;
            }
            return true;
        }
    };
    final ExpandableListView.OnChildClickListener krc = new ExpandableListView.OnChildClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.4
        @Override // android.widget.ExpandableListView.OnChildClickListener
        public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
            d child;
            if (HotTopicSelectActivity.this.kqV != null && (child = HotTopicSelectActivity.this.kqV.getChild(i, i2)) != null) {
                String topicName = child.getTopicName();
                HotTopicSelectActivity.this.Lw(topicName);
                c group = HotTopicSelectActivity.this.kqV.getGroup(i);
                if (group != null) {
                    HotTopicSelectActivity.this.bf(topicName, group.getType() == 0 ? 1 : 2);
                    return false;
                }
                return false;
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kqQ = new HotTopicSelectModel(getPageContext(), this);
        this.kqQ.W(getIntent());
        this.kqQ.cSe();
        initUI();
        getWindow().setSoftInputMode(1);
        showLoadingView();
        this.kqQ.cSa();
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    protected com.baidu.tbadk.suspended.a a(LinearLayout linearLayout, NavigationBar navigationBar) {
        LayoutInflater.from(this).inflate(R.layout.hot_navigation_view_layout, (ViewGroup) navigationBar.getContentLayout(), true);
        this.bUf.setVisibility(8);
        LayoutInflater.from(this).inflate(R.layout.hot_select_main, (ViewGroup) linearLayout, true);
        return this;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bEp() {
        ListView listView;
        View childAt;
        if (this.kqT.getVisibility() == 0) {
            listView = this.kqT;
        } else {
            listView = this.kqU;
        }
        return listView != null && listView.getFirstVisiblePosition() == 0 && (childAt = listView.getChildAt(0)) != null && childAt.getTop() == 0;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bEq() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void rs(int i) {
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bEr() {
        return this.gcE;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    protected void bEv() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.kqS.setVisibility(8);
        showLoadingView(this.kqX, true, getResources().getDimensionPixelSize(R.dimen.ds320));
    }

    private void initUI() {
        this.kqX = (ViewGroup) findViewById(R.id.frame_main_view);
        this.juV = (TextView) findViewById(R.id.btn_confirm);
        this.kra = (TextView) findViewById(R.id.topic_text);
        this.kqZ = (ImageView) findViewById(R.id.clear_right_img);
        this.kqS = findViewById(R.id.home_search_list);
        this.kqT = (BdListView) findViewById(R.id.home_lv_search_suggest);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds420)), null, null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.kqX.addView(this.mNoDataView, layoutParams);
        this.mNoDataView.setVisibility(8);
        this.kqW = new b(getPageContext());
        this.kqT.setAdapter((ListAdapter) this.kqW);
        this.kqU = (ExpandableListView) findViewById(R.id.home_no_search_listview);
        this.kqV = new e(getPageContext());
        this.kqU.setAdapter(this.kqV);
        this.kqT.setOnItemClickListener(this.mOnItemClickListener);
        this.kqU.setOnGroupClickListener(this.krb);
        this.kqU.setOnChildClickListener(this.krc);
        this.juV.setOnClickListener(this.mOnClickListener);
        this.kqZ.setOnClickListener(this.mOnClickListener);
        pe(false);
        cRW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bf(String str, int i) {
        aq aqVar = new aq("c11665");
        aqVar.dW("obj_name", str);
        aqVar.an("obj_locate", i);
        TiebaStatic.log(aqVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String czV() {
        String czV = this.kqQ != null ? this.kqQ.czV() : "";
        return czV != null ? czV : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRU() {
        this.kqQ.LB("");
        this.kqY.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRV() {
        this.kqU.setVisibility(0);
        this.kqT.setVisibility(8);
        this.kqW.clearList();
        if (this.kqV != null && !x.isEmpty(this.kqV.getList())) {
            this.kqS.setVisibility(0);
            return;
        }
        showLoadingView();
        this.kqQ.getCacheData();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        Lw("");
        super.onBackPressed();
    }

    private void cRW() {
        this.kqY = (EditText) findViewById(R.id.search_root);
        this.kqY.setCompoundDrawablePadding(l.getDimens(getPageContext().getPageActivity(), R.dimen.ds8));
        this.kqY.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(HotTopicSelectActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.kqY.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6) {
                    l.showSoftKeyPad(HotTopicSelectActivity.this.getPageContext().getPageActivity(), textView);
                    if (!TextUtils.isEmpty(HotTopicSelectActivity.this.czV())) {
                        HotTopicSelectActivity.this.Lw(HotTopicSelectActivity.this.czV());
                    }
                    return true;
                }
                return false;
            }
        });
        this.kqY.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.7
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (obj == null || obj.trim().length() <= 0) {
                    HotTopicSelectActivity.this.cRV();
                } else {
                    HotTopicSelectActivity.this.mNoDataView.setVisibility(8);
                    HotTopicSelectActivity.this.kqS.setVisibility(8);
                    HotTopicSelectActivity.this.showLoadingView();
                    HotTopicSelectActivity.this.kqQ.LA(obj);
                }
                HotTopicSelectActivity.this.pe(!StringUtils.isNull(editable.toString()));
                HotTopicSelectActivity.this.cRX();
            }
        });
        this.kqY.requestFocus();
    }

    public void pe(boolean z) {
        this.kqZ.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRX() {
        if (this.kqY != null && this.kra != null) {
            if (TextUtils.isEmpty(this.kqY.getText())) {
                ao.setViewTextColor(this.kra, R.color.CAM_X0109, 1);
            } else {
                ao.setViewTextColor(this.kra, R.color.CAM_X0105, 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lw(String str) {
        if (this.kqY != null && this.kqY.hasFocus()) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.kqY);
        }
        if (TextUtils.isEmpty(str)) {
            setResult(0, new Intent());
        } else {
            this.gcE = new Intent();
            this.gcE.putExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING, str + HotSelectActivityConfig.HOT_TOPIC_SING);
        }
        finish();
    }

    private d Lx(String str) {
        d dVar = new d();
        dVar.setTopicName(str);
        return dVar;
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void Ly(String str) {
        hideLoadingView(this.kqX);
        this.kqS.setVisibility(8);
        if (!j.isNetWorkAvailable()) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.pu(R.string.neterror));
            this.mNoDataView.setVisibility(0);
        } else if (!TextUtils.isEmpty(str)) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.pu(R.string.refresh_view_title_text));
            this.mNoDataView.setVisibility(0);
            showToast(str);
        }
    }

    private void a(c cVar, boolean z) {
        if (cVar != null && !x.isEmpty(cVar.getList())) {
            if (TextUtils.isEmpty(cVar.cRY())) {
                cVar.setTitle(getString(z ? R.string.group_topic_default : R.string.group_topic_hot));
            }
            this.kqV.b(cVar);
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void a(c cVar, c cVar2) {
        this.kqS.setVisibility(0);
        this.kqU.setVisibility(0);
        this.kqT.setVisibility(8);
        hideLoadingView(this.kqX);
        this.kqV.clearList();
        a(cVar, true);
        a(cVar2, false);
        this.kqV.notifyDataSetChanged();
        int count = this.kqU.getCount();
        for (int i = 0; i < count; i++) {
            this.kqU.expandGroup(i);
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void Lz(String str) {
        this.kqS.setVisibility(0);
        this.kqU.setVisibility(8);
        this.kqT.setVisibility(0);
        hideLoadingView(this.kqX);
        String czV = czV();
        d Lx = Lx(czV);
        this.kqR.clear();
        this.kqR.add(Lx);
        this.kqW.j(czV, this.kqR);
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void a(c cVar) {
        this.kqS.setVisibility(0);
        this.kqU.setVisibility(8);
        this.kqT.setVisibility(0);
        hideLoadingView(this.kqX);
        this.kqR.clear();
        String czV = czV();
        this.kqR.add(Lx(czV));
        if (cVar == null || cVar.getList() == null) {
            this.kqW.j(czV, this.kqR);
            return;
        }
        this.kqR.addAll(cVar.getList());
        this.kqW.j(czV, this.kqR);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        setSkinType(3);
        if (this.mNoDataView != null) {
            this.mNoDataView.btD();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.kqW != null) {
            this.kqW.notifyDataSetChanged();
        }
        if (this.kqV != null) {
            this.kqV.notifyDataSetChanged();
        }
        if (this.kqY != null) {
            this.kqY.setHintTextColor(ao.getColor(R.color.CAM_X0109));
        }
        ao.setViewTextColor(this.juV, R.color.CAM_X0302, 1);
        ao.setViewTextColor(this.kqY, R.color.CAM_X0105, 2);
        ao.setImageResource(this.kqZ, R.drawable.del_search_btn);
        cRX();
        if (this.mSkinType == 2) {
            StatusBarUtil.from(getPageContext().getPageActivity()).setTransparentStatusbar(true).setLightStatusBar(true).process();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.kqQ.onDestroy();
        this.mNoDataView.btD();
        hideLoadingView(this.kqX);
        super.onDestroy();
    }
}

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
/* loaded from: classes8.dex */
public class HotTopicSelectActivity extends SuspendedActivity implements com.baidu.tbadk.suspended.a, HotTopicSelectModel.a {
    private Intent ghm;
    private TextView jzB;
    private e kvA;
    private b kvB;
    private ViewGroup kvC;
    private EditText kvD;
    private ImageView kvE;
    private TextView kvF;
    private HotTopicSelectModel kvv;
    private View kvx;
    private BdListView kvy;
    private ExpandableListView kvz;
    private NoDataView mNoDataView;
    private final List<d> kvw = new ArrayList();
    final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == HotTopicSelectActivity.this.kvE) {
                HotTopicSelectActivity.this.cVM();
            } else if (view == HotTopicSelectActivity.this.jzB) {
                HotTopicSelectActivity.this.ME("");
            }
        }
    };
    final AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            d dVar = (d) x.getItem(HotTopicSelectActivity.this.kvB.getList(), i);
            if (dVar != null) {
                String topicName = dVar.getTopicName();
                HotTopicSelectActivity.this.ME(topicName);
                HotTopicSelectActivity.this.bf(topicName, 3);
            }
        }
    };
    final ExpandableListView.OnGroupClickListener kvG = new ExpandableListView.OnGroupClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.3
        @Override // android.widget.ExpandableListView.OnGroupClickListener
        public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
            if (HotTopicSelectActivity.this.kvz != null) {
                HotTopicSelectActivity.this.kvz.expandGroup(i);
                return true;
            }
            return true;
        }
    };
    final ExpandableListView.OnChildClickListener kvH = new ExpandableListView.OnChildClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.4
        @Override // android.widget.ExpandableListView.OnChildClickListener
        public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
            d child;
            if (HotTopicSelectActivity.this.kvA != null && (child = HotTopicSelectActivity.this.kvA.getChild(i, i2)) != null) {
                String topicName = child.getTopicName();
                HotTopicSelectActivity.this.ME(topicName);
                c group = HotTopicSelectActivity.this.kvA.getGroup(i);
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
        this.kvv = new HotTopicSelectModel(getPageContext(), this);
        this.kvv.W(getIntent());
        this.kvv.cVW();
        initUI();
        getWindow().setSoftInputMode(1);
        showLoadingView();
        this.kvv.cVS();
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    protected com.baidu.tbadk.suspended.a a(LinearLayout linearLayout, NavigationBar navigationBar) {
        LayoutInflater.from(this).inflate(R.layout.hot_navigation_view_layout, (ViewGroup) navigationBar.getContentLayout(), true);
        this.bYR.setVisibility(8);
        LayoutInflater.from(this).inflate(R.layout.hot_select_main, (ViewGroup) linearLayout, true);
        return this;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bIh() {
        ListView listView;
        View childAt;
        if (this.kvy.getVisibility() == 0) {
            listView = this.kvy;
        } else {
            listView = this.kvz;
        }
        return listView != null && listView.getFirstVisiblePosition() == 0 && (childAt = listView.getChildAt(0)) != null && childAt.getTop() == 0;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bIi() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void sY(int i) {
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bIj() {
        return this.ghm;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    protected void bIn() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.kvx.setVisibility(8);
        showLoadingView(this.kvC, true, getResources().getDimensionPixelSize(R.dimen.ds320));
    }

    private void initUI() {
        this.kvC = (ViewGroup) findViewById(R.id.frame_main_view);
        this.jzB = (TextView) findViewById(R.id.btn_confirm);
        this.kvF = (TextView) findViewById(R.id.topic_text);
        this.kvE = (ImageView) findViewById(R.id.clear_right_img);
        this.kvx = findViewById(R.id.home_search_list);
        this.kvy = (BdListView) findViewById(R.id.home_lv_search_suggest);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds420)), null, null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.kvC.addView(this.mNoDataView, layoutParams);
        this.mNoDataView.setVisibility(8);
        this.kvB = new b(getPageContext());
        this.kvy.setAdapter((ListAdapter) this.kvB);
        this.kvz = (ExpandableListView) findViewById(R.id.home_no_search_listview);
        this.kvA = new e(getPageContext());
        this.kvz.setAdapter(this.kvA);
        this.kvy.setOnItemClickListener(this.mOnItemClickListener);
        this.kvz.setOnGroupClickListener(this.kvG);
        this.kvz.setOnChildClickListener(this.kvH);
        this.jzB.setOnClickListener(this.mOnClickListener);
        this.kvE.setOnClickListener(this.mOnClickListener);
        pi(false);
        cVO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bf(String str, int i) {
        aq aqVar = new aq("c11665");
        aqVar.dX("obj_name", str);
        aqVar.an("obj_locate", i);
        TiebaStatic.log(aqVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cDN() {
        String cDN = this.kvv != null ? this.kvv.cDN() : "";
        return cDN != null ? cDN : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVM() {
        this.kvv.MJ("");
        this.kvD.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVN() {
        this.kvz.setVisibility(0);
        this.kvy.setVisibility(8);
        this.kvB.clearList();
        if (this.kvA != null && !x.isEmpty(this.kvA.getList())) {
            this.kvx.setVisibility(0);
            return;
        }
        showLoadingView();
        this.kvv.getCacheData();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        ME("");
        super.onBackPressed();
    }

    private void cVO() {
        this.kvD = (EditText) findViewById(R.id.search_root);
        this.kvD.setCompoundDrawablePadding(l.getDimens(getPageContext().getPageActivity(), R.dimen.ds8));
        this.kvD.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(HotTopicSelectActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.kvD.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6) {
                    l.showSoftKeyPad(HotTopicSelectActivity.this.getPageContext().getPageActivity(), textView);
                    if (!TextUtils.isEmpty(HotTopicSelectActivity.this.cDN())) {
                        HotTopicSelectActivity.this.ME(HotTopicSelectActivity.this.cDN());
                    }
                    return true;
                }
                return false;
            }
        });
        this.kvD.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.7
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
                    HotTopicSelectActivity.this.cVN();
                } else {
                    HotTopicSelectActivity.this.mNoDataView.setVisibility(8);
                    HotTopicSelectActivity.this.kvx.setVisibility(8);
                    HotTopicSelectActivity.this.showLoadingView();
                    HotTopicSelectActivity.this.kvv.MI(obj);
                }
                HotTopicSelectActivity.this.pi(!StringUtils.isNull(editable.toString()));
                HotTopicSelectActivity.this.cVP();
            }
        });
        this.kvD.requestFocus();
    }

    public void pi(boolean z) {
        this.kvE.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVP() {
        if (this.kvD != null && this.kvF != null) {
            if (TextUtils.isEmpty(this.kvD.getText())) {
                ao.setViewTextColor(this.kvF, R.color.CAM_X0109, 1);
            } else {
                ao.setViewTextColor(this.kvF, R.color.CAM_X0105, 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ME(String str) {
        if (this.kvD != null && this.kvD.hasFocus()) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.kvD);
        }
        if (TextUtils.isEmpty(str)) {
            setResult(0, new Intent());
        } else {
            this.ghm = new Intent();
            this.ghm.putExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING, str + HotSelectActivityConfig.HOT_TOPIC_SING);
        }
        finish();
    }

    private d MF(String str) {
        d dVar = new d();
        dVar.setTopicName(str);
        return dVar;
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void MG(String str) {
        hideLoadingView(this.kvC);
        this.kvx.setVisibility(8);
        if (!j.isNetWorkAvailable()) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.ra(R.string.neterror));
            this.mNoDataView.setVisibility(0);
        } else if (!TextUtils.isEmpty(str)) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.ra(R.string.refresh_view_title_text));
            this.mNoDataView.setVisibility(0);
            showToast(str);
        }
    }

    private void a(c cVar, boolean z) {
        if (cVar != null && !x.isEmpty(cVar.getList())) {
            if (TextUtils.isEmpty(cVar.cVQ())) {
                cVar.setTitle(getString(z ? R.string.group_topic_default : R.string.group_topic_hot));
            }
            this.kvA.b(cVar);
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void a(c cVar, c cVar2) {
        this.kvx.setVisibility(0);
        this.kvz.setVisibility(0);
        this.kvy.setVisibility(8);
        hideLoadingView(this.kvC);
        this.kvA.clearList();
        a(cVar, true);
        a(cVar2, false);
        this.kvA.notifyDataSetChanged();
        int count = this.kvz.getCount();
        for (int i = 0; i < count; i++) {
            this.kvz.expandGroup(i);
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void MH(String str) {
        this.kvx.setVisibility(0);
        this.kvz.setVisibility(8);
        this.kvy.setVisibility(0);
        hideLoadingView(this.kvC);
        String cDN = cDN();
        d MF = MF(cDN);
        this.kvw.clear();
        this.kvw.add(MF);
        this.kvB.j(cDN, this.kvw);
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void a(c cVar) {
        this.kvx.setVisibility(0);
        this.kvz.setVisibility(8);
        this.kvy.setVisibility(0);
        hideLoadingView(this.kvC);
        this.kvw.clear();
        String cDN = cDN();
        this.kvw.add(MF(cDN));
        if (cVar == null || cVar.getList() == null) {
            this.kvB.j(cDN, this.kvw);
            return;
        }
        this.kvw.addAll(cVar.getList());
        this.kvB.j(cDN, this.kvw);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        setSkinType(3);
        if (this.mNoDataView != null) {
            this.mNoDataView.bxx();
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
        if (this.kvB != null) {
            this.kvB.notifyDataSetChanged();
        }
        if (this.kvA != null) {
            this.kvA.notifyDataSetChanged();
        }
        if (this.kvD != null) {
            this.kvD.setHintTextColor(ao.getColor(R.color.CAM_X0109));
        }
        ao.setViewTextColor(this.jzB, R.color.CAM_X0302, 1);
        ao.setViewTextColor(this.kvD, R.color.CAM_X0105, 2);
        ao.setImageResource(this.kvE, R.drawable.del_search_btn);
        cVP();
        if (this.mSkinType == 2) {
            StatusBarUtil.from(getPageContext().getPageActivity()).setTransparentStatusbar(true).setLightStatusBar(true).process();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.kvv.onDestroy();
        this.mNoDataView.bxx();
        hideLoadingView(this.kvC);
        super.onDestroy();
    }
}

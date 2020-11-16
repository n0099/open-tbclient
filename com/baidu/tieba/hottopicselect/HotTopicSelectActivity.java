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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.suspended.SuspendedActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.StatusBarUtil;
import com.baidu.tieba.hottopicselect.HotTopicSelectModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes20.dex */
public class HotTopicSelectActivity extends SuspendedActivity implements com.baidu.tbadk.suspended.a, HotTopicSelectModel.a {
    private Intent fPu;
    private TextView iZB;
    private HotTopicSelectModel jUE;
    private View jUG;
    private BdListView jUH;
    private ExpandableListView jUI;
    private e jUJ;
    private b jUK;
    private ViewGroup jUL;
    private EditText jUM;
    private ImageView jUN;
    private TextView jUO;
    private NoDataView mNoDataView;
    private final List<d> jUF = new ArrayList();
    final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == HotTopicSelectActivity.this.jUN) {
                HotTopicSelectActivity.this.cNq();
            } else if (view == HotTopicSelectActivity.this.iZB) {
                HotTopicSelectActivity.this.Ly("");
            }
        }
    };
    final AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            d dVar = (d) y.getItem(HotTopicSelectActivity.this.jUK.getList(), i);
            if (dVar != null) {
                String topicName = dVar.getTopicName();
                HotTopicSelectActivity.this.Ly(topicName);
                HotTopicSelectActivity.this.aW(topicName, 3);
            }
        }
    };
    final ExpandableListView.OnGroupClickListener jUP = new ExpandableListView.OnGroupClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.3
        @Override // android.widget.ExpandableListView.OnGroupClickListener
        public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
            if (HotTopicSelectActivity.this.jUI != null) {
                HotTopicSelectActivity.this.jUI.expandGroup(i);
                return true;
            }
            return true;
        }
    };
    final ExpandableListView.OnChildClickListener jUQ = new ExpandableListView.OnChildClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.4
        @Override // android.widget.ExpandableListView.OnChildClickListener
        public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
            d child;
            if (HotTopicSelectActivity.this.jUJ != null && (child = HotTopicSelectActivity.this.jUJ.getChild(i, i2)) != null) {
                String topicName = child.getTopicName();
                HotTopicSelectActivity.this.Ly(topicName);
                c group = HotTopicSelectActivity.this.jUJ.getGroup(i);
                if (group != null) {
                    HotTopicSelectActivity.this.aW(topicName, group.getType() == 0 ? 1 : 2);
                    return false;
                }
                return false;
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jUE = new HotTopicSelectModel(getPageContext(), this);
        this.jUE.V(getIntent());
        this.jUE.cNA();
        initUI();
        getWindow().setSoftInputMode(1);
        showLoadingView();
        this.jUE.cNw();
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    protected com.baidu.tbadk.suspended.a a(LinearLayout linearLayout, NavigationBar navigationBar) {
        LayoutInflater.from(this).inflate(R.layout.hot_navigation_view_layout, (ViewGroup) navigationBar.getContentLayout(), true);
        this.bOb.setVisibility(8);
        LayoutInflater.from(this).inflate(R.layout.hot_select_main, (ViewGroup) linearLayout, true);
        return this;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bCk() {
        ListView listView;
        View childAt;
        if (this.jUH.getVisibility() == 0) {
            listView = this.jUH;
        } else {
            listView = this.jUI;
        }
        return listView != null && listView.getFirstVisiblePosition() == 0 && (childAt = listView.getChildAt(0)) != null && childAt.getTop() == 0;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bCl() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void sm(int i) {
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bCm() {
        return this.fPu;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    protected void bCq() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.jUG.setVisibility(8);
        showLoadingView(this.jUL, true, getResources().getDimensionPixelSize(R.dimen.ds320));
    }

    private void initUI() {
        this.jUL = (ViewGroup) findViewById(R.id.frame_main_view);
        this.iZB = (TextView) findViewById(R.id.btn_confirm);
        this.jUO = (TextView) findViewById(R.id.topic_text);
        this.jUN = (ImageView) findViewById(R.id.clear_right_img);
        this.jUG = findViewById(R.id.home_search_list);
        this.jUH = (BdListView) findViewById(R.id.home_lv_search_suggest);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds420)), null, null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.jUL.addView(this.mNoDataView, layoutParams);
        this.mNoDataView.setVisibility(8);
        this.jUK = new b(getPageContext());
        this.jUH.setAdapter((ListAdapter) this.jUK);
        this.jUI = (ExpandableListView) findViewById(R.id.home_no_search_listview);
        this.jUJ = new e(getPageContext());
        this.jUI.setAdapter(this.jUJ);
        this.jUH.setOnItemClickListener(this.mOnItemClickListener);
        this.jUI.setOnGroupClickListener(this.jUP);
        this.jUI.setOnChildClickListener(this.jUQ);
        this.iZB.setOnClickListener(this.mOnClickListener);
        this.jUN.setOnClickListener(this.mOnClickListener);
        on(false);
        cNs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aW(String str, int i) {
        ar arVar = new ar("c11665");
        arVar.dR("obj_name", str);
        arVar.ak("obj_locate", i);
        TiebaStatic.log(arVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cwD() {
        String cwD = this.jUE != null ? this.jUE.cwD() : "";
        return cwD != null ? cwD : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNq() {
        this.jUE.LD("");
        this.jUM.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNr() {
        this.jUI.setVisibility(0);
        this.jUH.setVisibility(8);
        this.jUK.clearList();
        if (this.jUJ != null && !y.isEmpty(this.jUJ.getList())) {
            this.jUG.setVisibility(0);
            return;
        }
        showLoadingView();
        this.jUE.getCacheData();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        Ly("");
        super.onBackPressed();
    }

    private void cNs() {
        this.jUM = (EditText) findViewById(R.id.search_root);
        this.jUM.setCompoundDrawablePadding(l.getDimens(getPageContext().getPageActivity(), R.dimen.ds8));
        this.jUM.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(HotTopicSelectActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.jUM.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6) {
                    l.showSoftKeyPad(HotTopicSelectActivity.this.getPageContext().getPageActivity(), textView);
                    if (!TextUtils.isEmpty(HotTopicSelectActivity.this.cwD())) {
                        HotTopicSelectActivity.this.Ly(HotTopicSelectActivity.this.cwD());
                    }
                    return true;
                }
                return false;
            }
        });
        this.jUM.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.7
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
                    HotTopicSelectActivity.this.cNr();
                } else {
                    HotTopicSelectActivity.this.mNoDataView.setVisibility(8);
                    HotTopicSelectActivity.this.jUG.setVisibility(8);
                    HotTopicSelectActivity.this.showLoadingView();
                    HotTopicSelectActivity.this.jUE.LC(obj);
                }
                HotTopicSelectActivity.this.on(!StringUtils.isNull(editable.toString()));
                HotTopicSelectActivity.this.cNt();
            }
        });
        this.jUM.requestFocus();
    }

    public void on(boolean z) {
        this.jUN.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNt() {
        if (this.jUM != null && this.jUO != null) {
            if (TextUtils.isEmpty(this.jUM.getText())) {
                ap.setViewTextColor(this.jUO, R.color.CAM_X0109, 1);
            } else {
                ap.setViewTextColor(this.jUO, R.color.CAM_X0105, 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ly(String str) {
        if (this.jUM != null && this.jUM.hasFocus()) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.jUM);
        }
        if (TextUtils.isEmpty(str)) {
            setResult(0, new Intent());
        } else {
            this.fPu = new Intent();
            this.fPu.putExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING, str + HotSelectActivityConfig.HOT_TOPIC_SING);
        }
        finish();
    }

    private d Lz(String str) {
        d dVar = new d();
        dVar.setTopicName(str);
        return dVar;
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void LA(String str) {
        hideLoadingView(this.jUL);
        this.jUG.setVisibility(8);
        if (!j.isNetWorkAvailable()) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.qo(R.string.neterror));
            this.mNoDataView.setVisibility(0);
        } else if (!TextUtils.isEmpty(str)) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.qo(R.string.refresh_view_title_text));
            this.mNoDataView.setVisibility(0);
            showToast(str);
        }
    }

    private void a(c cVar, boolean z) {
        if (cVar != null && !y.isEmpty(cVar.getList())) {
            if (TextUtils.isEmpty(cVar.cNu())) {
                cVar.setTitle(getString(z ? R.string.group_topic_default : R.string.group_topic_hot));
            }
            this.jUJ.b(cVar);
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void a(c cVar, c cVar2) {
        this.jUG.setVisibility(0);
        this.jUI.setVisibility(0);
        this.jUH.setVisibility(8);
        hideLoadingView(this.jUL);
        this.jUJ.clearList();
        a(cVar, true);
        a(cVar2, false);
        this.jUJ.notifyDataSetChanged();
        int count = this.jUI.getCount();
        for (int i = 0; i < count; i++) {
            this.jUI.expandGroup(i);
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void LB(String str) {
        this.jUG.setVisibility(0);
        this.jUI.setVisibility(8);
        this.jUH.setVisibility(0);
        hideLoadingView(this.jUL);
        String cwD = cwD();
        d Lz = Lz(cwD);
        this.jUF.clear();
        this.jUF.add(Lz);
        this.jUK.j(cwD, this.jUF);
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void a(c cVar) {
        this.jUG.setVisibility(0);
        this.jUI.setVisibility(8);
        this.jUH.setVisibility(0);
        hideLoadingView(this.jUL);
        this.jUF.clear();
        String cwD = cwD();
        this.jUF.add(Lz(cwD));
        if (cVar == null || cVar.getList() == null) {
            this.jUK.j(cwD, this.jUF);
            return;
        }
        this.jUF.addAll(cVar.getList());
        this.jUK.j(cwD, this.jUF);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        setSkinType(3);
        if (this.mNoDataView != null) {
            this.mNoDataView.brC();
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
        if (this.jUK != null) {
            this.jUK.notifyDataSetChanged();
        }
        if (this.jUJ != null) {
            this.jUJ.notifyDataSetChanged();
        }
        if (this.jUM != null) {
            this.jUM.setHintTextColor(ap.getColor(R.color.CAM_X0109));
        }
        ap.setViewTextColor(this.iZB, R.color.CAM_X0302, 1);
        ap.setViewTextColor(this.jUM, R.color.CAM_X0105, 2);
        ap.setImageResource(this.jUN, R.drawable.del_search_btn);
        cNt();
        if (this.mSkinType == 2) {
            StatusBarUtil.from(getPageContext().getPageActivity()).setTransparentStatusbar(true).setLightStatusBar(true).process();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.jUE.onDestroy();
        this.mNoDataView.brC();
        hideLoadingView(this.jUL);
        super.onDestroy();
    }
}

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
import com.baidu.tbadk.core.util.aq;
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
/* loaded from: classes15.dex */
public class HotTopicSelectActivity extends SuspendedActivity implements com.baidu.tbadk.suspended.a, HotTopicSelectModel.a {
    private TextView ikv;
    private HotTopicSelectModel jdO;
    private View jdQ;
    private BdListView jdR;
    private ExpandableListView jdS;
    private e jdT;
    private b jdU;
    private ViewGroup jdV;
    private EditText jdW;
    private ImageView jdX;
    private TextView jdY;
    private Intent jdZ;
    private NoDataView mNoDataView;
    private final List<d> jdP = new ArrayList();
    final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == HotTopicSelectActivity.this.jdX) {
                HotTopicSelectActivity.this.cAL();
            } else if (view == HotTopicSelectActivity.this.ikv) {
                HotTopicSelectActivity.this.JQ("");
            }
        }
    };
    final AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            d dVar = (d) y.getItem(HotTopicSelectActivity.this.jdU.getList(), i);
            if (dVar != null) {
                String topicName = dVar.getTopicName();
                HotTopicSelectActivity.this.JQ(topicName);
                HotTopicSelectActivity.this.aT(topicName, 3);
            }
        }
    };
    final ExpandableListView.OnGroupClickListener jea = new ExpandableListView.OnGroupClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.3
        @Override // android.widget.ExpandableListView.OnGroupClickListener
        public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
            if (HotTopicSelectActivity.this.jdS != null) {
                HotTopicSelectActivity.this.jdS.expandGroup(i);
                return true;
            }
            return true;
        }
    };
    final ExpandableListView.OnChildClickListener jeb = new ExpandableListView.OnChildClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.4
        @Override // android.widget.ExpandableListView.OnChildClickListener
        public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
            d child;
            if (HotTopicSelectActivity.this.jdT != null && (child = HotTopicSelectActivity.this.jdT.getChild(i, i2)) != null) {
                String topicName = child.getTopicName();
                HotTopicSelectActivity.this.JQ(topicName);
                c group = HotTopicSelectActivity.this.jdT.getGroup(i);
                if (group != null) {
                    HotTopicSelectActivity.this.aT(topicName, group.getType() == 0 ? 1 : 2);
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
        this.jdO = new HotTopicSelectModel(getPageContext(), this);
        this.jdO.Y(getIntent());
        this.jdO.cAV();
        initUI();
        getWindow().setSoftInputMode(1);
        showLoadingView();
        this.jdO.cAR();
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    protected com.baidu.tbadk.suspended.a a(LinearLayout linearLayout, NavigationBar navigationBar) {
        LayoutInflater.from(this).inflate(R.layout.hot_navigation_view_layout, (ViewGroup) navigationBar.getContentLayout(), true);
        this.dCB.setVisibility(8);
        LayoutInflater.from(this).inflate(R.layout.hot_select_main, (ViewGroup) linearLayout, true);
        return this;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean buK() {
        ListView listView;
        View childAt;
        if (this.jdR.getVisibility() == 0) {
            listView = this.jdR;
        } else {
            listView = this.jdS;
        }
        return listView != null && listView.getFirstVisiblePosition() == 0 && (childAt = listView.getChildAt(0)) != null && childAt.getTop() == 0;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean buL() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void qE(int i) {
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent buM() {
        return this.jdZ;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    protected void buQ() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.jdQ.setVisibility(8);
        showLoadingView(this.jdV, true, getResources().getDimensionPixelSize(R.dimen.ds320));
    }

    private void initUI() {
        this.jdV = (ViewGroup) findViewById(R.id.frame_main_view);
        this.ikv = (TextView) findViewById(R.id.btn_confirm);
        this.jdY = (TextView) findViewById(R.id.topic_text);
        this.jdX = (ImageView) findViewById(R.id.clear_right_img);
        this.jdQ = findViewById(R.id.home_search_list);
        this.jdR = (BdListView) findViewById(R.id.home_lv_search_suggest);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds420)), null, null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.jdV.addView(this.mNoDataView, layoutParams);
        this.mNoDataView.setVisibility(8);
        this.jdU = new b(getPageContext());
        this.jdR.setAdapter((ListAdapter) this.jdU);
        this.jdS = (ExpandableListView) findViewById(R.id.home_no_search_listview);
        this.jdT = new e(getPageContext());
        this.jdS.setAdapter(this.jdT);
        this.jdR.setOnItemClickListener(this.mOnItemClickListener);
        this.jdS.setOnGroupClickListener(this.jea);
        this.jdS.setOnChildClickListener(this.jeb);
        this.ikv.setOnClickListener(this.mOnClickListener);
        this.jdX.setOnClickListener(this.mOnClickListener);
        mX(false);
        cAN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aT(String str, int i) {
        aq aqVar = new aq("c11665");
        aqVar.dD("obj_name", str);
        aqVar.ai("obj_locate", i);
        TiebaStatic.log(aqVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ckH() {
        String ckH = this.jdO != null ? this.jdO.ckH() : "";
        return ckH != null ? ckH : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAL() {
        this.jdO.JV("");
        this.jdW.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAM() {
        this.jdS.setVisibility(0);
        this.jdR.setVisibility(8);
        this.jdU.clearList();
        if (this.jdT != null && !y.isEmpty(this.jdT.getList())) {
            this.jdQ.setVisibility(0);
            return;
        }
        showLoadingView();
        this.jdO.getCacheData();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        JQ("");
        super.onBackPressed();
    }

    private void cAN() {
        this.jdW = (EditText) findViewById(R.id.search_root);
        this.jdW.setCompoundDrawablePadding(l.getDimens(getPageContext().getPageActivity(), R.dimen.ds8));
        this.jdW.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(HotTopicSelectActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.jdW.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6) {
                    l.showSoftKeyPad(HotTopicSelectActivity.this.getPageContext().getPageActivity(), textView);
                    if (!TextUtils.isEmpty(HotTopicSelectActivity.this.ckH())) {
                        HotTopicSelectActivity.this.JQ(HotTopicSelectActivity.this.ckH());
                    }
                    return true;
                }
                return false;
            }
        });
        this.jdW.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.7
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
                    HotTopicSelectActivity.this.cAM();
                } else {
                    HotTopicSelectActivity.this.mNoDataView.setVisibility(8);
                    HotTopicSelectActivity.this.jdQ.setVisibility(8);
                    HotTopicSelectActivity.this.showLoadingView();
                    HotTopicSelectActivity.this.jdO.JU(obj);
                }
                HotTopicSelectActivity.this.mX(!StringUtils.isNull(editable.toString()));
                HotTopicSelectActivity.this.cAO();
            }
        });
        this.jdW.requestFocus();
    }

    public void mX(boolean z) {
        this.jdX.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAO() {
        if (this.jdW != null && this.jdY != null) {
            if (TextUtils.isEmpty(this.jdW.getText())) {
                ap.setViewTextColor(this.jdY, R.color.cp_cont_d, 1);
            } else {
                ap.setViewTextColor(this.jdY, R.color.cp_cont_b, 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JQ(String str) {
        if (this.jdW != null && this.jdW.hasFocus()) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.jdW);
        }
        if (TextUtils.isEmpty(str)) {
            setResult(0, new Intent());
        } else {
            this.jdZ = new Intent();
            this.jdZ.putExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING, str + HotSelectActivityConfig.HOT_TOPIC_SING);
        }
        finish();
    }

    private d JR(String str) {
        d dVar = new d();
        dVar.setTopicName(str);
        return dVar;
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void JS(String str) {
        hideLoadingView(this.jdV);
        this.jdQ.setVisibility(8);
        if (!j.isNetWorkAvailable()) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.oK(R.string.neterror));
            this.mNoDataView.setVisibility(0);
        } else if (!TextUtils.isEmpty(str)) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.oK(R.string.refresh_view_title_text));
            this.mNoDataView.setVisibility(0);
            showToast(str);
        }
    }

    private void a(c cVar, boolean z) {
        if (cVar != null && !y.isEmpty(cVar.getList())) {
            if (TextUtils.isEmpty(cVar.cAP())) {
                cVar.setTitle(getString(z ? R.string.group_topic_default : R.string.group_topic_hot));
            }
            this.jdT.b(cVar);
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void a(c cVar, c cVar2) {
        this.jdQ.setVisibility(0);
        this.jdS.setVisibility(0);
        this.jdR.setVisibility(8);
        hideLoadingView(this.jdV);
        this.jdT.clearList();
        a(cVar, true);
        a(cVar2, false);
        this.jdT.notifyDataSetChanged();
        int count = this.jdS.getCount();
        for (int i = 0; i < count; i++) {
            this.jdS.expandGroup(i);
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void JT(String str) {
        this.jdQ.setVisibility(0);
        this.jdS.setVisibility(8);
        this.jdR.setVisibility(0);
        hideLoadingView(this.jdV);
        String ckH = ckH();
        d JR = JR(ckH);
        this.jdP.clear();
        this.jdP.add(JR);
        this.jdU.j(ckH, this.jdP);
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void a(c cVar) {
        this.jdQ.setVisibility(0);
        this.jdS.setVisibility(8);
        this.jdR.setVisibility(0);
        hideLoadingView(this.jdV);
        this.jdP.clear();
        String ckH = ckH();
        this.jdP.add(JR(ckH));
        if (cVar == null || cVar.getList() == null) {
            this.jdU.j(ckH, this.jdP);
            return;
        }
        this.jdP.addAll(cVar.getList());
        this.jdU.j(ckH, this.jdP);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        setSkinType(3);
        if (this.mNoDataView != null) {
            this.mNoDataView.bkq();
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
        if (this.jdU != null) {
            this.jdU.notifyDataSetChanged();
        }
        if (this.jdT != null) {
            this.jdT.notifyDataSetChanged();
        }
        if (this.jdW != null) {
            this.jdW.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        }
        ap.setViewTextColor(this.ikv, R.color.cp_link_tip_a, 1);
        ap.setViewTextColor(this.jdW, R.color.cp_cont_b, 2);
        ap.setImageResource(this.jdX, R.drawable.del_search_btn);
        cAO();
        if (this.mSkinType == 2) {
            StatusBarUtil.from(getPageContext().getPageActivity()).setTransparentStatusbar(true).setLightStatusBar(true).process();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.jdO.onDestroy();
        this.mNoDataView.bkq();
        hideLoadingView(this.jdV);
        super.onDestroy();
    }
}

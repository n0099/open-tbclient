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
/* loaded from: classes7.dex */
public class HotTopicSelectActivity extends SuspendedActivity implements com.baidu.tbadk.suspended.a, HotTopicSelectModel.a {
    private Intent ggB;
    private TextView jCy;
    private HotTopicSelectModel kBn;
    private View kBp;
    private BdListView kBq;
    private ExpandableListView kBr;
    private e kBs;
    private b kBt;
    private ViewGroup kBu;
    private EditText kBv;
    private ImageView kBw;
    private TextView kBx;
    private NoDataView mNoDataView;
    private final List<d> kBo = new ArrayList();
    final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == HotTopicSelectActivity.this.kBw) {
                HotTopicSelectActivity.this.cUh();
            } else if (view == HotTopicSelectActivity.this.jCy) {
                HotTopicSelectActivity.this.Ms("");
            }
        }
    };
    final AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            d dVar = (d) y.getItem(HotTopicSelectActivity.this.kBt.getList(), i);
            if (dVar != null) {
                String topicName = dVar.getTopicName();
                HotTopicSelectActivity.this.Ms(topicName);
                HotTopicSelectActivity.this.bg(topicName, 3);
            }
        }
    };
    final ExpandableListView.OnGroupClickListener kBy = new ExpandableListView.OnGroupClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.3
        @Override // android.widget.ExpandableListView.OnGroupClickListener
        public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
            if (HotTopicSelectActivity.this.kBr != null) {
                HotTopicSelectActivity.this.kBr.expandGroup(i);
                return true;
            }
            return true;
        }
    };
    final ExpandableListView.OnChildClickListener kBz = new ExpandableListView.OnChildClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.4
        @Override // android.widget.ExpandableListView.OnChildClickListener
        public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
            d child;
            if (HotTopicSelectActivity.this.kBs != null && (child = HotTopicSelectActivity.this.kBs.getChild(i, i2)) != null) {
                String topicName = child.getTopicName();
                HotTopicSelectActivity.this.Ms(topicName);
                c group = HotTopicSelectActivity.this.kBs.getGroup(i);
                if (group != null) {
                    HotTopicSelectActivity.this.bg(topicName, group.getType() == 0 ? 1 : 2);
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
        this.kBn = new HotTopicSelectModel(getPageContext(), this);
        this.kBn.W(getIntent());
        this.kBn.cUr();
        initUI();
        getWindow().setSoftInputMode(1);
        showLoadingView();
        this.kBn.cUn();
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    protected com.baidu.tbadk.suspended.a a(LinearLayout linearLayout, NavigationBar navigationBar) {
        LayoutInflater.from(this).inflate(R.layout.hot_navigation_view_layout, (ViewGroup) navigationBar.getContentLayout(), true);
        this.bZE.setVisibility(8);
        LayoutInflater.from(this).inflate(R.layout.hot_select_main, (ViewGroup) linearLayout, true);
        return this;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bEL() {
        ListView listView;
        View childAt;
        if (this.kBq.getVisibility() == 0) {
            listView = this.kBq;
        } else {
            listView = this.kBr;
        }
        return listView != null && listView.getFirstVisiblePosition() == 0 && (childAt = listView.getChildAt(0)) != null && childAt.getTop() == 0;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bEM() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void rz(int i) {
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bEN() {
        return this.ggB;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    protected void bER() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.kBp.setVisibility(8);
        showLoadingView(this.kBu, true, getResources().getDimensionPixelSize(R.dimen.ds320));
    }

    private void initUI() {
        this.kBu = (ViewGroup) findViewById(R.id.frame_main_view);
        this.jCy = (TextView) findViewById(R.id.btn_confirm);
        this.kBx = (TextView) findViewById(R.id.topic_text);
        this.kBw = (ImageView) findViewById(R.id.clear_right_img);
        this.kBp = findViewById(R.id.home_search_list);
        this.kBq = (BdListView) findViewById(R.id.home_lv_search_suggest);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds420)), null, null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.kBu.addView(this.mNoDataView, layoutParams);
        this.mNoDataView.setVisibility(8);
        this.kBt = new b(getPageContext());
        this.kBq.setAdapter((ListAdapter) this.kBt);
        this.kBr = (ExpandableListView) findViewById(R.id.home_no_search_listview);
        this.kBs = new e(getPageContext());
        this.kBr.setAdapter(this.kBs);
        this.kBq.setOnItemClickListener(this.mOnItemClickListener);
        this.kBr.setOnGroupClickListener(this.kBy);
        this.kBr.setOnChildClickListener(this.kBz);
        this.jCy.setOnClickListener(this.mOnClickListener);
        this.kBw.setOnClickListener(this.mOnClickListener);
        po(false);
        cUj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bg(String str, int i) {
        ar arVar = new ar("c11665");
        arVar.dR("obj_name", str);
        arVar.aq("obj_locate", i);
        TiebaStatic.log(arVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cBt() {
        String cBt = this.kBn != null ? this.kBn.cBt() : "";
        return cBt != null ? cBt : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUh() {
        this.kBn.Mx("");
        this.kBv.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUi() {
        this.kBr.setVisibility(0);
        this.kBq.setVisibility(8);
        this.kBt.clearList();
        if (this.kBs != null && !y.isEmpty(this.kBs.getList())) {
            this.kBp.setVisibility(0);
            return;
        }
        showLoadingView();
        this.kBn.getCacheData();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        Ms("");
        super.onBackPressed();
    }

    private void cUj() {
        this.kBv = (EditText) findViewById(R.id.search_root);
        this.kBv.setCompoundDrawablePadding(l.getDimens(getPageContext().getPageActivity(), R.dimen.ds8));
        this.kBv.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(HotTopicSelectActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.kBv.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6) {
                    l.showSoftKeyPad(HotTopicSelectActivity.this.getPageContext().getPageActivity(), textView);
                    if (!TextUtils.isEmpty(HotTopicSelectActivity.this.cBt())) {
                        HotTopicSelectActivity.this.Ms(HotTopicSelectActivity.this.cBt());
                    }
                    return true;
                }
                return false;
            }
        });
        this.kBv.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.7
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
                    HotTopicSelectActivity.this.cUi();
                } else {
                    HotTopicSelectActivity.this.mNoDataView.setVisibility(8);
                    HotTopicSelectActivity.this.kBp.setVisibility(8);
                    HotTopicSelectActivity.this.showLoadingView();
                    HotTopicSelectActivity.this.kBn.Mw(obj);
                }
                HotTopicSelectActivity.this.po(!StringUtils.isNull(editable.toString()));
                HotTopicSelectActivity.this.cUk();
            }
        });
        this.kBv.requestFocus();
    }

    public void po(boolean z) {
        this.kBw.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUk() {
        if (this.kBv != null && this.kBx != null) {
            if (TextUtils.isEmpty(this.kBv.getText())) {
                ap.setViewTextColor(this.kBx, R.color.CAM_X0109, 1);
            } else {
                ap.setViewTextColor(this.kBx, R.color.CAM_X0105, 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ms(String str) {
        if (this.kBv != null && this.kBv.hasFocus()) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.kBv);
        }
        if (TextUtils.isEmpty(str)) {
            setResult(0, new Intent());
        } else {
            this.ggB = new Intent();
            this.ggB.putExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING, str + HotSelectActivityConfig.HOT_TOPIC_SING);
        }
        finish();
    }

    private d Mt(String str) {
        d dVar = new d();
        dVar.setTopicName(str);
        return dVar;
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void Mu(String str) {
        hideLoadingView(this.kBu);
        this.kBp.setVisibility(8);
        if (!j.isNetWorkAvailable()) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.pA(R.string.neterror));
            this.mNoDataView.setVisibility(0);
        } else if (!TextUtils.isEmpty(str)) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.pA(R.string.refresh_view_title_text));
            this.mNoDataView.setVisibility(0);
            showToast(str);
        }
    }

    private void a(c cVar, boolean z) {
        if (cVar != null && !y.isEmpty(cVar.getList())) {
            if (TextUtils.isEmpty(cVar.cUl())) {
                cVar.setTitle(getString(z ? R.string.group_topic_default : R.string.group_topic_hot));
            }
            this.kBs.b(cVar);
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void a(c cVar, c cVar2) {
        this.kBp.setVisibility(0);
        this.kBr.setVisibility(0);
        this.kBq.setVisibility(8);
        hideLoadingView(this.kBu);
        this.kBs.clearList();
        a(cVar, true);
        a(cVar2, false);
        this.kBs.notifyDataSetChanged();
        int count = this.kBr.getCount();
        for (int i = 0; i < count; i++) {
            this.kBr.expandGroup(i);
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void Mv(String str) {
        this.kBp.setVisibility(0);
        this.kBr.setVisibility(8);
        this.kBq.setVisibility(0);
        hideLoadingView(this.kBu);
        String cBt = cBt();
        d Mt = Mt(cBt);
        this.kBo.clear();
        this.kBo.add(Mt);
        this.kBt.j(cBt, this.kBo);
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void a(c cVar) {
        this.kBp.setVisibility(0);
        this.kBr.setVisibility(8);
        this.kBq.setVisibility(0);
        hideLoadingView(this.kBu);
        this.kBo.clear();
        String cBt = cBt();
        this.kBo.add(Mt(cBt));
        if (cVar == null || cVar.getList() == null) {
            this.kBt.j(cBt, this.kBo);
            return;
        }
        this.kBo.addAll(cVar.getList());
        this.kBt.j(cBt, this.kBo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        setSkinType(3);
        if (this.mNoDataView != null) {
            this.mNoDataView.bua();
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
        if (this.kBt != null) {
            this.kBt.notifyDataSetChanged();
        }
        if (this.kBs != null) {
            this.kBs.notifyDataSetChanged();
        }
        if (this.kBv != null) {
            this.kBv.setHintTextColor(ap.getColor(R.color.CAM_X0109));
        }
        ap.setViewTextColor(this.jCy, R.color.CAM_X0302, 1);
        ap.setViewTextColor(this.kBv, R.color.CAM_X0105, 2);
        ap.setImageResource(this.kBw, R.drawable.del_search_btn);
        cUk();
        if (this.mSkinType == 2) {
            StatusBarUtil.from(getPageContext().getPageActivity()).setTransparentStatusbar(true).setLightStatusBar(true).process();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.kBn.onDestroy();
        this.mNoDataView.bua();
        hideLoadingView(this.kBu);
        super.onDestroy();
    }
}

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
/* loaded from: classes21.dex */
public class HotTopicSelectActivity extends SuspendedActivity implements com.baidu.tbadk.suspended.a, HotTopicSelectModel.a {
    private Intent fXD;
    private TextView jnb;
    private HotTopicSelectModel kij;
    private View kil;
    private BdListView kim;
    private ExpandableListView kin;
    private e kio;
    private b kip;
    private ViewGroup kiq;
    private EditText kir;
    private ImageView kis;
    private TextView kit;
    private NoDataView mNoDataView;
    private final List<d> kik = new ArrayList();
    final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == HotTopicSelectActivity.this.kis) {
                HotTopicSelectActivity.this.cSE();
            } else if (view == HotTopicSelectActivity.this.jnb) {
                HotTopicSelectActivity.this.MF("");
            }
        }
    };
    final AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            d dVar = (d) y.getItem(HotTopicSelectActivity.this.kip.getList(), i);
            if (dVar != null) {
                String topicName = dVar.getTopicName();
                HotTopicSelectActivity.this.MF(topicName);
                HotTopicSelectActivity.this.aX(topicName, 3);
            }
        }
    };
    final ExpandableListView.OnGroupClickListener kiu = new ExpandableListView.OnGroupClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.3
        @Override // android.widget.ExpandableListView.OnGroupClickListener
        public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
            if (HotTopicSelectActivity.this.kin != null) {
                HotTopicSelectActivity.this.kin.expandGroup(i);
                return true;
            }
            return true;
        }
    };
    final ExpandableListView.OnChildClickListener kiv = new ExpandableListView.OnChildClickListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.4
        @Override // android.widget.ExpandableListView.OnChildClickListener
        public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
            d child;
            if (HotTopicSelectActivity.this.kio != null && (child = HotTopicSelectActivity.this.kio.getChild(i, i2)) != null) {
                String topicName = child.getTopicName();
                HotTopicSelectActivity.this.MF(topicName);
                c group = HotTopicSelectActivity.this.kio.getGroup(i);
                if (group != null) {
                    HotTopicSelectActivity.this.aX(topicName, group.getType() == 0 ? 1 : 2);
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
        this.kij = new HotTopicSelectModel(getPageContext(), this);
        this.kij.V(getIntent());
        this.kij.cSO();
        initUI();
        getWindow().setSoftInputMode(1);
        showLoadingView();
        this.kij.cSK();
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    protected com.baidu.tbadk.suspended.a a(LinearLayout linearLayout, NavigationBar navigationBar) {
        LayoutInflater.from(this).inflate(R.layout.hot_navigation_view_layout, (ViewGroup) navigationBar.getContentLayout(), true);
        this.bTh.setVisibility(8);
        LayoutInflater.from(this).inflate(R.layout.hot_select_main, (ViewGroup) linearLayout, true);
        return this;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bFL() {
        ListView listView;
        View childAt;
        if (this.kim.getVisibility() == 0) {
            listView = this.kim;
        } else {
            listView = this.kin;
        }
        return listView != null && listView.getFirstVisiblePosition() == 0 && (childAt = listView.getChildAt(0)) != null && childAt.getTop() == 0;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bFM() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public void sN(int i) {
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bFN() {
        return this.fXD;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    protected void bFR() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.kil.setVisibility(8);
        showLoadingView(this.kiq, true, getResources().getDimensionPixelSize(R.dimen.ds320));
    }

    private void initUI() {
        this.kiq = (ViewGroup) findViewById(R.id.frame_main_view);
        this.jnb = (TextView) findViewById(R.id.btn_confirm);
        this.kit = (TextView) findViewById(R.id.topic_text);
        this.kis = (ImageView) findViewById(R.id.clear_right_img);
        this.kil = findViewById(R.id.home_search_list);
        this.kim = (BdListView) findViewById(R.id.home_lv_search_suggest);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds420)), null, null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.kiq.addView(this.mNoDataView, layoutParams);
        this.mNoDataView.setVisibility(8);
        this.kip = new b(getPageContext());
        this.kim.setAdapter((ListAdapter) this.kip);
        this.kin = (ExpandableListView) findViewById(R.id.home_no_search_listview);
        this.kio = new e(getPageContext());
        this.kin.setAdapter(this.kio);
        this.kim.setOnItemClickListener(this.mOnItemClickListener);
        this.kin.setOnGroupClickListener(this.kiu);
        this.kin.setOnChildClickListener(this.kiv);
        this.jnb.setOnClickListener(this.mOnClickListener);
        this.kis.setOnClickListener(this.mOnClickListener);
        oJ(false);
        cSG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aX(String str, int i) {
        ar arVar = new ar("c11665");
        arVar.dY("obj_name", str);
        arVar.al("obj_locate", i);
        TiebaStatic.log(arVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cAS() {
        String cAS = this.kij != null ? this.kij.cAS() : "";
        return cAS != null ? cAS : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSE() {
        this.kij.MK("");
        this.kir.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSF() {
        this.kin.setVisibility(0);
        this.kim.setVisibility(8);
        this.kip.clearList();
        if (this.kio != null && !y.isEmpty(this.kio.getList())) {
            this.kil.setVisibility(0);
            return;
        }
        showLoadingView();
        this.kij.getCacheData();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        MF("");
        super.onBackPressed();
    }

    private void cSG() {
        this.kir = (EditText) findViewById(R.id.search_root);
        this.kir.setCompoundDrawablePadding(l.getDimens(getPageContext().getPageActivity(), R.dimen.ds8));
        this.kir.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(HotTopicSelectActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.kir.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6) {
                    l.showSoftKeyPad(HotTopicSelectActivity.this.getPageContext().getPageActivity(), textView);
                    if (!TextUtils.isEmpty(HotTopicSelectActivity.this.cAS())) {
                        HotTopicSelectActivity.this.MF(HotTopicSelectActivity.this.cAS());
                    }
                    return true;
                }
                return false;
            }
        });
        this.kir.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectActivity.7
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
                    HotTopicSelectActivity.this.cSF();
                } else {
                    HotTopicSelectActivity.this.mNoDataView.setVisibility(8);
                    HotTopicSelectActivity.this.kil.setVisibility(8);
                    HotTopicSelectActivity.this.showLoadingView();
                    HotTopicSelectActivity.this.kij.MJ(obj);
                }
                HotTopicSelectActivity.this.oJ(!StringUtils.isNull(editable.toString()));
                HotTopicSelectActivity.this.cSH();
            }
        });
        this.kir.requestFocus();
    }

    public void oJ(boolean z) {
        this.kis.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSH() {
        if (this.kir != null && this.kit != null) {
            if (TextUtils.isEmpty(this.kir.getText())) {
                ap.setViewTextColor(this.kit, R.color.CAM_X0109, 1);
            } else {
                ap.setViewTextColor(this.kit, R.color.CAM_X0105, 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MF(String str) {
        if (this.kir != null && this.kir.hasFocus()) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.kir);
        }
        if (TextUtils.isEmpty(str)) {
            setResult(0, new Intent());
        } else {
            this.fXD = new Intent();
            this.fXD.putExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING, str + HotSelectActivityConfig.HOT_TOPIC_SING);
        }
        finish();
    }

    private d MG(String str) {
        d dVar = new d();
        dVar.setTopicName(str);
        return dVar;
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void MH(String str) {
        hideLoadingView(this.kiq);
        this.kil.setVisibility(8);
        if (!j.isNetWorkAvailable()) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.qP(R.string.neterror));
            this.mNoDataView.setVisibility(0);
        } else if (!TextUtils.isEmpty(str)) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.qP(R.string.refresh_view_title_text));
            this.mNoDataView.setVisibility(0);
            showToast(str);
        }
    }

    private void a(c cVar, boolean z) {
        if (cVar != null && !y.isEmpty(cVar.getList())) {
            if (TextUtils.isEmpty(cVar.cSI())) {
                cVar.setTitle(getString(z ? R.string.group_topic_default : R.string.group_topic_hot));
            }
            this.kio.b(cVar);
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void a(c cVar, c cVar2) {
        this.kil.setVisibility(0);
        this.kin.setVisibility(0);
        this.kim.setVisibility(8);
        hideLoadingView(this.kiq);
        this.kio.clearList();
        a(cVar, true);
        a(cVar2, false);
        this.kio.notifyDataSetChanged();
        int count = this.kin.getCount();
        for (int i = 0; i < count; i++) {
            this.kin.expandGroup(i);
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void MI(String str) {
        this.kil.setVisibility(0);
        this.kin.setVisibility(8);
        this.kim.setVisibility(0);
        hideLoadingView(this.kiq);
        String cAS = cAS();
        d MG = MG(cAS);
        this.kik.clear();
        this.kik.add(MG);
        this.kip.j(cAS, this.kik);
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.a
    public void a(c cVar) {
        this.kil.setVisibility(0);
        this.kin.setVisibility(8);
        this.kim.setVisibility(0);
        hideLoadingView(this.kiq);
        this.kik.clear();
        String cAS = cAS();
        this.kik.add(MG(cAS));
        if (cVar == null || cVar.getList() == null) {
            this.kip.j(cAS, this.kik);
            return;
        }
        this.kik.addAll(cVar.getList());
        this.kip.j(cAS, this.kik);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        setSkinType(3);
        if (this.mNoDataView != null) {
            this.mNoDataView.bvb();
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
        if (this.kip != null) {
            this.kip.notifyDataSetChanged();
        }
        if (this.kio != null) {
            this.kio.notifyDataSetChanged();
        }
        if (this.kir != null) {
            this.kir.setHintTextColor(ap.getColor(R.color.CAM_X0109));
        }
        ap.setViewTextColor(this.jnb, R.color.CAM_X0302, 1);
        ap.setViewTextColor(this.kir, R.color.CAM_X0105, 2);
        ap.setImageResource(this.kis, R.drawable.del_search_btn);
        cSH();
        if (this.mSkinType == 2) {
            StatusBarUtil.from(getPageContext().getPageActivity()).setTransparentStatusbar(true).setLightStatusBar(true).process();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.kij.onDestroy();
        this.mNoDataView.bvb();
        hideLoadingView(this.kiq);
        super.onDestroy();
    }
}

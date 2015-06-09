package com.baidu.tieba.addresslist;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.List;
/* loaded from: classes.dex */
public class QuickSearchActivity extends BaseActivity<QuickSearchActivity> {
    private com.baidu.tieba.addresslist.c.b azo;
    private View azp;
    private EditText azq;
    private TextView azr;
    private TextView azs;
    private ListView azt;
    private s azu;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.r.quick_search_activity);
        this.azo = new com.baidu.tieba.addresslist.c.b(this);
        this.azo.setUniqueId(getUniqueId());
        FM();
    }

    private void FM() {
        this.azp = findViewById(com.baidu.tieba.q.quick_search_parent);
        FN();
        this.azt = (ListView) findViewById(com.baidu.tieba.q.quick_search_result);
        this.azt.setOnTouchListener(new m(this));
        this.azu = new s(this, null);
        this.azt.setAdapter((ListAdapter) this.azu);
        this.azt.setOnItemClickListener(this);
        this.azs = (TextView) findViewById(com.baidu.tieba.q.quick_search_empty_result);
        this.azp.setOnTouchListener(new n(this));
    }

    private void FN() {
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.q.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new o(this));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, com.baidu.tieba.r.quick_search_navigation, (View.OnClickListener) null);
        this.azq = (EditText) addCustomView.findViewById(com.baidu.tieba.q.quick_search_input);
        this.azq.addTextChangedListener(new r(this, null));
        this.azq.setOnFocusChangeListener(new p(this));
        this.azr = (TextView) addCustomView.findViewById(com.baidu.tieba.q.quick_search_delete_button);
        com.baidu.adp.lib.util.n.a(getPageContext().getPageActivity(), this.azr, 10, 10, 10, 10);
        this.azr.setOnClickListener(new q(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.adp.lib.util.n.c(getPageContext().getPageActivity(), this.azq);
        this.azo = null;
    }

    public void fs(String str) {
        List<com.baidu.tbadk.coreExtra.relationship.a> fH = this.azo.fH(str);
        if (fH.size() > 0) {
            bw(true);
            this.azu.setContacts(fH);
            this.azu.notifyDataSetChanged();
            this.azt.setSelection(0);
            return;
        }
        bw(false);
    }

    private void bw(boolean z) {
        this.azt.setVisibility(z ? 0 : 8);
        this.azs.setVisibility(z ? 8 : 0);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.coreExtra.relationship.a item = this.azu.getItem(i);
        if (item != null && item.getUserId() > 0) {
            if (item.getUserType() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), item.getUserId(), item.getUserName(), item.getUserPortrait(), 0, 4)));
                return;
            }
            sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(TbadkCoreApplication.m411getInst().getApplicationContext(), String.valueOf(item.getUserId()), item.getUserName())));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ay.i(this.azp, com.baidu.tieba.n.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.azu.notifyDataSetChanged();
        ay.b(this.azs, com.baidu.tieba.n.cp_cont_d, 1);
    }
}

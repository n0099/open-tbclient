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
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.t;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import java.util.List;
/* loaded from: classes.dex */
public class QuickSearchActivity extends BaseActivity<QuickSearchActivity> {
    private com.baidu.tieba.addresslist.c.b apc;
    private View apd;
    private EditText ape;
    private TextView apf;
    private View apg;
    private ListView aph;
    private p apj;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(x.quick_search_activity);
        this.apc = new com.baidu.tieba.addresslist.c.b(this);
        this.apc.setUniqueId(getUniqueId());
        vX();
    }

    private void vX() {
        this.apd = findViewById(w.quick_search_parent);
        Bt();
        this.aph = (ListView) findViewById(w.quick_search_result);
        this.aph.setOnTouchListener(new j(this));
        this.apj = new p(this, null);
        this.aph.setAdapter((ListAdapter) this.apj);
        this.aph.setOnItemClickListener(this);
        this.apg = findViewById(w.quick_search_empty_result);
        this.apd.setOnTouchListener(new k(this));
    }

    private void Bt() {
        this.mNavigationBar = (NavigationBar) findViewById(w.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new l(this));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, x.quick_search_navigation, (View.OnClickListener) null);
        this.ape = (EditText) addCustomView.findViewById(w.quick_search_input);
        this.ape.addTextChangedListener(new o(this, null));
        this.ape.setOnFocusChangeListener(new m(this));
        this.apf = (TextView) addCustomView.findViewById(w.quick_search_delete_button);
        com.baidu.adp.lib.util.l.a(getPageContext().getPageActivity(), this.apf, 10, 10, 10, 10);
        this.apf.setOnClickListener(new n(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.adp.lib.util.l.c(getPageContext().getPageActivity(), this.ape);
        this.apc = null;
    }

    public void eQ(String str) {
        List<com.baidu.tbadk.coreExtra.relationship.b> eS = this.apc.eS(str);
        if (eS.size() > 0) {
            bj(true);
            this.apj.setContacts(eS);
            this.apj.notifyDataSetChanged();
            this.aph.setSelection(0);
            return;
        }
        bj(false);
    }

    private void bj(boolean z) {
        this.aph.setVisibility(z ? 0 : 8);
        this.apg.setVisibility(z ? 8 : 0);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.coreExtra.relationship.b item = this.apj.getItem(i);
        if (item != null && item.getUserId() > 0) {
            if (item.getUserType() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), item.getUserId(), item.getUserName(), item.getUserPortrait(), 0, 4)));
                return;
            }
            sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(TbadkCoreApplication.m255getInst().getApplicationContext(), String.valueOf(item.getUserId()), item.getUserName())));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        bc.i(this.apd, t.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.apj.notifyDataSetChanged();
    }
}

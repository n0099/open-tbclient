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
    private com.baidu.tieba.addresslist.c.b aoZ;
    private View apa;
    private EditText apb;
    private TextView apc;
    private View apd;
    private ListView ape;
    private p apf;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(x.quick_search_activity);
        this.aoZ = new com.baidu.tieba.addresslist.c.b(this);
        this.aoZ.setUniqueId(getUniqueId());
        vR();
    }

    private void vR() {
        this.apa = findViewById(w.quick_search_parent);
        Bn();
        this.ape = (ListView) findViewById(w.quick_search_result);
        this.ape.setOnTouchListener(new j(this));
        this.apf = new p(this, null);
        this.ape.setAdapter((ListAdapter) this.apf);
        this.ape.setOnItemClickListener(this);
        this.apd = findViewById(w.quick_search_empty_result);
        this.apa.setOnTouchListener(new k(this));
    }

    private void Bn() {
        this.mNavigationBar = (NavigationBar) findViewById(w.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new l(this));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, x.quick_search_navigation, (View.OnClickListener) null);
        this.apb = (EditText) addCustomView.findViewById(w.quick_search_input);
        this.apb.addTextChangedListener(new o(this, null));
        this.apb.setOnFocusChangeListener(new m(this));
        this.apc = (TextView) addCustomView.findViewById(w.quick_search_delete_button);
        com.baidu.adp.lib.util.l.a(getPageContext().getPageActivity(), this.apc, 10, 10, 10, 10);
        this.apc.setOnClickListener(new n(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.adp.lib.util.l.c(getPageContext().getPageActivity(), this.apb);
        this.aoZ = null;
    }

    public void eN(String str) {
        List<com.baidu.tbadk.coreExtra.relationship.b> eP = this.aoZ.eP(str);
        if (eP.size() > 0) {
            bj(true);
            this.apf.setContacts(eP);
            this.apf.notifyDataSetChanged();
            this.ape.setSelection(0);
            return;
        }
        bj(false);
    }

    private void bj(boolean z) {
        this.ape.setVisibility(z ? 0 : 8);
        this.apd.setVisibility(z ? 8 : 0);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.coreExtra.relationship.b item = this.apf.getItem(i);
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
        bc.i(this.apa, t.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.apf.notifyDataSetChanged();
    }
}

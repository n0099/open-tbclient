package com.baidu.tieba.addresslist;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class QuickSearchActivity extends BaseActivity<QuickSearchActivity> {
    private com.baidu.tieba.addresslist.c.b aHR;
    private View aHS;
    private EditText aHT;
    private TextView aHU;
    private TextView aHV;
    private ListView aHW;
    private b aHX;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(n.g.quick_search_activity);
        this.aHR = new com.baidu.tieba.addresslist.c.b(this);
        this.aHR.setUniqueId(getUniqueId());
        initViews();
    }

    private void initViews() {
        this.aHS = findViewById(n.f.quick_search_parent);
        Hh();
        this.aHW = (ListView) findViewById(n.f.quick_search_result);
        this.aHW.setOnTouchListener(new i(this));
        this.aHX = new b(this, null);
        this.aHW.setAdapter((ListAdapter) this.aHX);
        this.aHW.setOnItemClickListener(this);
        this.aHV = (TextView) findViewById(n.f.quick_search_empty_result);
        this.aHS.setOnTouchListener(new j(this));
    }

    private void Hh() {
        this.mNavigationBar = (NavigationBar) findViewById(n.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new k(this));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, n.g.quick_search_navigation, (View.OnClickListener) null);
        this.aHT = (EditText) addCustomView.findViewById(n.f.quick_search_input);
        this.aHT.addTextChangedListener(new a(this, null));
        this.aHT.setOnFocusChangeListener(new l(this));
        this.aHU = (TextView) addCustomView.findViewById(n.f.quick_search_delete_button);
        com.baidu.adp.lib.util.k.a(getPageContext().getPageActivity(), this.aHU, 10, 10, 10, 10);
        this.aHU.setOnClickListener(new m(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), this.aHT);
        this.aHR = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gl(String str) {
        List<com.baidu.tbadk.coreExtra.relationship.a> gz = this.aHR.gz(str);
        if (gz.size() > 0) {
            bK(true);
            this.aHX.setContacts(gz);
            this.aHX.notifyDataSetChanged();
            this.aHW.setSelection(0);
            return;
        }
        bK(false);
    }

    private void bK(boolean z) {
        this.aHW.setVisibility(z ? 0 : 8);
        this.aHV.setVisibility(z ? 8 : 0);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.coreExtra.relationship.a item = this.aHX.getItem(i);
        if (item != null && item.getUserId() > 0) {
            if (item.getUserType() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), item.getUserId(), item.getUserName(), item.getUserPortrait(), 0, 4)));
                return;
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(TbadkCoreApplication.m411getInst().getApplicationContext(), String.valueOf(item.getUserId()), item.getUserName())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements TextWatcher {
        private a() {
        }

        /* synthetic */ a(QuickSearchActivity quickSearchActivity, a aVar) {
            this();
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (charSequence.toString().trim().length() == 0) {
                QuickSearchActivity.this.aHV.setVisibility(8);
                QuickSearchActivity.this.aHW.setVisibility(8);
                return;
            }
            QuickSearchActivity.this.gl(charSequence.toString());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.toString().trim().length() == 0) {
                QuickSearchActivity.this.aHU.setVisibility(8);
            } else {
                QuickSearchActivity.this.aHU.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BaseAdapter {
        private List<com.baidu.tbadk.coreExtra.relationship.a> aHZ;

        private b() {
            this.aHZ = new ArrayList();
        }

        /* synthetic */ b(QuickSearchActivity quickSearchActivity, b bVar) {
            this();
        }

        public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
            this.aHZ = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aHZ != null) {
                return this.aHZ.size();
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: fd */
        public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
            if (this.aHZ == null || i < 0 || i >= getCount()) {
                return null;
            }
            return this.aHZ.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            c cVar;
            com.baidu.tbadk.core.c layoutMode = QuickSearchActivity.this.getLayoutMode();
            TbadkCoreApplication.m411getInst().getSkinType();
            com.baidu.tbadk.coreExtra.relationship.a item = getItem(i);
            if (item == null) {
                return null;
            }
            if (view == null) {
                view = LayoutInflater.from(QuickSearchActivity.this.getPageContext().getPageActivity()).inflate(n.g.quick_search_item, (ViewGroup) null);
                c cVar2 = new c(QuickSearchActivity.this, null);
                cVar2.aIa = (HeadImageView) view.findViewById(n.f.quick_search_item_icon);
                cVar2.aIb = (TextView) view.findViewById(n.f.quick_search_item_text);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            layoutMode.k(view);
            as.i(view, n.e.addresslist_item_bg);
            if (item.getUserName() != null) {
                cVar.aIb.setText(item.getUserName());
            }
            cVar.aIa.d(item.getUserPortrait(), 12, false);
            return view;
        }
    }

    /* loaded from: classes.dex */
    private class c {
        public HeadImageView aIa;
        public TextView aIb;

        private c() {
        }

        /* synthetic */ c(QuickSearchActivity quickSearchActivity, c cVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        as.i(this.aHS, n.c.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aHX.notifyDataSetChanged();
        as.b(this.aHV, n.c.cp_cont_d, 1);
    }
}

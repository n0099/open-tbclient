package com.baidu.tieba.addresslist;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.addresslist.model.QuickSearchModel;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class QuickSearchActivity extends BaseActivity<QuickSearchActivity> {
    private QuickSearchModel bee;
    private View bef;
    private EditText beh;
    private TextView bei;
    private TextView bej;
    private ListView bek;
    private b bel;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.i.quick_search_activity);
        this.bee = new QuickSearchModel(this);
        this.bee.setUniqueId(getUniqueId());
        initViews();
    }

    private void initViews() {
        this.bef = findViewById(d.g.quick_search_parent);
        adjustResizeForSoftInput();
        Nk();
        this.bek = (ListView) findViewById(d.g.quick_search_result);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.bek.addHeaderView(textView);
        this.bek.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.b(QuickSearchActivity.this.getPageContext().getPageActivity(), QuickSearchActivity.this.beh);
                    return false;
                }
                return false;
            }
        });
        this.bel = new b();
        this.bek.setAdapter((ListAdapter) this.bel);
        this.bek.setOnItemClickListener(this);
        this.bej = (TextView) findViewById(d.g.quick_search_empty_result);
        this.bef.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.b(QuickSearchActivity.this.getPageContext().getPageActivity(), QuickSearchActivity.this.beh);
                    return false;
                }
                return false;
            }
        });
    }

    private void Nk() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (QuickSearchActivity.this.beh.hasFocus()) {
                    l.b(QuickSearchActivity.this.getPageContext().getPageActivity(), QuickSearchActivity.this.beh);
                }
                QuickSearchActivity.this.closeActivity();
            }
        });
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, d.i.quick_search_navigation, (View.OnClickListener) null);
        this.beh = (EditText) addCustomView.findViewById(d.g.quick_search_input);
        this.beh.addTextChangedListener(new a());
        this.beh.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z) {
                if (!z) {
                    l.b(QuickSearchActivity.this.getPageContext().getPageActivity(), view2);
                }
            }
        });
        this.beh.requestFocus();
        this.bei = (TextView) addCustomView.findViewById(d.g.quick_search_delete_button);
        l.a(getPageContext().getPageActivity(), this.bei, 10, 10, 10, 10);
        this.bei.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                QuickSearchActivity.this.beh.setText("");
                QuickSearchActivity.this.bej.setVisibility(8);
                QuickSearchActivity.this.bek.setVisibility(8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        l.b(getPageContext().getPageActivity(), this.beh);
        this.bee = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ig(String str) {
        List<com.baidu.tbadk.coreExtra.relationship.a> it = this.bee.it(str);
        if (it.size() > 0) {
            cp(true);
            this.bel.setContacts(it);
            this.bel.notifyDataSetChanged();
            this.bek.setSelection(0);
            return;
        }
        cp(false);
    }

    private void cp(boolean z) {
        this.bek.setVisibility(z ? 0 : 8);
        this.bej.setVisibility(z ? 8 : 0);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
        int headerViewsCount = this.bek.getHeaderViewsCount();
        if (headerViewsCount > 0) {
            i -= headerViewsCount;
        }
        com.baidu.tbadk.coreExtra.relationship.a item = this.bel.getItem(i);
        if (item != null && item.getUserId() > 0) {
            if (item.getUserType() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), item.getUserId(), item.getUserName(), item.BF(), 0, 4)));
                return;
            }
            sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), String.valueOf(item.getUserId()), item.getUserName())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements TextWatcher {
        private a() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (charSequence.toString().trim().length() != 0) {
                QuickSearchActivity.this.ig(charSequence.toString());
                return;
            }
            QuickSearchActivity.this.bej.setVisibility(8);
            QuickSearchActivity.this.bek.setVisibility(8);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.toString().trim().length() == 0) {
                QuickSearchActivity.this.bei.setVisibility(8);
            } else {
                QuickSearchActivity.this.bei.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends BaseAdapter {
        private List<com.baidu.tbadk.coreExtra.relationship.a> ben;

        private b() {
            this.ben = new ArrayList();
        }

        public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
            this.ben = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.ben != null) {
                return this.ben.size();
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: gu */
        public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
            if (this.ben == null || i < 0 || i >= getCount()) {
                return null;
            }
            return this.ben.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view2, ViewGroup viewGroup) {
            c cVar;
            com.baidu.tbadk.core.c layoutMode = QuickSearchActivity.this.getLayoutMode();
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            }
            com.baidu.tbadk.coreExtra.relationship.a item = getItem(i);
            if (item == null) {
                return null;
            }
            if (view2 == null) {
                view2 = LayoutInflater.from(QuickSearchActivity.this.getPageContext().getPageActivity()).inflate(d.i.quick_search_item, (ViewGroup) null);
                c cVar2 = new c();
                cVar2.beo = (HeadImageView) view2.findViewById(d.g.quick_search_item_icon);
                cVar2.bep = (TextView) view2.findViewById(d.g.quick_search_item_text);
                view2.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view2.getTag();
            }
            layoutMode.u(view2);
            ak.i(view2, d.f.addresslist_item_bg);
            if (item.getUserName() != null) {
                cVar.bep.setText(item.getUserName());
            }
            cVar.beo.startLoad(item.BF(), 12, false);
            return view2;
        }
    }

    /* loaded from: classes3.dex */
    private class c {
        public HeadImageView beo;
        public TextView bep;

        private c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ak.i(this.bef, d.C0126d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bel.notifyDataSetChanged();
        ak.c(this.bej, d.C0126d.cp_cont_d, 1);
    }
}

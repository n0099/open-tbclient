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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.addresslist.model.QuickSearchModel;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class QuickSearchActivity extends BaseActivity<QuickSearchActivity> {
    private QuickSearchModel bCA;
    private View bCB;
    private TextView bCC;
    private TextView bCD;
    private ListView bCE;
    private b bCF;
    private EditText mInputEditText;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(e.h.quick_search_activity);
        this.bCA = new QuickSearchModel(this);
        this.bCA.setUniqueId(getUniqueId());
        initViews();
    }

    private void initViews() {
        this.bCB = findViewById(e.g.quick_search_parent);
        adjustResizeForSoftInput();
        Wu();
        this.bCE = (ListView) findViewById(e.g.quick_search_result);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.bCE.addHeaderView(textView);
        this.bCE.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.b(QuickSearchActivity.this.getPageContext().getPageActivity(), QuickSearchActivity.this.mInputEditText);
                    return false;
                }
                return false;
            }
        });
        this.bCF = new b();
        this.bCE.setAdapter((ListAdapter) this.bCF);
        this.bCE.setOnItemClickListener(this);
        this.bCD = (TextView) findViewById(e.g.quick_search_empty_result);
        this.bCB.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.b(QuickSearchActivity.this.getPageContext().getPageActivity(), QuickSearchActivity.this.mInputEditText);
                    return false;
                }
                return false;
            }
        });
    }

    private void Wu() {
        this.mNavigationBar = (NavigationBar) findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (QuickSearchActivity.this.mInputEditText.hasFocus()) {
                    l.b(QuickSearchActivity.this.getPageContext().getPageActivity(), QuickSearchActivity.this.mInputEditText);
                }
                QuickSearchActivity.this.closeActivity();
            }
        });
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, e.h.quick_search_navigation, (View.OnClickListener) null);
        this.mInputEditText = (EditText) addCustomView.findViewById(e.g.quick_search_input);
        this.mInputEditText.addTextChangedListener(new a());
        this.mInputEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.b(QuickSearchActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.mInputEditText.requestFocus();
        this.bCC = (TextView) addCustomView.findViewById(e.g.quick_search_delete_button);
        l.b(getPageContext().getPageActivity(), this.bCC, 10, 10, 10, 10);
        this.bCC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                QuickSearchActivity.this.mInputEditText.setText("");
                QuickSearchActivity.this.bCD.setVisibility(8);
                QuickSearchActivity.this.bCE.setVisibility(8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        l.b(getPageContext().getPageActivity(), this.mInputEditText);
        this.bCA = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jV(String str) {
        List<com.baidu.tbadk.coreExtra.relationship.a> ki = this.bCA.ki(str);
        if (ki.size() > 0) {
            dr(true);
            this.bCF.setContacts(ki);
            this.bCF.notifyDataSetChanged();
            this.bCE.setSelection(0);
            return;
        }
        dr(false);
    }

    private void dr(boolean z) {
        this.bCE.setVisibility(z ? 0 : 8);
        this.bCD.setVisibility(z ? 8 : 0);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int headerViewsCount = this.bCE.getHeaderViewsCount();
        if (headerViewsCount > 0) {
            i -= headerViewsCount;
        }
        com.baidu.tbadk.coreExtra.relationship.a item = this.bCF.getItem(i);
        if (item != null && item.getUserId() > 0) {
            if (item.getUserType() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), item.getUserId(), item.getUserName(), item.Kc(), 0, 4)));
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
                QuickSearchActivity.this.jV(charSequence.toString());
                return;
            }
            QuickSearchActivity.this.bCD.setVisibility(8);
            QuickSearchActivity.this.bCE.setVisibility(8);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.toString().trim().length() == 0) {
                QuickSearchActivity.this.bCC.setVisibility(8);
            } else {
                QuickSearchActivity.this.bCC.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends BaseAdapter {
        private List<com.baidu.tbadk.coreExtra.relationship.a> bCH;

        private b() {
            this.bCH = new ArrayList();
        }

        public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
            this.bCH = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.bCH != null) {
                return this.bCH.size();
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: hL */
        public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
            if (this.bCH == null || i < 0 || i >= getCount()) {
                return null;
            }
            return this.bCH.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            c cVar;
            com.baidu.tbadk.core.c layoutMode = QuickSearchActivity.this.getLayoutMode();
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            }
            com.baidu.tbadk.coreExtra.relationship.a item = getItem(i);
            if (item == null) {
                return null;
            }
            if (view == null) {
                view = LayoutInflater.from(QuickSearchActivity.this.getPageContext().getPageActivity()).inflate(e.h.quick_search_item, (ViewGroup) null);
                c cVar2 = new c();
                cVar2.bCI = (HeadImageView) view.findViewById(e.g.quick_search_item_icon);
                cVar2.bCJ = (TextView) view.findViewById(e.g.quick_search_item_text);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            layoutMode.onModeChanged(view);
            al.i(view, e.f.addresslist_item_bg);
            if (item.getUserName() != null) {
                cVar.bCJ.setText(item.getUserName());
            }
            cVar.bCI.startLoad(item.Kc(), 12, false);
            return view;
        }
    }

    /* loaded from: classes3.dex */
    private class c {
        public HeadImageView bCI;
        public TextView bCJ;

        private c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.i(this.bCB, e.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bCF.notifyDataSetChanged();
        al.c(this.bCD, e.d.cp_cont_d, 1);
    }
}

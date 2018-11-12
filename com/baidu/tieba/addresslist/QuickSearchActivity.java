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
    private QuickSearchModel bza;
    private View bzb;
    private TextView bzc;
    private TextView bzd;
    private ListView bze;
    private b bzf;
    private EditText mInputEditText;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(e.h.quick_search_activity);
        this.bza = new QuickSearchModel(this);
        this.bza.setUniqueId(getUniqueId());
        initViews();
    }

    private void initViews() {
        this.bzb = findViewById(e.g.quick_search_parent);
        adjustResizeForSoftInput();
        Vm();
        this.bze = (ListView) findViewById(e.g.quick_search_result);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.bze.addHeaderView(textView);
        this.bze.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.b(QuickSearchActivity.this.getPageContext().getPageActivity(), QuickSearchActivity.this.mInputEditText);
                    return false;
                }
                return false;
            }
        });
        this.bzf = new b();
        this.bze.setAdapter((ListAdapter) this.bzf);
        this.bze.setOnItemClickListener(this);
        this.bzd = (TextView) findViewById(e.g.quick_search_empty_result);
        this.bzb.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.2
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

    private void Vm() {
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
        this.bzc = (TextView) addCustomView.findViewById(e.g.quick_search_delete_button);
        l.b(getPageContext().getPageActivity(), this.bzc, 10, 10, 10, 10);
        this.bzc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                QuickSearchActivity.this.mInputEditText.setText("");
                QuickSearchActivity.this.bzd.setVisibility(8);
                QuickSearchActivity.this.bze.setVisibility(8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        l.b(getPageContext().getPageActivity(), this.mInputEditText);
        this.bza = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jC(String str) {
        List<com.baidu.tbadk.coreExtra.relationship.a> jP = this.bza.jP(str);
        if (jP.size() > 0) {
            dq(true);
            this.bzf.setContacts(jP);
            this.bzf.notifyDataSetChanged();
            this.bze.setSelection(0);
            return;
        }
        dq(false);
    }

    private void dq(boolean z) {
        this.bze.setVisibility(z ? 0 : 8);
        this.bzd.setVisibility(z ? 8 : 0);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int headerViewsCount = this.bze.getHeaderViewsCount();
        if (headerViewsCount > 0) {
            i -= headerViewsCount;
        }
        com.baidu.tbadk.coreExtra.relationship.a item = this.bzf.getItem(i);
        if (item != null && item.getUserId() > 0) {
            if (item.getUserType() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), item.getUserId(), item.getUserName(), item.IX(), 0, 4)));
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
                QuickSearchActivity.this.jC(charSequence.toString());
                return;
            }
            QuickSearchActivity.this.bzd.setVisibility(8);
            QuickSearchActivity.this.bze.setVisibility(8);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.toString().trim().length() == 0) {
                QuickSearchActivity.this.bzc.setVisibility(8);
            } else {
                QuickSearchActivity.this.bzc.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends BaseAdapter {
        private List<com.baidu.tbadk.coreExtra.relationship.a> bzh;

        private b() {
            this.bzh = new ArrayList();
        }

        public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
            this.bzh = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.bzh != null) {
                return this.bzh.size();
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: hw */
        public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
            if (this.bzh == null || i < 0 || i >= getCount()) {
                return null;
            }
            return this.bzh.get(i);
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
                cVar2.bzi = (HeadImageView) view.findViewById(e.g.quick_search_item_icon);
                cVar2.bzj = (TextView) view.findViewById(e.g.quick_search_item_text);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            layoutMode.onModeChanged(view);
            al.i(view, e.f.addresslist_item_bg);
            if (item.getUserName() != null) {
                cVar.bzj.setText(item.getUserName());
            }
            cVar.bzi.startLoad(item.IX(), 12, false);
            return view;
        }
    }

    /* loaded from: classes3.dex */
    private class c {
        public HeadImageView bzi;
        public TextView bzj;

        private c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.i(this.bzb, e.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bzf.notifyDataSetChanged();
        al.c(this.bzd, e.d.cp_cont_d, 1);
    }
}

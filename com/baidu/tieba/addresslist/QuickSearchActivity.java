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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.addresslist.model.QuickSearchModel;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class QuickSearchActivity extends BaseActivity<QuickSearchActivity> {
    private QuickSearchModel bUj;
    private View bUk;
    private EditText bUl;
    private TextView bUm;
    private TextView bUn;
    private ListView bUo;
    private b bUp;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.quick_search_activity);
        this.bUj = new QuickSearchModel(this);
        this.bUj.setUniqueId(getUniqueId());
        initViews();
    }

    private void initViews() {
        this.bUk = findViewById(d.g.quick_search_parent);
        adjustResizeForSoftInput();
        UL();
        this.bUo = (ListView) findViewById(d.g.quick_search_result);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.bUo.addHeaderView(textView);
        this.bUo.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.a(QuickSearchActivity.this.getPageContext().getPageActivity(), QuickSearchActivity.this.bUl);
                    return false;
                }
                return false;
            }
        });
        this.bUp = new b();
        this.bUo.setAdapter((ListAdapter) this.bUp);
        this.bUo.setOnItemClickListener(this);
        this.bUn = (TextView) findViewById(d.g.quick_search_empty_result);
        this.bUk.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.a(QuickSearchActivity.this.getPageContext().getPageActivity(), QuickSearchActivity.this.bUl);
                    return false;
                }
                return false;
            }
        });
    }

    private void UL() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (QuickSearchActivity.this.bUl.hasFocus()) {
                    l.a(QuickSearchActivity.this.getPageContext().getPageActivity(), QuickSearchActivity.this.bUl);
                }
                QuickSearchActivity.this.closeActivity();
            }
        });
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, d.h.quick_search_navigation, (View.OnClickListener) null);
        this.bUl = (EditText) addCustomView.findViewById(d.g.quick_search_input);
        this.bUl.addTextChangedListener(new a());
        this.bUl.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.a(QuickSearchActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.bUl.requestFocus();
        this.bUm = (TextView) addCustomView.findViewById(d.g.quick_search_delete_button);
        l.a(getPageContext().getPageActivity(), this.bUm, 10, 10, 10, 10);
        this.bUm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                QuickSearchActivity.this.bUl.setText("");
                QuickSearchActivity.this.bUn.setVisibility(8);
                QuickSearchActivity.this.bUo.setVisibility(8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        l.a(getPageContext().getPageActivity(), this.bUl);
        this.bUj = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ij(String str) {
        List<com.baidu.tbadk.coreExtra.relationship.a> iw = this.bUj.iw(str);
        if (iw.size() > 0) {
            cY(true);
            this.bUp.setContacts(iw);
            this.bUp.notifyDataSetChanged();
            this.bUo.setSelection(0);
            return;
        }
        cY(false);
    }

    private void cY(boolean z) {
        this.bUo.setVisibility(z ? 0 : 8);
        this.bUn.setVisibility(z ? 8 : 0);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int headerViewsCount = this.bUo.getHeaderViewsCount();
        if (headerViewsCount > 0) {
            i -= headerViewsCount;
        }
        com.baidu.tbadk.coreExtra.relationship.a item = this.bUp.getItem(i);
        if (item != null && item.getUserId() > 0) {
            if (item.getUserType() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), item.getUserId(), item.getUserName(), item.IT(), 0, 4)));
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
                QuickSearchActivity.this.ij(charSequence.toString());
                return;
            }
            QuickSearchActivity.this.bUn.setVisibility(8);
            QuickSearchActivity.this.bUo.setVisibility(8);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.toString().trim().length() == 0) {
                QuickSearchActivity.this.bUm.setVisibility(8);
            } else {
                QuickSearchActivity.this.bUm.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends BaseAdapter {
        private List<com.baidu.tbadk.coreExtra.relationship.a> bUr;

        private b() {
            this.bUr = new ArrayList();
        }

        public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
            this.bUr = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.bUr != null) {
                return this.bUr.size();
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: jp */
        public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
            if (this.bUr == null || i < 0 || i >= getCount()) {
                return null;
            }
            return this.bUr.get(i);
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
                view = LayoutInflater.from(QuickSearchActivity.this.getPageContext().getPageActivity()).inflate(d.h.quick_search_item, (ViewGroup) null);
                c cVar2 = new c();
                cVar2.bUs = (HeadImageView) view.findViewById(d.g.quick_search_item_icon);
                cVar2.bUt = (TextView) view.findViewById(d.g.quick_search_item_text);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            layoutMode.aM(view);
            aj.s(view, d.f.addresslist_item_bg);
            if (item.getUserName() != null) {
                cVar.bUt.setText(item.getUserName());
            }
            cVar.bUs.startLoad(item.IT(), 12, false);
            return view;
        }
    }

    /* loaded from: classes3.dex */
    private class c {
        public HeadImageView bUs;
        public TextView bUt;

        private c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aj.s(this.bUk, d.C0140d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bUp.notifyDataSetChanged();
        aj.e(this.bUn, d.C0140d.cp_cont_d, 1);
    }
}

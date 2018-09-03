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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.addresslist.model.QuickSearchModel;
import com.baidu.tieba.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class QuickSearchActivity extends BaseActivity<QuickSearchActivity> {
    private ListView boA;
    private b boB;
    private QuickSearchModel bov;
    private View bow;
    private EditText box;
    private TextView boy;
    private TextView boz;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(f.h.quick_search_activity);
        this.bov = new QuickSearchModel(this);
        this.bov.setUniqueId(getUniqueId());
        initViews();
    }

    private void initViews() {
        this.bow = findViewById(f.g.quick_search_parent);
        adjustResizeForSoftInput();
        Rt();
        this.boA = (ListView) findViewById(f.g.quick_search_result);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.boA.addHeaderView(textView);
        this.boA.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.a(QuickSearchActivity.this.getPageContext().getPageActivity(), QuickSearchActivity.this.box);
                    return false;
                }
                return false;
            }
        });
        this.boB = new b();
        this.boA.setAdapter((ListAdapter) this.boB);
        this.boA.setOnItemClickListener(this);
        this.boz = (TextView) findViewById(f.g.quick_search_empty_result);
        this.bow.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.a(QuickSearchActivity.this.getPageContext().getPageActivity(), QuickSearchActivity.this.box);
                    return false;
                }
                return false;
            }
        });
    }

    private void Rt() {
        this.mNavigationBar = (NavigationBar) findViewById(f.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (QuickSearchActivity.this.box.hasFocus()) {
                    l.a(QuickSearchActivity.this.getPageContext().getPageActivity(), QuickSearchActivity.this.box);
                }
                QuickSearchActivity.this.closeActivity();
            }
        });
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, f.h.quick_search_navigation, (View.OnClickListener) null);
        this.box = (EditText) addCustomView.findViewById(f.g.quick_search_input);
        this.box.addTextChangedListener(new a());
        this.box.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.a(QuickSearchActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.box.requestFocus();
        this.boy = (TextView) addCustomView.findViewById(f.g.quick_search_delete_button);
        l.a(getPageContext().getPageActivity(), this.boy, 10, 10, 10, 10);
        this.boy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                QuickSearchActivity.this.box.setText("");
                QuickSearchActivity.this.boz.setVisibility(8);
                QuickSearchActivity.this.boA.setVisibility(8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        l.a(getPageContext().getPageActivity(), this.box);
        this.bov = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iL(String str) {
        List<com.baidu.tbadk.coreExtra.relationship.a> iY = this.bov.iY(str);
        if (iY.size() > 0) {
            cz(true);
            this.boB.setContacts(iY);
            this.boB.notifyDataSetChanged();
            this.boA.setSelection(0);
            return;
        }
        cz(false);
    }

    private void cz(boolean z) {
        this.boA.setVisibility(z ? 0 : 8);
        this.boz.setVisibility(z ? 8 : 0);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int headerViewsCount = this.boA.getHeaderViewsCount();
        if (headerViewsCount > 0) {
            i -= headerViewsCount;
        }
        com.baidu.tbadk.coreExtra.relationship.a item = this.boB.getItem(i);
        if (item != null && item.getUserId() > 0) {
            if (item.getUserType() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), item.getUserId(), item.getUserName(), item.Fu(), 0, 4)));
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
                QuickSearchActivity.this.iL(charSequence.toString());
                return;
            }
            QuickSearchActivity.this.boz.setVisibility(8);
            QuickSearchActivity.this.boA.setVisibility(8);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.toString().trim().length() == 0) {
                QuickSearchActivity.this.boy.setVisibility(8);
            } else {
                QuickSearchActivity.this.boy.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends BaseAdapter {
        private List<com.baidu.tbadk.coreExtra.relationship.a> boD;

        private b() {
            this.boD = new ArrayList();
        }

        public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
            this.boD = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.boD != null) {
                return this.boD.size();
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: gB */
        public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
            if (this.boD == null || i < 0 || i >= getCount()) {
                return null;
            }
            return this.boD.get(i);
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
                view = LayoutInflater.from(QuickSearchActivity.this.getPageContext().getPageActivity()).inflate(f.h.quick_search_item, (ViewGroup) null);
                c cVar2 = new c();
                cVar2.boE = (HeadImageView) view.findViewById(f.g.quick_search_item_icon);
                cVar2.boF = (TextView) view.findViewById(f.g.quick_search_item_text);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            layoutMode.onModeChanged(view);
            am.i(view, f.C0146f.addresslist_item_bg);
            if (item.getUserName() != null) {
                cVar.boF.setText(item.getUserName());
            }
            cVar.boE.startLoad(item.Fu(), 12, false);
            return view;
        }
    }

    /* loaded from: classes3.dex */
    private class c {
        public HeadImageView boE;
        public TextView boF;

        private c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.i(this.bow, f.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.boB.notifyDataSetChanged();
        am.c(this.boz, f.d.cp_cont_d, 1);
    }
}

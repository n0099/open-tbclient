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
    private QuickSearchModel bTX;
    private View bTY;
    private EditText bTZ;
    private TextView bUa;
    private TextView bUb;
    private ListView bUc;
    private b bUd;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.quick_search_activity);
        this.bTX = new QuickSearchModel(this);
        this.bTX.setUniqueId(getUniqueId());
        initViews();
    }

    private void initViews() {
        this.bTY = findViewById(d.g.quick_search_parent);
        adjustResizeForSoftInput();
        UK();
        this.bUc = (ListView) findViewById(d.g.quick_search_result);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.bUc.addHeaderView(textView);
        this.bUc.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.a(QuickSearchActivity.this.getPageContext().getPageActivity(), QuickSearchActivity.this.bTZ);
                    return false;
                }
                return false;
            }
        });
        this.bUd = new b();
        this.bUc.setAdapter((ListAdapter) this.bUd);
        this.bUc.setOnItemClickListener(this);
        this.bUb = (TextView) findViewById(d.g.quick_search_empty_result);
        this.bTY.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.a(QuickSearchActivity.this.getPageContext().getPageActivity(), QuickSearchActivity.this.bTZ);
                    return false;
                }
                return false;
            }
        });
    }

    private void UK() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (QuickSearchActivity.this.bTZ.hasFocus()) {
                    l.a(QuickSearchActivity.this.getPageContext().getPageActivity(), QuickSearchActivity.this.bTZ);
                }
                QuickSearchActivity.this.closeActivity();
            }
        });
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, d.h.quick_search_navigation, (View.OnClickListener) null);
        this.bTZ = (EditText) addCustomView.findViewById(d.g.quick_search_input);
        this.bTZ.addTextChangedListener(new a());
        this.bTZ.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.a(QuickSearchActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.bTZ.requestFocus();
        this.bUa = (TextView) addCustomView.findViewById(d.g.quick_search_delete_button);
        l.a(getPageContext().getPageActivity(), this.bUa, 10, 10, 10, 10);
        this.bUa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.addresslist.QuickSearchActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                QuickSearchActivity.this.bTZ.setText("");
                QuickSearchActivity.this.bUb.setVisibility(8);
                QuickSearchActivity.this.bUc.setVisibility(8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        l.a(getPageContext().getPageActivity(), this.bTZ);
        this.bTX = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ij(String str) {
        List<com.baidu.tbadk.coreExtra.relationship.a> iw = this.bTX.iw(str);
        if (iw.size() > 0) {
            cY(true);
            this.bUd.setContacts(iw);
            this.bUd.notifyDataSetChanged();
            this.bUc.setSelection(0);
            return;
        }
        cY(false);
    }

    private void cY(boolean z) {
        this.bUc.setVisibility(z ? 0 : 8);
        this.bUb.setVisibility(z ? 8 : 0);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int headerViewsCount = this.bUc.getHeaderViewsCount();
        if (headerViewsCount > 0) {
            i -= headerViewsCount;
        }
        com.baidu.tbadk.coreExtra.relationship.a item = this.bUd.getItem(i);
        if (item != null && item.getUserId() > 0) {
            if (item.getUserType() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), item.getUserId(), item.getUserName(), item.IS(), 0, 4)));
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
            QuickSearchActivity.this.bUb.setVisibility(8);
            QuickSearchActivity.this.bUc.setVisibility(8);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.toString().trim().length() == 0) {
                QuickSearchActivity.this.bUa.setVisibility(8);
            } else {
                QuickSearchActivity.this.bUa.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends BaseAdapter {
        private List<com.baidu.tbadk.coreExtra.relationship.a> bUf;

        private b() {
            this.bUf = new ArrayList();
        }

        public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
            this.bUf = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.bUf != null) {
                return this.bUf.size();
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: jp */
        public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
            if (this.bUf == null || i < 0 || i >= getCount()) {
                return null;
            }
            return this.bUf.get(i);
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
                cVar2.bUg = (HeadImageView) view.findViewById(d.g.quick_search_item_icon);
                cVar2.bUh = (TextView) view.findViewById(d.g.quick_search_item_text);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            layoutMode.aM(view);
            aj.s(view, d.f.addresslist_item_bg);
            if (item.getUserName() != null) {
                cVar.bUh.setText(item.getUserName());
            }
            cVar.bUg.startLoad(item.IS(), 12, false);
            return view;
        }
    }

    /* loaded from: classes3.dex */
    private class c {
        public HeadImageView bUg;
        public TextView bUh;

        private c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aj.s(this.bTY, d.C0141d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bUd.notifyDataSetChanged();
        aj.e(this.bUb, d.C0141d.cp_cont_d, 1);
    }
}

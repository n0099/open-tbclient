package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class SearchBar extends LinearLayout {
    private final Context a;
    private EditText b;
    private Button c;
    private Button d;
    private ag e;

    public SearchBar(Context context) {
        super(context);
        this.a = context;
        a();
    }

    public SearchBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = context;
        a();
    }

    public final void a(int i) {
        if (i == 1) {
            this.b.setHintTextColor(getResources().getColor(com.baidu.tbadk.g.widget_searchbox_text_1));
            setBackgroundColor(getResources().getColor(com.baidu.tbadk.g.search_box_bg_1));
            return;
        }
        this.b.setHintTextColor(getResources().getColor(com.baidu.tbadk.g.widget_searchbox_text));
        setBackgroundColor(getResources().getColor(com.baidu.tbadk.g.search_box_bg));
    }

    private void a() {
        LayoutInflater.from(this.a).inflate(com.baidu.tbadk.k.search_bar, (ViewGroup) this, true);
        this.b = (EditText) findViewById(com.baidu.tbadk.j.home_et_search);
        this.c = (Button) findViewById(com.baidu.tbadk.j.home_bt_search_del);
        this.d = (Button) findViewById(com.baidu.tbadk.j.home_bt_search_s);
        this.b.addTextChangedListener(new ad(this));
        this.c.setOnClickListener(new ae(this));
        this.d.setOnClickListener(new af(this));
        a(TbadkApplication.j().l());
    }

    public void setHint(String str) {
        this.b.setHint(str);
    }

    public void setHandler(ag agVar) {
        this.e = agVar;
    }

    public int getSearchButtonId() {
        return this.d.getId();
    }

    public EditText getEditText() {
        return this.b;
    }

    public void setSearchText(String str) {
        this.b.setText(str);
    }

    public String getSearchText() {
        Editable text = this.b.getText();
        return text != null ? text.toString() : "";
    }
}

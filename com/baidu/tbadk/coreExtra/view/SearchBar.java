package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class SearchBar extends LinearLayout {
    private final Context a;
    private EditText b;
    private ImageView c;
    private LinearLayout d;
    private ImageView e;
    private au f;

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

    public void a(int i) {
        if (i == 1) {
            setBackgroundResource(com.baidu.tieba.r.cp_bg_line_d_1);
            this.d.setBackgroundResource(com.baidu.tieba.t.inputbox_top_1);
            this.e.setImageResource(com.baidu.tieba.t.icon_head_bar_search_1);
            this.b.setTextColor(getResources().getColor(com.baidu.tieba.r.widget_searchbox_text_1));
            this.b.setHintTextColor(getResources().getColor(com.baidu.tieba.r.widget_searchbox_text_1));
            this.c.setImageResource(com.baidu.tieba.t.search_delete_button_1);
            return;
        }
        setBackgroundResource(com.baidu.tieba.r.cp_bg_line_d);
        this.d.setBackgroundResource(com.baidu.tieba.t.inputbox_top);
        this.e.setImageResource(com.baidu.tieba.t.icon_head_bar_search);
        this.b.setTextColor(getResources().getColor(com.baidu.tieba.r.widget_searchbox_text));
        this.b.setHintTextColor(getResources().getColor(com.baidu.tieba.r.widget_searchbox_text));
        this.c.setImageResource(com.baidu.tieba.t.search_delete_button);
    }

    private void a() {
        LayoutInflater.from(this.a).inflate(com.baidu.tieba.v.search_bar, (ViewGroup) this, true);
        this.b = (EditText) findViewById(com.baidu.tieba.u.home_et_search);
        this.c = (ImageView) findViewById(com.baidu.tieba.u.home_iv_search_del);
        this.d = (LinearLayout) findViewById(com.baidu.tieba.u.search_tap_text_layout);
        this.e = (ImageView) findViewById(com.baidu.tieba.u.search_bar_icon);
        this.b.addTextChangedListener(new as(this));
        this.c.setOnClickListener(new at(this));
        a(TbadkApplication.m252getInst().getSkinType());
    }

    public void setHint(String str) {
        this.b.setHint(str);
    }

    public void setHandler(au auVar) {
        this.f = auVar;
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

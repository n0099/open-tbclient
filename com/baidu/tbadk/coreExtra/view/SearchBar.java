package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bc;
/* loaded from: classes.dex */
public class SearchBar extends LinearLayout {
    private ImageView Vs;
    private LinearLayout Vt;
    private ImageView Vu;
    private au Vv;
    private final Context mContext;
    private EditText mEditText;

    public SearchBar(Context context) {
        super(context);
        this.mContext = context;
        initialize();
    }

    public SearchBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initialize();
    }

    public void onChangeSkinType(int i) {
        bc.j(this, com.baidu.tieba.t.cp_bg_line_d);
        bc.i(this.Vt, com.baidu.tieba.v.inputbox_top);
        bc.c(this.Vu, com.baidu.tieba.v.icon_head_bar_search);
        bc.b(this.mEditText, com.baidu.tieba.t.widget_searchbox_text, 2);
        this.mEditText.setHintTextColor(bc.cd(com.baidu.tieba.t.widget_searchbox_text));
        bc.c(this.Vs, com.baidu.tieba.v.search_delete_button);
    }

    private void initialize() {
        com.baidu.adp.lib.g.b.ei().a(this.mContext, com.baidu.tieba.x.search_bar, this, true);
        this.mEditText = (EditText) findViewById(com.baidu.tieba.w.home_et_search);
        this.Vs = (ImageView) findViewById(com.baidu.tieba.w.home_iv_search_del);
        this.Vt = (LinearLayout) findViewById(com.baidu.tieba.w.search_tap_text_layout);
        this.Vu = (ImageView) findViewById(com.baidu.tieba.w.search_bar_icon);
        this.mEditText.addTextChangedListener(new as(this));
        this.Vs.setOnClickListener(new at(this));
        onChangeSkinType(TbadkCoreApplication.m255getInst().getSkinType());
    }

    public void setHint(String str) {
        this.mEditText.setHint(str);
    }

    public void setHandler(au auVar) {
        this.Vv = auVar;
    }

    public EditText getEditText() {
        return this.mEditText;
    }

    public void setSearchText(String str) {
        this.mEditText.setText(str);
    }

    public String getSearchText() {
        Editable text = this.mEditText.getText();
        return text != null ? text.toString() : "";
    }
}

package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class SearchBar extends LinearLayout {
    private ImageView Pb;
    private LinearLayout Pc;
    private ImageView Pd;
    private at Pe;
    private final Context mContext;
    private EditText mEditText;

    public SearchBar(Context context) {
        super(context);
        this.mContext = context;
        ny();
    }

    public SearchBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        ny();
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.core.util.aw.i(this, com.baidu.tieba.s.cp_bg_line_d);
        com.baidu.tbadk.core.util.aw.h(this.Pc, com.baidu.tieba.u.inputbox_top);
        com.baidu.tbadk.core.util.aw.c(this.Pd, com.baidu.tieba.u.icon_head_bar_search);
        com.baidu.tbadk.core.util.aw.b(this.mEditText, com.baidu.tieba.s.widget_searchbox_text, 2);
        this.mEditText.setHintTextColor(com.baidu.tbadk.core.util.aw.bz(com.baidu.tieba.s.widget_searchbox_text));
        com.baidu.tbadk.core.util.aw.c(this.Pb, com.baidu.tieba.u.search_delete_button);
    }

    private void ny() {
        com.baidu.adp.lib.g.b.ek().a(this.mContext, com.baidu.tieba.w.search_bar, this, true);
        this.mEditText = (EditText) findViewById(com.baidu.tieba.v.home_et_search);
        this.Pb = (ImageView) findViewById(com.baidu.tieba.v.home_iv_search_del);
        this.Pc = (LinearLayout) findViewById(com.baidu.tieba.v.search_tap_text_layout);
        this.Pd = (ImageView) findViewById(com.baidu.tieba.v.search_bar_icon);
        this.mEditText.addTextChangedListener(new ar(this));
        this.Pb.setOnClickListener(new as(this));
        onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
    }

    public void setHint(String str) {
        this.mEditText.setHint(str);
    }

    public void setHandler(at atVar) {
        this.Pe = atVar;
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

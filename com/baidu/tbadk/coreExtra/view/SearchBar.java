package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class SearchBar extends LinearLayout {
    private ImageView UM;
    private LinearLayout UN;
    private ImageView UO;
    private au UQ;
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
        com.baidu.tbadk.core.util.ax.j(this, com.baidu.tieba.t.cp_bg_line_d);
        com.baidu.tbadk.core.util.ax.i(this.UN, com.baidu.tieba.v.inputbox_top);
        com.baidu.tbadk.core.util.ax.c(this.UO, com.baidu.tieba.v.icon_head_bar_search);
        com.baidu.tbadk.core.util.ax.b(this.mEditText, com.baidu.tieba.t.widget_searchbox_text, 2);
        this.mEditText.setHintTextColor(com.baidu.tbadk.core.util.ax.bW(com.baidu.tieba.t.widget_searchbox_text));
        com.baidu.tbadk.core.util.ax.c(this.UM, com.baidu.tieba.v.search_delete_button);
    }

    private void initialize() {
        com.baidu.adp.lib.g.b.ek().a(this.mContext, com.baidu.tieba.x.search_bar, this, true);
        this.mEditText = (EditText) findViewById(com.baidu.tieba.w.home_et_search);
        this.UM = (ImageView) findViewById(com.baidu.tieba.w.home_iv_search_del);
        this.UN = (LinearLayout) findViewById(com.baidu.tieba.w.search_tap_text_layout);
        this.UO = (ImageView) findViewById(com.baidu.tieba.w.search_bar_icon);
        this.mEditText.addTextChangedListener(new as(this));
        this.UM.setOnClickListener(new at(this));
        onChangeSkinType(TbadkCoreApplication.m255getInst().getSkinType());
    }

    public void setHint(String str) {
        this.mEditText.setHint(str);
    }

    public void setHandler(au auVar) {
        this.UQ = auVar;
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

package com.baidu.tieba.editortool;

import android.content.Context;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PbEditorToolView extends LinearLayout {
    protected PbEditorToolButtonContainer art;
    protected Button aru;
    protected Context mContext;
    protected EditText mEditText;

    public PbEditorToolView(Context context) {
        super(context);
        this.mContext = context;
        ny();
    }

    public PbEditorToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        ny();
    }

    public Button getPostButton() {
        return this.aru;
    }

    public EditText getEditText() {
        return this.mEditText;
    }

    protected void ny() {
        com.baidu.adp.lib.g.b.ek().a(this.mContext, com.baidu.tieba.w.pb_editor_tool_view, this, true);
        this.art = (PbEditorToolButtonContainer) findViewById(com.baidu.tieba.v.tool_button_container);
        this.mEditText = (EditText) findViewById(com.baidu.tieba.v.reply_content);
        this.aru = (Button) findViewById(com.baidu.tieba.v.pb_reply_post);
        this.mEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
    }

    public void p(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    sb.append("@");
                    sb.append(arrayList.get(i2));
                    sb.append(" ");
                    i = i2 + 1;
                } else {
                    String sb2 = sb.toString();
                    this.mEditText.getText().insert(this.mEditText.getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.w wVar) {
        this.art.setOnActionListener(new af(this, wVar));
        this.mEditText.setOnTouchListener(new ag(this, wVar));
        this.mEditText.addTextChangedListener(new ah(this, wVar));
        this.aru.setOnClickListener(new ai(this, wVar));
    }

    public void clearData() {
        this.art.Cm();
        this.mEditText.setText("");
        BY();
    }

    public void Bs() {
        this.art.bA(true);
    }

    public void Bt() {
        this.art.bA(false);
    }

    public void BX() {
        this.aru.setEnabled(true);
        com.baidu.tbadk.core.util.aw.b(this.aru, com.baidu.tieba.s.cp_cont_i, 3);
    }

    public void BY() {
        this.aru.setEnabled(false);
        com.baidu.tbadk.core.util.aw.b(this.aru, com.baidu.tieba.s.cp_cont_d, 3);
    }

    public void Cl() {
        this.art.Cl();
    }

    public void Cm() {
        this.art.Cm();
    }

    public void Cn() {
        this.art.Cn();
    }

    public void Co() {
        this.art.Co();
    }

    public void Bg() {
        this.art.Bg();
    }

    public void setAudioFocusable(boolean z) {
        this.art.setAudioFocusable(z);
    }

    public void setMoreFocusable(boolean z) {
        this.art.setMoreFocusable(z);
    }

    public void changeSkinType(int i) {
        this.mEditText.setHintTextColor(com.baidu.tbadk.core.util.aw.getColor(com.baidu.tieba.s.pb_editor_edittext_hint_text));
        this.aru.setBackgroundDrawable(com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.u.btn_pb_editor_post_btn));
        if (this.aru.isEnabled()) {
            BX();
        } else {
            BY();
        }
        this.art.changeSkinType(i);
    }
}

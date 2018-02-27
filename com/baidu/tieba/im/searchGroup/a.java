package com.baidu.tieba.im.searchGroup;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import com.baidu.adp.base.c;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a extends c<AddGroupActivity> {
    private NavigationBar bVp;
    private View eMi;
    private View eMj;
    private EditText eMk;
    private ImageButton eMl;
    private View eMm;
    private View eMn;
    private AddGroupActivity eMo;
    private ProgressBar progressBar;

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.eMi = null;
        this.bVp = null;
        this.eMj = null;
        this.eMk = null;
        this.eMl = null;
        this.progressBar = null;
        this.eMm = null;
        this.eMo = null;
        this.eMo = addGroupActivity;
        initUI();
    }

    public View aHj() {
        return this.eMl;
    }

    public View aLM() {
        return this.eMm;
    }

    public View aLN() {
        return this.eMj;
    }

    public View aLO() {
        return this.eMn;
    }

    public void aLP() {
        if (this.eMk != null) {
            this.eMk.setText("");
        }
    }

    public void hB(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.eMo.getLayoutMode().aQ(i == 1);
        this.eMo.getLayoutMode().aM(this.eMi);
        this.bVp.onChangeSkinType(this.eMo.getPageContext(), i);
    }

    private void initUI() {
        this.eMo.setContentView(d.h.im_add_group_activity);
        this.eMi = this.eMo.findViewById(d.g.addgroup_rootlayout);
        this.bVp = (NavigationBar) this.eMo.findViewById(d.g.addgroup_navigationbar);
        this.eMj = this.bVp.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bVp.setTitleText(this.eMo.getResources().getString(d.j.add_group_title_main));
        this.eMk = (EditText) this.eMo.findViewById(d.g.addgroup_input);
        this.eMk.setInputType(2);
        this.eMl = (ImageButton) this.eMo.findViewById(d.g.addgroup_delbtn);
        this.eMm = this.eMo.findViewById(d.g.addgroup_searchbutton);
        this.eMn = this.eMo.findViewById(d.g.addgroup_vcode);
        this.eMk.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.im.searchGroup.a.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.eMk.length() > 0) {
                    a.this.eMl.setVisibility(0);
                } else {
                    a.this.eMl.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                a.this.eMm.setTag(editable.toString().trim());
            }
        });
        this.eMm = this.eMo.findViewById(d.g.addgroup_searchbutton);
        this.progressBar = (ProgressBar) this.eMo.findViewById(d.g.addgroup_progress);
        this.eMj.setOnClickListener(this.eMo);
        this.eMl.setOnClickListener(this.eMo);
        this.eMm.setOnClickListener(this.eMo);
        this.eMn.setOnClickListener(this.eMo);
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2902030)) {
            this.eMn.setVisibility(8);
        }
    }
}

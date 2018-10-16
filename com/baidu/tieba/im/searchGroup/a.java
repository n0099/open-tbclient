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
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class a extends c<AddGroupActivity> {
    private NavigationBar bzH;
    private View eQd;
    private View eQe;
    private EditText eQf;
    private ImageButton eQg;
    private View eQh;
    private View eQi;
    private AddGroupActivity eQj;
    private ProgressBar progressBar;

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.eQd = null;
        this.bzH = null;
        this.eQe = null;
        this.eQf = null;
        this.eQg = null;
        this.progressBar = null;
        this.eQh = null;
        this.eQj = null;
        this.eQj = addGroupActivity;
        initUI();
    }

    public View aOl() {
        return this.eQg;
    }

    public View aSM() {
        return this.eQh;
    }

    public View aSN() {
        return this.eQe;
    }

    public View aSO() {
        return this.eQi;
    }

    public void aSP() {
        if (this.eQf != null) {
            this.eQf.setText("");
        }
    }

    public void iq(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.eQj.getLayoutMode().setNightMode(i == 1);
        this.eQj.getLayoutMode().onModeChanged(this.eQd);
        this.bzH.onChangeSkinType(this.eQj.getPageContext(), i);
    }

    private void initUI() {
        this.eQj.setContentView(e.h.im_add_group_activity);
        this.eQd = this.eQj.findViewById(e.g.addgroup_rootlayout);
        this.bzH = (NavigationBar) this.eQj.findViewById(e.g.addgroup_navigationbar);
        this.eQe = this.bzH.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bzH.setTitleText(this.eQj.getResources().getString(e.j.add_group_title_main));
        this.eQf = (EditText) this.eQj.findViewById(e.g.addgroup_input);
        this.eQf.setInputType(2);
        this.eQg = (ImageButton) this.eQj.findViewById(e.g.addgroup_delbtn);
        this.eQh = this.eQj.findViewById(e.g.addgroup_searchbutton);
        this.eQi = this.eQj.findViewById(e.g.addgroup_vcode);
        this.eQf.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.im.searchGroup.a.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.eQf.length() > 0) {
                    a.this.eQg.setVisibility(0);
                } else {
                    a.this.eQg.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                a.this.eQh.setTag(editable.toString().trim());
            }
        });
        this.eQh = this.eQj.findViewById(e.g.addgroup_searchbutton);
        this.progressBar = (ProgressBar) this.eQj.findViewById(e.g.addgroup_progress);
        this.eQe.setOnClickListener(this.eQj);
        this.eQg.setOnClickListener(this.eQj);
        this.eQh.setOnClickListener(this.eQj);
        this.eQi.setOnClickListener(this.eQj);
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2902030)) {
            this.eQi.setVisibility(8);
        }
    }
}

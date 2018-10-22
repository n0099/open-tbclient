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
    private View eQe;
    private View eQf;
    private EditText eQg;
    private ImageButton eQh;
    private View eQi;
    private View eQj;
    private AddGroupActivity eQk;
    private ProgressBar progressBar;

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.eQe = null;
        this.bzH = null;
        this.eQf = null;
        this.eQg = null;
        this.eQh = null;
        this.progressBar = null;
        this.eQi = null;
        this.eQk = null;
        this.eQk = addGroupActivity;
        initUI();
    }

    public View aOl() {
        return this.eQh;
    }

    public View aSM() {
        return this.eQi;
    }

    public View aSN() {
        return this.eQf;
    }

    public View aSO() {
        return this.eQj;
    }

    public void aSP() {
        if (this.eQg != null) {
            this.eQg.setText("");
        }
    }

    public void iq(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.eQk.getLayoutMode().setNightMode(i == 1);
        this.eQk.getLayoutMode().onModeChanged(this.eQe);
        this.bzH.onChangeSkinType(this.eQk.getPageContext(), i);
    }

    private void initUI() {
        this.eQk.setContentView(e.h.im_add_group_activity);
        this.eQe = this.eQk.findViewById(e.g.addgroup_rootlayout);
        this.bzH = (NavigationBar) this.eQk.findViewById(e.g.addgroup_navigationbar);
        this.eQf = this.bzH.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bzH.setTitleText(this.eQk.getResources().getString(e.j.add_group_title_main));
        this.eQg = (EditText) this.eQk.findViewById(e.g.addgroup_input);
        this.eQg.setInputType(2);
        this.eQh = (ImageButton) this.eQk.findViewById(e.g.addgroup_delbtn);
        this.eQi = this.eQk.findViewById(e.g.addgroup_searchbutton);
        this.eQj = this.eQk.findViewById(e.g.addgroup_vcode);
        this.eQg.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.im.searchGroup.a.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.eQg.length() > 0) {
                    a.this.eQh.setVisibility(0);
                } else {
                    a.this.eQh.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                a.this.eQi.setTag(editable.toString().trim());
            }
        });
        this.eQi = this.eQk.findViewById(e.g.addgroup_searchbutton);
        this.progressBar = (ProgressBar) this.eQk.findViewById(e.g.addgroup_progress);
        this.eQf.setOnClickListener(this.eQk);
        this.eQh.setOnClickListener(this.eQk);
        this.eQi.setOnClickListener(this.eQk);
        this.eQj.setOnClickListener(this.eQk);
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2902030)) {
            this.eQj.setVisibility(8);
        }
    }
}

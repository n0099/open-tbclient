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
    private NavigationBar bDS;
    private View fbc;
    private View fbd;
    private EditText fbe;
    private ImageButton fbf;
    private View fbg;
    private View fbh;
    private AddGroupActivity fbi;
    private ProgressBar progressBar;

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.fbc = null;
        this.bDS = null;
        this.fbd = null;
        this.fbe = null;
        this.fbf = null;
        this.progressBar = null;
        this.fbg = null;
        this.fbi = null;
        this.fbi = addGroupActivity;
        initUI();
    }

    public View aQn() {
        return this.fbf;
    }

    public View aUO() {
        return this.fbg;
    }

    public View aUP() {
        return this.fbd;
    }

    public View aUQ() {
        return this.fbh;
    }

    public void aUR() {
        if (this.fbe != null) {
            this.fbe.setText("");
        }
    }

    public void iF(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.fbi.getLayoutMode().setNightMode(i == 1);
        this.fbi.getLayoutMode().onModeChanged(this.fbc);
        this.bDS.onChangeSkinType(this.fbi.getPageContext(), i);
    }

    private void initUI() {
        this.fbi.setContentView(e.h.im_add_group_activity);
        this.fbc = this.fbi.findViewById(e.g.addgroup_rootlayout);
        this.bDS = (NavigationBar) this.fbi.findViewById(e.g.addgroup_navigationbar);
        this.fbd = this.bDS.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bDS.setTitleText(this.fbi.getResources().getString(e.j.add_group_title_main));
        this.fbe = (EditText) this.fbi.findViewById(e.g.addgroup_input);
        this.fbe.setInputType(2);
        this.fbf = (ImageButton) this.fbi.findViewById(e.g.addgroup_delbtn);
        this.fbg = this.fbi.findViewById(e.g.addgroup_searchbutton);
        this.fbh = this.fbi.findViewById(e.g.addgroup_vcode);
        this.fbe.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.im.searchGroup.a.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.fbe.length() > 0) {
                    a.this.fbf.setVisibility(0);
                } else {
                    a.this.fbf.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                a.this.fbg.setTag(editable.toString().trim());
            }
        });
        this.fbg = this.fbi.findViewById(e.g.addgroup_searchbutton);
        this.progressBar = (ProgressBar) this.fbi.findViewById(e.g.addgroup_progress);
        this.fbd.setOnClickListener(this.fbi);
        this.fbf.setOnClickListener(this.fbi);
        this.fbg.setOnClickListener(this.fbi);
        this.fbh.setOnClickListener(this.fbi);
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2902030)) {
            this.fbh.setVisibility(8);
        }
    }
}

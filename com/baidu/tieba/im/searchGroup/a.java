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
    private NavigationBar bDP;
    private View eYl;
    private View eYm;
    private EditText eYn;
    private ImageButton eYo;
    private View eYp;
    private View eYq;
    private AddGroupActivity eYr;
    private ProgressBar progressBar;

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.eYl = null;
        this.bDP = null;
        this.eYm = null;
        this.eYn = null;
        this.eYo = null;
        this.progressBar = null;
        this.eYp = null;
        this.eYr = null;
        this.eYr = addGroupActivity;
        initUI();
    }

    public View aPA() {
        return this.eYo;
    }

    public View aUb() {
        return this.eYp;
    }

    public View aUc() {
        return this.eYm;
    }

    public View aUd() {
        return this.eYq;
    }

    public void aUe() {
        if (this.eYn != null) {
            this.eYn.setText("");
        }
    }

    public void iC(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.eYr.getLayoutMode().setNightMode(i == 1);
        this.eYr.getLayoutMode().onModeChanged(this.eYl);
        this.bDP.onChangeSkinType(this.eYr.getPageContext(), i);
    }

    private void initUI() {
        this.eYr.setContentView(e.h.im_add_group_activity);
        this.eYl = this.eYr.findViewById(e.g.addgroup_rootlayout);
        this.bDP = (NavigationBar) this.eYr.findViewById(e.g.addgroup_navigationbar);
        this.eYm = this.bDP.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bDP.setTitleText(this.eYr.getResources().getString(e.j.add_group_title_main));
        this.eYn = (EditText) this.eYr.findViewById(e.g.addgroup_input);
        this.eYn.setInputType(2);
        this.eYo = (ImageButton) this.eYr.findViewById(e.g.addgroup_delbtn);
        this.eYp = this.eYr.findViewById(e.g.addgroup_searchbutton);
        this.eYq = this.eYr.findViewById(e.g.addgroup_vcode);
        this.eYn.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.im.searchGroup.a.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.eYn.length() > 0) {
                    a.this.eYo.setVisibility(0);
                } else {
                    a.this.eYo.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                a.this.eYp.setTag(editable.toString().trim());
            }
        });
        this.eYp = this.eYr.findViewById(e.g.addgroup_searchbutton);
        this.progressBar = (ProgressBar) this.eYr.findViewById(e.g.addgroup_progress);
        this.eYm.setOnClickListener(this.eYr);
        this.eYo.setOnClickListener(this.eYr);
        this.eYp.setOnClickListener(this.eYr);
        this.eYq.setOnClickListener(this.eYr);
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2902030)) {
            this.eYq.setVisibility(8);
        }
    }
}

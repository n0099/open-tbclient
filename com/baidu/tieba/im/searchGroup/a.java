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
    private NavigationBar bfz;
    private View eii;
    private View eij;
    private EditText eik;
    private ImageButton eil;
    private View eim;
    private View ein;
    private AddGroupActivity eio;
    private ProgressBar progressBar;

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.eii = null;
        this.bfz = null;
        this.eij = null;
        this.eik = null;
        this.eil = null;
        this.progressBar = null;
        this.eim = null;
        this.eio = null;
        this.eio = addGroupActivity;
        initUI();
    }

    public View aCi() {
        return this.eil;
    }

    public View aGL() {
        return this.eim;
    }

    public View aGM() {
        return this.eij;
    }

    public View aGN() {
        return this.ein;
    }

    public void aGO() {
        if (this.eik != null) {
            this.eik.setText("");
        }
    }

    public void hh(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.eio.getLayoutMode().setNightMode(i == 1);
        this.eio.getLayoutMode().u(this.eii);
        this.bfz.onChangeSkinType(this.eio.getPageContext(), i);
    }

    private void initUI() {
        this.eio.setContentView(d.i.im_add_group_activity);
        this.eii = this.eio.findViewById(d.g.addgroup_rootlayout);
        this.bfz = (NavigationBar) this.eio.findViewById(d.g.addgroup_navigationbar);
        this.eij = this.bfz.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bfz.setTitleText(this.eio.getResources().getString(d.k.add_group_title_main));
        this.eik = (EditText) this.eio.findViewById(d.g.addgroup_input);
        this.eik.setInputType(2);
        this.eil = (ImageButton) this.eio.findViewById(d.g.addgroup_delbtn);
        this.eim = this.eio.findViewById(d.g.addgroup_searchbutton);
        this.ein = this.eio.findViewById(d.g.addgroup_vcode);
        this.eik.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.im.searchGroup.a.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.eik.length() > 0) {
                    a.this.eil.setVisibility(0);
                } else {
                    a.this.eil.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                a.this.eim.setTag(editable.toString().trim());
            }
        });
        this.eim = this.eio.findViewById(d.g.addgroup_searchbutton);
        this.progressBar = (ProgressBar) this.eio.findViewById(d.g.addgroup_progress);
        this.eij.setOnClickListener(this.eio);
        this.eil.setOnClickListener(this.eio);
        this.eim.setOnClickListener(this.eio);
        this.ein.setOnClickListener(this.eio);
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2902030)) {
            this.ein.setVisibility(8);
        }
    }
}

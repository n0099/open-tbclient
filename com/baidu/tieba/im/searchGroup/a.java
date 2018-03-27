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
    private NavigationBar bVs;
    private EditText eMA;
    private ImageButton eMB;
    private View eMC;
    private View eMD;
    private AddGroupActivity eME;
    private View eMy;
    private View eMz;
    private ProgressBar progressBar;

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.eMy = null;
        this.bVs = null;
        this.eMz = null;
        this.eMA = null;
        this.eMB = null;
        this.progressBar = null;
        this.eMC = null;
        this.eME = null;
        this.eME = addGroupActivity;
        initUI();
    }

    public View aHk() {
        return this.eMB;
    }

    public View aLN() {
        return this.eMC;
    }

    public View aLO() {
        return this.eMz;
    }

    public View aLP() {
        return this.eMD;
    }

    public void aLQ() {
        if (this.eMA != null) {
            this.eMA.setText("");
        }
    }

    public void hG(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.eME.getLayoutMode().aQ(i == 1);
        this.eME.getLayoutMode().aM(this.eMy);
        this.bVs.onChangeSkinType(this.eME.getPageContext(), i);
    }

    private void initUI() {
        this.eME.setContentView(d.h.im_add_group_activity);
        this.eMy = this.eME.findViewById(d.g.addgroup_rootlayout);
        this.bVs = (NavigationBar) this.eME.findViewById(d.g.addgroup_navigationbar);
        this.eMz = this.bVs.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bVs.setTitleText(this.eME.getResources().getString(d.j.add_group_title_main));
        this.eMA = (EditText) this.eME.findViewById(d.g.addgroup_input);
        this.eMA.setInputType(2);
        this.eMB = (ImageButton) this.eME.findViewById(d.g.addgroup_delbtn);
        this.eMC = this.eME.findViewById(d.g.addgroup_searchbutton);
        this.eMD = this.eME.findViewById(d.g.addgroup_vcode);
        this.eMA.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.im.searchGroup.a.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.eMA.length() > 0) {
                    a.this.eMB.setVisibility(0);
                } else {
                    a.this.eMB.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                a.this.eMC.setTag(editable.toString().trim());
            }
        });
        this.eMC = this.eME.findViewById(d.g.addgroup_searchbutton);
        this.progressBar = (ProgressBar) this.eME.findViewById(d.g.addgroup_progress);
        this.eMz.setOnClickListener(this.eME);
        this.eMB.setOnClickListener(this.eME);
        this.eMC.setOnClickListener(this.eME);
        this.eMD.setOnClickListener(this.eME);
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2902030)) {
            this.eMD.setVisibility(8);
        }
    }
}

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
    private NavigationBar bVB;
    private AddGroupActivity eMA;
    private View eMu;
    private View eMv;
    private EditText eMw;
    private ImageButton eMx;
    private View eMy;
    private View eMz;
    private ProgressBar progressBar;

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.eMu = null;
        this.bVB = null;
        this.eMv = null;
        this.eMw = null;
        this.eMx = null;
        this.progressBar = null;
        this.eMy = null;
        this.eMA = null;
        this.eMA = addGroupActivity;
        initUI();
    }

    public View aHk() {
        return this.eMx;
    }

    public View aLN() {
        return this.eMy;
    }

    public View aLO() {
        return this.eMv;
    }

    public View aLP() {
        return this.eMz;
    }

    public void aLQ() {
        if (this.eMw != null) {
            this.eMw.setText("");
        }
    }

    public void hB(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.eMA.getLayoutMode().aQ(i == 1);
        this.eMA.getLayoutMode().aM(this.eMu);
        this.bVB.onChangeSkinType(this.eMA.getPageContext(), i);
    }

    private void initUI() {
        this.eMA.setContentView(d.h.im_add_group_activity);
        this.eMu = this.eMA.findViewById(d.g.addgroup_rootlayout);
        this.bVB = (NavigationBar) this.eMA.findViewById(d.g.addgroup_navigationbar);
        this.eMv = this.bVB.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bVB.setTitleText(this.eMA.getResources().getString(d.j.add_group_title_main));
        this.eMw = (EditText) this.eMA.findViewById(d.g.addgroup_input);
        this.eMw.setInputType(2);
        this.eMx = (ImageButton) this.eMA.findViewById(d.g.addgroup_delbtn);
        this.eMy = this.eMA.findViewById(d.g.addgroup_searchbutton);
        this.eMz = this.eMA.findViewById(d.g.addgroup_vcode);
        this.eMw.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.im.searchGroup.a.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.eMw.length() > 0) {
                    a.this.eMx.setVisibility(0);
                } else {
                    a.this.eMx.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                a.this.eMy.setTag(editable.toString().trim());
            }
        });
        this.eMy = this.eMA.findViewById(d.g.addgroup_searchbutton);
        this.progressBar = (ProgressBar) this.eMA.findViewById(d.g.addgroup_progress);
        this.eMv.setOnClickListener(this.eMA);
        this.eMx.setOnClickListener(this.eMA);
        this.eMy.setOnClickListener(this.eMA);
        this.eMz.setOnClickListener(this.eMA);
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2902030)) {
            this.eMz.setVisibility(8);
        }
    }
}

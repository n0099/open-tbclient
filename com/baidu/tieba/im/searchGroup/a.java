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
    private NavigationBar bEG;
    private View fbQ;
    private View fbR;
    private EditText fbS;
    private ImageButton fbT;
    private View fbU;
    private View fbV;
    private AddGroupActivity fbW;
    private ProgressBar progressBar;

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.fbQ = null;
        this.bEG = null;
        this.fbR = null;
        this.fbS = null;
        this.fbT = null;
        this.progressBar = null;
        this.fbU = null;
        this.fbW = null;
        this.fbW = addGroupActivity;
        initUI();
    }

    public View aQN() {
        return this.fbT;
    }

    public View aVo() {
        return this.fbU;
    }

    public View aVp() {
        return this.fbR;
    }

    public View aVq() {
        return this.fbV;
    }

    public void aVr() {
        if (this.fbS != null) {
            this.fbS.setText("");
        }
    }

    public void iF(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.fbW.getLayoutMode().setNightMode(i == 1);
        this.fbW.getLayoutMode().onModeChanged(this.fbQ);
        this.bEG.onChangeSkinType(this.fbW.getPageContext(), i);
    }

    private void initUI() {
        this.fbW.setContentView(e.h.im_add_group_activity);
        this.fbQ = this.fbW.findViewById(e.g.addgroup_rootlayout);
        this.bEG = (NavigationBar) this.fbW.findViewById(e.g.addgroup_navigationbar);
        this.fbR = this.bEG.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bEG.setTitleText(this.fbW.getResources().getString(e.j.add_group_title_main));
        this.fbS = (EditText) this.fbW.findViewById(e.g.addgroup_input);
        this.fbS.setInputType(2);
        this.fbT = (ImageButton) this.fbW.findViewById(e.g.addgroup_delbtn);
        this.fbU = this.fbW.findViewById(e.g.addgroup_searchbutton);
        this.fbV = this.fbW.findViewById(e.g.addgroup_vcode);
        this.fbS.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.im.searchGroup.a.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.fbS.length() > 0) {
                    a.this.fbT.setVisibility(0);
                } else {
                    a.this.fbT.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                a.this.fbU.setTag(editable.toString().trim());
            }
        });
        this.fbU = this.fbW.findViewById(e.g.addgroup_searchbutton);
        this.progressBar = (ProgressBar) this.fbW.findViewById(e.g.addgroup_progress);
        this.fbR.setOnClickListener(this.fbW);
        this.fbT.setOnClickListener(this.fbW);
        this.fbU.setOnClickListener(this.fbW);
        this.fbV.setOnClickListener(this.fbW);
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2902030)) {
            this.fbV.setVisibility(8);
        }
    }
}

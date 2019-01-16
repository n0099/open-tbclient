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
    private NavigationBar bEF;
    private View fbP;
    private View fbQ;
    private EditText fbR;
    private ImageButton fbS;
    private View fbT;
    private View fbU;
    private AddGroupActivity fbV;
    private ProgressBar progressBar;

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.fbP = null;
        this.bEF = null;
        this.fbQ = null;
        this.fbR = null;
        this.fbS = null;
        this.progressBar = null;
        this.fbT = null;
        this.fbV = null;
        this.fbV = addGroupActivity;
        initUI();
    }

    public View aQN() {
        return this.fbS;
    }

    public View aVo() {
        return this.fbT;
    }

    public View aVp() {
        return this.fbQ;
    }

    public View aVq() {
        return this.fbU;
    }

    public void aVr() {
        if (this.fbR != null) {
            this.fbR.setText("");
        }
    }

    public void iF(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.fbV.getLayoutMode().setNightMode(i == 1);
        this.fbV.getLayoutMode().onModeChanged(this.fbP);
        this.bEF.onChangeSkinType(this.fbV.getPageContext(), i);
    }

    private void initUI() {
        this.fbV.setContentView(e.h.im_add_group_activity);
        this.fbP = this.fbV.findViewById(e.g.addgroup_rootlayout);
        this.bEF = (NavigationBar) this.fbV.findViewById(e.g.addgroup_navigationbar);
        this.fbQ = this.bEF.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bEF.setTitleText(this.fbV.getResources().getString(e.j.add_group_title_main));
        this.fbR = (EditText) this.fbV.findViewById(e.g.addgroup_input);
        this.fbR.setInputType(2);
        this.fbS = (ImageButton) this.fbV.findViewById(e.g.addgroup_delbtn);
        this.fbT = this.fbV.findViewById(e.g.addgroup_searchbutton);
        this.fbU = this.fbV.findViewById(e.g.addgroup_vcode);
        this.fbR.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.im.searchGroup.a.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.fbR.length() > 0) {
                    a.this.fbS.setVisibility(0);
                } else {
                    a.this.fbS.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                a.this.fbT.setTag(editable.toString().trim());
            }
        });
        this.fbT = this.fbV.findViewById(e.g.addgroup_searchbutton);
        this.progressBar = (ProgressBar) this.fbV.findViewById(e.g.addgroup_progress);
        this.fbQ.setOnClickListener(this.fbV);
        this.fbS.setOnClickListener(this.fbV);
        this.fbT.setOnClickListener(this.fbV);
        this.fbU.setOnClickListener(this.fbV);
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2902030)) {
            this.fbU.setVisibility(8);
        }
    }
}

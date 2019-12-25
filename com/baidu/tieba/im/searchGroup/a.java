package com.baidu.tieba.im.searchGroup;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import com.baidu.adp.base.c;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class a extends c<AddGroupActivity> {
    private NavigationBar dXE;
    private View hDk;
    private View hDl;
    private EditText hDm;
    private ImageButton hDn;
    private View hDo;
    private View hDp;
    private AddGroupActivity hDq;
    private ProgressBar progressBar;

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.hDk = null;
        this.dXE = null;
        this.hDl = null;
        this.hDm = null;
        this.hDn = null;
        this.progressBar = null;
        this.hDo = null;
        this.hDq = null;
        this.hDq = addGroupActivity;
        initUI();
    }

    public View bQL() {
        return this.hDn;
    }

    public View bVg() {
        return this.hDo;
    }

    public View bVh() {
        return this.hDl;
    }

    public View bVi() {
        return this.hDp;
    }

    public void bVj() {
        if (this.hDm != null) {
            this.hDm.setText("");
        }
    }

    public void showProgressBar(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.hDq.getLayoutMode().setNightMode(i == 1);
        this.hDq.getLayoutMode().onModeChanged(this.hDk);
        this.dXE.onChangeSkinType(this.hDq.getPageContext(), i);
    }

    private void initUI() {
        this.hDq.setContentView(R.layout.im_add_group_activity);
        this.hDk = this.hDq.findViewById(R.id.addgroup_rootlayout);
        this.dXE = (NavigationBar) this.hDq.findViewById(R.id.addgroup_navigationbar);
        this.hDl = this.dXE.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dXE.setTitleText(this.hDq.getResources().getString(R.string.add_group_title_main));
        this.hDm = (EditText) this.hDq.findViewById(R.id.addgroup_input);
        this.hDm.setInputType(2);
        this.hDn = (ImageButton) this.hDq.findViewById(R.id.addgroup_delbtn);
        this.hDo = this.hDq.findViewById(R.id.addgroup_searchbutton);
        this.hDp = this.hDq.findViewById(R.id.addgroup_vcode);
        this.hDm.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.im.searchGroup.a.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.hDm.length() > 0) {
                    a.this.hDn.setVisibility(0);
                } else {
                    a.this.hDn.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                a.this.hDo.setTag(editable.toString().trim());
            }
        });
        this.hDo = this.hDq.findViewById(R.id.addgroup_searchbutton);
        this.progressBar = (ProgressBar) this.hDq.findViewById(R.id.addgroup_progress);
        this.hDl.setOnClickListener(this.hDq);
        this.hDn.setOnClickListener(this.hDq);
        this.hDo.setOnClickListener(this.hDq);
        this.hDp.setOnClickListener(this.hDq);
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_ZXING_CAPTURE)) {
            this.hDp.setVisibility(8);
        }
    }
}

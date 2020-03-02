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
/* loaded from: classes13.dex */
public class a extends c<AddGroupActivity> {
    private NavigationBar ebS;
    private View hIO;
    private View hIP;
    private EditText hIQ;
    private ImageButton hIR;
    private View hIS;
    private View hIT;
    private AddGroupActivity hIU;
    private ProgressBar progressBar;

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.hIO = null;
        this.ebS = null;
        this.hIP = null;
        this.hIQ = null;
        this.hIR = null;
        this.progressBar = null;
        this.hIS = null;
        this.hIU = null;
        this.hIU = addGroupActivity;
        initUI();
    }

    public View bTx() {
        return this.hIR;
    }

    public View bXS() {
        return this.hIS;
    }

    public View bXT() {
        return this.hIP;
    }

    public View bXU() {
        return this.hIT;
    }

    public void bXV() {
        if (this.hIQ != null) {
            this.hIQ.setText("");
        }
    }

    public void showProgressBar(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.hIU.getLayoutMode().setNightMode(i == 1);
        this.hIU.getLayoutMode().onModeChanged(this.hIO);
        this.ebS.onChangeSkinType(this.hIU.getPageContext(), i);
    }

    private void initUI() {
        this.hIU.setContentView(R.layout.im_add_group_activity);
        this.hIO = this.hIU.findViewById(R.id.addgroup_rootlayout);
        this.ebS = (NavigationBar) this.hIU.findViewById(R.id.addgroup_navigationbar);
        this.hIP = this.ebS.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ebS.setTitleText(this.hIU.getResources().getString(R.string.add_group_title_main));
        this.hIQ = (EditText) this.hIU.findViewById(R.id.addgroup_input);
        this.hIQ.setInputType(2);
        this.hIR = (ImageButton) this.hIU.findViewById(R.id.addgroup_delbtn);
        this.hIS = this.hIU.findViewById(R.id.addgroup_searchbutton);
        this.hIT = this.hIU.findViewById(R.id.addgroup_vcode);
        this.hIQ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.im.searchGroup.a.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.hIQ.length() > 0) {
                    a.this.hIR.setVisibility(0);
                } else {
                    a.this.hIR.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                a.this.hIS.setTag(editable.toString().trim());
            }
        });
        this.hIS = this.hIU.findViewById(R.id.addgroup_searchbutton);
        this.progressBar = (ProgressBar) this.hIU.findViewById(R.id.addgroup_progress);
        this.hIP.setOnClickListener(this.hIU);
        this.hIR.setOnClickListener(this.hIU);
        this.hIS.setOnClickListener(this.hIU);
        this.hIT.setOnClickListener(this.hIU);
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_ZXING_CAPTURE)) {
            this.hIT.setVisibility(8);
        }
    }
}

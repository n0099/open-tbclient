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
    private NavigationBar ebR;
    private View hIM;
    private View hIN;
    private EditText hIO;
    private ImageButton hIP;
    private View hIQ;
    private View hIR;
    private AddGroupActivity hIS;
    private ProgressBar progressBar;

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.hIM = null;
        this.ebR = null;
        this.hIN = null;
        this.hIO = null;
        this.hIP = null;
        this.progressBar = null;
        this.hIQ = null;
        this.hIS = null;
        this.hIS = addGroupActivity;
        initUI();
    }

    public View bTv() {
        return this.hIP;
    }

    public View bXQ() {
        return this.hIQ;
    }

    public View bXR() {
        return this.hIN;
    }

    public View bXS() {
        return this.hIR;
    }

    public void bXT() {
        if (this.hIO != null) {
            this.hIO.setText("");
        }
    }

    public void showProgressBar(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.hIS.getLayoutMode().setNightMode(i == 1);
        this.hIS.getLayoutMode().onModeChanged(this.hIM);
        this.ebR.onChangeSkinType(this.hIS.getPageContext(), i);
    }

    private void initUI() {
        this.hIS.setContentView(R.layout.im_add_group_activity);
        this.hIM = this.hIS.findViewById(R.id.addgroup_rootlayout);
        this.ebR = (NavigationBar) this.hIS.findViewById(R.id.addgroup_navigationbar);
        this.hIN = this.ebR.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ebR.setTitleText(this.hIS.getResources().getString(R.string.add_group_title_main));
        this.hIO = (EditText) this.hIS.findViewById(R.id.addgroup_input);
        this.hIO.setInputType(2);
        this.hIP = (ImageButton) this.hIS.findViewById(R.id.addgroup_delbtn);
        this.hIQ = this.hIS.findViewById(R.id.addgroup_searchbutton);
        this.hIR = this.hIS.findViewById(R.id.addgroup_vcode);
        this.hIO.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.im.searchGroup.a.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.hIO.length() > 0) {
                    a.this.hIP.setVisibility(0);
                } else {
                    a.this.hIP.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                a.this.hIQ.setTag(editable.toString().trim());
            }
        });
        this.hIQ = this.hIS.findViewById(R.id.addgroup_searchbutton);
        this.progressBar = (ProgressBar) this.hIS.findViewById(R.id.addgroup_progress);
        this.hIN.setOnClickListener(this.hIS);
        this.hIP.setOnClickListener(this.hIS);
        this.hIQ.setOnClickListener(this.hIS);
        this.hIR.setOnClickListener(this.hIS);
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_ZXING_CAPTURE)) {
            this.hIR.setVisibility(8);
        }
    }
}

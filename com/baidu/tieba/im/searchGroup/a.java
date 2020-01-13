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
/* loaded from: classes11.dex */
public class a extends c<AddGroupActivity> {
    private NavigationBar dXN;
    private View hGN;
    private View hGO;
    private EditText hGP;
    private ImageButton hGQ;
    private View hGR;
    private View hGS;
    private AddGroupActivity hGT;
    private ProgressBar progressBar;

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.hGN = null;
        this.dXN = null;
        this.hGO = null;
        this.hGP = null;
        this.hGQ = null;
        this.progressBar = null;
        this.hGR = null;
        this.hGT = null;
        this.hGT = addGroupActivity;
        initUI();
    }

    public View bRU() {
        return this.hGQ;
    }

    public View bWp() {
        return this.hGR;
    }

    public View bWq() {
        return this.hGO;
    }

    public View bWr() {
        return this.hGS;
    }

    public void bWs() {
        if (this.hGP != null) {
            this.hGP.setText("");
        }
    }

    public void showProgressBar(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.hGT.getLayoutMode().setNightMode(i == 1);
        this.hGT.getLayoutMode().onModeChanged(this.hGN);
        this.dXN.onChangeSkinType(this.hGT.getPageContext(), i);
    }

    private void initUI() {
        this.hGT.setContentView(R.layout.im_add_group_activity);
        this.hGN = this.hGT.findViewById(R.id.addgroup_rootlayout);
        this.dXN = (NavigationBar) this.hGT.findViewById(R.id.addgroup_navigationbar);
        this.hGO = this.dXN.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dXN.setTitleText(this.hGT.getResources().getString(R.string.add_group_title_main));
        this.hGP = (EditText) this.hGT.findViewById(R.id.addgroup_input);
        this.hGP.setInputType(2);
        this.hGQ = (ImageButton) this.hGT.findViewById(R.id.addgroup_delbtn);
        this.hGR = this.hGT.findViewById(R.id.addgroup_searchbutton);
        this.hGS = this.hGT.findViewById(R.id.addgroup_vcode);
        this.hGP.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.im.searchGroup.a.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.hGP.length() > 0) {
                    a.this.hGQ.setVisibility(0);
                } else {
                    a.this.hGQ.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                a.this.hGR.setTag(editable.toString().trim());
            }
        });
        this.hGR = this.hGT.findViewById(R.id.addgroup_searchbutton);
        this.progressBar = (ProgressBar) this.hGT.findViewById(R.id.addgroup_progress);
        this.hGO.setOnClickListener(this.hGT);
        this.hGQ.setOnClickListener(this.hGT);
        this.hGR.setOnClickListener(this.hGT);
        this.hGS.setOnClickListener(this.hGT);
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_ZXING_CAPTURE)) {
            this.hGS.setVisibility(8);
        }
    }
}

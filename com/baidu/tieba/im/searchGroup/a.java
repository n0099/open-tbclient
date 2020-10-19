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
/* loaded from: classes26.dex */
public class a extends c<AddGroupActivity> {
    private NavigationBar fGE;
    private View jVS;
    private EditText jVT;
    private ImageButton jVU;
    private View jVV;
    private View jVW;
    private AddGroupActivity jVX;
    private View jjO;
    private ProgressBar progressBar;

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.jjO = null;
        this.fGE = null;
        this.jVS = null;
        this.jVT = null;
        this.jVU = null;
        this.progressBar = null;
        this.jVV = null;
        this.jVX = null;
        this.jVX = addGroupActivity;
        initUI();
    }

    public View cKy() {
        return this.jVU;
    }

    public View cPp() {
        return this.jVV;
    }

    public View cPq() {
        return this.jVS;
    }

    public View cPr() {
        return this.jVW;
    }

    public void cPs() {
        if (this.jVT != null) {
            this.jVT.setText("");
        }
    }

    public void showProgressBar(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.jVX.getLayoutMode().setNightMode(i == 1);
        this.jVX.getLayoutMode().onModeChanged(this.jjO);
        this.fGE.onChangeSkinType(this.jVX.getPageContext(), i);
    }

    private void initUI() {
        this.jVX.setContentView(R.layout.im_add_group_activity);
        this.jjO = this.jVX.findViewById(R.id.addgroup_rootlayout);
        this.fGE = (NavigationBar) this.jVX.findViewById(R.id.addgroup_navigationbar);
        this.jVS = this.fGE.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fGE.setTitleText(this.jVX.getResources().getString(R.string.add_group_title_main));
        this.jVT = (EditText) this.jVX.findViewById(R.id.addgroup_input);
        this.jVT.setInputType(2);
        this.jVU = (ImageButton) this.jVX.findViewById(R.id.addgroup_delbtn);
        this.jVV = this.jVX.findViewById(R.id.addgroup_searchbutton);
        this.jVW = this.jVX.findViewById(R.id.addgroup_vcode);
        this.jVT.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.im.searchGroup.a.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.jVT.length() > 0) {
                    a.this.jVU.setVisibility(0);
                } else {
                    a.this.jVU.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                a.this.jVV.setTag(editable.toString().trim());
            }
        });
        this.jVV = this.jVX.findViewById(R.id.addgroup_searchbutton);
        this.progressBar = (ProgressBar) this.jVX.findViewById(R.id.addgroup_progress);
        this.jVS.setOnClickListener(this.jVX);
        this.jVU.setOnClickListener(this.jVX);
        this.jVV.setOnClickListener(this.jVX);
        this.jVW.setOnClickListener(this.jVX);
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_ZXING_CAPTURE)) {
            this.jVW.setVisibility(8);
        }
    }
}

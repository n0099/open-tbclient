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
    private NavigationBar fOZ;
    private View jwl;
    private View kit;
    private EditText kiu;
    private ImageButton kiv;
    private View kiw;
    private View kix;
    private AddGroupActivity kiy;
    private ProgressBar progressBar;

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.jwl = null;
        this.fOZ = null;
        this.kit = null;
        this.kiu = null;
        this.kiv = null;
        this.progressBar = null;
        this.kiw = null;
        this.kiy = null;
        this.kiy = addGroupActivity;
        initUI();
    }

    public View cNF() {
        return this.kiv;
    }

    public View cSw() {
        return this.kiw;
    }

    public View cSx() {
        return this.kit;
    }

    public View cSy() {
        return this.kix;
    }

    public void cSz() {
        if (this.kiu != null) {
            this.kiu.setText("");
        }
    }

    public void showProgressBar(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.kiy.getLayoutMode().setNightMode(i == 1);
        this.kiy.getLayoutMode().onModeChanged(this.jwl);
        this.fOZ.onChangeSkinType(this.kiy.getPageContext(), i);
    }

    private void initUI() {
        this.kiy.setContentView(R.layout.im_add_group_activity);
        this.jwl = this.kiy.findViewById(R.id.addgroup_rootlayout);
        this.fOZ = (NavigationBar) this.kiy.findViewById(R.id.addgroup_navigationbar);
        this.kit = this.fOZ.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fOZ.setTitleText(this.kiy.getResources().getString(R.string.add_group_title_main));
        this.kiu = (EditText) this.kiy.findViewById(R.id.addgroup_input);
        this.kiu.setInputType(2);
        this.kiv = (ImageButton) this.kiy.findViewById(R.id.addgroup_delbtn);
        this.kiw = this.kiy.findViewById(R.id.addgroup_searchbutton);
        this.kix = this.kiy.findViewById(R.id.addgroup_vcode);
        this.kiu.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.im.searchGroup.a.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.kiu.length() > 0) {
                    a.this.kiv.setVisibility(0);
                } else {
                    a.this.kiv.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                a.this.kiw.setTag(editable.toString().trim());
            }
        });
        this.kiw = this.kiy.findViewById(R.id.addgroup_searchbutton);
        this.progressBar = (ProgressBar) this.kiy.findViewById(R.id.addgroup_progress);
        this.kit.setOnClickListener(this.kiy);
        this.kiv.setOnClickListener(this.kiy);
        this.kiw.setOnClickListener(this.kiy);
        this.kix.setOnClickListener(this.kiy);
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_ZXING_CAPTURE)) {
            this.kix.setVisibility(8);
        }
    }
}

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
    private NavigationBar fbi;
    private View irn;
    private View jaS;
    private EditText jaT;
    private ImageButton jaU;
    private View jaV;
    private View jaW;
    private AddGroupActivity jaX;
    private ProgressBar progressBar;

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.irn = null;
        this.fbi = null;
        this.jaS = null;
        this.jaT = null;
        this.jaU = null;
        this.progressBar = null;
        this.jaV = null;
        this.jaX = null;
        this.jaX = addGroupActivity;
        initUI();
    }

    public View coL() {
        return this.jaU;
    }

    public View ctg() {
        return this.jaV;
    }

    public View cth() {
        return this.jaS;
    }

    public View cti() {
        return this.jaW;
    }

    public void ctj() {
        if (this.jaT != null) {
            this.jaT.setText("");
        }
    }

    public void showProgressBar(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.jaX.getLayoutMode().setNightMode(i == 1);
        this.jaX.getLayoutMode().onModeChanged(this.irn);
        this.fbi.onChangeSkinType(this.jaX.getPageContext(), i);
    }

    private void initUI() {
        this.jaX.setContentView(R.layout.im_add_group_activity);
        this.irn = this.jaX.findViewById(R.id.addgroup_rootlayout);
        this.fbi = (NavigationBar) this.jaX.findViewById(R.id.addgroup_navigationbar);
        this.jaS = this.fbi.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fbi.setTitleText(this.jaX.getResources().getString(R.string.add_group_title_main));
        this.jaT = (EditText) this.jaX.findViewById(R.id.addgroup_input);
        this.jaT.setInputType(2);
        this.jaU = (ImageButton) this.jaX.findViewById(R.id.addgroup_delbtn);
        this.jaV = this.jaX.findViewById(R.id.addgroup_searchbutton);
        this.jaW = this.jaX.findViewById(R.id.addgroup_vcode);
        this.jaT.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.im.searchGroup.a.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.jaT.length() > 0) {
                    a.this.jaU.setVisibility(0);
                } else {
                    a.this.jaU.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                a.this.jaV.setTag(editable.toString().trim());
            }
        });
        this.jaV = this.jaX.findViewById(R.id.addgroup_searchbutton);
        this.progressBar = (ProgressBar) this.jaX.findViewById(R.id.addgroup_progress);
        this.jaS.setOnClickListener(this.jaX);
        this.jaU.setOnClickListener(this.jaX);
        this.jaV.setOnClickListener(this.jaX);
        this.jaW.setOnClickListener(this.jaX);
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_ZXING_CAPTURE)) {
            this.jaW.setVisibility(8);
        }
    }
}

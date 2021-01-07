package com.baidu.tieba.im.searchGroup;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import com.baidu.adp.base.d;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class a extends d<AddGroupActivity> {
    private EditText editText;
    private NavigationBar glZ;
    private View kHT;
    private ImageButton kHU;
    private View kHV;
    private View kHW;
    private AddGroupActivity kHX;
    private View kdX;
    private ProgressBar progressBar;

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.kdX = null;
        this.glZ = null;
        this.kHT = null;
        this.editText = null;
        this.kHU = null;
        this.progressBar = null;
        this.kHV = null;
        this.kHX = null;
        this.kHX = addGroupActivity;
        initUI();
    }

    public View cZD() {
        return this.kHU;
    }

    public View cZE() {
        return this.kHV;
    }

    public View cZF() {
        return this.kHT;
    }

    public View cZG() {
        return this.kHW;
    }

    public void cZH() {
        if (this.editText != null) {
            this.editText.setText("");
        }
    }

    public void sU(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.kHX.getLayoutMode().setNightMode(i == 1);
        this.kHX.getLayoutMode().onModeChanged(this.kdX);
        this.glZ.onChangeSkinType(this.kHX.getPageContext(), i);
    }

    private void initUI() {
        this.kHX.setContentView(R.layout.im_add_group_activity);
        this.kdX = this.kHX.findViewById(R.id.addgroup_rootlayout);
        this.glZ = (NavigationBar) this.kHX.findViewById(R.id.addgroup_navigationbar);
        this.kHT = this.glZ.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.glZ.setTitleText(this.kHX.getResources().getString(R.string.add_group_title_main));
        this.editText = (EditText) this.kHX.findViewById(R.id.addgroup_input);
        this.editText.setInputType(2);
        this.kHU = (ImageButton) this.kHX.findViewById(R.id.addgroup_delbtn);
        this.kHV = this.kHX.findViewById(R.id.addgroup_searchbutton);
        this.kHW = this.kHX.findViewById(R.id.addgroup_vcode);
        this.editText.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.im.searchGroup.a.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.editText.length() > 0) {
                    a.this.kHU.setVisibility(0);
                } else {
                    a.this.kHU.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                a.this.kHV.setTag(editable.toString().trim());
            }
        });
        this.kHV = this.kHX.findViewById(R.id.addgroup_searchbutton);
        this.progressBar = (ProgressBar) this.kHX.findViewById(R.id.addgroup_progress);
        this.kHT.setOnClickListener(this.kHX);
        this.kHU.setOnClickListener(this.kHX);
        this.kHV.setOnClickListener(this.kHX);
        this.kHW.setOnClickListener(this.kHX);
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_ZXING_CAPTURE)) {
            this.kHW.setVisibility(8);
        }
    }
}

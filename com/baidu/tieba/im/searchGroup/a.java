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
/* loaded from: classes25.dex */
public class a extends c<AddGroupActivity> {
    private NavigationBar fuv;
    private View iUQ;
    private View jGV;
    private EditText jGW;
    private ImageButton jGX;
    private View jGY;
    private View jGZ;
    private AddGroupActivity jHa;
    private ProgressBar progressBar;

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.iUQ = null;
        this.fuv = null;
        this.jGV = null;
        this.jGW = null;
        this.jGX = null;
        this.progressBar = null;
        this.jGY = null;
        this.jHa = null;
        this.jHa = addGroupActivity;
        initUI();
    }

    public View cGP() {
        return this.jGX;
    }

    public View cLH() {
        return this.jGY;
    }

    public View cLI() {
        return this.jGV;
    }

    public View cLJ() {
        return this.jGZ;
    }

    public void cLK() {
        if (this.jGW != null) {
            this.jGW.setText("");
        }
    }

    public void showProgressBar(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.jHa.getLayoutMode().setNightMode(i == 1);
        this.jHa.getLayoutMode().onModeChanged(this.iUQ);
        this.fuv.onChangeSkinType(this.jHa.getPageContext(), i);
    }

    private void initUI() {
        this.jHa.setContentView(R.layout.im_add_group_activity);
        this.iUQ = this.jHa.findViewById(R.id.addgroup_rootlayout);
        this.fuv = (NavigationBar) this.jHa.findViewById(R.id.addgroup_navigationbar);
        this.jGV = this.fuv.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fuv.setTitleText(this.jHa.getResources().getString(R.string.add_group_title_main));
        this.jGW = (EditText) this.jHa.findViewById(R.id.addgroup_input);
        this.jGW.setInputType(2);
        this.jGX = (ImageButton) this.jHa.findViewById(R.id.addgroup_delbtn);
        this.jGY = this.jHa.findViewById(R.id.addgroup_searchbutton);
        this.jGZ = this.jHa.findViewById(R.id.addgroup_vcode);
        this.jGW.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.im.searchGroup.a.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.jGW.length() > 0) {
                    a.this.jGX.setVisibility(0);
                } else {
                    a.this.jGX.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                a.this.jGY.setTag(editable.toString().trim());
            }
        });
        this.jGY = this.jHa.findViewById(R.id.addgroup_searchbutton);
        this.progressBar = (ProgressBar) this.jHa.findViewById(R.id.addgroup_progress);
        this.jGV.setOnClickListener(this.jHa);
        this.jGX.setOnClickListener(this.jHa);
        this.jGY.setOnClickListener(this.jHa);
        this.jGZ.setOnClickListener(this.jHa);
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_ZXING_CAPTURE)) {
            this.jGZ.setVisibility(8);
        }
    }
}

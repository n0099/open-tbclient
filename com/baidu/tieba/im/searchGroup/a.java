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
    private NavigationBar eQX;
    private View iJP;
    private View iJQ;
    private EditText iJR;
    private ImageButton iJS;
    private View iJT;
    private View iJU;
    private AddGroupActivity iJV;
    private ProgressBar progressBar;

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.iJP = null;
        this.eQX = null;
        this.iJQ = null;
        this.iJR = null;
        this.iJS = null;
        this.progressBar = null;
        this.iJT = null;
        this.iJV = null;
        this.iJV = addGroupActivity;
        initUI();
    }

    public View ckW() {
        return this.iJS;
    }

    public View cpr() {
        return this.iJT;
    }

    public View cps() {
        return this.iJQ;
    }

    public View cpt() {
        return this.iJU;
    }

    public void cpu() {
        if (this.iJR != null) {
            this.iJR.setText("");
        }
    }

    public void showProgressBar(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.iJV.getLayoutMode().setNightMode(i == 1);
        this.iJV.getLayoutMode().onModeChanged(this.iJP);
        this.eQX.onChangeSkinType(this.iJV.getPageContext(), i);
    }

    private void initUI() {
        this.iJV.setContentView(R.layout.im_add_group_activity);
        this.iJP = this.iJV.findViewById(R.id.addgroup_rootlayout);
        this.eQX = (NavigationBar) this.iJV.findViewById(R.id.addgroup_navigationbar);
        this.iJQ = this.eQX.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eQX.setTitleText(this.iJV.getResources().getString(R.string.add_group_title_main));
        this.iJR = (EditText) this.iJV.findViewById(R.id.addgroup_input);
        this.iJR.setInputType(2);
        this.iJS = (ImageButton) this.iJV.findViewById(R.id.addgroup_delbtn);
        this.iJT = this.iJV.findViewById(R.id.addgroup_searchbutton);
        this.iJU = this.iJV.findViewById(R.id.addgroup_vcode);
        this.iJR.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.im.searchGroup.a.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.iJR.length() > 0) {
                    a.this.iJS.setVisibility(0);
                } else {
                    a.this.iJS.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                a.this.iJT.setTag(editable.toString().trim());
            }
        });
        this.iJT = this.iJV.findViewById(R.id.addgroup_searchbutton);
        this.progressBar = (ProgressBar) this.iJV.findViewById(R.id.addgroup_progress);
        this.iJQ.setOnClickListener(this.iJV);
        this.iJS.setOnClickListener(this.iJV);
        this.iJT.setOnClickListener(this.iJV);
        this.iJU.setOnClickListener(this.iJV);
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_ZXING_CAPTURE)) {
            this.iJU.setVisibility(8);
        }
    }
}

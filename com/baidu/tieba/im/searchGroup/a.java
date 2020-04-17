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
    private NavigationBar eCi;
    private View iuq;
    private View iur;
    private EditText ius;
    private ImageButton iut;
    private View iuu;
    private View iuv;
    private AddGroupActivity iuw;
    private ProgressBar progressBar;

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.iuq = null;
        this.eCi = null;
        this.iur = null;
        this.ius = null;
        this.iut = null;
        this.progressBar = null;
        this.iuu = null;
        this.iuw = null;
        this.iuw = addGroupActivity;
        initUI();
    }

    public View cer() {
        return this.iut;
    }

    public View ciM() {
        return this.iuu;
    }

    public View ciN() {
        return this.iur;
    }

    public View ciO() {
        return this.iuv;
    }

    public void ciP() {
        if (this.ius != null) {
            this.ius.setText("");
        }
    }

    public void showProgressBar(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.iuw.getLayoutMode().setNightMode(i == 1);
        this.iuw.getLayoutMode().onModeChanged(this.iuq);
        this.eCi.onChangeSkinType(this.iuw.getPageContext(), i);
    }

    private void initUI() {
        this.iuw.setContentView(R.layout.im_add_group_activity);
        this.iuq = this.iuw.findViewById(R.id.addgroup_rootlayout);
        this.eCi = (NavigationBar) this.iuw.findViewById(R.id.addgroup_navigationbar);
        this.iur = this.eCi.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eCi.setTitleText(this.iuw.getResources().getString(R.string.add_group_title_main));
        this.ius = (EditText) this.iuw.findViewById(R.id.addgroup_input);
        this.ius.setInputType(2);
        this.iut = (ImageButton) this.iuw.findViewById(R.id.addgroup_delbtn);
        this.iuu = this.iuw.findViewById(R.id.addgroup_searchbutton);
        this.iuv = this.iuw.findViewById(R.id.addgroup_vcode);
        this.ius.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.im.searchGroup.a.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.ius.length() > 0) {
                    a.this.iut.setVisibility(0);
                } else {
                    a.this.iut.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                a.this.iuu.setTag(editable.toString().trim());
            }
        });
        this.iuu = this.iuw.findViewById(R.id.addgroup_searchbutton);
        this.progressBar = (ProgressBar) this.iuw.findViewById(R.id.addgroup_progress);
        this.iur.setOnClickListener(this.iuw);
        this.iut.setOnClickListener(this.iuw);
        this.iuu.setOnClickListener(this.iuw);
        this.iuv.setOnClickListener(this.iuw);
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_ZXING_CAPTURE)) {
            this.iuv.setVisibility(8);
        }
    }
}

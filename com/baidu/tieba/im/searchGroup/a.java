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
    private NavigationBar eCn;
    private View iuA;
    private View iuB;
    private AddGroupActivity iuC;
    private View iuw;
    private View iux;
    private EditText iuy;
    private ImageButton iuz;
    private ProgressBar progressBar;

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.iuw = null;
        this.eCn = null;
        this.iux = null;
        this.iuy = null;
        this.iuz = null;
        this.progressBar = null;
        this.iuA = null;
        this.iuC = null;
        this.iuC = addGroupActivity;
        initUI();
    }

    public View ceq() {
        return this.iuz;
    }

    public View ciL() {
        return this.iuA;
    }

    public View ciM() {
        return this.iux;
    }

    public View ciN() {
        return this.iuB;
    }

    public void ciO() {
        if (this.iuy != null) {
            this.iuy.setText("");
        }
    }

    public void showProgressBar(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.iuC.getLayoutMode().setNightMode(i == 1);
        this.iuC.getLayoutMode().onModeChanged(this.iuw);
        this.eCn.onChangeSkinType(this.iuC.getPageContext(), i);
    }

    private void initUI() {
        this.iuC.setContentView(R.layout.im_add_group_activity);
        this.iuw = this.iuC.findViewById(R.id.addgroup_rootlayout);
        this.eCn = (NavigationBar) this.iuC.findViewById(R.id.addgroup_navigationbar);
        this.iux = this.eCn.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eCn.setTitleText(this.iuC.getResources().getString(R.string.add_group_title_main));
        this.iuy = (EditText) this.iuC.findViewById(R.id.addgroup_input);
        this.iuy.setInputType(2);
        this.iuz = (ImageButton) this.iuC.findViewById(R.id.addgroup_delbtn);
        this.iuA = this.iuC.findViewById(R.id.addgroup_searchbutton);
        this.iuB = this.iuC.findViewById(R.id.addgroup_vcode);
        this.iuy.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.im.searchGroup.a.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.iuy.length() > 0) {
                    a.this.iuz.setVisibility(0);
                } else {
                    a.this.iuz.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                a.this.iuA.setTag(editable.toString().trim());
            }
        });
        this.iuA = this.iuC.findViewById(R.id.addgroup_searchbutton);
        this.progressBar = (ProgressBar) this.iuC.findViewById(R.id.addgroup_progress);
        this.iux.setOnClickListener(this.iuC);
        this.iuz.setOnClickListener(this.iuC);
        this.iuA.setOnClickListener(this.iuC);
        this.iuB.setOnClickListener(this.iuC);
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_ZXING_CAPTURE)) {
            this.iuB.setVisibility(8);
        }
    }
}

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
    private NavigationBar ecf;
    private View hJa;
    private View hJb;
    private EditText hJc;
    private ImageButton hJd;
    private View hJe;
    private View hJf;
    private AddGroupActivity hJg;
    private ProgressBar progressBar;

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.hJa = null;
        this.ecf = null;
        this.hJb = null;
        this.hJc = null;
        this.hJd = null;
        this.progressBar = null;
        this.hJe = null;
        this.hJg = null;
        this.hJg = addGroupActivity;
        initUI();
    }

    public View bTy() {
        return this.hJd;
    }

    public View bXT() {
        return this.hJe;
    }

    public View bXU() {
        return this.hJb;
    }

    public View bXV() {
        return this.hJf;
    }

    public void bXW() {
        if (this.hJc != null) {
            this.hJc.setText("");
        }
    }

    public void showProgressBar(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.hJg.getLayoutMode().setNightMode(i == 1);
        this.hJg.getLayoutMode().onModeChanged(this.hJa);
        this.ecf.onChangeSkinType(this.hJg.getPageContext(), i);
    }

    private void initUI() {
        this.hJg.setContentView(R.layout.im_add_group_activity);
        this.hJa = this.hJg.findViewById(R.id.addgroup_rootlayout);
        this.ecf = (NavigationBar) this.hJg.findViewById(R.id.addgroup_navigationbar);
        this.hJb = this.ecf.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ecf.setTitleText(this.hJg.getResources().getString(R.string.add_group_title_main));
        this.hJc = (EditText) this.hJg.findViewById(R.id.addgroup_input);
        this.hJc.setInputType(2);
        this.hJd = (ImageButton) this.hJg.findViewById(R.id.addgroup_delbtn);
        this.hJe = this.hJg.findViewById(R.id.addgroup_searchbutton);
        this.hJf = this.hJg.findViewById(R.id.addgroup_vcode);
        this.hJc.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.im.searchGroup.a.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.hJc.length() > 0) {
                    a.this.hJd.setVisibility(0);
                } else {
                    a.this.hJd.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                a.this.hJe.setTag(editable.toString().trim());
            }
        });
        this.hJe = this.hJg.findViewById(R.id.addgroup_searchbutton);
        this.progressBar = (ProgressBar) this.hJg.findViewById(R.id.addgroup_progress);
        this.hJb.setOnClickListener(this.hJg);
        this.hJd.setOnClickListener(this.hJg);
        this.hJe.setOnClickListener(this.hJg);
        this.hJf.setOnClickListener(this.hJg);
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_ZXING_CAPTURE)) {
            this.hJf.setVisibility(8);
        }
    }
}

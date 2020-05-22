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
    private NavigationBar eQM;
    private View iJc;
    private View iJd;
    private EditText iJe;
    private ImageButton iJf;
    private View iJg;
    private View iJh;
    private AddGroupActivity iJi;
    private ProgressBar progressBar;

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.iJc = null;
        this.eQM = null;
        this.iJd = null;
        this.iJe = null;
        this.iJf = null;
        this.progressBar = null;
        this.iJg = null;
        this.iJi = null;
        this.iJi = addGroupActivity;
        initUI();
    }

    public View ckN() {
        return this.iJf;
    }

    public View cpi() {
        return this.iJg;
    }

    public View cpj() {
        return this.iJd;
    }

    public View cpk() {
        return this.iJh;
    }

    public void cpl() {
        if (this.iJe != null) {
            this.iJe.setText("");
        }
    }

    public void showProgressBar(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.iJi.getLayoutMode().setNightMode(i == 1);
        this.iJi.getLayoutMode().onModeChanged(this.iJc);
        this.eQM.onChangeSkinType(this.iJi.getPageContext(), i);
    }

    private void initUI() {
        this.iJi.setContentView(R.layout.im_add_group_activity);
        this.iJc = this.iJi.findViewById(R.id.addgroup_rootlayout);
        this.eQM = (NavigationBar) this.iJi.findViewById(R.id.addgroup_navigationbar);
        this.iJd = this.eQM.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eQM.setTitleText(this.iJi.getResources().getString(R.string.add_group_title_main));
        this.iJe = (EditText) this.iJi.findViewById(R.id.addgroup_input);
        this.iJe.setInputType(2);
        this.iJf = (ImageButton) this.iJi.findViewById(R.id.addgroup_delbtn);
        this.iJg = this.iJi.findViewById(R.id.addgroup_searchbutton);
        this.iJh = this.iJi.findViewById(R.id.addgroup_vcode);
        this.iJe.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.im.searchGroup.a.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.iJe.length() > 0) {
                    a.this.iJf.setVisibility(0);
                } else {
                    a.this.iJf.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                a.this.iJg.setTag(editable.toString().trim());
            }
        });
        this.iJg = this.iJi.findViewById(R.id.addgroup_searchbutton);
        this.progressBar = (ProgressBar) this.iJi.findViewById(R.id.addgroup_progress);
        this.iJd.setOnClickListener(this.iJi);
        this.iJf.setOnClickListener(this.iJi);
        this.iJg.setOnClickListener(this.iJi);
        this.iJh.setOnClickListener(this.iJi);
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_ZXING_CAPTURE)) {
            this.iJh.setVisibility(8);
        }
    }
}

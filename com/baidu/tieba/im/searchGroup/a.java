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
    private NavigationBar gjF;
    private View kLt;
    private ImageButton kLu;
    private View kLv;
    private View kLw;
    private AddGroupActivity kLx;
    private View kgV;
    private ProgressBar progressBar;

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.kgV = null;
        this.gjF = null;
        this.kLt = null;
        this.editText = null;
        this.kLu = null;
        this.progressBar = null;
        this.kLv = null;
        this.kLx = null;
        this.kLx = addGroupActivity;
        initUI();
    }

    public View cXJ() {
        return this.kLu;
    }

    public View cXK() {
        return this.kLv;
    }

    public View cXL() {
        return this.kLt;
    }

    public View cXM() {
        return this.kLw;
    }

    public void cXN() {
        if (this.editText != null) {
            this.editText.setText("");
        }
    }

    public void td(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.kLx.getLayoutMode().setNightMode(i == 1);
        this.kLx.getLayoutMode().onModeChanged(this.kgV);
        this.gjF.onChangeSkinType(this.kLx.getPageContext(), i);
    }

    private void initUI() {
        this.kLx.setContentView(R.layout.im_add_group_activity);
        this.kgV = this.kLx.findViewById(R.id.addgroup_rootlayout);
        this.gjF = (NavigationBar) this.kLx.findViewById(R.id.addgroup_navigationbar);
        this.kLt = this.gjF.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gjF.setTitleText(this.kLx.getResources().getString(R.string.add_group_title_main));
        this.editText = (EditText) this.kLx.findViewById(R.id.addgroup_input);
        this.editText.setInputType(2);
        this.kLu = (ImageButton) this.kLx.findViewById(R.id.addgroup_delbtn);
        this.kLv = this.kLx.findViewById(R.id.addgroup_searchbutton);
        this.kLw = this.kLx.findViewById(R.id.addgroup_vcode);
        this.editText.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.im.searchGroup.a.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.editText.length() > 0) {
                    a.this.kLu.setVisibility(0);
                } else {
                    a.this.kLu.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                a.this.kLv.setTag(editable.toString().trim());
            }
        });
        this.kLv = this.kLx.findViewById(R.id.addgroup_searchbutton);
        this.progressBar = (ProgressBar) this.kLx.findViewById(R.id.addgroup_progress);
        this.kLt.setOnClickListener(this.kLx);
        this.kLu.setOnClickListener(this.kLx);
        this.kLv.setOnClickListener(this.kLx);
        this.kLw.setOnClickListener(this.kLx);
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_ZXING_CAPTURE)) {
            this.kLw.setVisibility(8);
        }
    }
}

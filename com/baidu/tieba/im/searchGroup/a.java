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
    private NavigationBar gjT;
    private View kLH;
    private ImageButton kLI;
    private View kLJ;
    private View kLK;
    private AddGroupActivity kLL;
    private View khj;
    private ProgressBar progressBar;

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.khj = null;
        this.gjT = null;
        this.kLH = null;
        this.editText = null;
        this.kLI = null;
        this.progressBar = null;
        this.kLJ = null;
        this.kLL = null;
        this.kLL = addGroupActivity;
        initUI();
    }

    public View cXQ() {
        return this.kLI;
    }

    public View cXR() {
        return this.kLJ;
    }

    public View cXS() {
        return this.kLH;
    }

    public View cXT() {
        return this.kLK;
    }

    public void cXU() {
        if (this.editText != null) {
            this.editText.setText("");
        }
    }

    public void td(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.kLL.getLayoutMode().setNightMode(i == 1);
        this.kLL.getLayoutMode().onModeChanged(this.khj);
        this.gjT.onChangeSkinType(this.kLL.getPageContext(), i);
    }

    private void initUI() {
        this.kLL.setContentView(R.layout.im_add_group_activity);
        this.khj = this.kLL.findViewById(R.id.addgroup_rootlayout);
        this.gjT = (NavigationBar) this.kLL.findViewById(R.id.addgroup_navigationbar);
        this.kLH = this.gjT.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gjT.setTitleText(this.kLL.getResources().getString(R.string.add_group_title_main));
        this.editText = (EditText) this.kLL.findViewById(R.id.addgroup_input);
        this.editText.setInputType(2);
        this.kLI = (ImageButton) this.kLL.findViewById(R.id.addgroup_delbtn);
        this.kLJ = this.kLL.findViewById(R.id.addgroup_searchbutton);
        this.kLK = this.kLL.findViewById(R.id.addgroup_vcode);
        this.editText.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.im.searchGroup.a.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.editText.length() > 0) {
                    a.this.kLI.setVisibility(0);
                } else {
                    a.this.kLI.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                a.this.kLJ.setTag(editable.toString().trim());
            }
        });
        this.kLJ = this.kLL.findViewById(R.id.addgroup_searchbutton);
        this.progressBar = (ProgressBar) this.kLL.findViewById(R.id.addgroup_progress);
        this.kLH.setOnClickListener(this.kLL);
        this.kLI.setOnClickListener(this.kLL);
        this.kLJ.setOnClickListener(this.kLL);
        this.kLK.setOnClickListener(this.kLL);
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_ZXING_CAPTURE)) {
            this.kLK.setVisibility(8);
        }
    }
}

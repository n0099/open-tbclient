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
/* loaded from: classes26.dex */
public class a extends c<AddGroupActivity> {
    private NavigationBar gcI;
    private View jQJ;
    private View kCA;
    private View kCB;
    private AddGroupActivity kCC;
    private View kCx;
    private EditText kCy;
    private ImageButton kCz;
    private ProgressBar progressBar;

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.jQJ = null;
        this.gcI = null;
        this.kCx = null;
        this.kCy = null;
        this.kCz = null;
        this.progressBar = null;
        this.kCA = null;
        this.kCC = null;
        this.kCC = addGroupActivity;
        initUI();
    }

    public View cVb() {
        return this.kCz;
    }

    public View cZQ() {
        return this.kCA;
    }

    public View cZR() {
        return this.kCx;
    }

    public View cZS() {
        return this.kCB;
    }

    public void cZT() {
        if (this.kCy != null) {
            this.kCy.setText("");
        }
    }

    public void showProgressBar(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.kCC.getLayoutMode().setNightMode(i == 1);
        this.kCC.getLayoutMode().onModeChanged(this.jQJ);
        this.gcI.onChangeSkinType(this.kCC.getPageContext(), i);
    }

    private void initUI() {
        this.kCC.setContentView(R.layout.im_add_group_activity);
        this.jQJ = this.kCC.findViewById(R.id.addgroup_rootlayout);
        this.gcI = (NavigationBar) this.kCC.findViewById(R.id.addgroup_navigationbar);
        this.kCx = this.gcI.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gcI.setTitleText(this.kCC.getResources().getString(R.string.add_group_title_main));
        this.kCy = (EditText) this.kCC.findViewById(R.id.addgroup_input);
        this.kCy.setInputType(2);
        this.kCz = (ImageButton) this.kCC.findViewById(R.id.addgroup_delbtn);
        this.kCA = this.kCC.findViewById(R.id.addgroup_searchbutton);
        this.kCB = this.kCC.findViewById(R.id.addgroup_vcode);
        this.kCy.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.im.searchGroup.a.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.kCy.length() > 0) {
                    a.this.kCz.setVisibility(0);
                } else {
                    a.this.kCz.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                a.this.kCA.setTag(editable.toString().trim());
            }
        });
        this.kCA = this.kCC.findViewById(R.id.addgroup_searchbutton);
        this.progressBar = (ProgressBar) this.kCC.findViewById(R.id.addgroup_progress);
        this.kCx.setOnClickListener(this.kCC);
        this.kCz.setOnClickListener(this.kCC);
        this.kCA.setOnClickListener(this.kCC);
        this.kCB.setOnClickListener(this.kCC);
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_ZXING_CAPTURE)) {
            this.kCB.setVisibility(8);
        }
    }
}

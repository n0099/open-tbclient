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
    private NavigationBar gcG;
    private View jQH;
    private AddGroupActivity kCA;
    private View kCv;
    private EditText kCw;
    private ImageButton kCx;
    private View kCy;
    private View kCz;
    private ProgressBar progressBar;

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.jQH = null;
        this.gcG = null;
        this.kCv = null;
        this.kCw = null;
        this.kCx = null;
        this.progressBar = null;
        this.kCy = null;
        this.kCA = null;
        this.kCA = addGroupActivity;
        initUI();
    }

    public View cVa() {
        return this.kCx;
    }

    public View cZP() {
        return this.kCy;
    }

    public View cZQ() {
        return this.kCv;
    }

    public View cZR() {
        return this.kCz;
    }

    public void cZS() {
        if (this.kCw != null) {
            this.kCw.setText("");
        }
    }

    public void showProgressBar(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.kCA.getLayoutMode().setNightMode(i == 1);
        this.kCA.getLayoutMode().onModeChanged(this.jQH);
        this.gcG.onChangeSkinType(this.kCA.getPageContext(), i);
    }

    private void initUI() {
        this.kCA.setContentView(R.layout.im_add_group_activity);
        this.jQH = this.kCA.findViewById(R.id.addgroup_rootlayout);
        this.gcG = (NavigationBar) this.kCA.findViewById(R.id.addgroup_navigationbar);
        this.kCv = this.gcG.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gcG.setTitleText(this.kCA.getResources().getString(R.string.add_group_title_main));
        this.kCw = (EditText) this.kCA.findViewById(R.id.addgroup_input);
        this.kCw.setInputType(2);
        this.kCx = (ImageButton) this.kCA.findViewById(R.id.addgroup_delbtn);
        this.kCy = this.kCA.findViewById(R.id.addgroup_searchbutton);
        this.kCz = this.kCA.findViewById(R.id.addgroup_vcode);
        this.kCw.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.im.searchGroup.a.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.kCw.length() > 0) {
                    a.this.kCx.setVisibility(0);
                } else {
                    a.this.kCx.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                a.this.kCy.setTag(editable.toString().trim());
            }
        });
        this.kCy = this.kCA.findViewById(R.id.addgroup_searchbutton);
        this.progressBar = (ProgressBar) this.kCA.findViewById(R.id.addgroup_progress);
        this.kCv.setOnClickListener(this.kCA);
        this.kCx.setOnClickListener(this.kCA);
        this.kCy.setOnClickListener(this.kCA);
        this.kCz.setOnClickListener(this.kCA);
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_ZXING_CAPTURE)) {
            this.kCz.setVisibility(8);
        }
    }
}

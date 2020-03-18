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
    private NavigationBar ecv;
    private View hKA;
    private View hKB;
    private EditText hKC;
    private ImageButton hKD;
    private View hKE;
    private View hKF;
    private AddGroupActivity hKG;
    private ProgressBar progressBar;

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.hKA = null;
        this.ecv = null;
        this.hKB = null;
        this.hKC = null;
        this.hKD = null;
        this.progressBar = null;
        this.hKE = null;
        this.hKG = null;
        this.hKG = addGroupActivity;
        initUI();
    }

    public View bTQ() {
        return this.hKD;
    }

    public View bYl() {
        return this.hKE;
    }

    public View bYm() {
        return this.hKB;
    }

    public View bYn() {
        return this.hKF;
    }

    public void bYo() {
        if (this.hKC != null) {
            this.hKC.setText("");
        }
    }

    public void showProgressBar(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.hKG.getLayoutMode().setNightMode(i == 1);
        this.hKG.getLayoutMode().onModeChanged(this.hKA);
        this.ecv.onChangeSkinType(this.hKG.getPageContext(), i);
    }

    private void initUI() {
        this.hKG.setContentView(R.layout.im_add_group_activity);
        this.hKA = this.hKG.findViewById(R.id.addgroup_rootlayout);
        this.ecv = (NavigationBar) this.hKG.findViewById(R.id.addgroup_navigationbar);
        this.hKB = this.ecv.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ecv.setTitleText(this.hKG.getResources().getString(R.string.add_group_title_main));
        this.hKC = (EditText) this.hKG.findViewById(R.id.addgroup_input);
        this.hKC.setInputType(2);
        this.hKD = (ImageButton) this.hKG.findViewById(R.id.addgroup_delbtn);
        this.hKE = this.hKG.findViewById(R.id.addgroup_searchbutton);
        this.hKF = this.hKG.findViewById(R.id.addgroup_vcode);
        this.hKC.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.im.searchGroup.a.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.hKC.length() > 0) {
                    a.this.hKD.setVisibility(0);
                } else {
                    a.this.hKD.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                a.this.hKE.setTag(editable.toString().trim());
            }
        });
        this.hKE = this.hKG.findViewById(R.id.addgroup_searchbutton);
        this.progressBar = (ProgressBar) this.hKG.findViewById(R.id.addgroup_progress);
        this.hKB.setOnClickListener(this.hKG);
        this.hKD.setOnClickListener(this.hKG);
        this.hKE.setOnClickListener(this.hKG);
        this.hKF.setOnClickListener(this.hKG);
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_ZXING_CAPTURE)) {
            this.hKF.setVisibility(8);
        }
    }
}

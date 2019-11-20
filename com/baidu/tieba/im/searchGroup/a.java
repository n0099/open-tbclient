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
/* loaded from: classes3.dex */
public class a extends c<AddGroupActivity> {
    private NavigationBar djV;
    private View gPg;
    private View gPh;
    private EditText gPi;
    private ImageButton gPj;
    private View gPk;
    private View gPl;
    private AddGroupActivity gPm;
    private ProgressBar progressBar;

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.gPg = null;
        this.djV = null;
        this.gPh = null;
        this.gPi = null;
        this.gPj = null;
        this.progressBar = null;
        this.gPk = null;
        this.gPm = null;
        this.gPm = addGroupActivity;
        initUI();
    }

    public View bzv() {
        return this.gPj;
    }

    public View bDU() {
        return this.gPk;
    }

    public View bDV() {
        return this.gPh;
    }

    public View bDW() {
        return this.gPl;
    }

    public void bDX() {
        if (this.gPi != null) {
            this.gPi.setText("");
        }
    }

    public void ma(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.gPm.getLayoutMode().setNightMode(i == 1);
        this.gPm.getLayoutMode().onModeChanged(this.gPg);
        this.djV.onChangeSkinType(this.gPm.getPageContext(), i);
    }

    private void initUI() {
        this.gPm.setContentView(R.layout.im_add_group_activity);
        this.gPg = this.gPm.findViewById(R.id.addgroup_rootlayout);
        this.djV = (NavigationBar) this.gPm.findViewById(R.id.addgroup_navigationbar);
        this.gPh = this.djV.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.djV.setTitleText(this.gPm.getResources().getString(R.string.add_group_title_main));
        this.gPi = (EditText) this.gPm.findViewById(R.id.addgroup_input);
        this.gPi.setInputType(2);
        this.gPj = (ImageButton) this.gPm.findViewById(R.id.addgroup_delbtn);
        this.gPk = this.gPm.findViewById(R.id.addgroup_searchbutton);
        this.gPl = this.gPm.findViewById(R.id.addgroup_vcode);
        this.gPi.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.im.searchGroup.a.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.gPi.length() > 0) {
                    a.this.gPj.setVisibility(0);
                } else {
                    a.this.gPj.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                a.this.gPk.setTag(editable.toString().trim());
            }
        });
        this.gPk = this.gPm.findViewById(R.id.addgroup_searchbutton);
        this.progressBar = (ProgressBar) this.gPm.findViewById(R.id.addgroup_progress);
        this.gPh.setOnClickListener(this.gPm);
        this.gPj.setOnClickListener(this.gPm);
        this.gPk.setOnClickListener(this.gPm);
        this.gPl.setOnClickListener(this.gPm);
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_ZXING_CAPTURE)) {
            this.gPl.setVisibility(8);
        }
    }
}

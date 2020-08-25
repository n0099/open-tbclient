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
/* loaded from: classes20.dex */
public class a extends c<AddGroupActivity> {
    private NavigationBar fre;
    private View iMe;
    private View jyn;
    private EditText jyo;
    private ImageButton jyp;
    private View jyq;
    private View jyr;
    private AddGroupActivity jys;
    private ProgressBar progressBar;

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.iMe = null;
        this.fre = null;
        this.jyn = null;
        this.jyo = null;
        this.jyp = null;
        this.progressBar = null;
        this.jyq = null;
        this.jys = null;
        this.jys = addGroupActivity;
        initUI();
    }

    public View cDi() {
        return this.jyp;
    }

    public View cIa() {
        return this.jyq;
    }

    public View cIb() {
        return this.jyn;
    }

    public View cIc() {
        return this.jyr;
    }

    public void cId() {
        if (this.jyo != null) {
            this.jyo.setText("");
        }
    }

    public void showProgressBar(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.jys.getLayoutMode().setNightMode(i == 1);
        this.jys.getLayoutMode().onModeChanged(this.iMe);
        this.fre.onChangeSkinType(this.jys.getPageContext(), i);
    }

    private void initUI() {
        this.jys.setContentView(R.layout.im_add_group_activity);
        this.iMe = this.jys.findViewById(R.id.addgroup_rootlayout);
        this.fre = (NavigationBar) this.jys.findViewById(R.id.addgroup_navigationbar);
        this.jyn = this.fre.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fre.setTitleText(this.jys.getResources().getString(R.string.add_group_title_main));
        this.jyo = (EditText) this.jys.findViewById(R.id.addgroup_input);
        this.jyo.setInputType(2);
        this.jyp = (ImageButton) this.jys.findViewById(R.id.addgroup_delbtn);
        this.jyq = this.jys.findViewById(R.id.addgroup_searchbutton);
        this.jyr = this.jys.findViewById(R.id.addgroup_vcode);
        this.jyo.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.im.searchGroup.a.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.jyo.length() > 0) {
                    a.this.jyp.setVisibility(0);
                } else {
                    a.this.jyp.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                a.this.jyq.setTag(editable.toString().trim());
            }
        });
        this.jyq = this.jys.findViewById(R.id.addgroup_searchbutton);
        this.progressBar = (ProgressBar) this.jys.findViewById(R.id.addgroup_progress);
        this.jyn.setOnClickListener(this.jys);
        this.jyp.setOnClickListener(this.jys);
        this.jyq.setOnClickListener(this.jys);
        this.jyr.setOnClickListener(this.jys);
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_ZXING_CAPTURE)) {
            this.jyr.setVisibility(8);
        }
    }
}

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
    private NavigationBar fri;
    private View iMk;
    private View jyt;
    private EditText jyu;
    private ImageButton jyv;
    private View jyw;
    private View jyx;
    private AddGroupActivity jyy;
    private ProgressBar progressBar;

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.iMk = null;
        this.fri = null;
        this.jyt = null;
        this.jyu = null;
        this.jyv = null;
        this.progressBar = null;
        this.jyw = null;
        this.jyy = null;
        this.jyy = addGroupActivity;
        initUI();
    }

    public View cDj() {
        return this.jyv;
    }

    public View cIb() {
        return this.jyw;
    }

    public View cIc() {
        return this.jyt;
    }

    public View cId() {
        return this.jyx;
    }

    public void cIe() {
        if (this.jyu != null) {
            this.jyu.setText("");
        }
    }

    public void showProgressBar(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.jyy.getLayoutMode().setNightMode(i == 1);
        this.jyy.getLayoutMode().onModeChanged(this.iMk);
        this.fri.onChangeSkinType(this.jyy.getPageContext(), i);
    }

    private void initUI() {
        this.jyy.setContentView(R.layout.im_add_group_activity);
        this.iMk = this.jyy.findViewById(R.id.addgroup_rootlayout);
        this.fri = (NavigationBar) this.jyy.findViewById(R.id.addgroup_navigationbar);
        this.jyt = this.fri.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fri.setTitleText(this.jyy.getResources().getString(R.string.add_group_title_main));
        this.jyu = (EditText) this.jyy.findViewById(R.id.addgroup_input);
        this.jyu.setInputType(2);
        this.jyv = (ImageButton) this.jyy.findViewById(R.id.addgroup_delbtn);
        this.jyw = this.jyy.findViewById(R.id.addgroup_searchbutton);
        this.jyx = this.jyy.findViewById(R.id.addgroup_vcode);
        this.jyu.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.im.searchGroup.a.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.jyu.length() > 0) {
                    a.this.jyv.setVisibility(0);
                } else {
                    a.this.jyv.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                a.this.jyw.setTag(editable.toString().trim());
            }
        });
        this.jyw = this.jyy.findViewById(R.id.addgroup_searchbutton);
        this.progressBar = (ProgressBar) this.jyy.findViewById(R.id.addgroup_progress);
        this.jyt.setOnClickListener(this.jyy);
        this.jyv.setOnClickListener(this.jyy);
        this.jyw.setOnClickListener(this.jyy);
        this.jyx.setOnClickListener(this.jyy);
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_ZXING_CAPTURE)) {
            this.jyx.setVisibility(8);
        }
    }
}

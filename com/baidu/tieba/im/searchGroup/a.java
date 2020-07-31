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
    private NavigationBar ffK;
    private View ixr;
    private View jjm;
    private EditText jjn;
    private ImageButton jjo;
    private View jjp;
    private View jjq;
    private AddGroupActivity jjr;
    private ProgressBar progressBar;

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.ixr = null;
        this.ffK = null;
        this.jjm = null;
        this.jjn = null;
        this.jjo = null;
        this.progressBar = null;
        this.jjp = null;
        this.jjr = null;
        this.jjr = addGroupActivity;
        initUI();
    }

    public View csr() {
        return this.jjo;
    }

    public View cxj() {
        return this.jjp;
    }

    public View cxk() {
        return this.jjm;
    }

    public View cxl() {
        return this.jjq;
    }

    public void cxm() {
        if (this.jjn != null) {
            this.jjn.setText("");
        }
    }

    public void showProgressBar(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.jjr.getLayoutMode().setNightMode(i == 1);
        this.jjr.getLayoutMode().onModeChanged(this.ixr);
        this.ffK.onChangeSkinType(this.jjr.getPageContext(), i);
    }

    private void initUI() {
        this.jjr.setContentView(R.layout.im_add_group_activity);
        this.ixr = this.jjr.findViewById(R.id.addgroup_rootlayout);
        this.ffK = (NavigationBar) this.jjr.findViewById(R.id.addgroup_navigationbar);
        this.jjm = this.ffK.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ffK.setTitleText(this.jjr.getResources().getString(R.string.add_group_title_main));
        this.jjn = (EditText) this.jjr.findViewById(R.id.addgroup_input);
        this.jjn.setInputType(2);
        this.jjo = (ImageButton) this.jjr.findViewById(R.id.addgroup_delbtn);
        this.jjp = this.jjr.findViewById(R.id.addgroup_searchbutton);
        this.jjq = this.jjr.findViewById(R.id.addgroup_vcode);
        this.jjn.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.im.searchGroup.a.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.jjn.length() > 0) {
                    a.this.jjo.setVisibility(0);
                } else {
                    a.this.jjo.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                a.this.jjp.setTag(editable.toString().trim());
            }
        });
        this.jjp = this.jjr.findViewById(R.id.addgroup_searchbutton);
        this.progressBar = (ProgressBar) this.jjr.findViewById(R.id.addgroup_progress);
        this.jjm.setOnClickListener(this.jjr);
        this.jjo.setOnClickListener(this.jjr);
        this.jjp.setOnClickListener(this.jjr);
        this.jjq.setOnClickListener(this.jjr);
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_ZXING_CAPTURE)) {
            this.jjq.setVisibility(8);
        }
    }
}

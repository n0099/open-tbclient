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
    private View ixt;
    private View jjo;
    private EditText jjp;
    private ImageButton jjq;
    private View jjr;
    private View jjs;
    private AddGroupActivity jjt;
    private ProgressBar progressBar;

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.ixt = null;
        this.ffK = null;
        this.jjo = null;
        this.jjp = null;
        this.jjq = null;
        this.progressBar = null;
        this.jjr = null;
        this.jjt = null;
        this.jjt = addGroupActivity;
        initUI();
    }

    public View csr() {
        return this.jjq;
    }

    public View cxj() {
        return this.jjr;
    }

    public View cxk() {
        return this.jjo;
    }

    public View cxl() {
        return this.jjs;
    }

    public void cxm() {
        if (this.jjp != null) {
            this.jjp.setText("");
        }
    }

    public void showProgressBar(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.jjt.getLayoutMode().setNightMode(i == 1);
        this.jjt.getLayoutMode().onModeChanged(this.ixt);
        this.ffK.onChangeSkinType(this.jjt.getPageContext(), i);
    }

    private void initUI() {
        this.jjt.setContentView(R.layout.im_add_group_activity);
        this.ixt = this.jjt.findViewById(R.id.addgroup_rootlayout);
        this.ffK = (NavigationBar) this.jjt.findViewById(R.id.addgroup_navigationbar);
        this.jjo = this.ffK.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ffK.setTitleText(this.jjt.getResources().getString(R.string.add_group_title_main));
        this.jjp = (EditText) this.jjt.findViewById(R.id.addgroup_input);
        this.jjp.setInputType(2);
        this.jjq = (ImageButton) this.jjt.findViewById(R.id.addgroup_delbtn);
        this.jjr = this.jjt.findViewById(R.id.addgroup_searchbutton);
        this.jjs = this.jjt.findViewById(R.id.addgroup_vcode);
        this.jjp.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.im.searchGroup.a.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.jjp.length() > 0) {
                    a.this.jjq.setVisibility(0);
                } else {
                    a.this.jjq.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                a.this.jjr.setTag(editable.toString().trim());
            }
        });
        this.jjr = this.jjt.findViewById(R.id.addgroup_searchbutton);
        this.progressBar = (ProgressBar) this.jjt.findViewById(R.id.addgroup_progress);
        this.jjo.setOnClickListener(this.jjt);
        this.jjq.setOnClickListener(this.jjt);
        this.jjr.setOnClickListener(this.jjt);
        this.jjs.setOnClickListener(this.jjt);
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_ZXING_CAPTURE)) {
            this.jjs.setVisibility(8);
        }
    }
}

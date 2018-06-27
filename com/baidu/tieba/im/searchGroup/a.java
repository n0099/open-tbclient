package com.baidu.tieba.im.searchGroup;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import com.baidu.adp.base.c;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a extends c<AddGroupActivity> {
    private NavigationBar bpg;
    private View exo;
    private View exp;
    private EditText exq;
    private ImageButton exr;
    private View exs;
    private View exu;
    private AddGroupActivity exv;
    private ProgressBar progressBar;

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.exo = null;
        this.bpg = null;
        this.exp = null;
        this.exq = null;
        this.exr = null;
        this.progressBar = null;
        this.exs = null;
        this.exv = null;
        this.exv = addGroupActivity;
        initUI();
    }

    public View aHK() {
        return this.exr;
    }

    public View aMm() {
        return this.exs;
    }

    public View aMn() {
        return this.exp;
    }

    public View aMo() {
        return this.exu;
    }

    public void aMp() {
        if (this.exq != null) {
            this.exq.setText("");
        }
    }

    public void hx(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.exv.getLayoutMode().setNightMode(i == 1);
        this.exv.getLayoutMode().onModeChanged(this.exo);
        this.bpg.onChangeSkinType(this.exv.getPageContext(), i);
    }

    private void initUI() {
        this.exv.setContentView(d.i.im_add_group_activity);
        this.exo = this.exv.findViewById(d.g.addgroup_rootlayout);
        this.bpg = (NavigationBar) this.exv.findViewById(d.g.addgroup_navigationbar);
        this.exp = this.bpg.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bpg.setTitleText(this.exv.getResources().getString(d.k.add_group_title_main));
        this.exq = (EditText) this.exv.findViewById(d.g.addgroup_input);
        this.exq.setInputType(2);
        this.exr = (ImageButton) this.exv.findViewById(d.g.addgroup_delbtn);
        this.exs = this.exv.findViewById(d.g.addgroup_searchbutton);
        this.exu = this.exv.findViewById(d.g.addgroup_vcode);
        this.exq.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.im.searchGroup.a.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.exq.length() > 0) {
                    a.this.exr.setVisibility(0);
                } else {
                    a.this.exr.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                a.this.exs.setTag(editable.toString().trim());
            }
        });
        this.exs = this.exv.findViewById(d.g.addgroup_searchbutton);
        this.progressBar = (ProgressBar) this.exv.findViewById(d.g.addgroup_progress);
        this.exp.setOnClickListener(this.exv);
        this.exr.setOnClickListener(this.exv);
        this.exs.setOnClickListener(this.exv);
        this.exu.setOnClickListener(this.exv);
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2902030)) {
            this.exu.setVisibility(8);
        }
    }
}

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
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class a extends c<AddGroupActivity> {
    private NavigationBar cZw;
    private View gPk;
    private View gPl;
    private EditText gPm;
    private ImageButton gPn;
    private View gPo;
    private View gPp;
    private AddGroupActivity gPq;
    private ProgressBar progressBar;

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.gPk = null;
        this.cZw = null;
        this.gPl = null;
        this.gPm = null;
        this.gPn = null;
        this.progressBar = null;
        this.gPo = null;
        this.gPq = null;
        this.gPq = addGroupActivity;
        initUI();
    }

    public View bBK() {
        return this.gPn;
    }

    public View bGj() {
        return this.gPo;
    }

    public View bGk() {
        return this.gPl;
    }

    public View bGl() {
        return this.gPp;
    }

    public void bGm() {
        if (this.gPm != null) {
            this.gPm.setText("");
        }
    }

    public void mj(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.gPq.getLayoutMode().setNightMode(i == 1);
        this.gPq.getLayoutMode().onModeChanged(this.gPk);
        this.cZw.onChangeSkinType(this.gPq.getPageContext(), i);
    }

    private void initUI() {
        this.gPq.setContentView(R.layout.im_add_group_activity);
        this.gPk = this.gPq.findViewById(R.id.addgroup_rootlayout);
        this.cZw = (NavigationBar) this.gPq.findViewById(R.id.addgroup_navigationbar);
        this.gPl = this.cZw.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cZw.setTitleText(this.gPq.getResources().getString(R.string.add_group_title_main));
        this.gPm = (EditText) this.gPq.findViewById(R.id.addgroup_input);
        this.gPm.setInputType(2);
        this.gPn = (ImageButton) this.gPq.findViewById(R.id.addgroup_delbtn);
        this.gPo = this.gPq.findViewById(R.id.addgroup_searchbutton);
        this.gPp = this.gPq.findViewById(R.id.addgroup_vcode);
        this.gPm.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.im.searchGroup.a.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.gPm.length() > 0) {
                    a.this.gPn.setVisibility(0);
                } else {
                    a.this.gPn.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                a.this.gPo.setTag(editable.toString().trim());
            }
        });
        this.gPo = this.gPq.findViewById(R.id.addgroup_searchbutton);
        this.progressBar = (ProgressBar) this.gPq.findViewById(R.id.addgroup_progress);
        this.gPl.setOnClickListener(this.gPq);
        this.gPn.setOnClickListener(this.gPq);
        this.gPo.setOnClickListener(this.gPq);
        this.gPp.setOnClickListener(this.gPq);
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2902030)) {
            this.gPp.setVisibility(8);
        }
    }
}

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
    private NavigationBar cZD;
    private View gQc;
    private View gQd;
    private EditText gQe;
    private ImageButton gQf;
    private View gQg;
    private View gQh;
    private AddGroupActivity gQi;
    private ProgressBar progressBar;

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.gQc = null;
        this.cZD = null;
        this.gQd = null;
        this.gQe = null;
        this.gQf = null;
        this.progressBar = null;
        this.gQg = null;
        this.gQi = null;
        this.gQi = addGroupActivity;
        initUI();
    }

    public View bBY() {
        return this.gQf;
    }

    public View bGx() {
        return this.gQg;
    }

    public View bGy() {
        return this.gQd;
    }

    public View bGz() {
        return this.gQh;
    }

    public void bGA() {
        if (this.gQe != null) {
            this.gQe.setText("");
        }
    }

    public void mj(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.gQi.getLayoutMode().setNightMode(i == 1);
        this.gQi.getLayoutMode().onModeChanged(this.gQc);
        this.cZD.onChangeSkinType(this.gQi.getPageContext(), i);
    }

    private void initUI() {
        this.gQi.setContentView(R.layout.im_add_group_activity);
        this.gQc = this.gQi.findViewById(R.id.addgroup_rootlayout);
        this.cZD = (NavigationBar) this.gQi.findViewById(R.id.addgroup_navigationbar);
        this.gQd = this.cZD.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cZD.setTitleText(this.gQi.getResources().getString(R.string.add_group_title_main));
        this.gQe = (EditText) this.gQi.findViewById(R.id.addgroup_input);
        this.gQe.setInputType(2);
        this.gQf = (ImageButton) this.gQi.findViewById(R.id.addgroup_delbtn);
        this.gQg = this.gQi.findViewById(R.id.addgroup_searchbutton);
        this.gQh = this.gQi.findViewById(R.id.addgroup_vcode);
        this.gQe.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.im.searchGroup.a.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.gQe.length() > 0) {
                    a.this.gQf.setVisibility(0);
                } else {
                    a.this.gQf.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                a.this.gQg.setTag(editable.toString().trim());
            }
        });
        this.gQg = this.gQi.findViewById(R.id.addgroup_searchbutton);
        this.progressBar = (ProgressBar) this.gQi.findViewById(R.id.addgroup_progress);
        this.gQd.setOnClickListener(this.gQi);
        this.gQf.setOnClickListener(this.gQi);
        this.gQg.setOnClickListener(this.gQi);
        this.gQh.setOnClickListener(this.gQi);
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2902030)) {
            this.gQh.setVisibility(8);
        }
    }
}

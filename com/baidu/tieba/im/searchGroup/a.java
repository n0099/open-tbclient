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
    private NavigationBar cYa;
    private View gJa;
    private View gJb;
    private EditText gJc;
    private ImageButton gJd;
    private View gJe;
    private View gJf;
    private AddGroupActivity gJg;
    private ProgressBar progressBar;

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.gJa = null;
        this.cYa = null;
        this.gJb = null;
        this.gJc = null;
        this.gJd = null;
        this.progressBar = null;
        this.gJe = null;
        this.gJg = null;
        this.gJg = addGroupActivity;
        initUI();
    }

    public View bzf() {
        return this.gJd;
    }

    public View bDC() {
        return this.gJe;
    }

    public View bDD() {
        return this.gJb;
    }

    public View bDE() {
        return this.gJf;
    }

    public void bDF() {
        if (this.gJc != null) {
            this.gJc.setText("");
        }
    }

    public void lV(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.gJg.getLayoutMode().setNightMode(i == 1);
        this.gJg.getLayoutMode().onModeChanged(this.gJa);
        this.cYa.onChangeSkinType(this.gJg.getPageContext(), i);
    }

    private void initUI() {
        this.gJg.setContentView(R.layout.im_add_group_activity);
        this.gJa = this.gJg.findViewById(R.id.addgroup_rootlayout);
        this.cYa = (NavigationBar) this.gJg.findViewById(R.id.addgroup_navigationbar);
        this.gJb = this.cYa.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cYa.setTitleText(this.gJg.getResources().getString(R.string.add_group_title_main));
        this.gJc = (EditText) this.gJg.findViewById(R.id.addgroup_input);
        this.gJc.setInputType(2);
        this.gJd = (ImageButton) this.gJg.findViewById(R.id.addgroup_delbtn);
        this.gJe = this.gJg.findViewById(R.id.addgroup_searchbutton);
        this.gJf = this.gJg.findViewById(R.id.addgroup_vcode);
        this.gJc.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.im.searchGroup.a.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.gJc.length() > 0) {
                    a.this.gJd.setVisibility(0);
                } else {
                    a.this.gJd.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                a.this.gJe.setTag(editable.toString().trim());
            }
        });
        this.gJe = this.gJg.findViewById(R.id.addgroup_searchbutton);
        this.progressBar = (ProgressBar) this.gJg.findViewById(R.id.addgroup_progress);
        this.gJb.setOnClickListener(this.gJg);
        this.gJd.setOnClickListener(this.gJg);
        this.gJe.setOnClickListener(this.gJg);
        this.gJf.setOnClickListener(this.gJg);
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2902030)) {
            this.gJf.setVisibility(8);
        }
    }
}

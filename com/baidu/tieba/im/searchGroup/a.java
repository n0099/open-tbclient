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
    private NavigationBar cXY;
    private View gIX;
    private View gIY;
    private EditText gIZ;
    private ImageButton gJa;
    private View gJb;
    private View gJc;
    private AddGroupActivity gJd;
    private ProgressBar progressBar;

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.gIX = null;
        this.cXY = null;
        this.gIY = null;
        this.gIZ = null;
        this.gJa = null;
        this.progressBar = null;
        this.gJb = null;
        this.gJd = null;
        this.gJd = addGroupActivity;
        initUI();
    }

    public View bzb() {
        return this.gJa;
    }

    public View bDy() {
        return this.gJb;
    }

    public View bDz() {
        return this.gIY;
    }

    public View bDA() {
        return this.gJc;
    }

    public void bDB() {
        if (this.gIZ != null) {
            this.gIZ.setText("");
        }
    }

    public void lU(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.gJd.getLayoutMode().setNightMode(i == 1);
        this.gJd.getLayoutMode().onModeChanged(this.gIX);
        this.cXY.onChangeSkinType(this.gJd.getPageContext(), i);
    }

    private void initUI() {
        this.gJd.setContentView(R.layout.im_add_group_activity);
        this.gIX = this.gJd.findViewById(R.id.addgroup_rootlayout);
        this.cXY = (NavigationBar) this.gJd.findViewById(R.id.addgroup_navigationbar);
        this.gIY = this.cXY.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cXY.setTitleText(this.gJd.getResources().getString(R.string.add_group_title_main));
        this.gIZ = (EditText) this.gJd.findViewById(R.id.addgroup_input);
        this.gIZ.setInputType(2);
        this.gJa = (ImageButton) this.gJd.findViewById(R.id.addgroup_delbtn);
        this.gJb = this.gJd.findViewById(R.id.addgroup_searchbutton);
        this.gJc = this.gJd.findViewById(R.id.addgroup_vcode);
        this.gIZ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.im.searchGroup.a.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.gIZ.length() > 0) {
                    a.this.gJa.setVisibility(0);
                } else {
                    a.this.gJa.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                a.this.gJb.setTag(editable.toString().trim());
            }
        });
        this.gJb = this.gJd.findViewById(R.id.addgroup_searchbutton);
        this.progressBar = (ProgressBar) this.gJd.findViewById(R.id.addgroup_progress);
        this.gIY.setOnClickListener(this.gJd);
        this.gJa.setOnClickListener(this.gJd);
        this.gJb.setOnClickListener(this.gJd);
        this.gJc.setOnClickListener(this.gJd);
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2902030)) {
            this.gJc.setVisibility(8);
        }
    }
}

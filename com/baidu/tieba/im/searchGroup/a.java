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
    private NavigationBar cXZ;
    private View gIY;
    private View gIZ;
    private EditText gJa;
    private ImageButton gJb;
    private View gJc;
    private View gJd;
    private AddGroupActivity gJe;
    private ProgressBar progressBar;

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.gIY = null;
        this.cXZ = null;
        this.gIZ = null;
        this.gJa = null;
        this.gJb = null;
        this.progressBar = null;
        this.gJc = null;
        this.gJe = null;
        this.gJe = addGroupActivity;
        initUI();
    }

    public View bze() {
        return this.gJb;
    }

    public View bDB() {
        return this.gJc;
    }

    public View bDC() {
        return this.gIZ;
    }

    public View bDD() {
        return this.gJd;
    }

    public void bDE() {
        if (this.gJa != null) {
            this.gJa.setText("");
        }
    }

    public void lU(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.gJe.getLayoutMode().setNightMode(i == 1);
        this.gJe.getLayoutMode().onModeChanged(this.gIY);
        this.cXZ.onChangeSkinType(this.gJe.getPageContext(), i);
    }

    private void initUI() {
        this.gJe.setContentView(R.layout.im_add_group_activity);
        this.gIY = this.gJe.findViewById(R.id.addgroup_rootlayout);
        this.cXZ = (NavigationBar) this.gJe.findViewById(R.id.addgroup_navigationbar);
        this.gIZ = this.cXZ.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cXZ.setTitleText(this.gJe.getResources().getString(R.string.add_group_title_main));
        this.gJa = (EditText) this.gJe.findViewById(R.id.addgroup_input);
        this.gJa.setInputType(2);
        this.gJb = (ImageButton) this.gJe.findViewById(R.id.addgroup_delbtn);
        this.gJc = this.gJe.findViewById(R.id.addgroup_searchbutton);
        this.gJd = this.gJe.findViewById(R.id.addgroup_vcode);
        this.gJa.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.im.searchGroup.a.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.gJa.length() > 0) {
                    a.this.gJb.setVisibility(0);
                } else {
                    a.this.gJb.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                a.this.gJc.setTag(editable.toString().trim());
            }
        });
        this.gJc = this.gJe.findViewById(R.id.addgroup_searchbutton);
        this.progressBar = (ProgressBar) this.gJe.findViewById(R.id.addgroup_progress);
        this.gIZ.setOnClickListener(this.gJe);
        this.gJb.setOnClickListener(this.gJe);
        this.gJc.setOnClickListener(this.gJe);
        this.gJd.setOnClickListener(this.gJe);
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2902030)) {
            this.gJd.setVisibility(8);
        }
    }
}

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
    private NavigationBar dbp;
    private ProgressBar gFM;
    private View gRW;
    private View gRX;
    private EditText gRY;
    private ImageButton gRZ;
    private View gSa;
    private View gSb;
    private AddGroupActivity gSc;

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.gRW = null;
        this.dbp = null;
        this.gRX = null;
        this.gRY = null;
        this.gRZ = null;
        this.gFM = null;
        this.gSa = null;
        this.gSc = null;
        this.gSc = addGroupActivity;
        initUI();
    }

    public View bCM() {
        return this.gRZ;
    }

    public View bHl() {
        return this.gSa;
    }

    public View bHm() {
        return this.gRX;
    }

    public View bHn() {
        return this.gSb;
    }

    public void bHo() {
        if (this.gRY != null) {
            this.gRY.setText("");
        }
    }

    public void mm(boolean z) {
        this.gFM.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.gSc.getLayoutMode().setNightMode(i == 1);
        this.gSc.getLayoutMode().onModeChanged(this.gRW);
        this.dbp.onChangeSkinType(this.gSc.getPageContext(), i);
    }

    private void initUI() {
        this.gSc.setContentView(R.layout.im_add_group_activity);
        this.gRW = this.gSc.findViewById(R.id.addgroup_rootlayout);
        this.dbp = (NavigationBar) this.gSc.findViewById(R.id.addgroup_navigationbar);
        this.gRX = this.dbp.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dbp.setTitleText(this.gSc.getResources().getString(R.string.add_group_title_main));
        this.gRY = (EditText) this.gSc.findViewById(R.id.addgroup_input);
        this.gRY.setInputType(2);
        this.gRZ = (ImageButton) this.gSc.findViewById(R.id.addgroup_delbtn);
        this.gSa = this.gSc.findViewById(R.id.addgroup_searchbutton);
        this.gSb = this.gSc.findViewById(R.id.addgroup_vcode);
        this.gRY.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.im.searchGroup.a.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.gRY.length() > 0) {
                    a.this.gRZ.setVisibility(0);
                } else {
                    a.this.gRZ.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                a.this.gSa.setTag(editable.toString().trim());
            }
        });
        this.gSa = this.gSc.findViewById(R.id.addgroup_searchbutton);
        this.gFM = (ProgressBar) this.gSc.findViewById(R.id.addgroup_progress);
        this.gRX.setOnClickListener(this.gSc);
        this.gRZ.setOnClickListener(this.gSc);
        this.gSa.setOnClickListener(this.gSc);
        this.gSb.setOnClickListener(this.gSc);
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2902030)) {
            this.gSb.setVisibility(8);
        }
    }
}

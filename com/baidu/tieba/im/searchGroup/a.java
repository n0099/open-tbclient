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
/* loaded from: classes25.dex */
public class a extends c<AddGroupActivity> {
    private NavigationBar fUw;
    private View jDf;
    private View koZ;
    private EditText kpa;
    private ImageButton kpb;
    private View kpc;
    private View kpd;
    private AddGroupActivity kpe;
    private ProgressBar progressBar;

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.jDf = null;
        this.fUw = null;
        this.koZ = null;
        this.kpa = null;
        this.kpb = null;
        this.progressBar = null;
        this.kpc = null;
        this.kpe = null;
        this.kpe = addGroupActivity;
        initUI();
    }

    public View cPM() {
        return this.kpb;
    }

    public View cUD() {
        return this.kpc;
    }

    public View cUE() {
        return this.koZ;
    }

    public View cUF() {
        return this.kpd;
    }

    public void cUG() {
        if (this.kpa != null) {
            this.kpa.setText("");
        }
    }

    public void showProgressBar(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.kpe.getLayoutMode().setNightMode(i == 1);
        this.kpe.getLayoutMode().onModeChanged(this.jDf);
        this.fUw.onChangeSkinType(this.kpe.getPageContext(), i);
    }

    private void initUI() {
        this.kpe.setContentView(R.layout.im_add_group_activity);
        this.jDf = this.kpe.findViewById(R.id.addgroup_rootlayout);
        this.fUw = (NavigationBar) this.kpe.findViewById(R.id.addgroup_navigationbar);
        this.koZ = this.fUw.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fUw.setTitleText(this.kpe.getResources().getString(R.string.add_group_title_main));
        this.kpa = (EditText) this.kpe.findViewById(R.id.addgroup_input);
        this.kpa.setInputType(2);
        this.kpb = (ImageButton) this.kpe.findViewById(R.id.addgroup_delbtn);
        this.kpc = this.kpe.findViewById(R.id.addgroup_searchbutton);
        this.kpd = this.kpe.findViewById(R.id.addgroup_vcode);
        this.kpa.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.im.searchGroup.a.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.kpa.length() > 0) {
                    a.this.kpb.setVisibility(0);
                } else {
                    a.this.kpb.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                a.this.kpc.setTag(editable.toString().trim());
            }
        });
        this.kpc = this.kpe.findViewById(R.id.addgroup_searchbutton);
        this.progressBar = (ProgressBar) this.kpe.findViewById(R.id.addgroup_progress);
        this.koZ.setOnClickListener(this.kpe);
        this.kpb.setOnClickListener(this.kpe);
        this.kpc.setOnClickListener(this.kpe);
        this.kpd.setOnClickListener(this.kpe);
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_ZXING_CAPTURE)) {
            this.kpd.setVisibility(8);
        }
    }
}

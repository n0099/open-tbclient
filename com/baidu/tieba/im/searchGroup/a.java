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
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class a extends c<AddGroupActivity> {
    private NavigationBar bvF;
    private AddGroupActivity eIA;
    private View eIu;
    private View eIv;
    private EditText eIw;
    private ImageButton eIx;
    private View eIy;
    private View eIz;
    private ProgressBar progressBar;

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.eIu = null;
        this.bvF = null;
        this.eIv = null;
        this.eIw = null;
        this.eIx = null;
        this.progressBar = null;
        this.eIy = null;
        this.eIA = null;
        this.eIA = addGroupActivity;
        initUI();
    }

    public View aKW() {
        return this.eIx;
    }

    public View aPy() {
        return this.eIy;
    }

    public View aPz() {
        return this.eIv;
    }

    public View aPA() {
        return this.eIz;
    }

    public void aPB() {
        if (this.eIw != null) {
            this.eIw.setText("");
        }
    }

    public void hY(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.eIA.getLayoutMode().setNightMode(i == 1);
        this.eIA.getLayoutMode().onModeChanged(this.eIu);
        this.bvF.onChangeSkinType(this.eIA.getPageContext(), i);
    }

    private void initUI() {
        this.eIA.setContentView(e.h.im_add_group_activity);
        this.eIu = this.eIA.findViewById(e.g.addgroup_rootlayout);
        this.bvF = (NavigationBar) this.eIA.findViewById(e.g.addgroup_navigationbar);
        this.eIv = this.bvF.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bvF.setTitleText(this.eIA.getResources().getString(e.j.add_group_title_main));
        this.eIw = (EditText) this.eIA.findViewById(e.g.addgroup_input);
        this.eIw.setInputType(2);
        this.eIx = (ImageButton) this.eIA.findViewById(e.g.addgroup_delbtn);
        this.eIy = this.eIA.findViewById(e.g.addgroup_searchbutton);
        this.eIz = this.eIA.findViewById(e.g.addgroup_vcode);
        this.eIw.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.im.searchGroup.a.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.eIw.length() > 0) {
                    a.this.eIx.setVisibility(0);
                } else {
                    a.this.eIx.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                a.this.eIy.setTag(editable.toString().trim());
            }
        });
        this.eIy = this.eIA.findViewById(e.g.addgroup_searchbutton);
        this.progressBar = (ProgressBar) this.eIA.findViewById(e.g.addgroup_progress);
        this.eIv.setOnClickListener(this.eIA);
        this.eIx.setOnClickListener(this.eIA);
        this.eIy.setOnClickListener(this.eIA);
        this.eIz.setOnClickListener(this.eIA);
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2902030)) {
            this.eIz.setVisibility(8);
        }
    }
}

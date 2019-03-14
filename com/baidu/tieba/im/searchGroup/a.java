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
    private NavigationBar cPK;
    private View grW;
    private View grX;
    private EditText grY;
    private ImageButton grZ;
    private View gsa;
    private View gsb;
    private AddGroupActivity gsc;
    private ProgressBar progressBar;

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.grW = null;
        this.cPK = null;
        this.grX = null;
        this.grY = null;
        this.grZ = null;
        this.progressBar = null;
        this.gsa = null;
        this.gsc = null;
        this.gsc = addGroupActivity;
        initUI();
    }

    public View brs() {
        return this.grZ;
    }

    public View bvT() {
        return this.gsa;
    }

    public View bvU() {
        return this.grX;
    }

    public View bvV() {
        return this.gsb;
    }

    public void bvW() {
        if (this.grY != null) {
            this.grY.setText("");
        }
    }

    public void lf(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.gsc.getLayoutMode().setNightMode(i == 1);
        this.gsc.getLayoutMode().onModeChanged(this.grW);
        this.cPK.onChangeSkinType(this.gsc.getPageContext(), i);
    }

    private void initUI() {
        this.gsc.setContentView(d.h.im_add_group_activity);
        this.grW = this.gsc.findViewById(d.g.addgroup_rootlayout);
        this.cPK = (NavigationBar) this.gsc.findViewById(d.g.addgroup_navigationbar);
        this.grX = this.cPK.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cPK.setTitleText(this.gsc.getResources().getString(d.j.add_group_title_main));
        this.grY = (EditText) this.gsc.findViewById(d.g.addgroup_input);
        this.grY.setInputType(2);
        this.grZ = (ImageButton) this.gsc.findViewById(d.g.addgroup_delbtn);
        this.gsa = this.gsc.findViewById(d.g.addgroup_searchbutton);
        this.gsb = this.gsc.findViewById(d.g.addgroup_vcode);
        this.grY.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.im.searchGroup.a.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.grY.length() > 0) {
                    a.this.grZ.setVisibility(0);
                } else {
                    a.this.grZ.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                a.this.gsa.setTag(editable.toString().trim());
            }
        });
        this.gsa = this.gsc.findViewById(d.g.addgroup_searchbutton);
        this.progressBar = (ProgressBar) this.gsc.findViewById(d.g.addgroup_progress);
        this.grX.setOnClickListener(this.gsc);
        this.grZ.setOnClickListener(this.gsc);
        this.gsa.setOnClickListener(this.gsc);
        this.gsb.setOnClickListener(this.gsc);
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2902030)) {
            this.gsb.setVisibility(8);
        }
    }
}

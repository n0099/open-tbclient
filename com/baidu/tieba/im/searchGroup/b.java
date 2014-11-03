package com.baidu.tieba.im.searchGroup;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import com.baidu.adp.base.f;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class b extends f {
    private ProgressBar aTV;
    private View bhK;
    private NavigationBar bhL;
    private EditText bhM;
    private ImageButton bhN;
    private Button bhO;
    private AddGroupActivity bhP;
    private View iZ;

    public b(AddGroupActivity addGroupActivity) {
        super(addGroupActivity);
        this.bhK = null;
        this.bhL = null;
        this.iZ = null;
        this.bhM = null;
        this.bhN = null;
        this.aTV = null;
        this.bhO = null;
        this.bhP = null;
        this.bhP = addGroupActivity;
        initUI();
    }

    public View LF() {
        return this.bhN;
    }

    public View Ru() {
        return this.bhO;
    }

    public View Rv() {
        return this.iZ;
    }

    public void Rw() {
        if (this.bhM != null) {
            this.bhM.setText("");
        }
    }

    public void da(boolean z) {
        this.aTV.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.bhP.getLayoutMode().L(i == 1);
        this.bhP.getLayoutMode().h(this.bhK);
        this.bhL.onChangeSkinType(i);
    }

    private void initUI() {
        this.bhP.setContentView(w.im_add_group_activity);
        this.bhK = this.bhP.findViewById(v.addgroup_rootlayout);
        this.bhL = (NavigationBar) this.bhP.findViewById(v.addgroup_navigationbar);
        this.iZ = this.bhL.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bhL.setTitleText(this.bhP.getResources().getString(y.add_group_title_main));
        this.bhM = (EditText) this.bhP.findViewById(v.addgroup_input);
        this.bhM.setInputType(2);
        this.bhN = (ImageButton) this.bhP.findViewById(v.addgroup_delbtn);
        this.bhO = (Button) this.bhP.findViewById(v.addgroup_searchbutton);
        this.bhM.addTextChangedListener(new c(this));
        this.bhO = (Button) this.bhP.findViewById(v.addgroup_searchbutton);
        this.aTV = (ProgressBar) this.bhP.findViewById(v.addgroup_progress);
        this.iZ.setOnClickListener(this.bhP);
        this.bhN.setOnClickListener(this.bhP);
        this.bhO.setOnClickListener(this.bhP);
    }
}

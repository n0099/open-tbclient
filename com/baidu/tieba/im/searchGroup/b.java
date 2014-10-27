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
    private ProgressBar aTH;
    private Button bhA;
    private AddGroupActivity bhB;
    private View bhw;
    private NavigationBar bhx;
    private EditText bhy;
    private ImageButton bhz;
    private View iZ;

    public b(AddGroupActivity addGroupActivity) {
        super(addGroupActivity);
        this.bhw = null;
        this.bhx = null;
        this.iZ = null;
        this.bhy = null;
        this.bhz = null;
        this.aTH = null;
        this.bhA = null;
        this.bhB = null;
        this.bhB = addGroupActivity;
        initUI();
    }

    public View LB() {
        return this.bhz;
    }

    public View Rr() {
        return this.bhA;
    }

    public View Rs() {
        return this.iZ;
    }

    public void Rt() {
        if (this.bhy != null) {
            this.bhy.setText("");
        }
    }

    public void da(boolean z) {
        this.aTH.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.bhB.getLayoutMode().L(i == 1);
        this.bhB.getLayoutMode().h(this.bhw);
        this.bhx.onChangeSkinType(i);
    }

    private void initUI() {
        this.bhB.setContentView(w.im_add_group_activity);
        this.bhw = this.bhB.findViewById(v.addgroup_rootlayout);
        this.bhx = (NavigationBar) this.bhB.findViewById(v.addgroup_navigationbar);
        this.iZ = this.bhx.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bhx.setTitleText(this.bhB.getResources().getString(y.add_group_title_main));
        this.bhy = (EditText) this.bhB.findViewById(v.addgroup_input);
        this.bhy.setInputType(2);
        this.bhz = (ImageButton) this.bhB.findViewById(v.addgroup_delbtn);
        this.bhA = (Button) this.bhB.findViewById(v.addgroup_searchbutton);
        this.bhy.addTextChangedListener(new c(this));
        this.bhA = (Button) this.bhB.findViewById(v.addgroup_searchbutton);
        this.aTH = (ProgressBar) this.bhB.findViewById(v.addgroup_progress);
        this.iZ.setOnClickListener(this.bhB);
        this.bhz.setOnClickListener(this.bhB);
        this.bhA.setOnClickListener(this.bhB);
    }
}

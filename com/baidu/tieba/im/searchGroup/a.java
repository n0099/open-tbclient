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
/* loaded from: classes3.dex */
public class a extends c<AddGroupActivity> {
    private NavigationBar dkM;
    private View gPX;
    private View gPY;
    private EditText gPZ;
    private ImageButton gQa;
    private View gQb;
    private View gQc;
    private AddGroupActivity gQd;
    private ProgressBar progressBar;

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.gPX = null;
        this.dkM = null;
        this.gPY = null;
        this.gPZ = null;
        this.gQa = null;
        this.progressBar = null;
        this.gQb = null;
        this.gQd = null;
        this.gQd = addGroupActivity;
        initUI();
    }

    public View bzx() {
        return this.gQa;
    }

    public View bDW() {
        return this.gQb;
    }

    public View bDX() {
        return this.gPY;
    }

    public View bDY() {
        return this.gQc;
    }

    public void bDZ() {
        if (this.gPZ != null) {
            this.gPZ.setText("");
        }
    }

    public void ma(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.gQd.getLayoutMode().setNightMode(i == 1);
        this.gQd.getLayoutMode().onModeChanged(this.gPX);
        this.dkM.onChangeSkinType(this.gQd.getPageContext(), i);
    }

    private void initUI() {
        this.gQd.setContentView(R.layout.im_add_group_activity);
        this.gPX = this.gQd.findViewById(R.id.addgroup_rootlayout);
        this.dkM = (NavigationBar) this.gQd.findViewById(R.id.addgroup_navigationbar);
        this.gPY = this.dkM.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dkM.setTitleText(this.gQd.getResources().getString(R.string.add_group_title_main));
        this.gPZ = (EditText) this.gQd.findViewById(R.id.addgroup_input);
        this.gPZ.setInputType(2);
        this.gQa = (ImageButton) this.gQd.findViewById(R.id.addgroup_delbtn);
        this.gQb = this.gQd.findViewById(R.id.addgroup_searchbutton);
        this.gQc = this.gQd.findViewById(R.id.addgroup_vcode);
        this.gPZ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.im.searchGroup.a.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.gPZ.length() > 0) {
                    a.this.gQa.setVisibility(0);
                } else {
                    a.this.gQa.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                a.this.gQb.setTag(editable.toString().trim());
            }
        });
        this.gQb = this.gQd.findViewById(R.id.addgroup_searchbutton);
        this.progressBar = (ProgressBar) this.gQd.findViewById(R.id.addgroup_progress);
        this.gPY.setOnClickListener(this.gQd);
        this.gQa.setOnClickListener(this.gQd);
        this.gQb.setOnClickListener(this.gQd);
        this.gQc.setOnClickListener(this.gQd);
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_ZXING_CAPTURE)) {
            this.gQc.setVisibility(8);
        }
    }
}

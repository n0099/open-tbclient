package com.baidu.tieba.im.searchGroup;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import com.baidu.adp.base.d;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class a extends d<AddGroupActivity> {
    private EditText editText;
    private NavigationBar glw;
    private View kNJ;
    private ImageButton kNK;
    private View kNL;
    private View kNM;
    private AddGroupActivity kNN;
    private View kjm;
    private ProgressBar progressBar;

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.kjm = null;
        this.glw = null;
        this.kNJ = null;
        this.editText = null;
        this.kNK = null;
        this.progressBar = null;
        this.kNL = null;
        this.kNN = null;
        this.kNN = addGroupActivity;
        initUI();
    }

    public View cXX() {
        return this.kNK;
    }

    public View cXY() {
        return this.kNL;
    }

    public View cXZ() {
        return this.kNJ;
    }

    public View cYa() {
        return this.kNM;
    }

    public void cYb() {
        if (this.editText != null) {
            this.editText.setText("");
        }
    }

    public void td(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.kNN.getLayoutMode().setNightMode(i == 1);
        this.kNN.getLayoutMode().onModeChanged(this.kjm);
        this.glw.onChangeSkinType(this.kNN.getPageContext(), i);
    }

    private void initUI() {
        this.kNN.setContentView(R.layout.im_add_group_activity);
        this.kjm = this.kNN.findViewById(R.id.addgroup_rootlayout);
        this.glw = (NavigationBar) this.kNN.findViewById(R.id.addgroup_navigationbar);
        this.kNJ = this.glw.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.glw.setTitleText(this.kNN.getResources().getString(R.string.add_group_title_main));
        this.editText = (EditText) this.kNN.findViewById(R.id.addgroup_input);
        this.editText.setInputType(2);
        this.kNK = (ImageButton) this.kNN.findViewById(R.id.addgroup_delbtn);
        this.kNL = this.kNN.findViewById(R.id.addgroup_searchbutton);
        this.kNM = this.kNN.findViewById(R.id.addgroup_vcode);
        this.editText.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.im.searchGroup.a.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.editText.length() > 0) {
                    a.this.kNK.setVisibility(0);
                } else {
                    a.this.kNK.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                a.this.kNL.setTag(editable.toString().trim());
            }
        });
        this.kNL = this.kNN.findViewById(R.id.addgroup_searchbutton);
        this.progressBar = (ProgressBar) this.kNN.findViewById(R.id.addgroup_progress);
        this.kNJ.setOnClickListener(this.kNN);
        this.kNK.setOnClickListener(this.kNN);
        this.kNL.setOnClickListener(this.kNN);
        this.kNM.setOnClickListener(this.kNN);
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_ZXING_CAPTURE)) {
            this.kNM.setVisibility(8);
        }
    }
}

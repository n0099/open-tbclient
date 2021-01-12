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
    private NavigationBar ghr;
    private View jZs;
    private View kDo;
    private ImageButton kDp;
    private View kDq;
    private View kDr;
    private AddGroupActivity kDs;
    private ProgressBar progressBar;

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.jZs = null;
        this.ghr = null;
        this.kDo = null;
        this.editText = null;
        this.kDp = null;
        this.progressBar = null;
        this.kDq = null;
        this.kDs = null;
        this.kDs = addGroupActivity;
        initUI();
    }

    public View cVL() {
        return this.kDp;
    }

    public View cVM() {
        return this.kDq;
    }

    public View cVN() {
        return this.kDo;
    }

    public View cVO() {
        return this.kDr;
    }

    public void cVP() {
        if (this.editText != null) {
            this.editText.setText("");
        }
    }

    public void sQ(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.kDs.getLayoutMode().setNightMode(i == 1);
        this.kDs.getLayoutMode().onModeChanged(this.jZs);
        this.ghr.onChangeSkinType(this.kDs.getPageContext(), i);
    }

    private void initUI() {
        this.kDs.setContentView(R.layout.im_add_group_activity);
        this.jZs = this.kDs.findViewById(R.id.addgroup_rootlayout);
        this.ghr = (NavigationBar) this.kDs.findViewById(R.id.addgroup_navigationbar);
        this.kDo = this.ghr.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ghr.setTitleText(this.kDs.getResources().getString(R.string.add_group_title_main));
        this.editText = (EditText) this.kDs.findViewById(R.id.addgroup_input);
        this.editText.setInputType(2);
        this.kDp = (ImageButton) this.kDs.findViewById(R.id.addgroup_delbtn);
        this.kDq = this.kDs.findViewById(R.id.addgroup_searchbutton);
        this.kDr = this.kDs.findViewById(R.id.addgroup_vcode);
        this.editText.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.im.searchGroup.a.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.editText.length() > 0) {
                    a.this.kDp.setVisibility(0);
                } else {
                    a.this.kDp.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                a.this.kDq.setTag(editable.toString().trim());
            }
        });
        this.kDq = this.kDs.findViewById(R.id.addgroup_searchbutton);
        this.progressBar = (ProgressBar) this.kDs.findViewById(R.id.addgroup_progress);
        this.kDo.setOnClickListener(this.kDs);
        this.kDp.setOnClickListener(this.kDs);
        this.kDq.setOnClickListener(this.kDs);
        this.kDr.setOnClickListener(this.kDs);
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_ZXING_CAPTURE)) {
            this.kDr.setVisibility(8);
        }
    }
}

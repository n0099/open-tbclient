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
/* loaded from: classes26.dex */
public class a extends c<AddGroupActivity> {
    private NavigationBar fUP;
    private View jCi;
    private View kop;
    private EditText koq;
    private ImageButton kor;
    private View kos;
    private View kot;
    private AddGroupActivity kou;
    private ProgressBar progressBar;

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.jCi = null;
        this.fUP = null;
        this.kop = null;
        this.koq = null;
        this.kor = null;
        this.progressBar = null;
        this.kos = null;
        this.kou = null;
        this.kou = addGroupActivity;
        initUI();
    }

    public View cQg() {
        return this.kor;
    }

    public View cUX() {
        return this.kos;
    }

    public View cUY() {
        return this.kop;
    }

    public View cUZ() {
        return this.kot;
    }

    public void cVa() {
        if (this.koq != null) {
            this.koq.setText("");
        }
    }

    public void showProgressBar(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.kou.getLayoutMode().setNightMode(i == 1);
        this.kou.getLayoutMode().onModeChanged(this.jCi);
        this.fUP.onChangeSkinType(this.kou.getPageContext(), i);
    }

    private void initUI() {
        this.kou.setContentView(R.layout.im_add_group_activity);
        this.jCi = this.kou.findViewById(R.id.addgroup_rootlayout);
        this.fUP = (NavigationBar) this.kou.findViewById(R.id.addgroup_navigationbar);
        this.kop = this.fUP.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fUP.setTitleText(this.kou.getResources().getString(R.string.add_group_title_main));
        this.koq = (EditText) this.kou.findViewById(R.id.addgroup_input);
        this.koq.setInputType(2);
        this.kor = (ImageButton) this.kou.findViewById(R.id.addgroup_delbtn);
        this.kos = this.kou.findViewById(R.id.addgroup_searchbutton);
        this.kot = this.kou.findViewById(R.id.addgroup_vcode);
        this.koq.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.im.searchGroup.a.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.koq.length() > 0) {
                    a.this.kor.setVisibility(0);
                } else {
                    a.this.kor.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                a.this.kos.setTag(editable.toString().trim());
            }
        });
        this.kos = this.kou.findViewById(R.id.addgroup_searchbutton);
        this.progressBar = (ProgressBar) this.kou.findViewById(R.id.addgroup_progress);
        this.kop.setOnClickListener(this.kou);
        this.kor.setOnClickListener(this.kou);
        this.kos.setOnClickListener(this.kou);
        this.kot.setOnClickListener(this.kou);
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_ZXING_CAPTURE)) {
            this.kot.setVisibility(8);
        }
    }
}

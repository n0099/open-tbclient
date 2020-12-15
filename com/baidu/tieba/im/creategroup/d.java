package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class d implements o {
    EditText koD;
    TextView koE;
    CreateGroupStepActivity kot;
    TbImageView kou;
    private int kox;
    private int mIndex;
    private int mStep;
    View mView;

    public d(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.kot = null;
        this.mView = null;
        this.kou = null;
        this.koD = null;
        this.koE = null;
        this.kot = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step2_view, (ViewGroup) null);
        this.kou = (TbImageView) this.mView.findViewById(R.id.step2_img_bg);
        this.koD = (EditText) this.mView.findViewById(R.id.step2_group_info);
        this.koE = (TextView) this.mView.findViewById(R.id.step2_group_info_count);
        this.mIndex = i;
        this.mStep = i2;
        this.kox = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int cUr() {
        return this.mIndex;
    }

    public EditText cUD() {
        return this.koD;
    }

    public TextView cUE() {
        return this.koE;
    }

    public void DT(int i) {
        String charSequence2String;
        if (wg() / 2 > i && (charSequence2String = com.baidu.adp.lib.util.k.charSequence2String(this.koD.getText(), null)) != null && charSequence2String.length() > 2) {
            while (com.baidu.tieba.im.util.f.getTextLength(charSequence2String) / 2 > i) {
                charSequence2String = charSequence2String.substring(0, charSequence2String.length() - 1);
            }
            this.koD.setText(charSequence2String);
            this.koD.setSelection(charSequence2String.length());
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.kot.getPageContext().getPageActivity(), "create_g_intro", "pv", 1, new Object[0]);
        return this.mView;
    }

    public int wg() {
        return com.baidu.tieba.im.util.f.getTrimmedTextLength(this.koD);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cUx() {
        this.kou.setBackgroundDrawable(null);
    }

    public void cUF() {
        this.kot.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.kot.getLayoutMode().onModeChanged(this.koE);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cUy() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.kot.getLayoutMode().setNightMode(z);
        this.kot.getLayoutMode().onModeChanged(this.mView);
        String a2 = c.a(this.kot.getActivity(), c.koz, z);
        this.koD.setHintTextColor(ap.getColor(R.color.common_color_10005));
        this.kou.startLoad(a2, 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.kot.getPageContext().getString(R.string.group_create_step_intro), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cUA() {
        if (this.mIndex != this.kox) {
            return this.kot.getPageContext().getString(R.string.next_step);
        }
        return this.kot.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cUB() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.kot.getPageContext().getString(R.string.group_step_info_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cUC() {
        return true;
    }
}

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
/* loaded from: classes17.dex */
public class d implements o {
    CreateGroupStepActivity jka;
    TbImageView jkb;
    private int jke;
    EditText jkk;
    TextView jkl;
    private int mIndex;
    private int mStep;
    View mView;

    public d(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.jka = null;
        this.mView = null;
        this.jkb = null;
        this.jkk = null;
        this.jkl = null;
        this.jka = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step2_view, (ViewGroup) null);
        this.jkb = (TbImageView) this.mView.findViewById(R.id.step2_img_bg);
        this.jkk = (EditText) this.mView.findViewById(R.id.step2_group_info);
        this.jkl = (TextView) this.mView.findViewById(R.id.step2_group_info_count);
        this.mIndex = i;
        this.mStep = i2;
        this.jke = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int cCy() {
        return this.mIndex;
    }

    public EditText cCK() {
        return this.jkk;
    }

    public TextView cCL() {
        return this.jkl;
    }

    public void AT(int i) {
        String charSequence2String;
        if (vS() / 2 > i && (charSequence2String = com.baidu.adp.lib.util.k.charSequence2String(this.jkk.getText(), null)) != null && charSequence2String.length() > 2) {
            while (com.baidu.tieba.im.util.f.getTextLength(charSequence2String) / 2 > i) {
                charSequence2String = charSequence2String.substring(0, charSequence2String.length() - 1);
            }
            this.jkk.setText(charSequence2String);
            this.jkk.setSelection(charSequence2String.length());
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.jka.getPageContext().getPageActivity(), "create_g_intro", "pv", 1, new Object[0]);
        return this.mView;
    }

    public int vS() {
        return com.baidu.tieba.im.util.f.getTrimmedTextLength(this.jkk);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cCE() {
        this.jkb.setBackgroundDrawable(null);
    }

    public void cCM() {
        this.jka.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.jka.getLayoutMode().onModeChanged(this.jkl);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cCF() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.jka.getLayoutMode().setNightMode(z);
        this.jka.getLayoutMode().onModeChanged(this.mView);
        String a = c.a(this.jka.getActivity(), c.jkg, z);
        this.jkk.setHintTextColor(ap.getColor(R.color.common_color_10005));
        this.jkb.startLoad(a, 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.jka.getPageContext().getString(R.string.group_create_step_intro), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cCH() {
        if (this.mIndex != this.jke) {
            return this.jka.getPageContext().getString(R.string.next_step);
        }
        return this.jka.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cCI() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.jka.getPageContext().getString(R.string.group_step_info_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cCJ() {
        return true;
    }
}

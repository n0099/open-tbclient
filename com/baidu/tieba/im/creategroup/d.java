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
    CreateGroupStepActivity jkg;
    TbImageView jkh;
    private int jkk;
    EditText jkq;
    TextView jkr;
    private int mIndex;
    private int mStep;
    View mView;

    public d(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.jkg = null;
        this.mView = null;
        this.jkh = null;
        this.jkq = null;
        this.jkr = null;
        this.jkg = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step2_view, (ViewGroup) null);
        this.jkh = (TbImageView) this.mView.findViewById(R.id.step2_img_bg);
        this.jkq = (EditText) this.mView.findViewById(R.id.step2_group_info);
        this.jkr = (TextView) this.mView.findViewById(R.id.step2_group_info_count);
        this.mIndex = i;
        this.mStep = i2;
        this.jkk = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int cCz() {
        return this.mIndex;
    }

    public EditText cCL() {
        return this.jkq;
    }

    public TextView cCM() {
        return this.jkr;
    }

    public void AT(int i) {
        String charSequence2String;
        if (vS() / 2 > i && (charSequence2String = com.baidu.adp.lib.util.k.charSequence2String(this.jkq.getText(), null)) != null && charSequence2String.length() > 2) {
            while (com.baidu.tieba.im.util.f.getTextLength(charSequence2String) / 2 > i) {
                charSequence2String = charSequence2String.substring(0, charSequence2String.length() - 1);
            }
            this.jkq.setText(charSequence2String);
            this.jkq.setSelection(charSequence2String.length());
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.jkg.getPageContext().getPageActivity(), "create_g_intro", "pv", 1, new Object[0]);
        return this.mView;
    }

    public int vS() {
        return com.baidu.tieba.im.util.f.getTrimmedTextLength(this.jkq);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cCF() {
        this.jkh.setBackgroundDrawable(null);
    }

    public void cCN() {
        this.jkg.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.jkg.getLayoutMode().onModeChanged(this.jkr);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cCG() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.jkg.getLayoutMode().setNightMode(z);
        this.jkg.getLayoutMode().onModeChanged(this.mView);
        String a = c.a(this.jkg.getActivity(), c.jkm, z);
        this.jkq.setHintTextColor(ap.getColor(R.color.common_color_10005));
        this.jkh.startLoad(a, 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.jkg.getPageContext().getString(R.string.group_create_step_intro), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cCI() {
        if (this.mIndex != this.jkk) {
            return this.jkg.getPageContext().getString(R.string.next_step);
        }
        return this.jkg.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cCJ() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.jkg.getPageContext().getString(R.string.group_step_info_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cCK() {
        return true;
    }
}

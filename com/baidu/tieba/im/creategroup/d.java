package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class d implements o {
    CreateGroupStepActivity iUZ;
    TbImageView iVa;
    private int iVd;
    EditText iVj;
    TextView iVk;
    private int mIndex;
    private int mStep;
    View mView;

    public d(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.iUZ = null;
        this.mView = null;
        this.iVa = null;
        this.iVj = null;
        this.iVk = null;
        this.iUZ = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step2_view, (ViewGroup) null);
        this.iVa = (TbImageView) this.mView.findViewById(R.id.step2_img_bg);
        this.iVj = (EditText) this.mView.findViewById(R.id.step2_group_info);
        this.iVk = (TextView) this.mView.findViewById(R.id.step2_group_info_count);
        this.mIndex = i;
        this.mStep = i2;
        this.iVd = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int crG() {
        return this.mIndex;
    }

    public EditText crS() {
        return this.iVj;
    }

    public TextView crT() {
        return this.iVk;
    }

    public void yz(int i) {
        String charSequence2String;
        if (crU() / 2 > i && (charSequence2String = com.baidu.adp.lib.util.k.charSequence2String(this.iVj.getText(), null)) != null && charSequence2String.length() > 2) {
            while (com.baidu.tieba.im.util.f.getTextLength(charSequence2String) / 2 > i) {
                charSequence2String = charSequence2String.substring(0, charSequence2String.length() - 1);
            }
            this.iVj.setText(charSequence2String);
            this.iVj.setSelection(charSequence2String.length());
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.iUZ.getPageContext().getPageActivity(), "create_g_intro", "pv", 1, new Object[0]);
        return this.mView;
    }

    public int crU() {
        return com.baidu.tieba.im.util.f.getTrimmedTextLength(this.iVj);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void crM() {
        this.iVa.setBackgroundDrawable(null);
    }

    public void crV() {
        this.iUZ.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.iUZ.getLayoutMode().onModeChanged(this.iVk);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void crN() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.iUZ.getLayoutMode().setNightMode(z);
        this.iUZ.getLayoutMode().onModeChanged(this.mView);
        String a = c.a(this.iUZ.getActivity(), c.iVf, z);
        this.iVj.setHintTextColor(ao.getColor(R.color.common_color_10005));
        this.iVa.startLoad(a, 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.iUZ.getPageContext().getString(R.string.group_create_step_intro), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String crP() {
        if (this.mIndex != this.iVd) {
            return this.iUZ.getPageContext().getString(R.string.next_step);
        }
        return this.iUZ.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean crQ() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.iUZ.getPageContext().getString(R.string.group_step_info_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean crR() {
        return true;
    }
}

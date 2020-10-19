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
    CreateGroupStepActivity jHH;
    TbImageView jHI;
    private int jHL;
    EditText jHR;
    TextView jHS;
    private int mIndex;
    private int mStep;
    View mView;

    public d(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.jHH = null;
        this.mView = null;
        this.jHI = null;
        this.jHR = null;
        this.jHS = null;
        this.jHH = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step2_view, (ViewGroup) null);
        this.jHI = (TbImageView) this.mView.findViewById(R.id.step2_img_bg);
        this.jHR = (EditText) this.mView.findViewById(R.id.step2_group_info);
        this.jHS = (TextView) this.mView.findViewById(R.id.step2_group_info_count);
        this.mIndex = i;
        this.mStep = i2;
        this.jHL = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int cJO() {
        return this.mIndex;
    }

    public EditText cKa() {
        return this.jHR;
    }

    public TextView cKb() {
        return this.jHS;
    }

    public void Ca(int i) {
        String charSequence2String;
        if (wp() / 2 > i && (charSequence2String = com.baidu.adp.lib.util.k.charSequence2String(this.jHR.getText(), null)) != null && charSequence2String.length() > 2) {
            while (com.baidu.tieba.im.util.f.getTextLength(charSequence2String) / 2 > i) {
                charSequence2String = charSequence2String.substring(0, charSequence2String.length() - 1);
            }
            this.jHR.setText(charSequence2String);
            this.jHR.setSelection(charSequence2String.length());
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.jHH.getPageContext().getPageActivity(), "create_g_intro", "pv", 1, new Object[0]);
        return this.mView;
    }

    public int wp() {
        return com.baidu.tieba.im.util.f.getTrimmedTextLength(this.jHR);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cJU() {
        this.jHI.setBackgroundDrawable(null);
    }

    public void cKc() {
        this.jHH.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.jHH.getLayoutMode().onModeChanged(this.jHS);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cJV() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.jHH.getLayoutMode().setNightMode(z);
        this.jHH.getLayoutMode().onModeChanged(this.mView);
        String a2 = c.a(this.jHH.getActivity(), c.jHN, z);
        this.jHR.setHintTextColor(ap.getColor(R.color.common_color_10005));
        this.jHI.startLoad(a2, 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.jHH.getPageContext().getString(R.string.group_create_step_intro), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cJX() {
        if (this.mIndex != this.jHL) {
            return this.jHH.getPageContext().getString(R.string.next_step);
        }
        return this.jHH.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cJY() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.jHH.getPageContext().getString(R.string.group_step_info_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cJZ() {
        return true;
    }
}

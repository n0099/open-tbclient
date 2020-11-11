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
    CreateGroupStepActivity kac;
    TbImageView kad;
    private int kag;
    EditText kam;
    TextView kan;
    private int mIndex;
    private int mStep;
    View mView;

    public d(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.kac = null;
        this.mView = null;
        this.kad = null;
        this.kam = null;
        this.kan = null;
        this.kac = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step2_view, (ViewGroup) null);
        this.kad = (TbImageView) this.mView.findViewById(R.id.step2_img_bg);
        this.kam = (EditText) this.mView.findViewById(R.id.step2_group_info);
        this.kan = (TextView) this.mView.findViewById(R.id.step2_group_info_count);
        this.mIndex = i;
        this.mStep = i2;
        this.kag = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int cPw() {
        return this.mIndex;
    }

    public EditText cPI() {
        return this.kam;
    }

    public TextView cPJ() {
        return this.kan;
    }

    public void CG(int i) {
        String charSequence2String;
        if (wp() / 2 > i && (charSequence2String = com.baidu.adp.lib.util.k.charSequence2String(this.kam.getText(), null)) != null && charSequence2String.length() > 2) {
            while (com.baidu.tieba.im.util.f.getTextLength(charSequence2String) / 2 > i) {
                charSequence2String = charSequence2String.substring(0, charSequence2String.length() - 1);
            }
            this.kam.setText(charSequence2String);
            this.kam.setSelection(charSequence2String.length());
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.kac.getPageContext().getPageActivity(), "create_g_intro", "pv", 1, new Object[0]);
        return this.mView;
    }

    public int wp() {
        return com.baidu.tieba.im.util.f.getTrimmedTextLength(this.kam);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cPC() {
        this.kad.setBackgroundDrawable(null);
    }

    public void cPK() {
        this.kac.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.kac.getLayoutMode().onModeChanged(this.kan);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cPD() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.kac.getLayoutMode().setNightMode(z);
        this.kac.getLayoutMode().onModeChanged(this.mView);
        String a2 = c.a(this.kac.getActivity(), c.kai, z);
        this.kam.setHintTextColor(ap.getColor(R.color.common_color_10005));
        this.kad.startLoad(a2, 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.kac.getPageContext().getString(R.string.group_create_step_intro), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cPF() {
        if (this.mIndex != this.kag) {
            return this.kac.getPageContext().getString(R.string.next_step);
        }
        return this.kac.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cPG() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.kac.getPageContext().getString(R.string.group_step_info_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cPH() {
        return true;
    }
}

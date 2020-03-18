package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class d implements o {
    CreateGroupStepActivity hxC;
    TbImageView hxD;
    private int hxG;
    EditText hxM;
    TextView hxN;
    private int mIndex;
    private int mStep;
    View mView;

    public d(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.hxC = null;
        this.mView = null;
        this.hxD = null;
        this.hxM = null;
        this.hxN = null;
        this.hxC = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step2_view, (ViewGroup) null);
        this.hxD = (TbImageView) this.mView.findViewById(R.id.step2_img_bg);
        this.hxM = (EditText) this.mView.findViewById(R.id.step2_group_info);
        this.hxN = (TextView) this.mView.findViewById(R.id.step2_group_info_count);
        this.mIndex = i;
        this.mStep = i2;
        this.hxG = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int bTf() {
        return this.mIndex;
    }

    public EditText bTr() {
        return this.hxM;
    }

    public TextView bTs() {
        return this.hxN;
    }

    public void wo(int i) {
        String charSequence2String;
        if (bTt() / 2 > i && (charSequence2String = com.baidu.adp.lib.util.k.charSequence2String(this.hxM.getText(), null)) != null && charSequence2String.length() > 2) {
            while (com.baidu.tieba.im.util.f.getTextLength(charSequence2String) / 2 > i) {
                charSequence2String = charSequence2String.substring(0, charSequence2String.length() - 1);
            }
            this.hxM.setText(charSequence2String);
            this.hxM.setSelection(charSequence2String.length());
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.hxC.getPageContext().getPageActivity(), "create_g_intro", "pv", 1, new Object[0]);
        return this.mView;
    }

    public int bTt() {
        return com.baidu.tieba.im.util.f.getTrimmedTextLength(this.hxM);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bTl() {
        this.hxD.setBackgroundDrawable(null);
    }

    public void bTu() {
        this.hxC.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.hxC.getLayoutMode().onModeChanged(this.hxN);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bTm() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.hxC.getLayoutMode().setNightMode(z);
        this.hxC.getLayoutMode().onModeChanged(this.mView);
        String a = c.a(this.hxC.getActivity(), c.hxI, z);
        this.hxM.setHintTextColor(am.getColor(R.color.common_color_10005));
        this.hxD.startLoad(a, 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.hxC.getPageContext().getString(R.string.group_create_step_intro), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String bTo() {
        if (this.mIndex != this.hxG) {
            return this.hxC.getPageContext().getString(R.string.next_step);
        }
        return this.hxC.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bTp() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.hxC.getPageContext().getString(R.string.group_step_info_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bTq() {
        return true;
    }
}

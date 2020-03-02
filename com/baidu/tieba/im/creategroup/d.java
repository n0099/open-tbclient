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
    CreateGroupStepActivity hvQ;
    TbImageView hvR;
    private int hvU;
    EditText hwa;
    TextView hwb;
    private int mIndex;
    private int mStep;
    View mView;

    public d(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.hvQ = null;
        this.mView = null;
        this.hvR = null;
        this.hwa = null;
        this.hwb = null;
        this.hvQ = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step2_view, (ViewGroup) null);
        this.hvR = (TbImageView) this.mView.findViewById(R.id.step2_img_bg);
        this.hwa = (EditText) this.mView.findViewById(R.id.step2_group_info);
        this.hwb = (TextView) this.mView.findViewById(R.id.step2_group_info_count);
        this.mIndex = i;
        this.mStep = i2;
        this.hvU = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int bSM() {
        return this.mIndex;
    }

    public EditText bSY() {
        return this.hwa;
    }

    public TextView bSZ() {
        return this.hwb;
    }

    public void wg(int i) {
        String charSequence2String;
        if (bTa() / 2 > i && (charSequence2String = com.baidu.adp.lib.util.k.charSequence2String(this.hwa.getText(), null)) != null && charSequence2String.length() > 2) {
            while (com.baidu.tieba.im.util.f.getTextLength(charSequence2String) / 2 > i) {
                charSequence2String = charSequence2String.substring(0, charSequence2String.length() - 1);
            }
            this.hwa.setText(charSequence2String);
            this.hwa.setSelection(charSequence2String.length());
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.hvQ.getPageContext().getPageActivity(), "create_g_intro", "pv", 1, new Object[0]);
        return this.mView;
    }

    public int bTa() {
        return com.baidu.tieba.im.util.f.getTrimmedTextLength(this.hwa);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bSS() {
        this.hvR.setBackgroundDrawable(null);
    }

    public void bTb() {
        this.hvQ.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.hvQ.getLayoutMode().onModeChanged(this.hwb);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bST() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.hvQ.getLayoutMode().setNightMode(z);
        this.hvQ.getLayoutMode().onModeChanged(this.mView);
        String a = c.a(this.hvQ.getActivity(), c.hvW, z);
        this.hwa.setHintTextColor(am.getColor(R.color.common_color_10005));
        this.hvR.startLoad(a, 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.hvQ.getPageContext().getString(R.string.group_create_step_intro), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String bSV() {
        if (this.mIndex != this.hvU) {
            return this.hvQ.getPageContext().getString(R.string.next_step);
        }
        return this.hvQ.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bSW() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.hvQ.getPageContext().getString(R.string.group_step_info_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bSX() {
        return true;
    }
}

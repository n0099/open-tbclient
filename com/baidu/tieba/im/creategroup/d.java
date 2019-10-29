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
/* loaded from: classes5.dex */
public class d implements o {
    CreateGroupStepActivity gCY;
    TbImageView gCZ;
    private int gDc;
    EditText gDi;
    TextView gDj;
    private int mIndex;
    private int mStep;
    View mView;

    public d(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.gCY = null;
        this.mView = null;
        this.gCZ = null;
        this.gDi = null;
        this.gDj = null;
        this.gCY = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step2_view, (ViewGroup) null);
        this.gCZ = (TbImageView) this.mView.findViewById(R.id.step2_img_bg);
        this.gDi = (EditText) this.mView.findViewById(R.id.step2_group_info);
        this.gDj = (TextView) this.mView.findViewById(R.id.step2_group_info_count);
        this.mIndex = i;
        this.mStep = i2;
        this.gDc = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int byL() {
        return this.mIndex;
    }

    public EditText byX() {
        return this.gDi;
    }

    public TextView byY() {
        return this.gDj;
    }

    public void tU(int i) {
        String charSequence2String;
        if (byZ() / 2 > i && (charSequence2String = com.baidu.adp.lib.util.k.charSequence2String(this.gDi.getText(), null)) != null && charSequence2String.length() > 2) {
            while (com.baidu.tieba.im.util.f.getTextLength(charSequence2String) / 2 > i) {
                charSequence2String = charSequence2String.substring(0, charSequence2String.length() - 1);
            }
            this.gDi.setText(charSequence2String);
            this.gDi.setSelection(charSequence2String.length());
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.gCY.getPageContext().getPageActivity(), "create_g_intro", "pv", 1, new Object[0]);
        return this.mView;
    }

    public int byZ() {
        return com.baidu.tieba.im.util.f.getTrimmedTextLength(this.gDi);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void byR() {
        this.gCZ.setBackgroundDrawable(null);
    }

    public void bza() {
        this.gCY.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.gCY.getLayoutMode().onModeChanged(this.gDj);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void byS() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.gCY.getLayoutMode().setNightMode(z);
        this.gCY.getLayoutMode().onModeChanged(this.mView);
        String a = c.a(this.gCY.getActivity(), c.gDe, z);
        this.gDi.setHintTextColor(am.getColor(R.color.common_color_10005));
        this.gCZ.startLoad(a, 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.gCY.getPageContext().getString(R.string.group_create_step_intro), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String byU() {
        if (this.mIndex != this.gDc) {
            return this.gCY.getPageContext().getString(R.string.next_step);
        }
        return this.gCY.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean byV() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.gCY.getPageContext().getString(R.string.group_step_info_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean byW() {
        return true;
    }
}

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
    CreateGroupStepActivity iwR;
    TbImageView iwS;
    private int iwV;
    EditText ixb;
    TextView ixc;
    private int mIndex;
    private int mStep;
    View mView;

    public d(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.iwR = null;
        this.mView = null;
        this.iwS = null;
        this.ixb = null;
        this.ixc = null;
        this.iwR = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step2_view, (ViewGroup) null);
        this.iwS = (TbImageView) this.mView.findViewById(R.id.step2_img_bg);
        this.ixb = (EditText) this.mView.findViewById(R.id.step2_group_info);
        this.ixc = (TextView) this.mView.findViewById(R.id.step2_group_info_count);
        this.mIndex = i;
        this.mStep = i2;
        this.iwV = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int ckl() {
        return this.mIndex;
    }

    public EditText ckx() {
        return this.ixb;
    }

    public TextView cky() {
        return this.ixc;
    }

    public void xu(int i) {
        String charSequence2String;
        if (ckz() / 2 > i && (charSequence2String = com.baidu.adp.lib.util.k.charSequence2String(this.ixb.getText(), null)) != null && charSequence2String.length() > 2) {
            while (com.baidu.tieba.im.util.f.getTextLength(charSequence2String) / 2 > i) {
                charSequence2String = charSequence2String.substring(0, charSequence2String.length() - 1);
            }
            this.ixb.setText(charSequence2String);
            this.ixb.setSelection(charSequence2String.length());
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.iwR.getPageContext().getPageActivity(), "create_g_intro", "pv", 1, new Object[0]);
        return this.mView;
    }

    public int ckz() {
        return com.baidu.tieba.im.util.f.getTrimmedTextLength(this.ixb);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void ckr() {
        this.iwS.setBackgroundDrawable(null);
    }

    public void ckA() {
        this.iwR.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.iwR.getLayoutMode().onModeChanged(this.ixc);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cks() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.iwR.getLayoutMode().setNightMode(z);
        this.iwR.getLayoutMode().onModeChanged(this.mView);
        String a = c.a(this.iwR.getActivity(), c.iwX, z);
        this.ixb.setHintTextColor(am.getColor(R.color.common_color_10005));
        this.iwS.startLoad(a, 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.iwR.getPageContext().getString(R.string.group_create_step_intro), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cku() {
        if (this.mIndex != this.iwV) {
            return this.iwR.getPageContext().getString(R.string.next_step);
        }
        return this.iwR.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean ckv() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.iwR.getPageContext().getString(R.string.group_step_info_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean ckw() {
        return true;
    }
}

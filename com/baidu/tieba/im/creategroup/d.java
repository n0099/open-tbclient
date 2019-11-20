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
    CreateGroupStepActivity gCh;
    TbImageView gCi;
    private int gCl;
    EditText gCr;
    TextView gCs;
    private int mIndex;
    private int mStep;
    View mView;

    public d(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.gCh = null;
        this.mView = null;
        this.gCi = null;
        this.gCr = null;
        this.gCs = null;
        this.gCh = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step2_view, (ViewGroup) null);
        this.gCi = (TbImageView) this.mView.findViewById(R.id.step2_img_bg);
        this.gCr = (EditText) this.mView.findViewById(R.id.step2_group_info);
        this.gCs = (TextView) this.mView.findViewById(R.id.step2_group_info_count);
        this.mIndex = i;
        this.mStep = i2;
        this.gCl = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int byJ() {
        return this.mIndex;
    }

    public EditText byV() {
        return this.gCr;
    }

    public TextView byW() {
        return this.gCs;
    }

    public void tT(int i) {
        String charSequence2String;
        if (byX() / 2 > i && (charSequence2String = com.baidu.adp.lib.util.k.charSequence2String(this.gCr.getText(), null)) != null && charSequence2String.length() > 2) {
            while (com.baidu.tieba.im.util.f.getTextLength(charSequence2String) / 2 > i) {
                charSequence2String = charSequence2String.substring(0, charSequence2String.length() - 1);
            }
            this.gCr.setText(charSequence2String);
            this.gCr.setSelection(charSequence2String.length());
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.gCh.getPageContext().getPageActivity(), "create_g_intro", "pv", 1, new Object[0]);
        return this.mView;
    }

    public int byX() {
        return com.baidu.tieba.im.util.f.getTrimmedTextLength(this.gCr);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void byP() {
        this.gCi.setBackgroundDrawable(null);
    }

    public void byY() {
        this.gCh.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.gCh.getLayoutMode().onModeChanged(this.gCs);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void byQ() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.gCh.getLayoutMode().setNightMode(z);
        this.gCh.getLayoutMode().onModeChanged(this.mView);
        String a = c.a(this.gCh.getActivity(), c.gCn, z);
        this.gCr.setHintTextColor(am.getColor(R.color.common_color_10005));
        this.gCi.startLoad(a, 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.gCh.getPageContext().getString(R.string.group_create_step_intro), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String byS() {
        if (this.mIndex != this.gCl) {
            return this.gCh.getPageContext().getString(R.string.next_step);
        }
        return this.gCh.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean byT() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.gCh.getPageContext().getString(R.string.group_step_info_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean byU() {
        return true;
    }
}

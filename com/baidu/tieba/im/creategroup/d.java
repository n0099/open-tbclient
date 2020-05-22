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
    CreateGroupStepActivity iwe;
    TbImageView iwf;
    private int iwi;
    EditText iwo;
    TextView iwp;
    private int mIndex;
    private int mStep;
    View mView;

    public d(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.iwe = null;
        this.mView = null;
        this.iwf = null;
        this.iwo = null;
        this.iwp = null;
        this.iwe = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step2_view, (ViewGroup) null);
        this.iwf = (TbImageView) this.mView.findViewById(R.id.step2_img_bg);
        this.iwo = (EditText) this.mView.findViewById(R.id.step2_group_info);
        this.iwp = (TextView) this.mView.findViewById(R.id.step2_group_info_count);
        this.mIndex = i;
        this.mStep = i2;
        this.iwi = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int ckc() {
        return this.mIndex;
    }

    public EditText cko() {
        return this.iwo;
    }

    public TextView ckp() {
        return this.iwp;
    }

    public void xs(int i) {
        String charSequence2String;
        if (ckq() / 2 > i && (charSequence2String = com.baidu.adp.lib.util.k.charSequence2String(this.iwo.getText(), null)) != null && charSequence2String.length() > 2) {
            while (com.baidu.tieba.im.util.f.getTextLength(charSequence2String) / 2 > i) {
                charSequence2String = charSequence2String.substring(0, charSequence2String.length() - 1);
            }
            this.iwo.setText(charSequence2String);
            this.iwo.setSelection(charSequence2String.length());
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        TiebaStatic.eventStat(this.iwe.getPageContext().getPageActivity(), "create_g_intro", "pv", 1, new Object[0]);
        return this.mView;
    }

    public int ckq() {
        return com.baidu.tieba.im.util.f.getTrimmedTextLength(this.iwo);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cki() {
        this.iwf.setBackgroundDrawable(null);
    }

    public void ckr() {
        this.iwe.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.iwe.getLayoutMode().onModeChanged(this.iwp);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void ckj() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.iwe.getLayoutMode().setNightMode(z);
        this.iwe.getLayoutMode().onModeChanged(this.mView);
        String a = c.a(this.iwe.getActivity(), c.iwk, z);
        this.iwo.setHintTextColor(am.getColor(R.color.common_color_10005));
        this.iwf.startLoad(a, 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.iwe.getPageContext().getString(R.string.group_create_step_intro), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String ckl() {
        if (this.mIndex != this.iwi) {
            return this.iwe.getPageContext().getString(R.string.next_step);
        }
        return this.iwe.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean ckm() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return this.iwe.getPageContext().getString(R.string.group_step_info_error);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean ckn() {
        return true;
    }
}

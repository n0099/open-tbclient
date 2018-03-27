package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class d implements p {
    private int avb;
    CreateGroupStepActivity ezB;
    TbImageView ezC;
    private int ezF;
    EditText ezL;
    TextView ezM;
    private int mIndex;
    View mView;

    public d(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.ezB = null;
        this.mView = null;
        this.ezC = null;
        this.ezL = null;
        this.ezM = null;
        this.ezB = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(d.h.create_group_step2_view, (ViewGroup) null);
        this.ezC = (TbImageView) this.mView.findViewById(d.g.step2_img_bg);
        this.ezL = (EditText) this.mView.findViewById(d.g.step2_group_info);
        this.ezM = (TextView) this.mView.findViewById(d.g.step2_group_info_count);
        this.mIndex = i;
        this.avb = i2;
        this.ezF = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public int aGy() {
        return this.mIndex;
    }

    public EditText aGK() {
        return this.ezL;
    }

    public TextView aGL() {
        return this.ezM;
    }

    public void pP(int i) {
        String a;
        if (getLength() / 2 > i && (a = com.baidu.adp.lib.util.k.a(this.ezL.getText(), null)) != null && a.length() > 2) {
            while (com.baidu.tieba.im.util.f.hs(a) / 2 > i) {
                a = a.substring(0, a.length() - 1);
            }
            this.ezL.setText(a);
            this.ezL.setSelection(a.length());
        }
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public View getView() {
        TiebaStatic.eventStat(this.ezB.getPageContext().getPageActivity(), "create_g_intro", "pv", 1, new Object[0]);
        return this.mView;
    }

    public int getLength() {
        return com.baidu.tieba.im.util.f.e(this.ezL);
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public void aGE() {
        this.ezC.setBackgroundDrawable(null);
    }

    public void aGM() {
        this.ezB.getLayoutMode().aQ(TbadkApplication.getInst().getSkinType() == 1);
        this.ezB.getLayoutMode().aM(this.ezM);
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public void aGF() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.ezB.getLayoutMode().aQ(z);
        this.ezB.getLayoutMode().aM(this.mView);
        String a = c.a(this.ezB.getActivity(), c.ezH, z);
        this.ezL.setHintTextColor(aj.getColor(d.C0141d.common_color_10005));
        this.ezC.startLoad(a, 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public String getTitle() {
        return String.format(this.ezB.getPageContext().getString(d.j.group_create_step_intro), Integer.valueOf(this.avb));
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public String aGH() {
        if (this.mIndex != this.ezF) {
            return this.ezB.getPageContext().getString(d.j.next_step);
        }
        return this.ezB.getPageContext().getString(d.j.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public boolean aGI() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public String getErrMsg() {
        return this.ezB.getPageContext().getString(d.j.group_step_info_error);
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public boolean aGJ() {
        return true;
    }
}

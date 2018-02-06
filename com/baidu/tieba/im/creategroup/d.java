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
    private int avj;
    private int ezB;
    EditText ezH;
    TextView ezI;
    CreateGroupStepActivity ezx;
    TbImageView ezy;
    private int mIndex;
    View mView;

    public d(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.ezx = null;
        this.mView = null;
        this.ezy = null;
        this.ezH = null;
        this.ezI = null;
        this.ezx = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(d.h.create_group_step2_view, (ViewGroup) null);
        this.ezy = (TbImageView) this.mView.findViewById(d.g.step2_img_bg);
        this.ezH = (EditText) this.mView.findViewById(d.g.step2_group_info);
        this.ezI = (TextView) this.mView.findViewById(d.g.step2_group_info_count);
        this.mIndex = i;
        this.avj = i2;
        this.ezB = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public int aGy() {
        return this.mIndex;
    }

    public EditText aGK() {
        return this.ezH;
    }

    public TextView aGL() {
        return this.ezI;
    }

    public void pO(int i) {
        String a;
        if (getLength() / 2 > i && (a = com.baidu.adp.lib.util.k.a(this.ezH.getText(), null)) != null && a.length() > 2) {
            while (com.baidu.tieba.im.util.f.hs(a) / 2 > i) {
                a = a.substring(0, a.length() - 1);
            }
            this.ezH.setText(a);
            this.ezH.setSelection(a.length());
        }
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public View getView() {
        TiebaStatic.eventStat(this.ezx.getPageContext().getPageActivity(), "create_g_intro", "pv", 1, new Object[0]);
        return this.mView;
    }

    public int getLength() {
        return com.baidu.tieba.im.util.f.e(this.ezH);
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public void aGE() {
        this.ezy.setBackgroundDrawable(null);
    }

    public void aGM() {
        this.ezx.getLayoutMode().aQ(TbadkApplication.getInst().getSkinType() == 1);
        this.ezx.getLayoutMode().aM(this.ezI);
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public void aGF() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.ezx.getLayoutMode().aQ(z);
        this.ezx.getLayoutMode().aM(this.mView);
        String a = c.a(this.ezx.getActivity(), c.ezD, z);
        this.ezH.setHintTextColor(aj.getColor(d.C0140d.common_color_10005));
        this.ezy.startLoad(a, 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public String getTitle() {
        return String.format(this.ezx.getPageContext().getString(d.j.group_create_step_intro), Integer.valueOf(this.avj));
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public String aGH() {
        if (this.mIndex != this.ezB) {
            return this.ezx.getPageContext().getString(d.j.next_step);
        }
        return this.ezx.getPageContext().getString(d.j.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public boolean aGI() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public String getErrMsg() {
        return this.ezx.getPageContext().getString(d.j.group_step_info_error);
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public boolean aGJ() {
        return true;
    }
}

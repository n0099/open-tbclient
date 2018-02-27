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
    private int ava;
    CreateGroupStepActivity ezl;
    TbImageView ezm;
    private int ezp;
    EditText ezv;
    TextView ezw;
    private int mIndex;
    View mView;

    public d(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.ezl = null;
        this.mView = null;
        this.ezm = null;
        this.ezv = null;
        this.ezw = null;
        this.ezl = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(d.h.create_group_step2_view, (ViewGroup) null);
        this.ezm = (TbImageView) this.mView.findViewById(d.g.step2_img_bg);
        this.ezv = (EditText) this.mView.findViewById(d.g.step2_group_info);
        this.ezw = (TextView) this.mView.findViewById(d.g.step2_group_info_count);
        this.mIndex = i;
        this.ava = i2;
        this.ezp = i3;
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public int aGx() {
        return this.mIndex;
    }

    public EditText aGJ() {
        return this.ezv;
    }

    public TextView aGK() {
        return this.ezw;
    }

    public void pO(int i) {
        String a;
        if (getLength() / 2 > i && (a = com.baidu.adp.lib.util.k.a(this.ezv.getText(), null)) != null && a.length() > 2) {
            while (com.baidu.tieba.im.util.f.hs(a) / 2 > i) {
                a = a.substring(0, a.length() - 1);
            }
            this.ezv.setText(a);
            this.ezv.setSelection(a.length());
        }
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public View getView() {
        TiebaStatic.eventStat(this.ezl.getPageContext().getPageActivity(), "create_g_intro", "pv", 1, new Object[0]);
        return this.mView;
    }

    public int getLength() {
        return com.baidu.tieba.im.util.f.e(this.ezv);
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public void aGD() {
        this.ezm.setBackgroundDrawable(null);
    }

    public void aGL() {
        this.ezl.getLayoutMode().aQ(TbadkApplication.getInst().getSkinType() == 1);
        this.ezl.getLayoutMode().aM(this.ezw);
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public void aGE() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.ezl.getLayoutMode().aQ(z);
        this.ezl.getLayoutMode().aM(this.mView);
        String a = c.a(this.ezl.getActivity(), c.ezr, z);
        this.ezv.setHintTextColor(aj.getColor(d.C0141d.common_color_10005));
        this.ezm.startLoad(a, 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public String getTitle() {
        return String.format(this.ezl.getPageContext().getString(d.j.group_create_step_intro), Integer.valueOf(this.ava));
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public String aGG() {
        if (this.mIndex != this.ezp) {
            return this.ezl.getPageContext().getString(d.j.next_step);
        }
        return this.ezl.getPageContext().getString(d.j.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public boolean aGH() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public String getErrMsg() {
        return this.ezl.getPageContext().getString(d.j.group_step_info_error);
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public boolean aGI() {
        return true;
    }
}

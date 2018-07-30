package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class e implements o {
    private CreateGroupStepActivity eoi;
    private TbImageView eou;
    private Button eov;
    private int mIndex;
    private View mView;

    public e(CreateGroupStepActivity createGroupStepActivity, int i, int i2) {
        this.eoi = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(d.h.create_group_lbs_tips, (ViewGroup) null);
        this.eov = (Button) this.mView.findViewById(d.g.create_group_tips_btn);
        this.eou = (TbImageView) this.mView.findViewById(d.g.create_group_tips_image);
        this.mIndex = i;
        this.eov.setText(String.format(createGroupStepActivity.getPageContext().getString(d.j.group_create_can_create_num), Integer.valueOf(i2)));
        c.b(this.eoi.getActivity(), c.eon, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.eoi.getActivity(), c.eoq, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.eoi.getActivity(), c.eoo, TbadkApplication.getInst().getSkinType() == 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aIe() {
        this.eou.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aIf() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.eoi.getLayoutMode().setNightMode(z);
        this.eoi.getLayoutMode().onModeChanged(this.mView);
        this.eou.startLoad(c.a(this.eoi.getActivity(), c.eop, z), 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aHY() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return this.eoi.getPageContext().getString(d.j.group_create_tips_lbs);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aIh() {
        return "";
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aIi() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    public Button aIn() {
        return this.eov;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aIj() {
        return false;
    }
}

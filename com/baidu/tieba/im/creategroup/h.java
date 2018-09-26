package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class h implements o {
    private TbImageView evJ;
    private Button evK;
    private CreateGroupStepActivity evx;
    private int mIndex;
    private View mView;

    public h(CreateGroupStepActivity createGroupStepActivity, int i, int i2) {
        this.evx = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(e.h.create_group_normal_tips, (ViewGroup) null);
        this.evK = (Button) this.mView.findViewById(e.g.create_group_tips_btn);
        this.evJ = (TbImageView) this.mView.findViewById(e.g.create_group_tips_image);
        this.mIndex = i;
        this.evK.setText(String.format(createGroupStepActivity.getPageContext().getString(e.j.group_create_can_create_num), Integer.valueOf(i2)));
        c.b(this.evx.getPageContext().getPageActivity(), c.evC, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.evx.getPageContext().getPageActivity(), c.evF, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.evx.getPageContext().getPageActivity(), c.evD, TbadkApplication.getInst().getSkinType() == 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aKq() {
        this.evJ.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aKr() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.evx.getLayoutMode().setNightMode(z);
        this.evx.getLayoutMode().onModeChanged(this.mView);
        this.evJ.startLoad(c.a(this.evx.getPageContext().getPageActivity(), c.evG, z), 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aKk() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return this.evx.getPageContext().getString(e.j.group_create_tips_normal);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aKt() {
        return "";
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aKu() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aKv() {
        return false;
    }

    public Button aKz() {
        return this.evK;
    }
}

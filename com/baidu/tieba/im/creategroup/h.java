package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class h implements o {
    private TbImageView ihB;
    private Button ihC;
    private CreateGroupStepActivity ihp;
    private int mIndex;
    private View mView;

    public h(CreateGroupStepActivity createGroupStepActivity, int i, int i2) {
        this.ihp = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_normal_tips, (ViewGroup) null);
        this.ihC = (Button) this.mView.findViewById(R.id.create_group_tips_btn);
        this.ihB = (TbImageView) this.mView.findViewById(R.id.create_group_tips_image);
        this.mIndex = i;
        this.ihC.setText(String.format(createGroupStepActivity.getPageContext().getString(R.string.group_create_can_create_num), Integer.valueOf(i2)));
        c.b(this.ihp.getPageContext().getPageActivity(), c.ihu, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.ihp.getPageContext().getPageActivity(), c.ihx, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.ihp.getPageContext().getPageActivity(), c.ihv, TbadkApplication.getInst().getSkinType() == 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cdL() {
        this.ihB.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cdM() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.ihp.getLayoutMode().setNightMode(z);
        this.ihp.getLayoutMode().onModeChanged(this.mView);
        this.ihB.startLoad(c.a(this.ihp.getPageContext().getPageActivity(), c.ihy, z), 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int cdF() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return this.ihp.getPageContext().getString(R.string.group_create_tips_normal);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cdO() {
        return "";
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cdP() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cdQ() {
        return false;
    }

    public Button cdV() {
        return this.ihC;
    }
}

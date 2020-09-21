package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class h implements o {
    private CreateGroupStepActivity jsK;
    private TbImageView jsW;
    private Button jsX;
    private int mIndex;
    private View mView;

    public h(CreateGroupStepActivity createGroupStepActivity, int i, int i2) {
        this.jsK = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_normal_tips, (ViewGroup) null);
        this.jsX = (Button) this.mView.findViewById(R.id.create_group_tips_btn);
        this.jsW = (TbImageView) this.mView.findViewById(R.id.create_group_tips_image);
        this.mIndex = i;
        this.jsX.setText(String.format(createGroupStepActivity.getPageContext().getString(R.string.group_create_can_create_num), Integer.valueOf(i2)));
        c.b(this.jsK.getPageContext().getPageActivity(), c.jsP, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.jsK.getPageContext().getPageActivity(), c.jsS, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.jsK.getPageContext().getPageActivity(), c.jsQ, TbadkApplication.getInst().getSkinType() == 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cGl() {
        this.jsW.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cGm() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.jsK.getLayoutMode().setNightMode(z);
        this.jsK.getLayoutMode().onModeChanged(this.mView);
        this.jsW.startLoad(c.a(this.jsK.getPageContext().getPageActivity(), c.jsT, z), 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int cGf() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return this.jsK.getPageContext().getString(R.string.group_create_tips_normal);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String cGo() {
        return "";
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cGp() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cGq() {
        return false;
    }

    public Button cGu() {
        return this.jsX;
    }
}

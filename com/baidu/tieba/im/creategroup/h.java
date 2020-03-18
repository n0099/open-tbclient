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
    private CreateGroupStepActivity hxC;
    private TbImageView hxO;
    private Button hxP;
    private int mIndex;
    private View mView;

    public h(CreateGroupStepActivity createGroupStepActivity, int i, int i2) {
        this.hxC = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_normal_tips, (ViewGroup) null);
        this.hxP = (Button) this.mView.findViewById(R.id.create_group_tips_btn);
        this.hxO = (TbImageView) this.mView.findViewById(R.id.create_group_tips_image);
        this.mIndex = i;
        this.hxP.setText(String.format(createGroupStepActivity.getPageContext().getString(R.string.group_create_can_create_num), Integer.valueOf(i2)));
        c.b(this.hxC.getPageContext().getPageActivity(), c.hxH, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.hxC.getPageContext().getPageActivity(), c.hxK, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.hxC.getPageContext().getPageActivity(), c.hxI, TbadkApplication.getInst().getSkinType() == 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bTl() {
        this.hxO.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bTm() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.hxC.getLayoutMode().setNightMode(z);
        this.hxC.getLayoutMode().onModeChanged(this.mView);
        this.hxO.startLoad(c.a(this.hxC.getPageContext().getPageActivity(), c.hxL, z), 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int bTf() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return this.hxC.getPageContext().getString(R.string.group_create_tips_normal);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String bTo() {
        return "";
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bTp() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bTq() {
        return false;
    }

    public Button bTv() {
        return this.hxP;
    }
}

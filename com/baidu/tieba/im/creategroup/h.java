package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class h implements o {
    private CreateGroupStepActivity iVb;
    private TbImageView iVn;
    private Button iVo;
    private int mIndex;
    private View mView;

    public h(CreateGroupStepActivity createGroupStepActivity, int i, int i2) {
        this.iVb = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_normal_tips, (ViewGroup) null);
        this.iVo = (Button) this.mView.findViewById(R.id.create_group_tips_btn);
        this.iVn = (TbImageView) this.mView.findViewById(R.id.create_group_tips_image);
        this.mIndex = i;
        this.iVo.setText(String.format(createGroupStepActivity.getPageContext().getString(R.string.group_create_can_create_num), Integer.valueOf(i2)));
        c.b(this.iVb.getPageContext().getPageActivity(), c.iVg, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.iVb.getPageContext().getPageActivity(), c.iVj, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.iVb.getPageContext().getPageActivity(), c.iVh, TbadkApplication.getInst().getSkinType() == 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void crM() {
        this.iVn.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void crN() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.iVb.getLayoutMode().setNightMode(z);
        this.iVb.getLayoutMode().onModeChanged(this.mView);
        this.iVn.startLoad(c.a(this.iVb.getPageContext().getPageActivity(), c.iVk, z), 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int crG() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return this.iVb.getPageContext().getString(R.string.group_create_tips_normal);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String crP() {
        return "";
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean crQ() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean crR() {
        return false;
    }

    public Button crW() {
        return this.iVo;
    }
}

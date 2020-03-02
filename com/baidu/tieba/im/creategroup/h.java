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
    private CreateGroupStepActivity hvQ;
    private TbImageView hwc;
    private Button hwd;
    private int mIndex;
    private View mView;

    public h(CreateGroupStepActivity createGroupStepActivity, int i, int i2) {
        this.hvQ = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_normal_tips, (ViewGroup) null);
        this.hwd = (Button) this.mView.findViewById(R.id.create_group_tips_btn);
        this.hwc = (TbImageView) this.mView.findViewById(R.id.create_group_tips_image);
        this.mIndex = i;
        this.hwd.setText(String.format(createGroupStepActivity.getPageContext().getString(R.string.group_create_can_create_num), Integer.valueOf(i2)));
        c.b(this.hvQ.getPageContext().getPageActivity(), c.hvV, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.hvQ.getPageContext().getPageActivity(), c.hvY, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.hvQ.getPageContext().getPageActivity(), c.hvW, TbadkApplication.getInst().getSkinType() == 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bSS() {
        this.hwc.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bST() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.hvQ.getLayoutMode().setNightMode(z);
        this.hvQ.getLayoutMode().onModeChanged(this.mView);
        this.hwc.startLoad(c.a(this.hvQ.getPageContext().getPageActivity(), c.hvZ, z), 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int bSM() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return this.hvQ.getPageContext().getString(R.string.group_create_tips_normal);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String bSV() {
        return "";
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bSW() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bSX() {
        return false;
    }

    public Button bTc() {
        return this.hwd;
    }
}

package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class h implements o {
    private CreateGroupStepActivity gCh;
    private TbImageView gCt;
    private Button gCu;
    private int mIndex;
    private View mView;

    public h(CreateGroupStepActivity createGroupStepActivity, int i, int i2) {
        this.gCh = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_normal_tips, (ViewGroup) null);
        this.gCu = (Button) this.mView.findViewById(R.id.create_group_tips_btn);
        this.gCt = (TbImageView) this.mView.findViewById(R.id.create_group_tips_image);
        this.mIndex = i;
        this.gCu.setText(String.format(createGroupStepActivity.getPageContext().getString(R.string.group_create_can_create_num), Integer.valueOf(i2)));
        c.b(this.gCh.getPageContext().getPageActivity(), c.gCm, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.gCh.getPageContext().getPageActivity(), c.gCp, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.gCh.getPageContext().getPageActivity(), c.gCn, TbadkApplication.getInst().getSkinType() == 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void byP() {
        this.gCt.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void byQ() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.gCh.getLayoutMode().setNightMode(z);
        this.gCh.getLayoutMode().onModeChanged(this.mView);
        this.gCt.startLoad(c.a(this.gCh.getPageContext().getPageActivity(), c.gCq, z), 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int byJ() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return this.gCh.getPageContext().getString(R.string.group_create_tips_normal);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String byS() {
        return "";
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean byT() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean byU() {
        return false;
    }

    public Button byZ() {
        return this.gCu;
    }
}

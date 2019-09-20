package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class e implements o {
    private CreateGroupStepActivity gEY;
    private TbImageView gFk;
    private Button gFl;
    private int mIndex;
    private View mView;

    public e(CreateGroupStepActivity createGroupStepActivity, int i, int i2) {
        this.gEY = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_lbs_tips, (ViewGroup) null);
        this.gFl = (Button) this.mView.findViewById(R.id.create_group_tips_btn);
        this.gFk = (TbImageView) this.mView.findViewById(R.id.create_group_tips_image);
        this.mIndex = i;
        this.gFl.setText(String.format(createGroupStepActivity.getPageContext().getString(R.string.group_create_can_create_num), Integer.valueOf(i2)));
        c.b(this.gEY.getActivity(), c.gFd, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.gEY.getActivity(), c.gFg, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.gEY.getActivity(), c.gFe, TbadkApplication.getInst().getSkinType() == 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bCg() {
        this.gFk.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bCh() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.gEY.getLayoutMode().setNightMode(z);
        this.gEY.getLayoutMode().onModeChanged(this.mView);
        this.gFk.startLoad(c.a(this.gEY.getActivity(), c.gFf, z), 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int bCa() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return this.gEY.getPageContext().getString(R.string.group_create_tips_lbs);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String bCj() {
        return "";
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bCk() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    public Button bCq() {
        return this.gFl;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bCl() {
        return false;
    }
}

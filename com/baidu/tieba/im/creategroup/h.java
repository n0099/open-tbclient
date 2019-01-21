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
    private CreateGroupStepActivity eOY;
    private TbImageView ePk;
    private Button ePl;
    private int mIndex;
    private View mView;

    public h(CreateGroupStepActivity createGroupStepActivity, int i, int i2) {
        this.eOY = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(e.h.create_group_normal_tips, (ViewGroup) null);
        this.ePl = (Button) this.mView.findViewById(e.g.create_group_tips_btn);
        this.ePk = (TbImageView) this.mView.findViewById(e.g.create_group_tips_image);
        this.mIndex = i;
        this.ePl.setText(String.format(createGroupStepActivity.getPageContext().getString(e.j.group_create_can_create_num), Integer.valueOf(i2)));
        c.b(this.eOY.getPageContext().getPageActivity(), c.ePd, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.eOY.getPageContext().getPageActivity(), c.ePg, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.eOY.getPageContext().getPageActivity(), c.ePe, TbadkApplication.getInst().getSkinType() == 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aQi() {
        this.ePk.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aQj() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.eOY.getLayoutMode().setNightMode(z);
        this.eOY.getLayoutMode().onModeChanged(this.mView);
        this.ePk.startLoad(c.a(this.eOY.getPageContext().getPageActivity(), c.ePh, z), 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aQc() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return this.eOY.getPageContext().getString(e.j.group_create_tips_normal);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aQl() {
        return "";
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aQm() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aQn() {
        return false;
    }

    public Button aQr() {
        return this.ePl;
    }
}

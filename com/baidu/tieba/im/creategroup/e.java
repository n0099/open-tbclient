package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class e implements o {
    private CreateGroupStepActivity eOX;
    private TbImageView ePj;
    private Button ePk;
    private int mIndex;
    private View mView;

    public e(CreateGroupStepActivity createGroupStepActivity, int i, int i2) {
        this.eOX = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(e.h.create_group_lbs_tips, (ViewGroup) null);
        this.ePk = (Button) this.mView.findViewById(e.g.create_group_tips_btn);
        this.ePj = (TbImageView) this.mView.findViewById(e.g.create_group_tips_image);
        this.mIndex = i;
        this.ePk.setText(String.format(createGroupStepActivity.getPageContext().getString(e.j.group_create_can_create_num), Integer.valueOf(i2)));
        c.b(this.eOX.getActivity(), c.ePc, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.eOX.getActivity(), c.ePf, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.eOX.getActivity(), c.ePd, TbadkApplication.getInst().getSkinType() == 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aQi() {
        this.ePj.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aQj() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.eOX.getLayoutMode().setNightMode(z);
        this.eOX.getLayoutMode().onModeChanged(this.mView);
        this.ePj.startLoad(c.a(this.eOX.getActivity(), c.ePe, z), 29, false);
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
        return this.eOX.getPageContext().getString(e.j.group_create_tips_lbs);
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

    public Button aQr() {
        return this.ePk;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aQn() {
        return false;
    }
}

package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class e implements o {
    private CreateGroupStepActivity iNW;
    private TbImageView iOi;
    private Button iOj;
    private int mIndex;
    private View mView;

    public e(CreateGroupStepActivity createGroupStepActivity, int i, int i2) {
        this.iNW = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_lbs_tips, (ViewGroup) null);
        this.iOj = (Button) this.mView.findViewById(R.id.create_group_tips_btn);
        this.iOi = (TbImageView) this.mView.findViewById(R.id.create_group_tips_image);
        this.mIndex = i;
        this.iOj.setText(String.format(createGroupStepActivity.getPageContext().getString(R.string.group_create_can_create_num), Integer.valueOf(i2)));
        c.b(this.iNW.getActivity(), c.iOb, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.iNW.getActivity(), c.iOe, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.iNW.getActivity(), c.iOc, TbadkApplication.getInst().getSkinType() == 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cog() {
        this.iOi.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void coh() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.iNW.getLayoutMode().setNightMode(z);
        this.iNW.getLayoutMode().onModeChanged(this.mView);
        this.iOi.startLoad(c.a(this.iNW.getActivity(), c.iOd, z), 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int coa() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return this.iNW.getPageContext().getString(R.string.group_create_tips_lbs);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String coj() {
        return "";
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cok() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    public Button coq() {
        return this.iOj;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean col() {
        return false;
    }
}

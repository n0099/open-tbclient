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
    private CreateGroupStepActivity iwe;
    private TbImageView iwq;
    private Button iwr;
    private int mIndex;
    private View mView;

    public h(CreateGroupStepActivity createGroupStepActivity, int i, int i2) {
        this.iwe = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_normal_tips, (ViewGroup) null);
        this.iwr = (Button) this.mView.findViewById(R.id.create_group_tips_btn);
        this.iwq = (TbImageView) this.mView.findViewById(R.id.create_group_tips_image);
        this.mIndex = i;
        this.iwr.setText(String.format(createGroupStepActivity.getPageContext().getString(R.string.group_create_can_create_num), Integer.valueOf(i2)));
        c.b(this.iwe.getPageContext().getPageActivity(), c.iwj, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.iwe.getPageContext().getPageActivity(), c.iwm, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.iwe.getPageContext().getPageActivity(), c.iwk, TbadkApplication.getInst().getSkinType() == 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cki() {
        this.iwq.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void ckj() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.iwe.getLayoutMode().setNightMode(z);
        this.iwe.getLayoutMode().onModeChanged(this.mView);
        this.iwq.startLoad(c.a(this.iwe.getPageContext().getPageActivity(), c.iwn, z), 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int ckc() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return this.iwe.getPageContext().getString(R.string.group_create_tips_normal);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String ckl() {
        return "";
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean ckm() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean ckn() {
        return false;
    }

    public Button cks() {
        return this.iwr;
    }
}

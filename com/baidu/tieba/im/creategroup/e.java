package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class e implements o {
    private TbImageView ekB;
    private Button ekC;
    private CreateGroupStepActivity ekp;
    private int mIndex;
    private View mView;

    public e(CreateGroupStepActivity createGroupStepActivity, int i, int i2) {
        this.ekp = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(d.i.create_group_lbs_tips, (ViewGroup) null);
        this.ekC = (Button) this.mView.findViewById(d.g.create_group_tips_btn);
        this.ekB = (TbImageView) this.mView.findViewById(d.g.create_group_tips_image);
        this.mIndex = i;
        this.ekC.setText(String.format(createGroupStepActivity.getPageContext().getString(d.k.group_create_can_create_num), Integer.valueOf(i2)));
        c.b(this.ekp.getActivity(), c.eku, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.ekp.getActivity(), c.ekx, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.ekp.getActivity(), c.ekv, TbadkApplication.getInst().getSkinType() == 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aHe() {
        this.ekB.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aHf() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.ekp.getLayoutMode().setNightMode(z);
        this.ekp.getLayoutMode().onModeChanged(this.mView);
        this.ekB.startLoad(c.a(this.ekp.getActivity(), c.ekw, z), 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aGY() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return this.ekp.getPageContext().getString(d.k.group_create_tips_lbs);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aHh() {
        return "";
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aHi() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    public Button aHn() {
        return this.ekC;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aHj() {
        return false;
    }
}

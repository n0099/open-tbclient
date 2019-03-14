package com.baidu.tieba.im.creategroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class e implements o {
    private CreateGroupStepActivity gfb;
    private TbImageView gfn;
    private Button gfo;
    private int mIndex;
    private View mView;

    public e(CreateGroupStepActivity createGroupStepActivity, int i, int i2) {
        this.gfb = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(d.h.create_group_lbs_tips, (ViewGroup) null);
        this.gfo = (Button) this.mView.findViewById(d.g.create_group_tips_btn);
        this.gfn = (TbImageView) this.mView.findViewById(d.g.create_group_tips_image);
        this.mIndex = i;
        this.gfo.setText(String.format(createGroupStepActivity.getPageContext().getString(d.j.group_create_can_create_num), Integer.valueOf(i2)));
        c.b(this.gfb.getActivity(), c.gfg, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.gfb.getActivity(), c.gfj, TbadkApplication.getInst().getSkinType() == 1);
        c.b(this.gfb.getActivity(), c.gfh, TbadkApplication.getInst().getSkinType() == 1);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bqN() {
        this.gfn.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bqO() {
        boolean z = TbadkApplication.getInst().getSkinType() == 1;
        this.gfb.getLayoutMode().setNightMode(z);
        this.gfb.getLayoutMode().onModeChanged(this.mView);
        this.gfn.startLoad(c.a(this.gfb.getActivity(), c.gfi, z), 29, false);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int bqH() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return this.gfb.getPageContext().getString(d.j.group_create_tips_lbs);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String bqQ() {
        return "";
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bqR() {
        return false;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    public Button bqW() {
        return this.gfo;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bqS() {
        return false;
    }
}

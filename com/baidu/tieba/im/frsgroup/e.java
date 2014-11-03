package com.baidu.tieba.im.frsgroup;

import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.frsgroup.FrsGroupBottomView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.mvc.h.b implements com.baidu.adp.widget.ListView.aa {
    private FrsGroupActivity aWW;
    private m aWX;
    private com.baidu.tbadk.mvc.e.a aWY;
    private FrsGroupBottomView aWZ;
    private com.baidu.tbadk.core.view.o aXa;
    private Button aXb;
    private com.baidu.tbadk.mvc.i.c<GroupInfoData, com.baidu.tbadk.mvc.e.c, c> aXc;
    private boolean aXd;
    private boolean aXe;
    private final CustomMessageListener aXf;
    private LinearLayout ayt;
    private BdListView azI;
    private int index;
    private final com.baidu.adp.framework.listener.e mSocketListener;

    public e(FrsGroupActivity frsGroupActivity, int i, BdUniqueId bdUniqueId) {
        super(frsGroupActivity);
        this.mSocketListener = new f(this, 0);
        this.aXf = new g(this, 0);
        this.aWW = frsGroupActivity;
        this.index = i;
        this.unique_id = bdUniqueId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void ti() {
        this.aWW.registerListener(103104, this.mSocketListener);
        this.aWW.registerListener(103105, this.mSocketListener);
        this.aWW.registerListener(2001141, this.aXf);
        this.ayt = (LinearLayout) getView().findViewById(com.baidu.tieba.v.no_data_layout);
        this.azI = (BdListView) getView().findViewById(com.baidu.tieba.v.group_list);
        this.aXc = new com.baidu.tbadk.mvc.i.c<>(sZ(), c.class, com.baidu.tieba.w.im_frsgroup_list_item, null);
        this.aXc.aH(false);
        this.azI.setAdapter((ListAdapter) this.aXc);
        this.aWZ = new FrsGroupBottomView(this.aWW);
        this.azI.setNextPage(this.aWZ);
        this.azI.setOnSrollToBottomListener(this);
        this.azI.setOnItemClickListener(new h(this));
        this.aXb = (Button) getView().findViewById(com.baidu.tieba.v.create_group);
        ta().setViewClickListener(this.aXb, tb().dj(987));
        ug();
        this.aXe = true;
        ta().addEventDelegate(this);
        ub();
        dg(TbadkApplication.m251getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.mvc.h.b
    public BdListView uf() {
        return this.azI;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void nv() {
        super.nv();
        if (this.aXa != null) {
            this.aXa.nv();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void onActivityStop() {
        super.onActivityStop();
        if (this.aXa != null) {
            this.aXa.onActivityStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void tf() {
        super.tf();
        if (this.aXd) {
            aG(true);
        }
    }

    @Override // com.baidu.tbadk.mvc.core.c
    protected int tj() {
        return com.baidu.tieba.w.im_frsgroup_list;
    }

    @Override // com.baidu.tbadk.mvc.h.b, com.baidu.tbadk.mvc.core.c, com.baidu.tbadk.e.a
    public boolean dg(int i) {
        super.dg(i);
        this.azI.setDivider(aw.getDrawable(com.baidu.tieba.u.list_divider));
        com.baidu.tbadk.e.b.u(this.aXb);
        return true;
    }

    private void Nt() {
        if (this.aXa != null && this.aXa.getVisibility() == 0) {
            this.aXa.setVisibility(8);
            this.aXb.setVisibility(8);
        }
    }

    private void cV(boolean z) {
        if (!z) {
            this.azI.setDivider(getResources().getDrawable(17170445));
        } else {
            this.azI.setDivider(aw.getDrawable(com.baidu.tieba.u.list_divider));
        }
    }

    private void fF(int i) {
        if (this.aXa == null) {
            this.aXa = NoDataViewFactory.a(sZ(), this.ayt, com.baidu.tbadk.core.view.r.a(NoDataViewFactory.ImgType.CREATE, (int) getResources().getDimension(com.baidu.tieba.t.ds80)), null, null);
        }
        cV(false);
        this.aXa.nv();
        dg(TbadkApplication.m251getInst().getSkinType());
        switch (i) {
            case 1:
                this.aXa.setTextOption(com.baidu.tbadk.core.view.s.bL(com.baidu.tieba.y.frsgroup_no_recommend_tip));
                this.aXa.setButtonOption(null);
                this.aXa.setVisibility(0);
                this.aXb.setVisibility(0);
                return;
            case 2:
                this.aXa.setTextOption(com.baidu.tbadk.core.view.s.q(com.baidu.tieba.y.frsgroup_no_hot_tip, com.baidu.tieba.y.frsgroup_hot_create_group_tip));
                if (this.aWX != null && this.aWX.getGroupPerm() != null) {
                    this.aXa.setVisibility(0);
                    this.aXb.setVisibility(0);
                    return;
                }
                return;
            case 3:
                this.aXa.setTextOption(com.baidu.tbadk.core.view.s.q(com.baidu.tieba.y.frsgroup_office_no_tip1_leaguer, com.baidu.tieba.y.frsgroup_office_no_tip1_owner));
                this.aXb.setText(getString(com.baidu.tieba.y.frsgroup_official_create_group));
                if (this.aWX != null && this.aWX.getGroupPerm() != null) {
                    this.aXa.setVisibility(0);
                    this.aXb.setVisibility(0);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(long j) {
        List<GroupInfoData> um = this.aXc.um();
        if (um != null) {
            int size = um.size();
            for (int i = 0; i < size; i++) {
                if (um.get(i).getGroupId() == j) {
                    if (isShow()) {
                        Nu();
                        return;
                    } else {
                        this.aXd = true;
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.aa
    public void hQ() {
        if (this.aWY == null || !this.aWY.tY()) {
            de(16777218);
        }
    }

    protected boolean isShow() {
        return getView() != null && getView().getVisibility() == 0;
    }

    private void Nu() {
        this.azI.hO();
        this.aWZ.a(FrsGroupBottomView.BOTTOM_TYPE.LINE);
    }

    @Override // com.baidu.tbadk.mvc.h.a
    protected void b(com.baidu.tbadk.mvc.b.a aVar) {
        if ((aVar instanceof m) && this.aXe) {
            this.aWX = (m) aVar;
            if (this.aWX.getGroups() == null) {
                this.aXc.r(new ArrayList());
                cV(false);
                return;
            }
            this.aXc.r(this.aWX.getGroups());
            if (this.aWX.getGroups().size() == 0) {
                fF(this.index + 1);
                return;
            }
            Nt();
            cV(true);
        }
    }

    @Override // com.baidu.tbadk.mvc.h.a
    protected void b(com.baidu.tbadk.mvc.e.c cVar) {
        if ((cVar instanceof com.baidu.tbadk.mvc.e.a) && this.aXe) {
            this.aWY = (com.baidu.tbadk.mvc.e.a) cVar;
            this.azI.setNextPage(this.aWZ);
            if (this.aWY.tY()) {
                this.aWZ.a(FrsGroupBottomView.BOTTOM_TYPE.HAVE_MORE);
            } else {
                if (this.aWY.tZ()) {
                    this.aWZ.a(FrsGroupBottomView.BOTTOM_TYPE.LINE);
                } else {
                    this.aWZ.a(FrsGroupBottomView.BOTTOM_TYPE.NO_MORE);
                }
                if (this.aXc.um().size() == 0) {
                    this.azI.setNextPage(null);
                }
            }
            if (this.aWY.tX()) {
                uh();
            } else {
                ui();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void a(ErrorData errorData) {
        super.a(errorData);
        if (this.aWY != null) {
            this.aWY.aC(false);
            this.aWY.aD(false);
            b(this.aWY);
        }
    }

    public int fG(int i) {
        switch (i) {
            case 1:
            default:
                return 4;
            case 2:
                return 5;
            case 3:
                return 6;
        }
    }
}

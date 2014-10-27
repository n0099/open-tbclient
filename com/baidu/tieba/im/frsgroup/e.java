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
    private FrsGroupActivity aWI;
    private m aWJ;
    private com.baidu.tbadk.mvc.e.a aWK;
    private FrsGroupBottomView aWL;
    private com.baidu.tbadk.core.view.o aWM;
    private Button aWN;
    private com.baidu.tbadk.mvc.i.c<GroupInfoData, com.baidu.tbadk.mvc.e.c, c> aWO;
    private boolean aWP;
    private boolean aWQ;
    private final CustomMessageListener aWR;
    private LinearLayout ayk;
    private BdListView azz;
    private int index;
    private final com.baidu.adp.framework.listener.e mSocketListener;

    public e(FrsGroupActivity frsGroupActivity, int i, BdUniqueId bdUniqueId) {
        super(frsGroupActivity);
        this.mSocketListener = new f(this, 0);
        this.aWR = new g(this, 0);
        this.aWI = frsGroupActivity;
        this.index = i;
        this.unique_id = bdUniqueId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void tg() {
        this.aWI.registerListener(103104, this.mSocketListener);
        this.aWI.registerListener(103105, this.mSocketListener);
        this.aWI.registerListener(2001141, this.aWR);
        this.ayk = (LinearLayout) getView().findViewById(com.baidu.tieba.v.no_data_layout);
        this.azz = (BdListView) getView().findViewById(com.baidu.tieba.v.group_list);
        this.aWO = new com.baidu.tbadk.mvc.i.c<>(sX(), c.class, com.baidu.tieba.w.im_frsgroup_list_item, null);
        this.aWO.aH(false);
        this.azz.setAdapter((ListAdapter) this.aWO);
        this.aWL = new FrsGroupBottomView(this.aWI);
        this.azz.setNextPage(this.aWL);
        this.azz.setOnSrollToBottomListener(this);
        this.azz.setOnItemClickListener(new h(this));
        this.aWN = (Button) getView().findViewById(com.baidu.tieba.v.create_group);
        sY().setViewClickListener(this.aWN, sZ().dj(987));
        ue();
        this.aWQ = true;
        sY().addEventDelegate(this);
        tZ();
        dg(TbadkApplication.m251getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.mvc.h.b
    public BdListView ud() {
        return this.azz;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void nv() {
        super.nv();
        if (this.aWM != null) {
            this.aWM.nv();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void onActivityStop() {
        super.onActivityStop();
        if (this.aWM != null) {
            this.aWM.onActivityStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void td() {
        super.td();
        if (this.aWP) {
            aG(true);
        }
    }

    @Override // com.baidu.tbadk.mvc.core.c
    protected int th() {
        return com.baidu.tieba.w.im_frsgroup_list;
    }

    @Override // com.baidu.tbadk.mvc.h.b, com.baidu.tbadk.mvc.core.c, com.baidu.tbadk.e.a
    public boolean dg(int i) {
        super.dg(i);
        this.azz.setDivider(aw.getDrawable(com.baidu.tieba.u.list_divider));
        com.baidu.tbadk.e.b.u(this.aWN);
        return true;
    }

    private void Np() {
        if (this.aWM != null && this.aWM.getVisibility() == 0) {
            this.aWM.setVisibility(8);
            this.aWN.setVisibility(8);
        }
    }

    private void cV(boolean z) {
        if (!z) {
            this.azz.setDivider(getResources().getDrawable(17170445));
        } else {
            this.azz.setDivider(aw.getDrawable(com.baidu.tieba.u.list_divider));
        }
    }

    private void fF(int i) {
        if (this.aWM == null) {
            this.aWM = NoDataViewFactory.a(sX(), this.ayk, com.baidu.tbadk.core.view.r.a(NoDataViewFactory.ImgType.CREATE, (int) getResources().getDimension(com.baidu.tieba.t.ds80)), null, null);
        }
        cV(false);
        this.aWM.nv();
        dg(TbadkApplication.m251getInst().getSkinType());
        switch (i) {
            case 1:
                this.aWM.setTextOption(com.baidu.tbadk.core.view.s.bL(com.baidu.tieba.y.frsgroup_no_recommend_tip));
                this.aWM.setButtonOption(null);
                this.aWM.setVisibility(0);
                this.aWN.setVisibility(0);
                return;
            case 2:
                this.aWM.setTextOption(com.baidu.tbadk.core.view.s.q(com.baidu.tieba.y.frsgroup_no_hot_tip, com.baidu.tieba.y.frsgroup_hot_create_group_tip));
                if (this.aWJ != null && this.aWJ.getGroupPerm() != null) {
                    this.aWM.setVisibility(0);
                    this.aWN.setVisibility(0);
                    return;
                }
                return;
            case 3:
                this.aWM.setTextOption(com.baidu.tbadk.core.view.s.q(com.baidu.tieba.y.frsgroup_office_no_tip1_leaguer, com.baidu.tieba.y.frsgroup_office_no_tip1_owner));
                this.aWN.setText(getString(com.baidu.tieba.y.frsgroup_official_create_group));
                if (this.aWJ != null && this.aWJ.getGroupPerm() != null) {
                    this.aWM.setVisibility(0);
                    this.aWN.setVisibility(0);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(long j) {
        List<GroupInfoData> uk = this.aWO.uk();
        if (uk != null) {
            int size = uk.size();
            for (int i = 0; i < size; i++) {
                if (uk.get(i).getGroupId() == j) {
                    if (isShow()) {
                        Nq();
                        return;
                    } else {
                        this.aWP = true;
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.aa
    public void hQ() {
        if (this.aWK == null || !this.aWK.tW()) {
            de(16777218);
        }
    }

    protected boolean isShow() {
        return getView() != null && getView().getVisibility() == 0;
    }

    private void Nq() {
        this.azz.hO();
        this.aWL.a(FrsGroupBottomView.BOTTOM_TYPE.LINE);
    }

    @Override // com.baidu.tbadk.mvc.h.a
    protected void b(com.baidu.tbadk.mvc.b.a aVar) {
        if ((aVar instanceof m) && this.aWQ) {
            this.aWJ = (m) aVar;
            if (this.aWJ.getGroups() == null) {
                this.aWO.r(new ArrayList());
                cV(false);
                return;
            }
            this.aWO.r(this.aWJ.getGroups());
            if (this.aWJ.getGroups().size() == 0) {
                fF(this.index + 1);
                return;
            }
            Np();
            cV(true);
        }
    }

    @Override // com.baidu.tbadk.mvc.h.a
    protected void b(com.baidu.tbadk.mvc.e.c cVar) {
        if ((cVar instanceof com.baidu.tbadk.mvc.e.a) && this.aWQ) {
            this.aWK = (com.baidu.tbadk.mvc.e.a) cVar;
            this.azz.setNextPage(this.aWL);
            if (this.aWK.tW()) {
                this.aWL.a(FrsGroupBottomView.BOTTOM_TYPE.HAVE_MORE);
            } else {
                if (this.aWK.tX()) {
                    this.aWL.a(FrsGroupBottomView.BOTTOM_TYPE.LINE);
                } else {
                    this.aWL.a(FrsGroupBottomView.BOTTOM_TYPE.NO_MORE);
                }
                if (this.aWO.uk().size() == 0) {
                    this.azz.setNextPage(null);
                }
            }
            if (this.aWK.tV()) {
                uf();
            } else {
                ug();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void a(ErrorData errorData) {
        super.a(errorData);
        if (this.aWK != null) {
            this.aWK.aC(false);
            this.aWK.aD(false);
            b(this.aWK);
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

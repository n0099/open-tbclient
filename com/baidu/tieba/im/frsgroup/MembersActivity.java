package com.baidu.tieba.im.frsgroup;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.data.UserData;
import com.baidu.tieba.im.model.MembersModel;
import com.baidu.tieba.im.util.DialogUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class MembersActivity extends BaseActivity implements View.OnClickListener, AbsListView.OnScrollListener, com.baidu.adp.widget.ListView.aa {
    private ah aXJ;
    private MembersModel aXK;
    private com.baidu.tbadk.core.view.y ayp;
    private final com.baidu.adp.framework.listener.e ayJ = new r(this, 103005);
    private final com.baidu.adp.framework.listener.e aXL = new t(this, 103112);
    private final CustomMessageListener aXM = new u(this, 0);

    public static void a(Context context, long j) {
        Intent intent = new Intent(context, MembersActivity.class);
        intent.putExtra("group_id", j);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        HJ();
        d(bundle);
        initUI();
        startLoading();
    }

    private void HJ() {
        registerListener(2001132, this.aXM);
        registerListener(2001130, this.aXM);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.aXK.saveInstance(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.aXJ.NN().onActivityStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public MembersModel NB() {
        return this.aXK;
    }

    private void initUI() {
        this.aXJ = new ah(this);
        BdListView ER = this.aXJ.ER();
        this.ayp = new com.baidu.tbadk.core.view.y(this);
        this.ayp.a(new v(this, ER));
        ER.setPullRefresh(this.ayp);
        ER.setOnScrollListener(this);
        ER.setOnSrollToBottomListener(this);
        ER.setOnItemClickListener(new w(this));
        ER.setOnItemLongClickListener(new x(this));
        this.aXJ.NK().setOnClickListener(this);
        this.aXJ.NL().setOnClickListener(this);
        this.aXJ.NM().setOnClickListener(this);
        this.aXJ.setController(false);
        this.aXJ.NO().a(new aa(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, List<Long> list) {
        if (list != null && list.size() != 0) {
            this.aXJ.da(true);
            this.aXK.setUserIds(list);
            this.aXK.sendRemoveMessage(j, V(list));
        }
    }

    private String V(List<Long> list) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Long l : list) {
            stringBuffer.append(l).append(",");
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        return stringBuffer.toString();
    }

    private void startLoading() {
        this.aXK.setUseCache(false);
        this.aXK.setRequestM(null);
        this.aXJ.NO().bM(true);
        this.aXK.setStart(0);
        this.aXK.setLen(50);
        this.aXJ.ER().hO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.aXK.setUseCache(true);
        this.aXK.setRequestM(null);
        this.aXJ.NO().bM(false);
        this.aXK.setStart(0);
        this.aXK.setLen(50);
        this.aXJ.ER().hO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideProgress() {
        if (isFirstLoad()) {
            this.aXJ.hideProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFirstLoad() {
        return 50 == this.aXK.getLen();
    }

    public void d(Bundle bundle) {
        this.aXK = new MembersModel(this);
        this.aXK.setUniqueId(getUniqueId());
        if (bundle == null) {
            this.aXK.initWithIntent(getIntent());
        } else {
            this.aXK.initWithBundle(bundle);
        }
        registerListener(this.ayJ);
        registerListener(this.aXL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserData.Permission permission) {
        if (permission != null) {
            boolean isController = permission.isController();
            this.aXK.setController(isController);
            this.aXJ.setController(isController);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NC() {
        this.aXJ.NN().nv();
        this.aXJ.NN().setTextOption(com.baidu.tbadk.core.view.s.bL(com.baidu.tieba.y.members_no_person));
        this.aXJ.NN().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.aXJ.onChangeSkinType(i);
        this.ayp.bM(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aXJ.NQ()) {
            ND();
        } else if (view == this.aXJ.NK()) {
            NF();
            this.aXJ.dc(false);
        } else if (view == this.aXJ.NL()) {
            NE();
            this.aXJ.dc(true);
        } else if (view == this.aXJ.NM()) {
            NG();
        }
    }

    private void ND() {
        DialogUtil.orderMembers(this, new ab(this));
    }

    private void NE() {
        this.aXJ.fJ(0);
        this.aXJ.db(false);
        this.aXJ.NO().cZ(false);
        this.aXJ.NO().NH();
        this.aXJ.NP();
    }

    private void NF() {
        this.aXJ.fJ(0);
        this.aXJ.db(true);
        this.aXJ.NO().cZ(true);
        this.aXJ.NP();
    }

    private void NG() {
        Set<Long> NI = this.aXJ.NO().NI();
        if (NI.size() > 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(NI);
            DialogUtil.removeMembersDialog(this, new ac(this, arrayList), new s(this));
        }
    }

    private void Eh() {
        if (this.aXJ.NO().EJ()) {
            this.aXK.sendMessage(this.aXK.getGroupId(), this.aXK.getStart(), this.aXK.getLen(), this.aXK.getOrderType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.adp.widget.ListView.aa
    public void hQ() {
        Eh();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.aXJ.ER();
    }
}

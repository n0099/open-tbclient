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
    private ah aXX;
    private MembersModel aXY;
    private com.baidu.tbadk.core.view.y ayy;
    private final com.baidu.adp.framework.listener.e ayS = new r(this, 103005);
    private final com.baidu.adp.framework.listener.e aXZ = new t(this, 103112);
    private final CustomMessageListener aYa = new u(this, 0);

    public static void a(Context context, long j) {
        Intent intent = new Intent(context, MembersActivity.class);
        intent.putExtra("group_id", j);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        HN();
        d(bundle);
        initUI();
        startLoading();
    }

    private void HN() {
        registerListener(2001132, this.aYa);
        registerListener(2001130, this.aYa);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.aXY.saveInstance(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.aXX.NR().onActivityStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public MembersModel NF() {
        return this.aXY;
    }

    private void initUI() {
        this.aXX = new ah(this);
        BdListView ET = this.aXX.ET();
        this.ayy = new com.baidu.tbadk.core.view.y(this);
        this.ayy.a(new v(this, ET));
        ET.setPullRefresh(this.ayy);
        ET.setOnScrollListener(this);
        ET.setOnSrollToBottomListener(this);
        ET.setOnItemClickListener(new w(this));
        ET.setOnItemLongClickListener(new x(this));
        this.aXX.NO().setOnClickListener(this);
        this.aXX.NP().setOnClickListener(this);
        this.aXX.NQ().setOnClickListener(this);
        this.aXX.setController(false);
        this.aXX.NS().a(new aa(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, List<Long> list) {
        if (list != null && list.size() != 0) {
            this.aXX.da(true);
            this.aXY.setUserIds(list);
            this.aXY.sendRemoveMessage(j, V(list));
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
        this.aXY.setUseCache(false);
        this.aXY.setRequestM(null);
        this.aXX.NS().bM(true);
        this.aXY.setStart(0);
        this.aXY.setLen(50);
        this.aXX.ET().hO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.aXY.setUseCache(true);
        this.aXY.setRequestM(null);
        this.aXX.NS().bM(false);
        this.aXY.setStart(0);
        this.aXY.setLen(50);
        this.aXX.ET().hO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideProgress() {
        if (isFirstLoad()) {
            this.aXX.hideProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFirstLoad() {
        return 50 == this.aXY.getLen();
    }

    public void d(Bundle bundle) {
        this.aXY = new MembersModel(this);
        this.aXY.setUniqueId(getUniqueId());
        if (bundle == null) {
            this.aXY.initWithIntent(getIntent());
        } else {
            this.aXY.initWithBundle(bundle);
        }
        registerListener(this.ayS);
        registerListener(this.aXZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserData.Permission permission) {
        if (permission != null) {
            boolean isController = permission.isController();
            this.aXY.setController(isController);
            this.aXX.setController(isController);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NG() {
        this.aXX.NR().nv();
        this.aXX.NR().setTextOption(com.baidu.tbadk.core.view.s.bL(com.baidu.tieba.y.members_no_person));
        this.aXX.NR().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.aXX.onChangeSkinType(i);
        this.ayy.bM(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aXX.NU()) {
            NH();
        } else if (view == this.aXX.NO()) {
            NJ();
            this.aXX.dc(false);
        } else if (view == this.aXX.NP()) {
            NI();
            this.aXX.dc(true);
        } else if (view == this.aXX.NQ()) {
            NK();
        }
    }

    private void NH() {
        DialogUtil.orderMembers(this, new ab(this));
    }

    private void NI() {
        this.aXX.fJ(0);
        this.aXX.db(false);
        this.aXX.NS().cZ(false);
        this.aXX.NS().NL();
        this.aXX.NT();
    }

    private void NJ() {
        this.aXX.fJ(0);
        this.aXX.db(true);
        this.aXX.NS().cZ(true);
        this.aXX.NT();
    }

    private void NK() {
        Set<Long> NM = this.aXX.NS().NM();
        if (NM.size() > 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(NM);
            DialogUtil.removeMembersDialog(this, new ac(this, arrayList), new s(this));
        }
    }

    private void Ej() {
        if (this.aXX.NS().EL()) {
            this.aXY.sendMessage(this.aXY.getGroupId(), this.aXY.getStart(), this.aXY.getLen(), this.aXY.getOrderType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.adp.widget.ListView.aa
    public void hQ() {
        Ej();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.aXX.ET();
    }
}

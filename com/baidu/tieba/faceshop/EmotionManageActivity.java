package com.baidu.tieba.faceshop;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class EmotionManageActivity extends BaseActivity {
    private View Jt;
    private TextView aes;
    private List<s> asD;
    private t asF;
    private q asG;
    private LinearLayout asH;
    private NavigationBar asI;
    private TextView asJ;
    private ImageView asK;
    private BdListView asL;
    private TextView asM;
    private View asN;
    private r asO;
    private TextView mNotice;
    private final List<String> asE = new LinkedList();
    private boolean asP = false;
    private final View.OnClickListener mOnClickListener = new n(this);
    private final AdapterView.OnItemClickListener uI = new o(this);
    private final CustomMessageListener Sg = new p(this, 0);

    public static void S(Context context) {
        context.startActivity(new Intent(context, EmotionManageActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(ca.activity_emotion_manage);
        nu();
        initData();
        bC(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.asG != null) {
            this.asG.cancel(true);
            this.asG = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.asI.onChangeSkinType(i);
        com.baidu.tbadk.core.util.aw.h((View) this.asJ, by.navi_del_text_bg);
    }

    private void nu() {
        this.asH = (LinearLayout) findViewById(bz.emotion_manage_root);
        this.asI = (NavigationBar) findViewById(bz.view_navigation_bar);
        this.asI.setTitleText(cb.title_activity_emotion_manage);
        this.Jt = this.asI.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.asJ = this.asI.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, String.valueOf(getString(cb.delete)) + "(" + this.asE.size() + ")", this.mOnClickListener);
        CO();
        this.aes = this.asI.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(cb.edit), this.mOnClickListener);
        this.mNotice = (TextView) findViewById(bz.emotion_manager_title);
        this.asK = (ImageView) findViewById(bz.emotion_manage_enter_line_list_up);
        this.asL = (BdListView) findViewById(bz.emotion_manage_list);
        this.asL.setOnItemClickListener(this.uI);
        this.asN = com.baidu.adp.lib.g.b.ek().inflate(this, ca.emotion_manage_list_footer, null);
        this.asL.addFooterView(this.asN);
        this.asM = (TextView) this.asN.findViewById(bz.emotion_manage_enter_record);
        this.asM.setOnClickListener(this.mOnClickListener);
        getLayoutMode().L(TbadkApplication.m251getInst().getSkinType() == 1);
        getLayoutMode().h(this.asH);
        getLayoutMode().h(this.asN);
        CN();
    }

    private void initData() {
        registerListener(2001120, this.Sg);
        this.asF = new t(this, null);
        this.asF.execute(new String[0]);
        this.asO = new r(this, null);
        this.asL.setAdapter((ListAdapter) this.asO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bC(boolean z) {
        boolean z2;
        if (z) {
            this.asE.clear();
        } else {
            for (String str : this.asE) {
                Iterator<s> it = this.asD.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z2 = false;
                        break;
                    } else if (str.equals(it.next().id)) {
                        z2 = true;
                        break;
                    }
                }
                if (!z2) {
                    this.asE.remove(str);
                }
            }
        }
        CO();
        CL();
        this.asO.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CL() {
        if (this.asD != null) {
            if (this.asD.size() == 0) {
                this.mNotice.setText(cb.emotion_manage_title_nodata);
                this.aes.setEnabled(false);
                this.asK.setVisibility(8);
                CN();
                return;
            }
            this.mNotice.setText(cb.emotion_manage_title);
            this.aes.setEnabled(true);
            this.asK.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eM(String str) {
        if (!this.asE.contains(str)) {
            this.asE.add(str);
            CO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eN(String str) {
        this.asE.remove(str);
        CO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CM() {
        this.Jt.setVisibility(8);
        this.asJ.setVisibility(0);
        CO();
        this.aes.setText(getString(cb.cancel));
        this.asP = true;
        this.asN.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CN() {
        this.Jt.setVisibility(0);
        this.asJ.setVisibility(8);
        this.aes.setText(getString(cb.edit));
        this.asP = false;
        this.asN.setVisibility(0);
    }

    private void CO() {
        int size = this.asE.size();
        TbadkApplication.m251getInst().getSkinType();
        this.asJ.setText(String.valueOf(getString(cb.delete)) + "(" + size + ")");
        if (size == 0) {
            this.asJ.setEnabled(false);
            com.baidu.tbadk.core.util.aw.b(this.asJ, bw.emotion_manage_del_disable, 1);
            return;
        }
        this.asJ.setEnabled(true);
        com.baidu.tbadk.core.util.aw.b(this.asJ, bw.emotion_manage_del_enable, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CP() {
        this.asG = new q(this, null);
        this.asG.execute(this.asE);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.asP) {
            CN();
            this.asE.clear();
            this.asP = false;
            this.asO.notifyDataSetChanged();
            return;
        }
        super.onBackPressed();
    }
}

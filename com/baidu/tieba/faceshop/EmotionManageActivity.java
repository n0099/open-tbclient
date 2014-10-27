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
    private View Js;
    private TextView aek;
    private TextView asA;
    private ImageView asB;
    private BdListView asC;
    private TextView asD;
    private View asE;
    private r asF;
    private List<s> asu;
    private t asw;
    private q asx;
    private LinearLayout asy;
    private NavigationBar asz;
    private TextView mNotice;
    private final List<String> asv = new LinkedList();
    private boolean asG = false;
    private final View.OnClickListener mOnClickListener = new n(this);
    private final AdapterView.OnItemClickListener uI = new o(this);
    private final CustomMessageListener Sc = new p(this, 0);

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
        if (this.asx != null) {
            this.asx.cancel(true);
            this.asx = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.asz.onChangeSkinType(i);
        com.baidu.tbadk.core.util.aw.h((View) this.asA, by.navi_del_text_bg);
    }

    private void nu() {
        this.asy = (LinearLayout) findViewById(bz.emotion_manage_root);
        this.asz = (NavigationBar) findViewById(bz.view_navigation_bar);
        this.asz.setTitleText(cb.title_activity_emotion_manage);
        this.Js = this.asz.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.asA = this.asz.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, String.valueOf(getString(cb.delete)) + "(" + this.asv.size() + ")", this.mOnClickListener);
        CM();
        this.aek = this.asz.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(cb.edit), this.mOnClickListener);
        this.mNotice = (TextView) findViewById(bz.emotion_manager_title);
        this.asB = (ImageView) findViewById(bz.emotion_manage_enter_line_list_up);
        this.asC = (BdListView) findViewById(bz.emotion_manage_list);
        this.asC.setOnItemClickListener(this.uI);
        this.asE = com.baidu.adp.lib.g.b.ek().inflate(this, ca.emotion_manage_list_footer, null);
        this.asC.addFooterView(this.asE);
        this.asD = (TextView) this.asE.findViewById(bz.emotion_manage_enter_record);
        this.asD.setOnClickListener(this.mOnClickListener);
        getLayoutMode().L(TbadkApplication.m251getInst().getSkinType() == 1);
        getLayoutMode().h(this.asy);
        getLayoutMode().h(this.asE);
        CL();
    }

    private void initData() {
        registerListener(2001120, this.Sc);
        this.asw = new t(this, null);
        this.asw.execute(new String[0]);
        this.asF = new r(this, null);
        this.asC.setAdapter((ListAdapter) this.asF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bC(boolean z) {
        boolean z2;
        if (z) {
            this.asv.clear();
        } else {
            for (String str : this.asv) {
                Iterator<s> it = this.asu.iterator();
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
                    this.asv.remove(str);
                }
            }
        }
        CM();
        CJ();
        this.asF.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CJ() {
        if (this.asu != null) {
            if (this.asu.size() == 0) {
                this.mNotice.setText(cb.emotion_manage_title_nodata);
                this.aek.setEnabled(false);
                this.asB.setVisibility(8);
                CL();
                return;
            }
            this.mNotice.setText(cb.emotion_manage_title);
            this.aek.setEnabled(true);
            this.asB.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eM(String str) {
        if (!this.asv.contains(str)) {
            this.asv.add(str);
            CM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eN(String str) {
        this.asv.remove(str);
        CM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CK() {
        this.Js.setVisibility(8);
        this.asA.setVisibility(0);
        CM();
        this.aek.setText(getString(cb.cancel));
        this.asG = true;
        this.asE.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CL() {
        this.Js.setVisibility(0);
        this.asA.setVisibility(8);
        this.aek.setText(getString(cb.edit));
        this.asG = false;
        this.asE.setVisibility(0);
    }

    private void CM() {
        int size = this.asv.size();
        TbadkApplication.m251getInst().getSkinType();
        this.asA.setText(String.valueOf(getString(cb.delete)) + "(" + size + ")");
        if (size == 0) {
            this.asA.setEnabled(false);
            com.baidu.tbadk.core.util.aw.b(this.asA, bw.emotion_manage_del_disable, 1);
            return;
        }
        this.asA.setEnabled(true);
        com.baidu.tbadk.core.util.aw.b(this.asA, bw.emotion_manage_del_enable, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CN() {
        this.asx = new q(this, null);
        this.asx.execute(this.asv);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.asG) {
            CL();
            this.asv.clear();
            this.asG = false;
            this.asF.notifyDataSetChanged();
            return;
        }
        super.onBackPressed();
    }
}

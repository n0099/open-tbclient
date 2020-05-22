package com.baidu.tieba.ala.alasquare.live.c;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.recent_history.AlaRecentHistoryActivity;
import java.util.List;
import tbclient.LiveSquare.FunctionListInfo;
/* loaded from: classes3.dex */
public class a {
    private TextView eUO;
    private LinearLayout faZ;
    private LinearLayout fba;
    private ImageView fbb;
    private TextView fbc;
    private LinearLayout fbd;
    private ImageView fbe;
    private TextView fbf;
    private TextView fbg;
    private View fbh;
    private LinearLayout fbi;
    private ImageView fbj;
    private TextView fbk;
    private TextView fbl;
    private View fbm;
    private View fbn;
    private Context mContext;
    private List<FunctionListInfo> mData;
    private View mRootView;
    private int mSkinType = 3;

    public a(TbPageContext tbPageContext) {
        this.mContext = tbPageContext.getPageActivity();
        initUI();
    }

    private void initUI() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.square_live_function_region_layout, (ViewGroup) null);
        this.faZ = (LinearLayout) this.mRootView.findViewById(R.id.square_function_container);
        this.fba = (LinearLayout) this.mRootView.findViewById(R.id.square_function_rank);
        this.fba.setVisibility(8);
        this.fbb = (ImageView) this.mRootView.findViewById(R.id.square_function_rank_img);
        this.eUO = (TextView) this.mRootView.findViewById(R.id.square_function_rank_title);
        this.fbc = (TextView) this.mRootView.findViewById(R.id.square_function_rank_desc);
        this.fbd = (LinearLayout) this.mRootView.findViewById(R.id.square_function_history);
        this.fbd.setVisibility(8);
        this.fbe = (ImageView) this.mRootView.findViewById(R.id.square_function_history_img);
        this.fbf = (TextView) this.mRootView.findViewById(R.id.square_function_history_title);
        this.fbg = (TextView) this.mRootView.findViewById(R.id.square_function_history_desc);
        this.fbh = this.mRootView.findViewById(R.id.square_function_history_red_pointer);
        this.fbi = (LinearLayout) this.mRootView.findViewById(R.id.square_function_activity);
        this.fbi.setVisibility(8);
        this.fbj = (ImageView) this.mRootView.findViewById(R.id.square_function_activity_img);
        this.fbk = (TextView) this.mRootView.findViewById(R.id.square_function_activity_title);
        this.fbl = (TextView) this.mRootView.findViewById(R.id.square_function_activity_desc);
        this.fbm = this.mRootView.findViewById(R.id.square_function_activity_red_pointer);
        this.fbn = this.mRootView.findViewById(R.id.square_function_bottom_space);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void bk(List<FunctionListInfo> list) {
        this.mData = list;
        for (final FunctionListInfo functionListInfo : this.mData) {
            if (functionListInfo != null) {
                switch (functionListInfo.id.intValue()) {
                    case 1:
                        this.fba.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.eUO.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.fbc.setVisibility(0);
                            this.fbc.setText(functionListInfo.describe);
                        }
                        this.fba.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                a.this.aA(1, functionListInfo.url);
                            }
                        });
                        continue;
                    case 2:
                        this.fbd.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.fbf.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.fbg.setVisibility(0);
                            this.fbg.setText(functionListInfo.describe);
                        }
                        a(functionListInfo.id.intValue(), functionListInfo.update_time.longValue(), this.fbh);
                        this.fbd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (!TbadkCoreApplication.isLogin()) {
                                    bc.skipToLoginActivity(a.this.mContext);
                                    return;
                                }
                                a.this.a("prefer_key_history", a.this.fbh);
                                a.this.mContext.startActivity(new Intent(a.this.mContext, AlaRecentHistoryActivity.class));
                                TiebaStatic.log("c12648");
                            }
                        });
                        continue;
                    case 3:
                        this.fbi.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.fbk.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.fbl.setVisibility(0);
                            this.fbl.setText(functionListInfo.describe);
                        }
                        a(functionListInfo.id.intValue(), functionListInfo.update_time.longValue(), this.fbm);
                        this.fbi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                a.this.aA(3, functionListInfo.url);
                                a.this.a("prefer_key_activity", a.this.fbm);
                            }
                        });
                        continue;
                }
            }
        }
        TiebaStatic.log("c12647");
    }

    public View getView() {
        return this.mRootView;
    }

    private void a(int i, long j, View view) {
        String str = null;
        switch (i) {
            case 2:
                str = "prefer_key_history";
                break;
            case 3:
                str = "prefer_key_activity";
                break;
        }
        if (AV(str) < j) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, View view) {
        b.aTX().putLong(str, System.currentTimeMillis() / 1000);
        view.setVisibility(8);
    }

    private long AV(String str) {
        return b.aTX().getLong(str, 0L);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setBackgroundResource(this.faZ, R.color.cp_bg_line_d);
            am.setImageResource(this.fbb, R.drawable.live_portal_rank);
            am.setViewTextColor(this.eUO, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.fbc, (int) R.color.cp_cont_d);
            am.setImageResource(this.fbe, R.drawable.live_import_history);
            am.setViewTextColor(this.fbf, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.fbg, (int) R.color.cp_cont_d);
            am.setImageResource(this.fbj, R.drawable.live_import_activity);
            am.setViewTextColor(this.fbk, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.fbl, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.fbn, R.color.cp_bg_line_e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aA(int i, String str) {
        TiebaStatic.log(new an("c12215"));
        com.baidu.tbadk.browser.a.startWebActivity(this.mContext, str);
        if (3 == i) {
            TiebaStatic.log("c12649");
        } else if (1 == i) {
            TiebaStatic.log("c12215");
        }
    }

    public void onDestroy() {
    }
}

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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.recent_history.AlaRecentHistoryActivity;
import java.util.List;
import tbclient.LiveSquare.FunctionListInfo;
/* loaded from: classes3.dex */
public class a {
    private TextView ffk;
    private TextView fmA;
    private TextView fmB;
    private View fmC;
    private LinearLayout fmD;
    private ImageView fmE;
    private TextView fmF;
    private TextView fmG;
    private View fmH;
    private View fmI;
    private LinearLayout fmu;
    private LinearLayout fmv;
    private ImageView fmw;
    private TextView fmx;
    private LinearLayout fmy;
    private ImageView fmz;
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
        this.fmu = (LinearLayout) this.mRootView.findViewById(R.id.square_function_container);
        this.fmv = (LinearLayout) this.mRootView.findViewById(R.id.square_function_rank);
        this.fmv.setVisibility(8);
        this.fmw = (ImageView) this.mRootView.findViewById(R.id.square_function_rank_img);
        this.ffk = (TextView) this.mRootView.findViewById(R.id.square_function_rank_title);
        this.fmx = (TextView) this.mRootView.findViewById(R.id.square_function_rank_desc);
        this.fmy = (LinearLayout) this.mRootView.findViewById(R.id.square_function_history);
        this.fmy.setVisibility(8);
        this.fmz = (ImageView) this.mRootView.findViewById(R.id.square_function_history_img);
        this.fmA = (TextView) this.mRootView.findViewById(R.id.square_function_history_title);
        this.fmB = (TextView) this.mRootView.findViewById(R.id.square_function_history_desc);
        this.fmC = this.mRootView.findViewById(R.id.square_function_history_red_pointer);
        this.fmD = (LinearLayout) this.mRootView.findViewById(R.id.square_function_activity);
        this.fmD.setVisibility(8);
        this.fmE = (ImageView) this.mRootView.findViewById(R.id.square_function_activity_img);
        this.fmF = (TextView) this.mRootView.findViewById(R.id.square_function_activity_title);
        this.fmG = (TextView) this.mRootView.findViewById(R.id.square_function_activity_desc);
        this.fmH = this.mRootView.findViewById(R.id.square_function_activity_red_pointer);
        this.fmI = this.mRootView.findViewById(R.id.square_function_bottom_space);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void aP(List<FunctionListInfo> list) {
        this.mData = list;
        for (final FunctionListInfo functionListInfo : this.mData) {
            if (functionListInfo != null) {
                switch (functionListInfo.id.intValue()) {
                    case 1:
                        this.fmv.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.ffk.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.fmx.setVisibility(0);
                            this.fmx.setText(functionListInfo.describe);
                        }
                        this.fmv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                a.this.aC(1, functionListInfo.url);
                            }
                        });
                        continue;
                    case 2:
                        this.fmy.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.fmA.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.fmB.setVisibility(0);
                            this.fmB.setText(functionListInfo.describe);
                        }
                        a(functionListInfo.id.intValue(), functionListInfo.update_time.longValue(), this.fmC);
                        this.fmy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (!TbadkCoreApplication.isLogin()) {
                                    be.skipToLoginActivity(a.this.mContext);
                                    return;
                                }
                                a.this.a("prefer_key_history", a.this.fmC);
                                a.this.mContext.startActivity(new Intent(a.this.mContext, AlaRecentHistoryActivity.class));
                                TiebaStatic.log("c12648");
                            }
                        });
                        continue;
                    case 3:
                        this.fmD.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.fmF.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.fmG.setVisibility(0);
                            this.fmG.setText(functionListInfo.describe);
                        }
                        a(functionListInfo.id.intValue(), functionListInfo.update_time.longValue(), this.fmH);
                        this.fmD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                a.this.aC(3, functionListInfo.url);
                                a.this.a("prefer_key_activity", a.this.fmH);
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
        if (Bu(str) < j) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, View view) {
        b.aVP().putLong(str, System.currentTimeMillis() / 1000);
        view.setVisibility(8);
    }

    private long Bu(String str) {
        return b.aVP().getLong(str, 0L);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            an.setBackgroundResource(this.fmu, R.color.cp_bg_line_d);
            an.setImageResource(this.fmw, R.drawable.live_portal_rank);
            an.setViewTextColor(this.ffk, (int) R.color.cp_cont_b);
            an.setViewTextColor(this.fmx, (int) R.color.cp_cont_d);
            an.setImageResource(this.fmz, R.drawable.live_import_history);
            an.setViewTextColor(this.fmA, (int) R.color.cp_cont_b);
            an.setViewTextColor(this.fmB, (int) R.color.cp_cont_d);
            an.setImageResource(this.fmE, R.drawable.live_import_activity);
            an.setViewTextColor(this.fmF, (int) R.color.cp_cont_b);
            an.setViewTextColor(this.fmG, (int) R.color.cp_cont_d);
            an.setBackgroundResource(this.fmI, R.color.cp_bg_line_e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aC(int i, String str) {
        TiebaStatic.log(new ao("c12215"));
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

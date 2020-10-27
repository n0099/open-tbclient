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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.recent_history.AlaRecentHistoryActivity;
import java.util.List;
import tbclient.LiveSquare.FunctionListInfo;
/* loaded from: classes4.dex */
public class a {
    private TextView fTy;
    private LinearLayout gcA;
    private LinearLayout gcB;
    private ImageView gcC;
    private TextView gcD;
    private LinearLayout gcE;
    private ImageView gcF;
    private TextView gcG;
    private TextView gcH;
    private View gcI;
    private LinearLayout gcJ;
    private ImageView gcK;
    private TextView gcL;
    private TextView gcM;
    private View gcN;
    private View gcO;
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
        this.gcA = (LinearLayout) this.mRootView.findViewById(R.id.square_function_container);
        this.gcB = (LinearLayout) this.mRootView.findViewById(R.id.square_function_rank);
        this.gcB.setVisibility(8);
        this.gcC = (ImageView) this.mRootView.findViewById(R.id.square_function_rank_img);
        this.fTy = (TextView) this.mRootView.findViewById(R.id.square_function_rank_title);
        this.gcD = (TextView) this.mRootView.findViewById(R.id.square_function_rank_desc);
        this.gcE = (LinearLayout) this.mRootView.findViewById(R.id.square_function_history);
        this.gcE.setVisibility(8);
        this.gcF = (ImageView) this.mRootView.findViewById(R.id.square_function_history_img);
        this.gcG = (TextView) this.mRootView.findViewById(R.id.square_function_history_title);
        this.gcH = (TextView) this.mRootView.findViewById(R.id.square_function_history_desc);
        this.gcI = this.mRootView.findViewById(R.id.square_function_history_red_pointer);
        this.gcJ = (LinearLayout) this.mRootView.findViewById(R.id.square_function_activity);
        this.gcJ.setVisibility(8);
        this.gcK = (ImageView) this.mRootView.findViewById(R.id.square_function_activity_img);
        this.gcL = (TextView) this.mRootView.findViewById(R.id.square_function_activity_title);
        this.gcM = (TextView) this.mRootView.findViewById(R.id.square_function_activity_desc);
        this.gcN = this.mRootView.findViewById(R.id.square_function_activity_red_pointer);
        this.gcO = this.mRootView.findViewById(R.id.square_function_bottom_space);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void bQ(List<FunctionListInfo> list) {
        this.mData = list;
        for (final FunctionListInfo functionListInfo : this.mData) {
            if (functionListInfo != null) {
                switch (functionListInfo.id.intValue()) {
                    case 1:
                        this.gcB.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.fTy.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.gcD.setVisibility(0);
                            this.gcD.setText(functionListInfo.describe);
                        }
                        this.gcB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                a.this.aO(1, functionListInfo.url);
                            }
                        });
                        continue;
                    case 2:
                        this.gcE.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.gcG.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.gcH.setVisibility(0);
                            this.gcH.setText(functionListInfo.describe);
                        }
                        a(functionListInfo.id.intValue(), functionListInfo.update_time.longValue(), this.gcI);
                        this.gcE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (!TbadkCoreApplication.isLogin()) {
                                    bg.skipToLoginActivity(a.this.mContext);
                                    return;
                                }
                                a.this.a("prefer_key_history", a.this.gcI);
                                a.this.mContext.startActivity(new Intent(a.this.mContext, AlaRecentHistoryActivity.class));
                                TiebaStatic.log("c12648");
                            }
                        });
                        continue;
                    case 3:
                        this.gcJ.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.gcL.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.gcM.setVisibility(0);
                            this.gcM.setText(functionListInfo.describe);
                        }
                        a(functionListInfo.id.intValue(), functionListInfo.update_time.longValue(), this.gcN);
                        this.gcJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                a.this.aO(3, functionListInfo.url);
                                a.this.a("prefer_key_activity", a.this.gcN);
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
        if (Gi(str) < j) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, View view) {
        b.bnH().putLong(str, System.currentTimeMillis() / 1000);
        view.setVisibility(8);
    }

    private long Gi(String str) {
        return b.bnH().getLong(str, 0L);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setBackgroundResource(this.gcA, R.color.cp_bg_line_d);
            ap.setImageResource(this.gcC, R.drawable.live_portal_rank);
            ap.setViewTextColor(this.fTy, R.color.cp_cont_b);
            ap.setViewTextColor(this.gcD, R.color.cp_cont_d);
            ap.setImageResource(this.gcF, R.drawable.live_import_history);
            ap.setViewTextColor(this.gcG, R.color.cp_cont_b);
            ap.setViewTextColor(this.gcH, R.color.cp_cont_d);
            ap.setImageResource(this.gcK, R.drawable.live_import_activity);
            ap.setViewTextColor(this.gcL, R.color.cp_cont_b);
            ap.setViewTextColor(this.gcM, R.color.cp_cont_d);
            ap.setBackgroundResource(this.gcO, R.color.cp_bg_line_e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aO(int i, String str) {
        TiebaStatic.log(new aq("c12215"));
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

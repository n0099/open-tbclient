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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.recent_history.AlaRecentHistoryActivity;
import java.util.List;
import tbclient.LiveSquare.FunctionListInfo;
/* loaded from: classes4.dex */
public class a {
    private TextView fkn;
    private LinearLayout frE;
    private LinearLayout frF;
    private ImageView frG;
    private TextView frH;
    private LinearLayout frI;
    private ImageView frJ;
    private TextView frK;
    private TextView frL;
    private View frM;
    private LinearLayout frN;
    private ImageView frO;
    private TextView frP;
    private TextView frQ;
    private View frR;
    private View frS;
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
        this.frE = (LinearLayout) this.mRootView.findViewById(R.id.square_function_container);
        this.frF = (LinearLayout) this.mRootView.findViewById(R.id.square_function_rank);
        this.frF.setVisibility(8);
        this.frG = (ImageView) this.mRootView.findViewById(R.id.square_function_rank_img);
        this.fkn = (TextView) this.mRootView.findViewById(R.id.square_function_rank_title);
        this.frH = (TextView) this.mRootView.findViewById(R.id.square_function_rank_desc);
        this.frI = (LinearLayout) this.mRootView.findViewById(R.id.square_function_history);
        this.frI.setVisibility(8);
        this.frJ = (ImageView) this.mRootView.findViewById(R.id.square_function_history_img);
        this.frK = (TextView) this.mRootView.findViewById(R.id.square_function_history_title);
        this.frL = (TextView) this.mRootView.findViewById(R.id.square_function_history_desc);
        this.frM = this.mRootView.findViewById(R.id.square_function_history_red_pointer);
        this.frN = (LinearLayout) this.mRootView.findViewById(R.id.square_function_activity);
        this.frN.setVisibility(8);
        this.frO = (ImageView) this.mRootView.findViewById(R.id.square_function_activity_img);
        this.frP = (TextView) this.mRootView.findViewById(R.id.square_function_activity_title);
        this.frQ = (TextView) this.mRootView.findViewById(R.id.square_function_activity_desc);
        this.frR = this.mRootView.findViewById(R.id.square_function_activity_red_pointer);
        this.frS = this.mRootView.findViewById(R.id.square_function_bottom_space);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void aV(List<FunctionListInfo> list) {
        this.mData = list;
        for (final FunctionListInfo functionListInfo : this.mData) {
            if (functionListInfo != null) {
                switch (functionListInfo.id.intValue()) {
                    case 1:
                        this.frF.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.fkn.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.frH.setVisibility(0);
                            this.frH.setText(functionListInfo.describe);
                        }
                        this.frF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                a.this.aE(1, functionListInfo.url);
                            }
                        });
                        continue;
                    case 2:
                        this.frI.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.frK.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.frL.setVisibility(0);
                            this.frL.setText(functionListInfo.describe);
                        }
                        a(functionListInfo.id.intValue(), functionListInfo.update_time.longValue(), this.frM);
                        this.frI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (!TbadkCoreApplication.isLogin()) {
                                    bf.skipToLoginActivity(a.this.mContext);
                                    return;
                                }
                                a.this.a("prefer_key_history", a.this.frM);
                                a.this.mContext.startActivity(new Intent(a.this.mContext, AlaRecentHistoryActivity.class));
                                TiebaStatic.log("c12648");
                            }
                        });
                        continue;
                    case 3:
                        this.frN.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.frP.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.frQ.setVisibility(0);
                            this.frQ.setText(functionListInfo.describe);
                        }
                        a(functionListInfo.id.intValue(), functionListInfo.update_time.longValue(), this.frR);
                        this.frN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                a.this.aE(3, functionListInfo.url);
                                a.this.a("prefer_key_activity", a.this.frR);
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
        if (Cf(str) < j) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, View view) {
        b.aZP().putLong(str, System.currentTimeMillis() / 1000);
        view.setVisibility(8);
    }

    private long Cf(String str) {
        return b.aZP().getLong(str, 0L);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ao.setBackgroundResource(this.frE, R.color.cp_bg_line_d);
            ao.setImageResource(this.frG, R.drawable.live_portal_rank);
            ao.setViewTextColor(this.fkn, R.color.cp_cont_b);
            ao.setViewTextColor(this.frH, R.color.cp_cont_d);
            ao.setImageResource(this.frJ, R.drawable.live_import_history);
            ao.setViewTextColor(this.frK, R.color.cp_cont_b);
            ao.setViewTextColor(this.frL, R.color.cp_cont_d);
            ao.setImageResource(this.frO, R.drawable.live_import_activity);
            ao.setViewTextColor(this.frP, R.color.cp_cont_b);
            ao.setViewTextColor(this.frQ, R.color.cp_cont_d);
            ao.setBackgroundResource(this.frS, R.color.cp_bg_line_e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aE(int i, String str) {
        TiebaStatic.log(new ap("c12215"));
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

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
/* loaded from: classes6.dex */
public class a {
    private TextView duK;
    private LinearLayout dvK;
    private LinearLayout dvL;
    private ImageView dvM;
    private TextView dvN;
    private LinearLayout dvO;
    private ImageView dvP;
    private TextView dvQ;
    private TextView dvR;
    private View dvS;
    private LinearLayout dvT;
    private ImageView dvU;
    private TextView dvV;
    private TextView dvW;
    private View dvX;
    private View dvY;
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
        this.dvK = (LinearLayout) this.mRootView.findViewById(R.id.square_function_container);
        this.dvL = (LinearLayout) this.mRootView.findViewById(R.id.square_function_rank);
        this.dvL.setVisibility(8);
        this.dvM = (ImageView) this.mRootView.findViewById(R.id.square_function_rank_img);
        this.duK = (TextView) this.mRootView.findViewById(R.id.square_function_rank_title);
        this.dvN = (TextView) this.mRootView.findViewById(R.id.square_function_rank_desc);
        this.dvO = (LinearLayout) this.mRootView.findViewById(R.id.square_function_history);
        this.dvO.setVisibility(8);
        this.dvP = (ImageView) this.mRootView.findViewById(R.id.square_function_history_img);
        this.dvQ = (TextView) this.mRootView.findViewById(R.id.square_function_history_title);
        this.dvR = (TextView) this.mRootView.findViewById(R.id.square_function_history_desc);
        this.dvS = this.mRootView.findViewById(R.id.square_function_history_red_pointer);
        this.dvT = (LinearLayout) this.mRootView.findViewById(R.id.square_function_activity);
        this.dvT.setVisibility(8);
        this.dvU = (ImageView) this.mRootView.findViewById(R.id.square_function_activity_img);
        this.dvV = (TextView) this.mRootView.findViewById(R.id.square_function_activity_title);
        this.dvW = (TextView) this.mRootView.findViewById(R.id.square_function_activity_desc);
        this.dvX = this.mRootView.findViewById(R.id.square_function_activity_red_pointer);
        this.dvY = this.mRootView.findViewById(R.id.square_function_bottom_space);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void bh(List<FunctionListInfo> list) {
        this.mData = list;
        for (final FunctionListInfo functionListInfo : this.mData) {
            if (functionListInfo != null) {
                switch (functionListInfo.id.intValue()) {
                    case 1:
                        this.dvL.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.duK.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.dvN.setVisibility(0);
                            this.dvN.setText(functionListInfo.describe);
                        }
                        this.dvL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                a.this.Q(1, functionListInfo.url);
                            }
                        });
                        continue;
                    case 2:
                        this.dvO.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.dvQ.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.dvR.setVisibility(0);
                            this.dvR.setText(functionListInfo.describe);
                        }
                        a(functionListInfo.id.intValue(), functionListInfo.update_time.longValue(), this.dvS);
                        this.dvO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (!TbadkCoreApplication.isLogin()) {
                                    bc.skipToLoginActivity(a.this.mContext);
                                    return;
                                }
                                a.this.a("prefer_key_history", a.this.dvS);
                                a.this.mContext.startActivity(new Intent(a.this.mContext, AlaRecentHistoryActivity.class));
                                TiebaStatic.log("c12648");
                            }
                        });
                        continue;
                    case 3:
                        this.dvT.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.dvV.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.dvW.setVisibility(0);
                            this.dvW.setText(functionListInfo.describe);
                        }
                        a(functionListInfo.id.intValue(), functionListInfo.update_time.longValue(), this.dvX);
                        this.dvT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                a.this.Q(3, functionListInfo.url);
                                a.this.a("prefer_key_activity", a.this.dvX);
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
        if (sC(str) < j) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, View view) {
        b.alR().putLong(str, System.currentTimeMillis() / 1000);
        view.setVisibility(8);
    }

    private long sC(String str) {
        return b.alR().getLong(str, 0L);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setBackgroundResource(this.dvK, R.color.cp_bg_line_d);
            am.setImageResource(this.dvM, R.drawable.live_portal_rank);
            am.setViewTextColor(this.duK, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.dvN, (int) R.color.cp_cont_d);
            am.setImageResource(this.dvP, R.drawable.live_import_history);
            am.setViewTextColor(this.dvQ, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.dvR, (int) R.color.cp_cont_d);
            am.setImageResource(this.dvU, R.drawable.live_import_activity);
            am.setViewTextColor(this.dvV, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.dvW, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.dvY, R.color.cp_bg_line_e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(int i, String str) {
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

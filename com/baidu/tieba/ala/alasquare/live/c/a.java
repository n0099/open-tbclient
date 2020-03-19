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
    private TextView eiv;
    private LinearLayout ekN;
    private LinearLayout ekO;
    private ImageView ekP;
    private TextView ekQ;
    private LinearLayout ekR;
    private ImageView ekS;
    private TextView ekT;
    private TextView ekU;
    private View ekV;
    private LinearLayout ekW;
    private ImageView ekX;
    private TextView ekY;
    private TextView ekZ;
    private View ela;
    private View elb;
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
        this.ekN = (LinearLayout) this.mRootView.findViewById(R.id.square_function_container);
        this.ekO = (LinearLayout) this.mRootView.findViewById(R.id.square_function_rank);
        this.ekO.setVisibility(8);
        this.ekP = (ImageView) this.mRootView.findViewById(R.id.square_function_rank_img);
        this.eiv = (TextView) this.mRootView.findViewById(R.id.square_function_rank_title);
        this.ekQ = (TextView) this.mRootView.findViewById(R.id.square_function_rank_desc);
        this.ekR = (LinearLayout) this.mRootView.findViewById(R.id.square_function_history);
        this.ekR.setVisibility(8);
        this.ekS = (ImageView) this.mRootView.findViewById(R.id.square_function_history_img);
        this.ekT = (TextView) this.mRootView.findViewById(R.id.square_function_history_title);
        this.ekU = (TextView) this.mRootView.findViewById(R.id.square_function_history_desc);
        this.ekV = this.mRootView.findViewById(R.id.square_function_history_red_pointer);
        this.ekW = (LinearLayout) this.mRootView.findViewById(R.id.square_function_activity);
        this.ekW.setVisibility(8);
        this.ekX = (ImageView) this.mRootView.findViewById(R.id.square_function_activity_img);
        this.ekY = (TextView) this.mRootView.findViewById(R.id.square_function_activity_title);
        this.ekZ = (TextView) this.mRootView.findViewById(R.id.square_function_activity_desc);
        this.ela = this.mRootView.findViewById(R.id.square_function_activity_red_pointer);
        this.elb = this.mRootView.findViewById(R.id.square_function_bottom_space);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void bf(List<FunctionListInfo> list) {
        this.mData = list;
        for (final FunctionListInfo functionListInfo : this.mData) {
            if (functionListInfo != null) {
                switch (functionListInfo.id.intValue()) {
                    case 1:
                        this.ekO.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.eiv.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.ekQ.setVisibility(0);
                            this.ekQ.setText(functionListInfo.describe);
                        }
                        this.ekO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                a.this.ah(1, functionListInfo.url);
                            }
                        });
                        continue;
                    case 2:
                        this.ekR.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.ekT.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.ekU.setVisibility(0);
                            this.ekU.setText(functionListInfo.describe);
                        }
                        a(functionListInfo.id.intValue(), functionListInfo.update_time.longValue(), this.ekV);
                        this.ekR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (!TbadkCoreApplication.isLogin()) {
                                    bc.skipToLoginActivity(a.this.mContext);
                                    return;
                                }
                                a.this.a("prefer_key_history", a.this.ekV);
                                a.this.mContext.startActivity(new Intent(a.this.mContext, AlaRecentHistoryActivity.class));
                                TiebaStatic.log("c12648");
                            }
                        });
                        continue;
                    case 3:
                        this.ekW.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.ekY.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.ekZ.setVisibility(0);
                            this.ekZ.setText(functionListInfo.describe);
                        }
                        a(functionListInfo.id.intValue(), functionListInfo.update_time.longValue(), this.ela);
                        this.ekW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                a.this.ah(3, functionListInfo.url);
                                a.this.a("prefer_key_activity", a.this.ela);
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
        if (xJ(str) < j) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, View view) {
        b.aFH().putLong(str, System.currentTimeMillis() / 1000);
        view.setVisibility(8);
    }

    private long xJ(String str) {
        return b.aFH().getLong(str, 0L);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setBackgroundResource(this.ekN, R.color.cp_bg_line_d);
            am.setImageResource(this.ekP, R.drawable.live_portal_rank);
            am.setViewTextColor(this.eiv, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.ekQ, (int) R.color.cp_cont_d);
            am.setImageResource(this.ekS, R.drawable.live_import_history);
            am.setViewTextColor(this.ekT, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.ekU, (int) R.color.cp_cont_d);
            am.setImageResource(this.ekX, R.drawable.live_import_activity);
            am.setViewTextColor(this.ekY, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.ekZ, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.elb, R.color.cp_bg_line_e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(int i, String str) {
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

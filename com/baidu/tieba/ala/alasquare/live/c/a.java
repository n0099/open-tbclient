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
    private TextView eIk;
    private View eOA;
    private View eOB;
    private LinearLayout eOn;
    private LinearLayout eOo;
    private ImageView eOp;
    private TextView eOq;
    private LinearLayout eOr;
    private ImageView eOs;
    private TextView eOt;
    private TextView eOu;
    private View eOv;
    private LinearLayout eOw;
    private ImageView eOx;
    private TextView eOy;
    private TextView eOz;
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
        this.eOn = (LinearLayout) this.mRootView.findViewById(R.id.square_function_container);
        this.eOo = (LinearLayout) this.mRootView.findViewById(R.id.square_function_rank);
        this.eOo.setVisibility(8);
        this.eOp = (ImageView) this.mRootView.findViewById(R.id.square_function_rank_img);
        this.eIk = (TextView) this.mRootView.findViewById(R.id.square_function_rank_title);
        this.eOq = (TextView) this.mRootView.findViewById(R.id.square_function_rank_desc);
        this.eOr = (LinearLayout) this.mRootView.findViewById(R.id.square_function_history);
        this.eOr.setVisibility(8);
        this.eOs = (ImageView) this.mRootView.findViewById(R.id.square_function_history_img);
        this.eOt = (TextView) this.mRootView.findViewById(R.id.square_function_history_title);
        this.eOu = (TextView) this.mRootView.findViewById(R.id.square_function_history_desc);
        this.eOv = this.mRootView.findViewById(R.id.square_function_history_red_pointer);
        this.eOw = (LinearLayout) this.mRootView.findViewById(R.id.square_function_activity);
        this.eOw.setVisibility(8);
        this.eOx = (ImageView) this.mRootView.findViewById(R.id.square_function_activity_img);
        this.eOy = (TextView) this.mRootView.findViewById(R.id.square_function_activity_title);
        this.eOz = (TextView) this.mRootView.findViewById(R.id.square_function_activity_desc);
        this.eOA = this.mRootView.findViewById(R.id.square_function_activity_red_pointer);
        this.eOB = this.mRootView.findViewById(R.id.square_function_bottom_space);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void bp(List<FunctionListInfo> list) {
        this.mData = list;
        for (final FunctionListInfo functionListInfo : this.mData) {
            if (functionListInfo != null) {
                switch (functionListInfo.id.intValue()) {
                    case 1:
                        this.eOo.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.eIk.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.eOq.setVisibility(0);
                            this.eOq.setText(functionListInfo.describe);
                        }
                        this.eOo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                a.this.aw(1, functionListInfo.url);
                            }
                        });
                        continue;
                    case 2:
                        this.eOr.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.eOt.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.eOu.setVisibility(0);
                            this.eOu.setText(functionListInfo.describe);
                        }
                        a(functionListInfo.id.intValue(), functionListInfo.update_time.longValue(), this.eOv);
                        this.eOr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (!TbadkCoreApplication.isLogin()) {
                                    bc.skipToLoginActivity(a.this.mContext);
                                    return;
                                }
                                a.this.a("prefer_key_history", a.this.eOv);
                                a.this.mContext.startActivity(new Intent(a.this.mContext, AlaRecentHistoryActivity.class));
                                TiebaStatic.log("c12648");
                            }
                        });
                        continue;
                    case 3:
                        this.eOw.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.eOy.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.eOz.setVisibility(0);
                            this.eOz.setText(functionListInfo.describe);
                        }
                        a(functionListInfo.id.intValue(), functionListInfo.update_time.longValue(), this.eOA);
                        this.eOw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                a.this.aw(3, functionListInfo.url);
                                a.this.a("prefer_key_activity", a.this.eOA);
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
        if (zm(str) < j) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, View view) {
        b.aNV().putLong(str, System.currentTimeMillis() / 1000);
        view.setVisibility(8);
    }

    private long zm(String str) {
        return b.aNV().getLong(str, 0L);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setBackgroundResource(this.eOn, R.color.cp_bg_line_d);
            am.setImageResource(this.eOp, R.drawable.live_portal_rank);
            am.setViewTextColor(this.eIk, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.eOq, (int) R.color.cp_cont_d);
            am.setImageResource(this.eOs, R.drawable.live_import_history);
            am.setViewTextColor(this.eOt, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.eOu, (int) R.color.cp_cont_d);
            am.setImageResource(this.eOx, R.drawable.live_import_activity);
            am.setViewTextColor(this.eOy, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.eOz, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.eOB, R.color.cp_bg_line_e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aw(int i, String str) {
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

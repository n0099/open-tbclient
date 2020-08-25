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
    private LinearLayout fCY;
    private LinearLayout fCZ;
    private ImageView fDa;
    private TextView fDb;
    private LinearLayout fDc;
    private ImageView fDd;
    private TextView fDe;
    private TextView fDf;
    private View fDg;
    private LinearLayout fDh;
    private ImageView fDi;
    private TextView fDj;
    private TextView fDk;
    private View fDl;
    private View fDm;
    private TextView fvJ;
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
        this.fCY = (LinearLayout) this.mRootView.findViewById(R.id.square_function_container);
        this.fCZ = (LinearLayout) this.mRootView.findViewById(R.id.square_function_rank);
        this.fCZ.setVisibility(8);
        this.fDa = (ImageView) this.mRootView.findViewById(R.id.square_function_rank_img);
        this.fvJ = (TextView) this.mRootView.findViewById(R.id.square_function_rank_title);
        this.fDb = (TextView) this.mRootView.findViewById(R.id.square_function_rank_desc);
        this.fDc = (LinearLayout) this.mRootView.findViewById(R.id.square_function_history);
        this.fDc.setVisibility(8);
        this.fDd = (ImageView) this.mRootView.findViewById(R.id.square_function_history_img);
        this.fDe = (TextView) this.mRootView.findViewById(R.id.square_function_history_title);
        this.fDf = (TextView) this.mRootView.findViewById(R.id.square_function_history_desc);
        this.fDg = this.mRootView.findViewById(R.id.square_function_history_red_pointer);
        this.fDh = (LinearLayout) this.mRootView.findViewById(R.id.square_function_activity);
        this.fDh.setVisibility(8);
        this.fDi = (ImageView) this.mRootView.findViewById(R.id.square_function_activity_img);
        this.fDj = (TextView) this.mRootView.findViewById(R.id.square_function_activity_title);
        this.fDk = (TextView) this.mRootView.findViewById(R.id.square_function_activity_desc);
        this.fDl = this.mRootView.findViewById(R.id.square_function_activity_red_pointer);
        this.fDm = this.mRootView.findViewById(R.id.square_function_bottom_space);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void by(List<FunctionListInfo> list) {
        this.mData = list;
        for (final FunctionListInfo functionListInfo : this.mData) {
            if (functionListInfo != null) {
                switch (functionListInfo.id.intValue()) {
                    case 1:
                        this.fCZ.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.fvJ.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.fDb.setVisibility(0);
                            this.fDb.setText(functionListInfo.describe);
                        }
                        this.fCZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                a.this.aC(1, functionListInfo.url);
                            }
                        });
                        continue;
                    case 2:
                        this.fDc.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.fDe.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.fDf.setVisibility(0);
                            this.fDf.setText(functionListInfo.describe);
                        }
                        a(functionListInfo.id.intValue(), functionListInfo.update_time.longValue(), this.fDg);
                        this.fDc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (!TbadkCoreApplication.isLogin()) {
                                    bg.skipToLoginActivity(a.this.mContext);
                                    return;
                                }
                                a.this.a("prefer_key_history", a.this.fDg);
                                a.this.mContext.startActivity(new Intent(a.this.mContext, AlaRecentHistoryActivity.class));
                                TiebaStatic.log("c12648");
                            }
                        });
                        continue;
                    case 3:
                        this.fDh.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.fDj.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.fDk.setVisibility(0);
                            this.fDk.setText(functionListInfo.describe);
                        }
                        a(functionListInfo.id.intValue(), functionListInfo.update_time.longValue(), this.fDl);
                        this.fDh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                a.this.aC(3, functionListInfo.url);
                                a.this.a("prefer_key_activity", a.this.fDl);
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
        if (Ez(str) < j) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, View view) {
        b.bik().putLong(str, System.currentTimeMillis() / 1000);
        view.setVisibility(8);
    }

    private long Ez(String str) {
        return b.bik().getLong(str, 0L);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setBackgroundResource(this.fCY, R.color.cp_bg_line_d);
            ap.setImageResource(this.fDa, R.drawable.live_portal_rank);
            ap.setViewTextColor(this.fvJ, (int) R.color.cp_cont_b);
            ap.setViewTextColor(this.fDb, (int) R.color.cp_cont_d);
            ap.setImageResource(this.fDd, R.drawable.live_import_history);
            ap.setViewTextColor(this.fDe, (int) R.color.cp_cont_b);
            ap.setViewTextColor(this.fDf, (int) R.color.cp_cont_d);
            ap.setImageResource(this.fDi, R.drawable.live_import_activity);
            ap.setViewTextColor(this.fDj, (int) R.color.cp_cont_b);
            ap.setViewTextColor(this.fDk, (int) R.color.cp_cont_d);
            ap.setBackgroundResource(this.fDm, R.color.cp_bg_line_e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aC(int i, String str) {
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

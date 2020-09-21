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
    private TextView fGA;
    private View fGB;
    private View fGC;
    private LinearLayout fGo;
    private LinearLayout fGp;
    private ImageView fGq;
    private TextView fGr;
    private LinearLayout fGs;
    private ImageView fGt;
    private TextView fGu;
    private TextView fGv;
    private View fGw;
    private LinearLayout fGx;
    private ImageView fGy;
    private TextView fGz;
    private TextView fyY;
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
        this.fGo = (LinearLayout) this.mRootView.findViewById(R.id.square_function_container);
        this.fGp = (LinearLayout) this.mRootView.findViewById(R.id.square_function_rank);
        this.fGp.setVisibility(8);
        this.fGq = (ImageView) this.mRootView.findViewById(R.id.square_function_rank_img);
        this.fyY = (TextView) this.mRootView.findViewById(R.id.square_function_rank_title);
        this.fGr = (TextView) this.mRootView.findViewById(R.id.square_function_rank_desc);
        this.fGs = (LinearLayout) this.mRootView.findViewById(R.id.square_function_history);
        this.fGs.setVisibility(8);
        this.fGt = (ImageView) this.mRootView.findViewById(R.id.square_function_history_img);
        this.fGu = (TextView) this.mRootView.findViewById(R.id.square_function_history_title);
        this.fGv = (TextView) this.mRootView.findViewById(R.id.square_function_history_desc);
        this.fGw = this.mRootView.findViewById(R.id.square_function_history_red_pointer);
        this.fGx = (LinearLayout) this.mRootView.findViewById(R.id.square_function_activity);
        this.fGx.setVisibility(8);
        this.fGy = (ImageView) this.mRootView.findViewById(R.id.square_function_activity_img);
        this.fGz = (TextView) this.mRootView.findViewById(R.id.square_function_activity_title);
        this.fGA = (TextView) this.mRootView.findViewById(R.id.square_function_activity_desc);
        this.fGB = this.mRootView.findViewById(R.id.square_function_activity_red_pointer);
        this.fGC = this.mRootView.findViewById(R.id.square_function_bottom_space);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void bD(List<FunctionListInfo> list) {
        this.mData = list;
        for (final FunctionListInfo functionListInfo : this.mData) {
            if (functionListInfo != null) {
                switch (functionListInfo.id.intValue()) {
                    case 1:
                        this.fGp.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.fyY.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.fGr.setVisibility(0);
                            this.fGr.setText(functionListInfo.describe);
                        }
                        this.fGp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                a.this.aC(1, functionListInfo.url);
                            }
                        });
                        continue;
                    case 2:
                        this.fGs.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.fGu.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.fGv.setVisibility(0);
                            this.fGv.setText(functionListInfo.describe);
                        }
                        a(functionListInfo.id.intValue(), functionListInfo.update_time.longValue(), this.fGw);
                        this.fGs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (!TbadkCoreApplication.isLogin()) {
                                    bg.skipToLoginActivity(a.this.mContext);
                                    return;
                                }
                                a.this.a("prefer_key_history", a.this.fGw);
                                a.this.mContext.startActivity(new Intent(a.this.mContext, AlaRecentHistoryActivity.class));
                                TiebaStatic.log("c12648");
                            }
                        });
                        continue;
                    case 3:
                        this.fGx.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.fGz.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.fGA.setVisibility(0);
                            this.fGA.setText(functionListInfo.describe);
                        }
                        a(functionListInfo.id.intValue(), functionListInfo.update_time.longValue(), this.fGB);
                        this.fGx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                a.this.aC(3, functionListInfo.url);
                                a.this.a("prefer_key_activity", a.this.fGB);
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
        if (EY(str) < j) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, View view) {
        b.bjf().putLong(str, System.currentTimeMillis() / 1000);
        view.setVisibility(8);
    }

    private long EY(String str) {
        return b.bjf().getLong(str, 0L);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setBackgroundResource(this.fGo, R.color.cp_bg_line_d);
            ap.setImageResource(this.fGq, R.drawable.live_portal_rank);
            ap.setViewTextColor(this.fyY, R.color.cp_cont_b);
            ap.setViewTextColor(this.fGr, R.color.cp_cont_d);
            ap.setImageResource(this.fGt, R.drawable.live_import_history);
            ap.setViewTextColor(this.fGu, R.color.cp_cont_b);
            ap.setViewTextColor(this.fGv, R.color.cp_cont_d);
            ap.setImageResource(this.fGy, R.drawable.live_import_activity);
            ap.setViewTextColor(this.fGz, R.color.cp_cont_b);
            ap.setViewTextColor(this.fGA, R.color.cp_cont_d);
            ap.setBackgroundResource(this.fGC, R.color.cp_bg_line_e);
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

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
    private LinearLayout fDc;
    private LinearLayout fDd;
    private ImageView fDe;
    private TextView fDf;
    private LinearLayout fDg;
    private ImageView fDh;
    private TextView fDi;
    private TextView fDj;
    private View fDk;
    private LinearLayout fDl;
    private ImageView fDm;
    private TextView fDn;
    private TextView fDo;
    private View fDp;
    private View fDq;
    private TextView fvN;
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
        this.fDc = (LinearLayout) this.mRootView.findViewById(R.id.square_function_container);
        this.fDd = (LinearLayout) this.mRootView.findViewById(R.id.square_function_rank);
        this.fDd.setVisibility(8);
        this.fDe = (ImageView) this.mRootView.findViewById(R.id.square_function_rank_img);
        this.fvN = (TextView) this.mRootView.findViewById(R.id.square_function_rank_title);
        this.fDf = (TextView) this.mRootView.findViewById(R.id.square_function_rank_desc);
        this.fDg = (LinearLayout) this.mRootView.findViewById(R.id.square_function_history);
        this.fDg.setVisibility(8);
        this.fDh = (ImageView) this.mRootView.findViewById(R.id.square_function_history_img);
        this.fDi = (TextView) this.mRootView.findViewById(R.id.square_function_history_title);
        this.fDj = (TextView) this.mRootView.findViewById(R.id.square_function_history_desc);
        this.fDk = this.mRootView.findViewById(R.id.square_function_history_red_pointer);
        this.fDl = (LinearLayout) this.mRootView.findViewById(R.id.square_function_activity);
        this.fDl.setVisibility(8);
        this.fDm = (ImageView) this.mRootView.findViewById(R.id.square_function_activity_img);
        this.fDn = (TextView) this.mRootView.findViewById(R.id.square_function_activity_title);
        this.fDo = (TextView) this.mRootView.findViewById(R.id.square_function_activity_desc);
        this.fDp = this.mRootView.findViewById(R.id.square_function_activity_red_pointer);
        this.fDq = this.mRootView.findViewById(R.id.square_function_bottom_space);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void by(List<FunctionListInfo> list) {
        this.mData = list;
        for (final FunctionListInfo functionListInfo : this.mData) {
            if (functionListInfo != null) {
                switch (functionListInfo.id.intValue()) {
                    case 1:
                        this.fDd.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.fvN.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.fDf.setVisibility(0);
                            this.fDf.setText(functionListInfo.describe);
                        }
                        this.fDd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                a.this.aB(1, functionListInfo.url);
                            }
                        });
                        continue;
                    case 2:
                        this.fDg.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.fDi.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.fDj.setVisibility(0);
                            this.fDj.setText(functionListInfo.describe);
                        }
                        a(functionListInfo.id.intValue(), functionListInfo.update_time.longValue(), this.fDk);
                        this.fDg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (!TbadkCoreApplication.isLogin()) {
                                    bg.skipToLoginActivity(a.this.mContext);
                                    return;
                                }
                                a.this.a("prefer_key_history", a.this.fDk);
                                a.this.mContext.startActivity(new Intent(a.this.mContext, AlaRecentHistoryActivity.class));
                                TiebaStatic.log("c12648");
                            }
                        });
                        continue;
                    case 3:
                        this.fDl.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.fDn.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.fDo.setVisibility(0);
                            this.fDo.setText(functionListInfo.describe);
                        }
                        a(functionListInfo.id.intValue(), functionListInfo.update_time.longValue(), this.fDp);
                        this.fDl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                a.this.aB(3, functionListInfo.url);
                                a.this.a("prefer_key_activity", a.this.fDp);
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
        if (EA(str) < j) {
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

    private long EA(String str) {
        return b.bik().getLong(str, 0L);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setBackgroundResource(this.fDc, R.color.cp_bg_line_d);
            ap.setImageResource(this.fDe, R.drawable.live_portal_rank);
            ap.setViewTextColor(this.fvN, (int) R.color.cp_cont_b);
            ap.setViewTextColor(this.fDf, (int) R.color.cp_cont_d);
            ap.setImageResource(this.fDh, R.drawable.live_import_history);
            ap.setViewTextColor(this.fDi, (int) R.color.cp_cont_b);
            ap.setViewTextColor(this.fDj, (int) R.color.cp_cont_d);
            ap.setImageResource(this.fDm, R.drawable.live_import_activity);
            ap.setViewTextColor(this.fDn, (int) R.color.cp_cont_b);
            ap.setViewTextColor(this.fDo, (int) R.color.cp_cont_d);
            ap.setBackgroundResource(this.fDq, R.color.cp_bg_line_e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aB(int i, String str) {
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

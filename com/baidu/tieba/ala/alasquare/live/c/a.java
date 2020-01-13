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
/* loaded from: classes2.dex */
public class a {
    private TextView edO;
    private LinearLayout egf;
    private LinearLayout egg;
    private ImageView egh;
    private TextView egi;
    private LinearLayout egj;
    private ImageView egk;
    private TextView egl;
    private TextView egm;
    private View egn;
    private LinearLayout ego;
    private ImageView egp;
    private TextView egq;
    private TextView egr;
    private View egs;
    private View egt;
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
        this.egf = (LinearLayout) this.mRootView.findViewById(R.id.square_function_container);
        this.egg = (LinearLayout) this.mRootView.findViewById(R.id.square_function_rank);
        this.egg.setVisibility(8);
        this.egh = (ImageView) this.mRootView.findViewById(R.id.square_function_rank_img);
        this.edO = (TextView) this.mRootView.findViewById(R.id.square_function_rank_title);
        this.egi = (TextView) this.mRootView.findViewById(R.id.square_function_rank_desc);
        this.egj = (LinearLayout) this.mRootView.findViewById(R.id.square_function_history);
        this.egj.setVisibility(8);
        this.egk = (ImageView) this.mRootView.findViewById(R.id.square_function_history_img);
        this.egl = (TextView) this.mRootView.findViewById(R.id.square_function_history_title);
        this.egm = (TextView) this.mRootView.findViewById(R.id.square_function_history_desc);
        this.egn = this.mRootView.findViewById(R.id.square_function_history_red_pointer);
        this.ego = (LinearLayout) this.mRootView.findViewById(R.id.square_function_activity);
        this.ego.setVisibility(8);
        this.egp = (ImageView) this.mRootView.findViewById(R.id.square_function_activity_img);
        this.egq = (TextView) this.mRootView.findViewById(R.id.square_function_activity_title);
        this.egr = (TextView) this.mRootView.findViewById(R.id.square_function_activity_desc);
        this.egs = this.mRootView.findViewById(R.id.square_function_activity_red_pointer);
        this.egt = this.mRootView.findViewById(R.id.square_function_bottom_space);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void bf(List<FunctionListInfo> list) {
        this.mData = list;
        for (final FunctionListInfo functionListInfo : this.mData) {
            if (functionListInfo != null) {
                switch (functionListInfo.id.intValue()) {
                    case 1:
                        this.egg.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.edO.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.egi.setVisibility(0);
                            this.egi.setText(functionListInfo.describe);
                        }
                        this.egg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                a.this.ag(1, functionListInfo.url);
                            }
                        });
                        continue;
                    case 2:
                        this.egj.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.egl.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.egm.setVisibility(0);
                            this.egm.setText(functionListInfo.describe);
                        }
                        a(functionListInfo.id.intValue(), functionListInfo.update_time.longValue(), this.egn);
                        this.egj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (!TbadkCoreApplication.isLogin()) {
                                    bc.skipToLoginActivity(a.this.mContext);
                                    return;
                                }
                                a.this.a("prefer_key_history", a.this.egn);
                                a.this.mContext.startActivity(new Intent(a.this.mContext, AlaRecentHistoryActivity.class));
                                TiebaStatic.log("c12648");
                            }
                        });
                        continue;
                    case 3:
                        this.ego.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.egq.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.egr.setVisibility(0);
                            this.egr.setText(functionListInfo.describe);
                        }
                        a(functionListInfo.id.intValue(), functionListInfo.update_time.longValue(), this.egs);
                        this.ego.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                a.this.ag(3, functionListInfo.url);
                                a.this.a("prefer_key_activity", a.this.egs);
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
        if (xn(str) < j) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, View view) {
        b.aDr().putLong(str, System.currentTimeMillis() / 1000);
        view.setVisibility(8);
    }

    private long xn(String str) {
        return b.aDr().getLong(str, 0L);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setBackgroundResource(this.egf, R.color.cp_bg_line_d);
            am.setImageResource(this.egh, R.drawable.live_portal_rank);
            am.setViewTextColor(this.edO, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.egi, (int) R.color.cp_cont_d);
            am.setImageResource(this.egk, R.drawable.live_import_history);
            am.setViewTextColor(this.egl, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.egm, (int) R.color.cp_cont_d);
            am.setImageResource(this.egp, R.drawable.live_import_activity);
            am.setViewTextColor(this.egq, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.egr, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.egt, R.color.cp_bg_line_e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ag(int i, String str) {
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

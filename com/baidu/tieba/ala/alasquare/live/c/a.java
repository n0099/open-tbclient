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
    private TextView dtT;
    private LinearLayout duT;
    private LinearLayout duU;
    private ImageView duV;
    private TextView duW;
    private LinearLayout duX;
    private ImageView duY;
    private TextView duZ;
    private TextView dva;
    private View dvb;
    private LinearLayout dvc;
    private ImageView dvd;
    private TextView dve;
    private TextView dvf;
    private View dvg;
    private View dvh;
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
        this.duT = (LinearLayout) this.mRootView.findViewById(R.id.square_function_container);
        this.duU = (LinearLayout) this.mRootView.findViewById(R.id.square_function_rank);
        this.duU.setVisibility(8);
        this.duV = (ImageView) this.mRootView.findViewById(R.id.square_function_rank_img);
        this.dtT = (TextView) this.mRootView.findViewById(R.id.square_function_rank_title);
        this.duW = (TextView) this.mRootView.findViewById(R.id.square_function_rank_desc);
        this.duX = (LinearLayout) this.mRootView.findViewById(R.id.square_function_history);
        this.duX.setVisibility(8);
        this.duY = (ImageView) this.mRootView.findViewById(R.id.square_function_history_img);
        this.duZ = (TextView) this.mRootView.findViewById(R.id.square_function_history_title);
        this.dva = (TextView) this.mRootView.findViewById(R.id.square_function_history_desc);
        this.dvb = this.mRootView.findViewById(R.id.square_function_history_red_pointer);
        this.dvc = (LinearLayout) this.mRootView.findViewById(R.id.square_function_activity);
        this.dvc.setVisibility(8);
        this.dvd = (ImageView) this.mRootView.findViewById(R.id.square_function_activity_img);
        this.dve = (TextView) this.mRootView.findViewById(R.id.square_function_activity_title);
        this.dvf = (TextView) this.mRootView.findViewById(R.id.square_function_activity_desc);
        this.dvg = this.mRootView.findViewById(R.id.square_function_activity_red_pointer);
        this.dvh = this.mRootView.findViewById(R.id.square_function_bottom_space);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void bh(List<FunctionListInfo> list) {
        this.mData = list;
        for (final FunctionListInfo functionListInfo : this.mData) {
            if (functionListInfo != null) {
                switch (functionListInfo.id.intValue()) {
                    case 1:
                        this.duU.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.dtT.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.duW.setVisibility(0);
                            this.duW.setText(functionListInfo.describe);
                        }
                        this.duU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                a.this.P(1, functionListInfo.url);
                            }
                        });
                        continue;
                    case 2:
                        this.duX.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.duZ.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.dva.setVisibility(0);
                            this.dva.setText(functionListInfo.describe);
                        }
                        a(functionListInfo.id.intValue(), functionListInfo.update_time.longValue(), this.dvb);
                        this.duX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (!TbadkCoreApplication.isLogin()) {
                                    bc.skipToLoginActivity(a.this.mContext);
                                    return;
                                }
                                a.this.a("prefer_key_history", a.this.dvb);
                                a.this.mContext.startActivity(new Intent(a.this.mContext, AlaRecentHistoryActivity.class));
                                TiebaStatic.log("c12648");
                            }
                        });
                        continue;
                    case 3:
                        this.dvc.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.dve.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.dvf.setVisibility(0);
                            this.dvf.setText(functionListInfo.describe);
                        }
                        a(functionListInfo.id.intValue(), functionListInfo.update_time.longValue(), this.dvg);
                        this.dvc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                a.this.P(3, functionListInfo.url);
                                a.this.a("prefer_key_activity", a.this.dvg);
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
        b.alP().putLong(str, System.currentTimeMillis() / 1000);
        view.setVisibility(8);
    }

    private long sC(String str) {
        return b.alP().getLong(str, 0L);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setBackgroundResource(this.duT, R.color.cp_bg_line_d);
            am.setImageResource(this.duV, R.drawable.live_portal_rank);
            am.setViewTextColor(this.dtT, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.duW, (int) R.color.cp_cont_d);
            am.setImageResource(this.duY, R.drawable.live_import_history);
            am.setViewTextColor(this.duZ, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.dva, (int) R.color.cp_cont_d);
            am.setImageResource(this.dvd, R.drawable.live_import_activity);
            am.setViewTextColor(this.dve, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.dvf, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.dvh, R.color.cp_bg_line_e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(int i, String str) {
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

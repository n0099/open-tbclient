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
    private TextView edG;
    private LinearLayout efV;
    private LinearLayout efW;
    private ImageView efX;
    private TextView efY;
    private LinearLayout efZ;
    private ImageView ega;
    private TextView egb;
    private TextView egc;
    private View egd;
    private LinearLayout ege;
    private ImageView egf;
    private TextView egg;
    private TextView egh;
    private View egi;
    private View egj;
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
        this.efV = (LinearLayout) this.mRootView.findViewById(R.id.square_function_container);
        this.efW = (LinearLayout) this.mRootView.findViewById(R.id.square_function_rank);
        this.efW.setVisibility(8);
        this.efX = (ImageView) this.mRootView.findViewById(R.id.square_function_rank_img);
        this.edG = (TextView) this.mRootView.findViewById(R.id.square_function_rank_title);
        this.efY = (TextView) this.mRootView.findViewById(R.id.square_function_rank_desc);
        this.efZ = (LinearLayout) this.mRootView.findViewById(R.id.square_function_history);
        this.efZ.setVisibility(8);
        this.ega = (ImageView) this.mRootView.findViewById(R.id.square_function_history_img);
        this.egb = (TextView) this.mRootView.findViewById(R.id.square_function_history_title);
        this.egc = (TextView) this.mRootView.findViewById(R.id.square_function_history_desc);
        this.egd = this.mRootView.findViewById(R.id.square_function_history_red_pointer);
        this.ege = (LinearLayout) this.mRootView.findViewById(R.id.square_function_activity);
        this.ege.setVisibility(8);
        this.egf = (ImageView) this.mRootView.findViewById(R.id.square_function_activity_img);
        this.egg = (TextView) this.mRootView.findViewById(R.id.square_function_activity_title);
        this.egh = (TextView) this.mRootView.findViewById(R.id.square_function_activity_desc);
        this.egi = this.mRootView.findViewById(R.id.square_function_activity_red_pointer);
        this.egj = this.mRootView.findViewById(R.id.square_function_bottom_space);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void bg(List<FunctionListInfo> list) {
        this.mData = list;
        for (final FunctionListInfo functionListInfo : this.mData) {
            if (functionListInfo != null) {
                switch (functionListInfo.id.intValue()) {
                    case 1:
                        this.efW.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.edG.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.efY.setVisibility(0);
                            this.efY.setText(functionListInfo.describe);
                        }
                        this.efW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                a.this.ae(1, functionListInfo.url);
                            }
                        });
                        continue;
                    case 2:
                        this.efZ.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.egb.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.egc.setVisibility(0);
                            this.egc.setText(functionListInfo.describe);
                        }
                        a(functionListInfo.id.intValue(), functionListInfo.update_time.longValue(), this.egd);
                        this.efZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (!TbadkCoreApplication.isLogin()) {
                                    bc.skipToLoginActivity(a.this.mContext);
                                    return;
                                }
                                a.this.a("prefer_key_history", a.this.egd);
                                a.this.mContext.startActivity(new Intent(a.this.mContext, AlaRecentHistoryActivity.class));
                                TiebaStatic.log("c12648");
                            }
                        });
                        continue;
                    case 3:
                        this.ege.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.egg.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.egh.setVisibility(0);
                            this.egh.setText(functionListInfo.describe);
                        }
                        a(functionListInfo.id.intValue(), functionListInfo.update_time.longValue(), this.egi);
                        this.ege.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                a.this.ae(3, functionListInfo.url);
                                a.this.a("prefer_key_activity", a.this.egi);
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
        if (xj(str) < j) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, View view) {
        b.aCY().putLong(str, System.currentTimeMillis() / 1000);
        view.setVisibility(8);
    }

    private long xj(String str) {
        return b.aCY().getLong(str, 0L);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setBackgroundResource(this.efV, R.color.cp_bg_line_d);
            am.setImageResource(this.efX, R.drawable.live_portal_rank);
            am.setViewTextColor(this.edG, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.efY, (int) R.color.cp_cont_d);
            am.setImageResource(this.ega, R.drawable.live_import_history);
            am.setViewTextColor(this.egb, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.egc, (int) R.color.cp_cont_d);
            am.setImageResource(this.egf, R.drawable.live_import_activity);
            am.setViewTextColor(this.egg, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.egh, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.egj, R.color.cp_bg_line_e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(int i, String str) {
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

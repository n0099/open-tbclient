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
    private TextView fLh;
    private TextView fSA;
    private LinearLayout fSB;
    private ImageView fSC;
    private TextView fSD;
    private TextView fSE;
    private View fSF;
    private LinearLayout fSG;
    private ImageView fSH;
    private TextView fSI;
    private TextView fSJ;
    private View fSK;
    private View fSL;
    private LinearLayout fSx;
    private LinearLayout fSy;
    private ImageView fSz;
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
        this.fSx = (LinearLayout) this.mRootView.findViewById(R.id.square_function_container);
        this.fSy = (LinearLayout) this.mRootView.findViewById(R.id.square_function_rank);
        this.fSy.setVisibility(8);
        this.fSz = (ImageView) this.mRootView.findViewById(R.id.square_function_rank_img);
        this.fLh = (TextView) this.mRootView.findViewById(R.id.square_function_rank_title);
        this.fSA = (TextView) this.mRootView.findViewById(R.id.square_function_rank_desc);
        this.fSB = (LinearLayout) this.mRootView.findViewById(R.id.square_function_history);
        this.fSB.setVisibility(8);
        this.fSC = (ImageView) this.mRootView.findViewById(R.id.square_function_history_img);
        this.fSD = (TextView) this.mRootView.findViewById(R.id.square_function_history_title);
        this.fSE = (TextView) this.mRootView.findViewById(R.id.square_function_history_desc);
        this.fSF = this.mRootView.findViewById(R.id.square_function_history_red_pointer);
        this.fSG = (LinearLayout) this.mRootView.findViewById(R.id.square_function_activity);
        this.fSG.setVisibility(8);
        this.fSH = (ImageView) this.mRootView.findViewById(R.id.square_function_activity_img);
        this.fSI = (TextView) this.mRootView.findViewById(R.id.square_function_activity_title);
        this.fSJ = (TextView) this.mRootView.findViewById(R.id.square_function_activity_desc);
        this.fSK = this.mRootView.findViewById(R.id.square_function_activity_red_pointer);
        this.fSL = this.mRootView.findViewById(R.id.square_function_bottom_space);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void bG(List<FunctionListInfo> list) {
        this.mData = list;
        for (final FunctionListInfo functionListInfo : this.mData) {
            if (functionListInfo != null) {
                switch (functionListInfo.id.intValue()) {
                    case 1:
                        this.fSy.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.fLh.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.fSA.setVisibility(0);
                            this.fSA.setText(functionListInfo.describe);
                        }
                        this.fSy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                a.this.aN(1, functionListInfo.url);
                            }
                        });
                        continue;
                    case 2:
                        this.fSB.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.fSD.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.fSE.setVisibility(0);
                            this.fSE.setText(functionListInfo.describe);
                        }
                        a(functionListInfo.id.intValue(), functionListInfo.update_time.longValue(), this.fSF);
                        this.fSB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (!TbadkCoreApplication.isLogin()) {
                                    bg.skipToLoginActivity(a.this.mContext);
                                    return;
                                }
                                a.this.a("prefer_key_history", a.this.fSF);
                                a.this.mContext.startActivity(new Intent(a.this.mContext, AlaRecentHistoryActivity.class));
                                TiebaStatic.log("c12648");
                            }
                        });
                        continue;
                    case 3:
                        this.fSG.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.fSI.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.fSJ.setVisibility(0);
                            this.fSJ.setText(functionListInfo.describe);
                        }
                        a(functionListInfo.id.intValue(), functionListInfo.update_time.longValue(), this.fSK);
                        this.fSG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                a.this.aN(3, functionListInfo.url);
                                a.this.a("prefer_key_activity", a.this.fSK);
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
        if (FJ(str) < j) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, View view) {
        b.blO().putLong(str, System.currentTimeMillis() / 1000);
        view.setVisibility(8);
    }

    private long FJ(String str) {
        return b.blO().getLong(str, 0L);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setBackgroundResource(this.fSx, R.color.cp_bg_line_d);
            ap.setImageResource(this.fSz, R.drawable.live_portal_rank);
            ap.setViewTextColor(this.fLh, R.color.cp_cont_b);
            ap.setViewTextColor(this.fSA, R.color.cp_cont_d);
            ap.setImageResource(this.fSC, R.drawable.live_import_history);
            ap.setViewTextColor(this.fSD, R.color.cp_cont_b);
            ap.setViewTextColor(this.fSE, R.color.cp_cont_d);
            ap.setImageResource(this.fSH, R.drawable.live_import_activity);
            ap.setViewTextColor(this.fSI, R.color.cp_cont_b);
            ap.setViewTextColor(this.fSJ, R.color.cp_cont_d);
            ap.setBackgroundResource(this.fSL, R.color.cp_bg_line_e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aN(int i, String str) {
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

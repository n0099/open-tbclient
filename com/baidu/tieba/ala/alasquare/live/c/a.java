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
    private TextView eif;
    private TextView ekA;
    private LinearLayout ekB;
    private ImageView ekC;
    private TextView ekD;
    private TextView ekE;
    private View ekF;
    private LinearLayout ekG;
    private ImageView ekH;
    private TextView ekI;
    private TextView ekJ;
    private View ekK;
    private View ekL;
    private LinearLayout ekx;
    private LinearLayout eky;
    private ImageView ekz;
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
        this.ekx = (LinearLayout) this.mRootView.findViewById(R.id.square_function_container);
        this.eky = (LinearLayout) this.mRootView.findViewById(R.id.square_function_rank);
        this.eky.setVisibility(8);
        this.ekz = (ImageView) this.mRootView.findViewById(R.id.square_function_rank_img);
        this.eif = (TextView) this.mRootView.findViewById(R.id.square_function_rank_title);
        this.ekA = (TextView) this.mRootView.findViewById(R.id.square_function_rank_desc);
        this.ekB = (LinearLayout) this.mRootView.findViewById(R.id.square_function_history);
        this.ekB.setVisibility(8);
        this.ekC = (ImageView) this.mRootView.findViewById(R.id.square_function_history_img);
        this.ekD = (TextView) this.mRootView.findViewById(R.id.square_function_history_title);
        this.ekE = (TextView) this.mRootView.findViewById(R.id.square_function_history_desc);
        this.ekF = this.mRootView.findViewById(R.id.square_function_history_red_pointer);
        this.ekG = (LinearLayout) this.mRootView.findViewById(R.id.square_function_activity);
        this.ekG.setVisibility(8);
        this.ekH = (ImageView) this.mRootView.findViewById(R.id.square_function_activity_img);
        this.ekI = (TextView) this.mRootView.findViewById(R.id.square_function_activity_title);
        this.ekJ = (TextView) this.mRootView.findViewById(R.id.square_function_activity_desc);
        this.ekK = this.mRootView.findViewById(R.id.square_function_activity_red_pointer);
        this.ekL = this.mRootView.findViewById(R.id.square_function_bottom_space);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void bf(List<FunctionListInfo> list) {
        this.mData = list;
        for (final FunctionListInfo functionListInfo : this.mData) {
            if (functionListInfo != null) {
                switch (functionListInfo.id.intValue()) {
                    case 1:
                        this.eky.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.eif.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.ekA.setVisibility(0);
                            this.ekA.setText(functionListInfo.describe);
                        }
                        this.eky.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                a.this.ah(1, functionListInfo.url);
                            }
                        });
                        continue;
                    case 2:
                        this.ekB.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.ekD.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.ekE.setVisibility(0);
                            this.ekE.setText(functionListInfo.describe);
                        }
                        a(functionListInfo.id.intValue(), functionListInfo.update_time.longValue(), this.ekF);
                        this.ekB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (!TbadkCoreApplication.isLogin()) {
                                    bc.skipToLoginActivity(a.this.mContext);
                                    return;
                                }
                                a.this.a("prefer_key_history", a.this.ekF);
                                a.this.mContext.startActivity(new Intent(a.this.mContext, AlaRecentHistoryActivity.class));
                                TiebaStatic.log("c12648");
                            }
                        });
                        continue;
                    case 3:
                        this.ekG.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.ekI.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.ekJ.setVisibility(0);
                            this.ekJ.setText(functionListInfo.describe);
                        }
                        a(functionListInfo.id.intValue(), functionListInfo.update_time.longValue(), this.ekK);
                        this.ekG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                a.this.ah(3, functionListInfo.url);
                                a.this.a("prefer_key_activity", a.this.ekK);
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
        if (xI(str) < j) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, View view) {
        b.aFD().putLong(str, System.currentTimeMillis() / 1000);
        view.setVisibility(8);
    }

    private long xI(String str) {
        return b.aFD().getLong(str, 0L);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setBackgroundResource(this.ekx, R.color.cp_bg_line_d);
            am.setImageResource(this.ekz, R.drawable.live_portal_rank);
            am.setViewTextColor(this.eif, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.ekA, (int) R.color.cp_cont_d);
            am.setImageResource(this.ekC, R.drawable.live_import_history);
            am.setViewTextColor(this.ekD, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.ekE, (int) R.color.cp_cont_d);
            am.setImageResource(this.ekH, R.drawable.live_import_activity);
            am.setViewTextColor(this.ekI, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.ekJ, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.ekL, R.color.cp_bg_line_e);
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

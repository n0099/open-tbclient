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
    private TextView ehR;
    private LinearLayout ekj;
    private LinearLayout ekk;
    private ImageView ekl;
    private TextView ekm;
    private LinearLayout ekn;
    private ImageView eko;
    private TextView ekp;
    private TextView ekq;
    private View ekr;
    private LinearLayout eks;
    private ImageView ekt;
    private TextView eku;
    private TextView ekv;
    private View ekw;
    private View ekx;
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
        this.ekj = (LinearLayout) this.mRootView.findViewById(R.id.square_function_container);
        this.ekk = (LinearLayout) this.mRootView.findViewById(R.id.square_function_rank);
        this.ekk.setVisibility(8);
        this.ekl = (ImageView) this.mRootView.findViewById(R.id.square_function_rank_img);
        this.ehR = (TextView) this.mRootView.findViewById(R.id.square_function_rank_title);
        this.ekm = (TextView) this.mRootView.findViewById(R.id.square_function_rank_desc);
        this.ekn = (LinearLayout) this.mRootView.findViewById(R.id.square_function_history);
        this.ekn.setVisibility(8);
        this.eko = (ImageView) this.mRootView.findViewById(R.id.square_function_history_img);
        this.ekp = (TextView) this.mRootView.findViewById(R.id.square_function_history_title);
        this.ekq = (TextView) this.mRootView.findViewById(R.id.square_function_history_desc);
        this.ekr = this.mRootView.findViewById(R.id.square_function_history_red_pointer);
        this.eks = (LinearLayout) this.mRootView.findViewById(R.id.square_function_activity);
        this.eks.setVisibility(8);
        this.ekt = (ImageView) this.mRootView.findViewById(R.id.square_function_activity_img);
        this.eku = (TextView) this.mRootView.findViewById(R.id.square_function_activity_title);
        this.ekv = (TextView) this.mRootView.findViewById(R.id.square_function_activity_desc);
        this.ekw = this.mRootView.findViewById(R.id.square_function_activity_red_pointer);
        this.ekx = this.mRootView.findViewById(R.id.square_function_bottom_space);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void bf(List<FunctionListInfo> list) {
        this.mData = list;
        for (final FunctionListInfo functionListInfo : this.mData) {
            if (functionListInfo != null) {
                switch (functionListInfo.id.intValue()) {
                    case 1:
                        this.ekk.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.ehR.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.ekm.setVisibility(0);
                            this.ekm.setText(functionListInfo.describe);
                        }
                        this.ekk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                a.this.ah(1, functionListInfo.url);
                            }
                        });
                        continue;
                    case 2:
                        this.ekn.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.ekp.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.ekq.setVisibility(0);
                            this.ekq.setText(functionListInfo.describe);
                        }
                        a(functionListInfo.id.intValue(), functionListInfo.update_time.longValue(), this.ekr);
                        this.ekn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (!TbadkCoreApplication.isLogin()) {
                                    bc.skipToLoginActivity(a.this.mContext);
                                    return;
                                }
                                a.this.a("prefer_key_history", a.this.ekr);
                                a.this.mContext.startActivity(new Intent(a.this.mContext, AlaRecentHistoryActivity.class));
                                TiebaStatic.log("c12648");
                            }
                        });
                        continue;
                    case 3:
                        this.eks.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.eku.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.ekv.setVisibility(0);
                            this.ekv.setText(functionListInfo.describe);
                        }
                        a(functionListInfo.id.intValue(), functionListInfo.update_time.longValue(), this.ekw);
                        this.eks.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                a.this.ah(3, functionListInfo.url);
                                a.this.a("prefer_key_activity", a.this.ekw);
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
        if (xH(str) < j) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, View view) {
        b.aFB().putLong(str, System.currentTimeMillis() / 1000);
        view.setVisibility(8);
    }

    private long xH(String str) {
        return b.aFB().getLong(str, 0L);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setBackgroundResource(this.ekj, R.color.cp_bg_line_d);
            am.setImageResource(this.ekl, R.drawable.live_portal_rank);
            am.setViewTextColor(this.ehR, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.ekm, (int) R.color.cp_cont_d);
            am.setImageResource(this.eko, R.drawable.live_import_history);
            am.setViewTextColor(this.ekp, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.ekq, (int) R.color.cp_cont_d);
            am.setImageResource(this.ekt, R.drawable.live_import_activity);
            am.setViewTextColor(this.eku, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.ekv, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.ekx, R.color.cp_bg_line_e);
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

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
    private TextView eUZ;
    private LinearLayout fbk;
    private LinearLayout fbl;
    private ImageView fbm;
    private TextView fbn;
    private LinearLayout fbo;
    private ImageView fbp;
    private TextView fbq;
    private TextView fbr;
    private View fbs;
    private LinearLayout fbt;
    private ImageView fbu;
    private TextView fbv;
    private TextView fbw;
    private View fbx;
    private View fby;
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
        this.fbk = (LinearLayout) this.mRootView.findViewById(R.id.square_function_container);
        this.fbl = (LinearLayout) this.mRootView.findViewById(R.id.square_function_rank);
        this.fbl.setVisibility(8);
        this.fbm = (ImageView) this.mRootView.findViewById(R.id.square_function_rank_img);
        this.eUZ = (TextView) this.mRootView.findViewById(R.id.square_function_rank_title);
        this.fbn = (TextView) this.mRootView.findViewById(R.id.square_function_rank_desc);
        this.fbo = (LinearLayout) this.mRootView.findViewById(R.id.square_function_history);
        this.fbo.setVisibility(8);
        this.fbp = (ImageView) this.mRootView.findViewById(R.id.square_function_history_img);
        this.fbq = (TextView) this.mRootView.findViewById(R.id.square_function_history_title);
        this.fbr = (TextView) this.mRootView.findViewById(R.id.square_function_history_desc);
        this.fbs = this.mRootView.findViewById(R.id.square_function_history_red_pointer);
        this.fbt = (LinearLayout) this.mRootView.findViewById(R.id.square_function_activity);
        this.fbt.setVisibility(8);
        this.fbu = (ImageView) this.mRootView.findViewById(R.id.square_function_activity_img);
        this.fbv = (TextView) this.mRootView.findViewById(R.id.square_function_activity_title);
        this.fbw = (TextView) this.mRootView.findViewById(R.id.square_function_activity_desc);
        this.fbx = this.mRootView.findViewById(R.id.square_function_activity_red_pointer);
        this.fby = this.mRootView.findViewById(R.id.square_function_bottom_space);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void bk(List<FunctionListInfo> list) {
        this.mData = list;
        for (final FunctionListInfo functionListInfo : this.mData) {
            if (functionListInfo != null) {
                switch (functionListInfo.id.intValue()) {
                    case 1:
                        this.fbl.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.eUZ.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.fbn.setVisibility(0);
                            this.fbn.setText(functionListInfo.describe);
                        }
                        this.fbl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                a.this.aA(1, functionListInfo.url);
                            }
                        });
                        continue;
                    case 2:
                        this.fbo.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.fbq.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.fbr.setVisibility(0);
                            this.fbr.setText(functionListInfo.describe);
                        }
                        a(functionListInfo.id.intValue(), functionListInfo.update_time.longValue(), this.fbs);
                        this.fbo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (!TbadkCoreApplication.isLogin()) {
                                    bc.skipToLoginActivity(a.this.mContext);
                                    return;
                                }
                                a.this.a("prefer_key_history", a.this.fbs);
                                a.this.mContext.startActivity(new Intent(a.this.mContext, AlaRecentHistoryActivity.class));
                                TiebaStatic.log("c12648");
                            }
                        });
                        continue;
                    case 3:
                        this.fbt.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.fbv.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.fbw.setVisibility(0);
                            this.fbw.setText(functionListInfo.describe);
                        }
                        a(functionListInfo.id.intValue(), functionListInfo.update_time.longValue(), this.fbx);
                        this.fbt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                a.this.aA(3, functionListInfo.url);
                                a.this.a("prefer_key_activity", a.this.fbx);
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
        if (AV(str) < j) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, View view) {
        b.aTX().putLong(str, System.currentTimeMillis() / 1000);
        view.setVisibility(8);
    }

    private long AV(String str) {
        return b.aTX().getLong(str, 0L);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setBackgroundResource(this.fbk, R.color.cp_bg_line_d);
            am.setImageResource(this.fbm, R.drawable.live_portal_rank);
            am.setViewTextColor(this.eUZ, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.fbn, (int) R.color.cp_cont_d);
            am.setImageResource(this.fbp, R.drawable.live_import_history);
            am.setViewTextColor(this.fbq, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.fbr, (int) R.color.cp_cont_d);
            am.setImageResource(this.fbu, R.drawable.live_import_activity);
            am.setViewTextColor(this.fbv, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.fbw, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.fby, R.color.cp_bg_line_e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aA(int i, String str) {
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

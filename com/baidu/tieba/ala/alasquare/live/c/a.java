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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.recent_history.AlaRecentHistoryActivity;
import java.util.List;
import tbclient.LiveSquare.FunctionListInfo;
/* loaded from: classes6.dex */
public class a {
    private TextView ghg;
    private LinearLayout gqg;
    private LinearLayout gqh;
    private ImageView gqi;
    private TextView gqj;
    private LinearLayout gqk;
    private ImageView gql;
    private TextView gqm;
    private TextView gqn;
    private View gqo;
    private LinearLayout gqp;
    private ImageView gqq;
    private TextView gqr;
    private TextView gqs;
    private View gqt;
    private View gqu;
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
        this.gqg = (LinearLayout) this.mRootView.findViewById(R.id.square_function_container);
        this.gqh = (LinearLayout) this.mRootView.findViewById(R.id.square_function_rank);
        this.gqh.setVisibility(8);
        this.gqi = (ImageView) this.mRootView.findViewById(R.id.square_function_rank_img);
        this.ghg = (TextView) this.mRootView.findViewById(R.id.square_function_rank_title);
        this.gqj = (TextView) this.mRootView.findViewById(R.id.square_function_rank_desc);
        this.gqk = (LinearLayout) this.mRootView.findViewById(R.id.square_function_history);
        this.gqk.setVisibility(8);
        this.gql = (ImageView) this.mRootView.findViewById(R.id.square_function_history_img);
        this.gqm = (TextView) this.mRootView.findViewById(R.id.square_function_history_title);
        this.gqn = (TextView) this.mRootView.findViewById(R.id.square_function_history_desc);
        this.gqo = this.mRootView.findViewById(R.id.square_function_history_red_pointer);
        this.gqp = (LinearLayout) this.mRootView.findViewById(R.id.square_function_activity);
        this.gqp.setVisibility(8);
        this.gqq = (ImageView) this.mRootView.findViewById(R.id.square_function_activity_img);
        this.gqr = (TextView) this.mRootView.findViewById(R.id.square_function_activity_title);
        this.gqs = (TextView) this.mRootView.findViewById(R.id.square_function_activity_desc);
        this.gqt = this.mRootView.findViewById(R.id.square_function_activity_red_pointer);
        this.gqu = this.mRootView.findViewById(R.id.square_function_bottom_space);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void cb(List<FunctionListInfo> list) {
        this.mData = list;
        for (final FunctionListInfo functionListInfo : this.mData) {
            if (functionListInfo != null) {
                switch (functionListInfo.id.intValue()) {
                    case 1:
                        this.gqh.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.ghg.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.gqj.setVisibility(0);
                            this.gqj.setText(functionListInfo.describe);
                        }
                        this.gqh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                a.this.aQ(1, functionListInfo.url);
                            }
                        });
                        continue;
                    case 2:
                        this.gqk.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.gqm.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.gqn.setVisibility(0);
                            this.gqn.setText(functionListInfo.describe);
                        }
                        a(functionListInfo.id.intValue(), functionListInfo.update_time.longValue(), this.gqo);
                        this.gqk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (!TbadkCoreApplication.isLogin()) {
                                    bh.skipToLoginActivity(a.this.mContext);
                                    return;
                                }
                                a.this.a("prefer_key_history", a.this.gqo);
                                a.this.mContext.startActivity(new Intent(a.this.mContext, AlaRecentHistoryActivity.class));
                                TiebaStatic.log("c12648");
                            }
                        });
                        continue;
                    case 3:
                        this.gqp.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.gqr.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.gqs.setVisibility(0);
                            this.gqs.setText(functionListInfo.describe);
                        }
                        a(functionListInfo.id.intValue(), functionListInfo.update_time.longValue(), this.gqt);
                        this.gqp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                a.this.aQ(3, functionListInfo.url);
                                a.this.a("prefer_key_activity", a.this.gqt);
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
        if (GL(str) < j) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, View view) {
        b.bsO().putLong(str, System.currentTimeMillis() / 1000);
        view.setVisibility(8);
    }

    private long GL(String str) {
        return b.bsO().getLong(str, 0L);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setBackgroundResource(this.gqg, R.color.CAM_X0201);
            ap.setImageResource(this.gqi, R.drawable.live_portal_rank);
            ap.setViewTextColor(this.ghg, (int) R.color.CAM_X0105);
            ap.setViewTextColor(this.gqj, (int) R.color.CAM_X0109);
            ap.setImageResource(this.gql, R.drawable.live_import_history);
            ap.setViewTextColor(this.gqm, (int) R.color.CAM_X0105);
            ap.setViewTextColor(this.gqn, (int) R.color.CAM_X0109);
            ap.setImageResource(this.gqq, R.drawable.live_import_activity);
            ap.setViewTextColor(this.gqr, (int) R.color.CAM_X0105);
            ap.setViewTextColor(this.gqs, (int) R.color.CAM_X0109);
            ap.setBackgroundResource(this.gqu, R.color.CAM_X0205);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQ(int i, String str) {
        TiebaStatic.log(new ar("c12215"));
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

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
    private TextView ghi;
    private LinearLayout gqi;
    private LinearLayout gqj;
    private ImageView gqk;
    private TextView gql;
    private LinearLayout gqm;
    private ImageView gqn;
    private TextView gqo;
    private TextView gqp;
    private View gqq;
    private LinearLayout gqr;
    private ImageView gqs;
    private TextView gqt;
    private TextView gqu;
    private View gqv;
    private View gqw;
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
        this.gqi = (LinearLayout) this.mRootView.findViewById(R.id.square_function_container);
        this.gqj = (LinearLayout) this.mRootView.findViewById(R.id.square_function_rank);
        this.gqj.setVisibility(8);
        this.gqk = (ImageView) this.mRootView.findViewById(R.id.square_function_rank_img);
        this.ghi = (TextView) this.mRootView.findViewById(R.id.square_function_rank_title);
        this.gql = (TextView) this.mRootView.findViewById(R.id.square_function_rank_desc);
        this.gqm = (LinearLayout) this.mRootView.findViewById(R.id.square_function_history);
        this.gqm.setVisibility(8);
        this.gqn = (ImageView) this.mRootView.findViewById(R.id.square_function_history_img);
        this.gqo = (TextView) this.mRootView.findViewById(R.id.square_function_history_title);
        this.gqp = (TextView) this.mRootView.findViewById(R.id.square_function_history_desc);
        this.gqq = this.mRootView.findViewById(R.id.square_function_history_red_pointer);
        this.gqr = (LinearLayout) this.mRootView.findViewById(R.id.square_function_activity);
        this.gqr.setVisibility(8);
        this.gqs = (ImageView) this.mRootView.findViewById(R.id.square_function_activity_img);
        this.gqt = (TextView) this.mRootView.findViewById(R.id.square_function_activity_title);
        this.gqu = (TextView) this.mRootView.findViewById(R.id.square_function_activity_desc);
        this.gqv = this.mRootView.findViewById(R.id.square_function_activity_red_pointer);
        this.gqw = this.mRootView.findViewById(R.id.square_function_bottom_space);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void cb(List<FunctionListInfo> list) {
        this.mData = list;
        for (final FunctionListInfo functionListInfo : this.mData) {
            if (functionListInfo != null) {
                switch (functionListInfo.id.intValue()) {
                    case 1:
                        this.gqj.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.ghi.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.gql.setVisibility(0);
                            this.gql.setText(functionListInfo.describe);
                        }
                        this.gqj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                a.this.aQ(1, functionListInfo.url);
                            }
                        });
                        continue;
                    case 2:
                        this.gqm.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.gqo.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.gqp.setVisibility(0);
                            this.gqp.setText(functionListInfo.describe);
                        }
                        a(functionListInfo.id.intValue(), functionListInfo.update_time.longValue(), this.gqq);
                        this.gqm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (!TbadkCoreApplication.isLogin()) {
                                    bh.skipToLoginActivity(a.this.mContext);
                                    return;
                                }
                                a.this.a("prefer_key_history", a.this.gqq);
                                a.this.mContext.startActivity(new Intent(a.this.mContext, AlaRecentHistoryActivity.class));
                                TiebaStatic.log("c12648");
                            }
                        });
                        continue;
                    case 3:
                        this.gqr.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.gqt.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.gqu.setVisibility(0);
                            this.gqu.setText(functionListInfo.describe);
                        }
                        a(functionListInfo.id.intValue(), functionListInfo.update_time.longValue(), this.gqv);
                        this.gqr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                a.this.aQ(3, functionListInfo.url);
                                a.this.a("prefer_key_activity", a.this.gqv);
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
            ap.setBackgroundResource(this.gqi, R.color.CAM_X0201);
            ap.setImageResource(this.gqk, R.drawable.live_portal_rank);
            ap.setViewTextColor(this.ghi, (int) R.color.CAM_X0105);
            ap.setViewTextColor(this.gql, (int) R.color.CAM_X0109);
            ap.setImageResource(this.gqn, R.drawable.live_import_history);
            ap.setViewTextColor(this.gqo, (int) R.color.CAM_X0105);
            ap.setViewTextColor(this.gqp, (int) R.color.CAM_X0109);
            ap.setImageResource(this.gqs, R.drawable.live_import_activity);
            ap.setViewTextColor(this.gqt, (int) R.color.CAM_X0105);
            ap.setViewTextColor(this.gqu, (int) R.color.CAM_X0109);
            ap.setBackgroundResource(this.gqw, R.color.CAM_X0205);
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

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
/* loaded from: classes10.dex */
public class a {
    private TextView gpI;
    private LinearLayout gzk;
    private LinearLayout gzl;
    private ImageView gzm;
    private TextView gzn;
    private LinearLayout gzo;
    private ImageView gzp;
    private TextView gzq;
    private TextView gzr;
    private View gzs;
    private LinearLayout gzt;
    private ImageView gzu;
    private TextView gzv;
    private TextView gzw;
    private View gzx;
    private View gzy;
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
        this.gzk = (LinearLayout) this.mRootView.findViewById(R.id.square_function_container);
        this.gzl = (LinearLayout) this.mRootView.findViewById(R.id.square_function_rank);
        this.gzl.setVisibility(8);
        this.gzm = (ImageView) this.mRootView.findViewById(R.id.square_function_rank_img);
        this.gpI = (TextView) this.mRootView.findViewById(R.id.square_function_rank_title);
        this.gzn = (TextView) this.mRootView.findViewById(R.id.square_function_rank_desc);
        this.gzo = (LinearLayout) this.mRootView.findViewById(R.id.square_function_history);
        this.gzo.setVisibility(8);
        this.gzp = (ImageView) this.mRootView.findViewById(R.id.square_function_history_img);
        this.gzq = (TextView) this.mRootView.findViewById(R.id.square_function_history_title);
        this.gzr = (TextView) this.mRootView.findViewById(R.id.square_function_history_desc);
        this.gzs = this.mRootView.findViewById(R.id.square_function_history_red_pointer);
        this.gzt = (LinearLayout) this.mRootView.findViewById(R.id.square_function_activity);
        this.gzt.setVisibility(8);
        this.gzu = (ImageView) this.mRootView.findViewById(R.id.square_function_activity_img);
        this.gzv = (TextView) this.mRootView.findViewById(R.id.square_function_activity_title);
        this.gzw = (TextView) this.mRootView.findViewById(R.id.square_function_activity_desc);
        this.gzx = this.mRootView.findViewById(R.id.square_function_activity_red_pointer);
        this.gzy = this.mRootView.findViewById(R.id.square_function_bottom_space);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void cd(List<FunctionListInfo> list) {
        this.mData = list;
        for (final FunctionListInfo functionListInfo : this.mData) {
            if (functionListInfo != null) {
                switch (functionListInfo.id.intValue()) {
                    case 1:
                        this.gzl.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.gpI.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.gzn.setVisibility(0);
                            this.gzn.setText(functionListInfo.describe);
                        }
                        this.gzl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                a.this.aY(1, functionListInfo.url);
                            }
                        });
                        continue;
                    case 2:
                        this.gzo.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.gzq.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.gzr.setVisibility(0);
                            this.gzr.setText(functionListInfo.describe);
                        }
                        a(functionListInfo.id.intValue(), functionListInfo.update_time.longValue(), this.gzs);
                        this.gzo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (!TbadkCoreApplication.isLogin()) {
                                    bh.skipToLoginActivity(a.this.mContext);
                                    return;
                                }
                                a.this.a("prefer_key_history", a.this.gzs);
                                a.this.mContext.startActivity(new Intent(a.this.mContext, AlaRecentHistoryActivity.class));
                                TiebaStatic.log("c12648");
                            }
                        });
                        continue;
                    case 3:
                        this.gzt.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.gzv.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.gzw.setVisibility(0);
                            this.gzw.setText(functionListInfo.describe);
                        }
                        a(functionListInfo.id.intValue(), functionListInfo.update_time.longValue(), this.gzx);
                        this.gzt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                a.this.aY(3, functionListInfo.url);
                                a.this.a("prefer_key_activity", a.this.gzx);
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
        if (FV(str) < j) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, View view) {
        b.brQ().putLong(str, System.currentTimeMillis() / 1000);
        view.setVisibility(8);
    }

    private long FV(String str) {
        return b.brQ().getLong(str, 0L);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setBackgroundResource(this.gzk, R.color.CAM_X0201);
            ap.setImageResource(this.gzm, R.drawable.live_portal_rank);
            ap.setViewTextColor(this.gpI, R.color.CAM_X0105);
            ap.setViewTextColor(this.gzn, R.color.CAM_X0109);
            ap.setImageResource(this.gzp, R.drawable.live_import_history);
            ap.setViewTextColor(this.gzq, R.color.CAM_X0105);
            ap.setViewTextColor(this.gzr, R.color.CAM_X0109);
            ap.setImageResource(this.gzu, R.drawable.live_import_activity);
            ap.setViewTextColor(this.gzv, R.color.CAM_X0105);
            ap.setViewTextColor(this.gzw, R.color.CAM_X0109);
            ap.setBackgroundResource(this.gzy, R.color.CAM_X0205);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY(int i, String str) {
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

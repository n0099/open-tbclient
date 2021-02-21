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
    private TextView gpW;
    private ImageView gzA;
    private TextView gzB;
    private LinearLayout gzC;
    private ImageView gzD;
    private TextView gzE;
    private TextView gzF;
    private View gzG;
    private LinearLayout gzH;
    private ImageView gzI;
    private TextView gzJ;
    private TextView gzK;
    private View gzL;
    private View gzM;
    private LinearLayout gzy;
    private LinearLayout gzz;
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
        this.gzy = (LinearLayout) this.mRootView.findViewById(R.id.square_function_container);
        this.gzz = (LinearLayout) this.mRootView.findViewById(R.id.square_function_rank);
        this.gzz.setVisibility(8);
        this.gzA = (ImageView) this.mRootView.findViewById(R.id.square_function_rank_img);
        this.gpW = (TextView) this.mRootView.findViewById(R.id.square_function_rank_title);
        this.gzB = (TextView) this.mRootView.findViewById(R.id.square_function_rank_desc);
        this.gzC = (LinearLayout) this.mRootView.findViewById(R.id.square_function_history);
        this.gzC.setVisibility(8);
        this.gzD = (ImageView) this.mRootView.findViewById(R.id.square_function_history_img);
        this.gzE = (TextView) this.mRootView.findViewById(R.id.square_function_history_title);
        this.gzF = (TextView) this.mRootView.findViewById(R.id.square_function_history_desc);
        this.gzG = this.mRootView.findViewById(R.id.square_function_history_red_pointer);
        this.gzH = (LinearLayout) this.mRootView.findViewById(R.id.square_function_activity);
        this.gzH.setVisibility(8);
        this.gzI = (ImageView) this.mRootView.findViewById(R.id.square_function_activity_img);
        this.gzJ = (TextView) this.mRootView.findViewById(R.id.square_function_activity_title);
        this.gzK = (TextView) this.mRootView.findViewById(R.id.square_function_activity_desc);
        this.gzL = this.mRootView.findViewById(R.id.square_function_activity_red_pointer);
        this.gzM = this.mRootView.findViewById(R.id.square_function_bottom_space);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void cd(List<FunctionListInfo> list) {
        this.mData = list;
        for (final FunctionListInfo functionListInfo : this.mData) {
            if (functionListInfo != null) {
                switch (functionListInfo.id.intValue()) {
                    case 1:
                        this.gzz.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.gpW.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.gzB.setVisibility(0);
                            this.gzB.setText(functionListInfo.describe);
                        }
                        this.gzz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                a.this.aY(1, functionListInfo.url);
                            }
                        });
                        continue;
                    case 2:
                        this.gzC.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.gzE.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.gzF.setVisibility(0);
                            this.gzF.setText(functionListInfo.describe);
                        }
                        a(functionListInfo.id.intValue(), functionListInfo.update_time.longValue(), this.gzG);
                        this.gzC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (!TbadkCoreApplication.isLogin()) {
                                    bh.skipToLoginActivity(a.this.mContext);
                                    return;
                                }
                                a.this.a("prefer_key_history", a.this.gzG);
                                a.this.mContext.startActivity(new Intent(a.this.mContext, AlaRecentHistoryActivity.class));
                                TiebaStatic.log("c12648");
                            }
                        });
                        continue;
                    case 3:
                        this.gzH.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.gzJ.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.gzK.setVisibility(0);
                            this.gzK.setText(functionListInfo.describe);
                        }
                        a(functionListInfo.id.intValue(), functionListInfo.update_time.longValue(), this.gzL);
                        this.gzH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                a.this.aY(3, functionListInfo.url);
                                a.this.a("prefer_key_activity", a.this.gzL);
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
        if (FW(str) < j) {
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

    private long FW(String str) {
        return b.brQ().getLong(str, 0L);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setBackgroundResource(this.gzy, R.color.CAM_X0201);
            ap.setImageResource(this.gzA, R.drawable.live_portal_rank);
            ap.setViewTextColor(this.gpW, R.color.CAM_X0105);
            ap.setViewTextColor(this.gzB, R.color.CAM_X0109);
            ap.setImageResource(this.gzD, R.drawable.live_import_history);
            ap.setViewTextColor(this.gzE, R.color.CAM_X0105);
            ap.setViewTextColor(this.gzF, R.color.CAM_X0109);
            ap.setImageResource(this.gzI, R.drawable.live_import_activity);
            ap.setViewTextColor(this.gzJ, R.color.CAM_X0105);
            ap.setViewTextColor(this.gzK, R.color.CAM_X0109);
            ap.setBackgroundResource(this.gzM, R.color.CAM_X0205);
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

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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.recent_history.AlaRecentHistoryActivity;
import java.util.List;
import tbclient.LiveSquare.FunctionListInfo;
/* loaded from: classes9.dex */
public class a {
    private TextView gmZ;
    private LinearLayout gwA;
    private LinearLayout gwB;
    private ImageView gwC;
    private TextView gwD;
    private LinearLayout gwE;
    private ImageView gwF;
    private TextView gwG;
    private TextView gwH;
    private View gwI;
    private LinearLayout gwJ;
    private ImageView gwK;
    private TextView gwL;
    private TextView gwM;
    private View gwN;
    private View gwO;
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
        this.gwA = (LinearLayout) this.mRootView.findViewById(R.id.square_function_container);
        this.gwB = (LinearLayout) this.mRootView.findViewById(R.id.square_function_rank);
        this.gwB.setVisibility(8);
        this.gwC = (ImageView) this.mRootView.findViewById(R.id.square_function_rank_img);
        this.gmZ = (TextView) this.mRootView.findViewById(R.id.square_function_rank_title);
        this.gwD = (TextView) this.mRootView.findViewById(R.id.square_function_rank_desc);
        this.gwE = (LinearLayout) this.mRootView.findViewById(R.id.square_function_history);
        this.gwE.setVisibility(8);
        this.gwF = (ImageView) this.mRootView.findViewById(R.id.square_function_history_img);
        this.gwG = (TextView) this.mRootView.findViewById(R.id.square_function_history_title);
        this.gwH = (TextView) this.mRootView.findViewById(R.id.square_function_history_desc);
        this.gwI = this.mRootView.findViewById(R.id.square_function_history_red_pointer);
        this.gwJ = (LinearLayout) this.mRootView.findViewById(R.id.square_function_activity);
        this.gwJ.setVisibility(8);
        this.gwK = (ImageView) this.mRootView.findViewById(R.id.square_function_activity_img);
        this.gwL = (TextView) this.mRootView.findViewById(R.id.square_function_activity_title);
        this.gwM = (TextView) this.mRootView.findViewById(R.id.square_function_activity_desc);
        this.gwN = this.mRootView.findViewById(R.id.square_function_activity_red_pointer);
        this.gwO = this.mRootView.findViewById(R.id.square_function_bottom_space);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void ci(List<FunctionListInfo> list) {
        this.mData = list;
        for (final FunctionListInfo functionListInfo : this.mData) {
            if (functionListInfo != null) {
                switch (functionListInfo.id.intValue()) {
                    case 1:
                        this.gwB.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.gmZ.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.gwD.setVisibility(0);
                            this.gwD.setText(functionListInfo.describe);
                        }
                        this.gwB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                a.this.aT(1, functionListInfo.url);
                            }
                        });
                        continue;
                    case 2:
                        this.gwE.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.gwG.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.gwH.setVisibility(0);
                            this.gwH.setText(functionListInfo.describe);
                        }
                        a(functionListInfo.id.intValue(), functionListInfo.update_time.longValue(), this.gwI);
                        this.gwE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (!TbadkCoreApplication.isLogin()) {
                                    bg.skipToLoginActivity(a.this.mContext);
                                    return;
                                }
                                a.this.a("prefer_key_history", a.this.gwI);
                                a.this.mContext.startActivity(new Intent(a.this.mContext, AlaRecentHistoryActivity.class));
                                TiebaStatic.log("c12648");
                            }
                        });
                        continue;
                    case 3:
                        this.gwJ.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.gwL.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.gwM.setVisibility(0);
                            this.gwM.setText(functionListInfo.describe);
                        }
                        a(functionListInfo.id.intValue(), functionListInfo.update_time.longValue(), this.gwN);
                        this.gwJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                a.this.aT(3, functionListInfo.url);
                                a.this.a("prefer_key_activity", a.this.gwN);
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
        if (Fx(str) < j) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, View view) {
        b.brx().putLong(str, System.currentTimeMillis() / 1000);
        view.setVisibility(8);
    }

    private long Fx(String str) {
        return b.brx().getLong(str, 0L);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ao.setBackgroundResource(this.gwA, R.color.CAM_X0201);
            ao.setImageResource(this.gwC, R.drawable.live_portal_rank);
            ao.setViewTextColor(this.gmZ, R.color.CAM_X0105);
            ao.setViewTextColor(this.gwD, R.color.CAM_X0109);
            ao.setImageResource(this.gwF, R.drawable.live_import_history);
            ao.setViewTextColor(this.gwG, R.color.CAM_X0105);
            ao.setViewTextColor(this.gwH, R.color.CAM_X0109);
            ao.setImageResource(this.gwK, R.drawable.live_import_activity);
            ao.setViewTextColor(this.gwL, R.color.CAM_X0105);
            ao.setViewTextColor(this.gwM, R.color.CAM_X0109);
            ao.setBackgroundResource(this.gwO, R.color.CAM_X0205);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aT(int i, String str) {
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

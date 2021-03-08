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
/* loaded from: classes9.dex */
public class a {
    private LinearLayout gBh;
    private LinearLayout gBi;
    private ImageView gBj;
    private TextView gBk;
    private LinearLayout gBl;
    private ImageView gBm;
    private TextView gBn;
    private TextView gBo;
    private View gBp;
    private LinearLayout gBq;
    private ImageView gBr;
    private TextView gBs;
    private TextView gBt;
    private View gBu;
    private View gBv;
    private TextView grF;
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
        this.gBh = (LinearLayout) this.mRootView.findViewById(R.id.square_function_container);
        this.gBi = (LinearLayout) this.mRootView.findViewById(R.id.square_function_rank);
        this.gBi.setVisibility(8);
        this.gBj = (ImageView) this.mRootView.findViewById(R.id.square_function_rank_img);
        this.grF = (TextView) this.mRootView.findViewById(R.id.square_function_rank_title);
        this.gBk = (TextView) this.mRootView.findViewById(R.id.square_function_rank_desc);
        this.gBl = (LinearLayout) this.mRootView.findViewById(R.id.square_function_history);
        this.gBl.setVisibility(8);
        this.gBm = (ImageView) this.mRootView.findViewById(R.id.square_function_history_img);
        this.gBn = (TextView) this.mRootView.findViewById(R.id.square_function_history_title);
        this.gBo = (TextView) this.mRootView.findViewById(R.id.square_function_history_desc);
        this.gBp = this.mRootView.findViewById(R.id.square_function_history_red_pointer);
        this.gBq = (LinearLayout) this.mRootView.findViewById(R.id.square_function_activity);
        this.gBq.setVisibility(8);
        this.gBr = (ImageView) this.mRootView.findViewById(R.id.square_function_activity_img);
        this.gBs = (TextView) this.mRootView.findViewById(R.id.square_function_activity_title);
        this.gBt = (TextView) this.mRootView.findViewById(R.id.square_function_activity_desc);
        this.gBu = this.mRootView.findViewById(R.id.square_function_activity_red_pointer);
        this.gBv = this.mRootView.findViewById(R.id.square_function_bottom_space);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void cd(List<FunctionListInfo> list) {
        this.mData = list;
        for (final FunctionListInfo functionListInfo : this.mData) {
            if (functionListInfo != null) {
                switch (functionListInfo.id.intValue()) {
                    case 1:
                        this.gBi.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.grF.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.gBk.setVisibility(0);
                            this.gBk.setText(functionListInfo.describe);
                        }
                        this.gBi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                a.this.aY(1, functionListInfo.url);
                            }
                        });
                        continue;
                    case 2:
                        this.gBl.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.gBn.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.gBo.setVisibility(0);
                            this.gBo.setText(functionListInfo.describe);
                        }
                        a(functionListInfo.id.intValue(), functionListInfo.update_time.longValue(), this.gBp);
                        this.gBl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (!TbadkCoreApplication.isLogin()) {
                                    bh.skipToLoginActivity(a.this.mContext);
                                    return;
                                }
                                a.this.a("prefer_key_history", a.this.gBp);
                                a.this.mContext.startActivity(new Intent(a.this.mContext, AlaRecentHistoryActivity.class));
                                TiebaStatic.log("c12648");
                            }
                        });
                        continue;
                    case 3:
                        this.gBq.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.gBs.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.gBt.setVisibility(0);
                            this.gBt.setText(functionListInfo.describe);
                        }
                        a(functionListInfo.id.intValue(), functionListInfo.update_time.longValue(), this.gBu);
                        this.gBq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                a.this.aY(3, functionListInfo.url);
                                a.this.a("prefer_key_activity", a.this.gBu);
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
        if (Gf(str) < j) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, View view) {
        b.brR().putLong(str, System.currentTimeMillis() / 1000);
        view.setVisibility(8);
    }

    private long Gf(String str) {
        return b.brR().getLong(str, 0L);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setBackgroundResource(this.gBh, R.color.CAM_X0201);
            ap.setImageResource(this.gBj, R.drawable.live_portal_rank);
            ap.setViewTextColor(this.grF, R.color.CAM_X0105);
            ap.setViewTextColor(this.gBk, R.color.CAM_X0109);
            ap.setImageResource(this.gBm, R.drawable.live_import_history);
            ap.setViewTextColor(this.gBn, R.color.CAM_X0105);
            ap.setViewTextColor(this.gBo, R.color.CAM_X0109);
            ap.setImageResource(this.gBr, R.drawable.live_import_activity);
            ap.setViewTextColor(this.gBs, R.color.CAM_X0105);
            ap.setViewTextColor(this.gBt, R.color.CAM_X0109);
            ap.setBackgroundResource(this.gBv, R.color.CAM_X0205);
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

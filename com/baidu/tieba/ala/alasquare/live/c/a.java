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
/* loaded from: classes4.dex */
public class a {
    private TextView fYV;
    private LinearLayout ghW;
    private LinearLayout ghX;
    private ImageView ghY;
    private TextView ghZ;
    private LinearLayout gia;
    private ImageView gib;
    private TextView gic;
    private TextView gie;
    private View gif;
    private LinearLayout gig;
    private ImageView gih;
    private TextView gii;
    private TextView gij;
    private View gik;
    private View gil;
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
        this.ghW = (LinearLayout) this.mRootView.findViewById(R.id.square_function_container);
        this.ghX = (LinearLayout) this.mRootView.findViewById(R.id.square_function_rank);
        this.ghX.setVisibility(8);
        this.ghY = (ImageView) this.mRootView.findViewById(R.id.square_function_rank_img);
        this.fYV = (TextView) this.mRootView.findViewById(R.id.square_function_rank_title);
        this.ghZ = (TextView) this.mRootView.findViewById(R.id.square_function_rank_desc);
        this.gia = (LinearLayout) this.mRootView.findViewById(R.id.square_function_history);
        this.gia.setVisibility(8);
        this.gib = (ImageView) this.mRootView.findViewById(R.id.square_function_history_img);
        this.gic = (TextView) this.mRootView.findViewById(R.id.square_function_history_title);
        this.gie = (TextView) this.mRootView.findViewById(R.id.square_function_history_desc);
        this.gif = this.mRootView.findViewById(R.id.square_function_history_red_pointer);
        this.gig = (LinearLayout) this.mRootView.findViewById(R.id.square_function_activity);
        this.gig.setVisibility(8);
        this.gih = (ImageView) this.mRootView.findViewById(R.id.square_function_activity_img);
        this.gii = (TextView) this.mRootView.findViewById(R.id.square_function_activity_title);
        this.gij = (TextView) this.mRootView.findViewById(R.id.square_function_activity_desc);
        this.gik = this.mRootView.findViewById(R.id.square_function_activity_red_pointer);
        this.gil = this.mRootView.findViewById(R.id.square_function_bottom_space);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void bX(List<FunctionListInfo> list) {
        this.mData = list;
        for (final FunctionListInfo functionListInfo : this.mData) {
            if (functionListInfo != null) {
                switch (functionListInfo.id.intValue()) {
                    case 1:
                        this.ghX.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.fYV.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.ghZ.setVisibility(0);
                            this.ghZ.setText(functionListInfo.describe);
                        }
                        this.ghX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                a.this.aQ(1, functionListInfo.url);
                            }
                        });
                        continue;
                    case 2:
                        this.gia.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.gic.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.gie.setVisibility(0);
                            this.gie.setText(functionListInfo.describe);
                        }
                        a(functionListInfo.id.intValue(), functionListInfo.update_time.longValue(), this.gif);
                        this.gia.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (!TbadkCoreApplication.isLogin()) {
                                    bh.skipToLoginActivity(a.this.mContext);
                                    return;
                                }
                                a.this.a("prefer_key_history", a.this.gif);
                                a.this.mContext.startActivity(new Intent(a.this.mContext, AlaRecentHistoryActivity.class));
                                TiebaStatic.log("c12648");
                            }
                        });
                        continue;
                    case 3:
                        this.gig.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.gii.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.gij.setVisibility(0);
                            this.gij.setText(functionListInfo.describe);
                        }
                        a(functionListInfo.id.intValue(), functionListInfo.update_time.longValue(), this.gik);
                        this.gig.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                a.this.aQ(3, functionListInfo.url);
                                a.this.a("prefer_key_activity", a.this.gik);
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
        if (FX(str) < j) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, View view) {
        b.bpu().putLong(str, System.currentTimeMillis() / 1000);
        view.setVisibility(8);
    }

    private long FX(String str) {
        return b.bpu().getLong(str, 0L);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setBackgroundResource(this.ghW, R.color.CAM_X0201);
            ap.setImageResource(this.ghY, R.drawable.live_portal_rank);
            ap.setViewTextColor(this.fYV, R.color.CAM_X0105);
            ap.setViewTextColor(this.ghZ, R.color.CAM_X0109);
            ap.setImageResource(this.gib, R.drawable.live_import_history);
            ap.setViewTextColor(this.gic, R.color.CAM_X0105);
            ap.setViewTextColor(this.gie, R.color.CAM_X0109);
            ap.setImageResource(this.gih, R.drawable.live_import_activity);
            ap.setViewTextColor(this.gii, R.color.CAM_X0105);
            ap.setViewTextColor(this.gij, R.color.CAM_X0109);
            ap.setBackgroundResource(this.gil, R.color.CAM_X0205);
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

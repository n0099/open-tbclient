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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.recent_history.AlaRecentHistoryActivity;
import java.util.List;
import tbclient.LiveSquare.FunctionListInfo;
/* loaded from: classes4.dex */
public class a {
    private TextView fZo;
    private ImageView giA;
    private TextView giB;
    private TextView giC;
    private View giD;
    private View giE;
    private LinearLayout giq;
    private LinearLayout gir;
    private ImageView gis;
    private TextView git;
    private LinearLayout giu;
    private ImageView giv;
    private TextView giw;
    private TextView gix;
    private View giy;
    private LinearLayout giz;
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
        this.giq = (LinearLayout) this.mRootView.findViewById(R.id.square_function_container);
        this.gir = (LinearLayout) this.mRootView.findViewById(R.id.square_function_rank);
        this.gir.setVisibility(8);
        this.gis = (ImageView) this.mRootView.findViewById(R.id.square_function_rank_img);
        this.fZo = (TextView) this.mRootView.findViewById(R.id.square_function_rank_title);
        this.git = (TextView) this.mRootView.findViewById(R.id.square_function_rank_desc);
        this.giu = (LinearLayout) this.mRootView.findViewById(R.id.square_function_history);
        this.giu.setVisibility(8);
        this.giv = (ImageView) this.mRootView.findViewById(R.id.square_function_history_img);
        this.giw = (TextView) this.mRootView.findViewById(R.id.square_function_history_title);
        this.gix = (TextView) this.mRootView.findViewById(R.id.square_function_history_desc);
        this.giy = this.mRootView.findViewById(R.id.square_function_history_red_pointer);
        this.giz = (LinearLayout) this.mRootView.findViewById(R.id.square_function_activity);
        this.giz.setVisibility(8);
        this.giA = (ImageView) this.mRootView.findViewById(R.id.square_function_activity_img);
        this.giB = (TextView) this.mRootView.findViewById(R.id.square_function_activity_title);
        this.giC = (TextView) this.mRootView.findViewById(R.id.square_function_activity_desc);
        this.giD = this.mRootView.findViewById(R.id.square_function_activity_red_pointer);
        this.giE = this.mRootView.findViewById(R.id.square_function_bottom_space);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void bX(List<FunctionListInfo> list) {
        this.mData = list;
        for (final FunctionListInfo functionListInfo : this.mData) {
            if (functionListInfo != null) {
                switch (functionListInfo.id.intValue()) {
                    case 1:
                        this.gir.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.fZo.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.git.setVisibility(0);
                            this.git.setText(functionListInfo.describe);
                        }
                        this.gir.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                a.this.aS(1, functionListInfo.url);
                            }
                        });
                        continue;
                    case 2:
                        this.giu.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.giw.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.gix.setVisibility(0);
                            this.gix.setText(functionListInfo.describe);
                        }
                        a(functionListInfo.id.intValue(), functionListInfo.update_time.longValue(), this.giy);
                        this.giu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (!TbadkCoreApplication.isLogin()) {
                                    bg.skipToLoginActivity(a.this.mContext);
                                    return;
                                }
                                a.this.a("prefer_key_history", a.this.giy);
                                a.this.mContext.startActivity(new Intent(a.this.mContext, AlaRecentHistoryActivity.class));
                                TiebaStatic.log("c12648");
                            }
                        });
                        continue;
                    case 3:
                        this.giz.setVisibility(0);
                        if (!TextUtils.isEmpty(functionListInfo.title)) {
                            this.giB.setText(functionListInfo.title);
                        }
                        if (!TextUtils.isEmpty(functionListInfo.describe)) {
                            this.giC.setVisibility(0);
                            this.giC.setText(functionListInfo.describe);
                        }
                        a(functionListInfo.id.intValue(), functionListInfo.update_time.longValue(), this.giD);
                        this.giz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.c.a.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                a.this.aS(3, functionListInfo.url);
                                a.this.a("prefer_key_activity", a.this.giD);
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
        if (Gw(str) < j) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, View view) {
        b.bqh().putLong(str, System.currentTimeMillis() / 1000);
        view.setVisibility(8);
    }

    private long Gw(String str) {
        return b.bqh().getLong(str, 0L);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setBackgroundResource(this.giq, R.color.cp_bg_line_d);
            ap.setImageResource(this.gis, R.drawable.live_portal_rank);
            ap.setViewTextColor(this.fZo, (int) R.color.cp_cont_b);
            ap.setViewTextColor(this.git, (int) R.color.cp_cont_d);
            ap.setImageResource(this.giv, R.drawable.live_import_history);
            ap.setViewTextColor(this.giw, (int) R.color.cp_cont_b);
            ap.setViewTextColor(this.gix, (int) R.color.cp_cont_d);
            ap.setImageResource(this.giA, R.drawable.live_import_activity);
            ap.setViewTextColor(this.giB, (int) R.color.cp_cont_b);
            ap.setViewTextColor(this.giC, (int) R.color.cp_cont_d);
            ap.setBackgroundResource(this.giE, R.color.cp_bg_line_e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aS(int i, String str) {
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

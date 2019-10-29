package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.t.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class NestedScrollHeader extends RelativeLayout {
    private CustomMessageListener bRR;
    View.OnClickListener fZy;
    CustomMessageListener ffM;
    private TbImageView ghg;
    private TextView ghh;
    private a ghi;
    private Bitmap ghj;
    private View view;

    /* loaded from: classes4.dex */
    public interface a {
        void wW(String str);
    }

    public NestedScrollHeader(@NonNull Context context) {
        this(context, null);
    }

    public NestedScrollHeader(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollHeader(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fZy = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NestedScrollHeader.this.ghg == view) {
                    Object tag = NestedScrollHeader.this.ghg.getTag(R.id.homepage_mission_entrance_url);
                    if (tag instanceof String) {
                        String str = (String) tag;
                        if (!TextUtils.isEmpty(str)) {
                            if (NestedScrollHeader.this.ghi != null) {
                                NestedScrollHeader.this.ghi.wW(str);
                            }
                            NestedScrollHeader.this.btC();
                        }
                    }
                } else if (NestedScrollHeader.this.ghh == view) {
                    TiebaStatic.log(new an(CommonStatisticKey.SEARCH_BAR_CLICK).O("obj_type", 1));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new SquareSearchActivityConfig(NestedScrollHeader.this.getContext(), "", false)));
                }
            }
        };
        this.ffM = new CustomMessageListener(2921396) { // from class: com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                NestedScrollHeader.this.setSearchHint(TbSingleton.getInstance().getHotSearch());
            }
        };
        this.bRR = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && NestedScrollHeader.this.ghg.getVisibility() == 0) {
                    NestedScrollHeader.this.btB();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_presenlize_scroll_header, (ViewGroup) this, true);
        this.ghg = (TbImageView) findViewById(R.id.task);
        this.ghg.setOnClickListener(this.fZy);
        this.ghh = (TextView) findViewById(R.id.search);
        this.ghh.setOnClickListener(this.fZy);
        this.view = findViewById(R.id.view);
        onChangeSkinType();
        MessageManager.getInstance().registerListener(this.ffM);
        MessageManager.getInstance().registerListener(this.bRR);
        if (ao.isOn()) {
            this.ghg.setVisibility(0);
            btB();
            return;
        }
        this.ghg.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btB() {
        final String missionEntranceUrl = TbSingleton.getInstance().getMissionEntranceUrl();
        String missionEntranceIcon = TbSingleton.getInstance().getMissionEntranceIcon();
        if (TextUtils.isEmpty(missionEntranceUrl) || TextUtils.isEmpty(missionEntranceIcon)) {
            this.ghj = null;
            this.ghg.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
            this.ghg.setImageResource(R.drawable.btn_home_task_n);
            return;
        }
        com.baidu.adp.lib.f.c.fT().a(missionEntranceIcon, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null || aVar.getRawBitmap() == null || aVar.getRawBitmap().isRecycled()) {
                    NestedScrollHeader.this.ghj = null;
                    NestedScrollHeader.this.ghg.setImageResource(R.drawable.btn_home_task_n);
                    NestedScrollHeader.this.ghg.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
                    return;
                }
                NestedScrollHeader.this.ghj = aVar.getRawBitmap();
                NestedScrollHeader.this.ghg.setImageBitmap(NestedScrollHeader.this.ghj);
                NestedScrollHeader.this.ghg.setTag(R.id.homepage_mission_entrance_url, missionEntranceUrl);
                NestedScrollHeader.this.ghg.invalidate();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onProgressUpdate(Object... objArr) {
                super.onProgressUpdate(objArr);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
            }
        }, null);
    }

    public void setEntranceJumpListener(a aVar) {
        this.ghi = aVar;
    }

    public void setSearchHint(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.ghh.setText(str);
        }
    }

    public void am(float f) {
        if (f >= 0.0f && f <= 1.0f) {
            if (this.ghg.getVisibility() == 0 && this.ghg.getAlpha() != f) {
                this.ghg.setAlpha(f);
            }
            if (this.ghh.getAlpha() != f) {
                this.ghh.setAlpha(f);
            }
        }
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this, R.color.cp_bg_line_h);
        am.setViewTextColor(this.ghh, (int) R.color.cp_cont_d);
        am.setBackgroundResource(this.ghh, R.drawable.task_scroll_search_bg);
        am.setBackgroundColor(this.view, R.color.cp_bg_line_h);
        this.ghh.setCompoundDrawablesWithIntrinsicBounds(SvgManager.amN().a(R.drawable.icon_pure_search_import_n_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.ghj == null) {
            am.setImageResource(this.ghg, R.drawable.btn_home_task_n);
        } else if (this.ghg != null) {
            this.ghg.setImageBitmap(this.ghj);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.ffM);
        MessageManager.getInstance().registerListener(this.bRR);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.ffM);
        MessageManager.getInstance().unRegisterListener(this.bRR);
    }

    public ImageView getTaskView() {
        return this.ghg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btC() {
        an anVar = new an("c13422");
        anVar.O("obj_type", 2);
        anVar.O("obj_locate", 1);
        anVar.O(TiebaInitialize.Params.AB_TAG, TbSingleton.getInstance().getHomePageStyleAbTest());
        TiebaStatic.log(anVar);
    }
}
